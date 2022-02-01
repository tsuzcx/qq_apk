package com.tencent.mobileqq.troop.api.essence.data;

public class TroopEssenceMsgItem$TroopEssenceMsgPushItem
{
  public int a;
  public TroopEssenceMsgItem a;
  public String a;
  public String b;
  
  public TroopEssenceMsgItem$TroopEssenceMsgPushItem(TroopEssenceMsgItem paramTroopEssenceMsgItem, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem = paramTroopEssenceMsgItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("msgItem:");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqTroopApiEssenceDataTroopEssenceMsgItem.toString();; str = "null")
    {
      localStringBuilder2.append(str).append(" ");
      localStringBuilder1.append("graytipmsgseq:").append(this.jdField_a_of_type_Int).append(" ");
      localStringBuilder1.append("opNickName:").append(this.jdField_a_of_type_JavaLangString).append(" ");
      localStringBuilder1.append("senderNickName:").append(this.b);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem
 * JD-Core Version:    0.7.0.1
 */