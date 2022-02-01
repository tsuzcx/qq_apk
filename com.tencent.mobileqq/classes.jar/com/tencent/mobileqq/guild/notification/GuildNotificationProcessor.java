package com.tencent.mobileqq.guild.notification;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.avgame.util.MosaicUtil;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.BaseConversationMessageNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.util.notification.NotifyIdManager;

public final class GuildNotificationProcessor
  extends BaseConversationMessageNotificationProcessor
{
  protected GuildNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  @Nullable
  private NotificationElement e(Message paramMessage)
  {
    if (!TextUtils.isEmpty(paramMessage.nickName)) {
      localObject1 = paramMessage.nickName;
    } else {
      localObject1 = "";
    }
    Object localObject2 = ((IGPSService)this.a.getRuntimeService(IGPSService.class)).getChannelInfo(paramMessage.frienduin);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(((IGProChannelInfo)localObject2).getChannelName());
    localStringBuilder.append("] ");
    localObject2 = localStringBuilder.toString();
    if (MsgProxyUtils.f(paramMessage.msgtype))
    {
      localObject1 = this.a.getNamePostfix(paramMessage);
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.getNamePostfix(paramMessage));
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append(b());
    ((StringBuilder)localObject2).append("):");
    localObject2 = ((StringBuilder)localObject2).toString();
    this.b.b((String)localObject2);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(d());
      localObject1 = ((StringBuilder)localObject2).toString();
      this.b.d((String)localObject1);
    }
    else
    {
      localObject1 = d();
      this.b.d((String)localObject1);
    }
    Object localObject1 = ColorNickManager.b(c());
    this.b.d((String)localObject1);
    if ((this.a instanceof QQAppInterface))
    {
      localObject1 = MosaicUtil.a((URLDrawable)((IQQGuildService)this.a.getRuntimeService(IQQGuildService.class, "")).getAvatarDrawable(String.valueOf(((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(paramMessage))));
      this.b.a((Bitmap)localObject1);
    }
    localObject1 = NotifyIdManager.a(this.a);
    if (localObject1 != null)
    {
      localObject1 = ((NotifyIdManager)localObject1).b(c(), paramMessage);
      this.b.d((String)localObject1);
    }
    localObject1 = MessageNotificationSettingManager.a(this.a).a(c(), paramMessage);
    this.b.d((String)localObject1);
    c(paramMessage);
    this.b.b().putExtra("channel_name", paramMessage.getExtInfoFromExtStr("MSG_CHANNEL_NAME"));
    return this.b;
  }
  
  public NotificationElement a(Message paramMessage)
  {
    return e(paramMessage);
  }
  
  public int b(Message paramMessage)
  {
    boolean bool = this.a.isShowMsgContent();
    int i = paramMessage.istroop;
    paramMessage = String.valueOf(((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(paramMessage));
    if (NotifyIdManager.a(i, paramMessage))
    {
      if (bool) {
        return NotifyIdManager.b().a(paramMessage);
      }
      return 265;
    }
    return -113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notification.GuildNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */