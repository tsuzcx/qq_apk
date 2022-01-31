package com.tencent.qphone.base.remote;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class IBaseService$Stub$Proxy
  implements IBaseService
{
  private IBinder mRemote;
  
  IBaseService$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.qphone.base.remote.IBaseService";
  }
  
  public int getMsfConnectedIPFamily()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int getMsfConnectedNetType()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int onProcessViewableChanged(boolean paramBoolean, long paramLong, String paramString)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      localParcel1.writeLong(paramLong);
      localParcel1.writeString(paramString);
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public FromServiceMsg sendSyncToServiceMsg(ToServiceMsg paramToServiceMsg)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
        if (paramToServiceMsg != null)
        {
          localParcel1.writeInt(1);
          paramToServiceMsg.writeToParcel(localParcel1, 0);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramToServiceMsg = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(localParcel2);
            return paramToServiceMsg;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramToServiceMsg = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public int sendToServiceMsg(ToServiceMsg paramToServiceMsg)
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 22
    //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +51 -> 67
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 56	android/os/Parcel:writeInt	(I)V
    //   24: aload_1
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 71	com/tencent/qphone/base/remote/ToServiceMsg:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_0
    //   31: getfield 15	com/tencent/qphone/base/remote/IBaseService$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   34: iconst_2
    //   35: aload_3
    //   36: aload 4
    //   38: iconst_0
    //   39: invokeinterface 40 5 0
    //   44: pop
    //   45: aload 4
    //   47: invokevirtual 43	android/os/Parcel:readException	()V
    //   50: aload 4
    //   52: invokevirtual 46	android/os/Parcel:readInt	()I
    //   55: istore_2
    //   56: aload 4
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 49	android/os/Parcel:recycle	()V
    //   65: iload_2
    //   66: ireturn
    //   67: aload_3
    //   68: iconst_0
    //   69: invokevirtual 56	android/os/Parcel:writeInt	(I)V
    //   72: goto -42 -> 30
    //   75: astore_1
    //   76: aload 4
    //   78: invokevirtual 49	android/os/Parcel:recycle	()V
    //   81: aload_3
    //   82: invokevirtual 49	android/os/Parcel:recycle	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	Proxy
    //   0	87	1	paramToServiceMsg	ToServiceMsg
    //   55	11	2	i	int
    //   3	79	3	localParcel1	Parcel
    //   7	70	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	75	finally
    //   19	30	75	finally
    //   30	56	75	finally
    //   67	72	75	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IBaseService.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */