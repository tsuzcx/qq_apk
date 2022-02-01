package com.tencent.qqmini.sdk.manager;

import android.app.Activity;
import com.tencent.qqmini.sdk.cache.MiniCacheFreeManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import java.lang.ref.WeakReference;

public class MiniGameStorageExceedManager
{
  private static boolean hasShowStorageExceedDialog = false;
  private static int storageExceedCount;
  
  public static void resetStorageExceedDialogStatus()
  {
    hasShowStorageExceedDialog = false;
    storageExceedCount = 0;
  }
  
  public static void showStorageExceedDialog(WeakReference<Activity> paramWeakReference, String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if ((!hasShowStorageExceedDialog) && (GameWnsUtils.enableStorageExceedDialog()))
    {
      storageExceedCount += 1;
      if (storageExceedCount >= GameWnsUtils.enableStorageExceedLimit())
      {
        hasShowStorageExceedDialog = true;
        if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
          MiniCacheFreeManager.freeCacheDialog((Activity)paramWeakReference.get(), paramString, paramMiniAppInfo, GameWnsUtils.getCacheFreeContent());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniGameStorageExceedManager
 * JD-Core Version:    0.7.0.1
 */