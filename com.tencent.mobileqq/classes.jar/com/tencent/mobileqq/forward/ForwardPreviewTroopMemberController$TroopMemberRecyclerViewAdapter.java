package com.tencent.mobileqq.forward;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class ForwardPreviewTroopMemberController$TroopMemberRecyclerViewAdapter
  extends RecyclerView.Adapter<ForwardPreviewTroopMemberController.ViewHolder>
{
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  List<Pair<String, String>> jdField_a_of_type_JavaUtilList;
  
  public ForwardPreviewTroopMemberController$TroopMemberRecyclerViewAdapter(QQAppInterface paramQQAppInterface, Context paramContext, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public ForwardPreviewTroopMemberController.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == ForwardPreviewTroopMemberController.b)
    {
      paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297134)));
      return new ForwardPreviewTroopMemberController.ViewHolder(paramViewGroup);
    }
    return new ForwardPreviewTroopMemberController.TroopMemberViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559249, paramViewGroup, false));
  }
  
  public void a(ForwardPreviewTroopMemberController.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder.a == ForwardPreviewTroopMemberController.b) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if (paramViewHolder.a == ForwardPreviewTroopMemberController.a)
      {
        int i = paramInt - 1;
        if (i < 0) {
          QLog.e("Forward.Preview.Dialog", 2, "type normal in wrong index");
        }
        Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((paramViewHolder instanceof ForwardPreviewTroopMemberController.TroopMemberViewHolder)) {
          ((ForwardPreviewTroopMemberController.TroopMemberViewHolder)paramViewHolder).a((String)localPair.first, (String)localPair.second, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
        }
      }
    }
  }
  
  public void a(List<Pair<String, String>> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return ForwardPreviewTroopMemberController.b;
    }
    return ForwardPreviewTroopMemberController.a;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      ((GridLayoutManager)paramRecyclerView).setSpanSizeLookup(new ForwardPreviewTroopMemberController.TroopMemberRecyclerViewAdapter.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.TroopMemberRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */