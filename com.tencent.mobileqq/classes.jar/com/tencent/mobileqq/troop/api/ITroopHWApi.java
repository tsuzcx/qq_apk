package com.tencent.mobileqq.troop.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface ITroopHWApi
  extends QRouteApi
{
  public static final String ACTION_START_VIDEO_CHAT = "tencent.av.v2q.StartVideoChat";
  
  public abstract int getBknBySkey(String paramString);
  
  public abstract String getFileSuffix(String paramString);
  
  public abstract Intent getSelectMediaIntent(int paramInt, Activity paramActivity, String paramString);
  
  public abstract HashMap<Integer, String[]> getTroopListUin(AppInterface paramAppInterface, int paramInt);
  
  public abstract void goSelectMedia(Activity paramActivity, Object paramObject1, Object paramObject2, Intent paramIntent, byte paramByte);
  
  public abstract void gotoSelectPicture(Activity paramActivity, Object paramObject1, Object paramObject2, int paramInt, byte paramByte);
  
  public abstract boolean isAbsBaseWebViewActivity(Activity paramActivity);
  
  public abstract void showOnePicture(Activity paramActivity, String paramString);
  
  public abstract void start_BulkSendMessageFragment(Activity paramActivity, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopHWApi
 * JD-Core Version:    0.7.0.1
 */