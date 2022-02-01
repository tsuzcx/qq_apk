package com.tencent.timi.game.relationship.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.relationship.api.ITGRelationshipService;
import com.tencent.timi.game.relationship.api.ITGRelationshipService.DefaultImpls;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/relationship/impl/TGRelationshipService;", "Lcom/tencent/timi/game/relationship/api/ITGRelationshipService;", "()V", "TAG", "", "addQQFriend", "", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "uin", "source", "", "subSource", "showName", "reqCode", "addQQFriendFromCPDDText", "addQQFriendFromCPDDVoice", "addQQFriendFromFleet", "initiatorId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "init", "context", "Landroid/content/Context;", "isQQFriend", "", "app", "Lmqq/app/AppRuntime;", "isValidActivity", "openChatPage", "from", "realOpenChatPage", "matchRelationSource", "token", "", "safetyReport", "scene", "serviceDestroy", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGRelationshipService
  implements ITGRelationshipService
{
  private final String a = "TGRelationshipServiceUtil";
  
  private final void a(QBaseActivity paramQBaseActivity, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    if (TextUtils.isEmpty((CharSequence)paramString2)) {
      paramString2 = "--";
    }
    paramString1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend((Context)BaseApplication.getContext(), 1, paramString1, "", paramInt1, paramInt2, paramString2, null, null, "返回", null);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult((Activity)paramQBaseActivity, paramString1, paramInt3);
  }
  
  private final void a(QBaseActivity paramQBaseActivity, String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    Logger.b(this.a, "realOpenChatPage ");
    Object localObject = (ILimitChatUtils)QRoute.api(ILimitChatUtils.class);
    AppRuntime localAppRuntime = paramQBaseActivity.getAppRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "activity.appRuntime");
    ((ILimitChatUtils)localObject).saveTempC2cSignature(localAppRuntime, paramString, paramArrayOfByte);
    paramArrayOfByte = new Intent();
    paramArrayOfByte.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ChatActivity");
    paramArrayOfByte.putExtra("uin", paramString);
    localObject = paramQBaseActivity.getAppRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.appRuntime");
    if (a(paramString, (AppRuntime)localObject)) {
      paramArrayOfByte.putExtra("uintype", 0);
    } else {
      paramArrayOfByte.putExtra("uintype", 1044);
    }
    paramArrayOfByte.putExtra("entrance", 21);
    paramArrayOfByte.putExtra("key_limitchat_match_relation_source", paramInt);
    paramQBaseActivity.startActivity(paramArrayOfByte);
  }
  
  private final boolean a(QBaseActivity paramQBaseActivity)
  {
    return (paramQBaseActivity != null) && (!paramQBaseActivity.isFinishing()) && ((Build.VERSION.SDK_INT < 17) || (!paramQBaseActivity.isDestroyed()));
  }
  
  public int a()
  {
    return ITGRelationshipService.DefaultImpls.a(this);
  }
  
  public void a(@Nullable Context paramContext) {}
  
  public void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    TGRelationshipService.openChatPage.listener.1 local1 = new TGRelationshipService.openChatPage.listener.1(this, paramString, paramInt);
    Logger.b(this.a, "openChatPage start");
    LoadingUtils.a.a((Context)paramQBaseActivity);
    AioChatTokenUtil.a.a(paramQBaseActivity, paramString, (AioChatTokenUtil.TokenListener)local1);
  }
  
  public void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    Intrinsics.checkParameterIsNotNull(paramString2, "showName");
    a(paramQBaseActivity, paramString1, 3094, 17, paramString2, a());
  }
  
  public void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull CommonOuterClass.QQUserId paramQQUserId, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "initiatorId");
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    Intrinsics.checkParameterIsNotNull(paramString2, "showName");
    if (paramQQUserId.user_from.get() == 2)
    {
      a(paramQBaseActivity, paramString1, 3097, 19, paramString2, a());
      return;
    }
    a(paramQBaseActivity, paramString1, 3094, 19, paramString2, a());
  }
  
  public boolean a(@NotNull String paramString, @NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    paramAppRuntime = paramAppRuntime.getRuntimeService(IFriendDataService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "app.getRuntimeService(\n …ava, ProcessConstant.ALL)");
    return ((IFriendDataService)paramAppRuntime).isFriend(paramString);
  }
  
  public void b(@NotNull QBaseActivity paramQBaseActivity, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    Intrinsics.checkParameterIsNotNull(paramString2, "showName");
    a(paramQBaseActivity, paramString1, 3094, 18, paramString2, a());
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.relationship.impl.TGRelationshipService
 * JD-Core Version:    0.7.0.1
 */