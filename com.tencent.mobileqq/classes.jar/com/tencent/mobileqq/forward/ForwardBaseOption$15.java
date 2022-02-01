package com.tencent.mobileqq.forward;

import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;

class ForwardBaseOption$15
  extends DirectForwarder.CallBack
{
  ForwardBaseOption$15(ForwardBaseOption paramForwardBaseOption) {}
  
  public void a(AsyncTask<Integer, Integer, String> paramAsyncTask, int paramInt)
  {
    try
    {
      DirectForwarder.a(this.a.a, paramAsyncTask, paramInt, new ForwardBaseOption.15.1(this));
      super.a(paramAsyncTask, paramInt);
      return;
    }
    catch (Exception paramAsyncTask)
    {
      paramAsyncTask.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.15
 * JD-Core Version:    0.7.0.1
 */