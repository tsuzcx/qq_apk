package com.tencent.wcdb;

import android.database.ContentObserver;
import java.lang.ref.WeakReference;

public class AbstractCursor$SelfContentObserver
  extends ContentObserver
{
  WeakReference<AbstractCursor> a;
  
  public AbstractCursor$SelfContentObserver(AbstractCursor paramAbstractCursor)
  {
    super(null);
    this.a = new WeakReference(paramAbstractCursor);
  }
  
  public boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public void onChange(boolean paramBoolean)
  {
    AbstractCursor localAbstractCursor = (AbstractCursor)this.a.get();
    if (localAbstractCursor != null) {
      localAbstractCursor.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.AbstractCursor.SelfContentObserver
 * JD-Core Version:    0.7.0.1
 */