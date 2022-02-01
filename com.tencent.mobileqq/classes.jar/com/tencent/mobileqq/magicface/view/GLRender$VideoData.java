package com.tencent.mobileqq.magicface.view;

class GLRender$VideoData
{
  public byte[] a = null;
  public byte[] b = null;
  public int c;
  public int d;
  public int e;
  public int f;
  public float g;
  public boolean h;
  
  GLRender$VideoData(GLRender paramGLRender) {}
  
  public boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (paramArrayOfByte1 != null)
    {
      byte[] arrayOfByte = this.a;
      if (arrayOfByte == null) {
        this.a = new byte[paramArrayOfByte1.length];
      } else if (arrayOfByte.length != paramArrayOfByte1.length) {
        this.a = new byte[paramArrayOfByte1.length];
      }
      arrayOfByte = this.a;
      if (arrayOfByte == null) {
        return false;
      }
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      paramArrayOfByte1 = this.b;
      if (paramArrayOfByte1 == null) {
        this.b = new byte[paramArrayOfByte2.length];
      } else if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
        this.b = new byte[paramArrayOfByte2.length];
      }
      paramArrayOfByte1 = this.b;
      if (paramArrayOfByte1 == null) {
        return false;
      }
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte2.length);
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt1;
      this.f = paramInt2;
      this.g = paramFloat;
      this.h = paramBoolean;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.GLRender.VideoData
 * JD-Core Version:    0.7.0.1
 */