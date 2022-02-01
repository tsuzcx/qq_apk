package com.tencent.mobileqq.webprocess.temp.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;

class WebviewApiImpl$2
  implements DialogInterface.OnClickListener
{
  WebviewApiImpl$2(WebviewApiImpl paramWebviewApiImpl, SwiftBrowserComponentsProvider.SwiftBrowserComponentContext paramSwiftBrowserComponentContext, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getApplicationContext(), HardCodeUtil.a(2131714569), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.temp.api.impl.WebviewApiImpl.2
 * JD-Core Version:    0.7.0.1
 */