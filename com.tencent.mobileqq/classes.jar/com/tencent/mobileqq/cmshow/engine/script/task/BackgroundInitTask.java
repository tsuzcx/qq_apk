package com.tencent.mobileqq.cmshow.engine.script.task;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/task/BackgroundInitTask;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;", "()V", "apolloId", "", "getApolloId$cmshow_impl_release", "()Ljava/lang/String;", "setApolloId$cmshow_impl_release", "(Ljava/lang/String;)V", "roleId", "", "getRoleId$cmshow_impl_release", "()I", "setRoleId$cmshow_impl_release", "(I)V", "roleType", "getRoleType$cmshow_impl_release", "setRoleType$cmshow_impl_release", "scale", "", "getScale$cmshow_impl_release", "()F", "setScale$cmshow_impl_release", "(F)V", "xPosition", "getXPosition$cmshow_impl_release", "setXPosition$cmshow_impl_release", "yPosition", "getYPosition$cmshow_impl_release", "setYPosition$cmshow_impl_release", "setApolloId", "setPosition", "x", "y", "setRoleId", "setRoleType", "setScale", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract class BackgroundInitTask
  extends AbsScriptTask
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 1;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float c;
  
  public final float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  @NotNull
  public final BackgroundInitTask a(float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Float = paramFloat1;
    this.c = paramFloat2;
    return this;
  }
  
  @NotNull
  public final BackgroundInitTask a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public final float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public final float c()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @Nullable
  public final String e()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.task.BackgroundInitTask
 * JD-Core Version:    0.7.0.1
 */