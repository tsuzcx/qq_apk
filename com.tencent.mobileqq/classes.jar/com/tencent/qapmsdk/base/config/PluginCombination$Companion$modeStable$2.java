package com.tencent.qapmsdk.base.config;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
final class PluginCombination$Companion$modeStable$2
  extends Lambda
  implements Function0<Integer>
{
  public static final 2 INSTANCE = new 2();
  
  PluginCombination$Companion$modeStable$2()
  {
    super(0);
  }
  
  public final int invoke()
  {
    int i = 0;
    Iterator localIterator = ((Iterable)PluginCombination.access$getStablePlugins$cp()).iterator();
    while (localIterator.hasNext()) {
      i = ((DefaultPluginConfig)localIterator.next()).mode | i;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.PluginCombination.Companion.modeStable.2
 * JD-Core Version:    0.7.0.1
 */