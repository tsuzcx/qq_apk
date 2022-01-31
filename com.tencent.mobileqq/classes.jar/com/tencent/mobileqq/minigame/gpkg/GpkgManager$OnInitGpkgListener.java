package com.tencent.mobileqq.minigame.gpkg;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public abstract interface GpkgManager$OnInitGpkgListener
{
  public static final int DEBUG_APK_NOT_EXIST = 2006;
  public static final int DOWNLOAD_PARAM_ERROR = 2023;
  public static final int DOWNLOAD_PKG_CANCEL = 2003;
  public static final int DOWNLOAD_PKG_FAIL = 2004;
  public static final int DOWNLOAD_PLUGIN_FAIL = 2022;
  public static final int DOWNLOAD_SUB_PKG_CANCEL = 2009;
  public static final int DOWNLOAD_SUB_PKG_FAIL = 2010;
  public static final int DOWNLOAD_UNKNOW_ERROR = 2024;
  public static final int EXCEPTION = 2001;
  public static final int GAME_CONFIG_NULL_ERROR = 2002;
  public static final int PKG_FOLD_NOT_EXIST = 2007;
  public static final int RES_SUCC = 0;
  public static final int SUB_PKG_DOWNLOAD_URL_NULL = 2008;
  public static final int UNPACK_PKG_FAIL = 2005;
  public static final int UNPACK_SUB_PKG_FAIL = 2011;
  
  public abstract void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong);
  
  public abstract void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.OnInitGpkgListener
 * JD-Core Version:    0.7.0.1
 */