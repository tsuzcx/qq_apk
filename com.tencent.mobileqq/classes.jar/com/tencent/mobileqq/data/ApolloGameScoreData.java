package com.tencent.mobileqq.data;

import awge;
import awhp;
import awhs;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.ABORT, columnNames="mGameId,mUin")
public class ApolloGameScoreData
  extends awge
{
  @awhp
  public boolean mFromDb = true;
  @awhs
  public int mGameId;
  public int mScore;
  public String mUin;
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof ApolloGameScoreData)) && (((ApolloGameScoreData)paramObject).mGameId == this.mGameId) && (this.mUin.equals(((ApolloGameScoreData)paramObject).mUin));
  }
  
  public String toString()
  {
    return this.mUin + " " + this.mGameId + " " + this.mScore;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloGameScoreData
 * JD-Core Version:    0.7.0.1
 */