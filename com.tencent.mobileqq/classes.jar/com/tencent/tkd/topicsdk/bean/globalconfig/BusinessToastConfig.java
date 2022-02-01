package com.tencent.tkd.topicsdk.bean.globalconfig;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/globalconfig/BusinessToastConfig;", "Ljava/io/Serializable;", "()V", "publishSuccessToast", "", "getPublishSuccessToast", "()Ljava/lang/String;", "setPublishSuccessToast", "(Ljava/lang/String;)V", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class BusinessToastConfig
  implements Serializable
{
  @NotNull
  private String publishSuccessToast = "发表成功";
  
  @NotNull
  public final String getPublishSuccessToast()
  {
    return this.publishSuccessToast;
  }
  
  public final void setPublishSuccessToast(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.publishSuccessToast = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.globalconfig.BusinessToastConfig
 * JD-Core Version:    0.7.0.1
 */