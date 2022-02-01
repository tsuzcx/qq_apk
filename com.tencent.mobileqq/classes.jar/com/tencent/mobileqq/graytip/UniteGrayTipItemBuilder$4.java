package com.tencent.mobileqq.graytip;

import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.mobileqq.data.GrayTipsMessageConstants.HighlightItem;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class UniteGrayTipItemBuilder$4
  extends View.AccessibilityDelegate
{
  UniteGrayTipItemBuilder$4(UniteGrayTipItemBuilder paramUniteGrayTipItemBuilder, long paramLong1, long paramLong2, ArrayList paramArrayList, SpannableStringBuilder paramSpannableStringBuilder) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder sendAccessibilityEvent click msg uinseq=", Long.valueOf(this.a), ",holder.mPosition=", Long.valueOf(this.b) });
      }
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (GrayTipsMessageConstants.HighlightItem)localIterator.next();
        if (localObject != null)
        {
          localObject = (ClickableSpan[])this.d.getSpans(((GrayTipsMessageConstants.HighlightItem)localObject).start, ((GrayTipsMessageConstants.HighlightItem)localObject).end, MessageForGrayTips.HightlightClickableSpan.class);
          if (localObject.length > 0) {
            localObject[0].onClick(paramView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */