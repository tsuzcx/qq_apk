package com.tencent.mobileqq.nearby.guide;

import ajya;
import android.text.TextUtils;
import atbi;
import atev;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyGuideActivity$2$1
  implements Runnable
{
  public NearbyGuideActivity$2$1(atev paramatev, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Atev.a.l();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Atev.a.a(2, ajya.a(2131707181));
      this.jdField_a_of_type_Atev.a.a(true);
      this.jdField_a_of_type_Atev.a.finish();
      atbi.a(this.jdField_a_of_type_Atev.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ajya.a(2131707195);
    }
    this.jdField_a_of_type_Atev.a.a(1, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1
 * JD-Core Version:    0.7.0.1
 */