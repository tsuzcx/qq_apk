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
  private String a = null;
  private String b = null;
  private String c = null;
  private WebRecordApiPlugin.AudioApiHelper d = null;
  
  public WebRecordApiPlugin()
  {
    this.mPluginNameSpace = "webRecord";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"webRecord".equals(paramString2)) {
      return false;
    }
    if (this.d == null) {
      this.d = new WebRecordApiPlugin.AudioApiHelper(this, this.mRuntime.b(), (QBaseActivity)this.mRuntime.d());
    }
    if ("startRecord".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        this.a = paramJsBridgeListener.optString("callback", "");
        int i = paramJsBridgeListener.optInt("format", 0);
        int j = paramJsBridgeListener.optInt("maxTime", 0);
        this.d.a(i, j);
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
      this.d.a(0);
      return true;
    }
    if ("play".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        this.b = paramJsBridgeListener.optString("callback", "");
        paramJsBridgeListener = paramJsBridgeListener.optString("recordID", "");
        this.d.a(paramJsBridgeListener);
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
        this.d.c(paramJsBridgeListener);
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
        this.d.b(paramJsBridgeListener);
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
        this.d.a(paramJsBridgeListener, paramString1, paramString2);
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
    boolean bool = this.d.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onDestroy() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool) {
      this.d.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin
 * JD-Core Version:    0.7.0.1
 */