package com.tencent.mobileqq.startup.step;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class OnceIfSuccessStep
  extends Step
{
  public static ConcurrentHashMap<String, Boolean> a = new ConcurrentHashMap(6);
  
  public boolean step()
  {
    if ((Boolean)a.get(String.valueOf(this.mId)) == null)
    {
      boolean bool = super.step();
      if (bool) {
        a.put(String.valueOf(this.mId), Boolean.valueOf(bool));
      }
      return bool;
    }
    QLog.d("OnceIfSuccessStep", 1, " us + " + this.mName + " mId + " + this.mId);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OnceIfSuccessStep
 * JD-Core Version:    0.7.0.1
 */