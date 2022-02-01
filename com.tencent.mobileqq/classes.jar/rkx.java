import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;

public abstract class rkx
  extends Binder
  implements rkw
{
  public rkx()
  {
    attachInterface(this, "com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
  }
  
  public static rkw a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
    if ((localIInterface != null) && ((localIInterface instanceof rkw))) {
      return (rkw)localIInterface;
    }
    return new rky(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 0;
    int i = 0;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      if (paramParcel1.readInt() != 0) {
        localObject1 = RIJRewardTask.CREATOR.a(paramParcel1);
      }
      a((RIJRewardTask)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = RIJRewardTask.CREATOR.a(paramParcel1);
      }
      b((RIJRewardTask)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      paramParcel1 = b();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      bool = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 6: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      a(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      a(paramParcel1.readString(), paramParcel1.readInt(), rla.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      paramInt1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      paramInt1 = b();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      bool = a();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      bool = b();
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      paramInt1 = c();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      paramInt1 = d();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      paramInt1 = e();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
    paramInt1 = f();
    paramParcel2.writeNoException();
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkx
 * JD-Core Version:    0.7.0.1
 */