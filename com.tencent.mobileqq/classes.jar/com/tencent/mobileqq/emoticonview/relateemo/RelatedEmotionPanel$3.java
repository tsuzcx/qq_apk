package com.tencent.mobileqq.emoticonview.relateemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

class RelatedEmotionPanel$3
  extends RecyclerView.OnScrollListener
{
  RelatedEmotionPanel$3(RelatedEmotionPanel paramRelatedEmotionPanel) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      return;
    }
    AbstractGifImage.pauseAll();
  }
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if ((!paramRecyclerView.canScrollVertically(1)) && (RelatedEmotionPanel.access$200(this.this$0) == 1) && (!RelatedEmotionPanel.access$300(this.this$0)) && (RelatedEmotionPanel.access$400(this.this$0).getData() != null))
    {
      RelatedEmotionPanel.access$302(this.this$0, true);
      paramRecyclerView = RelatedEmotionPanel.access$100(this.this$0);
      String str = this.this$0.mCurFriendUin;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(RelatedEmotionPanel.access$400(this.this$0).getData().size());
      localStringBuilder.append("");
      ReportController.b(paramRecyclerView, "dc00898", "", str, "0X800B156", "0X800B156", 0, 0, localStringBuilder.toString(), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmotionPanel.3
 * JD-Core Version:    0.7.0.1
 */