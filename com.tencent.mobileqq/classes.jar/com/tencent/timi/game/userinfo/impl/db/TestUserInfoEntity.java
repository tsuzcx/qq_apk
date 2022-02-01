package com.tencent.timi.game.userinfo.impl.db;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import java.util.Arrays;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="testkey1,testkey2")
public class TestUserInfoEntity
  extends BaseTimiGameEntity
{
  public byte[] data;
  public String testkey1;
  public String testkey2;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TestUserInfoEnrity{testkey1='");
    localStringBuilder.append(this.testkey1);
    localStringBuilder.append('\'');
    localStringBuilder.append(", testkey2=");
    localStringBuilder.append(this.testkey2);
    localStringBuilder.append(", data=");
    localStringBuilder.append(Arrays.toString(this.data));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.db.TestUserInfoEntity
 * JD-Core Version:    0.7.0.1
 */