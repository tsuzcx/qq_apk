package com.tencent.mobileqq.troop.utils;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class RollangleImageView$ImageCache$2
  extends Handler
{
  RollangleImageView$ImageCache$2(RollangleImageView.ImageCache paramImageCache, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.a) {
      return;
    }
    Object localObject = (Object[])paramMessage.obj;
    paramMessage = (RollangleImageView)localObject[0];
    String str = (String)localObject[1];
    localObject = (Bitmap)localObject[2];
    if ((paramMessage != null) && (str != null) && (localObject != null) && (str.equals(paramMessage.b))) {
      paramMessage.setImageBitmap((Bitmap)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView.ImageCache.2
 * JD-Core Version:    0.7.0.1
 */