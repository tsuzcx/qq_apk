package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class SubscriptionList
  implements Subscription
{
  private LinkedList<Subscription> subscriptions;
  private volatile boolean unsubscribed;
  
  public SubscriptionList() {}
  
  public SubscriptionList(Subscription paramSubscription)
  {
    this.subscriptions = new LinkedList();
    this.subscriptions.add(paramSubscription);
  }
  
  public SubscriptionList(Subscription... paramVarArgs)
  {
    this.subscriptions = new LinkedList(Arrays.asList(paramVarArgs));
  }
  
  private static void unsubscribeFromAll(Collection<Subscription> paramCollection)
  {
    if (paramCollection == null) {
      return;
    }
    Subscription localSubscription = null;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = localSubscription;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label68;
      }
      localSubscription = (Subscription)localIterator.next();
      try
      {
        localSubscription.unsubscribe();
      }
      catch (Throwable localThrowable)
      {
        if (paramCollection != null) {
          break label73;
        }
      }
    }
    paramCollection = new ArrayList();
    label68:
    label73:
    for (;;)
    {
      paramCollection.add(localThrowable);
      break;
      Exceptions.throwIfAny(paramCollection);
      return;
    }
  }
  
  public void add(Subscription paramSubscription)
  {
    if (paramSubscription.isUnsubscribed()) {
      return;
    }
    if (!this.unsubscribed) {
      try
      {
        if (!this.unsubscribed)
        {
          LinkedList localLinkedList2 = this.subscriptions;
          LinkedList localLinkedList1 = localLinkedList2;
          if (localLinkedList2 == null)
          {
            localLinkedList1 = new LinkedList();
            this.subscriptions = localLinkedList1;
          }
          localLinkedList1.add(paramSubscription);
          return;
        }
      }
      finally {}
    }
    paramSubscription.unsubscribe();
  }
  
  public void clear()
  {
    if (!this.unsubscribed) {}
    try
    {
      LinkedList localLinkedList = this.subscriptions;
      this.subscriptions = null;
      unsubscribeFromAll(localLinkedList);
      return;
    }
    finally {}
  }
  
  public boolean hasSubscriptions()
  {
    boolean bool2 = false;
    if (!this.unsubscribed)
    {
      boolean bool1 = bool2;
      try
      {
        if (!this.unsubscribed)
        {
          bool1 = bool2;
          if (this.subscriptions != null)
          {
            bool1 = bool2;
            if (!this.subscriptions.isEmpty()) {
              bool1 = true;
            }
          }
        }
        return bool1;
      }
      finally {}
    }
    return false;
  }
  
  public boolean isUnsubscribed()
  {
    return this.unsubscribed;
  }
  
  public void remove(Subscription paramSubscription)
  {
    if (!this.unsubscribed) {
      try
      {
        LinkedList localLinkedList = this.subscriptions;
        if ((this.unsubscribed) || (localLinkedList == null)) {
          return;
        }
        boolean bool = localLinkedList.remove(paramSubscription);
        if (bool)
        {
          paramSubscription.unsubscribe();
          return;
        }
      }
      finally {}
    }
  }
  
  public void unsubscribe()
  {
    if (!this.unsubscribed) {
      try
      {
        if (this.unsubscribed) {
          return;
        }
        this.unsubscribed = true;
        LinkedList localLinkedList = this.subscriptions;
        this.subscriptions = null;
        unsubscribeFromAll(localLinkedList);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.SubscriptionList
 * JD-Core Version:    0.7.0.1
 */