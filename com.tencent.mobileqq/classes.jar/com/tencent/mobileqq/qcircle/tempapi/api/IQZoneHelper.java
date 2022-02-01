package com.tencent.mobileqq.qcircle.tempapi.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface IQZoneHelper
  extends QRouteApi
{
  public abstract String AUTHORITY_ACTION();
  
  public abstract String FRAGMENT_CLASS();
  
  public abstract String GO_PUBLISH_ACTIVITY();
  
  public abstract String KEY_CONFIRM_TEXT();
  
  public abstract String KEY_TITLE_STYLE();
  
  public abstract String KEY_UPLOAD_ENTRANCE();
  
  public abstract int PA_FRIEND_PROFILE();
  
  public abstract String PHOTO_PATHS();
  
  public abstract int QZONE_BUSSINESS_ID();
  
  public abstract int QZONE_VIDEO();
  
  public abstract int REQUEST_CODE_TAKE_VIDEO();
  
  public abstract void cancelQzoneAlive();
  
  public abstract void forwardToMoodSelectLocation(Context paramContext, String paramString, int paramInt, Bundle paramBundle);
  
  public abstract boolean isVideoSDKReady();
  
  public abstract void openFlutterPageForQCircle(Context paramContext, String paramString1, String paramString2, Map<String, Object> paramMap, Bundle paramBundle);
  
  public abstract void preloadHippy();
  
  public abstract void preloadQZoneProcess();
  
  public abstract void reportDC02880(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3);
  
  public abstract void startAddFriend(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void startAddFriend(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, byte[] paramArrayOfByte);
  
  public abstract void startFontSoDownload();
  
  public abstract void startNewFriendList(Context paramContext);
  
  public abstract void startProfileCardActivity(Context paramContext, String paramString);
  
  public abstract void startQCircleHippyActivity(Context paramContext, Intent paramIntent);
  
  public abstract void startUnlockActivity();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.IQZoneHelper
 * JD-Core Version:    0.7.0.1
 */