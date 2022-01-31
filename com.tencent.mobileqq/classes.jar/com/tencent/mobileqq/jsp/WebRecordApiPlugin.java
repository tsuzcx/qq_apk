package com.tencent.mobileqq.jsp;

import arpb;
import bcdp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class WebRecordApiPlugin
  extends WebViewPlugin
{
  private arpb jdField_a_of_type_Arpb;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public WebRecordApiPlugin()
  {
    this.mPluginNameSpace = "webRecord";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"webRecord".equals(paramString2)) {
      return false;
    }
    if (this.jdField_a_of_type_Arpb == null) {
      this.jdField_a_of_type_Arpb = new arpb(this, this.mRuntime.a(), (BaseActivity)this.mRuntime.a());
    }
    if ("startRecord".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        this.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("callback", "");
        int i = paramJsBridgeListener.optInt("format", 0);
        int j = paramJsBridgeListener.optInt("maxTime", 0);
        this.jdField_a_of_type_Arpb.a(i, j);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
          }
        }
      }
    }
    if ("stopRecord".equals(paramString3))
    {
      this.jdField_a_of_type_Arpb.b(0);
      return true;
    }
    if ("play".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        this.b = paramJsBridgeListener.optString("callback", "");
        paramJsBridgeListener = paramJsBridgeListener.optString("recordID", "");
        this.jdField_a_of_type_Arpb.b(paramJsBridgeListener);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
          }
        }
      }
    }
    if ("pause".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("recordID", "");
        this.jdField_a_of_type_Arpb.d(paramJsBridgeListener);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
          }
        }
      }
    }
    if ("stop".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("recordID", "");
        this.jdField_a_of_type_Arpb.c(paramJsBridgeListener);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
          }
        }
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
        this.jdField_a_of_type_Arpb.a(paramJsBridgeListener, paramString1, paramString2);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
          }
        }
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    boolean bool = this.jdField_a_of_type_Arpb.a();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_Arpb.b(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin
 * JD-Core Version:    0.7.0.1
 */