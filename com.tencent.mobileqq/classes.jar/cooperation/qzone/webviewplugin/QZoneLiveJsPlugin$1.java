package cooperation.qzone.webviewplugin;

import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

class QZoneLiveJsPlugin$1
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  QZoneLiveJsPlugin$1(QZoneLiveJsPlugin paramQZoneLiveJsPlugin, JSONObject paramJSONObject, String paramString, boolean paramBoolean) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (paramPluginManagerClient == null) {}
    try
    {
      if (QLog.isColorLevel())
      {
        paramPluginManagerClient = new StringBuilder();
        paramPluginManagerClient.append("context 为空，返回：");
        paramPluginManagerClient.append(this.val$result);
        QLog.i("QZoneLiveJsPlugin", 2, paramPluginManagerClient.toString());
      }
      this.val$result.put("isInstalled", false);
      if (QLog.isColorLevel())
      {
        paramPluginManagerClient = new StringBuilder();
        paramPluginManagerClient.append("pluginManagerClient 为空，返回：");
        paramPluginManagerClient.append(this.val$result);
        QLog.i("QZoneLiveJsPlugin", 2, paramPluginManagerClient.toString());
      }
      this.this$0.parentPlugin.callJs(this.val$callback, new String[] { this.val$result.toString() });
      return;
    }
    catch (JSONException paramPluginManagerClient)
    {
      for (;;)
      {
        Object localObject;
        StringBuilder localStringBuilder;
        int i;
        continue;
        boolean bool = false;
      }
    }
    localObject = paramPluginManagerClient.queryPlugin("qzone_live_video_plugin.apk");
    if (localObject == null)
    {
      this.val$result.put("isInstalled", false);
      if (QLog.isColorLevel())
      {
        paramPluginManagerClient = new StringBuilder();
        paramPluginManagerClient.append("pluginInfo 为空，返回：");
        paramPluginManagerClient.append(this.val$result);
        QLog.i("QZoneLiveJsPlugin", 2, paramPluginManagerClient.toString());
      }
      this.this$0.parentPlugin.callJs(this.val$callback, new String[] { this.val$result.toString() });
      return;
    }
    if (((PluginBaseInfo)localObject).mState == 4)
    {
      this.val$result.put("isInstalled", true);
      if (QLog.isColorLevel())
      {
        paramPluginManagerClient = new StringBuilder();
        paramPluginManagerClient.append("插件已安装，返回：");
        paramPluginManagerClient.append(this.val$result);
        QLog.i("QZoneLiveJsPlugin", 2, paramPluginManagerClient.toString());
      }
      this.this$0.parentPlugin.callJs(this.val$callback, new String[] { this.val$result.toString() });
      return;
    }
    this.val$result.put("isInstalled", false);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("插件未安装,state=");
      localStringBuilder.append(((PluginBaseInfo)localObject).mState);
      localStringBuilder.append("needInstall：");
      localStringBuilder.append(this.val$needInstall);
      localStringBuilder.append("返回：");
      localStringBuilder.append(this.val$result);
      QLog.i("QZoneLiveJsPlugin", 2, localStringBuilder.toString());
    }
    if (this.val$needInstall)
    {
      i = NetworkState.getNetworkType();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NetworkState.NET_TYPE_WIFI == type:");
        if (1 != i) {
          break label534;
        }
        bool = true;
        ((StringBuilder)localObject).append(bool);
        QLog.i("QZoneLiveJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      if (1 == i)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneLiveJsPlugin", 2, "开始下载");
        }
        paramPluginManagerClient.installPlugin("qzone_live_video_plugin.apk");
      }
    }
    this.this$0.parentPlugin.callJs(this.val$callback, new String[] { this.val$result.toString() });
    return;
    if (QLog.isColorLevel()) {
      QLog.e("QZoneLiveJsPlugin", 2, "", paramPluginManagerClient);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneLiveJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */