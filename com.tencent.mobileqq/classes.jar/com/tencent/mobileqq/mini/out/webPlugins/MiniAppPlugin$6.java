package com.tencent.mobileqq.mini.out.webPlugins;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.qphone.base.util.QLog;

class MiniAppPlugin$6
  extends OnRemoteRespObserver
{
  MiniAppPlugin$6(MiniAppPlugin paramMiniAppPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey") == MiniAppPlugin.access$100(this.this$0).key) && ("ipc_start_miniapp".equals(paramBundle.getString("cmd"))))
    {
      String str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response").getString("result");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramBundle)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ipc_start_miniapp result : ");
        localStringBuilder.append(paramBundle);
        QLog.e("MiniAppPlugin", 2, localStringBuilder.toString());
        this.this$0.callJs(str, new String[] { paramBundle });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.6
 * JD-Core Version:    0.7.0.1
 */