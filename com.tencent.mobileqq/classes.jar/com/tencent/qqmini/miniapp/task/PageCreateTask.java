package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.MainThreadTask;

@ClassTag(tag="PageCreateTask")
public class PageCreateTask
  extends MainThreadTask
{
  public static final String TAG = "PageCreateTask";
  private AppBrandPageContainer mPageContainer;
  
  public PageCreateTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeInMainThread()
  {
    if (getRuntimeLoader().getRuntime() == null)
    {
      QMLog.w("PageCreateTask", "runtime is null!");
      onTaskSucceed();
      return;
    }
    IPage localIPage = getRuntimeLoader().getRuntime().getPage();
    if (!(localIPage instanceof AppBrandPageContainer))
    {
      QMLog.w("PageCreateTask", "PageContainer type is incorrect! page=" + localIPage);
      onTaskSucceed();
      return;
    }
    try
    {
      this.mPageContainer = ((AppBrandPageContainer)localIPage);
      this.mPageContainer.init(null);
      onTaskSucceed();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("PageCreateTask", "pageContainer init exception!", localThrowable);
      onTaskFailed(10, "Page创建失败");
    }
  }
  
  public AppBrandPageContainer getPageContainer()
  {
    return this.mPageContainer;
  }
  
  public void reset()
  {
    super.reset();
    try
    {
      if (this.mPageContainer != null)
      {
        this.mPageContainer.recyclePreLoadAppBrandPage();
        this.mPageContainer = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("PageCreateTask", "PageCreateTask reset exception!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.PageCreateTask
 * JD-Core Version:    0.7.0.1
 */