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
  QQAppInterface a;
  Context b;
  List<Pair<String, String>> c;
  IFaceDecoder d;
  
  public ForwardPreviewTroopMemberController$TroopMemberRecyclerViewAdapter(QQAppInterface paramQQAppInterface, Context paramContext, IFaceDecoder paramIFaceDecoder)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.d = paramIFaceDecoder;
    this.c = new ArrayList();
  }
  
  public ForwardPreviewTroopMemberController.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == ForwardPreviewTroopMemberController.f)
    {
      paramViewGroup = new View(this.b);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.b.getResources().getDimensionPixelSize(2131297497)));
      return new ForwardPreviewTroopMemberController.ViewHolder(paramViewGroup);
    }
    return new ForwardPreviewTroopMemberController.TroopMemberViewHolder(LayoutInflater.from(this.b).inflate(2131624869, paramViewGroup, false));
  }
  
  public void a(ForwardPreviewTroopMemberController.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder.c != ForwardPreviewTroopMemberController.f) && (paramViewHolder.c == ForwardPreviewTroopMemberController.e))
    {
      int i = paramInt - 1;
      if (i < 0) {
        QLog.e("Forward.Preview.Dialog", 2, "type normal in wrong index");
      }
      Pair localPair = (Pair)this.c.get(i);
      if ((paramViewHolder instanceof ForwardPreviewTroopMemberController.TroopMemberViewHolder)) {
        ((ForwardPreviewTroopMemberController.TroopMemberViewHolder)paramViewHolder).a((String)localPair.first, (String)localPair.second, this.d);
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
      this.c.clear();
      this.c.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    List localList = this.c;
    if ((localList != null) && (localList.size() != 0)) {
      return this.c.size() + 1;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return ForwardPreviewTroopMemberController.f;
    }
    return ForwardPreviewTroopMemberController.e;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.TroopMemberRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */