package com.tencent.timi.game.databasecore.impl.test;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import java.util.Arrays;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="uid,openid")
public class TestYesEntity
  extends BaseTimiGameEntity
{
  public byte[] data;
  public String openid;
  public int testValue;
  public String uid;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TestYesEntity{uid='");
    localStringBuilder.append(this.uid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", openid=");
    localStringBuilder.append(this.openid);
    localStringBuilder.append(", testValue='");
    localStringBuilder.append(this.testValue);
    localStringBuilder.append('\'');
    localStringBuilder.append(", data=");
    localStringBuilder.append(Arrays.toString(this.data));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.databasecore.impl.test.TestYesEntity
 * JD-Core Version:    0.7.0.1
 */