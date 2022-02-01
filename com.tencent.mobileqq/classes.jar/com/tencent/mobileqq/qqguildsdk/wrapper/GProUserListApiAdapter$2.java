package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class GProUserListApiAdapter$2
  implements Runnable
{
  GProUserListApiAdapter$2(GProUserListApiAdapter paramGProUserListApiAdapter) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("GProUserListApiAdapter", 2, "dispatchUserList: ");
      localObject = GProUserListApiAdapter.a(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        QLog.d("GProUserListApiAdapter", 2, new Object[] { "USER:", String.valueOf(0), ": ", (IGProUserInfo)((Iterator)localObject).next() });
      }
    }
    Object localObject = new GProUserListApiAdapter.GProUsers(GProUserListApiAdapter.a(this.this$0));
    GProUserListApiAdapter.ApiParameter.d(GProUserListApiAdapter.b(this.this$0)).onGetUserList(GProUserListApiAdapter.ApiParameter.c(GProUserListApiAdapter.b(this.this$0)), 0, "", GProUserListApiAdapter.c(this.this$0), ((GProUserListApiAdapter.GProUsers)localObject).b, ((GProUserListApiAdapter.GProUsers)localObject).a, ((GProUserListApiAdapter.GProUsers)localObject).c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProUserListApiAdapter.2
 * JD-Core Version:    0.7.0.1
 */