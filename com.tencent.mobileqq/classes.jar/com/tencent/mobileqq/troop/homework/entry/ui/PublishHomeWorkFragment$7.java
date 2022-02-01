package com.tencent.mobileqq.troop.homework.entry.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;

class PublishHomeWorkFragment$7
  implements View.OnFocusChangeListener
{
  PublishHomeWorkFragment$7(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    paramView = this.a;
    paramView.F = (paramBoolean ^ true);
    if (paramBoolean)
    {
      paramView.al = true;
      paramView.c(paramView.d.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.7
 * JD-Core Version:    0.7.0.1
 */