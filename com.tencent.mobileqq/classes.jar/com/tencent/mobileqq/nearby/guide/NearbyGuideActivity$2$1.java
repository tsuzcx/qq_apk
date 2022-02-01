package com.tencent.mobileqq.nearby.guide;

import android.text.TextUtils;
import anni;
import axdz;
import axhm;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyGuideActivity$2$1
  implements Runnable
{
  public NearbyGuideActivity$2$1(axhm paramaxhm, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Axhm.a.l();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Axhm.a.a(2, anni.a(2131705956));
      this.jdField_a_of_type_Axhm.a.a(true);
      this.jdField_a_of_type_Axhm.a.finish();
      axdz.a(this.jdField_a_of_type_Axhm.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = anni.a(2131705970);
    }
    this.jdField_a_of_type_Axhm.a.a(1, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1
 * JD-Core Version:    0.7.0.1
 */