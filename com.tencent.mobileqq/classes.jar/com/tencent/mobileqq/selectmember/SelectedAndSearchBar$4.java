package com.tencent.mobileqq.selectmember;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class SelectedAndSearchBar$4
  implements View.OnFocusChangeListener
{
  SelectedAndSearchBar$4(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (SelectedAndSearchBar.b(this.a) != null) {
      SelectedAndSearchBar.b(this.a).a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectedAndSearchBar.4
 * JD-Core Version:    0.7.0.1
 */