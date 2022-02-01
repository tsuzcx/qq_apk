package com.tencent.wcdb;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.wcdb.support.Log;
import java.lang.reflect.Method;

public final class BulkCursorToCursorAdaptor
  extends AbstractWindowedCursor
{
  private AbstractCursor.SelfContentObserver h = new AbstractCursor.SelfContentObserver(this);
  private IBulkCursor i;
  private String[] j;
  private boolean k;
  private int l;
  
  private void f()
  {
    if (this.i != null) {
      return;
    }
    throw new StaleDataException("Attempted to access a cursor after it has been closed.");
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    f();
    try
    {
      if ((this.g != null) && (paramInt2 >= this.g.c()) && (paramInt2 < this.g.c() + this.g.d()))
      {
        if (this.k) {
          this.i.b(paramInt2);
        }
      }
      else {
        a(this.i.a(paramInt2));
      }
      return this.g != null;
    }
    catch (RemoteException localRemoteException)
    {
      label89:
      break label89;
    }
    Log.a("BulkCursor", "Unable to get window because the remote process is dead");
    return false;
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 81	com/tencent/wcdb/AbstractWindowedCursor:close	()V
    //   4: aload_0
    //   5: getfield 29	com/tencent/wcdb/BulkCursorToCursorAdaptor:i	Lcom/tencent/wcdb/IBulkCursor;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +36 -> 46
    //   13: aload_1
    //   14: invokeinterface 83 1 0
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 29	com/tencent/wcdb/BulkCursorToCursorAdaptor:i	Lcom/tencent/wcdb/IBulkCursor;
    //   24: return
    //   25: astore_1
    //   26: goto +13 -> 39
    //   29: ldc 71
    //   31: ldc 85
    //   33: invokestatic 87	com/tencent/wcdb/support/Log:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: goto -17 -> 19
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 29	com/tencent/wcdb/BulkCursorToCursorAdaptor:i	Lcom/tencent/wcdb/IBulkCursor;
    //   44: aload_1
    //   45: athrow
    //   46: return
    //   47: astore_1
    //   48: goto -19 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	BulkCursorToCursorAdaptor
    //   8	6	1	localIBulkCursor	IBulkCursor
    //   25	20	1	localObject	Object
    //   47	1	1	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   13	19	25	finally
    //   29	36	25	finally
    //   13	19	47	android/os/RemoteException
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public void deactivate()
  {
    super.deactivate();
    IBulkCursor localIBulkCursor = this.i;
    if (localIBulkCursor != null) {}
    try
    {
      localIBulkCursor.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      label20:
      break label20;
    }
    Log.b("BulkCursor", "Remote process exception when deactivating");
  }
  
  public IContentObserver e()
  {
    try
    {
      IContentObserver localIContentObserver = (IContentObserver)this.h.getClass().getMethod("getContentObserver", new Class[0]).invoke(this.h, new Object[0]);
      return localIContentObserver;
    }
    catch (Exception localException)
    {
      label33:
      break label33;
    }
    return null;
  }
  
  public String[] getColumnNames()
  {
    f();
    return this.j;
  }
  
  public int getCount()
  {
    f();
    return this.l;
  }
  
  public Bundle getExtras()
  {
    f();
    try
    {
      Bundle localBundle = this.i.c();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public boolean requery()
  {
    f();
    try
    {
      this.l = this.i.a(e());
      if (this.l != -1)
      {
        this.b = -1;
        d();
        super.requery();
        return true;
      }
      deactivate();
      return false;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to requery because the remote process exception ");
      localStringBuilder.append(localException.getMessage());
      Log.a("BulkCursor", localStringBuilder.toString());
      deactivate();
    }
    return false;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    f();
    try
    {
      paramBundle = this.i.a(paramBundle);
      return paramBundle;
    }
    catch (RemoteException paramBundle)
    {
      Log.b("BulkCursor", "respond() threw RemoteException, returning an empty bundle.", new Object[] { paramBundle });
    }
    return Bundle.EMPTY;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorToCursorAdaptor
 * JD-Core Version:    0.7.0.1
 */