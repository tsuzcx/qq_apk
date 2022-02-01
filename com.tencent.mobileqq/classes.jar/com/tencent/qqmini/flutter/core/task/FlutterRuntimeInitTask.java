package com.tencent.qqmini.flutter.core.task;

import android.content.Context;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.miniapp.task.RuntimeInitTask;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;

@ClassTag(tag="RuntimeInitTask")
public class FlutterRuntimeInitTask
  extends RuntimeInitTask
{
  public FlutterRuntimeInitTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public IAppBrandService getAppBrandService()
  {
    V8ServiceInitTask localV8ServiceInitTask = (V8ServiceInitTask)getRuntimeLoader().getTask(V8ServiceInitTask.class);
    if (localV8ServiceInitTask != null) {
      return localV8ServiceInitTask.getJsService();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.task.FlutterRuntimeInitTask
 * JD-Core Version:    0.7.0.1
 */