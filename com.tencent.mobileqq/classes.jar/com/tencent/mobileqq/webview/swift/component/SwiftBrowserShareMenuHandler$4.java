package com.tencent.mobileqq.webview.swift.component;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;

class SwiftBrowserShareMenuHandler$4
  implements DialogInterface.OnClickListener
{
  SwiftBrowserShareMenuHandler$4(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.excute(new SwiftBrowserShareMenuHandler.4.1(this), 128, null, false);
    SwiftBrowserShareMenuHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserShareMenuHandler, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.4
 * JD-Core Version:    0.7.0.1
 */