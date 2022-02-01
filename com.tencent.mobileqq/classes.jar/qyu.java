import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class qyu
  extends Binder
  implements qyt
{
  public qyu()
  {
    attachInterface(this, "com.tencent.biz.pubaccount.readinjoy.reward.aidl.IReportTaskProgressCallback");
  }
  
  public static qyt a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IReportTaskProgressCallback");
    if ((localIInterface != null) && ((localIInterface instanceof qyt))) {
      return (qyt)localIInterface;
    }
    return new qyv(paramIBinder);
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
      paramParcel2.writeString("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IReportTaskProgressCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IReportTaskProgressCallback");
      a();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IReportTaskProgressCallback");
    a(paramParcel1.readInt(), paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyu
 * JD-Core Version:    0.7.0.1
 */