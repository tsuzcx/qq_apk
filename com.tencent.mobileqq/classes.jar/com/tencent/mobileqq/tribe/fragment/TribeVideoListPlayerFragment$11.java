package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tribe.playvideo.TribeVideoADItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TribeVideoListPlayerFragment$11
  implements ActionSheet.OnButtonClickListener
{
  TribeVideoListPlayerFragment$11(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, ActionSheet paramActionSheet, TribeVideoADItem paramTribeVideoADItem) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.a.a();
    ThreadManager.excute(new TribeVideoListPlayerFragment.11.1(this), 128, null, true);
    TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment);
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.11
 * JD-Core Version:    0.7.0.1
 */