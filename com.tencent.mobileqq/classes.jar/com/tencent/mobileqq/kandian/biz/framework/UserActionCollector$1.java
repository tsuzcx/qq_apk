package com.tencent.mobileqq.kandian.biz.framework;

import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;

class UserActionCollector$1
  implements Runnable
{
  UserActionCollector$1(UserActionCollector paramUserActionCollector, int paramInt, AbsListView paramAbsListView) {}
  
  public void run()
  {
    int i = this.this$0.s;
    try
    {
      int j;
      if (this.a == 0)
      {
        j = this.b.getHeight() - ImmersiveUtils.getStatusBarHeight(this.b.getContext()) - this.b.getResources().getDimensionPixelOffset(2131299578);
        i = j;
      }
      else
      {
        j = this.b.getHeight();
        i = j;
      }
    }
    catch (Exception localException)
    {
      AIOUtils.a("UserActionCollector", "calculte height error !", localException);
    }
    if (i > 0) {
      this.this$0.s = i;
    }
    this.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.UserActionCollector.1
 * JD-Core Version:    0.7.0.1
 */