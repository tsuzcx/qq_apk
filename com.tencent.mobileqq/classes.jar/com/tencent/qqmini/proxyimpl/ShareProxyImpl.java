package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import bbkk;
import besj;
import betc;
import bgyp;
import bgyw;
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
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import cooperation.qzone.share.QZoneShareActivity;
import eipc.EIPCClient;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import ved;

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
      ved.b("ShareProxyImpl", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramString);
    }
    for (;;)
    {
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramString.downloadImediatly();
      return;
      label44:
      ved.b("ShareProxyImpl", "start load URLDrawable.");
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
    bgyw localbgyw = bgyw.a();
    localbgyw.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bgyp.a(paramActivity, localbgyw, paramString2, paramString3, paramString1, -1);
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
  
  public void onJsShareAppMessage(Object paramObject, AsyncResult paramAsyncResult)
  {
    if (!(paramObject instanceof besj))
    {
      betc.c("ShareProxyImpl", "onJsShareAppMessage. Unknown type of data");
      return;
    }
    paramObject = (besj)paramObject;
    switch (paramObject.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      shareQQArk(paramObject, paramAsyncResult);
      return;
    case 1: 
      shareQzone(paramObject);
      return;
    case 3: 
      shareToWeChat(paramObject, 3);
      return;
    }
    shareToWeChat(paramObject, 4);
  }
  
  public void onJsShareAppPictureMessage(Object paramObject, AsyncResult paramAsyncResult)
  {
    if (!(paramObject instanceof besj))
    {
      betc.c("ShareProxyImpl", "onJsShareAppPictureMessage. Unknown type of data");
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
  
  public void shareLocalPicMessage(besj parambesj)
  {
    if (!parambesj.jdField_a_of_type_Boolean)
    {
      betc.c("ShareProxyImpl", "shareLocalPicMessage. not local pic");
      return;
    }
    Object localObject = parambesj.jdField_b_of_type_JavaLangString;
    if (localObject == null)
    {
      betc.c("ShareProxyImpl", "shareLocalPicMessage. local pic is null");
      return;
    }
    if (((String)localObject).startsWith(BaseApplicationImpl.getContext().getFilesDir().getPath()))
    {
      localObject = new File((String)localObject);
      String str = ((File)localObject).getName();
      ThreadManager.excute(new ShareProxyImpl.6(this, (File)localObject, str), 64, new ShareProxyImpl.7(this, str, parambesj), true);
      return;
    }
    realSharePic(parambesj.jdField_a_of_type_AndroidAppActivity, parambesj.jdField_a_of_type_JavaLangString, parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name, (String)localObject, parambesj.jdField_b_of_type_Int);
  }
  
  public void shareNetworkPicMessage(besj parambesj, AsyncResult paramAsyncResult)
  {
    paramAsyncResult = parambesj.jdField_a_of_type_AndroidAppActivity;
    ThreadManager.getUIHandler().post(new ShareProxyImpl.5(this, paramAsyncResult, parambesj));
  }
  
  public void shareQQArk(besj parambesj, AsyncResult paramAsyncResult)
  {
    if ((parambesj == null) || (parambesj.jdField_a_of_type_AndroidAppActivity == null)) {}
    while ((!(parambesj.jdField_a_of_type_AndroidAppActivity instanceof GameActivity1)) || (parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null)) {
      return;
    }
    ShareProxyImpl.1 local1 = new ShareProxyImpl.1(this, paramAsyncResult);
    if (parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel != null)
    {
      paramAsyncResult = new com.tencent.mobileqq.mini.sdk.EntryModel(parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.jdField_a_of_type_Int, parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.jdField_a_of_type_Long, parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.jdField_a_of_type_JavaLangString, parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.jdField_a_of_type_Boolean);
      if (parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel == null) {
        break label281;
      }
    }
    label281:
    for (com.tencent.mobileqq.mini.sdk.ShareChatModel localShareChatModel = new com.tencent.mobileqq.mini.sdk.ShareChatModel(parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel.jdField_a_of_type_Int, parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel.jdField_a_of_type_Long, parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareChatModel.jdField_a_of_type_JavaLangString);; localShareChatModel = null)
    {
      MiniProgramShareUtils.shareAsArkMessage(parambesj.jdField_a_of_type_AndroidAppActivity, new MiniArkShareModelBuilder().setAppId(parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId).setTitle(parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name).setDescription(parambesj.jdField_a_of_type_JavaLangString).setShareScene(1).setShareTemplateType(1).setShareBusinessType(parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.getReportType()).setPicUrl(parambesj.jdField_b_of_type_JavaLangString).setVidUrl(null).setJumpUrl(parambesj.c).setIconUrl(parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.iconUrl).setVersionType(parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.verType).setVersionId(parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.versionId).setWebURL(parambesj.d).setTemplateId(parambesj.e).setTemplateData(parambesj.f).setEntryModel(paramAsyncResult).setShareChatModel(localShareChatModel).setShareTarget(parambesj.jdField_b_of_type_Int).createMiniArkShareModel(), parambesj.jdField_b_of_type_Boolean, parambesj.jdField_a_of_type_Int, local1);
      return;
      paramAsyncResult = null;
      break;
    }
  }
  
  public void shareQzone(besj parambesj)
  {
    Activity localActivity = parambesj.jdField_a_of_type_AndroidAppActivity;
    String str;
    Intent localIntent;
    if (bbkk.a(parambesj.jdField_a_of_type_JavaLangString))
    {
      str = parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.desc;
      localIntent = new Intent();
      localIntent.setClassName("com.tencent.mobileqq", QZoneShareActivity.class.getName());
      localIntent.putExtra("isSharedFromMiniProgram", true);
      localIntent.putExtra("miniShareParamAppId", parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
      localIntent.putExtra("miniShareParamTitle", parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
      localIntent.putExtra("miniShareParamDescription", str);
      localIntent.putExtra("miniShareParamShareScene", 1);
      localIntent.putExtra("miniShareParamTemplateType", 1);
      localIntent.putExtra("miniShareParamBusinessType", parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.getReportType());
      localIntent.putExtra("miniShareParamPicUrl", parambesj.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("miniShareParamJumpUrl", parambesj.c);
      localIntent.putExtra("miniShareParamIconUrl", parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.iconUrl);
      localIntent.putExtra("miniShareParamVersionType", parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.verType);
      localIntent.putExtra("miniShareParamVersionId", parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.versionId);
      if (parambesj.jdField_a_of_type_Int != 11) {
        break label247;
      }
    }
    label247:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("miniShareIsFromInnerButton", bool);
      localActivity.startActivity(localIntent);
      return;
      str = parambesj.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public void shareToWeChat(besj parambesj, int paramInt)
  {
    Activity localActivity = parambesj.jdField_a_of_type_AndroidAppActivity;
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
      QLog.d("AppBrandRuntime", 2, "startShareToWeChat. title=" + parambesj.jdField_a_of_type_JavaLangString + ",sharePicPath=" + parambesj.jdField_b_of_type_JavaLangString + ",entryPath=" + parambesj.c);
    }
    MiniAppInfo localMiniAppInfo = parambesj.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
    if (localMiniAppInfo == null)
    {
      QLog.e("AppBrandRuntime", 1, "startShareToWeChat. apkgInfo is null!");
      return;
    }
    String str2 = parambesj.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    MiniProgramShareUtils.shareAsWeChatMsg(localMiniAppInfo.appId, localMiniAppInfo.name, str1, 1, 1, localMiniAppInfo.getReportType(), parambesj.jdField_b_of_type_JavaLangString, null, parambesj.c, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, null, paramInt, new ShareProxyImpl.4(this, localActivity, parambesj, paramInt, str1, localMiniAppInfo));
  }
  
  public void showShareMenuForInnerShareButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, HashMap<String, Integer> paramHashMap, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl
 * JD-Core Version:    0.7.0.1
 */