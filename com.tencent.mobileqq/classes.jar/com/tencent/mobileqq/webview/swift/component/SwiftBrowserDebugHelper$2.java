package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import android.widget.Toast;

class SwiftBrowserDebugHelper$2
  implements DialogInterface.OnClickListener
{
  SwiftBrowserDebugHelper$2(SwiftBrowserDebugHelper paramSwiftBrowserDebugHelper, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserDebugHelper.a.a().getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserDebugHelper.a.a().getApplicationContext(), 2131714488, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserDebugHelper.2
 * JD-Core Version:    0.7.0.1
 */