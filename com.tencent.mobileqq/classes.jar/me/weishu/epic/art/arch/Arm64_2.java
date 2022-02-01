package me.weishu.epic.art.arch;

import java.nio.ByteOrder;

public class Arm64_2
  extends ShellCode
{
  public byte[] createBridgeJump(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    byte[] arrayOfByte = new byte[88];
    arrayOfByte[0] = 31;
    arrayOfByte[1] = 32;
    arrayOfByte[2] = 3;
    arrayOfByte[3] = -43;
    arrayOfByte[4] = 49;
    arrayOfByte[5] = 2;
    arrayOfByte[7] = 88;
    arrayOfByte[8] = 31;
    arrayOfByte[10] = 17;
    arrayOfByte[11] = -21;
    arrayOfByte[12] = 97;
    arrayOfByte[13] = 2;
    arrayOfByte[15] = 84;
    arrayOfByte[16] = 64;
    arrayOfByte[17] = 1;
    arrayOfByte[19] = 88;
    arrayOfByte[20] = -15;
    arrayOfByte[21] = 1;
    arrayOfByte[23] = 88;
    arrayOfByte[24] = -16;
    arrayOfByte[25] = 3;
    arrayOfByte[27] = -111;
    arrayOfByte[28] = 48;
    arrayOfByte[29] = 2;
    arrayOfByte[31] = -7;
    arrayOfByte[32] = 34;
    arrayOfByte[33] = 6;
    arrayOfByte[35] = -7;
    arrayOfByte[36] = 48;
    arrayOfByte[37] = 1;
    arrayOfByte[39] = 88;
    arrayOfByte[40] = 48;
    arrayOfByte[41] = 10;
    arrayOfByte[43] = -7;
    arrayOfByte[44] = -30;
    arrayOfByte[45] = 3;
    arrayOfByte[46] = 17;
    arrayOfByte[47] = -86;
    arrayOfByte[48] = -111;
    arrayOfByte[51] = 88;
    arrayOfByte[52] = 32;
    arrayOfByte[53] = 2;
    arrayOfByte[54] = 31;
    arrayOfByte[55] = -42;
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
    return "64-bit ARM(Android M)";
  }
  
  public int sizeOfBridgeJump()
  {
    return 88;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     me.weishu.epic.art.arch.Arm64_2
 * JD-Core Version:    0.7.0.1
 */