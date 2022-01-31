package com.tencent.mobileqq.mini.tfs.mini;

import android.content.Context;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.tfs.AsyncTask;

public class MiniTask$RuntimeContainerInitTask
  extends AsyncTask
{
  private AppBrandRuntimeContainer mRuntimeContainer;
  
  public MiniTask$RuntimeContainerInitTask(Context paramContext, AppBrandRuntimeContainer paramAppBrandRuntimeContainer)
  {
    super(paramContext);
    this.mRuntimeContainer = paramAppBrandRuntimeContainer;
  }
  
  public void executeAsync()
  {
    this.mRuntimeContainer.initDebugUI();
    onTaskSucceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.MiniTask.RuntimeContainerInitTask
 * JD-Core Version:    0.7.0.1
 */