package com.tencent.mobileqq.profile.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VipPhotoViewForSimple$2
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  VipPhotoViewForSimple$2(VipPhotoViewForSimple paramVipPhotoViewForSimple) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) >= 1000L)
    {
      this.jdField_a_of_type_Long = l;
      if ((paramView != null) && ((paramView.getTag() instanceof DataTag)))
      {
        Object localObject = (DataTag)paramView.getTag();
        if (localObject != null)
        {
          int i = ((DataTag)localObject).a;
          localObject = VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple).allInOne.uin;
          if (i == 25)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "View.OnClickListener click type is photo wall view");
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.a, "CliOper", "", "", "card_mall", "0X80066C4", 0, 0, "1", "", "", "");
            localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple;
            VipPhotoViewForSimple.a((VipPhotoViewForSimple)localObject, VipPhotoViewForSimple.a((VipPhotoViewForSimple)localObject));
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipPhotoViewForSimple.2
 * JD-Core Version:    0.7.0.1
 */