package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import mqq.util.WeakReference;

public class MiniGameStorageExceedManager
{
  private static boolean hasShowStorageExceedDialog;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.MiniGameStorageExceedManager
 * JD-Core Version:    0.7.0.1
 */