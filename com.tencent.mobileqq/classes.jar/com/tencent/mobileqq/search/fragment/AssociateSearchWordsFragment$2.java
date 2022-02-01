package com.tencent.mobileqq.search.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;

class AssociateSearchWordsFragment$2
  implements View.OnTouchListener
{
  AssociateSearchWordsFragment$2(AssociateSearchWordsFragment paramAssociateSearchWordsFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a.getBaseActivity();
    if ((paramView instanceof ActiveEntitySearchActivity)) {
      ((ActiveEntitySearchActivity)paramView).c();
    } else if ((paramView instanceof UniteSearchActivity)) {
      ((UniteSearchActivity)paramView).b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.2
 * JD-Core Version:    0.7.0.1
 */