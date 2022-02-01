package com.tencent.qcircle.weseevideo.model.template.auto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/model/template/auto/AEFrameVisibleRegion;", "", "()V", "height", "", "getHeight", "()F", "setHeight", "(F)V", "offsetX", "getOffsetX", "setOffsetX", "offsetY", "getOffsetY", "setOffsetY", "rotation", "getRotation", "setRotation", "width", "getWidth", "setWidth", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class AEFrameVisibleRegion
{
  @SerializedName("height")
  private float height = 1.0F;
  @SerializedName("x")
  private float offsetX;
  @SerializedName("y")
  private float offsetY;
  @SerializedName("rotation")
  private float rotation;
  @SerializedName("width")
  private float width = 1.0F;
  
  public final float getHeight()
  {
    return this.height;
  }
  
  public final float getOffsetX()
  {
    return this.offsetX;
  }
  
  public final float getOffsetY()
  {
    return this.offsetY;
  }
  
  public final float getRotation()
  {
    return this.rotation;
  }
  
  public final float getWidth()
  {
    return this.width;
  }
  
  public final void setHeight(float paramFloat)
  {
    this.height = paramFloat;
  }
  
  public final void setOffsetX(float paramFloat)
  {
    this.offsetX = paramFloat;
  }
  
  public final void setOffsetY(float paramFloat)
  {
    this.offsetY = paramFloat;
  }
  
  public final void setRotation(float paramFloat)
  {
    this.rotation = paramFloat;
  }
  
  public final void setWidth(float paramFloat)
  {
    this.width = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.template.auto.AEFrameVisibleRegion
 * JD-Core Version:    0.7.0.1
 */