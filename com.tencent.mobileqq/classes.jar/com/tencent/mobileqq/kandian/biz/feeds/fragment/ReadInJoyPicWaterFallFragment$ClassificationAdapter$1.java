package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import java.util.ArrayList;

class ReadInJoyPicWaterFallFragment$ClassificationAdapter$1
  implements View.OnClickListener
{
  ReadInJoyPicWaterFallFragment$ClassificationAdapter$1(ReadInJoyPicWaterFallFragment.ClassificationAdapter paramClassificationAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.a.a(paramView, i);
    GalleryReportedUtils.a(this.a.a.a(), "0X8009A71", this.a.a.b(), ((ReadInJoyPicWaterFallFragment.ClassData)this.a.a.a.get(i)).a.mChannelCoverId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.ClassificationAdapter.1
 * JD-Core Version:    0.7.0.1
 */