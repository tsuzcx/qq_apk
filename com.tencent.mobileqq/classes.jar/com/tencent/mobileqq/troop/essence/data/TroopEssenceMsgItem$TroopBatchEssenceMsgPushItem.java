package com.tencent.mobileqq.troop.essence.data;

import java.util.ArrayList;

public class TroopEssenceMsgItem$TroopBatchEssenceMsgPushItem
{
  public long a;
  public String a;
  public ArrayList<TroopEssenceMsgItem> a;
  public String b;
  
  public TroopEssenceMsgItem$TroopBatchEssenceMsgPushItem(long paramLong, ArrayList<TroopEssenceMsgItem> paramArrayList, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgList:");
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null) {
      localObject = ((ArrayList)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ");
    localStringBuilder.append("opUin:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append("opNickName:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem
 * JD-Core Version:    0.7.0.1
 */