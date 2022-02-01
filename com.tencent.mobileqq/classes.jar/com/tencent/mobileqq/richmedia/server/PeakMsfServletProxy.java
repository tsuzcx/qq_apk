package com.tencent.mobileqq.richmedia.server;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public class PeakMsfServletProxy
{
  private Map<String, String[]> a;
  private AppInterface b;
  
  public PeakMsfServletProxy(AppInterface paramAppInterface)
  {
    this.b = paramAppInterface;
    this.a = new ConcurrentHashMap();
    a("TransInfoCreate.CreateSession", new String[] { PeakAppInterface.b });
    a("TransInfo.JoinSession", new String[] { PeakAppInterface.b });
    a("TransInfo.ExitSession", new String[] { PeakAppInterface.b });
    a("TransInfo.ChangeSession", new String[] { PeakAppInterface.b });
    a("TransInfo.RawData", new String[] { PeakAppInterface.b });
    a("OidbSvc.oidb_cmd0xf8c", new String[] { "com.tencent.aelight.camera.ae.config.CameraDataServiceHandler" });
  }
  
  public AppInterface a()
  {
    return this.b;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg.getWupBuffer() != null)
    {
      long l = paramToServiceMsg.getWupBuffer().length;
      int i = (int)l;
      Object localObject = new byte[i + 4];
      PkgTools.dWord2Byte((byte[])localObject, 0, l + 4L);
      PkgTools.copyData((byte[])localObject, 4, paramToServiceMsg.getWupBuffer(), i);
      paramToServiceMsg.putWupBuffer((byte[])localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PB cmd: req cmd: ");
        ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
        QLog.d("PeakMsfServletProxy", 2, ((StringBuilder)localObject).toString());
      }
      paramClass = new NewIntent(this.b.getApplication(), paramClass);
      paramClass.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
      this.b.startServlet(paramClass);
      l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("sendtimekey", l);
    }
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
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
        paramException.append("sec.");
        paramException.append(f);
        QLog.d("PeakMsfServletProxy", 2, paramException.toString());
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
        QLog.d("PeakMsfServletProxy", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramException = new StringBuilder();
      paramException.append("[RES]cmd=");
      paramException.append(paramFromServiceMsg.getServiceCmd());
      paramException.append(",CODE=");
      paramException.append(paramFromServiceMsg.getResultCode());
      paramException.append("sec.");
      paramException.append(f);
      QLog.w("PeakMsfServletProxy", 2, paramException.toString());
    }
    paramException = null;
    Object localObject1 = paramToServiceMsg.extraData;
    int i = 0;
    boolean bool = ((Bundle)localObject1).getBoolean("req_pb_protocol_flag", false);
    if ((paramBoolean) && (bool))
    {
      localObject1 = paramFromServiceMsg.getServiceCmd();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PB cmd: recv cmd: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("PeakMsfServletProxy", 2, ((StringBuilder)localObject2).toString());
      }
      int j;
      if (paramFromServiceMsg.getWupBuffer() != null)
      {
        j = paramFromServiceMsg.getWupBuffer().length - 4;
        paramException = new byte[j];
        PkgTools.copyData(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, j);
        paramFromServiceMsg.putWupBuffer(paramException);
        paramException = paramFromServiceMsg.getWupBuffer();
      }
      Object localObject2 = (String[])this.a.get(localObject1);
      if ((localObject2 != null) && (localObject2.length > 0)) {
        j = localObject2.length;
      }
      while (i < j)
      {
        localObject1 = localAppInterface.getBusinessHandler(localObject2[i]);
        if (localObject1 != null) {
          try
          {
            ((BusinessHandler)localObject1).onReceive(paramToServiceMsg, paramFromServiceMsg, paramException);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(localObject1.getClass().getSimpleName());
              localStringBuilder.append(" onReceive error,");
              QLog.w("PeakMsfServletProxy", 2, localStringBuilder.toString(), localException);
            }
          }
        }
        i += 1;
        continue;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append(" handlerIds no map ");
          paramToServiceMsg.append((String)localObject1);
          QLog.w("PeakMsfServletProxy", 2, paramToServiceMsg.toString());
        }
      }
    }
  }
  
  protected boolean a(String paramString, String[] paramArrayOfString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.a.put(paramString, paramArrayOfString);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.server.PeakMsfServletProxy
 * JD-Core Version:    0.7.0.1
 */