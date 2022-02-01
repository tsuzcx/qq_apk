package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class LabelEditCtrl
  extends LabelBaseCtrl
  implements View.OnClickListener
{
  public int a;
  
  public LabelEditCtrl()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  protected int a()
  {
    return 2131561341;
  }
  
  protected LabelContainer a(View paramView, int paramInt1, InterestTag paramInterestTag, int paramInt2)
  {
    ((TextView)paramView.findViewById(2131380842)).setText(c[paramInt1]);
    paramInt1 = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 6.0F);
    int i = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 6.0F);
    LabelContainer localLabelContainer = (LabelContainer)paramView.findViewById(2131370030);
    localLabelContainer.setSpace(paramInt1, i);
    paramView.setTag(paramInterestTag);
    paramView.setOnClickListener(this);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == paramInt2 - 1)
    {
      paramInt1 = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramView.setBackgroundResource(2130839582);
      paramView.setPadding(0, paramInt1, 0, paramInt1);
    }
    return localLabelContainer;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof InterestTag))
    {
      InterestTag localInterestTag = (InterestTag)paramView.getTag();
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChooseInterestTagActivity.class);
      localIntent.putExtra("interest_tag_type", localInterestTag.jdField_a_of_type_Int);
      localIntent.putExtra("is_from_judge", false);
      localIntent.putExtra("is_from_nearby", true);
      localIntent.putExtra("from_where", "NearbyPeopleProfileActivity");
      localIntent.putParcelableArrayListExtra("choosed_interest_tags", localInterestTag.jdField_a_of_type_JavaUtilArrayList);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 11);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.LabelEditCtrl
 * JD-Core Version:    0.7.0.1
 */