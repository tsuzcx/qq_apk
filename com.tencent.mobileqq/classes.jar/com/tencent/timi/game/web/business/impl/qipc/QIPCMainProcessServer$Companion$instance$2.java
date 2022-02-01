package com.tencent.timi.game.web.business.impl.qipc;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/timi/game/web/business/impl/qipc/QIPCMainProcessServer;", "invoke"}, k=3, mv={1, 1, 16})
final class QIPCMainProcessServer$Companion$instance$2
  extends Lambda
  implements Function0<QIPCMainProcessServer>
{
  public static final 2 INSTANCE = new 2();
  
  QIPCMainProcessServer$Companion$instance$2()
  {
    super(0);
  }
  
  @NotNull
  public final QIPCMainProcessServer invoke()
  {
    return new QIPCMainProcessServer("tg_qipc_inscription_main_server");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.qipc.QIPCMainProcessServer.Companion.instance.2
 * JD-Core Version:    0.7.0.1
 */