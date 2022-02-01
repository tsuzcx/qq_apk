package org.light;

public class TextPlaceHolder
{
  public int entityId;
  public int fillColor;
  public String key = "";
  public float layerHeight;
  public float layerWidth;
  public int maxLength;
  public int replaceIndex;
  public String text = "";
  
  public TextPlaceHolder(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.key = paramString1;
    this.text = paramString2;
    this.fillColor = paramInt1;
    this.maxLength = paramInt2;
  }
  
  public TextPlaceHolder(String paramString1, String paramString2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4)
  {
    this.key = paramString1;
    this.text = paramString2;
    this.fillColor = paramInt1;
    this.maxLength = paramInt2;
    this.layerWidth = paramFloat1;
    this.layerHeight = paramFloat2;
    this.replaceIndex = paramInt3;
    this.entityId = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.TextPlaceHolder
 * JD-Core Version:    0.7.0.1
 */