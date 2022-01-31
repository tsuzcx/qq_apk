package com.tencent.mobileqq.data;

import aukm;
import aulx;
import auma;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.ABORT, columnNames="mGameId,mUin")
public class ApolloGameScoreData
  extends aukm
{
  @aulx
  public boolean mFromDb = true;
  @auma
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloGameScoreData
 * JD-Core Version:    0.7.0.1
 */