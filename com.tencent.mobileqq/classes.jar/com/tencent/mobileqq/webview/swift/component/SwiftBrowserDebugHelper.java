package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;

public class SwiftBrowserDebugHelper
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  private static boolean jdField_a_of_type_Boolean = false;
  private int jdField_a_of_type_Int = -1;
  private final ArrayList<SwiftBrowserDebugHelper.JsApiInvokeRecord> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private int b = -1;
  
  private boolean a()
  {
    if (-1 == this.jdField_a_of_type_Int) {
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getSharedPreferences("envSwitch", 4).getBoolean("webview_jsapi_trace_switch", false)) {
        break label51;
      }
    }
    label51:
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      if (1 != this.jdField_a_of_type_Int) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private boolean b()
  {
    if (-1 == this.b) {
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getSharedPreferences("envSwitch", 4).getBoolean("webview_cost_statistics_switch", false)) {
        break label51;
      }
    }
    label51:
    for (int i = 1;; i = 0)
    {
      this.b = i;
      if (1 != this.b) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void c()
  {
    if (a())
    {
      Object localObject1 = new StringBuilder("页面地址:\r\n" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getUrl() + "\r\n\r\n");
      ((StringBuilder)localObject1).append("白名单发布版本号:").append(AuthorizeConfig.a().a()).append("\r\n\r\n");
      ((StringBuilder)localObject1).append("JsAPI调用记录:\r\n");
      Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append(((SwiftBrowserDebugHelper.JsApiInvokeRecord)((Iterator)localObject2).next()).toString());
        ((StringBuilder)localObject1).append("\r\n");
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), 230);
      ((QQCustomDialog)localObject2).setContentView(((IWebviewApi)QRoute.api(IWebviewApi.class)).getWebViewDialogMultiLineLayout());
      ((QQCustomDialog)localObject2).getMessageTextView().setMovementMethod(ScrollingMovementMethod.getInstance());
      ((QQCustomDialog)localObject2).setTitle(2131714574);
      ((QQCustomDialog)localObject2).setMessage((CharSequence)localObject1);
      ((QQCustomDialog)localObject2).getMessageTextView().setMaxLines(20);
      ((QQCustomDialog)localObject2).getMessageTextView().setEllipsize(TextUtils.TruncateAt.END);
      ((QQCustomDialog)localObject2).setPositiveButton("Close", new SwiftBrowserDebugHelper.1(this));
      ((QQCustomDialog)localObject2).setNegativeButton("Copy", new SwiftBrowserDebugHelper.2(this, (String)localObject1));
      ((QQCustomDialog)localObject2).show();
    }
  }
  
  public void a()
  {
    if (b()) {
      ((IWebviewApi)QRoute.api(IWebviewApi.class)).showPerformanceDialogWhenDebugMode(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (7 == paramInt)
    {
      c();
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserDebugHelper
 * JD-Core Version:    0.7.0.1
 */