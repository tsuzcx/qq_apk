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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onNetworkChanged,netState:");
    ((StringBuilder)localObject1).append(GlobalUtil.getNetStatus());
    ab.c("LogReportManager", ((StringBuilder)localObject1).toString());
    localObject1 = e.d();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      try
      {
        if (localObject2.equals(b.class)) {
          b.g().c();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
    k.a().post(new g(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.f
 * JD-Core Version:    0.7.0.1
 */