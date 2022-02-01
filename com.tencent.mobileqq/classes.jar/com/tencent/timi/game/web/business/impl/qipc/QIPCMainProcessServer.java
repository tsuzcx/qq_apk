package com.tencent.timi.game.web.business.impl.qipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.timi.game.utils.Logger;
import eipc.EIPCResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/web/business/impl/qipc/QIPCMainProcessServer;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "name", "", "(Ljava/lang/String;)V", "TAG", "ipcCallBackId", "", "convertValueToJson", "Lorg/json/JSONObject;", "key", "value", "", "onCall", "Leipc/EIPCResult;", "action", "params", "Landroid/os/Bundle;", "callbackId", "qipcCallback", "", "bundle", "registerModule", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class QIPCMainProcessServer
  extends QIPCModule
{
  public static final QIPCMainProcessServer.Companion a = new QIPCMainProcessServer.Companion(null);
  @NotNull
  private static final Lazy d = LazyKt.lazy((Function0)QIPCMainProcessServer.Companion.instance.2.INSTANCE);
  private final String b = "QIPCMainProcessServer";
  private int c;
  
  public QIPCMainProcessServer(@NotNull String paramString)
  {
    super(paramString);
  }
  
  @Nullable
  public EIPCResult onCall(@Nullable String paramString, @Nullable Bundle paramBundle, int paramInt)
  {
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCall ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(',');
    localStringBuilder.append(paramBundle);
    localStringBuilder.append(',');
    localStringBuilder.append(paramInt);
    Logger.a(str, localStringBuilder.toString());
    this.c = paramInt;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.qipc.QIPCMainProcessServer
 * JD-Core Version:    0.7.0.1
 */