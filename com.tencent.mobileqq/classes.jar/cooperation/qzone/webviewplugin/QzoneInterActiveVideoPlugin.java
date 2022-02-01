package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QzoneInterActiveVideoPlugin
  extends QzoneInternalWebViewPlugin
{
  private static final String ACTION_HIDE_INNER_WEBVIEW = "com.tencent.mobileqq.action.ACTION_HIDE_INNER_WEBVIEW";
  private static final String ACTION_LIVEVIDEO_AUTHENTICATION = "com.cooperation.cooperation.qzone.webviewplugin.QzoneInterActiveVideoPlugin.getAuthenticationResults";
  private static final String ACTION_LIVE_MUSIC_SELECT = "com.qzone.module.browser.plugin.QzLivePlugin.liveMusicSelect";
  private static final String ACTION_NOTIFY_PAGE_READY = "com.tencent.mobileqq.action.ACTION_NOTIFY_PAGE_READY";
  private static final String ACTION_NOTIFY_QZ_LIVE_VIDEO_EVENT = "com.tencent.mobileqq.action.ACTION_QZ_LIVE_DISPATCH_EVENT";
  private static final String ACTION_OPEN_USER_INFO_CARD = "com.tencent.mobileqq.action.ACTION_OPEN_USER_INFO_CARD";
  private static final String EXTRA_NAME_LIVE_MUSIC_SONG_MID = "get_live_music_song_mid";
  private static final String METHOD_NAME_OF_AUTHENTICATION = "getAuthenticationResults";
  private static final String NOTIFY_VIDEO_DIALOG_PERMISSION = "com.tencent.msg.permission.pushnotify";
  private static final String QZ_LIVE_DISPATCH_EVENT_PARAMS_DATA = "data";
  private static final String QZ_LIVE_DISPATCH_EVENT_PARAMS_EVENT = "event";
  private static final String TAG = "QzoneInternalWebViewPlugin";
  private static JSONObject liveMusicUrlData;
  
  private static void notifyHideInnerWebview()
  {
    QLog.i("QzoneInternalWebViewPlugin", 2, "saxon@ hideInnerWebview running");
    try
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_HIDE_INNER_WEBVIEW");
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QzoneInternalWebViewPlugin", 1, "saxon@ notifyHideInnerWebview exception", localThrowable);
    }
  }
  
  private static void notifyOpenUserInfoCard(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saxon@ openUserInfoCard uin is ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("QzoneInternalWebViewPlugin", 2, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new Intent("com.tencent.mobileqq.action.ACTION_OPEN_USER_INFO_CARD");
      ((Intent)localObject).putExtra("uin", paramString);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("QzoneInternalWebViewPlugin", 1, "saxon@ notifyOpenUserInfoCard exception", paramString);
    }
  }
  
  private static void notifyPageReadyInnerWebview()
  {
    QLog.i("QzoneInternalWebViewPlugin", 2, "saxon@ onPageReady running");
    try
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_NOTIFY_PAGE_READY");
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QzoneInternalWebViewPlugin", 1, "saxon@ notifyPageReadyInnerWebview exception", localThrowable);
    }
  }
  
  public boolean dispatchOldPattern(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("getLiveMusicUrl".equals(paramString3))
    {
      if (paramVarArgs != null) {
        try
        {
          if (paramVarArgs.length != 1) {
            break label509;
          }
          liveMusicUrlData = new JSONObject(paramVarArgs[0]);
          if (liveMusicUrlData != null)
          {
            paramJsBridgeListener = liveMusicUrlData.optJSONObject("data");
            paramJsBridgeListener.getString("file_mid");
            paramJsBridgeListener = paramJsBridgeListener.getString("song_mid");
            paramString1 = new Intent("com.qzone.module.browser.plugin.QzLivePlugin.liveMusicSelect");
            paramString1.putExtra("get_live_music_song_mid", paramJsBridgeListener);
            BaseApplicationImpl.getApplication().sendBroadcast(paramString1);
            if ((this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null)) {
              this.parentPlugin.mRuntime.a().finish();
            }
          }
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramString1 = new StringBuilder();
          paramString1.append("getLiveMusicUrl Exception");
          paramString1.append(paramJsBridgeListener.toString());
          QLog.w("QzoneInternalWebViewPlugin", 1, paramString1.toString());
          return false;
        }
      }
    }
    else if ("getAuthenticationResults".equals(paramString3))
    {
      if (paramVarArgs != null) {
        try
        {
          if (paramVarArgs.length <= 0) {
            break label509;
          }
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          int i = paramJsBridgeListener.getInt("result");
          int j = paramJsBridgeListener.getInt("from");
          paramJsBridgeListener = new Intent("com.cooperation.cooperation.qzone.webviewplugin.QzoneInterActiveVideoPlugin.getAuthenticationResults");
          paramJsBridgeListener.putExtra("result", i);
          paramJsBridgeListener.putExtra("from", j);
          BaseApplicationImpl.getApplication().sendBroadcast(paramJsBridgeListener);
          if ((this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.a() != null)) {
            this.parentPlugin.mRuntime.a().finish();
          } else if (this.parentPlugin.mRuntime == null) {
            QLog.i("QzoneInternalWebViewPlugin", 1, " the parentPlugin.mRuntime is null");
          } else {
            QLog.i("QzoneInternalWebViewPlugin", 1, " parentPlugin.mRuntime.getActivity() is null");
          }
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("result is ");
          paramJsBridgeListener.append(i);
          paramJsBridgeListener.append(",from is ");
          paramJsBridgeListener.append(j);
          QLog.i("QzoneInternalWebViewPlugin", 1, paramJsBridgeListener.toString());
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.w("QzoneInternalWebViewPlugin", 1, "doAuthentication catch an exception in handleJsRequest", paramJsBridgeListener);
          return false;
        }
      }
    }
    else if ("openUserInfoCard".equals(paramString3))
    {
      if (paramVarArgs != null) {
        try
        {
          if (paramVarArgs.length <= 0) {
            break label509;
          }
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("uin");
          if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() != 0))
          {
            notifyOpenUserInfoCard(paramJsBridgeListener);
            return true;
          }
          QLog.w("QzoneInternalWebViewPlugin", 1, "openUserInfoCard uin is empty");
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramString1 = new StringBuilder();
          paramString1.append("openUserInfoCard Exception");
          paramString1.append(paramJsBridgeListener);
          QLog.w("QzoneInternalWebViewPlugin", 1, paramString1.toString());
          return false;
        }
      }
    }
    else
    {
      if ("hideInnerWebview".equals(paramString3))
      {
        notifyHideInnerWebview();
        return true;
      }
      if ("onPageReady".equals(paramString3))
      {
        notifyPageReadyInnerWebview();
        return true;
      }
    }
    label509:
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("qzlive".equals(paramString2))
    {
      if (this.parentPlugin == null) {
        return false;
      }
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qz_livevideo_jsbridge, dispatch method callback linkchain, ");
      localStringBuilder.append(paramString3);
      QLog.i("QzoneInternalWebViewPlugin", 2, localStringBuilder.toString());
      boolean bool2 = dispatchOldPattern(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      boolean bool1 = true;
      try
      {
        paramJsBridgeListener = new Intent("com.tencent.mobileqq.action.ACTION_QZ_LIVE_DISPATCH_EVENT");
        paramJsBridgeListener.putExtra("event", paramString3);
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          paramJsBridgeListener.putExtra("data", new JSONObject(paramVarArgs[0]).toString());
        }
        BaseApplicationImpl.getContext().sendBroadcast(paramJsBridgeListener, "com.tencent.msg.permission.pushnotify");
        return true;
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("QzoneInternalWebViewPlugin", 1, "qz_livevideo_jsbridge, dispatch method callback linkchain exception", paramJsBridgeListener);
        if (!bool2) {
          bool1 = false;
        }
        return bool1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneInterActiveVideoPlugin
 * JD-Core Version:    0.7.0.1
 */