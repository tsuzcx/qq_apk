package com.tencent.mobileqq.video;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class VipVideoApiPlugin$1
  extends OnRemoteRespObserver
{
  VipVideoApiPlugin$1(VipVideoApiPlugin paramVipVideoApiPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.a.a.key))
    {
      Object localObject = paramBundle.getString("cmd");
      String str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      try
      {
        boolean bool = TextUtils.equals((CharSequence)localObject, "ipc_video_isinstalled");
        StringBuilder localStringBuilder;
        if (bool)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("video remote response cmd=");
            localStringBuilder.append((String)localObject);
            QLog.d("VideoApiPlugin", 2, localStringBuilder.toString());
          }
          bool = paramBundle.getBoolean("isInstalled");
          this.a.callJs(str, new String[] { String.valueOf(bool) });
          return;
        }
        if (TextUtils.equals((CharSequence)localObject, "ipc_video_install_plugin"))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("video remote response cmd=");
            localStringBuilder.append((String)localObject);
            QLog.d("VideoApiPlugin", 2, localStringBuilder.toString());
          }
          int i = paramBundle.getInt("status");
          localObject = new JSONObject();
          ((JSONObject)localObject).put("status", i);
          if (i != 1)
          {
            if (i != 2)
            {
              if (i == 3)
              {
                ((JSONObject)localObject).put("result", 0);
                ((JSONObject)localObject).put("progress", 100);
                ((JSONObject)localObject).put("msg", "install finished");
              }
            }
            else
            {
              ((JSONObject)localObject).put("result", paramBundle.getInt("errCode"));
              ((JSONObject)localObject).put("progress", VipVideoManager.a);
              ((JSONObject)localObject).put("msg", "install failed");
            }
          }
          else
          {
            ((JSONObject)localObject).put("result", 1);
            ((JSONObject)localObject).put("progress", paramBundle.getFloat("progress"));
            ((JSONObject)localObject).put("msg", "install progress");
          }
          this.a.callJs(str, new String[] { ((JSONObject)localObject).toString() });
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.video.VipVideoApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */