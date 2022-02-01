package com.tencent.mobileqq.search.activity;

import android.os.Handler;
import android.os.Message;

class UniteSearchActivity$10
  extends Handler
{
  UniteSearchActivity$10(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 101)
    {
      UniteSearchActivity.a(this.a, 3);
      this.a.h();
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.10
 * JD-Core Version:    0.7.0.1
 */