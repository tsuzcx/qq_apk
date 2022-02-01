package com.tencent.mobileqq.troop.troopcreate.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.troop.troopcreate.tempapi.ICreateTroopForUI;

class NewTroopContactView$6
  implements View.OnFocusChangeListener
{
  NewTroopContactView$6(NewTroopContactView paramNewTroopContactView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView = NewTroopContactView.a(this.a);
      NewTroopContactView localNewTroopContactView = this.a;
      paramView.showContactSearchFragment(localNewTroopContactView, localNewTroopContactView.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView.6
 * JD-Core Version:    0.7.0.1
 */