package com.tencent.mtt.supportui.views.viewpager;

class ViewPager$4$1
  implements Runnable
{
  ViewPager$4$1(ViewPager.4 param4) {}
  
  public void run()
  {
    ViewPager.OnPageReadyListener localOnPageReadyListener;
    if (this.this$1.this$0.mOnPageReadyListener != null)
    {
      localOnPageReadyListener = this.this$1.this$0.mOnPageReadyListener;
      if (!this.this$1.this$0.isGallery()) {
        break label56;
      }
    }
    label56:
    for (int i = this.this$1.this$0.mCurrentScreen;; i = this.this$1.this$0.mCurItem)
    {
      localOnPageReadyListener.onPageReady(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.viewpager.ViewPager.4.1
 * JD-Core Version:    0.7.0.1
 */