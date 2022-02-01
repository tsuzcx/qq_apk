package com.tencent.mobileqq.qwallet.jump;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface IWXMiniProgramHelper
  extends QRouteApi
{
  public abstract void handleWXEntryActivityIntent(Activity paramActivity, Intent paramIntent);
  
  public abstract void launchMiniProgram(Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.jump.IWXMiniProgramHelper
 * JD-Core Version:    0.7.0.1
 */