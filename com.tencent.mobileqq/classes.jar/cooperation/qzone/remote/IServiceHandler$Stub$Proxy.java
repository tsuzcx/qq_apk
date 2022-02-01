package cooperation.qzone.remote;

import android.os.IBinder;
import android.os.Parcel;

class IServiceHandler$Stub$Proxy
  implements IServiceHandler
{
  private IBinder mRemote;
  
  IServiceHandler$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "cooperation.qzone.remote.IServiceHandler";
  }
  
  public void sendMsg(SendMsg paramSendMsg)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qzone.remote.IServiceHandler");
      if (paramSendMsg != null)
      {
        localParcel1.writeInt(1);
        paramSendMsg.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.remote.IServiceHandler.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */