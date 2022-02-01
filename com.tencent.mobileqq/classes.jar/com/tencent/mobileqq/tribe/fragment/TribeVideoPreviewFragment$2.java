package com.tencent.mobileqq.tribe.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;

class TribeVideoPreviewFragment$2
  implements View.OnClickListener
{
  TribeVideoPreviewFragment$2(TribeVideoPreviewFragment paramTribeVideoPreviewFragment, String paramString) {}
  
  public void onClick(View paramView)
  {
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.getActivity();
    if (localFragmentActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.a(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.getActivity().app, "dc00899", "Grp_tribe", "", "post", "save_video", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localFragmentActivity.requestPermissions(new TribeVideoPreviewFragment.2.1(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */