package com.tencent.wcdb;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;

final class CursorToBulkCursorAdaptor$ContentObserverProxy
  extends ContentObserver
{
  protected IContentObserver a;
  
  public CursorToBulkCursorAdaptor$ContentObserverProxy(IContentObserver paramIContentObserver, IBinder.DeathRecipient paramDeathRecipient)
  {
    super(null);
    this.a = paramIContentObserver;
    try
    {
      paramIContentObserver.asBinder().linkToDeath(paramDeathRecipient, 0);
      return;
    }
    catch (RemoteException paramIContentObserver) {}
  }
  
  public boolean a(IBinder.DeathRecipient paramDeathRecipient)
  {
    return this.a.asBinder().unlinkToDeath(paramDeathRecipient, 0);
  }
  
  public boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    try
    {
      this.a.a(paramBoolean, paramUri);
      return;
    }
    catch (RemoteException paramUri) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.CursorToBulkCursorAdaptor.ContentObserverProxy
 * JD-Core Version:    0.7.0.1
 */