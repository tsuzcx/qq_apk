package com.tencent.mobileqq.troop.essencemsg;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TroopEssenceMsgManager$WaittingEssenceMsgItem
{
  public String a;
  public long b;
  
  TroopEssenceMsgManager$WaittingEssenceMsgItem(TroopEssenceMsgManager paramTroopEssenceMsgManager, String paramString, long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
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
      if (!TextUtils.isEmpty(this.a))
      {
        bool1 = bool2;
        if (this.a.equals(paramObject.a))
        {
          bool1 = bool2;
          if (this.b == paramObject.b) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    String str = this.a;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    return i + (int)this.b;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troopUin = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", uniSeq = ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.WaittingEssenceMsgItem
 * JD-Core Version:    0.7.0.1
 */