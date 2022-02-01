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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((paramObject instanceof WaittingEssenceMsgItem))
    {
      paramObject = (WaittingEssenceMsgItem)paramObject;
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    return i + (int)this.jdField_a_of_type_Long;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troopUin = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", uniSeq = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.WaittingEssenceMsgItem
 * JD-Core Version:    0.7.0.1
 */