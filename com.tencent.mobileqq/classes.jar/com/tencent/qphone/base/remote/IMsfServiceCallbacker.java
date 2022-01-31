package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IMsfServiceCallbacker
  extends IInterface
{
  public abstract void onRecvPushResp(FromServiceMsg paramFromServiceMsg)
    throws RemoteException;
  
  public abstract void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IMsfServiceCallbacker
  {
    private static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IMsfServiceCallbacker";
    static final int TRANSACTION_onRecvPushResp = 2;
    static final int TRANSACTION_onResponse = 1;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.qphone.base.remote.IMsfServiceCallbacker");
    }
    
    public static IMsfServiceCallbacker asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
      if ((localIInterface != null) && ((localIInterface instanceof IMsfServiceCallbacker))) {
        return (IMsfServiceCallbacker)localIInterface;
      }
      return new Proxy(paramIBinder);
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
        paramParcel2.writeString("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
        ToServiceMsg localToServiceMsg;
        if (paramParcel1.readInt() != 0)
        {
          localToServiceMsg = (ToServiceMsg)ToServiceMsg.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label120;
          }
        }
        label120:
        for (paramParcel1 = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onResponse(localToServiceMsg, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localToServiceMsg = null;
          break;
        }
      }
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onRecvPushResp(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    private static class Proxy
      implements IMsfServiceCallbacker
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.qphone.base.remote.IMsfServiceCallbacker";
      }
      
      /* Error */
      public void onRecvPushResp(FromServiceMsg paramFromServiceMsg)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 26
        //   11: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 50	com/tencent/qphone/base/remote/FromServiceMsg:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 19	com/tencent/qphone/base/remote/IMsfServiceCallbacker$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   33: iconst_2
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 56 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 59	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 62	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 62	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore_1
        //   65: aload_3
        //   66: invokevirtual 62	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 62	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	Proxy
        //   0	75	1	paramFromServiceMsg	FromServiceMsg
        //   3	67	2	localParcel1	Parcel
        //   7	59	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	64	finally
        //   18	29	64	finally
        //   29	47	64	finally
        //   56	61	64	finally
      }
      
      public void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
            if (paramToServiceMsg != null)
            {
              localParcel1.writeInt(1);
              paramToServiceMsg.writeToParcel(localParcel1, 0);
              if (paramFromServiceMsg != null)
              {
                localParcel1.writeInt(1);
                paramFromServiceMsg.writeToParcel(localParcel1, 0);
                this.mRemote.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
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
 * Qualified Name:     com.tencent.qphone.base.remote.IMsfServiceCallbacker
 * JD-Core Version:    0.7.0.1
 */