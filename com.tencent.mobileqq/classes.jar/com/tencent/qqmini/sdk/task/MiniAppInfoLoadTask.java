package com.tencent.qqmini.sdk.task;

import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;

@ClassTag(tag="MiniAppInfoLoadTask")
public class MiniAppInfoLoadTask
  extends AsyncTask
{
  private static final String TAG = "MiniAppInfoLoadTask";
  private MiniAppInfo mMiniAppInfo;
  
  public MiniAppInfoLoadTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  private void doRequestByAppId()
  {
    String str1;
    if (this.mMiniAppInfo.firstPath != null) {
      str1 = this.mMiniAppInfo.firstPath;
    }
    for (;;)
    {
      if (this.mMiniAppInfo.launchParam.envVersion == null) {}
      for (String str2 = "";; str2 = this.mMiniAppInfo.launchParam.envVersion)
      {
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(this.mMiniAppInfo.appId, str1, str2, new MiniAppInfoLoadTask.2(this));
        return;
        if (this.mMiniAppInfo.launchParam.entryPath == null) {
          break label106;
        }
        str1 = this.mMiniAppInfo.launchParam.entryPath;
        break;
      }
      label106:
      str1 = "";
    }
  }
  
  private void doRequestByLink()
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoByLink(this.mMiniAppInfo.link, this.mMiniAppInfo.linkType, new MiniAppInfoLoadTask.3(this));
  }
  
  private void reloadMiniAppInfoIfNeeded()
  {
    QMLog.i("MiniAppInfoLoadTask", "start executing");
    if (this.mMiniAppInfo == null)
    {
      QMLog.e("MiniAppInfoLoadTask", "MiniAppInfo must not be null");
      onTaskFailed();
      return;
    }
    if (this.mMiniAppInfo.isShortcutFakeApp())
    {
      QMLog.i("MiniAppInfoLoadTask", "Start from shortcut, download MiniAppInfo ");
      doRequestByAppId();
      return;
    }
    if (this.mMiniAppInfo.isFakeAppInfo())
    {
      if (this.mMiniAppInfo.link != null)
      {
        doRequestByLink();
        return;
      }
      doRequestByAppId();
      return;
    }
    onTaskSucceed();
  }
  
  public void executeAsync() {}
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
    if (!isMainThread())
    {
      reloadMiniAppInfoIfNeeded();
      return;
    }
    ThreadManager.getSubThreadHandler().post(new MiniAppInfoLoadTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask
 * JD-Core Version:    0.7.0.1
 */