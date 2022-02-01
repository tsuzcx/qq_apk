package com.tencent.mobileqq.multicard;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopMemRecommendRclAdapter$CommonViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  List<RecommendPerson> a;
  List<TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView> b;
  TextView c;
  LinearLayout d;
  
  public TroopMemRecommendRclAdapter$CommonViewHolder(TroopMemRecommendRclAdapter paramTroopMemRecommendRclAdapter, View paramView, int paramInt)
  {
    super(paramView);
    this.a = ((List)paramTroopMemRecommendRclAdapter.a.get(Integer.valueOf(paramInt)));
    paramTroopMemRecommendRclAdapter = this.a;
    if (paramTroopMemRecommendRclAdapter == null) {
      return;
    }
    this.b = new ArrayList(paramTroopMemRecommendRclAdapter.size());
    this.c = ((TextView)paramView.findViewById(2131448840));
    this.d = ((LinearLayout)paramView.findViewById(2131445061));
    paramTroopMemRecommendRclAdapter = this.a.iterator();
    while (paramTroopMemRecommendRclAdapter.hasNext())
    {
      paramView = (RecommendPerson)paramTroopMemRecommendRclAdapter.next();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CommonViewHolder, person.uin =");
        ((StringBuilder)localObject).append(paramView.uin);
        ((StringBuilder)localObject).append(" size() = ");
        ((StringBuilder)localObject).append(this.a.size());
        QLog.d("TroopMemberRecommend.Adapter", 2, ((StringBuilder)localObject).toString());
      }
      paramView = LayoutInflater.from(this.d.getContext()).inflate(2131629594, this.d, false);
      Object localObject = (RelativeLayout)paramView.findViewById(2131445062);
      ImageView localImageView = (ImageView)paramView.findViewById(2131436636);
      TextView localTextView1 = (TextView)paramView.findViewById(2131448841);
      TextView localTextView2 = (TextView)paramView.findViewById(2131448842);
      Button localButton = (Button)paramView.findViewById(2131430065);
      TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView localCommonSubItemView = new TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView(this);
      localCommonSubItemView.a = ((RelativeLayout)localObject);
      localCommonSubItemView.b = localImageView;
      localCommonSubItemView.c = localTextView1;
      localCommonSubItemView.d = localTextView2;
      localCommonSubItemView.e = localButton;
      this.b.add(localCommonSubItemView);
      this.d.addView(paramView);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131430065)
    {
      if ((i == 2131445062) && (TroopMemRecommendRclAdapter.a(this.e) != null)) {
        TroopMemRecommendRclAdapter.a(this.e).a((RecyclerView.ViewHolder)paramView.getTag(2131445060), (RecommendPerson)paramView.getTag(2131430064));
      }
    }
    else if (TroopMemRecommendRclAdapter.a(this.e) != null) {
      TroopMemRecommendRclAdapter.a(this.e).b((RecyclerView.ViewHolder)paramView.getTag(2131445060), (RecommendPerson)paramView.getTag(2131430064));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.TroopMemRecommendRclAdapter.CommonViewHolder
 * JD-Core Version:    0.7.0.1
 */