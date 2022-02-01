package com.tencent.mobileqq.msg.api;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IMessageRecordEntityManager
  extends IRuntimeService
{
  public abstract EntityManager createMessageRecordEntityManager();
  
  public abstract List rawQuery(String paramString, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.IMessageRecordEntityManager
 * JD-Core Version:    0.7.0.1
 */