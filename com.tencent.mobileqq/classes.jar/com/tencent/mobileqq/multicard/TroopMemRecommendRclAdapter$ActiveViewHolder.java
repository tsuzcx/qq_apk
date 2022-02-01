package com.tencent.mobileqq.multicard;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopMemRecommendRclAdapter$ActiveViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  List<RecommendPerson> a;
  List<TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView> b;
  TextView c;
  LinearLayout d;
  
  public TroopMemRecommendRclAdapter$ActiveViewHolder(TroopMemRecommendRclAdapter paramTroopMemRecommendRclAdapter, View paramView, int paramInt)
  {
    super(paramView);
    this.a = ((List)paramTroopMemRecommendRclAdapter.a.get(Integer.valueOf(paramInt)));
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    this.b = new ArrayList(((List)localObject1).size());
    this.c = ((TextView)paramView.findViewById(2131448837));
    this.d = ((LinearLayout)paramView.findViewById(2131445059));
    paramView = this.a.iterator();
    while (paramView.hasNext())
    {
      localObject1 = (RecommendPerson)paramView.next();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ActiveViewHolder, person.uin =");
        ((StringBuilder)localObject2).append(((RecommendPerson)localObject1).uin);
        ((StringBuilder)localObject2).append(" size() = ");
        ((StringBuilder)localObject2).append(this.a.size());
        QLog.d("TroopMemberRecommend.Adapter", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = LayoutInflater.from(this.d.getContext()).inflate(2131629591, this.d, false);
      Object localObject2 = (RelativeLayout)((View)localObject1).findViewById(2131445060);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131436635);
      TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131448838);
      TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131448839);
      Button localButton = (Button)((View)localObject1).findViewById(2131430064);
      a(AIOUtils.b(85.0F, TroopMemRecommendRclAdapter.a(paramTroopMemRecommendRclAdapter).getResources()), this.a.size(), (RelativeLayout)localObject2);
      TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView localActiveSubItemView = new TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView(this);
      localActiveSubItemView.a = ((RelativeLayout)localObject2);
      localActiveSubItemView.b = localImageView;
      localActiveSubItemView.c = localTextView1;
      localActiveSubItemView.d = localTextView2;
      localActiveSubItemView.e = localButton;
      this.b.add(localActiveSubItemView);
      this.d.addView((View)localObject1);
    }
  }
  
  private void a(int paramInt1, int paramInt2, RelativeLayout paramRelativeLayout)
  {
    if (paramInt2 > 1)
    {
      int i = ViewUtils.getScreenWidth();
      paramInt2 = (i - paramInt2 * paramInt1) / (paramInt2 * paramInt2);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
      localLayoutParams.leftMargin = paramInt2;
      localLayoutParams.rightMargin = paramInt2;
      paramRelativeLayout.setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel())
      {
        paramRelativeLayout = new StringBuilder();
        paramRelativeLayout.append("onCreateViewHolder, rlWidth =");
        paramRelativeLayout.append(paramInt1);
        paramRelativeLayout.append(" screenWidth =");
        paramRelativeLayout.append(i);
        paramRelativeLayout.append(" margin = ");
        paramRelativeLayout.append(paramInt2);
        QLog.d("TroopMemberRecommend.Adapter", 2, paramRelativeLayout.toString());
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131430064)
    {
      if ((i == 2131445060) && (TroopMemRecommendRclAdapter.a(this.e) != null)) {
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
 * Qualified Name:     com.tencent.mobileqq.multicard.TroopMemRecommendRclAdapter.ActiveViewHolder
 * JD-Core Version:    0.7.0.1
 */