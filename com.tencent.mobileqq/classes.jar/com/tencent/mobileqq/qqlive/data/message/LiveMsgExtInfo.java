package com.tencent.mobileqq.qqlive.data.message;

public class LiveMsgExtInfo
{
  public LiveMsgExtInfo.MsgSpeed msgSpeed;
  public int msgType;
  public long msgUid;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgExtInfo{msgType=");
    localStringBuilder.append(this.msgType);
    localStringBuilder.append(", msgUid=");
    localStringBuilder.append(this.msgUid);
    localStringBuilder.append(", msgSpeed=");
    localStringBuilder.append(this.msgSpeed);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo
 * JD-Core Version:    0.7.0.1
 */