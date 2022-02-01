package com.tencent.qapmsdk.bigbitmap.datainfo;

public class DrawableInfo
{
  public long allocatedByteSize;
  public int height;
  public int type;
  public String url;
  public int width;
  
  public DrawableInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, 0L);
  }
  
  public DrawableInfo(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this(paramInt1, paramInt2, paramInt3, paramLong, "");
  }
  
  public DrawableInfo(int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    this.type = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.allocatedByteSize = paramLong;
    this.url = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.datainfo.DrawableInfo
 * JD-Core Version:    0.7.0.1
 */