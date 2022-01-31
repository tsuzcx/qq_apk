package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import beiw;
import berk;
import bero;
import bers;
import berz;
import besl;
import bfgo;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;

public class ShareProxyDefault
  implements ShareProxy
{
  private static final String TAG = "ShareProxy";
  
  private void downloadImageByURL(String paramString, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, null, 60, paramDownloadListener);
  }
  
  private void realSharePic(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      localObject = new berk();
      ((berk)localObject).jdField_a_of_type_Boolean = true;
      ((berk)localObject).jdField_a_of_type_JavaLangString = paramString4;
      ((berk)localObject).e = paramString2;
      ((berk)localObject).f = paramString3;
      ((berk)localObject).jdField_b_of_type_JavaLangString = paramString1;
      shareToOther(paramActivity, (berk)localObject);
      return;
    case 0: 
      localObject = new bero();
      ((bero)localObject).jdField_b_of_type_JavaLangString = paramString3;
      ((bero)localObject).c = paramString1;
      ((bero)localObject).jdField_a_of_type_JavaLangString = paramString4;
      ((bero)localObject).jdField_a_of_type_Boolean = true;
      ((bero)localObject).e = paramString2;
      ((bero)localObject).f = paramString3;
      shareToQQ(paramActivity, (bero)localObject);
      return;
    case 1: 
      localObject = new bero();
      ((bero)localObject).jdField_b_of_type_JavaLangString = paramString3;
      ((bero)localObject).c = paramString1;
      ((bero)localObject).jdField_a_of_type_JavaLangString = paramString4;
      ((bero)localObject).jdField_a_of_type_Boolean = true;
      ((bero)localObject).e = paramString2;
      ((bero)localObject).f = paramString3;
      shareToQZone(paramActivity, (bero)localObject);
      return;
    case 3: 
      localObject = new berz();
      ((berz)localObject).jdField_a_of_type_Boolean = true;
      ((berz)localObject).jdField_a_of_type_JavaLangString = paramString4;
      ((berz)localObject).e = paramString2;
      ((berz)localObject).f = paramString3;
      ((berz)localObject).jdField_b_of_type_JavaLangString = paramString1;
      shareToWxSession(paramActivity, (berz)localObject);
      return;
    }
    Object localObject = new berz();
    ((berz)localObject).jdField_a_of_type_Boolean = true;
    ((berz)localObject).jdField_a_of_type_JavaLangString = paramString4;
    ((berz)localObject).e = paramString2;
    ((berz)localObject).f = paramString3;
    ((berz)localObject).jdField_b_of_type_JavaLangString = paramString1;
    shareToWxTimeline(paramActivity, (berz)localObject);
  }
  
  private void shareAsOther(bers parambers, AsyncResult paramAsyncResult)
  {
    Activity localActivity = parambers.jdField_a_of_type_AndroidAppActivity;
    if (besl.a()) {
      besl.a("ShareProxy", "shareAsOther. title=" + parambers.jdField_a_of_type_JavaLangString + ",sharePicPath=" + parambers.jdField_b_of_type_JavaLangString + ",entryPath=" + parambers.c);
    }
    MiniAppInfo localMiniAppInfo = parambers.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (localMiniAppInfo == null)
    {
      besl.d("ShareProxy", "shareAsOther. mini app info is null!");
      return;
    }
    String str2 = parambers.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    bfgo.b(localMiniAppInfo.appId, parambers.jdField_a_of_type_JavaLangString, str1, 1, 1, localMiniAppInfo.getReportType(), parambers.jdField_b_of_type_JavaLangString, null, parambers.c, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, parambers.g, null, new ShareProxyDefault.4(this, parambers, paramAsyncResult, localActivity));
  }
  
  private void shareAsQQ(bers parambers, AsyncResult paramAsyncResult)
  {
    Activity localActivity = parambers.jdField_a_of_type_AndroidAppActivity;
    if (besl.a()) {
      besl.a("ShareProxy", "shareAsQQ. title=" + parambers.jdField_a_of_type_JavaLangString + ",sharePicPath=" + parambers.jdField_b_of_type_JavaLangString + ",entryPath=" + parambers.c);
    }
    MiniAppInfo localMiniAppInfo = parambers.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (localMiniAppInfo == null)
    {
      besl.d("ShareProxy", "shareAsQQ. mini app info is null!");
      return;
    }
    String str2 = parambers.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    bfgo.a(localMiniAppInfo.appId, parambers.jdField_a_of_type_JavaLangString, str1, 1, 1, localMiniAppInfo.getReportType(), parambers.jdField_b_of_type_JavaLangString, null, parambers.c, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, parambers.d, parambers.jdField_b_of_type_Boolean, parambers.e, parambers.f, parambers.g, null, 0, new ShareProxyDefault.1(this, parambers, paramAsyncResult, localActivity));
  }
  
  private void shareAsQZoneFeeds(bers parambers, AsyncResult paramAsyncResult)
  {
    Activity localActivity = parambers.jdField_a_of_type_AndroidAppActivity;
    if (besl.a()) {
      besl.a("ShareProxy", "shareAsQZoneFeeds. title=" + parambers.jdField_a_of_type_JavaLangString + ",sharePicPath=" + parambers.jdField_b_of_type_JavaLangString + ",entryPath=" + parambers.c);
    }
    MiniAppInfo localMiniAppInfo = parambers.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (localMiniAppInfo == null)
    {
      besl.d("ShareProxy", "shareAsQZoneFeeds. mini app info is null!");
      return;
    }
    String str2 = parambers.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    bfgo.a(localMiniAppInfo.appId, parambers.jdField_a_of_type_JavaLangString, str1, 1, 1, localMiniAppInfo.getReportType(), parambers.jdField_b_of_type_JavaLangString, null, parambers.c, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, parambers.g, null, new ShareProxyDefault.2(this, parambers, paramAsyncResult, localActivity));
  }
  
  private void shareAsWeChat(bers parambers, int paramInt, AsyncResult paramAsyncResult)
  {
    Activity localActivity = parambers.jdField_a_of_type_AndroidAppActivity;
    if (besl.a()) {
      besl.a("ShareProxy", "startShareToWeChat. title=" + parambers.jdField_a_of_type_JavaLangString + ",sharePicPath=" + parambers.jdField_b_of_type_JavaLangString + ",entryPath=" + parambers.c);
    }
    MiniAppInfo localMiniAppInfo = parambers.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (localMiniAppInfo == null)
    {
      besl.d("ShareProxy", "startShareToWeChat. mini app info is null!");
      return;
    }
    String str2 = parambers.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    bfgo.a(localMiniAppInfo.appId, localMiniAppInfo.name, str1, 1, 1, localMiniAppInfo.getReportType(), parambers.jdField_b_of_type_JavaLangString, null, parambers.c, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, parambers.g, null, paramInt, new ShareProxyDefault.3(this, localActivity, parambers, localMiniAppInfo, str1, paramAsyncResult, paramInt));
  }
  
  private void shareLocalPicMessage(bers parambers)
  {
    if (!parambers.jdField_a_of_type_Boolean)
    {
      besl.c("ShareProxy", "shareLocalPicMessage. not local pic");
      return;
    }
    String str = parambers.jdField_b_of_type_JavaLangString;
    if (str == null)
    {
      besl.c("ShareProxy", "shareLocalPicMessage. local pic is null");
      return;
    }
    realSharePic(parambers.jdField_a_of_type_AndroidAppActivity, parambers.jdField_a_of_type_JavaLangString, parambers.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, parambers.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name, str, parambers.jdField_b_of_type_Int);
  }
  
  private void shareNetworkPicMessage(bers parambers, AsyncResult paramAsyncResult)
  {
    paramAsyncResult = parambers.jdField_a_of_type_AndroidAppActivity;
    beiw.c().post(new ShareProxyDefault.5(this, paramAsyncResult, parambers));
  }
  
  public int getDefaultShareTarget()
  {
    return -1;
  }
  
  public void onJsShareAppMessage(Object paramObject, AsyncResult paramAsyncResult)
  {
    if (!(paramObject instanceof bers))
    {
      besl.c("ShareProxy", "onJsShareAppMessage. Unknown type of data");
      return;
    }
    paramObject = (bers)paramObject;
    switch (paramObject.jdField_b_of_type_Int)
    {
    default: 
      shareAsOther(paramObject, paramAsyncResult);
      return;
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      shareAsQQ(paramObject, paramAsyncResult);
      return;
    case 1: 
      shareAsQZoneFeeds(paramObject, paramAsyncResult);
      return;
    case 3: 
      shareAsWeChat(paramObject, 3, paramAsyncResult);
      return;
    }
    shareAsWeChat(paramObject, 4, paramAsyncResult);
  }
  
  public void onJsShareAppPictureMessage(Object paramObject, AsyncResult paramAsyncResult)
  {
    if (!(paramObject instanceof bers))
    {
      besl.c("ShareProxy", "onJsShareAppPictureMessage. Unknown type of data");
      return;
    }
    paramObject = (bers)paramObject;
    if (paramObject.jdField_a_of_type_Boolean)
    {
      shareLocalPicMessage(paramObject);
      return;
    }
    shareNetworkPicMessage(paramObject, paramAsyncResult);
  }
  
  protected void shareToOther(Activity paramActivity, berk paramberk) {}
  
  protected void shareToQQ(Activity paramActivity, bero parambero) {}
  
  protected void shareToQZone(Activity paramActivity, bero parambero) {}
  
  protected void shareToWxSession(Activity paramActivity, berz paramberz) {}
  
  protected void shareToWxTimeline(Activity paramActivity, berz paramberz) {}
  
  public void showShareMenuForInnerShareButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, HashMap<String, Integer> paramHashMap, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault
 * JD-Core Version:    0.7.0.1
 */