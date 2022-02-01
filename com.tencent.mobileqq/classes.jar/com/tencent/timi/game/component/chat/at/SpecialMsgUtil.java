package com.tencent.timi.game.component.chat.at;

import android.app.Activity;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.component.chat.input.KeyboardUtils;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.utils.Logger;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.AtUser;
import trpc.yes.common.MessageOuterClass.AtUserMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/at/SpecialMsgUtil;", "", "()V", "acquireAtAction", "Lcom/tencent/timi/game/component/chat/at/SpecialMsgUtil$Action;", "uid", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "activity", "Landroid/app/Activity;", "isAtUser", "", "data", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "userId", "Ltrpc/yes/common/MessageOuterClass$AtUserMsg;", "isAtUserAnchor", "", "(Ltrpc/yes/common/MessageOuterClass$AtUserMsg;Ljava/lang/Long;)Z", "resetAtContentSpan", "startPos", "", "txtStr", "", "idQQUserInfoMap", "", "spannable", "Landroid/text/SpannableStringBuilder;", "color", "underLine", "clickable", "Lcom/tencent/timi/game/component/chat/at/AtMessageClickListener;", "startInput", "", "userName", "editText", "Landroid/widget/EditText;", "inputBox", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "familyAtFunction", "Lcom/tencent/timi/game/component/chat/at/FamilyAtFunction;", "quickString", "headUrl", "Action", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SpecialMsgUtil
{
  public static final SpecialMsgUtil a = new SpecialMsgUtil();
  
  @Nullable
  public final SpecialMsgUtil.Action a(@NotNull CommonOuterClass.QQUserId paramQQUserId, @NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "uid");
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("acquireAtAction = ");
    ((StringBuilder)localObject1).append(paramActivity);
    Logger.a("SpecialMsgUtil", ((StringBuilder)localObject1).toString());
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    Object localObject2 = null;
    localObjectRef.element = ((FamilyAtFunction)null);
    if (!(paramActivity instanceof FamilyAtFunction))
    {
      if ((paramActivity instanceof QPublicFragmentActivity))
      {
        localObject1 = (QPublicFragmentActivity)paramActivity;
        if ((((QPublicFragmentActivity)localObject1).getFragment() instanceof FamilyAtFunction))
        {
          QPublicBaseFragment localQPublicBaseFragment = ((QPublicFragmentActivity)localObject1).getFragment();
          localObject1 = localQPublicBaseFragment;
          if (!(localQPublicBaseFragment instanceof FamilyAtFunction)) {
            localObject1 = null;
          }
          localObjectRef.element = ((FamilyAtFunction)localObject1);
        }
      }
      if ((FamilyAtFunction)localObjectRef.element == null)
      {
        localObject1 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
        if ((localObject1 != null) && ((localObject1 instanceof FamilyAtFunction))) {
          localObjectRef.element = ((FamilyAtFunction)localObject1);
        }
      }
    }
    else
    {
      localObjectRef.element = ((FamilyAtFunction)paramActivity);
    }
    if ((FamilyAtFunction)localObjectRef.element == null) {
      return null;
    }
    localObject1 = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…nCoreService::class.java)");
    long l = ((ILoginCoreService)localObject1).a();
    localObject1 = localObject2;
    if (paramQQUserId.uid.get() != l) {
      localObject1 = new SpecialMsgUtil.Action("@TA", (Function1)new SpecialMsgUtil.acquireAtAction.2(paramActivity, paramQQUserId, localObjectRef));
    }
    return localObject1;
  }
  
  public final void a(@NotNull CommonOuterClass.QQUserId paramQQUserId, @Nullable String paramString, @Nullable EditText paramEditText, @Nullable TimiBaseInputView paramTimiBaseInputView)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startInput ");
    ((StringBuilder)localObject).append(paramEditText);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(paramTimiBaseInputView);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(paramQQUserId);
    Logger.a("SpecialMsgUtil ", ((StringBuilder)localObject).toString());
    localObject = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
    long l = ((ILoginCoreService)localObject).a();
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (paramEditText != null) && (paramTimiBaseInputView != null) && (l != paramQQUserId.uid.get()) && (paramQQUserId.uid.get() != 0L))
    {
      TimiBaseInputView.a(paramTimiBaseInputView, paramQQUserId, paramString, null, 4, null);
      paramQQUserId = new StringBuilder();
      paramQQUserId.append(paramEditText.getText());
      paramQQUserId.append('@');
      paramQQUserId.append(paramString);
      paramQQUserId.append(" ");
      paramQQUserId = paramQQUserId.toString();
      paramEditText.setText((CharSequence)paramQQUserId);
      paramEditText.setSelection(paramQQUserId.length());
    }
  }
  
  public final void a(@NotNull CommonOuterClass.QQUserId paramQQUserId, @Nullable String paramString1, @Nullable FamilyAtFunction paramFamilyAtFunction, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    Intrinsics.checkParameterIsNotNull(paramString2, "quickString");
    Intrinsics.checkParameterIsNotNull(paramString3, "headUrl");
    TimiBaseInputView localTimiBaseInputView = null;
    EditText localEditText;
    if (paramFamilyAtFunction != null) {
      localEditText = paramFamilyAtFunction.c();
    } else {
      localEditText = null;
    }
    if (paramFamilyAtFunction != null) {
      localTimiBaseInputView = paramFamilyAtFunction.dJ_();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startInput ");
    ((StringBuilder)localObject).append(localEditText);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(localTimiBaseInputView);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(paramQQUserId);
    Logger.a("SpecialMsgUtil ", ((StringBuilder)localObject).toString());
    localObject = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
    long l = ((ILoginCoreService)localObject).a();
    if ((!TextUtils.isEmpty((CharSequence)paramString1)) && (localEditText != null) && (localTimiBaseInputView != null) && (l != paramQQUserId.uid.get()) && (paramQQUserId.uid.get() != 0L))
    {
      localTimiBaseInputView.a(paramQQUserId, paramString1, paramString3);
      paramQQUserId = new StringBuilder();
      paramQQUserId.append(localEditText.getText());
      paramQQUserId.append('@');
      paramQQUserId.append(paramString1);
      paramQQUserId.append(" ");
      paramQQUserId.append(paramString2);
      paramQQUserId = paramQQUserId.toString();
      localEditText.setText((CharSequence)paramQQUserId);
      localEditText.setSelection(paramQQUserId.length());
      if (((paramFamilyAtFunction instanceof Activity)) && (((Build.VERSION.SDK_INT >= 17) && (((Activity)paramFamilyAtFunction).isDestroyed())) || (((Activity)paramFamilyAtFunction).isFinishing())))
      {
        Logger.a("SpecialMsgUtil ", "startInput destroy");
        return;
      }
      if (((paramFamilyAtFunction instanceof QPublicBaseFragment)) && (!((QPublicBaseFragment)paramFamilyAtFunction).isAdded())) {
        return;
      }
      localTimiBaseInputView.setVisibility(0);
      KeyboardUtils.a((View)localEditText);
    }
  }
  
  public final boolean a(int paramInt1, @NotNull String paramString, @NotNull Map<String, CommonOuterClass.QQUserId> paramMap, @NotNull SpannableStringBuilder paramSpannableStringBuilder, int paramInt2, boolean paramBoolean, @Nullable AtMessageClickListener paramAtMessageClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "txtStr");
    Intrinsics.checkParameterIsNotNull(paramMap, "idQQUserInfoMap");
    Intrinsics.checkParameterIsNotNull(paramSpannableStringBuilder, "spannable");
    return ((Collection)ChatAtMessageUtil.a.a(paramInt1, paramString, paramMap, (Spannable)paramSpannableStringBuilder, paramInt2, paramBoolean, paramAtMessageClickListener)).isEmpty() ^ true;
  }
  
  public final boolean a(@Nullable IMsg paramIMsg, @Nullable CommonOuterClass.QQUserId paramQQUserId)
  {
    if (paramIMsg != null)
    {
      paramIMsg = paramIMsg.g();
      if (paramIMsg != null)
      {
        paramIMsg = paramIMsg.at_user_msg;
        break label25;
      }
    }
    paramIMsg = null;
    label25:
    return a(paramIMsg, paramQQUserId);
  }
  
  public final boolean a(@Nullable MessageOuterClass.AtUserMsg paramAtUserMsg, @Nullable Long paramLong)
  {
    if (paramAtUserMsg != null)
    {
      paramAtUserMsg = paramAtUserMsg.user_list;
      if (paramAtUserMsg != null)
      {
        paramAtUserMsg = paramAtUserMsg.get();
        if (paramAtUserMsg != null)
        {
          paramAtUserMsg = ((Iterable)paramAtUserMsg).iterator();
          while (paramAtUserMsg.hasNext())
          {
            long l = ((MessageOuterClass.AtUser)paramAtUserMsg.next()).user_id.uid.get();
            if ((paramLong != null) && (l == paramLong.longValue())) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  public final boolean a(@Nullable MessageOuterClass.AtUserMsg paramAtUserMsg, @Nullable CommonOuterClass.QQUserId paramQQUserId)
  {
    if (paramAtUserMsg != null)
    {
      paramAtUserMsg = paramAtUserMsg.user_list;
      if (paramAtUserMsg != null)
      {
        paramAtUserMsg = paramAtUserMsg.get();
        if (paramAtUserMsg != null)
        {
          paramAtUserMsg = ((Iterable)paramAtUserMsg).iterator();
          while (paramAtUserMsg.hasNext())
          {
            MessageOuterClass.AtUser localAtUser = (MessageOuterClass.AtUser)paramAtUserMsg.next();
            long l = localAtUser.user_id.uid.get();
            if (paramQQUserId != null)
            {
              PBUInt64Field localPBUInt64Field = paramQQUserId.uid;
              if ((localPBUInt64Field != null) && (l == localPBUInt64Field.get()) && (localAtUser.user_id.user_from.get() == paramQQUserId.user_from.get())) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.at.SpecialMsgUtil
 * JD-Core Version:    0.7.0.1
 */