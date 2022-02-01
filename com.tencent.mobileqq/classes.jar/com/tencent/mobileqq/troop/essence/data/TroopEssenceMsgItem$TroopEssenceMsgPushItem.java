package com.tencent.mobileqq.troop.essence.data;

public class TroopEssenceMsgItem$TroopEssenceMsgPushItem
{
  public int a;
  public TroopEssenceMsgItem a;
  public String a;
  public String b;
  
  public TroopEssenceMsgItem$TroopEssenceMsgPushItem(TroopEssenceMsgItem paramTroopEssenceMsgItem, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem = paramTroopEssenceMsgItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgItem:");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopEssenceDataTroopEssenceMsgItem;
    if (localObject != null) {
      localObject = ((TroopEssenceMsgItem)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ");
    localStringBuilder.append("graytipmsgseq:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" ");
    localStringBuilder.append("opNickName:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append("senderNickName:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem
 * JD-Core Version:    0.7.0.1
 */