package com.tencent.mobileqq.nearby.guide;

import amtj;
import android.text.TextUtils;
import awka;
import awnn;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyGuideActivity$2$1
  implements Runnable
{
  public NearbyGuideActivity$2$1(awnn paramawnn, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Awnn.a.l();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Awnn.a.a(2, amtj.a(2131706293));
      this.jdField_a_of_type_Awnn.a.a(true);
      this.jdField_a_of_type_Awnn.a.finish();
      awka.a(this.jdField_a_of_type_Awnn.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = amtj.a(2131706307);
    }
    this.jdField_a_of_type_Awnn.a.a(1, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1
 * JD-Core Version:    0.7.0.1
 */