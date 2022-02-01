package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocalFileBrowserActivity$3
  implements View.OnClickListener
{
  LocalFileBrowserActivity$3(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    }
    Button localButton = (Button)paramView.findViewById(2131365625);
    if (localButton.getTag() != null)
    {
      this.a.e = ((Integer)localButton.getTag()).intValue();
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(null);
      }
    }
    this.a.m();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.3
 * JD-Core Version:    0.7.0.1
 */