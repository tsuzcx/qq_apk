package com.tencent.mobileqq.cmshow.brickengine;

import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin;
import com.tencent.mobileqq.cmshow.engine.script.plugin.PluginCmdConstant.PlugPriority;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "o1", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "kotlin.jvm.PlatformType", "o2", "compare"}, k=3, mv={1, 1, 16})
final class BKScriptService$registerPlugin$1$1<T>
  implements Comparator<IEventPlugin>
{
  public static final 1 a = new 1();
  
  public final int a(IEventPlugin paramIEventPlugin1, IEventPlugin paramIEventPlugin2)
  {
    return paramIEventPlugin1.a().ordinal() - paramIEventPlugin2.a().ordinal();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKScriptService.registerPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */