import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class qib
  extends Binder
  implements qia
{
  public qib()
  {
    attachInterface(this, "com.tencent.biz.pubaccount.readinjoy.service.redpacket.IReportTaskProgressCallback");
  }
  
  public static qia a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IReportTaskProgressCallback");
    if ((localIInterface != null) && ((localIInterface instanceof qia))) {
      return (qia)localIInterface;
    }
    return new qic(paramIBinder);
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
      paramParcel2.writeString("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IReportTaskProgressCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IReportTaskProgressCallback");
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qib
 * JD-Core Version:    0.7.0.1
 */