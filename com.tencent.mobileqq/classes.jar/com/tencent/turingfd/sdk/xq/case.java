package com.tencent.turingfd.sdk.xq;

import java.io.Serializable;

public abstract class case
  implements Serializable
{
  public abstract void a(byte parambyte);
  
  public abstract void a(try paramtry);
  
  public byte[] toByteArray()
  {
    byte localbyte = new byte();
    a(localbyte);
    return localbyte.toByteArray();
  }
  
  public String toString()
  {
    return new StringBuilder().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.case
 * JD-Core Version:    0.7.0.1
 */