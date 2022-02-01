package com.tencent.mobileqq.mini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.os.Bundle;
import bhuf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
    PROTOCAL.StQWebRsp localStQWebRsp;
    if (paramBoolean)
    {
      paramBundle = (FromServiceMsg)paramBundle.getParcelable("msg");
      if (paramBundle == null) {
        break label272;
      }
      localStQWebRsp = new PROTOCAL.StQWebRsp();
    }
    for (;;)
    {
      try
      {
        localStQWebRsp.mergeFrom(bhuf.b(paramBundle.getWupBuffer()));
        MiniAppSSOCmdHelper.MiniAppCmdCallbackInternal localMiniAppCmdCallbackInternal = (MiniAppSSOCmdHelper.MiniAppCmdCallbackInternal)CALLBACK_MAP.remove(Integer.valueOf((int)localStQWebRsp.Seq.get()));
        if (localMiniAppCmdCallbackInternal != null)
        {
          if (localMiniAppCmdCallbackInternal.getResponseClass() != null)
          {
            MessageMicro localMessageMicro = (MessageMicro)localMiniAppCmdCallbackInternal.getResponseClass().newInstance();
            localMessageMicro.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
            if ((!paramBundle.isSuccess()) || (localStQWebRsp.retCode.get() != 0L) || (localStQWebRsp.busiBuff.get().size() <= 0)) {
              break label273;
            }
            paramBoolean = true;
            localMiniAppCmdCallbackInternal.onReceived(paramBoolean, localMessageMicro);
            return;
          }
          QLog.e("MiniAppSSOCmdObserver", 2, new Object[] { "onReceive", " cmdCallback target class must provided" });
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("MiniAppSSOCmdObserver", 1, "onReceive", paramBundle);
        return;
      }
      QLog.e("MiniAppSSOCmdObserver", 2, "onReceive no cmdCallback for " + localStQWebRsp.Seq.get());
      return;
      QLog.d("MiniAppSSOCmdObserver", 2, "onReceive() called failed with: i = [" + paramInt + "], b = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
      label272:
      return;
      label273:
      paramBoolean = false;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdObserver
 * JD-Core Version:    0.7.0.1
 */