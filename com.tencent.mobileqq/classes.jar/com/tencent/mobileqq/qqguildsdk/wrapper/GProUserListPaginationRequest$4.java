package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback.Result;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class GProUserListPaginationRequest$4
  implements Runnable
{
  GProUserListPaginationRequest$4(GProUserListPaginationRequest paramGProUserListPaginationRequest, GProUserListPaginationRequest.PaginationCookie paramPaginationCookie, boolean paramBoolean, IGetGProUserListPaginationCallback paramIGetGProUserListPaginationCallback) {}
  
  public void run()
  {
    Object localObject = (ArrayList)GProUserListPaginationRequest.a().get(GProUserListPaginationRequest.PaginationCookie.b(this.a));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchCallback() userList: ");
    localStringBuilder.append(((ArrayList)localObject).size());
    QLog.e("GProUserListPaginationRequest", 1, localStringBuilder.toString());
    localObject = IGetGProUserListPaginationCallback.Result.a(GProUserListPaginationRequest.a((List)localObject), this.a, true ^ this.b);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchCallback() ");
      localStringBuilder.append(localObject);
      QLog.d("GProUserListPaginationRequest", 2, localStringBuilder.toString());
    }
    this.c.a((IGetGProUserListPaginationCallback.Result)localObject);
    if (!this.b) {
      GProUserListPaginationRequest.a().remove(GProUserListPaginationRequest.PaginationCookie.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProUserListPaginationRequest.4
 * JD-Core Version:    0.7.0.1
 */