package com.tencent.mobileqq.nearby.guide;

import alpo;
import android.text.TextUtils;
import aush;
import auvu;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyGuideActivity$2$1
  implements Runnable
{
  public NearbyGuideActivity$2$1(auvu paramauvu, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Auvu.a.l();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Auvu.a.a(2, alpo.a(2131707553));
      this.jdField_a_of_type_Auvu.a.a(true);
      this.jdField_a_of_type_Auvu.a.finish();
      aush.a(this.jdField_a_of_type_Auvu.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = alpo.a(2131707567);
    }
    this.jdField_a_of_type_Auvu.a.a(1, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1
 * JD-Core Version:    0.7.0.1
 */