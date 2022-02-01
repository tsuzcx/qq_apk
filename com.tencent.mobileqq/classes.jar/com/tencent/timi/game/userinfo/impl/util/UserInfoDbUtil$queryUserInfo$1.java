package com.tencent.timi.game.userinfo.impl.util;

import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import mqq.util.WeakReference;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserInfoDbUtil$queryUserInfo$1
  implements Runnable
{
  UserInfoDbUtil$queryUserInfo$1(WeakReference paramWeakReference, IUserInfo paramIUserInfo) {}
  
  public final void run()
  {
    IResultListener localIResultListener = (IResultListener)this.a.get();
    if (localIResultListener != null) {
      localIResultListener.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil.queryUserInfo.1
 * JD-Core Version:    0.7.0.1
 */