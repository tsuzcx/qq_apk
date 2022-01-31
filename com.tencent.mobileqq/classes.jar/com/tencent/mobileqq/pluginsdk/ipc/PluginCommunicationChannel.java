package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface PluginCommunicationChannel
  extends IInterface
{
  public abstract String getNickName()
    throws RemoteException;
  
  public abstract String getSKey()
    throws RemoteException;
  
  public abstract String getSid()
    throws RemoteException;
  
  public abstract long getUin()
    throws RemoteException;
  
  public abstract Bundle transfer(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void transferAsync(String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements PluginCommunicationChannel
  {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = 4;
    static final int e = 5;
    static final int f = 6;
    private static final String g = "com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel";
    
    public Stub()
    {
      attachInterface(this, "com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
    }
    
    public static PluginCommunicationChannel asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
      if ((localIInterface != null) && ((localIInterface instanceof PluginCommunicationChannel))) {
        return (PluginCommunicationChannel)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      String str1 = null;
      Object localObject = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        long l = getUin();
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        paramParcel1 = getNickName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        paramParcel1 = getSKey();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        paramParcel1 = getSid();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = transfer(str1, (Bundle)localObject);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
      String str2 = paramParcel1.readString();
      localObject = str1;
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      transferAsync(str2, (Bundle)localObject, RemoteCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class a
      implements PluginCommunicationChannel
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public String a()
      {
        return "com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel";
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public String getNickName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getSKey()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
          this.a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getSid()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
          this.a.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public long getUin()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public Bundle transfer(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
            localParcel1.writeString(paramString);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.a.transact(5, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramString = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramString;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void transferAsync(String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
            localParcel1.writeString(paramString);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              if (paramRemoteCallback != null)
              {
                paramString = paramRemoteCallback.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.a.transact(6, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
 * JD-Core Version:    0.7.0.1
 */