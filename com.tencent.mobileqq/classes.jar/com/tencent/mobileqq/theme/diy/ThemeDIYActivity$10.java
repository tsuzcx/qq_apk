package com.tencent.mobileqq.theme.diy;

import alud;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import bapb;
import bead;
import beae;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$10
  extends bead
{
  ThemeDIYActivity$10(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    if ((parambeae.a() == 3) && (parambeae.a == 0)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      parambeae = parambeae.a();
      j = parambeae.getInt("type");
      switch (j)
      {
      default: 
        return;
      }
    }
    this.this$0.loadResJson(j, true);
    return;
    bapb localbapb = this.this$0.saveStyleCallback;
    if (i != 0) {}
    for (i = 4;; i = 8)
    {
      localbapb.callback(13, i, parambeae, null);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    QLog.e("ThemeDIYActivity", 2, "DownloadListener onNetMobile2None...");
    this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 27, alud.a(2131715288)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.10
 * JD-Core Version:    0.7.0.1
 */