package com.tencent.mobileqq.guild.setting;

import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback.Result;
import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;

class QQGuildVisibleMemberListViewModel$2
  implements IGetVisibleMemberListCallback
{
  QQGuildVisibleMemberListViewModel$2(QQGuildVisibleMemberListViewModel paramQQGuildVisibleMemberListViewModel) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, List<IGProUserInfo> paramList)
  {
    paramString = IGetGProUserListPaginationCallback.Result.a(paramList, Integer.valueOf(0), paramBoolean ^ true);
    this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildVisibleMemberListViewModel.2
 * JD-Core Version:    0.7.0.1
 */