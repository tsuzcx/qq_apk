package com.tencent.mobileqq.triton;

import android.content.Context;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.exception.TritonPlatformInitTwiceException;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;", "", "()V", "context", "Landroid/content/Context;", "debugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "downloader", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "enableCodeCache", "", "enableOpenGlEs3", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "mainThreadExecutor", "Ljava/util/concurrent/Executor;", "preloadEngine", "scriptPluginFactory", "Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "workerExecutor", "build", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "checkNonNull", "", "value", "name", "", "enablePreloadEngine", "performBuild", "Companion", "TritonClassLoader", "TritonPlatformFactory", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class TritonPlatform$Builder
{
  public static final TritonPlatform.Builder.Companion Companion = new TritonPlatform.Builder.Companion(null);
  private static final String TRITON_PLATFORM_FACTORY_IMPL_CLASS_NAME = "com.tencent.mobileqq.triton.internal.engine.EnginePlatformFactory";
  private static final ReentrantLock buildLock = new ReentrantLock();
  private static Throwable previouslyBuildingStackTrace;
  private static TritonPlatform previouslyBuiltPlatform;
  private Context context;
  private DebugConfig debugConfig;
  private Downloader downloader;
  private boolean enableCodeCache = true;
  private boolean enableOpenGlEs3 = true;
  private EnginePackage enginePackage;
  private LogDelegate logger;
  private Executor mainThreadExecutor;
  private boolean preloadEngine = true;
  private ScriptPluginFactory scriptPluginFactory;
  private Executor workerExecutor;
  
  private final void checkNonNull(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw ((Throwable)new TritonInitException(paramString + " is not set", null, null, 6, null));
    }
  }
  
  private final TritonPlatform performBuild()
  {
    Object localObject1 = this.debugConfig;
    if (localObject1 != null) {}
    for (;;)
    {
      this.debugConfig = ((DebugConfig)localObject1);
      if (this.context != null) {
        break;
      }
      throw ((Throwable)new TritonInitException("context" + " is not set", null, null, 6, null));
      localObject1 = new DebugConfig(false, 0L, 0L, 0, 0, 31, null);
    }
    if (this.logger == null) {
      throw ((Throwable)new TritonInitException("logger" + " is not set", null, null, 6, null));
    }
    if (this.scriptPluginFactory == null) {
      throw ((Throwable)new TritonInitException("scriptPluginFactory" + " is not set", null, null, 6, null));
    }
    if (this.enginePackage == null) {
      throw ((Throwable)new TritonInitException("enginePackage" + " is not set", null, null, 6, null));
    }
    boolean bool1 = this.enableCodeCache;
    if (this.workerExecutor == null) {
      throw ((Throwable)new TritonInitException("workerExecutor" + " is not set", null, null, 6, null));
    }
    if (this.mainThreadExecutor == null) {
      throw ((Throwable)new TritonInitException("mainThreadExecutor" + " is not set", null, null, 6, null));
    }
    if (this.downloader == null) {
      throw ((Throwable)new TritonInitException("downloader" + " is not set", null, null, 6, null));
    }
    localObject1 = this.enginePackage;
    if (localObject1 != null)
    {
      localObject1 = ((EnginePackage)localObject1).getEngineJar();
      if (localObject1 != null)
      {
        localContext = this.context;
        if (localContext == null) {
          Intrinsics.throwNpe();
        }
      }
    }
    for (localObject1 = (ClassLoader)new TritonPlatform.Builder.TritonClassLoader((File)localObject1, localContext);; localObject2 = TritonPlatform.class.getClassLoader()) {
      try
      {
        localObject1 = ((ClassLoader)localObject1).loadClass("com.tencent.mobileqq.triton.internal.engine.EnginePlatformFactory").newInstance();
        if (localObject1 != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.triton.TritonPlatform.Builder.TritonPlatformFactory");
      }
      catch (Throwable localThrowable)
      {
        throw ((Throwable)new TritonInitException("failed to create TritonEngine", ErrorCodes.UNKNOWN, localThrowable));
      }
    }
    Object localObject2 = (TritonPlatform.Builder.TritonPlatformFactory)localObject2;
    Context localContext = this.context;
    if (localContext == null) {
      Intrinsics.throwNpe();
    }
    LogDelegate localLogDelegate = this.logger;
    if (localLogDelegate == null) {
      Intrinsics.throwNpe();
    }
    DebugConfig localDebugConfig = this.debugConfig;
    if (localDebugConfig == null) {
      Intrinsics.throwNpe();
    }
    ScriptPluginFactory localScriptPluginFactory = this.scriptPluginFactory;
    if (localScriptPluginFactory == null) {
      Intrinsics.throwNpe();
    }
    EnginePackage localEnginePackage = this.enginePackage;
    if (localEnginePackage == null) {
      Intrinsics.throwNpe();
    }
    bool1 = this.enableCodeCache;
    boolean bool2 = this.enableOpenGlEs3;
    boolean bool3 = this.preloadEngine;
    Executor localExecutor1 = this.workerExecutor;
    if (localExecutor1 == null) {
      Intrinsics.throwNpe();
    }
    Executor localExecutor2 = this.mainThreadExecutor;
    if (localExecutor2 == null) {
      Intrinsics.throwNpe();
    }
    Downloader localDownloader = this.downloader;
    if (localDownloader == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((TritonPlatform.Builder.TritonPlatformFactory)localObject2).create(localContext, localLogDelegate, localDebugConfig, localScriptPluginFactory, localEnginePackage, bool1, bool2, bool3, localExecutor1, localExecutor2, localDownloader);
    return localObject2;
  }
  
  @NotNull
  public final TritonPlatform build()
  {
    Lock localLock = (Lock)buildLock;
    localLock.lock();
    try
    {
      TritonPlatform localTritonPlatform1 = previouslyBuiltPlatform;
      if (localTritonPlatform1 != null)
      {
        String str = "TritonPlatform is singleton, can't build twice. Previously built one is [" + localTritonPlatform1 + ']';
        Throwable localThrowable = previouslyBuildingStackTrace;
        if (localThrowable == null) {
          Intrinsics.throwNpe();
        }
        throw ((Throwable)new TritonPlatformInitTwiceException(str, localTritonPlatform1, localThrowable));
      }
    }
    finally
    {
      localLock.unlock();
    }
    TritonPlatform localTritonPlatform2 = performBuild();
    previouslyBuiltPlatform = localTritonPlatform2;
    previouslyBuildingStackTrace = new Throwable("previously building stacktrace");
    localLock.unlock();
    return localTritonPlatform2;
  }
  
  @NotNull
  public final Builder context(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    ((Builder)this).context = paramContext.getApplicationContext();
    return (Builder)this;
  }
  
  @NotNull
  public final Builder debugConfig(@NotNull DebugConfig paramDebugConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDebugConfig, "debugConfig");
    ((Builder)this).debugConfig = paramDebugConfig;
    return (Builder)this;
  }
  
  @NotNull
  public final Builder downloader(@NotNull Downloader paramDownloader)
  {
    Intrinsics.checkParameterIsNotNull(paramDownloader, "downloader");
    ((Builder)this).downloader = paramDownloader;
    return (Builder)this;
  }
  
  @NotNull
  public final Builder enableCodeCache(boolean paramBoolean)
  {
    ((Builder)this).enableCodeCache = paramBoolean;
    return (Builder)this;
  }
  
  @NotNull
  public final Builder enableOpenGlEs3(boolean paramBoolean)
  {
    ((Builder)this).enableOpenGlEs3 = paramBoolean;
    return (Builder)this;
  }
  
  @NotNull
  public final Builder enablePreloadEngine(boolean paramBoolean)
  {
    ((Builder)this).preloadEngine = paramBoolean;
    return (Builder)this;
  }
  
  @NotNull
  public final Builder enginePackage(@NotNull EnginePackage paramEnginePackage)
  {
    Intrinsics.checkParameterIsNotNull(paramEnginePackage, "enginePackage");
    ((Builder)this).enginePackage = paramEnginePackage;
    return (Builder)this;
  }
  
  @NotNull
  public final Builder logger(@NotNull LogDelegate paramLogDelegate)
  {
    Intrinsics.checkParameterIsNotNull(paramLogDelegate, "logger");
    ((Builder)this).logger = paramLogDelegate;
    return (Builder)this;
  }
  
  @NotNull
  public final Builder mainThreadExecutor(@NotNull Executor paramExecutor)
  {
    Intrinsics.checkParameterIsNotNull(paramExecutor, "mainThreadExecutor");
    ((Builder)this).mainThreadExecutor = paramExecutor;
    return (Builder)this;
  }
  
  @NotNull
  public final Builder scriptPluginFactory(@NotNull ScriptPluginFactory paramScriptPluginFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptPluginFactory, "scriptPluginFactory");
    ((Builder)this).scriptPluginFactory = paramScriptPluginFactory;
    return (Builder)this;
  }
  
  @NotNull
  public final Builder workerExecutor(@NotNull Executor paramExecutor)
  {
    Intrinsics.checkParameterIsNotNull(paramExecutor, "workerExecutor");
    ((Builder)this).workerExecutor = paramExecutor;
    return (Builder)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.TritonPlatform.Builder
 * JD-Core Version:    0.7.0.1
 */