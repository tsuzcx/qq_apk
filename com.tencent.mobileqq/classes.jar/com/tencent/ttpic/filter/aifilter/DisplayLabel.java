package com.tencent.ttpic.filter.aifilter;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public final class DisplayLabel
{
  @SerializedName("confidence")
  private final float confidence;
  @SerializedName("label")
  @NotNull
  private final String label;
  
  public DisplayLabel(@NotNull String paramString, float paramFloat)
  {
    this.label = paramString;
    this.confidence = paramFloat;
  }
  
  public final float getConfidence()
  {
    return this.confidence;
  }
  
  @NotNull
  public final String getLabel()
  {
    return this.label;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.DisplayLabel
 * JD-Core Version:    0.7.0.1
 */