package com.tencent.wcdb;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class BulkCursorNative
  extends Binder
  implements IBulkCursor
{
  public BulkCursorNative()
  {
    attachInterface(this, "android.content.IBulkCursor");
  }
  
  public static IBulkCursor a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IBulkCursor localIBulkCursor = (IBulkCursor)paramIBinder.queryLocalInterface("android.content.IBulkCursor");
    if (localIBulkCursor != null) {
      return localIBulkCursor;
    }
    return new BulkCursorProxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      break;
    case 7: 
    case 6: 
    case 5: 
    case 4: 
    case 3: 
    case 2: 
    case 1: 
      try
      {
        paramParcel1.enforceInterface("android.content.IBulkCursor");
        b();
        paramParcel2.writeNoException();
        return true;
      }
      catch (Exception paramParcel1)
      {
        DatabaseUtils.a(paramParcel2, paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = a(paramParcel1.readBundle(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeBundle(paramParcel1);
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = c();
      paramParcel2.writeNoException();
      paramParcel2.writeBundle(paramParcel1);
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      b(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramInt1 = a(IContentObserver.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      paramParcel2.writeBundle(c());
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      a();
      paramParcel2.writeNoException();
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 == null)
      {
        paramParcel2.writeInt(0);
        return true;
      }
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorNative
 * JD-Core Version:    0.7.0.1
 */