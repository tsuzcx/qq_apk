package com.tencent.mobileqq.troop.essence.data;

public class TroopEssenceMsgItem$TroopEssenceMsgItemValue
{
  public int a;
  public String b;
  public String c;
  public long d;
  public long e;
  
  public TroopEssenceMsgItem$TroopEssenceMsgItemValue(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramLong1;
    this.e = paramLong2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("opType:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append("msgSenderUin:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("opUin:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append("opTime:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("graytipuniseq:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue
 * JD-Core Version:    0.7.0.1
 */