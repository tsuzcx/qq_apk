package com.tencent.mobileqq.hiboom;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.MotionEvent;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener;
import com.tencent.mobileqq.hotpic.ScrollVelometer;
import com.tencent.mobileqq.hotpic.ScrollVelometer.SpeedListener;

public class RichTextPanelScrollListener
  extends RecyclerView.OnScrollListener
  implements ScrollVelometer.SpeedListener
{
  private int jdField_a_of_type_Int = 0;
  private EmotionPanelListView.PullAndFastScrollListener jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener;
  private ScrollVelometer jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer = new ScrollVelometer(200, this);
  
  public RichTextPanelScrollListener(EmotionPanelListView.PullAndFastScrollListener paramPullAndFastScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener = paramPullAndFastScrollListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      EmotionPanelListView.PullAndFastScrollListener localPullAndFastScrollListener = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener;
      if (localPullAndFastScrollListener != null)
      {
        localPullAndFastScrollListener.onPullUp();
        this.jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer.a(false);
      }
    }
  }
  
  public boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer.a(true);
    }
    else if ((i == 1) && (((GridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0))
    {
      paramRecyclerView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener;
      if (paramRecyclerView != null) {
        paramRecyclerView.onPullDown();
      }
    }
    return false;
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      AbstractGifImage.resumeAll();
    } else {
      AbstractGifImage.pauseAll();
    }
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == 2) && (((GridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0))
    {
      paramRecyclerView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener;
      if (paramRecyclerView != null) {
        paramRecyclerView.onPullDown();
      }
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer.a(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanelScrollListener
 * JD-Core Version:    0.7.0.1
 */