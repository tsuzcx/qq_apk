package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.view.View;
import bkho;
import bkhw;
import com.tencent.qphone.base.util.QLog;

class ContactJsPlugin$2$1
  implements bkhw
{
  ContactJsPlugin$2$1(ContactJsPlugin.2 param2, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    try
    {
      paramView = this.this$1.this$0;
      String str1 = this.this$1.val$eventName;
      String str2 = this.this$1.val$jsonParams;
      if (paramInt == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ContactJsPlugin.access$000(paramView, str1, str2, bool);
        this.val$actionSheet.dismiss();
        return;
      }
      return;
    }
    catch (Exception paramView)
    {
      QLog.e(ContactJsPlugin.access$100(), 1, this.this$1.val$eventName + " error.", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ContactJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */