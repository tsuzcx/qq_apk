package com.tencent.mobileqq.newfriend;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PushRecommend;

public class MayKnowMessage
  extends NewFriendMessage
{
  public PushRecommend a;
  
  public MayKnowMessage(PushRecommend paramPushRecommend)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend = paramPushRecommend;
    this.jdField_a_of_type_Long = paramPushRecommend.timestamp;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.remark)) {
        break label83;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.nick)) {
        break label72;
      }
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.uin;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = String.format(BaseApplicationImpl.sApplication.getString(2131435516), new Object[] { paramQQAppInterface });
      return this.jdField_a_of_type_JavaLangString;
      label72:
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.nick;
      continue;
      label83:
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.remark;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.isReaded;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.MayKnowMessage
 * JD-Core Version:    0.7.0.1
 */