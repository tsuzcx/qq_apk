package com.tencent.mobileqq.service;

import android.os.Bundle;
import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public abstract class MobileQQServiceBase
{
  public static final String REQ_PB_PROTOCOL_FLAG = "req_pb_protocol_flag";
  public static final String SERVICE_ID = "mobileqq.service";
  public static final String TAG = "MobileQQServiceBase";
  private static final String TIME_KEY = "sendtimekey";
  public static volatile int seq = 0;
  protected ConcurrentHashMap<String, BaseProtocolCoder> coderMap = new ConcurrentHashMap();
  private volatile boolean isDoCoderInit = false;
  
  protected boolean addCoder(BaseProtocolCoder paramBaseProtocolCoder)
  {
    int i = 0;
    String[] arrayOfString = paramBaseProtocolCoder.cmdHeaderPrefix();
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return false;
    }
    while (i < arrayOfString.length)
    {
      this.coderMap.put(arrayOfString[i], paramBaseProtocolCoder);
      i += 1;
    }
    return true;
  }
  
  public void destroy()
  {
    destroyCoder();
  }
  
  protected void destroyCoder()
  {
    if (this.coderMap != null)
    {
      Iterator localIterator = this.coderMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (BaseProtocolCoder)this.coderMap.get(localObject);
        if (localObject != null)
        {
          try
          {
            ((BaseProtocolCoder)localObject).destroy();
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQServiceBase", 2, "bpc destroy error " + localException, localException);
          }
        }
      }
      this.coderMap.clear();
    }
    this.isDoCoderInit = false;
  }
  
  public void dispatchToHandler(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AppInterface localAppInterface = getAppInterface();
    Object localObject = Cmd2HandlerMapHelper.a(paramFromServiceMsg.getServiceCmd());
    if ((localObject == null) || (((Set)localObject).isEmpty())) {}
    for (;;)
    {
      return;
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessHandler localBusinessHandler = localAppInterface.getBusinessHandler((String)((Iterator)localObject).next());
        if (localBusinessHandler != null)
        {
          try
          {
            localBusinessHandler.onReceive(paramToServiceMsg, paramFromServiceMsg, paramObject);
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.w("MobileQQServiceBase", 2, localBusinessHandler.getClass().getSimpleName() + " onReceive error", localException);
          }
        }
      }
    }
  }
  
  public abstract AppInterface getAppInterface();
  
  protected Map<String, String[]> getCompatibleCmd2HandlerMap()
  {
    return null;
  }
  
  protected abstract Class<? extends MSFServlet> getServlet();
  
  protected UniPacket getUniPacketClient(ToServiceMsg paramToServiceMsg)
  {
    return new UniPacket(true);
  }
  
  public void handleNoProtocolCoder(ToServiceMsg paramToServiceMsg) {}
  
  public void handleRequest(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      QLog.d("MobileQQServiceBase", 1, "handleRequest, request null");
      return;
    }
    paramToServiceMsg = new MobileQQServiceBase.1(this, paramToServiceMsg);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(paramToServiceMsg, 16, null, false);
      return;
    }
    paramToServiceMsg.run();
  }
  
  public void handleResponse(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    Object localObject = null;
    if (paramToServiceMsg == null) {
      return;
    }
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
    boolean bool2 = isPBPushCmd(paramFromServiceMsg.getServiceCmd());
    if ((bool1) || (bool2))
    {
      bool1 = true;
      label43:
      if (QLog.isColorLevel())
      {
        long l1 = System.currentTimeMillis();
        long l2 = paramToServiceMsg.extraData.getLong("sendtimekey");
        QLog.d("MobileQQServiceBase", 2, "[RES] cmd:" + paramFromServiceMsg.getServiceCmd() + ", success:" + paramBoolean + ", bPbResp:" + bool1 + ", app seq:" + paramFromServiceMsg.getAppSeq() + ", result:" + paramFromServiceMsg.getResultCode() + ", duration: " + (l1 - l2) + "ms", paramException);
      }
      if (!bool1) {
        break label250;
      }
      if ((!paramBoolean) || (paramFromServiceMsg.getWupBuffer() == null)) {
        break label345;
      }
      int i = paramFromServiceMsg.extraData.getInt("pb_msg_offset", 4);
      int j = paramFromServiceMsg.getWupBuffer().length - i;
      if (j <= 0) {
        break label345;
      }
      paramException = new byte[j];
      PkgTools.copyData(paramException, 0, paramFromServiceMsg.getWupBuffer(), i, j);
      paramFromServiceMsg.putWupBuffer(paramException);
    }
    label345:
    for (paramException = paramFromServiceMsg.getWupBuffer();; paramException = null)
    {
      dispatchToHandler(paramToServiceMsg, paramFromServiceMsg, paramException);
      return;
      bool1 = false;
      break label43;
      label250:
      BaseProtocolCoder localBaseProtocolCoder = lookupCoder(paramFromServiceMsg.getServiceCmd());
      if (localBaseProtocolCoder == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MobileQQServiceBase", 2, "bpc null");
        return;
      }
      paramException = localObject;
      if (paramBoolean) {}
      try
      {
        localBaseProtocolCoder.decodeRespMsg(paramToServiceMsg, paramFromServiceMsg);
        paramException = localBaseProtocolCoder.decode(paramToServiceMsg, paramFromServiceMsg);
        dispatchToHandler(paramToServiceMsg, paramFromServiceMsg, paramException);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramException = localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("MobileQQServiceBase", 2, localException, new Object[0]);
            paramException = localObject;
          }
        }
      }
    }
  }
  
  protected void initCoders() {}
  
  public boolean isPBPushCmd(String paramString)
  {
    return false;
  }
  
  public BaseProtocolCoder lookupCoder(String paramString)
  {
    if (!this.isDoCoderInit) {}
    int i;
    try
    {
      if (!this.isDoCoderInit) {
        initCoders();
      }
      i = paramString.indexOf('.');
      if (i <= 1) {
        return null;
      }
    }
    finally {}
    paramString = paramString.substring(0, i);
    return (BaseProtocolCoder)this.coderMap.get(paramString);
  }
  
  public void realHandleRequest(ToServiceMsg paramToServiceMsg, Class<? extends MSFServlet> paramClass)
  {
    int i = 1;
    int j = 0;
    int k = 0;
    boolean bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
    AppInterface localAppInterface = getAppInterface();
    Object localObject1;
    if (bool)
    {
      if (paramToServiceMsg.getWupBuffer() == null) {
        break label353;
      }
      long l = paramToServiceMsg.getWupBuffer().length;
      localObject1 = new byte[(int)l + 4];
      PkgTools.DWord2Byte((byte[])localObject1, 0, 4L + l);
      PkgTools.copyData((byte[])localObject1, 4, paramToServiceMsg.getWupBuffer(), (int)l);
      paramToServiceMsg.putWupBuffer((byte[])localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("MobileQQServiceBase", 2, "PB cmd: req cmd: " + paramToServiceMsg.getServiceCmd());
      }
      j = 1;
      i = 0;
      localObject1 = null;
    }
    for (;;)
    {
      label177:
      Object localObject2;
      if (j != 0)
      {
        paramToServiceMsg.extraData.putLong("sendtimekey", System.currentTimeMillis());
        paramClass = new NewIntent(localAppInterface.getApplication(), paramClass);
        paramClass.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
        localAppInterface.startServlet(paramClass);
        return;
        localObject1 = lookupCoder(paramToServiceMsg.getServiceCmd());
        if (localObject1 != null)
        {
          localObject2 = getUniPacketClient(paramToServiceMsg);
          ((UniPacket)localObject2).setEncodeName("utf-8");
          int m = seq;
          seq = m + 1;
          ((UniPacket)localObject2).setRequestId(m);
          if (((BaseProtocolCoder)localObject1).enableBinaryProtocol())
          {
            localObject2 = ((BaseProtocolCoder)localObject1).encodeReqMsg(paramToServiceMsg);
            i = k;
            if (localObject2 != null)
            {
              paramToServiceMsg.putWupBuffer((byte[])localObject2);
              i = 1;
            }
            j = 1;
          }
        }
      }
      for (;;)
      {
        k = i;
        i = j;
        j = k;
        break;
        if (((BaseProtocolCoder)localObject1).encodeReqMsg(paramToServiceMsg, (UniPacket)localObject2))
        {
          paramToServiceMsg.putWupBuffer(((UniPacket)localObject2).encode());
          continue;
          handleNoProtocolCoder(paramToServiceMsg);
          i = 0;
          j = 0;
          break;
          if ((!bool) && ((localObject1 == null) || (i != 0))) {
            break label177;
          }
          dispatchToHandler(paramToServiceMsg, new FromServiceMsg(localAppInterface.getAccount(), paramToServiceMsg.getServiceCmd()), null);
          return;
        }
        i = 0;
      }
      label353:
      i = 0;
      j = 0;
      localObject1 = null;
    }
  }
  
  protected void setCodersInit()
  {
    try
    {
      this.isDoCoderInit = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.MobileQQServiceBase
 * JD-Core Version:    0.7.0.1
 */