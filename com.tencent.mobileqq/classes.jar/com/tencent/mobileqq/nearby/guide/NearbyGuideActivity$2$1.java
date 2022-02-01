package com.tencent.mobileqq.nearby.guide;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;

class NearbyGuideActivity$2$1
  implements Runnable
{
  NearbyGuideActivity$2$1(NearbyGuideActivity.2 param2, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity$2.a.l();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity$2.a.a(2, HardCodeUtil.a(2131707184));
      this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity$2.a.a(true);
      this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity$2.a.finish();
      NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity$2.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = HardCodeUtil.a(2131707198);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity$2.a.a(1, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1
 * JD-Core Version:    0.7.0.1
 */