package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public class BroadCastPlugin
  extends WebViewPlugin
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public BroadCastPlugin()
  {
    this.mPluginNameSpace = "profileJS";
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "onAddTag");
    }
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("onTagChanged", true);
    return true;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934598L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934598L)
    {
      if (QLog.isColorLevel())
      {
        paramString = this.TAG;
        paramMap = new StringBuilder();
        paramMap.append("handleEvent finish or destroy. fromProfile:");
        paramMap.append(this.jdField_a_of_type_Boolean);
        QLog.i(paramString, 2, paramMap.toString());
      }
      paramString = this.jdField_a_of_type_JavaLangString;
      if ((paramString != null) && (!"".equals(paramString)) && (this.jdField_a_of_type_AndroidOsBundle != null))
      {
        paramString = new Intent();
        paramString.setAction(this.jdField_a_of_type_JavaLangString);
        paramMap = this.jdField_a_of_type_AndroidOsBundle;
        if (paramMap != null) {
          paramString.putExtra("key_bundle_data", paramMap);
        }
        this.mRuntime.a().sendBroadcast(paramString);
        this.jdField_a_of_type_AndroidOsBundle = null;
        if (this.jdField_a_of_type_Boolean)
        {
          paramString = new Intent(this.mRuntime.a(), PersonalityLabelGalleryActivity.class);
          paramString.putExtra("fromType", 3);
          paramString.putExtra("uin", this.mRuntime.a().getCurrentAccountUin());
          this.mRuntime.a().startActivity(paramString);
        }
      }
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString2 != null)
    {
      bool1 = bool2;
      if (paramString2.equalsIgnoreCase("profileJS"))
      {
        if (paramString3 == null) {
          return false;
        }
        bool1 = bool2;
        if (this.mRuntime != null)
        {
          if (this.mRuntime.a() == null) {
            return false;
          }
          if (paramString3.equals("onAddTag")) {
            return a(paramVarArgs);
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this.mRuntime.a();
    if (this.mRuntime.a().getIntent() != null)
    {
      this.jdField_a_of_type_JavaLangString = this.mRuntime.a().getIntent().getStringExtra("broadcastAction");
      this.jdField_a_of_type_Boolean = this.mRuntime.a().getIntent().getBooleanExtra("fromProfile", this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.BroadCastPlugin
 * JD-Core Version:    0.7.0.1
 */