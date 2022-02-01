package me.weishu.epic.art.arch;

import java.nio.ByteOrder;

public class Arm64
  extends ShellCode
{
  public byte[] createBridgeJump(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    byte[] arrayOfByte = new byte[96];
    arrayOfByte[0] = 31;
    arrayOfByte[1] = 32;
    arrayOfByte[2] = 3;
    arrayOfByte[3] = -43;
    arrayOfByte[4] = 105;
    arrayOfByte[5] = 2;
    arrayOfByte[7] = 88;
    arrayOfByte[8] = 31;
    arrayOfByte[10] = 9;
    arrayOfByte[11] = -21;
    arrayOfByte[12] = -95;
    arrayOfByte[13] = 2;
    arrayOfByte[15] = 84;
    arrayOfByte[16] = -128;
    arrayOfByte[17] = 1;
    arrayOfByte[19] = 88;
    arrayOfByte[20] = 41;
    arrayOfByte[21] = 2;
    arrayOfByte[23] = 88;
    arrayOfByte[24] = -22;
    arrayOfByte[25] = 3;
    arrayOfByte[27] = -111;
    arrayOfByte[28] = 42;
    arrayOfByte[29] = 1;
    arrayOfByte[31] = -7;
    arrayOfByte[32] = 34;
    arrayOfByte[33] = 5;
    arrayOfByte[35] = -7;
    arrayOfByte[36] = 35;
    arrayOfByte[37] = 9;
    arrayOfByte[39] = -7;
    arrayOfByte[40] = -29;
    arrayOfByte[41] = 3;
    arrayOfByte[42] = 9;
    arrayOfByte[43] = -86;
    arrayOfByte[44] = 34;
    arrayOfByte[45] = 1;
    arrayOfByte[47] = 88;
    arrayOfByte[48] = 34;
    arrayOfByte[49] = 13;
    arrayOfByte[51] = -7;
    arrayOfByte[52] = -30;
    arrayOfByte[53] = 3;
    arrayOfByte[54] = 19;
    arrayOfByte[55] = -86;
    arrayOfByte[56] = -119;
    arrayOfByte[59] = 88;
    arrayOfByte[60] = 32;
    arrayOfByte[61] = 1;
    arrayOfByte[62] = 31;
    arrayOfByte[63] = -42;
    writeLong(paramLong1, ByteOrder.LITTLE_ENDIAN, arrayOfByte, arrayOfByte.length - 32);
    writeLong(paramLong2, ByteOrder.LITTLE_ENDIAN, arrayOfByte, arrayOfByte.length - 24);
    writeLong(paramLong3, ByteOrder.LITTLE_ENDIAN, arrayOfByte, arrayOfByte.length - 16);
    writeLong(paramLong4, ByteOrder.LITTLE_ENDIAN, arrayOfByte, arrayOfByte.length - 8);
    return arrayOfByte;
  }
  
  public byte[] createDirectJump(long paramLong)
  {
    byte[] arrayOfByte = new byte[16];
    arrayOfByte[0] = 80;
    arrayOfByte[3] = 88;
    arrayOfByte[5] = 2;
    arrayOfByte[6] = 31;
    arrayOfByte[7] = -42;
    writeLong(paramLong, ByteOrder.LITTLE_ENDIAN, arrayOfByte, arrayOfByte.length - 8);
    return arrayOfByte;
  }
  
  public String getName()
  {
    return "64-bit ARM";
  }
  
  public int sizeOfBridgeJump()
  {
    return 96;
  }
  
  public int sizeOfDirectJump()
  {
    return 16;
  }
  
  public long toMem(long paramLong)
  {
    return paramLong;
  }
  
  public long toPC(long paramLong)
  {
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.arch.Arm64
 * JD-Core Version:    0.7.0.1
 */