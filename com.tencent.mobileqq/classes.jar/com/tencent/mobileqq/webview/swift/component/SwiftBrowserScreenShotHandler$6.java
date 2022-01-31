package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import beed;
import bepp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ndi;
import sdq;
import xxb;

public class SwiftBrowserScreenShotHandler$6
  implements Runnable
{
  public SwiftBrowserScreenShotHandler$6(beed parambeed, String paramString, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    String str = ndi.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    boolean bool2 = beed.a(this.this$0).a().isShowing();
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(this.this$0.b))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "doMultiShare download Finish!");
        QLog.d("SwiftBrowserScreenShotHandler", 2, "isGif:" + this.jdField_a_of_type_Boolean + ", imgUrl:" + this.jdField_a_of_type_JavaLangString);
        QLog.d("SwiftBrowserScreenShotHandler", 2, "isLastMultiShare:" + bool1 + ", mLastMultiShareUrl:" + this.this$0.b);
        QLog.d("SwiftBrowserScreenShotHandler", 2, "isDialogShowing:" + bool2 + ", localPath:" + str);
      }
      if ((bool2) && (bool1))
      {
        this.this$0.jdField_a_of_type_AndroidOsHandler.post(new SwiftBrowserScreenShotHandler.6.1(this));
        if (TextUtils.isEmpty(str)) {
          break label289;
        }
        this.this$0.jdField_a_of_type_JavaLangString = str;
        beed.a(this.this$0).a(3);
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        beed.a(this.this$0).d(this.this$0.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.post(new SwiftBrowserScreenShotHandler.6.2(this));
    return;
    label289:
    xxb.a(1, 2131695748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.6
 * JD-Core Version:    0.7.0.1
 */