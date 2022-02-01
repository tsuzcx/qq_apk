package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.common.util.FileChooserHelper;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;

public class SwiftFileChooseHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  protected FileChooserHelper a;
  
  public void a(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper == null) {
      this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper = new FileChooserHelper();
    }
    this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), 0, paramValueCallback, paramString1, paramString2);
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    FileChooserHelper localFileChooserHelper = this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper;
    return (localFileChooserHelper != null) && (localFileChooserHelper.a(paramInt1, paramInt2, paramIntent));
  }
  
  public boolean a(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if (this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper == null) {
      this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper = new FileChooserHelper();
    }
    return this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), 0, paramValueCallback, paramFileChooserParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftFileChooseHandler
 * JD-Core Version:    0.7.0.1
 */