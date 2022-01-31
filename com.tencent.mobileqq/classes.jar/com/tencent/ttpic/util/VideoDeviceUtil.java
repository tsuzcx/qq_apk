package com.tencent.ttpic.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.opengl.GLES20;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoDeviceUtil
{
  private static String DIRECTORY;
  public static final int MIN_STORAGE_SIZE = 52428800;
  public static String SD_CARD_ROOT;
  private static final String TAG = VideoDeviceUtil.class.getSimpleName();
  
  static
  {
    checkSdcard();
  }
  
  public static boolean checkSdcard()
  {
    DIRECTORY = VideoPrefsUtil.getDefaultPrefs().getString("pref_key_storage", "");
    Object localObject1;
    if (TextUtils.isEmpty(DIRECTORY))
    {
      DIRECTORY = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + File.separator + "Camera";
      localObject1 = new File(DIRECTORY);
      if (((File)localObject1).exists())
      {
        if (!((File)localObject1).isDirectory()) {
          DIRECTORY = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
        }
        SD_CARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
      }
    }
    for (;;)
    {
      try
      {
        l1 = getAvailableSize(new StatFs(DIRECTORY));
        bool = false;
        if (l1 > 0L) {
          bool = isDirectoryWritable(DIRECTORY);
        }
        if ((!bool) || (l1 < 52428800L)) {
          continue;
        }
        return true;
      }
      catch (Exception localException1)
      {
        boolean bool;
        int j;
        int i;
        ArrayList localArrayList = VideoStorageProxy.getAvailableStorage(VideoGlobalContext.getContext());
        long l1 = 0L;
        Iterator localIterator = null;
        Object localObject6 = null;
        Object localObject2 = null;
        Object localObject5 = localObject6;
        long l3 = l1;
        if (localArrayList == null) {
          continue;
        }
        Object localObject4 = localIterator;
        long l2 = l1;
        localObject5 = localObject6;
        l3 = l1;
        try
        {
          if (localArrayList.size() > 0)
          {
            localObject4 = localIterator;
            l2 = l1;
            localIterator = localArrayList.iterator();
            localObject4 = localObject2;
            l2 = l1;
            localObject5 = localObject2;
            l3 = l1;
            if (localIterator.hasNext())
            {
              localObject4 = localObject2;
              l2 = l1;
              localObject5 = (String)localIterator.next();
              localObject4 = localObject2;
              l2 = l1;
              l3 = getAvailableSize(new StatFs((String)localObject5));
              bool = false;
              if (l3 > 0L)
              {
                localObject4 = localObject2;
                l2 = l1;
                bool = isDirectoryWritable((String)localObject5);
              }
              if ((!bool) || (l3 <= l1)) {
                continue;
              }
              l1 = l3;
              localObject2 = localObject5;
              continue;
            }
          }
          if (l3 < 52428800L) {
            break label704;
          }
        }
        catch (Exception localException2)
        {
          l3 = l2;
          localObject5 = localObject4;
        }
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          break label704;
        }
        SD_CARD_ROOT = (String)localObject5;
        localObject4 = new File((String)localObject5 + File.separator + "DCIM" + File.separator + "Camera");
        if (!((File)localObject4).exists()) {
          continue;
        }
        Object localObject3 = localObject4;
        if (((File)localObject4).isDirectory()) {
          continue;
        }
        localObject4 = ((File)localObject4).getParentFile();
        if (!((File)localObject4).exists()) {
          continue;
        }
        localObject3 = localObject4;
        if (((File)localObject4).isDirectory()) {
          continue;
        }
        localObject3 = new File(((File)localObject4).getParentFile() + File.separator + "Pitu");
        if ((!((File)localObject3).exists()) || (((File)localObject3).isDirectory())) {
          continue;
        }
        ((File)localObject3).delete();
        ((File)localObject3).mkdirs();
        DIRECTORY = ((File)localObject3).getAbsolutePath();
        VideoPrefsUtil.getDefaultPrefs().edit().putString("pref_key_storage", DIRECTORY).commit();
        return true;
        ((File)localObject4).mkdirs();
        localObject3 = localObject4;
        continue;
        ((File)localObject4).mkdirs();
        localObject3 = localObject4;
        continue;
      }
      ((File)localObject1).mkdirs();
      break;
      localObject1 = VideoStorageProxy.getAvailableStorage(VideoGlobalContext.getContext());
      j = 0;
      i = j;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        i = j;
        if (((Iterator)localObject1).hasNext())
        {
          localObject4 = (String)((Iterator)localObject1).next();
          if ((TextUtils.isEmpty((CharSequence)localObject4)) || (((String)localObject4).length() > DIRECTORY.length()) || (!DIRECTORY.contains((CharSequence)localObject4))) {
            continue;
          }
          i = 1;
          SD_CARD_ROOT = (String)localObject4;
        }
      }
      if (i == 0) {
        SD_CARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
      }
    }
    label704:
    return false;
  }
  
  @TargetApi(18)
  public static long getAvailableSize(StatFs paramStatFs)
  {
    if (VideoUtil.hasJellyBeanMR2()) {
      return paramStatFs.getAvailableBytes();
    }
    return paramStatFs.getAvailableBlocks() * paramStatFs.getBlockSize();
  }
  
  private static File getExternalFilesDir(Context paramContext)
  {
    File localFile2 = paramContext.getExternalFilesDir(null);
    File localFile1 = localFile2;
    if (localFile2 == null)
    {
      paramContext = "/Android/data/" + paramContext.getPackageName() + "/files/";
      localFile1 = new File(Environment.getExternalStorageDirectory().getPath() + paramContext);
    }
    return localFile1;
  }
  
  public static File getExternalFilesDir(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (isExternalStorageAvailable())
    {
      localObject1 = localObject2;
      if (isExternalStorageSpaceEnough(52428800L)) {
        localObject1 = getExternalFilesDir(paramContext).getPath();
      }
    }
    paramContext = new File((String)localObject1 + File.separator + paramString);
    try
    {
      if ((paramContext.exists()) && (paramContext.isFile())) {
        paramContext.delete();
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext;
    }
    catch (Exception paramString) {}
    return paramContext;
  }
  
  public static String getGPUInfo()
  {
    String str1 = GLES20.glGetString(7937);
    String str2 = GLES20.glGetString(7936);
    String str3 = GLES20.glGetString(7938);
    return str1 + "; " + str2 + "; " + str3;
  }
  
  public static long getHeapAllocatedSizeInKb()
  {
    return getRuntimeTotalMemory(1) - getRuntimeFreeMemory(1);
  }
  
  private static long getRuntimeFreeMemory(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Runtime.getRuntime().freeMemory();
    case 0: 
      return Runtime.getRuntime().freeMemory();
    case 1: 
      return Runtime.getRuntime().freeMemory() / 1024L;
    }
    return Runtime.getRuntime().freeMemory() / 1024L / 1024L;
  }
  
  public static long getRuntimeRemainSize(int paramInt)
  {
    long l = Runtime.getRuntime().maxMemory() - getHeapAllocatedSizeInKb() * 1024L;
    switch (paramInt)
    {
    case 0: 
    default: 
      return l;
    case 1: 
      return l / 1024L;
    }
    return l / 1048576L;
  }
  
  private static long getRuntimeTotalMemory(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Runtime.getRuntime().totalMemory();
    case 0: 
      return Runtime.getRuntime().totalMemory();
    case 1: 
      return Runtime.getRuntime().totalMemory() / 1024L;
    }
    return Runtime.getRuntime().totalMemory() / 1024L / 1024L;
  }
  
  public static boolean isDirectoryWritable(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (!paramString.isDirectory())) {}
    do
    {
      return false;
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
    } while (!paramString.isDirectory());
    try
    {
      boolean bool = paramString.canWrite();
      return bool;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean isExternalStorageAvailable()
  {
    boolean bool = false;
    if (("mounted".equals(Environment.getExternalStorageState())) || (!Environment.isExternalStorageRemovable())) {}
    try
    {
      new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
      bool = true;
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isExternalStorageSpaceEnough(long paramLong)
  {
    return getAvailableSize(new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath())) > paramLong;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = paramContext.getActiveNetworkInfo();
    } while ((paramContext == null) || (!paramContext.isConnectedOrConnecting()));
    return true;
  }
  
  public static class MEMORY_CLASS
  {
    public static final int IN_B = 0;
    public static final int IN_KB = 1;
    public static final int IN_MB = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoDeviceUtil
 * JD-Core Version:    0.7.0.1
 */