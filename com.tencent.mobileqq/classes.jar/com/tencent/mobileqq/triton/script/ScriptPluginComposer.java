package com.tencent.mobileqq.triton.script;

import com.tencent.mobileqq.triton.TritonEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/script/ScriptPluginComposer;", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "composedScriptPlugins", "", "(Ljava/util/List;)V", "map", "", "", "getMap", "()Ljava/util/Map;", "nonComposablePlugins", "", "onCall", "eventName", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "onCreate", "", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "onDestroy", "onFirstFrame", "onGameLaunched", "onStart", "onStop", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class ScriptPluginComposer
  implements ScriptPlugin
{
  private final List<ScriptPlugin> composedScriptPlugins;
  @NotNull
  private final Map<String, ScriptPlugin> map;
  private final List<ScriptPlugin> nonComposablePlugins;
  
  public ScriptPluginComposer(@NotNull List<? extends ScriptPlugin> paramList)
  {
    this.composedScriptPlugins = paramList;
    this.nonComposablePlugins = ((List)new ArrayList());
    paramList = new HashMap();
    Iterator localIterator1 = ((Iterable)this.composedScriptPlugins).iterator();
    if (localIterator1.hasNext())
    {
      ScriptPlugin localScriptPlugin = (ScriptPlugin)localIterator1.next();
      if ((localScriptPlugin instanceof ScriptPluginComposer)) {
        paramList.putAll(((ScriptPluginComposer)localScriptPlugin).map);
      }
      for (;;)
      {
        break;
        if ((localScriptPlugin instanceof ComposableScriptPlugin))
        {
          Iterator localIterator2 = ((Iterable)((ComposableScriptPlugin)localScriptPlugin).getSupportedEvents()).iterator();
          while (localIterator2.hasNext())
          {
            String str = (String)localIterator2.next();
            ((Map)paramList).put(str, localScriptPlugin);
          }
        }
        else
        {
          this.nonComposablePlugins.add(localScriptPlugin);
        }
      }
    }
    this.map = ((Map)paramList);
  }
  
  @NotNull
  public final Map<String, ScriptPlugin> getMap()
  {
    return this.map;
  }
  
  @Nullable
  public String onCall(@NotNull String paramString, @NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventName");
    Intrinsics.checkParameterIsNotNull(paramArgument, "arguments");
    Object localObject = (ScriptPlugin)this.map.get(paramString);
    if (localObject != null) {}
    for (localObject = ((ScriptPlugin)localObject).onCall(paramString, paramArgument); localObject != null; localObject = null) {
      return localObject;
    }
    Iterator localIterator = ((Iterable)this.nonComposablePlugins).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label104;
      }
      String str = ((ScriptPlugin)localIterator.next()).onCall(paramString, paramArgument);
      localObject = str;
      if (str != null) {
        break;
      }
    }
    label104:
    return null;
  }
  
  public void onCreate(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    Iterator localIterator = ((Iterable)this.composedScriptPlugins).iterator();
    while (localIterator.hasNext()) {
      ((ScriptPlugin)localIterator.next()).onCreate(paramTritonEngine);
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = ((Iterable)this.composedScriptPlugins).iterator();
    while (localIterator.hasNext()) {
      ((ScriptPlugin)localIterator.next()).onDestroy();
    }
  }
  
  public void onFirstFrame()
  {
    Iterator localIterator = ((Iterable)this.composedScriptPlugins).iterator();
    while (localIterator.hasNext()) {
      ((ScriptPlugin)localIterator.next()).onFirstFrame();
    }
  }
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    Iterator localIterator = ((Iterable)this.composedScriptPlugins).iterator();
    while (localIterator.hasNext()) {
      ((ScriptPlugin)localIterator.next()).onGameLaunched(paramTritonEngine);
    }
  }
  
  public void onStart()
  {
    Iterator localIterator = ((Iterable)this.composedScriptPlugins).iterator();
    while (localIterator.hasNext()) {
      ((ScriptPlugin)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    Iterator localIterator = ((Iterable)this.composedScriptPlugins).iterator();
    while (localIterator.hasNext()) {
      ((ScriptPlugin)localIterator.next()).onStop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.ScriptPluginComposer
 * JD-Core Version:    0.7.0.1
 */