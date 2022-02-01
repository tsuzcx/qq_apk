package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView;
import com.tencent.mobileqq.kandian.biz.tab.ReadInjoyXRecyclerView;

class ReadInJoyPicWaterFallFragment$1
  extends ReadInjoyXRecyclerView
{
  ReadInJoyPicWaterFallFragment$1(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    if ((paramInt == 0) && (this.h.a != null)) {
      this.h.a.setData(this.h.d(), this.h.r);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.1
 * JD-Core Version:    0.7.0.1
 */