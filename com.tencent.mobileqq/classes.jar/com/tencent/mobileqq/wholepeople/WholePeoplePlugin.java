package com.tencent.mobileqq.wholepeople;

import android.app.Activity;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.campuscircle.CampusCircleIpcClient;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class WholePeoplePlugin
  extends WebViewPlugin
{
  ColorFilter a = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN);
  private WebView b;
  private RedTouch c;
  private int d = 2147483647;
  
  public WholePeoplePlugin()
  {
    this.mPluginNameSpace = "allpeoplevote";
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject1 = this.mRuntime.d();
    Object localObject2 = (WebViewFragment)this.mRuntime.f();
    if (localObject2 != null)
    {
      ImageView localImageView = ((WebViewFragment)localObject2).getSwiftTitleUI().h;
      if (this.d == 2147483647) {
        this.d = localImageView.getPaddingRight();
      }
      if ((paramBoolean1) && (!TextUtils.isEmpty(paramString)))
      {
        localImageView.setImageResource(2130846281);
        if (((WebViewFragment)localObject2).getSwiftTitleUI().e != null)
        {
          i = ((WebViewFragment)localObject2).getSwiftTitleUI().e.getCurrentTextColor();
          localImageView.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("titleColor:");
            ((StringBuilder)localObject2).append(i);
            QLog.i("WholePeoplePlugin", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          localImageView.setColorFilter(this.a);
        }
        int i = 0;
        localImageView.setVisibility(0);
        if (paramBoolean2)
        {
          if (this.c == null) {
            this.c = new RedTouch((Context)localObject1, localImageView).c(53).a();
          }
          localObject1 = CampusCircleIpcClient.a().d();
          if (localObject1 != null)
          {
            int j = ((Bundle)localObject1).getInt("redPointCount", 0);
            int k = ((Bundle)localObject1).getInt("redNumCount", 0);
            if (k > 0) {
              if (k > 99) {
                i = 12;
              } else {
                i = 10;
              }
            }
            localObject1 = WholePeopleConstant.a(k, j);
            this.c.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
            localImageView.setPadding(localImageView.getPaddingLeft(), localImageView.getPaddingTop(), this.d + AIOUtils.b(i, this.b.getResources()), localImageView.getPaddingBottom());
          }
          else
          {
            localObject1 = this.c;
            if (localObject1 != null) {
              ((RedTouch)localObject1).g();
            }
          }
        }
        else
        {
          localObject1 = this.c;
          if (localObject1 != null) {
            ((RedTouch)localObject1).g();
          }
        }
        localImageView.setOnClickListener(new WholePeoplePlugin.1(this, paramString));
        return;
      }
      localImageView.setVisibility(8);
      localImageView.setPadding(localImageView.getPaddingLeft(), localImageView.getPaddingTop(), this.d, localImageView.getPaddingBottom());
      return;
    }
    paramString = new StringBuilder();
    paramString.append("setRightButton, not support ");
    paramString.append(localObject1);
    QLog.e("WholePeoplePlugin", 1, paramString.toString());
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    bool2 = false;
    if ((paramString2 != null) && (paramString2.equalsIgnoreCase("allpeoplevote")))
    {
      if (paramString3 == null) {
        return false;
      }
      if (this.mRuntime != null)
      {
        if (this.mRuntime.d() == null) {
          return false;
        }
        if ((paramString3.equalsIgnoreCase("setRightButton")) && (paramVarArgs.length == 1)) {
          try
          {
            paramJsBridgeListener = this.mRuntime.d();
            if (paramJsBridgeListener != null)
            {
              if (paramJsBridgeListener.isFinishing()) {
                return true;
              }
              paramString2 = new JSONObject(paramVarArgs[0]);
              paramJsBridgeListener = paramString2.optString("callback");
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            label128:
            label131:
            label203:
            if (!QLog.isColorLevel()) {}
          }
        }
      }
    }
    try
    {
      paramString1 = paramString2.optString("show");
      paramString2 = paramString2.optString("showRedNum");
      i = Integer.parseInt(paramString1);
    }
    catch (Exception paramString1)
    {
      break label128;
    }
    try
    {
      j = Integer.parseInt(paramString2);
    }
    catch (Exception paramString1)
    {
      break label131;
      if (i != 1) {
        break label320;
      }
      bool1 = true;
      break label323;
      bool1 = false;
      if (j != 1) {
        break label203;
      }
      bool2 = true;
      break label203;
    }
    i = 0;
    j = 0;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("setRightButton show=");
      paramString1.append(i);
      paramString1.append(" showRedNum=");
      paramString1.append(j);
      paramString1.append(" callback=");
      paramString1.append(paramJsBridgeListener);
      QLog.i("WholePeoplePlugin", 2, paramString1.toString());
      break label308;
      a(bool1, bool2, paramJsBridgeListener);
      return true;
      return true;
      QLog.d("WholePeoplePlugin", 2, "setRightButton error", paramJsBridgeListener);
      return true;
      if (paramString3.equalsIgnoreCase("readRedPoint"))
      {
        paramJsBridgeListener = this.mRuntime.d();
        if (paramJsBridgeListener != null)
        {
          if (paramJsBridgeListener.isFinishing()) {
            return true;
          }
          CampusCircleIpcClient.a().e();
          paramJsBridgeListener = this.c;
          if ((paramJsBridgeListener != null) && (paramJsBridgeListener.h())) {
            this.c.g();
          }
        }
      }
      return true;
      return false;
    }
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.b = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.wholepeople.WholePeoplePlugin
 * JD-Core Version:    0.7.0.1
 */