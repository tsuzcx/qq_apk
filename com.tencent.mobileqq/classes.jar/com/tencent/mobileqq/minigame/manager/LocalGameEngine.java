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
  public static final String LOCAL_ENGINE_VERSION = "1.29.0.00002";
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
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new LocalGameEngine();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void initLocalBaseLibInfo()
  {
    this.mLocalBaseLibInfo = new BaseLibInfo();
    Object localObject = this.mLocalBaseLibInfo;
    ((BaseLibInfo)localObject).baseLibUrl = "assets://mini";
    ((BaseLibInfo)localObject).baseLibVersion = GameWnsUtils.getGameEngineVersion("1.29.0.00002");
    QLog.i("LocalGameEngine", 1, "[MiniEng]initLocalBaseLibInfo start");
    long l = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniEng]initLocalBaseLibInfo cost=");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    QLog.i("LocalGameEngine", 1, ((StringBuilder)localObject).toString());
    if (new boolean[] { false }[0] != 0)
    {
      localObject = this.mLocalBaseLibInfo;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{'file_length':");
      localStringBuilder.append(new long[] { 0L }[0]);
      localStringBuilder.append("}");
      ((BaseLibInfo)localObject).baseLibDesc = localStringBuilder.toString();
    }
    else
    {
      this.mLocalBaseLibInfo.baseLibDesc = "{'file_length':-1}";
    }
    localObject = this.mLocalBaseLibInfo;
    ((BaseLibInfo)localObject).baseLibKey = null;
    ((BaseLibInfo)localObject).baseLibType = 2;
  }
  
  private void initLocalEngineVersion()
  {
    this.mLocalEngineVersion = new EngineVersion(GameWnsUtils.getGameEngineVersion("1.29.0.00002"));
  }
  
  private boolean isQQSpeedPackage()
  {
    String str = BaseApplicationImpl.getApplication().getPackageName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng]isQQSpeedPackage ");
    localStringBuilder.append(str);
    QLog.i("LocalGameEngine", 1, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.LocalGameEngine
 * JD-Core Version:    0.7.0.1
 */