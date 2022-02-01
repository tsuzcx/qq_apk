package com.tencent.mobileqq.hotpic;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.image.AbstractGifImage;

class HotPicRecyclerView$1
  extends RecyclerView.OnScrollListener
{
  HotPicRecyclerView$1(HotPicRecyclerView paramHotPicRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      HotVideoBlurTaskManager.c();
      this.a.b();
      if (paramInt != 2) {
        break label128;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer.a(true);
    }
    for (;;)
    {
      if ((paramInt == 0) && (this.a.jdField_a_of_type_Int == 2))
      {
        ((StaggeredGridLayoutManager)this.a.getLayoutManager()).findFirstCompletelyVisibleItemPositions(this.a.jdField_a_of_type_ArrayOfInt);
        if ((this.a.jdField_a_of_type_ArrayOfInt[0] == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$PullAndFastScrollListener != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$PullAndFastScrollListener.d();
        }
      }
      this.a.jdField_a_of_type_Int = paramInt;
      return;
      this.a.c();
      AbstractGifImage.pauseAll();
      HotVideoBlurTaskManager.b();
      break;
      label128:
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer.a(false);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicScrollVelometer.a(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */