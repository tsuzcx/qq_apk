package eipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface EIPCChannel
  extends IInterface
{
  public abstract EIPCResult async(String paramString1, String paramString2, Bundle paramBundle, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void callback(int paramInt, EIPCResult paramEIPCResult)
    throws RemoteException;
  
  public abstract String getProcName()
    throws RemoteException;
  
  public abstract int setClient(String paramString, int paramInt1, EIPCChannel paramEIPCChannel, int paramInt2)
    throws RemoteException;
  
  public abstract IBinder setStubBinder(int paramInt, IBinder paramIBinder)
    throws RemoteException;
  
  public abstract EIPCResult sync(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements EIPCChannel
  {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = 4;
    static final int e = 5;
    static final int f = 6;
    private static final String g = "eipc.EIPCChannel";
    
    public Stub()
    {
      attachInterface(this, "eipc.EIPCChannel");
    }
    
    public static EIPCChannel asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("eipc.EIPCChannel");
      if ((localIInterface != null) && ((localIInterface instanceof EIPCChannel))) {
        return (EIPCChannel)localIInterface;
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
      String str1 = null;
      Object localObject = null;
      String str2;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("eipc.EIPCChannel");
        return true;
      case 1: 
        paramParcel1.enforceInterface("eipc.EIPCChannel");
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = sync(str1, str2, (Bundle)localObject, paramParcel1.readInt());
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
      case 2: 
        paramParcel1.enforceInterface("eipc.EIPCChannel");
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = async(str1, str2, (Bundle)localObject, paramParcel1.readInt(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label258;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          localObject = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 3: 
        paramParcel1.enforceInterface("eipc.EIPCChannel");
        paramParcel1 = getProcName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("eipc.EIPCChannel");
        paramInt1 = setClient(paramParcel1.readString(), paramParcel1.readInt(), asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        label258:
        paramParcel1.enforceInterface("eipc.EIPCChannel");
        paramParcel1 = setStubBinder(paramParcel1.readInt(), paramParcel1.readStrongBinder());
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("eipc.EIPCChannel");
      paramInt1 = paramParcel1.readInt();
      localObject = str1;
      if (paramParcel1.readInt() != 0) {
        localObject = (EIPCResult)EIPCResult.CREATOR.createFromParcel(paramParcel1);
      }
      callback(paramInt1, (EIPCResult)localObject);
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class Proxy
      implements EIPCChannel
    {
      private IBinder a;
      
      Proxy(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public EIPCResult async(String paramString1, String paramString2, Bundle paramBundle, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("eipc.EIPCChannel");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt1);
              localParcel1.writeInt(paramInt2);
              this.a.transact(2, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramString1 = (EIPCResult)EIPCResult.CREATOR.createFromParcel(localParcel2);
                return paramString1;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void callback(int paramInt, EIPCResult paramEIPCResult)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 34
        //   12: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   20: aload_2
        //   21: ifnull +45 -> 66
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 83	eipc/EIPCResult:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 19	eipc/EIPCChannel$Stub$Proxy:a	Landroid/os/IBinder;
        //   39: bipush 6
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 57 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 60	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 79	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 79	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aload_3
        //   67: iconst_0
        //   68: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   71: goto -36 -> 35
        //   74: astore_2
        //   75: aload 4
        //   77: invokevirtual 79	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 79	android/os/Parcel:recycle	()V
        //   84: aload_2
        //   85: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	86	0	this	Proxy
        //   0	86	1	paramInt	int
        //   0	86	2	paramEIPCResult	EIPCResult
        //   3	78	3	localParcel1	Parcel
        //   7	69	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	20	74	finally
        //   24	35	74	finally
        //   35	56	74	finally
        //   66	71	74	finally
      }
      
      public String getInterfaceDescriptor()
      {
        return "eipc.EIPCChannel";
      }
      
      public String getProcName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("eipc.EIPCChannel");
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
      
      /* Error */
      public int setClient(String paramString, int paramInt1, EIPCChannel paramEIPCChannel, int paramInt2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 5
        //   19: aload_1
        //   20: invokevirtual 41	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 5
        //   25: iload_2
        //   26: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   29: aload_3
        //   30: ifnull +62 -> 92
        //   33: aload_3
        //   34: invokeinterface 93 1 0
        //   39: astore_1
        //   40: aload 5
        //   42: aload_1
        //   43: invokevirtual 96	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   46: aload 5
        //   48: iload 4
        //   50: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   53: aload_0
        //   54: getfield 19	eipc/EIPCChannel$Stub$Proxy:a	Landroid/os/IBinder;
        //   57: iconst_4
        //   58: aload 5
        //   60: aload 6
        //   62: iconst_0
        //   63: invokeinterface 57 5 0
        //   68: pop
        //   69: aload 6
        //   71: invokevirtual 60	android/os/Parcel:readException	()V
        //   74: aload 6
        //   76: invokevirtual 64	android/os/Parcel:readInt	()I
        //   79: istore_2
        //   80: aload 6
        //   82: invokevirtual 79	android/os/Parcel:recycle	()V
        //   85: aload 5
        //   87: invokevirtual 79	android/os/Parcel:recycle	()V
        //   90: iload_2
        //   91: ireturn
        //   92: aconst_null
        //   93: astore_1
        //   94: goto -54 -> 40
        //   97: astore_1
        //   98: aload 6
        //   100: invokevirtual 79	android/os/Parcel:recycle	()V
        //   103: aload 5
        //   105: invokevirtual 79	android/os/Parcel:recycle	()V
        //   108: aload_1
        //   109: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	110	0	this	Proxy
        //   0	110	1	paramString	String
        //   0	110	2	paramInt1	int
        //   0	110	3	paramEIPCChannel	EIPCChannel
        //   0	110	4	paramInt2	int
        //   3	101	5	localParcel1	Parcel
        //   8	91	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	29	97	finally
        //   33	40	97	finally
        //   40	80	97	finally
      }
      
      public IBinder setStubBinder(int paramInt, IBinder paramIBinder)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("eipc.EIPCChannel");
          localParcel1.writeInt(paramInt);
          localParcel1.writeStrongBinder(paramIBinder);
          this.a.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramIBinder = localParcel2.readStrongBinder();
          return paramIBinder;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public EIPCResult sync(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("eipc.EIPCChannel");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt);
              this.a.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramString1 = (EIPCResult)EIPCResult.CREATOR.createFromParcel(localParcel2);
                return paramString1;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString1 = null;
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
 * Qualified Name:     eipc.EIPCChannel
 * JD-Core Version:    0.7.0.1
 */