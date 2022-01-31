package com.tencent.qqmini.nativePlugins;

import alud;
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
import bdgm;
import bdjz;
import bflz;
import bglv;
import bgok;
import bjdt;
import bjea;
import bjqu;
import bjqw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class TroopAlbumPlugin
  extends BaseJsPlugin
{
  public static final String DOWNLOAD_GROUP_ALBUM_PHOTO = "groupAlbum_downloadGroupAlbumPhoto";
  public static final String GROUP_UPLOAD_PHOTO = "groupAlbum_groupUploadPhoto";
  public static final String IMPORT_GROUP_AIO = "groupAlbum_importGroupAIO";
  public static final String IS_EXIT_FAIL_MISSON = "is_exit_fail_misson";
  public static final String JUMP_CATEGORY_ALBUM = "groupAlbum_jumpCategoryAlbum";
  public static final String JUMP_GROUP_ALBUM_SEND_BOX = "groupAlbum_jumpGroupAlbumSendBox";
  public static final String OPEN_USER_QZONE_HOME = "groupAlbum_openUserQzoneHome";
  public static final String PICK_QZONE_ALBUM = "groupAlbum_pickQzoneAlbum";
  public static final String QZONE_ALBUM_START = "groupAlbum_start";
  public static String REFER = "famous";
  public static final String SHOW_GROUP_PHOTO_BROWSER = "groupAlbum_showGroupPhotoBrowser";
  public static final String TAG = "TroopAlbumPlugin";
  private String cacheArgs;
  private Handler handler = new Handler();
  private long lastClickTime;
  Dialog mDownloadingDialog;
  private bgok mReq;
  private bdjz openDialog;
  private BroadcastReceiver troopAlbumReceiver = new TroopAlbumPlugin.1(this);
  
  private void alertDownloadErrorCount(Activity paramActivity, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if ((this.mDownloadingDialog != null) && (this.mDownloadingDialog.isShowing())) {
      this.mDownloadingDialog.dismiss();
    }
    if (paramBoolean) {
      return;
    }
    if (paramInt2 > 0)
    {
      String str = "";
      if (paramInt1 > 0)
      {
        str = String.format(paramActivity.getString(2131718540), new Object[] { Integer.valueOf(paramInt1) }) + "，";
        str = str + paramString + alud.a(2131715573);
      }
      paramString = str + String.format(paramActivity.getString(2131718533), new Object[] { Integer.valueOf(paramInt2) });
      bdgm.a(paramActivity, 232).setMessage(paramString).setNegativeButton(2131718538, new TroopAlbumPlugin.5(this)).show();
      return;
    }
    bflz.a().a(paramActivity.getString(2131718541) + paramString + alud.a(2131715572));
  }
  
  private void handleChatAio(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).optString("albumname");
    int i = ((JSONObject)localObject).getInt("groupCode");
    localObject = ((JSONObject)localObject).optString("albumid");
    ChatHistoryActivity.a(this.mMiniAppContext.a(), String.valueOf(i), (String)localObject, paramJSONObject);
  }
  
  private void handleDownloadPic(JSONObject paramJSONObject)
  {
    Object localObject = new Intent();
    paramJSONObject = paramJSONObject.getJSONObject("data").toString();
    ((Intent)localObject).putExtra("photos", paramJSONObject);
    bjqu.a().a(new TroopAlbumPlugin.2(this, paramJSONObject));
    if (!isSdcardWorking())
    {
      bflz.a().a(alud.a(2131715568));
      return;
    }
    if (!NetworkState.isNetSupport())
    {
      bflz.a().a(alud.a(2131715567));
      return;
    }
    if (!NetworkState.isWifiConn())
    {
      localObject = this.mMiniAppContext.a();
      bdgm.a((Context)localObject, 230).setTitle(((Context)localObject).getString(2131718537)).setMessage(((Context)localObject).getString(2131718539)).setPositiveButton(((Context)localObject).getString(2131718536), new TroopAlbumPlugin.4(this, paramJSONObject)).setNegativeButton(((Context)localObject).getString(2131718535), new TroopAlbumPlugin.3(this)).show();
      return;
    }
    bjqu.a().a().d(paramJSONObject);
  }
  
  private void handleJumpCategoryAlbum(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONObject("data");
    int i = paramJSONObject.optInt("categoryType");
    paramJSONObject = paramJSONObject.optString("categoryId");
    Activity localActivity = this.mMiniAppContext.a();
    if (localActivity != null) {
      bjdt.a(localActivity, BaseApplicationImpl.sApplication.getRuntime().getAccount(), i, paramJSONObject, -1);
    }
  }
  
  private void handleJumpToPublishBox()
  {
    bjea.a();
    bjdt.a(this.mMiniAppContext.a(), null, 0);
  }
  
  private void handleJumpToQzone(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONObject("data");
    long l = paramJSONObject.optLong("uin");
    paramJSONObject.optString("nick");
    paramJSONObject = new Intent();
    QzonePluginProxyActivity.a(paramJSONObject, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramJSONObject.putExtra("qqid", l);
    paramJSONObject.putExtra("refer", REFER);
    paramJSONObject.setFlags(67108864);
    paramJSONObject.putExtra("autoShowTimeLine", false);
    QzonePluginProxyActivity.a(this.mMiniAppContext.a(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), paramJSONObject, 0);
  }
  
  private void handleQunDidPickAlbum(JSONObject paramJSONObject, bgok parambgok)
  {
    try
    {
      paramJSONObject.getJSONObject("data");
      paramJSONObject = new Bundle();
      paramJSONObject.putInt("key_personal_album_enter_model", 0);
      paramJSONObject.putBoolean("key_pass_result_by_bundle", true);
      bjea localbjea = bjea.a();
      localbjea.jdField_a_of_type_JavaLangString = BaseApplicationImpl.sApplication.getRuntime().getAccount();
      paramJSONObject.putBoolean("key_need_change_to_jpg", true);
      bjdt.a(this.mMiniAppContext.a(), localbjea, paramJSONObject, 100);
      this.mReq = parambgok;
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("troop_select");
      this.mMiniAppContext.a().registerReceiver(this.troopAlbumReceiver, paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopAlbumPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private void handleQunStartAlbum(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = this.mMiniAppContext.a().getSharedPreferences("troop_album" + BaseApplicationImpl.sApplication.getRuntime().getAccount(), 0).getBoolean("is_exit_fail_misson", false);
      QLog.w("TroopAlbumPlugin", 2, "isExitFailMission:" + bool);
      if (bool)
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("count", 1);
        paramJSONObject.put("isFail", true);
        sendSubscribeEvent("groupAlbum_onGroupAlbumUpload", paramJSONObject.toString());
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopAlbumPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private void handleShowPhotoList(JSONObject paramJSONObject, bgok parambgok)
  {
    if (System.currentTimeMillis() - this.lastClickTime < 2000L)
    {
      QLog.d("TroopAlbumPlugin", 4, "handleShowPhotoList too many return " + (System.currentTimeMillis() - this.lastClickTime));
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
    parambgok = ((JSONObject)localObject1).optString("videoURL");
    String str = ((JSONObject)localObject1).optString("videoID");
    localObject1 = bjea.a();
    ((bjea)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
    localObject3 = new Bundle();
    ArrayList localArrayList = new ArrayList();
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.d = ((String)localObject2);
    localPhotoInfo.c = l;
    localPhotoInfo.b = paramJSONObject;
    localPhotoInfo.i = ((String)localObject4);
    localPhotoInfo.t = i;
    localPhotoInfo.q = j;
    localPhotoInfo.a = new VideoInfo();
    localPhotoInfo.a.jdField_a_of_type_JavaLangString = str;
    localObject4 = new PictureUrl();
    ((PictureUrl)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject2);
    localPhotoInfo.a.d = ((PictureUrl)localObject4);
    localObject2 = new VideoUrl();
    ((VideoUrl)localObject2).jdField_a_of_type_JavaLangString = parambgok;
    localPhotoInfo.a.jdField_a_of_type_Long = k;
    localPhotoInfo.a.jdField_a_of_type_JavaLangString = str;
    localPhotoInfo.a.b = parambgok;
    localPhotoInfo.a.jdField_a_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)localObject2);
    localPhotoInfo.a.g = m;
    localPhotoInfo.a.h = n;
    localPhotoInfo.a.f = 5;
    localArrayList.add(localPhotoInfo);
    parambgok = new PhotoParam();
    parambgok.b = paramJSONObject;
    parambgok.g = paramJSONObject;
    ((Bundle)localObject3).putSerializable("picturelist", localArrayList);
    ((Bundle)localObject3).putInt("curindex", 0);
    ((Bundle)localObject3).putInt("mode", 13);
    ((Bundle)localObject3).putBoolean("need_clear_cache", true);
    bjdt.c(this.mMiniAppContext.a(), (bjea)localObject1, (Bundle)localObject3, 6);
    this.lastClickTime = System.currentTimeMillis();
  }
  
  private void handleUploadPhoto(JSONObject paramJSONObject, bgok parambgok)
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).optString("albumname");
    long l = ((JSONObject)localObject).getLong("groupCode");
    localObject = ((JSONObject)localObject).optString("albumid");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (int i = 2;; i = 1)
    {
      bjdt.b(this.mMiniAppContext.a(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), i, 1, l, "", (String)localObject, paramJSONObject, 7001, 43);
      this.mReq = parambgok;
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("troop_upload");
      this.mMiniAppContext.a().registerReceiver(this.troopAlbumReceiver, paramJSONObject);
      return;
    }
  }
  
  private boolean isSdcardWorking()
  {
    return SDCardMountMonitorReceiver.a().b();
  }
  
  public void groupAlbumDownloadGroupAlbumPhoto(bgok parambgok)
  {
    QMLog.i("Demo", "groupAlbum_downloadGroupAlbumPhoto succeed");
    parambgok.a();
  }
  
  public void groupAlbumGroupUploadPhoto(bgok parambgok)
  {
    QMLog.i("Demo", "groupAlbum_groupUploadPhoto succeed");
    parambgok.a();
  }
  
  public void groupAlbumImportGroupAIO(bgok parambgok)
  {
    QMLog.i("Demo", "groupAlbum_importGroupAIO succeed");
    parambgok.a();
  }
  
  public void groupAlbumJumpCategoryAlbum(bgok parambgok)
  {
    QMLog.i("Demo", "groupAlbum_jumpCategoryAlbum succeed");
    parambgok.a();
  }
  
  public void groupAlbumJumpGroupAlbumSendBox(bgok parambgok)
  {
    QMLog.i("Demo", "groupAlbum_jumpGroupAlbumSendBox succeed");
    parambgok.a();
  }
  
  public void groupAlbumOpenUserQzoneHome(bgok parambgok)
  {
    QMLog.i("Demo", "groupAlbum_openUserQzoneHome succeed");
    parambgok.a();
  }
  
  public void groupAlbumPickQzoneAlbum(bgok parambgok)
  {
    QMLog.i("Demo", "groupAlbum_pickQzoneAlbum succeed");
    parambgok.a();
  }
  
  public void groupAlbumShowGroupPhotoBrowser(bgok parambgok)
  {
    QMLog.i("Demo", "groupAlbum_showGroupPhotoBrowser succeed");
    parambgok.a();
  }
  
  public void groupAlbumStart(bgok parambgok)
  {
    QMLog.i("Demo", "groupAlbum_start succeed");
    parambgok.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin
 * JD-Core Version:    0.7.0.1
 */