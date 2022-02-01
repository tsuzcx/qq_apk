package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import anvx;
import bhdf;
import bhdj;
import bifw;
import bifz;
import bjkv;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
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
import java.util.HashMap;
import org.json.JSONObject;

public class QzoneQunFeedJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String ACTION_HANDLE_QUN_DETAIL_DELETE = "cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete";
  public static final String NAMESPACE = "Qzone";
  public static final String TAG = "QzoneQunFeedJsPlugin";
  private static String pickCallBack = "";
  private String cacheArgs;
  private Handler handler = new Handler();
  long lastClickTime = 0L;
  Dialog mDownloadingDialog;
  private QQCustomDialog openDialog;
  private BroadcastReceiver unReadMsgBrocastReceiver = new QzoneQunFeedJsPlugin.1(this);
  
  private void alertDownloadErrorCount(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Activity localActivity = this.parentPlugin.mRuntime.a();
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
        str = String.format(localActivity.getString(2131717409), new Object[] { Integer.valueOf(paramInt1) }) + "，";
        str = str + paramString + anvx.a(2131711744);
      }
      paramString = str + String.format(localActivity.getString(2131717402), new Object[] { Integer.valueOf(paramInt2) });
      bhdj.a(localActivity, 232).setMessage(paramString).setNegativeButton(2131717407, new QzoneQunFeedJsPlugin.5(this)).show();
      return;
    }
    bjkv.a().a(localActivity.getString(2131717410) + paramString + anvx.a(2131711743));
  }
  
  private void cancelDownload(String paramString)
  {
    RemoteHandleManager.getInstance().getSender().cancelDownloadTroopPhoto(paramString);
  }
  
  private void doDownloadPicture(String paramString)
  {
    RemoteHandleManager.getInstance().getSender().downloadTroopPhoto(paramString);
  }
  
  private void handleEndQunRedPointNotify(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleEndQunRedPointNotify");
    }
  }
  
  private void handleGroupQuote(String... paramVarArgs)
  {
    int i = 4;
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupQuote " + paramVarArgs[0]);
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramVarArgs[0]);
        int j = ((JSONObject)localObject).getInt("groupCode");
        paramVarArgs = ((JSONObject)localObject).optString("albumid");
        localObject = ((JSONObject)localObject).optString("albumname");
        String str = this.parentPlugin.mRuntime.a().getAccount();
        if (TextUtils.isEmpty(paramVarArgs)) {
          break label151;
        }
        QZoneHelper.forwardToTroopUploadPhoto(this.parentPlugin.mRuntime.a(), str, i, 4, j, "", paramVarArgs, (String)localObject, 7001, 43);
        return;
      }
      catch (Exception paramVarArgs) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
      return;
      label151:
      i = 3;
    }
  }
  
  private void handleGroupUploadPhoto(String... paramVarArgs)
  {
    int i = 1;
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupUploadPhoto " + paramVarArgs[0]);
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      long l = ((JSONObject)localObject).getLong("groupCode");
      paramVarArgs = ((JSONObject)localObject).optString("albumid");
      localObject = ((JSONObject)localObject).optString("albumname");
      String str = this.parentPlugin.mRuntime.a().getAccount();
      if (!TextUtils.isEmpty(paramVarArgs)) {
        i = 2;
      }
      QZoneHelper.forwardMiniToTroopUploadPhoto(this.parentPlugin.mRuntime.a(), str, i, 1, l, "", paramVarArgs, (String)localObject, 7001, 43);
      return;
    }
    catch (Exception paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
    }
  }
  
  private void handleHideTopicComment(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleHideTopicComment");
    }
  }
  
  private void handleImportGroupAio(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupUploadPhoto " + paramVarArgs[0]);
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      int i = ((JSONObject)localObject).getInt("groupCode");
      paramVarArgs = ((JSONObject)localObject).optString("albumid");
      localObject = ((JSONObject)localObject).optString("albumname");
      this.parentPlugin.mRuntime.a().getAccount();
      ChatHistoryActivity.a(this.parentPlugin.mRuntime.a(), String.valueOf(i), paramVarArgs, (String)localObject);
      return;
    }
    catch (Exception paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleImportGroupAio,decode param error");
    }
  }
  
  private void handleQunDetailDelete(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunDetailDelete ");
    }
    try
    {
      paramVarArgs = new Intent("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete");
      this.parentPlugin.mRuntime.a().sendBroadcast(paramVarArgs);
      return;
    }
    catch (Exception paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunDetailDelete exception:" + paramVarArgs);
    }
  }
  
  private void handleQunDidPickAlbum(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunDidPickAlbum " + paramVarArgs[0]);
        }
        try
        {
          Object localObject = new JSONObject(paramVarArgs[0]);
          paramVarArgs = ((JSONObject)localObject).getString("albumid");
          String str = ((JSONObject)localObject).optString("albumname");
          localObject = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("UploadPhoto.key_album_id", paramVarArgs);
          localBundle.putString("UploadPhoto.key_album_name", str);
          ((Intent)localObject).putExtras(localBundle);
          paramVarArgs = this.parentPlugin.mRuntime.a();
          if ((paramVarArgs != null) && (!paramVarArgs.isFinishing()))
          {
            paramVarArgs.setResult(-1, (Intent)localObject);
            paramVarArgs.finish();
            return;
          }
        }
        catch (Exception paramVarArgs) {}
      }
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunDidPickAlbum,decode param error");
  }
  
  private void handleQunDownloadPhoto(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunDownloadPhoto " + paramVarArgs[0]);
    }
    new Intent().putExtra("photos", paramVarArgs[0]);
    RemoteHandleManager.getInstance().addWebEventListener(new QzoneQunFeedJsPlugin.2(this, paramVarArgs));
    if (!isSdcardWorking())
    {
      bjkv.a().a(anvx.a(2131711742));
      return;
    }
    if (!NetworkState.isNetSupport())
    {
      bjkv.a().a(anvx.a(2131711739));
      return;
    }
    if (!NetworkState.isWifiConn())
    {
      Activity localActivity = this.parentPlugin.mRuntime.a();
      bhdj.a(localActivity, 230).setTitle(localActivity.getString(2131717406)).setMessage(localActivity.getString(2131717408)).setPositiveButton(localActivity.getString(2131717405), new QzoneQunFeedJsPlugin.4(this, paramVarArgs)).setNegativeButton(localActivity.getString(2131717404), new QzoneQunFeedJsPlugin.3(this)).show();
      return;
    }
    doDownloadPicture(paramVarArgs[0]);
  }
  
  private void handleQunJumpDetail(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunJumpDetail " + paramVarArgs[0]);
      }
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]).getString("url");
        Intent localIntent = new Intent(this.parentPlugin.mRuntime.a(), QQBrowserDelegationActivity.class);
        localIntent.putExtra("url", paramVarArgs);
        localIntent.putExtra("fromQZone", true);
        localIntent.putExtra("injectrecommend", true);
        if (bifz.a.containsKey("Qzone")) {
          localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
        }
        localIntent.putExtra("source_name", this.parentPlugin.mRuntime.a().getString(2131717211));
        localIntent.setData(Uri.parse(paramVarArgs));
        this.parentPlugin.startActivityForResult(localIntent, (byte)0);
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunJumpDetail,decode param error");
  }
  
  private void handleQunPickQzoneAlbum(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunPickQzoneAlbum " + paramVarArgs[0]);
      }
      try
      {
        pickCallBack = new JSONObject(paramVarArgs[0]).getString("callback");
        paramVarArgs = new Bundle();
        paramVarArgs.putInt("key_personal_album_enter_model", 0);
        paramVarArgs.putBoolean("key_pass_result_by_bundle", true);
        QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
        localUserInfo.qzone_uin = this.parentPlugin.mRuntime.a().getCurrentAccountUin();
        paramVarArgs.putBoolean("key_need_change_to_jpg", true);
        QZoneHelper.forwardToPersonalAlbumSelect(this.parentPlugin.mRuntime.a(), localUserInfo, paramVarArgs, QZoneHelper.generateRequestCode(this.parentPlugin, this.parentPlugin.mRuntime, 6));
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
  }
  
  private void handleShowPhotoList(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupUploadPhoto " + paramVarArgs[0]);
    }
    if (System.currentTimeMillis() - this.lastClickTime < 2000L) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleShowPhotoList too many return " + (System.currentTimeMillis() - this.lastClickTime));
    }
    do
    {
      return;
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        int i = ((JSONObject)localObject2).getInt("groupID");
        paramVarArgs = ((JSONObject)localObject2).optString("albumID");
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
        localPhotoInfo.albumId = paramVarArgs;
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
        ((PhotoParam)localObject1).albumid = paramVarArgs;
        ((PhotoParam)localObject1).cell_id = paramVarArgs;
        ((Bundle)localObject4).putSerializable("picturelist", localArrayList);
        ((Bundle)localObject4).putInt("curindex", 0);
        ((Bundle)localObject4).putInt("mode", 13);
        ((Bundle)localObject4).putBoolean("need_clear_cache", true);
        QZoneHelper.forwardToPictureViewer(this.parentPlugin.mRuntime.a(), (QZoneHelper.UserInfo)localObject2, (Bundle)localObject4, 6);
        this.lastClickTime = System.currentTimeMillis();
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
  }
  
  private void handleStartQunRedPointNotify(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, "handleStartQunRedPointNotify " + paramVarArgs[0]);
      }
      try
      {
        int i = new JSONObject(paramVarArgs[0]).getInt("groupCode");
        i = bhdf.a(this.parentPlugin.mRuntime.a().getAccount(), "troop_photo_message", String.valueOf(i));
        if (QLog.isDevelopLevel()) {
          QLog.d("QzoneQunFeedJsPlugin", 4, "handleStartQunRedPointNotify data=" + i);
        }
        setUnReadMsgNum(i);
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleStartQunRedPointNotify,decode param error");
  }
  
  private boolean isSdcardWorking()
  {
    return SDCardMountMonitorReceiver.getInstance().isSDCardCanWrite();
  }
  
  private void registerUnreadMsgReceiver()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.qq.syncQunMsg");
      this.parentPlugin.mRuntime.a().registerReceiver(this.unReadMsgBrocastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QzoneQunFeedJsPlugin", 1, "registerUnreadMsgReceiver----", localException);
    }
  }
  
  private void setUnReadMsgNum(int paramInt)
  {
    if ((this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.parentPlugin.mRuntime.a();
    } while (localCustomWebView == null);
    localCustomWebView.callJs("window.QZQunRedPointInterface.onReceive({data:" + paramInt + "});");
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("StartQunRedPointNotify"))
    {
      handleStartQunRedPointNotify(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("EndQunRedPointNotify"))
    {
      handleEndQunRedPointNotify(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("GroupUploadPhoto"))
    {
      handleGroupUploadPhoto(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunDownloadPhoto"))
    {
      handleQunDownloadPhoto(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("GroupQuote"))
    {
      handleGroupQuote(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunDidPickAlbum"))
    {
      handleQunDidPickAlbum(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunPickQzoneAlbum"))
    {
      handleQunPickQzoneAlbum(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("HideTopicComment"))
    {
      handleHideTopicComment(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunJumpDetail"))
    {
      handleQunJumpDetail(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunDetailDelete"))
    {
      handleQunDetailDelete(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("ShowGroupPhotoBrowser"))
    {
      handleShowPhotoList(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("ImportGroupAIO"))
    {
      handleImportGroupAio(paramVarArgs);
      return true;
    }
    return false;
  }
  
  public void initRuntime(WebViewPlugin paramWebViewPlugin)
  {
    super.initRuntime(paramWebViewPlugin);
    registerUnreadMsgReceiver();
    SDCardMountMonitorReceiver.getInstance().registerReceiver();
    if ((paramWebViewPlugin != null) && (paramWebViewPlugin.mRuntime != null) && (paramWebViewPlugin.mRuntime.a() != null)) {
      paramWebViewPlugin.mRuntime.a().setResult(50);
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(pickCallBack)) || (paramIntent == null));
      String str1 = paramIntent.getStringExtra("key_selected_albuminfo.id");
      String str2 = paramIntent.getStringExtra("key_selected_albuminfo.name");
      String str3 = paramIntent.getStringExtra("key_selected_albuminfo.cover");
      paramByte = paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
      paramIntent = new StringBuilder();
      paramIntent.append("{albumid:\"").append(str1).append("\",albumname:\"").append(str2).append("\",albumcover:\"").append(str3).append("\",albumpermission:").append(paramByte).append("}");
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, paramIntent.toString());
      }
      this.parentPlugin.callJs(pickCallBack, new String[] { paramIntent.toString() });
      return;
    } while (paramInt != -1);
    this.handler.postDelayed(new QzoneQunFeedJsPlugin.6(this), 2000L);
  }
  
  public void onDestroy()
  {
    try
    {
      this.parentPlugin.mRuntime.a().unregisterReceiver(this.unReadMsgBrocastReceiver);
      SDCardMountMonitorReceiver.getInstance().unregisterReceiver();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin
 * JD-Core Version:    0.7.0.1
 */