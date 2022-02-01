package com.tencent.mobileqq.profilecard.entity;

import java.io.Serializable;

public class ProfileLabelInfo
  implements Serializable, Cloneable
{
  public static int STATUS_CHECKED = 1;
  public static int STATUS_NORMAL;
  public Long labelId;
  public String labelName;
  public int labelStatus = STATUS_NORMAL;
  public Long likeNum;
  public String typeId;
  
  public ProfileLabelInfo() {}
  
  public ProfileLabelInfo(Long paramLong1, Long paramLong2, String paramString)
  {
    this.labelId = paramLong1;
    this.labelName = paramString;
    this.likeNum = paramLong2;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return this;
  }
  
  public void toggleStatus()
  {
    int i = this.labelStatus;
    int j = STATUS_NORMAL;
    if (i == j)
    {
      this.labelStatus = STATUS_CHECKED;
      return;
    }
    if (i == STATUS_CHECKED) {
      this.labelStatus = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo
 * JD-Core Version:    0.7.0.1
 */