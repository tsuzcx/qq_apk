package com.tencent.mobileqq.config.splashlogo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.av.QAVConfig;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.readinjoy.logic.FeManager;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.config.TextFilterConfig;
import com.tencent.biz.qqstory.troop.TroopDynamicConfig;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.biz.troopconfig.TroopConfigForAllUser;
import com.tencent.biz.troopgift.GiftConfigManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.SafeModeUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.device.qfind.QFindConfigUtil;
import com.tencent.hotpatch.PatchFileManager;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.hotpatch.config.PatchConfigServlet;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.AIOConfigManager;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.photo.PhotoListConfigManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityBannerData;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.recent.RecentPubAccManager;
import com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import com.tencent.mobileqq.activity.shortvideo.ProgressiveUtils;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.soso.LbsInfoReportManager;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.ar.ARGlobalConfigManager;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.ar.ArResourceManager;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigParser;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.struct.NearbyBannerManager;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.OS;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.ReportedBanner;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager.ConfigLoader;
import com.tencent.mobileqq.identification.IdentificationActivityHelper;
import com.tencent.mobileqq.intervideo.now.NowGeneralConfigManager;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.managers.TimUpgradeHongdianManager;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.NearbyVideoUtils;
import com.tencent.mobileqq.ocr.OCRManager;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.olympic.OlympicActConfig;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicServlet;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.precover.PrecoverControl;
import com.tencent.mobileqq.precover.PrecoverManager;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.mobileqq.ptt.PttConfigController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.util.PAOfflineSearchManager;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.soload.config.SoLoadConfProcessor;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.homework.config.HomeworkConfig;
import com.tencent.mobileqq.troop.homework.recite.config.ReciteConfig;
import com.tencent.mobileqq.troop.utils.NearbyVideoChatManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.upgrade.UpgradeConfigManager;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeController.OnHandleUpgradeFinishListener;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.JumpForwardPkgManager;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vashealth.SportManager;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.notification.NotificationController;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import cooperation.readinjoy.AioReadInJoyConfigManager;
import cooperation.readinjoy.ReadInJoyHelper;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.data.CaptureTemplateManager;
import dov.com.qq.im.capture.util.ConfigSimplifier;
import dov.com.tencent.mobileqq.richmedia.capture.util.DovSVParamManager;
import dov.com.tencent.mobileqq.shortvideo.QIMBeautyManager;
import dov.com.tencent.mobileqq.shortvideo.QQStoryFollowCaptureResManager;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.InflaterInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import protocol.KQQConfig.UpgradeInfo;

public class ConfigServlet
{
  public static String a;
  public static final int[] a;
  private static String b;
  private boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131702483);
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 2, 3, 5, 10, 13, 23, 31, 38, 42, 44, 46, 47, 49, 50, 53, 55, 56, 57, 61, 62, 63, 64, 65, 66, 69, 206, 205, 72, 73, 74, 75, 385, 94, 78, 79, 80, 84, 223, 82, 101, 102, 147, 86, 93, 88, 90, 96, 97, 108, 146, 111, 109, 115, 286, 118, 119, 116, 130, 142, 121, 157, 211, 201, 129, 143, 140, 257, 232, 233, 148, 139, 145, 153, 149, 155, 165, 185, 167, 166, 171, 180, 182, 177, 371, 181, 184, 187, 191, 193, 188, 195, 227, 202, 190, 210, 199, 212, 407, StoryApi.a(2131427352), StoryApi.a(2131427353), StoryApi.a(2131427354), StoryApi.a(2131427349), StoryApi.a(2131427350), 218, 226, 225, 222, 256, 228, 235, 234, 238, 247, 244, 245, 253, 295, 254, 259, 260, 262, 204, 271, 267, 275, 358, 268, 269, 272, 274, 279, 308, 281, 283, 284, 280, 289, 314, 297, 301, 296, 330, 347, 313, 312, 397, 321, 326, 320, 328, 331, 336, 329, 337, 345, 351, 349, 355, 372, 384, 379, 357, 378, 381, 273, 364, 365, 369, 387, 386, 392, 393, 394, 401, 400, 403, 404, 405, 408, 410, 194, 596, 604, 705 };
  }
  
  public ConfigServlet()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static void Q(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.aS(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      SharedPreUtils.ai(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = paramConfig.iterator();
        while (paramConfig.hasNext())
        {
          Object localObject = (String)paramConfig.next();
          try
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("isWeiYunMiniApp"))
            {
              i = ((JSONObject)localObject).getInt("isWeiYunMiniApp");
              SharedPreUtils.w(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, enableMiniApp = " + i);
              }
            }
            if (((JSONObject)localObject).has("apkgUrl"))
            {
              String str = ((JSONObject)localObject).getString("apkgUrl");
              SharedPreUtils.v(BaseApplication.getContext(), str, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, apkgUrl = " + str);
              }
            }
            if (((JSONObject)localObject).has("miniVersion"))
            {
              i = ((JSONObject)localObject).getInt("miniVersion");
              SharedPreUtils.x(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, miniVersion = " + i);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig:localVersiont == version ");
    }
  }
  
  public static void R(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.aY(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleAIOConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      SharedPreUtils.ak(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        SharedPreUtils.c(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "aio_config_key", paramConfig);
        AIOConfigManager.a(paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
  }
  
  public static void S(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.aZ(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      SharedPreUtils.al(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        i = new JSONObject((String)paramConfig.get(paramConfig.size() - 1)).optInt("max_multimsg_totalcount");
        SharedPreUtils.g(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "multimsg_config", i);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig:limitTotal =  " + i);
        }
        MultiMsgManager.a().a(paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
  }
  
  private void T(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.aA(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      SharedPreUtils.U(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {
        break label438;
      }
      Iterator localIterator = paramConfig.iterator();
      paramConfig = null;
      if (!localIterator.hasNext()) {
        break label438;
      }
      Object localObject1 = (String)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig: config_content =" + (String)localObject1);
      }
      for (;;)
      {
        Object localObject3;
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          if (((JSONObject)localObject1).has("enable"))
          {
            i = ((JSONObject)localObject1).getInt("enable");
            localObject3 = RecentPubAccManager.a();
            if (i == 1)
            {
              bool = true;
              ((RecentPubAccManager)localObject3).a(paramQQAppInterface, bool);
              if (!((JSONObject)localObject1).has("list")) {
                break label412;
              }
              localObject3 = ((JSONObject)localObject1).getJSONArray("list");
              if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
                break label401;
              }
              j = ((JSONArray)localObject3).length();
              localObject1 = new HashSet();
              i = 0;
              if (i >= j) {
                break;
              }
            }
          }
        }
        catch (JSONException localJSONException1) {}
        try
        {
          paramConfig = ((JSONArray)localObject3).optString(i);
          if (!TextUtils.isEmpty(paramConfig)) {
            ((HashSet)localObject1).add(paramConfig);
          }
          i += 1;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            paramConfig = localJSONException1;
            localObject2 = localJSONException2;
          }
        }
        boolean bool = false;
        continue;
        RecentPubAccManager.a().a(paramQQAppInterface, false);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig  error =" + localJSONException1.getMessage());
        }
        RecentPubAccManager.a().a(paramQQAppInterface, false);
        RecentPubAccManager.a().a(paramQQAppInterface, null);
      }
    }
    label401:
    label412:
    label438:
    label439:
    for (;;)
    {
      break;
      RecentPubAccManager.a().a(paramQQAppInterface, localJSONException1);
      paramConfig = localJSONException1;
      continue;
      Object localObject2;
      RecentPubAccManager.a().a(paramQQAppInterface, paramConfig);
      break label439;
      RecentPubAccManager.a().a(paramQQAppInterface, paramConfig);
      break label439;
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig:localVersiont == version ");
      }
      return;
    }
  }
  
  private void U(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.a();
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      SharedPreUtils.a(i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfigStr: " + paramConfig);
        }
        SharedPreUtils.b(paramConfig);
        ((BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).a(paramConfig);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig:localVersiont == version ");
  }
  
  private void V(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.az(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      SharedPreUtils.T(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = paramConfig.iterator();
        if (paramConfig.hasNext())
        {
          Object localObject = (String)paramConfig.next();
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig: config_content =" + (String)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = new JSONObject((String)localObject);
              ZhituManager localZhituManager;
              if (((JSONObject)localObject).has("kMarioConfigEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioConfigEnable");
                localZhituManager = ZhituManager.a(paramQQAppInterface);
                if (i != 1) {
                  break label323;
                }
                bool = true;
                localZhituManager.a(bool);
              }
              if (((JSONObject)localObject).has("kMarioPageLen"))
              {
                i = ((JSONObject)localObject).getInt("kMarioPageLen");
                ZhituManager.a(paramQQAppInterface).b(i);
              }
              if (((JSONObject)localObject).has("kMarioSaveAndShareEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioSaveAndShareEnable");
                localZhituManager = ZhituManager.a(paramQQAppInterface);
                if (i != 1) {
                  break label329;
                }
                bool = true;
                localZhituManager.b(bool);
              }
              if (!((JSONObject)localObject).has("kMarioSafeGateRequestInterval")) {
                break;
              }
              i = ((JSONObject)localObject).getInt("kMarioSafeGateRequestInterval");
              ZhituManager.a(paramQQAppInterface).a(i);
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
            break;
            label323:
            boolean bool = false;
            continue;
            label329:
            bool = false;
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig:localVersiont == version ");
    }
  }
  
  private void W(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    a(paramQQAppInterface, paramConfig, "handleShortVideoMsgTailConfig", new ConfigServlet.2(this, paramQQAppInterface));
  }
  
  private void X(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.g(paramQQAppInterface.getApp());
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, "handleTroopRankConfigCmd, serverVersion=" + i + "|localVersion=" + j);
    }
    byte[] arrayOfByte;
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label288;
        }
        arrayOfByte = OlympicUtil.a(paramConfig.content.get().toByteArray());
        if (arrayOfByte == null) {
          break label283;
        }
      }
    }
    label283:
    label288:
    do
    {
      for (;;)
      {
        try
        {
          paramConfig = new String(arrayOfByte, "UTF-8");
          if (TextUtils.isEmpty(paramConfig)) {
            break;
          }
          boolean bool = TroopRankConfig.a(paramConfig);
          if (bool) {
            SharedPreUtils.e(paramQQAppInterface.getApp(), i);
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopRankConfig", 2, "refreshConfig ret=" + bool);
          }
          return;
        }
        catch (Exception paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", paramConfig);
          }
          paramConfig = null;
          continue;
        }
        catch (OutOfMemoryError paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", paramConfig);
          }
          System.gc();
          try
          {
            paramConfig = new String(arrayOfByte, "UTF-8");
          }
          catch (Throwable paramConfig)
          {
            if (QLog.isColorLevel()) {
              QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", paramConfig);
            }
          }
        }
        paramConfig = null;
        continue;
        paramConfig = paramConfig.content.get().toStringUtf8();
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopRankConfig", 2, "handleTroopRankConfigCmd, config_content is empty");
  }
  
  private void Y(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            localObject = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 96,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j == SharedPreUtils.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject))) {
              break label412;
            }
            localObject = ((String)localObject).split("=");
            if (localObject.length >= 2)
            {
              if (!"xqh_insert_into_feeds".equals(localObject[0])) {
                continue;
              }
              ReadInJoyHelper.c(paramQQAppInterface, "1".equals(localObject[1]));
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "update KANDIAN_INTERESTED_PUSH_CONFiG config , switch : " + "1".equals(localObject[1]));
              }
            }
            SharedPreUtils.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString, j);
            break label469;
            if ("simple_switch_fm".equals(localObject[0]))
            {
              ReadInJoyHelper.c(paramQQAppInterface, "1".equals(localObject[1]));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("SPLASH_ConfigServlet", 2, "update READINJOY_SIMPLE_SWITCH_FM config , switch : " + "1".equals(localObject[1]));
              continue;
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy interested push config error,cmd : 96" + paramQQAppInterface.toString());
        }
      }
      label412:
      do
      {
        if (!"simple_force_report_once".equals(localObject[0])) {
          break;
        }
        FeManager.a(paramQQAppInterface, "1".equals(localObject[1]));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "update simple_force_report_once config , switch : " + "1".equals(localObject[1]));
        break;
        if (!QLog.isColorLevel()) {
          break label469;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "received KANDIAN_INTERESTED_PUSH_CONFiG IGNORE THIS ACTION  because of SAME VERSION ");
        break label469;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 96,content_list is empty ,version: " + paramConfig.version.get());
      return;
      label469:
      i += 1;
    }
  }
  
  private void Z(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.o(paramQQAppInterface.getApp());
    if (QLog.isColorLevel()) {
      QLog.d("VideoDownCTWhiteList", 2, String.format("received VideoDownCTWhiteList remote version: %d, localVersion: %d, cmd: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(80) }));
    }
    if (i != j)
    {
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label159;
      }
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 80,content: " + str + ",version: " + paramConfig.version.get());
      }
      SharedPreUtils.l(paramQQAppInterface.getApp(), i, str);
    }
    label159:
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 80,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private float a(float paramFloat)
  {
    return paramFloat / (50.0F * 2.0F) * (float)DeviceInfoUtil.g();
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return (50.0F + paramFloat1) / (50.0F * 2.0F) * paramFloat2;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 / 2.0F - paramFloat1 * paramFloat3 / (50.0F * 2.0F);
  }
  
  private int a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString)
  {
    AEOldShortVideoResManager localAEOldShortVideoResManager = AEOldShortVideoResManager.a(paramQQAppInterface);
    if ((localAEOldShortVideoResManager == null) && ("ConfigurationService.ReqGetConfigNoLogin".equals(paramString))) {
      localAEOldShortVideoResManager = new AEOldShortVideoResManager(paramQQAppInterface);
    }
    for (int j = 1;; j = 0)
    {
      int i = AEOldShortVideoResManager.a();
      int k = paramConfig.version.get();
      QLog.d("AEOldShortVideoResManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|received remote version: " + k + " | localVersion: " + i);
      if (k != i) {
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
        {
          paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramConfig.msg_content_list.size() - 1);
          if (paramConfig != null) {
            if (paramConfig.compress.get() == 1)
            {
              paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
              if (paramConfig == null) {}
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          paramConfig = new String(paramConfig, "UTF-8");
          QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|config_content " + paramConfig);
          if (!"ConfigurationService.ReqGetConfigNoLogin".equals(paramString)) {
            break label300;
          }
          i = localAEOldShortVideoResManager.a(paramConfig, k);
          if (j != 0) {
            localAEOldShortVideoResManager.c();
          }
          return i;
        }
        catch (Throwable paramConfig)
        {
          QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|Throwable:" + paramConfig.getMessage());
          paramConfig = "";
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|inflateConfigString error!");
        paramConfig = "";
        continue;
        paramConfig = paramConfig.content.get().toStringUtf8();
        continue;
        label300:
        i = localAEOldShortVideoResManager.a(paramQQAppInterface.getApp(), paramConfig, k);
        continue;
        QLog.d("AEOldShortVideoResManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]| content==null");
        i = -125;
        continue;
        QLog.d("AEOldShortVideoResManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]| msg_content_list is empty ,version: " + k + ",localVersion:" + i);
        i = -125;
        continue;
        i = 0;
      }
    }
  }
  
  private static int a(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
    try
    {
      long l = (localSimpleDateFormat.parse(paramString2).getTime() - localSimpleDateFormat.parse(paramString1).getTime()) / 86400000L;
      return (int)l;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  private QQOperationViopTipTask a(String paramString)
  {
    return a(paramString, new QQOperationViopTipTask());
  }
  
  /* Error */
  private QQOperationViopTipTask a(String paramString, QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 636	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   5: invokevirtual 640	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   8: new 642	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_1
    //   13: ldc_w 644
    //   16: invokevirtual 648	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   19: invokespecial 651	java/io/ByteArrayInputStream:<init>	([B)V
    //   22: invokevirtual 656	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   25: astore_1
    //   26: aload_1
    //   27: ldc_w 658
    //   30: invokeinterface 664 2 0
    //   35: astore 4
    //   37: aload 4
    //   39: ifnull +1254 -> 1293
    //   42: aload 4
    //   44: invokeinterface 669 1 0
    //   49: ifle +1244 -> 1293
    //   52: aload_1
    //   53: ldc_w 671
    //   56: invokeinterface 664 2 0
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +45 -> 110
    //   68: aload 4
    //   70: invokeinterface 669 1 0
    //   75: ifle +35 -> 110
    //   78: aload_2
    //   79: aload_1
    //   80: ldc_w 671
    //   83: invokeinterface 664 2 0
    //   88: iconst_0
    //   89: invokeinterface 675 2 0
    //   94: invokeinterface 681 1 0
    //   99: invokeinterface 684 1 0
    //   104: invokestatic 687	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: putfield 690	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   110: aload_1
    //   111: ldc_w 692
    //   114: invokeinterface 664 2 0
    //   119: astore 4
    //   121: aload 4
    //   123: ifnull +45 -> 168
    //   126: aload 4
    //   128: invokeinterface 669 1 0
    //   133: ifle +35 -> 168
    //   136: aload_2
    //   137: aload_1
    //   138: ldc_w 692
    //   141: invokeinterface 664 2 0
    //   146: iconst_0
    //   147: invokeinterface 675 2 0
    //   152: invokeinterface 681 1 0
    //   157: invokeinterface 684 1 0
    //   162: invokestatic 687	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: putfield 695	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOCount	I
    //   168: aload_1
    //   169: ldc_w 697
    //   172: invokeinterface 664 2 0
    //   177: astore 4
    //   179: aload 4
    //   181: ifnull +45 -> 226
    //   184: aload 4
    //   186: invokeinterface 669 1 0
    //   191: ifle +35 -> 226
    //   194: aload_2
    //   195: aload_1
    //   196: ldc_w 697
    //   199: invokeinterface 664 2 0
    //   204: iconst_0
    //   205: invokeinterface 675 2 0
    //   210: invokeinterface 681 1 0
    //   215: invokeinterface 684 1 0
    //   220: invokestatic 687	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   223: putfield 700	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOShowCount	I
    //   226: aload_1
    //   227: ldc_w 702
    //   230: invokeinterface 664 2 0
    //   235: astore 4
    //   237: aload 4
    //   239: ifnull +45 -> 284
    //   242: aload 4
    //   244: invokeinterface 669 1 0
    //   249: ifle +35 -> 284
    //   252: aload_2
    //   253: aload_1
    //   254: ldc_w 702
    //   257: invokeinterface 664 2 0
    //   262: iconst_0
    //   263: invokeinterface 675 2 0
    //   268: invokeinterface 681 1 0
    //   273: invokeinterface 684 1 0
    //   278: invokestatic 687	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   281: putfield 705	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalAIOCount	I
    //   284: aload_1
    //   285: ldc_w 707
    //   288: invokeinterface 664 2 0
    //   293: astore 4
    //   295: aload 4
    //   297: ifnull +45 -> 342
    //   300: aload 4
    //   302: invokeinterface 669 1 0
    //   307: ifle +35 -> 342
    //   310: aload_2
    //   311: aload_1
    //   312: ldc_w 707
    //   315: invokeinterface 664 2 0
    //   320: iconst_0
    //   321: invokeinterface 675 2 0
    //   326: invokeinterface 681 1 0
    //   331: invokeinterface 684 1 0
    //   336: invokestatic 687	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   339: putfield 710	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalShowCount	I
    //   342: aload_1
    //   343: ldc_w 712
    //   346: invokeinterface 664 2 0
    //   351: astore 4
    //   353: aload 4
    //   355: ifnull +42 -> 397
    //   358: aload 4
    //   360: invokeinterface 669 1 0
    //   365: ifle +32 -> 397
    //   368: aload_2
    //   369: aload_1
    //   370: ldc_w 712
    //   373: invokeinterface 664 2 0
    //   378: iconst_0
    //   379: invokeinterface 675 2 0
    //   384: invokeinterface 681 1 0
    //   389: invokeinterface 684 1 0
    //   394: invokevirtual 715	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setKeywordString	(Ljava/lang/String;)V
    //   397: invokestatic 718	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   400: ifeq +33 -> 433
    //   403: ldc_w 720
    //   406: iconst_4
    //   407: new 79	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 722
    //   417: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_2
    //   421: invokevirtual 726	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getKeywordList	()Ljava/util/ArrayList;
    //   424: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_1
    //   434: ldc_w 731
    //   437: invokeinterface 664 2 0
    //   442: astore 4
    //   444: aload 4
    //   446: ifnull +42 -> 488
    //   449: aload 4
    //   451: invokeinterface 669 1 0
    //   456: ifle +32 -> 488
    //   459: aload_2
    //   460: aload_1
    //   461: ldc_w 731
    //   464: invokeinterface 664 2 0
    //   469: iconst_0
    //   470: invokeinterface 675 2 0
    //   475: invokeinterface 681 1 0
    //   480: invokeinterface 684 1 0
    //   485: invokevirtual 734	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setBeginTime	(Ljava/lang/String;)V
    //   488: aload_1
    //   489: ldc_w 736
    //   492: invokeinterface 664 2 0
    //   497: astore 4
    //   499: aload 4
    //   501: ifnull +42 -> 543
    //   504: aload 4
    //   506: invokeinterface 669 1 0
    //   511: ifle +32 -> 543
    //   514: aload_2
    //   515: aload_1
    //   516: ldc_w 736
    //   519: invokeinterface 664 2 0
    //   524: iconst_0
    //   525: invokeinterface 675 2 0
    //   530: invokeinterface 681 1 0
    //   535: invokeinterface 684 1 0
    //   540: invokevirtual 739	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setEndTime	(Ljava/lang/String;)V
    //   543: aload_1
    //   544: ldc_w 741
    //   547: invokeinterface 664 2 0
    //   552: astore 4
    //   554: aload 4
    //   556: ifnull +50 -> 606
    //   559: aload 4
    //   561: invokeinterface 669 1 0
    //   566: ifle +40 -> 606
    //   569: aload_1
    //   570: ldc_w 741
    //   573: invokeinterface 664 2 0
    //   578: iconst_0
    //   579: invokeinterface 675 2 0
    //   584: invokeinterface 681 1 0
    //   589: invokeinterface 684 1 0
    //   594: invokestatic 687	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   597: iconst_1
    //   598: if_icmpne +697 -> 1295
    //   601: aload_2
    //   602: iload_3
    //   603: putfield 744	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:uinType	I
    //   606: aload_1
    //   607: ldc_w 746
    //   610: invokeinterface 664 2 0
    //   615: astore 4
    //   617: aload 4
    //   619: ifnull +197 -> 816
    //   622: aload 4
    //   624: invokeinterface 669 1 0
    //   629: ifle +187 -> 816
    //   632: aload_1
    //   633: ldc_w 746
    //   636: invokeinterface 664 2 0
    //   641: iconst_0
    //   642: invokeinterface 675 2 0
    //   647: checkcast 748	org/w3c/dom/Element
    //   650: ldc_w 750
    //   653: invokeinterface 751 2 0
    //   658: astore 4
    //   660: aload 4
    //   662: ifnull +62 -> 724
    //   665: aload 4
    //   667: invokeinterface 669 1 0
    //   672: ifle +52 -> 724
    //   675: aload_2
    //   676: aload_1
    //   677: ldc_w 746
    //   680: invokeinterface 664 2 0
    //   685: iconst_0
    //   686: invokeinterface 675 2 0
    //   691: checkcast 748	org/w3c/dom/Element
    //   694: ldc_w 750
    //   697: invokeinterface 751 2 0
    //   702: iconst_0
    //   703: invokeinterface 675 2 0
    //   708: invokeinterface 681 1 0
    //   713: invokeinterface 684 1 0
    //   718: invokestatic 687	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   721: putfield 754	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyTime	I
    //   724: aload_1
    //   725: ldc_w 746
    //   728: invokeinterface 664 2 0
    //   733: iconst_0
    //   734: invokeinterface 675 2 0
    //   739: checkcast 748	org/w3c/dom/Element
    //   742: ldc_w 756
    //   745: invokeinterface 751 2 0
    //   750: astore 4
    //   752: aload 4
    //   754: ifnull +62 -> 816
    //   757: aload 4
    //   759: invokeinterface 669 1 0
    //   764: ifle +52 -> 816
    //   767: aload_2
    //   768: aload_1
    //   769: ldc_w 746
    //   772: invokeinterface 664 2 0
    //   777: iconst_0
    //   778: invokeinterface 675 2 0
    //   783: checkcast 748	org/w3c/dom/Element
    //   786: ldc_w 756
    //   789: invokeinterface 751 2 0
    //   794: iconst_0
    //   795: invokeinterface 675 2 0
    //   800: invokeinterface 681 1 0
    //   805: invokeinterface 684 1 0
    //   810: invokestatic 687	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   813: putfield 759	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyMessage	I
    //   816: aload_1
    //   817: ldc_w 761
    //   820: invokeinterface 664 2 0
    //   825: astore 4
    //   827: aload 4
    //   829: ifnull +464 -> 1293
    //   832: aload 4
    //   834: invokeinterface 669 1 0
    //   839: ifle +454 -> 1293
    //   842: aload_1
    //   843: ldc_w 761
    //   846: invokeinterface 664 2 0
    //   851: iconst_0
    //   852: invokeinterface 675 2 0
    //   857: checkcast 748	org/w3c/dom/Element
    //   860: ldc_w 763
    //   863: invokeinterface 751 2 0
    //   868: astore 4
    //   870: aload 4
    //   872: ifnull +62 -> 934
    //   875: aload 4
    //   877: invokeinterface 669 1 0
    //   882: ifle +52 -> 934
    //   885: aload_2
    //   886: aload_1
    //   887: ldc_w 761
    //   890: invokeinterface 664 2 0
    //   895: iconst_0
    //   896: invokeinterface 675 2 0
    //   901: checkcast 748	org/w3c/dom/Element
    //   904: ldc_w 763
    //   907: invokeinterface 751 2 0
    //   912: iconst_0
    //   913: invokeinterface 675 2 0
    //   918: invokeinterface 681 1 0
    //   923: invokeinterface 684 1 0
    //   928: invokestatic 687	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   931: putfield 766	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:tipType	I
    //   934: aload_1
    //   935: ldc_w 761
    //   938: invokeinterface 664 2 0
    //   943: iconst_0
    //   944: invokeinterface 675 2 0
    //   949: checkcast 748	org/w3c/dom/Element
    //   952: ldc_w 756
    //   955: invokeinterface 751 2 0
    //   960: astore 4
    //   962: aload 4
    //   964: ifnull +59 -> 1023
    //   967: aload 4
    //   969: invokeinterface 669 1 0
    //   974: ifle +49 -> 1023
    //   977: aload_2
    //   978: aload_1
    //   979: ldc_w 761
    //   982: invokeinterface 664 2 0
    //   987: iconst_0
    //   988: invokeinterface 675 2 0
    //   993: checkcast 748	org/w3c/dom/Element
    //   996: ldc_w 756
    //   999: invokeinterface 751 2 0
    //   1004: iconst_0
    //   1005: invokeinterface 675 2 0
    //   1010: invokeinterface 681 1 0
    //   1015: invokeinterface 684 1 0
    //   1020: putfield 769	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:adwords	Ljava/lang/String;
    //   1023: aload_1
    //   1024: ldc_w 761
    //   1027: invokeinterface 664 2 0
    //   1032: iconst_0
    //   1033: invokeinterface 675 2 0
    //   1038: checkcast 748	org/w3c/dom/Element
    //   1041: ldc_w 771
    //   1044: invokeinterface 751 2 0
    //   1049: astore 4
    //   1051: aload 4
    //   1053: ifnull +62 -> 1115
    //   1056: aload 4
    //   1058: invokeinterface 669 1 0
    //   1063: ifle +52 -> 1115
    //   1066: aload_2
    //   1067: aload_1
    //   1068: ldc_w 761
    //   1071: invokeinterface 664 2 0
    //   1076: iconst_0
    //   1077: invokeinterface 675 2 0
    //   1082: checkcast 748	org/w3c/dom/Element
    //   1085: ldc_w 771
    //   1088: invokeinterface 751 2 0
    //   1093: iconst_0
    //   1094: invokeinterface 675 2 0
    //   1099: invokeinterface 681 1 0
    //   1104: invokeinterface 684 1 0
    //   1109: invokestatic 687	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1112: putfield 774	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:linkOffset	I
    //   1115: aload_1
    //   1116: ldc_w 761
    //   1119: invokeinterface 664 2 0
    //   1124: iconst_0
    //   1125: invokeinterface 675 2 0
    //   1130: checkcast 748	org/w3c/dom/Element
    //   1133: ldc_w 776
    //   1136: invokeinterface 751 2 0
    //   1141: astore 4
    //   1143: aload 4
    //   1145: ifnull +59 -> 1204
    //   1148: aload 4
    //   1150: invokeinterface 669 1 0
    //   1155: ifle +49 -> 1204
    //   1158: aload_2
    //   1159: aload_1
    //   1160: ldc_w 761
    //   1163: invokeinterface 664 2 0
    //   1168: iconst_0
    //   1169: invokeinterface 675 2 0
    //   1174: checkcast 748	org/w3c/dom/Element
    //   1177: ldc_w 776
    //   1180: invokeinterface 751 2 0
    //   1185: iconst_0
    //   1186: invokeinterface 675 2 0
    //   1191: invokeinterface 681 1 0
    //   1196: invokeinterface 684 1 0
    //   1201: putfield 779	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:clickableWord	Ljava/lang/String;
    //   1204: aload_1
    //   1205: ldc_w 761
    //   1208: invokeinterface 664 2 0
    //   1213: iconst_0
    //   1214: invokeinterface 675 2 0
    //   1219: checkcast 748	org/w3c/dom/Element
    //   1222: ldc_w 781
    //   1225: invokeinterface 751 2 0
    //   1230: astore 4
    //   1232: aload 4
    //   1234: ifnull +59 -> 1293
    //   1237: aload 4
    //   1239: invokeinterface 669 1 0
    //   1244: ifle +49 -> 1293
    //   1247: aload_2
    //   1248: aload_1
    //   1249: ldc_w 761
    //   1252: invokeinterface 664 2 0
    //   1257: iconst_0
    //   1258: invokeinterface 675 2 0
    //   1263: checkcast 748	org/w3c/dom/Element
    //   1266: ldc_w 781
    //   1269: invokeinterface 751 2 0
    //   1274: iconst_0
    //   1275: invokeinterface 675 2 0
    //   1280: invokeinterface 681 1 0
    //   1285: invokeinterface 684 1 0
    //   1290: putfield 783	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:url	Ljava/lang/String;
    //   1293: aload_2
    //   1294: areturn
    //   1295: sipush 3000
    //   1298: istore_3
    //   1299: goto -698 -> 601
    //   1302: astore_1
    //   1303: aload_1
    //   1304: invokevirtual 784	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   1307: aconst_null
    //   1308: areturn
    //   1309: astore_1
    //   1310: aload_1
    //   1311: invokevirtual 785	org/xml/sax/SAXException:printStackTrace	()V
    //   1314: goto -7 -> 1307
    //   1317: astore_1
    //   1318: aload_1
    //   1319: invokevirtual 786	java/io/IOException:printStackTrace	()V
    //   1322: goto -15 -> 1307
    //   1325: astore_1
    //   1326: aload_1
    //   1327: invokevirtual 205	java/lang/Exception:printStackTrace	()V
    //   1330: goto -23 -> 1307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1333	0	this	ConfigServlet
    //   0	1333	1	paramString	String
    //   0	1333	2	paramQQOperationViopTipTask	QQOperationViopTipTask
    //   1	1298	3	i	int
    //   35	1203	4	localNodeList	NodeList
    // Exception table:
    //   from	to	target	type
    //   2	37	1302	javax/xml/parsers/ParserConfigurationException
    //   42	63	1302	javax/xml/parsers/ParserConfigurationException
    //   68	110	1302	javax/xml/parsers/ParserConfigurationException
    //   110	121	1302	javax/xml/parsers/ParserConfigurationException
    //   126	168	1302	javax/xml/parsers/ParserConfigurationException
    //   168	179	1302	javax/xml/parsers/ParserConfigurationException
    //   184	226	1302	javax/xml/parsers/ParserConfigurationException
    //   226	237	1302	javax/xml/parsers/ParserConfigurationException
    //   242	284	1302	javax/xml/parsers/ParserConfigurationException
    //   284	295	1302	javax/xml/parsers/ParserConfigurationException
    //   300	342	1302	javax/xml/parsers/ParserConfigurationException
    //   342	353	1302	javax/xml/parsers/ParserConfigurationException
    //   358	397	1302	javax/xml/parsers/ParserConfigurationException
    //   397	433	1302	javax/xml/parsers/ParserConfigurationException
    //   433	444	1302	javax/xml/parsers/ParserConfigurationException
    //   449	488	1302	javax/xml/parsers/ParserConfigurationException
    //   488	499	1302	javax/xml/parsers/ParserConfigurationException
    //   504	543	1302	javax/xml/parsers/ParserConfigurationException
    //   543	554	1302	javax/xml/parsers/ParserConfigurationException
    //   559	601	1302	javax/xml/parsers/ParserConfigurationException
    //   601	606	1302	javax/xml/parsers/ParserConfigurationException
    //   606	617	1302	javax/xml/parsers/ParserConfigurationException
    //   622	660	1302	javax/xml/parsers/ParserConfigurationException
    //   665	724	1302	javax/xml/parsers/ParserConfigurationException
    //   724	752	1302	javax/xml/parsers/ParserConfigurationException
    //   757	816	1302	javax/xml/parsers/ParserConfigurationException
    //   816	827	1302	javax/xml/parsers/ParserConfigurationException
    //   832	870	1302	javax/xml/parsers/ParserConfigurationException
    //   875	934	1302	javax/xml/parsers/ParserConfigurationException
    //   934	962	1302	javax/xml/parsers/ParserConfigurationException
    //   967	1023	1302	javax/xml/parsers/ParserConfigurationException
    //   1023	1051	1302	javax/xml/parsers/ParserConfigurationException
    //   1056	1115	1302	javax/xml/parsers/ParserConfigurationException
    //   1115	1143	1302	javax/xml/parsers/ParserConfigurationException
    //   1148	1204	1302	javax/xml/parsers/ParserConfigurationException
    //   1204	1232	1302	javax/xml/parsers/ParserConfigurationException
    //   1237	1293	1302	javax/xml/parsers/ParserConfigurationException
    //   2	37	1309	org/xml/sax/SAXException
    //   42	63	1309	org/xml/sax/SAXException
    //   68	110	1309	org/xml/sax/SAXException
    //   110	121	1309	org/xml/sax/SAXException
    //   126	168	1309	org/xml/sax/SAXException
    //   168	179	1309	org/xml/sax/SAXException
    //   184	226	1309	org/xml/sax/SAXException
    //   226	237	1309	org/xml/sax/SAXException
    //   242	284	1309	org/xml/sax/SAXException
    //   284	295	1309	org/xml/sax/SAXException
    //   300	342	1309	org/xml/sax/SAXException
    //   342	353	1309	org/xml/sax/SAXException
    //   358	397	1309	org/xml/sax/SAXException
    //   397	433	1309	org/xml/sax/SAXException
    //   433	444	1309	org/xml/sax/SAXException
    //   449	488	1309	org/xml/sax/SAXException
    //   488	499	1309	org/xml/sax/SAXException
    //   504	543	1309	org/xml/sax/SAXException
    //   543	554	1309	org/xml/sax/SAXException
    //   559	601	1309	org/xml/sax/SAXException
    //   601	606	1309	org/xml/sax/SAXException
    //   606	617	1309	org/xml/sax/SAXException
    //   622	660	1309	org/xml/sax/SAXException
    //   665	724	1309	org/xml/sax/SAXException
    //   724	752	1309	org/xml/sax/SAXException
    //   757	816	1309	org/xml/sax/SAXException
    //   816	827	1309	org/xml/sax/SAXException
    //   832	870	1309	org/xml/sax/SAXException
    //   875	934	1309	org/xml/sax/SAXException
    //   934	962	1309	org/xml/sax/SAXException
    //   967	1023	1309	org/xml/sax/SAXException
    //   1023	1051	1309	org/xml/sax/SAXException
    //   1056	1115	1309	org/xml/sax/SAXException
    //   1115	1143	1309	org/xml/sax/SAXException
    //   1148	1204	1309	org/xml/sax/SAXException
    //   1204	1232	1309	org/xml/sax/SAXException
    //   1237	1293	1309	org/xml/sax/SAXException
    //   2	37	1317	java/io/IOException
    //   42	63	1317	java/io/IOException
    //   68	110	1317	java/io/IOException
    //   110	121	1317	java/io/IOException
    //   126	168	1317	java/io/IOException
    //   168	179	1317	java/io/IOException
    //   184	226	1317	java/io/IOException
    //   226	237	1317	java/io/IOException
    //   242	284	1317	java/io/IOException
    //   284	295	1317	java/io/IOException
    //   300	342	1317	java/io/IOException
    //   342	353	1317	java/io/IOException
    //   358	397	1317	java/io/IOException
    //   397	433	1317	java/io/IOException
    //   433	444	1317	java/io/IOException
    //   449	488	1317	java/io/IOException
    //   488	499	1317	java/io/IOException
    //   504	543	1317	java/io/IOException
    //   543	554	1317	java/io/IOException
    //   559	601	1317	java/io/IOException
    //   601	606	1317	java/io/IOException
    //   606	617	1317	java/io/IOException
    //   622	660	1317	java/io/IOException
    //   665	724	1317	java/io/IOException
    //   724	752	1317	java/io/IOException
    //   757	816	1317	java/io/IOException
    //   816	827	1317	java/io/IOException
    //   832	870	1317	java/io/IOException
    //   875	934	1317	java/io/IOException
    //   934	962	1317	java/io/IOException
    //   967	1023	1317	java/io/IOException
    //   1023	1051	1317	java/io/IOException
    //   1056	1115	1317	java/io/IOException
    //   1115	1143	1317	java/io/IOException
    //   1148	1204	1317	java/io/IOException
    //   1204	1232	1317	java/io/IOException
    //   1237	1293	1317	java/io/IOException
    //   2	37	1325	java/lang/Exception
    //   42	63	1325	java/lang/Exception
    //   68	110	1325	java/lang/Exception
    //   110	121	1325	java/lang/Exception
    //   126	168	1325	java/lang/Exception
    //   168	179	1325	java/lang/Exception
    //   184	226	1325	java/lang/Exception
    //   226	237	1325	java/lang/Exception
    //   242	284	1325	java/lang/Exception
    //   284	295	1325	java/lang/Exception
    //   300	342	1325	java/lang/Exception
    //   342	353	1325	java/lang/Exception
    //   358	397	1325	java/lang/Exception
    //   397	433	1325	java/lang/Exception
    //   433	444	1325	java/lang/Exception
    //   449	488	1325	java/lang/Exception
    //   488	499	1325	java/lang/Exception
    //   504	543	1325	java/lang/Exception
    //   543	554	1325	java/lang/Exception
    //   559	601	1325	java/lang/Exception
    //   601	606	1325	java/lang/Exception
    //   606	617	1325	java/lang/Exception
    //   622	660	1325	java/lang/Exception
    //   665	724	1325	java/lang/Exception
    //   724	752	1325	java/lang/Exception
    //   757	816	1325	java/lang/Exception
    //   816	827	1325	java/lang/Exception
    //   832	870	1325	java/lang/Exception
    //   875	934	1325	java/lang/Exception
    //   934	962	1325	java/lang/Exception
    //   967	1023	1325	java/lang/Exception
    //   1023	1051	1325	java/lang/Exception
    //   1056	1115	1325	java/lang/Exception
    //   1115	1143	1325	java/lang/Exception
    //   1148	1204	1325	java/lang/Exception
    //   1204	1232	1325	java/lang/Exception
    //   1237	1293	1325	java/lang/Exception
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append('-').append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public static String a(SharedPreferences paramSharedPreferences, String paramString, boolean paramBoolean)
  {
    int i = 0;
    paramSharedPreferences = paramSharedPreferences.getString("data_migration_tim_uins", "");
    if (TextUtils.isEmpty(paramSharedPreferences))
    {
      if (paramBoolean) {
        return paramString;
      }
      return paramSharedPreferences;
    }
    if (paramBoolean)
    {
      localObject = paramSharedPreferences.split(";");
      j = localObject.length;
      while (i < j)
      {
        if (localObject[i].equals(paramString)) {
          return paramSharedPreferences;
        }
        i += 1;
      }
      return paramSharedPreferences + ";" + paramString;
    }
    paramSharedPreferences = paramSharedPreferences.split(";");
    Object localObject = new StringBuilder();
    int j = paramSharedPreferences.length;
    i = 0;
    while (i < j)
    {
      String str = paramSharedPreferences[i];
      if (!str.equals(paramString)) {
        ((StringBuilder)localObject).append(str).append(";");
      }
      i += 1;
    }
    if ((((StringBuilder)localObject).length() > 0) && (((StringBuilder)localObject).charAt(((StringBuilder)localObject).length() - 1) == ';')) {
      ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static String a(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramConfig.version.get() == paramInt1)
    {
      QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContent| config content will be null localVersion is same as config.version(" + paramInt1 + "). type=" + paramInt2);
      return null;
    }
    if (paramConfig.content_list.size() > 0) {
      return (String)paramConfig.content_list.get(0);
    }
    if (paramConfig.msg_content_list.size() == 0)
    {
      QLog.i("SPLASH_ConfigServlet", 1, String.format(Locale.getDefault(), "extractConfigContent| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return "";
    }
    Object localObject = ((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).content.get().toByteArray();
    if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
    {
      byte[] arrayOfByte = ArConfigUtils.a((byte[])localObject);
      localObject = arrayOfByte;
      if (arrayOfByte == null)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContent| decompress is failed. type=" + paramInt2 + ", data=null");
        return null;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new String((byte[])localObject, "utf-8");
        paramConfig = String.format(Locale.getDefault(), "extractConfigContent| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, paramConfig + "content=" + (String)localObject);
          return localObject;
        }
      }
      catch (UnsupportedEncodingException paramConfig)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContent| data[] to String failed. type=" + paramInt2, paramConfig);
        return null;
      }
      QLog.i("SPLASH_ConfigServlet", 1, paramConfig);
    }
  }
  
  private String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      try
      {
        paramInputStream.close();
        throw localObject;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      localIOException.printStackTrace();
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public static List<String> a(ConfigurationService.Config paramConfig)
  {
    ArrayList localArrayList = null;
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      localArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "parseCommonConfig: list.size() " + paramConfig.msg_content_list.size());
      }
      Iterator localIterator = paramConfig.msg_content_list.get().iterator();
      if (localIterator.hasNext())
      {
        paramConfig = (ConfigurationService.Content)localIterator.next();
        if ((paramConfig != null) && (paramConfig.content.has())) {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = a(paramConfig.content.get().toByteArray());
            if (paramConfig == null) {
              break label302;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "parseCommonConfig: contentitem.content =  " + paramConfig);
        }
        if (TextUtils.isEmpty(paramConfig)) {
          break;
        }
        localArrayList.add(paramConfig);
      }
      catch (Exception paramConfig)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "parseCommonConfig|uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      QLog.i("SPLASH_ConfigServlet", 1, "empty contentitem");
      break;
      do
      {
        return localArrayList;
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parseCommonConfig:msg_content_list is empty ,version: " + paramConfig.version.get());
      return null;
      label302:
      paramConfig = null;
    }
  }
  
  public static List<String> a(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramConfig.version.get() == paramInt1)
    {
      QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContentList| config content is null. type=" + paramInt2);
      return null;
    }
    if (paramConfig.content_list.size() > 0) {
      return paramConfig.content_list.get();
    }
    int i = paramConfig.msg_content_list.size();
    if (i == 0)
    {
      QLog.i("SPLASH_ConfigServlet", 1, String.format(Locale.getDefault(), "extractConfigContentList| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramInt1 = 0;
    if (paramInt1 < i)
    {
      Object localObject1 = ((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).content.get().toByteArray();
      Object localObject2;
      if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
      {
        localObject2 = ArConfigUtils.a((byte[])localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          QLog.e("SPLASH_ConfigServlet", 1, paramInt1 + ": extractConfigContentList| decompress is failed. type=" + paramInt2 + ", data=null");
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        try
        {
          localObject1 = new String((byte[])localObject1, "utf-8");
          localArrayList.add(localObject1);
          localObject2 = String.format(Locale.getDefault(), "%d: extractConfigContent| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
          if (!QLog.isColorLevel()) {
            break label380;
          }
          QLog.i("SPLASH_ConfigServlet", 2, (String)localObject2 + "content=" + (String)localObject1);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          QLog.e("SPLASH_ConfigServlet", 1, paramInt1 + ": extractConfigContentList| data[] to String failed. type=" + paramInt2, localUnsupportedEncodingException);
        }
        continue;
        label380:
        QLog.i("SPLASH_ConfigServlet", 1, (String)localObject2);
      }
    }
    return localArrayList;
  }
  
  /* Error */
  private void a(int paramInt, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: getstatic 909	cooperation/readinjoy/content/ReadInJoyDataProvider:e	Landroid/net/Uri;
    //   3: invokevirtual 915	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc_w 917
    //   13: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokevirtual 923	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   19: pop
    //   20: aload 5
    //   22: invokevirtual 927	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   25: astore 5
    //   27: new 929	android/content/ContentValues
    //   30: dup
    //   31: invokespecial 930	android/content/ContentValues:<init>	()V
    //   34: astore 6
    //   36: aload 6
    //   38: ldc_w 932
    //   41: iload_1
    //   42: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: invokevirtual 936	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   48: aload 6
    //   50: ldc_w 938
    //   53: aload_2
    //   54: invokevirtual 941	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 6
    //   59: ldc_w 943
    //   62: aload_3
    //   63: invokevirtual 941	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc_w 945
    //   69: iconst_2
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: ldc_w 938
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_2
    //   82: aastore
    //   83: invokestatic 534	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: astore_2
    //   87: aload 4
    //   89: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   92: invokevirtual 949	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   95: aload 5
    //   97: aconst_null
    //   98: aload_2
    //   99: aconst_null
    //   100: aconst_null
    //   101: invokevirtual 955	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore_2
    //   105: aload_2
    //   106: ifnull +148 -> 254
    //   109: aload_2
    //   110: invokeinterface 960 1 0
    //   115: ifle +61 -> 176
    //   118: aload 4
    //   120: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   123: invokevirtual 949	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   126: aload 5
    //   128: aload 6
    //   130: aconst_null
    //   131: aconst_null
    //   132: invokevirtual 964	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   135: pop
    //   136: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +12 -> 151
    //   142: ldc 77
    //   144: iconst_2
    //   145: ldc_w 966
    //   148: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload 4
    //   153: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   156: invokevirtual 949	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   159: aload 5
    //   161: aconst_null
    //   162: invokevirtual 970	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   165: aload_2
    //   166: ifnull +9 -> 175
    //   169: aload_2
    //   170: invokeinterface 971 1 0
    //   175: return
    //   176: aload 4
    //   178: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   181: invokevirtual 949	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   184: aload 5
    //   186: aload 6
    //   188: invokevirtual 975	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   191: pop
    //   192: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -44 -> 151
    //   198: ldc 77
    //   200: iconst_2
    //   201: ldc_w 977
    //   204: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: goto -56 -> 151
    //   210: astore_3
    //   211: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +29 -> 243
    //   217: ldc 77
    //   219: iconst_2
    //   220: new 79	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 979
    //   230: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_3
    //   234: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_2
    //   244: ifnull -69 -> 175
    //   247: aload_2
    //   248: invokeinterface 971 1 0
    //   253: return
    //   254: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -106 -> 151
    //   260: ldc 77
    //   262: iconst_2
    //   263: ldc_w 981
    //   266: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: goto -118 -> 151
    //   272: astore 4
    //   274: aload_2
    //   275: astore_3
    //   276: aload 4
    //   278: astore_2
    //   279: aload_3
    //   280: ifnull +9 -> 289
    //   283: aload_3
    //   284: invokeinterface 971 1 0
    //   289: aload_2
    //   290: athrow
    //   291: astore_2
    //   292: aconst_null
    //   293: astore_3
    //   294: goto -15 -> 279
    //   297: astore 4
    //   299: aload_2
    //   300: astore_3
    //   301: aload 4
    //   303: astore_2
    //   304: goto -25 -> 279
    //   307: astore_3
    //   308: aconst_null
    //   309: astore_2
    //   310: goto -99 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	ConfigServlet
    //   0	313	1	paramInt	int
    //   0	313	2	paramString1	String
    //   0	313	3	paramString2	String
    //   0	313	4	paramQQAppInterface	QQAppInterface
    //   6	179	5	localObject	Object
    //   34	153	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   109	151	210	java/lang/Exception
    //   151	165	210	java/lang/Exception
    //   176	207	210	java/lang/Exception
    //   254	269	210	java/lang/Exception
    //   109	151	272	finally
    //   151	165	272	finally
    //   176	207	272	finally
    //   254	269	272	finally
    //   27	105	291	finally
    //   211	243	297	finally
    //   27	105	307	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, 5);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "onSend configXml request");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a(paramQQAppInterface, paramInt, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if ((!paramQQAppInterface.isLogin()) && (paramInt == 215)) {}
    for (boolean bool = true;; bool = false)
    {
      QConfigManager.a(new int[] { paramInt }, paramString, bool);
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.ReqGetConfig paramReqGetConfig, int[] paramArrayOfInt, List<ConfigurationService.ConfigSeq> paramList, List<Integer> paramList1)
  {
    int n = paramArrayOfInt.length;
    int k = 0;
    ConfigurationService.ConfigSeq localConfigSeq;
    int i1;
    if (k < n)
    {
      localConfigSeq = new ConfigurationService.ConfigSeq();
      i1 = paramArrayOfInt[k];
      localConfigSeq.type.set(i1);
      switch (i1)
      {
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface.getConfigProcess().a(localConfigSeq, paramQQAppInterface, i1);
        paramList.add(localConfigSeq);
        paramList1.add(Integer.valueOf(i1));
        k += 1;
        break;
        localConfigSeq.version.set(SharedPreUtils.d(paramQQAppInterface.getApp()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        SharedPreUtils.a(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
        if (paramQQAppInterface.getCurrentAccountUin() == null) {
          continue;
        }
        jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentNickname();
        Object localObject1 = ProfileCardUtil.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet_birth", 2, "card!=null");
          }
          j = (int)((Card)localObject1).lBirthday;
          i = ProfileUtil.a(j);
          j = ProfileUtil.b(j);
          SharedPreUtils.b(paramQQAppInterface.getApp(), a(i, j));
          i = a(new SimpleDateFormat("MM-dd").format(new Date()), a(i, j));
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet_birth", 2, "birthday date diff is " + i);
          }
          if (i < 0) {
            continue;
          }
          if (i <= 3) {}
        }
        else
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("SPLASH_ConfigServlet_birth", 2, "card===null");
          continue;
        }
        localConfigSeq.version.set(SharedPreUtils.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localObject1 = (NearbyBannerManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_BANNER_MANAGER);
        localConfigSeq.version.set(((NearbyBannerManager)localObject1).a());
        Object localObject5 = paramIntent.getStringExtra("key_province");
        localObject1 = localObject5;
        if (localObject5 == null) {
          localObject1 = "";
        }
        String str = paramIntent.getStringExtra("key_city");
        localObject5 = str;
        if (str == null) {
          localObject5 = "";
        }
        paramReqGetConfig.province.set((String)localObject1);
        paramReqGetConfig.city.set((String)localObject5);
        continue;
        localConfigSeq.version.set(SharedPreUtils.i(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.j(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.b(paramQQAppInterface.getApp()));
        continue;
        localConfigSeq.version.set(PatchSharedPreUtil.getPatchConfigVersion(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        continue;
        BridgeHelper.a(BaseApplication.getContext(), jdField_a_of_type_JavaLangString).a();
        localConfigSeq.version.set(SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
        continue;
        i = ApkUtils.a(BaseApplicationImpl.getContext());
        if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < i)
        {
          localConfigSeq.version.set(0);
          continue;
        }
        localConfigSeq.version.set(SharedPreUtils.l(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
        continue;
        i = ApkUtils.a(BaseApplicationImpl.getContext());
        if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < i)
        {
          localConfigSeq.version.set(0);
          paramIntent.putExtra("update101Version", i);
          continue;
        }
        localConfigSeq.version.set(SharedPreUtils.k(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
        continue;
        localObject1 = (PhoneUnityManager)paramQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
        localConfigSeq.version.set(((PhoneUnityManager)localObject1).a());
        continue;
        localConfigSeq.version.set(SharedPreUtils.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.f(paramQQAppInterface.getApp()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.q(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        if (!PtvTemplateManager.a())
        {
          localConfigSeq.version.set(0);
          continue;
        }
        localConfigSeq.version.set(SharedPreUtils.h(paramQQAppInterface.getApp()));
        continue;
        if (!PtvTemplateManager.b())
        {
          localConfigSeq.version.set(0);
          localConfigSeq.compress.set(1);
          continue;
        }
        localConfigSeq.version.set(SharedPreUtils.j(paramQQAppInterface.getApp()));
        continue;
        if (!CapturePtvTemplateManager.a())
        {
          localConfigSeq.version.set(0);
          localConfigSeq.compress.set(1);
          continue;
        }
        localConfigSeq.version.set(SharedPreUtils.i(paramQQAppInterface.getApp()));
        continue;
        i = 0;
        if (PtvTemplateManager.c()) {
          i = SharedPreUtils.k(paramQQAppInterface.getApp());
        }
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 4, String.format("个性笔触配置版本号[%s]", new Object[] { Integer.valueOf(i) }));
        continue;
        i = SharedPreUtils.F(paramQQAppInterface.getApp());
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 4, String.format("日迹合拍版本号[%s]", new Object[] { Integer.valueOf(i) }));
        continue;
        i = SharedPreUtils.aR(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 4, String.format("日迹问答版本号[%s]", new Object[] { Integer.valueOf(i) }));
        continue;
        BusinessCommonConfig.getInstance(paramQQAppInterface).fillConfigVersion(i1, localConfigSeq);
        continue;
        localConfigSeq.version.set(SharedPreUtils.b(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.c(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.G(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        long l = paramIntent.getLongExtra("k_adcode", 0L);
        localObject5 = paramIntent.getStringExtra("key_province");
        localObject1 = localObject5;
        if (localObject5 == null) {
          localObject1 = "";
        }
        str = paramIntent.getStringExtra("key_city");
        localObject5 = str;
        if (str == null) {
          localObject5 = "";
        }
        paramReqGetConfig.province.set((String)localObject1);
        paramReqGetConfig.city.set((String)localObject5);
        paramReqGetConfig.adcode.set(l);
        continue;
        boolean bool = QFindConfigUtil.a();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
        }
        if (!bool) {
          continue;
        }
        localConfigSeq.version.set(SharedPreUtils.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        bool = QFindConfigUtil.a();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
        }
        if (!bool) {
          continue;
        }
        localConfigSeq.version.set(SharedPreUtils.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.s(paramQQAppInterface.getApp()));
        continue;
        i = SharedPreUtils.x(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        int j = AppSetting.a();
        if (i != j)
        {
          SharedPreUtils.i(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          SharedPreUtils.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          SearchConfigManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString);
        }
        localConfigSeq.version.set(SharedPreUtils.w(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.H(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.g(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(SharedPreUtils.t(paramQQAppInterface.getApp()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.u(paramQQAppInterface.getApp()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.v(paramQQAppInterface.getApp()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.w(paramQQAppInterface.getApp()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.L(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.x(paramQQAppInterface.getApp()));
        continue;
        i = SharedPreUtils.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        localConfigSeq.version.set(((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b());
        continue;
        i = SharedPreUtils.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        if (SharedPreUtils.y(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
          i = 0;
        }
        localConfigSeq.version.set(i);
        continue;
        localObject1 = (NotificationController)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER);
        i = ((NotificationController)localObject1).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = ((NotificationController)localObject1).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        int m = AppSetting.a();
        if (j == m) {
          break label8790;
        }
        i = 0;
        QLog.i("NCtr", 1, String.format("request NOTIFICATION_LIMIT_CONFIG localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m) }));
        localConfigSeq.version.set(i);
        continue;
        i = SharedPreUtils.av(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        if (SharedPreUtils.aw(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
          i = 0;
        }
        localConfigSeq.version.set(i);
        continue;
        i = SharedPreUtils.ax(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        if (SharedPreUtils.ay(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
          i = 0;
        }
        localConfigSeq.version.set(i);
        continue;
        paramReqGetConfig = ((IDPCApi)QRoute.api(IDPCApi.class)).buidldReqConfig(paramQQAppInterface);
        continue;
        localConfigSeq.version.set(SharedPreUtils.F(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(PrecoverUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        localObject5 = paramIntent.getStringExtra("key_province");
        localObject1 = localObject5;
        if (localObject5 == null) {
          localObject1 = "";
        }
        str = paramIntent.getStringExtra("key_city");
        localObject5 = str;
        if (str == null) {
          localObject5 = "";
        }
        paramReqGetConfig.province.set((String)localObject1);
        paramReqGetConfig.city.set((String)localObject5);
        continue;
        localConfigSeq.version.set(SharedPreUtils.o(paramQQAppInterface.getApp()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.p(paramQQAppInterface.getApp()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.M(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.P(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.K(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString));
        continue;
        localObject1 = (OlympicManager)paramQQAppInterface.getManager(QQManagerFactory.OLYMPIC_MANAGER);
        if (localObject1 == null) {
          continue;
        }
        ((OlympicManager)localObject1).c();
        localObject1 = ((OlympicManager)localObject1).a();
        i = 0;
        if (localObject1 != null) {
          i = ((OlympicActConfig)localObject1).version;
        }
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        paramIntent.putExtra("config_version", i);
        if (QLog.isColorLevel()) {
          QLog.d("Olympic.OLYMPIC_ACT_RESOURCE_CONFIG_INFO", 2, new Object[] { "oldVersion=", Integer.valueOf(i) });
        }
        if (!OlympicUtil.a(BaseApplicationImpl.getContext(), "olympic_config_act_get")) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Olympic.configServlet", 2, new Object[] { "check24Hour, result=true, do Report, key=", "olympic_config_act_get" });
        }
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "olympic_config_act_get", true, 0L, 0L, null, "", false);
        OlympicUtil.a(BaseApplicationImpl.getContext(), "olympic_config_act_get");
        continue;
        localObject1 = (ArResourceManager)paramQQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
        if (localObject1 == null) {
          continue;
        }
        int i2 = ((ArResourceManager)localObject1).b();
        m = 0;
        i = 0;
        localObject5 = BaseApplicationImpl.getApplication();
        j = m;
        try
        {
          int i3 = ((Context)localObject5).getPackageManager().getPackageInfo(((Context)localObject5).getPackageName(), 0).versionCode;
          j = m;
          m = ((ArResourceManager)localObject1).a();
          if ((m == 0) || (i3 != m)) {
            break label8793;
          }
          j = i;
          QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig|type= 1 version code is  " + i3 + "local version type is " + m);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
          QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig|type= 1 error happen");
          i = j;
          continue;
          localConfigSeq.version.set(i2);
          continue;
        }
        if (i == 1)
        {
          localConfigSeq.version.set(0);
          localConfigSeq.compress.set(1);
          localObject5 = paramIntent.getStringExtra("key_province");
          localObject1 = localObject5;
          if (localObject5 == null) {
            localObject1 = "";
          }
          str = paramIntent.getStringExtra("key_city");
          localObject5 = str;
          if (str == null) {
            localObject5 = "";
          }
          paramReqGetConfig.province.set((String)localObject1);
          paramReqGetConfig.city.set((String)localObject5);
          paramIntent.putExtra("key_config_version", i2);
          continue;
        }
        Object localObject2 = (ARGlobalConfigManager)paramQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
        if (localObject2 == null) {
          continue;
        }
        i = ((ARGlobalConfigManager)localObject2).b();
        if (QLog.isColorLevel()) {
          QLog.d("handleResp_GetArGlobalConfig", 2, " local version = " + i);
        }
        if (((ARGlobalConfigManager)localObject2).a())
        {
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("ar_global_key_config_version", i);
          continue;
        }
        i = 0;
        localConfigSeq.version.set(0);
        continue;
        localObject2 = (ARGlobalConfigManager)paramQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
        if (localObject2 == null) {
          continue;
        }
        i = ((ARGlobalConfigManager)localObject2).c();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        paramIntent.putExtra("ar_scan_star_face_config_version", i);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_STAR_FACE_CONFIG, version = " + i);
        continue;
        i = FaceScanDownloadManager.a(paramQQAppInterface);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        paramIntent.putExtra("key_download_cfg_version", i);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_FACE_PRE_DOWN_CONFIG, version = " + i);
        continue;
        localObject2 = (ArResourceManager)paramQQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
        if (localObject2 == null) {
          continue;
        }
        i = ((ArResourceManager)localObject2).c();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        paramIntent.putExtra("key_ar_entrance_effect_version", i);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        localObject2 = (PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
        localConfigSeq.version.set(((PhoneContactManagerImp)localObject2).e());
        continue;
        QAVConfig.a(i1, jdField_a_of_type_JavaLangString, localConfigSeq);
        continue;
        i = CameraUtils.a(BaseApplicationImpl.getContext());
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        paramIntent.putExtra("qcamera_conf_version", i);
        paramIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.camera.configServlet", 2, "request QCAMERA_PHONE_CONFIG version: " + i);
        continue;
        i = SharedPreUtils.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs|GET_CONFIG_UPGRADE version=" + i);
        }
        localConfigSeq.version.set(i);
        paramQQAppInterface.getPreloadSwitch();
        OpenConfig.a(paramQQAppInterface.getApp(), String.valueOf(AppSetting.a()));
        ((ConfigHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).c();
        continue;
        i = SharedPreUtils.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("UpgradeTIMWrapper", 2, "ConfigServlet req :193, version: " + i);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        localConfigSeq.version.set(SharedPreUtils.Q(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
        localConfigSeq.compress.set(1);
        continue;
        localObject2 = (BabyQHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
        if (localObject2 == null) {
          continue;
        }
        i = AppSetting.a();
        if (i != ((BabyQHandler)localObject2).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString))
        {
          ((BabyQHandler)localObject2).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          ((BabyQHandler)localObject2).b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
          ((BabyQHandler)localObject2).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, true);
          ((BabyQHandler)localObject2).c();
        }
        localConfigSeq.version.set(((BabyQHandler)localObject2).a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.S(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.version.set(SharedPreUtils.T(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(SharedPreUtils.D(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SearchConfigUtils.a());
        continue;
        i = SearchEntryConfigManager.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
        localConfigSeq.version.set(i);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(SharedPreUtils.V(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        if (SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1) != AppSetting.a())
        {
          SharedPreUtils.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, AppSetting.a());
          SharedPreUtils.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, 0);
          localConfigSeq.version.set(0);
          continue;
        }
        localConfigSeq.version.set(SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2));
        continue;
        try
        {
          if (((Integer)SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1)).intValue() == AppSetting.a()) {
            continue;
          }
          SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, Integer.valueOf(AppSetting.a()));
          SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(0));
          localConfigSeq.version.set(0);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "PUSH_RECOMMEND_SHIELD_CONFIG", localThrowable);
        continue;
        i = ((Integer)SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
        localConfigSeq.version.set(i);
        continue;
        localConfigSeq.version.set(SharedPreUtils.Y(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        if (!PtvTemplateManager.d())
        {
          localConfigSeq.version.set(0);
          localConfigSeq.compress.set(1);
          continue;
        }
        localConfigSeq.version.set(SharedPreUtils.m(paramQQAppInterface.getApp()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.W(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.ac(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(SharedPreUtils.ae(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        Object localObject3 = (TroopStoryManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_STORY_MANAGER);
        localConfigSeq.version.set(((TroopStoryManager)localObject3).a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountQQMailConfigVersionCode(paramQQAppInterface));
        continue;
        localConfigSeq.version.set(SharedPreUtils.c("local_qr_login_version"));
        continue;
        localConfigSeq.version.set(SharedPreUtils.ab(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        i = SharedPreUtils.am(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          SharedPreUtils.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          SharedPreUtils.K(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "[Doutu]onsend : appIdRecord = " + i + ", appId = " + j + ", DOUTU_CONFI version = " + SharedPreUtils.aj(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          }
          localConfigSeq.version.set(SharedPreUtils.aj(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
          localConfigSeq.compress.set(1);
          continue;
        }
        localObject3 = (DoutuManager)paramQQAppInterface.getManager(QQManagerFactory.DOUTU_MAGAGER);
        if (localObject3 == null) {
          continue;
        }
        ((DoutuManager)localObject3).b(false);
        continue;
        i = SharedPreUtils.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          SharedPreUtils.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          SharedPreUtils.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[GreenVideo]onsend : appIdRecord = " + i + ", appId = " + j + ", GREEN_VIDEO_CONFI version = " + SharedPreUtils.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
        localConfigSeq.version.set(SharedPreUtils.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        i = SharedPreUtils.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = AppSetting.a();
        if (i != j)
        {
          SharedPreUtils.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          SharedPreUtils.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[VideoCompress]onsend : appIdRecord = " + i + ", appId = " + j + ", VIDEO_REDBAG_CONFI version = " + SharedPreUtils.ao(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
        localConfigSeq.version.set(SharedPreUtils.v(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        if (((Integer)NearbySPUtil.a(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(0))).intValue() != AppSetting.a())
        {
          NearbySPUtil.a(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0));
          NearbySPUtil.a(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(AppSetting.a()));
        }
        i = ((Integer)NearbySPUtil.a(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0))).intValue();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        localObject5 = paramIntent.getStringExtra("key_province");
        localObject3 = localObject5;
        if (localObject5 == null) {
          localObject3 = "";
        }
        str = paramIntent.getStringExtra("key_city");
        localObject5 = str;
        if (str == null) {
          localObject5 = "";
        }
        paramReqGetConfig.province.set((String)localObject3);
        paramReqGetConfig.city.set((String)localObject5);
        continue;
        i = GiftConfigManager.a(jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(SttManager.a(paramQQAppInterface));
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(SharedPreUtils.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(SharedPreUtils.ad(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(PhotoListConfigManager.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        localConfigSeq.version.set(SharedPreUtils.ar(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(SharedPreUtils.z(paramQQAppInterface.getApp()));
        continue;
        localConfigSeq.version.set(SharedPreUtils.as(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        localConfigSeq.version.set(VideoFilterTools.a(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(CaptureVideoFilterManager.a(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        continue;
        a(paramReqGetConfig, localConfigSeq, paramQQAppInterface);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = ((OCRManager)paramQQAppInterface.getManager(QQManagerFactory.OCR_MANAGER)).a();
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet OCR_CONFIG ocrVersion:" + i);
        continue;
        i = SharedPreUtils.au(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet receipt ,receiptVersion:" + i);
        continue;
        i = SharedPreUtils.aY(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        i = SharedPreUtils.aZ(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        i = AEOldShortVideoResManager.a();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        if (QLog.isColorLevel()) {
          QLog.i("AEOldShortVideoResManager", 2, "SHORT_VIDEO_RESOURCE_CONFIG  ,versionRes:" + i);
        }
        AEOldShortVideoResManager.a();
        continue;
        i = ShortVideoResourceManager.a();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoResourceManager", 2, "SHORT_VIDEO_RESOURCE_CONFIG  ,versionRes:" + i);
        }
        ShortVideoResourceManager.a();
        i = paramQQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = paramQQAppInterface.getPreferences().getInt("tim_login_jump", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = paramQQAppInterface.getPreferences().getInt("tim_upgrade_hongdian_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(paramQQAppInterface.getPreferences().getInt("call_tim_config_version", 0));
        continue;
        i = paramQQAppInterface.getPreferences().getInt("tim_pc_banner", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = paramQQAppInterface.getPreferences().getInt("troop_link_config_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = paramQQAppInterface.getPreferences().getInt("key_game_troop_bind_config_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        paramQQAppInterface.getConfigProcess().a(localConfigSeq, paramQQAppInterface, i1);
        localObject3 = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        try
        {
          ((ExtendFriendManager)localObject3).a();
        }
        catch (Exception localException1)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "get local extend friend exception:", localException1);
        }
        continue;
        i = paramQQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = QmcfDevicesStrategy.a(paramQQAppInterface.getApp());
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = paramQQAppInterface.getPreferences().getInt("data_migration_tim_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        i = paramQQAppInterface.getPreferences().getInt("zhitu_config_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = paramQQAppInterface.getPreferences().getInt("homework_troop_config_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        Object localObject4 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        localConfigSeq.version.set(((TroopManager)localObject4).jdField_a_of_type_ComTencentMobileqqTroopHomeworkConfigHomeworkConfig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        i = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        localObject4 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        localConfigSeq.version.set(((TroopManager)localObject4).jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteConfigReciteConfig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        i = RecentDanceConfigMgr.a();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = ZhuoXusManager.a().a.a();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(SharedPreUtils.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApplication(), "troop_gift_anim_limit", "0");
        localConfigSeq.version.set(i);
        continue;
        localConfigSeq.version.set(0);
        localConfigSeq.compress.set(1);
        continue;
        i = paramQQAppInterface.getPreferences().getInt("task_entry_config_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = paramQQAppInterface.getPreferences().getInt("qzone_xp_config_version", 0);
        localConfigSeq.version.set(i);
        continue;
        i = paramQQAppInterface.getPreferences().getInt("buluo_enter_config_version" + paramQQAppInterface.getCurrentUin(), 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(SharedPreUtils.aF(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        continue;
        i = SharedPreUtils.aH(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        if (SharedPreUtils.aI(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
          i = 0;
        }
        localConfigSeq.version.set(i);
        continue;
        i = DovSVParamManager.a().a(paramQQAppInterface.getApp());
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = QIMBeautyManager.a().a(paramQQAppInterface.getApp());
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        localObject4 = (QQStoryManager)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
        localConfigSeq.version.set(((QQStoryManager)localObject4).a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(SharedPreUtils.a());
        localConfigSeq.compress.set(1);
        continue;
        i = SharedPreUtils.aJ(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        if (SharedPreUtils.aK(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
          i = 0;
        }
        localConfigSeq.version.set(i);
        continue;
        localConfigSeq.version.set(SharedPreUtils.R(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
        localConfigSeq.compress.set(1);
        continue;
        i = SharedPreUtils.a(paramQQAppInterface.getApp(), "wifi_connect_config_version", jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        localObject4 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        localConfigSeq.version.set(((TroopManager)localObject4).jdField_a_of_type_ComTencentBizTroopconfigTroopConfigForAllUser.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        i = SharedPreUtils.aS(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        localConfigSeq.version.set(i);
        continue;
        localConfigSeq.version.set(SharedPreUtils.aA(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        localConfigSeq.compress.set(1);
        continue;
        i = SharedPreUtils.aV(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        if (SharedPreUtils.aW(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
          i = 0;
        }
        localConfigSeq.version.set(i);
        continue;
        i = JumpForwardPkgManager.a();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("JumpForwardPkgManager", 2, "JUMP_PKG_TOAST_CONFIG  ,version:" + i);
        continue;
        i = AioReadInJoyConfigManager.a(paramQQAppInterface);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        i = StickerRecManager.a(paramQQAppInterface);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        continue;
        localConfigSeq.version.set(((Integer)SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_version_code", Integer.valueOf(0))).intValue());
        continue;
      }
      catch (Exception localException2)
      {
        QLog.d("QConfigManager", 1, "exception " + i1, localException2);
        continue;
      }
      paramQQAppInterface = new ConfigurationService.DeviceInfo();
      if ((paramList1.contains(Integer.valueOf(1))) || (paramList1.contains(Integer.valueOf(2))) || (paramList1.contains(Integer.valueOf(3))) || (paramList1.contains(Integer.valueOf(12))))
      {
        paramIntent = new ConfigurationService.Screen();
        paramIntent.setHasFlag(true);
        paramIntent.width.set((int)DeviceInfoUtil.i());
        paramIntent.height.set((int)DeviceInfoUtil.j());
        paramQQAppInterface.screen = paramIntent;
        paramQQAppInterface.setHasFlag(true);
        paramReqGetConfig.device_info = paramQQAppInterface;
      }
      if ((paramList1.contains(Integer.valueOf(47))) || (paramList1.contains(Integer.valueOf(65))) || (paramList1.contains(Integer.valueOf(156))) || (paramList1.contains(Integer.valueOf(297))))
      {
        paramIntent = new ConfigurationService.OS();
        paramIntent.setHasFlag(true);
        paramIntent.type.set(2);
        paramIntent.kernel.set(DeviceInfoUtil.m());
        paramIntent.sdk.set(String.valueOf(DeviceInfoUtil.a()));
        paramIntent.version.set(DeviceInfoUtil.e());
        paramIntent.rom.set(DeviceInfoUtil.j());
        paramQQAppInterface.brand.set(DeviceInfoUtil.h());
        paramQQAppInterface.model.set(DeviceInfoUtil.d());
        if (QLog.isDevelopLevel()) {
          QLog.w("SPLASH_ConfigServlet", 1, "addAllConfigs, brand[" + paramQQAppInterface.brand.get() + "], model[" + paramQQAppInterface.model.get() + "]");
        }
        paramQQAppInterface.os = paramIntent;
        paramQQAppInterface.setHasFlag(true);
        paramReqGetConfig.device_info = paramQQAppInterface;
      }
      return;
      label8790:
      continue;
      label8793:
      int i = 1;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    int i = paramConfig.version.get();
    int j = AioReadInJoyConfigManager.a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("AioReadInJoyConfigManager", 2, "received  Config remote version:" + i + " localversion= " + j);
    }
    if (i != j)
    {
      paramConfig = b(paramConfig, j, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("AioReadInJoyConfigManager", 2, "config content : " + paramConfig);
      }
      if (TextUtils.isEmpty(paramConfig)) {}
    }
    try
    {
      AioReadInJoyConfigManager.a(paramQQAppInterface, new JSONObject(paramConfig).optInt("hot_video_enable", 0));
      AioReadInJoyConfigManager.b(paramQQAppInterface, i);
      return;
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioReadInJoyConfigManager", 2, paramConfig.getMessage());
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    QConfigManager.a(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, app is null, or uin is empty");
      }
    }
    do
    {
      do
      {
        return;
        if ((paramInt == -1) || (SharedPreUtils.s(paramQQAppInterface.getApp()) != paramInt)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, same version " + paramInt);
      return;
      a(paramQQAppInterface, 49, paramString);
    } while (!QLog.isColorLevel());
    QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, " + paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)))
    {
      QLog.d("PatchLogTag", 1, "getPatchConfig app is null or uin is empty");
      return;
    }
    if ((paramInt != -1) && (PatchSharedPreUtil.getPatchConfigVersion(paramQQAppInterface.getApplication()) == paramInt))
    {
      QLog.d("PatchLogTag", 1, "getPatchConfig same version=" + paramInt + ", reason=" + paramString2);
      return;
    }
    a(paramQQAppInterface, 46, paramString1);
    QLog.d("PatchLogTag", 1, "getPatchConfig version=" + paramInt + ", reason=" + paramString2);
  }
  
  private void a(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.c("local_qr_login_version");
    QLog.i("SPLASH_ConfigServlet", 1, "handleLocalQRConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    if (i == j)
    {
      QLog.e("SPLASH_ConfigServlet", 1, "handleLocalQRConfig version is same of local version");
      return;
    }
    SharedPreUtils.b("local_qr_login_version", Integer.valueOf(i));
    paramConfig = a(paramConfig);
    if ((paramConfig == null) || (paramConfig.isEmpty()))
    {
      QLog.e("SPLASH_ConfigServlet", 1, "handleLocalQRConfig configStrList is null or empty");
      return;
    }
    try
    {
      paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
      QLog.d("SPLASH_ConfigServlet", 1, new Object[] { "localQrLoginConfig is ", paramConfig });
      SharedPreUtils.b("local_qr_login_config", paramConfig);
      return;
    }
    catch (Exception paramConfig)
    {
      QLog.e("SPLASH_ConfigServlet", 1, new Object[] { "get local qr login config error : ", paramConfig.getMessage() });
    }
  }
  
  /* Error */
  private void a(ConfigurationService.ReqGetConfig paramReqGetConfig, ConfigurationService.ConfigSeq paramConfigSeq, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: invokestatic 2074	com/tencent/mobileqq/utils/SharedPreUtils:ak	(Landroid/content/Context;Ljava/lang/String;)I
    //   10: invokestatic 1263	com/tencent/common/config/AppSetting:a	()I
    //   13: if_icmpeq +114 -> 127
    //   16: aload_3
    //   17: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   20: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokestatic 1263	com/tencent/common/config/AppSetting:a	()I
    //   26: invokestatic 2076	com/tencent/mobileqq/utils/SharedPreUtils:H	(Landroid/content/Context;Ljava/lang/String;I)V
    //   29: aload_3
    //   30: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: iconst_0
    //   37: invokestatic 2078	com/tencent/mobileqq/utils/SharedPreUtils:I	(Landroid/content/Context;Ljava/lang/String;I)V
    //   40: iconst_0
    //   41: istore 4
    //   43: aload_2
    //   44: getfield 1018	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ConfigSeq:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   47: iload 4
    //   49: invokevirtual 1008	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   52: invokestatic 2080	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()Ljava/util/ArrayList;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +119 -> 178
    //   62: aload 5
    //   64: invokevirtual 2081	java/util/ArrayList:size	()I
    //   67: ifle +111 -> 178
    //   70: aload 5
    //   72: invokevirtual 2082	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   75: astore_2
    //   76: aload_2
    //   77: invokeinterface 120 1 0
    //   82: ifeq +96 -> 178
    //   85: aload_2
    //   86: invokeinterface 124 1 0
    //   91: checkcast 526	java/lang/Integer
    //   94: astore 6
    //   96: aload_1
    //   97: getfield 2085	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:carriers	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   100: aload 6
    //   102: invokevirtual 2088	com/tencent/mobileqq/pb/PBRepeatField:add	(Ljava/lang/Object;)V
    //   105: goto -29 -> 76
    //   108: astore_1
    //   109: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +14 -> 126
    //   115: ldc_w 2090
    //   118: iconst_2
    //   119: ldc_w 2092
    //   122: aload_1
    //   123: invokestatic 1596	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: return
    //   127: aload_3
    //   128: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   131: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: invokestatic 2094	com/tencent/mobileqq/utils/SharedPreUtils:al	(Landroid/content/Context;Ljava/lang/String;)I
    //   137: istore 4
    //   139: goto -96 -> 43
    //   142: astore_2
    //   143: ldc 77
    //   145: iconst_2
    //   146: new 79	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 2096
    //   156: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_2
    //   160: invokevirtual 586	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aconst_null
    //   173: astore 5
    //   175: goto -118 -> 57
    //   178: aload_3
    //   179: getstatic 1489	com/tencent/mobileqq/app/QQManagerFactory:CONTACT_MANAGER	I
    //   182: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   185: checkcast 2098	com/tencent/mobileqq/model/PhoneContactManager
    //   188: invokeinterface 2101 1 0
    //   193: astore 6
    //   195: aload 6
    //   197: ifnull +229 -> 426
    //   200: aload 6
    //   202: getfield 2106	SecurityAccountServer/RespondQueryQQBindingStat:nationCode	Ljava/lang/String;
    //   205: astore_3
    //   206: aload_3
    //   207: astore_2
    //   208: aload_3
    //   209: ifnull +21 -> 230
    //   212: aload_3
    //   213: astore_2
    //   214: aload_3
    //   215: ldc_w 2108
    //   218: invokevirtual 2111	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   221: ifeq +9 -> 230
    //   224: aload_3
    //   225: iconst_1
    //   226: invokevirtual 2114	java/lang/String:substring	(I)Ljava/lang/String;
    //   229: astore_2
    //   230: aload_2
    //   231: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   234: ifeq +130 -> 364
    //   237: aload 6
    //   239: getfield 2117	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   242: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifeq +119 -> 364
    //   248: ldc 13
    //   250: astore_2
    //   251: aload_2
    //   252: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   255: ifne +11 -> 266
    //   258: aload_1
    //   259: getfield 2120	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:bind_phone_no	Lcom/tencent/mobileqq/pb/PBStringField;
    //   262: aload_2
    //   263: invokevirtual 1094	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   266: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -143 -> 126
    //   272: new 79	java/lang/StringBuilder
    //   275: dup
    //   276: bipush 100
    //   278: invokespecial 2121	java/lang/StringBuilder:<init>	(I)V
    //   281: astore_1
    //   282: aload_1
    //   283: ldc_w 2123
    //   286: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: iload 4
    //   291: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: ldc_w 2125
    //   297: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_2
    //   301: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_1
    //   306: ldc_w 2127
    //   309: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 5
    //   315: ifnull +91 -> 406
    //   318: aload 5
    //   320: invokevirtual 2081	java/util/ArrayList:size	()I
    //   323: ifle +83 -> 406
    //   326: aload 5
    //   328: invokevirtual 2082	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   331: astore_2
    //   332: aload_2
    //   333: invokeinterface 120 1 0
    //   338: ifeq +68 -> 406
    //   341: aload_1
    //   342: aload_2
    //   343: invokeinterface 124 1 0
    //   348: checkcast 526	java/lang/Integer
    //   351: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   354: ldc_w 2129
    //   357: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: goto -29 -> 332
    //   364: invokestatic 821	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   367: astore 7
    //   369: aload_2
    //   370: astore_3
    //   371: aload_2
    //   372: ifnonnull +6 -> 378
    //   375: ldc 13
    //   377: astore_3
    //   378: aload 7
    //   380: ldc_w 2131
    //   383: iconst_2
    //   384: anewarray 4	java/lang/Object
    //   387: dup
    //   388: iconst_0
    //   389: aload_3
    //   390: aastore
    //   391: dup
    //   392: iconst_1
    //   393: aload 6
    //   395: getfield 2117	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   398: aastore
    //   399: invokestatic 826	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   402: astore_2
    //   403: goto -152 -> 251
    //   406: aload_1
    //   407: ldc_w 2005
    //   410: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: ldc_w 2090
    //   417: iconst_2
    //   418: aload_1
    //   419: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: return
    //   426: ldc 13
    //   428: astore_2
    //   429: goto -178 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	ConfigServlet
    //   0	432	1	paramReqGetConfig	ConfigurationService.ReqGetConfig
    //   0	432	2	paramConfigSeq	ConfigurationService.ConfigSeq
    //   0	432	3	paramQQAppInterface	QQAppInterface
    //   41	249	4	i	int
    //   55	272	5	localArrayList	ArrayList
    //   94	300	6	localObject	Object
    //   367	12	7	localLocale	Locale
    // Exception table:
    //   from	to	target	type
    //   0	40	108	java/lang/Exception
    //   43	52	108	java/lang/Exception
    //   52	57	108	java/lang/Exception
    //   62	76	108	java/lang/Exception
    //   76	105	108	java/lang/Exception
    //   127	139	108	java/lang/Exception
    //   143	172	108	java/lang/Exception
    //   178	195	108	java/lang/Exception
    //   200	206	108	java/lang/Exception
    //   214	230	108	java/lang/Exception
    //   230	248	108	java/lang/Exception
    //   251	266	108	java/lang/Exception
    //   266	313	108	java/lang/Exception
    //   318	332	108	java/lang/Exception
    //   332	361	108	java/lang/Exception
    //   364	369	108	java/lang/Exception
    //   378	403	108	java/lang/Exception
    //   406	425	108	java/lang/Exception
    //   52	57	142	java/lang/Throwable
  }
  
  public static boolean a(PicAndAdConf paramPicAndAdConf, String paramString, Set<String> paramSet)
  {
    boolean bool2 = false;
    for (;;)
    {
      Document localDocument;
      String str1;
      int i;
      long l1;
      String str2;
      String str3;
      int k;
      Object localObject;
      long l2;
      long l3;
      boolean bool1;
      try
      {
        localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = localDocument.getElementsByTagName("pushbanner");
        str1 = "";
        i = 0;
        if (i < localNodeList.getLength())
        {
          l1 = Long.parseLong(localDocument.getElementsByTagName("channel").item(i).getFirstChild().getNodeValue());
          str2 = localDocument.getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
          str3 = localDocument.getElementsByTagName("digest").item(i).getFirstChild().getNodeValue();
          k = Integer.parseInt(localDocument.getElementsByTagName("weight").item(i).getFirstChild().getNodeValue());
          localObject = localDocument.getElementsByTagName("md5").item(i).getFirstChild();
          if (localObject != null) {
            str1 = ((Node)localObject).getNodeValue();
          }
          localObject = localDocument.getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          l2 = localSimpleDateFormat.parse((String)localObject).getTime();
          l3 = localSimpleDateFormat.parse(localDocument.getElementsByTagName("begin").item(i).getFirstChild().getNodeValue()).getTime();
          if (System.currentTimeMillis() > l2)
          {
            if (QLog.isColorLevel()) {
              QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner out of date, cid = " + l1 + ", endTime = " + (String)localObject);
            }
          }
          else if (str1.length() < 15)
          {
            if (!QLog.isColorLevel()) {
              break label758;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner md5 length < 15, cid = " + l1);
          }
        }
      }
      catch (Exception paramPicAndAdConf)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner parse exception,", paramPicAndAdConf);
          bool1 = bool2;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "parseNearbyBannerXml,result = " + bool1 + ",bannerContent =" + paramString);
        }
        return bool1;
        if ((paramSet != null) && (paramSet.contains(l1 + str1)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner " + l1 + " had been closed, throw it");
          break;
        }
        localObject = new StringBuffer();
        int j = 0;
        while (j < localDocument.getElementsByTagName("url").item(i).getChildNodes().getLength())
        {
          ((StringBuffer)localObject).append(localDocument.getElementsByTagName("url").item(i).getChildNodes().item(j).getNodeValue());
          j += 1;
        }
        paramPicAndAdConf.a(paramPicAndAdConf.a(l1, str3, (byte)3, str2, ((StringBuffer)localObject).toString(), BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic" + "/" + str1, l3 + "|" + l2, (short)k, str1));
        NearbySPUtil.a(jdField_a_of_type_JavaLangString, "has_new_banner", Boolean.valueOf(true));
        break;
        bool1 = true;
      }
      label758:
      i += 1;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  private void aA(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      paramQQAppInterface = (MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i = paramConfig.version.get();
        j = paramQQAppInterface.b();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 74,content: " + str + ",version: " + paramConfig.version.get());
        }
        if ((i != j) || (paramConfig.content_list.size() > 0)) {
          paramQQAppInterface.a(i, str);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 74,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void aB(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i = paramConfig.version.get();
        j = paramQQAppInterface.e();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 97,content: " + str + ",version: " + paramConfig.version.get());
        }
        if ((i != j) || (paramConfig.content_list.size() > 0)) {
          paramQQAppInterface.a(i, str);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 97,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  /* Error */
  private void aC(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: istore 35
    //   9: aload_1
    //   10: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: aload_1
    //   14: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   17: invokestatic 1334	com/tencent/mobileqq/utils/SharedPreUtils:av	(Landroid/content/Context;Ljava/lang/String;)I
    //   20: istore_3
    //   21: aload_1
    //   22: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: aload_1
    //   26: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokestatic 1337	com/tencent/mobileqq/utils/SharedPreUtils:aw	(Landroid/content/Context;Ljava/lang/String;)I
    //   32: istore 4
    //   34: invokestatic 1263	com/tencent/common/config/AppSetting:a	()I
    //   37: istore 5
    //   39: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +50 -> 92
    //   45: ldc 77
    //   47: iconst_2
    //   48: ldc_w 2258
    //   51: iconst_4
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: iload 35
    //   59: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: iload_3
    //   66: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: iload 4
    //   74: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: dup
    //   79: iconst_3
    //   80: iload 5
    //   82: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: invokestatic 534	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: iload 4
    //   94: iload 5
    //   96: if_icmpeq +18 -> 114
    //   99: aload_1
    //   100: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   103: aload_1
    //   104: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   107: iload 5
    //   109: invokestatic 2260	com/tencent/mobileqq/utils/SharedPreUtils:R	(Landroid/content/Context;Ljava/lang/String;I)V
    //   112: iconst_0
    //   113: istore_3
    //   114: iload 35
    //   116: iload_3
    //   117: if_icmpeq +3294 -> 3411
    //   120: aload_2
    //   121: iload_3
    //   122: sipush 228
    //   125: invokestatic 2021	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   128: astore 72
    //   130: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +12 -> 145
    //   136: ldc_w 2262
    //   139: iconst_2
    //   140: aload 72
    //   142: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload 72
    //   147: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +3575 -> 3725
    //   153: iconst_0
    //   154: istore 21
    //   156: iconst_0
    //   157: istore 29
    //   159: iconst_0
    //   160: istore 30
    //   162: iconst_0
    //   163: istore 31
    //   165: iconst_0
    //   166: istore 32
    //   168: iconst_0
    //   169: istore 33
    //   171: iconst_0
    //   172: istore 34
    //   174: iconst_0
    //   175: istore_3
    //   176: iconst_0
    //   177: istore 4
    //   179: iconst_0
    //   180: istore 22
    //   182: iconst_0
    //   183: istore 23
    //   185: iconst_0
    //   186: istore 24
    //   188: iconst_0
    //   189: istore 25
    //   191: iconst_0
    //   192: istore 26
    //   194: iconst_0
    //   195: istore 27
    //   197: iconst_0
    //   198: istore 28
    //   200: aconst_null
    //   201: astore 68
    //   203: aconst_null
    //   204: astore 69
    //   206: aconst_null
    //   207: astore 70
    //   209: aconst_null
    //   210: astore 71
    //   212: aconst_null
    //   213: astore_2
    //   214: aconst_null
    //   215: astore 64
    //   217: aconst_null
    //   218: astore 65
    //   220: aconst_null
    //   221: astore 66
    //   223: aconst_null
    //   224: astore 67
    //   226: aconst_null
    //   227: astore 37
    //   229: ldc 13
    //   231: astore 40
    //   233: aconst_null
    //   234: astore 39
    //   236: aconst_null
    //   237: astore 61
    //   239: aconst_null
    //   240: astore 62
    //   242: aconst_null
    //   243: astore 63
    //   245: aconst_null
    //   246: astore 38
    //   248: iload 4
    //   250: istore 15
    //   252: iload 29
    //   254: istore 8
    //   256: aload 38
    //   258: astore 41
    //   260: aload 40
    //   262: astore 56
    //   264: aload 37
    //   266: astore 46
    //   268: aload_2
    //   269: astore 51
    //   271: iload 22
    //   273: istore 16
    //   275: iload 30
    //   277: istore 9
    //   279: aload 39
    //   281: astore 42
    //   283: aload 40
    //   285: astore 57
    //   287: aload 64
    //   289: astore 47
    //   291: aload 68
    //   293: astore 52
    //   295: iload 23
    //   297: istore 17
    //   299: iload 31
    //   301: istore 10
    //   303: aload 61
    //   305: astore 43
    //   307: aload 40
    //   309: astore 58
    //   311: aload 65
    //   313: astore 48
    //   315: aload 69
    //   317: astore 53
    //   319: iload 24
    //   321: istore 18
    //   323: iload 32
    //   325: istore 11
    //   327: aload 62
    //   329: astore 44
    //   331: aload 40
    //   333: astore 59
    //   335: aload 66
    //   337: astore 49
    //   339: aload 70
    //   341: astore 54
    //   343: iload 25
    //   345: istore 19
    //   347: iload 33
    //   349: istore 12
    //   351: aload 63
    //   353: astore 45
    //   355: aload 40
    //   357: astore 60
    //   359: aload 67
    //   361: astore 50
    //   363: aload 71
    //   365: astore 55
    //   367: invokestatic 636	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   370: invokevirtual 640	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   373: new 642	java/io/ByteArrayInputStream
    //   376: dup
    //   377: aload 72
    //   379: ldc_w 644
    //   382: invokevirtual 648	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   385: invokespecial 651	java/io/ByteArrayInputStream:<init>	([B)V
    //   388: invokevirtual 656	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   391: astore 75
    //   393: iload 4
    //   395: istore 15
    //   397: iload 29
    //   399: istore 8
    //   401: aload 38
    //   403: astore 41
    //   405: aload 40
    //   407: astore 56
    //   409: aload 37
    //   411: astore 46
    //   413: aload_2
    //   414: astore 51
    //   416: iload 22
    //   418: istore 16
    //   420: iload 30
    //   422: istore 9
    //   424: aload 39
    //   426: astore 42
    //   428: aload 40
    //   430: astore 57
    //   432: aload 64
    //   434: astore 47
    //   436: aload 68
    //   438: astore 52
    //   440: iload 23
    //   442: istore 17
    //   444: iload 31
    //   446: istore 10
    //   448: aload 61
    //   450: astore 43
    //   452: aload 40
    //   454: astore 58
    //   456: aload 65
    //   458: astore 48
    //   460: aload 69
    //   462: astore 53
    //   464: iload 24
    //   466: istore 18
    //   468: iload 32
    //   470: istore 11
    //   472: aload 62
    //   474: astore 44
    //   476: aload 40
    //   478: astore 59
    //   480: aload 66
    //   482: astore 49
    //   484: aload 70
    //   486: astore 54
    //   488: iload 25
    //   490: istore 19
    //   492: iload 33
    //   494: istore 12
    //   496: aload 63
    //   498: astore 45
    //   500: aload 40
    //   502: astore 60
    //   504: aload 67
    //   506: astore 50
    //   508: aload 71
    //   510: astore 55
    //   512: aload 75
    //   514: ldc_w 2264
    //   517: invokeinterface 664 2 0
    //   522: iconst_0
    //   523: invokeinterface 675 2 0
    //   528: invokeinterface 681 1 0
    //   533: invokeinterface 684 1 0
    //   538: astore 72
    //   540: iload 4
    //   542: istore 15
    //   544: iload 29
    //   546: istore 8
    //   548: aload 38
    //   550: astore 41
    //   552: aload 40
    //   554: astore 56
    //   556: aload 37
    //   558: astore 46
    //   560: aload_2
    //   561: astore 51
    //   563: iload 22
    //   565: istore 16
    //   567: iload 30
    //   569: istore 9
    //   571: aload 39
    //   573: astore 42
    //   575: aload 40
    //   577: astore 57
    //   579: aload 64
    //   581: astore 47
    //   583: aload 68
    //   585: astore 52
    //   587: iload 23
    //   589: istore 17
    //   591: iload 31
    //   593: istore 10
    //   595: aload 61
    //   597: astore 43
    //   599: aload 40
    //   601: astore 58
    //   603: aload 65
    //   605: astore 48
    //   607: aload 69
    //   609: astore 53
    //   611: iload 24
    //   613: istore 18
    //   615: iload 32
    //   617: istore 11
    //   619: aload 62
    //   621: astore 44
    //   623: aload 40
    //   625: astore 59
    //   627: aload 66
    //   629: astore 49
    //   631: aload 70
    //   633: astore 54
    //   635: iload 25
    //   637: istore 19
    //   639: iload 33
    //   641: istore 12
    //   643: aload 63
    //   645: astore 45
    //   647: aload 40
    //   649: astore 60
    //   651: aload 67
    //   653: astore 50
    //   655: aload 71
    //   657: astore 55
    //   659: aload 75
    //   661: ldc_w 2266
    //   664: invokeinterface 664 2 0
    //   669: iconst_0
    //   670: invokeinterface 675 2 0
    //   675: invokeinterface 681 1 0
    //   680: invokeinterface 684 1 0
    //   685: astore 73
    //   687: iload 4
    //   689: istore 15
    //   691: iload 29
    //   693: istore 8
    //   695: aload 38
    //   697: astore 41
    //   699: aload 40
    //   701: astore 56
    //   703: aload 37
    //   705: astore 46
    //   707: aload_2
    //   708: astore 51
    //   710: iload 22
    //   712: istore 16
    //   714: iload 30
    //   716: istore 9
    //   718: aload 39
    //   720: astore 42
    //   722: aload 40
    //   724: astore 57
    //   726: aload 64
    //   728: astore 47
    //   730: aload 68
    //   732: astore 52
    //   734: iload 23
    //   736: istore 17
    //   738: iload 31
    //   740: istore 10
    //   742: aload 61
    //   744: astore 43
    //   746: aload 40
    //   748: astore 58
    //   750: aload 65
    //   752: astore 48
    //   754: aload 69
    //   756: astore 53
    //   758: iload 24
    //   760: istore 18
    //   762: iload 32
    //   764: istore 11
    //   766: aload 62
    //   768: astore 44
    //   770: aload 40
    //   772: astore 59
    //   774: aload 66
    //   776: astore 49
    //   778: aload 70
    //   780: astore 54
    //   782: iload 25
    //   784: istore 19
    //   786: iload 33
    //   788: istore 12
    //   790: aload 63
    //   792: astore 45
    //   794: aload 40
    //   796: astore 60
    //   798: aload 67
    //   800: astore 50
    //   802: aload 71
    //   804: astore 55
    //   806: aload 75
    //   808: ldc_w 2268
    //   811: invokeinterface 664 2 0
    //   816: iconst_0
    //   817: invokeinterface 675 2 0
    //   822: invokeinterface 681 1 0
    //   827: invokeinterface 684 1 0
    //   832: astore 74
    //   834: iload 4
    //   836: istore 15
    //   838: iload 29
    //   840: istore 8
    //   842: aload 38
    //   844: astore 41
    //   846: aload 40
    //   848: astore 56
    //   850: aload 37
    //   852: astore 46
    //   854: aload_2
    //   855: astore 51
    //   857: iload 22
    //   859: istore 16
    //   861: iload 30
    //   863: istore 9
    //   865: aload 39
    //   867: astore 42
    //   869: aload 40
    //   871: astore 57
    //   873: aload 64
    //   875: astore 47
    //   877: aload 68
    //   879: astore 52
    //   881: iload 23
    //   883: istore 17
    //   885: iload 31
    //   887: istore 10
    //   889: aload 61
    //   891: astore 43
    //   893: aload 40
    //   895: astore 58
    //   897: aload 65
    //   899: astore 48
    //   901: aload 69
    //   903: astore 53
    //   905: iload 24
    //   907: istore 18
    //   909: iload 32
    //   911: istore 11
    //   913: aload 62
    //   915: astore 44
    //   917: aload 40
    //   919: astore 59
    //   921: aload 66
    //   923: astore 49
    //   925: aload 70
    //   927: astore 54
    //   929: iload 25
    //   931: istore 19
    //   933: iload 33
    //   935: istore 12
    //   937: aload 63
    //   939: astore 45
    //   941: aload 40
    //   943: astore 60
    //   945: aload 67
    //   947: astore 50
    //   949: aload 71
    //   951: astore 55
    //   953: aload 75
    //   955: ldc_w 2270
    //   958: invokeinterface 664 2 0
    //   963: iconst_0
    //   964: invokeinterface 675 2 0
    //   969: invokeinterface 681 1 0
    //   974: invokeinterface 684 1 0
    //   979: astore_2
    //   980: iload 4
    //   982: istore 15
    //   984: iload 29
    //   986: istore 8
    //   988: aload 38
    //   990: astore 41
    //   992: aload 40
    //   994: astore 56
    //   996: aload 37
    //   998: astore 46
    //   1000: aload_2
    //   1001: astore 51
    //   1003: iload 22
    //   1005: istore 16
    //   1007: iload 30
    //   1009: istore 9
    //   1011: aload 39
    //   1013: astore 42
    //   1015: aload 40
    //   1017: astore 57
    //   1019: aload 64
    //   1021: astore 47
    //   1023: aload_2
    //   1024: astore 52
    //   1026: iload 23
    //   1028: istore 17
    //   1030: iload 31
    //   1032: istore 10
    //   1034: aload 61
    //   1036: astore 43
    //   1038: aload 40
    //   1040: astore 58
    //   1042: aload 65
    //   1044: astore 48
    //   1046: aload_2
    //   1047: astore 53
    //   1049: iload 24
    //   1051: istore 18
    //   1053: iload 32
    //   1055: istore 11
    //   1057: aload 62
    //   1059: astore 44
    //   1061: aload 40
    //   1063: astore 59
    //   1065: aload 66
    //   1067: astore 49
    //   1069: aload_2
    //   1070: astore 54
    //   1072: iload 25
    //   1074: istore 19
    //   1076: iload 33
    //   1078: istore 12
    //   1080: aload 63
    //   1082: astore 45
    //   1084: aload 40
    //   1086: astore 60
    //   1088: aload 67
    //   1090: astore 50
    //   1092: aload_2
    //   1093: astore 55
    //   1095: aload 75
    //   1097: ldc_w 2272
    //   1100: invokeinterface 664 2 0
    //   1105: iconst_0
    //   1106: invokeinterface 675 2 0
    //   1111: invokeinterface 681 1 0
    //   1116: invokeinterface 684 1 0
    //   1121: astore 37
    //   1123: iload 4
    //   1125: istore 15
    //   1127: iload 29
    //   1129: istore 8
    //   1131: aload 38
    //   1133: astore 41
    //   1135: aload 40
    //   1137: astore 56
    //   1139: aload 37
    //   1141: astore 46
    //   1143: aload_2
    //   1144: astore 51
    //   1146: iload 22
    //   1148: istore 16
    //   1150: iload 30
    //   1152: istore 9
    //   1154: aload 39
    //   1156: astore 42
    //   1158: aload 40
    //   1160: astore 57
    //   1162: aload 37
    //   1164: astore 47
    //   1166: aload_2
    //   1167: astore 52
    //   1169: iload 23
    //   1171: istore 17
    //   1173: iload 31
    //   1175: istore 10
    //   1177: aload 61
    //   1179: astore 43
    //   1181: aload 40
    //   1183: astore 58
    //   1185: aload 37
    //   1187: astore 48
    //   1189: aload_2
    //   1190: astore 53
    //   1192: iload 24
    //   1194: istore 18
    //   1196: iload 32
    //   1198: istore 11
    //   1200: aload 62
    //   1202: astore 44
    //   1204: aload 40
    //   1206: astore 59
    //   1208: aload 37
    //   1210: astore 49
    //   1212: aload_2
    //   1213: astore 54
    //   1215: iload 25
    //   1217: istore 19
    //   1219: iload 33
    //   1221: istore 12
    //   1223: aload 63
    //   1225: astore 45
    //   1227: aload 40
    //   1229: astore 60
    //   1231: aload 37
    //   1233: astore 50
    //   1235: aload_2
    //   1236: astore 55
    //   1238: aload 75
    //   1240: ldc_w 2274
    //   1243: invokeinterface 664 2 0
    //   1248: iconst_0
    //   1249: invokeinterface 675 2 0
    //   1254: invokeinterface 681 1 0
    //   1259: invokeinterface 684 1 0
    //   1264: astore 39
    //   1266: iload 4
    //   1268: istore 15
    //   1270: iload 29
    //   1272: istore 8
    //   1274: aload 39
    //   1276: astore 41
    //   1278: aload 40
    //   1280: astore 56
    //   1282: aload 37
    //   1284: astore 46
    //   1286: aload_2
    //   1287: astore 51
    //   1289: iload 22
    //   1291: istore 16
    //   1293: iload 30
    //   1295: istore 9
    //   1297: aload 39
    //   1299: astore 42
    //   1301: aload 40
    //   1303: astore 57
    //   1305: aload 37
    //   1307: astore 47
    //   1309: aload_2
    //   1310: astore 52
    //   1312: iload 23
    //   1314: istore 17
    //   1316: iload 31
    //   1318: istore 10
    //   1320: aload 39
    //   1322: astore 43
    //   1324: aload 40
    //   1326: astore 58
    //   1328: aload 37
    //   1330: astore 48
    //   1332: aload_2
    //   1333: astore 53
    //   1335: iload 24
    //   1337: istore 18
    //   1339: iload 32
    //   1341: istore 11
    //   1343: aload 39
    //   1345: astore 44
    //   1347: aload 40
    //   1349: astore 59
    //   1351: aload 37
    //   1353: astore 49
    //   1355: aload_2
    //   1356: astore 54
    //   1358: iload 25
    //   1360: istore 19
    //   1362: iload 33
    //   1364: istore 12
    //   1366: aload 39
    //   1368: astore 45
    //   1370: aload 40
    //   1372: astore 60
    //   1374: aload 37
    //   1376: astore 50
    //   1378: aload_2
    //   1379: astore 55
    //   1381: iload 26
    //   1383: istore 13
    //   1385: iload 34
    //   1387: istore 20
    //   1389: aload 40
    //   1391: astore 61
    //   1393: aload 75
    //   1395: ldc_w 2276
    //   1398: invokeinterface 664 2 0
    //   1403: astore 62
    //   1405: aload 40
    //   1407: astore 38
    //   1409: aload 62
    //   1411: ifnull +431 -> 1842
    //   1414: aload 40
    //   1416: astore 38
    //   1418: iload 4
    //   1420: istore 15
    //   1422: iload 29
    //   1424: istore 8
    //   1426: aload 39
    //   1428: astore 41
    //   1430: aload 40
    //   1432: astore 56
    //   1434: aload 37
    //   1436: astore 46
    //   1438: aload_2
    //   1439: astore 51
    //   1441: iload 22
    //   1443: istore 16
    //   1445: iload 30
    //   1447: istore 9
    //   1449: aload 39
    //   1451: astore 42
    //   1453: aload 40
    //   1455: astore 57
    //   1457: aload 37
    //   1459: astore 47
    //   1461: aload_2
    //   1462: astore 52
    //   1464: iload 23
    //   1466: istore 17
    //   1468: iload 31
    //   1470: istore 10
    //   1472: aload 39
    //   1474: astore 43
    //   1476: aload 40
    //   1478: astore 58
    //   1480: aload 37
    //   1482: astore 48
    //   1484: aload_2
    //   1485: astore 53
    //   1487: iload 24
    //   1489: istore 18
    //   1491: iload 32
    //   1493: istore 11
    //   1495: aload 39
    //   1497: astore 44
    //   1499: aload 40
    //   1501: astore 59
    //   1503: aload 37
    //   1505: astore 49
    //   1507: aload_2
    //   1508: astore 54
    //   1510: iload 25
    //   1512: istore 19
    //   1514: iload 33
    //   1516: istore 12
    //   1518: aload 39
    //   1520: astore 45
    //   1522: aload 40
    //   1524: astore 60
    //   1526: aload 37
    //   1528: astore 50
    //   1530: aload_2
    //   1531: astore 55
    //   1533: iload 26
    //   1535: istore 13
    //   1537: iload 34
    //   1539: istore 20
    //   1541: aload 40
    //   1543: astore 61
    //   1545: aload 62
    //   1547: invokeinterface 669 1 0
    //   1552: ifle +290 -> 1842
    //   1555: iload 4
    //   1557: istore 15
    //   1559: iload 29
    //   1561: istore 8
    //   1563: aload 39
    //   1565: astore 41
    //   1567: aload 40
    //   1569: astore 56
    //   1571: aload 37
    //   1573: astore 46
    //   1575: aload_2
    //   1576: astore 51
    //   1578: iload 22
    //   1580: istore 16
    //   1582: iload 30
    //   1584: istore 9
    //   1586: aload 39
    //   1588: astore 42
    //   1590: aload 40
    //   1592: astore 57
    //   1594: aload 37
    //   1596: astore 47
    //   1598: aload_2
    //   1599: astore 52
    //   1601: iload 23
    //   1603: istore 17
    //   1605: iload 31
    //   1607: istore 10
    //   1609: aload 39
    //   1611: astore 43
    //   1613: aload 40
    //   1615: astore 58
    //   1617: aload 37
    //   1619: astore 48
    //   1621: aload_2
    //   1622: astore 53
    //   1624: iload 24
    //   1626: istore 18
    //   1628: iload 32
    //   1630: istore 11
    //   1632: aload 39
    //   1634: astore 44
    //   1636: aload 40
    //   1638: astore 59
    //   1640: aload 37
    //   1642: astore 49
    //   1644: aload_2
    //   1645: astore 54
    //   1647: iload 25
    //   1649: istore 19
    //   1651: iload 33
    //   1653: istore 12
    //   1655: aload 39
    //   1657: astore 45
    //   1659: aload 40
    //   1661: astore 60
    //   1663: aload 37
    //   1665: astore 50
    //   1667: aload_2
    //   1668: astore 55
    //   1670: iload 26
    //   1672: istore 13
    //   1674: iload 34
    //   1676: istore 20
    //   1678: aload 40
    //   1680: astore 61
    //   1682: aload 62
    //   1684: iconst_0
    //   1685: invokeinterface 675 2 0
    //   1690: invokeinterface 681 1 0
    //   1695: astore 62
    //   1697: aload 40
    //   1699: astore 38
    //   1701: aload 62
    //   1703: ifnull +139 -> 1842
    //   1706: iload 4
    //   1708: istore 15
    //   1710: iload 29
    //   1712: istore 8
    //   1714: aload 39
    //   1716: astore 41
    //   1718: aload 40
    //   1720: astore 56
    //   1722: aload 37
    //   1724: astore 46
    //   1726: aload_2
    //   1727: astore 51
    //   1729: iload 22
    //   1731: istore 16
    //   1733: iload 30
    //   1735: istore 9
    //   1737: aload 39
    //   1739: astore 42
    //   1741: aload 40
    //   1743: astore 57
    //   1745: aload 37
    //   1747: astore 47
    //   1749: aload_2
    //   1750: astore 52
    //   1752: iload 23
    //   1754: istore 17
    //   1756: iload 31
    //   1758: istore 10
    //   1760: aload 39
    //   1762: astore 43
    //   1764: aload 40
    //   1766: astore 58
    //   1768: aload 37
    //   1770: astore 48
    //   1772: aload_2
    //   1773: astore 53
    //   1775: iload 24
    //   1777: istore 18
    //   1779: iload 32
    //   1781: istore 11
    //   1783: aload 39
    //   1785: astore 44
    //   1787: aload 40
    //   1789: astore 59
    //   1791: aload 37
    //   1793: astore 49
    //   1795: aload_2
    //   1796: astore 54
    //   1798: iload 25
    //   1800: istore 19
    //   1802: iload 33
    //   1804: istore 12
    //   1806: aload 39
    //   1808: astore 45
    //   1810: aload 40
    //   1812: astore 60
    //   1814: aload 37
    //   1816: astore 50
    //   1818: aload_2
    //   1819: astore 55
    //   1821: iload 26
    //   1823: istore 13
    //   1825: iload 34
    //   1827: istore 20
    //   1829: aload 40
    //   1831: astore 61
    //   1833: aload 62
    //   1835: invokeinterface 684 1 0
    //   1840: astore 38
    //   1842: iload 28
    //   1844: istore 14
    //   1846: iload 27
    //   1848: istore 6
    //   1850: iload_3
    //   1851: istore 5
    //   1853: iload 21
    //   1855: istore 7
    //   1857: iload 4
    //   1859: istore 15
    //   1861: iload 29
    //   1863: istore 8
    //   1865: aload 39
    //   1867: astore 41
    //   1869: aload 38
    //   1871: astore 56
    //   1873: aload 37
    //   1875: astore 46
    //   1877: aload_2
    //   1878: astore 51
    //   1880: iload 22
    //   1882: istore 16
    //   1884: iload 30
    //   1886: istore 9
    //   1888: aload 39
    //   1890: astore 42
    //   1892: aload 38
    //   1894: astore 57
    //   1896: aload 37
    //   1898: astore 47
    //   1900: aload_2
    //   1901: astore 52
    //   1903: iload 23
    //   1905: istore 17
    //   1907: iload 31
    //   1909: istore 10
    //   1911: aload 39
    //   1913: astore 43
    //   1915: aload 38
    //   1917: astore 58
    //   1919: aload 37
    //   1921: astore 48
    //   1923: aload_2
    //   1924: astore 53
    //   1926: iload 24
    //   1928: istore 18
    //   1930: iload 32
    //   1932: istore 11
    //   1934: aload 39
    //   1936: astore 44
    //   1938: aload 38
    //   1940: astore 59
    //   1942: aload 37
    //   1944: astore 49
    //   1946: aload_2
    //   1947: astore 54
    //   1949: iload 25
    //   1951: istore 19
    //   1953: iload 33
    //   1955: istore 12
    //   1957: aload 39
    //   1959: astore 45
    //   1961: aload 38
    //   1963: astore 60
    //   1965: aload 37
    //   1967: astore 50
    //   1969: aload_2
    //   1970: astore 55
    //   1972: iload 26
    //   1974: istore 13
    //   1976: iload 34
    //   1978: istore 20
    //   1980: aload 38
    //   1982: astore 61
    //   1984: aload 72
    //   1986: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1989: ifne +1289 -> 3278
    //   1992: iload 28
    //   1994: istore 14
    //   1996: iload 27
    //   1998: istore 6
    //   2000: iload_3
    //   2001: istore 5
    //   2003: iload 21
    //   2005: istore 7
    //   2007: iload 4
    //   2009: istore 15
    //   2011: iload 29
    //   2013: istore 8
    //   2015: aload 39
    //   2017: astore 41
    //   2019: aload 38
    //   2021: astore 56
    //   2023: aload 37
    //   2025: astore 46
    //   2027: aload_2
    //   2028: astore 51
    //   2030: iload 22
    //   2032: istore 16
    //   2034: iload 30
    //   2036: istore 9
    //   2038: aload 39
    //   2040: astore 42
    //   2042: aload 38
    //   2044: astore 57
    //   2046: aload 37
    //   2048: astore 47
    //   2050: aload_2
    //   2051: astore 52
    //   2053: iload 23
    //   2055: istore 17
    //   2057: iload 31
    //   2059: istore 10
    //   2061: aload 39
    //   2063: astore 43
    //   2065: aload 38
    //   2067: astore 58
    //   2069: aload 37
    //   2071: astore 48
    //   2073: aload_2
    //   2074: astore 53
    //   2076: iload 24
    //   2078: istore 18
    //   2080: iload 32
    //   2082: istore 11
    //   2084: aload 39
    //   2086: astore 44
    //   2088: aload 38
    //   2090: astore 59
    //   2092: aload 37
    //   2094: astore 49
    //   2096: aload_2
    //   2097: astore 54
    //   2099: iload 25
    //   2101: istore 19
    //   2103: iload 33
    //   2105: istore 12
    //   2107: aload 39
    //   2109: astore 45
    //   2111: aload 38
    //   2113: astore 60
    //   2115: aload 37
    //   2117: astore 50
    //   2119: aload_2
    //   2120: astore 55
    //   2122: iload 26
    //   2124: istore 13
    //   2126: iload 34
    //   2128: istore 20
    //   2130: aload 38
    //   2132: astore 61
    //   2134: aload 73
    //   2136: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2139: ifne +1139 -> 3278
    //   2142: iload 28
    //   2144: istore 14
    //   2146: iload 27
    //   2148: istore 6
    //   2150: iload_3
    //   2151: istore 5
    //   2153: iload 21
    //   2155: istore 7
    //   2157: iload 4
    //   2159: istore 15
    //   2161: iload 29
    //   2163: istore 8
    //   2165: aload 39
    //   2167: astore 41
    //   2169: aload 38
    //   2171: astore 56
    //   2173: aload 37
    //   2175: astore 46
    //   2177: aload_2
    //   2178: astore 51
    //   2180: iload 22
    //   2182: istore 16
    //   2184: iload 30
    //   2186: istore 9
    //   2188: aload 39
    //   2190: astore 42
    //   2192: aload 38
    //   2194: astore 57
    //   2196: aload 37
    //   2198: astore 47
    //   2200: aload_2
    //   2201: astore 52
    //   2203: iload 23
    //   2205: istore 17
    //   2207: iload 31
    //   2209: istore 10
    //   2211: aload 39
    //   2213: astore 43
    //   2215: aload 38
    //   2217: astore 58
    //   2219: aload 37
    //   2221: astore 48
    //   2223: aload_2
    //   2224: astore 53
    //   2226: iload 24
    //   2228: istore 18
    //   2230: iload 32
    //   2232: istore 11
    //   2234: aload 39
    //   2236: astore 44
    //   2238: aload 38
    //   2240: astore 59
    //   2242: aload 37
    //   2244: astore 49
    //   2246: aload_2
    //   2247: astore 54
    //   2249: iload 25
    //   2251: istore 19
    //   2253: iload 33
    //   2255: istore 12
    //   2257: aload 39
    //   2259: astore 45
    //   2261: aload 38
    //   2263: astore 60
    //   2265: aload 37
    //   2267: astore 50
    //   2269: aload_2
    //   2270: astore 55
    //   2272: iload 26
    //   2274: istore 13
    //   2276: iload 34
    //   2278: istore 20
    //   2280: aload 38
    //   2282: astore 61
    //   2284: aload 37
    //   2286: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2289: ifne +989 -> 3278
    //   2292: iload 28
    //   2294: istore 14
    //   2296: iload 27
    //   2298: istore 6
    //   2300: iload_3
    //   2301: istore 5
    //   2303: iload 21
    //   2305: istore 7
    //   2307: iload 4
    //   2309: istore 15
    //   2311: iload 29
    //   2313: istore 8
    //   2315: aload 39
    //   2317: astore 41
    //   2319: aload 38
    //   2321: astore 56
    //   2323: aload 37
    //   2325: astore 46
    //   2327: aload_2
    //   2328: astore 51
    //   2330: iload 22
    //   2332: istore 16
    //   2334: iload 30
    //   2336: istore 9
    //   2338: aload 39
    //   2340: astore 42
    //   2342: aload 38
    //   2344: astore 57
    //   2346: aload 37
    //   2348: astore 47
    //   2350: aload_2
    //   2351: astore 52
    //   2353: iload 23
    //   2355: istore 17
    //   2357: iload 31
    //   2359: istore 10
    //   2361: aload 39
    //   2363: astore 43
    //   2365: aload 38
    //   2367: astore 58
    //   2369: aload 37
    //   2371: astore 48
    //   2373: aload_2
    //   2374: astore 53
    //   2376: iload 24
    //   2378: istore 18
    //   2380: iload 32
    //   2382: istore 11
    //   2384: aload 39
    //   2386: astore 44
    //   2388: aload 38
    //   2390: astore 59
    //   2392: aload 37
    //   2394: astore 49
    //   2396: aload_2
    //   2397: astore 54
    //   2399: iload 25
    //   2401: istore 19
    //   2403: iload 33
    //   2405: istore 12
    //   2407: aload 39
    //   2409: astore 45
    //   2411: aload 38
    //   2413: astore 60
    //   2415: aload 37
    //   2417: astore 50
    //   2419: aload_2
    //   2420: astore 55
    //   2422: iload 26
    //   2424: istore 13
    //   2426: iload 34
    //   2428: istore 20
    //   2430: aload 38
    //   2432: astore 61
    //   2434: aload 39
    //   2436: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2439: ifne +839 -> 3278
    //   2442: iload 28
    //   2444: istore 14
    //   2446: iload 27
    //   2448: istore 6
    //   2450: iload_3
    //   2451: istore 5
    //   2453: iload 21
    //   2455: istore 7
    //   2457: iload 4
    //   2459: istore 15
    //   2461: iload 29
    //   2463: istore 8
    //   2465: aload 39
    //   2467: astore 41
    //   2469: aload 38
    //   2471: astore 56
    //   2473: aload 37
    //   2475: astore 46
    //   2477: aload_2
    //   2478: astore 51
    //   2480: iload 22
    //   2482: istore 16
    //   2484: iload 30
    //   2486: istore 9
    //   2488: aload 39
    //   2490: astore 42
    //   2492: aload 38
    //   2494: astore 57
    //   2496: aload 37
    //   2498: astore 47
    //   2500: aload_2
    //   2501: astore 52
    //   2503: iload 23
    //   2505: istore 17
    //   2507: iload 31
    //   2509: istore 10
    //   2511: aload 39
    //   2513: astore 43
    //   2515: aload 38
    //   2517: astore 58
    //   2519: aload 37
    //   2521: astore 48
    //   2523: aload_2
    //   2524: astore 53
    //   2526: iload 24
    //   2528: istore 18
    //   2530: iload 32
    //   2532: istore 11
    //   2534: aload 39
    //   2536: astore 44
    //   2538: aload 38
    //   2540: astore 59
    //   2542: aload 37
    //   2544: astore 49
    //   2546: aload_2
    //   2547: astore 54
    //   2549: iload 25
    //   2551: istore 19
    //   2553: iload 33
    //   2555: istore 12
    //   2557: aload 39
    //   2559: astore 45
    //   2561: aload 38
    //   2563: astore 60
    //   2565: aload 37
    //   2567: astore 50
    //   2569: aload_2
    //   2570: astore 55
    //   2572: iload 26
    //   2574: istore 13
    //   2576: iload 34
    //   2578: istore 20
    //   2580: aload 38
    //   2582: astore 61
    //   2584: aload_2
    //   2585: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2588: ifne +690 -> 3278
    //   2591: iload 28
    //   2593: istore 14
    //   2595: iload 27
    //   2597: istore 6
    //   2599: iload_3
    //   2600: istore 5
    //   2602: iload 21
    //   2604: istore 7
    //   2606: iload 4
    //   2608: istore 15
    //   2610: iload 29
    //   2612: istore 8
    //   2614: aload 39
    //   2616: astore 41
    //   2618: aload 38
    //   2620: astore 56
    //   2622: aload 37
    //   2624: astore 46
    //   2626: aload_2
    //   2627: astore 51
    //   2629: iload 22
    //   2631: istore 16
    //   2633: iload 30
    //   2635: istore 9
    //   2637: aload 39
    //   2639: astore 42
    //   2641: aload 38
    //   2643: astore 57
    //   2645: aload 37
    //   2647: astore 47
    //   2649: aload_2
    //   2650: astore 52
    //   2652: iload 23
    //   2654: istore 17
    //   2656: iload 31
    //   2658: istore 10
    //   2660: aload 39
    //   2662: astore 43
    //   2664: aload 38
    //   2666: astore 58
    //   2668: aload 37
    //   2670: astore 48
    //   2672: aload_2
    //   2673: astore 53
    //   2675: iload 24
    //   2677: istore 18
    //   2679: iload 32
    //   2681: istore 11
    //   2683: aload 39
    //   2685: astore 44
    //   2687: aload 38
    //   2689: astore 59
    //   2691: aload 37
    //   2693: astore 49
    //   2695: aload_2
    //   2696: astore 54
    //   2698: iload 25
    //   2700: istore 19
    //   2702: iload 33
    //   2704: istore 12
    //   2706: aload 39
    //   2708: astore 45
    //   2710: aload 38
    //   2712: astore 60
    //   2714: aload 37
    //   2716: astore 50
    //   2718: aload_2
    //   2719: astore 55
    //   2721: iload 26
    //   2723: istore 13
    //   2725: iload 34
    //   2727: istore 20
    //   2729: aload 38
    //   2731: astore 61
    //   2733: aload 74
    //   2735: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2738: ifne +540 -> 3278
    //   2741: iload 4
    //   2743: istore 15
    //   2745: iload 29
    //   2747: istore 8
    //   2749: aload 39
    //   2751: astore 41
    //   2753: aload 38
    //   2755: astore 56
    //   2757: aload 37
    //   2759: astore 46
    //   2761: aload_2
    //   2762: astore 51
    //   2764: iload 22
    //   2766: istore 16
    //   2768: iload 30
    //   2770: istore 9
    //   2772: aload 39
    //   2774: astore 42
    //   2776: aload 38
    //   2778: astore 57
    //   2780: aload 37
    //   2782: astore 47
    //   2784: aload_2
    //   2785: astore 52
    //   2787: iload 23
    //   2789: istore 17
    //   2791: iload 31
    //   2793: istore 10
    //   2795: aload 39
    //   2797: astore 43
    //   2799: aload 38
    //   2801: astore 58
    //   2803: aload 37
    //   2805: astore 48
    //   2807: aload_2
    //   2808: astore 53
    //   2810: iload 24
    //   2812: istore 18
    //   2814: iload 32
    //   2816: istore 11
    //   2818: aload 39
    //   2820: astore 44
    //   2822: aload 38
    //   2824: astore 59
    //   2826: aload 37
    //   2828: astore 49
    //   2830: aload_2
    //   2831: astore 54
    //   2833: iload 25
    //   2835: istore 19
    //   2837: iload 33
    //   2839: istore 12
    //   2841: aload 39
    //   2843: astore 45
    //   2845: aload 38
    //   2847: astore 60
    //   2849: aload 37
    //   2851: astore 50
    //   2853: aload_2
    //   2854: astore 55
    //   2856: iload 26
    //   2858: istore 13
    //   2860: iload 34
    //   2862: istore 20
    //   2864: aload 38
    //   2866: astore 61
    //   2868: aload 72
    //   2870: invokestatic 2279	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2873: invokevirtual 1588	java/lang/Integer:intValue	()I
    //   2876: istore_3
    //   2877: iload 4
    //   2879: istore 15
    //   2881: iload_3
    //   2882: istore 8
    //   2884: aload 39
    //   2886: astore 41
    //   2888: aload 38
    //   2890: astore 56
    //   2892: aload 37
    //   2894: astore 46
    //   2896: aload_2
    //   2897: astore 51
    //   2899: iload 22
    //   2901: istore 16
    //   2903: iload_3
    //   2904: istore 9
    //   2906: aload 39
    //   2908: astore 42
    //   2910: aload 38
    //   2912: astore 57
    //   2914: aload 37
    //   2916: astore 47
    //   2918: aload_2
    //   2919: astore 52
    //   2921: iload 23
    //   2923: istore 17
    //   2925: iload_3
    //   2926: istore 10
    //   2928: aload 39
    //   2930: astore 43
    //   2932: aload 38
    //   2934: astore 58
    //   2936: aload 37
    //   2938: astore 48
    //   2940: aload_2
    //   2941: astore 53
    //   2943: iload 24
    //   2945: istore 18
    //   2947: iload_3
    //   2948: istore 11
    //   2950: aload 39
    //   2952: astore 44
    //   2954: aload 38
    //   2956: astore 59
    //   2958: aload 37
    //   2960: astore 49
    //   2962: aload_2
    //   2963: astore 54
    //   2965: iload 25
    //   2967: istore 19
    //   2969: iload_3
    //   2970: istore 12
    //   2972: aload 39
    //   2974: astore 45
    //   2976: aload 38
    //   2978: astore 60
    //   2980: aload 37
    //   2982: astore 50
    //   2984: aload_2
    //   2985: astore 55
    //   2987: iload 26
    //   2989: istore 13
    //   2991: iload_3
    //   2992: istore 20
    //   2994: aload 38
    //   2996: astore 61
    //   2998: aload 73
    //   3000: invokestatic 2279	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   3003: invokevirtual 1588	java/lang/Integer:intValue	()I
    //   3006: istore 4
    //   3008: iload 4
    //   3010: istore 15
    //   3012: iload_3
    //   3013: istore 8
    //   3015: aload 39
    //   3017: astore 41
    //   3019: aload 38
    //   3021: astore 56
    //   3023: aload 37
    //   3025: astore 46
    //   3027: aload_2
    //   3028: astore 51
    //   3030: iload 4
    //   3032: istore 16
    //   3034: iload_3
    //   3035: istore 9
    //   3037: aload 39
    //   3039: astore 42
    //   3041: aload 38
    //   3043: astore 57
    //   3045: aload 37
    //   3047: astore 47
    //   3049: aload_2
    //   3050: astore 52
    //   3052: iload 4
    //   3054: istore 17
    //   3056: iload_3
    //   3057: istore 10
    //   3059: aload 39
    //   3061: astore 43
    //   3063: aload 38
    //   3065: astore 58
    //   3067: aload 37
    //   3069: astore 48
    //   3071: aload_2
    //   3072: astore 53
    //   3074: iload 4
    //   3076: istore 18
    //   3078: iload_3
    //   3079: istore 11
    //   3081: aload 39
    //   3083: astore 44
    //   3085: aload 38
    //   3087: astore 59
    //   3089: aload 37
    //   3091: astore 49
    //   3093: aload_2
    //   3094: astore 54
    //   3096: iload 4
    //   3098: istore 19
    //   3100: iload_3
    //   3101: istore 12
    //   3103: aload 39
    //   3105: astore 45
    //   3107: aload 38
    //   3109: astore 60
    //   3111: aload 37
    //   3113: astore 50
    //   3115: aload_2
    //   3116: astore 55
    //   3118: iload 4
    //   3120: istore 13
    //   3122: iload_3
    //   3123: istore 20
    //   3125: aload 38
    //   3127: astore 61
    //   3129: aload 74
    //   3131: invokestatic 2279	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   3134: invokevirtual 1588	java/lang/Integer:intValue	()I
    //   3137: istore 5
    //   3139: iload 5
    //   3141: istore 8
    //   3143: iload 8
    //   3145: istore 14
    //   3147: iload 4
    //   3149: istore 6
    //   3151: iload_3
    //   3152: istore 5
    //   3154: iload 21
    //   3156: istore 7
    //   3158: iload_3
    //   3159: iflt +119 -> 3278
    //   3162: iload 8
    //   3164: istore 14
    //   3166: iload 4
    //   3168: istore 6
    //   3170: iload_3
    //   3171: istore 5
    //   3173: iload 21
    //   3175: istore 7
    //   3177: iload_3
    //   3178: iconst_1
    //   3179: if_icmpgt +99 -> 3278
    //   3182: iload 8
    //   3184: istore 14
    //   3186: iload 4
    //   3188: istore 6
    //   3190: iload_3
    //   3191: istore 5
    //   3193: iload 21
    //   3195: istore 7
    //   3197: iload 4
    //   3199: iflt +79 -> 3278
    //   3202: iload 8
    //   3204: istore 14
    //   3206: iload 4
    //   3208: istore 6
    //   3210: iload_3
    //   3211: istore 5
    //   3213: iload 21
    //   3215: istore 7
    //   3217: iload 4
    //   3219: iconst_1
    //   3220: if_icmpgt +58 -> 3278
    //   3223: iload 8
    //   3225: istore 14
    //   3227: iload 4
    //   3229: istore 6
    //   3231: iload_3
    //   3232: istore 5
    //   3234: iload 21
    //   3236: istore 7
    //   3238: iload 8
    //   3240: iflt +38 -> 3278
    //   3243: iload 8
    //   3245: istore 14
    //   3247: iload 4
    //   3249: istore 6
    //   3251: iload_3
    //   3252: istore 5
    //   3254: iload 21
    //   3256: istore 7
    //   3258: iload 8
    //   3260: iconst_1
    //   3261: if_icmpgt +17 -> 3278
    //   3264: iconst_1
    //   3265: istore 7
    //   3267: iload_3
    //   3268: istore 5
    //   3270: iload 4
    //   3272: istore 6
    //   3274: iload 8
    //   3276: istore 14
    //   3278: aload 38
    //   3280: astore 40
    //   3282: aload_2
    //   3283: astore 38
    //   3285: iload 7
    //   3287: istore_3
    //   3288: aload 37
    //   3290: astore_2
    //   3291: iload 6
    //   3293: istore 4
    //   3295: iload 5
    //   3297: istore 7
    //   3299: iload 14
    //   3301: istore 6
    //   3303: aload 40
    //   3305: astore 37
    //   3307: iload 4
    //   3309: istore 5
    //   3311: iload 7
    //   3313: istore 4
    //   3315: iload_3
    //   3316: ifeq +95 -> 3411
    //   3319: invokestatic 2284	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:a	()Lcom/tencent/mobileqq/activity/aio/qim/QIMUserManager;
    //   3322: aload_1
    //   3323: invokevirtual 2287	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3326: astore 40
    //   3328: invokestatic 2284	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:a	()Lcom/tencent/mobileqq/activity/aio/qim/QIMUserManager;
    //   3331: aload_1
    //   3332: invokevirtual 2289	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3335: astore 41
    //   3337: iconst_0
    //   3338: istore 36
    //   3340: aload 40
    //   3342: aload_2
    //   3343: invokevirtual 483	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3346: ifeq +13 -> 3359
    //   3349: aload 41
    //   3351: aload 39
    //   3353: invokevirtual 483	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3356: ifne +6 -> 3362
    //   3359: iconst_1
    //   3360: istore 36
    //   3362: invokestatic 2284	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:a	()Lcom/tencent/mobileqq/activity/aio/qim/QIMUserManager;
    //   3365: iload 4
    //   3367: iload 5
    //   3369: aload_2
    //   3370: aload 37
    //   3372: aload 39
    //   3374: aload 38
    //   3376: iload 36
    //   3378: iload 6
    //   3380: invokevirtual 2292	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:a	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3383: aload_1
    //   3384: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3387: aload_1
    //   3388: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3391: iload 35
    //   3393: iload 4
    //   3395: iload 5
    //   3397: aload_2
    //   3398: aload 39
    //   3400: aload 37
    //   3402: aload 38
    //   3404: iload 36
    //   3406: iload 6
    //   3408: invokestatic 2295	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3411: return
    //   3412: astore 40
    //   3414: ldc 13
    //   3416: astore 37
    //   3418: aconst_null
    //   3419: astore 38
    //   3421: iconst_0
    //   3422: istore 4
    //   3424: aconst_null
    //   3425: astore_2
    //   3426: aconst_null
    //   3427: astore 39
    //   3429: iconst_0
    //   3430: istore_3
    //   3431: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3434: ifeq +16 -> 3450
    //   3437: ldc_w 2262
    //   3440: iconst_2
    //   3441: aload 40
    //   3443: iconst_0
    //   3444: anewarray 4	java/lang/Object
    //   3447: invokestatic 2298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3450: iconst_0
    //   3451: istore 6
    //   3453: iconst_0
    //   3454: istore 7
    //   3456: aload 39
    //   3458: astore 40
    //   3460: aload_2
    //   3461: astore 39
    //   3463: iload_3
    //   3464: istore 5
    //   3466: iload 7
    //   3468: istore_3
    //   3469: aload 40
    //   3471: astore_2
    //   3472: goto -157 -> 3315
    //   3475: astore_2
    //   3476: iload 15
    //   3478: istore 5
    //   3480: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3483: ifeq +15 -> 3498
    //   3486: ldc_w 2262
    //   3489: iconst_2
    //   3490: aload_2
    //   3491: iconst_0
    //   3492: anewarray 4	java/lang/Object
    //   3495: invokestatic 2298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3498: iload 8
    //   3500: istore 4
    //   3502: aload 56
    //   3504: astore 37
    //   3506: aload 51
    //   3508: astore 38
    //   3510: iconst_0
    //   3511: istore 6
    //   3513: iconst_0
    //   3514: istore_3
    //   3515: aload 46
    //   3517: astore_2
    //   3518: aload 41
    //   3520: astore 39
    //   3522: goto -207 -> 3315
    //   3525: astore_2
    //   3526: iload 16
    //   3528: istore 5
    //   3530: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3533: ifeq +15 -> 3548
    //   3536: ldc_w 2262
    //   3539: iconst_2
    //   3540: aload_2
    //   3541: iconst_0
    //   3542: anewarray 4	java/lang/Object
    //   3545: invokestatic 2298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3548: iload 9
    //   3550: istore 4
    //   3552: aload 57
    //   3554: astore 37
    //   3556: aload 52
    //   3558: astore 38
    //   3560: iconst_0
    //   3561: istore 6
    //   3563: iconst_0
    //   3564: istore_3
    //   3565: aload 47
    //   3567: astore_2
    //   3568: aload 42
    //   3570: astore 39
    //   3572: goto -257 -> 3315
    //   3575: astore_2
    //   3576: iload 17
    //   3578: istore 5
    //   3580: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3583: ifeq +15 -> 3598
    //   3586: ldc_w 2262
    //   3589: iconst_2
    //   3590: aload_2
    //   3591: iconst_0
    //   3592: anewarray 4	java/lang/Object
    //   3595: invokestatic 2298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3598: iload 10
    //   3600: istore 4
    //   3602: aload 58
    //   3604: astore 37
    //   3606: aload 53
    //   3608: astore 38
    //   3610: iconst_0
    //   3611: istore 6
    //   3613: iconst_0
    //   3614: istore_3
    //   3615: aload 48
    //   3617: astore_2
    //   3618: aload 43
    //   3620: astore 39
    //   3622: goto -307 -> 3315
    //   3625: astore_2
    //   3626: iload 18
    //   3628: istore 5
    //   3630: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3633: ifeq +15 -> 3648
    //   3636: ldc_w 2262
    //   3639: iconst_2
    //   3640: aload_2
    //   3641: iconst_0
    //   3642: anewarray 4	java/lang/Object
    //   3645: invokestatic 2298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3648: iload 11
    //   3650: istore 4
    //   3652: aload 59
    //   3654: astore 37
    //   3656: aload 54
    //   3658: astore 38
    //   3660: iconst_0
    //   3661: istore 6
    //   3663: iconst_0
    //   3664: istore_3
    //   3665: aload 49
    //   3667: astore_2
    //   3668: aload 44
    //   3670: astore 39
    //   3672: goto -357 -> 3315
    //   3675: astore_2
    //   3676: iload 19
    //   3678: istore 5
    //   3680: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3683: ifeq +15 -> 3698
    //   3686: ldc_w 2262
    //   3689: iconst_2
    //   3690: aload_2
    //   3691: iconst_0
    //   3692: anewarray 4	java/lang/Object
    //   3695: invokestatic 2298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3698: iload 12
    //   3700: istore 4
    //   3702: aload 60
    //   3704: astore 37
    //   3706: aload 55
    //   3708: astore 38
    //   3710: iconst_0
    //   3711: istore 6
    //   3713: iconst_0
    //   3714: istore_3
    //   3715: aload 50
    //   3717: astore_2
    //   3718: aload 45
    //   3720: astore 39
    //   3722: goto -407 -> 3315
    //   3725: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3728: ifeq -317 -> 3411
    //   3731: ldc 77
    //   3733: iconst_2
    //   3734: new 79	java/lang/StringBuilder
    //   3737: dup
    //   3738: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3741: ldc_w 2300
    //   3744: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3747: aload_2
    //   3748: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3751: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3754: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3757: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3760: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3763: return
    //   3764: astore 40
    //   3766: ldc 13
    //   3768: astore 37
    //   3770: aload_2
    //   3771: astore 38
    //   3773: iconst_0
    //   3774: istore 4
    //   3776: aconst_null
    //   3777: astore_2
    //   3778: aconst_null
    //   3779: astore 39
    //   3781: iconst_0
    //   3782: istore_3
    //   3783: goto -352 -> 3431
    //   3786: astore 40
    //   3788: ldc 13
    //   3790: astore 41
    //   3792: aload_2
    //   3793: astore 38
    //   3795: iconst_0
    //   3796: istore 4
    //   3798: aconst_null
    //   3799: astore_2
    //   3800: aload 37
    //   3802: astore 39
    //   3804: iconst_0
    //   3805: istore_3
    //   3806: aload 41
    //   3808: astore 37
    //   3810: goto -379 -> 3431
    //   3813: astore 40
    //   3815: aload_2
    //   3816: astore 38
    //   3818: iload 20
    //   3820: istore 4
    //   3822: aload 39
    //   3824: astore_2
    //   3825: aload 37
    //   3827: astore 39
    //   3829: iload 13
    //   3831: istore_3
    //   3832: aload 61
    //   3834: astore 37
    //   3836: goto -405 -> 3431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3839	0	this	ConfigServlet
    //   0	3839	1	paramQQAppInterface	QQAppInterface
    //   0	3839	2	paramConfig	ConfigurationService.Config
    //   20	3812	3	i	int
    //   32	3789	4	j	int
    //   37	3642	5	k	int
    //   1848	1864	6	m	int
    //   1855	1612	7	n	int
    //   254	3245	8	i1	int
    //   277	3272	9	i2	int
    //   301	3298	10	i3	int
    //   325	3324	11	i4	int
    //   349	3350	12	i5	int
    //   1383	2447	13	i6	int
    //   1844	1456	14	i7	int
    //   250	3227	15	i8	int
    //   273	3254	16	i9	int
    //   297	3280	17	i10	int
    //   321	3306	18	i11	int
    //   345	3332	19	i12	int
    //   1387	2432	20	i13	int
    //   154	3101	21	i14	int
    //   180	2720	22	i15	int
    //   183	2739	23	i16	int
    //   186	2758	24	i17	int
    //   189	2777	25	i18	int
    //   192	2796	26	i19	int
    //   195	2401	27	i20	int
    //   198	2394	28	i21	int
    //   157	2589	29	i22	int
    //   160	2609	30	i23	int
    //   163	2629	31	i24	int
    //   166	2649	32	i25	int
    //   169	2669	33	i26	int
    //   172	2689	34	i27	int
    //   7	3385	35	i28	int
    //   3338	67	36	bool	boolean
    //   227	3608	37	localObject1	Object
    //   246	3571	38	localObject2	Object
    //   234	3594	39	localObject3	Object
    //   231	3110	40	localObject4	Object
    //   3412	30	40	localParserConfigurationException1	javax.xml.parsers.ParserConfigurationException
    //   3458	12	40	localObject5	Object
    //   3764	1	40	localParserConfigurationException2	javax.xml.parsers.ParserConfigurationException
    //   3786	1	40	localParserConfigurationException3	javax.xml.parsers.ParserConfigurationException
    //   3813	1	40	localParserConfigurationException4	javax.xml.parsers.ParserConfigurationException
    //   258	3549	41	localObject6	Object
    //   281	3288	42	localObject7	Object
    //   305	3314	43	localObject8	Object
    //   329	3340	44	localObject9	Object
    //   353	3366	45	localObject10	Object
    //   266	3250	46	localObject11	Object
    //   289	3277	47	localObject12	Object
    //   313	3303	48	localObject13	Object
    //   337	3329	49	localObject14	Object
    //   361	3355	50	localObject15	Object
    //   269	3238	51	localConfig	ConfigurationService.Config
    //   293	3264	52	localObject16	Object
    //   317	3290	53	localObject17	Object
    //   341	3316	54	localObject18	Object
    //   365	3342	55	localObject19	Object
    //   262	3241	56	localObject20	Object
    //   285	3268	57	localObject21	Object
    //   309	3294	58	localObject22	Object
    //   333	3320	59	localObject23	Object
    //   357	3346	60	localObject24	Object
    //   237	3596	61	localObject25	Object
    //   240	1594	62	localObject26	Object
    //   243	981	63	localObject27	Object
    //   215	805	64	localObject28	Object
    //   218	825	65	localObject29	Object
    //   221	845	66	localObject30	Object
    //   224	865	67	localObject31	Object
    //   201	677	68	localObject32	Object
    //   204	698	69	localObject33	Object
    //   207	719	70	localObject34	Object
    //   210	740	71	localObject35	Object
    //   128	2741	72	str1	String
    //   685	2314	73	str2	String
    //   832	2298	74	str3	String
    //   391	1003	75	localDocument	Document
    // Exception table:
    //   from	to	target	type
    //   367	393	3412	javax/xml/parsers/ParserConfigurationException
    //   512	540	3412	javax/xml/parsers/ParserConfigurationException
    //   659	687	3412	javax/xml/parsers/ParserConfigurationException
    //   806	834	3412	javax/xml/parsers/ParserConfigurationException
    //   953	980	3412	javax/xml/parsers/ParserConfigurationException
    //   367	393	3475	java/lang/NumberFormatException
    //   512	540	3475	java/lang/NumberFormatException
    //   659	687	3475	java/lang/NumberFormatException
    //   806	834	3475	java/lang/NumberFormatException
    //   953	980	3475	java/lang/NumberFormatException
    //   1095	1123	3475	java/lang/NumberFormatException
    //   1238	1266	3475	java/lang/NumberFormatException
    //   1393	1405	3475	java/lang/NumberFormatException
    //   1545	1555	3475	java/lang/NumberFormatException
    //   1682	1697	3475	java/lang/NumberFormatException
    //   1833	1842	3475	java/lang/NumberFormatException
    //   1984	1992	3475	java/lang/NumberFormatException
    //   2134	2142	3475	java/lang/NumberFormatException
    //   2284	2292	3475	java/lang/NumberFormatException
    //   2434	2442	3475	java/lang/NumberFormatException
    //   2584	2591	3475	java/lang/NumberFormatException
    //   2733	2741	3475	java/lang/NumberFormatException
    //   2868	2877	3475	java/lang/NumberFormatException
    //   2998	3008	3475	java/lang/NumberFormatException
    //   3129	3139	3475	java/lang/NumberFormatException
    //   367	393	3525	java/io/UnsupportedEncodingException
    //   512	540	3525	java/io/UnsupportedEncodingException
    //   659	687	3525	java/io/UnsupportedEncodingException
    //   806	834	3525	java/io/UnsupportedEncodingException
    //   953	980	3525	java/io/UnsupportedEncodingException
    //   1095	1123	3525	java/io/UnsupportedEncodingException
    //   1238	1266	3525	java/io/UnsupportedEncodingException
    //   1393	1405	3525	java/io/UnsupportedEncodingException
    //   1545	1555	3525	java/io/UnsupportedEncodingException
    //   1682	1697	3525	java/io/UnsupportedEncodingException
    //   1833	1842	3525	java/io/UnsupportedEncodingException
    //   1984	1992	3525	java/io/UnsupportedEncodingException
    //   2134	2142	3525	java/io/UnsupportedEncodingException
    //   2284	2292	3525	java/io/UnsupportedEncodingException
    //   2434	2442	3525	java/io/UnsupportedEncodingException
    //   2584	2591	3525	java/io/UnsupportedEncodingException
    //   2733	2741	3525	java/io/UnsupportedEncodingException
    //   2868	2877	3525	java/io/UnsupportedEncodingException
    //   2998	3008	3525	java/io/UnsupportedEncodingException
    //   3129	3139	3525	java/io/UnsupportedEncodingException
    //   367	393	3575	java/io/IOException
    //   512	540	3575	java/io/IOException
    //   659	687	3575	java/io/IOException
    //   806	834	3575	java/io/IOException
    //   953	980	3575	java/io/IOException
    //   1095	1123	3575	java/io/IOException
    //   1238	1266	3575	java/io/IOException
    //   1393	1405	3575	java/io/IOException
    //   1545	1555	3575	java/io/IOException
    //   1682	1697	3575	java/io/IOException
    //   1833	1842	3575	java/io/IOException
    //   1984	1992	3575	java/io/IOException
    //   2134	2142	3575	java/io/IOException
    //   2284	2292	3575	java/io/IOException
    //   2434	2442	3575	java/io/IOException
    //   2584	2591	3575	java/io/IOException
    //   2733	2741	3575	java/io/IOException
    //   2868	2877	3575	java/io/IOException
    //   2998	3008	3575	java/io/IOException
    //   3129	3139	3575	java/io/IOException
    //   367	393	3625	org/xml/sax/SAXException
    //   512	540	3625	org/xml/sax/SAXException
    //   659	687	3625	org/xml/sax/SAXException
    //   806	834	3625	org/xml/sax/SAXException
    //   953	980	3625	org/xml/sax/SAXException
    //   1095	1123	3625	org/xml/sax/SAXException
    //   1238	1266	3625	org/xml/sax/SAXException
    //   1393	1405	3625	org/xml/sax/SAXException
    //   1545	1555	3625	org/xml/sax/SAXException
    //   1682	1697	3625	org/xml/sax/SAXException
    //   1833	1842	3625	org/xml/sax/SAXException
    //   1984	1992	3625	org/xml/sax/SAXException
    //   2134	2142	3625	org/xml/sax/SAXException
    //   2284	2292	3625	org/xml/sax/SAXException
    //   2434	2442	3625	org/xml/sax/SAXException
    //   2584	2591	3625	org/xml/sax/SAXException
    //   2733	2741	3625	org/xml/sax/SAXException
    //   2868	2877	3625	org/xml/sax/SAXException
    //   2998	3008	3625	org/xml/sax/SAXException
    //   3129	3139	3625	org/xml/sax/SAXException
    //   367	393	3675	java/lang/NullPointerException
    //   512	540	3675	java/lang/NullPointerException
    //   659	687	3675	java/lang/NullPointerException
    //   806	834	3675	java/lang/NullPointerException
    //   953	980	3675	java/lang/NullPointerException
    //   1095	1123	3675	java/lang/NullPointerException
    //   1238	1266	3675	java/lang/NullPointerException
    //   1393	1405	3675	java/lang/NullPointerException
    //   1545	1555	3675	java/lang/NullPointerException
    //   1682	1697	3675	java/lang/NullPointerException
    //   1833	1842	3675	java/lang/NullPointerException
    //   1984	1992	3675	java/lang/NullPointerException
    //   2134	2142	3675	java/lang/NullPointerException
    //   2284	2292	3675	java/lang/NullPointerException
    //   2434	2442	3675	java/lang/NullPointerException
    //   2584	2591	3675	java/lang/NullPointerException
    //   2733	2741	3675	java/lang/NullPointerException
    //   2868	2877	3675	java/lang/NullPointerException
    //   2998	3008	3675	java/lang/NullPointerException
    //   3129	3139	3675	java/lang/NullPointerException
    //   1095	1123	3764	javax/xml/parsers/ParserConfigurationException
    //   1238	1266	3786	javax/xml/parsers/ParserConfigurationException
    //   1393	1405	3813	javax/xml/parsers/ParserConfigurationException
    //   1545	1555	3813	javax/xml/parsers/ParserConfigurationException
    //   1682	1697	3813	javax/xml/parsers/ParserConfigurationException
    //   1833	1842	3813	javax/xml/parsers/ParserConfigurationException
    //   1984	1992	3813	javax/xml/parsers/ParserConfigurationException
    //   2134	2142	3813	javax/xml/parsers/ParserConfigurationException
    //   2284	2292	3813	javax/xml/parsers/ParserConfigurationException
    //   2434	2442	3813	javax/xml/parsers/ParserConfigurationException
    //   2584	2591	3813	javax/xml/parsers/ParserConfigurationException
    //   2733	2741	3813	javax/xml/parsers/ParserConfigurationException
    //   2868	2877	3813	javax/xml/parsers/ParserConfigurationException
    //   2998	3008	3813	javax/xml/parsers/ParserConfigurationException
    //   3129	3139	3813	javax/xml/parsers/ParserConfigurationException
  }
  
  private void aD(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int n = paramConfig.version.get();
    int i = SharedPreUtils.ax(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int j = SharedPreUtils.ay(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int k = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, String.format("received TimUserSpecial remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      SharedPreUtils.S(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), k);
      i = 0;
    }
    Object localObject;
    int m;
    ConfigurationService.Config localConfig;
    String str;
    if (n != i)
    {
      localObject = a(paramConfig);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label428;
      }
      m = 0;
      j = 0;
      localConfig = null;
      paramConfig = null;
      str = null;
    }
    for (;;)
    {
      boolean bool;
      try
      {
        localObject = new JSONObject((String)((List)localObject).get(0));
        if (!((JSONObject)localObject).has("TIMPersonality")) {
          break label472;
        }
        localObject = ((JSONObject)localObject).getJSONObject("TIMPersonality");
        if (!((JSONObject)localObject).has("aioTitleBgSwitch")) {
          break label467;
        }
        j = ((JSONObject)localObject).getInt("aioTitleBgSwitch");
        i = 1;
        if (((JSONObject)localObject).has("androidResourceURL")) {
          paramConfig = ((JSONObject)localObject).getString("androidResourceURL");
        }
        k = i;
        m = j;
        localConfig = paramConfig;
        if (((JSONObject)localObject).has("androidMD5"))
        {
          str = ((JSONObject)localObject).getString("androidMD5");
          localConfig = paramConfig;
          m = j;
          k = i;
        }
        if ((k != 0) && (!TextUtils.isEmpty(localConfig)) && (!TextUtils.isEmpty(str)))
        {
          paramConfig = TIMUserManager.a().a(paramQQAppInterface);
          localObject = TIMUserManager.a().b(paramQQAppInterface);
          bool = false;
          if ((!paramConfig.equals(localConfig)) || (!((String)localObject).equals(str))) {
            break label478;
          }
          TIMUserManager.a().a(0, m, localConfig, "", str, "", bool, 0);
          SharedPreUtils.b(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), n, 0, m, localConfig, str, "", "", bool, 0);
        }
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 256 exception =" + paramQQAppInterface.toString());
        return;
      }
      label428:
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 256,configStrList is empty ,version: " + paramConfig.version.get());
        return;
        label467:
        i = 0;
        continue;
        label472:
        k = 0;
        continue;
        label478:
        bool = true;
      }
    }
  }
  
  private void aE(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i58 = paramConfig.version.get();
    int i = SharedPreUtils.C(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int j = SharedPreUtils.y(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int k = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("handlePokeMsgConfig.received PokeMsgConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i58), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      SharedPreUtils.j(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), k);
      i = 0;
    }
    Object localObject1;
    long l1;
    Object localObject9;
    int i16;
    int i15;
    int i14;
    int i13;
    Object localObject5;
    int i11;
    int i12;
    int i10;
    int i9;
    int i8;
    int i7;
    int i6;
    int i5;
    int i3;
    int i2;
    int i4;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    int i1;
    int n;
    int m;
    int i17;
    int i19;
    label1787:
    Object localObject8;
    if (i58 != i) {
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        localObject1 = paramConfig.content_list.get();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, String.format("handlePokeMsgConfig.receiveAllConfigs|size:%d,content:%s ", new Object[] { Integer.valueOf(paramConfig.content_list.size()), "test" }));
        }
        Iterator localIterator = ((List)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label7121;
        }
        Object localObject10 = (String)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handlePokeMsgConfig.receiveAllConfigs|type: 75,content: " + (String)localObject10 + ",version: " + paramConfig.version.get() + ",configSize = " + paramConfig.content_list.size());
        }
        l1 = -1L;
        localObject9 = "";
        Object localObject6 = "";
        i16 = -1;
        i15 = -1;
        i14 = -1;
        i13 = -1;
        localObject5 = null;
        i11 = 0;
        i12 = 0;
        i10 = 0;
        i9 = 0;
        i8 = 0;
        i7 = 0;
        i6 = 0;
        i5 = 0;
        i3 = 0;
        i2 = 0;
        i4 = 0;
        localObject4 = null;
        localObject3 = null;
        localObject2 = null;
        localObject1 = null;
        i1 = 0;
        n = 0;
        m = 50;
        k = 0;
        j = 0;
        i = 0;
        for (;;)
        {
          try
          {
            String[] arrayOfString = ((String)localObject10).split("\\|");
            if (arrayOfString == null) {
              continue;
            }
            int i59 = arrayOfString.length;
            int i38 = 0;
            m = 0;
            n = 0;
            i1 = 0;
            i2 = 50;
            i = 0;
            j = 0;
            localObject1 = null;
            localObject2 = null;
            localObject3 = null;
            localObject4 = null;
            i14 = 0;
            i15 = 0;
            k = 0;
            i18 = 0;
            i3 = 0;
            i17 = 0;
            i13 = 0;
            i12 = 0;
            i11 = 0;
            i6 = 0;
            i4 = 0;
            localObject10 = null;
            i16 = -1;
            i9 = -1;
            i8 = -1;
            i7 = -1;
            localObject9 = "";
            localObject5 = "";
            l2 = -1L;
            i32 = m;
            i33 = n;
            i21 = i1;
            i23 = i2;
            i26 = i;
            i22 = j;
            localObject6 = localObject1;
            localObject15 = localObject2;
            localObject16 = localObject3;
            localObject12 = localObject4;
            i27 = i14;
            i37 = i15;
            i36 = k;
            i34 = i18;
            i30 = i3;
            i28 = i17;
            i24 = i13;
            i19 = i12;
            i10 = i11;
            i5 = i6;
            i35 = i4;
            localObject17 = localObject10;
            i31 = i16;
            i29 = i9;
            i25 = i8;
            i20 = i7;
            localObject14 = localObject9;
            localObject13 = localObject5;
            l1 = l2;
            if (i38 >= i59) {
              continue;
            }
            str2 = arrayOfString[i38];
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i13;
            i30 = i12;
            i31 = i11;
            i32 = i6;
            i33 = i4;
            localObject16 = localObject10;
            i19 = i16;
            i20 = i9;
            i34 = i8;
            i35 = i7;
            localObject17 = localObject9;
            localObject18 = localObject5;
            l3 = l2;
            try
            {
              if (!str2.contains("aio_pe_view_type")) {
                continue;
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i4;
              localObject16 = localObject10;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l2;
              localObject6 = str2.split("=")[1].trim();
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i4;
              localObject16 = localObject10;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l2;
              bool = TextUtils.isEmpty((CharSequence)localObject6);
              i39 = m;
              i40 = n;
              i41 = i1;
              i42 = i2;
              i36 = i;
              i37 = j;
              localObject19 = localObject1;
              localObject20 = localObject2;
              localObject21 = localObject3;
              localObject22 = localObject4;
              i43 = i14;
              i44 = i15;
              i45 = k;
              i46 = i18;
              i47 = i3;
              i48 = i17;
              i49 = i13;
              i50 = i12;
              i51 = i11;
              i52 = i6;
              i53 = i4;
              localObject23 = localObject10;
              i54 = i16;
              i55 = i9;
              i56 = i8;
              i57 = i7;
              localObject24 = localObject9;
              localObject25 = localObject5;
              l4 = l2;
              if (!bool) {}
              try
              {
                i40 = Integer.parseInt((String)localObject6);
                l4 = l2;
                localObject25 = localObject5;
                localObject24 = localObject9;
                i57 = i7;
                i56 = i8;
                i55 = i9;
                i54 = i16;
                localObject23 = localObject10;
                i53 = i4;
                i52 = i6;
                i51 = i11;
                i50 = i12;
                i49 = i13;
                i48 = i17;
                i47 = i3;
                i46 = i18;
                i45 = k;
                i44 = i15;
                i43 = i14;
                localObject22 = localObject4;
                localObject21 = localObject3;
                localObject20 = localObject2;
                localObject19 = localObject1;
                i37 = j;
                i36 = i;
                i42 = i2;
                i41 = i1;
                i39 = m;
              }
              catch (Exception localException1)
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i6;
                i33 = i4;
                localObject16 = localObject10;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject5;
                l3 = l2;
                localException1.printStackTrace();
                i39 = m;
                i40 = n;
                i41 = i1;
                i42 = i2;
                i36 = i;
                i37 = j;
                localObject19 = localObject1;
                localObject20 = localObject2;
                localObject21 = localObject3;
                localObject22 = localObject4;
                i43 = i14;
                i44 = i15;
                i45 = k;
                i46 = i18;
                i47 = i3;
                i48 = i17;
                i49 = i13;
                i50 = i12;
                i51 = i11;
                i52 = i6;
                i53 = i4;
                localObject23 = localObject10;
                i54 = i16;
                i55 = i9;
                i56 = i8;
                i57 = i7;
                localObject24 = localObject9;
                localObject25 = localObject5;
                l4 = l2;
                continue;
              }
              i38 += 1;
              m = i39;
              n = i40;
              i1 = i41;
              i2 = i42;
              i = i36;
              j = i37;
              localObject1 = localObject19;
              localObject2 = localObject20;
              localObject3 = localObject21;
              localObject4 = localObject22;
              i14 = i43;
              i15 = i44;
              k = i45;
              i18 = i46;
              i3 = i47;
              i17 = i48;
              i13 = i49;
              i12 = i50;
              i11 = i51;
              i6 = i52;
              i4 = i53;
              localObject10 = localObject23;
              i16 = i54;
              i9 = i55;
              i8 = i56;
              i7 = i57;
              localObject9 = localObject24;
              localObject5 = localObject25;
              l2 = l4;
            }
            catch (Exception localException4)
            {
              l1 = l3;
              localObject9 = localObject18;
              localObject7 = localObject17;
              i16 = i35;
              i15 = i34;
              i14 = i20;
              i13 = i19;
              localObject5 = localObject16;
              i11 = i33;
              i12 = i32;
              i10 = i31;
              i9 = i30;
              i8 = i29;
              i7 = i28;
              i6 = i27;
              i5 = i26;
              i3 = i25;
              i4 = i23;
              localObject4 = localObject15;
              localObject3 = localObject14;
              localObject2 = localObject13;
              localObject1 = localObject12;
              i = i2;
              k = i1;
              j = n;
              i17 = m;
              i2 = i24;
              i1 = i22;
              n = i21;
              m = i;
              i = i17;
            }
          }
          catch (Exception localException5)
          {
            int i18;
            long l2;
            int i32;
            int i33;
            int i21;
            int i23;
            int i26;
            int i22;
            Object localObject15;
            Object localObject16;
            Object localObject12;
            int i27;
            int i37;
            int i36;
            int i34;
            int i30;
            int i28;
            int i24;
            int i35;
            Object localObject17;
            int i31;
            int i29;
            int i25;
            int i20;
            Object localObject14;
            Object localObject13;
            String str2;
            Object localObject18;
            long l3;
            boolean bool;
            int i39;
            int i40;
            int i41;
            int i42;
            Object localObject19;
            Object localObject20;
            Object localObject21;
            Object localObject22;
            int i43;
            int i44;
            int i45;
            int i46;
            int i47;
            int i48;
            int i49;
            int i50;
            int i51;
            int i52;
            int i53;
            Object localObject23;
            int i54;
            int i55;
            int i56;
            int i57;
            Object localObject24;
            Object localObject25;
            long l4;
            Object localObject7;
            Object localObject11;
            continue;
            continue;
            continue;
            continue;
          }
          localException4.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("PokeMsg", 2, "PokeMsgConfig parse erro.fight " + localException4.getMessage());
          }
          i19 = i9;
          i37 = i2;
          localObject11 = localObject1;
          i2 = i1;
          i9 = n;
          localObject12 = localObject2;
          localObject2 = localObject9;
          localObject1 = localObject7;
          i20 = i16;
          i25 = i15;
          i29 = i14;
          localObject17 = localObject5;
          i35 = i11;
          i24 = i8;
          i34 = i5;
          i36 = i3;
          i1 = j;
          n = m;
          m = i9;
          j = i2;
          localObject7 = localObject11;
          localObject5 = localObject12;
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PokeEmo", 2, String.format("PokeEmoConfig.got.the value is %s,%s,%s,%s", new Object[] { localObject4, localObject3, localObject5, localObject7 }));
            }
            localObject9 = PokeItemHelper.a(paramQQAppInterface, 5);
            localObject11 = PokeItemHelper.a(paramQQAppInterface, 6);
            if ((localObject4 == null) || (!((String)localObject4).equals(localObject9)) || (localObject3 == null) || (!((String)localObject3).equals(localObject11)))
            {
              PokeItemHelper.jdField_b_of_type_Boolean = false;
              PokeItemHelper.c = false;
              SharedPreUtils.a(false);
              PokeItemHelper.a(paramQQAppInterface, (String)localObject4, (String)localObject3, PokeItemHelper.d);
            }
            SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), k, (String)localObject4, (String)localObject3, (String)localObject5, (String)localObject7, j, m, n, i1);
            PokeItemHelper.a(paramQQAppInterface, k, (String)localObject4, (String)localObject3, (String)localObject5, (String)localObject7, j, n, i1);
            PokeItemHelper.b(m);
          }
          if ((i10 != 0) && (i19 != 0) && (i24 != 0) && (i7 != 0) && (i6 != 0))
          {
            paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("chat_tool_poke_clicked", false).commit();
            PokeItemHelper.b(paramQQAppInterface, false);
            PokeItemHelper.a(paramQQAppInterface, false);
            PokeItemHelper.a(i20, i25, i29, i13);
            SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i58, true, i20, i25, i29, i13);
            PokeItemHelper.a(localObject17);
            SharedPreUtils.b(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i58, localObject17);
            PokeItemHelper.a(i37);
            SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i58, i37);
            PokeItemHelper.c(i4);
            SharedPreUtils.b(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i58, i4);
            PokeItemHelper.a(i34, i36);
            SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i58, i34, i36);
          }
          if ((i35 != 0) && (i12 != 0) && (i12 != 0))
          {
            localObject3 = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).getString(paramQQAppInterface.getAccount() + "_" + "aio_poke_res_url", "");
            SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i58, l1, (String)localObject2, (String)localObject1);
            if ((localObject2 != null) && (!((String)localObject2).equals(localObject3))) {
              ((PokeBigResHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER)).a(true);
            }
          }
          PokeItemHelper.c(i4);
          break;
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i17;
          i29 = i13;
          i30 = i12;
          i31 = i11;
          i32 = i6;
          i33 = i4;
          localObject16 = localObject11;
          i19 = i16;
          i20 = i9;
          i34 = i8;
          i35 = i7;
          localObject17 = localObject9;
          localObject18 = localObject5;
          l3 = l2;
          if (str2.contains("aio_entry_type"))
          {
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i13;
            i30 = i12;
            i31 = i11;
            i32 = i6;
            i33 = i4;
            localObject16 = localObject11;
            i19 = i16;
            i20 = i9;
            i34 = i8;
            i35 = i7;
            localObject17 = localObject9;
            localObject18 = localObject5;
            l3 = l2;
            localObject7 = str2.split("=")[1].trim();
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i13;
            i30 = i12;
            i31 = i11;
            i32 = i6;
            i33 = i4;
            localObject16 = localObject11;
            i19 = i16;
            i20 = i9;
            i34 = i8;
            i35 = i7;
            localObject17 = localObject9;
            localObject18 = localObject5;
            l3 = l2;
            bool = TextUtils.isEmpty((CharSequence)localObject7);
            i39 = m;
            i40 = n;
            i41 = i1;
            i42 = i2;
            i36 = i;
            i37 = j;
            localObject19 = localObject1;
            localObject20 = localObject2;
            localObject21 = localObject3;
            localObject22 = localObject4;
            i43 = i14;
            i44 = i15;
            i45 = k;
            i46 = i18;
            i47 = i3;
            i48 = i17;
            i49 = i13;
            i50 = i12;
            i51 = i11;
            i52 = i6;
            i53 = i4;
            localObject23 = localObject11;
            i54 = i16;
            i55 = i9;
            i56 = i8;
            i57 = i7;
            localObject24 = localObject9;
            localObject25 = localObject5;
            l4 = l2;
            if (!bool) {
              try
              {
                i41 = Integer.parseInt((String)localObject7);
                i39 = m;
                i40 = n;
                i42 = i2;
                i36 = i;
                i37 = j;
                localObject19 = localObject1;
                localObject20 = localObject2;
                localObject21 = localObject3;
                localObject22 = localObject4;
                i43 = i14;
                i44 = i15;
                i45 = k;
                i46 = i18;
                i47 = i3;
                i48 = i17;
                i49 = i13;
                i50 = i12;
                i51 = i11;
                i52 = i6;
                i53 = i4;
                localObject23 = localObject11;
                i54 = i16;
                i55 = i9;
                i56 = i8;
                i57 = i7;
                localObject24 = localObject9;
                localObject25 = localObject5;
                l4 = l2;
              }
              catch (Exception localException2)
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i6;
                i33 = i4;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject5;
                l3 = l2;
                localException2.printStackTrace();
                i39 = m;
                i40 = n;
                i41 = i1;
                i42 = i2;
                i36 = i;
                i37 = j;
                localObject19 = localObject1;
                localObject20 = localObject2;
                localObject21 = localObject3;
                localObject22 = localObject4;
                i43 = i14;
                i44 = i15;
                i45 = k;
                i46 = i18;
                i47 = i3;
                i48 = i17;
                i49 = i13;
                i50 = i12;
                i51 = i11;
                i52 = i6;
                i53 = i4;
                localObject23 = localObject11;
                i54 = i16;
                i55 = i9;
                i56 = i8;
                i57 = i7;
                localObject24 = localObject9;
                localObject25 = localObject5;
                l4 = l2;
              }
            }
          }
          else
          {
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i13;
            i30 = i12;
            i31 = i11;
            i32 = i6;
            i33 = i4;
            localObject16 = localObject11;
            i19 = i16;
            i20 = i9;
            i34 = i8;
            i35 = i7;
            localObject17 = localObject9;
            localObject18 = localObject5;
            l3 = l2;
            bool = str2.contains("aio_panel_pe");
            if (bool)
            {
              i5 = i;
              i10 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              try
              {
                localObject16 = new JSONObject(str2.split("=")[1]);
                i5 = i;
                i10 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                str1 = ((JSONObject)localObject16).optString("pe_res_url");
                i5 = i;
                i10 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = str1;
                localObject4 = ((JSONObject)localObject16).optString("pe_res_md5");
                i5 = i;
                i10 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject4;
                localObject15 = str1;
                localObject2 = ((JSONObject)localObject16).optString("pe_surprise_indexes");
              }
              catch (Exception localException3)
              {
                try
                {
                  localObject3 = ((JSONObject)localObject16).optString("pe_orders");
                }
                catch (Exception localException9)
                {
                  String str1;
                  localObject3 = localObject8;
                  localObject8 = localException9;
                  continue;
                }
                try
                {
                  localObject1 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
                  localObject2 = localObject1;
                }
                catch (Exception localException10)
                {
                  localObject1 = localObject3;
                  localObject3 = localObject8;
                  localObject8 = localException10;
                  continue;
                }
                try
                {
                  localObject19 = ((String)localObject3).substring(1, ((String)localObject3).length() - 1);
                  i5 = i;
                  i10 = j;
                  localObject12 = localObject19;
                  localObject13 = localObject2;
                  localObject14 = localObject4;
                  localObject15 = str1;
                  i37 = ((JSONObject)localObject16).optInt("aio_pe_input_switch");
                  i5 = i;
                  i10 = i37;
                  localObject12 = localObject19;
                  localObject13 = localObject2;
                  localObject14 = localObject4;
                  localObject15 = str1;
                  i36 = ((JSONObject)localObject16).optInt("aio_pe_feed_back_switch");
                  i5 = i36;
                  i10 = i37;
                  localObject12 = localObject19;
                  localObject13 = localObject2;
                  localObject14 = localObject4;
                  localObject15 = str1;
                  i42 = ((JSONObject)localObject16).optInt("aio_pe_bubble_limit_count");
                  i39 = 1;
                  i40 = n;
                  i41 = i1;
                  localObject20 = localObject2;
                  localObject21 = localObject4;
                  localObject22 = str1;
                  i43 = i14;
                  i44 = i15;
                  i45 = k;
                  i46 = i18;
                  i47 = i3;
                  i48 = i17;
                  i49 = i13;
                  i50 = i12;
                  i51 = i11;
                  i52 = i6;
                  i53 = i4;
                  localObject23 = localObject11;
                  i54 = i16;
                  i55 = i9;
                  i56 = i8;
                  i57 = i7;
                  localObject24 = localObject9;
                  localObject25 = localObject5;
                  l4 = l2;
                }
                catch (Exception localException11)
                {
                  localObject1 = localObject3;
                  localObject3 = localObject8;
                  localObject8 = localException11;
                  continue;
                  i3 = i19;
                  continue;
                  k = i17;
                  continue;
                  i14 = i16;
                  continue;
                }
                localException3 = localException3;
                localObject3 = localObject15;
                localObject4 = localObject14;
                localObject2 = localObject13;
                localObject1 = localObject12;
                j = i10;
                i = i5;
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject4;
              localObject15 = localObject3;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i4;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l2;
              localException3.printStackTrace();
              i39 = m;
              i40 = n;
              i41 = i1;
              i42 = i2;
              i36 = i;
              i37 = j;
              localObject19 = localObject1;
              localObject20 = localObject2;
              localObject21 = localObject4;
              localObject22 = localObject3;
              i43 = i14;
              i44 = i15;
              i45 = k;
              i46 = i18;
              i47 = i3;
              i48 = i17;
              i49 = i13;
              i50 = i12;
              i51 = i11;
              i52 = i6;
              i53 = i4;
              localObject23 = localObject11;
              i54 = i16;
              i55 = i9;
              i56 = i8;
              i57 = i7;
              localObject24 = localObject9;
              localObject25 = localObject5;
              l4 = l2;
            }
            else
            {
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i4;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l2;
              i5 = i4;
              l1 = l2;
              if (str2.contains("aio_poke_strength_rule_interval"))
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i6;
                i33 = i4;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject5;
                l3 = l2;
                l1 = Long.valueOf(str2.split("=")[1].trim()).longValue();
                i5 = 1;
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i5;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l1;
              i4 = i6;
              localObject8 = localObject5;
              if (str2.contains("aio_poke_res_url"))
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i6;
                i33 = i5;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject5;
                l3 = l1;
                localObject8 = str2.split("=")[1].trim();
                i4 = 1;
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i4;
              i33 = i5;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject8;
              l3 = l1;
              localObject5 = localObject9;
              if (str2.contains("aio_poke_res_md5"))
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i4;
                i33 = i5;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject8;
                l3 = l1;
                localObject5 = str2.split("=")[1].trim();
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i4;
              i33 = i5;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject5;
              localObject18 = localObject8;
              l3 = l1;
              i6 = i11;
              i10 = i7;
              if (str2.contains("aio_bar_poke"))
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i4;
                i33 = i5;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject5;
                localObject18 = localObject8;
                l3 = l1;
                i7 = Integer.valueOf(str2.split("=")[1].trim()).intValue();
                i6 = i7;
                if (i7 == 0) {
                  break label7552;
                }
                i6 = i7;
                if (i7 == 1) {
                  break label7552;
                }
                i6 = i7;
                if (i7 == 2) {
                  break label7552;
                }
                i6 = i7;
                if (i7 == 3) {
                  break label7552;
                }
                if (i7 != 4) {
                  break label7592;
                }
                i6 = i7;
                break label7552;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        i21 = i;
        i22 = j;
        localObject12 = localObject1;
        localObject13 = localObject2;
        localObject14 = localObject3;
        localObject15 = localObject4;
        i23 = i14;
        i24 = i15;
        i25 = k;
        i26 = i18;
        i27 = i3;
        i28 = i17;
        i29 = i13;
        i30 = i12;
        i31 = i6;
        i32 = i4;
        i33 = i5;
        localObject16 = localObject11;
        i19 = i16;
        i20 = i9;
        i34 = i8;
        i35 = i10;
        localObject17 = localObject5;
        localObject18 = localObject8;
        l3 = l1;
        i7 = i12;
        i11 = i8;
        if (str2.contains("aio_pad_poke"))
        {
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i17;
          i29 = i13;
          i30 = i12;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i16;
          i20 = i9;
          i34 = i8;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l1;
          i8 = Integer.valueOf(str2.split("=")[1].trim()).intValue();
          i7 = i8;
          if (i8 == 0) {
            break label7562;
          }
          i7 = i8;
          if (i8 == 1) {
            break label7562;
          }
          if (i8 != 2) {
            break label7598;
          }
          i7 = i8;
          break label7562;
        }
        i21 = i;
        i22 = j;
        localObject12 = localObject1;
        localObject13 = localObject2;
        localObject14 = localObject3;
        localObject15 = localObject4;
        i23 = i14;
        i24 = i15;
        i25 = k;
        i26 = i18;
        i27 = i3;
        i28 = i17;
        i29 = i13;
        i30 = i7;
        i31 = i6;
        i32 = i4;
        i33 = i5;
        localObject16 = localObject11;
        i19 = i16;
        i20 = i9;
        i34 = i11;
        i35 = i10;
        localObject17 = localObject5;
        localObject18 = localObject8;
        l3 = l1;
        i8 = i13;
        i12 = i9;
        if (str2.contains("aio_poke_unitcount"))
        {
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i17;
          i29 = i13;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i16;
          i20 = i9;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l1;
          i8 = Integer.valueOf(str2.split("=")[1].trim()).intValue();
          if (i8 > 0) {
            break label7572;
          }
        }
        else
        {
          label5309:
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i17;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i16;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l1;
          i9 = i17;
          i13 = i16;
          if (str2.contains("aio_poke_unittime"))
          {
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i8;
            i30 = i7;
            i31 = i6;
            i32 = i4;
            i33 = i5;
            localObject16 = localObject11;
            i19 = i16;
            i20 = i12;
            i34 = i11;
            i35 = i10;
            localObject17 = localObject5;
            localObject18 = localObject8;
            l3 = l1;
            i9 = Integer.valueOf(str2.split("=")[1].trim()).intValue();
            if (i9 <= 0) {
              break label6818;
            }
            break label7582;
          }
          label5555:
          i39 = m;
          i40 = n;
          i41 = i1;
          i42 = i2;
          i36 = i;
          i37 = j;
          localObject19 = localObject1;
          localObject20 = localObject2;
          localObject21 = localObject3;
          localObject22 = localObject4;
          i43 = i14;
          i44 = i15;
          i45 = k;
          i46 = i18;
          i47 = i3;
          i48 = i9;
          i49 = i8;
          i50 = i7;
          i51 = i6;
          i52 = i4;
          i53 = i5;
          localObject23 = localObject11;
          i54 = i13;
          i55 = i12;
          i56 = i11;
          i57 = i10;
          localObject24 = localObject5;
          localObject25 = localObject8;
          l4 = l1;
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l1;
          if (!str2.contains("aio_panel")) {
            break;
          }
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l1;
          localObject19 = str2.split("=");
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l1;
          localObject9 = PokeItemHelper.a(localObject19[1]);
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject9;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l1;
          i16 = PokeItemHelper.c(localObject19[1]);
        }
        try
        {
          i17 = PokeItemHelper.b(localObject19[1]);
        }
        catch (Exception localException6)
        {
          label6818:
          label7121:
          localObject12 = localObject8;
          localObject8 = localObject5;
          i17 = i10;
          i18 = i11;
          i19 = i12;
          localObject5 = localObject9;
          i11 = i5;
          i12 = i4;
          i10 = i6;
          i20 = i7;
          i7 = i9;
          i6 = i3;
          i5 = i16;
          i4 = i14;
          i3 = j;
          i9 = i;
          j = n;
          i = m;
          i14 = k;
          k = i1;
          m = i2;
          n = i9;
          i1 = i3;
          i2 = i15;
          i3 = i14;
          i9 = i20;
          i14 = i19;
          i15 = i18;
          i16 = i17;
          localObject9 = localObject12;
        }
        try
        {
          i19 = PokeItemHelper.a(localObject19[1]);
          if ((i16 == 1) || (i16 == 2)) {
            break label7545;
          }
          i14 = 0;
          i15 = k;
          if (i14 == 0) {}
        }
        catch (Exception localException7)
        {
          i19 = k;
          i20 = i17;
          localObject12 = localObject8;
          localObject8 = localObject5;
          i17 = i10;
          i15 = i11;
          i18 = i12;
          localObject5 = localObject9;
          i11 = i5;
          i12 = i4;
          i10 = i6;
          i21 = i7;
          i7 = i9;
          i6 = i3;
          i5 = i16;
          i4 = i14;
          i3 = j;
          i9 = i;
          k = i1;
          j = n;
          i = m;
          m = i2;
          n = i9;
          i1 = i3;
          i2 = i20;
          i3 = i19;
          i9 = i21;
          i14 = i18;
          i16 = i17;
          localObject9 = localObject12;
        }
        try
        {
          i15 = PokeItemHelper.d(localObject19[1]);
          k = i15;
          if (k > 0)
          {
            i15 = k;
            if (k <= 6) {}
          }
          else
          {
            i15 = 1;
          }
          if (i17 == 1) {
            break label7538;
          }
          k = 0;
          if (i19 > 0) {
            break label7531;
          }
          i3 = 3;
          i17 = 1;
          i16 = 1;
          i39 = m;
          i40 = n;
          i41 = i1;
          i42 = i2;
          i36 = i;
          i37 = j;
          localObject19 = localObject1;
          localObject20 = localObject2;
          localObject21 = localObject3;
          localObject22 = localObject4;
          i43 = i3;
          i44 = k;
          i45 = i15;
          i46 = i14;
          i47 = i16;
          i48 = i9;
          i49 = i8;
          i50 = i7;
          i51 = i6;
          i52 = i4;
          i53 = i5;
          localObject23 = localObject9;
          i54 = i13;
          i55 = i12;
          i56 = i11;
          i57 = i10;
          localObject24 = localObject5;
          localObject25 = localObject8;
          l4 = l1;
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i3;
          i24 = k;
          i25 = i15;
          i26 = i14;
          i27 = i17;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject9;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l1;
          if (!QLog.isColorLevel()) {
            break;
          }
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i3;
          i24 = k;
          i25 = i15;
          i26 = i14;
          i27 = i17;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject9;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l1;
          QLog.d("pokeMsg", 2, "[parsed value] pokePanelInfo:" + (String)localObject9 + " showUniquePokeFlag:" + i14 + " showUniquePokeType:" + i15 + " touchEffect:" + k + " comboNum:" + i3);
          i39 = m;
          i40 = n;
          i41 = i1;
          i42 = i2;
          i36 = i;
          i37 = j;
          localObject19 = localObject1;
          localObject20 = localObject2;
          localObject21 = localObject3;
          localObject22 = localObject4;
          i43 = i3;
          i44 = k;
          i45 = i15;
          i46 = i14;
          i47 = i16;
          i48 = i9;
          i49 = i8;
          i50 = i7;
          i51 = i6;
          i52 = i4;
          i53 = i5;
          localObject23 = localObject9;
          i54 = i13;
          i55 = i12;
          i56 = i11;
          i57 = i10;
          localObject24 = localObject5;
          localObject25 = localObject8;
          l4 = l1;
        }
        catch (Exception localException8)
        {
          i20 = j;
          i21 = i;
          j = n;
          i = m;
          localObject12 = localObject8;
          localObject8 = localObject5;
          i16 = i10;
          i15 = i11;
          i18 = i12;
          localObject5 = localObject9;
          i11 = i5;
          i12 = i4;
          i10 = i6;
          i22 = i7;
          i7 = i9;
          i6 = i3;
          i5 = i14;
          i3 = k;
          k = i1;
          m = i2;
          n = i21;
          i1 = i20;
          i4 = i19;
          i2 = i17;
          i9 = i22;
          i14 = i18;
          localObject9 = localObject12;
        }
      }
      i21 = i;
      i22 = j;
      localObject12 = localObject1;
      localObject13 = localObject2;
      localObject14 = localObject3;
      localObject15 = localObject4;
      i23 = i14;
      i24 = i15;
      i25 = k;
      i26 = i18;
      i27 = i3;
      i28 = i17;
      i29 = i13;
      i30 = i7;
      i31 = i6;
      i32 = i4;
      i33 = i5;
      localObject16 = localObject11;
      i19 = i16;
      i20 = i8;
      i34 = i11;
      i35 = i10;
      localObject17 = localObject5;
      localObject18 = localObject8;
      l3 = l1;
      i8 = PokeItemHelper.h;
      break label7572;
      i21 = i;
      i22 = j;
      localObject12 = localObject1;
      localObject13 = localObject2;
      localObject14 = localObject3;
      localObject15 = localObject4;
      i23 = i14;
      i24 = i15;
      i25 = k;
      i26 = i18;
      i27 = i3;
      i28 = i17;
      i29 = i8;
      i30 = i7;
      i31 = i6;
      i32 = i4;
      i33 = i5;
      localObject16 = localObject11;
      i19 = i9;
      i20 = i12;
      i34 = i11;
      i35 = i10;
      localObject17 = localObject5;
      localObject18 = localObject8;
      l3 = l1;
      i9 = PokeItemHelper.i;
      break label7582;
      i32 = 0;
      i33 = 0;
      i21 = 0;
      i23 = 50;
      i26 = 0;
      i22 = 0;
      localObject8 = null;
      localObject15 = null;
      localObject16 = null;
      localObject12 = null;
      i27 = 0;
      i37 = 0;
      i36 = 0;
      i34 = 0;
      i30 = 0;
      i28 = 0;
      i24 = 0;
      i19 = 0;
      i10 = 0;
      i5 = 0;
      i35 = 0;
      localObject17 = null;
      i31 = -1;
      i29 = -1;
      i25 = -1;
      i20 = -1;
      localObject14 = "";
      localObject13 = "";
      l1 = -1L;
      localObject1 = localObject14;
      localObject2 = localObject13;
      i4 = i27;
      i1 = i33;
      i = i32;
      localObject3 = localObject16;
      m = i26;
      j = i22;
      localObject5 = localObject15;
      n = i23;
      localObject4 = localObject12;
      k = i21;
      i6 = i30;
      i7 = i28;
      i12 = i5;
      i13 = i31;
      break label1787;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 75,content_list is empty ,version: " + paramConfig.version.get());
      }
      return;
      label7531:
      label7538:
      label7545:
      i10 = i6;
      label7552:
      i6 = 1;
    }
    for (;;)
    {
      label7562:
      i11 = i7;
      i7 = 1;
      break;
      label7572:
      i12 = i8;
      i8 = 1;
      break label5309;
      label7582:
      i13 = i9;
      i9 = 1;
      break label5555;
      label7592:
      i6 = 0;
      break label7552;
      label7598:
      i7 = 0;
    }
  }
  
  private void aF(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        i = paramConfig.version.get();
        j = SharedPreUtils.P(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
        if (QLog.isColorLevel()) {
          QLog.d("longText", 2, "received LongTextMsgConfig configVersion:" + i + " ,localVersion:" + j);
        }
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          paramConfig = (String)paramConfig.content_list.get(0);
          if (QLog.isColorLevel()) {
            QLog.d("longText", 2, "received LongTextMsgConfig configContent" + paramConfig);
          }
          if (i == j) {
            break label445;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int i;
        int j;
        int k;
        boolean bool3;
        boolean bool4;
        if (QLog.isColorLevel())
        {
          QLog.e("SPLASH_ConfigServlet", 2, "received LongTextMsgConfig error", paramQQAppInterface);
          return;
          if (i == j)
          {
            if (QLog.isColorLevel()) {
              QLog.d("longText", 2, "received LongTextMsgConfig, content_list is empty, ignored because of SAME VERSION");
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("longText", 2, "received LongTextMsgConfig, content_list is empty, use default config");
            return;
            bool1 = false;
            continue;
            bool2 = true;
            bool1 = false;
            continue;
          }
        }
      }
      try
      {
        if (TextUtils.isEmpty(paramConfig)) {
          continue;
        }
        paramConfig = new JSONObject(paramConfig);
        if (paramConfig == null) {
          continue;
        }
        j = Integer.parseInt(paramConfig.optString("largeMsgOp"));
        if (j != 1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramConfig)
      {
        bool1 = false;
        continue;
      }
      try
      {
        k = Integer.parseInt(paramConfig.optString("msfPullFilter"));
        if (k != 0) {
          continue;
        }
        bool2 = false;
      }
      catch (Exception paramConfig)
      {
        continue;
        bool2 = true;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("longText", 2, "received LongTextMsgConfig, parse content ltValue:" + j + ",ltSwitch:" + bool1 + ",mpfValue:" + k + ",mpfSwitch:" + bool2);
        }
        bool3 = bool1;
        bool4 = bool2;
        paramConfig = (LongTextMsgManager)paramQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER);
        paramConfig.jdField_b_of_type_Boolean = true;
        paramConfig.c = bool3;
        paramQQAppInterface.isMsfPullFilterConfigInited = true;
        paramQQAppInterface.msfPullFilterSwitch = bool4;
        SharedPreUtils.b(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, bool3, bool4);
        return;
      }
      catch (Exception paramConfig)
      {
        continue;
      }
      bool4 = bool2;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("longText", 2, "received LongTextMsgConfig, parse content error!", paramConfig);
        bool4 = bool2;
        bool3 = bool1;
      }
    }
    label445:
  }
  
  private void aG(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      i = paramConfig.version.get();
      localBabyQHandler = (BabyQHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      j = localBabyQHandler.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        paramQQAppInterface = (String)paramConfig.content_list.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig configVersion:" + i + " ,localVersion:" + j + " ,configContent" + paramQQAppInterface);
        }
        if (i != j)
        {
          localBabyQHandler.a(i, paramQQAppInterface);
          return;
        }
        localBabyQHandler.a(false, false);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      int i;
      BabyQHandler localBabyQHandler;
      int j;
      if (QLog.isColorLevel())
      {
        QLog.e("babyqConfig", 2, "received BabyQPlusPanelConfig error", paramQQAppInterface);
        return;
        if (i == j) {
          if (QLog.isColorLevel()) {
            QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig, content_list is empty, ignored because of SAME VERSION");
          }
        }
        for (;;)
        {
          localBabyQHandler.a(false, false);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig, content_list is empty, use default config");
          }
        }
      }
    }
  }
  
  private void aH(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleRespAddContactsViewConfig|type= " + paramConfig.type.get());
    }
    int j = paramConfig.version.get();
    if (j == SharedPreUtils.S(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "AddContactsViewConfig serverVersion is equals to localVersion ");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "AddContactsViewConfig contentlist:" + paramConfig.content_list);
        }
      } while ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0));
      paramConfig = (String)paramConfig.content_list.get(0);
    } while (paramConfig == null);
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    ConfigurationService.Config localConfig = null;
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramConfig.getBytes()), "utf-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramQQAppInterface) {}
      int i = localXmlPullParser.next();
      localConfig = paramConfig;
      break label357;
      String str = localXmlPullParser.getName();
      paramConfig = localConfig;
      if (str != null)
      {
        paramConfig = localConfig;
        if (str.equalsIgnoreCase("entrencelist"))
        {
          paramConfig = localXmlPullParser.nextText();
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "AddContactsView entrencelist:" + localConfig);
          }
          if ((localConfig == null) || (localConfig.length() <= 0)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "success");
          }
          SharedPreUtils.c(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "AddContactsViewConfig appear exception:" + paramQQAppInterface.toString());
          return;
          label357:
          if (i != 1)
          {
            paramConfig = localConfig;
            switch (i)
            {
            }
            paramConfig = localConfig;
          }
        }
      }
    }
  }
  
  private void aI(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ConfigurationService.Config localConfig = null;
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleRespClassicHeadConfig|type= " + paramConfig.type.get());
    }
    int j = paramConfig.version.get();
    if (j == SharedPreUtils.T(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "ClassicHeadConfig serverVersion is equals to localVersion ");
      }
    }
    label81:
    do
    {
      break label81;
      break label81;
      do
      {
        return;
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "ClassicHeadConfig size:" + paramConfig.msg_content_list.size() + "ClassicHeadConfig content:" + paramConfig.msg_content_list.get(0));
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {}
    }
    for (;;)
    {
      XmlPullParser localXmlPullParser;
      int i;
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {
          break label81;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead xmlContent = " + paramConfig);
        }
        localXmlPullParser = Xml.newPullParser();
        try
        {
          localXmlPullParser.setInput(new ByteArrayInputStream(paramConfig.getBytes()), "utf-8");
          i = localXmlPullParser.getEventType();
        }
        catch (Exception paramQQAppInterface) {}
        i = localXmlPullParser.next();
        localConfig = paramConfig;
      }
      catch (Throwable paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "Throwable:" + paramConfig.getMessage());
        }
        paramConfig = null;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "inflateConfigString error!");
      }
      paramConfig = null;
      continue;
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      String str = localXmlPullParser.getName();
      if ((str != null) && (str.equalsIgnoreCase("beginTime")))
      {
        paramConfig = localXmlPullParser.nextText();
      }
      else
      {
        paramConfig = localConfig;
        if (str != null)
        {
          paramConfig = localConfig;
          if (str.equalsIgnoreCase("endTime"))
          {
            paramConfig = localConfig + "|" + localXmlPullParser.nextText();
            continue;
            do
            {
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead entrence:" + localConfig);
              }
              if ((localConfig == null) || (localConfig.length() <= 0)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead getContent success");
              }
              SharedPreUtils.d(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
              paramQQAppInterface = (ClassicHeadActivityManager)paramQQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
              if (paramQQAppInterface == null) {
                break;
              }
              paramQQAppInterface.a();
              return;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("SPLASH_ConfigServlet", 2, "ClassicHeadConfig appear exception:", paramQQAppInterface);
              return;
            } while (i == 1);
            paramConfig = localConfig;
            switch (i)
            {
            }
            paramConfig = localConfig;
          }
        }
      }
    }
  }
  
  private void aJ(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      i = paramConfig.version.get();
      j = SharedPreUtils.D(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label156;
      }
      paramConfig = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("HeadsUp", 2, "received Headsup Notify configVersion:" + i + " ,localVersion:" + j + " ,configContent" + paramConfig);
      }
      if (i == j) {
        return;
      }
      if (!paramConfig.contains("headsup_switch")) {
        break label248;
      }
      bool = paramConfig.split("=")[1].trim().equals("true");
    }
    catch (Exception paramQQAppInterface)
    {
      int i;
      int j;
      boolean bool;
      label156:
      while (QLog.isColorLevel())
      {
        QLog.e("HeadsUp", 2, "received Headsup Notify error", paramQQAppInterface);
        return;
        label248:
        bool = false;
      }
    }
    SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, true, bool);
    return;
    if (i != j)
    {
      SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, false, true);
      paramQQAppInterface.mqqService.jdField_a_of_type_Boolean = false;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("HeadsUp", 2, "received Headsup Notify configVersion:" + i + " ,localVersion:" + j);
      return;
    }
  }
  
  private void aK(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    SearchEntryConfigManager.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    int i = paramConfig.version.get();
    int j = SearchEntryConfigManager.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchNetEntryConfig", 2, "handleSearchNetEntryConfig, version: " + i + " localVersion: " + j);
    }
    if (i == j) {
      return;
    }
    SearchEntryConfigManager.a(paramQQAppInterface.getApp(), i, paramQQAppInterface.getCurrentAccountUin());
    SearchEntryConfigManager.a(paramQQAppInterface.getApp(), paramConfig, paramQQAppInterface.getCurrentUin());
  }
  
  private void aL(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Medal_SPLASH_ConfigServlet", 2, "handleMedalConfig|type= " + paramConfig.type.get());
    }
    int j = paramConfig.version.get();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      Object localObject = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("Medal_SPLASH_ConfigServlet", 2, "content" + (String)localObject);
      }
      if (localObject != null)
      {
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str2 = str5;
        String str1 = str4;
        paramConfig = str3;
        try
        {
          localObject = new JSONObject((String)localObject);
          str2 = str5;
          str1 = str4;
          paramConfig = str3;
          str3 = ((JSONObject)localObject).optString("hosturl", "");
          str2 = str5;
          str1 = str4;
          paramConfig = str3;
          str4 = ((JSONObject)localObject).optString("customurl", "");
          str2 = str5;
          str1 = str4;
          paramConfig = str3;
          str5 = ((JSONObject)localObject).optString("shareurl", "");
          str2 = str5;
          str1 = str4;
          paramConfig = str3;
          int i = ((JSONObject)localObject).optInt("entrance_visibility", 0);
          paramConfig = str3;
          str1 = str4;
          str2 = str5;
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            try
            {
              ((MedalWallMng)paramQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(i, paramConfig, str1, str2);
              SharedPreUtils.u(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin());
              SharedPreUtils.w(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), i);
              return;
            }
            catch (Exception paramQQAppInterface)
            {
              if (!QLog.isColorLevel()) {
                return;
              }
              QLog.e("SPLASH_ConfigServlet", 2, paramQQAppInterface, new Object[0]);
            }
            localException = localException;
            if (QLog.isColorLevel()) {
              QLog.i("SPLASH_ConfigServlet", 2, localException.getMessage(), localException);
            }
            i = 0;
          }
        }
      }
    }
  }
  
  private void aM(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    j = 0;
    int i = 0;
    k = 0;
    m = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    int n = paramConfig.version.get();
    int i1 = SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2);
    if (n != i1)
    {
      if (paramConfig.msg_content_list.size() <= 0) {
        break label391;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {
        break label266;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig content is null !");
      }
      i = 1;
      paramConfig = localObject2;
      j = i;
      k = m;
      if (TextUtils.isEmpty(paramConfig)) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject(paramConfig);
          if (!((JSONObject)localObject1).has("medal_strong_reminder_off")) {
            continue;
          }
          j = ((JSONObject)localObject1).getInt("medal_strong_reminder_off");
          k = j;
          j = i;
        }
        catch (Exception localException)
        {
          label266:
          localException.printStackTrace();
          j = 5;
          k = m;
          continue;
        }
        if (j == 0)
        {
          SharedPreUtils.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, k);
          if (paramQQAppInterface.isCreateManager(QQManagerFactory.MEDAL_WALL_MNG)) {
            ((MedalWallMng)paramQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(k);
          }
        }
        SharedPreUtils.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, n);
        localObject1 = paramConfig;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handleMedalStrongReminderConfig localVersion: %s, version: %s, result: %s, value: %s, strContent: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), localObject1 }));
        }
        return;
        if (paramConfig.compress.get() != 1) {
          continue;
        }
        paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
        if (paramConfig != null) {
          try
          {
            paramConfig = new String(paramConfig, "UTF-8");
            i = 0;
          }
          catch (Throwable paramConfig)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig Throwable:" + paramConfig.getMessage());
            }
            i = 2;
            paramConfig = null;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig inflateConfigString error!");
      }
      i = 3;
      paramConfig = null;
      continue;
      paramConfig = paramConfig.content.get().toStringUtf8();
      break;
      label391:
      i = 4;
      paramConfig = localObject2;
      break;
      i = 6;
      j = 0;
    }
  }
  
  private void aN(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j = 0;
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        int k = paramConfig.version.get();
        int m = ((Integer)SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
        if (k != m)
        {
          if (paramConfig.msg_content_list.size() <= 0) {
            continue;
          }
          paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          if (paramConfig == null)
          {
            if (!QLog.isColorLevel()) {
              break label336;
            }
            QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig content is null !");
            break label336;
            if (i == 0)
            {
              SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, localObject1);
              if (paramQQAppInterface.isCreateManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)) {
                ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a((String)localObject1);
              }
            }
            SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(k));
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label355;
          }
          QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handlePushRecommendShieldConfig localVersion: %s, version: %s, result: %s, strContent: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), localObject1 }));
          return;
        }
        if (paramConfig.compress.get() == 1)
        {
          paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
          if (paramConfig != null)
          {
            try
            {
              paramConfig = new String(paramConfig, "UTF-8");
              i = 0;
            }
            catch (Throwable paramConfig)
            {
              if (!QLog.isColorLevel()) {
                break label356;
              }
            }
            QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig Throwable:" + paramConfig.getMessage());
            break label356;
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break label363;
            }
            QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig inflateConfigString error!");
            break label363;
          }
        }
        else
        {
          paramConfig = paramConfig.content.get().toStringUtf8();
          i = j;
          break label341;
          i = 4;
          paramConfig = localObject2;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      label336:
      i = 1;
      paramConfig = localObject2;
      label341:
      localObject1 = paramConfig;
      if (paramConfig == null)
      {
        localObject1 = "";
        continue;
        label355:
        return;
        label356:
        paramConfig = null;
        i = 2;
        continue;
        label363:
        paramConfig = null;
        i = 3;
      }
    }
  }
  
  private void aO(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject4;
    if (paramConfig.msg_content_list != null)
    {
      localObject1 = localObject3;
      if (paramConfig.msg_content_list.size() > 0)
      {
        localObject4 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          if (((ConfigurationService.Content)localObject4).compress.get() != 1) {
            break label460;
          }
          localObject3 = OlympicUtil.a(((ConfigurationService.Content)localObject4).content.get().toByteArray());
          if (localObject3 == null) {
            break label521;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new String((byte[])localObject3, "UTF-8");
        localObject3 = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4).edit();
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "SVDNAdjustment config : " + (String)localObject1);
            }
            localObject4 = new JSONObject((String)localObject1).getJSONObject("SVDNAdjustment").getJSONArray("configs").getJSONObject(0).getJSONObject("config");
            ((SharedPreferences.Editor)localObject3).putFloat("SVDNAdjustment_data_type", (float)((JSONObject)localObject4).optDouble("data_type", 0.5D));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_max_downmark", ((JSONObject)localObject4).optInt("max_downmark", 2));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_max_upmark", ((JSONObject)localObject4).optInt("max_upmark", 2));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_up_threshold_base", ((JSONObject)localObject4).optInt("up_threshold_base", 11));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_down_threshold_base", ((JSONObject)localObject4).optInt("down_threshold_base", 25));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_quality_up_threshold", ((JSONObject)localObject4).optInt("up_threshold_base", 11));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_quality_down_threshold", ((JSONObject)localObject4).optInt("down_threshold_base", 25));
            ((SharedPreferences.Editor)localObject3).putFloat("SVDNAdjustment_up_threshold_coefficient", (float)((JSONObject)localObject4).optDouble("up_threshold_coefficient", 0.7D));
            ((SharedPreferences.Editor)localObject3).putFloat("SVDNAdjustment_down_threshold_coefficient", (float)((JSONObject)localObject4).optDouble("down_threshold_coefficient", 1.3D));
            ((SharedPreferences.Editor)localObject3).commit();
          }
        }
        catch (Exception localException)
        {
          Object localObject2;
          String str1;
          if (!QLog.isColorLevel()) {
            break label513;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "error: " + localException.toString());
          localException.printStackTrace();
          continue;
        }
        VideoFilterTools.a();
        VideoFilterTools.a((String)localObject1);
        SharedPreUtils.t(paramQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (QLog.isColorLevel()) {
          localUnsupportedEncodingException.printStackTrace();
        }
        localObject2 = null;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          localOutOfMemoryError.printStackTrace();
        }
        System.gc();
        try
        {
          str1 = new String((byte[])localObject3, "UTF-8");
        }
        catch (Throwable localThrowable)
        {
          str2 = null;
        }
        continue;
      }
      label460:
      String str2 = ((ConfigurationService.Content)localObject4).content.get().toStringUtf8();
      continue;
      label513:
      label521:
      str2 = null;
    }
  }
  
  private void aP(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
    int j = paramConfig.version.get();
    QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend, localVersion:" + i + ",serverVersion:" + j);
    if (i != j)
    {
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label231;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig == null) {
        break label221;
      }
      if (paramConfig.compress.get() != 1) {
        break label197;
      }
      paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label241;
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (TextUtils.isEmpty(paramConfig)) {
          break label211;
        }
        ((RecommendTroopManagerImp)paramQQAppInterface.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER)).a(paramConfig, j);
        return;
      }
      catch (Exception paramConfig)
      {
        QLog.e("Q.lebanew", 1, "handleNewTroopRecommend uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      label197:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label211:
      QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend config_content is empty!");
      return;
      label221:
      QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend content is empty!");
      return;
      label231:
      QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend msg_content_list is empty!");
      return;
      label241:
      paramConfig = null;
    }
  }
  
  private void aQ(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = true;
    OCRManager localOCRManager = (OCRManager)paramQQAppInterface.getManager(QQManagerFactory.OCR_MANAGER);
    int i = localOCRManager.a();
    int j = paramConfig.version.get();
    QLog.d("SPLASH_ConfigServlet", 1, "handleGetOCRConfig, version:" + j + ",localVersion:" + i);
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        paramQQAppInterface = localObject2;
        if (paramConfig == null) {
          break label343;
        }
        if (paramConfig.compress.get() == 1)
        {
          paramQQAppInterface = OlympicUtil.a(paramConfig.content.get().toByteArray());
          if (paramQQAppInterface == null) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new String(paramQQAppInterface, "UTF-8");
        paramConfig = OcrConfig.parse(paramQQAppInterface);
        paramQQAppInterface = paramConfig;
        if (paramConfig == null) {
          break label343;
        }
        paramConfig.version = j;
        bool1 = true;
        paramQQAppInterface = paramConfig;
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handleGetOCRConfig, isSucc = " + bool1 + ", ocrConfig = " + paramQQAppInterface);
        }
        localOCRManager.a(bool1, paramQQAppInterface);
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "Throwable:" + paramQQAppInterface.getMessage());
        }
        paramQQAppInterface = null;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "inflateConfigString error!");
      }
      paramQQAppInterface = null;
      continue;
      paramQQAppInterface = paramConfig.content.get().toStringUtf8();
      continue;
      OcrConfig.deleteLocalConfig(jdField_a_of_type_JavaLangString);
      paramQQAppInterface = localObject1;
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "handleGetOCRConfig, msg_content_list is null");
        paramQQAppInterface = localObject1;
        bool1 = bool2;
        continue;
        label343:
        bool1 = false;
        continue;
        bool1 = false;
        paramQQAppInterface = localObject1;
      }
    }
  }
  
  private void aR(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    QLog.i("NCtr", 1, "[handleLimitNotifyConfig]");
    int j = paramConfig.version.get();
    int k = AppSetting.a();
    NotificationController localNotificationController = (NotificationController)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER);
    int i = localNotificationController.b(BaseApplicationImpl.getContext(), paramQQAppInterface.getAccount());
    if (localNotificationController.a(BaseApplicationImpl.getContext(), paramQQAppInterface.getAccount()) != k) {
      i = 0;
    }
    if (j != i)
    {
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label203;
      }
      paramConfig = paramConfig.msg_content_list.get().iterator();
      if (paramConfig.hasNext())
      {
        paramQQAppInterface = (ConfigurationService.Content)paramConfig.next();
        if (paramQQAppInterface.compress.get() != 1) {
          break label189;
        }
        paramQQAppInterface = localNotificationController.a(paramQQAppInterface.content.get().toByteArray());
        if (paramQQAppInterface == null) {
          break label222;
        }
        paramQQAppInterface = new String(paramQQAppInterface);
      }
    }
    for (;;)
    {
      try
      {
        localNotificationController.a(paramQQAppInterface, j, k);
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("NCtr", 1, "[handleLimitNotifyConfig] parse fail", paramQQAppInterface);
      }
      return;
      label189:
      paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
      continue;
      label203:
      QLog.i("NCtr", 1, "[hangleLimitNotifyConfig] config has no data");
      localNotificationController.a(jdField_a_of_type_JavaLangString);
      return;
      label222:
      paramQQAppInterface = null;
    }
  }
  
  /* Error */
  private void aS(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: istore 4
    //   9: aload_1
    //   10: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: aload_1
    //   14: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   17: invokestatic 1900	com/tencent/mobileqq/utils/SharedPreUtils:aV	(Landroid/content/Context;Ljava/lang/String;)I
    //   20: istore_3
    //   21: aload_1
    //   22: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: aload_1
    //   26: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokestatic 1903	com/tencent/mobileqq/utils/SharedPreUtils:aW	(Landroid/content/Context;Ljava/lang/String;)I
    //   32: istore 5
    //   34: invokestatic 1263	com/tencent/common/config/AppSetting:a	()I
    //   37: istore 6
    //   39: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +51 -> 93
    //   45: ldc_w 2875
    //   48: iconst_2
    //   49: ldc_w 2877
    //   52: iconst_4
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: iload 4
    //   60: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: iload_3
    //   67: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: dup
    //   72: iconst_2
    //   73: iload 5
    //   75: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: aastore
    //   79: dup
    //   80: iconst_3
    //   81: iload 6
    //   83: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: aastore
    //   87: invokestatic 534	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   90: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: iload 5
    //   95: iload 6
    //   97: if_icmpeq +18 -> 115
    //   100: aload_1
    //   101: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   104: iload 6
    //   106: aload_1
    //   107: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   110: invokestatic 2879	com/tencent/mobileqq/utils/SharedPreUtils:z	(Landroid/content/Context;ILjava/lang/String;)V
    //   113: iconst_0
    //   114: istore_3
    //   115: iload 4
    //   117: iload_3
    //   118: if_icmpeq +66 -> 184
    //   121: aload_2
    //   122: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   125: ifnull +271 -> 396
    //   128: aload_2
    //   129: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   132: invokevirtual 2880	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   135: ifne +261 -> 396
    //   138: aload_2
    //   139: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   142: iconst_0
    //   143: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   146: checkcast 391	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   149: astore 8
    //   151: aload 8
    //   153: getfield 395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   156: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   159: iconst_1
    //   160: if_icmpne +205 -> 365
    //   163: aload 8
    //   165: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   168: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   171: invokevirtual 413	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   174: invokestatic 418	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   177: astore 8
    //   179: aload 8
    //   181: ifnonnull +4 -> 185
    //   184: return
    //   185: new 126	java/lang/String
    //   188: dup
    //   189: aload 8
    //   191: ldc_w 420
    //   194: invokespecial 423	java/lang/String:<init>	([BLjava/lang/String;)V
    //   197: astore 8
    //   199: new 128	org/json/JSONObject
    //   202: dup
    //   203: aload 8
    //   205: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   208: ldc_w 2882
    //   211: invokevirtual 2885	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   214: istore 7
    //   216: aload_1
    //   217: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   220: ldc_w 2887
    //   223: iconst_4
    //   224: invokevirtual 2390	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   227: invokeinterface 2394 1 0
    //   232: ldc_w 2889
    //   235: iload 7
    //   237: invokeinterface 2402 3 0
    //   242: invokeinterface 2892 1 0
    //   247: aload_1
    //   248: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   251: aload_2
    //   252: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   255: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   258: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   261: invokestatic 2894	com/tencent/mobileqq/utils/SharedPreUtils:y	(Landroid/content/Context;ILjava/lang/String;)V
    //   264: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +30 -> 297
    //   270: ldc 77
    //   272: iconst_2
    //   273: new 79	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 2896
    //   283: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload 7
    //   288: invokevirtual 436	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   291: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq -116 -> 184
    //   303: ldc 77
    //   305: iconst_2
    //   306: new 79	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 2898
    //   316: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload 8
    //   321: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc_w 2900
    //   327: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_2
    //   331: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   334: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   337: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: return
    //   347: astore_1
    //   348: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq -167 -> 184
    //   354: ldc 77
    //   356: iconst_2
    //   357: aload_1
    //   358: invokestatic 2904	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   361: invokestatic 2007	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: return
    //   365: aload 8
    //   367: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   370: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   373: invokevirtual 449	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   376: astore 8
    //   378: goto -179 -> 199
    //   381: astore_1
    //   382: ldc 77
    //   384: iconst_1
    //   385: aload_1
    //   386: iconst_0
    //   387: anewarray 4	java/lang/Object
    //   390: invokestatic 2298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   393: goto -96 -> 297
    //   396: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq +35 -> 434
    //   402: ldc 77
    //   404: iconst_2
    //   405: new 79	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   412: ldc_w 2906
    //   415: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload_2
    //   419: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   422: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   425: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   428: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: aload_1
    //   435: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   438: ldc_w 2887
    //   441: iconst_4
    //   442: invokevirtual 2390	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   445: invokeinterface 2394 1 0
    //   450: astore_1
    //   451: aload_1
    //   452: ldc_w 2887
    //   455: invokeinterface 2910 2 0
    //   460: pop
    //   461: aload_1
    //   462: invokeinterface 2892 1 0
    //   467: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	ConfigServlet
    //   0	468	1	paramQQAppInterface	QQAppInterface
    //   0	468	2	paramConfig	ConfigurationService.Config
    //   20	99	3	i	int
    //   7	112	4	j	int
    //   32	66	5	k	int
    //   37	68	6	m	int
    //   214	73	7	bool	boolean
    //   149	228	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   185	199	347	java/lang/Throwable
    //   199	297	381	org/json/JSONException
  }
  
  private void aT(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = JumpForwardPkgManager.a();
    int j = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|received remote version: " + j + " | localVersion: " + i);
    }
    if (j != i)
    {
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label247;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig == null) {
        break label230;
      }
      if (paramConfig.compress.get() != 1) {
        break label216;
      }
      paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label194;
      }
    }
    label194:
    label216:
    label230:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          paramConfig = new String(paramConfig, "UTF-8");
          JumpForwardPkgManager.a().a(paramQQAppInterface.getApp(), paramConfig, j);
          return;
        }
        catch (Throwable paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|Throwable:" + paramConfig.getMessage());
          }
          paramConfig = "";
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|inflateConfigString error!");
        }
        paramConfig = "";
        continue;
        paramConfig = paramConfig.content.get().toStringUtf8();
      }
    }
    QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]| content==null");
    return;
    label247:
    if (QLog.isColorLevel()) {
      QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]| msg_content_list is empty ,version: " + j + ",localVersion:" + i);
    }
    JumpForwardPkgManager.a().a(j);
  }
  
  private void aU(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.ab(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    QLog.i("SPLASH_ConfigServlet", 1, "handleDevConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    if (i != j)
    {
      SharedPreUtils.z(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramQQAppInterface = a(paramConfig);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {}
      try
      {
        paramQQAppInterface = (String)paramQQAppInterface.get(paramQQAppInterface.size() - 1);
        QLog.d("SPLASH_ConfigServlet", 1, new Object[] { "devConfig is ", paramQQAppInterface });
        SharedPreUtils.l(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("SPLASH_ConfigServlet", 1, new Object[] { "get dev config error : ", paramQQAppInterface.getMessage() });
        return;
      }
    }
    QLog.e("SPLASH_ConfigServlet", 1, "handleDevConfig version is same of local version");
  }
  
  private void aV(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    boolean bool = false;
    int i = paramConfig.version.get();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.getCurrentUin();
    int j = ((Integer)SharedPreUtils.a(localBaseApplication, str, "config_tim_team_version_code", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleTimTeamConfig received Config remote version:" + i + " localVersion= " + j);
    }
    if (i != j)
    {
      paramQQAppInterface = a(paramConfig);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0)) {}
    }
    try
    {
      paramConfig = new JSONObject((String)paramQQAppInterface.get(0));
      paramQQAppInterface = "";
      if (paramConfig.has("isWeb")) {
        bool = paramConfig.getBoolean("isWeb");
      }
      if (paramConfig.has("url")) {
        paramQQAppInterface = paramConfig.getString("url");
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleTimTeamConfig isWeb=" + bool + " url=" + paramQQAppInterface);
      }
      SharedPreUtils.a(localBaseApplication, str, false, "config_tim_team_is_web", Boolean.valueOf(bool));
      SharedPreUtils.a(localBaseApplication, str, false, "config_tim_team_url", paramQQAppInterface);
      SharedPreUtils.a(localBaseApplication, str, true, "config_tim_team_version_code", Integer.valueOf(i));
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.getMessage());
    }
  }
  
  private void aa(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.p(paramQQAppInterface.getApp());
    if (QLog.isColorLevel()) {
      QLog.d("MixMsgForwardConfig", 2, String.format("received MixMsgForwardConfig remote version: %d, localVersion: %d, cmd: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(111) }));
    }
    if (i != j)
    {
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label159;
      }
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 111,content: " + str + ",version: " + paramConfig.version.get());
      }
      SharedPreUtils.m(paramQQAppInterface.getApp(), i, str);
    }
    label159:
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 111,content_list is empty ,version:" + paramConfig.version.get());
  }
  
  private void ab(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            Object localObject = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "receiveAllConfigs|type: 118,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int k = paramConfig.version.get();
            if (k != SharedPreUtils.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString))
            {
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = new JSONArray((String)localObject);
                  int m = ((JSONArray)localObject).length();
                  int j = 0;
                  if (j < m)
                  {
                    JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
                    SharedPreUtils.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("bid"), localJSONObject.optInt("actionType"));
                    j += 1;
                    continue;
                  }
                  if (!QLog.isColorLevel()) {
                    break label341;
                  }
                }
                catch (JSONException localJSONException)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received JSONException ");
                  }
                  SharedPreUtils.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString, k);
                }
              }
            }
            QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received change machine config error,cmd : 118" + paramQQAppInterface.toString());
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "receiveAllConfigs|type: 118,content_list is empty ,version: " + paramConfig.version.get());
      return;
      label341:
      i += 1;
    }
  }
  
  private void ac(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            Object localObject = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, "receiveAllConfigs|type: 142,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if (j == SharedPreUtils.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString)) {
              break label641;
            }
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (bool) {
              break label641;
            }
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject);
              SharedPreUtils.e(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optString("hot_chat_link"));
              SharedPreUtils.v(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("aio_post_tab_plugin"));
              ((TroopRobotManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(localJSONObject);
              ((LbsInfoReportManager)paramQQAppInterface.getManager(QQManagerFactory.LBS_REPORT_MANAGER)).a(localJSONObject);
              SharedPreUtils.u(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("create_troop_max_invite_num"));
              String str1 = localJSONObject.optString("nearby_faceVideo_show");
              String str2 = localJSONObject.optString("nearby_faceVideo_LV");
              String str3 = localJSONObject.optString("nearby_heart_switch");
              SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_enters", 4);
              localSharedPreferences.edit().putString("config_content", (String)localObject).commit();
              localSharedPreferences.edit().putString("nearby_faceVideo_show", str1).commit();
              localSharedPreferences.edit().putString("nearby_heart_switch", str3).commit();
              localSharedPreferences.edit().putString("nearby_faceVideo_LV", str2).commit();
              localObject = localJSONObject.optJSONObject("face_score_enter_config");
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("title"))) {
                localSharedPreferences.edit().putString("face_title", ((JSONObject)localObject).optString("title")).commit();
              }
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("detail_default"))) {
                localSharedPreferences.edit().putString("face_detail_default", ((JSONObject)localObject).optString("detail_default")).commit();
              }
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("jump_url"))) {
                localSharedPreferences.edit().putString("face_jump_url", ((JSONObject)localObject).optString("jump_url")).commit();
              }
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("detail_num"))) {
                localSharedPreferences.edit().putString("face_detail_num", ((JSONObject)localObject).optString("detail_num")).commit();
              }
              SharedPreUtils.D(paramQQAppInterface.getApp(), localJSONObject.optString("group_houseKeeper_switch"));
            }
            catch (JSONException localJSONException)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("SPLASH_ConfigServlet.troop_common_config", 2, "received JSONException ");
              continue;
            }
            SharedPreUtils.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString, j);
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet.troop_common_config", 2, "received change machine config error,cmd : 142" + paramQQAppInterface.toString());
        }
      }
      label641:
      do
      {
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        break;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, "receiveAllConfigs|type: 142,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  private void ad(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            Object localObject = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 201,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if (j != SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString))
            {
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = new JSONObject((String)localObject);
                  SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), (JSONObject)localObject);
                  SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString, j);
                }
                catch (JSONException localJSONException)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received JSONException ");
                  continue;
                }
              }
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received change machine config error,cmd : 201" + paramQQAppInterface.toString());
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        break;
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 201,content_list is empty ,version: " + paramConfig.version.get());
          return;
        }
      }
      i += 1;
    }
  }
  
  private void ae(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("NearbyActivity.nearByTabUrl", 4).edit();
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        int i = 0;
        if (i < paramConfig.content_list.size())
        {
          Object localObject = ((String)paramConfig.content_list.get(i)).trim();
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 129,content: " + (String)localObject + ",version: " + paramConfig.version.get());
          }
          int j = paramConfig.version.get();
          if (j != SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString))
          {
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (!bool) {
              for (;;)
              {
                try
                {
                  localObject = new JSONObject((String)localObject);
                  String str1 = ((JSONObject)localObject).getJSONObject("android").getString("url");
                  String str2 = ((JSONObject)localObject).getJSONObject("android").getString("menuCell_startLive");
                  String str3 = ((JSONObject)localObject).getJSONObject("android").getString("menuCell_personalCenter");
                  String str4 = ((JSONObject)localObject).getJSONObject("android").getString("menuCell_help");
                  localEditor.putString("nearByTabUrl", str1);
                  localEditor.putString("menuCell_startLive", str2);
                  localEditor.putString("menuCell_personalCenter", str3);
                  localEditor.putString("menuCell_help", str4);
                  if (Build.VERSION.SDK_INT >= 9) {
                    continue;
                  }
                  localEditor.commit();
                  if (QLog.isColorLevel()) {
                    QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received NearbyActivity.nearByTabUrl " + ((JSONObject)localObject).getJSONObject("android"));
                  }
                }
                catch (JSONException localJSONException)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received JSONException in get NearbyActivity.nearByTabUrl");
                  continue;
                }
                SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString, j);
                i += 1;
                break;
                localEditor.apply();
              }
            }
          }
        }
        else
        {
          return;
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received change machine config error,cmd : 129" + paramQQAppInterface.toString());
      }
    }
    do
    {
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
      break;
    } while (!QLog.isColorLevel());
    QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 129,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void af(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = SharedPreUtils.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
        if (paramConfig.msg_content_list == null) {
          break label262;
        }
        i = paramConfig.msg_content_list.size();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        NearbyVideoChatManager localNearbyVideoChatManager;
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatConfig error,cmd : 195", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatConfig null");
        return;
        localNearbyVideoChatManager.a("");
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 195,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      localNearbyVideoChatManager = (NearbyVideoChatManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
      if (i > 0)
      {
        paramConfig = b(paramConfig, k, 195);
        localNearbyVideoChatManager.a(paramConfig);
        if (!TextUtils.isEmpty(paramConfig))
        {
          SharedPreUtils.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString, j);
          if (!QLog.isColorLevel()) {
            break label261;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatConfig, content: \n" + paramConfig);
          return;
        }
      }
      label261:
      return;
      label262:
      int i = -1;
    }
  }
  
  private void ag(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
        if (paramConfig.msg_content_list == null) {
          break label241;
        }
        i = paramConfig.msg_content_list.size();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyAuthVideoConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          break label240;
        }
        QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyAuthVideoConfig error,cmd : 227", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          break label240;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyAuthVideoConfig null");
        return;
        if (!QLog.isColorLevel()) {
          break label240;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 227,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      if (i > 0)
      {
        paramConfig = b(paramConfig, k, 227);
        if (!TextUtils.isEmpty(paramConfig))
        {
          NearbyVideoUtils.a(paramConfig);
          SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString, j);
          if (!QLog.isColorLevel()) {
            break label240;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyAuthVideoConfig, content: \n" + paramConfig);
          return;
        }
      }
      label240:
      return;
      label241:
      int i = -1;
    }
  }
  
  private void ah(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
        if (paramConfig.msg_content_list == null) {
          break label251;
        }
        i = paramConfig.msg_content_list.size();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatDialogConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatDialogConfig error,cmd : 268", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatDialogConfig null");
        return;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 268,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      if (i > 0)
      {
        paramConfig = b(paramConfig, k, 268);
        if (!TextUtils.isEmpty(paramConfig))
        {
          ((NearbyVideoChatManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT)).c(paramConfig);
          SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString, j);
          if (!QLog.isColorLevel()) {
            break label250;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatDialogConfig, content: \n" + paramConfig);
          return;
        }
      }
      label250:
      return;
      label251:
      int i = -1;
    }
  }
  
  private void ai(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
        if (paramConfig.msg_content_list == null) {
          break label251;
        }
        i = paramConfig.msg_content_list.size();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatBannerConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatBannerConfig error,cmd : 269", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatBannerConfig null");
        return;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 269,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      if (i > 0)
      {
        paramConfig = b(paramConfig, k, 269);
        if (!TextUtils.isEmpty(paramConfig))
        {
          ((NearbyVideoChatManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT)).b(paramConfig);
          SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString, j);
          if (!QLog.isColorLevel()) {
            break label250;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatBannerConfig, content: \n" + paramConfig);
          return;
        }
      }
      label250:
      return;
      label251:
      int i = -1;
    }
  }
  
  private void aj(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    PtvTemplateManager localPtvTemplateManager = PtvTemplateManager.a(paramQQAppInterface);
    int k = paramConfig.version.get();
    int i = SharedPreUtils.k(paramQQAppInterface.getApp());
    if (!PtvTemplateManager.c()) {
      i = 0;
    }
    int j;
    if (paramConfig.msg_content_list != null)
    {
      j = paramConfig.msg_content_list.size();
      if (QLog.isColorLevel()) {
        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, String.format("个性笔触配置回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      if (k != i) {
        break label106;
      }
    }
    label106:
    do
    {
      do
      {
        return;
        j = -1;
        break;
        if (j <= 0) {
          break label194;
        }
        paramConfig = b(paramConfig, i, 139);
        if (TextUtils.isEmpty(paramConfig)) {
          break label177;
        }
        localPtvTemplateManager.a(paramConfig, paramQQAppInterface);
        SharedPreUtils.i(paramQQAppInterface.getApp(), k);
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServletDoodle_Strokes_", 2, "GetDoodleTemplateConfig|type: 个性笔触配置回包内容, content: \n" + paramConfig);
      return;
    } while (!QLog.isColorLevel());
    label177:
    QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: 个性笔触配置回包内容为空");
    return;
    label194:
    if (QLog.isColorLevel()) {
      QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: 个性笔触配置回包为空");
    }
    localPtvTemplateManager.c();
  }
  
  private void ak(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    QQStoryFollowCaptureResManager localQQStoryFollowCaptureResManager = QQStoryFollowCaptureResManager.a();
    int k = paramConfig.version.get();
    int i = SharedPreUtils.F(paramQQAppInterface.getApp());
    if (!localQQStoryFollowCaptureResManager.a()) {
      i = 0;
    }
    int j;
    if (paramConfig.msg_content_list != null)
    {
      j = paramConfig.msg_content_list.size();
      if (QLog.isColorLevel()) {
        QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, String.format("合拍配置回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      if (k != i) {
        break label107;
      }
    }
    label107:
    do
    {
      do
      {
        return;
        j = -1;
        break;
        if (j <= 0) {
          break label198;
        }
        paramConfig = b(paramConfig, i, 329);
        if (TextUtils.isEmpty(paramConfig)) {
          break label181;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置内容, content: \n" + paramConfig);
        }
      } while (!localQQStoryFollowCaptureResManager.a(paramConfig, paramQQAppInterface));
      SharedPreUtils.u(paramQQAppInterface.getApp(), k);
      return;
    } while (!QLog.isColorLevel());
    label181:
    QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包内容为空");
    return;
    label198:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包为空");
    }
    localQQStoryFollowCaptureResManager.a();
  }
  
  private void al(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int k = paramConfig.version.get();
    String str = paramQQAppInterface.getAccount();
    int i = SharedPreUtils.aR(paramQQAppInterface.getApp(), str);
    if (!CaptureTemplateManager.a()) {
      i = 0;
    }
    int j;
    if (paramConfig.msg_content_list != null)
    {
      j = paramConfig.msg_content_list.size();
      if (QLog.isColorLevel()) {
        QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, String.format("问答Tab配置回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      if (k != i) {
        break label108;
      }
    }
    label108:
    do
    {
      return;
      j = -1;
      break;
      if (j <= 0) {
        break label220;
      }
      paramConfig = b(paramConfig, i, 351);
      if (!TextUtils.isEmpty(paramConfig))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置内容, content: \n" + paramConfig);
        }
        SharedPreUtils.ah(paramQQAppInterface.getApp(), str, k);
        new ConfigSimplifier().a(paramConfig, CaptureTemplateManager.a.getAbsolutePath(), "temp_template_zip", new ConfigServlet.7(this));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包内容为空");
    return;
    label220:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包为空");
    }
    CaptureTemplateManager.c();
  }
  
  private void am(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    SharedPreUtils.g(paramQQAppInterface.getApplication(), i, jdField_a_of_type_JavaLangString);
    Object localObject = null;
    paramQQAppInterface = localObject;
    if (paramConfig.content_list != null)
    {
      paramQQAppInterface = localObject;
      if (paramConfig.content_list.size() > 0) {
        paramQQAppInterface = paramConfig.content_list.get();
      }
    }
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramQQAppInterface = (String)paramQQAppInterface.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 102,content: " + paramQQAppInterface + ",version: " + paramConfig.version.get());
      }
      if (!TextUtils.isEmpty(paramQQAppInterface)) {}
      try
      {
        paramConfig = Xml.newPullParser();
        paramConfig.setInput(new ByteArrayInputStream(paramQQAppInterface.getBytes()), "UTF-8");
        for (i = 0; i != 1; i = paramConfig.next()) {
          if ((i == 2) && (paramConfig.getName().equalsIgnoreCase("JA_Switch"))) {
            JumpActivity.a(paramConfig.nextText(), true);
          }
        }
        while (!QLog.isColorLevel()) {}
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface = paramQQAppInterface;
        paramQQAppInterface.printStackTrace();
        return;
      }
      finally {}
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 102,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void an(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "CMD_PHONE_UNITY_BANNER_CONFIG");
    }
    PhoneUnityManager localPhoneUnityManager = (PhoneUnityManager)paramQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
    i = localPhoneUnityManager.a();
    int m = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "newVersion " + m);
    }
    if (i == m) {
      return;
    }
    localObject1 = null;
    Object localObject2;
    Object localObject6;
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      localObject2 = paramConfig.content_list.get();
      localObject6 = localObject1;
      if (localObject2 != null)
      {
        localObject6 = localObject1;
        if (((List)localObject2).size() > 0)
        {
          localObject1 = (String)((List)localObject2).get(0);
          localObject6 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 34,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
            localObject6 = localObject1;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(localObject6)) {
          continue;
        }
        localPhoneUnityBannerData2 = new PhoneUnityBannerData();
      }
      catch (Throwable localThrowable2)
      {
        PhoneUnityBannerData localPhoneUnityBannerData2;
        XmlPullParser localXmlPullParser;
        int k;
        Object localObject3;
        PhoneUnityBannerData localPhoneUnityBannerData1 = null;
        i = 0;
        paramConfig = null;
        localObject1 = null;
        continue;
        localPhoneUnityBannerData1 = null;
        int j = 0;
        Object localObject4 = null;
        Object localObject5 = null;
        continue;
      }
      try
      {
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(new ByteArrayInputStream(localObject6.getBytes()), "UTF-8");
        i = 0;
        paramConfig = null;
        localObject1 = null;
        k = 0;
        localPhoneUnityBannerData1 = localPhoneUnityBannerData2;
        j = i;
        localObject2 = paramConfig;
        localObject5 = localObject1;
        if (k == 1) {
          continue;
        }
        if (k != 2) {
          continue;
        }
        try
        {
          localObject2 = localXmlPullParser.getName();
          if (!((String)localObject2).equalsIgnoreCase("banner")) {
            continue;
          }
          k = localXmlPullParser.getAttributeCount();
          j = 0;
          if (j >= k) {
            continue;
          }
          localObject2 = localXmlPullParser.getAttributeName(j);
          if ("text".equals(localObject2))
          {
            localPhoneUnityBannerData2.jdField_b_of_type_JavaLangString = localXmlPullParser.getAttributeValue(j);
            j += 1;
            continue;
            localObject6 = localObject1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 34,content_list is empty ,version: " + paramConfig.version.get());
            localObject6 = localObject1;
            continue;
          }
          if (!"url".equals(localObject2)) {
            continue;
          }
          localPhoneUnityBannerData2.jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(j);
          continue;
          QLog.e("PhoneContact.Manager", 1, "", localThrowable1);
        }
        catch (Throwable localThrowable1)
        {
          localPhoneUnityBannerData1 = localPhoneUnityBannerData2;
        }
      }
      catch (Throwable localThrowable3)
      {
        i = 0;
        paramConfig = null;
        localObject1 = null;
        localPhoneUnityBannerData1 = localPhoneUnityBannerData2;
        continue;
        continue;
        continue;
      }
      localObject5 = localObject1;
      localObject3 = paramConfig;
      j = i;
      localPhoneUnityManager.a(m, localObject6, localPhoneUnityBannerData1);
      ((PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(j, localObject5, (String)localObject3);
      return;
      if ("dayNum".equals(localObject3)) {
        localPhoneUnityBannerData2.jdField_a_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("dayIntervalNum".equals(localObject3)) {
        localPhoneUnityBannerData2.jdField_b_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("totalNum".equals(localObject3)) {
        localPhoneUnityBannerData2.c = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("loginNum".equals(localObject3)) {
        localPhoneUnityBannerData2.e = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("banner".equals(localObject3)) {
        localPhoneUnityBannerData2.jdField_a_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(j));
      } else if ("setEntry".equals(localObject3)) {
        localPhoneUnityBannerData2.jdField_b_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(j));
      }
    }
    for (;;)
    {
      try
      {
        k = localXmlPullParser.next();
      }
      catch (Throwable localThrowable4)
      {
        localPhoneUnityBannerData1 = localPhoneUnityBannerData2;
      }
      if (((String)localObject3).equalsIgnoreCase("bindGuideWording"))
      {
        localObject3 = localXmlPullParser.nextText();
        localObject1 = localObject3;
      }
      else if (((String)localObject3).equalsIgnoreCase("bindGuideStyle"))
      {
        j = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        i = j;
      }
      else
      {
        if (!((String)localObject3).equalsIgnoreCase("guideWording")) {
          break label845;
        }
        localObject3 = localXmlPullParser.nextText();
        paramConfig = (ConfigurationService.Config)localObject3;
      }
    }
  }
  
  private void ao(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            String str = (String)paramConfig.content_list.get(i);
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 66,content: " + str + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            int k = SharedPreUtils.A(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD remote version: " + j + " | localVersion: " + k);
            }
            if ((j != k) || (paramConfig.content_list.size() > 0))
            {
              if ((((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).updateSubscriptRecommendConfig(paramQQAppInterface, str)) && (QLog.isColorLevel())) {
                QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD save version: " + j);
              }
              SharedPreUtils.l(paramQQAppInterface.getApplication(), paramQQAppInterface.getAccount(), j);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received subscript recommend config error,cmd : 66");
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 66,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  private void ap(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 43,content: " + str + ",version: " + paramConfig.version.get());
      }
      i = paramConfig.version.get();
      j = SharedPreUtils.F(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        SharedPreUtils.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD save version: " + i);
        }
        a(i, "LocalChannelCity", str, paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD save to database");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 43,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void aq(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      int i = SharedPreUtils.s(paramQQAppInterface.getApp());
      int j = paramConfig.version.get();
      if (i != j)
      {
        ThreadManager.post(new ConfigServlet.9(this, paramQQAppInterface, paramConfig), 8, null, false);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "received HOTCHAT_SCENE_CONFIGS_CMD same version, " + j);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received HOTCHAT_SCENE_CONFIGS_CMD, EXCEPTION" + paramQQAppInterface.toString());
      }
    }
  }
  
  private void ar(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      int i = PatchSharedPreUtil.getPatchConfigVersion(BaseApplicationImpl.sApplication);
      int j = paramConfig.version.get();
      QLog.d("PatchLogTag", 1, "handlePatchConfigCmd server version: " + j + " | localVersion: " + i);
      if (j != i)
      {
        Object localObject = a(paramConfig);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          i = 0;
        }
        while (i < ((List)localObject).size())
        {
          paramConfig = (String)((List)localObject).get(i);
          QLog.d("PatchLogTag", 1, "handlePatchConfigCmd msg_content_list index=" + i + ", content=" + paramConfig);
          PatchConfigManager.a(BaseApplicationImpl.sApplication, paramConfig);
          i += 1;
          continue;
          if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
            i = 0;
          }
          while (i < paramConfig.content_list.size())
          {
            localObject = (String)paramConfig.content_list.get(i);
            QLog.d("PatchLogTag", 1, "handlePatchConfigCmd content_list index=" + i + ", content=" + (String)localObject);
            PatchConfigManager.a(BaseApplicationImpl.sApplication, (String)localObject);
            i += 1;
            continue;
            QLog.d("PatchLogTag", 1, "handlePatchConfigCmd msg_content_list and content_list are empty");
          }
        }
        PatchSharedPreUtil.updatePatchConfigVersion(BaseApplicationImpl.sApplication, j);
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, paramQQAppInterface.getCurrentUin(), "actPatchConfig", 100, "");
      }
      for (;;)
      {
        PatchFileManager.a(paramQQAppInterface);
        if (PatchSharedPreUtil.getPatchConfigVersion(BaseApplicationImpl.sApplication) == j) {
          break;
        }
        PatchSharedPreUtil.updatePatchConfigVersion(BaseApplicationImpl.sApplication, 0);
        return;
        QLog.d("PatchLogTag", 1, "handlePatchConfigCmd not update config as same version");
      }
      return;
    }
    catch (Throwable paramConfig)
    {
      QLog.e("PatchLogTag", 1, "handlePatchConfigCmd throwable=" + paramConfig);
      PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, paramQQAppInterface.getCurrentUin(), "actPatchConfig", 102, "");
    }
  }
  
  private void as(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str1 = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 50,content: " + str1 + ",version: " + paramConfig.version.get());
      }
      i = paramConfig.version.get();
      j = SharedPreUtils.w(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        SharedPreUtils.i(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD save version: " + i);
        }
        localIterator = paramConfig.content_list.get().iterator();
        while (localIterator.hasNext())
        {
          str2 = (String)localIterator.next();
          SearchConfigManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString, str2);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 50,config_content_item: " + str1 + ",version: " + paramConfig.version.get());
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD save to sps");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str1;
      int i;
      int j;
      Iterator localIterator;
      String str2;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 50,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void at(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new ConfigServlet.10(this, paramQQAppInterface, paramConfig));
  }
  
  private void au(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ThreadManager.post(new ConfigServlet.11(this, paramConfig, paramQQAppInterface), 5, null, false);
  }
  
  private void av(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 61,content: " + str + ",version: " + paramConfig.version.get());
      }
      i = paramConfig.version.get();
      j = SharedPreUtils.t(paramQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        SharedPreUtils.m(paramQQAppInterface.getApp(), i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save version: " + i);
        }
        CameraCompatibleList.a(str, true);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save to sps");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 61,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void aw(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      i = paramConfig.version.get();
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 64,content: " + str + ",version: " + paramConfig.version.get());
      }
      if (i != SharedPreUtils.v(paramQQAppInterface.getApp()))
      {
        SharedPreUtils.n(paramQQAppInterface.getApp(), i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SHORTVIDEO_PROGRESSIVE_BLACKLIST_CONFIG save version: " + i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SHORTVIDEO_PROGRESSIVE_BLACKLIST_CONFIG save to sps");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 64,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void ax(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new ConfigServlet.12(this, paramQQAppInterface, paramConfig));
  }
  
  private void ay(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, new Object[] { "handlePrecoverConfig, version=", Integer.valueOf(paramConfig.version.get()), ", type=", Integer.valueOf(paramConfig.type.get()), ", msg_content_list=", paramConfig.msg_content_list.get() });
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0)) {}
    for (List localList = paramConfig.msg_content_list.get();; localList = null)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("handlePrecoverConfig, configList.size=");
        if (localList != null) {
          break label250;
        }
      }
      label250:
      for (Object localObject = "null";; localObject = Integer.valueOf(localList.size()))
      {
        QLog.d("SPLASH_ConfigServlet", 2, localObject);
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        while (i < localList.size())
        {
          localObject = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
          if (localObject != null)
          {
            int j = ((ConfigurationService.Content)localObject).task_id.get();
            localObject = PrecoverUtils.a((ConfigurationService.Content)localObject);
            if (localObject != null) {
              localArrayList.add(new Pair(Integer.valueOf(j), localObject));
            }
          }
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handlePrecoverConfig, configList is empty");
      }
      PrecoverUtils.a(paramQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
      paramQQAppInterface = (PrecoverManager)paramQQAppInterface.getManager(QQManagerFactory.PRECOVER_MANAGER);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a(localArrayList);
        paramQQAppInterface.a();
        paramQQAppInterface.a(true);
      }
      return;
    }
  }
  
  private void az(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.B(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    if (QLog.isColorLevel()) {
      QLog.d("msgFold", 2, "received RedBagFoldMsgConfig remote version: " + i + " | localVersion: " + j);
    }
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      String str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 69,content: " + str + ",version: " + paramConfig.version.get());
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, "received RedBagFoldMsgConfig content: " + str);
      }
      if (i != j) {
        PasswdRedBagManager.a(paramQQAppInterface, i, str);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 69,content_list is empty ,version: " + paramConfig.version.get());
      }
      if (i != j) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("msgFold", 2, "received RedBagFoldMsgConfig, content_list is empty, ignored because of SAME VERSION");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("msgFold", 2, "received RedBagFoldMsgConfig, content_list is empty, use default config");
    }
    paramConfig = (PasswdRedBagManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    paramConfig.jdField_b_of_type_Boolean = true;
    paramConfig.c = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    paramConfig.jdField_a_of_type_Int = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    paramConfig.d = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    paramConfig.e = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, paramConfig.c, paramConfig.jdField_a_of_type_Int, paramConfig.d, paramConfig.e);
  }
  
  private int b(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString)
  {
    ShortVideoResourceManager localShortVideoResourceManager = paramQQAppInterface.getShortVideoResourceManager();
    if ((localShortVideoResourceManager == null) && ("ConfigurationService.ReqGetConfigNoLogin".equals(paramString))) {
      localShortVideoResourceManager = new ShortVideoResourceManager(paramQQAppInterface);
    }
    for (int j = 1;; j = 0)
    {
      int i = ShortVideoResourceManager.a();
      int k = paramConfig.version.get();
      QLog.d("ShortVideoResourceManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|received remote version: " + k + " | localVersion: " + i);
      if (k != i) {
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
        {
          paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramConfig.msg_content_list.size() - 1);
          if (paramConfig != null) {
            if (paramConfig.compress.get() == 1)
            {
              paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
              if (paramConfig == null) {}
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          paramConfig = new String(paramConfig, "UTF-8");
          QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|config_content " + paramConfig);
          if (!"ConfigurationService.ReqGetConfigNoLogin".equals(paramString)) {
            break label300;
          }
          i = localShortVideoResourceManager.a(paramConfig, k);
          if (j != 0) {
            localShortVideoResourceManager.c();
          }
          return i;
        }
        catch (Throwable paramConfig)
        {
          QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|Throwable:" + paramConfig.getMessage());
          paramConfig = "";
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|inflateConfigString error!");
        paramConfig = "";
        continue;
        paramConfig = paramConfig.content.get().toStringUtf8();
        continue;
        label300:
        i = localShortVideoResourceManager.a(paramQQAppInterface.getApp(), paramConfig, k);
        continue;
        QLog.d("ShortVideoResourceManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]| content==null");
        i = -125;
        continue;
        QLog.d("ShortVideoResourceManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]| msg_content_list is empty ,version: " + k + ",localVersion:" + i);
        i = -125;
        continue;
        i = 0;
      }
    }
  }
  
  public static String b(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramConfig.version.get() == paramInt1) {
      return null;
    }
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() == 0))
    {
      QLog.i("SPLASH_ConfigServlet", 1, String.format("handleCompressConfig| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return "";
    }
    if (paramConfig.msg_content_list.size() >= 2) {
      QLog.w("SPLASH_ConfigServlet", 1, "handleCompressConfig, 拉到了多份配置, type[" + paramInt2 + "], size[" + paramConfig.msg_content_list.size() + "]");
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      Object localObject1 = ((ConfigurationService.Content)paramConfig.msg_content_list.get(paramInt1)).content.get().toByteArray();
      if (localObject1 == null)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "handleCompressConfig| config content is null. type=" + paramInt2);
        return null;
      }
      Object localObject2;
      if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
      {
        localObject2 = ArConfigUtils.a((byte[])localObject1);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "handleCompressConfig| decompress is failed. type=" + paramInt2 + ", data=null");
          return null;
        }
      }
      String str;
      try
      {
        localObject2 = new String((byte[])localObject1, "utf-8");
        if (localObject2 == null)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "handleCompressConfig| switch data[] to String failed. type=" + paramInt2 + ", data=" + new String((byte[])localObject1));
          return null;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          str = null;
        }
        localObject1 = String.format("handleCompressConfig| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
        if (!QLog.isColorLevel()) {
          break label432;
        }
      }
      if ((paramConfig.version.get() != 397) && (paramConfig.version.get() != 394)) {
        QLog.i("SPLASH_ConfigServlet", 2, (String)localObject1 + "content=" + str);
      }
      for (;;)
      {
        return str;
        label432:
        QLog.i("SPLASH_ConfigServlet", 1, (String)localObject1);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEOldShortVideoResManager", 2, "getOldShortVideoResourceConfig| getType=" + paramInt);
    }
    AEOldShortVideoResManager.a = System.currentTimeMillis();
    a(paramQQAppInterface, 215, null);
  }
  
  private void b(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    int i = paramConfig.version.get();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.getCurrentUin();
    int j = StickerRecManager.a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "RecommendedSticker received Config remote version:" + i + " localVersion= " + j);
    }
    if (i != j)
    {
      paramConfig = b(paramConfig, j, paramInt);
      if (TextUtils.isEmpty(paramConfig)) {}
    }
    try
    {
      paramConfig = new JSONObject(paramConfig);
      if ((paramConfig.has("useRecommendedSticker")) && (paramConfig.has("maxMatchLength")))
      {
        StickerRecManager.a(paramQQAppInterface, paramConfig.getBoolean("useRecommendedSticker"));
        StickerRecManager.a(localBaseApplication, str, paramConfig.getInt("maxMatchLength"));
      }
      for (;;)
      {
        StickerRecManager.a(paramQQAppInterface, i);
        return;
        StickerRecManager.a(paramQQAppInterface, false);
      }
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        StickerRecManager.a(paramQQAppInterface, false);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, paramConfig.getMessage());
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    QConfigManager.a(new int[] { 34 }, paramString);
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    try
    {
      Object localObject = a(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      if (localObject != null)
      {
        paramString = ((String)localObject).substring(((String)localObject).indexOf("<?xml"), ((String)localObject).indexOf("</msg><msg")) + "</msg>";
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "qav_upgrade_invite msg1 = " + paramString);
        }
        String str = ((String)localObject).substring(((String)localObject).indexOf("<?xml"), ((String)localObject).indexOf("?>")) + "?>";
        localObject = ((String)localObject).substring(((String)localObject).indexOf("</msg><msg"), ((String)localObject).lastIndexOf("</msg>"));
        str = str + ((String)localObject).substring(6) + "</msg>";
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "qav_upgrade_invite msg2 = " + str);
        }
        localObject = SharedPreUtils.b(paramQQAppInterface.getCurrentAccountUin());
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_video", paramString).commit();
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_multi", str).commit();
        SharedPreUtils.h(paramQQAppInterface.getApplication(), paramInt, jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      do
      {
        paramQQAppInterface.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parse qav_upgrade_invite xml  exception : " + paramQQAppInterface.getMessage());
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoResourceManager", 2, "getShortVideoResourceConfig| getType=" + paramInt);
    }
    ShortVideoResourceManager.a = System.currentTimeMillis();
    a(paramQQAppInterface, 718, null);
  }
  
  private void c(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig|type= " + paramConfig.type.get());
    }
    ArResourceManager localArResourceManager = (ArResourceManager)paramQQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    if (paramConfig.type.get() != 88)
    {
      OlympicServlet.a(paramQQAppInterface, 88, 0, 0, 1, 3, 0);
      return;
    }
    int i = paramConfig.version.get();
    int j;
    if (paramIntent.getIntExtra("key_ar_entrance_effect_version", 0) != i) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        j = paramIntent.task_id.get();
        if (paramIntent.compress.get() == 1)
        {
          paramIntent = ArConfigUtils.a(paramIntent.content.get().toByteArray());
          if (paramIntent == null)
          {
            OlympicServlet.a(paramQQAppInterface, 88, i, j, 1, 4, 0);
            if (!QLog.isColorLevel()) {
              break label385;
            }
            QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||deCompress error!");
            paramIntent = null;
          }
        }
      }
    }
    for (;;)
    {
      paramIntent = ArEffectConfig.a(paramIntent);
      if (paramIntent != null)
      {
        paramIntent.jdField_a_of_type_Int = i;
        if (localArResourceManager != null) {
          localArResourceManager.a(paramIntent);
        }
        for (;;)
        {
          for (;;)
          {
            OlympicServlet.a(paramQQAppInterface, 88, i, j, 1, 0, 0);
            return;
            try
            {
              paramIntent = new String(paramIntent, "utf-8");
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              paramConfig = null;
              paramIntent = paramConfig;
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, localUnsupportedEncodingException.getMessage());
          paramIntent = paramConfig;
          break;
          paramIntent = paramIntent.content.get().toStringUtf8();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig|arManager is null ");
          }
        }
      }
      OlympicServlet.a(paramQQAppInterface, 88, i, j, 1, 5, 0);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||parseArEffectConfig error!");
      return;
      if (localArResourceManager != null) {
        localArResourceManager.b();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig || msg_content_list is null");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig || has same version");
      return;
      label385:
      paramIntent = null;
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    QLog.d("SPLASH_ConfigServlet", 1, " call  getServiceAccountFolderConfig ");
    a(paramQQAppInterface, 81, paramString);
  }
  
  private void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    try
    {
      paramString = a(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      if (paramString != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "qav_anychat_time_limit stream = " + paramString);
        }
        SharedPreUtils.d(paramQQAppInterface.getCurrentAccountUin()).edit().putString("qav_anychat_time_value", paramString).commit();
        SharedPreUtils.i(paramQQAppInterface.getApplication(), paramInt, jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      do
      {
        paramQQAppInterface.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parse qav_anychat_time_limit  exception : " + paramQQAppInterface.getMessage());
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig| 2 type= " + paramConfig.type.get());
    ArResourceManager localArResourceManager = (ArResourceManager)paramQQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    if (localArResourceManager == null)
    {
      QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig| manager is null");
      return;
    }
    Object localObject1 = BaseApplicationImpl.getApplication();
    int i;
    int j;
    ArrayList localArrayList;
    try
    {
      i = ((Context)localObject1).getPackageManager().getPackageInfo(((Context)localObject1).getPackageName(), 0).versionCode;
      localArResourceManager.a(i);
      QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig| 3 type= version code is " + i);
      if (paramConfig.type.get() != 87) {
        break label750;
      }
      j = paramConfig.version.get();
      i = paramIntent.getIntExtra("key_config_version", 0);
      if (QLog.isColorLevel()) {
        QLog.d("handleResp_GetArResourceConfig", 2, "handleResp_GetArResource|server-Version is " + j);
      }
      if (i == j) {
        break label728;
      }
      if (paramConfig.msg_content_list == null) {
        break label704;
      }
      int k = paramConfig.msg_content_list.size();
      if (k <= 0) {
        break label704;
      }
      localObject1 = null;
      localArrayList = new ArrayList();
      i = 0;
      if (i < k)
      {
        localObject3 = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
        m = ((ConfigurationService.Content)localObject3).task_id.get();
        localObject2 = ((ConfigurationService.Content)localObject3).content.get().toByteArray();
        paramIntent = (Intent)localObject2;
        if (((ConfigurationService.Content)localObject3).compress.get() == 1) {
          paramIntent = ArConfigUtils.a((byte[])localObject2);
        }
        if (paramIntent == null) {}
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        int m;
        try
        {
          localObject2 = new String(paramIntent, "utf-8");
          localObject3 = ArConfigInfo.parseArConfig((String)localObject2);
          if (localObject3 != null) {
            if (localObject1 == null)
            {
              paramIntent = (Intent)localObject3;
              localArrayList.addAll(((ArConfigInfo)localObject3).mArCloudConfigInfos);
              QLog.i("ArConfig_configServlet", 1, "config loop|| taskid=" + m + ",endtime=" + ((ArConfigInfo)localObject3).aREnd + ",xmlcontent=" + (String)localObject2);
              OlympicServlet.a(paramQQAppInterface, 87, j, m, 1, 0, 0);
              i += 1;
              localObject1 = paramIntent;
              continue;
              localNameNotFoundException = localNameNotFoundException;
              localNameNotFoundException.printStackTrace();
              QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig| 3 type= error happen");
            }
          }
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          Object localObject3;
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, paramIntent.getMessage());
          }
          Object localObject2 = null;
          continue;
          paramIntent = localNameNotFoundException;
          if (localNameNotFoundException.aREnd >= ((ArConfigInfo)localObject3).aREnd) {
            continue;
          }
          paramIntent = (Intent)localObject3;
          continue;
          OlympicServlet.a(paramQQAppInterface, 87, j, m, 1, 5, 0);
          paramIntent = localNameNotFoundException;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||parseArConfig error!");
          paramIntent = localNameNotFoundException;
          continue;
        }
        OlympicServlet.a(paramQQAppInterface, 87, j, m, 1, 4, 0);
        paramIntent = localNameNotFoundException;
        if (QLog.isColorLevel())
        {
          QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||deCompress error!");
          paramIntent = localNameNotFoundException;
        }
      }
    }
    if (localNameNotFoundException != null)
    {
      localNameNotFoundException.mArCloudConfigInfos = localArrayList;
      localNameNotFoundException.version = 2;
      localArResourceManager.b(j);
      localArResourceManager.a(localNameNotFoundException);
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "maxEndTimeArConfigInfo|| maxEndtime=" + localNameNotFoundException.aREnd);
      }
      OlympicServlet.a(paramQQAppInterface, 87, j, 0, 0, 0, 0);
    }
    for (;;)
    {
      i = 0;
      label645:
      if ((i == 0) || (localArResourceManager == null)) {
        break;
      }
      QLog.d("ArConfig_configServlet", 1, "arManager.downloadArResource");
      localArResourceManager.a(true, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource|combineArConfigInfo is null");
      }
      OlympicServlet.a(paramQQAppInterface, 87, j, 0, 0, 5, 0);
      continue;
      label704:
      localArResourceManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||msg_content_list is null!");
      }
    }
    label728:
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource || has same version");
    }
    for (;;)
    {
      i = 1;
      break label645;
      break;
      label750:
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource || fail");
      OlympicServlet.a(paramQQAppInterface, 87, 0, 0, 1, 3, 0);
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.R(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      SharedPreUtils.s(BaseApplication.getContext(), i, jdField_a_of_type_JavaLangString);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        HotReactiveHelper.a(paramQQAppInterface, (String)paramConfig.get(0));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig:localVersiont == version ");
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, 43, paramString);
  }
  
  private void d(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int i;
    long l1;
    Object localObject1;
    Object localObject2;
    int k;
    Object localObject3;
    Object localObject4;
    long l2;
    long l3;
    Object localObject5;
    int j;
    try
    {
      Document localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      NodeList localNodeList = localDocument.getElementsByTagName("pushbanner");
      paramString = "";
      i = 0;
      if (i < localNodeList.getLength())
      {
        l1 = Long.parseLong(localDocument.getElementsByTagName("channel").item(i).getFirstChild().getNodeValue());
        localObject1 = localDocument.getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
        localObject2 = localDocument.getElementsByTagName("digest").item(i).getFirstChild().getNodeValue();
        k = Integer.parseInt(localDocument.getElementsByTagName("weight").item(i).getFirstChild().getNodeValue());
        localObject3 = localDocument.getElementsByTagName("md5").item(i).getFirstChild();
        if (localObject3 != null) {
          paramString = ((Node)localObject3).getNodeValue();
        }
        localObject3 = localDocument.getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
        localObject4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        l2 = ((SimpleDateFormat)localObject4).parse((String)localObject3).getTime();
        l3 = ((SimpleDateFormat)localObject4).parse(localDocument.getElementsByTagName("begin").item(i).getFirstChild().getNodeValue()).getTime();
        if (System.currentTimeMillis() > l2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner is outdate , throw it");
          }
        }
        else
        {
          localObject3 = new StringBuffer();
          paramInt = 0;
          while (paramInt < localDocument.getElementsByTagName("url").item(i).getChildNodes().getLength())
          {
            ((StringBuffer)localObject3).append(localDocument.getElementsByTagName("url").item(i).getChildNodes().item(paramInt).getNodeValue());
            paramInt += 1;
          }
          localObject4 = ((StringBuffer)localObject3).toString();
          localObject3 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
          localObject5 = ((EntityManager)localObject3).query(ExpiredPushBanner.class);
          j = 0;
          paramInt = 0;
          if (localObject5 != null)
          {
            localObject5 = ((List)localObject5).iterator();
            label464:
            j = paramInt;
            if (((Iterator)localObject5).hasNext())
            {
              if (((ExpiredPushBanner)((Iterator)localObject5).next()).cid != l1) {
                break label1050;
              }
              paramInt = 1;
              break label1062;
            }
          }
          if (j != 0)
          {
            if (!QLog.isColorLevel()) {
              break label1053;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner had been close or click , throw it");
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "push exception : " + paramQQAppInterface.getMessage());
      }
    }
    return;
    if (paramString.length() < 15)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner md5 length < 15 .throw");
      }
    }
    else
    {
      localObject5 = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + paramString;
      if (!ConfigParser.a(paramString)) {
        ThreadManager.executeOnNetWorkThread(new ConfigServlet.4(this, (String)localObject1));
      }
      Config.a.a(Config.a.a(l1, (String)localObject2, (byte)3, (String)localObject1, (String)localObject4, (String)localObject5, l3 + "|" + l2, (short)k, paramString));
      paramInt = 1;
      k = 1;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((EntityManager)localObject3).query(ReportedBanner.class, false, null, null, null, null, "endtime DESC", null);
        j = paramInt;
        if (localObject1 != null)
        {
          j = paramInt;
          if (((List)localObject1).size() > 0)
          {
            localObject2 = ((List)localObject1).iterator();
            paramInt = k;
            if (((Iterator)localObject2).hasNext())
            {
              localObject4 = (ReportedBanner)((Iterator)localObject2).next();
              if ((localObject4 == null) || (((ReportedBanner)localObject4).cid != l1)) {
                continue;
              }
              paramInt = 0;
            }
            j = paramInt;
            if (((List)localObject1).size() > 18)
            {
              k = ((List)localObject1).size() - 1;
              j = paramInt;
              if (k >= 9)
              {
                localObject2 = (ReportedBanner)((List)localObject1).get(k);
                if ((localObject2 == null) || (((ReportedBanner)localObject2).cid == l1)) {
                  break label1065;
                }
                ((EntityManager)localObject3).remove((Entity)localObject2);
                break label1065;
              }
            }
          }
        }
        if (j == 0) {
          break label1014;
        }
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X80087C0", "0X80087C0", (int)l1, 0, "", "", "", "");
        localObject1 = new ReportedBanner();
        ((ReportedBanner)localObject1).cid = l1;
        ((ReportedBanner)localObject1).md5 = paramString;
        ((ReportedBanner)localObject1).endtime = l2;
        ((EntityManager)localObject3).persist((Entity)localObject1);
        if (!QLog.isColorLevel()) {
          break label1053;
        }
        QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report cid: %d", new Object[] { Long.valueOf(l1) }));
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          break label1053;
        }
      }
      QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report exception t: %s", new Object[] { localThrowable }));
      break label1053;
      label1014:
      if (QLog.isColorLevel())
      {
        QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report repeat cid: %d", new Object[] { Long.valueOf(l1) }));
        break label1053;
        break label1062;
      }
      label1050:
      label1053:
      i += 1;
      break;
      label1062:
      break label464;
      label1065:
      k -= 1;
    }
  }
  
  private void e(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("handleResp_GetArGlobalConfig", 2, "handleResp_GetArGlobalConfig |  type= " + paramConfig.type.get());
    }
    ARGlobalConfigManager localARGlobalConfigManager = (ARGlobalConfigManager)paramQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    int i;
    if (paramConfig.type.get() == 188)
    {
      i = paramConfig.version.get();
      if (paramIntent.getIntExtra("ar_global_key_config_version", 0) == i) {
        break label357;
      }
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label328;
      }
      paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramQQAppInterface == null) {
        break label309;
      }
      if (paramQQAppInterface.compress.get() != 1) {
        break label295;
      }
      paramIntent = OlympicUtil.a(paramQQAppInterface.content.get().toByteArray());
      if (paramIntent == null) {
        break label376;
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new String(paramIntent, "UTF-8");
        if (paramQQAppInterface != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, config_content is " + paramQQAppInterface);
          }
          i = paramConfig.version.get();
          if (localARGlobalConfigManager.a(paramQQAppInterface))
          {
            localARGlobalConfigManager.a(i);
            localARGlobalConfigManager.a();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, config type 188");
        }
        return;
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          paramQQAppInterface.printStackTrace();
        }
        paramQQAppInterface = null;
        continue;
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          paramQQAppInterface.printStackTrace();
        }
        System.gc();
        try
        {
          paramQQAppInterface = new String(paramIntent, "UTF-8");
        }
        catch (Throwable paramQQAppInterface)
        {
          paramQQAppInterface = null;
        }
        continue;
      }
      label295:
      paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
      continue;
      label309:
      if (QLog.isColorLevel())
      {
        QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, content is null");
        continue;
        label328:
        if (localARGlobalConfigManager != null) {
          localARGlobalConfigManager.b();
        }
        if (QLog.isColorLevel())
        {
          QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "we delete ARConfig info here");
          continue;
          label357:
          if (QLog.isColorLevel())
          {
            QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, version same");
            continue;
            label376:
            paramQQAppInterface = null;
          }
        }
      }
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      NearbyUtils.a("GENERAL_LBS_CONFIGS_CMD", new Object[] { "getGeneralLBSConfigs", paramString, Long.valueOf(l) });
    }
    QConfigManager.a(new int[] { 87, 12, 174, 189 }, paramString);
  }
  
  /* Error */
  private void e(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 636	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: invokevirtual 640	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   6: new 642	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_2
    //   11: ldc_w 644
    //   14: invokevirtual 648	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   17: invokespecial 651	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokevirtual 656	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   23: astore 15
    //   25: aload 15
    //   27: ldc_w 3822
    //   30: invokeinterface 664 2 0
    //   35: astore 16
    //   37: ldc 13
    //   39: astore 13
    //   41: fconst_0
    //   42: fstore 5
    //   44: fconst_0
    //   45: fstore 6
    //   47: iconst_0
    //   48: istore 11
    //   50: ldc 13
    //   52: astore 12
    //   54: fconst_0
    //   55: fstore 7
    //   57: fconst_0
    //   58: fstore 4
    //   60: ldc_w 3824
    //   63: astore_2
    //   64: ldc 13
    //   66: astore 14
    //   68: iconst_0
    //   69: istore 10
    //   71: iload 10
    //   73: aload 16
    //   75: invokeinterface 669 1 0
    //   80: if_icmpge +483 -> 563
    //   83: aload 15
    //   85: ldc_w 2144
    //   88: invokeinterface 664 2 0
    //   93: iload 10
    //   95: invokeinterface 675 2 0
    //   100: invokeinterface 681 1 0
    //   105: invokeinterface 684 1 0
    //   110: astore 14
    //   112: aload 15
    //   114: ldc_w 2150
    //   117: invokeinterface 664 2 0
    //   122: iload 10
    //   124: invokeinterface 675 2 0
    //   129: invokeinterface 681 1 0
    //   134: invokeinterface 684 1 0
    //   139: astore 13
    //   141: aload 15
    //   143: ldc_w 3825
    //   146: invokeinterface 664 2 0
    //   151: iload 10
    //   153: invokeinterface 675 2 0
    //   158: invokeinterface 681 1 0
    //   163: invokeinterface 684 1 0
    //   168: invokestatic 3831	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   171: fstore 5
    //   173: aload 15
    //   175: ldc_w 3832
    //   178: invokeinterface 664 2 0
    //   183: iload 10
    //   185: invokeinterface 675 2 0
    //   190: invokeinterface 681 1 0
    //   195: invokeinterface 684 1 0
    //   200: invokestatic 3831	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   203: fstore 4
    //   205: iconst_1
    //   206: istore 11
    //   208: aload 15
    //   210: ldc_w 3833
    //   213: invokeinterface 664 2 0
    //   218: iload 10
    //   220: invokeinterface 675 2 0
    //   225: invokeinterface 681 1 0
    //   230: invokeinterface 684 1 0
    //   235: invokestatic 3831	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   238: fstore 6
    //   240: aload 15
    //   242: ldc_w 3834
    //   245: invokeinterface 664 2 0
    //   250: iload 10
    //   252: invokeinterface 675 2 0
    //   257: invokeinterface 681 1 0
    //   262: invokeinterface 684 1 0
    //   267: invokestatic 3831	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   270: fstore 9
    //   272: aload 15
    //   274: ldc_w 3836
    //   277: invokeinterface 664 2 0
    //   282: iload 10
    //   284: invokeinterface 675 2 0
    //   289: invokeinterface 681 1 0
    //   294: invokeinterface 684 1 0
    //   299: astore 12
    //   301: aload 15
    //   303: ldc_w 3837
    //   306: invokeinterface 664 2 0
    //   311: iload 10
    //   313: invokeinterface 675 2 0
    //   318: invokeinterface 681 1 0
    //   323: invokeinterface 684 1 0
    //   328: invokestatic 3831	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   331: fstore 8
    //   333: aload 15
    //   335: ldc_w 3833
    //   338: invokeinterface 664 2 0
    //   343: iload 10
    //   345: invokeinterface 675 2 0
    //   350: invokeinterface 681 1 0
    //   355: invokeinterface 684 1 0
    //   360: invokestatic 3831	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   363: fstore 7
    //   365: aload 15
    //   367: ldc_w 3839
    //   370: invokeinterface 664 2 0
    //   375: iload 10
    //   377: invokeinterface 675 2 0
    //   382: invokeinterface 681 1 0
    //   387: invokeinterface 684 1 0
    //   392: astore_2
    //   393: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +298 -> 694
    //   399: ldc 77
    //   401: iconst_2
    //   402: new 79	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   409: ldc_w 3841
    //   412: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload 14
    //   417: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: ldc_w 3843
    //   423: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload 13
    //   428: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc_w 3845
    //   434: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: fload 5
    //   439: invokevirtual 3848	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   442: ldc_w 3850
    //   445: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: fload 4
    //   450: invokevirtual 3848	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   453: ldc_w 3852
    //   456: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: iload 11
    //   461: invokevirtual 436	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   464: ldc_w 3854
    //   467: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: fload 6
    //   472: invokevirtual 3848	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   475: ldc_w 3856
    //   478: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: fload 9
    //   483: invokevirtual 3848	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   486: ldc_w 3858
    //   489: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload 12
    //   494: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: ldc_w 3860
    //   500: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: fload 8
    //   505: invokevirtual 3848	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   508: ldc_w 3862
    //   511: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload_2
    //   515: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: goto +170 -> 694
    //   527: astore_2
    //   528: aload 15
    //   530: ldc_w 3863
    //   533: invokeinterface 664 2 0
    //   538: iload 10
    //   540: invokeinterface 675 2 0
    //   545: invokeinterface 681 1 0
    //   550: invokeinterface 684 1 0
    //   555: invokestatic 3831	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   558: fstore 4
    //   560: goto -352 -> 208
    //   563: aload 14
    //   565: ifnull +126 -> 691
    //   568: aload 14
    //   570: invokevirtual 463	java/lang/String:trim	()Ljava/lang/String;
    //   573: ldc 13
    //   575: invokevirtual 483	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   578: ifne +113 -> 691
    //   581: new 79	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   588: aload_1
    //   589: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   592: invokevirtual 3866	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   595: invokevirtual 2198	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   598: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: ldc_w 2200
    //   604: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   610: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: ldc_w 2200
    //   616: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: ldc_w 3868
    //   622: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: astore 15
    //   630: ldc_w 3870
    //   633: aload 14
    //   635: invokestatic 3875	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   638: astore 14
    //   640: fload 4
    //   642: fstore 8
    //   644: fload 4
    //   646: fconst_0
    //   647: fcmpg
    //   648: ifge +8 -> 656
    //   651: ldc_w 543
    //   654: fstore 8
    //   656: new 3877	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5
    //   659: dup
    //   660: aload_0
    //   661: aload 15
    //   663: aload_1
    //   664: aload 14
    //   666: fload 5
    //   668: fload 6
    //   670: fload 8
    //   672: aload 12
    //   674: aload_2
    //   675: fload 7
    //   677: iload 11
    //   679: iload_3
    //   680: aload 13
    //   682: invokespecial 3880	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:<init>	(Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;FFFLjava/lang/String;Ljava/lang/String;FZILjava/lang/String;)V
    //   685: iconst_2
    //   686: aconst_null
    //   687: iconst_0
    //   688: invokestatic 3342	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   691: return
    //   692: astore_1
    //   693: return
    //   694: iload 10
    //   696: iconst_1
    //   697: iadd
    //   698: istore 10
    //   700: fload 4
    //   702: fstore 6
    //   704: fload 7
    //   706: fstore 4
    //   708: fload 8
    //   710: fstore 7
    //   712: goto -641 -> 71
    //   715: astore_2
    //   716: ldc_w 3824
    //   719: astore_2
    //   720: goto -327 -> 393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	723	0	this	ConfigServlet
    //   0	723	1	paramQQAppInterface	QQAppInterface
    //   0	723	2	paramString	String
    //   0	723	3	paramInt	int
    //   58	649	4	f1	float
    //   42	625	5	f2	float
    //   45	658	6	f3	float
    //   55	656	7	f4	float
    //   331	378	8	f5	float
    //   270	212	9	f6	float
    //   69	630	10	i	int
    //   48	630	11	bool	boolean
    //   52	621	12	str1	String
    //   39	642	13	str2	String
    //   66	599	14	str3	String
    //   23	639	15	localObject	Object
    //   35	39	16	localNodeList	NodeList
    // Exception table:
    //   from	to	target	type
    //   173	205	527	java/lang/Exception
    //   0	37	692	java/lang/Exception
    //   71	173	692	java/lang/Exception
    //   208	365	692	java/lang/Exception
    //   393	524	692	java/lang/Exception
    //   528	560	692	java/lang/Exception
    //   568	640	692	java/lang/Exception
    //   656	691	692	java/lang/Exception
    //   365	393	715	java/lang/Exception
  }
  
  private void f(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = paramIntent.getStringExtra("key_uin");
    if (!TextUtils.isEmpty(paramIntent))
    {
      int i = paramConfig.version.get();
      int j = SharedPreUtils.q(paramQQAppInterface.getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("nearby_flower_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        SharedPreUtils.c(paramQQAppInterface.getApp(), paramIntent, i);
        paramQQAppInterface = (NearbyFlowerManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_FLOWER_MANAGER);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label231;
        }
        localList = paramConfig.content_list.get();
        if ((localList != null) && (localList.size() > 0))
        {
          paramQQAppInterface.a(paramIntent, (String)localList.get(0));
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 53,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
          }
        }
      }
    }
    label231:
    while (!QLog.isColorLevel())
    {
      List localList;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 53,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "getPrecoverConfig, PRECOVER_CONFIG_CMD, uin=" + paramString);
    }
    paramQQAppInterface = (PrecoverManager)paramQQAppInterface.getManager(QQManagerFactory.PRECOVER_MANAGER);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a() != null) && (paramQQAppInterface.a().d * 1000L <= 0L)) {}
    QConfigManager.a(new int[] { 113 }, paramString);
  }
  
  private void f(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        String str4 = paramQQAppInterface.getApplication().getFilesDir().getAbsolutePath() + "/splashpic/";
        Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = ((Document)localObject2).getElementsByTagName("splash");
        String str3 = null;
        String str2 = null;
        Object localObject1 = null;
        paramString = "";
        String str1 = "";
        i = 0;
        if (i < localNodeList.getLength())
        {
          str3 = ((Document)localObject2).getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
          str2 = ((Document)localObject2).getElementsByTagName("begin").item(i).getFirstChild().getNodeValue();
          localObject1 = ((Document)localObject2).getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
          paramString = ((Document)localObject2).getElementsByTagName("md5").item(i).getFirstChild().getNodeValue();
          str1 = ((Document)localObject2).getElementsByTagName("channel").item(i).getFirstChild().getNodeValue();
          String str5 = ((Document)localObject2).getElementsByTagName("title").item(i).getFirstChild().getNodeValue();
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "parse result,img == " + str3 + " ,begin = " + str2 + " ,end=" + (String)localObject1 + ",md5=" + paramString + " title = " + str5);
          }
        }
        else
        {
          if ((str3 == null) || (str3.trim().equals(""))) {
            break;
          }
          str3 = MsfSdkUtils.insertMtype("ConfigCheck", str3);
          localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          str2 = ((SimpleDateFormat)localObject2).parse(str2).getTime() + "|" + ((SimpleDateFormat)localObject2).parse((String)localObject1).getTime();
          SharedPreUtils.a(paramQQAppInterface.getApplication(), paramInt, str2, paramString);
          new File(paramQQAppInterface.getApplication().getFilesDir().getAbsolutePath() + "/splashpic");
          if (((SimpleDateFormat)localObject2).parse((String)localObject1).getTime() < System.currentTimeMillis())
          {
            paramQQAppInterface = new File(str4 + paramString);
            if (paramQQAppInterface.exists()) {
              paramQQAppInterface.delete();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "this splash is outdate, throw it");
            return;
          }
          localObject1 = new File(str4 + paramString);
          localObject2 = new File(str4 + str2 + "_" + paramString + "_" + str1);
          if (((File)localObject2).exists()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "begin a thread try to download");
          }
          ThreadManager.post(new ConfigServlet.6(this, (File)localObject1, paramQQAppInterface, str3, paramString, (File)localObject2, str4, str2, str1, str3), 5, null, true);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      i += 1;
    }
  }
  
  private void g(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = paramIntent.getStringExtra("key_uin");
    if (!TextUtils.isEmpty(paramIntent))
    {
      int i = paramConfig.version.get();
      int j = SharedPreUtils.r(paramQQAppInterface.getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        SharedPreUtils.d(paramQQAppInterface.getApp(), paramIntent, i);
        paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label231;
        }
        localList = paramConfig.content_list.get();
        if ((localList != null) && (localList.size() > 0))
        {
          paramQQAppInterface.a(paramIntent, (String)localList.get(0));
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 78,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
          }
        }
      }
    }
    label231:
    while (!QLog.isColorLevel())
    {
      List localList;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 78,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, 185, paramString);
  }
  
  private void h(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = CapturePtvTemplateManager.a();
    int j = paramConfig.version.get();
    int i = SharedPreUtils.i(paramQQAppInterface.getApp());
    if (!CapturePtvTemplateManager.a()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager_VideoRedbag", 2, "serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      SharedPreUtils.g(paramQQAppInterface.getApp(), j);
      try
      {
        String str = b(paramConfig, i, 226);
        if (str != null)
        {
          paramIntent.a(paramQQAppInterface, str, 1);
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, "receiveAllConfigs|type: 226,content: " + str + ",version: " + paramConfig.version.get());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, "receiveAllConfigs|type: 226,content_list is empty ,version: " + paramConfig.version.get());
          }
          paramIntent.a(paramQQAppInterface, "", 1);
          return;
        }
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CapturePtvTemplateManager", 2, "receiveAllConfigs|exception:" + paramQQAppInterface.getMessage());
        }
      }
    }
  }
  
  private void i(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = PtvTemplateManager.a(paramQQAppInterface);
    int j = paramConfig.version.get();
    int i = SharedPreUtils.h(paramQQAppInterface.getApp());
    if (!PtvTemplateManager.a()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      SharedPreUtils.f(paramQQAppInterface.getApp(), j);
      if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
        break label219;
      }
      localList = paramConfig.content_list.get();
      if ((localList != null) && (localList.size() > 0))
      {
        paramIntent.a((String)localList.get(0), paramQQAppInterface, 1);
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 84,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
        }
      }
    }
    label219:
    while (!QLog.isColorLevel())
    {
      List localList;
      return;
    }
    QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 84,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void j(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = PtvTemplateManager.a(paramQQAppInterface);
    int j = paramConfig.version.get();
    int i = SharedPreUtils.j(paramQQAppInterface.getApp());
    if (!PtvTemplateManager.b()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      SharedPreUtils.h(paramQQAppInterface.getApp(), j);
      String str = b(paramConfig, i, 167);
      if (str == null) {
        break label168;
      }
      paramIntent.a(str, paramQQAppInterface, 2);
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 167,content: " + str + ",version: " + paramConfig.version.get());
      }
    }
    label168:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 167,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void k(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    NearbyGrayTipsManager localNearbyGrayTipsManager;
    String str2;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_uin")))
    {
      int i = paramConfig.version.get();
      int j = SharedPreUtils.f(paramQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("nearby_aio_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        SharedPreUtils.d(paramQQAppInterface.getApp(), i);
        localNearbyGrayTipsManager = (NearbyGrayTipsManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_GRAY_TIPS_MANAGER);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label469;
        }
        paramIntent = paramConfig.content_list.get();
        if (QLog.isColorLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 2, "config.content_list size=" + paramIntent.size());
        }
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          localNearbyGrayTipsManager.b();
          Iterator localIterator = paramIntent.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str2 = (String)localIterator.next();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 23,content: " + str2 + ",version: " + paramConfig.version.get());
            }
          } while (StringUtil.a(str2));
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(str2);
        if (((JSONObject)localObject).isNull("MD5")) {
          break label519;
        }
        str1 = ((JSONObject)localObject).getString("MD5");
        paramIntent = str1;
        if (!TextUtils.isEmpty(str1)) {
          paramIntent = str1.toLowerCase();
        }
        if (((JSONObject)localObject).isNull("URL")) {
          break label513;
        }
        str1 = ((JSONObject)localObject).getString("URL");
        if (StringUtil.a(str1)) {
          break;
        }
        localObject = NearbyGrayTipsManager.a();
        ThreadManager.post(new ConfigServlet.8(this, paramQQAppInterface, str1, new File((String)localObject + "temp.txt"), paramIntent, localNearbyGrayTipsManager), 8, null, false);
      }
      catch (JSONException paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 2, "JSONException was thrown when parse json!!! string=" + str2);
        }
        paramIntent.printStackTrace();
      }
      break;
      localNearbyGrayTipsManager.a();
      localNearbyGrayTipsManager.a(true);
      return;
      label469:
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 23,content_list is empty ,version: " + paramConfig.version.get());
      }
      localNearbyGrayTipsManager.b();
      return;
      label513:
      String str1 = null;
      continue;
      label519:
      paramIntent = null;
    }
  }
  
  private void l(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    int j = 0;
    int i = paramConfig.version.get();
    if (i == SharedPreUtils.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      SharedPreUtils.j(paramQQAppInterface.getApp(), i, jdField_a_of_type_JavaLangString);
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        continue;
      }
      Object localObject1 = paramConfig.content_list.get();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        continue;
      }
      paramIntent = new HashMap();
      i = 0;
      if (i < ((List)localObject1).size())
      {
        Object localObject2 = (String)((List)localObject1).get(i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.fourTab", 2, "receiveAllConfigs|type: 115,content: " + (String)localObject2 + ",version: " + paramConfig.version.get());
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = ((String)localObject2).split("=");
          if ((localObject2 != null) && (localObject2.length == 2))
          {
            paramIntent.put(localObject2[0], localObject2[1]);
            if (QLog.isColorLevel()) {
              QLog.i("Q.qqstory.fourTab", 2, "NowTabConfigCmd, name=" + localObject2[0] + ", val=" + localObject2[1]);
            }
          }
        }
      }
      paramConfig = (String)paramIntent.get("mqq_nowtab_plan");
      if (QLog.isColorLevel()) {
        QLog.i("nowtabPlan", 2, "nowtabPlan=" + paramConfig);
      }
      if (paramConfig != null) {}
      try
      {
        localObject1 = paramQQAppInterface.getNowLiveManager().a();
        i = Integer.valueOf("" + ((String)localObject1).charAt(2)).intValue();
        k = Integer.valueOf(paramConfig).intValue();
        if (i != k)
        {
          localObject1 = new Integer[5];
          i = j;
        }
        switch (k)
        {
        case 0: 
          paramQQAppInterface.getNowLiveManager().a = paramConfig.charAt(0);
          paramConfig = (String)paramIntent.get("mqq_nowtab_index");
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqstory.fourTab:nowtabIndex", 2, "nowtabIndex=" + paramConfig);
          }
          if (paramConfig == null) {}
          break;
        }
      }
      catch (Exception paramConfig)
      {
        for (;;)
        {
          try
          {
            int k;
            for (;;)
            {
              paramQQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0).edit().putInt("now_index_key", Integer.valueOf(paramConfig).intValue());
              paramQQAppInterface.getNowLiveManager().c = Integer.valueOf(paramConfig).intValue();
              paramIntent = (String)paramIntent.get("mqq_open_myvideo");
              if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory:IsOpenMyVideo", 2, "IsOpenMyVideo=" + paramIntent);
              }
              try
              {
                if (TextUtils.isEmpty(paramIntent)) {
                  break;
                }
                ((QQStoryManager)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER)).h(Boolean.parseBoolean(paramIntent));
                return;
              }
              catch (Exception paramQQAppInterface)
              {
                QLog.w("Q.qqstory:drawerMyVideoItem", 2, "drawerMyVideoItem is not value of Int!");
                return;
              }
            }
            if (i < localObject1.length)
            {
              localObject1[i] = Integer.valueOf(0);
              i += 1;
            }
            else
            {
              localObject1[2] = Integer.valueOf(k);
              if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 0 1 nowtabPlan=" + paramConfig);
              }
              paramQQAppInterface.getNowLiveManager().a((Integer[])localObject1);
              continue;
              paramConfig = paramConfig;
              QLog.w("Q.qqstory.fourTab:nowtabPlan", 2, "" + paramConfig.getMessage(), paramConfig);
              continue;
              localObject1[1] = Integer.valueOf(0);
              localObject1[2] = Integer.valueOf(k);
              paramQQAppInterface.getNowLiveManager().a((Integer[])localObject1);
              if (QLog.isColorLevel())
              {
                QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 2 nowtabPlan=" + paramConfig);
                continue;
                localObject1[2] = Integer.valueOf(k);
                localObject1[1] = Integer.valueOf(1);
                paramQQAppInterface.getNowLiveManager().a((Integer[])localObject1);
                if (QLog.isColorLevel()) {
                  QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 3 nowtabPlan=" + paramConfig);
                }
              }
            }
          }
          catch (Exception paramConfig)
          {
            QLog.w("Q.qqstory.fourTab:nowtabIndex", 2, "nowtabIndex is not value of Int!");
          }
        }
      }
    }
  }
  
  private void m(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    if (i == j) {}
    label165:
    label181:
    do
    {
      do
      {
        return;
        SharedPreUtils.k(paramQQAppInterface.getApp(), i, jdField_a_of_type_JavaLangString);
        for (;;)
        {
          try
          {
            if (paramConfig.msg_content_list != null)
            {
              i = paramConfig.msg_content_list.size();
              paramQQAppInterface = (NowGeneralConfigManager)paramQQAppInterface.getManager(QQManagerFactory.NOW_DOWNLOAD_ENGINE_MANAGER);
              if (i <= 0) {
                break label181;
              }
              paramIntent = b(paramConfig, j, 286);
              paramQQAppInterface.a(paramIntent);
              if (TextUtils.isEmpty(paramIntent)) {
                break label165;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNowDownloadEngineConfigCmd, content: \n" + paramIntent);
              return;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            QLog.e("SPLASH_ConfigServlet", 2, "Exception e = " + paramQQAppInterface.toString());
            return;
          }
          i = -1;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNowDownloadEngineConfigCmd null");
      return;
      paramQQAppInterface.a("");
    } while (!QLog.isColorLevel());
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 286,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void n(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {}
    for (Object localObject1 = paramConfig.content_list.get();; localObject1 = null)
    {
      HashMap localHashMap;
      int i;
      Object localObject2;
      Object localObject3;
      label846:
      label865:
      boolean bool;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localHashMap = new HashMap();
        i = 0;
        if (i < ((List)localObject1).size())
        {
          localObject2 = (String)((List)localObject1).get(i);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 101,content: " + (String)localObject2 + ",version: " + paramConfig.version.get());
          }
          if (TextUtils.isEmpty((CharSequence)localObject2)) {}
          for (;;)
          {
            i += 1;
            break;
            localObject2 = ((String)localObject2).split("=");
            if ((localObject2 != null) && (localObject2.length == 2))
            {
              localHashMap.put(localObject2[0], localObject2[1]);
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "GENERAL_CONFIGS_CMD, name=" + localObject2[0] + ", val=" + localObject2[1]);
              }
            }
          }
        }
        localObject2 = (String)localHashMap.get("ptlogin_flag");
        localObject1 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
        ((SharedPreferences)localObject1).edit().putBoolean("ptlogin_flag" + paramQQAppInterface.getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
        localObject2 = (String)localHashMap.get("lmr_block");
        if (QLog.isColorLevel()) {
          QLog.i("new_regprxy_switch", 2, "GENERAL_CONFIGS_CMD, new_regprxy_switch=" + (String)localObject2);
        }
        if (localObject2 != null) {
          BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("new_regprxy_switch", "1".equalsIgnoreCase((String)localObject2)).commit();
        }
        localObject2 = (String)localHashMap.get("qfind_report_gps_bt_stat");
        String str = (String)localHashMap.get("qfind_searching");
        localObject3 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject3).putBoolean("qfind_searching" + paramQQAppInterface.getAccount(), "1".equals(str));
        ((SharedPreferences.Editor)localObject3).putBoolean("qfind_report_gps_bt_stat" + paramQQAppInterface.getAccount(), "1".equals(localObject2));
        ((SharedPreferences.Editor)localObject3).commit();
        if (QLog.isColorLevel()) {
          QLog.w("QFind", 2, "qfind flags qfindStatFlag=" + (String)localObject2 + ", qfind_searching=" + str);
        }
        localObject2 = (String)localHashMap.get("enable_public_device");
        if (localObject2 != null) {
          BaseApplication.getContext().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("enable_public_device" + "_" + paramQQAppInterface.getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
        }
        localObject2 = (String)localHashMap.get("search_device_enable_https");
        if (localObject2 != null)
        {
          BaseApplication.getContext().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("search_device_enable_https" + "_" + paramQQAppInterface.getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
          if (QLog.isColorLevel()) {
            QLog.w("smartdevice", 2, "search_device_enable_https=" + (String)localObject2);
          }
        }
        localObject2 = (String)localHashMap.get("mqq_calltab");
        str = (String)localHashMap.get("mqq_calltab_setting");
        if ((localObject2 != null) || (str != null))
        {
          localObject3 = new Integer[7];
          if (localObject2 != null)
          {
            if (((String)localObject2).indexOf('|') <= 0) {
              break label2053;
            }
            if (localObject2.split("|")[0].equals("1"))
            {
              i = 1;
              localObject3[1] = Integer.valueOf(i);
            }
          }
          else
          {
            if (str != null)
            {
              if (!str.equals("1")) {
                break label2085;
              }
              i = 1;
              localObject3[5] = Integer.valueOf(i);
            }
            paramQQAppInterface.writeCallTabStateVal((Integer[])localObject3);
          }
        }
        else
        {
          localObject3 = (String)localHashMap.get("subscribe_discovery");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            SubscriptRecommendController.d(paramQQAppInterface, "1".equals(localObject3));
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "subscribe discovery btn config : " + (String)localObject3);
            }
          }
          if ((localObject2 == null) || (str == null))
          {
            localObject3 = new Integer[7];
            if (localObject2 == null)
            {
              localObject3[1] = Integer.valueOf("0111100".charAt(1) - '0');
              localObject3[2] = Integer.valueOf("0111100".charAt(2) - '0');
            }
            if (str == null)
            {
              localObject3[5] = Integer.valueOf("0111100".charAt(5) - '0');
              localObject3[6] = Integer.valueOf("0111100".charAt(6) - '0');
            }
            paramQQAppInterface.writeCallTabStateVal((Integer[])localObject3);
          }
          localObject2 = (String)localHashMap.get("share_to_news");
          if (localObject2 != null) {
            ReadInJoyHelper.a((String)localObject2, paramQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("synchronize_to_qzone");
          if (localObject2 != null) {
            ReadInJoyHelper.b((String)localObject2, paramQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("merge_feeds");
          if (localObject2 != null) {
            ReadInJoyHelper.d((String)localObject2, paramQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("kandian_feeds");
          if (localObject2 != null) {
            ReadInJoyHelper.e((String)localObject2, paramQQAppInterface);
          }
          i = paramConfig.version.get();
          SharedPreUtils.f(paramQQAppInterface.getApplication(), i, jdField_a_of_type_JavaLangString);
          if ((paramIntent != null) && (paramIntent.hasExtra("update101Version"))) {
            SettingCloneUtil.writeValueForInt(paramQQAppInterface.getApplication(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", paramIntent.getIntExtra("update101Version", 0));
          }
          ArkAppCenter.a((String)localHashMap.get("arkapp_pa_nshow"));
          NearbySPUtil.a(paramQQAppInterface.getAccount(), "supportHotChatDemo", Boolean.valueOf("1".equals(localHashMap.get("hotchat_demo"))));
          paramIntent = (PttConfigController)paramQQAppInterface.getManager(QQManagerFactory.PTT_CFG_MANAGER);
          paramIntent.a((String)localHashMap.get("ptt_stream_slice_cfg"));
          paramIntent.b((String)localHashMap.get("ptt_optimize_cfg_v2"));
          paramIntent.c((String)localHashMap.get("ptt_pre_download"));
          paramIntent = (String)localHashMap.get("splashpic_charm_requirement");
          if (paramIntent != null) {
            HotChatManager.a(paramQQAppInterface, paramIntent);
          }
          paramIntent = (String)localHashMap.get("kFreezeTipsShow");
          paramConfig = paramQQAppInterface.getApp();
          if (Build.VERSION.SDK_INT <= 10) {
            break label2091;
          }
          i = 4;
          label1349:
          paramConfig = paramConfig.getSharedPreferences("qwallet_multi", i);
          if (paramConfig != null)
          {
            paramConfig = paramConfig.edit();
            if ((!TextUtils.isEmpty(paramIntent)) && (!"1".equals(paramIntent))) {
              break label2097;
            }
            bool = true;
            label1390:
            paramConfig.putBoolean("is_tenpay_yellowtip_valid", bool);
            paramIntent = (String)localHashMap.get("publicWhiteList");
            QWalletHelperImpl.updatePublicAccWhiteMap(paramIntent);
            paramConfig.putString("publicAcc_white_list", paramIntent);
            paramConfig.commit();
          }
          QWalletHelperImpl.updateHongBaoSpeedWitch(paramQQAppInterface, (String)localHashMap.get("hongbao_speed"));
          paramIntent = (String)localHashMap.get("shortvideo_predownload_strategy");
          if (paramIntent == null) {}
        }
      }
      for (;;)
      {
        try
        {
          i = Integer.valueOf(paramIntent).intValue();
          paramQQAppInterface.getShortVideoPredownloer().a.set(i);
          paramIntent = (String)localHashMap.get("camera_compatible_list");
          if (paramIntent == null) {}
        }
        catch (Exception paramIntent)
        {
          try
          {
            CameraCompatibleList.a(paramIntent, true);
            paramIntent = (String)localHashMap.get("qqwifi_provider_mask");
            if (paramIntent != null) {
              ((SharedPreferences)localObject1).edit().putString("qqwifi_provider_mask", paramIntent).commit();
            }
            paramIntent = (String)localHashMap.get("signalling_switch");
            if (QLog.isColorLevel()) {
              QLog.i("signalling_switch", 2, "GENERAL_CONFIGS_CMD, signalling_switch=" + paramIntent);
            }
            if (paramIntent != null)
            {
              paramQQAppInterface = paramQQAppInterface.getMsgCache();
              if ("1".equals(paramIntent))
              {
                i = 1;
                paramQQAppInterface.b(i);
              }
            }
            else
            {
              paramQQAppInterface = (String)localHashMap.get("public_offline_search_enable");
              if (QLog.isColorLevel()) {
                QLog.i("PAOfflineSearchManager", 2, "GENERAL_CONFIGS_CMD, public_offline_search_enable=" + paramQQAppInterface);
              }
              if (paramQQAppInterface != null)
              {
                paramIntent = PAOfflineSearchManager.a();
                if (!"1".equals(paramQQAppInterface)) {
                  continue;
                }
                bool = true;
                paramIntent.jdField_b_of_type_Boolean = bool;
              }
              paramQQAppInterface = (String)localHashMap.get("public_advance_search_freq");
              if (QLog.isColorLevel()) {
                QLog.i("searchutils", 2, "GENERAL_CONFIGS_CMD, netsearchlevel=" + paramQQAppInterface);
              }
              if (paramQQAppInterface == null) {}
            }
          }
          catch (Exception paramIntent)
          {
            try
            {
              com.tencent.mobileqq.search.util.SearchUtils.jdField_b_of_type_Int = Integer.valueOf(paramQQAppInterface).intValue();
              ProgressiveUtils.a((String)localHashMap.get("shortvideo_progressive_enable"));
              paramQQAppInterface = (String)localHashMap.get("aio_autoinput_time");
              if (paramQQAppInterface != null) {
                i = 900;
              }
              try
              {
                int j = Integer.parseInt(paramQQAppInterface);
                i = j;
              }
              catch (NumberFormatException paramIntent)
              {
                QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, aio_autoinput_time not a int");
                continue;
              }
              if (QLog.isColorLevel()) {
                QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, aio_autoinput_time=" + paramQQAppInterface);
              }
              BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt("aio_autoinput_time", i).commit();
              paramQQAppInterface = (String)localHashMap.get("pic_thumb_400");
              if (QLog.isColorLevel()) {
                QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, pic_thumb_400=" + paramQQAppInterface);
              }
              GeneralConfigUtils.a("pic_thumb_400Enable", paramQQAppInterface);
              paramQQAppInterface = (String)localHashMap.get("Show_Business_Card");
              if (QLog.isColorLevel()) {
                QLog.d("BusinessCara_Manager", 2, "Show_Business_Card= " + paramQQAppInterface);
              }
              paramQQAppInterface = (String)localHashMap.get("TIMDocLimitSettingFlag");
              if (QLog.isColorLevel()) {
                QLog.i("TIMDocLimitSettingFlag", 2, "GENERAL_CONFIGS_CMD, TIMDocLimitSettingFlag = " + paramQQAppInterface);
              }
              if (paramQQAppInterface != null) {
                BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit().putBoolean("TIMDocLimitSettingFlag", "1".equalsIgnoreCase(paramQQAppInterface)).commit();
              }
              IdentificationActivityHelper.a();
              return;
              i = 0;
              break;
              label2053:
              if (((String)localObject2).equals("1"))
              {
                i = 1;
                localObject3[1] = Integer.valueOf(i);
                break label846;
              }
              i = 0;
              continue;
              label2085:
              i = 0;
              break label865;
              label2091:
              i = 0;
              break label1349;
              label2097:
              bool = false;
              break label1390;
              paramIntent = paramIntent;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("SPLASH_ConfigServlet", 2, paramIntent.getMessage());
              continue;
              paramIntent = paramIntent;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("SPLASH_ConfigServlet", 2, "camera_compatible_list ERROR = " + paramIntent.getMessage());
              continue;
              i = 0;
              continue;
              bool = false;
            }
            catch (Exception paramQQAppInterface)
            {
              paramQQAppInterface.printStackTrace();
              continue;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 101,content_list is empty ,version: " + paramConfig.version.get());
        }
      }
    }
  }
  
  private void o(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    PtvTemplateManager localPtvTemplateManager = PtvTemplateManager.a(paramQQAppInterface);
    int j = paramConfig.version.get();
    int i = SharedPreUtils.m(paramQQAppInterface.getApp());
    if (!PtvTemplateManager.d()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "GetBlessSpecialPendantConfig serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      SharedPreUtils.j(paramQQAppInterface.getApp(), j);
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label249;
      }
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent != null)
      {
        if (paramIntent.compress.get() != 1) {
          break label235;
        }
        paramIntent = OlympicUtil.a(paramIntent.content.get().toByteArray());
        if (paramIntent == null) {
          break label230;
        }
      }
    }
    label230:
    label235:
    label249:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          paramIntent = new String(paramIntent, "UTF-8");
          localPtvTemplateManager.b(paramIntent, paramQQAppInterface);
          if (QLog.isColorLevel()) {
            QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 145,content: " + paramIntent + ",version: " + paramConfig.version.get());
          }
          return;
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
        paramIntent = null;
        continue;
        paramIntent = paramIntent.content.get().toStringUtf8();
      }
    }
    QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 145,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  public static void w(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    boolean bool = false;
    int k = paramConfig.version.get();
    int j = SharedPreUtils.as(paramQQAppInterface.getApp().getBaseContext(), jdField_a_of_type_JavaLangString);
    if (paramConfig.msg_content_list != null) {}
    for (int i = paramConfig.msg_content_list.size();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("handleScribbleRedSwitchConfigSPLASH_ConfigServlet", 2, String.format("scribble回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }));
      }
      if (k != j) {
        break;
      }
      return;
    }
    Object localObject1;
    byte[] arrayOfByte;
    if (i > 0)
    {
      j = 0;
      if (j < i)
      {
        localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(j);
        if (localObject1 == null) {
          break label336;
        }
        if (((ConfigurationService.Content)localObject1).compress.get() == 1)
        {
          arrayOfByte = OlympicUtil.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
          if (arrayOfByte == null)
          {
            QLog.e("handleScribbleRedSwitchConfigSPLASH_ConfigServlet", 2, "解压错误");
            localObject1 = null;
            label173:
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label336;
            }
            bool = ScribbleResMgr.a((String)localObject1, paramQQAppInterface.getApp().getBaseContext(), jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
    label336:
    for (;;)
    {
      for (;;)
      {
        j += 1;
        break;
        try
        {
          localObject1 = new String(arrayOfByte, "UTF-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          if (QLog.isColorLevel()) {
            localUnsupportedEncodingException.printStackTrace();
          }
          Object localObject2 = null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              localOutOfMemoryError.printStackTrace();
            }
            System.gc();
            try
            {
              String str1 = new String(arrayOfByte, "UTF-8");
            }
            catch (Throwable localThrowable)
            {
              str2 = null;
            }
          }
        }
      }
      break label173;
      String str2 = str2.content.get().toStringUtf8();
      break label173;
      if (!bool) {
        break;
      }
      SharedPreUtils.v(paramQQAppInterface.getApp().getBaseContext(), k, jdField_a_of_type_JavaLangString);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("handleScribbleRedSwitchConfigSPLASH_ConfigServlet", 2, "回包为空");
      return;
    }
  }
  
  public static void z(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.au(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      SharedPreUtils.Q(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = paramConfig.iterator();
        while (paramConfig.hasNext())
        {
          localObject = (String)paramConfig.next();
          try
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("kReceiptMsgEnable"))
            {
              i = ((JSONObject)localObject).getInt("kReceiptMsgEnable");
              SharedPreUtils.e(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "receipt_kReceiptMsgEnable", i);
            }
            if (((JSONObject)localObject).has("kReceiptMsgMaxSendTimes"))
            {
              i = ((JSONObject)localObject).getInt("kReceiptMsgMaxSendTimes");
              SharedPreUtils.e(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "receipt_kReceiptMsgSendTimes", i);
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        AIOConfigManager.a(paramQQAppInterface);
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      return;
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
  }
  
  public void A(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    boolean bool;
    if (i != paramQQAppInterface.getPreferences().getInt("tim_upgrade_hongdian_version", 0))
    {
      long l1 = System.currentTimeMillis();
      bool = PackageUtil.a(paramQQAppInterface.getApp(), "com.tencent.tim");
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TimUpgradeHondianManager", 2, "is install TIM = " + bool + " time cost = " + (l2 - l1));
      }
      if (bool) {
        break label386;
      }
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    try
    {
      Object localObject = new JSONObject((String)paramConfig.get(0));
      if (((JSONObject)localObject).has("AboutTIMRedDot"))
      {
        paramConfig = paramQQAppInterface.getApp().getSharedPreferences("tim_upgrade_hongdian_pre_" + paramQQAppInterface.getCurrentUin(), 0).edit();
        localObject = ((JSONObject)localObject).getJSONObject("AboutTIMRedDot");
        if (((JSONObject)localObject).has("On")) {
          if (((JSONObject)localObject).getInt("On") != 1) {
            break label374;
          }
        }
      }
      label374:
      for (bool = true;; bool = false)
      {
        paramConfig.putBoolean("tim_upgrade_hongdian_switch", bool);
        if (((JSONObject)localObject).has("AboutTitle")) {
          paramConfig.putString("tim_upgrade_hongdian_title", ((JSONObject)localObject).getString("AboutTitle"));
        }
        if (((JSONObject)localObject).has("AboutSubtitle")) {
          paramConfig.putString("tim_upgrade_hongdian_sub_title", ((JSONObject)localObject).getString("AboutSubtitle"));
        }
        if (((JSONObject)localObject).has("AndroidAboutURL"))
        {
          localObject = ((JSONObject)localObject).getString("AndroidAboutURL");
          paramConfig.putString("tim_upgrade_hongdian_url", (String)localObject);
          ((UpgradeTIMManager)paramQQAppInterface.getManager(QQManagerFactory.TIM_UPGRADE_DOWNLOAD_MANAGER)).a((String)localObject);
        }
        paramConfig.commit();
        paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
        paramQQAppInterface.putInt("tim_upgrade_hongdian_version", i);
        paramQQAppInterface.apply();
        return;
      }
      ((TimUpgradeHongdianManager)paramQQAppInterface.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER)).a();
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return;
    }
    label386:
  }
  
  public void B(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("tim_login_jump", 0))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)paramConfig.get(0));
      if (localJSONObject.has("LoginedTipForTIM"))
      {
        paramConfig = paramQQAppInterface.getApp().getSharedPreferences("tim_login_shared_pre_" + paramQQAppInterface.getCurrentUin(), 0).edit();
        localJSONObject = localJSONObject.getJSONObject("LoginedTipForTIM");
        if (localJSONObject.has("On")) {
          if (localJSONObject.getInt("On") != 1) {
            break label463;
          }
        }
      }
      label463:
      for (boolean bool = true;; bool = false)
      {
        paramConfig.putBoolean("tim_login_s", bool);
        if (localJSONObject.has("ShowTipTimeIntervalAfterLogined")) {
          paramConfig.putInt("tim_login_tal", localJSONObject.getInt("ShowTipTimeIntervalAfterLogined"));
        }
        if (localJSONObject.has("ShowTipDay")) {
          paramConfig.putString("tim_login_sd", localJSONObject.getJSONArray("ShowTipDay").toString());
        }
        if (localJSONObject.has("ShowTipTime")) {
          paramConfig.putString("tim_login_st", localJSONObject.getJSONArray("ShowTipTime").toString());
        }
        if (localJSONObject.has("AndroidLimit")) {
          paramConfig.putInt("tim_login_l", localJSONObject.getInt("AndroidLimit"));
        }
        if (localJSONObject.has("ShowTipTotalCount")) {
          paramConfig.putInt("tim_login_tc", localJSONObject.getInt("ShowTipTotalCount"));
        }
        if (localJSONObject.has("ShowTipHourInterval")) {
          paramConfig.putInt("tim_login_sti", localJSONObject.getInt("ShowTipHourInterval"));
        }
        if (localJSONObject.has("Title")) {
          paramConfig.putString("tim_login_t", localJSONObject.getString("Title"));
        }
        if (localJSONObject.has("Message")) {
          paramConfig.putString("tim_login_c", localJSONObject.getString("Message"));
        }
        if (localJSONObject.has("Buttons")) {
          paramConfig.putString("tim_login_btns", localJSONObject.getJSONArray("Buttons").toString());
        }
        paramConfig.commit();
        paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
        paramQQAppInterface.putInt("tim_login_jump", i);
        paramQQAppInterface.apply();
        return;
      }
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void C(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("tim_pc_banner", 0))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)paramConfig.get(0));
      if (localJSONObject.has("PCTIMLoginBanner"))
      {
        paramConfig = paramQQAppInterface.getApp().getSharedPreferences("tim_pc_banner_shared_pre_" + paramQQAppInterface.getCurrentUin(), 0).edit();
        localJSONObject = localJSONObject.getJSONObject("PCTIMLoginBanner");
        if (localJSONObject.has("On")) {
          if (localJSONObject.getInt("On") != 1) {
            break label338;
          }
        }
      }
      label338:
      for (boolean bool = true;; bool = false)
      {
        paramConfig.putBoolean("tim_pc_banner_switch", bool);
        if (localJSONObject.has("bannerURL")) {
          paramConfig.putString("tim_pc_banner_image_url", localJSONObject.getString("bannerURL"));
        }
        if (localJSONObject.has("bannerVersion")) {
          paramConfig.putInt("tim_pc_banner_image_ver", localJSONObject.getInt("bannerVersion"));
        }
        if (localJSONObject.has("androidURL")) {
          paramConfig.putString("tim_pc_banner_click_url", localJSONObject.getString("androidURL"));
        }
        if (localJSONObject.has("linkText")) {
          paramConfig.putString("tim_pc_banner_link_text", localJSONObject.getString("linkText"));
        }
        if (localJSONObject.has("androidLinkURL")) {
          paramConfig.putString("tim_pc_banner_link_url", localJSONObject.getString("androidLinkURL"));
        }
        paramConfig.commit();
        paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
        paramQQAppInterface.putInt("tim_pc_banner", i);
        paramQQAppInterface.apply();
        return;
      }
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void D(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("troop_link_config_version", 0))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        if (TroopLinkManager.a().a(paramConfig)) {
          paramQQAppInterface.getPreferences().edit().putInt("troop_link_config_version", i).commit();
        }
      }
    }
  }
  
  public void E(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    if (paramQQAppInterface == null) {}
    label17:
    do
    {
      break label17;
      do
      {
        return;
      } while (paramQQAppInterface.getInt("key_game_troop_bind_config_version", 0) == i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {
        break;
      }
      paramConfig = (String)paramConfig.get(0);
    } while (paramConfig == null);
    for (;;)
    {
      try
      {
        paramConfig = new JSONObject(paramConfig);
        if ((!paramConfig.has("showBindGameEntry")) || (paramConfig.getInt("showBindGameEntry") != 1)) {
          break label266;
        }
        bool = true;
        paramQQAppInterface.edit().putBoolean("key_game_troop_bind_config_switch", bool).apply();
        paramQQAppInterface.edit().putInt("key_game_troop_bind_config_version", i).apply();
        if (!QLog.isColorLevel()) {
          break label17;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "game troop config set:" + bool);
        return;
      }
      catch (Exception paramQQAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SPLASH_ConfigServlet", 2, "game troop config parse error:" + paramQQAppInterface.toString());
      return;
      paramQQAppInterface.edit().putBoolean("key_game_troop_bind_config_switch", false).apply();
      paramQQAppInterface.edit().putInt("key_game_troop_bind_config_version", i).apply();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "game troop config empty content get");
      return;
      label266:
      boolean bool = false;
    }
  }
  
  public void F(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = paramQQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0);
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, new Object[] { "handleTimAIOTipsBar| config empty, delete config, version=", Integer.valueOf(i) });
      }
      paramQQAppInterface.getPreferences().edit().remove("tim_aio_tips_bar_version").apply();
      ((AppGuideTipsManager)paramQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).d();
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while (i == j);
      paramQQAppInterface.getPreferences().edit().putInt("tim_aio_tips_bar_version", i).apply();
      localObject = a(paramConfig);
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    paramConfig = new AppGuideTipsConfig();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, new Object[] { "handleTimAIOTipsBar| Get Config ", Integer.valueOf(254), ": ", ((List)localObject).get(0) });
      }
      localObject = new JSONObject((String)((List)localObject).get(0));
      if (((JSONObject)localObject).has("SendMessageAIOTopTip"))
      {
        localObject = ((JSONObject)localObject).getJSONObject("SendMessageAIOTopTip");
        paramConfig.switchKey = ((JSONObject)localObject).getString("switch");
        paramConfig.maxCount = Integer.valueOf(((JSONObject)localObject).getString("total")).intValue();
        paramConfig.duration = Long.valueOf(((JSONObject)localObject).getString("duration")).longValue();
        paramConfig.tipsUrl = ((JSONObject)localObject).getString("androidURL");
        paramConfig.tipsMsg = ((JSONObject)localObject).getString("title");
        paramConfig.msgTypeStr = ((JSONObject)localObject).getString("androidtypes");
        paramConfig.aioTypeStr = ((JSONObject)localObject).getString("androidAIOTypes");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    paramQQAppInterface = (AppGuideTipsManager)paramQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER);
    paramQQAppInterface.a(paramConfig);
    paramQQAppInterface.c();
  }
  
  public void G(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != QmcfDevicesStrategy.a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        QmcfDevicesStrategy.a((String)paramConfig.get(0), i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void H(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    boolean bool4 = true;
    boolean bool5 = false;
    int i = paramConfig.version.get();
    Object localObject2;
    SharedPreferences.Editor localEditor;
    Object localObject1;
    boolean bool1;
    if (i != paramQQAppInterface.getPreferences().getInt("data_migration_tim_version", 0))
    {
      paramConfig = a(paramConfig);
      localObject2 = paramQQAppInterface.getApp().getSharedPreferences("data_migration_tim", 0);
      localEditor = ((SharedPreferences)localObject2).edit();
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    else
    {
      try
      {
        paramConfig = new JSONObject((String)paramConfig.get(0));
        if (!paramConfig.has("DataMigration")) {
          break label334;
        }
        localObject1 = paramConfig.getJSONObject("DataMigration");
        paramConfig = "";
        str1 = "";
        if (!((JSONObject)localObject1).has("switch")) {
          break label567;
        }
        if (((JSONObject)localObject1).getInt("switch") != 1) {
          break label369;
        }
        bool1 = true;
      }
      catch (JSONException paramConfig)
      {
        for (;;)
        {
          String str1;
          label173:
          paramConfig.printStackTrace();
        }
      }
      if (!((JSONObject)localObject1).has("uninstall")) {
        break label561;
      }
      if (((JSONObject)localObject1).getInt("uninstall") == 1)
      {
        bool1 = true;
        break label580;
        if (((JSONObject)localObject1).has("title")) {
          paramConfig = ((JSONObject)localObject1).getString("title");
        }
        if (((JSONObject)localObject1).has("content")) {
          str1 = ((JSONObject)localObject1).getString("content");
        }
        bool1 = bool5;
        if (((JSONObject)localObject1).has("uninstallNotify"))
        {
          if (((JSONObject)localObject1).getInt("uninstallNotify") != 1) {
            break label381;
          }
          bool1 = bool4;
          break label587;
        }
      }
    }
    label561:
    label567:
    label580:
    label587:
    for (;;)
    {
      if (((JSONObject)localObject1).has("uninstallTitle")) {}
      for (String str2 = ((JSONObject)localObject1).getString("uninstallTitle");; str2 = "")
      {
        if (((JSONObject)localObject1).has("uninstallContent")) {}
        for (localObject1 = ((JSONObject)localObject1).getString("uninstallContent");; localObject1 = "")
        {
          localObject2 = a((SharedPreferences)localObject2, paramQQAppInterface.getCurrentAccountUin(), bool2);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "handleDataMigrationForTIM| remove all uins");
            }
            localEditor.clear();
          }
          for (;;)
          {
            label334:
            localEditor.apply();
            paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
            paramQQAppInterface.putInt("data_migration_tim_version", i);
            paramQQAppInterface.apply();
            return;
            label369:
            bool1 = false;
            break;
            bool1 = false;
            break label580;
            label381:
            bool1 = false;
            break label587;
            localEditor.putString("data_migration_tim_uins", (String)localObject2);
            localEditor.putBoolean("data_migration_tim_uninstall_flag", bool3);
            localEditor.putString("data_migration_tim_title", paramConfig);
            localEditor.putString("data_migration_tim_content", str1);
            localEditor.putBoolean("data_migration_tim_uninstall_notify", bool1);
            localEditor.putString("data_migration_tim_uninstall_title", str2);
            localEditor.putString("data_migration_tim_uninstall_content", (String)localObject1);
            continue;
            paramConfig = a((SharedPreferences)localObject2, paramQQAppInterface.getCurrentAccountUin(), false);
            if (TextUtils.isEmpty(paramConfig))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleDataMigrationForTIM| remove all uins");
              }
              localEditor.clear();
            }
            else
            {
              localEditor.putString("data_migration_tim_uins", paramConfig);
            }
          }
        }
      }
      boolean bool3 = false;
      break label173;
      boolean bool2 = false;
      break;
      bool2 = bool1;
      break;
      bool3 = bool1;
      break label173;
    }
  }
  
  public void I(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    Object localObject;
    if (i != paramQQAppInterface.getPreferences().getInt("call_tim_config_version", 0))
    {
      localObject = a(paramConfig);
      paramConfig = paramQQAppInterface.getApp().getSharedPreferences("call_tim_config_pre" + paramQQAppInterface.getCurrentUin(), 0).edit();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label262;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)((List)localObject).get(0));
        if (((JSONObject)localObject).has("TIMFreeCloud"))
        {
          localObject = ((JSONObject)localObject).getJSONObject("TIMFreeCloud");
          if (((JSONObject)localObject).has("On")) {
            paramConfig.putBoolean("call_tim_config_switch", "1".equals(((JSONObject)localObject).getString("On")));
          }
          if (((JSONObject)localObject).has("Title")) {
            paramConfig.putString("call_tim_config_title", ((JSONObject)localObject).getString("Title"));
          }
          if (((JSONObject)localObject).has("androidURL")) {
            paramConfig.putString("call_tim_config_url", ((JSONObject)localObject).getString("androidURL"));
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      paramConfig.commit();
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putInt("call_tim_config_version", i);
      paramQQAppInterface.apply();
      return;
      label262:
      paramConfig.putBoolean("call_tim_config_switch", false);
    }
  }
  
  void J(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.type.get() != 267) || (paramQQAppInterface == null)) {}
    int i;
    int j;
    do
    {
      return;
      i = SharedPreUtils.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString);
      j = paramConfig.version.get();
    } while (i == j);
    ((SportManager)paramQQAppInterface.getManager(QQManagerFactory.SPORT_MANAGER)).a(paramConfig);
    SharedPreUtils.a(paramQQAppInterface.getApp(), "sport_config", jdField_a_of_type_JavaLangString, j);
  }
  
  public void K(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.type.get() != 281) || (paramQQAppInterface == null)) {}
    do
    {
      String str;
      do
      {
        return;
        str = a(paramConfig, SharedPreUtils.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0"), 281);
      } while (TextUtils.isEmpty(str));
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleTroopGiftLimitConfig content: " + str);
      }
      int i = paramConfig.version.get();
      SharedPreUtils.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0", i);
      try
      {
        i = new JSONObject(str).getInt("limitGiftAnimCount");
        com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.jdField_b_of_type_Int = i;
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).edit();
        paramQQAppInterface.putInt("AIOAnimationControlManager_limit_gif_count_MAX", i);
        paramQQAppInterface.commit();
        return;
      }
      catch (JSONException paramQQAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.w("SPLASH_ConfigServlet", 2, "handleTroopGiftLimitConfig error" + paramQQAppInterface.getMessage());
  }
  
  public void L(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig == null) || (paramConfig.type.get() != 283)) {
      return;
    }
    paramQQAppInterface = a(paramConfig);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramQQAppInterface = (String)paramQQAppInterface.get(0);
      QLog.d("SafeModeUtil", 1, "handleSafeModeCmd configJson = " + paramQQAppInterface);
      MsfCmdConfig.executeSafeModeCmd(paramConfig.version.get(), paramQQAppInterface);
    }
    for (;;)
    {
      SafeModeUtil.c();
      return;
      QLog.d("SafeModeUtil", 1, "handleSafeModeCmd null");
    }
  }
  
  public void M(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.type.get() != 284) || (paramQQAppInterface == null)) {}
    int i;
    int j;
    do
    {
      return;
      i = SharedPreUtils.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString);
      j = paramConfig.version.get();
      if (QLog.isColorLevel()) {
        QLog.w("zivonchen", 2, "handleTaskEntryConfig reqVersion = " + i);
      }
    } while (i == j);
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("task_entry_config" + jdField_a_of_type_JavaLangString, 0).edit();
    paramConfig = a(paramConfig);
    String str1;
    if ((paramConfig != null) && (paramConfig.size() > 0))
    {
      str1 = (String)paramConfig.get(0);
      if (QLog.isColorLevel()) {
        QLog.w("zivonchen", 2, "handleTaskEntryConfig configJson = " + str1);
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(str1);
        paramConfig = ((JSONObject)localObject).optString("icon_url");
        String str2 = ((JSONObject)localObject).optString("night_icon_url");
        String str3 = ((JSONObject)localObject).optString("jump_url");
        localObject = ((JSONObject)localObject).optString("word");
        if ((!TextUtils.isEmpty(paramConfig)) && (!TextUtils.isEmpty(str3)))
        {
          localEditor.putBoolean("open", true);
          localEditor.putString("icon_url", paramConfig);
          localEditor.putString("night_icon_url", str2);
          localEditor.putString("jump_url", str3);
          localEditor.putString("word", (String)localObject);
          SharedPreUtils.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString, j);
          localEditor.commit();
          return;
        }
        localEditor.putBoolean("open", false);
        localEditor.remove("icon_url");
        localEditor.remove("night_icon_url");
        localEditor.remove("jump_url");
        localEditor.remove("word");
        continue;
      }
      catch (JSONException paramConfig)
      {
        localEditor.clear();
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramConfig = str1;
        if (str1 == null) {
          paramConfig = "";
        }
        QLog.e("zivonchen", 2, new Object[] { "handleTaskEntryConfig json fail. content: ", paramConfig });
        continue;
      }
      localEditor.clear();
    }
  }
  
  public void N(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != DovSVParamManager.a().a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        DovSVParamManager.a().a(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void O(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != QIMBeautyManager.a().a(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        QIMBeautyManager.a().a(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void P(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      localObject1 = a(paramConfig);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        localObject1 = (String)((List)localObject1).get(0);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        try
        {
          paramConfig = new JSONObject((String)localObject1);
          if (paramConfig.has("jump_url"))
          {
            paramConfig = paramConfig.getJSONObject("jump_url");
            if (paramConfig.has("android"))
            {
              Object localObject2 = new JSONObject(paramConfig.getString("android"));
              if ((((JSONObject)localObject2).has("url")) && (((JSONObject)localObject2).has("scheme")))
              {
                paramConfig = ((JSONObject)localObject2).getString("scheme");
                localObject2 = ((JSONObject)localObject2).getString("url");
                paramConfig = paramConfig + Base64Util.encodeToString(((String)localObject2).getBytes(), 0);
                SharedPreUtils.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
                if (QLog.isColorLevel()) {
                  QLog.e("SPLASH_ConfigServlet", 2, new Object[] { "handleBuluoEnterConfig. buluoEntryUrl: ", paramConfig });
                }
              }
            }
          }
          for (;;)
          {
            SharedPreUtils.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString, i);
            return;
            if (paramConfig.has("tribe_summary_url"))
            {
              paramConfig = paramConfig.optJSONObject("tribe_summary_url");
              if (paramConfig.has("android"))
              {
                paramConfig = paramConfig.optString("android");
                SharedPreUtils.d(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
              }
            }
          }
        }
        catch (JSONException paramConfig)
        {
          for (;;)
          {
            Object localObject1;
            if (QLog.isColorLevel())
            {
              paramConfig = (ConfigurationService.Config)localObject1;
              if (localObject1 == null) {
                paramConfig = "";
              }
              QLog.e("SPLASH_ConfigServlet", 2, new Object[] { "handleBuluoEnterConfig json fail. content: ", paramConfig });
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig json fail. configContent is empty ,version: " + paramConfig.version.get());
      return;
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig:localVersion == version = " + i);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ConfigurationService.Config paramConfig, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] ENTER success=" + paramBoolean + " result=" + paramInt);
    }
    int j = 0;
    int i = 2;
    String str = paramIntent.getStringExtra("uin");
    int k;
    if ((paramBoolean) && (paramConfig != null) && (paramConfig.type.get() == 109)) {
      if (paramInt == 0)
      {
        k = paramConfig.version.get();
        int m = paramIntent.getIntExtra("qcamera_conf_version", 0);
        QLog.i("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] reqVersion=" + m + " receiveVersion=" + k);
        paramInt = i;
        i = j;
        if (k != m)
        {
          CameraUtils.a(BaseApplicationImpl.getContext(), k);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] save version: " + k + " and check config version: " + CameraUtils.a(BaseApplicationImpl.getContext()));
          }
          if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
            break label560;
          }
          paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          i = paramIntent.task_id.get();
          if (paramIntent.compress.get() != 1) {
            break label506;
          }
          paramIntent = CameraUtils.a(paramIntent.content.get().toByteArray());
          if (paramIntent == null)
          {
            paramInt = 4;
            CameraUtils.a(BaseApplicationImpl.getContext(), true);
            QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] uncompress failed");
          }
        }
        else
        {
          j = paramInt;
          paramInt = k;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          QLog.i("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] rptResult=" + j);
          paramIntent = new HashMap();
          paramIntent.put("rpt_type", String.valueOf(109));
          paramIntent.put("rpt_task_id", String.valueOf(k));
          paramIntent.put("rpt_req_version", String.valueOf(i));
          paramIntent.put("rpt_version", String.valueOf(paramInt));
          paramIntent.put("rpt_report_type", String.valueOf(1));
          paramIntent.put("rpt_result", String.valueOf(j));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "qcamera_phone_config_pull_event", paramBoolean, 0L, 0L, paramIntent, String.valueOf(j));
          return;
          paramInt = 0;
          paramIntent = new String(paramIntent);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig] zip");
          }
          try
          {
            CameraUtils.a(BaseApplicationImpl.getContext(), paramIntent, k);
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            paramInt = 3;
          }
        }
        break;
        label506:
        paramIntent = paramIntent.content.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig]");
        }
        try
        {
          CameraUtils.a(BaseApplicationImpl.getContext(), paramIntent, k);
          paramInt = 0;
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          paramInt = 3;
        }
      }
      break;
      label560:
      paramInt = 5;
      QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] no data, current disableCameraSDK=" + CameraUtils.a(BaseApplicationImpl.getContext()));
      i = j;
      break;
      paramInt = 0;
      j = 1;
      k = 0;
      i = 0;
      continue;
      paramInt = 0;
      j = 1;
      k = 0;
      i = 0;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig |  type= " + paramConfig.type.get());
    }
    ARGlobalConfigManager localARGlobalConfigManager = (ARGlobalConfigManager)paramQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    int i;
    if (paramConfig.type.get() == 206)
    {
      i = paramConfig.version.get();
      if (paramIntent.getIntExtra("ar_scan_star_face_config_version", 0) == i) {
        break label347;
      }
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label319;
      }
      paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramQQAppInterface == null) {
        break label301;
      }
      if (paramQQAppInterface.compress.get() != 1) {
        break label287;
      }
      paramIntent = OlympicUtil.a(paramQQAppInterface.content.get().toByteArray());
      if (paramIntent == null) {
        break label365;
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new String(paramIntent, "UTF-8");
        if (paramQQAppInterface != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig, config_content is " + paramQQAppInterface);
          }
          i = paramConfig.version.get();
          if (localARGlobalConfigManager.b(paramQQAppInterface)) {
            localARGlobalConfigManager.b(i);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig, config type 206");
        }
        return;
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          paramQQAppInterface.printStackTrace();
        }
        paramQQAppInterface = null;
        continue;
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          paramQQAppInterface.printStackTrace();
        }
        System.gc();
        try
        {
          paramQQAppInterface = new String(paramIntent, "UTF-8");
        }
        catch (Throwable paramQQAppInterface)
        {
          paramQQAppInterface = null;
        }
        continue;
      }
      label287:
      paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
      continue;
      label301:
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig, content is null");
        continue;
        label319:
        if (localARGlobalConfigManager != null) {
          localARGlobalConfigManager.c();
        }
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig we delete ARConfig info here");
          continue;
          label347:
          if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig, version same");
            continue;
            label365:
            paramQQAppInterface = null;
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Intent paramIntent, boolean paramBoolean, ConfigurationService.Config paramConfig, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, success=", Boolean.valueOf(paramBoolean) });
    }
    int m = 0;
    int j = 2;
    OlympicActConfig localOlympicActConfig;
    label297:
    int i;
    if ((paramBoolean) && (paramConfig != null) && (paramConfig.type.get() == 86))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, result=", Integer.valueOf(paramInt) });
      }
      if (paramInt == 0)
      {
        int k = paramConfig.version.get();
        paramInt = paramIntent.getIntExtra("config_version", 0);
        if (QLog.isColorLevel()) {
          QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, reqVersion=", Integer.valueOf(paramInt), ", receiveVersion=", Integer.valueOf(k) });
        }
        if (k != paramInt) {
          if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
          {
            paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
            if (paramIntent != null)
            {
              j = paramIntent.task_id.get();
              if (paramIntent.compress.get() == 1)
              {
                paramConfig = OlympicUtil.a(paramIntent.content.get().toByteArray());
                if (paramConfig == null)
                {
                  paramInt = 4;
                  paramIntent = null;
                  if (QLog.isColorLevel()) {
                    QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, xmlContent=", paramIntent });
                  }
                  localOlympicActConfig = OlympicActConfig.parse(paramQQAppInterface, paramIntent);
                  if (QLog.isColorLevel())
                  {
                    if (localOlympicActConfig != null) {
                      break label514;
                    }
                    paramConfig = "null";
                    QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, newConfig=", paramConfig });
                  }
                  if (localOlympicActConfig == null) {
                    break label548;
                  }
                  i = 0;
                  localOlympicActConfig.version = k;
                  paramIntent = (OlympicManager)paramQQAppInterface.getManager(QQManagerFactory.OLYMPIC_MANAGER);
                  if (paramIntent == null) {
                    break label521;
                  }
                  paramIntent.a(localOlympicActConfig);
                  paramInt = i;
                  label359:
                  i = paramInt;
                  paramInt = j;
                  label367:
                  j = i;
                  i = paramInt;
                  paramInt = k;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        OlympicServlet.a(paramQQAppInterface, 86, paramInt, i, 1, j, -1);
        paramQQAppInterface = (OlympicManager)paramQQAppInterface.getManager(QQManagerFactory.OLYMPIC_MANAGER);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface.g();
          paramQQAppInterface.f();
        }
        return;
        try
        {
          paramIntent = new String(paramConfig, "UTF-8");
          paramInt = 2;
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          if (QLog.isColorLevel()) {
            paramIntent.printStackTrace();
          }
          paramIntent = null;
          paramInt = 2;
        }
        catch (OutOfMemoryError paramIntent)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              paramIntent.printStackTrace();
            }
            System.gc();
            try
            {
              paramIntent = new String(paramConfig, "UTF-8");
              paramInt = 2;
            }
            catch (Throwable paramIntent)
            {
              paramIntent = null;
              paramInt = 2;
            }
          }
        }
      }
      break;
      paramIntent = paramIntent.content.get().toStringUtf8();
      paramInt = 2;
      break;
      label514:
      paramConfig = localOlympicActConfig;
      break label297;
      label521:
      paramInt = i;
      if (!QLog.isColorLevel()) {
        break label359;
      }
      QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, manager is null!");
      paramInt = i;
      break label359;
      label548:
      i = paramInt;
      if (paramIntent != null) {
        i = 5;
      }
      paramInt = i;
      if (!QLog.isColorLevel()) {
        break label359;
      }
      QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, parse failed, newConfig is null!");
      paramInt = i;
      break label359;
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, content is null");
      }
      paramInt = 0;
      i = j;
      break label367;
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, msg_content_list is null");
      }
      paramIntent = (OlympicManager)paramQQAppInterface.getManager(QQManagerFactory.OLYMPIC_MANAGER);
      if (paramIntent != null) {
        paramIntent.e();
      }
      OlympicActConfig.deleteFile(paramQQAppInterface, BaseApplicationImpl.getContext());
      paramInt = m;
      i = j;
      break label367;
      paramInt = m;
      i = j;
      if (!QLog.isColorLevel()) {
        break label367;
      }
      QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, has same version");
      paramInt = m;
      i = j;
      break label367;
      j = 1;
      i = 0;
      paramInt = 0;
      continue;
      j = 1;
      i = 0;
      paramInt = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            String str = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 79,content: " + str + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j != SharedPreUtils.M(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) || (paramConfig.content_list.size() > 0))
            {
              str = str.split("=")[1];
              if (!TextUtils.isEmpty(str)) {
                ReadInJoyHelper.c(str, paramQQAppInterface);
              }
              SharedPreUtils.o(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin());
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_MERGE_CONFIG_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy merge config error,cmd : 79" + paramQQAppInterface.toString());
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 79,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString, ConfigServlet.IHandleConfigCallback paramIHandleConfigCallback)
  {
    int j = paramConfig.version.get();
    int i = paramIHandleConfigCallback.a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, paramString + ", serverVersion=" + j + "|localVersion=" + i);
    }
    if ((j != i) && (paramConfig.msg_content_list.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramConfig.msg_content_list.size();
      i = 0;
      if (i < k)
      {
        paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        byte[] arrayOfByte;
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.compress.get() != 1) {
            break label271;
          }
          arrayOfByte = OlympicUtil.a(paramQQAppInterface.content.get().toByteArray());
          if (arrayOfByte == null) {
            break label266;
          }
        }
        for (;;)
        {
          try
          {
            paramQQAppInterface = new String(arrayOfByte, "UTF-8");
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              localArrayList.add(paramQQAppInterface);
            }
            i += 1;
          }
          catch (Exception paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.w("SPLASH_ConfigServlet", 2, paramString, paramQQAppInterface);
            }
            paramQQAppInterface = null;
            continue;
          }
          catch (OutOfMemoryError paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.w("SPLASH_ConfigServlet", 2, paramString, paramQQAppInterface);
            }
            System.gc();
            try
            {
              paramQQAppInterface = new String(arrayOfByte, "UTF-8");
            }
            catch (Throwable paramQQAppInterface)
            {
              if (QLog.isColorLevel()) {
                QLog.w("SPLASH_ConfigServlet", 2, paramString, paramQQAppInterface);
              }
            }
          }
          label266:
          paramQQAppInterface = null;
          continue;
          label271:
          paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
        }
      }
      if (localArrayList.size() <= 0) {
        break label314;
      }
      paramIHandleConfigCallback.a(j);
      paramIHandleConfigCallback.a(localArrayList);
    }
    label314:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, paramString + ", config_content is empty");
  }
  
  public void a(ConfigurationService.RespGetConfig paramRespGetConfig)
  {
    PatchConfigServlet.a(paramRespGetConfig.min_req_interval_for_reconnect.get());
  }
  
  public void a(AppRuntime paramAppRuntime, Intent paramIntent, ConfigurationService.ReqGetConfig paramReqGetConfig, int[] paramArrayOfInt, List<ConfigurationService.ConfigSeq> paramList, List<Integer> paramList1, String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    a((QQAppInterface)paramAppRuntime, paramIntent, paramReqGetConfig, paramArrayOfInt, paramList, paramList1);
  }
  
  /* Error */
  public void a(AppRuntime paramAppRuntime, ConfigurationService.RespGetConfig paramRespGetConfig, Intent paramIntent, List<Integer> paramList, int[] paramArrayOfInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 143	com/tencent/mobileqq/app/QQAppInterface
    //   4: astore 14
    //   6: aload_2
    //   7: getfield 4830	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   10: invokevirtual 386	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   13: istore 10
    //   15: aconst_null
    //   16: astore_1
    //   17: iconst_0
    //   18: istore 11
    //   20: iconst_0
    //   21: istore 7
    //   23: iload 7
    //   25: iload 10
    //   27: if_icmpge +7875 -> 7902
    //   30: aload_2
    //   31: getfield 4830	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   34: iload 7
    //   36: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   39: checkcast 47	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   42: astore 13
    //   44: aload 13
    //   46: ifnonnull +26 -> 72
    //   49: iload 11
    //   51: istore 12
    //   53: aload_1
    //   54: astore 5
    //   56: iload 7
    //   58: iconst_1
    //   59: iadd
    //   60: istore 7
    //   62: aload 5
    //   64: astore_1
    //   65: iload 12
    //   67: istore 11
    //   69: goto -46 -> 23
    //   72: aload_1
    //   73: astore 5
    //   75: iload 11
    //   77: istore 12
    //   79: aload 13
    //   81: getfield 2580	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   84: invokevirtual 4831	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   87: ifeq -31 -> 56
    //   90: aload 13
    //   92: getfield 2580	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   95: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   98: istore 8
    //   100: aload_1
    //   101: astore 5
    //   103: iload 11
    //   105: istore 12
    //   107: invokestatic 4834	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   110: iload 8
    //   112: invokevirtual 4836	com/tencent/mobileqq/config/QConfigManager:b	(I)Z
    //   115: ifne -59 -> 56
    //   118: aload 4
    //   120: iload 8
    //   122: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: invokeinterface 4838 2 0
    //   130: pop
    //   131: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +41 -> 175
    //   137: ldc 77
    //   139: iconst_2
    //   140: new 79	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 4840
    //   150: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload 8
    //   155: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: ldc_w 4842
    //   161: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: iload 10
    //   166: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: iload 8
    //   177: lookupswitch	default:+1355->1532, 1:+2829->3006, 2:+3229->3406, 3:+3707->3884, 5:+3943->4120, 6:+6052->6229, 10:+4780->4957, 12:+4154->4331, 13:+5053->5230, 23:+5282->5459, 31:+5130->5307, 34:+5108->5285, 38:+5406->5583, 42:+5832->6009, 43:+6030->6207, 44:+2406->2583, 46:+5854->6031, 47:+2594->2771, 49:+5843->6020, 50:+5865->6042, 53:+5294->5471, 55:+4472->4649, 56:+5876->6053, 61:+5887->6064, 63:+5909->6086, 64:+5920->6097, 65:+2783->2960, 66:+5931->6108, 69:+5964->6141, 72:+5942->6119, 73:+5953->6130, 74:+5975->6152, 75:+5986->6163, 78:+5306->5483, 79:+6095->6272, 80:+6073->6250, 82:+6106->6283, 84:+5318->5495, 86:+6324->6501, 87:+6345->6522, 88:+6357->6534, 90:+6117->6294, 93:+5619->5796, 96:+6405->6582, 97:+6416->6593, 101:+5072->5249, 102:+5119->5296, 109:+6453->6630, 111:+6084->6261, 113:+6041->6218, 115:+5084->5261, 116:+1768->1945, 118:+6472->6649, 119:+6527->6704, 121:+6538->6715, 129:+6505->6682, 130:+6560->6737, 139:+5354->5531, 140:+6590->6767, 142:+6483->6660, 143:+6516->6693, 145:+6634->6811, 146:+6442->6619, 147:+6313->6490, 148:+5898->6075, 149:+6427->6604, 153:+6623->6800, 155:+6646->6823, 156:+7924->8101, 157:+6549->6726, 165:+6668->6845, 166:+6679->6856, 167:+5342->5519, 171:+6703->6880, 174:+6758->6935, 177:+6812->6989, 180:+6427->6604, 181:+6725->6902, 182:+6790->6967, 184:+6714->6891, 185:+6867->7044, 187:+6823->7000, 188:+6369->6546, 190:+6990->7167, 191:+6856->7033, 193:+1372->1549, 194:+6657->6834, 195:+6834->7011, 199:+6888->7065, 201:+6494->6671, 202:+6979->7156, 204:+7266->7443, 205:+6393->6570, 206:+6381->6558, 210:+7001->7178, 211:+6579->6756, 212:+7012->7189, 215:+7062->7239, 218:+6427->6604, 222:+7104->7281, 223:+5387->5564, 225:+6932->7109, 226:+5330->5507, 227:+6845->7022, 228:+6008->6185, 232:+6571->6748, 234:+7134->7311, 235:+7145->7322, 238:+7156->7333, 244:+7167->7344, 245:+7178->7355, 247:+6736->6913, 253:+7189->7366, 254:+7211->7388, 256:+6019->6196, 257:+6601->6778, 259:+7222->7399, 260:+6612->6789, 262:+7233->7410, 267:+7277->7454, 268:+7244->7421, 269:+7255->7432, 272:+6747->6924, 273:+6769->6946, 274:+7288->7465, 279:+7298->7475, 280:+7402->7579, 281:+7413->7590, 283:+7424->7601, 284:+7435->7612, 286:+5096->5273, 289:+7461->7638, 295:+7200->7377, 297:+7472->7649, 301:+7446->7623, 308:+7322->7499, 312:+7359->7536, 313:+7346->7523, 314:+7504->7681, 320:+7526->7703, 321:+6878->7055, 328:+6779->6956, 329:+5365->5542, 331:+7550->7727, 336:+7561->7738, 337:+7484->7661, 345:+7571->7748, 347:+7515->7692, 349:+7583->7760, 351:+5376->5553, 364:+5387->5564, 365:+5387->5564, 371:+6801->6978, 384:+7620->7797, 385:+5997->6174, 386:+7641->7818, 387:+7630->7807, 392:+7660->7837, 393:+7671->7848, 394:+7690->7867, 397:+7378->7555, 400:+7607->7784, 403:+7022->7199, 404:+7052->7229, 410:+7701->7878, 596:+7714->7891, 604:+7032->7209, 705:+7043->7220, 718:+7083->7260
    //   1533: dconst_0
    //   1534: invokevirtual 1012	com/tencent/mobileqq/app/QQAppInterface:getConfigProcess	()Lcom/tencent/mobileqq/config/CfgProcess;
    //   1537: aload 14
    //   1539: aload 13
    //   1541: iload 8
    //   1543: invokevirtual 4844	com/tencent/mobileqq/config/CfgProcess:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   1546: goto +6467 -> 8013
    //   1549: aload 13
    //   1551: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1554: ifnull +6459 -> 8013
    //   1557: aload 13
    //   1559: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1562: invokevirtual 386	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1565: ifle +6448 -> 8013
    //   1568: aload 13
    //   1570: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1573: iconst_0
    //   1574: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1577: checkcast 391	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   1580: astore 5
    //   1582: aload 5
    //   1584: ifnull +336 -> 1920
    //   1587: aload 5
    //   1589: getfield 395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1592: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1595: iconst_1
    //   1596: if_icmpne +228 -> 1824
    //   1599: aload 5
    //   1601: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1604: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1607: invokevirtual 413	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1610: invokestatic 418	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   1613: astore 15
    //   1615: aload 15
    //   1617: ifnull +6390 -> 8007
    //   1620: new 126	java/lang/String
    //   1623: dup
    //   1624: aload 15
    //   1626: ldc_w 420
    //   1629: invokespecial 423	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1632: astore 5
    //   1634: aload 5
    //   1636: ifnull +6365 -> 8001
    //   1639: aload 13
    //   1641: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1644: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1647: istore 8
    //   1649: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1652: ifeq +42 -> 1694
    //   1655: ldc_w 1534
    //   1658: iconst_2
    //   1659: new 79	java/lang/StringBuilder
    //   1662: dup
    //   1663: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1666: ldc_w 4846
    //   1669: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1672: iload 8
    //   1674: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1677: ldc_w 4848
    //   1680: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: aload 5
    //   1685: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1691: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1694: aload 5
    //   1696: invokestatic 4853	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;
    //   1699: astore 13
    //   1701: aload 13
    //   1703: astore_1
    //   1704: aload 14
    //   1706: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1709: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1712: iload 8
    //   1714: invokestatic 4855	com/tencent/mobileqq/utils/SharedPreUtils:q	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1717: aload 14
    //   1719: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1722: ldc_w 4382
    //   1725: invokestatic 4385	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   1728: ifne +112 -> 1840
    //   1731: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1734: ifeq +13 -> 1747
    //   1737: ldc_w 1534
    //   1740: iconst_2
    //   1741: ldc_w 4857
    //   1744: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1747: aload 5
    //   1749: invokestatic 4858	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)V
    //   1752: aload 14
    //   1754: aload_1
    //   1755: invokestatic 4861	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   1758: aload_1
    //   1759: astore 5
    //   1761: aload 5
    //   1763: astore_1
    //   1764: goto +6249 -> 8013
    //   1767: astore 5
    //   1769: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1772: ifeq +6251 -> 8023
    //   1775: aload 5
    //   1777: invokevirtual 2814	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   1780: goto +6243 -> 8023
    //   1783: astore 5
    //   1785: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1788: ifeq +8 -> 1796
    //   1791: aload 5
    //   1793: invokevirtual 2815	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1796: invokestatic 446	java/lang/System:gc	()V
    //   1799: new 126	java/lang/String
    //   1802: dup
    //   1803: aload 15
    //   1805: ldc_w 420
    //   1808: invokespecial 423	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1811: astore 5
    //   1813: goto -179 -> 1634
    //   1816: astore 5
    //   1818: aconst_null
    //   1819: astore 5
    //   1821: goto -187 -> 1634
    //   1824: aload 5
    //   1826: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1829: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1832: invokevirtual 449	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1835: astore 5
    //   1837: goto -203 -> 1634
    //   1840: aload_1
    //   1841: astore 5
    //   1843: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1846: ifeq -85 -> 1761
    //   1849: ldc_w 1534
    //   1852: iconst_2
    //   1853: ldc_w 4863
    //   1856: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1859: aload_1
    //   1860: astore 5
    //   1862: goto -101 -> 1761
    //   1865: astore 13
    //   1867: aload_1
    //   1868: astore 5
    //   1870: iload 11
    //   1872: istore 12
    //   1874: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1877: ifeq -1821 -> 56
    //   1880: ldc 77
    //   1882: iconst_2
    //   1883: new 79	java/lang/StringBuilder
    //   1886: dup
    //   1887: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1890: ldc_w 4865
    //   1893: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1896: aload 13
    //   1898: invokevirtual 2031	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1901: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1904: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1907: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1910: aload_1
    //   1911: astore 5
    //   1913: iload 11
    //   1915: istore 12
    //   1917: goto -1861 -> 56
    //   1920: aload_1
    //   1921: astore 5
    //   1923: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1926: ifeq -165 -> 1761
    //   1929: ldc_w 1534
    //   1932: iconst_2
    //   1933: ldc_w 4867
    //   1936: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1939: aload_1
    //   1940: astore 5
    //   1942: goto -181 -> 1761
    //   1945: aload 14
    //   1947: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1950: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1953: invokestatic 1512	com/tencent/mobileqq/utils/SharedPreUtils:I	(Landroid/content/Context;Ljava/lang/String;)I
    //   1956: istore 8
    //   1958: aload 13
    //   1960: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1963: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1966: istore 9
    //   1968: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1971: ifeq +35 -> 2006
    //   1974: ldc 77
    //   1976: iconst_2
    //   1977: ldc_w 4869
    //   1980: iconst_2
    //   1981: anewarray 4	java/lang/Object
    //   1984: dup
    //   1985: iconst_0
    //   1986: iload 8
    //   1988: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1991: aastore
    //   1992: dup
    //   1993: iconst_1
    //   1994: iload 9
    //   1996: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1999: aastore
    //   2000: invokestatic 534	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2003: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2006: aconst_null
    //   2007: astore 5
    //   2009: iload 8
    //   2011: iload 9
    //   2013: if_icmpeq +395 -> 2408
    //   2016: aload 13
    //   2018: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2021: ifnull +14 -> 2035
    //   2024: aload 13
    //   2026: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2029: invokevirtual 4870	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   2032: ifeq +294 -> 2326
    //   2035: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2038: ifeq +12 -> 2050
    //   2041: ldc 77
    //   2043: iconst_2
    //   2044: ldc_w 4872
    //   2047: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2050: ldc_w 4874
    //   2053: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2056: invokestatic 4879	com/tencent/mobileqq/upgrade/UpgradeConfigManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2059: pop
    //   2060: aload 14
    //   2062: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   2065: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2068: iload 9
    //   2070: invokestatic 4881	com/tencent/mobileqq/utils/SharedPreUtils:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   2073: aload 14
    //   2075: getstatic 1527	com/tencent/mobileqq/app/BusinessHandlerFactory:CONFIG_HANDLER	Ljava/lang/String;
    //   2078: invokevirtual 1323	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2081: checkcast 1529	com/tencent/mobileqq/app/ConfigHandler
    //   2084: astore 15
    //   2086: aload 5
    //   2088: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2091: ifne +473 -> 2564
    //   2094: invokestatic 4886	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeController;
    //   2097: invokevirtual 4889	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   2100: astore 13
    //   2102: aload 13
    //   2104: aload 5
    //   2106: invokevirtual 4892	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   2109: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2112: ifeq +42 -> 2154
    //   2115: ldc 77
    //   2117: iconst_2
    //   2118: ldc_w 4894
    //   2121: iconst_2
    //   2122: anewarray 4	java/lang/Object
    //   2125: dup
    //   2126: iconst_0
    //   2127: invokestatic 1263	com/tencent/common/config/AppSetting:a	()I
    //   2130: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2133: aastore
    //   2134: dup
    //   2135: iconst_1
    //   2136: aload 13
    //   2138: getfield 4897	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   2141: getfield 4902	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   2144: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2147: aastore
    //   2148: invokestatic 534	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2151: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2154: aload 14
    //   2156: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2159: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2162: invokestatic 4904	com/tencent/mobileqq/utils/SharedPreUtils:aO	(Landroid/content/Context;Ljava/lang/String;)I
    //   2165: aload 13
    //   2167: getfield 4897	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   2170: getfield 4902	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   2173: if_icmpeq +78 -> 2251
    //   2176: aload 14
    //   2178: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2181: aload 14
    //   2183: invokevirtual 1293	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   2186: iconst_0
    //   2187: invokestatic 4906	com/tencent/mobileqq/utils/SharedPreUtils:af	(Landroid/content/Context;Ljava/lang/String;I)V
    //   2190: aload 14
    //   2192: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2195: aload 14
    //   2197: invokevirtual 1293	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   2200: lconst_0
    //   2201: invokestatic 4909	com/tencent/mobileqq/utils/SharedPreUtils:j	(Landroid/content/Context;Ljava/lang/String;J)V
    //   2204: aload 14
    //   2206: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2209: aload 14
    //   2211: invokevirtual 1293	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   2214: iconst_0
    //   2215: invokestatic 4911	com/tencent/mobileqq/utils/SharedPreUtils:ag	(Landroid/content/Context;Ljava/lang/String;I)V
    //   2218: aload 14
    //   2220: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2223: aload 14
    //   2225: invokevirtual 1293	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   2228: lconst_0
    //   2229: invokestatic 4913	com/tencent/mobileqq/utils/SharedPreUtils:k	(Landroid/content/Context;Ljava/lang/String;J)V
    //   2232: aload 14
    //   2234: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2237: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2240: aload 13
    //   2242: getfield 4897	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   2245: getfield 4902	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   2248: invokestatic 4915	com/tencent/mobileqq/utils/SharedPreUtils:ae	(Landroid/content/Context;Ljava/lang/String;I)V
    //   2251: invokestatic 1263	com/tencent/common/config/AppSetting:a	()I
    //   2254: aload 13
    //   2256: getfield 4897	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   2259: getfield 4902	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   2262: if_icmplt +167 -> 2429
    //   2265: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2268: ifeq +12 -> 2280
    //   2271: ldc 77
    //   2273: iconst_2
    //   2274: ldc_w 4917
    //   2277: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2280: aload 14
    //   2282: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2285: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2288: iconst_0
    //   2289: invokestatic 4881	com/tencent/mobileqq/utils/SharedPreUtils:p	(Landroid/content/Context;Ljava/lang/String;I)V
    //   2292: ldc_w 4874
    //   2295: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2298: invokestatic 4879	com/tencent/mobileqq/upgrade/UpgradeConfigManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2301: pop
    //   2302: aload 13
    //   2304: getfield 4897	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   2307: iconst_0
    //   2308: putfield 4920	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   2311: aload 15
    //   2313: aload 13
    //   2315: invokevirtual 4923	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   2318: aload 15
    //   2320: invokevirtual 4924	com/tencent/mobileqq/app/ConfigHandler:d	()V
    //   2323: goto +5690 -> 8013
    //   2326: aload 13
    //   2328: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2331: iconst_0
    //   2332: invokevirtual 460	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   2335: checkcast 126	java/lang/String
    //   2338: astore 5
    //   2340: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2343: ifeq +30 -> 2373
    //   2346: ldc 77
    //   2348: iconst_2
    //   2349: new 79	java/lang/StringBuilder
    //   2352: dup
    //   2353: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   2356: ldc_w 4926
    //   2359: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2362: aload 5
    //   2364: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2367: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2370: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2373: aload 5
    //   2375: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2378: ifeq +16 -> 2394
    //   2381: ldc_w 4874
    //   2384: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2387: invokestatic 4879	com/tencent/mobileqq/upgrade/UpgradeConfigManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2390: pop
    //   2391: goto -331 -> 2060
    //   2394: ldc_w 4874
    //   2397: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2400: aload 5
    //   2402: invokestatic 4929	com/tencent/mobileqq/upgrade/UpgradeConfigManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2405: goto -345 -> 2060
    //   2408: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2411: ifeq +12 -> 2423
    //   2414: ldc 77
    //   2416: iconst_2
    //   2417: ldc_w 4931
    //   2420: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2423: aconst_null
    //   2424: astore 5
    //   2426: goto -353 -> 2073
    //   2429: aload 14
    //   2431: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   2434: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2437: invokestatic 2155	java/lang/System:currentTimeMillis	()J
    //   2440: invokestatic 4933	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;J)V
    //   2443: aload 13
    //   2445: monitorenter
    //   2446: aload 13
    //   2448: getfield 4934	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   2451: ifne +27 -> 2478
    //   2454: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2457: ifeq +12 -> 2469
    //   2460: ldc 77
    //   2462: iconst_2
    //   2463: ldc_w 4936
    //   2466: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2469: aload 13
    //   2471: monitorexit
    //   2472: iconst_1
    //   2473: istore 11
    //   2475: goto +5538 -> 8013
    //   2478: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2481: ifeq +12 -> 2493
    //   2484: ldc 77
    //   2486: iconst_2
    //   2487: ldc_w 4938
    //   2490: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2493: aload 13
    //   2495: getfield 4939	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   2498: ifne +22 -> 2520
    //   2501: aload 13
    //   2503: getfield 4940	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   2506: iconst_1
    //   2507: if_icmpne +5527 -> 8034
    //   2510: iconst_1
    //   2511: istore 11
    //   2513: aload 14
    //   2515: iload 11
    //   2517: invokestatic 4941	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   2520: aload 15
    //   2522: invokevirtual 4924	com/tencent/mobileqq/app/ConfigHandler:d	()V
    //   2525: invokestatic 4886	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeController;
    //   2528: aload 13
    //   2530: getfield 4897	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   2533: aload 15
    //   2535: invokevirtual 4944	com/tencent/mobileqq/upgrade/UpgradeController:a	(Lprotocol/KQQConfig/UpgradeInfo;Lcom/tencent/mobileqq/upgrade/UpgradeController$OnHandleUpgradeFinishListener;)Z
    //   2538: pop
    //   2539: aload 13
    //   2541: monitorexit
    //   2542: iconst_1
    //   2543: istore 11
    //   2545: goto +5468 -> 8013
    //   2548: astore 5
    //   2550: aload 13
    //   2552: monitorexit
    //   2553: aload 5
    //   2555: athrow
    //   2556: astore 13
    //   2558: iconst_1
    //   2559: istore 11
    //   2561: goto -694 -> 1867
    //   2564: aload 15
    //   2566: invokevirtual 4924	com/tencent/mobileqq/app/ConfigHandler:d	()V
    //   2569: aload 15
    //   2571: invokestatic 4886	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeController;
    //   2574: invokevirtual 4889	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   2577: invokevirtual 4923	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   2580: goto +5433 -> 8013
    //   2583: aload 13
    //   2585: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2588: ifnull +141 -> 2729
    //   2591: aload 13
    //   2593: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2596: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   2599: ifle +130 -> 2729
    //   2602: aload 14
    //   2604: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   2607: aload 13
    //   2609: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2612: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2615: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2618: invokestatic 4946	com/tencent/mobileqq/utils/SharedPreUtils:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   2621: iconst_0
    //   2622: istore 8
    //   2624: iload 8
    //   2626: aload 13
    //   2628: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2631: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   2634: if_icmpge +5415 -> 8049
    //   2637: aload 13
    //   2639: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2642: iload 8
    //   2644: invokevirtual 460	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   2647: checkcast 126	java/lang/String
    //   2650: astore 5
    //   2652: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2655: ifeq +47 -> 2702
    //   2658: ldc 77
    //   2660: iconst_2
    //   2661: new 79	java/lang/StringBuilder
    //   2664: dup
    //   2665: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   2668: ldc_w 4948
    //   2671: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2674: aload 5
    //   2676: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2679: ldc_w 467
    //   2682: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2685: aload 13
    //   2687: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2690: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2693: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2696: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2699: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2702: aload 5
    //   2704: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2707: ifne +5333 -> 8040
    //   2710: aload 14
    //   2712: getstatic 3952	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   2715: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2718: checkcast 3954	com/tencent/mobileqq/app/HotChatManager
    //   2721: aload 5
    //   2723: invokevirtual 4950	com/tencent/mobileqq/app/HotChatManager:d	(Ljava/lang/String;)V
    //   2726: goto +5314 -> 8040
    //   2729: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2732: ifeq +5281 -> 8013
    //   2735: ldc 77
    //   2737: iconst_2
    //   2738: new 79	java/lang/StringBuilder
    //   2741: dup
    //   2742: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   2745: ldc_w 4952
    //   2748: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2751: aload 13
    //   2753: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2756: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2759: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2762: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2765: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2768: goto +5245 -> 8013
    //   2771: aload 13
    //   2773: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2776: ifnull +142 -> 2918
    //   2779: aload 13
    //   2781: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2784: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   2787: ifle +131 -> 2918
    //   2790: aload 14
    //   2792: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   2795: aload 13
    //   2797: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2800: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2803: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2806: invokestatic 4954	com/tencent/mobileqq/utils/SharedPreUtils:c	(Landroid/content/Context;ILjava/lang/String;)V
    //   2809: iconst_0
    //   2810: istore 8
    //   2812: iload 8
    //   2814: aload 13
    //   2816: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2819: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   2822: if_icmpge +5239 -> 8061
    //   2825: aload 13
    //   2827: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2830: iload 8
    //   2832: invokevirtual 460	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   2835: checkcast 126	java/lang/String
    //   2838: astore 5
    //   2840: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2843: ifeq +47 -> 2890
    //   2846: ldc 77
    //   2848: iconst_2
    //   2849: new 79	java/lang/StringBuilder
    //   2852: dup
    //   2853: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   2856: ldc_w 4956
    //   2859: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2862: aload 5
    //   2864: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2867: ldc_w 467
    //   2870: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2873: aload 13
    //   2875: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2878: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2881: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2884: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2887: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2890: aload 5
    //   2892: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2895: ifne +5157 -> 8052
    //   2898: aload 14
    //   2900: getstatic 4959	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	Ljava/lang/String;
    //   2903: invokevirtual 1323	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2906: checkcast 4961	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   2909: aload 5
    //   2911: iconst_0
    //   2912: invokevirtual 4962	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(Ljava/lang/String;Z)V
    //   2915: goto +5137 -> 8052
    //   2918: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2921: ifeq +5092 -> 8013
    //   2924: ldc 77
    //   2926: iconst_2
    //   2927: new 79	java/lang/StringBuilder
    //   2930: dup
    //   2931: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   2934: ldc_w 4964
    //   2937: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2940: aload 13
    //   2942: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2945: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2948: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2951: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2954: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2957: goto +5056 -> 8013
    //   2960: aload 13
    //   2962: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2965: ifnull +5048 -> 8013
    //   2968: aload 14
    //   2970: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   2973: aload 13
    //   2975: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2978: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2981: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2984: invokestatic 4966	com/tencent/mobileqq/utils/SharedPreUtils:d	(Landroid/content/Context;ILjava/lang/String;)V
    //   2987: aload 14
    //   2989: getstatic 4959	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	Ljava/lang/String;
    //   2992: invokevirtual 1323	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2995: checkcast 4961	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   2998: aload 13
    //   3000: invokevirtual 4967	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3003: goto +5010 -> 8013
    //   3006: aload 13
    //   3008: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3011: ifnull +276 -> 3287
    //   3014: aload 13
    //   3016: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3019: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   3022: ifle +265 -> 3287
    //   3025: new 2195	java/io/File
    //   3028: dup
    //   3029: new 79	java/lang/StringBuilder
    //   3032: dup
    //   3033: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3036: aload 14
    //   3038: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3041: invokevirtual 3866	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   3044: invokevirtual 2198	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3047: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3050: ldc_w 3929
    //   3053: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3056: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3059: invokespecial 3930	java/io/File:<init>	(Ljava/lang/String;)V
    //   3062: astore 5
    //   3064: aload 5
    //   3066: invokevirtual 3933	java/io/File:exists	()Z
    //   3069: ifne +154 -> 3223
    //   3072: aload 5
    //   3074: invokevirtual 4970	java/io/File:mkdirs	()Z
    //   3077: pop
    //   3078: aload 13
    //   3080: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3083: invokevirtual 886	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   3086: invokeinterface 115 1 0
    //   3091: astore 5
    //   3093: aload 5
    //   3095: invokeinterface 120 1 0
    //   3100: ifeq +4973 -> 8073
    //   3103: aload 5
    //   3105: invokeinterface 124 1 0
    //   3110: checkcast 126	java/lang/String
    //   3113: astore 15
    //   3115: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3118: ifeq +47 -> 3165
    //   3121: ldc 77
    //   3123: iconst_2
    //   3124: new 79	java/lang/StringBuilder
    //   3127: dup
    //   3128: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3131: ldc_w 4972
    //   3134: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3137: aload 15
    //   3139: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3142: ldc_w 467
    //   3145: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3148: aload 13
    //   3150: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3153: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3156: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3159: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3162: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3165: aload_0
    //   3166: aload 14
    //   3168: aload 15
    //   3170: aload 13
    //   3172: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3175: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3178: invokespecial 4974	com/tencent/mobileqq/config/splashlogo/ConfigServlet:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   3181: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3184: ifeq -91 -> 3093
    //   3187: ldc 77
    //   3189: iconst_2
    //   3190: new 79	java/lang/StringBuilder
    //   3193: dup
    //   3194: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3197: ldc_w 4976
    //   3200: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3203: aload 13
    //   3205: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3208: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3211: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3214: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3217: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3220: goto -127 -> 3093
    //   3223: aload 5
    //   3225: ifnull -147 -> 3078
    //   3228: aload 5
    //   3230: invokevirtual 4979	java/io/File:isDirectory	()Z
    //   3233: ifeq -155 -> 3078
    //   3236: aload 5
    //   3238: invokevirtual 4983	java/io/File:listFiles	()[Ljava/io/File;
    //   3241: astore 5
    //   3243: aload 5
    //   3245: arraylength
    //   3246: istore 9
    //   3248: iconst_0
    //   3249: istore 8
    //   3251: iload 8
    //   3253: iload 9
    //   3255: if_icmpge -177 -> 3078
    //   3258: aload 5
    //   3260: iload 8
    //   3262: aaload
    //   3263: astore 15
    //   3265: aload 15
    //   3267: ifnull +4797 -> 8064
    //   3270: aload 15
    //   3272: invokevirtual 3933	java/io/File:exists	()Z
    //   3275: ifeq +4789 -> 8064
    //   3278: aload 15
    //   3280: invokevirtual 3936	java/io/File:delete	()Z
    //   3283: pop
    //   3284: goto +4780 -> 8064
    //   3287: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3290: ifeq +36 -> 3326
    //   3293: ldc 77
    //   3295: iconst_2
    //   3296: new 79	java/lang/StringBuilder
    //   3299: dup
    //   3300: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3303: ldc_w 4985
    //   3306: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3309: aload 13
    //   3311: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3314: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3317: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3320: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3323: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3326: new 2195	java/io/File
    //   3329: dup
    //   3330: new 79	java/lang/StringBuilder
    //   3333: dup
    //   3334: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3337: aload 14
    //   3339: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3342: invokevirtual 3866	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   3345: invokevirtual 2198	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3348: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3351: ldc_w 2200
    //   3354: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3357: ldc_w 4987
    //   3360: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3363: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3366: invokespecial 3930	java/io/File:<init>	(Ljava/lang/String;)V
    //   3369: astore 5
    //   3371: aload 5
    //   3373: ifnull +9 -> 3382
    //   3376: aload 5
    //   3378: invokevirtual 3936	java/io/File:delete	()Z
    //   3381: pop
    //   3382: aload 14
    //   3384: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3387: aload 13
    //   3389: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3392: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3395: ldc_w 4989
    //   3398: ldc 13
    //   3400: invokestatic 3927	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   3403: goto +4610 -> 8013
    //   3406: aload 13
    //   3408: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3411: ifnull +317 -> 3728
    //   3414: aload 13
    //   3416: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3419: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   3422: ifle +306 -> 3728
    //   3425: getstatic 3754	com/tencent/mobileqq/config/Config:a	Lcom/tencent/mobileqq/config/struct/PicAndAdConf;
    //   3428: invokevirtual 4990	com/tencent/mobileqq/config/struct/PicAndAdConf:b	()V
    //   3431: aload 13
    //   3433: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3436: invokevirtual 886	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   3439: invokeinterface 115 1 0
    //   3444: astore 5
    //   3446: aload 5
    //   3448: invokeinterface 120 1 0
    //   3453: ifeq +84 -> 3537
    //   3456: aload 5
    //   3458: invokeinterface 124 1 0
    //   3463: checkcast 126	java/lang/String
    //   3466: astore 15
    //   3468: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3471: ifeq +47 -> 3518
    //   3474: ldc 77
    //   3476: iconst_2
    //   3477: new 79	java/lang/StringBuilder
    //   3480: dup
    //   3481: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3484: ldc_w 4992
    //   3487: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3490: aload 15
    //   3492: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3495: ldc_w 467
    //   3498: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3501: aload 13
    //   3503: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3506: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3509: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3512: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3515: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3518: aload_0
    //   3519: aload 14
    //   3521: aload 15
    //   3523: aload 13
    //   3525: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3528: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3531: invokespecial 4994	com/tencent/mobileqq/config/splashlogo/ConfigServlet:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   3534: goto -88 -> 3446
    //   3537: new 4996	com/tencent/mobileqq/config/ConfigManager
    //   3540: dup
    //   3541: aload 14
    //   3543: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3546: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3549: invokespecial 4998	com/tencent/mobileqq/config/ConfigManager:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   3552: astore 5
    //   3554: aload 5
    //   3556: ifnull +13 -> 3569
    //   3559: aload 5
    //   3561: invokevirtual 4999	com/tencent/mobileqq/config/ConfigManager:b	()V
    //   3564: aload 5
    //   3566: invokevirtual 5000	com/tencent/mobileqq/config/ConfigManager:c	()V
    //   3569: invokestatic 63	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3572: ldc_w 4134
    //   3575: iconst_0
    //   3576: invokevirtual 2390	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   3579: astore 5
    //   3581: aload 5
    //   3583: invokeinterface 2394 1 0
    //   3588: new 79	java/lang/StringBuilder
    //   3591: dup
    //   3592: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3595: ldc_w 5002
    //   3598: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3601: aload 14
    //   3603: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3606: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3609: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3612: iconst_1
    //   3613: invokeinterface 2402 3 0
    //   3618: invokeinterface 2405 1 0
    //   3623: pop
    //   3624: aload 5
    //   3626: invokeinterface 2394 1 0
    //   3631: new 79	java/lang/StringBuilder
    //   3634: dup
    //   3635: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3638: ldc_w 5004
    //   3641: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3644: aload 14
    //   3646: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3649: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3652: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3655: iconst_1
    //   3656: invokeinterface 2402 3 0
    //   3661: invokeinterface 2405 1 0
    //   3666: pop
    //   3667: aload 14
    //   3669: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3672: aload 13
    //   3674: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3677: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3680: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3683: invokestatic 4946	com/tencent/mobileqq/utils/SharedPreUtils:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   3686: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3689: ifeq +4387 -> 8076
    //   3692: ldc 77
    //   3694: iconst_2
    //   3695: new 79	java/lang/StringBuilder
    //   3698: dup
    //   3699: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3702: ldc_w 5006
    //   3705: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3708: aload 13
    //   3710: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3713: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3716: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3719: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3722: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3725: goto +4351 -> 8076
    //   3728: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3731: ifeq +36 -> 3767
    //   3734: ldc 77
    //   3736: iconst_2
    //   3737: new 79	java/lang/StringBuilder
    //   3740: dup
    //   3741: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3744: ldc_w 5008
    //   3747: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3750: aload 13
    //   3752: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3755: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3758: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3761: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3764: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3767: getstatic 3754	com/tencent/mobileqq/config/Config:a	Lcom/tencent/mobileqq/config/struct/PicAndAdConf;
    //   3770: invokevirtual 4990	com/tencent/mobileqq/config/struct/PicAndAdConf:b	()V
    //   3773: getstatic 3754	com/tencent/mobileqq/config/Config:a	Lcom/tencent/mobileqq/config/struct/PicAndAdConf;
    //   3776: invokevirtual 5009	com/tencent/mobileqq/config/struct/PicAndAdConf:c	()V
    //   3779: new 4996	com/tencent/mobileqq/config/ConfigManager
    //   3782: dup
    //   3783: aload 14
    //   3785: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3788: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3791: invokespecial 4998	com/tencent/mobileqq/config/ConfigManager:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   3794: astore 5
    //   3796: aload 5
    //   3798: ifnull +13 -> 3811
    //   3801: aload 5
    //   3803: invokevirtual 4999	com/tencent/mobileqq/config/ConfigManager:b	()V
    //   3806: aload 5
    //   3808: invokevirtual 5000	com/tencent/mobileqq/config/ConfigManager:c	()V
    //   3811: invokestatic 63	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3814: ldc_w 4134
    //   3817: iconst_0
    //   3818: invokevirtual 2390	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   3821: invokeinterface 2394 1 0
    //   3826: new 79	java/lang/StringBuilder
    //   3829: dup
    //   3830: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3833: ldc_w 5004
    //   3836: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3839: aload 14
    //   3841: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3844: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3847: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3850: iconst_0
    //   3851: invokeinterface 2402 3 0
    //   3856: invokeinterface 2405 1 0
    //   3861: pop
    //   3862: aload 14
    //   3864: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3867: aload 13
    //   3869: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3872: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3875: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3878: invokestatic 4946	com/tencent/mobileqq/utils/SharedPreUtils:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   3881: goto +4132 -> 8013
    //   3884: aload 13
    //   3886: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3889: ifnull +97 -> 3986
    //   3892: aload 13
    //   3894: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3897: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   3900: ifle +86 -> 3986
    //   3903: aload 13
    //   3905: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3908: iconst_0
    //   3909: invokevirtual 460	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   3912: checkcast 126	java/lang/String
    //   3915: astore 5
    //   3917: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3920: ifeq +47 -> 3967
    //   3923: ldc 77
    //   3925: iconst_2
    //   3926: new 79	java/lang/StringBuilder
    //   3929: dup
    //   3930: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3933: ldc_w 5011
    //   3936: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3939: aload 5
    //   3941: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3944: ldc_w 467
    //   3947: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3950: aload 13
    //   3952: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3955: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3958: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3961: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3964: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3967: aload_0
    //   3968: aload 14
    //   3970: aload 5
    //   3972: aload 13
    //   3974: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3977: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3980: invokespecial 5013	com/tencent/mobileqq/config/splashlogo/ConfigServlet:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   3983: goto +4030 -> 8013
    //   3986: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3989: ifeq +36 -> 4025
    //   3992: ldc 77
    //   3994: iconst_2
    //   3995: new 79	java/lang/StringBuilder
    //   3998: dup
    //   3999: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4002: ldc_w 5015
    //   4005: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4008: aload 13
    //   4010: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4013: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4016: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4019: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4022: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4025: new 2195	java/io/File
    //   4028: dup
    //   4029: new 79	java/lang/StringBuilder
    //   4032: dup
    //   4033: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4036: aload 14
    //   4038: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   4041: invokevirtual 3866	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   4044: invokevirtual 2198	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4047: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4050: ldc_w 2200
    //   4053: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4056: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4059: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4062: ldc_w 2200
    //   4065: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4068: ldc_w 3868
    //   4071: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4074: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4077: invokespecial 3930	java/io/File:<init>	(Ljava/lang/String;)V
    //   4080: astore 5
    //   4082: aload 5
    //   4084: invokevirtual 3933	java/io/File:exists	()Z
    //   4087: ifeq +9 -> 4096
    //   4090: aload 5
    //   4092: invokevirtual 3936	java/io/File:delete	()Z
    //   4095: pop
    //   4096: aload 14
    //   4098: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   4101: aload 13
    //   4103: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4106: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4109: ldc 13
    //   4111: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4114: invokestatic 5017	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   4117: goto +3896 -> 8013
    //   4120: aload 13
    //   4122: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4125: ifnull +164 -> 4289
    //   4128: aload 13
    //   4130: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4133: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4136: ifle +153 -> 4289
    //   4139: new 862	java/util/ArrayList
    //   4142: dup
    //   4143: invokespecial 863	java/util/ArrayList:<init>	()V
    //   4146: astore 5
    //   4148: iconst_0
    //   4149: istore 8
    //   4151: iload 8
    //   4153: aload 13
    //   4155: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4158: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4161: if_icmpge +92 -> 4253
    //   4164: aload 13
    //   4166: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4169: iload 8
    //   4171: invokevirtual 460	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4174: checkcast 126	java/lang/String
    //   4177: astore 15
    //   4179: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4182: ifeq +47 -> 4229
    //   4185: ldc 77
    //   4187: iconst_2
    //   4188: new 79	java/lang/StringBuilder
    //   4191: dup
    //   4192: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4195: ldc_w 5019
    //   4198: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4201: aload 15
    //   4203: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4206: ldc_w 467
    //   4209: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4212: aload 13
    //   4214: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4217: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4220: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4223: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4226: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4229: aload_0
    //   4230: aload 15
    //   4232: invokespecial 5021	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/config/operation/QQOperationViopTipTask;
    //   4235: astore 15
    //   4237: aload 15
    //   4239: ifnull +3840 -> 8079
    //   4242: aload 5
    //   4244: aload 15
    //   4246: invokevirtual 898	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4249: pop
    //   4250: goto +3829 -> 8079
    //   4253: aload 14
    //   4255: invokestatic 5026	com/tencent/mobileqq/config/operation/QQOperateManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/config/operation/QQOperateManager;
    //   4258: aload 14
    //   4260: aload 5
    //   4262: invokevirtual 5029	com/tencent/mobileqq/config/operation/QQOperateManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/ArrayList;)V
    //   4265: aload 14
    //   4267: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   4270: aload 14
    //   4272: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   4275: aload 13
    //   4277: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4280: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4283: invokestatic 5030	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4286: goto +3727 -> 8013
    //   4289: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4292: ifeq +3721 -> 8013
    //   4295: ldc 77
    //   4297: iconst_2
    //   4298: new 79	java/lang/StringBuilder
    //   4301: dup
    //   4302: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4305: ldc_w 5032
    //   4308: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4311: aload 13
    //   4313: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4316: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4319: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4322: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4325: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4328: goto +3685 -> 8013
    //   4331: aload 14
    //   4333: getstatic 1072	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_BANNER_MANAGER	I
    //   4336: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4339: checkcast 1074	com/tencent/mobileqq/config/struct/NearbyBannerManager
    //   4342: astore 5
    //   4344: aload 5
    //   4346: invokevirtual 5035	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	()Ljava/util/Set;
    //   4349: astore 16
    //   4351: new 2206	com/tencent/mobileqq/config/struct/PicAndAdConf
    //   4354: dup
    //   4355: bipush 21
    //   4357: iconst_2
    //   4358: invokespecial 5038	com/tencent/mobileqq/config/struct/PicAndAdConf:<init>	(SB)V
    //   4361: astore 15
    //   4363: aload 13
    //   4365: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4368: ifnull +129 -> 4497
    //   4371: aload 13
    //   4373: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4376: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4379: ifle +118 -> 4497
    //   4382: aload 13
    //   4384: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4387: invokevirtual 886	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   4390: invokeinterface 115 1 0
    //   4395: astore 17
    //   4397: aload 17
    //   4399: invokeinterface 120 1 0
    //   4404: ifeq +132 -> 4536
    //   4407: aload 17
    //   4409: invokeinterface 124 1 0
    //   4414: checkcast 126	java/lang/String
    //   4417: astore 18
    //   4419: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4422: ifeq +47 -> 4469
    //   4425: ldc 77
    //   4427: iconst_2
    //   4428: new 79	java/lang/StringBuilder
    //   4431: dup
    //   4432: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4435: ldc_w 5040
    //   4438: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4441: aload 18
    //   4443: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4446: ldc_w 467
    //   4449: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4452: aload 13
    //   4454: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4457: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4460: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4463: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4466: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4469: aload 15
    //   4471: aload 18
    //   4473: aload 16
    //   4475: invokestatic 5042	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/config/struct/PicAndAdConf;Ljava/lang/String;Ljava/util/Set;)Z
    //   4478: pop
    //   4479: aload 5
    //   4481: aload 15
    //   4483: aload 13
    //   4485: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4488: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4491: invokevirtual 5045	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(Lcom/tencent/mobileqq/config/struct/PicAndAdConf;I)V
    //   4494: goto -97 -> 4397
    //   4497: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4500: ifeq +36 -> 4536
    //   4503: ldc 77
    //   4505: iconst_2
    //   4506: new 79	java/lang/StringBuilder
    //   4509: dup
    //   4510: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4513: ldc_w 5047
    //   4516: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4519: aload 13
    //   4521: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4524: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4527: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4530: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4533: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4536: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4539: ifeq +76 -> 4615
    //   4542: new 79	java/lang/StringBuilder
    //   4545: dup
    //   4546: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4549: ldc_w 5049
    //   4552: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4555: astore 16
    //   4557: aload 13
    //   4559: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4562: ifnonnull +69 -> 4631
    //   4565: iconst_0
    //   4566: istore 8
    //   4568: ldc 77
    //   4570: iconst_2
    //   4571: aload 16
    //   4573: iload 8
    //   4575: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4578: ldc_w 5051
    //   4581: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4584: aload 15
    //   4586: invokevirtual 5052	com/tencent/mobileqq/config/struct/PicAndAdConf:a	()I
    //   4589: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4592: ldc_w 5054
    //   4595: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4598: aload 13
    //   4600: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4603: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4606: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4609: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4612: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4615: aload 5
    //   4617: aload 13
    //   4619: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4622: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4625: invokevirtual 5055	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(I)V
    //   4628: goto +3385 -> 8013
    //   4631: aload 13
    //   4633: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4636: invokevirtual 886	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   4639: invokeinterface 111 1 0
    //   4644: istore 8
    //   4646: goto -78 -> 4568
    //   4649: aload 14
    //   4651: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4654: aload 14
    //   4656: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4659: invokestatic 1102	com/tencent/mobileqq/utils/SharedPreUtils:j	(Landroid/content/Context;Ljava/lang/String;)I
    //   4662: istore 9
    //   4664: aload 13
    //   4666: ifnull +3422 -> 8088
    //   4669: aload 13
    //   4671: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4674: ifnull +3414 -> 8088
    //   4677: aload 13
    //   4679: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4682: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4685: istore 8
    //   4687: aload 13
    //   4689: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4692: ifnull +182 -> 4874
    //   4695: aload 13
    //   4697: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4700: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4703: ifle +171 -> 4874
    //   4706: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4709: ifeq +79 -> 4788
    //   4712: ldc 77
    //   4714: iconst_2
    //   4715: new 79	java/lang/StringBuilder
    //   4718: dup
    //   4719: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4722: ldc_w 5057
    //   4725: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4728: iload 8
    //   4730: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4733: ldc_w 5059
    //   4736: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4739: iload 9
    //   4741: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4744: ldc_w 5061
    //   4747: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4750: aload 13
    //   4752: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4755: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4758: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4761: ldc_w 5063
    //   4764: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4767: aload 13
    //   4769: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4772: iconst_0
    //   4773: invokevirtual 460	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4776: checkcast 126	java/lang/String
    //   4779: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4782: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4785: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4788: new 269	java/util/HashSet
    //   4791: dup
    //   4792: invokespecial 270	java/util/HashSet:<init>	()V
    //   4795: astore 5
    //   4797: iconst_0
    //   4798: istore 9
    //   4800: iload 9
    //   4802: aload 13
    //   4804: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4807: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4810: if_icmpge +30 -> 4840
    //   4813: aload 5
    //   4815: aload 13
    //   4817: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4820: iload 9
    //   4822: invokevirtual 460	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   4825: invokeinterface 5064 2 0
    //   4830: pop
    //   4831: iload 9
    //   4833: iconst_1
    //   4834: iadd
    //   4835: istore 9
    //   4837: goto -37 -> 4800
    //   4840: aload 14
    //   4842: getstatic 5067	com/tencent/mobileqq/app/QQManagerFactory:SEND_BLESS_CONFIG_MANAGER	I
    //   4845: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4848: checkcast 5069	com/tencent/mobileqq/activity/bless/BlessManager
    //   4851: aload 5
    //   4853: invokevirtual 5072	com/tencent/mobileqq/activity/bless/BlessManager:a	(Ljava/util/Set;)V
    //   4856: aload 14
    //   4858: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   4861: aload 14
    //   4863: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   4866: iload 8
    //   4868: invokestatic 5073	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4871: goto +3224 -> 8095
    //   4874: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4877: ifeq +41 -> 4918
    //   4880: ldc 77
    //   4882: iconst_2
    //   4883: new 79	java/lang/StringBuilder
    //   4886: dup
    //   4887: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4890: ldc_w 5075
    //   4893: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4896: iload 8
    //   4898: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4901: ldc_w 5059
    //   4904: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4907: iload 9
    //   4909: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4912: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4915: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4918: iload 9
    //   4920: iload 8
    //   4922: if_icmpeq +3173 -> 8095
    //   4925: aload 14
    //   4927: getstatic 5067	com/tencent/mobileqq/app/QQManagerFactory:SEND_BLESS_CONFIG_MANAGER	I
    //   4930: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4933: checkcast 5069	com/tencent/mobileqq/activity/bless/BlessManager
    //   4936: invokevirtual 5076	com/tencent/mobileqq/activity/bless/BlessManager:a	()V
    //   4939: aload 14
    //   4941: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   4944: aload 14
    //   4946: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   4949: iload 8
    //   4951: invokestatic 5073	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4954: goto +3141 -> 8095
    //   4957: aload 13
    //   4959: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4962: ifnull +3033 -> 7995
    //   4965: aload 13
    //   4967: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4970: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   4973: ifle +3022 -> 7995
    //   4976: aload 13
    //   4978: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4981: invokevirtual 886	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   4984: astore 5
    //   4986: aload 5
    //   4988: ifnull +193 -> 5181
    //   4991: aload 5
    //   4993: invokeinterface 111 1 0
    //   4998: ifle +183 -> 5181
    //   5001: aload 5
    //   5003: iconst_0
    //   5004: invokeinterface 193 2 0
    //   5009: checkcast 126	java/lang/String
    //   5012: astore 15
    //   5014: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5017: ifeq +47 -> 5064
    //   5020: ldc 77
    //   5022: iconst_2
    //   5023: new 79	java/lang/StringBuilder
    //   5026: dup
    //   5027: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5030: ldc_w 5078
    //   5033: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5036: aload 15
    //   5038: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5041: ldc_w 467
    //   5044: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5047: aload 13
    //   5049: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5052: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5055: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5058: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5061: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5064: aload 15
    //   5066: invokestatic 5081	com/tencent/biz/bmqq/util/BmqqSegmentUtil:a	(Ljava/lang/String;)V
    //   5069: aload 5
    //   5071: invokeinterface 115 1 0
    //   5076: astore 5
    //   5078: aload 5
    //   5080: invokeinterface 120 1 0
    //   5085: ifeq +73 -> 5158
    //   5088: aload 5
    //   5090: invokeinterface 124 1 0
    //   5095: checkcast 126	java/lang/String
    //   5098: astore 15
    //   5100: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5103: ifeq +47 -> 5150
    //   5106: ldc 77
    //   5108: iconst_2
    //   5109: new 79	java/lang/StringBuilder
    //   5112: dup
    //   5113: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5116: ldc_w 5078
    //   5119: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5122: aload 15
    //   5124: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5127: ldc_w 467
    //   5130: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5133: aload 13
    //   5135: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5138: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5141: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5144: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5147: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5150: aload 15
    //   5152: invokestatic 5084	com/tencent/mobileqq/activity/aio/tips/C2BTipsBar:a	(Ljava/lang/String;)Z
    //   5155: ifeq -77 -> 5078
    //   5158: aload 13
    //   5160: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5163: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5166: istore 8
    //   5168: aload 14
    //   5170: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   5173: iload 8
    //   5175: invokestatic 5086	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;I)V
    //   5178: goto +2835 -> 8013
    //   5181: aconst_null
    //   5182: invokestatic 5081	com/tencent/biz/bmqq/util/BmqqSegmentUtil:a	(Ljava/lang/String;)V
    //   5185: invokestatic 5087	com/tencent/mobileqq/activity/aio/tips/C2BTipsBar:a	()V
    //   5188: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5191: ifeq -33 -> 5158
    //   5194: ldc 77
    //   5196: iconst_2
    //   5197: new 79	java/lang/StringBuilder
    //   5200: dup
    //   5201: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5204: ldc_w 5089
    //   5207: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5210: aload 13
    //   5212: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5215: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5218: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5221: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5224: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5227: goto -69 -> 5158
    //   5230: invokestatic 63	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5233: aload 14
    //   5235: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5238: invokestatic 1116	cooperation/pluginbridge/BridgeHelper:a	(Landroid/content/Context;Ljava/lang/String;)Lcooperation/pluginbridge/BridgeHelper;
    //   5241: aload 13
    //   5243: invokevirtual 5090	cooperation/pluginbridge/BridgeHelper:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5246: goto +2767 -> 8013
    //   5249: aload_0
    //   5250: aload 14
    //   5252: aload_3
    //   5253: aload 13
    //   5255: invokespecial 5092	com/tencent/mobileqq/config/splashlogo/ConfigServlet:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5258: goto +2755 -> 8013
    //   5261: aload_0
    //   5262: aload 14
    //   5264: aload_3
    //   5265: aload 13
    //   5267: invokespecial 5094	com/tencent/mobileqq/config/splashlogo/ConfigServlet:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5270: goto +2743 -> 8013
    //   5273: aload_0
    //   5274: aload 14
    //   5276: aload_3
    //   5277: aload 13
    //   5279: invokespecial 5096	com/tencent/mobileqq/config/splashlogo/ConfigServlet:m	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5282: goto +2731 -> 8013
    //   5285: aload_0
    //   5286: aload 14
    //   5288: aload 13
    //   5290: invokespecial 5098	com/tencent/mobileqq/config/splashlogo/ConfigServlet:an	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5293: goto +2720 -> 8013
    //   5296: aload_0
    //   5297: aload 14
    //   5299: aload 13
    //   5301: invokespecial 5100	com/tencent/mobileqq/config/splashlogo/ConfigServlet:am	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5304: goto +2709 -> 8013
    //   5307: aload 13
    //   5309: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5312: ifnull +105 -> 5417
    //   5315: aload 13
    //   5317: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5320: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5323: ifle +94 -> 5417
    //   5326: aload 13
    //   5328: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5331: iconst_0
    //   5332: invokevirtual 460	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   5335: checkcast 126	java/lang/String
    //   5338: astore 5
    //   5340: aload 13
    //   5342: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5345: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5348: istore 8
    //   5350: aload 14
    //   5352: invokevirtual 5104	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   5355: aload 14
    //   5357: aload 5
    //   5359: iload 8
    //   5361: invokevirtual 5107	com/tencent/av/gaudio/AVNotifyCenter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   5364: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5367: ifeq +2731 -> 8098
    //   5370: ldc 77
    //   5372: iconst_2
    //   5373: new 79	java/lang/StringBuilder
    //   5376: dup
    //   5377: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5380: ldc_w 5109
    //   5383: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5386: aload 5
    //   5388: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5391: ldc_w 467
    //   5394: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5397: aload 13
    //   5399: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5402: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5405: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5408: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5411: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5414: goto +2684 -> 8098
    //   5417: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5420: ifeq +2593 -> 8013
    //   5423: ldc 77
    //   5425: iconst_2
    //   5426: new 79	java/lang/StringBuilder
    //   5429: dup
    //   5430: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5433: ldc_w 5111
    //   5436: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5439: aload 13
    //   5441: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5444: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5447: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5450: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5453: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5456: goto +2557 -> 8013
    //   5459: aload_0
    //   5460: aload 14
    //   5462: aload_3
    //   5463: aload 13
    //   5465: invokespecial 5113	com/tencent/mobileqq/config/splashlogo/ConfigServlet:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5468: goto +2545 -> 8013
    //   5471: aload_0
    //   5472: aload 14
    //   5474: aload_3
    //   5475: aload 13
    //   5477: invokespecial 5115	com/tencent/mobileqq/config/splashlogo/ConfigServlet:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5480: goto +2533 -> 8013
    //   5483: aload_0
    //   5484: aload 14
    //   5486: aload_3
    //   5487: aload 13
    //   5489: invokespecial 5117	com/tencent/mobileqq/config/splashlogo/ConfigServlet:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5492: goto +2521 -> 8013
    //   5495: aload_0
    //   5496: aload 14
    //   5498: aload_3
    //   5499: aload 13
    //   5501: invokespecial 5119	com/tencent/mobileqq/config/splashlogo/ConfigServlet:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5504: goto +2509 -> 8013
    //   5507: aload_0
    //   5508: aload 14
    //   5510: aload_3
    //   5511: aload 13
    //   5513: invokespecial 5121	com/tencent/mobileqq/config/splashlogo/ConfigServlet:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5516: goto +2497 -> 8013
    //   5519: aload_0
    //   5520: aload 14
    //   5522: aload_3
    //   5523: aload 13
    //   5525: invokespecial 5123	com/tencent/mobileqq/config/splashlogo/ConfigServlet:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5528: goto +2485 -> 8013
    //   5531: aload_0
    //   5532: aload 14
    //   5534: aload 13
    //   5536: invokespecial 5125	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aj	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5539: goto +2474 -> 8013
    //   5542: aload_0
    //   5543: aload 14
    //   5545: aload 13
    //   5547: invokespecial 5127	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ak	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5550: goto +2463 -> 8013
    //   5553: aload_0
    //   5554: aload 14
    //   5556: aload 13
    //   5558: invokespecial 5129	com/tencent/mobileqq/config/splashlogo/ConfigServlet:al	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5561: goto +2452 -> 8013
    //   5564: aload 14
    //   5566: invokestatic 1212	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   5569: aload 14
    //   5571: iload 8
    //   5573: aload_3
    //   5574: aload 13
    //   5576: invokevirtual 5133	com/tencent/mobileqq/utils/BusinessCommonConfig:decodeConfig	(Lcom/tencent/mobileqq/app/QQAppInterface;ILandroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)Ljava/lang/Boolean;
    //   5579: pop
    //   5580: goto +2433 -> 8013
    //   5583: aload 13
    //   5585: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5588: ifnull +166 -> 5754
    //   5591: aload 13
    //   5593: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5596: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5599: ifle +155 -> 5754
    //   5602: aload 13
    //   5604: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5607: invokevirtual 886	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5610: invokeinterface 115 1 0
    //   5615: astore 5
    //   5617: aload 5
    //   5619: invokeinterface 120 1 0
    //   5624: ifeq +169 -> 5793
    //   5627: aload 5
    //   5629: invokeinterface 124 1 0
    //   5634: checkcast 126	java/lang/String
    //   5637: astore 15
    //   5639: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5642: ifeq +47 -> 5689
    //   5645: ldc 77
    //   5647: iconst_2
    //   5648: new 79	java/lang/StringBuilder
    //   5651: dup
    //   5652: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5655: ldc_w 5135
    //   5658: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5661: aload 15
    //   5663: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5666: ldc_w 467
    //   5669: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5672: aload 13
    //   5674: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5677: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5680: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5683: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5686: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5689: aload_0
    //   5690: aload 14
    //   5692: aload 15
    //   5694: aload 13
    //   5696: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5699: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5702: invokespecial 5137	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   5705: goto -88 -> 5617
    //   5708: astore 5
    //   5710: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5713: ifeq +33 -> 5746
    //   5716: ldc 77
    //   5718: iconst_2
    //   5719: new 79	java/lang/StringBuilder
    //   5722: dup
    //   5723: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5726: ldc_w 5139
    //   5729: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5732: aload 5
    //   5734: invokevirtual 503	java/lang/Exception:toString	()Ljava/lang/String;
    //   5737: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5740: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5743: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5746: aload 5
    //   5748: invokevirtual 205	java/lang/Exception:printStackTrace	()V
    //   5751: goto +2262 -> 8013
    //   5754: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5757: ifeq +36 -> 5793
    //   5760: ldc 77
    //   5762: iconst_2
    //   5763: new 79	java/lang/StringBuilder
    //   5766: dup
    //   5767: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5770: ldc_w 5141
    //   5773: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5776: aload 13
    //   5778: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5781: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5784: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5787: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5790: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5793: goto +2220 -> 8013
    //   5796: aload 13
    //   5798: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5801: ifnull +166 -> 5967
    //   5804: aload 13
    //   5806: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5809: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5812: ifle +155 -> 5967
    //   5815: aload 13
    //   5817: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5820: invokevirtual 886	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5823: invokeinterface 115 1 0
    //   5828: astore 5
    //   5830: aload 5
    //   5832: invokeinterface 120 1 0
    //   5837: ifeq +169 -> 6006
    //   5840: aload 5
    //   5842: invokeinterface 124 1 0
    //   5847: checkcast 126	java/lang/String
    //   5850: astore 15
    //   5852: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5855: ifeq +47 -> 5902
    //   5858: ldc 77
    //   5860: iconst_2
    //   5861: new 79	java/lang/StringBuilder
    //   5864: dup
    //   5865: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5868: ldc_w 5143
    //   5871: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5874: aload 15
    //   5876: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5879: ldc_w 467
    //   5882: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5885: aload 13
    //   5887: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5890: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5893: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5896: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5899: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5902: aload_0
    //   5903: aload 14
    //   5905: aload 15
    //   5907: aload 13
    //   5909: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5912: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5915: invokespecial 5145	com/tencent/mobileqq/config/splashlogo/ConfigServlet:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   5918: goto -88 -> 5830
    //   5921: astore 5
    //   5923: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5926: ifeq +33 -> 5959
    //   5929: ldc 77
    //   5931: iconst_2
    //   5932: new 79	java/lang/StringBuilder
    //   5935: dup
    //   5936: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5939: ldc_w 5147
    //   5942: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5945: aload 5
    //   5947: invokevirtual 503	java/lang/Exception:toString	()Ljava/lang/String;
    //   5950: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5953: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5956: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5959: aload 5
    //   5961: invokevirtual 205	java/lang/Exception:printStackTrace	()V
    //   5964: goto +2049 -> 8013
    //   5967: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5970: ifeq +36 -> 6006
    //   5973: ldc 77
    //   5975: iconst_2
    //   5976: new 79	java/lang/StringBuilder
    //   5979: dup
    //   5980: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   5983: ldc_w 5149
    //   5986: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5989: aload 13
    //   5991: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5994: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5997: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6000: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6003: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6006: goto +2007 -> 8013
    //   6009: aload_0
    //   6010: aload 14
    //   6012: aload 13
    //   6014: invokespecial 5151	com/tencent/mobileqq/config/splashlogo/ConfigServlet:at	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6017: goto +1996 -> 8013
    //   6020: aload_0
    //   6021: aload 14
    //   6023: aload 13
    //   6025: invokespecial 5153	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aq	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6028: goto +1985 -> 8013
    //   6031: aload_0
    //   6032: aload 14
    //   6034: aload 13
    //   6036: invokespecial 5155	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ar	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6039: goto +1974 -> 8013
    //   6042: aload_0
    //   6043: aload 14
    //   6045: aload 13
    //   6047: invokespecial 5157	com/tencent/mobileqq/config/splashlogo/ConfigServlet:as	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6050: goto +1963 -> 8013
    //   6053: aload_0
    //   6054: aload 14
    //   6056: aload 13
    //   6058: invokespecial 5159	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ax	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6061: goto +1952 -> 8013
    //   6064: aload_0
    //   6065: aload 14
    //   6067: aload 13
    //   6069: invokespecial 5161	com/tencent/mobileqq/config/splashlogo/ConfigServlet:av	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6072: goto +1941 -> 8013
    //   6075: aload_0
    //   6076: aload 14
    //   6078: aload 13
    //   6080: invokespecial 5163	com/tencent/mobileqq/config/splashlogo/ConfigServlet:X	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6083: goto +1930 -> 8013
    //   6086: aload_0
    //   6087: aload 14
    //   6089: aload 13
    //   6091: invokespecial 5165	com/tencent/mobileqq/config/splashlogo/ConfigServlet:au	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6094: goto +1919 -> 8013
    //   6097: aload_0
    //   6098: aload 14
    //   6100: aload 13
    //   6102: invokespecial 5167	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aw	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6105: goto +1908 -> 8013
    //   6108: aload_0
    //   6109: aload 14
    //   6111: aload 13
    //   6113: invokespecial 5169	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ao	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6116: goto +1897 -> 8013
    //   6119: aload_0
    //   6120: aload 14
    //   6122: aload 13
    //   6124: invokevirtual 5171	com/tencent/mobileqq/config/splashlogo/ConfigServlet:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6127: goto +1886 -> 8013
    //   6130: aload_0
    //   6131: aload 14
    //   6133: aload 13
    //   6135: invokevirtual 5173	com/tencent/mobileqq/config/splashlogo/ConfigServlet:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6138: goto +1875 -> 8013
    //   6141: aload_0
    //   6142: aload 14
    //   6144: aload 13
    //   6146: invokespecial 5175	com/tencent/mobileqq/config/splashlogo/ConfigServlet:az	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6149: goto +1864 -> 8013
    //   6152: aload_0
    //   6153: aload 14
    //   6155: aload 13
    //   6157: invokespecial 5177	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aA	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6160: goto +1853 -> 8013
    //   6163: aload_0
    //   6164: aload 14
    //   6166: aload 13
    //   6168: invokespecial 5179	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aE	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6171: goto +1842 -> 8013
    //   6174: aload_0
    //   6175: aload 14
    //   6177: aload 13
    //   6179: invokespecial 5181	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aR	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6182: goto +1831 -> 8013
    //   6185: aload_0
    //   6186: aload 14
    //   6188: aload 13
    //   6190: invokespecial 5183	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aC	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6193: goto +1820 -> 8013
    //   6196: aload_0
    //   6197: aload 14
    //   6199: aload 13
    //   6201: invokespecial 5185	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aD	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6204: goto +1809 -> 8013
    //   6207: aload_0
    //   6208: aload 14
    //   6210: aload 13
    //   6212: invokespecial 5187	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ap	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6215: goto +1798 -> 8013
    //   6218: aload_0
    //   6219: aload 14
    //   6221: aload 13
    //   6223: invokespecial 5189	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ay	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6226: goto +1787 -> 8013
    //   6229: ldc_w 1345
    //   6232: invokestatic 1351	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   6235: checkcast 1345	com/tencent/mobileqq/dpc/api/IDPCApi
    //   6238: aload_2
    //   6239: ldc 13
    //   6241: invokeinterface 5193 3 0
    //   6246: pop
    //   6247: goto +1766 -> 8013
    //   6250: aload_0
    //   6251: aload 14
    //   6253: aload 13
    //   6255: invokespecial 5195	com/tencent/mobileqq/config/splashlogo/ConfigServlet:Z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6258: goto +1755 -> 8013
    //   6261: aload_0
    //   6262: aload 14
    //   6264: aload 13
    //   6266: invokespecial 5197	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aa	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6269: goto +1744 -> 8013
    //   6272: aload_0
    //   6273: aload 14
    //   6275: aload 13
    //   6277: invokevirtual 5199	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6280: goto +1733 -> 8013
    //   6283: aload_0
    //   6284: aload 14
    //   6286: aload 13
    //   6288: invokespecial 5201	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aF	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6291: goto +1722 -> 8013
    //   6294: aload 13
    //   6296: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6299: ifnull +138 -> 6437
    //   6302: aload 13
    //   6304: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6307: invokevirtual 459	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6310: ifle +127 -> 6437
    //   6313: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6316: ifeq +68 -> 6384
    //   6319: ldc 77
    //   6321: iconst_2
    //   6322: new 79	java/lang/StringBuilder
    //   6325: dup
    //   6326: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   6329: ldc_w 5203
    //   6332: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6335: iload 8
    //   6337: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6340: ldc_w 5063
    //   6343: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6346: aload 13
    //   6348: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6351: iconst_0
    //   6352: invokevirtual 460	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6355: checkcast 126	java/lang/String
    //   6358: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6361: ldc_w 467
    //   6364: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6367: aload 13
    //   6369: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6372: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6375: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6378: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6381: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6384: aload 14
    //   6386: getstatic 5206	com/tencent/mobileqq/app/QQManagerFactory:PHOTO_PLUS_MANAGER	I
    //   6389: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6392: checkcast 5208	cooperation/photoplus/PhotoPlusManager
    //   6395: aload 13
    //   6397: getfield 456	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6400: iconst_0
    //   6401: invokevirtual 460	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6404: checkcast 126	java/lang/String
    //   6407: invokevirtual 5209	cooperation/photoplus/PhotoPlusManager:a	(Ljava/lang/String;)Z
    //   6410: ifeq +1603 -> 8013
    //   6413: aload 14
    //   6415: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   6418: aload 14
    //   6420: invokevirtual 1121	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   6423: aload 13
    //   6425: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6428: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6431: invokestatic 5211	com/tencent/mobileqq/utils/SharedPreUtils:r	(Landroid/content/Context;Ljava/lang/String;I)V
    //   6434: goto +1579 -> 8013
    //   6437: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6440: ifeq +1573 -> 8013
    //   6443: ldc 77
    //   6445: iconst_2
    //   6446: new 79	java/lang/StringBuilder
    //   6449: dup
    //   6450: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   6453: ldc_w 5203
    //   6456: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6459: iload 8
    //   6461: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6464: ldc_w 5213
    //   6467: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6470: aload 13
    //   6472: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6475: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6478: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6481: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6484: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6487: goto +1526 -> 8013
    //   6490: aload_0
    //   6491: aload 14
    //   6493: aload 13
    //   6495: invokevirtual 5215	com/tencent/mobileqq/config/splashlogo/ConfigServlet:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6498: goto +1515 -> 8013
    //   6501: aload_0
    //   6502: aload 14
    //   6504: aload_3
    //   6505: iload 6
    //   6507: aload 13
    //   6509: aload_2
    //   6510: getfield 5218	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6513: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6516: invokevirtual 5220	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   6519: goto +1494 -> 8013
    //   6522: aload_0
    //   6523: aload 14
    //   6525: aload_3
    //   6526: aload 13
    //   6528: invokespecial 5222	com/tencent/mobileqq/config/splashlogo/ConfigServlet:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6531: goto +1482 -> 8013
    //   6534: aload_0
    //   6535: aload 14
    //   6537: aload_3
    //   6538: aload 13
    //   6540: invokespecial 5224	com/tencent/mobileqq/config/splashlogo/ConfigServlet:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6543: goto +1470 -> 8013
    //   6546: aload_0
    //   6547: aload 14
    //   6549: aload_3
    //   6550: aload 13
    //   6552: invokespecial 5226	com/tencent/mobileqq/config/splashlogo/ConfigServlet:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6555: goto +1458 -> 8013
    //   6558: aload_0
    //   6559: aload 14
    //   6561: aload_3
    //   6562: aload 13
    //   6564: invokevirtual 5228	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6567: goto +1446 -> 8013
    //   6570: aload_0
    //   6571: aload 14
    //   6573: aload_3
    //   6574: aload 13
    //   6576: invokevirtual 5230	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6579: goto +1434 -> 8013
    //   6582: aload_0
    //   6583: aload 14
    //   6585: aload 13
    //   6587: invokespecial 5232	com/tencent/mobileqq/config/splashlogo/ConfigServlet:Y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6590: goto +1423 -> 8013
    //   6593: aload_0
    //   6594: aload 14
    //   6596: aload 13
    //   6598: invokespecial 5234	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aB	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6601: goto +1412 -> 8013
    //   6604: iload 8
    //   6606: aload 14
    //   6608: invokevirtual 1293	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   6611: aload 13
    //   6613: invokestatic 5237	com/tencent/av/QAVConfig:a	(ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6616: goto +1397 -> 8013
    //   6619: aload_0
    //   6620: aload 14
    //   6622: aload 13
    //   6624: invokevirtual 5239	com/tencent/mobileqq/config/splashlogo/ConfigServlet:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6627: goto +1386 -> 8013
    //   6630: aload_0
    //   6631: aload_3
    //   6632: iload 6
    //   6634: aload 13
    //   6636: aload_2
    //   6637: getfield 5218	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6640: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6643: invokevirtual 5241	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   6646: goto +1367 -> 8013
    //   6649: aload_0
    //   6650: aload 14
    //   6652: aload 13
    //   6654: invokespecial 5243	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ab	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6657: goto +1356 -> 8013
    //   6660: aload_0
    //   6661: aload 14
    //   6663: aload 13
    //   6665: invokespecial 5245	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ac	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6668: goto +1345 -> 8013
    //   6671: aload_0
    //   6672: aload 14
    //   6674: aload 13
    //   6676: invokespecial 5247	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ad	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6679: goto +1334 -> 8013
    //   6682: aload_0
    //   6683: aload 14
    //   6685: aload 13
    //   6687: invokespecial 5249	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ae	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6690: goto +1323 -> 8013
    //   6693: aload_0
    //   6694: aload 14
    //   6696: aload 13
    //   6698: invokevirtual 5251	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6701: goto +1312 -> 8013
    //   6704: aload_0
    //   6705: aload 14
    //   6707: aload 13
    //   6709: invokespecial 5253	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aG	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6712: goto +1301 -> 8013
    //   6715: aload_0
    //   6716: aload 14
    //   6718: aload 13
    //   6720: invokespecial 5255	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aH	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6723: goto +1290 -> 8013
    //   6726: aload_0
    //   6727: aload 14
    //   6729: aload 13
    //   6731: invokespecial 5257	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aI	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6734: goto +1279 -> 8013
    //   6737: aload_0
    //   6738: aload 14
    //   6740: aload 13
    //   6742: invokespecial 5259	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aJ	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6745: goto +1268 -> 8013
    //   6748: aload 13
    //   6750: invokestatic 5260	com/tencent/mobileqq/search/util/SearchConfigUtils:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6753: goto +1260 -> 8013
    //   6756: aload_0
    //   6757: aload 14
    //   6759: aload 13
    //   6761: invokespecial 5262	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aK	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6764: goto +1249 -> 8013
    //   6767: aload_0
    //   6768: aload 14
    //   6770: aload 13
    //   6772: invokespecial 5264	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aL	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6775: goto +1238 -> 8013
    //   6778: aload_0
    //   6779: aload 14
    //   6781: aload 13
    //   6783: invokespecial 5266	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aM	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6786: goto +1227 -> 8013
    //   6789: aload_0
    //   6790: aload 14
    //   6792: aload 13
    //   6794: invokespecial 5268	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aN	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6797: goto +1216 -> 8013
    //   6800: aload_0
    //   6801: aload 14
    //   6803: aload 13
    //   6805: invokevirtual 5270	com/tencent/mobileqq/config/splashlogo/ConfigServlet:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6808: goto +1205 -> 8013
    //   6811: aload_0
    //   6812: aload 14
    //   6814: aload_3
    //   6815: aload 13
    //   6817: invokespecial 5272	com/tencent/mobileqq/config/splashlogo/ConfigServlet:o	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6820: goto +1193 -> 8013
    //   6823: aload_0
    //   6824: aload 14
    //   6826: aload 13
    //   6828: invokespecial 5274	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aO	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6831: goto +1182 -> 8013
    //   6834: aload_0
    //   6835: aload 14
    //   6837: aload 13
    //   6839: invokevirtual 5276	com/tencent/mobileqq/config/splashlogo/ConfigServlet:o	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6842: goto +1171 -> 8013
    //   6845: aload_0
    //   6846: aload 14
    //   6848: aload 13
    //   6850: invokevirtual 5278	com/tencent/mobileqq/config/splashlogo/ConfigServlet:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6853: goto +1160 -> 8013
    //   6856: aload 14
    //   6858: getstatic 1613	com/tencent/mobileqq/app/QQManagerFactory:TROOP_STORY_MANAGER	I
    //   6861: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6864: checkcast 1615	com/tencent/biz/qqstory/troop/TroopStoryManager
    //   6867: getfield 1618	com/tencent/biz/qqstory/troop/TroopStoryManager:a	Lcom/tencent/biz/qqstory/troop/TroopDynamicConfig;
    //   6870: aload 14
    //   6872: aload 13
    //   6874: invokevirtual 5281	com/tencent/biz/qqstory/troop/TroopDynamicConfig:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6877: goto +1136 -> 8013
    //   6880: aload_0
    //   6881: aload 14
    //   6883: aload 13
    //   6885: invokevirtual 5283	com/tencent/mobileqq/config/splashlogo/ConfigServlet:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6888: goto +1125 -> 8013
    //   6891: aload_0
    //   6892: aload 14
    //   6894: aload 13
    //   6896: invokevirtual 5285	com/tencent/mobileqq/config/splashlogo/ConfigServlet:m	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6899: goto +1114 -> 8013
    //   6902: aload_0
    //   6903: aload 14
    //   6905: aload 13
    //   6907: invokevirtual 5287	com/tencent/mobileqq/config/splashlogo/ConfigServlet:p	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6910: goto +1103 -> 8013
    //   6913: aload_0
    //   6914: aload 14
    //   6916: aload 13
    //   6918: invokevirtual 5289	com/tencent/mobileqq/config/splashlogo/ConfigServlet:q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6921: goto +1092 -> 8013
    //   6924: aload_0
    //   6925: aload 14
    //   6927: aload 13
    //   6929: invokevirtual 5291	com/tencent/mobileqq/config/splashlogo/ConfigServlet:r	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6932: goto +1081 -> 8013
    //   6935: aload_0
    //   6936: aload 14
    //   6938: aload 13
    //   6940: invokevirtual 5293	com/tencent/mobileqq/config/splashlogo/ConfigServlet:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6943: goto +1070 -> 8013
    //   6946: aload 14
    //   6948: aload 13
    //   6950: invokestatic 5294	com/tencent/biz/troopgift/GiftConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6953: goto +1060 -> 8013
    //   6956: aload_0
    //   6957: aload 14
    //   6959: aload 13
    //   6961: invokespecial 5296	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aP	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6964: goto +1049 -> 8013
    //   6967: aload_0
    //   6968: aload 14
    //   6970: aload 13
    //   6972: invokevirtual 5298	com/tencent/mobileqq/config/splashlogo/ConfigServlet:s	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6975: goto +1038 -> 8013
    //   6978: aload_0
    //   6979: aload 14
    //   6981: aload 13
    //   6983: invokevirtual 5300	com/tencent/mobileqq/config/splashlogo/ConfigServlet:u	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6986: goto +1027 -> 8013
    //   6989: aload_0
    //   6990: aload 14
    //   6992: aload 13
    //   6994: invokevirtual 5302	com/tencent/mobileqq/config/splashlogo/ConfigServlet:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6997: goto +1016 -> 8013
    //   7000: aload_0
    //   7001: aload 14
    //   7003: aload 13
    //   7005: invokevirtual 5304	com/tencent/mobileqq/config/splashlogo/ConfigServlet:v	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7008: goto +1005 -> 8013
    //   7011: aload_0
    //   7012: aload 14
    //   7014: aload 13
    //   7016: invokespecial 5306	com/tencent/mobileqq/config/splashlogo/ConfigServlet:af	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7019: goto +994 -> 8013
    //   7022: aload_0
    //   7023: aload 14
    //   7025: aload 13
    //   7027: invokespecial 5308	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ag	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7030: goto +983 -> 8013
    //   7033: aload_0
    //   7034: aload 14
    //   7036: aload 13
    //   7038: invokevirtual 5310	com/tencent/mobileqq/config/splashlogo/ConfigServlet:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7041: goto +972 -> 8013
    //   7044: aload_0
    //   7045: aload 14
    //   7047: aload 13
    //   7049: invokevirtual 5312	com/tencent/mobileqq/config/splashlogo/ConfigServlet:x	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7052: goto +961 -> 8013
    //   7055: aload 14
    //   7057: aload 13
    //   7059: invokestatic 5314	com/tencent/mobileqq/config/splashlogo/ConfigServlet:w	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7062: goto +951 -> 8013
    //   7065: aload 13
    //   7067: aload 14
    //   7069: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7072: invokestatic 1729	com/tencent/mobileqq/activity/richmedia/VideoFilterTools:a	(Landroid/content/Context;)I
    //   7075: sipush 199
    //   7078: invokestatic 2021	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   7081: astore 5
    //   7083: aload 5
    //   7085: ifnull +928 -> 8013
    //   7088: aload 14
    //   7090: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7093: aload 5
    //   7095: aload 13
    //   7097: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7100: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7103: invokestatic 5315	com/tencent/mobileqq/activity/richmedia/VideoFilterTools:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7106: goto +907 -> 8013
    //   7109: aload 13
    //   7111: aload 14
    //   7113: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7116: invokestatic 1732	com/tencent/mobileqq/richmedia/capture/data/CaptureVideoFilterManager:a	(Landroid/content/Context;)I
    //   7119: sipush 225
    //   7122: invokestatic 2021	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   7125: astore 5
    //   7127: aload 5
    //   7129: ifnull +884 -> 8013
    //   7132: invokestatic 5318	com/tencent/mobileqq/richmedia/capture/data/CaptureVideoFilterManager:a	()Lcom/tencent/mobileqq/richmedia/capture/data/CaptureVideoFilterManager;
    //   7135: aload 14
    //   7137: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7140: aload 5
    //   7142: aload 13
    //   7144: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7147: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7150: invokevirtual 5319	com/tencent/mobileqq/richmedia/capture/data/CaptureVideoFilterManager:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7153: goto +860 -> 8013
    //   7156: aload_0
    //   7157: aload 14
    //   7159: aload 13
    //   7161: invokevirtual 5321	com/tencent/mobileqq/config/splashlogo/ConfigServlet:y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7164: goto +849 -> 8013
    //   7167: aload_0
    //   7168: aload 14
    //   7170: aload 13
    //   7172: invokevirtual 5323	com/tencent/mobileqq/config/splashlogo/ConfigServlet:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7175: goto +838 -> 8013
    //   7178: aload_0
    //   7179: aload 14
    //   7181: aload 13
    //   7183: invokespecial 5325	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aQ	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7186: goto +827 -> 8013
    //   7189: aload 14
    //   7191: aload 13
    //   7193: invokestatic 5327	com/tencent/mobileqq/config/splashlogo/ConfigServlet:z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7196: goto +817 -> 8013
    //   7199: aload 14
    //   7201: aload 13
    //   7203: invokestatic 5329	com/tencent/mobileqq/config/splashlogo/ConfigServlet:R	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7206: goto +807 -> 8013
    //   7209: aload_0
    //   7210: aload 14
    //   7212: aload 13
    //   7214: invokespecial 5331	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aU	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7217: goto +796 -> 8013
    //   7220: aload_0
    //   7221: aload 13
    //   7223: invokespecial 5332	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7226: goto +787 -> 8013
    //   7229: aload 14
    //   7231: aload 13
    //   7233: invokestatic 5334	com/tencent/mobileqq/config/splashlogo/ConfigServlet:S	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7236: goto +777 -> 8013
    //   7239: aload_0
    //   7240: aload 14
    //   7242: aload 13
    //   7244: aload_3
    //   7245: ldc_w 5336
    //   7248: invokevirtual 1082	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   7251: invokespecial 5338	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)I
    //   7254: invokestatic 5339	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager:b	(I)V
    //   7257: goto +756 -> 8013
    //   7260: aload_0
    //   7261: aload 14
    //   7263: aload 13
    //   7265: aload_3
    //   7266: ldc_w 5336
    //   7269: invokevirtual 1082	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   7272: invokespecial 5341	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)I
    //   7275: invokestatic 5342	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	(I)V
    //   7278: goto +735 -> 8013
    //   7281: aload 14
    //   7283: getstatic 5345	com/tencent/mobileqq/app/QQManagerFactory:PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER	I
    //   7286: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7289: checkcast 5347	com/tencent/biz/pubaccount/Advertisement/manager/AdvertisementVideoPreloadManager
    //   7292: astore 5
    //   7294: aload 5
    //   7296: ifnull +717 -> 8013
    //   7299: aload 5
    //   7301: aload 14
    //   7303: aload 13
    //   7305: invokevirtual 5348	com/tencent/biz/pubaccount/Advertisement/manager/AdvertisementVideoPreloadManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7308: goto +705 -> 8013
    //   7311: aload_0
    //   7312: aload 14
    //   7314: aload 13
    //   7316: invokevirtual 5350	com/tencent/mobileqq/config/splashlogo/ConfigServlet:B	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7319: goto +694 -> 8013
    //   7322: aload_0
    //   7323: aload 14
    //   7325: aload 13
    //   7327: invokespecial 5352	com/tencent/mobileqq/config/splashlogo/ConfigServlet:W	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7330: goto +683 -> 8013
    //   7333: aload_0
    //   7334: aload 14
    //   7336: aload 13
    //   7338: invokevirtual 5354	com/tencent/mobileqq/config/splashlogo/ConfigServlet:A	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7341: goto +672 -> 8013
    //   7344: aload_0
    //   7345: aload 14
    //   7347: aload 13
    //   7349: invokevirtual 5356	com/tencent/mobileqq/config/splashlogo/ConfigServlet:I	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7352: goto +661 -> 8013
    //   7355: aload_0
    //   7356: aload 14
    //   7358: aload 13
    //   7360: invokevirtual 5358	com/tencent/mobileqq/config/splashlogo/ConfigServlet:C	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7363: goto +650 -> 8013
    //   7366: aload_0
    //   7367: aload 14
    //   7369: aload 13
    //   7371: invokevirtual 5360	com/tencent/mobileqq/config/splashlogo/ConfigServlet:D	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7374: goto +639 -> 8013
    //   7377: aload_0
    //   7378: aload 14
    //   7380: aload 13
    //   7382: invokevirtual 5362	com/tencent/mobileqq/config/splashlogo/ConfigServlet:E	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7385: goto +628 -> 8013
    //   7388: aload_0
    //   7389: aload 14
    //   7391: aload 13
    //   7393: invokevirtual 5364	com/tencent/mobileqq/config/splashlogo/ConfigServlet:F	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7396: goto +617 -> 8013
    //   7399: aload_0
    //   7400: aload 14
    //   7402: aload 13
    //   7404: invokevirtual 5366	com/tencent/mobileqq/config/splashlogo/ConfigServlet:G	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7407: goto +606 -> 8013
    //   7410: aload_0
    //   7411: aload 14
    //   7413: aload 13
    //   7415: invokevirtual 5368	com/tencent/mobileqq/config/splashlogo/ConfigServlet:H	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7418: goto +595 -> 8013
    //   7421: aload_0
    //   7422: aload 14
    //   7424: aload 13
    //   7426: invokespecial 5370	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ah	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7429: goto +584 -> 8013
    //   7432: aload_0
    //   7433: aload 14
    //   7435: aload 13
    //   7437: invokespecial 5372	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ai	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7440: goto +573 -> 8013
    //   7443: aload_0
    //   7444: aload 14
    //   7446: aload 13
    //   7448: invokespecial 5374	com/tencent/mobileqq/config/splashlogo/ConfigServlet:V	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7451: goto +562 -> 8013
    //   7454: aload_0
    //   7455: aload 14
    //   7457: aload 13
    //   7459: invokevirtual 5376	com/tencent/mobileqq/config/splashlogo/ConfigServlet:J	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7462: goto +551 -> 8013
    //   7465: aload 14
    //   7467: aload 13
    //   7469: invokestatic 5379	com/tencent/mobileqq/troop/logic/HomeworkTroopController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7472: goto +541 -> 8013
    //   7475: aload 14
    //   7477: getstatic 1807	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   7480: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7483: checkcast 1809	com/tencent/mobileqq/app/TroopManager
    //   7486: getfield 1812	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqTroopHomeworkConfigHomeworkConfig	Lcom/tencent/mobileqq/troop/homework/config/HomeworkConfig;
    //   7489: aload 14
    //   7491: aload 13
    //   7493: invokevirtual 5380	com/tencent/mobileqq/troop/homework/config/HomeworkConfig:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7496: goto +517 -> 8013
    //   7499: aload 14
    //   7501: getstatic 1807	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   7504: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7507: checkcast 1809	com/tencent/mobileqq/app/TroopManager
    //   7510: getfield 1820	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteConfigReciteConfig	Lcom/tencent/mobileqq/troop/homework/recite/config/ReciteConfig;
    //   7513: aload 14
    //   7515: aload 13
    //   7517: invokevirtual 5381	com/tencent/mobileqq/troop/homework/recite/config/ReciteConfig:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7520: goto +493 -> 8013
    //   7523: aload 14
    //   7525: invokestatic 5386	com/tencent/biz/qqstory/base/QQStoryFeedManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/biz/qqstory/base/QQStoryFeedManager;
    //   7528: aload 13
    //   7530: invokevirtual 5387	com/tencent/biz/qqstory/base/QQStoryFeedManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7533: goto +480 -> 8013
    //   7536: aload 14
    //   7538: getstatic 5390	com/tencent/mobileqq/app/QQManagerFactory:STORY_HALO_MANAGER	I
    //   7541: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7544: checkcast 5392	com/tencent/biz/qqstory/base/StoryHaloManager
    //   7547: aload 13
    //   7549: invokevirtual 5393	com/tencent/biz/qqstory/base/StoryHaloManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7552: goto +461 -> 8013
    //   7555: invokestatic 1831	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:a	()Lcom/tencent/mobileqq/haoliyou/orion/ZhuoXusManager;
    //   7558: getfield 1834	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:a	Lcom/tencent/mobileqq/haoliyou/orion/ZhuoXusManager$ConfigLoader;
    //   7561: aload 13
    //   7563: invokevirtual 5394	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager$ConfigLoader:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7566: goto +447 -> 8013
    //   7569: astore 5
    //   7571: aload 5
    //   7573: invokevirtual 1592	java/lang/Throwable:printStackTrace	()V
    //   7576: goto +437 -> 8013
    //   7579: aload 14
    //   7581: aload 13
    //   7583: invokestatic 5397	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   7586: pop
    //   7587: goto +426 -> 8013
    //   7590: aload_0
    //   7591: aload 14
    //   7593: aload 13
    //   7595: invokevirtual 5399	com/tencent/mobileqq/config/splashlogo/ConfigServlet:K	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7598: goto +415 -> 8013
    //   7601: aload_0
    //   7602: aload 14
    //   7604: aload 13
    //   7606: invokevirtual 5401	com/tencent/mobileqq/config/splashlogo/ConfigServlet:L	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7609: goto +404 -> 8013
    //   7612: aload_0
    //   7613: aload 14
    //   7615: aload 13
    //   7617: invokevirtual 5403	com/tencent/mobileqq/config/splashlogo/ConfigServlet:M	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7620: goto +393 -> 8013
    //   7623: aload 14
    //   7625: aload 13
    //   7627: iload 8
    //   7629: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7632: invokestatic 5408	com/tencent/mobileqq/statistics/QZoneReport:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;ILjava/lang/String;)V
    //   7635: goto +378 -> 8013
    //   7638: aload_0
    //   7639: aload 14
    //   7641: aload 13
    //   7643: invokevirtual 5410	com/tencent/mobileqq/config/splashlogo/ConfigServlet:P	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7646: goto +367 -> 8013
    //   7649: aload 14
    //   7651: iload 8
    //   7653: aload 13
    //   7655: invokestatic 5415	com/tencent/mobileqq/data/nativemonitor/NativeMonitorConfigHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7658: goto +355 -> 8013
    //   7661: aload 14
    //   7663: invokestatic 5420	com/tencent/mobileqq/flashchat/RichTextChatManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/flashchat/RichTextChatManager;
    //   7666: aload 14
    //   7668: iload 8
    //   7670: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7673: aload 13
    //   7675: invokevirtual 5423	com/tencent/mobileqq/flashchat/RichTextChatManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/Integer;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7678: goto +335 -> 8013
    //   7681: aload_0
    //   7682: aload 14
    //   7684: aload 13
    //   7686: invokevirtual 5425	com/tencent/mobileqq/config/splashlogo/ConfigServlet:N	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7689: goto +324 -> 8013
    //   7692: aload_0
    //   7693: aload 14
    //   7695: aload 13
    //   7697: invokevirtual 5427	com/tencent/mobileqq/config/splashlogo/ConfigServlet:O	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7700: goto +313 -> 8013
    //   7703: aload 14
    //   7705: getstatic 1873	com/tencent/mobileqq/app/QQManagerFactory:QQSTORY_MANAGER	I
    //   7708: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7711: checkcast 1875	com/tencent/biz/qqstory/base/QQStoryManager
    //   7714: getfield 1878	com/tencent/biz/qqstory/base/QQStoryManager:a	Lcom/tencent/biz/qqstory/config/TextFilterConfig;
    //   7717: aload 14
    //   7719: aload 13
    //   7721: invokevirtual 5428	com/tencent/biz/qqstory/config/TextFilterConfig:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7724: goto +289 -> 8013
    //   7727: aload_0
    //   7728: aload 14
    //   7730: aload 13
    //   7732: invokespecial 5430	com/tencent/mobileqq/config/splashlogo/ConfigServlet:U	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7735: goto +278 -> 8013
    //   7738: aload 14
    //   7740: aload 13
    //   7742: invokestatic 5432	com/tencent/mobileqq/config/splashlogo/ConfigServlet:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7745: goto +268 -> 8013
    //   7748: aload 14
    //   7750: iload 8
    //   7752: aload 13
    //   7754: invokestatic 5435	com/tencent/mobileqq/wifi/FreeWifiHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7757: goto +256 -> 8013
    //   7760: aload 14
    //   7762: getstatic 1807	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   7765: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7768: checkcast 1809	com/tencent/mobileqq/app/TroopManager
    //   7771: getfield 1894	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentBizTroopconfigTroopConfigForAllUser	Lcom/tencent/biz/troopconfig/TroopConfigForAllUser;
    //   7774: aload 14
    //   7776: aload 13
    //   7778: invokevirtual 5436	com/tencent/biz/troopconfig/TroopConfigForAllUser:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7781: goto +232 -> 8013
    //   7784: aload_0
    //   7785: aload 14
    //   7787: aload 13
    //   7789: iload 8
    //   7791: invokespecial 5437	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   7794: goto +219 -> 8013
    //   7797: aload 14
    //   7799: aload 13
    //   7801: invokestatic 5439	com/tencent/mobileqq/config/splashlogo/ConfigServlet:Q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7804: goto +209 -> 8013
    //   7807: aload_0
    //   7808: aload 14
    //   7810: aload 13
    //   7812: invokespecial 5441	com/tencent/mobileqq/config/splashlogo/ConfigServlet:T	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7815: goto +198 -> 8013
    //   7818: aload 14
    //   7820: getstatic 5444	com/tencent/mobileqq/app/QQManagerFactory:NOW_DYNAMIC_MANAGER	I
    //   7823: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7826: checkcast 5446	com/tencent/mobileqq/intervideo/now/dynamic/DynamicNowManager
    //   7829: aload 13
    //   7831: invokevirtual 5447	com/tencent/mobileqq/intervideo/now/dynamic/DynamicNowManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7834: goto +179 -> 8013
    //   7837: aload_0
    //   7838: aload 14
    //   7840: aload 13
    //   7842: invokespecial 5449	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aS	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7845: goto +168 -> 8013
    //   7848: aload 14
    //   7850: getstatic 5452	com/tencent/mobileqq/app/QQManagerFactory:GROUP_VIDEO_PLUGIN_MANAGER	I
    //   7853: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7856: checkcast 5454	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager
    //   7859: aload 13
    //   7861: invokevirtual 5455	com/tencent/mobileqq/intervideo/groupvideo/GroupVideoManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7864: goto +149 -> 8013
    //   7867: aload_0
    //   7868: aload 14
    //   7870: aload 13
    //   7872: invokespecial 5457	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aT	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7875: goto +138 -> 8013
    //   7878: aload_0
    //   7879: aload 14
    //   7881: aload 13
    //   7883: iload 8
    //   7885: invokespecial 5459	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   7888: goto +125 -> 8013
    //   7891: aload_0
    //   7892: aload 14
    //   7894: aload 13
    //   7896: invokespecial 5461	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aV	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7899: goto +114 -> 8013
    //   7902: aload_1
    //   7903: ifnull +73 -> 7976
    //   7906: iload 11
    //   7908: ifne +34 -> 7942
    //   7911: aload 14
    //   7913: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7916: ldc_w 4382
    //   7919: invokestatic 4385	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   7922: ifne +20 -> 7942
    //   7925: aload 14
    //   7927: getstatic 4414	com/tencent/mobileqq/app/QQManagerFactory:TIM_UPGRADE_DOWNLOAD_MANAGER	I
    //   7930: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7933: checkcast 4416	com/tencent/mobileqq/upgrade/UpgradeTIMManager
    //   7936: aload 14
    //   7938: aload_1
    //   7939: invokevirtual 5462	com/tencent/mobileqq/upgrade/UpgradeTIMManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   7942: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7945: ifeq +30 -> 7975
    //   7948: ldc 77
    //   7950: iconst_2
    //   7951: new 79	java/lang/StringBuilder
    //   7954: dup
    //   7955: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   7958: ldc_w 5464
    //   7961: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7964: iload 11
    //   7966: invokevirtual 436	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7969: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7972: invokestatic 2007	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   7975: return
    //   7976: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7979: ifeq -37 -> 7942
    //   7982: ldc_w 1534
    //   7985: iconst_2
    //   7986: ldc_w 5466
    //   7989: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7992: goto -50 -> 7942
    //   7995: aconst_null
    //   7996: astore 5
    //   7998: goto -3012 -> 4986
    //   8001: aload_1
    //   8002: astore 5
    //   8004: goto -6243 -> 1761
    //   8007: aconst_null
    //   8008: astore 5
    //   8010: goto -6376 -> 1634
    //   8013: aload_1
    //   8014: astore 5
    //   8016: iload 11
    //   8018: istore 12
    //   8020: goto -7964 -> 56
    //   8023: aconst_null
    //   8024: astore 5
    //   8026: goto -6392 -> 1634
    //   8029: astore 13
    //   8031: goto -6164 -> 1867
    //   8034: iconst_0
    //   8035: istore 11
    //   8037: goto -5524 -> 2513
    //   8040: iload 8
    //   8042: iconst_1
    //   8043: iadd
    //   8044: istore 8
    //   8046: goto -5422 -> 2624
    //   8049: goto -36 -> 8013
    //   8052: iload 8
    //   8054: iconst_1
    //   8055: iadd
    //   8056: istore 8
    //   8058: goto -5246 -> 2812
    //   8061: goto -48 -> 8013
    //   8064: iload 8
    //   8066: iconst_1
    //   8067: iadd
    //   8068: istore 8
    //   8070: goto -4819 -> 3251
    //   8073: goto -60 -> 8013
    //   8076: goto -63 -> 8013
    //   8079: iload 8
    //   8081: iconst_1
    //   8082: iadd
    //   8083: istore 8
    //   8085: goto -3934 -> 4151
    //   8088: iload 9
    //   8090: istore 8
    //   8092: goto -3405 -> 4687
    //   8095: goto -82 -> 8013
    //   8098: goto -85 -> 8013
    //   8101: goto -88 -> 8013
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8104	0	this	ConfigServlet
    //   0	8104	1	paramAppRuntime	AppRuntime
    //   0	8104	2	paramRespGetConfig	ConfigurationService.RespGetConfig
    //   0	8104	3	paramIntent	Intent
    //   0	8104	4	paramList	List<Integer>
    //   0	8104	5	paramArrayOfInt	int[]
    //   0	8104	6	paramBoolean	boolean
    //   21	40	7	i	int
    //   98	7993	8	j	int
    //   1966	6123	9	k	int
    //   13	152	10	m	int
    //   18	8018	11	bool1	boolean
    //   51	7968	12	bool2	boolean
    //   42	1660	13	localObject1	Object
    //   1865	160	13	localException1	Exception
    //   2100	451	13	localUpgradeDetailWrapper	UpgradeDetailWrapper
    //   2556	5339	13	localException2	Exception
    //   8029	1	13	localException3	Exception
    //   4	7933	14	localQQAppInterface	QQAppInterface
    //   1613	4293	15	localObject2	Object
    //   4349	223	16	localObject3	Object
    //   4395	13	17	localIterator	Iterator
    //   4417	55	18	str	String
    // Exception table:
    //   from	to	target	type
    //   1620	1634	1767	java/io/UnsupportedEncodingException
    //   1620	1634	1783	java/lang/OutOfMemoryError
    //   1799	1813	1816	java/lang/Throwable
    //   1704	1747	1865	java/lang/Exception
    //   1747	1758	1865	java/lang/Exception
    //   1843	1859	1865	java/lang/Exception
    //   2446	2469	2548	finally
    //   2469	2472	2548	finally
    //   2478	2493	2548	finally
    //   2493	2510	2548	finally
    //   2513	2520	2548	finally
    //   2520	2542	2548	finally
    //   2550	2553	2548	finally
    //   2429	2446	2556	java/lang/Exception
    //   2553	2556	2556	java/lang/Exception
    //   5583	5617	5708	java/lang/Exception
    //   5617	5689	5708	java/lang/Exception
    //   5689	5705	5708	java/lang/Exception
    //   5754	5793	5708	java/lang/Exception
    //   5796	5830	5921	java/lang/Exception
    //   5830	5902	5921	java/lang/Exception
    //   5902	5918	5921	java/lang/Exception
    //   5967	6006	5921	java/lang/Exception
    //   7555	7566	7569	java/lang/Throwable
    //   1532	1546	8029	java/lang/Exception
    //   1549	1582	8029	java/lang/Exception
    //   1587	1615	8029	java/lang/Exception
    //   1620	1634	8029	java/lang/Exception
    //   1639	1694	8029	java/lang/Exception
    //   1694	1701	8029	java/lang/Exception
    //   1769	1780	8029	java/lang/Exception
    //   1785	1796	8029	java/lang/Exception
    //   1796	1799	8029	java/lang/Exception
    //   1799	1813	8029	java/lang/Exception
    //   1824	1837	8029	java/lang/Exception
    //   1923	1939	8029	java/lang/Exception
    //   1945	2006	8029	java/lang/Exception
    //   2016	2035	8029	java/lang/Exception
    //   2035	2050	8029	java/lang/Exception
    //   2050	2060	8029	java/lang/Exception
    //   2060	2073	8029	java/lang/Exception
    //   2073	2154	8029	java/lang/Exception
    //   2154	2251	8029	java/lang/Exception
    //   2251	2280	8029	java/lang/Exception
    //   2280	2323	8029	java/lang/Exception
    //   2326	2373	8029	java/lang/Exception
    //   2373	2391	8029	java/lang/Exception
    //   2394	2405	8029	java/lang/Exception
    //   2408	2423	8029	java/lang/Exception
    //   2564	2580	8029	java/lang/Exception
    //   2583	2621	8029	java/lang/Exception
    //   2624	2702	8029	java/lang/Exception
    //   2702	2726	8029	java/lang/Exception
    //   2729	2768	8029	java/lang/Exception
    //   2771	2809	8029	java/lang/Exception
    //   2812	2890	8029	java/lang/Exception
    //   2890	2915	8029	java/lang/Exception
    //   2918	2957	8029	java/lang/Exception
    //   2960	3003	8029	java/lang/Exception
    //   3006	3078	8029	java/lang/Exception
    //   3078	3093	8029	java/lang/Exception
    //   3093	3165	8029	java/lang/Exception
    //   3165	3220	8029	java/lang/Exception
    //   3228	3248	8029	java/lang/Exception
    //   3270	3284	8029	java/lang/Exception
    //   3287	3326	8029	java/lang/Exception
    //   3326	3371	8029	java/lang/Exception
    //   3376	3382	8029	java/lang/Exception
    //   3382	3403	8029	java/lang/Exception
    //   3406	3446	8029	java/lang/Exception
    //   3446	3518	8029	java/lang/Exception
    //   3518	3534	8029	java/lang/Exception
    //   3537	3554	8029	java/lang/Exception
    //   3559	3569	8029	java/lang/Exception
    //   3569	3725	8029	java/lang/Exception
    //   3728	3767	8029	java/lang/Exception
    //   3767	3796	8029	java/lang/Exception
    //   3801	3811	8029	java/lang/Exception
    //   3811	3881	8029	java/lang/Exception
    //   3884	3967	8029	java/lang/Exception
    //   3967	3983	8029	java/lang/Exception
    //   3986	4025	8029	java/lang/Exception
    //   4025	4096	8029	java/lang/Exception
    //   4096	4117	8029	java/lang/Exception
    //   4120	4148	8029	java/lang/Exception
    //   4151	4229	8029	java/lang/Exception
    //   4229	4237	8029	java/lang/Exception
    //   4242	4250	8029	java/lang/Exception
    //   4253	4286	8029	java/lang/Exception
    //   4289	4328	8029	java/lang/Exception
    //   4331	4397	8029	java/lang/Exception
    //   4397	4469	8029	java/lang/Exception
    //   4469	4494	8029	java/lang/Exception
    //   4497	4536	8029	java/lang/Exception
    //   4536	4565	8029	java/lang/Exception
    //   4568	4615	8029	java/lang/Exception
    //   4615	4628	8029	java/lang/Exception
    //   4631	4646	8029	java/lang/Exception
    //   4649	4664	8029	java/lang/Exception
    //   4669	4687	8029	java/lang/Exception
    //   4687	4788	8029	java/lang/Exception
    //   4788	4797	8029	java/lang/Exception
    //   4800	4831	8029	java/lang/Exception
    //   4840	4871	8029	java/lang/Exception
    //   4874	4918	8029	java/lang/Exception
    //   4925	4954	8029	java/lang/Exception
    //   4957	4986	8029	java/lang/Exception
    //   4991	5064	8029	java/lang/Exception
    //   5064	5078	8029	java/lang/Exception
    //   5078	5150	8029	java/lang/Exception
    //   5150	5158	8029	java/lang/Exception
    //   5158	5178	8029	java/lang/Exception
    //   5181	5227	8029	java/lang/Exception
    //   5230	5246	8029	java/lang/Exception
    //   5249	5258	8029	java/lang/Exception
    //   5261	5270	8029	java/lang/Exception
    //   5273	5282	8029	java/lang/Exception
    //   5285	5293	8029	java/lang/Exception
    //   5296	5304	8029	java/lang/Exception
    //   5307	5414	8029	java/lang/Exception
    //   5417	5456	8029	java/lang/Exception
    //   5459	5468	8029	java/lang/Exception
    //   5471	5480	8029	java/lang/Exception
    //   5483	5492	8029	java/lang/Exception
    //   5495	5504	8029	java/lang/Exception
    //   5507	5516	8029	java/lang/Exception
    //   5519	5528	8029	java/lang/Exception
    //   5531	5539	8029	java/lang/Exception
    //   5542	5550	8029	java/lang/Exception
    //   5553	5561	8029	java/lang/Exception
    //   5564	5580	8029	java/lang/Exception
    //   5710	5746	8029	java/lang/Exception
    //   5746	5751	8029	java/lang/Exception
    //   5923	5959	8029	java/lang/Exception
    //   5959	5964	8029	java/lang/Exception
    //   6009	6017	8029	java/lang/Exception
    //   6020	6028	8029	java/lang/Exception
    //   6031	6039	8029	java/lang/Exception
    //   6042	6050	8029	java/lang/Exception
    //   6053	6061	8029	java/lang/Exception
    //   6064	6072	8029	java/lang/Exception
    //   6075	6083	8029	java/lang/Exception
    //   6086	6094	8029	java/lang/Exception
    //   6097	6105	8029	java/lang/Exception
    //   6108	6116	8029	java/lang/Exception
    //   6119	6127	8029	java/lang/Exception
    //   6130	6138	8029	java/lang/Exception
    //   6141	6149	8029	java/lang/Exception
    //   6152	6160	8029	java/lang/Exception
    //   6163	6171	8029	java/lang/Exception
    //   6174	6182	8029	java/lang/Exception
    //   6185	6193	8029	java/lang/Exception
    //   6196	6204	8029	java/lang/Exception
    //   6207	6215	8029	java/lang/Exception
    //   6218	6226	8029	java/lang/Exception
    //   6229	6247	8029	java/lang/Exception
    //   6250	6258	8029	java/lang/Exception
    //   6261	6269	8029	java/lang/Exception
    //   6272	6280	8029	java/lang/Exception
    //   6283	6291	8029	java/lang/Exception
    //   6294	6384	8029	java/lang/Exception
    //   6384	6434	8029	java/lang/Exception
    //   6437	6487	8029	java/lang/Exception
    //   6490	6498	8029	java/lang/Exception
    //   6501	6519	8029	java/lang/Exception
    //   6522	6531	8029	java/lang/Exception
    //   6534	6543	8029	java/lang/Exception
    //   6546	6555	8029	java/lang/Exception
    //   6558	6567	8029	java/lang/Exception
    //   6570	6579	8029	java/lang/Exception
    //   6582	6590	8029	java/lang/Exception
    //   6593	6601	8029	java/lang/Exception
    //   6604	6616	8029	java/lang/Exception
    //   6619	6627	8029	java/lang/Exception
    //   6630	6646	8029	java/lang/Exception
    //   6649	6657	8029	java/lang/Exception
    //   6660	6668	8029	java/lang/Exception
    //   6671	6679	8029	java/lang/Exception
    //   6682	6690	8029	java/lang/Exception
    //   6693	6701	8029	java/lang/Exception
    //   6704	6712	8029	java/lang/Exception
    //   6715	6723	8029	java/lang/Exception
    //   6726	6734	8029	java/lang/Exception
    //   6737	6745	8029	java/lang/Exception
    //   6748	6753	8029	java/lang/Exception
    //   6756	6764	8029	java/lang/Exception
    //   6767	6775	8029	java/lang/Exception
    //   6778	6786	8029	java/lang/Exception
    //   6789	6797	8029	java/lang/Exception
    //   6800	6808	8029	java/lang/Exception
    //   6811	6820	8029	java/lang/Exception
    //   6823	6831	8029	java/lang/Exception
    //   6834	6842	8029	java/lang/Exception
    //   6845	6853	8029	java/lang/Exception
    //   6856	6877	8029	java/lang/Exception
    //   6880	6888	8029	java/lang/Exception
    //   6891	6899	8029	java/lang/Exception
    //   6902	6910	8029	java/lang/Exception
    //   6913	6921	8029	java/lang/Exception
    //   6924	6932	8029	java/lang/Exception
    //   6935	6943	8029	java/lang/Exception
    //   6946	6953	8029	java/lang/Exception
    //   6956	6964	8029	java/lang/Exception
    //   6967	6975	8029	java/lang/Exception
    //   6978	6986	8029	java/lang/Exception
    //   6989	6997	8029	java/lang/Exception
    //   7000	7008	8029	java/lang/Exception
    //   7011	7019	8029	java/lang/Exception
    //   7022	7030	8029	java/lang/Exception
    //   7033	7041	8029	java/lang/Exception
    //   7044	7052	8029	java/lang/Exception
    //   7055	7062	8029	java/lang/Exception
    //   7065	7083	8029	java/lang/Exception
    //   7088	7106	8029	java/lang/Exception
    //   7109	7127	8029	java/lang/Exception
    //   7132	7153	8029	java/lang/Exception
    //   7156	7164	8029	java/lang/Exception
    //   7167	7175	8029	java/lang/Exception
    //   7178	7186	8029	java/lang/Exception
    //   7189	7196	8029	java/lang/Exception
    //   7199	7206	8029	java/lang/Exception
    //   7209	7217	8029	java/lang/Exception
    //   7220	7226	8029	java/lang/Exception
    //   7229	7236	8029	java/lang/Exception
    //   7239	7257	8029	java/lang/Exception
    //   7260	7278	8029	java/lang/Exception
    //   7281	7294	8029	java/lang/Exception
    //   7299	7308	8029	java/lang/Exception
    //   7311	7319	8029	java/lang/Exception
    //   7322	7330	8029	java/lang/Exception
    //   7333	7341	8029	java/lang/Exception
    //   7344	7352	8029	java/lang/Exception
    //   7355	7363	8029	java/lang/Exception
    //   7366	7374	8029	java/lang/Exception
    //   7377	7385	8029	java/lang/Exception
    //   7388	7396	8029	java/lang/Exception
    //   7399	7407	8029	java/lang/Exception
    //   7410	7418	8029	java/lang/Exception
    //   7421	7429	8029	java/lang/Exception
    //   7432	7440	8029	java/lang/Exception
    //   7443	7451	8029	java/lang/Exception
    //   7454	7462	8029	java/lang/Exception
    //   7465	7472	8029	java/lang/Exception
    //   7475	7496	8029	java/lang/Exception
    //   7499	7520	8029	java/lang/Exception
    //   7523	7533	8029	java/lang/Exception
    //   7536	7552	8029	java/lang/Exception
    //   7555	7566	8029	java/lang/Exception
    //   7571	7576	8029	java/lang/Exception
    //   7579	7587	8029	java/lang/Exception
    //   7590	7598	8029	java/lang/Exception
    //   7601	7609	8029	java/lang/Exception
    //   7612	7620	8029	java/lang/Exception
    //   7623	7635	8029	java/lang/Exception
    //   7638	7646	8029	java/lang/Exception
    //   7649	7658	8029	java/lang/Exception
    //   7661	7678	8029	java/lang/Exception
    //   7681	7689	8029	java/lang/Exception
    //   7692	7700	8029	java/lang/Exception
    //   7703	7724	8029	java/lang/Exception
    //   7727	7735	8029	java/lang/Exception
    //   7738	7745	8029	java/lang/Exception
    //   7748	7757	8029	java/lang/Exception
    //   7760	7781	8029	java/lang/Exception
    //   7784	7794	8029	java/lang/Exception
    //   7797	7804	8029	java/lang/Exception
    //   7807	7815	8029	java/lang/Exception
    //   7818	7834	8029	java/lang/Exception
    //   7837	7845	8029	java/lang/Exception
    //   7848	7864	8029	java/lang/Exception
    //   7867	7875	8029	java/lang/Exception
    //   7878	7888	8029	java/lang/Exception
    //   7891	7899	8029	java/lang/Exception
  }
  
  public void a(AppRuntime paramAppRuntime, ConfigurationService.RespGetConfig paramRespGetConfig, Intent paramIntent, int[] paramArrayOfInt, boolean paramBoolean)
  {
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    if ((!paramBoolean) || (paramRespGetConfig.result.get() != 0) || (paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0))
    {
      int i = 0;
      if (i < paramArrayOfInt.length)
      {
        int j = paramArrayOfInt[i];
        if (QConfigManager.a().b(j)) {}
        for (;;)
        {
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "receiveAllConfigs|failed type: " + j);
          }
          switch (j)
          {
          case 156: 
          default: 
            paramAppRuntime.getConfigProcess().a(paramAppRuntime, j, paramBoolean, paramRespGetConfig.result.get());
            break;
          case 149: 
          case 180: 
          case 218: 
            QAVConfig.a(j, paramBoolean, paramRespGetConfig);
            break;
          case 116: 
            if ((!paramBoolean) || (paramRespGetConfig.result.get() != 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE get config fail.");
              }
              if (!this.jdField_a_of_type_Boolean)
              {
                ReportController.b(paramAppRuntime, "CliOper", "", "", "0X800716D", "0X800716D", 0, 0, "", "", "", "");
                this.jdField_a_of_type_Boolean = true;
              }
              ((ConfigHandler)paramAppRuntime.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a(UpgradeController.a().a());
            }
            break;
          case 46: 
            if (paramRespGetConfig.result.get() != 0) {
              PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, paramAppRuntime.getCurrentUin(), "actPatchConfig", 101, "");
            }
            for (;;)
            {
              SafeModeUtil.c();
              break;
              if ((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) {
                PatchFileManager.a(paramAppRuntime);
              }
            }
          case 283: 
            SafeModeUtil.c();
            break;
          case 69: 
            if ((!paramBoolean) || (paramRespGetConfig.result.get() != 0))
            {
              paramIntent = (PasswdRedBagManager)paramAppRuntime.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
              paramIntent.jdField_b_of_type_Boolean = true;
              paramIntent.c = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
              paramIntent.jdField_a_of_type_Int = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
              paramIntent.e = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
              SharedPreUtils.a(paramAppRuntime.getApp(), paramAppRuntime.getAccount(), 0, paramIntent.c, paramIntent.jdField_a_of_type_Int, paramIntent.d, paramIntent.e);
            }
            break;
          case 88: 
            if (!paramBoolean)
            {
              OlympicServlet.a(paramAppRuntime, 88, 0, 0, 1, 1, 0);
              if (QLog.isColorLevel()) {
                QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||isSuccess =" + paramBoolean);
              }
            }
            else if (paramRespGetConfig.result.get() != 0)
            {
              j = paramRespGetConfig.result.get();
              OlympicServlet.a(paramAppRuntime, 88, 0, 0, 1, j, 0);
              if (QLog.isColorLevel()) {
                QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||result =" + j);
              }
            }
            else if (((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) && (QLog.isColorLevel()))
            {
              QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||config_list is null");
            }
            break;
          case 87: 
            if (!paramBoolean)
            {
              OlympicServlet.a(paramAppRuntime, 87, 0, 0, 1, 1, 0);
              if (QLog.isColorLevel()) {
                QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||isSuccess =" + paramBoolean);
              }
            }
            for (;;)
            {
              paramIntent = (ArResourceManager)paramAppRuntime.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
              if (paramIntent == null) {
                break;
              }
              paramIntent.a(true, false);
              break;
              if (paramRespGetConfig.result.get() != 0)
              {
                j = paramRespGetConfig.result.get();
                OlympicServlet.a(paramAppRuntime, 87, 0, 0, 1, j, 0);
                if (QLog.isColorLevel()) {
                  QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||result =" + j);
                }
              }
              else if (((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) && (QLog.isColorLevel()))
              {
                QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||config_list is null");
              }
            }
          case 86: 
            if (!paramBoolean)
            {
              OlympicServlet.a(paramAppRuntime, 86, 0, 0, 1, 1, 0);
              if (QLog.isColorLevel()) {
                QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig||isSuccess =" + paramBoolean);
              }
            }
            for (;;)
            {
              paramIntent = (OlympicManager)paramAppRuntime.getManager(QQManagerFactory.OLYMPIC_MANAGER);
              if (paramIntent == null) {
                break;
              }
              paramIntent.f();
              paramIntent.g();
              break;
              if (paramRespGetConfig.result.get() != 0)
              {
                j = paramRespGetConfig.result.get();
                OlympicServlet.a(paramAppRuntime, 86, 0, 0, 1, j, 0);
                if (QLog.isColorLevel()) {
                  QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig||result =" + j);
                }
              }
              else if (((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) && (QLog.isColorLevel()))
              {
                QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig||config_list is null");
              }
            }
          case 119: 
            paramIntent = (BabyQHandler)paramAppRuntime.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
            if (paramIntent != null) {
              paramIntent.a(false, false);
            }
            break;
          case 113: 
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "precover PRECOVER_CONFIG_CMD, failed");
            }
            paramIntent = (PrecoverManager)paramAppRuntime.getManager(QQManagerFactory.PRECOVER_MANAGER);
            if (paramIntent != null)
            {
              paramIntent.a();
              paramIntent.a(false);
            }
            break;
          case 223: 
          case 364: 
          case 365: 
            BusinessCommonConfig.getInstance(paramAppRuntime).handleResp_Config_Fail(paramAppRuntime, j, paramBoolean, paramRespGetConfig);
            break;
          case 188: 
            if (QLog.isColorLevel())
            {
              j = paramRespGetConfig.result.get();
              QLog.d("SPLASH_ConfigServlet", 2, "AR_GLOBAL_CONTROL_COFIG failed, resultCode:" + j);
            }
            break;
          case 206: 
            if (QLog.isColorLevel())
            {
              j = paramRespGetConfig.result.get();
              QLog.d("SPLASH_ConfigServlet", 2, "AR_SCAN_STAR_FACE_CONFIG failed, resultCode:" + j);
            }
            break;
          case 140: 
            j = paramRespGetConfig.result.get();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "ScanFu. GET_SCAN_FU_CONFIG failed, resultCode:" + j);
            }
            paramIntent = new HashMap();
            paramIntent.put("failedCode", j + "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pullMedalConfigFailed", false, 0L, 0L, paramIntent, null);
            break;
          case 257: 
            if (QLog.isColorLevel())
            {
              j = paramRespGetConfig.result.get();
              QLog.d("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "MEDAL_STRONG_REMINDER_CONFIG fail code: %s", new Object[] { Integer.valueOf(j) }));
            }
            break;
          case 260: 
            if (QLog.isColorLevel())
            {
              j = paramRespGetConfig.result.get();
              QLog.d("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "PUSH_RECOMMEND_SHIELD_CONFIG fail code: %s", new Object[] { Integer.valueOf(j) }));
            }
            break;
          case 165: 
            if (QLog.isColorLevel())
            {
              j = paramRespGetConfig.result.get();
              QLog.d("SPLASH_ConfigServlet", 2, "BuluoRedDot. BULUO_REDDOT_CONFIG failed, resultCode:" + j);
            }
            break;
          case 604: 
            QLog.e("SPLASH_ConfigServlet", 1, new Object[] { "get dev manage switch failed : ", Integer.valueOf(paramRespGetConfig.result.get()) });
            break;
          case 705: 
            QLog.e("SPLASH_ConfigServlet", 1, new Object[] { "get local qr login switch failed : ", Integer.valueOf(paramRespGetConfig.result.get()) });
            break;
          case 174: 
            if (QLog.isColorLevel())
            {
              j = paramRespGetConfig.result.get();
              QLog.d("SPLASH_ConfigServlet", 2, "Nearby. NEARBY_TABS_CONFIG failed, resultCode:" + j);
            }
            break;
          case 273: 
            if (QLog.isColorLevel())
            {
              j = paramRespGetConfig.result.get();
              QLog.d("GiftConfigManager", 2, "get config failed, resultCode:" + j);
            }
            break;
          case 185: 
            ScribbleResMgr.a().b();
            break;
          case 321: 
            if (QLog.isColorLevel())
            {
              j = paramRespGetConfig.result.get();
              QLog.d("SPLASH_ConfigServlet", 2, "SCRIBBLE_RED_SWITCH_CONFIG.  failed, resultCode:" + j);
            }
            break;
          case 202: 
            if (QLog.isColorLevel())
            {
              j = paramRespGetConfig.result.get();
              QLog.d("CU_OPEN_CARD_GUIDE", 2, "failed, resultCode:" + j);
            }
            break;
          case 210: 
            paramIntent = (OCRManager)paramAppRuntime.getManager(QQManagerFactory.OCR_MANAGER);
            j = paramRespGetConfig.result.get();
            QLog.d("SPLASH_ConfigServlet", 1, "OCR_CONFIG failed, resultCode:" + j);
            paramIntent.a(false, null);
            break;
          case 215: 
            AEOldShortVideoResManager.a(paramRespGetConfig.result.get());
            break;
          case 718: 
            ShortVideoResourceManager.a(paramRespGetConfig.result.get());
          }
        }
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, List<Integer> paramList)
  {
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Integer)localIterator.next();
      if (!QConfigManager.a().b(((Integer)localObject1).intValue()))
      {
        if (QLog.isColorLevel()) {
          QLog.w("SPLASH_ConfigServlet", 2, "receiveAllConfigs|noReceiveType: " + localObject1 + ",length: " + paramList.size());
        }
        Object localObject2;
        int i;
        label381:
        String str;
        switch (((Integer)localObject1).intValue())
        {
        case 156: 
        default: 
          break;
        case 1: 
          localObject1 = paramAppRuntime.getApplication().getFilesDir().getAbsolutePath() + "/splashpic/";
          localObject2 = new File((String)localObject1);
          if ((localObject2 != null) && (((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
          {
            localObject2 = ((File)localObject2).listFiles();
            if (localObject2 != null)
            {
              int j = localObject2.length;
              i = 0;
              if (i < j)
              {
                str = localObject2[i];
                if (str != null) {}
              }
            }
          }
          break;
        case 116: 
        case 46: 
        case 38: 
          for (;;)
          {
            for (;;)
            {
              i += 1;
              break label381;
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE no config, use local config.");
              }
              localObject2 = (ConfigHandler)paramAppRuntime.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
              str = UpgradeConfigManager.a("config_upgrade_", jdField_a_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE configContent=" + str);
              }
              if (TextUtils.isEmpty(str))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE local config is empty, reset local version to 0.");
                }
                SharedPreUtils.p(paramAppRuntime.getApp(), jdField_a_of_type_JavaLangString, 0);
                UpgradeConfigManager.a("config_upgrade_", jdField_a_of_type_JavaLangString);
                ((ConfigHandler)localObject2).a(UpgradeController.a().a());
                break;
              }
              localObject1 = UpgradeController.a().a();
              ((UpgradeDetailWrapper)localObject1).a(str);
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, String.format("receiveAllConfigs|GET_CONFIG_UPGRADE localAppID=%s configAppID=%s", new Object[] { Integer.valueOf(AppSetting.a()), Integer.valueOf(((UpgradeDetailWrapper)localObject1).jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId) }));
              }
              if (AppSetting.a() >= ((UpgradeDetailWrapper)localObject1).jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE already upgraded, delete local config.");
                }
                SharedPreUtils.p(paramAppRuntime.getApp(), jdField_a_of_type_JavaLangString, 0);
                UpgradeConfigManager.a("config_upgrade_", jdField_a_of_type_JavaLangString);
                ((UpgradeDetailWrapper)localObject1).jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType = 0;
                ((ConfigHandler)localObject2).a((UpgradeDetailWrapper)localObject1);
                ((ConfigHandler)localObject2).d();
                break;
              }
              try
              {
                if (!((UpgradeDetailWrapper)localObject1).jdField_a_of_type_Boolean)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE waiting switch bit.");
                  }
                  break;
                }
              }
              finally {}
            }
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE do upgrade.");
            }
            if (((UpgradeDetailWrapper)localObject1).jdField_b_of_type_Int == 0) {
              if (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_Int != 1) {
                break label767;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              ConfigHandler.a(paramAppRuntime, bool);
              UpgradeController.a().a(((UpgradeDetailWrapper)localObject1).jdField_b_of_type_ProtocolKQQConfigUpgradeInfo, (UpgradeController.OnHandleUpgradeFinishListener)localObject2);
              break;
            }
            PatchFileManager.a(paramAppRuntime);
            break;
            localObject1 = SharedPreUtils.b(paramAppRuntime.getCurrentAccountUin());
            ((SharedPreferences)localObject1).edit().remove("qav_upgrade_invite_video").commit();
            ((SharedPreferences)localObject1).edit().remove("qav_upgrade_invite_multi").commit();
            break;
            ThreadManager.post(new ConfigServlet.1(this, str, (String)localObject1, paramAppRuntime), 5, null, true);
          }
        case 87: 
          localObject1 = (ArResourceManager)paramAppRuntime.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
          if (localObject1 != null) {
            ((ArResourceManager)localObject1).a(true, false);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource:no receive respConfig");
          }
          break;
        case 188: 
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_AR_GLOBAL_CONTROL_COFIG", 2, "handleResp_AR_GLOBAL_CONTROL_COFIG:no receive respConfig");
          }
          break;
        case 206: 
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "config is newest .handleResp_AR_SCAN_STAR_FACE_CONFIG  no receive respConfig");
          }
          break;
        case 205: 
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "config is newest .handleResp_GetArScanFacePreDownConfig  no receive respConfig");
          }
          break;
        case 86: 
          localObject1 = (OlympicManager)paramAppRuntime.getManager(QQManagerFactory.OLYMPIC_MANAGER);
          if (localObject1 != null)
          {
            ((OlympicManager)localObject1).f();
            ((OlympicManager)localObject1).g();
          }
          if (QLog.isColorLevel()) {
            QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig: no receive respConfig");
          }
          break;
        case 42: 
          at(paramAppRuntime, null);
          break;
        case 113: 
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "precover PRECOVER_CONFIG_CMD, failed");
          }
          localObject1 = (PrecoverManager)paramAppRuntime.getManager(QQManagerFactory.PRECOVER_MANAGER);
          if (localObject1 != null)
          {
            ((PrecoverManager)localObject1).a();
            ((PrecoverManager)localObject1).a(true);
          }
          break;
        case 223: 
        case 364: 
        case 365: 
          BusinessCommonConfig.getInstance(paramAppRuntime).handleResp_Config_NoResp(paramAppRuntime, ((Integer)localObject1).intValue());
          break;
        case 119: 
          localObject1 = (BabyQHandler)paramAppRuntime.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
          if (localObject1 != null) {
            ((BabyQHandler)localObject1).a(false, false);
          }
          break;
        case 185: 
          ScribbleResMgr.a().a();
          break;
        case 202: 
          if (QLog.isColorLevel()) {
            QLog.i("CU_OPEN_CARD_GUIDE", 2, "no need to update, use local config");
          }
          break;
        case 191: 
          ((AppGuideTipsManager)paramAppRuntime.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).a();
          break;
        case 215: 
          AEOldShortVideoResManager.b();
          break;
        case 718: 
          ShortVideoResourceManager.b();
          break;
        case 297: 
          NativeMonitorConfigHelper.a(true);
          break;
        case 345: 
          label767:
          FreeWifiHelper.a(paramAppRuntime, true);
        }
      }
    }
  }
  
  public void a(int[] paramArrayOfInt, FromServiceMsg paramFromServiceMsg)
  {
    KandianConfigServlet.a("0", paramArrayOfInt, paramFromServiceMsg.getResultCode());
    SoLoadConfProcessor.a(paramArrayOfInt, paramFromServiceMsg);
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      if (k == 215)
      {
        AEOldShortVideoResManager.a(-5);
        AEQLog.d("SPLASH_ConfigServlet", "【SHORT_VIDEO_RESOURCE_CONFIG】RES_OVERTIME");
      }
      for (;;)
      {
        i += 1;
        break;
        if (k == 718)
        {
          ShortVideoResourceManager.a(-5);
          AEQLog.d("SPLASH_ConfigServlet", "【SHORT_VIDEO_RESOURCE_CONFIG】RES_OVERTIME");
        }
      }
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime, int[] paramArrayOfInt)
  {
    return (paramArrayOfInt != null) && (paramArrayOfInt.length == 1) && (paramArrayOfInt[0] == 215) && (!paramAppRuntime.isLogin());
  }
  
  void b(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig |  type= " + paramConfig.type.get());
    }
    if (paramConfig.type.get() != 205) {}
    do
    {
      do
      {
        do
        {
          return;
          int i = paramConfig.version.get();
          if (paramIntent.getIntExtra("key_download_cfg_version", 0) != i) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, version same");
        return;
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig we delete ARConfig info here");
      return;
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, content is null");
    return;
    byte[] arrayOfByte;
    if (paramIntent.compress.get() == 1)
    {
      arrayOfByte = OlympicUtil.a(paramIntent.content.get().toByteArray());
      if (arrayOfByte == null) {
        break label351;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new String(arrayOfByte, "UTF-8");
        if (paramIntent == null) {
          break label329;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, config_content is " + paramIntent);
        }
        FaceScanDownloadManager.a(paramQQAppInterface, paramIntent, paramConfig.version.get());
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, config type 205");
        return;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        paramIntent = null;
        continue;
      }
      catch (OutOfMemoryError paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        System.gc();
        try
        {
          paramIntent = new String(arrayOfByte, "UTF-8");
        }
        catch (Throwable paramIntent)
        {
          paramIntent = null;
        }
        continue;
      }
      paramIntent = paramIntent.content.get().toStringUtf8();
      continue;
      label329:
      FaceScanDownloadManager.b(paramQQAppInterface);
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig we delete ARConfig info here");
        continue;
        label351:
        paramIntent = null;
      }
    }
  }
  
  protected void b(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig != null) {}
    for (;;)
    {
      try
      {
        if (paramConfig.type.get() != 143) {
          break label366;
        }
        if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
          break label431;
        }
        Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (localObject1 == null) {
          break label349;
        }
        if (((ConfigurationService.Content)localObject1).compress.get() == 1)
        {
          byte[] arrayOfByte = OlympicUtil.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
          if (arrayOfByte == null) {
            break label425;
          }
          try
          {
            localObject1 = new String(arrayOfByte, "UTF-8");
            if (localObject1 == null) {
              break label431;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "receiveAllConfigs|type: 143,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
            }
            int i = paramConfig.version.get();
            if ((i == SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              continue;
            }
            NearbyFlowerUtil.a((String)localObject1);
            NearbyFlowerUtil.b((String)localObject1);
            SharedPreUtils.h(paramQQAppInterface.getApp(), (String)localObject1);
            SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString, i);
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            if (!QLog.isColorLevel()) {
              break label432;
            }
            localUnsupportedEncodingException.printStackTrace();
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (QLog.isColorLevel()) {
              localOutOfMemoryError.printStackTrace();
            }
            System.gc();
            try
            {
              String str = new String(arrayOfByte, "UTF-8");
            }
            catch (Throwable localThrowable)
            {
              localObject2 = null;
            }
            continue;
          }
        }
        else
        {
          localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label431;
        }
        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label431;
        }
      }
      QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "received change machine config error,cmd : 143" + paramQQAppInterface.toString());
      return;
      label349:
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "handleNearbyGlamourLevelConfig, content is null");
        return;
        label366:
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("receiveAllConfigs|type: 143,content_list is empty ,version: ");
          if (paramConfig != null) {}
          for (paramQQAppInterface = Integer.valueOf(paramConfig.version.get());; paramQQAppInterface = "")
          {
            QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, paramQQAppInterface);
            return;
          }
          localObject2 = null;
          continue;
        }
      }
      label425:
      label431:
      return;
      label432:
      Object localObject2 = null;
    }
  }
  
  protected void c(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        FunctionModuleConfigManager localFunctionModuleConfigManager = (FunctionModuleConfigManager)paramQQAppInterface.getManager(QQManagerFactory.FUNCTION_MODULE_MANAGER);
        if ((paramConfig != null) && (paramConfig.type.get() == 190)) {
          if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
          {
            i = 0;
            if (i < paramConfig.msg_content_list.size())
            {
              Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
              if (localObject1 == null) {
                break label382;
              }
              if (((ConfigurationService.Content)localObject1).compress.get() == 1)
              {
                byte[] arrayOfByte = OlympicUtil.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
                if (arrayOfByte == null) {
                  break label460;
                }
                try
                {
                  localObject1 = new String(arrayOfByte, "UTF-8");
                  if (localObject1 == null) {
                    break label466;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, "receiveAllConfigs|type: 190,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
                  }
                  int j = paramConfig.version.get();
                  if ((j == SharedPreUtils.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                    continue;
                  }
                  localFunctionModuleConfigManager.b(new JSONObject((String)localObject1).optString("kFTSFunctionListUrlKey"));
                  SharedPreUtils.a(paramQQAppInterface.getApp(), "search_function_config_version", jdField_a_of_type_JavaLangString, j);
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  if (!QLog.isColorLevel()) {
                    break label473;
                  }
                  localUnsupportedEncodingException.printStackTrace();
                  break label473;
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  if (QLog.isColorLevel()) {
                    localOutOfMemoryError.printStackTrace();
                  }
                  System.gc();
                  try
                  {
                    String str = new String(arrayOfByte, "UTF-8");
                  }
                  catch (Throwable localThrowable)
                  {
                    localObject2 = null;
                  }
                  continue;
                }
              }
              else
              {
                localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
                continue;
              }
              if (!QLog.isColorLevel()) {
                break label466;
              }
              QLog.d("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, "received SEARCH_FUNCTION_MODULE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, "received search function module error,cmd : 190" + paramQQAppInterface.toString());
        }
      }
      label382:
      do
      {
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, "handleFunctionModuleConfig, content is null");
        break;
      } while (!QLog.isColorLevel());
      Object localObject2 = new StringBuilder().append("receiveAllConfigs|type: 190,msg_content_list is empty ,version: ");
      if (paramConfig != null) {}
      for (paramQQAppInterface = Integer.valueOf(paramConfig.version.get());; paramQQAppInterface = "")
      {
        QLog.d("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, paramQQAppInterface);
        return;
      }
      label460:
      localObject2 = null;
      continue;
      label466:
      i += 1;
      continue;
      label473:
      localObject2 = null;
    }
  }
  
  public void e(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig|type= " + paramConfig.type.get());
    }
    if (paramConfig != null) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        if (paramConfig.type.get() != 146) {
          break label283;
        }
        if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
          break label345;
        }
        Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (localObject1 != null)
        {
          if (((ConfigurationService.Content)localObject1).compress.get() == 1)
          {
            byte[] arrayOfByte = OlympicUtil.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
            if (arrayOfByte == null) {
              break label340;
            }
            try
            {
              localObject1 = new String(arrayOfByte, "UTF-8");
              if (localObject1 == null) {
                break label345;
              }
              if (QLog.isColorLevel()) {
                QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, config_content is " + (String)localObject1);
              }
              HotReactiveHelper.a(paramQQAppInterface, (String)localObject1, paramConfig.version.get());
              return;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              if (!QLog.isColorLevel()) {
                break label346;
              }
              localUnsupportedEncodingException.printStackTrace();
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              if (QLog.isColorLevel()) {
                localOutOfMemoryError.printStackTrace();
              }
              System.gc();
              try
              {
                String str = new String(arrayOfByte, "UTF-8");
              }
              catch (Throwable localThrowable)
              {
                localObject2 = null;
              }
              continue;
            }
          }
          localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label345;
        }
        QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, content is null");
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label345;
        }
      }
      QLog.e("HotFriend_SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
      return;
      label283:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("content_list is empty ,version: ");
        if (paramConfig != null) {}
        for (paramQQAppInterface = Integer.valueOf(paramConfig.version.get());; paramQQAppInterface = "")
        {
          QLog.d("HotFriend_SPLASH_ConfigServlet", 2, paramQQAppInterface);
          return;
        }
        label340:
        localObject2 = null;
      }
      else
      {
        label345:
        return;
        label346:
        localObject2 = null;
      }
    }
  }
  
  public void f(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            String str = (String)paramConfig.content_list.get(i);
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 72,content: " + str + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j != SharedPreUtils.L(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin())) || (paramConfig.content_list.size() > 0))
            {
              if (ReadInJoyHelper.a(paramQQAppInterface, str))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "received 72 ark config");
                }
                SharedPreUtils.s(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentUin(), j);
                break label297;
              }
              if ((!((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).updateReadinjoyFolderConfig(paramQQAppInterface, str)) || (!QLog.isColorLevel())) {
                continue;
              }
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_CONFIG_CMD save version: " + j);
              continue;
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy folder config error,cmd : 72");
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_CONFIG_CMD IGNORE THIS ACTION  because of SAME VERSION");
        break;
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 72,content_list is empty ,version: " + paramConfig.version.get());
          return;
        }
      }
      label297:
      i += 1;
    }
  }
  
  public void g(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            Object localObject1 = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 73,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j != SharedPreUtils.x(paramQQAppInterface.getApp())) || (paramConfig.content_list.size() > 0))
            {
              Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8")));
              localObject1 = (Element)((Document)localObject2).getElementsByTagName("kandian_setting").item(0);
              localObject2 = (Element)((Document)localObject2).getElementsByTagName("url").item(0);
              localObject1 = ((Element)localObject1).getFirstChild().getNodeValue();
              localObject2 = ((Element)localObject2).getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
                SharedPreUtils.b(paramQQAppInterface.getApp(), (String)localObject2, "1".equals(localObject1));
              }
              SharedPreUtils.o(paramQQAppInterface.getApp(), j);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_SETTING_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy folder setting config error,cmd : 73");
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 73,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  void h(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 147) {}
    for (;;)
    {
      return;
      int i = SharedPreUtils.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString);
      int j = paramConfig.version.get();
      if ((i != j) && (paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
        try
        {
          paramConfig = new JSONObject((String)paramConfig.content_list.get(0));
          boolean bool = paramConfig.getBoolean("android");
          SharedPreUtils.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString, j);
          paramQQAppInterface = (EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
          paramQQAppInterface.b(bool);
          paramQQAppInterface.c = paramConfig.optBoolean("preload_web_process", false);
          paramQQAppInterface.a = paramConfig.optLong("stay_time", 5000L);
          paramQQAppInterface.d = paramConfig.optInt("day_limit", 3);
          EcShopAssistantManager.a().edit().putBoolean("preload_web", paramQQAppInterface.c).putLong("stayTime", paramQQAppInterface.a).putInt("dayLimit", paramQQAppInterface.d).commit();
          if (QLog.isColorLevel())
          {
            QLog.i("Ecshop", 2, "current config set tab show:" + bool + ",preload:" + paramQQAppInterface.c + ",stayTime:" + paramQQAppInterface.a + ",dayLimit:" + paramQQAppInterface.d);
            return;
          }
        }
        catch (Exception paramQQAppInterface) {}
      }
    }
  }
  
  protected void i(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig type = " + paramConfig.type.get());
    }
    int i = SharedPreUtils.Y(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
    int j = paramConfig.version.get();
    if (i == j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig version code not changed .");
      }
      return;
    }
    SharedPreUtils.x(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), j);
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() < 1) || (paramConfig.msg_content_list.get(0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig data is null!!!");
      }
      SharedPreUtils.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), null);
      return;
    }
    paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    byte[] arrayOfByte;
    if (paramConfig.compress.get() == 1)
    {
      arrayOfByte = OlympicUtil.a(paramConfig.content.get().toByteArray());
      if (arrayOfByte == null) {}
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(arrayOfByte, "UTF-8");
        if (TextUtils.isEmpty(paramConfig)) {
          break label367;
        }
        SharedPreUtils.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), paramConfig);
        ((QQStoryManager)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER)).a(paramConfig);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig() configContent = " + paramConfig);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramConfig));
        }
        paramConfig = null;
        continue;
      }
      catch (OutOfMemoryError paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramConfig));
        }
        System.gc();
        try
        {
          paramConfig = new String(arrayOfByte, "UTF-8");
        }
        catch (Throwable paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramConfig));
          }
        }
      }
      paramConfig = null;
      continue;
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label367:
      SharedPreUtils.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), null);
    }
  }
  
  void j(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = SharedPreUtils.ad(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label219;
        }
        paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
        if (paramConfig == null) {
          break label239;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {}
      }
      catch (Exception paramConfig)
      {
        try
        {
          paramConfig = new JSONObject(paramConfig);
          boolean bool1 = paramConfig.getBoolean("wifiAutoPreDown");
          boolean bool2 = paramConfig.getBoolean("noSafeDown");
          SharedPreUtils.m(paramQQAppInterface.getApp(), "wifiAutoPreDown", "" + bool1);
          SharedPreUtils.m(paramQQAppInterface.getApp(), "noSafeDown", "" + bool2);
          SharedPreUtils.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
        paramConfig = paramConfig;
        QLog.d("SPLASH_ConfigServlet", 2, "handleQQPreDownYYBConfig|uncompress failed");
        paramConfig = null;
        continue;
      }
      label219:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label239:
      paramConfig = null;
    }
  }
  
  void k(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = SharedPreUtils.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label206;
        }
        paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
        if (paramConfig == null) {
          break label226;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {}
      }
      catch (Exception paramConfig)
      {
        try
        {
          Object localObject = new JSONObject(paramConfig);
          paramConfig = ((JSONObject)localObject).getString("url");
          String str = ((JSONObject)localObject).getString("wantWord");
          localObject = ((JSONObject)localObject).getString("thxWord");
          SharedPreUtils.k(paramQQAppInterface.getApp(), "url", paramConfig);
          SharedPreUtils.k(paramQQAppInterface.getApp(), "thxWord", (String)localObject);
          SharedPreUtils.k(paramQQAppInterface.getApp(), "wantWord", str);
          SharedPreUtils.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
        paramConfig = paramConfig;
        QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoConfig|uncompress failed");
        paramConfig = null;
        continue;
      }
      label206:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label226:
      paramConfig = null;
    }
  }
  
  void l(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 165) {}
    int j;
    do
    {
      int i;
      do
      {
        return;
        i = SharedPreUtils.ae(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        j = paramConfig.version.get();
      } while ((i == j) || (paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label194;
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {
          break;
        }
        try
        {
          boolean bool = new JSONObject(paramConfig).getBoolean("isShowBuluoNumRedDot");
          SharedPreUtils.D(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          SharedPreUtils.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, bool);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
      }
      catch (Exception paramConfig)
      {
        QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoConfig|uncompress failed");
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label194:
      paramConfig = null;
    }
  }
  
  void m(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG response");
    }
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
        {
          int j = paramConfig.version.get();
          int k = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountQQMailConfigVersionCode(paramQQAppInterface);
          if (j != k)
          {
            i = 0;
            if (i < paramConfig.msg_content_list.size())
            {
              Object localObject = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
              if (localObject != null)
              {
                if (((ConfigurationService.Content)localObject).compress.get() == 1)
                {
                  localObject = OlympicUtil.a(((ConfigurationService.Content)localObject).content.get().toByteArray());
                  if (localObject == null) {
                    break label332;
                  }
                  try
                  {
                    localObject = new String((byte[])localObject, "UTF-8");
                    if (QLog.isColorLevel()) {
                      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 184, version:" + paramConfig.version.get() + ", content:" + (String)localObject);
                    }
                    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).updatePublicAccountQQMailConfigData(paramQQAppInterface, (String)localObject, j);
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                    break label332;
                  }
                }
                else
                {
                  str = localException.content.get().toStringUtf8();
                  continue;
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG remote version: " + j + " | localVersion: " + k);
              }
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG content_list is empty");
      return;
      i += 1;
      continue;
      label332:
      String str = null;
    }
  }
  
  /* Error */
  void n(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 2580	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 191
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 1720	com/tencent/mobileqq/utils/SharedPreUtils:ar	(Landroid/content/Context;Ljava/lang/String;)I
    //   24: istore_3
    //   25: aload_2
    //   26: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   29: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   32: istore 4
    //   34: iload 4
    //   36: iload_3
    //   37: if_icmpeq -24 -> 13
    //   40: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +30 -> 73
    //   46: ldc 77
    //   48: iconst_2
    //   49: new 79	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 5806
    //   59: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: iload 4
    //   64: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_2
    //   74: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   77: ifnull -64 -> 13
    //   80: aload_2
    //   81: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 386	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   87: ifle -74 -> 13
    //   90: aload_2
    //   91: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   94: iconst_0
    //   95: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 391	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull -90 -> 13
    //   106: aload_2
    //   107: getfield 395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: iconst_1
    //   114: if_icmpne +349 -> 463
    //   117: aload_2
    //   118: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   124: invokevirtual 413	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   127: invokestatic 418	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +442 -> 574
    //   135: new 126	java/lang/String
    //   138: dup
    //   139: aload_2
    //   140: ldc_w 420
    //   143: invokespecial 423	java/lang/String:<init>	([BLjava/lang/String;)V
    //   146: astore_2
    //   147: aload_2
    //   148: ifnull -135 -> 13
    //   151: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +29 -> 183
    //   157: ldc 77
    //   159: iconst_2
    //   160: new 79	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 5808
    //   170: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_2
    //   174: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: new 128	org/json/JSONObject
    //   186: dup
    //   187: aload_2
    //   188: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   191: astore 5
    //   193: aload 5
    //   195: ifnull -182 -> 13
    //   198: aload 5
    //   200: invokevirtual 5809	org/json/JSONObject:length	()I
    //   203: ifle -190 -> 13
    //   206: new 862	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 863	java/util/ArrayList:<init>	()V
    //   213: astore_2
    //   214: aload 5
    //   216: invokevirtual 5812	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   219: astore 6
    //   221: aload 6
    //   223: invokeinterface 120 1 0
    //   228: ifeq +310 -> 538
    //   231: aload 6
    //   233: invokeinterface 124 1 0
    //   238: checkcast 126	java/lang/String
    //   241: astore 7
    //   243: aload 5
    //   245: aload 7
    //   247: invokevirtual 3034	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   250: astore 8
    //   252: new 4520	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   255: dup
    //   256: invokespecial 4521	com/tencent/mobileqq/data/AppGuideTipsConfig:<init>	()V
    //   259: astore 9
    //   261: aload 9
    //   263: aload 7
    //   265: putfield 5815	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsType	Ljava/lang/String;
    //   268: aload 9
    //   270: aload 8
    //   272: ldc_w 4529
    //   275: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: putfield 4532	com/tencent/mobileqq/data/AppGuideTipsConfig:switchKey	Ljava/lang/String;
    //   281: aload 9
    //   283: aload 8
    //   285: ldc_w 4534
    //   288: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokestatic 2279	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   294: invokevirtual 1588	java/lang/Integer:intValue	()I
    //   297: putfield 4537	com/tencent/mobileqq/data/AppGuideTipsConfig:maxCount	I
    //   300: aload 9
    //   302: aload 8
    //   304: ldc_w 4539
    //   307: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   310: invokestatic 2477	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   313: invokevirtual 2480	java/lang/Long:longValue	()J
    //   316: putfield 4541	com/tencent/mobileqq/data/AppGuideTipsConfig:duration	J
    //   319: aload 9
    //   321: aload 8
    //   323: ldc_w 781
    //   326: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: putfield 4544	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsUrl	Ljava/lang/String;
    //   332: aload 9
    //   334: aload 8
    //   336: ldc_w 5817
    //   339: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   342: putfield 5819	com/tencent/mobileqq/data/AppGuideTipsConfig:opkey	Ljava/lang/String;
    //   345: aload 9
    //   347: aload 8
    //   349: ldc_w 4549
    //   352: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   355: putfield 4552	com/tencent/mobileqq/data/AppGuideTipsConfig:msgTypeStr	Ljava/lang/String;
    //   358: ldc_w 485
    //   361: aload 7
    //   363: invokevirtual 483	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifeq +143 -> 509
    //   369: aload 8
    //   371: ldc_w 756
    //   374: invokevirtual 137	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   377: ifeq +100 -> 477
    //   380: aload 9
    //   382: aload 8
    //   384: ldc_w 756
    //   387: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   390: putfield 4547	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   393: aload 8
    //   395: ldc_w 3036
    //   398: invokevirtual 137	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   401: ifeq +92 -> 493
    //   404: aload 9
    //   406: aload 8
    //   408: ldc_w 3036
    //   411: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   414: putfield 5822	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   417: aload_2
    //   418: aload 9
    //   420: invokeinterface 874 2 0
    //   425: pop
    //   426: goto -205 -> 221
    //   429: astore_1
    //   430: ldc 77
    //   432: iconst_1
    //   433: new 79	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   440: ldc_w 5824
    //   443: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_1
    //   447: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: return
    //   457: astore_2
    //   458: aconst_null
    //   459: astore_2
    //   460: goto -313 -> 147
    //   463: aload_2
    //   464: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   467: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   470: invokevirtual 449	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   473: astore_2
    //   474: goto -327 -> 147
    //   477: aload 9
    //   479: aload 8
    //   481: ldc_w 5826
    //   484: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   487: putfield 4547	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   490: goto -97 -> 393
    //   493: aload 9
    //   495: aload 8
    //   497: ldc_w 5828
    //   500: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   503: putfield 5822	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   506: goto -89 -> 417
    //   509: aload 9
    //   511: aload 8
    //   513: ldc_w 5826
    //   516: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   519: putfield 4547	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   522: aload 9
    //   524: aload 8
    //   526: ldc_w 5828
    //   529: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   532: putfield 5822	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   535: goto -118 -> 417
    //   538: aload_1
    //   539: getstatic 4514	com/tencent/mobileqq/app/QQManagerFactory:APP_GUIDE_TIPS_MANAGER	I
    //   542: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   545: checkcast 4516	com/tencent/mobileqq/activity/aio/AppGuideTipsManager
    //   548: astore 5
    //   550: aload 5
    //   552: aload_2
    //   553: invokevirtual 5829	com/tencent/mobileqq/activity/aio/AppGuideTipsManager:a	(Ljava/util/List;)V
    //   556: aload 5
    //   558: invokevirtual 5581	com/tencent/mobileqq/activity/aio/AppGuideTipsManager:a	()V
    //   561: aload_1
    //   562: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   565: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   568: iload 4
    //   570: invokestatic 5831	com/tencent/mobileqq/utils/SharedPreUtils:O	(Landroid/content/Context;Ljava/lang/String;I)V
    //   573: return
    //   574: aconst_null
    //   575: astore_2
    //   576: goto -429 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	ConfigServlet
    //   0	579	1	paramQQAppInterface	QQAppInterface
    //   0	579	2	paramConfig	ConfigurationService.Config
    //   24	14	3	i	int
    //   32	537	4	j	int
    //   191	366	5	localObject	Object
    //   219	13	6	localIterator	Iterator
    //   241	121	7	str	String
    //   250	275	8	localJSONObject	JSONObject
    //   259	264	9	localAppGuideTipsConfig	AppGuideTipsConfig
    // Exception table:
    //   from	to	target	type
    //   183	193	429	java/lang/Exception
    //   198	221	429	java/lang/Exception
    //   221	393	429	java/lang/Exception
    //   393	417	429	java/lang/Exception
    //   417	426	429	java/lang/Exception
    //   477	490	429	java/lang/Exception
    //   493	506	429	java/lang/Exception
    //   509	535	429	java/lang/Exception
    //   538	573	429	java/lang/Exception
    //   135	147	457	java/lang/Exception
  }
  
  void o(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 194) {
      return;
    }
    int i = SharedPreUtils.ac(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("PobingSPLASH_ConfigServlet", 2, "handleTroopPobingConfig reqVersion=" + i + "version=" + j);
    }
    if (i != j)
    {
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label399;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label355;
        }
        paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
        if (paramConfig == null) {
          break label428;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Pobing", 1, "handleTroopPobingConfig content" + paramConfig);
          }
          if (paramConfig == null) {}
        }
        try
        {
          Object localObject = new JSONObject(paramConfig);
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("left");
          localObject = ((JSONObject)localObject).getJSONArray("right");
          if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig content" + paramConfig + " left: " + localJSONArray);
            QLog.d("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig content" + paramConfig + " right: " + localObject);
          }
          TroopManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString, localJSONArray, (JSONArray)localObject);
        }
        catch (Exception paramConfig)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig failed" + paramConfig);
          continue;
        }
        SharedPreUtils.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PobingSPLASH_ConfigServlet", 2, "handleTroopPobingConfig|uncompress failed");
        }
        paramConfig = null;
        continue;
      }
      label355:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label399:
      paramConfig = new JSONArray();
      TroopManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString, paramConfig, paramConfig);
      QLog.i("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig, empty config clear local");
      continue;
      label428:
      paramConfig = null;
    }
  }
  
  void p(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 181) {}
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return;
          i = SharedPreUtils.aj(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("DoutuSPLASH_ConfigServlet", 2, "handleDoutuConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        SharedPreUtils.J(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label1412;
      }
    }
    for (;;)
    {
      label318:
      label455:
      int k;
      label518:
      label577:
      String str1;
      label637:
      int m;
      try
      {
        for (;;)
        {
          paramConfig = new String(paramConfig, "UTF-8");
          if (paramConfig == null) {
            break label1251;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Doutu", 1, "handleDoutuConfig content" + paramConfig);
          }
          try
          {
            Object localObject = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramConfig.getBytes("utf-8")));
            paramConfig = ((Document)localObject).getElementsByTagName("doutu_config");
            if ((paramConfig == null) || (paramConfig.getLength() <= 0)) {
              break;
            }
            if ((((Document)localObject).getElementsByTagName("entry") == null) || (((Document)localObject).getElementsByTagName("entry").item(0) == null)) {
              break label1407;
            }
            i = Integer.parseInt(((Document)localObject).getElementsByTagName("entry").item(0).getFirstChild().getNodeValue());
            l2 = 0L;
            l1 = l2;
            if (((Document)localObject).getElementsByTagName("timeGap") != null)
            {
              l1 = l2;
              if (((Document)localObject).getElementsByTagName("timeGap").item(0) != null) {
                l1 = Long.parseLong(((Document)localObject).getElementsByTagName("timeGap").item(0).getFirstChild().getNodeValue());
              }
            }
            if ((((Document)localObject).getElementsByTagName("duiTimes") == null) || (((Document)localObject).getElementsByTagName("duiTimes").item(0) == null)) {
              break label1401;
            }
            j = Integer.parseInt(((Document)localObject).getElementsByTagName("duiTimes").item(0).getFirstChild().getNodeValue());
            if ((((Document)localObject).getElementsByTagName("entryCombo") == null) || (((Document)localObject).getElementsByTagName("entryCombo").item(0) == null)) {
              break label1395;
            }
            k = Integer.parseInt(((Document)localObject).getElementsByTagName("entryCombo").item(0).getFirstChild().getNodeValue());
            if ((((Document)localObject).getElementsByTagName("resUrl") == null) || (((Document)localObject).getElementsByTagName("resUrl").item(0) == null)) {
              break label1390;
            }
            paramConfig = ((Document)localObject).getElementsByTagName("resUrl").item(0).getFirstChild().getNodeValue();
            if ((((Document)localObject).getElementsByTagName("resMd5") == null) || (((Document)localObject).getElementsByTagName("resMd5").item(0) == null)) {
              break label1384;
            }
            str1 = ((Document)localObject).getElementsByTagName("resMd5").item(0).getFirstChild().getNodeValue();
            l3 = 0L;
            l2 = l3;
            if (((Document)localObject).getElementsByTagName("comboDuration") != null)
            {
              l2 = l3;
              if (((Document)localObject).getElementsByTagName("comboDuration").item(0) != null) {
                l2 = Long.parseLong(((Document)localObject).getElementsByTagName("comboDuration").item(0).getFirstChild().getNodeValue());
              }
            }
            long l4 = 0L;
            l3 = l4;
            if (((Document)localObject).getElementsByTagName("comboKeep") != null)
            {
              l3 = l4;
              if (((Document)localObject).getElementsByTagName("comboKeep").item(0) != null) {
                l3 = Long.parseLong(((Document)localObject).getElementsByTagName("comboKeep").item(0).getFirstChild().getNodeValue());
              }
            }
            if ((((Document)localObject).getElementsByTagName("recommendSwitch") == null) || (((Document)localObject).getElementsByTagName("recommendSwitch").item(0) == null)) {
              break label1378;
            }
            m = Integer.parseInt(((Document)localObject).getElementsByTagName("recommendSwitch").item(0).getFirstChild().getNodeValue());
            label848:
            int i1 = 0;
            n = i1;
            if (((Document)localObject).getElementsByTagName("smartHeadPicCount") != null)
            {
              n = i1;
              if (((Document)localObject).getElementsByTagName("smartHeadPicCount").item(0) != null) {
                n = Integer.parseInt(((Document)localObject).getElementsByTagName("smartHeadPicCount").item(0).getFirstChild().getNodeValue());
              }
            }
            localObject = paramQQAppInterface.getApp();
            String str2 = jdField_a_of_type_JavaLangString;
            if (i != 1) {
              break label1215;
            }
            bool1 = true;
            SharedPreUtils.g((Context)localObject, str2, bool1);
            SharedPreUtils.b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l1);
            SharedPreUtils.N(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
            localObject = paramQQAppInterface.getApp();
            str2 = jdField_a_of_type_JavaLangString;
            if (k != 1) {
              break label1221;
            }
            bool1 = true;
            SharedPreUtils.i((Context)localObject, str2, bool1);
            localObject = paramQQAppInterface.getApp();
            str2 = jdField_a_of_type_JavaLangString;
            if (m != 1) {
              break label1227;
            }
            bool1 = true;
            SharedPreUtils.j((Context)localObject, str2, bool1);
            if (paramConfig != null) {
              SharedPreUtils.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
            }
            if (str1 != null) {
              SharedPreUtils.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, str1);
            }
            SharedPreUtils.c(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l2);
            SharedPreUtils.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l3);
            SharedPreUtils.L(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, n);
            paramQQAppInterface = (DoutuManager)paramQQAppInterface.getManager(QQManagerFactory.DOUTU_MAGAGER);
            if (paramQQAppInterface == null) {
              break;
            }
            if (i != 1) {
              break label1233;
            }
            bool1 = true;
          }
          catch (Exception paramQQAppInterface)
          {
            long l2;
            long l1;
            long l3;
            int n;
            label1126:
            QLog.e("HotPicManager", 1, "handleDoutuConfig failed" + paramQQAppInterface);
            return;
          }
        }
        paramQQAppInterface.a(bool1, bool2, l1, l2, l3, bool3, n);
        paramQQAppInterface.b(true);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuSPLASH_ConfigServlet", 2, "handleDoutuConfig|uncompress failed");
        }
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label1215:
      boolean bool1 = false;
      continue;
      label1221:
      bool1 = false;
      continue;
      label1227:
      bool1 = false;
      continue;
      label1233:
      bool1 = false;
      label1239:
      for (boolean bool2 = false; m != 1; bool2 = true)
      {
        bool3 = false;
        break label1126;
        label1251:
        if (QLog.isColorLevel()) {
          QLog.d("Doutu", 1, "handleDoutuConfig content is null");
        }
        SharedPreUtils.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        SharedPreUtils.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        SharedPreUtils.l(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        SharedPreUtils.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        SharedPreUtils.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        SharedPreUtils.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        SharedPreUtils.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        SharedPreUtils.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        SharedPreUtils.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        SharedPreUtils.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        SharedPreUtils.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        return;
        label1378:
        m = 0;
        break label848;
        label1384:
        str1 = null;
        break label637;
        label1390:
        paramConfig = null;
        break label577;
        label1395:
        k = 0;
        break label518;
        label1401:
        j = 0;
        break label455;
        label1407:
        i = 0;
        break label318;
        paramConfig = null;
        break;
        if (k != 1) {
          break label1239;
        }
      }
      label1412:
      boolean bool3 = true;
    }
  }
  
  void q(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 247) {}
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          return;
          i = SharedPreUtils.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        SharedPreUtils.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label276;
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {
          break label252;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GreenVideo", 1, "handleGreenVideoConfig content : " + paramConfig);
        }
        SharedPreUtils.e(paramQQAppInterface.getApp(), paramConfig);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig|uncompress failed");
        }
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label252:
      if (QLog.isColorLevel()) {
        QLog.d("GreenVideo", 1, "handleGreenVideoConfig content is null");
      }
      SharedPreUtils.a(paramQQAppInterface.getApp());
      return;
      label276:
      paramConfig = null;
    }
  }
  
  /* Error */
  void r(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 2580	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 272
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 1685	com/tencent/mobileqq/utils/SharedPreUtils:v	(Landroid/content/Context;Ljava/lang/String;)I
    //   24: istore_3
    //   25: aload_2
    //   26: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   29: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   32: istore 4
    //   34: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +40 -> 77
    //   40: ldc 77
    //   42: iconst_2
    //   43: new 79	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 5961
    //   53: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_3
    //   57: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc_w 5865
    //   63: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload 4
    //   68: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: iload_3
    //   78: iload 4
    //   80: if_icmpeq -67 -> 13
    //   83: aload_1
    //   84: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   87: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: iload 4
    //   92: invokestatic 1674	com/tencent/mobileqq/utils/SharedPreUtils:h	(Landroid/content/Context;Ljava/lang/String;I)V
    //   95: aload_2
    //   96: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   99: ifnull -86 -> 13
    //   102: aload_2
    //   103: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   106: invokevirtual 386	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   109: ifle -96 -> 13
    //   112: aload_2
    //   113: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   116: iconst_0
    //   117: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   120: checkcast 391	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   123: astore_2
    //   124: aload_2
    //   125: ifnull -112 -> 13
    //   128: aload_2
    //   129: getfield 395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   132: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   135: iconst_1
    //   136: if_icmpne +716 -> 852
    //   139: aload_2
    //   140: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   143: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   146: invokevirtual 413	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   149: invokestatic 418	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   152: astore_2
    //   153: aload_2
    //   154: ifnull +782 -> 936
    //   157: new 126	java/lang/String
    //   160: dup
    //   161: aload_2
    //   162: ldc_w 420
    //   165: invokespecial 423	java/lang/String:<init>	([BLjava/lang/String;)V
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +696 -> 866
    //   173: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +29 -> 205
    //   179: ldc 77
    //   181: iconst_2
    //   182: new 79	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 5963
    //   192: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: invokestatic 636	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   208: invokevirtual 640	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   211: new 642	java/io/ByteArrayInputStream
    //   214: dup
    //   215: aload_2
    //   216: ldc_w 644
    //   219: invokevirtual 648	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   222: invokespecial 651	java/io/ByteArrayInputStream:<init>	([B)V
    //   225: invokevirtual 656	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   228: astore_2
    //   229: aload_2
    //   230: ldc_w 5965
    //   233: invokeinterface 664 2 0
    //   238: astore 5
    //   240: aload 5
    //   242: ifnull -229 -> 13
    //   245: aload 5
    //   247: invokeinterface 669 1 0
    //   252: ifle -239 -> 13
    //   255: new 79	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   262: astore 5
    //   264: aload_2
    //   265: ldc_w 5967
    //   268: invokeinterface 664 2 0
    //   273: ifnull +42 -> 315
    //   276: aload 5
    //   278: aload_2
    //   279: ldc_w 5967
    //   282: invokeinterface 664 2 0
    //   287: iconst_0
    //   288: invokeinterface 675 2 0
    //   293: invokeinterface 681 1 0
    //   298: invokeinterface 684 1 0
    //   303: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 5
    //   309: bipush 124
    //   311: invokevirtual 790	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_2
    //   316: ldc_w 5969
    //   319: invokeinterface 664 2 0
    //   324: ifnull +42 -> 366
    //   327: aload 5
    //   329: aload_2
    //   330: ldc_w 5969
    //   333: invokeinterface 664 2 0
    //   338: iconst_0
    //   339: invokeinterface 675 2 0
    //   344: invokeinterface 681 1 0
    //   349: invokeinterface 684 1 0
    //   354: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 5
    //   360: bipush 124
    //   362: invokevirtual 790	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_2
    //   367: ldc_w 5971
    //   370: invokeinterface 664 2 0
    //   375: ifnull +42 -> 417
    //   378: aload 5
    //   380: aload_2
    //   381: ldc_w 5971
    //   384: invokeinterface 664 2 0
    //   389: iconst_0
    //   390: invokeinterface 675 2 0
    //   395: invokeinterface 681 1 0
    //   400: invokeinterface 684 1 0
    //   405: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 5
    //   411: bipush 124
    //   413: invokevirtual 790	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_2
    //   418: ldc_w 5973
    //   421: invokeinterface 664 2 0
    //   426: ifnull +42 -> 468
    //   429: aload 5
    //   431: aload_2
    //   432: ldc_w 5973
    //   435: invokeinterface 664 2 0
    //   440: iconst_0
    //   441: invokeinterface 675 2 0
    //   446: invokeinterface 681 1 0
    //   451: invokeinterface 684 1 0
    //   456: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 5
    //   462: bipush 124
    //   464: invokevirtual 790	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload_2
    //   469: ldc_w 5975
    //   472: invokeinterface 664 2 0
    //   477: ifnull +42 -> 519
    //   480: aload 5
    //   482: aload_2
    //   483: ldc_w 5975
    //   486: invokeinterface 664 2 0
    //   491: iconst_0
    //   492: invokeinterface 675 2 0
    //   497: invokeinterface 681 1 0
    //   502: invokeinterface 684 1 0
    //   507: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 5
    //   513: bipush 124
    //   515: invokevirtual 790	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_2
    //   520: ldc_w 5977
    //   523: invokeinterface 664 2 0
    //   528: ifnull +60 -> 588
    //   531: aload_2
    //   532: ldc_w 5977
    //   535: invokeinterface 664 2 0
    //   540: iconst_0
    //   541: invokeinterface 675 2 0
    //   546: ifnull +42 -> 588
    //   549: aload 5
    //   551: aload_2
    //   552: ldc_w 5977
    //   555: invokeinterface 664 2 0
    //   560: iconst_0
    //   561: invokeinterface 675 2 0
    //   566: invokeinterface 681 1 0
    //   571: invokeinterface 684 1 0
    //   576: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 5
    //   582: bipush 124
    //   584: invokevirtual 790	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload_2
    //   589: ldc_w 5979
    //   592: invokeinterface 664 2 0
    //   597: ifnull +60 -> 657
    //   600: aload_2
    //   601: ldc_w 5979
    //   604: invokeinterface 664 2 0
    //   609: iconst_0
    //   610: invokeinterface 675 2 0
    //   615: ifnull +42 -> 657
    //   618: aload 5
    //   620: aload_2
    //   621: ldc_w 5979
    //   624: invokeinterface 664 2 0
    //   629: iconst_0
    //   630: invokeinterface 675 2 0
    //   635: invokeinterface 681 1 0
    //   640: invokeinterface 684 1 0
    //   645: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload 5
    //   651: bipush 124
    //   653: invokevirtual 790	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload_2
    //   658: ldc_w 5981
    //   661: invokeinterface 664 2 0
    //   666: ifnull +60 -> 726
    //   669: aload_2
    //   670: ldc_w 5981
    //   673: invokeinterface 664 2 0
    //   678: iconst_0
    //   679: invokeinterface 675 2 0
    //   684: ifnull +42 -> 726
    //   687: aload 5
    //   689: aload_2
    //   690: ldc_w 5981
    //   693: invokeinterface 664 2 0
    //   698: iconst_0
    //   699: invokeinterface 675 2 0
    //   704: invokeinterface 681 1 0
    //   709: invokeinterface 684 1 0
    //   714: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 5
    //   720: bipush 124
    //   722: invokevirtual 790	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_2
    //   727: ldc_w 5983
    //   730: invokeinterface 664 2 0
    //   735: ifnull +52 -> 787
    //   738: aload_2
    //   739: ldc_w 5983
    //   742: invokeinterface 664 2 0
    //   747: iconst_0
    //   748: invokeinterface 675 2 0
    //   753: ifnull +34 -> 787
    //   756: aload 5
    //   758: aload_2
    //   759: ldc_w 5983
    //   762: invokeinterface 664 2 0
    //   767: iconst_0
    //   768: invokeinterface 675 2 0
    //   773: invokeinterface 681 1 0
    //   778: invokeinterface 684 1 0
    //   783: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload_1
    //   788: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   791: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   794: aload 5
    //   796: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 5985	com/tencent/mobileqq/utils/SharedPreUtils:q	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   802: return
    //   803: astore_1
    //   804: ldc 77
    //   806: iconst_1
    //   807: new 79	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 5987
    //   817: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload_1
    //   821: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   824: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: return
    //   831: astore_2
    //   832: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   835: ifeq +12 -> 847
    //   838: ldc 77
    //   840: iconst_2
    //   841: ldc_w 5989
    //   844: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: aconst_null
    //   848: astore_2
    //   849: goto -680 -> 169
    //   852: aload_2
    //   853: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   856: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   859: invokevirtual 449	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   862: astore_2
    //   863: goto -694 -> 169
    //   866: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   869: ifeq +12 -> 881
    //   872: ldc 77
    //   874: iconst_2
    //   875: ldc_w 5991
    //   878: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: aload_1
    //   882: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   885: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   888: invokestatic 5993	com/tencent/mobileqq/utils/SharedPreUtils:q	(Landroid/content/Context;Ljava/lang/String;)V
    //   891: return
    //   892: astore_2
    //   893: goto -106 -> 787
    //   896: astore 6
    //   898: goto -172 -> 726
    //   901: astore 6
    //   903: goto -246 -> 657
    //   906: astore 6
    //   908: goto -320 -> 588
    //   911: astore 6
    //   913: goto -394 -> 519
    //   916: astore 6
    //   918: goto -450 -> 468
    //   921: astore 6
    //   923: goto -506 -> 417
    //   926: astore 6
    //   928: goto -562 -> 366
    //   931: astore 6
    //   933: goto -618 -> 315
    //   936: aconst_null
    //   937: astore_2
    //   938: goto -769 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	941	0	this	ConfigServlet
    //   0	941	1	paramQQAppInterface	QQAppInterface
    //   0	941	2	paramConfig	ConfigurationService.Config
    //   24	57	3	i	int
    //   32	59	4	j	int
    //   238	557	5	localObject	Object
    //   896	1	6	localThrowable1	Throwable
    //   901	1	6	localThrowable2	Throwable
    //   906	1	6	localThrowable3	Throwable
    //   911	1	6	localThrowable4	Throwable
    //   916	1	6	localThrowable5	Throwable
    //   921	1	6	localThrowable6	Throwable
    //   926	1	6	localThrowable7	Throwable
    //   931	1	6	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   205	240	803	java/lang/Exception
    //   245	264	803	java/lang/Exception
    //   264	315	803	java/lang/Exception
    //   315	366	803	java/lang/Exception
    //   366	417	803	java/lang/Exception
    //   417	468	803	java/lang/Exception
    //   468	519	803	java/lang/Exception
    //   519	588	803	java/lang/Exception
    //   588	657	803	java/lang/Exception
    //   657	726	803	java/lang/Exception
    //   726	787	803	java/lang/Exception
    //   787	802	803	java/lang/Exception
    //   157	169	831	java/lang/Exception
    //   726	787	892	java/lang/Throwable
    //   657	726	896	java/lang/Throwable
    //   588	657	901	java/lang/Throwable
    //   519	588	906	java/lang/Throwable
    //   468	519	911	java/lang/Throwable
    //   417	468	916	java/lang/Throwable
    //   366	417	921	java/lang/Throwable
    //   315	366	926	java/lang/Throwable
    //   264	315	931	java/lang/Throwable
  }
  
  /* Error */
  void s(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 1704	com/tencent/mobileqq/stt/SttManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   4: istore 4
    //   6: aload_2
    //   7: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   13: istore_3
    //   14: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +40 -> 57
    //   20: ldc 77
    //   22: iconst_2
    //   23: new 79	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 5995
    //   33: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload 4
    //   38: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 5997
    //   44: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload 4
    //   59: iload_3
    //   60: if_icmpeq +158 -> 218
    //   63: aload_1
    //   64: getstatic 6000	com/tencent/mobileqq/app/QQManagerFactory:STT_MANAGER	I
    //   67: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   70: checkcast 1703	com/tencent/mobileqq/stt/SttManager
    //   73: astore 5
    //   75: aload_2
    //   76: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   79: ifnull +216 -> 295
    //   82: aload_2
    //   83: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   86: invokevirtual 386	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   89: ifle +206 -> 295
    //   92: aload_2
    //   93: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   96: iconst_0
    //   97: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   100: checkcast 391	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +108 -> 213
    //   108: aload_2
    //   109: getfield 395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   115: iconst_1
    //   116: if_icmpne +135 -> 251
    //   119: aload_2
    //   120: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   126: invokevirtual 413	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   129: invokestatic 418	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   132: astore_2
    //   133: aload_2
    //   134: ifnull +179 -> 313
    //   137: new 126	java/lang/String
    //   140: dup
    //   141: aload_2
    //   142: ldc_w 420
    //   145: invokespecial 423	java/lang/String:<init>	([BLjava/lang/String;)V
    //   148: astore_2
    //   149: aload_2
    //   150: ifnull +63 -> 213
    //   153: new 128	org/json/JSONObject
    //   156: dup
    //   157: aload_2
    //   158: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   161: ldc_w 6002
    //   164: invokevirtual 141	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   167: istore 4
    //   169: aload 5
    //   171: iload 4
    //   173: invokevirtual 6003	com/tencent/mobileqq/stt/SttManager:a	(I)V
    //   176: ldc 77
    //   178: iconst_1
    //   179: new 79	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 6005
    //   189: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_2
    //   193: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 6007
    //   199: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: iload 4
    //   204: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload_1
    //   214: iload_3
    //   215: invokestatic 6008	com/tencent/mobileqq/stt/SttManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   218: return
    //   219: astore_2
    //   220: ldc 77
    //   222: iconst_1
    //   223: new 79	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   230: ldc_w 6010
    //   233: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_2
    //   237: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aconst_null
    //   247: astore_2
    //   248: goto -99 -> 149
    //   251: aload_2
    //   252: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 449	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   261: astore_2
    //   262: goto -113 -> 149
    //   265: astore_2
    //   266: ldc 77
    //   268: iconst_1
    //   269: new 79	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 6012
    //   279: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_2
    //   283: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: goto -79 -> 213
    //   295: ldc 77
    //   297: iconst_1
    //   298: ldc_w 6014
    //   301: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload 5
    //   306: iconst_0
    //   307: invokevirtual 6003	com/tencent/mobileqq/stt/SttManager:a	(I)V
    //   310: goto -97 -> 213
    //   313: aconst_null
    //   314: astore_2
    //   315: goto -166 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	ConfigServlet
    //   0	318	1	paramQQAppInterface	QQAppInterface
    //   0	318	2	paramConfig	ConfigurationService.Config
    //   13	202	3	i	int
    //   4	199	4	j	int
    //   73	232	5	localSttManager	SttManager
    // Exception table:
    //   from	to	target	type
    //   137	149	219	java/lang/Exception
    //   153	213	265	java/lang/Exception
  }
  
  /* Error */
  protected void t(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: ldc_w 1694
    //   9: iconst_0
    //   10: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: invokestatic 1692	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 526	java/lang/Integer
    //   19: invokevirtual 1588	java/lang/Integer:intValue	()I
    //   22: istore 5
    //   24: aload_2
    //   25: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   28: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   31: istore 6
    //   33: new 79	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 6016
    //   43: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 5997
    //   54: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload 6
    //   59: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 6018
    //   65: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: astore 7
    //   70: aload_2
    //   71: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   74: ifnonnull +109 -> 183
    //   77: iconst_0
    //   78: istore_3
    //   79: ldc_w 6020
    //   82: iconst_1
    //   83: aload 7
    //   85: iload_3
    //   86: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: iload 5
    //   97: iload 6
    //   99: if_icmpeq +621 -> 720
    //   102: aload_2
    //   103: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   106: ifnull +614 -> 720
    //   109: aload_2
    //   110: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   113: invokevirtual 386	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   116: ifle +604 -> 720
    //   119: iload 4
    //   121: istore_3
    //   122: iload_3
    //   123: aload_2
    //   124: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   127: invokevirtual 386	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   130: if_icmpge +64 -> 194
    //   133: ldc_w 6020
    //   136: iconst_1
    //   137: new 79	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 6022
    //   147: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: iload_3
    //   155: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 391	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   161: getfield 3455	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   164: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   167: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: iload_3
    //   177: iconst_1
    //   178: iadd
    //   179: istore_3
    //   180: goto -58 -> 122
    //   183: aload_2
    //   184: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   187: invokevirtual 386	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   190: istore_3
    //   191: goto -112 -> 79
    //   194: aload_2
    //   195: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   198: iconst_0
    //   199: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   202: checkcast 391	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   205: astore 7
    //   207: aload 7
    //   209: ifnull +511 -> 720
    //   212: aload 7
    //   214: getfield 395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   217: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   220: iconst_1
    //   221: if_icmpne +536 -> 757
    //   224: aload 7
    //   226: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   232: invokevirtual 413	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   235: invokestatic 418	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   238: astore 7
    //   240: aload 7
    //   242: ifnull +588 -> 830
    //   245: new 126	java/lang/String
    //   248: dup
    //   249: aload 7
    //   251: ldc_w 420
    //   254: invokespecial 423	java/lang/String:<init>	([BLjava/lang/String;)V
    //   257: astore 7
    //   259: aload 7
    //   261: ifnull +459 -> 720
    //   264: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +31 -> 298
    //   270: ldc_w 6020
    //   273: iconst_1
    //   274: new 79	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 6024
    //   284: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 7
    //   289: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: new 128	org/json/JSONObject
    //   301: dup
    //   302: aload 7
    //   304: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   307: astore 7
    //   309: aload 7
    //   311: ldc_w 6026
    //   314: invokevirtual 6029	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   317: astore 8
    //   319: aload 8
    //   321: invokevirtual 267	org/json/JSONArray:length	()I
    //   324: ifle +18 -> 342
    //   327: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: ldc_w 6031
    //   333: aload 8
    //   335: invokevirtual 4438	org/json/JSONArray:toString	()Ljava/lang/String;
    //   338: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   341: pop
    //   342: aload 7
    //   344: ldc_w 6033
    //   347: invokevirtual 3034	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   350: astore 8
    //   352: aload 8
    //   354: ifnull +18 -> 372
    //   357: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   360: ldc_w 6035
    //   363: aload 8
    //   365: invokevirtual 6036	org/json/JSONObject:toString	()Ljava/lang/String;
    //   368: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   371: pop
    //   372: aload 7
    //   374: ldc_w 6038
    //   377: invokevirtual 221	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   380: istore_3
    //   381: aload 8
    //   383: ifnull +17 -> 400
    //   386: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   389: ldc_w 6040
    //   392: iload_3
    //   393: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   399: pop
    //   400: aload 7
    //   402: ldc_w 6042
    //   405: invokevirtual 3034	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   408: astore 8
    //   410: aload 8
    //   412: ifnull +76 -> 488
    //   415: aload 8
    //   417: ldc_w 6044
    //   420: invokevirtual 221	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   423: istore_3
    //   424: aload 8
    //   426: ldc_w 6046
    //   429: invokevirtual 221	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   432: istore 4
    //   434: aload 8
    //   436: ldc_w 6048
    //   439: invokevirtual 221	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   442: istore 5
    //   444: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   447: ldc_w 6050
    //   450: iload_3
    //   451: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   457: pop
    //   458: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   461: ldc_w 6052
    //   464: iload 4
    //   466: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   469: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   472: pop
    //   473: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   476: ldc_w 6054
    //   479: iload 5
    //   481: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   487: pop
    //   488: aload 7
    //   490: ldc_w 6056
    //   493: invokevirtual 6029	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   496: astore 8
    //   498: aload 8
    //   500: ifnull +273 -> 773
    //   503: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   506: ldc_w 6058
    //   509: aload 8
    //   511: invokevirtual 4438	org/json/JSONArray:toString	()Ljava/lang/String;
    //   514: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   517: pop
    //   518: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   521: ldc_w 1694
    //   524: aload_2
    //   525: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   528: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   531: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   537: pop
    //   538: aload 7
    //   540: ldc_w 6060
    //   543: iconst_0
    //   544: invokevirtual 2027	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   547: istore_3
    //   548: aload 7
    //   550: ldc_w 6062
    //   553: iconst_m1
    //   554: invokevirtual 2027	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   557: istore 4
    //   559: aload 7
    //   561: ldc_w 6064
    //   564: iconst_0
    //   565: invokevirtual 2027	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   568: istore 5
    //   570: aload 7
    //   572: ldc_w 6066
    //   575: iconst_0
    //   576: invokevirtual 2027	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   579: istore 6
    //   581: aload 7
    //   583: ldc_w 6068
    //   586: invokevirtual 2458	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   589: astore_2
    //   590: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   593: ldc_w 6060
    //   596: iload_3
    //   597: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   600: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   603: pop
    //   604: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   607: ldc_w 6062
    //   610: iload 4
    //   612: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   615: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   618: pop
    //   619: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: ldc_w 6064
    //   625: iload 5
    //   627: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   630: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   633: pop
    //   634: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   637: ldc_w 6066
    //   640: iload 6
    //   642: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   648: pop
    //   649: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   652: ldc_w 6070
    //   655: aload_2
    //   656: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   659: pop
    //   660: aload 7
    //   662: ldc_w 6072
    //   665: invokevirtual 221	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   668: istore_3
    //   669: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   672: ldc_w 6072
    //   675: iload_3
    //   676: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   679: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   682: pop
    //   683: aload 7
    //   685: ldc_w 6074
    //   688: invokevirtual 3034	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   691: astore_2
    //   692: aload_2
    //   693: ifnull +17 -> 710
    //   696: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   699: ldc_w 6076
    //   702: aload_2
    //   703: invokevirtual 6036	org/json/JSONObject:toString	()Ljava/lang/String;
    //   706: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   709: pop
    //   710: aload_1
    //   711: ldc_w 6078
    //   714: iconst_1
    //   715: iconst_1
    //   716: aconst_null
    //   717: invokevirtual 6082	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   720: return
    //   721: astore 7
    //   723: ldc_w 6020
    //   726: iconst_1
    //   727: new 79	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 6084
    //   737: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 7
    //   742: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   745: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: aconst_null
    //   752: astore 7
    //   754: goto -495 -> 259
    //   757: aload 7
    //   759: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   762: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   765: invokevirtual 449	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   768: astore 7
    //   770: goto -511 -> 259
    //   773: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   776: ldc_w 6058
    //   779: ldc 13
    //   781: invokestatic 1697	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   784: pop
    //   785: goto -267 -> 518
    //   788: astore_1
    //   789: ldc_w 6020
    //   792: iconst_1
    //   793: new 79	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   800: ldc_w 6086
    //   803: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_1
    //   807: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   810: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: return
    //   817: astore_1
    //   818: ldc_w 6020
    //   821: iconst_1
    //   822: ldc_w 6088
    //   825: aload_1
    //   826: invokestatic 841	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   829: return
    //   830: aconst_null
    //   831: astore 7
    //   833: goto -574 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	836	0	this	ConfigServlet
    //   0	836	1	paramQQAppInterface	QQAppInterface
    //   0	836	2	paramConfig	ConfigurationService.Config
    //   78	598	3	i	int
    //   1	610	4	j	int
    //   22	604	5	k	int
    //   31	610	6	m	int
    //   68	616	7	localObject1	Object
    //   721	20	7	localException	Exception
    //   752	80	7	str	String
    //   317	193	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   245	259	721	java/lang/Exception
    //   298	342	788	java/lang/Exception
    //   342	352	788	java/lang/Exception
    //   357	372	788	java/lang/Exception
    //   372	381	788	java/lang/Exception
    //   386	400	788	java/lang/Exception
    //   400	410	788	java/lang/Exception
    //   415	488	788	java/lang/Exception
    //   488	498	788	java/lang/Exception
    //   503	518	788	java/lang/Exception
    //   518	692	788	java/lang/Exception
    //   696	710	788	java/lang/Exception
    //   710	720	788	java/lang/Exception
    //   773	785	788	java/lang/Exception
    //   3	77	817	java/lang/Exception
    //   79	95	817	java/lang/Exception
    //   102	119	817	java/lang/Exception
    //   122	176	817	java/lang/Exception
    //   183	191	817	java/lang/Exception
    //   194	207	817	java/lang/Exception
    //   212	240	817	java/lang/Exception
    //   264	298	817	java/lang/Exception
    //   723	751	817	java/lang/Exception
    //   757	770	817	java/lang/Exception
    //   789	816	817	java/lang/Exception
  }
  
  void u(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    QLog.i("Contact.RecommendTabConfig", 1, String.format("receive handleContactRecommendTabConfig", new Object[0]));
    if (paramConfig.type.get() != 371) {
      return;
    }
    int i = SharedPreUtils.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if (i == j)
    {
      QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, req-version equals to rsp-version, ver=%d", new Object[] { Integer.valueOf(i) }));
      return;
    }
    byte[] arrayOfByte;
    if (paramConfig.msg_content_list.size() > 0)
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {
        if (paramConfig.compress.get() == 1)
        {
          arrayOfByte = OlympicUtil.a(paramConfig.content.get().toByteArray());
          if (arrayOfByte == null) {
            break label296;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(arrayOfByte, "UTF-8");
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleContactRecommendTabConfig config_content:" + paramConfig);
        }
        SharedPreUtils.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
        SharedPreUtils.G(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        return;
      }
      catch (Exception paramConfig)
      {
        QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, uncompress failed, buf-len=%d", new Object[] { Integer.valueOf(arrayOfByte.length) }));
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, content is null", new Object[0]));
      for (;;)
      {
        paramConfig = null;
        break;
        QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, msg content list is empty", new Object[0]));
      }
      label296:
      paramConfig = null;
    }
  }
  
  /* Error */
  void v(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: ldc_w 6108
    //   12: iconst_1
    //   13: ldc_w 6110
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 534	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_1
    //   27: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: invokestatic 1713	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   36: istore_3
    //   37: aload_2
    //   38: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   41: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   44: istore 6
    //   46: iload_3
    //   47: iload 6
    //   49: if_icmpeq +396 -> 445
    //   52: aload_2
    //   53: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   56: ifnull +365 -> 421
    //   59: aload_2
    //   60: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   63: invokevirtual 386	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   66: ifle +355 -> 421
    //   69: aload_2
    //   70: getfield 383	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   73: iconst_0
    //   74: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   77: checkcast 391	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +326 -> 408
    //   85: aload_2
    //   86: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   89: invokevirtual 870	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   92: ifeq +316 -> 408
    //   95: aload_2
    //   96: getfield 395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   99: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   102: iconst_1
    //   103: if_icmpne +217 -> 320
    //   106: aload_2
    //   107: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   110: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   113: invokevirtual 413	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   116: invokestatic 418	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull +393 -> 514
    //   124: new 126	java/lang/String
    //   127: dup
    //   128: aload_2
    //   129: ldc_w 420
    //   132: invokespecial 423	java/lang/String:<init>	([BLjava/lang/String;)V
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +215 -> 352
    //   140: new 128	org/json/JSONObject
    //   143: dup
    //   144: aload_2
    //   145: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: astore 9
    //   150: ldc_w 6108
    //   153: iconst_1
    //   154: new 79	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 6112
    //   164: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 9
    //   179: ldc_w 6114
    //   182: invokevirtual 141	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   185: istore_3
    //   186: aload 9
    //   188: ldc_w 6116
    //   191: invokevirtual 141	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   194: istore 4
    //   196: aload 9
    //   198: ldc_w 6118
    //   201: invokevirtual 262	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   204: astore 9
    //   206: aload 8
    //   208: astore_2
    //   209: aload 9
    //   211: ifnull +123 -> 334
    //   214: aload 8
    //   216: astore_2
    //   217: aload 9
    //   219: invokevirtual 267	org/json/JSONArray:length	()I
    //   222: ifle +112 -> 334
    //   225: new 269	java/util/HashSet
    //   228: dup
    //   229: invokespecial 270	java/util/HashSet:<init>	()V
    //   232: astore_2
    //   233: iload 5
    //   235: aload 9
    //   237: invokevirtual 267	org/json/JSONArray:length	()I
    //   240: if_icmpge +94 -> 334
    //   243: aload 9
    //   245: iload 5
    //   247: invokevirtual 6119	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   250: checkcast 128	org/json/JSONObject
    //   253: ldc_w 6121
    //   256: invokevirtual 161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore 7
    //   261: aload 7
    //   263: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne +12 -> 278
    //   269: aload_2
    //   270: aload 7
    //   272: invokeinterface 5064 2 0
    //   277: pop
    //   278: iload 5
    //   280: iconst_1
    //   281: iadd
    //   282: istore 5
    //   284: goto -51 -> 233
    //   287: astore_2
    //   288: ldc_w 6108
    //   291: iconst_1
    //   292: new 79	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 6123
    //   302: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_2
    //   306: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aconst_null
    //   316: astore_2
    //   317: goto -181 -> 136
    //   320: aload_2
    //   321: getfield 402	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   324: invokevirtual 407	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   327: invokevirtual 449	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   330: astore_2
    //   331: goto -195 -> 136
    //   334: iload_3
    //   335: istore 5
    //   337: iload 4
    //   339: istore_3
    //   340: aload_1
    //   341: invokestatic 6126	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager;
    //   344: aload_1
    //   345: iload 5
    //   347: iload_3
    //   348: aload_2
    //   349: invokevirtual 6129	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   352: aload_1
    //   353: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   356: getstatic 15	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   359: iload 6
    //   361: invokestatic 6130	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   364: return
    //   365: astore_2
    //   366: iconst_0
    //   367: istore 4
    //   369: iconst_0
    //   370: istore_3
    //   371: ldc_w 6108
    //   374: iconst_1
    //   375: new 79	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 6012
    //   385: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_2
    //   389: invokevirtual 729	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload 7
    //   400: astore_2
    //   401: iload 4
    //   403: istore 5
    //   405: goto -65 -> 340
    //   408: ldc_w 6108
    //   411: iconst_1
    //   412: ldc_w 6132
    //   415: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -66 -> 352
    //   421: ldc_w 6108
    //   424: iconst_1
    //   425: ldc_w 6134
    //   428: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload_1
    //   432: invokestatic 6126	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager;
    //   435: aload_1
    //   436: iconst_0
    //   437: iconst_0
    //   438: aconst_null
    //   439: invokevirtual 6129	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   442: goto -90 -> 352
    //   445: ldc_w 6108
    //   448: iconst_1
    //   449: ldc_w 6136
    //   452: iconst_1
    //   453: anewarray 4	java/lang/Object
    //   456: dup
    //   457: iconst_0
    //   458: iload_3
    //   459: invokestatic 530	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   462: aastore
    //   463: invokestatic 534	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   466: invokestatic 505	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: return
    //   470: astore_2
    //   471: iload_3
    //   472: istore 4
    //   474: iconst_0
    //   475: istore_3
    //   476: goto -105 -> 371
    //   479: astore_2
    //   480: iload_3
    //   481: istore 5
    //   483: iload 4
    //   485: istore_3
    //   486: iload 5
    //   488: istore 4
    //   490: goto -119 -> 371
    //   493: astore 8
    //   495: iload_3
    //   496: istore 5
    //   498: iload 4
    //   500: istore_3
    //   501: aload_2
    //   502: astore 7
    //   504: iload 5
    //   506: istore 4
    //   508: aload 8
    //   510: astore_2
    //   511: goto -140 -> 371
    //   514: aconst_null
    //   515: astore_2
    //   516: goto -380 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	this	ConfigServlet
    //   0	519	1	paramQQAppInterface	QQAppInterface
    //   0	519	2	paramConfig	ConfigurationService.Config
    //   36	465	3	i	int
    //   194	313	4	j	int
    //   7	498	5	k	int
    //   44	316	6	m	int
    //   1	502	7	localObject1	Object
    //   4	211	8	localObject2	Object
    //   493	16	8	localException	Exception
    //   148	96	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   124	136	287	java/lang/Exception
    //   140	186	365	java/lang/Exception
    //   186	196	470	java/lang/Exception
    //   196	206	479	java/lang/Exception
    //   217	233	479	java/lang/Exception
    //   233	278	493	java/lang/Exception
  }
  
  void x(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new ConfigServlet.13(this, paramConfig, paramQQAppInterface));
  }
  
  void y(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = SharedPreUtils.al(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if ((paramConfig != null) && (paramConfig.content.has())) {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
            if (paramConfig == null) {
              break label339;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        SharedPreUtils.I(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        ((CUOpenCardGuideMng)paramQQAppInterface.getManager(QQManagerFactory.CU_OPEN_CARD_GUIDE_MANAGER)).a(paramConfig);
        if (QLog.isColorLevel()) {
          QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig reqVer: %d rspVer: %d config: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramConfig }));
        }
        return;
      }
      catch (Exception paramConfig)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "handleCUOpenCardGuideConfig|uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      paramConfig = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig empty content", new Object[0]));
        paramConfig = localObject1;
        continue;
        paramConfig = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig empty config", new Object[0]));
          paramConfig = localObject1;
          continue;
          paramConfig = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig same version, no need to update", new Object[0]));
            paramConfig = localObject2;
            continue;
            label339:
            paramConfig = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet
 * JD-Core Version:    0.7.0.1
 */