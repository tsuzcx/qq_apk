import android.os.IBinder;
import android.os.Parcel;

class rbb
  implements raz
{
  private IBinder a;
  
  rbb(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public rbf a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.IRIJAidlInterface");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      rbf localrbf = rbg.a(localParcel2.readStrongBinder());
      return localrbf;
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
 * Qualified Name:     rbb
 * JD-Core Version:    0.7.0.1
 */