package com.tencent.timi.game.mic.impl;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.mic.api.CheckMicPermissionCallback;
import com.tencent.timi.game.mic.api.IMicService;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/mic/impl/MicServiceImpl;", "Lcom/tencent/timi/game/mic/api/IMicService;", "()V", "checkMicPermission", "", "checkMicPermissionCallback", "Lcom/tencent/timi/game/mic/api/CheckMicPermissionCallback;", "init", "context", "Landroid/content/Context;", "serviceDestroy", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MicServiceImpl
  implements IMicService
{
  public void a(@Nullable Context paramContext) {}
  
  public void a(@Nullable CheckMicPermissionCallback paramCheckMicPermissionCallback)
  {
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (MobileQQ.sMobileQQ.checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      if (paramCheckMicPermissionCallback != null) {
        paramCheckMicPermissionCallback.a(true);
      }
    }
    else
    {
      QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
      if (localQBaseActivity != null)
      {
        localQBaseActivity.requestPermissions(new MicServiceImpl.checkMicPermission.1(paramCheckMicPermissionCallback), 1, new String[] { "android.permission.RECORD_AUDIO" });
        return;
      }
      if (paramCheckMicPermissionCallback != null) {
        paramCheckMicPermissionCallback.a(false);
      }
    }
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.mic.impl.MicServiceImpl
 * JD-Core Version:    0.7.0.1
 */