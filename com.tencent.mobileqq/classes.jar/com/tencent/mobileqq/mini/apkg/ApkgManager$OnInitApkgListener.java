package com.tencent.mobileqq.mini.apkg;

public abstract interface ApkgManager$OnInitApkgListener
{
  public static final int RES_DOWNLOAD_CANCEL = 4;
  public static final int RES_DOWNLOAD_FAIL = 2;
  public static final int RES_FAIL = 1;
  public static final int RES_SUCC = 0;
  public static final int RES_UNPACK_FAIL = 3;
  
  public abstract void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager.OnInitApkgListener
 * JD-Core Version:    0.7.0.1
 */