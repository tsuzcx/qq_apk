package com.tencent.mobileqq.vas.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QvipSpecialCareHandler;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.VasService;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.config.business.QVipHippyConfig;
import com.tencent.mobileqq.vas.config.business.QVipHippyConfig.HippyInfo;
import com.tencent.mobileqq.vas.config.business.QVipHippyProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.mobileqq.vip.KingCardActivationFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.webso.WebSoRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHttpUtil;
import cooperation.qzone.report.lp.LpReportInfo_dc04233;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.ProtocolUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

public class VasDepTempImpl
  implements IVasDepTemp
{
  public void colorRingDownload(AppRuntime paramAppRuntime, int paramInt1, boolean paramBoolean, int paramInt2, IPCDownloadListener paramIPCDownloadListener)
  {
    paramAppRuntime = (ColorRingManager)paramAppRuntime.getManager(QQManagerFactory.COLOR_RING_MANAGER);
    paramAppRuntime.a = paramIPCDownloadListener;
    paramAppRuntime.a(paramInt1, 3, paramBoolean, paramInt2, "comering");
  }
  
  public String convert2SharpPFilePath(File paramFile)
  {
    return QQSharpPUtil.a(paramFile);
  }
  
  public Card findAndCreateCardByUin(String paramString)
  {
    return null;
  }
  
  public Friends findFriendEntityByUin(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramAppRuntime != null) {
      return paramAppRuntime.e(paramString);
    }
    return null;
  }
  
  public void flatBuffersParserSetEnable(boolean paramBoolean)
  {
    FlatBuffersParser.a(paramBoolean);
  }
  
  public DownloaderInterface getDownloader(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof ToolAppRuntime))
    {
      paramAppRuntime = paramAppRuntime.getAppRuntime("modular_web");
      if ((paramAppRuntime instanceof BrowserAppInterface))
      {
        paramAppRuntime = paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
        break label86;
      }
    }
    else
    {
      if ((paramAppRuntime instanceof QQAppInterface))
      {
        paramAppRuntime = paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
        break label86;
      }
      if ((paramAppRuntime instanceof QzoneMainRuntime))
      {
        paramAppRuntime = BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("qzone_plugin.apk");
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
          break label86;
        }
      }
    }
    paramAppRuntime = null;
    label86:
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof DownloaderFactory))) {
      return ((DownloaderFactory)paramAppRuntime).a(1);
    }
    return null;
  }
  
  public Intent getQQBrowserIntent()
  {
    return new Intent(MobileQQ.getContext(), QQBrowserActivity.class);
  }
  
  public void guanjiaReport(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3)
  {
    VipInfoHandler localVipInfoHandler = (VipInfoHandler)VasUtil.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
    if (localVipInfoHandler != null) {
      localVipInfoHandler.a(paramString1, paramString2, paramBoolean, paramInt, paramString3);
    }
  }
  
  public boolean isBelongServiceAccountFolderInner(String paramString)
  {
    return ServiceAccountFolderManager.a(VasUtil.a(), paramString);
  }
  
  public boolean isCanOpenGxhHippyPage()
  {
    return QVipHippyConfig.isCanOpenGxhHippyPage();
  }
  
  public boolean isCanOpenQQVipHippyPage()
  {
    return QVipHippyConfig.isCanOpenQQVipHippyPage();
  }
  
  public boolean isEnable()
  {
    return ((IPreDownloadController)VasUtil.a().getRuntimeService(IPreDownloadController.class, "")).isEnable();
  }
  
  public boolean isEnableGetAuth(String paramString1, String paramString2)
  {
    return QVipHippyProcessor.a().isEnableGetAuth(paramString1, paramString2);
  }
  
  public boolean isFunctionAvaliable(Context paramContext)
  {
    return QQSharpPUtil.a(paramContext);
  }
  
  public boolean isQQBrowserActivity(Activity paramActivity)
  {
    return paramActivity instanceof QQBrowserActivity;
  }
  
  public void openGxhHippyPage()
  {
    Object localObject = QVipHippyProcessor.a().getHippyInfoFromKey("qqgxh");
    IHippyAccessHelper localIHippyAccessHelper = (IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class);
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (localObject != null) {
      localObject = ((QVipHippyConfig.HippyInfo)localObject).openParams;
    } else {
      localObject = null;
    }
    localIHippyAccessHelper.openHippyPage(localBaseApplication, (OpenHippyInfo)localObject);
  }
  
  public void openQQVipHippyPage()
  {
    Object localObject = QVipHippyProcessor.a().getHippyInfoFromKey("QQVip");
    IHippyAccessHelper localIHippyAccessHelper = (IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class);
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (localObject != null) {
      localObject = ((QVipHippyConfig.HippyInfo)localObject).openParams;
    } else {
      localObject = null;
    }
    localIHippyAccessHelper.openHippyPage(localBaseApplication, (OpenHippyInfo)localObject);
  }
  
  public void registerSeqKey(IJce paramIJce, String paramString)
  {
    VasService.a(paramIJce, paramString);
  }
  
  public void reportKCLP(long paramLong, int paramInt)
  {
    new LpReportInfo_dc04233(paramLong, paramInt).report();
  }
  
  public void requestPreDownload(File paramFile, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, RunnableTask paramRunnableTask)
  {
    try
    {
      ((IPreDownloadController)VasUtil.a().getRuntimeService(IPreDownloadController.class, "")).requestPreDownload(paramInt1, paramString2, "vas_special_remind", 0, paramString1, paramFile.getCanonicalPath(), paramInt2, paramInt3, false, paramRunnableTask);
      return;
    }
    catch (IOException paramFile)
    {
      label38:
      break label38;
    }
    throw new RuntimeException("getCanonicalPath: Invalid file path");
  }
  
  public void sendGetBaseVipInfoReq(String paramString1, String paramString2)
  {
    VipInfoHandler localVipInfoHandler = (VipInfoHandler)VasUtil.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
    if (localVipInfoHandler != null) {
      localVipInfoHandler.a(paramString1, paramString2);
    }
  }
  
  public void sendSpecialCareEvent(List<String> paramList1, int paramInt, List<String> paramList2, AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      return;
    }
    paramAppRuntime = (QvipSpecialCareHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.SPECIAL_CARE_HANDLER);
    if (paramAppRuntime != null) {
      paramAppRuntime.a(paramList1, paramInt, paramList2);
    }
  }
  
  public boolean setContentBackground(View paramView, int paramInt)
  {
    if ((paramView instanceof ChatXListView))
    {
      ((ChatXListView)paramView).setContentBackground(paramInt);
      return true;
    }
    return false;
  }
  
  public boolean setContentBackground(View paramView, Drawable paramDrawable)
  {
    if ((paramView instanceof ChatXListView))
    {
      ((ChatXListView)paramView).setContentBackground(paramDrawable);
      return true;
    }
    return false;
  }
  
  public int specialSoundDownload(DownloadTask paramDownloadTask)
  {
    AppRuntime localAppRuntime = VasUtil.a();
    Object localObject = localAppRuntime;
    if (localAppRuntime == null) {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return DownloaderFactory.a(paramDownloadTask, (AppRuntime)localObject);
  }
  
  public void startDownload(AppRuntime paramAppRuntime, Bundle paramBundle, DownloadTask paramDownloadTask, DownloadListener paramDownloadListener)
  {
    ((DownloaderFactory)paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).startDownload(paramDownloadTask, paramDownloadListener, paramBundle);
  }
  
  public void startKingCardActivationFragment()
  {
    PublicFragmentActivity.a(BaseApplicationImpl.getContext(), KingCardActivationFragment.class);
  }
  
  public void startPhotoListEditForResult(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    PhotoUtils.startPhotoListEditForResult(paramIntent, paramActivity, paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, paramInt5);
  }
  
  public void unRegisterSeqKey(String paramString)
  {
    VasService.a(paramString);
  }
  
  public void updateDisPlayInteval(long paramLong)
  {
    ((ICommercialDrainageManagerService)VasUtil.a().getRuntimeService(ICommercialDrainageManagerService.class, "")).updateDisPlayInteval(paramLong);
  }
  
  public void vipFuncallReport(String paramString, boolean paramBoolean, int paramInt, long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("_t");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramBoolean);
    ((StringBuilder)localObject3).append("");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramLong);
    ((StringBuilder)localObject4).append("");
    localObject4 = ((StringBuilder)localObject4).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("_p");
    VasReportUtils.a("externalStorageType", paramString, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, localStringBuilder.toString(), "", "", "");
  }
  
  public byte[] websoEncode(String paramString1, long paramLong, HttpReq paramHttpReq, String paramString2)
  {
    return new WebSoRequest(paramString1, paramLong, paramHttpReq, paramString2).encode();
  }
  
  public HttpResponse websoExecuteHttpPost(Context paramContext, String paramString, HttpEntity paramHttpEntity)
  {
    return QZoneHttpUtil.executeHttpPost(paramContext, paramString, paramHttpEntity);
  }
  
  public String websoGetAPN()
  {
    return NetworkState.getAPN();
  }
  
  public String websoGetCookie4WebSoOrSonic(String paramString)
  {
    return SwiftBrowserCookieMonster.c(paramString);
  }
  
  public String websoGetQUA()
  {
    return QUA.getQUA3();
  }
  
  public HttpRsp websoOnResponse(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = (HttpRsp)ProtocolUtils.decode(paramArrayOfByte, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e("WebSoRequest", 1, "onResponse error:", paramArrayOfByte);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasDepTempImpl
 * JD-Core Version:    0.7.0.1
 */