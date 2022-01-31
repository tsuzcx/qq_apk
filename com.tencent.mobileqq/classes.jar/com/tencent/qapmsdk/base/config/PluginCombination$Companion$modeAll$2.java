package com.tencent.qapmsdk.base.config;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
final class PluginCombination$Companion$modeAll$2
  extends Lambda
  implements Function0<Integer>
{
  public static final 2 INSTANCE = new 2();
  
  PluginCombination$Companion$modeAll$2()
  {
    super(0);
  }
  
  public final int invoke()
  {
    int i = 0;
    Iterator localIterator1 = ((Iterable)CollectionsKt.listOf(new List[] { PluginCombination.access$getAusterityPlugins$cp(), PluginCombination.Companion.getLoosePlugins$qapmbase_release() })).iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Iterable)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        i |= ((DefaultPluginConfig)localIterator2.next()).mode;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.PluginCombination.Companion.modeAll.2
 * JD-Core Version:    0.7.0.1
 */