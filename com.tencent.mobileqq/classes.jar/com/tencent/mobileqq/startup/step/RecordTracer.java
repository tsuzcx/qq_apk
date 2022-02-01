package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trackrecordlib.core.RecordManager;

public class RecordTracer
  extends Step
{
  private static final String a = "RecordTracer";
  
  public static RecordTracer a()
  {
    return RecordTracer.Holder.a;
  }
  
  protected boolean doStep()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      QLog.d(a, 2, "doStep: RecordTracer");
      try
      {
        RecordManager.getInstance().startRecord(BaseApplicationImpl.getContext(), new RecordTracer.1(this), new RecordTracer.2(this));
        return true;
      }
      catch (Throwable localThrowable)
      {
        QLog.e(a, 1, localThrowable, new Object[0]);
        localThrowable.printStackTrace();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.RecordTracer
 * JD-Core Version:    0.7.0.1
 */