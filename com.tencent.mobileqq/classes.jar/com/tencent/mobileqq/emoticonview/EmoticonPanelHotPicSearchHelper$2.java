package com.tencent.mobileqq.emoticonview;

import com.tencent.image.AbstractGifImage;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class EmoticonPanelHotPicSearchHelper$2
  implements AbsListView.OnScrollListener
{
  EmoticonPanelHotPicSearchHelper$2(EmoticonPanelHotPicSearchHelper paramEmoticonPanelHotPicSearchHelper) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2)) {
      AbstractGifImage.pauseAll();
    } else {
      AbstractGifImage.resumeAll();
    }
    this.this$0.mLastScrollState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper.2
 * JD-Core Version:    0.7.0.1
 */