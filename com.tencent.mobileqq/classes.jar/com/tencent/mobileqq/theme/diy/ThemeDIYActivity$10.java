package com.tencent.mobileqq.theme.diy;

import ajyc;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import aymu;
import bbwf;
import bbwg;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$10
  extends bbwf
{
  ThemeDIYActivity$10(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if ((parambbwg.a() == 3) && (parambbwg.a == 0)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      parambbwg = parambbwg.a();
      j = parambbwg.getInt("type");
      switch (j)
      {
      default: 
        return;
      }
    }
    this.this$0.loadResJson(j, true);
    return;
    aymu localaymu = this.this$0.saveStyleCallback;
    if (i != 0) {}
    for (i = 4;; i = 8)
    {
      localaymu.callback(13, i, parambbwg, null);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    QLog.e("ThemeDIYActivity", 2, "DownloadListener onNetMobile2None...");
    this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 27, ajyc.a(2131714893)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.10
 * JD-Core Version:    0.7.0.1
 */