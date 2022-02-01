package com.tencent.timi.game.component.qqlive.impl.util;

import com.tencent.timi.game.component.qqlive.api.TgCheckPermissionCallback;
import mqq.app.QQPermissionCallback;

final class TgLiveUtils$1
  implements QQPermissionCallback
{
  TgLiveUtils$1(TgCheckPermissionCallback paramTgCheckPermissionCallback) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfInt = this.a;
    if (paramArrayOfInt != null) {
      paramArrayOfInt.a(paramArrayOfString);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.a;
    if (paramArrayOfString != null) {
      paramArrayOfString.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.util.TgLiveUtils.1
 * JD-Core Version:    0.7.0.1
 */