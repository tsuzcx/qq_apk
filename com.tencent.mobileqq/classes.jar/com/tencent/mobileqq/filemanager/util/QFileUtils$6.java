package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;

final class QFileUtils$6
  extends DirectForwarder.CallBack
{
  QFileUtils$6(Context paramContext) {}
  
  protected void a(AsyncTask<Integer, Integer, String> paramAsyncTask, int paramInt)
  {
    super.a(paramAsyncTask, paramInt);
    DirectForwarder.a(this.b, paramAsyncTask, paramInt, new QFileUtils.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils.6
 * JD-Core Version:    0.7.0.1
 */