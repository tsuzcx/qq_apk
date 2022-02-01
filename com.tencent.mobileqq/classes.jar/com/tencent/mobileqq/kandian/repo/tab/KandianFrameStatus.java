package com.tencent.mobileqq.kandian.repo.tab;

import com.tencent.mobileqq.app.Frame;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/tab/KandianFrameStatus;", "", "()V", "currentFrameClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/Frame;", "getCurrentFrameClass", "()Ljava/lang/Class;", "setCurrentFrameClass", "(Ljava/lang/Class;)V", "isShowKandianTab", "", "()Z", "setShowKandianTab", "(Z)V", "isXTabMode", "setXTabMode", "toString", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class KandianFrameStatus
{
  @Nullable
  private Class<? extends Frame> jdField_a_of_type_JavaLangClass;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  @Nullable
  public final Class<? extends Frame> a()
  {
    return this.jdField_a_of_type_JavaLangClass;
  }
  
  public final void a(@Nullable Class<? extends Frame> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final boolean b()
  {
    return this.b;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KandianFrameStatus(isShowKandianTab=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", isXTabMode=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", currenFrmeClass=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangClass);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.tab.KandianFrameStatus
 * JD-Core Version:    0.7.0.1
 */