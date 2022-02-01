package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;

class ReadInJoyTabAdapter$1
  implements View.OnClickListener
{
  ReadInJoyTabAdapter$1(ReadInJoyTabAdapter paramReadInJoyTabAdapter, TabChannelCoverInfo paramTabChannelCoverInfo1, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo2, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyTabAdapter.a(this.e, this.a);
    if (ReadInJoyTabAdapter.a(this.e) != null) {
      ReadInJoyTabAdapter.a(this.e).a(this.b);
    }
    paramView = this.c;
    int j = ChannelCoverView.b;
    int i;
    if (this.d.getVisibility() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    ChannelCoverView.a("0X8009496", paramView, j, i, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyTabAdapter.1
 * JD-Core Version:    0.7.0.1
 */