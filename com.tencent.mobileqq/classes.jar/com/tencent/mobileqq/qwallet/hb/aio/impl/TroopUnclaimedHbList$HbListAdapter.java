package com.tencent.mobileqq.qwallet.hb.aio.impl;

import Wallet.RedPackGrapInfo;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class TroopUnclaimedHbList$HbListAdapter
  extends RecyclerView.Adapter<TroopUnclaimedHbList.HbListAdapter.HbItemViewHolder>
{
  private List<RedPackGrapInfo> b;
  private Context c;
  
  TroopUnclaimedHbList$HbListAdapter(TroopUnclaimedHbList paramTroopUnclaimedHbList, Context paramContext)
  {
    this.c = paramContext;
    this.b = new ArrayList();
  }
  
  public TroopUnclaimedHbList.HbListAdapter.HbItemViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.a;
    return new TroopUnclaimedHbList.HbListAdapter.HbItemViewHolder(this, new TroopUnclaimedHbList.HbListItem(paramViewGroup, this.c, new QQWalletTroopHbItem(TroopUnclaimedHbList.a(paramViewGroup), this.c, TroopUnclaimedHbList.h(this.a))));
  }
  
  public void a(TroopUnclaimedHbList.HbListAdapter.HbItemViewHolder paramHbItemViewHolder, int paramInt)
  {
    RedPackGrapInfo localRedPackGrapInfo = (RedPackGrapInfo)this.b.get(paramHbItemViewHolder.getPosition());
    if (localRedPackGrapInfo == null) {
      return;
    }
    paramHbItemViewHolder = paramHbItemViewHolder.a;
    if (paramHbItemViewHolder != null) {
      paramHbItemViewHolder.a(localRedPackGrapInfo);
    }
  }
  
  void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.b != null)
        {
          if (!this.b.isEmpty()) {
            break label242;
          }
          return;
          int i = k;
          if (j < this.b.size())
          {
            localObject = (RedPackGrapInfo)this.b.get(j);
            if ((localObject == null) || (!((RedPackGrapInfo)localObject).sBiilNo.equals(paramString))) {
              break label250;
            }
            i = j;
          }
          j = i;
          if (i == this.b.size()) {
            j = i - 1;
          }
          this.b.remove(j);
          notifyItemRemoved(j);
          notifyItemRangeChanged(j, this.b.size());
          if (TroopUnclaimedHbList.e(this.a) != null)
          {
            if ((this.b != null) && (!this.b.isEmpty()))
            {
              TroopUnclaimedHbList.e(this.a).postDelayed(new TroopUnclaimedHbList.HbListAdapter.1(this), 300L);
              return;
            }
            if (this.a.a != null) {
              this.a.a.dismiss();
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramString)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("removeHbList occur an exception: ");
          ((StringBuilder)localObject).append(paramString);
          QLog.e("TroopUnclaimedRedPacketList", 2, ((StringBuilder)localObject).toString());
        }
      }
      return;
      label242:
      int k = 0;
      int j = 0;
      continue;
      label250:
      j += 1;
    }
  }
  
  void a(List<RedPackGrapInfo> paramList)
  {
    List localList = this.b;
    if (localList == null) {
      return;
    }
    localList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    if ((localList != null) && (!localList.isEmpty())) {
      return this.b.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList.HbListAdapter
 * JD-Core Version:    0.7.0.1
 */