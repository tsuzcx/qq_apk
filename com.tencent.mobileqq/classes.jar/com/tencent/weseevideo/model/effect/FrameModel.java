package com.tencent.weseevideo.model.effect;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/effect/FrameModel;", "", "()V", "angle", "", "getAngle", "()I", "centerX", "", "getCenterX", "()F", "centerY", "getCenterY", "maxScale", "getMaxScale", "minScale", "getMinScale", "scale", "getScale", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class FrameModel
{
  @SerializedName("angle")
  private final int angle;
  @SerializedName("centerX")
  private final float centerX = 0.5F;
  @SerializedName("centerY")
  private final float centerY = 0.5F;
  @SerializedName("maxScale")
  private final float maxScale = 1.0F;
  @SerializedName("minScale")
  private final float minScale = 0.2F;
  @SerializedName("scale")
  private final float scale = 0.6F;
  
  public final int getAngle()
  {
    return this.angle;
  }
  
  public final float getCenterX()
  {
    return this.centerX;
  }
  
  public final float getCenterY()
  {
    return this.centerY;
  }
  
  public final float getMaxScale()
  {
    return this.maxScale;
  }
  
  public final float getMinScale()
  {
    return this.minScale;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.FrameModel
 * JD-Core Version:    0.7.0.1
 */