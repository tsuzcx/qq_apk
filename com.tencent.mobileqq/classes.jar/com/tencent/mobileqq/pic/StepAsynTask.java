package com.tencent.mobileqq.pic;

import android.os.AsyncTask;

public class StepAsynTask
  extends AsyncTask<Object, Object, Object>
{
  StepAsynTask a;
  
  protected Void a(Object... paramVarArgs)
  {
    return null;
  }
  
  protected void onPostExecute(Object paramObject)
  {
    StepAsynTask localStepAsynTask = this.a;
    if (localStepAsynTask != null) {
      localStepAsynTask.execute(new Object[0]);
    }
    super.onPostExecute(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.StepAsynTask
 * JD-Core Version:    0.7.0.1
 */