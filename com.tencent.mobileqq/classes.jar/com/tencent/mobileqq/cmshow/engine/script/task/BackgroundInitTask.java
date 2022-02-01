package com.tencent.mobileqq.cmshow.engine.script.task;

import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/task/BackgroundInitTask;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;", "apolloResManager", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;", "(Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;)V", "apolloId", "", "getApolloId$cmshow_impl_release", "()Ljava/lang/String;", "setApolloId$cmshow_impl_release", "(Ljava/lang/String;)V", "roleId", "", "getRoleId$cmshow_impl_release", "()I", "setRoleId$cmshow_impl_release", "(I)V", "roleType", "getRoleType$cmshow_impl_release", "setRoleType$cmshow_impl_release", "scale", "", "getScale$cmshow_impl_release", "()F", "setScale$cmshow_impl_release", "(F)V", "xPosition", "getXPosition$cmshow_impl_release", "setXPosition$cmshow_impl_release", "yPosition", "getYPosition$cmshow_impl_release", "setYPosition$cmshow_impl_release", "setApolloId", "setPosition", "x", "y", "setRoleId", "setRoleType", "setScale", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract class BackgroundInitTask
  extends AbsScriptTask
{
  private int a = 1;
  @Nullable
  private String b;
  private int c;
  private float d = 1.0F;
  private float e;
  private float f;
  
  public BackgroundInitTask(@NotNull IApolloResManager paramIApolloResManager)
  {
    super(paramIApolloResManager);
  }
  
  @NotNull
  public final BackgroundInitTask a(float paramFloat1, float paramFloat2)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
    return this;
  }
  
  public final int c()
  {
    return this.a;
  }
  
  @NotNull
  public final BackgroundInitTask c(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  @Nullable
  public final String l()
  {
    return this.b;
  }
  
  public final int m()
  {
    return this.c;
  }
  
  public final float n()
  {
    return this.d;
  }
  
  public final float o()
  {
    return this.e;
  }
  
  public final float p()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.task.BackgroundInitTask
 * JD-Core Version:    0.7.0.1
 */