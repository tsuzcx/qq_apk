package com.tencent.mobileqq.ecshop.aio;

import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/aio/IEcshopChatPieCallback;", "", "getList", "", "Lcom/tencent/mobileqq/data/ChatMessage;", "startDelAnimAndDelMsg", "", "chatMessage", "qqshop-feature-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IEcshopChatPieCallback
{
  @NotNull
  public abstract List<ChatMessage> a();
  
  public abstract void a(@NotNull ChatMessage paramChatMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.aio.IEcshopChatPieCallback
 * JD-Core Version:    0.7.0.1
 */