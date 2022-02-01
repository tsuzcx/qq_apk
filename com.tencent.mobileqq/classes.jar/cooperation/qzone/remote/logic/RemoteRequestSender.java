package cooperation.qzone.remote.logic;

import NS_QMALL_COVER.AlbumThemeSkin;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.model.DiscoverTab;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteRequestSender
  implements RemoteHandleConst
{
  private static final String TAG = "cooperation.qzone.remote.logic.RemoteRequestSender";
  private RemoteHandleManager manager;
  
  public RemoteRequestSender(RemoteHandleManager paramRemoteHandleManager)
  {
    this.manager = paramRemoteHandleManager;
  }
  
  public int UpdatePloymorphicPraise(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.ploymorphicPraise", paramString);
    return this.manager.sendData("cmd.qzoneUpdatePloymorphicPraise", localBundle, false);
  }
  
  public void cancelAllupload()
  {
    Bundle localBundle = new Bundle();
    this.manager.sendData("cmd.cancelAllpreLoad", localBundle, true);
  }
  
  public void cancelDownloadTroopPhoto(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString);
    this.manager.sendData("cmd.troop.cancel.download.photo", localBundle, false);
  }
  
  public void deletePrePostDynamicAlbum()
  {
    Bundle localBundle = new Bundle();
    this.manager.sendData("cmd.deletePrePostPhoto", localBundle, true);
  }
  
  public void deleteTempVideo(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.recordTempVideoPath", paramString);
    this.manager.sendData("cmd.qzoneDeleteTempVideo", localBundle, false);
  }
  
  public void deleteTimerShuoShuo()
  {
    this.manager.sendData("cmd.deleteTimerShuoShuo", null, false);
  }
  
  public void downloadGift(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("GiftId_FullScreen", paramString1);
    localBundle.putString("GiftUrl_FullScreen", paramString2);
    localBundle.putString("GiftMd5_FullScreen", paramString3);
    this.manager.sendData("cmd.downloadGift", localBundle, true);
  }
  
  public void downloadPassivePraise(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("GiftId_FullScreen", paramString1);
    localBundle.putString("GiftUrl_FullScreen", paramString2);
    this.manager.sendData("cmd.downloadPassivePraise", localBundle, true);
  }
  
  public void downloadTroopPhoto(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString);
    this.manager.sendData("cmd.troop.download.photo", localBundle, true);
  }
  
  public void downloadVideo(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.videoRemoteUrls", paramString);
    this.manager.sendData("cmd.videoDownload", localBundle, false);
  }
  
  public void enableFirstDynamicPreUpload()
  {
    Bundle localBundle = new Bundle();
    this.manager.sendData("cmd.enableUploadFirstDynamicPhoto", localBundle, true);
  }
  
  public void gdtAdvReportFromWebViewPlug(Map<Integer, String> paramMap, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMap);
    localBundle.putSerializable("param.feedDataCookie", localArrayList);
    localBundle.putInt("param.reportPosi", paramInt1);
    localBundle.putInt("param.actionExpectation", paramInt2);
    localBundle.putLong("costTime", paramLong1);
    localBundle.putLong("error_code", paramLong2);
    ThreadManager.post(new RemoteRequestSender.1(this, localBundle), 2, null, false);
  }
  
  public void getCloudPhotoDynamic(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.CloudDynamicCmd", paramString);
    this.manager.sendData("cmd.getDynamicCloudPhoto", localBundle, true);
  }
  
  public void getDeviceInfos()
  {
    this.manager.sendData("cmd.getDeviceInfos", null, true);
  }
  
  public void getDynamicPhoto(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.DynamicCmd", paramString);
    this.manager.sendData("cmd.getDynamicPhoto", localBundle, true);
  }
  
  public void getDynamicselNum(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.DynamicCmd", paramString);
    this.manager.sendData("cmd.getDynamicSelnum", localBundle, true);
  }
  
  public void getEventVideoAlbumState()
  {
    this.manager.sendData("cmd.getEventVideoAlbumState", null, true);
  }
  
  public void getFakeFeedVideoCover(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.videoClientKey", paramString);
    this.manager.sendData("cmd.videoGetFakeFeedCover", localBundle, true);
  }
  
  public void getHistoryEventTag()
  {
    this.manager.sendData("cmd.getHistoryEventTag", null, true);
  }
  
  public void getLivingInfo()
  {
    this.manager.sendData("cmd.getLivingInfo", null, true);
  }
  
  public void getLocalPhotoSwitcher()
  {
    this.manager.sendData("cmd.getLocalPhotoSwitcher", null, true);
  }
  
  public void getPlayMode()
  {
    this.manager.sendData("cmd.getPlayMode", null, true);
  }
  
  public void getPlayingSong()
  {
    this.manager.sendData("cmd.getPlayingSong", null, true);
  }
  
  public void getQuickMakeDynamicStatus()
  {
    this.manager.sendData("cmd.getQuickMakeDynamicStatus", null, true);
  }
  
  public void getRecommedPhoto()
  {
    this.manager.sendData("cmd.getRecommedPhoto", null, true);
  }
  
  public void getTravelGroup(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", paramLong);
    this.manager.sendData("cmd.getTravelGroup", localBundle, true);
  }
  
  public void getVideoLocalProxyUrl(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("param.videoRemoteUrls", paramArrayList1);
    localBundle.putStringArrayList("param.videoId", paramArrayList2);
    this.manager.sendData("cmd.videoGetLocalProxyUrl", localBundle, true);
  }
  
  public void getWnsProxyData(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localBundle.putInt("web_hash_code", paramInt);
    this.manager.sendData("cmd.webview.getproxydata", localBundle, true);
  }
  
  public int handleUpdateFontList()
  {
    Bundle localBundle = new Bundle();
    return this.manager.sendData("cmd.qzoneUpdateFontList", localBundle, false);
  }
  
  public void initUserInfo()
  {
    this.manager.sendData("cmd.initUserInfo", null, false);
  }
  
  public int notifyBarrageEffectChanged(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("value", paramBoolean);
    return this.manager.sendData("cmd.qzoneBarrageEffectChanged", localBundle, false);
  }
  
  public int notifyCustomBrowserChanged(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("value", paramBoolean);
    return this.manager.sendData("cmd.qzoneUpdateCustomBrowserInfo", localBundle, false);
  }
  
  public int notifyFeedSkinSwitchChagned()
  {
    return this.manager.sendData("cmd.qzoneFeedSkinSwitchChanged", null, false);
  }
  
  public int notifyFontChanged(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("value", paramBoolean);
    return this.manager.sendData("cmd.qzoneFontChanged", localBundle, false);
  }
  
  public void notifyPlayListChange()
  {
    this.manager.sendData("cmd.notifyPlayListChange", null, false);
  }
  
  public int notifySuperFontChanged(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("value", paramBoolean);
    return this.manager.sendData("cmd.qzoneSuperFontChanged", localBundle, false);
  }
  
  public void onDynamicPageDestroy()
  {
    this.manager.sendData("cmd.dynamicDestroy", null, true);
  }
  
  public void onShowDiscoverTab(DiscoverTab paramDiscoverTab)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("tab", paramDiscoverTab);
    this.manager.sendData("cmd.discover.onShowDiscoverTab", localBundle, false);
  }
  
  public void pausePlay()
  {
    this.manager.sendData("cmd.pausePlay", null, false);
  }
  
  public void playAudioList(long paramLong, int paramInt1, int paramInt2, ArrayList<SongInfo> paramArrayList, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.origin", paramInt1);
    localBundle.putInt("param.index", paramInt2);
    localBundle.putSerializable("param.songList", paramArrayList);
    localBundle.putInt("param.playMode", paramInt3);
    this.manager.sendData("cmd.playAudioList", localBundle, false);
  }
  
  public void playFmBroadCastList(long paramLong, int paramInt1, int paramInt2, ArrayList<SongInfo> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.origin", paramInt1);
    localBundle.putInt("param.index", paramInt2);
    localBundle.putSerializable("param.songList", paramArrayList);
    this.manager.sendData("cmd.playFMBroadCastList", localBundle, false);
  }
  
  public void playMusicList(long paramLong, int paramInt1, int paramInt2, ArrayList<SongInfo> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.origin", paramInt1);
    localBundle.putInt("param.index", paramInt2);
    localBundle.putSerializable("param.songList", paramArrayList);
    this.manager.sendData("cmd.playMusicList", localBundle, false);
  }
  
  public int pregetPassiveFeeds(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    return this.manager.sendData("cmd.pre.getpassivefeeds", localBundle, true);
  }
  
  public void refreshPassiveFeeds()
  {
    this.manager.sendData("cmd.refreshPassiveFeeds", null, false);
  }
  
  public void refreshWeishiMedalStatus(long paramLong, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    localBundle.putInt("isHide", paramInt);
    this.manager.sendData("cmd.refreshWeishiMedalStatus", localBundle, false);
  }
  
  public void resumePlay()
  {
    this.manager.sendData("cmd.resumePlay", null, false);
  }
  
  public void selectEventTag(Bundle paramBundle)
  {
    this.manager.sendData("cmd.selectEventTag", paramBundle, false);
  }
  
  public void sendCloudDynmicPhotoSuccess(ArrayList<QzonePhotoInfo> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("param.DynamicCloudPhotolist", paramArrayList);
    this.manager.sendData("cmd.DynamicCloudPhotoSendSuccess", localBundle, true);
  }
  
  public void sendRedPocketGift(Activity paramActivity, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    paramActivity = new Bundle();
    paramActivity.putLong("param.uin", paramLong);
    paramActivity.putString("param.payKey", paramString2);
    paramActivity.putString("param.nickName", paramString1);
    paramActivity.putInt("param.requestCode", paramInt);
    paramActivity.putString("param.from", paramString3);
    this.manager.sendData("cmd.qzoneSendRedPocketGift", paramActivity, true);
  }
  
  public void setAlbumTheme(long paramLong, AlbumThemeSkin paramAlbumThemeSkin)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putSerializable("param.album_theme", paramAlbumThemeSkin);
    this.manager.sendData("cmd.alumb.theme", localBundle, false);
  }
  
  public void setEventVideoAlbumState(Bundle paramBundle)
  {
    this.manager.sendData("cmd.setEventVideoAlbumState", paramBundle, false);
  }
  
  public void setHistoryEventTagData(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.manager.sendData("cmd.setHistoryEventTag", paramBundle, false);
      return;
    }
    this.manager.sendData("cmd.setHistoryEventTag", null, false);
  }
  
  public void setLocalPhotoSwitcher(Bundle paramBundle)
  {
    this.manager.sendData("cmd.setLocalPhotoSwitcher", paramBundle, false);
  }
  
  public void setPlayMode(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.playModeRandom", paramInt1);
    localBundle.putInt("param.playModeAuto", paramInt2);
    localBundle.putInt("param.playModeLoop", paramInt3);
    this.manager.sendData("cmd.savePlayMode", localBundle, false);
  }
  
  public void setQuickMakeDynamicStatus(Bundle paramBundle)
  {
    this.manager.sendData("cmd.setQuickMakeDynamicStatus", paramBundle, false);
  }
  
  public void setRedKeyData(long paramLong, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putString("param.payKey", paramString);
    this.manager.sendData("cmd.qzoneSetRedKeyData", localBundle, true);
  }
  
  public void setUserTail(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("DeviceStrDiyMemo", paramString1);
    localBundle.putString("DeviceStrDeviceTail", paramString2);
    localBundle.putString("DeviceStrDeviceIcon", paramString3);
    localBundle.putString("DeviceStrIdentifySqua", paramString4);
    this.manager.sendData("cmd.setUserTail", localBundle, true);
  }
  
  public void setVideoState(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("param.videoRemoteUrls", paramArrayList1);
    localBundle.putStringArrayList("param.videoStates", paramArrayList2);
    this.manager.sendData("cmd.videoSetState", localBundle, false);
  }
  
  public void startWnsProxyRequestWithCheck(DiscoverTab paramDiscoverTab)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startWebSoRequestWithCheck name:");
    ((StringBuilder)localObject).append(paramDiscoverTab.name);
    QLog.d("QZoneDiscoverActivity", 2, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putParcelable("tab", paramDiscoverTab);
    this.manager.sendData("cmd.discover.startWebSoRequestWithCheck", (Bundle)localObject, false);
  }
  
  public void stopAllVideo()
  {
    this.manager.sendData("cmd.videoStopAll", null, false);
  }
  
  public void stopPlay()
  {
    this.manager.sendData("cmd.stopPlay", null, false);
  }
  
  public void syncWithSignIn(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.textContent", paramString1);
    localBundle.putString("param.signInPictureUrl", paramString2);
    localBundle.putString("param.fontId", paramString3);
    localBundle.putString("param.fontUrl", paramString4);
    this.manager.sendData("cmd.SyncWechatWithSignIn", localBundle, false);
  }
  
  public int updateCustomPraise(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.customPraiseData", paramString);
    return this.manager.sendData("cmd.qzoneUpdateCustomPraise", localBundle, false);
  }
  
  public void updateDynamicAlbumInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("music_id", paramString1);
    localBundle.putString("lrc_id", paramString2);
    localBundle.putString("climax_start", paramString3);
    localBundle.putString("climax_endure", paramString4);
    this.manager.sendData("cmd.UpdateDynamicAlbumInfo", localBundle, true);
  }
  
  public void updateFriendSetting(String paramString1, String paramString2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("type", paramString1);
    localBundle.putString("value", paramString2);
    localBundle.putLong("uin", paramLong);
    this.manager.sendData("cmd.update.friendsetting", localBundle, false);
  }
  
  public void updateSchoolCertificate(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    try
    {
      if (new JSONObject(paramString1).optInt("certificateResult") == 1)
      {
        boolean bool = paramString2.equals("notifyCampusFriendCertificateResult");
        if (bool)
        {
          LocalMultiProcConfig.putInt4Uin("qzone_campusInfo_verfyStatus", 2, Long.valueOf(paramString3).longValue());
          return;
        }
        if (paramString2.equals("notifyUploadSutudentIDResult"))
        {
          LocalMultiProcConfig.putInt4Uin("qzone_campusInfo_verfyStatus", 1, Long.valueOf(paramString3).longValue());
          return;
        }
      }
    }
    catch (JSONException paramString1)
    {
      QLog.i(TAG, 1, "updateSchoolCertificate exception", paramString1);
    }
  }
  
  public void updateSchoolinfo(Bundle paramBundle, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      LocalMultiProcConfig.putString4Uin("qzone_campusInfo_name", paramBundle.getString("name"), Long.valueOf(paramString).longValue());
      LocalMultiProcConfig.putString4Uin("qzone_campusInfo_school_id", paramBundle.getString("schoolid"), Long.valueOf(paramString).longValue());
      LocalMultiProcConfig.putString4Uin("qzone_campusInfo_school_idx", paramBundle.getString("idx"), Long.valueOf(paramString).longValue());
    }
  }
  
  public int uploadAudio(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.tmpLocalFile", paramString);
    localBundle.putInt("param.audioBusiType", paramInt1);
    localBundle.putInt("param.audioFileType", paramInt2);
    localBundle.putByteArray("param.audioExtra", paramArrayOfByte);
    return this.manager.sendData("cmd.qzoneUploadAudio", localBundle, true);
  }
  
  public void uploadFirstDynamicPhoto(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.FirstDynamicPhotoPath", paramString);
    localBundle.putInt("param.DynamicTotalPhotoNum", paramInt);
    this.manager.sendData("cmd.UploadFirstDynamicPhoto", localBundle, true);
  }
  
  public void uploadFirstDynamicPhoto(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.DynamicCloudPhotolistAlbumId", paramString1);
    localBundle.putString("param.DynamicCloudPhotolistlloc", paramString2);
    localBundle.putString("param.DynamicCloudPhotolist", paramString3);
    localBundle.putBoolean("param.DynamicIsFromAlbum", true);
    localBundle.putInt("param.DynamicTotalPhotoNum", paramInt);
    this.manager.sendData("cmd.UploadFirstDynamicPhoto", localBundle, true);
  }
  
  public int uploadTroopPhotos(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, ArrayList<String> paramArrayList, Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_qun_id", paramString2);
    localBundle.putString("ken_qun_name", paramString3);
    localBundle.putString("UploadPhoto.key_album_id", paramString4);
    localBundle.putString("UploadPhoto.key_album_name", paramString5);
    localBundle.putString("refer", "mqqChat");
    if (paramInt != 0)
    {
      if (paramInt == 2) {
        paramInt = 3;
      }
    }
    else {
      paramInt = 0;
    }
    localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", paramArrayList);
    localBundle.putInt("key_quality", paramInt);
    paramString2 = String.valueOf(MessageUtils.a());
    localBundle.putString("key_upload_client_key", paramString2);
    paramString3 = QZoneHelper.UserInfo.getInstance();
    paramString3.qzone_uin = paramString1;
    localBundle.putString("qzone_uin", paramString3.qzone_uin);
    localBundle.putString("nickname", paramString3.nickname);
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramIntent.putExtra("key_upload_client_key", paramString2);
    return this.manager.sendData("cmd_upload_troop_photos", localBundle, true);
  }
  
  public int uploadUps(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.tmpLocalFile", paramString1);
    localBundle.putString("param.jsBid", paramString2);
    return this.manager.sendData("cmd.qzoneUploadUps", localBundle, true);
  }
  
  public void uploadVideoForH5(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.videoForH5Json", paramString);
    this.manager.sendData("cmd.videoUploadForH5", localBundle, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.remote.logic.RemoteRequestSender
 * JD-Core Version:    0.7.0.1
 */