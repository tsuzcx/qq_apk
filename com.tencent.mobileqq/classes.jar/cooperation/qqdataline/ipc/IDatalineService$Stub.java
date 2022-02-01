package cooperation.qqdataline.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IDatalineService$Stub
  extends Binder
  implements IDatalineService
{
  public IDatalineService$Stub()
  {
    attachInterface(this, "cooperation.qqdataline.ipc.IDatalineService");
  }
  
  public static IDatalineService a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qqdataline.ipc.IDatalineService");
    if ((localIInterface != null) && ((localIInterface instanceof IDatalineService))) {
      return (IDatalineService)localIInterface;
    }
    return new IDatalineService.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    String str1 = null;
    Object localObject = null;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 1598968902) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        paramParcel2.writeString("cooperation.qqdataline.ipc.IDatalineService");
        return true;
      }
      paramParcel1.enforceInterface("cooperation.qqdataline.ipc.IDatalineService");
      str1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      b(str1, (Bundle)localObject);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qqdataline.ipc.IDatalineService");
    String str2 = paramParcel1.readString();
    localObject = str1;
    if (paramParcel1.readInt() != 0) {
      localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    }
    paramParcel1 = a(str2, (Bundle)localObject);
    paramParcel2.writeNoException();
    if (paramParcel1 != null)
    {
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    paramParcel2.writeInt(0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqdataline.ipc.IDatalineService.Stub
 * JD-Core Version:    0.7.0.1
 */