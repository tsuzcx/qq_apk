package com.tencent.ttpic.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ConcurrentHashMap;

public final class VideoCacheUtil
{
  public static final String IMAGE_CACHE_NAME = "image_cache";
  public static final String MATERIAL_CACHE_NAME = "material_cache";
  public static final String OP_HTML5_CACHE_4_IMG_NAME = "img_temp";
  public static final String OP_HTML5_CACHE_NAME = "op_html5_cache";
  private static final String TAG = VideoCacheUtil.class.getSimpleName();
  public static final String TEMP_CACHE_NAME = "temp_cache";
  public static final String THUMB_CACHE_NAME = "thumb_cache";
  public static final String TOPIC_THUMB_CACHE_NAME = "topic_cache";
  public static final String TPL_CACHE_NAME = "tpl_cache";
  public static final String VIDEO_CACHE_NAME = "video_cache";
  public static ConcurrentHashMap<String, Integer> dlMaterialStatus = new ConcurrentHashMap();
  
  private static String bytesToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void clearDownloadStatusCache()
  {
    if (dlMaterialStatus != null) {
      dlMaterialStatus.clear();
    }
  }
  
  private static String getCacheBaseDir(Context paramContext)
  {
    return "Android/data/" + paramContext.getPackageName() + "/cache";
  }
  
  public static File getDiskCacheDir(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (VideoDeviceUtil.isExternalStorageAvailable())
    {
      localObject1 = localObject2;
      if (VideoDeviceUtil.isExternalStorageSpaceEnough(52428800L))
      {
        localObject2 = getExternalCacheDir(paramContext).getPath();
        localObject1 = localObject2;
        if (!VideoDeviceUtil.isDirectoryWritable((String)localObject2)) {
          localObject1 = null;
        }
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty(localObject1))
    {
      if (!TextUtils.isEmpty(VideoDeviceUtil.SD_CARD_ROOT)) {
        break label110;
      }
      paramContext = paramContext.getCacheDir();
      if (paramContext != null) {
        break label102;
      }
      localObject2 = "";
    }
    for (;;)
    {
      return new File((String)localObject2 + File.separator + paramString);
      label102:
      localObject2 = paramContext.getPath();
      continue;
      label110:
      localObject2 = VideoDeviceUtil.SD_CARD_ROOT + File.separator + getCacheBaseDir(paramContext);
    }
  }
  
  @TargetApi(8)
  public static File getExternalCacheDir(Context paramContext)
  {
    File localFile2 = paramContext.getExternalCacheDir();
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + getCacheBaseDir(paramContext));
    }
    return localFile1;
  }
  
  public static File getTempDiskCacheDir()
  {
    return getDiskCacheDir(VideoGlobalContext.getContext(), "temp_cache");
  }
  
  @TargetApi(9)
  public static long getUsableSpace(File paramFile)
  {
    try
    {
      long l = VideoDeviceUtil.getAvailableSize(new StatFs(paramFile.getPath()));
      return l;
    }
    catch (Exception paramFile) {}
    return 0L;
  }
  
  public static File getVideoDiskCacheDir()
  {
    return getDiskCacheDir(VideoGlobalContext.getContext(), "video_cache");
  }
  
  public static String hashKeyForDisk(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = bytesToHexString(((MessageDigest)localObject).digest());
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return String.valueOf(paramString.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoCacheUtil
 * JD-Core Version:    0.7.0.1
 */