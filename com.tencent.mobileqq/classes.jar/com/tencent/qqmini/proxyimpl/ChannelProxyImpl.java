package com.tencent.qqmini.proxyimpl;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StInteractiveTemplate;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingReq;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import NS_MINI_INTERFACE.INTERFACE.StReportExecuteReq;
import NS_MINI_INTERFACE.INTERFACE.StReportExecuteRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import Wallet.FocusMpIdReq;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ReportHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.mini.appbrand.ui.MiniAppWebviewFragment;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment;
import com.tencent.mobileqq.mini.mainpage.PhoneNumberManagementFragment;
import com.tencent.mobileqq.mini.manager.MiniTianShuManager;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.mini.ui.MiniAIOEntryView;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.mini.zxing.MultiFormatReader;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo.MediaInfo;
import com.tencent.mobileqq.minigame.report.MiniGameBeaconReport;
import com.tencent.mobileqq.minigame.ui.RedpacketTranslucentBrowserFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.oskplayer.OskPlayerConfig;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.DefaultCacheKeyGenerator;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.DefaultLogger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.auth.SubscribeMessage;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.BeaconReportCategory;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.ICommandListenr;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.SoLoaderOption;
import com.tencent.qqmini.sdk.launcher.core.proxy.IFlutterProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import com.tencent.qqmini.sdk.launcher.model.TouchInfo;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QZoneShareManager;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.tianshu.TianShuManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChannelProxyImpl
  implements ChannelProxy
{
  private static final String jdField_a_of_type_JavaLangString;
  public static ArrayList<TouchInfo> a;
  public static volatile boolean a;
  private static final boolean b;
  MultiFormatReader jdField_a_of_type_ComTencentMobileqqMiniZxingMultiFormatReader;
  private volatile FFmpeg jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    boolean bool = false;
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "useSuperPlayer", 0) == 1) {
      bool = true;
    }
    b = bool;
  }
  
  private static MiniAppCmdInterface a(AsyncResult paramAsyncResult)
  {
    return new ChannelProxyImpl.9(paramAsyncResult);
  }
  
  public static PublishMoodInfo a(IMiniAppContext paramIMiniAppContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    PublishMoodInfo localPublishMoodInfo = new PublishMoodInfo();
    for (;;)
    {
      int i;
      try
      {
        Object localObject3 = new JSONObject(paramString);
        boolean bool = ((JSONObject)localObject3).has("text");
        Object localObject2 = "";
        if (!bool) {
          break label497;
        }
        localObject1 = ((JSONObject)localObject3).getString("text");
        localPublishMoodInfo.mText = ((String)localObject1);
        if (!((JSONObject)localObject3).has("tag")) {
          break label504;
        }
        localObject1 = ((JSONObject)localObject3).getString("tag");
        localPublishMoodInfo.mTag = ((String)localObject1);
        if (!((JSONObject)localObject3).has("path")) {
          break label511;
        }
        localObject1 = ((JSONObject)localObject3).optString("path");
        localPublishMoodInfo.mPath = ((String)localObject1);
        localObject1 = localObject2;
        if (((JSONObject)localObject3).has("footnote")) {
          localObject1 = ((JSONObject)localObject3).optString("footnote");
        }
        localPublishMoodInfo.mFootnote = ((String)localObject1);
        if ((((JSONObject)localObject3).has("media")) && (!TextUtils.isEmpty(((JSONObject)localObject3).getString("media"))))
        {
          localObject1 = new ArrayList();
          localObject2 = ((JSONObject)localObject3).getJSONArray("media");
          int j = ((JSONArray)localObject2).length();
          i = 0;
          if (i < j)
          {
            localObject3 = ((JSONArray)localObject2).getJSONObject(i);
            bool = ((JSONObject)localObject3).has("type");
            if ((bool) && (((JSONObject)localObject3).has("path")))
            {
              localObject4 = ((JSONObject)localObject3).getString("type");
              String str = ((JSONObject)localObject3).getString("path");
              if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty(str)))
              {
                localObject3 = new PublishMoodInfo.MediaInfo();
                if (paramIMiniAppContext != null) {
                  ((PublishMoodInfo.MediaInfo)localObject3).mPath = ((IMiniAppFileManager)paramIMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(str);
                }
                if ("photo".equalsIgnoreCase((String)localObject4))
                {
                  ((PublishMoodInfo.MediaInfo)localObject3).mType = 1;
                  ((ArrayList)localObject1).add(localObject3);
                  break label518;
                }
                if (!"video".equalsIgnoreCase((String)localObject4)) {
                  break label518;
                }
                ((PublishMoodInfo.MediaInfo)localObject3).mType = 2;
                ((ArrayList)localObject1).add(localObject3);
                break label518;
              }
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("invalid mediaItem, ");
              ((StringBuilder)localObject4).append(localObject3);
              QLog.i("ChannelProxyImpl", 2, ((StringBuilder)localObject4).toString());
              break label518;
            }
            Object localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("invalid mediaItem, ");
            ((StringBuilder)localObject4).append(localObject3);
            QLog.i("ChannelProxyImpl", 2, ((StringBuilder)localObject4).toString());
            break label518;
          }
          localPublishMoodInfo.mMediaInfo = ((ArrayList)localObject1);
          return localPublishMoodInfo;
        }
      }
      catch (Exception paramIMiniAppContext)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseJsonToMoodInfo error ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.i("ChannelProxyImpl", 1, ((StringBuilder)localObject1).toString(), paramIMiniAppContext);
      }
      return localPublishMoodInfo;
      label497:
      Object localObject1 = "";
      continue;
      label504:
      localObject1 = "";
      continue;
      label511:
      localObject1 = "";
      continue;
      label518:
      i += 1;
    }
  }
  
  private TianShuReportData a(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    int i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    TianShuReportData localTianShuReportData = new TianShuReportData();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(CommonDataAdapter.a().a()));
    localStringBuilder.append('_');
    localStringBuilder.append(i);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.d = paramInt;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.g = String.valueOf(paramAdItem.iAdId.get());
    localTianShuReportData.n = paramString;
    localTianShuReportData.jdField_a_of_type_Long = i;
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.81";
    localTianShuReportData.i = "";
    return localTianShuReportData;
  }
  
  private UserSettingInfo a(INTERFACE.StUserSettingInfo paramStUserSettingInfo)
  {
    UserSettingInfo localUserSettingInfo = new UserSettingInfo();
    localUserSettingInfo.settingItem = paramStUserSettingInfo.settingItem.get();
    localUserSettingInfo.authState = paramStUserSettingInfo.authState.get();
    localUserSettingInfo.desc = paramStUserSettingInfo.desc.get();
    paramStUserSettingInfo = paramStUserSettingInfo.subItems.get();
    if ((paramStUserSettingInfo != null) && (paramStUserSettingInfo.size() > 0))
    {
      localUserSettingInfo.subItems = new ArrayList();
      paramStUserSettingInfo = paramStUserSettingInfo.iterator();
      while (paramStUserSettingInfo.hasNext())
      {
        INTERFACE.StSubscribeMessage localStSubscribeMessage = (INTERFACE.StSubscribeMessage)paramStUserSettingInfo.next();
        SubscribeMessage localSubscribeMessage = new SubscribeMessage();
        localSubscribeMessage.authState = localStSubscribeMessage.authState.get();
        localSubscribeMessage.templateId = localStSubscribeMessage.templateId.get();
        localUserSettingInfo.subItems.add(localSubscribeMessage);
      }
    }
    return localUserSettingInfo;
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2)) {
        return "file";
      }
      return "media";
    }
    return "image";
  }
  
  private void a(Activity paramActivity, PublishMoodInfo paramPublishMoodInfo, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramActivity != null) && (paramPublishMoodInfo != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("summary", paramPublishMoodInfo.mText);
      localBundle.putBoolean("key_need_save_draft", false);
      localBundle.putBoolean("from_mini_app", true);
      localBundle.putStringArrayList("images", paramPublishMoodInfo.mAllImageAndVideo);
      localBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", paramPublishMoodInfo.mMediaInfoHashMap);
      localBundle.putString("shareSource", "miniApp");
      String str1;
      if (paramMiniAppInfo != null)
      {
        String str2 = paramMiniAppInfo.appId;
        str1 = str2;
        if (paramMiniAppInfo != null)
        {
          str1 = "https://m.q.qq.com/a/p/{appid}".replace("{appid}", str2);
          if (!TextUtils.isEmpty(paramPublishMoodInfo.mPath))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str1);
            ((StringBuilder)localObject).append("?s=");
            ((StringBuilder)localObject).append(paramPublishMoodInfo.mPath);
            ((StringBuilder)localObject).append("&referer=");
            ((StringBuilder)localObject).append(2100);
            str1 = ((StringBuilder)localObject).toString();
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str1);
            ((StringBuilder)localObject).append("?referer=2100");
            str1 = ((StringBuilder)localObject).toString();
          }
          if (TextUtils.isEmpty(paramPublishMoodInfo.mFootnote)) {
            paramPublishMoodInfo = paramActivity.getResources().getString(2131694156);
          } else {
            paramPublishMoodInfo = paramPublishMoodInfo.mFootnote;
          }
          Object localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("icon_url", paramMiniAppInfo.iconUrl);
            ((JSONObject)localObject).put("title", paramMiniAppInfo.name);
            ((JSONObject)localObject).put("summary", paramPublishMoodInfo);
            ((JSONObject)localObject).put("jump_url", str1);
            ((JSONObject)localObject).put("button_txt", paramActivity.getResources().getString(2131694167));
            ((JSONObject)localObject).put("recom_bottom_id", 2);
            ((JSONObject)localObject).put("action_type", 2);
            paramPublishMoodInfo = ((JSONObject)localObject).toString();
            localBundle.putString("key_mini_app_tail", paramPublishMoodInfo);
            paramMiniAppInfo = new StringBuilder();
            paramMiniAppInfo.append("publishMood， comm_recom_bottom： ");
            paramMiniAppInfo.append(paramPublishMoodInfo);
            QLog.d("ChannelProxyImpl", 1, paramMiniAppInfo.toString());
            str1 = str2;
          }
          catch (Exception paramPublishMoodInfo)
          {
            paramMiniAppInfo = new StringBuilder();
            paramMiniAppInfo.append("publishMood exception: ");
            paramMiniAppInfo.append(Log.getStackTraceString(paramPublishMoodInfo));
            QLog.d("ChannelProxyImpl", 1, paramMiniAppInfo.toString());
            str1 = str2;
          }
        }
      }
      else
      {
        str1 = null;
      }
      localBundle.putString("key_mini_appid", str1);
      QZoneShareManager.publishToQzoneFromMiniApp(paramActivity, localBundle, null, -1);
      return;
    }
    QLog.i("ChannelProxyImpl", 2, "handle moodInfo is null");
  }
  
  public static void a(Context paramContext)
  {
    if (!jdField_a_of_type_Boolean)
    {
      Object localObject = new OskPlayerConfig();
      ((OskPlayerConfig)localObject).setEnableHLSCache(true);
      ((OskPlayerConfig)localObject).setDebugVersion(true);
      ((OskPlayerConfig)localObject).setLogger(new DefaultLogger());
      ((OskPlayerConfig)localObject).setCacheKeyGenerator(new DefaultCacheKeyGenerator());
      OskPlayerCore.init(paramContext.getApplicationContext(), (OskPlayerConfig)localObject);
      paramContext = PlayerConfig.g().getContentTypeList();
      if (paramContext != null) {
        try
        {
          paramContext.addAll(Arrays.asList(jdField_a_of_type_JavaLangString.split("|")));
          PlayerConfig.g().setContentTypeList(paramContext);
        }
        catch (Exception paramContext)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initOskOnce contentTypeList.addAll oskPlayerContentTypeStrList get an err!!:");
          ((StringBuilder)localObject).append(paramContext);
          QLog.e("ChannelProxyImpl", 1, ((StringBuilder)localObject).toString());
        }
      } else {
        QLog.e("ChannelProxyImpl", 1, "getContentTypeList null");
      }
      jdField_a_of_type_Boolean = true;
    }
  }
  
  public void ReportExecute(String paramString1, int paramInt, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    INTERFACE.StReportExecuteReq localStReportExecuteReq = new INTERFACE.StReportExecuteReq();
    localStReportExecuteReq.appid.set(paramString1);
    localStReportExecuteReq.execTime.set(paramInt);
    localStReportExecuteReq.instrTraceId.set(paramString2);
    localStReportExecuteReq.ruleName.set(paramString3);
    MiniAppSSOCmdHelper.sendSSOCmdRequest("LightAppSvc.mini_app_growguard.ReportExecute", paramString1, localStReportExecuteReq, INTERFACE.StReportExecuteRsp.class, new ChannelProxyImpl.3(this, paramAsyncResult));
  }
  
  public void addGroupApp(IMiniAppContext paramIMiniAppContext, AsyncResult paramAsyncResult)
  {
    QLog.d("ChannelProxyImpl", 1, "addGroupApp");
    if (paramIMiniAppContext == null) {}
    int i;
    try
    {
      QLog.e("ChannelProxyImpl", 1, "addGroupApp, miniAppContext=null");
      paramIMiniAppContext = new JSONObject();
      paramIMiniAppContext.put("errMsg", "miniAppContext is null");
      paramAsyncResult.onReceiveResult(false, paramIMiniAppContext);
      return;
    }
    catch (Exception paramIMiniAppContext)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addGroupApp, exception: ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramIMiniAppContext));
      QLog.e("ChannelProxyImpl", 1, ((StringBuilder)localObject).toString());
      paramAsyncResult.onReceiveResult(false, null);
      return;
    }
    if (paramIMiniAppContext.getMiniAppInfo().launchParam.entryModel != null) {
      i = 1;
    }
    for (;;)
    {
      Object localObject = paramIMiniAppContext.getMiniAppInfo().appId;
      if (i != 0)
      {
        if (!paramIMiniAppContext.getMiniAppInfo().launchParam.entryModel.isAdmin)
        {
          paramIMiniAppContext = new JSONObject();
          paramIMiniAppContext.put("errMsg", "non-administrators");
          paramAsyncResult.onReceiveResult(false, paramIMiniAppContext);
          return;
        }
        TroopApplicationListUtil.addMiniAppToTroopApplicationList(String.valueOf(paramIMiniAppContext.getMiniAppInfo().launchParam.entryModel.uin), (String)localObject, null, paramAsyncResult);
        return;
      }
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "query_user_troop_info", new Bundle(), new ChannelProxyImpl.15(this, paramIMiniAppContext, (String)localObject, paramAsyncResult));
      return;
      i = 0;
    }
  }
  
  public void addPhoneNumber(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().addPhoneNumber(paramString1, paramString2, paramString3, paramInt, a(paramAsyncResult));
  }
  
  public boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    paramString1 = new FocusMpIdReq(paramString1, paramString2);
    ((IQWalletApi)QRoute.api(IQWalletApi.class)).servletSendRequest(paramString1, new ChannelProxyImpl.8(this, paramAsyncResult));
    return true;
  }
  
  public void batchGetContact(ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().batchGetContact(paramArrayList, a(paramAsyncResult));
  }
  
  public void checkBindingState(String paramString1, String paramString2, int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkBindingState(paramString1, paramString2, paramInt, a(paramAsyncResult));
  }
  
  public void checkNavigateRight(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkNavigateRight(paramString1, paramString2, null, a(paramAsyncResult));
  }
  
  public void checkOfferId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkOfferId(paramString1, paramString2, null, a(paramAsyncResult));
  }
  
  public void checkSession(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkSession(paramString, a(paramAsyncResult));
  }
  
  public void checkWxPayUrl(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().checkWxPayUrl(paramString1, paramString2, a(paramAsyncResult));
  }
  
  public void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().performDataReport(paramArrayOfByte, a(paramAsyncResult));
  }
  
  /* Error */
  public String decodeQR(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    // Byte code:
    //   0: invokestatic 719	java/lang/System:nanoTime	()J
    //   3: lstore 8
    //   5: aload_0
    //   6: getfield 721	com/tencent/qqmini/proxyimpl/ChannelProxyImpl:jdField_a_of_type_ComTencentMobileqqMiniZxingMultiFormatReader	Lcom/tencent/mobileqq/mini/zxing/MultiFormatReader;
    //   9: ifnonnull +179 -> 188
    //   12: aload_0
    //   13: new 723	com/tencent/mobileqq/mini/zxing/MultiFormatReader
    //   16: dup
    //   17: invokespecial 724	com/tencent/mobileqq/mini/zxing/MultiFormatReader:<init>	()V
    //   20: putfield 721	com/tencent/qqmini/proxyimpl/ChannelProxyImpl:jdField_a_of_type_ComTencentMobileqqMiniZxingMultiFormatReader	Lcom/tencent/mobileqq/mini/zxing/MultiFormatReader;
    //   23: new 726	java/util/HashMap
    //   26: dup
    //   27: invokespecial 727	java/util/HashMap:<init>	()V
    //   30: astore 12
    //   32: aload 12
    //   34: getstatic 733	com/tencent/mobileqq/mini/zxing/DecodeHintType:TRY_HARDER	Lcom/tencent/mobileqq/mini/zxing/DecodeHintType;
    //   37: iconst_1
    //   38: invokestatic 738	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   41: invokeinterface 743 3 0
    //   46: pop
    //   47: new 18	java/util/ArrayList
    //   50: dup
    //   51: invokespecial 21	java/util/ArrayList:<init>	()V
    //   54: astore 13
    //   56: aload 13
    //   58: getstatic 749	com/tencent/mobileqq/mini/zxing/BarcodeFormat:CODABAR	Lcom/tencent/mobileqq/mini/zxing/BarcodeFormat;
    //   61: invokeinterface 342 2 0
    //   66: pop
    //   67: aload 13
    //   69: getstatic 752	com/tencent/mobileqq/mini/zxing/BarcodeFormat:CODE_39	Lcom/tencent/mobileqq/mini/zxing/BarcodeFormat;
    //   72: invokeinterface 342 2 0
    //   77: pop
    //   78: aload 13
    //   80: getstatic 755	com/tencent/mobileqq/mini/zxing/BarcodeFormat:CODE_93	Lcom/tencent/mobileqq/mini/zxing/BarcodeFormat;
    //   83: invokeinterface 342 2 0
    //   88: pop
    //   89: aload 13
    //   91: getstatic 758	com/tencent/mobileqq/mini/zxing/BarcodeFormat:CODE_128	Lcom/tencent/mobileqq/mini/zxing/BarcodeFormat;
    //   94: invokeinterface 342 2 0
    //   99: pop
    //   100: aload 13
    //   102: getstatic 761	com/tencent/mobileqq/mini/zxing/BarcodeFormat:EAN_8	Lcom/tencent/mobileqq/mini/zxing/BarcodeFormat;
    //   105: invokeinterface 342 2 0
    //   110: pop
    //   111: aload 13
    //   113: getstatic 764	com/tencent/mobileqq/mini/zxing/BarcodeFormat:EAN_13	Lcom/tencent/mobileqq/mini/zxing/BarcodeFormat;
    //   116: invokeinterface 342 2 0
    //   121: pop
    //   122: aload 13
    //   124: getstatic 767	com/tencent/mobileqq/mini/zxing/BarcodeFormat:ITF	Lcom/tencent/mobileqq/mini/zxing/BarcodeFormat;
    //   127: invokeinterface 342 2 0
    //   132: pop
    //   133: aload 13
    //   135: getstatic 770	com/tencent/mobileqq/mini/zxing/BarcodeFormat:UPC_A	Lcom/tencent/mobileqq/mini/zxing/BarcodeFormat;
    //   138: invokeinterface 342 2 0
    //   143: pop
    //   144: aload 13
    //   146: getstatic 773	com/tencent/mobileqq/mini/zxing/BarcodeFormat:UPC_E	Lcom/tencent/mobileqq/mini/zxing/BarcodeFormat;
    //   149: invokeinterface 342 2 0
    //   154: pop
    //   155: aload 13
    //   157: getstatic 776	com/tencent/mobileqq/mini/zxing/BarcodeFormat:UPC_EAN_EXTENSION	Lcom/tencent/mobileqq/mini/zxing/BarcodeFormat;
    //   160: invokeinterface 342 2 0
    //   165: pop
    //   166: aload 12
    //   168: getstatic 779	com/tencent/mobileqq/mini/zxing/DecodeHintType:POSSIBLE_FORMATS	Lcom/tencent/mobileqq/mini/zxing/DecodeHintType;
    //   171: aload 13
    //   173: invokeinterface 743 3 0
    //   178: pop
    //   179: aload_0
    //   180: getfield 721	com/tencent/qqmini/proxyimpl/ChannelProxyImpl:jdField_a_of_type_ComTencentMobileqqMiniZxingMultiFormatReader	Lcom/tencent/mobileqq/mini/zxing/MultiFormatReader;
    //   183: aload 12
    //   185: invokevirtual 783	com/tencent/mobileqq/mini/zxing/MultiFormatReader:setHints	(Ljava/util/Map;)V
    //   188: new 785	com/tencent/mobileqq/mini/zxing/BinaryBitmap
    //   191: dup
    //   192: new 787	com/tencent/mobileqq/mini/zxing/common/HybridBinarizer
    //   195: dup
    //   196: new 789	com/tencent/mobileqq/mini/zxing/PlanarYUVLuminanceSource
    //   199: dup
    //   200: aload_1
    //   201: iload_2
    //   202: iload_3
    //   203: iload 4
    //   205: iload 5
    //   207: iload_2
    //   208: iload_3
    //   209: iconst_0
    //   210: invokespecial 792	com/tencent/mobileqq/mini/zxing/PlanarYUVLuminanceSource:<init>	([BIIIIIIZ)V
    //   213: invokespecial 795	com/tencent/mobileqq/mini/zxing/common/HybridBinarizer:<init>	(Lcom/tencent/mobileqq/mini/zxing/LuminanceSource;)V
    //   216: invokespecial 798	com/tencent/mobileqq/mini/zxing/BinaryBitmap:<init>	(Lcom/tencent/mobileqq/mini/zxing/Binarizer;)V
    //   219: astore_1
    //   220: new 162	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   227: astore 12
    //   229: aload 12
    //   231: ldc_w 800
    //   234: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 12
    //   240: aload_1
    //   241: invokevirtual 803	com/tencent/mobileqq/mini/zxing/BinaryBitmap:getWidth	()I
    //   244: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 12
    //   250: ldc_w 805
    //   253: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 12
    //   259: aload_1
    //   260: invokevirtual 808	com/tencent/mobileqq/mini/zxing/BinaryBitmap:getHeight	()I
    //   263: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: ldc 174
    //   269: iconst_1
    //   270: aload 12
    //   272: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 454	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload_0
    //   279: getfield 721	com/tencent/qqmini/proxyimpl/ChannelProxyImpl:jdField_a_of_type_ComTencentMobileqqMiniZxingMultiFormatReader	Lcom/tencent/mobileqq/mini/zxing/MultiFormatReader;
    //   282: aload_1
    //   283: invokevirtual 812	com/tencent/mobileqq/mini/zxing/MultiFormatReader:decodeWithState	(Lcom/tencent/mobileqq/mini/zxing/BinaryBitmap;)Lcom/tencent/mobileqq/mini/zxing/Result;
    //   286: astore_1
    //   287: aload_0
    //   288: getfield 721	com/tencent/qqmini/proxyimpl/ChannelProxyImpl:jdField_a_of_type_ComTencentMobileqqMiniZxingMultiFormatReader	Lcom/tencent/mobileqq/mini/zxing/MultiFormatReader;
    //   291: invokevirtual 815	com/tencent/mobileqq/mini/zxing/MultiFormatReader:reset	()V
    //   294: goto +27 -> 321
    //   297: astore_1
    //   298: goto +128 -> 426
    //   301: astore_1
    //   302: ldc 174
    //   304: iconst_1
    //   305: ldc_w 817
    //   308: aload_1
    //   309: invokestatic 819	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   312: aload_0
    //   313: getfield 721	com/tencent/qqmini/proxyimpl/ChannelProxyImpl:jdField_a_of_type_ComTencentMobileqqMiniZxingMultiFormatReader	Lcom/tencent/mobileqq/mini/zxing/MultiFormatReader;
    //   316: invokevirtual 815	com/tencent/mobileqq/mini/zxing/MultiFormatReader:reset	()V
    //   319: aconst_null
    //   320: astore_1
    //   321: aload_1
    //   322: ifnull +102 -> 424
    //   325: invokestatic 719	java/lang/System:nanoTime	()J
    //   328: lstore 10
    //   330: aload_1
    //   331: invokevirtual 824	com/tencent/mobileqq/mini/zxing/Result:getText	()Ljava/lang/String;
    //   334: astore 12
    //   336: new 162	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   343: astore 13
    //   345: aload 13
    //   347: ldc_w 826
    //   350: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 13
    //   356: getstatic 829	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   359: lload 10
    //   361: lload 8
    //   363: lsub
    //   364: invokevirtual 832	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   367: invokevirtual 835	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 13
    //   373: ldc_w 837
    //   376: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload 13
    //   382: aload 12
    //   384: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload 13
    //   390: ldc_w 839
    //   393: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 13
    //   399: aload_1
    //   400: invokevirtual 843	com/tencent/mobileqq/mini/zxing/Result:getBarcodeFormat	()Lcom/tencent/mobileqq/mini/zxing/BarcodeFormat;
    //   403: invokevirtual 845	com/tencent/mobileqq/mini/zxing/BarcodeFormat:name	()Ljava/lang/String;
    //   406: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: ldc 174
    //   412: aload 13
    //   414: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 848	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   420: pop
    //   421: aload 12
    //   423: areturn
    //   424: aconst_null
    //   425: areturn
    //   426: aload_0
    //   427: getfield 721	com/tencent/qqmini/proxyimpl/ChannelProxyImpl:jdField_a_of_type_ComTencentMobileqqMiniZxingMultiFormatReader	Lcom/tencent/mobileqq/mini/zxing/MultiFormatReader;
    //   430: invokevirtual 815	com/tencent/mobileqq/mini/zxing/MultiFormatReader:reset	()V
    //   433: aload_1
    //   434: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	ChannelProxyImpl
    //   0	435	1	paramArrayOfByte	byte[]
    //   0	435	2	paramInt1	int
    //   0	435	3	paramInt2	int
    //   0	435	4	paramInt3	int
    //   0	435	5	paramInt4	int
    //   0	435	6	paramInt5	int
    //   0	435	7	paramInt6	int
    //   3	359	8	l1	long
    //   328	32	10	l2	long
    //   30	392	12	localObject1	Object
    //   54	359	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	188	297	finally
    //   188	287	297	finally
    //   302	312	297	finally
    //   5	188	301	java/lang/Exception
    //   188	287	301	java/lang/Exception
  }
  
  public void delPhoneNumber(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().delPhoneNumber(paramString1, paramString2, a(paramAsyncResult));
  }
  
  public void doGameRaffle(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().doGameRaffle(paramString1, paramString2, a(paramAsyncResult));
  }
  
  public void downloadQQBrowser(String paramString) {}
  
  public void ffmpegExecCommand(String[] paramArrayOfString, ChannelProxy.ICommandListenr paramICommandListenr)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg == null) {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
      }
      this.jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg.execute(paramArrayOfString, new ChannelProxyImpl.14(this, paramICommandListenr));
      return;
    }
    catch (FFmpegCommandAlreadyRunningException paramArrayOfString)
    {
      Log.e("ChannelProxyImpl", "run: ", paramArrayOfString);
      if (paramICommandListenr != null) {
        paramICommandListenr.onFailure("FFmpegCommandAlreadyRunningException");
      }
    }
  }
  
  public void getAppInfoById(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByIdForSDK(null, paramString1, paramString2, paramString3, a(paramAsyncResult));
  }
  
  public void getAppInfoById(String paramString1, String paramString2, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByIdForSDK(null, paramString1, paramString2, paramString3, paramString4, a(paramAsyncResult));
  }
  
  public void getAppInfoByLink(String paramString, int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByLinkForSDK(paramString, paramInt, a(paramAsyncResult));
  }
  
  public void getAuthList(String paramString, ChannelProxy.AuthListResult paramAuthListResult)
  {
    MiniAppCmdUtil.getInstance().getAuthList(null, paramString, new ChannelProxyImpl.1(this, paramAuthListResult));
  }
  
  public void getAuthListForSubscribe(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getAuthList(null, paramString, a(paramAsyncResult));
  }
  
  public JSONArray getChooseMessageTempFilesArray(Intent paramIntent)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramIntent != null) {
      try
      {
        paramIntent = paramIntent.getParcelableArrayListExtra("reslut_select_file_info_list");
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            FileInfo localFileInfo = (FileInfo)paramIntent.next();
            if (localFileInfo != null)
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("path", localFileInfo.c());
              localJSONObject.put("size", localFileInfo.a());
              localJSONObject.put("name", localFileInfo.d());
              localJSONObject.put("type", a(localFileInfo.a()));
              localJSONObject.put("time", localFileInfo.b());
              localJSONArray.put(localJSONObject);
            }
          }
          paramIntent = new StringBuilder();
          paramIntent.append("tempFiles : ");
          paramIntent.append(localJSONArray.toString());
          QLog.i("ChannelProxyImpl", 1, paramIntent.toString());
          return localJSONArray;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("ChannelProxyImpl", 1, "ChooseMessageFile error,", paramIntent);
      }
    }
    return localJSONArray;
  }
  
  public void getContentAccelerate(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap, AsyncResult paramAsyncResult) {}
  
  public String getDeviceInfo()
  {
    return PlatformInfor.g().getDeviceInfor();
  }
  
  public IFlutterProxy getFlutterProxy()
  {
    return new ChannelProxyImpl.12(this);
  }
  
  public void getFormId(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getFormId(paramString, a(paramAsyncResult));
  }
  
  public void getFriendCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getFriendCloudStorage(paramString, paramArrayOfString, a(paramAsyncResult));
  }
  
  public void getGameRaffleMaterial(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getGameRaffleMaterial(paramString1, paramString2, a(paramAsyncResult));
  }
  
  public void getGdtAd(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult) {}
  
  public void getGdtAdInfo(String paramString1, int paramInt, String paramString2, AsyncResult paramAsyncResult) {}
  
  public Drawable getGifDrawable(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppLoaderFactory.g().getContext().getFilesDir().getPath());
    ((StringBuilder)localObject).append("/mini/gif/");
    ((StringBuilder)localObject).append(paramString.hashCode());
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists())
    {
      paramString = VasApngUtil.getApngDrawable((String)localObject, paramString, null, new int[] { 32 }, "-MINI-APP-", null);
      AppBrandTask.runTaskOnUiThreadDelay(new ChannelProxyImpl.16(this, paramString), 500L);
      return paramString;
    }
    MiniappDownloadUtil.getInstance().download(paramString, (String)localObject, false, null, Downloader.DownloadMode.OkHttpMode, null);
    return null;
  }
  
  public void getGroupAppStatus(IMiniAppContext paramIMiniAppContext, String paramString, AsyncResult paramAsyncResult)
  {
    QLog.d("ChannelProxyImpl", 1, "getGroupAppStatus");
    if (paramIMiniAppContext == null)
    {
      QLog.e("ChannelProxyImpl", 1, "getGroupAppStatus, miniAppContext=null");
      paramAsyncResult.onReceiveResult(false, null);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).optString("entryDataHash");
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramIMiniAppContext.getMiniAppInfo().launchParam.entryModel.getEntryHash())))
      {
        if (paramIMiniAppContext.getMiniAppInfo().launchParam.entryModel.isAdmin)
        {
          TroopApplicationListUtil.getGroupAppStatus(String.valueOf(paramIMiniAppContext.getMiniAppInfo().launchParam.entryModel.uin), paramIMiniAppContext.getMiniAppInfo().appId, paramAsyncResult);
          return;
        }
        QLog.e("ChannelProxyImpl", 1, "you are not group administrator");
        paramAsyncResult.onReceiveResult(false, null);
        return;
      }
      QLog.e("ChannelProxyImpl", 1, "entryDataHash is not valid or you are not group administrator");
      paramAsyncResult.onReceiveResult(false, null);
      return;
    }
    catch (Exception paramIMiniAppContext)
    {
      paramString = new StringBuilder();
      paramString.append("getGroupAppStatus, exception: ");
      paramString.append(Log.getStackTraceString(paramIMiniAppContext));
      QLog.e("ChannelProxyImpl", 1, paramString.toString());
      paramAsyncResult.onReceiveResult(false, null);
    }
  }
  
  public void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getGroupCloudStorage(paramString1, paramString2, paramArrayOfString, a(paramAsyncResult));
  }
  
  public void getGroupShareInfo(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getGroupShareInfo(paramString1, paramString2, null, a(paramAsyncResult));
  }
  
  public IMediaPlayer getMediaPlayer()
  {
    if (!PlayerConfig.hasInit())
    {
      Context localContext = AppLoaderFactory.g().getContext();
      if (localContext != null)
      {
        PlayerConfig.init(localContext);
        PlayerConfig.g().setLogger(new EmbeddedVideoLogger());
      }
      else
      {
        throw new RuntimeException("BaseApplicationImpl ctx is null");
      }
    }
    if (!VideoManager.hasInit()) {
      VideoManager.init(AppLoaderFactory.g().getContext());
    }
    a(AppLoaderFactory.g().getContext());
    return new MediaPlayerImpl();
  }
  
  public IMediaPlayerUtil getMediaPlayerUtil()
  {
    return new ChannelProxyImpl.11(this);
  }
  
  public void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null, a(paramAsyncResult));
  }
  
  public MiniAIOEntranceProxy getMiniAIOEntranceView(Context paramContext, String paramString)
  {
    paramContext = new MiniAIOEntryView(paramContext, paramString);
    paramContext.setMiniAIOStyle(paramString);
    return paramContext;
  }
  
  public void getMiniAppStoreAppList(int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getMiniAppStoreAppList(paramInt, a(paramAsyncResult));
  }
  
  public void getNativeAppInfoForJump(String paramString1, String paramString2, String paramString3, int paramInt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getNativeAppInfoForJump(null, paramString1, paramString2, paramString3, paramInt, a(paramAsyncResult));
  }
  
  public void getPhoneNumber(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getPhoneNumber(paramString, a(paramAsyncResult));
  }
  
  public void getPotentialFriendList(COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getPotentialFriendList(paramStCommonExt, paramString, a(paramAsyncResult));
  }
  
  public void getRobotUin(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getRobotUin(paramString, a(paramAsyncResult));
  }
  
  public void getSDKOpenKeyToken(COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult) {}
  
  public long getServerTime()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void getShareInfo(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getShareInfo(paramStAdaptShareInfoReq, a(paramAsyncResult));
  }
  
  public void getTcbTicket(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getTcbTicket(paramString1, null, paramString2, a(paramAsyncResult));
  }
  
  public ChannelProxy.SoLoaderOption getTissueSoLoaderOption()
  {
    return null;
  }
  
  public void getUserAppInfo(COMM.StCommonExt paramStCommonExt, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult) {}
  
  public void getUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserCloudStorage(paramString, paramArrayOfString, a(paramAsyncResult));
  }
  
  public void getUserGroupInfo(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, long paramLong, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserGroupInfo(paramStCommonExt, paramString1, paramString2, paramLong, a(paramAsyncResult));
  }
  
  public void getUserHealthData(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserHealthData(paramString, null, a(paramAsyncResult));
  }
  
  public void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInfo(paramString1, paramBoolean, paramString2, a(paramAsyncResult));
  }
  
  public void getUserInfoExtra(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInfoExtra(paramString, a(paramAsyncResult));
  }
  
  public void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInfoOpenData(paramString1, paramString2, paramArrayOfString, a(paramAsyncResult));
  }
  
  public void getUserInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserInteractiveStorage(paramStCommonExt, paramString, paramArrayOfString, a(paramAsyncResult));
  }
  
  public void getUserSetting(String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getUserSetting(paramString1, paramString2, paramString3, paramArrayList, a(paramAsyncResult));
  }
  
  public String getUserTheme()
  {
    String str2 = ThemeUtil.getUserCurrentThemeId(BaseApplicationImpl.getApplication().getRuntime());
    boolean bool = "1000".equals(str2);
    String str1 = "light";
    if (bool) {
      return "light";
    }
    if ("1103".equals(str2)) {
      str1 = "dark";
    }
    return str1;
  }
  
  public AbsVideoPlayer getVideoPlayer()
  {
    if (b) {
      return new AbsVideoPlayerSuperImpl();
    }
    return new AbsVideoPlayerImpl();
  }
  
  public void httpReport(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("data")))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (ReportHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.REPORT_HANDLER);
        if (localObject != null) {
          ((ReportHandler)localObject).a(paramBundle);
        }
      }
    }
  }
  
  public void insertBookShelf(String paramString1, String paramString2, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().insertBookShelf(paramString1, paramString2, paramArrayList, a(paramAsyncResult));
  }
  
  public boolean isGooglePlayVersion()
  {
    return false;
  }
  
  public void judgeTiming(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, String paramString2, int paramInt5, String paramString3, int paramInt6, COMM.StCommonExt paramStCommonExt, String paramString4, String paramString5, AsyncResult paramAsyncResult)
  {
    paramString4 = new INTERFACE.StJudgeTimingReq();
    paramString4.appid.set(paramString1);
    paramString4.appType.set(paramInt1);
    paramString4.scene.set(paramInt2);
    paramString4.factType.set(paramInt3);
    paramString4.reportTime.set(paramLong);
    paramString4.totalTime.set(paramInt4);
    paramString4.launchId.set(paramString2);
    paramString4.afterCertify.set(paramInt5);
    paramString4.via.set(paramString3);
    paramString4.AdsTotalTime.set(paramInt6);
    paramString4.sourceID.set(paramString5);
    if (paramStCommonExt != null) {
      paramString4.extInfo.set(paramStCommonExt);
    }
    MiniAppSSOCmdHelper.sendSSOCmdRequest("LightAppSvc.mini_app_growguard.JudgeTiming", paramString1, paramString4, INTERFACE.StJudgeTimingRsp.class, new ChannelProxyImpl.2(this, paramAsyncResult));
  }
  
  public boolean jump2PublicAccount(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramContext, ChatActivity.class));
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("chat_subType", 2);
    localIntent.putExtra("uinname", paramString2);
    localIntent.setFlags(67108864);
    return true;
  }
  
  public void launchAddPhoneNumberFragment(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivityForMini.class, AddPhoneNumberFragment.class, paramInt);
  }
  
  public void launchPhoneNumberManagementFragment(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivityForMini.class, PhoneNumberManagementFragment.class, paramInt);
  }
  
  public void launchSubMsgPermissionSettingFragment(Activity paramActivity, Intent paramIntent, int paramInt) {}
  
  public void login(String paramString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getLoginCode(paramString, a(paramAsyncResult));
  }
  
  public void modifyFriendInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, boolean paramBoolean, CloudStorage.StInteractiveTemplate paramStInteractiveTemplate, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().modifyFriendInteractiveStorage(paramStCommonExt, paramString1, paramString2, paramString3, paramInt, paramString4, paramHashMap, paramBoolean, paramStInteractiveTemplate, a(paramAsyncResult));
  }
  
  public boolean openGroup(Context paramContext, String paramString, AsyncResult paramAsyncResult)
  {
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      paramContext = new Intent(paramContext, QQBrowserActivity.class);
      paramContext.putExtra("url", paramString);
      paramString = new Bundle();
      paramString.putBoolean("hide_more_button", true);
      paramContext.putExtras(paramString);
      paramString = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
      paramString.addActivityResultListener(new ChannelProxyImpl.7(this, paramString, paramAsyncResult));
      localActivity.startActivityForResult(paramContext, 9);
      return true;
    }
    return false;
  }
  
  public boolean openPermissionSettingsActivity(Context paramContext, String paramString1, String paramString2)
  {
    PermissionSettingFragment.launchForResult((Activity)paramContext, paramString1, paramString2, 5);
    return true;
  }
  
  public boolean openQzonePublish(IMiniAppContext paramIMiniAppContext, Activity paramActivity, String paramString, MiniAppInfo paramMiniAppInfo)
  {
    QLog.i("ChannelProxyImpl", 2, "receive openQzonePublish event");
    paramIMiniAppContext = SharePlugin.a(a(paramIMiniAppContext, paramString));
    if (paramIMiniAppContext != null) {
      a(paramActivity, paramIMiniAppContext, paramMiniAppInfo);
    }
    return true;
  }
  
  public boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2)
  {
    RobotUtils.a(paramContext, paramString1, paramString2);
    return true;
  }
  
  public void queryBookShelf(String paramString, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().queryBookShelf(paramString, paramArrayList, a(paramAsyncResult));
  }
  
  public void queryCurrency(String paramString1, String paramString2, int paramInt1, int paramInt2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().getMidasQueryResult(paramString1, paramString2, paramInt1, paramInt2, null, a(paramAsyncResult));
  }
  
  public void realTimeLogReport(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, ArrayList<RealTimeLogItem> paramArrayList, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().realTimeLogReport(paramString1, paramString2, paramString3, paramArrayOfString, paramArrayList, a(paramAsyncResult));
  }
  
  public void removeUserCloudStorage(String paramString, String[] paramArrayOfString, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().removeUserCloudStorage(paramString, paramArrayOfString, a(paramAsyncResult));
  }
  
  public void report(byte[] paramArrayOfByte, String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil localMiniAppCmdUtil = MiniAppCmdUtil.getInstance();
    paramAsyncResult = a(paramAsyncResult);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LightAppSvc.");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    localMiniAppCmdUtil.performReport(paramArrayOfByte, paramAsyncResult, localStringBuilder.toString());
  }
  
  public void reportBeacon(@NonNull ChannelProxy.BeaconReportCategory paramBeaconReportCategory, @NonNull String paramString, @Nullable Map<String, String> paramMap)
  {
    if (paramBeaconReportCategory == ChannelProxy.BeaconReportCategory.MINI_GAME) {
      MiniGameBeaconReport.report(paramString, paramMap);
    }
  }
  
  public void reportShare(COMM.StCommonExt paramStCommonExt, long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, AsyncResult paramAsyncResult)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      MiniAppCmdUtil.getInstance().reportShare(paramStCommonExt, paramLong, paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, a(paramAsyncResult));
    }
  }
  
  public void sendSmsCodeRequest(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppSendSmsCodeServlet.sendSmsCodeRequest(paramString1, paramString2, new ChannelProxyImpl.4(this, paramAsyncResult));
  }
  
  public void sendVerifySmsCodeRequest(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    MiniAppSendSmsCodeServlet.sendVerifySmsCodeRequest(paramString1, paramString2, paramString3, new ChannelProxyImpl.5(this, paramAsyncResult));
  }
  
  public void setAuth(String paramString, UserAuthInfo paramUserAuthInfo, AsyncResult paramAsyncResult)
  {
    INTERFACE.StUserAuthInfo localStUserAuthInfo = new INTERFACE.StUserAuthInfo();
    localStUserAuthInfo.scope.set(paramUserAuthInfo.scope);
    if (!TextUtils.isEmpty(paramUserAuthInfo.desc)) {
      localStUserAuthInfo.desc.set(paramUserAuthInfo.desc);
    }
    localStUserAuthInfo.authState.set(paramUserAuthInfo.authState);
    MiniAppCmdUtil.getInstance().setAuth(null, paramString, localStUserAuthInfo, a(paramAsyncResult));
  }
  
  public void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().setPersonalizeInfo(paramString1, paramString2, paramInt, paramString3, paramString4, a(paramAsyncResult));
  }
  
  public void setUserAppLike(boolean paramBoolean, COMM.StCommonExt paramStCommonExt, String paramString, AsyncResult paramAsyncResult) {}
  
  public void setUserAppTop(MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult) {}
  
  public void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().setUserCloudStorage(paramString, paramHashMap, a(paramAsyncResult));
  }
  
  public boolean setWebviewCookie(Context paramContext, String paramString)
  {
    Object localObject = MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication());
    boolean bool = TextUtils.isEmpty(MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), (String)localObject));
    int i = 0;
    if (!bool)
    {
      QLog.e("ChannelProxyImpl", 1, "setCookie: forbidToken non-null");
      return false;
    }
    localObject = SwiftBrowserCookieMonster.c(paramString).replace(" ", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((Build.VERSION.SDK_INT < 21) && (paramContext != null)) {
        CookieSyncManager.createInstance(paramContext);
      }
      paramContext = CookieManager.getInstance();
      paramContext.setAcceptCookie(true);
      localObject = ((String)localObject).split(";");
      int j = localObject.length;
      while (i < j)
      {
        String str = localObject[i];
        paramContext.setCookie(Uri.parse(paramString).getHost(), str);
        i += 1;
      }
    }
    try
    {
      CookieSyncManager.getInstance().sync();
      return true;
    }
    catch (Exception paramContext) {}
    return true;
  }
  
  public void springHbReport(String paramString1, int paramInt1, int paramInt2, Map<String, String> paramMap, String paramString2)
  {
    SpringHbReporter.a(paramString1, paramInt1, paramInt2, paramMap, paramString2);
  }
  
  public boolean startAddFriendActivity(Context paramContext, String paramString1, String paramString2)
  {
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).setsOpenId(paramString1);
    paramString1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramContext, 3, paramString2, paramString1, 3024, Integer.parseInt(paramString1), null, null, null, "", null);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramContext, paramString1);
    return true;
  }
  
  public boolean startBrowserSupportHeaderActivityForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("big_brother_source_key", "biz_src_miniapp");
    localIntent.setComponent(new ComponentName(paramActivity, QQBrowserActivity.class));
    localIntent.putExtra("fragmentClass", MiniAppWebviewFragment.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public boolean startChooseMessageFileActivityForResult(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).fileChooseLaunchForResult(paramActivity, paramInt2, paramInt1, new ArrayList(Arrays.asList(new String[] { paramString })));
    return true;
  }
  
  public void startDownloadX5(IMiniAppContext paramIMiniAppContext)
  {
    X5UpdateGuard.a().a(paramIMiniAppContext);
  }
  
  public boolean startRedpacketTranslucentBrowserActivityForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("fragmentClass", RedpacketTranslucentBrowserFragment.class);
    boolean bool = paramBundle.getBoolean("mini_game_orientation");
    paramString = new StringBuilder();
    paramString.append("mini_game_orientation =");
    paramString.append(bool);
    QLog.d("ChannelProxyImpl", 1, paramString.toString());
    paramBundle.putBoolean("isLandScape", bool);
    localIntent.putExtras(paramBundle);
    if (paramActivity != null)
    {
      paramActivity.startActivityForResult(localIntent, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean startTransparentBrowserActivityForResult(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramBundle.putBoolean("hide_left_button", true);
    paramBundle.putBoolean("hide_more_button", true);
    localIntent.putExtras(paramBundle);
    if (paramActivity != null)
    {
      paramActivity.startActivityForResult(localIntent, paramInt);
      return true;
    }
    return false;
  }
  
  public void syncForceGroundAndRefreshBadge(Activity paramActivity, String paramString1, String paramString2)
  {
    ThreadManagerV2.excute(new ChannelProxyImpl.13(this, paramActivity, paramString1, paramString2), 16, null, true);
  }
  
  public boolean tianshuReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    TianShuManager.getInstance().report(a(paramAdItem, paramString, paramInt));
    return true;
  }
  
  public boolean tianshuRequestAdv(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, AsyncResult paramAsyncResult)
  {
    paramContext = new TianShuAdPosItemData();
    paramContext.jdField_a_of_type_Int = paramInt2;
    paramContext.b = paramInt3;
    paramContext.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    paramString = new JSONArray();
    paramString.put(String.valueOf(paramInt1));
    try
    {
      localJSONObject.put("Appid", localJSONArray);
      localJSONObject.put("Refer", paramString);
      paramContext.jdField_a_of_type_JavaUtilHashMap.put("FilterInfo", localJSONObject.toString());
    }
    catch (JSONException paramString)
    {
      QLog.e("ChannelProxyImpl", 1, "put extra data exception", paramString);
    }
    MiniTianShuManager.requestAdv(Collections.singletonList(paramContext), new ChannelProxyImpl.6(this, paramAsyncResult));
    return true;
  }
  
  public void transForRoomId(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().transForRoomId(paramString1, paramString2, a(paramAsyncResult));
  }
  
  public boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, AsyncResult paramAsyncResult)
  {
    return MiniAppCmdUtil.getInstance().updateBaseLibForSDK(paramString, paramBoolean1, paramBoolean2, a(paramAsyncResult));
  }
  
  public void updateBookshelfReadtime(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().updateBookshelfReadtime(paramString1, paramString2, paramString3, a(paramAsyncResult));
  }
  
  public boolean updateEntryList(String paramString)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data", paramString);
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "update_entry_list", localBundle, null);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("ChannelProxyImpl", 1, paramString, new Object[0]);
      paramString.printStackTrace();
    }
    return true;
  }
  
  public void updateTouchInfoList(ArrayList<TouchInfo> paramArrayList)
  {
    jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void updateUserSetting(String paramString, INTERFACE.StUserSettingInfo paramStUserSettingInfo, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().updateUserSetting(null, paramString, paramStUserSettingInfo, a(paramAsyncResult));
  }
  
  public void uploadUserLog(String paramString)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("appid", paramString);
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "upload_user_log", localBundle, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ChannelProxyImpl", 1, paramString, new Object[0]);
      paramString.printStackTrace();
    }
  }
  
  public void useUserApp(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, COMM.StCommonExt paramStCommonExt, AsyncResult paramAsyncResult)
  {
    MiniAppCmdUtil.getInstance().useUserApp(paramString1, paramInt1, paramInt2, paramString2, paramString3, paramStCommonExt, a(paramAsyncResult));
  }
  
  public void verifyPlugin(String paramString, ArrayList<com.tencent.qqmini.sdk.launcher.model.PluginInfo> paramArrayList, AsyncResult paramAsyncResult)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.tencent.qqmini.sdk.launcher.model.PluginInfo localPluginInfo = (com.tencent.qqmini.sdk.launcher.model.PluginInfo)paramArrayList.next();
      com.tencent.mobileqq.mini.apkg.PluginInfo localPluginInfo1 = new com.tencent.mobileqq.mini.apkg.PluginInfo();
      localPluginInfo1.setInnerVersion(localPluginInfo.getInnerVersion());
      localPluginInfo1.setPluginId(localPluginInfo.getPluginId());
      localArrayList.add(localPluginInfo1);
    }
    MiniAppCmdUtil.getInstance().verifyPlugin(paramString, localArrayList, a(paramAsyncResult));
  }
  
  public boolean wnsCgiRequest(JSONObject paramJSONObject, AsyncResult paramAsyncResult)
  {
    return MiniAppUtils.performWnsCgiRequest(paramJSONObject, paramAsyncResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl
 * JD-Core Version:    0.7.0.1
 */