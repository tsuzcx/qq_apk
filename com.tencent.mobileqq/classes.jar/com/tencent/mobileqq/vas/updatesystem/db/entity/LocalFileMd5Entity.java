package com.tencent.mobileqq.vas.updatesystem.db.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class LocalFileMd5Entity
  extends Entity
{
  public static final String TABLE_NAME = LocalFileMd5Entity.class.getSimpleName();
  public String mContent;
  @unique
  public String mItemId;
  
  public String toString()
  {
    return "LocalFileMd5Entity{itemId='" + this.mItemId + '\'' + ", mContent='" + this.mContent + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.db.entity.LocalFileMd5Entity
 * JD-Core Version:    0.7.0.1
 */