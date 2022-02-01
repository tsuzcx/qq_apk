package com.tencent.mobileqq.theme.diy;

import amtj;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import bdbx;
import bgod;
import bgoe;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$10
  extends bgod
{
  ThemeDIYActivity$10(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if ((parambgoe.a() == 3) && (parambgoe.a == 0)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      parambgoe = parambgoe.a();
      j = parambgoe.getInt("type");
      switch (j)
      {
      default: 
        return;
      }
    }
    this.this$0.loadResJson(j, true);
    return;
    bdbx localbdbx = this.this$0.saveStyleCallback;
    if (i != 0) {}
    for (i = 4;; i = 8)
    {
      localbdbx.callback(13, i, parambgoe, null);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    QLog.e("ThemeDIYActivity", 2, "DownloadListener onNetMobile2None...");
    this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 27, amtj.a(2131713928)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.10
 * JD-Core Version:    0.7.0.1
 */