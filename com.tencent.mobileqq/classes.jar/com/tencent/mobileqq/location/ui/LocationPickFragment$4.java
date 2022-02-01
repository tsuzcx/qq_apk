package com.tencent.mobileqq.location.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class LocationPickFragment$4
  implements View.OnKeyListener
{
  LocationPickFragment$4(LocationPickFragment paramLocationPickFragment, EditText paramEditText) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (LocationPickFragment.d(this.b).h()))
    {
      LocationPickFragment.d(this.b).f();
      return true;
    }
    if ((paramInt != 84) && (paramInt != 66)) {
      return false;
    }
    LocationPickFragment.b(this.b).a(this.a.getText().toString().trim());
    LocationPickFragment.e(this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.4
 * JD-Core Version:    0.7.0.1
 */