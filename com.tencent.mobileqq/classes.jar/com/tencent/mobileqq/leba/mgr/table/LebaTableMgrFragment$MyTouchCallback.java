package com.tencent.mobileqq.leba.mgr.table;

import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback;

public class LebaTableMgrFragment$MyTouchCallback
  extends ItemTouchHelper.Callback
{
  LebaMgrDataLogic jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic;
  LebaTableMgrAdpter jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter;
  OverScrollRecyclerView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView;
  
  public LebaTableMgrFragment$MyTouchCallback(OverScrollRecyclerView paramOverScrollRecyclerView, LebaMgrDataLogic paramLebaMgrDataLogic, LebaTableMgrAdpter paramLebaTableMgrAdpter)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView = paramOverScrollRecyclerView;
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic = paramLebaMgrDataLogic;
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter = paramLebaTableMgrAdpter;
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if ((paramViewHolder != null) && (paramViewHolder.itemView != null) && ((paramViewHolder instanceof LebaTableMgrAdpter.PluginViewHolder)) && (Build.VERSION.SDK_INT >= 21)) {}
    try
    {
      paramViewHolder.itemView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
      paramViewHolder = paramViewHolder.itemView;
      if (paramBoolean) {}
      for (float f = 20.0F;; f = 0.0F)
      {
        paramViewHolder.setTranslationZ(f);
        return;
      }
      return;
    }
    catch (Exception paramViewHolder)
    {
      QLog.i("LebaTableMgrFragment", 1, "setItemShadow", paramViewHolder);
    }
  }
  
  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    super.clearView(paramRecyclerView, paramViewHolder);
    QLog.i("LebaTableMgrFragment", 1, "clearView");
    a(paramViewHolder, false);
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return makeMovementFlags(15, 0);
  }
  
  public boolean isLongPressDragEnabled()
  {
    return false;
  }
  
  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    int i = paramViewHolder1.getAdapterPosition();
    int j = paramViewHolder2.getAdapterPosition();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic != null) {
      return this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic.a(paramRecyclerView, i, j);
    }
    return false;
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.i("LebaTableMgrFragment", 1, "onSelectedChanged" + paramInt);
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic.a(this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 2);
      a(paramViewHolder, true);
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.b();
  }
  
  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.table.LebaTableMgrFragment.MyTouchCallback
 * JD-Core Version:    0.7.0.1
 */