package com.tencent.mobileqq.nearby;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyFragmentEnterAdapter$3
  implements View.OnClickListener
{
  NearbyFragmentEnterAdapter$3(NearbyFragmentEnterAdapter paramNearbyFragmentEnterAdapter) {}
  
  public void onClick(View paramView)
  {
    NearbyFragmentEnterAdapter.ViewHolder localViewHolder = (NearbyFragmentEnterAdapter.ViewHolder)paramView.getTag();
    if (this.a.a != null) {
      this.a.a.a(paramView, localViewHolder.a, localViewHolder.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.3
 * JD-Core Version:    0.7.0.1
 */