package cooperation.qappcenter.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IActionListener$Stub
  extends Binder
  implements IActionListener
{
  public IActionListener$Stub()
  {
    attachInterface(this, "cooperation.qappcenter.remote.IActionListener");
  }
  
  public static IActionListener a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qappcenter.remote.IActionListener");
    if ((localIInterface != null) && ((localIInterface instanceof IActionListener))) {
      return (IActionListener)localIInterface;
    }
    return new IActionListener.Stub.Proxy(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 1598968902) {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel2.writeString("cooperation.qappcenter.remote.IActionListener");
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qappcenter.remote.IActionListener");
    if (paramParcel1.readInt() != 0) {
      paramParcel1 = (RecvMsg)RecvMsg.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel1 = null;
    }
    a(paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qappcenter.remote.IActionListener.Stub
 * JD-Core Version:    0.7.0.1
 */