package com.tencent.mobileqq.location.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

class LocationPickFragment$9
  implements TextWatcher
{
  LocationPickFragment$9(LocationPickFragment paramLocationPickFragment, View paramView1, View paramView2, View paramView3) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      this.a.setVisibility(8);
      this.b.setVisibility(0);
      this.c.setVisibility(0);
    }
    else
    {
      this.a.setVisibility(0);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    paramEditable = paramEditable.toString().trim();
    if (!TextUtils.isEmpty(paramEditable))
    {
      LocationPickFragment.b(this.d).a(paramEditable);
      return;
    }
    LocationPickFragment.b(this.d).a("");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.9
 * JD-Core Version:    0.7.0.1
 */