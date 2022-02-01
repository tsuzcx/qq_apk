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
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      this.b = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380675));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377312));
      paramView = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramView.hasNext())
      {
        Object localObject = (RecommendPerson)paramView.next();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.Adapter", 2, "ActiveViewHolder, person.uin =" + ((RecommendPerson)localObject).uin + " size() = " + this.jdField_a_of_type_JavaUtilList.size());
        }
        localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()).inflate(2131563160, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)((View)localObject).findViewById(2131377313);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131369849);
        TextView localTextView1 = (TextView)((View)localObject).findViewById(2131380676);
        TextView localTextView2 = (TextView)((View)localObject).findViewById(2131380677);
        Button localButton = (Button)((View)localObject).findViewById(2131364179);
        a(AIOUtils.a(85.0F, TroopMemRecommendRclAdapter.a(paramTroopMemRecommendRclAdapter).getResources()), this.jdField_a_of_type_JavaUtilList.size(), localRelativeLayout);
        TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView localActiveSubItemView = new TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView(this);
        localActiveSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
        localActiveSubItemView.jdField_a_of_type_AndroidWidgetImageView = localImageView;
        localActiveSubItemView.jdField_a_of_type_AndroidWidgetTextView = localTextView1;
        localActiveSubItemView.b = localTextView2;
        localActiveSubItemView.jdField_a_of_type_AndroidWidgetButton = localButton;
        this.b.add(localActiveSubItemView);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      }
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
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberRecommend.Adapter", 2, "onCreateViewHolder, rlWidth =" + paramInt1 + " screenWidth =" + i + " margin = " + paramInt2);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (TroopMemRecommendRclAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter) != null)
      {
        TroopMemRecommendRclAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter).a((RecyclerView.ViewHolder)paramView.getTag(2131377313), (RecommendPerson)paramView.getTag(2131364179));
        continue;
        if (TroopMemRecommendRclAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter) != null) {
          TroopMemRecommendRclAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMulticardTroopMemRecommendRclAdapter).b((RecyclerView.ViewHolder)paramView.getTag(2131377313), (RecommendPerson)paramView.getTag(2131364179));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.TroopMemRecommendRclAdapter.ActiveViewHolder
 * JD-Core Version:    0.7.0.1
 */