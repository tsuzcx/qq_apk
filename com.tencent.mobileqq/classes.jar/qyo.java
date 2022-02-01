import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class qyo
  extends Binder
  implements qyn
{
  public qyo()
  {
    attachInterface(this, "com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterface");
  }
  
  public static qyn a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterface");
    if ((localIInterface != null) && ((localIInterface instanceof qyn))) {
      return (qyn)localIInterface;
    }
    return new qyp(paramIBinder);
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
      paramParcel2.writeString("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterface");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterface");
    paramParcel1 = a();
    paramParcel2.writeNoException();
    if (paramParcel1 != null) {}
    for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
    {
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyo
 * JD-Core Version:    0.7.0.1
 */