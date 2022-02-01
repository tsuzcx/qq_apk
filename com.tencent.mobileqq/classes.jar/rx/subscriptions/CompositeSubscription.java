package rx.subscriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class CompositeSubscription
  implements Subscription
{
  private Set<Subscription> subscriptions;
  private volatile boolean unsubscribed;
  
  public CompositeSubscription() {}
  
  public CompositeSubscription(Subscription... paramVarArgs)
  {
    this.subscriptions = new HashSet(Arrays.asList(paramVarArgs));
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
          if (this.subscriptions == null) {
            this.subscriptions = new HashSet(4);
          }
          this.subscriptions.add(paramSubscription);
          return;
        }
      }
      finally {}
    }
    paramSubscription.unsubscribe();
  }
  
  public void clear()
  {
    if (!this.unsubscribed) {
      try
      {
        if ((this.unsubscribed) || (this.subscriptions == null)) {
          return;
        }
        Set localSet = this.subscriptions;
        this.subscriptions = null;
        unsubscribeFromAll(localSet);
        return;
      }
      finally {}
    }
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
        if ((this.unsubscribed) || (this.subscriptions == null)) {
          return;
        }
        boolean bool = this.subscriptions.remove(paramSubscription);
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
        Set localSet = this.subscriptions;
        this.subscriptions = null;
        unsubscribeFromAll(localSet);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.subscriptions.CompositeSubscription
 * JD-Core Version:    0.7.0.1
 */