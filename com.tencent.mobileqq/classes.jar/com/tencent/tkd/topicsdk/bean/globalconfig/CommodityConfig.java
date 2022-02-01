package com.tencent.tkd.topicsdk.bean.globalconfig;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/globalconfig/CommodityConfig;", "Ljava/io/Serializable;", "()V", "showUserHint", "", "getShowUserHint", "()Z", "setShowUserHint", "(Z)V", "userHint", "", "getUserHint", "()Ljava/lang/String;", "setUserHint", "(Ljava/lang/String;)V", "userHintUrl", "getUserHintUrl", "setUserHintUrl", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CommodityConfig
  implements Serializable
{
  private boolean showUserHint;
  @NotNull
  private String userHint = "";
  @NotNull
  private String userHintUrl = "";
  
  public final boolean getShowUserHint()
  {
    return this.showUserHint;
  }
  
  @NotNull
  public final String getUserHint()
  {
    return this.userHint;
  }
  
  @NotNull
  public final String getUserHintUrl()
  {
    return this.userHintUrl;
  }
  
  public final void setShowUserHint(boolean paramBoolean)
  {
    this.showUserHint = paramBoolean;
  }
  
  public final void setUserHint(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.userHint = paramString;
  }
  
  public final void setUserHintUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.userHintUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.globalconfig.CommodityConfig
 * JD-Core Version:    0.7.0.1
 */