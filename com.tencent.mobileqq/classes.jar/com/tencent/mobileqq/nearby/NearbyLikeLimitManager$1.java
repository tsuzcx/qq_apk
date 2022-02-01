package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;

class NearbyLikeLimitManager$1
  implements DialogInterface.OnClickListener
{
  NearbyLikeLimitManager$1(NearbyLikeLimitManager paramNearbyLikeLimitManager, boolean paramBoolean, String paramString1, INearbyLikeLimitManager.onDoVoteListener paramonDoVoteListener, QQAppInterface paramQQAppInterface, String paramString2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.b();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), 0, 1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyINearbyLikeLimitManager$onDoVoteListener.a(this.jdField_a_of_type_JavaLangString, false);
      ((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "pay_like", this.jdField_a_of_type_JavaLangString, this.b, "", "", "");
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.a(this.jdField_a_of_type_AndroidAppActivity, this.b);
      ((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "exp_pay", this.b);
    }
    ((INearbyLikeLimitManagerUtil)QRoute.api(INearbyLikeLimitManagerUtil.class)).report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_no_warm", this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyLikeLimitManager.1
 * JD-Core Version:    0.7.0.1
 */