package com.tencent.timi.game.component.chat.at;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.timi.game.profile.api.ui.ProfileDialog;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "d", "Landroid/app/Dialog;", "invoke"}, k=3, mv={1, 1, 16})
final class SpecialMsgUtil$acquireAtAction$2
  extends Lambda
  implements Function1<Dialog, Unit>
{
  SpecialMsgUtil$acquireAtAction$2(Activity paramActivity, CommonOuterClass.QQUserId paramQQUserId, Ref.ObjectRef paramObjectRef)
  {
    super(1);
  }
  
  public final void invoke(@NotNull Dialog paramDialog)
  {
    Intrinsics.checkParameterIsNotNull(paramDialog, "d");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("acquireAtAction Action , ");
    ((StringBuilder)localObject).append(this.$activity);
    Logger.a("SpecialMsgUtil", ((StringBuilder)localObject).toString());
    if ((paramDialog instanceof ProfileDialog))
    {
      localObject = ((ProfileDialog)paramDialog).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("acquireAtAction end ");
      localStringBuilder.append(this.$activity);
      Logger.a("SpecialMsgUtil", localStringBuilder.toString());
      SpecialMsgUtil.a(SpecialMsgUtil.a, this.$uid, (String)localObject, (FamilyAtFunction)this.$atFunction.element, null, null, 24, null);
    }
    paramDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.at.SpecialMsgUtil.acquireAtAction.2
 * JD-Core Version:    0.7.0.1
 */