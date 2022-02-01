package com.tencent.mobileqq.triton.internal.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.GamePluginPackage;
import com.tencent.mobileqq.triton.filesystem.ScriptPackage;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.script.ScriptFile.Content;
import com.tencent.mobileqq.triton.script.ScriptFile.Path;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"initAssertNotNullptr", "", "pointer", "", "name", "", "jniCall", "T", "call", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "nanoTime", "timeStamp", "decorate", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "enableCodeCache", "", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "com/tencent/mobileqq/triton/internal/utils/Utils$decorate$3", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "(Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;Z)Lcom/tencent/mobileqq/triton/internal/utils/Utils$decorate$3;", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "prefix", "decorateSubPackage", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "subPackageName", "onError", "Lcom/tencent/mobileqq/triton/statistic/ErrorCallback;", "exception", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "toTritonException", "", "error", "Lcom/tencent/mobileqq/triton/exception/ErrorCodes;", "Triton_release"}, k=2, mv={1, 1, 16})
@JvmName(name="Utils")
public final class Utils
{
  @NotNull
  public static final EnginePackage decorate(@NotNull EnginePackage paramEnginePackage, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramEnginePackage, "$this$decorate");
    return (EnginePackage)new Utils.decorate.1(paramEnginePackage, paramBoolean);
  }
  
  @NotNull
  public static final GamePackage decorate(@NotNull GamePackage paramGamePackage, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramGamePackage, "$this$decorate");
    return (GamePackage)new Utils.decorate.2(paramGamePackage, paramBoolean);
  }
  
  private static final Utils.decorate.3 decorate(@NotNull GamePluginPackage paramGamePluginPackage, boolean paramBoolean)
  {
    return new Utils.decorate.3(paramGamePluginPackage, paramBoolean);
  }
  
  private static final ScriptFile decorate(@NotNull ScriptFile paramScriptFile, boolean paramBoolean, String paramString1, String paramString2)
  {
    boolean bool = paramScriptFile instanceof ScriptFile.Path;
    ScriptFile.Path localPath = null;
    ScriptFile.Content localContent = null;
    if (bool)
    {
      localPath = (ScriptFile.Path)paramScriptFile;
      paramScriptFile = new StringBuilder();
      paramScriptFile.append(paramString1);
      paramScriptFile.append(paramString2);
      paramString1 = paramScriptFile.toString();
      paramScriptFile = localContent;
      if (paramBoolean) {
        paramScriptFile = localPath.getCodeCache();
      }
      return (ScriptFile)ScriptFile.Path.copy$default(localPath, paramString1, null, paramScriptFile, 2, null);
    }
    if (paramScriptFile != null)
    {
      localContent = (ScriptFile.Content)paramScriptFile;
      paramScriptFile = new StringBuilder();
      paramScriptFile.append(paramString1);
      paramScriptFile.append(paramString2);
      paramString1 = paramScriptFile.toString();
      paramScriptFile = localPath;
      if (paramBoolean) {
        paramScriptFile = localContent.getCodeCache();
      }
      return (ScriptFile)ScriptFile.Content.copy$default(localContent, paramString1, null, paramScriptFile, 2, null);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.triton.script.ScriptFile.Content");
  }
  
  @NotNull
  public static final ScriptPackage decorateSubPackage(@NotNull ScriptPackage paramScriptPackage, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptPackage, "$this$decorateSubPackage");
    Intrinsics.checkParameterIsNotNull(paramString, "subPackageName");
    return (ScriptPackage)new Utils.decorateSubPackage.1(paramScriptPackage, paramBoolean, paramString);
  }
  
  public static final void initAssertNotNullptr(long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    if (paramLong != 0L) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pointer ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is nullptr");
    throw ((Throwable)new TritonInitException(localStringBuilder.toString(), ErrorCodes.NATIVE_FUNCTION_CALL, null, 4, null));
  }
  
  public static final <T> T jniCall(@NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "call");
    try
    {
      Object localObject = paramFunction0.invoke();
      return localObject;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label15:
      break label15;
    }
    return paramFunction0.invoke();
  }
  
  public static final long nanoTime()
  {
    return System.nanoTime();
  }
  
  public static final void onError(@NotNull ErrorCallback paramErrorCallback, @NotNull TritonException paramTritonException)
  {
    Intrinsics.checkParameterIsNotNull(paramErrorCallback, "$this$onError");
    Intrinsics.checkParameterIsNotNull(paramTritonException, "exception");
    paramErrorCallback.onError(paramTritonException.getMessage(), paramTritonException);
  }
  
  public static final long timeStamp()
  {
    return SystemClock.uptimeMillis();
  }
  
  @NotNull
  public static final TritonException toTritonException(@NotNull Throwable paramThrowable, @NotNull ErrorCodes paramErrorCodes)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "$this$toTritonException");
    Intrinsics.checkParameterIsNotNull(paramErrorCodes, "error");
    if ((paramThrowable instanceof TritonException)) {
      return (TritonException)paramThrowable;
    }
    String str = paramThrowable.getMessage();
    if (str == null) {
      str = "";
    }
    return new TritonException(str, paramErrorCodes, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.utils.Utils
 * JD-Core Version:    0.7.0.1
 */