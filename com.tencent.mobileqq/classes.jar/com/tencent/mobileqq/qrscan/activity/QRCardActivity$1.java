package com.tencent.mobileqq.qrscan.activity;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

class QRCardActivity$1
  extends Handler
{
  QRCardActivity$1(QRCardActivity paramQRCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return;
    }
    if ((!this.a.a) && ((paramMessage.obj instanceof Bitmap)))
    {
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage != null)
      {
        this.a.d.setBackgroundResource(0);
        this.a.d.setImageBitmap(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.QRCardActivity.1
 * JD-Core Version:    0.7.0.1
 */