package com.tencent.timi.game.smoba.impl.util;

import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class UserSmobaInfoDbUtils$getAuthDescInfoFromDB$1
  implements Runnable
{
  public final void run()
  {
    Object localObject = UserSmobaInfoDbUtils.a.c();
    if (localObject != null)
    {
      IUserSmobaInfoService.Callback localCallback = this.a;
      if (localCallback != null) {
        localCallback.a(true, 0, "", localObject);
      }
    }
    else
    {
      localObject = this.a;
      if (localObject != null) {
        ((IUserSmobaInfoService.Callback)localObject).a(false, 0, "", null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.UserSmobaInfoDbUtils.getAuthDescInfoFromDB.1
 * JD-Core Version:    0.7.0.1
 */