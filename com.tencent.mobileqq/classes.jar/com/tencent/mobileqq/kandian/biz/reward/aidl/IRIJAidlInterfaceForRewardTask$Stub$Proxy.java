package com.tencent.mobileqq.kandian.biz.reward.aidl;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask.CREATOR;

class IRIJAidlInterfaceForRewardTask$Stub$Proxy
  implements IRIJAidlInterfaceForRewardTask
{
  private IBinder a;
  
  IRIJAidlInterfaceForRewardTask$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public RIJRewardTask a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      RIJRewardTask localRIJRewardTask;
      if (localParcel2.readInt() != 0) {
        localRIJRewardTask = RIJRewardTask.CREATOR.a(localParcel2);
      } else {
        localRIJRewardTask = null;
      }
      return localRIJRewardTask;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      localParcel1.writeInt(paramInt);
      this.a.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(RIJRewardTask paramRIJRewardTask)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      if (paramRIJRewardTask != null)
      {
        localParcel1.writeInt(1);
        paramRIJRewardTask.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(String paramString, int paramInt, IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        if (paramIReportTaskProgressCallback != null)
        {
          paramString = paramIReportTaskProgressCallback.asBinder();
          localParcel1.writeStrongBinder(paramString);
          this.a.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramString = null;
    }
  }
  
  public boolean a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      localParcel1.writeString(paramString);
      paramString = this.a;
      boolean bool = false;
      paramString.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
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
  
  public RIJRewardTask b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      RIJRewardTask localRIJRewardTask;
      if (localParcel2.readInt() != 0) {
        localRIJRewardTask = RIJRewardTask.CREATOR.a(localParcel2);
      } else {
        localRIJRewardTask = null;
      }
      return localRIJRewardTask;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void b(RIJRewardTask paramRIJRewardTask)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      if (paramRIJRewardTask != null)
      {
        localParcel1.writeInt(1);
        paramRIJRewardTask.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void b(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      localParcel1.writeString(paramString);
      this.a.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int d()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean e()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      IBinder localIBinder = this.a;
      boolean bool = false;
      localIBinder.transact(11, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean f()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      IBinder localIBinder = this.a;
      boolean bool = false;
      localIBinder.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int g()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(13, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int h()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(14, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int i()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(15, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int j()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(16, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterfaceForRewardTask.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */