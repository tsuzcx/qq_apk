package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;

public abstract interface ApkgManager$OnInitApkgListener
{
  public static final int RES_DOWNLOAD_CANCEL = 4;
  public static final int RES_DOWNLOAD_FAIL = 2;
  public static final int RES_FAIL = 1;
  public static final int RES_SUCC = 0;
  public static final int RES_UNPACK_FAIL = 3;
  
  public abstract void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener
 * JD-Core Version:    0.7.0.1
 */