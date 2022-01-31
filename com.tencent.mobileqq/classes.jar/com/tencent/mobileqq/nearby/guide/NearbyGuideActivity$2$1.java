package com.tencent.mobileqq.nearby.guide;

import alud;
import android.text.TextUtils;
import auwq;
import avad;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyGuideActivity$2$1
  implements Runnable
{
  public NearbyGuideActivity$2$1(avad paramavad, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Avad.a.l();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Avad.a.a(2, alud.a(2131707565));
      this.jdField_a_of_type_Avad.a.a(true);
      this.jdField_a_of_type_Avad.a.finish();
      auwq.a(this.jdField_a_of_type_Avad.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = alud.a(2131707579);
    }
    this.jdField_a_of_type_Avad.a.a(1, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1
 * JD-Core Version:    0.7.0.1
 */