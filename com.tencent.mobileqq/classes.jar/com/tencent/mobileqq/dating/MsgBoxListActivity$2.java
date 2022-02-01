package com.tencent.mobileqq.dating;

import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import java.util.Iterator;
import java.util.List;
import tencent.nearby.now.nearby_now_anchor.AnchorStatus;

class MsgBoxListActivity$2
  extends MsgBoxProtocol.ReqNowStateObserver
{
  MsgBoxListActivity$2(MsgBoxListActivity paramMsgBoxListActivity, List paramList) {}
  
  public void a(boolean paramBoolean, List<nearby_now_anchor.AnchorStatus> paramList, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramBundle.hasNext())
      {
        RecentItemNearbyLiveTipData localRecentItemNearbyLiveTipData = (RecentItemNearbyLiveTipData)paramBundle.next();
        this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxListActivity.updateLivingState(localRecentItemNearbyLiveTipData, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.2
 * JD-Core Version:    0.7.0.1
 */