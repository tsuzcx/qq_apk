package com.tencent.mobileqq.qcircle.tempapi.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qcircle.tempapi.avatar.IAvatarListener;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.AccountIdentityCallBack;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.FlutterInstallCallBack;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.IAEKitResult;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.QCircleVideoSdkInitListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.shadow.core.common.ILoggerFactory;
import java.io.Serializable;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface IQQBaseService
  extends QRouteApi
{
  public abstract int SUPPORT_AVC_DEC();
  
  public abstract int SUPPORT_AVC_ENC();
  
  public abstract int checkSupportMediaCodecFeature();
  
  public abstract void clearAvatarListener();
  
  public abstract void clearRedDotInfo();
  
  public abstract String getAccountName(String paramString);
  
  public abstract String getBuddyName(String paramString);
  
  public abstract BusinessHandler getBusinessHandler(String paramString);
  
  public abstract int getDoubleEmoji(int paramInt1, int paramInt2);
  
  public abstract int getEmojiUnicode(int paramInt);
  
  public abstract IEmoticonMainPanelApp getEmotionImpl();
  
  public abstract String getFaceString(int paramInt);
  
  public abstract String getFriendNick(String paramString);
  
  public abstract ILoggerFactory getILoggerFactory();
  
  public abstract String getImei();
  
  public abstract int getLocalIdFromEMCodeFromEmoji(String paramString);
  
  public abstract int getLocalIdFromEMCodeFromSystem(String paramString);
  
  public abstract void getNewQQHead(String paramString, IAvatarListener paramIAvatarListener);
  
  public abstract Class getQCircleHippyFragmentClass();
  
  public abstract Class getQQBrowserActivityClass();
  
  public abstract Class getQQTranslucentBrowserActivityClass();
  
  public abstract String getResolution();
  
  public abstract int getSingleEmoji(int paramInt);
  
  public abstract Bundle getTroopProfileExtra(String paramString);
  
  public abstract Intent handleQCircleHybirdActivityIntent(Context paramContext, String paramString, Intent paramIntent, int paramInt);
  
  public abstract boolean initAEKit(IAEKitResult paramIAEKitResult);
  
  public abstract void initSDKAsync(QCircleVideoSdkInitListener paramQCircleVideoSdkInitListener);
  
  public abstract void installQFlutter(FlutterInstallCallBack paramFlutterInstallCallBack);
  
  public abstract boolean isDeviceSupport();
  
  public abstract boolean isFunctionAvaliable(Context paramContext);
  
  public abstract boolean isQQForeground();
  
  public abstract boolean isSkinEmoji(int paramInt);
  
  public abstract void nativeSetMaxPhotoFrameCount(int paramInt);
  
  public abstract void openBottomTabSwitchActivity();
  
  public abstract void requestGenerateVideo(String paramString);
  
  public abstract void sendQCircleAccountIdentityRequest(AccountIdentityCallBack paramAccountIdentityCallBack);
  
  public abstract void updateRedDotInfo();
  
  public abstract Serializable wrapSerializableMap(HashMap paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
 * JD-Core Version:    0.7.0.1
 */