package com.tencent.mobileqq.mini.out.webPlugins;

import android.os.Bundle;
import android.text.TextUtils;
import ascz;
import com.tencent.qphone.base.util.QLog;

class MiniAppPlugin$3
  extends ascz
{
  MiniAppPlugin$3(MiniAppPlugin paramMiniAppPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey") == MiniAppPlugin.access$000(this.this$0).key) && ("ipc_start_miniapp".equals(paramBundle.getString("cmd"))))
    {
      String str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response").getString("result");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramBundle)))
      {
        QLog.e("MiniAppPlugin", 2, "ipc_start_miniapp result : " + paramBundle);
        this.this$0.callJs(str, new String[] { paramBundle });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.3
 * JD-Core Version:    0.7.0.1
 */