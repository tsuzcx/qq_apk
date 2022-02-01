package com.tencent.mobileqq.vas.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.hiboom.api.IBaseChatPieAdapter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.widget.QQProgressDialog;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IVasCommonAdapter
  extends QRouteApi
{
  public abstract String addParamToUrl(String paramString1, String paramString2);
  
  public abstract void checkFZEngineReady();
  
  public abstract void clearMagicFontCache(AppRuntime paramAppRuntime);
  
  public abstract Bitmap decodeFileWithBufferedStream(String paramString, BitmapFactory.Options paramOptions);
  
  public abstract IBaseChatPieAdapter getBaseChatPieAdapter(Context paramContext);
  
  public abstract int getChatTextSize(AppRuntime paramAppRuntime);
  
  public abstract BusinessObserver getHiBoomAuthObserver(Context paramContext);
  
  public abstract int getInvalidateHiBoomPreviewType();
  
  public abstract String getKeyIsKandianEmoticon();
  
  public abstract String getKeyIsShowAD();
  
  public abstract String getKeyIsSmallEmoticon();
  
  public abstract QQProgressDialog getProgressDialog(Context paramContext);
  
  public abstract Class<?> getQQBrowserActivityClass();
  
  public abstract void getRichTextChatConfig(AppInterface paramAppInterface);
  
  public abstract String getUserDataString();
  
  public abstract void handleHiBoomMsg(IBaseChatPieAdapter paramIBaseChatPieAdapter, String paramString);
  
  public abstract void handleHiBoomTipsInfo(Context paramContext, byte[] paramArrayOfByte, int paramInt);
  
  public abstract boolean hasSysEmotion(String paramString);
  
  public abstract void hiboomAuthForward(Activity paramActivity, int paramInt1, String paramString, int paramInt2);
  
  public abstract int initColorFont(int paramInt, String paramString);
  
  public abstract String insertMtype(String paramString1, String paramString2);
  
  public abstract Intent insertWbPlugin(Intent paramIntent, String paramString);
  
  public abstract boolean isFZEngineInited();
  
  public abstract boolean isFZSoLoaded();
  
  public abstract boolean isFragmentStyleOrEmoStore(Intent paramIntent);
  
  public abstract boolean isLaterVersionByUrlConfig(String paramString1, String paramString2);
  
  public abstract String isShowAdKey();
  
  public abstract void parseURLJson(AppRuntime paramAppRuntime);
  
  public abstract String processEmoStoreHomeUrl(String paramString);
  
  public abstract Bundle putSrcType(Bundle paramBundle);
  
  public abstract Intent putWebViewTitleStyle(Intent paramIntent, String paramString);
  
  public abstract void reportClickEventTo644(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String[] paramArrayOfString);
  
  public abstract void reportClickEventTo644V2(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String[] paramArrayOfString);
  
  public abstract void reportRedPacket(AppRuntime paramAppRuntime);
  
  public abstract void resolveFunnyPicJson(AppRuntime paramAppRuntime);
  
  public abstract void sendHiBoomMessage(AppInterface paramAppInterface, BaseSessionInfo paramBaseSessionInfo, HiBoomMessage paramHiBoomMessage, Object paramObject);
  
  public abstract Intent setBrowserTitleStyle(Intent paramIntent, String paramString);
  
  public abstract void setColorNickEnabke(boolean paramBoolean);
  
  public abstract void setHiBoomMaxSize(int paramInt);
  
  public abstract void setSignatureEnable(boolean paramBoolean);
  
  public abstract void setVipCardDrawable(Resources paramResources, ImageView paramImageView, String paramString);
  
  public abstract void startWebSoRequest(String paramString);
  
  public abstract void updateMsgFieldByUniseq(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IVasCommonAdapter
 * JD-Core Version:    0.7.0.1
 */