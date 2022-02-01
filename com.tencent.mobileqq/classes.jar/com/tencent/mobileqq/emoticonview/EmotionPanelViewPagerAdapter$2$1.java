package com.tencent.mobileqq.emoticonview;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import mqq.os.MqqHandler;

class EmotionPanelViewPagerAdapter$2$1
  implements AbsListView.OnScrollListener
{
  EmotionPanelViewPagerAdapter$2$1(EmotionPanelViewPagerAdapter.2 param2) {}
  
  protected boolean isInAIOAndSystemPanelReport(int paramInt)
  {
    return (this.this$1.this$0.panelController.isInAIO()) && (paramInt == 0) && (this.this$1.val$panelType == 1);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    processScrollStateChange(paramInt);
    if (isInAIOAndSystemPanelReport(paramInt)) {
      ReportController.b(null, "dc00898", "", "", "0X800B9F4", "0X800B9F4", 0, 0, "", "", "", "");
    }
  }
  
  protected void processScrollStateChange(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2))
    {
      URLDrawable.pause();
      if (this.this$1.val$panelType == 15) {
        ThreadManager.getSubThreadHandler().post(new EmotionPanelViewPagerAdapter.2.1.1(this));
      }
    }
    else
    {
      URLDrawable.resume();
      if (this.this$1.val$panelType == 1) {
        EmotionPanelViewPagerAdapter.access$100(this.this$1.this$0, this.this$1.val$data, this.this$1.val$listView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */