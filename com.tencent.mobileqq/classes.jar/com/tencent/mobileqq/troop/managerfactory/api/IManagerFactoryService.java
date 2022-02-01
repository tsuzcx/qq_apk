package com.tencent.mobileqq.troop.managerfactory.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

@Service(process={""})
public abstract interface IManagerFactoryService
  extends IRuntimeService
{
  public abstract <T extends Manager> T getManager(Class<T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.managerfactory.api.IManagerFactoryService
 * JD-Core Version:    0.7.0.1
 */