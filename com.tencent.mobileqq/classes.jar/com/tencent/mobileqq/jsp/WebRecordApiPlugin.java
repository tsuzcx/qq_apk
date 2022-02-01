package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class WebRecordApiPlugin
  extends WebViewPlugin
{
  private WebRecordApiPlugin.AudioApiHelper jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioApiHelper = null;
  private String jdField_a_of_type_JavaLangString = null;
  private String b = null;
  private String c = null;
  
  public WebRecordApiPlugin()
  {
    this.mPluginNameSpace = "webRecord";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"webRecord".equals(paramString2)) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioApiHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioApiHelper = new WebRecordApiPlugin.AudioApiHelper(this, this.mRuntime.a(), (QBaseActivity)this.mRuntime.a());
    }
    if ("startRecord".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        this.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("callback", "");
        int i = paramJsBridgeListener.optInt("format", 0);
        int j = paramJsBridgeListener.optInt("maxTime", 0);
        this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioApiHelper.a(i, j);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
    }
    if ("stopRecord".equals(paramString3))
    {
      this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioApiHelper.a(0);
      return true;
    }
    if ("play".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        this.b = paramJsBridgeListener.optString("callback", "");
        paramJsBridgeListener = paramJsBridgeListener.optString("recordID", "");
        this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioApiHelper.a(paramJsBridgeListener);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
    }
    if ("pause".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("recordID", "");
        this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioApiHelper.c(paramJsBridgeListener);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
    }
    if ("stop".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("recordID", "");
        this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioApiHelper.b(paramJsBridgeListener);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
    }
    if ("upload".equals(paramString3)) {
      try
      {
        paramString2 = new JSONObject(paramVarArgs[0]);
        this.c = paramString2.optString("callback", "");
        paramJsBridgeListener = paramString2.optJSONArray("recordIDs");
        paramString1 = paramString2.optString("cgi", "");
        paramString2 = paramString2.optString("cookie", "");
        this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioApiHelper.a(paramJsBridgeListener, paramString1, paramString2);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioApiHelper.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onDestroy() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioApiHelper.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin
 * JD-Core Version:    0.7.0.1
 */