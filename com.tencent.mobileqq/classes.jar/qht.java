import android.os.IBinder;
import android.os.Parcel;

class qht
  implements qhr
{
  private IBinder a;
  
  qht(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public qhx a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.IRIJAidlInterface");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      qhx localqhx = qhy.a(localParcel2.readStrongBinder());
      return localqhx;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qht
 * JD-Core Version:    0.7.0.1
 */