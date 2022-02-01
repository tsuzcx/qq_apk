package com.tencent.xaction.impl;

import com.tencent.xaction.api.IExpression;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.trigger.helper.CurrentState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/Expression;", "Lcom/tencent/xaction/api/IExpression;", "", "state", "Lcom/tencent/xaction/trigger/helper/CurrentState;", "(Lcom/tencent/xaction/trigger/helper/CurrentState;)V", "expsStr", "", "getState", "()Lcom/tencent/xaction/trigger/helper/CurrentState;", "setState", "compute", "()Ljava/lang/Float;", "parse", "", "setExps", "expsString", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class Expression
  implements IExpression<Float>
{
  @Nullable
  private CurrentState jdField_a_of_type_ComTencentXactionTriggerHelperCurrentState;
  private String jdField_a_of_type_JavaLangString;
  
  public Expression(@Nullable CurrentState paramCurrentState)
  {
    this.jdField_a_of_type_ComTencentXactionTriggerHelperCurrentState = paramCurrentState;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  @Nullable
  public CurrentState a()
  {
    return this.jdField_a_of_type_ComTencentXactionTriggerHelperCurrentState;
  }
  
  @NotNull
  public Float a()
  {
    if (a() == null) {
      return Float.valueOf(0.0F);
    }
    ScreenUnit.Companion localCompanion = ScreenUnit.a;
    CurrentState localCurrentState = a();
    if (localCurrentState == null) {
      Intrinsics.throwNpe();
    }
    double d = localCompanion.b(localCurrentState.getCx()) / 100;
    Double.isNaN(d);
    return Float.valueOf((float)Math.abs(Math.round(d * 1.0D) * 100));
  }
  
  public void a(@Nullable CurrentState paramCurrentState)
  {
    this.jdField_a_of_type_ComTencentXactionTriggerHelperCurrentState = paramCurrentState;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "expsString");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.Expression
 * JD-Core Version:    0.7.0.1
 */