package com.tencent.mobileqq.theme.diy;

import ajjy;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import axmn;
import batl;
import batm;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$10
  extends batl
{
  ThemeDIYActivity$10(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if ((parambatm.a() == 3) && (parambatm.a == 0)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      parambatm = parambatm.a();
      j = parambatm.getInt("type");
      switch (j)
      {
      default: 
        return;
      }
    }
    this.this$0.loadResJson(j, true);
    return;
    axmn localaxmn = this.this$0.saveStyleCallback;
    if (i != 0) {}
    for (i = 4;; i = 8)
    {
      localaxmn.callback(13, i, parambatm, null);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    QLog.e("ThemeDIYActivity", 2, "DownloadListener onNetMobile2None...");
    this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 27, ajjy.a(2131649104)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.10
 * JD-Core Version:    0.7.0.1
 */