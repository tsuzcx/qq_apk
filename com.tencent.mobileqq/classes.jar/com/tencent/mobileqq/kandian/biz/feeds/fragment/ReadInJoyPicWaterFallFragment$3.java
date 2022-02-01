package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;

class ReadInJoyPicWaterFallFragment$3
  extends RecyclerView.OnScrollListener
{
  ReadInJoyPicWaterFallFragment$3(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt != 0) {
      ReadInJoyPicWaterFallFragment.a(this.a);
    }
    if (ChannelModeConfigHandler.a()) {
      ReadInJoyLogicEngineEventDispatcher.a().k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.3
 * JD-Core Version:    0.7.0.1
 */