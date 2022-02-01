package com.tencent.mobileqq.magicface.view;

class GLRender$VideoData
{
  public float a;
  public int a;
  public boolean a;
  public byte[] a;
  public int b;
  public byte[] b;
  public int c;
  public int d;
  
  GLRender$VideoData(GLRender paramGLRender)
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
  }
  
  public boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (paramArrayOfByte1 != null)
    {
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      if (arrayOfByte == null) {
        this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte1.length];
      } else if (arrayOfByte.length != paramArrayOfByte1.length) {
        this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte1.length];
      }
      arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      if (arrayOfByte == null) {
        return false;
      }
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      paramArrayOfByte1 = this.jdField_b_of_type_ArrayOfByte;
      if (paramArrayOfByte1 == null) {
        this.jdField_b_of_type_ArrayOfByte = new byte[paramArrayOfByte2.length];
      } else if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
        this.jdField_b_of_type_ArrayOfByte = new byte[paramArrayOfByte2.length];
      }
      paramArrayOfByte1 = this.jdField_b_of_type_ArrayOfByte;
      if (paramArrayOfByte1 == null) {
        return false;
      }
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte2.length);
      this.jdField_a_of_type_Int = paramInt3;
      this.jdField_b_of_type_Int = paramInt4;
      this.c = paramInt1;
      this.d = paramInt2;
      this.jdField_a_of_type_Float = paramFloat;
      this.jdField_a_of_type_Boolean = paramBoolean;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.GLRender.VideoData
 * JD-Core Version:    0.7.0.1
 */