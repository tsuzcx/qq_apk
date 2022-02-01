package com.tencent.mobileqq.triton.internal.engine.init;

import android.content.Context;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.view.GameView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/init/EngineDataImpl;", "Lcom/tencent/mobileqq/triton/engine/EngineData;", "contextImpl", "Lcom/tencent/mobileqq/triton/internal/engine/init/EngineContextImpl;", "(Lcom/tencent/mobileqq/triton/internal/engine/init/EngineContextImpl;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "getDataFileSystem", "()Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "downloader", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "getDownloader", "()Lcom/tencent/mobileqq/triton/utils/Downloader;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "getEnginePackage", "()Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "getGamePackage", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "gameView", "Lcom/tencent/mobileqq/triton/view/GameView;", "getGameView", "()Lcom/tencent/mobileqq/triton/view/GameView;", "inspectorAgent", "Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "getInspectorAgent", "()Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "logDelegate", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "getLogDelegate", "()Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "scriptPlugin", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "getScriptPlugin", "()Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "userDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "", "getUserDataMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "get", "R", "T", "tag", "(Ljava/lang/Class;)Ljava/lang/Object;", "getOrNull", "has", "", "set", "", "data", "(Ljava/lang/Class;Ljava/lang/Object;)V", "Triton_release"}, k=1, mv={1, 1, 16})
final class EngineDataImpl
  implements EngineData
{
  private final EngineContextImpl contextImpl;
  @NotNull
  private final ConcurrentHashMap<Class<?>, Object> userDataMap;
  
  public EngineDataImpl(@NotNull EngineContextImpl paramEngineContextImpl)
  {
    this.contextImpl = paramEngineContextImpl;
    this.userDataMap = new ConcurrentHashMap();
  }
  
  public <T, R extends T> R get(@NotNull Class<T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "tag");
    return MapsKt.getValue((Map)this.userDataMap, paramClass);
  }
  
  @NotNull
  public Context getContext()
  {
    return this.contextImpl.getContext();
  }
  
  @NotNull
  public GameDataFileSystem getDataFileSystem()
  {
    return this.contextImpl.getDataFileSystem();
  }
  
  @NotNull
  public Downloader getDownloader()
  {
    return this.contextImpl.getDownloader();
  }
  
  @NotNull
  public EnginePackage getEnginePackage()
  {
    return this.contextImpl.getEnginePackage();
  }
  
  @NotNull
  public GamePackage getGamePackage()
  {
    return this.contextImpl.getGamePackage();
  }
  
  @NotNull
  public GameView getGameView()
  {
    return this.contextImpl.getGameView();
  }
  
  @Nullable
  public InspectorAgent getInspectorAgent()
  {
    return this.contextImpl.getInspectorAgent();
  }
  
  @NotNull
  public LogDelegate getLogDelegate()
  {
    return Logger.INSTANCE.getDelegate();
  }
  
  @Nullable
  public <T, R extends T> R getOrNull(@NotNull Class<T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "tag");
    return this.userDataMap.get(paramClass);
  }
  
  @NotNull
  public ScriptPlugin getScriptPlugin()
  {
    return this.contextImpl.getScriptPluginWrapper().getExternalPlugin();
  }
  
  @NotNull
  public final ConcurrentHashMap<Class<?>, Object> getUserDataMap()
  {
    return this.userDataMap;
  }
  
  public boolean has(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "tag");
    return this.userDataMap.containsKey(paramClass);
  }
  
  public <T> void set(@NotNull Class<T> paramClass, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "tag");
    ((Map)this.userDataMap).put(paramClass, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineDataImpl
 * JD-Core Version:    0.7.0.1
 */