package com.tencent.mobileqq.vpng.util;

class VPNGUtil$PNGStruct
{
  int jdField_a_of_type_Int;
  char[] jdField_a_of_type_ArrayOfChar = new char[4];
  
  private void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Int = VPNGUtil.a(paramArrayOfByte);
    int i = 0;
    for (;;)
    {
      char[] arrayOfChar = this.jdField_a_of_type_ArrayOfChar;
      if (i >= arrayOfChar.length) {
        break;
      }
      arrayOfChar[i] = ((char)paramArrayOfByte[(i + 4)]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.util.VPNGUtil.PNGStruct
 * JD-Core Version:    0.7.0.1
 */