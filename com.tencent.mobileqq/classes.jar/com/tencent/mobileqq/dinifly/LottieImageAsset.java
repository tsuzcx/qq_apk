package com.tencent.mobileqq.dinifly;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class LottieImageAsset
{
  @Nullable
  private Bitmap bitmap;
  private final String dirName;
  private final String fileName;
  private final int height;
  private final String id;
  private String key;
  public MQLruCache<String, Object> sImageCache;
  public long size;
  private final int width;
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public LottieImageAsset(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.id = paramString1;
    this.fileName = paramString2;
    this.dirName = paramString3;
  }
  
  public static void decodeBitmapIntoCache(MQLruCache<String, Object> paramMQLruCache, String paramString1, String paramString2)
  {
    if (paramMQLruCache == null)
    {
      paramMQLruCache = new StringBuilder();
      paramMQLruCache.append("image cache is null");
      paramMQLruCache.append(paramString1);
      Log.e("LottieImageAsset", paramMQLruCache.toString());
      return;
    }
    if (paramMQLruCache.get(paramString1) != null)
    {
      paramMQLruCache = new StringBuilder();
      paramMQLruCache.append("cache has this bitmap: ");
      paramMQLruCache.append(paramString1);
      Log.d("LottieImageAsset", paramMQLruCache.toString());
      return;
    }
    paramMQLruCache.put(paramString1, decodeStream(paramString2));
  }
  
  public static Bitmap decodeStream(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject3 = null;
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    Object localObject4 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject4).inDensity = DiniFlyAnimationView.inDensity;
    ((BitmapFactory.Options)localObject4).inDensity = DiniFlyAnimationView.inTargetDensity;
    localObject2 = localObject3;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      localObject2 = localObject3;
      try
      {
        localObject4 = BitmapFactory.decodeStream(new BufferedInputStream(localFileInputStream), null, (BitmapFactory.Options)localObject4);
        localObject1 = localObject4;
      }
      catch (Exception localException)
      {
        localObject2 = localObject3;
        localStringBuilder2 = new StringBuilder();
        localObject2 = localObject3;
        localStringBuilder2.append("lottie, IllegalArgumentException= ");
        localObject2 = localObject3;
        localStringBuilder2.append(localException.getMessage());
        localObject2 = localObject3;
        Log.e("LottieImageAsset", localStringBuilder2.toString());
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject2 = localObject3;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localObject2 = localObject3;
        localStringBuilder2.append("lottie, oom ");
        localObject2 = localObject3;
        localStringBuilder2.append(localOutOfMemoryError.getMessage());
        localObject2 = localObject3;
        Log.e("LottieImageAsset", localStringBuilder2.toString());
      }
      localObject2 = localObject1;
      try
      {
        localFileInputStream.close();
        return localObject1;
      }
      catch (IOException localIOException)
      {
        localObject2 = localObject1;
        localIOException.printStackTrace();
        return localObject1;
      }
      StringBuilder localStringBuilder1;
      return localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("lottie, file not found -> ");
      localStringBuilder1.append(paramString);
      Log.e("LottieImageAsset", localStringBuilder1.toString());
      localFileNotFoundException.printStackTrace();
    }
  }
  
  @Nullable
  public Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public String getDirName()
  {
    return this.dirName;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean hasCache()
  {
    return TextUtils.isEmpty(this.id) ^ true;
  }
  
  public void setBitmap(@Nullable Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieImageAsset
 * JD-Core Version:    0.7.0.1
 */