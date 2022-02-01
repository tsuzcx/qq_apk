package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class InterestLabelInfo
  extends Entity
  implements Cloneable
{
  public static final String TABLE_NAME = "InterestLabelInfo";
  @unique
  public int mInterestLabelID;
  public String mInterestLabelNme;
  public boolean mIsDefault;
  
  public InterestLabelInfo clone()
  {
    try
    {
      InterestLabelInfo localInterestLabelInfo = (InterestLabelInfo)super.clone();
      return localInterestLabelInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.InterestLabelInfo
 * JD-Core Version:    0.7.0.1
 */