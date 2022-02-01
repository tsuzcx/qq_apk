package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DropdownView$1
  implements View.OnClickListener
{
  DropdownView$1(DropdownView paramDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.a.clearFocus();
    this.a.e.hideSoftInputFromWindow(this.a.a.getWindowToken(), 0);
    if ((this.a.a.getAdapter() != null) && (this.a.a.getAdapter().getCount() > 0)) {
      if ((((ImageView)paramView).getDrawable() == this.a.b) && (!this.a.d))
      {
        DropdownView.a(this.a).postDelayed(new DropdownView.1.1(this, paramView), 250L);
        paramView.getContext();
      }
      else
      {
        this.a.a.dismissDropDown();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DropdownView.1
 * JD-Core Version:    0.7.0.1
 */