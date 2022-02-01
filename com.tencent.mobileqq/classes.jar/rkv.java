import android.os.IBinder;
import android.os.Parcel;

class rkv
  implements rkt
{
  private IBinder a;
  
  rkv(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public rkw a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterface");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      rkw localrkw = rkx.a(localParcel2.readStrongBinder());
      return localrkw;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkv
 * JD-Core Version:    0.7.0.1
 */