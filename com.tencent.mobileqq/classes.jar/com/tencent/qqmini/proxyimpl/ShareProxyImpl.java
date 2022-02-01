package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import com.tencent.qzonehub.api.IQzoneShareApi;
import eipc.EIPCClient;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import mqq.os.MqqHandler;

@ProxyService(proxy=ShareProxy.class)
public class ShareProxyImpl
  implements ShareProxy
{
  private int a(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    case 5: 
    default: 
      return 1;
    case 2: 
    case 6: 
    case 7: 
      return 3;
    case 0: 
    case 1: 
    case 4: 
      i = 2;
    }
    return i;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject1 = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject1);
    Object localObject2 = ((ByteArrayOutputStream)localObject1).toByteArray();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length original:");
    ((StringBuilder)localObject1).append(localObject2.length);
    QLog.d("AppBrandRuntime", 1, ((StringBuilder)localObject1).toString());
    int i = 0;
    localObject1 = paramBitmap;
    paramBitmap = (Bitmap)localObject2;
    while ((i < 10) && (paramBitmap.length > 32768))
    {
      paramBitmap = new Matrix();
      paramBitmap.setScale(0.7F, 0.7F);
      localObject1 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramBitmap, true);
      paramBitmap = new ByteArrayOutputStream();
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 85, paramBitmap);
      paramBitmap = paramBitmap.toByteArray();
      i += 1;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length compressTo:");
      ((StringBuilder)localObject2).append(paramBitmap.length);
      QLog.d("AppBrandRuntime", 1, ((StringBuilder)localObject2).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length done:");
    ((StringBuilder)localObject1).append(paramBitmap.length);
    QLog.d("AppBrandRuntime", 1, ((StringBuilder)localObject1).toString());
    return BitmapFactory.decodeByteArray(paramBitmap, 0, paramBitmap.length);
  }
  
  private void a(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3)
  {
    WXShareHelper localWXShareHelper;
    long l;
    StringBuilder localStringBuilder;
    if (paramInt == 3)
    {
      localWXShareHelper = WXShareHelper.a();
      l = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQ小程序 · ");
      localStringBuilder.append(paramString2);
      localWXShareHelper.d(String.valueOf(l), paramString1, paramBitmap, localStringBuilder.toString(), paramString3);
    }
    else if (paramInt == 4)
    {
      localWXShareHelper = WXShareHelper.a();
      l = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQ小程序 · ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString1);
      localWXShareHelper.c(String.valueOf(l), localStringBuilder.toString(), paramBitmap, "", paramString3);
    }
    paramString1 = new Bundle();
    paramString1.putParcelable("MiniAppInfoForSDK", paramMiniAppInfo);
    QIPCClientHelper.getInstance().getClient().callServer("MiniAppTransferModule", "mini_record_wx_share_miniapp_for_sdk", paramString1);
  }
  
  private void a(MiniAppInfo paramMiniAppInfo, Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a(paramMiniAppInfo, paramInt, paramString1, paramString2, ImageUtil.drawableToBitmap(paramActivity.getResources().getDrawable(2130850326)), paramString3);
  }
  
  private void a(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    if (paramURLDrawableListener != null)
    {
      if (paramString.getStatus() == 1)
      {
        SLog.b("ShareProxyImpl", "URLDrawable's status is SUCCESSED.");
        paramURLDrawableListener.onLoadSuccessed(paramString);
      }
      else
      {
        SLog.b("ShareProxyImpl", "start load URLDrawable.");
      }
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramString.downloadImediatly();
    }
  }
  
  private void e(InnerShareData paramInnerShareData)
  {
    if (paramInnerShareData == null) {
      return;
    }
    int i = paramInnerShareData.shareTarget;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            ShareUtils.startSharePicToQQ(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath, paramInnerShareData.shareChatModel);
            return;
          }
          ShareUtils.startSharePicToWeChat(paramInnerShareData.fromActivity, ShareUtils.getFileUri(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath), false);
          return;
        }
        ShareUtils.startSharePicToWeChat(paramInnerShareData.fromActivity, ShareUtils.getFileUri(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath), true);
        return;
      }
      ShareUtils.startSharePicToQzone(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath, paramInnerShareData.getMiniAppInfo().name);
      return;
    }
    ShareUtils.startSharePicToQQ(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath);
  }
  
  private void f(InnerShareData paramInnerShareData)
  {
    if (paramInnerShareData == null) {
      return;
    }
    int i = a(paramInnerShareData.getMiniAppInfo().verType);
    MiniProgramShareUtils.shareUpdatableMsg(paramInnerShareData.fromActivity, paramInnerShareData.getMiniAppId(), i, paramInnerShareData.templateId, paramInnerShareData.event, paramInnerShareData.callbackId, paramInnerShareData.subScene);
  }
  
  public void a(InnerShareData paramInnerShareData)
  {
    if ((paramInnerShareData != null) && (paramInnerShareData.fromActivity != null))
    {
      if (!(paramInnerShareData.fromActivity instanceof GameActivity1)) {
        QLog.e("ShareProxyImpl", 1, "shareQQArk. not GameActivity1");
      }
      MiniAppInfo localMiniAppInfo = paramInnerShareData.getMiniAppInfo();
      if (localMiniAppInfo == null)
      {
        QLog.e("ShareProxyImpl", 1, "Failed to shareQQArk. miniAppInfo is null");
        return;
      }
      ShareProxyImpl.1 local1 = new ShareProxyImpl.1(this, paramInnerShareData);
      if (paramInnerShareData.entryModel != null) {
        localObject = new com.tencent.mobileqq.mini.sdk.EntryModel(paramInnerShareData.entryModel.type, paramInnerShareData.entryModel.uin, paramInnerShareData.entryModel.name, paramInnerShareData.entryModel.isAdmin);
      } else {
        localObject = null;
      }
      com.tencent.mobileqq.mini.sdk.ShareChatModel localShareChatModel;
      if (paramInnerShareData.shareChatModel != null) {
        localShareChatModel = new com.tencent.mobileqq.mini.sdk.ShareChatModel(paramInnerShareData.shareChatModel.type, paramInnerShareData.shareChatModel.uin, paramInnerShareData.shareChatModel.name);
      } else {
        localShareChatModel = null;
      }
      Object localObject = new MiniArkShareModelBuilder().setAppId(localMiniAppInfo.appId).setTitle(localMiniAppInfo.name).setDescription(paramInnerShareData.summary).setShareScene(paramInnerShareData.shareScene).setShareTemplateType(1).setShareBusinessType(localMiniAppInfo.getReportType()).setPicUrl(paramInnerShareData.sharePicPath).setVidUrl(null).setJumpUrl(paramInnerShareData.entryPath).setIconUrl(localMiniAppInfo.iconUrl).setVersionType(localMiniAppInfo.verType).setVersionId(localMiniAppInfo.versionId).setWebURL(paramInnerShareData.webURL).setTemplateId(paramInnerShareData.templateId).setTemplateData(paramInnerShareData.templateData).setEntryModel((com.tencent.mobileqq.mini.sdk.EntryModel)localObject).setShareChatModel(localShareChatModel).setShareTarget(paramInnerShareData.shareTarget).setRcvOpenId(paramInnerShareData.recvOpenId).setWithShareTicket(paramInnerShareData.withShareTicket).setMiniAppShareFrom(paramInnerShareData.shareSource).setExtInfo(paramInnerShareData.extInfo).createMiniArkShareModel();
      ShareQQArkHelper.a(paramInnerShareData.fromActivity, (MiniArkShareModel)localObject, local1);
      return;
    }
    QLog.e("ShareProxyImpl", 1, "Failed to shareQQArk. shareData or activity is null");
  }
  
  public void b(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.fromActivity;
    Object localObject = paramInnerShareData.getMiniAppInfo();
    String str1;
    if (StringUtil.isEmpty(paramInnerShareData.summary)) {
      str1 = ((MiniAppInfo)localObject).desc;
    } else {
      str1 = paramInnerShareData.summary;
    }
    IQzoneShareApi localIQzoneShareApi = (IQzoneShareApi)QRoute.api(IQzoneShareApi.class);
    String str2 = ((MiniAppInfo)localObject).appId;
    String str3 = ((MiniAppInfo)localObject).name;
    int i = ((MiniAppInfo)localObject).getReportType();
    String str4 = paramInnerShareData.sharePicPath;
    String str5 = paramInnerShareData.entryPath;
    String str6 = ((MiniAppInfo)localObject).iconUrl;
    int j = ((MiniAppInfo)localObject).verType;
    localObject = ((MiniAppInfo)localObject).versionId;
    boolean bool;
    if (paramInnerShareData.shareSource == 11) {
      bool = true;
    } else {
      bool = false;
    }
    localIQzoneShareApi.shareQzoneForMini(localActivity, str2, str3, str1, 1, 1, i, str4, str5, str6, j, (String)localObject, bool);
  }
  
  public void c(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.fromActivity;
    if (!WXShareHelper.a().b())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareProxyImpl.2(this, localActivity));
      return;
    }
    if (!WXShareHelper.a().c())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareProxyImpl.3(this, localActivity));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startShareToWeChat. title=");
      ((StringBuilder)localObject).append(paramInnerShareData.summary);
      ((StringBuilder)localObject).append(",sharePicPath=");
      ((StringBuilder)localObject).append(paramInnerShareData.sharePicPath);
      ((StringBuilder)localObject).append(",entryPath=");
      ((StringBuilder)localObject).append(paramInnerShareData.entryPath);
      QLog.d("AppBrandRuntime", 2, ((StringBuilder)localObject).toString());
    }
    MiniAppInfo localMiniAppInfo = paramInnerShareData.getMiniAppInfo();
    if (localMiniAppInfo == null)
    {
      QLog.e("AppBrandRuntime", 1, "startShareToWeChat. apkgInfo is null!");
      return;
    }
    String str = paramInnerShareData.summary;
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = localMiniAppInfo.desc;
    }
    int i = paramInnerShareData.getShareType();
    MiniProgramShareUtils.shareAsWeChatMsg(localMiniAppInfo.appId, localMiniAppInfo.name, (String)localObject, 1, 1, localMiniAppInfo.getReportType(), paramInnerShareData.sharePicPath, null, paramInnerShareData.entryPath, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, null, i, new ShareProxyImpl.4(this, localActivity, paramInnerShareData, localMiniAppInfo, i, (String)localObject));
  }
  
  public void d(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.fromActivity;
    ThreadManager.getUIHandler().post(new ShareProxyImpl.5(this, localActivity, paramInnerShareData));
  }
  
  public int getDefaultShareTarget()
  {
    return 0;
  }
  
  public boolean isShareTargetAvailable(Context paramContext, int paramInt)
  {
    return true;
  }
  
  public void onJsShareAppMessage(Object paramObject)
  {
    if (!(paramObject instanceof InnerShareData))
    {
      QLog.w("ShareProxyImpl", 1, "onJsShareAppMessage. Unknown type of data");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onJsShareAppMessage. data = ");
    localStringBuilder.append(paramObject);
    QLog.d("ShareProxyImpl", 1, localStringBuilder.toString());
    paramObject = (InnerShareData)paramObject;
    switch (paramObject.shareTarget)
    {
    default: 
      return;
    case 7: 
      f(paramObject);
      return;
    case 3: 
    case 4: 
      c(paramObject);
      return;
    case 1: 
      b(paramObject);
      return;
    }
    a(paramObject);
  }
  
  public void onJsShareAppPictureMessage(Object paramObject)
  {
    if (!(paramObject instanceof InnerShareData))
    {
      QLog.w("ShareProxyImpl", 1, "onJsShareAppPictureMessage. Unknown type of data");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onJsShareAppMessage. data = ");
    localStringBuilder.append(paramObject);
    QLog.d("ShareProxyImpl", 1, localStringBuilder.toString());
    paramObject = (InnerShareData)paramObject;
    if (paramObject.isLocalPic)
    {
      e(paramObject);
      return;
    }
    d(paramObject);
  }
  
  public void onShareActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void share(Activity paramActivity, ShareData paramShareData) {}
  
  public void sharePic(Activity paramActivity, ShareData paramShareData)
  {
    if ((paramActivity != null) && (paramShareData != null))
    {
      if (TextUtils.isEmpty(paramShareData.sharePicPath)) {
        return;
      }
      if (paramShareData.shareTarget != 0) {
        return;
      }
      ShareUtils.startSharePicToQQ(paramActivity, paramShareData.sharePicPath);
    }
  }
  
  public void showSharePanel(IMiniAppContext paramIMiniAppContext)
  {
    ((MiniAppProxy)AppLoaderFactory.g().getProxyManager().get(MiniAppProxy.class)).onCapsuleButtonMoreClick(paramIMiniAppContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl
 * JD-Core Version:    0.7.0.1
 */