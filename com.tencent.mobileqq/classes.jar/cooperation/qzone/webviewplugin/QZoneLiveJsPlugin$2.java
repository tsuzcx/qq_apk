package cooperation.qzone.webviewplugin;

import android.os.RemoteException;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

class QZoneLiveJsPlugin$2
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  QZoneLiveJsPlugin$2(QZoneLiveJsPlugin paramQZoneLiveJsPlugin, JSONObject paramJSONObject, boolean paramBoolean, String paramString) {}
  
  public void onQzonePluginClientReady(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null) {
      return;
    }
    try
    {
      localPluginRecord = paramIQZonePluginManager.queryPlugin("qzone_live_video_plugin_hack.apk");
      if ((localPluginRecord == null) || (localPluginRecord.state != 4)) {
        break label104;
      }
      this.val$result.put("isInstalled", true);
    }
    catch (JSONException paramIQZonePluginManager)
    {
      for (;;)
      {
        PluginRecord localPluginRecord;
        paramIQZonePluginManager.printStackTrace();
        return;
        if ((localPluginRecord != null) && ((localPluginRecord.state == 2) || (NetworkState.isWifiConn())))
        {
          this.val$result.put("isInstalled", false);
          if (this.val$needInstall)
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneLiveJsPlugin", 2, " needInstall:" + this.val$needInstall + ",需要安装插件");
            }
            paramIQZonePluginManager.installPlugin(localPluginRecord.id, null, 0);
          }
        }
      }
    }
    catch (RemoteException paramIQZonePluginManager)
    {
      paramIQZonePluginManager.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QZoneLiveJsPlugin", 2, " 返回结果：" + this.val$result);
    }
    this.this$0.parentPlugin.callJs(this.val$callback, new String[] { this.val$result.toString() });
    return;
    label104:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneLiveJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */