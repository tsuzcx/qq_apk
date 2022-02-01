package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="frienduin")
public class NewBeancurdMsg
  extends Entity
{
  public String busiUuid;
  public long busiid;
  public String extensionInfoStr;
  public String frienduin;
  
  public String toString()
  {
    return String.format(" busiid:%d,frienduin:%s,busi_uuid:%s,extensionInfoStr:%s", new Object[] { Long.valueOf(this.busiid), this.frienduin, this.busiUuid, this.extensionInfoStr });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.NewBeancurdMsg
 * JD-Core Version:    0.7.0.1
 */