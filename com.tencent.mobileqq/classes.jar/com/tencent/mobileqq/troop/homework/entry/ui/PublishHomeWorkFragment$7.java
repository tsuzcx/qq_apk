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
    paramView.jdField_a_of_type_Boolean = (paramBoolean ^ true);
    if (paramBoolean)
    {
      paramView.l = true;
      paramView.c(paramView.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.7
 * JD-Core Version:    0.7.0.1
 */