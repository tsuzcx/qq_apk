package com.tencent.mobileqq.dinifly.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class DocumentData
{
  public final float baselineShift;
  @ColorInt
  public final int color;
  public final String fontName;
  public final DocumentData.Justification justification;
  public final float lineHeight;
  public final float size;
  @ColorInt
  public final int strokeColor;
  public final boolean strokeOverFill;
  public final float strokeWidth;
  public final String text;
  public final int tracking;
  
  public DocumentData(String paramString1, String paramString2, float paramFloat1, DocumentData.Justification paramJustification, int paramInt1, float paramFloat2, float paramFloat3, @ColorInt int paramInt2, @ColorInt int paramInt3, float paramFloat4, boolean paramBoolean)
  {
    this.text = paramString1;
    this.fontName = paramString2;
    this.size = paramFloat1;
    this.justification = paramJustification;
    this.tracking = paramInt1;
    this.lineHeight = paramFloat2;
    this.baselineShift = paramFloat3;
    this.color = paramInt2;
    this.strokeColor = paramInt3;
    this.strokeWidth = paramFloat4;
    this.strokeOverFill = paramBoolean;
  }
  
  public int hashCode()
  {
    int i = (int)((this.text.hashCode() * 31 + this.fontName.hashCode()) * 31 + this.size);
    int j = this.justification.ordinal();
    int k = this.tracking;
    long l = Float.floatToRawIntBits(this.lineHeight);
    return (((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32)) * 31 + this.color;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.DocumentData
 * JD-Core Version:    0.7.0.1
 */