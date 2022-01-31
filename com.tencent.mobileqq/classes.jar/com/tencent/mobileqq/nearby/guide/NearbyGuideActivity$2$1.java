package com.tencent.mobileqq.nearby.guide;

import ajyc;
import android.text.TextUtils;
import atbg;
import atet;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyGuideActivity$2$1
  implements Runnable
{
  public NearbyGuideActivity$2$1(atet paramatet, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Atet.a.l();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Atet.a.a(2, ajyc.a(2131707170));
      this.jdField_a_of_type_Atet.a.a(true);
      this.jdField_a_of_type_Atet.a.finish();
      atbg.a(this.jdField_a_of_type_Atet.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ajyc.a(2131707184);
    }
    this.jdField_a_of_type_Atet.a.a(1, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1
 * JD-Core Version:    0.7.0.1
 */