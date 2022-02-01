package com.tencent.weiyun;

import android.app.Application;
import android.content.Context;
import com.tencent.weiyun.cmd.CommandManager;
import com.tencent.weiyun.poi.PoiManager;
import com.tencent.weiyun.utils.ILog;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import com.tencent.weiyun.utils.WyLog;

public final class WeiyunLiteGlobal
{
  private static final String TAG = "WeiyunLiteGlobal";
  private static Singleton<WeiyunLiteGlobal, Void> sInstance = new WeiyunLiteGlobal.1();
  private CommandManager mCommandManager;
  private Application mContext;
  private WeiyunLiteGlobal.HostInterface mHostInterface;
  private PoiManager mPoiManager;
  
  public static WeiyunLiteGlobal getInstance()
  {
    return (WeiyunLiteGlobal)sInstance.get(null);
  }
  
  public CommandManager getCommandManager()
  {
    if (this.mCommandManager == null) {
      throw new IllegalStateException("Please call WeiyunLiteGlobal.initLite(...) in advance.");
    }
    return this.mCommandManager;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public WeiyunLiteGlobal.HostInterface getHostInterface()
  {
    return this.mHostInterface;
  }
  
  public PoiManager getPoiManager()
  {
    if (this.mPoiManager == null) {
      throw new IllegalStateException("Please call WeiyunLiteGlobal.initLite(...) in advance.");
    }
    return this.mPoiManager;
  }
  
  public void initLite(Application paramApplication, WeiyunLiteGlobal.HostInterface paramHostInterface, ILog paramILog)
  {
    if ((paramApplication == null) || (paramHostInterface == null)) {
      try
      {
        throw new IllegalArgumentException("The params appInfo, context and hostInterface should be no-null.");
      }
      finally {}
    }
    this.mContext = paramApplication;
    this.mHostInterface = paramHostInterface;
    WyLog.setLog(paramILog);
    NetworkUtils.setNetworkInfoProvider(new WeiyunLiteGlobal.2(this));
    this.mCommandManager = CommandManager.getInstance();
    this.mPoiManager = PoiManager.getInstance();
    this.mPoiManager.init();
  }
  
  public void resetCommandCache()
  {
    getCommandManager().resetWeiyunSdk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.WeiyunLiteGlobal
 * JD-Core Version:    0.7.0.1
 */