package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.nearby.home.INearbyTabInfo;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class BaseMsgBoxActivity$8
  extends RedpointObserver
{
  BaseMsgBoxActivity$8(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mRedpointObserver.onDataChange(): isSucc=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.msg_box", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.a.isFromNearby) && (this.a.mTabBarView != null))
    {
      if (this.a.mTabInfos.size() <= 0) {
        return;
      }
      int k = -1;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.a.mTabInfos.size()) {
          break;
        }
        if (((INearbyTabInfo)this.a.mTabInfos.get(i)).getTabType() == 7)
        {
          j = i;
          break;
        }
        i += 1;
      }
      if (j < 0) {
        return;
      }
      localObject = this.a;
      BaseMsgBoxActivity.access$100((BaseMsgBoxActivity)localObject, ((BaseMsgBoxActivity)localObject).mTabBarView.a(j));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.8
 * JD-Core Version:    0.7.0.1
 */