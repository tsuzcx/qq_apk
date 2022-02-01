package com.tencent.mobileqq.doutu.combo;

import android.content.Context;
import com.tencent.mobileqq.doutu.api.IDoutuUtils;
import com.tencent.mobileqq.qroute.QRoute;

final class ComboResource$2
  implements Runnable
{
  ComboResource$2(Context paramContext) {}
  
  public void run()
  {
    ((IDoutuUtils)QRoute.api(IDoutuUtils.class)).markResDamaged(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboResource.2
 * JD-Core Version:    0.7.0.1
 */