package com.tencent.sonic.sdk.download;

import android.text.TextUtils;
import com.tencent.sonic.sdk.SonicConfig;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicFileUtils;
import com.tencent.sonic.sdk.SonicResourceDataHelper;
import com.tencent.sonic.sdk.SonicResourceDataHelper.ResourceData;
import com.tencent.sonic.sdk.SonicUtils;
import java.io.File;
import java.util.List;
import java.util.Map;

public abstract class SonicDownloadCache
{
  public static SonicDownloadCache getSubResourceCache()
  {
    return new SonicResourceCache();
  }
  
  public abstract byte[] getResourceCache(String paramString);
  
  public abstract Map<String, List<String>> getResourceCacheHeader(String paramString);
  
  public static class SonicResourceCache
    extends SonicDownloadCache
  {
    public static final String TAG = "SonicSdk_SonicDownloadCache";
    
    public byte[] getResourceCache(String paramString)
    {
      Object localObject = null;
      if (TextUtils.isEmpty(paramString)) {}
      String str;
      SonicResourceDataHelper.ResourceData localResourceData;
      do
      {
        return localObject;
        str = SonicUtils.getMD5(paramString);
        localResourceData = SonicResourceDataHelper.getResourceData(str);
      } while (localResourceData.expiredTime < System.currentTimeMillis());
      byte[] arrayOfByte = null;
      int i;
      if (TextUtils.isEmpty(localResourceData.resourceSha1))
      {
        i = 1;
        SonicUtils.log("SonicSdk_SonicDownloadCache", 4, "get resource data(" + paramString + "): resource data is empty.");
      }
      for (;;)
      {
        localObject = arrayOfByte;
        if (i == 0) {
          break;
        }
        long l = System.currentTimeMillis();
        SonicUtils.removeResourceCache(str);
        localResourceData.reset();
        SonicUtils.log("SonicSdk_SonicDownloadCache", 4, "get resource data(" + paramString + ") :verify error so remove session cache, cost " + (System.currentTimeMillis() - l) + "ms.");
        return arrayOfByte;
        localObject = new File(SonicFileUtils.getSonicResourcePath(str));
        arrayOfByte = SonicFileUtils.readFileToBytes((File)localObject);
        if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label229;
          }
          SonicUtils.log("SonicSdk_SonicDownloadCache", 6, "get resource data(" + paramString + ") error:cache data is null.");
          break;
        }
        label229:
        if (SonicEngine.getInstance().getConfig().VERIFY_CACHE_FILE_WITH_SHA1)
        {
          if (!SonicFileUtils.verifyData(arrayOfByte, localResourceData.resourceSha1))
          {
            i = 1;
            arrayOfByte = null;
            SonicUtils.log("SonicSdk_SonicDownloadCache", 6, "get resource data(" + paramString + ") error:verify html cache with sha1 fail.");
          }
          else
          {
            SonicUtils.log("SonicSdk_SonicDownloadCache", 4, "get resource data(" + paramString + ") verify html cache with sha1 success.");
          }
        }
        else if (localResourceData.resourceSize != ((File)localObject).length())
        {
          i = 1;
          arrayOfByte = null;
          SonicUtils.log("SonicSdk_SonicDownloadCache", 6, "get resource data(" + paramString + ") error:verify html cache with size fail.");
        }
      }
    }
    
    public Map<String, List<String>> getResourceCacheHeader(String paramString)
    {
      return SonicFileUtils.getHeaderFromLocalCache(SonicFileUtils.getSonicResourceHeaderPath(SonicUtils.getMD5(paramString)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.download.SonicDownloadCache
 * JD-Core Version:    0.7.0.1
 */