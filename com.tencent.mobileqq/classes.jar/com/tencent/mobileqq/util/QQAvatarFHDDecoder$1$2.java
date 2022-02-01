package com.tencent.mobileqq.util;

import bfro;
import bfrp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

public class QQAvatarFHDDecoder$1$2
  implements Runnable
{
  public QQAvatarFHDDecoder$1$2(bfrp parambfrp, String paramString) {}
  
  public void run()
  {
    if (bfro.a(this.jdField_a_of_type_Bfrp.a)) {
      return;
    }
    Setting localSetting = bfro.a(this.jdField_a_of_type_Bfrp.a).getQQHeadSettingFromDB(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bfrp.a.a(localSetting);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQAvatarFHDDecoder.1.2
 * JD-Core Version:    0.7.0.1
 */