package org.jbox2d.pooling.normal;

import org.jbox2d.dynamics.contacts.CircleContact;
import org.jbox2d.dynamics.contacts.Contact;

class DefaultWorldPool$2
  extends MutableStack<Contact>
{
  DefaultWorldPool$2(DefaultWorldPool paramDefaultWorldPool, int paramInt)
  {
    super(paramInt);
  }
  
  protected Contact newInstance()
  {
    return new CircleContact(DefaultWorldPool.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.normal.DefaultWorldPool.2
 * JD-Core Version:    0.7.0.1
 */