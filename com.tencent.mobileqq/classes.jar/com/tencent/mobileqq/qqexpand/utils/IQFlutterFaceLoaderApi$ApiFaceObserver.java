package com.tencent.mobileqq.qqexpand.utils;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qqexpand.bean.flutter.ApiDecodeRequest;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
public abstract interface IQFlutterFaceLoaderApi$ApiFaceObserver
{
  public abstract void onFaceUpdate(ApiDecodeRequest paramApiDecodeRequest, Bitmap paramBitmap, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.IQFlutterFaceLoaderApi.ApiFaceObserver
 * JD-Core Version:    0.7.0.1
 */