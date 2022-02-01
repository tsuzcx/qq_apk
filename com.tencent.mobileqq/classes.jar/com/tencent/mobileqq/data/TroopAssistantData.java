package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class TroopAssistantData
  extends Entity
  implements TroopAssistantDataStub
{
  public long lastdrafttime;
  public long lastmsgtime;
  @unique
  public String troopUin;
  
  public long getLastdrafttime()
  {
    return this.lastdrafttime;
  }
  
  public long getLastmsgtime()
  {
    return this.lastmsgtime;
  }
  
  public String getTroopUin()
  {
    return this.troopUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopAssistantData
 * JD-Core Version:    0.7.0.1
 */