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
    Object localObject = PluginCombination.access$getAusterityPlugins$cp();
    int i = 0;
    localObject = ((Iterable)CollectionsKt.listOf(new List[] { localObject, PluginCombination.Companion.getLoosePlugins$qapmbase_release() })).iterator();
    if (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((Iterable)((Iterator)localObject).next()).iterator();
      int j = i;
      for (;;)
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        j |= ((DefaultPluginConfig)localIterator.next()).mode;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.PluginCombination.Companion.modeAll.2
 * JD-Core Version:    0.7.0.1
 */