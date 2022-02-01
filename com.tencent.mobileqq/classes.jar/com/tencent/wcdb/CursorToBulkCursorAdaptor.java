package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IBinder.DeathRecipient;

public final class CursorToBulkCursorAdaptor
  extends BulkCursorNative
  implements IBinder.DeathRecipient
{
  private final Object a;
  private final String b;
  private CursorToBulkCursorAdaptor.ContentObserverProxy c;
  private CrossProcessCursor d;
  private CursorWindow e;
  
  private void b(IContentObserver paramIContentObserver)
  {
    if (this.c == null)
    {
      this.c = new CursorToBulkCursorAdaptor.ContentObserverProxy(paramIContentObserver, this);
      this.d.registerContentObserver(this.c);
      return;
    }
    throw new IllegalStateException("an observer is already registered");
  }
  
  private void d()
  {
    CursorWindow localCursorWindow = this.e;
    if (localCursorWindow != null)
    {
      localCursorWindow.close();
      this.e = null;
    }
  }
  
  private void e()
  {
    if (this.d != null)
    {
      g();
      this.d.close();
      this.d = null;
    }
    d();
  }
  
  private void f()
  {
    if (this.d != null) {
      return;
    }
    throw new StaleDataException("Attempted to access a cursor after it has been closed.");
  }
  
  private void g()
  {
    CursorToBulkCursorAdaptor.ContentObserverProxy localContentObserverProxy = this.c;
    if (localContentObserverProxy != null)
    {
      this.d.unregisterContentObserver(localContentObserverProxy);
      this.c.a(this);
      this.c = null;
    }
  }
  
  public int a(IContentObserver paramIContentObserver)
  {
    synchronized (this.a)
    {
      f();
      d();
      try
      {
        boolean bool = this.d.requery();
        if (!bool) {
          return -1;
        }
        g();
        b(paramIContentObserver);
        int i = this.d.getCount();
        return i;
      }
      catch (IllegalStateException paramIContentObserver)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b);
        localStringBuilder.append(" Requery misuse db, mCursor isClosed:");
        localStringBuilder.append(this.d.isClosed());
        throw new IllegalStateException(localStringBuilder.toString(), paramIContentObserver);
      }
    }
  }
  
  public Bundle a(Bundle paramBundle)
  {
    synchronized (this.a)
    {
      f();
      paramBundle = this.d.respond(paramBundle);
      return paramBundle;
    }
  }
  
  public CursorWindow a(int paramInt)
  {
    synchronized (this.a)
    {
      f();
      if (!this.d.moveToPosition(paramInt))
      {
        d();
        return null;
      }
      Object localObject1 = this.d.a();
      if (localObject1 != null)
      {
        d();
      }
      else
      {
        CursorWindow localCursorWindow = this.e;
        if (localCursorWindow == null)
        {
          this.e = new CursorWindow(this.b);
          localObject1 = this.e;
        }
        else if (paramInt >= localCursorWindow.c())
        {
          localObject1 = localCursorWindow;
          if (paramInt < localCursorWindow.c() + localCursorWindow.d()) {}
        }
        else
        {
          localCursorWindow.b();
          localObject1 = localCursorWindow;
        }
        this.d.a(paramInt, (CursorWindow)localObject1);
      }
      if (localObject1 != null) {
        ((CursorWindow)localObject1).h();
      }
      return localObject1;
    }
  }
  
  public void a()
  {
    synchronized (this.a)
    {
      if (this.d != null)
      {
        g();
        this.d.deactivate();
      }
      d();
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.a)
    {
      e();
      return;
    }
  }
  
  public void b(int paramInt)
  {
    synchronized (this.a)
    {
      f();
      this.d.a(this.d.getPosition(), paramInt);
      return;
    }
  }
  
  public void binderDied()
  {
    synchronized (this.a)
    {
      e();
      return;
    }
  }
  
  public Bundle c()
  {
    synchronized (this.a)
    {
      f();
      Bundle localBundle = this.d.getExtras();
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.CursorToBulkCursorAdaptor
 * JD-Core Version:    0.7.0.1
 */