package com.tencent.mobileqq.emoticonview;

import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.popanim.PopOutEmoticonGesture;
import com.tencent.mobileqq.popanim.util.PopOutEmoticonUtil;
import com.tencent.mobileqq.popanim.view.PopOutAnimViewHelper;
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
    if (QQEmoticonPanelLinearLayoutHelper.access$800(this.this$0) != null)
    {
      if (QQEmoticonPanelLinearLayoutHelper.access$800(this.this$0).getBaseChatPie() == null) {
        return;
      }
      int i = this.mReportSparseArray.get(paramEmoticonInfo.type, -1);
      if (i != -1) {
        ReportController.b(QQEmoticonPanelLinearLayoutHelper.access$200(this.this$0).getAppRuntime(), "dc00898", "", "", "0X800AEEC", "0X800AEEC", i, 0, "", "", "", "");
      }
    }
  }
  
  public void rememberWindowAttachCount()
  {
    this.mOriginalWindowAttachCount = QQEmoticonPanelLinearLayoutHelper.access$500(this.this$0).getWindowAttachCount();
  }
  
  public void run()
  {
    if ((QQEmoticonPanelLinearLayoutHelper.access$500(this.this$0).getParent() != null) && (this.mOriginalWindowAttachCount == QQEmoticonPanelLinearLayoutHelper.access$500(this.this$0).getWindowAttachCount()) && (this.this$0.mPointView != null))
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)this.this$0.mPointView.getTag();
      if (localEmoticonInfo != null)
      {
        if ((QQEmoticonPanelLinearLayoutHelper.access$100(this.this$0) != null) && (QQEmoticonPanelLinearLayoutHelper.access$100(this.this$0).onLongClick(localEmoticonInfo)))
        {
          this.this$0.mPointView = null;
          return;
        }
        Object localObject = this.this$0;
        ((QQEmoticonPanelLinearLayoutHelper)localObject).mHasPerformedLongPress = true;
        QQEmoticonPanelLinearLayoutHelper.access$500((QQEmoticonPanelLinearLayoutHelper)localObject).getParent().requestDisallowInterceptTouchEvent(true);
        QQEmoticonPanelLinearLayoutHelper.access$500(this.this$0).sendAccessibilityEvent(2);
        localObject = this.this$0;
        QQEmoticonPanelLinearLayoutHelper.access$600((QQEmoticonPanelLinearLayoutHelper)localObject, ((QQEmoticonPanelLinearLayoutHelper)localObject).mPointView, localEmoticonInfo);
        if (QQEmoticonPanelLinearLayoutHelper.access$700(this.this$0, localEmoticonInfo))
        {
          localObject = this.this$0;
          ((QQEmoticonPanelLinearLayoutHelper)localObject).showPopupEmo(((QQEmoticonPanelLinearLayoutHelper)localObject).mPointView, localEmoticonInfo);
          reportShowPopupEmoEvent(localEmoticonInfo);
          if (QQEmoticonPanelLinearLayoutHelper.access$800(this.this$0) != null)
          {
            if (PopOutEmoticonUtil.a(QQEmoticonPanelLinearLayoutHelper.access$900(this.this$0), QQEmoticonPanelLinearLayoutHelper.access$1000(this.this$0), QQEmoticonPanelLinearLayoutHelper.access$800(this.this$0).getCurType()))
            {
              if (this.this$0.mPopOutEmoticonGesture == null)
              {
                this.this$0.mPopOutEmoticonGesture = new PopOutEmoticonGesture();
                localObject = this.this$0.mPopOutEmoticonGesture;
                ViewGroup localViewGroup = QQEmoticonPanelLinearLayoutHelper.access$000(this.this$0);
                EmoticonPanelLinearLayout localEmoticonPanelLinearLayout = QQEmoticonPanelLinearLayoutHelper.access$500(this.this$0);
                QQEmoticonPanelLinearLayoutHelper localQQEmoticonPanelLinearLayoutHelper = this.this$0;
                ((PopOutEmoticonGesture)localObject).a(localViewGroup, localEmoticonPanelLinearLayout, localQQEmoticonPanelLinearLayoutHelper, QQEmoticonPanelLinearLayoutHelper.access$800(localQQEmoticonPanelLinearLayoutHelper));
              }
              this.this$0.mPopOutEmoticonGesture.a(localEmoticonInfo);
            }
            if (PopOutEmoticonUtil.a(QQEmoticonPanelLinearLayoutHelper.access$900(this.this$0), localEmoticonInfo))
            {
              QQEmoticonPanelLinearLayoutHelper.access$1102(this.this$0, false);
              PopOutAnimViewHelper.a("0X800BB9E", localEmoticonInfo);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */