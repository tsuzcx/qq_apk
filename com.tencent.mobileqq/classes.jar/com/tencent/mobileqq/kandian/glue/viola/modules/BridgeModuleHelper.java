package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationReadInJoy;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationReadInJoy;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.account.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.comment.WebCommentEditorHandler;
import com.tencent.mobileqq.kandian.biz.comment.WebCommentEditorHandler.OpenEditorParams;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJUGCDianDian;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion;
import com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyMessagesActivity;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.mobileqq.kandian.biz.ugc.api.impl.RIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.impl.ReadInJoyCaptureLauncher;
import com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.mobileqq.kandian.biz.video.api.impl.VideoFeedsWeiShiUtils;
import com.tencent.mobileqq.kandian.biz.viola.api.OnTitleChangeListener;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ui.ComponentAdapter;
import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AccountProfileInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCPicInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.handler.JumpInfo;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.protofile.cmd0xe36.cmd0xe36.ReqBody;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.util.VersionUtils;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class BridgeModuleHelper
{
  public static void A(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramJSONObject == null) {
        return;
      }
      ReadInJoyUserInfoModule localReadInJoyUserInfoModule = d();
      if (localReadInJoyUserInfoModule == null) {
        return;
      }
      paramJSONObject = paramJSONObject.optJSONArray("uins");
      if (paramJSONObject == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        String str = paramJSONObject.optString(i);
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
      if (localArrayList.isEmpty()) {
        return;
      }
      localReadInJoyUserInfoModule.a(localArrayList, new BridgeModuleHelper.25(localArrayList, paramString, paramBridgeModule));
    }
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 5) {
      return 4;
    }
    if (paramInt == 11) {
      return 5;
    }
    if (paramInt == 6) {
      return 6;
    }
    if (paramInt == 12) {
      return 7;
    }
    if (paramInt == 13) {
      return 8;
    }
    if (paramInt >= 15) {
      return paramInt;
    }
    if (paramInt == 8) {
      return 2;
    }
    return 3;
  }
  
  private static int a(int paramInt, JSONObject paramJSONObject)
  {
    if ((paramInt != 3) && (paramInt != 2))
    {
      if (paramInt != 4)
      {
        if (paramInt == 5) {
          return 2;
        }
        return paramJSONObject.optInt("type");
      }
      return 2;
    }
    return 1;
  }
  
  private static Intent a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, int paramInt3, String paramString5, int paramInt4, Activity paramActivity)
  {
    paramActivity = new Intent(paramActivity, ReadInJoyDeliverBiuActivity.class);
    paramActivity.putExtra("arg_article_info", paramAbsBaseArticleInfo);
    if (!TextUtils.isEmpty(paramString1)) {
      paramActivity.putExtra("biu_rowkey", paramString1);
    }
    paramActivity.putExtra("arg_from_type", paramInt1);
    paramActivity.putExtra("arg_type", paramInt2);
    paramActivity.putExtra("result_js_callback", paramString2);
    paramActivity.putExtra("biu_src", paramInt4);
    paramActivity.putExtra("feed_id", paramString3);
    paramActivity.putExtra("feedsType", paramLong1);
    paramActivity.putExtra("ugc_comment", paramString4);
    paramActivity.putExtra("arg_account_id", paramLong2);
    paramActivity.putExtra("arg_account_type", paramInt3);
    paramActivity.putExtra("arg_source_url", paramString5);
    return paramActivity;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str2 = paramQQAppInterface.getCurrentNickname();
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      str1 = str2;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (PublicAccountInfo)paramQQAppInterface.findPublicAccountInfoCache(paramString);
        str1 = str2;
        if (paramQQAppInterface != null) {
          str1 = paramQQAppInterface.name;
        }
      }
    }
    return str1;
  }
  
  public static String a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject1 != null) {
      paramJSONObject1 = ViolaUtils.getString(paramJSONObject1.opt("toUin"), "");
    } else {
      paramJSONObject1 = "";
    }
    Object localObject = paramJSONObject1;
    if (TextUtils.isEmpty(paramJSONObject1))
    {
      localObject = paramJSONObject1;
      if (paramJSONObject2 != null) {
        localObject = ViolaUtils.getString(paramJSONObject2.opt("toUin"), "");
      }
    }
    return localObject;
  }
  
  public static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = (QQAppInterface)ReadInJoyUtils.b();
    if (localObject2 != null)
    {
      TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject2).getManager(2);
      Object localObject1 = ((QQAppInterface)localObject2).getAccount();
      String str = null;
      if (localTicketManager != null) {
        str = localTicketManager.getSkey(((QQAppInterface)localObject2).getCurrentAccountUin());
      }
      localObject2 = a((QQAppInterface)localObject2, (String)localObject1);
      try
      {
        localJSONObject.put("uin", localObject1);
        localJSONObject.put("skey", str);
        localJSONObject.put("nick", localObject2);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getReportInfo() JSONException");
          ((StringBuilder)localObject1).append(localJSONException.getMessage());
          QLog.e("BridgeModuleHelper", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    return localJSONObject;
  }
  
  private static void a(Activity paramActivity, int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString)
  {
    if (((QQAppInterface)ReadInJoyUtils.b() != null) && (paramActivity != null))
    {
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramActivity, "/base/album/photolist");
      localActivityURIRequest.extra().putInt("enter_from", 25);
      localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationReadInJoy.a);
      localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationReadInJoy.a);
      localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyUploadAvatarFragment.class.getName());
      localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localActivityURIRequest.extra().putBoolean("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
      localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
      localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      localActivityURIRequest.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      localActivityURIRequest.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      localActivityURIRequest.extra().putBoolean("key_from_kandian_uploadimg", true);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject).append("readinjoy_avatar_upload/");
      localObject = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(".jpg");
      localObject = localStringBuilder.toString();
      localActivityURIRequest.extra().putString("PhotoConst.TARGET_PATH", (String)localObject);
      localActivityURIRequest.extra().putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
      localActivityURIRequest.extra().putInt("PhotoConst.CLIP_WIDTH", paramInt3);
      localActivityURIRequest.extra().putInt("PhotoConst.CLIP_HEIGHT", paramInt4);
      localActivityURIRequest.extra().putInt("PhotoConst.TARGET_WIDTH", paramInt5);
      localActivityURIRequest.extra().putInt("PhotoConst.TARGET_HEIGHT", paramInt6);
      localActivityURIRequest.extra().putInt("from", paramInt1);
      localActivityURIRequest.extra().putInt("type", paramInt2);
      localActivityURIRequest.extra().putBoolean("finish", true);
      localActivityURIRequest.extra().putString("callbackId", paramString);
      localActivityURIRequest.setRequestCode(paramByte);
      QRoute.startUri(localActivityURIRequest);
      AlbumUtil.anim(paramActivity, false, true);
    }
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, ReadInJoyMessagesActivity.class);
    localIntent.setFlags(67108864);
    paramContext.startActivity(localIntent);
  }
  
  private static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    RIJJumpUtils.a(paramContext, paramString, paramBundle);
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    boolean bool = paramBundle.containsKey("cmd");
    String str2 = "";
    String str1;
    if (bool) {
      str1 = paramBundle.getString("cmd");
    } else {
      str1 = "";
    }
    if (paramBundle.containsKey("data_error_msg")) {
      str2 = paramBundle.getString("data_error_msg");
    }
    int i = -1;
    if (paramBundle.containsKey("data_error_code")) {
      i = paramBundle.getInt("data_error_code");
    }
    paramBundle = new StringBuilder();
    paramBundle.append("request web sso error, cmd: ");
    paramBundle.append(str1);
    paramBundle.append(", failMsg: ");
    paramBundle.append(str2);
    paramBundle.append(", errorCode: ");
    paramBundle.append(i);
    QLog.e("BridgeModuleHelper", 1, paramBundle.toString());
  }
  
  public static void a(WebSsoBody.WebSsoResponseBody paramWebSsoResponseBody, Bundle paramBundle)
  {
    if (paramWebSsoResponseBody != null)
    {
      if (paramBundle == null) {
        return;
      }
      boolean bool = paramBundle.containsKey("cmd");
      String str = "";
      if (bool) {
        paramBundle = paramBundle.getString("cmd");
      } else {
        paramBundle = "";
      }
      if (paramWebSsoResponseBody.data != null) {
        str = paramWebSsoResponseBody.data.get();
      }
      int i = -1;
      if (paramWebSsoResponseBody.ret != null) {
        i = paramWebSsoResponseBody.ret.get();
      }
      paramWebSsoResponseBody = new StringBuilder();
      paramWebSsoResponseBody.append("request web sso success, cmd: ");
      paramWebSsoResponseBody.append(paramBundle);
      paramWebSsoResponseBody.append(", ret: ");
      paramWebSsoResponseBody.append(i);
      paramWebSsoResponseBody.append(", data: ");
      paramWebSsoResponseBody.append(str);
      QLog.d("BridgeModuleHelper", 2, paramWebSsoResponseBody.toString());
    }
  }
  
  public static void a(BridgeModule paramBridgeModule)
  {
    if ((paramBridgeModule.getViolaInstance() != null) && ((paramBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment))) {
      ((ViolaFragment)paramBridgeModule.getViolaInstance().getFragment()).disableSwitcher();
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getStringExtra("arg_callback");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    Object localObject;
    if (paramInt2 == -1)
    {
      paramIntent = paramIntent.getStringExtra("arg_result_json");
      if (paramIntent == null) {
        return;
      }
      try
      {
        paramIntent = new JSONObject(paramIntent);
        paramIntent.put("retCode", 0);
        localObject = paramIntent.toString();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(b(paramInt1));
          localStringBuilder.append(" result:");
          localStringBuilder.append(RIJDeliverUGCUtils.INSTANCE.replaceUrlInLog((String)localObject));
          QLog.d("BridgeModuleHelper", 2, localStringBuilder.toString());
        }
        paramBridgeModule.invokeCallJS(str, paramIntent);
        return;
      }
      catch (Exception paramBridgeModule)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("callJsDeliverResult error:");
        paramIntent.append(paramBridgeModule.getMessage());
        QLog.e("BridgeModuleHelper", 2, paramIntent.toString());
        return;
      }
    }
    try
    {
      paramIntent = new JSONObject();
      paramIntent.put("retCode", paramInt2);
      paramIntent = paramIntent.toString();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(b(paramInt1));
        ((StringBuilder)localObject).append(" result:");
        ((StringBuilder)localObject).append(paramIntent);
        QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject).toString());
      }
      paramBridgeModule.invokeErrorCallJS(str, "result not ok");
      return;
    }
    catch (Exception paramBridgeModule)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("callJsDeliverResult fail error:");
      paramIntent.append(paramBridgeModule.getMessage());
      QLog.e("BridgeModuleHelper", 2, paramIntent.toString());
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, int paramInt, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("arg_callback");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    paramIntent = paramIntent.getExtras();
    long l1 = paramIntent.getLong("duration_time");
    long l2 = paramIntent.getLong("elapsed_time");
    boolean bool1 = paramIntent.getBoolean("profitable_flag", false);
    boolean bool2 = paramIntent.getBoolean("is_end", false);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("motiveResult: durationTime = ");
      paramIntent.append(l1);
      paramIntent.append("elaspedTime = ");
      paramIntent.append(l2);
      paramIntent.append("profitable =");
      paramIntent.append(bool1);
      QLog.d("BridgeModuleHelper", 2, paramIntent.toString());
    }
    paramIntent = new JSONObject();
    if (paramInt == -1) {}
    try
    {
      paramIntent.put("retCode", 0);
      break label162;
      paramIntent.put("retCode", -1);
      label162:
      paramIntent.put("elapsedTime", l2);
      paramIntent.put("totalTime", l1);
      paramIntent.put("profitable", bool1);
      paramIntent.put("isEnd", bool2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    paramBridgeModule.invokeCallJS(str, paramIntent);
  }
  
  public static void a(BridgeModule paramBridgeModule, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (e() == null) {
        return;
      }
      String str = paramIntent.getStringExtra("arg_callback");
      if (TextUtils.isEmpty(str)) {
        return;
      }
      int i = paramIntent.getIntExtra("result_code", -1);
      if (i == 0)
      {
        if (Looper.myLooper() == null) {
          Looper.prepare();
        }
        new Handler(e().getMainLooper()).postDelayed(new BridgeModuleHelper.24(), 200L);
      }
      if (paramIntent.hasExtra("result_msg")) {
        paramIntent = paramIntent.getStringExtra("result_msg");
      } else {
        paramIntent = "";
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("retCode", i);
        localJSONObject.put("msg", paramIntent);
        paramBridgeModule.invokeCallJS(str, localJSONObject);
        return;
      }
      catch (JSONException paramBridgeModule)
      {
        paramBridgeModule.printStackTrace();
      }
    }
  }
  
  @VisibleForTesting
  protected static void a(@NotNull BridgeModule paramBridgeModule, Bundle paramBundle)
  {
    paramBridgeModule = paramBridgeModule.getViolaInstance().getActivity();
    if (paramBridgeModule != null)
    {
      Intent localIntent = new Intent(paramBridgeModule, TroopAvatarWallPreviewActivity.class);
      localIntent.putExtras(paramBundle);
      paramBridgeModule.startActivity(localIntent);
      return;
    }
    QLog.e("BridgeModuleHelper", 1, "showPictureWithSocialBottomBar error, activity == null");
  }
  
  private static void a(BridgeModule paramBridgeModule, SosoLbsInfo paramSosoLbsInfo, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      b(paramBridgeModule, paramSosoLbsInfo, paramString2);
      return;
    }
    d(paramBridgeModule, paramString2, "fail to get locationInfo from cache");
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab())
        {
          i = 1;
          localJSONObject.put("result", i);
          paramBridgeModule.invokeCallJS(paramString, localJSONObject);
          return;
        }
      }
      catch (Exception paramBridgeModule)
      {
        QLog.e("BridgeModuleHelper", 1, "isInkanDianTab exception e = ", paramBridgeModule);
        return;
      }
      int i = 0;
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = DeviceInfoUtil.a(paramActivity);
    String str = DeviceInfoUtil.e();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qqVersion", str);
      localJSONObject.put("qqBuild", paramActivity);
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      paramString = new StringBuilder();
      paramString.append("[getClientInfo]: ");
      paramString.append(paramBridgeModule.getMessage());
      QLog.e("BridgeModuleHelper", 1, paramString.toString());
    }
  }
  
  private static void a(BridgeModule paramBridgeModule, String paramString, File paramFile)
  {
    Bundle localBundle = new Bundle();
    paramFile = new DownloadTask(paramString, paramFile);
    paramFile.u = 60L;
    ((DownloaderFactory)ReadInJoyUtils.b().getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).startDownload(paramFile, new BridgeModuleHelper.8(paramBridgeModule, paramString), localBundle);
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", GalleryReportedUtils.a(paramBridgeModule.getViolaInstance().getActivity()));
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", String.valueOf(RIJQQAppInterfaceUtil.c()));
      localJSONObject.put("rowkey", paramString1);
      if (paramInt1 >= 0) {
        localJSONObject.put("source", String.valueOf(paramInt1));
      }
      localJSONObject.put("version", VideoReporter.a);
      localJSONObject.put("vid", paramString2);
      if (paramBoolean) {
        localJSONObject.put("cancel", "1");
      }
      if (paramInt2 >= 0) {
        localJSONObject.put("sourcefrom", String.valueOf(paramInt2));
      }
      if (paramInt3 >= 0) {
        localJSONObject.put("share_unit", String.valueOf(paramInt3));
      }
      if (paramInt4 == 4) {
        localJSONObject.put("type", 3);
      } else if (paramInt4 == 11) {
        localJSONObject.put("type", 4);
      }
      paramBridgeModule = localJSONObject.toString();
    }
    catch (Exception paramBridgeModule)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("shareReport:");
        paramString1.append(paramBridgeModule.toString());
        QLog.d("BridgeModuleHelper", 2, paramString1.toString());
      }
      paramBridgeModule = "";
    }
    paramBridgeModule = new VideoR5.Builder(paramBridgeModule);
    if (paramInt4 == 4)
    {
      PublicAccountReportUtils.a(null, "", "0X8009546", "0X8009546", 0, 0, "", paramString4, paramString3, paramBridgeModule.b().a(), false);
      return;
    }
    if (paramInt4 == 11) {
      PublicAccountReportUtils.a(null, "", "0X8009546", "0X8009546", 0, 0, "", paramString5, "", paramBridgeModule.b().a(), false);
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString1, String paramString2, String paramString3, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        paramBridgeModule.invokeErrorCallJS(paramString2, HardCodeUtil.a(2131899435));
      }
      return;
    }
    if ((!paramString1.contains("weishi")) && (!paramString1.contains("weishi://feed")))
    {
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).launch(paramActivity, paramString1))
      {
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.VIEW");
        String str = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          str = RIJJumpUtils.a(0);
        }
        localIntent.putExtra("big_brother_source_key", str);
        localIntent.putExtra("big_brother_ref_source_key", RIJJumpUtils.a(0));
        localIntent.setData(Uri.parse(paramString1));
        paramActivity.startActivity(localIntent);
      }
    }
    else if (WeishiGuideUtils.a(paramActivity))
    {
      VideoFeedsWeiShiUtils.a(paramActivity, "video_type_videopublic");
    }
    else
    {
      QQToast.makeText(paramActivity, -1, HardCodeUtil.a(2131899441), 0).show(paramActivity.getResources().getDimensionPixelSize(2131299920));
      VideoFeedsWeiShiUtils.b(paramActivity, "video_type_videopublic");
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramBridgeModule.invokeCallJS(paramString2, null);
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString1, String paramString2, boolean paramBoolean, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    boolean bool;
    if ((!"weishi://feed".equals(paramString1)) && (!"weishi".equals(paramString1))) {
      bool = PackageUtil.a(paramActivity, paramString1);
    } else {
      bool = WeishiGuideUtils.a(paramActivity);
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject();
        if (bool)
        {
          i = 1;
          paramString1.put("result", i);
          if (paramBoolean)
          {
            paramBridgeModule.invokeCallJS(paramString2, paramString1);
            return;
          }
          ViolaBridgeManager.getInstance().callbackJavascript(paramBridgeModule.getViolaInstance().getInstanceId(), paramBridgeModule.getModuleName(), "callback", paramString2, paramString1, true);
          return;
        }
      }
      catch (JSONException paramBridgeModule)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("hasApp error");
          paramString1.append(paramBridgeModule.getMessage());
          QLog.e("BridgeModuleHelper", 2, paramString1.toString());
        }
        return;
      }
      int i = 0;
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString, JSONObject paramJSONObject)
  {
    Activity localActivity = e();
    paramBridgeModule = new BridgeModuleHelper.18(paramBridgeModule, paramString);
    if (localActivity == null)
    {
      paramBridgeModule.a(null, new GdtAdError(5));
      return;
    }
    paramString = paramJSONObject.optString("posId", "1041305064862972");
    long l1 = paramJSONObject.optLong("publicId", 0L);
    long l2 = paramJSONObject.optLong("articleId", 0L);
    int i = paramJSONObject.optInt("sourceFrom", 0);
    int j = paramJSONObject.optInt("shareRate", 0);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).getMotiveAd(localActivity, paramString, l1, l2, i, j, paramBridgeModule);
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString, JSONObject paramJSONObject, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("res", 1);
      paramJSONObject = paramJSONObject.optString("miniAppUrl");
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramActivity, paramJSONObject, 2103, null))
      {
        localJSONObject.put("res", 0);
        paramBridgeModule.invokeCallJS(paramString, localJSONObject);
        return;
      }
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label81:
      break label81;
    }
    paramBridgeModule.invokeCallJS(paramString, localJSONObject);
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    QLog.d("BridgeModuleHelper", 2, "getGdtDeviceInfo callback before");
    AdThreadManager.INSTANCE.post(new BridgeModuleHelper.17(paramJSONObject, paramBoolean, paramBridgeModule, paramString), 4);
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      JSONObject localJSONObject = a();
      if (paramBoolean)
      {
        paramBridgeModule.invokeCallJS(paramString, localJSONObject);
        return;
      }
      ViolaBridgeManager.getInstance().callbackJavascript(paramBridgeModule.getViolaInstance().getInstanceId(), paramBridgeModule.getModuleName(), "callback", paramString, localJSONObject, true);
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = paramJSONObject.optJSONArray("imageIDs");
        int k = paramJSONObject.optInt("index");
        String str1 = paramJSONObject.optString("srcID");
        boolean bool1 = paramJSONObject.optBoolean("isNotShowIndex", true);
        boolean bool2 = paramJSONObject.optBoolean("showTitle", false);
        String str2 = new String(Base64Util.decode(paramJSONObject.optString("title", ""), 0));
        String str3 = paramJSONObject.optString("articleUrl", "");
        boolean bool3 = paramJSONObject.optBoolean("isReport", false);
        long l1 = paramJSONObject.optLong("touin");
        long l2 = paramJSONObject.optLong("feeds_id");
        int m = paramJSONObject.optInt("feeds_type");
        long l3 = paramJSONObject.optLong("articleId");
        int n = paramJSONObject.optInt("source");
        if (localObject2 == null) {
          break label649;
        }
        i = ((JSONArray)localObject2).length();
        if (!Boolean.valueOf(bool3).booleanValue()) {
          break label654;
        }
        Object localObject1 = new PublicAccountShowPictureReport();
        ((PublicAccountShowPictureReport)localObject1).parse(paramJSONObject);
        paramJSONObject = (JSONObject)localObject1;
        bool3 = QLog.isColorLevel();
        if (bool3) {
          QLog.d("BridgeModuleHelper", 2, new Object[] { "KANDIAN Grid Image title: ", str2, ", articleUrl: ", str3, ", showTitle: ", Boolean.valueOf(bool2) });
        }
        if ((localObject2 != null) && (((JSONArray)localObject2).length() != 0))
        {
          localObject1 = new ArrayList();
          int j = 0;
          if (j < ((JSONArray)localObject2).length())
          {
            ((ArrayList)localObject1).add(((JSONArray)localObject2).get(j).toString());
            j += 1;
            continue;
          }
          localObject2 = paramBridgeModule.getViolaInstance().getActivity();
          if (localObject2 != null)
          {
            Intent localIntent = new Intent((Context)localObject2, TroopAvatarWallPreviewActivity.class);
            Bundle localBundle = new Bundle();
            localBundle.putInt("index", k);
            localBundle.putStringArrayList("seqNum", (ArrayList)localObject1);
            localBundle.putBoolean("needBottomBar", false);
            localBundle.putBoolean("IS_EDIT", false);
            localBundle.putBoolean("is_use_path", true);
            localBundle.putBoolean("is_show_action", true);
            localBundle.putBoolean("is_not_show_index", bool1);
            localBundle.putBoolean("is_grid_image_report", true);
            localBundle.putString("to_uin", Long.toString(l1));
            localBundle.putString("feeds_id", Long.toString(l2));
            localBundle.putString("article_id", Long.toString(l3));
            localBundle.putString("scroll_image_r5", RIJTransMergeKanDianReport.a(i, -1, Integer.toString(n), m, "", "", null));
            localBundle.putString("read_article_r5", RIJTransMergeKanDianReport.a(i, -1, Integer.toString(n), m, "", null));
            if (!TextUtils.isEmpty(str1)) {
              localBundle.putString("src_id", str1);
            }
            if ((bool2) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
            {
              localBundle.putBoolean("is_show_content_url", true);
              localBundle.putString("article_url", str3);
              localBundle.putString("article_title", str2);
            }
            if ((paramJSONObject != null) && (paramJSONObject.isReport)) {
              localBundle.putString("PublicAccountShowPictureReport", paramJSONObject.toString());
            }
            localIntent.putExtras(localBundle);
            ((Activity)localObject2).startActivityForResult(localIntent, 100);
            paramBridgeModule.invokeCallJS(paramString, null);
          }
        }
        else
        {
          bool1 = QLog.isColorLevel();
          if (bool1) {
            QLog.d("BridgeModuleHelper", 2, "imageList is null or length is 0");
          }
          paramBridgeModule.invokeErrorCallJS(paramString, "imageList is null or length is 0");
          return;
        }
      }
      catch (Exception paramBridgeModule)
      {
        paramBridgeModule.printStackTrace();
      }
      return;
      label649:
      int i = 0;
      continue;
      label654:
      paramJSONObject = null;
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramBridgeModule.getViolaInstance().getFragment() != null) {
      paramBridgeModule = paramBridgeModule.getViolaInstance().getFragment().getActivity();
    } else {
      paramBridgeModule = paramBridgeModule.getViolaInstance().getActivity();
    }
    if (paramBridgeModule != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      WebCommentEditorHandler.OpenEditorParams localOpenEditorParams = new WebCommentEditorHandler.OpenEditorParams();
      localOpenEditorParams.a = paramBridgeModule;
      localOpenEditorParams.b = paramJSONObject;
      localOpenEditorParams.c = paramInt;
      localOpenEditorParams.d = paramString;
      localOpenEditorParams.e = 126;
      WebCommentEditorHandler.a(localOpenEditorParams);
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    paramJSONObject = paramJSONObject.optString("feedsId");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showVisibleUserList feedsId ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject).toString());
      localObject = new Intent();
      ((Intent)localObject).putExtra("feeds_id", new BigInteger(paramJSONObject).longValue());
      PublicFragmentActivity.a(paramActivity, (Intent)localObject, ReadInJoyPrivacyListFragment.class);
      paramBridgeModule.invokeCallJS(paramString, null);
      return;
    }
    paramBridgeModule.invokeErrorCallJS(paramString, "params error");
  }
  
  public static void a(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString, Fragment paramFragment)
  {
    Object localObject = paramFragment;
    if (paramFragment == null) {
      localObject = paramBridgeModule.getViolaInstance().getFragment();
    }
    if (localObject == null) {
      return;
    }
    paramFragment = null;
    if ((localObject instanceof ViolaFragment)) {
      paramFragment = ((ViolaFragment)localObject).getTtileChangelistener();
    }
    if (paramFragment == null) {
      return;
    }
    localObject = paramJSONObject.optString("position");
    paramJSONObject = paramJSONObject.optString("text");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (((String)localObject).equals("right"))
      {
        paramFragment.a(paramJSONObject, new BridgeModuleHelper.21(paramBridgeModule, paramString));
        return;
      }
      if (((String)localObject).equals("left")) {
        paramFragment.b(paramJSONObject, new BridgeModuleHelper.22(paramBridgeModule, paramString));
      }
    }
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, Intent paramIntent, long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2, BridgeModule paramBridgeModule)
  {
    int i = paramJSONObject.optInt("hiddenBiuComponent");
    boolean bool = true;
    Object localObject;
    if (i == 1) {
      localObject = new String(Base64Util.decode(paramJSONObject.optString("newComment"), 2));
    } else {
      localObject = "";
    }
    if (i == 1)
    {
      paramJSONObject = (JSONObject)localObject;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.a != null)
      {
        paramJSONObject = (JSONObject)localObject;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.a.size() > 0)
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append((String)localObject);
          paramJSONObject.append("//");
          paramJSONObject = paramJSONObject.toString();
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("：");
      ((StringBuilder)localObject).append(paramJSONObject);
      paramJSONObject = ((StringBuilder)localObject).toString();
      localObject = (QQAppInterface)ReadInJoyUtils.b();
      if (localObject != null) {
        ((ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a(RIJQQAppInterfaceUtil.c(), paramLong1, paramAbsBaseArticleInfo.mSocialFeedInfo.n, 0L, paramJSONObject, paramLong2, -1L, paramInt1, paramString, paramInt2, paramAbsBaseArticleInfo);
      }
      paramBridgeModule.onActivityResult(113, -1, paramIntent);
      return;
    }
    if (paramJSONObject.optInt("hideSuccessToast") != 1) {
      bool = false;
    }
    paramIntent.putExtra("hideSuccessToast", bool);
    paramBridgeModule.getActivity().startActivityForResult(paramIntent, 113);
    paramBridgeModule.getActivity().overridePendingTransition(0, 0);
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    paramAbsBaseArticleInfo.mSocialFeedInfo.s = new UGCFeedsInfo();
    a(paramJSONObject, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo.mTitle = new String(Base64Util.decode(paramString1, 0));
    paramAbsBaseArticleInfo.mSummary = "";
    if ((paramInt1 != 3) && (paramInt1 != 2))
    {
      if ((paramInt1 != 4) && (paramInt1 != 5))
      {
        if (paramInt1 == 1) {
          paramAbsBaseArticleInfo.mFirstPagePicUrl = "";
        }
      }
      else
      {
        paramAbsBaseArticleInfo.mSocialFeedInfo.s.c = new ArrayList();
        paramString1 = new UGCVideoInfo();
        paramJSONObject = paramJSONObject.optJSONObject("ugcVideoInfo");
        if (paramJSONObject != null)
        {
          paramString1.d = paramJSONObject.optString("ugcVideoCoverUrl");
          paramString1.g = paramJSONObject.optInt("ugcVideoDuration");
          paramString1.e = paramString2;
          paramAbsBaseArticleInfo.mSocialFeedInfo.s.c.add(paramString1);
        }
      }
    }
    else
    {
      paramAbsBaseArticleInfo.mSocialFeedInfo.s.b = new ArrayList();
      paramString1 = new UGCPicInfo();
      paramJSONObject = paramJSONObject.optJSONArray("ugcPicInfo");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        paramString1.e = paramJSONObject.getJSONObject(0).optString("ugcPicUrl");
        paramAbsBaseArticleInfo.mSocialFeedInfo.s.b.add(paramString1);
      }
    }
    if (paramInt2 == 22)
    {
      paramJSONObject = new AccountProfileInfo();
      paramJSONObject.c = paramString3;
      paramJSONObject.d = paramString4;
      paramJSONObject.e = paramString5;
      paramJSONObject.a = paramLong;
      paramAbsBaseArticleInfo.mSocialFeedInfo.s.k = paramJSONObject;
    }
    paramAbsBaseArticleInfo.mSocialFeedInfo.s.a = paramInt1;
    paramAbsBaseArticleInfo.mSocialFeedInfo.s.f = paramAbsBaseArticleInfo.mTitle;
  }
  
  private static void a(File paramFile, String paramString)
  {
    ThreadManager.executeOnNetWorkThread(new BridgeModuleHelper.23(paramString, paramFile));
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("?client=androidQQ");
      ((StringBuilder)localObject).append("&version=8.8.17.5770");
      paramString = new StringBuilder();
      paramString.append("&system=");
      paramString.append(Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append(paramString.toString());
      paramString = new StringBuilder();
      paramString.append("&device=");
      paramString.append(Build.DEVICE);
      ((StringBuilder)localObject).append(paramString.toString());
      paramString = new StringBuilder();
      paramString.append("&uin=");
      paramString.append(RIJQQAppInterfaceUtil.d());
      ((StringBuilder)localObject).append(paramString.toString());
      paramString = EmosmUtils.a("VIP_xingying", ((StringBuilder)localObject).toString());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveImageToLocal imageUrl=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(".jpg");
      localObject = ((StringBuilder)localObject).toString();
      a(new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE), (String)localObject), paramString);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveImageToLocal imageUrl error=");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.e("BridgeModuleHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static void a(String paramString, Activity paramActivity)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addCategory("android.intent.category.BROWSABLE");
      localIntent.setData(Uri.parse(paramString));
      if (paramActivity != null) {
        paramActivity.startActivity(localIntent);
      }
    }
  }
  
  public static void a(String paramString, Bundle paramBundle, Activity paramActivity)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a(paramActivity, paramString, paramBundle);
    }
  }
  
  /* Error */
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 148
    //   2: astore 6
    //   4: invokestatic 526	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:e	()Landroid/app/Activity;
    //   7: astore 8
    //   9: iconst_0
    //   10: istore_2
    //   11: iconst_0
    //   12: istore 4
    //   14: aload_1
    //   15: ldc_w 1308
    //   18: invokevirtual 70	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   21: istore_3
    //   22: aload_1
    //   23: ldc_w 1310
    //   26: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 5
    //   31: iload 4
    //   33: istore_2
    //   34: aload_1
    //   35: ldc_w 1312
    //   38: iconst_0
    //   39: invokevirtual 871	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   42: istore 4
    //   44: iload 4
    //   46: istore_2
    //   47: aload_1
    //   48: ldc_w 1314
    //   51: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_1
    //   55: iload 4
    //   57: istore_2
    //   58: goto +47 -> 105
    //   61: astore 7
    //   63: aload 5
    //   65: astore_1
    //   66: aload 7
    //   68: astore 5
    //   70: goto +18 -> 88
    //   73: astore 5
    //   75: ldc 148
    //   77: astore_1
    //   78: goto +10 -> 88
    //   81: astore 5
    //   83: ldc 148
    //   85: astore_1
    //   86: iconst_0
    //   87: istore_3
    //   88: ldc 211
    //   90: iconst_1
    //   91: ldc_w 1316
    //   94: aload 5
    //   96: invokestatic 618	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload_1
    //   100: astore 5
    //   102: aload 6
    //   104: astore_1
    //   105: ldc_w 875
    //   108: invokestatic 750	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   111: checkcast 875	com/tencent/mobileqq/kandian/ad/api/IRIJAdService
    //   114: aload 8
    //   116: iload_3
    //   117: aload 5
    //   119: iload_2
    //   120: aload_0
    //   121: aload_1
    //   122: invokeinterface 1320 7 0
    //   127: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	String
    //   0	128	1	paramJSONObject	JSONObject
    //   10	110	2	i	int
    //   21	96	3	j	int
    //   12	44	4	k	int
    //   29	40	5	localObject	Object
    //   73	1	5	localException1	Exception
    //   81	14	5	localException2	Exception
    //   100	18	5	localJSONObject	JSONObject
    //   2	101	6	str	String
    //   61	6	7	localException3	Exception
    //   7	108	8	localActivity	Activity
    // Exception table:
    //   from	to	target	type
    //   34	44	61	java/lang/Exception
    //   47	55	61	java/lang/Exception
    //   22	31	73	java/lang/Exception
    //   14	22	81	java/lang/Exception
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("code");
    Object localObject4 = paramJSONObject.optJSONObject("params");
    if ((!TextUtils.isEmpty(str)) && (localObject4 != null))
    {
      paramJSONObject = ((JSONObject)localObject4).optJSONObject("r2");
      Object localObject1 = ((JSONObject)localObject4).optJSONObject("r3");
      Object localObject2 = ((JSONObject)localObject4).optJSONObject("r4");
      Object localObject3 = ((JSONObject)localObject4).optJSONObject("r5");
      localObject4 = a((JSONObject)localObject4, (JSONObject)localObject3);
      if (paramJSONObject != null) {
        paramJSONObject = paramJSONObject.toString();
      } else {
        paramJSONObject = "";
      }
      if (localObject1 != null) {
        localObject1 = ((JSONObject)localObject1).toString();
      } else {
        localObject1 = "";
      }
      if (localObject2 != null) {
        localObject2 = ((JSONObject)localObject2).toString();
      } else {
        localObject2 = "";
      }
      if (localObject3 != null) {
        localObject3 = ((JSONObject)localObject3).toString();
      } else {
        localObject3 = "";
      }
      PublicAccountReportUtils.a(null, (String)localObject4, str, str, 0, 0, paramJSONObject, (String)localObject1, (String)localObject2, (String)localObject3, false);
    }
  }
  
  public static void a(JSONObject paramJSONObject, Activity paramActivity)
  {
    if (paramActivity != null) {
      ViolaAccessHelper.a(paramActivity, paramJSONObject);
    }
  }
  
  private static void a(JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramJSONObject = paramJSONObject.optJSONArray("ugcAtLevelList");
    if (paramJSONObject != null)
    {
      paramAbsBaseArticleInfo.mSocialFeedInfo.s.h = new BiuInfo();
      paramAbsBaseArticleInfo.mSocialFeedInfo.s.h.a = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        BiuCommentInfo localBiuCommentInfo = new BiuCommentInfo();
        Object localObject = paramJSONObject.getJSONObject(i);
        localBiuCommentInfo.mUin = Long.valueOf(((JSONObject)localObject).optLong("uin"));
        localBiuCommentInfo.mOrigBiuComment = new String(Base64Util.decode(((JSONObject)localObject).optString("comment"), 0));
        localBiuCommentInfo.mBiuComment = localBiuCommentInfo.mOrigBiuComment;
        localBiuCommentInfo.mBiuTime = ((JSONObject)localObject).optInt("biuTime");
        localBiuCommentInfo.mFeedsType = ((JSONObject)localObject).optInt("feeds_type", 1);
        localBiuCommentInfo.mOpType = ((JSONObject)localObject).optInt("op_type");
        String str1 = ((JSONObject)localObject).optString("jumpName");
        String str2 = ((JSONObject)localObject).optString("jumpUrl");
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
          localBiuCommentInfo.jumpInfo = new JumpInfo(0L, new String(Base64Util.decode(str1, 0)), str2);
        }
        try
        {
          localObject = ((JSONObject)localObject).optString("feedsId");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localBiuCommentInfo.mFeedId = Long.valueOf(new BigInteger((String)localObject).longValue());
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        paramAbsBaseArticleInfo.mSocialFeedInfo.s.h.a.add(localBiuCommentInfo);
        i += 1;
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong1, long paramLong2)
  {
    if (paramJSONObject == null) {
      return;
    }
    paramJSONObject = paramJSONObject.getJSONArray("biuLevelList");
    paramAbsBaseArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
    paramAbsBaseArticleInfo.mSocialFeedInfo.n = new BiuInfo();
    paramAbsBaseArticleInfo.mSocialFeedInfo.n.b = Long.valueOf(paramLong1);
    paramAbsBaseArticleInfo.mSocialFeedInfo.n.c = Long.valueOf(paramLong2);
    paramAbsBaseArticleInfo.mSocialFeedInfo.n.a = new ArrayList();
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        BiuCommentInfo localBiuCommentInfo = new BiuCommentInfo();
        Object localObject = paramJSONObject.getJSONObject(i);
        localBiuCommentInfo.mUin = Long.valueOf(((JSONObject)localObject).optLong("uin"));
        localBiuCommentInfo.mOrigBiuComment = new String(Base64Util.decode(((JSONObject)localObject).optString("comment"), 0));
        localBiuCommentInfo.mBiuComment = localBiuCommentInfo.mOrigBiuComment;
        localBiuCommentInfo.mBiuTime = ((JSONObject)localObject).optInt("biuTime");
        localBiuCommentInfo.mFeedsType = ((JSONObject)localObject).optInt("feeds_type", 1);
        localBiuCommentInfo.mOpType = ((JSONObject)localObject).optInt("op_type");
        String str1 = ((JSONObject)localObject).optString("jumpName");
        String str2 = ((JSONObject)localObject).optString("jumpUrl");
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
          localBiuCommentInfo.jumpInfo = new JumpInfo(0L, new String(Base64Util.decode(str1, 0)), str2);
        }
        try
        {
          localObject = ((JSONObject)localObject).optString("feedsId");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localBiuCommentInfo.mFeedId = Long.valueOf(new BigInteger((String)localObject).longValue());
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        paramAbsBaseArticleInfo.mSocialFeedInfo.n.a.add(localBiuCommentInfo);
        i += 1;
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    String str1 = paramJSONObject.optString("topicId");
    Object localObject = paramJSONObject.optString("topicName");
    String str2 = paramJSONObject.optString("cookie");
    int k = 0;
    int i;
    if (paramJSONObject.optInt("isQuestion", 0) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramJSONObject.optInt("isAnswer", 0) == 1) {
      j = 1;
    } else {
      j = 0;
    }
    int m = paramJSONObject.optInt("adtag");
    try
    {
      paramJSONObject = new String(Base64Util.decode((String)localObject, 0));
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      paramJSONObject = (JSONObject)localObject;
    }
    localObject = new Intent(paramActivity, ReadInJoyDeliverUGCActivity.class);
    ((Intent)localObject).putExtra("arg_topic_id", str1);
    if (i == 0)
    {
      i = k;
      if (j == 0) {}
    }
    else
    {
      i = 1;
    }
    ((Intent)localObject).putExtra("support_topic", i ^ 0x1);
    ((Intent)localObject).putExtra("support_linkify", i ^ 0x1);
    ((Intent)localObject).putExtra("arg_topic_name", paramJSONObject);
    ((Intent)localObject).putExtra("arg_ad_tag", m);
    ((Intent)localObject).putExtra("arg_callback", paramString);
    ((Intent)localObject).putExtra("arg_ugc_edit_cookie", str2);
    paramActivity.startActivityForResult((Intent)localObject, 114);
  }
  
  /* Error */
  public static void a(JSONObject paramJSONObject, String paramString, BridgeModule paramBridgeModule)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 1166	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule:getActivity	()Landroid/app/Activity;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: ldc_w 927
    //   12: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 26
    //   17: aload_0
    //   18: ldc_w 1434
    //   21: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 28
    //   26: aload_0
    //   27: ldc_w 1436
    //   30: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 30
    //   35: aload 30
    //   37: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: istore 8
    //   42: iload 8
    //   44: ifeq +10 -> 54
    //   47: ldc 148
    //   49: astore 30
    //   51: goto +3 -> 54
    //   54: lconst_0
    //   55: lstore 15
    //   57: new 688	java/lang/String
    //   60: dup
    //   61: aload 26
    //   63: iconst_0
    //   64: invokestatic 933	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   67: invokespecial 936	java/lang/String:<init>	([B)V
    //   70: astore 25
    //   72: new 688	java/lang/String
    //   75: dup
    //   76: aload 28
    //   78: iconst_0
    //   79: invokestatic 933	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   82: invokespecial 936	java/lang/String:<init>	([B)V
    //   85: astore 27
    //   87: aload_0
    //   88: ldc_w 1068
    //   91: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 29
    //   96: aload_0
    //   97: ldc_w 694
    //   100: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore 31
    //   105: aload 29
    //   107: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +20 -> 130
    //   113: new 1072	java/math/BigInteger
    //   116: dup
    //   117: aload 29
    //   119: invokespecial 1073	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   122: invokevirtual 1076	java/math/BigInteger:longValue	()J
    //   125: lstore 9
    //   127: goto +6 -> 133
    //   130: lconst_0
    //   131: lstore 9
    //   133: aload_0
    //   134: ldc_w 1438
    //   137: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   140: astore 26
    //   142: aload 26
    //   144: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   147: ifne +20 -> 167
    //   150: new 1072	java/math/BigInteger
    //   153: dup
    //   154: aload 26
    //   156: invokespecial 1073	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   159: invokevirtual 1076	java/math/BigInteger:longValue	()J
    //   162: lstore 11
    //   164: goto +6 -> 170
    //   167: lconst_0
    //   168: lstore 11
    //   170: aload_0
    //   171: ldc_w 1440
    //   174: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore 26
    //   179: aload 26
    //   181: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   184: ifne +20 -> 204
    //   187: new 1072	java/math/BigInteger
    //   190: dup
    //   191: aload 26
    //   193: invokespecial 1073	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   196: invokevirtual 1076	java/math/BigInteger:longValue	()J
    //   199: lstore 13
    //   201: goto +6 -> 207
    //   204: lconst_0
    //   205: lstore 13
    //   207: aload_0
    //   208: ldc_w 1442
    //   211: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 26
    //   216: aload 26
    //   218: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: ifne +20 -> 241
    //   224: new 1072	java/math/BigInteger
    //   227: dup
    //   228: aload 26
    //   230: invokespecial 1073	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   233: invokevirtual 1076	java/math/BigInteger:longValue	()J
    //   236: lstore 19
    //   238: goto +6 -> 244
    //   241: lconst_0
    //   242: lstore 19
    //   244: aload_0
    //   245: ldc_w 1444
    //   248: invokevirtual 944	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   251: lstore 17
    //   253: lload 17
    //   255: lstore 15
    //   257: aload_0
    //   258: ldc_w 1446
    //   261: invokevirtual 70	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   264: istore_3
    //   265: aload 27
    //   267: astore 28
    //   269: aload 29
    //   271: astore 26
    //   273: lload 17
    //   275: lstore 15
    //   277: aload 25
    //   279: astore 27
    //   281: lload 19
    //   283: lstore 21
    //   285: aload 31
    //   287: astore 25
    //   289: lload 9
    //   291: lstore 17
    //   293: lload 11
    //   295: lstore 19
    //   297: lload 21
    //   299: lstore 11
    //   301: lload 13
    //   303: lstore 9
    //   305: lload 17
    //   307: lstore 13
    //   309: lload 19
    //   311: lstore 17
    //   313: goto +228 -> 541
    //   316: astore 26
    //   318: lload 11
    //   320: lstore 17
    //   322: lload 15
    //   324: lstore 11
    //   326: aload 27
    //   328: astore 28
    //   330: lload 17
    //   332: lstore 15
    //   334: aload 25
    //   336: astore 27
    //   338: aload 31
    //   340: astore 25
    //   342: lload 9
    //   344: lstore 17
    //   346: lload 11
    //   348: lstore 9
    //   350: lload 19
    //   352: lstore 11
    //   354: goto +148 -> 502
    //   357: astore 26
    //   359: goto +8 -> 367
    //   362: astore 26
    //   364: lconst_0
    //   365: lstore 13
    //   367: lconst_0
    //   368: lstore 19
    //   370: lconst_0
    //   371: lstore 21
    //   373: aload 27
    //   375: astore 28
    //   377: lload 11
    //   379: lstore 15
    //   381: aload 25
    //   383: astore 27
    //   385: aload 31
    //   387: astore 25
    //   389: lload 9
    //   391: lstore 17
    //   393: lload 21
    //   395: lstore 9
    //   397: lload 19
    //   399: lstore 11
    //   401: goto +101 -> 502
    //   404: astore 26
    //   406: goto +8 -> 414
    //   409: astore 26
    //   411: lconst_0
    //   412: lstore 9
    //   414: lconst_0
    //   415: lstore 19
    //   417: lconst_0
    //   418: lstore 13
    //   420: lload 13
    //   422: lstore 11
    //   424: aload 27
    //   426: astore 28
    //   428: aload 25
    //   430: astore 27
    //   432: aload 31
    //   434: astore 25
    //   436: lload 9
    //   438: lstore 17
    //   440: lload 19
    //   442: lstore 9
    //   444: goto +58 -> 502
    //   447: astore 26
    //   449: aload 27
    //   451: astore 28
    //   453: aload 25
    //   455: astore 27
    //   457: goto +22 -> 479
    //   460: astore 26
    //   462: goto +13 -> 475
    //   465: astore 27
    //   467: aload 26
    //   469: astore 25
    //   471: aload 27
    //   473: astore 26
    //   475: aload 25
    //   477: astore 27
    //   479: lconst_0
    //   480: lstore 17
    //   482: lload 17
    //   484: lstore 9
    //   486: lload 9
    //   488: lstore 13
    //   490: lload 13
    //   492: lstore 11
    //   494: ldc 148
    //   496: astore 29
    //   498: aload 29
    //   500: astore 25
    //   502: aload 26
    //   504: invokevirtual 1039	java/lang/Exception:printStackTrace	()V
    //   507: aload 29
    //   509: astore 26
    //   511: iconst_0
    //   512: istore_3
    //   513: lload 15
    //   515: lstore 19
    //   517: lload 17
    //   519: lstore 21
    //   521: lload 13
    //   523: lstore 23
    //   525: lload 9
    //   527: lstore 15
    //   529: lload 19
    //   531: lstore 17
    //   533: lload 21
    //   535: lstore 13
    //   537: lload 23
    //   539: lstore 9
    //   541: aload_0
    //   542: ldc_w 1448
    //   545: lconst_1
    //   546: invokevirtual 865	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   549: lstore 19
    //   551: aload_0
    //   552: ldc 66
    //   554: invokevirtual 70	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   557: istore 4
    //   559: aload_0
    //   560: ldc_w 1417
    //   563: invokevirtual 70	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   566: istore 5
    //   568: aload_0
    //   569: ldc_w 1450
    //   572: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   575: astore 32
    //   577: aload_0
    //   578: ldc_w 1452
    //   581: invokevirtual 70	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   584: istore 7
    //   586: new 688	java/lang/String
    //   589: dup
    //   590: aload_0
    //   591: ldc_w 1454
    //   594: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   597: iconst_0
    //   598: invokestatic 933	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   601: invokespecial 936	java/lang/String:<init>	([B)V
    //   604: astore 33
    //   606: aload_0
    //   607: ldc 104
    //   609: iconst_1
    //   610: invokevirtual 871	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   613: istore 6
    //   615: new 1456	com/tencent/mobileqq/kandian/repo/db/struct/BaseArticleInfo
    //   618: dup
    //   619: invokespecial 1457	com/tencent/mobileqq/kandian/repo/db/struct/BaseArticleInfo:<init>	()V
    //   622: astore 31
    //   624: aload 31
    //   626: lload 17
    //   628: putfield 1460	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleID	J
    //   631: aload 31
    //   633: aload 27
    //   635: putfield 1184	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   638: aload 31
    //   640: aload 28
    //   642: putfield 1463	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   645: aload 31
    //   647: aload 32
    //   649: putfield 1190	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   652: aload 31
    //   654: iload 7
    //   656: putfield 1466	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoDuration	I
    //   659: aload 31
    //   661: lload 13
    //   663: putfield 1468	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedId	J
    //   666: aload 31
    //   668: aload 33
    //   670: putfield 1187	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSummary	Ljava/lang/String;
    //   673: aload 31
    //   675: lload 11
    //   677: putfield 1470	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:businessId	J
    //   680: aload 31
    //   682: iload 6
    //   684: putfield 1473	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedType	I
    //   687: aload 31
    //   689: aload 25
    //   691: putfield 1476	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   694: aload_0
    //   695: aload 31
    //   697: lload 9
    //   699: lload 19
    //   701: invokestatic 1478	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;JJ)V
    //   704: aload_0
    //   705: ldc_w 1480
    //   708: invokevirtual 1202	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   711: astore 34
    //   713: aload 34
    //   715: ifnull +194 -> 909
    //   718: iload 6
    //   720: lload 19
    //   722: invokestatic 1485	com/tencent/mobileqq/kandian/repo/common/RIJItemViewTypeUtils:a	(IJ)Z
    //   725: ifeq +184 -> 909
    //   728: aload 34
    //   730: ldc_w 1487
    //   733: invokevirtual 886	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   736: astore 29
    //   738: aload 34
    //   740: ldc_w 1489
    //   743: iconst_0
    //   744: invokevirtual 871	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   747: istore 4
    //   749: aload 31
    //   751: aload 34
    //   753: aload 29
    //   755: iload 4
    //   757: iload 5
    //   759: aload 27
    //   761: aload 28
    //   763: aload 32
    //   765: aload 33
    //   767: lload 15
    //   769: invokestatic 1491	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;Lorg/json/JSONObject;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   772: iload 4
    //   774: aload_0
    //   775: invokestatic 1493	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(ILorg/json/JSONObject;)I
    //   778: istore 4
    //   780: aload 29
    //   782: astore 27
    //   784: goto +3 -> 787
    //   787: aload 31
    //   789: getfield 1122	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   792: ldc 148
    //   794: putfield 1494	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:e	Ljava/lang/String;
    //   797: aload 31
    //   799: getfield 1122	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   802: ldc 148
    //   804: putfield 1496	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:g	Ljava/lang/String;
    //   807: aload 31
    //   809: getfield 1122	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   812: ldc 148
    //   814: putfield 1497	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:f	Ljava/lang/String;
    //   817: iload 5
    //   819: aload 30
    //   821: aload 31
    //   823: invokestatic 1500	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(ILjava/lang/String;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)Z
    //   826: ifeq +13 -> 839
    //   829: ldc 211
    //   831: iconst_1
    //   832: ldc_w 1502
    //   835: invokestatic 412	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   838: return
    //   839: iload 5
    //   841: invokestatic 1504	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(I)I
    //   844: istore 7
    //   846: aload 31
    //   848: aload_0
    //   849: aload 31
    //   851: aload 25
    //   853: iload 5
    //   855: iload 4
    //   857: aload_1
    //   858: aload 26
    //   860: iload 6
    //   862: i2l
    //   863: aload 27
    //   865: lload 15
    //   867: iload_3
    //   868: aload 30
    //   870: iload 7
    //   872: aload_2
    //   873: invokevirtual 1166	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule:getActivity	()Landroid/app/Activity;
    //   876: invokestatic 1506	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;JLjava/lang/String;JILjava/lang/String;ILandroid/app/Activity;)Landroid/content/Intent;
    //   879: lload 13
    //   881: lload 17
    //   883: iload 7
    //   885: aload 25
    //   887: iload 6
    //   889: aload_2
    //   890: invokestatic 1508	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;Lorg/json/JSONObject;Landroid/content/Intent;JJILjava/lang/String;ILcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V
    //   893: return
    //   894: astore_0
    //   895: goto +4 -> 899
    //   898: astore_0
    //   899: ldc 211
    //   901: aload_0
    //   902: invokevirtual 209	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   905: invokestatic 1512	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   908: return
    //   909: ldc 148
    //   911: astore 27
    //   913: goto -126 -> 787
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	916	0	paramJSONObject	JSONObject
    //   0	916	1	paramString	String
    //   0	916	2	paramBridgeModule	BridgeModule
    //   264	604	3	i	int
    //   557	299	4	j	int
    //   566	288	5	k	int
    //   613	275	6	m	int
    //   584	300	7	n	int
    //   40	3	8	bool	boolean
    //   125	573	9	l1	long
    //   162	514	11	l2	long
    //   199	681	13	l3	long
    //   55	811	15	l4	long
    //   251	631	17	l5	long
    //   236	485	19	l6	long
    //   283	251	21	l7	long
    //   523	15	23	l8	long
    //   70	816	25	localObject1	Object
    //   15	257	26	localObject2	Object
    //   316	1	26	localException1	Exception
    //   357	1	26	localException2	Exception
    //   362	1	26	localException3	Exception
    //   404	1	26	localException4	Exception
    //   409	1	26	localException5	Exception
    //   447	1	26	localException6	Exception
    //   460	8	26	localException7	Exception
    //   473	386	26	localObject3	Object
    //   85	371	27	localObject4	Object
    //   465	7	27	localException8	Exception
    //   477	435	27	localObject5	Object
    //   24	738	28	localObject6	Object
    //   94	687	29	str1	String
    //   33	836	30	str2	String
    //   103	747	31	localObject7	Object
    //   575	189	32	str3	String
    //   604	162	33	str4	String
    //   711	41	34	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   244	253	316	java/lang/Exception
    //   257	265	316	java/lang/Exception
    //   207	238	357	java/lang/Exception
    //   170	201	362	java/lang/Exception
    //   133	164	404	java/lang/Exception
    //   105	127	409	java/lang/Exception
    //   87	105	447	java/lang/Exception
    //   72	87	460	java/lang/Exception
    //   57	72	465	java/lang/Exception
    //   568	713	894	org/json/JSONException
    //   718	780	894	org/json/JSONException
    //   787	829	894	org/json/JSONException
    //   8	42	898	org/json/JSONException
    //   57	72	898	org/json/JSONException
    //   72	87	898	org/json/JSONException
    //   87	105	898	org/json/JSONException
    //   105	127	898	org/json/JSONException
    //   133	164	898	org/json/JSONException
    //   170	201	898	org/json/JSONException
    //   207	238	898	org/json/JSONException
    //   244	253	898	org/json/JSONException
    //   257	265	898	org/json/JSONException
    //   502	507	898	org/json/JSONException
    //   541	568	898	org/json/JSONException
    //   829	838	898	org/json/JSONException
    //   839	893	898	org/json/JSONException
  }
  
  private static boolean a(int paramInt, String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramInt == 23) && ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeName)));
  }
  
  @SuppressLint({"NewApi"})
  public static boolean a(Activity paramActivity)
  {
    if (!VersionUtils.k()) {
      return true;
    }
    boolean bool = false;
    if (paramActivity == null) {
      return false;
    }
    if (paramActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
      bool = true;
    }
    return bool;
  }
  
  static ColumnInfo b(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("topicId");
    paramJSONObject = paramJSONObject.optString("title");
    ColumnInfo localColumnInfo = new ColumnInfo();
    localColumnInfo.columnID = i;
    localColumnInfo.title = paramJSONObject;
    return localColumnInfo;
  }
  
  private static String b(int paramInt)
  {
    if (paramInt != 122)
    {
      switch (paramInt)
      {
      default: 
        return "";
      case 116: 
        return "showUGCVideoRecordPage";
      case 115: 
        return "showUGCVideoUploadPage";
      }
      return "showUGCEditPage";
    }
    return "showQAAskEditor";
  }
  
  public static JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    String str1 = DeviceInfoUtil.j();
    String str2 = DeviceInfoUtil.b();
    try
    {
      localJSONObject.put("imsi", ReadInJoyUtils.d());
      localJSONObject.put("androidID", str1);
      localJSONObject.put("identifier", str2);
      localJSONObject.put("qimei", UserAction.getQIMEI());
      localJSONObject.put("qua", QZoneHelper.getQUA());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void b(BridgeModule paramBridgeModule, int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    int i;
    if (paramInt == -1) {
      i = 0;
    } else {
      i = -1;
    }
    if (paramIntent == null) {
      return;
    }
    String str1 = paramIntent.getStringExtra("result_js_callback");
    String str2 = paramIntent.getStringExtra("feed_id");
    long l = paramIntent.getLongExtra("feedsType", 1L);
    if ((str1 != null) && (str2 != null))
    {
      paramIntent = new JSONObject();
      try
      {
        paramIntent.put("feedsId", str2);
        paramIntent.put("retCode", i);
        paramIntent.put("feedsType", l);
        paramBridgeModule.invokeCallJS(str1, paramIntent);
      }
      catch (Exception paramBridgeModule)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("dealBiuResult error:");
        paramIntent.append(paramBridgeModule.getMessage());
        QLog.e("BridgeModuleHelper", 2, paramIntent.toString());
      }
    }
    paramBridgeModule = ShareReport.a;
    if (paramInt == -1) {
      bool = true;
    }
    paramBridgeModule.a(bool);
  }
  
  private static void b(BridgeModule paramBridgeModule, SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if (paramSosoLbsInfo != null)
    {
      if (paramSosoLbsInfo.mLocation == null) {
        return;
      }
      double d1 = paramSosoLbsInfo.mLocation.mLat02;
      double d2 = 1000000;
      Double.isNaN(d2);
      double d3 = paramSosoLbsInfo.mLocation.mLon02;
      Double.isNaN(d2);
      double d4 = paramSosoLbsInfo.mLocation.mLat02;
      double d5 = paramSosoLbsInfo.mLocation.mLon02;
      String str1 = paramSosoLbsInfo.mLocation.city;
      String str2 = "";
      if (str1 != null) {
        str1 = paramSosoLbsInfo.mLocation.city;
      } else {
        str1 = "";
      }
      if (paramSosoLbsInfo.mLocation.cityCode != null) {
        str2 = paramSosoLbsInfo.mLocation.cityCode;
      }
      try
      {
        paramSosoLbsInfo = new JSONObject();
        paramSosoLbsInfo.put("authroized", true);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", 0).put("latitude", d1 * d2).put("longitude", d3 * d2).put("origin_latitude", d4).put("origin_longitude", d5).put("city", str1).put("cityCode", str2).put("status", paramSosoLbsInfo);
        paramBridgeModule.invokeCallJS(paramString, localJSONObject.toString());
        return;
      }
      catch (JSONException paramBridgeModule)
      {
        paramSosoLbsInfo = new StringBuilder();
        paramSosoLbsInfo.append("fireLocationSuccessCallbackError: ");
        paramSosoLbsInfo.append(paramBridgeModule.getMessage());
        QLog.e("BridgeModuleHelper", 1, paramSosoLbsInfo.toString());
      }
    }
  }
  
  private static void b(BridgeModule paramBridgeModule, File paramFile)
  {
    paramBridgeModule = paramBridgeModule.getViolaInstance().getActivity();
    if (paramBridgeModule != null)
    {
      if (paramBridgeModule.isFinishing()) {
        return;
      }
      Object localObject = paramFile.getAbsolutePath();
      paramFile = new Bundle();
      paramFile.putInt("forward_type", 1);
      paramFile.putString("forward_urldrawable_thumb_url", (String)localObject);
      paramFile.putString("forward_filepath", (String)localObject);
      paramFile.putString("forward_extra", (String)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramFile);
      ForwardBaseOption.a(paramBridgeModule, (Intent)localObject, 18);
    }
  }
  
  public static void b(BridgeModule paramBridgeModule, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!ReadInJoyHelper.C()) {
          break label45;
        }
        i = 1;
        localJSONObject.put("result", i);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
      label45:
      int i = 0;
    }
  }
  
  public static void b(BridgeModule paramBridgeModule, String paramString, boolean paramBoolean)
  {
    ViolaSDKManager.getInstance().postOnThreadPool(new BridgeModuleHelper.9(paramBoolean, paramBridgeModule, paramString));
  }
  
  public static void b(@NotNull BridgeModule paramBridgeModule, @NotNull JSONObject paramJSONObject, @Nullable String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showPictureWithRowKey, json=");
      ((StringBuilder)localObject1).append(paramJSONObject);
      ((StringBuilder)localObject1).append(", callbackId=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("BridgeModuleHelper", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = paramJSONObject.optJSONArray("imageIDs");
    if ((localObject2 != null) && (((JSONArray)localObject2).length() != 0))
    {
      localObject1 = new ArrayList();
      int i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        String str = ((JSONArray)localObject2).optString(i, "");
        if (!TextUtils.isEmpty(str)) {
          ((ArrayList)localObject1).add(str);
        }
        i += 1;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putStringArrayList("seqNum", (ArrayList)localObject1);
      ((Bundle)localObject2).putString("src_id", paramJSONObject.optString("srcID"));
      ((Bundle)localObject2).putInt("index", paramJSONObject.optInt("index"));
      ((Bundle)localObject2).putBoolean("is_not_show_index", true);
      ((Bundle)localObject2).putBoolean("show_title_bar", paramJSONObject.optBoolean("showTitleBar", true));
      ((Bundle)localObject2).putString("acticle_info_rowkey", paramJSONObject.optString("rowkey"));
      ((Bundle)localObject2).putString("callback_seq", paramString);
      ((Bundle)localObject2).putBoolean("show_social_bottom_bar", true);
      ((Bundle)localObject2).putString("show_social_bottom_bar_data", paramJSONObject.optJSONObject("socialBottomBar").toString());
      ((Bundle)localObject2).putBoolean("is_need_to_aio", false);
      a(paramBridgeModule, (Bundle)localObject2);
      return;
    }
    QLog.e("BridgeModuleHelper", 1, "showPictureWithRowKey imageJSONArray is Empty");
  }
  
  public static void b(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    if (paramJSONObject != null)
    {
      String str1 = paramJSONObject.optString("url");
      String str2 = paramJSONObject.optString("businessId", null);
      if (!TextUtils.isEmpty(str1))
      {
        if (!TextUtils.isEmpty(str2))
        {
          paramJSONObject = new Bundle();
          paramJSONObject.putString("big_brother_source_key", str2);
          paramJSONObject.putString("big_brother_ref_source_key", RIJJumpUtils.a(0));
        }
        else
        {
          paramJSONObject = null;
        }
        a(str1, paramJSONObject, paramActivity);
        paramBridgeModule.invokeCallJS(paramString, null);
      }
    }
  }
  
  public static void b(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        String str = paramJSONObject.optString("rowkey", "");
        int j = paramJSONObject.optInt("maxSelect");
        int k = paramJSONObject.optInt("maxCount");
        Object localObject = paramJSONObject.optString("invitedUins", "[]");
        paramJSONObject = new StringBuilder();
        if ((localObject != null) && (((String)localObject).trim().length() > 0))
        {
          localObject = new JSONArray(((String)localObject).trim());
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramJSONObject.append(((JSONArray)localObject).get(i));
            if (i >= ((JSONArray)localObject).length() - 1) {
              break label264;
            }
            paramJSONObject.append(",");
            break label264;
          }
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("opentype", 1);
        ((Intent)localObject).putExtra("filterUins", paramJSONObject.toString());
        ((Intent)localObject).putExtra("maxSelect", j);
        if (k > 0) {
          ((Intent)localObject).putExtra("maxCount", k);
        }
        ((Intent)localObject).putExtra("rowkey", str);
        ((Intent)localObject).putExtra("callback", paramString);
        PublicFragmentActivity.a(paramActivity, (Intent)localObject, ReadInJoySelectMemberAQFragment.class, 119);
        return;
      }
      catch (Exception paramJSONObject)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("selectAndInviteFriend e = ");
          paramString.append(paramJSONObject);
          QLog.e("BridgeModuleHelper", 2, paramString.toString());
        }
        paramJSONObject.printStackTrace();
        return;
      }
      label264:
      i += 1;
    }
  }
  
  private static void b(JSONObject paramJSONObject, String paramString, BridgeModule paramBridgeModule)
  {
    ViolaBridgeManager.getInstance().callbackJavascript(paramBridgeModule.getViolaInstance().getInstanceId(), paramBridgeModule.getModuleName(), "callback", paramString, paramJSONObject, true);
  }
  
  public static QQCustomDialog c(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    QQCustomDialog localQQCustomDialog = null;
    if (paramJSONObject != null)
    {
      if (paramActivity == null) {
        return null;
      }
      localQQCustomDialog = new QQCustomDialog(paramActivity, 2131953338);
      localQQCustomDialog.setContentView(2131624587);
      localQQCustomDialog.getMessageTextView().setMovementMethod(new ScrollingMovementMethod());
      localQQCustomDialog.getMessageTextView().setMaxHeight(DisplayUtil.a(paramActivity, 200.0F));
      localQQCustomDialog.setTitle(paramJSONObject.optString("title"));
      localQQCustomDialog.setMessage(paramJSONObject.optString("text"));
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      if (paramJSONObject.optBoolean("needOkBtn", true)) {
        localQQCustomDialog.setPositiveButton(paramJSONObject.optString("okBtnText", HardCodeUtil.a(2131899883)), new BridgeModuleHelper.4(paramJSONObject, paramBridgeModule, paramString));
      }
      if (paramJSONObject.optBoolean("needCancelBtn", true)) {
        localQQCustomDialog.setNegativeButton(paramJSONObject.optString("cancelBtnText", HardCodeUtil.a(2131898212)), new BridgeModuleHelper.5(paramJSONObject, paramBridgeModule, paramString));
      }
      localQQCustomDialog.show();
    }
    return localQQCustomDialog;
  }
  
  static CommunityInfo c(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("kdCommunityInfo");
    if (paramJSONObject != null)
    {
      CommunityInfo localCommunityInfo = new CommunityInfo();
      localCommunityInfo.setTitle(paramJSONObject.optString("communityName"));
      localCommunityInfo.setCommunityId(String.valueOf(paramJSONObject.optInt("communityId")));
      return localCommunityInfo;
    }
    return null;
  }
  
  public static JSONObject c()
  {
    int k = HttpUtil.getNetWorkType();
    String str = HttpUtil.getNetWorkTypeByStr();
    Object localObject = DeviceInfoUtil.c();
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    int j = 3;
    if ((!bool) && (((String)localObject).length() > 5) && (((String)localObject).startsWith("460")))
    {
      localObject = ((String)localObject).substring(3, 5);
      if ((!((String)localObject).equals("00")) && (!((String)localObject).equals("02")) && (!((String)localObject).equals("04")) && (!((String)localObject).equals("07")))
      {
        if ((!((String)localObject).equals("01")) && (!((String)localObject).equals("06")) && (!((String)localObject).equals("09")))
        {
          i = j;
          if (((String)localObject).equals("03")) {
            break label195;
          }
          if (((String)localObject).equals("05"))
          {
            i = j;
            break label195;
          }
          if (((String)localObject).equals("20"))
          {
            i = 4;
            break label195;
          }
        }
        else
        {
          i = 2;
          break label195;
        }
      }
      else
      {
        i = 1;
        break label195;
      }
    }
    int i = 0;
    label195:
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("type", k);
      ((JSONObject)localObject).put("radio", str);
      ((JSONObject)localObject).put("carriertype", i);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localObject;
  }
  
  public static void c(BridgeModule paramBridgeModule, String paramString)
  {
    QLog.i("BridgeModuleHelper", 1, "request yyy_0xe36");
    cmd0xe36.ReqBody localReqBody = new cmd0xe36.ReqBody();
    localReqBody.nothing.set(1);
    ProtoUtils.a(ReadInJoyUtils.b(), new BridgeModuleHelper.2(paramBridgeModule, paramString), localReqBody.toByteArray(), "OidbSvc.0xe36", 3638, 1, new Bundle(), 5000L);
  }
  
  private static void c(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new BridgeModuleHelper.20(paramString1, paramBridgeModule, paramString2));
  }
  
  public static void c(BridgeModule paramBridgeModule, String paramString, boolean paramBoolean)
  {
    ViolaSDKManager.getInstance().postOnThreadPool(new BridgeModuleHelper.10(paramBridgeModule, paramString));
  }
  
  public static void c(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Object localObject = paramBridgeModule.getViolaInstance().getActivity();
    if ((paramJSONObject != null) && (localObject != null)) {}
    try
    {
      long l = paramJSONObject.getLong("puin");
      paramJSONObject = new ActivityURIRequest((Context)localObject, "/pubaccount/detail");
      localObject = paramJSONObject.extra();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l);
      ((Bundle)localObject).putString("uin", localStringBuilder.toString());
      paramJSONObject.extra().putBoolean("from_js", true);
      QRoute.startUri(paramJSONObject, null);
      paramBridgeModule.invokeCallJS(paramString, null);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("openAccountPageMore->error:");
      paramJSONObject.append(paramBridgeModule);
      QLog.d("BridgeModuleHelper", 2, paramJSONObject.toString());
    }
    paramBridgeModule.invokeErrorCallJS(paramString, "params error");
    return;
  }
  
  public static void c(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    int n = paramJSONObject.optInt("type", 1);
    int j;
    int i;
    if (paramJSONObject.has("width"))
    {
      j = paramJSONObject.optInt("width");
      i = DisplayUtil.a(paramActivity, j / 2);
    }
    else
    {
      i = 640;
      j = 640;
    }
    int k;
    int m;
    if (paramJSONObject.has("height"))
    {
      k = paramJSONObject.optInt("height");
      m = DisplayUtil.a(paramActivity, k / 2);
    }
    else
    {
      m = 640;
      k = 640;
    }
    a(paramActivity, 1, n, (byte)118, i, m, j, k, paramString);
  }
  
  public static ReadInJoyUserInfoModule d()
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject == null) {
      return null;
    }
    localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject == null) {
      return null;
    }
    return ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().e();
  }
  
  public static void d(BridgeModule paramBridgeModule, String paramString)
  {
    if (paramBridgeModule.getViolaInstance() == null) {
      return;
    }
    Object localObject = paramBridgeModule.getViolaInstance().getFragment();
    if (localObject != null)
    {
      boolean bool = ((Fragment)localObject).getUserVisibleHint();
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("result", bool);
        paramBridgeModule.invokeCallJS(paramString, localObject);
        return;
      }
      catch (JSONException paramBridgeModule)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("pageVisibility error");
          paramString.append(paramBridgeModule.getMessage());
          QLog.e("BridgeModuleHelper", 2, paramString.toString());
        }
      }
    }
  }
  
  private static void d(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    try
    {
      paramString2 = paramBridgeModule.getFailInvokeObj(paramString2);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", 1).put("authroized", false);
      paramString2.put("data", localJSONObject);
      paramBridgeModule.invokeJS(paramString1, paramString2);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      paramString1 = new StringBuilder();
      paramString1.append("fireLocationErrorCallbackError: ");
      paramString1.append(paramBridgeModule.getMessage());
      QLog.e("BridgeModuleHelper", 1, paramString1.toString());
    }
  }
  
  public static void d(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {}
    try
    {
      String str = paramJSONObject.getString("feeds_id");
      paramJSONObject = paramJSONObject.optString("feeds_type", "1");
      ReadInJoyLogicEngine.a().a(str, Integer.valueOf(paramJSONObject).intValue());
      paramBridgeModule.invokeCallJS(paramString, null);
      return;
    }
    catch (Exception paramBridgeModule)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("openAccountPageMore->error:");
      paramJSONObject.append(paramBridgeModule);
      QLog.d("BridgeModuleHelper", 2, paramJSONObject.toString());
    }
    paramBridgeModule.invokeErrorCallJS(paramString, "params error");
    return;
  }
  
  public static void d(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    paramJSONObject = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramJSONObject)) {
      return;
    }
    if (paramActivity != null) {
      ViolaAccessHelper.a(paramActivity, paramJSONObject, new BridgeModuleHelper.6(paramBridgeModule, paramString));
    }
  }
  
  public static void d(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optString("apkUrl") != null) && (paramJSONObject.optInt("action", -1) != -1))
    {
      int i = paramJSONObject.optInt("action", -1);
      if (i == 1)
      {
        e(paramJSONObject);
        return;
      }
      if (i == 2)
      {
        f(paramJSONObject);
        return;
      }
      if (i == 3) {
        g(paramJSONObject);
      }
    }
  }
  
  public static void d(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    int n = paramJSONObject.optInt("type");
    int i = Utils.rp2px(localDisplayMetrics.widthPixels, 360.0D);
    int j = Utils.rp2px(localDisplayMetrics.widthPixels, 200.0D);
    int k = 750;
    int m = 416;
    if (n == 1)
    {
      i = Utils.rp2px(localDisplayMetrics.widthPixels, 360.0D);
      j = i;
      k = 160;
      m = 160;
    }
    if ((n == 1) || (n == 2)) {
      a(paramActivity, 2, 0, (byte)121, i, j, k, m, paramString);
    }
  }
  
  public static Activity e()
  {
    if (Foreground.getTopActivity() != null) {
      return Foreground.getTopActivity();
    }
    return QBaseActivity.sTopActivity;
  }
  
  public static void e(BridgeModule paramBridgeModule, String paramString)
  {
    if (paramBridgeModule.getViolaInstance() == null) {
      return;
    }
    Fragment localFragment = paramBridgeModule.getViolaInstance().getFragment();
    if (localFragment != null)
    {
      if ((localFragment instanceof ViolaFragment)) {
        ((ViolaFragment)localFragment).doOnBackPressed();
      } else {
        localFragment.getActivity().onBackPressed();
      }
      paramBridgeModule.invokeCallJS(paramString, null);
    }
  }
  
  public static void e(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        long l = paramJSONObject.getLong("followUin");
        int i = paramJSONObject.getInt("followInfo");
        if ((i == 2) || (i == 1))
        {
          paramJSONObject = ReadInJoyLogicEngineEventDispatcher.a();
          if (i != 2) {
            break label136;
          }
          bool = true;
          paramJSONObject.b(l, bool);
          ReadInJoyLogicEngineEventDispatcher.a().a(l, i);
          ThreadManager.post(new BridgeModuleHelper.1(l, i), 8, null, true);
        }
        paramBridgeModule.invokeCallJS(paramString, null);
        return;
      }
      catch (JSONException paramBridgeModule)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("openAccountPageMore -> error:");
        paramJSONObject.append(paramBridgeModule);
        QLog.d("BridgeModuleHelper", 2, paramJSONObject.toString());
        return;
      }
      paramBridgeModule.invokeErrorCallJS(paramString, "params error");
      return;
      label136:
      boolean bool = false;
    }
  }
  
  public static void e(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      DownloadManagerV2.a().e(paramJSONObject);
    }
  }
  
  public static void e(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    int j = paramJSONObject.optInt("fromType");
    boolean bool = paramJSONObject.has("permission");
    int i;
    if (bool) {
      i = paramJSONObject.optInt("permission");
    } else {
      i = RIJEntryViewUtils.a.c();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasPermission: ");
      localStringBuilder.append(bool);
      localStringBuilder.append("  permission: ");
      localStringBuilder.append(i);
      QLog.i("BridgeModuleHelper", 2, localStringBuilder.toString());
    }
    RIJEntryViewUtils.a.a(paramActivity, i, j, 124, b(paramJSONObject), c(paramJSONObject), paramString);
  }
  
  private static int f()
  {
    if (StudyModeManager.h()) {
      return 8193;
    }
    return 1;
  }
  
  public static void f(BridgeModule paramBridgeModule, String paramString)
  {
    if (paramBridgeModule.getViolaInstance() == null) {
      return;
    }
    Object localObject = paramBridgeModule.getViolaInstance().getFragment();
    if (localObject != null)
    {
      if ((localObject instanceof ViolaFragment))
      {
        ViolaFragment localViolaFragment = (ViolaFragment)localObject;
        if (localViolaFragment.getCommonSuspensionGestureLayout() != null)
        {
          localObject = (CommonSuspensionGestureLayout)localViolaFragment.getCommonSuspensionGestureLayout();
          if (((CommonSuspensionGestureLayout)localObject).b()) {
            localViolaFragment.getQBaseActivity().doOnBackPressed();
          } else {
            ((CommonSuspensionGestureLayout)localObject).a(0, 3);
          }
        }
        else
        {
          ((QBaseFragment)localObject).getQBaseActivity().doOnBackPressed();
        }
      }
      else
      {
        ((QBaseFragment)localObject).getQBaseActivity().doOnBackPressed();
      }
      paramBridgeModule.invokeCallJS(paramString, null);
    }
  }
  
  public static void f(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {}
    try
    {
      int i = paramJSONObject.getInt("topicId");
      int j = paramJSONObject.getInt("followInfo");
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("topic id = ");
        paramJSONObject.append(i);
        paramJSONObject.append("\t follow info =");
        paramJSONObject.append(j);
        QLog.d("BridgeModuleHelper", 2, paramJSONObject.toString());
      }
      if (!ReadInJoyLogicEngine.a().g(i, j)) {
        ReadInJoyLogicEngine.a().h(i, j);
      }
      paramBridgeModule.invokeCallJS(paramString, null);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("openAccountPageMore->error:");
      paramJSONObject.append(paramBridgeModule);
      QLog.d("BridgeModuleHelper", 2, paramJSONObject.toString());
    }
    paramBridgeModule.invokeErrorCallJS(paramString, "params error");
    return;
  }
  
  public static void f(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.d = paramJSONObject;
      localDownloadInfo.r = "biz_src_feeds_kandianads";
      localDownloadInfo.b();
      DownloadManagerV2.a().b(localDownloadInfo);
    }
  }
  
  public static void f(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    paramString = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (paramJSONObject.optJSONObject("param") != null) {
      localBundle.putString("param", paramJSONObject.optJSONObject("param").toString());
    }
    ViolaAccessHelper.a(paramActivity, "", paramString, localBundle);
  }
  
  public static void g(BridgeModule paramBridgeModule, String paramString)
  {
    Object localObject = paramBridgeModule.getViolaInstance();
    if (localObject == null) {
      return;
    }
    localObject = ((ViolaInstance)localObject).getFragment();
    if ((localObject instanceof ViolaFragment)) {
      ((ViolaFragment)localObject).setTitleContainerClick(new BridgeModuleHelper.7(paramBridgeModule, paramString));
    }
  }
  
  public static void g(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        int i = BiuBehaviour.a();
        str = "fastBiu";
        if (i == 1) {
          paramJSONObject = "fastBiu";
        } else {
          paramJSONObject = "normalBiu";
        }
        if (BiuBehaviour.b() != 1) {
          break label102;
        }
        localJSONObject.put("retCode", 0);
        localJSONObject.put("click", paramJSONObject);
        localJSONObject.put("longClick", str);
        if (!TextUtils.isEmpty(paramString))
        {
          paramBridgeModule.invokeCallJS(paramString, localJSONObject);
          return;
        }
      }
      catch (JSONException paramBridgeModule)
      {
        QLog.e("BridgeModuleHelper", 1, "[getBiuTriggerType] ", paramBridgeModule);
      }
      return;
      label102:
      String str = "normalBiu";
    }
  }
  
  public static void g(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      DownloadManagerV2.a().b(paramJSONObject, true);
    }
  }
  
  public static void h(BridgeModule paramBridgeModule, String paramString)
  {
    Object localObject = paramBridgeModule.getViolaInstance().getActivity();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      if (!AppNetConnInfo.isNetSupport())
      {
        QQToast.makeText(ReadInJoyUtils.b().getApplication(), 1, HardCodeUtil.a(2131899440), 0).show();
        return;
      }
      localObject = new File(AbsDownloader.getFilePath(paramString));
      if (((File)localObject).exists())
      {
        b(paramBridgeModule, (File)localObject);
        return;
      }
      a(paramBridgeModule, paramString, (File)localObject);
    }
  }
  
  public static void h(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (AppInterface)ReadInJoyUtils.b();
    localObject = paramBridgeModule.getViolaInstance().getFragment();
    if (localObject != null) {
      paramBridgeModule = ((Fragment)localObject).getActivity();
    } else {
      paramBridgeModule = paramBridgeModule.getViolaInstance().getActivity();
    }
    if (paramBridgeModule == null) {
      return;
    }
    String str1 = paramJSONObject.optString("topicId");
    int i = paramJSONObject.optInt("adtag");
    paramJSONObject.optInt("mode");
    paramJSONObject.optString("vid");
    paramJSONObject.optString("videourl");
    paramJSONObject.optString("coverurl");
    paramJSONObject.optString("md5");
    localObject = paramJSONObject.optString("topicName");
    String str2 = paramJSONObject.optString("cookie");
    try
    {
      paramJSONObject = new String(Base64Util.decode((String)localObject, 0));
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      paramJSONObject = (JSONObject)localObject;
    }
    if (RIJUGCDianDian.b() >= 2)
    {
      QQToast.makeText(paramBridgeModule, 0, paramBridgeModule.getString(2131915357), 0).show(paramBridgeModule.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("arg_topic_id", str1);
    ((Bundle)localObject).putString("mTaskID", String.valueOf(System.currentTimeMillis() + (Math.random() * 10000.0D)));
    ((Bundle)localObject).putString("arg_topic_id", str1);
    ((Bundle)localObject).putString("arg_topic_name", paramJSONObject);
    ((Bundle)localObject).putInt("arg_ad_tag", i);
    ((Bundle)localObject).putString("arg_callback", paramString);
    ((Bundle)localObject).putString("arg_ugc_edit_cookie", str2);
    ReadInJoyCaptureLauncher.getInstance().launchFromViolaForResult(paramBridgeModule, (Bundle)localObject, (byte)116);
    RIJUGCDianDian.a("2", "2");
  }
  
  public static void h(JSONObject paramJSONObject)
  {
    try
    {
      GdtLog.a("BridgeModuleHelper", paramJSONObject.toString());
      GdtC2SReporter.a(paramJSONObject.optInt("operationType"), paramJSONObject.optInt("businessType"), (qq_ad_get.QQAdGetRsp.AdInfo)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo")));
      return;
    }
    catch (Exception paramJSONObject)
    {
      GdtLog.d("BridgeModuleHelper", "handleJsCallRequest", paramJSONObject);
    }
  }
  
  public static void i(BridgeModule paramBridgeModule, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      int i = 0;
      if (ThemeUtil.isNowThemeIsNight(localAppRuntime, false, null)) {
        i = 1;
      }
      localJSONObject.put("isNightMode", i);
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      paramBridgeModule.printStackTrace();
    }
  }
  
  public static void i(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramBridgeModule.getViolaInstance().getFragment() != null) {
      paramBridgeModule = paramBridgeModule.getViolaInstance().getFragment().getActivity();
    } else {
      paramBridgeModule = paramBridgeModule.getViolaInstance().getActivity();
    }
    if (paramBridgeModule == null) {
      return;
    }
    int i = paramJSONObject.optInt("maxLength", -1);
    int j = paramJSONObject.optInt("commentType", 0);
    int k = paramJSONObject.optInt("sourceType", 0);
    String str1 = WebCommentEditorHandler.a(paramJSONObject.optString("placeholder"));
    String str2 = WebCommentEditorHandler.a(paramJSONObject.optString("defaultTxt"));
    Intent localIntent = new Intent();
    if (paramJSONObject.has("isPgcAuthor")) {
      localIntent.putExtra("isPgcAuthor", paramJSONObject.optBoolean("isPgcAuthor"));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#showCommentEditor bridge isPgcAuthor = ");
    localStringBuilder.append(paramJSONObject.optBoolean("isPgcAuthor", false));
    QLog.d("BridgeModuleHelper", 2, localStringBuilder.toString());
    localIntent.putExtra("comment_type", false);
    localIntent.putExtra("placeholder", str1);
    localIntent.putExtra("defaultTxt", str2);
    localIntent.putExtra("maxLength", i);
    localIntent.putExtra("commentType", j);
    localIntent.putExtra("sourceType", k);
    localIntent.putExtra("arg_callback", paramString);
    localIntent.putExtra("public_fragment_window_feature", 1);
    ReadInJoyCommentEntrance.a(paramBridgeModule, localIntent, 117);
  }
  
  public static void i(JSONObject paramJSONObject) {}
  
  public static void j(BridgeModule paramBridgeModule, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", CUKingCardUtils.a());
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (Exception paramBridgeModule)
    {
      QLog.e("BridgeModuleHelper", 1, "getCUKingStatus error e = ", paramBridgeModule);
    }
  }
  
  public static void j(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("type", 0);
    boolean bool1 = paramJSONObject.optBoolean("blackScene", false);
    boolean bool2 = paramJSONObject.optBoolean("isNightMode", false);
    String str = paramJSONObject.optString("avatarUrl", "");
    int j = paramJSONObject.optInt("bizType", 1);
    paramJSONObject = paramJSONObject.optString("uniqueID", "");
    RIJPushNotifyManager.Companion.a().showPushNotifyDialogForWeb(i, bool1, bool2, str, j, paramJSONObject, new BridgeModuleHelper.3(paramBridgeModule, paramString));
  }
  
  public static void j(JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(paramJSONObject.optString("url", "")))
    {
      String str = paramJSONObject.optString("url", "");
      boolean bool1 = paramJSONObject.optBoolean("isGif", false);
      boolean bool2 = paramJSONObject.has("width");
      float f2 = 100.0F;
      float f1;
      if (bool2) {
        f1 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("width"), 750);
      } else {
        f1 = 100.0F;
      }
      if (paramJSONObject.has("height")) {
        f2 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("height"), 750);
      }
      paramJSONObject = URLDrawable.getDrawable(str, ComponentAdapter.a(bool1, (int)f1, (int)f2));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preload image, ur: ");
      localStringBuilder.append(str);
      localStringBuilder.append(".isGif:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",reqWidth:");
      localStringBuilder.append(f1);
      localStringBuilder.append(",reqHeight:");
      localStringBuilder.append(f2);
      QLog.d("BridgeModuleHelper", 2, localStringBuilder.toString());
      paramJSONObject.startDownload();
    }
  }
  
  private static HashMap<String, Object> k(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      HashMap localHashMap = new HashMap();
      if (TextUtils.isEmpty(paramJSONObject.optString("bgclr"))) {
        localHashMap.put("title_nav_text_color", paramJSONObject.optString("bgclr"));
      }
      if (TextUtils.isEmpty(paramJSONObject.optString("txtclr"))) {
        localHashMap.put("title_nav_background_color", paramJSONObject.optString("txtclr"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("titleclr"))) {
        localHashMap.put("title_nav_center_text_color", paramJSONObject.optString("titleclr"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("alpha"))) {
        localHashMap.put("title_nav_alpha", paramJSONObject.optString("alpha"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("statusBarColor"))) {
        localHashMap.put("title_status_bar_color", paramJSONObject.optString("statusBarColor"));
      }
      return localHashMap;
    }
    return null;
  }
  
  public static void k(BridgeModule paramBridgeModule, String paramString)
  {
    ThreadManager.post(new BridgeModuleHelper.11(paramBridgeModule, paramString), 8, null, true);
  }
  
  public static void k(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = paramJSONObject.optString("key");
    int i = paramJSONObject.optInt("id", -1);
    if (i != -1)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        paramJSONObject = new JSONObject();
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          Object localObject2 = Aladdin.getConfig(i).getAll();
          if (localObject2 != null)
          {
            localObject1 = new JSONObject();
            localObject2 = ((Map)localObject2).entrySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
              ((JSONObject)localObject1).put((String)localEntry.getKey(), localEntry.getValue().toString());
            }
            paramJSONObject.put("value", localObject1);
          }
        }
        else
        {
          paramJSONObject.put("value", Aladdin.getConfig(i).getString((String)localObject1, ""));
        }
        b(paramJSONObject, paramString, paramBridgeModule);
        return;
      }
      catch (Exception paramBridgeModule)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("[getALDConfig]: ");
        paramJSONObject.append(paramBridgeModule.getMessage());
        QLog.e("BridgeModuleHelper", 1, paramJSONObject.toString());
      }
    }
  }
  
  public static void l(BridgeModule paramBridgeModule, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("recommendFlag", f());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    paramBridgeModule.invokeCallJS(paramString, localJSONObject);
  }
  
  public static void l(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.b();
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getApplication();
    String str = paramJSONObject.optString("text");
    int j = 2;
    int k = paramJSONObject.optInt("iconMode", 2);
    if (!TextUtils.isEmpty(str))
    {
      if (k != 0)
      {
        i = j;
        if (k == 1) {
          break label103;
        }
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 6)
            {
              i = j;
              break label103;
            }
          }
          else
          {
            i = 6;
            break label103;
          }
        }
        else
        {
          i = 1;
          break label103;
        }
      }
      int i = 0;
      label103:
      QQToast.makeText((Context)localObject, i, str, 0).show(((Context)localObject).getResources().getDimensionPixelSize(2131299920));
      paramBridgeModule.invokeCallJS(paramString, new JSONObject());
      return;
    }
    paramBridgeModule.invokeErrorCallJS(paramString, "text为null!!");
  }
  
  public static void m(BridgeModule paramBridgeModule, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", true);
    }
    catch (JSONException localJSONException)
    {
      label20:
      break label20;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModuleHelper", 2, "Error in isMobileQQ");
    }
    paramBridgeModule.invokeCallJS(paramString, localJSONObject);
  }
  
  public static void m(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramBridgeModule.getViolaInstance() == null) {
      return;
    }
    Fragment localFragment = paramBridgeModule.getViolaInstance().getFragment();
    if (localFragment == null) {
      return;
    }
    if ((localFragment instanceof ViolaFragment))
    {
      String str2 = paramJSONObject.optString("title");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramJSONObject.optString("text");
      }
      if (!TextUtils.isEmpty(str1))
      {
        ((ViolaFragment)localFragment).setTitle(str1);
        paramBridgeModule.invokeCallJS(paramString, new JSONObject());
      }
    }
  }
  
  public static void n(BridgeModule paramBridgeModule, String paramString)
  {
    if (paramBridgeModule.getViolaInstance() != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        int i = CUKingCardUtils.a();
        bool = true;
        if (i != 1) {
          break label108;
        }
        localJSONObject.put("value", bool);
        ViolaBridgeManager.getInstance().callbackJavascript(paramBridgeModule.getViolaInstance().getInstanceId(), paramBridgeModule.getModuleName(), "callback", paramString, localJSONObject, true);
        return;
      }
      catch (JSONException paramBridgeModule)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("isKindCard error");
          paramString.append(paramBridgeModule.getMessage());
          QLog.e("BridgeModuleHelper", 2, paramString.toString());
        }
      }
      return;
      label108:
      boolean bool = false;
    }
  }
  
  public static void n(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = k(paramJSONObject);
    if (paramJSONObject != null)
    {
      Fragment localFragment = paramBridgeModule.getViolaInstance().getFragment();
      if ((localFragment != null) && ((localFragment instanceof ViolaFragment)))
      {
        ((ViolaFragment)localFragment).setTitleConf(paramJSONObject, null);
        paramBridgeModule.invokeCallJS(paramString, null);
      }
    }
  }
  
  public static void o(BridgeModule paramBridgeModule, String paramString)
  {
    paramBridgeModule = paramBridgeModule.getViolaInstance().getContext();
    if (paramBridgeModule != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject = VideoFeedsWeiShiUtils.b(paramString);
      if (localObject != null)
      {
        ((DownloadInfo)localObject).b();
        DownloadManagerV2.a().b((DownloadInfo)localObject);
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        localObject = new Intent(paramBridgeModule, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("big_brother_source_key", RIJJumpUtils.a(0));
        ((Intent)localObject).putExtra("url", paramString.optString("url"));
        paramBridgeModule.startActivity((Intent)localObject);
        return;
      }
      catch (Exception paramBridgeModule)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("downloadApp error");
          paramString.append(paramBridgeModule.getMessage());
          QLog.e("BridgeModuleHelper", 2, paramString.toString());
        }
      }
    }
  }
  
  public static void o(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.optBoolean("enable", true);
    if ((paramBridgeModule.getViolaInstance() != null) && ((paramBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ((ViolaFragment)paramBridgeModule.getViolaInstance().getFragment()).enableFlingRight(bool);
      paramBridgeModule.invokeCallJS(paramString, new JSONObject());
      return;
    }
    paramBridgeModule.invokeErrorCallJS(paramString, HardCodeUtil.a(2131899443));
  }
  
  public static void p(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.optString("imageUrl");
      JSONObject localJSONObject = new JSONObject();
      boolean bool = TextUtils.isEmpty(paramJSONObject);
      if (!bool)
      {
        h(paramBridgeModule, paramJSONObject);
        localJSONObject.put("retCode", 0);
        paramBridgeModule.invokeCallJS(paramString, localJSONObject);
        return;
      }
      localJSONObject.put("retCode", 1);
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      QQToast.makeText(ReadInJoyUtils.b().getApplication(), 1, HardCodeUtil.a(2131899444), 0).show();
      return;
    }
    catch (Exception paramBridgeModule)
    {
      QLog.e("BridgeModuleHelper", 1, "sharePicMessage exception e = ", paramBridgeModule);
    }
  }
  
  public static void q(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramBridgeModule.getViolaInstance() != null) && ((paramBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment))) {
      ((ViolaFragment)paramBridgeModule.getViolaInstance().getFragment()).updateViolaPageByData(paramJSONObject);
    }
  }
  
  public static void r(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      Object localObject = DownloadManagerV2.a().b(paramJSONObject);
      int i = -1;
      int j = 0;
      if (localObject != null)
      {
        i = ((DownloadInfo)localObject).a();
        j = ((DownloadInfo)localObject).t;
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("state", i);
        ((JSONObject)localObject).put("data", j);
        paramBridgeModule.invokeCallJS(paramString, localObject);
      }
      catch (Exception paramBridgeModule)
      {
        paramString = new StringBuilder();
        paramString.append("getDownloadApkState error:");
        paramString.append(paramBridgeModule.getMessage());
        ViolaLogUtils.e("downloadApk", paramString.toString());
      }
      paramBridgeModule = new StringBuilder();
      paramBridgeModule.append("downloadApk getDownloadApkState :");
      paramBridgeModule.append(i);
      paramBridgeModule.append(" ,apkUrl : ");
      paramBridgeModule.append(paramJSONObject);
      ViolaLogUtils.d("BridgeModuleHelper", paramBridgeModule.toString());
    }
  }
  
  public static void s(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    ViolaSDKManager.getInstance().getDomManager().post(new BridgeModuleHelper.12(paramJSONObject, paramBridgeModule, paramString));
  }
  
  public static void t(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    label229:
    for (;;)
    {
      try
      {
        Object localObject2 = paramJSONObject.optJSONArray("imageIDs");
        int j = paramJSONObject.optInt("index");
        localObject1 = paramJSONObject.optString("srcID", "1");
        if (!"1".equals(localObject1)) {
          break label229;
        }
        localObject1 = "4";
        boolean bool = paramJSONObject.optBoolean("isNotShowIndex", true);
        if ((localObject2 != null) && (((JSONArray)localObject2).length() != 0))
        {
          paramJSONObject = new ArrayList();
          int i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            paramJSONObject.add(((JSONArray)localObject2).get(i).toString());
            i += 1;
            continue;
          }
          localObject2 = paramBridgeModule.getViolaInstance().getActivity();
          if (localObject2 != null)
          {
            TroopNoticeJsHandler.a((Activity)localObject2, j, paramJSONObject, null, null, false, bool, (String)localObject1, 100, null, null, null, null, "", true);
            paramBridgeModule.invokeCallJS(paramString, null);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("BridgeModuleHelper", 2, "imageList is null or length is 0");
          }
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("showPicture error");
          ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
          QLog.e("BridgeModuleHelper", 2, ((StringBuilder)localObject1).toString());
          paramBridgeModule.invokeErrorCallJS(paramString, null);
        }
      }
      return;
    }
  }
  
  public static void u(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Activity localActivity = paramBridgeModule.getViolaInstance().getActivity();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      if (!CheckPermission.isHasStoragePermission(localActivity))
      {
        CheckPermission.requestSDCardPermission((AppActivity)localActivity, new BridgeModuleHelper.13(paramBridgeModule, paramJSONObject, paramString));
        return;
      }
      v(paramBridgeModule, paramJSONObject, paramString);
    }
  }
  
  public static void v(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    try
    {
      localObject = paramJSONObject.getString("content");
      paramJSONObject = new StringBuilder();
      paramJSONObject.append((String)localObject);
      paramJSONObject.append("?client=androidQQ");
      paramJSONObject.append("&version=8.8.17.5770");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("&system=");
      ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
      paramJSONObject.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("&device=");
      ((StringBuilder)localObject).append(Build.DEVICE);
      paramJSONObject.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("&uin=");
      ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.d());
      paramJSONObject.append(((StringBuilder)localObject).toString());
      paramJSONObject = EmosmUtils.a("VIP_xingying", paramJSONObject.toString());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveImage imageUrl=");
        ((StringBuilder)localObject).append(paramJSONObject);
        QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(".jpg");
      localObject = ((StringBuilder)localObject).toString();
      ThreadManager.executeOnNetWorkThread(new BridgeModuleHelper.14(paramJSONObject, new File(AppConstants.SDCARD_IMG_SAVE, (String)localObject), paramBridgeModule, paramString));
      return;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveImage imageUrl error=");
        ((StringBuilder)localObject).append(paramJSONObject.getMessage());
        QLog.e("BridgeModuleHelper", 2, ((StringBuilder)localObject).toString());
      }
      paramBridgeModule.invokeErrorCallJS(paramString, "saveImage error");
    }
  }
  
  public static void w(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    ViolaAccessHelper.a(String.valueOf(paramJSONObject.optInt("bid", 3256)), new BridgeModuleHelper.15(paramBridgeModule, paramString));
  }
  
  public static void x(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray("bids");
    if (paramJSONObject != null)
    {
      Object localObject = new ArrayList();
      int i = 0;
      try
      {
        while (i < paramJSONObject.length())
        {
          ((ArrayList)localObject).add(i, paramJSONObject.get(i).toString());
          i += 1;
        }
        HtmlOffline.a((ArrayList)localObject, ReadInJoyUtils.b(), new BridgeModuleHelper.16(paramBridgeModule, paramString), true, false);
        return;
      }
      catch (Exception paramJSONObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("batchCheckUpdate error");
          ((StringBuilder)localObject).append(paramJSONObject.getMessage());
          QLog.e("BridgeModuleHelper", 2, ((StringBuilder)localObject).toString());
          paramBridgeModule.invokeErrorCallJS(paramString, null);
        }
      }
    }
  }
  
  public static void y(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
    {
      QLog.d("BridgeModuleHelper", 1, "Error in isCached, the param is null!");
      return;
    }
    paramJSONObject = HtmlOffline.d(paramJSONObject.optString("bid"));
    JSONObject localJSONObject = new JSONObject();
    if (paramJSONObject != null) {}
    try
    {
      localJSONObject.put("result", true);
      localJSONObject.put("version", paramJSONObject);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder;
      break label80;
    }
    localJSONObject.put("result", false);
    localJSONObject.put("version", "");
    break label122;
    label80:
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isCached,version:");
      localStringBuilder.append(paramJSONObject);
      QLog.d("BridgeModuleHelper", 2, localStringBuilder.toString());
    }
    label122:
    paramBridgeModule.invokeCallJS(paramString, localJSONObject);
  }
  
  public static void z(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    int i;
    if (paramJSONObject != null) {
      i = ViolaUtils.getInt(Integer.valueOf(paramJSONObject.optInt("allowCacheTime")));
    } else {
      i = -1;
    }
    paramJSONObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("webview");
    if (i > 0)
    {
      a(paramBridgeModule, paramJSONObject, "webview", paramString);
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.mLocation != null))
    {
      a(paramBridgeModule, paramJSONObject, "webview", paramString);
      return;
    }
    paramJSONObject = paramBridgeModule.getActivity();
    if ((paramJSONObject instanceof QBaseActivity))
    {
      paramJSONObject = (QBaseActivity)paramJSONObject;
      if (paramJSONObject.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        paramJSONObject.requestPermissions(new BridgeModuleHelper.19(paramBridgeModule, "webview", paramString), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      c(paramBridgeModule, "webview", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper
 * JD-Core Version:    0.7.0.1
 */