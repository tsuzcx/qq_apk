package com.tencent.mobileqq.selectmember;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import java.util.List;

class TroopMemberListInnerFrame$8
  extends TroopOnlineMemberObserver
{
  TroopMemberListInnerFrame$8(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  protected void a(boolean paramBoolean, String paramString, List<String> paramList)
  {
    if (TextUtils.equals(paramString, this.a.b))
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity != null) && (this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isFinishing())) {
        return;
      }
      if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity)) {
        ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).onOnlineRsp(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.8
 * JD-Core Version:    0.7.0.1
 */