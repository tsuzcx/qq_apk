package com.tencent.mobileqq.mini.zxing;

public final class PlanarYUVLuminanceSource
  extends LuminanceSource
{
  private static final int THUMBNAIL_SCALE_FACTOR = 2;
  private final int dataHeight;
  private final int dataWidth;
  private final int left;
  private final int top;
  private final byte[] yuvData;
  
  public PlanarYUVLuminanceSource(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    super(paramInt5, paramInt6);
    if ((paramInt3 + paramInt5 > paramInt1) || (paramInt4 + paramInt6 > paramInt2)) {
      throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
    this.yuvData = paramArrayOfByte;
    this.dataWidth = paramInt1;
    this.dataHeight = paramInt2;
    this.left = paramInt3;
    this.top = paramInt4;
    if (paramBoolean) {
      reverseHorizontal(paramInt5, paramInt6);
    }
  }
  
  private void reverseHorizontal(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = this.yuvData;
    int j = this.top;
    int k = this.dataWidth;
    j = this.left + j * k;
    k = 0;
    while (k < paramInt2)
    {
      int i1 = paramInt1 / 2;
      int m = j + paramInt1 - 1;
      int n = j;
      while (n < j + i1)
      {
        int i = arrayOfByte[n];
        arrayOfByte[n] = arrayOfByte[m];
        arrayOfByte[m] = i;
        n += 1;
        m -= 1;
      }
      j += this.dataWidth;
      k += 1;
    }
  }
  
  public LuminanceSource crop(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new PlanarYUVLuminanceSource(this.yuvData, this.dataWidth, this.dataHeight, this.left + paramInt1, this.top + paramInt2, paramInt3, paramInt4, false);
  }
  
  public byte[] getMatrix()
  {
    int i = 0;
    int m = getWidth();
    int n = getHeight();
    Object localObject;
    if ((m == this.dataWidth) && (n == this.dataHeight))
    {
      localObject = this.yuvData;
      return localObject;
    }
    int i1 = m * n;
    byte[] arrayOfByte = new byte[i1];
    int k = this.top * this.dataWidth + this.left;
    int j = k;
    if (m == this.dataWidth)
    {
      System.arraycopy(this.yuvData, k, arrayOfByte, 0, i1);
      return arrayOfByte;
    }
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= n) {
        break;
      }
      System.arraycopy(this.yuvData, j, arrayOfByte, i * m, m);
      j += this.dataWidth;
      i += 1;
    }
  }
  
  public byte[] getRow(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt < 0) || (paramInt >= getHeight())) {
      throw new IllegalArgumentException("Requested row is outside the image: " + paramInt);
    }
    int i = getWidth();
    byte[] arrayOfByte;
    if (paramArrayOfByte != null)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte.length >= i) {}
    }
    else
    {
      arrayOfByte = new byte[i];
    }
    int j = this.top;
    int k = this.dataWidth;
    int m = this.left;
    System.arraycopy(this.yuvData, (j + paramInt) * k + m, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public int getThumbnailHeight()
  {
    return getHeight() / 2;
  }
  
  public int getThumbnailWidth()
  {
    return getWidth() / 2;
  }
  
  public boolean isCropSupported()
  {
    return true;
  }
  
  public int[] renderThumbnail()
  {
    int m = getWidth() / 2;
    int n = getHeight() / 2;
    int[] arrayOfInt = new int[m * n];
    byte[] arrayOfByte = this.yuvData;
    int j = this.top;
    int k = this.dataWidth;
    int i1 = this.left;
    int i = 0;
    j = j * k + i1;
    while (i < n)
    {
      k = 0;
      while (k < m)
      {
        arrayOfInt[(i * m + k)] = ((arrayOfByte[(k * 2 + j)] & 0xFF) * 65793 | 0xFF000000);
        k += 1;
      }
      j += this.dataWidth * 2;
      i += 1;
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.PlanarYUVLuminanceSource
 * JD-Core Version:    0.7.0.1
 */