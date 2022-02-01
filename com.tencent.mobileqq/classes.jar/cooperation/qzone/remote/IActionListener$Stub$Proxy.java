package cooperation.qzone.remote;

import android.os.IBinder;
import android.os.Parcel;

class IActionListener$Stub$Proxy
  implements IActionListener
{
  private IBinder mRemote;
  
  IActionListener$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "cooperation.qzone.remote.IActionListener";
  }
  
  public void onRecvFromMsg(RecvMsg paramRecvMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("cooperation.qzone.remote.IActionListener");
      if (paramRecvMsg != null)
      {
        localParcel.writeInt(1);
        paramRecvMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.mRemote.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.remote.IActionListener.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */