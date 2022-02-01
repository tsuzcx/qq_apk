package com.tencent.mobileqq.vas.updatesystem.db.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class LocalUpdateEntity
  extends Entity
{
  public static final String TABLE_NAME = "LocalUpdateEntity";
  public String mContent;
  @unique
  public String mItemId;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalUpdateEntity{itemId='");
    localStringBuilder.append(this.mItemId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContent='");
    localStringBuilder.append(this.mContent);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.db.entity.LocalUpdateEntity
 * JD-Core Version:    0.7.0.1
 */