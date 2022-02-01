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
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  List<RecommendPerson> jdField_a_of_type_JavaUtilList;
  List<TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView> b;
  
  public TroopMemRecommendRclAdapter$ActiveViewHolder(TroopMemRecommendRclAdapter paramTroopMemRecommendRclAdapter, View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_JavaUtilList = ((List)paramTroopMemRecommendRclAdapter.a.get(Integer.valueOf(paramInt)));
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if (localObject1 == null) {
      return;
    }
    this.b = new ArrayList(((List)localObject1).size());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379949));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376766));
    paramView = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramView.hasNext())
    {
      localObject1 = (RecommendPerson)paramView.next();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ActiveViewHolder, person.uin =");
        ((StringBuilder)localObject2).append(((RecommendPerson)localObject1).uin);
        ((StringBuilder)localObject2).append(" size() = ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilList.size());
        QLog.d("TroopMemberRecommend.Adapter", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131562983, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      Object localObject2 = (RelativeLayout)((View)localObject1).findViewById(2131376767);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131369535);
      TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131379950);
      TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131379951);
      Button localButton = (Button)((View)localObject1).findViewById(2131364098);
      a(AIOUtils.b(85.0F, TroopMemRecommendRclAdapter.a(paramTroopMemRecommendRclAdapter).getResources()), this.jdField_a_of_type_JavaUtilList.size(), (RelativeLayout)localObject2);
      TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView localActiveSubItemView = new TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView(this);
      localActiveSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
      localActiveSubItemView.jdField_a_of_type_AndroidWidgetImageView = localImageView;
      localActiveSubItemView.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
      localActiveSubItemView.b = localTextView2;
      localActiveSubItemView.jdField_a_of_type_AndroidWidgetButton = localButton;
      this.b.add(localActiveSubItemView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
  }
  
  private void a(int paramInt1, int paramInt2, RelativeLayout paramRelativeLayout)
  {
    if (paramInt2 > 1)
    {
      int i = ViewUtils.a();
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
    if (i != 2131364098)
    {
      if ((i == 2131376767) && (TroopMemRecommendRclAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter) != null)) {
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
 * Qualified Name:     com.tencent.mobileqq.multicard.TroopMemRecommendRclAdapter.ActiveViewHolder
 * JD-Core Version:    0.7.0.1
 */