package com.tencent.mobileqq.troop.troopnotification;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousAdapter;

class TroopNotificationFragment$28
  extends RecyclerView.OnScrollListener
{
  TroopNotificationFragment$28(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    this.a.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (((paramRecyclerView instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition() + 1 == TroopNotificationFragment.a(this.a).getItemCount())) {
        TroopNotificationFragment.n(this.a);
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      if (paramInt != 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
        this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.28
 * JD-Core Version:    0.7.0.1
 */