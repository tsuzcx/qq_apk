package com.tencent.mobileqq.kandian.biz.reward.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IReportTaskProgressCallback$Stub
  extends Binder
  implements IReportTaskProgressCallback
{
  public IReportTaskProgressCallback$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.kandian.biz.reward.aidl.IReportTaskProgressCallback");
  }
  
  public static IReportTaskProgressCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.kandian.biz.reward.aidl.IReportTaskProgressCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IReportTaskProgressCallback))) {
      return (IReportTaskProgressCallback)localIInterface;
    }
    return new IReportTaskProgressCallback.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 1598968902) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        paramParcel2.writeString("com.tencent.mobileqq.kandian.biz.reward.aidl.IReportTaskProgressCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.kandian.biz.reward.aidl.IReportTaskProgressCallback");
      a(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.kandian.biz.reward.aidl.IReportTaskProgressCallback");
    a();
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.IReportTaskProgressCallback.Stub
 * JD-Core Version:    0.7.0.1
 */