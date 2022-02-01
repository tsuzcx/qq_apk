package com.tencent.mobileqq.triton.internal.engine;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.TritonPlatform.Builder.TritonPlatformFactory;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatformFactory;", "Lcom/tencent/mobileqq/triton/TritonPlatform$Builder$TritonPlatformFactory;", "()V", "create", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "context", "Landroid/content/Context;", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "debugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "scriptPlugin", "Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "enableCodeCache", "", "enableOpenGlEs3", "enablePreloadEngine", "workerExecutor", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", "downloader", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "Triton_release"}, k=1, mv={1, 1, 16})
@Keep
public final class EnginePlatformFactory
  implements TritonPlatform.Builder.TritonPlatformFactory
{
  @NotNull
  public TritonPlatform create(@NotNull Context paramContext, @NotNull LogDelegate paramLogDelegate, @NotNull DebugConfig paramDebugConfig, @NotNull ScriptPluginFactory paramScriptPluginFactory, @NotNull EnginePackage paramEnginePackage, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NotNull Executor paramExecutor1, @NotNull Executor paramExecutor2, @NotNull Downloader paramDownloader)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramLogDelegate, "logger");
    Intrinsics.checkParameterIsNotNull(paramDebugConfig, "debugConfig");
    Intrinsics.checkParameterIsNotNull(paramScriptPluginFactory, "scriptPlugin");
    Intrinsics.checkParameterIsNotNull(paramEnginePackage, "enginePackage");
    Intrinsics.checkParameterIsNotNull(paramExecutor1, "workerExecutor");
    Intrinsics.checkParameterIsNotNull(paramExecutor2, "mainThreadExecutor");
    Intrinsics.checkParameterIsNotNull(paramDownloader, "downloader");
    return (TritonPlatform)new EnginePlatform(new PlatformConfig(paramContext, paramLogDelegate, paramScriptPluginFactory, paramDebugConfig, paramEnginePackage, paramBoolean1, paramBoolean2, paramBoolean3, paramExecutor1, paramExecutor2, paramDownloader));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.EnginePlatformFactory
 * JD-Core Version:    0.7.0.1
 */