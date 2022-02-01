package com.tencent.mobileqq.emoticonview;

class BasePanelView$6
  implements Runnable
{
  BasePanelView$6(BasePanelView paramBasePanelView) {}
  
  public void run()
  {
    int i = this.this$0.viewPager.getCurrentItem();
    this.this$0.viewPager.setAdapter(this.this$0.pageAdapter);
    this.this$0.viewPager.setCurrentItem(i, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BasePanelView.6
 * JD-Core Version:    0.7.0.1
 */