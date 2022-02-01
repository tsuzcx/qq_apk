package com.tencent.mobileqq.tribe.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.playvideo.TribeItem;
import com.tencent.mobileqq.tribe.playvideo.TribeVideoItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class TribeVideoListPlayerFragment$TribeListAdapter$1
  implements View.OnClickListener
{
  TribeVideoListPlayerFragment$TribeListAdapter$1(TribeVideoListPlayerFragment.TribeListAdapter paramTribeListAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeListAdapter.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", ((TribeItem)this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeListAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).b);
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeListAdapter.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().startActivity((Intent)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeListAdapter.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem.c == 31) {}
    for (localObject = "1";; localObject = "2")
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_tribe", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeListAdapter.jdField_a_of_type_ComTencentMobileqqTribePlayvideoTribeVideoItem.d, ((TribeItem)this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeListAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a + "", "", (String)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.TribeListAdapter.1
 * JD-Core Version:    0.7.0.1
 */