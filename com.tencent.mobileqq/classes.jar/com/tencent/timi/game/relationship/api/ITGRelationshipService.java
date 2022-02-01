package com.tencent.timi.game.relationship.api;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.router.IService;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/relationship/api/ITGRelationshipService;", "Lcom/tencent/timi/game/router/IService;", "ADD_QQ_FRIEND_REQUEST_CODE", "", "getADD_QQ_FRIEND_REQUEST_CODE", "()I", "addQQFriendFromCPDDText", "", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "uin", "", "showName", "addQQFriendFromCPDDVoice", "addQQFriendFromFleet", "initiatorId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "isQQFriend", "", "app", "Lmqq/app/AppRuntime;", "openChatPage", "matchRelationSource", "safetyReport", "scene", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ITGRelationshipService
  extends IService
{
  public abstract void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull String paramString, int paramInt);
  
  public abstract void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void a(@NotNull QBaseActivity paramQBaseActivity, @NotNull CommonOuterClass.QQUserId paramQQUserId, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract boolean a(@NotNull String paramString, @NotNull AppRuntime paramAppRuntime);
  
  public abstract void b(@NotNull QBaseActivity paramQBaseActivity, @NotNull String paramString1, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.relationship.api.ITGRelationshipService
 * JD-Core Version:    0.7.0.1
 */