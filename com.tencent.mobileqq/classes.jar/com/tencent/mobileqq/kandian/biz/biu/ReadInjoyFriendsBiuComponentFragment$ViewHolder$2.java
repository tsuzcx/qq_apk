package com.tencent.mobileqq.kandian.biz.biu;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ReadInjoyFriendsBiuComponentFragment$ViewHolder$2
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ReadInjoyFriendsBiuComponentFragment$ViewHolder$2(ReadInjoyFriendsBiuComponentFragment.ViewHolder paramViewHolder) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(paramString1))) {
      ThreadManager.getUIHandler().post(new ReadInjoyFriendsBiuComponentFragment.ViewHolder.2.2(this));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setNickName infoFailed. uin:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString2);
    QLog.d("ReadInjoyFriendsBiuComponentFragment", 1, localStringBuilder.toString());
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramString != null) && (paramString.equals(paramString)) && (paramReadInJoyUserInfo != null)) {
      ThreadManager.getUIHandler().post(new ReadInjoyFriendsBiuComponentFragment.ViewHolder.2.1(this, paramReadInJoyUserInfo));
    }
    if (paramReadInJoyUserInfo != null) {
      paramReadInJoyUserInfo = paramReadInJoyUserInfo.nick;
    } else {
      paramReadInJoyUserInfo = "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("  uin:");
    localStringBuilder.append(paramString);
    QLog.d("ReadInjoyFriendsBiuComponentFragment", 1, new Object[] { "setNickName infoSuccess nick = ", paramReadInJoyUserInfo, localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInjoyFriendsBiuComponentFragment.ViewHolder.2
 * JD-Core Version:    0.7.0.1
 */