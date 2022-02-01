package com.tencent.mobileqq.troop.api.essence.data;

public class TroopEssenceMsgItem$TroopEssenceMsgItemValue
{
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  
  public TroopEssenceMsgItem$TroopEssenceMsgItemValue(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("opType:").append(this.jdField_a_of_type_Int).append(" ");
    localStringBuilder.append("msgSenderUin:").append(this.jdField_a_of_type_JavaLangString).append(" ");
    localStringBuilder.append("opUin:").append(this.jdField_b_of_type_JavaLangString).append(" ");
    localStringBuilder.append("opTime:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append("graytipuniseq:").append(this.jdField_b_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue
 * JD-Core Version:    0.7.0.1
 */