package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.qphone.base.util.QLog;

class TroopUnclaimedHbList$RedPacketRefreshReceiver
  extends BroadcastReceiver
{
  private TroopUnclaimedHbList$RedPacketRefreshReceiver(TroopUnclaimedHbList paramTroopUnclaimedHbList) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("troop_hblist_broadcast_action".equals(paramIntent.getAction()))
    {
      if (!TroopUnclaimedHbList.i(this.a)) {
        return;
      }
      int i = paramIntent.getIntExtra("result_code", 0);
      int j = paramIntent.getIntExtra("grap_hb_state", 0);
      paramContext = paramIntent.getStringExtra("listid");
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("RedPacketRefreshReceiver|resultCode:");
        paramIntent.append(i);
        paramIntent.append("|listId: ");
        paramIntent.append(paramContext);
        paramIntent.append("|grabHbState: ");
        paramIntent.append(j);
        QLog.d("TroopUnclaimedRedPacketList", 2, paramIntent.toString());
      }
      if (i == -20180322)
      {
        if (TroopUnclaimedHbList.j(this.a) != null) {
          TroopUnclaimedHbList.j(this.a).setVisibility(8);
        }
        if (TroopUnclaimedHbList.e(this.a) != null) {
          TroopUnclaimedHbList.e(this.a).setVisibility(8);
        }
      }
      else if (i == -20180323)
      {
        if (TroopUnclaimedHbList.j(this.a) != null) {
          TroopUnclaimedHbList.j(this.a).setVisibility(0);
        }
        if (TroopUnclaimedHbList.e(this.a) != null) {
          TroopUnclaimedHbList.e(this.a).setVisibility(0);
        }
        if ((TroopUnclaimedHbList.c(this.a) != null) && (!TextUtils.isEmpty(paramContext)))
        {
          TroopUnclaimedHbList.c(this.a).a(paramContext);
          NotifyMsgApiImpl.onGroupHbGrabbedNotify(TroopUnclaimedHbList.k(this.a), TroopUnclaimedHbList.l(this.a), paramContext);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList.RedPacketRefreshReceiver
 * JD-Core Version:    0.7.0.1
 */