package com.tencent.mobileqq.kandian.repo.tab;

import com.tencent.mobileqq.app.Frame;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/tab/KandianFrameStatus;", "", "()V", "currentFrameClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/Frame;", "getCurrentFrameClass", "()Ljava/lang/Class;", "setCurrentFrameClass", "(Ljava/lang/Class;)V", "isShowKandianTab", "", "()Z", "setShowKandianTab", "(Z)V", "isXTabMode", "setXTabMode", "toString", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class KandianFrameStatus
{
  private boolean a;
  private boolean b;
  @Nullable
  private Class<? extends Frame> c;
  
  public final void a(@Nullable Class<? extends Frame> paramClass)
  {
    this.c = paramClass;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final boolean b()
  {
    return this.b;
  }
  
  @Nullable
  public final Class<? extends Frame> c()
  {
    return this.c;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KandianFrameStatus(isShowKandianTab=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", isXTabMode=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", currenFrmeClass=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.tab.KandianFrameStatus
 * JD-Core Version:    0.7.0.1
 */