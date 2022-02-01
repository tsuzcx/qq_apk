package com.tencent.mobileqq.guild.setting;

import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;

class QQGuildMemberListViewModel$7
  implements IGetUserInfoCallback
{
  QQGuildMemberListViewModel$7(QQGuildMemberListViewModel paramQQGuildMemberListViewModel) {}
  
  public void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1)
  {
    this.a.p.setValue(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListViewModel.7
 * JD-Core Version:    0.7.0.1
 */