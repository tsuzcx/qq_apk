package com.tencent.timi.game.liveroom.impl.view.message;

import android.app.Activity;
import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.app.event.AnchorAtEvent;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.liveroom.impl.profile.LivingOperateHelper;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/message/AnchorBaseTextMsgItemView$NickNameLongClick;", "Lcom/tencent/timi/game/liveroom/impl/view/message/MsgLongClickableSpan;", "()V", "liveUserInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "getLiveUserInfo", "()Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "setLiveUserInfo", "(Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;)V", "nickColor", "", "roomId", "", "getRoomId", "()J", "setRoomId", "(J)V", "onClick", "", "widget", "Landroid/view/View;", "onLongClick", "setUserInfo", "info", "updateDrawState", "tp", "Landroid/text/TextPaint;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorBaseTextMsgItemView$NickNameLongClick
  extends MsgLongClickableSpan
{
  private final int a = ResUtils.b(2131168483);
  @Nullable
  private LiveUserInfo b;
  private long c;
  
  public final long a()
  {
    return this.c;
  }
  
  public final void a(@NotNull LiveUserInfo paramLiveUserInfo, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveUserInfo, "info");
    this.b = paramLiveUserInfo;
    this.c = paramLong;
  }
  
  public void b()
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("nickName onLoneClick userName = ");
    Object localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((LiveUserInfo)localObject1).nick;
    } else {
      localObject1 = null;
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    Logger.a("TxtMsgView", ((StringBuilder)localObject2).toString());
    localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject2 = TimiGameActivityManager.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("userLongClick ");
      localStringBuilder.append(localObject2);
      Logger.a("BaseMsgView ", localStringBuilder.toString());
      long l = ((LiveUserInfo)localObject1).uid;
      localObject2 = ServiceCenter.a(ITgLiveRoomService.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ServiceCenter.getService…eRoomService::class.java)");
      localObject2 = ((ITgLiveRoomService)localObject2).f();
      if ((localObject2 == null) || (l != ((LiveUserInfo)localObject2).uid)) {
        SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new AnchorAtEvent((LiveUserInfo)localObject1, null, 2, null));
      }
    }
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "widget");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("nickName onClick userName = ");
    Object localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((LiveUserInfo)localObject1).nick;
    } else {
      localObject1 = null;
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    Logger.a("TxtMsgView", ((StringBuilder)localObject2).toString());
    localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject2 = LivingOperateHelper.a;
      Activity localActivity = CommonExKt.a(paramView);
      if (localActivity == null) {
        Intrinsics.throwNpe();
      }
      ((LivingOperateHelper)localObject2).a(paramView, (Context)localActivity, this.c, (LiveUserInfo)localObject1, 1);
    }
  }
  
  public void updateDrawState(@Nullable TextPaint paramTextPaint)
  {
    if (paramTextPaint != null) {
      paramTextPaint.setColor(this.a);
    }
    if (paramTextPaint != null) {
      paramTextPaint.setUnderlineText(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.AnchorBaseTextMsgItemView.NickNameLongClick
 * JD-Core Version:    0.7.0.1
 */