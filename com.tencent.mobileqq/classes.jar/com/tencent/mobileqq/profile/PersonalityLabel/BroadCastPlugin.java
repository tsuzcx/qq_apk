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
  private WebView a;
  private String b = null;
  private boolean c = false;
  private Bundle d;
  
  public BroadCastPlugin()
  {
    this.mPluginNameSpace = "profileJS";
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.mTAG, 2, "onAddTag");
    }
    if (this.d == null) {
      this.d = new Bundle();
    }
    this.d.putBoolean("onTagChanged", true);
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
        paramString = this.mTAG;
        paramMap = new StringBuilder();
        paramMap.append("handleEvent finish or destroy. fromProfile:");
        paramMap.append(this.c);
        QLog.i(paramString, 2, paramMap.toString());
      }
      paramString = this.b;
      if ((paramString != null) && (!"".equals(paramString)) && (this.d != null))
      {
        paramString = new Intent();
        paramString.setAction(this.b);
        paramMap = this.d;
        if (paramMap != null) {
          paramString.putExtra("key_bundle_data", paramMap);
        }
        this.mRuntime.d().sendBroadcast(paramString);
        this.d = null;
        if (this.c)
        {
          paramString = new Intent(this.mRuntime.d(), PersonalityLabelGalleryActivity.class);
          paramString.putExtra("fromType", 3);
          paramString.putExtra("uin", this.mRuntime.b().getCurrentAccountUin());
          this.mRuntime.d().startActivity(paramString);
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
          if (this.mRuntime.d() == null) {
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
    this.a = this.mRuntime.a();
    if (this.mRuntime.d().getIntent() != null)
    {
      this.b = this.mRuntime.d().getIntent().getStringExtra("broadcastAction");
      this.c = this.mRuntime.d().getIntent().getBooleanExtra("fromProfile", this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.BroadCastPlugin
 * JD-Core Version:    0.7.0.1
 */