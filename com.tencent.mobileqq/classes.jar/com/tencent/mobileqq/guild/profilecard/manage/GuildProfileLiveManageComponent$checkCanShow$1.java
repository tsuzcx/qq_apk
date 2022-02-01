package com.tencent.mobileqq.guild.profilecard.manage;

import android.view.ViewGroup;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "sucList", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "", "<anonymous parameter 3>", "onGetUserInfo"}, k=3, mv={1, 1, 16})
final class GuildProfileLiveManageComponent$checkCanShow$1
  implements IGetUserInfoCallback
{
  GuildProfileLiveManageComponent$checkCanShow$1(GuildProfileLiveManageComponent paramGuildProfileLiveManageComponent) {}
  
  public final void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1)
  {
    paramList1 = GuildProfileLiveManageComponent.access$getTAG$p(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryUserIsAdmin onGetUserInfo result:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    QLog.i(paramList1, 1, localStringBuilder.toString());
    if ((paramInt == 0) && (paramList != null) && ((((Collection)paramList).isEmpty() ^ true)))
    {
      boolean bool = QQGuildUtil.c((IGProUserInfo)paramList.get(0));
      paramString = GuildProfileLiveManageComponent.access$getTAG$p(this.a);
      paramList = new StringBuilder();
      paramList.append("queryUserIsAdmin : ");
      paramList.append(bool);
      QLog.i(paramString, 1, paramList.toString());
      if (bool)
      {
        paramString = GuildProfileLiveManageComponent.access$getMViewContainer$p(this.a);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "mViewContainer");
        paramString.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileLiveManageComponent.checkCanShow.1
 * JD-Core Version:    0.7.0.1
 */