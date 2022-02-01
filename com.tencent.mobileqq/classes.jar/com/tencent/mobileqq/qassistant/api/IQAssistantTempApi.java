package com.tencent.mobileqq.qassistant.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.JumpAction;

@QAPI(process={""})
public abstract interface IQAssistantTempApi
  extends QRouteApi
{
  public abstract boolean checkIsSupportJump(Context paramContext, String paramString);
  
  public abstract void configWebItemCloseDrawer();
  
  public abstract String configWebItemJumpUrl(String paramString);
  
  public abstract JumpAction createJumpAction(Context paramContext);
  
  public abstract void extendJumpIntentExtra1(Bundle paramBundle);
  
  public abstract void extendJumpIntentExtra2(Bundle paramBundle, String paramString);
  
  public abstract int getChatFragmentCurrentType();
  
  public abstract String getIpcConstants_ACTION_VOICE_RECORD_OFF();
  
  public abstract String getIpcConstants_ACTION_VOICE_RECORD_ON();
  
  public abstract String getMainFragmentClassName();
  
  public abstract int getMainFragmentCurrentTab();
  
  public abstract boolean isSpecialCareFriend(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.api.IQAssistantTempApi
 * JD-Core Version:    0.7.0.1
 */