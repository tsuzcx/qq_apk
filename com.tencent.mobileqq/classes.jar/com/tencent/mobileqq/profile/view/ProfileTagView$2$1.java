package com.tencent.mobileqq.profile.view;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import atuw;
import atwx;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.widget.RatioLayout;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

class ProfileTagView$2$1
  implements Runnable
{
  ProfileTagView$2$1(ProfileTagView.2 param2, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int k = ProfileTagView.a().length - 1;
      int i;
      if (this.jdField_a_of_type_JavaUtilList.size() >= k)
      {
        i = k;
        if ((!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.b) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_ArrayOfAndroidViewView[k] == null) || (i != 0)) {
          break label341;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_ArrayOfAndroidViewView[k] == null))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_ArrayOfAndroidViewView;
          localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.getContext(), 2131496069, null);
          localObject2[k] = localObject1;
          localObject2 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, 0.5F, 0.5F);
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          ((View)localObject1).setVisibility(4);
          ((View)localObject1).setTag(new atuw(32, null));
          ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((View)localObject1).setId(2131307959);
          ((View)localObject1).setTag(2131307959, Integer.valueOf(-1));
          ((View)localObject1).setTag(2131307961, Integer.valueOf(ProfileTagView.a().length - 1));
        }
        j = 0;
        while (j < k)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_ArrayOfAndroidViewView[j];
          if (((localObject1 instanceof VipTagView)) && (((View)localObject1).getVisibility() != 8))
          {
            ((VipTagView)localObject1).setShakingState(false);
            ((View)localObject1).setVisibility(8);
          }
          j += 1;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
        break;
        label341:
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      int j = 0;
      if (j < i)
      {
        localObject2 = (ProfileLabelInfo)this.jdField_a_of_type_JavaUtilList.get(j);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_ArrayOfAndroidViewView[j] == null)
        {
          localObject1 = new VipTagView(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.getContext());
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_ArrayOfAndroidViewView[j] = localObject1;
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.addView((View)localObject1);
          ((VipTagView)localObject1).setGravity(17);
          ((VipTagView)localObject1).setTag(2131307959, Integer.valueOf(j));
          ((VipTagView)localObject1).setTag(2131307961, Integer.valueOf(ProfileTagView.a()[j]));
          ((VipTagView)localObject1).setTextColor(-1);
        }
        VipTagView localVipTagView = (VipTagView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_ArrayOfAndroidViewView[j];
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.b))
        {
          localObject1 = ProfileTagView.a()[ProfileTagView.a()[j]];
          localObject1 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, ((PointF)localObject1).x, ((PointF)localObject1).y);
          localVipTagView.setVisibility(0);
          localVipTagView.setShakingState(true);
          label575:
          localVipTagView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localVipTagView.setLabelAndPraise(((ProfileLabelInfo)localObject2).labelName, ((ProfileLabelInfo)localObject2).likeNum.intValue());
          localVipTagView.setTag(2131307960, ((ProfileLabelInfo)localObject2).labelId);
          if ((!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.a(localVipTagView)) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)) {
            break label715;
          }
          localVipTagView.setTagColor(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.getResources().getColor(2131100846), this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.getResources().getColor(2131100844));
        }
        for (;;)
        {
          j += 1;
          break;
          localObject1 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, 0.5F, 0.5F);
          localVipTagView.setVisibility(4);
          break label575;
          label715:
          localVipTagView.setTagColor(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.getResources().getColor(2131100845), this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.getResources().getColor(2131100843));
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.this$0.a((int)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView$2.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileTagView.2.1
 * JD-Core Version:    0.7.0.1
 */