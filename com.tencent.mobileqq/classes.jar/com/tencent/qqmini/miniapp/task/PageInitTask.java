package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;

@ClassTag(tag="PageInitTask")
public class PageInitTask
  extends AsyncTask
{
  public static final String TAG = "PageInitTask";
  
  public PageInitTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeAsync()
  {
    if (getRuntimeLoader().getRuntime() == null)
    {
      QMLog.w("PageInitTask", "runtime is null!");
      onTaskSucceed();
      return;
    }
    IPage localIPage = getRuntimeLoader().getRuntime().getPage();
    if (!(localIPage instanceof AppBrandPageContainer))
    {
      QMLog.w("PageInitTask", "PageContainer type is incorrect! page=" + localIPage);
      onTaskSucceed();
      return;
    }
    BaselibLoader.BaselibContent localBaselibContent = ((BaselibLoadAsyncTask)getRuntimeLoader().getTask(BaselibLoadAsyncTask.class)).getBaselibContent();
    if ((localBaselibContent == null) || (!localBaselibContent.isBaseLibInited()))
    {
      QMLog.w("PageInitTask", "Baselib is not inited!");
      onTaskSucceed();
      return;
    }
    try
    {
      ((AppBrandPageContainer)localIPage).initBaseJs(localBaselibContent);
      onTaskSucceed();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("PageInitTask", "pageContainer init exception!", localThrowable);
      onTaskFailed(10, "Page创建失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.PageInitTask
 * JD-Core Version:    0.7.0.1
 */