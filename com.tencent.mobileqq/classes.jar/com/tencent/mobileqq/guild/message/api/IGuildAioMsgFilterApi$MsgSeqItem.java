package com.tencent.mobileqq.guild.message.api;

import androidx.annotation.NonNull;

public class IGuildAioMsgFilterApi$MsgSeqItem
{
  public long a = 0L;
  public long b = 0L;
  public long c = 0L;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("MsgSeqItem:{");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("uniqueSeq = ");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", msgSeq = ");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", cntSeq = ");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("}");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi.MsgSeqItem
 * JD-Core Version:    0.7.0.1
 */