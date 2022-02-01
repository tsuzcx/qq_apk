package com.tencent.mobileqq.startup.step;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class OnceIfSuccessStep
  extends Step
{
  public static ConcurrentHashMap<String, Boolean> sStepRunCache = new ConcurrentHashMap(6);
  
  public boolean step()
  {
    Object localObject = (Boolean)sStepRunCache.get(String.valueOf(this.mId));
    boolean bool1 = true;
    if (localObject == null)
    {
      boolean bool2 = super.step();
      bool1 = bool2;
      if (bool2)
      {
        sStepRunCache.put(String.valueOf(this.mId), Boolean.valueOf(bool2));
        return bool2;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" us + ");
      ((StringBuilder)localObject).append(this.mName);
      ((StringBuilder)localObject).append(" mId + ");
      ((StringBuilder)localObject).append(this.mId);
      QLog.d("OnceIfSuccessStep", 1, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OnceIfSuccessStep
 * JD-Core Version:    0.7.0.1
 */