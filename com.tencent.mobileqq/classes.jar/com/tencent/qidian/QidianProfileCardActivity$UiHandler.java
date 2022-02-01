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
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      try
      {
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.a.getResources(), this.a.jdField_a_of_type_AndroidGraphicsBitmap);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localBitmapDrawable);
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.UiHandler
 * JD-Core Version:    0.7.0.1
 */