package org.jbox2d.dynamics;

import org.jbox2d.callbacks.ContactFilter;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.callbacks.PairCallback;
import org.jbox2d.collision.broadphase.BroadPhase;
import org.jbox2d.collision.broadphase.BroadPhaseStrategy;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.contacts.ContactEdge;

public class ContactManager
  implements PairCallback
{
  public BroadPhase m_broadPhase;
  public int m_contactCount = 0;
  public ContactFilter m_contactFilter = new ContactFilter();
  public Contact m_contactList = null;
  public ContactListener m_contactListener = null;
  private final World pool;
  
  public ContactManager(World paramWorld, BroadPhaseStrategy paramBroadPhaseStrategy)
  {
    this.m_broadPhase = new BroadPhase(paramBroadPhaseStrategy);
    this.pool = paramWorld;
  }
  
  public void addPair(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (FixtureProxy)paramObject1;
    Object localObject1 = (FixtureProxy)paramObject2;
    paramObject2 = paramObject1.fixture;
    Fixture localFixture1 = ((FixtureProxy)localObject1).fixture;
    int i = paramObject1.childIndex;
    int j = ((FixtureProxy)localObject1).childIndex;
    localObject1 = paramObject2.getBody();
    Body localBody = localFixture1.getBody();
    if (localObject1 == localBody) {
      return;
    }
    for (paramObject1 = localBody.getContactList(); paramObject1 != null; paramObject1 = paramObject1.next) {
      if (paramObject1.other == localObject1)
      {
        localObject2 = paramObject1.contact.getFixtureA();
        Fixture localFixture2 = paramObject1.contact.getFixtureB();
        int k = paramObject1.contact.getChildIndexA();
        int m = paramObject1.contact.getChildIndexB();
        if ((localObject2 == paramObject2) && (k == i) && (localFixture2 == localFixture1) && (m == j)) {
          return;
        }
        if ((localObject2 == localFixture1) && (k == j) && (localFixture2 == paramObject2) && (m == i)) {
          return;
        }
      }
    }
    if (!localBody.shouldCollide((Body)localObject1)) {
      return;
    }
    paramObject1 = this.m_contactFilter;
    if ((paramObject1 != null) && (!paramObject1.shouldCollide(paramObject2, localFixture1))) {
      return;
    }
    paramObject1 = this.pool.popContact(paramObject2, i, localFixture1, j);
    if (paramObject1 == null) {
      return;
    }
    paramObject2 = paramObject1.getFixtureA();
    localFixture1 = paramObject1.getFixtureB();
    paramObject1.getChildIndexA();
    paramObject1.getChildIndexB();
    localObject1 = paramObject2.getBody();
    localBody = localFixture1.getBody();
    paramObject1.m_prev = null;
    Object localObject2 = this.m_contactList;
    paramObject1.m_next = ((Contact)localObject2);
    if (localObject2 != null) {
      ((Contact)localObject2).m_prev = paramObject1;
    }
    this.m_contactList = paramObject1;
    paramObject1.m_nodeA.contact = paramObject1;
    paramObject1.m_nodeA.other = localBody;
    paramObject1.m_nodeA.prev = null;
    paramObject1.m_nodeA.next = ((Body)localObject1).m_contactList;
    if (((Body)localObject1).m_contactList != null) {
      ((Body)localObject1).m_contactList.prev = paramObject1.m_nodeA;
    }
    ((Body)localObject1).m_contactList = paramObject1.m_nodeA;
    paramObject1.m_nodeB.contact = paramObject1;
    paramObject1.m_nodeB.other = ((Body)localObject1);
    paramObject1.m_nodeB.prev = null;
    paramObject1.m_nodeB.next = localBody.m_contactList;
    if (localBody.m_contactList != null) {
      localBody.m_contactList.prev = paramObject1.m_nodeB;
    }
    localBody.m_contactList = paramObject1.m_nodeB;
    if ((!paramObject2.isSensor()) && (!localFixture1.isSensor()))
    {
      ((Body)localObject1).setAwake(true);
      localBody.setAwake(true);
    }
    this.m_contactCount += 1;
  }
  
  public void collide()
  {
    Object localObject1 = this.m_contactList;
    while (localObject1 != null)
    {
      Object localObject2 = ((Contact)localObject1).getFixtureA();
      Fixture localFixture = ((Contact)localObject1).getFixtureB();
      int m = ((Contact)localObject1).getChildIndexA();
      int k = ((Contact)localObject1).getChildIndexB();
      Body localBody1 = ((Fixture)localObject2).getBody();
      Body localBody2 = localFixture.getBody();
      if ((((Contact)localObject1).m_flags & 0x8) == 8) {
        if (!localBody2.shouldCollide(localBody1))
        {
          localObject2 = ((Contact)localObject1).getNext();
          destroy((Contact)localObject1);
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        break;
        ContactFilter localContactFilter = this.m_contactFilter;
        if ((localContactFilter != null) && (!localContactFilter.shouldCollide((Fixture)localObject2, localFixture)))
        {
          localObject2 = ((Contact)localObject1).getNext();
          destroy((Contact)localObject1);
          localObject1 = localObject2;
        }
        else
        {
          ((Contact)localObject1).m_flags &= 0xFFFFFFF7;
          boolean bool = localBody1.isAwake();
          int j = 1;
          if ((bool) && (localBody1.m_type != BodyType.STATIC)) {
            i = 1;
          } else {
            i = 0;
          }
          if ((!localBody2.isAwake()) || (localBody2.m_type == BodyType.STATIC)) {
            j = 0;
          }
          if ((i == 0) && (j == 0))
          {
            localObject1 = ((Contact)localObject1).getNext();
            break;
          }
          int i = localObject2.m_proxies[m].proxyId;
          j = localFixture.m_proxies[k].proxyId;
          if (this.m_broadPhase.testOverlap(i, j)) {
            break label280;
          }
          localObject2 = ((Contact)localObject1).getNext();
          destroy((Contact)localObject1);
          localObject1 = localObject2;
        }
      }
      label280:
      ((Contact)localObject1).update(this.m_contactListener);
      localObject1 = ((Contact)localObject1).getNext();
    }
  }
  
  public void destroy(Contact paramContact)
  {
    Object localObject2 = paramContact.getFixtureA();
    Object localObject1 = paramContact.getFixtureB();
    localObject2 = ((Fixture)localObject2).getBody();
    localObject1 = ((Fixture)localObject1).getBody();
    if ((this.m_contactListener != null) && (paramContact.isTouching())) {
      this.m_contactListener.endContact(paramContact);
    }
    if (paramContact.m_prev != null) {
      paramContact.m_prev.m_next = paramContact.m_next;
    }
    if (paramContact.m_next != null) {
      paramContact.m_next.m_prev = paramContact.m_prev;
    }
    if (paramContact == this.m_contactList) {
      this.m_contactList = paramContact.m_next;
    }
    if (paramContact.m_nodeA.prev != null) {
      paramContact.m_nodeA.prev.next = paramContact.m_nodeA.next;
    }
    if (paramContact.m_nodeA.next != null) {
      paramContact.m_nodeA.next.prev = paramContact.m_nodeA.prev;
    }
    if (paramContact.m_nodeA == ((Body)localObject2).m_contactList) {
      ((Body)localObject2).m_contactList = paramContact.m_nodeA.next;
    }
    if (paramContact.m_nodeB.prev != null) {
      paramContact.m_nodeB.prev.next = paramContact.m_nodeB.next;
    }
    if (paramContact.m_nodeB.next != null) {
      paramContact.m_nodeB.next.prev = paramContact.m_nodeB.prev;
    }
    if (paramContact.m_nodeB == ((Body)localObject1).m_contactList) {
      ((Body)localObject1).m_contactList = paramContact.m_nodeB.next;
    }
    this.pool.pushContact(paramContact);
    this.m_contactCount -= 1;
  }
  
  public void findNewContacts()
  {
    this.m_broadPhase.updatePairs(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.ContactManager
 * JD-Core Version:    0.7.0.1
 */