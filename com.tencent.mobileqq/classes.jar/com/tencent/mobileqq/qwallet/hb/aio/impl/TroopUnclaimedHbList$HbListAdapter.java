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
  private Context jdField_a_of_type_AndroidContentContext;
  private List<RedPackGrapInfo> jdField_a_of_type_JavaUtilList;
  
  TroopUnclaimedHbList$HbListAdapter(TroopUnclaimedHbList paramTroopUnclaimedHbList, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public TroopUnclaimedHbList.HbListAdapter.HbItemViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplTroopUnclaimedHbList;
    return new TroopUnclaimedHbList.HbListAdapter.HbItemViewHolder(this, new TroopUnclaimedHbList.HbListItem(paramViewGroup, this.jdField_a_of_type_AndroidContentContext, new QQWalletTroopHbItem(TroopUnclaimedHbList.a(paramViewGroup), this.jdField_a_of_type_AndroidContentContext, TroopUnclaimedHbList.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplTroopUnclaimedHbList))));
  }
  
  public void a(TroopUnclaimedHbList.HbListAdapter.HbItemViewHolder paramHbItemViewHolder, int paramInt)
  {
    RedPackGrapInfo localRedPackGrapInfo = (RedPackGrapInfo)this.jdField_a_of_type_JavaUtilList.get(paramHbItemViewHolder.getPosition());
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
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
            break label242;
          }
          return;
          int i = k;
          if (j < this.jdField_a_of_type_JavaUtilList.size())
          {
            localObject = (RedPackGrapInfo)this.jdField_a_of_type_JavaUtilList.get(j);
            if ((localObject == null) || (!((RedPackGrapInfo)localObject).sBiilNo.equals(paramString))) {
              break label250;
            }
            i = j;
          }
          j = i;
          if (i == this.jdField_a_of_type_JavaUtilList.size()) {
            j = i - 1;
          }
          this.jdField_a_of_type_JavaUtilList.remove(j);
          notifyItemRemoved(j);
          notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilList.size());
          if (TroopUnclaimedHbList.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplTroopUnclaimedHbList) != null)
          {
            if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
            {
              TroopUnclaimedHbList.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplTroopUnclaimedHbList).postDelayed(new TroopUnclaimedHbList.HbListAdapter.1(this), 300L);
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplTroopUnclaimedHbList.a != null) {
              this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplTroopUnclaimedHbList.a.dismiss();
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
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return;
    }
    localList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty())) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList.HbListAdapter
 * JD-Core Version:    0.7.0.1
 */