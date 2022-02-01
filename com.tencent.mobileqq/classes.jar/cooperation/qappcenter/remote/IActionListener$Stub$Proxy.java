package cooperation.qappcenter.remote;

import android.os.IBinder;
import android.os.Parcel;

class IActionListener$Stub$Proxy
  implements IActionListener
{
  private IBinder a;
  
  IActionListener$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(RecvMsg paramRecvMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("cooperation.qappcenter.remote.IActionListener");
      if (paramRecvMsg != null)
      {
        localParcel.writeInt(1);
        paramRecvMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qappcenter.remote.IActionListener.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */