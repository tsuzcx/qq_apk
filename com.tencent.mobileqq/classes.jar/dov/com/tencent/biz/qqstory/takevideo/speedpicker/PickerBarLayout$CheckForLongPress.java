package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.view.ViewParent;

class PickerBarLayout$CheckForLongPress
  implements Runnable
{
  private int a;
  
  PickerBarLayout$CheckForLongPress(PickerBarLayout paramPickerBarLayout) {}
  
  public void a()
  {
    this.a = PickerBarLayout.b(this.this$0);
  }
  
  public void run()
  {
    if ((this.this$0.getParent() != null) && (this.a == PickerBarLayout.a(this.this$0)))
    {
      this.this$0.a = true;
      this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
      this.this$0.sendAccessibilityEvent(2);
      this.this$0.a(PickerBarLayout.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerBarLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */