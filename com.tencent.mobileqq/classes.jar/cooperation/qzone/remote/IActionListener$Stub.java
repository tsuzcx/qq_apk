package cooperation.qzone.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import bmey;

public abstract class IActionListener$Stub
  extends Binder
  implements IActionListener
{
  private static final String DESCRIPTOR = "cooperation.qzone.remote.IActionListener";
  static final int TRANSACTION_onRecvFromMsg = 1;
  
  public IActionListener$Stub()
  {
    attachInterface(this, "cooperation.qzone.remote.IActionListener");
  }
  
  public static IActionListener asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qzone.remote.IActionListener");
    if ((localIInterface != null) && ((localIInterface instanceof IActionListener))) {
      return (IActionListener)localIInterface;
    }
    return new bmey(paramIBinder);
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
      paramParcel2.writeString("cooperation.qzone.remote.IActionListener");
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qzone.remote.IActionListener");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (RecvMsg)RecvMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      onRecvFromMsg(paramParcel1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.remote.IActionListener.Stub
 * JD-Core Version:    0.7.0.1
 */