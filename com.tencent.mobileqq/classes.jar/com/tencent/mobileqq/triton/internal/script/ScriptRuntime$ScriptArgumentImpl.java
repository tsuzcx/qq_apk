package com.tencent.mobileqq.triton.internal.script;

import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptTask;
import java.util.concurrent.locks.Lock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/ScriptRuntime$ScriptArgumentImpl;", "Lcom/tencent/mobileqq/triton/script/Argument;", "paramStr", "", "callbackId", "", "scriptObjectHandle", "(Lcom/tencent/mobileqq/triton/internal/script/ScriptRuntime;Ljava/lang/String;II)V", "getCallbackId", "()I", "contextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "getContextType", "()Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "params", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/triton/script/ScriptData;", "getParams", "()Lorg/json/JSONObject;", "params$delegate", "Lkotlin/Lazy;", "rawParams", "getRawParams", "()Ljava/lang/String;", "scriptTask", "Lcom/tencent/mobileqq/triton/script/ScriptTask;", "task", "getTask", "()Lcom/tencent/mobileqq/triton/script/ScriptTask;", "callback", "", "result", "createBuffer", "buffer", "", "offset", "", "length", "getBuffer", "bufferId", "subscribe", "eventName", "Triton_release"}, k=1, mv={1, 1, 16})
final class ScriptRuntime$ScriptArgumentImpl
  implements Argument
{
  private final int callbackId;
  @NotNull
  private final Lazy params$delegate;
  @NotNull
  private final String rawParams;
  private final ScriptTask scriptTask;
  
  public ScriptRuntime$ScriptArgumentImpl(String paramString, @NotNull int paramInt1, int paramInt2)
  {
    int i;
    if (i != 0) {
      paramString = (ScriptTask)new ScriptRuntime.ScriptTaskImpl(paramString, paramString.getType(), i);
    } else {
      paramString = null;
    }
    this.scriptTask = paramString;
    this.rawParams = paramInt1;
    this.callbackId = paramInt2;
    this.params$delegate = LazyKt.lazy((Function0)new ScriptRuntime.ScriptArgumentImpl.params.2(paramInt1));
  }
  
  public boolean callback(@Nullable String paramString)
  {
    return this.this$0.callback2Script(getCallbackId(), paramString);
  }
  
  public int createBuffer(@NotNull byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "buffer");
    EngineContext localEngineContext = ScriptRuntime.access$getEngineContext$p(this.this$0);
    Lock localLock = (Lock)localEngineContext.getLock();
    localLock.lock();
    try
    {
      if (localEngineContext.isAlive())
      {
        int i = ScriptRuntime.access$getNativeBufferManager$p(this.this$0).createBuffer(paramArrayOfByte, paramLong1, paramLong2);
        return i;
      }
      return 0;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @Nullable
  public byte[] getBuffer(int paramInt)
  {
    Object localObject1 = ScriptRuntime.access$getEngineContext$p(this.this$0);
    Lock localLock = (Lock)((EngineContext)localObject1).getLock();
    localLock.lock();
    try
    {
      if (((EngineContext)localObject1).isAlive())
      {
        localObject1 = ScriptRuntime.access$getNativeBufferManager$p(this.this$0).getBuffer(paramInt);
        return localObject1;
      }
      return null;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public int getCallbackId()
  {
    return this.callbackId;
  }
  
  @NotNull
  public ScriptContextType getContextType()
  {
    return this.this$0.getType();
  }
  
  @NotNull
  public JSONObject getParams()
  {
    return (JSONObject)this.params$delegate.getValue();
  }
  
  @NotNull
  public String getRawParams()
  {
    return this.rawParams;
  }
  
  @Nullable
  public ScriptTask getTask()
  {
    return this.scriptTask;
  }
  
  public boolean subscribe(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "eventName");
    return this.this$0.subscribe2Script(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.ScriptRuntime.ScriptArgumentImpl
 * JD-Core Version:    0.7.0.1
 */