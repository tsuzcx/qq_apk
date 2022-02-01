package com.tencent.mobileqq.triton;

import android.content.Context;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/TritonPlatform$Builder$TritonPlatformFactory;", "", "create", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "context", "Landroid/content/Context;", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "debugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "scriptPlugin", "Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "enableCodeCache", "", "enableOpenGlEs3", "enablePreloadEngine", "workerExecutor", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", "downloader", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface TritonPlatform$Builder$TritonPlatformFactory
{
  @NotNull
  public abstract TritonPlatform create(@NotNull Context paramContext, @NotNull LogDelegate paramLogDelegate, @NotNull DebugConfig paramDebugConfig, @NotNull ScriptPluginFactory paramScriptPluginFactory, @NotNull EnginePackage paramEnginePackage, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NotNull Executor paramExecutor1, @NotNull Executor paramExecutor2, @NotNull Downloader paramDownloader);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.TritonPlatform.Builder.TritonPlatformFactory
 * JD-Core Version:    0.7.0.1
 */