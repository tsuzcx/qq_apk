package com.tencent.mobileqq.share.api.impl;

import android.content.Context;
import com.tencent.mobileqq.screendetect.ScreenShotHelper;
import com.tencent.mobileqq.share.api.IShareActivityStartup;

public class ShareActivityStartupImpl
  implements IShareActivityStartup
{
  public void gotoShareActivity(Context paramContext, String paramString)
  {
    ScreenShotHelper.a(paramContext, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.share.api.impl.ShareActivityStartupImpl
 * JD-Core Version:    0.7.0.1
 */