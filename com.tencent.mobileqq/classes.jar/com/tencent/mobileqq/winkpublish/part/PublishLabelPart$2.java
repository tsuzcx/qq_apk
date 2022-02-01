package com.tencent.mobileqq.winkpublish.part;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.winkpublish.event.PublishKeyboardEvent;

class PublishLabelPart$2
  extends RecyclerView.OnScrollListener
{
  PublishLabelPart$2(PublishLabelPart paramPublishLabelPart) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (1 == paramInt) {
      SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(false));
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLabelPart.2
 * JD-Core Version:    0.7.0.1
 */