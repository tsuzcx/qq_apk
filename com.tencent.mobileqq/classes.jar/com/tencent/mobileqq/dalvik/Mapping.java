package com.tencent.mobileqq.dalvik;

public class Mapping
{
  public final long beginAddr;
  public final long endAddr;
  public final String pathName;
  public final boolean readable;
  public final boolean useless;
  public final boolean writable;
  
  public Mapping(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    this.beginAddr = paramLong1;
    this.endAddr = paramLong2;
    this.readable = paramBoolean1;
    this.writable = paramBoolean2;
    this.useless = paramBoolean3;
    this.pathName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dalvik.Mapping
 * JD-Core Version:    0.7.0.1
 */