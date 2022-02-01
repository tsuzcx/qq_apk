package com.tencent.mobileqq.profilecard.vas.view;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import azvr;
import azxr;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.widget.RatioLayout;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

class VasProfileTagView$2$1
  implements Runnable
{
  VasProfileTagView$2$1(VasProfileTagView.2 param2, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int k = VasProfileTagView.a().length - 1;
      int i;
      if (this.jdField_a_of_type_JavaUtilList.size() >= k)
      {
        i = k;
        if ((!this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0.b) || (VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0)) || (VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0)[k] == null) || (i != 0)) {
          break label338;
        }
        VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0).setVisibility(0);
      }
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) && (VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0)[k] == null))
        {
          localObject2 = VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0);
          localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0.getContext(), 2131562138, null);
          localObject2[k] = localObject1;
          localObject2 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, 0.5F, 0.5F);
          VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          ((View)localObject1).setVisibility(4);
          ((View)localObject1).setTag(new azvr(32, null));
          ((View)localObject1).setOnClickListener(VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0));
          ((View)localObject1).setId(2131375037);
          ((View)localObject1).setTag(2131375037, Integer.valueOf(-1));
          ((View)localObject1).setTag(2131375039, Integer.valueOf(VasProfileTagView.a().length - 1));
        }
        j = 0;
        while (j < k)
        {
          localObject1 = VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0)[j];
          if (((localObject1 instanceof VipTagView)) && (((View)localObject1).getVisibility() != 8))
          {
            ((VipTagView)localObject1).setShakingState(false);
            ((View)localObject1).setVisibility(8);
          }
          j += 1;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
        break;
        label338:
        VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0).setVisibility(4);
      }
      int j = 0;
      if (j < i)
      {
        localObject2 = (ProfileLabelInfo)this.jdField_a_of_type_JavaUtilList.get(j);
        if (VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0)[j] == null)
        {
          localObject1 = new VipTagView(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0.getContext());
          VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0)[j] = localObject1;
          VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0).addView((View)localObject1);
          ((VipTagView)localObject1).setGravity(17);
          ((VipTagView)localObject1).setTag(2131375037, Integer.valueOf(j));
          ((VipTagView)localObject1).setTag(2131375039, Integer.valueOf(VasProfileTagView.a()[j]));
          ((VipTagView)localObject1).setTextColor(-1);
        }
        VipTagView localVipTagView = (VipTagView)VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0)[j];
        if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0.b) && (!VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0)))
        {
          localObject1 = VasProfileTagView.a()[VasProfileTagView.a()[j]];
          localObject1 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, ((PointF)localObject1).x, ((PointF)localObject1).y);
          localVipTagView.setVisibility(0);
          localVipTagView.setShakingState(true);
          label572:
          localVipTagView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localVipTagView.setLabelAndPraise(((ProfileLabelInfo)localObject2).labelName, ((ProfileLabelInfo)localObject2).likeNum.intValue());
          localVipTagView.setTag(2131375038, ((ProfileLabelInfo)localObject2).labelId);
          if ((!this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0.a(localVipTagView)) || (this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)) {
            break label712;
          }
          localVipTagView.setTagColor(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0.getResources().getColor(2131166566), this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0.getResources().getColor(2131166564));
        }
        for (;;)
        {
          j += 1;
          break;
          localObject1 = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, 0.5F, 0.5F);
          localVipTagView.setVisibility(4);
          break label572;
          label712:
          localVipTagView.setTagColor(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0.getResources().getColor(2131166565), this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0.getResources().getColor(2131166563));
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.this$0.b((int)this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView$2.a.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.2.1
 * JD-Core Version:    0.7.0.1
 */