import android.os.IBinder;
import android.os.Parcel;

class qyp
  implements qyn
{
  private IBinder a;
  
  qyp(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public qyq a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterface");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      qyq localqyq = qyr.a(localParcel2.readStrongBinder());
      return localqyq;
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
 * Qualified Name:     qyp
 * JD-Core Version:    0.7.0.1
 */