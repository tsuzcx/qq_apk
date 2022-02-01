package com.tencent.mobileqq.vas.util;

import android.os.Bundle;
import com.tencent.mobileqq.vas.updatesystem.callback.IRemoteVasUpdateListener;
import com.tencent.mobileqq.vas.updatesystem.entity.VasUpdateParcelableParams;
import eipc.EIPCCallback.Stub;
import eipc.EIPCResult;

final class QQVasUpdateBusinessUtil$1
  extends EIPCCallback.Stub
{
  QQVasUpdateBusinessUtil$1(IRemoteVasUpdateListener paramIRemoteVasUpdateListener) {}
  
  public void callback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null) && (paramEIPCResult.data.getParcelable("data") != null)) {
      QQVasUpdateBusinessUtil.a((VasUpdateParcelableParams)paramEIPCResult.data.getParcelable("data"), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil.1
 * JD-Core Version:    0.7.0.1
 */