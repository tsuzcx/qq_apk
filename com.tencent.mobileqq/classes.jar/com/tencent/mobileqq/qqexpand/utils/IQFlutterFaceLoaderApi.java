package com.tencent.mobileqq.qqexpand.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qqexpand.bean.common.Pair;
import com.tencent.mobileqq.qqexpand.bean.flutter.ApiDecodeRequest;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQFlutterFaceLoaderApi
  extends QRouteApi
{
  public abstract void addFaceObserver(IQFlutterFaceLoaderApi.ApiFaceObserver paramApiFaceObserver);
  
  public abstract void clearCache();
  
  public abstract Pair<Bitmap, Boolean> getBitmap(ApiDecodeRequest paramApiDecodeRequest);
  
  public abstract void onDestroy();
  
  public abstract void removeFaceObserver(IQFlutterFaceLoaderApi.ApiFaceObserver paramApiFaceObserver);
  
  public abstract void setContext(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.IQFlutterFaceLoaderApi
 * JD-Core Version:    0.7.0.1
 */