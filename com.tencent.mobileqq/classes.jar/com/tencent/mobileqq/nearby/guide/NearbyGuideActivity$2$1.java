package com.tencent.mobileqq.nearby.guide;

import android.text.TextUtils;
import anvx;
import axqc;
import axtp;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyGuideActivity$2$1
  implements Runnable
{
  public NearbyGuideActivity$2$1(axtp paramaxtp, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Axtp.a.l();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Axtp.a.a(2, anvx.a(2131706645));
      this.jdField_a_of_type_Axtp.a.a(true);
      this.jdField_a_of_type_Axtp.a.finish();
      axqc.a(this.jdField_a_of_type_Axtp.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = anvx.a(2131706659);
    }
    this.jdField_a_of_type_Axtp.a.a(1, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1
 * JD-Core Version:    0.7.0.1
 */