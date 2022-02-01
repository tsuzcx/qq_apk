package com.tencent.open.base.http;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.util.concurrent.Executor;

public abstract class HttpAsyncTask<Param, Progress, Result>
  extends AsyncTask<Param, Progress, Result>
{
  protected String a = null;
  protected String b = null;
  
  public HttpAsyncTask(String paramString1, String paramString2)
  {
    this.a = paramString1;
    if (!paramString1.toLowerCase().startsWith("http"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://openmobile.qq.com/");
      localStringBuilder.append(paramString1);
      this.a = localStringBuilder.toString();
    }
    this.b = paramString2;
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  public Executor a()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return AsyncTask.THREAD_POOL_EXECUTOR;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.http.HttpAsyncTask
 * JD-Core Version:    0.7.0.1
 */