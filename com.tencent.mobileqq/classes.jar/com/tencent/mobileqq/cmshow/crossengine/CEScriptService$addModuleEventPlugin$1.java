package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.mobileqq.cmshow.crossengine.script.plugin.IModuleEventPlugin;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/crossengine/CEScriptService$addModuleEventPlugin$1", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cmshow/crossengine/script/plugin/IModuleEventPlugin;", "Lkotlin/collections/ArrayList;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEScriptService$addModuleEventPlugin$1
  extends ArrayList<IModuleEventPlugin>
{
  CEScriptService$addModuleEventPlugin$1(IModuleEventPlugin paramIModuleEventPlugin)
  {
    add(paramIModuleEventPlugin);
  }
  
  public int getSize()
  {
    return super.size();
  }
  
  public final IModuleEventPlugin remove(int paramInt)
  {
    return removeAt(paramInt);
  }
  
  public IModuleEventPlugin removeAt(int paramInt)
  {
    return (IModuleEventPlugin)super.remove(paramInt);
  }
  
  public final int size()
  {
    return getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CEScriptService.addModuleEventPlugin.1
 * JD-Core Version:    0.7.0.1
 */