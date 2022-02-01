package com.tencent.qidian;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

class QidianProfileCardActivity$UiHandler
  extends Handler
{
  QidianProfileCardActivity$UiHandler(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {}
    try
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.a.getResources(), this.a.f);
      this.a.a.setBackgroundDrawable(localBitmapDrawable);
      label43:
      super.handleMessage(paramMessage);
      return;
    }
    catch (Exception localException)
    {
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.UiHandler
 * JD-Core Version:    0.7.0.1
 */