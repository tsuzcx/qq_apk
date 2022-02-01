package com.tencent.mobileqq.guild.profilecard.manage;

import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, k=3, mv={1, 1, 16})
final class GuildProfileLiveManageComponent$checkCanShow$2<T>
  implements Observer<Integer>
{
  GuildProfileLiveManageComponent$checkCanShow$2(GuildProfileLiveManageComponent paramGuildProfileLiveManageComponent) {}
  
  public final void a(Integer paramInteger)
  {
    if (((paramInteger == null) || (paramInteger.intValue() != 1)) && ((paramInteger == null) || (paramInteger.intValue() != 2)))
    {
      paramInteger = GuildProfileLiveManageComponent.access$getMViewContainer$p(this.a);
      Intrinsics.checkExpressionValueIsNotNull(paramInteger, "mViewContainer");
      paramInteger.setVisibility(0);
      return;
    }
    paramInteger = GuildProfileLiveManageComponent.access$getMViewContainer$p(this.a);
    Intrinsics.checkExpressionValueIsNotNull(paramInteger, "mViewContainer");
    paramInteger.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileLiveManageComponent.checkCanShow.2
 * JD-Core Version:    0.7.0.1
 */