package com.tencent.tencentmap.mapsdk.maps.model;

public final class PolylineOptions$SegmentText
{
  private final int a;
  private final int b;
  private final String c;
  
  public PolylineOptions$SegmentText(int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
  }
  
  public final int getEndIndex()
  {
    return this.b;
  }
  
  public final int getStartIndex()
  {
    return this.a;
  }
  
  public final String getText()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.SegmentText
 * JD-Core Version:    0.7.0.1
 */