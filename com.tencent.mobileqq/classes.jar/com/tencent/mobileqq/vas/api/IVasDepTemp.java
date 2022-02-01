package com.tencent.mobileqq.vas.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import java.io.File;
import java.util.List;
import mqq.app.AppRuntime;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

@QAPI(process={"all"})
public abstract interface IVasDepTemp
  extends QRouteApi
{
  public abstract void colorRingDownload(AppRuntime paramAppRuntime, int paramInt1, boolean paramBoolean, int paramInt2, IPCDownloadListener paramIPCDownloadListener);
  
  public abstract String convert2SharpPFilePath(File paramFile);
  
  public abstract Card findAndCreateCardByUin(String paramString);
  
  public abstract Friends findFriendEntityByUin(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void flatBuffersParserSetEnable(boolean paramBoolean);
  
  public abstract DownloaderInterface getDownloader(AppRuntime paramAppRuntime);
  
  public abstract Intent getQQBrowserIntent();
  
  public abstract void guanjiaReport(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3);
  
  public abstract boolean isBelongServiceAccountFolderInner(String paramString);
  
  public abstract boolean isCanOpenGxhHippyPage();
  
  public abstract boolean isCanOpenQQVipHippyPage();
  
  public abstract boolean isEnable();
  
  public abstract boolean isEnableGetAuth(String paramString1, String paramString2);
  
  public abstract boolean isFunctionAvaliable(Context paramContext);
  
  public abstract boolean isQQBrowserActivity(Activity paramActivity);
  
  public abstract void openGxhHippyPage();
  
  public abstract void openQQVipHippyPage();
  
  public abstract void registerSeqKey(IJce paramIJce, String paramString);
  
  public abstract void reportKCLP(long paramLong, int paramInt);
  
  public abstract void requestPreDownload(File paramFile, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, RunnableTask paramRunnableTask);
  
  public abstract void sendGetBaseVipInfoReq(String paramString1, String paramString2);
  
  public abstract void sendSpecialCareEvent(List<String> paramList1, int paramInt, List<String> paramList2, AppRuntime paramAppRuntime);
  
  public abstract boolean setContentBackground(View paramView, int paramInt);
  
  public abstract boolean setContentBackground(View paramView, Drawable paramDrawable);
  
  public abstract int specialSoundDownload(DownloadTask paramDownloadTask);
  
  public abstract void startDownload(AppRuntime paramAppRuntime, Bundle paramBundle, DownloadTask paramDownloadTask, DownloadListener paramDownloadListener);
  
  public abstract void startKingCardActivationFragment();
  
  public abstract void startPhotoListEditForResult(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5);
  
  public abstract void unRegisterSeqKey(String paramString);
  
  public abstract void updateDisPlayInteval(long paramLong);
  
  public abstract void vipFuncallReport(String paramString, boolean paramBoolean, int paramInt, long paramLong);
  
  public abstract byte[] websoEncode(String paramString1, long paramLong, HttpReq paramHttpReq, String paramString2);
  
  public abstract HttpResponse websoExecuteHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity);
  
  public abstract String websoGetAPN();
  
  public abstract String websoGetCookie4WebSoOrSonic(String paramString);
  
  public abstract String websoGetQUA();
  
  public abstract HttpRsp websoOnResponse(byte[] paramArrayOfByte, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IVasDepTemp
 * JD-Core Version:    0.7.0.1
 */