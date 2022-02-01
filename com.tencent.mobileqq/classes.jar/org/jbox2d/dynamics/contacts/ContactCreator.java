package org.jbox2d.dynamics.contacts;

import org.jbox2d.dynamics.Fixture;
import org.jbox2d.pooling.IWorldPool;

public abstract interface ContactCreator
{
  public abstract Contact contactCreateFcn(IWorldPool paramIWorldPool, Fixture paramFixture1, Fixture paramFixture2);
  
  public abstract void contactDestroyFcn(IWorldPool paramIWorldPool, Contact paramContact);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.contacts.ContactCreator
 * JD-Core Version:    0.7.0.1
 */