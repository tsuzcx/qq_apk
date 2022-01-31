package com.tencent.mobileqq.dinifly.model;

import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class DocumentData
{
  public final double baselineShift;
  @ColorInt
  public final int color;
  public final String fontName;
  public final DocumentData.Justification justification;
  public final double lineHeight;
  public final double size;
  @ColorInt
  public final int strokeColor;
  public final boolean strokeOverFill;
  public final double strokeWidth;
  public final String text;
  public final int tracking;
  
  public DocumentData(String paramString1, String paramString2, double paramDouble1, DocumentData.Justification paramJustification, int paramInt1, double paramDouble2, double paramDouble3, @ColorInt int paramInt2, @ColorInt int paramInt3, double paramDouble4, boolean paramBoolean)
  {
    this.text = paramString1;
    this.fontName = paramString2;
    this.size = paramDouble1;
    this.justification = paramJustification;
    this.tracking = paramInt1;
    this.lineHeight = paramDouble2;
    this.baselineShift = paramDouble3;
    this.color = paramInt2;
    this.strokeColor = paramInt3;
    this.strokeWidth = paramDouble4;
    this.strokeOverFill = paramBoolean;
  }
  
  public int hashCode()
  {
    int i = (int)((this.text.hashCode() * 31 + this.fontName.hashCode()) * 31 + this.size);
    int j = this.justification.ordinal();
    int k = this.tracking;
    long l = Double.doubleToLongBits(this.lineHeight);
    return (((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32)) * 31 + this.color;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.DocumentData
 * JD-Core Version:    0.7.0.1
 */