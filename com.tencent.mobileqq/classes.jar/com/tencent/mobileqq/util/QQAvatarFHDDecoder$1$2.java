package com.tencent.mobileqq.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

class QQAvatarFHDDecoder$1$2
  implements Runnable
{
  QQAvatarFHDDecoder$1$2(QQAvatarFHDDecoder.1 param1, String paramString) {}
  
  public void run()
  {
    if (QQAvatarFHDDecoder.a(this.jdField_a_of_type_ComTencentMobileqqUtilQQAvatarFHDDecoder$1.a)) {
      return;
    }
    Setting localSetting = QQAvatarFHDDecoder.a(this.jdField_a_of_type_ComTencentMobileqqUtilQQAvatarFHDDecoder$1.a).getQQHeadSettingFromDB(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqUtilQQAvatarFHDDecoder$1.a.a(localSetting);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQAvatarFHDDecoder.1.2
 * JD-Core Version:    0.7.0.1
 */