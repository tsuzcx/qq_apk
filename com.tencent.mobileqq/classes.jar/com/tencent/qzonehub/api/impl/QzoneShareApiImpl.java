package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.qcircle.api.data.SerializableMap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.qzone.share.QZoneShareActivity;
import cooperation.qzone.share.QzoneShareServlet;
import cooperation.qzone.share.WXShareFromQZHelper;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class QzoneShareApiImpl
  implements IQzoneShareApi
{
  WXShareFromQZHelper helper = WXShareFromQZHelper.getInstance();
  
  private void shareToQzone2(Context paramContext, String paramString, QZoneShareData paramQZoneShareData, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXShareFromQzone", 2, "shareToQzone()");
    }
    if ((paramContext != null) && (paramQZoneShareData != null)) {
      dontShowContact();
    }
    try
    {
      Intent localIntent = new Intent(paramContext, QZoneShareActivity.class);
      localIntent.putExtra("qzone_uin", paramString);
      localIntent.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
      localIntent.putExtras(paramBundle);
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramBundle)
    {
      label79:
      break label79;
    }
    paramBundle = new Intent(paramContext, QZoneShareActivity.class);
    paramBundle.putExtra("qzone_uin", paramString);
    paramBundle.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
    paramBundle.addFlags(268435456);
    paramContext.startActivity(paramBundle);
    return;
    QLog.e("WXShareFromQzone", 1, "shareToQzone() params error");
  }
  
  private void shareToQzoneForMiniApp(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, String paramString9)
  {
    Intent localIntent = new Intent(paramContext, QZoneShareActivity.class);
    localIntent.putExtra("isSharedFromMiniProgram", true);
    localIntent.putExtra("isSharedFromThirdParty", true);
    localIntent.putExtra("miniShareParamAppId", paramString1);
    localIntent.putExtra("miniShareParamTitle", paramString2);
    localIntent.putExtra("miniShareParamDescription", paramString3);
    localIntent.putExtra("miniShareParamShareScene", 3);
    localIntent.putExtra("miniShareParamTemplateType", 1);
    localIntent.putExtra("miniShareParamBusinessType", 0);
    localIntent.putExtra("miniShareParamPicUrl", paramString4);
    localIntent.putExtra("miniShareParamIconUrl", paramString5);
    localIntent.putExtra("miniShareParamJumpUrl", paramString6);
    localIntent.putExtra("miniShareParamVersionType", paramInt);
    localIntent.putExtra("miniShareAppRichId", paramString7);
    localIntent.putExtra("miniSharePkgName", paramString8);
    localIntent.putExtra("miniShareOpenId", paramString9);
    paramContext.startActivity(localIntent);
  }
  
  public void addObserver(IQzoneShareApi.WXShareListener paramWXShareListener)
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return;
    }
    localWXShareFromQZHelper.addObserver(paramWXShareListener);
  }
  
  public String buildTransaction(String paramString)
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return "";
    }
    return localWXShareFromQZHelper.buildTransaction(paramString);
  }
  
  public boolean checkAndroidNotBelowN()
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return false;
    }
    return localWXShareFromQZHelper.checkAndroidNotBelowN();
  }
  
  public boolean checkVersionValid(Context paramContext)
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return false;
    }
    return localWXShareFromQZHelper.checkVersionValid(paramContext);
  }
  
  public void dontShowContact() {}
  
  public void handleWXEntryActivityIntent(Activity paramActivity, Intent paramIntent)
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return;
    }
    localWXShareFromQZHelper.handleWXEntryActivityIntent(paramActivity, paramIntent);
  }
  
  public boolean isWXinstalled()
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return false;
    }
    return localWXShareFromQZHelper.isWXinstalled();
  }
  
  public boolean isWXsupportApi()
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return false;
    }
    return localWXShareFromQZHelper.isWXsupportApi();
  }
  
  public boolean isWxSupportMiniProgramm()
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return false;
    }
    return localWXShareFromQZHelper.isWxSupportMiniProgramm();
  }
  
  public boolean isWxSupportTimeLine()
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return false;
    }
    return localWXShareFromQZHelper.isWxSupportTimeLine();
  }
  
  public void jmpWeixinDetail(Activity paramActivity)
  {
    WXShareFromQZHelper.jmpWeixinDetail(paramActivity);
  }
  
  public boolean jumpToQzoneShare(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return jumpToQzoneShare(paramAppInterface, paramContext, paramBundle, paramOnDismissListener, -1);
  }
  
  public boolean jumpToQzoneShare(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    return jumpToQzoneShare(paramAppInterface.getCurrentAccountUin(), paramContext, paramBundle, paramOnDismissListener, paramInt);
  }
  
  public boolean jumpToQzoneShare(String paramString, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (paramBundle == null) {
      return false;
    }
    Object localObject1 = paramBundle.getString("title");
    Object localObject2 = paramBundle.getString("desc");
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2)) && (!paramBundle.getBoolean("is_share_mini_app_msg")))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("qzone_uin", paramString);
      ((Intent)localObject1).putExtra("key_share_is_third_party", true);
      ((Intent)localObject1).putExtra("share_data", paramBundle);
      ((Intent)localObject1).addFlags(67108864);
      ((Intent)localObject1).addFlags(268435456);
      QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject1, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).dontShowContact();
    }
    try
    {
      paramBundle = QZoneHelper.UserInfo.getInstance();
      paramBundle.qzone_uin = paramString;
      QZoneHelper.forwardToFriendFeed((Activity)paramContext, paramBundle, (Intent)localObject1, paramInt, paramOnDismissListener);
      return true;
    }
    catch (Exception paramString)
    {
      label144:
      String str1;
      String str2;
      break label144;
    }
    paramString = new Intent(paramContext, TranslucentActivity.class);
    paramString.addFlags(268435456);
    paramString.putExtras((Intent)localObject1);
    paramContext.startActivity(paramString);
    return true;
    QZoneShareManager.checkQzoneShareParams(paramBundle);
    paramOnDismissListener = paramBundle.getString("open_id");
    localObject1 = paramBundle.getString("pkg_name");
    if (paramBundle.getBoolean("is_share_mini_app_msg"))
    {
      paramString = paramBundle.getString("title");
      localObject2 = paramBundle.getString("desc");
      str1 = paramBundle.getString("share_mini_app_id");
      str2 = paramBundle.getString("share_mini_app_path");
      shareToQzoneForMiniApp(paramContext, str1, paramString, (String)localObject2, paramBundle.getString("share_mini_image_url"), null, str2, paramBundle.getInt("share_mini_ver_type"), String.valueOf(paramBundle.getLong("req_share_id", -1L)), (String)localObject1, paramOnDismissListener);
      return true;
    }
    localObject2 = (OpenSdkShareModel)paramBundle.getParcelable("KEY_MINI_PROGRAM_SHARE_OBJ");
    if (localObject2 != null)
    {
      shareToQzoneForMiniApp(paramContext, ((OpenSdkShareModel)localObject2).miniAppAppid, ((OpenSdkShareModel)localObject2).title, ((OpenSdkShareModel)localObject2).desc, ((OpenSdkShareModel)localObject2).imageUrl, ((OpenSdkShareModel)localObject2).iconUrl, ((OpenSdkShareModel)localObject2).miniAppPath, 3, ((OpenSdkShareModel)localObject2).appRichId, (String)localObject1, paramOnDismissListener);
      return true;
    }
    paramOnDismissListener = new QZoneShareData();
    paramOnDismissListener.mTitle = paramBundle.getString("title");
    paramOnDismissListener.mSummary = paramBundle.getString("desc");
    paramOnDismissListener.mImageUrls = paramBundle.getStringArrayList("image_url");
    paramOnDismissListener.extString = paramBundle.getString("share_qq_ext_str");
    paramOnDismissListener.appid = paramBundle.getLong("req_share_id");
    paramOnDismissListener.openId = paramBundle.getString("open_id");
    paramOnDismissListener.appName = paramBundle.getString("app_name");
    paramOnDismissListener.targetUrl = paramBundle.getString("detail_url");
    paramOnDismissListener.iUrlInfoFrm = paramBundle.getInt("iUrlInfoFrm", -1);
    paramOnDismissListener.mShareBeginTime = paramBundle.getLong("share_begin_time", 0L);
    localObject1 = (SerializableMap)paramBundle.getSerializable("share_qzone_info");
    if (localObject1 != null) {
      paramOnDismissListener.qzoneShareInfo = ((SerializableMap)localObject1).getMap();
    }
    if (paramBundle.getBoolean("thirdPartShare")) {
      paramOnDismissListener.from = 1;
    } else if (paramBundle.getBoolean("from_web")) {
      paramOnDismissListener.from = 2;
    } else {
      paramOnDismissListener.from = 0;
    }
    paramOnDismissListener.action = paramBundle.getString("share_action");
    paramOnDismissListener.jFrom = paramBundle.getString("jfrom");
    paramOnDismissListener.pkgname = paramBundle.getString("pkg_name");
    paramOnDismissListener.shareUin = paramBundle.getString("share_uin");
    paramOnDismissListener.mWebUrl = paramBundle.getString("shareCurUrl");
    paramOnDismissListener.mDefaultForwardReason = paramBundle.getString("default_text");
    shareToQzone2(paramContext, paramString, paramOnDismissListener, paramBundle, paramInt);
    return true;
  }
  
  public void onReq(BaseReq paramBaseReq)
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return;
    }
    localWXShareFromQZHelper.onReq(paramBaseReq);
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return;
    }
    localWXShareFromQZHelper.onResp(paramBaseResp);
  }
  
  public void publishToQzone(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    publishToQzone(paramAppInterface, paramContext, paramBundle, paramOnDismissListener, -1);
  }
  
  public void publishToQzone(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXShareFromQzone", 2, "publishToQzone()");
    }
    Intent localIntent;
    if ((paramBundle != null) && (paramAppInterface != null))
    {
      localIntent = new Intent();
      localIntent.putExtra("qzone_uin", paramAppInterface.getAccount());
      localIntent.putExtra("key_share_is_third_party", true);
      ArrayList localArrayList = paramBundle.getStringArrayList("images");
      String str1;
      if ((localArrayList != null) && (localArrayList.size() > 9)) {
        str1 = "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity";
      } else {
        str1 = "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity";
      }
      if ((paramContext instanceof Activity))
      {
        localObject = (Activity)paramContext;
        if (((Activity)localObject).getIntent() != null)
        {
          localIntent.putExtra("qq_camera_scheme", ((Activity)localObject).getIntent().getStringExtra("qq_camera_scheme"));
          localIntent.putExtra("qq_camera_top_title", ((Activity)localObject).getIntent().getStringExtra("qq_camera_top_title"));
        }
      }
      Object localObject = paramBundle.getString("hulian_appid");
      String str2 = paramBundle.getString("file_send_path");
      if ((!QZoneShareManager.isQzoneShareWhite((String)localObject)) && (((localArrayList != null) && (localArrayList.size() > 0)) || (!TextUtils.isEmpty(str2))))
      {
        paramBundle.putString("summary", "");
        paramBundle.putString("defaultText", "");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (!TextUtils.isEmpty(str2))
        {
          paramBundle.putInt("key_upload_entrance", 207);
          paramBundle.putString("refer", (String)localObject);
        }
        else if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          paramBundle.putInt("key_upload_entrance", 45);
          paramBundle.putString("refer", (String)localObject);
        }
      }
      localIntent.putExtras(paramBundle);
      QzonePluginProxyActivity.setActivityNameToIntent(localIntent, str1);
      localIntent.putExtra("key_share_is_third_party", true);
      ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).dontShowContact();
    }
    try
    {
      paramBundle = QZoneHelper.UserInfo.getInstance();
      paramBundle.qzone_uin = paramAppInterface.getCurrentAccountUin();
      QZoneHelper.forwardToFriendFeed((Activity)paramContext, paramBundle, localIntent, paramInt, paramOnDismissListener);
      return;
    }
    catch (Exception paramAppInterface)
    {
      label351:
      break label351;
    }
    paramAppInterface = new Intent(paramContext, TranslucentActivity.class);
    paramAppInterface.addFlags(268435456);
    paramAppInterface.putExtras(localIntent);
    paramContext.startActivity(paramAppInterface);
    return;
    QLog.d("WXShareFromQzone", 1, "publishToQzone() params error");
  }
  
  public void publishToQzoneFromMiniApp(Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXShareFromQzone", 2, "publishToQzone()");
    }
    if (paramBundle == null)
    {
      QLog.d("WXShareFromQzone", 1, "publishToQzone() params error");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("qzone_uin", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).dontShowContact();
    try
    {
      paramBundle = QZoneHelper.UserInfo.getInstance();
      paramBundle.qzone_uin = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
      QZoneHelper.forwardToFriendFeed((Activity)paramContext, paramBundle, localIntent, paramInt, paramOnDismissListener);
      return;
    }
    catch (Exception paramBundle)
    {
      label114:
      break label114;
    }
    paramBundle = new Intent(paramContext, TranslucentActivity.class);
    paramBundle.addFlags(268435456);
    paramBundle.putExtras(localIntent);
    paramContext.startActivity(paramBundle);
  }
  
  public void registerApp()
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return;
    }
    localWXShareFromQZHelper.registerApp();
  }
  
  public void removeObserver(IQzoneShareApi.WXShareListener paramWXShareListener)
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return;
    }
    localWXShareFromQZHelper.removeObserver(paramWXShareListener);
  }
  
  public void shareImage(Context paramContext, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return;
    }
    localWXShareFromQZHelper.shareImage(paramContext, paramString, paramArrayOfByte, paramInt);
  }
  
  public void shareMiniProgram(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return;
    }
    localWXShareFromQZHelper.shareMiniProgram(paramString1, paramBitmap, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt);
  }
  
  public void shareMutilPicToWehat(Context paramContext, ArrayList<File> paramArrayList)
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return;
    }
    localWXShareFromQZHelper.shareMutilPicToWehat(paramContext, paramArrayList);
  }
  
  public void shareQzoneForMini(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, int paramInt4, String paramString7, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", QZoneShareActivity.class.getName());
    localIntent.putExtra("isSharedFromMiniProgram", true);
    localIntent.putExtra("miniShareParamAppId", paramString1);
    localIntent.putExtra("miniShareParamTitle", paramString2);
    localIntent.putExtra("miniShareParamDescription", paramString3);
    localIntent.putExtra("miniShareParamShareScene", paramInt1);
    localIntent.putExtra("miniShareParamTemplateType", paramInt2);
    localIntent.putExtra("miniShareParamBusinessType", paramInt3);
    localIntent.putExtra("miniShareParamPicUrl", paramString4);
    localIntent.putExtra("miniShareParamJumpUrl", paramString5);
    localIntent.putExtra("miniShareParamIconUrl", paramString6);
    localIntent.putExtra("miniShareParamVersionType", paramInt4);
    localIntent.putExtra("miniShareParamVersionId", paramString7);
    localIntent.putExtra("miniShareIsFromInnerButton", paramBoolean);
    paramActivity.startActivity(localIntent);
  }
  
  public void shareText(String paramString, int paramInt)
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return;
    }
    localWXShareFromQZHelper.shareText(paramString, paramInt);
  }
  
  public void shareToQzone(Context paramContext, String paramString, QZoneShareData paramQZoneShareData, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXShareFromQzone", 2, "shareToQzone()");
    }
    if ((paramContext != null) && (paramQZoneShareData != null)) {
      dontShowContact();
    }
    try
    {
      paramOnDismissListener = new Intent(BaseApplicationImpl.getContext(), QZoneShareActivity.class);
      paramOnDismissListener.putExtra("qzone_uin", paramString);
      paramOnDismissListener.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
      ((Activity)paramContext).startActivityForResult(paramOnDismissListener, paramInt);
      return;
    }
    catch (Exception paramOnDismissListener)
    {
      label73:
      break label73;
    }
    paramOnDismissListener = new Intent(BaseApplicationImpl.getContext(), QZoneShareActivity.class);
    paramOnDismissListener.putExtra("qzone_uin", paramString);
    paramOnDismissListener.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
    paramOnDismissListener.addFlags(268435456);
    paramContext.startActivity(paramOnDismissListener);
    return;
    QLog.e("WXShareFromQzone", 1, "shareToQzone() params error");
  }
  
  public void shareToQzoneFromAskAnonymously(Context paramContext, String paramString, QZoneShareData paramQZoneShareData, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXShareFromQzone", 2, "shareToQzone()");
    }
    if ((paramContext != null) && (paramQZoneShareData != null))
    {
      dontShowContact();
      Intent localIntent = new Intent(paramContext, QZoneShareActivity.class);
      localIntent.putExtra("qzone_uin", paramString);
      localIntent.putExtra("isSharedFromAskAnonymously", true);
      localIntent.putExtra("askAnonymouslyShareType", paramInt);
      localIntent.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    QLog.e("WXShareFromQzone", 1, "shareToQzone() params error");
  }
  
  public void shareWebPage(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, int paramInt)
  {
    WXShareFromQZHelper localWXShareFromQZHelper = this.helper;
    if (localWXShareFromQZHelper == null) {
      return;
    }
    localWXShareFromQZHelper.shareWebPage(paramString1, paramBitmap, paramString2, paramString3, paramInt);
  }
  
  public void startShareServlet(Context paramContext, String paramString, long paramLong, QZoneShareData paramQZoneShareData)
  {
    paramContext = new NewIntent(paramContext, QzoneShareServlet.class);
    paramContext.putExtra("reason", paramString);
    paramContext.putExtra("uin", paramLong);
    paramContext.putExtra("sharedata", paramQZoneShareData);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneShareApiImpl
 * JD-Core Version:    0.7.0.1
 */