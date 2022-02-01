package com.tencent.mobileqq.theme.diy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import anvx;
import beix;
import bhyn;
import bhyo;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$10
  extends bhyn
{
  ThemeDIYActivity$10(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if ((parambhyo.a() == 3) && (parambhyo.a == 0)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      parambhyo = parambhyo.a();
      j = parambhyo.getInt("type");
      switch (j)
      {
      default: 
        return;
      }
    }
    this.this$0.loadResJson(j, true);
    return;
    beix localbeix = this.this$0.saveStyleCallback;
    if (i != 0) {}
    for (i = 4;; i = 8)
    {
      localbeix.callback(13, i, parambhyo, null);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    QLog.e("ThemeDIYActivity", 2, "DownloadListener onNetMobile2None...");
    this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 27, anvx.a(2131714275)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.10
 * JD-Core Version:    0.7.0.1
 */