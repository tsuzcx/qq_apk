package com.tencent.mobileqq.triton.internal.script;

import android.util.SparseArray;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/ScriptRuntime$ScriptTaskImpl;", "Lcom/tencent/mobileqq/triton/script/ScriptTask;", "contextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "scriptObjectHandle", "", "(Lcom/tencent/mobileqq/triton/internal/script/ScriptRuntime;Lcom/tencent/mobileqq/triton/script/ScriptContextType;I)V", "getContextType", "()Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "getScriptObjectHandle", "()I", "associate", "", "obj", "", "callMethod", "", "methodName", "", "arguments", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/triton/script/ScriptData;", "destroy", "getAssociation", "T", "()Ljava/lang/Object;", "Triton_release"}, k=1, mv={1, 1, 16})
final class ScriptRuntime$ScriptTaskImpl
  implements ScriptTask
{
  @NotNull
  private final ScriptContextType contextType;
  private final int scriptObjectHandle;
  
  public ScriptRuntime$ScriptTaskImpl(ScriptContextType paramScriptContextType, @NotNull int paramInt)
  {
    this.contextType = paramInt;
    int i;
    this.scriptObjectHandle = i;
  }
  
  public void associate(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    synchronized (ScriptRuntime.access$getScriptTaskAssociation$p(this.this$0))
    {
      ScriptRuntime.access$getScriptTaskAssociation$p(this.this$0).put(this.scriptObjectHandle, paramObject);
      paramObject = Unit.INSTANCE;
      return;
    }
  }
  
  public boolean callMethod(@NotNull String paramString, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "methodName");
    ScriptRuntime localScriptRuntime = this.this$0;
    int i = this.scriptObjectHandle;
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = null) {
      return ScriptRuntime.access$callScriptMethod(localScriptRuntime, i, paramString, paramJSONObject);
    }
  }
  
  public void destroy()
  {
    synchronized (ScriptRuntime.access$getScriptTaskAssociation$p(this.this$0))
    {
      ScriptRuntime.access$getScriptTaskAssociation$p(this.this$0).remove(this.scriptObjectHandle);
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
  
  public <T> T getAssociation()
  {
    synchronized (ScriptRuntime.access$getScriptTaskAssociation$p(this.this$0))
    {
      Object localObject1 = ScriptRuntime.access$getScriptTaskAssociation$p(this.this$0).get(this.scriptObjectHandle);
      if (localObject1 != null) {
        return localObject1;
      }
      throw ((Throwable)new IllegalStateException("no association"));
    }
  }
  
  @NotNull
  public ScriptContextType getContextType()
  {
    return this.contextType;
  }
  
  public final int getScriptObjectHandle()
  {
    return this.scriptObjectHandle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.ScriptRuntime.ScriptTaskImpl
 * JD-Core Version:    0.7.0.1
 */