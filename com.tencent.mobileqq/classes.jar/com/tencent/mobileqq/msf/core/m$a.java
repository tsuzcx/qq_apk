package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class m$a
  implements Runnable
{
  private int b = 0;
  
  public m$a(m paramm, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void run()
  {
    Object localObject = (ArrayList)this.a.a.sender.e.remove(Integer.valueOf(this.b));
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("remove merged ssoseq list: ");
        localStringBuilder.append(((ArrayList)localObject).toString());
        localStringBuilder.append(" from SSO LoginMerge ");
        localStringBuilder.append(this.b);
        QLog.d("MSF.C.NetConnTag", 2, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SSO LoginMerge's ssoseq ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("list has been removed by error code.");
      QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.m.a
 * JD-Core Version:    0.7.0.1
 */