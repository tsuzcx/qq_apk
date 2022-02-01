package com.tencent.mobileqq.kandian.biz.privatechat.api;

import android.content.Context;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Service(needUin=false, process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/privatechat/api/IRIJPrivateChatService;", "Lmqq/app/api/IRuntimeService;", "clearPrivateChatRedCount", "", "getConversationFacade", "Lcom/tencent/mobileqq/msg/api/IConversationFacade;", "getPrivateChatRedCount", "", "isKanDianPrivateChatMsg", "", "messageRecord", "Lcom/tencent/mobileqq/data/MessageRecord;", "jumpKanDianProfilePage", "context", "Landroid/content/Context;", "uin", "", "openAIOIntent", "uinName", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJPrivateChatService
  extends IRuntimeService
{
  public abstract void clearPrivateChatRedCount();
  
  @NotNull
  public abstract IConversationFacade getConversationFacade();
  
  public abstract int getPrivateChatRedCount();
  
  public abstract boolean isKanDianPrivateChatMsg(@Nullable MessageRecord paramMessageRecord);
  
  public abstract void jumpKanDianProfilePage(@Nullable Context paramContext, @Nullable String paramString);
  
  public abstract void openAIOIntent(@Nullable Context paramContext, @NotNull String paramString1, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatService
 * JD-Core Version:    0.7.0.1
 */