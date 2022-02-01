package com.tencent.mobileqq.selectmember;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class TroopMemberListInnerFrame$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TroopMemberListInnerFrame$2(TroopMemberListInnerFrame paramTroopMemberListInnerFrame, ViewGroup paramViewGroup) {}
  
  public void onGlobalLayout()
  {
    this.b.v.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.a.removeView(this.b.v);
    Object localObject = this.b;
    localObject = TroopMemberListInnerFrame.a((TroopMemberListInnerFrame)localObject, ((TroopMemberListInnerFrame)localObject).v);
    if (localObject == null) {
      return;
    }
    this.b.v.setTag(localObject);
    if (this.b.e != null) {
      this.b.e.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.2
 * JD-Core Version:    0.7.0.1
 */