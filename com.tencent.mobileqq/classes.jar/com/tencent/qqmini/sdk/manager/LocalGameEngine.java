package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.utils.WnsUtil;

public class LocalGameEngine
{
  public static final String ASSETS_PROTOCOL = "assets://";
  public static final String GAME_ASSETS_PATH = "mini";
  public static final String LIBNAME_PNG_SO = "png-armeabi";
  public static final String LIBNAME_PNG_SO_ARMV7A = "png-armeabi-v7a";
  public static final String LOCAL_ENGINE_FLAG = "soTest";
  public static final String LOCAL_ENGINE_VERSION = "1.18.0.00132";
  public static final String LOG_TAG = "LocalGameEngine";
  private static volatile LocalGameEngine sInstance;
  public BaseLibInfo mLocalBaseLibInfo;
  public EngineVersion mLocalEngineVersion;
  
  public LocalGameEngine()
  {
    initLocalBaseLibInfo();
    initLocalEngineVersion();
  }
  
  public static LocalGameEngine g()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new LocalGameEngine();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void initLocalBaseLibInfo()
  {
    this.mLocalBaseLibInfo = new BaseLibInfo();
    this.mLocalBaseLibInfo.baseLibUrl = "assets://mini";
    this.mLocalBaseLibInfo.baseLibVersion = WnsUtil.getGameEngineVersion("1.18.0.00132");
    QMLog.i("LocalGameEngine", "[MiniEng]initLocalBaseLibInfo start");
    long l = System.currentTimeMillis();
    QMLog.i("LocalGameEngine", "[MiniEng]initLocalBaseLibInfo cost=" + (System.currentTimeMillis() - l));
    if (new boolean[] { false }[0] != 0) {}
    for (this.mLocalBaseLibInfo.baseLibDesc = ("{'file_length':" + new long[] { 0L }[0] + "}");; this.mLocalBaseLibInfo.baseLibDesc = "{'file_length':-1}")
    {
      this.mLocalBaseLibInfo.baseLibKey = null;
      this.mLocalBaseLibInfo.baseLibType = 2;
      return;
    }
  }
  
  private void initLocalEngineVersion()
  {
    this.mLocalEngineVersion = new EngineVersion(WnsUtil.getGameEngineVersion("1.18.0.00132"));
  }
  
  private boolean isQQSpeedPackage()
  {
    String str = AppLoaderFactory.g().getContext().getPackageName();
    QMLog.i("LocalGameEngine", "[MiniEng]isQQSpeedPackage " + str);
    return (!TextUtils.isEmpty(str)) && (str.toLowerCase().startsWith("com.tencent.qqlite"));
  }
  
  public boolean isDisabled()
  {
    return isQQSpeedPackage();
  }
  
  public boolean isWnsConfigModel()
  {
    return isQQSpeedPackage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.LocalGameEngine
 * JD-Core Version:    0.7.0.1
 */