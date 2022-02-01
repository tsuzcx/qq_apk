package com.tencent.mobileqq.troop.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopRemarkEditFragment$7
  implements View.OnClickListener
{
  TroopRemarkEditFragment$7(TroopRemarkEditFragment paramTroopRemarkEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (TroopRemarkEditFragment.b(this.a) != null)
    {
      TroopRemarkEditFragment localTroopRemarkEditFragment = this.a;
      TroopRemarkEditFragment.a(localTroopRemarkEditFragment, TroopRemarkEditFragment.b(localTroopRemarkEditFragment));
    }
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment.7
 * JD-Core Version:    0.7.0.1
 */