package com.tencent.mobileqq.nearby.widget;

import android.view.View;
import android.view.View.OnClickListener;

class NearbyCustomDialog$2
  implements View.OnClickListener
{
  NearbyCustomDialog$2(NearbyCustomDialog paramNearbyCustomDialog, ButtonInfo paramButtonInfo) {}
  
  public void onClick(View paramView)
  {
    this.b.dismiss();
    if (this.a.d != null) {
      this.a.d.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyCustomDialog.2
 * JD-Core Version:    0.7.0.1
 */