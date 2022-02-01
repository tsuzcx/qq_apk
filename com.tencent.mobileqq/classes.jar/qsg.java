import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class qsg
  extends Binder
  implements qsf
{
  public static qsf a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IShouldDoTaskTimingCallback");
    if ((localIInterface != null) && ((localIInterface instanceof qsf))) {
      return (qsf)localIInterface;
    }
    return new qsh(paramIBinder);
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
      paramParcel2.writeString("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IShouldDoTaskTimingCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IShouldDoTaskTimingCallback");
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qsg
 * JD-Core Version:    0.7.0.1
 */