package com.tencent.mobileqq.ecshop.temp.api.impl;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopPublicAccountChatPieTempApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/temp/api/impl/EcshopPublicAccountChatPieTempApiImpl;", "Lcom/tencent/mobileqq/ecshop/temp/api/IEcshopPublicAccountChatPieTempApi;", "()V", "getCurPieAnimator", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "getCurrentPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "startDelAnimAndDelMsg", "", "chatMessage", "Lcom/tencent/mobileqq/data/ChatMessage;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class EcshopPublicAccountChatPieTempApiImpl
  implements IEcshopPublicAccountChatPieTempApi
{
  private final BaseChatPie getCurrentPie(Context paramContext)
  {
    boolean bool = paramContext instanceof BaseActivity;
    Object localObject1 = null;
    if (!bool) {
      paramContext = null;
    }
    Object localObject2 = (BaseActivity)paramContext;
    paramContext = localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((BaseActivity)localObject2).getChatFragment();
      paramContext = localObject1;
      if (localObject2 != null) {
        paramContext = ((ChatFragment)localObject2).k();
      }
    }
    return paramContext;
  }
  
  @Nullable
  public ViewGroup getCurPieAnimator()
  {
    Object localObject2 = null;
    Object localObject3 = getCurrentPie$default(this, null, 1, null);
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseChatPie)localObject3).aZ;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = (ViewGroup)((ViewGroup)localObject3).findViewById(2131428370);
      }
    }
    return localObject1;
  }
  
  @Nullable
  public ViewGroup getCurPieAnimator(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = getCurrentPie(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.aZ;
      if (paramContext != null) {
        return (ViewGroup)paramContext.findViewById(2131428370);
      }
    }
    return null;
  }
  
  public void startDelAnimAndDelMsg(@NotNull Context paramContext, @NotNull ChatMessage paramChatMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramChatMessage, "chatMessage");
    paramContext = getCurrentPie(paramContext);
    if (paramContext != null) {
      paramContext.a(paramChatMessage);
    }
  }
  
  public void startDelAnimAndDelMsg(@NotNull ChatMessage paramChatMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramChatMessage, "chatMessage");
    BaseChatPie localBaseChatPie = getCurrentPie$default(this, null, 1, null);
    if (localBaseChatPie != null) {
      localBaseChatPie.a(paramChatMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.temp.api.impl.EcshopPublicAccountChatPieTempApiImpl
 * JD-Core Version:    0.7.0.1
 */