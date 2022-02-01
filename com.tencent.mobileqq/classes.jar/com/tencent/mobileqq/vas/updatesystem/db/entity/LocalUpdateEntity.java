package com.tencent.mobileqq.vas.updatesystem.db.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class LocalUpdateEntity
  extends Entity
{
  public static final String TABLE_NAME = LocalUpdateEntity.class.getSimpleName();
  public String mContent;
  @unique
  public String mItemId;
  
  public String toString()
  {
    return "LocalUpdateEntity{itemId='" + this.mItemId + '\'' + ", mContent='" + this.mContent + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.db.entity.LocalUpdateEntity
 * JD-Core Version:    0.7.0.1
 */