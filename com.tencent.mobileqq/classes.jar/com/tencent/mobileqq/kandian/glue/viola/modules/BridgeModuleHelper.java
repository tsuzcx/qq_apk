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
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentEntranceUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJUGCDianDian;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion;
import com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyMessagesActivity;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.IReadInJoyCaptureLauncher;
import com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.mobileqq.kandian.biz.video.api.impl.VideoFeedsWeiShiUtils;
import com.tencent.mobileqq.kandian.biz.viola.api.OnTitleChangeListener;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
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
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
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
import com.tencent.util.VersionUtils;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
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
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class BridgeModuleHelper
{
  public static void A(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
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
        HtmlOffline.a((ArrayList)localObject, ReadInJoyUtils.a(), new BridgeModuleHelper.13(paramBridgeModule, paramString), true, false);
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
  
  public static void B(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
    {
      QLog.d("BridgeModuleHelper", 1, "Error in isCached, the param is null!");
      return;
    }
    paramJSONObject = HtmlOffline.a(paramJSONObject.optString("bid"));
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
      break label74;
    }
    localJSONObject.put("result", false);
    localJSONObject.put("version", "");
    break label115;
    label74:
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isCached,version:");
      localStringBuilder.append(paramJSONObject);
      QLog.d("BridgeModuleHelper", 2, localStringBuilder.toString());
    }
    label115:
    paramBridgeModule.invokeCallJS(paramString, localJSONObject);
  }
  
  public static void C(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    int i;
    if (paramJSONObject != null) {
      i = ViolaUtils.getInt(Integer.valueOf(paramJSONObject.optInt("allowCacheTime")));
    } else {
      i = -1;
    }
    if (a())
    {
      if (i > 0)
      {
        b(paramBridgeModule, "webview", paramString);
        return;
      }
      c(paramBridgeModule, "webview", paramString);
      return;
    }
    d(paramBridgeModule, paramString, "no authorize");
  }
  
  public static void D(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramJSONObject == null) {
        return;
      }
      ReadInJoyUserInfoModule localReadInJoyUserInfoModule = a();
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
      localReadInJoyUserInfoModule.a(localArrayList, new BridgeModuleHelper.21(localArrayList, paramString, paramBridgeModule));
    }
  }
  
  private static int a()
  {
    if (StudyModeManager.a()) {
      return 8193;
    }
    return 1;
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
  
  private static Intent a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, int paramInt3, String paramString5, int paramInt4)
  {
    Intent localIntent = new Intent(QBaseActivity.sTopActivity, ReadInJoyDeliverBiuActivity.class);
    localIntent.putExtra("arg_article_info", paramAbsBaseArticleInfo);
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("biu_rowkey", paramString1);
    }
    localIntent.putExtra("arg_from_type", paramInt1);
    localIntent.putExtra("arg_type", paramInt2);
    localIntent.putExtra("result_js_callback", paramString2);
    localIntent.putExtra("biu_src", paramInt4);
    localIntent.putExtra("feed_id", paramString3);
    localIntent.putExtra("feedsType", paramLong1);
    localIntent.putExtra("ugc_comment", paramString4);
    localIntent.putExtra("arg_account_id", paramLong2);
    localIntent.putExtra("arg_account_type", paramInt3);
    localIntent.putExtra("arg_source_url", paramString5);
    return localIntent;
  }
  
  public static ReadInJoyUserInfoModule a()
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject == null) {
      return null;
    }
    localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject == null) {
      return null;
    }
    return ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().a();
  }
  
  public static QQCustomDialog a(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    QQCustomDialog localQQCustomDialog = null;
    if (paramJSONObject != null)
    {
      QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
      if (localQBaseActivity == null) {
        return null;
      }
      localQQCustomDialog = new QQCustomDialog(localQBaseActivity, 2131756189);
      localQQCustomDialog.setContentView(2131558954);
      localQQCustomDialog.getMessageTextView().setMovementMethod(new ScrollingMovementMethod());
      localQQCustomDialog.getMessageTextView().setMaxHeight(DisplayUtil.a(localQBaseActivity, 200.0F));
      localQQCustomDialog.setTitle(paramJSONObject.optString("title"));
      localQQCustomDialog.setMessage(paramJSONObject.optString("text"));
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      if (paramJSONObject.optBoolean("needOkBtn", true)) {
        localQQCustomDialog.setPositiveButton(paramJSONObject.optString("okBtnText", HardCodeUtil.a(2131701409)), new BridgeModuleHelper.4(paramJSONObject, paramBridgeModule, paramString));
      }
      if (paramJSONObject.optBoolean("needCancelBtn", true)) {
        localQQCustomDialog.setNegativeButton(paramJSONObject.optString("cancelBtnText", HardCodeUtil.a(2131701405)), new BridgeModuleHelper.5(paramJSONObject, paramBridgeModule, paramString));
      }
      localQQCustomDialog.show();
    }
    return localQQCustomDialog;
  }
  
  private static String a(int paramInt)
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
  
  private static String a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    String str1;
    if (paramJSONObject1 != null) {
      str1 = ViolaUtils.getString(paramJSONObject1.opt("toUin"), "");
    } else {
      str1 = "";
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
    {
      str2 = str1;
      if (paramJSONObject2 != null) {
        str2 = ViolaUtils.getString(paramJSONObject1.opt("toUin"), "");
      }
    }
    return str2;
  }
  
  private static HashMap<String, Object> a(JSONObject paramJSONObject)
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
  
  public static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = (QQAppInterface)ReadInJoyUtils.a();
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
    if (((QQAppInterface)ReadInJoyUtils.a() != null) && (paramActivity != null))
    {
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramActivity, "/base/album/photolist");
      localActivityURIRequest.extra().putInt("enter_from", 25);
      localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationReadInJoy.jdField_a_of_type_JavaLangString);
      localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationReadInJoy.jdField_a_of_type_JavaLangString);
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
          localStringBuilder.append(a(paramInt1));
          localStringBuilder.append(" result:");
          localStringBuilder.append(((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).replaceUrlInLog((String)localObject));
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
        ((StringBuilder)localObject).append(a(paramInt1));
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
      if (QBaseActivity.sTopActivity == null) {
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
        new Handler(QBaseActivity.sTopActivity.getMainLooper()).postDelayed(new BridgeModuleHelper.20(), 200L);
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
  
  private static void a(BridgeModule paramBridgeModule, String paramString, File paramFile)
  {
    Bundle localBundle = new Bundle();
    paramFile = new DownloadTask(paramString, paramFile);
    paramFile.d = 60L;
    ((DownloaderFactory)ReadInJoyUtils.a().getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).startDownload(paramFile, new BridgeModuleHelper.8(paramBridgeModule, paramString), localBundle);
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", GalleryReportedUtils.a(paramBridgeModule.getViolaInstance().getActivity()));
      localJSONObject.put("os", "1");
      localJSONObject.put("uin", String.valueOf(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin()));
      localJSONObject.put("rowkey", paramString1);
      if (paramInt1 >= 0) {
        localJSONObject.put("source", String.valueOf(paramInt1));
      }
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
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
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009546", "0X8009546", 0, 0, "", paramString4, paramString3, paramBridgeModule.a().a(), false);
      return;
    }
    if (paramInt4 == 11) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009546", "0X8009546", 0, 0, "", paramString5, "", paramBridgeModule.a().a(), false);
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString1, String paramString2, String paramString3)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        paramBridgeModule.invokeErrorCallJS(paramString2, HardCodeUtil.a(2131701410));
      }
      return;
    }
    if ((!paramString1.contains("weishi")) && (!paramString1.contains("weishi://feed")))
    {
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).launch(localQBaseActivity, paramString1))
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
        localQBaseActivity.startActivity(localIntent);
      }
    }
    else if (WeishiGuideUtils.a(localQBaseActivity))
    {
      VideoFeedsWeiShiUtils.a(localQBaseActivity, "video_type_videopublic");
    }
    else
    {
      QQToast.a(localQBaseActivity, -1, HardCodeUtil.a(2131701416), 0).b(localQBaseActivity.getResources().getDimensionPixelSize(2131299168));
      VideoFeedsWeiShiUtils.b(localQBaseActivity, "video_type_videopublic");
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramBridgeModule.invokeCallJS(paramString2, null);
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString1, String paramString2, boolean paramBoolean)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity == null) {
      return;
    }
    boolean bool;
    if ((!"weishi://feed".equals(paramString1)) && (!"weishi".equals(paramString1))) {
      bool = PackageUtil.a(localQBaseActivity, paramString1);
    } else {
      bool = WeishiGuideUtils.a(localQBaseActivity);
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
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    paramBridgeModule = new BridgeModuleHelper.15(paramBridgeModule, paramString);
    if (localQBaseActivity == null)
    {
      paramBridgeModule.a(null, new GdtAdError(5));
      return;
    }
    paramString = paramJSONObject.optString("posId", "1041305064862972");
    long l1 = paramJSONObject.optLong("publicId", 0L);
    long l2 = paramJSONObject.optLong("articleId", 0L);
    int i = paramJSONObject.optInt("sourceFrom", 0);
    int j = paramJSONObject.optInt("shareRate", 0);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).getMotiveAd(localQBaseActivity, paramString, l1, l2, i, j, paramBridgeModule);
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    QLog.d("BridgeModuleHelper", 2, "getGdtDeviceInfo callback before");
    AdThreadManager.INSTANCE.post(new BridgeModuleHelper.14(paramJSONObject, paramBoolean, paramBridgeModule, paramString), 4);
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
        paramFragment.a(paramJSONObject, new BridgeModuleHelper.17(paramBridgeModule, paramString));
        return;
      }
      if (((String)localObject).equals("left")) {
        paramFragment.b(paramJSONObject, new BridgeModuleHelper.18(paramBridgeModule, paramString));
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
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList != null)
      {
        paramJSONObject = (JSONObject)localObject;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.size() > 0)
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
      localObject = (QQAppInterface)ReadInJoyUtils.a();
      if (localObject != null) {
        ((ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), paramLong1, paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo, 0L, paramJSONObject, paramLong2, -1L, paramInt1, paramString, paramInt2, paramAbsBaseArticleInfo);
      }
      paramBridgeModule.onActivityResult(113, -1, paramIntent);
      return;
    }
    if (paramJSONObject.optInt("hideSuccessToast") != 1) {
      bool = false;
    }
    paramIntent.putExtra("hideSuccessToast", bool);
    QBaseActivity.sTopActivity.startActivityForResult(paramIntent, 113);
    QBaseActivity.sTopActivity.overridePendingTransition(0, 0);
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo = new UGCFeedsInfo();
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
        paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b = new ArrayList();
        paramString1 = new UGCVideoInfo();
        paramJSONObject = paramJSONObject.optJSONObject("ugcVideoInfo");
        if (paramJSONObject != null)
        {
          paramString1.d = paramJSONObject.optString("ugcVideoCoverUrl");
          paramString1.jdField_a_of_type_Long = paramJSONObject.optInt("ugcVideoDuration");
          paramString1.e = paramString2;
          paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.add(paramString1);
        }
      }
    }
    else
    {
      paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      paramString1 = new UGCPicInfo();
      paramJSONObject = paramJSONObject.optJSONArray("ugcPicInfo");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        paramString1.c = paramJSONObject.getJSONObject(0).optString("ugcPicUrl");
        paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.add(paramString1);
      }
    }
    if (paramInt2 == 22)
    {
      paramJSONObject = new AccountProfileInfo();
      paramJSONObject.jdField_a_of_type_JavaLangString = paramString3;
      paramJSONObject.b = paramString4;
      paramJSONObject.c = paramString5;
      paramJSONObject.jdField_a_of_type_Long = paramLong;
      paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAccountProfileInfo = paramJSONObject;
    }
    paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Int = paramInt1;
    paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_JavaLangString = paramAbsBaseArticleInfo.mTitle;
  }
  
  private static void a(File paramFile, String paramString)
  {
    ThreadManager.executeOnNetWorkThread(new BridgeModuleHelper.19(paramString, paramFile));
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addCategory("android.intent.category.BROWSABLE");
      localIntent.setData(Uri.parse(paramString));
      paramString = QBaseActivity.sTopActivity;
      if (paramString != null) {
        paramString.startActivity(localIntent);
      }
    }
  }
  
  public static void a(String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a(QBaseActivity.sTopActivity, paramString, paramBundle);
    }
  }
  
  /* Error */
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 119
    //   2: astore 6
    //   4: getstatic 207	com/tencent/mobileqq/app/QBaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   7: astore 8
    //   9: iconst_0
    //   10: istore_2
    //   11: iconst_0
    //   12: istore 4
    //   14: aload_1
    //   15: ldc_w 1335
    //   18: invokevirtual 132	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   21: istore_3
    //   22: aload_1
    //   23: ldc_w 1337
    //   26: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 5
    //   31: iload 4
    //   33: istore_2
    //   34: aload_1
    //   35: ldc_w 1339
    //   38: iconst_0
    //   39: invokevirtual 1020	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   42: istore 4
    //   44: iload 4
    //   46: istore_2
    //   47: aload_1
    //   48: ldc_w 1341
    //   51: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
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
    //   75: ldc 119
    //   77: astore_1
    //   78: goto +10 -> 88
    //   81: astore 5
    //   83: ldc 119
    //   85: astore_1
    //   86: iconst_0
    //   87: istore_3
    //   88: ldc 78
    //   90: iconst_1
    //   91: ldc_w 1343
    //   94: aload 5
    //   96: invokestatic 798	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload_1
    //   100: astore 5
    //   102: aload 6
    //   104: astore_1
    //   105: ldc_w 1024
    //   108: invokestatic 687	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   111: checkcast 1024	com/tencent/mobileqq/kandian/ad/api/IRIJAdService
    //   114: aload 8
    //   116: iload_3
    //   117: aload 5
    //   119: iload_2
    //   120: aload_0
    //   121: aload_1
    //   122: invokeinterface 1347 7 0
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
    //   7	108	8	localQBaseActivity	QBaseActivity
    // Exception table:
    //   from	to	target	type
    //   34	44	61	java/lang/Exception
    //   47	55	61	java/lang/Exception
    //   22	31	73	java/lang/Exception
    //   14	22	81	java/lang/Exception
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity != null) {
      ViolaAccessHelper.a(localQBaseActivity, paramJSONObject);
    }
  }
  
  private static void a(JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramJSONObject = paramJSONObject.optJSONArray("ugcAtLevelList");
    if (paramJSONObject != null)
    {
      paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo = new BiuInfo();
      paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
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
        paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo);
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
    paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo = new BiuInfo();
    paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong1);
    paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b = Long.valueOf(paramLong2);
    paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
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
        paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo);
        i += 1;
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString)
  {
    if (QBaseActivity.sTopActivity == null) {
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
    localObject = new Intent(QBaseActivity.sTopActivity, ReadInJoyDeliverUGCActivity.class);
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
    QBaseActivity.sTopActivity.startActivityForResult((Intent)localObject, 114);
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity == null) {
      return;
    }
    int n = paramJSONObject.optInt("type", 1);
    int j;
    int i;
    if (paramJSONObject.has("width"))
    {
      j = paramJSONObject.optInt("width");
      i = DisplayUtil.a(localQBaseActivity, j / 2);
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
      m = DisplayUtil.a(localQBaseActivity, k / 2);
    }
    else
    {
      m = 640;
      k = 640;
    }
    a(paramActivity, 1, n, (byte)118, i, m, j, k, paramString);
  }
  
  /* Error */
  public static void a(JSONObject paramJSONObject, String paramString, BridgeModule paramBridgeModule)
  {
    // Byte code:
    //   0: getstatic 207	com/tencent/mobileqq/app/QBaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: ldc_w 311
    //   11: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 26
    //   16: aload_0
    //   17: ldc_w 1462
    //   20: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 28
    //   25: aload_0
    //   26: ldc_w 1464
    //   29: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 30
    //   34: aload 30
    //   36: invokestatic 166	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: istore 8
    //   41: iload 8
    //   43: ifeq +10 -> 53
    //   46: ldc 119
    //   48: astore 30
    //   50: goto +3 -> 53
    //   53: lconst_0
    //   54: lstore 15
    //   56: new 853	java/lang/String
    //   59: dup
    //   60: aload 26
    //   62: iconst_0
    //   63: invokestatic 1064	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   66: invokespecial 1067	java/lang/String:<init>	([B)V
    //   69: astore 25
    //   71: new 853	java/lang/String
    //   74: dup
    //   75: aload 28
    //   77: iconst_0
    //   78: invokestatic 1064	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   81: invokespecial 1067	java/lang/String:<init>	([B)V
    //   84: astore 27
    //   86: aload_0
    //   87: ldc_w 1402
    //   90: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 29
    //   95: aload_0
    //   96: ldc_w 858
    //   99: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 31
    //   104: aload 29
    //   106: invokestatic 166	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifne +20 -> 129
    //   112: new 1404	java/math/BigInteger
    //   115: dup
    //   116: aload 29
    //   118: invokespecial 1405	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   121: invokevirtual 1408	java/math/BigInteger:longValue	()J
    //   124: lstore 9
    //   126: goto +6 -> 132
    //   129: lconst_0
    //   130: lstore 9
    //   132: aload_0
    //   133: ldc_w 1466
    //   136: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 26
    //   141: aload 26
    //   143: invokestatic 166	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   146: ifne +20 -> 166
    //   149: new 1404	java/math/BigInteger
    //   152: dup
    //   153: aload 26
    //   155: invokespecial 1405	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   158: invokevirtual 1408	java/math/BigInteger:longValue	()J
    //   161: lstore 11
    //   163: goto +6 -> 169
    //   166: lconst_0
    //   167: lstore 11
    //   169: aload_0
    //   170: ldc_w 1468
    //   173: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore 26
    //   178: aload 26
    //   180: invokestatic 166	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifne +20 -> 203
    //   186: new 1404	java/math/BigInteger
    //   189: dup
    //   190: aload 26
    //   192: invokespecial 1405	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   195: invokevirtual 1408	java/math/BigInteger:longValue	()J
    //   198: lstore 13
    //   200: goto +6 -> 206
    //   203: lconst_0
    //   204: lstore 13
    //   206: aload_0
    //   207: ldc_w 1470
    //   210: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   213: astore 26
    //   215: aload 26
    //   217: invokestatic 166	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifne +20 -> 240
    //   223: new 1404	java/math/BigInteger
    //   226: dup
    //   227: aload 26
    //   229: invokespecial 1405	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   232: invokevirtual 1408	java/math/BigInteger:longValue	()J
    //   235: lstore 19
    //   237: goto +6 -> 243
    //   240: lconst_0
    //   241: lstore 19
    //   243: aload_0
    //   244: ldc_w 1472
    //   247: invokevirtual 1075	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   250: lstore 17
    //   252: lload 17
    //   254: lstore 15
    //   256: aload_0
    //   257: ldc_w 1474
    //   260: invokevirtual 132	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   263: istore_3
    //   264: aload 27
    //   266: astore 28
    //   268: aload 29
    //   270: astore 26
    //   272: lload 17
    //   274: lstore 15
    //   276: aload 25
    //   278: astore 27
    //   280: lload 19
    //   282: lstore 21
    //   284: aload 31
    //   286: astore 25
    //   288: lload 9
    //   290: lstore 17
    //   292: lload 11
    //   294: lstore 19
    //   296: lload 21
    //   298: lstore 11
    //   300: lload 13
    //   302: lstore 9
    //   304: lload 17
    //   306: lstore 13
    //   308: lload 19
    //   310: lstore 17
    //   312: goto +228 -> 540
    //   315: astore 26
    //   317: lload 11
    //   319: lstore 17
    //   321: lload 15
    //   323: lstore 11
    //   325: aload 27
    //   327: astore 28
    //   329: lload 17
    //   331: lstore 15
    //   333: aload 25
    //   335: astore 27
    //   337: aload 31
    //   339: astore 25
    //   341: lload 9
    //   343: lstore 17
    //   345: lload 11
    //   347: lstore 9
    //   349: lload 19
    //   351: lstore 11
    //   353: goto +148 -> 501
    //   356: astore 26
    //   358: goto +8 -> 366
    //   361: astore 26
    //   363: lconst_0
    //   364: lstore 13
    //   366: lconst_0
    //   367: lstore 19
    //   369: lconst_0
    //   370: lstore 21
    //   372: aload 27
    //   374: astore 28
    //   376: lload 11
    //   378: lstore 15
    //   380: aload 25
    //   382: astore 27
    //   384: aload 31
    //   386: astore 25
    //   388: lload 9
    //   390: lstore 17
    //   392: lload 21
    //   394: lstore 9
    //   396: lload 19
    //   398: lstore 11
    //   400: goto +101 -> 501
    //   403: astore 26
    //   405: goto +8 -> 413
    //   408: astore 26
    //   410: lconst_0
    //   411: lstore 9
    //   413: lconst_0
    //   414: lstore 19
    //   416: lconst_0
    //   417: lstore 13
    //   419: lload 13
    //   421: lstore 11
    //   423: aload 27
    //   425: astore 28
    //   427: aload 25
    //   429: astore 27
    //   431: aload 31
    //   433: astore 25
    //   435: lload 9
    //   437: lstore 17
    //   439: lload 19
    //   441: lstore 9
    //   443: goto +58 -> 501
    //   446: astore 26
    //   448: aload 27
    //   450: astore 28
    //   452: aload 25
    //   454: astore 27
    //   456: goto +22 -> 478
    //   459: astore 26
    //   461: goto +13 -> 474
    //   464: astore 27
    //   466: aload 26
    //   468: astore 25
    //   470: aload 27
    //   472: astore 26
    //   474: aload 25
    //   476: astore 27
    //   478: lconst_0
    //   479: lstore 17
    //   481: lload 17
    //   483: lstore 9
    //   485: lload 9
    //   487: lstore 13
    //   489: lload 13
    //   491: lstore 11
    //   493: ldc 119
    //   495: astore 29
    //   497: aload 29
    //   499: astore 25
    //   501: aload 26
    //   503: invokevirtual 1172	java/lang/Exception:printStackTrace	()V
    //   506: aload 29
    //   508: astore 26
    //   510: iconst_0
    //   511: istore_3
    //   512: lload 15
    //   514: lstore 19
    //   516: lload 17
    //   518: lstore 21
    //   520: lload 13
    //   522: lstore 23
    //   524: lload 9
    //   526: lstore 15
    //   528: lload 19
    //   530: lstore 17
    //   532: lload 21
    //   534: lstore 13
    //   536: lload 23
    //   538: lstore 9
    //   540: aload_0
    //   541: ldc_w 1476
    //   544: lconst_1
    //   545: invokevirtual 1014	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   548: lstore 19
    //   550: aload_0
    //   551: ldc 198
    //   553: invokevirtual 132	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   556: istore 4
    //   558: aload_0
    //   559: ldc_w 1435
    //   562: invokevirtual 132	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   565: istore 5
    //   567: aload_0
    //   568: ldc_w 1478
    //   571: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   574: astore 32
    //   576: aload_0
    //   577: ldc_w 1480
    //   580: invokevirtual 132	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   583: istore 7
    //   585: new 853	java/lang/String
    //   588: dup
    //   589: aload_0
    //   590: ldc_w 1482
    //   593: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   596: iconst_0
    //   597: invokestatic 1064	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   600: invokespecial 1067	java/lang/String:<init>	([B)V
    //   603: astore 33
    //   605: aload_0
    //   606: ldc 238
    //   608: iconst_1
    //   609: invokevirtual 1020	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   612: istore 6
    //   614: new 1484	com/tencent/mobileqq/kandian/repo/db/struct/BaseArticleInfo
    //   617: dup
    //   618: invokespecial 1485	com/tencent/mobileqq/kandian/repo/db/struct/BaseArticleInfo:<init>	()V
    //   621: astore 31
    //   623: aload 31
    //   625: lload 17
    //   627: putfield 1488	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleID	J
    //   630: aload 31
    //   632: aload 27
    //   634: putfield 1256	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   637: aload 31
    //   639: aload 28
    //   641: putfield 1491	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   644: aload 31
    //   646: aload 32
    //   648: putfield 1262	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   651: aload 31
    //   653: iload 7
    //   655: putfield 1494	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoDuration	I
    //   658: aload 31
    //   660: lload 13
    //   662: putfield 1496	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedId	J
    //   665: aload 31
    //   667: aload 33
    //   669: putfield 1259	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSummary	Ljava/lang/String;
    //   672: aload 31
    //   674: lload 11
    //   676: putfield 1498	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:businessId	J
    //   679: aload 31
    //   681: iload 6
    //   683: putfield 1501	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedType	I
    //   686: aload 31
    //   688: aload 25
    //   690: putfield 1504	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   693: aload_0
    //   694: aload 31
    //   696: lload 9
    //   698: lload 19
    //   700: invokestatic 1506	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;JJ)V
    //   703: aload_0
    //   704: ldc_w 1508
    //   707: invokevirtual 1274	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   710: astore 34
    //   712: aload 34
    //   714: ifnull +190 -> 904
    //   717: iload 6
    //   719: lload 19
    //   721: invokestatic 1513	com/tencent/mobileqq/kandian/repo/common/RIJItemViewTypeUtils:a	(IJ)Z
    //   724: ifeq +180 -> 904
    //   727: aload 34
    //   729: ldc_w 1515
    //   732: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   735: astore 29
    //   737: aload 34
    //   739: ldc_w 1517
    //   742: iconst_0
    //   743: invokevirtual 1020	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   746: istore 4
    //   748: aload 31
    //   750: aload 34
    //   752: aload 29
    //   754: iload 4
    //   756: iload 5
    //   758: aload 27
    //   760: aload 28
    //   762: aload 32
    //   764: aload 33
    //   766: lload 15
    //   768: invokestatic 1519	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;Lorg/json/JSONObject;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   771: iload 4
    //   773: aload_0
    //   774: invokestatic 1521	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(ILorg/json/JSONObject;)I
    //   777: istore 4
    //   779: aload 29
    //   781: astore 27
    //   783: goto +3 -> 786
    //   786: aload 31
    //   788: getfield 1207	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   791: ldc 119
    //   793: putfield 1522	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   796: aload 31
    //   798: getfield 1207	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   801: ldc 119
    //   803: putfield 1523	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:c	Ljava/lang/String;
    //   806: aload 31
    //   808: getfield 1207	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   811: ldc 119
    //   813: putfield 1524	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:b	Ljava/lang/String;
    //   816: iload 5
    //   818: aload 30
    //   820: aload 31
    //   822: invokestatic 1527	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(ILjava/lang/String;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)Z
    //   825: ifeq +13 -> 838
    //   828: ldc 78
    //   830: iconst_1
    //   831: ldc_w 1529
    //   834: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: return
    //   838: iload 5
    //   840: invokestatic 1531	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(I)I
    //   843: istore 7
    //   845: aload 31
    //   847: aload_0
    //   848: aload 31
    //   850: aload 25
    //   852: iload 5
    //   854: iload 4
    //   856: aload_1
    //   857: aload 26
    //   859: iload 6
    //   861: i2l
    //   862: aload 27
    //   864: lload 15
    //   866: iload_3
    //   867: aload 30
    //   869: iload 7
    //   871: invokestatic 1533	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;JLjava/lang/String;JILjava/lang/String;I)Landroid/content/Intent;
    //   874: lload 13
    //   876: lload 17
    //   878: iload 7
    //   880: aload 25
    //   882: iload 6
    //   884: aload_2
    //   885: invokestatic 1535	com/tencent/mobileqq/kandian/glue/viola/modules/BridgeModuleHelper:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;Lorg/json/JSONObject;Landroid/content/Intent;JJILjava/lang/String;ILcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V
    //   888: return
    //   889: astore_0
    //   890: goto +4 -> 894
    //   893: astore_0
    //   894: ldc 78
    //   896: aload_0
    //   897: invokevirtual 456	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   900: invokestatic 1539	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   903: return
    //   904: ldc 119
    //   906: astore 27
    //   908: goto -122 -> 786
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	911	0	paramJSONObject	JSONObject
    //   0	911	1	paramString	String
    //   0	911	2	paramBridgeModule	BridgeModule
    //   263	604	3	i	int
    //   556	299	4	j	int
    //   565	288	5	k	int
    //   612	271	6	m	int
    //   583	296	7	n	int
    //   39	3	8	bool	boolean
    //   124	573	9	l1	long
    //   161	514	11	l2	long
    //   198	677	13	l3	long
    //   54	811	15	l4	long
    //   250	627	17	l5	long
    //   235	485	19	l6	long
    //   282	251	21	l7	long
    //   522	15	23	l8	long
    //   69	812	25	localObject1	Object
    //   14	257	26	localObject2	Object
    //   315	1	26	localException1	Exception
    //   356	1	26	localException2	Exception
    //   361	1	26	localException3	Exception
    //   403	1	26	localException4	Exception
    //   408	1	26	localException5	Exception
    //   446	1	26	localException6	Exception
    //   459	8	26	localException7	Exception
    //   472	386	26	localObject3	Object
    //   84	371	27	localObject4	Object
    //   464	7	27	localException8	Exception
    //   476	431	27	localObject5	Object
    //   23	738	28	localObject6	Object
    //   93	687	29	str1	String
    //   32	836	30	str2	String
    //   102	747	31	localObject7	Object
    //   574	189	32	str3	String
    //   603	162	33	str4	String
    //   710	41	34	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   243	252	315	java/lang/Exception
    //   256	264	315	java/lang/Exception
    //   206	237	356	java/lang/Exception
    //   169	200	361	java/lang/Exception
    //   132	163	403	java/lang/Exception
    //   104	126	408	java/lang/Exception
    //   86	104	446	java/lang/Exception
    //   71	86	459	java/lang/Exception
    //   56	71	464	java/lang/Exception
    //   567	712	889	org/json/JSONException
    //   717	779	889	org/json/JSONException
    //   786	828	889	org/json/JSONException
    //   7	41	893	org/json/JSONException
    //   56	71	893	org/json/JSONException
    //   71	86	893	org/json/JSONException
    //   86	104	893	org/json/JSONException
    //   104	126	893	org/json/JSONException
    //   132	163	893	org/json/JSONException
    //   169	200	893	org/json/JSONException
    //   206	237	893	org/json/JSONException
    //   243	252	893	org/json/JSONException
    //   256	264	893	org/json/JSONException
    //   501	506	893	org/json/JSONException
    //   540	567	893	org/json/JSONException
    //   828	837	893	org/json/JSONException
    //   838	888	893	org/json/JSONException
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a()
  {
    if (!VersionUtils.k()) {
      return true;
    }
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity == null) {
      return false;
    }
    return localQBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
  }
  
  private static boolean a(int paramInt, String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramInt == 23) && ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeName)));
  }
  
  public static JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    String str1 = DeviceInfoUtil.f();
    String str2 = DeviceInfoUtil.a();
    try
    {
      localJSONObject.put("imsi", ReadInJoyUtils.c());
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
        if (!ReadInJoyHelper.q()) {
          break label44;
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
      label44:
      int i = 0;
    }
  }
  
  private static void b(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(paramString1);
    if ((paramString1 != null) && (paramString1.mLocation != null))
    {
      b(paramBridgeModule, paramString1, paramString2);
      return;
    }
    d(paramBridgeModule, paramString2, "fail to get locationInfo from cache");
  }
  
  public static void b(BridgeModule paramBridgeModule, String paramString, JSONObject paramJSONObject)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("res", 1);
      paramJSONObject = paramJSONObject.optString("miniAppUrl");
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(localQBaseActivity, paramJSONObject, 2103, null))
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
      label83:
      break label83;
    }
    paramBridgeModule.invokeCallJS(paramString, localJSONObject);
  }
  
  public static void b(BridgeModule paramBridgeModule, String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject = b();
    if (paramBoolean)
    {
      paramBridgeModule.invokeCallJS(paramString, localJSONObject);
      return;
    }
    ViolaBridgeManager.getInstance().callbackJavascript(paramBridgeModule.getViolaInstance().getInstanceId(), paramBridgeModule.getModuleName(), "callback", paramString, localJSONObject, true);
  }
  
  public static void b(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
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
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("?client=androidQQ");
      ((StringBuilder)localObject).append("&version=8.7.0.5295");
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
      paramString.append(RIJQQAppInterfaceUtil.a());
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
  
  public static void b(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("code");
    Object localObject4 = paramJSONObject.optJSONObject("params");
    if ((!TextUtils.isEmpty(str)) && (localObject4 != null))
    {
      paramJSONObject = ((JSONObject)localObject4).optJSONObject("r2");
      Object localObject1 = ((JSONObject)localObject4).optJSONObject("r3");
      Object localObject2 = ((JSONObject)localObject4).optJSONObject("r4");
      Object localObject3 = ((JSONObject)localObject4).optJSONObject("r5");
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
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
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, (String)localObject4, str, str, 0, 0, paramJSONObject, (String)localObject1, (String)localObject2, (String)localObject3, false);
    }
  }
  
  public static void b(JSONObject paramJSONObject, String paramString)
  {
    if (QBaseActivity.sTopActivity == null) {
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
              break label266;
            }
            paramJSONObject.append(",");
            break label266;
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
        PublicFragmentActivity.a(QBaseActivity.sTopActivity, (Intent)localObject, ReadInJoySelectMemberAQFragment.class, 119);
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
      label266:
      i += 1;
    }
  }
  
  public static void b(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    Object localObject = QBaseActivity.sTopActivity;
    if (localObject == null) {
      return;
    }
    localObject = ((Context)localObject).getResources().getDisplayMetrics();
    int n = paramJSONObject.optInt("type");
    int i = Utils.rp2px(((DisplayMetrics)localObject).widthPixels, 360.0D);
    int j = Utils.rp2px(((DisplayMetrics)localObject).widthPixels, 200.0D);
    int k;
    int m;
    if (n == 1)
    {
      i = Utils.rp2px(((DisplayMetrics)localObject).widthPixels, 360.0D);
      j = i;
      k = 160;
      m = 160;
    }
    else
    {
      k = 750;
      m = 416;
    }
    if ((n == 1) || (n == 2)) {
      a(paramActivity, 2, 0, (byte)121, i, j, k, m, paramString);
    }
  }
  
  private static void b(JSONObject paramJSONObject, String paramString, BridgeModule paramBridgeModule)
  {
    ViolaBridgeManager.getInstance().callbackJavascript(paramBridgeModule.getViolaInstance().getInstanceId(), paramBridgeModule.getModuleName(), "callback", paramString, paramJSONObject, true);
  }
  
  public static JSONObject c()
  {
    int k = HttpUtil.getNetWorkType();
    String str = HttpUtil.getNetWorkTypeByStr();
    Object localObject = DeviceInfoUtil.b();
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
    ProtoUtils.a(ReadInJoyUtils.a(), new BridgeModuleHelper.2(paramBridgeModule, paramString), localReqBody.toByteArray(), "OidbSvc.0xe36", 3638, 1, new Bundle(), 5000L);
  }
  
  private static void c(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new BridgeModuleHelper.16(paramString1, paramBridgeModule, paramString2));
  }
  
  public static void c(BridgeModule paramBridgeModule, String paramString, boolean paramBoolean)
  {
    paramBridgeModule.invokeCallJS(paramString, c());
  }
  
  public static void c(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
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
  
  public static void c(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optString("apkUrl") != null) && (paramJSONObject.optInt("action", -1) != -1))
    {
      int i = paramJSONObject.optInt("action", -1);
      if (i == 1)
      {
        d(paramJSONObject);
        return;
      }
      if (i == 2)
      {
        e(paramJSONObject);
        return;
      }
      if (i == 3) {
        f(paramJSONObject);
      }
    }
  }
  
  public static void c(JSONObject paramJSONObject, String paramString)
  {
    paramString = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (paramJSONObject.optJSONObject("param") != null) {
      localBundle.putString("param", paramJSONObject.optJSONObject("param").toString());
    }
    ViolaAccessHelper.a(QBaseActivity.sTopActivity, "", paramString, localBundle);
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
            break label127;
          }
          bool = true;
          paramJSONObject.b(l, bool);
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
      label127:
      boolean bool = false;
    }
  }
  
  public static void d(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      DownloadManagerV2.a().a(paramJSONObject);
    }
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
      if (!ReadInJoyLogicEngine.a().a(i, j)) {
        ReadInJoyLogicEngine.a().d(i, j);
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
  
  public static void e(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.d = paramJSONObject;
      localDownloadInfo.m = "biz_src_feeds_kandianads";
      localDownloadInfo.a();
      DownloadManagerV2.a().b(localDownloadInfo);
    }
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
          if (((CommonSuspensionGestureLayout)localObject).a()) {
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
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity == null) {
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
      PublicFragmentActivity.a(localQBaseActivity, (Intent)localObject, ReadInJoyPrivacyListFragment.class);
      paramBridgeModule.invokeCallJS(paramString, null);
      return;
    }
    paramBridgeModule.invokeErrorCallJS(paramString, "params error");
  }
  
  public static void f(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      DownloadManagerV2.a().b(paramJSONObject, true);
    }
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
        QQToast.a(ReadInJoyUtils.a().getApplication(), 1, HardCodeUtil.a(2131701415), 0).a();
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
    Object localObject = (AppInterface)ReadInJoyUtils.a();
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
    if (RIJUGCDianDian.a() >= 2)
    {
      QQToast.a(paramBridgeModule, 0, paramBridgeModule.getString(2131717884), 0).b(paramBridgeModule.getResources().getDimensionPixelSize(2131299168));
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
    ((IReadInJoyCaptureLauncher)QRoute.api(IReadInJoyCaptureLauncher.class)).launchFromViolaForResult(paramBridgeModule, (Bundle)localObject, (byte)116);
    RIJUGCDianDian.a("2", "2");
  }
  
  public static void h(JSONObject paramJSONObject) {}
  
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
    boolean bool1 = paramJSONObject.optBoolean("enableAnonymous", false);
    boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
    int i = paramJSONObject.optInt("maxLength", -1);
    int j = paramJSONObject.optInt("commentType", 0);
    int k = paramJSONObject.optInt("sourceType", 0);
    int m = paramJSONObject.optInt("openAt", 0);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("defaultCommentAtLevel");
    Object localObject1 = paramJSONObject.optString("placeholder");
    try
    {
      localObject2 = new String(Base64Util.decode((String)localObject1, 0));
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      Object localObject2;
      label136:
      label247:
      break label136;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showCommentEditor | comment_placeholder decode error! | comment_placeholder: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.e("BridgeModuleHelper", 1, ((StringBuilder)localObject2).toString());
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showCommentEditor | comment_placeholder after decode: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = paramJSONObject.optString("defaultTxt");
    try
    {
      localObject3 = new String(Base64Util.decode((String)localObject2, 0));
      localObject2 = localObject3;
    }
    catch (Exception localException2)
    {
      Object localObject3;
      StringBuilder localStringBuilder;
      break label247;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("showCommentEditor | defaultTxt decode error! | defaultTxt: ");
    ((StringBuilder)localObject3).append((String)localObject2);
    QLog.e("BridgeModuleHelper", 1, ((StringBuilder)localObject3).toString());
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("showCommentEditor | defaultTxt after decode: ");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject3).toString());
    }
    localObject3 = new Intent();
    if (paramJSONObject.has("isPgcAuthor")) {
      ((Intent)localObject3).putExtra("comment_is_pgc_author", paramJSONObject.optBoolean("isPgcAuthor"));
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("#showCommentEditor bridge isPgcAuthor = ");
    localStringBuilder.append(paramJSONObject.optBoolean("isPgcAuthor", false));
    QLog.d("BridgeModuleHelper", 2, localStringBuilder.toString());
    ((Intent)localObject3).putExtra("comment_type", false);
    ((Intent)localObject3).putExtra("arg_comment_enable_anonymous", bool1);
    ((Intent)localObject3).putExtra("arg_comment_placeholder", (String)localObject1);
    ((Intent)localObject3).putExtra("arg_comment_default_txt", (String)localObject2);
    ((Intent)localObject3).putExtra("arg_comment_max_length", i);
    ((Intent)localObject3).putExtra("arg_comment_comment_type", j);
    ((Intent)localObject3).putExtra("arg_comment_source_type", k);
    ((Intent)localObject3).putExtra("arg_callback", paramString);
    ((Intent)localObject3).putExtra("arg_comment_open_at", m);
    ((Intent)localObject3).putExtra("comment_can_biu", bool2);
    ((Intent)localObject3).putExtra("public_fragment_window_feature", 1);
    if (localJSONArray != null) {
      ((Intent)localObject3).putExtra("arg_comment_default_comment_at", localJSONArray.toString());
    }
    ((IRIJCommentEntranceUtils)QRoute.api(IRIJCommentEntranceUtils.class)).startForResult(paramBridgeModule, (Intent)localObject3, 117);
  }
  
  public static void i(JSONObject paramJSONObject)
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
  
  public static void j(BridgeModule paramBridgeModule, String paramString)
  {
    Object localObject = QBaseActivity.sTopActivity;
    if (localObject == null) {
      return;
    }
    localObject = DeviceInfoUtil.a((Context)localObject);
    String str = DeviceInfoUtil.c();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qqVersion", str);
      localJSONObject.put("qqBuild", localObject);
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
  
  public static void j(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if (paramBridgeModule.getViolaInstance().getFragment() != null) {
      paramBridgeModule = paramBridgeModule.getViolaInstance().getFragment().getActivity();
    } else {
      paramBridgeModule = paramBridgeModule.getViolaInstance().getActivity();
    }
    boolean bool1;
    boolean bool2;
    int i;
    int j;
    int k;
    int m;
    JSONArray localJSONArray;
    Object localObject1;
    if (paramBridgeModule != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      bool1 = paramJSONObject.optBoolean("enableAnonymous", false);
      bool2 = paramJSONObject.optBoolean("canBiu", true);
      i = paramJSONObject.optInt("maxLength", -1);
      j = paramJSONObject.optInt("commentType", 0);
      k = paramJSONObject.optInt("sourceType", 0);
      m = paramJSONObject.optInt("openAt", 0);
      localJSONArray = paramJSONObject.optJSONArray("defaultCommentAtLevel");
      localObject1 = paramJSONObject.optString("placeholder");
    }
    try
    {
      localObject2 = new String(Base64Util.decode((String)localObject1, 0));
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      Object localObject2;
      label140:
      break label140;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showCommentEditorNative | comment_placeholder decode error! | comment_placeholder: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.e("BridgeModuleHelper", 1, ((StringBuilder)localObject2).toString());
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showCommentEditorNative | comment_placeholder after decode: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = paramJSONObject.optString("defaultTxt");
    try
    {
      localObject3 = new String(Base64Util.decode((String)localObject2, 0));
      localObject2 = localObject3;
    }
    catch (Exception localException2)
    {
      Object localObject3;
      label251:
      String str1;
      int n;
      int i1;
      String str4;
      String str2;
      long l;
      String str3;
      Intent localIntent;
      StringBuilder localStringBuilder;
      break label251;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("showCommentEditorNative | defaultTxt decode error! | defaultTxt: ");
    ((StringBuilder)localObject3).append((String)localObject2);
    QLog.e("BridgeModuleHelper", 1, ((StringBuilder)localObject3).toString());
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("showCommentEditorNative | defaultTxt after decode: ");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.d("BridgeModuleHelper", 2, ((StringBuilder)localObject3).toString());
    }
    localObject3 = paramJSONObject.optString("rowkey");
    str1 = paramJSONObject.optString("articleId");
    n = paramJSONObject.optInt("scene");
    i1 = paramJSONObject.optInt("entry");
    str4 = paramJSONObject.optString("businessInfo");
    str2 = paramJSONObject.optString("firstCommentId");
    l = paramJSONObject.optLong("repliedSubAuthorId");
    str3 = paramJSONObject.optString("repliedSubCommentId");
    localIntent = new Intent();
    if (paramJSONObject.has("isPgcAuthor")) {
      localIntent.putExtra("comment_is_pgc_author", paramJSONObject.optBoolean("isPgcAuthor"));
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("#showCommentEditorNative bridge isPgcAuthor = ");
    localStringBuilder.append(paramJSONObject.optBoolean("isPgcAuthor", false));
    QLog.d("BridgeModuleHelper", 2, localStringBuilder.toString());
    localIntent.putExtra("comment_type", false);
    localIntent.putExtra("arg_comment_enable_anonymous", bool1);
    localIntent.putExtra("arg_comment_placeholder", (String)localObject1);
    localIntent.putExtra("arg_comment_default_txt", (String)localObject2);
    localIntent.putExtra("arg_comment_max_length", i);
    localIntent.putExtra("arg_comment_comment_type", j);
    localIntent.putExtra("arg_comment_source_type", k);
    localIntent.putExtra("arg_callback", paramString);
    localIntent.putExtra("arg_comment_open_at", m);
    localIntent.putExtra("comment_can_biu", bool2);
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (localJSONArray != null) {
      localIntent.putExtra("arg_comment_default_comment_at", localJSONArray.toString());
    }
    if (str2.isEmpty())
    {
      paramJSONObject = new FirstCommentCreateData(i1, str4);
      paramJSONObject.b((String)localObject3);
      paramJSONObject.c(str1);
      paramJSONObject.b(n);
      localIntent.putExtra("comment_create_data", paramJSONObject);
    }
    else
    {
      paramJSONObject = new SubCommentCreateData(i1, str4);
      paramJSONObject.a(str2);
      paramJSONObject.b((String)localObject3);
      paramJSONObject.c(str1);
      paramJSONObject.a(l);
      paramJSONObject.e(str3);
      paramJSONObject.b(n);
      localIntent.putExtra("comment_create_data", paramJSONObject);
    }
    ((IRIJCommentEntranceUtils)QRoute.api(IRIJCommentEntranceUtils.class)).startForResult(paramBridgeModule, localIntent, 126);
  }
  
  public static void k(BridgeModule paramBridgeModule, String paramString)
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
  
  public static void k(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("type", 0);
    boolean bool1 = paramJSONObject.optBoolean("blackScene", false);
    boolean bool2 = paramJSONObject.optBoolean("isNightMode", false);
    String str = paramJSONObject.optString("avatarUrl", "");
    int j = paramJSONObject.optInt("bizType", 1);
    paramJSONObject = paramJSONObject.optString("uniqueID", "");
    RIJPushNotifyManager.Companion.a().showPushNotifyDialogForWeb(i, bool1, bool2, str, j, paramJSONObject, new BridgeModuleHelper.3(paramBridgeModule, paramString));
  }
  
  public static void l(BridgeModule paramBridgeModule, String paramString)
  {
    ThreadManager.post(new BridgeModuleHelper.9(paramBridgeModule, paramString), 8, null, true);
  }
  
  public static void l(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
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
  
  public static void m(BridgeModule paramBridgeModule, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("recommendFlag", a());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    paramBridgeModule.invokeCallJS(paramString, localJSONObject);
  }
  
  public static void m(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
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
      QQToast.a((Context)localObject, i, str, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131299168));
      paramBridgeModule.invokeCallJS(paramString, new JSONObject());
      return;
    }
    paramBridgeModule.invokeErrorCallJS(paramString, "text为null!!");
  }
  
  public static void n(BridgeModule paramBridgeModule, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", true);
    }
    catch (JSONException localJSONException)
    {
      label19:
      break label19;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModuleHelper", 2, "Error in isMobileQQ");
    }
    paramBridgeModule.invokeCallJS(paramString, localJSONObject);
  }
  
  public static void n(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
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
        a(str1, paramJSONObject);
        paramBridgeModule.invokeCallJS(paramString, null);
      }
    }
  }
  
  public static void o(BridgeModule paramBridgeModule, String paramString)
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
  
  public static void o(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
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
  
  public static void p(BridgeModule paramBridgeModule, String paramString)
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
        ((DownloadInfo)localObject).a();
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
  
  public static void p(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramJSONObject)) {
      return;
    }
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity != null) {
      ViolaAccessHelper.a(localQBaseActivity, paramJSONObject, new BridgeModuleHelper.6(paramBridgeModule, paramString));
    }
  }
  
  public static void q(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = a(paramJSONObject);
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
  
  public static void r(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.optBoolean("enable", true);
    if ((paramBridgeModule.getViolaInstance() != null) && ((paramBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ((ViolaFragment)paramBridgeModule.getViolaInstance().getFragment()).enableFlingRight(bool);
      paramBridgeModule.invokeCallJS(paramString, new JSONObject());
      return;
    }
    paramBridgeModule.invokeErrorCallJS(paramString, HardCodeUtil.a(2131701418));
  }
  
  public static void s(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
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
      QQToast.a(ReadInJoyUtils.a().getApplication(), 1, HardCodeUtil.a(2131701419), 0).a();
      return;
    }
    catch (Exception paramBridgeModule)
    {
      QLog.e("BridgeModuleHelper", 1, "sharePicMessage exception e = ", paramBridgeModule);
    }
  }
  
  public static void t(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramBridgeModule.getViolaInstance() != null) && ((paramBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment))) {
      ((ViolaFragment)paramBridgeModule.getViolaInstance().getFragment()).updateViolaPageByData(paramJSONObject);
    }
  }
  
  public static void u(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
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
        j = ((DownloadInfo)localObject).f;
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
  
  public static void v(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localObject != null)
    {
      if (localQBaseActivity == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramJSONObject.optString("id"));
      localStringBuilder.append("|");
      localStringBuilder.append(paramJSONObject.optString("subid"));
      localStringBuilder.append("|");
      localStringBuilder.append(paramJSONObject.optString("content"));
      localStringBuilder.append("|");
      localStringBuilder.append("ANDROID");
      localStringBuilder.append("|");
      localStringBuilder.append("8.7.0.5295");
      localStringBuilder.append("|");
      localStringBuilder.append(DeviceInfoUtil.e());
      localStringBuilder.append("|");
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
      localStringBuilder.append("|");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append("|");
      boolean bool = TextUtils.isEmpty(DeviceInfoUtil.a(localQBaseActivity).c);
      String str = "未知";
      if (bool) {
        localObject = "未知";
      } else {
        localObject = DeviceInfoUtil.a(localQBaseActivity).c;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("|");
      if (TextUtils.isEmpty(DeviceInfoUtil.a(localQBaseActivity).jdField_a_of_type_JavaLangString)) {
        localObject = str;
      } else {
        localObject = DeviceInfoUtil.a(localQBaseActivity).jdField_a_of_type_JavaLangString;
      }
      localStringBuilder.append((String)localObject);
      if (paramJSONObject.optBoolean("isall", false))
      {
        QLog.w("ViolaLog", 1, localStringBuilder.toString());
        paramBridgeModule.invokeCallJS(paramString, null);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.w("ViolaLog", 2, localStringBuilder.toString());
        paramBridgeModule.invokeCallJS(paramString, null);
      }
    }
  }
  
  public static void w(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
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
  
  public static void x(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Activity localActivity = paramBridgeModule.getViolaInstance().getActivity();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      if (!CheckPermission.isHasStoragePermission(localActivity))
      {
        CheckPermission.requestSDCardPermission((AppActivity)localActivity, new BridgeModuleHelper.10(paramBridgeModule, paramJSONObject, paramString));
        return;
      }
      y(paramBridgeModule, paramJSONObject, paramString);
    }
  }
  
  public static void y(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    try
    {
      localObject = paramJSONObject.getString("content");
      paramJSONObject = new StringBuilder();
      paramJSONObject.append((String)localObject);
      paramJSONObject.append("?client=androidQQ");
      paramJSONObject.append("&version=8.7.0.5295");
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
      ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.a());
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
      ThreadManager.executeOnNetWorkThread(new BridgeModuleHelper.11(paramJSONObject, new File(AppConstants.SDCARD_IMG_SAVE, (String)localObject), paramBridgeModule, paramString));
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
  
  public static void z(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    ViolaAccessHelper.a(String.valueOf(paramJSONObject.optInt("bid", 3256)), new BridgeModuleHelper.12(paramBridgeModule, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper
 * JD-Core Version:    0.7.0.1
 */