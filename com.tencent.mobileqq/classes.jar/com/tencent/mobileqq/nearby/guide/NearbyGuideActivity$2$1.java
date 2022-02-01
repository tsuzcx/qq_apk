package com.tencent.mobileqq.nearby.guide;

import android.text.TextUtils;
import anzj;
import axws;
import ayaf;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyGuideActivity$2$1
  implements Runnable
{
  public NearbyGuideActivity$2$1(ayaf paramayaf, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ayaf.a.l();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Ayaf.a.a(2, anzj.a(2131706063));
      this.jdField_a_of_type_Ayaf.a.a(true);
      this.jdField_a_of_type_Ayaf.a.finish();
      axws.a(this.jdField_a_of_type_Ayaf.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = anzj.a(2131706077);
    }
    this.jdField_a_of_type_Ayaf.a.a(1, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1
 * JD-Core Version:    0.7.0.1
 */