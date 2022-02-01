package com.tencent.mobileqq.flutter.qqface;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
public abstract interface QFlutterFaceLoader$FaceObserver
{
  public abstract void onFaceUpdate(DecodeRequest paramDecodeRequest, Bitmap paramBitmap, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader.FaceObserver
 * JD-Core Version:    0.7.0.1
 */