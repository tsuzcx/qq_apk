package com.tencent.mobileqq.troop.troopcreate.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.FrameLayout;
import com.tencent.mobileqq.troop.troopcreate.tempapi.ICreateTroopForUI;
import com.tencent.widget.PinnedFooterExpandableListView;

class NewTroopContactView$8
  implements TextWatcher
{
  NewTroopContactView$8(NewTroopContactView paramNewTroopContactView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable))
    {
      this.a.e.setVisibility(8);
      this.a.x.setVisibility(0);
    }
    else
    {
      this.a.e.setVisibility(0);
      this.a.x.setVisibility(8);
    }
    if (NewTroopContactView.a(this.a) != null) {
      NewTroopContactView.a(this.a).startSearch(paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView.8
 * JD-Core Version:    0.7.0.1
 */