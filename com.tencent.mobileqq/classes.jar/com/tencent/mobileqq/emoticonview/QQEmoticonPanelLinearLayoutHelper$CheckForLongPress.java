package com.tencent.mobileqq.emoticonview;

import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;

class QQEmoticonPanelLinearLayoutHelper$CheckForLongPress
  implements Runnable
{
  private MotionEvent event;
  int mOriginalWindowAttachCount;
  SparseIntArray mReportSparseArray;
  
  public QQEmoticonPanelLinearLayoutHelper$CheckForLongPress(QQEmoticonPanelLinearLayoutHelper paramQQEmoticonPanelLinearLayoutHelper, MotionEvent paramMotionEvent)
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
    if (QQEmoticonPanelLinearLayoutHelper.access$900(this.this$0) == null) {}
    int i;
    do
    {
      return;
      i = this.mReportSparseArray.get(paramEmoticonInfo.type, -1);
    } while (i == -1);
    ReportController.b(QQEmoticonPanelLinearLayoutHelper.access$900(this.this$0).a, "dc00898", "", "", "0X800AEEC", "0X800AEEC", i, 0, "", "", "", "");
  }
  
  public void rememberWindowAttachCount()
  {
    this.mOriginalWindowAttachCount = QQEmoticonPanelLinearLayoutHelper.access$600(this.this$0).getWindowAttachCount();
  }
  
  public void run()
  {
    if ((QQEmoticonPanelLinearLayoutHelper.access$600(this.this$0).getParent() != null) && (this.mOriginalWindowAttachCount == QQEmoticonPanelLinearLayoutHelper.access$600(this.this$0).getWindowAttachCount()) && (this.this$0.mPointView != null))
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)this.this$0.mPointView.getTag();
      if (localEmoticonInfo != null)
      {
        if ((QQEmoticonPanelLinearLayoutHelper.access$200(this.this$0) != null) && (QQEmoticonPanelLinearLayoutHelper.access$200(this.this$0).onLongClick(localEmoticonInfo))) {
          break label166;
        }
        this.this$0.mHasPerformedLongPress = true;
        QQEmoticonPanelLinearLayoutHelper.access$600(this.this$0).getParent().requestDisallowInterceptTouchEvent(true);
        QQEmoticonPanelLinearLayoutHelper.access$600(this.this$0).sendAccessibilityEvent(2);
        QQEmoticonPanelLinearLayoutHelper.access$700(this.this$0, this.this$0.mPointView, localEmoticonInfo);
        if (QQEmoticonPanelLinearLayoutHelper.access$800(this.this$0, localEmoticonInfo))
        {
          this.this$0.showPopupEmo(this.this$0.mPointView, localEmoticonInfo);
          reportShowPopupEmoEvent(localEmoticonInfo);
        }
      }
    }
    return;
    label166:
    this.this$0.mPointView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */