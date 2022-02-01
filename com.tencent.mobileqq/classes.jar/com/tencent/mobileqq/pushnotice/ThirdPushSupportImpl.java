package com.tencent.mobileqq.pushnotice;

import android.content.Context;
import android.os.Bundle;
import mqq.app.IThirdPushSupport;

public class ThirdPushSupportImpl
  implements IThirdPushSupport
{
  public int getThirdPushType(Context paramContext, Bundle paramBundle)
  {
    return ThirdPushManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.ThirdPushSupportImpl
 * JD-Core Version:    0.7.0.1
 */