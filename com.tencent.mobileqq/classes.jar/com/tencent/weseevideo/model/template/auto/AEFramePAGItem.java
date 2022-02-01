package com.tencent.weseevideo.model.template.auto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/template/auto/AEFramePAGItem;", "", "()V", "pagName", "", "getPagName", "()Ljava/lang/String;", "setPagName", "(Ljava/lang/String;)V", "visibleRatio", "", "getVisibleRatio", "()F", "setVisibleRatio", "(F)V", "visibleRegion", "Lcom/tencent/weseevideo/model/template/auto/AEFrameVisibleRegion;", "getVisibleRegion", "()Lcom/tencent/weseevideo/model/template/auto/AEFrameVisibleRegion;", "setVisibleRegion", "(Lcom/tencent/weseevideo/model/template/auto/AEFrameVisibleRegion;)V", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class AEFramePAGItem
{
  @SerializedName("pagName")
  @NotNull
  private String pagName = "";
  @SerializedName("visibleRatio")
  private float visibleRatio;
  @SerializedName("visibleRegion")
  @NotNull
  private AEFrameVisibleRegion visibleRegion = new AEFrameVisibleRegion();
  
  @NotNull
  public final String getPagName()
  {
    return this.pagName;
  }
  
  public final float getVisibleRatio()
  {
    return this.visibleRatio;
  }
  
  @NotNull
  public final AEFrameVisibleRegion getVisibleRegion()
  {
    return this.visibleRegion;
  }
  
  public final void setPagName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.pagName = paramString;
  }
  
  public final void setVisibleRatio(float paramFloat)
  {
    this.visibleRatio = paramFloat;
  }
  
  public final void setVisibleRegion(@NotNull AEFrameVisibleRegion paramAEFrameVisibleRegion)
  {
    Intrinsics.checkParameterIsNotNull(paramAEFrameVisibleRegion, "<set-?>");
    this.visibleRegion = paramAEFrameVisibleRegion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.auto.AEFramePAGItem
 * JD-Core Version:    0.7.0.1
 */