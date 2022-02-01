package com.tencent.shadow.dynamic.host;

import android.os.Binder;
import android.os.Parcel;

class PpsBinder
  extends Binder
{
  static final String DESCRIPTOR = "com.tencent.shadow.dynamic.host.PpsBinder";
  static final int TRANSACTION_CODE_FAILED_EXCEPTION = 1;
  static final int TRANSACTION_CODE_NO_EXCEPTION = 0;
  static final int TRANSACTION_exit = 4;
  static final int TRANSACTION_getPluginLoader = 6;
  static final int TRANSACTION_getPpsStatus = 5;
  static final int TRANSACTION_loadPluginLoader = 2;
  static final int TRANSACTION_loadRuntime = 1;
  static final int TRANSACTION_setUuidManager = 3;
  private final PluginProcessService mPps;
  
  PpsBinder(PluginProcessService paramPluginProcessService)
  {
    this.mPps = paramPluginProcessService;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1598968902)
    {
      switch (paramInt1)
      {
      default: 
        return false;
      case 6: 
        paramParcel1.enforceInterface(DESCRIPTOR);
        paramParcel1 = this.mPps.getPluginLoader();
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface(DESCRIPTOR);
        paramParcel1 = this.mPps.getPpsStatus();
        paramParcel2.writeNoException();
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      case 4: 
        paramParcel1.enforceInterface(DESCRIPTOR);
        this.mPps.exit();
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface(DESCRIPTOR);
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 != null) {
          paramParcel1 = new BinderUuidManager(paramParcel1);
        } else {
          paramParcel1 = null;
        }
        this.mPps.setUuidManager(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface(DESCRIPTOR);
        paramParcel1 = paramParcel1.readString();
        try
        {
          this.mPps.loadPluginLoader(paramParcel1);
          paramParcel2.writeInt(0);
          return true;
        }
        catch (FailedException paramParcel1)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 0);
          return true;
        }
      }
      paramParcel1.enforceInterface(DESCRIPTOR);
      paramParcel1 = paramParcel1.readString();
      try
      {
        this.mPps.loadRuntime(paramParcel1);
        paramParcel2.writeInt(0);
        return true;
      }
      catch (FailedException paramParcel1)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 0);
        return true;
      }
    }
    paramParcel2.writeString(DESCRIPTOR);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.PpsBinder
 * JD-Core Version:    0.7.0.1
 */