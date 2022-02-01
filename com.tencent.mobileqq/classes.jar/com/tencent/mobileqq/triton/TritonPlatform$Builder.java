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
    if (paramObject != null) {
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append(paramString);
    paramObject.append(" is not set");
    throw ((Throwable)new TritonInitException(paramObject.toString(), null, null, 6, null));
  }
  
  private final TritonPlatform performBuild()
  {
    Object localObject = this.debugConfig;
    if (localObject == null) {
      localObject = new DebugConfig(false, 0L, 0L, 0, 0, 31, null);
    }
    this.debugConfig = ((DebugConfig)localObject);
    if (this.context != null)
    {
      if (this.logger != null)
      {
        if (this.scriptPluginFactory != null)
        {
          localObject = this.enginePackage;
          if (localObject != null)
          {
            boolean bool1 = this.enableCodeCache;
            if (this.workerExecutor != null)
            {
              if (this.mainThreadExecutor != null)
              {
                if (this.downloader != null)
                {
                  Context localContext;
                  if (localObject != null)
                  {
                    localObject = ((EnginePackage)localObject).getEngineJar();
                    if (localObject != null)
                    {
                      localContext = this.context;
                      if (localContext == null) {
                        Intrinsics.throwNpe();
                      }
                      localObject = (ClassLoader)new TritonPlatform.Builder.TritonClassLoader((File)localObject, localContext);
                      break label154;
                    }
                  }
                  localObject = TritonPlatform.class.getClassLoader();
                  try
                  {
                    label154:
                    localObject = ((ClassLoader)localObject).loadClass("com.tencent.mobileqq.triton.internal.engine.EnginePlatformFactory").newInstance();
                    if (localObject != null)
                    {
                      localObject = (TritonPlatform.Builder.TritonPlatformFactory)localObject;
                      localContext = this.context;
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
                      return ((TritonPlatform.Builder.TritonPlatformFactory)localObject).create(localContext, localLogDelegate, localDebugConfig, localScriptPluginFactory, localEnginePackage, bool1, bool2, bool3, localExecutor1, localExecutor2, localDownloader);
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.triton.TritonPlatform.Builder.TritonPlatformFactory");
                  }
                  catch (Throwable localThrowable)
                  {
                    throw ((Throwable)new TritonInitException("failed to create TritonEngine", ErrorCodes.UNKNOWN, localThrowable));
                  }
                }
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("downloader");
                localStringBuilder.append(" is not set");
                throw ((Throwable)new TritonInitException(localStringBuilder.toString(), null, null, 6, null));
              }
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("mainThreadExecutor");
              localStringBuilder.append(" is not set");
              throw ((Throwable)new TritonInitException(localStringBuilder.toString(), null, null, 6, null));
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("workerExecutor");
            localStringBuilder.append(" is not set");
            throw ((Throwable)new TritonInitException(localStringBuilder.toString(), null, null, 6, null));
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("enginePackage");
          localStringBuilder.append(" is not set");
          throw ((Throwable)new TritonInitException(localStringBuilder.toString(), null, null, 6, null));
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("scriptPluginFactory");
        localStringBuilder.append(" is not set");
        throw ((Throwable)new TritonInitException(localStringBuilder.toString(), null, null, 6, null));
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("logger");
      localStringBuilder.append(" is not set");
      throw ((Throwable)new TritonInitException(localStringBuilder.toString(), null, null, 6, null));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("context");
    localStringBuilder.append(" is not set");
    throw ((Throwable)new TritonInitException(localStringBuilder.toString(), null, null, 6, null));
  }
  
  @NotNull
  public final TritonPlatform build()
  {
    Lock localLock = (Lock)buildLock;
    localLock.lock();
    try
    {
      TritonPlatform localTritonPlatform = previouslyBuiltPlatform;
      if (localTritonPlatform != null)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("TritonPlatform is singleton, can't build twice. Previously built one is [");
        ((StringBuilder)localObject2).append(localTritonPlatform);
        ((StringBuilder)localObject2).append(']');
        localObject2 = ((StringBuilder)localObject2).toString();
        Throwable localThrowable = previouslyBuildingStackTrace;
        if (localThrowable == null) {
          Intrinsics.throwNpe();
        }
        throw ((Throwable)new TritonPlatformInitTwiceException((String)localObject2, localTritonPlatform, localThrowable));
      }
      localTritonPlatform = performBuild();
      previouslyBuiltPlatform = localTritonPlatform;
      previouslyBuildingStackTrace = new Throwable("previously building stacktrace");
      return localTritonPlatform;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @NotNull
  public final Builder context(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Builder localBuilder = (Builder)this;
    localBuilder.context = paramContext.getApplicationContext();
    return localBuilder;
  }
  
  @NotNull
  public final Builder debugConfig(@NotNull DebugConfig paramDebugConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDebugConfig, "debugConfig");
    Builder localBuilder = (Builder)this;
    localBuilder.debugConfig = paramDebugConfig;
    return localBuilder;
  }
  
  @NotNull
  public final Builder downloader(@NotNull Downloader paramDownloader)
  {
    Intrinsics.checkParameterIsNotNull(paramDownloader, "downloader");
    Builder localBuilder = (Builder)this;
    localBuilder.downloader = paramDownloader;
    return localBuilder;
  }
  
  @NotNull
  public final Builder enableCodeCache(boolean paramBoolean)
  {
    Builder localBuilder = (Builder)this;
    localBuilder.enableCodeCache = paramBoolean;
    return localBuilder;
  }
  
  @NotNull
  public final Builder enableOpenGlEs3(boolean paramBoolean)
  {
    Builder localBuilder = (Builder)this;
    localBuilder.enableOpenGlEs3 = paramBoolean;
    return localBuilder;
  }
  
  @NotNull
  public final Builder enablePreloadEngine(boolean paramBoolean)
  {
    Builder localBuilder = (Builder)this;
    localBuilder.preloadEngine = paramBoolean;
    return localBuilder;
  }
  
  @NotNull
  public final Builder enginePackage(@NotNull EnginePackage paramEnginePackage)
  {
    Intrinsics.checkParameterIsNotNull(paramEnginePackage, "enginePackage");
    Builder localBuilder = (Builder)this;
    localBuilder.enginePackage = paramEnginePackage;
    return localBuilder;
  }
  
  @NotNull
  public final Builder logger(@NotNull LogDelegate paramLogDelegate)
  {
    Intrinsics.checkParameterIsNotNull(paramLogDelegate, "logger");
    Builder localBuilder = (Builder)this;
    localBuilder.logger = paramLogDelegate;
    return localBuilder;
  }
  
  @NotNull
  public final Builder mainThreadExecutor(@NotNull Executor paramExecutor)
  {
    Intrinsics.checkParameterIsNotNull(paramExecutor, "mainThreadExecutor");
    Builder localBuilder = (Builder)this;
    localBuilder.mainThreadExecutor = paramExecutor;
    return localBuilder;
  }
  
  @NotNull
  public final Builder scriptPluginFactory(@NotNull ScriptPluginFactory paramScriptPluginFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptPluginFactory, "scriptPluginFactory");
    Builder localBuilder = (Builder)this;
    localBuilder.scriptPluginFactory = paramScriptPluginFactory;
    return localBuilder;
  }
  
  @NotNull
  public final Builder workerExecutor(@NotNull Executor paramExecutor)
  {
    Intrinsics.checkParameterIsNotNull(paramExecutor, "workerExecutor");
    Builder localBuilder = (Builder)this;
    localBuilder.workerExecutor = paramExecutor;
    return localBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.TritonPlatform.Builder
 * JD-Core Version:    0.7.0.1
 */