package com.tencent.open.base.http;

import android.content.Context;
import java.lang.ref.WeakReference;

public class AvatarUpdateService$AvatarUpdateTask
{
  public WeakReference<Context> a;
  public String b;
  public String c;
  public String d;
  public WeakReference<HttpImageDownloadAsyncTask.TaskCompleteCallback> e;
  
  public AvatarUpdateService$AvatarUpdateTask(AvatarUpdateService paramAvatarUpdateService, Context paramContext, String paramString1, String paramString2, String paramString3, HttpImageDownloadAsyncTask.TaskCompleteCallback paramTaskCompleteCallback)
  {
    this.a = new WeakReference(paramContext);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = new WeakReference(paramTaskCompleteCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.http.AvatarUpdateService.AvatarUpdateTask
 * JD-Core Version:    0.7.0.1
 */