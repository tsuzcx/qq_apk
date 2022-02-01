package com.tencent.mobileqq.forward;

import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;

class ForwardBaseOption$13
  extends DirectForwarder.CallBack
{
  ForwardBaseOption$13(ForwardBaseOption paramForwardBaseOption) {}
  
  protected void a(AsyncTask<Integer, Integer, String> paramAsyncTask, int paramInt)
  {
    try
    {
      DirectForwarder.a(this.a.a, paramAsyncTask, paramInt, new ForwardBaseOption.13.1(this));
      super.a(paramAsyncTask, paramInt);
      return;
    }
    catch (Exception paramAsyncTask)
    {
      paramAsyncTask.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.13
 * JD-Core Version:    0.7.0.1
 */