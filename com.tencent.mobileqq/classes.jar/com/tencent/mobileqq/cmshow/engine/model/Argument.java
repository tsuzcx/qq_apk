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
  public static final Argument.Companion a;
  private final IScriptService jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService;
  @Nullable
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  @Nullable
  private final Lazy b;
  @NotNull
  private final Lazy c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowEngineModelArgument$Companion = new Argument.Companion(null);
  }
  
  public Argument(@NotNull IScriptService paramIScriptService, @Nullable String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService = paramIScriptService;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new Argument.data.2(this));
    this.b = LazyKt.lazy((Function0)new Argument.params.2(this));
    this.c = LazyKt.lazy((Function0)new Argument.cmd.2(this));
  }
  
  @NotNull
  public final JSONObject a()
  {
    return (JSONObject)this.jdField_a_of_type_KotlinLazy.getValue();
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
      localStringBuilder.append(c());
      localStringBuilder.append(") with responseData:");
      localStringBuilder.append(paramString2);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService.a(paramString1, paramString2);
  }
  
  @Nullable
  public final String b()
  {
    return (String)this.b.getValue();
  }
  
  @NotNull
  public final String c()
  {
    return (String)this.c.getValue();
  }
  
  @Nullable
  public final String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.model.Argument
 * JD-Core Version:    0.7.0.1
 */