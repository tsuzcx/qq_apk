package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.ViewParent;

class EmoticonLinearLayout$CheckForLongPress
  implements Runnable
{
  private int mOriginalWindowAttachCount;
  
  EmoticonLinearLayout$CheckForLongPress(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
  public void rememberWindowAttachCount()
  {
    this.mOriginalWindowAttachCount = EmoticonLinearLayout.access$100(this.this$0);
  }
  
  public void run()
  {
    EmoticonInfo localEmoticonInfo;
    if ((this.this$0.getParent() != null) && (this.mOriginalWindowAttachCount == EmoticonLinearLayout.access$000(this.this$0)) && (this.this$0.mPointView != null))
    {
      localEmoticonInfo = (EmoticonInfo)this.this$0.mPointView.getTag();
      if (localEmoticonInfo != null)
      {
        if ((this.this$0.callback != null) && (this.this$0.callback.onLongClick(localEmoticonInfo))) {
          break label172;
        }
        this.this$0.mHasPerformedLongPress = true;
        this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
        this.this$0.sendAccessibilityEvent(2);
        if (!"delete".equals(localEmoticonInfo.action)) {
          break label132;
        }
        this.this$0.mDelete.run();
      }
    }
    label132:
    while (("setting".equals(localEmoticonInfo.action)) || ("add".equals(localEmoticonInfo.action))) {
      return;
    }
    this.this$0.showPopupEmo(this.this$0.mPointView, localEmoticonInfo);
    return;
    label172:
    this.this$0.mPointView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */