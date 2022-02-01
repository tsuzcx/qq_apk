package com.tencent.mobileqq.utils;

import QQWalletPay.ReqCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.dataline.activities.LiteActivity;
import com.etrump.mixlayout.FontManager;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.av.VideoController;
import com.tencent.av.share.api.IShareChatApi;
import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.accountdetail.api.IEqqAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.ProfileParams.Builder;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.DiscoverBannerPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryHomeJumpHelper;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.biz.widgets.QQMapRoutingHelper;
import com.tencent.comic.api.IQQComicConfigApi;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceScanner;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.SearchMightKnowFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TranslucentTRansferFragment;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingFragment;
import com.tencent.mobileqq.activity.activateFriend.QQReminderJumpFragment;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARGlobalConfigManager;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.config.business.OpenSdkD55Processor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardD55Manager;
import com.tencent.mobileqq.forward.ForwardSdkStatusManager;
import com.tencent.mobileqq.forward.ForwardShareByServerHelper;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpAction;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.miniapp.util.MiniAppJumpUtil;
import com.tencent.mobileqq.nearby.INearbyFaceScoreManager;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.now.ISmallVideoFragmentUtil;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.mobileqq.now.NowQQLiveHelper;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qqconnectface.IIdentificationApi;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.qwallet.jump.IWXMiniProgramHelper;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.settings.message.AssistantSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studyroom.StudyRoomManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.troop.data.NearbyTroops;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopphoto.api.ITroopPhotoHandler;
import com.tencent.mobileqq.troop.utils.NearbyVideoChatManager;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vashealth.api.ISportManager;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqp.app.sec.SecShareInfoUtil;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.ToastUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianWebViewFragment;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import com.tencent.util.QQDeviceInfo;
import com.tencent.util.URLUtil;
import com.tencent.util.VersionUtils;
import common.config.service.QzoneConfig;
import cooperation.plugin.PluginInfo;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.util.QzoneAuthorizeConfig;
import cooperation.troop.NearbyVideoChatProxyActivity;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageCmd;
import cooperation.troop.TroopManageProxyActivity;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JumpActionLegacy
  extends JumpAction
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.mobileqq" };
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public ChatActivityUtils.StartVideoListener a;
  public final QQAppInterface a;
  private QWalletAuthObserver jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver;
  public JumpActionLegacy.CustomHeadObserver a;
  private JumpActionLegacy.QWalletAuthMsgHandler jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy$QWalletAuthMsgHandler;
  public QQProgressDialog a;
  QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new JumpActionLegacy.12(this);
  
  public JumpActionLegacy(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy$CustomHeadObserver = new JumpActionLegacy.CustomHeadObserver(this, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener = new JumpActionLegacy.24(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean A()
  {
    int i;
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("mini_appid")) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("fakeUrl"))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return MiniAppLauncher.launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    return ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, 2016, null, null);
  }
  
  private boolean B()
  {
    boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("app");
    String str2 = null;
    String str1;
    if (bool) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app");
    } else {
      str1 = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("type")) {
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
    }
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      ((AppletsFolderManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, str1, str2);
    }
    return true;
  }
  
  private boolean C()
  {
    boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("entry");
    String str2 = null;
    String str1;
    if (bool) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("entry");
    } else {
      str1 = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("seq")) {
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("seq");
    }
    long l2 = 0L;
    long l1 = l2;
    if (!TextUtils.isEmpty(str2)) {
      l1 = l2;
    }
    try
    {
      l2 = Long.valueOf(str2).longValue();
      l1 = l2;
      VACDReportUtil.a(l2, "", "jumpParse", null, 0, null);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label108:
      Bundle localBundle;
      break label108;
    }
    str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
    if ((!"1".equals(str2)) && (!"2".equals(str2)) && (!"3".equals(str2)) && (!"4".equals(str2)) && (!"5".equals(str2)) && (!"6".equals(str2)) && (!"7".equals(str2)) && (!"9".equals(str2)) && (!"10".equals(str2)) && (!"11".equals(str2)))
    {
      if ("8".equals(str2)) {
        return a(str2, str1, l1);
      }
      return false;
    }
    localBundle = new Bundle();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tokenid")) {
      localBundle.putString("tokenid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("tokenid"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("data")) {
      localBundle.putString("data", (String)this.jdField_a_of_type_JavaUtilHashMap.get("data"));
    }
    return a(str2, str1, l1, localBundle);
  }
  
  private boolean D()
  {
    if (this.jdField_c_of_type_JavaLangString.equals("publish")) {
      return bb();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("writemood")) {
      return bf();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("to_publish_queue")) {
      return bg();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("open_homepage")) {
      return bh();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("groupalbum")) {
      return aW();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("to_friend_feeds")) {
      return i_();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("to_qzone_dialog")) {
      return aX();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("to_redpocket_share")) {
      return bc();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("open_redpocket")) {
      return bd();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("qzone_schema")) {
      return aY();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("shareLogToQQ")) {
      return be();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("qzone_publicaccount")) {
      return aZ();
    }
    return false;
  }
  
  private boolean E()
  {
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))) {
      l = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    }
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))) {
      m = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
    }
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openkey"))) {
      o = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openkey");
    }
    if ("true".equals(this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"))) {
      return aL();
    }
    return aP();
  }
  
  private boolean F()
  {
    if (this.jdField_c_of_type_JavaLangString.equals("emoji"))
    {
      EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 7);
      return true;
    }
    if (this.jdField_c_of_type_JavaLangString.equals("emoji_detail"))
    {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4, b("detailid"));
      return true;
    }
    if (this.jdField_c_of_type_JavaLangString.equals("emoji_author"))
    {
      EmojiHomeUiPlugin.openEmojiAuthorPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 5, b("authorid"));
      return true;
    }
    if (this.jdField_c_of_type_JavaLangString.equals("bubble"))
    {
      VasWebviewUtil.b(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, null, false, -1);
      return true;
    }
    if (this.jdField_c_of_type_JavaLangString.equals("theme"))
    {
      if ((BaseApplicationImpl.IS_SUPPORT_THEME) && (Utils.a()))
      {
        VasWebviewUtil.b(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, null, false, -1);
        return true;
      }
    }
    else if (this.jdField_c_of_type_JavaLangString.equals("font"))
    {
      if ((((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).c()) && (Utils.a()))
      {
        VasWebviewUtil.b(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "font", ""), 4096L, null, false, -1);
        return true;
      }
    }
    else
    {
      if (this.jdField_c_of_type_JavaLangString.equals("pendant"))
      {
        if (Utils.a()) {
          AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
        }
        return true;
      }
      if (this.jdField_c_of_type_JavaLangString.equals("individuation"))
      {
        VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext);
        return true;
      }
      if (this.jdField_c_of_type_JavaLangString.equals("apollo_store"))
      {
        Intent localIntent = new Intent();
        String[] arrayOfString = this.jdField_a_of_type_JavaLangString.split("\\?");
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (arrayOfString.length >= 2)
        {
          localIntent.putExtra("extra_key_url_append", arrayOfString[1]);
          localObject1 = localObject2;
          if (arrayOfString[1] != null) {
            if (arrayOfString[1].contains("tab=game_center"))
            {
              localObject1 = localObject2;
            }
            else
            {
              if (arrayOfString[1].contains("tab=other_url&url="))
              {
                localObject1 = URLDecoder.decode(arrayOfString[1].substring(arrayOfString[1].indexOf("tab=other_url&url=") + 18));
                i = 1;
                break label498;
              }
              localObject1 = new HashMap();
              StoryShareEncryptHelper.a(arrayOfString[1], (HashMap)localObject1);
              localObject1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getStoreTabUrl((String)((HashMap)localObject1).get("tab"), true);
            }
          }
        }
        int i = 0;
        label498:
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, new Object[] { "apollo_store url:", localObject1 });
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = ApolloConstant.z;
        }
        if (i != 0) {
          ((IApolloUtil)QRoute.api(IApolloUtil.class)).openWebViewActivity(this.jdField_a_of_type_AndroidContentContext, (String)localObject2);
        } else {
          ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_AndroidContentContext, localIntent, null, (String)localObject2, null);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localObject1 != null)
        {
          localObject1 = (IApolloManagerService)((QQAppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all");
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "action_clk", ((IApolloManagerService)localObject1).getApolloStatus(((QQAppInterface)localObject2).getCurrentUin()), 0, new String[] { "0" });
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean G()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "enter jiankang");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("JumpAction", 1, "app is null");
      return false;
    }
    ThreadManager.post(new JumpActionLegacy.4(this), 5, null, true);
    Object localObject1;
    if ((Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor")).getDefaultSensor(19) != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject1 != null) {
        ((ISportManager)((QQAppInterface)localObject1).getRuntimeService(ISportManager.class, "multi")).refreshCurrentStep("jump action");
      }
    }
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if ((localObject2 != null) && ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://"))))
    {
      if ((!Util.b((String)localObject2).equalsIgnoreCase("qq.com")) && (!Util.b((String)localObject2).equalsIgnoreCase("myun.tenpay.com")) && (!Util.b((String)localObject2).equalsIgnoreCase("tenpay.com")) && (!Util.b((String)localObject2).equalsIgnoreCase("wanggou.com"))) {
        return false;
      }
      localObject1 = localObject2;
      if (((String)localObject2).indexOf("?") <= 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("?");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder((String)localObject1);
      ((StringBuilder)localObject2).append("&client=androidQQ");
      ((StringBuilder)localObject2).append("&uin=");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append("&version=");
      ((StringBuilder)localObject2).append("8.7.0.5295");
      ((StringBuilder)localObject2).append("&system=");
      ((StringBuilder)localObject2).append(Build.VERSION.RELEASE);
      ((StringBuilder)localObject2).append("&device=");
      ((StringBuilder)localObject2).append(Build.DEVICE);
      ((StringBuilder)localObject2).append("&density=");
      ((StringBuilder)localObject2).append(ThemeUtil.getThemeDensity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()));
      ((StringBuilder)localObject2).append("&platformId=2");
      ((StringBuilder)localObject2).append("&_lv=0");
      ((StringBuilder)localObject2).append("&hasRedDot=");
      if (this.jdField_d_of_type_Boolean) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&adtag=mvip.gongneng.anroid.health.nativet");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      ((StringBuilder)localObject2).append("&lati=");
      ((StringBuilder)localObject2).append(((SharedPreferences)localObject1).getFloat(SearchProtocol.jdField_b_of_type_JavaLangString, 0.0F));
      ((StringBuilder)localObject2).append("&logi=");
      ((StringBuilder)localObject2).append(((SharedPreferences)localObject1).getFloat(SearchProtocol.jdField_c_of_type_JavaLangString, 0.0F));
      int i = NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&netType=");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      localObject1 = DeviceInfoUtil.d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("&model=");
      localStringBuilder.append((String)localObject1);
      ((StringBuilder)localObject2).append(localStringBuilder.toString());
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString());
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
    return false;
  }
  
  private boolean H()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sourceUrl");
    Object localObject1;
    if (this.jdField_c_of_type_JavaLangString.equals("web")) {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
    }
    try
    {
      Object localObject2 = URLDecoder.decode((String)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("url", (String)localObject2);
      ((Bundle)localObject1).putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Bundle)localObject1).putBoolean("hide_operation_bar", true);
      ((Bundle)localObject1).putBoolean("hideRightButton", true);
      localObject2 = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/pubaccount/browser");
      ((ActivityURIRequest)localObject2).extra().putAll((Bundle)localObject1);
      QRoute.startUri((URIRequest)localObject2, null);
    }
    catch (Exception localException)
    {
      label142:
      break label142;
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("JumpAction", 4, "URLDecoder.decode error");
    }
    return false;
    if ((str1 != null) && (str2 != null)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_tribe", "", "url", "visit", 0, 1, 0, str1, Util.b(str2, new String[0]), "", "");
    }
    return true;
  }
  
  private boolean I()
  {
    Object localObject1;
    Object localObject2;
    if ("opendetail".equals(this.jdField_c_of_type_JavaLangString))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("key_launch_time", System.currentTimeMillis());
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      if ((localObject2 == null) || ("".equals(localObject2)) || (((String)localObject2).length() < 5)) {}
    }
    try
    {
      ((Bundle)localObject1).putLong("key_current_feeduin", Long.valueOf((String)localObject2).longValue());
      label83:
      ((Bundle)localObject1).putString("key_current_feed_cellid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("cellid"));
      ((Bundle)localObject1).putInt("key_request_from", 3);
      ((Bundle)localObject1).putInt("key_weishi_entrance_type", 19);
      ((Bundle)localObject1).putInt("key_request_business_type", 8);
      a((Bundle)localObject1);
      break label1188;
      return false;
      if ("takevideo".equals(this.jdField_c_of_type_JavaLangString))
      {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("widgetid");
        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("activity_id");
        Object localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shareto");
        Object localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cmode");
        String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("widgetinfo");
        String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cake_id");
        String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nick");
        String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("preview");
        String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("toUin");
        Bundle localBundle = new Bundle();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localBundle.putString("KEY_CURRENT_SELECT_ID", (String)localObject1);
        }
        localBundle = ((IJumpUtil)QRoute.api(IJumpUtil.class)).handleWidgetInfo(localBundle, str5);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("【widgetid】:");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("【");
        localStringBuilder.append("from");
        localStringBuilder.append("】:");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("【");
        localStringBuilder.append("activity_id");
        localStringBuilder.append("】:");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append("【");
        localStringBuilder.append("shareto");
        localStringBuilder.append("】:");
        localStringBuilder.append((String)localObject5);
        localStringBuilder.append("【");
        localStringBuilder.append("cmode");
        localStringBuilder.append("】:");
        localStringBuilder.append((String)localObject4);
        localStringBuilder.append("【");
        localStringBuilder.append("widgetinfo");
        localStringBuilder.append("】:");
        localStringBuilder.append(str5);
        AEQLog.b("JumpAction", localStringBuilder.toString());
        localObject5 = localObject3;
        localObject1 = localObject4;
        try
        {
          int i = AECameraEntry.a((String)localObject2).a();
          localObject5 = localObject3;
          localObject1 = localObject4;
          a(localBundle, i);
          localObject2 = localObject3;
          localObject5 = localObject3;
          localObject1 = localObject4;
          if (i == AECameraEntry.n.a()) {
            localObject2 = "qzone_takesame";
          }
          localObject3 = localObject4;
          localObject5 = localObject2;
          localObject1 = localObject4;
          if (i == AECameraEntry.J.a())
          {
            localObject3 = "arCake";
            localObject5 = localObject2;
            localObject1 = localObject3;
            localBundle.putString("KEY_CURRENT_SELECT_ID", null);
            localObject5 = localObject2;
            localObject1 = localObject3;
            localBundle.putString("KEY_ARCAKE_ID", str1);
            localObject5 = localObject2;
            localObject1 = localObject3;
            ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_arcake_id", str1, 4);
            localObject5 = localObject2;
            localObject1 = localObject3;
            ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_arcake_nick", str2, 4);
            localObject5 = localObject2;
            localObject1 = localObject3;
            ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_arcake_preview", str3, 4);
            localObject5 = localObject2;
            localObject1 = localObject3;
            ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_arcake_touin", str4, 4);
            localObject5 = localObject2;
            localObject1 = localObject3;
            localObject4 = new StringBuilder();
            localObject5 = localObject2;
            localObject1 = localObject3;
            ((StringBuilder)localObject4).append("arcake arCakeID : ");
            localObject5 = localObject2;
            localObject1 = localObject3;
            ((StringBuilder)localObject4).append(str1);
            localObject5 = localObject2;
            localObject1 = localObject3;
            ((StringBuilder)localObject4).append("fromnick : ");
            localObject5 = localObject2;
            localObject1 = localObject3;
            ((StringBuilder)localObject4).append(str2);
            localObject5 = localObject2;
            localObject1 = localObject3;
            ((StringBuilder)localObject4).append(" preview ");
            localObject5 = localObject2;
            localObject1 = localObject3;
            ((StringBuilder)localObject4).append(str3);
            localObject5 = localObject2;
            localObject1 = localObject3;
            ((StringBuilder)localObject4).append(" toNickUin ");
            localObject5 = localObject2;
            localObject1 = localObject3;
            ((StringBuilder)localObject4).append(str4);
            localObject5 = localObject2;
            localObject1 = localObject3;
            AEQLog.b("JumpAction", ((StringBuilder)localObject4).toString());
          }
          localObject4 = localObject3;
          localObject5 = localObject2;
          localObject1 = localObject3;
          if (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isAddPlayShowEntry(i)) {
            localObject4 = "cameraAndPlay";
          }
          localObject5 = localObject2;
          localObject1 = localObject4;
          localBundle.putInt("VIDEO_STORY_FROM_TYPE", i);
        }
        catch (Exception localException4)
        {
          localObject2 = localObject5;
          localObject4 = localObject1;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Invalid VIDEO_STORY_FROM_TYPE format: ");
            ((StringBuilder)localObject2).append(localException4.getMessage());
            QLog.e("JumpAction", 2, ((StringBuilder)localObject2).toString());
            localObject4 = localObject1;
            localObject2 = localObject5;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          try
          {
            localBundle.putString("VIDEO_STORY_ACTIVITY_ID", (String)localObject2);
          }
          catch (Exception localException1)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Invalid VIDEO_STORY_ACTIVITY_ID format: ");
              ((StringBuilder)localObject2).append(localException1.getMessage());
              QLog.e("JumpAction", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          try
          {
            localBundle.putInt("AECAMERA_MODE", ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).switchModeToInt((String)localObject4));
          }
          catch (Exception localException2)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Invalid AECAMERA_MODE format: ");
              ((StringBuilder)localObject2).append(localException2.getMessage());
              QLog.e("JumpAction", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        ((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).launchAECameraUnit((Activity)this.jdField_a_of_type_AndroidContentContext, 120, localBundle);
      }
      label1188:
      return true;
    }
    catch (Exception localException3)
    {
      break label83;
    }
  }
  
  private boolean J()
  {
    ((IWXMiniProgramHelper)QRoute.api(IWXMiniProgramHelper.class)).launchMiniProgram(this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  private boolean K()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication());
    int i = 0;
    if (!bool)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694425, 1).a();
      return false;
    }
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("params")) {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");
    } else {
      str = "";
    }
    try
    {
      Object localObject2 = new JSONObject(new String(Base64Util.decode(str, 0)));
      localObject1 = ((JSONObject)localObject2).optString("keyword");
      JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("groupmask");
      long[] arrayOfLong = new long[localJSONArray.length()];
      while (i < localJSONArray.length())
      {
        arrayOfLong[i] = localJSONArray.optLong(i);
        i += 1;
      }
      localObject2 = ((JSONObject)localObject2).optString("groupname");
      ActiveEntitySearchActivity.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, (String)localObject2, arrayOfLong);
      return true;
    }
    catch (JSONException localJSONException)
    {
      Object localObject1;
      label164:
      break label164;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("参数解析成json错误.  params=");
    ((StringBuilder)localObject1).append(str);
    QLog.e("JumpActionQ.uniteSearch.", 2, ((StringBuilder)localObject1).toString());
    return true;
  }
  
  private boolean L()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication());
    int j = 0;
    if (!bool)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694425, 1).a();
      return false;
    }
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("invitorId");
    int i = 10;
    try
    {
      k = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("roomNum"));
      i = k;
    }
    catch (Exception localException1)
    {
      int k;
      label69:
      label88:
      long l1;
      break label69;
    }
    try
    {
      k = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("zoneId"));
      j = k;
    }
    catch (Exception localException2)
    {
      break label88;
    }
    l1 = -1L;
    try
    {
      long l2 = Long.parseLong((String)this.jdField_a_of_type_JavaUtilHashMap.get("gc"));
      l1 = l2;
    }
    catch (Exception localException3)
    {
      label115:
      Intent localIntent;
      break label115;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("roomNum", i);
      ((Intent)localObject).putExtra("action", 3);
      ((Intent)localObject).putExtra("zoneId", j);
      ((Intent)localObject).putExtra("gc", l1);
      RouteUtils.a(BaseApplicationImpl.getContext(), (Intent)localObject, "/nearby/gameroom/trans");
      return true;
    }
    localIntent = new Intent();
    localIntent.putExtra("inviteId", (String)localObject);
    localIntent.putExtra("roomNum", i);
    localIntent.putExtra("zoneId", j);
    localIntent.putExtra("action", 2);
    RouteUtils.a(BaseApplicationImpl.getContext(), localIntent, "/nearby/gameroom/trans");
    return true;
  }
  
  private boolean M()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication());
    int j = 0;
    if (!bool)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694425, 1).a();
      return false;
    }
    int i = 10;
    try
    {
      k = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("roomNum"));
      i = k;
    }
    catch (Exception localException1)
    {
      int k;
      label54:
      label73:
      Intent localIntent;
      break label54;
    }
    try
    {
      k = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("zoneId"));
      j = k;
    }
    catch (Exception localException2)
    {
      break label73;
    }
    localIntent = new Intent();
    localIntent.putExtra("roomNum", i);
    localIntent.putExtra("zoneId", j);
    localIntent.putExtra("action", 1);
    RouteUtils.a(BaseApplicationImpl.getContext(), localIntent, "/nearby/gameroom/trans");
    return true;
  }
  
  private boolean N()
  {
    boolean bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("token");
    if (!TextUtils.isEmpty(str))
    {
      StoryShareEncryptHelper.a(this.jdField_a_of_type_AndroidContentContext, str, new JumpActionLegacy.5(this), null);
    }
    else if (TextUtils.equals(this.jdField_c_of_type_JavaLangString, "publish"))
    {
      O();
    }
    else
    {
      if (bool)
      {
        this.jdField_c_of_type_JavaLangString = "open";
        StoryShareEncryptHelper.a(this.jdField_a_of_type_JavaUtilHashMap);
      }
      O();
    }
    return true;
  }
  
  private boolean O()
  {
    if ((QzoneConfig.getInstance().getConfig("qqstoryvideo", "jump_hyws_scheme_enable", 0) == 0) && (BaseApplicationImpl.getContext() != null))
    {
      ThreadManager.getUIHandler().post(new JumpActionLegacy.6(this));
      return false;
    }
    if ((((MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).jdField_a_of_type_Boolean) && (!"open".equals(this.jdField_c_of_type_JavaLangString)) && (!"openTag".equals(this.jdField_c_of_type_JavaLangString)) && (!"openSquare".equals(this.jdField_c_of_type_JavaLangString)) && (!"publish".equals(this.jdField_c_of_type_JavaLangString))) {
      return bA();
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page");
    String str1 = str2;
    if (String.valueOf(2).equals(str2))
    {
      MsgTabStoryNodeConfigManager localMsgTabStoryNodeConfigManager = (MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER);
      str1 = str2;
      if (localMsgTabStoryNodeConfigManager != null)
      {
        str1 = str2;
        if (!localMsgTabStoryNodeConfigManager.jdField_a_of_type_Boolean)
        {
          str1 = String.valueOf(0);
          this.jdField_a_of_type_JavaUtilHashMap.put("one_page", str1);
        }
      }
    }
    if ("0".equals(str1)) {
      return bD();
    }
    if ("open".equals(this.jdField_c_of_type_JavaLangString)) {
      return bD();
    }
    return bA();
  }
  
  private boolean P()
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      String str;
      if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().h())) {
        str = "https://docs.qq.com/desktop/m/index.html?_from=1";
      } else {
        str = TencentDocConvertConfigProcessor.a().h();
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent.putExtra("url", str));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  private boolean Q()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
    localIntent.putExtra("fragment_id", 1);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
    localIntent.putExtra("from", str);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if ("10003".equals(str))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077F6", "0X80077F6", 0, 0, "", "", "", "");
      return true;
    }
    if ("10004".equals(str))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077F7", "0X80077F7", 0, 0, "", "", "", "");
      return true;
    }
    if ("10009".equals(str)) {
      QLog.i("JumpAction", 1, "jumpaction from gotoConversaton e = ");
    }
    return true;
  }
  
  private boolean R()
  {
    l3 = System.currentTimeMillis();
    bool2 = ARDeviceController.a().a();
    localARGlobalConfigManager = (ARGlobalConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    if (localARGlobalConfigManager != null)
    {
      localObject1 = localARGlobalConfigManager.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("jumpaction from gotoScannerActivity device support is config info is ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.i("JumpAction", 1, ((StringBuilder)localObject2).toString());
      if (localARGlobalConfigManager.b())
      {
        bool1 = true;
        break label95;
      }
    }
    bool1 = false;
    label95:
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
    } else {
      localObject2 = "";
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("args")) {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("args");
    } else {
      localObject1 = "";
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("disablecloud")) {
      localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("disablecloud");
    } else {
      localObject3 = "0";
    }
    try
    {
      i = Integer.parseInt((String)localObject3);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      try
      {
        int j;
        Intent localIntent;
        Object localObject4;
        l1 = Long.valueOf((String)localObject1).longValue();
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("RecoglizeMask");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label798;
        }
        try
        {
          l2 = Long.valueOf((String)localObject1).longValue();
        }
        catch (Exception localException2)
        {
          break label798;
        }
        l2 = 0L;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("H5Source")) {
          break label821;
        }
        localObject1 = "";
        break label836;
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("H5Source");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("enableQR")) {
          break label867;
        }
        localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enableQR");
        break label872;
        localObject3 = "0";
        try
        {
          long l4 = Long.valueOf((String)localObject3).longValue();
          if (l4 != 0L) {
            bool1 = false;
          }
        }
        catch (Exception localException3)
        {
          break label898;
        }
        bool1 = true;
        ((Bundle)localObject4).putLong("PromotionType", l1);
        ((Bundle)localObject4).putLong("RecoglizeMask", l2);
        if (j == 0) {
          break label930;
        }
        bool2 = true;
        break label933;
        bool2 = false;
        ((Bundle)localObject4).putBoolean("disablecloud", bool2);
        ((Bundle)localObject4).putString("H5Source", (String)localObject1);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("version")) {
          break label984;
        }
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
        break label989;
        localObject1 = "0";
        ((Bundle)localObject4).putString("version", (String)localObject1);
        ((Bundle)localObject4).putBoolean("enableQR", bool1);
        if (l1 == 0L) {
          break label1020;
        }
        int i = 1;
        break label1022;
        i = 0;
        if ((i == 0) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("PromotionDescription"))) {
          break label1060;
        }
        ((Bundle)localObject4).putString("PromotionDescription", (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionDescription"));
        ((Bundle)localObject4).putBoolean("is_from_h5_entry", true);
        localIntent.putExtra("web_invoke_params", (Bundle)localObject4);
        QQAudioHelper.a("JumpAction", (Bundle)localObject4);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("PromotionInfo test , \n");
        ((StringBuilder)localObject1).append(((Bundle)localObject4).toString());
        ((StringBuilder)localObject1).append("]");
        QLog.w("JumpAction", 1, ((StringBuilder)localObject1).toString());
        if (localARGlobalConfigManager == null) {
          break label1236;
        }
        if ((localARGlobalConfigManager.a() == null) || (TextUtils.isEmpty(localARGlobalConfigManager.a().jdField_e_of_type_JavaLangString))) {
          break label1188;
        }
        localIntent.putExtra("icon_text", localARGlobalConfigManager.a().jdField_e_of_type_JavaLangString);
        break label1200;
        localIntent.putExtra("icon_text", "QQ-AR");
        if ((localARGlobalConfigManager.a() == null) || (localARGlobalConfigManager.a().jdField_c_of_type_JavaLangString == null)) {
          break label1236;
        }
        localIntent.putExtra("icon_url", localARGlobalConfigManager.a().jdField_c_of_type_JavaLangString);
        RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, localIntent, "/qrscan/scanner");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "0", (String)localObject2, "", "");
        break label1465;
        localObject3 = new StringBuilder("https://ti.qq.com/ar/help/error.html?_wv=3");
        ((StringBuilder)localObject3).append("&from=");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("&args=");
        new StringBuffer();
        ((StringBuilder)localObject3).append(GrayTipsItemBuilder.a((String)localObject1));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("jumpaction from gotoScannerActivity QQBrowserActivity cost time is ");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
        QLog.i("JumpAction", 1, ((StringBuilder)localObject1).toString());
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject3).toString());
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "1", (String)localObject2, "", "");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("jumpaction from gotoScannerActivity cost time is ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l3);
        QLog.i("JumpAction", 1, ((StringBuilder)localObject1).toString());
        return true;
        localNumberFormatException = localNumberFormatException;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          long l2;
          long l1 = l2;
        }
      }
    }
    i = 0;
    j = i;
    if (i != 1)
    {
      j = i;
      if (i != 0) {
        j = 1;
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("jumpaction from gotoScannerActivity device support is ");
    ((StringBuilder)localObject3).append(bool2);
    ((StringBuilder)localObject3).append(",effectinfo is ");
    ((StringBuilder)localObject3).append(bool1);
    ((StringBuilder)localObject3).append(",from url is ");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(",args is");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(",cloudSwitch is ");
    ((StringBuilder)localObject3).append(j);
    QLog.i("JumpAction", 1, ((StringBuilder)localObject3).toString());
    if ((bool2) && (bool1))
    {
      localIntent = new Intent();
      localIntent.putExtra("from", "web-ar");
      localIntent.addFlags(67108864);
      localIntent.addFlags(268435456);
      localIntent.addFlags(65536);
      localIntent.addFlags(536870912);
      localIntent.putExtra("click_time", System.currentTimeMillis());
      localIntent.putExtra("web_url_switch", j);
      localIntent.putExtra("jump_from_web", true);
      if (QLog.isDevelopLevel())
      {
        localObject3 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        localObject1 = "";
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          StringBuilder localStringBuilder;
          if ((((Map.Entry)localObject4).getValue() != null) && (((String)((Map.Entry)localObject4).getValue()).length() > 20))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append((String)((Map.Entry)localObject4).getKey());
            localStringBuilder.append("[");
            localStringBuilder.append(((String)((Map.Entry)localObject4).getValue()).substring(0, 20));
            localStringBuilder.append("]\n");
            localObject1 = localStringBuilder.toString();
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append((String)((Map.Entry)localObject4).getKey());
            localStringBuilder.append("[");
            localStringBuilder.append((String)((Map.Entry)localObject4).getValue());
            localStringBuilder.append("]\n");
            localObject1 = localStringBuilder.toString();
          }
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("gotoScannerActivity, \n");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("]");
        QLog.w("JumpAction", 1, ((StringBuilder)localObject3).toString());
      }
      localObject4 = new Bundle();
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionType");
      l2 = 1L;
      l1 = l2;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
  }
  
  private boolean S()
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("kSrouce")) {
        break label89;
      }
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        int i;
        label51:
        continue;
        label89:
        String str = "22";
      }
    }
    i = Integer.parseInt((String)localObject);
    break label51;
    QLog.i("JumpAction", 1, "gotoBindNumberActivity from value format wrong");
    i = 22;
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, BindNumberActivity.class);
    ((Intent)localObject).putExtra("kSrouce", i);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean T()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("interest_type"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "ChooseInterestTagActivity->type = null");
      }
      return false;
    }
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("interest_type");
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
    } else {
      str = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ChooseInterestTagActivity->type = ");
      localStringBuilder.append((String)localObject);
      QLog.d("JumpAction", 2, localStringBuilder.toString());
    }
    try
    {
      i = Integer.valueOf((String)localObject).intValue();
    }
    catch (Exception localException2)
    {
      int i;
      label132:
      break label132;
    }
    i = 0;
    if ("interesttag_selector".equals(this.jdField_c_of_type_JavaLangString)) {
      try
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("is_from_judge", true);
        ((Intent)localObject).putExtra("interest_tag_type", i);
        ((Intent)localObject).putExtra("from_where", "web_to_choose_tag");
        if ("10002".equals(str)) {
          ((Intent)localObject).addFlags(268435456);
        }
        RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, "/nearby/choose/interesttag");
        return true;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "", localException1);
        }
      }
    }
    return false;
  }
  
  private boolean U()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("TAB_TYPE", 1);
    String str2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type")) {
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    } else {
      str2 = "";
    }
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("web_url")) {
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("web_url");
    } else {
      str4 = "";
    }
    String str5;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
    } else {
      str5 = "";
    }
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
    } else {
      str1 = "";
    }
    localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
    localIntent.putExtra("fromWhere", str2);
    localIntent.putExtra("webUrl", str4);
    localIntent.putExtra("fromType", str1);
    localIntent.putExtra("FROM_WHERE", 1);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("neighbor_list_source"))
    {
      try
      {
        i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("neighbor_list_source"));
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        i = 0;
      }
      localIntent.putExtra("neighbor_list_source", i);
    }
    if ("10002".equals(str5))
    {
      localIntent.putExtra("abp_flag", true);
      localIntent.addFlags(268435456);
    }
    String str3;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter")) {
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter");
    } else {
      str3 = "";
    }
    String str6;
    String str7;
    String str8;
    String str9;
    String str10;
    if ("1".equals(str3))
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_gender")) {
        str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
      } else {
        str4 = "";
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time")) {
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
      } else {
        str5 = "";
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
        str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
      } else {
        str6 = "";
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_xingzuo")) {
        str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_xingzuo");
      } else {
        str7 = "";
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_interest")) {
        str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_interest");
      } else {
        str8 = "";
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
        str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
      } else {
        str9 = "";
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
        str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_location");
      } else {
        str10 = "";
      }
    }
    try
    {
      i = Integer.valueOf(str4).intValue();
    }
    catch (Exception localException2)
    {
      label623:
      break label623;
    }
    int i = 0;
    label651:
    try
    {
      j = Integer.valueOf(str5).intValue();
    }
    catch (Exception localException3)
    {
      int j;
      label637:
      break label637;
    }
    j = 3;
    try
    {
      k = Integer.valueOf(str6).intValue();
    }
    catch (Exception localException4)
    {
      int k;
      break label651;
    }
    k = 0;
    try
    {
      m = Integer.valueOf(str7).intValue();
    }
    catch (Exception localException5)
    {
      int m;
      label666:
      break label666;
    }
    m = 0;
    try
    {
      n = Integer.valueOf(str9).intValue();
    }
    catch (Exception localException6)
    {
      int n;
      label682:
      label698:
      break label682;
    }
    n = 0;
    try
    {
      i1 = Integer.valueOf(str8).intValue();
    }
    catch (Exception localException7)
    {
      int i1;
      break label698;
    }
    i1 = 0;
    localIntent.putExtra("filter", str3);
    localIntent.putExtra("filterGender", i);
    localIntent.putExtra("filter_time", j);
    localIntent.putExtra("filter_age", k);
    localIntent.putExtra("filter_xingzuo", m);
    localIntent.putExtra("filter_interest", i1);
    localIntent.putExtra("filter_career", n);
    localIntent.putExtra("filter_location", str10);
    localIntent.addFlags(67108864);
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, localIntent, "/nearby/activity");
    if ("100".equals(str1)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007244", "0X8007244", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  private boolean V()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("groupCode");
        String str3 = "";
        if (bool)
        {
          String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupCode");
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("groupMemberUin")) {
            str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupMemberUin");
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("troop_uin", str1);
          localIntent.putExtra("member_uin", str3);
          PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, TroopMemberHistoryFragment.class);
          return true;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, localException.toString());
        }
        return false;
      }
      String str2 = "";
    }
  }
  
  private boolean W()
  {
    HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, false);
    return true;
  }
  
  private boolean X()
  {
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hotnamecode")) {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hotnamecode");
    } else {
      str = "";
    }
    if (TextUtils.isEmpty(str))
    {
      QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131705974), 1).a();
      return false;
    }
    NearbyTransitActivity.a(this.jdField_a_of_type_AndroidContentContext, str, 1, this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  private boolean Y()
  {
    boolean bool1 = QLog.isColorLevel();
    int j = 0;
    if (bool1) {
      NearbyUtils.a("JumpAction", new Object[] { "gotoHotchatNewYearScene" });
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("trigger_anim")) {
        bool1 = Boolean.parseBoolean((String)this.jdField_a_of_type_JavaUtilHashMap.get("trigger_anim"));
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      i = j;
      try
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
          break label121;
        }
        i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("from"));
        bool2 = bool1;
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      bool1 = false;
    }
    int i = j;
    boolean bool2 = bool1;
    label121:
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
    localIntent.setFlags(67108864);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
      localIntent.putExtra("from", i);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("trigger_anim")) {
      localIntent.putExtra("trigger_anim", bool2);
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))
    {
      SplashActivity localSplashActivity = (SplashActivity)this.jdField_a_of_type_AndroidContentContext;
      localIntent.putExtra("switch_anim", true);
      localSplashActivity.openMainFragment(localIntent);
      return true;
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
    return true;
  }
  
  private boolean Z()
  {
    return true;
  }
  
  private int a()
  {
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("env"))) {
      return Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("env")).intValue();
    }
    return 0;
  }
  
  public static int a(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("sharefromtype");
    if (paramMap != null) {}
    try
    {
      int i = Integer.parseInt(paramMap);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label24:
      StringBuilder localStringBuilder;
      break label24;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("makeStoryContentPageIntent, NumberFormatException, shareFromStr:");
      localStringBuilder.append(paramMap);
      QLog.e("JumpAction", 2, localStringBuilder.toString());
    }
    return 0;
  }
  
  public static int a(Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    if (paramMap != null) {}
    try
    {
      int i = Integer.parseInt(paramMap);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label22:
      StringBuilder localStringBuilder;
      break label22;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIntAttribute, NumberFormatException, key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" strVal:");
      localStringBuilder.append(paramMap);
      QLog.e("JumpAction", 2, localStringBuilder.toString());
    }
    return paramInt;
  }
  
  private Intent a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtra("thridparty_prepare_mini_app", true);
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    localIntent.putExtra("fragment_id", 1);
    return localIntent;
  }
  
  private Intent a(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    paramBundle.putBoolean("is_ark_display_share", true);
    paramBundle.putBoolean("forward_ark_from_sdk", true);
    return localIntent;
  }
  
  private Intent a(String paramString, Bundle paramBundle, long paramLong)
  {
    paramBundle.putBoolean("is_ark_display_share", false);
    if (TextUtils.isEmpty(paramString))
    {
      ArkAppCenter.a("JumpAction", "gotoShareArkMsg, appInfo is empty");
      return a(paramBundle);
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("app");
      String str1 = ((JSONObject)localObject).optString("view");
      String str2 = ((JSONObject)localObject).optString("meta");
      localObject = ((JSONObject)localObject).optString("config");
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        paramBundle.putBoolean("is_ark_display_share", true);
        paramString = ArkFullScreenAppActivity.a(this.jdField_a_of_type_AndroidContentContext, str1, paramString, str2, (String)localObject, String.valueOf(paramLong), this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity);
        ArkAppCenter.a("JumpAction", "gotoShareArkMsg, ark appInfo is parse success");
        return paramString;
      }
      ArkAppCenter.a("JumpAction", "gotoShareArkMsg, appName or appView or appMeta is empty");
      paramString = a(paramBundle);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ArkAppCenter.a("JumpAction", String.format("gotoShareArkMsg, parse json failed, err=%s", new Object[] { paramString.getMessage() }));
    }
    return a(paramBundle);
  }
  
  private Class a()
  {
    ILoginRegisterApi localILoginRegisterApi = a();
    Class localClass = localILoginRegisterApi.getRegisterPhoneNumActivityClass();
    int i = BaseApplicationImpl.getApplication().appActivities.size() - 1;
    while (i >= 0)
    {
      Object localObject = (WeakReference)BaseApplicationImpl.getApplication().appActivities.get(i);
      if (localObject != null) {
        localObject = (Activity)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getLocalClassName();
        if ("activity.RegisterPersonalInfoActivity".equals(localObject)) {
          return localILoginRegisterApi.getRegisterPersonalInfoActivityClass();
        }
        if ("activity.RegisterVerifyCodeActivity".equals(localObject)) {
          return localILoginRegisterApi.getRegisterVerifyCodeActivityClass();
        }
        if ("activity.RegisterByNicknameAndPwdActivity".equals(localObject)) {
          return localILoginRegisterApi.getRegisterByNicknameAndPwdActivityClass();
        }
        if ("activity.RegisterSendUpSms".equals(localObject)) {
          return localILoginRegisterApi.getRegisterSendUpSmsClass();
        }
        if ("activity.RegisterPhoneNumActivity".equals(localObject)) {
          return localClass;
        }
      }
      i -= 1;
    }
    return localClass;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      if (i != 15)
      {
        if (i != 45)
        {
          if (i != 3001)
          {
            switch (i)
            {
            default: 
              return paramString;
            case 22: 
              return "6";
            case 21: 
              return "2";
            }
            return "3";
          }
          return "5";
        }
        return "7";
      }
      str = "4";
      return str;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    String str1 = paramString1;
    String str2;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return paramString1;
      }
      try
      {
        str1 = URLEncoder.encode(paramString3, "UTF-8");
        paramString3 = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      if (paramString1.contains(paramString2)) {
        return paramString1.replace(paramString2, paramString3);
      }
      str2 = paramString1.replace(paramString2.toUpperCase(), paramString3);
    }
    return str2;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("qidian");
    String str2 = "";
    String str1;
    if (bool) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("qidian");
    } else {
      str1 = "";
    }
    if (!TextUtils.isEmpty(str1)) {}
    try
    {
      i = Integer.valueOf(str1).intValue();
    }
    catch (Exception localException)
    {
      int i;
      label63:
      break label63;
    }
    i = 0;
    if (i == 1)
    {
      str1 = str2;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("jsondata")) {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jsondata");
      }
      ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(str1, paramInt1, paramInt2);
    }
  }
  
  private void a(long paramLong, String paramString, int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = "1";
    }
    for (;;)
    {
      break;
      if (paramInt == 5) {
        str = "2";
      } else if (paramInt == 2) {
        str = "3";
      } else {
        str = "4";
      }
    }
    ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString, String.valueOf(paramLong), "102", "80", "0", str, "0", "0", false, true);
  }
  
  private void a(Intent paramIntent)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("source")) {
      return;
    }
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
    try
    {
      paramIntent.putExtra("data_report_source", Integer.parseInt(str));
      return;
    }
    catch (Exception paramIntent)
    {
      label41:
      break label41;
    }
    QLog.w("JumpAction", 2, "no source, ingore it");
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "wpaParamsParse---Start");
    }
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.get("paramencrypted_type");
    boolean bool2 = false;
    int i;
    if (localObject2 == null) {
      i = 0;
    } else {
      i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("paramencrypted_type"));
    }
    paramIntent.putExtra("from3rdApp", true);
    if (i == 1) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "params must be decrypted");
      }
      localObject2 = Base64Util.decode(new Cryptor().decrypt(HexUtil.hexStr2Bytes(paramString), "Hf7K(s*js12LiskW".getBytes()), 0);
      paramString = localObject1;
      if (localObject2 != null)
      {
        paramString = new JSONObject(new String((byte[])localObject2));
        boolean bool1 = bool2;
        if (paramString.has("layout"))
        {
          bool1 = bool2;
          if (paramString.getString("layout") != null) {
            bool1 = true;
          }
        }
        paramIntent.putExtra("showFirstStructMsg", bool1);
        break label219;
        paramIntent.putExtra("fromSencondhandCommunity", true);
        paramString = new JSONObject(paramString);
        paramIntent.putExtra("gid", paramString.getString("gid"));
      }
      label219:
      if (paramString == null) {
        break label304;
      }
      paramString = ChatActivityUtils.a(paramString);
      paramIntent.putExtra("stuctmsg_bytes", paramString);
      if ((paramString == null) || (i != 1)) {
        break label304;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), "0X8004B50", "0X8004B50", 0, 0, "", "", "", "");
      return;
    }
    catch (JSONException paramIntent)
    {
      label288:
      label304:
      break label288;
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("JumpAction", 4, "wpaParamsParse---JSONException");
    }
  }
  
  @Deprecated
  public static void a(Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("key_launch_time");
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("call jumpToVideoStoryLayer timedelay=");
      ((StringBuilder)localObject).append(l2 - l1);
      QLog.d("plugin_tag", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = QZoneHelper.getQzoneVerticalVideoDownloadActivityIntent(BaseApplicationImpl.getContext());
    ((Intent)localObject).putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).putExtras(paramBundle);
    BaseApplicationImpl.getContext().startActivity((Intent)localObject);
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    HashSet localHashSet1 = new HashSet();
    localHashSet1.add(Integer.valueOf(AECameraEntry.a.a()));
    localHashSet1.add(Integer.valueOf(AECameraEntry.n.a()));
    localHashSet1.add(Integer.valueOf(AECameraEntry.t.a()));
    localHashSet1.add(Integer.valueOf(AECameraEntry.w.a()));
    localHashSet1.add(Integer.valueOf(AECameraEntry.b.a()));
    localHashSet1.add(Integer.valueOf(AECameraEntry.u.a()));
    localHashSet1.add(Integer.valueOf(AECameraEntry.c.a()));
    HashSet localHashSet2 = new HashSet();
    localHashSet2.add(Integer.valueOf(AECameraEntry.g.a()));
    localHashSet2.add(Integer.valueOf(AECameraEntry.q.a()));
    localHashSet2.add(Integer.valueOf(AECameraEntry.r.a()));
    localHashSet2.add(Integer.valueOf(AECameraEntry.o.a()));
    localHashSet2.add(Integer.valueOf(AECameraEntry.s.a()));
    localHashSet2.add(Integer.valueOf(AECameraEntry.v.a()));
    if (localHashSet1.contains(Integer.valueOf(paramInt)))
    {
      paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
      return;
    }
    if (localHashSet2.contains(Integer.valueOf(paramInt)))
    {
      paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 2);
      return;
    }
    paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
  }
  
  private void a(Bundle paramBundle, String paramString1, int paramInt, String paramString2)
  {
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1));
    if (!TextUtils.isEmpty(str))
    {
      if (str.getBytes().length <= paramInt)
      {
        paramBundle.putString(paramString2, str);
        paramBundle = new StringBuilder();
        paramBundle.append("addShareGameParam: has ");
        paramBundle.append(paramString1);
        QLog.i("JumpAction", 1, paramBundle.toString());
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("addShareGameParam: too large ");
      paramBundle.append(paramString1);
      QLog.i("JumpAction", 1, paramBundle.toString());
    }
  }
  
  private void a(Bundle paramBundle, HashMap<String, String> paramHashMap, int paramInt1, int paramInt2)
  {
    Object localObject = new String[6];
    boolean bool3 = false;
    localObject[0] = "file_data";
    localObject[1] = "description";
    localObject[2] = "url";
    localObject[3] = "image_url";
    localObject[4] = "share_uin";
    localObject[5] = "share_qq_ext_str";
    int i = 0;
    while (i < localObject.length)
    {
      paramBundle.putString(new String[] { "image_url", "desc", "detail_url", "image_url_remote", "share_uin", "share_qq_ext_str" }[i], c((String)paramHashMap.get(localObject[i])));
      i += 1;
    }
    paramBundle.putInt("req_type", paramInt1);
    paramBundle.putInt("cflag", paramInt2);
    localObject = null;
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      localObject = c((String)paramHashMap.get("app_name"));
    }
    paramBundle.putString("app_name", (String)localObject);
    paramBundle.putString("jfrom", (String)paramHashMap.get("jfrom"));
    paramBundle.putString("chSrc", (String)paramHashMap.get("chSrc"));
    a(paramBundle, "game_tag_name", 128, "game_tag_name");
    a(paramBundle, "game_message_ext", 256, "game_message_ext");
    String str = c((String)paramHashMap.get("title"));
    paramBundle.putString("title", str);
    if (str == null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = "";
      }
      paramBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131696401, new Object[] { localObject }));
    }
    else
    {
      paramBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131696401, new Object[] { str }));
    }
    paramBundle.putInt("forward_type", 11);
    paramBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    if ((paramInt1 == 5) && (ForwardShareByServerHelper.a()))
    {
      paramBundle.putBoolean("is_ark_display_share", true);
      paramBundle.putBoolean("forward_ark_from_sdk", true);
    }
    if (paramInt1 == 2) {
      paramBundle.putString("audio_url", c((String)paramHashMap.get("audioUrl")));
    }
    paramBundle.putBoolean("k_dataline", false);
    paramBundle.putBoolean("k_favorites", true);
    paramBundle.putBoolean("k_cancel_button", true);
    paramBundle.putInt("emoInputType", 2);
    boolean bool1;
    if (((paramInt2 & 0x2) == 0) && (!"com.qzone".equals(this.jdField_e_of_type_JavaLangString))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramBundle.putBoolean("k_qzone", bool1);
    boolean bool2 = bool3;
    if (bool1)
    {
      bool2 = bool3;
      if ((paramInt2 & 0x1) != 0) {
        bool2 = true;
      }
    }
    paramBundle.putBoolean("k_send", bool2);
    paramBundle.putInt("iUrlInfoFrm", 4);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent)
  {
    paramIntent.putExtra("url", paramString1);
    paramIntent.setClassName(paramString2, paramString3);
    paramIntent.addCategory("android.intent.category.LAUNCHER");
    paramIntent.addFlags(268435456);
    paramIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramIntent);
  }
  
  private boolean a(Intent paramIntent, String paramString1, String paramString2)
  {
    if (!paramIntent.hasExtra("click_start_time")) {
      paramIntent.putExtra("click_start_time", System.currentTimeMillis());
    }
    paramIntent.putExtra("is_from_webview", "webview".equals(this.jdField_d_of_type_JavaLangString));
    if ((this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.uiAppId.get() == 769))
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.push_red_ts.get();
      int j = 0;
      int i;
      try
      {
        i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("redtouch_click_timestamp"));
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        i = 0;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reader_zone_appinfo_last_pull_timestamp_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      int m = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reader_zone_appinfo_last_pull_timestamp_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), 0).commit();
      if (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.buffer.has()) {
        try
        {
          localObject = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.buffer.get());
          if ((this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.missions.has()) && (!this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.missions.isEmpty()))
          {
            boolean bool = "0".equals(((JSONObject)localObject).getJSONObject("param").getJSONObject((String)this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.missions.get(0)).getString("_red_ext_type"));
            if (bool) {}
          }
          else
          {
            j = 1;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      paramIntent.putExtra("redtouch_type", j);
      paramIntent.putExtra("redtouch_push_ts", k);
      paramIntent.putExtra("redtouch_pull_ts", m);
      paramIntent.putExtra("redtouch_click_ts", i);
      if ((this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.missions.has()) && (!this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.missions.isEmpty())) {
        paramIntent.putStringArrayListExtra("redtouch_taskid", new ArrayList(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.missions.get()));
      }
    }
    paramIntent.putExtra("pluginsdk_selfuin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramIntent.putExtra("load_from_third_app", true);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    paramIntent.putExtra("current_qr_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramIntent.putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
    b(paramIntent);
    paramIntent.setClassName(this.jdField_a_of_type_AndroidContentContext, paramString1);
    try
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramIntent);
      if (!"qqreaderplugin.apk".equals(paramString2))
      {
        ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).preloadQWallet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return true;
      }
      ThreadManager.post(new JumpActionLegacy.26(this), 5, null, true);
      return true;
    }
    catch (Exception paramIntent) {}
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    paramQQAppInterface = (String)paramHashMap.get("uin");
    String str1 = (String)paramHashMap.get("usertype");
    String str2 = (String)paramHashMap.get("unionid");
    paramHashMap = (String)paramHashMap.get("fromId");
    if ((!TextUtils.isEmpty(str1)) && ((!TextUtils.isEmpty(paramQQAppInterface)) || (!TextUtils.isEmpty(str2)))) {
      if (TextUtils.isEmpty(paramHashMap)) {
        return false;
      }
    }
    try
    {
      if (!TextUtils.isEmpty(str2)) {
        StoryApi.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), str2);
      } else {
        StoryApi.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), Long.valueOf(paramQQAppInterface).longValue());
      }
      return true;
    }
    catch (Exception paramQQAppInterface) {}
    return false;
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str5 = (String)paramHashMap.get("videoOwnerUin");
    String str6 = (String)paramHashMap.get("unionid");
    String str4 = (String)paramHashMap.get("fromId");
    String str3 = (String)paramHashMap.get("videoId");
    String str1 = (String)paramHashMap.get("type");
    str1 = (String)paramHashMap.get("videoList");
    int i = a(paramHashMap);
    str1 = (String)paramHashMap.get("feedid");
    int k = a(paramHashMap, "ptype", 0);
    int m = "0".equals(paramHashMap.get("identify")) ^ true;
    String str2 = str3;
    if (str3 == null) {
      str2 = (String)paramHashMap.get("videoid");
    }
    str3 = str4;
    if (str4 == null) {
      str3 = (String)paramHashMap.get("fromid");
    }
    int j = k;
    if (!TextUtils.isEmpty(paramString))
    {
      j = k;
      if (k == 0) {
        j = 7;
      }
    }
    k = -1;
    switch (j)
    {
    default: 
      paramQQAppInterface = str1;
      if (str1 == null) {
        paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
      }
      break;
    case 10: 
      paramQQAppInterface = (String)paramHashMap.get("bannerID");
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        StoryPlayerLauncher.a(paramActivity, new OpenPlayerBuilder(new DiscoverBannerPlayInfo(paramQQAppInterface), 102).a());
      }
      return true;
    case 9: 
      a(paramHashMap, "time_zone", -1);
      j = i;
      if (i == 0) {
        j = 96;
      }
      StoryPlayerLauncher.a(paramActivity, str1, j);
      return true;
    case 8: 
      j = i;
      if (i == 0) {
        j = 90;
      }
      StoryPlayerLauncher.b(paramActivity, str2, str1, j);
      return true;
    case 7: 
      j = i;
      if (i == 0) {
        j = 19;
      }
      StoryPlayerLauncher.b(paramActivity, str2, str1, j);
      return true;
    case 6: 
      j = i;
      if (i == 0) {
        j = 57;
      }
      StoryPlayerLauncher.b(paramActivity, str2, str1, j);
      return true;
    case 5: 
      StoryPlayerLauncher.a(paramActivity, str6, str1, m, i, 0, null);
      return true;
    case 4: 
      paramQQAppInterface = (String)paramHashMap.get("collection_id");
      paramHashMap = (String)paramHashMap.get("time_zone");
      j = k;
      if (!TextUtils.isEmpty(paramHashMap)) {
        j = Integer.valueOf(paramHashMap).intValue();
      }
      if (!TextUtils.isEmpty(str6))
      {
        StoryPlayerLauncher.a(paramActivity, str6, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str6), j, i, str1, m, null);
        return true;
      }
      if (!TextUtils.isEmpty(str5))
      {
        StoryPlayerLauncher.a(paramActivity, str5, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str5), j, i, str1, m, null);
        return true;
      }
      return false;
    case 3: 
      j = i;
      if (i == 0) {
        j = 30;
      }
      StoryPlayerLauncher.a(paramActivity, str2, str1, j);
      return true;
    case 2: 
      if ("17".equals(str3)) {
        StoryReportor.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", str2 });
      }
      paramQQAppInterface = (String)paramHashMap.get("et");
      paramQQAppInterface = (String)paramHashMap.get("time_zone");
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        Integer.valueOf(paramQQAppInterface).intValue();
      }
      if (!TextUtils.isEmpty(str6))
      {
        StoryPlayerLauncher.a(paramActivity, str6, str1, 1, 109, 1, null);
        return true;
      }
      if (!TextUtils.isEmpty(str5))
      {
        StoryPlayerLauncher.a(paramActivity, str5, str1, 1, 109, 1, null);
        return true;
      }
      return false;
    case 1: 
      if ("17".equals(str3)) {
        StoryReportor.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", str2 });
      }
      paramQQAppInterface = str1;
      if (str1 == null) {
        paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
      }
      j = i;
      if (i == 0) {
        j = 7;
      }
      StoryPlayerLauncher.b(paramActivity, str2, paramQQAppInterface, j);
      return true;
    case 0: 
      return b(paramQQAppInterface, paramActivity, paramHashMap, paramString);
    }
    j = i;
    if (i == 0) {
      j = 7;
    }
    StoryPlayerLauncher.b(paramActivity, str2, paramQQAppInterface, j);
    return true;
  }
  
  private boolean a(JumpActionLegacy.AsyncShareCallback paramAsyncShareCallback)
  {
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_uri"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_uri"));
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      QLog.d("JumpAction", 1, new Object[] { "imageUrl=", str1, ", imageUri=", str2 });
      this.f = false;
      ThreadManagerV2.executeOnSubThread(new JumpActionLegacy.27(this, str2, System.currentTimeMillis(), paramAsyncShareCallback));
      return false;
    }
    if ((!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str3)))
    {
      QLog.d("JumpAction", 1, new Object[] { "fileUri=", str4, ", fileData=", str3 });
      this.f = false;
      ThreadManagerV2.executeOnSubThread(new JumpActionLegacy.28(this, str4, System.currentTimeMillis(), paramAsyncShareCallback));
      return false;
    }
    return paramAsyncShareCallback.a();
  }
  
  private boolean a(Runnable paramRunnable, String paramString1, String paramString2, String paramString3)
  {
    this.f = false;
    ThreadManagerV2.executeOnSubThread(new JumpActionLegacy.9(this, paramString1, System.currentTimeMillis(), paramString2, paramString3, paramRunnable));
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("[0-9]+").matcher(paramString).matches();
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("PayInvokerId", 13);
    ((Bundle)localObject).putString("viewParam", paramString1);
    if (paramString2 != null) {
      ((Bundle)localObject).putString("entry", paramString2);
    }
    paramString1 = new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class);
    paramString1.putExtra("srvBundle", (Bundle)localObject);
    if (paramLong != 0L) {
      paramString1.putExtra("vacreport_key_seq", paramLong);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=10&entry=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("&seq=");
    ((StringBuilder)localObject).append(paramLong);
    paramString1.setData(Uri.parse(((StringBuilder)localObject).toString()));
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramString1);
    return true;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 13);
    localBundle.putString("viewParam", paramString1);
    if (paramString2 != null) {
      localBundle.putString("entry", paramString2);
    }
    if (paramLong != 0L) {
      localBundle.putLong("vacreport_key_seq", paramLong);
    }
    if (paramBundle != null) {
      localBundle.putBundle("extra_pay_data", paramBundle);
    }
    VACDReportUtil.a(paramLong, null, "loadPluginStart", null, 0, null);
    QWalletPayBridge.launchForeground((Activity)this.jdField_a_of_type_AndroidContentContext, localBundle);
    return true;
  }
  
  /* Error */
  private boolean a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 1811
    //   7: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 18	java/lang/String
    //   13: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 12
    //   18: aload_0
    //   19: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   22: ldc_w 1780
    //   25: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 18	java/lang/String
    //   31: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore 13
    //   36: aload_0
    //   37: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   40: ldc_w 670
    //   43: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 18	java/lang/String
    //   49: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 14
    //   54: aload_0
    //   55: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   58: ldc_w 1799
    //   61: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 18	java/lang/String
    //   67: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 15
    //   72: aload_0
    //   73: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   76: ldc_w 1782
    //   79: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 18	java/lang/String
    //   85: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   88: astore 11
    //   90: aload_0
    //   91: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   94: ldc_w 1828
    //   97: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 18	java/lang/String
    //   103: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 16
    //   108: aload_0
    //   109: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   112: ldc_w 2193
    //   115: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast 18	java/lang/String
    //   121: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   124: astore 10
    //   126: aload_0
    //   127: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   130: ldc_w 1784
    //   133: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 18	java/lang/String
    //   139: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   142: astore 17
    //   144: aload_0
    //   145: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   148: ldc_w 1801
    //   151: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   154: checkcast 18	java/lang/String
    //   157: astore 18
    //   159: aload_0
    //   160: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   163: ldc_w 1794
    //   166: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   169: checkcast 18	java/lang/String
    //   172: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   175: astore 9
    //   177: aload_0
    //   178: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   181: ldc_w 1786
    //   184: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 18	java/lang/String
    //   190: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   193: astore 19
    //   195: aload_0
    //   196: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   199: ldc_w 2195
    //   202: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   205: checkcast 18	java/lang/String
    //   208: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   211: astore 20
    //   213: aload_0
    //   214: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   217: ldc_w 2197
    //   220: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   223: checkcast 18	java/lang/String
    //   226: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   229: astore 21
    //   231: aload_0
    //   232: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   235: ldc_w 2199
    //   238: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   241: ifnull +30 -> 271
    //   244: aload_0
    //   245: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   248: ldc_w 2199
    //   251: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   254: checkcast 18	java/lang/String
    //   257: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   260: invokestatic 1315	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   263: invokevirtual 1318	java/lang/Integer:intValue	()I
    //   266: istore 4
    //   268: goto +6 -> 274
    //   271: iconst_3
    //   272: istore 4
    //   274: aload_0
    //   275: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   278: astore 22
    //   280: aload 22
    //   282: ldc_w 2201
    //   285: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   288: checkcast 18	java/lang/String
    //   291: invokestatic 129	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   294: invokevirtual 133	java/lang/Long:longValue	()J
    //   297: lstore 7
    //   299: goto +6 -> 305
    //   302: lconst_0
    //   303: lstore 7
    //   305: lload 7
    //   307: lconst_0
    //   308: lcmp
    //   309: ifgt +5 -> 314
    //   312: iconst_0
    //   313: ireturn
    //   314: aload_0
    //   315: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   318: ldc_w 1796
    //   321: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   324: checkcast 18	java/lang/String
    //   327: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   330: invokestatic 1315	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   333: invokevirtual 1318	java/lang/Integer:intValue	()I
    //   336: istore 5
    //   338: goto +25 -> 363
    //   341: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +16 -> 360
    //   347: ldc_w 2203
    //   350: iconst_2
    //   351: ldc_w 2205
    //   354: invokestatic 1310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: goto +3 -> 360
    //   360: iconst_0
    //   361: istore 5
    //   363: aload 9
    //   365: invokestatic 1315	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   368: invokevirtual 1318	java/lang/Integer:intValue	()I
    //   371: istore_3
    //   372: goto +21 -> 393
    //   375: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +13 -> 391
    //   381: ldc_w 2203
    //   384: iconst_2
    //   385: ldc_w 2207
    //   388: invokestatic 1310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: iconst_1
    //   392: istore_3
    //   393: aload 11
    //   395: astore 9
    //   397: aload 11
    //   399: ifnonnull +21 -> 420
    //   402: aload_0
    //   403: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   406: ldc_w 1778
    //   409: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   412: checkcast 18	java/lang/String
    //   415: invokestatic 530	com/tencent/mobileqq/utils/JumpActionLegacy:c	(Ljava/lang/String;)Ljava/lang/String;
    //   418: astore 9
    //   420: new 1546	java/util/ArrayList
    //   423: dup
    //   424: invokespecial 2208	java/util/ArrayList:<init>	()V
    //   427: astore 11
    //   429: aload 9
    //   431: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   434: ifne +47 -> 481
    //   437: aload 9
    //   439: ldc_w 2210
    //   442: invokevirtual 381	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   445: astore 9
    //   447: iconst_0
    //   448: istore 6
    //   450: iload 6
    //   452: aload 9
    //   454: arraylength
    //   455: if_icmpge +26 -> 481
    //   458: aload 11
    //   460: aload 9
    //   462: iload 6
    //   464: aaload
    //   465: invokestatic 407	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   468: invokevirtual 2211	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   471: pop
    //   472: iload 6
    //   474: iconst_1
    //   475: iadd
    //   476: istore 6
    //   478: goto -28 -> 450
    //   481: aload 11
    //   483: invokevirtual 1549	java/util/ArrayList:size	()I
    //   486: ifle +17 -> 503
    //   489: aload 11
    //   491: iconst_0
    //   492: invokevirtual 1552	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   495: checkcast 18	java/lang/String
    //   498: astore 9
    //   500: goto +7 -> 507
    //   503: ldc 135
    //   505: astore 9
    //   507: new 174	android/os/Bundle
    //   510: dup
    //   511: invokespecial 176	android/os/Bundle:<init>	()V
    //   514: astore 22
    //   516: aload 22
    //   518: ldc_w 1811
    //   521: aload 12
    //   523: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: aload 22
    //   528: ldc_w 1788
    //   531: aload 13
    //   533: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: aload 22
    //   538: ldc_w 1799
    //   541: aload 15
    //   543: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   546: aload 22
    //   548: ldc_w 2213
    //   551: lload 7
    //   553: invokevirtual 746	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   556: aload 22
    //   558: ldc_w 1790
    //   561: aload 14
    //   563: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: aload 22
    //   568: ldc_w 1782
    //   571: aload 11
    //   573: invokevirtual 2217	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   576: aload 22
    //   578: ldc_w 1821
    //   581: aload_0
    //   582: getfield 1797	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   585: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   588: aload 22
    //   590: ldc_w 2193
    //   593: aload 10
    //   595: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   598: aload 22
    //   600: ldc_w 1784
    //   603: aload 17
    //   605: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: aload 22
    //   610: ldc_w 1801
    //   613: aload 18
    //   615: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: aload 22
    //   620: ldc_w 1786
    //   623: aload 19
    //   625: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload 22
    //   630: ldc_w 1796
    //   633: iload 5
    //   635: invokevirtual 762	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   638: aload 22
    //   640: ldc_w 2219
    //   643: aload_1
    //   644: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: aload 22
    //   649: ldc_w 1844
    //   652: iconst_4
    //   653: invokevirtual 762	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   656: aload 22
    //   658: ldc_w 2221
    //   661: iconst_1
    //   662: invokevirtual 699	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   665: aload 20
    //   667: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   670: ifne +60 -> 730
    //   673: aload 21
    //   675: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   678: ifne +52 -> 730
    //   681: aload 22
    //   683: ldc_w 2223
    //   686: iconst_1
    //   687: invokevirtual 699	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   690: aload 22
    //   692: ldc_w 2225
    //   695: aload 20
    //   697: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   700: aload 22
    //   702: ldc_w 2227
    //   705: aload 21
    //   707: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   710: aload 22
    //   712: ldc_w 2229
    //   715: iload 4
    //   717: invokevirtual 762	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   720: aload 22
    //   722: ldc_w 2231
    //   725: aload 9
    //   727: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: iload_3
    //   731: iconst_2
    //   732: if_icmpne +13 -> 745
    //   735: aload 22
    //   737: ldc_w 1826
    //   740: aload 16
    //   742: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   745: aload 22
    //   747: ldc_w 1794
    //   750: iload_3
    //   751: invokevirtual 762	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   754: iconst_1
    //   755: putstatic 2234	com/tencent/mobileqq/phonecontact/constant/PhoneContactFlags:jdField_a_of_type_Boolean	Z
    //   758: new 2236	com/tencent/mobileqq/utils/JumpActionLegacy$23
    //   761: dup
    //   762: aload_0
    //   763: invokespecial 2237	com/tencent/mobileqq/utils/JumpActionLegacy$23:<init>	(Lcom/tencent/mobileqq/utils/JumpActionLegacy;)V
    //   766: astore_1
    //   767: aload 22
    //   769: ldc_w 2239
    //   772: iload_2
    //   773: invokevirtual 699	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   776: iload_3
    //   777: iconst_5
    //   778: if_icmpne +30 -> 808
    //   781: iload 5
    //   783: iconst_1
    //   784: iand
    //   785: ifeq +23 -> 808
    //   788: aload_0
    //   789: getfield 49	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   792: aload_0
    //   793: getfield 67	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   796: aload 22
    //   798: aload_1
    //   799: bipush 23
    //   801: invokestatic 2245	cooperation/qzone/QZoneShareManager:jumpToQzoneShare	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnDismissListener;I)Z
    //   804: pop
    //   805: goto +18 -> 823
    //   808: aload_0
    //   809: getfield 49	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   812: aload_0
    //   813: getfield 67	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   816: aload 22
    //   818: aload_1
    //   819: invokestatic 2248	cooperation/qzone/QZoneShareManager:jumpToQzoneShare	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnDismissListener;)Z
    //   822: pop
    //   823: iload_3
    //   824: iconst_1
    //   825: if_icmpne +9 -> 834
    //   828: ldc 146
    //   830: astore_1
    //   831: goto +31 -> 862
    //   834: iload_3
    //   835: iconst_2
    //   836: if_icmpne +9 -> 845
    //   839: ldc 153
    //   841: astore_1
    //   842: goto -11 -> 831
    //   845: iload_3
    //   846: iconst_5
    //   847: if_icmpne +9 -> 856
    //   850: ldc 151
    //   852: astore_1
    //   853: goto -22 -> 831
    //   856: ldc 155
    //   858: astore_1
    //   859: goto -28 -> 831
    //   862: invokestatic 1629	com/tencent/open/agent/report/ReportCenter:a	()Lcom/tencent/open/agent/report/ReportCenter;
    //   865: aload_0
    //   866: getfield 49	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   869: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   872: aload 10
    //   874: lload 7
    //   876: invokestatic 1497	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   879: ldc 167
    //   881: ldc_w 2250
    //   884: ldc_w 471
    //   887: aload_1
    //   888: ldc_w 471
    //   891: ldc_w 471
    //   894: iconst_0
    //   895: iconst_1
    //   896: invokevirtual 1636	com/tencent/open/agent/report/ReportCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
    //   899: new 2252	cooperation/qzone/QZoneClickReport$ReportInfo
    //   902: dup
    //   903: invokespecial 2253	cooperation/qzone/QZoneClickReport$ReportInfo:<init>	()V
    //   906: astore_1
    //   907: aload_1
    //   908: ldc 146
    //   910: putfield 2256	cooperation/qzone/QZoneClickReport$ReportInfo:actionType	Ljava/lang/String;
    //   913: aload_1
    //   914: ldc_w 471
    //   917: putfield 2259	cooperation/qzone/QZoneClickReport$ReportInfo:subactionType	Ljava/lang/String;
    //   920: aload_1
    //   921: iconst_4
    //   922: putfield 2262	cooperation/qzone/QZoneClickReport$ReportInfo:tabletype	I
    //   925: aload_1
    //   926: ldc 157
    //   928: putfield 2265	cooperation/qzone/QZoneClickReport$ReportInfo:sourceType	Ljava/lang/String;
    //   931: aload_1
    //   932: ldc_w 2267
    //   935: putfield 2270	cooperation/qzone/QZoneClickReport$ReportInfo:sourceFrom	Ljava/lang/String;
    //   938: aload_1
    //   939: ldc_w 2272
    //   942: putfield 2275	cooperation/qzone/QZoneClickReport$ReportInfo:sourceTo	Ljava/lang/String;
    //   945: aload_0
    //   946: getfield 49	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   949: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   952: aload_1
    //   953: invokestatic 2281	cooperation/qzone/QZoneClickReport:startReportImediately	(Ljava/lang/String;Lcooperation/qzone/QZoneClickReport$ReportInfo;)V
    //   956: new 58	java/util/HashMap
    //   959: dup
    //   960: invokespecial 408	java/util/HashMap:<init>	()V
    //   963: astore_1
    //   964: aload_1
    //   965: ldc_w 2283
    //   968: ldc 157
    //   970: invokevirtual 1077	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   973: pop
    //   974: aload_1
    //   975: ldc_w 2285
    //   978: ldc_w 2267
    //   981: invokevirtual 1077	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   984: pop
    //   985: aload_1
    //   986: ldc_w 2287
    //   989: ldc_w 2272
    //   992: invokevirtual 1077	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   995: pop
    //   996: invokestatic 979	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   999: invokestatic 2292	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1002: aload_0
    //   1003: getfield 49	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1006: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1009: ldc_w 2294
    //   1012: iconst_1
    //   1013: lconst_0
    //   1014: lconst_0
    //   1015: aload_1
    //   1016: aconst_null
    //   1017: invokevirtual 2298	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1020: aload_0
    //   1021: getfield 2101	com/tencent/mobileqq/utils/JumpActionLegacy:f	Z
    //   1024: ifne +23 -> 1047
    //   1027: aload_0
    //   1028: getfield 67	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1031: instanceof 2159
    //   1034: ifeq +13 -> 1047
    //   1037: aload_0
    //   1038: getfield 67	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1041: checkcast 2159	com/tencent/mobileqq/activity/JumpActivity
    //   1044: invokevirtual 2299	com/tencent/mobileqq/activity/JumpActivity:finish	()V
    //   1047: iconst_1
    //   1048: ireturn
    //   1049: astore 22
    //   1051: goto -749 -> 302
    //   1054: astore 22
    //   1056: goto -754 -> 302
    //   1059: astore 22
    //   1061: goto -720 -> 341
    //   1064: astore 9
    //   1066: goto -691 -> 375
    //   1069: astore_1
    //   1070: goto -171 -> 899
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1073	0	this	JumpActionLegacy
    //   0	1073	1	paramString	String
    //   0	1073	2	paramBoolean	boolean
    //   371	477	3	i	int
    //   266	450	4	j	int
    //   336	449	5	k	int
    //   448	29	6	m	int
    //   297	578	7	l	long
    //   175	551	9	localObject1	Object
    //   1064	1	9	localNumberFormatException1	NumberFormatException
    //   124	749	10	str1	String
    //   88	484	11	localObject2	Object
    //   16	506	12	str2	String
    //   34	498	13	str3	String
    //   52	510	14	str4	String
    //   70	472	15	str5	String
    //   106	635	16	str6	String
    //   142	462	17	str7	String
    //   157	457	18	str8	String
    //   193	431	19	str9	String
    //   211	485	20	str10	String
    //   229	477	21	str11	String
    //   278	539	22	localObject3	Object
    //   1049	1	22	localException1	Exception
    //   1054	1	22	localException2	Exception
    //   1059	1	22	localNumberFormatException2	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   274	280	1049	java/lang/Exception
    //   280	299	1054	java/lang/Exception
    //   314	338	1059	java/lang/NumberFormatException
    //   363	372	1064	java/lang/NumberFormatException
    //   862	899	1069	java/lang/Exception
  }
  
  private boolean a(Map<String, String> paramMap, boolean paramBoolean)
  {
    String str1 = (String)paramMap.get("userid");
    String str2 = (String)paramMap.get("usertype");
    String str3 = (String)paramMap.get("unionid");
    String str4 = (String)paramMap.get("storyid");
    String str5 = (String)paramMap.get("showinfocard");
    a(paramMap);
    if (str5 != null) {
      str5.equals("0");
    }
    if (TextUtils.isEmpty(str4)) {
      if (!TextUtils.isEmpty(str2)) {
        if (TextUtils.isEmpty(str3)) {
          return false;
        }
      }
    }
    try
    {
      if (Integer.parseInt(str2) == 1)
      {
        if (TextUtils.isEmpty(str1)) {
          return false;
        }
        StoryApi.a(this.jdField_a_of_type_AndroidContentContext, 23, str3);
      }
      return true;
    }
    catch (NumberFormatException paramMap)
    {
      label145:
      break label145;
    }
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("gotoStoryPlayVideoPage, NumberFormatException, userId:");
      paramMap.append(str1);
      paramMap.append(", userType:");
      paramMap.append(str2);
      QLog.d("JumpAction", 2, paramMap.toString());
    }
    return false;
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    localObject1 = new Bundle();
    try
    {
      l = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
    }
    catch (Exception localException2)
    {
      try
      {
        int i;
        ((Bundle)localObject1).putLong("file_send_duration", Long.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoDuration"))).longValue());
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            long l;
            int j;
            ((Bundle)localObject1).putLong("PhotoConst.VIDEO_SIZE", Long.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoSize"))).longValue());
            Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
            ((Bundle)localObject1).putBoolean("PhotoConst.IS_VIDEO_SELECTED", true);
            ((Bundle)localObject1).putInt("PhotoConst.VIDEO_TYPE", 1);
            ((Bundle)localObject1).putString("file_send_path", str);
            ((Bundle)localObject1).putBoolean("need_process", false);
            ((Bundle)localObject1).putString("defaultText", (String)localObject2);
            String str = "8";
            continue;
            str = "";
            ((Bundle)localObject1).putString("app_name", c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")));
            if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
              ((Bundle)localObject1).putString("hulian_appid", String.valueOf(l));
            }
            ((Bundle)localObject1).putInt("req_type", j);
            ((Bundle)localObject1).putLong("req_share_id", l);
            ((Bundle)localObject1).putString("pkg_name", this.jdField_e_of_type_JavaLangString);
            ((Bundle)localObject1).putBoolean("key_need_save_draft", false);
            ((Bundle)localObject1).putBoolean("key_require_storage_permission", paramBoolean);
            com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.jdField_a_of_type_Boolean = true;
            localObject2 = new JumpActionLegacy.21(this);
            QZoneShareManager.publishToQzone(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, (DialogInterface.OnDismissListener)localObject2);
            localObject2 = new QZoneClickReport.ReportInfo();
            ((QZoneClickReport.ReportInfo)localObject2).actionType = "1";
            ((QZoneClickReport.ReportInfo)localObject2).subactionType = "0";
            ((QZoneClickReport.ReportInfo)localObject2).tabletype = 4;
            ((QZoneClickReport.ReportInfo)localObject2).sourceType = "5";
            ((QZoneClickReport.ReportInfo)localObject2).sourceFrom = "thirdApp";
            Object localObject3 = new HashMap();
            ((HashMap)localObject3).put("source_type", "5");
            ((HashMap)localObject3).put("source_from", "thirdApp");
            localObject1 = ((Bundle)localObject1).getStringArrayList("images");
            if ((localObject1 != null) && (((ArrayList)localObject1).size() > 9))
            {
              ((QZoneClickReport.ReportInfo)localObject2).sourceTo = "QZoneUploadPhotosActivity";
              ((HashMap)localObject3).put("source_to", "QZoneUploadPhotosActivity");
            }
            else
            {
              ((QZoneClickReport.ReportInfo)localObject2).sourceTo = "QZonePublishMoodActivity";
              ((HashMap)localObject3).put("source_to", "QZonePublishMoodActivity");
            }
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject2);
            StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject3, null);
            localObject1 = ReportCenter.a();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(l);
            ((StringBuilder)localObject3).append("");
            ((ReportCenter)localObject1).a((String)localObject2, "", ((StringBuilder)localObject3).toString(), "11", "12", "0", str, "", "4", false);
            return true;
            localException1 = localException1;
            continue;
            localException2 = localException2;
          }
        }
        catch (Exception localException3)
        {
          break label367;
        }
      }
    }
    l = 0L;
    if (l <= 0L) {
      return false;
    }
    str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qzone_ext_str"));
    ((Bundle)localObject1).putString("open_id", str);
    ((Bundle)localObject1).putString("share_uin", (String)localObject2);
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      ((Bundle)localObject1).putString("share_ext_string", (String)localObject3);
    }
    j = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"))).intValue();
    if (j == 3)
    {
      str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
      localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
      localObject2 = new ArrayList();
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = ((String)localObject3).split(";");
        i = 0;
        while (i < localObject3.length)
        {
          ((ArrayList)localObject2).add(URLDecoder.decode(localObject3[i]));
          i += 1;
        }
      }
      ((Bundle)localObject1).putStringArrayList("images", (ArrayList)localObject2);
      ((Bundle)localObject1).putString("summary", str);
      str = "7";
    }
    else if (j == 4)
    {
      str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoPath"));
    }
  }
  
  private boolean aA()
  {
    if ("webview".equals(this.jdField_d_of_type_JavaLangString))
    {
      c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "select_location").putExtra("doCallBack", true).putExtra("src_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type")).putExtra("callback_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type")).putExtra("callback_name", (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name")));
    }
    return true;
  }
  
  private boolean aB()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("card_type");
    if (QSecFramework.a().a(1003).booleanValue())
    {
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      SecShareInfoUtil.a().a(5, str1, 0, str2);
      SecShareInfoUtil.a().a();
    }
    if ((str1 != null) && ("group".equals(str1)))
    {
      a(10010, a());
      return aK();
    }
    if ("groupsearchsetting".equalsIgnoreCase(str1)) {
      return aI();
    }
    if ("groupmanager".equalsIgnoreCase(str1)) {
      return aJ();
    }
    if ("public_account".equals(str1))
    {
      a(10003, a());
      return aD();
    }
    if ("troopmember".equals(str1)) {
      return aM();
    }
    if ("crm".equals(str1)) {
      return aE();
    }
    if ("nearby".equals(str1)) {
      return aC();
    }
    if ("allpeoplevote".equals(str1)) {
      return aF();
    }
    if ("troopmemberfromhb".equals(str1)) {
      return aO();
    }
    if ("groupsetting".equals(str1)) {
      return aN();
    }
    a(10002, a());
    return aG();
  }
  
  private boolean aC()
  {
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("source_id")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source_id");
    } else {
      str1 = "";
    }
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("reportsource")) {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("reportsource");
    } else {
      localObject = "";
    }
    boolean bool1;
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_now_plugin")) && ("1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("from_now_plugin")))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("now_id")) {}
    try
    {
      l2 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("now_id")).longValue();
    }
    catch (Exception localException1)
    {
      long l2;
      label147:
      label196:
      break label147;
    }
    QLog.i("JumpAction", 1, "illegal now_id");
    l2 = 0L;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("now_user_type")) {}
    try
    {
      i = Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("now_user_type")).intValue();
    }
    catch (Exception localException2)
    {
      int i;
      break label196;
    }
    QLog.i("JumpAction", 1, "illegal now_user_type");
    i = 0;
    try
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("tinnyid")) {
        break label1346;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tinnyid");
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        String str2;
        long l1;
        continue;
        String str3 = "";
        continue;
        str3 = "";
        continue;
        str3 = "";
        continue;
        str3 = "0";
      }
    }
    if (TextUtils.isEmpty(str2)) {
      l1 = 0L;
    } else {
      l1 = Long.valueOf(str2).longValue();
    }
    break label269;
    l1 = 0L;
    try
    {
      label269:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        break label1353;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      j = Integer.parseInt(str2);
    }
    catch (Exception localException4)
    {
      int j;
      label309:
      break label309;
    }
    j = 0;
    label400:
    try
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("mode")) {
        break label1360;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mode");
      k = Integer.valueOf(str2).intValue();
    }
    catch (Exception localException5)
    {
      int k;
      label354:
      break label354;
    }
    k = -1;
    try
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("refresh")) {
        break label1367;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("refresh");
      m = Integer.valueOf(str2).intValue();
    }
    catch (Exception localException6)
    {
      int m;
      Intent localIntent;
      break label400;
    }
    m = 0;
    if ((k != 1) && (k != 2) && (k != 3) && (k != 4)) {
      return false;
    }
    localIntent = new Intent();
    localIntent.putExtra("refresh_flag", m);
    localIntent.putExtra("is_from_now_plugin", bool1);
    localIntent.putExtra("now_id", l2);
    localIntent.putExtra("now_id_type", i);
    a(localIntent);
    if ((k != 1) && (k != 2)) {
      if (k != 3) {
        if (k == 4) {}
      }
    }
    for (;;)
    {
      return true;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null) {
        localObject = ((QQAppInterface)localObject).getAccount();
      } else if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      } else {
        localObject = "";
      }
      localObject = new AllInOne((String)localObject, 0);
      localIntent.putExtra("is_from_web", true);
      localIntent.putExtra("param_mode", k);
      localIntent.putExtra("AllInOne", (Parcelable)localObject);
      localIntent.addFlags(268435456);
      localIntent.putExtra("param_tiny_id", l1);
      RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, localIntent, "/nearby/people/profile");
      continue;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      } else {
        str1 = "";
      }
      if ((l1 == 0L) && (TextUtils.isEmpty(str1)) && (l2 == 0L)) {
        return false;
      }
      localIntent.putExtra("param_mode", 3);
      localIntent.putExtra("param_tiny_id", l1);
      if (10002 == j) {
        localIntent.addFlags(268435456);
      }
      localIntent.putExtra("is_from_web", true);
      localIntent.putExtra("NEARBY_MSG_REPORT_SOURCE", (String)localObject);
      localObject = new AllInOne(str1, 19);
      if (j == 1)
      {
        localIntent.putExtra("frome_where", 12);
        ((AllInOne)localObject).pa = 86;
        localIntent.addFlags(268435456);
      }
      if (j == 2)
      {
        ((AllInOne)localObject).pa = 87;
        localIntent.addFlags(268435456);
      }
      if (j == 3)
      {
        ((AllInOne)localObject).pa = 88;
        localIntent.addFlags(268435456);
      }
      if (j >= 7)
      {
        localIntent.putExtra("frome_where", j);
        ((AllInOne)localObject).pa = 86;
        localIntent.addFlags(268435456);
      }
      localIntent.putExtra("AllInOne", (Parcelable)localObject);
      RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, localIntent, "/nearby/people/profile");
      continue;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null) {
        localObject = ((QQAppInterface)localObject).getAccount();
      } else if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      } else {
        localObject = "";
      }
      if (Utils.a(str1, "1001"))
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uid")) {
          str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uid");
        } else {
          str2 = "";
        }
        String str4;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("PUSH_CONTENT")) {
          str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PUSH_CONTENT");
        } else {
          str4 = "";
        }
        if (!Utils.a(str2, localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.i("JumpAction", 2, "gotoNearybyProfile,return caused by different uid");
          }
          return true;
        }
        localIntent.putExtra("PUSH_CONTENT", str4);
        localIntent.putExtra("frome_where", -1);
        localIntent.addFlags(67108864);
      }
      else
      {
        localIntent.putExtra("is_from_web", true);
      }
      boolean bool2 = false;
      localObject = new AllInOne((String)localObject, 0);
      if (j == 1)
      {
        localIntent.putExtra("frome_where", 12);
        ((AllInOne)localObject).pa = 86;
        localIntent.addFlags(268435456);
      }
      if (j == 2)
      {
        ((AllInOne)localObject).pa = 87;
        localIntent.addFlags(268435456);
      }
      if (j == 3)
      {
        ((AllInOne)localObject).pa = 88;
        localIntent.addFlags(268435456);
      }
      if (j >= 7)
      {
        localIntent.putExtra("frome_where", j);
        ((AllInOne)localObject).pa = 86;
        localIntent.addFlags(268435456);
      }
      localIntent.putExtra("param_mode", k);
      localIntent.putExtra("AllInOne", (Parcelable)localObject);
      bool1 = bool2;
      if (!TextUtils.isEmpty(str1))
      {
        bool1 = bool2;
        if (str1.equals("1000")) {
          bool1 = true;
        }
      }
      localIntent.putExtra("param_from_interest_test", bool1);
      if (10002 == j) {
        localIntent.addFlags(268435456);
      }
      localIntent.putExtra("param_tiny_id", l1);
      RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, localIntent, "/nearby/people/profile");
    }
  }
  
  private boolean aD()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_flag");
    try
    {
      i = Integer.parseInt((String)localObject2);
    }
    catch (Exception localException)
    {
      int i;
      label36:
      break label36;
    }
    i = -1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gotoShowPublicAccountCard uin: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" | accountFlag: ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" | current uin: ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      QLog.d("JumpAction", 2, ((StringBuilder)localObject2).toString());
    }
    if ((localObject1 != null) && (!"".equals(localObject1)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject1)) {
        return false;
      }
      if (((String)localObject1).length() < 5) {
        return false;
      }
      if (g())
      {
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          localObject1 = new ProfileParams.Builder();
          ((ProfileParams.Builder)localObject1).a(new ProfileParams.CurLoginUsr((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"), (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"))).d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")).c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).a(i).b((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
          ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).checkGotoProfileOrShowAcntNotCoherentDlg((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ProfileParams.Builder)localObject1).a());
          return false;
        }
      }
      else
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("source", 117);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfile((Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, i);
        ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
      }
      return true;
    }
    return false;
  }
  
  private boolean aE()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoShowCrmCard uin: ");
      localStringBuilder.append(str);
      localStringBuilder.append(" | current uin: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      QLog.d("JumpAction", 2, localStringBuilder.toString());
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (!"".equals(str))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(str)) {
          return false;
        }
        if (str.length() < 5) {
          return false;
        }
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfile(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str, -7);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean aF()
  {
    try
    {
      String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      long l = Long.parseLong(str1);
      if (l < 10000L)
      {
        if (!QLog.isColorLevel()) {
          break label303;
        }
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard invalid uin uin: %d", new Object[] { Long.valueOf(l) }));
        return false;
      }
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("name");
      String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
      Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str1);
      AllInOne localAllInOne;
      if (Utils.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        localAllInOne = new AllInOne(str1, 0);
      }
      else if ((localFriends != null) && (localFriends.isFriend()))
      {
        localAllInOne = new AllInOne(str1, 1);
        localAllInOne.nickname = localFriends.name;
        localAllInOne.remark = localFriends.remark;
      }
      else
      {
        localAllInOne = new AllInOne(str1, 95);
        localAllInOne.nickname = str2;
      }
      ProfileUtils.openProfileCard(this.jdField_a_of_type_AndroidContentContext, localAllInOne);
      if (QLog.isDevelopLevel())
      {
        QLog.i("JumpAction", 4, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard uin: %s  name: %s source: %s", new Object[] { Utils.a(str1), Utils.a(str2), str3 }));
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard exception : %s", new Object[] { localException.toString() }));
      }
    }
    return false;
    label303:
    return false;
  }
  
  private boolean aG()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean aH()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    int j = 0;
    int i = j;
    if (str != null)
    {
      i = j;
      if (!"".equals(str)) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(str))
        {
          i = j;
        }
        else
        {
          if (str.length() < 5) {
            return false;
          }
          if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str)) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
    }
    Object localObject = new AllInOne(str, i);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PersonalityLabelGalleryActivity.class);
    localIntent.putExtra("personality_label_allinone", (Parcelable)localObject);
    localIntent.putExtra("fromType", 1);
    localIntent.putExtra("uin", str);
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gotoShowPersonalityLabel. uin:");
      ((StringBuilder)localObject).append(str);
      QLog.i("JumpAction", 2, ((StringBuilder)localObject).toString());
    }
    return true;
  }
  
  private boolean aI()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str != null) && (!"".equals(str)))
    {
      if (str.length() < 5) {
        return false;
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject1 != null)
        {
          localObject1 = ((TroopManager)localObject1).b(str);
          if ((localObject1 != null) && (((TroopInfo)localObject1).isAdmin()))
          {
            i = 1;
            break label89;
          }
        }
        int i = 0;
        label89:
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("gotoGroupSearchSetting not admin ");
            ((StringBuilder)localObject1).append(str);
            QLog.i("JumpAction", 2, ((StringBuilder)localObject1).toString());
          }
          return false;
        }
        Object localObject2 = TroopInfoUIUtil.a(str, 3);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        localObject2 = new TroopManageCmd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        if (localPluginCommunicationHandler != null) {
          localPluginCommunicationHandler.register((RemoteCommand)localObject2);
        }
        localObject2 = TroopBaseProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext);
        TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, (Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopSearchWayActivity", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("gotoGroupSearchSetting ");
          ((StringBuilder)localObject1).append(str);
          QLog.i("JumpAction", 2, ((StringBuilder)localObject1).toString());
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupSearchSetting context not activity");
      }
    }
    return false;
  }
  
  private boolean aJ()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str != null) && (!"".equals(str)))
    {
      if (str.length() < 5) {
        return false;
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject1 != null)
        {
          localObject1 = ((TroopManager)localObject1).b(str);
          if ((localObject1 != null) && (((TroopInfo)localObject1).isAdmin()))
          {
            i = 1;
            break label89;
          }
        }
        int i = 0;
        label89:
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("gotoGroupManager not admin ");
            ((StringBuilder)localObject1).append(str);
            QLog.i("JumpAction", 2, ((StringBuilder)localObject1).toString());
          }
          return false;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((Intent)localObject1).putExtra("troop_uin", str);
        ((Intent)localObject1).putExtra("key_is_update_before_805", ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isUpdateBeforeSomeVersion(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
        ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
        Object localObject2 = new TroopManageCmd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        if (localPluginCommunicationHandler != null) {
          localPluginCommunicationHandler.register((RemoteCommand)localObject2);
        }
        localObject2 = TroopBaseProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext);
        TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, (Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopManageActivity", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("gotoGroupManager ");
          ((StringBuilder)localObject1).append(str);
          QLog.i("JumpAction", 2, ((StringBuilder)localObject1).toString());
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager context not activity");
      }
    }
    return false;
  }
  
  private boolean aK()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wSourceSubID");
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("isPrivate")) {
      try
      {
        if (Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("isPrivate")).intValue() == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
          ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(str2);
          return true;
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, new Object[] { "gotoShowGroupCard throw Exception ", localException1.toString() });
        }
      }
    }
    Object localObject3;
    Object localObject2;
    if ((str2 != null) && (!"".equals(str2)))
    {
      if (str2.length() < 5) {
        return false;
      }
      if ("QRJumpActivity".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from"))) {
        localObject1 = TroopInfoUIUtil.a(str2, 14);
      } else {
        localObject1 = TroopInfoUIUtil.a(str2, 5);
      }
      if ("d2g".equals(this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
      {
        localObject1 = TroopInfoUIUtil.a(str2, 16);
        ((Bundle)localObject1).putInt("D2GType", 2);
      }
      localObject3 = localObject1;
      Object localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from_group_search"))) {
        try
        {
          localObject1 = TroopInfoUIUtil.a(str2, Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from_group_search")));
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          localObject2 = localObject3;
        }
      }
      if ("h5".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
      {
        localObject2 = TroopInfoUIUtil.a(str2, 22);
      }
      else if ("groupprofile".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
      {
        localObject2 = TroopInfoUIUtil.a(str2, 22);
        ((Bundle)localObject2).putBoolean("troop_info_from_troopsetting", true);
      }
      if ("webapi".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from"))) {
        if ("3_40002".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("source_id"))) {
          ((Bundle)localObject2).putInt("troop_info_from_ex", 40002);
        } else {
          ((Bundle)localObject2).putInt("troop_info_from_ex", 40001);
        }
      }
    }
    try
    {
      i = Integer.parseInt(str1);
      j = i;
      if (i == 43) {
        j = 10002;
      }
      if (j == 33) {
        ((Bundle)localObject2).putInt("troop_info_from", 24);
      } else if (j == 43) {
        ((Bundle)localObject2).putInt("troop_info_from", 27);
      } else if (j == 37) {
        ((Bundle)localObject2).putInt("troop_info_from", 30);
      } else if (j == 10008) {
        ((Bundle)localObject2).putInt("troop_info_from", 102);
      } else if (j == 10013) {
        ((Bundle)localObject2).putInt("troop_info_from", 106);
      } else if ((j >= 30006) && (j <= 30020)) {
        ((Bundle)localObject2).putInt("troop_info_from", j);
      }
      localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sourceext");
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isexactsearch");
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (str2 != null)
        {
          i = j;
          if (!((String)localObject3).isEmpty())
          {
            i = j;
            if (!str2.isEmpty())
            {
              k = Integer.parseInt((String)localObject3);
              if (Integer.parseInt(str2) != 1) {
                break label995;
              }
              i = 1;
            }
          }
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int j;
        int k;
        continue;
        int i = 0;
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3)
            {
              if (k != 4)
              {
                if (k != 5)
                {
                  i = j;
                  continue;
                }
                if (i != 0)
                {
                  i = 30018;
                  continue;
                }
                i = 30020;
                continue;
              }
              if (i != 0)
              {
                i = 30014;
                continue;
              }
              i = 30016;
              continue;
            }
            if (i != 0)
            {
              i = 30010;
              continue;
            }
            i = 30012;
            continue;
          }
          if (i == 0) {}
        }
        while (i != 0)
        {
          i = 30004;
          break;
          i = 30008;
          break;
        }
        i = 30006;
      }
    }
    ((Bundle)localObject2).putInt("troop_info_from_ex", i);
    break label720;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("cast source sub id from web error, sourceSubId = ");
      ((StringBuilder)localObject3).append(str1);
      QLog.d("JumpAction", 2, ((StringBuilder)localObject3).toString());
    }
    label720:
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"))) && (Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type")) == 100))
    {
      ((Bundle)localObject2).putBoolean("from_babyq", true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007245", "0X8007245", 0, 0, "", "", "", "");
    }
    ((Bundle)localObject2).putString("authKey", (String)this.jdField_a_of_type_JavaUtilHashMap.get("authKey"));
    ((Bundle)localObject2).putString("authSig", (String)this.jdField_a_of_type_JavaUtilHashMap.get("authSig"));
    ((Bundle)localObject2).putString("keyword", (String)this.jdField_a_of_type_JavaUtilHashMap.get("keyword"));
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, String.format("gotoShowGroupCard troop_authSig=%s", new Object[] { this.jdField_a_of_type_JavaUtilHashMap.get("authSig") }));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
      ((Bundle)localObject2).putString("appid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) {
      ((Bundle)localObject2).putString("openid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid"));
    }
    TroopUtils.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject2, 2);
    return true;
    return false;
  }
  
  private boolean aL()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((localObject != null) && (!"".equals(localObject)) && (((String)localObject).length() >= 5))
    {
      localObject = TroopInfoUIUtil.a((String)localObject, 14);
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
        ((Bundle)localObject).putString("appid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) {
        ((Bundle)localObject).putString("openid", c(JumpAction.m));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("openkey")) {
        ((Bundle)localObject).putString("openkey", (String)this.jdField_a_of_type_JavaUtilHashMap.get("openkey"));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("is_from_game")) {
        ((Bundle)localObject).putString("is_from_game", (String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("guild_id")) {
        ((Bundle)localObject).putString("guild_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("guild_id"));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("zone_id")) {
        ((Bundle)localObject).putString("zone_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("zone_id"));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("role_id")) {
        ((Bundle)localObject).putString("role_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("role_id"));
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("gc")) {
        ((Bundle)localObject).putString("gc", (String)this.jdField_a_of_type_JavaUtilHashMap.get("gc"));
      }
      TroopUtils.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject, 2);
      return true;
    }
    return false;
  }
  
  /* Error */
  private boolean aM()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 1350
    //   7: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 18	java/lang/String
    //   13: astore 5
    //   15: aload_0
    //   16: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: ldc_w 2793
    //   22: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 18	java/lang/String
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   33: ldc_w 693
    //   36: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 18	java/lang/String
    //   42: astore_2
    //   43: aload_0
    //   44: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   47: ldc_w 2795
    //   50: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: checkcast 18	java/lang/String
    //   56: astore_3
    //   57: aload_0
    //   58: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   61: ldc_w 786
    //   64: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 18	java/lang/String
    //   70: ldc_w 2797
    //   73: invokestatic 2799	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 4
    //   78: aload_0
    //   79: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   82: ldc_w 2801
    //   85: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: checkcast 18	java/lang/String
    //   91: ldc_w 2797
    //   94: invokestatic 2799	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 6
    //   99: aload_0
    //   100: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   103: ldc_w 2803
    //   106: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 18	java/lang/String
    //   112: ldc_w 2797
    //   115: invokestatic 2799	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 10
    //   120: aload_0
    //   121: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   124: ldc_w 2805
    //   127: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: checkcast 18	java/lang/String
    //   133: ldc_w 2797
    //   136: invokestatic 2799	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 7
    //   141: aload_0
    //   142: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   145: ldc_w 2807
    //   148: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: checkcast 18	java/lang/String
    //   154: ldc_w 2797
    //   157: invokestatic 2799	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   160: astore 8
    //   162: aload_0
    //   163: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   166: ldc_w 2809
    //   169: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   172: checkcast 18	java/lang/String
    //   175: ldc_w 2797
    //   178: invokestatic 2799	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 9
    //   183: aload 5
    //   185: astore 11
    //   187: aload 7
    //   189: astore 5
    //   191: aload 8
    //   193: astore 7
    //   195: aload 10
    //   197: astore 8
    //   199: aload_1
    //   200: astore 14
    //   202: aload_2
    //   203: astore 12
    //   205: aload_3
    //   206: astore_1
    //   207: aload 4
    //   209: astore 10
    //   211: goto +521 -> 732
    //   214: astore 9
    //   216: aload 7
    //   218: astore 11
    //   220: aload 8
    //   222: astore 7
    //   224: goto +60 -> 284
    //   227: astore 9
    //   229: aload 7
    //   231: astore 11
    //   233: aload 8
    //   235: astore 7
    //   237: goto +88 -> 325
    //   240: astore 9
    //   242: ldc 135
    //   244: astore 8
    //   246: aload 7
    //   248: astore 11
    //   250: aload 8
    //   252: astore 7
    //   254: goto +30 -> 284
    //   257: astore 9
    //   259: ldc 135
    //   261: astore 8
    //   263: aload 7
    //   265: astore 11
    //   267: aload 8
    //   269: astore 7
    //   271: goto +54 -> 325
    //   274: astore 9
    //   276: ldc 135
    //   278: astore 11
    //   280: aload 11
    //   282: astore 7
    //   284: aload 10
    //   286: astore 8
    //   288: aload 9
    //   290: astore 15
    //   292: aload_1
    //   293: astore 14
    //   295: aload_2
    //   296: astore 13
    //   298: aload_3
    //   299: astore 12
    //   301: aload 4
    //   303: astore 10
    //   305: aload 11
    //   307: astore_1
    //   308: aload 7
    //   310: astore 9
    //   312: goto +306 -> 618
    //   315: astore 9
    //   317: ldc 135
    //   319: astore 11
    //   321: aload 11
    //   323: astore 7
    //   325: aload 10
    //   327: astore 8
    //   329: aload 9
    //   331: astore 10
    //   333: aload 7
    //   335: astore 9
    //   337: goto +348 -> 685
    //   340: astore 7
    //   342: ldc 135
    //   344: astore 9
    //   346: aload_1
    //   347: astore 8
    //   349: aload 9
    //   351: astore_1
    //   352: goto +237 -> 589
    //   355: astore 7
    //   357: ldc 135
    //   359: astore 9
    //   361: aload_1
    //   362: astore 8
    //   364: aload 9
    //   366: astore_1
    //   367: goto +297 -> 664
    //   370: astore 7
    //   372: ldc 135
    //   374: astore 6
    //   376: aload_1
    //   377: astore 8
    //   379: aload 4
    //   381: astore_1
    //   382: goto +123 -> 505
    //   385: astore 7
    //   387: ldc 135
    //   389: astore 6
    //   391: aload_1
    //   392: astore 8
    //   394: aload 4
    //   396: astore_1
    //   397: goto +154 -> 551
    //   400: astore 4
    //   402: ldc 135
    //   404: astore 6
    //   406: aload_1
    //   407: astore 7
    //   409: aload 6
    //   411: astore_1
    //   412: goto +82 -> 494
    //   415: astore 4
    //   417: ldc 135
    //   419: astore 6
    //   421: aload_1
    //   422: astore 7
    //   424: aload 6
    //   426: astore_1
    //   427: goto +113 -> 540
    //   430: astore 4
    //   432: ldc 135
    //   434: astore_3
    //   435: aload_1
    //   436: astore 7
    //   438: aload_2
    //   439: astore 6
    //   441: aload_3
    //   442: astore_2
    //   443: goto +44 -> 487
    //   446: astore 4
    //   448: ldc 135
    //   450: astore_3
    //   451: aload_1
    //   452: astore 7
    //   454: aload_2
    //   455: astore 6
    //   457: aload_3
    //   458: astore_2
    //   459: goto +74 -> 533
    //   462: astore 4
    //   464: goto +13 -> 477
    //   467: astore 4
    //   469: goto +54 -> 523
    //   472: astore 4
    //   474: ldc 135
    //   476: astore_1
    //   477: ldc 135
    //   479: astore 6
    //   481: ldc 135
    //   483: astore_2
    //   484: aload_1
    //   485: astore 7
    //   487: aload_2
    //   488: astore_1
    //   489: aload_2
    //   490: astore_3
    //   491: aload 6
    //   493: astore_2
    //   494: aload_1
    //   495: astore 6
    //   497: aload 7
    //   499: astore 8
    //   501: aload 4
    //   503: astore 7
    //   505: aload 6
    //   507: astore 9
    //   509: aload_1
    //   510: astore 4
    //   512: aload 9
    //   514: astore_1
    //   515: goto +74 -> 589
    //   518: astore 4
    //   520: ldc 135
    //   522: astore_1
    //   523: ldc 135
    //   525: astore 6
    //   527: ldc 135
    //   529: astore_2
    //   530: aload_1
    //   531: astore 7
    //   533: aload_2
    //   534: astore_1
    //   535: aload_2
    //   536: astore_3
    //   537: aload 6
    //   539: astore_2
    //   540: aload_1
    //   541: astore 6
    //   543: aload 7
    //   545: astore 8
    //   547: aload 4
    //   549: astore 7
    //   551: aload 6
    //   553: astore 9
    //   555: aload_1
    //   556: astore 4
    //   558: aload 9
    //   560: astore_1
    //   561: goto +103 -> 664
    //   564: astore 7
    //   566: ldc 135
    //   568: astore 8
    //   570: aload 8
    //   572: astore_2
    //   573: aload_2
    //   574: astore_3
    //   575: aload_3
    //   576: astore 4
    //   578: aload 4
    //   580: astore 6
    //   582: aload 6
    //   584: astore 5
    //   586: aload 5
    //   588: astore_1
    //   589: ldc 135
    //   591: astore 11
    //   593: aload_1
    //   594: astore 9
    //   596: aload 4
    //   598: astore 10
    //   600: aload_3
    //   601: astore 12
    //   603: aload_2
    //   604: astore 13
    //   606: aload 8
    //   608: astore 14
    //   610: aload 11
    //   612: astore 8
    //   614: aload 7
    //   616: astore 15
    //   618: aload 15
    //   620: invokevirtual 2810	java/lang/NullPointerException:printStackTrace	()V
    //   623: aload 14
    //   625: astore_2
    //   626: aload 13
    //   628: astore_3
    //   629: aload 12
    //   631: astore 4
    //   633: aload_1
    //   634: astore 11
    //   636: goto +65 -> 701
    //   639: astore 7
    //   641: ldc 135
    //   643: astore 8
    //   645: aload 8
    //   647: astore_2
    //   648: aload_2
    //   649: astore_3
    //   650: aload_3
    //   651: astore 4
    //   653: aload 4
    //   655: astore 6
    //   657: aload 6
    //   659: astore 5
    //   661: aload 5
    //   663: astore_1
    //   664: ldc 135
    //   666: astore 10
    //   668: aload_1
    //   669: astore 9
    //   671: aload_1
    //   672: astore 11
    //   674: aload 8
    //   676: astore_1
    //   677: aload 10
    //   679: astore 8
    //   681: aload 7
    //   683: astore 10
    //   685: aload 10
    //   687: invokevirtual 1597	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   690: aload 4
    //   692: astore 10
    //   694: aload_3
    //   695: astore 4
    //   697: aload_2
    //   698: astore_3
    //   699: aload_1
    //   700: astore_2
    //   701: ldc 135
    //   703: astore_1
    //   704: aload 5
    //   706: astore 13
    //   708: aload 9
    //   710: astore 7
    //   712: aload 11
    //   714: astore 5
    //   716: aload_1
    //   717: astore 9
    //   719: aload 4
    //   721: astore_1
    //   722: aload_3
    //   723: astore 12
    //   725: aload_2
    //   726: astore 14
    //   728: aload 13
    //   730: astore 11
    //   732: aload 12
    //   734: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   737: ifne +245 -> 982
    //   740: aload 14
    //   742: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   745: ifeq +6 -> 751
    //   748: goto +234 -> 982
    //   751: aload_0
    //   752: getfield 67	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   755: ifnull +195 -> 950
    //   758: ldc_w 2812
    //   761: invokestatic 81	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   764: checkcast 2812	com/tencent/mobileqq/profilecard/api/IProfileCardApi
    //   767: invokeinterface 2815 1 0
    //   772: astore_2
    //   773: new 372	android/content/Intent
    //   776: dup
    //   777: aload_0
    //   778: getfield 67	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   781: aload_2
    //   782: invokespecial 668	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   785: astore_2
    //   786: aload_2
    //   787: ldc_w 2817
    //   790: aload 14
    //   792: invokevirtual 387	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   795: pop
    //   796: new 556	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   803: astore_3
    //   804: aload_3
    //   805: ldc 135
    //   807: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: aload_3
    //   812: aload 12
    //   814: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: aload_2
    //   819: ldc_w 2819
    //   822: aload_3
    //   823: invokevirtual 564	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokevirtual 387	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   829: pop
    //   830: ldc_w 691
    //   833: aload 11
    //   835: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   838: ifeq +15 -> 853
    //   841: aload_2
    //   842: ldc_w 2821
    //   845: iconst_0
    //   846: invokevirtual 974	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   849: pop
    //   850: goto +13 -> 863
    //   853: aload_2
    //   854: ldc_w 2821
    //   857: bipush 6
    //   859: invokevirtual 974	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   862: pop
    //   863: new 174	android/os/Bundle
    //   866: dup
    //   867: invokespecial 176	android/os/Bundle:<init>	()V
    //   870: astore_3
    //   871: aload_3
    //   872: ldc_w 2793
    //   875: aload_1
    //   876: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   879: aload_3
    //   880: ldc_w 786
    //   883: aload 10
    //   885: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   888: aload_3
    //   889: ldc_w 2801
    //   892: aload 6
    //   894: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   897: aload_3
    //   898: ldc_w 2803
    //   901: aload 8
    //   903: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   906: aload_3
    //   907: ldc_w 2805
    //   910: aload 5
    //   912: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   915: aload_3
    //   916: ldc_w 2807
    //   919: aload 7
    //   921: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   924: aload_3
    //   925: ldc_w 2809
    //   928: aload 9
    //   930: invokevirtual 182	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   933: aload_2
    //   934: ldc_w 911
    //   937: aload_3
    //   938: invokevirtual 1251	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   941: pop
    //   942: aload_0
    //   943: getfield 67	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   946: aload_2
    //   947: invokevirtual 684	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   950: aload_0
    //   951: getfield 49	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   954: ldc_w 1699
    //   957: ldc 135
    //   959: ldc 135
    //   961: ldc_w 2823
    //   964: ldc_w 2823
    //   967: iconst_0
    //   968: iconst_0
    //   969: ldc 135
    //   971: ldc 135
    //   973: ldc 135
    //   975: ldc 135
    //   977: invokestatic 1125	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   980: iconst_1
    //   981: ireturn
    //   982: iconst_0
    //   983: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	984	0	this	JumpActionLegacy
    //   28	848	1	localObject1	Object
    //   42	905	2	localObject2	Object
    //   56	882	3	localObject3	Object
    //   76	319	4	str1	String
    //   400	1	4	localNullPointerException1	java.lang.NullPointerException
    //   415	1	4	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   430	1	4	localNullPointerException2	java.lang.NullPointerException
    //   446	1	4	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   462	1	4	localNullPointerException3	java.lang.NullPointerException
    //   467	1	4	localUnsupportedEncodingException3	UnsupportedEncodingException
    //   472	30	4	localNullPointerException4	java.lang.NullPointerException
    //   510	1	4	localObject4	Object
    //   518	30	4	localUnsupportedEncodingException4	UnsupportedEncodingException
    //   556	164	4	localObject5	Object
    //   13	898	5	localObject6	Object
    //   97	796	6	localObject7	Object
    //   139	195	7	localObject8	Object
    //   340	1	7	localNullPointerException5	java.lang.NullPointerException
    //   355	1	7	localUnsupportedEncodingException5	UnsupportedEncodingException
    //   370	1	7	localNullPointerException6	java.lang.NullPointerException
    //   385	1	7	localUnsupportedEncodingException6	UnsupportedEncodingException
    //   407	143	7	localObject9	Object
    //   564	51	7	localNullPointerException7	java.lang.NullPointerException
    //   639	43	7	localUnsupportedEncodingException7	UnsupportedEncodingException
    //   710	210	7	localObject10	Object
    //   160	742	8	localObject11	Object
    //   181	1	9	str2	String
    //   214	1	9	localNullPointerException8	java.lang.NullPointerException
    //   227	1	9	localUnsupportedEncodingException8	UnsupportedEncodingException
    //   240	1	9	localNullPointerException9	java.lang.NullPointerException
    //   257	1	9	localUnsupportedEncodingException9	UnsupportedEncodingException
    //   274	15	9	localNullPointerException10	java.lang.NullPointerException
    //   310	1	9	localObject12	Object
    //   315	15	9	localUnsupportedEncodingException10	UnsupportedEncodingException
    //   335	594	9	localObject13	Object
    //   118	766	10	localObject14	Object
    //   185	649	11	localObject15	Object
    //   203	610	12	localObject16	Object
    //   296	433	13	localObject17	Object
    //   200	591	14	localObject18	Object
    //   290	329	15	localNullPointerException11	java.lang.NullPointerException
    // Exception table:
    //   from	to	target	type
    //   162	183	214	java/lang/NullPointerException
    //   162	183	227	java/io/UnsupportedEncodingException
    //   141	162	240	java/lang/NullPointerException
    //   141	162	257	java/io/UnsupportedEncodingException
    //   120	141	274	java/lang/NullPointerException
    //   120	141	315	java/io/UnsupportedEncodingException
    //   99	120	340	java/lang/NullPointerException
    //   99	120	355	java/io/UnsupportedEncodingException
    //   78	99	370	java/lang/NullPointerException
    //   78	99	385	java/io/UnsupportedEncodingException
    //   57	78	400	java/lang/NullPointerException
    //   57	78	415	java/io/UnsupportedEncodingException
    //   43	57	430	java/lang/NullPointerException
    //   43	57	446	java/io/UnsupportedEncodingException
    //   29	43	462	java/lang/NullPointerException
    //   29	43	467	java/io/UnsupportedEncodingException
    //   15	29	472	java/lang/NullPointerException
    //   15	29	518	java/io/UnsupportedEncodingException
    //   0	15	564	java/lang/NullPointerException
    //   0	15	639	java/io/UnsupportedEncodingException
  }
  
  private boolean aN()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("focus_item");
    TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str1, str2);
    return true;
  }
  
  private boolean aO()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("troopuin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str1, str2, 9, -1);
      return true;
    }
    return false;
  }
  
  private boolean aP()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("attr_original_url");
    boolean bool3 = this.jdField_a_of_type_AndroidContentContext instanceof Activity;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      Intent localIntent = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if (localIntent == null) {
        bool1 = bool2;
      } else {
        bool1 = localIntent.getBooleanExtra("fromQrcode", false);
      }
    }
    ((IQRJumpApi)QRoute.api(IQRJumpApi.class)).startQRJumpActivity(this.jdField_a_of_type_AndroidContentContext, str1, str2, bool1);
    return true;
  }
  
  private boolean aQ()
  {
    if ("webview".equals(this.jdField_d_of_type_JavaLangString))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bus_type");
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "photo").putExtra("doCallBack", true).putExtra("src_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type")).putExtra("callback_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type")).putExtra("callback_name", (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name")));
    }
    return true;
  }
  
  private boolean aR()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BindGroupActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("skey", ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str1;
      if (!str2.equals("src_type")) {
        str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));
      } else {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2);
      }
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString(str2, str1);
      }
    }
    localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("key_params", localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean aS()
  {
    System.currentTimeMillis();
    Object localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if ((localObject3 != null) && ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://"))) && ((Util.b((String)localObject3).equalsIgnoreCase("qq.com")) || (Util.b((String)localObject3).equalsIgnoreCase("myun.tenpay.com")) || (Util.b((String)localObject3).equalsIgnoreCase("tenpay.com")) || (Util.b((String)localObject3).equalsIgnoreCase("wanggou.com")) || (Util.b((String)localObject3).equalsIgnoreCase("tencent.com")) || (Util.b((String)localObject3).equalsIgnoreCase("jd.com")) || (Util.b((String)localObject3).equalsIgnoreCase("qcloud.com")) || (Util.b((String)localObject3).equalsIgnoreCase("webank.com")) || (Util.b((String)localObject3).equalsIgnoreCase("qqumall.com"))))
    {
      if ((((String)localObject3).startsWith("https://jiazhang.qq.com/wap/com/")) || (((String)localObject3).startsWith("https://test.jiazhang.qq.com/wap/com/")))
      {
        if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid")))) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"), "");
        }
      }
      else
      {
        Object localObject1 = (IWeatherCommApi)QRoute.api(IWeatherCommApi.class);
        if (((IWeatherCommApi)localObject1).isWeatherArkPageUrl((String)localObject3))
        {
          ((IWeatherCommApi)localObject1).startNewWeatherWebPageActivityByFollowState(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, (String)localObject3);
          return true;
        }
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("style");
        String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
        String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_auth");
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_nld");
        String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_dev");
        String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_usr");
        String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_vkey");
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append((String)localObject3);
        if (localStringBuffer.indexOf("?") < 0) {
          localStringBuffer.append("?");
        } else if (localStringBuffer.indexOf("?") < localStringBuffer.length() - 1) {
          if (localStringBuffer.indexOf("&") < 0) {
            localStringBuffer.append("&");
          } else if (localStringBuffer.lastIndexOf("&") < localStringBuffer.length() - 1) {
            localStringBuffer.append("&");
          }
        }
        localObject3 = new Cryptor();
        int i;
        if ("1".equals(str2))
        {
          localStringBuffer.append("plg_auth=1");
          localStringBuffer.append("&");
          i = 1;
        }
        else
        {
          i = 0;
        }
        if ("1".equals(str3))
        {
          localStringBuffer.append("plg_dev=1");
          localStringBuffer.append("&");
          localStringBuffer.append("MOBINFO=");
          localStringBuffer.append(HexUtil.bytes2HexStr(((Cryptor)localObject3).encrypt(c().getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
          localStringBuffer.append("&");
          i = 1;
        }
        if ("1".equals(str4))
        {
          localStringBuffer.append("plg_usr=1");
          localStringBuffer.append("&");
          localStringBuffer.append("USER=");
          localStringBuffer.append(HexUtil.bytes2HexStr(((Cryptor)localObject3).encrypt(HardCodeUtil.a(2131705984).getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
          localStringBuffer.append("&");
          i = 1;
        }
        int j = i;
        if ("1".equals(str5))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getvKeyStr();
          j = i;
          if (localObject3 != null)
          {
            localStringBuffer.append("plg_vkey=1");
            localStringBuffer.append("&mqqvkey=");
            localStringBuffer.append((String)localObject3);
            localStringBuffer.append("&");
            j = 1;
          }
        }
        if ((this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.length() > 0))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.jdField_g_of_type_JavaLangString);
          ((StringBuilder)localObject3).append("&");
          localStringBuffer.append(((StringBuilder)localObject3).toString());
        }
        str2 = b("download_sourceid");
        if ("1".equals(localObject1))
        {
          localStringBuffer.append("plg_nld=1");
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class).putExtra("url", localStringBuffer.toString());
          ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
          if ((str1 != null) && (!str1.equals(""))) {
            ((Intent)localObject1).putExtra("title", str1);
          }
          ((Intent)localObject1).putExtra("reportNldFormPlugin", true);
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          return true;
        }
        if (j != 0) {
          localStringBuffer.deleteCharAt(localStringBuffer.lastIndexOf("&"));
        }
        localObject1 = localStringBuffer.toString();
        if (((String)localObject1).startsWith("http://story.now.qq.com/mobile/transfer_q.html"))
        {
          localObject1 = URLUtil.b(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
          if (!TextUtils.isEmpty((String)((Map)localObject1).get("storysharefrom")))
          {
            this.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject1);
            if (this.jdField_a_of_type_JavaUtilHashMap.get("type") == null)
            {
              this.jdField_c_of_type_JavaLangString = "opencontent";
            }
            else
            {
              i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("type"));
              if (i != 0)
              {
                if (i != 1)
                {
                  if (i != 2) {
                    return true;
                  }
                  this.jdField_c_of_type_JavaLangString = "opentopic";
                }
                else
                {
                  this.jdField_c_of_type_JavaLangString = "openVideo";
                }
              }
              else {
                this.jdField_c_of_type_JavaLangString = "opencontent";
              }
            }
            return N();
          }
        }
        else if (((String)localObject1).startsWith("http://story.now.qq.com/mobile/transfer_q2.html"))
        {
          localObject1 = URLUtil.b(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
          this.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject1);
          localObject1 = (String)((Map)localObject1).get("contentType");
          if ((localObject1 == null) || (((String)localObject1).equals("0")))
          {
            if (this.jdField_a_of_type_JavaUtilHashMap.get("actionnamekey") != null) {
              i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("actionnamekey"));
            } else {
              i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("type"));
            }
            if (i != 0)
            {
              if (i != 1)
              {
                if (i != 2)
                {
                  if (i != 3) {
                    return true;
                  }
                  this.jdField_c_of_type_JavaLangString = "infoCard";
                }
                else
                {
                  this.jdField_c_of_type_JavaLangString = "opentopic";
                }
              }
              else {
                this.jdField_c_of_type_JavaLangString = "openVideo";
              }
            }
            else {
              this.jdField_c_of_type_JavaLangString = "opencontent";
            }
            return N();
          }
        }
        else
        {
          if (((String)localObject1).contains("lbs.qidian.qq.com/authorize/voiceShow"))
          {
            localObject3 = localStringBuffer.toString();
            localObject1 = localObject3;
            if (((String)localObject3).endsWith("&")) {
              localObject1 = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
            }
            localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
            ((Intent)localObject3).putExtra("url", (String)localObject1);
            ((Intent)localObject3).putExtra("fragment_class", QidianWebViewFragment.class.getCanonicalName());
            ((Intent)localObject3).putExtra("key_isReadModeEnabled", true);
            ((Intent)localObject3).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            if ((str1 != null) && (!str1.equals(""))) {
              ((Intent)localObject3).putExtra("title", str1);
            }
            ((Intent)localObject3).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((Intent)localObject3).putExtra("plugin_start_time", System.nanoTime());
            ((Intent)localObject3).putExtra("click_start_time", System.currentTimeMillis());
            ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
            try
            {
              ((Intent)localObject3).putExtra("leba_resid", Long.parseLong(b("leba_resid")));
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
            ((Intent)localObject3).putExtra("has_red_dot", this.jdField_d_of_type_Boolean);
            ((Intent)localObject3).putExtra("is_from_leba", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
            return true;
          }
          if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
          {
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            if (MiniAppJumpUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, localException1, (Bundle)localObject3)) {
              return true;
            }
          }
        }
        if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.trim().equalsIgnoreCase("com.tx.android.txnews.new")))
        {
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class).putExtra("url", localStringBuffer.toString());
          ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
          ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if ((str1 != null) && (!str1.equals(""))) {
            ((Intent)localObject2).putExtra("title", str1);
          }
          ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((Intent)localObject2).putExtra("param_force_internal_browser", false);
          ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
          ((Intent)localObject2).putExtra("injectrecommend", true);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
          return true;
        }
        if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.trim().equalsIgnoreCase("com.qq.yijianfankui")))
        {
          localStringBuffer.append("&version=8.7.0.5295");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("&appid=");
          ((StringBuilder)localObject2).append(AppSetting.a());
          localStringBuffer.append(((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("&QUA=");
          ((StringBuilder)localObject2).append(QUA.getQUA3());
          localStringBuffer.append(((StringBuilder)localObject2).toString());
          localStringBuffer.append("&adtag=5295");
          localObject2 = Build.MODEL;
          if (localObject2 != null) {
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
          } else {
            localObject2 = "";
          }
          i = StatisticCollector.getQzonePatchTag();
          localObject3 = localObject2;
          if (i > 0)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append("_qzpatch");
            ((StringBuilder)localObject3).append(i);
            localObject3 = ((StringBuilder)localObject3).toString();
          }
          localObject2 = Build.MANUFACTURER;
          if (localObject2 != null) {
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
          } else {
            localObject2 = "";
          }
          localStringBuffer.append("&model=");
          localStringBuffer.append((String)localObject3);
          localStringBuffer.append("&manufacture=");
          localStringBuffer.append((String)localObject2);
          localStringBuffer.append("&cpunum=");
          localStringBuffer.append(DeviceInfoUtil.b());
          localStringBuffer.append("&cpurate=");
          localStringBuffer.append(DeviceInfoUtil.b());
          localStringBuffer.append("&mem=");
          localStringBuffer.append(DeviceInfoUtil.a() / 1024L / 1024L);
          localStringBuffer.append("&w=");
          localStringBuffer.append(DeviceInfoUtil.g());
          localStringBuffer.append("&h=");
          localStringBuffer.append(DeviceInfoUtil.h());
        }
        Object localObject2 = localStringBuffer.toString();
        if (((String)localObject2).endsWith("&")) {
          localObject2 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class).putExtra("url", (String)localObject2);
        ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
        ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((str1 != null) && (!str1.equals(""))) {
          ((Intent)localObject2).putExtra("title", str1);
        }
        ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((Intent)localObject2).putExtra("plugin_start_time", System.nanoTime());
        ((Intent)localObject2).putExtra("click_start_time", System.currentTimeMillis());
        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        try
        {
          ((Intent)localObject2).putExtra("leba_resid", Long.parseLong(b("leba_resid")));
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        ((Intent)localObject2).putExtra("has_red_dot", this.jdField_d_of_type_Boolean);
        ((Intent)localObject2).putExtra("is_from_leba", true);
        if (!TextUtils.isEmpty(str2)) {
          ((Intent)localObject2).putExtra("big_brother_source_key", str2);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        return true;
      }
      QLog.e("JumpAction", 1, "empty params");
      return false;
    }
    return false;
  }
  
  private boolean aT()
  {
    ForwardStatisticsReporter.b();
    ForwardStatisticsReporter.a("KEY_STAGE_1_TOTAL");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_uri"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("third_sd"));
    long l = ForwardUtils.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
    int i = ForwardUtils.a(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag")));
    boolean bool = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext);
    QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck appID:", Long.valueOf(l), ",file_type:", str1, ",reqType=", str2, ",third_sd=", str4, ",qq_sd=", Boolean.valueOf(bool), ",file_data=", localObject, ",file_uri=", str3 });
    if (i == 1)
    {
      e("shareToQQ");
      return true;
    }
    if (l <= 0L)
    {
      QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck appid = ", Long.valueOf(l) });
      return false;
    }
    localObject = new HashMap(4);
    ((HashMap)localObject).put("KEY_SHARE_TYPE", str2);
    ((HashMap)localObject).put("KEY_FILE_TYPE", str1);
    ((HashMap)localObject).put("KEY_THIRD_SD", str4);
    ((HashMap)localObject).put("KEY_QQ_SD", String.valueOf(bool));
    if (!TextUtils.isEmpty(str3))
    {
      this.f = false;
      ThreadManagerV2.executeOnSubThread(new JumpActionLegacy.18(this, str3, System.currentTimeMillis(), (HashMap)localObject));
      return false;
    }
    ForwardStatisticsReporter.a("KEY_STAGE_1_SAVE_IMAGE", 0L, (HashMap)localObject, false);
    return aU();
  }
  
  private boolean aU()
  {
    int k = ForwardUtils.a(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag")));
    if (k == 1)
    {
      e("shareToQQ");
      return true;
    }
    long l = ForwardUtils.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
    if (l <= 0L)
    {
      QLog.d("StructMsg", 1, new Object[] { "gotoShareMsg appid = ", Long.valueOf(l) });
      return false;
    }
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    int i = 148;
    try
    {
      int j = Integer.valueOf(str1).intValue();
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label123:
      Bundle localBundle;
      String str2;
      Intent localIntent;
      String str3;
      boolean bool;
      break label123;
    }
    QLog.d("QQShare", 1, "NumberFormatException req_type = 1");
    str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    a(l, str1, i);
    localBundle = new Bundle();
    str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_to_qq_ark_info"));
    localIntent = a(str2, localBundle, l);
    if (localIntent == null)
    {
      QLog.d("JumpAction", 1, "gotoShareMsg: intent is null");
      return true;
    }
    str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    if (("news".equals(str3)) || ("audio".equals(str3)))
    {
      a(localBundle, this.jdField_a_of_type_JavaUtilHashMap, i, k);
      localBundle.putLong("req_share_id", l);
      localBundle.putString("open_id", str1);
      localBundle.putString("shareArkInfo", str2);
      bool = OpenSdkD55Processor.a();
      localBundle.putBoolean("enable_d55", bool);
      if (bool) {
        ((ForwardSdkStatusManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.SDK_SHARE)).a().a(str1, l, this.jdField_e_of_type_JavaLangString);
      }
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isSharingMiniProgram(this.jdField_a_of_type_JavaUtilHashMap))
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).forwardShareWithTryCatch(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, localBundle, localIntent);
        return true;
      }
      localIntent.putExtras(localBundle);
      com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.jdField_a_of_type_Boolean = true;
      ForwardBaseOption.a(this.jdField_a_of_type_AndroidContentContext, localIntent);
    }
    return true;
  }
  
  private boolean aV()
  {
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    Object localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("fopen_id"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("friend_label"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("add_msg"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
    try
    {
      l = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id")).longValue();
    }
    catch (Exception localException)
    {
      long l;
      label130:
      StringBuilder localStringBuilder;
      break label130;
    }
    l = 0L;
    if (l <= 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("gotoMakeFriend appid = ");
        ((StringBuilder)localObject1).append(l);
        QLog.d("JumpAction", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).setsOpenId((String)localObject2);
    if ("true".equals(localObject3))
    {
      localObject2 = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
      localObject3 = (Activity)this.jdField_a_of_type_AndroidContentContext;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l);
      localObject1 = ((IAddFriendApi)localObject2).startAddFriend((Context)localObject3, 3, (String)localObject1, localStringBuilder.toString(), 3090, 0, str1, str2, null, "", str3);
    }
    else
    {
      localObject2 = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
      localObject3 = (Activity)this.jdField_a_of_type_AndroidContentContext;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l);
      localObject1 = ((IAddFriendApi)localObject2).startAddFriend((Context)localObject3, 3, (String)localObject1, localStringBuilder.toString(), 3016, 0, str1, str2, null, "", str3);
    }
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1);
    return true;
  }
  
  private boolean aW()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)))
    {
      Object localObject = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("page_id");
      if (str2 != null)
      {
        QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
        localUserInfo.qzone_uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localUserInfo.nickname = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
        String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
        SessionInfo localSessionInfo = ((BaseActivity)localObject).getChatFragment().a().a();
        if ((localSessionInfo != null) && (!TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString))) {
          ((ITroopPhotoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_PHOTO_HANDLER)).a(localSessionInfo.jdField_a_of_type_JavaLangString, true);
        }
        if (str2.equalsIgnoreCase("11"))
        {
          QZoneHelper.forwardToQunAlbumDetail((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, str1, "mqqChat.QzoneCard", -1);
        }
        else if (str2.equalsIgnoreCase("12"))
        {
          localObject = ((BaseActivity)localObject).getChatFragment().a().b();
          str2 = e(str1);
          if (TextUtils.isEmpty(str2)) {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, "缺少相册id", 1).a();
          } else {
            QZoneHelper.forwardToTroopAlbumViewPhoto((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, (String)localObject, str2, str1, "mqqChat.QzoneCard", -1);
          }
        }
      }
    }
    return false;
  }
  
  private boolean aX()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.common.activities.QzoneDialogActivity");
    localIntent.addFlags(805306368);
    QZoneHelper.launchQZone((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localIntent, -1);
    return true;
  }
  
  private boolean aY()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (!QzoneAuthorizeConfig.getInstance().hasSchemeRight(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("JumpAction", 1, "has no right to handle this schema");
        return false;
      }
      Intent localIntent2 = null;
      Object localObject;
      Intent localIntent1;
      if (this.jdField_a_of_type_JavaLangString.startsWith("mqqzone"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mqzone");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString.substring(7));
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        String str = (String)URLUtil.a(this.jdField_a_of_type_JavaLangString).get("schema");
        localObject = localIntent2;
        if (!TextUtils.isEmpty(str)) {
          try
          {
            localObject = new String(Base64.decode(str, 0), "utf-8");
          }
          catch (Exception localException)
          {
            QLog.e("JumpAction", 1, localException, new Object[0]);
            localIntent1 = localIntent2;
          }
        }
      }
      if (!TextUtils.isEmpty(localIntent1))
      {
        localIntent2 = new Intent();
        localIntent2.putExtra("cmd", "Schema");
        localIntent2.putExtra("schema", localIntent1);
        if (d(localIntent1))
        {
          ((IWSManager)QRoute.api(IWSManager.class)).enterTrendsTabWs(this.jdField_a_of_type_AndroidContentContext, "from_trends_tab", this.jdField_d_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, localIntent2);
          return true;
        }
        QZoneHelper.forwardToQzoneTransluentActivity((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.getInstance(), localIntent2);
        return true;
      }
      QLog.e("JumpAction", 1, "gotoQzoneHandleSchema,schema=null");
      return true;
    }
    return false;
  }
  
  private boolean aZ()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return false;
    }
    return ((IQzoneMsgApi)QRoute.api(IQzoneMsgApi.class)).openContentBox(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private boolean aa()
  {
    return true;
  }
  
  private boolean ab()
  {
    return true;
  }
  
  private boolean ac()
  {
    Object localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
    String str = ((Intent)localObject).getStringExtra("uin");
    Intent localIntent;
    long l2;
    if (Utils.b(str))
    {
      localIntent = new Intent();
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", ((Intent)localObject).getIntExtra("uintype", -1));
      l2 = 0L;
      l1 = l2;
    }
    try
    {
      if (TextUtils.isEmpty(b("msg_uniseq"))) {
        break label150;
      }
      l1 = Long.valueOf(b("msg_uniseq")).longValue();
    }
    catch (Exception localException)
    {
      label104:
      int i;
      break label104;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("NumberFormatException uniseq:");
    ((StringBuilder)localObject).append(b("msg_uniseq"));
    QLog.i("JumpAction", 1, ((StringBuilder)localObject).toString());
    long l1 = l2;
    label150:
    str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(str, "chatimg", l1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gotoSetAvator path:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("msg uniseq:");
      ((StringBuilder)localObject).append(l1);
      QLog.d("JumpAction", 2, ((StringBuilder)localObject).toString());
    }
    i = Math.min(482, ProfileCardUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext));
    localIntent.putExtra("Business_Origin", 100);
    localIntent.putExtra("open_chatfragment", true);
    localIntent.putExtra("open_chat_from_avator", true);
    PhotoUtils.startPhotoEdit(localIntent, (Activity)this.jdField_a_of_type_AndroidContentContext, SplashActivity.class.getName(), i, i, 1080, 1080, str, FaceUtil.a());
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800723E", "0X800723E", 0, 0, "", "", "", "");
    return true;
  }
  
  private boolean ad()
  {
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("set_uri_list"));
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    ArrayList localArrayList = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getParcelableArrayListExtra("android.intent.extra.STREAM");
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/base/activity/FavEmosmManageActivity");
    localActivityURIRequest.setFlags(335544320);
    localActivityURIRequest.extra().putBoolean("key_from_sdk_set_emotion", true);
    localActivityURIRequest.extra().putParcelableArrayList("key_from_sdk_set_emotion_uri", localArrayList);
    localActivityURIRequest.extra().putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(str1)) {
      localActivityURIRequest.extra().putString("key_from_sdk_set_emotion_appname", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      localActivityURIRequest.extra().putString("key_from_sdk_set_emotion_share_id", str2);
    }
    if (!TextUtils.isEmpty(str3)) {
      localActivityURIRequest.extra().putString("key_from_sdk_set_emotion_open_id", str3);
    }
    if (!TextUtils.isEmpty(str4)) {
      localActivityURIRequest.extra().putString("key_from_sdk_set_emotion_uri_list", str4);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localActivityURIRequest.extra().putString("sdk_version", (String)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gotoSDKSetEmotion:sdk appName=");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" shareId=");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(", openId =");
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append(", setPathList =");
      ((StringBuilder)localObject).append(str4);
      QLog.d("JumpAction", 2, ((StringBuilder)localObject).toString());
    }
    QRoute.startUri(localActivityURIRequest);
    return true;
  }
  
  private boolean ae()
  {
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("set_uri"));
    QLog.d("JumpAction", 1, new Object[] { "-->gotoSDKSetAvator setUri=", str1 });
    if (!TextUtils.isEmpty(str1)) {
      return a(new JumpActionLegacy.7(this), str1, "set_uri", "set_path");
    }
    str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("set_path"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("key_request_code", 0);
    AllInOne localAllInOne = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_from_sdk_set_avatar", true);
    localBundle.putString("key_from_sdk_set_avatar_path", str4);
    localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(str1)) {
      localBundle.putString("key_from_sdk_set_avatar_appname", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      localBundle.putString("key_from_sdk_set_avatar_share_id", str2);
    }
    if (!TextUtils.isEmpty(str3)) {
      localBundle.putString("key_from_sdk_set_avatar_open_id", str3);
    }
    if (!TextUtils.isEmpty(str5)) {
      localBundle.putString("sdk_version", str5);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoSDKSetAvator:sdk appName=");
      localStringBuilder.append(str1);
      localStringBuilder.append(" shareId=");
      localStringBuilder.append(str2);
      localStringBuilder.append(", openId =");
      localStringBuilder.append(str3);
      localStringBuilder.append(", setPath =");
      localStringBuilder.append(str4);
      localStringBuilder.append(", sdkVersion =");
      localStringBuilder.append(str5);
      QLog.d("JumpAction", 2, localStringBuilder.toString());
    }
    ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, localAllInOne, localBundle);
    return true;
  }
  
  private boolean af()
  {
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_uri"));
    QLog.d("JumpAction", 1, new Object[] { "-->gotoSDKSetDynamicAvatar videoUri=", str1 });
    if (!TextUtils.isEmpty(str1)) {
      return a(new JumpActionLegacy.8(this), str1, "video_uri", "video_path");
    }
    str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_path"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, new Object[] { "[gotoSDKSetDynamicAvatar] appName=", str1 });
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DF9", "0X8009DF9", 0, 0, str2, "", "", "");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SelectCoverActivity.class);
    localIntent.putExtra("param_source", 3);
    localIntent.putExtra("param_from_newer_guide", false);
    localIntent.putExtra("key_video_file_path", str4);
    localIntent.putExtra("pkg_name", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("app_name", str1);
    localIntent.putExtra("share_id", str2);
    localIntent.putExtra("open_id", str3);
    localIntent.putExtra("sdk_version", str5);
    localIntent.addFlags(335544320);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean ag()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, RecommendFriendActivity.class);
    localIntent.putExtra("EntranceId", 7);
    localIntent.putExtra("from_babyq", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007243", "0X8007243", 0, 0, "", "", "", "");
    return true;
  }
  
  private boolean ah()
  {
    Intent localIntent = new Intent();
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, SearchMightKnowFragment.class);
    return true;
  }
  
  private boolean ai()
  {
    Intent localIntent = new Intent();
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
    int i;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (a((String)localObject))) {
      i = Integer.valueOf((String)localObject).intValue();
    } else {
      i = 0;
    }
    localIntent.putExtra("jumpFromType", i);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gotoShowNewFriends ");
      ((StringBuilder)localObject).append(i);
      QLog.i("JumpAction", 2, ((StringBuilder)localObject).toString());
    }
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).startActivity(this.jdField_a_of_type_AndroidContentContext, localIntent, 9);
    return true;
  }
  
  private boolean aj()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
    int i;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (a((String)localObject))) {
      i = Integer.valueOf((String)localObject).intValue();
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gotoShowContactsTab ");
      ((StringBuilder)localObject).append(i);
      QLog.i("JumpAction", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    ((Intent)localObject).setFlags(67108864);
    ((Intent)localObject).putExtra("jumpFromType", i);
    ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.c);
    ((Intent)localObject).putExtra("fragment_id", 1);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean ak()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ContactBindedActivity.class);
    localIntent.putExtra("from_babyq", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean al()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof QBaseActivity)) {
      return false;
    }
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    } else {
      str = "";
    }
    if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      m();
      return false;
    }
    n();
    return false;
  }
  
  private boolean am()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("leftBackText", HardCodeUtil.a(2131705986));
    ((Bundle)localObject).putBoolean("isBack2Root", true);
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.putExtras((Bundle)localObject);
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("txt");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      localIntent.putExtra("JumpAction.Text", c((String)localObject));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean an()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof QBaseActivity)) {
      return false;
    }
    ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).launchQWalletAct((QBaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false);
    return true;
  }
  
  private boolean ao()
  {
    try
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
      int i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
      if (str == null) {
        return false;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      localIntent.setFlags(335544320);
      localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      localIntent.putExtra("openid", str);
      localIntent.putExtra("appid", i);
      localIntent.putExtra("source", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label109:
      break label109;
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "Receive error appid number format");
    }
    return false;
  }
  
  private boolean ap()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app_type");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_id");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_id");
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_path"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_type"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A519", "0X800A519", 0, 0, "", "", str2, str1);
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A51B", "0X800A51B", 0, 0, "", "", str2, str1);
      QLog.e("JumpAction", 1, "connectMiniApp fail: packageName is empty");
      return true;
    }
    if ("mini_program_or_game".equals(localObject1))
    {
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131699408, 1).a();
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).addFlags(268435456);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return true;
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JumpActionLegacy.13(this), 20000L);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JumpActionLegacy.14(this), 500L);
    }
    for (;;)
    {
      try
      {
        this.jdField_i_of_type_Boolean = true;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label535;
        }
        bool = true;
        ForwardStatisticsReporter.a("KEY_STAGE_2_CONNECT_MINI_D55");
        MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
        if (localObject3 != null) {
          break label540;
        }
        localObject1 = "";
        long l1 = Long.valueOf(str1).longValue();
        long l2 = Long.valueOf(str2).longValue();
        int i = Integer.valueOf(str6).intValue();
        str6 = this.jdField_e_of_type_JavaLangString;
        try
        {
          localMessageHandler.a(bool, (String)localObject1, true, l1, l2, 1, i, str6, false, 0L, new JumpActionLegacy.15(this, str2, str1, str3, str4, (String)localObject3, str5));
          return false;
        }
        catch (Exception localException1) {}
        if (!this.jdField_i_of_type_Boolean) {
          break label490;
        }
      }
      catch (Exception localException2) {}
      this.jdField_i_of_type_Boolean = false;
      a();
      label490:
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("checkAppSignAndOpenidDiff exception: ");
      ((StringBuilder)localObject3).append(localException2.getMessage());
      QLog.e("JumpAction", 1, ((StringBuilder)localObject3).toString());
      return true;
      return true;
      label535:
      boolean bool = false;
      continue;
      label540:
      Object localObject2 = localObject3;
    }
  }
  
  private boolean aq()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    Object localObject5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
    String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    String str8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id"));
    String str10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_pkg_name"));
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("reply_content");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("reply_time");
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, String.format("gotoChat [uin,type,replyContent,replyTime]=[%s,%s,%s,%s]", new Object[] { str2, str7, str4, str5 }));
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("panel");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");
    if ((str3 != null) && (QLog.isDevelopLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str3);
      ((StringBuilder)localObject1).append("");
      QLog.d("JumpAction", 4, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject4 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    int i;
    if ("c2c".equals(str7))
    {
      if ((str2 != null) && (str2.length() >= 5))
      {
        if (((FriendsManager)localObject2).b(str2))
        {
          localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
          if ("chat".equals(localObject3))
          {
            localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
            ((Intent)localObject2).putExtra("uin", str2);
            ((Intent)localObject2).putExtra("uintype", 0);
            if (localObject1 != null) {
              ((Intent)localObject2).putExtra("uinname", (String)localObject1);
            }
            if (!TextUtils.isEmpty(str4))
            {
              ((Intent)localObject2).putExtra("key_aio_reply_content", str4);
              ((Intent)localObject2).putExtra("key_aio_reply_time", str5);
            }
            ((Intent)localObject2).addFlags(67108864);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007191", "0X8007191", 0, 0, "", "", "", "");
            return true;
          }
          i = 0;
        }
        else
        {
          return false;
        }
      }
      else {
        return false;
      }
    }
    else
    {
      if (!"discuss".equals(str7)) {
        break label617;
      }
      if ((str2 == null) || (str2.length() < 6)) {
        break label615;
      }
      i = 3000;
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("discuss_info");
    }
    for (;;)
    {
      localObject3 = null;
      localObject2 = null;
      break label2133;
      label615:
      return false;
      label617:
      if ("group".equals(str7))
      {
        if ((str2 != null) && (str2.length() >= 6))
        {
          localObject1 = ((TroopManager)localObject1).b(str2);
          if (localObject1 != null)
          {
            localObject1 = ((TroopInfo)localObject1).getTroopDisplayName();
            i = 1;
          }
          else
          {
            return false;
          }
        }
        else
        {
          return false;
        }
      }
      else if ("robot".equals(str7))
      {
        if ((str2 != null) && (!"".equals(str2)))
        {
          localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
          i = 1001;
        }
        else
        {
          return false;
        }
      }
      else
      {
        if (!"wpa".equals(str7)) {
          break label812;
        }
        if ((str2 == null) || (str2.length() < 5) || (str2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          break;
        }
        if (((FriendsManager)localObject2).b(str2))
        {
          localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
          i = 0;
        }
        else
        {
          localObject1 = null;
          i = 1005;
        }
        g(str2);
      }
    }
    return false;
    label812:
    if ("crm".equals(str7))
    {
      boolean bool2 = au();
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = ar();
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = as();
      }
      bool1 = bool2;
      if (!bool2) {
        bool1 = at();
      }
      return bool1;
    }
    if ((!"lbs".equals(str7)) && (!"date".equals(str7)))
    {
      if ("public_account".equals(str7))
      {
        if ((str2 != null) && (str2.length() >= 6))
        {
          localObject1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", str2, "0X800589E", "0X800589E", 0, 0, str2, "", "", "", false);
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
          ((Intent)localObject2).putExtra("uin", str2);
          ((Intent)localObject2).putExtra("uintype", 1008);
          if (localObject1 != null) {
            ((Intent)localObject2).putExtra("uinname", (String)localObject1);
          }
          if (("2747277822".equals(str2)) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()))
          {
            ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).startQQGamePubAccount(this.jdField_a_of_type_AndroidContentContext, 4);
          }
          else
          {
            if (!((IMiniAppService)QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(str2)) {
              break label1124;
            }
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniGamePublicAccount(this.jdField_a_of_type_AndroidContentContext);
          }
          for (;;)
          {
            return true;
            label1124:
            if ("3046055438".equals(str2))
            {
              ((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).jump(this.jdField_a_of_type_AndroidContentContext);
            }
            else if (NowQQLiveConstant.jdField_a_of_type_JavaLangString.equals(str2))
            {
              if (!NowQQLiveHelper.a(this.jdField_a_of_type_AndroidContentContext, str2, 3)) {
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
              }
            }
            else
            {
              if ((!AppConstants.QQ_VIP_UIN.equals(str2)) || (!QQVipHelper.b(this.jdField_a_of_type_AndroidContentContext))) {
                break;
              }
              QQVipHelper.b(this.jdField_a_of_type_AndroidContentContext);
            }
          }
          if ((((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(str2)) && (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivity(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
          {
            QLog.i("JumpAction", 1, "gotoChat startNewWeatherWebPageActivity");
            return true;
          }
          if (((IQQComicConfigApi)QRoute.api(IQQComicConfigApi.class)).launchIfMatched(str2, this.jdField_a_of_type_AndroidContentContext, 1005, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            return true;
          }
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
          return true;
        }
        return false;
      }
      if ("qd_account".equals(str7))
      {
        if ((str2 != null) && (str2.length() >= 6))
        {
          localObject1 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
          ((Intent)localObject1).putExtra("uin", str2);
          ((Intent)localObject1).putExtra("uintype", 1008);
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("key");
          localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("kfuin");
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assign_type");
          localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assign_key");
          str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("ext");
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rkey");
          if (QLog.isColorLevel())
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("QD_ACCOUNT_TYPE ");
            ((StringBuilder)localObject5).append((String)localObject3);
            ((StringBuilder)localObject5).append(" ");
            ((StringBuilder)localObject5).append(str1);
            ((StringBuilder)localObject5).append(" ");
            ((StringBuilder)localObject5).append((String)localObject4);
            ((StringBuilder)localObject5).append(" ");
            ((StringBuilder)localObject5).append(str2);
            ((StringBuilder)localObject5).append(" ");
            ((StringBuilder)localObject5).append(str3);
            QLog.d("JumpAction", 2, ((StringBuilder)localObject5).toString());
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
          {
            ((Intent)localObject1).putExtra("qd_wpa_key", (String)localObject2);
            ((Intent)localObject1).putExtra("qd_kfuin", (String)localObject3);
            if (!TextUtils.isEmpty(str1)) {
              ((Intent)localObject1).putExtra("assign_type", str1);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              ((Intent)localObject1).putExtra("assign_key", (String)localObject4);
            }
            if (!TextUtils.isEmpty(str2)) {
              ((Intent)localObject1).putExtra("assign_ext", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
              ((Intent)localObject1).putExtra("rkey", str3);
            }
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
            return true;
          }
          return false;
        }
        return false;
      }
      if ((!"thirdparty2c".equals(str7)) && (!"audio_chat".equals(str7)) && (!"video_chat".equals(str7))) {
        return false;
      }
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131699403, 1).a();
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).addFlags(268435456);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return true;
      }
      if (!TextUtils.isEmpty(str8))
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JumpActionLegacy.16(this), 20000L);
      }
    }
    for (;;)
    {
      try
      {
        if ("thirdparty2c".equals(str7))
        {
          i = 18;
        }
        else
        {
          if ("audio_chat".equals(str7)) {
            break label2633;
          }
          if (!"video_chat".equals(str7)) {
            break label2639;
          }
          break label2633;
        }
        ForwardStatisticsReporter.a("KEY_STAGE_2_GO_TO_CHAT_D55");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(true, str8, false, 0L, Long.valueOf(str9).longValue(), 1, i, str10, false, 0L, new JumpActionLegacy.17(this, str8, str9, str7));
        return false;
      }
      catch (Exception localException)
      {
        label2133:
        return true;
      }
      return true;
      if ((str2 != null) && (str2.length() >= 5) && (!str2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        if (((FriendsManager)localObject2).b(str2))
        {
          localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
          localObject2 = null;
          i = 0;
        }
        else if ("lbs".equals(str7))
        {
          localObject1 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
          localObject2 = "rich_accost_sig";
          i = 1001;
        }
        else
        {
          localObject1 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
          localObject2 = "rich_date_sig";
          i = 1010;
        }
        localObject3 = localObject4;
        if (localObject2 != null)
        {
          localObject3 = localObject4;
          if (str6 != null) {
            localObject3 = HexUtil.hexStr2Bytes(str6);
          }
        }
        localObject4 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject4;
        localObject4 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
        ((Intent)localObject4).putExtra("uin", str2);
        ((Intent)localObject4).putExtra("uintype", i);
        if (localObject1 != null) {
          ((Intent)localObject4).putExtra("uinname", (String)localObject1);
        }
        if (localObject5 != null) {
          ((Intent)localObject4).putExtra("input_text", (String)localObject5);
        }
        if (!TextUtils.isEmpty(str4))
        {
          ((Intent)localObject4).putExtra("key_aio_reply_content", str4);
          ((Intent)localObject4).putExtra("key_aio_reply_time", str5);
        }
        if ((localObject2 != null) && (localObject2.length > 0)) {
          ((Intent)localObject4).putExtra((String)localObject3, (byte[])localObject2);
        }
        if ((str3 != null) && (!"".equals(str3))) {
          if ((str2 != null) && (!"".equals(str2)))
          {
            localObject1 = this;
            localObject2 = (String)((JumpActionLegacy)localObject1).jdField_a_of_type_JavaUtilHashMap.get("callback_type");
            localObject3 = c((String)((JumpActionLegacy)localObject1).jdField_a_of_type_JavaUtilHashMap.get("thirdAppDisplayName"));
            localObject5 = (String)((JumpActionLegacy)localObject1).jdField_a_of_type_JavaUtilHashMap.get("appid");
            if ((localObject2 != null) && (!"".equals(localObject2))) {
              ((Intent)localObject4).putExtra("callback_type", (String)localObject2);
            }
            if ((localObject3 != null) && (!"".equals(localObject3))) {
              ((Intent)localObject4).putExtra("thirdAppDisplayName", (String)localObject3);
            }
            if ((localObject5 != null) && (!"".equals(localObject5))) {
              ((Intent)localObject4).putExtra("appid", (String)localObject5);
            }
            ((JumpActionLegacy)localObject1).a((Intent)localObject4, str3);
            ReportController.b(((JumpActionLegacy)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B4B", "0X8004B4B", 0, 0, "", "", "", "");
            if ("webview".equals(((JumpActionLegacy)localObject1).jdField_d_of_type_JavaLangString))
            {
              ((Intent)localObject4).putExtra("from", ((JumpActionLegacy)localObject1).jdField_d_of_type_JavaLangString);
              if (jdField_a_of_type_Int > 3)
              {
                QQToast.a(((JumpActionLegacy)localObject1).jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131705969), 1).a();
                return true;
              }
              jdField_a_of_type_Int += 1;
              ReportController.b(((JumpActionLegacy)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B5A", "0X8004B5A", 0, 0, "", "", "", "");
            }
            else
            {
              ReportController.b(((JumpActionLegacy)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B58", "0X8004B58", 0, 0, "", "", "", "");
            }
          }
          else
          {
            return false;
          }
        }
        if (str1 != null) {
          ((Intent)localObject4).putExtra("panel", str1);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
        return true;
      }
      return false;
      label2633:
      i = 19;
      continue;
      label2639:
      i = 10000;
    }
  }
  
  /* Error */
  private boolean ar()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 3858
    //   7: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 18	java/lang/String
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   18: ldc_w 3860
    //   21: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 18	java/lang/String
    //   27: astore 4
    //   29: aload_0
    //   30: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   33: ldc_w 3862
    //   36: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 18	java/lang/String
    //   42: astore 5
    //   44: aload_0
    //   45: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   48: ldc_w 3864
    //   51: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast 18	java/lang/String
    //   57: astore 6
    //   59: aload_0
    //   60: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   63: ldc_w 3811
    //   66: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast 18	java/lang/String
    //   72: astore 7
    //   74: aload_0
    //   75: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   78: ldc_w 3866
    //   81: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: checkcast 18	java/lang/String
    //   87: astore 8
    //   89: aload_3
    //   90: ifnull +530 -> 620
    //   93: aload 4
    //   95: ifnull +525 -> 620
    //   98: aload 5
    //   100: ifnull +520 -> 620
    //   103: aload 6
    //   105: ifnull +515 -> 620
    //   108: aload_3
    //   109: ldc 151
    //   111: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: istore_2
    //   115: iload_2
    //   116: ifeq +300 -> 416
    //   119: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +13 -> 135
    //   125: ldc_w 428
    //   128: iconst_2
    //   129: ldc_w 3868
    //   132: invokestatic 1310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: new 372	android/content/Intent
    //   138: dup
    //   139: invokespecial 373	android/content/Intent:<init>	()V
    //   142: astore 9
    //   144: aload 8
    //   146: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +50 -> 199
    //   152: aload 8
    //   154: ldc_w 3870
    //   157: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +6 -> 166
    //   163: goto +36 -> 199
    //   166: aload 9
    //   168: new 3872	android/content/ComponentName
    //   171: dup
    //   172: aload_0
    //   173: getfield 67	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   176: ldc_w 1099
    //   179: invokespecial 3873	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   182: invokevirtual 3877	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   185: pop
    //   186: aload 9
    //   188: ldc_w 3413
    //   191: iconst_1
    //   192: invokevirtual 1191	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   195: pop
    //   196: goto +23 -> 219
    //   199: aload 9
    //   201: new 3872	android/content/ComponentName
    //   204: dup
    //   205: aload_0
    //   206: getfield 67	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   209: ldc_w 3246
    //   212: invokespecial 3873	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   215: invokevirtual 3877	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   218: pop
    //   219: aload 9
    //   221: ldc_w 1104
    //   224: invokevirtual 1179	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   227: pop
    //   228: aload_0
    //   229: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   232: ldc_w 3659
    //   235: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   238: checkcast 18	java/lang/String
    //   241: astore 10
    //   243: aload_0
    //   244: getfield 54	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   247: ldc_w 693
    //   250: invokevirtual 91	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   253: checkcast 18	java/lang/String
    //   256: astore 11
    //   258: aload 11
    //   260: ifnull +149 -> 409
    //   263: aload 11
    //   265: invokevirtual 750	java/lang/String:length	()I
    //   268: iconst_5
    //   269: if_icmplt +138 -> 407
    //   272: aload 11
    //   274: aload_0
    //   275: getfield 49	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   278: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   281: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   284: ifeq +5 -> 289
    //   287: iconst_0
    //   288: ireturn
    //   289: aload 10
    //   291: ifnull +17 -> 308
    //   294: aload 9
    //   296: ldc_w 3659
    //   299: aload 10
    //   301: invokestatic 1660	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   304: invokevirtual 1697	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   307: pop
    //   308: aload_0
    //   309: getfield 49	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   312: getstatic 2599	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   315: invokevirtual 111	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   318: checkcast 2601	com/tencent/mobileqq/app/FriendsManager
    //   321: aload 11
    //   323: invokevirtual 2639	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   326: istore_2
    //   327: iload_2
    //   328: ifeq +34 -> 362
    //   331: aload 9
    //   333: ldc_w 3376
    //   336: iconst_0
    //   337: invokevirtual 974	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   340: pop
    //   341: aload 9
    //   343: ldc_w 3682
    //   346: aload_0
    //   347: getfield 49	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   350: aload 11
    //   352: invokestatic 3700	com/tencent/mobileqq/utils/ContactUtils:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   355: invokevirtual 387	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   358: pop
    //   359: goto +25 -> 384
    //   362: aload 9
    //   364: ldc_w 3376
    //   367: sipush 1025
    //   370: invokevirtual 974	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   373: pop
    //   374: aload 9
    //   376: ldc_w 3879
    //   379: iconst_1
    //   380: invokevirtual 1191	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   383: pop
    //   384: aload 9
    //   386: ldc_w 693
    //   389: aload 11
    //   391: invokevirtual 387	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   394: pop
    //   395: aload_0
    //   396: getfield 67	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   399: aload 9
    //   401: invokevirtual 684	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   404: goto +5 -> 409
    //   407: iconst_0
    //   408: ireturn
    //   409: goto +43 -> 452
    //   412: astore_3
    //   413: goto +186 -> 599
    //   416: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: istore_2
    //   420: iload_2
    //   421: ifeq +20 -> 441
    //   424: ldc_w 428
    //   427: iconst_2
    //   428: ldc_w 3881
    //   431: invokestatic 1310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: goto +7 -> 441
    //   437: astore_3
    //   438: goto +161 -> 599
    //   441: aload_0
    //   442: getfield 49	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   445: aload_0
    //   446: getfield 42	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver	Lcom/tencent/qidian/controller/QidianBusinessObserver;
    //   449: invokevirtual 2730	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   452: aload_0
    //   453: getfield 49	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   456: getstatic 1614	com/tencent/mobileqq/app/BusinessHandlerFactory:QIDIAN_HANDLER	Ljava/lang/String;
    //   459: invokevirtual 1618	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   462: checkcast 1620	com/tencent/qidian/controller/QidianHandler
    //   465: astore 9
    //   467: aload_0
    //   468: getfield 42	com/tencent/mobileqq/utils/JumpActionLegacy:jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver	Lcom/tencent/qidian/controller/QidianBusinessObserver;
    //   471: getfield 3884	com/tencent/qidian/controller/QidianBusinessObserver:jdField_a_of_type_Int	I
    //   474: istore_1
    //   475: aload 9
    //   477: aload 6
    //   479: aload_3
    //   480: aload 5
    //   482: aload 4
    //   484: aload 7
    //   486: aload 8
    //   488: iload_1
    //   489: invokevirtual 3887	com/tencent/qidian/controller/QidianHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   492: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   495: ifeq +91 -> 586
    //   498: new 556	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   505: astore 7
    //   507: aload 7
    //   509: ldc_w 3889
    //   512: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 7
    //   518: aload_3
    //   519: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload 7
    //   525: ldc_w 3891
    //   528: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 7
    //   534: aload 4
    //   536: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload 7
    //   542: ldc_w 3893
    //   545: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 7
    //   551: aload 5
    //   553: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload 7
    //   559: ldc_w 3895
    //   562: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 7
    //   568: aload 6
    //   570: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: ldc_w 428
    //   577: iconst_2
    //   578: aload 7
    //   580: invokevirtual 564	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 1310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: iconst_1
    //   587: ireturn
    //   588: astore_3
    //   589: iconst_1
    //   590: istore_2
    //   591: goto +10 -> 601
    //   594: astore_3
    //   595: goto +4 -> 599
    //   598: astore_3
    //   599: iconst_0
    //   600: istore_2
    //   601: invokestatic 426	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   604: ifeq +14 -> 618
    //   607: ldc_w 428
    //   610: iconst_2
    //   611: aload_3
    //   612: invokevirtual 867	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   615: invokestatic 1310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: iload_2
    //   619: ireturn
    //   620: iconst_0
    //   621: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	this	JumpActionLegacy
    //   474	15	1	i	int
    //   114	505	2	bool	boolean
    //   13	96	3	str1	String
    //   412	1	3	localException1	Exception
    //   437	82	3	localException2	Exception
    //   588	1	3	localException3	Exception
    //   594	1	3	localException4	Exception
    //   598	14	3	localException5	Exception
    //   27	508	4	str2	String
    //   42	510	5	str3	String
    //   57	512	6	str4	String
    //   72	507	7	localObject1	Object
    //   87	400	8	str5	String
    //   142	334	9	localObject2	Object
    //   241	59	10	str6	String
    //   256	134	11	str7	String
    // Exception table:
    //   from	to	target	type
    //   119	135	412	java/lang/Exception
    //   135	163	412	java/lang/Exception
    //   166	196	412	java/lang/Exception
    //   199	219	412	java/lang/Exception
    //   219	258	412	java/lang/Exception
    //   263	287	412	java/lang/Exception
    //   294	308	412	java/lang/Exception
    //   308	327	412	java/lang/Exception
    //   331	359	412	java/lang/Exception
    //   362	384	412	java/lang/Exception
    //   384	404	412	java/lang/Exception
    //   424	434	437	java/lang/Exception
    //   475	492	437	java/lang/Exception
    //   492	586	588	java/lang/Exception
    //   441	452	594	java/lang/Exception
    //   452	475	594	java/lang/Exception
    //   108	115	598	java/lang/Exception
    //   416	420	598	java/lang/Exception
  }
  
  private boolean as()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpaType");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assignId");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("QidianKfUin");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shouldReturnToRoot");
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    if (str1 != null)
    {
      bool2 = bool1;
      if (str2 != null)
      {
        bool2 = bool1;
        if (str3 != null)
        {
          bool2 = bool1;
          if (str4 != null)
          {
            bool2 = bool1;
            if (str5 != null)
            {
              bool1 = bool3;
              try
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
                bool1 = bool3;
                ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(str5, str2, str1, str3, str4, str6);
                bool2 = true;
                bool3 = true;
                bool1 = bool3;
                if (QLog.isColorLevel())
                {
                  bool1 = bool3;
                  QLog.d("JumpAction", 2, "handleQidianCorpWPA");
                  return true;
                }
              }
              catch (Exception localException)
              {
                bool2 = bool1;
                if (QLog.isColorLevel())
                {
                  QLog.d("JumpAction", 2, localException.getMessage());
                  bool2 = bool1;
                }
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private boolean at()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str1 != null) && (str1.length() >= 5) && (!str1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
      Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
      Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shouldReturnToRoot");
      Intent localIntent = new Intent();
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals("NO")))
      {
        localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class));
        localIntent.putExtra("open_chatfragment", true);
      }
      else
      {
        localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class));
      }
      localIntent.addFlags(67108864);
      int i = CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("handleLegacyCrmWPA ");
        ((StringBuilder)localObject3).append(i);
        QLog.d("JumpAction", 2, ((StringBuilder)localObject3).toString());
      }
      localIntent.putExtra("from_wpa_for_crm", true);
      localIntent.putExtra("uin", str1);
      localIntent.putExtra("uintype", i);
      if (i == 0)
      {
        localObject3 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
        if (localObject3 != null) {
          localIntent.putExtra("uinname", (String)localObject3);
        }
      }
      else if (i == 1024)
      {
        localIntent.putExtra("chat_subType", 1);
      }
      if (localObject2 != null) {
        localIntent.putExtra("input_text", (String)localObject2);
      }
      if ((str2 != null) && (str1 != null))
      {
        localObject2 = HexUtil.hexStr2Bytes(str2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(str1, (byte[])localObject2);
      }
      if (localObject1 != null) {
        localIntent.putExtra("sigt", HexUtil.hexStr2Bytes((String)localObject1));
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      ReportController.b((AppRuntime)localObject1, "P_CliOper", "Bqq_Crm", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, ((QQAppInterface)localObject1).getCurrentAccountUin(), str1, "", "");
      return true;
    }
    return false;
  }
  
  private boolean au()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request");
    if (str1 != null)
    {
      if (!str1.equals("videochat")) {
        return false;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
      String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname");
      String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str4)))
      {
        Intent localIntent = new Intent("com.tencent.mobileqq.qidian.openactionsheet");
        Bundle localBundle = new Bundle();
        localBundle.putString("request_type", str4);
        localBundle.putString("nickname", str3);
        localBundle.putString("uin", str1);
        localBundle.putString("sigt", str2);
        localIntent.putExtras(localBundle);
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
        return true;
      }
    }
    return false;
  }
  
  private boolean av()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (str != null)
    {
      if (str.length() < 6) {
        return false;
      }
      Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject == null) {
        return false;
      }
      localObject = ((TroopManager)localObject).b(str);
      if (localObject != null)
      {
        localObject = ((TroopInfo)localObject).getTroopDisplayName();
        Intent localIntent = new Intent();
        localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
        localIntent = AIOUtils.a(localIntent, new int[] { 2 });
        localIntent.putExtra("uin", str);
        localIntent.putExtra("uintype", 1);
        if (localObject != null) {
          localIntent.putExtra("uinname", (String)localObject);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return true;
      }
      return aK();
    }
    return false;
  }
  
  private boolean aw()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lon");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lat");
    if ((str != null) && (localObject != null)) {}
    try
    {
      int i = Integer.parseInt(str.trim());
      int j = Integer.parseInt(((String)localObject).trim());
      break label87;
      i = 0;
      j = 0;
      label87:
      str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      localObject = new Intent();
      ((Intent)localObject).putExtra("ENTER_TIME", System.currentTimeMillis());
      ((Intent)localObject).putExtra("lat", j);
      ((Intent)localObject).putExtra("lon", i);
      ((Intent)localObject).putExtra("filter", 0);
      if (str != null) {
        ((Intent)localObject).putExtra("title", str);
      }
      RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, "/nearby/activity");
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private boolean ax()
  {
    NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private boolean ay()
  {
    if ((String)this.jdField_a_of_type_JavaUtilHashMap.get("back_title") == null) {
      HardCodeUtil.a(2131705985);
    }
    ITroopCreateService localITroopCreateService = (ITroopCreateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopCreateService.class, "");
    if (localITroopCreateService != null) {
      localITroopCreateService.startCreateTroopSession((QBaseActivity)this.jdField_a_of_type_AndroidContentContext, 0);
    }
    return true;
  }
  
  private boolean az()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lon");
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lat");
    if ((localObject1 != null) && (localObject2 != null)) {}
    try
    {
      int i = Integer.parseInt(((String)localObject1).trim());
      double d1 = i;
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      i = Integer.parseInt(((String)localObject2).trim());
      double d2 = i;
      Double.isNaN(d2);
      d2 /= 1000000.0D;
      c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://maps.google.com/maps?q=");
      ((StringBuilder)localObject1).append(d2);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(d1);
      ((StringBuilder)localObject1).append("&hl=zh-CN");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1));
      ((Intent)localObject2).setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
    }
    catch (Exception localException)
    {
      label205:
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      break label205;
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1)));
    return true;
    return false;
  }
  
  private Intent b()
  {
    ((QQStoryActivityManager)SuperManager.a(18)).a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  private void b()
  {
    String str = b("payurl");
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = new String(Base64.decode(str, 0));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("JumpAction", 1, "payurl is call to launch");
        VasH5PayUtil.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("payurl cant not decode to base64 =");
      ((StringBuilder)localObject).append(str);
      QLog.e("JumpAction", 1, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.e("JumpAction", 1, "payurl is null");
  }
  
  private void b(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("midas://open_modify_status?status=");
    localStringBuilder.append(paramInt);
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    if (this.jdField_a_of_type_AndroidContentContext.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    ((QBaseActivity)this.jdField_a_of_type_AndroidContentContext).finish();
  }
  
  private void b(Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(this.h)))
    {
      paramIntent.putExtra("redTouch", this.h);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "wrapper Intent failed intent is null or redTouchInfo is Empty");
    }
  }
  
  public static void b(Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("key_launch_time");
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("call jumpToQZoneVideoLayer timedelay=");
      ((StringBuilder)localObject).append(l2 - l1);
      QLog.d("plugin_tag", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = QZoneHelper.getQzoneVerticalVideoDownloadActivityIntent(BaseApplicationImpl.getContext());
    ((Intent)localObject).putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).putExtras(paramBundle);
    BaseApplicationImpl.getContext().startActivity((Intent)localObject);
  }
  
  private void b(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = paramString1.split(";");
    paramString1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    if (paramString1 != null) {
      paramString1 = paramString1.split(";");
    } else {
      paramString1 = null;
    }
    int i = 0;
    while (i < arrayOfString.length)
    {
      String str = URLDecoder.decode(arrayOfString[i]);
      if (!TextUtils.isEmpty(str))
      {
        str = FileUtils.saveFileUriToFile(this.jdField_a_of_type_AndroidContentContext, str, "opensdk_tmp");
        if (!TextUtils.isEmpty(str))
        {
          localStringBuffer.append(URLEncoder.encode(str));
        }
        else
        {
          if ((paramString1 == null) || (i >= paramString1.length)) {
            break label151;
          }
          localStringBuffer.append(paramString1[i]);
        }
        if (i != arrayOfString.length - 1) {
          localStringBuffer.append(";");
        }
      }
      label151:
      i += 1;
    }
    try
    {
      paramString1 = new String(Base64Util.encode(localStringBuffer.toString().getBytes("UTF-8"), 0));
      this.jdField_a_of_type_JavaUtilHashMap.put("image_url", paramString1);
    }
    catch (UnsupportedEncodingException paramString1)
    {
      QLog.i("JumpAction", 1, "gotoShareMsgCheck put exception:", paramString1);
    }
    a(paramString2, false);
    if (((this.jdField_a_of_type_AndroidContentContext instanceof GesturePWDUnlockActivity)) && (this.jdField_g_of_type_Boolean)) {
      ((GesturePWDUnlockActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    String str = (String)paramHashMap.get("unionid");
    paramQQAppInterface = (String)paramHashMap.get("fromuid");
    int i;
    try
    {
      i = Integer.valueOf((String)paramHashMap.get("fromId")).intValue();
    }
    catch (NumberFormatException paramHashMap)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoStoryShareGroupCard from id is error:");
      localStringBuilder.append(paramHashMap);
      QLog.e("JumpAction", 2, localStringBuilder.toString());
      i = -1;
    }
    paramHashMap = QQStoryShareGroupProfileActivity.a(paramActivity, 2, str, null, i, 0);
    paramHashMap.putExtra("extra_share_from_user_uid", paramQQAppInterface);
    paramActivity.startActivity(paramHashMap);
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str5 = (String)paramHashMap.get("videoOwnerUin");
    String str6 = (String)paramHashMap.get("unionid");
    String str4 = (String)paramHashMap.get("fromId");
    String str1 = (String)paramHashMap.get("videoId");
    String str3 = (String)paramHashMap.get("type");
    paramQQAppInterface = (String)paramHashMap.get("videoList");
    int i = a(paramHashMap);
    String str2 = (String)paramHashMap.get("feedid");
    a(paramHashMap, "ptype", 0);
    paramQQAppInterface = str1;
    if (str1 == null) {
      paramQQAppInterface = (String)paramHashMap.get("videoid");
    }
    str1 = str4;
    if (str4 == null) {
      str1 = (String)paramHashMap.get("fromid");
    }
    int j;
    if ((str3 != null) && (str3.equals("mylist"))) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((str3 != null) && (str3.equals("myonedaylist"))) {
      k = 1;
    } else {
      k = 0;
    }
    int m = "0".equals(paramHashMap.get("identify")) ^ true;
    for (;;)
    {
      try
      {
        boolean bool = "17".equals(str1);
        if (bool) {
          if (j != 0) {
            StoryReportor.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          } else {
            StoryReportor.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
        }
        if (k != 0)
        {
          paramString = (String)paramHashMap.get("collection_id");
          if (TextUtils.isEmpty(paramString))
          {
            j = i;
            if (i == 0) {
              j = 30;
            }
            StoryPlayerLauncher.a(paramActivity, paramQQAppInterface, str2, j);
            break label733;
          }
          paramQQAppInterface = (String)paramHashMap.get("time_zone");
          j = -1;
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            j = Integer.valueOf(paramQQAppInterface).intValue();
          }
          if (!TextUtils.isEmpty(str6))
          {
            StoryPlayerLauncher.a(paramActivity, str6, VideoCollectionEntry.getCollectionKey(1, paramString, str6), j, i, str2, m, null);
            break label733;
          }
          if (TextUtils.isEmpty(str5)) {
            break label735;
          }
          StoryPlayerLauncher.a(paramActivity, str5, VideoCollectionEntry.getCollectionKey(1, paramString, str5), j, i, str2, m, null);
          break label733;
        }
        if ("17".equals(str1))
        {
          if (j != 0)
          {
            paramQQAppInterface = (String)paramHashMap.get("et");
            paramQQAppInterface = (String)paramHashMap.get("time_zone");
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              Integer.valueOf(paramQQAppInterface).intValue();
            }
            if (!TextUtils.isEmpty(str6))
            {
              StoryPlayerLauncher.a(paramActivity, str6, str2, m, i, 0, null);
              break label758;
            }
            if (TextUtils.isEmpty(str5)) {
              break label737;
            }
            StoryPlayerLauncher.a(paramActivity, str5, str2, m, i, 0, null);
            break label758;
          }
          if (TextUtils.isEmpty(str3)) {
            break label739;
          }
          if (str3.equals(String.valueOf(1)))
          {
            j = i;
            if (i == 0) {
              j = 57;
            }
            StoryPlayerLauncher.b(paramActivity, paramQQAppInterface, str2, j);
            break label758;
          }
          if (!"onedaylist".equals(str3)) {
            break label742;
          }
          StoryPlayerLauncher.a(paramActivity, str6, str2, m, i, 0, null);
          break label758;
          StoryPlayerLauncher.b(paramActivity, paramQQAppInterface, str2, j);
          break label758;
        }
        if (TextUtils.isEmpty(paramString)) {
          break label760;
        }
        j = i;
        if (i == 0) {
          j = 19;
        }
        StoryPlayerLauncher.b(paramActivity, paramQQAppInterface, str2, j);
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramActivity = new StringBuilder();
        paramActivity.append("gotoStoryPlayVideoPage, NumberFormatException, videoOwnerUin:");
        paramActivity.append(str5);
        paramActivity.append(",e:");
        paramActivity.append(QLog.getStackTraceString(paramQQAppInterface));
        QLog.d("JumpAction", 2, paramActivity.toString());
        return false;
      }
      StoryPlayerLauncher.b(paramActivity, paramQQAppInterface, paramHashMap, j);
      break label758;
      label733:
      return true;
      label735:
      return false;
      label737:
      return false;
      label739:
      continue;
      label742:
      j = i;
      if (i == 0)
      {
        j = 17;
        continue;
        label758:
        return true;
        label760:
        paramHashMap = str2;
        if (str2 == null) {
          paramHashMap = "JUMP_ACTION_EMPTY_FEED_ID";
        }
        j = i;
        if (i == 0) {
          j = 7;
        }
      }
    }
  }
  
  private boolean bA()
  {
    if ("open".equals(this.jdField_c_of_type_JavaLangString))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 8855);
      return true;
    }
    if ("openVideo".equalsIgnoreCase(this.jdField_c_of_type_JavaLangString))
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, null);
      }
      return false;
    }
    if ("opencontent".equals(this.jdField_c_of_type_JavaLangString)) {
      return a(this.jdField_a_of_type_JavaUtilHashMap, false);
    }
    if ("opendiscovery".equals(this.jdField_c_of_type_JavaLangString)) {
      return bC();
    }
    if ("opentopic".equals(this.jdField_c_of_type_JavaLangString)) {
      return bB();
    }
    if ("infoCard".equals(this.jdField_c_of_type_JavaLangString)) {
      return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    if ("sharegroupcard".equals(this.jdField_c_of_type_JavaLangString)) {
      return b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    Object localObject = new QQStoryHomeJumpHelper((Activity)this.jdField_a_of_type_AndroidContentContext, new JumpActionLegacy.29(this));
    Intent localIntent = e(new Intent());
    if (localIntent != null)
    {
      int i = localIntent.getIntExtra("action", 0);
      localIntent.putExtra("action", 0);
      return ((QQStoryHomeJumpHelper)localObject).a(i, localIntent);
    }
    return false;
  }
  
  private boolean bB()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname");
    a((String)this.jdField_a_of_type_JavaUtilHashMap.get("sharefromtype"));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
      return true;
    }
    return false;
  }
  
  private boolean bC()
  {
    if (!TextUtils.isEmpty(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api")))) {
      StoryReportor.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      "1".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"));
      return true;
    }
    return false;
  }
  
  private boolean bD()
  {
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Boolean)
    {
      SLog.b("JumpAction", "startStoryMainActivity, isNowTabShow==true");
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", FrameControllerUtil.f);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.setFlags(335544320);
      localIntent = e(localIntent);
      if ((localIntent != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return true;
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Error: context is not instanceof Activity, context is: ");
        localStringBuilder.append(String.valueOf(this.jdField_a_of_type_AndroidContentContext));
        SLog.e("JumpAction", localStringBuilder.toString());
      }
      if (localIntent == null) {
        SLog.e("JumpAction", "Error: jumpIntent is null");
      }
    }
    else
    {
      SLog.b("JumpAction", "startStoryMainActivity, isNowTabShow==false");
      if (((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity)) && (!BaseApplicationImpl.appMainActivityHasLanuch))
      {
        localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
        localIntent.putExtra("fragment_id", 1);
        localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
        localIntent.setFlags(335544320);
        localIntent.putExtra("jump_to_story", true);
      }
      else
      {
        localIntent = b();
      }
      localIntent = e(localIntent);
      if ((localIntent != null) && (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof BaseApplicationImpl))))
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return true;
      }
    }
    return false;
  }
  
  private boolean bE()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity;
    int i = 0;
    if ((bool) && ((((JumpActivity)this.jdField_a_of_type_AndroidContentContext).getIntent().getFlags() & 0x100000) != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, String.format("gotoRegisterByInvite bLaunchFromRecent=%b", new Object[] { Boolean.valueOf(bool) }));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("code")) {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("code");
    } else {
      localObject1 = "";
    }
    Object localObject2 = a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject2);
    if (a().getRegisterPhoneNumActivityClass() == localObject2)
    {
      localIntent.putExtra("key_report_extra_from", 5);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localIntent.putExtra("invite_code", (String)localObject2);
      i = 1;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject1 != null) && (((QQAppInterface)localObject1).isLogin()) && (i != 0) && (!bool))
    {
      localIntent.putExtra("action", 4097);
      PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, TranslucentTRansferFragment.class);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096FF", "0X80096FF", 0, 0, "", "", "", "");
      return true;
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096FE", "0X80096FE", 0, 0, "", "", "", "");
    return true;
  }
  
  private boolean bF()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80077DE", "0X80077DE", 0, 0, (String)localObject, "", "", "");
    localObject = a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
    if (a().getRegisterPhoneNumActivityClass() == localObject) {
      localIntent.putExtra("key_report_extra_from", 5);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean bG()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("troopUin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("evilUin");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("selfUin");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("scene");
    if (str4 != null) {}
    try
    {
      i = Integer.parseInt(str4);
    }
    catch (Exception localException)
    {
      int i;
      label72:
      break label72;
    }
    i = 20008;
    NewReportPlugin.a((QBaseActivity)this.jdField_a_of_type_AndroidContentContext, str2, str1, str3, i, null);
    return true;
  }
  
  private boolean bH()
  {
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    Object localObject1 = localObject2;
    if (StringUtil.a((String)localObject2)) {
      localObject1 = "0";
    }
    localObject2 = (INearbyFaceScoreManager)((QBaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime().getManager(QQManagerFactory.FACE_SCORE_MANAGER);
    long l = Long.parseLong((String)localObject1);
    ((INearbyFaceScoreManager)localObject2).a(l, new JumpActionLegacy.30(this, l));
    return true;
  }
  
  private boolean bI()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomcode");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isgroupcode");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("backtype");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extra");
    IGroupVideoManager localIGroupVideoManager = (IGroupVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
    try
    {
      i = Integer.parseInt(str3);
    }
    catch (Exception localException)
    {
      int i;
      label112:
      StringBuilder localStringBuilder;
      break label112;
    }
    i = 1;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[goToGroupVideoPlugin], roomId:");
    localStringBuilder.append(str1);
    localStringBuilder.append(",fromId:");
    localStringBuilder.append(str2);
    localStringBuilder.append(" isGroupCode:");
    localStringBuilder.append(str3);
    QLog.i("JumpAction", 1, localStringBuilder.toString());
    localIGroupVideoManager.a(this.jdField_a_of_type_AndroidContentContext, str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), i, "download", str2, str4, str5, str6);
    return true;
  }
  
  private boolean bJ()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    localObject = (IGroupVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
    QLog.i("JumpAction", 1, "[goToPreLoadGroupVideoPlugin]");
    ((IGroupVideoManager)localObject).a(null, 10L);
    return true;
  }
  
  private boolean bK()
  {
    ((StudyRoomManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  private boolean bL()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("guin");
    Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    i = 0;
    if ((!bool) && (((TroopManager)localObject2).l((String)localObject1)))
    {
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
      if ("group_file".equals(localObject2))
      {
        TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1);
        return true;
      }
      if ("group_album".equals(localObject2)) {
        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gname");
      }
    }
    label259:
    try
    {
      j = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("unreadnum"));
      i = j;
    }
    catch (NumberFormatException localNumberFormatException4)
    {
      label145:
      break label145;
    }
    TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1, (String)localObject2, i);
    return true;
    if ("group_story".equals(localObject2)) {}
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("troopStoryMemoriesFrom")) {
        i = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("troopStoryMemoriesFrom"));
      } else {
        i = 8;
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      int m;
      break label259;
    }
    try
    {
      k = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("playVideoFrom"));
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      j = i;
      break label261;
    }
    try
    {
      m = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("lastOpenFrom"));
      j = k;
      k = m;
      m = j;
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      j = i;
      i = k;
      break label263;
    }
    j = 0;
    label261:
    i = 0;
    label263:
    k = 0;
    m = i;
    i = j;
    localObject1 = QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, null, (String)localObject1, i, m);
    ((Intent)localObject1).putExtra("extra_last_open_from", k);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
    return true;
    if ("bulk_send_message".equals(localObject2))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gc");
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("extra.GROUP_UIN", (String)localObject1);
      ((Bundle)localObject2).putString("selfSet_leftViewText", HardCodeUtil.a(2131705968));
      BulkSendMessageFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject2);
      return true;
    }
    return false;
    if (QLog.isColorLevel()) {
      QLog.e("JumpAction", 2, new Object[] { "illegal goToTroopProfileApp jumpAction. troopUin=", localObject1 });
    }
    return false;
  }
  
  private boolean bM()
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, 0, 2131558642, 17);
    localQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690163));
    localQQProgressDialog.getWindow().setDimAmount(0.0F);
    localQQProgressDialog.show();
    localQQProgressDialog.setCanceledOnTouchOutside(true);
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app");
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.e("JumpAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen jumpAction. appName=null");
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("meta");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
    ArkAppMgr.getInstance().getAppPathByName(str1, "0.0.0.1", new JumpActionLegacy.31(this, localQQProgressDialog, str3, str2, str1));
    return true;
  }
  
  private boolean bN()
  {
    WatchTogetherManager localWatchTogetherManager = (WatchTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WATCH_LIVE_TOGETHER);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if (localObject1 != null)
      {
        localObject1 = ((Intent)localObject1).getDataString();
        break label51;
      }
    }
    Object localObject1 = "";
    label51:
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.jdField_a_of_type_JavaLangString;
    }
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
    boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("room_type");
    String str = "0";
    if (bool) {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("room_type");
    } else {
      localObject1 = "0";
    }
    localNewTogetherRoomMessageData.jdField_a_of_type_Int = Integer.parseInt((String)localObject1);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("group_uin")) {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("group_uin");
    } else {
      localObject1 = "0";
    }
    localNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString = ((String)localObject1);
    localObject1 = str;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("group_owner_uin")) {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("group_owner_uin");
    }
    localNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString = ((String)localObject1);
    localNewTogetherRoomMessageData.jdField_e_of_type_JavaLangString = ((String)localObject2);
    localNewTogetherRoomMessageData.f = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("cover_url"));
    Object localObject3 = Uri.parse((String)localObject2);
    localObject1 = ((Uri)localObject3).getQueryParameter("roomid");
    localObject2 = ((Uri)localObject3).getQueryParameter("room_show_number");
    str = ((Uri)localObject3).getQueryParameter("fromid");
    localObject3 = ((Uri)localObject3).getQueryParameter("room_group_code");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localNewTogetherRoomMessageData.jdField_a_of_type_Long = Integer.parseInt((String)localObject1);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localNewTogetherRoomMessageData.jdField_b_of_type_Int = Integer.parseInt((String)localObject2);
    }
    if (!TextUtils.isEmpty(str)) {
      localNewTogetherRoomMessageData.jdField_g_of_type_JavaLangString = str;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      localNewTogetherRoomMessageData.jdField_c_of_type_JavaLangString = ((String)localObject3);
    }
    localWatchTogetherManager.a(localNewTogetherRoomMessageData);
    return true;
  }
  
  private boolean bO()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
    if ((str != null) && (!"".equals(str)))
    {
      if (str.length() < 5) {
        return false;
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject1 != null)
        {
          localObject1 = ((TroopManager)localObject1).b(str);
          if ((localObject1 != null) && (((TroopInfo)localObject1).isAdmin()))
          {
            i = 1;
            break label89;
          }
        }
        int i = 0;
        label89:
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("gotoGroupManager not admin ");
            ((StringBuilder)localObject1).append(str);
            QLog.i("JumpAction", 2, ((StringBuilder)localObject1).toString());
          }
          return false;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((Intent)localObject1).putExtra("troop_uin", str);
        ((Intent)localObject1).putExtra("key_is_update_before_805", ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isUpdateBeforeSomeVersion(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
        ((Intent)localObject1).putExtra("troop_manage_from_jump_action", true);
        ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
        Object localObject2 = new TroopManageCmd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        if (localPluginCommunicationHandler != null) {
          localPluginCommunicationHandler.register((RemoteCommand)localObject2);
        }
        localObject2 = TroopBaseProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext);
        TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, (Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopManageActivity", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("gotoGroupManager ");
          ((StringBuilder)localObject1).append(str);
          QLog.i("JumpAction", 2, ((StringBuilder)localObject1).toString());
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager context not activity");
      }
    }
    return false;
  }
  
  private boolean ba()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    Object localObject6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    Object localObject8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    Object localObject9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    } else {
      localObject1 = null;
    }
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    try
    {
      i = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
    }
    catch (Exception localException1)
    {
      int i;
      label287:
      Object localObject2;
      long l2;
      label377:
      label380:
      break label287;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gotoQfavShareMsg|parse extflags exp: extflag=");
      ((StringBuilder)localObject2).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"));
      QLog.e("qqfav", 2, ((StringBuilder)localObject2).toString());
    }
    i = 0;
    l2 = 0L;
    do
    {
      try
      {
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      }
      catch (Exception localException2)
      {
        long l1;
        int j;
        Object localObject7;
        Object localObject4;
        break label380;
      }
      try
      {
        l1 = Long.valueOf((String)((HashMap)localObject2).get("share_id")).longValue();
      }
      catch (Exception localException3)
      {
        break label377;
      }
      l1 = l2;
    } while (!QLog.isColorLevel());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("gotoQfavShareMsg|parse appid exp: appid=");
    ((StringBuilder)localObject2).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
    QLog.e("qqfav", 2, ((StringBuilder)localObject2).toString());
    l1 = l2;
    j = i;
    localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    i = (int)l1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "";
    } else {
      localObject2 = localObject1;
    }
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      localObject4 = "";
    } else {
      localObject4 = this.jdField_e_of_type_JavaLangString;
    }
    QfavReport.a((AppRuntime)localObject7, "User_SdkShare", i, 0, 0, 0, (String)localObject2, (String)localObject4);
    localObject7 = new Bundle();
    ((Bundle)localObject7).putString("title", (String)localObject3);
    ((Bundle)localObject7).putString("desc", (String)localObject5);
    ((Bundle)localObject7).putString("image_url", (String)localObject6);
    ((Bundle)localObject7).putString("detail_url", (String)localObject8);
    ((Bundle)localObject7).putLong("req_share_id", l1);
    ((Bundle)localObject7).putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    ((Bundle)localObject7).putString("image_url_remote", (String)localObject9);
    ((Bundle)localObject7).putString("app_name", (String)localObject1);
    ((Bundle)localObject7).putString("open_id", str3);
    ((Bundle)localObject7).putString("share_uin", str4);
    ((Bundle)localObject7).putString("jfrom", str5);
    ((Bundle)localObject7).putString("share_qq_ext_str", str6);
    ((Bundle)localObject7).putInt("cflag", j);
    ((Bundle)localObject7).putInt("forward_type", 11);
    try
    {
      i = Integer.valueOf(str2).intValue();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label671:
      label1117:
      label1786:
      break label671;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gotoQfavShareMsg|parse reqtype exp: reqType=");
      ((StringBuilder)localObject2).append(str2);
      QLog.e("qqfav", 2, ((StringBuilder)localObject2).toString());
    }
    i = 1;
    ((Bundle)localObject7).putInt("req_type", i);
    if (2 == i)
    {
      ((Bundle)localObject7).putString("audio_url", str1);
      if ((TextUtils.isEmpty((CharSequence)localObject3)) && (TextUtils.isEmpty((CharSequence)localObject5))) {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((Bundle)localObject7).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131698144), new Object[] { localObject1 }));
        } else {
          ((Bundle)localObject7).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131698145));
        }
      }
    }
    else if (6 == i)
    {
      ((Bundle)localObject7).putBoolean("key_sdk_share_pure_text", true);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = localObject3;
      } else {
        localObject1 = "";
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject5;
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("\n");
          ((StringBuilder)localObject2).append((String)localObject5);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
      ((Bundle)localObject7).putString("forward_text", (String)localObject2);
      ((Bundle)localObject7).putString("qqfav_extra_richmedia_title", (String)localObject3);
      ((Bundle)localObject7).putString("qqfav_extra_mixed_msg", (String)localObject5);
    }
    else if (5 == i)
    {
      ((Bundle)localObject7).putBoolean("qqfav_extra_pic_share", true);
      ((Bundle)localObject7).putBoolean("qqfav_extra_only_pic", TextUtils.isEmpty((CharSequence)localObject5));
      ((Bundle)localObject7).putString("qqfav_extra_richmedia_title", (String)localObject3);
      ((Bundle)localObject7).putString("qqfav_extra_mixed_msg", (String)localObject5);
      ((Bundle)localObject7).putString("desc", "");
      localObject4 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject4 = localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject5))
        {
          localObject4 = ((String)localObject5).replace("\024", "");
          ((Bundle)localObject7).putString("title", (String)localObject4);
        }
      }
      localObject8 = new ArrayList();
      if (!TextUtils.isEmpty((CharSequence)localObject6))
      {
        localObject9 = ((String)localObject6).split(";");
        i = 0;
        localObject2 = null;
        for (localObject3 = null; i < localObject9.length; localObject3 = localObject6)
        {
          try
          {
            localObject1 = URLDecoder.decode(localObject9[i], "UTF-8");
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            break label1117;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("gotoQfavShareMsg|decode exp. imageUrls[i]=");
            ((StringBuilder)localObject1).append(localObject9[i]);
            QLog.e("qqfav", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = "";
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if ((((String)localObject1).startsWith("/")) && (new File((String)localObject1).exists()))
            {
              ((ArrayList)localObject8).add(localObject1);
              localObject5 = localObject2;
              localObject6 = localObject3;
              if (TextUtils.isEmpty((CharSequence)localObject3))
              {
                localObject5 = localObject2;
                localObject6 = localObject1;
              }
            }
            else
            {
              localObject5 = localObject2;
              localObject6 = localObject3;
              if (((String)localObject1).startsWith("http"))
              {
                ((ArrayList)localObject8).add(localObject1);
                localObject5 = localObject2;
                localObject6 = localObject3;
                if (TextUtils.isEmpty((CharSequence)localObject2))
                {
                  localObject5 = localObject1;
                  localObject6 = localObject3;
                }
              }
            }
          }
          else
          {
            localObject5 = localObject2;
            localObject6 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("gotoQfavShareMsg|file path invalid. path=");
              ((StringBuilder)localObject5).append((String)localObject1);
              QLog.e("qqfav", 2, ((StringBuilder)localObject5).toString());
              localObject6 = localObject3;
              localObject5 = localObject2;
            }
          }
          i += 1;
          localObject2 = localObject5;
        }
        localObject1 = localObject3;
      }
      else
      {
        localObject1 = null;
        localObject2 = null;
      }
      if (((ArrayList)localObject8).isEmpty())
      {
        QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131698142, 1);
        if (QLog.isColorLevel()) {
          QLog.e("qqfav", 2, "gotoQfavShareMsg|image type.no image path");
        }
        return false;
      }
      ((Bundle)localObject7).putString("image_url", (String)localObject1);
      ((Bundle)localObject7).putString("image_url_remote", (String)localObject2);
      ((Bundle)localObject7).putStringArrayList("qqfav_extra_multi_pic_path_list", (ArrayList)localObject8);
      if (1 == ((ArrayList)localObject8).size())
      {
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          ((Bundle)localObject7).putInt("req_type", 5);
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
            ((Bundle)localObject7).putString("image_url", (String)localObject2);
          }
        }
        else
        {
          ((Bundle)localObject7).putInt("req_type", 1);
        }
      }
      else
      {
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((ArrayList)localObject8).size());
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131694555));
          ((Bundle)localObject7).putString("title", ((StringBuilder)localObject1).toString());
        }
        ((Bundle)localObject7).putBoolean("qqfav_extra_multi_pic", true);
        ((Bundle)localObject7).putInt("req_type", 1);
      }
    }
    else
    {
      if (1 != i) {
        break label1786;
      }
      if ((TextUtils.isEmpty((CharSequence)localObject3)) && (TextUtils.isEmpty((CharSequence)localObject5))) {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((Bundle)localObject7).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131698144), new Object[] { localObject1 }));
        } else {
          ((Bundle)localObject7).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131698145));
        }
      }
      if ((TextUtils.isEmpty((CharSequence)localObject8)) && (QLog.isColorLevel())) {
        QLog.i("qqfav", 2, "gotoQfavShareMsg|link type. no detail url");
      }
    }
    com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.jdField_a_of_type_Boolean = true;
    localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
    ((Intent)localObject1).putExtra("toUin", AppConstants.FAVORITES_UIN);
    ((Intent)localObject1).putExtra("uinType", 0);
    if (1 == j) {
      ((Intent)localObject1).putExtra("qqfav_extra_from_system_share", true);
    } else {
      ((Intent)localObject1).putExtra("qqfav_extra_from_sdk_share", true);
    }
    ((Intent)localObject1).putExtras((Bundle)localObject7);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, DirectForwardActivity.class);
    return true;
    QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131698142, 1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("gotoQfavShareMsg|unknown reqType. reqType=");
      ((StringBuilder)localObject1).append(i);
      QLog.e("qqfav", 2, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  private boolean bb()
  {
    int i = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"))).intValue();
    String str;
    if (i == 3)
    {
      str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_uri"));
      if (!TextUtils.isEmpty(str))
      {
        ThreadManagerV2.executeOnSubThread(new JumpActionLegacy.19(this, str));
        return true;
      }
      a(true);
      return true;
    }
    if (i == 4)
    {
      str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoUri"));
      if (!TextUtils.isEmpty(str))
      {
        ThreadManagerV2.executeOnSubThread(new JumpActionLegacy.20(this, str));
        return true;
      }
      a(true);
    }
    return true;
  }
  
  private boolean bc()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    String str3 = QUA.getQUA3();
    QZoneShareManager.shareToQZoneForRedPocket(this.jdField_a_of_type_AndroidContentContext, str1, null, 0, str2, str3);
    return true;
  }
  
  private boolean bd()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_uin");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(str))
    {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extinfo");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("mqzone://arouse/homepage?redpocket=1&uin=");
        ((StringBuilder)localObject1).append(str);
        str = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mqzone://arouse/homepage?redpocket=1&uin=");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("&extinfo=");
        ((StringBuilder)localObject2).append((String)localObject1);
        str = ((StringBuilder)localObject2).toString();
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("cmd", "Schema");
      ((Intent)localObject1).putExtra("schema", str);
      QZoneHelper.forwardToQzoneTransluentActivity((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.getInstance(), (Intent)localObject1);
      return true;
    }
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    if ((!TextUtils.isEmpty(str)) && (str.equals("login")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131705971), 1).a();
      return true;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131705981), 1).a();
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    str = "?";
    if (((String)localObject2).indexOf("?") > -1) {
      str = "&";
    }
    ((StringBuilder)localObject1).append(str);
    str = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append("jfrom=login");
    str = ((StringBuilder)localObject1).toString();
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("scheme_content", str);
    ((Intent)localObject1).putExtra("pkg_name", "com.tencent.mobileqq");
    ((Intent)localObject1).putExtras((Intent)localObject1);
    ((Intent)localObject1).setFlags(268435456);
    if (VersionUtils.e()) {
      ((Intent)localObject1).addFlags(32768);
    }
    RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, "/base/login");
    return true;
  }
  
  private boolean be()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131705973), 1).a();
    return false;
  }
  
  private boolean bf()
  {
    return true;
  }
  
  private boolean bg()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localUserInfo.nickname = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      QZoneHelper.forwardToPublishQueue((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, -1);
      return true;
    }
    return false;
  }
  
  private boolean bh()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str1 = str2;
    try
    {
      if (TextUtils.isEmpty(str2)) {
        str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      }
      QZoneHelper.forwardToUserHome((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.getInstance(), str1, 0, 0, 0);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("JumpAction", 1, localException, new Object[0]);
    }
    return true;
  }
  
  private boolean bi()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, JoinDiscussionActivity.class);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    localIntent.putExtra("sig", str);
    if (TextUtils.isEmpty(str)) {
      localIntent.putExtra("innerSig", (String)this.jdField_a_of_type_JavaUtilHashMap.get("k"));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean bj()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AgentActivity.class);
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
    }
    localIntent.putExtra("key_params", localBundle);
    localIntent.putExtra("key_action", "action_ptlogin_login");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean bk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoMultiVoiceChat");
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("relation_id");
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("actid");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mp_ext_params");
    HashMap localHashMap = new HashMap();
    if ((localObject2 != null) && (((String)localObject2).equals("video"))) {
      localHashMap.put("isVideo", "true");
    }
    if (str5 != null)
    {
      localHashMap.put("mp_ext_params", str5);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gotoMultiVoiceChat mp_ext_params : ");
        localStringBuilder.append(str5);
        QLog.d("JumpAction", 2, localStringBuilder.toString());
      }
    }
    if ((str4 != null) && (localObject2 != null))
    {
      localHashMap.put("actid", str4);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("gotoMultiVoiceChat actId : ");
        ((StringBuilder)localObject2).append(str4);
        QLog.d("JumpAction", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if ((str1 != null) && (str1.equals("web")) && (str2 != null) && (str2.equals("1")) && (localObject1 != null) && (str3 != null))
    {
      if (str3.equals("discussgroup"))
      {
        if (((String)localObject1).equals("0"))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("param_type", 3000);
          ((Intent)localObject1).putExtra("param_subtype", 0);
          ((Intent)localObject1).putExtra("param_from", 1003);
          ((Intent)localObject1).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131691273));
          ((Intent)localObject1).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131691600));
          ((Intent)localObject1).putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131691601));
          ((Intent)localObject1).putExtra("param_max", 99);
          ((Intent)localObject1).setFlags(603979776);
          ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult((QBaseActivity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 1);
          return true;
        }
        return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3000, (String)localObject1, true, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, localHashMap);
      }
      if (str3.equals("single"))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("forward_type", 13);
        ((Intent)localObject1).putExtra("fromWebXman", true);
        ForwardBaseOption.a((QBaseActivity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 2);
        return true;
      }
      if (str3.equals("group"))
      {
        if (!((String)localObject1).equals("0"))
        {
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from");
          boolean bool;
          if ((!"gvideo".equals(str1)) && (!"gvideo_h5".equals(str1))) {
            bool = true;
          } else {
            bool = false;
          }
          return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject1, true, bool, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, this.jdField_a_of_type_JavaUtilHashMap);
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean bl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoVideoChat");
    }
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    if ((localObject3 != null) && ("forward_to_tab".equals(localObject3)))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      ((Intent)localObject1).putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      ((Intent)localObject1).putExtra("conversation_index", 1);
      ((Intent)localObject1).setFlags(335544320);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uinType");
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("phone");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extraUin");
    Object localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("actid");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mp_ext_params");
    if ((localObject5 != null) && (localObject3 != null) && (((String)localObject3).equals("audio")) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoVideoChat actId : ");
      localStringBuilder.append((String)localObject5);
      QLog.d("JumpAction", 2, localStringBuilder.toString());
    }
    if ((str5 != null) && (QLog.isColorLevel()))
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("gotoVideoChat mp_ext_params : ");
      ((StringBuilder)localObject5).append(str5);
      QLog.d("JumpAction", 2, ((StringBuilder)localObject5).toString());
    }
    try
    {
      i = Integer.parseInt(str4);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      label348:
      boolean bool1;
      Object localObject4;
      boolean bool2;
      break label348;
    }
    i = 0;
    if ((str1 != null) && (str1.equals("web")) && (i > 0))
    {
      try
      {
        i = Integer.valueOf(str3).intValue();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoVideoChat", localException);
          }
          i = 0;
        }
      }
      i = VideoController.a(i, false, 1);
      if ((localObject3 != null) && (((String)localObject3).equals("audio"))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (i == 1006)
      {
        if (!((String)localObject1).startsWith("+"))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("+");
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject3).toString();
        }
        localObject3 = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber((String)localObject1);
        if (localObject3 != null) {
          localObject3 = ((PhoneContact)localObject3).name;
        } else {
          localObject3 = localObject1;
        }
        localObject4 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject4 = localObject1;
        }
      }
      for (localObject2 = localObject3;; localObject2 = localObject3)
      {
        bool2 = true;
        break;
        if (i == 1011)
        {
          localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickName");
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject3 = localObject4;
            if (!((String)localObject2).equals(localObject4)) {}
          }
          else
          {
            localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695744);
          }
          bool1 = true;
          bool2 = false;
          localObject4 = localObject2;
          localObject2 = localObject3;
          break;
        }
        int j = ContactUtils.a(i);
        if (j == -1) {
          localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, i);
        } else {
          localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, str2, j, 0);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject2).equals(localObject3))) {
          break label711;
        }
        localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, true);
        label711:
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject3 = localObject2;
        }
        localObject4 = localObject2;
      }
      return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i, (String)localObject4, (String)localObject2, (String)localObject1, bool1, str2, bool2, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
    }
    return false;
  }
  
  private boolean bm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoRandomVideoChat");
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("session_name"));
    this.jdField_a_of_type_JavaUtilHashMap.put("session_name", str4);
    boolean bool;
    if ((str2 != null) && (str2.equals("audio"))) {
      bool = true;
    } else {
      bool = false;
    }
    try
    {
      i = Integer.parseInt(str3);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      label137:
      break label137;
    }
    i = 0;
    if ((str1 != null) && (str1.equals("web")) && (i > 0)) {
      return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1011, null, null, null, bool, null, false, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
    }
    return false;
  }
  
  private boolean bn()
  {
    if (this.jdField_c_of_type_JavaLangString.equals("jump"))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("options");
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/base/vipcomic");
      localActivityURIRequest.extra().putString("options", str);
      QRoute.startUri(localActivityURIRequest, null);
      return true;
    }
    return false;
  }
  
  private boolean bo()
  {
    String str = "cspecialflag";
    Object localObject8;
    int i;
    Object localObject9;
    Object localObject11;
    Object localObject12;
    Object localObject13;
    int j;
    try
    {
      localIntent = new Intent("android.intent.action.MAIN");
      b(localIntent);
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet();
      localObject4 = b("download_sourceid");
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        localIntent.putExtra("big_brother_source_key", (String)localObject4);
      }
      bool = TextUtils.isEmpty(b("from_leba"));
      if (!bool)
      {
        localIntent.putExtra("plugin_start_time", System.nanoTime());
        localIntent.putExtra("click_start_time", System.currentTimeMillis());
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        localIntent.putExtra("is_from_leba", true);
        localIntent.putExtra("has_red_dot", this.jdField_d_of_type_Boolean);
      }
      Iterator localIterator = ((Set)localObject1).iterator();
      localObject4 = "";
      localObject8 = null;
      localObject1 = null;
      i = 0;
      localObject9 = null;
      bool = localIterator.hasNext();
      localObject10 = "1";
      if (bool)
      {
        localObject10 = (Map.Entry)localIterator.next();
        localObject11 = (String)((Map.Entry)localObject10).getKey();
        localObject10 = (String)((Map.Entry)localObject10).getValue();
        if ((localObject11 == null) || (localObject10 == null)) {
          break label3275;
        }
        if ("pkg".equals(localObject11))
        {
          localObject11 = localObject10;
          localObject12 = localObject1;
          localObject13 = localObject9;
          break label3256;
        }
        if ("cmp".equals(localObject11))
        {
          localObject11 = localObject8;
          localObject12 = localObject10;
          localObject13 = localObject9;
          break label3256;
        }
        if ("plg_account".equals(localObject11))
        {
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject9;
          if (!"1".equals(localObject10)) {
            break label3256;
          }
          localIntent.putExtra("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject9;
          break label3256;
        }
        if ("plg_nickname".equals(localObject11))
        {
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject9;
          if (!"1".equals(localObject10)) {
            break label3256;
          }
          localObject11 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
          localObject10 = localObject11;
          if (StringUtil.a((String)localObject11)) {
            localObject10 = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          }
          localIntent.putExtra("nickname", (String)localObject10);
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject9;
          break label3256;
        }
        if ("plg_vkey".equals(localObject11))
        {
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject9;
          if (!"1".equals(localObject10)) {
            break label3256;
          }
          localIntent.putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getvKeyStr());
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject9;
          break label3256;
        }
        if ("plg_launchtime".equals(localObject11))
        {
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject9;
          if (!"1".equals(localObject10)) {
            break label3256;
          }
          localIntent.putExtra("launch_time", System.currentTimeMillis());
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject9;
          break label3256;
        }
        if ("plg_newflag".equals(localObject11))
        {
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject9;
          if (!"1".equals(localObject10)) {
            break label3256;
          }
          localIntent.putExtra("newflag", this.jdField_c_of_type_Boolean);
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject9;
          if (!QLog.isColorLevel()) {
            break label3256;
          }
          localObject10 = new StringBuilder();
          ((StringBuilder)localObject10).append("handleAppForward.newflag=");
          ((StringBuilder)localObject10).append(this.jdField_c_of_type_Boolean);
          QLog.d("Jumpaction", 2, ((StringBuilder)localObject10).toString());
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject9;
          break label3256;
        }
        if ("plg_type".equals(localObject11))
        {
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject9;
          if (!"1".equals(localObject10)) {
            break label3256;
          }
          i = 1;
          localObject12 = localObject1;
          localObject1 = localObject4;
          break label3268;
        }
        if ("apk".equals(localObject11))
        {
          localObject12 = localObject1;
          localObject1 = localObject10;
          break label3268;
        }
        if ("src_type".equals(localObject11))
        {
          localObject11 = localObject8;
          localObject12 = localObject1;
          localObject13 = localObject10;
          break label3256;
        }
        localIntent.putExtra((String)localObject11, (String)localObject10);
        localObject11 = localObject8;
        localObject12 = localObject1;
        localObject13 = localObject9;
        break label3256;
      }
      if ((localObject8 != null) && (localObject1 != null) && (!"".equals(localObject8)) && (!"".equals(localObject1)))
      {
        if ((this.jdField_a_of_type_Boolean) && (JumpFilterHelper.a().a(this.jdField_a_of_type_AndroidContentContext, (String)localObject8, (String)localObject1))) {
          return false;
        }
        if (TextUtils.isEmpty((CharSequence)localObject8)) {
          break label3293;
        }
        localObject11 = jdField_a_of_type_ArrayOfJavaLangString;
        int k = localObject11.length;
        j = 0;
        label879:
        if (j >= k) {
          break label3293;
        }
        if (!((String)localObject8).equals(localObject11[j])) {
          break label3286;
        }
        j = 1;
        label901:
        if (j == 0)
        {
          localIntent.putExtra("vkey", (String)null);
          localIntent.putExtra("sid", (String)null);
          localIntent.putExtra("nickname", (String)null);
          localIntent.putExtra("account", (String)null);
        }
        if (((String)localObject1).startsWith("com.qzone"))
        {
          localIntent.putExtra("refer", "mqqActiveTab");
          if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
            localIntent.putExtra("qzone_feeds_key", this.jdField_i_of_type_JavaLangString);
          }
          if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
            localIntent.putExtra("qzone_feeds_time", this.jdField_j_of_type_JavaLangString);
          }
          if (!TextUtils.isEmpty(this.k)) {
            localIntent.putExtra("qzone_feeds_index", this.k);
          }
          localIntent.putExtra("had_digital_reddot", this.jdField_e_of_type_Boolean);
          if (QZoneLoginReportHelper.needAddLoginFromLebaTab(localIntent, (String)localObject1)) {
            QZoneLoginReportHelper.setLoginFromLebaTab(localIntent);
          }
        }
        if (i == 0) {
          if (((String)localObject1).startsWith("com.qzone"))
          {
            QzonePluginProxyActivity.setActivityNameToIntent(localIntent, (String)localObject1);
            localIntent.addFlags(536870912);
          }
        }
      }
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Intent localIntent;
      Object localObject1;
      Object localObject4;
      boolean bool;
      Object localObject10;
      label1131:
      Object localObject5;
      label1742:
      Object localObject6;
      label2696:
      label2729:
      localActivityNotFoundException.printStackTrace();
      label3228:
      return false;
    }
    try
    {
      QzonePluginProxyActivity.launchPluingActivityForResult((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localIntent, -1);
    }
    catch (Exception localException2)
    {
      break label1131;
    }
    localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, TranslucentActivity.class);
    ((Intent)localObject1).addFlags(268435456);
    ((Intent)localObject1).putExtras(localIntent);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
    break label3228;
    if (((String)localObject1).endsWith("NearbyTroopsActivity"))
    {
      NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = localObject10;
      if (this.jdField_d_of_type_Boolean) {
        localObject1 = "0";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_entry", "Clk_nearbygrp", 0, 0, "", "", "", (String)localObject1);
    }
    else
    {
      bool = ((String)localObject1).endsWith("PoiMapActivity");
      if (bool)
      {
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
        {
          QLog.e("JumpAction", 1, "context is not instanceof BaseActivity");
          return false;
        }
        try
        {
          localObject4 = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
          if ((localObject4 == null) || (((ChatFragment)localObject4).a() == null)) {
            break label3228;
          }
          ((ChatFragment)localObject4).a().ae();
          i = ((ChatFragment)localObject4).a().a.jdField_a_of_type_Int;
          localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          localIntent.putExtra("sessionType", i);
          localObject8 = localIntent.getStringExtra("lat");
          localObject9 = localIntent.getStringExtra("lon");
          localObject4 = localIntent.getStringExtra("loc");
          if ((localObject8 != null) && (localObject9 != null))
          {
            localObject8 = Double.valueOf((String)localObject8);
            localObject9 = Double.valueOf((String)localObject9);
            localObject10 = new StringBuilder();
            ((StringBuilder)localObject10).append("http://maps.google.com/maps?q=");
            ((StringBuilder)localObject10).append(localObject8);
            ((StringBuilder)localObject10).append(",");
            ((StringBuilder)localObject10).append(localObject9);
            ((StringBuilder)localObject10).append("&iwloc=A&hl=zh-CN (");
            ((StringBuilder)localObject10).append((String)localObject4);
            ((StringBuilder)localObject10).append(")");
            localIntent.putExtra("url", ((StringBuilder)localObject10).toString());
          }
          localIntent.setClassName(this.jdField_a_of_type_AndroidContentContext.getPackageName(), (String)localObject1);
          ((QBaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 18);
          QQMapRoutingHelper.a("see_location");
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
      else if ((!TextUtils.isEmpty(localException1)) && (!TextUtils.isEmpty((CharSequence)localObject8)) && (localException1.equalsIgnoreCase("com.tencent.biz.coupon.CouponActivity")) && (((String)localObject8).equalsIgnoreCase("com.tencent.mobileqq")))
      {
        localObject10 = new StringBuffer();
        if ((this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.type.get() > 0) && (this.jdField_c_of_type_Boolean))
        {
          ((StringBuffer)localObject10).append("isRedLight=1");
          if (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.type.has())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("&redType=");
            ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.type.get());
            ((StringBuffer)localObject10).append(((StringBuilder)localObject4).toString());
          }
          bool = this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.buffer.has();
          if (bool)
          {
            try
            {
              localObject4 = URLEncoder.encode(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.buffer.get(), "UTF-8");
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              if (!QLog.isColorLevel()) {
                break label3298;
              }
            }
            QLog.d("JumpAction", 2, localUnsupportedEncodingException.getMessage());
            break label3298;
            localObject9 = new StringBuilder();
            ((StringBuilder)localObject9).append("&couponBuffer=");
            ((StringBuilder)localObject9).append(localUnsupportedEncodingException);
            ((StringBuffer)localObject10).append(((StringBuilder)localObject9).toString());
          }
        }
        else
        {
          ((StringBuffer)localObject10).append("isRedLight=0");
        }
        localObject9 = b("url");
        localObject5 = localObject9;
        if (!TextUtils.isEmpty((CharSequence)localObject9))
        {
          localObject5 = localObject9;
          if (QRUtils.g((String)localObject9)) {
            localObject5 = HtmlOffline.a((String)localObject9, ((StringBuffer)localObject10).toString());
          }
        }
        a((String)localObject5, (String)localObject8, localException1, localIntent);
        h(localException1);
      }
      else if ((!TextUtils.isEmpty(localException1)) && (!TextUtils.isEmpty((CharSequence)localObject8)) && (localException1.equalsIgnoreCase("com.tencent.gamecenter.activities.GameCenterActivity")) && (((String)localObject8).equalsIgnoreCase("com.tencent.mobileqq")))
      {
        localObject5 = b("url");
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          localObject5 = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
        } else {
          try
          {
            localObject5 = URLDecoder.decode((String)localObject5);
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            localObject6 = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
          }
        }
        localObject9 = new StringBuilder();
        ((StringBuilder)localObject9).append("st=");
        ((StringBuilder)localObject9).append(System.currentTimeMillis());
        localObject10 = ((StringBuilder)localObject9).toString();
        localObject9 = localObject10;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject9 = localObject10;
          if (AuthorizeConfig.a().i((String)localObject6))
          {
            localObject9 = new StringBuilder();
            ((StringBuilder)localObject9).append((String)localObject10);
            ((StringBuilder)localObject9).append("&uin=");
            ((StringBuilder)localObject9).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localObject9 = ((StringBuilder)localObject9).toString();
          }
        }
        localObject10 = localObject9;
        if (!TextUtils.isEmpty(this.h))
        {
          localObject10 = new StringBuilder();
          ((StringBuilder)localObject10).append((String)localObject9);
          ((StringBuilder)localObject10).append("&");
          ((StringBuilder)localObject10).append(this.h);
          localObject10 = ((StringBuilder)localObject10).toString();
        }
        localObject9 = localObject10;
        if (((String)localObject6).indexOf("?") < 0)
        {
          localObject9 = new StringBuilder();
          ((StringBuilder)localObject9).append((String)localObject10);
          ((StringBuilder)localObject9).append("&plat=qq&_wv=5127");
          localObject9 = ((StringBuilder)localObject9).toString();
        }
        localObject9 = HtmlOffline.a((String)localObject6, (String)localObject9);
        bool = TextUtils.isEmpty(b("from_leba")) ^ true;
        localObject6 = localObject9;
        if (bool)
        {
          localObject6 = localObject9;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localObject6 = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER);
            if (!this.jdField_d_of_type_Boolean) {
              break label3304;
            }
            i = PadFaceManager.a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, true);
          }
        }
      }
    }
    for (;;)
    {
      localObject10 = ((GameCenterManagerImp)localObject6).a().a(i);
      localObject6 = localObject9;
      if (localObject10 != null)
      {
        QLog.d("JumpAction", 2, new Object[] { "add PadFaceAd=", localObject10 });
        localObject6 = HtmlOffline.a((String)localObject9, "show_ark=1");
        PadFaceManager.a((PadFaceAd)localObject10, localIntent);
      }
      i = ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).canOpenHippyByModuleName("QQGameCenter");
      if (QLog.isColorLevel())
      {
        localObject9 = new StringBuilder();
        ((StringBuilder)localObject9).append("open QQGameCenter checkCode:");
        ((StringBuilder)localObject9).append(i);
        ((StringBuilder)localObject9).append(" isFromLeba:");
        ((StringBuilder)localObject9).append(bool);
        QLog.i("JumpAction", 2, ((StringBuilder)localObject9).toString());
      }
      if ((i == 0) && (bool))
      {
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).openQQGameCenterByHippy(this.jdField_a_of_type_AndroidContentContext, (String)localObject6, "dynamic");
      }
      else
      {
        a((String)localObject6, (String)localObject8, localException1, localIntent);
        h(localException1);
      }
      if (bool) {
        HippyReporter.getInstance().reportGameCenterHippy(i);
      }
      Object localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        if (localObject2 != null) {
          ((MqqHandler)localObject2).sendMessageDelayed(((MqqHandler)localObject2).obtainMessage(1134050), 1000L);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "enter gameCenter");
      }
      ThreadManager.post(new JumpActionLegacy.25(this), 5, null, true);
      break label3228;
      if (((String)localObject2).endsWith("cooperation.readinjoy.ReadInJoyProxyActivity"))
      {
        ((IRIJJumpAction)QRoute.api(IRIJJumpAction.class)).launchReadInJoyPlugin(this.jdField_a_of_type_JavaUtilHashMap, localIntent, this.jdField_a_of_type_AndroidContentContext);
      }
      else
      {
        if (((String)localObject2).endsWith("NearbyTroopsActivity")) {
          localIntent.putExtra("from", 15);
        }
        if (((String)localObject2).endsWith("JoinGroupTransitActivity")) {
          localIntent.putExtra("source_scheme", this.jdField_a_of_type_JavaLangString);
        }
        if (((String)localObject2).endsWith("VipComicJumpActivity"))
        {
          localIntent.putExtra("has_red_dot", this.jdField_d_of_type_Boolean | this.jdField_c_of_type_Boolean);
          if (((IQQComicUtil)QRoute.api(IQQComicUtil.class)).initPluginBeforeEnter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localIntent)) {
            return true;
          }
        }
        if (localObject8 != null)
        {
          bool = ((String)localObject8).equals(BaseApplicationImpl.getContext().getPackageName());
          if (!bool) {}
        }
      }
      try
      {
        bool = PluginProxyActivity.class.isAssignableFrom(BaseApplicationImpl.getContext().getClassLoader().loadClass((String)localObject2));
      }
      catch (Exception localException4)
      {
        break label2696;
      }
      bool = false;
      if (bool) {
        return false;
      }
      localObject6 = localIntent.getStringExtra(str);
      if (localObject6 != null) {}
      try
      {
        i = Integer.parseInt((String)localObject6);
      }
      catch (Exception localException5)
      {
        break label2729;
      }
      i = 0;
      if (((String)localObject2).equalsIgnoreCase("com.tencent.biz.eqq.EnterpriseDetailActivity"))
      {
        localObject6 = ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplName(IEqqAccountDetailActivity.class);
      }
      else if ((!((String)localObject2).equalsIgnoreCase("com.tencent.biz.troopbar.TroopBarDetailActivity")) && (!"com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity".equals(localObject2)))
      {
        localObject6 = localObject2;
        if (!"com.tencent.biz.pubaccount.AccountDetailActivity".equals(localObject2)) {}
      }
      else
      {
        localObject6 = ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountDetailActivity.class);
      }
      if (((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountDetailActivity.class).equals(localObject6))
      {
        localObject10 = localIntent.getStringExtra("account_type");
        localObject2 = localObject6;
        if (localObject10 != null)
        {
          localObject2 = localObject6;
          if (Integer.parseInt((String)localObject10) == 2) {
            if (QidianManager.b(i))
            {
              localIntent.putExtra(str, i);
              localObject2 = "com.tencent.qidian.QidianProfileCardActivity";
            }
            else
            {
              localObject2 = ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplName(IEqqAccountDetailActivity.class);
            }
          }
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject9)) && (((String)localObject9).toLowerCase().equals("app"))) {
          localIntent.putExtra("source", 117);
        } else {
          localIntent.putExtra("source", 2);
        }
        localIntent.addFlags(67108864);
      }
      else if (((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplName(IEqqAccountDetailActivity.class).equals(localObject6))
      {
        localObject2 = localObject6;
        if (QidianManager.b(i))
        {
          localObject2 = "com.tencent.qidian.QidianProfileCardActivity";
          localIntent.putExtra(str, i);
        }
      }
      else
      {
        localIntent.addCategory("android.intent.category.LAUNCHER");
        localIntent.addFlags(268435456);
        localObject2 = localObject6;
      }
      if ("com.tencent.mobileqq.activity.QQBrowserActivity".equals(localObject2))
      {
        localObject6 = localIntent.getStringExtra("url");
        if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (!((String)localObject6).startsWith("http")))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("unsupport protocol: ");
          ((StringBuilder)localObject2).append((String)localObject6);
          QLog.e("JumpAction", 1, ((StringBuilder)localObject2).toString());
          return false;
        }
      }
      localIntent.setClassName((String)localObject8, (String)localObject2);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      h((String)localObject2);
      break label3228;
      localIntent.setClassName((String)localObject8, (String)localObject2);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.addFlags(268435456);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      break label3228;
      if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject6)))
      {
        bool = a(localIntent, (String)localObject2, (String)localObject6);
        return bool;
      }
      return true;
      return false;
      label3256:
      Object localObject3 = localException5;
      localObject9 = localObject13;
      localObject8 = localObject11;
      label3268:
      Object localObject7 = localObject3;
      break label3279;
      label3275:
      localObject12 = localObject3;
      label3279:
      localObject3 = localObject12;
      break;
      label3286:
      j += 1;
      break label879;
      label3293:
      j = 0;
      break label901;
      label3298:
      localObject7 = null;
      break label1742;
      label3304:
      i = 0;
    }
  }
  
  private boolean bp()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492C", "0X800492C", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.e("qqdataline", 2, "shareFromMigSdk|report send from sdk:0X800492C.");
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    Object localObject4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    Object localObject5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    } else {
      localObject1 = null;
    }
    Object localObject6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    Object localObject8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    try
    {
      i = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
    }
    catch (Exception localException1)
    {
      int i;
      label333:
      Object localObject7;
      long l1;
      break label333;
    }
    if (QLog.isColorLevel())
    {
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append("gotoQfavShareMsg|parse extflags exp: extflag=");
      ((StringBuilder)localObject7).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"));
      QLog.e("qqfav", 2, ((StringBuilder)localObject7).toString());
    }
    i = 0;
    l1 = 0L;
    try
    {
      localObject7 = this.jdField_a_of_type_JavaUtilHashMap;
    }
    catch (Exception localException2)
    {
      long l2;
      label426:
      label429:
      break label429;
    }
    try
    {
      l2 = Long.valueOf((String)((HashMap)localObject7).get("share_id")).longValue();
      l1 = l2;
    }
    catch (Exception localException3)
    {
      break label426;
    }
    if (QLog.isColorLevel())
    {
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append("gotoQfavShareMsg|parse appid exp: appid=");
      ((StringBuilder)localObject7).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
      QLog.e("qqfav", 2, ((StringBuilder)localObject7).toString());
    }
    localObject7 = new Bundle();
    ((Bundle)localObject7).putString("title", (String)localObject3);
    ((Bundle)localObject7).putString("desc", (String)localObject2);
    ((Bundle)localObject7).putString("image_url", str1);
    ((Bundle)localObject7).putString("detail_url", (String)localObject4);
    ((Bundle)localObject7).putLong("req_share_id", l1);
    ((Bundle)localObject7).putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    ((Bundle)localObject7).putString("image_url_remote", (String)localObject5);
    ((Bundle)localObject7).putString("app_name", (String)localObject1);
    ((Bundle)localObject7).putString("open_id", str2);
    ((Bundle)localObject7).putString("share_uin", str3);
    ((Bundle)localObject7).putString("jfrom", str4);
    ((Bundle)localObject7).putString("share_qq_ext_str", str5);
    ((Bundle)localObject7).putInt("cflag", i);
    ((Bundle)localObject7).putInt("forward_type", 11);
    try
    {
      i = Integer.valueOf((String)localObject8).intValue();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label648:
      label984:
      label1786:
      break label648;
    }
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("gotoQfavShareMsg|parse reqtype exp: reqType=");
      ((StringBuilder)localObject4).append((String)localObject8);
      QLog.e("qqfav", 2, ((StringBuilder)localObject4).toString());
    }
    i = 1;
    ((Bundle)localObject7).putInt("req_type", i);
    if (2 == i)
    {
      ((Bundle)localObject7).putString("audio_url", (String)localObject6);
      if ((TextUtils.isEmpty((CharSequence)localObject3)) && (TextUtils.isEmpty((CharSequence)localObject2))) {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((Bundle)localObject7).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131698144), new Object[] { localObject1 }));
        } else {
          ((Bundle)localObject7).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131698145));
        }
      }
    }
    for (;;)
    {
      break;
      if (6 == i)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = localObject3;
        } else {
          localObject1 = "";
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = localObject2;
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append("\n");
            ((StringBuilder)localObject3).append((String)localObject2);
            localObject1 = ((StringBuilder)localObject3).toString();
          }
        }
        ((Bundle)localObject7).putString("forward_text", (String)localObject1);
        ((Bundle)localObject7).putBoolean("isFromShare", true);
        ((Bundle)localObject7).putBoolean("key_sdk_share_pure_text", true);
      }
      else if (5 == i)
      {
        localObject8 = new ArrayList();
        if (!TextUtils.isEmpty(str1))
        {
          localObject6 = str1.split(";");
          i = 0;
          localObject1 = null;
          localObject2 = null;
          while (i < localObject6.length)
          {
            try
            {
              localObject3 = URLDecoder.decode(localObject6[i], "UTF-8");
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              break label984;
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("gotoQfavShareMsg|decode exp. imageUrls[i]=");
              ((StringBuilder)localObject3).append(localObject6[i]);
              QLog.e("qqfav", 2, ((StringBuilder)localObject3).toString());
            }
            localObject3 = "";
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              if ((((String)localObject3).startsWith("/")) && (new File((String)localObject3).exists()))
              {
                ((ArrayList)localObject8).add(localObject3);
                localObject5 = localObject1;
                localObject4 = localObject2;
                if (TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject5 = localObject3;
                  localObject4 = localObject2;
                }
              }
              else
              {
                localObject5 = localObject1;
                localObject4 = localObject2;
                if (((String)localObject3).startsWith("http"))
                {
                  ((ArrayList)localObject8).add(localObject3);
                  localObject5 = localObject1;
                  localObject4 = localObject2;
                  if (TextUtils.isEmpty((CharSequence)localObject2))
                  {
                    localObject4 = localObject3;
                    localObject5 = localObject1;
                  }
                }
              }
            }
            do
            {
              localObject1 = localObject5;
              localObject2 = localObject4;
              break;
              localObject5 = localObject1;
              localObject4 = localObject2;
            } while (!QLog.isColorLevel());
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("gotoQfavShareMsg|file path invalid. path=");
            ((StringBuilder)localObject4).append((String)localObject3);
            QLog.e("qqfav", 2, ((StringBuilder)localObject4).toString());
            i += 1;
          }
        }
        else
        {
          localObject2 = null;
          localObject1 = null;
        }
        ((Bundle)localObject7).putString("image_url", (String)localObject1);
        ((Bundle)localObject7).putString("image_url_remote", (String)localObject2);
        ((Bundle)localObject7).putString("title", null);
        ((Bundle)localObject7).putString("desc", null);
        if (1 == ((ArrayList)localObject8).size())
        {
          localObject3 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              ((Bundle)localObject7).putString("image_url", (String)localObject2);
              localObject3 = localObject2;
            }
          }
          if (FileManagerUtil.a((String)localObject3) == 0)
          {
            ((Bundle)localObject7).putInt("req_type", 5);
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131705975));
            ((StringBuilder)localObject1).append(FileManagerUtil.a((String)localObject3));
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131705976));
            ((StringBuilder)localObject1).append(FileUtil.a(FileUtil.a((String)localObject3)));
            ((StringBuilder)localObject1).append("。");
            ((Bundle)localObject7).putString("forward_text", ((StringBuilder)localObject1).toString());
            ((Bundle)localObject7).putBoolean("qdshare_file", true);
            ((Bundle)localObject7).putBoolean("isFromShare", true);
            ((Bundle)localObject7).putBoolean("key_sdk_share_pure_text", true);
            ((Bundle)localObject7).putInt("req_type", 6);
          }
        }
        else if (FileManagerUtil.a((String)localObject1) == 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((ArrayList)localObject8).size());
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131694555));
          ((Bundle)localObject7).putString("title", ((StringBuilder)localObject1).toString());
          ((Bundle)localObject7).putString("qqfav_extra_multi_pic_path_list", str1);
          ((Bundle)localObject7).putBoolean("qqfav_extra_multi_pic", true);
          ((Bundle)localObject7).putInt("req_type", 1);
        }
        else
        {
          l1 = 0L;
          localObject2 = ((ArrayList)localObject8).iterator();
          while (((Iterator)localObject2).hasNext()) {
            l1 += FileUtil.a((String)((Iterator)localObject2).next());
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131705982));
          ((StringBuilder)localObject2).append(FileManagerUtil.a((String)localObject1));
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131705970));
          ((StringBuilder)localObject2).append(((ArrayList)localObject8).size());
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131705983));
          ((StringBuilder)localObject2).append(FileUtil.a(l1));
          ((Bundle)localObject7).putString("forward_text", ((StringBuilder)localObject2).toString());
          ((Bundle)localObject7).putString("qqfav_extra_multi_pic_path_list", str1);
          ((Bundle)localObject7).putBoolean("qdshare_file", true);
          ((Bundle)localObject7).putBoolean("isFromShare", true);
          ((Bundle)localObject7).putBoolean("key_sdk_share_pure_text", true);
          ((Bundle)localObject7).putInt("req_type", 6);
        }
      }
      else
      {
        if (1 != i) {
          break label1786;
        }
      }
    }
    com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.jdField_a_of_type_Boolean = true;
    localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
    ((Bundle)localObject7).putBoolean("MigSdkShareNotDone", true);
    ((Intent)localObject1).putExtras((Bundle)localObject7);
    ((Intent)localObject1).addFlags(268435456);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
    return true;
    return false;
  }
  
  private boolean bq()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" source:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("  serverName:");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("  hostName:");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
      QLog.d("Jumpaction", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_c_of_type_JavaLangString.equals("index"))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
      ((Intent)localObject1).putExtra("goto_type", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.jdField_c_of_type_JavaLangString.equals("detail"))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Common.g());
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append("qapp_center_detail.htm");
        localObject1 = ((StringBuilder)localObject1).toString();
        if (new File((String)localObject1).exists())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("file:///");
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(Common.m());
          ((StringBuilder)localObject1).append(File.separator);
          ((StringBuilder)localObject1).append("qapp_center_detail.htm");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
        localObject3 = new Bundle();
        localObject4 = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("param");
        ((Bundle)localObject3).putString("APP_URL", (String)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("&");
        ((StringBuilder)localObject1).append((String)localObject4);
        ((Bundle)localObject3).putString("APP_PARAMS", ((StringBuilder)localObject1).toString());
        ((Bundle)localObject3).putInt("goto_type", 2);
        ((Intent)localObject2).putExtras((Bundle)localObject3);
        ((Intent)localObject2).putExtra("adapter_action", "action_app_detail");
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        return true;
      }
    }
    else if (this.jdField_c_of_type_JavaLangString.equals("webview"))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("APP_URL", Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("url"));
        ((Bundle)localObject2).putInt("goto_type", 3);
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return true;
      }
    }
    else if ((this.jdField_c_of_type_JavaLangString.equals("local")) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      localObject2 = Uri.parse(this.jdField_a_of_type_JavaLangString);
      localObject1 = ((Uri)localObject2).getQueryParameter("title");
      localObject3 = Common.a(((Uri)localObject2).getQueryParameter("url"));
      if (localObject3.length > 1)
      {
        localObject2 = localObject3[0];
        if ((((String)localObject2).startsWith("file://")) && ((((String)localObject2).contains(Common.g())) || (((String)localObject2).contains("android_asset/Page/system/"))))
        {
          localObject3 = localObject3[1];
          localObject4 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putString("APP_URL", (String)localObject2);
          localObject2 = new ArrayList();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((ArrayList)localObject2).add(localObject1);
          }
          localBundle.putStringArrayList("titleName", (ArrayList)localObject2);
          if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
            localBundle.putString("APP_PARAMS", (String)localObject3);
          }
          localBundle.putInt("goto_type", 4);
          ((Intent)localObject4).putExtras(localBundle);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
        }
      }
    }
    return true;
  }
  
  private boolean br()
  {
    QQProxyForQlink.a(this.jdField_a_of_type_AndroidContentContext, 9, null);
    return true;
  }
  
  private boolean bs()
  {
    return true;
  }
  
  private boolean bt()
  {
    return true;
  }
  
  private boolean bu()
  {
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str1;
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    } else {
      str1 = null;
    }
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    Object localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    try
    {
      localObject1 = URLDecoder.decode((String)localObject1, "UTF-8");
    }
    catch (Exception localException2)
    {
      label114:
      String str4;
      label145:
      break label114;
    }
    localObject1 = "";
    str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("troopbar_id"));
    try
    {
      l = Long.parseLong((String)localObject2);
    }
    catch (Exception localException3)
    {
      long l;
      break label145;
    }
    l = 0L;
    localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("share_from_app", true);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("share_img_list", localObject1);
      localJSONObject.put("share_title", str2);
      localJSONObject.put("share_content", str3);
      localJSONObject.put("share_app_name", str1);
      localJSONObject.put("share_app_id", l);
      ((JSONObject)localObject2).put("share_info", localJSONObject);
      ((JSONObject)localObject2).put("bid", str4);
      return true;
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("gotoTroopBarShareMsg Exception:");
        ((StringBuilder)localObject1).append(localException1.toString());
        QLog.d("JumpAction", 2, ((StringBuilder)localObject1).toString());
      }
      return true;
    }
  }
  
  private boolean bv()
  {
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    SmartDeviceReport.a().a(1);
    SmartDeviceReport.a().jdField_a_of_type_JavaLangString = "";
    SmartDeviceReport.a().jdField_a_of_type_Int = 0;
    SmartDeviceReport.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 2);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      DeviceScanner.openDeviceQCodeUrl((Activity)this.jdField_a_of_type_AndroidContentContext, null, str1);
    }
    return true;
  }
  
  private boolean bw()
  {
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      try
      {
        localObject1 = URLUtil.a((String)localObject1);
        if (((Map)localObject1).get("public_device") != null)
        {
          i = 1;
          localObject2 = URLUtil.b((String)((Map)localObject1).get("args"));
          localObject1 = (String)((Map)localObject2).get("sn");
          localObject2 = (String)((Map)localObject2).get("pid");
          if ((i != 0) && ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))))
          {
            ToastUtil.a().a(this.jdField_a_of_type_AndroidContentContext.getString(2131720191));
            return true;
          }
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, DevicePluginDownloadActivity.class);
          localIntent.putExtra("DevicePID", (String)localObject2);
          localIntent.putExtra("DeviceSN", (String)localObject1);
          localIntent.putExtra("DeviceToken", "");
          localIntent.putExtra("public_device", i);
          localIntent.putExtra("from", "share");
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          return true;
        }
      }
      catch (Exception localException)
      {
        return false;
      }
      int i = 0;
    }
  }
  
  private boolean bx()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JumpAction.gotoSendHongBao(). hong_bao_id=");
      ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_id"));
      ((StringBuilder)localObject).append(", send_uin=");
      ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("send_uin"));
      ((StringBuilder)localObject).append(", hong_bao_type=");
      ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_type"));
      ((StringBuilder)localObject).append(", hong_bao_summary=");
      ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_summary"));
      QLog.d("Q.send_hong_bao", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("hb_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_id"));
    ((Intent)localObject).putExtra("send_uin", (String)this.jdField_a_of_type_JavaUtilHashMap.get("send_uin"));
    ((Intent)localObject).putExtra("hb_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_type"));
    ((Intent)localObject).putExtra("forward_text", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_summary"));
    ((Intent)localObject).putExtra("forward_type", 17);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject);
    return true;
  }
  
  private boolean by()
  {
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("friendUin"));
    localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend((Activity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, "", 3001, 11, "", "", null, "", "");
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject);
    return true;
  }
  
  private boolean bz()
  {
    Object localObject1 = new StringBuilder((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    ((StringBuilder)localObject1).append("?a=1");
    Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str1 = (String)((Iterator)localObject2).next();
      if (!"url".equals(str1))
      {
        try
        {
          String str2 = URLEncoder.encode((String)this.jdField_a_of_type_JavaUtilHashMap.get(str1), "UTF-8");
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append("=");
          ((StringBuilder)localObject1).append(str2);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
        if (QLog.isColorLevel()) {
          QLog.e("JumpAction", 1, localUnsupportedEncodingException, new Object[0]);
        }
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gotoHuayang url==");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.e("JumpAction", 4, ((StringBuilder)localObject2).toString());
    }
    localObject2 = this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent((Context)localObject2, QQBrowserActivity.class);
    localIntent.setFlags(536870912);
    localIntent.putExtra("url", (String)localObject1);
    ((Context)localObject2).startActivity(localIntent);
    return true;
  }
  
  private String c()
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.MODEL;
    String str3 = QQDeviceInfo.getIMEI("0db4c4");
    String str4 = QQDeviceInfo.getIMSI("0db4c4");
    Object localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay();
    int i = ((Display)localObject).getHeight();
    int j = ((Display)localObject).getWidth();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("*");
    ((StringBuilder)localObject).append(i);
    localObject = ((StringBuilder)localObject).toString();
    i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("|");
    localStringBuilder.append(str2);
    localStringBuilder.append("|");
    localStringBuilder.append(str3);
    localStringBuilder.append("|");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("|");
    localStringBuilder.append(str4);
    localStringBuilder.append("|");
    localStringBuilder.append(i);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("params")) {
      try
      {
        JSONObject localJSONObject = new JSONObject(URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("params")));
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("urlParamObj: ");
          localStringBuilder.append(localJSONObject);
          QLog.i("JumpAction", 2, localStringBuilder.toString());
        }
        if (localJSONObject.optInt("view_type", 0) == 0)
        {
          localJSONObject = localJSONObject.optJSONObject("params");
          if (localJSONObject != null)
          {
            ReminderListFragment.a(this.jdField_a_of_type_AndroidContentContext, localJSONObject.optString("notice_time"));
            return;
          }
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("JumpAction parse url throw an exception: ");
          localStringBuilder.append(localException);
          QLog.e("JumpAction", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  private void c(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("thridparty_pull_main", true);
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private boolean c(String paramString)
  {
    if (paramString != null)
    {
      String str3 = "";
      if (!"".equals(paramString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString)) {
          return false;
        }
        if (paramString.length() < 5) {
          return false;
        }
        String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("visitid");
        if (TextUtils.isEmpty(str4)) {
          return false;
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.get("kfuin") != null) {
          localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("kfuin");
        } else {
          localObject = "";
        }
        String str1;
        if (this.jdField_a_of_type_JavaUtilHashMap.get("extuin") != null) {
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extuin");
        } else {
          str1 = "";
        }
        String str2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get("name") != null) {
          str2 = c(((String)this.jdField_a_of_type_JavaUtilHashMap.get("name")).replace(" ", "+"));
        } else {
          str2 = "";
        }
        QidianHandler localQidianHandler = (QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
        if (this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag") != null) {
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag");
        }
        boolean bool;
        if (!TextUtils.isEmpty(str3)) {
          bool = QidianManager.b(Integer.valueOf(str3).intValue());
        } else {
          bool = false;
        }
        localQidianHandler.a(str4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, str1, paramString, bool);
        Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localObject != null) && (((FriendsManager)localObject).b(paramString)) && (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
        {
          localObject = new ProfileCardInfo();
          ((ProfileCardInfo)localObject).allInOne = new AllInOne(paramString, 1);
          ((ProfileCardInfo)localObject).nameArray = new String[8];
          ((ProfileCardInfo)localObject).nameArray[4] = str2;
          ProfileBottomContainer.enterChat(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (QBaseActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileCardInfo)localObject);
          return true;
        }
        paramString = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_AndroidContentContext, 1, paramString, null, 3999, 0, str2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131690706), null);
        paramString.putExtra("webImVisitId", str4);
        paramString.putExtra("webim_qd_ext", true);
        if (BaseActivity.sTopActivity == null) {
          paramString.putExtra("need_jumpto_splash", true);
        }
        ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_AndroidContentContext, paramString);
        return true;
      }
    }
    return false;
  }
  
  private String d(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("request_from");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("mqzone://arouse/normalvideolayer")) && (TextUtils.equals(d(paramString), "6"));
  }
  
  private Intent e(Intent paramIntent)
  {
    boolean bool = TextUtils.isEmpty((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api")) ^ true;
    SLog.a("JumpAction", "makeStoryJumpActivity() action=%s isFromApi=%s", this.jdField_c_of_type_JavaLangString, Boolean.valueOf(bool));
    SLog.a("JumpAction", "makeStoryJumpActivity() attr=%s", String.valueOf(this.jdField_a_of_type_JavaUtilHashMap));
    if ("open".equals(this.jdField_c_of_type_JavaLangString))
    {
      paramIntent.putExtra("redid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("redid"));
      paramIntent.putExtra("lebaVersion", (String)this.jdField_a_of_type_JavaUtilHashMap.get("lebaVersion"));
      if (bool) {
        StoryReportor.a("basic", "use_api", 0, 0, new String[] { "1", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
      }
      return paramIntent;
    }
    Object localObject1;
    Object localObject2;
    String str3;
    String str2;
    if ((!"openVideo".equals(this.jdField_c_of_type_JavaLangString)) && (!"openvideo".equals(this.jdField_c_of_type_JavaLangString)))
    {
      String str1;
      if ("opencontent".equals(this.jdField_c_of_type_JavaLangString))
      {
        if (bool)
        {
          localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("unionId=");
            ((StringBuilder)localObject2).append(str3);
            ((StringBuilder)localObject2).append("&userId=");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("&userType=");
            ((StringBuilder)localObject2).append(str1);
            localObject1 = ((StringBuilder)localObject2).toString();
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("storyId=");
            ((StringBuilder)localObject1).append((String)localObject2);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          StoryReportor.a("basic", "use_api", 0, 0, new String[] { "4", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", localObject1 });
        }
        return d(paramIntent);
      }
      if ("opentopic".equals(this.jdField_c_of_type_JavaLangString))
      {
        if (bool)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("topicId=");
          ((StringBuilder)localObject1).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid"));
          localObject1 = ((StringBuilder)localObject1).toString();
          StoryReportor.a("basic", "use_api", 0, 0, new String[] { "5", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", localObject1 });
        }
        return b(paramIntent);
      }
      if ("opendiscovery".equals(this.jdField_c_of_type_JavaLangString))
      {
        if (bool) {
          StoryReportor.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
        }
        return c(paramIntent);
      }
      if ("publish".equals(this.jdField_c_of_type_JavaLangString))
      {
        if (bool) {
          StoryReportor.a("basic", "use_api", 0, 0, new String[] { "2", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
        }
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("capture_mode");
        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tab_id");
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("category_id");
        String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("item_id");
        String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("album_id");
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page");
        String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("dispatch_event");
        paramIntent.putExtra("cameraDirection", 2);
        if (!TextUtils.isEmpty(str6)) {
          paramIntent.putExtra("web_dispatch_event", str6);
        }
        try
        {
          if (!TextUtils.isEmpty(str5)) {
            paramIntent.putExtra("key_finish_jump_to_page", Integer.valueOf(str5));
          }
          if (!TextUtils.isEmpty(str1)) {
            paramIntent.putExtra("capture_intent_mode", Integer.valueOf(str1));
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramIntent.putExtra("firsttab", Integer.valueOf((String)localObject2));
          }
          if (!TextUtils.isEmpty(str3)) {
            paramIntent.putExtra("secondtab", Integer.valueOf(str3));
          }
          paramIntent.putExtra("itemid", str4);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("start story publish, NumberFormatException, attrs=");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilHashMap.toString());
          ((StringBuilder)localObject2).append("\n");
          ((StringBuilder)localObject2).append(localNumberFormatException);
          QLog.e("Q.qqstory.publish.JumpAction", 2, ((StringBuilder)localObject2).toString());
        }
        paramIntent.putExtra("from_type", (String)localObject1);
        paramIntent.putExtra("action", 1);
        return paramIntent;
      }
      if ("infoCard".equals(this.jdField_c_of_type_JavaLangString))
      {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromId");
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
        if ((!TextUtils.isEmpty(str2)) && ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty(str3)))) {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            return null;
          }
        }
      }
    }
    try
    {
      paramIntent.putExtra("union_id", str3);
      paramIntent.putExtra("qq_number", Long.valueOf((String)localObject1));
      paramIntent.putExtra("source", Integer.valueOf((String)localObject2));
      paramIntent.putExtra("action", 11);
      return paramIntent;
    }
    catch (NumberFormatException paramIntent)
    {
      return null;
    }
    return null;
    if ("sharegroupcard".equals(this.jdField_c_of_type_JavaLangString))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromId");
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromuid");
    }
    try
    {
      paramIntent.putExtra("union_id", (String)localObject1);
      paramIntent.putExtra("extra_share_from_uid", (String)localObject2);
      paramIntent.putExtra("source", Integer.valueOf(str2));
      paramIntent.putExtra("action", 13);
      return paramIntent;
    }
    catch (NumberFormatException paramIntent) {}
    if ("openTag".equals(this.jdField_c_of_type_JavaLangString))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag_id");
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag_type");
      paramIntent.putExtra("action", 14);
      paramIntent.putExtra("tag_id", (String)localObject1);
      paramIntent.putExtra("tag_type", str2);
      return paramIntent;
    }
    if ("openSquare".equals(this.jdField_c_of_type_JavaLangString))
    {
      paramIntent.putExtra("action", 15);
      return paramIntent;
    }
    return null;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("userId=");
      ((StringBuilder)localObject1).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoOwnerUin"));
      ((StringBuilder)localObject1).append("&vid=");
      ((StringBuilder)localObject1).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoId"));
      localObject1 = ((StringBuilder)localObject1).toString();
      StoryReportor.a("basic", "use_api", 0, 0, new String[] { "6", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", localObject1 });
    }
    return a(paramIntent);
    return null;
  }
  
  private String e(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("i=")))
    {
      int k = paramString.indexOf("i=");
      int j = paramString.substring(k).indexOf('&');
      int i = j;
      if (j <= 0) {
        i = paramString.length() - k;
      }
      return paramString.substring(k + 2, k + i);
    }
    return null;
  }
  
  private boolean e(String paramString)
  {
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_uri"));
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_uri"));
    }
    if (!TextUtils.isEmpty(str1))
    {
      this.f = false;
      ThreadManagerV2.executeOnSubThread(new JumpActionLegacy.22(this, str1, paramString));
      return false;
    }
    return a(paramString, true);
  }
  
  private String f(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("urlDecode imageUri=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("JumpAction", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = URLDecoder.decode(paramString, "UTF-8");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      QLog.e("JumpAction", 1, "UnsupportedEncodingException", localUnsupportedEncodingException);
    }
    return URLDecoder.decode(paramString);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("scheme")) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msgid")) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("busiid")))
    {
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("msgid");
      String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("busiid");
      String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("scheme");
      String str1;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("domain")) {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("domain");
      } else {
        str1 = "";
      }
      QQNotifySettingFragment.a(this.jdField_a_of_type_AndroidContentContext, str2, str3, str4, str1);
    }
  }
  
  private String g(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("urlEncode filePath=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("JumpAction", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = URLEncoder.encode(paramString, "UTF-8");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      QLog.e("JumpAction", 1, "UnsupportedEncodingException", localUnsupportedEncodingException);
    }
    return URLEncoder.encode(paramString);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msgid"))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("msgid");
      QQReminderJumpFragment.a(this.jdField_a_of_type_AndroidContentContext, str);
    }
  }
  
  private void g(String paramString)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    if ("app".equals(str))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
      return;
    }
    if ("web".equals(str))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
      return;
    }
    if ("scan".equals(str)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
    }
  }
  
  private void h()
  {
    AllInOne localAllInOne = new AllInOne((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), 111);
    if ("1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("source"))) {
      localAllInOne.profileEntryType = 118;
    } else if ("2".equals(this.jdField_a_of_type_JavaUtilHashMap.get("source"))) {
      localAllInOne.profileEntryType = 121;
    }
    ProfileUtils.openProfileCard(this.jdField_a_of_type_AndroidContentContext, localAllInOne);
  }
  
  private void h(String paramString)
  {
    if ((paramString.equals(GameCenterActivity.class.getName())) || (paramString.equals(((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountBrowser.class))) || (paramString.equals(CouponActivity.class.getName()))) {
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).preloadQWallet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void i()
  {
    String str = b("buddyuin");
    if (!str.isEmpty())
    {
      long l = Long.parseLong(str);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("grayTip,openTroopWithCommonFriendsFragment:");
        localStringBuilder.append(l);
        QLog.d("JumpAction", 2, localStringBuilder.toString());
      }
      TroopWithCommonFriendsFragment.a(str);
      TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_AndroidContentContext, 1);
      ReportController.b(null, "dc00898", "", "", "0X800AD20", "0X800AD20", 0, 0, "0", "0", "", "");
    }
  }
  
  private void j()
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("fromTranslucent", 1);
    try
    {
      long l1 = Long.parseLong(b("uin"));
      int i = Integer.parseInt(b("appid"));
      Object localObject2 = b("cellid");
      Object localObject3 = b("subid");
      long l2 = Long.parseLong(b("time"));
      ((Bundle)localObject1).putLong("targetuin", Long.valueOf(l1).longValue());
      ((Bundle)localObject1).putInt("appid", i);
      ((Bundle)localObject1).putString("cellid", (String)localObject2);
      ((Bundle)localObject1).putString("subid", (String)localObject3);
      ((Bundle)localObject1).putLong("feedtime", l2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject2, "com.qzone.detail.ui.activity.StickyNoteDetailActivity");
      if ((this.jdField_a_of_type_AndroidContentContext instanceof QBaseActivity))
      {
        localObject3 = (QBaseActivity)this.jdField_a_of_type_AndroidContentContext;
        localObject1 = null;
        if (((QBaseActivity)localObject3).getAppRuntime() != null) {
          localObject1 = ((QBaseActivity)localObject3).getAppRuntime().getCurrentUin();
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("action_open_sticky_note_feed_detail  error! get currentUin failed! ");
          ((StringBuilder)localObject1).append(((QBaseActivity)localObject3).getAppRuntime());
          QLog.e("JumpAction", 1, ((StringBuilder)localObject1).toString());
          return;
        }
        QzonePluginProxyActivity.launchPluingActivityForResult((Activity)localObject3, (String)localObject1, (Intent)localObject2, 7, true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpAction", 1, "action_open_sticky_note_feed_detail  error!", localThrowable);
    }
  }
  
  private void k()
  {
    Intent localIntent = QZoneHelper.getQzoneVerticalVideoDownloadActivityIntent(BaseApplicationImpl.getContext());
    localIntent.putExtra("key_plugin_id", "qzone_weishi_feeds_plugin.apk");
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  private void l()
  {
    if ((this.jdField_c_of_type_JavaLangString != null) && ((this.jdField_c_of_type_JavaLangString.equals("forward_msg_list")) || (this.jdField_c_of_type_JavaLangString.equals("open_conversation"))))
    {
      int i = FrameControllerUtil.jdField_a_of_type_Int;
      Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("third_open_conversation_sceneid");
      try
      {
        long l = Long.parseLong((String)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(l);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800A5AF", "0X800A5AF", 0, 0, localStringBuilder.toString(), "", "", "");
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sceneid must be a numeric string, errorMsg: ");
        localStringBuilder.append(localException.toString());
        QLog.e("JumpAction", 1, localStringBuilder.toString());
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      ((Intent)localObject2).setFlags(335544320);
      ((Intent)localObject2).putExtra("tab_index", i);
      ((Intent)localObject2).putExtra("fragment_id", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("action_name doesnt match: ");
    ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
    QLog.e("JumpAction", 1, ((StringBuilder)localObject2).toString());
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131692801, this.jdField_a_of_type_AndroidContentContext.getString(2131692783), 2131692785, 2131692784, new JumpActionLegacy.10(this), new JumpActionLegacy.11(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void n()
  {
    boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("packageName");
    String str5 = "";
    if (bool) {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("packageName");
    } else {
      localObject = "";
    }
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("signareMode")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("signareMode");
    } else {
      str1 = "";
    }
    String str2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    } else {
      str2 = "";
    }
    String str3;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("timeStamp")) {
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("timeStamp");
    } else {
      str3 = "";
    }
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("resetWordMode")) {
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("resetWordMode");
    } else {
      str4 = "";
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("offerid")) {
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("offerid");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("packageName : ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" signatureMode :");
      localStringBuilder.append(str1);
      localStringBuilder.append(" appid : ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" timestamp : ");
      localStringBuilder.append(str3);
      localStringBuilder.append(" resetWordMode : ");
      localStringBuilder.append(str4);
      localStringBuilder.append(" offerId : ");
      localStringBuilder.append(str5);
      QLog.d("JumpAction", 2, localStringBuilder.toString());
    }
    Object localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
    ((QWalletAuthHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).a((ReqCheckChangePwdAuth)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy$QWalletAuthMsgHandler = new JumpActionLegacy.QWalletAuthMsgHandler(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = new QWalletAuthObserver(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy$QWalletAuthMsgHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
  }
  
  private void o()
  {
    com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.jdField_a_of_type_Boolean = true;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localJSONObject.put("viewTag", "pswManage");
        if (!PayBridgeActivity.tenpay((Activity)this.jdField_a_of_type_AndroidContentContext, localJSONObject.toString(), 5, ""))
        {
          i = 1;
          b(i);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        b(1);
        return;
      }
      int i = 0;
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
      ((JumpActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
  
  private void q()
  {
    try
    {
      Object localObject;
      if ("head".equals(this.jdField_c_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy$CustomHeadObserver == null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy$CustomHeadObserver = new JumpActionLegacy.CustomHeadObserver(this, this);
        }
        if (this.jdField_a_of_type_JavaUtilHashtable == null) {
          this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy$CustomHeadObserver);
        long l = System.currentTimeMillis();
        String[] arrayOfString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).split(",");
        localObject = (IQQAvatarHandlerService)a().getRuntimeService(IQQAvatarHandlerService.class, "");
        int i = 0;
        while (i < arrayOfString.length)
        {
          String str = arrayOfString[i];
          ((IQQAvatarHandlerService)localObject).getCustomHead(str);
          this.jdField_a_of_type_JavaUtilHashtable.put(str, Long.valueOf(l));
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMQQService error ");
        ((StringBuilder)localObject).append(localException.toString());
        QLog.w("JumpAction", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void r()
  {
    if ((!this.f) && (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isSharingMiniProgram(this.jdField_a_of_type_JavaUtilHashMap)) && ((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
      ((JumpActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
    if (((this.jdField_a_of_type_AndroidContentContext instanceof GesturePWDUnlockActivity)) && (this.jdField_g_of_type_Boolean)) {
      ((GesturePWDUnlockActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
  
  private boolean y()
  {
    int i;
    try
    {
      i = Integer.parseInt(this.jdField_c_of_type_JavaLangString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleQfavHelperAction error:");
      localStringBuilder.append(localNumberFormatException.getMessage());
      QLog.e("JumpAction", 1, localStringBuilder.toString());
      i = -1;
    }
    if (i != 2) {
      return true;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690706));
    return QfavHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, -1, false);
  }
  
  private boolean z()
  {
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    if ((!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"), "");
      ((IIdentificationApi)QRoute.api(IIdentificationApi.class)).preResDownload();
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    QLog.e("JumpAction", 1, "identification with illegal params");
    return true;
  }
  
  public Intent a(Intent paramIntent)
  {
    paramIntent.putExtra("action", 5);
    paramIntent.putExtra("extra_jump_attrs", this.jdField_a_of_type_JavaUtilHashMap);
    return paramIntent;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  protected ILoginRegisterApi a()
  {
    return (ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class);
  }
  
  public void a()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    if ((!((JumpActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_b_of_type_JavaLangString.equals("card")) && (this.jdField_c_of_type_JavaLangString.equals("show_pslcard")) && (QSecFramework.a().a(1003).booleanValue())) {
      SecShareInfoUtil.a().a(paramActivity, null);
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
  }
  
  public boolean a()
  {
    try
    {
      if ("com.qqfav".equals(this.jdField_b_of_type_JavaLangString)) {
        return y();
      }
      if (("urlopen".equals(this.jdField_b_of_type_JavaLangString)) && ("pay".equals(this.jdField_c_of_type_JavaLangString))) {
        b();
      }
      if (("qqidentifier".equals(this.jdField_b_of_type_JavaLangString)) && ("web".equals(this.jdField_c_of_type_JavaLangString))) {
        return z();
      }
      if ("qsubscribe".equals(this.jdField_b_of_type_JavaLangString))
      {
        SubscribeLaucher.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap);
        return true;
      }
      if ("qcircle".equals(this.jdField_b_of_type_JavaLangString))
      {
        QCircleUtils.a().enterBySchemeAction(this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap);
        return true;
      }
      if ("videostory".equals(this.jdField_b_of_type_JavaLangString)) {
        return I();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("manage_troop")) && (this.jdField_c_of_type_JavaLangString.equals("main_page"))) {
        return bO();
      }
      boolean bool = "microapp".equals(this.jdField_b_of_type_JavaLangString);
      if ((bool) && ("open".equals(this.jdField_c_of_type_JavaLangString))) {
        return A();
      }
      if (("miniapp".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString))) {
        return ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 2016, null);
      }
      if (("miniapp".equals(this.jdField_b_of_type_JavaLangString)) && ("notifyclose".equals(this.jdField_c_of_type_JavaLangString))) {
        return B();
      }
      bool = "wallet".equals(this.jdField_b_of_type_JavaLangString);
      if ((bool) && ("open".equals(this.jdField_c_of_type_JavaLangString)) && ("0".equals(this.jdField_a_of_type_JavaUtilHashMap.get("viewtype"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"))) && ((this.jdField_a_of_type_JavaUtilHashMap.get("view") == null) || ("0".equals(this.jdField_a_of_type_JavaUtilHashMap.get("view"))))) {
        return an();
      }
      if (("wallet".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString)) && ("0".equals(this.jdField_a_of_type_JavaUtilHashMap.get("viewtype"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("src_type")))) {
        return C();
      }
      if (("wxminiapp".equals(this.jdField_b_of_type_JavaLangString)) && ("launch".equals(this.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("user_name")) && (!StringUtil.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("user_name")))) {
        return J();
      }
      if ("qqnotify".equals(this.jdField_b_of_type_JavaLangString)) {
        if ("open".equals(this.jdField_c_of_type_JavaLangString)) {
          c();
        } else if ("subscribe".equals(this.jdField_c_of_type_JavaLangString)) {
          f();
        } else if ("jump".equals(this.jdField_c_of_type_JavaLangString)) {
          g();
        }
      }
      Object localObject1;
      if (("qqnotify".equals(this.jdField_b_of_type_JavaLangString)) && ("birth".equals(this.jdField_c_of_type_JavaLangString)))
      {
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, ActivateFriendActivity.class);
        ((Intent)localObject1).putExtra("af_key_from", 2);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      }
      if (this.jdField_b_of_type_JavaLangString.equals("ftssearch"))
      {
        if (this.jdField_c_of_type_JavaLangString.equals("tab")) {
          return K();
        }
        if (this.jdField_c_of_type_JavaLangString.equals("openmixweb")) {
          return j();
        }
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("wpa")) && (this.jdField_c_of_type_JavaLangString.equals("openid_to_uin"))) {
        return ao();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.jdField_c_of_type_JavaLangString.equals("chat"))) {
        return aq();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("wsgzh")) && (this.jdField_c_of_type_JavaLangString.equals("waterfall")))
      {
        ((IWSManager)QRoute.api(IWSManager.class)).enterWSPublicAccount(this.jdField_a_of_type_AndroidContentContext, "from_search_rzh_ws", false);
        return true;
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("wsgzh")) && (this.jdField_c_of_type_JavaLangString.equals("miniapp_player")) && ("openPlayer".equals(this.jdField_a_of_type_JavaUtilHashMap.get("action")))) {
        return ((IWSManager)QRoute.api(IWSManager.class)).enterWSVerticalPlayerPageForMiniApp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("wsgzh")) && (this.jdField_c_of_type_JavaLangString.equals("wesee")) && ("operationh5".equals(this.jdField_a_of_type_JavaUtilHashMap.get("action")))) {
        return ((IWSManager)QRoute.api(IWSManager.class)).enterWSOperationH5(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("asyncmsg")) && (this.jdField_c_of_type_JavaLangString.equals("open_async_detail"))) {
        return bs();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("connect_miniapp")) && (this.jdField_c_of_type_JavaLangString.equals("launch"))) {
        return ap();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.jdField_c_of_type_JavaLangString.equals("aioorprofile"))) {
        return av();
      }
      if (this.jdField_b_of_type_JavaLangString.equals("qapp")) {
        return bq();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.jdField_c_of_type_JavaLangString.equals("show_nearby_fri"))) {
        return aw();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.jdField_c_of_type_JavaLangString.equals("show_location"))) {
        return az();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.jdField_c_of_type_JavaLangString.equals("select_location"))) {
        return aA();
      }
      if (("card".equals(this.jdField_b_of_type_JavaLangString)) && ("show_pslcard".equals(this.jdField_c_of_type_JavaLangString))) {
        return aB();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("personal_tag")) && (this.jdField_c_of_type_JavaLangString.equals("tag_list"))) {
        return aH();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("upload")) && (this.jdField_c_of_type_JavaLangString.equals("photo"))) {
        return aQ();
      }
      bool = this.jdField_b_of_type_JavaLangString.equals("forward");
      if ((bool) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
        return aS();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("forward")) && (this.jdField_c_of_type_JavaLangString.equals("invite_register"))) {
        return bE();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("gamesdk")) && (this.jdField_c_of_type_JavaLangString.equals("bind_group"))) {
        return aR();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_fri"))) {
        return aT();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_qqdataline"))) {
        return a(new JumpActionLegacy.1(this));
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("gamesdk")) && (this.jdField_c_of_type_JavaLangString.equals("add_friend")))
      {
        if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"))) {
          n = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
        }
        return aV();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_qqfav"))) {
        return a(new JumpActionLegacy.2(this));
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_qzone"))) {
        return e("shareToQzone");
      }
      if (this.jdField_b_of_type_JavaLangString.equals("qzone")) {
        return D();
      }
      bool = this.jdField_b_of_type_JavaLangString.equals("mqq");
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleMQQService");
        }
        q();
      }
      else
      {
        if ((this.jdField_b_of_type_JavaLangString.equals("groupopenapp")) && (this.jdField_c_of_type_JavaLangString.equals("openapp"))) {
          return bL();
        }
        if ((this.jdField_b_of_type_JavaLangString.equals("lightapp")) && (this.jdField_c_of_type_JavaLangString.equals("open"))) {
          return bM();
        }
        if (this.jdField_b_of_type_JavaLangString.endsWith("app"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "handleAppForward");
          }
          return bo();
        }
        if ((this.jdField_b_of_type_JavaLangString.equals("qm")) && (this.jdField_c_of_type_JavaLangString.equals("qr"))) {
          return E();
        }
        if ((this.jdField_b_of_type_JavaLangString.equals("dc")) && (this.jdField_c_of_type_JavaLangString.equals("ft"))) {
          return bi();
        }
        if ("group".equals(this.jdField_b_of_type_JavaLangString))
        {
          if (this.jdField_c_of_type_JavaLangString.equals("nearby")) {
            return ax();
          }
          if (this.jdField_c_of_type_JavaLangString.equals("create")) {
            return ay();
          }
          if (this.jdField_c_of_type_JavaLangString.equals("report")) {
            return bG();
          }
        }
        else
        {
          if (this.jdField_b_of_type_JavaLangString.equals("shop")) {
            return F();
          }
          if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.jdField_c_of_type_JavaLangString.equals("game_invite")))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[cmshow.game_invite], source:");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
            QLog.i("JumpAction", 1, ((StringBuilder)localObject1).toString());
            return true;
          }
          if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("avatar_edit".equals(this.jdField_c_of_type_JavaLangString))) {
            return ac();
          }
          if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_avatar_edit".equals(this.jdField_c_of_type_JavaLangString))) {
            return ae();
          }
          if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_dynamic_avatar_edit".equals(this.jdField_c_of_type_JavaLangString))) {
            return af();
          }
          if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_face_collection".equals(this.jdField_c_of_type_JavaLangString))) {
            return ad();
          }
          if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("more_info_edit".equals(this.jdField_c_of_type_JavaLangString)))
          {
            localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, FriendProfileMoreInfoActivity.class);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          }
          else if (("userprofile".equals(this.jdField_b_of_type_JavaLangString)) && ("friend_profile_card".equals(this.jdField_c_of_type_JavaLangString)))
          {
            h();
          }
          else
          {
            if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("might_know".equals(this.jdField_c_of_type_JavaLangString))) {
              return ag();
            }
            if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("search_might_know".equals(this.jdField_c_of_type_JavaLangString))) {
              return ah();
            }
            if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("new_friends".equals(this.jdField_c_of_type_JavaLangString))) {
              return ai();
            }
            if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("contacts_tab".equals(this.jdField_c_of_type_JavaLangString))) {
              return aj();
            }
            if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("phone_recommend".equals(this.jdField_c_of_type_JavaLangString))) {
              return ak();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("healthcenter")) && (this.jdField_c_of_type_JavaLangString.equals("open"))) {
              return G();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("ptlogin")) && (this.jdField_c_of_type_JavaLangString.equals("qlogin"))) {
              return bj();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("gav")) && (this.jdField_c_of_type_JavaLangString.equals("request"))) {
              return bk();
            }
            if (("videochat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.jdField_c_of_type_JavaLangString))) {
              return bl();
            }
            if (("randomavchat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.jdField_c_of_type_JavaLangString))) {
              return bm();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("tribe")) {
              return H();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qqdataline")) && (this.jdField_c_of_type_JavaLangString.equals("openqqdataline"))) {
              return am();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("wallet")) && (this.jdField_c_of_type_JavaLangString.equals("modify_pass"))) {
              return al();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("dating"))
            {
              if (this.jdField_c_of_type_JavaLangString.equals("detail")) {
                return ab();
              }
              if (this.jdField_c_of_type_JavaLangString.equals("publish")) {
                return aa();
              }
              if (this.jdField_c_of_type_JavaLangString.equals("feed")) {
                return Z();
              }
            }
            else if (this.jdField_b_of_type_JavaLangString.equals("nearby_entry"))
            {
              if (this.jdField_c_of_type_JavaLangString.equals("nearby_feed")) {
                return U();
              }
              if (this.jdField_c_of_type_JavaLangString.equals("nearby_profile")) {
                return aC();
              }
              if (this.jdField_c_of_type_JavaLangString.equals("hotchat_list")) {
                return W();
              }
              if (this.jdField_c_of_type_JavaLangString.equals("hotchat_room")) {
                return X();
              }
              if (this.jdField_c_of_type_JavaLangString.equals("visitor_list")) {
                return r();
              }
            }
            else if (this.jdField_b_of_type_JavaLangString.equals("nearby"))
            {
              if (this.jdField_c_of_type_JavaLangString.equals("reportFriend")) {
                return bH();
              }
            }
            else if (this.jdField_b_of_type_JavaLangString.equals("hotchat"))
            {
              if (this.jdField_c_of_type_JavaLangString.equals("newyear_scene")) {
                return Y();
              }
            }
            else
            {
              if (this.jdField_b_of_type_JavaLangString.equals("freshnews_entry")) {
                return false;
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qlink")) && (this.jdField_c_of_type_JavaLangString.equals("openqlink"))) {
                return br();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_troopbar"))) {
                return a(new JumpActionLegacy.3(this));
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qqconnect")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
                return bv();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("publicdevice")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
                return bw();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("openLightApp")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
                return k();
              }
              if (("tenpay".equals(this.jdField_b_of_type_JavaLangString)) && ("sendHongBao".equals(this.jdField_c_of_type_JavaLangString))) {
                return bx();
              }
              if (("massbless".endsWith(this.jdField_b_of_type_JavaLangString)) && ("mainpage".equals(this.jdField_c_of_type_JavaLangString))) {
                return l();
              }
              if (this.jdField_b_of_type_JavaLangString.equals("interesttag")) {
                return T();
              }
              if (this.jdField_b_of_type_JavaLangString.equals("qqcomic")) {
                return bn();
              }
              if (("leba_plugin".equals(this.jdField_b_of_type_JavaLangString)) && ("set".equals(this.jdField_c_of_type_JavaLangString))) {
                return m();
              }
              if (this.jdField_b_of_type_JavaLangString.equals("pa_relationship")) {
                return n();
              }
              if (this.jdField_b_of_type_JavaLangString.equals("od")) {
                return o();
              }
              if (this.jdField_b_of_type_JavaLangString.equals("odAddFriend")) {
                return by();
              }
              if ("huayang".equals(this.jdField_b_of_type_JavaLangString)) {
                return bz();
              }
              if (this.jdField_b_of_type_JavaLangString.equals("readinjoy")) {
                return ((IRIJJumpAction)QRoute.api(IRIJJumpAction.class)).handleServerReadInJoy(this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.jdField_c_of_type_JavaLangString.equals("apollo_action")))
              {
                if (((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(this.jdField_a_of_type_AndroidContentContext)) {
                  return q();
                }
              }
              else if ((!this.jdField_b_of_type_JavaLangString.equals("cmshow")) || (!this.jdField_c_of_type_JavaLangString.equals("open_game"))) {
                if ("favorites".equals(this.jdField_b_of_type_JavaLangString))
                {
                  if ("forward_favorites".equals(this.jdField_c_of_type_JavaLangString))
                  {
                    localObject1 = new Intent();
                    ((Intent)localObject1).putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690706));
                    return QfavHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, -1, false);
                  }
                }
                else if ("hongbao_share".equals(this.jdField_b_of_type_JavaLangString))
                {
                  if ("hongbao_brush".equals(this.jdField_c_of_type_JavaLangString)) {
                    return Q();
                  }
                }
                else if ("general_ar".equals(this.jdField_b_of_type_JavaLangString))
                {
                  if ("gotoScannerTorchActivity".equals(this.jdField_c_of_type_JavaLangString)) {
                    return R();
                  }
                }
                else
                {
                  if ("mqqavshare://".equals(this.jdField_b_of_type_JavaLangString))
                  {
                    this.jdField_j_of_type_Boolean = true;
                    return ((IShareChatApi)QRoute.api(IShareChatApi.class)).jump(this);
                  }
                  if ("assistant_setting".equals(this.jdField_b_of_type_JavaLangString))
                  {
                    if ("ASSISTANT_SETTING".equals(this.jdField_c_of_type_JavaLangString)) {
                      return p();
                    }
                  }
                  else if ((!this.jdField_b_of_type_JavaLangString.equals("conf")) && (!this.jdField_b_of_type_JavaLangString.equals("confpstn")) && (!this.jdField_b_of_type_JavaLangString.equals("confhr")))
                  {
                    if ("teamwork".equals(this.jdField_b_of_type_JavaLangString))
                    {
                      if ("opendoclist".equals(this.jdField_c_of_type_JavaLangString)) {
                        return P();
                      }
                    }
                    else
                    {
                      if ("qstory".equals(this.jdField_b_of_type_JavaLangString))
                      {
                        if ("openNow".equals(this.jdField_c_of_type_JavaLangString)) {
                          return u();
                        }
                        return N();
                      }
                      if (("now".equals(this.jdField_b_of_type_JavaLangString)) || ("ilive".equals(this.jdField_b_of_type_JavaLangString)))
                      {
                        if ("openroom".equals(this.jdField_c_of_type_JavaLangString)) {
                          return u();
                        }
                        if ("prelogin".equals(this.jdField_c_of_type_JavaLangString)) {
                          return t();
                        }
                        if ("playmedia".equals(this.jdField_c_of_type_JavaLangString)) {
                          return c();
                        }
                      }
                    }
                  }
                  else if (this.jdField_c_of_type_JavaLangString.equals("ft")) {
                    return s();
                  }
                }
              }
            }
          }
        }
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("schedule")) && (this.jdField_c_of_type_JavaLangString.equals("showDetail"))) {
        return bt();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("contact")) && (this.jdField_c_of_type_JavaLangString.equals("add"))) {
        return v();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("profile")) && (this.jdField_c_of_type_JavaLangString.equals("setting"))) {
        return w();
      }
      if (this.jdField_b_of_type_JavaLangString.equals("qqreg")) {
        return bF();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("troop_member_card")) && (this.jdField_c_of_type_JavaLangString.equals("open_member_recent_chat_view"))) {
        return V();
      }
      if (this.jdField_b_of_type_JavaLangString.equals("qwerewolf"))
      {
        if (this.jdField_c_of_type_JavaLangString.equals("openInvitationRoom")) {
          return L();
        }
        if (this.jdField_c_of_type_JavaLangString.equals("enterGameRoom")) {
          return M();
        }
      }
      else if (this.jdField_b_of_type_JavaLangString.equals("groupvideo"))
      {
        if (this.jdField_c_of_type_JavaLangString.equals("openroom")) {
          return bI();
        }
        if (this.jdField_c_of_type_JavaLangString.equals("preload")) {
          return bJ();
        }
      }
      else
      {
        if (this.jdField_b_of_type_JavaLangString.equals("studyroom")) {
          return bK();
        }
        if (this.jdField_b_of_type_JavaLangString.equals("invite_join_group"))
        {
          if (this.jdField_c_of_type_JavaLangString.equals("open")) {
            return x();
          }
        }
        else
        {
          if (("troop_homework".equals(this.jdField_b_of_type_JavaLangString)) && ("publish".equals(this.jdField_c_of_type_JavaLangString))) {
            return b(b("gc"));
          }
          if ((this.jdField_b_of_type_JavaLangString.equals("nearby_videochat")) && (this.jdField_c_of_type_JavaLangString.equals("open_plugin")))
          {
            if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
            {
              localObject1 = (NearbyVideoChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
              NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, null, ((NearbyVideoChatManager)localObject1).a(), null, 123987);
              return true;
            }
            QLog.i("JumpAction", 1, "openNearbyVideoChatActivity, context is not a activity");
            return false;
          }
          if ("weishitab".equals(this.jdField_b_of_type_JavaLangString))
          {
            if ("open".equals(this.jdField_c_of_type_JavaLangString))
            {
              k();
              return false;
            }
          }
          else
          {
            if ("page_router".equals(this.jdField_b_of_type_JavaLangString))
            {
              l();
              return true;
            }
            if ("msg_list".equals(this.jdField_b_of_type_JavaLangString))
            {
              l();
              return true;
            }
            if ("watchtogether".equals(this.jdField_b_of_type_JavaLangString))
            {
              if (this.jdField_c_of_type_JavaLangString.equals("openroom")) {
                return bN();
              }
            }
            else
            {
              if ("share_group".equals(this.jdField_b_of_type_JavaLangString))
              {
                if (!this.jdField_c_of_type_JavaLangString.equals("open")) {
                  break label5035;
                }
                localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
                if (localObject1 == null) {
                  break label5035;
                }
                TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1);
                return true;
              }
              if ("edit_group".equals(this.jdField_b_of_type_JavaLangString))
              {
                if (!this.jdField_c_of_type_JavaLangString.equals("open")) {
                  break label5037;
                }
                localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
                if (localObject1 == null) {
                  break label5037;
                }
                TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1);
                return true;
              }
              if ("weishiforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                ((IWSManager)QRoute.api(IWSManager.class)).enterWSPublicAccount(this.jdField_a_of_type_AndroidContentContext, "from_audio_assistant", true);
                return true;
              }
              if ("nearbyforqassistant".equals(this.jdField_b_of_type_JavaLangString)) {
                return U();
              }
              if ("qechatforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                ((IExpandEntrance)QRoute.api(IExpandEntrance.class)).enterExpand(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7);
                return true;
              }
              if ("searchforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                localObject1 = b("searchkey");
                UniteSearchActivity.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, 10004);
                return true;
              }
              if ("settingsforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQSettingSettingActivity.class);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                return true;
              }
              if ("confiessmsgforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                ConfessConfig localConfessConfig = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
                localObject2 = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
                localObject1 = localObject2;
                if (localConfessConfig != null)
                {
                  localObject1 = localObject2;
                  if (!TextUtils.isEmpty(localConfessConfig.l)) {
                    localObject1 = localConfessConfig.l;
                  }
                }
                localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                ((Intent)localObject2).putExtra("url", (String)localObject1);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
                return true;
              }
              if ("qzoneforqassistant".equals(this.jdField_b_of_type_JavaLangString)) {
                return i_();
              }
              if ("weqzoneforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                localObject1 = new HashMap();
                ((HashMap)localObject1).put("key_enable_splash", "0");
                QCircleUtils.a().enterBySchemeAction(this.jdField_a_of_type_AndroidContentContext, "openfolder", (HashMap)localObject1);
                return true;
              }
              if ("scanforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                if (!(this.jdField_a_of_type_AndroidContentContext instanceof QBaseActivity)) {
                  break label5039;
                }
                RecentOptPopBar.a((QBaseActivity)this.jdField_a_of_type_AndroidContentContext, 0L, 0L, 0);
                return true;
              }
              if ("bind_number".equals(this.jdField_b_of_type_JavaLangString))
              {
                if (!"bind".equals(this.jdField_c_of_type_JavaLangString)) {
                  break label5041;
                }
                S();
                return true;
              }
              if ("stickynote".equals(this.jdField_b_of_type_JavaLangString))
              {
                if (!"feeddetail".equals(this.jdField_c_of_type_JavaLangString)) {
                  break label5043;
                }
                j();
                return true;
              }
              if ("commonBuddyGroup".equals(this.jdField_b_of_type_JavaLangString))
              {
                if (!"open".equals(this.jdField_c_of_type_JavaLangString)) {
                  break label5045;
                }
                i();
                return true;
              }
              if (("hippy".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString)))
              {
                bool = new OpenHippyInfo(this.jdField_a_of_type_JavaUtilHashMap).openHippy(this.jdField_a_of_type_AndroidContentContext);
                return bool;
              }
            }
          }
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doAction error:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("JumpAction", 1, ((StringBuilder)localObject2).toString());
      HashMap localHashMap = new HashMap(1);
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = "";
      }
      if (this.jdField_b_of_type_JavaLangString == null) {
        this.jdField_b_of_type_JavaLangString = "";
      }
      if (this.jdField_c_of_type_JavaLangString == null) {
        this.jdField_c_of_type_JavaLangString = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("JumpAction");
      ((StringBuilder)localObject2).append("source:");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("server_name:");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("action_name:");
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
      localHashMap.put("keyJumpParserUtilDoActionErrorInfo", ((StringBuilder)localObject2).toString());
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, localHashMap, "", false);
      return false;
    }
    label5035:
    return true;
    label5037:
    return true;
    label5039:
    return true;
    label5041:
    return false;
    label5043:
    return false;
    label5045:
    return false;
  }
  
  public Intent b(Intent paramIntent)
  {
    paramIntent.putExtra("action", 4);
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storysharefrom");
    String str1 = str2;
    try
    {
      if (TextUtils.equals(str4, "qzone")) {
        str1 = URLDecoder.decode(str2, "utf-8");
      }
      paramIntent.putExtra("extra_topic_id", Long.parseLong(str3));
      paramIntent.putExtra("extra_topic_name", str1);
      paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
      paramIntent.putExtra("extra_share_from_type", a(this.jdField_a_of_type_JavaUtilHashMap));
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      label134:
      break label134;
    }
    return null;
  }
  
  protected String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("/");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("?src_type=");
    localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
    return localStringBuilder.toString();
  }
  
  protected boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      ((IHWTroopUIApi)QRoute.api(IHWTroopUIApi.class)).startPublishHomeWorkFragment((Activity)this.jdField_a_of_type_AndroidContentContext, null, paramString);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772342, 2130772004);
    }
    return true;
  }
  
  public Intent c(Intent paramIntent)
  {
    paramIntent.putExtra("action", 12);
    try
    {
      paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
      paramIntent.putExtra("extra_share_from_type", a(this.jdField_a_of_type_JavaUtilHashMap));
      paramIntent.putExtra("to_new_version", (String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"));
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      label69:
      break label69;
    }
    return null;
  }
  
  public boolean c()
  {
    ((ISmallVideoFragmentUtil)QRoute.api(ISmallVideoFragmentUtil.class)).launch(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    return true;
  }
  
  public Intent d(Intent paramIntent)
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("showinfocard");
    int i = a(this.jdField_a_of_type_JavaUtilHashMap);
    boolean bool;
    if ((str5 != null) && (str5.equals("0"))) {
      bool = false;
    } else {
      bool = true;
    }
    if ((!TextUtils.isEmpty(str4)) || ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))) {}
    try
    {
      int j = Integer.parseInt(str2);
      if (j == 1)
      {
        if (TextUtils.isEmpty(str1)) {
          return null;
        }
        paramIntent.putExtra("action", 7);
        paramIntent.putExtra("EXTRA_USER_UIN", str1);
        paramIntent.putExtra("EXTRA_USER_UNION_ID", str3);
        paramIntent.putExtra("extra_is_show_info_card", bool);
        paramIntent.putExtra("extra_share_from_type", i);
        paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
        return paramIntent;
      }
      if (j == 5)
      {
        paramIntent.putExtra("action", 4);
        paramIntent.putExtra("extra_topic_id", Long.parseLong(str1));
        paramIntent.putExtra("extra_topic_name", (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname"));
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topiccolor");
        if (!TextUtils.isEmpty(str3)) {
          paramIntent.putExtra("extra_topic_color", Integer.parseInt(str3));
        }
        paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
        paramIntent.putExtra("extra_share_from_type", i);
        return paramIntent;
      }
      paramIntent.putExtra("action", 6);
      paramIntent.putExtra("user_type", Integer.parseInt(str2));
      paramIntent.putExtra("user_unionid", str3);
      paramIntent.putExtra("come_from", i);
      paramIntent.putExtra("showTitleBar", false);
      paramIntent.putExtra("showInfoCard", bool);
      return paramIntent;
    }
    catch (NumberFormatException paramIntent)
    {
      label407:
      break label407;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("makeStoryPlayVideoPageIntent, NumberFormatException, userId:");
      paramIntent.append(str1);
      paramIntent.append(", userType:");
      paramIntent.append(str2);
      QLog.d("JumpAction", 2, paramIntent.toString());
    }
    return null;
    return null;
    paramIntent.putExtra("action", 6);
    paramIntent.putExtra("story_id", str4);
    paramIntent.putExtra("come_from", i);
    paramIntent.putExtra("showTitleBar", false);
    paramIntent.putExtra("showInfoCard", false);
    return paramIntent;
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    String str = a(a(a(a(a(a(QzoneConfig.getInstance().getConfig("H5Url", "PersonalQzoneVisitor", "https://h5.qzone.qq.com/visitor/qzone/personal?uin={uin}&qua={qua}&clicktime={clicktime}&_bid=329&_wv=3&_proxy=true"), "{hostUin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "{clicktime}", String.valueOf(System.currentTimeMillis())), "{from}", "androidQQ"), "{qua}", QUA.getQUA3()), "{uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "{UIN}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.putExtra("articalChannelId", 5);
    if (WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717365));
    localIntent.setData(Uri.parse(str));
    localIntent.addFlags(268435456);
    localIntent.putExtra("needSkey", "true");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean f()
  {
    new JumpActionLegacy.32(this).start();
    return a();
  }
  
  public boolean g()
  {
    return (this.jdField_b_of_type_JavaLangString.equals("card")) && (this.jdField_c_of_type_JavaLangString.equals("show_pslcard")) && ("public_account".equals(this.jdField_a_of_type_JavaUtilHashMap.get("card_type"))) && ("app".equals(this.jdField_a_of_type_JavaUtilHashMap.get("src_type"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")));
  }
  
  public boolean i_()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = (QZoneManagerImp)((QQAppInterface)localObject).getManager(QQManagerFactory.QZONE_MANAGER);
    boolean bool1 = bool2;
    if (localObject != null) {
      if (((QZoneManagerImp)localObject).a(2) <= 0)
      {
        bool1 = bool2;
        if (((QZoneManagerImp)localObject).a(1) <= 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("newflag", bool1);
    localIntent.putExtra("refer", "schemeActiveFeeds");
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    localIntent.addFlags(805306368);
    localObject = null;
    if (this.jdField_a_of_type_JavaLangString != null) {
      localObject = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("push_trans_channel");
    }
    QZoneHelper.forwardToFriendFeed((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localIntent, (String)localObject, -1);
    LpReportInfo_dc02880.report(this.jdField_a_of_type_JavaLangString);
    return true;
  }
  
  public boolean j()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("url")) {
      this.jdField_a_of_type_JavaUtilHashMap.remove("url");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localIntent.putExtra((String)localEntry.getKey(), Uri.decode((String)localEntry.getValue()));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("weburl")) {
      localObject = Uri.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("weburl"));
    } else {
      localObject = "";
    }
    if ((!((String)localObject).startsWith("https://sou.qq.com/")) && (!((String)localObject).startsWith("https://sou.html5.qq.com/"))) {
      return false;
    }
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("fragment_class", "com.tencent.mobileqq.search.activity.MixSearchWebFragment");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!"1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("openanimtype")))) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(0, 0);
    }
    return true;
  }
  
  public boolean k()
  {
    Object localObject = b("param_meta_data");
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localBundle.putString("param_meta_data", (String)localObject);
    }
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_JavaLangString;
    }
    SmartDeviceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, (String)localObject, localBundle);
    return true;
  }
  
  public boolean l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "gotoSendBless");
    }
    BlessManager localBlessManager = (BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
    if (localBlessManager.a()) {
      localBlessManager.a(this.jdField_a_of_type_AndroidContentContext);
    } else {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, HardCodeUtil.a(2131705979), 0).a();
    }
    return true;
  }
  
  public boolean m()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("id");
    if (localObject == null) {
      return false;
    }
    try
    {
      l = Long.parseLong((String)localObject);
    }
    catch (Exception localException)
    {
      long l;
      label28:
      break label28;
    }
    l = -1L;
    if (l == -1L) {
      return false;
    }
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, LebaSearchPluginManagerActivity.class);
    ((Intent)localObject).putExtra("id", l);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    return true;
  }
  
  public boolean n()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_type");
    if ((localObject != null) && ("public_account".equals(localObject)))
    {
      int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("account_flag")));
      if ((i == -3) || (i == -4))
      {
        ((IPublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).getAIOHistoryMsg((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), 0L, 1);
        return true;
      }
    }
    else if ((localObject != null) && ("crm".equals(localObject)))
    {
      localObject = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
      if (localObject != null) {
        ((EnterpriseQQHandler)localObject).a(SystemClock.uptimeMillis());
      }
    }
    return true;
  }
  
  public boolean o()
  {
    String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    boolean bool = TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"));
    String str5 = "";
    String str2;
    if (!bool) {
      try
      {
        String str1 = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"), "utf-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        localUnsupportedEncodingException1.printStackTrace();
      }
    } else {
      str2 = "";
    }
    String str3 = str5;
    String str4;
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("userdata"))) {
      try
      {
        str3 = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"), "utf-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        localUnsupportedEncodingException2.printStackTrace();
        str4 = str5;
      }
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(str7);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      for (;;)
      {
        localNumberFormatException1.printStackTrace();
      }
    }
    int i;
    try
    {
      i = Integer.parseInt(str6);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      localNumberFormatException2.printStackTrace();
      i = 0;
    }
    ((ODProxy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ODPROXY_MGR)).a(this.jdField_a_of_type_AndroidContentContext, l1, "launcher", str2, str4, i);
    return true;
  }
  
  public boolean p()
  {
    Intent localIntent = new Intent();
    if (SettingsConfigHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, AssistantSettingFragment.class);
    }
    else
    {
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, AssistantSettingActivity.class);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    return true;
  }
  
  public boolean q()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/cmshow/store/guestStateActivity");
    localActivityURIRequest.extra().putString("extra_guest_nick", str1);
    localActivityURIRequest.extra().putString("extra_guest_uin", str2);
    QRoute.startUri(localActivityURIRequest, null);
    return true;
  }
  
  public boolean r()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean s()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ConferenceFlyTicketActivity.class);
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("confid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("subject");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("confidshort");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("ticket");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("discid");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("confphone");
    String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("businesstype");
    String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("stask");
    String str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("user");
    String str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("ticket_f");
    localIntent.putExtra("confid", str1);
    localIntent.putExtra("subject", str2);
    localIntent.putExtra("ticket", str4);
    localIntent.putExtra("confidshort", str3);
    localIntent.putExtra("discid", str5);
    localIntent.putExtra("confphone", str6);
    localIntent.putExtra("businesstype", str7);
    localIntent.putExtra("user", str9);
    localIntent.putExtra("stask", str8);
    localIntent.putExtra("ticket_f", str10);
    QQAudioHelper.b("start_ConferenceFlyTicketActivity");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean t()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentContext instanceof Activity;
    Object localObject3 = "";
    if (bool)
    {
      localObject1 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if (localObject1 != null)
      {
        str = ((Intent)localObject1).getStringExtra("big_brother_source_key");
        localObject1 = ((Intent)localObject1).getDataString();
        break label52;
      }
    }
    String str = null;
    Object localObject1 = "";
    label52:
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.jdField_a_of_type_JavaLangString;
    }
    localObject1 = localObject3;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    }
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("sourcee", str);
    ((Bundle)localObject3).putString("schemeUrl", (String)localObject2);
    ((Bundle)localObject3).putString("appid", (String)localObject1);
    try
    {
      ((IDynamicNowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).b((Bundle)localObject3);
      QLog.i("JumpAction", 1, "preloginLiteSDK-----");
      return true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("JumpAction", 2, localException.toString());
      }
    }
    return false;
  }
  
  public boolean u()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if (localObject1 != null)
      {
        str1 = ((Intent)localObject1).getStringExtra("big_brother_source_key");
        localObject1 = ((Intent)localObject1).getDataString();
        break label54;
      }
    }
    String str1 = null;
    Object localObject1 = "";
    label54:
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("roomid")) {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");
    } else {
      localObject1 = "0";
    }
    String str2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("fromid")) {
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    } else {
      str2 = "";
    }
    String str3;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("roomtype")) {
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomtype");
    } else {
      str3 = "";
    }
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("list_name")) {
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("list_name");
    } else {
      str4 = "";
    }
    String str5;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("first_jump_mode")) {
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("first_jump_mode");
    } else {
      str5 = "h5";
    }
    String str6;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("need_record")) {
      str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("need_record");
    } else {
      str6 = "1";
    }
    String str7;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("is_record")) {
      str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("is_record");
    } else {
      str7 = "0";
    }
    String str8;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("enter_record_if_finish")) {
      str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enter_record_if_finish");
    } else {
      str8 = "1";
    }
    String str9;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("nowapp_ext")) {
      str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nowapp_ext");
    } else {
      str9 = "";
    }
    String str10;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("nowplugin_ext")) {
      str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nowplugin_ext");
    } else {
      str10 = "";
    }
    String str11;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("h5_ext")) {
      str11 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("h5_ext");
    } else {
      str11 = "";
    }
    String str12;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("shakespearetime")) {
      str12 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shakespearetime");
    } else {
      str12 = "";
    }
    String str13;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msgurl")) {
      str13 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("msgurl"));
    } else {
      str13 = "";
    }
    String str14;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hostloading_percent")) {
      str14 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hostloading_percent");
    } else {
      str14 = "0";
    }
    long l = 0L;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("enter_ts")) {
      try
      {
        l = Long.parseLong((String)this.jdField_a_of_type_JavaUtilHashMap.get("enter_ts"));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("goNowRoom------NumberFormatException, e = ");
        ((StringBuilder)localObject3).append(localNumberFormatException.getMessage());
        QLog.e("JumpAction", 1, ((StringBuilder)localObject3).toString());
        l = 0L;
      }
    }
    String str15 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("coverurl");
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extras");
    Object localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
    localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("first");
    localObject4 = new Bundle();
    ((Bundle)localObject4).putString("coverurl", str15);
    ((Bundle)localObject4).putString("roomid", (String)localObject1);
    ((Bundle)localObject4).putString("roomtype", str3);
    ((Bundle)localObject4).putString("extras_from_js", (String)localObject3);
    ((Bundle)localObject4).putBoolean("can_use_h5_first", true);
    ((Bundle)localObject4).putString("first_jump_mode", str5);
    ((Bundle)localObject4).putString("is_record", str7);
    ((Bundle)localObject4).putString("enter_record_if_finish", str8);
    ((Bundle)localObject4).putString("nowapp_ext", str9);
    ((Bundle)localObject4).putString("nowplugin_ext", str10);
    ((Bundle)localObject4).putString("h5_ext", str11);
    ((Bundle)localObject4).putString("shakespearetime", str12);
    ((Bundle)localObject4).putString("fromid", str2);
    ((Bundle)localObject4).putString("url", str13);
    ((Bundle)localObject4).putString("listname", str4);
    ((Bundle)localObject4).putString("mqqScheme", (String)localObject2);
    ((Bundle)localObject4).putLong("enter_ts", l);
    if (!TextUtils.isEmpty(str1)) {
      ((Bundle)localObject4).putString("big_brother_source_key", str1);
    }
    boolean bool;
    if ((!TextUtils.isEmpty(str6)) && ("0".equals(str6))) {
      bool = false;
    } else {
      bool = true;
    }
    ((Bundle)localObject4).putBoolean("need_record", bool);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("topic")) {
      ((Bundle)localObject4).putString("topic", (String)this.jdField_a_of_type_JavaUtilHashMap.get("topic"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("story_ext")) {
      ((Bundle)localObject4).putString("story_ext", (String)this.jdField_a_of_type_JavaUtilHashMap.get("story_ext"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("startsrc")) {
      ((Bundle)localObject4).putString("startsrc", (String)this.jdField_a_of_type_JavaUtilHashMap.get("startsrc"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hostloading_percent")) {
      ((Bundle)localObject4).putInt("hostloading_percent", Integer.valueOf(str14).intValue());
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, "无网络连接请稍后再试", 1).a();
      return false;
    }
    try
    {
      ((IDynamicNowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a((Bundle)localObject4);
      QLog.i("JumpAction", 1, "enter now plugin use shadow");
      return true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("JumpAction", 2, localException.toString());
      }
    }
    return false;
  }
  
  public boolean v()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddContactsActivity.class);
    localIntent.setFlags(67108864);
    int j = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("des_type"));
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        i = j;
        if (j != 2) {
          i = 0;
        }
      }
    }
    localIntent.putExtra("tab_index_key", i);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean w()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, InterestSwitchEditActivity.class);
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  protected boolean x()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(str1);
    if (localObject != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      boolean bool;
      if ((!((TroopInfo)localObject).isTroopOwner(str2)) && (!((TroopInfo)localObject).isTroopAdmin(str2))) {
        bool = false;
      } else {
        bool = true;
      }
      if ((!((TroopInfo)localObject).mMemberInvitingFlag) && (!bool))
      {
        QLog.e("JumpAction", 1, "cannot invite join group");
        return true;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("param_groupcode", str1);
      ((Intent)localObject).putExtra("param_type", 1);
      ((Intent)localObject).putExtra("param_subtype", 1);
      ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131697306));
      ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131696061));
      ((Intent)localObject).putExtra("param_is_troop_admin", bool);
      ((Intent)localObject).putExtra("param_donot_need_contacts", true);
      ((Intent)localObject).putExtra("param_max", 100);
      ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject);
      return true;
    }
    QLog.e("JumpAction", 1, "troopInfo not found");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy
 * JD-Core Version:    0.7.0.1
 */