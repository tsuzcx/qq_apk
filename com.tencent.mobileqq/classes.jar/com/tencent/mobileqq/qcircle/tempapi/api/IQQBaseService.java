package com.tencent.mobileqq.qcircle.tempapi.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQBaseService
  extends QRouteApi
{
  public abstract void attachConditionSearchManager();
  
  public abstract int checkSupportMediaCodecFeature();
  
  public abstract String decodeRemoteCode(long paramLong);
  
  public abstract void detachConditionSearchManager();
  
  public abstract int encodeLocCode(String paramString);
  
  public abstract IEmoticonMainPanelApp getEmotionImpl();
  
  public abstract Class getQCircleHippyFragmentClass();
  
  public abstract Intent handleQCircleHybirdActivityIntent(Context paramContext, String paramString, Intent paramIntent, int paramInt);
  
  public abstract void openBottomTabSwitchActivity();
  
  public abstract void openLocationSelectActivity(Context paramContext, Bundle paramBundle);
  
  public abstract void setNewSsoAndRestartApp(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
 * JD-Core Version:    0.7.0.1
 */