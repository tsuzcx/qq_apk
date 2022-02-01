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
    if (paramInstalledEngine == null) {
      return false;
    }
    if (paramMiniAppInfo == null) {}
    return true;
  }
  
  private void loadEngine(InstalledEngine paramInstalledEngine)
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
        return;
      }
      paramInstalledEngine = new StringBuilder();
      paramInstalledEngine.append("[MiniEng]loadSo cost time ");
      paramInstalledEngine.append(System.currentTimeMillis() - l);
      QMLog.e("MiniAppEngineLoadTask", paramInstalledEngine.toString());
      onTaskSucceed();
      return;
    }
    finally {}
  }
  
  private void sendCommand(int paramInt, Bundle paramBundle)
  {
    paramBundle.putInt("baseLibType", this.mLibType);
    paramBundle.putInt("enginePid", Process.myPid());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng]installEngineRequestCount ");
    localStringBuilder.append(this.installEngineRequestCount);
    QMLog.i("MiniAppEngineLoadTask", localStringBuilder.toString());
    if (this.installEngineRequestCount >= 2)
    {
      QMLog.i("MiniAppEngineLoadTask", "[MiniEng]GET_INSTALLED_ENGINE_LIST requestCount reaches max 2");
      onTaskFailed(103, "加载引擎超时");
      return;
    }
    this.mEngineChannel.send(paramInt, paramBundle);
    if (paramInt == 3) {
      this.installEngineRequestCount += 1;
    }
  }
  
  public void executeAsync()
  {
    if (this.mEngineChannel == null)
    {
      onTaskFailed(1, "参数错误, channel为空");
      return;
    }
    EngineChannel localEngineChannel = new EngineChannel();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AppEngine(");
    ((StringBuilder)localObject).append(Process.myPid());
    ((StringBuilder)localObject).append(")");
    localEngineChannel.setName(((StringBuilder)localObject).toString());
    localEngineChannel.setReceiver(this);
    localObject = new Bundle();
    ((Bundle)localObject).putParcelable("engineChannel", localEngineChannel);
    sendCommand(1, (Bundle)localObject);
  }
  
  public InstalledEngine getEngine()
  {
    return this.mEngine;
  }
  
  public void onReceiveData(int paramInt, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] onReceiveData what=");
    localStringBuilder.append(paramInt);
    QMLog.i("MiniAppEngineLoadTask", localStringBuilder.toString());
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    if (paramInt == 51)
    {
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getParcelableArrayList("installedEngineList");
        if (paramBundle != null)
        {
          paramInt = paramBundle.size();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[MiniEng] getInstalledEngineList success ");
          localStringBuilder.append(paramInt);
          QMLog.i("MiniAppEngineLoadTask", localStringBuilder.toString());
          if (paramInt > 0)
          {
            paramBundle = (InstalledEngine)paramBundle.get(0);
            if (isMiniAppSatisfy(paramBundle, this.mMiniAppInfo))
            {
              this.mEngine = paramBundle;
              loadEngine(paramBundle);
              return;
            }
            onTaskFailed(101, "未知错误");
            return;
          }
          QMLog.i("MiniAppEngineLoadTask", "[MiniEng] no engine installed, send cmd WHAT_INSTALL_LATEST_ENGINE");
          sendCommand(3, new Bundle());
          return;
        }
        QMLog.i("MiniAppEngineLoadTask", "[MiniEng] getInstalledEngineList miniAppEngineList is null");
        onTaskFailed(102, "获取引擎信息失败");
        return;
      }
      QMLog.i("MiniAppEngineLoadTask", "[MiniEng] getInstalledEngineList data is null");
      onTaskFailed(102, "获取引擎信息失败");
      return;
    }
    if (paramInt == 52)
    {
      QMLog.i("MiniAppEngineLoadTask", "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_BEGIN");
      return;
    }
    if (paramInt == 53)
    {
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("engineInstallerMessage");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MiniEng]EVENT_INSTALL_LATEST_ENGINE_PROCESS ");
        localStringBuilder.append(paramBundle);
        QMLog.i("MiniAppEngineLoadTask", localStringBuilder.toString());
      }
    }
    else if (paramInt == 54)
    {
      QMLog.i("MiniAppEngineLoadTask", "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_FINISH");
      sendCommand(1, new Bundle());
    }
  }
  
  public void reset()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng]");
      localStringBuilder.append(this);
      localStringBuilder.append(" reset ");
      QMLog.i("MiniAppEngineLoadTask", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppEngineLoadTask
 * JD-Core Version:    0.7.0.1
 */