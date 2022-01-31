package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.ArrayList;
import java.util.List;

public final class PolylineOptions$Text$Builder
{
  private List<PolylineOptions.SegmentText> a = new ArrayList();
  private int b = -16777216;
  private int c = -1;
  private int d = 14;
  private PolylineOptions.TextPriority e = PolylineOptions.TextPriority.HIGH;
  
  public PolylineOptions$Text$Builder(PolylineOptions.SegmentText paramSegmentText)
  {
    addSegmentText(paramSegmentText);
  }
  
  public PolylineOptions$Text$Builder(List<PolylineOptions.SegmentText> paramList)
  {
    addAllSegmentText(paramList);
  }
  
  public final Builder addAllSegmentText(List<PolylineOptions.SegmentText> paramList)
  {
    this.a.addAll(paramList);
    return this;
  }
  
  public final Builder addSegmentText(PolylineOptions.SegmentText paramSegmentText)
  {
    this.a.add(paramSegmentText);
    return this;
  }
  
  public final PolylineOptions.Text build()
  {
    return new PolylineOptions.Text(this, (byte)0);
  }
  
  public final Builder color(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public final Builder priority(PolylineOptions.TextPriority paramTextPriority)
  {
    this.e = paramTextPriority;
    return this;
  }
  
  public final Builder size(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public final Builder strokeColor(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text.Builder
 * JD-Core Version:    0.7.0.1
 */