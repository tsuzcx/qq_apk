package com.tencent.mobileqq.cmshow.engine.model;

import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "rawData", "", "(Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;Ljava/lang/String;)V", "cmd", "getCmd", "()Ljava/lang/String;", "cmd$delegate", "Lkotlin/Lazy;", "data", "Lorg/json/JSONObject;", "getData$cmshow_impl_release", "()Lorg/json/JSONObject;", "data$delegate", "params", "getParams", "params$delegate", "getRawData", "callback", "", "responseCmd", "responseData", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public class Argument
{
  public static final Argument.Companion b = new Argument.Companion(null);
  @NotNull
  private final Lazy a;
  @Nullable
  private final Lazy c;
  @NotNull
  private final Lazy d;
  private final IScriptService e;
  @Nullable
  private final String f;
  
  public Argument(@NotNull IScriptService paramIScriptService, @Nullable String paramString)
  {
    this.e = paramIScriptService;
    this.f = paramString;
    this.a = LazyKt.lazy((Function0)new Argument.data.2(this));
    this.c = LazyKt.lazy((Function0)new Argument.params.2(this));
    this.d = LazyKt.lazy((Function0)new Argument.cmd.2(this));
  }
  
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
    this.e.a(paramString1, paramString2);
  }
  
  @NotNull
  public final JSONObject d()
  {
    return (JSONObject)this.a.getValue();
  }
  
  @Nullable
  public final String e()
  {
    return (String)this.c.getValue();
  }
  
  @NotNull
  public final String f()
  {
    return (String)this.d.getValue();
  }
  
  @Nullable
  public final String g()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.model.Argument
 * JD-Core Version:    0.7.0.1
 */