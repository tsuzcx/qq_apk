package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback.Result;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback;
import java.util.Collections;

class GProUserListApiAdapter$3
  implements Runnable
{
  GProUserListApiAdapter$3(GProUserListApiAdapter paramGProUserListApiAdapter, IGetGProUserListPaginationCallback.Result paramResult) {}
  
  public void run()
  {
    GProUserListApiAdapter.ApiParameter.d(GProUserListApiAdapter.b(this.this$0)).onGetUserList(GProUserListApiAdapter.ApiParameter.c(GProUserListApiAdapter.b(this.this$0)), this.a.a, this.a.b, GProUserListApiAdapter.c(this.this$0), Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProUserListApiAdapter.3
 * JD-Core Version:    0.7.0.1
 */