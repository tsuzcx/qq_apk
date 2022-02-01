package com.tencent.mobileqq.mini.out.nativePlugins;

import amtj;
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
import bfur;
import bhzt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
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

public class TroopAlbumPlugin
  implements NativePlugin
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
  private QQCustomDialog openDialog;
  private NativePlugin.JSContext troopAlbumJsContext;
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
        str = String.format(paramActivity.getString(2131717046), new Object[] { Integer.valueOf(paramInt1) }) + "，";
        str = str + paramString + amtj.a(2131714195);
      }
      paramString = str + String.format(paramActivity.getString(2131717039), new Object[] { Integer.valueOf(paramInt2) });
      bfur.a(paramActivity, 232).setMessage(paramString).setNegativeButton(2131717044, new TroopAlbumPlugin.5(this)).show();
      return;
    }
    bhzt.a().a(paramActivity.getString(2131717047) + paramString + amtj.a(2131714194));
  }
  
  private void handleChatAio(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).optString("albumname");
    int i = ((JSONObject)localObject).getInt("groupCode");
    localObject = ((JSONObject)localObject).optString("albumid");
    ChatHistoryActivity.a(paramJSContext.getActivity(), String.valueOf(i), (String)localObject, paramJSONObject);
  }
  
  private void handleDownloadPic(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    Intent localIntent = new Intent();
    paramJSONObject = paramJSONObject.getJSONObject("data").toString();
    localIntent.putExtra("photos", paramJSONObject);
    RemoteHandleManager.getInstance().addWebEventListener(new TroopAlbumPlugin.2(this, paramJSONObject, paramJSContext));
    if (!isSdcardWorking())
    {
      bhzt.a().a(amtj.a(2131714190));
      return;
    }
    if (!NetworkState.isNetSupport())
    {
      bhzt.a().a(amtj.a(2131714189));
      return;
    }
    if (!NetworkState.isWifiConn())
    {
      paramJSContext = paramJSContext.getActivity();
      bfur.a(paramJSContext, 230).setTitle(paramJSContext.getString(2131717043)).setMessage(paramJSContext.getString(2131717045)).setPositiveButton(paramJSContext.getString(2131717042), new TroopAlbumPlugin.4(this, paramJSONObject)).setNegativeButton(paramJSContext.getString(2131717041), new TroopAlbumPlugin.3(this)).show();
      return;
    }
    RemoteHandleManager.getInstance().getSender().downloadTroopPhoto(paramJSONObject);
  }
  
  private void handleJumpCategoryAlbum(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    paramJSONObject = paramJSONObject.getJSONObject("data");
    int i = paramJSONObject.optInt("categoryType");
    paramJSONObject = paramJSONObject.optString("categoryId");
    paramJSContext = paramJSContext.getActivity();
    if (paramJSContext != null) {
      QZoneHelper.forwardToCategoryAlbum(paramJSContext, BaseApplicationImpl.sApplication.getRuntime().getAccount(), i, paramJSONObject, -1);
    }
  }
  
  private void handleJumpToPublishBox(NativePlugin.JSContext paramJSContext)
  {
    QZoneHelper.UserInfo.getInstance();
    QZoneHelper.forwardToPublishBox(paramJSContext.getActivity(), null, 0);
  }
  
  private void handleJumpToQzone(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    paramJSONObject = paramJSONObject.getJSONObject("data");
    long l = paramJSONObject.optLong("uin");
    paramJSONObject.optString("nick");
    paramJSONObject = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(paramJSONObject, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramJSONObject.putExtra("qqid", l);
    paramJSONObject.putExtra("refer", REFER);
    paramJSONObject.setFlags(67108864);
    paramJSONObject.putExtra("autoShowTimeLine", false);
    QzonePluginProxyActivity.launchPluingActivityForResult(paramJSContext.getActivity(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), paramJSONObject, 0);
  }
  
  private void handleQunDidPickAlbum(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
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
      QZoneHelper.forwardToPersonalAlbumSelect(paramJSContext.getActivity(), localUserInfo, paramJSONObject, 100);
      this.troopAlbumJsContext = paramJSContext;
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("troop_select");
      paramJSContext.getActivity().registerReceiver(this.troopAlbumReceiver, paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopAlbumPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private void handleQunStartAlbum(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    try
    {
      boolean bool = paramJSContext.getActivity().getSharedPreferences("troop_album" + BaseApplicationImpl.sApplication.getRuntime().getAccount(), 0).getBoolean("is_exit_fail_misson", false);
      QLog.w("TroopAlbumPlugin", 2, "isExitFailMission:" + bool);
      if (bool)
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("count", 1);
        paramJSONObject.put("isFail", true);
        paramJSContext.callJs("groupAlbum_onGroupAlbumUpload", paramJSONObject);
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopAlbumPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private void handleShowPhotoList(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    if (System.currentTimeMillis() - this.lastClickTime < 2000L)
    {
      QLog.d("TroopAlbumPlugin", 4, "handleShowPhotoList too many return " + (System.currentTimeMillis() - this.lastClickTime));
      return;
    }
    Object localObject2 = paramJSONObject.getJSONObject("data");
    int i = ((JSONObject)localObject2).getInt("groupID");
    paramJSONObject = ((JSONObject)localObject2).optString("albumID");
    Object localObject5 = ((JSONObject)localObject2).optString("photoID");
    Object localObject4 = ((JSONObject)localObject2).optString("uin");
    Object localObject3 = ((JSONObject)localObject2).optString("bigurl");
    long l = ((JSONObject)localObject2).optLong("uin");
    int j = ((JSONObject)localObject2).optInt("isVideo");
    int k = ((JSONObject)localObject2).optInt("orgVideoSize");
    int m = ((JSONObject)localObject2).optInt("videoWidth");
    int n = ((JSONObject)localObject2).optInt("videoHeight");
    Object localObject1 = ((JSONObject)localObject2).optString("videoURL");
    String str = ((JSONObject)localObject2).optString("videoID");
    localObject2 = QZoneHelper.UserInfo.getInstance();
    ((QZoneHelper.UserInfo)localObject2).qzone_uin = ((String)localObject4);
    localObject4 = new Bundle();
    ArrayList localArrayList = new ArrayList();
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.bigUrl = ((String)localObject3);
    localPhotoInfo.uploaduin = l;
    localPhotoInfo.albumId = paramJSONObject;
    localPhotoInfo.lloc = ((String)localObject5);
    localPhotoInfo.appid = i;
    localPhotoInfo.videoflag = j;
    localPhotoInfo.videodata = new VideoInfo();
    localPhotoInfo.videodata.videoId = str;
    localObject5 = new PictureUrl();
    ((PictureUrl)localObject5).url = ((String)localObject3);
    localPhotoInfo.videodata.coverUrl = ((PictureUrl)localObject5);
    localObject3 = new VideoUrl();
    ((VideoUrl)localObject3).url = ((String)localObject1);
    localPhotoInfo.videodata.originVideoSize = k;
    localPhotoInfo.videodata.videoId = str;
    localPhotoInfo.videodata.actionUrl = ((String)localObject1);
    localPhotoInfo.videodata.videoUrl = ((VideoUrl)localObject3);
    localPhotoInfo.videodata.width = m;
    localPhotoInfo.videodata.height = n;
    localPhotoInfo.videodata.videoStatus = 5;
    localArrayList.add(localPhotoInfo);
    localObject1 = new PhotoParam();
    ((PhotoParam)localObject1).albumid = paramJSONObject;
    ((PhotoParam)localObject1).cell_id = paramJSONObject;
    ((Bundle)localObject4).putSerializable("picturelist", localArrayList);
    ((Bundle)localObject4).putInt("curindex", 0);
    ((Bundle)localObject4).putInt("mode", 13);
    ((Bundle)localObject4).putBoolean("need_clear_cache", true);
    QZoneHelper.forwardToPictureViewer(paramJSContext.getActivity(), (QZoneHelper.UserInfo)localObject2, (Bundle)localObject4, 6);
    this.lastClickTime = System.currentTimeMillis();
  }
  
  private void handleUploadPhoto(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).optString("albumname");
    long l = ((JSONObject)localObject).getLong("groupCode");
    localObject = ((JSONObject)localObject).optString("albumid");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (int i = 2;; i = 1)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        QLog.d("TroopAlbumPlugin", 1, "handleUploadPhoto  init  mAlbumId is null!");
      }
      QZoneHelper.forwardMiniToTroopUploadPhoto(paramJSContext.getActivity(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), i, 1, l, "", (String)localObject, paramJSONObject, 7001, 43);
      this.troopAlbumJsContext = paramJSContext;
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("troop_upload");
      paramJSContext.getActivity().registerReceiver(this.troopAlbumReceiver, paramJSONObject);
      return;
    }
  }
  
  private boolean isSdcardWorking()
  {
    return SDCardMountMonitorReceiver.getInstance().isSDCardCanWrite();
  }
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    if (paramJSContext != null) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopAlbumPlugin", 2, paramJSONObject.toString());
        }
        str = paramJSONObject.optString("api_name");
        if (str.equals("groupAlbum_groupUploadPhoto"))
        {
          handleUploadPhoto(paramJSONObject, paramJSContext);
          return;
        }
        if (str.equals("groupAlbum_openUserQzoneHome"))
        {
          handleJumpToQzone(paramJSONObject, paramJSContext);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        String str;
        if (QLog.isColorLevel())
        {
          QLog.w("TroopAlbumPlugin", 2, "handleGroupUploadPhoto,decode param error");
          return;
          if (str.equals("groupAlbum_importGroupAIO"))
          {
            handleChatAio(paramJSONObject, paramJSContext);
            return;
          }
          if (str.equals("groupAlbum_showGroupPhotoBrowser"))
          {
            handleShowPhotoList(paramJSONObject, paramJSContext);
            return;
          }
          if (str.equals("groupAlbum_jumpGroupAlbumSendBox"))
          {
            handleJumpToPublishBox(paramJSContext);
            return;
          }
          if (str.equals("groupAlbum_downloadGroupAlbumPhoto"))
          {
            handleDownloadPic(paramJSONObject, paramJSContext);
            return;
          }
          if (str.equals("groupAlbum_jumpCategoryAlbum"))
          {
            handleJumpCategoryAlbum(paramJSONObject, paramJSContext);
            return;
          }
          if (str.equals("groupAlbum_pickQzoneAlbum"))
          {
            handleQunDidPickAlbum(paramJSONObject, paramJSContext);
            return;
          }
          if (str.equals("groupAlbum_start")) {
            handleQunStartAlbum(paramJSONObject, paramJSContext);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin
 * JD-Core Version:    0.7.0.1
 */