package com.tencent.mobileqq.vas.updatesystem.db.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ShouldUpdateEntity
  extends Entity
{
  public static final String TABLE_NAME = ShouldUpdateEntity.class.getSimpleName();
  public String mContent;
  @unique
  public String mItemId;
  
  public String toString()
  {
    return "ShouldUpdateEntity{itemId='" + this.mItemId + '\'' + ", mContent='" + this.mContent + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.db.entity.ShouldUpdateEntity
 * JD-Core Version:    0.7.0.1
 */