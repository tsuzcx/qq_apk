package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
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
  private static JSONObject a;
  
  private static void a(String paramString)
  {
    QLog.i("QzoneInternalWebViewPlugin", 2, "saxon@ openUserInfoCard uin is " + paramString);
    try
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_OPEN_USER_INFO_CARD");
      localIntent.putExtra("uin", paramString);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("QzoneInternalWebViewPlugin", 1, "saxon@ notifyOpenUserInfoCard exception", paramString);
    }
  }
  
  private static void b()
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
  
  private static void c()
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
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!"qzlive".equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null))
    {
      bool1 = false;
      return bool1;
    }
    if (("getAuthenticationResults".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          bool1 = bool2;
          if (paramJsBridgeListener == null) {
            break;
          }
          int i = paramJsBridgeListener.getInt("result");
          int j = paramJsBridgeListener.getInt("from");
          paramJsBridgeListener = new Intent("com.cooperation.cooperation.qzone.webviewplugin.QzoneInterActiveVideoPlugin.getAuthenticationResults");
          paramJsBridgeListener.putExtra("result", i);
          paramJsBridgeListener.putExtra("from", j);
          BaseApplicationImpl.getApplication().sendBroadcast(paramJsBridgeListener);
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() == null)) {
            break label457;
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
          QLog.i("QzoneInternalWebViewPlugin", 1, "result is " + i + ",from is " + j);
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.w("QzoneInternalWebViewPlugin", 1, "doAuthentication catch an exception in handleJsRequest", paramJsBridgeListener);
        }
        if (("getLiveMusicUrl".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length == 1)) {
          try
          {
            jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramVarArgs[0]);
            bool1 = bool2;
            if (jdField_a_of_type_OrgJsonJSONObject == null) {
              break;
            }
            paramJsBridgeListener = jdField_a_of_type_OrgJsonJSONObject.optJSONObject("data");
            paramJsBridgeListener.getString("file_mid");
            paramJsBridgeListener = paramJsBridgeListener.getString("song_mid");
            paramString1 = new Intent("com.qzone.module.browser.plugin.QzLivePlugin.liveMusicSelect");
            paramString1.putExtra("get_live_music_song_mid", paramJsBridgeListener);
            BaseApplicationImpl.getApplication().sendBroadcast(paramString1);
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null) {
              break;
            }
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.w("QzoneInternalWebViewPlugin", 1, "getLiveMusicUrl Exception" + paramJsBridgeListener.toString());
          }
        }
      }
      if ((!"openUserInfoCard".equals(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length <= 0)) {
        break label495;
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("uin");
        if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() != 0)) {
          break label489;
        }
        QLog.w("QzoneInternalWebViewPlugin", 1, "openUserInfoCard uin is empty");
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.w("QzoneInternalWebViewPlugin", 1, "openUserInfoCard Exception" + paramJsBridgeListener);
        return true;
      }
      label457:
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null) {
        QLog.i("QzoneInternalWebViewPlugin", 1, " the parentPlugin.mRuntime is null");
      } else {
        QLog.i("QzoneInternalWebViewPlugin", 1, " parentPlugin.mRuntime.getActivity() is null");
      }
    }
    label489:
    a(paramJsBridgeListener);
    return true;
    label495:
    if ("hideInnerWebview".equals(paramString3))
    {
      b();
      return true;
    }
    if ("onPageReady".equals(paramString3))
    {
      c();
      return true;
    }
    QLog.d("QzoneInternalWebViewPlugin", 2, "method do nothing:" + paramString3);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneInterActiveVideoPlugin
 * JD-Core Version:    0.7.0.1
 */