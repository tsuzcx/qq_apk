package com.tencent.mobileqq.utils;

import QQWalletPay.ReqCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.dataline.activities.LiteActivity;
import com.etrump.mixlayout.FontManager;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.av.VideoController;
import com.tencent.av.share.ShareChat;
import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.util.ProfileParams.Builder;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionUtils;
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
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceScanner;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.hippy.qq.utils.HippyAccessHelper.OpenHippyInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
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
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingFragment;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.activity.qwallet.WXMiniProgramHelper;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopHandler;
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
import com.tencent.mobileqq.config.business.QQComicConfBean;
import com.tencent.mobileqq.config.business.QQComicConfBean.ServiceAccountConfig;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardD55Manager;
import com.tencent.mobileqq.forward.ForwardSdkStatusManager;
import com.tencent.mobileqq.forward.ForwardShareByServerHelper;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.identification.IdentificationActivityHelper;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherManager;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.miniapp.util.MiniAppJumpUtil;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.NearbyFaceScoreManager;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.mobileqq.now.NowQQLiveHelper;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.qbosssplash.common.QbossPreDownloadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.settings.message.AssistantSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studyroom.StudyRoomManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.NearbyTroops;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.utils.NearbyVideoChatManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.mobileqq.vashealth.SportManager;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqp.app.sec.SecShareInfoUtil;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.agent.BindTroopPreVerificationFragment;
import com.tencent.open.agent.JoinTroopPreVerificationFragment;
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
import com.tencent.util.QQDeviceInfo;
import com.tencent.util.URLUtil;
import com.tencent.util.VersionUtils;
import common.config.service.QzoneConfig;
import cooperation.comic.VipComicJumpActivity;
import cooperation.plugin.PluginInfo;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.util.QzoneAuthorizeConfig;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.readinjoy.ReadInjoyFloatingWindowHelper;
import cooperation.troop.NearbyVideoChatProxyActivity;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageCmd;
import cooperation.troop.TroopManageProxyActivity;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.entry.AECameraLauncher;
import dov.com.qq.im.ae.util.AEQLog;
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
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JumpAction
{
  public static int a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.mobileqq" };
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public Context a;
  protected Handler a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public ChatActivityUtils.StartVideoListener a;
  public final QQAppInterface a;
  private QWalletAuthObserver jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver;
  public BusinessInfoCheckUpdate.AppInfo a;
  public JumpAction.CustomHeadObserver a;
  private JumpAction.QWalletAuthMsgHandler jdField_a_of_type_ComTencentMobileqqUtilsJumpAction$QWalletAuthMsgHandler;
  public QQProgressDialog a;
  QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new JumpAction.13(this);
  public String a;
  public HashMap<String, String> a;
  public Hashtable<String, Long> a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public String f;
  public boolean f;
  public String g;
  public boolean g;
  public String h;
  protected boolean h;
  public String i;
  protected boolean i;
  public String j;
  public boolean j;
  public String k;
  private boolean k;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public JumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction$CustomHeadObserver = new JumpAction.CustomHeadObserver(this, this);
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener = new JumpAction.25(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private boolean C()
  {
    try
    {
      i1 = Integer.parseInt(this.jdField_c_of_type_JavaLangString);
      switch (i1)
      {
      default: 
        return true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("JumpAction", 1, "handleQfavHelperAction error:" + localNumberFormatException.getMessage());
        int i1 = -1;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690778));
      return QfavHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, -1, false);
    }
  }
  
  private boolean D()
  {
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    if ((TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))))
    {
      QLog.e("JumpAction", 1, "identification with illegal params");
      return true;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"), "");
    IdentificationActivityHelper.a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean E()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("mini_appid")) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("fakeUrl"))) {}
    for (int i1 = 1; i1 != 0; i1 = 0) {
      return MiniAppLauncher.launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    return ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, 2016, null, null);
  }
  
  private boolean F()
  {
    String str2 = null;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("app")) {}
    for (String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app");; str1 = null)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("type")) {
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
      }
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        ((AppletsFolderManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, str1, str2);
      }
      return true;
    }
  }
  
  private boolean G()
  {
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("entry")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("entry");
    }
    for (;;)
    {
      String str2;
      label56:
      long l2;
      long l1;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("seq"))
      {
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("seq");
        l2 = 0L;
        l1 = l2;
        if (TextUtils.isEmpty(str2)) {}
      }
      try
      {
        l1 = Long.valueOf(str2).longValue();
      }
      catch (Exception localException1)
      {
        try
        {
          VACDReportUtil.a(l1, "", "jumpParse", null, 0, null);
          for (;;)
          {
            label89:
            str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
            if (("1".equals(str2)) || ("2".equals(str2)) || ("3".equals(str2)) || ("4".equals(str2)) || ("5".equals(str2)) || ("6".equals(str2)) || ("7".equals(str2)) || ("9".equals(str2)) || ("10".equals(str2)) || ("11".equals(str2)))
            {
              Bundle localBundle = new Bundle();
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tokenid")) {
                localBundle.putString("tokenid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("tokenid"));
              }
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("data")) {
                localBundle.putString("data", (String)this.jdField_a_of_type_JavaUtilHashMap.get("data"));
              }
              return a(str2, str1, l1, localBundle);
              str1 = null;
              break;
              str2 = null;
              break label56;
            }
            if ("8".equals(str2)) {
              return a(str2, str1, l1);
            }
            return false;
            localException1 = localException1;
            l1 = l2;
          }
        }
        catch (Exception localException2)
        {
          break label89;
        }
      }
    }
  }
  
  private boolean H()
  {
    if (this.jdField_c_of_type_JavaLangString.equals("publish")) {
      return bi();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("writemood")) {
      return bm();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("to_publish_queue")) {
      return bn();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("open_homepage")) {
      return bo();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("groupalbum")) {
      return bd();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("to_friend_feeds")) {
      return h();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("to_qzone_dialog")) {
      return be();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("to_redpocket_share")) {
      return bj();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("open_redpocket")) {
      return bk();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("qzone_schema")) {
      return bf();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("shareLogToQQ")) {
      return bl();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("qzone_publicaccount")) {
      return bg();
    }
    return false;
  }
  
  private boolean I()
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
      return aQ();
    }
    return aU();
  }
  
  private boolean J()
  {
    if (this.jdField_c_of_type_JavaLangString.equals("emoji")) {
      EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 7);
    }
    do
    {
      return true;
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
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, null, false, -1);
        return true;
      }
      if (this.jdField_c_of_type_JavaLangString.equals("theme"))
      {
        if ((!BaseApplicationImpl.IS_SUPPORT_THEME) || (!Utils.a())) {
          break label675;
        }
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, null, false, -1);
        return true;
      }
      if (this.jdField_c_of_type_JavaLangString.equals("font"))
      {
        if ((!((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).c()) || (!Utils.a())) {
          break label675;
        }
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "font", ""), 4096L, null, false, -1);
        return true;
      }
      if (!this.jdField_c_of_type_JavaLangString.equals("pendant")) {
        break;
      }
    } while (!Utils.a());
    AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    return true;
    if (this.jdField_c_of_type_JavaLangString.equals("individuation"))
    {
      VasWebviewUtil.openIndividuationIndex(this.jdField_a_of_type_AndroidContentContext);
      return true;
    }
    Intent localIntent;
    Object localObject;
    int i1;
    int i2;
    if (this.jdField_c_of_type_JavaLangString.equals("apollo_store"))
    {
      localIntent = new Intent();
      localObject = this.jdField_a_of_type_JavaLangString.split("\\?");
      if (localObject.length < 2) {
        break label680;
      }
      localIntent.putExtra("extra_key_url_append", localObject[1]);
      if (localObject[1] == null) {
        break label680;
      }
      if (localObject[1].contains("tab=game_center"))
      {
        i1 = 0;
        i2 = 1;
        localObject = null;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, new Object[] { "apollo_store url:", localObject });
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = ApolloConstant.u;
      }
      for (;;)
      {
        if (i2 != 0) {
          ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloGameCenter(this.jdField_a_of_type_AndroidContentContext);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label673;
          }
          localObject = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_clk", ((IApolloManagerService)localObject).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()), 0, new String[] { "0" });
          return true;
          if (localObject[1].contains("tab=other_url&url="))
          {
            localObject = URLDecoder.decode(localObject[1].substring(localObject[1].indexOf("tab=other_url&url=") + "tab=other_url&url=".length()));
            i2 = 0;
            i1 = 1;
            break;
          }
          HashMap localHashMap = new HashMap();
          StoryShareEncryptHelper.a(localObject[1], localHashMap);
          localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getStoreTabUrl((String)localHashMap.get("tab"), true);
          i2 = 0;
          i1 = 0;
          break;
          if (i1 != 0) {
            ((IApolloUtil)QRoute.api(IApolloUtil.class)).openWebViewActivity(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
          } else {
            ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_AndroidContentContext, localIntent, null, (String)localObject, null);
          }
        }
        label673:
        break;
        label675:
        return false;
      }
      label680:
      i1 = 0;
      i2 = 0;
      localObject = null;
    }
  }
  
  private boolean K()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "enter jiankang");
    }
    ThreadManager.post(new JumpAction.5(this), 5, null, true);
    if ((Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor")).getDefaultSensor(19) != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      ((SportManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SPORT_MANAGER)).a("jump action");
    }
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if ((localObject2 == null) || ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://"))) || ((!Util.b((String)localObject2).equalsIgnoreCase("qq.com")) && (!Util.b((String)localObject2).equalsIgnoreCase("myun.tenpay.com")) && (!Util.b((String)localObject2).equalsIgnoreCase("tenpay.com")) && (!Util.b((String)localObject2).equalsIgnoreCase("wanggou.com")))) {
      return false;
    }
    Object localObject1 = localObject2;
    if (((String)localObject2).indexOf("?") <= 0) {
      localObject1 = (String)localObject2 + "?";
    }
    localObject2 = new StringBuilder((String)localObject1);
    StringBuilder localStringBuilder = ((StringBuilder)localObject2).append("&client=androidQQ").append("&uin=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("&version=").append("8.5.5.5105").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&density=").append(ThemeUtil.getThemeDensity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())).append("&platformId=2").append("&_lv=0").append("&hasRedDot=");
    if (this.jdField_d_of_type_Boolean) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      localStringBuilder.append((String)localObject1).append("&adtag=mvip.gongneng.anroid.health.nativet");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      ((StringBuilder)localObject2).append("&lati=").append(((SharedPreferences)localObject1).getFloat("search_lbs_latitude", 0.0F));
      ((StringBuilder)localObject2).append("&logi=").append(((SharedPreferences)localObject1).getFloat("search_lbs_logitude", 0.0F));
      int i1 = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      ((StringBuilder)localObject2).append("&netType=" + i1);
      localObject1 = DeviceInfoUtil.d();
      ((StringBuilder)localObject2).append("&model=" + (String)localObject1);
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString());
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
  }
  
  private boolean L()
  {
    boolean bool = false;
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
      if ((str1 != null) && (str2 != null)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_tribe", "", "url", "visit", 0, 1, 0, str1, Util.b(str2, new String[0]), "", "");
      }
      bool = true;
    }
    catch (Exception localException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e("JumpAction", 4, "URLDecoder.decode error");
    }
    return bool;
    return false;
  }
  
  private boolean M()
  {
    if (this.jdField_c_of_type_JavaLangString.equals("open")) {
      return t();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("report")) {
      return u();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("reportrealtime")) {
      return v();
    }
    Object localObject1;
    int i1;
    Object localObject2;
    if (this.jdField_c_of_type_JavaLangString.equals("apenalbum"))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("articleid");
      i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin_type"));
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountImageCollectionMainActivity.class);
        ((Intent)localObject2).putExtra("source_for_report", i1);
        PublicAccountImageCollectionUtils.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, (String)localObject1);
      }
    }
    for (;;)
    {
      return false;
      if (this.jdField_c_of_type_JavaLangString.equals("multivideo")) {
        return w();
      }
      if (this.jdField_c_of_type_JavaLangString.equals("openatlas"))
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("rowkey")) {}
        for (localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rowkey"); TextUtils.isEmpty((CharSequence)localObject1); localObject1 = "")
        {
          if (QLog.isColorLevel()) {
            QLog.e("JumpAction", 2, "rowKey is Empty");
          }
          return false;
        }
        label263:
        String str1;
        label291:
        String str2;
        label319:
        String str3;
        label347:
        label375:
        String str4;
        label403:
        String str5;
        label431:
        label459:
        String str6;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("picindex"))
        {
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("picindex");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("source")) {
            break label627;
          }
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("enteranimationstyle")) {
            break label635;
          }
          str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enteranimationstyle");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("hideTopic")) {
            break label643;
          }
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hideTopic");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("commentId")) {
            break label646;
          }
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("commentId");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("subCommentId")) {
            break label653;
          }
          str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("subCommentId");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("albumStyle")) {
            break label660;
          }
          str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("albumStyle");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("jumpCommentType")) {
            break label663;
          }
          str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jumpCommentType");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("isAwesome")) {
            break label670;
          }
          str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isAwesome");
        }
        for (;;)
        {
          for (;;)
          {
            int i2;
            label643:
            label646:
            label653:
            label660:
            label663:
            label670:
            try
            {
              Integer.valueOf((String)localObject2).intValue();
              i1 = Integer.valueOf(str1).intValue();
            }
            catch (Exception localException1)
            {
              label627:
              label635:
              i1 = 0;
            }
            try
            {
              Integer.valueOf(str2).intValue();
              i2 = i1;
              if (!Boolean.valueOf(ReadInJoyHelper.w(ReadInJoyUtils.a())).booleanValue()) {
                break label703;
              }
              localObject1 = "https://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&rowkey=" + (String)localObject1 + "&album_source=" + i2 + "&isAwesome=" + str6 + "&commentId=" + str3 + "&subCommentId=" + str4 + "&jumpCommentType=" + str5;
              ViolaAccessHelper.a(this.jdField_a_of_type_AndroidContentContext, null, (String)localObject1, null);
            }
            catch (Exception localException2)
            {
              label681:
              break label681;
            }
          }
          localObject2 = "0";
          break label263;
          str1 = "0";
          break label291;
          str2 = "0";
          break label319;
          break label347;
          str3 = "";
          break label375;
          str4 = "";
          break label403;
          break label431;
          str5 = "";
          break label459;
          str6 = "";
          continue;
          i2 = i1;
          if (QLog.isColorLevel())
          {
            QLog.e("JumpAction", 2, "Parameter error");
            i2 = i1;
          }
        }
        label703:
        if (QLog.isColorLevel()) {
          QLog.e("JumpAction", 2, "jumpToGallery failed: atlas has undercarriage");
        }
      }
      else
      {
        if (this.jdField_c_of_type_JavaLangString.equals("selfpage"))
        {
          ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, false);
          return true;
        }
        if ("showugceditor".equals(this.jdField_c_of_type_JavaLangString))
        {
          k();
        }
        else if ("openarticle".equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject1 = ReadInJoyActivityHelper.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
          if ((this.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)) {
            ((FastWebActivity)this.jdField_a_of_type_AndroidContentContext).a((Intent)localObject1);
          } else {
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          }
        }
      }
    }
  }
  
  private boolean N()
  {
    Object localObject1;
    String str1;
    if ("opendetail".equals(this.jdField_c_of_type_JavaLangString))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("key_launch_time", System.currentTimeMillis());
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      if ((str1 == null) || ("".equals(str1)) || (str1.length() < 5)) {
        return false;
      }
    }
    try
    {
      ((Bundle)localObject1).putLong("key_current_feeduin", Long.valueOf(str1).longValue());
      ((Bundle)localObject1).putString("key_current_feed_cellid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("cellid"));
      ((Bundle)localObject1).putInt("key_request_from", 3);
      ((Bundle)localObject1).putInt("key_weishi_entrance_type", 19);
      ((Bundle)localObject1).putInt("key_request_business_type", 8);
      a((Bundle)localObject1);
      for (;;)
      {
        return true;
        if (!"takevideo".equals(this.jdField_c_of_type_JavaLangString)) {
          continue;
        }
        String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("widgetid");
        String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("activity_id");
        Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shareto");
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cmode");
        String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("widgetinfo");
        Bundle localBundle = new Bundle();
        if (!TextUtils.isEmpty(str2)) {
          localBundle.putString("KEY_CURRENT_SELECT_ID", str2);
        }
        localBundle = dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil.a(localBundle, str4);
        AEQLog.b("JumpAction", "【widgetid】:" + str2 + "【" + "from" + "】:" + str3 + "【" + "activity_id" + "】:" + (String)localObject1 + "【" + "shareto" + "】:" + (String)localObject2 + "【" + "cmode" + "】:" + str1 + "【" + "widgetinfo" + "】:" + str4);
        try
        {
          i1 = AECameraEntry.a(str3).a();
          a(localBundle, i1);
          if (i1 == AECameraEntry.n.a()) {
            localObject1 = "qzone_takesame";
          }
        }
        catch (Exception localException1)
        {
          label524:
          try
          {
            if (!AECameraEntry.d(i1)) {
              break label667;
            }
            str1 = "cameraAndPlay";
          }
          catch (Exception localException5)
          {
            int i1;
            label466:
            label484:
            label505:
            break label524;
          }
          try
          {
            localBundle.putInt("VIDEO_STORY_FROM_TYPE", i1);
            localObject2 = localObject1;
            str3 = str1;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {}
          }
          catch (Exception localException6)
          {
            break label524;
          }
          try
          {
            localBundle.putString("VIDEO_STORY_ACTIVITY_ID", (String)localObject2);
            if (TextUtils.isEmpty(str3)) {}
          }
          catch (Exception localException1)
          {
            try
            {
              localBundle.putInt("AECAMERA_MODE", AECameraEntry.a(str3));
              AECameraLauncher.a((Activity)this.jdField_a_of_type_AndroidContentContext, 120, localBundle);
              continue;
              localException4 = localException4;
              str3 = str1;
              localObject2 = localObject1;
              if (!QLog.isColorLevel()) {
                break label466;
              }
              QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_FROM_TYPE format: " + localException4.getMessage());
              str3 = str1;
              localObject2 = localObject1;
              break label466;
              localException1 = localException1;
              if (!QLog.isColorLevel()) {
                break label484;
              }
              QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_ACTIVITY_ID format: " + localException1.getMessage());
            }
            catch (Exception localException2)
            {
              if (!QLog.isColorLevel()) {
                break label505;
              }
              QLog.e("JumpAction", 2, "Invalid AECAMERA_MODE format: " + localException2.getMessage());
              break label505;
            }
          }
        }
      }
    }
    catch (Exception localException3)
    {
      label667:
      for (;;)
      {
        continue;
      }
    }
  }
  
  private boolean O()
  {
    WXMiniProgramHelper.a().a(this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  private boolean P()
  {
    int i1 = 0;
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694460, 1).a();
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("params")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");
    }
    try
    {
      String str2;
      long[] arrayOfLong;
      for (;;)
      {
        localObject = new JSONObject(new String(Base64Util.decode(str1, 0)));
        str2 = ((JSONObject)localObject).optString("keyword");
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("groupmask");
        arrayOfLong = new long[localJSONArray.length()];
        while (i1 < localJSONArray.length())
        {
          arrayOfLong[i1] = localJSONArray.optLong(i1);
          i1 += 1;
        }
        str1 = "";
      }
      Object localObject = ((JSONObject)localObject).optString("groupname");
      ActiveEntitySearchActivity.a(this.jdField_a_of_type_AndroidContentContext, str2, (String)localObject, arrayOfLong);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("JumpActionQ.uniteSearch.", 2, "参数解析成json错误.  params=" + str1);
      }
    }
    return true;
  }
  
  private boolean Q()
  {
    int i2 = 0;
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694460, 1).a();
      return false;
    }
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("invitorId");
    int i1 = 10;
    for (;;)
    {
      try
      {
        i3 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("roomNum"));
        i1 = i3;
      }
      catch (Exception localException3)
      {
        int i3;
        long l1;
        long l2;
        label111:
        continue;
      }
      try
      {
        i3 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("zoneId"));
        i2 = i3;
      }
      catch (Exception localException2) {}
    }
    l1 = -1L;
    try
    {
      l2 = Long.parseLong((String)this.jdField_a_of_type_JavaUtilHashMap.get("gc"));
      l1 = l2;
    }
    catch (Exception localException1)
    {
      break label111;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, GameRoomTransActivity.class);
      ((Intent)localObject).putExtra("roomNum", i1);
      ((Intent)localObject).putExtra("action", 3);
      ((Intent)localObject).putExtra("zoneId", i2);
      ((Intent)localObject).putExtra("gc", l1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
    for (;;)
    {
      return true;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, GameRoomTransActivity.class);
      localIntent.putExtra("inviteId", (String)localObject);
      localIntent.putExtra("roomNum", i1);
      localIntent.putExtra("zoneId", i2);
      localIntent.putExtra("action", 2);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  private boolean R()
  {
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694460, 1).a();
      return false;
    }
    int i1 = 10;
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("roomNum"));
        i1 = i2;
      }
      catch (Exception localException2)
      {
        int i2;
        Intent localIntent;
        continue;
      }
      try
      {
        i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("zoneId"));
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, GameRoomTransActivity.class);
        localIntent.putExtra("roomNum", i1);
        localIntent.putExtra("zoneId", i2);
        localIntent.putExtra("action", 1);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return true;
      }
      catch (Exception localException1)
      {
        i2 = 0;
      }
    }
  }
  
  private boolean S()
  {
    boolean bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("token");
    if (!TextUtils.isEmpty(str)) {
      StoryShareEncryptHelper.a(this.jdField_a_of_type_AndroidContentContext, str, new JumpAction.6(this), null);
    }
    for (;;)
    {
      return true;
      if (TextUtils.equals(this.jdField_c_of_type_JavaLangString, "publish"))
      {
        T();
      }
      else
      {
        if (bool)
        {
          this.jdField_c_of_type_JavaLangString = "open";
          StoryShareEncryptHelper.a(this.jdField_a_of_type_JavaUtilHashMap);
        }
        T();
      }
    }
  }
  
  private boolean T()
  {
    if ((QzoneConfig.getInstance().getConfig("qqstoryvideo", "jump_hyws_scheme_enable", 0) == 0) && (BaseApplicationImpl.getContext() != null))
    {
      ThreadManager.getUIHandler().post(new JumpAction.7(this));
      return false;
    }
    if ((((MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).jdField_a_of_type_Boolean) && (!"open".equals(this.jdField_c_of_type_JavaLangString)) && (!"openTag".equals(this.jdField_c_of_type_JavaLangString)) && (!"openSquare".equals(this.jdField_c_of_type_JavaLangString)) && (!"publish".equals(this.jdField_c_of_type_JavaLangString))) {
      return bH();
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
      return bK();
    }
    if ("open".equals(this.jdField_c_of_type_JavaLangString)) {
      return bK();
    }
    return bH();
  }
  
  private boolean U()
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().h())) {}
      for (String str = "https://docs.qq.com/desktop/m/index.html?_from=1";; str = TencentDocConvertConfigProcessor.a().h())
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent.putExtra("url", str));
        break;
      }
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean V()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
    localIntent.putExtra("fragment_id", 1);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
    localIntent.putExtra("from", str);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if ("10003".equals(str)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077F6", "0X80077F6", 0, 0, "", "", "", "");
    }
    do
    {
      return true;
      if ("10004".equals(str))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077F7", "0X80077F7", 0, 0, "", "", "", "");
        return true;
      }
    } while (!"10009".equals(str));
    QLog.i("JumpAction", 1, "jumpaction from gotoConversaton e = ");
    return true;
  }
  
  private boolean W()
  {
    long l4 = System.currentTimeMillis();
    boolean bool2 = ARDeviceController.a().a();
    ARGlobalConfigManager localARGlobalConfigManager = (ARGlobalConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    Object localObject1;
    if (localARGlobalConfigManager != null)
    {
      localObject1 = localARGlobalConfigManager.a();
      QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is config info is " + localObject1);
      if (!localARGlobalConfigManager.b()) {}
    }
    label134:
    label1163:
    label1171:
    label1176:
    for (boolean bool1 = true;; bool1 = false)
    {
      String str;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      }
      label800:
      label1196:
      for (;;)
      {
        Object localObject2;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("args"))
        {
          localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("args");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("disablecloud")) {
            break label513;
          }
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("disablecloud");
        }
        label586:
        label848:
        try
        {
          for (;;)
          {
            i1 = Integer.parseInt((String)localObject2);
            if ((i1 == 1) || (i1 == 0)) {
              break label1392;
            }
            i1 = 1;
            QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is " + bool2 + ",effectinfo is " + bool1 + ",from url is " + str + ",args is" + (String)localObject1 + ",cloudSwitch is " + i1);
            if ((!bool2) || (!bool1)) {
              break label1196;
            }
            localIntent = new Intent();
            localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ScannerActivity.class);
            localIntent.putExtra("from", "web-ar");
            localIntent.addFlags(67108864);
            localIntent.addFlags(268435456);
            localIntent.addFlags(65536);
            localIntent.addFlags(536870912);
            localIntent.putExtra("click_time", System.currentTimeMillis());
            localIntent.putExtra("web_url_switch", i1);
            localIntent.putExtra("jump_from_web", true);
            if (!QLog.isDevelopLevel()) {
              break label619;
            }
            localObject2 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
            for (localObject1 = "";; localObject1 = (String)localObject1 + (String)((Map.Entry)localObject4).getKey() + "[" + ((String)((Map.Entry)localObject4).getValue()).substring(0, 20) + "]\n")
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label586;
              }
              localObject4 = (Map.Entry)((Iterator)localObject2).next();
              if ((((Map.Entry)localObject4).getValue() == null) || (((String)((Map.Entry)localObject4).getValue()).length() <= 20)) {
                break;
              }
            }
            str = "";
            break;
            localObject1 = "";
            break label134;
            localObject2 = "0";
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label619:
          label876:
          label1392:
          for (;;)
          {
            Intent localIntent;
            int i1 = 0;
            continue;
            localObject1 = (String)localObject1 + (String)((Map.Entry)localObject4).getKey() + "[" + (String)((Map.Entry)localObject4).getValue() + "]\n";
            continue;
            QLog.w("JumpAction", 1, "gotoScannerActivity, \n" + (String)localObject1 + "]");
            Object localObject4 = new Bundle();
            localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionType");
            long l2 = 1L;
            long l1 = l2;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
            try
            {
              l1 = Long.valueOf((String)localObject1).longValue();
              long l3 = 0L;
              localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("RecoglizeMask");
              l2 = l3;
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
              try
              {
                l2 = Long.valueOf((String)localObject1).longValue();
                Object localObject3;
                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("H5Source"))
                {
                  localObject1 = "";
                  bool1 = true;
                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("enableQR")) {
                    break label1143;
                  }
                  localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enableQR");
                }
                label754:
                label1143:
                try
                {
                  l3 = Long.valueOf((String)localObject3).longValue();
                  if (l3 != 0L) {
                    break label1151;
                  }
                  bool1 = true;
                }
                catch (Exception localException3)
                {
                  label1016:
                  label1151:
                  break label774;
                }
                ((Bundle)localObject4).putLong("PromotionType", l1);
                ((Bundle)localObject4).putLong("RecoglizeMask", l2);
                if (i1 != 0)
                {
                  bool2 = true;
                  ((Bundle)localObject4).putBoolean("disablecloud", bool2);
                  ((Bundle)localObject4).putString("H5Source", (String)localObject1);
                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("version")) {
                    break label1163;
                  }
                  localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
                  ((Bundle)localObject4).putString("version", (String)localObject1);
                  ((Bundle)localObject4).putBoolean("enableQR", bool1);
                  if (l1 == 0L) {
                    break label1171;
                  }
                  i1 = 1;
                  if ((i1 != 0) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("PromotionDescription"))) {
                    ((Bundle)localObject4).putString("PromotionDescription", (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionDescription"));
                  }
                  ((Bundle)localObject4).putBoolean("is_from_h5_entry", true);
                  localIntent.putExtra("web_invoke_params", (Bundle)localObject4);
                  AudioHelper.a("JumpAction", (Bundle)localObject4);
                  QLog.w("JumpAction", 1, "PromotionInfo test , \n" + ((Bundle)localObject4).toString() + "]");
                  if (localARGlobalConfigManager != null)
                  {
                    if ((localARGlobalConfigManager.a() != null) && (!TextUtils.isEmpty(localARGlobalConfigManager.a().jdField_e_of_type_JavaLangString))) {
                      break label1176;
                    }
                    localIntent.putExtra("icon_text", "QQ-AR");
                    if ((localARGlobalConfigManager.a() != null) && (localARGlobalConfigManager.a().jdField_c_of_type_JavaLangString != null)) {
                      localIntent.putExtra("icon_url", localARGlobalConfigManager.a().jdField_c_of_type_JavaLangString);
                    }
                  }
                  this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "0", str, "", "");
                }
                for (;;)
                {
                  QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity cost time is " + (System.currentTimeMillis() - l4));
                  return true;
                  localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("H5Source");
                  break;
                  localObject3 = "0";
                  break label754;
                  bool1 = false;
                  break label774;
                  bool2 = false;
                  break label800;
                  localObject1 = "0";
                  break label848;
                  i1 = 0;
                  break label876;
                  localIntent.putExtra("icon_text", localARGlobalConfigManager.a().jdField_e_of_type_JavaLangString);
                  break label1016;
                  localObject3 = new StringBuilder("https://ti.qq.com/ar/help/error.html?_wv=3");
                  ((StringBuilder)localObject3).append("&from=");
                  ((StringBuilder)localObject3).append(str);
                  ((StringBuilder)localObject3).append("&args=");
                  new StringBuffer();
                  ((StringBuilder)localObject3).append(GrayTipsItemBuilder.a((String)localObject1));
                  QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity QQBrowserActivity cost time is " + ((StringBuilder)localObject3).toString());
                  localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                  ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
                  ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject3).toString());
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "1", str, "", "");
                }
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  l2 = l3;
                }
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                l1 = l2;
              }
            }
          }
        }
      }
    }
  }
  
  private boolean X()
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("kSrouce")) {
          continue;
        }
        localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        i1 = Integer.parseInt((String)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.i("JumpAction", 1, "gotoBindNumberActivity from value format wrong");
        int i1 = 22;
        continue;
      }
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, BindNumberActivity.class);
      ((Intent)localObject).putExtra("kSrouce", i1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
      localObject = "22";
    }
  }
  
  private boolean Y()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("interest_type")) {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "ChooseInterestTagActivity->type = null");
      }
    }
    do
    {
      for (;;)
      {
        return false;
        Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("interest_type");
        String str;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from"))
        {
          str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "ChooseInterestTagActivity->type = " + (String)localObject);
          }
        }
        try
        {
          i1 = Integer.valueOf((String)localObject).intValue();
          if ("interesttag_selector".equals(this.jdField_c_of_type_JavaLangString))
          {
            try
            {
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, ChooseInterestTagActivity.class);
              ((Intent)localObject).putExtra("is_from_judge", true);
              ((Intent)localObject).putExtra("interest_tag_type", i1);
              ((Intent)localObject).putExtra("from_where", "web_to_choose_tag");
              if ("10002".equals(str)) {
                ((Intent)localObject).addFlags(268435456);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return true;
            }
            catch (Exception localException1) {}
            str = "";
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i1 = 0;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpAction", 2, "", localException1);
    return false;
  }
  
  private boolean Z()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class);
    localIntent.putExtra("TAB_TYPE", 1);
    String str2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type")) {
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    }
    for (;;)
    {
      String str4;
      label107:
      String str5;
      label135:
      String str1;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("web_url"))
      {
        str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("web_url");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
          break label758;
        }
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
          break label765;
        }
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
        label163:
        localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
        localIntent.putExtra("fromWhere", str2);
        localIntent.putExtra("webUrl", str4);
        localIntent.putExtra("fromType", str1);
        localIntent.putExtra("FROM_WHERE", 1);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("neighbor_list_source")) {}
      }
      try
      {
        i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("neighbor_list_source"));
        localIntent.putExtra("neighbor_list_source", i1);
        if ("10002".equals(str5))
        {
          localIntent.putExtra("abp_flag", true);
          localIntent.addFlags(268435456);
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter"))
        {
          str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter");
          if ("1".equals(str2))
          {
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_gender")) {
              break label791;
            }
            str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time")) {
              break label798;
            }
            str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
              break label805;
            }
            str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_xingzuo")) {
              break label812;
            }
            str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_xingzuo");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_interest")) {
              break label819;
            }
            str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_interest");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
              break label826;
            }
            str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
              break label833;
            }
            str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_location");
          }
        }
      }
      catch (Exception localException6)
      {
        try
        {
          i1 = Integer.valueOf(str4).intValue();
        }
        catch (Exception localException6)
        {
          try
          {
            i2 = Integer.valueOf(str5).intValue();
          }
          catch (Exception localException6)
          {
            try
            {
              i3 = Integer.valueOf(str6).intValue();
            }
            catch (Exception localException6)
            {
              try
              {
                i4 = Integer.valueOf(str7).intValue();
              }
              catch (Exception localException6)
              {
                try
                {
                  i5 = Integer.valueOf(str9).intValue();
                }
                catch (Exception localException6)
                {
                  try
                  {
                    for (;;)
                    {
                      i6 = Integer.valueOf(str8).intValue();
                      localIntent.putExtra("filter", str2);
                      localIntent.putExtra("filterGender", i1);
                      localIntent.putExtra("filter_time", i2);
                      localIntent.putExtra("filter_age", i3);
                      localIntent.putExtra("filter_xingzuo", i4);
                      localIntent.putExtra("filter_interest", i6);
                      localIntent.putExtra("filter_career", i5);
                      localIntent.putExtra("filter_location", str10);
                      localIntent.addFlags(67108864);
                      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
                        localIntent.addFlags(268435456);
                      }
                      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
                      if ("100".equals(str1)) {
                        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007244", "0X8007244", 0, 0, "", "", "", "");
                      }
                      return true;
                      str2 = "";
                      break;
                      str4 = "";
                      break label107;
                      label758:
                      str5 = "";
                      break label135;
                      label765:
                      str1 = "";
                      break label163;
                      localException1 = localException1;
                      localException1.printStackTrace();
                      int i1 = 0;
                      continue;
                      String str3 = "";
                      continue;
                      label791:
                      str4 = "";
                      continue;
                      label798:
                      str5 = "";
                      continue;
                      label805:
                      String str6 = "";
                      continue;
                      label812:
                      String str7 = "";
                      continue;
                      label819:
                      String str8 = "";
                      continue;
                      label826:
                      String str9 = "";
                      continue;
                      label833:
                      String str10 = "";
                      continue;
                      localException2 = localException2;
                      i1 = 0;
                      continue;
                      localException3 = localException3;
                      int i2 = 3;
                      continue;
                      localException4 = localException4;
                      int i3 = 0;
                      continue;
                      localException5 = localException5;
                      int i4 = 0;
                      continue;
                      localException6 = localException6;
                      int i5 = 0;
                    }
                  }
                  catch (Exception localException7)
                  {
                    for (;;)
                    {
                      int i6 = 0;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private int a()
  {
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("env"))) {
      return Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("env")).intValue();
    }
    return 0;
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
  
  private Class a()
  {
    ILoginRegisterApi localILoginRegisterApi = a();
    Class localClass = localILoginRegisterApi.getRegisterPhoneNumActivityClass();
    int i1 = BaseApplicationImpl.getApplication().appActivities.size() - 1;
    while (i1 >= 0)
    {
      Object localObject = (WeakReference)BaseApplicationImpl.getApplication().appActivities.get(i1);
      if (localObject != null) {
        localObject = (AppActivity)((WeakReference)localObject).get();
      }
      while (localObject != null)
      {
        localObject = ((Activity)localObject).getLocalClassName();
        if ("activity.RegisterPersonalInfoActivity".equals(localObject))
        {
          return localILoginRegisterApi.getRegisterPersonalInfoActivityClass();
          localObject = null;
        }
        else
        {
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
      }
      i1 -= 1;
    }
    return localClass;
  }
  
  private String a(String paramString)
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
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return paramString1;
    }
    try
    {
      String str = URLEncoder.encode(paramString3, "UTF-8");
      paramString3 = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    if (paramString1.contains(paramString2)) {
      return paramString1.replace(paramString2, paramString3);
    }
    return paramString1.replace(paramString2.toUpperCase(), paramString3);
  }
  
  private void a()
  {
    String str1 = b("payurl");
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = new String(Base64.decode(str1, 0));
      if (!TextUtils.isEmpty(str2))
      {
        QLog.e("JumpAction", 1, "payurl is call to launch");
        VasH5PayUtil.a(this.jdField_a_of_type_AndroidContentContext, str2);
        return;
      }
      QLog.e("JumpAction", 1, "payurl cant not decode to base64 =" + str1);
      return;
    }
    QLog.e("JumpAction", 1, "payurl is null");
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setData(Uri.parse("midas://open_modify_status?status=" + paramInt));
    if (this.jdField_a_of_type_AndroidContentContext.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).finish();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("qidian")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("qidian");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        i1 = Integer.valueOf(str1).intValue();
        if (i1 == 1)
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("jsondata"))
          {
            str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jsondata");
            ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(str1, paramInt1, paramInt2);
          }
        }
        else
        {
          return;
          str1 = "";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i1 = 0;
          continue;
          String str2 = "";
        }
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "wrapper Intent failed intent is null or redTouchInfo is Empty");
      }
      return;
    }
    paramIntent.putExtra("redTouch", this.jdField_h_of_type_JavaLangString);
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "wpaParamsParse---Start");
    }
    int i1;
    if (this.jdField_a_of_type_JavaUtilHashMap.get("paramencrypted_type") == null)
    {
      i1 = 0;
      paramIntent.putExtra("from3rdApp", true);
      if (i1 != 1) {
        break label237;
      }
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "params must be decrypted");
        }
        paramString = Base64Util.decode(new Cryptor().decrypt(HexUtil.hexStr2Bytes(paramString), "Hf7K(s*js12LiskW".getBytes()), 0);
        if (paramString == null) {
          break label290;
        }
        paramString = new JSONObject(new String(paramString));
        boolean bool1 = bool2;
        if (paramString.has("layout"))
        {
          bool1 = bool2;
          if (paramString.getString("layout") != null) {
            bool1 = true;
          }
        }
        paramIntent.putExtra("showFirstStructMsg", bool1);
        if (paramString != null)
        {
          paramString = ChatActivityUtils.a(paramString);
          paramIntent.putExtra("stuctmsg_bytes", paramString);
          if ((paramString != null) && (i1 == 1)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), "0X8004B50", "0X8004B50", 0, 0, "", "", "", "");
          }
        }
        return;
      }
      catch (JSONException paramIntent)
      {
        label237:
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.e("JumpAction", 4, "wpaParamsParse---JSONException");
        return;
      }
      i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("paramencrypted_type"));
      break;
      paramIntent.putExtra("fromSencondhandCommunity", true);
      paramString = new JSONObject(paramString);
      paramIntent.putExtra("gid", paramString.getString("gid"));
      continue;
      label290:
      paramString = null;
    }
  }
  
  @Deprecated
  public static void a(Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("key_launch_time");
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("plugin_tag", 1, "call jumpToVideoStoryLayer timedelay=" + (l2 - l1));
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
    localIntent.setFlags(268435456);
    localIntent.putExtras(paramBundle);
    BaseApplicationImpl.getContext().startActivity(localIntent);
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
  
  private void a(String paramString)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    if ("app".equals(str)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if ("web".equals(str))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
        return;
      }
    } while (!"scan".equals(str));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
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
  
  /* Error */
  private boolean a(Intent paramIntent, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ldc_w 1834
    //   7: invokevirtual 1837	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   10: ifne +14 -> 24
    //   13: aload_1
    //   14: ldc_w 1834
    //   17: invokestatic 760	java/lang/System:currentTimeMillis	()J
    //   20: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   23: pop
    //   24: ldc_w 1839
    //   27: aload_0
    //   28: getfield 1841	com/tencent/mobileqq/utils/JumpAction:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   31: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +467 -> 501
    //   37: iconst_1
    //   38: istore 8
    //   40: aload_1
    //   41: ldc_w 1843
    //   44: iload 8
    //   46: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   49: pop
    //   50: aload_0
    //   51: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   54: ifnull +346 -> 400
    //   57: aload_0
    //   58: getfield 58	com/tencent/mobileqq/utils/JumpAction:jdField_d_of_type_Boolean	Z
    //   61: ifeq +339 -> 400
    //   64: aload_0
    //   65: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   68: getfield 1851	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   71: invokevirtual 1855	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   74: sipush 769
    //   77: if_icmpne +323 -> 400
    //   80: aload_0
    //   81: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   84: getfield 1858	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   87: invokevirtual 1855	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   90: istore 6
    //   92: aload_0
    //   93: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   96: ldc_w 1860
    //   99: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 45	java/lang/String
    //   105: invokestatic 121	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: istore 4
    //   110: aload_0
    //   111: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: invokevirtual 713	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   117: ldc_w 1862
    //   120: iconst_0
    //   121: invokevirtual 719	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   124: astore 9
    //   126: aload 9
    //   128: new 125	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 1864
    //   138: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   148: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: iconst_0
    //   155: invokeinterface 1868 3 0
    //   160: istore 7
    //   162: aload 9
    //   164: invokeinterface 1872 1 0
    //   169: new 125	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 1864
    //   179: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   186: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   189: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: iconst_0
    //   196: invokeinterface 1877 3 0
    //   201: invokeinterface 1880 1 0
    //   206: pop
    //   207: aload_0
    //   208: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   211: getfield 1884	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   214: invokevirtual 1888	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   217: ifeq +310 -> 527
    //   220: new 1068	org/json/JSONObject
    //   223: dup
    //   224: aload_0
    //   225: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   228: getfield 1884	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   231: invokevirtual 1890	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   234: invokespecial 1077	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   237: astore 9
    //   239: aload_0
    //   240: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   243: getfield 1894	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   246: invokevirtual 1897	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   249: ifeq +278 -> 527
    //   252: aload_0
    //   253: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   256: getfield 1894	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   259: invokevirtual 1899	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   262: ifne +265 -> 527
    //   265: ldc_w 554
    //   268: aload 9
    //   270: ldc_w 1901
    //   273: invokevirtual 1905	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   276: aload_0
    //   277: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   280: getfield 1894	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   283: iconst_0
    //   284: invokevirtual 1906	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   287: checkcast 45	java/lang/String
    //   290: invokevirtual 1905	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   293: ldc_w 1908
    //   296: invokevirtual 1725	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   299: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: istore 8
    //   304: iload 8
    //   306: ifeq +221 -> 527
    //   309: aload_1
    //   310: ldc_w 1910
    //   313: iload 5
    //   315: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   318: pop
    //   319: aload_1
    //   320: ldc_w 1912
    //   323: iload 6
    //   325: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   328: pop
    //   329: aload_1
    //   330: ldc_w 1914
    //   333: iload 7
    //   335: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   338: pop
    //   339: aload_1
    //   340: ldc_w 1916
    //   343: iload 4
    //   345: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   348: pop
    //   349: aload_0
    //   350: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   353: getfield 1894	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   356: invokevirtual 1897	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   359: ifeq +41 -> 400
    //   362: aload_0
    //   363: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   366: getfield 1894	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   369: invokevirtual 1899	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   372: ifne +28 -> 400
    //   375: aload_1
    //   376: ldc_w 1918
    //   379: new 1538	java/util/ArrayList
    //   382: dup
    //   383: aload_0
    //   384: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   387: getfield 1894	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   390: invokevirtual 1921	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   393: invokespecial 1924	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   396: invokevirtual 1928	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   399: pop
    //   400: aload_1
    //   401: ldc_w 1930
    //   404: aload_0
    //   405: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   408: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   411: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   414: pop
    //   415: aload_1
    //   416: ldc_w 1932
    //   419: iconst_1
    //   420: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   423: pop
    //   424: aload_1
    //   425: ldc_w 1934
    //   428: iconst_1
    //   429: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   432: pop
    //   433: aload_1
    //   434: ldc_w 1936
    //   437: aload_0
    //   438: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   441: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   444: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   447: pop
    //   448: aload_1
    //   449: ldc_w 1938
    //   452: ldc_w 1940
    //   455: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   458: pop
    //   459: aload_0
    //   460: aload_1
    //   461: invokespecial 1941	com/tencent/mobileqq/utils/JumpAction:a	(Landroid/content/Intent;)V
    //   464: aload_1
    //   465: aload_0
    //   466: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   469: aload_2
    //   470: invokevirtual 1944	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   473: pop
    //   474: aload_0
    //   475: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   478: aload_1
    //   479: invokevirtual 228	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   482: ldc_w 1946
    //   485: aload_3
    //   486: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   489: ifne +44 -> 533
    //   492: aload_0
    //   493: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   496: invokestatic 1952	cooperation/qwallet/plugin/impl/QWalletHelperImpl:preloadQWallet	(Lcom/tencent/common/app/AppInterface;)V
    //   499: iconst_1
    //   500: ireturn
    //   501: iconst_0
    //   502: istore 8
    //   504: goto -464 -> 40
    //   507: astore 9
    //   509: aload 9
    //   511: invokevirtual 1227	java/lang/Exception:printStackTrace	()V
    //   514: iconst_0
    //   515: istore 4
    //   517: goto -407 -> 110
    //   520: astore 9
    //   522: aload 9
    //   524: invokevirtual 1227	java/lang/Exception:printStackTrace	()V
    //   527: iconst_1
    //   528: istore 5
    //   530: goto -221 -> 309
    //   533: new 1954	com/tencent/mobileqq/utils/JumpAction$27
    //   536: dup
    //   537: aload_0
    //   538: invokespecial 1955	com/tencent/mobileqq/utils/JumpAction$27:<init>	(Lcom/tencent/mobileqq/utils/JumpAction;)V
    //   541: iconst_5
    //   542: aconst_null
    //   543: iconst_1
    //   544: invokestatic 609	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   547: iconst_1
    //   548: ireturn
    //   549: astore_1
    //   550: iconst_1
    //   551: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	JumpAction
    //   0	552	1	paramIntent	Intent
    //   0	552	2	paramString1	String
    //   0	552	3	paramString2	String
    //   108	408	4	i1	int
    //   1	528	5	i2	int
    //   90	234	6	i3	int
    //   160	174	7	i4	int
    //   38	465	8	bool	boolean
    //   124	145	9	localObject	Object
    //   507	3	9	localException1	Exception
    //   520	3	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   92	110	507	java/lang/Exception
    //   220	304	520	java/lang/Exception
    //   474	499	549	java/lang/Exception
    //   533	547	549	java/lang/Exception
  }
  
  private boolean a(JumpAction.AsyncShareCallback paramAsyncShareCallback)
  {
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_uri"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_uri"));
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      QLog.d("JumpAction", 1, new Object[] { "imageUrl=", str1, ", imageUri=", str2 });
      this.jdField_f_of_type_Boolean = false;
      ThreadManagerV2.executeOnSubThread(new JumpAction.28(this, str2, System.currentTimeMillis(), paramAsyncShareCallback));
      return false;
    }
    if ((!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str3)))
    {
      QLog.d("JumpAction", 1, new Object[] { "fileUri=", str4, ", fileData=", str3 });
      this.jdField_f_of_type_Boolean = false;
      ThreadManagerV2.executeOnSubThread(new JumpAction.29(this, str4, System.currentTimeMillis(), paramAsyncShareCallback));
      return false;
    }
    return paramAsyncShareCallback.a();
  }
  
  private boolean a(Runnable paramRunnable, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_f_of_type_Boolean = false;
    ThreadManagerV2.executeOnSubThread(new JumpAction.10(this, paramString1, System.currentTimeMillis(), paramString2, paramString3, paramRunnable));
    return true;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 13);
    localBundle.putString("viewParam", paramString1);
    if (paramString2 != null) {
      localBundle.putString("entry", paramString2);
    }
    paramString1 = new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class);
    paramString1.putExtra("srvBundle", localBundle);
    if (paramLong != 0L) {
      paramString1.putExtra("vacreport_key_seq", paramLong);
    }
    paramString1.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=10&entry=" + paramString2 + "&seq=" + paramLong));
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
    QWalletPayBridge.launchForeground((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle);
    return true;
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    String str10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_program_appid"));
    String str11 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_program_path"));
    if (this.jdField_a_of_type_JavaUtilHashMap.get("mini_program_type") != null) {}
    for (int i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_program_type"))).intValue();; i1 = 3)
    {
      int i3 = 0;
      long l1;
      int i4;
      try
      {
        l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
        if (l1 <= 0L) {
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          l1 = 0L;
        }
        i4 = 1;
      }
      try
      {
        i2 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          for (;;)
          {
            i3 = Integer.valueOf((String)localObject2).intValue();
            if (localObject1 != null) {
              break label1073;
            }
            localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
            localObject2 = new ArrayList();
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            localObject1 = ((String)localObject1).split(";");
            i4 = 0;
            while (i4 < localObject1.length)
            {
              ((ArrayList)localObject2).add(URLDecoder.decode(localObject1[i4]));
              i4 += 1;
            }
            localNumberFormatException2 = localNumberFormatException2;
            i2 = i3;
            if (QLog.isColorLevel())
            {
              QLog.d("QzoneShare", 2, "NumberFormatException extFlags = 0");
              i2 = i3;
            }
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          label1073:
          for (;;)
          {
            int i2;
            i3 = i4;
            if (QLog.isColorLevel())
            {
              QLog.d("QzoneShare", 2, "NumberFormatException req_type = 1");
              i3 = i4;
              continue;
              if ((localNumberFormatException1 != null) && (localNumberFormatException1.size() > 0)) {}
              for (localObject1 = (String)localNumberFormatException1.get(0);; localObject1 = "")
              {
                Bundle localBundle = new Bundle();
                localBundle.putString("title", str2);
                localBundle.putString("desc", str3);
                localBundle.putString("app_name", str5);
                localBundle.putLong("req_share_id", l1);
                localBundle.putString("detail_url", str4);
                localBundle.putStringArrayList("image_url", localNumberFormatException1);
                localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
                localBundle.putString("open_id", str1);
                localBundle.putString("share_uin", str7);
                localBundle.putString("jfrom", str8);
                localBundle.putString("share_qq_ext_str", str9);
                localBundle.putInt("cflag", i2);
                localBundle.putString("share_action", paramString);
                localBundle.putInt("iUrlInfoFrm", 4);
                localBundle.putBoolean("thirdPartShare", true);
                if ((!TextUtils.isEmpty(str10)) && (!TextUtils.isEmpty(str11)))
                {
                  localBundle.putBoolean("is_share_mini_app_msg", true);
                  localBundle.putString("share_mini_app_id", str10);
                  localBundle.putString("share_mini_app_path", str11);
                  localBundle.putInt("share_mini_ver_type", i1);
                  localBundle.putString("share_mini_image_url", (String)localObject1);
                }
                if (i3 == 2) {
                  localBundle.putString("audio_url", str6);
                }
                localBundle.putInt("req_type", i3);
                com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
                paramString = new JumpAction.24(this);
                localBundle.putBoolean("key_require_storage_permission", paramBoolean);
                if ((i3 == 5) && ((i2 & 0x1) != 0)) {
                  QZoneShareManager.jumpToQzoneShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localBundle, paramString, 23);
                }
                for (;;)
                {
                  if (i3 == 1) {
                    paramString = "1";
                  }
                  try
                  {
                    for (;;)
                    {
                      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str1, String.valueOf(l1), "11", "12", "0", paramString, "0", "0", false, true);
                      label858:
                      paramString = new QZoneClickReport.ReportInfo();
                      paramString.actionType = "1";
                      paramString.subactionType = "0";
                      paramString.tabletype = 4;
                      paramString.sourceType = "5";
                      paramString.sourceFrom = "thirdApp";
                      paramString.sourceTo = "activefeed";
                      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString);
                      paramString = new HashMap();
                      paramString.put("source_type", "5");
                      paramString.put("source_from", "thirdApp");
                      paramString.put("source_to", "activefeed");
                      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramString, null);
                      if ((!this.jdField_f_of_type_Boolean) && ((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
                        ((JumpActivity)this.jdField_a_of_type_AndroidContentContext).finish();
                      }
                      return true;
                      QZoneShareManager.jumpToQzoneShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localBundle, paramString);
                      break;
                      if (i3 == 2) {
                        paramString = "3";
                      } else if (i3 == 5) {
                        paramString = "2";
                      } else {
                        paramString = "4";
                      }
                    }
                  }
                  catch (Exception paramString)
                  {
                    break label858;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean a(Map<String, String> paramMap, boolean paramBoolean)
  {
    String str1 = (String)paramMap.get("userid");
    String str2 = (String)paramMap.get("usertype");
    String str3 = (String)paramMap.get("unionid");
    String str4 = (String)paramMap.get("storyid");
    String str5 = (String)paramMap.get("showinfocard");
    b(paramMap);
    if (((str5 == null) || (!str5.equals("0"))) || (TextUtils.isEmpty(str4)))
    {
      if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
        return false;
      }
      try
      {
        int i1 = Integer.parseInt(str2);
        if (i1 == 1)
        {
          if (TextUtils.isEmpty(str1)) {
            return false;
          }
          StoryApi.a(this.jdField_a_of_type_AndroidContentContext, 23, str3);
        }
        for (;;)
        {
          return true;
          if (i1 != 5) {}
        }
        return true;
      }
      catch (NumberFormatException paramMap)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, userId:" + str1 + ", userType:" + str2);
        }
        return false;
      }
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject1 = new Bundle();
    long l1;
    int i2;
    try
    {
      l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
      if (l1 <= 0L) {
        return false;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        l1 = 0L;
      }
      str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qzone_ext_str"));
      ((Bundle)localObject1).putString("open_id", str);
      ((Bundle)localObject1).putString("share_uin", (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((Bundle)localObject1).putString("share_ext_string", (String)localObject3);
      }
      i2 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"))).intValue();
      if (i2 != 3) {
        break label625;
      }
    }
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    Object localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    Object localObject2 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = ((String)localObject3).split(";");
      int i1 = 0;
      while (i1 < localObject3.length)
      {
        ((ArrayList)localObject2).add(URLDecoder.decode(localObject3[i1]));
        i1 += 1;
      }
    }
    ((Bundle)localObject1).putStringArrayList("images", (ArrayList)localObject2);
    ((Bundle)localObject1).putString("summary", str);
    for (str = "7";; str = "") {
      for (;;)
      {
        ((Bundle)localObject1).putString("app_name", c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")));
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          ((Bundle)localObject1).putString("hulian_appid", String.valueOf(l1));
        }
        ((Bundle)localObject1).putInt("req_type", i2);
        ((Bundle)localObject1).putLong("req_share_id", l1);
        ((Bundle)localObject1).putString("pkg_name", this.jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putBoolean("key_need_save_draft", false);
        ((Bundle)localObject1).putBoolean("key_require_storage_permission", paramBoolean);
        com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
        localObject2 = new JumpAction.22(this);
        QZoneShareManager.publishToQzone(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, (DialogInterface.OnDismissListener)localObject2);
        localObject2 = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject2).actionType = "1";
        ((QZoneClickReport.ReportInfo)localObject2).subactionType = "0";
        ((QZoneClickReport.ReportInfo)localObject2).tabletype = 4;
        ((QZoneClickReport.ReportInfo)localObject2).sourceType = "5";
        ((QZoneClickReport.ReportInfo)localObject2).sourceFrom = "thirdApp";
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("source_type", "5");
        ((HashMap)localObject3).put("source_from", "thirdApp");
        localObject1 = ((Bundle)localObject1).getStringArrayList("images");
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 9))
        {
          ((QZoneClickReport.ReportInfo)localObject2).sourceTo = "QZoneUploadPhotosActivity";
          ((HashMap)localObject3).put("source_to", "QZoneUploadPhotosActivity");
          QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject2);
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject3, null);
          ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", l1 + "", "11", "12", "0", str, "", "4", false);
          return true;
          label625:
          if (i2 == 4) {
            str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoPath"));
          }
        }
        else
        {
          try
          {
            ((Bundle)localObject1).putLong("file_send_duration", Long.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoDuration"))).longValue());
            try
            {
              label678:
              ((Bundle)localObject1).putLong("PhotoConst.VIDEO_SIZE", Long.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoSize"))).longValue());
              label708:
              localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
              ((Bundle)localObject1).putBoolean("PhotoConst.IS_VIDEO_SELECTED", true);
              ((Bundle)localObject1).putInt("PhotoConst.VIDEO_TYPE", 1);
              ((Bundle)localObject1).putString("file_send_path", str);
              ((Bundle)localObject1).putBoolean("need_process", false);
              ((Bundle)localObject1).putString("defaultText", (String)localObject2);
              str = "8";
              continue;
              ((QZoneClickReport.ReportInfo)localObject2).sourceTo = "QZonePublishMoodActivity";
              ((HashMap)localObject3).put("source_to", "QZonePublishMoodActivity");
            }
            catch (Exception localException2)
            {
              break label708;
            }
          }
          catch (Exception localException3)
          {
            break label678;
          }
        }
      }
    }
  }
  
  private boolean aA()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || (str.length() < 6)) {
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
    return aP();
  }
  
  private boolean aB()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lon");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lat");
    if ((str != null) && (localObject != null)) {}
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt(str.trim());
        i1 = Integer.parseInt(((String)localObject).trim());
        str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class);
        ((Intent)localObject).putExtra("ENTER_TIME", System.currentTimeMillis());
        ((Intent)localObject).putExtra("lat", i1);
        ((Intent)localObject).putExtra("lon", i2);
        ((Intent)localObject).putExtra("filter", 0);
        if (str != null) {
          ((Intent)localObject).putExtra("title", str);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        return true;
      }
      catch (Exception localException)
      {
        return false;
      }
      int i1 = 0;
      int i2 = 0;
    }
  }
  
  private boolean aC()
  {
    NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private boolean aD()
  {
    if ((String)this.jdField_a_of_type_JavaUtilHashMap.get("back_title") == null) {
      HardCodeUtil.a(2131705933);
    }
    TroopCreateLogic localTroopCreateLogic = (TroopCreateLogic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_TROOP_CREATE);
    if (localTroopCreateLogic != null) {
      localTroopCreateLogic.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 0);
    }
    return true;
  }
  
  /* Error */
  private boolean aE()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 2289
    //   7: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 45	java/lang/String
    //   13: astore 6
    //   15: aload_0
    //   16: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: ldc_w 2291
    //   22: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 45	java/lang/String
    //   28: astore 7
    //   30: aload 6
    //   32: ifnull +139 -> 171
    //   35: aload 7
    //   37: ifnull +134 -> 171
    //   40: aload 6
    //   42: invokevirtual 2294	java/lang/String:trim	()Ljava/lang/String;
    //   45: invokestatic 121	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   48: i2d
    //   49: ldc2_w 2320
    //   52: ddiv
    //   53: dstore_1
    //   54: aload 7
    //   56: invokevirtual 2294	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 121	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: istore 5
    //   64: iload 5
    //   66: i2d
    //   67: ldc2_w 2320
    //   70: ddiv
    //   71: dstore_3
    //   72: aload_0
    //   73: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   76: ldc_w 2036
    //   79: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 45	java/lang/String
    //   85: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   88: pop
    //   89: new 125	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 2323
    //   99: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: dload_3
    //   103: invokevirtual 2326	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   106: ldc_w 2328
    //   109: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: dload_1
    //   113: invokevirtual 2326	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   116: ldc_w 2330
    //   119: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 6
    //   127: new 146	android/content/Intent
    //   130: dup
    //   131: ldc_w 1629
    //   134: aload 6
    //   136: invokestatic 1587	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   139: invokespecial 2333	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   142: astore 7
    //   144: aload 7
    //   146: ldc_w 2335
    //   149: ldc_w 2337
    //   152: invokevirtual 1829	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: aload_0
    //   157: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   160: aload 7
    //   162: invokevirtual 228	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   165: iconst_1
    //   166: ireturn
    //   167: astore 6
    //   169: iconst_0
    //   170: ireturn
    //   171: iconst_0
    //   172: ireturn
    //   173: astore 7
    //   175: aload_0
    //   176: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   179: new 146	android/content/Intent
    //   182: dup
    //   183: ldc_w 1629
    //   186: aload 6
    //   188: invokestatic 1587	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   191: invokespecial 2333	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   194: invokevirtual 228	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   197: goto -32 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	JumpAction
    //   53	60	1	d1	double
    //   71	32	3	d2	double
    //   62	3	5	i1	int
    //   13	122	6	str	String
    //   167	20	6	localException	Exception
    //   28	133	7	localObject	Object
    //   173	1	7	localActivityNotFoundException	android.content.ActivityNotFoundException
    // Exception table:
    //   from	to	target	type
    //   40	64	167	java/lang/Exception
    //   156	165	173	android/content/ActivityNotFoundException
  }
  
  private boolean aF()
  {
    if ("webview".equals(this.jdField_d_of_type_JavaLangString))
    {
      c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "select_location").putExtra("doCallBack", true).putExtra("src_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type")).putExtra("callback_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type")).putExtra("callback_name", (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name")));
    }
    return true;
  }
  
  private boolean aG()
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
      return aP();
    }
    if ("groupsearchsetting".equalsIgnoreCase(str1)) {
      return aN();
    }
    if ("groupmanager".equalsIgnoreCase(str1)) {
      return aO();
    }
    if ("public_account".equals(str1))
    {
      a(10003, a());
      return aI();
    }
    if ("troopmember".equals(str1)) {
      return aR();
    }
    if ("crm".equals(str1)) {
      return aJ();
    }
    if ("nearby".equals(str1)) {
      return aH();
    }
    if ("allpeoplevote".equals(str1)) {
      return aK();
    }
    if ("troopmemberfromhb".equals(str1)) {
      return aT();
    }
    if ("groupsetting".equals(str1)) {
      return aS();
    }
    a(10002, a());
    return aL();
  }
  
  /* Error */
  private boolean aH()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 2422
    //   7: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +329 -> 339
    //   13: aload_0
    //   14: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   17: ldc_w 2422
    //   20: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 45	java/lang/String
    //   26: astore 12
    //   28: aload_0
    //   29: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   32: ldc_w 2424
    //   35: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   38: ifeq +308 -> 346
    //   41: aload_0
    //   42: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   45: ldc_w 2424
    //   48: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 45	java/lang/String
    //   54: astore 11
    //   56: lconst_0
    //   57: lstore 5
    //   59: aload_0
    //   60: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   63: ldc_w 2426
    //   66: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   69: ifeq +1264 -> 1333
    //   72: ldc_w 301
    //   75: aload_0
    //   76: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   79: ldc_w 2426
    //   82: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq +1245 -> 1333
    //   91: iconst_1
    //   92: istore 9
    //   94: lload 5
    //   96: lstore 7
    //   98: aload_0
    //   99: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   102: ldc_w 2428
    //   105: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   108: ifeq +24 -> 132
    //   111: aload_0
    //   112: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   115: ldc_w 2428
    //   118: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: checkcast 45	java/lang/String
    //   124: invokestatic 286	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   127: invokevirtual 290	java/lang/Long:longValue	()J
    //   130: lstore 7
    //   132: aload_0
    //   133: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   136: ldc_w 2430
    //   139: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   142: ifeq +240 -> 382
    //   145: aload_0
    //   146: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   149: ldc_w 2430
    //   152: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: checkcast 45	java/lang/String
    //   158: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   161: invokevirtual 883	java/lang/Integer:intValue	()I
    //   164: istore_1
    //   165: aload_0
    //   166: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   169: ldc_w 2432
    //   172: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   175: ifeq +212 -> 387
    //   178: aload_0
    //   179: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   182: ldc_w 2432
    //   185: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   188: checkcast 45	java/lang/String
    //   191: astore 13
    //   193: aload 13
    //   195: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: istore 10
    //   200: iload 10
    //   202: ifeq +192 -> 394
    //   205: lconst_0
    //   206: lstore 5
    //   208: aload_0
    //   209: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   212: ldc_w 975
    //   215: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   218: ifeq +197 -> 415
    //   221: aload_0
    //   222: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   225: ldc_w 975
    //   228: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   231: checkcast 45	java/lang/String
    //   234: astore 13
    //   236: aload 13
    //   238: invokestatic 121	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   241: istore_2
    //   242: aload_0
    //   243: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   246: ldc_w 2434
    //   249: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   252: ifeq +177 -> 429
    //   255: aload_0
    //   256: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   259: ldc_w 2434
    //   262: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   265: checkcast 45	java/lang/String
    //   268: astore 13
    //   270: aload 13
    //   272: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   275: invokevirtual 883	java/lang/Integer:intValue	()I
    //   278: istore_3
    //   279: aload_0
    //   280: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   283: ldc_w 2436
    //   286: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   289: ifeq +154 -> 443
    //   292: aload_0
    //   293: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   296: ldc_w 2436
    //   299: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   302: checkcast 45	java/lang/String
    //   305: astore 13
    //   307: aload 13
    //   309: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   312: invokevirtual 883	java/lang/Integer:intValue	()I
    //   315: istore 4
    //   317: iload_3
    //   318: iconst_1
    //   319: if_icmpeq +140 -> 459
    //   322: iload_3
    //   323: iconst_2
    //   324: if_icmpeq +135 -> 459
    //   327: iload_3
    //   328: iconst_3
    //   329: if_icmpeq +130 -> 459
    //   332: iload_3
    //   333: iconst_4
    //   334: if_icmpeq +125 -> 459
    //   337: iconst_0
    //   338: ireturn
    //   339: ldc 60
    //   341: astore 12
    //   343: goto -315 -> 28
    //   346: ldc 60
    //   348: astore 11
    //   350: goto -294 -> 56
    //   353: astore 13
    //   355: ldc 123
    //   357: iconst_1
    //   358: ldc_w 2438
    //   361: invokestatic 600	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: lload 5
    //   366: lstore 7
    //   368: goto -236 -> 132
    //   371: astore 13
    //   373: ldc 123
    //   375: iconst_1
    //   376: ldc_w 2440
    //   379: invokestatic 600	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: iconst_0
    //   383: istore_1
    //   384: goto -219 -> 165
    //   387: ldc 60
    //   389: astore 13
    //   391: goto -198 -> 193
    //   394: aload 13
    //   396: invokestatic 286	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   399: invokevirtual 290	java/lang/Long:longValue	()J
    //   402: lstore 5
    //   404: goto -196 -> 208
    //   407: astore 13
    //   409: lconst_0
    //   410: lstore 5
    //   412: goto -204 -> 208
    //   415: ldc 60
    //   417: astore 13
    //   419: goto -183 -> 236
    //   422: astore 13
    //   424: iconst_0
    //   425: istore_2
    //   426: goto -184 -> 242
    //   429: ldc 60
    //   431: astore 13
    //   433: goto -163 -> 270
    //   436: astore 13
    //   438: iconst_m1
    //   439: istore_3
    //   440: goto -161 -> 279
    //   443: ldc_w 554
    //   446: astore 13
    //   448: goto -141 -> 307
    //   451: astore 13
    //   453: iconst_0
    //   454: istore 4
    //   456: goto -139 -> 317
    //   459: new 146	android/content/Intent
    //   462: dup
    //   463: aload_0
    //   464: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   467: ldc_w 2442
    //   470: invokespecial 224	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   473: astore 15
    //   475: aload 15
    //   477: ldc_w 2444
    //   480: iload 4
    //   482: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   485: pop
    //   486: aload 15
    //   488: ldc_w 2446
    //   491: iload 9
    //   493: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   496: pop
    //   497: aload 15
    //   499: ldc_w 2428
    //   502: lload 7
    //   504: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   507: pop
    //   508: aload 15
    //   510: ldc_w 2448
    //   513: iload_1
    //   514: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   517: pop
    //   518: iload_3
    //   519: tableswitch	default:+29 -> 548, 1:+31->550, 2:+31->550, 3:+434->953, 4:+693->1212
    //   549: ireturn
    //   550: aload_0
    //   551: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   554: ifnull +106 -> 660
    //   557: aload_0
    //   558: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   561: invokevirtual 177	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   564: astore 11
    //   566: aload 12
    //   568: ldc_w 2450
    //   571: invokestatic 2453	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   574: ifeq +360 -> 934
    //   577: aload_0
    //   578: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   581: ldc_w 2455
    //   584: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   587: ifeq +92 -> 679
    //   590: aload_0
    //   591: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   594: ldc_w 2455
    //   597: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   600: checkcast 45	java/lang/String
    //   603: astore 13
    //   605: aload_0
    //   606: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   609: ldc_w 2457
    //   612: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   615: ifeq +71 -> 686
    //   618: aload_0
    //   619: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   622: ldc_w 2457
    //   625: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   628: checkcast 45	java/lang/String
    //   631: astore 14
    //   633: aload 13
    //   635: aload 11
    //   637: invokestatic 2453	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   640: ifne +53 -> 693
    //   643: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq +12 -> 658
    //   649: ldc 123
    //   651: iconst_2
    //   652: ldc_w 2459
    //   655: invokestatic 600	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: iconst_1
    //   659: ireturn
    //   660: aload_0
    //   661: getfield 2461	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   664: ifnull +662 -> 1326
    //   667: aload_0
    //   668: getfield 2461	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   671: invokevirtual 2464	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   674: astore 11
    //   676: goto -110 -> 566
    //   679: ldc 60
    //   681: astore 13
    //   683: goto -78 -> 605
    //   686: ldc 60
    //   688: astore 14
    //   690: goto -57 -> 633
    //   693: aload 15
    //   695: ldc_w 2457
    //   698: aload 14
    //   700: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   703: pop
    //   704: aload 15
    //   706: ldc_w 2466
    //   709: iconst_m1
    //   710: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   713: pop
    //   714: aload 15
    //   716: ldc_w 1235
    //   719: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   722: pop
    //   723: new 2468	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   726: dup
    //   727: aload 11
    //   729: iconst_0
    //   730: invokespecial 2470	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   733: astore 11
    //   735: iload_2
    //   736: iconst_1
    //   737: if_icmpne +30 -> 767
    //   740: aload 15
    //   742: ldc_w 2466
    //   745: bipush 12
    //   747: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   750: pop
    //   751: aload 11
    //   753: bipush 86
    //   755: putfield 2471	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   758: aload 15
    //   760: ldc_w 1307
    //   763: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   766: pop
    //   767: iload_2
    //   768: iconst_2
    //   769: if_icmpne +19 -> 788
    //   772: aload 11
    //   774: bipush 87
    //   776: putfield 2471	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   779: aload 15
    //   781: ldc_w 1307
    //   784: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   787: pop
    //   788: iload_2
    //   789: iconst_3
    //   790: if_icmpne +19 -> 809
    //   793: aload 11
    //   795: bipush 88
    //   797: putfield 2471	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   800: aload 15
    //   802: ldc_w 1307
    //   805: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   808: pop
    //   809: iload_2
    //   810: bipush 7
    //   812: if_icmplt +29 -> 841
    //   815: aload 15
    //   817: ldc_w 2466
    //   820: iload_2
    //   821: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   824: pop
    //   825: aload 11
    //   827: bipush 86
    //   829: putfield 2471	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   832: aload 15
    //   834: ldc_w 1307
    //   837: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   840: pop
    //   841: aload 15
    //   843: ldc_w 2473
    //   846: iload_3
    //   847: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   850: pop
    //   851: aload 15
    //   853: ldc_w 2475
    //   856: aload 11
    //   858: invokevirtual 2478	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   861: pop
    //   862: aload 12
    //   864: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   867: ifne +80 -> 947
    //   870: aload 12
    //   872: ldc_w 2480
    //   875: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   878: ifeq +69 -> 947
    //   881: iconst_1
    //   882: istore 9
    //   884: aload 15
    //   886: ldc_w 2482
    //   889: iload 9
    //   891: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   894: pop
    //   895: sipush 10002
    //   898: iload_2
    //   899: if_icmpne +12 -> 911
    //   902: aload 15
    //   904: ldc_w 1307
    //   907: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   910: pop
    //   911: aload 15
    //   913: ldc_w 2484
    //   916: lload 5
    //   918: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   921: pop
    //   922: aload_0
    //   923: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   926: aload 15
    //   928: invokevirtual 228	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   931: goto -383 -> 548
    //   934: aload 15
    //   936: ldc_w 2486
    //   939: iconst_1
    //   940: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   943: pop
    //   944: goto -221 -> 723
    //   947: iconst_0
    //   948: istore 9
    //   950: goto -66 -> 884
    //   953: aload_0
    //   954: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   957: ldc_w 772
    //   960: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   963: ifeq +42 -> 1005
    //   966: aload_0
    //   967: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   970: ldc_w 772
    //   973: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   976: checkcast 45	java/lang/String
    //   979: astore 12
    //   981: lload 5
    //   983: lconst_0
    //   984: lcmp
    //   985: ifne +27 -> 1012
    //   988: aload 12
    //   990: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   993: ifeq +19 -> 1012
    //   996: lload 7
    //   998: lconst_0
    //   999: lcmp
    //   1000: ifne +12 -> 1012
    //   1003: iconst_0
    //   1004: ireturn
    //   1005: ldc 60
    //   1007: astore 12
    //   1009: goto -28 -> 981
    //   1012: aload 15
    //   1014: ldc_w 2473
    //   1017: iconst_3
    //   1018: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1021: pop
    //   1022: aload 15
    //   1024: ldc_w 2484
    //   1027: lload 5
    //   1029: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1032: pop
    //   1033: sipush 10002
    //   1036: iload_2
    //   1037: if_icmpne +12 -> 1049
    //   1040: aload 15
    //   1042: ldc_w 1307
    //   1045: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1048: pop
    //   1049: aload 15
    //   1051: ldc_w 2486
    //   1054: iconst_1
    //   1055: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1058: pop
    //   1059: aload 15
    //   1061: ldc_w 2488
    //   1064: aload 11
    //   1066: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1069: pop
    //   1070: new 2468	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   1073: dup
    //   1074: aload 12
    //   1076: bipush 19
    //   1078: invokespecial 2470	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   1081: astore 11
    //   1083: iload_2
    //   1084: iconst_1
    //   1085: if_icmpne +30 -> 1115
    //   1088: aload 15
    //   1090: ldc_w 2466
    //   1093: bipush 12
    //   1095: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1098: pop
    //   1099: aload 11
    //   1101: bipush 86
    //   1103: putfield 2471	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1106: aload 15
    //   1108: ldc_w 1307
    //   1111: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1114: pop
    //   1115: iload_2
    //   1116: iconst_2
    //   1117: if_icmpne +19 -> 1136
    //   1120: aload 11
    //   1122: bipush 87
    //   1124: putfield 2471	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1127: aload 15
    //   1129: ldc_w 1307
    //   1132: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1135: pop
    //   1136: iload_2
    //   1137: iconst_3
    //   1138: if_icmpne +19 -> 1157
    //   1141: aload 11
    //   1143: bipush 88
    //   1145: putfield 2471	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1148: aload 15
    //   1150: ldc_w 1307
    //   1153: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1156: pop
    //   1157: iload_2
    //   1158: bipush 7
    //   1160: if_icmplt +29 -> 1189
    //   1163: aload 15
    //   1165: ldc_w 2466
    //   1168: iload_2
    //   1169: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1172: pop
    //   1173: aload 11
    //   1175: bipush 86
    //   1177: putfield 2471	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1180: aload 15
    //   1182: ldc_w 1307
    //   1185: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1188: pop
    //   1189: aload 15
    //   1191: ldc_w 2475
    //   1194: aload 11
    //   1196: invokevirtual 2478	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1199: pop
    //   1200: aload_0
    //   1201: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1204: aload 15
    //   1206: invokevirtual 228	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1209: goto -661 -> 548
    //   1212: ldc 60
    //   1214: astore 11
    //   1216: aload_0
    //   1217: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1220: ifnull +87 -> 1307
    //   1223: aload_0
    //   1224: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1227: invokevirtual 177	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1230: astore 11
    //   1232: new 2468	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   1235: dup
    //   1236: aload 11
    //   1238: iconst_0
    //   1239: invokespecial 2470	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   1242: astore 11
    //   1244: aload 15
    //   1246: ldc_w 2486
    //   1249: iconst_1
    //   1250: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1253: pop
    //   1254: aload 15
    //   1256: ldc_w 2473
    //   1259: iload_3
    //   1260: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1263: pop
    //   1264: aload 15
    //   1266: ldc_w 2475
    //   1269: aload 11
    //   1271: invokevirtual 2478	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1274: pop
    //   1275: aload 15
    //   1277: ldc_w 1307
    //   1280: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1283: pop
    //   1284: aload 15
    //   1286: ldc_w 2484
    //   1289: lload 5
    //   1291: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1294: pop
    //   1295: aload_0
    //   1296: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1299: aload 15
    //   1301: invokevirtual 228	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1304: goto -756 -> 548
    //   1307: aload_0
    //   1308: getfield 2461	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1311: ifnull -79 -> 1232
    //   1314: aload_0
    //   1315: getfield 2461	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1318: invokevirtual 2464	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1321: astore 11
    //   1323: goto -91 -> 1232
    //   1326: ldc 60
    //   1328: astore 11
    //   1330: goto -764 -> 566
    //   1333: iconst_0
    //   1334: istore 9
    //   1336: goto -1242 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1339	0	this	JumpAction
    //   164	350	1	i1	int
    //   241	928	2	i2	int
    //   278	982	3	i3	int
    //   315	166	4	i4	int
    //   57	1233	5	l1	long
    //   96	901	7	l2	long
    //   92	1243	9	bool1	boolean
    //   198	3	10	bool2	boolean
    //   54	1275	11	localObject	Object
    //   26	1049	12	str1	String
    //   191	117	13	str2	String
    //   353	1	13	localException1	Exception
    //   371	1	13	localException2	Exception
    //   389	6	13	str3	String
    //   407	1	13	localException3	Exception
    //   417	1	13	str4	String
    //   422	1	13	localException4	Exception
    //   431	1	13	str5	String
    //   436	1	13	localException5	Exception
    //   446	1	13	str6	String
    //   451	1	13	localException6	Exception
    //   603	79	13	str7	String
    //   631	68	14	str8	String
    //   473	827	15	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   111	132	353	java/lang/Exception
    //   145	165	371	java/lang/Exception
    //   165	193	407	java/lang/Exception
    //   193	200	407	java/lang/Exception
    //   394	404	407	java/lang/Exception
    //   208	236	422	java/lang/Exception
    //   236	242	422	java/lang/Exception
    //   242	270	436	java/lang/Exception
    //   270	279	436	java/lang/Exception
    //   279	307	451	java/lang/Exception
    //   307	317	451	java/lang/Exception
  }
  
  private boolean aI()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_flag");
    int i1 = -1;
    try
    {
      int i2 = Integer.parseInt((String)localObject2);
      i1 = i2;
    }
    catch (Exception localException)
    {
      label39:
      break label39;
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoShowPublicAccountCard uin: " + (String)localObject1 + " | accountFlag: " + i1 + " | current uin: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    if ((localObject1 == null) || ("".equals(localObject1)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject1))) {
      return false;
    }
    if (((String)localObject1).length() < 5) {
      return false;
    }
    if (m())
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        localObject1 = new ProfileParams.Builder();
        ((ProfileParams.Builder)localObject1).a(new ProfileParams.CurLoginUsr((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"), (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"))).d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")).c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).a(i1).b((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).checkGotoProfileOrShowAcntNotCoherentDlg((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ProfileParams.Builder)localObject1).a());
        return false;
      }
    }
    else
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("source", 117);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfile((Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, i1);
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
    }
    return true;
  }
  
  private boolean aJ()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoShowCrmCard uin: " + str + " | current uin: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    if ((str == null) || ("".equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(str))) {}
    while (str.length() < 5) {
      return false;
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfile(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str, -7);
    return true;
  }
  
  private boolean aK()
  {
    try
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      long l1 = Long.parseLong(str1);
      if (l1 < 10000L)
      {
        if (!QLog.isColorLevel()) {
          break label300;
        }
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard invalid uin uin: %d", new Object[] { Long.valueOf(l1) }));
        return false;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("name");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
      localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str1);
      if (!Utils.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label234;
      }
      localAllInOne1 = new ProfileActivity.AllInOne(str1, 0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2;
        String str3;
        Friends localFriends;
        ProfileActivity.AllInOne localAllInOne1;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard exception : %s", new Object[] { localException.toString() }));
        return false;
        label234:
        ProfileActivity.AllInOne localAllInOne2;
        if ((localFriends != null) && (localFriends.isFriend()))
        {
          localAllInOne2 = new ProfileActivity.AllInOne(str1, 1);
          localAllInOne2.jdField_h_of_type_JavaLangString = localFriends.name;
          localAllInOne2.jdField_i_of_type_JavaLangString = localFriends.remark;
        }
        else
        {
          localAllInOne2 = new ProfileActivity.AllInOne(str1, 95);
          localAllInOne2.jdField_h_of_type_JavaLangString = str2;
        }
      }
    }
    ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, localAllInOne1);
    if (QLog.isDevelopLevel())
    {
      QLog.i("JumpAction", 4, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard uin: %s  name: %s source: %s", new Object[] { Utils.a(str1), Utils.a(str2), str3 }));
      return false;
    }
    label300:
    return false;
  }
  
  private boolean aL()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (Boolean.parseBoolean((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_add_friend"))) {
      return c((String)localObject1);
    }
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpa");
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    boolean bool1 = "1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("track_back"));
    boolean bool2 = "1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("singleTop"));
    boolean bool3 = "1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("group_video_open"));
    if ("internal_phone".equals(localObject3))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007014", "0X8007014", 0, 0, "", "", "", "");
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 53);
      ((ProfileActivity.AllInOne)localObject1).jdField_k_of_type_JavaLangString = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname"));
      ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 105;
      localObject2 = new Bundle();
      localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!b((String)localObject3))) {
        break label720;
      }
    }
    label720:
    for (int i1 = Integer.valueOf((String)localObject3).intValue();; i1 = 0)
    {
      if ((i1 > 0) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msg_uniseq")))
      {
        localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("msg_uniseq");
        if ((i1 == 100) && (Utils.b((String)localObject3)))
        {
          ((Bundle)localObject2).putBoolean("from_babyq", true);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007241", "0X8007241", 0, 0, "", "", "", "");
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("colorScreen")) {
        ((ProfileActivity.AllInOne)localObject1).f = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("colorScreen"));
      }
      ((Bundle)localObject2).putBoolean("key_need_track_back", bool1);
      ((Bundle)localObject2).putBoolean("single_top", bool2);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, String.format("gotoShowPSLCard [%d %b %b]", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, (Bundle)localObject2);
      return true;
      if ((localObject1 == null) || ("".equals(localObject1)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject1)))
      {
        localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        break;
      }
      if (((String)localObject1).length() < 5) {
        return false;
      }
      localObject3 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e((String)localObject1);
      if ((localObject3 != null) && (((Friends)localObject3).isFriend()))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
        ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = ((Friends)localObject3).name;
        ((ProfileActivity.AllInOne)localObject1).jdField_i_of_type_JavaLangString = ((Friends)localObject3).remark;
        break;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 3);
        if ("1".equals(localObject2)) {}
        for (i1 = 1;; i1 = 0)
        {
          ((ProfileActivity.AllInOne)localObject1).d = i1;
          ((ProfileActivity.AllInOne)localObject1).l = 11;
          break;
        }
      }
      if (bool3)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 116);
        break;
      }
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 78);
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("referee");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("flc_recommend_uin", (String)localObject2);
        ((ProfileActivity.AllInOne)localObject1).b.putBundle("flc_extra_param", (Bundle)localObject3);
      }
      break;
    }
  }
  
  private boolean aM()
  {
    boolean bool = false;
    int i2 = 0;
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    int i1 = i2;
    if (str != null)
    {
      i1 = i2;
      if (!"".equals(str))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(str)) {
          break label180;
        }
        i1 = i2;
      }
    }
    for (;;)
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(str, i1);
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PersonalityLabelGalleryActivity.class);
      localIntent.putExtra("personality_label_allinone", localAllInOne);
      localIntent.putExtra("fromType", 1);
      localIntent.putExtra("uin", str);
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoShowPersonalityLabel. uin:" + str);
      }
      bool = true;
      label180:
      do
      {
        return bool;
      } while (str.length() < 5);
      if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str)) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
  
  private boolean aN()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject1 == null) {
        break label270;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label270;
      }
    }
    label270:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "gotoGroupSearchSetting not admin " + str);
        }
        return false;
      }
      Object localObject2 = TroopInfoActivity.a(str, 3);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      localObject2 = new TroopManageCmd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      if (localPluginCommunicationHandler != null) {
        localPluginCommunicationHandler.register((RemoteCommand)localObject2);
      }
      localObject2 = TroopBaseProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, (Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopSearchWayActivity", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupSearchSetting " + str);
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupSearchSetting context not activity");
      }
      return false;
    }
  }
  
  private boolean aO()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject1 == null) {
        break label307;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label307;
      }
    }
    label307:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "gotoGroupManager not admin " + str);
        }
        return false;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("troop_uin", str);
      ((Intent)localObject1).putExtra("key_is_update_before_805", TroopUtils.a(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new TroopManageCmd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      if (localPluginCommunicationHandler != null) {
        localPluginCommunicationHandler.register((RemoteCommand)localObject2);
      }
      localObject2 = TroopBaseProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, (Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopManageActivity", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager " + str);
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager context not activity");
      }
      return false;
    }
  }
  
  private boolean aP()
  {
    boolean bool2 = false;
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wSourceSubID");
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("isPrivate")) {}
    do
    {
      do
      {
        do
        {
          try
          {
            if (Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("isPrivate")).intValue() == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
              ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(str2);
              bool1 = true;
              return bool1;
            }
          }
          catch (Exception localException1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, new Object[] { "gotoShowGroupCard throw Exception ", localException1.toString() });
            }
          }
          bool1 = bool2;
        } while (str2 == null);
        bool1 = bool2;
      } while ("".equals(str2));
      boolean bool1 = bool2;
    } while (str2.length() < 5);
    Object localObject1;
    if ("QRJumpActivity".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from"))) {
      localObject1 = TroopInfoActivity.a(str2, 14);
    }
    for (;;)
    {
      if ("d2g".equals(this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
      {
        localObject1 = TroopInfoActivity.a(str2, 16);
        ((Bundle)localObject1).putInt("D2GType", 2);
      }
      Object localObject3 = localObject1;
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from_group_search"))) {}
      try
      {
        localObject1 = TroopInfoActivity.a(str2, Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from_group_search")));
        if ("h5".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
        {
          localObject1 = TroopInfoActivity.a(str2, 22);
          if ("webapi".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
          {
            if (!"3_40002".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("source_id"))) {
              break label826;
            }
            ((Bundle)localObject1).putInt("troop_info_from_ex", 40002);
          }
        }
        try
        {
          i2 = Integer.parseInt(str1);
          i1 = i2;
          if (i2 == 43) {
            i1 = 10002;
          }
          if (i1 != 33) {
            break label840;
          }
          ((Bundle)localObject1).putInt("troop_info_from", 24);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int i2;
            int i1;
            int i3;
            Object localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("JumpAction", 2, "cast source sub id from web error, sourceSubId = " + str1);
              continue;
              if (i1 == 37)
              {
                ((Bundle)localObject2).putInt("troop_info_from", 30);
              }
              else if (i1 == 10008)
              {
                ((Bundle)localObject2).putInt("troop_info_from", 102);
              }
              else if (i1 == 10013)
              {
                ((Bundle)localObject2).putInt("troop_info_from", 106);
              }
              else if ((i1 >= 30006) && (i1 <= 30020))
              {
                ((Bundle)localObject2).putInt("troop_info_from", i1);
                continue;
                i2 = 0;
                if (i2 != 0)
                {
                  i1 = 30004;
                }
                else
                {
                  i1 = 30006;
                  continue;
                  if (i2 != 0)
                  {
                    i1 = 30004;
                  }
                  else
                  {
                    i1 = 30008;
                    continue;
                    if (i2 != 0)
                    {
                      i1 = 30010;
                    }
                    else
                    {
                      i1 = 30012;
                      continue;
                      if (i2 != 0)
                      {
                        i1 = 30014;
                      }
                      else
                      {
                        i1 = 30016;
                        continue;
                        if (i2 != 0)
                        {
                          i1 = 30018;
                        }
                        else
                        {
                          i1 = 30020;
                          continue;
                          switch (i3)
                          {
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sourceext");
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isexactsearch");
        if ((localObject3 != null) && (str2 != null) && (!((String)localObject3).isEmpty()) && (!str2.isEmpty()))
        {
          i3 = Integer.parseInt((String)localObject3);
          if (Integer.parseInt(str2) == 1)
          {
            i2 = 1;
            break label1077;
            ((Bundle)localObject1).putInt("troop_info_from_ex", i1);
            if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"))) && (Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type")) == 100))
            {
              ((Bundle)localObject1).putBoolean("from_babyq", true);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007245", "0X8007245", 0, 0, "", "", "", "");
            }
            ((Bundle)localObject1).putString("authKey", (String)this.jdField_a_of_type_JavaUtilHashMap.get("authKey"));
            ((Bundle)localObject1).putString("authSig", (String)this.jdField_a_of_type_JavaUtilHashMap.get("authSig"));
            ((Bundle)localObject1).putString("keyword", (String)this.jdField_a_of_type_JavaUtilHashMap.get("keyword"));
            if (QLog.isColorLevel()) {
              QLog.i("JumpAction", 2, String.format("gotoShowGroupCard troop_authSig=%s", new Object[] { this.jdField_a_of_type_JavaUtilHashMap.get("authSig") }));
            }
            if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
              ((Bundle)localObject1).putString("appid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
            }
            if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) {
              ((Bundle)localObject1).putString("openid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid"));
            }
            TroopUtils.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, 2);
            return true;
            localObject1 = TroopInfoActivity.a(str2, 5);
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          localObject2 = localObject3;
          continue;
          if ("groupprofile".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
          {
            localObject2 = TroopInfoActivity.a(str2, 22);
            ((Bundle)localObject2).putBoolean("troop_info_from_troopsetting", true);
          }
          continue;
          label826:
          ((Bundle)localObject2).putInt("troop_info_from_ex", 40001);
          continue;
          label840:
          if (i1 != 43) {
            break;
          }
          ((Bundle)localObject2).putInt("troop_info_from", 27);
        }
      }
    }
  }
  
  private boolean aQ()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((localObject == null) || ("".equals(localObject)) || (((String)localObject).length() < 5)) {
      return false;
    }
    localObject = TroopInfoActivity.a((String)localObject, 14);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
      ((Bundle)localObject).putString("appid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) {
      ((Bundle)localObject).putString("openid", c(m));
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
  
  /* Error */
  private boolean aR()
  {
    // Byte code:
    //   0: ldc 60
    //   2: astore 14
    //   4: ldc 60
    //   6: astore 19
    //   8: ldc 60
    //   10: astore 17
    //   12: ldc 60
    //   14: astore 10
    //   16: ldc 60
    //   18: astore 18
    //   20: aload_0
    //   21: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: ldc_w 1469
    //   27: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 45	java/lang/String
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   38: ldc_w 2796
    //   41: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 45	java/lang/String
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   52: ldc_w 772
    //   55: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: checkcast 45	java/lang/String
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   66: ldc_w 2798
    //   69: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 45	java/lang/String
    //   75: astore 4
    //   77: aload 18
    //   79: astore 12
    //   81: aload 10
    //   83: astore 7
    //   85: aload 17
    //   87: astore 5
    //   89: aload 19
    //   91: astore 15
    //   93: aload 14
    //   95: astore 11
    //   97: aload 18
    //   99: astore 13
    //   101: aload 10
    //   103: astore 8
    //   105: aload 17
    //   107: astore 6
    //   109: aload 19
    //   111: astore 16
    //   113: aload_0
    //   114: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   117: ldc_w 2800
    //   120: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast 45	java/lang/String
    //   126: ldc_w 2802
    //   129: invokestatic 2804	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 9
    //   134: aload 18
    //   136: astore 12
    //   138: aload 10
    //   140: astore 7
    //   142: aload 17
    //   144: astore 5
    //   146: aload 19
    //   148: astore 15
    //   150: aload 9
    //   152: astore 11
    //   154: aload 18
    //   156: astore 13
    //   158: aload 10
    //   160: astore 8
    //   162: aload 17
    //   164: astore 6
    //   166: aload 19
    //   168: astore 16
    //   170: aload 9
    //   172: astore 14
    //   174: aload_0
    //   175: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   178: ldc_w 2806
    //   181: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: checkcast 45	java/lang/String
    //   187: ldc_w 2802
    //   190: invokestatic 2804	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   193: astore 19
    //   195: aload 18
    //   197: astore 12
    //   199: aload 10
    //   201: astore 7
    //   203: aload 17
    //   205: astore 5
    //   207: aload 19
    //   209: astore 15
    //   211: aload 9
    //   213: astore 11
    //   215: aload 18
    //   217: astore 13
    //   219: aload 10
    //   221: astore 8
    //   223: aload 17
    //   225: astore 6
    //   227: aload 19
    //   229: astore 16
    //   231: aload 9
    //   233: astore 14
    //   235: aload_0
    //   236: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   239: ldc_w 2808
    //   242: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   245: checkcast 45	java/lang/String
    //   248: ldc_w 2802
    //   251: invokestatic 2804	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   254: astore 17
    //   256: aload 18
    //   258: astore 12
    //   260: aload 10
    //   262: astore 7
    //   264: aload 17
    //   266: astore 5
    //   268: aload 19
    //   270: astore 15
    //   272: aload 9
    //   274: astore 11
    //   276: aload 18
    //   278: astore 13
    //   280: aload 10
    //   282: astore 8
    //   284: aload 17
    //   286: astore 6
    //   288: aload 19
    //   290: astore 16
    //   292: aload 9
    //   294: astore 14
    //   296: aload_0
    //   297: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   300: ldc_w 2810
    //   303: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast 45	java/lang/String
    //   309: ldc_w 2802
    //   312: invokestatic 2804	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   315: astore 10
    //   317: aload 18
    //   319: astore 12
    //   321: aload 10
    //   323: astore 7
    //   325: aload 17
    //   327: astore 5
    //   329: aload 19
    //   331: astore 15
    //   333: aload 9
    //   335: astore 11
    //   337: aload 18
    //   339: astore 13
    //   341: aload 10
    //   343: astore 8
    //   345: aload 17
    //   347: astore 6
    //   349: aload 19
    //   351: astore 16
    //   353: aload 9
    //   355: astore 14
    //   357: aload_0
    //   358: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   361: ldc_w 2812
    //   364: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   367: checkcast 45	java/lang/String
    //   370: ldc_w 2802
    //   373: invokestatic 2804	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   376: astore 18
    //   378: aload 18
    //   380: astore 12
    //   382: aload 10
    //   384: astore 7
    //   386: aload 17
    //   388: astore 5
    //   390: aload 19
    //   392: astore 15
    //   394: aload 9
    //   396: astore 11
    //   398: aload 18
    //   400: astore 13
    //   402: aload 10
    //   404: astore 8
    //   406: aload 17
    //   408: astore 6
    //   410: aload 19
    //   412: astore 16
    //   414: aload 9
    //   416: astore 14
    //   418: aload_0
    //   419: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   422: ldc_w 2814
    //   425: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   428: checkcast 45	java/lang/String
    //   431: ldc_w 2802
    //   434: invokestatic 2804	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   437: astore 20
    //   439: aload_1
    //   440: astore 7
    //   442: aload 20
    //   444: astore_1
    //   445: aload 17
    //   447: astore 8
    //   449: aload_2
    //   450: astore 6
    //   452: aload 18
    //   454: astore_2
    //   455: aload 10
    //   457: astore 5
    //   459: aload 9
    //   461: astore 11
    //   463: aload 19
    //   465: astore 9
    //   467: aload_3
    //   468: astore 10
    //   470: aload 6
    //   472: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifne +11 -> 486
    //   478: aload 7
    //   480: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifeq +129 -> 612
    //   486: iconst_0
    //   487: ireturn
    //   488: astore 9
    //   490: ldc 60
    //   492: astore 10
    //   494: ldc 60
    //   496: astore_1
    //   497: ldc 60
    //   499: astore_3
    //   500: ldc 60
    //   502: astore 6
    //   504: ldc 60
    //   506: astore 5
    //   508: ldc 60
    //   510: astore 4
    //   512: ldc 60
    //   514: astore 8
    //   516: ldc 60
    //   518: astore 7
    //   520: ldc 60
    //   522: astore_2
    //   523: aload 9
    //   525: invokevirtual 1608	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   528: aload 8
    //   530: astore 9
    //   532: aload 5
    //   534: astore 8
    //   536: aload_2
    //   537: astore 5
    //   539: aload_1
    //   540: astore_2
    //   541: ldc 60
    //   543: astore_1
    //   544: aload_3
    //   545: astore 11
    //   547: goto -77 -> 470
    //   550: astore 9
    //   552: ldc 60
    //   554: astore 10
    //   556: ldc 60
    //   558: astore_1
    //   559: ldc 60
    //   561: astore_3
    //   562: ldc 60
    //   564: astore 6
    //   566: ldc 60
    //   568: astore 5
    //   570: ldc 60
    //   572: astore 4
    //   574: ldc 60
    //   576: astore 8
    //   578: ldc 60
    //   580: astore 7
    //   582: ldc 60
    //   584: astore_2
    //   585: aload 9
    //   587: invokevirtual 2815	java/lang/NullPointerException:printStackTrace	()V
    //   590: aload 8
    //   592: astore 9
    //   594: aload 5
    //   596: astore 8
    //   598: aload_2
    //   599: astore 5
    //   601: aload_1
    //   602: astore_2
    //   603: ldc 60
    //   605: astore_1
    //   606: aload_3
    //   607: astore 11
    //   609: goto -139 -> 470
    //   612: aload_0
    //   613: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   616: ifnull +171 -> 787
    //   619: new 146	android/content/Intent
    //   622: dup
    //   623: aload_0
    //   624: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   627: ldc_w 2817
    //   630: invokespecial 224	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   633: astore_3
    //   634: aload_3
    //   635: ldc_w 2819
    //   638: aload 7
    //   640: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   643: pop
    //   644: aload_3
    //   645: ldc_w 2821
    //   648: new 125	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   655: ldc 60
    //   657: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload 6
    //   662: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   671: pop
    //   672: ldc_w 770
    //   675: aload 10
    //   677: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   680: ifeq +139 -> 819
    //   683: aload_3
    //   684: ldc_w 2823
    //   687: iconst_0
    //   688: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   691: pop
    //   692: new 324	android/os/Bundle
    //   695: dup
    //   696: invokespecial 325	android/os/Bundle:<init>	()V
    //   699: astore 6
    //   701: aload 6
    //   703: ldc_w 2796
    //   706: aload 4
    //   708: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: aload 6
    //   713: ldc_w 2800
    //   716: aload 11
    //   718: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   721: aload 6
    //   723: ldc_w 2806
    //   726: aload 9
    //   728: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   731: aload 6
    //   733: ldc_w 2808
    //   736: aload 8
    //   738: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: aload 6
    //   743: ldc_w 2810
    //   746: aload 5
    //   748: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload 6
    //   753: ldc_w 2812
    //   756: aload_2
    //   757: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload 6
    //   762: ldc_w 2814
    //   765: aload_1
    //   766: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   769: aload_3
    //   770: ldc_w 1066
    //   773: aload 6
    //   775: invokevirtual 1377	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   778: pop
    //   779: aload_0
    //   780: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   783: aload_3
    //   784: invokevirtual 228	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   787: aload_0
    //   788: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   791: ldc_w 1739
    //   794: ldc 60
    //   796: ldc 60
    //   798: ldc_w 2825
    //   801: ldc_w 2825
    //   804: iconst_0
    //   805: iconst_0
    //   806: ldc 60
    //   808: ldc 60
    //   810: ldc 60
    //   812: ldc 60
    //   814: invokestatic 215	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   817: iconst_1
    //   818: ireturn
    //   819: aload_3
    //   820: ldc_w 2823
    //   823: bipush 6
    //   825: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   828: pop
    //   829: goto -137 -> 692
    //   832: astore 9
    //   834: ldc 60
    //   836: astore_1
    //   837: ldc 60
    //   839: astore 4
    //   841: ldc 60
    //   843: astore 6
    //   845: ldc 60
    //   847: astore 5
    //   849: ldc 60
    //   851: astore 11
    //   853: ldc 60
    //   855: astore 8
    //   857: ldc 60
    //   859: astore 7
    //   861: ldc 60
    //   863: astore_2
    //   864: aload_3
    //   865: astore 10
    //   867: aload 4
    //   869: astore_3
    //   870: aload 11
    //   872: astore 4
    //   874: goto -289 -> 585
    //   877: astore 9
    //   879: ldc 60
    //   881: astore_2
    //   882: ldc 60
    //   884: astore 4
    //   886: ldc 60
    //   888: astore 8
    //   890: aload_1
    //   891: astore 7
    //   893: ldc 60
    //   895: astore_1
    //   896: ldc 60
    //   898: astore 11
    //   900: ldc 60
    //   902: astore 5
    //   904: ldc 60
    //   906: astore 6
    //   908: aload_3
    //   909: astore 10
    //   911: aload 11
    //   913: astore_3
    //   914: goto -329 -> 585
    //   917: astore 9
    //   919: ldc 60
    //   921: astore 5
    //   923: aload_2
    //   924: astore 6
    //   926: ldc 60
    //   928: astore_2
    //   929: ldc 60
    //   931: astore 4
    //   933: ldc 60
    //   935: astore 8
    //   937: aload_1
    //   938: astore 7
    //   940: ldc 60
    //   942: astore_1
    //   943: ldc 60
    //   945: astore 11
    //   947: aload_3
    //   948: astore 10
    //   950: aload 11
    //   952: astore_3
    //   953: goto -368 -> 585
    //   956: astore 10
    //   958: aload 15
    //   960: astore 8
    //   962: aload_1
    //   963: astore 9
    //   965: aload 12
    //   967: astore_1
    //   968: aload 11
    //   970: astore 6
    //   972: aload 10
    //   974: astore 11
    //   976: aload_2
    //   977: astore 12
    //   979: aload 7
    //   981: astore_2
    //   982: aload_3
    //   983: astore 10
    //   985: aload 6
    //   987: astore_3
    //   988: aload 12
    //   990: astore 6
    //   992: aload 9
    //   994: astore 7
    //   996: aload 11
    //   998: astore 9
    //   1000: goto -415 -> 585
    //   1003: astore 9
    //   1005: ldc 60
    //   1007: astore_1
    //   1008: ldc 60
    //   1010: astore 4
    //   1012: ldc 60
    //   1014: astore 6
    //   1016: ldc 60
    //   1018: astore 5
    //   1020: ldc 60
    //   1022: astore 11
    //   1024: ldc 60
    //   1026: astore 8
    //   1028: ldc 60
    //   1030: astore 7
    //   1032: ldc 60
    //   1034: astore_2
    //   1035: aload_3
    //   1036: astore 10
    //   1038: aload 4
    //   1040: astore_3
    //   1041: aload 11
    //   1043: astore 4
    //   1045: goto -522 -> 523
    //   1048: astore 9
    //   1050: ldc 60
    //   1052: astore_2
    //   1053: ldc 60
    //   1055: astore 4
    //   1057: ldc 60
    //   1059: astore 8
    //   1061: aload_1
    //   1062: astore 7
    //   1064: ldc 60
    //   1066: astore_1
    //   1067: ldc 60
    //   1069: astore 11
    //   1071: ldc 60
    //   1073: astore 5
    //   1075: ldc 60
    //   1077: astore 6
    //   1079: aload_3
    //   1080: astore 10
    //   1082: aload 11
    //   1084: astore_3
    //   1085: goto -562 -> 523
    //   1088: astore 9
    //   1090: ldc 60
    //   1092: astore 5
    //   1094: aload_2
    //   1095: astore 6
    //   1097: ldc 60
    //   1099: astore_2
    //   1100: ldc 60
    //   1102: astore 4
    //   1104: ldc 60
    //   1106: astore 8
    //   1108: aload_1
    //   1109: astore 7
    //   1111: ldc 60
    //   1113: astore_1
    //   1114: ldc 60
    //   1116: astore 11
    //   1118: aload_3
    //   1119: astore 10
    //   1121: aload 11
    //   1123: astore_3
    //   1124: goto -601 -> 523
    //   1127: astore 9
    //   1129: aload_1
    //   1130: astore 7
    //   1132: aload 13
    //   1134: astore_1
    //   1135: aload_2
    //   1136: astore 11
    //   1138: aload 8
    //   1140: astore_2
    //   1141: aload 6
    //   1143: astore 5
    //   1145: aload_3
    //   1146: astore 10
    //   1148: aload 16
    //   1150: astore 8
    //   1152: aload 14
    //   1154: astore_3
    //   1155: aload 11
    //   1157: astore 6
    //   1159: goto -636 -> 523
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1162	0	this	JumpAction
    //   47	1088	1	localObject1	Object
    //   61	1080	2	localObject2	Object
    //   33	1122	3	localObject3	Object
    //   75	1028	4	localObject4	Object
    //   87	1057	5	localObject5	Object
    //   107	1051	6	localObject6	Object
    //   83	1048	7	localObject7	Object
    //   103	1048	8	localObject8	Object
    //   132	334	9	str1	String
    //   488	36	9	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   530	1	9	localObject9	Object
    //   550	36	9	localNullPointerException1	java.lang.NullPointerException
    //   592	135	9	localObject10	Object
    //   832	1	9	localNullPointerException2	java.lang.NullPointerException
    //   877	1	9	localNullPointerException3	java.lang.NullPointerException
    //   917	1	9	localNullPointerException4	java.lang.NullPointerException
    //   963	36	9	localObject11	Object
    //   1003	1	9	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   1048	1	9	localUnsupportedEncodingException3	UnsupportedEncodingException
    //   1088	1	9	localUnsupportedEncodingException4	UnsupportedEncodingException
    //   1127	1	9	localUnsupportedEncodingException5	UnsupportedEncodingException
    //   14	935	10	localObject12	Object
    //   956	17	10	localNullPointerException5	java.lang.NullPointerException
    //   983	164	10	localObject13	Object
    //   95	1061	11	localObject14	Object
    //   79	910	12	localObject15	Object
    //   99	1034	13	str2	String
    //   2	1151	14	localObject16	Object
    //   91	868	15	str3	String
    //   111	1038	16	str4	String
    //   10	436	17	str5	String
    //   18	435	18	str6	String
    //   6	458	19	str7	String
    //   437	6	20	str8	String
    // Exception table:
    //   from	to	target	type
    //   20	34	488	java/io/UnsupportedEncodingException
    //   20	34	550	java/lang/NullPointerException
    //   34	48	832	java/lang/NullPointerException
    //   48	62	877	java/lang/NullPointerException
    //   62	77	917	java/lang/NullPointerException
    //   113	134	956	java/lang/NullPointerException
    //   174	195	956	java/lang/NullPointerException
    //   235	256	956	java/lang/NullPointerException
    //   296	317	956	java/lang/NullPointerException
    //   357	378	956	java/lang/NullPointerException
    //   418	439	956	java/lang/NullPointerException
    //   34	48	1003	java/io/UnsupportedEncodingException
    //   48	62	1048	java/io/UnsupportedEncodingException
    //   62	77	1088	java/io/UnsupportedEncodingException
    //   113	134	1127	java/io/UnsupportedEncodingException
    //   174	195	1127	java/io/UnsupportedEncodingException
    //   235	256	1127	java/io/UnsupportedEncodingException
    //   296	317	1127	java/io/UnsupportedEncodingException
    //   357	378	1127	java/io/UnsupportedEncodingException
    //   418	439	1127	java/io/UnsupportedEncodingException
  }
  
  private boolean aS()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("focus_item");
    TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str1, str2);
    return true;
  }
  
  private boolean aT()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("troopuin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      return false;
    }
    TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str1, str2, 9, -1);
    return true;
  }
  
  private boolean aU()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QRJumpActivity.class);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_JavaLangString;
    }
    localIntent.putExtra("url", (String)localObject);
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("attr_original_url");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localIntent.putExtra("attr_original_url", (String)localObject);
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if ((localObject != null) && (((Intent)localObject).hasExtra("fromQrcode"))) {
        localIntent.putExtra("fromQrcode", ((Intent)localObject).getBooleanExtra("fromQrcode", false));
      }
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean aV()
  {
    if ("webview".equals(this.jdField_d_of_type_JavaLangString))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bus_type");
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "photo").putExtra("doCallBack", true).putExtra("src_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type")).putExtra("callback_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type")).putExtra("callback_name", (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name")));
    }
    return true;
  }
  
  private boolean aW()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label110:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label110;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    localBundle.putString("pkg_sig", this.jdField_f_of_type_JavaLangString);
    localBundle.putInt("action", 3);
    localIntent.putExtra("key_params", localBundle);
    PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
    return true;
  }
  
  private boolean aX()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label110:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label110;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    localBundle.putString("pkg_sig", this.jdField_f_of_type_JavaLangString);
    localBundle.putInt("action", 1);
    localIntent.putExtra("key_params", localBundle);
    PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
    return true;
  }
  
  private boolean aY()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BindGroupActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("skey", ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label163:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label163;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("key_params", localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean aZ()
  {
    System.currentTimeMillis();
    Object localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if ((localObject3 == null) || ((!((String)localObject3).startsWith("http://")) && (!((String)localObject3).startsWith("https://"))) || ((!Util.b((String)localObject3).equalsIgnoreCase("qq.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("myun.tenpay.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("tenpay.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("wanggou.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("tencent.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("jd.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("qcloud.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("webank.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("qqumall.com")))) {
      return false;
    }
    if ((((String)localObject3).startsWith("https://jiazhang.qq.com/wap/com/")) || (((String)localObject3).startsWith("https://test.jiazhang.qq.com/wap/com/")))
    {
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))))
      {
        QLog.e("JumpAction", 1, "empty params");
        return false;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"), "");
    }
    if (WeatherWebPageHelperKt.a((String)localObject3))
    {
      WeatherWebPageHelperKt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, (String)localObject3);
      return true;
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("style");
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_auth");
    localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_nld");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_dev");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_usr");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_vkey");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((String)localObject3);
    if (localStringBuffer.indexOf("?") < 0)
    {
      localStringBuffer.append("?");
      localObject3 = new Cryptor();
      if (!"1".equals(str2)) {
        break label2284;
      }
      localStringBuffer.append("plg_auth=1");
      localStringBuffer.append("&");
    }
    label2141:
    label2284:
    for (int i1 = 1;; i1 = 0)
    {
      if ("1".equals(str3))
      {
        localStringBuffer.append("plg_dev=1");
        localStringBuffer.append("&");
        localStringBuffer.append("MOBINFO=");
        localStringBuffer.append(HexUtil.bytes2HexStr(((Cryptor)localObject3).encrypt(c().getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      if ("1".equals(str4))
      {
        localStringBuffer.append("plg_usr=1");
        localStringBuffer.append("&");
        localStringBuffer.append("USER=");
        localStringBuffer.append(HexUtil.bytes2HexStr(((Cryptor)localObject3).encrypt(HardCodeUtil.a(2131705932).getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      int i2 = i1;
      if ("1".equals(str5))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getvKeyStr();
        i2 = i1;
        if (localObject3 != null)
        {
          localStringBuffer.append("plg_vkey=1").append("&mqqvkey=").append((String)localObject3).append("&");
          i2 = 1;
        }
      }
      if ((this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.length() > 0)) {
        localStringBuffer.append(this.jdField_g_of_type_JavaLangString + "&");
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
        if (localStringBuffer.indexOf("?") >= localStringBuffer.length() - 1) {
          break;
        }
        if (localStringBuffer.indexOf("&") < 0)
        {
          localStringBuffer.append("&");
          break;
        }
        if (localStringBuffer.lastIndexOf("&") >= localStringBuffer.length() - 1) {
          break;
        }
        localStringBuffer.append("&");
        break;
      }
      if (i2 != 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.lastIndexOf("&"));
      }
      localObject1 = localStringBuffer.toString();
      if (((String)localObject1).startsWith("http://story.now.qq.com/mobile/transfer_q.html"))
      {
        localObject1 = URLUtil.b(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
        if (!TextUtils.isEmpty((String)((Map)localObject1).get("storysharefrom")))
        {
          this.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject1);
          if (this.jdField_a_of_type_JavaUtilHashMap.get("type") == null) {
            this.jdField_c_of_type_JavaLangString = "opencontent";
          }
          for (;;)
          {
            return S();
            switch (Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("type")))
            {
            default: 
              return true;
            case 0: 
              this.jdField_c_of_type_JavaLangString = "opencontent";
              break;
            case 1: 
              this.jdField_c_of_type_JavaLangString = "openVideo";
              break;
            case 2: 
              this.jdField_c_of_type_JavaLangString = "opentopic";
            }
          }
        }
      }
      else if (((String)localObject1).startsWith("http://story.now.qq.com/mobile/transfer_q2.html"))
      {
        localObject1 = URLUtil.b(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
        this.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject1);
        localObject1 = (String)((Map)localObject1).get("contentType");
        if ((localObject1 == null) || (((String)localObject1).equals("0")))
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.get("actionnamekey") != null) {}
          for (i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("actionnamekey"));; i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("type"))) {
            switch (i1)
            {
            default: 
              return true;
            }
          }
          this.jdField_c_of_type_JavaLangString = "opencontent";
          for (;;)
          {
            return S();
            this.jdField_c_of_type_JavaLangString = "openVideo";
            continue;
            this.jdField_c_of_type_JavaLangString = "opentopic";
            continue;
            this.jdField_c_of_type_JavaLangString = "infoCard";
          }
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
            ((Intent)localObject3).putExtra("has_red_dot", this.jdField_d_of_type_Boolean);
            ((Intent)localObject3).putExtra("is_from_leba", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
            return true;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
            }
          }
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
      Object localObject2;
      if ((this.jdField_e_of_type_JavaLangString == null) || (!this.jdField_e_of_type_JavaLangString.trim().equalsIgnoreCase("com.tx.android.txnews.new"))) {
        if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.trim().equalsIgnoreCase("com.qq.yijianfankui")))
        {
          localStringBuffer.append("&version=8.5.5.5105");
          localStringBuffer.append("&appid=" + AppSetting.a());
          localStringBuffer.append("&QUA=" + QUA.getQUA3());
          localStringBuffer.append("&adtag=5105");
          localObject2 = Build.MODEL;
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            i1 = StatisticCollector.getQzonePatchTag();
            localObject3 = localObject2;
            if (i1 > 0) {
              localObject3 = (String)localObject2 + "_qzpatch" + i1;
            }
            localObject2 = Build.MANUFACTURER;
            if (localObject2 == null) {
              break label2141;
            }
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            localStringBuffer.append("&model=").append((String)localObject3).append("&manufacture=").append((String)localObject2).append("&cpunum=").append(DeviceInfoUtil.b()).append("&cpurate=").append(DeviceInfoUtil.b()).append("&mem=").append(DeviceInfoUtil.a() / 1024L / 1024L).append("&w=").append(DeviceInfoUtil.g()).append("&h=").append(DeviceInfoUtil.h());
          }
        }
        else
        {
          localObject3 = localStringBuffer.toString();
          localObject2 = localObject3;
          if (((String)localObject3).endsWith("&")) {
            localObject2 = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
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
        }
      }
      for (;;)
      {
        try
        {
          ((Intent)localObject2).putExtra("leba_resid", Long.parseLong(b("leba_resid")));
          ((Intent)localObject2).putExtra("has_red_dot", this.jdField_d_of_type_Boolean);
          ((Intent)localObject2).putExtra("is_from_leba", true);
          if (!TextUtils.isEmpty(str2)) {
            ((Intent)localObject2).putExtra("big_brother_source_key", str2);
          }
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
          return true;
          localObject2 = "";
          break;
          localObject2 = "";
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
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
      }
    }
  }
  
  private boolean aa()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("groupCode"))
        {
          String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupCode");
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("groupMemberUin"))
          {
            str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupMemberUin");
            Intent localIntent = new Intent();
            localIntent.putExtra("troop_uin", str1);
            localIntent.putExtra("member_uin", str3);
            PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, TroopMemberHistoryFragment.class);
            return true;
          }
          String str3 = "";
          continue;
        }
        String str2 = "";
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, localException.toString());
        }
        return false;
      }
    }
  }
  
  private boolean ab()
  {
    HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, false);
    return true;
  }
  
  private boolean ac()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hotnamecode")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hotnamecode"); TextUtils.isEmpty(str); str = "")
    {
      QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131705922), 1).a();
      return false;
    }
    NearbyTransitActivity.a(this.jdField_a_of_type_AndroidContentContext, str, 1, this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  /* Error */
  private boolean ad()
  {
    // Byte code:
    //   0: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +18 -> 21
    //   6: ldc 123
    //   8: iconst_1
    //   9: anewarray 4	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: ldc_w 3139
    //   17: aastore
    //   18: invokestatic 1463	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aload_0
    //   22: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   25: ldc_w 3141
    //   28: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   31: ifeq +224 -> 255
    //   34: aload_0
    //   35: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   38: ldc_w 3141
    //   41: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 45	java/lang/String
    //   47: invokestatic 2598	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   55: ldc_w 975
    //   58: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   61: ifeq +189 -> 250
    //   64: aload_0
    //   65: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   68: ldc_w 975
    //   71: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: checkcast 45	java/lang/String
    //   77: invokestatic 121	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   80: istore_1
    //   81: new 146	android/content/Intent
    //   84: dup
    //   85: aload_0
    //   86: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   89: ldc_w 1230
    //   92: invokespecial 224	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   95: astore_3
    //   96: aload_3
    //   97: ldc_w 1246
    //   100: iconst_1
    //   101: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   104: pop
    //   105: aload_3
    //   106: ldc_w 1241
    //   109: getstatic 1244	com/tencent/mobileqq/activity/home/impl/FrameControllerUtil:jdField_a_of_type_Int	I
    //   112: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   115: pop
    //   116: aload_3
    //   117: ldc_w 1235
    //   120: invokevirtual 1239	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   123: pop
    //   124: aload_0
    //   125: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   128: ldc_w 975
    //   131: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   134: ifeq +12 -> 146
    //   137: aload_3
    //   138: ldc_w 975
    //   141: iload_1
    //   142: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   145: pop
    //   146: aload_0
    //   147: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   150: ldc_w 3141
    //   153: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   156: ifeq +12 -> 168
    //   159: aload_3
    //   160: ldc_w 3141
    //   163: iload_2
    //   164: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   167: pop
    //   168: aload_0
    //   169: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   172: instanceof 1230
    //   175: ifeq +41 -> 216
    //   178: aload_0
    //   179: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   182: checkcast 1230	com/tencent/mobileqq/activity/SplashActivity
    //   185: astore 4
    //   187: aload_3
    //   188: ldc_w 3143
    //   191: iconst_1
    //   192: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   195: pop
    //   196: aload 4
    //   198: aload_3
    //   199: invokevirtual 3146	com/tencent/mobileqq/activity/SplashActivity:openMainFragment	(Landroid/content/Intent;)V
    //   202: iconst_1
    //   203: ireturn
    //   204: astore_3
    //   205: iconst_0
    //   206: istore_2
    //   207: aload_3
    //   208: invokevirtual 1227	java/lang/Exception:printStackTrace	()V
    //   211: iconst_0
    //   212: istore_1
    //   213: goto -132 -> 81
    //   216: aload_0
    //   217: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   220: aload_3
    //   221: invokevirtual 228	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   224: aload_0
    //   225: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   228: instanceof 172
    //   231: ifeq -29 -> 202
    //   234: aload_0
    //   235: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   238: checkcast 172	android/app/Activity
    //   241: invokevirtual 3147	android/app/Activity:finish	()V
    //   244: iconst_1
    //   245: ireturn
    //   246: astore_3
    //   247: goto -40 -> 207
    //   250: iconst_0
    //   251: istore_1
    //   252: goto -171 -> 81
    //   255: iconst_0
    //   256: istore_2
    //   257: goto -206 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	JumpAction
    //   80	172	1	i1	int
    //   50	207	2	bool	boolean
    //   95	104	3	localIntent	Intent
    //   204	17	3	localException1	Exception
    //   246	1	3	localException2	Exception
    //   185	12	4	localSplashActivity	SplashActivity
    // Exception table:
    //   from	to	target	type
    //   21	51	204	java/lang/Exception
    //   51	81	246	java/lang/Exception
  }
  
  private boolean ae()
  {
    return true;
  }
  
  private boolean af()
  {
    return true;
  }
  
  private boolean ag()
  {
    return true;
  }
  
  private boolean ah()
  {
    Intent localIntent2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
    String str = localIntent2.getStringExtra("uin");
    Intent localIntent1;
    long l2;
    long l1;
    if (Utils.b(str))
    {
      localIntent1 = new Intent();
      localIntent1.putExtra("uin", str);
      localIntent1.putExtra("uintype", localIntent2.getIntExtra("uintype", -1));
      l2 = 0L;
      l1 = l2;
    }
    try
    {
      if (!TextUtils.isEmpty(b("msg_uniseq"))) {
        l1 = Long.valueOf(b("msg_uniseq")).longValue();
      }
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(str, "chatimg", l1);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoSetAvator path:" + str + "msg uniseq:" + l1);
      }
      int i1 = Math.min(482, ProfileCardUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext));
      localIntent1.putExtra("Business_Origin", 100);
      localIntent1.putExtra("open_chatfragment", true);
      localIntent1.putExtra("open_chat_from_avator", true);
      PhotoUtils.startPhotoEdit(localIntent1, (Activity)this.jdField_a_of_type_AndroidContentContext, SplashActivity.class.getName(), i1, i1, 1080, 1080, str, FaceUtil.a());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800723E", "0X800723E", 0, 0, "", "", "", "");
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("JumpAction", 1, "NumberFormatException uniseq:" + b("msg_uniseq"));
        l1 = l2;
      }
    }
  }
  
  private boolean ai()
  {
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("set_uri_list"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    ArrayList localArrayList = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getParcelableArrayListExtra("android.intent.extra.STREAM");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, FavEmosmManageActivity.class);
    localIntent.addFlags(335544320);
    localIntent.putExtra("key_from_sdk_set_emotion", true);
    localIntent.putParcelableArrayListExtra("key_from_sdk_set_emotion_uri", localArrayList);
    localIntent.putExtra("pkg_name", this.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(str1)) {
      localIntent.putExtra("key_from_sdk_set_emotion_appname", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      localIntent.putExtra("key_from_sdk_set_emotion_share_id", str2);
    }
    if (!TextUtils.isEmpty(str3)) {
      localIntent.putExtra("key_from_sdk_set_emotion_open_id", str3);
    }
    if (!TextUtils.isEmpty(str4)) {
      localIntent.putExtra("key_from_sdk_set_emotion_uri_list", str4);
    }
    if (!TextUtils.isEmpty(str5)) {
      localIntent.putExtra("sdk_version", str5);
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoSDKSetEmotion:sdk appName=" + str1 + " shareId=" + str2 + ", openId =" + str3 + ", setPathList =" + str4);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean aj()
  {
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("set_uri"));
    QLog.d("JumpAction", 1, new Object[] { "-->gotoSDKSetAvator setUri=", str1 });
    if (!TextUtils.isEmpty(str1)) {
      return a(new JumpAction.8(this), str1, "set_uri", "set_path");
    }
    str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("set_path"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("key_request_code", 0);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
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
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoSDKSetAvator:sdk appName=" + str1 + " shareId=" + str2 + ", openId =" + str3 + ", setPath =" + str4 + ", sdkVersion =" + str5);
    }
    ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, localAllInOne, localBundle);
    return true;
  }
  
  private boolean ak()
  {
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_uri"));
    QLog.d("JumpAction", 1, new Object[] { "-->gotoSDKSetDynamicAvatar videoUri=", str1 });
    if (!TextUtils.isEmpty(str1)) {
      return a(new JumpAction.9(this), str1, "video_uri", "video_path");
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
  
  private boolean al()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, RecommendFriendActivity.class);
    localIntent.putExtra("EntranceId", 7);
    localIntent.putExtra("from_babyq", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007243", "0X8007243", 0, 0, "", "", "", "");
    return true;
  }
  
  private boolean am()
  {
    Intent localIntent = new Intent();
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, SearchMightKnowFragment.class);
    return true;
  }
  
  private boolean an()
  {
    Intent localIntent = new Intent();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
    if ((!TextUtils.isEmpty(str)) && (b(str))) {}
    for (int i1 = Integer.valueOf(str).intValue();; i1 = 0)
    {
      localIntent.putExtra("jumpFromType", i1);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoShowNewFriends " + i1);
      }
      NewFriendActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, 9);
      return true;
    }
  }
  
  private boolean ao()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (b((String)localObject))) {}
    for (int i1 = Integer.valueOf((String)localObject).intValue();; i1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoShowContactsTab " + i1);
      }
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      ((Intent)localObject).setFlags(67108864);
      ((Intent)localObject).putExtra("jumpFromType", i1);
      ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.c);
      ((Intent)localObject).putExtra("fragment_id", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
    }
  }
  
  private boolean ap()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ContactBindedActivity.class);
    localIntent.putExtra("from_babyq", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean aq()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"); !str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()); str = "")
    {
      m();
      return false;
    }
    n();
    return false;
  }
  
  private boolean ar()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("leftBackText", HardCodeUtil.a(2131705934));
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
  
  private boolean as()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    QWalletHelperImpl.launchQWalletAct((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false);
    return true;
  }
  
  private boolean at()
  {
    try
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
      int i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
      if (str == null) {
        return false;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      localIntent.setFlags(335544320);
      localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      localIntent.putExtra("openid", str);
      localIntent.putExtra("appid", i1);
      localIntent.putExtra("source", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "Receive error appid number format");
      }
    }
    return false;
  }
  
  private boolean au()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_id");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_id");
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_path"));
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_type"));
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A519", "0X800A519", 0, 0, "", "", str4, str2);
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A51B", "0X800A51B", 0, 0, "", "", str4, str2);
      QLog.e("JumpAction", 1, "connectMiniApp fail: packageName is empty");
      return true;
    }
    if ("mini_program_or_game".equals(localObject))
    {
      if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131699303, 1).a();
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).addFlags(268435456);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        return true;
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JumpAction.14(this), 20000L);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JumpAction.15(this), 500L);
      try
      {
        this.jdField_i_of_type_Boolean = true;
        boolean bool;
        MessageHandler localMessageHandler;
        if (!TextUtils.isEmpty(str1))
        {
          bool = true;
          ForwardStatisticsReporter.a("KEY_STAGE_2_CONNECT_MINI_D55");
          localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
          if (str1 != null) {
            break label441;
          }
        }
        label441:
        for (localObject = "";; localObject = str1)
        {
          localMessageHandler.a(bool, (String)localObject, true, Long.valueOf(str2).longValue(), Long.valueOf(str4).longValue(), 1, Integer.valueOf(str3).intValue(), this.jdField_e_of_type_JavaLangString, false, 0L, new JumpAction.16(this, str4, str2, str5, str6, str1, str7));
          return false;
          bool = false;
          break;
        }
        return true;
      }
      catch (Exception localException)
      {
        if (this.jdField_i_of_type_Boolean)
        {
          this.jdField_i_of_type_Boolean = false;
          d();
        }
        QLog.e("JumpAction", 1, "checkAppSignAndOpenidDiff exception: " + localException.getMessage());
        return true;
      }
    }
  }
  
  private boolean av()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    Object localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    String str9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id"));
    String str11 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_pkg_name"));
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("reply_content");
    String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("reply_time");
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, String.format("gotoChat [uin,type,replyContent,replyTime]=[%s,%s,%s,%s]", new Object[] { str2, localObject3, str6, str7 }));
    }
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("panel");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");
    if ((str4 != null) && (QLog.isDevelopLevel())) {
      QLog.d("JumpAction", 4, str4 + "");
    }
    localObject1 = null;
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    }
    boolean bool1;
    int i1;
    if ("c2c".equals(localObject3))
    {
      if ((str2 == null) || (str2.length() < 5))
      {
        bool1 = false;
        return bool1;
      }
      if (((FriendsManager)localObject1).b(str2))
      {
        localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
        if ("chat".equals(str8))
        {
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
          ((Intent)localObject1).putExtra("uin", str2);
          ((Intent)localObject1).putExtra("uintype", 0);
          if (localObject3 != null) {
            ((Intent)localObject1).putExtra("uinname", (String)localObject3);
          }
          if (!TextUtils.isEmpty(str6))
          {
            ((Intent)localObject1).putExtra("key_aio_reply_content", str6);
            ((Intent)localObject1).putExtra("key_aio_reply_time", str7);
          }
          ((Intent)localObject1).addFlags(67108864);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007191", "0X8007191", 0, 0, "", "", "", "");
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    else if ("discuss".equals(localObject3))
    {
      if ((str2 == null) || (str2.length() < 6)) {
        return false;
      }
      localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("discuss_info");
      i1 = 3000;
      localObject2 = null;
      localObject1 = null;
    }
    for (;;)
    {
      localObject4 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
      ((Intent)localObject4).putExtra("uin", str2);
      ((Intent)localObject4).putExtra("uintype", i1);
      if (localObject3 != null) {
        ((Intent)localObject4).putExtra("uinname", (String)localObject3);
      }
      if (str5 != null) {
        ((Intent)localObject4).putExtra("input_text", str5);
      }
      if (!TextUtils.isEmpty(str6))
      {
        ((Intent)localObject4).putExtra("key_aio_reply_content", str6);
        ((Intent)localObject4).putExtra("key_aio_reply_time", str7);
      }
      if ((localObject1 != null) && (localObject1.length > 0)) {
        ((Intent)localObject4).putExtra((String)localObject2, (byte[])localObject1);
      }
      if ((str4 != null) && (!"".equals(str4))) {
        if ((str2 == null) || ("".equals(str2)))
        {
          return false;
          if ("group".equals(localObject3))
          {
            if ((str2 == null) || (str2.length() < 6)) {
              return false;
            }
            localObject1 = ((TroopManager)localObject2).b(str2);
            if (localObject1 != null)
            {
              localObject3 = ((TroopInfo)localObject1).getTroopDisplayName();
              i1 = 1;
              localObject2 = null;
              localObject1 = null;
              continue;
            }
            return false;
          }
          if ("robot".equals(localObject3))
          {
            if ((str2 == null) || ("".equals(str2))) {
              return false;
            }
            localObject3 = ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            i1 = 1001;
            localObject2 = null;
            localObject1 = null;
            continue;
          }
          if ("wpa".equals(localObject3))
          {
            if ((str2 == null) || (str2.length() < 5) || (str2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              return false;
            }
            if (((FriendsManager)localObject1).b(str2)) {
              i1 = 0;
            }
            for (localObject1 = ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);; localObject1 = null)
            {
              a(str2);
              localObject3 = localObject1;
              localObject2 = null;
              localObject1 = null;
              break;
              i1 = 1005;
            }
          }
          if ("crm".equals(localObject3))
          {
            boolean bool2 = az();
            bool1 = bool2;
            if (!bool2) {
              bool1 = aw();
            }
            bool2 = bool1;
            if (!bool1) {
              bool2 = ax();
            }
            bool1 = bool2;
            if (bool2) {
              break;
            }
            return ay();
          }
          if (("lbs".equals(localObject3)) || ("date".equals(localObject3)))
          {
            if ((str2 == null) || (str2.length() < 5) || (str2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              return false;
            }
            if (((FriendsManager)localObject1).b(str2))
            {
              i1 = 0;
              localObject3 = ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
              localObject2 = null;
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject2 != null) && (localObject4 != null))
        {
          localObject1 = HexUtil.hexStr2Bytes((String)localObject4);
          break;
          if ("lbs".equals(localObject3))
          {
            i1 = 1001;
            localObject3 = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            localObject2 = "rich_accost_sig";
          }
          else
          {
            i1 = 1010;
            localObject3 = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            localObject2 = "rich_date_sig";
            continue;
            if ("public_account".equals(localObject3))
            {
              if ((str2 == null) || (str2.length() < 6)) {
                return false;
              }
              localObject1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", str2, "0X800589E", "0X800589E", 0, 0, str2, "", "", "", false);
              localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
              ((Intent)localObject2).putExtra("uin", str2);
              ((Intent)localObject2).putExtra("uintype", 1008);
              if (localObject1 != null) {
                ((Intent)localObject2).putExtra("uinname", (String)localObject1);
              }
              if (("2747277822".equals(str2)) && (QQGameConfigUtil.b())) {
                QQGameHelper.a(this.jdField_a_of_type_AndroidContentContext);
              }
              for (;;)
              {
                return true;
                if (((IMiniAppService)QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(str2)) {
                  ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniGamePublicAccount(this.jdField_a_of_type_AndroidContentContext);
                } else if ("3046055438".equals(str2)) {
                  com.tencent.biz.pubaccount.ecshopassit.utils.JumpUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
                } else if (NowQQLiveConstant.jdField_a_of_type_JavaLangString.equals(str2))
                {
                  if (!NowQQLiveHelper.a(this.jdField_a_of_type_AndroidContentContext, str2, 3)) {
                    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
                  }
                }
                else if ((AppConstants.QQ_VIP_UIN.equals(str2)) && (QQVipHelper.b(this.jdField_a_of_type_AndroidContentContext))) {
                  QQVipHelper.b(this.jdField_a_of_type_AndroidContentContext);
                } else if ((PAWeatherItemBuilder.a(str2)) && (WeatherWebPageHelperKt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
                  QLog.i("JumpAction", 1, "gotoChat startNewWeatherWebPageActivity");
                } else if (!QQComicConfBean.a().a(str2, this.jdField_a_of_type_AndroidContentContext, 1005, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
                }
              }
            }
            if ("qd_account".equals(localObject3))
            {
              if ((str2 == null) || (str2.length() < 6)) {
                return false;
              }
              localObject1 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
              ((Intent)localObject1).putExtra("uin", str2);
              ((Intent)localObject1).putExtra("uintype", 1008);
              localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("key");
              localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("kfuin");
              str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assign_type");
              str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assign_key");
              str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("ext");
              str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rkey");
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "QD_ACCOUNT_TYPE " + (String)localObject3 + " " + str2 + " " + str3 + " " + str4 + " " + str5);
              }
              if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
                return false;
              }
              ((Intent)localObject1).putExtra("qd_wpa_key", (String)localObject2);
              ((Intent)localObject1).putExtra("qd_kfuin", (String)localObject3);
              if (!TextUtils.isEmpty(str2)) {
                ((Intent)localObject1).putExtra("assign_type", str2);
              }
              if (!TextUtils.isEmpty(str3)) {
                ((Intent)localObject1).putExtra("assign_key", str3);
              }
              if (!TextUtils.isEmpty(str4)) {
                ((Intent)localObject1).putExtra("assign_ext", str4);
              }
              if (!TextUtils.isEmpty(str5)) {
                ((Intent)localObject1).putExtra("rkey", str5);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
              return true;
            }
            if (("thirdparty2c".equals(localObject3)) || ("audio_chat".equals(localObject3)) || ("video_chat".equals(localObject3)))
            {
              if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131699298, 1).a();
                localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).addFlags(268435456);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                return true;
              }
              if (!TextUtils.isEmpty(str9))
              {
                this.jdField_a_of_type_AndroidOsHandler = new Handler();
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JumpAction.17(this), 20000L);
                try
                {
                  if ("thirdparty2c".equals(localObject3)) {
                    i1 = 18;
                  }
                  for (;;)
                  {
                    ForwardStatisticsReporter.a("KEY_STAGE_2_GO_TO_CHAT_D55");
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(true, str9, false, 0L, Long.valueOf(str10).longValue(), 1, i1, str11, false, 0L, new JumpAction.18(this, str9, str10, (String)localObject3));
                    return false;
                    if ("audio_chat".equals(localObject3))
                    {
                      i1 = 19;
                    }
                    else
                    {
                      bool1 = "video_chat".equals(localObject3);
                      if (bool1) {
                        i1 = 19;
                      } else {
                        i1 = 10000;
                      }
                    }
                  }
                  return true;
                }
                catch (Exception localException)
                {
                  return true;
                }
              }
            }
            return false;
            str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type");
            localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("thirdAppDisplayName"));
            localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
            if ((str1 != null) && (!"".equals(str1))) {
              ((Intent)localObject4).putExtra("callback_type", str1);
            }
            if ((localObject2 != null) && (!"".equals(localObject2))) {
              ((Intent)localObject4).putExtra("thirdAppDisplayName", (String)localObject2);
            }
            if ((localObject3 != null) && (!"".equals(localObject3))) {
              ((Intent)localObject4).putExtra("appid", (String)localObject3);
            }
            a((Intent)localObject4, str4);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B4B", "0X8004B4B", 0, 0, "", "", "", "");
            if ("webview".equals(this.jdField_d_of_type_JavaLangString))
            {
              ((Intent)localObject4).putExtra("from", this.jdField_d_of_type_JavaLangString);
              if (jdField_a_of_type_Int > 3)
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131705917), 1).a();
                return true;
              }
              jdField_a_of_type_Int += 1;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B5A", "0X8004B5A", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              if (str3 != null) {
                ((Intent)localObject4).putExtra("panel", str3);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
              return true;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B58", "0X8004B58", 0, 0, "", "", "", "");
            }
          }
        }
      }
      String str1 = null;
      continue;
      localObject2 = null;
      i1 = 0;
      str1 = null;
    }
  }
  
  private boolean aw()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpaType");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assignId");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("QidianSigT");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("QidianKfUin");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rkey");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shouldReturnToRoot");
    Intent localIntent;
    String str6;
    String str7;
    boolean bool1;
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null))
    {
      try
      {
        if (!str1.equals("2")) {
          break label533;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleQidianExtWPA wpaType = 2");
        }
        localIntent = new Intent();
        if ((TextUtils.isEmpty(str5)) || (str5.equals("NO"))) {
          localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class));
        }
        for (;;)
        {
          localIntent.addFlags(67108864);
          str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
          str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
          if (str7 == null) {
            break label397;
          }
          if (str7.length() < 5) {
            break label573;
          }
          if (!str7.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            break;
          }
          return false;
          localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class));
          localIntent.putExtra("open_chatfragment", true);
        }
        bool2 = bool1;
      }
      catch (Exception localException1)
      {
        bool1 = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, localException1.getMessage());
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      return bool2;
      if (str6 != null) {
        localIntent.putExtra("sigt", HexUtil.hexStr2Bytes(str6));
      }
      if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str7))
      {
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("uinname", ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str7));
        label377:
        localIntent.putExtra("uin", str7);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          label397:
          ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(str4, localException1, str3, str2, (String)localObject, str5, this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver.jdField_a_of_type_Int);
          try
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("wpaType: ").append(localException1).append("assignId: ").append(str2).append("qidianSigt: ").append(str3).append("qidianUin: ").append(str4);
              QLog.d("JumpAction", 2, ((StringBuilder)localObject).toString());
            }
            bool2 = true;
          }
          catch (Exception localException2)
          {
            label533:
            bool1 = true;
          }
        }
        localIntent.putExtra("uintype", 1025);
        localIntent.putExtra("from_wpa_for_crm", true);
        break label377;
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleQidianExtWPA wpaType != 2");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
      }
      break;
    }
    label573:
    return false;
  }
  
  private boolean ax()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpaType");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assignId");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("QidianKfUin");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shouldReturnToRoot");
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null) && (str5 != null)) {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
          ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(str5, str2, str1, str3, str4, str6);
          bool3 = true;
          bool1 = true;
          boolean bool2 = bool1;
          bool2 = bool1;
        }
        catch (Exception localException1)
        {
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.d("JumpAction", 2, "handleQidianCorpWPA");
              bool2 = bool1;
            }
            return bool2;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              boolean bool3;
              boolean bool1 = bool3;
            }
          }
          localException1 = localException1;
          bool1 = false;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("JumpAction", 2, localException1.getMessage());
          return bool1;
        }
      }
    }
    return false;
  }
  
  private boolean ay()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str1 == null) || (str1.length() < 5) || (str1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      return false;
    }
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shouldReturnToRoot");
    Intent localIntent = new Intent();
    int i1;
    if ((TextUtils.isEmpty(str4)) || (str4.equals("NO")))
    {
      localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class));
      localIntent.addFlags(67108864);
      i1 = CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "handleLegacyCrmWPA " + i1);
      }
      localIntent.putExtra("from_wpa_for_crm", true);
      localIntent.putExtra("uin", str1);
      localIntent.putExtra("uintype", i1);
      if (i1 != 0) {
        break label403;
      }
      str4 = ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      if (str4 != null) {
        localIntent.putExtra("uinname", str4);
      }
    }
    for (;;)
    {
      if (localObject != null) {
        localIntent.putExtra("input_text", (String)localObject);
      }
      if ((str3 != null) && (str1 != null))
      {
        localObject = HexUtil.hexStr2Bytes(str3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(str1, (byte[])localObject);
      }
      if (str2 != null) {
        localIntent.putExtra("sigt", HexUtil.hexStr2Bytes(str2));
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Bqq_Crm", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str1, "", "");
      return true;
      localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class));
      localIntent.putExtra("open_chatfragment", true);
      break;
      label403:
      if (i1 == 1024) {
        localIntent.putExtra("chat_subType", 1);
      }
    }
  }
  
  private boolean az()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request");
    if ((str1 == null) || (!str1.equals("videochat"))) {
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
    return false;
  }
  
  public static int b(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("sharefromtype");
    if (paramMap != null) {}
    try
    {
      int i1 = Integer.parseInt(paramMap);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (!QLog.isColorLevel()) {
        break label59;
      }
      QLog.e("JumpAction", 2, "makeStoryContentPageIntent, NumberFormatException, shareFromStr:" + paramMap);
    }
    return 0;
    label59:
    return 0;
  }
  
  public static int b(Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i1 = paramInt;
    if (paramMap != null) {}
    try
    {
      i1 = Integer.parseInt(paramMap);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      do
      {
        i1 = paramInt;
      } while (!QLog.isColorLevel());
      QLog.e("JumpAction", 2, "getIntAttribute, NumberFormatException, key:" + paramString + " strVal:" + paramMap);
    }
    return paramInt;
  }
  
  private Intent b()
  {
    ((QQStoryActivityManager)SuperManager.a(18)).a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  private String b()
  {
    return "mqqapi://" + this.jdField_b_of_type_JavaLangString + "/" + this.jdField_c_of_type_JavaLangString + "?src_type=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
  }
  
  public static void b(Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("key_launch_time");
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("plugin_tag", 1, "call jumpToQZoneVideoLayer timedelay=" + (l2 - l1));
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
    localIntent.setFlags(268435456);
    localIntent.putExtras(paramBundle);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public static boolean b(String paramString)
  {
    return Pattern.compile("[0-9]+").matcher(paramString).matches();
  }
  
  private boolean bA()
  {
    return true;
  }
  
  private boolean bB()
  {
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {}
    Object localObject2;
    for (Object localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; localObject2 = null)
    {
      Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
      String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
      try
      {
        str1 = URLDecoder.decode(str1, "UTF-8");
        str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("troopbar_id"));
      }
      catch (Exception localException3)
      {
        try
        {
          l1 = Long.parseLong((String)localObject3);
          localObject3 = new JSONObject();
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              String str5;
              ((JSONObject)localObject3).put("share_from_app", true);
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("share_img_list", str1);
              localJSONObject.put("share_title", str3);
              localJSONObject.put("share_content", str4);
              localJSONObject.put("share_app_name", localObject1);
              localJSONObject.put("share_app_id", l1);
              ((JSONObject)localObject3).put("share_info", localJSONObject);
              ((JSONObject)localObject3).put("bid", str5);
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopBarPublishActivity.class);
              ((Intent)localObject1).addFlags(268435456);
              ((Intent)localObject1).putExtra("options", ((JSONObject)localObject3).toString());
              ((Intent)localObject1).putExtra("pkg_name", this.jdField_e_of_type_JavaLangString);
              com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
              return true;
              localException2 = localException2;
              String str2 = "";
            }
            localException3 = localException3;
            long l1 = 0L;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "gotoTroopBarShareMsg Exception:" + localException1.toString());
              }
            }
          }
        }
      }
    }
  }
  
  private boolean bC()
  {
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if (TextUtils.isEmpty(str)) {
      str = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      SmartDeviceReport.a().a(1);
      SmartDeviceReport.a().jdField_a_of_type_JavaLangString = "";
      SmartDeviceReport.a().jdField_a_of_type_Int = 0;
      SmartDeviceReport.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 2);
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        DeviceScanner.openDeviceQCodeUrl((Activity)this.jdField_a_of_type_AndroidContentContext, null, str);
      }
      return true;
    }
  }
  
  private boolean bD()
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
          i1 = 1;
          localObject2 = URLUtil.b((String)((Map)localObject1).get("args"));
          localObject1 = (String)((Map)localObject2).get("sn");
          localObject2 = (String)((Map)localObject2).get("pid");
          if ((i1 != 0) && ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))))
          {
            ToastUtil.a().a(this.jdField_a_of_type_AndroidContentContext.getString(2131720476));
            return true;
          }
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, DevicePluginDownloadActivity.class);
          localIntent.putExtra("DevicePID", (String)localObject2);
          localIntent.putExtra("DeviceSN", (String)localObject1);
          localIntent.putExtra("DeviceToken", "");
          localIntent.putExtra("public_device", i1);
          localIntent.putExtra("from", "share");
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          return true;
        }
      }
      catch (Exception localException)
      {
        return false;
      }
      int i1 = 0;
    }
  }
  
  private boolean bE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.send_hong_bao", 2, "JumpAction.gotoSendHongBao(). hong_bao_id=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_id") + ", send_uin=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("send_uin") + ", hong_bao_type=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_type") + ", hong_bao_summary=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_summary"));
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("hb_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_id"));
    localIntent.putExtra("send_uin", (String)this.jdField_a_of_type_JavaUtilHashMap.get("send_uin"));
    localIntent.putExtra("hb_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_type"));
    localIntent.putExtra("forward_text", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_summary"));
    localIntent.putExtra("forward_type", 17);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidContentContext, localIntent);
    return true;
  }
  
  private boolean bF()
  {
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("friendUin"));
    localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, "", 3001, 11, "", "", null, "", "");
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean bG()
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
    if (QLog.isDevelopLevel()) {
      QLog.e("JumpAction", 4, "gotoHuayang url==" + (String)localObject1);
    }
    localObject2 = this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent((Context)localObject2, QQBrowserActivity.class);
    localIntent.setFlags(536870912);
    localIntent.putExtra("url", (String)localObject1);
    ((Context)localObject2).startActivity(localIntent);
    return true;
  }
  
  private boolean bH()
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
        return c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, null);
      }
      return false;
    }
    if ("opencontent".equals(this.jdField_c_of_type_JavaLangString)) {
      return a(this.jdField_a_of_type_JavaUtilHashMap, false);
    }
    if ("opendiscovery".equals(this.jdField_c_of_type_JavaLangString)) {
      return bJ();
    }
    if ("opentopic".equals(this.jdField_c_of_type_JavaLangString)) {
      return bI();
    }
    if ("infoCard".equals(this.jdField_c_of_type_JavaLangString)) {
      return c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    if ("sharegroupcard".equals(this.jdField_c_of_type_JavaLangString)) {
      return d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    Object localObject = new QQStoryHomeJumpHelper((Activity)this.jdField_a_of_type_AndroidContentContext, new JumpAction.30(this));
    Intent localIntent = e(new Intent());
    if (localIntent != null)
    {
      int i1 = localIntent.getIntExtra("action", 0);
      localIntent.putExtra("action", 0);
      return ((QQStoryHomeJumpHelper)localObject).a(i1, localIntent);
    }
    return false;
  }
  
  private boolean bI()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname");
    d((String)this.jdField_a_of_type_JavaUtilHashMap.get("sharefromtype"));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
      return true;
    }
    return false;
  }
  
  private boolean bJ()
  {
    if (!TextUtils.isEmpty(d((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api")))) {
      StoryReportor.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      if ("1".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"))) {}
      return true;
    }
    return false;
  }
  
  private boolean bK()
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
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        SLog.e("JumpAction", "Error: context is not instanceof Activity, context is: " + String.valueOf(this.jdField_a_of_type_AndroidContentContext));
      }
      if (localIntent == null) {
        SLog.e("JumpAction", "Error: jumpIntent is null");
      }
      return false;
    }
    SLog.b("JumpAction", "startStoryMainActivity, isNowTabShow==false");
    if (((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity)) && (!BaseApplicationImpl.appMainActivityHasLanuch))
    {
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      localIntent.setFlags(335544320);
      localIntent.putExtra("jump_to_story", true);
    }
    for (;;)
    {
      localIntent = e(localIntent);
      if ((localIntent == null) || ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseApplicationImpl)))) {
        break;
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      localIntent = b();
    }
  }
  
  private boolean bL()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity)) && ((((JumpActivity)this.jdField_a_of_type_AndroidContentContext).getIntent().getFlags() & 0x100000) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, String.format("gotoRegisterByInvite bLaunchFromRecent=%b", new Object[] { Boolean.valueOf(bool) }));
      }
      String str;
      Intent localIntent;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("code"))
      {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("code");
        Object localObject = a();
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
        if (a().getRegisterPhoneNumActivityClass() != localObject) {
          break label286;
        }
        localIntent.putExtra("key_report_extra_from", 5);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localIntent.putExtra("invite_code", (String)localObject);
      }
      label286:
      for (int i1 = 1;; i1 = 0)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) && (i1 != 0) && (!bool))
        {
          localIntent.putExtra("action", 4097);
          PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, TranslucentTRansferFragment.class);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096FF", "0X80096FF", 0, 0, "", "", "", "");
          return true;
          str = "";
          break;
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096FE", "0X80096FE", 0, 0, "", "", "", "");
        return true;
      }
    }
  }
  
  private boolean bM()
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
  
  private boolean bN()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("troopUin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("evilUin");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("selfUin");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("scene");
    int i2 = 20008;
    int i1 = i2;
    if (str4 != null) {}
    try
    {
      i1 = Integer.parseInt(str4);
      NewReportPlugin.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, str2, str1, str3, i1, null);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
  }
  
  private boolean bO()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (StringUtil.a(str)) {
      str = "0";
    }
    for (;;)
    {
      NearbyFaceScoreManager localNearbyFaceScoreManager = (NearbyFaceScoreManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppInterface().getManager(QQManagerFactory.FACE_SCORE_MANAGER);
      long l1 = Long.parseLong(str);
      localNearbyFaceScoreManager.a(l1, new JumpAction.31(this, l1));
      return true;
    }
  }
  
  private boolean bP()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomcode");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isgroupcode");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("backtype");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extra");
    GroupVideoManager localGroupVideoManager = (GroupVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
    try
    {
      i1 = Integer.parseInt(str3);
      QLog.i("JumpAction", 1, "[goToGroupVideoPlugin], roomId:" + str1 + ",fromId:" + str2 + " isGroupCode:" + str3);
      localGroupVideoManager.a(this.jdField_a_of_type_AndroidContentContext, str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), i1, "download", str2, str4, str5, str6);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1 = 1;
      }
    }
  }
  
  private boolean bQ()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    localObject = (GroupVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
    QLog.i("JumpAction", 1, "[goToPreLoadGroupVideoPlugin]");
    ((GroupVideoManager)localObject).a(null, 10L);
    return true;
  }
  
  private boolean bR()
  {
    ((StudyRoomManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  private boolean bS()
  {
    i1 = 0;
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("guin");
    Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((TroopManager)localObject2).m((String)localObject1)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("JumpAction", 2, new Object[] { "illegal goToTroopProfileApp jumpAction. troopUin=", localObject1 });
      }
      return false;
    }
    localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
    if ("group_file".equals(localObject2)) {
      TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1);
    }
    for (;;)
    {
      return true;
      if ("group_album".equals(localObject2)) {
        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gname");
      }
      try
      {
        i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("unreadnum"));
        i1 = i2;
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        int i2;
        label168:
        break label168;
      }
      TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1, (String)localObject2, i1);
      continue;
      if ("group_story".equals(localObject2)) {
        for (;;)
        {
          for (;;)
          {
            int i3;
            int i4;
            try
            {
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("troopStoryMemoriesFrom")) {
                i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("troopStoryMemoriesFrom"));
              }
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              i1 = 0;
              i2 = 0;
            }
            try
            {
              i3 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("playVideoFrom"));
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              for (;;)
              {
                label318:
                Bundle localBundle;
                i3 = 0;
                i2 = i1;
                i1 = i3;
              }
            }
            try
            {
              i4 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("lastOpenFrom"));
              i2 = i1;
              localObject1 = QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, null, (String)localObject1, i2, i3);
              ((Intent)localObject1).putExtra("extra_last_open_from", i4);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              i2 = i1;
              i1 = i3;
              break label318;
            }
          }
          i1 = 8;
          continue;
          i4 = 0;
          i3 = i1;
        }
      }
      if (!"bulk_send_message".equals(localNumberFormatException1)) {
        break;
      }
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gc");
      localBundle = new Bundle();
      localBundle.putString("extra.GROUP_UIN", (String)localObject1);
      localBundle.putString("selfSet_leftViewText", HardCodeUtil.a(2131705916));
      BulkSendMessageFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, localBundle);
    }
  }
  
  private boolean bT()
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, 0, 2131558743, 17);
    localQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690247));
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
    ArkAppMgr.getInstance().getAppPathByName(str1, str3, "0.0.0.1", "", new JumpAction.32(this, localQQProgressDialog, str3, str2, str1));
    return true;
  }
  
  private boolean bU()
  {
    WatchTogetherManager localWatchTogetherManager = (WatchTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WATCH_LIVE_TOGETHER);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if (localObject1 == null) {}
    }
    for (Object localObject1 = ((Intent)localObject1).getDataString();; localObject1 = "")
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = this.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("room_type"))
        {
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("room_type");
          localNewTogetherRoomMessageData.jdField_a_of_type_Int = Integer.parseInt(str1);
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("group_uin")) {
            break label313;
          }
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("group_uin");
          label128:
          localNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString = str1;
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("group_owner_uin")) {
            break label320;
          }
        }
        label313:
        label320:
        for (String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("group_owner_uin");; str1 = "0")
        {
          localNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString = str1;
          localNewTogetherRoomMessageData.jdField_e_of_type_JavaLangString = ((String)localObject1);
          localNewTogetherRoomMessageData.jdField_f_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("cover_url"));
          Object localObject2 = Uri.parse((String)localObject1);
          localObject1 = ((Uri)localObject2).getQueryParameter("roomid");
          str1 = ((Uri)localObject2).getQueryParameter("room_show_number");
          String str2 = ((Uri)localObject2).getQueryParameter("fromid");
          localObject2 = ((Uri)localObject2).getQueryParameter("room_group_code");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localNewTogetherRoomMessageData.jdField_a_of_type_Long = Integer.parseInt((String)localObject1);
          }
          if (!TextUtils.isEmpty(str1)) {
            localNewTogetherRoomMessageData.jdField_b_of_type_Int = Integer.parseInt(str1);
          }
          if (!TextUtils.isEmpty(str2)) {
            localNewTogetherRoomMessageData.jdField_g_of_type_JavaLangString = str2;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localNewTogetherRoomMessageData.jdField_c_of_type_JavaLangString = ((String)localObject2);
          }
          localWatchTogetherManager.a(localNewTogetherRoomMessageData);
          return true;
          str1 = "0";
          break;
          str1 = "0";
          break label128;
        }
      }
    }
  }
  
  private boolean bV()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject1 == null) {
        break label316;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label316;
      }
    }
    label316:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "gotoGroupManager not admin " + str);
        }
        return false;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("troop_uin", str);
      ((Intent)localObject1).putExtra("key_is_update_before_805", TroopUtils.a(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
      ((Intent)localObject1).putExtra("troop_manage_from_jump_action", true);
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new TroopManageCmd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      if (localPluginCommunicationHandler != null) {
        localPluginCommunicationHandler.register((RemoteCommand)localObject2);
      }
      localObject2 = TroopBaseProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, (Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopManageActivity", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager " + str);
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager context not activity");
      }
      return false;
    }
  }
  
  private boolean ba()
  {
    ForwardStatisticsReporter.a();
    ForwardStatisticsReporter.a("KEY_STAGE_1_TOTAL");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_uri"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("third_sd"));
    long l1 = ForwardUtils.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
    int i1 = ForwardUtils.a(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag")));
    boolean bool = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext);
    QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck appID:", Long.valueOf(l1), ",file_type:", str1, ",reqType=", str2, ",third_sd=", str4, ",qq_sd=", Boolean.valueOf(bool), ",file_data=", localObject, ",file_uri=", str3 });
    if (i1 == 1)
    {
      e("shareToQQ");
      return true;
    }
    if (l1 <= 0L)
    {
      QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck appid = ", Long.valueOf(l1) });
      return false;
    }
    localObject = new HashMap(4);
    ((HashMap)localObject).put("KEY_SHARE_TYPE", str2);
    ((HashMap)localObject).put("KEY_FILE_TYPE", str1);
    ((HashMap)localObject).put("KEY_THIRD_SD", str4);
    ((HashMap)localObject).put("KEY_QQ_SD", String.valueOf(bool));
    if (!TextUtils.isEmpty(str3))
    {
      this.jdField_f_of_type_Boolean = false;
      ThreadManagerV2.executeOnSubThread(new JumpAction.19(this, str3, System.currentTimeMillis(), (HashMap)localObject));
      return false;
    }
    ForwardStatisticsReporter.a("KEY_STAGE_1_SAVE_IMAGE", 0L, (HashMap)localObject, false);
    return bb();
  }
  
  private boolean bb()
  {
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_to_qq_ark_info"));
    String str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chSrc");
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {}
    for (String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; str2 = null)
    {
      String str11 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
      String str12 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
      int i2;
      String str13;
      String str14;
      String str15;
      int i3;
      try
      {
        i2 = Integer.valueOf(str1).intValue();
        str13 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
        str14 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
        str15 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
        i3 = ForwardUtils.a(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag")));
        if (i3 == 1)
        {
          e("shareToQQ");
          return true;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.d("QQShare", 1, "NumberFormatException req_type = 1");
          i2 = 148;
        }
      }
      Object localObject1;
      long l1;
      Object localObject2;
      Intent localIntent;
      Bundle localBundle;
      int i1;
      if (i2 == 1)
      {
        localObject1 = "1";
        l1 = ForwardUtils.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str12, String.valueOf(l1), "102", "80", "0", (String)localObject1, "0", "0", false, true);
        localObject2 = null;
        localIntent = null;
        localBundle = new Bundle();
        localBundle.putBoolean("is_ark_display_share", false);
        i1 = 0;
        if (!TextUtils.isEmpty(str9)) {
          localObject1 = localObject2;
        }
      }
      else
      {
        try
        {
          Object localObject3 = new JSONObject(str9);
          localObject1 = localObject2;
          String str16 = ((JSONObject)localObject3).optString("app");
          localObject1 = localObject2;
          String str17 = ((JSONObject)localObject3).optString("view");
          localObject1 = localObject2;
          String str18 = ((JSONObject)localObject3).optString("meta");
          localObject1 = localObject2;
          localObject3 = ((JSONObject)localObject3).optString("config");
          localObject1 = localObject2;
          if (TextUtils.isEmpty(str16)) {
            break label708;
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty(str17)) {
            break label708;
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty(str18)) {
            break label708;
          }
          localObject1 = localObject2;
          localBundle.putBoolean("is_ark_display_share", true);
          localObject1 = localObject2;
          localIntent = ArkFullScreenAppActivity.a(this.jdField_a_of_type_AndroidContentContext, str17, str16, str18, (String)localObject3, String.valueOf(l1), this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity);
          localObject1 = localIntent;
          ArkAppCenter.c("JumpAction", "gotoShareArkMsg, ark appInfo is parse success");
          localObject1 = localIntent;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            label609:
            ArkAppCenter.c("JumpAction", String.format("gotoShareArkMsg, parse json failed, err=%s", new Object[] { localJSONException.getMessage() }));
            i1 = 1;
          }
        }
        if (i1 == 0) {
          break label1338;
        }
        localObject1 = new Intent();
        localBundle.putBoolean("is_ark_display_share", true);
        localBundle.putBoolean("forward_ark_from_sdk", true);
      }
      label1302:
      label1308:
      label1329:
      label1331:
      label1338:
      for (;;)
      {
        if (l1 <= 0L)
        {
          QLog.d("StructMsg", 1, new Object[] { "gotoShareMsg appid = ", Long.valueOf(l1) });
          return false;
          if (i2 == 5)
          {
            localObject1 = "2";
            break;
          }
          if (i2 == 2)
          {
            localObject1 = "3";
            break;
          }
          localObject1 = "4";
          break;
          label708:
          i1 = 1;
          localObject1 = localObject2;
          ArkAppCenter.c("JumpAction", "gotoShareArkMsg, appName or appView or appMeta is empty");
          localObject1 = localIntent;
          break label609;
          ArkAppCenter.c("JumpAction", "gotoShareArkMsg, appInfo is empty");
          localObject1 = null;
          i1 = 1;
          break label609;
        }
        if (("news".equals(str3)) || ("audio".equals(str3)))
        {
          localBundle.putString("title", str5);
          localBundle.putString("desc", str6);
          localBundle.putString("image_url", str4);
          localBundle.putString("detail_url", str7);
          localBundle.putString("chSrc", str10);
          localBundle.putInt("forward_type", 11);
          localBundle.putLong("req_share_id", l1);
          localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
          localBundle.putString("image_url_remote", str8);
          localBundle.putString("app_name", str2);
          localBundle.putString("open_id", str12);
          localBundle.putString("shareArkInfo", str9);
          localBundle.putString("chSrc", str10);
          if (str5 == null) {
            if (TextUtils.isEmpty(str2)) {
              break label1331;
            }
          }
        }
        for (;;)
        {
          localBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131696382, new Object[] { str2 }));
          localBundle.putString("share_uin", str13);
          localBundle.putString("jfrom", str14);
          localBundle.putString("share_qq_ext_str", str15);
          localBundle.putInt("cflag", i3);
          localBundle.putInt("emoInputType", 2);
          if ((i2 == 5) && (ForwardShareByServerHelper.a()))
          {
            localBundle.putBoolean("is_ark_display_share", true);
            localBundle.putBoolean("forward_ark_from_sdk", true);
          }
          if (i2 == 2) {
            localBundle.putString("audio_url", str11);
          }
          localBundle.putInt("req_type", i2);
          localBundle.putBoolean("k_dataline", false);
          localBundle.putBoolean("k_favorites", true);
          localBundle.putBoolean("k_cancel_button", true);
          if (((i3 & 0x2) == 0) && (!"com.qzone".equals(this.jdField_e_of_type_JavaLangString)))
          {
            bool = true;
            label1119:
            localBundle.putBoolean("k_qzone", bool);
            if ((!bool) || ((i3 & 0x1) == 0)) {
              break label1302;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localBundle.putBoolean("k_send", bool);
            localBundle.putInt("iUrlInfoFrm", 4);
            bool = OpenSdkD55Processor.a();
            localBundle.putBoolean("enable_d55", bool);
            if (bool) {
              ((ForwardSdkStatusManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.SDK_SHARE)).a().a(str12, l1, this.jdField_e_of_type_JavaLangString);
            }
            if (localObject1 == null) {
              break label1329;
            }
            if (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isSharingMiniProgram(this.jdField_a_of_type_JavaUtilHashMap)) {
              break label1308;
            }
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).forwardShareWithTryCatch(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, localBundle, (Intent)localObject1);
            return true;
            localBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131696382, new Object[] { str5 }));
            break;
            bool = false;
            break label1119;
          }
          ((Intent)localObject1).putExtras(localBundle);
          com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
          ForwardBaseOption.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1);
          return true;
          str2 = "";
        }
      }
    }
  }
  
  private boolean bc()
  {
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("fopen_id"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("friend_label"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("add_msg"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
    long l1;
    try
    {
      l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id")).longValue();
      if (l1 <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoMakeFriend appid = " + l1);
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = 0L;
      }
      AddFriendLogicActivity.jdField_a_of_type_JavaLangString = (String)localObject;
      if (!"true".equals(str5)) {}
    }
    for (localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, str1, "" + l1, 3090, 0, str2, str3, null, "", str4);; localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, str1, "" + l1, 3016, 0, str2, str3, null, "", str4))
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
    }
  }
  
  private boolean bd()
  {
    Object localObject;
    String str2;
    QZoneHelper.UserInfo localUserInfo;
    String str1;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)))
    {
      localObject = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("page_id");
      if (str2 != null)
      {
        localUserInfo = QZoneHelper.UserInfo.getInstance();
        localUserInfo.qzone_uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localUserInfo.nickname = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
        SessionInfo localSessionInfo = ((FragmentActivity)localObject).getChatFragment().a().a();
        if ((localSessionInfo != null) && (!TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString))) {
          ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).d(localSessionInfo.jdField_a_of_type_JavaLangString, true);
        }
        if (!str2.equalsIgnoreCase("11")) {
          break label166;
        }
        QZoneHelper.forwardToQunAlbumDetail((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, str1, "mqqChat.QzoneCard", -1);
      }
    }
    for (;;)
    {
      return false;
      label166:
      if (str2.equalsIgnoreCase("12"))
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a().b();
        str2 = e(str1);
        if (TextUtils.isEmpty(str2)) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, "缺少相册id", 1).a();
        } else {
          QZoneHelper.forwardToTroopAlbumViewPhoto((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, (String)localObject, str2, str1, "mqqChat.QzoneCard", -1);
        }
      }
    }
  }
  
  private boolean be()
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
  
  private boolean bf()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (!QzoneAuthorizeConfig.getInstance().hasSchemeRight(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("JumpAction", 1, "has no right to handle this schema");
        return false;
      }
      String str;
      Intent localIntent;
      if (this.jdField_a_of_type_JavaLangString.startsWith("mqqzone"))
      {
        str = "mqzone" + this.jdField_a_of_type_JavaLangString.substring("mqqzone".length());
        if (TextUtils.isEmpty(str)) {
          break label235;
        }
        localIntent = new Intent();
        localIntent.putExtra("cmd", "Schema");
        localIntent.putExtra("schema", str);
        if (!d(str)) {
          break label218;
        }
        ((IWSManager)QRoute.api(IWSManager.class)).enterTrendsTabWs(this.jdField_a_of_type_AndroidContentContext, "from_trends_tab", this.jdField_d_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          return true;
          str = (String)URLUtil.a(this.jdField_a_of_type_JavaLangString).get("schema");
          if (!TextUtils.isEmpty(str)) {
            try
            {
              str = new String(Base64.decode(str, 0), "utf-8");
            }
            catch (Exception localException)
            {
              QLog.e("JumpAction", 1, localException, new Object[0]);
            }
          }
        }
        Object localObject = null;
        break;
        label218:
        QZoneHelper.forwardToQzoneTransluentActivity((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.getInstance(), localIntent);
        continue;
        label235:
        QLog.e("JumpAction", 1, "gotoQzoneHandleSchema,schema=null");
      }
    }
    return false;
  }
  
  private boolean bg()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return false;
    }
    long l1 = QZoneHelper.enableQZoneContentBoxMiniProgram();
    if (l1 != 0L) {
      QZoneMsgActivity.launchContentBoxMiniProgram(l1, this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      return true;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneMsgActivity.class);
      localIntent.addFlags(67108864);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  private boolean bh()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    Object localObject9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    Object localObject10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {}
    for (localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; localObject1 = null)
    {
      String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
      String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
      String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
      String str8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
      for (;;)
      {
        try
        {
          i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
        }
        catch (Exception localException2)
        {
          try
          {
            l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
            localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            i2 = (int)l1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              String str1 = "";
              if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
                continue;
              }
              localObject6 = "";
              QfavReport.a((AppRuntime)localObject8, "User_SdkShare", i2, 0, 0, 0, str1, (String)localObject6);
              localObject8 = new Bundle();
              ((Bundle)localObject8).putString("title", (String)localObject5);
              ((Bundle)localObject8).putString("desc", (String)localObject7);
              ((Bundle)localObject8).putString("image_url", (String)localObject9);
              ((Bundle)localObject8).putString("detail_url", (String)localObject10);
              ((Bundle)localObject8).putLong("req_share_id", l1);
              ((Bundle)localObject8).putString("pkg_name", this.jdField_e_of_type_JavaLangString);
              ((Bundle)localObject8).putString("image_url_remote", str2);
              ((Bundle)localObject8).putString("app_name", (String)localObject1);
              ((Bundle)localObject8).putString("open_id", str5);
              ((Bundle)localObject8).putString("share_uin", str6);
              ((Bundle)localObject8).putString("jfrom", str7);
              ((Bundle)localObject8).putString("share_qq_ext_str", str8);
              ((Bundle)localObject8).putInt("cflag", i1);
              ((Bundle)localObject8).putInt("forward_type", 11);
              i3 = 1;
            }
          }
          catch (Exception localException2)
          {
            try
            {
              int i1;
              long l1;
              i2 = Integer.valueOf(str4).intValue();
              ((Bundle)localObject8).putInt("req_type", i2);
              if (2 == i2)
              {
                ((Bundle)localObject8).putString("audio_url", str3);
                if ((TextUtils.isEmpty((CharSequence)localObject5)) && (TextUtils.isEmpty((CharSequence)localObject7)))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    ((Bundle)localObject8).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131698137), new Object[] { localObject1 }));
                  }
                }
                else
                {
                  com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
                  localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
                  ((Intent)localObject1).putExtra("toUin", AppConstants.FAVORITES_UIN);
                  ((Intent)localObject1).putExtra("uinType", 0);
                  if (1 != i1) {
                    break label1691;
                  }
                  ((Intent)localObject1).putExtra("qqfav_extra_from_system_share", true);
                  ((Intent)localObject1).putExtras((Bundle)localObject8);
                  ForwardBaseOption.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, DirectForwardActivity.class);
                  return true;
                  localException1 = localException1;
                  if (QLog.isColorLevel()) {
                    QLog.e("qqfav", 2, "gotoQfavShareMsg|parse extflags exp: extflag=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"));
                  }
                  i1 = 0;
                  continue;
                  localException2 = localException2;
                  if (QLog.isColorLevel()) {
                    QLog.e("qqfav", 2, "gotoQfavShareMsg|parse appid exp: appid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
                  }
                  l1 = 0L;
                  continue;
                  Object localObject2 = localObject1;
                  continue;
                  localObject6 = this.jdField_e_of_type_JavaLangString;
                }
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              Object localObject8;
              Object localObject6;
              int i3;
              int i2 = i3;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("qqfav", 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + str4);
              i2 = i3;
              continue;
              ((Bundle)localObject8).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131698138));
              continue;
              Object localObject3;
              if (6 == i2)
              {
                ((Bundle)localObject8).putBoolean("key_sdk_share_pure_text", true);
                localObject1 = "";
                if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                  localObject1 = localObject5;
                }
                localObject3 = localObject1;
                if (!TextUtils.isEmpty((CharSequence)localObject7))
                {
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    localObject3 = localObject7;
                  }
                }
                else
                {
                  ((Bundle)localObject8).putString("forward_text", (String)localObject3);
                  ((Bundle)localObject8).putString("qqfav_extra_richmedia_title", (String)localObject5);
                  ((Bundle)localObject8).putString("qqfav_extra_mixed_msg", (String)localObject7);
                  continue;
                }
                localObject3 = (String)localObject1 + "\n" + (String)localObject7;
                continue;
              }
              if (5 == i2)
              {
                ((Bundle)localObject8).putBoolean("qqfav_extra_pic_share", true);
                ((Bundle)localObject8).putBoolean("qqfav_extra_only_pic", TextUtils.isEmpty((CharSequence)localObject7));
                ((Bundle)localObject8).putString("qqfav_extra_richmedia_title", (String)localObject5);
                ((Bundle)localObject8).putString("qqfav_extra_mixed_msg", (String)localObject7);
                ((Bundle)localObject8).putString("desc", "");
                localObject6 = localObject5;
                if (TextUtils.isEmpty((CharSequence)localObject5))
                {
                  localObject6 = localObject5;
                  if (!TextUtils.isEmpty((CharSequence)localObject7))
                  {
                    localObject6 = ((String)localObject7).replace("\024", "");
                    ((Bundle)localObject8).putString("title", (String)localObject6);
                  }
                }
                localObject3 = null;
                localObject1 = null;
                localObject10 = new ArrayList();
                Object localObject4;
                if (!TextUtils.isEmpty((CharSequence)localObject9))
                {
                  localObject9 = ((String)localObject9).split(";");
                  i2 = 0;
                  localObject5 = null;
                  localObject7 = localObject5;
                  localObject3 = localObject1;
                  if (i2 < localObject9.length)
                  {
                    localObject7 = "";
                    try
                    {
                      localObject3 = URLDecoder.decode(localObject9[i2], "UTF-8");
                      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                        if ((((String)localObject3).startsWith("/")) && (new File((String)localObject3).exists()))
                        {
                          ((ArrayList)localObject10).add(localObject3);
                          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                            continue;
                          }
                          i2 += 1;
                          localObject1 = localObject3;
                        }
                      }
                    }
                    catch (UnsupportedEncodingException localUnsupportedEncodingException)
                    {
                      localObject4 = localObject7;
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.e("qqfav", 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + localObject9[i2]);
                      localObject4 = localObject7;
                      continue;
                      if (localObject4.startsWith("http"))
                      {
                        ((ArrayList)localObject10).add(localObject4);
                        if (TextUtils.isEmpty((CharSequence)localObject5))
                        {
                          localObject5 = localObject4;
                          localObject4 = localObject1;
                          continue;
                          if (QLog.isColorLevel()) {
                            QLog.e("qqfav", 2, "gotoQfavShareMsg|file path invalid. path=" + localObject4);
                          }
                        }
                      }
                      localObject4 = localObject1;
                      continue;
                    }
                  }
                }
                else
                {
                  localObject7 = null;
                }
                if (((ArrayList)localObject10).isEmpty())
                {
                  QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131698135, 1);
                  if (QLog.isColorLevel()) {
                    QLog.e("qqfav", 2, "gotoQfavShareMsg|image type.no image path");
                  }
                  return false;
                }
                ((Bundle)localObject8).putString("image_url", localObject4);
                ((Bundle)localObject8).putString("image_url_remote", (String)localObject7);
                ((Bundle)localObject8).putStringArrayList("qqfav_extra_multi_pic_path_list", (ArrayList)localObject10);
                if (1 == ((ArrayList)localObject10).size())
                {
                  if (TextUtils.isEmpty((CharSequence)localObject6))
                  {
                    ((Bundle)localObject8).putInt("req_type", 5);
                    if ((!TextUtils.isEmpty(localObject4)) || (TextUtils.isEmpty((CharSequence)localObject7))) {
                      continue;
                    }
                    ((Bundle)localObject8).putString("image_url", (String)localObject7);
                    continue;
                  }
                  ((Bundle)localObject8).putInt("req_type", 1);
                  continue;
                }
                if (TextUtils.isEmpty((CharSequence)localObject6)) {
                  ((Bundle)localObject8).putString("title", ((ArrayList)localObject10).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131694587));
                }
                ((Bundle)localObject8).putBoolean("qqfav_extra_multi_pic", true);
                ((Bundle)localObject8).putInt("req_type", 1);
                continue;
              }
              if (1 == i2)
              {
                if ((TextUtils.isEmpty((CharSequence)localObject5)) && (TextUtils.isEmpty((CharSequence)localObject7)))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    ((Bundle)localObject8).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131698137), new Object[] { localObject1 }));
                  }
                }
                else
                {
                  if ((!TextUtils.isEmpty((CharSequence)localObject10)) || (!QLog.isColorLevel())) {
                    continue;
                  }
                  QLog.i("qqfav", 2, "gotoQfavShareMsg|link type. no detail url");
                  continue;
                }
                ((Bundle)localObject8).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131698138));
                continue;
              }
              QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131698135, 1);
              if (QLog.isColorLevel()) {
                QLog.e("qqfav", 2, "gotoQfavShareMsg|unknown reqType. reqType=" + i2);
              }
              return false;
            }
          }
        }
        label1691:
        ((Intent)localObject1).putExtra("qqfav_extra_from_sdk_share", true);
      }
    }
  }
  
  private boolean bi()
  {
    int i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"))).intValue();
    if (i1 == 3)
    {
      str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_uri"));
      if (!TextUtils.isEmpty(str)) {
        ThreadManagerV2.executeOnSubThread(new JumpAction.20(this, str));
      }
    }
    while (i1 != 4)
    {
      return true;
      a(true);
      return true;
    }
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoUri"));
    if (!TextUtils.isEmpty(str))
    {
      ThreadManagerV2.executeOnSubThread(new JumpAction.21(this, str));
      return true;
    }
    a(true);
    return true;
  }
  
  private boolean bj()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    String str3 = QUA.getQUA3();
    QZoneShareManager.shareToQZoneForRedPocket(this.jdField_a_of_type_AndroidContentContext, str1, null, 0, str2, str3);
    return true;
  }
  
  private boolean bk()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_uin");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(str))
    {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extinfo");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (str = "mqzone://arouse/homepage?redpocket=1&uin=" + str;; str = "mqzone://arouse/homepage?redpocket=1&uin=" + str + "&extinfo=" + (String)localObject)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("cmd", "Schema");
        ((Intent)localObject).putExtra("schema", str);
        QZoneHelper.forwardToQzoneTransluentActivity((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.getInstance(), (Intent)localObject);
        return true;
      }
    }
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    if ((!TextUtils.isEmpty(str)) && (str.equals("login")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131705919), 1).a();
      return true;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131705929), 1).a();
    str = this.jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder().append(str);
    if (str.indexOf("?") > -1) {}
    for (str = "&";; str = "?")
    {
      str = str;
      str = str + "jfrom=login";
      localObject = new Intent();
      ((Intent)localObject).putExtra("scheme_content", str);
      ((Intent)localObject).putExtra("pkg_name", "com.tencent.mobileqq");
      ((Intent)localObject).putExtras((Intent)localObject);
      ((Intent)localObject).setFlags(268435456);
      if (VersionUtils.e()) {
        ((Intent)localObject).addFlags(32768);
      }
      RouteUtils.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, "/base/login");
      return true;
    }
  }
  
  private boolean bl()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131705921), 1).a();
    return false;
  }
  
  private boolean bm()
  {
    return true;
  }
  
  private boolean bn()
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
  
  private boolean bo()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(str))
        {
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          QZoneHelper.forwardToUserHome((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.getInstance(), str, 0, 0, 0);
          return true;
        }
      }
      catch (Exception localException)
      {
        QLog.e("JumpAction", 1, localException, new Object[0]);
        return true;
      }
    }
  }
  
  private boolean bp()
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
  
  private boolean bq()
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
  
  private boolean br()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoMultiVoiceChat");
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("relation_id");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("actid");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mp_ext_params");
    HashMap localHashMap = new HashMap();
    if ((str4 != null) && (str4.equals("video"))) {
      localHashMap.put("isVideo", "true");
    }
    if (str6 != null)
    {
      localHashMap.put("mp_ext_params", str6);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoMultiVoiceChat mp_ext_params : " + str6);
      }
    }
    if ((str5 != null) && (str4 != null))
    {
      localHashMap.put("actid", str5);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoMultiVoiceChat actId : " + str5);
      }
    }
    if ((str1 != null) && (str1.equals("web")) && (str2 != null) && (str2.equals("1")) && (localObject != null) && (str3 != null))
    {
      if (str3.equals("discussgroup")) {
        if (((String)localObject).equals("0"))
        {
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SelectMemberActivity.class);
          ((Intent)localObject).putExtra("param_type", 3000);
          ((Intent)localObject).putExtra("param_subtype", 0);
          ((Intent)localObject).putExtra("param_from", 1003);
          ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131691352));
          ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131691678));
          ((Intent)localObject).putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131691679));
          ((Intent)localObject).putExtra("param_max", 99);
          ((Intent)localObject).setFlags(603979776);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 1);
        }
      }
      do
      {
        return true;
        return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 3000, (String)localObject, true, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, localHashMap);
        if (str3.equals("single"))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("forward_type", 13);
          ((Intent)localObject).putExtra("fromWebXman", true);
          ForwardBaseOption.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 2);
          return true;
        }
        if (!str3.equals("group")) {
          break;
        }
      } while (((String)localObject).equals("0"));
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from");
      if ((!"gvideo".equals(str1)) && (!"gvideo_h5".equals(str1))) {
        break label621;
      }
    }
    label621:
    for (boolean bool = false;; bool = true)
    {
      return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, true, bool, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, this.jdField_a_of_type_JavaUtilHashMap);
      return false;
    }
  }
  
  private boolean bs()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoVideoChat");
    }
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    if ((localObject2 != null) && ("forward_to_tab".equals(localObject2)))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      ((Intent)localObject1).putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      ((Intent)localObject1).putExtra("conversation_index", 1);
      ((Intent)localObject1).setFlags(335544320);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uinType");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    Object localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("phone");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extraUin");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("actid");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mp_ext_params");
    if ((str4 != null) && (localObject2 != null) && (((String)localObject2).equals("audio")) && (QLog.isColorLevel())) {
      QLog.d("JumpAction", 2, "gotoVideoChat actId : " + str4);
    }
    if ((str5 != null) && (QLog.isColorLevel())) {
      QLog.d("JumpAction", 2, "gotoVideoChat mp_ext_params : " + str5);
    }
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(str3);
        if ((localObject3 == null) || (!((String)localObject3).equals("web")) || (i1 <= 0)) {}
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i1;
        int i2;
        try
        {
          i1 = Integer.valueOf(str2).intValue();
          i1 = VideoController.a(i1, false, 1);
          if ((localObject2 == null) || (!((String)localObject2).equals("audio"))) {
            break label763;
          }
          bool1 = true;
          if (i1 == 1006)
          {
            localObject2 = localObject5;
            if (!((String)localObject5).startsWith("+")) {
              localObject2 = "+" + (String)localObject5;
            }
            localObject3 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).c((String)localObject2);
            if (localObject3 != null)
            {
              localObject3 = ((PhoneContact)localObject3).name;
              localObject5 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject5 = localObject2;
              }
              bool2 = true;
              localObject1 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject5;
              return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, (String)localObject2, (String)localObject1, (String)localObject3, bool1, str1, bool2, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
              localNumberFormatException = localNumberFormatException;
              i1 = 0;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoVideoChat", localException);
          }
          i1 = 0;
          continue;
          localObject4 = localObject2;
          continue;
          if (i1 == 1011)
          {
            localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickName");
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              localObject2 = localObject4;
              if (!((String)localObject1).equals(localObject4)) {}
            }
            else
            {
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695730);
            }
            bool1 = true;
            bool2 = false;
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            continue;
          }
          i2 = ContactUtils.a(i1);
          if (i2 != -1) {
            continue;
          }
        }
        localObject4 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, i1);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = localObject4;
          if (!((String)localObject1).equals(localObject4)) {}
        }
        else
        {
          localObject2 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label741;
        }
        bool2 = true;
        localObject2 = localObject1;
        localObject4 = localObject5;
        continue;
        localObject4 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, str1, i2, 0);
        continue;
      }
      return false;
      label741:
      boolean bool2 = true;
      Object localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject5;
      continue;
      label763:
      boolean bool1 = false;
    }
  }
  
  private boolean bt()
  {
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoRandomVideoChat");
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("session_name"));
    this.jdField_a_of_type_JavaUtilHashMap.put("session_name", str4);
    boolean bool1;
    if ((str2 != null) && (str2.equals("audio"))) {
      bool1 = true;
    }
    try
    {
      for (;;)
      {
        i1 = Integer.parseInt(str3);
        boolean bool2 = bool3;
        if (str1 != null)
        {
          bool2 = bool3;
          if (str1.equals("web"))
          {
            bool2 = bool3;
            if (i1 > 0) {
              bool2 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1011, null, null, null, bool1, null, false, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
            }
          }
        }
        return bool2;
        bool1 = false;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i1 = 0;
      }
    }
  }
  
  private boolean bu()
  {
    if (this.jdField_c_of_type_JavaLangString.equals("jump"))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("options");
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, VipComicJumpActivity.class);
      localIntent.putExtra("options", str);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  /* Error */
  private boolean bv()
  {
    // Byte code:
    //   0: new 146	android/content/Intent
    //   3: dup
    //   4: ldc_w 4773
    //   7: invokespecial 3681	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   10: astore 14
    //   12: aload_0
    //   13: aload 14
    //   15: invokespecial 1941	com/tencent/mobileqq/utils/JumpAction:a	(Landroid/content/Intent;)V
    //   18: aconst_null
    //   19: astore 9
    //   21: aconst_null
    //   22: astore 8
    //   24: aconst_null
    //   25: astore 10
    //   27: aload_0
    //   28: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   31: invokevirtual 1322	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   34: astore 12
    //   36: iconst_0
    //   37: istore_1
    //   38: ldc 60
    //   40: astore 11
    //   42: aload_0
    //   43: ldc_w 2959
    //   46: invokevirtual 434	com/tencent/mobileqq/utils/JumpAction:b	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 13
    //   51: aload 13
    //   53: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +14 -> 70
    //   59: aload 14
    //   61: ldc_w 3100
    //   64: aload 13
    //   66: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   69: pop
    //   70: aload_0
    //   71: ldc_w 4775
    //   74: invokevirtual 434	com/tencent/mobileqq/utils/JumpAction:b	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +62 -> 142
    //   83: aload 14
    //   85: ldc_w 3017
    //   88: invokestatic 3020	java/lang/System:nanoTime	()J
    //   91: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   94: pop
    //   95: aload 14
    //   97: ldc_w 1834
    //   100: invokestatic 760	java/lang/System:currentTimeMillis	()J
    //   103: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   106: pop
    //   107: aload 14
    //   109: ldc_w 755
    //   112: invokestatic 760	java/lang/System:currentTimeMillis	()J
    //   115: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   118: pop
    //   119: aload 14
    //   121: ldc_w 3026
    //   124: iconst_1
    //   125: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   128: pop
    //   129: aload 14
    //   131: ldc_w 3024
    //   134: aload_0
    //   135: getfield 58	com/tencent/mobileqq/utils/JumpAction:jdField_d_of_type_Boolean	Z
    //   138: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   141: pop
    //   142: aload 12
    //   144: invokeinterface 1328 1 0
    //   149: astore 15
    //   151: aload 15
    //   153: invokeinterface 1333 1 0
    //   158: ifeq +631 -> 789
    //   161: aload 15
    //   163: invokeinterface 1337 1 0
    //   168: checkcast 1339	java/util/Map$Entry
    //   171: astore 12
    //   173: aload 12
    //   175: invokeinterface 1345 1 0
    //   180: checkcast 45	java/lang/String
    //   183: astore 13
    //   185: aload 12
    //   187: invokeinterface 1342 1 0
    //   192: checkcast 45	java/lang/String
    //   195: astore 12
    //   197: aload 13
    //   199: ifnull -48 -> 151
    //   202: aload 12
    //   204: ifnull -53 -> 151
    //   207: ldc_w 4777
    //   210: aload 13
    //   212: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifeq +26 -> 241
    //   218: aload 8
    //   220: astore 13
    //   222: aload 11
    //   224: astore 8
    //   226: aload 10
    //   228: astore 9
    //   230: aload 13
    //   232: astore 10
    //   234: aload 12
    //   236: astore 11
    //   238: goto +2970 -> 3208
    //   241: ldc_w 4779
    //   244: aload 13
    //   246: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq +22 -> 271
    //   252: aload 11
    //   254: astore 8
    //   256: aload 9
    //   258: astore 11
    //   260: aload 10
    //   262: astore 9
    //   264: aload 12
    //   266: astore 10
    //   268: goto +2940 -> 3208
    //   271: ldc_w 4781
    //   274: aload 13
    //   276: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   279: ifeq +57 -> 336
    //   282: ldc_w 301
    //   285: aload 12
    //   287: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   290: ifeq +2945 -> 3235
    //   293: aload 14
    //   295: ldc_w 4783
    //   298: aload_0
    //   299: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   302: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   305: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   308: pop
    //   309: aload 8
    //   311: astore 12
    //   313: aload 9
    //   315: astore 13
    //   317: aload 11
    //   319: astore 8
    //   321: aload 10
    //   323: astore 9
    //   325: aload 12
    //   327: astore 10
    //   329: aload 13
    //   331: astore 11
    //   333: goto +2875 -> 3208
    //   336: ldc_w 4785
    //   339: aload 13
    //   341: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   344: ifeq +89 -> 433
    //   347: ldc_w 301
    //   350: aload 12
    //   352: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   355: ifeq +2880 -> 3235
    //   358: aload_0
    //   359: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   362: invokevirtual 4401	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   365: astore 13
    //   367: aload 13
    //   369: astore 12
    //   371: aload 13
    //   373: invokestatic 4002	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   376: ifeq +19 -> 395
    //   379: aload_0
    //   380: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   383: aload_0
    //   384: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   387: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   390: invokestatic 4787	com/tencent/mobileqq/utils/ContactUtils:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   393: astore 12
    //   395: aload 14
    //   397: ldc_w 2614
    //   400: aload 12
    //   402: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   405: pop
    //   406: aload 8
    //   408: astore 12
    //   410: aload 9
    //   412: astore 13
    //   414: aload 11
    //   416: astore 8
    //   418: aload 10
    //   420: astore 9
    //   422: aload 12
    //   424: astore 10
    //   426: aload 13
    //   428: astore 11
    //   430: goto +2778 -> 3208
    //   433: ldc_w 2920
    //   436: aload 13
    //   438: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   441: ifeq +57 -> 498
    //   444: ldc_w 301
    //   447: aload 12
    //   449: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   452: ifeq +2783 -> 3235
    //   455: aload 14
    //   457: ldc_w 4789
    //   460: aload_0
    //   461: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   464: invokevirtual 2951	com/tencent/mobileqq/app/QQAppInterface:getvKeyStr	()Ljava/lang/String;
    //   467: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   470: pop
    //   471: aload 8
    //   473: astore 12
    //   475: aload 9
    //   477: astore 13
    //   479: aload 11
    //   481: astore 8
    //   483: aload 10
    //   485: astore 9
    //   487: aload 12
    //   489: astore 10
    //   491: aload 13
    //   493: astore 11
    //   495: goto +2713 -> 3208
    //   498: ldc_w 4791
    //   501: aload 13
    //   503: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   506: ifeq +53 -> 559
    //   509: ldc_w 301
    //   512: aload 12
    //   514: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   517: ifeq +2718 -> 3235
    //   520: aload 14
    //   522: ldc_w 4793
    //   525: invokestatic 760	java/lang/System:currentTimeMillis	()J
    //   528: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   531: pop
    //   532: aload 8
    //   534: astore 12
    //   536: aload 9
    //   538: astore 13
    //   540: aload 11
    //   542: astore 8
    //   544: aload 10
    //   546: astore 9
    //   548: aload 12
    //   550: astore 10
    //   552: aload 13
    //   554: astore 11
    //   556: goto +2652 -> 3208
    //   559: ldc_w 4795
    //   562: aload 13
    //   564: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   567: ifeq +90 -> 657
    //   570: ldc_w 301
    //   573: aload 12
    //   575: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   578: ifeq +2657 -> 3235
    //   581: aload 14
    //   583: ldc_w 4797
    //   586: aload_0
    //   587: getfield 56	com/tencent/mobileqq/utils/JumpAction:jdField_c_of_type_Boolean	Z
    //   590: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   593: pop
    //   594: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +2638 -> 3235
    //   600: ldc_w 4799
    //   603: iconst_2
    //   604: new 125	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 4801
    //   614: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_0
    //   618: getfield 56	com/tencent/mobileqq/utils/JumpAction:jdField_c_of_type_Boolean	Z
    //   621: invokevirtual 1291	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   624: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 1434	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: aload 8
    //   632: astore 12
    //   634: aload 9
    //   636: astore 13
    //   638: aload 11
    //   640: astore 8
    //   642: aload 10
    //   644: astore 9
    //   646: aload 12
    //   648: astore 10
    //   650: aload 13
    //   652: astore 11
    //   654: goto +2554 -> 3208
    //   657: ldc_w 4803
    //   660: aload 13
    //   662: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   665: ifeq +39 -> 704
    //   668: ldc_w 301
    //   671: aload 12
    //   673: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   676: ifeq +2559 -> 3235
    //   679: iconst_1
    //   680: istore_1
    //   681: aload 8
    //   683: astore 12
    //   685: aload 11
    //   687: astore 8
    //   689: aload 9
    //   691: astore 11
    //   693: aload 10
    //   695: astore 9
    //   697: aload 12
    //   699: astore 10
    //   701: goto +2507 -> 3208
    //   704: ldc_w 4805
    //   707: aload 13
    //   709: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   712: ifeq +30 -> 742
    //   715: aload 8
    //   717: astore 11
    //   719: aload 9
    //   721: astore 13
    //   723: aload 12
    //   725: astore 8
    //   727: aload 10
    //   729: astore 9
    //   731: aload 11
    //   733: astore 10
    //   735: aload 13
    //   737: astore 11
    //   739: goto +2469 -> 3208
    //   742: ldc_w 1469
    //   745: aload 13
    //   747: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   750: ifeq +26 -> 776
    //   753: aload 9
    //   755: astore 13
    //   757: aload 8
    //   759: astore 10
    //   761: aload 11
    //   763: astore 8
    //   765: aload 12
    //   767: astore 9
    //   769: aload 13
    //   771: astore 11
    //   773: goto +2435 -> 3208
    //   776: aload 14
    //   778: aload 13
    //   780: aload 12
    //   782: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   785: pop
    //   786: goto +2449 -> 3235
    //   789: aload 9
    //   791: ifnull +2471 -> 3262
    //   794: aload 8
    //   796: ifnull +2466 -> 3262
    //   799: ldc 60
    //   801: aload 9
    //   803: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   806: ifne +2456 -> 3262
    //   809: ldc 60
    //   811: aload 8
    //   813: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   816: ifeq +6 -> 822
    //   819: goto +2443 -> 3262
    //   822: aload_0
    //   823: getfield 4806	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_Boolean	Z
    //   826: ifeq +22 -> 848
    //   829: invokestatic 4811	com/tencent/mobileqq/utils/JumpFilterHelper:a	()Lcom/tencent/mobileqq/utils/JumpFilterHelper;
    //   832: aload_0
    //   833: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   836: aload 9
    //   838: aload 8
    //   840: invokevirtual 4814	com/tencent/mobileqq/utils/JumpFilterHelper:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   843: ifeq +5 -> 848
    //   846: iconst_0
    //   847: ireturn
    //   848: iconst_0
    //   849: istore 4
    //   851: iload 4
    //   853: istore_3
    //   854: aload 9
    //   856: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   859: ifne +38 -> 897
    //   862: getstatic 49	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   865: astore 12
    //   867: aload 12
    //   869: arraylength
    //   870: istore 5
    //   872: iconst_0
    //   873: istore_2
    //   874: iload 4
    //   876: istore_3
    //   877: iload_2
    //   878: iload 5
    //   880: if_icmpge +17 -> 897
    //   883: aload 9
    //   885: aload 12
    //   887: iload_2
    //   888: aaload
    //   889: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   892: ifeq +234 -> 1126
    //   895: iconst_1
    //   896: istore_3
    //   897: iload_3
    //   898: ifne +55 -> 953
    //   901: aload 14
    //   903: ldc_w 4789
    //   906: aconst_null
    //   907: checkcast 45	java/lang/String
    //   910: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   913: pop
    //   914: aload 14
    //   916: ldc_w 4816
    //   919: aconst_null
    //   920: checkcast 45	java/lang/String
    //   923: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   926: pop
    //   927: aload 14
    //   929: ldc_w 2614
    //   932: aconst_null
    //   933: checkcast 45	java/lang/String
    //   936: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   939: pop
    //   940: aload 14
    //   942: ldc_w 4783
    //   945: aconst_null
    //   946: checkcast 45	java/lang/String
    //   949: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   952: pop
    //   953: aload 8
    //   955: ldc_w 4346
    //   958: invokevirtual 644	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   961: ifeq +112 -> 1073
    //   964: aload 14
    //   966: ldc_w 4818
    //   969: ldc_w 4820
    //   972: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   975: pop
    //   976: aload_0
    //   977: getfield 62	com/tencent/mobileqq/utils/JumpAction:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   980: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   983: ifne +16 -> 999
    //   986: aload 14
    //   988: ldc_w 4822
    //   991: aload_0
    //   992: getfield 62	com/tencent/mobileqq/utils/JumpAction:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   995: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   998: pop
    //   999: aload_0
    //   1000: getfield 64	com/tencent/mobileqq/utils/JumpAction:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1003: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1006: ifne +16 -> 1022
    //   1009: aload 14
    //   1011: ldc_w 4824
    //   1014: aload_0
    //   1015: getfield 64	com/tencent/mobileqq/utils/JumpAction:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1018: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1021: pop
    //   1022: aload_0
    //   1023: getfield 66	com/tencent/mobileqq/utils/JumpAction:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1026: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1029: ifne +16 -> 1045
    //   1032: aload 14
    //   1034: ldc_w 4826
    //   1037: aload_0
    //   1038: getfield 66	com/tencent/mobileqq/utils/JumpAction:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1041: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1044: pop
    //   1045: aload 14
    //   1047: ldc_w 4828
    //   1050: aload_0
    //   1051: getfield 68	com/tencent/mobileqq/utils/JumpAction:jdField_e_of_type_Boolean	Z
    //   1054: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1057: pop
    //   1058: aload 14
    //   1060: aload 8
    //   1062: invokestatic 4834	cooperation/qzone/report/lp/QZoneLoginReportHelper:needAddLoginFromLebaTab	(Landroid/content/Intent;Ljava/lang/String;)Z
    //   1065: ifeq +8 -> 1073
    //   1068: aload 14
    //   1070: invokestatic 4837	cooperation/qzone/report/lp/QZoneLoginReportHelper:setLoginFromLebaTab	(Landroid/content/Intent;)V
    //   1073: iload_1
    //   1074: ifne +2087 -> 3161
    //   1077: aload 8
    //   1079: ldc_w 4346
    //   1082: invokevirtual 644	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1085: ifeq +104 -> 1189
    //   1088: aload 14
    //   1090: aload 8
    //   1092: invokestatic 4451	cooperation/qzone/QzonePluginProxyActivity:setActivityNameToIntent	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1095: aload 14
    //   1097: ldc_w 1309
    //   1100: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1103: pop
    //   1104: aload_0
    //   1105: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1108: checkcast 172	android/app/Activity
    //   1111: aload_0
    //   1112: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1115: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1118: aload 14
    //   1120: iconst_m1
    //   1121: invokestatic 4841	cooperation/qzone/QzonePluginProxyActivity:launchPluingActivityForResult	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;I)V
    //   1124: iconst_1
    //   1125: ireturn
    //   1126: iload_2
    //   1127: iconst_1
    //   1128: iadd
    //   1129: istore_2
    //   1130: goto -256 -> 874
    //   1133: astore 8
    //   1135: new 146	android/content/Intent
    //   1138: dup
    //   1139: aload_0
    //   1140: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1143: ldc_w 4843
    //   1146: invokespecial 224	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1149: astore 8
    //   1151: aload 8
    //   1153: ldc_w 1307
    //   1156: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1159: pop
    //   1160: aload 8
    //   1162: aload 14
    //   1164: invokevirtual 4614	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   1167: pop
    //   1168: aload_0
    //   1169: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1172: aload 8
    //   1174: invokevirtual 228	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1177: goto -53 -> 1124
    //   1180: astore 8
    //   1182: aload 8
    //   1184: invokevirtual 4844	android/content/ActivityNotFoundException:printStackTrace	()V
    //   1187: iconst_0
    //   1188: ireturn
    //   1189: aload 8
    //   1191: ldc_w 4846
    //   1194: invokevirtual 3006	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1197: ifeq +60 -> 1257
    //   1200: aload_0
    //   1201: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1204: aload_0
    //   1205: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1208: invokestatic 2300	com/tencent/mobileqq/troop/data/NearbyTroops:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)V
    //   1211: aload_0
    //   1212: getfield 58	com/tencent/mobileqq/utils/JumpAction:jdField_d_of_type_Boolean	Z
    //   1215: ifeq +2049 -> 3264
    //   1218: ldc_w 554
    //   1221: astore 8
    //   1223: aload_0
    //   1224: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1227: ldc_w 800
    //   1230: ldc_w 4848
    //   1233: ldc 60
    //   1235: ldc_w 4850
    //   1238: ldc_w 4852
    //   1241: iconst_0
    //   1242: iconst_0
    //   1243: ldc 60
    //   1245: ldc 60
    //   1247: ldc 60
    //   1249: aload 8
    //   1251: invokestatic 215	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1254: goto -130 -> 1124
    //   1257: aload 8
    //   1259: ldc_w 4854
    //   1262: invokevirtual 3006	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1265: istore 6
    //   1267: iload 6
    //   1269: ifeq +233 -> 1502
    //   1272: aload_0
    //   1273: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1276: checkcast 4388	android/support/v4/app/FragmentActivity
    //   1279: invokevirtual 4407	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   1282: astore 9
    //   1284: aload 9
    //   1286: ifnull -162 -> 1124
    //   1289: aload 9
    //   1291: invokevirtual 4412	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   1294: ifnull -170 -> 1124
    //   1297: aload 9
    //   1299: invokevirtual 4412	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   1302: invokevirtual 4856	com/tencent/mobileqq/activity/aio/core/BaseChatPie:aG	()V
    //   1305: aload 9
    //   1307: invokevirtual 4412	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   1310: getfield 4859	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1313: getfield 4860	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   1316: istore_1
    //   1317: aload 14
    //   1319: ldc_w 772
    //   1322: aload_0
    //   1323: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1326: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1329: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1332: pop
    //   1333: aload 14
    //   1335: ldc_w 4862
    //   1338: iload_1
    //   1339: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1342: pop
    //   1343: aload 14
    //   1345: ldc_w 2291
    //   1348: invokevirtual 3154	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1351: astore 11
    //   1353: aload 14
    //   1355: ldc_w 2289
    //   1358: invokevirtual 3154	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1361: astore 10
    //   1363: aload 14
    //   1365: ldc_w 4864
    //   1368: invokevirtual 3154	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1371: astore 9
    //   1373: aload 11
    //   1375: ifnull +79 -> 1454
    //   1378: aload 10
    //   1380: ifnull +74 -> 1454
    //   1383: aload 11
    //   1385: invokestatic 4869	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1388: astore 11
    //   1390: aload 10
    //   1392: invokestatic 4869	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1395: astore 10
    //   1397: aload 14
    //   1399: ldc 185
    //   1401: new 125	java/lang/StringBuilder
    //   1404: dup
    //   1405: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1408: ldc_w 4871
    //   1411: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: aload 11
    //   1416: invokevirtual 1280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1419: ldc_w 2328
    //   1422: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: aload 10
    //   1427: invokevirtual 1280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1430: ldc_w 4873
    //   1433: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: aload 9
    //   1438: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: ldc_w 4875
    //   1444: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1450: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1453: pop
    //   1454: aload 14
    //   1456: aload_0
    //   1457: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1460: invokevirtual 4878	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1463: aload 8
    //   1465: invokevirtual 1829	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1468: pop
    //   1469: aload_0
    //   1470: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1473: checkcast 1659	com/tencent/mobileqq/app/BaseActivity
    //   1476: aload 14
    //   1478: bipush 18
    //   1480: invokevirtual 4692	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1483: ldc_w 4880
    //   1486: invokestatic 4883	com/tencent/biz/widgets/QQMapRoutingHelper:a	(Ljava/lang/String;)V
    //   1489: goto -365 -> 1124
    //   1492: astore 8
    //   1494: aload 8
    //   1496: invokevirtual 1227	java/lang/Exception:printStackTrace	()V
    //   1499: goto -375 -> 1124
    //   1502: aload 8
    //   1504: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1507: ifne +286 -> 1793
    //   1510: aload 9
    //   1512: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1515: ifne +278 -> 1793
    //   1518: aload 8
    //   1520: ldc_w 4885
    //   1523: invokevirtual 654	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1526: ifeq +267 -> 1793
    //   1529: aload 9
    //   1531: ldc 47
    //   1533: invokevirtual 654	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1536: ifeq +257 -> 1793
    //   1539: new 1411	java/lang/StringBuffer
    //   1542: dup
    //   1543: invokespecial 1412	java/lang/StringBuffer:<init>	()V
    //   1546: astore 12
    //   1548: aload_0
    //   1549: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   1552: ifnull +229 -> 1781
    //   1555: aload_0
    //   1556: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   1559: getfield 4887	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1562: invokevirtual 1855	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1565: ifle +216 -> 1781
    //   1568: aload_0
    //   1569: getfield 56	com/tencent/mobileqq/utils/JumpAction:jdField_c_of_type_Boolean	Z
    //   1572: ifeq +209 -> 1781
    //   1575: aload 12
    //   1577: ldc_w 4889
    //   1580: invokevirtual 2923	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1583: pop
    //   1584: aload_0
    //   1585: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   1588: getfield 4887	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1591: invokevirtual 4890	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1594: ifeq +38 -> 1632
    //   1597: aload 12
    //   1599: new 125	java/lang/StringBuilder
    //   1602: dup
    //   1603: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1606: ldc_w 4892
    //   1609: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: aload_0
    //   1613: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   1616: getfield 4887	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1619: invokevirtual 1855	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1622: invokevirtual 747	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1625: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1628: invokevirtual 2923	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1631: pop
    //   1632: aload_0
    //   1633: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   1636: getfield 1884	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1639: invokevirtual 1888	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1642: istore 6
    //   1644: iload 6
    //   1646: ifeq +48 -> 1694
    //   1649: aload_0
    //   1650: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   1653: getfield 1884	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1656: invokevirtual 1890	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1659: ldc_w 1597
    //   1662: invokestatic 1603	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1665: astore 10
    //   1667: aload 12
    //   1669: new 125	java/lang/StringBuilder
    //   1672: dup
    //   1673: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1676: ldc_w 4894
    //   1679: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: aload 10
    //   1684: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1690: invokevirtual 2923	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1693: pop
    //   1694: aload_0
    //   1695: ldc 185
    //   1697: invokevirtual 434	com/tencent/mobileqq/utils/JumpAction:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1700: astore 11
    //   1702: aload 11
    //   1704: astore 10
    //   1706: aload 11
    //   1708: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1711: ifne +27 -> 1738
    //   1714: aload 11
    //   1716: astore 10
    //   1718: aload 11
    //   1720: invokestatic 4898	com/tencent/biz/qrcode/util/QRUtils:g	(Ljava/lang/String;)Z
    //   1723: ifeq +15 -> 1738
    //   1726: aload 11
    //   1728: aload 12
    //   1730: invokevirtual 2962	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1733: invokestatic 4902	com/tencent/biz/common/offline/HtmlOffline:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1736: astore 10
    //   1738: aload_0
    //   1739: aload 10
    //   1741: aload 9
    //   1743: aload 8
    //   1745: aload 14
    //   1747: invokespecial 4904	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1750: aload_0
    //   1751: aload 8
    //   1753: invokespecial 4906	com/tencent/mobileqq/utils/JumpAction:g	(Ljava/lang/String;)V
    //   1756: goto -632 -> 1124
    //   1759: astore 10
    //   1761: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1764: ifeq +1508 -> 3272
    //   1767: ldc 123
    //   1769: iconst_2
    //   1770: aload 10
    //   1772: invokevirtual 4907	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   1775: invokestatic 1434	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1778: goto +1494 -> 3272
    //   1781: aload 12
    //   1783: ldc_w 4909
    //   1786: invokevirtual 2923	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1789: pop
    //   1790: goto -96 -> 1694
    //   1793: aload 8
    //   1795: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1798: ifne +545 -> 2343
    //   1801: aload 9
    //   1803: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1806: ifne +537 -> 2343
    //   1809: aload 8
    //   1811: ldc_w 4911
    //   1814: invokevirtual 654	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1817: ifeq +526 -> 2343
    //   1820: aload 9
    //   1822: ldc 47
    //   1824: invokevirtual 654	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1827: ifeq +516 -> 2343
    //   1830: aload_0
    //   1831: ldc 185
    //   1833: invokevirtual 434	com/tencent/mobileqq/utils/JumpAction:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1836: astore 10
    //   1838: aload 10
    //   1840: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1843: ifeq +454 -> 2297
    //   1846: ldc_w 4913
    //   1849: astore 10
    //   1851: new 125	java/lang/StringBuilder
    //   1854: dup
    //   1855: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1858: ldc_w 4915
    //   1861: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1864: invokestatic 760	java/lang/System:currentTimeMillis	()J
    //   1867: invokevirtual 1403	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1870: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1873: astore 12
    //   1875: aload 12
    //   1877: astore 11
    //   1879: aload_0
    //   1880: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1883: ifnull +51 -> 1934
    //   1886: aload 12
    //   1888: astore 11
    //   1890: invokestatic 4920	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   1893: aload 10
    //   1895: invokevirtual 4922	com/tencent/biz/AuthorizeConfig:i	(Ljava/lang/String;)Z
    //   1898: ifeq +36 -> 1934
    //   1901: new 125	java/lang/StringBuilder
    //   1904: dup
    //   1905: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1908: aload 12
    //   1910: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1913: ldc_w 668
    //   1916: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: aload_0
    //   1920: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1923: invokevirtual 671	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1926: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1932: astore 11
    //   1934: aload 11
    //   1936: astore 12
    //   1938: aload_0
    //   1939: getfield 1683	com/tencent/mobileqq/utils/JumpAction:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1942: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1945: ifne +33 -> 1978
    //   1948: new 125	java/lang/StringBuilder
    //   1951: dup
    //   1952: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1955: aload 11
    //   1957: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1960: ldc_w 2928
    //   1963: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: aload_0
    //   1967: getfield 1683	com/tencent/mobileqq/utils/JumpAction:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1970: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1973: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1976: astore 12
    //   1978: aload 12
    //   1980: astore 11
    //   1982: aload 10
    //   1984: ldc_w 662
    //   1987: invokevirtual 564	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1990: ifge +26 -> 2016
    //   1993: new 125	java/lang/StringBuilder
    //   1996: dup
    //   1997: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   2000: aload 12
    //   2002: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2005: ldc_w 4924
    //   2008: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2014: astore 11
    //   2016: aload 10
    //   2018: aload 11
    //   2020: invokestatic 4902	com/tencent/biz/common/offline/HtmlOffline:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2023: astore 10
    //   2025: aload_0
    //   2026: ldc_w 4775
    //   2029: invokevirtual 434	com/tencent/mobileqq/utils/JumpAction:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2032: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2035: ifne +1243 -> 3278
    //   2038: iconst_1
    //   2039: istore 6
    //   2041: iload 6
    //   2043: ifeq +1162 -> 3205
    //   2046: aload_0
    //   2047: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2050: ifnull +1155 -> 3205
    //   2053: aload_0
    //   2054: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2057: getstatic 4927	com/tencent/mobileqq/app/QQManagerFactory:GAMECENTER_MANAGER	I
    //   2060: invokevirtual 268	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2063: checkcast 4929	com/tencent/mobileqq/servlet/GameCenterManagerImp
    //   2066: astore 11
    //   2068: iconst_0
    //   2069: istore_1
    //   2070: aload_0
    //   2071: getfield 58	com/tencent/mobileqq/utils/JumpAction:jdField_d_of_type_Boolean	Z
    //   2074: ifeq +12 -> 2086
    //   2077: aload_0
    //   2078: getfield 1845	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   2081: iconst_1
    //   2082: invokestatic 4934	com/tencent/mobileqq/gamecenter/data/PadFaceManager:a	(Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;Z)I
    //   2085: istore_1
    //   2086: aload 11
    //   2088: invokevirtual 4937	com/tencent/mobileqq/servlet/GameCenterManagerImp:a	()Lcom/tencent/mobileqq/gamecenter/data/PadFaceManager;
    //   2091: iload_1
    //   2092: invokevirtual 4940	com/tencent/mobileqq/gamecenter/data/PadFaceManager:a	(I)Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;
    //   2095: astore 11
    //   2097: aload 11
    //   2099: ifnull +1106 -> 3205
    //   2102: ldc 123
    //   2104: iconst_2
    //   2105: iconst_2
    //   2106: anewarray 4	java/lang/Object
    //   2109: dup
    //   2110: iconst_0
    //   2111: ldc_w 4942
    //   2114: aastore
    //   2115: dup
    //   2116: iconst_1
    //   2117: aload 11
    //   2119: aastore
    //   2120: invokestatic 522	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2123: aload 10
    //   2125: ldc_w 4944
    //   2128: invokestatic 4902	com/tencent/biz/common/offline/HtmlOffline:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2131: astore 10
    //   2133: aload 11
    //   2135: aload 14
    //   2137: invokestatic 4947	com/tencent/mobileqq/gamecenter/data/PadFaceManager:a	(Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;Landroid/content/Intent;)Landroid/content/Intent;
    //   2140: pop
    //   2141: ldc_w 4949
    //   2144: invokestatic 4950	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	(Ljava/lang/String;)I
    //   2147: istore_1
    //   2148: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2151: ifeq +40 -> 2191
    //   2154: ldc 123
    //   2156: iconst_2
    //   2157: new 125	java/lang/StringBuilder
    //   2160: dup
    //   2161: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   2164: ldc_w 4952
    //   2167: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2170: iload_1
    //   2171: invokevirtual 747	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2174: ldc_w 4954
    //   2177: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2180: iload 6
    //   2182: invokevirtual 1291	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2185: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2188: invokestatic 600	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2191: iload_1
    //   2192: ifne +130 -> 2322
    //   2195: iload 6
    //   2197: ifeq +125 -> 2322
    //   2200: aload_0
    //   2201: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2204: aload 10
    //   2206: ldc_w 4956
    //   2209: invokestatic 4957	com/tencent/mobileqq/gamecenter/util/QQGameHelper:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   2212: iload 6
    //   2214: ifeq +10 -> 2224
    //   2217: invokestatic 4962	com/tencent/hippy/qq/utils/HippyReporter:getInstance	()Lcom/tencent/hippy/qq/utils/HippyReporter;
    //   2220: iload_1
    //   2221: invokevirtual 4965	com/tencent/hippy/qq/utils/HippyReporter:reportGameCenterHippy	(I)V
    //   2224: aload_0
    //   2225: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2228: ifnull +37 -> 2265
    //   2231: aload_0
    //   2232: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2235: ldc_w 4967
    //   2238: invokevirtual 4971	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   2241: astore 8
    //   2243: aload 8
    //   2245: ifnull +20 -> 2265
    //   2248: aload 8
    //   2250: aload 8
    //   2252: ldc_w 4972
    //   2255: invokevirtual 4976	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   2258: ldc2_w 4977
    //   2261: invokevirtual 4982	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   2264: pop
    //   2265: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2268: ifeq +12 -> 2280
    //   2271: ldc 123
    //   2273: iconst_2
    //   2274: ldc_w 4984
    //   2277: invokestatic 600	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2280: new 4986	com/tencent/mobileqq/utils/JumpAction$26
    //   2283: dup
    //   2284: aload_0
    //   2285: invokespecial 4987	com/tencent/mobileqq/utils/JumpAction$26:<init>	(Lcom/tencent/mobileqq/utils/JumpAction;)V
    //   2288: iconst_5
    //   2289: aconst_null
    //   2290: iconst_1
    //   2291: invokestatic 609	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2294: goto -1170 -> 1124
    //   2297: aload 10
    //   2299: invokestatic 576	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   2302: astore 10
    //   2304: goto -453 -> 1851
    //   2307: astore 10
    //   2309: aload 10
    //   2311: invokevirtual 1227	java/lang/Exception:printStackTrace	()V
    //   2314: ldc_w 4913
    //   2317: astore 10
    //   2319: goto -468 -> 1851
    //   2322: aload_0
    //   2323: aload 10
    //   2325: aload 9
    //   2327: aload 8
    //   2329: aload 14
    //   2331: invokespecial 4904	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2334: aload_0
    //   2335: aload 8
    //   2337: invokespecial 4906	com/tencent/mobileqq/utils/JumpAction:g	(Ljava/lang/String;)V
    //   2340: goto -128 -> 2212
    //   2343: aload 8
    //   2345: ldc_w 4989
    //   2348: invokevirtual 3006	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2351: ifeq +182 -> 2533
    //   2354: aload_0
    //   2355: ldc_w 975
    //   2358: invokevirtual 434	com/tencent/mobileqq/utils/JumpAction:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2361: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2364: ifne +52 -> 2416
    //   2367: aload 14
    //   2369: ldc_w 4991
    //   2372: iconst_4
    //   2373: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2376: pop
    //   2377: aload 14
    //   2379: ldc_w 4993
    //   2382: aload 14
    //   2384: ldc_w 4993
    //   2387: iconst_1
    //   2388: invokevirtual 3157	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2391: iconst_4
    //   2392: ior
    //   2393: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2396: pop
    //   2397: aload_0
    //   2398: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2401: aload_0
    //   2402: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2405: checkcast 172	android/app/Activity
    //   2408: aload 14
    //   2410: invokestatic 4996	cooperation/readinjoy/ReadInJoyHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2413: goto -1289 -> 1124
    //   2416: ldc_w 3493
    //   2419: invokestatic 251	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2422: checkcast 3493	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   2425: aload_0
    //   2426: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2429: ldc_w 1739
    //   2432: ldc 60
    //   2434: ldc 60
    //   2436: ldc_w 4998
    //   2439: ldc_w 4998
    //   2442: iconst_0
    //   2443: iconst_0
    //   2444: ldc 60
    //   2446: ldc 60
    //   2448: ldc 60
    //   2450: ldc 60
    //   2452: iconst_0
    //   2453: invokeinterface 3499 14 0
    //   2458: invokestatic 5003	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:a	()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   2461: invokestatic 5003	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:a	()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   2464: invokevirtual 5004	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:b	()Z
    //   2467: ldc_w 5006
    //   2470: iconst_1
    //   2471: invokevirtual 5009	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:a	(ZLjava/lang/String;I)V
    //   2474: aload 14
    //   2476: ldc_w 4991
    //   2479: iconst_1
    //   2480: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2483: pop
    //   2484: aload 14
    //   2486: ldc_w 5011
    //   2489: invokestatic 760	java/lang/System:currentTimeMillis	()J
    //   2492: invokevirtual 763	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2495: pop
    //   2496: aload_0
    //   2497: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2500: getstatic 5014	com/tencent/mobileqq/app/QQManagerFactory:READINJOY_MANAGER	I
    //   2503: invokevirtual 268	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2506: checkcast 5016	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager
    //   2509: aload 14
    //   2511: invokevirtual 5017	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager:a	(Landroid/content/Intent;)V
    //   2514: aload_0
    //   2515: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2518: aload_0
    //   2519: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2522: checkcast 172	android/app/Activity
    //   2525: aload 14
    //   2527: invokestatic 4996	cooperation/readinjoy/ReadInJoyHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2530: goto -1406 -> 1124
    //   2533: aload 8
    //   2535: ldc_w 4846
    //   2538: invokevirtual 3006	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2541: ifeq +14 -> 2555
    //   2544: aload 14
    //   2546: ldc_w 975
    //   2549: bipush 15
    //   2551: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2554: pop
    //   2555: aload 8
    //   2557: ldc_w 5019
    //   2560: invokevirtual 3006	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2563: ifeq +16 -> 2579
    //   2566: aload 14
    //   2568: ldc_w 5021
    //   2571: aload_0
    //   2572: getfield 501	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2575: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2578: pop
    //   2579: aload 8
    //   2581: getstatic 5022	cooperation/comic/VipComicJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2584: invokevirtual 3006	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2587: ifeq +57 -> 2644
    //   2590: aload 14
    //   2592: ldc_w 3024
    //   2595: aload_0
    //   2596: getfield 58	com/tencent/mobileqq/utils/JumpAction:jdField_d_of_type_Boolean	Z
    //   2599: aload_0
    //   2600: getfield 56	com/tencent/mobileqq/utils/JumpAction:jdField_c_of_type_Boolean	Z
    //   2603: ior
    //   2604: invokevirtual 1318	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2607: pop
    //   2608: aload 14
    //   2610: invokestatic 5025	cooperation/comic/VipComicJumpActivity:a	(Landroid/content/Intent;)Lcooperation/comic/VipComicJumpActivity$ComicParam;
    //   2613: astore 11
    //   2615: aload_0
    //   2616: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2619: aload_0
    //   2620: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2623: checkcast 172	android/app/Activity
    //   2626: aload 11
    //   2628: invokestatic 5028	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lcooperation/comic/VipComicJumpActivity$ComicParam;)Z
    //   2631: ifeq +13 -> 2644
    //   2634: aload_0
    //   2635: getfield 104	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2638: iconst_1
    //   2639: invokestatic 5031	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Z)V
    //   2642: iconst_1
    //   2643: ireturn
    //   2644: aload 9
    //   2646: ifnull -1522 -> 1124
    //   2649: aload 9
    //   2651: invokestatic 1175	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2654: invokevirtual 5032	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   2657: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2660: istore 6
    //   2662: iload 6
    //   2664: ifeq +457 -> 3121
    //   2667: iconst_0
    //   2668: istore 6
    //   2670: ldc_w 5034
    //   2673: invokestatic 1175	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2676: invokevirtual 5038	com/tencent/qphone/base/util/BaseApplication:getClassLoader	()Ljava/lang/ClassLoader;
    //   2679: aload 8
    //   2681: invokevirtual 5044	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   2684: invokevirtual 5048	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   2687: istore 7
    //   2689: iload 7
    //   2691: istore 6
    //   2693: iload 6
    //   2695: ifeq +5 -> 2700
    //   2698: iconst_0
    //   2699: ireturn
    //   2700: aload 14
    //   2702: ldc_w 5050
    //   2705: invokevirtual 3154	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2708: astore 11
    //   2710: aload 11
    //   2712: ifnull +488 -> 3200
    //   2715: aload 11
    //   2717: invokestatic 121	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2720: istore_1
    //   2721: aload 8
    //   2723: ldc_w 5052
    //   2726: invokevirtual 654	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2729: ifeq +203 -> 2932
    //   2732: ldc_w 5054
    //   2735: invokestatic 251	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2738: checkcast 5054	com/tencent/biz/pubaccount/api/IPublicAccountProxy
    //   2741: ldc_w 5056
    //   2744: invokeinterface 5060 2 0
    //   2749: astore 8
    //   2751: ldc_w 5054
    //   2754: invokestatic 251	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2757: checkcast 5054	com/tencent/biz/pubaccount/api/IPublicAccountProxy
    //   2760: ldc_w 5062
    //   2763: invokeinterface 5060 2 0
    //   2768: aload 8
    //   2770: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2773: ifeq +249 -> 3022
    //   2776: aload 14
    //   2778: ldc_w 5064
    //   2781: invokevirtual 3154	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2784: astore 11
    //   2786: aload 11
    //   2788: ifnull +406 -> 3194
    //   2791: aload 11
    //   2793: invokestatic 121	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2796: iconst_2
    //   2797: if_icmpne +397 -> 3194
    //   2800: iload_1
    //   2801: invokestatic 5068	com/tencent/qidian/QidianManager:b	(I)Z
    //   2804: ifeq +183 -> 2987
    //   2807: aload 14
    //   2809: ldc_w 5050
    //   2812: iload_1
    //   2813: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2816: pop
    //   2817: ldc_w 5070
    //   2820: astore 8
    //   2822: aload 10
    //   2824: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2827: ifne +182 -> 3009
    //   2830: aload 10
    //   2832: invokevirtual 5073	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2835: ldc_w 257
    //   2838: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2841: ifeq +168 -> 3009
    //   2844: aload 14
    //   2846: ldc_w 863
    //   2849: bipush 117
    //   2851: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2854: pop
    //   2855: aload 14
    //   2857: ldc_w 1235
    //   2860: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2863: pop
    //   2864: ldc_w 5075
    //   2867: aload 8
    //   2869: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2872: ifeq +221 -> 3093
    //   2875: aload 14
    //   2877: ldc 185
    //   2879: invokevirtual 3154	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2882: astore 10
    //   2884: aload 10
    //   2886: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2889: ifne +204 -> 3093
    //   2892: aload 10
    //   2894: ldc_w 4560
    //   2897: invokevirtual 644	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2900: ifne +193 -> 3093
    //   2903: ldc 123
    //   2905: iconst_1
    //   2906: new 125	java/lang/StringBuilder
    //   2909: dup
    //   2910: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   2913: ldc_w 5077
    //   2916: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2919: aload 10
    //   2921: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2924: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2927: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2930: iconst_0
    //   2931: ireturn
    //   2932: aload 8
    //   2934: ldc_w 5079
    //   2937: invokevirtual 654	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2940: ifne +25 -> 2965
    //   2943: ldc_w 5081
    //   2946: aload 8
    //   2948: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2951: ifne +14 -> 2965
    //   2954: ldc_w 5083
    //   2957: aload 8
    //   2959: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2962: ifeq +235 -> 3197
    //   2965: ldc_w 5054
    //   2968: invokestatic 251	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2971: checkcast 5054	com/tencent/biz/pubaccount/api/IPublicAccountProxy
    //   2974: ldc_w 5062
    //   2977: invokeinterface 5060 2 0
    //   2982: astore 8
    //   2984: goto -233 -> 2751
    //   2987: ldc_w 5054
    //   2990: invokestatic 251	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2993: checkcast 5054	com/tencent/biz/pubaccount/api/IPublicAccountProxy
    //   2996: ldc_w 5056
    //   2999: invokeinterface 5060 2 0
    //   3004: astore 8
    //   3006: goto -184 -> 2822
    //   3009: aload 14
    //   3011: ldc_w 863
    //   3014: iconst_2
    //   3015: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3018: pop
    //   3019: goto -164 -> 2855
    //   3022: ldc_w 5054
    //   3025: invokestatic 251	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3028: checkcast 5054	com/tencent/biz/pubaccount/api/IPublicAccountProxy
    //   3031: ldc_w 5056
    //   3034: invokeinterface 5060 2 0
    //   3039: aload 8
    //   3041: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3044: ifeq +28 -> 3072
    //   3047: iload_1
    //   3048: invokestatic 5068	com/tencent/qidian/QidianManager:b	(I)Z
    //   3051: ifeq +240 -> 3291
    //   3054: ldc_w 5070
    //   3057: astore 8
    //   3059: aload 14
    //   3061: ldc_w 5050
    //   3064: iload_1
    //   3065: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3068: pop
    //   3069: goto -205 -> 2864
    //   3072: aload 14
    //   3074: ldc_w 1831
    //   3077: invokevirtual 1638	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   3080: pop
    //   3081: aload 14
    //   3083: ldc_w 1307
    //   3086: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   3089: pop
    //   3090: goto +201 -> 3291
    //   3093: aload 14
    //   3095: aload 9
    //   3097: aload 8
    //   3099: invokevirtual 1829	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3102: pop
    //   3103: aload_0
    //   3104: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3107: aload 14
    //   3109: invokevirtual 228	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   3112: aload_0
    //   3113: aload 8
    //   3115: invokespecial 4906	com/tencent/mobileqq/utils/JumpAction:g	(Ljava/lang/String;)V
    //   3118: goto -1994 -> 1124
    //   3121: aload 14
    //   3123: aload 9
    //   3125: aload 8
    //   3127: invokevirtual 1829	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3130: pop
    //   3131: aload 14
    //   3133: ldc_w 1831
    //   3136: invokevirtual 1638	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   3139: pop
    //   3140: aload 14
    //   3142: ldc_w 1307
    //   3145: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   3148: pop
    //   3149: aload_0
    //   3150: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3153: aload 14
    //   3155: invokevirtual 228	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   3158: goto -2034 -> 1124
    //   3161: iload_1
    //   3162: iconst_1
    //   3163: if_icmpne -2039 -> 1124
    //   3166: aload 11
    //   3168: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3171: ifne -2047 -> 1124
    //   3174: aload_0
    //   3175: aload 14
    //   3177: aload 8
    //   3179: aload 11
    //   3181: invokespecial 5085	com/tencent/mobileqq/utils/JumpAction:a	(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Z
    //   3184: istore 6
    //   3186: iload 6
    //   3188: ireturn
    //   3189: astore 11
    //   3191: goto -498 -> 2693
    //   3194: goto -372 -> 2822
    //   3197: goto -446 -> 2751
    //   3200: iconst_0
    //   3201: istore_1
    //   3202: goto -481 -> 2721
    //   3205: goto -1064 -> 2141
    //   3208: aload 10
    //   3210: astore 12
    //   3212: aload 11
    //   3214: astore 13
    //   3216: aload 8
    //   3218: astore 11
    //   3220: aload 9
    //   3222: astore 10
    //   3224: aload 12
    //   3226: astore 8
    //   3228: aload 13
    //   3230: astore 9
    //   3232: goto -3081 -> 151
    //   3235: aload 8
    //   3237: astore 12
    //   3239: aload 9
    //   3241: astore 13
    //   3243: aload 11
    //   3245: astore 8
    //   3247: aload 10
    //   3249: astore 9
    //   3251: aload 12
    //   3253: astore 10
    //   3255: aload 13
    //   3257: astore 11
    //   3259: goto -51 -> 3208
    //   3262: iconst_0
    //   3263: ireturn
    //   3264: ldc_w 301
    //   3267: astore 8
    //   3269: goto -2046 -> 1223
    //   3272: aconst_null
    //   3273: astore 10
    //   3275: goto -1608 -> 1667
    //   3278: iconst_0
    //   3279: istore 6
    //   3281: goto -1240 -> 2041
    //   3284: astore 11
    //   3286: iconst_0
    //   3287: istore_1
    //   3288: goto -567 -> 2721
    //   3291: goto -427 -> 2864
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3294	0	this	JumpAction
    //   37	3251	1	i1	int
    //   873	257	2	i2	int
    //   853	45	3	i3	int
    //   849	26	4	i4	int
    //   870	11	5	i5	int
    //   1265	2015	6	bool1	boolean
    //   2687	3	7	bool2	boolean
    //   22	1069	8	localObject1	Object
    //   1133	1	8	localException1	Exception
    //   1149	24	8	localIntent1	Intent
    //   1180	10	8	localActivityNotFoundException	android.content.ActivityNotFoundException
    //   1221	243	8	str1	String
    //   1492	318	8	localException2	Exception
    //   2241	1027	8	localObject2	Object
    //   19	3231	9	localObject3	Object
    //   25	1715	10	localObject4	Object
    //   1759	12	10	localUnsupportedEncodingException	UnsupportedEncodingException
    //   1836	467	10	str2	String
    //   2307	3	10	localException3	Exception
    //   2317	957	10	localObject5	Object
    //   40	3140	11	localObject6	Object
    //   3189	24	11	localException4	Exception
    //   3218	40	11	localObject7	Object
    //   3284	1	11	localException5	Exception
    //   34	3218	12	localObject8	Object
    //   49	3207	13	localObject9	Object
    //   10	3166	14	localIntent2	Intent
    //   149	13	15	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   1104	1124	1133	java/lang/Exception
    //   0	18	1180	android/content/ActivityNotFoundException
    //   27	36	1180	android/content/ActivityNotFoundException
    //   42	70	1180	android/content/ActivityNotFoundException
    //   70	142	1180	android/content/ActivityNotFoundException
    //   142	151	1180	android/content/ActivityNotFoundException
    //   151	197	1180	android/content/ActivityNotFoundException
    //   207	218	1180	android/content/ActivityNotFoundException
    //   241	252	1180	android/content/ActivityNotFoundException
    //   271	309	1180	android/content/ActivityNotFoundException
    //   336	367	1180	android/content/ActivityNotFoundException
    //   371	395	1180	android/content/ActivityNotFoundException
    //   395	406	1180	android/content/ActivityNotFoundException
    //   433	471	1180	android/content/ActivityNotFoundException
    //   498	532	1180	android/content/ActivityNotFoundException
    //   559	630	1180	android/content/ActivityNotFoundException
    //   657	679	1180	android/content/ActivityNotFoundException
    //   704	715	1180	android/content/ActivityNotFoundException
    //   742	753	1180	android/content/ActivityNotFoundException
    //   776	786	1180	android/content/ActivityNotFoundException
    //   799	819	1180	android/content/ActivityNotFoundException
    //   822	846	1180	android/content/ActivityNotFoundException
    //   854	872	1180	android/content/ActivityNotFoundException
    //   883	895	1180	android/content/ActivityNotFoundException
    //   901	953	1180	android/content/ActivityNotFoundException
    //   953	999	1180	android/content/ActivityNotFoundException
    //   999	1022	1180	android/content/ActivityNotFoundException
    //   1022	1045	1180	android/content/ActivityNotFoundException
    //   1045	1073	1180	android/content/ActivityNotFoundException
    //   1077	1104	1180	android/content/ActivityNotFoundException
    //   1104	1124	1180	android/content/ActivityNotFoundException
    //   1135	1177	1180	android/content/ActivityNotFoundException
    //   1189	1218	1180	android/content/ActivityNotFoundException
    //   1223	1254	1180	android/content/ActivityNotFoundException
    //   1257	1267	1180	android/content/ActivityNotFoundException
    //   1272	1284	1180	android/content/ActivityNotFoundException
    //   1289	1373	1180	android/content/ActivityNotFoundException
    //   1383	1454	1180	android/content/ActivityNotFoundException
    //   1454	1489	1180	android/content/ActivityNotFoundException
    //   1494	1499	1180	android/content/ActivityNotFoundException
    //   1502	1632	1180	android/content/ActivityNotFoundException
    //   1632	1644	1180	android/content/ActivityNotFoundException
    //   1649	1667	1180	android/content/ActivityNotFoundException
    //   1667	1694	1180	android/content/ActivityNotFoundException
    //   1694	1702	1180	android/content/ActivityNotFoundException
    //   1706	1714	1180	android/content/ActivityNotFoundException
    //   1718	1738	1180	android/content/ActivityNotFoundException
    //   1738	1756	1180	android/content/ActivityNotFoundException
    //   1761	1778	1180	android/content/ActivityNotFoundException
    //   1781	1790	1180	android/content/ActivityNotFoundException
    //   1793	1846	1180	android/content/ActivityNotFoundException
    //   1851	1875	1180	android/content/ActivityNotFoundException
    //   1879	1886	1180	android/content/ActivityNotFoundException
    //   1890	1934	1180	android/content/ActivityNotFoundException
    //   1938	1978	1180	android/content/ActivityNotFoundException
    //   1982	2016	1180	android/content/ActivityNotFoundException
    //   2016	2038	1180	android/content/ActivityNotFoundException
    //   2046	2068	1180	android/content/ActivityNotFoundException
    //   2070	2086	1180	android/content/ActivityNotFoundException
    //   2086	2097	1180	android/content/ActivityNotFoundException
    //   2102	2141	1180	android/content/ActivityNotFoundException
    //   2141	2191	1180	android/content/ActivityNotFoundException
    //   2200	2212	1180	android/content/ActivityNotFoundException
    //   2217	2224	1180	android/content/ActivityNotFoundException
    //   2224	2243	1180	android/content/ActivityNotFoundException
    //   2248	2265	1180	android/content/ActivityNotFoundException
    //   2265	2280	1180	android/content/ActivityNotFoundException
    //   2280	2294	1180	android/content/ActivityNotFoundException
    //   2297	2304	1180	android/content/ActivityNotFoundException
    //   2309	2314	1180	android/content/ActivityNotFoundException
    //   2322	2340	1180	android/content/ActivityNotFoundException
    //   2343	2413	1180	android/content/ActivityNotFoundException
    //   2416	2530	1180	android/content/ActivityNotFoundException
    //   2533	2555	1180	android/content/ActivityNotFoundException
    //   2555	2579	1180	android/content/ActivityNotFoundException
    //   2579	2642	1180	android/content/ActivityNotFoundException
    //   2649	2662	1180	android/content/ActivityNotFoundException
    //   2670	2689	1180	android/content/ActivityNotFoundException
    //   2700	2710	1180	android/content/ActivityNotFoundException
    //   2715	2721	1180	android/content/ActivityNotFoundException
    //   2721	2751	1180	android/content/ActivityNotFoundException
    //   2751	2786	1180	android/content/ActivityNotFoundException
    //   2791	2817	1180	android/content/ActivityNotFoundException
    //   2822	2855	1180	android/content/ActivityNotFoundException
    //   2855	2864	1180	android/content/ActivityNotFoundException
    //   2864	2930	1180	android/content/ActivityNotFoundException
    //   2932	2965	1180	android/content/ActivityNotFoundException
    //   2965	2984	1180	android/content/ActivityNotFoundException
    //   2987	3006	1180	android/content/ActivityNotFoundException
    //   3009	3019	1180	android/content/ActivityNotFoundException
    //   3022	3054	1180	android/content/ActivityNotFoundException
    //   3059	3069	1180	android/content/ActivityNotFoundException
    //   3072	3090	1180	android/content/ActivityNotFoundException
    //   3093	3118	1180	android/content/ActivityNotFoundException
    //   3121	3158	1180	android/content/ActivityNotFoundException
    //   3166	3186	1180	android/content/ActivityNotFoundException
    //   1272	1284	1492	java/lang/Exception
    //   1289	1373	1492	java/lang/Exception
    //   1383	1454	1492	java/lang/Exception
    //   1454	1489	1492	java/lang/Exception
    //   1649	1667	1759	java/io/UnsupportedEncodingException
    //   2297	2304	2307	java/lang/Exception
    //   2670	2689	3189	java/lang/Exception
    //   2715	2721	3284	java/lang/Exception
  }
  
  private boolean bw()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492C", "0X800492C", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.e("qqdataline", 2, "shareFromMigSdk|report send from sdk:0X800492C.");
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    Object localObject6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {}
    for (localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; localObject1 = null)
    {
      Object localObject7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
      String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
      String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
      String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
      int i2 = 0;
      try
      {
        i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
        l2 = 0L;
      }
      catch (Exception localException2)
      {
        try
        {
          l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
          localBundle = new Bundle();
          localBundle.putString("title", (String)localObject2);
          localBundle.putString("desc", (String)localObject4);
          localBundle.putString("image_url", str2);
          localBundle.putString("detail_url", str1);
          localBundle.putLong("req_share_id", l1);
          localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
          localBundle.putString("image_url_remote", (String)localObject6);
          localBundle.putString("app_name", (String)localObject1);
          localBundle.putString("open_id", str4);
          localBundle.putString("share_uin", str5);
          localBundle.putString("jfrom", str6);
          localBundle.putString("share_qq_ext_str", str7);
          localBundle.putInt("cflag", i1);
          localBundle.putInt("forward_type", 11);
          i2 = 1;
        }
        catch (Exception localException2)
        {
          try
          {
            long l2;
            do
            {
              for (;;)
              {
                Bundle localBundle;
                i1 = Integer.valueOf(str3).intValue();
                localBundle.putInt("req_type", i1);
                if (2 != i1) {
                  break label817;
                }
                localBundle.putString("audio_url", (String)localObject7);
                if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject4)))
                {
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break;
                  }
                  localBundle.putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131698137), new Object[] { localObject1 }));
                }
                com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
                localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
                localBundle.putBoolean("MigSdkShareNotDone", true);
                ((Intent)localObject1).putExtras(localBundle);
                ((Intent)localObject1).addFlags(268435456);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                return true;
                localException1 = localException1;
                i1 = i2;
                if (QLog.isColorLevel())
                {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|parse extflags exp: extflag=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"));
                  i1 = i2;
                }
              }
              localException2 = localException2;
              l1 = l2;
            } while (!QLog.isColorLevel());
            QLog.e("qqfav", 2, "gotoQfavShareMsg|parse appid exp: appid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
            l1 = l2;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            int i1;
            label817:
            label894:
            do
            {
              for (;;)
              {
                long l1;
                i1 = i2;
                if (QLog.isColorLevel())
                {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + str3);
                  i1 = i2;
                  continue;
                  localException2.putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131698138));
                  continue;
                  if (6 == i1)
                  {
                    localObject1 = "";
                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                      localObject1 = localObject2;
                    }
                    localObject2 = localObject1;
                    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                        break label894;
                      }
                    }
                    for (localObject2 = localObject4;; localObject2 = (String)localObject1 + "\n" + (String)localObject4)
                    {
                      localException2.putString("forward_text", (String)localObject2);
                      localException2.putBoolean("isFromShare", true);
                      localException2.putBoolean("key_sdk_share_pure_text", true);
                      break;
                    }
                  }
                  if (5 != i1) {
                    break;
                  }
                  localObject2 = null;
                  localObject1 = null;
                  localObject6 = new ArrayList();
                  Object localObject3;
                  if (!TextUtils.isEmpty(str2))
                  {
                    localObject7 = str2.split(";");
                    i1 = 0;
                    localObject4 = null;
                    for (;;)
                    {
                      localObject5 = localObject4;
                      localObject2 = localObject1;
                      if (i1 >= localObject7.length) {
                        break label1191;
                      }
                      localObject5 = "";
                      try
                      {
                        localObject2 = URLDecoder.decode(localObject7[i1], "UTF-8");
                        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                          if ((((String)localObject2).startsWith("/")) && (new File((String)localObject2).exists()))
                          {
                            ((ArrayList)localObject6).add(localObject2);
                            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                              break label1181;
                            }
                            i1 += 1;
                            localObject1 = localObject2;
                          }
                        }
                      }
                      catch (UnsupportedEncodingException localUnsupportedEncodingException)
                      {
                        for (;;)
                        {
                          localObject3 = localObject5;
                          if (QLog.isColorLevel())
                          {
                            QLog.e("qqfav", 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + localObject7[i1]);
                            localObject3 = localObject5;
                            continue;
                            if (localObject3.startsWith("http"))
                            {
                              ((ArrayList)localObject6).add(localObject3);
                              if (TextUtils.isEmpty((CharSequence)localObject4))
                              {
                                localObject4 = localObject3;
                                localObject3 = localObject1;
                                continue;
                                if (QLog.isColorLevel()) {
                                  QLog.e("qqfav", 2, "gotoQfavShareMsg|file path invalid. path=" + localObject3);
                                }
                              }
                            }
                            localObject3 = localObject1;
                          }
                        }
                      }
                    }
                  }
                  Object localObject5 = null;
                  localException2.putString("image_url", localObject3);
                  localException2.putString("image_url_remote", (String)localObject5);
                  localException2.putString("title", null);
                  localException2.putString("desc", null);
                  if (1 == ((ArrayList)localObject6).size())
                  {
                    localObject1 = localObject3;
                    if (TextUtils.isEmpty(localObject3))
                    {
                      localObject1 = localObject3;
                      if (!TextUtils.isEmpty((CharSequence)localObject5))
                      {
                        localException2.putString("image_url", (String)localObject5);
                        localObject1 = localObject5;
                      }
                    }
                    if (FileManagerUtil.a((String)localObject1) == 0)
                    {
                      localException2.putInt("req_type", 5);
                    }
                    else
                    {
                      localException2.putString("forward_text", HardCodeUtil.a(2131705923) + FileManagerUtil.a((String)localObject1) + HardCodeUtil.a(2131705924) + FileUtil.a(FileUtil.a((String)localObject1)) + "。");
                      localException2.putBoolean("qdshare_file", true);
                      localException2.putBoolean("isFromShare", true);
                      localException2.putBoolean("key_sdk_share_pure_text", true);
                      localException2.putInt("req_type", 6);
                    }
                  }
                  else if (FileManagerUtil.a(localObject3) == 0)
                  {
                    localException2.putString("title", ((ArrayList)localObject6).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131694587));
                    localException2.putString("qqfav_extra_multi_pic_path_list", str2);
                    localException2.putBoolean("qqfav_extra_multi_pic", true);
                    localException2.putInt("req_type", 1);
                  }
                  else
                  {
                    localObject1 = ((ArrayList)localObject6).iterator();
                    for (l1 = 0L; ((Iterator)localObject1).hasNext(); l1 = FileUtil.a((String)((Iterator)localObject1).next()) + l1) {}
                    localException2.putString("forward_text", HardCodeUtil.a(2131705930) + FileManagerUtil.a(localObject3) + HardCodeUtil.a(2131705918) + ((ArrayList)localObject6).size() + HardCodeUtil.a(2131705931) + FileUtil.a(l1));
                    localException2.putString("qqfav_extra_multi_pic_path_list", str2);
                    localException2.putBoolean("qdshare_file", true);
                    localException2.putBoolean("isFromShare", true);
                    localException2.putBoolean("key_sdk_share_pure_text", true);
                    localException2.putInt("req_type", 6);
                  }
                }
              }
            } while (1 == i1);
            label1181:
            label1191:
            return false;
          }
        }
      }
    }
  }
  
  private boolean bx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, " source:" + this.jdField_a_of_type_JavaLangString + "  serverName:" + this.jdField_b_of_type_JavaLangString + "  hostName:" + this.jdField_c_of_type_JavaLangString);
    }
    Object localObject1;
    if (this.jdField_c_of_type_JavaLangString.equals("index"))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
      ((Intent)localObject1).putExtra("goto_type", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              if (!this.jdField_c_of_type_JavaLangString.equals("detail")) {
                break;
              }
            } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
            localObject1 = Common.g() + File.separator + "qapp_center_detail.htm";
            if (new File((String)localObject1).exists()) {}
            for (localObject1 = "file:///" + (String)localObject1;; localObject1 = Common.m() + File.separator + "qapp_center_detail.htm")
            {
              localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
              localObject3 = new Bundle();
              localObject4 = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("param");
              ((Bundle)localObject3).putString("APP_URL", (String)localObject1);
              ((Bundle)localObject3).putString("APP_PARAMS", "&" + (String)localObject4);
              ((Bundle)localObject3).putInt("goto_type", 2);
              ((Intent)localObject2).putExtras((Bundle)localObject3);
              ((Intent)localObject2).putExtra("adapter_action", "action_app_detail");
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
              return true;
            }
            if (!this.jdField_c_of_type_JavaLangString.equals("webview")) {
              break;
            }
          } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("APP_URL", Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("url"));
          ((Bundle)localObject2).putInt("goto_type", 3);
          ((Intent)localObject1).putExtras((Bundle)localObject2);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          return true;
        } while ((!this.jdField_c_of_type_JavaLangString.equals("local")) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
        localObject2 = Uri.parse(this.jdField_a_of_type_JavaLangString);
        localObject1 = ((Uri)localObject2).getQueryParameter("title");
        localObject3 = Common.a(((Uri)localObject2).getQueryParameter("url"));
      } while (localObject3.length <= 1);
      localObject2 = localObject3[0];
    } while ((!((String)localObject2).startsWith("file://")) || ((!((String)localObject2).contains(Common.g())) && (!((String)localObject2).contains("android_asset/Page/system/"))));
    Object localObject3 = localObject3[1];
    Object localObject4 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("APP_URL", (String)localObject2);
    Object localObject2 = new ArrayList();
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
    return true;
  }
  
  private boolean by()
  {
    QQProxyForQlink.a(this.jdField_a_of_type_AndroidContentContext, 9, null);
    return true;
  }
  
  private boolean bz()
  {
    return true;
  }
  
  private String c()
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.MODEL;
    String str3 = QQDeviceInfo.getIMEI("0db4c4");
    String str4 = QQDeviceInfo.getIMSI("0db4c4");
    Object localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay();
    int i1 = ((Display)localObject).getHeight();
    int i2 = ((Display)localObject).getWidth();
    localObject = i2 + "*" + i1;
    i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid();
    return str1 + "|" + str2 + "|" + str3 + "|" + (String)localObject + "|" + str4 + "|" + i1 + "|";
  }
  
  public static String c(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(Base64Util.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
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
  
  public static boolean c(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    paramQQAppInterface = (String)paramHashMap.get("uin");
    String str1 = (String)paramHashMap.get("usertype");
    String str2 = (String)paramHashMap.get("unionid");
    paramHashMap = (String)paramHashMap.get("fromId");
    if ((TextUtils.isEmpty(str1)) || ((TextUtils.isEmpty(paramQQAppInterface)) && (TextUtils.isEmpty(str2))) || (TextUtils.isEmpty(paramHashMap))) {
      return false;
    }
    try
    {
      if (!TextUtils.isEmpty(str2)) {
        StoryApi.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), str2);
      } else {
        StoryApi.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), Long.valueOf(paramQQAppInterface).longValue());
      }
    }
    catch (Exception paramQQAppInterface)
    {
      return false;
    }
    return true;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str5 = (String)paramHashMap.get("videoOwnerUin");
    String str6 = (String)paramHashMap.get("unionid");
    String str4 = (String)paramHashMap.get("fromId");
    String str2 = (String)paramHashMap.get("videoId");
    String str1 = (String)paramHashMap.get("type");
    str1 = (String)paramHashMap.get("videoList");
    int i1 = b(paramHashMap);
    str1 = (String)paramHashMap.get("feedid");
    int i3 = b(paramHashMap, "ptype", 0);
    int i2;
    if ("0".equals(paramHashMap.get("identify")))
    {
      i2 = 0;
      if (str2 != null) {
        break label799;
      }
      str2 = (String)paramHashMap.get("videoid");
    }
    label799:
    for (;;)
    {
      String str3 = str4;
      if (str4 == null) {
        str3 = (String)paramHashMap.get("fromid");
      }
      if ((!TextUtils.isEmpty(paramString)) && (i3 == 0)) {
        i3 = 7;
      }
      for (;;)
      {
        switch (i3)
        {
        default: 
          paramQQAppInterface = str1;
          if (str1 == null) {
            paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
          }
          i2 = i1;
          if (i1 == 0) {
            i2 = 7;
          }
          StoryPlayerLauncher.b(paramActivity, str2, paramQQAppInterface, i2);
          return true;
          i2 = 1;
          break;
        case 1: 
          if ("17".equals(str3)) {
            StoryReportor.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = str1;
          if (str1 == null) {
            paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
          }
          i2 = i1;
          if (i1 == 0) {
            i2 = 7;
          }
          StoryPlayerLauncher.b(paramActivity, str2, paramQQAppInterface, i2);
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
          if (!TextUtils.isEmpty(str6)) {
            StoryPlayerLauncher.a(paramActivity, str6, str1, 1, 109, 1, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            StoryPlayerLauncher.a(paramActivity, str5, str1, 1, 109, 1, null);
          }
          return false;
        case 3: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 30;
          }
          StoryPlayerLauncher.a(paramActivity, str2, str1, i2);
          return true;
        case 4: 
          paramQQAppInterface = (String)paramHashMap.get("collection_id");
          paramHashMap = (String)paramHashMap.get("time_zone");
          i3 = -1;
          if (!TextUtils.isEmpty(paramHashMap)) {
            i3 = Integer.valueOf(paramHashMap).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            StoryPlayerLauncher.a(paramActivity, str6, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str6), i3, i1, str1, i2, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            StoryPlayerLauncher.a(paramActivity, str5, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str5), i3, i1, str1, i2, null);
          }
          return false;
        case 7: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 19;
          }
          StoryPlayerLauncher.b(paramActivity, str2, str1, i2);
          return true;
        case 6: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 57;
          }
          StoryPlayerLauncher.b(paramActivity, str2, str1, i2);
          return true;
        case 5: 
          StoryPlayerLauncher.a(paramActivity, str6, str1, i2, i1, 0, null);
          return true;
        case 8: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 90;
          }
          StoryPlayerLauncher.b(paramActivity, str2, str1, i2);
          return true;
        case 9: 
          b(paramHashMap, "time_zone", -1);
          i2 = i1;
          if (i1 == 0) {
            i2 = 96;
          }
          StoryPlayerLauncher.a(paramActivity, str1, i2);
          return true;
        case 10: 
          paramQQAppInterface = (String)paramHashMap.get("bannerID");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            StoryPlayerLauncher.a(paramActivity, new OpenPlayerBuilder(new DiscoverBannerPlayInfo(paramQQAppInterface), 102).a());
          }
          return true;
        case 0: 
          return d(paramQQAppInterface, paramActivity, paramHashMap, paramString);
        }
      }
    }
  }
  
  private boolean c(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString))) {
      return false;
    }
    if (paramString.length() < 5) {
      return false;
    }
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("visitid");
    if (TextUtils.isEmpty(str4)) {
      return false;
    }
    Object localObject;
    String str1;
    label119:
    String str2;
    label159:
    String str3;
    if (this.jdField_a_of_type_JavaUtilHashMap.get("kfuin") != null)
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("kfuin");
      if (this.jdField_a_of_type_JavaUtilHashMap.get("extuin") == null) {
        break label344;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extuin");
      if (this.jdField_a_of_type_JavaUtilHashMap.get("name") == null) {
        break label351;
      }
      str2 = c(((String)this.jdField_a_of_type_JavaUtilHashMap.get("name")).replace(" ", "+"));
      QidianHandler localQidianHandler = (QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
      boolean bool = false;
      if (this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag") == null) {
        break label358;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag");
      label204:
      if (!TextUtils.isEmpty(str3)) {
        bool = QidianManager.b(Integer.valueOf(str3).intValue());
      }
      localQidianHandler.a(str4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, str1, paramString, bool);
      localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject == null) || (!((FriendsManager)localObject).b(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label365;
      }
      localObject = new ProfileCardInfo();
      ((ProfileCardInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramString, 1);
      ((ProfileCardInfo)localObject).jdField_a_of_type_ArrayOfJavaLangString = new String[8];
      ((ProfileCardInfo)localObject).jdField_a_of_type_ArrayOfJavaLangString[4] = str2;
      FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileCardInfo)localObject);
    }
    for (;;)
    {
      return true;
      localObject = "";
      break;
      label344:
      str1 = "";
      break label119;
      label351:
      str2 = "";
      break label159;
      label358:
      str3 = "";
      break label204;
      label365:
      paramString = AddFriendLogicActivity.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, paramString, null, 3999, 0, str2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131690778), null);
      paramString.putExtra("webImVisitId", str4);
      paramString.putExtra("webim_qd_ext", true);
      if (BaseActivity.sTopActivity == null) {
        paramString.putExtra("need_jumpto_splash", true);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
    }
  }
  
  public static String d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      int i1 = Integer.valueOf(paramString).intValue();
      switch (i1)
      {
      default: 
        return paramString;
      case 21: 
        return "2";
      case 20: 
        return "3";
      case 15: 
        return "4";
      case 3001: 
        return "5";
      case 22: 
        return "6";
      }
      return "7";
    }
    catch (NumberFormatException localNumberFormatException) {}
    return paramString;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    String str = (String)paramHashMap.get("unionid");
    paramQQAppInterface = (String)paramHashMap.get("fromuid");
    int i1 = -1;
    try
    {
      int i2 = Integer.valueOf((String)paramHashMap.get("fromId")).intValue();
      i1 = i2;
    }
    catch (NumberFormatException paramHashMap)
    {
      for (;;)
      {
        QLog.e("JumpAction", 2, "gotoStoryShareGroupCard from id is error:" + paramHashMap);
      }
    }
    paramHashMap = QQStoryShareGroupProfileActivity.a(paramActivity, 2, str, null, i1, 0);
    paramHashMap.putExtra("extra_share_from_user_uid", paramQQAppInterface);
    paramActivity.startActivity(paramHashMap);
    return true;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str3 = (String)paramHashMap.get("videoOwnerUin");
    String str4 = (String)paramHashMap.get("unionid");
    String str1 = (String)paramHashMap.get("fromId");
    paramQQAppInterface = (String)paramHashMap.get("videoId");
    String str5 = (String)paramHashMap.get("type");
    String str2 = (String)paramHashMap.get("videoList");
    int i1 = b(paramHashMap);
    str2 = (String)paramHashMap.get("feedid");
    b(paramHashMap, "ptype", 0);
    label130:
    int i2;
    label149:
    int i4;
    label168:
    int i3;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = (String)paramHashMap.get("videoid");
      if (str1 == null)
      {
        str1 = (String)paramHashMap.get("fromid");
        if ((str5 == null) || (!str5.equals("mylist"))) {
          break label706;
        }
        i2 = 1;
        if ((str5 == null) || (!str5.equals("myonedaylist"))) {
          break label712;
        }
        i4 = 1;
        if (!"0".equals(paramHashMap.get("identify"))) {
          break label718;
        }
        i3 = 0;
        try
        {
          label187:
          if ("17".equals(str1))
          {
            if (i2 == 0) {
              break label285;
            }
            StoryReportor.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
          for (;;)
          {
            if (i4 == 0) {
              break label467;
            }
            paramString = (String)paramHashMap.get("collection_id");
            if (!TextUtils.isEmpty(paramString)) {
              break;
            }
            i2 = i1;
            if (i1 == 0) {
              i2 = 30;
            }
            StoryPlayerLauncher.a(paramActivity, paramQQAppInterface, str2, i2);
            break label704;
            label285:
            StoryReportor.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
          paramQQAppInterface = (String)paramHashMap.get("time_zone");
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, videoOwnerUin:" + str3 + ",e:" + QLog.getStackTraceString(paramQQAppInterface));
          }
          return false;
        }
        i2 = -1;
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          i2 = Integer.valueOf(paramQQAppInterface).intValue();
        }
        if (!TextUtils.isEmpty(str4))
        {
          StoryPlayerLauncher.a(paramActivity, str4, VideoCollectionEntry.getCollectionKey(1, paramString, str4), i2, i1, str2, i3, null);
          break label704;
        }
        if (TextUtils.isEmpty(str3)) {
          break label724;
        }
        StoryPlayerLauncher.a(paramActivity, str3, VideoCollectionEntry.getCollectionKey(1, paramString, str3), i2, i1, str2, i3, null);
        break label704;
        label467:
        if ("17".equals(str1))
        {
          if (i2 != 0)
          {
            paramQQAppInterface = (String)paramHashMap.get("et");
            paramQQAppInterface = (String)paramHashMap.get("time_zone");
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              Integer.valueOf(paramQQAppInterface).intValue();
            }
            if (!TextUtils.isEmpty(str4))
            {
              StoryPlayerLauncher.a(paramActivity, str4, str2, i3, i1, 0, null);
              break label726;
            }
            if (TextUtils.isEmpty(str3)) {
              break label728;
            }
            StoryPlayerLauncher.a(paramActivity, str3, str2, i3, i1, 0, null);
            break label726;
          }
          if ((!TextUtils.isEmpty(str5)) && (str5.equals(String.valueOf(1))))
          {
            i2 = i1;
            if (i1 == 0) {
              i2 = 57;
            }
            StoryPlayerLauncher.b(paramActivity, paramQQAppInterface, str2, i2);
            break label726;
          }
          if (!"onedaylist".equals(str5)) {
            break label730;
          }
          StoryPlayerLauncher.a(paramActivity, str4, str2, i3, i1, 0, null);
          break label726;
          StoryPlayerLauncher.b(paramActivity, paramQQAppInterface, str2, i2);
          break label726;
        }
        label643:
        if (TextUtils.isEmpty(paramString)) {
          break label746;
        }
        i2 = i1;
        if (i1 == 0) {
          i2 = 19;
        }
        StoryPlayerLauncher.b(paramActivity, paramQQAppInterface, str2, i2);
        break label726;
      }
    }
    for (;;)
    {
      StoryPlayerLauncher.b(paramActivity, paramQQAppInterface, paramHashMap, i2);
      break label726;
      break label130;
      break;
      label704:
      return true;
      label706:
      i2 = 0;
      break label149;
      label712:
      i4 = 0;
      break label168;
      label718:
      i3 = 1;
      break label187;
      label724:
      return false;
      label726:
      return true;
      label728:
      return false;
      label730:
      i2 = i1;
      if (i1 != 0) {
        break label643;
      }
      i2 = 17;
      break label643;
      label746:
      paramHashMap = str2;
      if (str2 == null) {
        paramHashMap = "JUMP_ACTION_EMPTY_FEED_ID";
      }
      i2 = i1;
      if (i1 == 0) {
        i2 = 7;
      }
    }
  }
  
  private boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("mqzone://arouse/normalvideolayer")) && (TextUtils.equals(a(paramString), "6"));
  }
  
  private Intent e(Intent paramIntent)
  {
    if (!TextUtils.isEmpty((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"))) {}
    for (boolean bool = true;; bool = false)
    {
      SLog.a("JumpAction", "makeStoryJumpActivity() action=%s isFromApi=%s", this.jdField_c_of_type_JavaLangString, Boolean.valueOf(bool));
      SLog.a("JumpAction", "makeStoryJumpActivity() attr=%s", String.valueOf(this.jdField_a_of_type_JavaUtilHashMap));
      if (!"open".equals(this.jdField_c_of_type_JavaLangString)) {
        break;
      }
      paramIntent.putExtra("redid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("redid"));
      paramIntent.putExtra("lebaVersion", (String)this.jdField_a_of_type_JavaUtilHashMap.get("lebaVersion"));
      if (bool) {
        StoryReportor.a("basic", "use_api", 0, 0, new String[] { "1", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
      }
      return paramIntent;
    }
    String str1;
    if (("openVideo".equals(this.jdField_c_of_type_JavaLangString)) || ("openvideo".equals(this.jdField_c_of_type_JavaLangString)))
    {
      if (bool)
      {
        str1 = "userId=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoOwnerUin") + "&vid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoId");
        StoryReportor.a("basic", "use_api", 0, 0, new String[] { "6", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
      }
      return a(paramIntent);
    }
    String str2;
    String str4;
    String str5;
    if ("opencontent".equals(this.jdField_c_of_type_JavaLangString))
    {
      if (bool)
      {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
        str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
        if (!TextUtils.isEmpty(str4)) {
          break label471;
        }
      }
      label471:
      for (str1 = "unionId=" + str5 + "&userId=" + str1 + "&userType=" + str2;; str1 = "storyId=" + str4)
      {
        StoryReportor.a("basic", "use_api", 0, 0, new String[] { "4", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
        return d(paramIntent);
      }
    }
    if ("opentopic".equals(this.jdField_c_of_type_JavaLangString))
    {
      if (bool)
      {
        str1 = "topicId=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
        StoryReportor.a("basic", "use_api", 0, 0, new String[] { "5", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
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
      paramIntent.putExtra("story_default_label", (String)this.jdField_a_of_type_JavaUtilHashMap.get("default_label"));
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("capture_mode");
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tab_id");
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("category_id");
      String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("item_id");
      String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("album_id");
      String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page");
      String str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("dispatch_event");
      paramIntent.putExtra("cameraDirection", 2);
      paramIntent.putExtra("story_game_id", str4);
      paramIntent.putExtra("story_capture_album_id", str7);
      if (!TextUtils.isEmpty(str9)) {
        paramIntent.putExtra("web_dispatch_event", str9);
      }
      try
      {
        if (!TextUtils.isEmpty(str8)) {
          paramIntent.putExtra("key_finish_jump_to_page", Integer.valueOf(str8));
        }
        if (!TextUtils.isEmpty(str2)) {
          paramIntent.putExtra("capture_intent_mode", Integer.valueOf(str2));
        }
        if (!TextUtils.isEmpty(str4)) {
          paramIntent.putExtra("firsttab", Integer.valueOf(str4));
        }
        if (!TextUtils.isEmpty(str5)) {
          paramIntent.putExtra("secondtab", Integer.valueOf(str5));
        }
        paramIntent.putExtra("itemid", str6);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("Q.qqstory.publish.JumpAction", 2, "start story publish, NumberFormatException, attrs=" + this.jdField_a_of_type_JavaUtilHashMap.toString() + "\n" + localNumberFormatException);
        }
      }
      paramIntent.putExtra("from_type", str1);
      paramIntent.putExtra("action", 1);
      return paramIntent;
    }
    String str3;
    if ("infoCard".equals(this.jdField_c_of_type_JavaLangString))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromId");
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
      if ((TextUtils.isEmpty(str3)) || ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str5))) || (TextUtils.isEmpty(str4))) {
        return null;
      }
      try
      {
        paramIntent.putExtra("union_id", str5);
        paramIntent.putExtra("qq_number", Long.valueOf(str1));
        paramIntent.putExtra("source", Integer.valueOf(str4));
        paramIntent.putExtra("action", 11);
        return paramIntent;
      }
      catch (NumberFormatException paramIntent)
      {
        return null;
      }
    }
    if ("sharegroupcard".equals(this.jdField_c_of_type_JavaLangString))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromId");
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromuid");
      try
      {
        paramIntent.putExtra("union_id", str1);
        paramIntent.putExtra("extra_share_from_uid", str4);
        paramIntent.putExtra("source", Integer.valueOf(str3));
        paramIntent.putExtra("action", 13);
        return paramIntent;
      }
      catch (NumberFormatException paramIntent)
      {
        return null;
      }
    }
    if ("openTag".equals(this.jdField_c_of_type_JavaLangString))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag_id");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag_type");
      paramIntent.putExtra("action", 14);
      paramIntent.putExtra("tag_id", str1);
      paramIntent.putExtra("tag_type", str3);
      return paramIntent;
    }
    if ("openSquare".equals(this.jdField_c_of_type_JavaLangString))
    {
      paramIntent.putExtra("action", 15);
      return paramIntent;
    }
    return null;
  }
  
  private String e(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("i="))) {
      return null;
    }
    int i3 = paramString.indexOf("i=");
    int i2 = paramString.substring(i3).indexOf('&');
    int i1 = i2;
    if (i2 <= 0) {
      i1 = paramString.length() - i3;
    }
    return paramString.substring("i=".length() + i3, i1 + i3);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("params")) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("params")));
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "urlParamObj: " + localJSONObject);
      }
      if (localJSONObject.optInt("view_type", 0) == 0)
      {
        localJSONObject = localJSONObject.optJSONObject("params");
        if (localJSONObject != null) {
          ReminderListFragment.a(this.jdField_a_of_type_AndroidContentContext, localJSONObject.optString("notice_time"));
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("JumpAction", 2, "JumpAction parse url throw an exception: " + localException);
    }
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
      this.jdField_f_of_type_Boolean = false;
      ThreadManagerV2.executeOnSubThread(new JumpAction.23(this, str1, paramString));
      return false;
    }
    return a(paramString, true);
  }
  
  private String f(String paramString)
  {
    QLog.d("JumpAction", 1, "urlDecode imageUri=" + paramString);
    try
    {
      String str = URLDecoder.decode(paramString, "UTF-8");
      return str;
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
      String str1 = "";
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("domain")) {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("domain");
      }
      QQNotifySettingFragment.a(this.jdField_a_of_type_AndroidContentContext, str2, str3, str4, str1);
    }
  }
  
  private boolean f(String paramString)
  {
    int i3 = 0;
    int i2 = 0;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return true;
      paramString = paramString.split("\\?");
    } while ((paramString == null) || (paramString.length < 2));
    long l1 = 0L;
    paramString = paramString[1];
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(URLDecoder.decode(paramString.substring(paramString.indexOf('=') + 1), "UTF-8"));
        int i1 = ((JSONObject)localObject).optInt("gameId");
        i2 = i3;
        long l2;
        paramString.printStackTrace();
      }
      catch (Exception paramString)
      {
        try
        {
          l2 = ((JSONObject)localObject).optLong("roomId");
          l1 = l2;
          i2 = i3;
          paramString = ((JSONObject)localObject).optString("gameName");
          l1 = l2;
          i2 = i3;
          i3 = ((JSONObject)localObject).optInt("gameMode");
          l1 = l2;
          i2 = i3;
          localObject = ((JSONObject)localObject).optString("extendInfo");
          l1 = l2;
          i2 = i3;
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l2, i3, (String)localObject, 204, paramString);
          i2 = i3;
          l1 = l2;
          QLog.i("JumpAction", 1, "[gotoCmShowGame], gameId:" + i1 + ",roomId:" + l1 + ",gameMode:" + i2);
          return true;
        }
        catch (Exception paramString)
        {
          break label222;
        }
        paramString = paramString;
        i1 = 0;
      }
      label222:
      QLog.w("JumpAction", 1, "[gotoCmShowGame], errInfo->" + paramString.getMessage());
    }
  }
  
  private String g(String paramString)
  {
    QLog.d("JumpAction", 1, "urlEncode filePath=" + paramString);
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      QLog.e("JumpAction", 1, "UnsupportedEncodingException", localUnsupportedEncodingException);
    }
    return URLEncoder.encode(paramString);
  }
  
  private void g()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), 111);
    if ("1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("source"))) {
      localAllInOne.jdField_h_of_type_Int = 118;
    }
    for (;;)
    {
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, localAllInOne);
      return;
      if ("2".equals(this.jdField_a_of_type_JavaUtilHashMap.get("source"))) {
        localAllInOne.jdField_h_of_type_Int = 121;
      }
    }
  }
  
  private void g(String paramString)
  {
    if ((paramString.equals(GameCenterActivity.class.getName())) || (paramString.equals(((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountBrowser.class))) || (paramString.equals(CouponActivity.class.getName()))) {
      QWalletHelperImpl.preloadQWallet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void h()
  {
    String str = b("buddyuin");
    if (!str.isEmpty())
    {
      long l1 = Long.parseLong(str);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "grayTip,openTroopWithCommonFriendsFragment:" + l1);
      }
      TroopWithCommonFriendsFragment.a(str);
      TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_AndroidContentContext, 1);
      ReportController.b(null, "dc00898", "", "", "0X800AD20", "0X800AD20", 0, 0, "0", "0", "", "");
    }
  }
  
  private void i()
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("fromTranslucent", 1);
    try
    {
      long l1 = Long.parseLong(b("uin"));
      int i1 = Integer.parseInt(b("appid"));
      Object localObject2 = b("cellid");
      Object localObject3 = b("subid");
      long l2 = Long.parseLong(b("time"));
      ((Bundle)localObject1).putLong("targetuin", Long.valueOf(l1).longValue());
      ((Bundle)localObject1).putInt("appid", i1);
      ((Bundle)localObject1).putString("cellid", (String)localObject2);
      ((Bundle)localObject1).putString("subid", (String)localObject3);
      ((Bundle)localObject1).putLong("feedtime", l2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject2, "com.qzone.detail.ui.activity.StickyNoteDetailActivity");
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
      {
        localObject3 = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
        localObject1 = null;
        if (((BaseActivity)localObject3).app != null) {
          localObject1 = ((BaseActivity)localObject3).app.getCurrentUin();
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QLog.e("JumpAction", 1, "action_open_sticky_note_feed_detail  error! get currentUin failed! " + ((BaseActivity)localObject3).app);
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
  
  private void j()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_weishi_feeds_plugin.apk");
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  private void k()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ReadInJoyDeliverUGCActivity.class);
    localObject2 = "";
    Object localObject4 = "";
    str = "";
    localObject1 = localObject2;
    localObject3 = localObject2;
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("topicid"))
      {
        localObject1 = localObject2;
        localObject3 = localObject2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get("topicid") != null)
        {
          localObject3 = localObject2;
          localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
        }
      }
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("topicname"))
      {
        localObject2 = localObject4;
        localObject3 = localObject1;
        if (this.jdField_a_of_type_JavaUtilHashMap.get("topicname") != null)
        {
          localObject3 = localObject1;
          localObject2 = new String(Base64Util.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname"), 0));
        }
      }
      localObject3 = str;
      localObject4 = str;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label265:
        str = "";
        localObject2 = "";
        localObject1 = localObject3;
        localObject3 = str;
        localException1.printStackTrace();
        i1 = 0;
      }
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("cookie"))
      {
        localObject3 = str;
        localObject4 = str;
        if (this.jdField_a_of_type_JavaUtilHashMap.get("cookie") != null)
        {
          localObject4 = str;
          localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cookie");
        }
      }
      localObject4 = localObject3;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("adtag")) {
        break label375;
      }
      localObject4 = localObject3;
      if (this.jdField_a_of_type_JavaUtilHashMap.get("adtag") == null) {
        break label375;
      }
      localObject4 = localObject3;
      i1 = Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("adtag")).intValue();
    }
    catch (Exception localException2)
    {
      localObject3 = localException1;
      Object localObject5 = localException2;
      break label352;
      i1 = 0;
      break label265;
    }
    localIntent.putExtra("arg_topic_id", (String)localObject1);
    localIntent.putExtra("support_topic", true);
    localIntent.putExtra("support_linkify", true);
    localIntent.putExtra("arg_topic_name", (String)localObject2);
    localIntent.putExtra("arg_ad_tag", i1);
    localIntent.putExtra("arg_ugc_edit_cookie", (String)localObject3);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private void l()
  {
    if ((this.jdField_c_of_type_JavaLangString == null) || ((!this.jdField_c_of_type_JavaLangString.equals("forward_msg_list")) && (!this.jdField_c_of_type_JavaLangString.equals("open_conversation"))))
    {
      QLog.e("JumpAction", 1, "action_name doesnt match: " + this.jdField_c_of_type_JavaLangString);
      return;
    }
    int i1 = FrameControllerUtil.jdField_a_of_type_Int;
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("third_open_conversation_sceneid");
    try
    {
      long l1 = Long.parseLong((String)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5AF", "0X800A5AF", 0, 0, l1 + "", "", "", "");
      localObject = new Intent();
      ((Intent)localObject).setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      ((Intent)localObject).setFlags(335544320);
      ((Intent)localObject).putExtra("tab_index", i1);
      ((Intent)localObject).putExtra("fragment_id", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("JumpAction", 1, "sceneid must be a numeric string, errorMsg: " + localException.toString());
      }
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131692847, this.jdField_a_of_type_AndroidContentContext.getString(2131692829), 2131692831, 2131692830, new JumpAction.11(this), new JumpAction.12(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void n()
  {
    Object localObject;
    String str1;
    label54:
    String str2;
    label79:
    String str3;
    label107:
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("packageName"))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("packageName");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("signareMode")) {
        break label328;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("signareMode");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
        break label334;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("timeStamp")) {
        break label340;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("timeStamp");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("resetWordMode")) {
        break label347;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("resetWordMode");
      label135:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("offerid")) {
        break label354;
      }
    }
    label328:
    label334:
    label340:
    label347:
    label354:
    for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("offerid");; str5 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "packageName : " + (String)localObject + " signatureMode :" + str1 + " appid : " + str2 + " timestamp : " + str3 + " resetWordMode : " + str4 + " offerId : " + str5);
      }
      localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
      ((QWalletAuthHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).a((ReqCheckChangePwdAuth)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction$QWalletAuthMsgHandler = new JumpAction.QWalletAuthMsgHandler(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = new QWalletAuthObserver(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction$QWalletAuthMsgHandler);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
      return;
      localObject = "";
      break;
      str1 = "";
      break label54;
      str2 = "";
      break label79;
      str3 = "";
      break label107;
      str4 = "";
      break label135;
    }
  }
  
  private void o()
  {
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localJSONObject.put("viewTag", "pswManage");
      if (!PayBridgeActivity.tenpay((Activity)this.jdField_a_of_type_AndroidContentContext, localJSONObject.toString(), 5, "")) {}
      for (int i1 = 1;; i1 = 0)
      {
        a(i1);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(1);
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
      if ("head".equals(this.jdField_c_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction$CustomHeadObserver == null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction$CustomHeadObserver = new JumpAction.CustomHeadObserver(this, this);
        }
        if (this.jdField_a_of_type_JavaUtilHashtable == null) {
          this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction$CustomHeadObserver);
        long l1 = System.currentTimeMillis();
        String[] arrayOfString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).split(",");
        IQQAvatarHandlerService localIQQAvatarHandlerService = (IQQAvatarHandlerService)a().getRuntimeService(IQQAvatarHandlerService.class, "");
        int i1 = 0;
        while (i1 < arrayOfString.length)
        {
          String str = arrayOfString[i1];
          localIQQAvatarHandlerService.getCustomHead(str);
          this.jdField_a_of_type_JavaUtilHashtable.put(str, Long.valueOf(l1));
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("JumpAction", 2, "handleMQQService error " + localException.toString());
      }
    }
  }
  
  private void r()
  {
    if ((!this.jdField_f_of_type_Boolean) && (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isSharingMiniProgram(this.jdField_a_of_type_JavaUtilHashMap)) && ((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
      ((JumpActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
    if (((this.jdField_a_of_type_AndroidContentContext instanceof GesturePWDUnlockActivity)) && (this.jdField_g_of_type_Boolean)) {
      ((GesturePWDUnlockActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
  
  public boolean A()
  {
    Object localObject;
    String str2;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if (localObject != null)
      {
        str2 = ((Intent)localObject).getStringExtra("big_brother_source_key");
        localObject = ((Intent)localObject).getDataString();
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = this.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        String str3 = "";
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("sourcee", str2);
        localBundle.putString("schemeUrl", (String)localObject);
        localBundle.putString("appid", str3);
        try
        {
          ((DynamicNowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).b(localBundle);
          QLog.i("JumpAction", 1, "preloginLiteSDK-----");
          return true;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("JumpAction", 2, localException.toString());
          }
          return false;
        }
      }
      String str1 = "";
      str2 = null;
    }
  }
  
  protected boolean B()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(str1);
    if (localObject != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((((TroopInfo)localObject).isTroopOwner(str2)) || (((TroopInfo)localObject).isTroopAdmin(str2))) {}
      for (boolean bool = true; (!((TroopInfo)localObject).mMemberInvitingFlag) && (!bool); bool = false)
      {
        QLog.e("JumpAction", 1, "cannot invite join group");
        return true;
      }
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SelectMemberActivity.class);
      ((Intent)localObject).putExtra("param_groupcode", str1);
      ((Intent)localObject).putExtra("param_type", 1);
      ((Intent)localObject).putExtra("param_subtype", 1);
      ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131697287));
      ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131696046));
      ((Intent)localObject).putExtra("param_is_troop_admin", bool);
      ((Intent)localObject).putExtra("param_donot_need_contacts", true);
      ((Intent)localObject).putExtra("param_max", 100);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
    }
    QLog.e("JumpAction", 1, "troopInfo not found");
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
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_b_of_type_JavaLangString.equals("card")) && (this.jdField_c_of_type_JavaLangString.equals("show_pslcard")) && (QSecFramework.a().a(1003).booleanValue())) {
      SecShareInfoUtil.a().a(paramActivity, null);
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.putAll(paramHashMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, "setNewFlag.newflag=" + this.jdField_c_of_type_Boolean);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    label664:
    Object localObject1;
    Object localObject2;
    try
    {
      if ("com.qqfav".equals(this.jdField_b_of_type_JavaLangString)) {
        return C();
      }
      if (("urlopen".equals(this.jdField_b_of_type_JavaLangString)) && ("pay".equals(this.jdField_c_of_type_JavaLangString))) {
        a();
      }
      if (("qqidentifier".equals(this.jdField_b_of_type_JavaLangString)) && ("web".equals(this.jdField_c_of_type_JavaLangString))) {
        return D();
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
        return N();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("manage_troop")) && (this.jdField_c_of_type_JavaLangString.equals("main_page"))) {
        return bV();
      }
      if (("microapp".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString))) {
        return E();
      }
      if (("miniapp".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString))) {
        return ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 2016, null);
      }
      if (("miniapp".equals(this.jdField_b_of_type_JavaLangString)) && ("notifyclose".equals(this.jdField_c_of_type_JavaLangString))) {
        return F();
      }
      if (("wallet".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString)) && ("0".equals(this.jdField_a_of_type_JavaUtilHashMap.get("viewtype"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"))) && ((this.jdField_a_of_type_JavaUtilHashMap.get("view") == null) || ("0".equals(this.jdField_a_of_type_JavaUtilHashMap.get("view"))))) {
        return as();
      }
      if (("wallet".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString)) && ("0".equals(this.jdField_a_of_type_JavaUtilHashMap.get("viewtype"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("src_type")))) {
        return G();
      }
      if (("wxminiapp".equals(this.jdField_b_of_type_JavaLangString)) && ("launch".equals(this.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("user_name")) && (!StringUtil.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("user_name")))) {
        return O();
      }
      if ("qqnotify".equals(this.jdField_b_of_type_JavaLangString))
      {
        if (!"open".equals(this.jdField_c_of_type_JavaLangString)) {
          break label664;
        }
        e();
      }
      for (;;)
      {
        if (("qqnotify".equals(this.jdField_b_of_type_JavaLangString)) && ("birth".equals(this.jdField_c_of_type_JavaLangString)))
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ActivateFriendActivity.class);
          localIntent.putExtra("af_key_from", 2);
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        }
        if (!this.jdField_b_of_type_JavaLangString.equals("ftssearch")) {
          break label872;
        }
        if (!this.jdField_c_of_type_JavaLangString.equals("tab")) {
          break;
        }
        return P();
        if ("subscribe".equals(this.jdField_c_of_type_JavaLangString)) {
          f();
        }
      }
      if (!this.jdField_c_of_type_JavaLangString.equals("openmixweb")) {
        break label872;
      }
    }
    catch (Exception localException)
    {
      QLog.e("JumpAction", 1, "doAction error:" + localException.getMessage());
      localObject1 = new HashMap(1);
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
      ((StringBuilder)localObject2).append("JumpAction").append("source:").append(this.jdField_a_of_type_JavaLangString).append("server_name:").append(this.jdField_b_of_type_JavaLangString).append("action_name:").append(this.jdField_c_of_type_JavaLangString);
      ((HashMap)localObject1).put("keyJumpParserUtilDoActionErrorInfo", ((StringBuilder)localObject2).toString());
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, (HashMap)localObject1, "", false);
      return false;
    }
    return d();
    label872:
    if ((this.jdField_b_of_type_JavaLangString.equals("wpa")) && (this.jdField_c_of_type_JavaLangString.equals("openid_to_uin"))) {
      return at();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.jdField_c_of_type_JavaLangString.equals("chat"))) {
      return av();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("wsgzh")) && (this.jdField_c_of_type_JavaLangString.equals("waterfall")))
    {
      ((IWSManager)QRoute.api(IWSManager.class)).enterWSPublicAccount(this.jdField_a_of_type_AndroidContentContext, "from_search_rzh_ws", false);
      return true;
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("wsgzh")) && (this.jdField_c_of_type_JavaLangString.equals("miniapp_player")) && ("openPlayer".equals(this.jdField_a_of_type_JavaUtilHashMap.get("action")))) {
      return ((IWSManager)QRoute.api(IWSManager.class)).enterWSVerticalPlayerPageForMiniApp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("asyncmsg")) && (this.jdField_c_of_type_JavaLangString.equals("open_async_detail"))) {
      return bz();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("connect_miniapp")) && (this.jdField_c_of_type_JavaLangString.equals("launch"))) {
      return au();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.jdField_c_of_type_JavaLangString.equals("aioorprofile"))) {
      return aA();
    }
    if (this.jdField_b_of_type_JavaLangString.equals("qapp")) {
      return bx();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.jdField_c_of_type_JavaLangString.equals("show_nearby_fri"))) {
      return aB();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.jdField_c_of_type_JavaLangString.equals("show_location"))) {
      return aE();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.jdField_c_of_type_JavaLangString.equals("select_location"))) {
      return aF();
    }
    if (("card".equals(this.jdField_b_of_type_JavaLangString)) && ("show_pslcard".equals(this.jdField_c_of_type_JavaLangString))) {
      return aG();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("personal_tag")) && (this.jdField_c_of_type_JavaLangString.equals("tag_list"))) {
      return aM();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("upload")) && (this.jdField_c_of_type_JavaLangString.equals("photo"))) {
      return aV();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("forward")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
      return aZ();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("forward")) && (this.jdField_c_of_type_JavaLangString.equals("invite_register"))) {
      return bL();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("gamesdk")) && (this.jdField_c_of_type_JavaLangString.equals("bind_group"))) {
      return aY();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("opensdk")) && (this.jdField_c_of_type_JavaLangString.equals("join_group"))) {
      return aW();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("opensdk")) && (this.jdField_c_of_type_JavaLangString.equals("bind_group"))) {
      return aX();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_fri"))) {
      return ba();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_qqdataline"))) {
      return a(new JumpAction.2(this));
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("gamesdk")) && (this.jdField_c_of_type_JavaLangString.equals("add_friend")))
    {
      if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"))) {
        n = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
      }
      return bc();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_qqfav"))) {
      return a(new JumpAction.3(this));
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_qzone"))) {
      return e("shareToQzone");
    }
    if (this.jdField_b_of_type_JavaLangString.equals("qzone")) {
      return H();
    }
    if (this.jdField_b_of_type_JavaLangString.equals("mqq"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "handleMQQService");
      }
      q();
    }
    boolean bool1;
    while ((this.jdField_b_of_type_JavaLangString.equals("schedule")) && (this.jdField_c_of_type_JavaLangString.equals("showDetail")))
    {
      return bA();
      if ((this.jdField_b_of_type_JavaLangString.equals("groupopenapp")) && (this.jdField_c_of_type_JavaLangString.equals("openapp"))) {
        return bS();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("lightapp")) && (this.jdField_c_of_type_JavaLangString.equals("open"))) {
        return bT();
      }
      if (this.jdField_b_of_type_JavaLangString.endsWith("app"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleAppForward");
        }
        return bv();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("qm")) && (this.jdField_c_of_type_JavaLangString.equals("qr"))) {
        return I();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("dc")) && (this.jdField_c_of_type_JavaLangString.equals("ft"))) {
        return bp();
      }
      if ("group".equals(this.jdField_b_of_type_JavaLangString))
      {
        if (this.jdField_c_of_type_JavaLangString.equals("nearby")) {
          return aC();
        }
        if (this.jdField_c_of_type_JavaLangString.equals("create")) {
          return aD();
        }
        if (this.jdField_c_of_type_JavaLangString.equals("report")) {
          return bN();
        }
      }
      else
      {
        if (this.jdField_b_of_type_JavaLangString.equals("shop")) {
          return J();
        }
        if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.jdField_c_of_type_JavaLangString.equals("game_invite")))
        {
          QLog.i("JumpAction", 1, "[cmshow.game_invite], source:" + this.jdField_a_of_type_JavaLangString);
          return f(this.jdField_a_of_type_JavaLangString);
        }
        if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("avatar_edit".equals(this.jdField_c_of_type_JavaLangString))) {
          return ah();
        }
        if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_avatar_edit".equals(this.jdField_c_of_type_JavaLangString))) {
          return aj();
        }
        if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_dynamic_avatar_edit".equals(this.jdField_c_of_type_JavaLangString))) {
          return ak();
        }
        if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_face_collection".equals(this.jdField_c_of_type_JavaLangString))) {
          return ai();
        }
        if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("more_info_edit".equals(this.jdField_c_of_type_JavaLangString)))
        {
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, FriendProfileMoreInfoActivity.class);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        }
        else if (("userprofile".equals(this.jdField_b_of_type_JavaLangString)) && ("friend_profile_card".equals(this.jdField_c_of_type_JavaLangString)))
        {
          g();
        }
        else
        {
          if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("might_know".equals(this.jdField_c_of_type_JavaLangString))) {
            return al();
          }
          if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("search_might_know".equals(this.jdField_c_of_type_JavaLangString))) {
            return am();
          }
          if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("new_friends".equals(this.jdField_c_of_type_JavaLangString))) {
            return an();
          }
          if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("contacts_tab".equals(this.jdField_c_of_type_JavaLangString))) {
            return ao();
          }
          if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("phone_recommend".equals(this.jdField_c_of_type_JavaLangString))) {
            return ap();
          }
          if ((this.jdField_b_of_type_JavaLangString.equals("healthcenter")) && (this.jdField_c_of_type_JavaLangString.equals("open"))) {
            return K();
          }
          if ((this.jdField_b_of_type_JavaLangString.equals("ptlogin")) && (this.jdField_c_of_type_JavaLangString.equals("qlogin"))) {
            return bq();
          }
          if ((this.jdField_b_of_type_JavaLangString.equals("gav")) && (this.jdField_c_of_type_JavaLangString.equals("request"))) {
            return br();
          }
          if (("videochat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.jdField_c_of_type_JavaLangString))) {
            return bs();
          }
          if (("randomavchat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.jdField_c_of_type_JavaLangString))) {
            return bt();
          }
          if (this.jdField_b_of_type_JavaLangString.equals("tribe")) {
            return L();
          }
          if ((this.jdField_b_of_type_JavaLangString.equals("qqdataline")) && (this.jdField_c_of_type_JavaLangString.equals("openqqdataline"))) {
            return ar();
          }
          if ((this.jdField_b_of_type_JavaLangString.equals("wallet")) && (this.jdField_c_of_type_JavaLangString.equals("modify_pass"))) {
            return aq();
          }
          if (this.jdField_b_of_type_JavaLangString.equals("dating"))
          {
            if (this.jdField_c_of_type_JavaLangString.equals("detail")) {
              return ag();
            }
            if (this.jdField_c_of_type_JavaLangString.equals("publish")) {
              return af();
            }
            if (this.jdField_c_of_type_JavaLangString.equals("feed")) {
              return ae();
            }
          }
          else if (this.jdField_b_of_type_JavaLangString.equals("nearby_entry"))
          {
            if (this.jdField_c_of_type_JavaLangString.equals("nearby_feed")) {
              return Z();
            }
            if (this.jdField_c_of_type_JavaLangString.equals("nearby_profile")) {
              return aH();
            }
            if (this.jdField_c_of_type_JavaLangString.equals("hotchat_list")) {
              return ab();
            }
            if (this.jdField_c_of_type_JavaLangString.equals("hotchat_room")) {
              return ac();
            }
            if (this.jdField_c_of_type_JavaLangString.equals("visitor_list")) {
              return y();
            }
          }
          else if (this.jdField_b_of_type_JavaLangString.equals("nearby"))
          {
            if (this.jdField_c_of_type_JavaLangString.equals("reportFriend")) {
              return bO();
            }
          }
          else if (this.jdField_b_of_type_JavaLangString.equals("hotchat"))
          {
            if (this.jdField_c_of_type_JavaLangString.equals("newyear_scene")) {
              return ad();
            }
          }
          else
          {
            bool1 = bool2;
            if (this.jdField_b_of_type_JavaLangString.equals("freshnews_entry")) {
              break label4973;
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qlink")) && (this.jdField_c_of_type_JavaLangString.equals("openqlink"))) {
              return by();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_troopbar"))) {
              return a(new JumpAction.4(this));
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qqconnect")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
              return bC();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("publicdevice")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
              return bD();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("openLightApp")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
              return p();
            }
            if (("tenpay".equals(this.jdField_b_of_type_JavaLangString)) && ("sendHongBao".equals(this.jdField_c_of_type_JavaLangString))) {
              return bE();
            }
            if (("massbless".endsWith(this.jdField_b_of_type_JavaLangString)) && ("mainpage".equals(this.jdField_c_of_type_JavaLangString))) {
              return q();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("interesttag")) {
              return Y();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("qqcomic")) {
              return bu();
            }
            if (("leba_plugin".equals(this.jdField_b_of_type_JavaLangString)) && ("set".equals(this.jdField_c_of_type_JavaLangString))) {
              return r();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("pa_relationship")) {
              return s();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("od")) {
              return e();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("odAddFriend")) {
              return bF();
            }
            if ("huayang".equals(this.jdField_b_of_type_JavaLangString)) {
              return bG();
            }
            if ("qboss".equals(this.jdField_b_of_type_JavaLangString)) {
              return QbossPreDownloadManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
            }
            if (this.jdField_b_of_type_JavaLangString.equals("readinjoy")) {
              return M();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.jdField_c_of_type_JavaLangString.equals("apollo_action")))
            {
              if (((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloFuncOpen(this.jdField_a_of_type_AndroidContentContext)) {
                return x();
              }
            }
            else
            {
              if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.jdField_c_of_type_JavaLangString.equals("open_game"))) {
                return a(this.jdField_a_of_type_JavaUtilHashMap);
              }
              if ("favorites".equals(this.jdField_b_of_type_JavaLangString))
              {
                if ("forward_favorites".equals(this.jdField_c_of_type_JavaLangString))
                {
                  localObject1 = new Intent();
                  ((Intent)localObject1).putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690778));
                  return QfavHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, -1, false);
                }
              }
              else if ("hongbao_share".equals(this.jdField_b_of_type_JavaLangString))
              {
                if ("hongbao_brush".equals(this.jdField_c_of_type_JavaLangString)) {
                  return V();
                }
              }
              else if ("general_ar".equals(this.jdField_b_of_type_JavaLangString))
              {
                if ("gotoScannerTorchActivity".equals(this.jdField_c_of_type_JavaLangString)) {
                  return W();
                }
              }
              else
              {
                if ("mqqavshare://".equals(this.jdField_b_of_type_JavaLangString))
                {
                  this.jdField_j_of_type_Boolean = true;
                  return ShareChat.a(this);
                }
                if ("assistant_setting".equals(this.jdField_b_of_type_JavaLangString))
                {
                  if ("ASSISTANT_SETTING".equals(this.jdField_c_of_type_JavaLangString)) {
                    return h_();
                  }
                }
                else if ((this.jdField_b_of_type_JavaLangString.equals("conf")) || (this.jdField_b_of_type_JavaLangString.equals("confpstn")) || (this.jdField_b_of_type_JavaLangString.equals("confhr")))
                {
                  if (this.jdField_c_of_type_JavaLangString.equals("ft")) {
                    return z();
                  }
                }
                else if ("teamwork".equals(this.jdField_b_of_type_JavaLangString))
                {
                  if ("opendoclist".equals(this.jdField_c_of_type_JavaLangString)) {
                    return U();
                  }
                }
                else
                {
                  if ("qstory".equals(this.jdField_b_of_type_JavaLangString))
                  {
                    if ("openNow".equals(this.jdField_c_of_type_JavaLangString)) {
                      return g();
                    }
                    return S();
                  }
                  if (("now".equals(this.jdField_b_of_type_JavaLangString)) || ("ilive".equals(this.jdField_b_of_type_JavaLangString)))
                  {
                    if ("openroom".equals(this.jdField_c_of_type_JavaLangString)) {
                      return g();
                    }
                    if ("prelogin".equals(this.jdField_c_of_type_JavaLangString)) {
                      return A();
                    }
                    if ("playmedia".equals(this.jdField_c_of_type_JavaLangString)) {
                      return i();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("contact")) && (this.jdField_c_of_type_JavaLangString.equals("add"))) {
      return i_();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("profile")) && (this.jdField_c_of_type_JavaLangString.equals("setting"))) {
      return f();
    }
    if (this.jdField_b_of_type_JavaLangString.equals("qqreg")) {
      return bM();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("troop_member_card")) && (this.jdField_c_of_type_JavaLangString.equals("open_member_recent_chat_view"))) {
      return aa();
    }
    if (this.jdField_b_of_type_JavaLangString.equals("qwerewolf"))
    {
      if (this.jdField_c_of_type_JavaLangString.equals("openInvitationRoom")) {
        return Q();
      }
      bool1 = bool2;
      if (this.jdField_c_of_type_JavaLangString.equals("enterGameRoom")) {
        return R();
      }
    }
    else if (this.jdField_b_of_type_JavaLangString.equals("groupvideo"))
    {
      if (this.jdField_c_of_type_JavaLangString.equals("openroom")) {
        return bP();
      }
      bool1 = bool2;
      if (this.jdField_c_of_type_JavaLangString.equals("preload")) {
        return bQ();
      }
    }
    else
    {
      if (this.jdField_b_of_type_JavaLangString.equals("studyroom")) {
        return bR();
      }
      if (this.jdField_b_of_type_JavaLangString.equals("invite_join_group"))
      {
        bool1 = bool2;
        if (this.jdField_c_of_type_JavaLangString.equals("open")) {
          return B();
        }
      }
      else
      {
        if (("troop_homework".equals(this.jdField_b_of_type_JavaLangString)) && ("publish".equals(this.jdField_c_of_type_JavaLangString))) {
          return a(b("gc"));
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
          bool1 = bool2;
          if ("open".equals(this.jdField_c_of_type_JavaLangString))
          {
            j();
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
            bool1 = bool2;
            if (this.jdField_c_of_type_JavaLangString.equals("openroom")) {
              return bU();
            }
          }
          else
          {
            if ("share_group".equals(this.jdField_b_of_type_JavaLangString))
            {
              if (!this.jdField_c_of_type_JavaLangString.equals("open")) {
                break label4975;
              }
              localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
              if (localObject1 == null) {
                break label4975;
              }
              TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1);
              break label4975;
            }
            if ("edit_group".equals(this.jdField_b_of_type_JavaLangString))
            {
              if (!this.jdField_c_of_type_JavaLangString.equals("open")) {
                break label4977;
              }
              localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
              if (localObject1 == null) {
                break label4977;
              }
              TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1);
              break label4977;
            }
            if ("weishiforqassistant".equals(this.jdField_b_of_type_JavaLangString))
            {
              ((IWSManager)QRoute.api(IWSManager.class)).enterWSPublicAccount(this.jdField_a_of_type_AndroidContentContext, "from_audio_assistant", true);
              return true;
            }
            if ("nearbyforqassistant".equals(this.jdField_b_of_type_JavaLangString)) {
              return Z();
            }
            if ("qechatforqassistant".equals(this.jdField_b_of_type_JavaLangString))
            {
              ExtendFriendPublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext);
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
              return h();
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
              if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
                break label4979;
              }
              RecentOptPopBar.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 0L, 0L, 0);
              break label4979;
            }
            if ("bind_number".equals(this.jdField_b_of_type_JavaLangString))
            {
              bool1 = bool2;
              if ("bind".equals(this.jdField_c_of_type_JavaLangString))
              {
                X();
                return true;
              }
            }
            else if ("stickynote".equals(this.jdField_b_of_type_JavaLangString))
            {
              bool1 = bool2;
              if ("feeddetail".equals(this.jdField_c_of_type_JavaLangString))
              {
                i();
                return true;
              }
            }
            else if ("commonBuddyGroup".equals(this.jdField_b_of_type_JavaLangString))
            {
              bool1 = bool2;
              if ("open".equals(this.jdField_c_of_type_JavaLangString))
              {
                h();
                return true;
              }
            }
            else
            {
              bool1 = bool2;
              if ("hippy".equals(this.jdField_b_of_type_JavaLangString))
              {
                bool1 = bool2;
                if ("open".equals(this.jdField_c_of_type_JavaLangString)) {
                  bool1 = new HippyAccessHelper.OpenHippyInfo(this.jdField_a_of_type_JavaUtilHashMap).openHippy(this.jdField_a_of_type_AndroidContentContext);
                }
              }
            }
          }
        }
      }
    }
    label4973:
    return bool1;
    label4975:
    return true;
    label4977:
    return true;
    label4979:
    return true;
  }
  
  protected boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      PublishHomeWorkFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, null, paramString);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772314, 2130771992);
    }
    return true;
  }
  
  public boolean a(Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      QLog.e("JumpAction", 1, "[gotoApolloGame] attrs null");
      return false;
    }
    Object localObject = (String)paramMap.get("gameid");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = (String)paramMap.get("gameId");
    }
    for (;;)
    {
      String str = (String)paramMap.get("gamename");
      if (TextUtils.isEmpty(str)) {
        str = (String)paramMap.get("gameName");
      }
      for (;;)
      {
        QLog.d("JumpAction", 1, new Object[] { "[gotoApolloGame] game id=", localObject });
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            int i3 = Integer.parseInt((String)localObject);
            int i2 = 221;
            int i1 = i2;
            if (paramMap.containsKey("src")) {
              localObject = (String)paramMap.get("src");
            }
            try
            {
              i1 = Integer.parseInt((String)localObject);
              QLog.d("JumpAction", 1, new Object[] { "[gotoApolloGame] src=", Integer.valueOf(i1) });
              CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(i3, true, "launch", 0L, 9, 8, 0, 0, "", i1, str);
              str = (String)paramMap.get("gameParam");
              localObject = str;
              if (TextUtils.isEmpty(str)) {
                localObject = (String)paramMap.get("gameparam");
              }
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                localStartCheckParam.extendJson = ((String)localObject);
                QLog.d("JumpAction", 1, new Object[] { "[gotoApolloGame] gameParam=", localObject });
              }
              ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentContext, localStartCheckParam);
              return true;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("JumpAction", 1, "open apollo game, parse src failed, e=", localException);
                i1 = i2;
              }
            }
            QLog.e("JumpAction", 1, "open apollo game failed, no game id");
          }
          catch (Exception paramMap)
          {
            QLog.e("JumpAction", 1, "open apollo game, parse game id failed, e=", paramMap);
            return false;
          }
        }
        return false;
      }
    }
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
      paramIntent.putExtra("extra_share_from_type", b(this.jdField_a_of_type_JavaUtilHashMap));
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public String b(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void b()
  {
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    if ((!((JumpActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public Intent c(Intent paramIntent)
  {
    paramIntent.putExtra("action", 12);
    try
    {
      paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
      paramIntent.putExtra("extra_share_from_type", b(this.jdField_a_of_type_JavaUtilHashMap));
      paramIntent.putExtra("to_new_version", (String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"));
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public Intent d(Intent paramIntent)
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("showinfocard");
    int i1 = b(this.jdField_a_of_type_JavaUtilHashMap);
    if ((str5 != null) && (str5.equals("0"))) {}
    for (boolean bool = false;; bool = true)
    {
      if (TextUtils.isEmpty(str4))
      {
        if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
          return null;
        }
        int i2;
        try
        {
          i2 = Integer.parseInt(str2);
          if (i2 == 1)
          {
            if (TextUtils.isEmpty(str1)) {
              return null;
            }
            paramIntent.putExtra("action", 7);
            paramIntent.putExtra("EXTRA_USER_UIN", str1);
            paramIntent.putExtra("EXTRA_USER_UNION_ID", str3);
            paramIntent.putExtra("extra_is_show_info_card", bool);
            paramIntent.putExtra("extra_share_from_type", i1);
            paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
            return paramIntent;
          }
        }
        catch (NumberFormatException paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "makeStoryPlayVideoPageIntent, NumberFormatException, userId:" + str1 + ", userType:" + str2);
          }
          return null;
        }
        if (i2 == 5)
        {
          paramIntent.putExtra("action", 4);
          paramIntent.putExtra("extra_topic_id", Long.parseLong(str1));
          paramIntent.putExtra("extra_topic_name", (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname"));
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topiccolor");
          if (!TextUtils.isEmpty(str3)) {
            paramIntent.putExtra("extra_topic_color", Integer.parseInt(str3));
          }
          paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
          paramIntent.putExtra("extra_share_from_type", i1);
          return paramIntent;
        }
        paramIntent.putExtra("action", 6);
        paramIntent.putExtra("user_type", Integer.parseInt(str2));
        paramIntent.putExtra("user_unionid", str3);
        paramIntent.putExtra("come_from", i1);
        paramIntent.putExtra("showTitleBar", false);
        paramIntent.putExtra("showInfoCard", bool);
        return paramIntent;
      }
      paramIntent.putExtra("action", 6);
      paramIntent.putExtra("story_id", str4);
      paramIntent.putExtra("come_from", i1);
      paramIntent.putExtra("showTitleBar", false);
      paramIntent.putExtra("showInfoCard", false);
      return paramIntent;
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void d(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public boolean d()
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
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("weburl")) {}
    for (localObject = Uri.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("weburl")); (((String)localObject).startsWith("https://sou.qq.com/")) || (((String)localObject).startsWith("https://sou.html5.qq.com/")); localObject = "")
    {
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("fragment_class", "com.tencent.mobileqq.search.activity.MixSearchWebFragment");
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!"1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("openanimtype")))) {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(0, 0);
      }
      return true;
    }
    return false;
  }
  
  public void e(String paramString)
  {
    this.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public boolean e()
  {
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"))) {}
    try
    {
      localObject1 = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"), "utf-8");
      str1 = "";
      localObject3 = str1;
      if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("userdata"))) {}
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      try
      {
        localObject3 = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"), "utf-8");
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(str3);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          for (;;)
          {
            int i1;
            localNumberFormatException1.printStackTrace();
          }
        }
        i1 = 0;
        try
        {
          int i2 = Integer.parseInt(str2);
          i1 = i2;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject4;
            localNumberFormatException2.printStackTrace();
          }
        }
        ((ODProxy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ODPROXY_MGR)).a(this.jdField_a_of_type_AndroidContentContext, l1, "launcher", (String)localObject1, (String)localObject3, i1);
        return true;
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
        localUnsupportedEncodingException1.printStackTrace();
        localObject2 = localObject3;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          String str1;
          localUnsupportedEncodingException2.printStackTrace();
          localObject4 = str1;
        }
      }
    }
  }
  
  public void f(String paramString)
  {
    this.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public boolean f()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, InterestSwitchEditActivity.class);
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean g()
  {
    Object localObject1;
    String str2;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if (localObject1 != null)
      {
        str2 = ((Intent)localObject1).getStringExtra("big_brother_source_key");
        localObject1 = ((Intent)localObject1).getDataString();
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = this.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("roomid")) {}
        for (String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");; str3 = "0")
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("fromid")) {}
          for (String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");; str4 = "")
          {
            if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("roomtype")) {}
            for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomtype");; str5 = "")
            {
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("list_name")) {}
              for (String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("list_name");; str6 = "")
              {
                if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("first_jump_mode")) {}
                for (String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("first_jump_mode");; str7 = "h5")
                {
                  if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("need_record")) {}
                  for (String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("need_record");; str8 = "1")
                  {
                    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("is_record")) {}
                    for (String str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("is_record");; str9 = "0")
                    {
                      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("enter_record_if_finish")) {}
                      for (String str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enter_record_if_finish");; str10 = "1")
                      {
                        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("nowapp_ext")) {}
                        for (String str11 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nowapp_ext");; str11 = "")
                        {
                          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("nowplugin_ext")) {}
                          for (String str12 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nowplugin_ext");; str12 = "")
                          {
                            if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("h5_ext")) {}
                            for (String str13 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("h5_ext");; str13 = "")
                            {
                              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("shakespearetime")) {}
                              for (String str14 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shakespearetime");; str14 = "")
                              {
                                if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msgurl")) {}
                                for (String str15 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("msgurl"));; str15 = "")
                                {
                                  if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hostloading_percent")) {}
                                  for (String str16 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hostloading_percent");; str16 = "0")
                                  {
                                    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("enter_ts")) {}
                                    for (;;)
                                    {
                                      try
                                      {
                                        l1 = Long.parseLong((String)this.jdField_a_of_type_JavaUtilHashMap.get("enter_ts"));
                                        String str17 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("coverurl");
                                        String str18 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extras");
                                        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
                                        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("first");
                                        localObject2 = new Bundle();
                                        ((Bundle)localObject2).putString("coverurl", str17);
                                        ((Bundle)localObject2).putString("roomid", str3);
                                        ((Bundle)localObject2).putString("roomtype", str5);
                                        ((Bundle)localObject2).putString("extras_from_js", str18);
                                        ((Bundle)localObject2).putBoolean("can_use_h5_first", true);
                                        ((Bundle)localObject2).putString("first_jump_mode", str7);
                                        ((Bundle)localObject2).putString("is_record", str9);
                                        ((Bundle)localObject2).putString("enter_record_if_finish", str10);
                                        ((Bundle)localObject2).putString("nowapp_ext", str11);
                                        ((Bundle)localObject2).putString("nowplugin_ext", str12);
                                        ((Bundle)localObject2).putString("h5_ext", str13);
                                        ((Bundle)localObject2).putString("shakespearetime", str14);
                                        ((Bundle)localObject2).putString("fromid", str4);
                                        ((Bundle)localObject2).putString("url", str15);
                                        ((Bundle)localObject2).putString("listname", str6);
                                        ((Bundle)localObject2).putString("mqqScheme", (String)localObject1);
                                        ((Bundle)localObject2).putLong("enter_ts", l1);
                                        if (!TextUtils.isEmpty(str2)) {
                                          ((Bundle)localObject2).putString("big_brother_source_key", str2);
                                        }
                                        boolean bool2 = true;
                                        boolean bool1 = bool2;
                                        if (!TextUtils.isEmpty(str8))
                                        {
                                          bool1 = bool2;
                                          if ("0".equals(str8)) {
                                            bool1 = false;
                                          }
                                        }
                                        ((Bundle)localObject2).putBoolean("need_record", bool1);
                                        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("topic")) {
                                          ((Bundle)localObject2).putString("topic", (String)this.jdField_a_of_type_JavaUtilHashMap.get("topic"));
                                        }
                                        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("story_ext")) {
                                          ((Bundle)localObject2).putString("story_ext", (String)this.jdField_a_of_type_JavaUtilHashMap.get("story_ext"));
                                        }
                                        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("startsrc")) {
                                          ((Bundle)localObject2).putString("startsrc", (String)this.jdField_a_of_type_JavaUtilHashMap.get("startsrc"));
                                        }
                                        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hostloading_percent")) {
                                          ((Bundle)localObject2).putInt("hostloading_percent", Integer.valueOf(str16).intValue());
                                        }
                                        if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
                                        {
                                          QQToast.a(BaseApplicationImpl.getApplication(), 1, "无网络连接请稍后再试", 1).a();
                                          return false;
                                        }
                                      }
                                      catch (NumberFormatException localNumberFormatException)
                                      {
                                        Object localObject2;
                                        localNumberFormatException.printStackTrace();
                                        QLog.e("JumpAction", 1, "goNowRoom------NumberFormatException, e = " + localNumberFormatException.getMessage());
                                        l1 = 0L;
                                        continue;
                                        try
                                        {
                                          ((DynamicNowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a((Bundle)localObject2);
                                          QLog.i("JumpAction", 1, "enter now plugin use shadow");
                                          return true;
                                        }
                                        catch (Exception localException)
                                        {
                                          if (QLog.isColorLevel()) {
                                            QLog.e("JumpAction", 2, localException.toString());
                                          }
                                          return false;
                                        }
                                      }
                                      long l1 = 0L;
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      String str1 = "";
      str2 = null;
    }
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Object localObject = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    if ((localObject != null) && ((((QZoneManagerImp)localObject).a(2) > 0) || (((QZoneManagerImp)localObject).a(1) > 0))) {}
    for (boolean bool = true;; bool = false)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("newflag", bool);
      localIntent.putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      localIntent.addFlags(805306368);
      if (this.jdField_a_of_type_JavaLangString != null) {}
      for (localObject = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("push_trans_channel");; localObject = null)
      {
        QZoneHelper.forwardToFriendFeed((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localIntent, (String)localObject, -1);
        LpReportInfo_dc02880.report(this.jdField_a_of_type_JavaLangString);
        return true;
      }
    }
  }
  
  public boolean h_()
  {
    Intent localIntent = new Intent();
    if (SettingsConfigHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, AssistantSettingFragment.class);
    }
    for (;;)
    {
      return true;
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, AssistantSettingActivity.class);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  public boolean i()
  {
    SmallVideoFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    return true;
  }
  
  public boolean i_()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddContactsActivity.class);
    localIntent.setFlags(67108864);
    int i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("des_type"));
    int i1 = i2;
    if (i2 != 0)
    {
      i1 = i2;
      if (i2 != 1)
      {
        i1 = i2;
        if (i2 != 2) {
          i1 = 0;
        }
      }
    }
    localIntent.putExtra("tab_index_key", i1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean j()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  public boolean k()
  {
    new JumpAction.1(this).start();
    return a();
  }
  
  public boolean l()
  {
    if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.jdField_c_of_type_JavaLangString.equals("aioorprofile"))) {}
    while (((this.jdField_b_of_type_JavaLangString.equals("group")) && (this.jdField_c_of_type_JavaLangString.equals("creategroup"))) || ((this.jdField_b_of_type_JavaLangString.equals("qstory")) && (this.jdField_c_of_type_JavaLangString.equals("publish")))) {
      return true;
    }
    return false;
  }
  
  public boolean m()
  {
    return (this.jdField_b_of_type_JavaLangString.equals("card")) && (this.jdField_c_of_type_JavaLangString.equals("show_pslcard")) && ("public_account".equals(this.jdField_a_of_type_JavaUtilHashMap.get("card_type"))) && ("app".equals(this.jdField_a_of_type_JavaUtilHashMap.get("src_type"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")));
  }
  
  public boolean n()
  {
    return (this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_fri"));
  }
  
  public boolean o()
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
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717706));
    localIntent.setData(Uri.parse(str));
    localIntent.addFlags(268435456);
    localIntent.putExtra("needSkey", "true");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean p()
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
  
  public boolean q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "gotoSendBless");
    }
    BlessManager localBlessManager = (BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
    if (localBlessManager.a()) {
      localBlessManager.a(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      return true;
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, HardCodeUtil.a(2131705927), 0).a();
    }
  }
  
  public boolean r()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("id");
    if (str == null) {
      return false;
    }
    try
    {
      l1 = Long.parseLong(str);
      if (l1 == -1L) {
        return false;
      }
    }
    catch (Exception localException)
    {
      long l1;
      for (;;)
      {
        l1 = -1L;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LebaSearchPluginManagerActivity.class);
      localIntent.putExtra("id", l1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    return true;
  }
  
  public boolean s()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_type");
    if ((localObject != null) && ("public_account".equals(localObject)))
    {
      int i1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("account_flag")));
      if ((i1 == -3) || (i1 == -4)) {
        ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), 0L, 1);
      }
    }
    do
    {
      do
      {
        return true;
      } while ((localObject == null) || (!"crm".equals(localObject)));
      localObject = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
    } while (localObject == null);
    ((EnterpriseQQHandler)localObject).a(SystemClock.uptimeMillis());
    return true;
  }
  
  public boolean t()
  {
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("channelid");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("channelname");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("target");
    int i2;
    int i1;
    if ("1".equals(str5))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      if ("qzone".equals(localObject1)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067C6", "0X80067C6", 0, 0, "", "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", false);
      }
      if ("webview".equals(this.jdField_d_of_type_JavaLangString)) {
        TroopMemberApiClient.a().a((String)localObject1, this.jdField_a_of_type_JavaUtilHashMap);
      }
      for (;;)
      {
        return true;
        i2 = 12;
        i1 = i2;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          i1 = i2;
          if (TextUtils.isDigitsOnly((CharSequence)localObject1)) {
            i1 = Integer.valueOf((String)localObject1).intValue();
          }
        }
        if (ReadInJoyHelper.i())
        {
          try
          {
            localObject1 = ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, i1);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          }
          catch (Exception localException1) {}
          if (QLog.isColorLevel()) {
            QLog.e("JumpAction", 1, "jump activity error1 ", localException1);
          }
        }
        else if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 2, 0);
        }
        else
        {
          ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, 2);
        }
      }
    }
    int i3;
    Object localObject2;
    if ("2".equals(str5))
    {
      if (str3 == null) {
        return false;
      }
      try
      {
        i2 = Integer.parseInt(str3);
      }
      catch (Exception localException8)
      {
        try
        {
          for (;;)
          {
            i3 = Integer.parseInt(str1);
            if (i2 != -1) {
              break;
            }
            return false;
            localException8 = localException8;
            if (QLog.isDevelopLevel()) {
              QLog.e("JumpAction", 4, "gotoReadInJoy channelId error");
            }
            i2 = -1;
          }
        }
        catch (Exception localException5)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("JumpAction", 4, "gotoReadInJoy channelType error");
            }
            i3 = 0;
          }
        }
      }
      if (!TextUtils.isEmpty(localException1)) {
        break label1533;
      }
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131699723);
    }
    label935:
    label1470:
    label1533:
    for (;;)
    {
      for (;;)
      {
        String str4;
        for (;;)
        {
          for (;;)
          {
            boolean bool = "1".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("ispush"));
            if ((!bool) && (i2 == 70))
            {
              if ("webview".equals(this.jdField_d_of_type_JavaLangString)) {
                TroopMemberApiClient.a().k();
              }
              for (;;)
              {
                return true;
                KandianSubscribeManager.a(this.jdField_a_of_type_AndroidContentContext, 3, 4);
              }
            }
            if (i3 == 3)
            {
              if (i2 == 56)
              {
                if (ReadInJoyHelper.o())
                {
                  ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, i2, (String)localObject2, i3, 4);
                  break;
                }
                ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 4, 1);
                break;
              }
              ReadInJoyActivityHelper.b(this.jdField_a_of_type_AndroidContentContext, i2, (String)localObject2, i3, 4);
              break;
            }
            String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("changeChannelOrder");
            i1 = 0;
            str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("moveChannelFromSource");
            try
            {
              i4 = Integer.valueOf(str2).intValue();
              i1 = i4;
              int i5 = Integer.valueOf(str4).intValue();
              i1 = i5;
            }
            catch (Exception localException6)
            {
              int i4;
              for (;;)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.e("JumpAction", 4, "gotoReadInJoy channelOrder error," + localException6.toString());
                }
                i4 = i1;
                i1 = 0;
              }
              Bundle localBundle = new Bundle();
              localBundle.putInt("key_native_channel_id", i2);
              localBundle.putInt("key_native_channel_change_order", i4);
              localBundle.putString("key_native_channel_name", (String)localObject2);
              localBundle.putInt("key_native_channel_type", i3);
              localBundle.putBoolean("key_native_channel_is_push", bool);
              localBundle.putInt("key_channel_source_from", i1);
              localBundle.putString("key_channel_jump_scheme", this.jdField_a_of_type_JavaLangString);
              QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_native_channel_jump", localBundle, null);
            }
            ReadInJoyBaseFragment.a(i2, 3);
            if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("v_url")) || (this.jdField_a_of_type_JavaUtilHashMap.containsKey("v_url_base64")))
            {
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("key_viola_fragment_jump_url", this.jdField_a_of_type_JavaLangString);
              ((Bundle)localObject2).putInt("key_native_channel_change_order", i4);
              ((Bundle)localObject2).putInt("key_native_channel_id", i2);
              QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_viola_fragment_jump", (Bundle)localObject2, null);
              break;
            }
            break;
            if (!"2001".equals(str5)) {
              break label935;
            }
            i1 = Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("from")).intValue();
            if (!ReadInJoyHelper.m()) {
              break label894;
            }
            try
            {
              localObject2 = ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, i1);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            }
            catch (Exception localException2) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("JumpAction", 1, "jump activity error1 ", localException2);
          break;
          label894:
          if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, 0);
            break;
          }
          ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, i1);
          break;
          Object localObject3;
          if ("3".equals(str5))
          {
            localObject3 = ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
            if ((this.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity))
            {
              ((FastWebActivity)this.jdField_a_of_type_AndroidContentContext).a((Intent)localObject3);
              break;
            }
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
            break;
          }
          if ("4".equals(str5))
          {
            localObject3 = this.jdField_a_of_type_AndroidContentContext;
            if (BaseActivity.sTopActivity != null) {
              localObject3 = BaseActivity.sTopActivity;
            }
            ReadInJoyActivityHelper.a((Context)localObject3, this.jdField_a_of_type_JavaUtilHashMap);
            break;
          }
          if ("5".equals(str5))
          {
            ReadInJoyActivityHelper.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
            break;
          }
          if (!"6".equals(str5)) {
            break label1166;
          }
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("v_url_base64")) {
            break;
          }
          try
          {
            localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("v_url_base64"));
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break;
            }
            ViolaAccessHelper.a(this.jdField_a_of_type_AndroidContentContext, "", (String)localObject3, null);
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            QLog.w("JumpAction", 1, "[gotoReadInJoyFromSourceTarget] openViolaPage, v_url error->" + localException3.getMessage());
          }
        }
        break;
        if ("7".equals(str5))
        {
          ReadInJoyActivityHelper.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
          break;
        }
        if ("8".equals(str5))
        {
          if ("webview".equals(this.jdField_d_of_type_JavaLangString))
          {
            TroopMemberApiClient.a().f(this.jdField_d_of_type_JavaLangString);
            break;
          }
          KandianDailyManager.a(this.jdField_a_of_type_AndroidContentContext);
          break;
        }
        if ("9".equals(str5))
        {
          ReadInjoyFloatingWindowHelper.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
          break;
        }
        Intent localIntent1;
        if ("10".equals(str5))
        {
          if ("1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("bizType")))
          {
            localIntent1 = new Intent(this.jdField_a_of_type_AndroidContentContext, ReadInJoySettingActivity.class);
            this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
            break;
          }
          if (!"2".equals(this.jdField_a_of_type_JavaUtilHashMap.get("bizType"))) {
            break;
          }
          PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, ReadInJoyDraftboxFragment.class);
          break;
        }
        if (str4 == null) {
          return false;
        }
        try
        {
          i1 = Integer.parseInt(str4);
          if (i1 == -1) {
            return false;
          }
        }
        catch (Exception localException7)
        {
          Object localObject4;
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("JumpAction", 4, "gotoReadInJoy channelId error");
            }
            i1 = -1;
            continue;
            localObject4 = localIntent1;
            if (TextUtils.isEmpty(localIntent1)) {
              localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131699723);
            }
            if (!ReadInJoyHelper.o()) {
              break label1470;
            }
            try
            {
              localIntent1 = ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, 12);
              this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
            }
            catch (Exception localException4) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("JumpAction", 1, "jump activity error1 ", localException4);
          break;
          Intent localIntent2 = new Intent("android.intent.action.MAIN");
          localIntent2.putExtra("channel_id", i1);
          localIntent2.putExtra("channel_name", (String)localObject4);
          localIntent2.putExtra("readinjoy_launch_source", 7);
          ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localIntent2);
        }
      }
      break;
    }
  }
  
  public boolean u()
  {
    int i3 = 0;
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("sub_action"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sub_action");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("action_name")) {
        break label133;
      }
    }
    label133:
    for (String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("action_name");; str2 = "")
    {
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        break label140;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "subAction[" + str1 + "] or actionName[" + str2 + "] null");
      }
      return true;
      str1 = "";
      break;
    }
    label140:
    String str3;
    label168:
    String str4;
    label196:
    String str5;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tag"))
    {
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("main_action")) {
        break label574;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("main_action");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("to_uin")) {
        break label581;
      }
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("to_uin");
      label224:
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("from_type")))) {
        break label630;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "webReportT get from_type: " + (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"));
      }
    }
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"));
        i2 = i3;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("result"))
        {
          i2 = i3;
          if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("result"))) {
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, "webReportT get result: " + (String)this.jdField_a_of_type_JavaUtilHashMap.get("result"));
            }
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("result"));
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("r2"))
          {
            String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("r2");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("r3")) {
              continue;
            }
            str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("r3");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("r4")) {
              continue;
            }
            str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("r4");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("r5")) {
              continue;
            }
            str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("r5");
            ReportController.b(null, str3, str4, str5, str1, str2, i1, i2, str6, str8, str9, str10);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("JumpAction", 2, "webReportT ");
            return true;
            str3 = "";
            break label168;
            label574:
            str4 = "";
            break label196;
            label581:
            str5 = "";
            break label224;
            localException1 = localException1;
            i1 = 0;
            continue;
          }
          String str7 = "";
          continue;
          String str8 = "";
          continue;
          String str9 = "";
          continue;
          String str10 = "";
          continue;
        }
        catch (Exception localException2)
        {
          int i2 = i3;
          continue;
        }
      }
      label630:
      int i1 = 0;
    }
  }
  
  public boolean v()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("source")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("source"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("source_article_id")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("source_article_id"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("operation")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("operation"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("op_source")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("op_source")))) {}
    try
    {
      int i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("source"));
      long l1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("source_article_id"));
      int i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("operation"));
      int i3 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("op_source"));
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "webReportArticleRealTime get source[ " + (String)this.jdField_a_of_type_JavaUtilHashMap.get("source") + "] source_article_id[" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("source_article_id") + "] operation[" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("operation") + "] op_source[" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("op_source") + "]");
      }
      ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, i2, i3);
    }
    catch (Exception localException)
    {
      label326:
      break label326;
    }
    return true;
  }
  
  /* Error */
  public boolean w()
  {
    // Byte code:
    //   0: new 324	android/os/Bundle
    //   3: dup
    //   4: invokespecial 325	android/os/Bundle:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 6944
    //   14: aload_0
    //   15: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   18: ldc_w 2036
    //   21: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 45	java/lang/String
    //   27: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload 6
    //   35: ldc_w 6946
    //   38: aload_0
    //   39: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   42: ldc_w 2218
    //   45: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast 45	java/lang/String
    //   51: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   54: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 6
    //   59: ldc_w 6948
    //   62: aload_0
    //   63: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   66: ldc_w 6950
    //   69: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 45	java/lang/String
    //   75: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 6
    //   80: ldc_w 6952
    //   83: aload_0
    //   84: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   87: ldc_w 6954
    //   90: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast 45	java/lang/String
    //   96: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 6
    //   101: ldc_w 6956
    //   104: aload_0
    //   105: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   108: ldc_w 6958
    //   111: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: checkcast 45	java/lang/String
    //   117: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 6
    //   122: ldc_w 6960
    //   125: aload_0
    //   126: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   129: ldc_w 6962
    //   132: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 45	java/lang/String
    //   138: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 6
    //   143: ldc_w 6964
    //   146: aload_0
    //   147: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   150: ldc_w 6966
    //   153: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: checkcast 45	java/lang/String
    //   159: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload 6
    //   164: ldc_w 6968
    //   167: iconst_0
    //   168: invokevirtual 778	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   171: aload 6
    //   173: ldc_w 6970
    //   176: ldc_w 301
    //   179: aload_0
    //   180: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   183: ldc_w 6972
    //   186: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   189: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   192: invokevirtual 778	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   195: aload 6
    //   197: ldc_w 6974
    //   200: aload_0
    //   201: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   204: ldc_w 6976
    //   207: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: checkcast 45	java/lang/String
    //   213: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   216: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   223: ldc_w 6978
    //   226: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   229: checkcast 196	java/lang/CharSequence
    //   232: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne +40 -> 275
    //   238: aload 6
    //   240: ldc_w 6980
    //   243: new 6982	java/math/BigInteger
    //   246: dup
    //   247: aload_0
    //   248: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   251: ldc_w 6978
    //   254: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   257: checkcast 45	java/lang/String
    //   260: invokespecial 6983	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   263: invokevirtual 6984	java/math/BigInteger:longValue	()J
    //   266: invokestatic 1458	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: invokevirtual 290	java/lang/Long:longValue	()J
    //   272: invokevirtual 951	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   275: aload_0
    //   276: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   279: ldc_w 6986
    //   282: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   285: checkcast 196	java/lang/CharSequence
    //   288: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   291: ifne +30 -> 321
    //   294: aload 6
    //   296: ldc_w 6988
    //   299: aload_0
    //   300: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   303: ldc_w 6986
    //   306: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   309: checkcast 45	java/lang/String
    //   312: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   315: invokevirtual 883	java/lang/Integer:intValue	()I
    //   318: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   321: aload_0
    //   322: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   325: ldc_w 6990
    //   328: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   331: checkcast 196	java/lang/CharSequence
    //   334: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   337: ifne +24 -> 361
    //   340: aload 6
    //   342: ldc_w 6992
    //   345: aload_0
    //   346: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   349: ldc_w 6990
    //   352: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   355: checkcast 45	java/lang/String
    //   358: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload_0
    //   362: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   365: ldc_w 6994
    //   368: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: checkcast 45	java/lang/String
    //   374: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   377: ifne +1449 -> 1826
    //   380: aload 6
    //   382: ldc_w 6996
    //   385: aload_0
    //   386: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   389: ldc_w 6994
    //   392: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   395: checkcast 45	java/lang/String
    //   398: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   401: invokevirtual 883	java/lang/Integer:intValue	()I
    //   404: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   407: aload_0
    //   408: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   411: ldc_w 6998
    //   414: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   417: checkcast 45	java/lang/String
    //   420: astore 5
    //   422: aload 5
    //   424: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   427: ifne +19 -> 446
    //   430: aload 6
    //   432: ldc_w 7000
    //   435: aload 5
    //   437: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   440: invokevirtual 883	java/lang/Integer:intValue	()I
    //   443: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   446: aload 6
    //   448: ldc_w 7002
    //   451: aload_0
    //   452: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   455: ldc_w 7004
    //   458: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   461: checkcast 45	java/lang/String
    //   464: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload 6
    //   472: ldc_w 7006
    //   475: aload_0
    //   476: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   479: ldc_w 7008
    //   482: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   485: checkcast 45	java/lang/String
    //   488: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   491: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload_0
    //   495: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   498: ldc_w 7010
    //   501: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   504: checkcast 45	java/lang/String
    //   507: astore 5
    //   509: aload 5
    //   511: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   514: ifne +19 -> 533
    //   517: aload 6
    //   519: ldc_w 7010
    //   522: aload 5
    //   524: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   527: invokevirtual 883	java/lang/Integer:intValue	()I
    //   530: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   533: aload_0
    //   534: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   537: ldc_w 7012
    //   540: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   543: checkcast 45	java/lang/String
    //   546: astore 5
    //   548: aload 5
    //   550: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   553: ifne +19 -> 572
    //   556: aload 6
    //   558: ldc_w 7012
    //   561: aload 5
    //   563: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   566: invokevirtual 883	java/lang/Integer:intValue	()I
    //   569: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   572: aload_0
    //   573: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   576: ldc_w 7014
    //   579: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   582: checkcast 45	java/lang/String
    //   585: astore 5
    //   587: aload 5
    //   589: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   592: ifne +19 -> 611
    //   595: aload 6
    //   597: ldc_w 7014
    //   600: aload 5
    //   602: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   605: invokevirtual 883	java/lang/Integer:intValue	()I
    //   608: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   611: aload_0
    //   612: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   615: ldc_w 7016
    //   618: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   621: checkcast 45	java/lang/String
    //   624: astore 5
    //   626: aload 5
    //   628: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   631: ifne +19 -> 650
    //   634: aload 6
    //   636: ldc_w 7016
    //   639: aload 5
    //   641: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   644: invokevirtual 883	java/lang/Integer:intValue	()I
    //   647: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   650: aload_0
    //   651: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   654: ldc_w 869
    //   657: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   660: checkcast 45	java/lang/String
    //   663: astore 5
    //   665: aload 5
    //   667: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   670: ifne +116 -> 786
    //   673: aload_0
    //   674: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   677: ldc_w 871
    //   680: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   683: checkcast 45	java/lang/String
    //   686: astore 7
    //   688: aload_0
    //   689: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   692: ldc_w 875
    //   695: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   698: checkcast 45	java/lang/String
    //   701: astore 8
    //   703: aload_0
    //   704: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   707: ldc_w 877
    //   710: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   713: checkcast 45	java/lang/String
    //   716: astore 9
    //   718: new 7018	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData
    //   721: dup
    //   722: invokespecial 7019	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:<init>	()V
    //   725: astore 10
    //   727: aload 10
    //   729: aload 5
    //   731: putfield 7020	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   734: aload 10
    //   736: aload 7
    //   738: putfield 7021	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   741: aload 10
    //   743: ldc_w 554
    //   746: aload 8
    //   748: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   751: putfield 7022	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_b_of_type_Boolean	Z
    //   754: aload 10
    //   756: ldc_w 301
    //   759: aload 9
    //   761: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   764: putfield 7023	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_a_of_type_Boolean	Z
    //   767: aload 6
    //   769: ldc_w 7025
    //   772: iconst_1
    //   773: invokevirtual 778	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   776: aload 6
    //   778: ldc_w 7027
    //   781: aload 10
    //   783: invokevirtual 7031	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   786: aload 6
    //   788: ldc_w 7033
    //   791: aload_0
    //   792: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   795: ldc_w 7035
    //   798: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   801: checkcast 45	java/lang/String
    //   804: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   807: aload 6
    //   809: ldc_w 7037
    //   812: aload_0
    //   813: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   816: ldc_w 7039
    //   819: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   822: checkcast 45	java/lang/String
    //   825: invokestatic 121	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   828: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   831: ldc_w 301
    //   834: aload_0
    //   835: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   838: ldc_w 7041
    //   841: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   844: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   847: ifeq +1104 -> 1951
    //   850: iconst_1
    //   851: istore_1
    //   852: aload 6
    //   854: ldc_w 7043
    //   857: iload_1
    //   858: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   861: iload_1
    //   862: ifne +802 -> 1664
    //   865: aload_0
    //   866: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   869: ldc_w 6972
    //   872: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   875: checkcast 45	java/lang/String
    //   878: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   881: invokevirtual 883	java/lang/Integer:intValue	()I
    //   884: istore_2
    //   885: aload 6
    //   887: ldc_w 7045
    //   890: iload_2
    //   891: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   894: aload_0
    //   895: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   898: ldc_w 7047
    //   901: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   904: checkcast 45	java/lang/String
    //   907: invokestatic 286	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   910: invokevirtual 290	java/lang/Long:longValue	()J
    //   913: iconst_1
    //   914: invokestatic 7052	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyTimeUtils:a	(JZ)Ljava/lang/String;
    //   917: astore 5
    //   919: aload 6
    //   921: ldc_w 7054
    //   924: aload 5
    //   926: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: aload 6
    //   931: ldc_w 7056
    //   934: aload_0
    //   935: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   938: ldc_w 7058
    //   941: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   944: checkcast 45	java/lang/String
    //   947: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   950: aload 6
    //   952: ldc_w 7060
    //   955: aload_0
    //   956: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   959: ldc_w 7062
    //   962: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   965: checkcast 45	java/lang/String
    //   968: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   971: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   974: aload 6
    //   976: ldc_w 7064
    //   979: aload_0
    //   980: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   983: ldc_w 7066
    //   986: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   989: checkcast 45	java/lang/String
    //   992: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   995: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   998: aload 6
    //   1000: ldc_w 7068
    //   1003: aload_0
    //   1004: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1007: ldc_w 7070
    //   1010: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1013: checkcast 45	java/lang/String
    //   1016: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1019: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1022: aload_0
    //   1023: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1026: ldc_w 7072
    //   1029: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1032: ifeq +46 -> 1078
    //   1035: aload_0
    //   1036: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1039: ldc_w 7072
    //   1042: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1045: checkcast 196	java/lang/CharSequence
    //   1048: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1051: ifne +27 -> 1078
    //   1054: aload 6
    //   1056: ldc_w 7074
    //   1059: aload_0
    //   1060: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1063: ldc_w 7072
    //   1066: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1069: checkcast 45	java/lang/String
    //   1072: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1075: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1078: aload_0
    //   1079: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1082: ldc_w 6962
    //   1085: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1088: checkcast 45	java/lang/String
    //   1091: invokestatic 7079	com/tencent/biz/pubaccount/readinjoy/video/videourl/ThirdVideoManager:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/video/videourl/VideoUrlInfo;
    //   1094: astore 5
    //   1096: aload 5
    //   1098: ifnull +29 -> 1127
    //   1101: aload 6
    //   1103: ldc_w 7081
    //   1106: aload 5
    //   1108: getfield 7084	com/tencent/biz/pubaccount/readinjoy/video/videourl/VideoUrlInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1111: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1114: aload 6
    //   1116: ldc_w 7086
    //   1119: aload 5
    //   1121: getfield 7088	com/tencent/biz/pubaccount/readinjoy/video/videourl/VideoUrlInfo:b	J
    //   1124: invokevirtual 951	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1127: new 324	android/os/Bundle
    //   1130: dup
    //   1131: invokespecial 325	android/os/Bundle:<init>	()V
    //   1134: astore 5
    //   1136: aload 5
    //   1138: ldc_w 7090
    //   1141: aload_0
    //   1142: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1145: ldc_w 6962
    //   1148: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1151: checkcast 45	java/lang/String
    //   1154: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1157: aload 5
    //   1159: ldc_w 7092
    //   1162: aload_0
    //   1163: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1166: ldc_w 6962
    //   1169: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1172: checkcast 45	java/lang/String
    //   1175: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1178: aload 5
    //   1180: ldc_w 7094
    //   1183: aload_0
    //   1184: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1187: ldc_w 6950
    //   1190: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1193: checkcast 45	java/lang/String
    //   1196: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1199: invokevirtual 883	java/lang/Integer:intValue	()I
    //   1202: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1205: aload 5
    //   1207: ldc_w 7096
    //   1210: aload_0
    //   1211: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1214: ldc_w 6954
    //   1217: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1220: checkcast 45	java/lang/String
    //   1223: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1226: invokevirtual 883	java/lang/Integer:intValue	()I
    //   1229: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1232: aload 5
    //   1234: ldc_w 7098
    //   1237: aload_0
    //   1238: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1241: ldc_w 6958
    //   1244: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1247: checkcast 45	java/lang/String
    //   1250: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1253: invokevirtual 883	java/lang/Integer:intValue	()I
    //   1256: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1259: aload 5
    //   1261: ldc_w 7100
    //   1264: aload_0
    //   1265: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1268: ldc_w 6950
    //   1271: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1274: checkcast 45	java/lang/String
    //   1277: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1280: invokevirtual 883	java/lang/Integer:intValue	()I
    //   1283: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1286: aload_0
    //   1287: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1290: ldc_w 6972
    //   1293: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1296: checkcast 45	java/lang/String
    //   1299: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1302: invokevirtual 883	java/lang/Integer:intValue	()I
    //   1305: iconst_1
    //   1306: if_icmpne +831 -> 2137
    //   1309: aload 5
    //   1311: ldc_w 7102
    //   1314: aload_0
    //   1315: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1318: ldc_w 7058
    //   1321: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1324: checkcast 45	java/lang/String
    //   1327: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1330: aload 5
    //   1332: ldc_w 7104
    //   1335: aload_0
    //   1336: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1339: ldc_w 7062
    //   1342: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1345: checkcast 45	java/lang/String
    //   1348: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1351: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1354: aload 5
    //   1356: ldc_w 7106
    //   1359: aload_0
    //   1360: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1363: ldc_w 7058
    //   1366: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1369: checkcast 45	java/lang/String
    //   1372: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1375: aload 5
    //   1377: ldc_w 7108
    //   1380: aload_0
    //   1381: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1384: ldc_w 6972
    //   1387: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1390: checkcast 45	java/lang/String
    //   1393: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1396: invokevirtual 883	java/lang/Integer:intValue	()I
    //   1399: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1402: aload 5
    //   1404: ldc_w 7110
    //   1407: aload_0
    //   1408: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1411: ldc_w 6966
    //   1414: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1417: checkcast 45	java/lang/String
    //   1420: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1423: aload 5
    //   1425: ldc_w 7112
    //   1428: iconst_5
    //   1429: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1432: aload 5
    //   1434: ldc_w 7114
    //   1437: iconst_0
    //   1438: invokevirtual 778	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1441: aload 5
    //   1443: ldc_w 4325
    //   1446: aload_0
    //   1447: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1450: ldc_w 7008
    //   1453: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1456: checkcast 45	java/lang/String
    //   1459: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1462: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1465: aload 5
    //   1467: ldc_w 2078
    //   1470: aload_0
    //   1471: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1474: ldc_w 7004
    //   1477: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1480: checkcast 45	java/lang/String
    //   1483: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1486: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1489: aload 5
    //   1491: ldc_w 6976
    //   1494: aload_0
    //   1495: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1498: ldc_w 6962
    //   1501: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1504: checkcast 45	java/lang/String
    //   1507: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1510: aload 5
    //   1512: ldc_w 2036
    //   1515: aload_0
    //   1516: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1519: ldc_w 2036
    //   1522: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1525: checkcast 45	java/lang/String
    //   1528: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1531: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1534: aload 5
    //   1536: ldc_w 7116
    //   1539: aload_0
    //   1540: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1543: ldc_w 7047
    //   1546: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1549: checkcast 45	java/lang/String
    //   1552: invokestatic 286	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1555: invokevirtual 290	java/lang/Long:longValue	()J
    //   1558: invokestatic 7118	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyTimeUtils:b	(J)Ljava/lang/String;
    //   1561: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1564: aload 5
    //   1566: ldc_w 4329
    //   1569: aload_0
    //   1570: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1573: ldc_w 2036
    //   1576: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1579: checkcast 45	java/lang/String
    //   1582: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1585: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1588: aload 5
    //   1590: ldc_w 2050
    //   1593: sipush 140
    //   1596: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1599: aload 6
    //   1601: ldc_w 7120
    //   1604: aload 5
    //   1606: invokestatic 7125	com/tencent/mobileqq/structmsg/StructMsgFactory:a	(Landroid/os/Bundle;)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1609: checkcast 7127	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   1612: invokevirtual 7128	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getBytes	()[B
    //   1615: invokevirtual 7131	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1618: iload_2
    //   1619: bipush 6
    //   1621: if_icmpne +43 -> 1664
    //   1624: aload_0
    //   1625: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1628: ldc_w 7133
    //   1631: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1634: ifeq +30 -> 1664
    //   1637: aload 6
    //   1639: ldc_w 7135
    //   1642: aload_0
    //   1643: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1646: ldc_w 7133
    //   1649: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1652: checkcast 45	java/lang/String
    //   1655: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1658: invokestatic 7138	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   1661: invokevirtual 7031	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1664: aload 6
    //   1666: ldc_w 7140
    //   1669: iconst_5
    //   1670: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1673: ldc_w 301
    //   1676: aload_0
    //   1677: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1680: ldc_w 7142
    //   1683: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1686: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1689: istore 4
    //   1691: iload_1
    //   1692: iconst_1
    //   1693: if_icmpne +565 -> 2258
    //   1696: aload 6
    //   1698: ldc_w 6996
    //   1701: iconst_m1
    //   1702: invokevirtual 7143	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1705: invokestatic 7147	com/tencent/biz/pubaccount/readinjoy/config/handlers/MultiVideoConfigHandler:a	(I)Z
    //   1708: istore_3
    //   1709: iload_3
    //   1710: ifeq +613 -> 2323
    //   1713: new 146	android/content/Intent
    //   1716: dup
    //   1717: invokespecial 147	android/content/Intent:<init>	()V
    //   1720: astore 5
    //   1722: aload 5
    //   1724: aload 6
    //   1726: invokevirtual 1765	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1729: pop
    //   1730: aload_0
    //   1731: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1734: aload 5
    //   1736: invokestatic 7150	com/tencent/biz/pubaccount/readinjoy/video/multivideo/MultiVideoHelper:a	(Landroid/content/Context;Landroid/content/Intent;)V
    //   1739: iconst_1
    //   1740: ireturn
    //   1741: astore 5
    //   1743: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1746: ifeq -1425 -> 321
    //   1749: ldc 123
    //   1751: iconst_2
    //   1752: new 125	java/lang/StringBuilder
    //   1755: dup
    //   1756: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1759: ldc_w 7152
    //   1762: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1765: aload_0
    //   1766: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1769: ldc_w 6978
    //   1772: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1775: checkcast 45	java/lang/String
    //   1778: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: ldc_w 7154
    //   1784: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: aload_0
    //   1788: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1791: ldc_w 6986
    //   1794: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1797: checkcast 45	java/lang/String
    //   1800: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1803: ldc_w 7156
    //   1806: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1809: aload 5
    //   1811: invokevirtual 1036	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1814: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1817: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1820: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1823: goto -1502 -> 321
    //   1826: aload 6
    //   1828: ldc_w 6996
    //   1831: bipush 100
    //   1833: invokevirtual 963	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1836: goto -1429 -> 407
    //   1839: astore 5
    //   1841: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1844: ifeq -105 -> 1739
    //   1847: ldc 123
    //   1849: iconst_2
    //   1850: new 125	java/lang/StringBuilder
    //   1853: dup
    //   1854: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1857: ldc_w 7158
    //   1860: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1863: aload_0
    //   1864: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1867: ldc_w 7004
    //   1870: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1873: checkcast 45	java/lang/String
    //   1876: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1879: ldc_w 7160
    //   1882: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1885: aload_0
    //   1886: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1889: ldc_w 7004
    //   1892: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1895: checkcast 45	java/lang/String
    //   1898: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1904: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1907: iconst_1
    //   1908: ireturn
    //   1909: astore 5
    //   1911: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1914: ifeq -1264 -> 650
    //   1917: ldc 123
    //   1919: iconst_2
    //   1920: ldc_w 7162
    //   1923: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1926: goto -1276 -> 650
    //   1929: astore 5
    //   1931: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1934: ifeq -1103 -> 831
    //   1937: ldc 123
    //   1939: iconst_2
    //   1940: ldc_w 7164
    //   1943: aload 5
    //   1945: invokestatic 5466	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1948: goto -1117 -> 831
    //   1951: iconst_0
    //   1952: istore_1
    //   1953: goto -1101 -> 852
    //   1956: astore 5
    //   1958: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1961: ifeq +423 -> 2384
    //   1964: ldc 123
    //   1966: iconst_2
    //   1967: new 125	java/lang/StringBuilder
    //   1970: dup
    //   1971: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1974: ldc_w 7166
    //   1977: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: aload 5
    //   1982: invokevirtual 1036	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1985: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1988: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1991: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1994: goto +390 -> 2384
    //   1997: astore 5
    //   1999: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2002: ifeq -263 -> 1739
    //   2005: ldc 123
    //   2007: iconst_2
    //   2008: new 125	java/lang/StringBuilder
    //   2011: dup
    //   2012: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   2015: ldc_w 7168
    //   2018: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: aload_0
    //   2022: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2025: ldc_w 7070
    //   2028: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2031: checkcast 45	java/lang/String
    //   2034: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2037: ldc_w 7170
    //   2040: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2043: aload_0
    //   2044: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2047: ldc_w 7072
    //   2050: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2053: checkcast 45	java/lang/String
    //   2056: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2059: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2062: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2065: iconst_1
    //   2066: ireturn
    //   2067: astore 5
    //   2069: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2072: ifeq -333 -> 1739
    //   2075: ldc 123
    //   2077: iconst_2
    //   2078: new 125	java/lang/StringBuilder
    //   2081: dup
    //   2082: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   2085: ldc_w 7172
    //   2088: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: aload_0
    //   2092: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2095: ldc_w 6972
    //   2098: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2101: checkcast 45	java/lang/String
    //   2104: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: ldc_w 7174
    //   2110: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2113: aload_0
    //   2114: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2117: ldc_w 7047
    //   2120: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2123: checkcast 45	java/lang/String
    //   2126: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2132: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2135: iconst_1
    //   2136: ireturn
    //   2137: aload_0
    //   2138: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2141: ldc_w 7176
    //   2144: invokevirtual 235	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2147: ifeq +43 -> 2190
    //   2150: aload_0
    //   2151: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2154: ldc_w 7176
    //   2157: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2160: checkcast 196	java/lang/CharSequence
    //   2163: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2166: ifne +24 -> 2190
    //   2169: aload 5
    //   2171: ldc_w 7102
    //   2174: aload_0
    //   2175: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2178: ldc_w 7176
    //   2181: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2184: checkcast 45	java/lang/String
    //   2187: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2190: aload 5
    //   2192: ldc_w 7104
    //   2195: aload_0
    //   2196: getfield 109	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2199: ldc_w 7066
    //   2202: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2205: checkcast 45	java/lang/String
    //   2208: invokestatic 192	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   2211: invokevirtual 331	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2214: goto -839 -> 1375
    //   2217: astore 7
    //   2219: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2222: ifeq -658 -> 1564
    //   2225: ldc 123
    //   2227: iconst_2
    //   2228: new 125	java/lang/StringBuilder
    //   2231: dup
    //   2232: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   2235: ldc_w 7178
    //   2238: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: aload 7
    //   2243: invokevirtual 1036	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2246: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2252: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2255: goto -691 -> 1564
    //   2258: aload 6
    //   2260: ldc_w 6996
    //   2263: iconst_m1
    //   2264: invokevirtual 7143	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   2267: aload 6
    //   2269: ldc_w 6952
    //   2272: invokevirtual 7179	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2275: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2278: invokevirtual 883	java/lang/Integer:intValue	()I
    //   2281: aload 6
    //   2283: ldc_w 6956
    //   2286: invokevirtual 7179	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2289: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2292: invokevirtual 883	java/lang/Integer:intValue	()I
    //   2295: aload 6
    //   2297: ldc_w 6948
    //   2300: invokevirtual 7179	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2303: invokestatic 880	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2306: invokevirtual 883	java/lang/Integer:intValue	()I
    //   2309: invokestatic 7182	com/tencent/biz/pubaccount/readinjoy/config/handlers/MultiVideoConfigHandler:a	(IIII)Z
    //   2312: istore_3
    //   2313: goto -604 -> 1709
    //   2316: astore 5
    //   2318: iconst_0
    //   2319: istore_3
    //   2320: goto -611 -> 1709
    //   2323: new 146	android/content/Intent
    //   2326: dup
    //   2327: aload_0
    //   2328: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2331: ldc_w 7184
    //   2334: invokespecial 224	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2337: astore 5
    //   2339: iload 4
    //   2341: ifeq +31 -> 2372
    //   2344: aload 5
    //   2346: ldc_w 1307
    //   2349: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2352: pop
    //   2353: aload 5
    //   2355: aload 6
    //   2357: invokevirtual 1765	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   2360: pop
    //   2361: aload_0
    //   2362: getfield 102	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2365: aload 5
    //   2367: invokevirtual 228	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2370: iconst_1
    //   2371: ireturn
    //   2372: aload 5
    //   2374: ldc_w 1309
    //   2377: invokevirtual 1306	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2380: pop
    //   2381: goto -28 -> 2353
    //   2384: aconst_null
    //   2385: astore 5
    //   2387: goto -1468 -> 919
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2390	0	this	JumpAction
    //   851	1102	1	i1	int
    //   884	738	2	i2	int
    //   1708	612	3	bool1	boolean
    //   1689	651	4	bool2	boolean
    //   420	1315	5	localObject	Object
    //   1741	69	5	localException1	Exception
    //   1839	1	5	localException2	Exception
    //   1909	1	5	localException3	Exception
    //   1929	15	5	localException4	Exception
    //   1956	25	5	localException5	Exception
    //   1997	1	5	localException6	Exception
    //   2067	124	5	localException7	Exception
    //   2316	1	5	localException8	Exception
    //   2337	49	5	localIntent	Intent
    //   7	2349	6	localBundle	Bundle
    //   686	51	7	str1	String
    //   2217	25	7	localException9	Exception
    //   701	46	8	str2	String
    //   716	44	9	str3	String
    //   725	57	10	localAnchorData	com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData
    // Exception table:
    //   from	to	target	type
    //   219	275	1741	java/lang/Exception
    //   275	321	1741	java/lang/Exception
    //   446	494	1839	java/lang/Exception
    //   494	533	1909	java/lang/Exception
    //   533	572	1909	java/lang/Exception
    //   572	611	1909	java/lang/Exception
    //   611	650	1909	java/lang/Exception
    //   807	831	1929	java/lang/Exception
    //   894	919	1956	java/lang/Exception
    //   998	1078	1997	java/lang/Exception
    //   865	894	2067	java/lang/Exception
    //   919	998	2067	java/lang/Exception
    //   1078	1096	2067	java/lang/Exception
    //   1101	1127	2067	java/lang/Exception
    //   1127	1375	2067	java/lang/Exception
    //   1375	1534	2067	java/lang/Exception
    //   1564	1618	2067	java/lang/Exception
    //   1624	1664	2067	java/lang/Exception
    //   1958	1994	2067	java/lang/Exception
    //   1999	2065	2067	java/lang/Exception
    //   2137	2190	2067	java/lang/Exception
    //   2190	2214	2067	java/lang/Exception
    //   2219	2255	2067	java/lang/Exception
    //   1534	1564	2217	java/lang/Exception
    //   1696	1709	2316	java/lang/Exception
    //   2258	2313	2316	java/lang/Exception
  }
  
  public boolean x()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/cmshow/store/guestStateActivity");
    localActivityURIRequest.extra().putString("extra_guest_nick", str1);
    localActivityURIRequest.extra().putString("extra_guest_uin", str2);
    QRoute.startUri(localActivityURIRequest, null);
    return true;
  }
  
  public boolean y()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean z()
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
    AudioHelper.b("start_ConferenceFlyTicketActivity");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction
 * JD-Core Version:    0.7.0.1
 */