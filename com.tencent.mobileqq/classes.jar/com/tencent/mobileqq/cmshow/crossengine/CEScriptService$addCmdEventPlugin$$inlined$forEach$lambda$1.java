package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/crossengine/CEScriptService$addCmdEventPlugin$1$1", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "Lkotlin/collections/ArrayList;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEScriptService$addCmdEventPlugin$$inlined$forEach$lambda$1
  extends ArrayList<IEventPlugin>
{
  CEScriptService$addCmdEventPlugin$$inlined$forEach$lambda$1(CEScriptService paramCEScriptService, IEventPlugin paramIEventPlugin)
  {
    add(this.$eventPlugin$inlined);
  }
  
  public int getSize()
  {
    return super.size();
  }
  
  public final IEventPlugin remove(int paramInt)
  {
    return removeAt(paramInt);
  }
  
  public IEventPlugin removeAt(int paramInt)
  {
    return (IEventPlugin)super.remove(paramInt);
  }
  
  public final int size()
  {
    return getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CEScriptService.addCmdEventPlugin..inlined.forEach.lambda.1
 * JD-Core Version:    0.7.0.1
 */