package com.tencent.mobileqq.dinifly;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

public class LottieImageAsset
{
  public static MQLruCache<String, Object> sImageCache;
  private final String fileName;
  private String filePath;
  private final int height;
  private final String id;
  private String key;
  public long size;
  private final int width;
  
  private LottieImageAsset(int paramInt1, int paramInt2, String paramString1, String paramString2, Resources paramResources, Bundle paramBundle)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.id = paramString1;
    this.fileName = paramString2;
    this.key = "";
    this.filePath = "";
    if (paramBundle != null)
    {
      String str = paramBundle.getString("key");
      paramBundle = paramBundle.getString("path");
      this.key = (str + paramString1);
      this.filePath = (paramBundle + paramString2);
      decodeBitmapIntoCache(paramResources, this.key, this.filePath);
      paramString1 = sImageCache.get(this.key);
      if ((paramString1 instanceof Bitmap)) {
        this.size = ((Bitmap)paramString1).getByteCount();
      }
    }
  }
  
  public static void decodeBitmapIntoCache(Resources paramResources, String paramString1, String paramString2)
  {
    if (sImageCache == null)
    {
      Log.e("LottieImageAsset", "image cache is null" + paramString1);
      return;
    }
    if (sImageCache.get(paramString1) != null)
    {
      Log.d("LottieImageAsset", "cache has this bitmap: " + paramString1);
      return;
    }
    paramResources = decodeStream(paramResources, paramString2);
    sImageCache.put(paramString1, paramResources);
  }
  
  public static Bitmap decodeStream(Resources paramResources, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject3 = new BitmapFactory.Options();
    if (paramResources.getDisplayMetrics().density < 320.0F) {}
    for (((BitmapFactory.Options)localObject3).inDensity = 160;; ((BitmapFactory.Options)localObject3).inDensity = 320)
    {
      ((BitmapFactory.Options)localObject3).inTargetDensity = paramResources.getDisplayMetrics().densityDpi;
      if (((BitmapFactory.Options)localObject3).inDensity < ((BitmapFactory.Options)localObject3).inTargetDensity) {
        ((BitmapFactory.Options)localObject3).inDensity = ((BitmapFactory.Options)localObject3).inTargetDensity;
      }
      Object localObject2 = null;
      paramResources = null;
      localObject1 = localObject2;
      try
      {
        localFileInputStream = new FileInputStream(paramString);
        localObject1 = localObject2;
      }
      catch (FileNotFoundException paramResources)
      {
        FileInputStream localFileInputStream;
        label112:
        Log.e("LottieImageAsset", "lottie, file not found -> " + paramString);
        paramResources.printStackTrace();
        return localObject1;
      }
      try
      {
        localObject3 = BitmapFactory.decodeStream(new BufferedInputStream(localFileInputStream), null, (BitmapFactory.Options)localObject3);
        paramResources = (Resources)localObject3;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject1 = localIOException;
        Log.e("LottieImageAsset", "lottie, oom " + localOutOfMemoryError.getMessage());
        break label112;
      }
      catch (Exception localException)
      {
        localObject1 = localIOException;
        Log.e("LottieImageAsset", "lottie, IllegalArgumentException= " + localException.getMessage());
        if (0 == 0) {
          break label112;
        }
        localObject1 = localIOException;
        new StringBuilder().append("lottie, bitmap width=");
        localObject1 = localIOException;
        throw new NullPointerException();
      }
      localObject1 = paramResources;
      try
      {
        localFileInputStream.close();
        return paramResources;
      }
      catch (IOException localIOException)
      {
        localObject1 = paramResources;
        localIOException.printStackTrace();
        return paramResources;
      }
    }
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
    return !TextUtils.isEmpty(this.key);
  }
  
  static class Factory
  {
    static LottieImageAsset newInstance(Resources paramResources, JSONObject paramJSONObject, Bundle paramBundle)
    {
      return new LottieImageAsset(paramJSONObject.optInt("w"), paramJSONObject.optInt("h"), paramJSONObject.optString("id"), paramJSONObject.optString("p"), paramResources, paramBundle, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieImageAsset
 * JD-Core Version:    0.7.0.1
 */