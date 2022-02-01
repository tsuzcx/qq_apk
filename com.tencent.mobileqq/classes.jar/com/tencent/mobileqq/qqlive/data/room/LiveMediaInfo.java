package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.util.Utils;

public class LiveMediaInfo
{
  public int authEncryptionType;
  public byte[] sig;
  public long timeOut;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LiveMediaInfo is [sig= ");
    localStringBuilder.append(Utils.b(this.sig));
    localStringBuilder.append(";timeOut=");
    localStringBuilder.append(this.timeOut);
    localStringBuilder.append(";authEncryptionType=");
    localStringBuilder.append(this.authEncryptionType);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.room.LiveMediaInfo
 * JD-Core Version:    0.7.0.1
 */