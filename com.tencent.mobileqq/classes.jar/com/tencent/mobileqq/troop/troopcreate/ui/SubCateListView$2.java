package com.tencent.mobileqq.troop.troopcreate.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;

class SubCateListView$2
  extends AnimatorListenerAdapter
{
  SubCateListView$2(SubCateListView paramSubCateListView, boolean paramBoolean, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a) {
      this.b.setVisibility(8);
    }
    int j = 0;
    int i = j;
    if (!this.a)
    {
      paramAnimator = new int[2];
      this.b.getLocationOnScreen(paramAnimator);
      int k = DisplayUtil.a(this.d.b).b() - paramAnimator[1];
      int m = this.c;
      i = j;
      if (k < m) {
        i = m - k;
      }
    }
    if (this.d.d != null) {
      this.d.d.a(true ^ this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.SubCateListView.2
 * JD-Core Version:    0.7.0.1
 */