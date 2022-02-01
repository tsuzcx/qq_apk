package com.tencent.mobileqq.cmshow.engine.model;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "", "changeListener", "Lkotlin/Function3;", "Lkotlin/reflect/KProperty;", "Lkotlin/ParameterName;", "name", "property", "oldValue", "newValue", "", "(Lkotlin/jvm/functions/Function3;)V", "<set-?>", "", "bubbleType", "getBubbleType", "()I", "setBubbleType", "(I)V", "bubbleType$delegate", "Lkotlin/properties/ReadWriteProperty;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BusinessConfig
{
  @NotNull
  private final ReadWriteProperty jdField_a_of_type_KotlinPropertiesReadWriteProperty;
  
  public BusinessConfig(@NotNull Function3<? super KProperty<?>, Object, Object, Unit> paramFunction3)
  {
    Object localObject = Delegates.INSTANCE;
    localObject = Integer.valueOf(-1);
    this.jdField_a_of_type_KotlinPropertiesReadWriteProperty = ((ReadWriteProperty)new BusinessConfig..special..inlined.observable.1(paramFunction3, localObject, localObject));
  }
  
  public final int a()
  {
    return ((Number)this.jdField_a_of_type_KotlinPropertiesReadWriteProperty.getValue(this, jdField_a_of_type_ArrayOfKotlinReflectKProperty[0])).intValue();
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_KotlinPropertiesReadWriteProperty.setValue(this, jdField_a_of_type_ArrayOfKotlinReflectKProperty[0], Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.model.BusinessConfig
 * JD-Core Version:    0.7.0.1
 */