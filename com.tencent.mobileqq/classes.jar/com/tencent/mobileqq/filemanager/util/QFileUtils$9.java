package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;

final class QFileUtils$9
  extends DirectForwarder.CallBack
{
  QFileUtils$9(Context paramContext) {}
  
  public void a(AsyncTask<Integer, Integer, String> paramAsyncTask, int paramInt)
  {
    super.a(paramAsyncTask, paramInt);
    DirectForwarder.a(this.a, paramAsyncTask, paramInt, new QFileUtils.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils.9
 * JD-Core Version:    0.7.0.1
 */