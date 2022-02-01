package com.tencent.mobileqq.ecshop.temp.api;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/temp/api/IEcshopPublicAccountChatPieTempApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getCurPieAnimator", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "startDelAnimAndDelMsg", "", "chatMessage", "Lcom/tencent/mobileqq/data/ChatMessage;", "qqshop-feature-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IEcshopPublicAccountChatPieTempApi
  extends QRouteApi
{
  @Nullable
  public abstract ViewGroup getCurPieAnimator();
  
  @Nullable
  public abstract ViewGroup getCurPieAnimator(@NotNull Context paramContext);
  
  public abstract void startDelAnimAndDelMsg(@NotNull Context paramContext, @NotNull ChatMessage paramChatMessage);
  
  public abstract void startDelAnimAndDelMsg(@NotNull ChatMessage paramChatMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.temp.api.IEcshopPublicAccountChatPieTempApi
 * JD-Core Version:    0.7.0.1
 */