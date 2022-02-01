package com.tencent.mobileqq.webview.swift;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class WebViewFragment$16
  implements DialogInterface.OnClickListener
{
  WebViewFragment$16(WebViewFragment paramWebViewFragment, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.startActivity(this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment.16
 * JD-Core Version:    0.7.0.1
 */