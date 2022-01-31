package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.RecordAndChangeVoiceService;
import org.json.JSONException;
import org.json.JSONObject;

public class QZonePublishSecretShuoShuoH5Plugin
  extends QzoneInternalWebViewPlugin
{
  public static QZonePublishSecretShuoShuoH5Plugin a;
  
  public QZonePublishSecretShuoShuoH5Plugin()
  {
    jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin = this;
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ret", 0);
        ((JSONObject)localObject).put("voiceTime", paramLong);
        localObject = ((JSONObject)localObject).toString();
        if ((jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() != null))
        {
          jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().a(paramString, new String[] { localObject });
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, paramString.getMessage());
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("ret", 0);
        localJSONObject.put("voiceData", paramString2);
        localJSONObject.put("voiceFormat", "amr");
        paramString2 = localJSONObject.toString();
        if ((jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() != null))
        {
          jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().a(paramString1, new String[] { paramString2 });
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, paramString1.getMessage());
      }
    }
  }
  
  public static void b()
  {
    if ((jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)) {
      jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.secret.onRightButtonClick()");
    }
  }
  
  public static void b(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ret", 0);
        ((JSONObject)localObject).put("voiceTime", paramLong);
        localObject = ((JSONObject)localObject).toString();
        if ((jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() != null))
        {
          jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().a(paramString, new String[] { localObject });
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, paramString.getMessage());
      }
    }
  }
  
  public static void c()
  {
    if ((jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)) {
      jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.secret.onEditLeftButtonClick()");
    }
  }
  
  public static void d()
  {
    if ((jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)) {
      jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.secret.onEditRightButtonClick()");
    }
  }
  
  public static void e()
  {
    if ((jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)) {
      jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.QZMoodVoiceJSInterface.onRecordDone()");
    }
  }
  
  public static void f()
  {
    if ((jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin != null) && (jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)) {
      jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.QZMoodVoiceJSInterface.onRecordCancel()");
    }
  }
  
  public void a()
  {
    jdField_a_of_type_CooperationQzoneWebviewpluginQZonePublishSecretShuoShuoH5Plugin = null;
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.a(paramIntent, paramByte, paramInt);
    switch (paramByte)
    {
    default: 
      return;
    }
    if (paramInt == -1)
    {
      RecordAndChangeVoiceService.a().a(paramIntent, 0);
      return;
    }
    f();
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int k = 0;
    int j = 0;
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {}
    do
    {
      return false;
      if (paramString3.equalsIgnoreCase("updateFeedsAndPopup"))
      {
        paramJsBridgeListener = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
        if ((paramJsBridgeListener instanceof QzonePublishSecretShuoShuoH5PluginInterface)) {
          ((QzonePublishSecretShuoShuoH5PluginInterface)paramJsBridgeListener).g();
        }
        return true;
      }
      if (paramString3.equalsIgnoreCase("editTitleButtons"))
      {
        paramJsBridgeListener = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
        if ((paramJsBridgeListener instanceof QzonePublishSecretShuoShuoH5PluginInterface)) {
          ((QzonePublishSecretShuoShuoH5PluginInterface)paramJsBridgeListener).h();
        }
        return true;
      }
      if (paramString3.equalsIgnoreCase("getMoodVoiceRecordTime"))
      {
        paramString1 = "";
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1;
          if (paramString2 != null) {
            paramJsBridgeListener = paramString2.optString("callback");
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
            paramJsBridgeListener = paramString1;
          }
        }
        RecordAndChangeVoiceService.a().a(paramJsBridgeListener);
        return true;
      }
      int i;
      if (paramString3.equalsIgnoreCase("playMoodVoice"))
      {
        paramString1 = "";
        paramJsBridgeListener = paramString1;
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          i = j;
          paramJsBridgeListener = paramString1;
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString1;
            paramString1 = paramString2.optString("callback");
            paramJsBridgeListener = paramString1;
            i = paramString2.optInt("voiceID");
            paramJsBridgeListener = paramString1;
          }
        }
        catch (JSONException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            i = j;
          }
        }
        RecordAndChangeVoiceService.a().a(paramJsBridgeListener, i);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getMoodVoiceData"))
      {
        paramString1 = "";
        paramJsBridgeListener = paramString1;
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          i = k;
          paramJsBridgeListener = paramString1;
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString1;
            paramString1 = paramString2.optString("callback");
            paramJsBridgeListener = paramString1;
            i = paramString2.optInt("voiceID");
            paramJsBridgeListener = paramString1;
          }
        }
        catch (JSONException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            i = k;
          }
        }
        RecordAndChangeVoiceService.a().b(paramJsBridgeListener, i);
        return true;
      }
      if (paramString3.equalsIgnoreCase("stopPlayingMoodVoice"))
      {
        RecordAndChangeVoiceService.a().d();
        return true;
      }
    } while (!paramString3.equalsIgnoreCase("didPublishMoodVoice"));
    paramJsBridgeListener = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    if ((paramJsBridgeListener instanceof QZonePublishVoiceShuoShuoH5PluginInterface)) {
      ((QZonePublishVoiceShuoShuoH5PluginInterface)paramJsBridgeListener).b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZonePublishSecretShuoShuoH5Plugin
 * JD-Core Version:    0.7.0.1
 */