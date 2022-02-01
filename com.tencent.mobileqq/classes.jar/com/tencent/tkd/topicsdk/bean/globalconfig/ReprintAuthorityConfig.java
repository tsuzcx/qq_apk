package com.tencent.tkd.topicsdk.bean.globalconfig;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/globalconfig/ReprintAuthorityConfig;", "Ljava/io/Serializable;", "()V", "allowReprint", "", "getAllowReprint", "()Z", "setAllowReprint", "(Z)V", "allowReprintDesc", "", "getAllowReprintDesc", "()Ljava/lang/String;", "setAllowReprintDesc", "(Ljava/lang/String;)V", "allowReprintTitle", "getAllowReprintTitle", "setAllowReprintTitle", "forbidReprintDesc", "getForbidReprintDesc", "setForbidReprintDesc", "forbidReprintTitle", "getForbidReprintTitle", "setForbidReprintTitle", "title", "getTitle", "setTitle", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class ReprintAuthorityConfig
  implements Serializable
{
  private boolean allowReprint;
  @NotNull
  private String allowReprintDesc = "允许其他人添加该视频到栏目";
  @NotNull
  private String allowReprintTitle = "允许转载";
  @NotNull
  private String forbidReprintDesc = "禁止其他人添加该视频到栏目";
  @NotNull
  private String forbidReprintTitle = "禁止转载";
  @NotNull
  private String title = "权限";
  
  public final boolean getAllowReprint()
  {
    return this.allowReprint;
  }
  
  @NotNull
  public final String getAllowReprintDesc()
  {
    return this.allowReprintDesc;
  }
  
  @NotNull
  public final String getAllowReprintTitle()
  {
    return this.allowReprintTitle;
  }
  
  @NotNull
  public final String getForbidReprintDesc()
  {
    return this.forbidReprintDesc;
  }
  
  @NotNull
  public final String getForbidReprintTitle()
  {
    return this.forbidReprintTitle;
  }
  
  @NotNull
  public final String getTitle()
  {
    return this.title;
  }
  
  public final void setAllowReprint(boolean paramBoolean)
  {
    this.allowReprint = paramBoolean;
  }
  
  public final void setAllowReprintDesc(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.allowReprintDesc = paramString;
  }
  
  public final void setAllowReprintTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.allowReprintTitle = paramString;
  }
  
  public final void setForbidReprintDesc(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.forbidReprintDesc = paramString;
  }
  
  public final void setForbidReprintTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.forbidReprintTitle = paramString;
  }
  
  public final void setTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.title = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.globalconfig.ReprintAuthorityConfig
 * JD-Core Version:    0.7.0.1
 */