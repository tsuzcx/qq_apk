package com.tencent.mobileqq.qqexpand.entrance.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandEntranceImpl$getQuietMode$1
  implements Runnable
{
  ExpandEntranceImpl$getQuietMode$1(AppInterface paramAppInterface) {}
  
  public final void run()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      QLog.d("ExpandEntranceImpl", 1, "getQuietMode app is empty");
      return;
    }
    localObject = ((AppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localObject != null)
    {
      ((ExpandHandlerImpl)localObject).b(this.a.getCurrentUin());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.entrance.impl.ExpandEntranceImpl.getQuietMode.1
 * JD-Core Version:    0.7.0.1
 */