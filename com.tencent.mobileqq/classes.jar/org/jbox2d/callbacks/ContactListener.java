package org.jbox2d.callbacks;

import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.contacts.Contact;

public abstract interface ContactListener
{
  public abstract void beginContact(Contact paramContact);
  
  public abstract void endContact(Contact paramContact);
  
  public abstract void postSolve(Contact paramContact, ContactImpulse paramContactImpulse);
  
  public abstract void preSolve(Contact paramContact, Manifold paramManifold);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.callbacks.ContactListener
 * JD-Core Version:    0.7.0.1
 */