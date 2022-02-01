package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class TroopAlbumPlugin
  extends BaseJsPlugin
{
  public static String a = "famous";
  private long jdField_a_of_type_Long = 0L;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new TroopAlbumPlugin.1(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private RequestEvent jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent;
  private String b = null;
  
  private void a()
  {
    QZoneHelper.UserInfo.getInstance();
    QZoneHelper.forwardToPublishBox(this.mMiniAppContext.getAttachedActivity(), null, 0);
  }
  
  private void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (paramBoolean) {
      return;
    }
    if (paramInt2 > 0)
    {
      if (paramInt1 > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(String.format(paramActivity.getString(2131717563), new Object[] { Integer.valueOf(paramInt1) }));
        ((StringBuilder)localObject).append("，");
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(paramString);
        localStringBuilder.append(HardCodeUtil.a(2131714960));
        paramString = localStringBuilder.toString();
      }
      else
      {
        paramString = "";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(String.format(paramActivity.getString(2131717556), new Object[] { Integer.valueOf(paramInt2) }));
      paramString = ((StringBuilder)localObject).toString();
      DialogUtil.a(paramActivity, 232).setMessage(paramString).setNegativeButton(2131717561, new TroopAlbumPlugin.5(this)).show();
      return;
    }
    localObject = ToastUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramActivity.getString(2131717564));
    localStringBuilder.append(paramString);
    localStringBuilder.append(HardCodeUtil.a(2131714959));
    ((ToastUtil)localObject).a(localStringBuilder.toString());
  }
  
  private void a(JSONObject paramJSONObject)
  {
    label141:
    try
    {
      paramJSONObject = this.mMiniAppContext.getAttachedActivity();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troop_album");
      localStringBuilder.append(BaseApplicationImpl.sApplication.getRuntime().getAccount());
      boolean bool = paramJSONObject.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("is_exit_fail_misson", false);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("isExitFailMission:");
      paramJSONObject.append(bool);
      QLog.w("TroopAlbumPlugin", 2, paramJSONObject.toString());
      if (!bool) {
        break label141;
      }
      paramJSONObject = new JSONObject();
      paramJSONObject.put("count", 1);
      paramJSONObject.put("isFail", true);
      sendSubscribeEvent("groupAlbum_onGroupAlbumUpload", paramJSONObject.toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      label127:
      break label127;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TroopAlbumPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private void a(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
  {
    try
    {
      paramJSONObject.getJSONObject("data");
      paramJSONObject = new Bundle();
      paramJSONObject.putInt("key_personal_album_enter_model", 0);
      paramJSONObject.putBoolean("key_pass_result_by_bundle", true);
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = BaseApplicationImpl.sApplication.getRuntime().getAccount();
      paramJSONObject.putBoolean("key_need_change_to_jpg", true);
      QZoneHelper.forwardToPersonalAlbumSelect(this.mMiniAppContext.getAttachedActivity(), localUserInfo, paramJSONObject, 100);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent = paramRequestEvent;
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("troop_select");
      this.mMiniAppContext.getAttachedActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label109:
      break label109;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TroopAlbumPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private boolean a()
  {
    return SDCardMountMonitorReceiver.getInstance().isSDCardCanWrite();
  }
  
  private void b(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONObject("data");
    int i = paramJSONObject.optInt("categoryType");
    paramJSONObject = paramJSONObject.optString("categoryId");
    Activity localActivity = this.mMiniAppContext.getAttachedActivity();
    if (localActivity != null) {
      QZoneHelper.forwardToCategoryAlbum(localActivity, BaseApplicationImpl.sApplication.getRuntime().getAccount(), i, paramJSONObject, -1);
    }
  }
  
  private void b(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).optString("albumname");
    long l = ((JSONObject)localObject).getLong("groupCode");
    localObject = ((JSONObject)localObject).optString("albumid");
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      i = 2;
    } else {
      i = 1;
    }
    QZoneHelper.forwardMiniToTroopUploadPhoto(this.mMiniAppContext.getAttachedActivity(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), i, 1, l, "", (String)localObject, paramJSONObject, 7001, 43);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent = paramRequestEvent;
    paramJSONObject = new IntentFilter();
    paramJSONObject.addAction("troop_upload");
    this.mMiniAppContext.getAttachedActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramJSONObject);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONObject("data");
    long l = paramJSONObject.optLong("uin");
    paramJSONObject.optString("nick");
    paramJSONObject = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(paramJSONObject, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramJSONObject.putExtra("qqid", l);
    paramJSONObject.putExtra("refer", jdField_a_of_type_JavaLangString);
    paramJSONObject.setFlags(67108864);
    paramJSONObject.putExtra("autoShowTimeLine", false);
    QzonePluginProxyActivity.launchPluingActivityForResult(this.mMiniAppContext.getAttachedActivity(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), paramJSONObject, 0);
  }
  
  private void c(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 2000L)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("handleShowPhotoList too many return ");
      paramJSONObject.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.d("TroopAlbumPlugin", 4, paramJSONObject.toString());
      return;
    }
    Object localObject1 = paramJSONObject.getJSONObject("data");
    int i = ((JSONObject)localObject1).getInt("groupID");
    paramJSONObject = ((JSONObject)localObject1).optString("albumID");
    Object localObject4 = ((JSONObject)localObject1).optString("photoID");
    Object localObject3 = ((JSONObject)localObject1).optString("uin");
    Object localObject2 = ((JSONObject)localObject1).optString("bigurl");
    long l = ((JSONObject)localObject1).optLong("uin");
    int j = ((JSONObject)localObject1).optInt("isVideo");
    int k = ((JSONObject)localObject1).optInt("orgVideoSize");
    int m = ((JSONObject)localObject1).optInt("videoWidth");
    int n = ((JSONObject)localObject1).optInt("videoHeight");
    paramRequestEvent = ((JSONObject)localObject1).optString("videoURL");
    String str = ((JSONObject)localObject1).optString("videoID");
    localObject1 = QZoneHelper.UserInfo.getInstance();
    ((QZoneHelper.UserInfo)localObject1).qzone_uin = ((String)localObject3);
    localObject3 = new Bundle();
    ArrayList localArrayList = new ArrayList();
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.bigUrl = ((String)localObject2);
    localPhotoInfo.uploaduin = l;
    localPhotoInfo.albumId = paramJSONObject;
    localPhotoInfo.lloc = ((String)localObject4);
    localPhotoInfo.appid = i;
    localPhotoInfo.videoflag = j;
    localPhotoInfo.videodata = new VideoInfo();
    localPhotoInfo.videodata.videoId = str;
    localObject4 = new PictureUrl();
    ((PictureUrl)localObject4).url = ((String)localObject2);
    localPhotoInfo.videodata.coverUrl = ((PictureUrl)localObject4);
    localObject2 = new VideoUrl();
    ((VideoUrl)localObject2).url = paramRequestEvent;
    localPhotoInfo.videodata.originVideoSize = k;
    localPhotoInfo.videodata.videoId = str;
    localPhotoInfo.videodata.actionUrl = paramRequestEvent;
    localPhotoInfo.videodata.videoUrl = ((VideoUrl)localObject2);
    localPhotoInfo.videodata.width = m;
    localPhotoInfo.videodata.height = n;
    localPhotoInfo.videodata.videoStatus = 5;
    localArrayList.add(localPhotoInfo);
    paramRequestEvent = new PhotoParam();
    paramRequestEvent.albumid = paramJSONObject;
    paramRequestEvent.cell_id = paramJSONObject;
    ((Bundle)localObject3).putSerializable("picturelist", localArrayList);
    ((Bundle)localObject3).putInt("curindex", 0);
    ((Bundle)localObject3).putInt("mode", 13);
    ((Bundle)localObject3).putBoolean("need_clear_cache", true);
    QZoneHelper.forwardToPictureViewer(this.mMiniAppContext.getAttachedActivity(), (QZoneHelper.UserInfo)localObject1, (Bundle)localObject3, 6);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void d(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).optString("albumname");
    int i = ((JSONObject)localObject).getInt("groupCode");
    localObject = ((JSONObject)localObject).optString("albumid");
    ChatHistoryActivity.a(this.mMiniAppContext.getAttachedActivity(), String.valueOf(i), (String)localObject, paramJSONObject);
  }
  
  private void e(JSONObject paramJSONObject)
  {
    Object localObject = new Intent();
    paramJSONObject = paramJSONObject.getJSONObject("data").toString();
    ((Intent)localObject).putExtra("photos", paramJSONObject);
    RemoteHandleManager.getInstance().addWebEventListener(new TroopAlbumPlugin.2(this, paramJSONObject));
    if (!a())
    {
      ToastUtil.a().a(HardCodeUtil.a(2131714955));
      return;
    }
    if (!NetworkState.isNetSupport())
    {
      ToastUtil.a().a(HardCodeUtil.a(2131714954));
      return;
    }
    if (!NetworkState.isWifiConn())
    {
      localObject = this.mMiniAppContext.getAttachedActivity();
      DialogUtil.a((Context)localObject, 230).setTitle(((Context)localObject).getString(2131717560)).setMessage(((Context)localObject).getString(2131717562)).setPositiveButton(((Context)localObject).getString(2131717559), new TroopAlbumPlugin.4(this, paramJSONObject)).setNegativeButton(((Context)localObject).getString(2131717558), new TroopAlbumPlugin.3(this)).show();
      return;
    }
    RemoteHandleManager.getInstance().getSender().downloadTroopPhoto(paramJSONObject);
  }
  
  @JsEvent({"groupAlbum_downloadGroupAlbumPhoto"})
  public void groupAlbumDownloadGroupAlbumPhoto(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_downloadGroupAlbumPhoto succeed");
      e(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_downloadGroupAlbumPhoto failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_groupUploadPhoto"})
  public void groupAlbumGroupUploadPhoto(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_groupUploadPhoto succeed");
      b(new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent);
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbumGroupUploadPhoto failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_importGroupAIO"})
  public void groupAlbumImportGroupAIO(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_importGroupAIO succeed");
      d(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_importGroupAIO failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_jumpCategoryAlbum"})
  public void groupAlbumJumpCategoryAlbum(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_jumpCategoryAlbum succeed");
      b(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_jumpCategoryAlbum failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_jumpGroupAlbumSendBox"})
  public void groupAlbumJumpGroupAlbumSendBox(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_jumpGroupAlbumSendBox succeed");
      a();
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_jumpGroupAlbumSendBox failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_openUserQzoneHome"})
  public void groupAlbumOpenUserQzoneHome(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_openUserQzoneHome succeed");
      c(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_openUserQzoneHome failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_pickQzoneAlbum"})
  public void groupAlbumPickQzoneAlbum(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_pickQzoneAlbum succeed");
      a(new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent);
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_pickQzoneAlbum failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_showGroupPhotoBrowser"})
  public void groupAlbumShowGroupPhotoBrowser(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_showGroupPhotoBrowser succeed");
      c(new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent);
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_showGroupPhotoBrowser failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_start"})
  public void groupAlbumStart(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_start succeed");
      a(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_start failed, ", paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin
 * JD-Core Version:    0.7.0.1
 */