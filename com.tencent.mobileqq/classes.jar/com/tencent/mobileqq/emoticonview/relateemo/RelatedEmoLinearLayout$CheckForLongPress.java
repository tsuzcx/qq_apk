package com.tencent.mobileqq.emoticonview.relateemo;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;

class RelatedEmoLinearLayout$CheckForLongPress
  implements Runnable
{
  private MotionEvent event;
  int mOriginalWindowAttachCount;
  
  public RelatedEmoLinearLayout$CheckForLongPress(RelatedEmoLinearLayout paramRelatedEmoLinearLayout, MotionEvent paramMotionEvent)
  {
    this.event = paramMotionEvent;
  }
  
  public void rememberWindowAttachCount()
  {
    this.mOriginalWindowAttachCount = RelatedEmoLinearLayout.access$300(this.this$0);
  }
  
  public void run()
  {
    if ((this.this$0.getParent() != null) && (this.mOriginalWindowAttachCount == RelatedEmoLinearLayout.access$000(this.this$0)) && (RelatedEmoLinearLayout.access$100(this.this$0) != null) && ((EmoticonInfo)RelatedEmoLinearLayout.access$100(this.this$0).getTag() != null))
    {
      RelatedEmoLinearLayout.access$202(this.this$0, true);
      RelatedEmoLinearLayout.access$100(this.this$0).performLongClick();
      this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
      this.this$0.sendAccessibilityEvent(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */