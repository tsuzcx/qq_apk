package com.tencent.mobileqq.minigame.manager;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;

public class LocalGameEngine
{
  public static final String ASSETS_PROTOCOL = "assets://";
  public static final String GAME_ASSETS_PATH = "mini";
  public static final String LIBNAME_PNG_SO = "png-armeabi";
  public static final String LIBNAME_PNG_SO_ARMV7A = "png-armeabi-v7a";
  public static final String LOCAL_ENGINE_FLAG = "soTest";
  public static final String LOCAL_ENGINE_VERSION = "1.12.1.00001";
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
    this.mLocalBaseLibInfo.baseLibVersion = GameWnsUtils.getGameEngineVersion("1.12.1.00001");
    QLog.i("LocalGameEngine", 1, "[MiniEng]initLocalBaseLibInfo start");
    long l = System.currentTimeMillis();
    QLog.i("LocalGameEngine", 1, "[MiniEng]initLocalBaseLibInfo cost=" + (System.currentTimeMillis() - l));
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
    this.mLocalEngineVersion = new EngineVersion(GameWnsUtils.getGameEngineVersion("1.12.1.00001"));
  }
  
  private boolean isQQSpeedPackage()
  {
    String str = BaseApplicationImpl.getApplication().getPackageName();
    QLog.i("LocalGameEngine", 1, "[MiniEng]isQQSpeedPackage " + str);
    return (!TextUtils.isEmpty(str)) && (str.toLowerCase().startsWith("com.tencent.qqspeed"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.LocalGameEngine
 * JD-Core Version:    0.7.0.1
 */