package com.tencent.mobileqq.cmshow.crossengine.model;

import com.tencent.mobileqq.cmshow.crossengine.util.CEChannelUtil;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/model/CEArgument;", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "rawParams", "", "(Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;Ljava/lang/String;)V", "callbackId", "", "getCallbackId", "()I", "callbackId$delegate", "Lkotlin/Lazy;", "isAsync", "", "()Z", "isAsync$delegate", "moduleName", "getModuleName", "()Ljava/lang/String;", "moduleName$delegate", "callback", "", "responseCmd", "responseData", "Lorg/json/JSONObject;", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEArgument
  extends Argument
{
  public static final CEArgument.Companion a = new CEArgument.Companion(null);
  @NotNull
  private final Lazy c;
  @NotNull
  private final Lazy d;
  @NotNull
  private final Lazy e;
  private final IScriptService f;
  
  public CEArgument(@NotNull IScriptService paramIScriptService, @Nullable String paramString)
  {
    super(paramIScriptService, paramString);
    this.f = paramIScriptService;
    this.c = LazyKt.lazy((Function0)new CEArgument.moduleName.2(this));
    this.d = LazyKt.lazy((Function0)new CEArgument.callbackId.2(this));
    this.e = LazyKt.lazy((Function0)new CEArgument.isAsync.2(this));
  }
  
  @NotNull
  public final String a()
  {
    return (String)this.c.getValue();
  }
  
  @Deprecated(message="CE回调无需命令字")
  public void a(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "responseCmd");
    if (QLog.isColorLevel())
    {
      String str = String.valueOf(this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("callback for responseCmd:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("(reqCmd:");
      localStringBuilder.append(f());
      localStringBuilder.append(") with responseData:");
      localStringBuilder.append(paramString2);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.f.a(CEChannelUtil.a.a(paramString1, paramString2));
  }
  
  public final void a(@Nullable JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = String.valueOf(this);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("callback for (reqCmd:");
      ((StringBuilder)localObject2).append(f());
      ((StringBuilder)localObject2).append(") with responseData:");
      ((StringBuilder)localObject2).append(paramJSONObject);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.f;
    Object localObject2 = CEChannelUtil.a;
    int i = b();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.toString();
    } else {
      paramJSONObject = null;
    }
    ((IScriptService)localObject1).a(((CEChannelUtil)localObject2).a(String.valueOf(i), paramJSONObject));
  }
  
  public final int b()
  {
    return ((Number)this.d.getValue()).intValue();
  }
  
  public final boolean c()
  {
    return ((Boolean)this.e.getValue()).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.model.CEArgument
 * JD-Core Version:    0.7.0.1
 */