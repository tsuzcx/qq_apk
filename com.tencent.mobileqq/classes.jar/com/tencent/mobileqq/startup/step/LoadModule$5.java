package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.proxy.db.TableBuilderProxy.Proxy;
import com.tencent.mobileqq.persistence.Entity;

final class LoadModule$5
  implements TableBuilderProxy.Proxy
{
  public String createIndexSQLStatement(Entity paramEntity)
  {
    if ((paramEntity instanceof MessageRecord))
    {
      MessageRecord localMessageRecord = (MessageRecord)paramEntity;
      paramEntity = localMessageRecord.getTableName();
      StringBuilder localStringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
      localStringBuilder.append(paramEntity).append("_idx");
      localStringBuilder.append(" ON ");
      localStringBuilder.append(paramEntity);
      paramEntity = "time";
      switch (localMessageRecord.istroop)
      {
      }
      for (;;)
      {
        localStringBuilder.append("(").append(paramEntity).append(", _id)");
        return localStringBuilder.toString();
        paramEntity = "shmsgseq";
      }
    }
    return null;
  }
  
  public Class[] getNeedPrivateFieldsClass()
  {
    return new Class[] { RecentUser.class };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadModule.5
 * JD-Core Version:    0.7.0.1
 */