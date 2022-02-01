package com.tencent.timi.game.scheme.tools;

import com.tencent.mobileqq.bigbrother.JumpCallback;
import com.tencent.mobileqq.bigbrother.TeleScreen;
import com.tencent.timi.game.utils.Logger;

final class SchemeUtil$2
  implements JumpCallback
{
  public void onJump(int paramInt1, int paramInt2)
  {
    String str = SchemeUtil.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchCommonScheme onJump - callbackId= ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", action = ");
    localStringBuilder.append(paramInt2);
    Logger.a(str, localStringBuilder.toString());
    TeleScreen.a().a(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.scheme.tools.SchemeUtil.2
 * JD-Core Version:    0.7.0.1
 */