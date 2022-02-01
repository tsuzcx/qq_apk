package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;

final class QFileUtils$8
  extends DirectForwarder.CallBack
{
  QFileUtils$8(Context paramContext) {}
  
  public void a(AsyncTask<Integer, Integer, String> paramAsyncTask, int paramInt)
  {
    try
    {
      DirectForwarder.a(this.a, paramAsyncTask, paramInt, new QFileUtils.8.1(this));
      super.a(paramAsyncTask, paramInt);
      return;
    }
    catch (Exception paramAsyncTask)
    {
      paramAsyncTask.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils.8
 * JD-Core Version:    0.7.0.1
 */