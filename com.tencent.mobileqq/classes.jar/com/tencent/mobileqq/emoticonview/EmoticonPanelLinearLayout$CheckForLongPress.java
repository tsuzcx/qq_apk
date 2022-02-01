package com.tencent.mobileqq.emoticonview;

import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import bdla;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class EmoticonPanelLinearLayout$CheckForLongPress
  implements Runnable
{
  private MotionEvent event;
  int mOriginalWindowAttachCount;
  SparseIntArray mReportSparseArray;
  
  public EmoticonPanelLinearLayout$CheckForLongPress(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout, MotionEvent paramMotionEvent)
  {
    this.event = paramMotionEvent;
    this.mReportSparseArray = new SparseIntArray(10);
    this.mReportSparseArray.put(7, 1);
    this.mReportSparseArray.put(1, 1);
    this.mReportSparseArray.put(2, 1);
    this.mReportSparseArray.put(4, 2);
    this.mReportSparseArray.put(5, 2);
    this.mReportSparseArray.put(11, 3);
    this.mReportSparseArray.put(6, 4);
    this.mReportSparseArray.put(9, 4);
    this.mReportSparseArray.put(10, 5);
  }
  
  private void reportShowPopupEmoEvent(EmoticonInfo paramEmoticonInfo)
  {
    if (EmoticonPanelLinearLayout.access$300(this.this$0) == null) {}
    int i;
    do
    {
      return;
      i = this.mReportSparseArray.get(paramEmoticonInfo.type, -1);
    } while (i == -1);
    bdla.b(EmoticonPanelLinearLayout.access$300(this.this$0).app, "dc00898", "", "", "0X800AEEC", "0X800AEEC", i, 0, "", "", "", "");
  }
  
  public void rememberWindowAttachCount()
  {
    this.mOriginalWindowAttachCount = EmoticonPanelLinearLayout.access$400(this.this$0);
  }
  
  public void run()
  {
    if ((this.this$0.getParent() != null) && (this.mOriginalWindowAttachCount == EmoticonPanelLinearLayout.access$000(this.this$0)) && (this.this$0.mPointView != null))
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)this.this$0.mPointView.getTag();
      if (localEmoticonInfo != null)
      {
        if ((this.this$0.callback != null) && (this.this$0.callback.onLongClick(localEmoticonInfo))) {
          break label154;
        }
        this.this$0.mHasPerformedLongPress = true;
        this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
        this.this$0.sendAccessibilityEvent(2);
        EmoticonPanelLinearLayout.access$100(this.this$0, this.this$0.mPointView, localEmoticonInfo);
        if (EmoticonPanelLinearLayout.access$200(this.this$0, localEmoticonInfo))
        {
          this.this$0.showPopupEmo(this.this$0.mPointView, localEmoticonInfo);
          reportShowPopupEmoEvent(localEmoticonInfo);
        }
      }
    }
    return;
    label154:
    this.this$0.mPointView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */