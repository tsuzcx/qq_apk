package com.tencent.mobileqq.troop.essence.data;

public class TroopEssenceMsgItem$TroopEssenceMsgPushItem
{
  public TroopEssenceMsgItem a;
  public int b;
  public String c;
  public String d;
  
  public TroopEssenceMsgItem$TroopEssenceMsgPushItem(TroopEssenceMsgItem paramTroopEssenceMsgItem, int paramInt, String paramString1, String paramString2)
  {
    this.a = paramTroopEssenceMsgItem;
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgItem:");
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((TroopEssenceMsgItem)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ");
    localStringBuilder.append("graytipmsgseq:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append("opNickName:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append("senderNickName:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem
 * JD-Core Version:    0.7.0.1
 */