package de.robv.android.xposed.services;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import java.io.IOException;

public final class BinderService
  extends BaseService
{
  private static final int ACCESS_FILE_TRANSACTION = 3;
  private static final String INTERFACE_TOKEN = "de.robv.android.xposed.IXposedService";
  private static final int READ_FILE_TRANSACTION = 5;
  private static final String[] SERVICE_NAMES = { "user.xposed.app", "user.xposed.system" };
  private static final int STAT_FILE_TRANSACTION = 4;
  public static final int TARGET_APP = 0;
  public static final int TARGET_SYSTEM = 1;
  private static final BinderService[] sServices = new BinderService[2];
  private final IBinder mRemote;
  
  private BinderService(int paramInt)
  {
    IBinder localIBinder = ServiceManager.getService(SERVICE_NAMES[paramInt]);
    if (localIBinder == null) {
      throw new IllegalStateException("Service " + SERVICE_NAMES[paramInt] + " does not exist");
    }
    this.mRemote = localIBinder;
  }
  
  public static BinderService getService(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > sServices.length)) {
      throw new IllegalArgumentException("Invalid service target " + paramInt);
    }
    synchronized (sServices)
    {
      if (sServices[paramInt] == null) {
        sServices[paramInt] = new BinderService(paramInt);
      }
      BinderService localBinderService = sServices[paramInt];
      return localBinderService;
    }
  }
  
  public boolean checkFileAccess(String paramString, int paramInt)
  {
    boolean bool = false;
    ensureAbsolutePath(paramString);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("de.robv.android.xposed.IXposedService");
    localParcel1.writeString(paramString);
    localParcel1.writeInt(paramInt);
    try
    {
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      localParcel2.recycle();
      localParcel1.recycle();
      if (paramInt == 0) {
        bool = true;
      }
      return bool;
    }
    catch (RemoteException paramString)
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
    return false;
  }
  
  public FileResult readFile(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    ensureAbsolutePath(paramString);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("de.robv.android.xposed.IXposedService");
    localParcel1.writeString(paramString);
    localParcel1.writeInt(paramInt1);
    localParcel1.writeInt(paramInt2);
    localParcel1.writeLong(paramLong1);
    localParcel1.writeLong(paramLong2);
    String str;
    byte[] arrayOfByte;
    try
    {
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      str = localParcel2.readString();
      paramLong1 = localParcel2.readLong();
      paramLong2 = localParcel2.readLong();
      arrayOfByte = localParcel2.createByteArray();
      localParcel2.recycle();
      localParcel1.recycle();
      switch (i)
      {
      default: 
        throwCommonIOException(i, str, paramString, " while reading ");
        throw new IllegalStateException();
      }
    }
    catch (RemoteException paramString)
    {
      localParcel1.recycle();
      localParcel2.recycle();
      throw new IOException(paramString);
    }
    return new FileResult(arrayOfByte, paramLong1, paramLong2);
    if (str != null)
    {
      paramString = new IllegalArgumentException(str);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        throw new IOException(paramString);
      }
      throw paramString;
    }
    throw new IllegalArgumentException("Offset " + paramInt1 + " / Length " + paramInt2 + " is out of range for " + paramString + " with size " + paramLong1);
  }
  
  public FileResult readFile(String paramString, long paramLong1, long paramLong2)
  {
    return readFile(paramString, 0, 0, paramLong1, paramLong2);
  }
  
  public byte[] readFile(String paramString)
  {
    return readFile(paramString, 0, 0, 0L, 0L).content;
  }
  
  public FileResult statFile(String paramString)
  {
    ensureAbsolutePath(paramString);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("de.robv.android.xposed.IXposedService");
    localParcel1.writeString(paramString);
    try
    {
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        throwCommonIOException(i, null, paramString, " while retrieving attributes for ");
      }
      long l1 = localParcel2.readLong();
      long l2 = localParcel2.readLong();
      localParcel2.recycle();
      localParcel1.recycle();
      return new FileResult(l1, l2);
    }
    catch (RemoteException paramString)
    {
      localParcel1.recycle();
      localParcel2.recycle();
      throw new IOException(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.services.BinderService
 * JD-Core Version:    0.7.0.1
 */