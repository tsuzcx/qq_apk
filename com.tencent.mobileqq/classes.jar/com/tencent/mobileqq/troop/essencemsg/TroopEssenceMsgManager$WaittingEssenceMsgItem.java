package com.tencent.mobileqq.troop.essencemsg;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TroopEssenceMsgManager$WaittingEssenceMsgItem
{
  public long a;
  public String a;
  
  TroopEssenceMsgManager$WaittingEssenceMsgItem(TroopEssenceMsgManager paramTroopEssenceMsgManager, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof WaittingEssenceMsgItem));
      paramObject = (WaittingEssenceMsgItem)paramObject;
    } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long));
    return true;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaLangString.hashCode()) {
      return i + (int)this.jdField_a_of_type_Long;
    }
  }
  
  @NonNull
  public String toString()
  {
    return "troopUin = " + this.jdField_a_of_type_JavaLangString + ", uniSeq = " + this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.WaittingEssenceMsgItem
 * JD-Core Version:    0.7.0.1
 */