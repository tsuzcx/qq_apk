package com.tencent.mobileqq.utils;

import QQWalletPay.ReqCheckChangePwdAuth;
import akjx;
import akka;
import akkb;
import akkc;
import akkd;
import akke;
import akkf;
import akkg;
import akkh;
import akki;
import akkj;
import akkk;
import akkl;
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
import android.os.Parcelable;
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
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.biz.pubaccount.util.ProfileParams.Builder;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryHomeJumpHelper;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.discover.view.StoryDiscoverActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceScanner;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.qwallet.PayCodeEntryActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARGlobalConfigManager;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.intervideo.now.NowProxy.ListNameData;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.NearbyTroops;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.utils.NearbyVideoChatManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vashealth.SportManager;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.ToastUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianWebViewFragment;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import com.tencent.util.URLUtil;
import com.tencent.util.VersionUtils;
import common.config.service.QzoneConfig;
import cooperation.comic.VipComicJumpActivity;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.util.QzoneAuthorizeConfig;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.troop.NearbyVideoChatProxyActivity;
import cooperation.troop.TroopMemberCardProxyActivity;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JumpAction
{
  public static int a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.mobileqq" };
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  private akkk jdField_a_of_type_Akkk = new akkk(this, this);
  private akkl jdField_a_of_type_Akkl;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public final Context a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public ChatActivityUtils.StartVideoListener a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QWalletAuthObserver jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  public QidianBusinessObserver a;
  public String a;
  private final HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  public boolean a;
  public String b;
  private boolean b;
  public String c;
  private boolean c;
  public String d;
  private boolean d;
  public String e;
  private boolean e;
  public String f;
  public String g;
  public String h;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q = "";
  private String r = "";
  private String s = "";
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public JumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new akkg(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener = new akkj(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private boolean A()
  {
    int i2 = 0;
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131434859, 1).a();
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
        label106:
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
      break label106;
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
  
  private boolean B()
  {
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131434859, 1).a();
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
  
  private boolean C()
  {
    boolean bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("token");
    if (!TextUtils.isEmpty(str)) {
      StoryShareEncryptHelper.a(this.jdField_a_of_type_AndroidContentContext, str, new akkd(this), null);
    }
    for (;;)
    {
      return true;
      if (bool)
      {
        this.jdField_c_of_type_JavaLangString = "open";
        StoryShareEncryptHelper.a(this.jdField_a_of_type_JavaUtilHashMap);
      }
      D();
    }
  }
  
  private boolean D()
  {
    if ((((MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).jdField_a_of_type_Boolean) && (!"open".equals(this.jdField_c_of_type_JavaLangString)) && (!"openTag".equals(this.jdField_c_of_type_JavaLangString)) && (!"openSquare".equals(this.jdField_c_of_type_JavaLangString))) {
      return be();
    }
    if ("0".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page"))) {
      return bh();
    }
    if ("open".equals(this.jdField_c_of_type_JavaLangString)) {
      return bh();
    }
    return be();
  }
  
  private boolean E()
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      String str = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("tim_convert_teamwork_pre_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getString("tim_myfile_teamwork_list_url", "https://docs.qq.com/desktop/m/index.html?_from=1");
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent.putExtra("url", str));
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private boolean F()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
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
  
  private boolean G()
  {
    long l4 = System.currentTimeMillis();
    boolean bool2 = ARDeviceController.a().a();
    ARGlobalConfigManager localARGlobalConfigManager = (ARGlobalConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219);
    Object localObject1;
    if (localARGlobalConfigManager != null)
    {
      localObject1 = localARGlobalConfigManager.a();
      QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is config info is " + localObject1);
      if (!localARGlobalConfigManager.b()) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      String str1;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      }
      label135:
      Intent localIntent;
      Object localObject4;
      label519:
      label591:
      label625:
      Bundle localBundle;
      long l2;
      long l1;
      for (;;)
      {
        Object localObject2;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("args"))
        {
          localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("args");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("disablecloud")) {
            break label519;
          }
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("disablecloud");
        }
        try
        {
          for (;;)
          {
            i1 = Integer.parseInt((String)localObject2);
            int i2 = i1;
            if (i1 != 1)
            {
              i2 = i1;
              if (i1 != 0) {
                i2 = 1;
              }
            }
            QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is " + bool2 + ",effectinfo is " + bool1 + ",from url is " + str1 + ",args is" + (String)localObject1 + ",cloudSwitch is " + i2);
            if ((!bool2) || (!bool1)) {
              break label1313;
            }
            localIntent = new Intent();
            localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ScannerActivity.class);
            localIntent.putExtra("from", "web-ar");
            localIntent.addFlags(67108864);
            localIntent.addFlags(268435456);
            localIntent.addFlags(65536);
            localIntent.addFlags(536870912);
            localIntent.putExtra("click_time", System.currentTimeMillis());
            localIntent.putExtra("web_url_switch", i2);
            localIntent.putExtra("jump_from_web", true);
            if (!QLog.isDevelopLevel()) {
              break label625;
            }
            localObject2 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
            for (localObject1 = "";; localObject1 = (String)localObject1 + (String)((Map.Entry)localObject4).getKey() + "[" + ((String)((Map.Entry)localObject4).getValue()).substring(0, 20) + "]\n")
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label591;
              }
              localObject4 = (Map.Entry)((Iterator)localObject2).next();
              if ((((Map.Entry)localObject4).getValue() == null) || (((String)((Map.Entry)localObject4).getValue()).length() <= 20)) {
                break;
              }
            }
            str1 = "";
            break;
            localObject1 = "";
            break label135;
            localObject2 = "0";
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int i1 = 0;
            continue;
            localObject1 = (String)localObject1 + (String)((Map.Entry)localObject4).getKey() + "[" + (String)((Map.Entry)localObject4).getValue() + "]\n";
          }
          QLog.w("JumpAction", 1, "gotoScannerActivity, \n" + (String)localObject1 + "]");
          localBundle = new Bundle();
          localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionType");
          l2 = 0L;
          l1 = l2;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        }
      }
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
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("H5Source"))
          {
            localObject1 = "";
            localBundle.putLong("ar_promotion_type", l1);
            localBundle.putLong("ar_recoglize_mask", l2);
            localBundle.putString("H5Source", (String)localObject1);
            if (l1 != 2L) {
              break label951;
            }
            localIntent.putExtra("ARRelationShipPromotion", localBundle);
            AudioHelper.a("JumpAction", localBundle);
            if (localARGlobalConfigManager != null)
            {
              if ((localARGlobalConfigManager.a() != null) && (!TextUtils.isEmpty(localARGlobalConfigManager.a().jdField_e_of_type_JavaLangString))) {
                break label1293;
              }
              localIntent.putExtra("icon_text", "QQ-AR");
              label824:
              if ((localARGlobalConfigManager.a() != null) && (localARGlobalConfigManager.a().jdField_c_of_type_JavaLangString != null)) {
                localIntent.putExtra("icon_url", localARGlobalConfigManager.a().jdField_c_of_type_JavaLangString);
              }
            }
            this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "0", str1, "", "");
          }
          for (;;)
          {
            QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity cost time is " + (System.currentTimeMillis() - l4));
            return true;
            localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("H5Source");
            break;
            label951:
            label969:
            label1005:
            label1022:
            String str2;
            label1039:
            String str3;
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("PromotionID"))
            {
              localObject1 = "-2";
              if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equalsIgnoreCase("-2"))) {
                break label1201;
              }
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("PromotionWords")) {
                break label1203;
              }
              localObject3 = "";
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("PromotionIconUrl")) {
                break label1221;
              }
              localObject4 = "";
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("PromotionUserFrom")) {
                break label1239;
              }
              str2 = "";
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("PromotionUserTo")) {
                break label1257;
              }
              str3 = "";
              label1056:
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("PromotionUserShareId")) {
                break label1275;
              }
            }
            label1201:
            label1203:
            label1221:
            label1239:
            label1257:
            label1275:
            for (String str4 = "";; str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionUserShareId"))
            {
              localBundle.putLong("ar_promotion_type", 1L);
              localBundle.putString("PromotionID", (String)localObject1);
              localBundle.putString("PromotionWords", (String)localObject3);
              localBundle.putString("PromotionIconUrl", (String)localObject4);
              localBundle.putString("PromotionUserFrom", str2);
              localBundle.putString("PromotionUserTo", str3);
              localBundle.putString("PromotionUserShareId", str4);
              QLog.i("JumpAction", 1, String.format("ARRelationShipPromotion PromotionID=%s PromotionWords=%s PromotionIconUrl=%s RecoglizeMask =%s", new Object[] { localObject1, localObject3, localObject4, Long.valueOf(l2) }));
              break;
              localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionID");
              break label969;
              break;
              localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionWords");
              break label1005;
              localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionIconUrl");
              break label1022;
              str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionUserFrom");
              break label1039;
              str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionUserTo");
              break label1056;
            }
            label1293:
            localIntent.putExtra("icon_text", localARGlobalConfigManager.a().jdField_e_of_type_JavaLangString);
            break label824;
            label1313:
            Object localObject3 = new StringBuilder("https://ti.qq.com/ar/help/error.html?_wv=3");
            ((StringBuilder)localObject3).append("&from=");
            ((StringBuilder)localObject3).append(str1);
            ((StringBuilder)localObject3).append("&args=");
            new StringBuffer();
            ((StringBuilder)localObject3).append(GrayTipsItemBuilder.a((String)localObject1));
            QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity QQBrowserActivity cost time is " + ((StringBuilder)localObject3).toString());
            localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
            ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject3).toString());
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "1", str1, "", "");
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
  
  private boolean H()
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
  
  private boolean I()
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
          break label759;
        }
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
          break label766;
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
              break label792;
            }
            str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time")) {
              break label799;
            }
            str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
              break label806;
            }
            str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_xingzuo")) {
              break label813;
            }
            str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_xingzuo");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_interest")) {
              break label820;
            }
            str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_interest");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
              break label827;
            }
            str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
              break label834;
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
                      label759:
                      str5 = "";
                      break label135;
                      label766:
                      str1 = "";
                      break label163;
                      localException1 = localException1;
                      localException1.printStackTrace();
                      int i1 = 0;
                      continue;
                      String str3 = "";
                      continue;
                      label792:
                      str4 = "";
                      continue;
                      label799:
                      str5 = "";
                      continue;
                      label806:
                      String str6 = "";
                      continue;
                      label813:
                      String str7 = "";
                      continue;
                      label820:
                      String str8 = "";
                      continue;
                      label827:
                      String str9 = "";
                      continue;
                      label834:
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
  
  private boolean J()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("groupCode"))
        {
          String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupCode");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("groupMemberUin")) {
            break label188;
          }
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupMemberUin");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("shielded")) {
            break label194;
          }
          localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shielded");
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            i1 = 0;
            localObject = new Intent();
            ((Intent)localObject).putExtra("troop_uin", str1);
            ((Intent)localObject).putExtra("member_uin", str3);
            ((Intent)localObject).putExtra("member_is_shield", i1);
            TroopMemberCardProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, "com.tencent.mobileqq.memcard.plugin.RecentSaidActivity", 0);
            return true;
          }
          int i1 = Integer.parseInt((String)localObject);
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
      continue;
      label188:
      String str3 = "";
      continue;
      label194:
      Object localObject = "";
    }
  }
  
  private boolean K()
  {
    HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, false);
    return true;
  }
  
  private boolean L()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hotnamecode")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hotnamecode"); TextUtils.isEmpty(str); str = "")
    {
      QQToast.a(BaseApplicationImpl.getContext(), "该热聊不存在，换个热聊试试吧。", 1).a();
      return false;
    }
    NearbyTransitActivity.a(this.jdField_a_of_type_AndroidContentContext, str, 1, this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  /* Error */
  private boolean M()
  {
    // Byte code:
    //   0: invokestatic 569	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +19 -> 22
    //   6: ldc_w 328
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 702
    //   18: aastore
    //   19: invokestatic 605	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   26: ldc_w 704
    //   29: invokevirtual 366	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +224 -> 256
    //   35: aload_0
    //   36: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   39: ldc_w 704
    //   42: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 45	java/lang/String
    //   48: invokestatic 707	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   51: istore_2
    //   52: aload_0
    //   53: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   56: ldc_w 309
    //   59: invokevirtual 366	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   62: ifeq +189 -> 251
    //   65: aload_0
    //   66: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   69: ldc_w 309
    //   72: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast 45	java/lang/String
    //   78: invokestatic 133	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   81: istore_1
    //   82: new 153	android/content/Intent
    //   85: dup
    //   86: aload_0
    //   87: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   90: ldc_w 291
    //   93: invokespecial 158	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   96: astore_3
    //   97: aload_3
    //   98: ldc_w 307
    //   101: iconst_1
    //   102: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   105: pop
    //   106: aload_3
    //   107: ldc_w 302
    //   110: getstatic 305	com/tencent/mobileqq/activity/MainFragment:jdField_a_of_type_Int	I
    //   113: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   116: pop
    //   117: aload_3
    //   118: ldc_w 296
    //   121: invokevirtual 300	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   124: pop
    //   125: aload_0
    //   126: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   129: ldc_w 309
    //   132: invokevirtual 366	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   135: ifeq +12 -> 147
    //   138: aload_3
    //   139: ldc_w 309
    //   142: iload_1
    //   143: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   146: pop
    //   147: aload_0
    //   148: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   151: ldc_w 704
    //   154: invokevirtual 366	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   157: ifeq +12 -> 169
    //   160: aload_3
    //   161: ldc_w 704
    //   164: iload_2
    //   165: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   168: pop
    //   169: aload_0
    //   170: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   173: instanceof 291
    //   176: ifeq +41 -> 217
    //   179: aload_0
    //   180: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   183: checkcast 291	com/tencent/mobileqq/activity/SplashActivity
    //   186: astore 4
    //   188: aload_3
    //   189: ldc_w 709
    //   192: iconst_1
    //   193: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   196: pop
    //   197: aload 4
    //   199: aload_3
    //   200: invokevirtual 711	com/tencent/mobileqq/activity/SplashActivity:b	(Landroid/content/Intent;)V
    //   203: iconst_1
    //   204: ireturn
    //   205: astore_3
    //   206: iconst_0
    //   207: istore_2
    //   208: aload_3
    //   209: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   212: iconst_0
    //   213: istore_1
    //   214: goto -132 -> 82
    //   217: aload_0
    //   218: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   221: aload_3
    //   222: invokevirtual 173	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   225: aload_0
    //   226: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   229: instanceof 649
    //   232: ifeq -29 -> 203
    //   235: aload_0
    //   236: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   239: checkcast 649	android/app/Activity
    //   242: invokevirtual 714	android/app/Activity:finish	()V
    //   245: iconst_1
    //   246: ireturn
    //   247: astore_3
    //   248: goto -40 -> 208
    //   251: iconst_0
    //   252: istore_1
    //   253: goto -171 -> 82
    //   256: iconst_0
    //   257: istore_2
    //   258: goto -206 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	JumpAction
    //   81	172	1	i1	int
    //   51	207	2	bool	boolean
    //   96	104	3	localIntent	Intent
    //   205	17	3	localException1	Exception
    //   247	1	3	localException2	Exception
    //   186	12	4	localSplashActivity	SplashActivity
    // Exception table:
    //   from	to	target	type
    //   22	52	205	java/lang/Exception
    //   52	82	247	java/lang/Exception
  }
  
  private boolean N()
  {
    return true;
  }
  
  private boolean O()
  {
    return true;
  }
  
  private boolean P()
  {
    return true;
  }
  
  private boolean Q()
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
      if (!TextUtils.isEmpty(a("msg_uniseq"))) {
        l1 = Long.valueOf(a("msg_uniseq")).longValue();
      }
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, "chatimg", l1);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoSetAvator path:" + str + "msg uniseq:" + l1);
      }
      int i1 = Math.min(482, ProfileCardUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext));
      localIntent1.putExtra("Business_Origin", 100);
      localIntent1.putExtra("open_chatfragment", true);
      localIntent1.putExtra("open_chat_from_avator", true);
      PhotoUtils.a(localIntent1, (Activity)this.jdField_a_of_type_AndroidContentContext, SplashActivity.class.getName(), i1, i1, 640, 640, str, ProfileCardUtil.a());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800723E", "0X800723E", 0, 0, "", "", "", "");
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("JumpAction", 1, "NumberFormatException uniseq:" + a("msg_uniseq"));
        l1 = l2;
      }
    }
  }
  
  private boolean R()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, RecommendFriendActivity.class);
    localIntent.putExtra("EntranceId", 7);
    localIntent.putExtra("from_babyq", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007243", "0X8007243", 0, 0, "", "", "", "");
    return true;
  }
  
  private boolean S()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ContactBindedActivity.class);
    localIntent.putExtra("from_babyq", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean T()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"); !str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()); str = "")
    {
      c();
      return false;
    }
    d();
    return false;
  }
  
  private boolean U()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("leftBackText", "消息");
    ((Bundle)localObject).putBoolean("isBack2Root", true);
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.putExtras((Bundle)localObject);
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("txt");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      localIntent.putExtra("JumpAction.Text", d((String)localObject));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean V()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    QWalletHelper.launchQWalletAct((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    return true;
  }
  
  private boolean W()
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
      localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
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
  
  private boolean X()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str5 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("panel");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");
    if ((str4 != null) && (QLog.isDevelopLevel())) {
      QLog.d("JumpAction", 4, str4 + "");
    }
    localObject1 = null;
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    }
    boolean bool1;
    int i1;
    if ("c2c".equals(str6))
    {
      if ((str2 == null) || (str2.length() < 5))
      {
        bool1 = false;
        return bool1;
      }
      if (((FriendsManager)localObject1).b(str2))
      {
        localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
        if ("chat".equals(str1))
        {
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
          ((Intent)localObject1).putExtra("uin", str2);
          ((Intent)localObject1).putExtra("uintype", 0);
          if (localObject2 != null) {
            ((Intent)localObject1).putExtra("uinname", (String)localObject2);
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
    else if ("discuss".equals(str6))
    {
      if ((str2 == null) || (str2.length() < 6)) {
        return false;
      }
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("discuss_info");
      i1 = 3000;
      str1 = null;
      localObject1 = null;
    }
    for (;;)
    {
      localObject3 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
      ((Intent)localObject3).putExtra("uin", str2);
      ((Intent)localObject3).putExtra("uintype", i1);
      if (localObject2 != null) {
        ((Intent)localObject3).putExtra("uinname", (String)localObject2);
      }
      if (str5 != null) {
        ((Intent)localObject3).putExtra("input_text", str5);
      }
      if ((localObject1 != null) && (localObject1.length > 0)) {
        ((Intent)localObject3).putExtra(str1, (byte[])localObject1);
      }
      if ((str4 != null) && (!"".equals(str4))) {
        if ((str2 == null) || ("".equals(str2)))
        {
          return false;
          if ("group".equals(str6))
          {
            if ((str2 == null) || (str2.length() < 6)) {
              return false;
            }
            localObject1 = ((TroopManager)localObject2).a(str2);
            if (localObject1 != null)
            {
              localObject2 = ((TroopInfo)localObject1).getTroopName();
              i1 = 1;
              str1 = null;
              localObject1 = null;
              continue;
            }
            return false;
          }
          if ("robot".equals(str6))
          {
            if ((str2 == null) || ("".equals(str2))) {
              return false;
            }
            localObject2 = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            i1 = 1001;
            str1 = null;
            localObject1 = null;
            continue;
          }
          if ("wpa".equals(str6))
          {
            if ((str2 == null) || (str2.length() < 5) || (str2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              return false;
            }
            if (((FriendsManager)localObject1).b(str2)) {
              i1 = 0;
            }
            for (localObject1 = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);; localObject1 = null)
            {
              e(str2);
              localObject2 = localObject1;
              str1 = null;
              localObject1 = null;
              break;
              i1 = 1005;
            }
          }
          if ("crm".equals(str6))
          {
            boolean bool2 = ab();
            bool1 = bool2;
            if (!bool2) {
              bool1 = Y();
            }
            bool2 = bool1;
            if (!bool1) {
              bool2 = Z();
            }
            bool1 = bool2;
            if (bool2) {
              break;
            }
            return aa();
          }
          if (("lbs".equals(str6)) || ("date".equals(str6)))
          {
            if ((str2 == null) || (str2.length() < 5) || (str2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              return false;
            }
            if (((FriendsManager)localObject1).b(str2))
            {
              i1 = 0;
              localObject1 = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
              str1 = null;
            }
          }
        }
      }
      for (;;)
      {
        if ((str1 != null) && (localObject3 != null))
        {
          localObject3 = HexUtil.a((String)localObject3);
          localObject2 = localObject1;
          localObject1 = localObject3;
          break;
          if ("lbs".equals(str6))
          {
            i1 = 1001;
            localObject1 = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            str1 = "rich_accost_sig";
          }
          else
          {
            i1 = 1010;
            localObject1 = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            str1 = "rich_date_sig";
            continue;
            if ("public_account".equals(str6))
            {
              if ((str2 == null) || (str2.length() < 6)) {
                return false;
              }
              localObject1 = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
              PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", str2, "0X800589E", "0X800589E", 0, 0, str2, "", "", "", false);
              localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
              ((Intent)localObject2).putExtra("uin", str2);
              ((Intent)localObject2).putExtra("uintype", 1008);
              if (localObject1 != null) {
                ((Intent)localObject2).putExtra("uinname", (String)localObject1);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
              return true;
            }
            if ("qd_account".equals(str6))
            {
              if ((str2 == null) || (str2.length() < 6)) {
                return false;
              }
              localObject1 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
              ((Intent)localObject1).putExtra("uin", str2);
              ((Intent)localObject1).putExtra("uintype", 1008);
              localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("key");
              str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("kfuin");
              localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assign_type");
              str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assign_key");
              str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("ext");
              str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rkey");
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "QD_ACCOUNT_TYPE " + str1 + " " + (String)localObject3 + " " + str2 + " " + str3 + " " + str4);
              }
              if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str1))) {
                return false;
              }
              ((Intent)localObject1).putExtra("qd_wpa_key", (String)localObject2);
              ((Intent)localObject1).putExtra("qd_kfuin", str1);
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                ((Intent)localObject1).putExtra("assign_type", (String)localObject3);
              }
              if (!TextUtils.isEmpty(str2)) {
                ((Intent)localObject1).putExtra("assign_key", str2);
              }
              if (!TextUtils.isEmpty(str3)) {
                ((Intent)localObject1).putExtra("assign_ext", str3);
              }
              if (!TextUtils.isEmpty(str4)) {
                ((Intent)localObject1).putExtra("rkey", str4);
              }
              if (0 != 0) {
                ((Intent)localObject1).putExtra("uinname", null);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
              return true;
            }
            return false;
            localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type");
            localObject2 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("thirdAppDisplayName"));
            str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
            if ((localObject1 != null) && (!"".equals(localObject1))) {
              ((Intent)localObject3).putExtra("callback_type", (String)localObject1);
            }
            if ((localObject2 != null) && (!"".equals(localObject2))) {
              ((Intent)localObject3).putExtra("thirdAppDisplayName", (String)localObject2);
            }
            if ((str1 != null) && (!"".equals(str1))) {
              ((Intent)localObject3).putExtra("appid", str1);
            }
            a((Intent)localObject3, str4);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B4B", "0X8004B4B", 0, 0, "", "", "", "");
            if ("webview".equals(this.m))
            {
              ((Intent)localObject3).putExtra("from", this.m);
              if (jdField_a_of_type_Int > 3)
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, "对话框打开数已达到上限", 1).a();
                return true;
              }
              jdField_a_of_type_Int += 1;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B5A", "0X8004B5A", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              if (str3 != null) {
                ((Intent)localObject3).putExtra("panel", str3);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
              return true;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B58", "0X8004B58", 0, 0, "", "", "", "");
            }
          }
        }
      }
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
      continue;
      localObject1 = null;
      i1 = 0;
      str1 = null;
    }
  }
  
  private boolean Y()
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
          break label527;
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
            break label398;
          }
          if (str7.length() < 5) {
            break label568;
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
        localIntent.putExtra("sigt", HexUtil.a(str6));
      }
      if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(str7))
      {
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("uinname", ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str7));
        label378:
        localIntent.putExtra("uin", str7);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          label398:
          ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str4, localException1, str3, str2, (String)localObject, str5);
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
            label527:
            bool1 = true;
          }
        }
        localIntent.putExtra("uintype", 1025);
        localIntent.putExtra("from_wpa_for_crm", true);
        break label378;
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleQidianExtWPA wpaType != 2");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
      }
      break;
    }
    label568:
    return false;
  }
  
  private boolean Z()
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
          ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).b(str5, str2, str1, str3, str4, str6);
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
  
  private int a()
  {
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("env"))) {
      return Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("env")).intValue();
    }
    return 0;
  }
  
  public static int a(Map paramMap)
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
        break label60;
      }
      QLog.e("JumpAction", 2, "makeStoryContentPageIntent, NumberFormatException, shareFromStr:" + paramMap);
    }
    return 0;
    label60:
    return 0;
  }
  
  public static int a(Map paramMap, String paramString, int paramInt)
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
  
  private Intent a()
  {
    ((QQStoryActivityManager)SuperManager.a(18)).a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    return localIntent;
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
            ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str1, paramInt1, paramInt2);
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
    if ((paramIntent == null) || (TextUtils.isEmpty(this.p)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "wrapper Intent failed intent is null or redTouchInfo is Empty");
      }
      return;
    }
    paramIntent.putExtra("redTouch", this.p);
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
        break label239;
      }
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "params must be decrypted");
        }
        paramString = Base64Util.decode(new Cryptor().decrypt(HexUtil.a(paramString), "Hf7K(s*js12LiskW".getBytes()), 0);
        if (paramString == null) {
          break label293;
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
        label239:
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
      label293:
      paramString = null;
    }
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
  
  public static boolean a(Context paramContext, String paramString, Long paramLong)
  {
    paramContext = SharedPreUtils.n(paramContext);
    if (TextUtils.isEmpty(paramContext))
    {
      ArkAppCenter.b("JumpAction", "getArkShareConfig, keywordCfgJsonStr is empty");
      return false;
    }
    try
    {
      paramContext = new JSONObject(paramContext).optJSONArray("ark_ai_keyword_sdk_share_app_info");
      if (paramContext != null)
      {
        HashMap localHashMap = new HashMap();
        int i1 = 0;
        while (i1 < paramContext.length())
        {
          JSONObject localJSONObject = (JSONObject)paramContext.get(i1);
          localHashMap.put(localJSONObject.getString("appID"), localJSONObject.getString("appName"));
          i1 += 1;
        }
        if ((!localHashMap.containsKey(paramLong.toString())) || (!localHashMap.containsValue(paramString))) {
          break label191;
        }
        if ((!TextUtils.isEmpty(paramLong.toString())) && (((String)localHashMap.get(paramLong.toString())).equals(paramString))) {
          return true;
        }
      }
      else
      {
        ArkAppCenter.b("JumpAction", "getArkShareConfig,ark_ai_keyword_sdk_share_app_info is empty");
        return false;
      }
    }
    catch (JSONException paramContext)
    {
      ArkAppCenter.b("JumpAction", String.format("getArkShareConfig, parse json failed, err=%s", new Object[] { paramContext.getMessage() }));
      return false;
    }
    return false;
    label191:
    return false;
  }
  
  /* Error */
  private boolean a(Intent paramIntent, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ldc_w 1281
    //   7: invokevirtual 1284	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   10: ifne +14 -> 24
    //   13: aload_1
    //   14: ldc_w 1281
    //   17: invokestatic 344	java/lang/System:currentTimeMillis	()J
    //   20: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   23: pop
    //   24: ldc_w 994
    //   27: aload_0
    //   28: getfield 996	com/tencent/mobileqq/utils/JumpAction:m	Ljava/lang/String;
    //   31: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +466 -> 500
    //   37: iconst_1
    //   38: istore 8
    //   40: aload_1
    //   41: ldc_w 1286
    //   44: iload 8
    //   46: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   49: pop
    //   50: aload_0
    //   51: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   54: ifnull +345 -> 399
    //   57: aload_0
    //   58: getfield 1290	com/tencent/mobileqq/utils/JumpAction:jdField_d_of_type_Boolean	Z
    //   61: ifeq +338 -> 399
    //   64: aload_0
    //   65: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   68: getfield 1296	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   71: invokevirtual 1300	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   74: sipush 769
    //   77: if_icmpne +322 -> 399
    //   80: aload_0
    //   81: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   84: getfield 1303	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   87: invokevirtual 1300	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   90: istore 6
    //   92: aload_0
    //   93: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   96: ldc_w 1305
    //   99: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 45	java/lang/String
    //   105: invokestatic 133	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: istore 4
    //   110: aload_0
    //   111: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: invokevirtual 1308	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   117: ldc_w 1310
    //   120: iconst_0
    //   121: invokevirtual 1313	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   124: astore 9
    //   126: aload 9
    //   128: new 254	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 1315
    //   138: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   148: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: iconst_0
    //   155: invokeinterface 1318 3 0
    //   160: istore 7
    //   162: aload 9
    //   164: invokeinterface 1322 1 0
    //   169: new 254	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 1315
    //   179: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   186: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   189: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: iconst_0
    //   196: invokeinterface 1328 3 0
    //   201: invokeinterface 1331 1 0
    //   206: pop
    //   207: aload_0
    //   208: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   211: getfield 1335	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   214: invokevirtual 1339	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   217: ifeq +309 -> 526
    //   220: new 1198	org/json/JSONObject
    //   223: dup
    //   224: aload_0
    //   225: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   228: getfield 1335	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   231: invokevirtual 1341	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   234: invokespecial 1202	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   237: astore 9
    //   239: aload_0
    //   240: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   243: getfield 1345	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   246: invokevirtual 1348	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   249: ifeq +277 -> 526
    //   252: aload_0
    //   253: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   256: getfield 1345	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   259: invokevirtual 1350	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   262: ifne +264 -> 526
    //   265: ldc 244
    //   267: aload 9
    //   269: ldc_w 1352
    //   272: invokevirtual 1356	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   275: aload_0
    //   276: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   279: getfield 1345	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   282: iconst_0
    //   283: invokevirtual 1357	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   286: checkcast 45	java/lang/String
    //   289: invokevirtual 1356	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   292: ldc_w 1359
    //   295: invokevirtual 1209	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   298: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: istore 8
    //   303: iload 8
    //   305: ifeq +221 -> 526
    //   308: aload_1
    //   309: ldc_w 1361
    //   312: iload 5
    //   314: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   317: pop
    //   318: aload_1
    //   319: ldc_w 1363
    //   322: iload 6
    //   324: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   327: pop
    //   328: aload_1
    //   329: ldc_w 1365
    //   332: iload 7
    //   334: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   337: pop
    //   338: aload_1
    //   339: ldc_w 1367
    //   342: iload 4
    //   344: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   347: pop
    //   348: aload_0
    //   349: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   352: getfield 1345	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   355: invokevirtual 1348	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   358: ifeq +41 -> 399
    //   361: aload_0
    //   362: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   365: getfield 1345	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   368: invokevirtual 1350	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   371: ifne +28 -> 399
    //   374: aload_1
    //   375: ldc_w 1369
    //   378: new 1371	java/util/ArrayList
    //   381: dup
    //   382: aload_0
    //   383: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   386: getfield 1345	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   389: invokevirtual 1374	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   392: invokespecial 1377	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   395: invokevirtual 1381	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   398: pop
    //   399: aload_1
    //   400: ldc_w 1383
    //   403: aload_0
    //   404: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   407: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   410: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   413: pop
    //   414: aload_1
    //   415: ldc_w 1385
    //   418: iconst_1
    //   419: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   422: pop
    //   423: aload_1
    //   424: ldc_w 1387
    //   427: iconst_1
    //   428: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   431: pop
    //   432: aload_1
    //   433: ldc_w 1389
    //   436: aload_0
    //   437: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   440: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   443: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   446: pop
    //   447: aload_1
    //   448: ldc_w 1391
    //   451: ldc_w 1393
    //   454: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   457: pop
    //   458: aload_0
    //   459: aload_1
    //   460: invokespecial 1395	com/tencent/mobileqq/utils/JumpAction:a	(Landroid/content/Intent;)V
    //   463: aload_1
    //   464: aload_0
    //   465: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   468: aload_2
    //   469: invokevirtual 1398	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   472: pop
    //   473: aload_0
    //   474: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   477: aload_1
    //   478: invokevirtual 173	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   481: ldc_w 1400
    //   484: aload_3
    //   485: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   488: ifne +44 -> 532
    //   491: aload_0
    //   492: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   495: invokestatic 1404	cooperation/qwallet/plugin/QWalletHelper:preloadQWallet	(Lcom/tencent/common/app/AppInterface;)V
    //   498: iconst_1
    //   499: ireturn
    //   500: iconst_0
    //   501: istore 8
    //   503: goto -463 -> 40
    //   506: astore 9
    //   508: aload 9
    //   510: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   513: iconst_0
    //   514: istore 4
    //   516: goto -406 -> 110
    //   519: astore 9
    //   521: aload 9
    //   523: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   526: iconst_1
    //   527: istore 5
    //   529: goto -221 -> 308
    //   532: new 1406	akjz
    //   535: dup
    //   536: aload_0
    //   537: invokespecial 1407	akjz:<init>	(Lcom/tencent/mobileqq/utils/JumpAction;)V
    //   540: iconst_5
    //   541: aconst_null
    //   542: iconst_1
    //   543: invokestatic 1413	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   546: iconst_1
    //   547: ireturn
    //   548: astore_1
    //   549: iconst_1
    //   550: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	551	0	this	JumpAction
    //   0	551	1	paramIntent	Intent
    //   0	551	2	paramString1	String
    //   0	551	3	paramString2	String
    //   108	407	4	i1	int
    //   1	527	5	i2	int
    //   90	233	6	i3	int
    //   160	173	7	i4	int
    //   38	464	8	bool	boolean
    //   124	144	9	localObject	Object
    //   506	3	9	localException1	Exception
    //   519	3	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   92	110	506	java/lang/Exception
    //   220	303	519	java/lang/Exception
    //   473	498	548	java/lang/Exception
    //   532	546	548	java/lang/Exception
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap paramHashMap)
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap paramHashMap, String paramString)
  {
    String str4 = (String)paramHashMap.get("videoOwnerUin");
    String str5 = (String)paramHashMap.get("unionid");
    String str3 = (String)paramHashMap.get("fromId");
    String str2 = (String)paramHashMap.get("videoId");
    String str1 = (String)paramHashMap.get("type");
    str1 = (String)paramHashMap.get("videoList");
    int i4 = a(paramHashMap);
    String str6 = (String)paramHashMap.get("feedid");
    int i3 = a(paramHashMap, "ptype", 0);
    int i1;
    int i2;
    if ("0".equals(paramHashMap.get("identify")))
    {
      i1 = 0;
      str1 = str2;
      if (str2 == null) {
        str1 = (String)paramHashMap.get("videoid");
      }
      str2 = str3;
      if (str3 == null) {
        str2 = (String)paramHashMap.get("fromid");
      }
      i2 = i3;
      if (!TextUtils.isEmpty(paramString))
      {
        i2 = i3;
        if (i3 == 0) {
          i2 = 7;
        }
      }
      switch (i2)
      {
      default: 
        if (!TextUtils.isEmpty(str5)) {
          StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, str5, 5, i4, str6, i1);
        }
        break;
      }
    }
    for (;;)
    {
      return true;
      i1 = 1;
      break;
      if ("17".equals(str2)) {
        StoryReportor.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", str1 });
      }
      if (!TextUtils.isEmpty(str5)) {
        StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, str5, 5, i4, str6, i1);
      }
      for (;;)
      {
        return true;
        if (TextUtils.isEmpty(str4)) {
          break;
        }
        StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, Long.parseLong(str4), 5, i4, str6, i1);
      }
      return false;
      if ("17".equals(str2)) {
        StoryReportor.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", str1 });
      }
      paramQQAppInterface = (String)paramHashMap.get("et");
      paramHashMap = (String)paramHashMap.get("time_zone");
      i2 = -1;
      if (!TextUtils.isEmpty(paramHashMap)) {
        i2 = Integer.valueOf(paramHashMap).intValue();
      }
      if (!TextUtils.isEmpty(str5)) {
        StoryPlayVideoActivity.a(paramActivity, str5, paramQQAppInterface, "我的一天", i2, i4, str6, i1);
      }
      for (;;)
      {
        return true;
        if (TextUtils.isEmpty(str4)) {
          break;
        }
        StoryPlayVideoActivity.a(paramActivity, Long.parseLong(str4), paramQQAppInterface, "我的一天", i2, i4, str6, i1);
      }
      return false;
      if (!TextUtils.isEmpty(str5)) {
        StoryPlayVideoActivity.a(paramActivity, str5, str1, i4, str6, i1);
      }
      for (;;)
      {
        return true;
        if (TextUtils.isEmpty(str4)) {
          break;
        }
        StoryPlayVideoActivity.a(paramActivity, Long.parseLong(str4), str1, i4, str6, i1);
      }
      return false;
      paramQQAppInterface = (String)paramHashMap.get("collection_id");
      paramHashMap = (String)paramHashMap.get("time_zone");
      i2 = -1;
      if (!TextUtils.isEmpty(paramHashMap)) {
        i2 = Integer.valueOf(paramHashMap).intValue();
      }
      if (!TextUtils.isEmpty(str5)) {
        StoryPlayVideoActivity.a(paramActivity, str5, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str5), i2, i4, str6, i1);
      }
      for (;;)
      {
        return true;
        if (TextUtils.isEmpty(str4)) {
          break;
        }
        paramQQAppInterface = VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str4);
        StoryPlayVideoActivity.a(paramActivity, Long.parseLong(str4), paramQQAppInterface, i2, i4, str6, i1);
      }
      return false;
      if (!TextUtils.isEmpty(str5)) {
        StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, str5, 12, i4, str6, i1);
      }
      for (;;)
      {
        return true;
        if (TextUtils.isEmpty(str4)) {
          break;
        }
        StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, Long.parseLong(str4), 12, i4, str6, i1);
      }
      return false;
      if (!TextUtils.isEmpty(str5)) {
        StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, str5, i4, str6, i1);
      }
      for (;;)
      {
        return true;
        if (TextUtils.isEmpty(str4)) {
          break;
        }
        StoryPlayVideoActivity.b(paramQQAppInterface, paramActivity, str1, Long.parseLong(str4), i4, str6, i1);
      }
      return false;
      StoryPlayVideoActivity.a(paramActivity, str5, str6, i1, i4);
      return true;
      StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, str5, i4, str6);
      return true;
      StoryPlayVideoActivity.a(paramActivity, str5, a(paramHashMap, "time_zone", -1), i4, str6);
      return true;
      paramQQAppInterface = (String)paramHashMap.get("bannerID");
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        StoryPlayVideoActivity.a(paramActivity, null, paramQQAppInterface);
      }
      return true;
      return b(paramQQAppInterface, paramActivity, paramHashMap, paramString);
      if (TextUtils.isEmpty(str4)) {
        break label923;
      }
      StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, Long.parseLong(str4), 5, i4, str6, i1);
    }
    label923:
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 13);
    localBundle.putString("viewParam", paramString1);
    if (paramString2 != null) {
      localBundle.putString("entry", paramString2);
    }
    paramString1 = new Intent(this.jdField_a_of_type_AndroidContentContext, PayCodeEntryActivity.class);
    paramString1.putExtra("srvBundle", localBundle);
    if (paramLong != 0L) {
      paramString1.putExtra("vacreport_key_seq", paramLong);
    }
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
    QWalletHelper.launchPayBridgeAct((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle, null, 0L);
    return true;
  }
  
  private boolean a(Map paramMap, boolean paramBoolean)
  {
    String str1 = (String)paramMap.get("userid");
    String str2 = (String)paramMap.get("usertype");
    String str3 = (String)paramMap.get("unionid");
    String str4 = (String)paramMap.get("storyid");
    String str5 = (String)paramMap.get("showinfocard");
    a(paramMap);
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
        else if (i1 == 5)
        {
          paramMap = (String)paramMap.get("topicname");
          StoryPlayVideoActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, Long.parseLong(str1), paramMap, null);
        }
      }
      catch (NumberFormatException paramMap)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, userId:" + str1 + ", userType:" + str2);
        }
        return false;
      }
    }
    else
    {
      return true;
    }
    return true;
  }
  
  private boolean aA()
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
        localUserInfo = QZoneHelper.UserInfo.a();
        localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localUserInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
        SessionInfo localSessionInfo = ((FragmentActivity)localObject).getChatFragment().a().a();
        if ((localSessionInfo != null) && (!TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString))) {
          ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).e(localSessionInfo.jdField_a_of_type_JavaLangString, true);
        }
        if (!str2.equalsIgnoreCase("11")) {
          break label166;
        }
        QZoneHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, str1, "mqqChat.QzoneCard", -1);
      }
    }
    for (;;)
    {
      return false;
      label166:
      if (str2.equalsIgnoreCase("12"))
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a().a();
        str2 = c(str1);
        if (TextUtils.isEmpty(str2)) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, "缺少相册id", 1).a();
        } else {
          QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, (String)localObject, str2, str1, "mqqChat.QzoneCard", -1);
        }
      }
    }
  }
  
  private boolean aB()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.common.activities.QzoneDialogActivity");
    localIntent.addFlags(805306368);
    QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localIntent, -1);
    return true;
  }
  
  private boolean aC()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (!QzoneAuthorizeConfig.a().b(this.n, this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("JumpAction", 1, "has no right to handle this schema");
        return false;
      }
      String str;
      if (this.jdField_a_of_type_JavaLangString.startsWith("mqqzone"))
      {
        str = "mqzone" + this.jdField_a_of_type_JavaLangString.substring("mqqzone".length());
        if (TextUtils.isEmpty(str)) {
          break label196;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("cmd", "Schema");
        localIntent.putExtra("schema", str);
        QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.a(), localIntent);
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
        label196:
        QLog.e("JumpAction", 1, "gotoQzoneHandleSchema,schema=null");
      }
    }
    return false;
  }
  
  private boolean aD()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    Object localObject9 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject5 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject7 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    d((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    Object localObject10 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str2 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    if (!TextUtils.isEmpty(this.n)) {}
    for (localObject1 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; localObject1 = null)
    {
      String str3 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
      String str5 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      String str4 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
      String str6 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
      String str8 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
      for (;;)
      {
        try
        {
          i1 = Integer.valueOf(d((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
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
              if (!TextUtils.isEmpty(this.n)) {
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
              ((Bundle)localObject8).putString("pkg_name", this.n);
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
                    ((Bundle)localObject8).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131431696), new Object[] { localObject1 }));
                  }
                }
                else
                {
                  com.tencent.mobileqq.app.PhoneContactManagerImp.g = true;
                  localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
                  ((Intent)localObject1).putExtra("toUin", AppConstants.J);
                  ((Intent)localObject1).putExtra("uinType", 0);
                  if (1 != i1) {
                    break label1705;
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
                  localObject6 = this.n;
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
              ((Bundle)localObject8).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131431697));
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
                  QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131431690, 1);
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
                  ((Bundle)localObject8).putString("title", ((ArrayList)localObject10).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131431652));
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
                    ((Bundle)localObject8).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131431696), new Object[] { localObject1 }));
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
                ((Bundle)localObject8).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131431697));
                continue;
              }
              QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131431690, 1);
              if (QLog.isColorLevel()) {
                QLog.e("qqfav", 2, "gotoQfavShareMsg|unknown reqType. reqType=" + i2);
              }
              return false;
            }
          }
        }
        label1705:
        ((Intent)localObject1).putExtra("qqfav_extra_from_sdk_share", true);
      }
    }
  }
  
  private boolean aE()
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
      str = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      localObject2 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      localObject3 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qzone_ext_str"));
      ((Bundle)localObject1).putString("open_id", str);
      ((Bundle)localObject1).putString("share_uin", (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((Bundle)localObject1).putString("share_ext_string", (String)localObject3);
      }
      i2 = Integer.valueOf(d((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"))).intValue();
      str = "";
      if (i2 != 3) {
        break label619;
      }
    }
    String str = "7";
    Object localObject2 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    Object localObject4 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    Object localObject3 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      localObject4 = ((String)localObject4).split(";");
      int i1 = 0;
      while (i1 < localObject4.length)
      {
        ((ArrayList)localObject3).add(URLDecoder.decode(localObject4[i1]));
        i1 += 1;
      }
    }
    ((Bundle)localObject1).putStringArrayList("images", (ArrayList)localObject3);
    ((Bundle)localObject1).putString("summary", (String)localObject2);
    for (;;)
    {
      ((Bundle)localObject1).putString("app_name", d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")));
      if (!TextUtils.isEmpty(this.n)) {
        ((Bundle)localObject1).putString("hulian_appid", String.valueOf(l1));
      }
      ((Bundle)localObject1).putInt("req_type", i2);
      ((Bundle)localObject1).putLong("req_share_id", l1);
      ((Bundle)localObject1).putString("pkg_name", this.n);
      ((Bundle)localObject1).putBoolean("key_need_save_draft", false);
      com.tencent.mobileqq.app.PhoneContactManagerImp.g = true;
      localObject2 = new akkh(this);
      QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, (DialogInterface.OnDismissListener)localObject2);
      localObject2 = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject2).jdField_c_of_type_JavaLangString = "1";
      ((QZoneClickReport.ReportInfo)localObject2).jdField_d_of_type_JavaLangString = "0";
      ((QZoneClickReport.ReportInfo)localObject2).b = 4;
      ((QZoneClickReport.ReportInfo)localObject2).k = "5";
      ((QZoneClickReport.ReportInfo)localObject2).l = "thirdApp";
      localObject3 = new HashMap();
      ((HashMap)localObject3).put("source_type", "5");
      ((HashMap)localObject3).put("source_from", "thirdApp");
      localObject1 = ((Bundle)localObject1).getStringArrayList("images");
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 9))
      {
        ((QZoneClickReport.ReportInfo)localObject2).m = "QZoneUploadPhotosActivity";
        ((HashMap)localObject3).put("source_to", "QZoneUploadPhotosActivity");
        QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject2);
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject3, null);
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", l1 + "", "11", "12", "0", str, "", "4", false);
        return true;
        label619:
        if (i2 != 4) {
          continue;
        }
        str = "8";
        localObject2 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoPath"));
      }
      try
      {
        ((Bundle)localObject1).putLong("file_send_duration", Long.valueOf(d((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoDuration"))).longValue());
        try
        {
          label679:
          ((Bundle)localObject1).putLong("PhotoConst.VIDEO_SIZE", Long.valueOf(d((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoSize"))).longValue());
          label710:
          localObject3 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
          ((Bundle)localObject1).putBoolean("PhotoConst.IS_VIDEO_SELECTED", true);
          ((Bundle)localObject1).putInt("PhotoConst.VIDEO_TYPE", 1);
          ((Bundle)localObject1).putString("file_send_path", (String)localObject2);
          ((Bundle)localObject1).putBoolean("need_process", false);
          ((Bundle)localObject1).putString("defaultText", (String)localObject3);
          continue;
          ((QZoneClickReport.ReportInfo)localObject2).m = "QZonePublishMoodActivity";
          ((HashMap)localObject3).put("source_to", "QZonePublishMoodActivity");
        }
        catch (Exception localException2)
        {
          break label710;
        }
      }
      catch (Exception localException3)
      {
        break label679;
      }
    }
  }
  
  private boolean aF()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    String str3 = QUA.a();
    QZoneShareManager.a(this.jdField_a_of_type_AndroidContentContext, str1, null, 0, str2, str3);
    return true;
  }
  
  private boolean aG()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_uin");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(str))
    {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extinfo");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (str = "mqzone://arouse/homepage?redpocket=1&uin=" + str;; str = "mqzone://arouse/homepage?redpocket=1&uin=" + str + "&extinfo=" + (String)localObject)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("cmd", "Schema");
        ((Intent)localObject).putExtra("schema", str);
        QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.a(), (Intent)localObject);
        return true;
      }
    }
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    if ((!TextUtils.isEmpty(str)) && (str.equals("login")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, "不是同一个帐号,不能抢红包", 1).a();
      return true;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, "帐号不一致，请重新登录后领取红包", 1).a();
    str = this.jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder().append(str);
    if (str.indexOf("?") > -1) {}
    for (str = "&";; str = "?")
    {
      str = str;
      str = str + "jfrom=login";
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, LoginActivity.class);
      ((Intent)localObject).putExtra("scheme_content", str);
      ((Intent)localObject).putExtra("pkg_name", "com.tencent.mobileqq");
      ((Intent)localObject).putExtras((Intent)localObject);
      ((Intent)localObject).setFlags(268435456);
      if (VersionUtils.e()) {
        ((Intent)localObject).addFlags(32768);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
    }
  }
  
  private boolean aH()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, "正式版本已关闭此功能啦！", 1).a();
    return false;
  }
  
  private boolean aI()
  {
    return true;
  }
  
  private boolean aJ()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localUserInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, -1);
      return true;
    }
    return false;
  }
  
  private boolean aK()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(str))
        {
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.a(), str, 0, 0, 0);
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
  
  private boolean aL()
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
  
  private boolean aM()
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
  
  private boolean aN()
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
          ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131436247));
          ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131435108));
          ((Intent)localObject).putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131436029));
          ((Intent)localObject).putExtra("param_entrance", 10);
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
        break label632;
      }
    }
    label632:
    for (boolean bool = false;; bool = true)
    {
      return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, true, bool, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, this.jdField_a_of_type_JavaUtilHashMap);
      return false;
    }
  }
  
  private boolean aO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoVideoChat");
    }
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    if ((localObject2 != null) && ("forward_to_tab".equals(localObject2)))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      ((Intent)localObject1).putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
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
            break label766;
          }
          bool1 = true;
          if (i1 == 1006)
          {
            localObject2 = localObject5;
            if (!((String)localObject5).startsWith("+")) {
              localObject2 = "+" + (String)localObject5;
            }
            localObject3 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c((String)localObject2);
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
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131429247);
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
          localObject2 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label744;
        }
        bool2 = true;
        localObject2 = localObject1;
        localObject4 = localObject5;
        continue;
        localObject4 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, str1, i2, 0);
        continue;
      }
      return false;
      label744:
      boolean bool2 = true;
      Object localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject5;
      continue;
      label766:
      boolean bool1 = false;
    }
  }
  
  private boolean aP()
  {
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoRandomVideoChat");
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str4 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("session_name"));
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
  
  private boolean aQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoGameGuildChat");
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    boolean bool;
    if ((str2 != null) && (str2.equals("audio"))) {
      bool = true;
    }
    try
    {
      for (;;)
      {
        i1 = Integer.parseInt(str3);
        str2 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("room_title"));
        this.jdField_a_of_type_JavaUtilHashMap.put("room_title", str2);
        if ((str1 == null) || (!str1.equals("web")) || (i1 < 1)) {
          break label256;
        }
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("is_quit");
        long l1 = -1L;
        try
        {
          long l2 = Long.parseLong((String)this.jdField_a_of_type_JavaUtilHashMap.get("group_id"));
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          label178:
          break label178;
        }
        if ((str1 == null) || (!str1.equals("1")) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c() == l1)) {
          break;
        }
        return true;
        bool = false;
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      for (;;)
      {
        int i1 = 0;
      }
    }
    return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1011, null, null, null, bool, null, false, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
    label256:
    return false;
  }
  
  private boolean aR()
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
  private boolean aS()
  {
    // Byte code:
    //   0: new 153	android/content/Intent
    //   3: dup
    //   4: ldc_w 2202
    //   7: invokespecial 2203	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   10: astore 14
    //   12: aload_0
    //   13: aload 14
    //   15: invokespecial 1395	com/tencent/mobileqq/utils/JumpAction:a	(Landroid/content/Intent;)V
    //   18: aconst_null
    //   19: astore 9
    //   21: aconst_null
    //   22: astore 8
    //   24: aconst_null
    //   25: astore 10
    //   27: aload_0
    //   28: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   31: invokevirtual 412	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   34: astore 12
    //   36: iconst_0
    //   37: istore_1
    //   38: ldc 56
    //   40: astore 11
    //   42: aload_0
    //   43: ldc_w 2205
    //   46: invokevirtual 738	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)Ljava/lang/String;
    //   49: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne +62 -> 114
    //   55: aload 14
    //   57: ldc_w 2207
    //   60: invokestatic 2210	java/lang/System:nanoTime	()J
    //   63: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   66: pop
    //   67: aload 14
    //   69: ldc_w 1281
    //   72: invokestatic 344	java/lang/System:currentTimeMillis	()J
    //   75: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   78: pop
    //   79: aload 14
    //   81: ldc_w 1237
    //   84: invokestatic 344	java/lang/System:currentTimeMillis	()J
    //   87: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   90: pop
    //   91: aload 14
    //   93: ldc_w 2212
    //   96: iconst_1
    //   97: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   100: pop
    //   101: aload 14
    //   103: ldc_w 2214
    //   106: aload_0
    //   107: getfield 1290	com/tencent/mobileqq/utils/JumpAction:jdField_d_of_type_Boolean	Z
    //   110: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   113: pop
    //   114: aload 12
    //   116: invokeinterface 418 1 0
    //   121: astore 15
    //   123: aload 15
    //   125: invokeinterface 423 1 0
    //   130: ifeq +631 -> 761
    //   133: aload 15
    //   135: invokeinterface 427 1 0
    //   140: checkcast 429	java/util/Map$Entry
    //   143: astore 12
    //   145: aload 12
    //   147: invokeinterface 439 1 0
    //   152: checkcast 45	java/lang/String
    //   155: astore 13
    //   157: aload 12
    //   159: invokeinterface 432 1 0
    //   164: checkcast 45	java/lang/String
    //   167: astore 12
    //   169: aload 13
    //   171: ifnull -48 -> 123
    //   174: aload 12
    //   176: ifnull -53 -> 123
    //   179: ldc_w 2216
    //   182: aload 13
    //   184: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifeq +26 -> 213
    //   190: aload 8
    //   192: astore 13
    //   194: aload 11
    //   196: astore 8
    //   198: aload 10
    //   200: astore 9
    //   202: aload 13
    //   204: astore 10
    //   206: aload 12
    //   208: astore 11
    //   210: goto +2646 -> 2856
    //   213: ldc_w 2218
    //   216: aload 13
    //   218: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifeq +22 -> 243
    //   224: aload 11
    //   226: astore 8
    //   228: aload 9
    //   230: astore 11
    //   232: aload 10
    //   234: astore 9
    //   236: aload 12
    //   238: astore 10
    //   240: goto +2616 -> 2856
    //   243: ldc_w 2220
    //   246: aload 13
    //   248: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifeq +57 -> 308
    //   254: ldc_w 563
    //   257: aload 12
    //   259: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   262: ifeq +2621 -> 2883
    //   265: aload 14
    //   267: ldc_w 2222
    //   270: aload_0
    //   271: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   274: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   277: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   280: pop
    //   281: aload 8
    //   283: astore 12
    //   285: aload 9
    //   287: astore 13
    //   289: aload 11
    //   291: astore 8
    //   293: aload 10
    //   295: astore 9
    //   297: aload 12
    //   299: astore 10
    //   301: aload 13
    //   303: astore 11
    //   305: goto +2551 -> 2856
    //   308: ldc_w 2224
    //   311: aload 13
    //   313: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   316: ifeq +89 -> 405
    //   319: ldc_w 563
    //   322: aload 12
    //   324: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   327: ifeq +2556 -> 2883
    //   330: aload_0
    //   331: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   334: invokevirtual 1590	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   337: astore 13
    //   339: aload 13
    //   341: astore 12
    //   343: aload 13
    //   345: invokestatic 2228	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   348: ifeq +19 -> 367
    //   351: aload_0
    //   352: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   355: aload_0
    //   356: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   359: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   362: invokestatic 2230	com/tencent/mobileqq/utils/ContactUtils:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   365: astore 12
    //   367: aload 14
    //   369: ldc_w 2232
    //   372: aload 12
    //   374: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   377: pop
    //   378: aload 8
    //   380: astore 12
    //   382: aload 9
    //   384: astore 13
    //   386: aload 11
    //   388: astore 8
    //   390: aload 10
    //   392: astore 9
    //   394: aload 12
    //   396: astore 10
    //   398: aload 13
    //   400: astore 11
    //   402: goto +2454 -> 2856
    //   405: ldc_w 2234
    //   408: aload 13
    //   410: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   413: ifeq +57 -> 470
    //   416: ldc_w 563
    //   419: aload 12
    //   421: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   424: ifeq +2459 -> 2883
    //   427: aload 14
    //   429: ldc_w 2236
    //   432: aload_0
    //   433: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   436: invokevirtual 2237	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   439: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   442: pop
    //   443: aload 8
    //   445: astore 12
    //   447: aload 9
    //   449: astore 13
    //   451: aload 11
    //   453: astore 8
    //   455: aload 10
    //   457: astore 9
    //   459: aload 12
    //   461: astore 10
    //   463: aload 13
    //   465: astore 11
    //   467: goto +2389 -> 2856
    //   470: ldc_w 2239
    //   473: aload 13
    //   475: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   478: ifeq +53 -> 531
    //   481: ldc_w 563
    //   484: aload 12
    //   486: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   489: ifeq +2394 -> 2883
    //   492: aload 14
    //   494: ldc_w 2241
    //   497: invokestatic 344	java/lang/System:currentTimeMillis	()J
    //   500: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   503: pop
    //   504: aload 8
    //   506: astore 12
    //   508: aload 9
    //   510: astore 13
    //   512: aload 11
    //   514: astore 8
    //   516: aload 10
    //   518: astore 9
    //   520: aload 12
    //   522: astore 10
    //   524: aload 13
    //   526: astore 11
    //   528: goto +2328 -> 2856
    //   531: ldc_w 2243
    //   534: aload 13
    //   536: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   539: ifeq +90 -> 629
    //   542: ldc_w 563
    //   545: aload 12
    //   547: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   550: ifeq +2333 -> 2883
    //   553: aload 14
    //   555: ldc_w 2245
    //   558: aload_0
    //   559: getfield 2247	com/tencent/mobileqq/utils/JumpAction:jdField_c_of_type_Boolean	Z
    //   562: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   565: pop
    //   566: invokestatic 569	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   569: ifeq +2314 -> 2883
    //   572: ldc_w 2249
    //   575: iconst_2
    //   576: new 254	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   583: ldc_w 2251
    //   586: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload_0
    //   590: getfield 2247	com/tencent/mobileqq/utils/JumpAction:jdField_c_of_type_Boolean	Z
    //   593: invokevirtual 375	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   596: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 573	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: aload 8
    //   604: astore 12
    //   606: aload 9
    //   608: astore 13
    //   610: aload 11
    //   612: astore 8
    //   614: aload 10
    //   616: astore 9
    //   618: aload 12
    //   620: astore 10
    //   622: aload 13
    //   624: astore 11
    //   626: goto +2230 -> 2856
    //   629: ldc_w 2253
    //   632: aload 13
    //   634: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   637: ifeq +39 -> 676
    //   640: ldc_w 563
    //   643: aload 12
    //   645: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   648: ifeq +2235 -> 2883
    //   651: iconst_1
    //   652: istore_1
    //   653: aload 8
    //   655: astore 12
    //   657: aload 11
    //   659: astore 8
    //   661: aload 9
    //   663: astore 11
    //   665: aload 10
    //   667: astore 9
    //   669: aload 12
    //   671: astore 10
    //   673: goto +2183 -> 2856
    //   676: ldc_w 2255
    //   679: aload 13
    //   681: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   684: ifeq +30 -> 714
    //   687: aload 8
    //   689: astore 11
    //   691: aload 9
    //   693: astore 13
    //   695: aload 12
    //   697: astore 8
    //   699: aload 10
    //   701: astore 9
    //   703: aload 11
    //   705: astore 10
    //   707: aload 13
    //   709: astore 11
    //   711: goto +2145 -> 2856
    //   714: ldc_w 611
    //   717: aload 13
    //   719: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   722: ifeq +26 -> 748
    //   725: aload 9
    //   727: astore 13
    //   729: aload 8
    //   731: astore 10
    //   733: aload 11
    //   735: astore 8
    //   737: aload 12
    //   739: astore 9
    //   741: aload 13
    //   743: astore 11
    //   745: goto +2111 -> 2856
    //   748: aload 14
    //   750: aload 13
    //   752: aload 12
    //   754: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   757: pop
    //   758: goto +2125 -> 2883
    //   761: aload 9
    //   763: ifnull +2147 -> 2910
    //   766: aload 8
    //   768: ifnull +2142 -> 2910
    //   771: ldc 56
    //   773: aload 9
    //   775: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   778: ifne +2132 -> 2910
    //   781: ldc 56
    //   783: aload 8
    //   785: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   788: ifeq +6 -> 794
    //   791: goto +2119 -> 2910
    //   794: aload_0
    //   795: getfield 2256	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_Boolean	Z
    //   798: ifeq +22 -> 820
    //   801: invokestatic 2261	com/tencent/mobileqq/utils/JumpFilterHelper:a	()Lcom/tencent/mobileqq/utils/JumpFilterHelper;
    //   804: aload_0
    //   805: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   808: aload 9
    //   810: aload 8
    //   812: invokevirtual 2264	com/tencent/mobileqq/utils/JumpFilterHelper:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   815: ifeq +5 -> 820
    //   818: iconst_0
    //   819: ireturn
    //   820: iconst_0
    //   821: istore 4
    //   823: iload 4
    //   825: istore_3
    //   826: aload 9
    //   828: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   831: ifne +38 -> 869
    //   834: getstatic 49	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   837: astore 12
    //   839: aload 12
    //   841: arraylength
    //   842: istore 5
    //   844: iconst_0
    //   845: istore_2
    //   846: iload 4
    //   848: istore_3
    //   849: iload_2
    //   850: iload 5
    //   852: if_icmpge +17 -> 869
    //   855: aload 9
    //   857: aload 12
    //   859: iload_2
    //   860: aaload
    //   861: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   864: ifeq +234 -> 1098
    //   867: iconst_1
    //   868: istore_3
    //   869: iload_3
    //   870: ifne +55 -> 925
    //   873: aload 14
    //   875: ldc_w 2236
    //   878: aconst_null
    //   879: checkcast 45	java/lang/String
    //   882: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   885: pop
    //   886: aload 14
    //   888: ldc_w 2266
    //   891: aconst_null
    //   892: checkcast 45	java/lang/String
    //   895: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   898: pop
    //   899: aload 14
    //   901: ldc_w 2232
    //   904: aconst_null
    //   905: checkcast 45	java/lang/String
    //   908: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   911: pop
    //   912: aload 14
    //   914: ldc_w 2222
    //   917: aconst_null
    //   918: checkcast 45	java/lang/String
    //   921: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   924: pop
    //   925: aload 8
    //   927: ldc_w 2268
    //   930: invokevirtual 1660	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   933: ifeq +112 -> 1045
    //   936: aload 14
    //   938: ldc_w 2270
    //   941: ldc_w 2272
    //   944: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   947: pop
    //   948: aload_0
    //   949: getfield 58	com/tencent/mobileqq/utils/JumpAction:q	Ljava/lang/String;
    //   952: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   955: ifne +16 -> 971
    //   958: aload 14
    //   960: ldc_w 2274
    //   963: aload_0
    //   964: getfield 58	com/tencent/mobileqq/utils/JumpAction:q	Ljava/lang/String;
    //   967: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   970: pop
    //   971: aload_0
    //   972: getfield 60	com/tencent/mobileqq/utils/JumpAction:r	Ljava/lang/String;
    //   975: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   978: ifne +16 -> 994
    //   981: aload 14
    //   983: ldc_w 2276
    //   986: aload_0
    //   987: getfield 60	com/tencent/mobileqq/utils/JumpAction:r	Ljava/lang/String;
    //   990: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   993: pop
    //   994: aload_0
    //   995: getfield 62	com/tencent/mobileqq/utils/JumpAction:s	Ljava/lang/String;
    //   998: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1001: ifne +16 -> 1017
    //   1004: aload 14
    //   1006: ldc_w 2278
    //   1009: aload_0
    //   1010: getfield 62	com/tencent/mobileqq/utils/JumpAction:s	Ljava/lang/String;
    //   1013: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1016: pop
    //   1017: aload 14
    //   1019: ldc_w 2280
    //   1022: aload_0
    //   1023: getfield 2282	com/tencent/mobileqq/utils/JumpAction:jdField_e_of_type_Boolean	Z
    //   1026: invokevirtual 405	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1029: pop
    //   1030: aload 14
    //   1032: aload 8
    //   1034: invokestatic 2288	cooperation/qzone/report/lp/QZoneLoginReportHelper:needAddLoginFromLebaTab	(Landroid/content/Intent;Ljava/lang/String;)Z
    //   1037: ifeq +8 -> 1045
    //   1040: aload 14
    //   1042: invokestatic 2291	cooperation/qzone/report/lp/QZoneLoginReportHelper:setLoginFromLebaTab	(Landroid/content/Intent;)V
    //   1045: iload_1
    //   1046: ifne +1769 -> 2815
    //   1049: aload 8
    //   1051: ldc_w 2268
    //   1054: invokevirtual 1660	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1057: ifeq +104 -> 1161
    //   1060: aload 14
    //   1062: aload 8
    //   1064: invokestatic 1638	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1067: aload 14
    //   1069: ldc_w 396
    //   1072: invokevirtual 393	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1075: pop
    //   1076: aload_0
    //   1077: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1080: checkcast 649	android/app/Activity
    //   1083: aload_0
    //   1084: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1087: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1090: aload 14
    //   1092: iconst_m1
    //   1093: invokestatic 2293	cooperation/qzone/QZoneHelper:c	(Landroid/app/Activity;Ljava/lang/String;Landroid/content/Intent;I)V
    //   1096: iconst_1
    //   1097: ireturn
    //   1098: iload_2
    //   1099: iconst_1
    //   1100: iadd
    //   1101: istore_2
    //   1102: goto -256 -> 846
    //   1105: astore 8
    //   1107: new 153	android/content/Intent
    //   1110: dup
    //   1111: aload_0
    //   1112: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1115: ldc_w 2295
    //   1118: invokespecial 158	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1121: astore 8
    //   1123: aload 8
    //   1125: ldc_w 394
    //   1128: invokevirtual 393	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1131: pop
    //   1132: aload 8
    //   1134: aload 14
    //   1136: invokevirtual 1996	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   1139: pop
    //   1140: aload_0
    //   1141: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1144: aload 8
    //   1146: invokevirtual 173	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1149: goto -53 -> 1096
    //   1152: astore 8
    //   1154: aload 8
    //   1156: invokevirtual 2296	android/content/ActivityNotFoundException:printStackTrace	()V
    //   1159: iconst_0
    //   1160: ireturn
    //   1161: aload 8
    //   1163: ldc_w 2298
    //   1166: invokevirtual 2301	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1169: ifeq +59 -> 1228
    //   1172: aload_0
    //   1173: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1176: aload_0
    //   1177: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1180: invokestatic 2306	com/tencent/mobileqq/troop/data/NearbyTroops:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)V
    //   1183: aload_0
    //   1184: getfield 1290	com/tencent/mobileqq/utils/JumpAction:jdField_d_of_type_Boolean	Z
    //   1187: ifeq +1725 -> 2912
    //   1190: ldc 244
    //   1192: astore 8
    //   1194: aload_0
    //   1195: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1198: ldc_w 948
    //   1201: ldc_w 2308
    //   1204: ldc 56
    //   1206: ldc_w 2310
    //   1209: ldc_w 2312
    //   1212: iconst_0
    //   1213: iconst_0
    //   1214: ldc 56
    //   1216: ldc 56
    //   1218: ldc 56
    //   1220: aload 8
    //   1222: invokestatic 320	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1225: goto -129 -> 1096
    //   1228: aload 8
    //   1230: ldc_w 2314
    //   1233: invokevirtual 2301	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1236: istore 6
    //   1238: iload 6
    //   1240: ifeq +234 -> 1474
    //   1243: aload_0
    //   1244: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1247: checkcast 1579	android/support/v4/app/FragmentActivity
    //   1250: invokevirtual 1596	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   1253: astore 9
    //   1255: aload 9
    //   1257: ifnull -161 -> 1096
    //   1260: aload 9
    //   1262: invokevirtual 1601	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1265: ifnull -169 -> 1096
    //   1268: aload 9
    //   1270: invokevirtual 1601	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1273: invokevirtual 2317	com/tencent/mobileqq/activity/BaseChatPie:az	()V
    //   1276: aload 9
    //   1278: invokevirtual 1601	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1281: getfield 2320	com/tencent/mobileqq/activity/BaseChatPie:a	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1284: getfield 2321	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   1287: istore_1
    //   1288: aload 14
    //   1290: ldc_w 559
    //   1293: aload_0
    //   1294: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1297: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1300: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1303: pop
    //   1304: aload 14
    //   1306: ldc_w 2323
    //   1309: iload_1
    //   1310: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1313: pop
    //   1314: aload 14
    //   1316: ldc_w 2325
    //   1319: invokevirtual 725	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1322: astore 11
    //   1324: aload 14
    //   1326: ldc_w 2327
    //   1329: invokevirtual 725	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1332: astore 10
    //   1334: aload 14
    //   1336: ldc_w 2329
    //   1339: invokevirtual 725	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1342: astore 9
    //   1344: aload 11
    //   1346: ifnull +80 -> 1426
    //   1349: aload 10
    //   1351: ifnull +75 -> 1426
    //   1354: aload 11
    //   1356: invokestatic 2334	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1359: astore 11
    //   1361: aload 10
    //   1363: invokestatic 2334	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1366: astore 10
    //   1368: aload 14
    //   1370: ldc_w 284
    //   1373: new 254	java/lang/StringBuilder
    //   1376: dup
    //   1377: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1380: ldc_w 2336
    //   1383: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: aload 11
    //   1388: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1391: ldc_w 2338
    //   1394: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: aload 10
    //   1399: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1402: ldc_w 2340
    //   1405: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: aload 9
    //   1410: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: ldc_w 2342
    //   1416: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1422: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1425: pop
    //   1426: aload 14
    //   1428: aload_0
    //   1429: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1432: invokevirtual 2345	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1435: aload 8
    //   1437: invokevirtual 1233	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1440: pop
    //   1441: aload_0
    //   1442: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1445: checkcast 800	com/tencent/mobileqq/app/BaseActivity
    //   1448: aload 14
    //   1450: bipush 18
    //   1452: invokevirtual 2092	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1455: ldc_w 2347
    //   1458: invokestatic 2351	com/tencent/biz/widgets/QQMapRoutingHelper:a	(Ljava/lang/String;)V
    //   1461: goto -365 -> 1096
    //   1464: astore 8
    //   1466: aload 8
    //   1468: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   1471: goto -375 -> 1096
    //   1474: aload 8
    //   1476: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1479: ifne +288 -> 1767
    //   1482: aload 9
    //   1484: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1487: ifne +280 -> 1767
    //   1490: aload 8
    //   1492: ldc_w 2353
    //   1495: invokevirtual 519	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1498: ifeq +269 -> 1767
    //   1501: aload 9
    //   1503: ldc 47
    //   1505: invokevirtual 519	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1508: ifeq +259 -> 1767
    //   1511: new 549	java/lang/StringBuffer
    //   1514: dup
    //   1515: invokespecial 550	java/lang/StringBuffer:<init>	()V
    //   1518: astore 12
    //   1520: aload_0
    //   1521: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1524: ifnull +231 -> 1755
    //   1527: aload_0
    //   1528: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1531: getfield 2355	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1534: invokevirtual 1300	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1537: ifle +218 -> 1755
    //   1540: aload_0
    //   1541: getfield 2247	com/tencent/mobileqq/utils/JumpAction:jdField_c_of_type_Boolean	Z
    //   1544: ifeq +211 -> 1755
    //   1547: aload 12
    //   1549: ldc_w 2357
    //   1552: invokevirtual 2360	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1555: pop
    //   1556: aload_0
    //   1557: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1560: getfield 2355	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1563: invokevirtual 2361	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1566: ifeq +38 -> 1604
    //   1569: aload 12
    //   1571: new 254	java/lang/StringBuilder
    //   1574: dup
    //   1575: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1578: ldc_w 2363
    //   1581: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: aload_0
    //   1585: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1588: getfield 2355	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1591: invokevirtual 1300	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1594: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1597: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1600: invokevirtual 2360	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1603: pop
    //   1604: aload_0
    //   1605: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1608: getfield 1335	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1611: invokevirtual 1339	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1614: istore 6
    //   1616: iload 6
    //   1618: ifeq +48 -> 1666
    //   1621: aload_0
    //   1622: getfield 1288	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1625: getfield 1335	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1628: invokevirtual 1341	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1631: ldc_w 1095
    //   1634: invokestatic 1100	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1637: astore 10
    //   1639: aload 12
    //   1641: new 254	java/lang/StringBuilder
    //   1644: dup
    //   1645: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1648: ldc_w 2365
    //   1651: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: aload 10
    //   1656: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1662: invokevirtual 2360	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1665: pop
    //   1666: aload_0
    //   1667: ldc_w 284
    //   1670: invokevirtual 738	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1673: astore 11
    //   1675: aload 11
    //   1677: astore 10
    //   1679: aload 11
    //   1681: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1684: ifne +27 -> 1711
    //   1687: aload 11
    //   1689: astore 10
    //   1691: aload 11
    //   1693: invokestatic 2369	com/tencent/biz/qrcode/util/QRUtils:g	(Ljava/lang/String;)Z
    //   1696: ifeq +15 -> 1711
    //   1699: aload 11
    //   1701: aload 12
    //   1703: invokevirtual 2370	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1706: invokestatic 2374	com/tencent/biz/common/offline/HtmlOffline:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1709: astore 10
    //   1711: aload_0
    //   1712: aload 10
    //   1714: aload 9
    //   1716: aload 8
    //   1718: aload 14
    //   1720: invokespecial 2376	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1723: aload_0
    //   1724: aload 8
    //   1726: invokespecial 2378	com/tencent/mobileqq/utils/JumpAction:f	(Ljava/lang/String;)V
    //   1729: goto -633 -> 1096
    //   1732: astore 10
    //   1734: invokestatic 569	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1737: ifeq +1183 -> 2920
    //   1740: ldc_w 328
    //   1743: iconst_2
    //   1744: aload 10
    //   1746: invokevirtual 2379	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   1749: invokestatic 573	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1752: goto +1168 -> 2920
    //   1755: aload 12
    //   1757: ldc_w 2381
    //   1760: invokevirtual 2360	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1763: pop
    //   1764: goto -98 -> 1666
    //   1767: aload 8
    //   1769: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1772: ifne +341 -> 2113
    //   1775: aload 9
    //   1777: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1780: ifne +333 -> 2113
    //   1783: aload 8
    //   1785: ldc_w 2383
    //   1788: invokevirtual 519	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1791: ifeq +322 -> 2113
    //   1794: aload 9
    //   1796: ldc 47
    //   1798: invokevirtual 519	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1801: ifeq +312 -> 2113
    //   1804: aload_0
    //   1805: ldc_w 284
    //   1808: invokevirtual 738	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1811: astore 10
    //   1813: aload 10
    //   1815: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1818: ifeq +270 -> 2088
    //   1821: ldc_w 2385
    //   1824: astore 10
    //   1826: new 254	java/lang/StringBuilder
    //   1829: dup
    //   1830: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1833: ldc_w 2387
    //   1836: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1839: invokestatic 344	java/lang/System:currentTimeMillis	()J
    //   1842: invokevirtual 511	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1845: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1848: astore 12
    //   1850: aload 12
    //   1852: astore 11
    //   1854: aload_0
    //   1855: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1858: ifnull +51 -> 1909
    //   1861: aload 12
    //   1863: astore 11
    //   1865: invokestatic 2392	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   1868: aload 10
    //   1870: invokevirtual 2394	com/tencent/biz/AuthorizeConfig:e	(Ljava/lang/String;)Z
    //   1873: ifeq +36 -> 1909
    //   1876: new 254	java/lang/StringBuilder
    //   1879: dup
    //   1880: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1883: aload 12
    //   1885: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1888: ldc_w 2396
    //   1891: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1894: aload_0
    //   1895: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1898: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1901: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1904: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1907: astore 11
    //   1909: aload 11
    //   1911: astore 12
    //   1913: aload_0
    //   1914: getfield 1163	com/tencent/mobileqq/utils/JumpAction:p	Ljava/lang/String;
    //   1917: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1920: ifne +33 -> 1953
    //   1923: new 254	java/lang/StringBuilder
    //   1926: dup
    //   1927: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1930: aload 11
    //   1932: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1935: ldc_w 1987
    //   1938: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: aload_0
    //   1942: getfield 1163	com/tencent/mobileqq/utils/JumpAction:p	Ljava/lang/String;
    //   1945: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1951: astore 12
    //   1953: aload 12
    //   1955: astore 11
    //   1957: aload 10
    //   1959: ldc_w 1982
    //   1962: invokevirtual 1985	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1965: ifge +26 -> 1991
    //   1968: new 254	java/lang/StringBuilder
    //   1971: dup
    //   1972: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1975: aload 12
    //   1977: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: ldc_w 2398
    //   1983: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1986: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1989: astore 11
    //   1991: aload_0
    //   1992: aload 10
    //   1994: aload 11
    //   1996: invokestatic 2374	com/tencent/biz/common/offline/HtmlOffline:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1999: aload 9
    //   2001: aload 8
    //   2003: aload 14
    //   2005: invokespecial 2376	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2008: aload_0
    //   2009: aload 8
    //   2011: invokespecial 2378	com/tencent/mobileqq/utils/JumpAction:f	(Ljava/lang/String;)V
    //   2014: aload_0
    //   2015: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2018: ifnull +37 -> 2055
    //   2021: aload_0
    //   2022: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2025: ldc_w 2400
    //   2028: invokevirtual 2404	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   2031: astore 8
    //   2033: aload 8
    //   2035: ifnull +20 -> 2055
    //   2038: aload 8
    //   2040: aload 8
    //   2042: ldc_w 2405
    //   2045: invokevirtual 2411	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   2048: ldc2_w 2412
    //   2051: invokevirtual 2417	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   2054: pop
    //   2055: invokestatic 569	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2058: ifeq +13 -> 2071
    //   2061: ldc_w 328
    //   2064: iconst_2
    //   2065: ldc_w 2419
    //   2068: invokestatic 335	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2071: new 2421	akjy
    //   2074: dup
    //   2075: aload_0
    //   2076: invokespecial 2422	akjy:<init>	(Lcom/tencent/mobileqq/utils/JumpAction;)V
    //   2079: iconst_5
    //   2080: aconst_null
    //   2081: iconst_1
    //   2082: invokestatic 1413	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2085: goto -989 -> 1096
    //   2088: aload 10
    //   2090: invokestatic 1857	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   2093: astore 10
    //   2095: goto -269 -> 1826
    //   2098: astore 10
    //   2100: aload 10
    //   2102: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   2105: ldc_w 2385
    //   2108: astore 10
    //   2110: goto -284 -> 1826
    //   2113: aload 8
    //   2115: ldc_w 2424
    //   2118: invokevirtual 2301	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2121: ifeq +170 -> 2291
    //   2124: aload_0
    //   2125: ldc_w 309
    //   2128: invokevirtual 738	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2131: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2134: ifne +52 -> 2186
    //   2137: aload 14
    //   2139: ldc_w 2426
    //   2142: iconst_4
    //   2143: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2146: pop
    //   2147: aload 14
    //   2149: ldc_w 2428
    //   2152: aload 14
    //   2154: ldc_w 2428
    //   2157: iconst_1
    //   2158: invokevirtual 735	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2161: iconst_4
    //   2162: ior
    //   2163: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2166: pop
    //   2167: aload_0
    //   2168: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2171: aload_0
    //   2172: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2175: checkcast 649	android/app/Activity
    //   2178: aload 14
    //   2180: invokestatic 2433	cooperation/readinjoy/ReadInJoyHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2183: goto -1087 -> 1096
    //   2186: aload_0
    //   2187: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2190: ldc_w 990
    //   2193: ldc 56
    //   2195: ldc 56
    //   2197: ldc_w 2435
    //   2200: ldc_w 2435
    //   2203: iconst_0
    //   2204: iconst_0
    //   2205: ldc 56
    //   2207: ldc 56
    //   2209: ldc 56
    //   2211: ldc 56
    //   2213: iconst_0
    //   2214: invokestatic 957	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2217: invokestatic 2440	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:a	()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   2220: invokestatic 2440	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:a	()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   2223: invokevirtual 2441	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:b	()Z
    //   2226: ldc_w 2443
    //   2229: iconst_1
    //   2230: invokevirtual 2446	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:a	(ZLjava/lang/String;I)V
    //   2233: aload 14
    //   2235: ldc_w 2426
    //   2238: iconst_1
    //   2239: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2242: pop
    //   2243: aload 14
    //   2245: ldc_w 2448
    //   2248: invokestatic 344	java/lang/System:currentTimeMillis	()J
    //   2251: invokevirtual 167	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2254: pop
    //   2255: aload_0
    //   2256: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2259: bipush 95
    //   2261: invokevirtual 227	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2264: checkcast 2450	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager
    //   2267: aload 14
    //   2269: invokevirtual 2451	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager:a	(Landroid/content/Intent;)V
    //   2272: aload_0
    //   2273: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2276: aload_0
    //   2277: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2280: checkcast 649	android/app/Activity
    //   2283: aload 14
    //   2285: invokestatic 2433	cooperation/readinjoy/ReadInJoyHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2288: goto -1192 -> 1096
    //   2291: aload 8
    //   2293: ldc_w 2298
    //   2296: invokevirtual 2301	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2299: ifeq +14 -> 2313
    //   2302: aload 14
    //   2304: ldc_w 309
    //   2307: bipush 15
    //   2309: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2312: pop
    //   2313: aload 8
    //   2315: ldc_w 2453
    //   2318: invokevirtual 2301	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2321: ifeq +16 -> 2337
    //   2324: aload 14
    //   2326: ldc_w 2455
    //   2329: aload_0
    //   2330: getfield 844	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2333: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2336: pop
    //   2337: aload 8
    //   2339: getstatic 2456	cooperation/comic/VipComicJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2342: invokevirtual 2301	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2345: ifeq +39 -> 2384
    //   2348: aload 14
    //   2350: invokestatic 2459	cooperation/comic/VipComicJumpActivity:a	(Landroid/content/Intent;)Lcooperation/comic/VipComicJumpActivity$ComicParam;
    //   2353: astore 11
    //   2355: aload_0
    //   2356: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2359: aload_0
    //   2360: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2363: checkcast 649	android/app/Activity
    //   2366: aload 11
    //   2368: invokestatic 2462	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lcooperation/comic/VipComicJumpActivity$ComicParam;)Z
    //   2371: ifeq +13 -> 2384
    //   2374: aload_0
    //   2375: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2378: iconst_1
    //   2379: invokestatic 2465	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Z)V
    //   2382: iconst_1
    //   2383: ireturn
    //   2384: aload 9
    //   2386: ifnull -1290 -> 1096
    //   2389: aload 9
    //   2391: invokestatic 689	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2394: invokevirtual 2466	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   2397: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2400: istore 6
    //   2402: iload 6
    //   2404: ifeq +371 -> 2775
    //   2407: iconst_0
    //   2408: istore 6
    //   2410: ldc_w 2468
    //   2413: invokestatic 689	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2416: invokevirtual 2472	com/tencent/qphone/base/util/BaseApplication:getClassLoader	()Ljava/lang/ClassLoader;
    //   2419: aload 8
    //   2421: invokevirtual 2478	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   2424: invokevirtual 2482	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   2427: istore 7
    //   2429: iload 7
    //   2431: istore 6
    //   2433: iload 6
    //   2435: ifeq +5 -> 2440
    //   2438: iconst_0
    //   2439: ireturn
    //   2440: aload 14
    //   2442: ldc_w 2484
    //   2445: invokevirtual 725	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2448: astore 11
    //   2450: aload 11
    //   2452: ifnull +399 -> 2851
    //   2455: aload 11
    //   2457: invokestatic 133	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2460: istore_1
    //   2461: aload 8
    //   2463: ldc_w 2486
    //   2466: invokevirtual 519	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2469: ifeq +189 -> 2658
    //   2472: ldc_w 2488
    //   2475: astore 8
    //   2477: ldc_w 2490
    //   2480: aload 8
    //   2482: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2485: ifeq +205 -> 2690
    //   2488: aload 14
    //   2490: ldc_w 2492
    //   2493: invokevirtual 725	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2496: astore 12
    //   2498: aload 8
    //   2500: astore 11
    //   2502: aload 12
    //   2504: ifnull +38 -> 2542
    //   2507: aload 8
    //   2509: astore 11
    //   2511: aload 12
    //   2513: invokestatic 133	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2516: iconst_2
    //   2517: if_icmpne +25 -> 2542
    //   2520: iload_1
    //   2521: invokestatic 2497	com/tencent/qidian/QidianManager:b	(I)Z
    //   2524: ifeq +409 -> 2933
    //   2527: ldc_w 2499
    //   2530: astore 11
    //   2532: aload 14
    //   2534: ldc_w 2484
    //   2537: iload_1
    //   2538: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2541: pop
    //   2542: aload 10
    //   2544: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2547: ifne +130 -> 2677
    //   2550: aload 10
    //   2552: invokevirtual 2502	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2555: ldc_w 2504
    //   2558: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2561: ifeq +116 -> 2677
    //   2564: aload 14
    //   2566: ldc_w 842
    //   2569: bipush 117
    //   2571: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2574: pop
    //   2575: aload 14
    //   2577: ldc_w 296
    //   2580: invokevirtual 393	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2583: pop
    //   2584: aload 11
    //   2586: astore 8
    //   2588: ldc_w 2506
    //   2591: aload 8
    //   2593: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2596: ifeq +151 -> 2747
    //   2599: aload 14
    //   2601: ldc_w 284
    //   2604: invokevirtual 725	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2607: astore 10
    //   2609: aload 10
    //   2611: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2614: ifne +133 -> 2747
    //   2617: aload 10
    //   2619: ldc_w 1821
    //   2622: invokevirtual 1660	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2625: ifne +122 -> 2747
    //   2628: ldc_w 328
    //   2631: iconst_1
    //   2632: new 254	java/lang/StringBuilder
    //   2635: dup
    //   2636: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   2639: ldc_w 2508
    //   2642: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2645: aload 10
    //   2647: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2650: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2653: invokestatic 1070	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2656: iconst_0
    //   2657: ireturn
    //   2658: aload 8
    //   2660: ldc_w 2510
    //   2663: invokevirtual 519	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2666: ifeq +182 -> 2848
    //   2669: ldc_w 2490
    //   2672: astore 8
    //   2674: goto -197 -> 2477
    //   2677: aload 14
    //   2679: ldc_w 842
    //   2682: iconst_2
    //   2683: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2686: pop
    //   2687: goto -112 -> 2575
    //   2690: ldc_w 2488
    //   2693: aload 8
    //   2695: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2698: ifeq +28 -> 2726
    //   2701: iload_1
    //   2702: invokestatic 2497	com/tencent/qidian/QidianManager:b	(I)Z
    //   2705: ifeq -117 -> 2588
    //   2708: ldc_w 2499
    //   2711: astore 8
    //   2713: aload 14
    //   2715: ldc_w 2484
    //   2718: iload_1
    //   2719: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2722: pop
    //   2723: goto -135 -> 2588
    //   2726: aload 14
    //   2728: ldc_w 1235
    //   2731: invokevirtual 1125	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   2734: pop
    //   2735: aload 14
    //   2737: ldc_w 394
    //   2740: invokevirtual 393	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2743: pop
    //   2744: goto -156 -> 2588
    //   2747: aload 14
    //   2749: aload 9
    //   2751: aload 8
    //   2753: invokevirtual 1233	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2756: pop
    //   2757: aload_0
    //   2758: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2761: aload 14
    //   2763: invokevirtual 173	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2766: aload_0
    //   2767: aload 8
    //   2769: invokespecial 2378	com/tencent/mobileqq/utils/JumpAction:f	(Ljava/lang/String;)V
    //   2772: goto -1676 -> 1096
    //   2775: aload 14
    //   2777: aload 9
    //   2779: aload 8
    //   2781: invokevirtual 1233	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2784: pop
    //   2785: aload 14
    //   2787: ldc_w 1235
    //   2790: invokevirtual 1125	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   2793: pop
    //   2794: aload 14
    //   2796: ldc_w 394
    //   2799: invokevirtual 393	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2802: pop
    //   2803: aload_0
    //   2804: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2807: aload 14
    //   2809: invokevirtual 173	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2812: goto -1716 -> 1096
    //   2815: iload_1
    //   2816: iconst_1
    //   2817: if_icmpne -1721 -> 1096
    //   2820: aload 11
    //   2822: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2825: ifne -1729 -> 1096
    //   2828: aload_0
    //   2829: aload 14
    //   2831: aload 8
    //   2833: aload 11
    //   2835: invokespecial 2512	com/tencent/mobileqq/utils/JumpAction:a	(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Z
    //   2838: istore 6
    //   2840: iload 6
    //   2842: ireturn
    //   2843: astore 11
    //   2845: goto -412 -> 2433
    //   2848: goto -371 -> 2477
    //   2851: iconst_0
    //   2852: istore_1
    //   2853: goto -392 -> 2461
    //   2856: aload 10
    //   2858: astore 12
    //   2860: aload 11
    //   2862: astore 13
    //   2864: aload 8
    //   2866: astore 11
    //   2868: aload 9
    //   2870: astore 10
    //   2872: aload 12
    //   2874: astore 8
    //   2876: aload 13
    //   2878: astore 9
    //   2880: goto -2757 -> 123
    //   2883: aload 8
    //   2885: astore 12
    //   2887: aload 9
    //   2889: astore 13
    //   2891: aload 11
    //   2893: astore 8
    //   2895: aload 10
    //   2897: astore 9
    //   2899: aload 12
    //   2901: astore 10
    //   2903: aload 13
    //   2905: astore 11
    //   2907: goto -51 -> 2856
    //   2910: iconst_0
    //   2911: ireturn
    //   2912: ldc_w 563
    //   2915: astore 8
    //   2917: goto -1723 -> 1194
    //   2920: aconst_null
    //   2921: astore 10
    //   2923: goto -1284 -> 1639
    //   2926: astore 11
    //   2928: iconst_0
    //   2929: istore_1
    //   2930: goto -469 -> 2461
    //   2933: ldc_w 2488
    //   2936: astore 11
    //   2938: goto -396 -> 2542
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2941	0	this	JumpAction
    //   37	2893	1	i1	int
    //   845	257	2	i2	int
    //   825	45	3	i3	int
    //   821	26	4	i4	int
    //   842	11	5	i5	int
    //   1236	1605	6	bool1	boolean
    //   2427	3	7	bool2	boolean
    //   22	1041	8	localObject1	Object
    //   1105	1	8	localException1	Exception
    //   1121	24	8	localIntent1	Intent
    //   1152	10	8	localActivityNotFoundException	android.content.ActivityNotFoundException
    //   1192	244	8	str1	String
    //   1464	546	8	localException2	Exception
    //   2031	885	8	localObject2	Object
    //   19	2879	9	localObject3	Object
    //   25	1688	10	localObject4	Object
    //   1732	13	10	localUnsupportedEncodingException	UnsupportedEncodingException
    //   1811	283	10	str2	String
    //   2098	3	10	localException3	Exception
    //   2108	814	10	localObject5	Object
    //   40	2794	11	localObject6	Object
    //   2843	18	11	localException4	Exception
    //   2866	40	11	localObject7	Object
    //   2926	1	11	localException5	Exception
    //   2936	1	11	str3	String
    //   34	2866	12	localObject8	Object
    //   155	2749	13	localObject9	Object
    //   10	2820	14	localIntent2	Intent
    //   121	13	15	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   1076	1096	1105	java/lang/Exception
    //   0	18	1152	android/content/ActivityNotFoundException
    //   27	36	1152	android/content/ActivityNotFoundException
    //   42	114	1152	android/content/ActivityNotFoundException
    //   114	123	1152	android/content/ActivityNotFoundException
    //   123	169	1152	android/content/ActivityNotFoundException
    //   179	190	1152	android/content/ActivityNotFoundException
    //   213	224	1152	android/content/ActivityNotFoundException
    //   243	281	1152	android/content/ActivityNotFoundException
    //   308	339	1152	android/content/ActivityNotFoundException
    //   343	367	1152	android/content/ActivityNotFoundException
    //   367	378	1152	android/content/ActivityNotFoundException
    //   405	443	1152	android/content/ActivityNotFoundException
    //   470	504	1152	android/content/ActivityNotFoundException
    //   531	602	1152	android/content/ActivityNotFoundException
    //   629	651	1152	android/content/ActivityNotFoundException
    //   676	687	1152	android/content/ActivityNotFoundException
    //   714	725	1152	android/content/ActivityNotFoundException
    //   748	758	1152	android/content/ActivityNotFoundException
    //   771	791	1152	android/content/ActivityNotFoundException
    //   794	818	1152	android/content/ActivityNotFoundException
    //   826	844	1152	android/content/ActivityNotFoundException
    //   855	867	1152	android/content/ActivityNotFoundException
    //   873	925	1152	android/content/ActivityNotFoundException
    //   925	971	1152	android/content/ActivityNotFoundException
    //   971	994	1152	android/content/ActivityNotFoundException
    //   994	1017	1152	android/content/ActivityNotFoundException
    //   1017	1045	1152	android/content/ActivityNotFoundException
    //   1049	1076	1152	android/content/ActivityNotFoundException
    //   1076	1096	1152	android/content/ActivityNotFoundException
    //   1107	1149	1152	android/content/ActivityNotFoundException
    //   1161	1190	1152	android/content/ActivityNotFoundException
    //   1194	1225	1152	android/content/ActivityNotFoundException
    //   1228	1238	1152	android/content/ActivityNotFoundException
    //   1243	1255	1152	android/content/ActivityNotFoundException
    //   1260	1344	1152	android/content/ActivityNotFoundException
    //   1354	1426	1152	android/content/ActivityNotFoundException
    //   1426	1461	1152	android/content/ActivityNotFoundException
    //   1466	1471	1152	android/content/ActivityNotFoundException
    //   1474	1604	1152	android/content/ActivityNotFoundException
    //   1604	1616	1152	android/content/ActivityNotFoundException
    //   1621	1639	1152	android/content/ActivityNotFoundException
    //   1639	1666	1152	android/content/ActivityNotFoundException
    //   1666	1675	1152	android/content/ActivityNotFoundException
    //   1679	1687	1152	android/content/ActivityNotFoundException
    //   1691	1711	1152	android/content/ActivityNotFoundException
    //   1711	1729	1152	android/content/ActivityNotFoundException
    //   1734	1752	1152	android/content/ActivityNotFoundException
    //   1755	1764	1152	android/content/ActivityNotFoundException
    //   1767	1821	1152	android/content/ActivityNotFoundException
    //   1826	1850	1152	android/content/ActivityNotFoundException
    //   1854	1861	1152	android/content/ActivityNotFoundException
    //   1865	1909	1152	android/content/ActivityNotFoundException
    //   1913	1953	1152	android/content/ActivityNotFoundException
    //   1957	1991	1152	android/content/ActivityNotFoundException
    //   1991	2033	1152	android/content/ActivityNotFoundException
    //   2038	2055	1152	android/content/ActivityNotFoundException
    //   2055	2071	1152	android/content/ActivityNotFoundException
    //   2071	2085	1152	android/content/ActivityNotFoundException
    //   2088	2095	1152	android/content/ActivityNotFoundException
    //   2100	2105	1152	android/content/ActivityNotFoundException
    //   2113	2183	1152	android/content/ActivityNotFoundException
    //   2186	2288	1152	android/content/ActivityNotFoundException
    //   2291	2313	1152	android/content/ActivityNotFoundException
    //   2313	2337	1152	android/content/ActivityNotFoundException
    //   2337	2382	1152	android/content/ActivityNotFoundException
    //   2389	2402	1152	android/content/ActivityNotFoundException
    //   2410	2429	1152	android/content/ActivityNotFoundException
    //   2440	2450	1152	android/content/ActivityNotFoundException
    //   2455	2461	1152	android/content/ActivityNotFoundException
    //   2461	2472	1152	android/content/ActivityNotFoundException
    //   2477	2498	1152	android/content/ActivityNotFoundException
    //   2511	2527	1152	android/content/ActivityNotFoundException
    //   2532	2542	1152	android/content/ActivityNotFoundException
    //   2542	2575	1152	android/content/ActivityNotFoundException
    //   2575	2584	1152	android/content/ActivityNotFoundException
    //   2588	2656	1152	android/content/ActivityNotFoundException
    //   2658	2669	1152	android/content/ActivityNotFoundException
    //   2677	2687	1152	android/content/ActivityNotFoundException
    //   2690	2701	1152	android/content/ActivityNotFoundException
    //   2701	2708	1152	android/content/ActivityNotFoundException
    //   2713	2723	1152	android/content/ActivityNotFoundException
    //   2726	2744	1152	android/content/ActivityNotFoundException
    //   2747	2772	1152	android/content/ActivityNotFoundException
    //   2775	2812	1152	android/content/ActivityNotFoundException
    //   2820	2840	1152	android/content/ActivityNotFoundException
    //   1243	1255	1464	java/lang/Exception
    //   1260	1344	1464	java/lang/Exception
    //   1354	1426	1464	java/lang/Exception
    //   1426	1461	1464	java/lang/Exception
    //   1621	1639	1732	java/io/UnsupportedEncodingException
    //   2088	2095	2098	java/lang/Exception
    //   2410	2429	2843	java/lang/Exception
    //   2455	2461	2926	java/lang/Exception
  }
  
  private boolean aT()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492C", "0X800492C", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.e("qqdataline", 2, "shareFromMigSdk|report send from sdk:0X800492C.");
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str2 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject2 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject4 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    d((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    String str1 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    Object localObject6 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    if (!TextUtils.isEmpty(this.n)) {}
    for (localObject1 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; localObject1 = null)
    {
      Object localObject7 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
      String str4 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      String str3 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
      String str5 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
      String str7 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
      int i2 = 0;
      try
      {
        i1 = Integer.valueOf(d((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
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
          localBundle.putString("pkg_name", this.n);
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
                  break label831;
                }
                localBundle.putString("audio_url", (String)localObject7);
                if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject4)))
                {
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break;
                  }
                  localBundle.putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131431696), new Object[] { localObject1 }));
                }
                com.tencent.mobileqq.app.PhoneContactManagerImp.g = true;
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
            label831:
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
                  localException2.putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131431697));
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
                        break label908;
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
                        break label1205;
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
                              break label1195;
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
                      localException2.putString("forward_text", "已选择" + FileManagerUtil.a((String)localObject1) + "，大小" + FileUtil.a(FileUtil.a((String)localObject1)) + "。");
                      localException2.putBoolean("qdshare_file", true);
                      localException2.putBoolean("isFromShare", true);
                      localException2.putBoolean("key_sdk_share_pure_text", true);
                      localException2.putInt("req_type", 6);
                    }
                  }
                  else if (FileManagerUtil.a(localObject3) == 0)
                  {
                    localException2.putString("title", ((ArrayList)localObject6).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131431652));
                    localException2.putString("qqfav_extra_multi_pic_path_list", str2);
                    localException2.putBoolean("qqfav_extra_multi_pic", true);
                    localException2.putInt("req_type", 1);
                  }
                  else
                  {
                    localObject1 = ((ArrayList)localObject6).iterator();
                    for (l1 = 0L; ((Iterator)localObject1).hasNext(); l1 = FileUtil.a((String)((Iterator)localObject1).next()) + l1) {}
                    localException2.putString("forward_text", "已选择" + FileManagerUtil.a(localObject3) + "等" + ((ArrayList)localObject6).size() + "个文件，大小" + FileUtil.a(l1));
                    localException2.putString("qqfav_extra_multi_pic_path_list", str2);
                    localException2.putBoolean("qdshare_file", true);
                    localException2.putBoolean("isFromShare", true);
                    localException2.putBoolean("key_sdk_share_pure_text", true);
                    localException2.putInt("req_type", 6);
                  }
                }
              }
            } while (1 == i1);
            label908:
            label1195:
            label1205:
            return false;
          }
        }
      }
    }
  }
  
  private boolean aU()
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
  
  private boolean aV()
  {
    QQProxyForQlink.a(this.jdField_a_of_type_AndroidContentContext, 9, null);
    return true;
  }
  
  private boolean aW()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("feedsid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fsc");
    int i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("fst"));
    Intent localIntent = new Intent();
    localIntent.putExtra("_feed_id_", str1);
    localIntent.putExtra("_src_code_", str2);
    localIntent.putExtra("_src_type_", i1);
    localIntent.putExtra("_from_", 1);
    DingdongPluginHelper.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, "com.dingdong.business.base.activity.DingdongDetailActivity", localIntent, -1);
    return true;
  }
  
  private boolean aX()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("schedule_id");
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.putExtra("schedule_feed_id", str);
    localIntent.putExtra("from_url", true);
    DingdongPluginHelper.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, "com.dingdong.business.Schedule.Activity.ScheduleListActivity", localIntent, -1);
    return true;
  }
  
  private boolean aY()
  {
    String str3 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str4 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    if (!TextUtils.isEmpty(this.n)) {}
    Object localObject2;
    for (Object localObject1 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; localObject2 = null)
    {
      Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
      String str1 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
      try
      {
        str1 = URLDecoder.decode(str1, "UTF-8");
        str5 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("troopbar_id"));
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
              ((Intent)localObject1).putExtra("pkg_name", this.n);
              com.tencent.mobileqq.app.PhoneContactManagerImp.g = true;
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
  
  private boolean aZ()
  {
    String str = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
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
  
  private boolean aa()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str1 == null) || (str1.length() < 5) || (str1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      return false;
    }
    Object localObject = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
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
        break label405;
      }
      str4 = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
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
        localObject = HexUtil.a(str3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str1, (byte[])localObject);
      }
      if (str2 != null) {
        localIntent.putExtra("sigt", HexUtil.a(str2));
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Bqq_Crm", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str1, "", "");
      return true;
      localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class));
      localIntent.putExtra("open_chatfragment", true);
      break;
      label405:
      if (i1 == 1024) {
        localIntent.putExtra("chat_subType", 1);
      }
    }
  }
  
  private boolean ab()
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
  
  private boolean ac()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || (str.length() < 6)) {
      return false;
    }
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject == null) {
      return false;
    }
    localObject = ((TroopManager)localObject).a(str);
    if (localObject != null)
    {
      localObject = ((TroopInfo)localObject).getTroopName();
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
    return ar();
  }
  
  private boolean ad()
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
        str = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
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
  
  private boolean ae()
  {
    NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private boolean af()
  {
    if ((String)this.jdField_a_of_type_JavaUtilHashMap.get("back_title") == null) {}
    TroopCreateLogic localTroopCreateLogic = (TroopCreateLogic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31);
    if (localTroopCreateLogic != null) {
      localTroopCreateLogic.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 0);
    }
    return true;
  }
  
  private boolean ag()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.putExtra("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    localIntent.putExtra("nickname", (String)localObject);
    localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if ((!str.equals("version")) && (!str.equals("src_type"))) {
        localIntent.putExtra(str, (String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
      }
    }
    return a(localIntent, "cooperation.qqreader.QRBridgeActivity", "qqreaderplugin.apk");
  }
  
  /* Error */
  private boolean ah()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 2327
    //   7: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 45	java/lang/String
    //   13: astore 6
    //   15: aload_0
    //   16: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: ldc_w 2325
    //   22: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 45	java/lang/String
    //   28: astore 7
    //   30: aload 6
    //   32: ifnull +140 -> 172
    //   35: aload 7
    //   37: ifnull +135 -> 172
    //   40: aload 6
    //   42: invokevirtual 2728	java/lang/String:trim	()Ljava/lang/String;
    //   45: invokestatic 133	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   48: i2d
    //   49: ldc2_w 2742
    //   52: ddiv
    //   53: dstore_1
    //   54: aload 7
    //   56: invokevirtual 2728	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 133	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: istore 5
    //   64: iload 5
    //   66: i2d
    //   67: ldc2_w 2742
    //   70: ddiv
    //   71: dstore_3
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   77: ldc_w 1701
    //   80: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: checkcast 45	java/lang/String
    //   86: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   89: pop
    //   90: new 254	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 2336
    //   100: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: dload_3
    //   104: invokevirtual 2746	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   107: ldc_w 2338
    //   110: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: dload_1
    //   114: invokevirtual 2746	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   117: ldc_w 2748
    //   120: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore 6
    //   128: new 153	android/content/Intent
    //   131: dup
    //   132: ldc_w 1116
    //   135: aload 6
    //   137: invokestatic 1133	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   140: invokespecial 2751	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   143: astore 7
    //   145: aload 7
    //   147: ldc_w 2753
    //   150: ldc_w 2755
    //   153: invokevirtual 1233	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   156: pop
    //   157: aload_0
    //   158: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   161: aload 7
    //   163: invokevirtual 173	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore 6
    //   170: iconst_0
    //   171: ireturn
    //   172: iconst_0
    //   173: ireturn
    //   174: astore 7
    //   176: aload_0
    //   177: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   180: new 153	android/content/Intent
    //   183: dup
    //   184: ldc_w 1116
    //   187: aload 6
    //   189: invokestatic 1133	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   192: invokespecial 2751	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   195: invokevirtual 173	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   198: goto -32 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	JumpAction
    //   53	61	1	d1	double
    //   71	33	3	d2	double
    //   62	3	5	i1	int
    //   13	123	6	str	String
    //   168	20	6	localException	Exception
    //   28	134	7	localObject	Object
    //   174	1	7	localActivityNotFoundException	android.content.ActivityNotFoundException
    // Exception table:
    //   from	to	target	type
    //   40	64	168	java/lang/Exception
    //   157	166	174	android/content/ActivityNotFoundException
  }
  
  private boolean ai()
  {
    if ("webview".equals(this.m))
    {
      d((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "select_location").putExtra("doCallBack", true).putExtra("src_type", this.f).putExtra("callback_type", this.g).putExtra("callback_name", this.jdField_h_of_type_JavaLangString));
    }
    return true;
  }
  
  private boolean aj()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("card_type");
    if ((str != null) && ("group".equals(str)))
    {
      a(10010, a());
      return ar();
    }
    if ((str != null) && ("public_account".equals(str)))
    {
      a(10003, a());
      return al();
    }
    if ((str != null) && ("troopmember".equals(str))) {
      return at();
    }
    if ((str != null) && ("crm".equals(str))) {
      return am();
    }
    if ((str != null) && ("nearby".equals(str))) {
      return ak();
    }
    if ((str != null) && ("campus_circle".equals(str))) {
      return an();
    }
    if ((str != null) && ("allpeoplevote".equals(str))) {
      return ao();
    }
    a(10002, a());
    return ap();
  }
  
  private boolean ak()
  {
    String str4;
    int i2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("source_id"))
    {
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source_id");
      i2 = -1;
    }
    label58:
    boolean bool;
    long l1;
    label73:
    int i1;
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tinnyid"))
      {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tinnyid");
        bool = TextUtils.isEmpty(str1);
        if (!bool) {
          break label182;
        }
        l1 = 0L;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str1;
        label107:
        int i3;
        label135:
        label182:
        l1 = 0L;
        continue;
        str2 = "";
      }
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from"))
      {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        i1 = Integer.parseInt(str1);
      }
    }
    catch (Exception localException2)
    {
      i1 = 0;
      break label107;
      label217:
      localObject = "";
      break label135;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
      switch (i2)
      {
      }
    }
    try
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("mode")) {
        break label217;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mode");
      i3 = Integer.valueOf(str1).intValue();
      i2 = i3;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        break;
        String str3 = "";
      }
    }
    if ((i2 != 1) && (i2 != 2) && (i2 != 3) && (i2 != 4)) {}
    Intent localIntent;
    label659:
    label915:
    for (;;)
    {
      return false;
      str4 = "";
      break;
      str1 = "";
      break label58;
      l1 = Long.valueOf(str1).longValue();
      break label73;
      String str2;
      return true;
      String str5;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if (!Utils.a(str4, "1001")) {
          break label659;
        }
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("uid")) {
          break label404;
        }
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uid");
        label329:
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("PUSH_CONTENT")) {
          break label411;
        }
      }
      label404:
      label411:
      for (String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PUSH_CONTENT");; str6 = "")
      {
        if (Utils.a(str5, localObject)) {
          break label418;
        }
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "gotoNearybyProfile,return caused by different uid");
        }
        return true;
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
          break label1036;
        }
        localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
        break;
        str5 = "";
        break label329;
      }
      label418:
      localIntent.putExtra("PUSH_CONTENT", str6);
      localIntent.putExtra("frome_where", -1);
      localIntent.addFlags(67108864);
      label448:
      localObject = new ProfileActivity.AllInOne((String)localObject, 0);
      if (i1 == 1)
      {
        localIntent.putExtra("frome_where", 12);
        ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 86;
        localIntent.addFlags(268435456);
      }
      if (i1 == 2)
      {
        ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 87;
        localIntent.addFlags(268435456);
      }
      if (i1 == 3)
      {
        ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 88;
        localIntent.addFlags(268435456);
      }
      if (i1 >= 7)
      {
        localIntent.putExtra("frome_where", i1);
        ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 86;
        localIntent.addFlags(268435456);
      }
      localIntent.putExtra("param_mode", i2);
      localIntent.putExtra("AllInOne", (Parcelable)localObject);
      if ((!TextUtils.isEmpty(str4)) && (str4.equals("1000"))) {}
      for (bool = true;; bool = false)
      {
        localIntent.putExtra("param_from_interest_test", bool);
        if (10002 == i1) {
          localIntent.addFlags(268435456);
        }
        localIntent.putExtra("param_tiny_id", l1);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        break;
        localIntent.putExtra("is_from_web", true);
        break label448;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {}
      for (localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");; localObject = "")
      {
        if ((l1 == 0L) && (TextUtils.isEmpty((CharSequence)localObject))) {
          break label915;
        }
        localIntent.putExtra("param_mode", 3);
        localIntent.putExtra("param_tiny_id", l1);
        if (10002 == i1) {
          localIntent.addFlags(268435456);
        }
        localIntent.putExtra("is_from_web", true);
        localObject = new ProfileActivity.AllInOne((String)localObject, 19);
        if (i1 == 1)
        {
          localIntent.putExtra("frome_where", 12);
          ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 86;
          localIntent.addFlags(268435456);
        }
        if (i1 == 2)
        {
          ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 87;
          localIntent.addFlags(268435456);
        }
        if (i1 == 3)
        {
          ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 88;
          localIntent.addFlags(268435456);
        }
        if (i1 >= 7)
        {
          localIntent.putExtra("frome_where", i1);
          ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Int = 86;
          localIntent.addFlags(268435456);
        }
        localIntent.putExtra("AllInOne", (Parcelable)localObject);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        break;
      }
    }
    Object localObject = "";
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne((String)localObject, 0);
      localIntent.putExtra("is_from_web", true);
      localIntent.putExtra("param_mode", i2);
      localIntent.putExtra("AllInOne", (Parcelable)localObject);
      localIntent.addFlags(268435456);
      localIntent.putExtra("param_tiny_id", l1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      break;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      }
    }
  }
  
  private boolean al()
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
    if (f())
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        localObject1 = new ProfileParams.Builder();
        ((ProfileParams.Builder)localObject1).a(new ProfileParams.CurLoginUsr((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"), (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"))).d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")).c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).a(i1).b((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
        PublicAccountUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ProfileParams.Builder)localObject1).a());
        return false;
      }
    }
    else
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("source", 117);
      PublicAccountUtil.a((Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, i1);
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
    }
    return true;
  }
  
  private boolean am()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoShowCrmCard uin: " + str + " | current uin: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    if ((str == null) || ("".equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(str))) {
      return false;
    }
    if (str.length() < 5) {
      return false;
    }
    PublicAccountUtil.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str, -7);
    return true;
  }
  
  private boolean an()
  {
    try
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      long l1 = Long.parseLong(str1);
      if (l1 < 10000L)
      {
        if (!QLog.isColorLevel()) {
          break label329;
        }
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoCampusCircleCard invalid uin uin: %d", new Object[] { Long.valueOf(l1) }));
        return false;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("name");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
      localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(str1);
      if (!Utils.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label259;
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
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoCampusCircleCard exception : %s", new Object[] { localException.toString() }));
        return false;
        label259:
        ProfileActivity.AllInOne localAllInOne2;
        if ((localFriends != null) && (localFriends.isFriend()))
        {
          localAllInOne2 = new ProfileActivity.AllInOne(str1, 91);
          localAllInOne2.jdField_h_of_type_JavaLangString = localFriends.name;
          localAllInOne2.i = localFriends.remark;
        }
        else
        {
          localAllInOne2 = new ProfileActivity.AllInOne(str1, 92);
          continue;
          localAllInOne2.jdField_h_of_type_Int = 110;
        }
      }
    }
    if ("sharecard".equals(str3))
    {
      localAllInOne1.jdField_h_of_type_Int = 114;
      localAllInOne1.n = str2;
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, localAllInOne1);
      if (!QLog.isDevelopLevel()) {
        break label329;
      }
      QLog.i("JumpAction", 4, String.format(Locale.getDefault(), "gotoCampusCircleCard uin: %s  name: %s source: %s", new Object[] { Utils.b(str1), Utils.b(str2), str3 }));
      return false;
    }
    label329:
    return false;
  }
  
  private boolean ao()
  {
    try
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      long l1 = Long.parseLong(str1);
      if (l1 < 10000L)
      {
        if (!QLog.isColorLevel()) {
          break label302;
        }
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard invalid uin uin: %d", new Object[] { Long.valueOf(l1) }));
        return false;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("name");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
      localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(str1);
      if (!Utils.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label236;
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
        label236:
        ProfileActivity.AllInOne localAllInOne2;
        if ((localFriends != null) && (localFriends.isFriend()))
        {
          localAllInOne2 = new ProfileActivity.AllInOne(str1, 1);
          localAllInOne2.jdField_h_of_type_JavaLangString = localFriends.name;
          localAllInOne2.i = localFriends.remark;
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
      QLog.i("JumpAction", 4, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard uin: %s  name: %s source: %s", new Object[] { Utils.b(str1), Utils.b(str2), str3 }));
      return false;
    }
    label302:
    return false;
  }
  
  private boolean ap()
  {
    boolean bool = false;
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (Boolean.parseBoolean((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_add_friend")))
    {
      bool = b((String)localObject1);
      return bool;
    }
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpa");
    if ("internal_phone".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type")))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007014", "0X8007014", 0, 0, "", "", "", "");
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 53);
      ((ProfileActivity.AllInOne)localObject1).k = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname"));
      ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 105;
    }
    for (;;)
    {
      Friends localFriends = null;
      localObject2 = localFriends;
      int i1;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type"))
      {
        localObject2 = localFriends;
        if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("from_type")))
        {
          localObject2 = localFriends;
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msg_uniseq"))
          {
            i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"));
            String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("msg_uniseq");
            localObject2 = localFriends;
            if (i1 == 100)
            {
              localObject2 = localFriends;
              if (Utils.b(str))
              {
                localObject2 = new Bundle();
                ((Bundle)localObject2).putBoolean("from_babyq", true);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007241", "0X8007241", 0, 0, "", "", "", "");
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("colorScreen")) {
        ((ProfileActivity.AllInOne)localObject1).f = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("colorScreen"));
      }
      ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, (Bundle)localObject2);
      return true;
      if ((localObject1 == null) || ("".equals(localObject1)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject1)))
      {
        localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      }
      else
      {
        if (((String)localObject1).length() < 5) {
          break;
        }
        localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c((String)localObject1);
        if ((localFriends != null) && (localFriends.isFriend()))
        {
          localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
          ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = localFriends.name;
          ((ProfileActivity.AllInOne)localObject1).i = localFriends.remark;
        }
        else
        {
          if (this.jdField_b_of_type_Boolean)
          {
            localObject1 = new ProfileActivity.AllInOne((String)localObject1, 3);
            if ("1".equals(localObject2)) {}
            for (i1 = 1;; i1 = 0)
            {
              ((ProfileActivity.AllInOne)localObject1).d = i1;
              break;
            }
          }
          localObject1 = new ProfileActivity.AllInOne((String)localObject1, 78);
        }
      }
    }
  }
  
  private boolean aq()
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
          break label181;
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
      label181:
      do
      {
        return bool;
      } while (str.length() < 5);
      if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(str)) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
  
  private boolean ar()
  {
    boolean bool2 = false;
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wSourceSubID");
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
              ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str2);
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
          try
          {
            i1 = Integer.parseInt(str1);
            ((Bundle)localObject1).putInt("troop_info_from_ex", i1);
            if (i1 != 33) {
              break label595;
            }
            ((Bundle)localObject1).putInt("troop_info_from", 24);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              int i1;
              Object localObject2;
              if (QLog.isColorLevel())
              {
                QLog.d("JumpAction", 2, "cast source sub id from web error, sourceSubId = " + str1);
                continue;
                if (i1 == 37) {
                  localObject2.putInt("troop_info_from", 30);
                }
              }
            }
          }
          if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"))) && (Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type")) == 100))
          {
            ((Bundle)localObject1).putBoolean("from_babyq", true);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007245", "0X8007245", 0, 0, "", "", "", "");
          }
          ((Bundle)localObject1).putString("authKey", (String)this.jdField_a_of_type_JavaUtilHashMap.get("authKey"));
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("authKey")) {
            ((Bundle)localObject1).putString("authKey", (String)this.jdField_a_of_type_JavaUtilHashMap.get("authKey"));
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
            ((Bundle)localObject1).putString("appid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) {
            ((Bundle)localObject1).putString("openid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid"));
          }
          ChatSettingForTroop.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, 2);
          return true;
          localObject1 = TroopInfoActivity.a(str2, 5);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          localObject2 = localObject3;
          continue;
          label595:
          if (i1 == 36) {
            localObject2.putInt("troop_info_from", 27);
          }
        }
      }
    }
  }
  
  private boolean as()
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
      ((Bundle)localObject).putString("openid", d(j));
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
    ChatSettingForTroop.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject, 2);
    return true;
  }
  
  /* Error */
  private boolean at()
  {
    // Byte code:
    //   0: ldc 56
    //   2: astore 14
    //   4: ldc 56
    //   6: astore 19
    //   8: ldc 56
    //   10: astore 17
    //   12: ldc 56
    //   14: astore 10
    //   16: ldc 56
    //   18: astore 18
    //   20: aload_0
    //   21: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: ldc_w 611
    //   27: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 45	java/lang/String
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   38: ldc_w 3040
    //   41: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 45	java/lang/String
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   52: ldc_w 559
    //   55: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: checkcast 45	java/lang/String
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   66: ldc_w 3042
    //   69: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
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
    //   114: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   117: ldc_w 3044
    //   120: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast 45	java/lang/String
    //   126: ldc_w 1686
    //   129: invokestatic 1806	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   175: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   178: ldc_w 3046
    //   181: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: checkcast 45	java/lang/String
    //   187: ldc_w 1686
    //   190: invokestatic 1806	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   236: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   239: ldc_w 3048
    //   242: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   245: checkcast 45	java/lang/String
    //   248: ldc_w 1686
    //   251: invokestatic 1806	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   297: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   300: ldc_w 3050
    //   303: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast 45	java/lang/String
    //   309: ldc_w 1686
    //   312: invokestatic 1806	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   358: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   361: ldc_w 3052
    //   364: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   367: checkcast 45	java/lang/String
    //   370: ldc_w 1686
    //   373: invokestatic 1806	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   419: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   422: ldc_w 3054
    //   425: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   428: checkcast 45	java/lang/String
    //   431: ldc_w 1686
    //   434: invokestatic 1806	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   472: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifne +11 -> 486
    //   478: aload 7
    //   480: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifeq +129 -> 612
    //   486: iconst_0
    //   487: ireturn
    //   488: astore 9
    //   490: ldc 56
    //   492: astore 10
    //   494: ldc 56
    //   496: astore_1
    //   497: ldc 56
    //   499: astore_3
    //   500: ldc 56
    //   502: astore 6
    //   504: ldc 56
    //   506: astore 5
    //   508: ldc 56
    //   510: astore 4
    //   512: ldc 56
    //   514: astore 8
    //   516: ldc 56
    //   518: astore 7
    //   520: ldc 56
    //   522: astore_2
    //   523: aload 9
    //   525: invokevirtual 1108	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   528: aload 8
    //   530: astore 9
    //   532: aload 5
    //   534: astore 8
    //   536: aload_2
    //   537: astore 5
    //   539: aload_1
    //   540: astore_2
    //   541: ldc 56
    //   543: astore_1
    //   544: aload_3
    //   545: astore 11
    //   547: goto -77 -> 470
    //   550: astore 9
    //   552: ldc 56
    //   554: astore 10
    //   556: ldc 56
    //   558: astore_1
    //   559: ldc 56
    //   561: astore_3
    //   562: ldc 56
    //   564: astore 6
    //   566: ldc 56
    //   568: astore 5
    //   570: ldc 56
    //   572: astore 4
    //   574: ldc 56
    //   576: astore 8
    //   578: ldc 56
    //   580: astore 7
    //   582: ldc 56
    //   584: astore_2
    //   585: aload 9
    //   587: invokevirtual 3055	java/lang/NullPointerException:printStackTrace	()V
    //   590: aload 8
    //   592: astore 9
    //   594: aload 5
    //   596: astore 8
    //   598: aload_2
    //   599: astore 5
    //   601: aload_1
    //   602: astore_2
    //   603: ldc 56
    //   605: astore_1
    //   606: aload_3
    //   607: astore 11
    //   609: goto -139 -> 470
    //   612: aload_0
    //   613: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   616: ifnull +171 -> 787
    //   619: new 153	android/content/Intent
    //   622: dup
    //   623: aload_0
    //   624: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   627: ldc_w 3057
    //   630: invokespecial 158	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   633: astore_3
    //   634: aload_3
    //   635: ldc_w 3059
    //   638: aload 7
    //   640: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   643: pop
    //   644: aload_3
    //   645: ldc_w 3061
    //   648: new 254	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   655: ldc 56
    //   657: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload 6
    //   662: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokevirtual 178	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   671: pop
    //   672: ldc_w 2064
    //   675: aload 10
    //   677: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   680: ifeq +139 -> 819
    //   683: aload_3
    //   684: ldc_w 3063
    //   687: iconst_0
    //   688: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   691: pop
    //   692: new 456	android/os/Bundle
    //   695: dup
    //   696: invokespecial 457	android/os/Bundle:<init>	()V
    //   699: astore 6
    //   701: aload 6
    //   703: ldc_w 3040
    //   706: aload 4
    //   708: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: aload 6
    //   713: ldc_w 3044
    //   716: aload 11
    //   718: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   721: aload 6
    //   723: ldc_w 3046
    //   726: aload 9
    //   728: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   731: aload 6
    //   733: ldc_w 3048
    //   736: aload 8
    //   738: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: aload 6
    //   743: ldc_w 3050
    //   746: aload 5
    //   748: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload 6
    //   753: ldc_w 3052
    //   756: aload_2
    //   757: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload 6
    //   762: ldc_w 3054
    //   765: aload_1
    //   766: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   769: aload_3
    //   770: ldc_w 861
    //   773: aload 6
    //   775: invokevirtual 488	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   778: pop
    //   779: aload_0
    //   780: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   783: aload_3
    //   784: invokevirtual 173	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   787: aload_0
    //   788: getfield 90	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   791: ldc_w 990
    //   794: ldc 56
    //   796: ldc 56
    //   798: ldc_w 3065
    //   801: ldc_w 3065
    //   804: iconst_0
    //   805: iconst_0
    //   806: ldc 56
    //   808: ldc 56
    //   810: ldc 56
    //   812: ldc 56
    //   814: invokestatic 320	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   817: iconst_1
    //   818: ireturn
    //   819: aload_3
    //   820: ldc_w 3063
    //   823: bipush 6
    //   825: invokevirtual 162	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   828: pop
    //   829: goto -137 -> 692
    //   832: astore 9
    //   834: ldc 56
    //   836: astore_1
    //   837: ldc 56
    //   839: astore 4
    //   841: ldc 56
    //   843: astore 6
    //   845: ldc 56
    //   847: astore 5
    //   849: ldc 56
    //   851: astore 11
    //   853: ldc 56
    //   855: astore 8
    //   857: ldc 56
    //   859: astore 7
    //   861: ldc 56
    //   863: astore_2
    //   864: aload_3
    //   865: astore 10
    //   867: aload 4
    //   869: astore_3
    //   870: aload 11
    //   872: astore 4
    //   874: goto -289 -> 585
    //   877: astore 9
    //   879: ldc 56
    //   881: astore_2
    //   882: ldc 56
    //   884: astore 4
    //   886: ldc 56
    //   888: astore 8
    //   890: aload_1
    //   891: astore 7
    //   893: ldc 56
    //   895: astore_1
    //   896: ldc 56
    //   898: astore 11
    //   900: ldc 56
    //   902: astore 5
    //   904: ldc 56
    //   906: astore 6
    //   908: aload_3
    //   909: astore 10
    //   911: aload 11
    //   913: astore_3
    //   914: goto -329 -> 585
    //   917: astore 9
    //   919: ldc 56
    //   921: astore 5
    //   923: aload_2
    //   924: astore 6
    //   926: ldc 56
    //   928: astore_2
    //   929: ldc 56
    //   931: astore 4
    //   933: ldc 56
    //   935: astore 8
    //   937: aload_1
    //   938: astore 7
    //   940: ldc 56
    //   942: astore_1
    //   943: ldc 56
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
    //   1005: ldc 56
    //   1007: astore_1
    //   1008: ldc 56
    //   1010: astore 4
    //   1012: ldc 56
    //   1014: astore 6
    //   1016: ldc 56
    //   1018: astore 5
    //   1020: ldc 56
    //   1022: astore 11
    //   1024: ldc 56
    //   1026: astore 8
    //   1028: ldc 56
    //   1030: astore 7
    //   1032: ldc 56
    //   1034: astore_2
    //   1035: aload_3
    //   1036: astore 10
    //   1038: aload 4
    //   1040: astore_3
    //   1041: aload 11
    //   1043: astore 4
    //   1045: goto -522 -> 523
    //   1048: astore 9
    //   1050: ldc 56
    //   1052: astore_2
    //   1053: ldc 56
    //   1055: astore 4
    //   1057: ldc 56
    //   1059: astore 8
    //   1061: aload_1
    //   1062: astore 7
    //   1064: ldc 56
    //   1066: astore_1
    //   1067: ldc 56
    //   1069: astore 11
    //   1071: ldc 56
    //   1073: astore 5
    //   1075: ldc 56
    //   1077: astore 6
    //   1079: aload_3
    //   1080: astore 10
    //   1082: aload 11
    //   1084: astore_3
    //   1085: goto -562 -> 523
    //   1088: astore 9
    //   1090: ldc 56
    //   1092: astore 5
    //   1094: aload_2
    //   1095: astore 6
    //   1097: ldc 56
    //   1099: astore_2
    //   1100: ldc 56
    //   1102: astore 4
    //   1104: ldc 56
    //   1106: astore 8
    //   1108: aload_1
    //   1109: astore 7
    //   1111: ldc 56
    //   1113: astore_1
    //   1114: ldc 56
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
  
  private boolean au()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QRJumpActivity.class);
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    localIntent.putExtra("url", str1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean av()
  {
    if ("webview".equals(this.m))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bus_type");
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "photo").putExtra("doCallBack", true).putExtra("src_type", this.f).putExtra("callback_type", this.g).putExtra("callback_name", this.jdField_h_of_type_JavaLangString));
    }
    return true;
  }
  
  private boolean aw()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BindGroupActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("skey", ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label164:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label164;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localIntent.putExtra("key_params", localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean ax()
  {
    System.currentTimeMillis();
    Object localObject3 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if ((localObject3 == null) || ((!((String)localObject3).startsWith("http://")) && (!((String)localObject3).startsWith("https://"))) || ((!Util.b((String)localObject3).equalsIgnoreCase("qq.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("myun.tenpay.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("tenpay.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("wanggou.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("tencent.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("jd.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("qcloud.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("webank.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("qqumall.com")))) {
      return false;
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("style");
    String str1 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
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
        break label2052;
      }
      localStringBuffer.append("plg_auth=1");
      localStringBuffer.append("&");
    }
    label2052:
    for (int i1 = 1;; i1 = 0)
    {
      if ("1".equals(str3))
      {
        localStringBuffer.append("plg_dev=1");
        localStringBuffer.append("&");
        localStringBuffer.append("MOBINFO=");
        localStringBuffer.append(HexUtil.a(((Cryptor)localObject3).encrypt(b().getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      if ("1".equals(str4))
      {
        localStringBuffer.append("plg_usr=1");
        localStringBuffer.append("&");
        localStringBuffer.append("USER=");
        localStringBuffer.append(HexUtil.a(((Cryptor)localObject3).encrypt("黑".getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      int i2 = i1;
      if ("1".equals(str5))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        i2 = i1;
        if (localObject3 != null)
        {
          localStringBuffer.append("plg_vkey=1").append("&mqqvkey=").append((String)localObject3).append("&");
          i2 = 1;
        }
      }
      if ((this.o != null) && (this.o.length() > 0)) {
        localStringBuffer.append(this.o + "&");
      }
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
            return C();
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
          if (this.jdField_a_of_type_JavaUtilHashMap.get("actionnamekey") != null)
          {
            i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("actionnamekey"));
            switch (i1)
            {
            default: 
              return true;
            case 0: 
              this.jdField_c_of_type_JavaLangString = "opencontent";
            }
          }
          for (;;)
          {
            return C();
            i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("type"));
            break;
            this.jdField_c_of_type_JavaLangString = "openVideo";
            continue;
            this.jdField_c_of_type_JavaLangString = "opentopic";
            continue;
            this.jdField_c_of_type_JavaLangString = "infoCard";
          }
        }
      }
      else if (((String)localObject1).contains("lbs.qidian.qq.com/authorize/voiceShow"))
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
          ((Intent)localObject3).putExtra("leba_resid", Long.parseLong(a("leba_resid")));
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
      if ((this.n == null) || (!this.n.trim().equalsIgnoreCase("com.tx.android.txnews.new")))
      {
        if ((this.n != null) && (this.n.trim().equalsIgnoreCase("com.qq.yijianfankui")))
        {
          localStringBuffer.append("&version=7.6.8.3615");
          localStringBuffer.append("&appid=" + AppSetting.jdField_a_of_type_Int);
          localStringBuffer.append("&QUA=" + QUA.a());
          localStringBuffer.append("&adtag=3615");
          localObject2 = Build.MODEL;
          if (localObject2 == null) {
            break label1903;
          }
          localObject2 = ((String)localObject2).replaceAll(" ", "_");
        }
        for (;;)
        {
          i1 = StatisticCollector.a();
          localObject3 = localObject2;
          if (i1 > 0) {
            localObject3 = (String)localObject2 + "_qzpatch" + i1;
          }
          localObject2 = Build.MANUFACTURER;
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            localStringBuffer.append("&model=").append((String)localObject3).append("&manufacture=").append((String)localObject2).append("&cpunum=").append(DeviceInfoUtil.b()).append("&cpurate=").append(DeviceInfoUtil.a()).append("&mem=").append(DeviceInfoUtil.e() / 1024L / 1024L).append("&w=").append(DeviceInfoUtil.h()).append("&h=").append(DeviceInfoUtil.i());
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
          try
          {
            ((Intent)localObject2).putExtra("leba_resid", Long.parseLong(a("leba_resid")));
            ((Intent)localObject2).putExtra("has_red_dot", this.jdField_d_of_type_Boolean);
            ((Intent)localObject2).putExtra("is_from_leba", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            return true;
            label1903:
            localObject2 = "";
            continue;
            localObject2 = "";
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
        }
      }
      Object localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class).putExtra("url", localStringBuffer.toString());
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
  }
  
  private boolean ay()
  {
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str6 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str7 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str8 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    d((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    String str9 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str10 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str11 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_to_qq_ark_info"));
    String str12 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chSrc");
    if (!TextUtils.isEmpty(this.n)) {}
    label566:
    label1104:
    String str2;
    for (String str1 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; str2 = null)
    {
      String str4 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
      String str17 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      String str13 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
      String str14 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      String str15 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
      String str16 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
      int i2;
      try
      {
        i2 = Integer.valueOf(d((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
        if (i2 == 1)
        {
          c("shareToQQ");
          return true;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          i2 = 0;
        }
      }
      try
      {
        l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
        localObject3 = null;
        localBundle = new Bundle();
        localBundle.putBoolean("is_ark_display_share", false);
        if (!TextUtils.isEmpty(str11)) {
          try
          {
            Object localObject4 = new JSONObject(str11);
            localObject1 = ((JSONObject)localObject4).optString("app");
            String str3 = ((JSONObject)localObject4).optString("view");
            String str18 = ((JSONObject)localObject4).optString("meta");
            localObject4 = ((JSONObject)localObject4).optString("config");
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str18))) {
              if (a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, Long.valueOf(l1)))
              {
                localBundle.putBoolean("is_ark_display_share", true);
                localObject1 = ArkFullScreenAppActivity.a(this.jdField_a_of_type_AndroidContentContext, str3, (String)localObject1, str18, (String)localObject4, String.valueOf(l1), this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity);
              }
            }
          }
          catch (JSONException localJSONException2)
          {
            Object localObject1;
            localObject2 = localObject3;
            localObject3 = localJSONException2;
          }
        }
        try
        {
          ArkAppCenter.b("JumpAction", "gotoShareArkMsg, ark appInfo is parse success");
          i1 = 0;
          if (i1 == 0) {
            continue;
          }
          localObject1 = new Intent();
          localBundle.putBoolean("forward_ark_from_sdk", false);
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            int i3;
            boolean bool;
            continue;
            str2 = "";
          }
          break label566;
        }
        if (l1 <= 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "gotoShareMsg appid = " + l1);
          }
          return false;
        }
      }
      catch (Exception localException2)
      {
        long l1;
        Bundle localBundle;
        int i1;
        Object localObject2;
        for (;;)
        {
          Object localObject3;
          l1 = 0L;
          continue;
          i1 = 1;
          ArkAppCenter.b("JumpAction", "gotoShareArkMsg, appInfo is not exist in white list");
          localObject2 = null;
          continue;
          i1 = 1;
          ArkAppCenter.b("JumpAction", "gotoShareArkMsg, appName or appView or appMeta is empty");
          localObject2 = null;
          continue;
          i1 = 1;
          ArkAppCenter.b("JumpAction", String.format("gotoShareArkMsg, parse json failed, err=%s", new Object[] { localObject3.getMessage() }));
          continue;
          ArkAppCenter.b("JumpAction", "gotoShareArkMsg, appInfo is empty");
          i1 = 1;
          localObject2 = null;
        }
        if (("news".equals(str5)) || ("audio".equals(str5)))
        {
          localBundle.putString("title", str7);
          localBundle.putString("desc", str8);
          localBundle.putString("image_url", str6);
          localBundle.putString("detail_url", str9);
          localBundle.putString("chSrc", str12);
          localBundle.putInt("forward_type", 11);
          localBundle.putLong("req_share_id", l1);
          localBundle.putString("pkg_name", this.n);
          localBundle.putString("image_url_remote", str10);
          localBundle.putString("app_name", str1);
          localBundle.putString("open_id", str17);
          localBundle.putString("shareArkInfo", str11);
          localBundle.putString("chSrc", str12);
          if (str7 != null) {
            break label1104;
          }
          if (TextUtils.isEmpty(str1)) {
            continue;
          }
          localBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131430119, new Object[] { str1 }));
        }
        for (;;)
        {
          localBundle.putString("share_uin", str14);
          localBundle.putString("jfrom", str15);
          localBundle.putString("share_qq_ext_str", str16);
          localBundle.putInt("cflag", i2);
          localBundle.putInt("emoInputType", 2);
          i3 = 1;
          try
          {
            i1 = Integer.valueOf(str13).intValue();
            if (i1 == 2) {
              localBundle.putString("audio_url", str4);
            }
            localBundle.putInt("req_type", i1);
            localBundle.putBoolean("k_dataline", false);
            localBundle.putBoolean("k_favorites", true);
            localBundle.putBoolean("k_cancel_button", true);
            if (((i2 & 0x2) == 0) && (!"com.qzone".equals(this.n)))
            {
              bool = true;
              localBundle.putBoolean("k_qzone", bool);
              if ((!bool) || ((i2 & 0x1) == 0)) {
                break label1165;
              }
              bool = true;
              localBundle.putBoolean("k_send", bool);
              localBundle.putInt("iUrlInfoFrm", 4);
              if (localObject2 != null)
              {
                localObject2.putExtras(localBundle);
                com.tencent.mobileqq.app.PhoneContactManagerImp.g = true;
                ForwardBaseOption.a(this.jdField_a_of_type_AndroidContentContext, localObject2);
              }
              return true;
              localBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131430119, new Object[] { str7 }));
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              i1 = i3;
              if (QLog.isColorLevel())
              {
                QLog.d("QQShare", 2, "NumberFormatException req_type = 1");
                i1 = i3;
                continue;
                bool = false;
                continue;
                label1165:
                bool = false;
              }
            }
          }
        }
      }
    }
  }
  
  private boolean az()
  {
    Object localObject = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str1 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("fopen_id"));
    String str2 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("friend_label"));
    String str3 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("add_msg"));
    String str4 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str5 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
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
  
  private String b()
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.MODEL;
    String str3 = QQDeviceInfo.a("0db4c4");
    String str4 = QQDeviceInfo.b("0db4c4");
    Object localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay();
    int i1 = ((Display)localObject).getHeight();
    int i2 = ((Display)localObject).getWidth();
    localObject = i2 + "*" + i1;
    i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid();
    return str1 + "|" + str2 + "|" + str3 + "|" + (String)localObject + "|" + str4 + "|" + i1 + "|";
  }
  
  public static String b(String paramString)
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
  
  private void b()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_weishi_feeds_plugin.apk");
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap paramHashMap)
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
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap paramHashMap, String paramString)
  {
    String str4 = (String)paramHashMap.get("videoOwnerUin");
    String str5 = (String)paramHashMap.get("unionid");
    String str2 = (String)paramHashMap.get("fromId");
    String str3 = (String)paramHashMap.get("videoId");
    String str7 = (String)paramHashMap.get("type");
    String str1 = (String)paramHashMap.get("videoList");
    int i4 = a(paramHashMap);
    String str6 = (String)paramHashMap.get("feedid");
    a(paramHashMap, "ptype", 0);
    str1 = str3;
    if (str3 == null) {
      str1 = (String)paramHashMap.get("videoid");
    }
    int i2;
    label156:
    int i3;
    if (str2 == null)
    {
      str2 = (String)paramHashMap.get("fromid");
      if ((str7 == null) || (!str7.equals("mylist"))) {
        break label915;
      }
      i2 = 1;
      if ((str7 == null) || (!str7.equals("myonedaylist"))) {
        break label921;
      }
      i3 = 1;
      label175:
      if (!"0".equals(paramHashMap.get("identify"))) {
        break label927;
      }
    }
    label408:
    label921:
    label927:
    for (int i1 = 0;; i1 = 1)
    {
      try
      {
        if ("17".equals(str2))
        {
          if (i2 == 0) {
            break label292;
          }
          StoryReportor.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", str1 });
        }
        for (;;)
        {
          if (i3 == 0) {
            break label507;
          }
          paramQQAppInterface = (String)paramHashMap.get("collection_id");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            break label408;
          }
          if (TextUtils.isEmpty(str5)) {
            break;
          }
          StoryPlayVideoActivity.a(paramActivity, str5, str1, i4, str6, i1);
          break label913;
          label292:
          StoryReportor.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", str1 });
        }
        if (TextUtils.isEmpty(str4)) {
          break label933;
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, videoOwnerUin:" + str4 + ",e:" + QLog.getStackTraceString(paramQQAppInterface));
        }
        return false;
      }
      StoryPlayVideoActivity.a(paramActivity, Long.parseLong(str4), str1, i4, str6, i1);
      break label913;
      paramHashMap = (String)paramHashMap.get("time_zone");
      i2 = -1;
      if (!TextUtils.isEmpty(paramHashMap)) {
        i2 = Integer.valueOf(paramHashMap).intValue();
      }
      if (!TextUtils.isEmpty(str5))
      {
        StoryPlayVideoActivity.a(paramActivity, str5, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str5), i2, i4, str6, i1);
      }
      else
      {
        if (TextUtils.isEmpty(str4)) {
          break label935;
        }
        paramQQAppInterface = VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str4);
        StoryPlayVideoActivity.a(paramActivity, Long.parseLong(str4), paramQQAppInterface, i2, i4, str6, i1);
        break label913;
        label507:
        if ("17".equals(str2))
        {
          if (i2 != 0)
          {
            paramQQAppInterface = (String)paramHashMap.get("et");
            paramHashMap = (String)paramHashMap.get("time_zone");
            i2 = -1;
            if (!TextUtils.isEmpty(paramHashMap)) {
              i2 = Integer.valueOf(paramHashMap).intValue();
            }
            if (!TextUtils.isEmpty(str5))
            {
              StoryPlayVideoActivity.a(paramActivity, str5, paramQQAppInterface, "我的一天", i2, i4, str6, i1);
              break label937;
            }
            if (TextUtils.isEmpty(str4)) {
              break label939;
            }
            StoryPlayVideoActivity.a(paramActivity, Long.parseLong(str4), paramQQAppInterface, "我的一天", i2, i4, str6, i1);
            break label937;
          }
          if ((!TextUtils.isEmpty(str7)) && (str7.equals(String.valueOf(1))))
          {
            if (!TextUtils.isEmpty(str5))
            {
              StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, str5, i4, str6, i1);
              break label937;
            }
            if (TextUtils.isEmpty(str4)) {
              break label941;
            }
            StoryPlayVideoActivity.b(paramQQAppInterface, paramActivity, str1, Long.parseLong(str4), i4, str6, i1);
            break label937;
          }
          if ("onedaylist".equals(str7))
          {
            StoryPlayVideoActivity.a(paramActivity, str5, str6, i1, i4);
            break label937;
          }
          if (!TextUtils.isEmpty(str5))
          {
            StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, str5, 11, i4, str6, i1);
            break label937;
          }
          if (TextUtils.isEmpty(str4)) {
            break label943;
          }
          StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, Long.parseLong(str4), 11, i4, str6, i1);
          break label937;
        }
        if (!TextUtils.isEmpty(paramString))
        {
          if (!TextUtils.isEmpty(str5))
          {
            StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, str5, 12, i4, str6, i1);
            break label937;
          }
          if (TextUtils.isEmpty(str4)) {
            break label945;
          }
          StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, Long.parseLong(str4), 12, i4, str6, i1);
          break label937;
        }
        if (!TextUtils.isEmpty(str5))
        {
          StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, str5, 5, i4, str6, i1);
          break label937;
        }
        if (!TextUtils.isEmpty(str4))
        {
          StoryPlayVideoActivity.a(paramQQAppInterface, paramActivity, str1, Long.parseLong(str4), 5, i4, str6, i1);
          break label937;
        }
        return false;
        break;
      }
      return true;
      i2 = 0;
      break label156;
      i3 = 0;
      break label175;
    }
    label913:
    label915:
    label933:
    return false;
    label935:
    return false;
    label937:
    return true;
    label939:
    return false;
    label941:
    return false;
    label943:
    return false;
    label945:
    return false;
  }
  
  private boolean b(String paramString)
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
    label160:
    String str3;
    if (this.jdField_a_of_type_JavaUtilHashMap.get("kfuin") != null)
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("kfuin");
      if (this.jdField_a_of_type_JavaUtilHashMap.get("extuin") == null) {
        break label343;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extuin");
      if (this.jdField_a_of_type_JavaUtilHashMap.get("name") == null) {
        break label350;
      }
      str2 = d(((String)this.jdField_a_of_type_JavaUtilHashMap.get("name")).replace(" ", "+"));
      QidianHandler localQidianHandler = (QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
      boolean bool = false;
      if (this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag") == null) {
        break label357;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag");
      label204:
      if (!TextUtils.isEmpty(str3)) {
        bool = QidianManager.b(Integer.valueOf(str3).intValue());
      }
      localQidianHandler.a(str4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, str1, paramString, bool);
      localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((localObject == null) || (!((FriendsManager)localObject).b(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label364;
      }
      localObject = new ProfileCardInfo();
      ((ProfileCardInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramString, 1);
      ((ProfileCardInfo)localObject).jdField_a_of_type_ArrayOfJavaLangString = new String[7];
      ((ProfileCardInfo)localObject).jdField_a_of_type_ArrayOfJavaLangString[4] = str2;
      FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileCardInfo)localObject);
    }
    for (;;)
    {
      return true;
      localObject = "";
      break;
      label343:
      str1 = "";
      break label119;
      label350:
      str2 = "";
      break label160;
      label357:
      str3 = "";
      break label204;
      label364:
      paramString = AddFriendLogicActivity.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, paramString, null, 3999, 0, str2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131433712), null);
      paramString.putExtra("webImVisitId", str4);
      paramString.putExtra("webim_qd_ext", true);
      if (BaseActivity.sTopActivity == null) {
        paramString.putExtra("need_jumpto_splash", true);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
    }
  }
  
  private boolean ba()
  {
    Object localObject2 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
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
            ToastUtil.a().a(this.jdField_a_of_type_AndroidContentContext.getString(2131427815));
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
  
  private boolean bb()
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
  
  private boolean bc()
  {
    Object localObject = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("friendUin"));
    localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, "", 3001, 0, "", "", null, "", "");
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean bd()
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
  
  private boolean be()
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
      return bg();
    }
    if ("opentopic".equals(this.jdField_c_of_type_JavaLangString)) {
      return bf();
    }
    if ("infoCard".equals(this.jdField_c_of_type_JavaLangString)) {
      return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    if ("sharegroupcard".equals(this.jdField_c_of_type_JavaLangString)) {
      return b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    Object localObject = new QQStoryHomeJumpHelper((Activity)this.jdField_a_of_type_AndroidContentContext, new akka(this));
    Intent localIntent = e(new Intent());
    if (localIntent != null)
    {
      int i1 = localIntent.getIntExtra("action", 0);
      localIntent.putExtra("action", 0);
      return ((QQStoryHomeJumpHelper)localObject).a(i1, localIntent);
    }
    return false;
  }
  
  private boolean bf()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname");
    String str3 = b((String)this.jdField_a_of_type_JavaUtilHashMap.get("sharefromtype"));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      try
      {
        StoryDiscoverActivity.a(localActivity, Long.parseLong(str1), str2, null, str3, 3);
        return true;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoStoryTopic, topicId:" + str1);
        }
      }
    }
    return false;
  }
  
  private boolean bg()
  {
    if (!TextUtils.isEmpty(b((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api")))) {
      StoryReportor.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      if ("1".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"))) {}
      for (;;)
      {
        return true;
        StoryDiscoverActivity.a(localActivity, "", 3);
      }
    }
    return false;
  }
  
  private boolean bh()
  {
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean)
    {
      SLog.b("JumpAction", "startStoryMainActivity, isNowTabShow==true");
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.f);
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
      localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
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
      localIntent = a();
    }
  }
  
  private boolean bi()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoARMap");
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ARMapLoadingActivity.class);
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("service_id");
    if ((!TextUtils.isEmpty(str1)) && (str1.equals("1")))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("location");
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nick");
      String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("pid");
      String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("status");
      String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("md5");
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "location:" + str1 + ", nick:" + str2 + ", pid:" + str3 + ", uin:" + str5 + ", status:" + str4);
      }
      localObject = ((ARMapConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(189)).a();
      if ((localObject == null) || (!((ARMapConfig)localObject).isWealthGodEnterOpen()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), "神秘功能上线中，敬请期待哦。", 1).a();
        return false;
      }
      localIntent.putExtra("entrance_type", 1);
      localIntent.putExtra("location", str1);
      localIntent.putExtra("nick", str2);
      localIntent.putExtra("pid", str3);
      localIntent.putExtra("status", str4);
      localIntent.putExtra("uin", str5);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      localIntent.putExtra("entrance_from", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      localIntent.putExtra("entrance_type", 0);
    }
  }
  
  private boolean bj()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80077DE", "0X80077DE", 0, 0, (String)localObject, "", "", "");
    int i1 = BaseApplicationImpl.getApplication().appActivities.size() - 1;
    if (i1 >= 0)
    {
      localObject = (WeakReference)BaseApplicationImpl.getApplication().appActivities.get(i1);
      if (localObject != null)
      {
        localObject = (AppActivity)((WeakReference)localObject).get();
        label85:
        if (localObject == null) {
          break label237;
        }
        localObject = ((Activity)localObject).getLocalClassName();
        if (!"activity.RegisterPersonalInfoActivity".equals(localObject)) {
          break label152;
        }
        localObject = RegisterPersonalInfoActivity.class;
      }
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
      if (RegisterPhoneNumActivity.class == localObject) {
        localIntent.putExtra("key_report_extra_from", 5);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      localObject = null;
      break label85;
      label152:
      if ("activity.RegisterChooseLoginActivity".equals(localObject))
      {
        localObject = RegisterChooseLoginActivity.class;
      }
      else if ("activity.RegisterVerifyCodeActivity".equals(localObject))
      {
        localObject = RegisterVerifyCodeActivity.class;
      }
      else if ("activity.RegisterByNicknameAndPwdActivity".equals(localObject))
      {
        localObject = RegisterByNicknameAndPwdActivity.class;
      }
      else if ("activity.RegisterSendUpSms".equals(localObject))
      {
        localObject = RegisterSendUpSms.class;
      }
      else if ("activity.RegisterPhoneNumActivity".equals(localObject))
      {
        localObject = RegisterPhoneNumActivity.class;
      }
      else
      {
        label237:
        i1 -= 1;
        break;
        localObject = RegisterPhoneNumActivity.class;
      }
    }
  }
  
  private boolean bk()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("troopUin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("evilUin");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("selfUin");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("scene");
    int i2 = 1101;
    int i1 = i2;
    if (str4 != null) {}
    try
    {
      i1 = Integer.parseInt(str4);
      ProfileCardUtil.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, str2, str1, str3, i1, null);
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
  
  private boolean bl()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomcode");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isgroupcode");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("backtype");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extra");
    GroupVideoManager localGroupVideoManager = (GroupVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235);
    try
    {
      i1 = Integer.parseInt(str3);
      QLog.i("JumpAction", 1, "[goToGroupVideoPlugin], roomId:" + str1 + ",fromId:" + str2 + " isGroupCode:" + str3);
      localGroupVideoManager.a(this.jdField_a_of_type_AndroidContentContext, str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), i1, "download", str2, str4, str5, str6);
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
  
  private boolean bm()
  {
    i1 = 0;
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("guin");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!TroopInfo.isTroopMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("JumpAction", 2, new Object[] { "illegal goToTroopProfileApp jumpAction. troopUin=", localObject });
      }
      return false;
    }
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
    if ("group_file".equals(str)) {
      ChatSettingForTroop.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject);
    }
    for (;;)
    {
      return true;
      if ("group_album".equals(str)) {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gname");
      }
      try
      {
        i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("unreadnum"));
        i1 = i2;
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        int i2;
        label156:
        break label156;
      }
      ChatSettingForTroop.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject, str, i1);
      continue;
      if ("group_story".equals(str)) {
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
                label306:
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
              localObject = QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, null, (String)localObject, i2, i3);
              ((Intent)localObject).putExtra("extra_last_open_from", i4);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              i2 = i1;
              i1 = i3;
              break label306;
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
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gc");
      localBundle = new Bundle();
      localBundle.putString("extra.GROUP_UIN", (String)localObject);
      localBundle.putString("selfSet_leftViewText", "取消");
      BulkSendMessageFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, localBundle);
    }
  }
  
  private boolean bn()
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, 0, 2130968709, 17);
    localQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131438260));
    localQQProgressDialog.getWindow().setDimAmount(0.0F);
    localQQProgressDialog.show();
    localQQProgressDialog.setCanceledOnTouchOutside(true);
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app");
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.e("JumpAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen jumpAction. appName=null");
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("meta");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(120);
    localArkAppCenter.a().a(str1, "0.0.0.1", "", new akkb(this, localQQProgressDialog, str3, localArkAppCenter, str2, str1));
    return true;
  }
  
  private String c()
  {
    return "mqqapi://" + this.jdField_b_of_type_JavaLangString + "/" + this.jdField_c_of_type_JavaLangString + "?src_type=" + this.f;
  }
  
  private String c(String paramString)
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
  
  private void c()
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131437766, this.jdField_a_of_type_AndroidContentContext.getString(2131437765), 2131437767, 2131437768, new akke(this), new akkf(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private boolean c(String paramString)
  {
    String str2 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str3 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str4 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str5 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject1 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str6 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str1 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str7 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    Object localObject2 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str9 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    int i2 = 0;
    long l1;
    int i3;
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
      i3 = 1;
    }
    try
    {
      i1 = Integer.valueOf(d((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      try
      {
        for (;;)
        {
          i2 = Integer.valueOf((String)localObject2).intValue();
          if (localObject1 != null) {
            break label861;
          }
          localObject1 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
          localObject2 = new ArrayList();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject1 = ((String)localObject1).split(";");
          i3 = 0;
          while (i3 < localObject1.length)
          {
            ((ArrayList)localObject2).add(URLDecoder.decode(localObject1[i3]));
            i3 += 1;
          }
          localNumberFormatException2 = localNumberFormatException2;
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("QzoneShare", 2, "NumberFormatException extFlags = 0");
            i1 = i2;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        label683:
        label861:
        for (;;)
        {
          int i1;
          i2 = i3;
          if (QLog.isColorLevel())
          {
            QLog.d("QzoneShare", 2, "NumberFormatException req_type = 1");
            i2 = i3;
            continue;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("title", str2);
            ((Bundle)localObject1).putString("desc", str3);
            ((Bundle)localObject1).putString("app_name", str5);
            ((Bundle)localObject1).putLong("req_share_id", l1);
            ((Bundle)localObject1).putString("detail_url", str4);
            ((Bundle)localObject1).putStringArrayList("image_url", localNumberFormatException1);
            ((Bundle)localObject1).putString("pkg_name", this.n);
            ((Bundle)localObject1).putString("open_id", str1);
            ((Bundle)localObject1).putString("share_uin", str7);
            ((Bundle)localObject1).putString("jfrom", str8);
            ((Bundle)localObject1).putString("share_qq_ext_str", str9);
            ((Bundle)localObject1).putInt("cflag", i1);
            ((Bundle)localObject1).putString("share_action", paramString);
            ((Bundle)localObject1).putInt("iUrlInfoFrm", 4);
            ((Bundle)localObject1).putBoolean("thirdPartShare", true);
            if (i2 == 2) {
              ((Bundle)localObject1).putString("audio_url", str6);
            }
            ((Bundle)localObject1).putInt("req_type", i2);
            com.tencent.mobileqq.app.PhoneContactManagerImp.g = true;
            paramString = new akki(this);
            if ((i2 == 5) && ((i1 & 0x1) != 0)) {
              QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, paramString, 23);
            }
            for (;;)
            {
              if (i2 == 1) {
                paramString = "1";
              }
              try
              {
                for (;;)
                {
                  ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str1, String.valueOf(l1), "11", "12", "0", paramString, "0", "0", false);
                  paramString = new QZoneClickReport.ReportInfo();
                  paramString.jdField_c_of_type_JavaLangString = "1";
                  paramString.jdField_d_of_type_JavaLangString = "0";
                  paramString.b = 4;
                  paramString.k = "5";
                  paramString.l = "thirdApp";
                  paramString.m = "activefeed";
                  QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString);
                  paramString = new HashMap();
                  paramString.put("source_type", "5");
                  paramString.put("source_from", "thirdApp");
                  paramString.put("source_to", "activefeed");
                  StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramString, null);
                  return true;
                  QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, paramString);
                  break;
                  if (i2 == 2) {
                    paramString = "3";
                  } else if (i2 == 5) {
                    paramString = "2";
                  } else {
                    paramString = "4";
                  }
                }
              }
              catch (Exception paramString)
              {
                break label683;
              }
            }
          }
        }
      }
    }
  }
  
  private String d(String paramString)
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
  
  private void d()
  {
    Object localObject;
    String str1;
    label54:
    String str2;
    label81:
    String str3;
    label109:
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("packageName"))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("packageName");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("signareMode")) {
        break label330;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("signareMode");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
        break label336;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("timeStamp")) {
        break label342;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("timeStamp");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("resetWordMode")) {
        break label349;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("resetWordMode");
      label137:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("offerid")) {
        break label356;
      }
    }
    label330:
    label336:
    label342:
    label349:
    label356:
    for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("offerid");; str5 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "packageName : " + (String)localObject + " signatureMode :" + str1 + " appid : " + str2 + " timestamp : " + str3 + " resetWordMode : " + str4 + " offerId : " + str5);
      }
      localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
      ((QWalletAuthHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(42)).a((ReqCheckChangePwdAuth)localObject);
      this.jdField_a_of_type_Akkl = new akkl(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = new QWalletAuthObserver(this.jdField_a_of_type_Akkl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
      return;
      localObject = "";
      break;
      str1 = "";
      break label54;
      str2 = "";
      break label81;
      str3 = "";
      break label109;
      str4 = "";
      break label137;
    }
  }
  
  private boolean d(String paramString)
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
        paramString = new JSONObject(URLDecoder.decode(paramString.substring(paramString.indexOf('=') + 1), "UTF-8"));
        int i1 = paramString.optInt("gameId");
        i2 = i3;
        long l2;
        paramString.printStackTrace();
      }
      catch (Exception paramString)
      {
        try
        {
          l2 = paramString.optLong("roomId");
          l1 = l2;
          i2 = i3;
          i3 = paramString.optInt("gameMode");
          l1 = l2;
          i2 = i3;
          paramString = paramString.optString("extendInfo");
          l1 = l2;
          i2 = i3;
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l2, i3, paramString, 204);
          i2 = i3;
          l1 = l2;
          QLog.i("JumpAction", 1, "[gotoCmShowGame], gameId:" + i1 + ",roomId:" + l1 + ",gameMode:" + i2);
          return true;
        }
        catch (Exception paramString)
        {
          break label199;
        }
        paramString = paramString;
        i1 = 0;
      }
      label199:
      QLog.w("JumpAction", 1, "[gotoCmShowGame], errInfo->" + paramString.getMessage());
    }
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
    String str3;
    String str4;
    if ("opencontent".equals(this.jdField_c_of_type_JavaLangString))
    {
      if (bool)
      {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
        str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
        if (!TextUtils.isEmpty(str3)) {
          break label472;
        }
      }
      label472:
      for (str1 = "unionId=" + str4 + "&userId=" + str1 + "&userType=" + str2;; str1 = "storyId=" + str3)
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
      paramIntent.putExtra("action", 1);
      return paramIntent;
    }
    if ("infoCard".equals(this.jdField_c_of_type_JavaLangString))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromId");
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
      if ((TextUtils.isEmpty(str2)) || ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str4))) || (TextUtils.isEmpty(str3))) {
        return null;
      }
      try
      {
        paramIntent.putExtra("union_id", str4);
        paramIntent.putExtra("qq_number", Long.valueOf(str1));
        paramIntent.putExtra("source", Integer.valueOf(str3));
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
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromId");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromuid");
      try
      {
        paramIntent.putExtra("union_id", str1);
        paramIntent.putExtra("extra_share_from_uid", str3);
        paramIntent.putExtra("source", Integer.valueOf(str2));
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
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag_type");
      paramIntent.putExtra("action", 14);
      paramIntent.putExtra("tag_id", str1);
      paramIntent.putExtra("tag_type", str2);
      return paramIntent;
    }
    if ("openSquare".equals(this.jdField_c_of_type_JavaLangString))
    {
      paramIntent.putExtra("action", 15);
      return paramIntent;
    }
    return null;
  }
  
  private void e()
  {
    com.tencent.mobileqq.app.PhoneContactManagerImp.g = true;
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
  
  private void e(String paramString)
  {
    if ("app".equals(this.f)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if ("web".equals(this.f))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
        return;
      }
    } while (!"scan".equals(this.f));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
  }
  
  private void f()
  {
    try
    {
      if ("head".equals(this.jdField_c_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Akkk == null) {
          this.jdField_a_of_type_Akkk = new akkk(this, this);
        }
        if (this.jdField_a_of_type_JavaUtilHashtable == null) {
          this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akkk);
        long l1 = System.currentTimeMillis();
        String[] arrayOfString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).split(",");
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        int i1 = 0;
        while (i1 < arrayOfString.length)
        {
          String str = arrayOfString[i1];
          localFriendListHandler.c(str);
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
  
  private void f(String paramString)
  {
    if ((paramString.equals(GameCenterActivity.class.getName())) || (paramString.equals(PublicAccountBrowser.class.getName())) || (paramString.equals(CouponActivity.class.getName()))) {
      QWalletHelper.preloadQWallet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private boolean z()
  {
    int i1 = 0;
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131434859, 1).a();
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("params")) {}
    for (String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");; str1 = null)
    {
      try
      {
        Object localObject = new JSONObject(new String(Base64Util.decode(str1, 0)));
        String str2 = ((JSONObject)localObject).optString("keyword");
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("groupmask");
        long[] arrayOfLong = new long[localJSONArray.length()];
        while (i1 < localJSONArray.length())
        {
          arrayOfLong[i1] = localJSONArray.optLong(i1);
          i1 += 1;
        }
        localObject = ((JSONObject)localObject).optString("groupname");
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
  }
  
  public Intent a(Intent paramIntent)
  {
    paramIntent.putExtra("action", 5);
    paramIntent.putExtra("extra_jump_attrs", this.jdField_a_of_type_JavaUtilHashMap);
    return paramIntent;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
  }
  
  public void a(String paramString)
  {
    this.m = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
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
    new akjx(this).start();
    return b();
  }
  
  protected boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      PublishHomeWorkFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, null, paramString);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2131034380, 2131034131);
    }
    return true;
  }
  
  public boolean a(Map paramMap)
  {
    if (paramMap == null)
    {
      QLog.e("JumpAction", 1, "[gotoApolloGame] attrs null");
      return false;
    }
    String str2 = (String)paramMap.get("gameid");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = (String)paramMap.get("gameId");
    }
    QLog.d("JumpAction", 1, new Object[] { "[gotoApolloGame] game id=", str1 });
    if (!TextUtils.isEmpty(str1)) {
      try
      {
        int i3 = Integer.parseInt(str1);
        int i2 = 221;
        int i1 = i2;
        if (paramMap.containsKey("src")) {
          str1 = (String)paramMap.get("src");
        }
        try
        {
          i1 = Integer.parseInt(str1);
          QLog.d("JumpAction", 1, new Object[] { "[gotoApolloGame] src=", Integer.valueOf(i1) });
          CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(i3, true, "launch", 0L, 9, 8, 0, 0, "", i1);
          str2 = (String)paramMap.get("gameParam");
          str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = (String)paramMap.get("gameparam");
          }
          if (!TextUtils.isEmpty(str1))
          {
            localStartCheckParam.extendJson = str1;
            QLog.d("JumpAction", 1, new Object[] { "[gotoApolloGame] gameParam=", str1 });
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
    catch (Exception paramIntent) {}
    return null;
  }
  
  public void b(String paramString)
  {
    this.n = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    AudioHelper.b("JumpAction.doAction");
    if ("com.qqfav".equals(this.jdField_b_of_type_JavaLangString)) {}
    for (;;)
    {
      int i1;
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
        i1 = -1;
        continue;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131433712));
        return QfavHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, -1, false);
      }
      this.jdField_d_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("version"));
      this.jdField_e_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("channel_id"));
      this.f = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
      this.g = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type"));
      this.jdField_h_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name"));
      Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("viewtype");
      Object localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
      if (("wallet".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString)) && ("0".equals(localObject1)) && (!TextUtils.isEmpty(this.f)) && ((localObject4 == null) || ("0".equals(localObject4)))) {
        return V();
      }
      label362:
      Object localObject3;
      label390:
      long l2;
      long l1;
      if (("wallet".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString)) && ("0".equals(localObject1)) && (!TextUtils.isEmpty(this.f))) {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("entry"))
        {
          localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("entry");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("seq")) {
            break label634;
          }
          localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("seq");
          l2 = 0L;
          l1 = l2;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {}
        }
      }
      try
      {
        l1 = Long.valueOf((String)localObject3).longValue();
      }
      catch (Exception localException5)
      {
        try
        {
          VACDReportUtil.a(l1, "", "jumpParse", null, 0, null);
          for (;;)
          {
            if (("1".equals(localObject4)) || ("2".equals(localObject4)) || ("3".equals(localObject4)) || ("4".equals(localObject4)) || ("5".equals(localObject4)) || ("6".equals(localObject4)) || ("7".equals(localObject4)) || ("9".equals(localObject4)) || ("10".equals(localObject4)) || ("11".equals(localObject4)))
            {
              localObject3 = new Bundle();
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tokenid")) {
                ((Bundle)localObject3).putString("tokenid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("tokenid"));
              }
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("data")) {
                ((Bundle)localObject3).putString("data", (String)this.jdField_a_of_type_JavaUtilHashMap.get("data"));
              }
              return a((String)localObject4, (String)localObject1, l1, (Bundle)localObject3);
              localObject1 = null;
              break label362;
              label634:
              localObject3 = null;
              break label390;
            }
            if ("8".equals(localObject4)) {
              return a((String)localObject4, (String)localObject1, l1);
            }
            if (this.jdField_b_of_type_JavaLangString.equals("ftssearch"))
            {
              if (this.jdField_c_of_type_JavaLangString.equals("tab")) {
                return z();
              }
              if (this.jdField_c_of_type_JavaLangString.equals("openmixweb")) {
                return d();
              }
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("wpa")) && (this.jdField_c_of_type_JavaLangString.equals("openid_to_uin"))) {
              return W();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.jdField_c_of_type_JavaLangString.equals("chat"))) {
              return X();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("asyncmsg")) && (this.jdField_c_of_type_JavaLangString.equals("open_async_detail"))) {
              return aW();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.jdField_c_of_type_JavaLangString.equals("aioorprofile"))) {
              return ac();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("qapp")) {
              return aU();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.jdField_c_of_type_JavaLangString.equals("show_nearby_fri"))) {
              return ad();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.jdField_c_of_type_JavaLangString.equals("show_location"))) {
              return ah();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.jdField_c_of_type_JavaLangString.equals("select_location"))) {
              return ai();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("card")) && (this.jdField_c_of_type_JavaLangString.equals("show_pslcard"))) {
              return aj();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("personal_tag")) && (this.jdField_c_of_type_JavaLangString.equals("tag_list"))) {
              return aq();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("upload")) && (this.jdField_c_of_type_JavaLangString.equals("photo"))) {
              return av();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("forward")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
              return ax();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("gamesdk")) && (this.jdField_c_of_type_JavaLangString.equals("bind_group"))) {
              return aw();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_fri"))) {
              return ay();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_qqdataline"))) {
              return aT();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("gamesdk")) && (this.jdField_c_of_type_JavaLangString.equals("add_friend")))
            {
              if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"))) {
                k = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
              }
              return az();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_qqfav"))) {
              return aD();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_qzone"))) {
              return c("shareToQzone");
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.jdField_c_of_type_JavaLangString.equals("publish"))) {
              return aE();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.jdField_c_of_type_JavaLangString.equals("writemood"))) {
              return aI();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.jdField_c_of_type_JavaLangString.equals("to_publish_queue"))) {
              return aJ();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.jdField_c_of_type_JavaLangString.equals("open_homepage"))) {
              return aK();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.jdField_c_of_type_JavaLangString.equals("groupalbum"))) {
              return aA();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.jdField_c_of_type_JavaLangString.equals("to_friend_feeds"))) {
              return h();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.jdField_c_of_type_JavaLangString.equals("to_qzone_dialog"))) {
              return aB();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.jdField_c_of_type_JavaLangString.equals("to_redpocket_share"))) {
              return aF();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.jdField_c_of_type_JavaLangString.equals("open_redpocket"))) {
              return aG();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.jdField_c_of_type_JavaLangString.equals("qzone_schema"))) {
              return aC();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.jdField_c_of_type_JavaLangString.equals("shareLogToQQ"))) {
              return aH();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("mqq"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "handleMQQService");
              }
              f();
            }
            label2585:
            Object localObject2;
            for (;;)
            {
              for (;;)
              {
                if ((!this.jdField_b_of_type_JavaLangString.equals("schedule")) || (!this.jdField_c_of_type_JavaLangString.equals("showDetail"))) {
                  break label5479;
                }
                return aX();
                if ((this.jdField_b_of_type_JavaLangString.equals("groupopenapp")) && (this.jdField_c_of_type_JavaLangString.equals("openapp"))) {
                  return bm();
                }
                if ((this.jdField_b_of_type_JavaLangString.equals("lightapp")) && (this.jdField_c_of_type_JavaLangString.equals("open"))) {
                  return bn();
                }
                if (this.jdField_b_of_type_JavaLangString.endsWith("app"))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("JumpAction", 2, "handleAppForward");
                  }
                  return aS();
                }
                if ((this.jdField_b_of_type_JavaLangString.equals("qm")) && (this.jdField_c_of_type_JavaLangString.equals("qr")))
                {
                  if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))) {
                    i = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
                  }
                  if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))) {
                    j = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
                  }
                  if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openkey"))) {
                    l = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openkey");
                  }
                  if ("true".equals(this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"))) {
                    return as();
                  }
                  return au();
                }
                if ((this.jdField_b_of_type_JavaLangString.equals("dc")) && (this.jdField_c_of_type_JavaLangString.equals("ft"))) {
                  return aL();
                }
                if ("group".equals(this.jdField_b_of_type_JavaLangString))
                {
                  if (this.jdField_c_of_type_JavaLangString.equals("nearby")) {
                    return ae();
                  }
                  if (this.jdField_c_of_type_JavaLangString.equals("create")) {
                    return af();
                  }
                  if (this.jdField_c_of_type_JavaLangString.equals("report")) {
                    return bk();
                  }
                }
                else
                {
                  if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.jdField_c_of_type_JavaLangString.equals("emoji")))
                  {
                    EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 7);
                    return true;
                  }
                  if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.jdField_c_of_type_JavaLangString.equals("emoji_detail")))
                  {
                    EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4, a("detailid"));
                    return true;
                  }
                  if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.jdField_c_of_type_JavaLangString.equals("emoji_author")))
                  {
                    EmojiHomeUiPlugin.openEmojiAuthorPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 5, a("authorid"));
                    return true;
                  }
                  if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.jdField_c_of_type_JavaLangString.equals("bubble")))
                  {
                    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, null, false, -1);
                    return true;
                  }
                  if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.jdField_c_of_type_JavaLangString.equals("theme")))
                  {
                    if ((BaseApplicationImpl.IS_SUPPORT_THEME) && (Utils.a()))
                    {
                      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, null, false, -1);
                      return true;
                    }
                  }
                  else if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.jdField_c_of_type_JavaLangString.equals("font")))
                  {
                    if ((((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).c()) && (Utils.a()))
                    {
                      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_AndroidContentContext, "font", ""), 4096L, null, false, -1);
                      return true;
                    }
                  }
                  else
                  {
                    if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.jdField_c_of_type_JavaLangString.equals("pendant")))
                    {
                      if (!Utils.a()) {
                        break;
                      }
                      AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
                      return true;
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.jdField_c_of_type_JavaLangString.equals("individuation")))
                    {
                      VasWebviewUtil.openIndividuationIndex(this.jdField_a_of_type_AndroidContentContext);
                      return true;
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.jdField_c_of_type_JavaLangString.equals("apollo_store")))
                    {
                      localObject3 = new Intent();
                      localObject4 = this.jdField_a_of_type_JavaLangString.split("\\?");
                      localObject1 = ApolloConstant.X;
                      if (localObject4.length < 2) {
                        break label5862;
                      }
                      ((Intent)localObject3).putExtra("extra_key_url_append", localObject4[1]);
                      if (localObject4[1] == null) {
                        break label5862;
                      }
                      if (localObject4[1].contains("tab=interactive"))
                      {
                        localObject1 = ApolloConstant.Y;
                        i1 = 0;
                        if (i1 == 0) {
                          break label2699;
                        }
                        ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext);
                      }
                      while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
                      {
                        localObject1 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
                        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_clk", ((ApolloManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), 0, new String[] { "0" });
                        return true;
                        if (localObject4[1].contains("tab=game_city"))
                        {
                          localObject1 = ApolloConstant.ac;
                          i1 = 0;
                          break label2585;
                        }
                        if (!localObject4[1].contains("tab=game_center")) {
                          break label5862;
                        }
                        i1 = 1;
                        break label2585;
                        label2699:
                        ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject3, null, (String)localObject1, null);
                      }
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.jdField_c_of_type_JavaLangString.equals("game_invite")))
                    {
                      QLog.i("JumpAction", 1, "[cmshow.game_invite], source:" + this.jdField_a_of_type_JavaLangString);
                      return d(this.jdField_a_of_type_JavaLangString);
                    }
                    if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("avatar_edit".equals(this.jdField_c_of_type_JavaLangString))) {
                      return Q();
                    }
                    if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("might_know".equals(this.jdField_c_of_type_JavaLangString))) {
                      return R();
                    }
                    if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("phone_recommend".equals(this.jdField_c_of_type_JavaLangString))) {
                      return S();
                    }
                    if (((this.jdField_b_of_type_JavaLangString.equals("readingcenter")) || (this.jdField_b_of_type_JavaLangString.equals("qqreader"))) && (this.jdField_c_of_type_JavaLangString.equals("open"))) {
                      return ag();
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("healthcenter")) && (this.jdField_c_of_type_JavaLangString.equals("open")))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.i("JumpAction", 2, "enter jiankang");
                      }
                      ThreadManager.post(new akkc(this), 5, null, true);
                      if ((Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor")).getDefaultSensor(19) != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
                        ((SportManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(259)).a("jump action");
                      }
                      localObject3 = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
                      if ((localObject3 == null) || ((!((String)localObject3).startsWith("http://")) && (!((String)localObject3).startsWith("https://"))) || ((!Util.b((String)localObject3).equalsIgnoreCase("qq.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("myun.tenpay.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("tenpay.com")) && (!Util.b((String)localObject3).equalsIgnoreCase("wanggou.com")))) {
                        return false;
                      }
                      localObject1 = localObject3;
                      if (((String)localObject3).indexOf("?") <= 0) {
                        localObject1 = (String)localObject3 + "?";
                      }
                      localObject3 = new StringBuilder((String)localObject1);
                      localObject4 = ((StringBuilder)localObject3).append("&client=androidQQ").append("&uin=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("&version=").append("7.6.8.3615").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&density=").append(ThemeUtil.getThemeDensity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())).append("&platformId=2").append("&_lv=0").append("&hasRedDot=");
                      if (this.jdField_d_of_type_Boolean) {}
                      for (localObject1 = "1";; localObject1 = "0")
                      {
                        ((StringBuilder)localObject4).append((String)localObject1).append("&adtag=mvip.gongneng.anroid.health.nativet");
                        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
                        ((StringBuilder)localObject3).append("&lati=").append(((SharedPreferences)localObject1).getFloat("search_lbs_latitude", 0.0F));
                        ((StringBuilder)localObject3).append("&logi=").append(((SharedPreferences)localObject1).getFloat("search_lbs_logitude", 0.0F));
                        i1 = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
                        ((StringBuilder)localObject3).append("&netType=" + i1);
                        localObject1 = DeviceInfoUtil.e();
                        ((StringBuilder)localObject3).append("&model=" + (String)localObject1);
                        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                        ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject3).toString());
                        ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
                        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                        return true;
                      }
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("ptlogin")) && (this.jdField_c_of_type_JavaLangString.equals("qlogin"))) {
                      return aM();
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("gav")) && (this.jdField_c_of_type_JavaLangString.equals("request"))) {
                      return aN();
                    }
                    if (("videochat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.jdField_c_of_type_JavaLangString))) {
                      return aO();
                    }
                    if (("randomavchat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.jdField_c_of_type_JavaLangString))) {
                      return aP();
                    }
                    if (("guildavchat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.jdField_c_of_type_JavaLangString))) {
                      return aQ();
                    }
                    if (this.jdField_b_of_type_JavaLangString.equals("tribe"))
                    {
                      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
                      localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sourceUrl");
                      if (this.jdField_c_of_type_JavaLangString.equals("web")) {
                        localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
                      }
                      try
                      {
                        localObject4 = URLDecoder.decode((String)localObject4);
                        localObject4 = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class).putExtra("url", (String)localObject4);
                        ((Intent)localObject4).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                        ((Intent)localObject4).putExtra("hide_operation_bar", true);
                        ((Intent)localObject4).putExtra("hideRightButton", true);
                        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
                        if ((localObject1 == null) || (localObject3 == null)) {
                          break;
                        }
                        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_tribe", "", "url", "visit", 0, 1, 0, (String)localObject1, Util.b((String)localObject3, new String[0]), "", "");
                        return true;
                      }
                      catch (Exception localException1)
                      {
                        if (QLog.isDevelopLevel()) {
                          QLog.e("JumpAction", 4, "URLDecoder.decode error");
                        }
                        return false;
                      }
                    }
                  }
                }
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qqdataline")) && (this.jdField_c_of_type_JavaLangString.equals("openqqdataline"))) {
                return U();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("wallet")) && (this.jdField_c_of_type_JavaLangString.equals("modify_pass"))) {
                return T();
              }
              if (this.jdField_b_of_type_JavaLangString.equals("dating"))
              {
                if (this.jdField_c_of_type_JavaLangString.equals("detail")) {
                  return P();
                }
                if (this.jdField_c_of_type_JavaLangString.equals("publish")) {
                  return O();
                }
                if (this.jdField_c_of_type_JavaLangString.equals("feed")) {
                  return N();
                }
              }
              else if (this.jdField_b_of_type_JavaLangString.equals("nearby_entry"))
              {
                if (this.jdField_c_of_type_JavaLangString.equals("nearby_feed")) {
                  return I();
                }
                if (this.jdField_c_of_type_JavaLangString.equals("nearby_profile")) {
                  return ak();
                }
                if (this.jdField_c_of_type_JavaLangString.equals("hotchat_list")) {
                  return K();
                }
                if (this.jdField_c_of_type_JavaLangString.equals("hotchat_room")) {
                  return L();
                }
                if (this.jdField_c_of_type_JavaLangString.equals("visitor_list")) {
                  return u();
                }
              }
              else if (this.jdField_b_of_type_JavaLangString.equals("hotchat"))
              {
                if (this.jdField_c_of_type_JavaLangString.equals("newyear_scene")) {
                  return M();
                }
              }
              else if (this.jdField_b_of_type_JavaLangString.equals("freshnews_entry"))
              {
                if ((this.jdField_c_of_type_JavaLangString.equals("feed")) || (this.jdField_c_of_type_JavaLangString.equals("detail")) || (this.jdField_c_of_type_JavaLangString.equals("topic")) || (!this.jdField_c_of_type_JavaLangString.equals("public"))) {}
              }
              else
              {
                if ((this.jdField_b_of_type_JavaLangString.equals("qlink")) && (this.jdField_c_of_type_JavaLangString.equals("openqlink"))) {
                  return aV();
                }
                if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_troopbar"))) {
                  return aY();
                }
                if ((this.jdField_b_of_type_JavaLangString.equals("qqconnect")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
                  return aZ();
                }
                if ((this.jdField_b_of_type_JavaLangString.equals("publicdevice")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
                  return ba();
                }
                if ((this.jdField_b_of_type_JavaLangString.equals("openLightApp")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
                  return j();
                }
                if (("tenpay".equals(this.jdField_b_of_type_JavaLangString)) && ("sendHongBao".equals(this.jdField_c_of_type_JavaLangString))) {
                  return bb();
                }
                if (("massbless".endsWith(this.jdField_b_of_type_JavaLangString)) && ("mainpage".equals(this.jdField_c_of_type_JavaLangString))) {
                  return k();
                }
                if (!this.jdField_b_of_type_JavaLangString.equals("rankinglist"))
                {
                  if (this.jdField_b_of_type_JavaLangString.equals("interesttag")) {
                    return H();
                  }
                  if (this.jdField_b_of_type_JavaLangString.equals("qqcomic")) {
                    return aR();
                  }
                  if (("leba_plugin".equals(this.jdField_b_of_type_JavaLangString)) && ("set".equals(this.jdField_c_of_type_JavaLangString))) {
                    return l();
                  }
                  if (this.jdField_b_of_type_JavaLangString.equals("pa_relationship")) {
                    return m();
                  }
                  if (this.jdField_b_of_type_JavaLangString.equals("od")) {
                    return n();
                  }
                  if (this.jdField_b_of_type_JavaLangString.equals("odAddFriend")) {
                    return bc();
                  }
                  if ("huayang".equals(this.jdField_b_of_type_JavaLangString)) {
                    return bd();
                  }
                  if (this.jdField_b_of_type_JavaLangString.equals("readinjoy"))
                  {
                    if (this.jdField_c_of_type_JavaLangString.equals("open")) {
                      return o();
                    }
                    if (this.jdField_c_of_type_JavaLangString.equals("report")) {
                      return p();
                    }
                    if (this.jdField_c_of_type_JavaLangString.equals("reportrealtime")) {
                      return q();
                    }
                    if (this.jdField_c_of_type_JavaLangString.equals("apenalbum"))
                    {
                      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("articleid");
                      i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin_type"));
                      if (!TextUtils.isEmpty((CharSequence)localObject2))
                      {
                        localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountImageCollectionMainActivity.class);
                        ((Intent)localObject3).putExtra("source_for_report", i1);
                        PublicAccountImageCollectionUtils.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject3, (String)localObject2);
                      }
                    }
                    else
                    {
                      if (this.jdField_c_of_type_JavaLangString.equals("multivideo")) {
                        return r();
                      }
                      if (this.jdField_c_of_type_JavaLangString.equals("openatlas"))
                      {
                        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("rowkey")) {}
                        for (localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rowkey"); TextUtils.isEmpty((CharSequence)localObject2); localObject2 = "")
                        {
                          if (QLog.isColorLevel()) {
                            QLog.e("JumpAction", 2, "rowKey is Empty");
                          }
                          return false;
                        }
                        label4860:
                        String str;
                        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("picindex"))
                        {
                          localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("picindex");
                          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("source")) {
                            break label4971;
                          }
                          localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
                          label4888:
                          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("enteranimationstyle")) {
                            break label4978;
                          }
                          str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enteranimationstyle");
                        }
                        for (;;)
                        {
                          for (;;)
                          {
                            int i2;
                            int i3;
                            int i4;
                            try
                            {
                              i1 = Integer.valueOf((String)localObject3).intValue();
                            }
                            catch (Exception localException2)
                            {
                              label4971:
                              label4978:
                              i1 = 0;
                              i2 = 0;
                            }
                            try
                            {
                              i2 = Integer.valueOf((String)localObject4).intValue();
                            }
                            catch (Exception localException3)
                            {
                              for (;;)
                              {
                                label4991:
                                i3 = 0;
                                i2 = i1;
                                i1 = i3;
                              }
                            }
                            try
                            {
                              i3 = Integer.valueOf(str).intValue();
                              i4 = i1;
                              i1 = i2;
                              ReadInJoyAtlasFragment.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2, i4, i1, i3);
                            }
                            catch (Exception localException4)
                            {
                              i3 = i1;
                              i1 = i2;
                              i2 = i3;
                              break label4991;
                            }
                          }
                          localObject3 = "0";
                          break label4860;
                          localObject4 = "0";
                          break label4888;
                          str = "0";
                          continue;
                          if (QLog.isColorLevel()) {
                            QLog.e("JumpAction", 2, "Parameter error");
                          }
                          i3 = 0;
                          i4 = i2;
                        }
                      }
                    }
                  }
                  else if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.jdField_c_of_type_JavaLangString.equals("apollo_action")))
                  {
                    if (ApolloManager.a(this.jdField_a_of_type_AndroidContentContext)) {
                      return t();
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
                        localObject2 = new Intent();
                        ((Intent)localObject2).putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131433712));
                        return QfavHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject2, -1, false);
                      }
                    }
                    else if ("hongbao_share".equals(this.jdField_b_of_type_JavaLangString))
                    {
                      if ("hongbao_brush".equals(this.jdField_c_of_type_JavaLangString)) {
                        return F();
                      }
                    }
                    else if ("general_ar".equals(this.jdField_b_of_type_JavaLangString))
                    {
                      if ("gotoScannerTorchActivity".equals(this.jdField_c_of_type_JavaLangString)) {
                        return G();
                      }
                    }
                    else if ("assistant_setting".equals(this.jdField_b_of_type_JavaLangString))
                    {
                      if ("ASSISTANT_SETTING".equals(this.jdField_c_of_type_JavaLangString)) {
                        return s();
                      }
                    }
                    else if ((this.jdField_b_of_type_JavaLangString.equals("conf")) || (this.jdField_b_of_type_JavaLangString.equals("confpstn")) || (this.jdField_b_of_type_JavaLangString.equals("confhr")))
                    {
                      if (this.jdField_c_of_type_JavaLangString.equals("ft")) {
                        return v();
                      }
                    }
                    else if (!"olympic_entry".equals(this.jdField_b_of_type_JavaLangString)) {
                      if ("teamwork".equals(this.jdField_b_of_type_JavaLangString))
                      {
                        if ("opendoclist".equals(this.jdField_c_of_type_JavaLangString)) {
                          return E();
                        }
                      }
                      else
                      {
                        if ("qstory".equals(this.jdField_b_of_type_JavaLangString))
                        {
                          if ("openNow".equals(this.jdField_c_of_type_JavaLangString)) {
                            return w();
                          }
                          return C();
                        }
                        if ("now".equals(this.jdField_b_of_type_JavaLangString))
                        {
                          if ("openroom".equals(this.jdField_c_of_type_JavaLangString)) {
                            return w();
                          }
                          if ("playmedia".equals(this.jdField_c_of_type_JavaLangString)) {
                            return c();
                          }
                        }
                        else if (("armap_entry".equals(this.jdField_b_of_type_JavaLangString)) && ("map".equals(this.jdField_c_of_type_JavaLangString)))
                        {
                          return bi();
                        }
                      }
                    }
                  }
                }
              }
            }
            label5479:
            if ((this.jdField_b_of_type_JavaLangString.equals("contact")) && (this.jdField_c_of_type_JavaLangString.equals("add"))) {
              return x();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("qqreg")) {
              return bj();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("troop_member_card")) && (this.jdField_c_of_type_JavaLangString.equals("open_member_recent_chat_view"))) {
              return J();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("qwerewolf"))
            {
              if (this.jdField_c_of_type_JavaLangString.equals("openInvitationRoom")) {
                return A();
              }
              if (this.jdField_c_of_type_JavaLangString.equals("enterGameRoom")) {
                return B();
              }
            }
            else if (this.jdField_b_of_type_JavaLangString.equals("groupvideo"))
            {
              if (this.jdField_c_of_type_JavaLangString.equals("openroom")) {
                return bl();
              }
            }
            else if (this.jdField_b_of_type_JavaLangString.equals("invite_join_group"))
            {
              if (this.jdField_c_of_type_JavaLangString.equals("open")) {
                return y();
              }
            }
            else
            {
              if (("troop_homework".equals(this.jdField_b_of_type_JavaLangString)) && ("publish".equals(this.jdField_c_of_type_JavaLangString))) {
                return a(a("gc"));
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("nearby_videochat")) && (this.jdField_c_of_type_JavaLangString.equals("open_plugin")))
              {
                if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
                {
                  localObject2 = (NearbyVideoChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
                  NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, null, ((NearbyVideoChatManager)localObject2).a(), null, 123987);
                  return true;
                }
                QLog.i("JumpAction", 1, "openNearbyVideoChatActivity, context is not a activity");
                return false;
              }
              if (("weishitab".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString))) {
                b();
              }
            }
            return false;
            localException5 = localException5;
            l1 = l2;
          }
        }
        catch (Exception localException6)
        {
          for (;;)
          {
            continue;
            label5862:
            i1 = 0;
          }
        }
      }
    }
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
    catch (Exception paramIntent) {}
    return null;
  }
  
  public void c(String paramString)
  {
    this.o = paramString;
  }
  
  public boolean c()
  {
    SmallVideoFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    return true;
  }
  
  public Intent d(Intent paramIntent)
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("showinfocard");
    int i1 = a(this.jdField_a_of_type_JavaUtilHashMap);
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
          paramIntent.putExtra("EXTRA_VIDEO_MODE", 9);
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
  
  public void d(String paramString)
  {
    this.p = paramString;
  }
  
  public boolean d()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("weburl")) {
      localIntent.putExtra("url", Uri.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("weburl")));
    }
    localIntent.putExtra("fragment_class", "com.tencent.mobileqq.search.activity.MixSearchWebFragment");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localIntent.putExtra((String)localEntry.getKey(), Uri.decode((String)localEntry.getValue()));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!"1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("openanimtype")))) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(0, 0);
    }
    return true;
  }
  
  public boolean e()
  {
    if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.jdField_c_of_type_JavaLangString.equals("aioorprofile"))) {}
    while ((this.jdField_b_of_type_JavaLangString.equals("group")) && (this.jdField_c_of_type_JavaLangString.equals("creategroup"))) {
      return true;
    }
    return false;
  }
  
  public boolean f()
  {
    return (this.jdField_b_of_type_JavaLangString.equals("card")) && (this.jdField_c_of_type_JavaLangString.equals("show_pslcard")) && ("public_account".equals(this.jdField_a_of_type_JavaUtilHashMap.get("card_type"))) && ("app".equals(this.jdField_a_of_type_JavaUtilHashMap.get("src_type"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")));
  }
  
  public boolean g()
  {
    return (this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_fri"));
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Object localObject = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
    if ((localObject != null) && ((((QZoneManagerImp)localObject).a(2) > 0) || (((QZoneManagerImp)localObject).a(1) > 0))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("newflag", bool);
      ((Intent)localObject).putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.a((Intent)localObject, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      ((Intent)localObject).addFlags(805306368);
      QZoneHelper.c((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (Intent)localObject, -1);
      LpReportInfo_dc02880.report(this.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    String str = a(a(a(a(a(a(QzoneConfig.getInstance().getConfig("H5Url", "PersonalQzoneVisitor", "https://h5.qzone.qq.com/visitor/qzone/personal?uin={uin}&qua={qua}&clicktime={clicktime}&_bid=329&_wv=3&_proxy=true"), "{hostUin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "{clicktime}", String.valueOf(System.currentTimeMillis())), "{from}", "androidQQ"), "{qua}", QUA.a()), "{uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "{UIN}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.putExtra("articalChannelId", 5);
    if (WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131432890));
    localIntent.setData(Uri.parse(str));
    localIntent.addFlags(268435456);
    localIntent.putExtra("needSkey", "true");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean j()
  {
    Object localObject = a("param_meta_data");
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localBundle.putString("param_meta_data", (String)localObject);
    }
    String str = d((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_JavaLangString;
    }
    SmartDeviceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, (String)localObject, localBundle);
    return true;
  }
  
  public boolean k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "gotoSendBless");
    }
    if (((BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(137)).a())
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BlessActivity.class);
      localIntent.putExtra("fromoutweb", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    localIntent.putExtra("url", "http://sqimg.qq.com/qq_product_operations/mma/ptv/index.html?adtag=main");
    WebAccelerator.a(this.jdField_a_of_type_AndroidContentContext, localIntent, "http://sqimg.qq.com/qq_product_operations/mma/ptv/index.html?adtag=main");
    return true;
  }
  
  public boolean l()
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
  
  public boolean m()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_type");
    if ((localObject != null) && ("public_account".equals(localObject)))
    {
      int i1 = PublicAccountUtil.a(Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("account_flag")));
      if ((i1 == -3) || (i1 == -4)) {
        ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), 0L, 1);
      }
    }
    do
    {
      do
      {
        return true;
      } while ((localObject == null) || (!"crm".equals(localObject)));
      localObject = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    } while (localObject == null);
    ((EnterpriseQQHandler)localObject).a(SystemClock.uptimeMillis());
    return true;
  }
  
  public boolean n()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");
    Object localObject6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"))) {}
    try
    {
      localObject1 = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"), "utf-8");
      localObject5 = "";
      localObject3 = localObject5;
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
          long l2 = Long.parseLong(str);
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
          int i2 = Integer.parseInt((String)localObject6);
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
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ((ODProxy)((QQAppInterface)localObject5).getManager(107)).a(this.jdField_a_of_type_AndroidContentContext, l1, "launcher", (String)localObject1, (String)localObject3, i1);
        return true;
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
        localUnsupportedEncodingException1.printStackTrace();
        localObject2 = localObject3;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          Object localObject5;
          localUnsupportedEncodingException2.printStackTrace();
          localObject4 = localObject5;
        }
      }
    }
  }
  
  public boolean o()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("channelid");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("channelname");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("target");
    int i2;
    int i1;
    if ("1".equals(str3))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      if ("qzone".equals(localObject1)) {
        PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067C6", "0X80067C6", 0, 0, "", "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", false);
      }
      if (ReadInJoyHelper.h())
      {
        i2 = 12;
        i1 = i2;
      }
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          i1 = i2;
          if (TextUtils.isDigitsOnly((CharSequence)localObject1)) {
            i1 = Integer.valueOf((String)localObject1).intValue();
          }
        }
        localObject1 = ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, i1);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("JumpAction", 1, "jump activity error1 ", localException1);
        continue;
      }
      return true;
      if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 2, 0);
      }
      else
      {
        ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, 2);
        continue;
        if ("2".equals(str3))
        {
          i2 = -1;
          if (str2 == null) {
            return false;
          }
          try
          {
            i1 = Integer.parseInt(str2);
          }
          catch (Exception localException6)
          {
            try
            {
              for (;;)
              {
                i2 = Integer.parseInt(str1);
                if (i1 != -1) {
                  break;
                }
                return false;
                localException6 = localException6;
                i1 = i2;
                if (QLog.isDevelopLevel())
                {
                  QLog.e("JumpAction", 4, "gotoReadInJoy channelId error");
                  i1 = i2;
                }
              }
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.e("JumpAction", 4, "gotoReadInJoy channelType error");
                }
                i2 = 0;
              }
              Object localObject2 = localException1;
              if (TextUtils.isEmpty(localException1)) {
                localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131432085);
              }
              if (i2 == 3)
              {
                if (i1 == 56)
                {
                  if (ReadInJoyHelper.h())
                  {
                    ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, i1, (String)localObject2, i2, 4);
                    continue;
                  }
                  ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 4, 1);
                  continue;
                }
                ReadInJoyActivityHelper.b(this.jdField_a_of_type_AndroidContentContext, i1, (String)localObject2, i2, 4);
                continue;
              }
              ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, i1, (String)localObject2, i2, 4);
            }
          }
        }
        else if ("2001".equals(str3))
        {
          i1 = Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("from")).intValue();
          if (ReadInJoyHelper.f())
          {
            try
            {
              Intent localIntent1 = ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, i1);
              this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
            }
            catch (Exception localException2) {}
            if (QLog.isColorLevel()) {
              QLog.e("JumpAction", 1, "jump activity error1 ", localException2);
            }
          }
          else if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, 0);
          }
          else
          {
            ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, i1);
          }
        }
        else
        {
          if (localException6 == null) {
            return false;
          }
          try
          {
            i1 = Integer.parseInt(localException6);
            if (i1 == -1) {
              return false;
            }
          }
          catch (Exception localException5)
          {
            for (;;)
            {
              if (QLog.isDevelopLevel()) {
                QLog.e("JumpAction", 4, "gotoReadInJoy channelId error");
              }
              i1 = -1;
            }
            Object localObject3 = localException2;
            if (TextUtils.isEmpty(localException2)) {
              localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131432085);
            }
            if (ReadInJoyHelper.h())
            {
              try
              {
                Intent localIntent2 = ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, 12);
                this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent2);
              }
              catch (Exception localException3) {}
              if (QLog.isColorLevel()) {
                QLog.e("JumpAction", 1, "jump activity error1 ", localException3);
              }
            }
            else
            {
              Intent localIntent3 = new Intent("android.intent.action.MAIN");
              localIntent3.putExtra("channel_id", i1);
              localIntent3.putExtra("channel_name", (String)localObject3);
              localIntent3.putExtra("readinjoy_launch_source", 7);
              ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localIntent3);
            }
          }
        }
      }
    }
  }
  
  public boolean p()
  {
    int i3 = 0;
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("sub_action"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sub_action");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("action_name")) {
        break label134;
      }
    }
    label134:
    for (String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("action_name");; str2 = "")
    {
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        break label141;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "subAction[" + str1 + "] or actionName[" + str2 + "] null");
      }
      return true;
      str1 = "";
      break;
    }
    label141:
    String str3;
    label169:
    String str4;
    label197:
    String str5;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tag"))
    {
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("main_action")) {
        break label578;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("main_action");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("to_uin")) {
        break label585;
      }
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("to_uin");
      label225:
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("from_type")))) {
        break label634;
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
            break label169;
            label578:
            str4 = "";
            break label197;
            label585:
            str5 = "";
            break label225;
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
      label634:
      int i1 = 0;
    }
  }
  
  public boolean q()
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
      label327:
      break label327;
    }
    return true;
  }
  
  /* Error */
  public boolean r()
  {
    // Byte code:
    //   0: new 456	android/os/Bundle
    //   3: dup
    //   4: invokespecial 457	android/os/Bundle:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc_w 5153
    //   12: aload_0
    //   13: aload_0
    //   14: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   17: ldc_w 1701
    //   20: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 45	java/lang/String
    //   26: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_3
    //   33: ldc_w 5155
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   41: ldc_w 1861
    //   44: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 45	java/lang/String
    //   50: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_3
    //   57: ldc_w 5157
    //   60: aload_0
    //   61: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   64: ldc_w 5159
    //   67: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 45	java/lang/String
    //   73: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_3
    //   77: ldc_w 5161
    //   80: aload_0
    //   81: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   84: ldc_w 5163
    //   87: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 45	java/lang/String
    //   93: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_3
    //   97: ldc_w 5165
    //   100: aload_0
    //   101: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   104: ldc_w 5167
    //   107: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   110: checkcast 45	java/lang/String
    //   113: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_3
    //   117: ldc_w 5169
    //   120: aload_0
    //   121: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   124: ldc_w 5171
    //   127: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: checkcast 45	java/lang/String
    //   133: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_3
    //   137: ldc_w 5173
    //   140: aload_0
    //   141: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   144: ldc_w 5175
    //   147: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   150: checkcast 45	java/lang/String
    //   153: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload_3
    //   157: ldc_w 5177
    //   160: iconst_0
    //   161: invokevirtual 817	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   164: aload_3
    //   165: ldc_w 5179
    //   168: ldc_w 563
    //   171: aload_0
    //   172: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   175: ldc_w 5181
    //   178: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   181: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   184: invokevirtual 817	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   187: aload_3
    //   188: ldc_w 5183
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   196: ldc_w 5185
    //   199: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   202: checkcast 45	java/lang/String
    //   205: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   208: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload_0
    //   212: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   215: ldc_w 2606
    //   218: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   221: checkcast 1060	java/lang/CharSequence
    //   224: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   227: ifne +39 -> 266
    //   230: aload_3
    //   231: ldc_w 5187
    //   234: new 5189	java/math/BigInteger
    //   237: dup
    //   238: aload_0
    //   239: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   242: ldc_w 2606
    //   245: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   248: checkcast 45	java/lang/String
    //   251: invokespecial 5190	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   254: invokevirtual 5191	java/math/BigInteger:longValue	()J
    //   257: invokestatic 534	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   260: invokevirtual 465	java/lang/Long:longValue	()J
    //   263: invokevirtual 475	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   266: aload_0
    //   267: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   270: ldc_w 5193
    //   273: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   276: checkcast 1060	java/lang/CharSequence
    //   279: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   282: ifne +29 -> 311
    //   285: aload_3
    //   286: ldc_w 5195
    //   289: aload_0
    //   290: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   293: ldc_w 5193
    //   296: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   299: checkcast 45	java/lang/String
    //   302: invokestatic 578	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   305: invokevirtual 581	java/lang/Integer:intValue	()I
    //   308: invokevirtual 1533	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   311: aload_0
    //   312: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   315: ldc_w 5197
    //   318: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   321: checkcast 1060	java/lang/CharSequence
    //   324: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   327: ifne +23 -> 350
    //   330: aload_3
    //   331: ldc_w 5199
    //   334: aload_0
    //   335: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   338: ldc_w 5197
    //   341: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   344: checkcast 45	java/lang/String
    //   347: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: aload_0
    //   351: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   354: ldc_w 5201
    //   357: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   360: checkcast 45	java/lang/String
    //   363: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   366: ifne +996 -> 1362
    //   369: aload_3
    //   370: ldc_w 5203
    //   373: aload_0
    //   374: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   377: ldc_w 5201
    //   380: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   383: checkcast 45	java/lang/String
    //   386: invokestatic 578	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   389: invokevirtual 581	java/lang/Integer:intValue	()I
    //   392: invokevirtual 1533	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   395: aload_0
    //   396: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   399: ldc_w 5205
    //   402: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   405: checkcast 45	java/lang/String
    //   408: astore_2
    //   409: aload_2
    //   410: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   413: ifne +17 -> 430
    //   416: aload_3
    //   417: ldc_w 5207
    //   420: aload_2
    //   421: invokestatic 578	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   424: invokevirtual 581	java/lang/Integer:intValue	()I
    //   427: invokevirtual 1533	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   430: aload_3
    //   431: ldc_w 5209
    //   434: aload_0
    //   435: aload_0
    //   436: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   439: ldc_w 5211
    //   442: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   445: checkcast 45	java/lang/String
    //   448: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   451: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload_3
    //   455: ldc_w 5213
    //   458: aload_0
    //   459: aload_0
    //   460: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   463: ldc_w 5215
    //   466: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   469: checkcast 45	java/lang/String
    //   472: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   475: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: aload_0
    //   479: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   482: ldc_w 5181
    //   485: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   488: checkcast 45	java/lang/String
    //   491: invokestatic 578	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   494: invokevirtual 581	java/lang/Integer:intValue	()I
    //   497: istore_1
    //   498: aload_3
    //   499: ldc_w 5217
    //   502: iload_1
    //   503: invokevirtual 1533	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   506: aload_0
    //   507: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   510: ldc_w 5219
    //   513: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   516: checkcast 45	java/lang/String
    //   519: invokestatic 462	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   522: invokevirtual 465	java/lang/Long:longValue	()J
    //   525: iconst_1
    //   526: invokestatic 5224	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyTimeUtils:a	(JZ)Ljava/lang/String;
    //   529: astore_2
    //   530: aload_3
    //   531: ldc_w 5226
    //   534: aload_2
    //   535: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   538: aload_3
    //   539: ldc_w 5228
    //   542: aload_0
    //   543: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   546: ldc_w 5230
    //   549: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   552: checkcast 45	java/lang/String
    //   555: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: aload_3
    //   559: ldc_w 5232
    //   562: aload_0
    //   563: aload_0
    //   564: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   567: ldc_w 5234
    //   570: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   573: checkcast 45	java/lang/String
    //   576: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   579: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   582: aload_3
    //   583: ldc_w 5236
    //   586: aload_0
    //   587: aload_0
    //   588: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   591: ldc_w 5238
    //   594: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   597: checkcast 45	java/lang/String
    //   600: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   603: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: aload_3
    //   607: ldc_w 5240
    //   610: aload_0
    //   611: aload_0
    //   612: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   615: ldc_w 5242
    //   618: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   621: checkcast 45	java/lang/String
    //   624: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   627: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: aload_0
    //   631: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   634: ldc_w 5244
    //   637: invokevirtual 366	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   640: ifeq +46 -> 686
    //   643: aload_0
    //   644: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   647: ldc_w 5244
    //   650: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   653: checkcast 1060	java/lang/CharSequence
    //   656: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   659: ifne +27 -> 686
    //   662: aload_3
    //   663: ldc_w 5246
    //   666: aload_0
    //   667: aload_0
    //   668: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   671: ldc_w 5244
    //   674: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   677: checkcast 45	java/lang/String
    //   680: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   683: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   686: aload_0
    //   687: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   690: ldc_w 5171
    //   693: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   696: checkcast 45	java/lang/String
    //   699: invokestatic 5251	com/tencent/biz/pubaccount/readinjoy/common/ThirdVideoManager:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/struct/VidUrl;
    //   702: astore_2
    //   703: aload_2
    //   704: ifnull +25 -> 729
    //   707: aload_3
    //   708: ldc_w 5253
    //   711: aload_2
    //   712: getfield 5256	com/tencent/biz/pubaccount/readinjoy/struct/VidUrl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   715: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: aload_3
    //   719: ldc_w 5258
    //   722: aload_2
    //   723: getfield 5260	com/tencent/biz/pubaccount/readinjoy/struct/VidUrl:a	J
    //   726: invokevirtual 475	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   729: new 456	android/os/Bundle
    //   732: dup
    //   733: invokespecial 457	android/os/Bundle:<init>	()V
    //   736: astore_2
    //   737: aload_2
    //   738: ldc_w 5262
    //   741: aload_0
    //   742: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   745: ldc_w 5171
    //   748: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   751: checkcast 45	java/lang/String
    //   754: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   757: aload_2
    //   758: ldc_w 5264
    //   761: aload_0
    //   762: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   765: ldc_w 5171
    //   768: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   771: checkcast 45	java/lang/String
    //   774: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   777: aload_2
    //   778: ldc_w 5266
    //   781: aload_0
    //   782: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   785: ldc_w 5159
    //   788: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   791: checkcast 45	java/lang/String
    //   794: invokestatic 578	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   797: invokevirtual 581	java/lang/Integer:intValue	()I
    //   800: invokevirtual 1533	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   803: aload_2
    //   804: ldc_w 5268
    //   807: aload_0
    //   808: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   811: ldc_w 5163
    //   814: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   817: checkcast 45	java/lang/String
    //   820: invokestatic 578	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   823: invokevirtual 581	java/lang/Integer:intValue	()I
    //   826: invokevirtual 1533	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   829: aload_2
    //   830: ldc_w 5270
    //   833: aload_0
    //   834: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   837: ldc_w 5167
    //   840: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   843: checkcast 45	java/lang/String
    //   846: invokestatic 578	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   849: invokevirtual 581	java/lang/Integer:intValue	()I
    //   852: invokevirtual 1533	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   855: aload_2
    //   856: ldc_w 5272
    //   859: aload_0
    //   860: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   863: ldc_w 5159
    //   866: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   869: checkcast 45	java/lang/String
    //   872: invokestatic 578	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   875: invokevirtual 581	java/lang/Integer:intValue	()I
    //   878: invokevirtual 1533	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   881: aload_0
    //   882: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   885: ldc_w 5181
    //   888: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   891: checkcast 45	java/lang/String
    //   894: invokestatic 578	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   897: invokevirtual 581	java/lang/Integer:intValue	()I
    //   900: iconst_1
    //   901: if_icmpne +723 -> 1624
    //   904: aload_2
    //   905: ldc_w 5274
    //   908: aload_0
    //   909: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   912: ldc_w 5230
    //   915: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   918: checkcast 45	java/lang/String
    //   921: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   924: aload_2
    //   925: ldc_w 5276
    //   928: aload_0
    //   929: aload_0
    //   930: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   933: ldc_w 5234
    //   936: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   939: checkcast 45	java/lang/String
    //   942: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   945: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   948: aload_2
    //   949: ldc_w 5278
    //   952: aload_0
    //   953: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   956: ldc_w 5230
    //   959: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   962: checkcast 45	java/lang/String
    //   965: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   968: aload_2
    //   969: ldc_w 5280
    //   972: aload_0
    //   973: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   976: ldc_w 5181
    //   979: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   982: checkcast 45	java/lang/String
    //   985: invokestatic 578	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   988: invokevirtual 581	java/lang/Integer:intValue	()I
    //   991: invokevirtual 1533	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   994: aload_2
    //   995: ldc_w 5282
    //   998: aload_0
    //   999: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1002: ldc_w 5175
    //   1005: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1008: checkcast 45	java/lang/String
    //   1011: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1014: aload_2
    //   1015: ldc_w 5284
    //   1018: iconst_5
    //   1019: invokevirtual 1533	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1022: aload_2
    //   1023: ldc_w 5286
    //   1026: iconst_0
    //   1027: invokevirtual 817	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1030: aload_2
    //   1031: ldc_w 1742
    //   1034: aload_0
    //   1035: aload_0
    //   1036: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1039: ldc_w 5215
    //   1042: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1045: checkcast 45	java/lang/String
    //   1048: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1051: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1054: aload_2
    //   1055: ldc_w 1736
    //   1058: aload_0
    //   1059: aload_0
    //   1060: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1063: ldc_w 5211
    //   1066: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1069: checkcast 45	java/lang/String
    //   1072: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1075: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1078: aload_2
    //   1079: ldc_w 5185
    //   1082: aload_0
    //   1083: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1086: ldc_w 5171
    //   1089: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1092: checkcast 45	java/lang/String
    //   1095: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1098: aload_2
    //   1099: ldc_w 1701
    //   1102: aload_0
    //   1103: aload_0
    //   1104: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1107: ldc_w 1701
    //   1110: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1113: checkcast 45	java/lang/String
    //   1116: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1119: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1122: aload_2
    //   1123: ldc_w 5288
    //   1126: aload_0
    //   1127: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1130: ldc_w 5219
    //   1133: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1136: checkcast 45	java/lang/String
    //   1139: invokestatic 462	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1142: invokevirtual 465	java/lang/Long:longValue	()J
    //   1145: invokestatic 5290	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyTimeUtils:b	(J)Ljava/lang/String;
    //   1148: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1151: aload_2
    //   1152: ldc_w 3327
    //   1155: aload_0
    //   1156: aload_0
    //   1157: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1160: ldc_w 1701
    //   1163: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1166: checkcast 45	java/lang/String
    //   1169: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1172: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1175: aload_3
    //   1176: ldc_w 5292
    //   1179: aload_2
    //   1180: invokestatic 5297	com/tencent/mobileqq/structmsg/StructMsgFactory:a	(Landroid/os/Bundle;)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1183: checkcast 5299	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   1186: invokevirtual 5300	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getBytes	()[B
    //   1189: invokevirtual 5303	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1192: aload_3
    //   1193: ldc_w 5305
    //   1196: iconst_5
    //   1197: invokevirtual 1533	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1200: new 153	android/content/Intent
    //   1203: dup
    //   1204: aload_0
    //   1205: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1208: ldc_w 5307
    //   1211: invokespecial 158	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1214: astore_2
    //   1215: aload_2
    //   1216: aload_3
    //   1217: invokevirtual 821	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1220: pop
    //   1221: iload_1
    //   1222: bipush 6
    //   1224: if_icmpne +44 -> 1268
    //   1227: aload_0
    //   1228: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1231: ldc_w 5309
    //   1234: invokevirtual 366	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1237: ifeq +31 -> 1268
    //   1240: aload_2
    //   1241: ldc_w 5311
    //   1244: aload_0
    //   1245: aload_0
    //   1246: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1249: ldc_w 5309
    //   1252: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1255: checkcast 45	java/lang/String
    //   1258: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1261: invokestatic 5316	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   1264: invokevirtual 2844	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1267: pop
    //   1268: aload_0
    //   1269: getfield 88	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1272: aload_2
    //   1273: invokevirtual 173	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1276: iconst_1
    //   1277: ireturn
    //   1278: astore_2
    //   1279: invokestatic 569	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1282: ifeq -971 -> 311
    //   1285: ldc_w 328
    //   1288: iconst_2
    //   1289: new 254	java/lang/StringBuilder
    //   1292: dup
    //   1293: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1296: ldc_w 5318
    //   1299: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: aload_0
    //   1303: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1306: ldc_w 2606
    //   1309: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1312: checkcast 45	java/lang/String
    //   1315: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: ldc_w 5320
    //   1321: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: aload_0
    //   1325: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1328: ldc_w 5193
    //   1331: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1334: checkcast 45	java/lang/String
    //   1337: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: ldc_w 5322
    //   1343: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: aload_2
    //   1347: invokevirtual 1028	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1350: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1356: invokestatic 1070	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1359: goto -1048 -> 311
    //   1362: aload_3
    //   1363: ldc_w 5203
    //   1366: bipush 100
    //   1368: invokevirtual 1533	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1371: goto -976 -> 395
    //   1374: astore_2
    //   1375: invokestatic 569	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1378: ifeq -102 -> 1276
    //   1381: ldc_w 328
    //   1384: iconst_2
    //   1385: new 254	java/lang/StringBuilder
    //   1388: dup
    //   1389: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1392: ldc_w 5324
    //   1395: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: aload_0
    //   1399: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1402: ldc_w 5211
    //   1405: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1408: checkcast 45	java/lang/String
    //   1411: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: ldc_w 5326
    //   1417: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: aload_0
    //   1421: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1424: ldc_w 5211
    //   1427: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1430: checkcast 45	java/lang/String
    //   1433: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1439: invokestatic 1070	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1442: iconst_1
    //   1443: ireturn
    //   1444: astore_2
    //   1445: invokestatic 569	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1448: ifeq +297 -> 1745
    //   1451: ldc_w 328
    //   1454: iconst_2
    //   1455: new 254	java/lang/StringBuilder
    //   1458: dup
    //   1459: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1462: ldc_w 5328
    //   1465: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: aload_2
    //   1469: invokevirtual 1028	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1472: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1478: invokestatic 1070	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1481: goto +264 -> 1745
    //   1484: astore_2
    //   1485: invokestatic 569	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1488: ifeq -212 -> 1276
    //   1491: ldc_w 328
    //   1494: iconst_2
    //   1495: new 254	java/lang/StringBuilder
    //   1498: dup
    //   1499: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1502: ldc_w 5330
    //   1505: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: aload_0
    //   1509: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1512: ldc_w 5242
    //   1515: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1518: checkcast 45	java/lang/String
    //   1521: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: ldc_w 5332
    //   1527: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: aload_0
    //   1531: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1534: ldc_w 5244
    //   1537: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1540: checkcast 45	java/lang/String
    //   1543: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1549: invokestatic 1070	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1552: iconst_1
    //   1553: ireturn
    //   1554: astore_2
    //   1555: invokestatic 569	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1558: ifeq -282 -> 1276
    //   1561: ldc_w 328
    //   1564: iconst_2
    //   1565: new 254	java/lang/StringBuilder
    //   1568: dup
    //   1569: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1572: ldc_w 5334
    //   1575: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1578: aload_0
    //   1579: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1582: ldc_w 5181
    //   1585: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1588: checkcast 45	java/lang/String
    //   1591: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: ldc_w 5336
    //   1597: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: aload_0
    //   1601: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1604: ldc_w 5219
    //   1607: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1610: checkcast 45	java/lang/String
    //   1613: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1616: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1619: invokestatic 1070	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1622: iconst_1
    //   1623: ireturn
    //   1624: aload_0
    //   1625: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1628: ldc_w 5338
    //   1631: invokevirtual 366	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1634: ifeq +42 -> 1676
    //   1637: aload_0
    //   1638: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1641: ldc_w 5338
    //   1644: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1647: checkcast 1060	java/lang/CharSequence
    //   1650: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1653: ifne +23 -> 1676
    //   1656: aload_2
    //   1657: ldc_w 5274
    //   1660: aload_0
    //   1661: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1664: ldc_w 5338
    //   1667: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1670: checkcast 45	java/lang/String
    //   1673: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1676: aload_2
    //   1677: ldc_w 5276
    //   1680: aload_0
    //   1681: aload_0
    //   1682: getfield 95	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1685: ldc_w 5238
    //   1688: invokevirtual 125	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1691: checkcast 45	java/lang/String
    //   1694: invokespecial 827	com/tencent/mobileqq/utils/JumpAction:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1697: invokevirtual 481	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1700: goto -732 -> 968
    //   1703: astore 4
    //   1705: invokestatic 569	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1708: ifeq -557 -> 1151
    //   1711: ldc_w 328
    //   1714: iconst_2
    //   1715: new 254	java/lang/StringBuilder
    //   1718: dup
    //   1719: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1722: ldc_w 5340
    //   1725: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1728: aload 4
    //   1730: invokevirtual 1028	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1733: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1736: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1739: invokestatic 1070	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1742: goto -591 -> 1151
    //   1745: aconst_null
    //   1746: astore_2
    //   1747: goto -1217 -> 530
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1750	0	this	JumpAction
    //   497	728	1	i1	int
    //   408	865	2	localObject1	Object
    //   1278	69	2	localException1	Exception
    //   1374	1	2	localException2	Exception
    //   1444	25	2	localException3	Exception
    //   1484	1	2	localException4	Exception
    //   1554	123	2	localException5	Exception
    //   1746	1	2	localObject2	Object
    //   7	1356	3	localBundle	Bundle
    //   1703	26	4	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   211	266	1278	java/lang/Exception
    //   266	311	1278	java/lang/Exception
    //   430	478	1374	java/lang/Exception
    //   506	530	1444	java/lang/Exception
    //   606	686	1484	java/lang/Exception
    //   478	506	1554	java/lang/Exception
    //   530	606	1554	java/lang/Exception
    //   686	703	1554	java/lang/Exception
    //   707	729	1554	java/lang/Exception
    //   729	968	1554	java/lang/Exception
    //   968	1122	1554	java/lang/Exception
    //   1151	1221	1554	java/lang/Exception
    //   1227	1268	1554	java/lang/Exception
    //   1268	1276	1554	java/lang/Exception
    //   1445	1481	1554	java/lang/Exception
    //   1485	1552	1554	java/lang/Exception
    //   1624	1676	1554	java/lang/Exception
    //   1676	1700	1554	java/lang/Exception
    //   1705	1742	1554	java/lang/Exception
    //   1122	1151	1703	java/lang/Exception
  }
  
  public boolean s()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, AssistantSettingActivity.class);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean t()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
    Intent localIntent = new Intent((Activity)this.jdField_a_of_type_AndroidContentContext, ApolloGuestsStateActivity.class);
    localIntent.putExtra("extra_guest_nick", str1);
    localIntent.putExtra("extra_guest_uin", str2);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivity(localIntent);
    return true;
  }
  
  public boolean u()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, NearbyVisitorListActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("isJumpAction", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean v()
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
  
  public boolean w()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("roomid")) {}
    String str2;
    for (String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");; str2 = "0")
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("fromid")) {}
      for (Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");; localObject1 = "")
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("roomtype")) {}
        for (Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomtype");; localObject2 = "")
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("list_name")) {}
          for (String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("list_name");; str3 = "")
          {
            if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("first_jump_mode")) {}
            String str4;
            for (Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("first_jump_mode");; str4 = "h5")
            {
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("need_record")) {}
              for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("need_record");; str5 = "1")
              {
                if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("is_record")) {}
                for (String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("is_record");; str6 = "0")
                {
                  if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("enter_record_if_finish")) {}
                  for (String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enter_record_if_finish");; str7 = "1")
                  {
                    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("nowapp_ext")) {}
                    for (String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nowapp_ext");; str8 = "")
                    {
                      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("nowplugin_ext")) {}
                      for (String str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nowplugin_ext");; str9 = "")
                      {
                        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("h5_ext")) {}
                        for (String str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("h5_ext");; str10 = "")
                        {
                          String str13 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("coverurl");
                          String str14 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extras");
                          String str11 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
                          String str12 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("first");
                          Bundle localBundle = new Bundle();
                          localBundle.putString("coverurl", str13);
                          localBundle.putString("roomid", str1);
                          localBundle.putString("roomtype", (String)localObject2);
                          localBundle.putString("extras_from_js", str14);
                          localBundle.putBoolean("can_use_h5_first", true);
                          localBundle.putString("first_jump_mode", (String)localObject3);
                          localBundle.putString("is_record", str6);
                          localBundle.putString("enter_record_if_finish", str7);
                          localBundle.putString("nowapp_ext", str8);
                          localBundle.putString("nowplugin_ext", str9);
                          localBundle.putString("h5_ext", str10);
                          boolean bool2 = true;
                          boolean bool1 = bool2;
                          if (!TextUtils.isEmpty(str5))
                          {
                            bool1 = bool2;
                            if ("0".equals(str5)) {
                              bool1 = false;
                            }
                          }
                          localBundle.putBoolean("need_record", bool1);
                          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("topic")) {
                            localBundle.putString("topic", (String)this.jdField_a_of_type_JavaUtilHashMap.get("topic"));
                          }
                          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("story_ext")) {
                            localBundle.putString("story_ext", (String)this.jdField_a_of_type_JavaUtilHashMap.get("story_ext"));
                          }
                          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("startsrc")) {
                            localBundle.putString("startsrc", (String)this.jdField_a_of_type_JavaUtilHashMap.get("startsrc"));
                          }
                          for (;;)
                          {
                            try
                            {
                              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                              localObject2 = (NowProxy)((QQAppInterface)localObject2).getManager(181);
                              if (!TextUtils.isEmpty(str12))
                              {
                                i1 = Integer.parseInt(str12);
                                if (i1 != 0) {}
                              }
                              else
                              {
                                int i2 = 0;
                                try
                                {
                                  i1 = Integer.parseInt(str11);
                                  i1 = SharedPreUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i1);
                                  localObject3 = new NowFromData();
                                  ((NowFromData)localObject3).jdField_b_of_type_JavaLangString = "actiondata";
                                  ((NowFromData)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
                                  localObject1 = new ArrayList();
                                  ((ArrayList)localObject1).add(str3);
                                  return ((NowProxy)localObject2).a(new NowProxy.ListNameData((ArrayList)localObject1, 0), Long.parseLong(str1), (NowFromData)localObject3, i1, localBundle);
                                }
                                catch (NumberFormatException localNumberFormatException)
                                {
                                  i1 = i2;
                                  if (!QLog.isColorLevel()) {
                                    continue;
                                  }
                                  QLog.e("JumpAction", 2, localNumberFormatException.toString());
                                  i1 = i2;
                                  continue;
                                }
                              }
                              int i1 = Integer.parseInt(str12);
                            }
                            catch (Exception localException)
                            {
                              if (QLog.isColorLevel()) {
                                QLog.e("JumpAction", 2, localException.toString());
                              }
                              return false;
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
  
  public boolean x()
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
  
  protected boolean y()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(str1);
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
      ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131430620));
      ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131430203));
      ((Intent)localObject).putExtra("param_is_troop_admin", bool);
      ((Intent)localObject).putExtra("param_donot_need_contacts", true);
      if (!bool) {
        ((Intent)localObject).putExtra("param_max", 10);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
    }
    QLog.e("JumpAction", 1, "troopInfo not found");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction
 * JD-Core Version:    0.7.0.1
 */