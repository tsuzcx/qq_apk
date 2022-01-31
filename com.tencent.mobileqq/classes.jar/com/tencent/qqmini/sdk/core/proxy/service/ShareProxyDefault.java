package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import bejn;
import besb;
import besf;
import besj;
import besq;
import betc;
import bfhf;
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
      localObject = new besb();
      ((besb)localObject).jdField_a_of_type_Boolean = true;
      ((besb)localObject).jdField_a_of_type_JavaLangString = paramString4;
      ((besb)localObject).e = paramString2;
      ((besb)localObject).f = paramString3;
      ((besb)localObject).jdField_b_of_type_JavaLangString = paramString1;
      shareToOther(paramActivity, (besb)localObject);
      return;
    case 0: 
      localObject = new besf();
      ((besf)localObject).jdField_b_of_type_JavaLangString = paramString3;
      ((besf)localObject).c = paramString1;
      ((besf)localObject).jdField_a_of_type_JavaLangString = paramString4;
      ((besf)localObject).jdField_a_of_type_Boolean = true;
      ((besf)localObject).e = paramString2;
      ((besf)localObject).f = paramString3;
      shareToQQ(paramActivity, (besf)localObject);
      return;
    case 1: 
      localObject = new besf();
      ((besf)localObject).jdField_b_of_type_JavaLangString = paramString3;
      ((besf)localObject).c = paramString1;
      ((besf)localObject).jdField_a_of_type_JavaLangString = paramString4;
      ((besf)localObject).jdField_a_of_type_Boolean = true;
      ((besf)localObject).e = paramString2;
      ((besf)localObject).f = paramString3;
      shareToQZone(paramActivity, (besf)localObject);
      return;
    case 3: 
      localObject = new besq();
      ((besq)localObject).jdField_a_of_type_Boolean = true;
      ((besq)localObject).jdField_a_of_type_JavaLangString = paramString4;
      ((besq)localObject).e = paramString2;
      ((besq)localObject).f = paramString3;
      ((besq)localObject).jdField_b_of_type_JavaLangString = paramString1;
      shareToWxSession(paramActivity, (besq)localObject);
      return;
    }
    Object localObject = new besq();
    ((besq)localObject).jdField_a_of_type_Boolean = true;
    ((besq)localObject).jdField_a_of_type_JavaLangString = paramString4;
    ((besq)localObject).e = paramString2;
    ((besq)localObject).f = paramString3;
    ((besq)localObject).jdField_b_of_type_JavaLangString = paramString1;
    shareToWxTimeline(paramActivity, (besq)localObject);
  }
  
  private void shareAsOther(besj parambesj, AsyncResult paramAsyncResult)
  {
    Activity localActivity = parambesj.jdField_a_of_type_AndroidAppActivity;
    if (betc.a()) {
      betc.a("ShareProxy", "shareAsOther. title=" + parambesj.jdField_a_of_type_JavaLangString + ",sharePicPath=" + parambesj.jdField_b_of_type_JavaLangString + ",entryPath=" + parambesj.c);
    }
    MiniAppInfo localMiniAppInfo = parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (localMiniAppInfo == null)
    {
      betc.d("ShareProxy", "shareAsOther. mini app info is null!");
      return;
    }
    String str2 = parambesj.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    bfhf.b(localMiniAppInfo.appId, parambesj.jdField_a_of_type_JavaLangString, str1, 1, 1, localMiniAppInfo.getReportType(), parambesj.jdField_b_of_type_JavaLangString, null, parambesj.c, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, parambesj.g, null, new ShareProxyDefault.4(this, parambesj, paramAsyncResult, localActivity));
  }
  
  private void shareAsQQ(besj parambesj, AsyncResult paramAsyncResult)
  {
    Activity localActivity = parambesj.jdField_a_of_type_AndroidAppActivity;
    if (betc.a()) {
      betc.a("ShareProxy", "shareAsQQ. title=" + parambesj.jdField_a_of_type_JavaLangString + ",sharePicPath=" + parambesj.jdField_b_of_type_JavaLangString + ",entryPath=" + parambesj.c);
    }
    MiniAppInfo localMiniAppInfo = parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (localMiniAppInfo == null)
    {
      betc.d("ShareProxy", "shareAsQQ. mini app info is null!");
      return;
    }
    String str2 = parambesj.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    bfhf.a(localMiniAppInfo.appId, parambesj.jdField_a_of_type_JavaLangString, str1, 1, 1, localMiniAppInfo.getReportType(), parambesj.jdField_b_of_type_JavaLangString, null, parambesj.c, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, parambesj.d, parambesj.jdField_b_of_type_Boolean, parambesj.e, parambesj.f, parambesj.g, null, 0, new ShareProxyDefault.1(this, parambesj, paramAsyncResult, localActivity));
  }
  
  private void shareAsQZoneFeeds(besj parambesj, AsyncResult paramAsyncResult)
  {
    Activity localActivity = parambesj.jdField_a_of_type_AndroidAppActivity;
    if (betc.a()) {
      betc.a("ShareProxy", "shareAsQZoneFeeds. title=" + parambesj.jdField_a_of_type_JavaLangString + ",sharePicPath=" + parambesj.jdField_b_of_type_JavaLangString + ",entryPath=" + parambesj.c);
    }
    MiniAppInfo localMiniAppInfo = parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (localMiniAppInfo == null)
    {
      betc.d("ShareProxy", "shareAsQZoneFeeds. mini app info is null!");
      return;
    }
    String str2 = parambesj.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    bfhf.a(localMiniAppInfo.appId, parambesj.jdField_a_of_type_JavaLangString, str1, 1, 1, localMiniAppInfo.getReportType(), parambesj.jdField_b_of_type_JavaLangString, null, parambesj.c, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, parambesj.g, null, new ShareProxyDefault.2(this, parambesj, paramAsyncResult, localActivity));
  }
  
  private void shareAsWeChat(besj parambesj, int paramInt, AsyncResult paramAsyncResult)
  {
    Activity localActivity = parambesj.jdField_a_of_type_AndroidAppActivity;
    if (betc.a()) {
      betc.a("ShareProxy", "startShareToWeChat. title=" + parambesj.jdField_a_of_type_JavaLangString + ",sharePicPath=" + parambesj.jdField_b_of_type_JavaLangString + ",entryPath=" + parambesj.c);
    }
    MiniAppInfo localMiniAppInfo = parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (localMiniAppInfo == null)
    {
      betc.d("ShareProxy", "startShareToWeChat. mini app info is null!");
      return;
    }
    String str2 = parambesj.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    bfhf.a(localMiniAppInfo.appId, localMiniAppInfo.name, str1, 1, 1, localMiniAppInfo.getReportType(), parambesj.jdField_b_of_type_JavaLangString, null, parambesj.c, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, parambesj.g, null, paramInt, new ShareProxyDefault.3(this, localActivity, parambesj, localMiniAppInfo, str1, paramAsyncResult, paramInt));
  }
  
  private void shareLocalPicMessage(besj parambesj)
  {
    if (!parambesj.jdField_a_of_type_Boolean)
    {
      betc.c("ShareProxy", "shareLocalPicMessage. not local pic");
      return;
    }
    String str = parambesj.jdField_b_of_type_JavaLangString;
    if (str == null)
    {
      betc.c("ShareProxy", "shareLocalPicMessage. local pic is null");
      return;
    }
    realSharePic(parambesj.jdField_a_of_type_AndroidAppActivity, parambesj.jdField_a_of_type_JavaLangString, parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name, str, parambesj.jdField_b_of_type_Int);
  }
  
  private void shareNetworkPicMessage(besj parambesj, AsyncResult paramAsyncResult)
  {
    paramAsyncResult = parambesj.jdField_a_of_type_AndroidAppActivity;
    bejn.c().post(new ShareProxyDefault.5(this, paramAsyncResult, parambesj));
  }
  
  public int getDefaultShareTarget()
  {
    return -1;
  }
  
  public void onJsShareAppMessage(Object paramObject, AsyncResult paramAsyncResult)
  {
    if (!(paramObject instanceof besj))
    {
      betc.c("ShareProxy", "onJsShareAppMessage. Unknown type of data");
      return;
    }
    paramObject = (besj)paramObject;
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
    if (!(paramObject instanceof besj))
    {
      betc.c("ShareProxy", "onJsShareAppPictureMessage. Unknown type of data");
      return;
    }
    paramObject = (besj)paramObject;
    if (paramObject.jdField_a_of_type_Boolean)
    {
      shareLocalPicMessage(paramObject);
      return;
    }
    shareNetworkPicMessage(paramObject, paramAsyncResult);
  }
  
  protected void shareToOther(Activity paramActivity, besb parambesb) {}
  
  protected void shareToQQ(Activity paramActivity, besf parambesf) {}
  
  protected void shareToQZone(Activity paramActivity, besf parambesf) {}
  
  protected void shareToWxSession(Activity paramActivity, besq parambesq) {}
  
  protected void shareToWxTimeline(Activity paramActivity, besq parambesq) {}
  
  public void showShareMenuForInnerShareButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, HashMap<String, Integer> paramHashMap, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault
 * JD-Core Version:    0.7.0.1
 */