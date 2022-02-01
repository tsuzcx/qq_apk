package com.tencent.mobileqq.vpng.util;

class VPNGUtil$PNGStruct
{
  int a;
  char[] b = new char[4];
  
  private void a(byte[] paramArrayOfByte)
  {
    this.a = VPNGUtil.a(paramArrayOfByte);
    int i = 0;
    for (;;)
    {
      char[] arrayOfChar = this.b;
      if (i >= arrayOfChar.length) {
        break;
      }
      arrayOfChar[i] = ((char)paramArrayOfByte[(i + 4)]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.util.VPNGUtil.PNGStruct
 * JD-Core Version:    0.7.0.1
 */