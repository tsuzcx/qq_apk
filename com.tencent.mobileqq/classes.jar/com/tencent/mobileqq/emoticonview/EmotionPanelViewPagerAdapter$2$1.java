package com.tencent.mobileqq.emoticonview;

import com.tencent.image.URLDrawable;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class EmotionPanelViewPagerAdapter$2$1
  implements AbsListView.OnScrollListener
{
  EmotionPanelViewPagerAdapter$2$1(EmotionPanelViewPagerAdapter.2 param2) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2))
    {
      URLDrawable.resume();
      if (this.this$1.val$panelType == 1) {
        EmotionPanelViewPagerAdapter.access$100(this.this$1.this$0, this.this$1.val$data, this.this$1.val$listView);
      }
      return;
    }
    URLDrawable.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */