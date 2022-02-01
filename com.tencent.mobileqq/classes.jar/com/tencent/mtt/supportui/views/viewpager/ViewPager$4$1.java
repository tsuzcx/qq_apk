package com.tencent.mtt.supportui.views.viewpager;

class ViewPager$4$1
  implements Runnable
{
  ViewPager$4$1(ViewPager.4 param4) {}
  
  public void run()
  {
    if (this.this$1.this$0.mOnPageReadyListener != null)
    {
      ViewPager.OnPageReadyListener localOnPageReadyListener = this.this$1.this$0.mOnPageReadyListener;
      int i;
      if (this.this$1.this$0.isGallery()) {
        i = this.this$1.this$0.mCurrentScreen;
      } else {
        i = this.this$1.this$0.mCurItem;
      }
      localOnPageReadyListener.onPageReady(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.viewpager.ViewPager.4.1
 * JD-Core Version:    0.7.0.1
 */