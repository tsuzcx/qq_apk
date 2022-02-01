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
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class ForwardTroopMemberControllerForMiniPie$TroopMemberRecyclerViewAdapter
  extends RecyclerView.Adapter<ForwardTroopMemberControllerForMiniPie.ViewHolder>
{
  float jdField_a_of_type_Float = 1.0F;
  Context jdField_a_of_type_AndroidContentContext;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  List<Pair<String, String>> jdField_a_of_type_JavaUtilList;
  
  public ForwardTroopMemberControllerForMiniPie$TroopMemberRecyclerViewAdapter(Context paramContext, IFaceDecoder paramIFaceDecoder, float paramFloat)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public ForwardTroopMemberControllerForMiniPie.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == ForwardTroopMemberControllerForMiniPie.b)
    {
      paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
      int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297134);
      paramInt = i;
      if (this.jdField_a_of_type_Float != 0.0F) {
        paramInt = (int)(i / this.jdField_a_of_type_Float);
      }
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
      return new ForwardTroopMemberControllerForMiniPie.ViewHolder(paramViewGroup);
    }
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559249, paramViewGroup, false);
    if ((this.jdField_a_of_type_Float != 0.0F) && (paramViewGroup != null))
    {
      Object localObject1 = paramViewGroup.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = AIOUtils.a(80.0F / this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (ImageView)paramViewGroup.findViewById(2131368996);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((ImageView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          paramInt = AIOUtils.a(40.0F / this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((ViewGroup.LayoutParams)localObject2).width = paramInt;
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = (TextView)paramViewGroup.findViewById(2131380813);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setTextSize(2, (int)(10.0D / this.jdField_a_of_type_Float));
        localObject2 = (ViewGroup.MarginLayoutParams)((TextView)localObject1).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject2).setMargins((int)(((ViewGroup.MarginLayoutParams)localObject2).leftMargin / this.jdField_a_of_type_Float), (int)(((ViewGroup.MarginLayoutParams)localObject2).topMargin / this.jdField_a_of_type_Float), (int)(((ViewGroup.MarginLayoutParams)localObject2).rightMargin / this.jdField_a_of_type_Float), (int)(((ViewGroup.MarginLayoutParams)localObject2).bottomMargin / this.jdField_a_of_type_Float));
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    return new ForwardTroopMemberControllerForMiniPie.TroopMemberViewHolder(paramViewGroup);
  }
  
  public void a(ForwardTroopMemberControllerForMiniPie.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder.a == ForwardTroopMemberControllerForMiniPie.b) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if (paramViewHolder.a == ForwardTroopMemberControllerForMiniPie.a)
      {
        int i = paramInt - 1;
        if (i < 0) {
          QLog.e("ForwardTroopMemberControllerForMiniPie", 2, "type normal in wrong index");
        }
        Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((paramViewHolder instanceof ForwardTroopMemberControllerForMiniPie.TroopMemberViewHolder)) {
          ((ForwardTroopMemberControllerForMiniPie.TroopMemberViewHolder)paramViewHolder).a((String)localPair.first, (String)localPair.second, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
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
      return ForwardTroopMemberControllerForMiniPie.b;
    }
    return ForwardTroopMemberControllerForMiniPie.a;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      ((GridLayoutManager)paramRecyclerView).setSpanSizeLookup(new ForwardTroopMemberControllerForMiniPie.TroopMemberRecyclerViewAdapter.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie.TroopMemberRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */