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
  private int jdField_a_of_type_Int = 2147483647;
  ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN);
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  
  public WholePeoplePlugin()
  {
    this.mPluginNameSpace = "allpeoplevote";
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject = this.mRuntime.a();
    WebViewFragment localWebViewFragment = (WebViewFragment)this.mRuntime.a();
    if (localWebViewFragment != null)
    {
      ImageView localImageView = localWebViewFragment.mSwiftTitleUI.a;
      if (this.jdField_a_of_type_Int == 2147483647) {
        this.jdField_a_of_type_Int = localImageView.getPaddingRight();
      }
      if ((!paramBoolean1) || (TextUtils.isEmpty(paramString)))
      {
        localImageView.setVisibility(8);
        localImageView.setPadding(localImageView.getPaddingLeft(), localImageView.getPaddingTop(), this.jdField_a_of_type_Int, localImageView.getPaddingBottom());
        return;
      }
      localImageView.setImageResource(2130844971);
      int i;
      int k;
      if (localWebViewFragment.mSwiftTitleUI.b != null)
      {
        i = localWebViewFragment.mSwiftTitleUI.b.getCurrentTextColor();
        localImageView.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        if (QLog.isColorLevel()) {
          QLog.i("WholePeoplePlugin", 2, "titleColor:" + i);
        }
        localImageView.setVisibility(0);
        if (!paramBoolean2) {
          break label391;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) {
          this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch((Context)localObject, localImageView).b(53).a();
        }
        localObject = CampusCircleIpcClient.a().b();
        if (localObject == null) {
          break label374;
        }
        int j = ((Bundle)localObject).getInt("redPointCount", 0);
        k = ((Bundle)localObject).getInt("redNumCount", 0);
        if (k > 0) {
          break label353;
        }
        i = 0;
        label258:
        localObject = WholePeopleConstant.a(k, j);
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
        j = localImageView.getPaddingLeft();
        k = localImageView.getPaddingTop();
        int m = this.jdField_a_of_type_Int;
        localImageView.setPadding(j, k, AIOUtils.a(i, this.jdField_a_of_type_ComTencentSmttSdkWebView.getResources()) + m, localImageView.getPaddingBottom());
      }
      label391:
      for (;;)
      {
        localImageView.setOnClickListener(new WholePeoplePlugin.1(this, paramString));
        return;
        localImageView.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
        break;
        label353:
        if (k > 99)
        {
          i = 12;
          break label258;
        }
        i = 10;
        break label258;
        label374:
        if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
            this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
          }
        }
      }
    }
    QLog.e("WholePeoplePlugin", 1, "setRightButton, not support " + localObject);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    bool2 = false;
    boolean bool3 = true;
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("allpeoplevote")) || (paramString3 == null)) {
      bool1 = false;
    }
    label230:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
                return false;
              }
              if ((paramString3.equalsIgnoreCase("setRightButton")) && (paramVarArgs.length == 1))
              {
                for (;;)
                {
                  try
                  {
                    paramJsBridgeListener = this.mRuntime.a();
                    bool1 = bool3;
                    if (paramJsBridgeListener == null) {
                      break;
                    }
                    bool1 = bool3;
                    if (paramJsBridgeListener.isFinishing()) {
                      break;
                    }
                    paramString2 = new JSONObject(paramVarArgs[0]);
                    paramJsBridgeListener = paramString2.optString("callback");
                  }
                  catch (JSONException paramJsBridgeListener)
                  {
                    bool1 = bool3;
                  }
                  try
                  {
                    paramString1 = paramString2.optString("show");
                    paramString2 = paramString2.optString("showRedNum");
                    i = Integer.parseInt(paramString1);
                  }
                  catch (Exception paramString1)
                  {
                    i = 0;
                  }
                  try
                  {
                    j = Integer.parseInt(paramString2);
                    if (!QLog.isColorLevel()) {
                      break label328;
                    }
                    QLog.i("WholePeoplePlugin", 2, "setRightButton show=" + i + " showRedNum=" + j + " callback=" + paramJsBridgeListener);
                  }
                  catch (Exception paramString1)
                  {
                    do
                    {
                      break label230;
                    } while (i != 1);
                    bool1 = true;
                    if (j != 1) {
                      continue;
                    }
                    bool2 = true;
                    continue;
                  }
                  a(bool1, bool2, paramJsBridgeListener);
                  return true;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("WholePeoplePlugin", 2, "setRightButton error", paramJsBridgeListener);
                  return true;
                  j = 0;
                }
                bool1 = false;
                break label337;
              }
              bool1 = bool3;
            } while (!paramString3.equalsIgnoreCase("readRedPoint"));
            paramJsBridgeListener = this.mRuntime.a();
            bool1 = bool3;
          } while (paramJsBridgeListener == null);
          bool1 = bool3;
        } while (paramJsBridgeListener.isFinishing());
        CampusCircleIpcClient.a().b();
        bool1 = bool3;
      } while (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null);
      bool1 = bool3;
    } while (!this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c());
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
    return true;
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wholepeople.WholePeoplePlugin
 * JD-Core Version:    0.7.0.1
 */