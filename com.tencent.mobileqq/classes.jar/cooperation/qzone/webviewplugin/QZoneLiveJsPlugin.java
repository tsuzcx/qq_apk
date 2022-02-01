package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZonePluginUtils;
import org.json.JSONObject;

public class QZoneLiveJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String METHOD_NAME_OF_GET_QZONE_LIVE_PLUGIN_STATUS = "getQZoneLiveStatus";
  public static final String NAMESPACE = "Qzone";
  private static final String TAG = "QZoneLiveJsPlugin";
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if (("getQZoneLiveStatus".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          boolean bool1 = paramString1.optBoolean("needInstall");
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("H5参数：");
            paramString2.append(paramString1);
            QLog.i("QZoneLiveJsPlugin", 2, paramString2.toString());
          }
          paramString1 = new JSONObject();
          paramString2 = QZonePluginUtils.getLoadQZoneLivePluginId();
          if (QLog.isColorLevel())
          {
            paramString3 = new StringBuilder();
            paramString3.append("pluginid ：");
            paramString3.append(paramString2);
            QLog.i("QZoneLiveJsPlugin", 2, paramString3.toString());
          }
          boolean bool2 = TextUtils.isEmpty(paramString2);
          if (bool2)
          {
            paramString1.put("isInstalled", false);
            if (QLog.isColorLevel())
            {
              paramString2 = new StringBuilder();
              paramString2.append("pluginid 为空，返回：");
              paramString2.append(paramString1);
              QLog.i("QZoneLiveJsPlugin", 2, paramString2.toString());
            }
            this.parentPlugin.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            return false;
          }
          if ("qzone_live_video_plugin.apk".equals(paramString2))
          {
            if (!TextUtils.isEmpty(paramJsBridgeListener))
            {
              paramString2 = this.parentPlugin.mRuntime.d();
              if (paramString2 == null)
              {
                paramString1.put("isInstalled", false);
                if (QLog.isColorLevel())
                {
                  paramString2 = new StringBuilder();
                  paramString2.append("context 为空，返回：");
                  paramString2.append(paramString1);
                  QLog.i("QZoneLiveJsPlugin", 2, paramString2.toString());
                }
                this.parentPlugin.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                return false;
              }
              PluginManagerHelper.getPluginInterface(paramString2, new QZoneLiveJsPlugin.1(this, paramString1, paramJsBridgeListener, bool1));
              return false;
            }
          }
          else if (paramString2.equals("qzone_live_video_plugin_hack.apk"))
          {
            TextUtils.isEmpty(paramJsBridgeListener);
            return false;
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QZoneLiveJsPlugin", 2, "", paramJsBridgeListener);
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneLiveJsPlugin
 * JD-Core Version:    0.7.0.1
 */