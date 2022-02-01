package com.tencent.mobileqq.theme.diy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import anni;
import bdqf;
import bhhe;
import bhhf;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$10
  extends bhhe
{
  ThemeDIYActivity$10(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if ((parambhhf.a() == 3) && (parambhhf.a == 0)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      parambhhf = parambhhf.a();
      j = parambhhf.getInt("type");
      switch (j)
      {
      default: 
        return;
      }
    }
    this.this$0.loadResJson(j, true);
    return;
    bdqf localbdqf = this.this$0.saveStyleCallback;
    if (i != 0) {}
    for (i = 4;; i = 8)
    {
      localbdqf.callback(13, i, parambhhf, null);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    QLog.e("ThemeDIYActivity", 2, "DownloadListener onNetMobile2None...");
    this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 27, anni.a(2131713587)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.10
 * JD-Core Version:    0.7.0.1
 */