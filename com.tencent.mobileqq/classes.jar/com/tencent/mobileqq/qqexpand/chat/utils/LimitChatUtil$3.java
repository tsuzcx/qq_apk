package com.tencent.mobileqq.qqexpand.chat.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class LimitChatUtil$3
  implements Runnable
{
  LimitChatUtil$3(AppInterface paramAppInterface, String paramString, boolean paramBoolean, int paramInt, Object paramObject) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      LimitChatUtil.a((QQAppInterface)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangObject);
      if (this.jdField_a_of_type_Int == 1045)
      {
        ExpandFriendData.setMatchSrc((BaseQQAppInterface)localObject, this.jdField_a_of_type_JavaLangString, 6);
        return;
      }
      try
      {
        int i = new JSONObject((String)this.jdField_a_of_type_JavaLangObject).getJSONObject("infos").getJSONObject("match_src").getInt("id");
        ExpandFriendData.setMatchSrc((BaseQQAppInterface)localObject, this.jdField_a_of_type_JavaLangString, i);
        LimitChatUtil.a((QQAppInterface)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, i);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handlePreLoadDataForArkMiniProfileCard get matchSource error");
        localStringBuilder.append(localException);
        QLog.w("LimitChatUtil", 1, localStringBuilder.toString());
        return;
      }
    }
    QLog.w("LimitChatUtil", 1, "app not instanceof QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil.3
 * JD-Core Version:    0.7.0.1
 */