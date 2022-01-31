package com.tencent.tmassistantsdk.internal.logreport;

import android.os.Handler;
import com.tencent.tmassistantbase.network.INetworkChangedObserver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.l;

class f
  implements INetworkChangedObserver
{
  f(e parame) {}
  
  public void onNetworkChanged()
  {
    ac.c("LogReportManager", "onNetworkChanged,netState:" + GlobalUtil.getNetStatus());
    Class[] arrayOfClass = e.d();
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
            b.g().c();
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
    l.a().post(new g(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.f
 * JD-Core Version:    0.7.0.1
 */