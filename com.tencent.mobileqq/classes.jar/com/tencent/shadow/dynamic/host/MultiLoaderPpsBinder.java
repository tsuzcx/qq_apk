package com.tencent.shadow.dynamic.host;

import android.os.Binder;
import android.os.Parcel;

public class MultiLoaderPpsBinder
  extends Binder
{
  static final String DESCRIPTOR = MultiLoaderPpsBinder.class.getName();
  static final int TRANSACTION_CODE_FAILED_EXCEPTION = 1;
  static final int TRANSACTION_CODE_NO_EXCEPTION = 0;
  static final int TRANSACTION_exit = 6;
  static final int TRANSACTION_getPluginLoaderForPlugin = 5;
  static final int TRANSACTION_getPpsStatusForPlugin = 4;
  static final int TRANSACTION_loadPluginLoaderForPlugin = 2;
  static final int TRANSACTION_loadRuntimeForPlugin = 1;
  static final int TRANSACTION_setUuidManagerForPlugin = 3;
  private final MultiLoaderPluginProcessService mPps;
  
  MultiLoaderPpsBinder(MultiLoaderPluginProcessService paramMultiLoaderPluginProcessService)
  {
    this.mPps = paramMultiLoaderPluginProcessService;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    String str;
    switch (paramInt1)
    {
    default: 
      return false;
    case 1598968902: 
      paramParcel2.writeString(DESCRIPTOR);
      return true;
    case 1: 
      paramParcel1.enforceInterface(DESCRIPTOR);
      str = paramParcel1.readString();
      paramParcel1 = paramParcel1.readString();
      try
      {
        this.mPps.loadRuntimeForPlugin(str, paramParcel1);
        paramParcel2.writeInt(0);
        return true;
      }
      catch (FailedException paramParcel1)
      {
        for (;;)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 0);
        }
      }
    case 2: 
      paramParcel1.enforceInterface(DESCRIPTOR);
      str = paramParcel1.readString();
      paramParcel1 = paramParcel1.readString();
      try
      {
        this.mPps.loadPluginLoaderForPlugin(str, paramParcel1);
        paramParcel2.writeInt(0);
        return true;
      }
      catch (FailedException paramParcel1)
      {
        for (;;)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 0);
        }
      }
    case 3: 
      paramParcel1.enforceInterface(DESCRIPTOR);
      str = paramParcel1.readString();
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 != null) {}
      for (paramParcel1 = new BinderUuidManager(paramParcel1);; paramParcel1 = null)
      {
        this.mPps.setUuidManagerForPlugin(str, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface(DESCRIPTOR);
      paramParcel1 = paramParcel1.readString();
      paramParcel1 = this.mPps.getPpsStatusForPlugin(paramParcel1);
      paramParcel2.writeNoException();
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    case 5: 
      paramParcel1.enforceInterface(DESCRIPTOR);
      paramParcel1 = paramParcel1.readString();
      paramParcel1 = this.mPps.getPluginLoaderForPlugin(paramParcel1);
      paramParcel2.writeNoException();
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface(DESCRIPTOR);
    this.mPps.exit();
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.MultiLoaderPpsBinder
 * JD-Core Version:    0.7.0.1
 */