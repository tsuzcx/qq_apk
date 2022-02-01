package com.tencent.open.base.http;

import android.content.Context;
import java.lang.ref.WeakReference;

public class AvatarUpdateService$AvatarUpdateTask
{
  public String a;
  public WeakReference<Context> a;
  public String b;
  public WeakReference<HttpImageDownloadAsyncTask.TaskCompleteCallback> b;
  public String c;
  
  public AvatarUpdateService$AvatarUpdateTask(AvatarUpdateService paramAvatarUpdateService, Context paramContext, String paramString1, String paramString2, String paramString3, HttpImageDownloadAsyncTask.TaskCompleteCallback paramTaskCompleteCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramTaskCompleteCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.http.AvatarUpdateService.AvatarUpdateTask
 * JD-Core Version:    0.7.0.1
 */