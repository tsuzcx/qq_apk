package com.tencent.mobileqq.nearby.guide;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;

class NearbyGuideActivity$2$1
  implements Runnable
{
  NearbyGuideActivity$2$1(NearbyGuideActivity.2 param2, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity$2.a.dismissProcessDialog();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity$2.a.showToast(2, HardCodeUtil.a(2131707209));
      this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity$2.a.gotoNearbyBaseActivity(true);
      this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity$2.a.finish();
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity$2.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = HardCodeUtil.a(2131707223);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity$2.a.showToast(1, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1
 * JD-Core Version:    0.7.0.1
 */