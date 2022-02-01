package com.tencent.tmassistantsdk.internal.logreport;

import android.os.Handler;
import com.tencent.tmassistantbase.network.INetworkChangedObserver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;

class f
  implements INetworkChangedObserver
{
  f(e parame) {}
  
  public void onNetworkChanged()
  {
    ab.c("LogReportManager", "onNetworkChanged,netState:" + GlobalUtil.getNetStatus());
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
    k.a().post(new g(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.f
 * JD-Core Version:    0.7.0.1
 */