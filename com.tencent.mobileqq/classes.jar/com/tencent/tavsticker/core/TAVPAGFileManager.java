package com.tencent.tavsticker.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import java.io.File;
import org.libpag.PAGFile;

public class TAVPAGFileManager
{
  private static final int CACHE_SIZE = 10;
  private static final String TAG = "TAVPAGFileManager";
  private static volatile TAVPAGFileManager sInstance;
  private LruCache<String, PAGFile> mapPagFile = null;
  
  private void checkPAGFileMap()
  {
    if (this.mapPagFile == null) {
      this.mapPagFile = new LruCache(10);
    }
  }
  
  public static TAVPAGFileManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new TAVPAGFileManager();
        }
      }
      finally {}
    }
    return sInstance;
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
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = this.mapPagFile;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("android_asset://");
      localStringBuilder.append(paramString);
      localObject = (PAGFile)((LruCache)localObject).get(localStringBuilder.toString());
      if (localObject != null) {
        return localObject;
      }
      localObject = PAGFile.Load(paramContext.getAssets(), paramString);
      paramContext = (Context)localObject;
      if (localObject != null)
      {
        paramContext = this.mapPagFile;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("android_asset://");
        localStringBuilder.append(paramString);
        paramContext.put(localStringBuilder.toString(), localObject);
        return localObject;
      }
    }
    else
    {
      paramContext = null;
    }
    return paramContext;
  }
  
  public PAGFile getPAGFileFromByteArray(byte[] paramArrayOfByte)
  {
    checkPAGFileMap();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      return PAGFile.Load(paramArrayOfByte);
    }
    return null;
  }
  
  public PAGFile getPAGFileFromPath(String paramString)
  {
    checkPAGFileMap();
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = (PAGFile)this.mapPagFile.get(paramString);
      if (localObject != null) {
        return localObject;
      }
      if (new File(paramString).exists())
      {
        PAGFile localPAGFile = PAGFile.Load(paramString);
        localObject = localPAGFile;
        if (localPAGFile != null)
        {
          this.mapPagFile.put(paramString, localPAGFile);
          return localPAGFile;
        }
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVPAGFileManager
 * JD-Core Version:    0.7.0.1
 */