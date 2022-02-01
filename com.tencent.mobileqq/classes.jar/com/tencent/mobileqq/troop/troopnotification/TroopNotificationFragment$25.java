package com.tencent.mobileqq.troop.troopnotification;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.troop.adapter.QuickRecyclerAdapter.OnItemClickListener;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousHolder;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopNotificationFragment$25
  implements QuickRecyclerAdapter.OnItemClickListener
{
  TroopNotificationFragment$25(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!(paramViewHolder instanceof SuspiciousHolder)) {
      return;
    }
    paramView = (SuspiciousHolder)paramViewHolder;
    if (paramView.a.msg_type.get() == 2) {
      TroopNotificationFragment.a(this.a, paramView);
    }
  }
  
  public boolean a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.25
 * JD-Core Version:    0.7.0.1
 */