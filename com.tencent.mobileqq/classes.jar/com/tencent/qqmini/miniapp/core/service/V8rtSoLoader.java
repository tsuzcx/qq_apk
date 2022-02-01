package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.tissue.v8rt.engine.LibLoader;

public class V8rtSoLoader
  implements LibLoader
{
  public static final String LOG_TAG = "V8rtSoLoader";
  
  public boolean loadSo()
  {
    try
    {
      System.load(MiniSDKConst.getMiniAppV8rtPath());
      QMLog.d("V8rtSoLoader", "v8rt loadSo success");
      return true;
    }
    catch (Exception localException)
    {
      QMLog.e("V8rtSoLoader", "v8rt loadSo Error", localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.V8rtSoLoader
 * JD-Core Version:    0.7.0.1
 */