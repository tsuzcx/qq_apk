package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="mTag, mDetail")
public class Reporting
  extends Entity
  implements Cloneable
{
  public int mCount;
  public String mDetail;
  public int mDetailHashCode;
  public int mLockedCount;
  public int mSeqKey;
  public String mTag;
  
  public Reporting clone()
  {
    try
    {
      Reporting localReporting = (Reporting)super.clone();
      return localReporting;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.Reporting
 * JD-Core Version:    0.7.0.1
 */