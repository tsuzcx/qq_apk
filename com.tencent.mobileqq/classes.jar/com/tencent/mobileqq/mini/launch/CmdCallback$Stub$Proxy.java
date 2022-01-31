package com.tencent.mobileqq.mini.launch;

import android.os.IBinder;

class CmdCallback$Stub$Proxy
  implements CmdCallback
{
  private IBinder mRemote;
  
  CmdCallback$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.mobileqq.mini.launch.CmdCallback";
  }
  
  /* Error */
  public void onCmdResult(boolean paramBoolean, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 22
    //   16: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: iload_1
    //   20: ifeq +58 -> 78
    //   23: aload 4
    //   25: iload_3
    //   26: invokevirtual 38	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: ifnull +53 -> 83
    //   33: aload 4
    //   35: iconst_1
    //   36: invokevirtual 38	android/os/Parcel:writeInt	(I)V
    //   39: aload_2
    //   40: aload 4
    //   42: iconst_0
    //   43: invokevirtual 44	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 15	com/tencent/mobileqq/mini/launch/CmdCallback$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   50: iconst_1
    //   51: aload 4
    //   53: aload 5
    //   55: iconst_0
    //   56: invokeinterface 50 5 0
    //   61: pop
    //   62: aload 5
    //   64: invokevirtual 53	android/os/Parcel:readException	()V
    //   67: aload 5
    //   69: invokevirtual 56	android/os/Parcel:recycle	()V
    //   72: aload 4
    //   74: invokevirtual 56	android/os/Parcel:recycle	()V
    //   77: return
    //   78: iconst_0
    //   79: istore_3
    //   80: goto -57 -> 23
    //   83: aload 4
    //   85: iconst_0
    //   86: invokevirtual 38	android/os/Parcel:writeInt	(I)V
    //   89: goto -43 -> 46
    //   92: astore_2
    //   93: aload 5
    //   95: invokevirtual 56	android/os/Parcel:recycle	()V
    //   98: aload 4
    //   100: invokevirtual 56	android/os/Parcel:recycle	()V
    //   103: aload_2
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	Proxy
    //   0	105	1	paramBoolean	boolean
    //   0	105	2	paramBundle	android.os.Bundle
    //   1	79	3	i	int
    //   5	94	4	localParcel1	android.os.Parcel
    //   10	84	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	92	finally
    //   23	29	92	finally
    //   33	46	92	finally
    //   46	67	92	finally
    //   83	89	92	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.CmdCallback.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */