package com.tencent.plato.sdk.render;

public class PRect
{
  public int blockRef;
  public int height;
  public int id;
  public int left;
  public int top;
  public int width;
  
  public PRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.id = paramInt1;
    this.blockRef = paramInt2;
    this.left = paramInt3;
    this.top = paramInt4;
    this.width = paramInt5;
    this.height = paramInt6;
  }
  
  public PRect(PRect paramPRect)
  {
    this.id = paramPRect.id;
    this.blockRef = paramPRect.blockRef;
    this.left = paramPRect.left;
    this.top = paramPRect.top;
    this.width = paramPRect.width;
    this.height = paramPRect.height;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PRect
 * JD-Core Version:    0.7.0.1
 */