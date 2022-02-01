package com.tencent.mobileqq.kandian.biz.reward.aidl;

import android.os.IBinder;
import android.os.Parcel;

class IRIJAidlInterface$Stub$Proxy
  implements IRIJAidlInterface
{
  private IBinder a;
  
  IRIJAidlInterface$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IRIJAidlInterfaceForRewardTask a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterface");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      IRIJAidlInterfaceForRewardTask localIRIJAidlInterfaceForRewardTask = IRIJAidlInterfaceForRewardTask.Stub.a(localParcel2.readStrongBinder());
      return localIRIJAidlInterfaceForRewardTask;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterface.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */