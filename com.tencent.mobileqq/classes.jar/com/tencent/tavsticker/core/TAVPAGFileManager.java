package com.tencent.tavsticker.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import java.io.File;
import org.libpag.PAGFile;

public class TAVPAGFileManager
{
  private static final int CACHE_SIZE = 10;
  private static final String TAG = TAVPAGFileManager.class.getSimpleName();
  private static volatile TAVPAGFileManager sInstance = null;
  private LruCache<String, PAGFile> mapPagFile = null;
  
  private void checkPAGFileMap()
  {
    if (this.mapPagFile == null) {
      this.mapPagFile = new LruCache(10);
    }
  }
  
  public static TAVPAGFileManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new TAVPAGFileManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void clearCache()
  {
    try
    {
      checkPAGFileMap();
      this.mapPagFile.evictAll();
      System.gc();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public PAGFile getPAGFileFromAsset(Context paramContext, String paramString)
  {
    checkPAGFileMap();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramContext != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = (PAGFile)this.mapPagFile.get("android_asset://" + paramString);
        if (localObject1 == null) {
          break label60;
        }
      }
    }
    label60:
    do
    {
      return localObject1;
      paramContext = PAGFile.Load(paramContext.getAssets(), paramString);
      localObject1 = paramContext;
    } while (paramContext == null);
    this.mapPagFile.put("android_asset://" + paramString, paramContext);
    return paramContext;
  }
  
  public PAGFile getPAGFileFromByteArray(byte[] paramArrayOfByte)
  {
    checkPAGFileMap();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfByte != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfByte.length > 0) {
        localObject1 = PAGFile.Load(paramArrayOfByte);
      }
    }
    return localObject1;
  }
  
  public PAGFile getPAGFileFromPath(String paramString)
  {
    checkPAGFileMap();
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = (PAGFile)this.mapPagFile.get(paramString);
      if (localObject == null) {
        break label31;
      }
    }
    label31:
    PAGFile localPAGFile;
    do
    {
      do
      {
        return localObject;
      } while (!new File(paramString).exists());
      localPAGFile = PAGFile.Load(paramString);
      localObject = localPAGFile;
    } while (localPAGFile == null);
    this.mapPagFile.put(paramString, localPAGFile);
    return localPAGFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVPAGFileManager
 * JD-Core Version:    0.7.0.1
 */