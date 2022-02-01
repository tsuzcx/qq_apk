package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseReq
  extends BaseIpc
{
  public ResultReceiver c;
  
  public static BaseReq d(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int i = paramBundle.getInt("redpoint.fromReceiverIPCCode", -1);
    Object localObject = (Class)a.get(i);
    if (localObject != null) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("class name is ");
        localStringBuilder.append(((Class)localObject).getName());
        QLog.d("BaseReq getReq", 2, localStringBuilder.toString());
      }
    }
    try
    {
      localObject = (BaseReq)((Class)localObject).newInstance();
      ((BaseReq)localObject).b(paramBundle);
      return localObject;
    }
    catch (Exception paramBundle) {}
    return null;
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.c != null)
    {
      Parcel localParcel = Parcel.obtain();
      this.c.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      ResultReceiver localResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramBundle.putParcelable("redpoint.fromReceiverKey", localResultReceiver);
    }
  }
  
  public abstract void a(QQAppInterface paramQQAppInterface, Bundle paramBundle);
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.c = ((ResultReceiver)paramBundle.getParcelable("redpoint.fromReceiverKey"));
  }
  
  public final boolean c(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      ResultReceiver localResultReceiver = this.c;
      if (localResultReceiver != null)
      {
        localResultReceiver.send(0, paramBundle);
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseReq doCallback", 2, "bundle == null or fromReceiver == null");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.BaseReq
 * JD-Core Version:    0.7.0.1
 */