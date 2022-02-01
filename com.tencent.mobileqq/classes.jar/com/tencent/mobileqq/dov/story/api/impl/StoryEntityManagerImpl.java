package com.tencent.mobileqq.dov.story.api.impl;

import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.mobileqq.dov.story.api.IStoryEntityManager;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class StoryEntityManagerImpl
  implements IStoryEntityManager
{
  public EntityManager createEntityManager()
  {
    QQStoryEntityManagerFactory localQQStoryEntityManagerFactory = new QQStoryEntityManagerFactory(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
    localQQStoryEntityManagerFactory.verifyAuthentication();
    return localQQStoryEntityManagerFactory.createEntityManager();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dov.story.api.impl.StoryEntityManagerImpl
 * JD-Core Version:    0.7.0.1
 */