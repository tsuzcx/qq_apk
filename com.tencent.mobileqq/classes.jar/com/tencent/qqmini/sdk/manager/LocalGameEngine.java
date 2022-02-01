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
  public static final String LOCAL_ENGINE_VERSION = "1.22.0.00008";
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
    ((BaseLibInfo)localObject).baseLibVersion = WnsUtil.getGameEngineVersion("1.22.0.00008");
    QMLog.i("LocalGameEngine", "[MiniEng]initLocalBaseLibInfo start");
    long l = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniEng]initLocalBaseLibInfo cost=");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    QMLog.i("LocalGameEngine", ((StringBuilder)localObject).toString());
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
    this.mLocalEngineVersion = new EngineVersion(WnsUtil.getGameEngineVersion("1.22.0.00008"));
  }
  
  private boolean isQQSpeedPackage()
  {
    String str = AppLoaderFactory.g().getContext().getPackageName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng]isQQSpeedPackage ");
    localStringBuilder.append(str);
    QMLog.i("LocalGameEngine", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.LocalGameEngine
 * JD-Core Version:    0.7.0.1
 */