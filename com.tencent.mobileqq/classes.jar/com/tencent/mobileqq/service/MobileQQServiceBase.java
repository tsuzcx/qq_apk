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
  public static volatile int seq;
  protected ConcurrentHashMap<String, BaseProtocolCoder> coderMap = new ConcurrentHashMap();
  private volatile boolean isDoCoderInit = false;
  
  protected boolean addCoder(BaseProtocolCoder paramBaseProtocolCoder)
  {
    String[] arrayOfString = paramBaseProtocolCoder.cmdHeaderPrefix();
    int i = 0;
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return false;
      }
      while (i < arrayOfString.length)
      {
        this.coderMap.put(arrayOfString[i], paramBaseProtocolCoder);
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public void destroy()
  {
    destroyCoder();
  }
  
  protected void destroyCoder()
  {
    Object localObject1 = this.coderMap;
    if (localObject1 != null)
    {
      localObject1 = ((ConcurrentHashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (BaseProtocolCoder)this.coderMap.get(localObject2);
        if (localObject2 != null)
        {
          try
          {
            ((BaseProtocolCoder)localObject2).destroy();
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("bpc destroy error ");
            localStringBuilder.append(localException);
            QLog.d("MobileQQServiceBase", 2, localStringBuilder.toString(), localException);
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
    Object localObject = Cmd2HandlerMapHelper.a(getAppInterface(), paramFromServiceMsg.getServiceCmd());
    if (localObject != null)
    {
      if (((Set)localObject).isEmpty()) {
        return;
      }
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
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localBusinessHandler.getClass().getSimpleName());
            localStringBuilder.append(" onReceive error");
            QLog.w("MobileQQServiceBase", 2, localStringBuilder.toString(), localException);
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
    if (paramToServiceMsg == null) {
      return;
    }
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
    boolean bool2 = isPBPushCmd(paramFromServiceMsg.getServiceCmd());
    if ((!bool1) && (!bool2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (QLog.isColorLevel())
    {
      long l1 = System.currentTimeMillis();
      long l2 = paramToServiceMsg.extraData.getLong("sendtimekey");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[RES] cmd:");
      localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
      localStringBuilder.append(", success:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", bPbResp:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", app seq:");
      localStringBuilder.append(paramFromServiceMsg.getAppSeq());
      localStringBuilder.append(", result:");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      localStringBuilder.append(", duration: ");
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("ms");
      QLog.d("MobileQQServiceBase", 2, localStringBuilder.toString(), paramException);
    }
    StringBuilder localStringBuilder = null;
    BaseProtocolCoder localBaseProtocolCoder = null;
    if (bool1)
    {
      paramException = localBaseProtocolCoder;
      if (paramBoolean)
      {
        paramException = localBaseProtocolCoder;
        if (paramFromServiceMsg.getWupBuffer() != null)
        {
          int i = paramFromServiceMsg.extraData.getInt("pb_msg_offset", 4);
          int j = paramFromServiceMsg.getWupBuffer().length - i;
          paramException = localBaseProtocolCoder;
          if (j > 0)
          {
            paramException = new byte[j];
            PkgTools.copyData(paramException, 0, paramFromServiceMsg.getWupBuffer(), i, j);
            paramFromServiceMsg.putWupBuffer(paramException);
            paramException = paramFromServiceMsg.getWupBuffer();
          }
        }
      }
      dispatchToHandler(paramToServiceMsg, paramFromServiceMsg, paramException);
      return;
    }
    localBaseProtocolCoder = lookupCoder(paramFromServiceMsg.getServiceCmd());
    if (localBaseProtocolCoder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MobileQQServiceBase", 2, "bpc null");
      }
    }
    else
    {
      paramException = localStringBuilder;
      if (paramBoolean) {
        try
        {
          localBaseProtocolCoder.decodeRespMsg(paramToServiceMsg, paramFromServiceMsg);
          paramException = localBaseProtocolCoder.decode(paramToServiceMsg, paramFromServiceMsg);
        }
        catch (Exception localException)
        {
          paramException = localStringBuilder;
          if (QLog.isColorLevel())
          {
            QLog.d("MobileQQServiceBase", 2, localException, new Object[0]);
            paramException = localStringBuilder;
          }
        }
      }
      dispatchToHandler(paramToServiceMsg, paramFromServiceMsg, paramException);
    }
  }
  
  protected void initCoders() {}
  
  public boolean isPBPushCmd(String paramString)
  {
    return false;
  }
  
  public BaseProtocolCoder lookupCoder(String paramString)
  {
    if (!this.isDoCoderInit) {
      try
      {
        if (!this.isDoCoderInit) {
          initCoders();
        }
      }
      finally {}
    }
    int i = paramString.indexOf('.');
    if (i <= 1) {
      return null;
    }
    paramString = paramString.substring(0, i);
    return (BaseProtocolCoder)this.coderMap.get(paramString);
  }
  
  public void realHandleRequest(ToServiceMsg paramToServiceMsg, Class<? extends MSFServlet> paramClass)
  {
    Object localObject1 = paramToServiceMsg.extraData;
    int j = 0;
    int i = 0;
    boolean bool = ((Bundle)localObject1).getBoolean("req_pb_protocol_flag", false);
    AppInterface localAppInterface = getAppInterface();
    int k = 1;
    if (bool) {
      if (paramToServiceMsg.getWupBuffer() != null)
      {
        long l = paramToServiceMsg.getWupBuffer().length;
        i = (int)l;
        localObject1 = new byte[i + 4];
        PkgTools.DWord2Byte((byte[])localObject1, 0, l + 4L);
        PkgTools.copyData((byte[])localObject1, 4, paramToServiceMsg.getWupBuffer(), i);
        paramToServiceMsg.putWupBuffer((byte[])localObject1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("PB cmd: req cmd: ");
          ((StringBuilder)localObject1).append(paramToServiceMsg.getServiceCmd());
          QLog.d("MobileQQServiceBase", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = null;
        i = 1;
      }
      else
      {
        localObject1 = null;
      }
    }
    for (;;)
    {
      j = 0;
      break label295;
      BaseProtocolCoder localBaseProtocolCoder = lookupCoder(paramToServiceMsg.getServiceCmd());
      if (localBaseProtocolCoder != null)
      {
        Object localObject2 = getUniPacketClient(paramToServiceMsg);
        ((UniPacket)localObject2).setEncodeName("utf-8");
        int m = seq;
        seq = m + 1;
        ((UniPacket)localObject2).setRequestId(m);
        if (localBaseProtocolCoder.enableBinaryProtocol())
        {
          localObject2 = localBaseProtocolCoder.encodeReqMsg(paramToServiceMsg);
          i = j;
          j = k;
          localObject1 = localBaseProtocolCoder;
          if (localObject2 == null) {
            break label295;
          }
          paramToServiceMsg.putWupBuffer((byte[])localObject2);
          i = 1;
          j = k;
          localObject1 = localBaseProtocolCoder;
          break label295;
        }
        localObject1 = localBaseProtocolCoder;
        if (!localBaseProtocolCoder.encodeReqMsg(paramToServiceMsg, (UniPacket)localObject2)) {
          continue;
        }
        paramToServiceMsg.putWupBuffer(((UniPacket)localObject2).encode());
        localObject1 = localBaseProtocolCoder;
        break;
      }
      handleNoProtocolCoder(paramToServiceMsg);
      localObject1 = localBaseProtocolCoder;
    }
    label295:
    if (i != 0)
    {
      paramToServiceMsg.extraData.putLong("sendtimekey", System.currentTimeMillis());
      paramClass = new NewIntent(localAppInterface.getApplication(), paramClass);
      paramClass.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
      localAppInterface.startServlet(paramClass);
      return;
    }
    if ((bool) || ((localObject1 != null) && (j == 0))) {
      dispatchToHandler(paramToServiceMsg, new FromServiceMsg(localAppInterface.getAccount(), paramToServiceMsg.getServiceCmd()), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.MobileQQServiceBase
 * JD-Core Version:    0.7.0.1
 */