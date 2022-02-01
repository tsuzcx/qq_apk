package com.tencent.mobileqq.cmshow.engine.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class BusinessConfig$$special$$inlined$observable$1
  extends ObservableProperty<Integer>
{
  public BusinessConfig$$special$$inlined$observable$1(Function3 paramFunction3, Object paramObject1, Object paramObject2)
  {
    super(paramObject2);
  }
  
  protected void afterChange(@NotNull KProperty<?> paramKProperty, Integer paramInteger1, Integer paramInteger2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    this.jdField_a_of_type_KotlinJvmFunctionsFunction3.invoke(paramKProperty, paramInteger1, paramInteger2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.model.BusinessConfig..special..inlined.observable.1
 * JD-Core Version:    0.7.0.1
 */