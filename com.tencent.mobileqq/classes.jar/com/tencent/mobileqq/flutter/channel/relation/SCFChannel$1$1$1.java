package com.tencent.mobileqq.flutter.channel.relation;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import io.flutter.plugin.common.MethodChannel.Result;

class SCFChannel$1$1$1
  implements Runnable
{
  SCFChannel$1$1$1(SCFChannel.1.1 param1) {}
  
  public void run()
  {
    this.a.c.success(null);
    int i;
    if (this.a.b.booleanValue()) {
      i = 2131897334;
    } else {
      i = 2131897333;
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), 2, i, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.1.1
 * JD-Core Version:    0.7.0.1
 */