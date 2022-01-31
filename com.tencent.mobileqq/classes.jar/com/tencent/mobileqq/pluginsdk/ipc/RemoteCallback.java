package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface RemoteCallback
  extends IInterface
{
  public abstract void onRemoteCallback(Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements RemoteCallback
  {
    static final int a = 1;
    private static final String b = "com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback";
    
    public Stub()
    {
      attachInterface(this, "com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback");
    }
    
    public static RemoteCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback");
      if ((localIInterface != null) && ((localIInterface instanceof RemoteCallback))) {
        return (RemoteCallback)localIInterface;
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
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onRemoteCallback(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    private static class a
      implements RemoteCallback
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public String a()
      {
        return "com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback";
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      /* Error */
      public void onRemoteCallback(Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 22
        //   11: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 48	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/tencent/mobileqq/pluginsdk/ipc/RemoteCallback$Stub$a:a	Landroid/os/IBinder;
        //   33: iconst_1
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 54 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 57	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 60	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 60	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore_1
        //   65: aload_3
        //   66: invokevirtual 60	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 60	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	a
        //   0	75	1	paramBundle	Bundle
        //   3	67	2	localParcel1	Parcel
        //   7	59	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	64	finally
        //   18	29	64	finally
        //   29	47	64	finally
        //   56	61	64	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback
 * JD-Core Version:    0.7.0.1
 */