package com.tencent.mobileqq.friends.intimate;

import NS_MINI_APP_MISC.MISC.StAppPlayingInfo;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class IntimatePlayTogetherMiniGameCardView$IntimatePlayTogetherAdapter$1
  implements View.OnClickListener
{
  IntimatePlayTogetherMiniGameCardView$IntimatePlayTogetherAdapter$1(IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherAdapter paramIntimatePlayTogetherAdapter, MISC.StAppPlayingInfo paramStAppPlayingInfo, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    MiniGamePlayTogetherHandler.a(paramView.getContext(), this.jdField_a_of_type_NS_MINI_APP_MISCMISC$StAppPlayingInfo.appMetaInfo, IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimatePlayTogetherMiniGameCardView$IntimatePlayTogetherAdapter), IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimatePlayTogetherMiniGameCardView$IntimatePlayTogetherAdapter), this.jdField_a_of_type_Boolean);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView.IntimatePlayTogetherAdapter.1
 * JD-Core Version:    0.7.0.1
 */