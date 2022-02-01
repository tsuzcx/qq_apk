package com.tencent.mobileqq.selectmember;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class TroopMemberListInnerFrame$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TroopMemberListInnerFrame$3(TroopMemberListInnerFrame paramTroopMemberListInnerFrame, ViewGroup paramViewGroup) {}
  
  public void onGlobalLayout()
  {
    this.b.w.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.a.removeView(this.b.w);
    Object localObject = this.b;
    localObject = TroopMemberListInnerFrame.a((TroopMemberListInnerFrame)localObject, ((TroopMemberListInnerFrame)localObject).w);
    if (localObject == null) {
      return;
    }
    this.b.w.setTag(localObject);
    if (this.b.e != null) {
      this.b.e.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.3
 * JD-Core Version:    0.7.0.1
 */