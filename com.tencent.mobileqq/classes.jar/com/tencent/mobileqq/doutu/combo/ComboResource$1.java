package com.tencent.mobileqq.doutu.combo;

import android.content.Context;
import com.tencent.mobileqq.doutu.api.IDoutuUtils;
import com.tencent.mobileqq.qroute.QRoute;

final class ComboResource$1
  implements Runnable
{
  ComboResource$1(Context paramContext) {}
  
  public void run()
  {
    ((IDoutuUtils)QRoute.api(IDoutuUtils.class)).markResDamaged(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboResource.1
 * JD-Core Version:    0.7.0.1
 */