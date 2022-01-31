package com.tencent.tmassistantsdk.internal.logreport;

import android.os.Handler;
import com.tencent.tmassistantbase.network.a;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;

class f
  implements a
{
  f(e parame) {}
  
  public void onNetworkChanged()
  {
    r.c("LogReportManager", "onNetworkChanged,netState:" + GlobalUtil.getNetStatus());
    Class[] arrayOfClass = e.e();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          if (localClass.equals(b.class)) {
            b.h().d();
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    com.tencent.tmassistantbase.util.f.a().post(new g(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.f
 * JD-Core Version:    0.7.0.1
 */