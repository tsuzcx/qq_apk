package com.tencent.tkd.topicsdk.bean.globalconfig;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/globalconfig/BusinessToastConfig;", "Ljava/io/Serializable;", "()V", "publishFailToast", "", "getPublishFailToast", "()Ljava/lang/String;", "setPublishFailToast", "(Ljava/lang/String;)V", "publishSuccessToast", "getPublishSuccessToast", "setPublishSuccessToast", "saveDraftToast", "getSaveDraftToast", "setSaveDraftToast", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class BusinessToastConfig
  implements Serializable
{
  @NotNull
  private String publishFailToast = "发表失败";
  @NotNull
  private String publishSuccessToast = "发表成功";
  @NotNull
  private String saveDraftToast = "已存入草稿";
  
  @NotNull
  public final String getPublishFailToast()
  {
    return this.publishFailToast;
  }
  
  @NotNull
  public final String getPublishSuccessToast()
  {
    return this.publishSuccessToast;
  }
  
  @NotNull
  public final String getSaveDraftToast()
  {
    return this.saveDraftToast;
  }
  
  public final void setPublishFailToast(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.publishFailToast = paramString;
  }
  
  public final void setPublishSuccessToast(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.publishSuccessToast = paramString;
  }
  
  public final void setSaveDraftToast(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.saveDraftToast = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.globalconfig.BusinessToastConfig
 * JD-Core Version:    0.7.0.1
 */