package com.tencent.timi.game.liveroom.impl.view.message;

import android.graphics.Bitmap;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.app.event.AnchorAtEvent;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/message/AnchorGiftMsgItemView$refresh$1$thanksBtn$1$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "timi-game-impl_release", "com/tencent/timi/game/liveroom/impl/view/message/AnchorGiftMsgItemView$$special$$inlined$apply$lambda$1"}, k=1, mv={1, 1, 16})
public final class AnchorGiftMsgItemView$refresh$$inlined$let$lambda$1
  extends ClickableSpan
{
  AnchorGiftMsgItemView$refresh$$inlined$let$lambda$1(GiftMessage paramGiftMessage, Ref.ObjectRef paramObjectRef, Ref.IntRef paramIntRef, AnchorGiftMsgItemView paramAnchorGiftMsgItemView, Bitmap paramBitmap) {}
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "widget");
    paramView = AnchorGiftMsgItemView.a(this.d);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("msg.senderNick:");
    ((StringBuilder)localObject).append(this.a.senderNick);
    ((StringBuilder)localObject).append(",msg.sender:");
    ((StringBuilder)localObject).append(this.a.sender);
    ((StringBuilder)localObject).append(",msg.senderHead:");
    ((StringBuilder)localObject).append(this.a.senderHead);
    Logger.a(paramView, ((StringBuilder)localObject).toString());
    paramView = new LiveUserInfo();
    paramView.nick = ((String)this.b.element);
    paramView.uid = this.a.sender;
    paramView.headUrl = this.a.senderHead;
    long l = paramView.uid;
    localObject = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
    if (l != ((ILoginCoreService)localObject).a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("感谢你赠送的");
      ((StringBuilder)localObject).append(this.c.element);
      ((StringBuilder)localObject).append('个');
      ((StringBuilder)localObject).append(this.a.giftName);
      localObject = ((StringBuilder)localObject).toString();
      SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new AnchorAtEvent(paramView, (String)localObject));
    }
  }
  
  public void updateDrawState(@NotNull TextPaint paramTextPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramTextPaint, "ds");
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.AnchorGiftMsgItemView.refresh..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */