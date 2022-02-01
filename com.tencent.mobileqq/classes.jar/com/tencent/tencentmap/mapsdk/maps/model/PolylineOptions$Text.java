package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.Collections;
import java.util.List;

public final class PolylineOptions$Text
{
  private final List<PolylineOptions.SegmentText> a;
  private PolylineOptions.Text.Builder b;
  
  private PolylineOptions$Text(PolylineOptions.Text.Builder paramBuilder)
  {
    this.a = Collections.unmodifiableList(PolylineOptions.Text.Builder.a(paramBuilder));
    this.b = paramBuilder;
  }
  
  public final PolylineOptions.TextPriority getPriority()
  {
    return PolylineOptions.Text.Builder.e(this.b);
  }
  
  public final List<PolylineOptions.SegmentText> getSegmentTexts()
  {
    return this.a;
  }
  
  public final int getStrokeColor()
  {
    return PolylineOptions.Text.Builder.c(this.b);
  }
  
  public final int getTextColor()
  {
    return PolylineOptions.Text.Builder.b(this.b);
  }
  
  public final int getTextSize()
  {
    return PolylineOptions.Text.Builder.d(this.b);
  }
  
  public final void setPriority(PolylineOptions.TextPriority paramTextPriority)
  {
    PolylineOptions.Text.Builder.a(this.b, paramTextPriority);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    PolylineOptions.Text.Builder.b(this.b, paramInt);
  }
  
  public final void setTextColor(int paramInt)
  {
    PolylineOptions.Text.Builder.a(this.b, paramInt);
  }
  
  public final void setTextSize(int paramInt)
  {
    PolylineOptions.Text.Builder.c(this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text
 * JD-Core Version:    0.7.0.1
 */