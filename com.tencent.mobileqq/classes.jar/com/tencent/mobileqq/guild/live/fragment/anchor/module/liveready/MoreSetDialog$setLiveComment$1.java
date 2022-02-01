package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "<anonymous parameter 2>", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "onResult"}, k=3, mv={1, 1, 16})
final class MoreSetDialog$setLiveComment$1
  implements IResultWithSecurityCallback
{
  MoreSetDialog$setLiveComment$1(MoreSetDialog paramMoreSetDialog) {}
  
  public final void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    paramIGProSecurityResult = MoreSetDialog.b(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("res ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" err ");
    localStringBuilder.append(paramString);
    QLog.d(paramIGProSecurityResult, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.MoreSetDialog.setLiveComment.1
 * JD-Core Version:    0.7.0.1
 */