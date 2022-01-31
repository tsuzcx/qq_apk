package cooperation.qzone.plugin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import anfr;

public abstract class QZoneRemotePluginManager$Stub
  extends Binder
  implements QZoneRemotePluginManager
{
  public QZoneRemotePluginManager$Stub()
  {
    attachInterface(this, "cooperation.qzone.plugin.QZoneRemotePluginManager");
  }
  
  public static QZoneRemotePluginManager a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
    if ((localIInterface != null) && ((localIInterface instanceof QZoneRemotePluginManager))) {
      return (QZoneRemotePluginManager)localIInterface;
    }
    return new anfr(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("cooperation.qzone.plugin.QZoneRemotePluginManager");
      return true;
    case 1: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      bool = a();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      bool = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      bool = a(paramParcel1.readString(), OnQZonePluginInstallListner.Stub.a(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramInt1 = k;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      bool = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = m;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      bool = c(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = n;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      paramParcel1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 7: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      a(OnQZoneLiveSoDownloadListener.Stub.a(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
    a();
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.QZoneRemotePluginManager.Stub
 * JD-Core Version:    0.7.0.1
 */