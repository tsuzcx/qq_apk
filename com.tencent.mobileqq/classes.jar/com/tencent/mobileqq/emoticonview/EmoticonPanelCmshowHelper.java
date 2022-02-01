package com.tencent.mobileqq.emoticonview;

import android.os.SystemClock;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EmoticonPanelCmshowHelper
  extends AbstractEmoticonPanelHelper
{
  private static final int EXPOSE_STATE_BIG = 1;
  private static final int EXPOSE_STATE_NONE = -1;
  private static final int EXPOSE_STATE_SMALL = 0;
  private static final String TAG = "EmoticonPanelCmshowHelper";
  private static final long TIME_LIMIT = 2000L;
  private int mExposeState = -1;
  private long mTabExposeTime;
  
  public EmoticonPanelCmshowHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private boolean hasCmShowTab(List<EmotionPanelInfo> paramList)
  {
    if (paramList == null) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)paramList.next();
      if ((localEmotionPanelInfo != null) && (localEmotionPanelInfo.type == 15)) {
        return true;
      }
    }
    return false;
  }
  
  private void onBigExpose()
  {
    if (this.mExposeState != 1)
    {
      ApolloDtReportUtil.a("aio", "emojicmtab", "bigexpose", null);
      this.mExposeState = 1;
    }
  }
  
  private void onSmallExpose()
  {
    if (this.mExposeState != 0)
    {
      ApolloDtReportUtil.a("aio", "emojicmtab", "smallexpose", null);
      this.mExposeState = 0;
    }
  }
  
  public String getTag()
  {
    return "EmoticonPanelCmshowHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 5, 3, 4 };
  }
  
  public void onHide(boolean paramBoolean)
  {
    this.mExposeState = -1;
    this.mTabExposeTime = 0L;
  }
  
  public void onPageSelected(int paramInt)
  {
    try
    {
      if (this.mPanelController == null) {
        return;
      }
      if (this.mPanelController.mEmoticonTabAdapter != null) {
        this.mPanelController.mEmoticonTabAdapter.onCmShowRedDotClick(paramInt);
      }
      if (this.mPanelController.isEmoticonOnShow(15))
      {
        if (this.mPanelController.isPanelOpen())
        {
          onBigExpose();
          return;
        }
        onSmallExpose();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("EmoticonPanelCmshowHelper", 1, "onPageSelected error", localThrowable);
      return;
    }
    this.mExposeState = -1;
  }
  
  public void onPullDown()
  {
    try
    {
      if ((this.mPanelController != null) && (this.mPanelController.isEmoticonOnShow(15))) {
        onSmallExpose();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("EmoticonPanelCmshowHelper", 1, "onPullDown error", localThrowable);
    }
  }
  
  public void onPullUp()
  {
    try
    {
      if ((this.mPanelController != null) && (this.mPanelController.isEmoticonOnShow(15))) {
        onBigExpose();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("EmoticonPanelCmshowHelper", 1, "onPullUp error", localThrowable);
    }
  }
  
  public void onShow()
  {
    try
    {
      if (this.mPanelController != null)
      {
        if (hasCmShowTab(this.mPanelController.panelDataList))
        {
          long l = SystemClock.elapsedRealtime();
          if (l - this.mTabExposeTime > 2000L)
          {
            ApolloDtReportUtil.a("aio", "emojicmtab", "expose", null);
            this.mTabExposeTime = l;
          }
        }
        if (this.mPanelController.mEmoticonTabAdapter != null) {
          this.mPanelController.mEmoticonTabAdapter.updateCmShowRedDot();
        }
        if (this.mPanelController.isEmoticonOnShow(15))
        {
          if (this.mPanelController.isPanelOpen())
          {
            onBigExpose();
            return;
          }
          onSmallExpose();
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("EmoticonPanelCmshowHelper", 1, "onShow error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCmshowHelper
 * JD-Core Version:    0.7.0.1
 */