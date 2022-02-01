package com.tencent.mobileqq.kandian.base.msf;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.kandian.base.msf.api.IReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class ReadInJoyMSFService
  implements IReadInJoyMSFService
{
  public static final String TAG = "ReadInJoyMSFService";
  public static final String TIME_KEY = "sendtimekey";
  private static ReadInJoyMSFService mInstance;
  private DecimalFormat decimalFormat = new DecimalFormat("0.00");
  private int mSeq = 0;
  private ConcurrentHashMap<Integer, WeakReference<IReadInJoyEngineModule>> mSeq2ModuleMap = new ConcurrentHashMap();
  
  private void dispatchResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (Integer)paramToServiceMsg.getAttributes().get("seq");
    if (localObject == null) {
      return;
    }
    localObject = (WeakReference)this.mSeq2ModuleMap.get(localObject);
    if (localObject == null) {
      return;
    }
    localObject = (IReadInJoyEngineModule)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((IReadInJoyEngineModule)localObject).onReceive(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public static ReadInJoyMSFService getInstance()
  {
    if (mInstance == null) {
      mInstance = new ReadInJoyMSFService();
    }
    return mInstance;
  }
  
  private boolean isRetryRequest(ToServiceMsg paramToServiceMsg)
  {
    boolean bool;
    if (paramToServiceMsg.getAttribute("isRetryRequest") != null)
    {
      bool = ((Boolean)paramToServiceMsg.getAttribute("isRetryRequest")).booleanValue();
      QLog.d("ReadInJoyMSFService", 1, new Object[] { "is68bRetryReq = ", Boolean.valueOf(bool) });
    }
    else
    {
      bool = false;
    }
    if (bool) {
      QLog.d("ReadInJoyMSFService", 1, " isRetryRequest | 68b Retry");
    }
    return bool;
  }
  
  public void handleRequest(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = new ReadInJoyMSFService.2(this, paramToServiceMsg);
    RIJThreadHandler.a().post(paramToServiceMsg);
  }
  
  public void handleResponse(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    if (paramToServiceMsg == null) {
      return;
    }
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
        paramException.append(this.decimalFormat.format(f));
        paramException.append("sec.");
        QLog.d("ReadInJoyMSFService", 2, paramException.toString());
      }
    }
    else
    {
      if (paramFromServiceMsg.getResultCode() == 2008)
      {
        paramFromServiceMsg = BaseActivity.sTopActivity;
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg == null) {
          paramToServiceMsg = RIJQQAppInterfaceUtil.a().getApplication();
        }
        paramFromServiceMsg = new Intent();
        paramFromServiceMsg.setFlags(872415232);
        paramFromServiceMsg.putExtra("type", 2);
        RouteUtils.a(paramToServiceMsg, paramFromServiceMsg, "/base/notification");
        return;
      }
      if (paramException != null)
      {
        localObject = new ByteArrayOutputStream();
        paramException.printStackTrace(new PrintStream((OutputStream)localObject));
        paramException = new String(((ByteArrayOutputStream)localObject).toByteArray());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[NOT SEND]cmd=");
          ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(paramException);
          QLog.d("ReadInJoyMSFService", 2, ((StringBuilder)localObject).toString());
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
        paramException.append(this.decimalFormat.format(f));
        paramException.append("sec.");
        QLog.w("ReadInJoyMSFService", 2, paramException.toString());
      }
    }
    boolean bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
    if (QLog.isDevelopLevel())
    {
      paramException = new StringBuilder();
      paramException.append("bPbResp:");
      paramException.append(bool);
      QLog.d("ReadInJoy", 4, paramException.toString());
    }
    Object localObject = null;
    paramException = (Exception)localObject;
    if (paramBoolean) {
      if (bool)
      {
        if (QLog.isColorLevel())
        {
          paramException = new StringBuilder();
          paramException.append("PB cmd: recv cmd: ");
          paramException.append(paramFromServiceMsg.getServiceCmd());
          QLog.d("ReadInJoyMSFService", 2, paramException.toString());
        }
        paramException = (Exception)localObject;
        if (paramFromServiceMsg.getWupBuffer() != null)
        {
          int i = paramFromServiceMsg.getWupBuffer().length - 4;
          paramException = new byte[i];
          PkgTools.copyData(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramFromServiceMsg.putWupBuffer(paramException);
          paramException = paramFromServiceMsg.getWupBuffer();
        }
      }
      else
      {
        paramException = (Exception)localObject;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ReadInJoyMSFService", 2, "bpc null");
            paramException = (Exception)localObject;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          paramException = (Exception)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("ReadInJoyMSFService", 2, "", localException);
            paramException = (Exception)localObject;
          }
        }
      }
    }
    dispatchResponse(paramToServiceMsg, paramFromServiceMsg, paramException);
  }
  
  public final void sendPbRequest(ToServiceMsg paramToServiceMsg, IReadInJoyEngineModule paramIReadInJoyEngineModule)
  {
    if (paramToServiceMsg != null)
    {
      if (paramIReadInJoyEngineModule == null) {
        return;
      }
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramIReadInJoyEngineModule = new WeakReference(paramIReadInJoyEngineModule);
      RIJThreadHandler.a().post(new ReadInJoyMSFService.1(this, paramToServiceMsg, paramIReadInJoyEngineModule));
      handleRequest(paramToServiceMsg);
    }
  }
  
  public void unInitialize()
  {
    this.mSeq = 0;
    this.mSeq2ModuleMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService
 * JD-Core Version:    0.7.0.1
 */