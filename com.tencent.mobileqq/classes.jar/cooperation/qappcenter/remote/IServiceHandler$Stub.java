package cooperation.qappcenter.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IServiceHandler$Stub
  extends Binder
  implements IServiceHandler
{
  public IServiceHandler$Stub()
  {
    attachInterface(this, "cooperation.qappcenter.remote.IServiceHandler");
  }
  
  public static IServiceHandler a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qappcenter.remote.IServiceHandler");
    if ((localIInterface != null) && ((localIInterface instanceof IServiceHandler))) {
      return (IServiceHandler)localIInterface;
    }
    return new IServiceHandler.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("cooperation.qappcenter.remote.IServiceHandler");
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qappcenter.remote.IServiceHandler");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (SendMsg)SendMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qappcenter.remote.IServiceHandler.Stub
 * JD-Core Version:    0.7.0.1
 */