package com.tencent.mobileqq.troop.essence.data;

import java.util.ArrayList;

public class TroopEssenceMsgItem$TroopBatchEssenceMsgPushItem
{
  public long a;
  public ArrayList<TroopEssenceMsgItem> b;
  public String c;
  public String d;
  
  public TroopEssenceMsgItem$TroopBatchEssenceMsgPushItem(long paramLong, ArrayList<TroopEssenceMsgItem> paramArrayList, String paramString1, String paramString2)
  {
    this.a = paramLong;
    this.b = paramArrayList;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgList:");
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((ArrayList)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ");
    localStringBuilder.append("opUin:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append("opNickName:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem
 * JD-Core Version:    0.7.0.1
 */