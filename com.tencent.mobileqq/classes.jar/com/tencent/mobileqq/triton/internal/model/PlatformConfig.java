package com.tencent.mobileqq.triton.internal.model;

import android.content.Context;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;", "", "context", "Landroid/content/Context;", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "scriptPluginFactory", "Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "debugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "enableCodeCache", "", "enableOpenGlEs3", "enablePreloadEngine", "workerExecutor", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", "downloader", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "(Landroid/content/Context;Lcom/tencent/mobileqq/triton/utils/LogDelegate;Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;Lcom/tencent/mobileqq/triton/model/DebugConfig;Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;ZZZLjava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/tencent/mobileqq/triton/utils/Downloader;)V", "getContext", "()Landroid/content/Context;", "getDebugConfig", "()Lcom/tencent/mobileqq/triton/model/DebugConfig;", "getDownloader", "()Lcom/tencent/mobileqq/triton/utils/Downloader;", "getEnableCodeCache", "()Z", "getEnableOpenGlEs3", "getEnablePreloadEngine", "getEnginePackage", "()Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "getLogger", "()Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "getMainThreadExecutor", "()Ljava/util/concurrent/Executor;", "getScriptPluginFactory", "()Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "getWorkerExecutor", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class PlatformConfig
{
  @NotNull
  private final Context context;
  @NotNull
  private final DebugConfig debugConfig;
  @NotNull
  private final Downloader downloader;
  private final boolean enableCodeCache;
  private final boolean enableOpenGlEs3;
  private final boolean enablePreloadEngine;
  @NotNull
  private final EnginePackage enginePackage;
  @NotNull
  private final LogDelegate logger;
  @NotNull
  private final Executor mainThreadExecutor;
  @NotNull
  private final ScriptPluginFactory scriptPluginFactory;
  @NotNull
  private final Executor workerExecutor;
  
  public PlatformConfig(@NotNull Context paramContext, @NotNull LogDelegate paramLogDelegate, @NotNull ScriptPluginFactory paramScriptPluginFactory, @NotNull DebugConfig paramDebugConfig, @NotNull EnginePackage paramEnginePackage, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NotNull Executor paramExecutor1, @NotNull Executor paramExecutor2, @NotNull Downloader paramDownloader)
  {
    this.context = paramContext;
    this.logger = paramLogDelegate;
    this.scriptPluginFactory = paramScriptPluginFactory;
    this.debugConfig = paramDebugConfig;
    this.enginePackage = paramEnginePackage;
    this.enableCodeCache = paramBoolean1;
    this.enableOpenGlEs3 = paramBoolean2;
    this.enablePreloadEngine = paramBoolean3;
    this.workerExecutor = paramExecutor1;
    this.mainThreadExecutor = paramExecutor2;
    this.downloader = paramDownloader;
  }
  
  @NotNull
  public final Context component1()
  {
    return this.context;
  }
  
  @NotNull
  public final Executor component10()
  {
    return this.mainThreadExecutor;
  }
  
  @NotNull
  public final Downloader component11()
  {
    return this.downloader;
  }
  
  @NotNull
  public final LogDelegate component2()
  {
    return this.logger;
  }
  
  @NotNull
  public final ScriptPluginFactory component3()
  {
    return this.scriptPluginFactory;
  }
  
  @NotNull
  public final DebugConfig component4()
  {
    return this.debugConfig;
  }
  
  @NotNull
  public final EnginePackage component5()
  {
    return this.enginePackage;
  }
  
  public final boolean component6()
  {
    return this.enableCodeCache;
  }
  
  public final boolean component7()
  {
    return this.enableOpenGlEs3;
  }
  
  public final boolean component8()
  {
    return this.enablePreloadEngine;
  }
  
  @NotNull
  public final Executor component9()
  {
    return this.workerExecutor;
  }
  
  @NotNull
  public final PlatformConfig copy(@NotNull Context paramContext, @NotNull LogDelegate paramLogDelegate, @NotNull ScriptPluginFactory paramScriptPluginFactory, @NotNull DebugConfig paramDebugConfig, @NotNull EnginePackage paramEnginePackage, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NotNull Executor paramExecutor1, @NotNull Executor paramExecutor2, @NotNull Downloader paramDownloader)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramLogDelegate, "logger");
    Intrinsics.checkParameterIsNotNull(paramScriptPluginFactory, "scriptPluginFactory");
    Intrinsics.checkParameterIsNotNull(paramDebugConfig, "debugConfig");
    Intrinsics.checkParameterIsNotNull(paramEnginePackage, "enginePackage");
    Intrinsics.checkParameterIsNotNull(paramExecutor1, "workerExecutor");
    Intrinsics.checkParameterIsNotNull(paramExecutor2, "mainThreadExecutor");
    Intrinsics.checkParameterIsNotNull(paramDownloader, "downloader");
    return new PlatformConfig(paramContext, paramLogDelegate, paramScriptPluginFactory, paramDebugConfig, paramEnginePackage, paramBoolean1, paramBoolean2, paramBoolean3, paramExecutor1, paramExecutor2, paramDownloader);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof PlatformConfig))
      {
        paramObject = (PlatformConfig)paramObject;
        if ((!Intrinsics.areEqual(this.context, paramObject.context)) || (!Intrinsics.areEqual(this.logger, paramObject.logger)) || (!Intrinsics.areEqual(this.scriptPluginFactory, paramObject.scriptPluginFactory)) || (!Intrinsics.areEqual(this.debugConfig, paramObject.debugConfig)) || (!Intrinsics.areEqual(this.enginePackage, paramObject.enginePackage)) || (this.enableCodeCache != paramObject.enableCodeCache) || (this.enableOpenGlEs3 != paramObject.enableOpenGlEs3) || (this.enablePreloadEngine != paramObject.enablePreloadEngine) || (!Intrinsics.areEqual(this.workerExecutor, paramObject.workerExecutor)) || (!Intrinsics.areEqual(this.mainThreadExecutor, paramObject.mainThreadExecutor)) || (!Intrinsics.areEqual(this.downloader, paramObject.downloader))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final Context getContext()
  {
    return this.context;
  }
  
  @NotNull
  public final DebugConfig getDebugConfig()
  {
    return this.debugConfig;
  }
  
  @NotNull
  public final Downloader getDownloader()
  {
    return this.downloader;
  }
  
  public final boolean getEnableCodeCache()
  {
    return this.enableCodeCache;
  }
  
  public final boolean getEnableOpenGlEs3()
  {
    return this.enableOpenGlEs3;
  }
  
  public final boolean getEnablePreloadEngine()
  {
    return this.enablePreloadEngine;
  }
  
  @NotNull
  public final EnginePackage getEnginePackage()
  {
    return this.enginePackage;
  }
  
  @NotNull
  public final LogDelegate getLogger()
  {
    return this.logger;
  }
  
  @NotNull
  public final Executor getMainThreadExecutor()
  {
    return this.mainThreadExecutor;
  }
  
  @NotNull
  public final ScriptPluginFactory getScriptPluginFactory()
  {
    return this.scriptPluginFactory;
  }
  
  @NotNull
  public final Executor getWorkerExecutor()
  {
    return this.workerExecutor;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    return "PlatformConfig(context=" + this.context + ", logger=" + this.logger + ", scriptPluginFactory=" + this.scriptPluginFactory + ", debugConfig=" + this.debugConfig + ", enginePackage=" + this.enginePackage + ", enableCodeCache=" + this.enableCodeCache + ", enableOpenGlEs3=" + this.enableOpenGlEs3 + ", enablePreloadEngine=" + this.enablePreloadEngine + ", workerExecutor=" + this.workerExecutor + ", mainThreadExecutor=" + this.mainThreadExecutor + ", downloader=" + this.downloader + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.model.PlatformConfig
 * JD-Core Version:    0.7.0.1
 */