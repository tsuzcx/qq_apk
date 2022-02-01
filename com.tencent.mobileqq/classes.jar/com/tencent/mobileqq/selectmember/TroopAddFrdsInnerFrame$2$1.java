package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class TroopAddFrdsInnerFrame$2$1
  implements Runnable
{
  TroopAddFrdsInnerFrame$2$1(TroopAddFrdsInnerFrame.2 param2, ArrayList paramArrayList) {}
  
  public void run()
  {
    ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).showResultForBatchAddFriendData(this.b.a.h, this.b.a.f, this.b.a.c, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.2.1
 * JD-Core Version:    0.7.0.1
 */