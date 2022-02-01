package org.jbox2d.pooling.normal;

import org.jbox2d.dynamics.contacts.ChainAndCircleContact;
import org.jbox2d.dynamics.contacts.Contact;

class DefaultWorldPool$6
  extends MutableStack<Contact>
{
  DefaultWorldPool$6(DefaultWorldPool paramDefaultWorldPool, int paramInt)
  {
    super(paramInt);
  }
  
  protected Contact newInstance()
  {
    return new ChainAndCircleContact(DefaultWorldPool.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.normal.DefaultWorldPool.6
 * JD-Core Version:    0.7.0.1
 */