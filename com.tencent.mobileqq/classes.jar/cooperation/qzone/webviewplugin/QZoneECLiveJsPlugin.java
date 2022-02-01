package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QZoneECLiveJsPlugin
  extends QzoneInternalWebViewPlugin
{
  private static final String ACTION_NOTIFY_QZ_LIVE_VIDEO_EVENT = "com.tencent.mobileqq.action.ACTION_EC_LIVE_DISPATCH_EVENT";
  private static final String EC_LIVE_DISPATCH_EVENT_PARAMS_DATA = "data";
  private static final String EC_LIVE_DISPATCH_EVENT_PARAMS_EVENT = "event";
  private static final String NOTIFY_VIDEO_DIALOG_PERMISSION = "com.tencent.msg.permission.pushnotify";
  private static final String TAG = "QZoneECLiveJsPlugin";
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (paramString2.equals("qqexplive"))
    {
      if (this.parentPlugin == null) {
        return false;
      }
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("ec_live_jsbridge, dispatch method callback linkchain, ");
      paramJsBridgeListener.append(paramString3);
      QLog.i("QZoneECLiveJsPlugin", 2, paramJsBridgeListener.toString());
      try
      {
        paramJsBridgeListener = new Intent("com.tencent.mobileqq.action.ACTION_EC_LIVE_DISPATCH_EVENT");
        paramJsBridgeListener.putExtra("event", paramString3);
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          paramJsBridgeListener.putExtra("data", new JSONObject(paramVarArgs[0]).toString());
        }
        BaseApplicationImpl.getContext().sendBroadcast(paramJsBridgeListener, "com.tencent.msg.permission.pushnotify");
        return true;
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("QZoneECLiveJsPlugin", 1, "qz_livevideo_jsbridge, dispatch method callback linkchain exception", paramJsBridgeListener);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneECLiveJsPlugin
 * JD-Core Version:    0.7.0.1
 */