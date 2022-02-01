package com.tencent.mobileqq.qwallet.preload;

import java.io.Serializable;

public abstract interface IPreloadResource
  extends Serializable
{
  public static final String ABI_32 = "32";
  public static final String ABI_64 = "64";
  public static final int FROM_TYPE_AVGAME_CJ = 3;
  public static final int FROM_TYPE_MOBILE_QQ = 0;
  public static final int FROM_TYPE_MOGGY = 1;
  public static final int FROM_TYPE_NONE = 0;
  public static final int FROM_TYPE_REDBAO = 2;
  public static final String PARAM_KEY_MODULE = "module";
  public static final String PARAM_KEY_RES = "resource";
  public static final String PARAM_KEY_SCENE = "scene";
  public static final int PRELOAD_DOWNLOAD_NOTIFY_THRESHOLD = 1048576;
  public static final int TYPE_GIF = 2;
  public static final int TYPE_MP3 = 3;
  public static final int TYPE_PNG = 1;
  public static final int TYPE_VIDEO = 5;
  public static final int TYPE_ZIP = 4;
  
  public abstract String getResDownloadUrl(IPreloadModule paramIPreloadModule);
  
  public abstract String getResId();
  
  public abstract String getUrl();
  
  public abstract boolean isResFileExist(IPreloadModule paramIPreloadModule);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.IPreloadResource
 * JD-Core Version:    0.7.0.1
 */