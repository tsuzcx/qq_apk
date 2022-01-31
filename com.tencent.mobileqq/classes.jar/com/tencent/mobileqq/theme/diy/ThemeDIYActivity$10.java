package com.tencent.mobileqq.theme.diy;

import ajya;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import aymw;
import bbwt;
import bbwu;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$10
  extends bbwt
{
  ThemeDIYActivity$10(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if ((parambbwu.a() == 3) && (parambbwu.a == 0)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      parambbwu = parambbwu.a();
      j = parambbwu.getInt("type");
      switch (j)
      {
      default: 
        return;
      }
    }
    this.this$0.loadResJson(j, true);
    return;
    aymw localaymw = this.this$0.saveStyleCallback;
    if (i != 0) {}
    for (i = 4;; i = 8)
    {
      localaymw.callback(13, i, parambbwu, null);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    QLog.e("ThemeDIYActivity", 2, "DownloadListener onNetMobile2None...");
    this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 27, ajya.a(2131714904)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.10
 * JD-Core Version:    0.7.0.1
 */