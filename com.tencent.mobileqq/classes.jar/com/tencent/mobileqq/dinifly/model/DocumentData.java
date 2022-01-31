package com.tencent.mobileqq.dinifly.model;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import org.json.JSONArray;
import org.json.JSONObject;

public class DocumentData
{
  @ColorInt
  public int color;
  public String fontName;
  int justification;
  double lineHeight;
  public int size;
  @ColorInt
  public int strokeColor;
  public boolean strokeOverFill;
  public int strokeWidth;
  public String text;
  public int tracking;
  
  DocumentData(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, double paramDouble, @ColorInt int paramInt4, @ColorInt int paramInt5, int paramInt6, boolean paramBoolean)
  {
    this.text = paramString1;
    this.fontName = paramString2;
    this.size = paramInt1;
    this.justification = paramInt2;
    this.tracking = paramInt3;
    this.lineHeight = paramDouble;
    this.color = paramInt4;
    this.strokeColor = paramInt5;
    this.strokeWidth = paramInt6;
    this.strokeOverFill = paramBoolean;
  }
  
  public int hashCode()
  {
    int i = this.text.hashCode();
    int j = this.fontName.hashCode();
    int k = this.size;
    int m = this.justification;
    int n = this.tracking;
    long l = Double.doubleToLongBits(this.lineHeight);
    return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + (int)(l >>> 32 ^ l)) * 31 + this.color;
  }
  
  void set(DocumentData paramDocumentData)
  {
    this.text = paramDocumentData.text;
    this.fontName = paramDocumentData.fontName;
    this.size = paramDocumentData.size;
    this.justification = paramDocumentData.justification;
    this.tracking = paramDocumentData.tracking;
    this.lineHeight = paramDocumentData.lineHeight;
    this.color = paramDocumentData.color;
  }
  
  public static final class Factory
  {
    public static DocumentData newInstance(JSONObject paramJSONObject)
    {
      String str1 = paramJSONObject.optString("t");
      String str2 = paramJSONObject.optString("f");
      int j = paramJSONObject.optInt("s");
      int k = paramJSONObject.optInt("j");
      int m = paramJSONObject.optInt("tr");
      double d = paramJSONObject.optDouble("lh");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("fc");
      int n = Color.argb(255, (int)(localJSONArray.optDouble(0) * 255.0D), (int)(localJSONArray.optDouble(1) * 255.0D), (int)(localJSONArray.optDouble(2) * 255.0D));
      localJSONArray = paramJSONObject.optJSONArray("sc");
      int i = 0;
      if (localJSONArray != null) {
        i = Color.argb(255, (int)(localJSONArray.optDouble(0) * 255.0D), (int)(localJSONArray.optDouble(1) * 255.0D), (int)(localJSONArray.optDouble(2) * 255.0D));
      }
      return new DocumentData(str1, str2, j, k, m, d, n, i, paramJSONObject.optInt("sw"), paramJSONObject.optBoolean("of"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.DocumentData
 * JD-Core Version:    0.7.0.1
 */