package cooperation.qzone.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IServiceHandler$Stub
  extends Binder
  implements IServiceHandler
{
  private static final String DESCRIPTOR = "cooperation.qzone.remote.IServiceHandler";
  static final int TRANSACTION_sendMsg = 1;
  
  public IServiceHandler$Stub()
  {
    attachInterface(this, "cooperation.qzone.remote.IServiceHandler");
  }
  
  public static IServiceHandler asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qzone.remote.IServiceHandler");
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
    if (paramInt1 != 1)
    {
      if (paramInt1 != 1598968902) {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel2.writeString("cooperation.qzone.remote.IServiceHandler");
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qzone.remote.IServiceHandler");
    if (paramParcel1.readInt() != 0) {
      paramParcel1 = (SendMsg)SendMsg.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel1 = null;
    }
    sendMsg(paramParcel1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.remote.IServiceHandler.Stub
 * JD-Core Version:    0.7.0.1
 */