package com.tencent.mobileqq.newfriend.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MayKnowMessage
  extends NewFriendMessage
{
  public MayKnowRecommend a;
  
  public MayKnowMessage(MayKnowRecommend paramMayKnowRecommend)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = paramMayKnowRecommend;
    this.jdField_a_of_type_Long = paramMayKnowRecommend.timestamp;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin;
  }
  
  public String a(AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      boolean bool = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isPhoneContactEnabled((AppInterface)paramAppRuntime);
      paramAppRuntime = this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.getDisplayName(bool);
      this.jdField_a_of_type_JavaLangString = String.format(MobileQQ.sMobileQQ.getApplicationContext().getString(2131689692), new Object[] { paramAppRuntime });
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.MayKnowMessage
 * JD-Core Version:    0.7.0.1
 */