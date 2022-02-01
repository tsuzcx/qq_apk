package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;
import java.io.File;

class SwiftBrowserLongClickHandler$4
  implements Runnable
{
  SwiftBrowserLongClickHandler$4(SwiftBrowserLongClickHandler paramSwiftBrowserLongClickHandler, String paramString) {}
  
  public void run()
  {
    ??? = new Bundle();
    if (this.this$0.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
    {
      this.this$0.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
      this.this$0.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
    }
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie(this.a);
    if (localObject2 != null)
    {
      ((Bundle)???).putString("Cookie", (String)localObject2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Get cookie: ");
        localStringBuilder.append(Util.c((String)localObject2, new String[0]));
        localStringBuilder.append(" from ");
        localStringBuilder.append(Util.b(this.a, new String[0]));
        QLog.d("SwiftBrowserLongClickHandler", 2, localStringBuilder.toString());
      }
    }
    ??? = ImageUtil.a(BaseApplication.getContext(), this.a, (Bundle)???);
    this.this$0.jdField_b_of_type_JavaLangString = ((String)???);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("saveImage filepath = ");
      ((StringBuilder)localObject2).append(this.this$0.jdField_b_of_type_JavaLangString);
      QLog.d("SwiftBrowserLongClickHandler", 2, ((StringBuilder)localObject2).toString());
    }
    if (??? == null)
    {
      this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SwiftBrowserLongClickHandler.4.1(this));
      return;
    }
    if (this.this$0.jdField_b_of_type_Int == 0)
    {
      this.this$0.b((String)???);
      this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SwiftBrowserLongClickHandler.4.2(this));
      return;
    }
    if (this.this$0.jdField_b_of_type_Int == 1)
    {
      this.this$0.a((String)???);
      return;
    }
    if (this.this$0.jdField_b_of_type_Int == 2)
    {
      this.this$0.c((String)???);
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("file://");
    ((StringBuilder)localObject2).append(new File((String)???).getAbsolutePath());
    ??? = Uri.parse(((StringBuilder)localObject2).toString());
    localObject2 = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile((Uri)???, this.this$0.jdField_a_of_type_AndroidAppActivity, 3, false);
    if (localObject2 != null) {
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.this$0.c = this.this$0.jdField_b_of_type_JavaLangString;
        this.this$0.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult = ((ScannerResult)localObject2);
        if (this.this$0.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
        {
          this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SwiftBrowserLongClickHandler.4.3(this, (ScannerResult)localObject2));
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4
 * JD-Core Version:    0.7.0.1
 */