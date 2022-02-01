package com.tencent.mobileqq.troop.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MediaPreviewAdapter$1
  implements View.OnClickListener
{
  MediaPreviewAdapter$1(MediaPreviewAdapter paramMediaPreviewAdapter, MediaPreviewAdapter.ViewHolder paramViewHolder, MediaPreviewInfo paramMediaPreviewInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter$ViewHolder.a.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewInfo, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaPreviewAdapter$ViewHolder);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.MediaPreviewAdapter.1
 * JD-Core Version:    0.7.0.1
 */