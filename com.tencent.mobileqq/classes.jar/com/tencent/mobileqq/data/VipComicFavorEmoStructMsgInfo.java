package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="picMd5")
public class VipComicFavorEmoStructMsgInfo
  extends Entity
{
  public static final int init = 1;
  public static final int updated = 2;
  public String actionData;
  public String picMd5;
  public int status = 1;
  
  public boolean equals(Object paramObject)
  {
    if (super.equals(paramObject)) {
      return true;
    }
    if (((paramObject instanceof VipComicFavorEmoStructMsgInfo)) && (!TextUtils.isEmpty(this.picMd5)))
    {
      if (TextUtils.isEmpty(this.actionData)) {
        return false;
      }
      paramObject = (VipComicFavorEmoStructMsgInfo)paramObject;
      if ((this.picMd5.equalsIgnoreCase(paramObject.picMd5)) && (this.actionData.equals(paramObject.actionData))) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("md5 = ");
    localStringBuilder.append(this.picMd5);
    localStringBuilder.append(" , actionData = ");
    localStringBuilder.append(this.actionData);
    localStringBuilder.append(" , status = ");
    localStringBuilder.append(this.status);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo
 * JD-Core Version:    0.7.0.1
 */