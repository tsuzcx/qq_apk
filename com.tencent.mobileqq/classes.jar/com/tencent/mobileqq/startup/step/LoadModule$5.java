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
      paramEntity = (MessageRecord)paramEntity;
      String str = paramEntity.getTableName();
      StringBuilder localStringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
      localStringBuilder.append(str);
      localStringBuilder.append("_idx");
      localStringBuilder.append(" ON ");
      localStringBuilder.append(str);
      int i = paramEntity.istroop;
      if ((i != 1) && (i != 3000) && (i != 10014)) {
        paramEntity = "time";
      } else {
        paramEntity = "shmsgseq";
      }
      localStringBuilder.append("(");
      localStringBuilder.append(paramEntity);
      localStringBuilder.append(", _id)");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public Class[] getNeedPrivateFieldsClass()
  {
    return new Class[] { RecentUser.class };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadModule.5
 * JD-Core Version:    0.7.0.1
 */