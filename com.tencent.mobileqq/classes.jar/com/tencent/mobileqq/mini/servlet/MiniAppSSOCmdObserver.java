package com.tencent.mobileqq.mini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class MiniAppSSOCmdObserver
  implements BusinessObserver
{
  private static final Map<Integer, MiniAppSSOCmdHelper.MiniAppCmdCallbackInternal<? extends MessageMicro>> CALLBACK_MAP = new ConcurrentHashMap();
  private static final MiniAppSSOCmdObserver OBSERVER = new MiniAppSSOCmdObserver();
  private static final String TAG = "MiniAppSSOCmdObserver";
  
  static MiniAppSSOCmdObserver defaultObserver()
  {
    return OBSERVER;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      localObject1 = (FromServiceMsg)paramBundle.getParcelable("msg");
      if (localObject1 == null) {
        return;
      }
      paramBundle = new PROTOCAL.StQWebRsp();
      try
      {
        paramBundle.mergeFrom(WupUtil.b(((FromServiceMsg)localObject1).getWupBuffer()));
        MiniAppSSOCmdHelper.MiniAppCmdCallbackInternal localMiniAppCmdCallbackInternal = (MiniAppSSOCmdHelper.MiniAppCmdCallbackInternal)CALLBACK_MAP.remove(Integer.valueOf((int)paramBundle.Seq.get()));
        if (localMiniAppCmdCallbackInternal != null)
        {
          Object localObject2 = localMiniAppCmdCallbackInternal.getResponseClass();
          boolean bool = false;
          if (localObject2 != null)
          {
            localObject2 = (MessageMicro)localMiniAppCmdCallbackInternal.getResponseClass().newInstance();
            ((MessageMicro)localObject2).mergeFrom(paramBundle.busiBuff.get().toByteArray());
            paramBoolean = bool;
            if (((FromServiceMsg)localObject1).isSuccess())
            {
              paramBoolean = bool;
              if (paramBundle.retCode.get() == 0L)
              {
                paramBoolean = bool;
                if (paramBundle.busiBuff.get().size() > 0) {
                  paramBoolean = true;
                }
              }
            }
            localMiniAppCmdCallbackInternal.onReceived(paramBoolean, (MessageMicro)localObject2);
            return;
          }
          QLog.e("MiniAppSSOCmdObserver", 2, new Object[] { "onReceive", " cmdCallback target class must provided" });
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onReceive no cmdCallback for ");
        ((StringBuilder)localObject1).append(paramBundle.Seq.get());
        QLog.e("MiniAppSSOCmdObserver", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("MiniAppSSOCmdObserver", 1, "onReceive", paramBundle);
        return;
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onReceive() called failed with: i = [");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("], b = [");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append("], bundle = [");
    ((StringBuilder)localObject1).append(paramBundle);
    ((StringBuilder)localObject1).append("]");
    QLog.d("MiniAppSSOCmdObserver", 2, ((StringBuilder)localObject1).toString());
  }
  
  void sendSSOCmdRequest(String paramString1, String paramString2, MessageMicro<?> paramMessageMicro, MiniAppSSOCmdHelper.MiniAppCmdCallbackInternal<?> paramMiniAppCmdCallbackInternal)
  {
    try
    {
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), MiniAppSSOCmdServlet.class);
      int i = MiniAppCmdUtil.getCallbackIndex();
      localNewIntent.putExtra("key_index", i);
      localNewIntent.putExtra("key_appid", paramString2);
      CALLBACK_MAP.put(Integer.valueOf(i), paramMiniAppCmdCallbackInternal);
      localNewIntent.putExtra("key_data", paramMessageMicro.toByteArray());
      localNewIntent.putExtra("key_cmd_name", paramString1);
      localNewIntent.setObserver(defaultObserver());
      BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("MiniAppSSOCmdObserver", 1, "sendSSOCmdRequest ", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdObserver
 * JD-Core Version:    0.7.0.1
 */