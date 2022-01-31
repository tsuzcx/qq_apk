package com.tencent.mobileqq.data;

import android.text.TextUtils;
import atmo;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="picMd5")
public class VipComicFavorEmoStructMsgInfo
  extends atmo
{
  public static final int init = 1;
  public static final int updated = 2;
  public String actionData;
  public String picMd5;
  public int status = 1;
  
  public boolean equals(Object paramObject)
  {
    if (super.equals(paramObject)) {}
    do
    {
      return true;
      if (!(paramObject instanceof VipComicFavorEmoStructMsgInfo)) {
        break;
      }
      if ((TextUtils.isEmpty(this.picMd5)) || (TextUtils.isEmpty(this.actionData))) {
        return false;
      }
      paramObject = (VipComicFavorEmoStructMsgInfo)paramObject;
    } while ((this.picMd5.equalsIgnoreCase(paramObject.picMd5)) && (this.actionData.equals(paramObject.actionData)));
    return false;
    return false;
  }
  
  public String toString()
  {
    return "md5 = " + this.picMd5 + " , actionData = " + this.actionData + " , status = " + this.status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo
 * JD-Core Version:    0.7.0.1
 */