package com.tencent.timi.game.userinfo.impl.util;

import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import mqq.util.WeakReference;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserInfoDbUtil$queryUserInfo$2$1
  implements Runnable
{
  UserInfoDbUtil$queryUserInfo$2$1(UserInfoDbUtil.queryUserInfo.2 param2, IUserInfo paramIUserInfo) {}
  
  public final void run()
  {
    IResultListener localIResultListener = (IResultListener)this.this$0.b.get();
    if (localIResultListener != null) {
      localIResultListener.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil.queryUserInfo.2.1
 * JD-Core Version:    0.7.0.1
 */