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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.impl.QZoneHelperProxyImpl;
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
  private String cacheArgs = null;
  private Handler handler = new Handler();
  long lastClickTime = 0L;
  Dialog mDownloadingDialog;
  private QQCustomDialog openDialog;
  private BroadcastReceiver unReadMsgBrocastReceiver = new QzoneQunFeedJsPlugin.1(this);
  
  private void alertDownloadErrorCount(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Activity localActivity = this.parentPlugin.mRuntime.a();
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
        ((StringBuilder)localObject).append(String.format(localActivity.getString(2131717563), new Object[] { Integer.valueOf(paramInt1) }));
        ((StringBuilder)localObject).append("，");
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(paramString);
        localStringBuilder.append(HardCodeUtil.a(2131712234));
        paramString = localStringBuilder.toString();
      }
      else
      {
        paramString = "";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(String.format(localActivity.getString(2131717556), new Object[] { Integer.valueOf(paramInt2) }));
      paramString = ((StringBuilder)localObject).toString();
      DialogUtil.a(localActivity, 232).setMessage(paramString).setNegativeButton(2131717561, new QzoneQunFeedJsPlugin.5(this)).show();
      return;
    }
    localObject = ToastUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localActivity.getString(2131717564));
    localStringBuilder.append(paramString);
    localStringBuilder.append(HardCodeUtil.a(2131712233));
    ((ToastUtil)localObject).a(localStringBuilder.toString());
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
    Object localObject;
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return;
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGroupQuote ");
        ((StringBuilder)localObject).append(paramVarArgs[0]);
        QLog.d("QzoneQunFeedJsPlugin", 4, ((StringBuilder)localObject).toString());
      }
    }
    try
    {
      localObject = new JSONObject(paramVarArgs[0]);
      j = ((JSONObject)localObject).getInt("groupCode");
      paramVarArgs = ((JSONObject)localObject).optString("albumid");
      localObject = ((JSONObject)localObject).optString("albumname");
      str = this.parentPlugin.mRuntime.a().getAccount();
      if (TextUtils.isEmpty(paramVarArgs)) {
        break label167;
      }
      i = 4;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        int j;
        String str;
        continue;
        int i = 3;
      }
    }
    QZoneHelper.forwardToTroopUploadPhoto(this.parentPlugin.mRuntime.a(), str, i, 4, j, "", paramVarArgs, (String)localObject, 7001, 43);
    return;
    if (QLog.isColorLevel()) {
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
    }
  }
  
  private void handleGroupUploadPhoto(String... paramVarArgs)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGroupUploadPhoto ");
      ((StringBuilder)localObject).append(paramVarArgs[0]);
      QLog.d("QzoneQunFeedJsPlugin", 4, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject(paramVarArgs[0]);
      l = ((JSONObject)localObject).getLong("groupCode");
      paramVarArgs = ((JSONObject)localObject).optString("albumid");
      localObject = ((JSONObject)localObject).optString("albumname");
      str = this.parentPlugin.mRuntime.a().getAccount();
      if (TextUtils.isEmpty(paramVarArgs)) {
        break label157;
      }
      i = 2;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        long l;
        String str;
        continue;
        int i = 1;
      }
    }
    QZoneHelper.forwardMiniToTroopUploadPhoto(this.parentPlugin.mRuntime.a(), str, i, 1, l, "", paramVarArgs, (String)localObject, 7001, 43);
    return;
    if (QLog.isColorLevel()) {
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
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGroupUploadPhoto ");
      ((StringBuilder)localObject).append(paramVarArgs[0]);
      QLog.d("QzoneQunFeedJsPlugin", 4, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject(paramVarArgs[0]);
      int i = ((JSONObject)localObject).getInt("groupCode");
      paramVarArgs = ((JSONObject)localObject).optString("albumid");
      localObject = ((JSONObject)localObject).optString("albumname");
      this.parentPlugin.mRuntime.a().getAccount();
      ChatHistoryActivity.a(this.parentPlugin.mRuntime.a(), String.valueOf(i), paramVarArgs, (String)localObject);
      return;
    }
    catch (Exception paramVarArgs)
    {
      label106:
      break label106;
    }
    if (QLog.isColorLevel()) {
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleQunDetailDelete exception:");
        localStringBuilder.append(paramVarArgs);
        QLog.w("QzoneQunFeedJsPlugin", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void handleQunDidPickAlbum(String... paramVarArgs)
  {
    Object localObject;
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return;
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleQunDidPickAlbum ");
        ((StringBuilder)localObject).append(paramVarArgs[0]);
        QLog.d("QzoneQunFeedJsPlugin", 4, ((StringBuilder)localObject).toString());
      }
    }
    try
    {
      localObject = new JSONObject(paramVarArgs[0]);
      paramVarArgs = ((JSONObject)localObject).getString("albumid");
      String str = ((JSONObject)localObject).optString("albumname");
      localObject = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("UploadPhoto.key_album_id", paramVarArgs);
      localBundle.putString("UploadPhoto.key_album_name", str);
      ((Intent)localObject).putExtras(localBundle);
      paramVarArgs = this.parentPlugin.mRuntime.a();
      if ((paramVarArgs == null) || (paramVarArgs.isFinishing())) {
        break label165;
      }
      paramVarArgs.setResult(-1, (Intent)localObject);
      paramVarArgs.finish();
      return;
    }
    catch (Exception paramVarArgs)
    {
      label150:
      label165:
      break label150;
    }
    if (QLog.isColorLevel()) {
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunDidPickAlbum,decode param error");
    }
  }
  
  private void handleQunDownloadPhoto(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return;
      }
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleQunDownloadPhoto ");
        ((StringBuilder)localObject).append(paramVarArgs[0]);
        QLog.d("QzoneQunFeedJsPlugin", 4, ((StringBuilder)localObject).toString());
      }
      new Intent().putExtra("photos", paramVarArgs[0]);
      RemoteHandleManager.getInstance().addWebEventListener(new QzoneQunFeedJsPlugin.2(this, paramVarArgs));
      if (!isSdcardWorking())
      {
        ToastUtil.a().a(HardCodeUtil.a(2131712232));
        return;
      }
      if (!NetworkState.isNetSupport())
      {
        ToastUtil.a().a(HardCodeUtil.a(2131712229));
        return;
      }
      if (!NetworkState.isWifiConn())
      {
        localObject = this.parentPlugin.mRuntime.a();
        DialogUtil.a((Context)localObject, 230).setTitle(((Context)localObject).getString(2131717560)).setMessage(((Context)localObject).getString(2131717562)).setPositiveButton(((Context)localObject).getString(2131717559), new QzoneQunFeedJsPlugin.4(this, paramVarArgs)).setNegativeButton(((Context)localObject).getString(2131717558), new QzoneQunFeedJsPlugin.3(this)).show();
        return;
      }
      doDownloadPicture(paramVarArgs[0]);
    }
  }
  
  private void handleQunJumpDetail(String... paramVarArgs)
  {
    Object localObject;
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return;
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleQunJumpDetail ");
        ((StringBuilder)localObject).append(paramVarArgs[0]);
        QLog.d("QzoneQunFeedJsPlugin", 4, ((StringBuilder)localObject).toString());
      }
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]).getString("url");
      localObject = new Intent(this.parentPlugin.mRuntime.a(), QQBrowserDelegationActivity.class);
      ((Intent)localObject).putExtra("url", paramVarArgs);
      ((Intent)localObject).putExtra("fromQZone", true);
      ((Intent)localObject).putExtra("injectrecommend", true);
      if (WebViewPluginFactory.a.containsKey("Qzone")) {
        ((Intent)localObject).putExtra("insertPluginsArray", new String[] { "Qzone" });
      }
      ((Intent)localObject).putExtra("source_name", this.parentPlugin.mRuntime.a().getString(2131717365));
      ((Intent)localObject).setData(Uri.parse(paramVarArgs));
      this.parentPlugin.startActivityForResult((Intent)localObject, (byte)0);
      return;
    }
    catch (Exception paramVarArgs)
    {
      label186:
      break label186;
    }
    if (QLog.isColorLevel()) {
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunJumpDetail,decode param error");
    }
  }
  
  private void handleQunPickQzoneAlbum(String... paramVarArgs)
  {
    Object localObject;
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return;
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleQunPickQzoneAlbum ");
        ((StringBuilder)localObject).append(paramVarArgs[0]);
        QLog.d("QzoneQunFeedJsPlugin", 4, ((StringBuilder)localObject).toString());
      }
    }
    try
    {
      pickCallBack = new JSONObject(paramVarArgs[0]).getString("callback");
      paramVarArgs = new Bundle();
      paramVarArgs.putInt("key_personal_album_enter_model", 0);
      paramVarArgs.putBoolean("key_pass_result_by_bundle", true);
      localObject = QZoneHelper.UserInfo.getInstance();
      ((QZoneHelper.UserInfo)localObject).qzone_uin = this.parentPlugin.mRuntime.a().getCurrentAccountUin();
      paramVarArgs.putBoolean("key_need_change_to_jpg", true);
      QZoneHelper.forwardToPersonalAlbumSelect(this.parentPlugin.mRuntime.a(), (QZoneHelper.UserInfo)localObject, paramVarArgs, QZoneHelperProxyImpl.generateRequestCode(this.parentPlugin, this.parentPlugin.mRuntime, 6));
      return;
    }
    catch (Exception paramVarArgs)
    {
      label154:
      break label154;
    }
    if (QLog.isColorLevel()) {
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private void handleShowPhotoList(String... paramVarArgs)
  {
    Object localObject1;
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleGroupUploadPhoto ");
      ((StringBuilder)localObject1).append(paramVarArgs[0]);
      QLog.d("QzoneQunFeedJsPlugin", 4, ((StringBuilder)localObject1).toString());
    }
    if (System.currentTimeMillis() - this.lastClickTime < 2000L)
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("handleShowPhotoList too many return ");
      paramVarArgs.append(System.currentTimeMillis() - this.lastClickTime);
      QLog.d("QzoneQunFeedJsPlugin", 4, paramVarArgs.toString());
      return;
    }
    try
    {
      localObject2 = new JSONObject(paramVarArgs[0]);
      i = ((JSONObject)localObject2).getInt("groupID");
      paramVarArgs = ((JSONObject)localObject2).optString("albumID");
      localObject5 = ((JSONObject)localObject2).optString("photoID");
      localObject4 = ((JSONObject)localObject2).optString("uin");
      localObject3 = ((JSONObject)localObject2).optString("bigurl");
      l = ((JSONObject)localObject2).optLong("uin");
      j = ((JSONObject)localObject2).optInt("isVideo");
      k = ((JSONObject)localObject2).optInt("orgVideoSize");
      m = ((JSONObject)localObject2).optInt("videoWidth");
      n = ((JSONObject)localObject2).optInt("videoHeight");
      localObject1 = ((JSONObject)localObject2).optString("videoURL");
      str = ((JSONObject)localObject2).optString("videoID");
      localObject2 = QZoneHelper.UserInfo.getInstance();
      ((QZoneHelper.UserInfo)localObject2).qzone_uin = ((String)localObject4);
      localObject4 = new Bundle();
    }
    catch (Exception paramVarArgs)
    {
      Object localObject2;
      int i;
      Object localObject5;
      Object localObject4;
      Object localObject3;
      long l;
      int j;
      int k;
      int m;
      int n;
      String str;
      ArrayList localArrayList;
      PhotoInfo localPhotoInfo;
      label534:
      label537:
      break label537;
    }
    try
    {
      localArrayList = new ArrayList();
      localPhotoInfo = new PhotoInfo();
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
    catch (Exception paramVarArgs)
    {
      break label534;
    }
    if (QLog.isColorLevel()) {
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
    }
  }
  
  private void handleStartQunRedPointNotify(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return;
      }
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleStartQunRedPointNotify ");
        localStringBuilder.append(paramVarArgs[0]);
        QLog.d("QzoneQunFeedJsPlugin", 4, localStringBuilder.toString());
      }
    }
    try
    {
      int i = new JSONObject(paramVarArgs[0]).getInt("groupCode");
      paramVarArgs = this.parentPlugin.mRuntime.a().getAccount();
      i = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(paramVarArgs, "troop_photo_message", String.valueOf(i));
      if (QLog.isDevelopLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("handleStartQunRedPointNotify data=");
        paramVarArgs.append(i);
        QLog.d("QzoneQunFeedJsPlugin", 4, paramVarArgs.toString());
      }
      setUnReadMsgNum(i);
      return;
    }
    catch (Exception paramVarArgs)
    {
      label147:
      break label147;
    }
    if (QLog.isColorLevel()) {
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleStartQunRedPointNotify,decode param error");
    }
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
    if (this.parentPlugin != null)
    {
      if (this.parentPlugin.mRuntime == null) {
        return;
      }
      CustomWebView localCustomWebView = this.parentPlugin.mRuntime.a();
      if (localCustomWebView != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("window.QZQunRedPointInterface.onReceive({data:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("});");
        localCustomWebView.callJs(localStringBuilder.toString());
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
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
    if (paramByte != 4)
    {
      if (paramByte != 6) {
        return;
      }
      if ((!TextUtils.isEmpty(pickCallBack)) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("key_selected_albuminfo.id");
        String str2 = paramIntent.getStringExtra("key_selected_albuminfo.name");
        String str3 = paramIntent.getStringExtra("key_selected_albuminfo.cover");
        paramByte = paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
        paramIntent = new StringBuilder();
        paramIntent.append("{albumid:\"");
        paramIntent.append(str1);
        paramIntent.append("\",albumname:\"");
        paramIntent.append(str2);
        paramIntent.append("\",albumcover:\"");
        paramIntent.append(str3);
        paramIntent.append("\",albumpermission:");
        paramIntent.append(paramByte);
        paramIntent.append("}");
        if (QLog.isDevelopLevel()) {
          QLog.d("QzoneQunFeedJsPlugin", 4, paramIntent.toString());
        }
        this.parentPlugin.callJs(pickCallBack, new String[] { paramIntent.toString() });
      }
    }
    else if (paramInt == -1)
    {
      this.handler.postDelayed(new QzoneQunFeedJsPlugin.6(this), 2000L);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin
 * JD-Core Version:    0.7.0.1
 */