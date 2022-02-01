package com.tencent.mobileqq.soload.biz;

import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;

public abstract interface OnLoadListener
{
  public static final int RES_CODE_CHECK_MD5_NOT_MATCH = 4;
  public static final int RES_CODE_CRC_AND_UNZIP_FAIL = 10;
  public static final int RES_CODE_DOWNLOAD_404 = 9;
  public static final int RES_CODE_DOWNLOAD_RELATED_FILE_FAIL = 11;
  public static final int RES_CODE_DOWNLOAD_SO_FAIL = 3;
  public static final int RES_CODE_LOAD_CRASH = 8;
  public static final int RES_CODE_LOAD_PARAMS_INVALID = 1;
  public static final int RES_CODE_LOAD_SO_FAIL = 6;
  public static final int RES_CODE_LOAD_TIME_OUT = 7;
  public static final int RES_CODE_NO_DEPENDENCY_FAIL = 12;
  public static final int RES_CODE_NO_SO_CONFIG = 2;
  public static final int RES_CODE_SO_FILE_NOT_EXIST = 5;
  public static final int RES_CODE_SUCC = 0;
  
  public abstract void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.OnLoadListener
 * JD-Core Version:    0.7.0.1
 */