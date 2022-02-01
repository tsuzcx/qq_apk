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
    if ((this.this$0.getParent() != null) && (this.mOriginalWindowAttachCount == EmoticonLinearLayout.access$000(this.this$0)) && (this.this$0.mPointView != null))
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)this.this$0.mPointView.getTag();
      if (localEmoticonInfo != null)
      {
        if ((this.this$0.callback != null) && (this.this$0.callback.onLongClick(localEmoticonInfo)))
        {
          this.this$0.mPointView = null;
          return;
        }
        EmoticonLinearLayout localEmoticonLinearLayout = this.this$0;
        localEmoticonLinearLayout.mHasPerformedLongPress = true;
        localEmoticonLinearLayout.getParent().requestDisallowInterceptTouchEvent(true);
        this.this$0.sendAccessibilityEvent(2);
        if ("delete".equals(localEmoticonInfo.action))
        {
          this.this$0.mDelete.run();
          return;
        }
        if (!"setting".equals(localEmoticonInfo.action))
        {
          if ("add".equals(localEmoticonInfo.action)) {
            return;
          }
          localEmoticonLinearLayout = this.this$0;
          localEmoticonLinearLayout.showPopupEmo(localEmoticonLinearLayout.mPointView, localEmoticonInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */