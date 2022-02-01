package com.tencent.mobileqq.guild.profilecard.manage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class GuildProfileLiveManageComponent$setObservers$1<T>
  implements Observer<Boolean>
{
  GuildProfileLiveManageComponent$setObservers$1(GuildProfileLiveManageComponent paramGuildProfileLiveManageComponent) {}
  
  public final void a(Boolean paramBoolean)
  {
    GuildProfileLiveManageComponent localGuildProfileLiveManageComponent = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramBoolean, "it");
    Object localObject;
    int i;
    if (paramBoolean.booleanValue())
    {
      paramBoolean = GuildProfileLiveManageComponent.access$getMuteIcon$p(this.a);
      localObject = this.a.getContainerView();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView");
      localObject = ((View)localObject).getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.context");
      paramBoolean.setImageDrawable(((Context)localObject).getResources().getDrawable(2130840841));
      GuildProfileLiveManageComponent.access$getMuteTips$p(this.a).setText(2131890550);
      i = 2;
    }
    else
    {
      paramBoolean = GuildProfileLiveManageComponent.access$getMuteIcon$p(this.a);
      localObject = this.a.getContainerView();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView");
      localObject = ((View)localObject).getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.context");
      paramBoolean.setImageDrawable(((Context)localObject).getResources().getDrawable(2130840840));
      GuildProfileLiveManageComponent.access$getMuteTips$p(this.a).setText(2131890549);
      i = 1;
    }
    GuildProfileLiveManageComponent.access$setOperatorType$p(localGuildProfileLiveManageComponent, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileLiveManageComponent.setObservers.1
 * JD-Core Version:    0.7.0.1
 */