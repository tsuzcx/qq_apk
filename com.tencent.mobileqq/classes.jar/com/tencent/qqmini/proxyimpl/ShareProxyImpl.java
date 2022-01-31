package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import bdje;
import bizm;
import bizt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.model.InnerShareData;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import com.tencent.qqmini.sdk.log.QMLog;
import cooperation.qzone.share.QZoneShareActivity;
import eipc.EIPCClient;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import wsv;

public class ShareProxyImpl
  implements ShareProxy
{
  private static final String TAG = "ShareProxyImpl";
  
  private void downloadImageByURLDrawable(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    if (paramURLDrawableListener != null)
    {
      if (paramString.getStatus() != 1) {
        break label44;
      }
      wsv.b("ShareProxyImpl", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramString);
    }
    for (;;)
    {
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramString.downloadImediatly();
      return;
      label44:
      wsv.b("ShareProxyImpl", "start load URLDrawable.");
    }
  }
  
  private void realSharePic(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      ShareUtils.startSharePicToQQ(paramActivity, paramString3);
      return;
    case 1: 
      startSharePicToQzone(paramActivity, paramString1, paramString3, paramString2);
      return;
    case 3: 
      ShareUtils.startSharePicToWeChat(paramActivity, paramString3, true);
      return;
    }
    ShareUtils.startSharePicToWeChat(paramActivity, paramString3, false);
  }
  
  public static void startSharePicToQzone(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 2, "startSharePicToQzone. content=" + paramString1 + ",localPicPath=" + paramString2);
    }
    bizt localbizt = bizt.a();
    localbizt.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bizm.a(paramActivity, localbizt, paramString2, paramString3, paramString1, -1);
    paramActivity = new Bundle();
    paramActivity.putString("key_mini_report_event_action_type", "user_click");
    paramActivity.putString("key_mini_report_event_sub_action_type", "custom_button");
    paramActivity.putString("key_mini_report_event_reserves", "share_QZ");
    paramActivity.putString("key_mini_report_event_reserves2", "success");
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", paramActivity, null);
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
      QMLog.w("ShareProxyImpl", "onJsShareAppMessage. Unknown type of data");
      return;
    }
    QMLog.d("ShareProxyImpl", "onJsShareAppMessage. data = " + paramObject);
    paramObject = (InnerShareData)paramObject;
    switch (paramObject.shareTarget)
    {
    default: 
      return;
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      shareQQArk(paramObject);
      return;
    case 1: 
      shareQzone(paramObject);
      return;
    }
    shareToWeChat(paramObject);
  }
  
  public void onJsShareAppPictureMessage(Object paramObject)
  {
    if (!(paramObject instanceof InnerShareData))
    {
      QMLog.w("ShareProxyImpl", "onJsShareAppPictureMessage. Unknown type of data");
      return;
    }
    QMLog.d("ShareProxyImpl", "onJsShareAppMessage. data = " + paramObject);
    paramObject = (InnerShareData)paramObject;
    if (paramObject.isLocalPic)
    {
      shareLocalPicMessage(paramObject);
      return;
    }
    shareNetworkPicMessage(paramObject);
  }
  
  public void onShareActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void share(Activity paramActivity, ShareData paramShareData) {}
  
  public void shareLocalPicMessage(InnerShareData paramInnerShareData)
  {
    if (!paramInnerShareData.isLocalPic)
    {
      QMLog.w("ShareProxyImpl", "Failed to shareLocalPicMessage. not local pic");
      return;
    }
    Object localObject = paramInnerShareData.sharePicPath;
    if (localObject == null)
    {
      QMLog.w("ShareProxyImpl", "Failed to shareLocalPicMessage. local pic is null");
      return;
    }
    MiniAppInfo localMiniAppInfo = paramInnerShareData.a();
    if (localMiniAppInfo == null)
    {
      QMLog.w("ShareProxyImpl", "Failed to shareLocalPicMessage. miniAppInfo is null");
      return;
    }
    if (((String)localObject).startsWith(BaseApplicationImpl.getContext().getFilesDir().getPath()))
    {
      localObject = new File((String)localObject);
      String str = ((File)localObject).getName();
      ThreadManager.excute(new ShareProxyImpl.6(this, (File)localObject, str), 64, new ShareProxyImpl.7(this, str, paramInnerShareData, localMiniAppInfo), true);
      return;
    }
    realSharePic(paramInnerShareData.jdField_a_of_type_AndroidAppActivity, paramInnerShareData.summary, localMiniAppInfo.name, (String)localObject, paramInnerShareData.shareTarget);
  }
  
  public void shareNetworkPicMessage(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.jdField_a_of_type_AndroidAppActivity;
    ThreadManager.getUIHandler().post(new ShareProxyImpl.5(this, localActivity, paramInnerShareData));
  }
  
  public void shareQQArk(InnerShareData paramInnerShareData)
  {
    if ((paramInnerShareData == null) || (paramInnerShareData.jdField_a_of_type_AndroidAppActivity == null))
    {
      QMLog.e("ShareProxyImpl", "Failed to shareQQArk. shareData or activity is null");
      return;
    }
    if (!(paramInnerShareData.jdField_a_of_type_AndroidAppActivity instanceof GameActivity1))
    {
      QMLog.e("ShareProxyImpl", "Failed to shareQQArk. not GameActivity1");
      return;
    }
    MiniAppInfo localMiniAppInfo = paramInnerShareData.a();
    if (localMiniAppInfo == null)
    {
      QMLog.e("ShareProxyImpl", "Failed to shareQQArk. miniAppInfo is null");
      return;
    }
    ShareProxyImpl.1 local1 = new ShareProxyImpl.1(this, paramInnerShareData);
    com.tencent.mobileqq.mini.sdk.EntryModel localEntryModel;
    if (paramInnerShareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel != null)
    {
      localEntryModel = new com.tencent.mobileqq.mini.sdk.EntryModel(paramInnerShareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.type, paramInnerShareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.uin, paramInnerShareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.name, paramInnerShareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.isAdmin);
      if (paramInnerShareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel == null) {
        break label306;
      }
    }
    label306:
    for (com.tencent.mobileqq.mini.sdk.ShareChatModel localShareChatModel = new com.tencent.mobileqq.mini.sdk.ShareChatModel(paramInnerShareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel.type, paramInnerShareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel.uin, paramInnerShareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel.name);; localShareChatModel = null)
    {
      MiniProgramShareUtils.shareAsArkMessage(paramInnerShareData.jdField_a_of_type_AndroidAppActivity, new MiniArkShareModelBuilder().setAppId(localMiniAppInfo.appId).setTitle(localMiniAppInfo.name).setDescription(paramInnerShareData.summary).setShareScene(1).setShareTemplateType(1).setShareBusinessType(localMiniAppInfo.getReportType()).setPicUrl(paramInnerShareData.sharePicPath).setVidUrl(null).setJumpUrl(paramInnerShareData.jdField_a_of_type_JavaLangString).setIconUrl(localMiniAppInfo.iconUrl).setVersionType(localMiniAppInfo.verType).setVersionId(localMiniAppInfo.versionId).setWebURL(paramInnerShareData.b).setTemplateId(paramInnerShareData.c).setTemplateData(paramInnerShareData.d).setEntryModel(localEntryModel).setShareChatModel(localShareChatModel).setShareTarget(paramInnerShareData.shareTarget).setRcvOpenId(paramInnerShareData.e).createMiniArkShareModel(), paramInnerShareData.jdField_a_of_type_Boolean, paramInnerShareData.shareSource, local1);
      return;
      localEntryModel = null;
      break;
    }
  }
  
  public void shareQzone(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.jdField_a_of_type_AndroidAppActivity;
    MiniAppInfo localMiniAppInfo = paramInnerShareData.a();
    String str;
    Intent localIntent;
    if (bdje.a(paramInnerShareData.summary))
    {
      str = localMiniAppInfo.desc;
      localIntent = new Intent();
      localIntent.setClassName("com.tencent.mobileqq", QZoneShareActivity.class.getName());
      localIntent.putExtra("isSharedFromMiniProgram", true);
      localIntent.putExtra("miniShareParamAppId", localMiniAppInfo.appId);
      localIntent.putExtra("miniShareParamTitle", localMiniAppInfo.name);
      localIntent.putExtra("miniShareParamDescription", str);
      localIntent.putExtra("miniShareParamShareScene", 1);
      localIntent.putExtra("miniShareParamTemplateType", 1);
      localIntent.putExtra("miniShareParamBusinessType", localMiniAppInfo.getReportType());
      localIntent.putExtra("miniShareParamPicUrl", paramInnerShareData.sharePicPath);
      localIntent.putExtra("miniShareParamJumpUrl", paramInnerShareData.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("miniShareParamIconUrl", localMiniAppInfo.iconUrl);
      localIntent.putExtra("miniShareParamVersionType", localMiniAppInfo.verType);
      localIntent.putExtra("miniShareParamVersionId", localMiniAppInfo.versionId);
      if (paramInnerShareData.shareSource != 11) {
        break label239;
      }
    }
    label239:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("miniShareIsFromInnerButton", bool);
      localActivity.startActivity(localIntent);
      return;
      str = paramInnerShareData.summary;
      break;
    }
  }
  
  public void shareToWeChat(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.jdField_a_of_type_AndroidAppActivity;
    if (!WXShareHelper.a().a())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareProxyImpl.2(this, localActivity));
      return;
    }
    if (!WXShareHelper.a().b())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareProxyImpl.3(this, localActivity));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 2, "startShareToWeChat. title=" + paramInnerShareData.summary + ",sharePicPath=" + paramInnerShareData.sharePicPath + ",entryPath=" + paramInnerShareData.jdField_a_of_type_JavaLangString);
    }
    MiniAppInfo localMiniAppInfo = paramInnerShareData.a();
    if (localMiniAppInfo == null)
    {
      QLog.e("AppBrandRuntime", 1, "startShareToWeChat. apkgInfo is null!");
      return;
    }
    String str2 = paramInnerShareData.summary;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    int i = paramInnerShareData.a();
    MiniProgramShareUtils.shareAsWeChatMsg(localMiniAppInfo.appId, localMiniAppInfo.name, str1, 1, 1, localMiniAppInfo.getReportType(), paramInnerShareData.sharePicPath, null, paramInnerShareData.jdField_a_of_type_JavaLangString, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, null, i, new ShareProxyImpl.4(this, localActivity, paramInnerShareData, i, str1, localMiniAppInfo));
  }
  
  public void showShareMenuForInnerShareButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, HashMap<String, Integer> paramHashMap, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl
 * JD-Core Version:    0.7.0.1
 */