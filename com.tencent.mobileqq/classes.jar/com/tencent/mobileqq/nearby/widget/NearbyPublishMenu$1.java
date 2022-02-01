package com.tencent.mobileqq.nearby.widget;

import android.view.View;
import android.view.View.OnClickListener;

class NearbyPublishMenu$1
  implements View.OnClickListener
{
  NearbyPublishMenu$1(NearbyPublishMenu paramNearbyPublishMenu) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof MenuItem)) && (this.a.a != null))
    {
      MenuItem localMenuItem = (MenuItem)paramView.getTag();
      this.a.a.a(this.a, paramView, localMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyPublishMenu.1
 * JD-Core Version:    0.7.0.1
 */