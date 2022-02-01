package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

public abstract interface IFindRemovedEntity<T extends Entity>
{
  public abstract Entity a(EntityManager paramEntityManager, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity
 * JD-Core Version:    0.7.0.1
 */