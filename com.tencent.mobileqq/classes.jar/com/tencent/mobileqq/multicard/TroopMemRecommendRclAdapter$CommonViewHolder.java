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
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  List<RecommendPerson> jdField_a_of_type_JavaUtilList;
  List<TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView> b;
  
  public TroopMemRecommendRclAdapter$CommonViewHolder(TroopMemRecommendRclAdapter paramTroopMemRecommendRclAdapter, View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilList = ((List)paramTroopMemRecommendRclAdapter.a.get(Integer.valueOf(paramInt)));
    paramTroopMemRecommendRclAdapter = this.jdField_a_of_type_JavaUtilList;
    if (paramTroopMemRecommendRclAdapter == null) {
      return;
    }
    this.b = new ArrayList(paramTroopMemRecommendRclAdapter.size());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379952));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376768));
    paramTroopMemRecommendRclAdapter = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramTroopMemRecommendRclAdapter.hasNext())
    {
      paramView = (RecommendPerson)paramTroopMemRecommendRclAdapter.next();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CommonViewHolder, person.uin =");
        ((StringBuilder)localObject).append(paramView.uin);
        ((StringBuilder)localObject).append(" size() = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
        QLog.d("TroopMemberRecommend.Adapter", 2, ((StringBuilder)localObject).toString());
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131562986, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      Object localObject = (RelativeLayout)paramView.findViewById(2131376769);
      ImageView localImageView = (ImageView)paramView.findViewById(2131369536);
      TextView localTextView1 = (TextView)paramView.findViewById(2131379953);
      TextView localTextView2 = (TextView)paramView.findViewById(2131379954);
      Button localButton = (Button)paramView.findViewById(2131364099);
      TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView localCommonSubItemView = new TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView(this);
      localCommonSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
      localCommonSubItemView.jdField_a_of_type_AndroidWidgetImageView = localImageView;
      localCommonSubItemView.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
      localCommonSubItemView.b = localTextView2;
      localCommonSubItemView.jdField_a_of_type_AndroidWidgetButton = localButton;
      this.b.add(localCommonSubItemView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364099)
    {
      if ((i == 2131376769) && (TroopMemRecommendRclAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter) != null)) {
        TroopMemRecommendRclAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter).a((RecyclerView.ViewHolder)paramView.getTag(2131376767), (RecommendPerson)paramView.getTag(2131364098));
      }
    }
    else if (TroopMemRecommendRclAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter) != null) {
      TroopMemRecommendRclAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter).b((RecyclerView.ViewHolder)paramView.getTag(2131376767), (RecommendPerson)paramView.getTag(2131364098));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.TroopMemRecommendRclAdapter.CommonViewHolder
 * JD-Core Version:    0.7.0.1
 */