package com.tencent.mobileqq.structmsg;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;

class StructMsgForGeneralShare$1
  implements View.OnLongClickListener
{
  StructMsgForGeneralShare$1(StructMsgForGeneralShare paramStructMsgForGeneralShare, OnLongClickAndTouchListener paramOnLongClickAndTouchListener) {}
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)paramView.getTag();
    if (!TextUtils.isEmpty(localAbsStructMsgElement.an)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localAbsStructMsgElement.an).intValue();
    }
    return this.a.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.1
 * JD-Core Version:    0.7.0.1
 */