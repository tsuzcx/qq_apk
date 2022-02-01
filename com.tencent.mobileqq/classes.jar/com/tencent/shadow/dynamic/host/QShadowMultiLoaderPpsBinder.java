package com.tencent.shadow.dynamic.host;

import android.os.Binder;
import android.os.Parcel;

public class QShadowMultiLoaderPpsBinder
  extends Binder
{
  private final QShadowMultiLoaderPluginProcessService mPps;
  
  QShadowMultiLoaderPpsBinder(QShadowMultiLoaderPluginProcessService paramQShadowMultiLoaderPluginProcessService)
  {
    this.mPps = paramQShadowMultiLoaderPluginProcessService;
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
        paramParcel1.enforceInterface(MultiLoaderPpsBinder.DESCRIPTOR);
        this.mPps.exit();
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface(MultiLoaderPpsBinder.DESCRIPTOR);
        paramParcel1 = paramParcel1.readString();
        paramParcel1 = this.mPps.getPluginLoaderForPlugin(paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface(MultiLoaderPpsBinder.DESCRIPTOR);
        paramParcel1 = paramParcel1.readString();
        paramParcel1 = this.mPps.getPpsStatusForPlugin(paramParcel1);
        paramParcel2.writeNoException();
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      case 3: 
        paramParcel1.enforceInterface(MultiLoaderPpsBinder.DESCRIPTOR);
        str = paramParcel1.readString();
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 != null) {
          paramParcel1 = new BinderUuidManager(paramParcel1);
        } else {
          paramParcel1 = null;
        }
        this.mPps.setUuidManagerForPlugin(str, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface(MultiLoaderPpsBinder.DESCRIPTOR);
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
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 0);
          return true;
        }
      }
      paramParcel1.enforceInterface(MultiLoaderPpsBinder.DESCRIPTOR);
      String str = paramParcel1.readString();
      paramParcel1 = paramParcel1.readString();
      try
      {
        this.mPps.loadRuntimeForPlugin(str, paramParcel1);
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
    paramParcel2.writeString(MultiLoaderPpsBinder.DESCRIPTOR);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.QShadowMultiLoaderPpsBinder
 * JD-Core Version:    0.7.0.1
 */