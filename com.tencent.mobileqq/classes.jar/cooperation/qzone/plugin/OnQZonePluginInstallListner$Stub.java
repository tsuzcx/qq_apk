package cooperation.qzone.plugin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class OnQZonePluginInstallListner$Stub
  extends Binder
  implements OnQZonePluginInstallListner
{
  private static final String DESCRIPTOR = "cooperation.qzone.plugin.OnQZonePluginInstallListner";
  static final int TRANSACTION_onInstallBegin = 1;
  static final int TRANSACTION_onInstallDownloadProgress = 2;
  static final int TRANSACTION_onInstallError = 4;
  static final int TRANSACTION_onInstallFinish = 3;
  
  public OnQZonePluginInstallListner$Stub()
  {
    attachInterface(this, "cooperation.qzone.plugin.OnQZonePluginInstallListner");
  }
  
  public static OnQZonePluginInstallListner asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
    if ((localIInterface != null) && ((localIInterface instanceof OnQZonePluginInstallListner))) {
      return (OnQZonePluginInstallListner)localIInterface;
    }
    return new OnQZonePluginInstallListner.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      return true;
    case 1: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      onInstallBegin(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      onInstallDownloadProgress(paramParcel1.readString(), paramParcel1.readFloat(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      onInstallFinish(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
    onInstallError(paramParcel1.readString(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.OnQZonePluginInstallListner.Stub
 * JD-Core Version:    0.7.0.1
 */