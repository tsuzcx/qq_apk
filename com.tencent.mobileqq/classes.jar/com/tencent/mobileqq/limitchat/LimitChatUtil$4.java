package com.tencent.mobileqq.limitchat;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.bean.ExpandFriendData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class LimitChatUtil$4
  implements Runnable
{
  LimitChatUtil$4(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt, Object paramObject) {}
  
  public void run()
  {
    LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangObject);
    if (this.jdField_a_of_type_Int == 1045)
    {
      ExpandFriendData.updateAttribute(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, 0, Integer.valueOf(6));
      return;
    }
    try
    {
      int i = new JSONObject((String)this.jdField_a_of_type_JavaLangObject).getJSONObject("infos").getJSONObject("match_src").getInt("id");
      ExpandFriendData.updateAttribute(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, 0, Integer.valueOf(i));
      LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, i);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("LimitChatUtil", 1, "handlePreLoadDataForArkMiniProfileCard get matchSource error" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatUtil.4
 * JD-Core Version:    0.7.0.1
 */