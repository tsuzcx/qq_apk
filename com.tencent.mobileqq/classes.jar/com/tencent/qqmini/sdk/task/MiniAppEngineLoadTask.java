package com.tencent.qqmini.sdk.task;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel.Receiver;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import com.tencent.qqmini.sdk.manager.MiniLoadManager.MiniLoadListener;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import java.util.ArrayList;

public class MiniAppEngineLoadTask
  extends AsyncTask
  implements EngineChannel.Receiver
{
  public static final int ERR_ENGINE_NEED_UPDATE = 101;
  public static final int ERR_ENGINE_TIMEOUT = 103;
  public static final int ERR_INTERNAL = 102;
  public static final int ERR_INVALID_OP = 1;
  public static final int ERR_UNKNOWN = 100;
  private static final int INSTALL_ENGINE_REQUEST_COUNT_MAX = 2;
  public static final String LOG_TAG = "MiniAppEngineLoadTask";
  private int installEngineRequestCount = 0;
  private InstalledEngine mEngine;
  private EngineChannel mEngineChannel;
  private int mLibType = 3;
  private MiniAppInfo mMiniAppInfo;
  private MiniLoadManager.MiniLoadListener mMiniLibLoadListener;
  
  public MiniAppEngineLoadTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  private boolean isMiniAppSatisfy(InstalledEngine paramInstalledEngine, MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = true;
    if (paramInstalledEngine == null) {
      bool = false;
    }
    while (paramMiniAppInfo != null) {
      return bool;
    }
    return true;
  }
  
  private void loadEngine(InstalledEngine paramInstalledEngine)
  {
    for (;;)
    {
      try
      {
        if (this.mEngine == null)
        {
          QMLog.i("MiniAppEngineLoadTask", "[MiniEng]mEngine == null, loadEngineTask is reset?");
          return;
        }
        long l = System.currentTimeMillis();
        QMLog.i("MiniAppEngineLoadTask", "[MiniEng]initEngine");
        if (paramInstalledEngine != null) {
          MiniAppSoLoader.g().setEngine(paramInstalledEngine);
        }
        if (!MiniAppSoLoader.g().loadAllMiniSo())
        {
          QMLog.e("MiniAppEngineLoadTask", "[MiniEng]initEngine fail");
          onTaskFailed();
          continue;
        }
        QMLog.e("MiniAppEngineLoadTask", "[MiniEng]loadSo cost time " + (System.currentTimeMillis() - l));
      }
      finally {}
      onTaskSucceed();
    }
  }
  
  private void sendCommand(int paramInt, Bundle paramBundle)
  {
    paramBundle.putInt("baseLibType", this.mLibType);
    paramBundle.putInt("enginePid", Process.myPid());
    QMLog.i("MiniAppEngineLoadTask", "[MiniEng]installEngineRequestCount " + this.installEngineRequestCount);
    if (this.installEngineRequestCount >= 2)
    {
      QMLog.i("MiniAppEngineLoadTask", "[MiniEng]GET_INSTALLED_ENGINE_LIST requestCount reaches max 2");
      onTaskFailed(103, "加载引擎超时");
    }
    do
    {
      return;
      this.mEngineChannel.send(paramInt, paramBundle);
    } while (paramInt != 3);
    this.installEngineRequestCount += 1;
  }
  
  public void executeAsync()
  {
    if (this.mEngineChannel == null)
    {
      onTaskFailed(1, "参数错误, channel为空");
      return;
    }
    EngineChannel localEngineChannel = new EngineChannel();
    localEngineChannel.setName("AppEngine(" + Process.myPid() + ")");
    localEngineChannel.setReceiver(this);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("engineChannel", localEngineChannel);
    sendCommand(1, localBundle);
  }
  
  public InstalledEngine getEngine()
  {
    return this.mEngine;
  }
  
  public void onReceiveData(int paramInt, Bundle paramBundle)
  {
    QMLog.i("MiniAppEngineLoadTask", "[MiniEng] onReceiveData what=" + paramInt);
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    if (paramInt == 51) {
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getParcelableArrayList("installedEngineList");
        if (paramBundle != null)
        {
          paramInt = paramBundle.size();
          QMLog.i("MiniAppEngineLoadTask", "[MiniEng] getInstalledEngineList success " + paramInt);
          if (paramInt > 0)
          {
            paramBundle = (InstalledEngine)paramBundle.get(0);
            if (isMiniAppSatisfy(paramBundle, this.mMiniAppInfo))
            {
              this.mEngine = paramBundle;
              loadEngine(paramBundle);
            }
          }
        }
      }
    }
    do
    {
      do
      {
        return;
        onTaskFailed(101, "未知错误");
        return;
        QMLog.i("MiniAppEngineLoadTask", "[MiniEng] no engine installed, send cmd WHAT_INSTALL_LATEST_ENGINE");
        sendCommand(3, new Bundle());
        return;
        QMLog.i("MiniAppEngineLoadTask", "[MiniEng] getInstalledEngineList miniAppEngineList is null");
        onTaskFailed(102, "获取引擎信息失败");
        return;
        QMLog.i("MiniAppEngineLoadTask", "[MiniEng] getInstalledEngineList data is null");
        onTaskFailed(102, "获取引擎信息失败");
        return;
        if (paramInt == 52)
        {
          QMLog.i("MiniAppEngineLoadTask", "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_BEGIN");
          return;
        }
        if (paramInt != 53) {
          break;
        }
      } while (paramBundle == null);
      paramBundle = paramBundle.getString("engineInstallerMessage");
      QMLog.i("MiniAppEngineLoadTask", "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_PROCESS " + paramBundle);
      return;
    } while (paramInt != 54);
    QMLog.i("MiniAppEngineLoadTask", "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_FINISH");
    sendCommand(1, new Bundle());
  }
  
  public void reset()
  {
    try
    {
      QMLog.i("MiniAppEngineLoadTask", "[MiniEng]" + this + " reset ");
      this.installEngineRequestCount = 0;
      this.mMiniAppInfo = null;
      this.mEngine = null;
      super.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setDownloadListener(MiniLoadManager.MiniLoadListener paramMiniLoadListener)
  {
    this.mMiniLibLoadListener = paramMiniLoadListener;
  }
  
  public void setEngineChannel(EngineChannel paramEngineChannel)
  {
    this.mEngineChannel = paramEngineChannel;
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppEngineLoadTask
 * JD-Core Version:    0.7.0.1
 */