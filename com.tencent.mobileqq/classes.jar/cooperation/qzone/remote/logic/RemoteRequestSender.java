package cooperation.qzone.remote.logic;

import NS_QMALL_COVER.AlbumThemeSkin;
import amyn;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.service.message.MessageUtils;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.Map;

public class RemoteRequestSender
  implements RemoteHandleConst
{
  private RemoteHandleManager a;
  
  public RemoteRequestSender(RemoteHandleManager paramRemoteHandleManager)
  {
    this.a = paramRemoteHandleManager;
  }
  
  public int a()
  {
    return this.a.a("cmd.qzoneFontChanged", null, false);
  }
  
  public int a(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    return this.a.a("cmd.pre.getpassivefeeds", localBundle, true);
  }
  
  public int a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.customPraiseData", paramString);
    return this.a.a("cmd.qzoneUpdateCustomPraise", localBundle, false);
  }
  
  public int a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.tmpLocalFile", paramString);
    localBundle.putInt("param.audioBusiType", paramInt1);
    localBundle.putInt("param.audioFileType", paramInt2);
    localBundle.putByteArray("param.audioExtra", paramArrayOfByte);
    return this.a.a("cmd.qzoneUploadAudio", localBundle, true);
  }
  
  public int a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.tmpLocalFile", paramString1);
    localBundle.putString("param.jsBid", paramString2);
    return this.a.a("cmd.qzoneUploadUps", localBundle, true);
  }
  
  public int a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, ArrayList paramArrayList, Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_qun_id", paramString2);
    localBundle.putString("ken_qun_name", paramString3);
    localBundle.putString("UploadPhoto.key_album_id", paramString4);
    localBundle.putString("UploadPhoto.key_album_name", paramString5);
    localBundle.putString("refer", "mqqChat");
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = paramInt;
    }
    for (;;)
    {
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", paramArrayList);
      localBundle.putInt("key_quality", i);
      paramString2 = String.valueOf(MessageUtils.a());
      localBundle.putString("key_upload_client_key", paramString2);
      paramString3 = QZoneHelper.UserInfo.a();
      paramString3.a = paramString1;
      localBundle.putString("qzone_uin", paramString3.a);
      localBundle.putString("nickname", paramString3.b);
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      paramIntent.putExtra("key_upload_client_key", paramString2);
      return this.a.a("cmd_upload_troop_photos", localBundle, true);
      i = 0;
      continue;
      i = 3;
    }
  }
  
  public void a()
  {
    this.a.a("cmd.resumePlay", null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.playModeRandom", paramInt1);
    localBundle.putInt("param.playModeAuto", paramInt2);
    localBundle.putInt("param.playModeLoop", paramInt3);
    this.a.a("cmd.savePlayMode", localBundle, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.origin", paramInt1);
    localBundle.putInt("param.index", paramInt2);
    localBundle.putSerializable("param.songList", paramArrayList);
    this.a.a("cmd.playMusicList", localBundle, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, ArrayList paramArrayList, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.origin", paramInt1);
    localBundle.putInt("param.index", paramInt2);
    localBundle.putSerializable("param.songList", paramArrayList);
    localBundle.putInt("param.playMode", paramInt3);
    this.a.a("cmd.playAudioList", localBundle, false);
  }
  
  public void a(long paramLong, AlbumThemeSkin paramAlbumThemeSkin)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putSerializable("param.album_theme", paramAlbumThemeSkin);
    this.a.a("cmd.alumb.theme", localBundle, false);
  }
  
  public void a(long paramLong, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putString("param.payKey", paramString);
    this.a.a("cmd.qzoneSetRedKeyData", localBundle, true);
  }
  
  public void a(Bundle paramBundle)
  {
    this.a.a("cmd.setLocalPhotoSwitcher", paramBundle, false);
  }
  
  public void a(Boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("param.switchIsHide", paramBoolean.booleanValue());
    this.a.a("cmd.qzoneWidgetAIDataUpdate", localBundle, false);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.DynamicCmd", paramString);
    this.a.a("cmd.getDynamicPhoto", localBundle, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.FirstDynamicPhotoPath", paramString);
    localBundle.putInt("param.DynamicTotalPhotoNum", paramInt);
    this.a.a("cmd.UploadFirstDynamicPhoto", localBundle, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("GiftId_FullScreen", paramString1);
    localBundle.putString("GiftUrl_FullScreen", paramString2);
    this.a.a("cmd.downloadPassivePraise", localBundle, true);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("type", paramString1);
    localBundle.putString("value", paramString2);
    localBundle.putLong("uin", paramLong);
    this.a.a("cmd.update.friendsetting", localBundle, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("GiftId_FullScreen", paramString1);
    localBundle.putString("GiftUrl_FullScreen", paramString2);
    localBundle.putString("GiftMd5_FullScreen", paramString3);
    this.a.a("cmd.downloadGift", localBundle, true);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.DynamicCloudPhotolistAlbumId", paramString1);
    localBundle.putString("param.DynamicCloudPhotolistlloc", paramString2);
    localBundle.putString("param.DynamicCloudPhotolist", paramString3);
    localBundle.putBoolean("param.DynamicIsFromAlbum", true);
    localBundle.putInt("param.DynamicTotalPhotoNum", paramInt);
    this.a.a("cmd.UploadFirstDynamicPhoto", localBundle, true);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.textContent", paramString1);
    localBundle.putString("param.signInPictureUrl", paramString2);
    localBundle.putString("param.fontId", paramString3);
    localBundle.putString("param.fontUrl", paramString4);
    this.a.a("cmd.SyncWechatWithSignIn", localBundle, false);
  }
  
  public void a(ArrayList paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("param.DynamicCloudPhotolist", new ArrayList(paramArrayList));
    this.a.a("cmd.DynamicCloudPhotoSendSuccess", localBundle, true);
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("param.videoRemoteUrls", paramArrayList1);
    localBundle.putStringArrayList("param.videoId", paramArrayList2);
    this.a.a("cmd.videoGetLocalProxyUrl", localBundle, true);
  }
  
  public void a(Map paramMap, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMap);
    localBundle.putSerializable("param.feedDataCookie", localArrayList);
    localBundle.putInt("param.reportPosi", paramInt1);
    localBundle.putInt("param.actionExpectation", paramInt2);
    localBundle.putLong("costTime", paramLong1);
    localBundle.putLong("error_code", paramLong2);
    ThreadManager.post(new amyn(this, localBundle), 2, null, false);
  }
  
  public int b()
  {
    return this.a.a("cmd.qzoneFeedSkinSwitchChanged", null, false);
  }
  
  public void b()
  {
    this.a.a("cmd.pausePlay", null, false);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.uin", paramLong);
    localBundle.putInt("param.origin", paramInt1);
    localBundle.putInt("param.index", paramInt2);
    localBundle.putSerializable("param.songList", paramArrayList);
    this.a.a("cmd.playFMBroadCastList", localBundle, false);
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.a.a("cmd.setHistoryEventTag", paramBundle, false);
      return;
    }
    this.a.a("cmd.setHistoryEventTag", null, false);
  }
  
  public void b(Boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("param.quickCommentIsEnabled", paramBoolean.booleanValue());
    this.a.a("cmd.qzoneWidgetAIQuickComment", localBundle, false);
  }
  
  public void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.DynamicCmd", paramString);
    this.a.a("cmd.getDynamicSelnum", localBundle, true);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("DeviceStrDiyMemo", paramString1);
    localBundle.putString("DeviceStrDeviceTail", paramString2);
    localBundle.putString("DeviceStrDeviceIcon", paramString3);
    localBundle.putString("DeviceStrIdentifySqua", paramString4);
    this.a.a("cmd.setUserTail", localBundle, true);
  }
  
  public void b(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("param.videoRemoteUrls", paramArrayList1);
    localBundle.putStringArrayList("param.videoStates", paramArrayList2);
    this.a.a("cmd.videoSetState", localBundle, false);
  }
  
  public void c()
  {
    this.a.a("cmd.stopPlay", null, false);
  }
  
  public void c(Bundle paramBundle)
  {
    this.a.a("cmd.selectEventTag", paramBundle, false);
  }
  
  public void c(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.CloudDynamicCmd", paramString);
    this.a.a("cmd.getDynamicCloudPhoto", localBundle, true);
  }
  
  public void d()
  {
    this.a.a("cmd.getPlayingSong", null, true);
  }
  
  public void d(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString);
    this.a.a("cmd.troop.download.photo", localBundle, true);
  }
  
  public void e()
  {
    this.a.a("cmd.getLivingInfo", null, true);
  }
  
  public void e(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString);
    this.a.a("cmd.troop.cancel.download.photo", localBundle, false);
  }
  
  public void f()
  {
    this.a.a("cmd.getPlayMode", null, true);
  }
  
  public void f(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.videoRemoteUrls", paramString);
    this.a.a("cmd.videoDownload", localBundle, false);
  }
  
  public void g()
  {
    this.a.a("cmd.initUserInfo", null, false);
  }
  
  public void g(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.videoClientKey", paramString);
    this.a.a("cmd.videoGetFakeFeedCover", localBundle, true);
  }
  
  public void h()
  {
    this.a.a("cmd.notifyPlayListChange", null, false);
  }
  
  public void h(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.recordTempVideoPath", paramString);
    this.a.a("cmd.qzoneDeleteTempVideo", localBundle, false);
  }
  
  public void i()
  {
    this.a.a("cmd.dynamicDestroy", null, true);
  }
  
  public void i(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.videoForH5Json", paramString);
    this.a.a("cmd.videoUploadForH5", localBundle, false);
  }
  
  public void j()
  {
    Bundle localBundle = new Bundle();
    this.a.a("cmd.deletePrePostPhoto", localBundle, true);
  }
  
  public void k()
  {
    Bundle localBundle = new Bundle();
    this.a.a("cmd.cancelAllpreLoad", localBundle, true);
  }
  
  public void l()
  {
    Bundle localBundle = new Bundle();
    this.a.a("cmd.enableUploadFirstDynamicPhoto", localBundle, true);
  }
  
  public void m()
  {
    this.a.a("cmd.getDeviceInfos", null, true);
  }
  
  public void n()
  {
    this.a.a("cmd.videoStopAll", null, false);
  }
  
  public void o()
  {
    Bundle localBundle = new Bundle();
    this.a.a("cmd.qzoneNotifyWidgetAISkinChanged", localBundle, false);
  }
  
  public void p()
  {
    Bundle localBundle = new Bundle();
    this.a.a("cmd.qzoneWidgetAIStartPet", localBundle, false);
  }
  
  public void q()
  {
    this.a.a("cmd.getRecommedPhoto", null, true);
  }
  
  public void r()
  {
    this.a.a("cmd.getLocalPhotoSwitcher", null, true);
  }
  
  public void s()
  {
    this.a.a("cmd.getHistoryEventTag", null, true);
  }
  
  public void t()
  {
    this.a.a("cmd.deleteTimerShuoShuo", null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.remote.logic.RemoteRequestSender
 * JD-Core Version:    0.7.0.1
 */