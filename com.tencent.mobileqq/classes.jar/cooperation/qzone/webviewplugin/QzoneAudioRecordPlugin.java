package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import ankd;
import anke;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.webviewplugin.sound.QzoneSoundPlayerHelper;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneAudioRecordPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  private final QzoneAudioRecordPlugin.SimpleAACRecorder.RecorderListener jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener = new ankd(this);
  private QzoneAudioRecordPlugin.SimpleAACRecorder jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder;
  private QzoneSoundPlayerHelper jdField_a_of_type_CooperationQzoneWebviewpluginSoundQzoneSoundPlayerHelper;
  private String jdField_a_of_type_JavaLangString;
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Set jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private String b;
  private String c;
  
  public QzoneAudioRecordPlugin()
  {
    RemoteHandleManager.a().a(this);
  }
  
  private Context a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null)
      {
        Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
        localObject1 = localObject2;
        if (localActivity != null) {
          localObject1 = localActivity.getApplicationContext();
        }
      }
    }
    return localObject1;
  }
  
  private QzoneAudioRecordPlugin.SimpleAACRecorder a()
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder == null)
    {
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder = new QzoneAudioRecordPlugin.SimpleAACRecorder(44100, 96000, 5242880, 300000);
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder$RecorderListener);
    }
    return this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder;
  }
  
  private QzoneSoundPlayerHelper a()
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewpluginSoundQzoneSoundPlayerHelper == null)
    {
      this.jdField_a_of_type_CooperationQzoneWebviewpluginSoundQzoneSoundPlayerHelper = new QzoneSoundPlayerHelper();
      this.jdField_a_of_type_CooperationQzoneWebviewpluginSoundQzoneSoundPlayerHelper.a(new anke(this));
    }
    return this.jdField_a_of_type_CooperationQzoneWebviewpluginSoundQzoneSoundPlayerHelper;
  }
  
  private void a(int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("stopped", 1);
      localJSONObject2.put("errorcode", paramInt);
      localJSONObject2.put("audioClientKey", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("QzoneJSBridgeQzoneAudioPlugin_RecordState", localJSONObject2, localJSONObject1);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.w("QzoneVoiceRecordPlugin", 1, "args is null or empty");
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QzoneVoiceRecordPlugin", 1, "Upload path is empty");
      return;
    }
    if (!new File(paramString).exists())
    {
      QLog.e("QzoneVoiceRecordPlugin", 1, "Upload file " + paramString + " does not exist!!");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramString))
    {
      QLog.w("QzoneVoiceRecordPlugin", 1, "Already uploading file " + paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
    QzoneUploadInterface.a(paramString, paramInt, 0, null);
  }
  
  private void a(String... paramVarArgs)
  {
    paramVarArgs = a();
    Object localObject = a();
    if (localObject != null)
    {
      String str = UUID.randomUUID().toString();
      this.jdField_a_of_type_JavaLangString = str;
      localObject = QzoneUploadInterface.b((Context)localObject, str);
      paramVarArgs.a((String)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, localObject);
      return;
    }
    QLog.w("QzoneVoiceRecordPlugin", 1, "onStartRecord() obtain context failed");
    a(-1);
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)((Map.Entry)localIterator.next()).getValue();
      if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject))
      {
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
    }
  }
  
  private void b(String... paramVarArgs)
  {
    a().a();
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]).getString("callback");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("audioClientKey", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramVarArgs, new String[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException paramVarArgs)
      {
        QLog.w("QzoneVoiceRecordPlugin", 1, "onStopRecord() e=", paramVarArgs);
        return;
      }
    }
    QLog.w("QzoneVoiceRecordPlugin", 1, "args is null or empty");
  }
  
  private void c(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]).getString("audioClientKey");
        String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramVarArgs);
        if (str == null) {
          return;
        }
        QzoneSoundPlayerHelper localQzoneSoundPlayerHelper = a();
        if (TextUtils.equals(this.b, paramVarArgs))
        {
          localQzoneSoundPlayerHelper.a();
          return;
        }
        this.b = paramVarArgs;
        if (!localQzoneSoundPlayerHelper.a(str)) {
          return;
        }
        localQzoneSoundPlayerHelper.a();
        return;
      }
      catch (JSONException paramVarArgs)
      {
        QLog.w("QzoneVoiceRecordPlugin", 1, "onStartPlay() e=", paramVarArgs);
        return;
      }
    } else {
      QLog.w("QzoneVoiceRecordPlugin", 1, "args is null or empty");
    }
  }
  
  private void d(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        if (TextUtils.equals(new JSONObject(paramVarArgs[0]).getString("audioClientKey"), this.b))
        {
          paramVarArgs = a();
          this.b = null;
          paramVarArgs.b();
        }
        return;
      }
      catch (JSONException paramVarArgs)
      {
        QLog.w("QzoneVoiceRecordPlugin", 1, "onStartPlay() e=", paramVarArgs);
        return;
      }
    }
    QLog.w("QzoneVoiceRecordPlugin", 1, "args is null or empty");
  }
  
  private void e(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        if (TextUtils.equals(new JSONObject(paramVarArgs[0]).getString("audioClientKey"), this.b)) {
          a().c();
        }
        return;
      }
      catch (JSONException paramVarArgs)
      {
        QLog.w("QzoneVoiceRecordPlugin", 1, "onStartPlay() e=", paramVarArgs);
        return;
      }
    }
    QLog.w("QzoneVoiceRecordPlugin", 1, "args is null or empty");
  }
  
  private void f(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        String str = paramVarArgs.getString("audioClientKey");
        this.c = paramVarArgs.getString("callback");
        int i = paramVarArgs.optInt("busiType", 0);
        paramVarArgs = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        if (paramVarArgs != null) {
          a(paramVarArgs, i);
        }
        return;
      }
      catch (JSONException paramVarArgs)
      {
        QLog.w("QzoneVoiceRecordPlugin", 1, "onStartPlay() e=", paramVarArgs);
        return;
      }
    }
    QLog.w("QzoneVoiceRecordPlugin", 1, "args is null or empty");
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder != null)
    {
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder.a(null);
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder.a();
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneAudioRecordPlugin$SimpleAACRecorder = null;
    }
    if (this.jdField_a_of_type_CooperationQzoneWebviewpluginSoundQzoneSoundPlayerHelper != null)
    {
      this.jdField_a_of_type_CooperationQzoneWebviewpluginSoundQzoneSoundPlayerHelper.a();
      this.jdField_a_of_type_CooperationQzoneWebviewpluginSoundQzoneSoundPlayerHelper = null;
    }
    RemoteHandleManager.a().b(this);
    b();
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("QzoneAudio")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if (paramString3 != null)
    {
      if (paramString3.equals("startRecord"))
      {
        a(paramVarArgs);
        return true;
      }
      if (paramString3.equals("stopRecord"))
      {
        b(paramVarArgs);
        return true;
      }
      if (paramString3.equals("startPlay"))
      {
        c(paramVarArgs);
        return true;
      }
      if (paramString3.equals("stopPlay"))
      {
        d(paramVarArgs);
        return true;
      }
      if (paramString3.equals("pausePlay"))
      {
        e(paramVarArgs);
        return true;
      }
      if (paramString3.equals("startUpload"))
      {
        f(paramVarArgs);
        return true;
      }
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.qzoneUploadAudio".equals(paramString))
    {
      if ((paramBundle != null) && (paramBundle.containsKey("data"))) {
        break label34;
      }
      QLog.w("QzoneVoiceRecordPlugin", 1, "onWebEvent data == null !!");
    }
    for (;;)
    {
      return;
      label34:
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        QLog.e("QzoneVoiceRecordPlugin", 1, "call js function, bundle is empty");
        return;
      }
      int i = paramBundle.getInt("param.uploadResult", -1);
      paramString = paramBundle.getString("param.tmpLocalFile");
      paramBundle = paramBundle.getString("param.uploadAudioResult");
      QLog.d("QzoneVoiceRecordPlugin", 1, "onWebEvent code:" + i + " serverID:" + paramBundle);
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      if (TextUtils.isEmpty(paramString))
      {
        QLog.w("QzoneVoiceRecordPlugin", 1, "localTmpPath == null !!");
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errorcode", i);
        localJSONObject.put("audioServerKey", paramBundle);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.c, new String[] { localJSONObject.toString() });
        if ((i != 0) || (TextUtils.isEmpty(paramString))) {
          continue;
        }
        paramBundle = new File(paramString);
        if (!paramBundle.exists()) {
          continue;
        }
        QLog.i("QzoneVoiceRecordPlugin", 4, "deleting temp file " + paramString);
        paramBundle.delete();
        return;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          QLog.w("QzoneVoiceRecordPlugin", 1, "JSONException error !", paramBundle);
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          QLog.w("QzoneVoiceRecordPlugin", 1, "parentPlugin.callJs error !", paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneAudioRecordPlugin
 * JD-Core Version:    0.7.0.1
 */