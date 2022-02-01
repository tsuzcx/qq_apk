package com.tencent.mobileqq.triton.engine;

import android.content.Context;
import androidx.annotation.AnyThread;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.view.GameView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/engine/EngineData;", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "getDataFileSystem", "()Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "downloader", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "getDownloader", "()Lcom/tencent/mobileqq/triton/utils/Downloader;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "getEnginePackage", "()Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "getGamePackage", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "gameView", "Lcom/tencent/mobileqq/triton/view/GameView;", "getGameView", "()Lcom/tencent/mobileqq/triton/view/GameView;", "inspectorAgent", "Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "getInspectorAgent", "()Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "logDelegate", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "getLogDelegate", "()Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "scriptPlugin", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "getScriptPlugin", "()Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "get", "R", "T", "tag", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getOrNull", "has", "", "set", "", "data", "(Ljava/lang/Class;Ljava/lang/Object;)V", "TritonAPI_release"}, k=1, mv={1, 1, 16})
@AnyThread
public abstract interface EngineData
{
  public abstract <T, R extends T> R get(@NotNull Class<T> paramClass);
  
  @NotNull
  public abstract Context getContext();
  
  @NotNull
  public abstract GameDataFileSystem getDataFileSystem();
  
  @NotNull
  public abstract Downloader getDownloader();
  
  @NotNull
  public abstract EnginePackage getEnginePackage();
  
  @NotNull
  public abstract GamePackage getGamePackage();
  
  @NotNull
  public abstract GameView getGameView();
  
  @Nullable
  public abstract InspectorAgent getInspectorAgent();
  
  @NotNull
  public abstract LogDelegate getLogDelegate();
  
  @Nullable
  public abstract <T, R extends T> T getOrNull(@NotNull Class<T> paramClass);
  
  @NotNull
  public abstract ScriptPlugin getScriptPlugin();
  
  public abstract boolean has(@NotNull Class<?> paramClass);
  
  public abstract <T> void set(@NotNull Class<T> paramClass, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.EngineData
 * JD-Core Version:    0.7.0.1
 */