package com.tencent.turingfd.sdk.xq;

public class Chestnut
{
  public static final byte[] Wg = new byte[0];
  public byte[] eh;
  public long fg;
  public Codlin zh;
  
  public Chestnut(long paramLong, byte[] paramArrayOfByte, Codlin paramCodlin)
  {
    this.fg = paramLong;
    this.eh = paramArrayOfByte;
    this.zh = paramCodlin;
  }
  
  public static Chestnut a(long paramLong, Codlin paramCodlin)
  {
    paramCodlin.fg = paramLong;
    return new Chestnut(paramLong, Wg, paramCodlin);
  }
  
  public static Chestnut a(byte[] paramArrayOfByte, Codlin paramCodlin)
  {
    paramCodlin.fg = 0L;
    return new Chestnut(0L, paramArrayOfByte, paramCodlin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Chestnut
 * JD-Core Version:    0.7.0.1
 */