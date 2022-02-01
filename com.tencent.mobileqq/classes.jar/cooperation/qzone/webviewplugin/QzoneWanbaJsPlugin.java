package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneWanbaJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String ACTION_NOTIFY_ADV_PLAY = "QZONE.ACTION_NOTIFY_ADV_PLAY";
  public static final String BROADCAST_PERMISSION = "com.tencent.msg.permission.pushnotify";
  public static final String KEY_CALLBACK = "callback";
  public static final String KEY_RESULT = "ret";
  private static final String TAG = "QzoneWanbaJsPlugin";
  BroadcastReceiver mReceiver = new QzoneWanbaJsPlugin.1(this);
  private volatile boolean mReceiverRegistered = false;
  
  private void registerBroadcast()
  {
    if (this.mReceiverRegistered) {
      return;
    }
    try
    {
      QZLog.i("QzoneWanbaJsPlugin", "registerBroadcast");
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("QZONE.ACTION_NOTIFY_ADV_PLAY");
      Activity localActivity = this.parentPlugin.mRuntime.a();
      boolean bool = this.mReceiverRegistered;
      if (!bool) {
        try
        {
          localActivity.registerReceiver(this.mReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
          this.mReceiverRegistered = true;
          return;
        }
        catch (Exception localException1)
        {
          QZLog.e("QzoneWanbaJsPlugin", "regist receiver error:", localException1);
          return;
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      QZLog.e("QzoneWanbaJsPlugin", "registerBroadcast error", localException2);
    }
  }
  
  private void removeBroadcast()
  {
    try
    {
      if (this.mReceiverRegistered)
      {
        QZLog.i("QzoneWanbaJsPlugin", "removeBroadcast");
        Activity localActivity = this.parentPlugin.mRuntime.a();
        try
        {
          localActivity.unregisterReceiver(this.mReceiver);
        }
        catch (Exception localException1)
        {
          QZLog.e("QzoneWanbaJsPlugin", "unregisterReceiver error ", localException1);
        }
        this.mReceiverRegistered = false;
        return;
      }
    }
    catch (Exception localException2)
    {
      QZLog.e("QzoneWanbaJsPlugin", "removeBroadcast error", localException2);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"Qzone".equals(paramString2)) {
      return false;
    }
    if ("OpenGDTVideoPage".equals(paramString3)) {
      try
      {
        if (paramVarArgs.length < 1)
        {
          QZLog.e("QzoneWanbaJsPlugin", "OpenGDTVideoPage 参数错误");
          return true;
        }
        paramString3 = paramVarArgs[0];
        paramString2 = null;
        try
        {
          paramJsBridgeListener = new JSONObject(paramString3);
          try
          {
            paramString1 = paramJsBridgeListener.optString("callback");
          }
          catch (JSONException paramString1) {}
          paramString1.printStackTrace();
        }
        catch (JSONException paramString1)
        {
          paramJsBridgeListener = null;
        }
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString1))
        {
          QZLog.e("QzoneWanbaJsPlugin", "OpenGDTVideoPage not have callback");
          return true;
        }
        paramString1 = new StringBuilder();
        paramString1.append("OpenGDTVideoPage js param=");
        paramString1.append(paramJsBridgeListener);
        QZLog.i("QzoneWanbaJsPlugin", paramString1.toString());
        registerBroadcast();
        QZoneHelper.launchQZoneEncourageAdvActivity(this.parentPlugin.mRuntime.a(), paramString3);
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        QZLog.e("QzoneWanbaJsPlugin", "OpenGDTVideoPage error", paramJsBridgeListener);
        return true;
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    removeBroadcast();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneWanbaJsPlugin
 * JD-Core Version:    0.7.0.1
 */