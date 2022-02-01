package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomHelper;
import cooperation.liveroom.LiveRoomPluginInstaller;

class LiveRoomBusinessPlugin$1
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  LiveRoomBusinessPlugin$1(LiveRoomBusinessPlugin paramLiveRoomBusinessPlugin, String paramString) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    PluginBaseInfo localPluginBaseInfo = paramPluginManagerClient.queryPlugin("LiveRoomPlugin.apk");
    if (QLog.isColorLevel()) {
      QLog.d("LiveRoomBusinessPlugin", 2, "get plugin info by ipc");
    }
    if ((localPluginBaseInfo != null) && (localPluginBaseInfo.mState == 4))
    {
      LiveRoomHelper.setPluginInstalledInTool();
      paramPluginManagerClient = new StringBuilder();
      paramPluginManagerClient.append("");
      paramPluginManagerClient.append(localPluginBaseInfo.mCurVersion);
      LiveRoomHelper.setPluginVersionInTool(paramPluginManagerClient.toString());
      paramPluginManagerClient = this.b;
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{\"result\":0\"version\":\"");
      localStringBuilder.append(localPluginBaseInfo.mCurVersion);
      localStringBuilder.append("\"}");
      paramPluginManagerClient.callJs(str, new String[] { localStringBuilder.toString() });
      if (QLog.isColorLevel())
      {
        paramPluginManagerClient = new StringBuilder();
        paramPluginManagerClient.append("plugin is installed: version=");
        paramPluginManagerClient.append(localPluginBaseInfo.mCurVersion);
        QLog.d("LiveRoomBusinessPlugin", 2, paramPluginManagerClient.toString());
      }
    }
    else
    {
      this.b.callJs(this.a, new String[] { "{\"result\":-1}" });
      LiveRoomPluginInstaller.getInstance().installFromTool(paramPluginManagerClient, "checkSDKInstalled");
      if (QLog.isColorLevel()) {
        QLog.d("LiveRoomBusinessPlugin", 2, "plugin is not installed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.LiveRoomBusinessPlugin.1
 * JD-Core Version:    0.7.0.1
 */