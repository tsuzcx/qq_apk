package com.tencent.mobileqq.qqgift.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQGiftUtil
  extends QRouteApi
{
  public abstract boolean checkIsQQGiftUrl(String paramString1, String paramString2, Intent paramIntent);
  
  public abstract Intent getOpenQQGiftUrlIntent(Activity paramActivity, String paramString1, String paramString2, Intent paramIntent, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.IQQGiftUtil
 * JD-Core Version:    0.7.0.1
 */