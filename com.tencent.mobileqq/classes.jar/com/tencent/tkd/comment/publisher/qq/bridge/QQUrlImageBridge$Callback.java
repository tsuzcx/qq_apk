package com.tencent.tkd.comment.publisher.qq.bridge;

import android.graphics.Bitmap;

public abstract interface QQUrlImageBridge$Callback
{
  public abstract void onFail();
  
  public abstract void onSuccess(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge.Callback
 * JD-Core Version:    0.7.0.1
 */