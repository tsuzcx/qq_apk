package com.tencent.qzonehub.api.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import com.tencent.qzonehub.api.IGifAntishakeApi;
import com.tencent.qzonehub.api.IGifAntishakeApi.postProgressListener;
import cooperation.qzone.util.GifAntishakeModule;
import java.util.ArrayList;

public class GifAntishakeApiImpl
  implements IGifAntishakeApi
{
  public boolean checkFolder(ArrayList<String> paramArrayList)
  {
    return GifAntishakeModule.getInstance().checkFolder(paramArrayList);
  }
  
  public ArrayList<String> getAntiShakeBitmapList(ArrayList<Bitmap> paramArrayList)
  {
    return GifAntishakeModule.getInstance().getAntiShakeBitmapList(paramArrayList);
  }
  
  public String getDhash(Bitmap paramBitmap)
  {
    return GifAntishakeModule.getDhash(paramBitmap);
  }
  
  public int getDistance(String paramString1, String paramString2)
  {
    return GifAntishakeModule.getDistance(paramString1, paramString2);
  }
  
  public int getMaxGifAntishakeFrameNum()
  {
    return GifAntishakeModule.getInstance().getMaxGifAntishakeFrameNum();
  }
  
  public void setAntishakeProgressListener(IGifAntishakeApi.postProgressListener parampostProgressListener)
  {
    GifAntishakeModule.getInstance().setAntishakeProgressListener(parampostProgressListener);
  }
  
  public boolean suitableForAntishake(ArrayList<String> paramArrayList, LruCache<Integer, BitmapDrawable> paramLruCache)
  {
    return GifAntishakeModule.getInstance().suitableForAntishake(paramArrayList, paramLruCache);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.GifAntishakeApiImpl
 * JD-Core Version:    0.7.0.1
 */