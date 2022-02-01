package com.tencent.mobileqq.troop.api.essence.data;

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
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("msgList:");
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (String str = this.jdField_a_of_type_JavaUtilArrayList.toString();; str = "null")
    {
      localStringBuilder2.append(str).append(" ");
      localStringBuilder1.append("opUin:").append(this.jdField_a_of_type_JavaLangString).append(" ");
      localStringBuilder1.append("opNickName:").append(this.b);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem
 * JD-Core Version:    0.7.0.1
 */