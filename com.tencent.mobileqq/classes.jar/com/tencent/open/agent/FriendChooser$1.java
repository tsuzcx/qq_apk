package com.tencent.open.agent;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class FriendChooser$1
  implements AdapterView.OnItemClickListener
{
  FriendChooser$1(FriendChooser paramFriendChooser) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Friend localFriend = (Friend)this.a.jdField_a_of_type_ComTencentOpenAgentFriendChooser$GridViewAdapter.getItem(paramInt);
    if ((localFriend != null) && (this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(localFriend.a)))
    {
      this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.b(localFriend.a);
      this.a.b.remove(localFriend);
      this.a.e();
      ((OpenFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).g();
      this.a.b(false);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.1
 * JD-Core Version:    0.7.0.1
 */