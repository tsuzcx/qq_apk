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
    this.a.a.setVisibility(8);
    this.c.b(this.b, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.MediaPreviewAdapter.1
 * JD-Core Version:    0.7.0.1
 */