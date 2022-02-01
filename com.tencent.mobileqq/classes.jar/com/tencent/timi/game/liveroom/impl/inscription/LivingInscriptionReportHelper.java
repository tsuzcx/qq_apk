package com.tencent.timi.game.liveroom.impl.inscription;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionReportHelper;", "", "()V", "equipStatusMap", "", "", "", "statusListenerSet", "", "Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionReportHelper$StatusListener;", "acquireStatus", "roomId", "addStatusListener", "", "listener", "clear", "removeStatusListener", "updateState", "status", "Companion", "StatusListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingInscriptionReportHelper
{
  public static final LivingInscriptionReportHelper.Companion a = new LivingInscriptionReportHelper.Companion(null);
  @NotNull
  private static final LivingInscriptionReportHelper d = new LivingInscriptionReportHelper();
  private final Map<Long, String> b = (Map)new LinkedHashMap();
  private final Set<LivingInscriptionReportHelper.StatusListener> c = (Set)new LinkedHashSet();
  
  @NotNull
  public final String a(long paramLong)
  {
    String str = (String)this.b.get(Long.valueOf(paramLong));
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public final void a()
  {
    this.b.clear();
    this.c.clear();
  }
  
  public final void a(long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "status");
    boolean bool = Intrinsics.areEqual(paramString, (String)this.b.get(Long.valueOf(paramLong)));
    this.b.put(Long.valueOf(paramLong), paramString);
    if ((bool ^ true))
    {
      Iterator localIterator = ((Iterable)this.c).iterator();
      while (localIterator.hasNext()) {
        ((LivingInscriptionReportHelper.StatusListener)localIterator.next()).a(paramLong, paramString);
      }
    }
  }
  
  public final void a(@NotNull LivingInscriptionReportHelper.StatusListener paramStatusListener)
  {
    Intrinsics.checkParameterIsNotNull(paramStatusListener, "listener");
    this.c.add(paramStatusListener);
  }
  
  public final void b(@NotNull LivingInscriptionReportHelper.StatusListener paramStatusListener)
  {
    Intrinsics.checkParameterIsNotNull(paramStatusListener, "listener");
    this.c.remove(paramStatusListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionReportHelper
 * JD-Core Version:    0.7.0.1
 */