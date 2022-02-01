package com.tencent.qzonehub.api;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IGifAntishakeApi
  extends QRouteApi
{
  public abstract boolean checkFolder(ArrayList<String> paramArrayList);
  
  public abstract ArrayList<String> getAntiShakeBitmapList(ArrayList<Bitmap> paramArrayList);
  
  public abstract String getDhash(Bitmap paramBitmap);
  
  public abstract int getDistance(String paramString1, String paramString2);
  
  public abstract int getMaxGifAntishakeFrameNum();
  
  public abstract void setAntishakeProgressListener(IGifAntishakeApi.postProgressListener parampostProgressListener);
  
  public abstract boolean suitableForAntishake(ArrayList<String> paramArrayList, LruCache<Integer, BitmapDrawable> paramLruCache);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IGifAntishakeApi
 * JD-Core Version:    0.7.0.1
 */