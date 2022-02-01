package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class ProcessInfoUtil$1
  implements Runnable
{
  ProcessInfoUtil$1(String paramString) {}
  
  public void run()
  {
    Object localObject1 = ProcessInfoUtil.a();
    if (localObject1 != null)
    {
      int i = ProcessInfoUtil.a(BaseApplicationImpl.getContext(), this.a);
      if (i == -1) {
        return;
      }
      long l = System.currentTimeMillis();
      Object localObject2 = ((SharedPreferences)localObject1).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pid");
      localStringBuilder.append(this.a);
      ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), i);
      localObject1 = ((SharedPreferences)localObject1).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start_time");
      ((StringBuilder)localObject2).append(this.a);
      ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), l).apply();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("recordProcessStart - ");
        ((StringBuilder)localObject1).append(this.a);
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(l);
        QLog.d("ProcessUtils", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.ProcessInfoUtil.1
 * JD-Core Version:    0.7.0.1
 */