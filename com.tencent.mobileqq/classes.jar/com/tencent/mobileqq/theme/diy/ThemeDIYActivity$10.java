package com.tencent.mobileqq.theme.diy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import anzj;
import bejb;
import biht;
import bihu;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$10
  extends biht
{
  ThemeDIYActivity$10(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if ((parambihu.a() == 3) && (parambihu.a == 0)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      parambihu = parambihu.a();
      j = parambihu.getInt("type");
      switch (j)
      {
      default: 
        return;
      }
    }
    this.this$0.loadResJson(j, true);
    return;
    bejb localbejb = this.this$0.saveStyleCallback;
    if (i != 0) {}
    for (i = 4;; i = 8)
    {
      localbejb.callback(13, i, parambihu, null);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    QLog.e("ThemeDIYActivity", 2, "DownloadListener onNetMobile2None...");
    this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 27, anzj.a(2131713696)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.10
 * JD-Core Version:    0.7.0.1
 */