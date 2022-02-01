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
    this.a = paramMayKnowRecommend;
    this.d = paramMayKnowRecommend.timestamp;
  }
  
  public String a()
  {
    return this.a.uin;
  }
  
  public String b(AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(this.c))
    {
      boolean bool = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isPhoneContactEnabled((AppInterface)paramAppRuntime);
      paramAppRuntime = this.a.getDisplayName(bool);
      this.c = String.format(MobileQQ.sMobileQQ.getApplicationContext().getString(2131886304), new Object[] { paramAppRuntime });
    }
    return this.c;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.MayKnowMessage
 * JD-Core Version:    0.7.0.1
 */