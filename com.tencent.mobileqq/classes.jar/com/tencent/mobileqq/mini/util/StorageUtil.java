package com.tencent.mobileqq.mini.util;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;

public class StorageUtil
{
  public static final String PRE_MINI_APP = "pre_miniapp";
  private static SharedPreferences sPreMiniAppSp;
  
  public static SharedPreferences getPreference()
  {
    if (sPreMiniAppSp == null) {
      sPreMiniAppSp = BaseApplication.getContext().getSharedPreferences("pre_miniapp", 4);
    }
    return sPreMiniAppSp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.StorageUtil
 * JD-Core Version:    0.7.0.1
 */