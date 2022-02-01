package com.tencent.mobileqq.nearby.redtouch;

import java.io.Serializable;

public class RedTouchItemExtMsg
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  public byte[] bytesData;
  public long seq;
  public int time;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("seq");
    localStringBuilder.append(":");
    localStringBuilder.append(this.seq);
    localStringBuilder.append(" ");
    localStringBuilder.append("time");
    localStringBuilder.append(":");
    localStringBuilder.append(this.time);
    localStringBuilder.append(" ");
    localStringBuilder.append("bytesData");
    localStringBuilder.append(":");
    localStringBuilder.append(this.bytesData);
    localStringBuilder.append(" ");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg
 * JD-Core Version:    0.7.0.1
 */