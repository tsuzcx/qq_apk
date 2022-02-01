package com.tencent.mobileqq.mini.out.nativePlugins;

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
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.ToastUtil;
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
  private String cacheArgs = null;
  private Handler handler = new Handler();
  private long lastClickTime = 0L;
  Dialog mDownloadingDialog;
  private QQCustomDialog openDialog;
  private JSContext troopAlbumJsContext;
  private BroadcastReceiver troopAlbumReceiver = new TroopAlbumPlugin.1(this);
  
  private void alertDownloadErrorCount(Activity paramActivity, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Object localObject = this.mDownloadingDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.mDownloadingDialog.dismiss();
    }
    if (paramBoolean) {
      return;
    }
    if (paramInt2 > 0)
    {
      if (paramInt1 > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(String.format(paramActivity.getString(2131915038), new Object[] { Integer.valueOf(paramInt1) }));
        ((StringBuilder)localObject).append("，");
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(paramString);
        localStringBuilder.append(HardCodeUtil.a(2131912456));
        paramString = localStringBuilder.toString();
      }
      else
      {
        paramString = "";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(String.format(paramActivity.getString(2131915031), new Object[] { Integer.valueOf(paramInt2) }));
      paramString = ((StringBuilder)localObject).toString();
      DialogUtil.a(paramActivity, 232).setMessage(paramString).setNegativeButton(2131915036, new TroopAlbumPlugin.5(this)).show();
      return;
    }
    localObject = ToastUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramActivity.getString(2131915039));
    localStringBuilder.append(paramString);
    localStringBuilder.append(HardCodeUtil.a(2131912455));
    ((ToastUtil)localObject).a(localStringBuilder.toString());
  }
  
  private void handleChatAio(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).optString("albumname");
    int i = ((JSONObject)localObject).getInt("groupCode");
    localObject = ((JSONObject)localObject).optString("albumid");
    ChatHistoryActivity.a(paramJSContext.getActivity(), String.valueOf(i), (String)localObject, paramJSONObject);
  }
  
  private void handleDownloadPic(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    Intent localIntent = new Intent();
    paramJSONObject = paramJSONObject.getJSONObject("data").toString();
    localIntent.putExtra("photos", paramJSONObject);
    RemoteHandleManager.getInstance().addWebEventListener(new TroopAlbumPlugin.2(this, paramJSONObject, paramJSContext));
    if (!isSdcardWorking())
    {
      ToastUtil.a().a(HardCodeUtil.a(2131912452));
      return;
    }
    if (!NetworkState.isNetSupport())
    {
      ToastUtil.a().a(HardCodeUtil.a(2131912451));
      return;
    }
    if (!NetworkState.isWifiConn())
    {
      paramJSContext = paramJSContext.getActivity();
      DialogUtil.a(paramJSContext, 230).setTitle(paramJSContext.getString(2131915035)).setMessage(paramJSContext.getString(2131915037)).setPositiveButton(paramJSContext.getString(2131915034), new TroopAlbumPlugin.4(this, paramJSONObject)).setNegativeButton(paramJSContext.getString(2131915033), new TroopAlbumPlugin.3(this)).show();
      return;
    }
    RemoteHandleManager.getInstance().getSender().downloadTroopPhoto(paramJSONObject);
  }
  
  private void handleJumpCategoryAlbum(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    paramJSONObject = paramJSONObject.getJSONObject("data");
    int i = paramJSONObject.optInt("categoryType");
    paramJSONObject = paramJSONObject.optString("categoryId");
    paramJSContext = paramJSContext.getActivity();
    if (paramJSContext != null) {
      QZoneHelper.forwardToCategoryAlbum(paramJSContext, BaseApplicationImpl.sApplication.getRuntime().getAccount(), i, paramJSONObject, -1);
    }
  }
  
  private void handleJumpToPublishBox(JSContext paramJSContext)
  {
    QZoneHelper.UserInfo.getInstance();
    QZoneHelper.forwardToPublishBox(paramJSContext.getActivity(), null, 0);
  }
  
  private void handleJumpToQzone(JSONObject paramJSONObject, JSContext paramJSContext)
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
  
  private void handleQunDidPickAlbum(JSONObject paramJSONObject, JSContext paramJSContext)
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
      label105:
      break label105;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TroopAlbumPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private void handleQunStartAlbum(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    try
    {
      paramJSONObject = paramJSContext.getActivity();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troop_album");
      localStringBuilder.append(BaseApplicationImpl.sApplication.getRuntime().getAccount());
      boolean bool = paramJSONObject.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("is_exit_fail_misson", false);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("isExitFailMission:");
      paramJSONObject.append(bool);
      QLog.w("TroopAlbumPlugin", 2, paramJSONObject.toString());
      if (!bool) {
        break label147;
      }
      paramJSONObject = new JSONObject();
      paramJSONObject.put("count", 1);
      paramJSONObject.put("isFail", true);
      paramJSContext.callJs("groupAlbum_onGroupAlbumUpload", paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label132:
      label147:
      break label132;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TroopAlbumPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private void handleShowPhotoList(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    if (System.currentTimeMillis() - this.lastClickTime < 2000L)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("handleShowPhotoList too many return ");
      paramJSONObject.append(System.currentTimeMillis() - this.lastClickTime);
      QLog.d("TroopAlbumPlugin", 4, paramJSONObject.toString());
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
  
  private void handleUploadPhoto(JSONObject paramJSONObject, JSContext paramJSContext)
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
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      QLog.d("TroopAlbumPlugin", 1, "handleUploadPhoto  init  mAlbumId is null!");
    }
    QZoneHelper.forwardMiniToTroopUploadPhoto(paramJSContext.getActivity(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), i, 1, l, "", (String)localObject, paramJSONObject, 7001, 43);
    this.troopAlbumJsContext = paramJSContext;
    paramJSONObject = new IntentFilter();
    paramJSONObject.addAction("troop_upload");
    paramJSContext.getActivity().registerReceiver(this.troopAlbumReceiver, paramJSONObject);
  }
  
  private boolean isSdcardWorking()
  {
    return SDCardMountMonitorReceiver.getInstance().isSDCardCanWrite();
  }
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    if (paramJSContext != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopAlbumPlugin", 2, paramJSONObject.toString());
      }
      String str = paramJSONObject.optString("api_name");
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
      if (!str.equals("groupAlbum_start")) {
        break label186;
      }
      handleQunStartAlbum(paramJSONObject, paramJSContext);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label171:
      label186:
      break label171;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TroopAlbumPlugin", 2, "handleGroupUploadPhoto,decode param error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin
 * JD-Core Version:    0.7.0.1
 */