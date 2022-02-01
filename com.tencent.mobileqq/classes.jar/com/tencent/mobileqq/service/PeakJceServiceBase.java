package com.tencent.mobileqq.service;

import android.os.Bundle;
import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public abstract class PeakJceServiceBase
{
  public static volatile int a;
  public static HashMap<String, UniPacket> a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  private ConcurrentHashMap<String, BaseProtocolCoder> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public UniPacket a(ToServiceMsg paramToServiceMsg)
  {
    if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))
    {
      String str = paramToServiceMsg.extraData.getString("filepath");
      Object localObject2 = (UniPacket)jdField_a_of_type_JavaUtilHashMap.get(str);
      Object localObject1;
      if (localObject2 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("no saved packet, new one ");
          ((StringBuilder)localObject1).append(str);
          QLog.d("PeakJceServiceBase", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = new PttUniPacket(true);
        jdField_a_of_type_JavaUtilHashMap.clear();
        jdField_a_of_type_JavaUtilHashMap.put(str, localObject1);
      }
      else
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("got last packet, reuse it ");
          ((StringBuilder)localObject1).append(str);
          QLog.d("PeakJceServiceBase", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      paramToServiceMsg = Short.valueOf(paramToServiceMsg.extraData.getShort("PackSeq"));
      int i = StreamDataManager.b(str);
      if (paramToServiceMsg.shortValue() <= i)
      {
        jdField_a_of_type_JavaUtilHashMap.remove(str);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("last stream, remove ");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(", ");
          ((StringBuilder)localObject2).append(paramToServiceMsg);
          QLog.d("PeakJceServiceBase", 2, ((StringBuilder)localObject2).toString());
        }
      }
      return localObject1;
    }
    return new UniPacket(true);
  }
  
  public abstract AppInterface a();
  
  public BaseProtocolCoder a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          a();
        }
      }
      finally {}
    }
    int i = paramString.indexOf('.');
    if (i <= 1) {
      return null;
    }
    paramString = paramString.substring(0, i);
    return (BaseProtocolCoder)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg) {}
  
  protected void a(ToServiceMsg paramToServiceMsg, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PeakJceServiceBase", 2, "handleRequest request is null. ");
      }
      return;
    }
    paramToServiceMsg = new PeakJceServiceBase.1(this, paramToServiceMsg, paramClass);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramToServiceMsg, 10, null, false);
      return;
    }
    paramToServiceMsg.run();
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    AppInterface localAppInterface = a();
    float f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        paramException = new StringBuilder();
        paramException.append("[RES]cmd=");
        paramException.append(paramFromServiceMsg.getServiceCmd());
        paramException.append(" app seq:");
        paramException.append(paramFromServiceMsg.getAppSeq());
        paramException.append(" during ");
        paramException.append(this.jdField_a_of_type_JavaTextDecimalFormat.format(f));
        paramException.append("sec.");
        QLog.d("PeakJceServiceBase", 2, paramException.toString());
      }
    }
    else if (paramException != null)
    {
      localObject1 = new ByteArrayOutputStream();
      paramException.printStackTrace(new PrintStream((OutputStream)localObject1));
      paramException = new String(((ByteArrayOutputStream)localObject1).toByteArray());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[NOT SEND]cmd=");
        ((StringBuilder)localObject1).append(paramFromServiceMsg.getServiceCmd());
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(paramException);
        QLog.d("PeakJceServiceBase", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramException = new StringBuilder();
      paramException.append("[RES]cmd=");
      paramException.append(paramFromServiceMsg.getServiceCmd());
      paramException.append(",CODE=");
      paramException.append(paramFromServiceMsg.getResultCode());
      paramException.append(" during ");
      paramException.append(this.jdField_a_of_type_JavaTextDecimalFormat.format(f));
      paramException.append("sec.");
      QLog.w("PeakJceServiceBase", 2, paramException.toString());
    }
    Object localObject1 = null;
    Object localObject2 = a(paramFromServiceMsg.getServiceCmd());
    paramException = (Exception)localObject1;
    if (paramBoolean)
    {
      if (localObject2 != null) {}
      try
      {
        ((BaseProtocolCoder)localObject2).decodeRespMsg(paramToServiceMsg, paramFromServiceMsg);
        paramException = ((BaseProtocolCoder)localObject2).decode(paramToServiceMsg, paramFromServiceMsg);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        paramException = (Exception)localObject1;
        if (!QLog.isColorLevel()) {
          break label434;
        }
        QLog.d("PeakJceServiceBase", 2, "", localException1);
        paramException = (Exception)localObject1;
      }
      paramException = (Exception)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("PeakJceServiceBase", 2, "bpc null");
        paramException = (Exception)localObject1;
      }
    }
    label434:
    a(paramFromServiceMsg);
    if (localObject2 != null)
    {
      localObject1 = (String[])Cmd2HandlerMap.b().get(paramFromServiceMsg.getServiceCmd());
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject2 = localAppInterface.getBusinessHandler(localObject1[i]);
          if (localObject2 != null) {
            try
            {
              ((BusinessHandler)localObject2).onReceive(paramToServiceMsg, paramFromServiceMsg, paramException);
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(localObject2.getClass().getSimpleName());
                localStringBuilder.append(" onReceive error,");
                QLog.w("PeakJceServiceBase", 2, localStringBuilder.toString(), localException2);
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  protected boolean a(BaseProtocolCoder paramBaseProtocolCoder)
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
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(arrayOfString[i], paramBaseProtocolCoder);
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, Class<? extends MSFServlet> paramClass)
  {
    AppInterface localAppInterface = a();
    Object localObject1 = paramToServiceMsg.getServiceCmd();
    Object localObject2 = a((String)localObject1);
    int j = 0;
    int i = 1;
    int k;
    if (localObject2 != null)
    {
      Object localObject3 = a(paramToServiceMsg);
      ((UniPacket)localObject3).setEncodeName("utf-8");
      k = jdField_a_of_type_Int;
      jdField_a_of_type_Int = k + 1;
      ((UniPacket)localObject3).setRequestId(k);
      if (((BaseProtocolCoder)localObject2).enableBinaryProtocol())
      {
        localObject3 = ((BaseProtocolCoder)localObject2).encodeReqMsg(paramToServiceMsg);
        if (localObject3 != null)
        {
          paramToServiceMsg.putWupBuffer((byte[])localObject3);
          break label119;
        }
      }
      else if (((BaseProtocolCoder)localObject2).encodeReqMsg(paramToServiceMsg, (UniPacket)localObject3))
      {
        paramToServiceMsg.putWupBuffer(((UniPacket)localObject3).encode());
        break label119;
      }
    }
    i = 0;
    label119:
    if (i != 0)
    {
      paramClass = new NewIntent(localAppInterface.getApplication(), paramClass);
      paramClass.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
      localAppInterface.startServlet(paramClass);
      long l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("sendtimekey", l);
      return;
    }
    if (localObject2 != null)
    {
      paramClass = new FromServiceMsg(localAppInterface.getCurrentAccountUin(), (String)localObject1);
      localObject1 = (String[])Cmd2HandlerMap.b().get(localObject1);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        k = localObject1.length;
        i = j;
        while (i < k)
        {
          localObject2 = localAppInterface.getBusinessHandler(localObject1[i]);
          if (localObject2 != null) {
            try
            {
              ((BusinessHandler)localObject2).onReceive(paramToServiceMsg, paramClass, null);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(localObject2.getClass().getSimpleName());
                localStringBuilder.append(" onReceive error,");
                QLog.w("PeakJceServiceBase", 2, localStringBuilder.toString(), localException);
              }
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.PeakJceServiceBase
 * JD-Core Version:    0.7.0.1
 */