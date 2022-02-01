package com.tencent.mobileqq.kandian.biz.biu;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ReadInjoyFriendsBiuComponentFragment$ViewHolder$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ReadInjoyFriendsBiuComponentFragment$ViewHolder$1(ReadInjoyFriendsBiuComponentFragment.ViewHolder paramViewHolder) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setComments infoFailed. uin:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString2);
    QLog.d("ReadInjoyFriendsBiuComponentFragment", 1, localStringBuilder.toString());
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramReadInJoyUserInfo != null) && (this.a.a != null)) {
      ThreadManager.getUIHandler().post(new ReadInjoyFriendsBiuComponentFragment.ViewHolder.1.1(this));
    }
    if (paramReadInJoyUserInfo != null) {
      paramReadInJoyUserInfo = paramReadInJoyUserInfo.nick;
    } else {
      paramReadInJoyUserInfo = "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("  uin:");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" mContents:");
    localStringBuilder.append(this.a.a);
    QLog.d("ReadInjoyFriendsBiuComponentFragment", 1, new Object[] { "setComments infoSuccess nick = ", paramReadInJoyUserInfo, paramString, localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInjoyFriendsBiuComponentFragment.ViewHolder.1
 * JD-Core Version:    0.7.0.1
 */