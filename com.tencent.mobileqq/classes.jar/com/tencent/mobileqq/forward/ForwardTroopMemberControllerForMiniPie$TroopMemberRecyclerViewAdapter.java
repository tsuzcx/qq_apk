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
  Context a;
  List<Pair<String, String>> b;
  IFaceDecoder c;
  float d = 1.0F;
  
  public ForwardTroopMemberControllerForMiniPie$TroopMemberRecyclerViewAdapter(Context paramContext, IFaceDecoder paramIFaceDecoder, float paramFloat)
  {
    this.a = paramContext;
    this.c = paramIFaceDecoder;
    this.b = new ArrayList();
    this.d = paramFloat;
  }
  
  public ForwardTroopMemberControllerForMiniPie.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == ForwardTroopMemberControllerForMiniPie.b)
    {
      paramViewGroup = new View(this.a);
      int i = this.a.getResources().getDimensionPixelSize(2131297497);
      float f = this.d;
      paramInt = i;
      if (f != 0.0F) {
        paramInt = (int)(i / f);
      }
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
      return new ForwardTroopMemberControllerForMiniPie.ViewHolder(paramViewGroup);
    }
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131624869, paramViewGroup, false);
    if ((this.d != 0.0F) && (paramViewGroup != null))
    {
      Object localObject1 = paramViewGroup.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = AIOUtils.b(80.0F / this.d, this.a.getResources());
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (ImageView)paramViewGroup.findViewById(2131435631);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((ImageView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          paramInt = AIOUtils.b(40.0F / this.d, this.a.getResources());
          ((ViewGroup.LayoutParams)localObject2).width = paramInt;
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = (TextView)paramViewGroup.findViewById(2131448989);
      if (localObject1 != null)
      {
        double d1 = this.d;
        Double.isNaN(d1);
        ((TextView)localObject1).setTextSize(2, (int)(10.0D / d1));
        localObject2 = (ViewGroup.MarginLayoutParams)((TextView)localObject1).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject2).setMargins((int)(((ViewGroup.MarginLayoutParams)localObject2).leftMargin / this.d), (int)(((ViewGroup.MarginLayoutParams)localObject2).topMargin / this.d), (int)(((ViewGroup.MarginLayoutParams)localObject2).rightMargin / this.d), (int)(((ViewGroup.MarginLayoutParams)localObject2).bottomMargin / this.d));
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    return new ForwardTroopMemberControllerForMiniPie.TroopMemberViewHolder(paramViewGroup);
  }
  
  public void a(ForwardTroopMemberControllerForMiniPie.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder.c != ForwardTroopMemberControllerForMiniPie.b) && (paramViewHolder.c == ForwardTroopMemberControllerForMiniPie.a))
    {
      int i = paramInt - 1;
      if (i < 0) {
        QLog.e("ForwardTroopMemberControllerForMiniPie", 2, "type normal in wrong index");
      }
      Pair localPair = (Pair)this.b.get(i);
      if ((paramViewHolder instanceof ForwardTroopMemberControllerForMiniPie.TroopMemberViewHolder)) {
        ((ForwardTroopMemberControllerForMiniPie.TroopMemberViewHolder)paramViewHolder).a((String)localPair.first, (String)localPair.second, this.c);
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<Pair<String, String>> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.b.clear();
      this.b.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    if ((localList != null) && (localList.size() != 0)) {
      return this.b.size() + 1;
    }
    return 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie.TroopMemberRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */