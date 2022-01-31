package com.tencent.open.base.http;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.util.concurrent.Executor;

public abstract class HttpAsyncTask
  extends AsyncTask
{
  public String a;
  public String b;
  
  public HttpAsyncTask(String paramString1, String paramString2)
  {
    this.a = paramString1;
    if (!paramString1.toLowerCase().startsWith("http")) {
      this.a = ("https://openmobile.qq.com/" + paramString1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.base.http.HttpAsyncTask
 * JD-Core Version:    0.7.0.1
 */