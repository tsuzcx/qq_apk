package com.tencent.mobileqq.kandian.repo.aladdin.beans;

import com.tencent.aladdin.config.parse.AladdinConfigBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/aladdin/beans/ProteusPreloadRule;", "Lcom/tencent/aladdin/config/parse/AladdinConfigBean;", "()V", "bizID", "", "getBizID", "()Ljava/lang/String;", "setBizID", "(Ljava/lang/String;)V", "preloadCount", "", "getPreloadCount", "()I", "setPreloadCount", "(I)V", "styleName", "getStyleName", "setStyleName", "toString", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ProteusPreloadRule
  implements AladdinConfigBean
{
  @NotNull
  public String bizID;
  private int preloadCount = 1;
  @NotNull
  public String styleName;
  
  @NotNull
  public final String getBizID()
  {
    String str = this.bizID;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bizID");
    }
    return str;
  }
  
  public final int getPreloadCount()
  {
    return this.preloadCount;
  }
  
  @NotNull
  public final String getStyleName()
  {
    String str = this.styleName;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("styleName");
    }
    return str;
  }
  
  public final void setBizID(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.bizID = paramString;
  }
  
  public final void setPreloadCount(int paramInt)
  {
    this.preloadCount = paramInt;
  }
  
  public final void setStyleName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.styleName = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ProteusPreloadRule(bizID='");
    String str = this.bizID;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bizID");
    }
    localStringBuilder.append(str);
    localStringBuilder.append("', styleName='");
    str = this.styleName;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("styleName");
    }
    localStringBuilder.append(str);
    localStringBuilder.append("', preloadCount=");
    localStringBuilder.append(this.preloadCount);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.beans.ProteusPreloadRule
 * JD-Core Version:    0.7.0.1
 */