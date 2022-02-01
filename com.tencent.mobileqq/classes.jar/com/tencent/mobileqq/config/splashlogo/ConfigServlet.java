package com.tencent.mobileqq.config.splashlogo;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager;
import com.tencent.aelight.camera.qqstory.api.IQIMBeautyManager;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.av.QAVConfig;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.config.TextFilterConfig;
import com.tencent.biz.qqstory.troop.TroopDynamicConfig;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.biz.troopconfig.TroopConfigForAllUser;
import com.tencent.biz.troopgift.GiftConfigManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.qfind.QFindConfigUtil;
import com.tencent.hotpatch.PatchFileManager;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.hotpatch.config.PatchConfigServlet;
import com.tencent.mobileqq.activity.aio.AIOConfigManager;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListConfigManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityBannerData;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.recent.RecentPubAccManager;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.soso.LbsInfoReportManager;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.ar.ARGlobalConfigManager;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigParser;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.QConfigServlet;
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
import com.tencent.mobileqq.doutu.api.IDoutuSPUtil;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager.ConfigLoader;
import com.tencent.mobileqq.intervideo.now.NowGeneralConfigManager;
import com.tencent.mobileqq.kandian.base.report.api.IFeManager;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.managers.PasswdRedBagFoldManager;
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
import com.tencent.mobileqq.nearby.NearbyEnterUpdateObserver;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyFlowerUtil;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtils;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.ocr.data.OcrConfig;
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
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.search.util.SearchConfigServlet;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.soload.config.SoLoadConfProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.tofumsg.ITofuManagerNew;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.utils.NearbyVideoChatManager;
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
import com.tencent.mobileqq.weiyun.utils.PreferenceUtils;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.util.notification.NotificationController;
import cooperation.pluginbridge.BridgeHelper;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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
import java.util.zip.InflaterInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import protocol.KQQConfig.UpgradeInfo;

public class ConfigServlet
{
  public static String a = "";
  public static final int[] a;
  private static String b;
  private boolean a;
  
  static
  {
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131702615);
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 2, 3, 5, 10, 13, 23, 31, 38, 42, 44, 46, 47, 49, 53, 55, 56, 57, 61, 62, 63, 64, 65, 66, 69, 205, 72, 73, 74, 75, 385, 94, 78, 79, 80, 84, 223, 82, 101, 102, 147, 93, 90, 96, 97, 108, 146, 111, 109, 115, 286, 118, 119, 116, 130, 142, 121, 157, 211, 201, 129, 143, 140, 257, 232, 233, 148, 139, 145, 153, 149, 155, 165, 185, 167, 166, 171, 180, 182, 177, 371, 181, 184, 187, 191, 193, 188, 195, 227, 202, 210, 212, 407, StoryApi.a(2131427356), StoryApi.a(2131427357), StoryApi.a(2131427358), StoryApi.a(2131427353), StoryApi.a(2131427354), 218, 226, 225, 222, 256, 228, 235, 234, 238, 247, 244, 245, 253, 295, 254, 259, 260, 262, 204, 271, 275, 358, 268, 269, 272, 274, 279, 308, 281, 283, 284, 280, 289, 314, 297, 301, 296, 330, 347, 313, 312, 397, 321, 326, 320, 328, 331, 336, 337, 345, 349, 355, 372, 384, 379, 357, 378, 381, 273, 364, 365, 369, 387, 386, 392, 393, 394, 401, 400, 403, 404, 405, 408, 410, 194, 596, 604, 705 };
  }
  
  public ConfigServlet()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static void N(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = PreferenceUtils.c(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleWeiYunMiniAppConfig: ,version: ");
      ((StringBuilder)localObject1).append(paramConfig.version.get());
      ((StringBuilder)localObject1).append("| localVersion: ");
      ((StringBuilder)localObject1).append(j);
      QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
    }
    if (i != j)
    {
      PreferenceUtils.a(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = paramConfig.iterator();
        while (paramConfig.hasNext())
        {
          localObject1 = (String)paramConfig.next();
          try
          {
            localObject1 = new JSONObject((String)localObject1);
            Object localObject2;
            if (((JSONObject)localObject1).has("isWeiYunMiniApp"))
            {
              i = ((JSONObject)localObject1).getInt("isWeiYunMiniApp");
              PreferenceUtils.a(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("handleWeiYunMiniAppConfig, enableMiniApp = ");
                ((StringBuilder)localObject2).append(i);
                QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
              }
            }
            if (((JSONObject)localObject1).has("apkgUrl"))
            {
              localObject2 = ((JSONObject)localObject1).getString("apkgUrl");
              PreferenceUtils.b(BaseApplication.getContext(), (String)localObject2, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("handleWeiYunMiniAppConfig, apkgUrl = ");
                localStringBuilder.append((String)localObject2);
                QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
              }
            }
            if (((JSONObject)localObject1).has("miniVersion"))
            {
              i = ((JSONObject)localObject1).getInt("miniVersion");
              PreferenceUtils.b(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("handleWeiYunMiniAppConfig, miniVersion = ");
                ((StringBuilder)localObject1).append(i);
                QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
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
  
  public static void O(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.aM(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleAIOConfig: ,version: ");
      localStringBuilder.append(paramConfig.version.get());
      localStringBuilder.append("| localVersion: ");
      localStringBuilder.append(j);
      QLog.i("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
    }
    if (i != j)
    {
      SharedPreUtils.Y(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {
        return;
      }
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
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
    }
  }
  
  public static void P(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.aN(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMultiMsgConfig: ,version: ");
      localStringBuilder.append(paramConfig.version.get());
      localStringBuilder.append("| localVersion: ");
      localStringBuilder.append(j);
      QLog.i("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
    }
    if (i != j)
    {
      SharedPreUtils.Z(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {
        return;
      }
      try
      {
        i = new JSONObject((String)paramConfig.get(paramConfig.size() - 1)).optInt("max_multimsg_totalcount");
        SharedPreUtils.g(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, "multimsg_config", i);
        if (QLog.isColorLevel())
        {
          paramConfig = new StringBuilder();
          paramConfig.append("handleMultiMsgConfig:limitTotal =  ");
          paramConfig.append(i);
          QLog.i("SPLASH_ConfigServlet", 2, paramConfig.toString());
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
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
    }
  }
  
  private void Q(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.at(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleConversationPublicAccConfig: ,version: ");
      ((StringBuilder)localObject1).append(paramConfig.version.get());
      ((StringBuilder)localObject1).append("| localVersion: ");
      ((StringBuilder)localObject1).append(j);
      QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    Object localObject3;
    if (i != j)
    {
      SharedPreUtils.L(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      localObject1 = a(paramConfig);
      paramConfig = new HashSet();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label432;
      }
      localObject1 = ((List)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label432;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("handleConversationPublicAccConfig: config_content =");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject3).toString());
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        if (((JSONObject)localObject2).has("enable"))
        {
          i = ((JSONObject)localObject2).getInt("enable");
          localObject3 = RecentPubAccManager.a();
          bool = true;
          if (i != 1) {
            break label433;
          }
          ((RecentPubAccManager)localObject3).a(paramQQAppInterface, bool);
        }
        else
        {
          RecentPubAccManager.a().a(paramQQAppInterface, false);
        }
        if (((JSONObject)localObject2).has("list"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("list");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            j = ((JSONArray)localObject2).length();
            i = 0;
            if (i < j)
            {
              localObject3 = ((JSONArray)localObject2).optString(i);
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label439;
              }
              paramConfig.add(localObject3);
              break label439;
            }
          }
        }
        RecentPubAccManager.a().a(paramQQAppInterface, paramConfig);
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("handleConversationPublicAccConfig  error =");
          ((StringBuilder)localObject3).append(localJSONException.getMessage());
          QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject3).toString());
        }
        RecentPubAccManager.a().a(paramQQAppInterface, false);
        RecentPubAccManager.a().a(paramQQAppInterface, null);
      }
      break;
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig:localVersiont == version ");
      }
      label432:
      return;
      label433:
      boolean bool = false;
      continue;
      label439:
      i += 1;
    }
  }
  
  private void R(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleBeancurdConfig: ,version: ");
      localStringBuilder.append(paramConfig.version.get());
      localStringBuilder.append("| localVersion: ");
      localStringBuilder.append(j);
      QLog.i("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
    }
    if (i != j)
    {
      SharedPreUtils.a(i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleBeancurdConfigStr: ");
          localStringBuilder.append(paramConfig);
          QLog.i("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
        }
        SharedPreUtils.b(paramConfig);
        ((BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).a(paramConfig);
        ((ITofuManagerNew)paramQQAppInterface.getManager(QQManagerFactory.TOFU_NEW_MANAGER)).a(paramConfig);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig:localVersiont == version ");
    }
  }
  
  private void S(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.as(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleZhituConfig: ,version: ");
      ((StringBuilder)localObject1).append(paramConfig.version.get());
      ((StringBuilder)localObject1).append("| localVersion: ");
      ((StringBuilder)localObject1).append(j);
      QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if (i != j)
    {
      SharedPreUtils.K(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {
        break label378;
      }
      paramConfig = paramConfig.iterator();
      if (!paramConfig.hasNext()) {
        break label378;
      }
      localObject1 = (String)paramConfig.next();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleZhituConfig: config_content =");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        bool1 = ((JSONObject)localObject1).has("kMarioConfigEnable");
        boolean bool2 = false;
        if (bool1)
        {
          i = ((JSONObject)localObject1).getInt("kMarioConfigEnable");
          localObject2 = ZhituManager.a(paramQQAppInterface);
          if (i != 1) {
            break label379;
          }
          bool1 = true;
          ((ZhituManager)localObject2).a(bool1);
        }
        if (((JSONObject)localObject1).has("kMarioPageLen"))
        {
          i = ((JSONObject)localObject1).getInt("kMarioPageLen");
          ZhituManager.a(paramQQAppInterface).b(i);
        }
        if (((JSONObject)localObject1).has("kMarioSaveAndShareEnable"))
        {
          i = ((JSONObject)localObject1).getInt("kMarioSaveAndShareEnable");
          localObject2 = ZhituManager.a(paramQQAppInterface);
          bool1 = bool2;
          if (i == 1) {
            bool1 = true;
          }
          ((ZhituManager)localObject2).b(bool1);
        }
        if (!((JSONObject)localObject1).has("kMarioSafeGateRequestInterval")) {
          break;
        }
        i = ((JSONObject)localObject1).getInt("kMarioSafeGateRequestInterval");
        ZhituManager.a(paramQQAppInterface).a(i);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      break;
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig:localVersiont == version ");
      }
      label378:
      return;
      label379:
      boolean bool1 = false;
    }
  }
  
  private void T(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    a(paramQQAppInterface, paramConfig, "handleShortVideoMsgTailConfig", new ConfigServlet.2(this, paramQQAppInterface));
  }
  
  private void U(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.g(paramQQAppInterface.getApp());
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTroopRankConfigCmd, serverVersion=");
      localStringBuilder.append(i);
      localStringBuilder.append("|localVersion=");
      localStringBuilder.append(j);
      QLog.d("TroopRankConfig", 2, localStringBuilder.toString());
    }
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() == 1)
        {
          byte[] arrayOfByte = OlympicUtil.a(paramConfig.content.get().toByteArray());
          localStringBuilder = null;
          paramConfig = localStringBuilder;
          if (arrayOfByte != null)
          {
            try
            {
              paramConfig = new String(arrayOfByte, "UTF-8");
            }
            catch (OutOfMemoryError paramConfig)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", paramConfig);
                }
                System.gc();
                try
                {
                  paramConfig = new String(arrayOfByte, "UTF-8");
                }
                catch (Throwable localThrowable)
                {
                  paramConfig = localStringBuilder;
                  if (!QLog.isColorLevel()) {
                    break label275;
                  }
                }
              }
              QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", localThrowable);
              paramConfig = localStringBuilder;
            }
            catch (Exception localException)
            {
              paramConfig = localStringBuilder;
              if (!QLog.isColorLevel()) {
                break label275;
              }
            }
            QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", localException);
            paramConfig = localStringBuilder;
          }
        }
        else
        {
          paramConfig = paramConfig.content.get().toStringUtf8();
        }
        label275:
        if (!TextUtils.isEmpty(paramConfig))
        {
          boolean bool = TroopRankConfig.a(paramConfig);
          if (bool) {
            SharedPreUtils.e(paramQQAppInterface.getApp(), i);
          }
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("refreshConfig ret=");
            paramQQAppInterface.append(bool);
            QLog.d("TroopRankConfig", 2, paramQQAppInterface.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("TroopRankConfig", 2, "handleTroopRankConfigCmd, config_content is empty");
        }
      }
    }
  }
  
  private void V(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
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
            StringBuilder localStringBuilder;
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("receiveAllConfigs|type: 96,content: ");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(",version: ");
              localStringBuilder.append(paramConfig.version.get());
              QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
            }
            int j = paramConfig.version.get();
            if ((j != SharedPreUtils.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
            {
              localObject = ((String)localObject).split("=");
              if (localObject.length >= 2)
              {
                boolean bool = "xqh_insert_into_feeds".equals(localObject[0]);
                if (bool)
                {
                  ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateReadInJoyInterestedPushSwitch("1".equals(localObject[1]));
                  if (QLog.isColorLevel())
                  {
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append("update KANDIAN_INTERESTED_PUSH_CONFiG config , switch : ");
                    localStringBuilder.append("1".equals(localObject[1]));
                    QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
                  }
                }
                else if ("simple_switch_fm".equals(localObject[0]))
                {
                  ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateOpenSimpleSwitchFm("1".equals(localObject[1]));
                  if (QLog.isColorLevel())
                  {
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append("update READINJOY_SIMPLE_SWITCH_FM config , switch : ");
                    localStringBuilder.append("1".equals(localObject[1]));
                    QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
                  }
                }
                else if ("simple_force_report_once".equals(localObject[0]))
                {
                  ((IFeManager)QRoute.api(IFeManager.class)).updateForceReport(paramQQAppInterface, "1".equals(localObject[1]));
                  if (QLog.isColorLevel())
                  {
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append("update simple_force_report_once config , switch : ");
                    localStringBuilder.append("1".equals(localObject[1]));
                    QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
                  }
                }
              }
              SharedPreUtils.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString, j);
              break label562;
            }
            if (!QLog.isColorLevel()) {
              break label562;
            }
            QLog.d("SPLASH_ConfigServlet", 2, "received KANDIAN_INTERESTED_PUSH_CONFiG IGNORE THIS ACTION  because of SAME VERSION ");
            break label562;
          }
        }
        else if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 96,content_list is empty ,version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel())
        {
          paramConfig = new StringBuilder();
          paramConfig.append("received readinjoy interested push config error,cmd : 96");
          paramConfig.append(paramQQAppInterface.toString());
          QLog.e("SPLASH_ConfigServlet", 2, paramConfig.toString());
        }
      }
      return;
      label562:
      i += 1;
    }
  }
  
  private void W(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.o(paramQQAppInterface.getApp());
    if (QLog.isColorLevel()) {
      QLog.d("VideoDownCTWhiteList", 2, String.format("received VideoDownCTWhiteList remote version: %d, localVersion: %d, cmd: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(80) }));
    }
    if (i != j)
    {
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        String str = (String)paramConfig.content_list.get(0);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("receiveAllConfigs|type: 80,content: ");
          localStringBuilder.append(str);
          localStringBuilder.append(",version: ");
          localStringBuilder.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
        }
        SharedPreUtils.l(paramQQAppInterface.getApp(), i, str);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("receiveAllConfigs|type: 80,content_list is empty ,version: ");
        paramQQAppInterface.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  private void X(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.p(paramQQAppInterface.getApp());
    if (QLog.isColorLevel()) {
      QLog.d("MixMsgForwardConfig", 2, String.format("received MixMsgForwardConfig remote version: %d, localVersion: %d, cmd: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(111) }));
    }
    if (i != j)
    {
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        String str = (String)paramConfig.content_list.get(0);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("receiveAllConfigs|type: 111,content: ");
          localStringBuilder.append(str);
          localStringBuilder.append(",version: ");
          localStringBuilder.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
        }
        SharedPreUtils.m(paramQQAppInterface.getApp(), i, str);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("receiveAllConfigs|type: 111,content_list is empty ,version:");
        paramQQAppInterface.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  private void Y(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i;
    label366:
    label372:
    for (;;)
    {
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i >= paramConfig.content_list.size()) {
            break label366;
          }
          localObject1 = ((String)paramConfig.content_list.get(i)).trim();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("receiveAllConfigs|type: 118,content: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(",version: ");
            ((StringBuilder)localObject2).append(paramConfig.version.get());
            QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, ((StringBuilder)localObject2).toString());
          }
          k = paramConfig.version.get();
          if (k != SharedPreUtils.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString))
          {
            boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
            if (bool) {}
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        Object localObject1;
        Object localObject2;
        int k;
        int m;
        int j;
        if (QLog.isColorLevel())
        {
          paramConfig = new StringBuilder();
          paramConfig.append("received change machine config error,cmd : 118");
          paramConfig.append(paramQQAppInterface.toString());
          QLog.e("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, paramConfig.toString());
        }
      }
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        m = ((JSONArray)localObject1).length();
        j = 0;
        if (j >= m) {
          continue;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(j);
        SharedPreUtils.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), ((JSONObject)localObject2).optInt("bid"), ((JSONObject)localObject2).optInt("actionType"));
        j += 1;
        continue;
      }
      catch (JSONException localJSONException)
      {
        continue;
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received JSONException ");
      }
      SharedPreUtils.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString, k);
      break label372;
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        break label372;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 118,content_list is empty ,version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, paramQQAppInterface.toString());
          return;
        }
        return;
      }
    }
  }
  
  private void Z(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject1 = paramConfig;
    Object localObject2 = "troop_common_config_version";
    int i;
    label789:
    label805:
    for (;;)
    {
      try
      {
        if ((((ConfigurationService.Config)localObject1).content_list != null) && (((ConfigurationService.Config)localObject1).content_list.size() > 0))
        {
          i = 0;
          localObject1 = localObject2;
          localObject3 = paramConfig;
          localObject2 = paramQQAppInterface;
          if (i >= ((ConfigurationService.Config)localObject3).content_list.size()) {
            break label789;
          }
          str1 = ((String)((ConfigurationService.Config)localObject3).content_list.get(i)).trim();
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("receiveAllConfigs|type: 142,content: ");
            ((StringBuilder)localObject4).append(str1);
            ((StringBuilder)localObject4).append(",version: ");
            ((StringBuilder)localObject4).append(((ConfigurationService.Config)localObject3).version.get());
            QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, ((StringBuilder)localObject4).toString());
          }
          j = ((ConfigurationService.Config)localObject3).version.get();
          if (j != SharedPreUtils.a(paramQQAppInterface.getApp(), (String)localObject1, jdField_a_of_type_JavaLangString))
          {
            boolean bool = TextUtils.isEmpty(str1);
            if (bool) {}
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        Object localObject3;
        String str1;
        Object localObject4;
        int j;
        String str2;
        Object localObject5;
        if (QLog.isColorLevel())
        {
          paramConfig = new StringBuilder();
          paramConfig.append("received change machine config error,cmd : 142");
          paramConfig.append(paramQQAppInterface.toString());
          QLog.e("SPLASH_ConfigServlet.troop_common_config", 2, paramConfig.toString());
        }
      }
      try
      {
        localObject3 = new JSONObject(str1);
        localObject4 = paramQQAppInterface.getApp();
        str2 = paramQQAppInterface.getCurrentAccountUin();
      }
      catch (JSONException localJSONException1)
      {
        continue;
      }
      try
      {
        SharedPreUtils.e((Context)localObject4, str2, ((JSONObject)localObject3).optString("hot_chat_link"));
        SharedPreUtils.s(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), ((JSONObject)localObject3).optInt("aio_post_tab_plugin"));
        ((ITroopRobotService)((QQAppInterface)localObject2).getRuntimeService(ITroopRobotService.class, "all")).configRobotFromServer((JSONObject)localObject3);
        ((LbsInfoReportManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.LBS_REPORT_MANAGER)).a((JSONObject)localObject3);
        SharedPreUtils.r(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), ((JSONObject)localObject3).optInt("create_troop_max_invite_num"));
        localObject2 = ((JSONObject)localObject3).optString("nearby_faceVideo_show");
        localObject4 = ((JSONObject)localObject3).optString("nearby_faceVideo_LV");
        str2 = ((JSONObject)localObject3).optString("nearby_heart_switch");
        localObject5 = BaseApplicationImpl.getContext();
      }
      catch (JSONException localJSONException2)
      {
        continue;
      }
      try
      {
        localObject5 = ((BaseApplication)localObject5).getSharedPreferences("nearby_enters", 4);
        ((SharedPreferences)localObject5).edit().putString("config_content", str1).commit();
        ((SharedPreferences)localObject5).edit().putString("nearby_faceVideo_show", (String)localObject2).commit();
        ((SharedPreferences)localObject5).edit().putString("nearby_heart_switch", str2).commit();
        ((SharedPreferences)localObject5).edit().putString("nearby_faceVideo_LV", (String)localObject4).commit();
        localObject2 = ((JSONObject)localObject3).optJSONObject("face_score_enter_config");
        if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("title"))) {
          ((SharedPreferences)localObject5).edit().putString("face_title", ((JSONObject)localObject2).optString("title")).commit();
        }
        if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("detail_default"))) {
          ((SharedPreferences)localObject5).edit().putString("face_detail_default", ((JSONObject)localObject2).optString("detail_default")).commit();
        }
        if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("jump_url"))) {
          ((SharedPreferences)localObject5).edit().putString("face_jump_url", ((JSONObject)localObject2).optString("jump_url")).commit();
        }
        if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("detail_num"))) {
          ((SharedPreferences)localObject5).edit().putString("face_detail_num", ((JSONObject)localObject2).optString("detail_num")).commit();
        }
        SharedPreUtils.t(paramQQAppInterface.getApp(), ((JSONObject)localObject3).optString("group_houseKeeper_switch"));
      }
      catch (JSONException localJSONException3)
      {
        continue;
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SPLASH_ConfigServlet.troop_common_config", 2, "received JSONException ");
      }
      localObject2 = paramQQAppInterface.getApp();
      localObject3 = jdField_a_of_type_JavaLangString;
      SharedPreUtils.a((Context)localObject2, (String)localObject1, (String)localObject3, j);
      break label805;
      localObject2 = localObject1;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        localObject1 = localObject2;
        break label805;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 142,content_list is empty ,version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, paramQQAppInterface.toString());
          return;
        }
        return;
      }
    }
  }
  
  private float a(float paramFloat)
  {
    return paramFloat / 100.0F * (float)DeviceInfoUtil.g();
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 + 50.0F) / 100.0F * paramFloat2;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 / 2.0F - paramFloat1 * paramFloat3 / 100.0F;
  }
  
  private int a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString)
  {
    AEOldShortVideoResManager localAEOldShortVideoResManager = AEOldShortVideoResManager.a(paramQQAppInterface);
    int i = 0;
    int j;
    if ((localAEOldShortVideoResManager == null) && ("ConfigurationService.ReqGetConfigNoLogin".equals(paramString)))
    {
      localAEOldShortVideoResManager = new AEOldShortVideoResManager(paramQQAppInterface);
      j = 1;
    }
    else
    {
      j = 0;
    }
    int k = AEOldShortVideoResManager.a();
    int m = paramConfig.version.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiveAllConfigs[handleShortVideoResourceConfig]|received remote version: ");
    localStringBuilder.append(m);
    localStringBuilder.append(" | localVersion: ");
    localStringBuilder.append(k);
    QLog.d("AEOldShortVideoResManager", 1, localStringBuilder.toString());
    if (m != k)
    {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramConfig.msg_content_list.size() - 1);
        if (paramConfig != null)
        {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
            if (paramConfig != null) {
              try
              {
                paramConfig = new String(paramConfig, "UTF-8");
              }
              catch (Throwable paramConfig)
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("receiveAllConfigs[handleShortVideoResourceConfig]|Throwable:");
                localStringBuilder.append(paramConfig.getMessage());
                QLog.d("SPLASH_ConfigServlet", 1, localStringBuilder.toString());
                break label256;
              }
            } else {
              QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|inflateConfigString error!");
            }
            label256:
            paramConfig = "";
          }
          else
          {
            paramConfig = paramConfig.content.get().toStringUtf8();
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("receiveAllConfigs[handleShortVideoResourceConfig]|config_content ");
          localStringBuilder.append(paramConfig);
          QLog.d("SPLASH_ConfigServlet", 1, localStringBuilder.toString());
          if ("ConfigurationService.ReqGetConfigNoLogin".equals(paramString)) {
            i = localAEOldShortVideoResManager.a(paramConfig, m);
          } else {
            i = localAEOldShortVideoResManager.a(paramQQAppInterface.getApp(), paramConfig, m);
          }
          break label415;
        }
        QLog.d("AEOldShortVideoResManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]| content==null");
      }
      else
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("receiveAllConfigs[handleShortVideoResourceConfig]| msg_content_list is empty ,version: ");
        paramQQAppInterface.append(m);
        paramQQAppInterface.append(",localVersion:");
        paramQQAppInterface.append(k);
        QLog.d("AEOldShortVideoResManager", 1, paramQQAppInterface.toString());
      }
      i = -125;
    }
    label415:
    if (j != 0) {
      localAEOldShortVideoResManager.c();
    }
    return i;
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
  
  private QQOperationViopTipTask a(String paramString, QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    for (;;)
    {
      try
      {
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        Object localObject = paramString.getElementsByTagName("tipsbanner");
        if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
        {
          localObject = paramString.getElementsByTagName("task");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
            paramQQOperationViopTipTask.taskid = Integer.parseInt(paramString.getElementsByTagName("task").item(0).getFirstChild().getNodeValue());
          }
          localObject = paramString.getElementsByTagName("aio_count_limit");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
            paramQQOperationViopTipTask.limitDayAIOCount = Integer.parseInt(paramString.getElementsByTagName("aio_count_limit").item(0).getFirstChild().getNodeValue());
          }
          localObject = paramString.getElementsByTagName("aio_display_limit");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
            paramQQOperationViopTipTask.limitDayAIOShowCount = Integer.parseInt(paramString.getElementsByTagName("aio_display_limit").item(0).getFirstChild().getNodeValue());
          }
          localObject = paramString.getElementsByTagName("aio_count_total_limit");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
            paramQQOperationViopTipTask.limitTotalAIOCount = Integer.parseInt(paramString.getElementsByTagName("aio_count_total_limit").item(0).getFirstChild().getNodeValue());
          }
          localObject = paramString.getElementsByTagName("aio_display_total_limit");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
            paramQQOperationViopTipTask.limitTotalShowCount = Integer.parseInt(paramString.getElementsByTagName("aio_display_total_limit").item(0).getFirstChild().getNodeValue());
          }
          localObject = paramString.getElementsByTagName("keyword_list");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
            paramQQOperationViopTipTask.setKeywordString(paramString.getElementsByTagName("keyword_list").item(0).getFirstChild().getNodeValue());
          }
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("parse task XML, keywords:");
            ((StringBuilder)localObject).append(paramQQOperationViopTipTask.getKeywordList());
            QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject).toString());
          }
          localObject = paramString.getElementsByTagName("begin");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
            paramQQOperationViopTipTask.setBeginTime(paramString.getElementsByTagName("begin").item(0).getFirstChild().getNodeValue());
          }
          localObject = paramString.getElementsByTagName("end");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
            paramQQOperationViopTipTask.setEndTime(paramString.getElementsByTagName("end").item(0).getFirstChild().getNodeValue());
          }
          localObject = paramString.getElementsByTagName("uin_type");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
          {
            if (Integer.parseInt(paramString.getElementsByTagName("uin_type").item(0).getFirstChild().getNodeValue()) != 1) {
              break label1339;
            }
            i = 0;
            paramQQOperationViopTipTask.uinType = i;
          }
          localObject = paramString.getElementsByTagName("frequency");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
          {
            localObject = ((Element)paramString.getElementsByTagName("frequency").item(0)).getElementsByTagName("time");
            if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
              paramQQOperationViopTipTask.frequencyTime = Integer.parseInt(((Element)paramString.getElementsByTagName("frequency").item(0)).getElementsByTagName("time").item(0).getFirstChild().getNodeValue());
            }
            localObject = ((Element)paramString.getElementsByTagName("frequency").item(0)).getElementsByTagName("message");
            if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
              paramQQOperationViopTipTask.frequencyMessage = Integer.parseInt(((Element)paramString.getElementsByTagName("frequency").item(0)).getElementsByTagName("message").item(0).getFirstChild().getNodeValue());
            }
          }
          localObject = paramString.getElementsByTagName("wording");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
          {
            localObject = ((Element)paramString.getElementsByTagName("wording").item(0)).getElementsByTagName("type");
            if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
              paramQQOperationViopTipTask.tipType = Integer.parseInt(((Element)paramString.getElementsByTagName("wording").item(0)).getElementsByTagName("type").item(0).getFirstChild().getNodeValue());
            }
            localObject = ((Element)paramString.getElementsByTagName("wording").item(0)).getElementsByTagName("message");
            if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
              paramQQOperationViopTipTask.adwords = ((Element)paramString.getElementsByTagName("wording").item(0)).getElementsByTagName("message").item(0).getFirstChild().getNodeValue();
            }
            localObject = ((Element)paramString.getElementsByTagName("wording").item(0)).getElementsByTagName("link_offset");
            if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
              paramQQOperationViopTipTask.linkOffset = Integer.parseInt(((Element)paramString.getElementsByTagName("wording").item(0)).getElementsByTagName("link_offset").item(0).getFirstChild().getNodeValue());
            }
            localObject = ((Element)paramString.getElementsByTagName("wording").item(0)).getElementsByTagName("link_message");
            if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
              paramQQOperationViopTipTask.clickableWord = ((Element)paramString.getElementsByTagName("wording").item(0)).getElementsByTagName("link_message").item(0).getFirstChild().getNodeValue();
            }
            localObject = ((Element)paramString.getElementsByTagName("wording").item(0)).getElementsByTagName("url");
            if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
              paramQQOperationViopTipTask.url = ((Element)paramString.getElementsByTagName("wording").item(0)).getElementsByTagName("url").item(0).getFirstChild().getNodeValue();
            }
          }
        }
        return paramQQOperationViopTipTask;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
      catch (SAXException paramString)
      {
        paramString.printStackTrace();
      }
      catch (ParserConfigurationException paramString)
      {
        paramString.printStackTrace();
      }
      return null;
      label1339:
      int i = 3000;
    }
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append('-');
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public static String a(SharedPreferences paramSharedPreferences, String paramString, boolean paramBoolean)
  {
    paramSharedPreferences = paramSharedPreferences.getString("data_migration_tim_uins", "");
    if (TextUtils.isEmpty(paramSharedPreferences))
    {
      if (paramBoolean) {
        paramSharedPreferences = paramString;
      }
      return paramSharedPreferences;
    }
    int j = 0;
    int i = 0;
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramSharedPreferences);
      ((StringBuilder)localObject).append(";");
      ((StringBuilder)localObject).append(paramString);
      return ((StringBuilder)localObject).toString();
    }
    paramSharedPreferences = paramSharedPreferences.split(";");
    Object localObject = new StringBuilder();
    int k = paramSharedPreferences.length;
    i = j;
    while (i < k)
    {
      String str = paramSharedPreferences[i];
      if (!str.equals(paramString))
      {
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(";");
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
      paramConfig = new StringBuilder();
      paramConfig.append("extractConfigContent| config content will be null localVersion is same as config.version(");
      paramConfig.append(paramInt1);
      paramConfig.append("). type=");
      paramConfig.append(paramInt2);
      QLog.e("SPLASH_ConfigServlet", 1, paramConfig.toString());
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
    Object localObject2 = ((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).content.get().toByteArray();
    Object localObject1 = localObject2;
    if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
    {
      localObject2 = ArConfigUtils.a((byte[])localObject2);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramConfig = new StringBuilder();
        paramConfig.append("extractConfigContent| decompress is failed. type=");
        paramConfig.append(paramInt2);
        paramConfig.append(", data=null");
        QLog.e("SPLASH_ConfigServlet", 1, paramConfig.toString());
        return null;
      }
    }
    try
    {
      localObject1 = new String((byte[])localObject1, "utf-8");
      paramConfig = String.format(Locale.getDefault(), "extractConfigContent| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramConfig);
        ((StringBuilder)localObject2).append("content=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
        return localObject1;
      }
      QLog.i("SPLASH_ConfigServlet", 1, paramConfig);
      return localObject1;
    }
    catch (UnsupportedEncodingException paramConfig)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("extractConfigContent| data[] to String failed. type=");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.e("SPLASH_ConfigServlet", 1, ((StringBuilder)localObject1).toString(), paramConfig);
    }
    return null;
  }
  
  /* Error */
  private String a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 1004	java/io/BufferedReader
    //   3: dup
    //   4: new 1006	java/io/InputStreamReader
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 1009	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 1012	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_3
    //   16: new 77	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   23: astore_2
    //   24: aload_3
    //   25: invokevirtual 1015	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +13 -> 45
    //   35: aload_2
    //   36: aload 4
    //   38: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: goto -18 -> 24
    //   45: aload_1
    //   46: invokevirtual 1020	java/io/InputStream:close	()V
    //   49: goto +24 -> 73
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 946	java/io/IOException:printStackTrace	()V
    //   57: goto +16 -> 73
    //   60: astore_2
    //   61: goto +17 -> 78
    //   64: astore_3
    //   65: aload_3
    //   66: invokevirtual 946	java/io/IOException:printStackTrace	()V
    //   69: aload_1
    //   70: invokevirtual 1020	java/io/InputStream:close	()V
    //   73: aload_2
    //   74: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: areturn
    //   78: aload_1
    //   79: invokevirtual 1020	java/io/InputStream:close	()V
    //   82: goto +8 -> 90
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 946	java/io/IOException:printStackTrace	()V
    //   90: goto +5 -> 95
    //   93: aload_2
    //   94: athrow
    //   95: goto -2 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	ConfigServlet
    //   0	98	1	paramInputStream	java.io.InputStream
    //   23	13	2	localStringBuilder	StringBuilder
    //   60	34	2	localObject	Object
    //   15	10	3	localBufferedReader	java.io.BufferedReader
    //   64	2	3	localIOException	IOException
    //   28	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   45	49	52	java/io/IOException
    //   69	73	52	java/io/IOException
    //   24	30	60	finally
    //   35	42	60	finally
    //   65	69	60	finally
    //   24	30	64	java/io/IOException
    //   35	42	64	java/io/IOException
    //   78	82	85	java/io/IOException
  }
  
  public static List<String> a(ConfigurationService.Config paramConfig)
  {
    Object localObject1;
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      localObject1 = new ArrayList();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseCommonConfig: list.size() ");
        ((StringBuilder)localObject2).append(paramConfig.msg_content_list.size());
        QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = paramConfig.msg_content_list.get().iterator();
      for (;;)
      {
        paramConfig = (ConfigurationService.Config)localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramConfig = (ConfigurationService.Content)((Iterator)localObject2).next();
        if ((paramConfig != null) && (paramConfig.content.has()))
        {
          StringBuilder localStringBuilder;
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = a(paramConfig.content.get().toByteArray());
            if (paramConfig != null) {
              try
              {
                paramConfig = new String(paramConfig, "UTF-8");
              }
              catch (Exception paramConfig)
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("parseCommonConfig|uncompress failed");
                localStringBuilder.append(paramConfig);
                QLog.e("SPLASH_ConfigServlet", 1, localStringBuilder.toString());
              }
            } else {
              paramConfig = null;
            }
          }
          else
          {
            paramConfig = paramConfig.content.get().toStringUtf8();
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("parseCommonConfig: contentitem.content =  ");
            localStringBuilder.append(paramConfig);
            QLog.i("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
          }
          if (!TextUtils.isEmpty(paramConfig)) {
            ((List)localObject1).add(paramConfig);
          }
        }
        else
        {
          QLog.i("SPLASH_ConfigServlet", 1, "empty contentitem");
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseCommonConfig:msg_content_list is empty ,version: ");
      ((StringBuilder)localObject1).append(paramConfig.version.get());
      QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
    }
    paramConfig = null;
    return paramConfig;
  }
  
  public static List<String> a(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramConfig.version.get() == paramInt1)
    {
      paramConfig = new StringBuilder();
      paramConfig.append("extractConfigContentList| config content is null. type=");
      paramConfig.append(paramInt2);
      QLog.e("SPLASH_ConfigServlet", 1, paramConfig.toString());
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
    while (paramInt1 < i)
    {
      Object localObject2 = ((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).content.get().toByteArray();
      Object localObject1 = localObject2;
      if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
      {
        localObject2 = ArConfigUtils.a((byte[])localObject2);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramInt1);
          ((StringBuilder)localObject1).append(": extractConfigContentList| decompress is failed. type=");
          ((StringBuilder)localObject1).append(paramInt2);
          ((StringBuilder)localObject1).append(", data=null");
          QLog.e("SPLASH_ConfigServlet", 1, ((StringBuilder)localObject1).toString());
          break label436;
        }
      }
      try
      {
        localObject1 = new String((byte[])localObject1, "utf-8");
        localArrayList.add(localObject1);
        localObject2 = String.format(Locale.getDefault(), "%d: extractConfigContent| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("content=");
          localStringBuilder.append((String)localObject1);
          QLog.i("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
        }
        else
        {
          QLog.i("SPLASH_ConfigServlet", 1, (String)localObject2);
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append(": extractConfigContentList| data[] to String failed. type=");
        ((StringBuilder)localObject2).append(paramInt2);
        QLog.e("SPLASH_ConfigServlet", 1, ((StringBuilder)localObject2).toString(), localUnsupportedEncodingException);
      }
      label436:
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  /* Error */
  private void a(int paramInt, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: getstatic 1069	com/tencent/mobileqq/kandian/biz/common/constant/ReadInJoyDataProviderConstants:a	Landroid/net/Uri;
    //   3: invokevirtual 1075	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc_w 1077
    //   13: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokevirtual 1083	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   19: pop
    //   20: aload 5
    //   22: invokevirtual 1087	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   25: astore 8
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 7
    //   33: aload 7
    //   35: astore 5
    //   37: new 1089	android/content/ContentValues
    //   40: dup
    //   41: invokespecial 1090	android/content/ContentValues:<init>	()V
    //   44: astore 9
    //   46: aload 7
    //   48: astore 5
    //   50: aload 9
    //   52: ldc_w 1092
    //   55: iload_1
    //   56: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: invokevirtual 1096	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   62: aload 7
    //   64: astore 5
    //   66: aload 9
    //   68: ldc_w 1098
    //   71: aload_2
    //   72: invokevirtual 1101	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload 7
    //   77: astore 5
    //   79: aload 9
    //   81: ldc_w 1103
    //   84: aload_3
    //   85: invokevirtual 1101	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 7
    //   90: astore 5
    //   92: ldc_w 1105
    //   95: iconst_2
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: ldc_w 1098
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: aload_2
    //   108: aastore
    //   109: invokestatic 549	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   112: astore_2
    //   113: aload 7
    //   115: astore 5
    //   117: aload 4
    //   119: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   122: invokevirtual 1109	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   125: aload 8
    //   127: aconst_null
    //   128: aload_2
    //   129: aconst_null
    //   130: aconst_null
    //   131: invokevirtual 1115	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   134: astore_2
    //   135: aload_2
    //   136: ifnull +82 -> 218
    //   139: aload_2
    //   140: invokeinterface 1120 1 0
    //   145: ifle +39 -> 184
    //   148: aload 4
    //   150: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   153: invokevirtual 1109	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   156: aload 8
    //   158: aload 9
    //   160: aconst_null
    //   161: aconst_null
    //   162: invokevirtual 1124	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   165: pop
    //   166: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +64 -> 233
    //   172: ldc 91
    //   174: iconst_2
    //   175: ldc_w 1126
    //   178: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: goto +52 -> 233
    //   184: aload 4
    //   186: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   189: invokevirtual 1109	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   192: aload 8
    //   194: aload 9
    //   196: invokevirtual 1130	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   199: pop
    //   200: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +30 -> 233
    //   206: ldc 91
    //   208: iconst_2
    //   209: ldc_w 1132
    //   212: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: goto +18 -> 233
    //   218: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +12 -> 233
    //   224: ldc 91
    //   226: iconst_2
    //   227: ldc_w 1134
    //   230: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload 4
    //   235: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   238: invokevirtual 1109	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   241: aload 8
    //   243: aconst_null
    //   244: invokevirtual 1138	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   247: aload_2
    //   248: ifnull +102 -> 350
    //   251: aload_2
    //   252: invokeinterface 1139 1 0
    //   257: return
    //   258: astore 4
    //   260: aload_2
    //   261: astore_3
    //   262: aload 4
    //   264: astore_2
    //   265: goto +86 -> 351
    //   268: astore_3
    //   269: goto +14 -> 283
    //   272: astore_2
    //   273: aload 5
    //   275: astore_3
    //   276: goto +75 -> 351
    //   279: astore_3
    //   280: aload 6
    //   282: astore_2
    //   283: aload_2
    //   284: astore 5
    //   286: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +51 -> 340
    //   292: aload_2
    //   293: astore 5
    //   295: new 77	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   302: astore 4
    //   304: aload_2
    //   305: astore 5
    //   307: aload 4
    //   309: ldc_w 1141
    //   312: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_2
    //   317: astore 5
    //   319: aload 4
    //   321: aload_3
    //   322: invokevirtual 889	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_2
    //   327: astore 5
    //   329: ldc 91
    //   331: iconst_2
    //   332: aload 4
    //   334: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload_2
    //   341: ifnull +9 -> 350
    //   344: aload_2
    //   345: invokeinterface 1139 1 0
    //   350: return
    //   351: aload_3
    //   352: ifnull +9 -> 361
    //   355: aload_3
    //   356: invokeinterface 1139 1 0
    //   361: aload_2
    //   362: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	ConfigServlet
    //   0	363	1	paramInt	int
    //   0	363	2	paramString1	String
    //   0	363	3	paramString2	String
    //   0	363	4	paramQQAppInterface	QQAppInterface
    //   6	322	5	localObject1	Object
    //   28	253	6	localObject2	Object
    //   31	83	7	localObject3	Object
    //   25	217	8	localUri	android.net.Uri
    //   44	151	9	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   139	181	258	finally
    //   184	215	258	finally
    //   218	233	258	finally
    //   233	247	258	finally
    //   139	181	268	java/lang/Exception
    //   184	215	268	java/lang/Exception
    //   218	233	268	java/lang/Exception
    //   233	247	268	java/lang/Exception
    //   37	46	272	finally
    //   50	62	272	finally
    //   66	75	272	finally
    //   79	88	272	finally
    //   92	113	272	finally
    //   117	135	272	finally
    //   286	292	272	finally
    //   295	304	272	finally
    //   307	316	272	finally
    //   319	326	272	finally
    //   329	340	272	finally
    //   37	46	279	java/lang/Exception
    //   50	62	279	java/lang/Exception
    //   66	75	279	java/lang/Exception
    //   79	88	279	java/lang/Exception
    //   92	113	279	java/lang/Exception
    //   117	135	279	java/lang/Exception
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
    boolean bool;
    if ((!paramQQAppInterface.isLogin()) && (paramInt == 215)) {
      bool = true;
    } else {
      bool = false;
    }
    QConfigManager.a(new int[] { paramInt }, paramString, bool);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.ReqGetConfig paramReqGetConfig, int[] paramArrayOfInt, List<ConfigurationService.ConfigSeq> paramList, List<Integer> paramList1)
  {
    Object localObject = paramList1;
    int k = paramArrayOfInt.length;
    Integer localInteger = Integer.valueOf(0);
    int i = 0;
    ConfigurationService.ReqGetConfig localReqGetConfig = paramReqGetConfig;
    for (paramReqGetConfig = (ConfigurationService.ReqGetConfig)localObject; i < k; paramReqGetConfig = paramList1)
    {
      ConfigurationService.ConfigSeq localConfigSeq = new ConfigurationService.ConfigSeq();
      int m = paramArrayOfInt[i];
      localConfigSeq.type.set(m);
      if (m != 1)
      {
        if (m != 2)
        {
          int j;
          int n;
          if (m != 3)
          {
            if (m != 5)
            {
              if (m != 6)
              {
                paramReqGetConfig = "";
                String str;
                if (m != 12)
                {
                  if (m != 13)
                  {
                    if (m != 46)
                    {
                      if (m != 47)
                      {
                        if (m != 93)
                        {
                          if (m != 94)
                          {
                            switch (m)
                            {
                            default: 
                              switch (m)
                              {
                              default: 
                                switch (m)
                                {
                                default: 
                                  switch (m)
                                  {
                                  default: 
                                    switch (m)
                                    {
                                    default: 
                                      try
                                      {
                                        paramQQAppInterface.getConfigProcess().a(localConfigSeq, paramQQAppInterface, m);
                                      }
                                      catch (Exception paramReqGetConfig)
                                      {
                                        localObject = new StringBuilder();
                                        ((StringBuilder)localObject).append("exception ");
                                        ((StringBuilder)localObject).append(m);
                                        QLog.d("QConfigManager", 1, ((StringBuilder)localObject).toString(), paramReqGetConfig);
                                      }
                                    case 80: 
                                      localConfigSeq.version.set(SharedPreUtils.o(paramQQAppInterface.getApp()));
                                      break;
                                    case 79: 
                                      localConfigSeq.version.set(SharedPreUtils.J(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                      break;
                                    case 78: 
                                      localConfigSeq.version.set(SharedPreUtils.r(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                    }
                                    break;
                                  case 75: 
                                    j = SharedPreUtils.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                    if (SharedPreUtils.w(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                      j = 0;
                                    }
                                    localConfigSeq.version.set(j);
                                    break;
                                  case 74: 
                                    localConfigSeq.version.set(((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b());
                                    break;
                                  case 73: 
                                    localConfigSeq.version.set(SharedPreUtils.x(paramQQAppInterface.getApp()));
                                    break;
                                  case 72: 
                                    localConfigSeq.version.set(SharedPreUtils.I(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin()));
                                  }
                                  break;
                                case 57: 
                                  localConfigSeq.version.set(SharedPreUtils.w(paramQQAppInterface.getApp()));
                                  break;
                                case 56: 
                                  localConfigSeq.version.set(SharedPreUtils.E(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  break;
                                case 55: 
                                  localConfigSeq.version.set(SharedPreUtils.j(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                }
                                break;
                              case 44: 
                                localConfigSeq.version.set(SharedPreUtils.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                break;
                              case 43: 
                                localConfigSeq.version.set(SharedPreUtils.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                break;
                              case 42: 
                                localConfigSeq.version.set(SharedPreUtils.D(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                long l = paramIntent.getLongExtra("k_adcode", 0L);
                                str = paramIntent.getStringExtra("key_province");
                                localObject = str;
                                if (str == null) {
                                  localObject = "";
                                }
                                str = paramIntent.getStringExtra("key_city");
                                if (str != null) {
                                  paramReqGetConfig = str;
                                }
                                localReqGetConfig.province.set((String)localObject);
                                localReqGetConfig.city.set(paramReqGetConfig);
                                localReqGetConfig.adcode.set(l);
                              }
                              break;
                            case 718: 
                              j = ShortVideoResourceManager.a();
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append("SHORT_VIDEO_RESOURCE_CONFIG  ,versionRes:");
                                paramReqGetConfig.append(j);
                                QLog.i("ShortVideoResourceManager", 2, paramReqGetConfig.toString());
                              }
                              ShortVideoResourceManager.a();
                              break;
                            case 705: 
                              localConfigSeq.version.set(SharedPreUtils.c("local_qr_login_version"));
                              break;
                            case 604: 
                              localConfigSeq.version.set(SharedPreUtils.Y(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 596: 
                              localConfigSeq.version.set(((Integer)SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_version_code", localInteger)).intValue());
                              break;
                            case 410: 
                              j = ((IStickerRecManager)paramQQAppInterface.getRuntimeService(IStickerRecManager.class)).getUserConfigVersion(paramQQAppInterface);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 404: 
                              j = SharedPreUtils.aN(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              break;
                            case 403: 
                              j = SharedPreUtils.aM(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              break;
                            case 400: 
                              j = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getUserConfigVersion().intValue();
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 397: 
                              j = ZhuoXusManager.a().a.a();
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 394: 
                              j = JumpForwardPkgManager.a();
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append("JUMP_PKG_TOAST_CONFIG  ,version:");
                                paramReqGetConfig.append(j);
                                QLog.i("JumpForwardPkgManager", 2, paramReqGetConfig.toString());
                              }
                              break;
                            case 392: 
                              j = SharedPreUtils.aJ(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              if (SharedPreUtils.aK(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                j = 0;
                              }
                              localConfigSeq.version.set(j);
                              break;
                            case 387: 
                              localConfigSeq.version.set(SharedPreUtils.at(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                              break;
                            case 385: 
                              paramReqGetConfig = (NotificationController)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER);
                              j = paramReqGetConfig.b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              n = paramReqGetConfig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              int i1 = AppSetting.a();
                              if (n != i1) {
                                j = 0;
                              }
                              QLog.i("NCtr", 1, String.format("request NOTIFICATION_LIMIT_CONFIG localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1) }));
                              localConfigSeq.version.set(j);
                              break;
                            case 384: 
                              j = PreferenceUtils.c(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              break;
                            case 371: 
                              localConfigSeq.version.set(SharedPreUtils.ae(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                              break;
                            case 349: 
                              paramReqGetConfig = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                              localConfigSeq.version.set(paramReqGetConfig.a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                              break;
                            case 347: 
                              j = ((IQIMBeautyManager)QRoute.api(IQIMBeautyManager.class)).getBeautyConfigVersion(paramQQAppInterface.getApp());
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 345: 
                              j = SharedPreUtils.a(paramQQAppInterface.getApp(), "wifi_connect_config_version", jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              break;
                            case 337: 
                              j = SharedPreUtils.aC(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              if (SharedPreUtils.aD(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                j = 0;
                              }
                              localConfigSeq.version.set(j);
                              break;
                            case 336: 
                              localConfigSeq.version.set(SharedPreUtils.O(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                              localConfigSeq.compress.set(1);
                              break;
                            case 331: 
                              localConfigSeq.version.set(SharedPreUtils.a());
                              localConfigSeq.compress.set(1);
                              break;
                            case 328: 
                              j = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 321: 
                              localConfigSeq.version.set(SharedPreUtils.am(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 320: 
                              paramReqGetConfig = (QQStoryManager)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
                              localConfigSeq.version.set(paramReqGetConfig.a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                              break;
                            case 313: 
                              localConfigSeq.version.set(SharedPreUtils.ay(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 301: 
                              j = paramQQAppInterface.getPreferences().getInt("qzone_xp_config_version", 0);
                              localConfigSeq.version.set(j);
                              break;
                            case 297: 
                              j = SharedPreUtils.aA(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              if (SharedPreUtils.aB(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                j = 0;
                              }
                              localConfigSeq.version.set(j);
                              break;
                            case 296: 
                              paramQQAppInterface.getConfigProcess().a(localConfigSeq, paramQQAppInterface, m);
                              paramReqGetConfig = (IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
                              try
                              {
                                paramReqGetConfig.a();
                              }
                              catch (Exception paramReqGetConfig)
                              {
                                QLog.e("SPLASH_ConfigServlet", 1, "get local extend friend exception:", paramReqGetConfig);
                              }
                            case 295: 
                              j = paramQQAppInterface.getPreferences().getInt("key_game_troop_bind_config_version", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 289: 
                              paramReqGetConfig = paramQQAppInterface.getPreferences();
                              localObject = new StringBuilder();
                              ((StringBuilder)localObject).append("buluo_enter_config_version");
                              ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentUin());
                              j = paramReqGetConfig.getInt(((StringBuilder)localObject).toString(), 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 286: 
                              localConfigSeq.version.set(SharedPreUtils.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 284: 
                              j = paramQQAppInterface.getPreferences().getInt("task_entry_config_version", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 283: 
                              localConfigSeq.version.set(0);
                              localConfigSeq.compress.set(1);
                              break;
                            case 281: 
                              j = SharedPreUtils.a(paramQQAppInterface.getApplication(), "troop_gift_anim_limit", "0");
                              localConfigSeq.version.set(j);
                              break;
                            case 280: 
                              j = RecentDanceConfigMgr.a();
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 274: 
                              j = paramQQAppInterface.getPreferences().getInt("homework_troop_config_version", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 273: 
                              j = GiftConfigManager.a(jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 272: 
                              j = SharedPreUtils.u(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              n = AppSetting.a();
                              if (j != n)
                              {
                                SharedPreUtils.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
                                SharedPreUtils.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, n);
                              }
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append("[VideoCompress]onsend : appIdRecord = ");
                                paramReqGetConfig.append(j);
                                paramReqGetConfig.append(", appId = ");
                                paramReqGetConfig.append(n);
                                paramReqGetConfig.append(", VIDEO_REDBAG_CONFI version = ");
                                paramReqGetConfig.append(SharedPreUtils.aj(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                QLog.d("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                              }
                              localConfigSeq.version.set(SharedPreUtils.v(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                              break;
                            case 269: 
                              j = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              break;
                            case 268: 
                              j = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              break;
                            case 262: 
                              j = paramQQAppInterface.getPreferences().getInt("data_migration_tim_version", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 260: 
                              try
                              {
                                if (((Integer)SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1)).intValue() != AppSetting.a())
                                {
                                  SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, Integer.valueOf(AppSetting.a()));
                                  SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, localInteger);
                                  localConfigSeq.version.set(0);
                                }
                                else
                                {
                                  j = ((Integer)SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
                                  localConfigSeq.version.set(j);
                                }
                              }
                              catch (Throwable paramReqGetConfig)
                              {
                                paramReqGetConfig.printStackTrace();
                                if (!QLog.isColorLevel()) {
                                  break label5951;
                                }
                              }
                              QLog.i("SPLASH_ConfigServlet", 2, "PUSH_RECOMMEND_SHIELD_CONFIG", paramReqGetConfig);
                              break;
                            case 259: 
                              j = QmcfDevicesStrategy.a(paramQQAppInterface.getApp());
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 257: 
                              if (SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1) != AppSetting.a())
                              {
                                SharedPreUtils.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 1, AppSetting.a());
                                SharedPreUtils.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, 0);
                                localConfigSeq.version.set(0);
                              }
                              else
                              {
                                localConfigSeq.version.set(SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2));
                              }
                              break;
                            case 256: 
                              j = SharedPreUtils.aq(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              if (SharedPreUtils.ar(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                j = 0;
                              }
                              localConfigSeq.version.set(j);
                              break;
                            case 254: 
                              j = paramQQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 253: 
                              j = paramQQAppInterface.getPreferences().getInt("troop_link_config_version", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 247: 
                              j = SharedPreUtils.s(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              n = AppSetting.a();
                              if (j != n)
                              {
                                SharedPreUtils.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
                                SharedPreUtils.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, n);
                              }
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append("[GreenVideo]onsend : appIdRecord = ");
                                paramReqGetConfig.append(j);
                                paramReqGetConfig.append(", appId = ");
                                paramReqGetConfig.append(n);
                                paramReqGetConfig.append(", GREEN_VIDEO_CONFI version = ");
                                paramReqGetConfig.append(SharedPreUtils.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                QLog.d("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                              }
                              localConfigSeq.version.set(SharedPreUtils.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                              break;
                            case 245: 
                              j = paramQQAppInterface.getPreferences().getInt("tim_pc_banner", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 244: 
                              localConfigSeq.version.set(paramQQAppInterface.getPreferences().getInt("call_tim_config_version", 0));
                              break;
                            case 238: 
                              j = paramQQAppInterface.getPreferences().getInt("tim_upgrade_hongdian_version", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 234: 
                              j = paramQQAppInterface.getPreferences().getInt("tim_login_jump", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 232: 
                              SearchConfigServlet.a(localConfigSeq);
                              break;
                            case 228: 
                              j = SharedPreUtils.ao(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              if (SharedPreUtils.ap(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.a()) {
                                j = 0;
                              }
                              localConfigSeq.version.set(j);
                              break;
                            case 227: 
                              j = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              break;
                            case 226: 
                              if (!CapturePtvTemplateManager.a()) {
                                localConfigSeq.version.set(0);
                              } else {
                                localConfigSeq.version.set(SharedPreUtils.i(paramQQAppInterface.getApp()));
                              }
                              localConfigSeq.compress.set(1);
                              break;
                            case 225: 
                              localConfigSeq.version.set(((ICaptureVideoFilterManager)QRoute.api(ICaptureVideoFilterManager.class)).getQQShortVideoFilterConfigVersion(paramQQAppInterface.getApp()));
                              localConfigSeq.compress.set(1);
                              break;
                            case 223: 
                            case 364: 
                            case 365: 
                              BusinessCommonConfig.getInstance(paramQQAppInterface).fillConfigVersion(m, localConfigSeq);
                              break;
                            case 222: 
                              j = paramQQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 215: 
                              j = AEOldShortVideoResManager.a();
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append("SHORT_VIDEO_RESOURCE_CONFIG  ,versionRes:");
                                paramReqGetConfig.append(j);
                                QLog.i("AEOldShortVideoResManager", 2, paramReqGetConfig.toString());
                              }
                              AEOldShortVideoResManager.a();
                              break;
                            case 212: 
                              j = SharedPreUtils.an(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append("ConfigServlet receipt ,receiptVersion:");
                                paramReqGetConfig.append(j);
                                QLog.i("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                              }
                              break;
                            case 211: 
                              SearchConfigServlet.a(paramQQAppInterface, localConfigSeq);
                              break;
                            case 210: 
                              j = ((IOCRService)paramQQAppInterface.getRuntimeService(IOCRService.class, "")).getConfigVersion();
                              localConfigSeq.version.set(j);
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append("ConfigServlet OCR_CONFIG ocrVersion:");
                                paramReqGetConfig.append(j);
                                QLog.i("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                              }
                              break;
                            case 205: 
                              j = FaceScanDownloadManager.a(paramQQAppInterface);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              paramIntent.putExtra("key_download_cfg_version", j);
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append(" get AR_SCAN_FACE_PRE_DOWN_CONFIG, version = ");
                                paramReqGetConfig.append(j);
                                QLog.d("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                              }
                              break;
                            case 204: 
                              j = paramQQAppInterface.getPreferences().getInt("zhitu_config_version", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 202: 
                              a(localReqGetConfig, localConfigSeq, paramQQAppInterface);
                              break;
                            case 201: 
                              j = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              break;
                            case 195: 
                              j = SharedPreUtils.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              break;
                            case 194: 
                              localConfigSeq.version.set(SharedPreUtils.Z(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                              break;
                            case 193: 
                              j = SharedPreUtils.G(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append("ConfigServlet req :193, version: ");
                                paramReqGetConfig.append(j);
                                QLog.d("UpgradeTIMWrapper", 2, paramReqGetConfig.toString());
                              }
                              break;
                            case 191: 
                              localConfigSeq.version.set(SharedPreUtils.al(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 188: 
                              paramReqGetConfig = (ARGlobalConfigManager)paramQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
                              if (paramReqGetConfig != null)
                              {
                                j = paramReqGetConfig.b();
                                if (QLog.isColorLevel())
                                {
                                  localObject = new StringBuilder();
                                  ((StringBuilder)localObject).append(" local version = ");
                                  ((StringBuilder)localObject).append(j);
                                  QLog.d("handleResp_GetArGlobalConfig", 2, ((StringBuilder)localObject).toString());
                                }
                                if (paramReqGetConfig.a())
                                {
                                  localConfigSeq.version.set(j);
                                }
                                else
                                {
                                  localConfigSeq.version.set(0);
                                  j = 0;
                                }
                                localConfigSeq.compress.set(1);
                                paramIntent.putExtra("ar_global_key_config_version", j);
                              }
                              break;
                            case 187: 
                              localConfigSeq.version.set(PhotoListConfigManager.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                              break;
                            case 185: 
                              localConfigSeq.version.set(SharedPreUtils.z(paramQQAppInterface.getApp()));
                              break;
                            case 184: 
                              localConfigSeq.version.set(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountQQMailConfigVersionCode(paramQQAppInterface));
                              break;
                            case 182: 
                              localConfigSeq.version.set(((ISttManagerApi)QRoute.api(ISttManagerApi.class)).getConfigVersion(paramQQAppInterface));
                              localConfigSeq.compress.set(1);
                              break;
                            case 181: 
                              j = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getDoutuConfigAppId(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              n = AppSetting.a();
                              if (j != n)
                              {
                                ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuConfigVersion(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
                                ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuConfigAppId(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, n);
                              }
                              else
                              {
                                paramReqGetConfig = (IDoutuService)paramQQAppInterface.getRuntimeService(IDoutuService.class, "");
                                if (paramReqGetConfig != null)
                                {
                                  paramReqGetConfig.setApp(paramQQAppInterface);
                                  paramReqGetConfig.doOnLogin(false);
                                }
                              }
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append("[Doutu]onsend : appIdRecord = ");
                                paramReqGetConfig.append(j);
                                paramReqGetConfig.append(", appId = ");
                                paramReqGetConfig.append(n);
                                paramReqGetConfig.append(", DOUTU_CONFI version = ");
                                paramReqGetConfig.append(SharedPreUtils.ag(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                QLog.d("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                              }
                              localConfigSeq.version.set(SharedPreUtils.ag(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                              break;
                            case 177: 
                              localConfigSeq.version.set(SharedPreUtils.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                              break;
                            case 174: 
                              if (((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(jdField_a_of_type_JavaLangString, "key_app_id", localInteger)).intValue() != AppSetting.a())
                              {
                                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "key_tabs_config_version", localInteger);
                                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "key_app_id", Integer.valueOf(AppSetting.a()));
                              }
                              j = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(jdField_a_of_type_JavaLangString, "key_tabs_config_version", localInteger)).intValue();
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              str = paramIntent.getStringExtra("key_province");
                              localObject = str;
                              if (str == null) {
                                localObject = "";
                              }
                              str = paramIntent.getStringExtra("key_city");
                              if (str != null) {
                                paramReqGetConfig = str;
                              }
                              localReqGetConfig.province.set((String)localObject);
                              localReqGetConfig.city.set(paramReqGetConfig);
                              break;
                            case 171: 
                              localConfigSeq.version.set(SharedPreUtils.X(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                              break;
                            case 167: 
                              if (!PtvTemplateManager.b()) {
                                localConfigSeq.version.set(0);
                              } else {
                                localConfigSeq.version.set(SharedPreUtils.j(paramQQAppInterface.getApp()));
                              }
                              localConfigSeq.compress.set(1);
                              break;
                            case 166: 
                              paramReqGetConfig = (TroopStoryManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_STORY_MANAGER);
                              localConfigSeq.version.set(paramReqGetConfig.a.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 165: 
                              localConfigSeq.version.set(SharedPreUtils.ab(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                              break;
                            case 155: 
                              localConfigSeq.version.set(SharedPreUtils.T(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 153: 
                              localConfigSeq.version.set(SharedPreUtils.V(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 149: 
                            case 180: 
                            case 218: 
                              QAVConfig.a(m, jdField_a_of_type_JavaLangString, localConfigSeq);
                              break;
                            case 148: 
                              localConfigSeq.version.set(SharedPreUtils.g(paramQQAppInterface.getApp()));
                              localConfigSeq.compress.set(1);
                              break;
                            case 147: 
                              localConfigSeq.version.set(SharedPreUtils.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString));
                              break;
                            case 146: 
                              localConfigSeq.version.set(SharedPreUtils.N(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                              localConfigSeq.compress.set(1);
                              break;
                            case 145: 
                              if (!PtvTemplateManager.d()) {
                                localConfigSeq.version.set(0);
                              } else {
                                localConfigSeq.version.set(SharedPreUtils.m(paramQQAppInterface.getApp()));
                              }
                              localConfigSeq.compress.set(1);
                              break;
                            case 143: 
                              j = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 142: 
                              j = SharedPreUtils.a(paramQQAppInterface.getApp(), "troop_common_config_version", jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              break;
                            case 140: 
                              localConfigSeq.version.set(SharedPreUtils.S(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 139: 
                              if (PtvTemplateManager.c()) {
                                j = SharedPreUtils.k(paramQQAppInterface.getApp());
                              } else {
                                j = 0;
                              }
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              if (QLog.isDevelopLevel()) {
                                QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 4, String.format("个性笔触配置版本号[%s]", new Object[] { Integer.valueOf(j) }));
                              }
                              break;
                            case 130: 
                              localConfigSeq.version.set(SharedPreUtils.B(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 129: 
                              j = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              break;
                            case 121: 
                              localConfigSeq.version.set(SharedPreUtils.P(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                            case 157: 
                              localConfigSeq.version.set(SharedPreUtils.Q(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              localConfigSeq.compress.set(1);
                            case 119: 
                            case 118: 
                            case 116: 
                            case 115: 
                            case 111: 
                            case 109: 
                            case 102: 
                            case 101: 
                            case 97: 
                            case 96: 
                            case 90: 
                              for (;;)
                              {
                                break;
                                paramReqGetConfig = (BabyQHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
                                if (paramReqGetConfig != null)
                                {
                                  j = AppSetting.a();
                                  if (j != paramReqGetConfig.b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString))
                                  {
                                    paramReqGetConfig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
                                    paramReqGetConfig.b(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
                                    paramReqGetConfig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, true);
                                    paramReqGetConfig.c();
                                  }
                                  localConfigSeq.version.set(paramReqGetConfig.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  continue;
                                  j = SharedPreUtils.a(paramQQAppInterface.getApp(), "now_entrance_action_version", jdField_a_of_type_JavaLangString);
                                  localConfigSeq.version.set(j);
                                  continue;
                                  j = SharedPreUtils.F(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                                  if (QLog.isColorLevel())
                                  {
                                    paramReqGetConfig = new StringBuilder();
                                    paramReqGetConfig.append("addAllConfigs|GET_CONFIG_UPGRADE version=");
                                    paramReqGetConfig.append(j);
                                    QLog.d("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                                  }
                                  localConfigSeq.version.set(j);
                                  paramQQAppInterface.getPreloadSwitch();
                                  OpenConfig.a(paramQQAppInterface.getApp(), String.valueOf(AppSetting.a()));
                                  ((ConfigHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).c();
                                  continue;
                                  localConfigSeq.version.set(SharedPreUtils.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                                  continue;
                                  localConfigSeq.version.set(SharedPreUtils.p(paramQQAppInterface.getApp()));
                                  continue;
                                  j = CameraUtils.a(BaseApplicationImpl.getContext());
                                  localConfigSeq.version.set(j);
                                  localConfigSeq.compress.set(1);
                                  paramIntent.putExtra("qcamera_conf_version", j);
                                  paramIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
                                  if (QLog.isColorLevel())
                                  {
                                    paramReqGetConfig = new StringBuilder();
                                    paramReqGetConfig.append("request QCAMERA_PHONE_CONFIG version: ");
                                    paramReqGetConfig.append(j);
                                    QLog.i("Q.camera.configServlet", 2, paramReqGetConfig.toString());
                                    continue;
                                    j = ApkUtils.a(BaseApplicationImpl.getContext());
                                    if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < j)
                                    {
                                      localConfigSeq.version.set(0);
                                    }
                                    else
                                    {
                                      localConfigSeq.version.set(SharedPreUtils.l(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                                      continue;
                                      j = ApkUtils.a(BaseApplicationImpl.getContext());
                                      if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, null, "qqsetting_calltab_show_key_version", 0) < j)
                                      {
                                        localConfigSeq.version.set(0);
                                        paramIntent.putExtra("update101Version", j);
                                      }
                                      else
                                      {
                                        localConfigSeq.version.set(SharedPreUtils.k(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                                        continue;
                                        paramReqGetConfig = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
                                        localConfigSeq.version.set(paramReqGetConfig.getsAllEntranceConfigVersion());
                                        continue;
                                        j = SharedPreUtils.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", jdField_a_of_type_JavaLangString);
                                        localConfigSeq.version.set(j);
                                        continue;
                                        localConfigSeq.version.set(SharedPreUtils.H(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                      }
                                    }
                                  }
                                }
                              }
                            case 84: 
                              if (!PtvTemplateManager.a()) {
                                localConfigSeq.version.set(0);
                              } else {
                                localConfigSeq.version.set(SharedPreUtils.h(paramQQAppInterface.getApp()));
                              }
                              break;
                            case 82: 
                              localConfigSeq.version.set(SharedPreUtils.M(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 69: 
                              j = SharedPreUtils.z(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
                              localConfigSeq.version.set(j);
                              break;
                            case 66: 
                              localConfigSeq.version.set(SharedPreUtils.y(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 65: 
                              bool = QFindConfigUtil.a();
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append("addAllConfigs, support ble=");
                                paramReqGetConfig.append(bool);
                                QLog.d("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                              }
                              if (!bool) {
                                break label7413;
                              }
                              localConfigSeq.version.set(SharedPreUtils.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 64: 
                              localConfigSeq.version.set(SharedPreUtils.v(paramQQAppInterface.getApp()));
                              break;
                            case 63: 
                              localConfigSeq.version.set(SharedPreUtils.u(paramQQAppInterface.getApp()));
                              break;
                            case 61: 
                              localConfigSeq.version.set(SharedPreUtils.t(paramQQAppInterface.getApp()));
                              break;
                            case 53: 
                              localConfigSeq.version.set(SharedPreUtils.q(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 49: 
                              localConfigSeq.version.set(SharedPreUtils.s(paramQQAppInterface.getApp()));
                              break;
                            case 38: 
                              localConfigSeq.version.set(SharedPreUtils.m(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                              break;
                            case 34: 
                              paramReqGetConfig = (PhoneUnityManager)paramQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
                              localConfigSeq.version.set(paramReqGetConfig.a());
                              break;
                            case 31: 
                              localConfigSeq.version.set(SharedPreUtils.b(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                              break;
                            case 23: 
                              label5951:
                              localConfigSeq.version.set(SharedPreUtils.f(paramQQAppInterface.getApp()));
                              break;
                            }
                            localConfigSeq.version.set(SharedPreUtils.b(paramQQAppInterface.getApp()));
                            break label7452;
                          }
                          localConfigSeq.version.set(SharedPreUtils.c(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                          break label7452;
                        }
                        localConfigSeq.version.set(SharedPreUtils.n(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                        break label7452;
                      }
                      boolean bool = QFindConfigUtil.a();
                      if (QLog.isColorLevel())
                      {
                        paramReqGetConfig = new StringBuilder();
                        paramReqGetConfig.append("addAllConfigs, support ble=");
                        paramReqGetConfig.append(bool);
                        QLog.d("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                      }
                      if (bool)
                      {
                        localConfigSeq.version.set(SharedPreUtils.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                        break label7452;
                      }
                    }
                    else
                    {
                      localConfigSeq.version.set(PatchSharedPreUtil.getPatchConfigVersion(paramQQAppInterface.getApp()));
                      localConfigSeq.compress.set(1);
                      break label7452;
                    }
                  }
                  else
                  {
                    BridgeHelper.a(BaseApplication.getContext(), jdField_a_of_type_JavaLangString).a();
                    localConfigSeq.version.set(SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                    break label7452;
                  }
                }
                else
                {
                  localObject = (NearbyBannerManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_BANNER_MANAGER);
                  localConfigSeq.version.set(((NearbyBannerManager)localObject).a());
                  str = paramIntent.getStringExtra("key_province");
                  localObject = str;
                  if (str == null) {
                    localObject = "";
                  }
                  str = paramIntent.getStringExtra("key_city");
                  if (str != null) {
                    paramReqGetConfig = str;
                  }
                  localReqGetConfig.province.set((String)localObject);
                  localReqGetConfig.city.set(paramReqGetConfig);
                  break label7452;
                }
              }
              else
              {
                localReqGetConfig = ((IDPCApi)QRoute.api(IDPCApi.class)).buidldReqConfig(paramQQAppInterface);
                break label7475;
              }
            }
            else
            {
              localConfigSeq.version.set(SharedPreUtils.i(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
              break label7452;
            }
          }
          else
          {
            SharedPreUtils.a(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
            if (paramQQAppInterface.getCurrentAccountUin() != null)
            {
              jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentNickname();
              paramReqGetConfig = ProfileCardUtil.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
              if (paramReqGetConfig != null)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("SPLASH_ConfigServlet_birth", 2, "card!=null");
                }
                n = (int)paramReqGetConfig.lBirthday;
                j = ProfileUtil.a(n);
                n = ProfileUtil.b(n);
                SharedPreUtils.b(paramQQAppInterface.getApp(), a(j, n));
                j = a(new SimpleDateFormat("MM-dd").format(new Date()), a(j, n));
                if (QLog.isColorLevel())
                {
                  paramReqGetConfig = new StringBuilder();
                  paramReqGetConfig.append("birthday date diff is ");
                  paramReqGetConfig.append(j);
                  QLog.i("SPLASH_ConfigServlet_birth", 2, paramReqGetConfig.toString());
                }
                if ((j >= 0) && (j <= 3))
                {
                  localConfigSeq.version.set(SharedPreUtils.h(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
                  break label7452;
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.i("SPLASH_ConfigServlet_birth", 2, "card===null");
              }
            }
          }
          label7413:
          break label7475;
        }
        else
        {
          localConfigSeq.version.set(SharedPreUtils.g(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString));
        }
      }
      else {
        localConfigSeq.version.set(SharedPreUtils.d(paramQQAppInterface.getApp()));
      }
      label7452:
      paramList.add(localConfigSeq);
      paramList1.add(Integer.valueOf(m));
      label7475:
      i += 1;
    }
    paramQQAppInterface = new ConfigurationService.DeviceInfo();
    if ((paramReqGetConfig.contains(Integer.valueOf(1))) || (paramReqGetConfig.contains(Integer.valueOf(2))) || (paramReqGetConfig.contains(Integer.valueOf(3))) || (paramReqGetConfig.contains(Integer.valueOf(12))))
    {
      paramIntent = new ConfigurationService.Screen();
      paramIntent.setHasFlag(true);
      paramIntent.width.set((int)DeviceInfoUtil.i());
      paramIntent.height.set((int)DeviceInfoUtil.j());
      paramQQAppInterface.screen = paramIntent;
      paramQQAppInterface.setHasFlag(true);
      localReqGetConfig.device_info = paramQQAppInterface;
    }
    if ((paramReqGetConfig.contains(Integer.valueOf(47))) || (paramReqGetConfig.contains(Integer.valueOf(65))) || (paramReqGetConfig.contains(Integer.valueOf(156))) || (paramReqGetConfig.contains(Integer.valueOf(297))))
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
      if (QLog.isDevelopLevel())
      {
        paramReqGetConfig = new StringBuilder();
        paramReqGetConfig.append("addAllConfigs, brand[");
        paramReqGetConfig.append(paramQQAppInterface.brand.get());
        paramReqGetConfig.append("], model[");
        paramReqGetConfig.append(paramQQAppInterface.model.get());
        paramReqGetConfig.append("]");
        QLog.w("SPLASH_ConfigServlet", 1, paramReqGetConfig.toString());
      }
      paramQQAppInterface.os = paramIntent;
      paramQQAppInterface.setHasFlag(true);
      localReqGetConfig.device_info = paramQQAppInterface;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    int i = paramConfig.version.get();
    int j = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getUserConfigVersion().intValue();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("received  Config remote version:");
      paramQQAppInterface.append(i);
      paramQQAppInterface.append(" localversion= ");
      paramQQAppInterface.append(j);
      QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
    }
    if (i != j)
    {
      paramQQAppInterface = b(paramConfig, j, paramInt);
      if (QLog.isColorLevel())
      {
        paramConfig = new StringBuilder();
        paramConfig.append("config content : ");
        paramConfig.append(paramQQAppInterface);
        QLog.d("SPLASH_ConfigServlet", 2, paramConfig.toString());
      }
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        try
        {
          paramInt = new JSONObject(paramQQAppInterface).optInt("hot_video_enable", 0);
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateSupportMultiVideoSwitch(paramInt);
        }
        catch (Exception paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.getMessage());
          }
        }
      }
      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).setUserConfigVersion(i);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    QConfigManager.a(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramInt != -1) && (SharedPreUtils.s(paramQQAppInterface.getApp()) == paramInt))
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("HOTCHAT_SCENE_CONFIGS_CMD, same version ");
          paramQQAppInterface.append(paramInt);
          QLog.d("Q.nearby", 2, paramQQAppInterface.toString());
        }
        return;
      }
      a(paramQQAppInterface, 49, paramString);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("HOTCHAT_SCENE_CONFIGS_CMD, ");
        paramQQAppInterface.append(paramInt);
        QLog.d("Q.nearby", 2, paramQQAppInterface.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, app is null, or uin is empty");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if ((paramInt != -1) && (PatchSharedPreUtil.getPatchConfigVersion(paramQQAppInterface.getApplication()) == paramInt))
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getPatchConfig same version=");
        paramQQAppInterface.append(paramInt);
        paramQQAppInterface.append(", reason=");
        paramQQAppInterface.append(paramString2);
        QLog.d("PatchLogTag", 1, paramQQAppInterface.toString());
        return;
      }
      a(paramQQAppInterface, 46, paramString1);
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getPatchConfig version=");
      paramQQAppInterface.append(paramInt);
      paramQQAppInterface.append(", reason=");
      paramQQAppInterface.append(paramString2);
      QLog.d("PatchLogTag", 1, paramQQAppInterface.toString());
      return;
    }
    QLog.d("PatchLogTag", 1, "getPatchConfig app is null or uin is empty");
  }
  
  private void a(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.c("local_qr_login_version");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleLocalQRConfig: ,version: ");
    localStringBuilder.append(paramConfig.version.get());
    localStringBuilder.append("| localVersion: ");
    localStringBuilder.append(j);
    QLog.i("SPLASH_ConfigServlet", 1, localStringBuilder.toString());
    if (i == j)
    {
      QLog.e("SPLASH_ConfigServlet", 1, "handleLocalQRConfig version is same of local version");
      return;
    }
    SharedPreUtils.b("local_qr_login_version", Integer.valueOf(i));
    paramConfig = a(paramConfig);
    if ((paramConfig != null) && (!paramConfig.isEmpty())) {
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
        return;
      }
    }
    QLog.e("SPLASH_ConfigServlet", 1, "handleLocalQRConfig configStrList is null or empty");
  }
  
  private void a(ConfigurationService.ReqGetConfig paramReqGetConfig, ConfigurationService.ConfigSeq paramConfigSeq, QQAppInterface paramQQAppInterface)
  {
    for (Object localObject1 = "";; localObject1 = paramConfigSeq)
    {
      try
      {
        int i;
        if (SharedPreUtils.ah(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString) != AppSetting.a())
        {
          SharedPreUtils.E(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, AppSetting.a());
          SharedPreUtils.F(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 0);
          i = 0;
        }
        else
        {
          i = SharedPreUtils.ai(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
        }
        paramConfigSeq.version.set(i);
        ConfigurationService.ConfigSeq localConfigSeq = null;
        try
        {
          paramConfigSeq = DeviceInfoUtil.a();
          localConfigSeq = paramConfigSeq;
        }
        catch (Throwable paramConfigSeq)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onGetCUOpenCardGuideConfig error: ");
          ((StringBuilder)localObject2).append(paramConfigSeq.getMessage());
          QLog.e("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
        }
        if ((localConfigSeq != null) && (localConfigSeq.size() > 0))
        {
          paramConfigSeq = localConfigSeq.iterator();
          while (paramConfigSeq.hasNext())
          {
            localObject2 = (Integer)paramConfigSeq.next();
            paramReqGetConfig.carriers.add(localObject2);
          }
        }
        Object localObject2 = ((IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
        paramConfigSeq = (ConfigurationService.ConfigSeq)localObject1;
        if (localObject2 != null)
        {
          paramQQAppInterface = ((RespondQueryQQBindingStat)localObject2).nationCode;
          paramConfigSeq = paramQQAppInterface;
          if (paramQQAppInterface != null)
          {
            paramConfigSeq = paramQQAppInterface;
            if (paramQQAppInterface.startsWith("+")) {
              paramConfigSeq = paramQQAppInterface.substring(1);
            }
          }
          if ((TextUtils.isEmpty(paramConfigSeq)) && (TextUtils.isEmpty(((RespondQueryQQBindingStat)localObject2).mobileNo)))
          {
            paramConfigSeq = (ConfigurationService.ConfigSeq)localObject1;
          }
          else
          {
            paramQQAppInterface = Locale.getDefault();
            if (paramConfigSeq != null) {
              continue;
            }
            paramConfigSeq = String.format(paramQQAppInterface, "%s-%s", new Object[] { localObject1, ((RespondQueryQQBindingStat)localObject2).mobileNo });
          }
        }
        if (!TextUtils.isEmpty(paramConfigSeq)) {
          paramReqGetConfig.bind_phone_no.set(paramConfigSeq);
        }
        if (QLog.isColorLevel())
        {
          paramReqGetConfig = new StringBuilder(100);
          paramReqGetConfig.append("onGetCUOpenCardGuideConfig reqVersion=");
          paramReqGetConfig.append(i);
          paramReqGetConfig.append(", bindPhoneNum=");
          paramReqGetConfig.append(paramConfigSeq);
          paramReqGetConfig.append(", carrier[");
          if ((localConfigSeq != null) && (localConfigSeq.size() > 0))
          {
            paramConfigSeq = localConfigSeq.iterator();
            while (paramConfigSeq.hasNext())
            {
              paramReqGetConfig.append((Integer)paramConfigSeq.next());
              paramReqGetConfig.append(",");
            }
          }
          paramReqGetConfig.append("]");
          QLog.i("CU_OPEN_CARD_GUIDE", 2, paramReqGetConfig.toString());
          return;
        }
      }
      catch (Exception paramReqGetConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CU_OPEN_CARD_GUIDE", 2, "onGetCUOpenCardGuideConfig", paramReqGetConfig);
        }
      }
      return;
    }
  }
  
  public static boolean a(PicAndAdConf paramPicAndAdConf, String paramString, Set<String> paramSet)
  {
    label869:
    for (;;)
    {
      boolean bool;
      try
      {
        Document localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = localDocument.getElementsByTagName("pushbanner");
        String str1 = "";
        int i = 0;
        Object localObject1 = paramSet;
        if (i < localNodeList.getLength())
        {
          long l1 = Long.parseLong(localDocument.getElementsByTagName("channel").item(i).getFirstChild().getNodeValue());
          String str2 = localDocument.getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
          String str3 = localDocument.getElementsByTagName("digest").item(i).getFirstChild().getNodeValue();
          int k = Integer.parseInt(localDocument.getElementsByTagName("weight").item(i).getFirstChild().getNodeValue());
          Object localObject2 = localDocument.getElementsByTagName("md5").item(i).getFirstChild();
          if (localObject2 != null) {
            str1 = ((Node)localObject2).getNodeValue();
          }
          localObject2 = localDocument.getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
          Object localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          long l2 = ((SimpleDateFormat)localObject3).parse((String)localObject2).getTime();
          long l3 = ((SimpleDateFormat)localObject3).parse(localDocument.getElementsByTagName("begin").item(i).getFirstChild().getNodeValue()).getTime();
          if (System.currentTimeMillis() > l2)
          {
            if (!QLog.isColorLevel()) {
              break label869;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("parseXML | NearbyBanner out of date, cid = ");
            ((StringBuilder)localObject1).append(l1);
            ((StringBuilder)localObject1).append(", endTime = ");
            ((StringBuilder)localObject1).append((String)localObject2);
            QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
            break label869;
          }
          if (str1.length() < 15)
          {
            if (!QLog.isColorLevel()) {
              break label869;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("parseXML | NearbyBanner md5 length < 15, cid = ");
            ((StringBuilder)localObject1).append(l1);
            QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
            break label869;
          }
          if (localObject1 != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(l1);
            ((StringBuilder)localObject2).append(str1);
            if (((Set)localObject1).contains(((StringBuilder)localObject2).toString()))
            {
              if (!QLog.isColorLevel()) {
                break label869;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("parseXML | NearbyBanner ");
              ((StringBuilder)localObject1).append(l1);
              ((StringBuilder)localObject1).append(" had been closed, throw it");
              QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
              break label869;
            }
          }
          localObject1 = new StringBuffer();
          int j = 0;
          if (j < localDocument.getElementsByTagName("url").item(i).getChildNodes().getLength())
          {
            ((StringBuffer)localObject1).append(localDocument.getElementsByTagName("url").item(i).getChildNodes().item(j).getNodeValue());
            j += 1;
            continue;
          }
          localObject1 = ((StringBuffer)localObject1).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
          ((StringBuilder)localObject2).append("/");
          ((StringBuilder)localObject2).append("NearbyBannerPic");
          ((StringBuilder)localObject2).append("/");
          ((StringBuilder)localObject2).append(str1);
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(l3);
          ((StringBuilder)localObject3).append("|");
          ((StringBuilder)localObject3).append(l2);
          paramPicAndAdConf.a(paramPicAndAdConf.a(l1, str3, (byte)3, str2, (String)localObject1, (String)localObject2, ((StringBuilder)localObject3).toString(), (short)k, str1));
          ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "has_new_banner", Boolean.valueOf(true));
          i += 1;
          continue;
        }
        bool = true;
      }
      catch (Exception paramPicAndAdConf)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner parse exception,", paramPicAndAdConf);
        }
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        paramPicAndAdConf = new StringBuilder();
        paramPicAndAdConf.append("parseNearbyBannerXml,result = ");
        paramPicAndAdConf.append(bool);
        paramPicAndAdConf.append(",bannerContent =");
        paramPicAndAdConf.append(paramString);
        QLog.d("SPLASH_ConfigServlet", 2, paramPicAndAdConf.toString());
      }
      return bool;
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
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  private void aA(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleRespClassicHeadConfig|type= ");
      ((StringBuilder)localObject1).append(paramConfig.type.get());
      QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
    }
    int j = paramConfig.version.get();
    if (j == SharedPreUtils.Q(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "ClassicHeadConfig serverVersion is equals to localVersion ");
      }
      return;
    }
    int i;
    Object localObject2;
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ClassicHeadConfig size:");
        ((StringBuilder)localObject1).append(paramConfig.msg_content_list.size());
        ((StringBuilder)localObject1).append("ClassicHeadConfig content:");
        ((StringBuilder)localObject1).append(paramConfig.msg_content_list.get(0));
        QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        i = paramConfig.compress.get();
        localObject1 = null;
        if (i == 1)
        {
          paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
          if (paramConfig != null)
          {
            try
            {
              paramConfig = new String(paramConfig, "UTF-8");
            }
            catch (Throwable paramConfig)
            {
              if (!QLog.isColorLevel()) {
                break label306;
              }
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Throwable:");
            ((StringBuilder)localObject2).append(paramConfig.getMessage());
            QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "inflateConfigString error!");
          }
          label306:
          paramConfig = null;
        }
        else
        {
          paramConfig = paramConfig.content.get().toStringUtf8();
        }
        if (paramConfig != null)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("ClassicHead xmlContent = ");
            ((StringBuilder)localObject2).append(paramConfig);
            QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = Xml.newPullParser();
          try
          {
            ((XmlPullParser)localObject2).setInput(new ByteArrayInputStream(paramConfig.getBytes()), "utf-8");
            i = ((XmlPullParser)localObject2).getEventType();
            paramConfig = (ConfigurationService.Config)localObject1;
          }
          catch (Exception paramQQAppInterface)
          {
            String str;
            if (!QLog.isColorLevel()) {
              break label646;
            }
            QLog.e("SPLASH_ConfigServlet", 2, "ClassicHeadConfig appear exception:", paramQQAppInterface);
          }
          str = ((XmlPullParser)localObject2).getName();
          if ((str != null) && (str.equalsIgnoreCase("beginTime")))
          {
            paramConfig = ((XmlPullParser)localObject2).nextText();
            break label670;
          }
          localObject1 = paramConfig;
          if (str != null)
          {
            localObject1 = paramConfig;
            if (str.equalsIgnoreCase("endTime"))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramConfig);
              ((StringBuilder)localObject1).append("|");
              ((StringBuilder)localObject1).append(((XmlPullParser)localObject2).nextText());
              paramConfig = ((StringBuilder)localObject1).toString();
              break label670;
            }
          }
        }
      }
    }
    for (;;)
    {
      i = ((XmlPullParser)localObject2).next();
      paramConfig = (ConfigurationService.Config)localObject1;
      label646:
      while (i == 1)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("ClassicHead entrence:");
          ((StringBuilder)localObject1).append(paramConfig);
          QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
        }
        if ((paramConfig != null) && (paramConfig.length() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead getContent success");
          }
          SharedPreUtils.d(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), paramConfig);
          paramQQAppInterface = (ClassicHeadActivityManager)paramQQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface.a();
            return;
          }
        }
        return;
      }
      localObject1 = paramConfig;
      if (i != 0)
      {
        if (i == 2) {
          break;
        }
        localObject1 = paramConfig;
        continue;
        label670:
        localObject1 = paramConfig;
      }
    }
  }
  
  private void aB(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      int i = paramConfig.version.get();
      int j = SharedPreUtils.B(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
      Object localObject = paramConfig.content_list;
      boolean bool = false;
      if ((localObject != null) && (paramConfig.content_list.size() > 0))
      {
        paramConfig = (String)paramConfig.content_list.get(0);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("received Headsup Notify configVersion:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" ,localVersion:");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(" ,configContent");
          ((StringBuilder)localObject).append(paramConfig);
          QLog.d("HeadsUp", 2, ((StringBuilder)localObject).toString());
        }
        if (i == j) {
          return;
        }
        if (paramConfig.contains("headsup_switch")) {
          bool = paramConfig.split("=")[1].trim().equals("true");
        }
        SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, true, bool);
        return;
      }
      if (i != j)
      {
        SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, false, true);
        paramQQAppInterface.mqqService.jdField_a_of_type_Boolean = false;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("received Headsup Notify configVersion:");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(" ,localVersion:");
        paramQQAppInterface.append(j);
        QLog.d("HeadsUp", 2, paramQQAppInterface.toString());
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HeadsUp", 2, "received Headsup Notify error", paramQQAppInterface);
      }
    }
    return;
  }
  
  /* Error */
  private void aC(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: ldc 8
    //   2: astore 5
    //   4: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +46 -> 53
    //   10: new 77	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   17: astore 6
    //   19: aload 6
    //   21: ldc_w 2337
    //   24: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 6
    //   30: aload_2
    //   31: getfield 2250	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   34: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   37: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc_w 2339
    //   44: iconst_2
    //   45: aload 6
    //   47: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_2
    //   54: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   57: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   60: istore 4
    //   62: aload_2
    //   63: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   66: ifnull +245 -> 311
    //   69: aload_2
    //   70: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   73: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   76: ifle +235 -> 311
    //   79: aload_2
    //   80: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   83: iconst_0
    //   84: invokevirtual 465	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   87: checkcast 125	java/lang/String
    //   90: astore_2
    //   91: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +40 -> 134
    //   97: new 77	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   104: astore 6
    //   106: aload 6
    //   108: ldc_w 2340
    //   111: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 6
    //   117: aload_2
    //   118: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: ldc_w 2339
    //   125: iconst_2
    //   126: aload 6
    //   128: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_2
    //   135: ifnull +176 -> 311
    //   138: new 127	org/json/JSONObject
    //   141: dup
    //   142: aload_2
    //   143: invokespecial 130	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   146: astore 8
    //   148: aload 8
    //   150: ldc_w 2342
    //   153: ldc 8
    //   155: invokevirtual 2344	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 6
    //   160: aload 8
    //   162: ldc_w 2346
    //   165: ldc 8
    //   167: invokevirtual 2344	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   170: astore_2
    //   171: aload 8
    //   173: ldc_w 2348
    //   176: ldc 8
    //   178: invokevirtual 2344	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 7
    //   183: aload 7
    //   185: astore 5
    //   187: aload 8
    //   189: ldc_w 2350
    //   192: iconst_0
    //   193: invokevirtual 2028	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   196: istore_3
    //   197: aload 7
    //   199: astore 5
    //   201: goto +47 -> 248
    //   204: astore 7
    //   206: goto +20 -> 226
    //   209: astore 7
    //   211: ldc 8
    //   213: astore_2
    //   214: goto +12 -> 226
    //   217: astore 7
    //   219: ldc 8
    //   221: astore 6
    //   223: aload 6
    //   225: astore_2
    //   226: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +83 -> 312
    //   232: ldc 91
    //   234: iconst_2
    //   235: aload 7
    //   237: invokevirtual 2032	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   240: aload 7
    //   242: invokestatic 1480	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   245: goto +67 -> 312
    //   248: aload_1
    //   249: getstatic 2353	com/tencent/mobileqq/app/QQManagerFactory:MEDAL_WALL_MNG	I
    //   252: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   255: checkcast 2355	com/tencent/mobileqq/medalwall/MedalWallMng
    //   258: iload_3
    //   259: aload 6
    //   261: aload_2
    //   262: aload 5
    //   264: invokevirtual 2358	com/tencent/mobileqq/medalwall/MedalWallMng:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_1
    //   268: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   271: iload 4
    //   273: aload_1
    //   274: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   277: invokestatic 2360	com/tencent/mobileqq/utils/SharedPreUtils:t	(Landroid/content/Context;ILjava/lang/String;)V
    //   280: aload_1
    //   281: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   284: aload_1
    //   285: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   288: iload_3
    //   289: invokestatic 2362	com/tencent/mobileqq/utils/SharedPreUtils:t	(Landroid/content/Context;Ljava/lang/String;I)V
    //   292: return
    //   293: astore_1
    //   294: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +14 -> 311
    //   300: ldc 91
    //   302: iconst_2
    //   303: aload_1
    //   304: iconst_0
    //   305: anewarray 4	java/lang/Object
    //   308: invokestatic 2365	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   311: return
    //   312: iconst_0
    //   313: istore_3
    //   314: goto -66 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	ConfigServlet
    //   0	317	1	paramQQAppInterface	QQAppInterface
    //   0	317	2	paramConfig	ConfigurationService.Config
    //   196	118	3	i	int
    //   60	212	4	j	int
    //   2	261	5	localObject1	Object
    //   17	243	6	localObject2	Object
    //   181	17	7	str	String
    //   204	1	7	localException1	Exception
    //   209	1	7	localException2	Exception
    //   217	24	7	localException3	Exception
    //   146	42	8	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   171	183	204	java/lang/Exception
    //   187	197	204	java/lang/Exception
    //   160	171	209	java/lang/Exception
    //   138	160	217	java/lang/Exception
    //   226	245	293	java/lang/Exception
    //   248	292	293	java/lang/Exception
  }
  
  private void aD(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int m = paramConfig.version.get();
    int n = SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2);
    StringBuilder localStringBuilder = null;
    JSONObject localJSONObject = null;
    int i;
    int j;
    if (m != n)
    {
      if (paramConfig.msg_content_list.size() > 0)
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramConfig == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig content is null !");
          }
          i = 1;
          paramConfig = localJSONObject;
        }
        else
        {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
            if (paramConfig == null) {}
          }
          for (;;)
          {
            try
            {
              paramConfig = new String(paramConfig, "UTF-8");
              i = 0;
            }
            catch (Throwable paramConfig)
            {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(" handleMedalStrongReminderConfig Throwable:");
                localStringBuilder.append(paramConfig.getMessage());
                QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
              }
              i = 2;
              paramConfig = localJSONObject;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig inflateConfigString error!");
            }
            i = 3;
            paramConfig = localJSONObject;
            break;
            paramConfig = paramConfig.content.get().toStringUtf8();
          }
        }
      }
      else
      {
        i = 4;
        paramConfig = localJSONObject;
      }
      j = i;
      if (!TextUtils.isEmpty(paramConfig))
      {
        try
        {
          localJSONObject = new JSONObject(paramConfig);
          if (localJSONObject.has("medal_strong_reminder_off"))
          {
            j = localJSONObject.getInt("medal_strong_reminder_off");
            break label297;
          }
          j = 6;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          j = 5;
        }
      }
      else
      {
        int k = 0;
        i = j;
        j = k;
      }
      label297:
      if (i == 0)
      {
        SharedPreUtils.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, j);
        if (paramQQAppInterface.isCreateManager(QQManagerFactory.MEDAL_WALL_MNG)) {
          ((MedalWallMng)paramQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(j);
        }
      }
      SharedPreUtils.d(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, m);
    }
    else
    {
      i = 0;
      j = 0;
      paramConfig = localStringBuilder;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handleMedalStrongReminderConfig localVersion: %s, version: %s, result: %s, value: %s, strContent: %s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), paramConfig }));
    }
  }
  
  private void aE(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject = null;
    StringBuilder localStringBuilder = null;
    for (;;)
    {
      try
      {
        int j = paramConfig.version.get();
        int k = ((Integer)SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2)).intValue();
        if (j == k) {
          break label365;
        }
        if (paramConfig.msg_content_list.size() <= 0) {
          break label349;
        }
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramConfig == null)
        {
          if (!QLog.isColorLevel()) {
            break label334;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig content is null !");
          break label334;
        }
        if (paramConfig.compress.get() == 1)
        {
          paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
          if (paramConfig != null)
          {
            try
            {
              paramConfig = new String(paramConfig, "UTF-8");
              localObject = paramConfig;
              i = 0;
            }
            catch (Throwable paramConfig)
            {
              if (!QLog.isColorLevel()) {
                break label339;
              }
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" handlePushRecommendShieldConfig Throwable:");
            localStringBuilder.append(paramConfig.getMessage());
            QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
            break label339;
          }
          if (!QLog.isColorLevel()) {
            break label344;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig inflateConfigString error!");
          break label344;
        }
        localObject = paramConfig.content.get().toStringUtf8();
        continue;
        if (i == 0)
        {
          SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 3, paramConfig);
          if (paramQQAppInterface.isCreateManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)) {
            ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(paramConfig);
          }
        }
        SharedPreUtils.a(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, 2, Integer.valueOf(j));
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handlePushRecommendShieldConfig localVersion: %s, version: %s, result: %s, strContent: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), paramConfig }));
          return;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      return;
      label334:
      int i = 1;
      break label351;
      label339:
      i = 2;
      break label351;
      label344:
      i = 3;
      break label351;
      label349:
      i = 4;
      label351:
      paramConfig = (ConfigurationService.Config)localObject;
      if (localObject == null)
      {
        paramConfig = "";
        continue;
        label365:
        i = 0;
        paramConfig = localStringBuilder;
      }
    }
  }
  
  private void aF(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject3 = paramConfig.msg_content_list;
    SharedPreferences.Editor localEditor = null;
    Object localObject1 = localEditor;
    if (localObject3 != null)
    {
      localObject1 = localEditor;
      if (paramConfig.msg_content_list.size() > 0)
      {
        localObject3 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        localObject1 = localEditor;
        if (localObject3 != null) {
          if (((ConfigurationService.Content)localObject3).compress.get() == 1)
          {
            localObject3 = OlympicUtil.a(((ConfigurationService.Content)localObject3).content.get().toByteArray());
            localObject1 = localEditor;
            if (localObject3 != null)
            {
              try
              {
                localObject1 = new String((byte[])localObject3, "UTF-8");
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                if (QLog.isColorLevel()) {
                  localOutOfMemoryError.printStackTrace();
                }
                System.gc();
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                try
                {
                  localObject2 = new String((byte[])localObject3, "UTF-8");
                }
                catch (Throwable localThrowable)
                {
                  for (;;)
                  {
                    Object localObject2;
                    Exception localException1 = localException2;
                  }
                }
                localUnsupportedEncodingException = localUnsupportedEncodingException;
                localObject2 = localEditor;
                if (!QLog.isColorLevel()) {
                  break label167;
                }
              }
              localUnsupportedEncodingException.printStackTrace();
              localObject2 = localEditor;
            }
          }
          else
          {
            localObject2 = localUnsupportedEncodingException.content.get().toStringUtf8();
          }
        }
      }
    }
    label167:
    localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4).edit();
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("SVDNAdjustment config : ");
          ((StringBuilder)localObject4).append((String)localObject2);
          QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject4).toString());
        }
        localObject4 = new JSONObject((String)localObject2).getJSONObject("SVDNAdjustment").getJSONArray("configs").getJSONObject(0).getJSONObject("config");
        localEditor.putFloat("SVDNAdjustment_data_type", (float)((JSONObject)localObject4).optDouble("data_type", 0.5D));
        localEditor.putInt("SVDNAdjustment_max_downmark", ((JSONObject)localObject4).optInt("max_downmark", 2));
        localEditor.putInt("SVDNAdjustment_max_upmark", ((JSONObject)localObject4).optInt("max_upmark", 2));
        localEditor.putInt("SVDNAdjustment_up_threshold_base", ((JSONObject)localObject4).optInt("up_threshold_base", 11));
        localEditor.putInt("SVDNAdjustment_down_threshold_base", ((JSONObject)localObject4).optInt("down_threshold_base", 25));
        localEditor.putInt("SVDNAdjustment_quality_up_threshold", ((JSONObject)localObject4).optInt("up_threshold_base", 11));
        localEditor.putInt("SVDNAdjustment_quality_down_threshold", ((JSONObject)localObject4).optInt("down_threshold_base", 25));
        localEditor.putFloat("SVDNAdjustment_up_threshold_coefficient", (float)((JSONObject)localObject4).optDouble("up_threshold_coefficient", 0.7D));
        localEditor.putFloat("SVDNAdjustment_down_threshold_coefficient", (float)((JSONObject)localObject4).optDouble("down_threshold_coefficient", 1.3D));
        localEditor.commit();
      }
    }
    catch (Exception localException2)
    {
      Object localObject4;
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("error: ");
        ((StringBuilder)localObject4).append(localException2.toString());
        QLog.e("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject4).toString());
      }
      localException2.printStackTrace();
    }
    ((IVideoFilterTools)QRoute.api(IVideoFilterTools.class)).handleQQShortVideoCommonConfig((String)localObject2);
    SharedPreUtils.s(paramQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
  }
  
  private void aG(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
    int j = paramConfig.version.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleNewTroopRecommend, localVersion:");
    localStringBuilder.append(i);
    localStringBuilder.append(",serverVersion:");
    localStringBuilder.append(j);
    QLog.w("SPLASH_ConfigServlet", 1, localStringBuilder.toString());
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramConfig != null)
        {
          if (paramConfig.compress.get() == 1)
          {
            Object localObject = OlympicUtil.a(paramConfig.content.get().toByteArray());
            localStringBuilder = null;
            paramConfig = localStringBuilder;
            if (localObject != null) {
              try
              {
                paramConfig = new String((byte[])localObject, "UTF-8");
              }
              catch (Exception paramConfig)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("handleNewTroopRecommend uncompress failed");
                ((StringBuilder)localObject).append(paramConfig);
                QLog.e("Q.lebanew", 1, ((StringBuilder)localObject).toString());
                paramConfig = localStringBuilder;
              }
            }
          }
          else
          {
            paramConfig = paramConfig.content.get().toStringUtf8();
          }
          if (!TextUtils.isEmpty(paramConfig))
          {
            paramQQAppInterface = (IRecommendTroopService)paramQQAppInterface.getRuntimeService(IRecommendTroopService.class, "");
            if (paramQQAppInterface != null) {
              paramQQAppInterface.updateTroopRecommend(paramConfig, j);
            }
          }
          else
          {
            QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend config_content is empty!");
          }
        }
        else
        {
          QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend content is empty!");
        }
      }
      else
      {
        QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend msg_content_list is empty!");
      }
    }
  }
  
  private void aH(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    IOCRService localIOCRService = (IOCRService)paramQQAppInterface.getRuntimeService(IOCRService.class, "");
    int i = localIOCRService.getConfigVersion();
    int j = paramConfig.version.get();
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("handleGetOCRConfig, version:");
    paramQQAppInterface.append(j);
    paramQQAppInterface.append(",localVersion:");
    paramQQAppInterface.append(i);
    paramQQAppInterface = paramQQAppInterface.toString();
    boolean bool2 = true;
    QLog.d("SPLASH_ConfigServlet", 1, paramQQAppInterface);
    Object localObject2 = null;
    Object localObject1 = null;
    paramQQAppInterface = localObject1;
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        paramQQAppInterface = localObject1;
        if (paramConfig != null)
        {
          if (paramConfig.compress.get() == 1)
          {
            paramQQAppInterface = OlympicUtil.a(paramConfig.content.get().toByteArray());
            if (paramQQAppInterface != null)
            {
              try
              {
                paramQQAppInterface = new String(paramQQAppInterface, "UTF-8");
              }
              catch (Throwable paramQQAppInterface)
              {
                if (!QLog.isColorLevel()) {
                  break label238;
                }
              }
              paramConfig = new StringBuilder();
              paramConfig.append("Throwable:");
              paramConfig.append(paramQQAppInterface.getMessage());
              QLog.d("SPLASH_ConfigServlet", 2, paramConfig.toString());
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "inflateConfigString error!");
            }
            label238:
            paramQQAppInterface = null;
          }
          else
          {
            paramQQAppInterface = paramConfig.content.get().toStringUtf8();
          }
          paramQQAppInterface = OcrConfig.parse(paramQQAppInterface);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface.version = j;
            bool1 = bool2;
            break label320;
          }
        }
      }
      else
      {
        OcrConfig.deleteLocalConfig(jdField_a_of_type_JavaLangString);
        bool1 = bool2;
        paramQQAppInterface = localObject2;
        if (!QLog.isColorLevel()) {
          break label320;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "handleGetOCRConfig, msg_content_list is null");
        bool1 = bool2;
        paramQQAppInterface = localObject2;
        break label320;
      }
    }
    boolean bool1 = false;
    label320:
    if (QLog.isColorLevel())
    {
      paramConfig = new StringBuilder();
      paramConfig.append("handleGetOCRConfig, isSucc = ");
      paramConfig.append(bool1);
      paramConfig.append(", ocrConfig = ");
      paramConfig.append(paramQQAppInterface);
      QLog.d("SPLASH_ConfigServlet", 2, paramConfig.toString());
    }
    localIOCRService.onGetOCRConfig(bool1, paramQQAppInterface);
  }
  
  private void aI(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
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
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = paramConfig.msg_content_list.get().iterator();
        for (;;)
        {
          if (!paramConfig.hasNext()) {
            return;
          }
          Object localObject = (ConfigurationService.Content)paramConfig.next();
          paramQQAppInterface = null;
          if (((ConfigurationService.Content)localObject).compress.get() == 1)
          {
            localObject = localNotificationController.a(((ConfigurationService.Content)localObject).content.get().toByteArray());
            if (localObject != null) {
              paramQQAppInterface = new String((byte[])localObject);
            }
          }
          else
          {
            paramQQAppInterface = ((ConfigurationService.Content)localObject).content.get().toStringUtf8();
          }
          try
          {
            localNotificationController.a(paramQQAppInterface, j, k);
          }
          catch (Exception paramQQAppInterface)
          {
            QLog.e("NCtr", 1, "[handleLimitNotifyConfig] parse fail", paramQQAppInterface);
            return;
          }
        }
      }
      QLog.i("NCtr", 1, "[hangleLimitNotifyConfig] config has no data");
      localNotificationController.a(jdField_a_of_type_JavaLangString);
    }
  }
  
  private void aJ(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j = paramConfig.version.get();
    int i = SharedPreUtils.aJ(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int k = SharedPreUtils.aK(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int m = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("handleSSOListConfig", 2, String.format("handleSSOListConfig.received SSOListConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m) }));
    }
    if (k != m)
    {
      SharedPreUtils.w(paramQQAppInterface.getApp(), m, paramQQAppInterface.getAccount());
      i = 0;
    }
    if (j != i)
    {
      Object localObject;
      if ((paramConfig.msg_content_list != null) && (!paramConfig.msg_content_list.isEmpty()))
      {
        localObject = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (((ConfigurationService.Content)localObject).compress.get() == 1)
        {
          localObject = OlympicUtil.a(((ConfigurationService.Content)localObject).content.get().toByteArray());
          if (localObject == null) {
            return;
          }
          try
          {
            localObject = new String((byte[])localObject, "UTF-8");
          }
          catch (Throwable paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramQQAppInterface));
            }
            return;
          }
        }
        else
        {
          localObject = ((ConfigurationService.Content)localObject).content.get().toStringUtf8();
        }
        try
        {
          boolean bool = new JSONObject((String)localObject).getBoolean("enable_ipv6");
          paramQQAppInterface.getApp().getSharedPreferences("sso_list", 4).edit().putBoolean("sso_list_enable_ipv6", bool).apply();
          SharedPreUtils.v(paramQQAppInterface.getApp(), paramConfig.version.get(), jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append(" sso_list_enable_ipv6 = ");
            paramQQAppInterface.append(bool);
            QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
          }
        }
        catch (JSONException paramQQAppInterface)
        {
          QLog.d("SPLASH_ConfigServlet", 1, paramQQAppInterface, new Object[0]);
        }
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 392, item: ");
          paramQQAppInterface.append((String)localObject);
          paramQQAppInterface.append(", version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("receiveAllConfigs|type: 392,content_list is empty ,version: ");
          ((StringBuilder)localObject).append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject).toString());
        }
        paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("sso_list", 4).edit();
        paramQQAppInterface.remove("sso_list");
        paramQQAppInterface.apply();
      }
    }
  }
  
  private void aK(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = JumpForwardPkgManager.a();
    int j = paramConfig.version.get();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("receiveAllConfigs[handleJumpPkgConfig]|received remote version: ");
      localStringBuilder.append(j);
      localStringBuilder.append(" | localVersion: ");
      localStringBuilder.append(i);
      QLog.d("JumpForwardPkgManager", 2, localStringBuilder.toString());
    }
    if (j != i) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramConfig != null)
        {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
            if (paramConfig != null)
            {
              try
              {
                paramConfig = new String(paramConfig, "UTF-8");
              }
              catch (Throwable paramConfig)
              {
                if (!QLog.isColorLevel()) {
                  break label222;
                }
              }
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("receiveAllConfigs[handleJumpPkgConfig]|Throwable:");
              localStringBuilder.append(paramConfig.getMessage());
              QLog.d("JumpForwardPkgManager", 2, localStringBuilder.toString());
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|inflateConfigString error!");
            }
            label222:
            paramConfig = "";
          }
          else
          {
            paramConfig = paramConfig.content.get().toStringUtf8();
          }
          JumpForwardPkgManager.a().a(paramQQAppInterface.getApp(), paramConfig, j);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]| content==null");
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs[handleJumpPkgConfig]| msg_content_list is empty ,version: ");
          paramQQAppInterface.append(j);
          paramQQAppInterface.append(",localVersion:");
          paramQQAppInterface.append(i);
          QLog.d("JumpForwardPkgManager", 2, paramQQAppInterface.toString());
        }
        JumpForwardPkgManager.a().a(j);
      }
    }
  }
  
  private void aL(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.Y(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("handleDevConfig: ,version: ");
    paramQQAppInterface.append(paramConfig.version.get());
    paramQQAppInterface.append("| localVersion: ");
    paramQQAppInterface.append(j);
    QLog.i("SPLASH_ConfigServlet", 1, paramQQAppInterface.toString());
    if (i != j)
    {
      SharedPreUtils.w(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
      paramQQAppInterface = a(paramConfig);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0)) {
        return;
      }
      try
      {
        paramQQAppInterface = (String)paramQQAppInterface.get(paramQQAppInterface.size() - 1);
        QLog.d("SPLASH_ConfigServlet", 1, new Object[] { "devConfig is ", paramQQAppInterface });
        SharedPreUtils.j(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, paramQQAppInterface);
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
  
  private void aM(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.getCurrentUin();
    int j = ((Integer)SharedPreUtils.a(localBaseApplication, str, "config_tim_team_version_code", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("handleTimTeamConfig received Config remote version:");
      paramQQAppInterface.append(i);
      paramQQAppInterface.append(" localVersion= ");
      paramQQAppInterface.append(j);
      QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
    }
    if (i != j)
    {
      paramQQAppInterface = a(paramConfig);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0)) {}
    }
    for (;;)
    {
      try
      {
        paramConfig = new JSONObject((String)paramQQAppInterface.get(0));
        paramQQAppInterface = "";
        if (!paramConfig.has("isWeb")) {
          break label295;
        }
        bool = paramConfig.getBoolean("isWeb");
        if (paramConfig.has("url")) {
          paramQQAppInterface = paramConfig.getString("url");
        }
        if (QLog.isColorLevel())
        {
          paramConfig = new StringBuilder();
          paramConfig.append("handleTimTeamConfig isWeb=");
          paramConfig.append(bool);
          paramConfig.append(" url=");
          paramConfig.append(paramQQAppInterface);
          QLog.d("SPLASH_ConfigServlet", 2, paramConfig.toString());
        }
        SharedPreUtils.a(localBaseApplication, str, false, "config_tim_team_is_web", Boolean.valueOf(bool));
        SharedPreUtils.a(localBaseApplication, str, false, "config_tim_team_url", paramQQAppInterface);
        SharedPreUtils.a(localBaseApplication, str, true, "config_tim_team_version_code", Integer.valueOf(i));
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.getMessage());
        }
      }
      return;
      label295:
      boolean bool = false;
    }
  }
  
  private void aa(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i;
    label320:
    label326:
    for (;;)
    {
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i >= paramConfig.content_list.size()) {
            break label320;
          }
          localObject = ((String)paramConfig.content_list.get(i)).trim();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("receiveAllConfigs|type: 201,content: ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(",version: ");
            localStringBuilder.append(paramConfig.version.get());
            QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, localStringBuilder.toString());
          }
          j = paramConfig.version.get();
          if (j != SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString))
          {
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (bool) {}
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        Object localObject;
        int j;
        if (QLog.isColorLevel())
        {
          paramConfig = new StringBuilder();
          paramConfig.append("received change machine config error,cmd : 201");
          paramConfig.append(paramQQAppInterface.toString());
          QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, paramConfig.toString());
        }
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), (JSONObject)localObject);
      }
      catch (JSONException localJSONException)
      {
        continue;
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received JSONException ");
      }
      SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_config_version", jdField_a_of_type_JavaLangString, j);
      break label326;
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        break label326;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 201,content_list is empty ,version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, paramQQAppInterface.toString());
          return;
        }
        return;
      }
    }
  }
  
  private void ab(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i;
    label517:
    label523:
    for (;;)
    {
      try
      {
        localEditor = paramQQAppInterface.getApp().getSharedPreferences("NearbyActivity.nearByTabUrl", 4).edit();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i >= paramConfig.content_list.size()) {
            break label517;
          }
          localObject1 = ((String)paramConfig.content_list.get(i)).trim();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("receiveAllConfigs|type: 129,content: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(",version: ");
            ((StringBuilder)localObject2).append(paramConfig.version.get());
            QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, ((StringBuilder)localObject2).toString());
          }
          j = paramConfig.version.get();
          if (j != SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString))
          {
            boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
            if (bool) {}
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        SharedPreferences.Editor localEditor;
        Object localObject1;
        Object localObject2;
        int j;
        String str1;
        String str2;
        String str3;
        if (QLog.isColorLevel())
        {
          paramConfig = new StringBuilder();
          paramConfig.append("received change machine config error,cmd : 129");
          paramConfig.append(paramQQAppInterface.toString());
          QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, paramConfig.toString());
        }
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = ((JSONObject)localObject1).getJSONObject("android").getString("url");
        str1 = ((JSONObject)localObject1).getJSONObject("android").getString("menuCell_startLive");
        str2 = ((JSONObject)localObject1).getJSONObject("android").getString("menuCell_personalCenter");
        str3 = ((JSONObject)localObject1).getJSONObject("android").getString("menuCell_help");
        localEditor.putString("nearByTabUrl", (String)localObject2);
        localEditor.putString("menuCell_startLive", str1);
        localEditor.putString("menuCell_personalCenter", str2);
        localEditor.putString("menuCell_help", str3);
        if (Build.VERSION.SDK_INT < 9) {
          localEditor.commit();
        } else {
          localEditor.apply();
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("received NearbyActivity.nearByTabUrl ");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).getJSONObject("android"));
        QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, ((StringBuilder)localObject2).toString());
      }
      catch (JSONException localJSONException)
      {
        continue;
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received JSONException in get NearbyActivity.nearByTabUrl");
      }
      SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", jdField_a_of_type_JavaLangString, j);
      break label523;
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        break label523;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 129,content_list is empty ,version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, paramQQAppInterface.toString());
          return;
        }
        return;
      }
    }
  }
  
  private void ac(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j;
    int k;
    label268:
    label269:
    do
    {
      for (;;)
      {
        try
        {
          j = paramConfig.version.get();
          k = SharedPreUtils.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString);
          if (paramConfig.msg_content_list == null) {
            break label269;
          }
          i = paramConfig.msg_content_list.size();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
        }
        catch (Exception paramQQAppInterface)
        {
          NearbyVideoChatManager localNearbyVideoChatManager;
          if (!QLog.isColorLevel()) {
            break label268;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatConfig error,cmd : 195", paramQQAppInterface);
        }
        localNearbyVideoChatManager = (NearbyVideoChatManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
        if (i > 0)
        {
          paramConfig = b(paramConfig, k, 195);
          localNearbyVideoChatManager.a(paramConfig);
          if (!TextUtils.isEmpty(paramConfig))
          {
            SharedPreUtils.a(paramQQAppInterface.getApp(), "change_machine_version", jdField_a_of_type_JavaLangString, j);
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("GetDoodleTemplateConfig|type: handleNearbyVideoChatConfig, content: \n");
              paramQQAppInterface.append(paramConfig);
              QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatConfig null");
          }
        }
        else
        {
          localNearbyVideoChatManager.a("");
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("receiveAllConfigs|type: 195,content_list is empty ,version: ");
            paramQQAppInterface.append(paramConfig.version.get());
            QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
            return;
          }
        }
        return;
        int i = -1;
      }
    } while (j != k);
  }
  
  private void ad(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j;
    int k;
    label258:
    label259:
    do
    {
      for (;;)
      {
        try
        {
          j = paramConfig.version.get();
          k = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString);
          if (paramConfig.msg_content_list == null) {
            break label259;
          }
          i = paramConfig.msg_content_list.size();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyAuthVideoConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            break label258;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyAuthVideoConfig error,cmd : 227", paramQQAppInterface);
        }
        if (i > 0)
        {
          paramConfig = b(paramConfig, k, 227);
          if (!TextUtils.isEmpty(paramConfig))
          {
            ((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).setAuthVideoConfig(paramConfig);
            SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", jdField_a_of_type_JavaLangString, j);
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("GetDoodleTemplateConfig|type: handleNearbyAuthVideoConfig, content: \n");
              paramQQAppInterface.append(paramConfig);
              QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyAuthVideoConfig null");
          }
        }
        else if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 227,content_list is empty ,version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
          return;
        }
        return;
        int i = -1;
      }
    } while (j != k);
  }
  
  private void ae(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j;
    int k;
    label257:
    label258:
    do
    {
      for (;;)
      {
        try
        {
          j = paramConfig.version.get();
          k = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString);
          if (paramConfig.msg_content_list == null) {
            break label258;
          }
          i = paramConfig.msg_content_list.size();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatDialogConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            break label257;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatDialogConfig error,cmd : 268", paramQQAppInterface);
        }
        if (i > 0)
        {
          paramConfig = b(paramConfig, k, 268);
          if (!TextUtils.isEmpty(paramConfig))
          {
            ((NearbyVideoChatManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT)).c(paramConfig);
            SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", jdField_a_of_type_JavaLangString, j);
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("GetDoodleTemplateConfig|type: handleNearbyVideoChatDialogConfig, content: \n");
              paramQQAppInterface.append(paramConfig);
              QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatDialogConfig null");
          }
        }
        else if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 268,content_list is empty ,version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
          return;
        }
        return;
        int i = -1;
      }
    } while (j != k);
  }
  
  private void af(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j;
    int k;
    label257:
    label258:
    do
    {
      for (;;)
      {
        try
        {
          j = paramConfig.version.get();
          k = SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString);
          if (paramConfig.msg_content_list == null) {
            break label258;
          }
          i = paramConfig.msg_content_list.size();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatBannerConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            break label257;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatBannerConfig error,cmd : 269", paramQQAppInterface);
        }
        if (i > 0)
        {
          paramConfig = b(paramConfig, k, 269);
          if (!TextUtils.isEmpty(paramConfig))
          {
            ((NearbyVideoChatManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT)).b(paramConfig);
            SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", jdField_a_of_type_JavaLangString, j);
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("GetDoodleTemplateConfig|type: handleNearbyVideoChatBannerConfig, content: \n");
              paramQQAppInterface.append(paramConfig);
              QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatBannerConfig null");
          }
        }
        else if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 269,content_list is empty ,version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
          return;
        }
        return;
        int i = -1;
      }
    } while (j != k);
  }
  
  private void ag(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    PtvTemplateManager localPtvTemplateManager = PtvTemplateManager.a(paramQQAppInterface);
    int k = paramConfig.version.get();
    int i = SharedPreUtils.k(paramQQAppInterface.getApp());
    if (!PtvTemplateManager.c()) {
      i = 0;
    }
    int j;
    if (paramConfig.msg_content_list != null) {
      j = paramConfig.msg_content_list.size();
    } else {
      j = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, String.format("个性笔触配置回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
    }
    if (k == i) {
      return;
    }
    if (j > 0)
    {
      paramConfig = b(paramConfig, i, 139);
      if (!TextUtils.isEmpty(paramConfig))
      {
        localPtvTemplateManager.a(paramConfig, paramQQAppInterface);
        SharedPreUtils.i(paramQQAppInterface.getApp(), k);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("GetDoodleTemplateConfig|type: 个性笔触配置回包内容, content: \n");
          paramQQAppInterface.append(paramConfig);
          QLog.d("SPLASH_ConfigServletDoodle_Strokes_", 2, paramQQAppInterface.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: 个性笔触配置回包内容为空");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: 个性笔触配置回包为空");
      }
      localPtvTemplateManager.c();
    }
  }
  
  /* Error */
  private void ah(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: istore_3
    //   8: aload_1
    //   9: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   12: iload_3
    //   13: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokestatic 2729	com/tencent/mobileqq/utils/SharedPreUtils:g	(Landroid/content/Context;ILjava/lang/String;)V
    //   19: aload_2
    //   20: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   23: ifnull +24 -> 47
    //   26: aload_2
    //   27: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   30: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   33: ifle +14 -> 47
    //   36: aload_2
    //   37: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   40: invokevirtual 1046	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   43: astore_1
    //   44: goto +5 -> 49
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +177 -> 227
    //   53: aload_1
    //   54: invokeinterface 110 1 0
    //   59: ifle +168 -> 227
    //   62: iconst_0
    //   63: istore_3
    //   64: aload_1
    //   65: iconst_0
    //   66: invokeinterface 191 2 0
    //   71: checkcast 125	java/lang/String
    //   74: astore_1
    //   75: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +61 -> 139
    //   81: new 77	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   88: astore 4
    //   90: aload 4
    //   92: ldc_w 2731
    //   95: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 4
    //   101: aload_1
    //   102: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 4
    //   108: ldc_w 472
    //   111: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: aload_2
    //   118: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   121: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   124: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc 91
    //   130: iconst_2
    //   131: aload 4
    //   133: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_1
    //   140: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifne +128 -> 271
    //   146: invokestatic 2268	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   149: astore_2
    //   150: aload_2
    //   151: new 804	java/io/ByteArrayInputStream
    //   154: dup
    //   155: aload_1
    //   156: invokevirtual 2270	java/lang/String:getBytes	()[B
    //   159: invokespecial 813	java/io/ByteArrayInputStream:<init>	([B)V
    //   162: ldc_w 424
    //   165: invokeinterface 2276 3 0
    //   170: iload_3
    //   171: iconst_1
    //   172: if_icmpeq +99 -> 271
    //   175: iload_3
    //   176: iconst_2
    //   177: if_icmpne +28 -> 205
    //   180: aload_2
    //   181: invokeinterface 2282 1 0
    //   186: ldc_w 2733
    //   189: invokevirtual 2287	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   192: ifeq +13 -> 205
    //   195: aload_2
    //   196: invokeinterface 2290 1 0
    //   201: iconst_1
    //   202: invokestatic 2739	com/tencent/mobileqq/activity/JumpActivity:initJASwitch	(Ljava/lang/String;Z)V
    //   205: aload_2
    //   206: invokeinterface 2294 1 0
    //   211: istore_3
    //   212: goto -42 -> 170
    //   215: astore_1
    //   216: goto +9 -> 225
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   224: return
    //   225: aload_1
    //   226: athrow
    //   227: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq +41 -> 271
    //   233: new 77	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   240: astore_1
    //   241: aload_1
    //   242: ldc_w 2741
    //   245: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_1
    //   250: aload_2
    //   251: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   254: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   257: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: ldc 91
    //   263: iconst_2
    //   264: aload_1
    //   265: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	ConfigServlet
    //   0	272	1	paramQQAppInterface	QQAppInterface
    //   0	272	2	paramConfig	ConfigurationService.Config
    //   7	205	3	i	int
    //   88	44	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   146	170	215	finally
    //   180	205	215	finally
    //   205	212	215	finally
    //   220	224	215	finally
    //   146	170	219	java/lang/Exception
    //   180	205	219	java/lang/Exception
    //   205	212	219	java/lang/Exception
  }
  
  private void ai(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "CMD_PHONE_UNITY_BANNER_CONFIG");
    }
    PhoneUnityManager localPhoneUnityManager = (PhoneUnityManager)paramQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
    int i = localPhoneUnityManager.a();
    int n = paramConfig.version.get();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("newVersion ");
      ((StringBuilder)localObject1).append(n);
      QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
    }
    if (i == n) {
      return;
    }
    Object localObject3 = paramConfig.content_list;
    PhoneUnityBannerData localPhoneUnityBannerData = null;
    Object localObject1 = null;
    Object localObject7;
    Object localObject4;
    if ((localObject3 != null) && (paramConfig.content_list.size() > 0))
    {
      localObject3 = paramConfig.content_list.get();
      if ((localObject3 != null) && (((List)localObject3).size() > 0))
      {
        localObject3 = (String)((List)localObject3).get(0);
        localObject7 = localObject3;
        if (!QLog.isColorLevel()) {
          break label290;
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("receiveAllConfigs|type: 34,content: ");
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(",version: ");
        ((StringBuilder)localObject4).append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject4).toString());
        localObject7 = localObject3;
        break label290;
      }
    }
    for (;;)
    {
      localObject7 = null;
      break;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("receiveAllConfigs|type: 34,content_list is empty ,version: ");
        ((StringBuilder)localObject3).append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject3).toString());
      }
    }
    for (;;)
    {
      label290:
      int m;
      Object localObject2;
      ConfigurationService.Config localConfig;
      try
      {
        if (!TextUtils.isEmpty(localObject7))
        {
          localPhoneUnityBannerData = new PhoneUnityBannerData();
          try
          {
            XmlPullParser localXmlPullParser = Xml.newPullParser();
            localXmlPullParser.setInput(new ByteArrayInputStream(localObject7.getBytes()), "UTF-8");
            localObject1 = null;
            paramConfig = (ConfigurationService.Config)localObject1;
            k = 0;
            i = 0;
            if (k != 1)
            {
              Object localObject5 = localObject1;
              Object localObject6 = paramConfig;
              int j = i;
              if (k == 2)
              {
                localObject4 = localObject1;
                localObject3 = paramConfig;
                k = i;
              }
              try
              {
                String str = localXmlPullParser.getName();
                localObject4 = localObject1;
                localObject3 = paramConfig;
                k = i;
                if (str.equalsIgnoreCase("banner"))
                {
                  localObject4 = localObject1;
                  localObject3 = paramConfig;
                  k = i;
                  int i1 = localXmlPullParser.getAttributeCount();
                  m = 0;
                  localObject5 = localObject1;
                  localObject6 = paramConfig;
                  j = i;
                  if (m < i1)
                  {
                    localObject4 = localObject1;
                    localObject3 = paramConfig;
                    k = i;
                    localObject5 = localXmlPullParser.getAttributeName(m);
                    localObject4 = localObject1;
                    localObject3 = paramConfig;
                    k = i;
                    if ("text".equals(localObject5))
                    {
                      localObject4 = localObject1;
                      localObject3 = paramConfig;
                      k = i;
                      localPhoneUnityBannerData.jdField_b_of_type_JavaLangString = localXmlPullParser.getAttributeValue(m);
                      break label1196;
                    }
                    localObject4 = localObject1;
                    localObject3 = paramConfig;
                    k = i;
                    if ("url".equals(localObject5))
                    {
                      localObject4 = localObject1;
                      localObject3 = paramConfig;
                      k = i;
                      localPhoneUnityBannerData.jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(m);
                      break label1196;
                    }
                    localObject4 = localObject1;
                    localObject3 = paramConfig;
                    k = i;
                    if ("dayNum".equals(localObject5))
                    {
                      localObject4 = localObject1;
                      localObject3 = paramConfig;
                      k = i;
                      localPhoneUnityBannerData.jdField_a_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(m)).intValue();
                      break label1196;
                    }
                    localObject4 = localObject1;
                    localObject3 = paramConfig;
                    k = i;
                    if ("dayIntervalNum".equals(localObject5))
                    {
                      localObject4 = localObject1;
                      localObject3 = paramConfig;
                      k = i;
                      localPhoneUnityBannerData.jdField_b_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(m)).intValue();
                      break label1196;
                    }
                    localObject4 = localObject1;
                    localObject3 = paramConfig;
                    k = i;
                    if ("totalNum".equals(localObject5))
                    {
                      localObject4 = localObject1;
                      localObject3 = paramConfig;
                      k = i;
                      localPhoneUnityBannerData.c = Integer.valueOf(localXmlPullParser.getAttributeValue(m)).intValue();
                      break label1196;
                    }
                    localObject4 = localObject1;
                    localObject3 = paramConfig;
                    k = i;
                    if ("loginNum".equals(localObject5))
                    {
                      localObject4 = localObject1;
                      localObject3 = paramConfig;
                      k = i;
                      localPhoneUnityBannerData.e = Integer.valueOf(localXmlPullParser.getAttributeValue(m)).intValue();
                      break label1196;
                    }
                    localObject4 = localObject1;
                    localObject3 = paramConfig;
                    k = i;
                    boolean bool = "banner".equals(localObject5);
                    if (bool)
                    {
                      localObject4 = localObject1;
                      localObject3 = paramConfig;
                      k = i;
                      localPhoneUnityBannerData.jdField_a_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(m));
                      break label1196;
                    }
                    localObject4 = localObject1;
                    localObject3 = paramConfig;
                    k = i;
                    if (!"setEntry".equals(localObject5)) {
                      break label1196;
                    }
                    localObject4 = localObject1;
                    localObject3 = paramConfig;
                    k = i;
                    localPhoneUnityBannerData.jdField_b_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(m));
                    break label1196;
                  }
                }
                else
                {
                  localObject4 = localObject1;
                  localObject3 = paramConfig;
                  k = i;
                  if (str.equalsIgnoreCase("bindGuideWording"))
                  {
                    localObject4 = localObject1;
                    localObject3 = paramConfig;
                    k = i;
                    localObject5 = localXmlPullParser.nextText();
                    localObject6 = paramConfig;
                    j = i;
                  }
                  else
                  {
                    localObject4 = localObject1;
                    localObject3 = paramConfig;
                    k = i;
                    if (str.equalsIgnoreCase("bindGuideStyle"))
                    {
                      localObject4 = localObject1;
                      localObject3 = paramConfig;
                      k = i;
                      j = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                      localObject5 = localObject1;
                      localObject6 = paramConfig;
                    }
                    else
                    {
                      localObject5 = localObject1;
                      localObject6 = paramConfig;
                      j = i;
                      localObject4 = localObject1;
                      localObject3 = paramConfig;
                      k = i;
                      if (str.equalsIgnoreCase("guideWording"))
                      {
                        localObject4 = localObject1;
                        localObject3 = paramConfig;
                        k = i;
                        localObject6 = localXmlPullParser.nextText();
                        j = i;
                        localObject5 = localObject1;
                      }
                    }
                  }
                }
                localObject4 = localObject5;
                localObject3 = localObject6;
                k = j;
                i = localXmlPullParser.next();
                k = i;
                localObject1 = localObject5;
                paramConfig = (ConfigurationService.Config)localObject6;
                i = j;
              }
              catch (Throwable localThrowable1)
              {
                paramConfig = localPhoneUnityBannerData;
                continue;
              }
            }
            localObject3 = paramConfig;
          }
          catch (Throwable localThrowable2)
          {
            paramConfig = localPhoneUnityBannerData;
            continue;
          }
        }
        else
        {
          localObject2 = null;
          localObject3 = localObject2;
          i = 0;
        }
      }
      catch (Throwable localThrowable3)
      {
        paramConfig = localObject2;
        localObject2 = localThrowable3;
        localObject3 = null;
        localObject4 = null;
        int k = 0;
        QLog.e("IMCore.PhoneContact", 1, "", localObject2);
        i = k;
        localObject2 = localObject4;
        localConfig = paramConfig;
      }
      localPhoneUnityManager.a(n, localObject7, localConfig);
      ((IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).saveBindConfig(i, localObject2, (String)localObject3);
      return;
      label1196:
      m += 1;
    }
  }
  
  private void aj(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label307;
      }
      i = 0;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        int i;
        Object localObject;
        StringBuilder localStringBuilder;
        int j;
        int k;
        label307:
        continue;
        label372:
        i += 1;
      }
    }
    if (i < paramConfig.content_list.size())
    {
      localObject = (String)paramConfig.content_list.get(i);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("receiveAllConfigs|type: 66,content: ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",version: ");
        localStringBuilder.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
      }
      j = paramConfig.version.get();
      k = SharedPreUtils.y(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("received SUBSCRIPT_RECOMMEND_CMD remote version: ");
        localStringBuilder.append(j);
        localStringBuilder.append(" | localVersion: ");
        localStringBuilder.append(k);
        QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
      }
      if ((j == k) && (paramConfig.content_list.size() <= 0))
      {
        if (!QLog.isColorLevel()) {
          break label372;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD IGNORE THIS ACTION  because of SAME VERSION");
        break label372;
      }
      if ((((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).updateSubscriptRecommendConfig(paramQQAppInterface, (String)localObject)) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("received SUBSCRIPT_RECOMMEND_CMD save version: ");
        ((StringBuilder)localObject).append(j);
        QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject).toString());
      }
      SharedPreUtils.j(paramQQAppInterface.getApplication(), paramQQAppInterface.getAccount(), j);
      break label372;
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("receiveAllConfigs|type: 66,content_list is empty ,version: ");
        paramQQAppInterface.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received subscript recommend config error,cmd : 66");
        }
      }
    }
  }
  
  private void ak(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      String str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("receiveAllConfigs|type: 43,content: ");
        localStringBuilder.append(str);
        localStringBuilder.append(",version: ");
        localStringBuilder.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
      }
      int i = paramConfig.version.get();
      int j = SharedPreUtils.C(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        paramConfig = new StringBuilder();
        paramConfig.append("received READINJOY_LOCAL_CHANNEL_CONFIG_CMD remote version: ");
        paramConfig.append(i);
        paramConfig.append(" | localVersion: ");
        paramConfig.append(j);
        QLog.d("SPLASH_ConfigServlet", 2, paramConfig.toString());
      }
      if (i != j)
      {
        SharedPreUtils.k(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
        if (QLog.isColorLevel())
        {
          paramConfig = new StringBuilder();
          paramConfig.append("received READINJOY_LOCAL_CHANNEL_CONFIG_CMD save version: ");
          paramConfig.append(i);
          QLog.d("SPLASH_ConfigServlet", 2, paramConfig.toString());
        }
        a(i, "LocalChannelCity", str, paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD save to database");
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("receiveAllConfigs|type: 43,content_list is empty ,version: ");
      paramQQAppInterface.append(paramConfig.version.get());
      QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
    }
  }
  
  private void al(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      int i = SharedPreUtils.s(paramQQAppInterface.getApp());
      int j = paramConfig.version.get();
      if (i != j)
      {
        ThreadManager.post(new ConfigServlet.8(this, paramQQAppInterface, paramConfig), 8, null, false);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("received HOTCHAT_SCENE_CONFIGS_CMD same version, ");
        paramQQAppInterface.append(j);
        QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramConfig = new StringBuilder();
        paramConfig.append("received HOTCHAT_SCENE_CONFIGS_CMD, EXCEPTION");
        paramConfig.append(paramQQAppInterface.toString());
        QLog.d("SPLASH_ConfigServlet", 2, paramConfig.toString());
      }
    }
  }
  
  private void am(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      int i = PatchSharedPreUtil.getPatchConfigVersion(BaseApplicationImpl.sApplication);
      int j = paramConfig.version.get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePatchConfigCmd server version: ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" | localVersion: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("PatchLogTag", 1, ((StringBuilder)localObject).toString());
      if (j != i)
      {
        localObject = a(paramConfig);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          i = 0;
        }
        while (i < ((List)localObject).size())
        {
          paramConfig = (String)((List)localObject).get(i);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handlePatchConfigCmd msg_content_list index=");
          localStringBuilder.append(i);
          localStringBuilder.append(", content=");
          localStringBuilder.append(paramConfig);
          QLog.d("PatchLogTag", 1, localStringBuilder.toString());
          PatchConfigManager.a(BaseApplicationImpl.sApplication, paramConfig);
          i += 1;
          continue;
          if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
            i = 0;
          }
          while (i < paramConfig.content_list.size())
          {
            localObject = (String)paramConfig.content_list.get(i);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("handlePatchConfigCmd content_list index=");
            localStringBuilder.append(i);
            localStringBuilder.append(", content=");
            localStringBuilder.append((String)localObject);
            QLog.d("PatchLogTag", 1, localStringBuilder.toString());
            PatchConfigManager.a(BaseApplicationImpl.sApplication, (String)localObject);
            i += 1;
            continue;
            QLog.d("PatchLogTag", 1, "handlePatchConfigCmd msg_content_list and content_list are empty");
          }
        }
        PatchSharedPreUtil.updatePatchConfigVersion(BaseApplicationImpl.sApplication, j);
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, paramQQAppInterface.getCurrentUin(), "actPatchConfig", 100, "");
      }
      else
      {
        QLog.d("PatchLogTag", 1, "handlePatchConfigCmd not update config as same version");
      }
      PatchFileManager.a(paramQQAppInterface);
      if (PatchSharedPreUtil.getPatchConfigVersion(BaseApplicationImpl.sApplication) != j)
      {
        PatchSharedPreUtil.updatePatchConfigVersion(BaseApplicationImpl.sApplication, 0);
        return;
      }
    }
    catch (Throwable paramConfig)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePatchConfigCmd throwable=");
      ((StringBuilder)localObject).append(paramConfig);
      QLog.e("PatchLogTag", 1, ((StringBuilder)localObject).toString());
      PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, paramQQAppInterface.getCurrentUin(), "actPatchConfig", 102, "");
    }
  }
  
  private void an(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ThreadManager.post(new ConfigServlet.9(this, paramConfig, paramQQAppInterface), 5, null, false);
  }
  
  private void ao(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      String str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("receiveAllConfigs|type: 61,content: ");
        localStringBuilder.append(str);
        localStringBuilder.append(",version: ");
        localStringBuilder.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
      }
      int i = paramConfig.version.get();
      int j = SharedPreUtils.t(paramQQAppInterface.getApp());
      if (QLog.isColorLevel())
      {
        paramConfig = new StringBuilder();
        paramConfig.append("received CAMERA_COMPATIBLE_LIST_CONFIG remote version: ");
        paramConfig.append(i);
        paramConfig.append(" | localVersion: ");
        paramConfig.append(j);
        QLog.d("SPLASH_ConfigServlet", 2, paramConfig.toString());
      }
      if (i != j)
      {
        SharedPreUtils.m(paramQQAppInterface.getApp(), i);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("received CAMERA_COMPATIBLE_LIST_CONFIG save version: ");
          paramQQAppInterface.append(i);
          QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
        }
        ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).updateCompatibleList(str, true);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save to sps");
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("receiveAllConfigs|type: 61,content_list is empty ,version: ");
      paramQQAppInterface.append(paramConfig.version.get());
      QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
    }
  }
  
  private void ap(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      String str = (String)paramConfig.content_list.get(0);
      int i = paramConfig.version.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("receiveAllConfigs|type: 64,content: ");
        localStringBuilder.append(str);
        localStringBuilder.append(",version: ");
        localStringBuilder.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
      }
      if (i != SharedPreUtils.v(paramQQAppInterface.getApp()))
      {
        SharedPreUtils.n(paramQQAppInterface.getApp(), i);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("received SHORTVIDEO_PROGRESSIVE_BLACKLIST_CONFIG save version: ");
          paramQQAppInterface.append(i);
          QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SHORTVIDEO_PROGRESSIVE_BLACKLIST_CONFIG save to sps");
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("receiveAllConfigs|type: 64,content_list is empty ,version: ");
      paramQQAppInterface.append(paramConfig.version.get());
      QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
    }
  }
  
  private void aq(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new ConfigServlet.10(this, paramQQAppInterface, paramConfig));
  }
  
  private void ar(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.z(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("received RedBagFoldMsgConfig remote version: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" | localVersion: ");
      ((StringBuilder)localObject).append(j);
      QLog.d("msgFold", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      localObject = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("receiveAllConfigs|type: 69,content: ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",version: ");
        localStringBuilder.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        paramConfig = new StringBuilder();
        paramConfig.append("received RedBagFoldMsgConfig content: ");
        paramConfig.append((String)localObject);
        QLog.d("msgFold", 2, paramConfig.toString());
      }
      if (i != j) {
        PasswdRedBagFoldManager.a(paramQQAppInterface, i, (String)localObject);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receiveAllConfigs|type: 69,content_list is empty ,version: ");
      ((StringBuilder)localObject).append(paramConfig.version.get());
      QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject).toString());
    }
    if (i == j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, "received RedBagFoldMsgConfig, content_list is empty, ignored because of SAME VERSION");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("msgFold", 2, "received RedBagFoldMsgConfig, content_list is empty, use default config");
    }
    paramConfig = (PasswdRedBagFoldManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
    paramConfig.jdField_a_of_type_Boolean = true;
    paramConfig.jdField_b_of_type_Boolean = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    paramConfig.jdField_a_of_type_Int = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    paramConfig.c = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    paramConfig.d = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, paramConfig.jdField_b_of_type_Boolean, paramConfig.jdField_a_of_type_Int, paramConfig.c, paramConfig.d);
  }
  
  private void as(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      paramQQAppInterface = (MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if (paramConfig.content_list.size() > 0)
      {
        String str = (String)paramConfig.content_list.get(0);
        int i = paramConfig.version.get();
        int j = paramQQAppInterface.b();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("receiveAllConfigs|type: 74,content: ");
          localStringBuilder.append(str);
          localStringBuilder.append(",version: ");
          localStringBuilder.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
        }
        if ((i != j) || (paramConfig.content_list.size() > 0)) {
          paramQQAppInterface.a(i, str);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("receiveAllConfigs|type: 74,content_list is empty ,version: ");
      paramQQAppInterface.append(paramConfig.version.get());
      QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
    }
  }
  
  private void at(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      paramQQAppInterface = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
      if (paramConfig.content_list.size() > 0)
      {
        String str = (String)paramConfig.content_list.get(0);
        int i = paramConfig.version.get();
        int j = paramQQAppInterface.getsAllEntranceConfigVersion();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("receiveAllConfigs|type: 97,content: ");
          localStringBuilder.append(str);
          localStringBuilder.append(",version: ");
          localStringBuilder.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
        }
        if ((i != j) || (paramConfig.content_list.size() > 0)) {
          paramQQAppInterface.updateAllEntranceConfig(i, str);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("receiveAllConfigs|type: 97,content_list is empty ,version: ");
      paramQQAppInterface.append(paramConfig.version.get());
      QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
    }
  }
  
  /* Error */
  private void au(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: istore 8
    //   9: aload_1
    //   10: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: aload_1
    //   14: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   17: invokestatic 1526	com/tencent/mobileqq/utils/SharedPreUtils:ao	(Landroid/content/Context;Ljava/lang/String;)I
    //   20: istore_3
    //   21: aload_1
    //   22: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: aload_1
    //   26: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokestatic 1529	com/tencent/mobileqq/utils/SharedPreUtils:ap	(Landroid/content/Context;Ljava/lang/String;)I
    //   32: istore 4
    //   34: invokestatic 1198	com/tencent/common/config/AppSetting:a	()I
    //   37: istore 5
    //   39: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +50 -> 92
    //   45: ldc 91
    //   47: iconst_2
    //   48: ldc_w 3002
    //   51: iconst_4
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: iload 8
    //   59: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: iload_3
    //   66: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: iload 4
    //   74: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: dup
    //   79: iconst_3
    //   80: iload 5
    //   82: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: invokestatic 549	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: iload 4
    //   94: iload 5
    //   96: if_icmpeq +18 -> 114
    //   99: aload_1
    //   100: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   103: aload_1
    //   104: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   107: iload 5
    //   109: invokestatic 3004	com/tencent/mobileqq/utils/SharedPreUtils:I	(Landroid/content/Context;Ljava/lang/String;I)V
    //   112: iconst_0
    //   113: istore_3
    //   114: iload 8
    //   116: iload_3
    //   117: if_icmpeq +2254 -> 2371
    //   120: aload_2
    //   121: iload_3
    //   122: sipush 228
    //   125: invokestatic 2022	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   128: astore 10
    //   130: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +12 -> 145
    //   136: ldc_w 3006
    //   139: iconst_2
    //   140: aload 10
    //   142: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload 10
    //   147: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +2177 -> 2327
    //   153: ldc 8
    //   155: astore 13
    //   157: aconst_null
    //   158: astore 20
    //   160: aconst_null
    //   161: astore 22
    //   163: aconst_null
    //   164: astore 23
    //   166: aconst_null
    //   167: astore 24
    //   169: aconst_null
    //   170: astore 25
    //   172: aconst_null
    //   173: astore 12
    //   175: aconst_null
    //   176: astore 14
    //   178: aconst_null
    //   179: astore 15
    //   181: aconst_null
    //   182: astore 16
    //   184: aconst_null
    //   185: astore 17
    //   187: aconst_null
    //   188: astore 18
    //   190: aconst_null
    //   191: astore_2
    //   192: invokestatic 798	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   195: invokevirtual 802	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   198: new 804	java/io/ByteArrayInputStream
    //   201: dup
    //   202: aload 10
    //   204: ldc_w 806
    //   207: invokevirtual 810	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   210: invokespecial 813	java/io/ByteArrayInputStream:<init>	([B)V
    //   213: invokevirtual 818	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   216: astore 29
    //   218: aload 29
    //   220: ldc_w 3008
    //   223: invokeinterface 826 2 0
    //   228: iconst_0
    //   229: invokeinterface 837 2 0
    //   234: invokeinterface 843 1 0
    //   239: invokeinterface 846 1 0
    //   244: astore 26
    //   246: aload 29
    //   248: ldc_w 3010
    //   251: invokeinterface 826 2 0
    //   256: iconst_0
    //   257: invokeinterface 837 2 0
    //   262: invokeinterface 843 1 0
    //   267: invokeinterface 846 1 0
    //   272: astore 27
    //   274: aload 29
    //   276: ldc_w 3012
    //   279: invokeinterface 826 2 0
    //   284: iconst_0
    //   285: invokeinterface 837 2 0
    //   290: invokeinterface 843 1 0
    //   295: invokeinterface 846 1 0
    //   300: astore 28
    //   302: aload 29
    //   304: ldc_w 3014
    //   307: invokeinterface 826 2 0
    //   312: iconst_0
    //   313: invokeinterface 837 2 0
    //   318: invokeinterface 843 1 0
    //   323: invokeinterface 846 1 0
    //   328: astore 10
    //   330: aload 29
    //   332: ldc_w 3016
    //   335: invokeinterface 826 2 0
    //   340: iconst_0
    //   341: invokeinterface 837 2 0
    //   346: invokeinterface 843 1 0
    //   351: invokeinterface 846 1 0
    //   356: astore 11
    //   358: aload 13
    //   360: astore 14
    //   362: aload_2
    //   363: astore 18
    //   365: aload 13
    //   367: astore 15
    //   369: aload 13
    //   371: astore 16
    //   373: aload 13
    //   375: astore 17
    //   377: aload 13
    //   379: astore 19
    //   381: aload 13
    //   383: astore 21
    //   385: aload 29
    //   387: ldc_w 3018
    //   390: invokeinterface 826 2 0
    //   395: iconst_0
    //   396: invokeinterface 837 2 0
    //   401: invokeinterface 843 1 0
    //   406: invokeinterface 846 1 0
    //   411: astore 12
    //   413: aload 13
    //   415: astore 14
    //   417: aload 12
    //   419: astore 18
    //   421: aload 13
    //   423: astore 15
    //   425: aload 12
    //   427: astore 20
    //   429: aload 13
    //   431: astore 16
    //   433: aload 12
    //   435: astore 22
    //   437: aload 13
    //   439: astore 17
    //   441: aload 12
    //   443: astore 23
    //   445: aload 13
    //   447: astore 19
    //   449: aload 12
    //   451: astore 24
    //   453: aload 13
    //   455: astore 21
    //   457: aload 12
    //   459: astore 25
    //   461: aload 29
    //   463: ldc_w 3020
    //   466: invokeinterface 826 2 0
    //   471: astore 29
    //   473: aload 13
    //   475: astore_2
    //   476: aload 29
    //   478: ifnull +191 -> 669
    //   481: aload 13
    //   483: astore_2
    //   484: aload 13
    //   486: astore 14
    //   488: aload 12
    //   490: astore 18
    //   492: aload 13
    //   494: astore 15
    //   496: aload 12
    //   498: astore 20
    //   500: aload 13
    //   502: astore 16
    //   504: aload 12
    //   506: astore 22
    //   508: aload 13
    //   510: astore 17
    //   512: aload 12
    //   514: astore 23
    //   516: aload 13
    //   518: astore 19
    //   520: aload 12
    //   522: astore 24
    //   524: aload 13
    //   526: astore 21
    //   528: aload 12
    //   530: astore 25
    //   532: aload 29
    //   534: invokeinterface 831 1 0
    //   539: ifle +130 -> 669
    //   542: aload 13
    //   544: astore 14
    //   546: aload 12
    //   548: astore 18
    //   550: aload 13
    //   552: astore 15
    //   554: aload 12
    //   556: astore 20
    //   558: aload 13
    //   560: astore 16
    //   562: aload 12
    //   564: astore 22
    //   566: aload 13
    //   568: astore 17
    //   570: aload 12
    //   572: astore 23
    //   574: aload 13
    //   576: astore 19
    //   578: aload 12
    //   580: astore 24
    //   582: aload 13
    //   584: astore 21
    //   586: aload 12
    //   588: astore 25
    //   590: aload 29
    //   592: iconst_0
    //   593: invokeinterface 837 2 0
    //   598: invokeinterface 843 1 0
    //   603: astore 29
    //   605: aload 13
    //   607: astore_2
    //   608: aload 29
    //   610: ifnull +59 -> 669
    //   613: aload 13
    //   615: astore 14
    //   617: aload 12
    //   619: astore 18
    //   621: aload 13
    //   623: astore 15
    //   625: aload 12
    //   627: astore 20
    //   629: aload 13
    //   631: astore 16
    //   633: aload 12
    //   635: astore 22
    //   637: aload 13
    //   639: astore 17
    //   641: aload 12
    //   643: astore 23
    //   645: aload 13
    //   647: astore 19
    //   649: aload 12
    //   651: astore 24
    //   653: aload 13
    //   655: astore 21
    //   657: aload 12
    //   659: astore 25
    //   661: aload 29
    //   663: invokeinterface 846 1 0
    //   668: astore_2
    //   669: aload_2
    //   670: astore 14
    //   672: aload 12
    //   674: astore 18
    //   676: aload_2
    //   677: astore 15
    //   679: aload 12
    //   681: astore 20
    //   683: aload_2
    //   684: astore 16
    //   686: aload 12
    //   688: astore 22
    //   690: aload_2
    //   691: astore 17
    //   693: aload 12
    //   695: astore 23
    //   697: aload_2
    //   698: astore 19
    //   700: aload 12
    //   702: astore 24
    //   704: aload_2
    //   705: astore 21
    //   707: aload 12
    //   709: astore 25
    //   711: aload 26
    //   713: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   716: ifne +661 -> 1377
    //   719: aload_2
    //   720: astore 14
    //   722: aload 12
    //   724: astore 18
    //   726: aload_2
    //   727: astore 15
    //   729: aload 12
    //   731: astore 20
    //   733: aload_2
    //   734: astore 16
    //   736: aload 12
    //   738: astore 22
    //   740: aload_2
    //   741: astore 17
    //   743: aload 12
    //   745: astore 23
    //   747: aload_2
    //   748: astore 19
    //   750: aload 12
    //   752: astore 24
    //   754: aload_2
    //   755: astore 21
    //   757: aload 12
    //   759: astore 25
    //   761: aload 27
    //   763: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   766: ifne +611 -> 1377
    //   769: aload_2
    //   770: astore 14
    //   772: aload 12
    //   774: astore 18
    //   776: aload_2
    //   777: astore 15
    //   779: aload 12
    //   781: astore 20
    //   783: aload_2
    //   784: astore 16
    //   786: aload 12
    //   788: astore 22
    //   790: aload_2
    //   791: astore 17
    //   793: aload 12
    //   795: astore 23
    //   797: aload_2
    //   798: astore 19
    //   800: aload 12
    //   802: astore 24
    //   804: aload_2
    //   805: astore 21
    //   807: aload 12
    //   809: astore 25
    //   811: aload 11
    //   813: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   816: ifne +561 -> 1377
    //   819: aload_2
    //   820: astore 14
    //   822: aload 12
    //   824: astore 18
    //   826: aload_2
    //   827: astore 15
    //   829: aload 12
    //   831: astore 20
    //   833: aload_2
    //   834: astore 16
    //   836: aload 12
    //   838: astore 22
    //   840: aload_2
    //   841: astore 17
    //   843: aload 12
    //   845: astore 23
    //   847: aload_2
    //   848: astore 19
    //   850: aload 12
    //   852: astore 24
    //   854: aload_2
    //   855: astore 21
    //   857: aload 12
    //   859: astore 25
    //   861: aload 12
    //   863: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   866: ifne +511 -> 1377
    //   869: aload_2
    //   870: astore 14
    //   872: aload 12
    //   874: astore 18
    //   876: aload_2
    //   877: astore 15
    //   879: aload 12
    //   881: astore 20
    //   883: aload_2
    //   884: astore 16
    //   886: aload 12
    //   888: astore 22
    //   890: aload_2
    //   891: astore 17
    //   893: aload 12
    //   895: astore 23
    //   897: aload_2
    //   898: astore 19
    //   900: aload 12
    //   902: astore 24
    //   904: aload_2
    //   905: astore 21
    //   907: aload 12
    //   909: astore 25
    //   911: aload 10
    //   913: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   916: ifne +461 -> 1377
    //   919: aload_2
    //   920: astore 14
    //   922: aload 12
    //   924: astore 18
    //   926: aload_2
    //   927: astore 15
    //   929: aload 12
    //   931: astore 20
    //   933: aload_2
    //   934: astore 16
    //   936: aload 12
    //   938: astore 22
    //   940: aload_2
    //   941: astore 17
    //   943: aload 12
    //   945: astore 23
    //   947: aload_2
    //   948: astore 19
    //   950: aload 12
    //   952: astore 24
    //   954: aload_2
    //   955: astore 21
    //   957: aload 12
    //   959: astore 25
    //   961: aload 28
    //   963: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   966: ifne +411 -> 1377
    //   969: aload_2
    //   970: astore 14
    //   972: aload 12
    //   974: astore 18
    //   976: aload_2
    //   977: astore 15
    //   979: aload 12
    //   981: astore 20
    //   983: aload_2
    //   984: astore 16
    //   986: aload 12
    //   988: astore 22
    //   990: aload_2
    //   991: astore 17
    //   993: aload 12
    //   995: astore 23
    //   997: aload_2
    //   998: astore 19
    //   1000: aload 12
    //   1002: astore 24
    //   1004: aload_2
    //   1005: astore 21
    //   1007: aload 12
    //   1009: astore 25
    //   1011: aload 26
    //   1013: invokestatic 2774	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1016: invokevirtual 1291	java/lang/Integer:intValue	()I
    //   1019: istore_3
    //   1020: aload 27
    //   1022: invokestatic 2774	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1025: invokevirtual 1291	java/lang/Integer:intValue	()I
    //   1028: istore 4
    //   1030: aload 28
    //   1032: invokestatic 2774	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1035: invokevirtual 1291	java/lang/Integer:intValue	()I
    //   1038: istore 7
    //   1040: iload_3
    //   1041: iflt +42 -> 1083
    //   1044: iload_3
    //   1045: iconst_1
    //   1046: if_icmpgt +37 -> 1083
    //   1049: iload 4
    //   1051: iflt +32 -> 1083
    //   1054: iload 4
    //   1056: iconst_1
    //   1057: if_icmpgt +26 -> 1083
    //   1060: iload 7
    //   1062: iflt +21 -> 1083
    //   1065: iload 7
    //   1067: iconst_1
    //   1068: if_icmpgt +15 -> 1083
    //   1071: iconst_1
    //   1072: istore 5
    //   1074: iload_3
    //   1075: istore 6
    //   1077: iload 7
    //   1079: istore_3
    //   1080: goto +308 -> 1388
    //   1083: iconst_0
    //   1084: istore 5
    //   1086: iload_3
    //   1087: istore 6
    //   1089: iload 7
    //   1091: istore_3
    //   1092: goto +296 -> 1388
    //   1095: astore 17
    //   1097: iload_3
    //   1098: istore 5
    //   1100: aload_2
    //   1101: astore 13
    //   1103: aload 11
    //   1105: astore 14
    //   1107: iload 4
    //   1109: istore 6
    //   1111: aload 12
    //   1113: astore 15
    //   1115: aload 10
    //   1117: astore 16
    //   1119: goto +487 -> 1606
    //   1122: astore 17
    //   1124: iload_3
    //   1125: istore 5
    //   1127: aload_2
    //   1128: astore 13
    //   1130: aload 11
    //   1132: astore 14
    //   1134: iload 4
    //   1136: istore 6
    //   1138: aload 12
    //   1140: astore 15
    //   1142: aload 10
    //   1144: astore 16
    //   1146: goto +593 -> 1739
    //   1149: astore 17
    //   1151: iload_3
    //   1152: istore 5
    //   1154: aload_2
    //   1155: astore 13
    //   1157: aload 11
    //   1159: astore 14
    //   1161: iload 4
    //   1163: istore 6
    //   1165: aload 12
    //   1167: astore 15
    //   1169: aload 10
    //   1171: astore 16
    //   1173: goto +671 -> 1844
    //   1176: astore 17
    //   1178: iload_3
    //   1179: istore 5
    //   1181: aload_2
    //   1182: astore 13
    //   1184: aload 11
    //   1186: astore 14
    //   1188: iload 4
    //   1190: istore 6
    //   1192: aload 12
    //   1194: astore 15
    //   1196: aload 10
    //   1198: astore 16
    //   1200: goto +749 -> 1949
    //   1203: astore 17
    //   1205: iload_3
    //   1206: istore 5
    //   1208: aload_2
    //   1209: astore 13
    //   1211: aload 11
    //   1213: astore 14
    //   1215: iload 4
    //   1217: istore 6
    //   1219: aload 12
    //   1221: astore 15
    //   1223: aload 10
    //   1225: astore 16
    //   1227: goto +827 -> 2054
    //   1230: astore 17
    //   1232: iload_3
    //   1233: istore 5
    //   1235: aload_2
    //   1236: astore 13
    //   1238: aload 11
    //   1240: astore 14
    //   1242: iload 4
    //   1244: istore 6
    //   1246: aload 12
    //   1248: astore 15
    //   1250: aload 10
    //   1252: astore 16
    //   1254: goto +905 -> 2159
    //   1257: astore 13
    //   1259: aload 12
    //   1261: astore 15
    //   1263: aload 11
    //   1265: astore 12
    //   1267: aload 13
    //   1269: astore 11
    //   1271: aload_2
    //   1272: astore 13
    //   1274: goto +314 -> 1588
    //   1277: astore 13
    //   1279: aload 12
    //   1281: astore 15
    //   1283: aload 11
    //   1285: astore 12
    //   1287: aload 13
    //   1289: astore 11
    //   1291: aload_2
    //   1292: astore 13
    //   1294: goto +427 -> 1721
    //   1297: astore 13
    //   1299: aload 12
    //   1301: astore 15
    //   1303: aload 11
    //   1305: astore 12
    //   1307: aload 13
    //   1309: astore 11
    //   1311: aload_2
    //   1312: astore 13
    //   1314: goto +512 -> 1826
    //   1317: astore 13
    //   1319: aload 12
    //   1321: astore 15
    //   1323: aload 11
    //   1325: astore 12
    //   1327: aload 13
    //   1329: astore 11
    //   1331: aload_2
    //   1332: astore 13
    //   1334: goto +597 -> 1931
    //   1337: astore 13
    //   1339: aload 12
    //   1341: astore 15
    //   1343: aload 11
    //   1345: astore 12
    //   1347: aload 13
    //   1349: astore 11
    //   1351: aload_2
    //   1352: astore 13
    //   1354: goto +682 -> 2036
    //   1357: astore 13
    //   1359: aload 12
    //   1361: astore 15
    //   1363: aload 11
    //   1365: astore 12
    //   1367: aload 13
    //   1369: astore 11
    //   1371: aload_2
    //   1372: astore 13
    //   1374: goto +767 -> 2141
    //   1377: iconst_0
    //   1378: istore 5
    //   1380: iconst_0
    //   1381: istore 6
    //   1383: iconst_0
    //   1384: istore_3
    //   1385: iconst_0
    //   1386: istore 4
    //   1388: aload_2
    //   1389: astore 13
    //   1391: aload 10
    //   1393: astore 14
    //   1395: aload 11
    //   1397: astore_2
    //   1398: aload 12
    //   1400: astore 10
    //   1402: aload 14
    //   1404: astore 11
    //   1406: aload 13
    //   1408: astore 12
    //   1410: goto +815 -> 2225
    //   1413: astore_2
    //   1414: aload 14
    //   1416: astore 13
    //   1418: aload 11
    //   1420: astore 12
    //   1422: aload 18
    //   1424: astore 11
    //   1426: goto +153 -> 1579
    //   1429: astore_2
    //   1430: aload 15
    //   1432: astore 13
    //   1434: aload 11
    //   1436: astore 12
    //   1438: aload 20
    //   1440: astore 11
    //   1442: goto +270 -> 1712
    //   1445: astore_2
    //   1446: aload 16
    //   1448: astore 13
    //   1450: aload 11
    //   1452: astore 12
    //   1454: aload 22
    //   1456: astore 11
    //   1458: goto +359 -> 1817
    //   1461: astore_2
    //   1462: aload 17
    //   1464: astore 13
    //   1466: aload 11
    //   1468: astore 12
    //   1470: aload 23
    //   1472: astore 11
    //   1474: goto +448 -> 1922
    //   1477: astore_2
    //   1478: aload 19
    //   1480: astore 13
    //   1482: aload 11
    //   1484: astore 12
    //   1486: aload 24
    //   1488: astore 11
    //   1490: goto +537 -> 2027
    //   1493: astore_2
    //   1494: aload 21
    //   1496: astore 13
    //   1498: aload 11
    //   1500: astore 12
    //   1502: aload 25
    //   1504: astore 11
    //   1506: goto +626 -> 2132
    //   1509: astore_2
    //   1510: aconst_null
    //   1511: astore 11
    //   1513: goto +66 -> 1579
    //   1516: astore_2
    //   1517: aconst_null
    //   1518: astore 11
    //   1520: aload 14
    //   1522: astore 12
    //   1524: goto +188 -> 1712
    //   1527: astore_2
    //   1528: aconst_null
    //   1529: astore 11
    //   1531: aload 15
    //   1533: astore 12
    //   1535: goto +282 -> 1817
    //   1538: astore_2
    //   1539: aconst_null
    //   1540: astore 11
    //   1542: aload 16
    //   1544: astore 12
    //   1546: goto +376 -> 1922
    //   1549: astore_2
    //   1550: aconst_null
    //   1551: astore 11
    //   1553: aload 17
    //   1555: astore 12
    //   1557: goto +470 -> 2027
    //   1560: astore_2
    //   1561: aconst_null
    //   1562: astore 11
    //   1564: aload 18
    //   1566: astore 12
    //   1568: goto +564 -> 2132
    //   1571: astore_2
    //   1572: aconst_null
    //   1573: astore 11
    //   1575: aload 11
    //   1577: astore 10
    //   1579: iconst_0
    //   1580: istore_3
    //   1581: aload 11
    //   1583: astore 15
    //   1585: aload_2
    //   1586: astore 11
    //   1588: iconst_0
    //   1589: istore 6
    //   1591: aload 10
    //   1593: astore 16
    //   1595: aload 12
    //   1597: astore 14
    //   1599: iload_3
    //   1600: istore 5
    //   1602: aload 11
    //   1604: astore 17
    //   1606: iload 5
    //   1608: istore 4
    //   1610: aload 13
    //   1612: astore 12
    //   1614: aload 14
    //   1616: astore_2
    //   1617: iload 6
    //   1619: istore_3
    //   1620: aload 15
    //   1622: astore 11
    //   1624: aload 16
    //   1626: astore 10
    //   1628: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1631: ifeq +38 -> 1669
    //   1634: ldc_w 3006
    //   1637: iconst_2
    //   1638: aload 17
    //   1640: iconst_0
    //   1641: anewarray 4	java/lang/Object
    //   1644: invokestatic 2558	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1647: aload 16
    //   1649: astore 10
    //   1651: aload 15
    //   1653: astore 11
    //   1655: iload 6
    //   1657: istore_3
    //   1658: aload 14
    //   1660: astore_2
    //   1661: aload 13
    //   1663: astore 12
    //   1665: iload 5
    //   1667: istore 4
    //   1669: aload 10
    //   1671: astore 13
    //   1673: iconst_0
    //   1674: istore 5
    //   1676: iconst_0
    //   1677: istore 7
    //   1679: iload 4
    //   1681: istore 6
    //   1683: iload_3
    //   1684: istore 4
    //   1686: aload 11
    //   1688: astore 10
    //   1690: iload 7
    //   1692: istore_3
    //   1693: aload 13
    //   1695: astore 11
    //   1697: goto +528 -> 2225
    //   1700: astore_2
    //   1701: aconst_null
    //   1702: astore 11
    //   1704: aload 11
    //   1706: astore 10
    //   1708: aload 14
    //   1710: astore 12
    //   1712: iconst_0
    //   1713: istore_3
    //   1714: aload 11
    //   1716: astore 15
    //   1718: aload_2
    //   1719: astore 11
    //   1721: iconst_0
    //   1722: istore 6
    //   1724: aload 10
    //   1726: astore 16
    //   1728: aload 12
    //   1730: astore 14
    //   1732: iload_3
    //   1733: istore 5
    //   1735: aload 11
    //   1737: astore 17
    //   1739: iload 5
    //   1741: istore 4
    //   1743: aload 13
    //   1745: astore 12
    //   1747: aload 14
    //   1749: astore_2
    //   1750: iload 6
    //   1752: istore_3
    //   1753: aload 15
    //   1755: astore 11
    //   1757: aload 16
    //   1759: astore 10
    //   1761: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1764: ifeq -95 -> 1669
    //   1767: ldc_w 3006
    //   1770: iconst_2
    //   1771: aload 17
    //   1773: iconst_0
    //   1774: anewarray 4	java/lang/Object
    //   1777: invokestatic 2558	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1780: iload 5
    //   1782: istore 4
    //   1784: aload 13
    //   1786: astore 12
    //   1788: aload 14
    //   1790: astore_2
    //   1791: iload 6
    //   1793: istore_3
    //   1794: aload 15
    //   1796: astore 11
    //   1798: aload 16
    //   1800: astore 10
    //   1802: goto -133 -> 1669
    //   1805: astore_2
    //   1806: aconst_null
    //   1807: astore 11
    //   1809: aload 11
    //   1811: astore 10
    //   1813: aload 15
    //   1815: astore 12
    //   1817: iconst_0
    //   1818: istore_3
    //   1819: aload 11
    //   1821: astore 15
    //   1823: aload_2
    //   1824: astore 11
    //   1826: iconst_0
    //   1827: istore 6
    //   1829: aload 10
    //   1831: astore 16
    //   1833: aload 12
    //   1835: astore 14
    //   1837: iload_3
    //   1838: istore 5
    //   1840: aload 11
    //   1842: astore 17
    //   1844: iload 5
    //   1846: istore 4
    //   1848: aload 13
    //   1850: astore 12
    //   1852: aload 14
    //   1854: astore_2
    //   1855: iload 6
    //   1857: istore_3
    //   1858: aload 15
    //   1860: astore 11
    //   1862: aload 16
    //   1864: astore 10
    //   1866: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1869: ifeq -200 -> 1669
    //   1872: ldc_w 3006
    //   1875: iconst_2
    //   1876: aload 17
    //   1878: iconst_0
    //   1879: anewarray 4	java/lang/Object
    //   1882: invokestatic 2558	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1885: iload 5
    //   1887: istore 4
    //   1889: aload 13
    //   1891: astore 12
    //   1893: aload 14
    //   1895: astore_2
    //   1896: iload 6
    //   1898: istore_3
    //   1899: aload 15
    //   1901: astore 11
    //   1903: aload 16
    //   1905: astore 10
    //   1907: goto -238 -> 1669
    //   1910: astore_2
    //   1911: aconst_null
    //   1912: astore 11
    //   1914: aload 11
    //   1916: astore 10
    //   1918: aload 16
    //   1920: astore 12
    //   1922: iconst_0
    //   1923: istore_3
    //   1924: aload 11
    //   1926: astore 15
    //   1928: aload_2
    //   1929: astore 11
    //   1931: iconst_0
    //   1932: istore 6
    //   1934: aload 10
    //   1936: astore 16
    //   1938: aload 12
    //   1940: astore 14
    //   1942: iload_3
    //   1943: istore 5
    //   1945: aload 11
    //   1947: astore 17
    //   1949: iload 5
    //   1951: istore 4
    //   1953: aload 13
    //   1955: astore 12
    //   1957: aload 14
    //   1959: astore_2
    //   1960: iload 6
    //   1962: istore_3
    //   1963: aload 15
    //   1965: astore 11
    //   1967: aload 16
    //   1969: astore 10
    //   1971: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1974: ifeq -305 -> 1669
    //   1977: ldc_w 3006
    //   1980: iconst_2
    //   1981: aload 17
    //   1983: iconst_0
    //   1984: anewarray 4	java/lang/Object
    //   1987: invokestatic 2558	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1990: iload 5
    //   1992: istore 4
    //   1994: aload 13
    //   1996: astore 12
    //   1998: aload 14
    //   2000: astore_2
    //   2001: iload 6
    //   2003: istore_3
    //   2004: aload 15
    //   2006: astore 11
    //   2008: aload 16
    //   2010: astore 10
    //   2012: goto -343 -> 1669
    //   2015: astore_2
    //   2016: aconst_null
    //   2017: astore 11
    //   2019: aload 11
    //   2021: astore 10
    //   2023: aload 17
    //   2025: astore 12
    //   2027: iconst_0
    //   2028: istore_3
    //   2029: aload 11
    //   2031: astore 15
    //   2033: aload_2
    //   2034: astore 11
    //   2036: iconst_0
    //   2037: istore 6
    //   2039: aload 10
    //   2041: astore 16
    //   2043: aload 12
    //   2045: astore 14
    //   2047: iload_3
    //   2048: istore 5
    //   2050: aload 11
    //   2052: astore 17
    //   2054: iload 5
    //   2056: istore 4
    //   2058: aload 13
    //   2060: astore 12
    //   2062: aload 14
    //   2064: astore_2
    //   2065: iload 6
    //   2067: istore_3
    //   2068: aload 15
    //   2070: astore 11
    //   2072: aload 16
    //   2074: astore 10
    //   2076: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2079: ifeq -410 -> 1669
    //   2082: ldc_w 3006
    //   2085: iconst_2
    //   2086: aload 17
    //   2088: iconst_0
    //   2089: anewarray 4	java/lang/Object
    //   2092: invokestatic 2558	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2095: iload 5
    //   2097: istore 4
    //   2099: aload 13
    //   2101: astore 12
    //   2103: aload 14
    //   2105: astore_2
    //   2106: iload 6
    //   2108: istore_3
    //   2109: aload 15
    //   2111: astore 11
    //   2113: aload 16
    //   2115: astore 10
    //   2117: goto -448 -> 1669
    //   2120: astore_2
    //   2121: aconst_null
    //   2122: astore 11
    //   2124: aload 11
    //   2126: astore 10
    //   2128: aload 18
    //   2130: astore 12
    //   2132: iconst_0
    //   2133: istore_3
    //   2134: aload 11
    //   2136: astore 15
    //   2138: aload_2
    //   2139: astore 11
    //   2141: iconst_0
    //   2142: istore 6
    //   2144: aload 10
    //   2146: astore 16
    //   2148: aload 12
    //   2150: astore 14
    //   2152: iload_3
    //   2153: istore 5
    //   2155: aload 11
    //   2157: astore 17
    //   2159: iload 5
    //   2161: istore 4
    //   2163: aload 13
    //   2165: astore 12
    //   2167: aload 14
    //   2169: astore_2
    //   2170: iload 6
    //   2172: istore_3
    //   2173: aload 15
    //   2175: astore 11
    //   2177: aload 16
    //   2179: astore 10
    //   2181: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2184: ifeq -515 -> 1669
    //   2187: ldc_w 3006
    //   2190: iconst_2
    //   2191: aload 17
    //   2193: iconst_0
    //   2194: anewarray 4	java/lang/Object
    //   2197: invokestatic 2558	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2200: iload 5
    //   2202: istore 4
    //   2204: aload 13
    //   2206: astore 12
    //   2208: aload 14
    //   2210: astore_2
    //   2211: iload 6
    //   2213: istore_3
    //   2214: aload 15
    //   2216: astore 11
    //   2218: aload 16
    //   2220: astore 10
    //   2222: goto -553 -> 1669
    //   2225: iload 5
    //   2227: ifeq +144 -> 2371
    //   2230: invokestatic 3025	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:a	()Lcom/tencent/mobileqq/activity/aio/qim/QIMUserManager;
    //   2233: aload_1
    //   2234: invokevirtual 3028	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   2237: astore 13
    //   2239: invokestatic 3025	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:a	()Lcom/tencent/mobileqq/activity/aio/qim/QIMUserManager;
    //   2242: aload_1
    //   2243: invokevirtual 3030	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   2246: astore 14
    //   2248: aload 13
    //   2250: aload_2
    //   2251: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2254: ifeq +22 -> 2276
    //   2257: aload 14
    //   2259: aload 10
    //   2261: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2264: ifne +6 -> 2270
    //   2267: goto +9 -> 2276
    //   2270: iconst_0
    //   2271: istore 9
    //   2273: goto +6 -> 2279
    //   2276: iconst_1
    //   2277: istore 9
    //   2279: invokestatic 3025	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:a	()Lcom/tencent/mobileqq/activity/aio/qim/QIMUserManager;
    //   2282: iload 6
    //   2284: iload 4
    //   2286: aload_2
    //   2287: aload 12
    //   2289: aload 10
    //   2291: aload 11
    //   2293: iload 9
    //   2295: iload_3
    //   2296: invokevirtual 3033	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:a	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   2299: aload_1
    //   2300: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2303: aload_1
    //   2304: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2307: iload 8
    //   2309: iload 6
    //   2311: iload 4
    //   2313: aload_2
    //   2314: aload 10
    //   2316: aload 12
    //   2318: aload 11
    //   2320: iload 9
    //   2322: iload_3
    //   2323: invokestatic 3036	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   2326: return
    //   2327: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2330: ifeq +41 -> 2371
    //   2333: new 77	java/lang/StringBuilder
    //   2336: dup
    //   2337: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   2340: astore_1
    //   2341: aload_1
    //   2342: ldc_w 3038
    //   2345: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2348: pop
    //   2349: aload_1
    //   2350: aload_2
    //   2351: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2354: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2357: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2360: pop
    //   2361: ldc 91
    //   2363: iconst_2
    //   2364: aload_1
    //   2365: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2368: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2371: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2372	0	this	ConfigServlet
    //   0	2372	1	paramQQAppInterface	QQAppInterface
    //   0	2372	2	paramConfig	ConfigurationService.Config
    //   20	2303	3	i	int
    //   32	2280	4	j	int
    //   37	2189	5	k	int
    //   1075	1235	6	m	int
    //   1038	653	7	n	int
    //   7	2301	8	i1	int
    //   2271	50	9	bool	boolean
    //   128	2187	10	localObject1	Object
    //   356	1963	11	localObject2	Object
    //   173	2144	12	localObject3	Object
    //   155	1082	13	localObject4	Object
    //   1257	11	13	localNullPointerException1	java.lang.NullPointerException
    //   1272	1	13	localConfig1	ConfigurationService.Config
    //   1277	11	13	localSAXException1	SAXException
    //   1292	1	13	localConfig2	ConfigurationService.Config
    //   1297	11	13	localIOException1	IOException
    //   1312	1	13	localConfig3	ConfigurationService.Config
    //   1317	11	13	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   1332	1	13	localConfig4	ConfigurationService.Config
    //   1337	11	13	localNumberFormatException1	java.lang.NumberFormatException
    //   1352	1	13	localConfig5	ConfigurationService.Config
    //   1357	11	13	localParserConfigurationException1	ParserConfigurationException
    //   1372	877	13	localObject5	Object
    //   176	2082	14	localObject6	Object
    //   179	2036	15	localObject7	Object
    //   182	2037	16	localObject8	Object
    //   185	807	17	localObject9	Object
    //   1095	1	17	localNullPointerException2	java.lang.NullPointerException
    //   1122	1	17	localSAXException2	SAXException
    //   1149	1	17	localIOException2	IOException
    //   1176	1	17	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   1203	1	17	localNumberFormatException2	java.lang.NumberFormatException
    //   1230	324	17	localParserConfigurationException2	ParserConfigurationException
    //   1604	588	17	localObject10	Object
    //   188	1941	18	localObject11	Object
    //   379	1100	19	localObject12	Object
    //   158	1281	20	localObject13	Object
    //   383	1112	21	localObject14	Object
    //   161	1294	22	localObject15	Object
    //   164	1307	23	localObject16	Object
    //   167	1320	24	localObject17	Object
    //   170	1333	25	localObject18	Object
    //   244	768	26	str1	String
    //   272	749	27	str2	String
    //   300	731	28	str3	String
    //   216	446	29	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   1030	1040	1095	java/lang/NullPointerException
    //   1030	1040	1122	org/xml/sax/SAXException
    //   1030	1040	1149	java/io/IOException
    //   1030	1040	1176	java/io/UnsupportedEncodingException
    //   1030	1040	1203	java/lang/NumberFormatException
    //   1030	1040	1230	javax/xml/parsers/ParserConfigurationException
    //   1020	1030	1257	java/lang/NullPointerException
    //   1020	1030	1277	org/xml/sax/SAXException
    //   1020	1030	1297	java/io/IOException
    //   1020	1030	1317	java/io/UnsupportedEncodingException
    //   1020	1030	1337	java/lang/NumberFormatException
    //   1020	1030	1357	javax/xml/parsers/ParserConfigurationException
    //   385	413	1413	java/lang/NullPointerException
    //   461	473	1413	java/lang/NullPointerException
    //   532	542	1413	java/lang/NullPointerException
    //   590	605	1413	java/lang/NullPointerException
    //   661	669	1413	java/lang/NullPointerException
    //   711	719	1413	java/lang/NullPointerException
    //   761	769	1413	java/lang/NullPointerException
    //   811	819	1413	java/lang/NullPointerException
    //   861	869	1413	java/lang/NullPointerException
    //   911	919	1413	java/lang/NullPointerException
    //   961	969	1413	java/lang/NullPointerException
    //   1011	1020	1413	java/lang/NullPointerException
    //   385	413	1429	org/xml/sax/SAXException
    //   461	473	1429	org/xml/sax/SAXException
    //   532	542	1429	org/xml/sax/SAXException
    //   590	605	1429	org/xml/sax/SAXException
    //   661	669	1429	org/xml/sax/SAXException
    //   711	719	1429	org/xml/sax/SAXException
    //   761	769	1429	org/xml/sax/SAXException
    //   811	819	1429	org/xml/sax/SAXException
    //   861	869	1429	org/xml/sax/SAXException
    //   911	919	1429	org/xml/sax/SAXException
    //   961	969	1429	org/xml/sax/SAXException
    //   1011	1020	1429	org/xml/sax/SAXException
    //   385	413	1445	java/io/IOException
    //   461	473	1445	java/io/IOException
    //   532	542	1445	java/io/IOException
    //   590	605	1445	java/io/IOException
    //   661	669	1445	java/io/IOException
    //   711	719	1445	java/io/IOException
    //   761	769	1445	java/io/IOException
    //   811	819	1445	java/io/IOException
    //   861	869	1445	java/io/IOException
    //   911	919	1445	java/io/IOException
    //   961	969	1445	java/io/IOException
    //   1011	1020	1445	java/io/IOException
    //   385	413	1461	java/io/UnsupportedEncodingException
    //   461	473	1461	java/io/UnsupportedEncodingException
    //   532	542	1461	java/io/UnsupportedEncodingException
    //   590	605	1461	java/io/UnsupportedEncodingException
    //   661	669	1461	java/io/UnsupportedEncodingException
    //   711	719	1461	java/io/UnsupportedEncodingException
    //   761	769	1461	java/io/UnsupportedEncodingException
    //   811	819	1461	java/io/UnsupportedEncodingException
    //   861	869	1461	java/io/UnsupportedEncodingException
    //   911	919	1461	java/io/UnsupportedEncodingException
    //   961	969	1461	java/io/UnsupportedEncodingException
    //   1011	1020	1461	java/io/UnsupportedEncodingException
    //   385	413	1477	java/lang/NumberFormatException
    //   461	473	1477	java/lang/NumberFormatException
    //   532	542	1477	java/lang/NumberFormatException
    //   590	605	1477	java/lang/NumberFormatException
    //   661	669	1477	java/lang/NumberFormatException
    //   711	719	1477	java/lang/NumberFormatException
    //   761	769	1477	java/lang/NumberFormatException
    //   811	819	1477	java/lang/NumberFormatException
    //   861	869	1477	java/lang/NumberFormatException
    //   911	919	1477	java/lang/NumberFormatException
    //   961	969	1477	java/lang/NumberFormatException
    //   1011	1020	1477	java/lang/NumberFormatException
    //   385	413	1493	javax/xml/parsers/ParserConfigurationException
    //   461	473	1493	javax/xml/parsers/ParserConfigurationException
    //   532	542	1493	javax/xml/parsers/ParserConfigurationException
    //   590	605	1493	javax/xml/parsers/ParserConfigurationException
    //   661	669	1493	javax/xml/parsers/ParserConfigurationException
    //   711	719	1493	javax/xml/parsers/ParserConfigurationException
    //   761	769	1493	javax/xml/parsers/ParserConfigurationException
    //   811	819	1493	javax/xml/parsers/ParserConfigurationException
    //   861	869	1493	javax/xml/parsers/ParserConfigurationException
    //   911	919	1493	javax/xml/parsers/ParserConfigurationException
    //   961	969	1493	javax/xml/parsers/ParserConfigurationException
    //   1011	1020	1493	javax/xml/parsers/ParserConfigurationException
    //   330	358	1509	java/lang/NullPointerException
    //   330	358	1516	org/xml/sax/SAXException
    //   330	358	1527	java/io/IOException
    //   330	358	1538	java/io/UnsupportedEncodingException
    //   330	358	1549	java/lang/NumberFormatException
    //   330	358	1560	javax/xml/parsers/ParserConfigurationException
    //   192	330	1571	java/lang/NullPointerException
    //   192	330	1700	org/xml/sax/SAXException
    //   192	330	1805	java/io/IOException
    //   192	330	1910	java/io/UnsupportedEncodingException
    //   192	330	2015	java/lang/NumberFormatException
    //   192	330	2120	javax/xml/parsers/ParserConfigurationException
  }
  
  private void av(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int k = paramConfig.version.get();
    int i = SharedPreUtils.aq(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int j = SharedPreUtils.ar(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int m = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, String.format("received TimUserSpecial remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m) }));
    }
    if (j != m)
    {
      SharedPreUtils.J(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), m);
      i = 0;
    }
    Object localObject1;
    if (k != i)
    {
      localObject1 = a(paramConfig);
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {}
    }
    for (;;)
    {
      try
      {
        paramConfig = new JSONObject((String)((List)localObject1).get(0));
        if (!paramConfig.has("TIMPersonality")) {
          break label467;
        }
        paramConfig = paramConfig.getJSONObject("TIMPersonality");
        if (!paramConfig.has("aioTitleBgSwitch")) {
          break label448;
        }
        j = paramConfig.getInt("aioTitleBgSwitch");
        i = 1;
        if (!paramConfig.has("androidResourceURL")) {
          break label456;
        }
        localObject1 = paramConfig.getString("androidResourceURL");
        if (!paramConfig.has("androidMD5")) {
          break label462;
        }
        paramConfig = paramConfig.getString("androidMD5");
        if ((i == 0) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramConfig))) {
          break label447;
        }
        localObject2 = TIMUserManager.a().a(paramQQAppInterface);
        String str = TIMUserManager.a().b(paramQQAppInterface);
        if (!((String)localObject2).equals(localObject1)) {
          break label486;
        }
        if (str.equals(paramConfig)) {
          break label480;
        }
      }
      catch (JSONException paramQQAppInterface) {}
      TIMUserManager.a().a(0, j, (String)localObject1, "", paramConfig, "", bool, 0);
      Object localObject2 = paramQQAppInterface.getApp();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      try
      {
        SharedPreUtils.b((Context)localObject2, paramQQAppInterface, k, 0, j, (String)localObject1, paramConfig, "", "", bool, 0);
        return;
      }
      catch (JSONException paramQQAppInterface) {}
      if (QLog.isColorLevel())
      {
        paramConfig = new StringBuilder();
        paramConfig.append("receiveAllConfigs|type: 256 exception =");
        paramConfig.append(paramQQAppInterface.toString());
        QLog.d("SPLASH_ConfigServlet", 2, paramConfig.toString());
        return;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 256,configStrList is empty ,version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
        }
      }
      label447:
      return;
      label448:
      i = 0;
      j = 0;
      continue;
      label456:
      localObject1 = null;
      continue;
      label462:
      paramConfig = null;
      continue;
      label467:
      paramConfig = null;
      localObject1 = paramConfig;
      i = 0;
      j = 0;
      continue;
      label480:
      boolean bool = false;
      continue;
      label486:
      bool = true;
    }
  }
  
  /* Error */
  private void aw(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: istore 34
    //   9: aload_1
    //   10: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: aload_1
    //   14: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   17: invokestatic 1190	com/tencent/mobileqq/utils/SharedPreUtils:A	(Landroid/content/Context;Ljava/lang/String;)I
    //   20: istore_3
    //   21: aload_1
    //   22: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: aload_1
    //   26: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokestatic 1195	com/tencent/mobileqq/utils/SharedPreUtils:w	(Landroid/content/Context;Ljava/lang/String;)I
    //   32: istore 4
    //   34: invokestatic 1198	com/tencent/common/config/AppSetting:a	()I
    //   37: istore 5
    //   39: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: istore 35
    //   44: ldc_w 3070
    //   47: astore 55
    //   49: iload 35
    //   51: ifeq +51 -> 102
    //   54: ldc_w 3070
    //   57: iconst_2
    //   58: ldc_w 3072
    //   61: iconst_4
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: iload 34
    //   69: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: iload_3
    //   76: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: iload 4
    //   84: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: aastore
    //   88: dup
    //   89: iconst_3
    //   90: iload 5
    //   92: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: invokestatic 549	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   99: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: iload 4
    //   104: iload 5
    //   106: if_icmpeq +18 -> 124
    //   109: aload_1
    //   110: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   113: aload_1
    //   114: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   117: iload 5
    //   119: invokestatic 3074	com/tencent/mobileqq/utils/SharedPreUtils:i	(Landroid/content/Context;Ljava/lang/String;I)V
    //   122: iconst_0
    //   123: istore_3
    //   124: iload 34
    //   126: iload_3
    //   127: if_icmpeq +3621 -> 3748
    //   130: aload_2
    //   131: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   134: astore 43
    //   136: ldc 91
    //   138: astore 42
    //   140: aload 43
    //   142: ifnull +3562 -> 3704
    //   145: aload_2
    //   146: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   149: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   152: ifle +3552 -> 3704
    //   155: aload_2
    //   156: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   159: invokevirtual 1046	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   162: astore 43
    //   164: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +38 -> 205
    //   170: ldc 91
    //   172: iconst_2
    //   173: ldc_w 3076
    //   176: iconst_2
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_2
    //   183: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   186: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   189: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: ldc_w 3078
    //   198: aastore
    //   199: invokestatic 549	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   202: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload 43
    //   207: invokeinterface 114 1 0
    //   212: astore 58
    //   214: iconst_0
    //   215: istore 33
    //   217: aload 58
    //   219: invokeinterface 119 1 0
    //   224: ifeq +3524 -> 3748
    //   227: aload 58
    //   229: invokeinterface 123 1 0
    //   234: checkcast 125	java/lang/String
    //   237: astore 43
    //   239: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +84 -> 326
    //   245: new 77	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   252: astore 44
    //   254: aload 44
    //   256: ldc_w 3080
    //   259: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 44
    //   265: aload 43
    //   267: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 44
    //   273: ldc_w 472
    //   276: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 44
    //   282: aload_2
    //   283: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   286: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   289: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 44
    //   295: ldc_w 3082
    //   298: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 44
    //   304: aload_2
    //   305: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   308: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   311: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 42
    //   317: iconst_2
    //   318: aload 44
    //   320: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: aconst_null
    //   327: astore 46
    //   329: aconst_null
    //   330: astore 48
    //   332: aconst_null
    //   333: astore 49
    //   335: aload 43
    //   337: ldc_w 3084
    //   340: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   343: astore 56
    //   345: aload 56
    //   347: ifnull +2438 -> 2785
    //   350: aload 56
    //   352: arraylength
    //   353: istore 32
    //   355: ldc 8
    //   357: astore 45
    //   359: aload 45
    //   361: astore 43
    //   363: aconst_null
    //   364: astore 47
    //   366: aload 47
    //   368: astore 44
    //   370: aload 44
    //   372: astore 46
    //   374: aload 46
    //   376: astore 50
    //   378: iconst_0
    //   379: istore 24
    //   381: iconst_0
    //   382: istore 20
    //   384: iconst_0
    //   385: istore 8
    //   387: iconst_0
    //   388: istore 6
    //   390: iconst_0
    //   391: istore 4
    //   393: iconst_0
    //   394: istore 25
    //   396: iconst_m1
    //   397: istore 9
    //   399: iconst_m1
    //   400: istore 7
    //   402: iconst_m1
    //   403: istore 5
    //   405: iconst_m1
    //   406: istore_3
    //   407: iconst_0
    //   408: istore 19
    //   410: iconst_0
    //   411: istore 22
    //   413: iconst_0
    //   414: istore 23
    //   416: iconst_0
    //   417: istore 18
    //   419: iconst_0
    //   420: istore 14
    //   422: iconst_0
    //   423: istore 13
    //   425: ldc2_w 3085
    //   428: lstore 36
    //   430: iconst_0
    //   431: istore 11
    //   433: iconst_0
    //   434: istore 10
    //   436: bipush 50
    //   438: istore 21
    //   440: iconst_0
    //   441: istore 17
    //   443: iconst_0
    //   444: istore 16
    //   446: aload 49
    //   448: astore 48
    //   450: iload 33
    //   452: iload 32
    //   454: if_icmpge +2328 -> 2782
    //   457: aload 56
    //   459: iload 33
    //   461: aaload
    //   462: astore 57
    //   464: iload 14
    //   466: istore 15
    //   468: lload 36
    //   470: lstore 40
    //   472: aload 57
    //   474: ldc_w 3088
    //   477: invokevirtual 2321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   480: istore 35
    //   482: iload 35
    //   484: ifeq +94 -> 578
    //   487: iload 14
    //   489: istore 15
    //   491: lload 36
    //   493: lstore 40
    //   495: aload 57
    //   497: ldc_w 479
    //   500: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   503: iconst_1
    //   504: aaload
    //   505: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   508: astore 49
    //   510: iload 14
    //   512: istore 15
    //   514: lload 36
    //   516: lstore 40
    //   518: aload 49
    //   520: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   523: istore 35
    //   525: iload 17
    //   527: istore 12
    //   529: iload 16
    //   531: istore 26
    //   533: iload 35
    //   535: ifne +3214 -> 3749
    //   538: aload 49
    //   540: invokestatic 849	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   543: istore 26
    //   545: iload 17
    //   547: istore 12
    //   549: goto +3200 -> 3749
    //   552: astore 49
    //   554: iload 14
    //   556: istore 15
    //   558: lload 36
    //   560: lstore 40
    //   562: aload 49
    //   564: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   567: iload 17
    //   569: istore 12
    //   571: iload 16
    //   573: istore 26
    //   575: goto +3174 -> 3749
    //   578: iload 14
    //   580: istore 15
    //   582: lload 36
    //   584: lstore 40
    //   586: aload 57
    //   588: ldc_w 3090
    //   591: invokevirtual 2321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   594: ifeq +94 -> 688
    //   597: iload 14
    //   599: istore 15
    //   601: lload 36
    //   603: lstore 40
    //   605: aload 57
    //   607: ldc_w 479
    //   610: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   613: iconst_1
    //   614: aaload
    //   615: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   618: astore 49
    //   620: iload 14
    //   622: istore 15
    //   624: lload 36
    //   626: lstore 40
    //   628: aload 49
    //   630: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   633: istore 35
    //   635: iload 17
    //   637: istore 12
    //   639: iload 16
    //   641: istore 26
    //   643: iload 35
    //   645: ifne +3104 -> 3749
    //   648: aload 49
    //   650: invokestatic 849	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   653: istore 12
    //   655: iload 16
    //   657: istore 26
    //   659: goto +3090 -> 3749
    //   662: astore 49
    //   664: iload 14
    //   666: istore 15
    //   668: lload 36
    //   670: lstore 40
    //   672: aload 49
    //   674: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   677: iload 17
    //   679: istore 12
    //   681: iload 16
    //   683: istore 26
    //   685: goto +3064 -> 3749
    //   688: iload 14
    //   690: istore 15
    //   692: lload 36
    //   694: lstore 40
    //   696: aload 57
    //   698: ldc_w 3092
    //   701: invokevirtual 2321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   704: istore 35
    //   706: iload 35
    //   708: ifeq +536 -> 1244
    //   711: aload 47
    //   713: astore 51
    //   715: aload 44
    //   717: astore 52
    //   719: aload 48
    //   721: astore 53
    //   723: aload 46
    //   725: astore 54
    //   727: iload 11
    //   729: istore 12
    //   731: iload 10
    //   733: istore 15
    //   735: new 127	org/json/JSONObject
    //   738: dup
    //   739: aload 57
    //   741: ldc_w 479
    //   744: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   747: iconst_1
    //   748: aaload
    //   749: invokespecial 130	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   752: astore 59
    //   754: aload 47
    //   756: astore 51
    //   758: aload 44
    //   760: astore 52
    //   762: aload 48
    //   764: astore 53
    //   766: aload 46
    //   768: astore 54
    //   770: iload 11
    //   772: istore 12
    //   774: iload 10
    //   776: istore 15
    //   778: aload 59
    //   780: ldc_w 3094
    //   783: invokevirtual 607	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   786: astore 49
    //   788: aload 47
    //   790: astore 51
    //   792: aload 44
    //   794: astore 52
    //   796: aload 48
    //   798: astore 53
    //   800: aload 49
    //   802: astore 54
    //   804: iload 11
    //   806: istore 12
    //   808: iload 10
    //   810: istore 15
    //   812: aload 59
    //   814: ldc_w 3096
    //   817: invokevirtual 607	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   820: astore 48
    //   822: aload 47
    //   824: astore 51
    //   826: aload 44
    //   828: astore 52
    //   830: aload 48
    //   832: astore 53
    //   834: aload 49
    //   836: astore 54
    //   838: iload 11
    //   840: istore 12
    //   842: iload 10
    //   844: istore 15
    //   846: aload 59
    //   848: ldc_w 3098
    //   851: invokevirtual 607	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   854: astore 57
    //   856: aload 59
    //   858: ldc_w 3100
    //   861: invokevirtual 607	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   864: astore 47
    //   866: aload 57
    //   868: iconst_1
    //   869: aload 57
    //   871: invokevirtual 2172	java/lang/String:length	()I
    //   874: iconst_1
    //   875: isub
    //   876: invokevirtual 3102	java/lang/String:substring	(II)Ljava/lang/String;
    //   879: astore 46
    //   881: aload 47
    //   883: iconst_1
    //   884: aload 47
    //   886: invokevirtual 2172	java/lang/String:length	()I
    //   889: iconst_1
    //   890: isub
    //   891: invokevirtual 3102	java/lang/String:substring	(II)Ljava/lang/String;
    //   894: astore 44
    //   896: aload 46
    //   898: astore 51
    //   900: aload 44
    //   902: astore 52
    //   904: aload 48
    //   906: astore 53
    //   908: aload 49
    //   910: astore 54
    //   912: iload 11
    //   914: istore 12
    //   916: iload 10
    //   918: istore 15
    //   920: aload 59
    //   922: ldc_w 3104
    //   925: invokevirtual 217	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   928: istore 11
    //   930: aload 46
    //   932: astore 51
    //   934: aload 44
    //   936: astore 52
    //   938: aload 48
    //   940: astore 53
    //   942: aload 49
    //   944: astore 54
    //   946: iload 11
    //   948: istore 12
    //   950: iload 10
    //   952: istore 15
    //   954: aload 59
    //   956: ldc_w 3106
    //   959: invokevirtual 217	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   962: istore 10
    //   964: aload 46
    //   966: astore 51
    //   968: aload 44
    //   970: astore 52
    //   972: aload 48
    //   974: astore 53
    //   976: aload 49
    //   978: astore 54
    //   980: iload 11
    //   982: istore 12
    //   984: iload 10
    //   986: istore 15
    //   988: aload 59
    //   990: ldc_w 3108
    //   993: invokevirtual 217	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   996: istore 26
    //   998: iconst_1
    //   999: istore 24
    //   1001: aload 46
    //   1003: astore 47
    //   1005: aload 49
    //   1007: astore 46
    //   1009: iload 8
    //   1011: istore 27
    //   1013: iload 6
    //   1015: istore 28
    //   1017: iload 9
    //   1019: istore 15
    //   1021: iload 5
    //   1023: istore 29
    //   1025: iload 14
    //   1027: istore 30
    //   1029: iload 13
    //   1031: istore 31
    //   1033: iload 26
    //   1035: istore 21
    //   1037: goto +1470 -> 2507
    //   1040: astore 51
    //   1042: aload 47
    //   1044: astore 44
    //   1046: aload 48
    //   1048: astore 47
    //   1050: aload 49
    //   1052: astore 48
    //   1054: goto +59 -> 1113
    //   1057: astore 51
    //   1059: aload 47
    //   1061: astore 44
    //   1063: goto +5 -> 1068
    //   1066: astore 51
    //   1068: aload 57
    //   1070: astore 46
    //   1072: aload 48
    //   1074: astore 47
    //   1076: aload 49
    //   1078: astore 48
    //   1080: goto +33 -> 1113
    //   1083: astore 49
    //   1085: iload 15
    //   1087: istore 10
    //   1089: iload 12
    //   1091: istore 11
    //   1093: aload 54
    //   1095: astore 48
    //   1097: aload 53
    //   1099: astore 47
    //   1101: aload 52
    //   1103: astore 44
    //   1105: aload 51
    //   1107: astore 46
    //   1109: aload 49
    //   1111: astore 51
    //   1113: aload 51
    //   1115: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   1118: aload 48
    //   1120: astore 49
    //   1122: aload 47
    //   1124: astore 48
    //   1126: aload 46
    //   1128: astore 47
    //   1130: aload 49
    //   1132: astore 46
    //   1134: iload 8
    //   1136: istore 27
    //   1138: iload 6
    //   1140: istore 28
    //   1142: iload 9
    //   1144: istore 15
    //   1146: iload 5
    //   1148: istore 29
    //   1150: iload 14
    //   1152: istore 30
    //   1154: iload 13
    //   1156: istore 31
    //   1158: goto +1349 -> 2507
    //   1161: astore 51
    //   1163: aload 48
    //   1165: astore 52
    //   1167: aload 43
    //   1169: astore 49
    //   1171: aload 47
    //   1173: astore 48
    //   1175: aload 51
    //   1177: astore 43
    //   1179: iload 9
    //   1181: istore 15
    //   1183: aload 46
    //   1185: astore 47
    //   1187: aload 44
    //   1189: astore 51
    //   1191: iload 24
    //   1193: istore 26
    //   1195: aload 52
    //   1197: astore 46
    //   1199: iload 20
    //   1201: istore 24
    //   1203: iload 8
    //   1205: istore 20
    //   1207: iload 6
    //   1209: istore 9
    //   1211: iload 4
    //   1213: istore 6
    //   1215: iload 5
    //   1217: istore 8
    //   1219: iload_3
    //   1220: istore 5
    //   1222: aload 50
    //   1224: astore 44
    //   1226: iload 19
    //   1228: istore_3
    //   1229: iload 22
    //   1231: istore 19
    //   1233: iload 23
    //   1235: istore 4
    //   1237: iload 14
    //   1239: istore 12
    //   1241: goto +1817 -> 3058
    //   1244: iload 14
    //   1246: istore 12
    //   1248: lload 36
    //   1250: lstore 38
    //   1252: iload 14
    //   1254: istore 15
    //   1256: lload 36
    //   1258: lstore 40
    //   1260: aload 57
    //   1262: ldc_w 3110
    //   1265: invokevirtual 2321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1268: ifeq +35 -> 1303
    //   1271: iload 14
    //   1273: istore 15
    //   1275: lload 36
    //   1277: lstore 40
    //   1279: aload 57
    //   1281: ldc_w 479
    //   1284: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1287: iconst_1
    //   1288: aaload
    //   1289: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   1292: invokestatic 3113	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1295: invokevirtual 3116	java/lang/Long:longValue	()J
    //   1298: lstore 38
    //   1300: iconst_1
    //   1301: istore 12
    //   1303: iload 12
    //   1305: istore 15
    //   1307: lload 38
    //   1309: lstore 40
    //   1311: aload 57
    //   1313: ldc_w 3118
    //   1316: invokevirtual 2321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1319: ifeq +36 -> 1355
    //   1322: iload 12
    //   1324: istore 15
    //   1326: lload 38
    //   1328: lstore 40
    //   1330: aload 57
    //   1332: ldc_w 479
    //   1335: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1338: iconst_1
    //   1339: aaload
    //   1340: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   1343: astore 49
    //   1345: iconst_1
    //   1346: istore 14
    //   1348: aload 49
    //   1350: astore 45
    //   1352: goto +7 -> 1359
    //   1355: iload 13
    //   1357: istore 14
    //   1359: aload 57
    //   1361: ldc_w 3120
    //   1364: invokevirtual 2321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1367: ifeq +21 -> 1388
    //   1370: aload 57
    //   1372: ldc_w 479
    //   1375: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1378: iconst_1
    //   1379: aaload
    //   1380: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   1383: astore 49
    //   1385: goto +7 -> 1392
    //   1388: aload 43
    //   1390: astore 49
    //   1392: aload 57
    //   1394: ldc_w 3122
    //   1397: invokevirtual 2321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1400: ifeq +85 -> 1485
    //   1403: aload 57
    //   1405: ldc_w 479
    //   1408: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1411: iconst_1
    //   1412: aaload
    //   1413: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   1416: invokestatic 2774	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1419: invokevirtual 1291	java/lang/Integer:intValue	()I
    //   1422: istore 13
    //   1424: iload 13
    //   1426: istore 15
    //   1428: iload 13
    //   1430: ifeq +49 -> 1479
    //   1433: iload 13
    //   1435: istore 15
    //   1437: iload 13
    //   1439: iconst_1
    //   1440: if_icmpeq +39 -> 1479
    //   1443: iload 13
    //   1445: istore 15
    //   1447: iload 13
    //   1449: iconst_2
    //   1450: if_icmpeq +29 -> 1479
    //   1453: iload 13
    //   1455: istore 15
    //   1457: iload 13
    //   1459: iconst_3
    //   1460: if_icmpeq +19 -> 1479
    //   1463: iload 13
    //   1465: iconst_4
    //   1466: if_icmpne +10 -> 1476
    //   1469: iload 13
    //   1471: istore 15
    //   1473: goto +6 -> 1479
    //   1476: iconst_0
    //   1477: istore 15
    //   1479: iconst_1
    //   1480: istore 20
    //   1482: goto +7 -> 1489
    //   1485: iload 9
    //   1487: istore 15
    //   1489: aload 57
    //   1491: ldc_w 3124
    //   1494: invokevirtual 2321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1497: ifeq +2296 -> 3793
    //   1500: aload 57
    //   1502: ldc_w 479
    //   1505: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1508: astore 43
    //   1510: iload 8
    //   1512: istore 31
    //   1514: iload 6
    //   1516: istore 30
    //   1518: iload 4
    //   1520: istore 28
    //   1522: iload 7
    //   1524: istore 29
    //   1526: iload 5
    //   1528: istore 27
    //   1530: iload_3
    //   1531: istore 26
    //   1533: aload 43
    //   1535: iconst_1
    //   1536: aaload
    //   1537: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   1540: invokestatic 2774	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1543: invokevirtual 1291	java/lang/Integer:intValue	()I
    //   1546: istore 8
    //   1548: iload 8
    //   1550: istore 7
    //   1552: iload 8
    //   1554: ifeq +2233 -> 3787
    //   1557: iload 8
    //   1559: istore 7
    //   1561: iload 8
    //   1563: iconst_1
    //   1564: if_icmpeq +2223 -> 3787
    //   1567: iload 8
    //   1569: iconst_2
    //   1570: if_icmpne +2214 -> 3784
    //   1573: iload 8
    //   1575: istore 7
    //   1577: goto +2210 -> 3787
    //   1580: aload 45
    //   1582: astore 52
    //   1584: iload 6
    //   1586: istore 13
    //   1588: iload 5
    //   1590: istore 8
    //   1592: iload 9
    //   1594: istore 31
    //   1596: iload 6
    //   1598: istore 30
    //   1600: iload 4
    //   1602: istore 28
    //   1604: iload 7
    //   1606: istore 29
    //   1608: iload 5
    //   1610: istore 27
    //   1612: iload_3
    //   1613: istore 26
    //   1615: aload 57
    //   1617: ldc_w 3126
    //   1620: invokevirtual 2321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1623: ifeq +79 -> 1702
    //   1626: iload 9
    //   1628: istore 31
    //   1630: iload 6
    //   1632: istore 30
    //   1634: iload 4
    //   1636: istore 28
    //   1638: iload 7
    //   1640: istore 29
    //   1642: iload 5
    //   1644: istore 27
    //   1646: iload_3
    //   1647: istore 26
    //   1649: aload 57
    //   1651: ldc_w 479
    //   1654: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1657: iconst_1
    //   1658: aaload
    //   1659: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   1662: invokestatic 2774	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1665: invokevirtual 1291	java/lang/Integer:intValue	()I
    //   1668: istore 5
    //   1670: iload 5
    //   1672: ifle +6 -> 1678
    //   1675: goto +12 -> 1687
    //   1678: getstatic 3130	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:h	I
    //   1681: istore 8
    //   1683: iload 8
    //   1685: istore 5
    //   1687: iconst_1
    //   1688: istore 13
    //   1690: iload 5
    //   1692: istore 8
    //   1694: goto +8 -> 1702
    //   1697: astore 43
    //   1699: goto +875 -> 2574
    //   1702: iload 4
    //   1704: istore 6
    //   1706: iload_3
    //   1707: istore 5
    //   1709: iload 9
    //   1711: istore 31
    //   1713: iload 13
    //   1715: istore 30
    //   1717: iload 4
    //   1719: istore 28
    //   1721: iload 7
    //   1723: istore 29
    //   1725: iload 8
    //   1727: istore 27
    //   1729: iload_3
    //   1730: istore 26
    //   1732: aload 57
    //   1734: ldc_w 3132
    //   1737: invokevirtual 2321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1740: ifeq +83 -> 1823
    //   1743: iload 9
    //   1745: istore 31
    //   1747: iload 13
    //   1749: istore 30
    //   1751: iload 4
    //   1753: istore 28
    //   1755: iload 7
    //   1757: istore 29
    //   1759: iload 8
    //   1761: istore 27
    //   1763: iload_3
    //   1764: istore 26
    //   1766: aload 57
    //   1768: ldc_w 479
    //   1771: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1774: iconst_1
    //   1775: aaload
    //   1776: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   1779: invokestatic 2774	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1782: invokevirtual 1291	java/lang/Integer:intValue	()I
    //   1785: istore_3
    //   1786: iload_3
    //   1787: ifle +6 -> 1793
    //   1790: goto +11 -> 1801
    //   1793: getstatic 3134	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:i	I
    //   1796: istore 5
    //   1798: iload 5
    //   1800: istore_3
    //   1801: iconst_1
    //   1802: istore 6
    //   1804: iload_3
    //   1805: istore 5
    //   1807: goto +16 -> 1823
    //   1810: astore 43
    //   1812: iload 13
    //   1814: istore 6
    //   1816: iload 8
    //   1818: istore 5
    //   1820: goto +754 -> 2574
    //   1823: iload 9
    //   1825: istore 31
    //   1827: iload 13
    //   1829: istore 30
    //   1831: iload 6
    //   1833: istore 28
    //   1835: iload 7
    //   1837: istore 29
    //   1839: iload 8
    //   1841: istore 27
    //   1843: iload 5
    //   1845: istore 26
    //   1847: aload 57
    //   1849: ldc_w 3136
    //   1852: invokevirtual 2321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1855: ifeq +613 -> 2468
    //   1858: iload 9
    //   1860: istore 31
    //   1862: iload 13
    //   1864: istore 30
    //   1866: iload 6
    //   1868: istore 28
    //   1870: iload 7
    //   1872: istore 29
    //   1874: iload 8
    //   1876: istore 27
    //   1878: iload 5
    //   1880: istore 26
    //   1882: aload 57
    //   1884: ldc_w 479
    //   1887: invokevirtual 483	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1890: astore 51
    //   1892: iload 9
    //   1894: istore 31
    //   1896: iload 13
    //   1898: istore 30
    //   1900: iload 6
    //   1902: istore 28
    //   1904: iload 7
    //   1906: istore 29
    //   1908: iload 8
    //   1910: istore 27
    //   1912: iload 5
    //   1914: istore 26
    //   1916: aload 51
    //   1918: iconst_1
    //   1919: aaload
    //   1920: invokestatic 3138	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1923: astore 43
    //   1925: aload 51
    //   1927: iconst_1
    //   1928: aaload
    //   1929: invokestatic 3139	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:c	(Ljava/lang/String;)I
    //   1932: istore 4
    //   1934: aload 51
    //   1936: iconst_1
    //   1937: aaload
    //   1938: invokestatic 3141	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:b	(Ljava/lang/String;)I
    //   1941: istore 23
    //   1943: aload 51
    //   1945: iconst_1
    //   1946: aaload
    //   1947: invokestatic 3142	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Ljava/lang/String;)I
    //   1950: istore 19
    //   1952: iload 4
    //   1954: istore_3
    //   1955: iload 4
    //   1957: iconst_1
    //   1958: if_icmpeq +14 -> 1972
    //   1961: iload 4
    //   1963: istore_3
    //   1964: iload 4
    //   1966: iconst_2
    //   1967: if_icmpeq +5 -> 1972
    //   1970: iconst_0
    //   1971: istore_3
    //   1972: iload_3
    //   1973: ifeq +91 -> 2064
    //   1976: aload 51
    //   1978: iconst_1
    //   1979: aaload
    //   1980: invokestatic 3144	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:d	(Ljava/lang/String;)I
    //   1983: istore 4
    //   1985: iload 4
    //   1987: ifle +16 -> 2003
    //   1990: iload 4
    //   1992: bipush 6
    //   1994: if_icmple +6 -> 2000
    //   1997: goto +6 -> 2003
    //   2000: goto +68 -> 2068
    //   2003: iconst_1
    //   2004: istore 4
    //   2006: goto +62 -> 2068
    //   2009: astore 50
    //   2011: aload 43
    //   2013: astore 45
    //   2015: iload_3
    //   2016: istore 4
    //   2018: aload 50
    //   2020: astore 43
    //   2022: aload 44
    //   2024: astore 51
    //   2026: iload 24
    //   2028: istore 26
    //   2030: iload 20
    //   2032: istore 24
    //   2034: iload 9
    //   2036: istore 20
    //   2038: iload 13
    //   2040: istore 9
    //   2042: aload 45
    //   2044: astore 44
    //   2046: iload 23
    //   2048: istore_3
    //   2049: iload 14
    //   2051: istore 13
    //   2053: lload 38
    //   2055: lstore 36
    //   2057: aload 52
    //   2059: astore 45
    //   2061: goto +997 -> 3058
    //   2064: iload 18
    //   2066: istore 4
    //   2068: iload 23
    //   2070: istore 18
    //   2072: iload 23
    //   2074: iconst_1
    //   2075: if_icmpeq +6 -> 2081
    //   2078: iconst_0
    //   2079: istore 18
    //   2081: iload 19
    //   2083: ifgt +9 -> 2092
    //   2086: iconst_3
    //   2087: istore 19
    //   2089: goto +3 -> 2092
    //   2092: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2095: ifeq +115 -> 2210
    //   2098: new 77	java/lang/StringBuilder
    //   2101: dup
    //   2102: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   2105: astore 45
    //   2107: aload 45
    //   2109: ldc_w 3146
    //   2112: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2115: pop
    //   2116: aload 45
    //   2118: aload 43
    //   2120: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2123: pop
    //   2124: aload 45
    //   2126: ldc_w 3148
    //   2129: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: pop
    //   2133: aload 45
    //   2135: iload_3
    //   2136: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2139: pop
    //   2140: aload 45
    //   2142: ldc_w 3150
    //   2145: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2148: pop
    //   2149: aload 45
    //   2151: iload 4
    //   2153: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2156: pop
    //   2157: aload 45
    //   2159: ldc_w 3152
    //   2162: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: pop
    //   2166: aload 45
    //   2168: iload 18
    //   2170: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2173: pop
    //   2174: aload 45
    //   2176: ldc_w 3154
    //   2179: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2182: pop
    //   2183: aload 45
    //   2185: iload 19
    //   2187: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2190: pop
    //   2191: aload 55
    //   2193: iconst_2
    //   2194: aload 45
    //   2196: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2199: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2202: goto +8 -> 2210
    //   2205: astore 45
    //   2207: goto +73 -> 2280
    //   2210: iload 4
    //   2212: istore 26
    //   2214: iload 19
    //   2216: istore 22
    //   2218: aload 43
    //   2220: astore 50
    //   2222: aload 49
    //   2224: astore 43
    //   2226: iload_3
    //   2227: istore 23
    //   2229: iconst_1
    //   2230: istore 25
    //   2232: iload 9
    //   2234: istore 27
    //   2236: iload 13
    //   2238: istore 28
    //   2240: iload 6
    //   2242: istore 4
    //   2244: iload 8
    //   2246: istore 29
    //   2248: iload 5
    //   2250: istore_3
    //   2251: iload 18
    //   2253: istore 19
    //   2255: iload 26
    //   2257: istore 18
    //   2259: iload 12
    //   2261: istore 30
    //   2263: iload 14
    //   2265: istore 31
    //   2267: lload 38
    //   2269: lstore 36
    //   2271: aload 52
    //   2273: astore 45
    //   2275: goto +232 -> 2507
    //   2278: astore 45
    //   2280: iload 4
    //   2282: istore 22
    //   2284: aload 43
    //   2286: astore 50
    //   2288: iload_3
    //   2289: istore 4
    //   2291: iconst_1
    //   2292: istore 25
    //   2294: aload 45
    //   2296: astore 43
    //   2298: aload 44
    //   2300: astore 51
    //   2302: iload 24
    //   2304: istore 26
    //   2306: iload 20
    //   2308: istore 24
    //   2310: iload 9
    //   2312: istore 20
    //   2314: iload 13
    //   2316: istore 9
    //   2318: aload 50
    //   2320: astore 44
    //   2322: iload 18
    //   2324: istore_3
    //   2325: iload 22
    //   2327: istore 18
    //   2329: iload 14
    //   2331: istore 13
    //   2333: lload 38
    //   2335: lstore 36
    //   2337: aload 52
    //   2339: astore 45
    //   2341: goto +717 -> 3058
    //   2344: astore 45
    //   2346: iload 23
    //   2348: istore_3
    //   2349: goto +8 -> 2357
    //   2352: astore 45
    //   2354: iload 19
    //   2356: istore_3
    //   2357: aload 43
    //   2359: astore 50
    //   2361: aload 45
    //   2363: astore 43
    //   2365: aload 44
    //   2367: astore 51
    //   2369: iload 24
    //   2371: istore 26
    //   2373: iload 20
    //   2375: istore 24
    //   2377: iload 9
    //   2379: istore 20
    //   2381: iload 13
    //   2383: istore 9
    //   2385: aload 50
    //   2387: astore 44
    //   2389: iload 22
    //   2391: istore 19
    //   2393: iload 14
    //   2395: istore 13
    //   2397: lload 38
    //   2399: lstore 36
    //   2401: aload 52
    //   2403: astore 45
    //   2405: goto +653 -> 3058
    //   2408: astore 50
    //   2410: aload 43
    //   2412: astore 45
    //   2414: aload 50
    //   2416: astore 43
    //   2418: aload 44
    //   2420: astore 51
    //   2422: iload 24
    //   2424: istore 26
    //   2426: iload 20
    //   2428: istore 24
    //   2430: iload 9
    //   2432: istore 20
    //   2434: iload 13
    //   2436: istore 9
    //   2438: aload 45
    //   2440: astore 44
    //   2442: iload 19
    //   2444: istore_3
    //   2445: iload 22
    //   2447: istore 19
    //   2449: iload 23
    //   2451: istore 4
    //   2453: iload 14
    //   2455: istore 13
    //   2457: lload 38
    //   2459: lstore 36
    //   2461: aload 52
    //   2463: astore 45
    //   2465: goto +593 -> 3058
    //   2468: aload 49
    //   2470: astore 43
    //   2472: aload 52
    //   2474: astore 45
    //   2476: lload 38
    //   2478: lstore 36
    //   2480: iload 14
    //   2482: istore 31
    //   2484: iload 12
    //   2486: istore 30
    //   2488: iload 5
    //   2490: istore_3
    //   2491: iload 8
    //   2493: istore 29
    //   2495: iload 6
    //   2497: istore 4
    //   2499: iload 13
    //   2501: istore 28
    //   2503: iload 9
    //   2505: istore 27
    //   2507: iload 33
    //   2509: iconst_1
    //   2510: iadd
    //   2511: istore 33
    //   2513: iload 27
    //   2515: istore 8
    //   2517: iload 28
    //   2519: istore 6
    //   2521: iload 15
    //   2523: istore 9
    //   2525: iload 29
    //   2527: istore 5
    //   2529: iload 30
    //   2531: istore 14
    //   2533: iload 31
    //   2535: istore 13
    //   2537: goto -2087 -> 450
    //   2540: astore 43
    //   2542: iload 31
    //   2544: istore 9
    //   2546: iload 30
    //   2548: istore 6
    //   2550: iload 28
    //   2552: istore 4
    //   2554: iload 29
    //   2556: istore 7
    //   2558: iload 27
    //   2560: istore 5
    //   2562: iload 26
    //   2564: istore_3
    //   2565: goto +9 -> 2574
    //   2568: astore 43
    //   2570: iload 8
    //   2572: istore 9
    //   2574: aload 44
    //   2576: astore 51
    //   2578: iload 24
    //   2580: istore 26
    //   2582: iload 20
    //   2584: istore 24
    //   2586: iload 9
    //   2588: istore 20
    //   2590: iload 6
    //   2592: istore 9
    //   2594: iload 4
    //   2596: istore 6
    //   2598: iload 5
    //   2600: istore 8
    //   2602: iload_3
    //   2603: istore 5
    //   2605: aload 50
    //   2607: astore 44
    //   2609: iload 19
    //   2611: istore_3
    //   2612: iload 22
    //   2614: istore 19
    //   2616: iload 23
    //   2618: istore 4
    //   2620: iload 14
    //   2622: istore 13
    //   2624: lload 38
    //   2626: lstore 36
    //   2628: goto +430 -> 3058
    //   2631: astore 43
    //   2633: iload 9
    //   2635: istore 15
    //   2637: aload 44
    //   2639: astore 51
    //   2641: iload 24
    //   2643: istore 26
    //   2645: iload 20
    //   2647: istore 24
    //   2649: iload 8
    //   2651: istore 20
    //   2653: iload 6
    //   2655: istore 9
    //   2657: iload 4
    //   2659: istore 6
    //   2661: iload 5
    //   2663: istore 8
    //   2665: iload_3
    //   2666: istore 5
    //   2668: aload 50
    //   2670: astore 44
    //   2672: iload 19
    //   2674: istore_3
    //   2675: iload 22
    //   2677: istore 19
    //   2679: iload 23
    //   2681: istore 4
    //   2683: iload 14
    //   2685: istore 13
    //   2687: lload 38
    //   2689: lstore 36
    //   2691: goto +367 -> 3058
    //   2694: astore 49
    //   2696: iload 14
    //   2698: istore 13
    //   2700: lload 38
    //   2702: lstore 36
    //   2704: goto +13 -> 2717
    //   2707: astore 49
    //   2709: lload 40
    //   2711: lstore 36
    //   2713: iload 15
    //   2715: istore 12
    //   2717: aload 43
    //   2719: astore 51
    //   2721: aload 49
    //   2723: astore 43
    //   2725: iload 9
    //   2727: istore 15
    //   2729: aload 51
    //   2731: astore 49
    //   2733: aload 44
    //   2735: astore 51
    //   2737: iload 24
    //   2739: istore 26
    //   2741: iload 20
    //   2743: istore 24
    //   2745: iload 8
    //   2747: istore 20
    //   2749: iload 6
    //   2751: istore 9
    //   2753: iload 4
    //   2755: istore 6
    //   2757: iload 5
    //   2759: istore 8
    //   2761: iload_3
    //   2762: istore 5
    //   2764: aload 50
    //   2766: astore 44
    //   2768: iload 19
    //   2770: istore_3
    //   2771: iload 22
    //   2773: istore 19
    //   2775: iload 23
    //   2777: istore 4
    //   2779: goto +279 -> 3058
    //   2782: goto +94 -> 2876
    //   2785: ldc 8
    //   2787: astore 45
    //   2789: aload 45
    //   2791: astore 43
    //   2793: aconst_null
    //   2794: astore 48
    //   2796: aload 48
    //   2798: astore 47
    //   2800: aload 47
    //   2802: astore 44
    //   2804: aload 44
    //   2806: astore 50
    //   2808: iconst_0
    //   2809: istore 24
    //   2811: iconst_0
    //   2812: istore 20
    //   2814: iconst_0
    //   2815: istore 8
    //   2817: iconst_0
    //   2818: istore 6
    //   2820: iconst_0
    //   2821: istore 4
    //   2823: iconst_0
    //   2824: istore 25
    //   2826: iconst_m1
    //   2827: istore 9
    //   2829: iconst_m1
    //   2830: istore 7
    //   2832: iconst_m1
    //   2833: istore 5
    //   2835: iconst_m1
    //   2836: istore_3
    //   2837: iconst_0
    //   2838: istore 19
    //   2840: iconst_0
    //   2841: istore 22
    //   2843: iconst_0
    //   2844: istore 23
    //   2846: iconst_0
    //   2847: istore 18
    //   2849: iconst_0
    //   2850: istore 14
    //   2852: iconst_0
    //   2853: istore 13
    //   2855: ldc2_w 3085
    //   2858: lstore 36
    //   2860: iconst_0
    //   2861: istore 11
    //   2863: iconst_0
    //   2864: istore 10
    //   2866: bipush 50
    //   2868: istore 21
    //   2870: iconst_0
    //   2871: istore 17
    //   2873: iconst_0
    //   2874: istore 16
    //   2876: aload 48
    //   2878: astore 49
    //   2880: iload 20
    //   2882: istore 15
    //   2884: iload 8
    //   2886: istore 12
    //   2888: iload 5
    //   2890: istore 8
    //   2892: iload 19
    //   2894: istore 5
    //   2896: iload 22
    //   2898: istore 26
    //   2900: iload 23
    //   2902: istore 20
    //   2904: iload 18
    //   2906: istore 22
    //   2908: iload 6
    //   2910: istore 18
    //   2912: iload 4
    //   2914: istore 19
    //   2916: aload 46
    //   2918: astore 48
    //   2920: iload 26
    //   2922: istore 4
    //   2924: iload 5
    //   2926: istore 6
    //   2928: aload 50
    //   2930: astore 46
    //   2932: iload_3
    //   2933: istore 5
    //   2935: iload 7
    //   2937: istore_3
    //   2938: iload 9
    //   2940: istore 7
    //   2942: iload 15
    //   2944: istore 9
    //   2946: iload 24
    //   2948: istore 26
    //   2950: iload 18
    //   2952: istore 15
    //   2954: iload 19
    //   2956: istore 18
    //   2958: iload 25
    //   2960: istore 19
    //   2962: goto +239 -> 3201
    //   2965: astore 43
    //   2967: ldc 8
    //   2969: astore 49
    //   2971: aload 49
    //   2973: astore 45
    //   2975: aconst_null
    //   2976: astore 47
    //   2978: aload 47
    //   2980: astore 51
    //   2982: aload 51
    //   2984: astore 46
    //   2986: aload 46
    //   2988: astore 44
    //   2990: iconst_m1
    //   2991: istore 15
    //   2993: iconst_0
    //   2994: istore 26
    //   2996: iconst_0
    //   2997: istore 24
    //   2999: iconst_0
    //   3000: istore 20
    //   3002: iconst_0
    //   3003: istore 9
    //   3005: iconst_0
    //   3006: istore 6
    //   3008: iconst_0
    //   3009: istore 25
    //   3011: iconst_m1
    //   3012: istore 7
    //   3014: iconst_m1
    //   3015: istore 8
    //   3017: iconst_m1
    //   3018: istore 5
    //   3020: iconst_0
    //   3021: istore_3
    //   3022: iconst_0
    //   3023: istore 19
    //   3025: iconst_0
    //   3026: istore 4
    //   3028: iconst_0
    //   3029: istore 18
    //   3031: iconst_0
    //   3032: istore 12
    //   3034: iconst_0
    //   3035: istore 13
    //   3037: ldc2_w 3085
    //   3040: lstore 36
    //   3042: iconst_0
    //   3043: istore 11
    //   3045: iconst_0
    //   3046: istore 10
    //   3048: bipush 50
    //   3050: istore 21
    //   3052: iconst_0
    //   3053: istore 17
    //   3055: iconst_0
    //   3056: istore 16
    //   3058: aload 43
    //   3060: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   3063: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3066: ifeq +47 -> 3113
    //   3069: new 77	java/lang/StringBuilder
    //   3072: dup
    //   3073: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   3076: astore 50
    //   3078: aload 50
    //   3080: ldc_w 3156
    //   3083: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3086: pop
    //   3087: aload 50
    //   3089: aload 43
    //   3091: invokevirtual 2032	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3094: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3097: pop
    //   3098: ldc_w 3158
    //   3101: iconst_2
    //   3102: aload 50
    //   3104: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3107: invokestatic 531	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3110: goto +3 -> 3113
    //   3113: aload 49
    //   3115: astore 43
    //   3117: aload 48
    //   3119: astore 49
    //   3121: aload 46
    //   3123: astore 48
    //   3125: iload 24
    //   3127: istore 27
    //   3129: iload 20
    //   3131: istore 28
    //   3133: aload 44
    //   3135: astore 46
    //   3137: iload_3
    //   3138: istore 23
    //   3140: iload 19
    //   3142: istore 24
    //   3144: iload 4
    //   3146: istore 20
    //   3148: iload 15
    //   3150: istore_3
    //   3151: iload 25
    //   3153: istore 19
    //   3155: iload 7
    //   3157: istore 4
    //   3159: iload 18
    //   3161: istore 22
    //   3163: iload 12
    //   3165: istore 14
    //   3167: iload 6
    //   3169: istore 18
    //   3171: iload 9
    //   3173: istore 15
    //   3175: iload 28
    //   3177: istore 12
    //   3179: iload 27
    //   3181: istore 9
    //   3183: aload 51
    //   3185: astore 44
    //   3187: iload_3
    //   3188: istore 7
    //   3190: iload 4
    //   3192: istore_3
    //   3193: iload 23
    //   3195: istore 6
    //   3197: iload 24
    //   3199: istore 4
    //   3201: iload 26
    //   3203: ifeq +180 -> 3383
    //   3206: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3209: ifeq +43 -> 3252
    //   3212: ldc_w 3160
    //   3215: iconst_2
    //   3216: ldc_w 3162
    //   3219: iconst_4
    //   3220: anewarray 4	java/lang/Object
    //   3223: dup
    //   3224: iconst_0
    //   3225: aload 48
    //   3227: aastore
    //   3228: dup
    //   3229: iconst_1
    //   3230: aload 49
    //   3232: aastore
    //   3233: dup
    //   3234: iconst_2
    //   3235: aload 47
    //   3237: aastore
    //   3238: dup
    //   3239: iconst_3
    //   3240: aload 44
    //   3242: aastore
    //   3243: invokestatic 549	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3246: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3249: goto +3 -> 3252
    //   3252: aload_1
    //   3253: iconst_5
    //   3254: invokestatic 3165	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)Ljava/lang/String;
    //   3257: astore 50
    //   3259: aload_1
    //   3260: bipush 6
    //   3262: invokestatic 3165	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)Ljava/lang/String;
    //   3265: astore 51
    //   3267: aload 48
    //   3269: ifnull +34 -> 3303
    //   3272: aload 48
    //   3274: aload 50
    //   3276: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3279: ifeq +24 -> 3303
    //   3282: aload 49
    //   3284: ifnull +19 -> 3303
    //   3287: aload 49
    //   3289: aload 51
    //   3291: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3294: ifne +6 -> 3300
    //   3297: goto +6 -> 3303
    //   3300: goto +26 -> 3326
    //   3303: iconst_0
    //   3304: putstatic 3166	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:jdField_b_of_type_Boolean	Z
    //   3307: iconst_0
    //   3308: putstatic 3167	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:c	Z
    //   3311: iconst_0
    //   3312: invokestatic 3168	com/tencent/mobileqq/utils/SharedPreUtils:a	(Z)V
    //   3315: aload_1
    //   3316: aload 48
    //   3318: aload 49
    //   3320: getstatic 3170	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:d	Ljava/lang/String;
    //   3323: invokestatic 3173	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3326: aload_1
    //   3327: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3330: aload_1
    //   3331: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3334: iload 17
    //   3336: aload 48
    //   3338: aload 49
    //   3340: aload 47
    //   3342: aload 44
    //   3344: iload 11
    //   3346: iload 10
    //   3348: iload 21
    //   3350: iload 16
    //   3352: invokestatic 3176	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIII)V
    //   3355: aload_1
    //   3356: iload 17
    //   3358: aload 48
    //   3360: aload 49
    //   3362: aload 47
    //   3364: aload 44
    //   3366: iload 11
    //   3368: iload 21
    //   3370: iload 16
    //   3372: invokestatic 3179	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V
    //   3375: iload 10
    //   3377: invokestatic 3180	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:b	(I)V
    //   3380: goto +3 -> 3383
    //   3383: iload 9
    //   3385: ifeq +183 -> 3568
    //   3388: iload 12
    //   3390: ifeq +178 -> 3568
    //   3393: iload 15
    //   3395: ifeq +173 -> 3568
    //   3398: iload 18
    //   3400: ifeq +168 -> 3568
    //   3403: iload 19
    //   3405: ifeq +163 -> 3568
    //   3408: aload_1
    //   3409: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3412: aload_1
    //   3413: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3416: iconst_0
    //   3417: invokevirtual 653	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   3420: invokeinterface 659 1 0
    //   3425: ldc_w 3182
    //   3428: iconst_0
    //   3429: invokeinterface 2549 3 0
    //   3434: invokeinterface 670 1 0
    //   3439: pop
    //   3440: aload_1
    //   3441: iconst_0
    //   3442: invokestatic 3184	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   3445: aload_1
    //   3446: iconst_0
    //   3447: invokestatic 3185	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   3450: iload 7
    //   3452: iload_3
    //   3453: iload 8
    //   3455: iload 5
    //   3457: invokestatic 3188	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(IIII)V
    //   3460: aload_1
    //   3461: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3464: aload_1
    //   3465: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3468: iload 34
    //   3470: iconst_1
    //   3471: iload 7
    //   3473: iload_3
    //   3474: iload 8
    //   3476: iload 5
    //   3478: invokestatic 3191	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;IZIIII)V
    //   3481: aload 46
    //   3483: invokestatic 3192	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Ljava/lang/String;)V
    //   3486: aload_1
    //   3487: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3490: aload_1
    //   3491: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3494: iload 34
    //   3496: aload 46
    //   3498: invokestatic 3195	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;)V
    //   3501: iload 6
    //   3503: invokestatic 3196	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(I)V
    //   3506: aload_1
    //   3507: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3510: aload_1
    //   3511: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3514: iload 34
    //   3516: iload 6
    //   3518: invokestatic 3198	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;II)V
    //   3521: iload 4
    //   3523: invokestatic 3200	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:c	(I)V
    //   3526: aload_1
    //   3527: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3530: aload_1
    //   3531: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3534: iload 34
    //   3536: iload 4
    //   3538: invokestatic 3202	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;Ljava/lang/String;II)V
    //   3541: iload 20
    //   3543: iload 22
    //   3545: invokestatic 3205	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(II)V
    //   3548: aload_1
    //   3549: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3552: aload_1
    //   3553: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3556: iload 34
    //   3558: iload 20
    //   3560: iload 22
    //   3562: invokestatic 3208	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;III)V
    //   3565: goto +3 -> 3568
    //   3568: iload 14
    //   3570: ifeq +126 -> 3696
    //   3573: iload 13
    //   3575: ifeq +121 -> 3696
    //   3578: iload 13
    //   3580: ifeq +116 -> 3696
    //   3583: aload_1
    //   3584: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3587: invokestatic 3214	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   3590: astore 44
    //   3592: new 77	java/lang/StringBuilder
    //   3595: dup
    //   3596: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   3599: astore 46
    //   3601: aload 46
    //   3603: aload_1
    //   3604: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3607: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3610: pop
    //   3611: aload 46
    //   3613: ldc_w 3216
    //   3616: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3619: pop
    //   3620: aload 46
    //   3622: ldc_w 3118
    //   3625: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3628: pop
    //   3629: aload 44
    //   3631: aload 46
    //   3633: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3636: ldc 8
    //   3638: invokeinterface 958 3 0
    //   3643: astore 44
    //   3645: aload_1
    //   3646: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3649: aload_1
    //   3650: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3653: iload 34
    //   3655: lload 36
    //   3657: aload 45
    //   3659: aload 43
    //   3661: invokestatic 3219	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V
    //   3664: aload 45
    //   3666: ifnull +30 -> 3696
    //   3669: aload 45
    //   3671: aload 44
    //   3673: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3676: ifne +20 -> 3696
    //   3679: aload_1
    //   3680: getstatic 3222	com/tencent/mobileqq/app/BusinessHandlerFactory:POKE_BIG_RES_HANDLER	Ljava/lang/String;
    //   3683: invokevirtual 1336	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   3686: checkcast 3224	com/tencent/mobileqq/app/utils/PokeBigResHandler
    //   3689: iconst_1
    //   3690: invokevirtual 3225	com/tencent/mobileqq/app/utils/PokeBigResHandler:a	(Z)V
    //   3693: goto +3 -> 3696
    //   3696: iload 4
    //   3698: invokestatic 3200	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:c	(I)V
    //   3701: goto -3487 -> 214
    //   3704: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3707: ifeq +41 -> 3748
    //   3710: new 77	java/lang/StringBuilder
    //   3713: dup
    //   3714: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   3717: astore_1
    //   3718: aload_1
    //   3719: ldc_w 3227
    //   3722: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3725: pop
    //   3726: aload_1
    //   3727: aload_2
    //   3728: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3731: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3734: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3737: pop
    //   3738: ldc 91
    //   3740: iconst_2
    //   3741: aload_1
    //   3742: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3745: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3748: return
    //   3749: iload 8
    //   3751: istore 27
    //   3753: iload 6
    //   3755: istore 28
    //   3757: iload 9
    //   3759: istore 15
    //   3761: iload 5
    //   3763: istore 29
    //   3765: iload 14
    //   3767: istore 30
    //   3769: iload 13
    //   3771: istore 31
    //   3773: iload 12
    //   3775: istore 17
    //   3777: iload 26
    //   3779: istore 16
    //   3781: goto -1274 -> 2507
    //   3784: iconst_0
    //   3785: istore 7
    //   3787: iconst_1
    //   3788: istore 9
    //   3790: goto -2210 -> 1580
    //   3793: iload 8
    //   3795: istore 9
    //   3797: goto -2217 -> 1580
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3800	0	this	ConfigServlet
    //   0	3800	1	paramQQAppInterface	QQAppInterface
    //   0	3800	2	paramConfig	ConfigurationService.Config
    //   20	3454	3	i	int
    //   32	3665	4	j	int
    //   37	3725	5	k	int
    //   388	3366	6	m	int
    //   400	3386	7	n	int
    //   385	3409	8	i1	int
    //   397	3399	9	i2	int
    //   434	2942	10	i3	int
    //   431	2936	11	i4	int
    //   527	3247	12	i5	int
    //   423	3347	13	i6	int
    //   420	3346	14	i7	int
    //   466	3294	15	i8	int
    //   444	3336	16	i9	int
    //   441	3335	17	i10	int
    //   417	2982	18	i11	int
    //   408	2996	19	i12	int
    //   382	3177	20	i13	int
    //   438	2931	21	i14	int
    //   411	3150	22	i15	int
    //   414	2780	23	i16	int
    //   379	2819	24	i17	int
    //   394	2758	25	i18	int
    //   531	3247	26	i19	int
    //   1011	2741	27	i20	int
    //   1015	2741	28	i21	int
    //   1023	2741	29	i22	int
    //   1027	2741	30	i23	int
    //   1031	2741	31	i24	int
    //   353	102	32	i25	int
    //   215	2297	33	i26	int
    //   7	3647	34	i27	int
    //   42	665	35	bool	boolean
    //   428	3228	36	l1	long
    //   1250	1451	38	l2	long
    //   470	2240	40	l3	long
    //   138	178	42	str1	String
    //   134	1400	43	localObject1	Object
    //   1697	1	43	localException1	Exception
    //   1810	1	43	localException2	Exception
    //   1923	548	43	localObject2	Object
    //   2540	1	43	localException3	Exception
    //   2568	1	43	localException4	Exception
    //   2631	87	43	localException5	Exception
    //   2723	69	43	localObject3	Object
    //   2965	125	43	localException6	Exception
    //   3115	545	43	localObject4	Object
    //   252	3420	44	localObject5	Object
    //   357	1838	45	localObject6	Object
    //   2205	1	45	localException7	Exception
    //   2273	1	45	localObject7	Object
    //   2278	17	45	localException8	Exception
    //   2339	1	45	localObject8	Object
    //   2344	1	45	localException9	Exception
    //   2352	10	45	localException10	Exception
    //   2403	1267	45	localObject9	Object
    //   327	3305	46	localObject10	Object
    //   364	2999	47	localObject11	Object
    //   330	3029	48	localObject12	Object
    //   333	206	49	str2	String
    //   552	11	49	localException11	Exception
    //   618	31	49	str3	String
    //   662	11	49	localException12	Exception
    //   786	291	49	str4	String
    //   1083	27	49	localException13	Exception
    //   1120	1349	49	localObject13	Object
    //   2694	1	49	localException14	Exception
    //   2707	15	49	localException15	Exception
    //   2731	630	49	localObject14	Object
    //   376	847	50	localObject15	Object
    //   2009	10	50	localException16	Exception
    //   2220	166	50	localObject16	Object
    //   2408	357	50	localException17	Exception
    //   2806	469	50	localObject17	Object
    //   713	254	51	localObject18	Object
    //   1040	1	51	localException18	Exception
    //   1057	1	51	localException19	Exception
    //   1066	40	51	localException20	Exception
    //   1111	3	51	localException21	Exception
    //   1161	15	51	localException22	Exception
    //   1189	2101	51	localObject19	Object
    //   717	1756	52	localObject20	Object
    //   721	377	53	localObject21	Object
    //   725	369	54	localObject22	Object
    //   47	2145	55	str5	String
    //   343	115	56	arrayOfString	String[]
    //   462	1421	57	str6	String
    //   212	16	58	localIterator	Iterator
    //   752	237	59	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   538	545	552	java/lang/Exception
    //   648	655	662	java/lang/Exception
    //   881	896	1040	java/lang/Exception
    //   866	881	1057	java/lang/Exception
    //   856	866	1066	java/lang/Exception
    //   735	754	1083	java/lang/Exception
    //   778	788	1083	java/lang/Exception
    //   812	822	1083	java/lang/Exception
    //   846	856	1083	java/lang/Exception
    //   920	930	1083	java/lang/Exception
    //   954	964	1083	java/lang/Exception
    //   988	998	1083	java/lang/Exception
    //   1113	1118	1161	java/lang/Exception
    //   1678	1683	1697	java/lang/Exception
    //   1793	1798	1810	java/lang/Exception
    //   1976	1985	2009	java/lang/Exception
    //   2107	2202	2205	java/lang/Exception
    //   2092	2107	2278	java/lang/Exception
    //   1943	1952	2344	java/lang/Exception
    //   1934	1943	2352	java/lang/Exception
    //   1925	1934	2408	java/lang/Exception
    //   1533	1548	2540	java/lang/Exception
    //   1615	1626	2540	java/lang/Exception
    //   1649	1670	2540	java/lang/Exception
    //   1732	1743	2540	java/lang/Exception
    //   1766	1786	2540	java/lang/Exception
    //   1847	1858	2540	java/lang/Exception
    //   1882	1892	2540	java/lang/Exception
    //   1916	1925	2540	java/lang/Exception
    //   1489	1510	2568	java/lang/Exception
    //   1392	1424	2631	java/lang/Exception
    //   1359	1385	2694	java/lang/Exception
    //   472	482	2707	java/lang/Exception
    //   495	510	2707	java/lang/Exception
    //   518	525	2707	java/lang/Exception
    //   562	567	2707	java/lang/Exception
    //   586	597	2707	java/lang/Exception
    //   605	620	2707	java/lang/Exception
    //   628	635	2707	java/lang/Exception
    //   672	677	2707	java/lang/Exception
    //   696	706	2707	java/lang/Exception
    //   1260	1271	2707	java/lang/Exception
    //   1279	1300	2707	java/lang/Exception
    //   1311	1322	2707	java/lang/Exception
    //   1330	1345	2707	java/lang/Exception
    //   335	345	2965	java/lang/Exception
    //   350	355	2965	java/lang/Exception
  }
  
  private void ax(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    label478:
    for (;;)
    {
      try
      {
        int i = paramConfig.version.get();
        int j = SharedPreUtils.M(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
        boolean bool1 = QLog.isColorLevel();
        StringBuilder localStringBuilder;
        if (bool1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("received LongTextMsgConfig configVersion:");
          localStringBuilder.append(i);
          localStringBuilder.append(" ,localVersion:");
          localStringBuilder.append(j);
          QLog.d("longText", 2, localStringBuilder.toString());
        }
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          paramConfig = paramConfig.content_list;
          boolean bool3 = false;
          bool1 = false;
          boolean bool2 = false;
          paramConfig = (String)paramConfig.get(0);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("received LongTextMsgConfig configContent");
            localStringBuilder.append(paramConfig);
            QLog.d("longText", 2, localStringBuilder.toString());
          }
          if (i == j) {
            break;
          }
          try
          {
            if (!TextUtils.isEmpty(paramConfig))
            {
              paramConfig = new JSONObject(paramConfig);
              j = Integer.parseInt(paramConfig.optString("largeMsgOp"));
              if (j == 1) {
                bool1 = true;
              } else {
                bool1 = false;
              }
              try
              {
                int k = Integer.parseInt(paramConfig.optString("msfPullFilter"));
                if (k != 0) {
                  bool2 = true;
                }
                try
                {
                  if (QLog.isColorLevel())
                  {
                    paramConfig = new StringBuilder();
                    paramConfig.append("received LongTextMsgConfig, parse content ltValue:");
                    paramConfig.append(j);
                    paramConfig.append(",ltSwitch:");
                    paramConfig.append(bool1);
                    paramConfig.append(",mpfValue:");
                    paramConfig.append(k);
                    paramConfig.append(",mpfSwitch:");
                    paramConfig.append(bool2);
                    QLog.d("longText", 2, paramConfig.toString());
                  }
                }
                catch (Exception paramConfig)
                {
                  continue;
                }
                bool2 = true;
              }
              catch (Exception paramConfig) {}
            }
          }
          catch (Exception paramConfig)
          {
            bool1 = bool3;
            bool2 = true;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("longText", 2, "received LongTextMsgConfig, parse content error!", paramConfig);
            break label478;
            paramConfig = (LongTextMsgManager)paramQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER);
            paramConfig.jdField_b_of_type_Boolean = true;
            paramConfig.c = bool1;
            paramQQAppInterface.isMsfPullFilterConfigInited = true;
            paramQQAppInterface.msfPullFilterSwitch = bool2;
            SharedPreUtils.b(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, bool1, bool2);
          }
        }
        else
        {
          if (i == j)
          {
            if (QLog.isColorLevel()) {
              QLog.d("longText", 2, "received LongTextMsgConfig, content_list is empty, ignored because of SAME VERSION");
            }
          }
          else if (QLog.isColorLevel()) {
            QLog.d("longText", 2, "received LongTextMsgConfig, content_list is empty, use default config");
          }
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received LongTextMsgConfig error", paramQQAppInterface);
        }
        return;
      }
    }
  }
  
  private void ay(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      int i = paramConfig.version.get();
      BabyQHandler localBabyQHandler = (BabyQHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      int j = localBabyQHandler.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        paramQQAppInterface = (String)paramConfig.content_list.get(0);
        if (QLog.isColorLevel())
        {
          paramConfig = new StringBuilder();
          paramConfig.append("received BabyQPlusPanelConfig configVersion:");
          paramConfig.append(i);
          paramConfig.append(" ,localVersion:");
          paramConfig.append(j);
          paramConfig.append(" ,configContent");
          paramConfig.append(paramQQAppInterface);
          QLog.d("babyqConfig", 2, paramConfig.toString());
        }
        if (i != j)
        {
          localBabyQHandler.a(i, paramQQAppInterface);
          return;
        }
        localBabyQHandler.a(false, false);
        return;
      }
      if (i == j)
      {
        if (QLog.isColorLevel()) {
          QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig, content_list is empty, ignored because of SAME VERSION");
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("babyqConfig", 2, "received BabyQPlusPanelConfig, content_list is empty, use default config");
      }
      localBabyQHandler.a(false, false);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("babyqConfig", 2, "received BabyQPlusPanelConfig error", paramQQAppInterface);
      }
    }
  }
  
  private void az(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleRespAddContactsViewConfig|type= ");
      ((StringBuilder)localObject).append(paramConfig.type.get());
      QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject).toString());
    }
    int j = paramConfig.version.get();
    if (j == SharedPreUtils.P(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "AddContactsViewConfig serverVersion is equals to localVersion ");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AddContactsViewConfig contentlist:");
      ((StringBuilder)localObject).append(paramConfig.content_list);
      QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject).toString());
    }
    XmlPullParser localXmlPullParser;
    int i;
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      localObject = (String)paramConfig.content_list.get(0);
      if (localObject != null)
      {
        localXmlPullParser = Xml.newPullParser();
        paramConfig = null;
        try
        {
          localXmlPullParser.setInput(new ByteArrayInputStream(((String)localObject).getBytes()), "utf-8");
          i = localXmlPullParser.getEventType();
        }
        catch (Exception paramQQAppInterface)
        {
          String str;
          if (!QLog.isColorLevel()) {
            break label388;
          }
          paramConfig = new StringBuilder();
          paramConfig.append("AddContactsViewConfig appear exception:");
          paramConfig.append(paramQQAppInterface.toString());
          QLog.e("SPLASH_ConfigServlet", 2, paramConfig.toString());
        }
        str = localXmlPullParser.getName();
        localObject = paramConfig;
        if (str != null)
        {
          localObject = paramConfig;
          if (str.equalsIgnoreCase("entrencelist")) {
            localObject = localXmlPullParser.nextText();
          }
        }
      }
    }
    for (;;)
    {
      i = localXmlPullParser.next();
      paramConfig = (ConfigurationService.Config)localObject;
      label388:
      while (i == 1)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("AddContactsView entrencelist:");
          ((StringBuilder)localObject).append(paramConfig);
          QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject).toString());
        }
        if ((paramConfig != null) && (paramConfig.length() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "success");
          }
          SharedPreUtils.c(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), paramConfig);
          return;
        }
        return;
      }
      localObject = paramConfig;
      if (i != 0)
      {
        if (i == 2) {
          break;
        }
        localObject = paramConfig;
      }
    }
  }
  
  private int b(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString)
  {
    ShortVideoResourceManager localShortVideoResourceManager = paramQQAppInterface.getShortVideoResourceManager();
    int i = 0;
    int j;
    if ((localShortVideoResourceManager == null) && ("ConfigurationService.ReqGetConfigNoLogin".equals(paramString)))
    {
      localShortVideoResourceManager = new ShortVideoResourceManager(paramQQAppInterface);
      j = 1;
    }
    else
    {
      j = 0;
    }
    int k = ShortVideoResourceManager.a();
    int m = paramConfig.version.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiveAllConfigs[handleShortVideoResourceConfig]|received remote version: ");
    localStringBuilder.append(m);
    localStringBuilder.append(" | localVersion: ");
    localStringBuilder.append(k);
    QLog.d("ShortVideoResourceManager", 1, localStringBuilder.toString());
    if (m != k)
    {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramConfig.msg_content_list.size() - 1);
        if (paramConfig != null)
        {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
            if (paramConfig != null) {
              try
              {
                paramConfig = new String(paramConfig, "UTF-8");
              }
              catch (Throwable paramConfig)
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("receiveAllConfigs[handleShortVideoResourceConfig]|Throwable:");
                localStringBuilder.append(paramConfig.getMessage());
                QLog.d("SPLASH_ConfigServlet", 1, localStringBuilder.toString());
                break label256;
              }
            } else {
              QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|inflateConfigString error!");
            }
            label256:
            paramConfig = "";
          }
          else
          {
            paramConfig = paramConfig.content.get().toStringUtf8();
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("receiveAllConfigs[handleShortVideoResourceConfig]|config_content ");
          localStringBuilder.append(paramConfig);
          QLog.d("SPLASH_ConfigServlet", 1, localStringBuilder.toString());
          if ("ConfigurationService.ReqGetConfigNoLogin".equals(paramString)) {
            i = localShortVideoResourceManager.a(paramConfig, m);
          } else {
            i = localShortVideoResourceManager.a(paramQQAppInterface.getApp(), paramConfig, m);
          }
          break label415;
        }
        QLog.d("ShortVideoResourceManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]| content==null");
      }
      else
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("receiveAllConfigs[handleShortVideoResourceConfig]| msg_content_list is empty ,version: ");
        paramQQAppInterface.append(m);
        paramQQAppInterface.append(",localVersion:");
        paramQQAppInterface.append(k);
        QLog.d("ShortVideoResourceManager", 1, paramQQAppInterface.toString());
      }
      i = -125;
    }
    label415:
    if (j != 0) {
      localShortVideoResourceManager.c();
    }
    return i;
  }
  
  public static String b(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    return QConfigServlet.a(paramConfig, paramInt1, paramInt2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getOldShortVideoResourceConfig| getType=");
      localStringBuilder.append(paramInt);
      QLog.i("AEOldShortVideoResManager", 2, localStringBuilder.toString());
    }
    AEOldShortVideoResManager.a = System.currentTimeMillis();
    a(paramQQAppInterface, 215, null);
  }
  
  private void b(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleResp_GetArGlobalConfig |  type= ");
      ((StringBuilder)localObject).append(paramConfig.type.get());
      QLog.d("handleResp_GetArGlobalConfig", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ARGlobalConfigManager)paramQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    if (paramConfig.type.get() == 188)
    {
      int i = paramConfig.version.get();
      if (paramIntent.getIntExtra("ar_global_key_config_version", 0) != i)
      {
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
        {
          paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          if (paramQQAppInterface != null)
          {
            if (paramQQAppInterface.compress.get() == 1)
            {
              byte[] arrayOfByte = OlympicUtil.a(paramQQAppInterface.content.get().toByteArray());
              paramIntent = null;
              paramQQAppInterface = paramIntent;
              if (arrayOfByte != null)
              {
                try
                {
                  paramQQAppInterface = new String(arrayOfByte, "UTF-8");
                }
                catch (OutOfMemoryError paramQQAppInterface)
                {
                  if (QLog.isColorLevel()) {
                    paramQQAppInterface.printStackTrace();
                  }
                  System.gc();
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  try
                  {
                    paramQQAppInterface = new String(arrayOfByte, "UTF-8");
                  }
                  catch (Throwable paramQQAppInterface)
                  {
                    for (;;)
                    {
                      paramQQAppInterface = paramIntent;
                    }
                  }
                  localUnsupportedEncodingException = localUnsupportedEncodingException;
                  paramQQAppInterface = paramIntent;
                  if (!QLog.isColorLevel()) {
                    break label241;
                  }
                }
                localUnsupportedEncodingException.printStackTrace();
                paramQQAppInterface = paramIntent;
              }
            }
            else
            {
              paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
            }
            label241:
            if (paramQQAppInterface != null)
            {
              if (QLog.isColorLevel())
              {
                paramIntent = new StringBuilder();
                paramIntent.append("handleRespGetHotDaysConfig, config_content is ");
                paramIntent.append(paramQQAppInterface);
                QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, paramIntent.toString());
              }
              i = paramConfig.version.get();
              if (((ARGlobalConfigManager)localObject).a(paramQQAppInterface))
              {
                ((ARGlobalConfigManager)localObject).a(i);
                ((ARGlobalConfigManager)localObject).a();
              }
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, content is null");
          }
        }
        else
        {
          if (localObject != null) {
            ((ARGlobalConfigManager)localObject).b();
          }
          if (QLog.isColorLevel()) {
            QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "we delete ARConfig info here");
          }
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, version same");
      }
      if (QLog.isColorLevel()) {
        QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, config type 188");
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    QLog.d("SPLASH_ConfigServlet", 1, " call  getServiceAccountFolderConfig ");
    a(paramQQAppInterface, 81, paramString);
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    try
    {
      String str = a(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      if (str != null)
      {
        paramString = new StringBuilder();
        paramString.append(str.substring(str.indexOf("<?xml"), str.indexOf("</msg><msg")));
        paramString.append("</msg>");
        paramString = paramString.toString();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("qav_upgrade_invite msg1 = ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str.substring(str.indexOf("<?xml"), str.indexOf("?>")));
        ((StringBuilder)localObject).append("?>");
        localObject = ((StringBuilder)localObject).toString();
        str = str.substring(str.indexOf("</msg><msg"), str.lastIndexOf("</msg>"));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(str.substring(6));
        localStringBuilder.append("</msg>");
        str = localStringBuilder.toString();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("qav_upgrade_invite msg2 = ");
          ((StringBuilder)localObject).append(str);
          QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject).toString());
        }
        localObject = SharedPreUtils.b(paramQQAppInterface.getCurrentAccountUin());
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_video", paramString).commit();
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_multi", str).commit();
        SharedPreUtils.h(paramQQAppInterface.getApplication(), paramInt, jdField_a_of_type_JavaLangString);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("parse qav_upgrade_invite xml  exception : ");
        paramString.append(paramQQAppInterface.getMessage());
        QLog.i("SPLASH_ConfigServlet", 2, paramString.toString());
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getShortVideoResourceConfig| getType=");
      localStringBuilder.append(paramInt);
      QLog.i("ShortVideoResourceManager", 2, localStringBuilder.toString());
    }
    ShortVideoResourceManager.a = System.currentTimeMillis();
    a(paramQQAppInterface, 718, null);
  }
  
  private void c(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = paramIntent.getStringExtra("key_uin");
    if (!TextUtils.isEmpty(paramIntent))
    {
      int i = paramConfig.version.get();
      int j = SharedPreUtils.q(paramQQAppInterface.getApp(), paramIntent);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("serverVersion=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("|localVersion=");
        ((StringBuilder)localObject).append(j);
        QLog.d("nearby_flower_operation_gray_tips", 2, ((StringBuilder)localObject).toString());
      }
      if (i != j)
      {
        SharedPreUtils.c(paramQQAppInterface.getApp(), paramIntent, i);
        localObject = (NearbyFlowerManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_FLOWER_MANAGER);
        if ((paramConfig.content_list.has()) && (paramConfig.content_list.get().size() > 0))
        {
          paramQQAppInterface = paramConfig.content_list.get();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
          {
            ((NearbyFlowerManager)localObject).a(paramIntent, (String)paramQQAppInterface.get(0));
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("receiveAllConfigs|type: 53,content: ");
              paramIntent.append((String)paramQQAppInterface.get(0));
              paramIntent.append(",version: ");
              paramIntent.append(paramConfig.version.get());
              QLog.d("SPLASH_ConfigServlet", 2, paramIntent.toString());
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 53,content_list is empty ,version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
        }
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.O(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleRespNewBoatConfig: ,version: ");
      localStringBuilder.append(paramConfig.version.get());
      localStringBuilder.append("| localVersion: ");
      localStringBuilder.append(j);
      QLog.i("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
    }
    if (i != j)
    {
      SharedPreUtils.r(BaseApplication.getContext(), i, jdField_a_of_type_JavaLangString);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        HotReactiveHelper.a(paramQQAppInterface, (String)paramConfig.get(0));
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig:localVersiont == version ");
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, 43, paramString);
  }
  
  private void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    try
    {
      paramString = a(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      if (paramString != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("qav_anychat_time_limit stream = ");
          localStringBuilder.append(paramString);
          QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
        }
        SharedPreUtils.d(paramQQAppInterface.getCurrentAccountUin()).edit().putString("qav_anychat_time_value", paramString).commit();
        SharedPreUtils.i(paramQQAppInterface.getApplication(), paramInt, jdField_a_of_type_JavaLangString);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("parse qav_anychat_time_limit  exception : ");
        paramString.append(paramQQAppInterface.getMessage());
        QLog.i("SPLASH_ConfigServlet", 2, paramString.toString());
      }
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = paramIntent.getStringExtra("key_uin");
    if (!TextUtils.isEmpty(paramIntent))
    {
      int i = paramConfig.version.get();
      int j = SharedPreUtils.r(paramQQAppInterface.getApp(), paramIntent);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("serverVersion=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("|localVersion=");
        ((StringBuilder)localObject).append(j);
        QLog.d("HotChatManager", 2, ((StringBuilder)localObject).toString());
      }
      if (i != j)
      {
        SharedPreUtils.d(paramQQAppInterface.getApp(), paramIntent, i);
        localObject = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((paramConfig.content_list.has()) && (paramConfig.content_list.get().size() > 0))
        {
          paramQQAppInterface = paramConfig.content_list.get();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
          {
            ((HotChatManager)localObject).a(paramIntent, (String)paramQQAppInterface.get(0));
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("receiveAllConfigs|type: 78,content: ");
              paramIntent.append((String)paramQQAppInterface.get(0));
              paramIntent.append(",version: ");
              paramIntent.append(paramConfig.version.get());
              QLog.d("SPLASH_ConfigServlet", 2, paramIntent.toString());
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 78,content_list is empty ,version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
        }
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      NearbyUtils.a("GENERAL_LBS_CONFIGS_CMD", new Object[] { "getGeneralLBSConfigs", paramString, Long.valueOf(l) });
    }
    QConfigManager.a(new int[] { 12, 174, 189 }, paramString);
  }
  
  private void d(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str2 = "url";
    Object localObject3;
    int i;
    try
    {
      paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      localObject1 = paramString.getElementsByTagName("pushbanner");
      str1 = "";
      paramInt = 0;
      if (paramInt >= ((NodeList)localObject1).getLength()) {
        break label1130;
      }
      l1 = Long.parseLong(paramString.getElementsByTagName("channel").item(paramInt).getFirstChild().getNodeValue());
      localObject7 = paramString.getElementsByTagName("img").item(paramInt).getFirstChild().getNodeValue();
      localObject4 = paramString.getElementsByTagName("digest").item(paramInt).getFirstChild().getNodeValue();
      j = Integer.parseInt(paramString.getElementsByTagName("weight").item(paramInt).getFirstChild().getNodeValue());
      localObject3 = paramString.getElementsByTagName("md5").item(paramInt).getFirstChild();
      if (localObject3 != null) {
        str1 = ((Node)localObject3).getNodeValue();
      }
      localObject5 = paramString.getElementsByTagName("end").item(paramInt).getFirstChild().getNodeValue();
      localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      l2 = ((SimpleDateFormat)localObject3).parse((String)localObject5).getTime();
      localObject5 = paramString.getElementsByTagName("begin");
      localObject3 = ((SimpleDateFormat)localObject3).parse(((NodeList)localObject5).item(paramInt).getFirstChild().getNodeValue());
      l3 = ((Date)localObject3).getTime();
      if (System.currentTimeMillis() > l2)
      {
        if (!QLog.isColorLevel()) {
          break label1131;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner is outdate , throw it");
        break label1131;
      }
      localObject5 = new StringBuffer();
      i = 0;
      for (;;)
      {
        localObject3 = localObject1;
        if (i >= paramString.getElementsByTagName(str2).item(paramInt).getChildNodes().getLength()) {
          break;
        }
        ((StringBuffer)localObject5).append(paramString.getElementsByTagName(str2).item(paramInt).getChildNodes().item(i).getNodeValue());
        i += 1;
        localObject1 = localObject3;
      }
      str3 = ((StringBuffer)localObject5).toString();
      localObject6 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject1 = ((EntityManager)localObject6).query(ExpiredPushBanner.class);
      if (localObject1 == null) {
        break label1144;
      }
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      label466:
      if (!((Iterator)localObject1).hasNext()) {
        break label1141;
      }
      if (((ExpiredPushBanner)((Iterator)localObject1).next()).cid != l1) {
        break label1138;
      }
      i = 1;
    }
    catch (Exception paramQQAppInterface)
    {
      Object localObject1;
      String str1;
      long l1;
      Object localObject7;
      Object localObject4;
      int j;
      Object localObject5;
      long l2;
      long l3;
      String str3;
      Object localObject6;
      label501:
      String str4;
      boolean bool;
      PicAndAdConf localPicAndAdConf1;
      PicAndAdConf localPicAndAdConf2;
      String str5;
      short s;
      label1037:
      paramQQAppInterface.printStackTrace();
      if (!QLog.isColorLevel()) {
        break label1130;
      }
      paramString = new StringBuilder();
      paramString.append("push exception : ");
      paramString.append(paramQQAppInterface.getMessage());
      QLog.i("SPLASH_ConfigServlet", 2, paramString.toString());
    }
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner had been close or click , throw it");
      }
    }
    else if (str1.length() < 15)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner md5 length < 15 .throw");
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
      ((StringBuilder)localObject1).append("/ADPic/");
      ((StringBuilder)localObject1).append(str1);
      str4 = ((StringBuilder)localObject1).toString();
      bool = ConfigParser.a(str1);
      if (bool) {
        break label1157;
      }
      ThreadManager.executeOnNetWorkThread(new ConfigServlet.4(this, (String)localObject7));
      localPicAndAdConf1 = Config.a;
      localPicAndAdConf2 = Config.a;
      localObject5 = paramString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(l3);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(l2);
      str5 = ((StringBuilder)localObject1).toString();
      s = (short)j;
      localObject1 = localObject6;
      j = paramInt;
      localPicAndAdConf1.a(localPicAndAdConf2.a(l1, (String)localObject4, (byte)3, (String)localObject7, str3, str4, str5, s, str1));
      try
      {
        localObject6 = ((EntityManager)localObject1).query(ReportedBanner.class, false, null, null, null, null, "endtime DESC", null);
        if ((localObject6 == null) || (((List)localObject6).size() <= 0)) {
          break label1182;
        }
        localObject4 = ((List)localObject6).iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject7 = (ReportedBanner)((Iterator)localObject4).next();
        } while ((localObject7 == null) || (((ReportedBanner)localObject7).cid != l1));
        i = 0;
        localObject4 = localObject1;
        if (((List)localObject6).size() <= 18) {
          break label1175;
        }
        int k = ((List)localObject6).size() - 1;
        localObject4 = localObject1;
        if (k < 9) {
          break label1175;
        }
        localObject4 = (ReportedBanner)((List)localObject6).get(k);
        if ((localObject4 == null) || (((ReportedBanner)localObject4).cid == l1)) {
          break label1166;
        }
        ((EntityManager)localObject1).remove((Entity)localObject4);
      }
      catch (Throwable localThrowable2) {}
      if (i != 0)
      {
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X80087C0", "0X80087C0", (int)l1, 0, "", "", "", "");
        localObject4 = new ReportedBanner();
        ((ReportedBanner)localObject4).cid = l1;
      }
      try
      {
        ((ReportedBanner)localObject4).md5 = str1;
        ((ReportedBanner)localObject4).endtime = l2;
        ((EntityManager)localObject1).persist((Entity)localObject4);
        if (!QLog.isColorLevel()) {
          break label1150;
        }
        QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report cid: %d", new Object[] { Long.valueOf(l1) }));
      }
      catch (Throwable localThrowable1)
      {
        break label1037;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report repeat cid: %d", new Object[] { Long.valueOf(l1) }));
        break label1150;
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report exception t: %s", new Object[] { localThrowable2 }));
          paramString = (String)localObject5;
          paramInt = j;
        }
      }
    }
    label1130:
    label1131:
    label1138:
    label1141:
    label1144:
    label1150:
    for (;;)
    {
      paramInt += 1;
      Object localObject2 = localObject3;
      break;
      return;
      localObject3 = localObject2;
      continue;
      break label466;
      break label501;
      i = 0;
      break label501;
    }
  }
  
  private void e(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = CapturePtvTemplateManager.a();
    int j = paramConfig.version.get();
    int i = SharedPreUtils.i(paramQQAppInterface.getApp());
    if (!CapturePtvTemplateManager.a()) {
      i = 0;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("serverVersion=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("|localVersion=");
      ((StringBuilder)localObject).append(i);
      QLog.d("CapturePtvTemplateManager_VideoRedbag", 2, ((StringBuilder)localObject).toString());
    }
    if (j != i)
    {
      SharedPreUtils.g(paramQQAppInterface.getApp(), j);
      try
      {
        localObject = b(paramConfig, i, 226);
        if (localObject != null)
        {
          paramIntent.a(paramQQAppInterface, (String)localObject, 1);
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("receiveAllConfigs|type: 226,content: ");
            paramQQAppInterface.append((String)localObject);
            paramQQAppInterface.append(",version: ");
            paramQQAppInterface.append(paramConfig.version.get());
            QLog.d("CapturePtvTemplateManager", 2, paramQQAppInterface.toString());
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("receiveAllConfigs|type: 226,content_list is empty ,version: ");
            ((StringBuilder)localObject).append(paramConfig.version.get());
            QLog.d("CapturePtvTemplateManager", 2, ((StringBuilder)localObject).toString());
          }
          paramIntent.a(paramQQAppInterface, "", 1);
          return;
        }
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("receiveAllConfigs|exception:");
          paramIntent.append(paramQQAppInterface.getMessage());
          QLog.e("CapturePtvTemplateManager", 2, paramIntent.toString());
        }
      }
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, 185, paramString);
  }
  
  private void e(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str3 = "width";
    Object localObject2;
    int i;
    float f5;
    try
    {
      localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      NodeList localNodeList = ((Document)localObject1).getElementsByTagName("splash_birth");
      str6 = "left";
      localObject2 = "left";
      str5 = "";
      paramString = str5;
      str4 = paramString;
      i = 0;
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      f4 = 0.0F;
      bool = false;
      str1 = paramString;
      paramString = str6;
      if (i < localNodeList.getLength())
      {
        str5 = ((Document)localObject1).getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
        str4 = ((Document)localObject1).getElementsByTagName("md5").item(i).getFirstChild().getNodeValue();
        f5 = Float.parseFloat(((Document)localObject1).getElementsByTagName("x").item(i).getFirstChild().getNodeValue());
      }
    }
    catch (Exception paramQQAppInterface)
    {
      Object localObject1;
      String str5;
      String str4;
      float f4;
      boolean bool;
      String str1;
      label226:
      float f6;
      return;
    }
    try
    {
      f1 = Float.parseFloat(((Document)localObject1).getElementsByTagName("ay").item(i).getFirstChild().getNodeValue());
      bool = true;
    }
    catch (Exception localException1)
    {
      break label226;
    }
    float f1 = Float.parseFloat(((Document)localObject1).getElementsByTagName("y").item(i).getFirstChild().getNodeValue());
    float f3 = Float.parseFloat(((Document)localObject1).getElementsByTagName(str3).item(i).getFirstChild().getNodeValue());
    f6 = Float.parseFloat(((Document)localObject1).getElementsByTagName("height").item(i).getFirstChild().getNodeValue());
    String str6 = ((Document)localObject1).getElementsByTagName("color").item(i).getFirstChild().getNodeValue();
    f4 = Float.parseFloat(((Document)localObject1).getElementsByTagName("size").item(i).getFirstChild().getNodeValue());
    float f2 = Float.parseFloat(((Document)localObject1).getElementsByTagName(str3).item(i).getFirstChild().getNodeValue());
    try
    {
      str1 = ((Document)localObject1).getElementsByTagName("align").item(i).getFirstChild().getNodeValue();
    }
    catch (Exception localException2)
    {
      label445:
      break label445;
      i += 1;
      localObject2 = localException2;
      str2 = str6;
      f3 = f1;
      f1 = f2;
      f2 = f5;
    }
    str1 = paramString;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("birthday-splash parse result,img == ");
      ((StringBuilder)localObject2).append(str5);
      ((StringBuilder)localObject2).append(" ,md5 = ");
      ((StringBuilder)localObject2).append(str4);
      ((StringBuilder)localObject2).append(" ,x=");
      ((StringBuilder)localObject2).append(f5);
      ((StringBuilder)localObject2).append(" ,y=");
      ((StringBuilder)localObject2).append(f1);
      ((StringBuilder)localObject2).append(" ,useAy=");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(" ,width=");
      ((StringBuilder)localObject2).append(f3);
      ((StringBuilder)localObject2).append(" ,height=");
      ((StringBuilder)localObject2).append(f6);
      ((StringBuilder)localObject2).append(" ,color=");
      ((StringBuilder)localObject2).append(str6);
      ((StringBuilder)localObject2).append(" ,font_size=");
      ((StringBuilder)localObject2).append(f4);
      ((StringBuilder)localObject2).append(" ,align=");
      ((StringBuilder)localObject2).append(str1);
      QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
      break label798;
      if ((str5 != null) && (!str5.trim().equals("")))
      {
        paramString = new StringBuilder();
        paramString.append(paramQQAppInterface.getApplication().getFilesDir().getAbsolutePath());
        paramString.append("/");
        paramString.append(jdField_a_of_type_JavaLangString);
        paramString.append("/");
        paramString.append("birthdayflashlogo.png");
        paramString = paramString.toString();
        localObject1 = MsfSdkUtils.insertMtype("ConfigCheck", str5);
        if (f1 >= 0.0F) {
          break label827;
        }
        f1 = 50.0F;
      }
    }
    label798:
    label827:
    for (;;)
    {
      ThreadManager.post(new ConfigServlet.5(this, paramString, paramQQAppInterface, (String)localObject1, f2, f3, f1, str1, (String)localObject2, f4, bool, paramInt, str4), 2, null, false);
      return;
      String str2;
      break;
    }
  }
  
  private void f(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = PtvTemplateManager.a(paramQQAppInterface);
    int j = paramConfig.version.get();
    int i = SharedPreUtils.h(paramQQAppInterface.getApp());
    if (!PtvTemplateManager.a()) {
      i = 0;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("serverVersion=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("|localVersion=");
      ((StringBuilder)localObject).append(i);
      QLog.d("PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
    if (j != i)
    {
      SharedPreUtils.f(paramQQAppInterface.getApp(), j);
      if ((paramConfig.content_list.has()) && (paramConfig.content_list.get().size() > 0))
      {
        localObject = paramConfig.content_list.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramIntent.a((String)((List)localObject).get(0), paramQQAppInterface, 1);
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("receiveAllConfigs|type: 84,content: ");
            paramQQAppInterface.append((String)((List)localObject).get(0));
            paramQQAppInterface.append(",version: ");
            paramQQAppInterface.append(paramConfig.version.get());
            QLog.d("PtvTemplateManager", 2, paramQQAppInterface.toString());
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("receiveAllConfigs|type: 84,content_list is empty ,version: ");
        paramQQAppInterface.append(paramConfig.version.get());
        QLog.d("PtvTemplateManager", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  private void f(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramQQAppInterface.getApplication().getFilesDir().getAbsolutePath());
        ((StringBuilder)localObject1).append("/splashpic/");
        String str3 = ((StringBuilder)localObject1).toString();
        Object localObject3 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        Object localObject4 = ((Document)localObject3).getElementsByTagName("splash");
        i = 0;
        paramString = "";
        localObject1 = paramString;
        String str2 = null;
        String str1 = null;
        Object localObject2 = null;
        int j = ((NodeList)localObject4).getLength();
        if (i < j)
        {
          str2 = ((Document)localObject3).getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
          str1 = ((Document)localObject3).getElementsByTagName("begin").item(i).getFirstChild().getNodeValue();
          localObject2 = ((Document)localObject3).getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
          paramString = ((Document)localObject3).getElementsByTagName("md5").item(i).getFirstChild().getNodeValue();
          localObject1 = ((Document)localObject3).getElementsByTagName("channel").item(i).getFirstChild().getNodeValue();
          String str4 = ((Document)localObject3).getElementsByTagName("title").item(i).getFirstChild().getNodeValue();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse result,img == ");
            localStringBuilder.append(str2);
            localStringBuilder.append(" ,begin = ");
            localStringBuilder.append(str1);
            localStringBuilder.append(" ,end=");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(",md5=");
            localStringBuilder.append(paramString);
            localStringBuilder.append(" title = ");
            localStringBuilder.append(str4);
            QLog.i("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
          }
        }
        else
        {
          if ((str2 != null) && (!str2.trim().equals("")))
          {
            str2 = MsfSdkUtils.insertMtype("ConfigCheck", str2);
            localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(((SimpleDateFormat)localObject3).parse(str1).getTime());
            ((StringBuilder)localObject4).append("|");
            ((StringBuilder)localObject4).append(((SimpleDateFormat)localObject3).parse((String)localObject2).getTime());
            str1 = ((StringBuilder)localObject4).toString();
            SharedPreUtils.a(paramQQAppInterface.getApplication(), paramInt, str1, paramString);
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramQQAppInterface.getApplication().getFilesDir().getAbsolutePath());
            ((StringBuilder)localObject4).append("/splashpic");
            new File(((StringBuilder)localObject4).toString());
            if (((SimpleDateFormat)localObject3).parse((String)localObject2).getTime() < System.currentTimeMillis())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append(str3);
              paramQQAppInterface.append(paramString);
              paramQQAppInterface = new File(paramQQAppInterface.toString());
              if (paramQQAppInterface.exists()) {
                paramQQAppInterface.delete();
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("SPLASH_ConfigServlet", 2, "this splash is outdate, throw it");
              return;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(str3);
            ((StringBuilder)localObject2).append(paramString);
            localObject2 = new File(((StringBuilder)localObject2).toString());
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(str3);
            ((StringBuilder)localObject3).append(str1);
            ((StringBuilder)localObject3).append("_");
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append("_");
            ((StringBuilder)localObject3).append((String)localObject1);
            localObject3 = new File(((StringBuilder)localObject3).toString());
            if (!((File)localObject3).exists())
            {
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "begin a thread try to download");
              }
              ThreadManager.post(new ConfigServlet.6(this, (File)localObject2, paramQQAppInterface, str2, paramString, (File)localObject3, str3, str1, (String)localObject1, str2), 5, null, true);
            }
          }
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
    paramIntent = PtvTemplateManager.a(paramQQAppInterface);
    int j = paramConfig.version.get();
    int i = SharedPreUtils.j(paramQQAppInterface.getApp());
    if (!PtvTemplateManager.b()) {
      i = 0;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("serverVersion=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("|localVersion=");
      ((StringBuilder)localObject).append(i);
      QLog.d("PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
    if (j != i)
    {
      SharedPreUtils.h(paramQQAppInterface.getApp(), j);
      localObject = b(paramConfig, i, 167);
      if (localObject != null)
      {
        paramIntent.a((String)localObject, paramQQAppInterface, 2);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 167,content: ");
          paramQQAppInterface.append((String)localObject);
          paramQQAppInterface.append(",version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("PtvTemplateManager", 2, paramQQAppInterface.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("receiveAllConfigs|type: 167,content_list is empty ,version: ");
        paramQQAppInterface.append(paramConfig.version.get());
        QLog.d("PtvTemplateManager", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  private void h(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    NearbyGrayTipsManager localNearbyGrayTipsManager;
    Object localObject1;
    String str;
    Object localObject2;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_uin")))
    {
      int i = paramConfig.version.get();
      int j = SharedPreUtils.f(paramQQAppInterface.getApp());
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("serverVersion=");
        paramIntent.append(i);
        paramIntent.append("|localVersion=");
        paramIntent.append(j);
        QLog.d("nearby_aio_operation_gray_tips", 2, paramIntent.toString());
      }
      if (i != j)
      {
        SharedPreUtils.d(paramQQAppInterface.getApp(), i);
        localNearbyGrayTipsManager = (NearbyGrayTipsManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_GRAY_TIPS_MANAGER);
        if ((paramConfig.content_list.has()) && (paramConfig.content_list.get().size() > 0))
        {
          paramIntent = paramConfig.content_list.get();
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("config.content_list size=");
            ((StringBuilder)localObject1).append(paramIntent.size());
            QLog.d("nearby_aio_operation_gray_tips", 2, ((StringBuilder)localObject1).toString());
          }
          if ((paramIntent == null) || (paramIntent.size() <= 0)) {
            break label582;
          }
          localNearbyGrayTipsManager.b();
          Iterator localIterator = paramIntent.iterator();
          if (localIterator.hasNext())
          {
            str = (String)localIterator.next();
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("receiveAllConfigs|type: 23,content: ");
              paramIntent.append(str);
              paramIntent.append(",version: ");
              paramIntent.append(paramConfig.version.get());
              QLog.d("SPLASH_ConfigServlet", 2, paramIntent.toString());
            }
            if (!StringUtil.a(str))
            {
              label362:
              try
              {
                localObject2 = new JSONObject(str);
                if (((JSONObject)localObject2).isNull("MD5")) {
                  break label586;
                }
                localObject1 = ((JSONObject)localObject2).getString("MD5");
                paramIntent = (Intent)localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label583;
                }
                paramIntent = ((String)localObject1).toLowerCase();
              }
              catch (JSONException paramIntent) {}
              if (((JSONObject)localObject2).isNull("URL")) {
                break label591;
              }
              localObject1 = ((JSONObject)localObject2).getString("URL");
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!StringUtil.a((String)localObject1))
      {
        localObject2 = NearbyGrayTipsManager.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("temp.txt");
        localObject2 = new File(localStringBuilder.toString());
        try
        {
          ThreadManager.post(new ConfigServlet.7(this, paramQQAppInterface, (String)localObject1, (File)localObject2, paramIntent, localNearbyGrayTipsManager), 8, null, false);
        }
        catch (JSONException paramIntent) {}
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("JSONException was thrown when parse json!!! string=");
          ((StringBuilder)localObject1).append(str);
          QLog.d("nearby_aio_operation_gray_tips", 2, ((StringBuilder)localObject1).toString());
        }
        paramIntent.printStackTrace();
      }
      break;
      localNearbyGrayTipsManager.a();
      localNearbyGrayTipsManager.a(true);
      return;
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("receiveAllConfigs|type: 23,content_list is empty ,version: ");
        paramQQAppInterface.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
      }
      localNearbyGrayTipsManager.b();
      label582:
      return;
      label583:
      break label362;
      label586:
      paramIntent = null;
      break label362;
      label591:
      localObject1 = null;
    }
  }
  
  private void i(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i == SharedPreUtils.o(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString)) {
      return;
    }
    SharedPreUtils.j(paramQQAppInterface.getApp(), i, jdField_a_of_type_JavaLangString);
    Object localObject1;
    Object localObject2;
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      localObject1 = paramConfig.content_list.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramIntent = new HashMap();
        i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (String)((List)localObject1).get(i);
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("receiveAllConfigs|type: 115,content: ");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(",version: ");
            localStringBuilder.append(paramConfig.version.get());
            QLog.d("Q.qqstory.fourTab", 2, localStringBuilder.toString());
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = ((String)localObject2).split("=");
            if ((localObject2 != null) && (localObject2.length == 2))
            {
              paramIntent.put(localObject2[0], localObject2[1]);
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("NowTabConfigCmd, name=");
                localStringBuilder.append(localObject2[0]);
                localStringBuilder.append(", val=");
                localStringBuilder.append(localObject2[1]);
                QLog.i("Q.qqstory.fourTab", 2, localStringBuilder.toString());
              }
            }
          }
          i += 1;
        }
        paramConfig = (String)paramIntent.get("mqq_nowtab_plan");
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("nowtabPlan=");
          ((StringBuilder)localObject1).append(paramConfig);
          QLog.i("nowtabPlan", 2, ((StringBuilder)localObject1).toString());
        }
        if (paramConfig == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = paramQQAppInterface.getNowLiveManager().a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((String)localObject1).charAt(2));
        i = Integer.valueOf(((StringBuilder)localObject2).toString()).intValue();
        int j = Integer.valueOf(paramConfig).intValue();
        if (i != j)
        {
          localObject1 = new Integer[5];
          if ((j == 0) || (j == 1)) {
            break label959;
          }
          if (j != 2)
          {
            if (j == 3)
            {
              localObject1[2] = Integer.valueOf(j);
              localObject1[1] = Integer.valueOf(1);
              paramQQAppInterface.getNowLiveManager().a((Integer[])localObject1);
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("case 3 nowtabPlan=");
                ((StringBuilder)localObject1).append(paramConfig);
                QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, ((StringBuilder)localObject1).toString());
              }
            }
          }
          else
          {
            localObject1[1] = Integer.valueOf(0);
            localObject1[2] = Integer.valueOf(j);
            paramQQAppInterface.getNowLiveManager().a((Integer[])localObject1);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("case 2 nowtabPlan=");
              ((StringBuilder)localObject1).append(paramConfig);
              QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, ((StringBuilder)localObject1).toString());
              continue;
              if (i < localObject1.length)
              {
                localObject1[i] = Integer.valueOf(0);
                i += 1;
                continue;
              }
              localObject1[2] = Integer.valueOf(j);
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("case 0 1 nowtabPlan=");
                ((StringBuilder)localObject2).append(paramConfig);
                QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, ((StringBuilder)localObject2).toString());
              }
              paramQQAppInterface.getNowLiveManager().a((Integer[])localObject1);
            }
          }
        }
        paramQQAppInterface.getNowLiveManager().a = paramConfig.charAt(0);
      }
      catch (Exception paramConfig)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(paramConfig.getMessage());
        QLog.w("Q.qqstory.fourTab:nowtabPlan", 2, ((StringBuilder)localObject1).toString(), paramConfig);
      }
      paramConfig = (String)paramIntent.get("mqq_nowtab_index");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("nowtabIndex=");
        ((StringBuilder)localObject1).append(paramConfig);
        QLog.i("Q.qqstory.fourTab:nowtabIndex", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramConfig != null) {}
      try
      {
        paramQQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0).edit().putInt("now_index_key", Integer.valueOf(paramConfig).intValue());
        paramQQAppInterface.getNowLiveManager().c = Integer.valueOf(paramConfig).intValue();
      }
      catch (Exception paramConfig)
      {
        label855:
        break label855;
      }
      QLog.w("Q.qqstory.fourTab:nowtabIndex", 2, "nowtabIndex is not value of Int!");
      paramIntent = (String)paramIntent.get("mqq_open_myvideo");
      if (QLog.isColorLevel())
      {
        paramConfig = new StringBuilder();
        paramConfig.append("IsOpenMyVideo=");
        paramConfig.append(paramIntent);
        QLog.i("Q.qqstory:IsOpenMyVideo", 2, paramConfig.toString());
      }
      try
      {
        if (TextUtils.isEmpty(paramIntent)) {
          break label950;
        }
        ((QQStoryManager)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER)).h(Boolean.parseBoolean(paramIntent));
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        label940:
        label950:
        break label940;
      }
      QLog.w("Q.qqstory:drawerMyVideoItem", 2, "drawerMyVideoItem is not value of Int!");
      return;
      label959:
      i = 0;
    }
  }
  
  private void j(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.p(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    if (i == j) {
      return;
    }
    SharedPreUtils.k(paramQQAppInterface.getApp(), i, jdField_a_of_type_JavaLangString);
    for (;;)
    {
      try
      {
        if (paramConfig.msg_content_list == null) {
          break label241;
        }
        i = paramConfig.msg_content_list.size();
        paramQQAppInterface = (NowGeneralConfigManager)paramQQAppInterface.getManager(QQManagerFactory.NOW_DOWNLOAD_ENGINE_MANAGER);
        if (i > 0)
        {
          paramIntent = b(paramConfig, j, 286);
          paramQQAppInterface.a(paramIntent);
          if (!TextUtils.isEmpty(paramIntent))
          {
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("GetDoodleTemplateConfig|type: handleNowDownloadEngineConfigCmd, content: \n");
              paramQQAppInterface.append(paramIntent);
              QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
            }
          }
          else if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNowDownloadEngineConfigCmd null");
          }
        }
        else
        {
          paramQQAppInterface.a("");
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("receiveAllConfigs|type: 286,content_list is empty ,version: ");
            paramQQAppInterface.append(paramConfig.version.get());
            QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
            return;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("Exception e = ");
        paramIntent.append(paramQQAppInterface.toString());
        QLog.e("SPLASH_ConfigServlet", 2, paramIntent.toString());
      }
      return;
      label241:
      i = -1;
    }
  }
  
  private void k(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void l(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    PtvTemplateManager localPtvTemplateManager = PtvTemplateManager.a(paramQQAppInterface);
    int j = paramConfig.version.get();
    int i = SharedPreUtils.m(paramQQAppInterface.getApp());
    if (!PtvTemplateManager.d()) {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("GetBlessSpecialPendantConfig serverVersion=");
      paramIntent.append(j);
      paramIntent.append("|localVersion=");
      paramIntent.append(i);
      QLog.d("PtvTemplateManager", 2, paramIntent.toString());
    }
    if (j != i)
    {
      SharedPreUtils.j(paramQQAppInterface.getApp(), j);
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramIntent != null)
        {
          Object localObject = null;
          if (paramIntent.compress.get() == 1)
          {
            byte[] arrayOfByte = OlympicUtil.a(paramIntent.content.get().toByteArray());
            paramIntent = localObject;
            if (arrayOfByte != null) {
              try
              {
                paramIntent = new String(arrayOfByte, "UTF-8");
              }
              catch (Exception paramIntent)
              {
                paramIntent.printStackTrace();
                paramIntent = localObject;
              }
            }
          }
          else
          {
            paramIntent = paramIntent.content.get().toStringUtf8();
          }
          localPtvTemplateManager.b(paramIntent, paramQQAppInterface);
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("receiveAllConfigs|type: 145,content: ");
            paramQQAppInterface.append(paramIntent);
            paramQQAppInterface.append(",version: ");
            paramQQAppInterface.append(paramConfig.version.get());
            QLog.d("PtvTemplateManager", 2, paramQQAppInterface.toString());
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("receiveAllConfigs|type: 145,content_list is empty ,version: ");
        paramQQAppInterface.append(paramConfig.version.get());
        QLog.d("PtvTemplateManager", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static void v(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int k = paramConfig.version.get();
    int m = SharedPreUtils.am(paramQQAppInterface.getApp().getBaseContext(), jdField_a_of_type_JavaLangString);
    int i;
    if (paramConfig.msg_content_list != null) {
      i = paramConfig.msg_content_list.size();
    } else {
      i = -1;
    }
    boolean bool1 = QLog.isColorLevel();
    int j = 0;
    if (bool1) {
      QLog.d("handleScribbleRedSwitchConfigSPLASH_ConfigServlet", 2, String.format("scribble回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) }));
    }
    if (k == m) {
      return;
    }
    if (i > 0)
    {
      boolean bool2;
      for (bool1 = false; j < i; bool1 = bool2)
      {
        Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(j);
        bool2 = bool1;
        if (localObject1 != null)
        {
          if (((ConfigurationService.Content)localObject1).compress.get() == 1)
          {
            byte[] arrayOfByte = OlympicUtil.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
            localObject4 = null;
            if (arrayOfByte == null)
            {
              QLog.e("handleScribbleRedSwitchConfigSPLASH_ConfigServlet", 2, "解压错误");
              localObject1 = localObject4;
            }
            else
            {
              try
              {
                localObject1 = new String(arrayOfByte, "UTF-8");
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                if (QLog.isColorLevel()) {
                  localOutOfMemoryError.printStackTrace();
                }
                System.gc();
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                try
                {
                  localObject2 = new String(arrayOfByte, "UTF-8");
                }
                catch (Throwable localThrowable)
                {
                  for (;;)
                  {
                    Object localObject2;
                    Object localObject3 = localObject4;
                  }
                }
                localUnsupportedEncodingException = localUnsupportedEncodingException;
                localObject2 = localObject4;
                if (!QLog.isColorLevel()) {
                  break label278;
                }
              }
              localUnsupportedEncodingException.printStackTrace();
              localObject2 = localObject4;
            }
          }
          else
          {
            localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
          }
          label278:
          bool2 = bool1;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            bool2 = ScribbleResMgr.a((String)localObject2, paramQQAppInterface.getApp().getBaseContext(), jdField_a_of_type_JavaLangString);
          }
        }
        j += 1;
      }
      if (bool1) {
        SharedPreUtils.u(paramQQAppInterface.getApp().getBaseContext(), k, jdField_a_of_type_JavaLangString);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("handleScribbleRedSwitchConfigSPLASH_ConfigServlet", 2, "回包为空");
    }
  }
  
  public static void y(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.an(BaseApplication.getContext(), jdField_a_of_type_JavaLangString);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleReceiptConfig: ,version: ");
      ((StringBuilder)localObject).append(paramConfig.version.get());
      ((StringBuilder)localObject).append("| localVersion: ");
      ((StringBuilder)localObject).append(j);
      QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject).toString());
    }
    if (i != j)
    {
      SharedPreUtils.H(BaseApplication.getContext(), jdField_a_of_type_JavaLangString, i);
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
    else if (QLog.isColorLevel())
    {
      QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
    }
  }
  
  public void A(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("tim_login_jump", 0))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        try
        {
          paramConfig = new JSONObject((String)paramConfig.get(0));
          if (paramConfig.has("LoginedTipForTIM"))
          {
            Object localObject1 = paramQQAppInterface.getApp();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("tim_login_shared_pre_");
            ((StringBuilder)localObject2).append(paramQQAppInterface.getCurrentUin());
            localObject2 = ((StringBuilder)localObject2).toString();
            boolean bool = false;
            localObject1 = ((BaseApplication)localObject1).getSharedPreferences((String)localObject2, 0).edit();
            paramConfig = paramConfig.getJSONObject("LoginedTipForTIM");
            if (paramConfig.has("On"))
            {
              if (paramConfig.getInt("On") == 1) {
                bool = true;
              }
              ((SharedPreferences.Editor)localObject1).putBoolean("tim_login_s", bool);
            }
            if (paramConfig.has("ShowTipTimeIntervalAfterLogined")) {
              ((SharedPreferences.Editor)localObject1).putInt("tim_login_tal", paramConfig.getInt("ShowTipTimeIntervalAfterLogined"));
            }
            if (paramConfig.has("ShowTipDay")) {
              ((SharedPreferences.Editor)localObject1).putString("tim_login_sd", paramConfig.getJSONArray("ShowTipDay").toString());
            }
            if (paramConfig.has("ShowTipTime")) {
              ((SharedPreferences.Editor)localObject1).putString("tim_login_st", paramConfig.getJSONArray("ShowTipTime").toString());
            }
            if (paramConfig.has("AndroidLimit")) {
              ((SharedPreferences.Editor)localObject1).putInt("tim_login_l", paramConfig.getInt("AndroidLimit"));
            }
            if (paramConfig.has("ShowTipTotalCount")) {
              ((SharedPreferences.Editor)localObject1).putInt("tim_login_tc", paramConfig.getInt("ShowTipTotalCount"));
            }
            if (paramConfig.has("ShowTipHourInterval")) {
              ((SharedPreferences.Editor)localObject1).putInt("tim_login_sti", paramConfig.getInt("ShowTipHourInterval"));
            }
            if (paramConfig.has("Title")) {
              ((SharedPreferences.Editor)localObject1).putString("tim_login_t", paramConfig.getString("Title"));
            }
            if (paramConfig.has("Message")) {
              ((SharedPreferences.Editor)localObject1).putString("tim_login_c", paramConfig.getString("Message"));
            }
            if (paramConfig.has("Buttons")) {
              ((SharedPreferences.Editor)localObject1).putString("tim_login_btns", paramConfig.getJSONArray("Buttons").toString());
            }
            ((SharedPreferences.Editor)localObject1).commit();
            paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
            paramQQAppInterface.putInt("tim_login_jump", i);
            paramQQAppInterface.apply();
            return;
          }
        }
        catch (JSONException paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
        }
      }
    }
  }
  
  public void B(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("tim_pc_banner", 0))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    for (;;)
    {
      try
      {
        paramConfig = new JSONObject((String)paramConfig.get(0));
        if (paramConfig.has("PCTIMLoginBanner"))
        {
          Object localObject = paramQQAppInterface.getApp();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("tim_pc_banner_shared_pre_");
          localStringBuilder.append(paramQQAppInterface.getCurrentUin());
          localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
          paramConfig = paramConfig.getJSONObject("PCTIMLoginBanner");
          if (paramConfig.has("On"))
          {
            int j = paramConfig.getInt("On");
            bool = true;
            if (j != 1) {
              break label357;
            }
            ((SharedPreferences.Editor)localObject).putBoolean("tim_pc_banner_switch", bool);
          }
          if (paramConfig.has("bannerURL")) {
            ((SharedPreferences.Editor)localObject).putString("tim_pc_banner_image_url", paramConfig.getString("bannerURL"));
          }
          if (paramConfig.has("bannerVersion")) {
            ((SharedPreferences.Editor)localObject).putInt("tim_pc_banner_image_ver", paramConfig.getInt("bannerVersion"));
          }
          if (paramConfig.has("androidURL")) {
            ((SharedPreferences.Editor)localObject).putString("tim_pc_banner_click_url", paramConfig.getString("androidURL"));
          }
          if (paramConfig.has("linkText")) {
            ((SharedPreferences.Editor)localObject).putString("tim_pc_banner_link_text", paramConfig.getString("linkText"));
          }
          if (paramConfig.has("androidLinkURL")) {
            ((SharedPreferences.Editor)localObject).putString("tim_pc_banner_link_url", paramConfig.getString("androidLinkURL"));
          }
          ((SharedPreferences.Editor)localObject).commit();
          paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
          paramQQAppInterface.putInt("tim_pc_banner", i);
          paramQQAppInterface.apply();
          return;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      return;
      label357:
      boolean bool = false;
    }
  }
  
  public void C(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("troop_link_config_version", 0))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        if (((ITroopLinkApi)QRoute.api(ITroopLinkApi.class)).saveConfig(paramConfig)) {
          paramQQAppInterface.getPreferences().edit().putInt("troop_link_config_version", i).commit();
        }
      }
    }
  }
  
  public void D(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    if (paramQQAppInterface == null) {
      return;
    }
    boolean bool2 = false;
    if (paramQQAppInterface.getInt("key_game_troop_bind_config_version", 0) != i)
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        if (paramConfig != null)
        {
          try
          {
            paramConfig = new JSONObject(paramConfig);
            boolean bool1 = bool2;
            if (paramConfig.has("showBindGameEntry"))
            {
              bool1 = bool2;
              if (paramConfig.getInt("showBindGameEntry") == 1) {
                bool1 = true;
              }
            }
            paramQQAppInterface.edit().putBoolean("key_game_troop_bind_config_switch", bool1).apply();
            paramQQAppInterface.edit().putInt("key_game_troop_bind_config_version", i).apply();
            if (!QLog.isColorLevel()) {
              return;
            }
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("game troop config set:");
            paramQQAppInterface.append(bool1);
            QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
            return;
          }
          catch (Exception paramQQAppInterface)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          paramConfig = new StringBuilder();
          paramConfig.append("game troop config parse error:");
          paramConfig.append(paramQQAppInterface.toString());
          QLog.e("SPLASH_ConfigServlet", 2, paramConfig.toString());
        }
      }
      else
      {
        paramQQAppInterface.edit().putBoolean("key_game_troop_bind_config_switch", false).apply();
        paramQQAppInterface.edit().putInt("key_game_troop_bind_config_version", i).apply();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "game troop config empty content get");
        }
      }
    }
  }
  
  public void E(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = paramQQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0);
    if ((paramConfig.msg_content_list != null) && (!paramConfig.msg_content_list.isEmpty()))
    {
      if (i != j)
      {
        paramQQAppInterface.getPreferences().edit().putInt("tim_aio_tips_bar_version", i).apply();
        Object localObject = a(paramConfig);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
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
            localJSONException.printStackTrace();
          }
          paramQQAppInterface = (AppGuideTipsManager)paramQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER);
          paramQQAppInterface.a(paramConfig);
          paramQQAppInterface.c();
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, new Object[] { "handleTimAIOTipsBar| config empty, delete config, version=", Integer.valueOf(i) });
    }
    paramQQAppInterface.getPreferences().edit().remove("tim_aio_tips_bar_version").apply();
    ((AppGuideTipsManager)paramQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).d();
  }
  
  public void F(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
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
  
  public void G(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    Object localObject1 = paramQQAppInterface.getPreferences();
    boolean bool4 = false;
    Object localObject2;
    SharedPreferences.Editor localEditor;
    if (i != ((SharedPreferences)localObject1).getInt("data_migration_tim_version", 0))
    {
      paramConfig = a(paramConfig);
      localObject2 = paramQQAppInterface.getApp().getSharedPreferences("data_migration_tim", 0);
      localEditor = ((SharedPreferences)localObject2).edit();
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    for (;;)
    {
      try
      {
        paramConfig = new JSONObject((String)paramConfig.get(0));
        if (!paramConfig.has("DataMigration")) {
          break label505;
        }
        JSONObject localJSONObject = paramConfig.getJSONObject("DataMigration");
        if ((!localJSONObject.has("switch")) || (localJSONObject.getInt("switch") != 1)) {
          break label540;
        }
        bool1 = true;
        if ((!localJSONObject.has("uninstall")) || (localJSONObject.getInt("uninstall") != 1)) {
          break label546;
        }
        bool2 = true;
        boolean bool3 = localJSONObject.has("title");
        String str2 = "";
        if (!bool3) {
          break label552;
        }
        paramConfig = localJSONObject.getString("title");
        if (!localJSONObject.has("content")) {
          break label558;
        }
        localObject1 = localJSONObject.getString("content");
        bool3 = bool4;
        if (localJSONObject.has("uninstallNotify"))
        {
          bool3 = bool4;
          if (localJSONObject.getInt("uninstallNotify") == 1) {
            bool3 = true;
          }
        }
        if (!localJSONObject.has("uninstallTitle")) {
          break label565;
        }
        str1 = localJSONObject.getString("uninstallTitle");
        if (localJSONObject.has("uninstallContent")) {
          str2 = localJSONObject.getString("uninstallContent");
        }
        localObject2 = a((SharedPreferences)localObject2, paramQQAppInterface.getCurrentAccountUin(), bool1);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "handleDataMigrationForTIM| remove all uins");
          }
          localEditor.clear();
        }
        else
        {
          localEditor.putString("data_migration_tim_uins", (String)localObject2);
          localEditor.putBoolean("data_migration_tim_uninstall_flag", bool2);
          localEditor.putString("data_migration_tim_title", paramConfig);
          localEditor.putString("data_migration_tim_content", (String)localObject1);
          localEditor.putBoolean("data_migration_tim_uninstall_notify", bool3);
          localEditor.putString("data_migration_tim_uninstall_title", str1);
          localEditor.putString("data_migration_tim_uninstall_content", str2);
        }
      }
      catch (JSONException paramConfig)
      {
        paramConfig.printStackTrace();
      }
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
      label505:
      localEditor.apply();
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putInt("data_migration_tim_version", i);
      paramQQAppInterface.apply();
      return;
      label540:
      boolean bool1 = false;
      continue;
      label546:
      boolean bool2 = false;
      continue;
      label552:
      paramConfig = "";
      continue;
      label558:
      localObject1 = "";
      continue;
      label565:
      String str1 = "";
    }
  }
  
  public void H(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("call_tim_config_version", 0))
    {
      Object localObject = a(paramConfig);
      paramConfig = paramQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("call_tim_config_pre");
      localStringBuilder.append(paramQQAppInterface.getCurrentUin());
      paramConfig = paramConfig.getSharedPreferences(localStringBuilder.toString(), 0).edit();
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        try
        {
          localObject = new JSONObject((String)((List)localObject).get(0));
          if (!((JSONObject)localObject).has("TIMFreeCloud")) {
            break label253;
          }
          localObject = ((JSONObject)localObject).getJSONObject("TIMFreeCloud");
          if (((JSONObject)localObject).has("On")) {
            paramConfig.putBoolean("call_tim_config_switch", "1".equals(((JSONObject)localObject).getString("On")));
          }
          if (((JSONObject)localObject).has("Title")) {
            paramConfig.putString("call_tim_config_title", ((JSONObject)localObject).getString("Title"));
          }
          if (!((JSONObject)localObject).has("androidURL")) {
            break label253;
          }
          paramConfig.putString("call_tim_config_url", ((JSONObject)localObject).getString("androidURL"));
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      } else {
        paramConfig.putBoolean("call_tim_config_switch", false);
      }
      label253:
      paramConfig.commit();
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putInt("call_tim_config_version", i);
      paramQQAppInterface.apply();
    }
  }
  
  public void I(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() == 281)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      String str = a(paramConfig, SharedPreUtils.a(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0"), 281);
      if (!TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleTroopGiftLimitConfig content: ");
          localStringBuilder.append(str);
          QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
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
        catch (JSONException paramQQAppInterface)
        {
          if (QLog.isColorLevel())
          {
            paramConfig = new StringBuilder();
            paramConfig.append("handleTroopGiftLimitConfig error");
            paramConfig.append(paramQQAppInterface.getMessage());
            QLog.w("SPLASH_ConfigServlet", 2, paramConfig.toString());
          }
        }
      }
    }
  }
  
  public void J(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig != null)
    {
      if (paramConfig.type.get() != 283) {
        return;
      }
      paramQQAppInterface = a(paramConfig);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
      {
        paramQQAppInterface = (String)paramQQAppInterface.get(0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleSafeModeCmd configJson = ");
        localStringBuilder.append(paramQQAppInterface);
        QLog.d("SafeModeUtil", 1, localStringBuilder.toString());
        MsfCmdConfig.executeSafeModeCmd(paramConfig.version.get(), paramQQAppInterface);
      }
      else
      {
        QLog.d("SafeModeUtil", 1, "handleSafeModeCmd null");
      }
      SafeModeUtil.c();
    }
  }
  
  public void K(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j;
    Object localObject1;
    Object localObject2;
    if (paramConfig.type.get() == 284)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      int i = SharedPreUtils.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString);
      j = paramConfig.version.get();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleTaskEntryConfig reqVersion = ");
        ((StringBuilder)localObject1).append(i);
        QLog.w("zivonchen", 2, ((StringBuilder)localObject1).toString());
      }
      if (i != j)
      {
        localObject1 = paramQQAppInterface.getApp();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("task_entry_config");
        ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
        localObject2 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).edit();
        paramConfig = a(paramConfig);
        if ((paramConfig != null) && (paramConfig.size() > 0))
        {
          localObject1 = (String)paramConfig.get(0);
          if (QLog.isColorLevel())
          {
            paramConfig = new StringBuilder();
            paramConfig.append("handleTaskEntryConfig configJson = ");
            paramConfig.append((String)localObject1);
            QLog.w("zivonchen", 2, paramConfig.toString());
          }
        }
      }
    }
    try
    {
      Object localObject3 = new JSONObject((String)localObject1);
      paramConfig = ((JSONObject)localObject3).optString("icon_url");
      String str1 = ((JSONObject)localObject3).optString("night_icon_url");
      String str2 = ((JSONObject)localObject3).optString("jump_url");
      localObject3 = ((JSONObject)localObject3).optString("word");
      boolean bool = TextUtils.isEmpty(paramConfig);
      if ((!bool) && (!TextUtils.isEmpty(str2)))
      {
        ((SharedPreferences.Editor)localObject2).putBoolean("open", true);
        ((SharedPreferences.Editor)localObject2).putString("icon_url", paramConfig);
        ((SharedPreferences.Editor)localObject2).putString("night_icon_url", str1);
        ((SharedPreferences.Editor)localObject2).putString("jump_url", str2);
        ((SharedPreferences.Editor)localObject2).putString("word", (String)localObject3);
      }
      else
      {
        ((SharedPreferences.Editor)localObject2).putBoolean("open", false);
        ((SharedPreferences.Editor)localObject2).remove("icon_url");
        ((SharedPreferences.Editor)localObject2).remove("night_icon_url");
        ((SharedPreferences.Editor)localObject2).remove("jump_url");
        ((SharedPreferences.Editor)localObject2).remove("word");
      }
    }
    catch (JSONException paramConfig)
    {
      label405:
      label462:
      break label405;
    }
    ((SharedPreferences.Editor)localObject2).clear();
    if (QLog.isColorLevel())
    {
      paramConfig = (ConfigurationService.Config)localObject1;
      if (localObject1 == null) {
        paramConfig = "";
      }
      QLog.e("zivonchen", 2, new Object[] { "handleTaskEntryConfig json fail. content: ", paramConfig });
      break label462;
      ((SharedPreferences.Editor)localObject2).clear();
    }
    SharedPreUtils.a(paramQQAppInterface.getApp(), "task_entry_config_version", jdField_a_of_type_JavaLangString, j);
    ((SharedPreferences.Editor)localObject2).commit();
  }
  
  public void L(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != ((IQIMBeautyManager)QRoute.api(IQIMBeautyManager.class)).getBeautyConfigVersion(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        ((IQIMBeautyManager)QRoute.api(IQIMBeautyManager.class)).saveBeautyConfig(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void M(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleBuluoEnterConfig: ,version: ");
      ((StringBuilder)localObject1).append(paramConfig.version.get());
      ((StringBuilder)localObject1).append("| localVersion: ");
      ((StringBuilder)localObject1).append(j);
      QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
    }
    if (i != j)
    {
      localObject1 = a(paramConfig);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        localObject1 = (String)((List)localObject1).get(0);
      }
    }
    try
    {
      paramConfig = new JSONObject((String)localObject1);
      boolean bool = paramConfig.has("jump_url");
      if (bool)
      {
        paramConfig = paramConfig.getJSONObject("jump_url");
        if (paramConfig.has("android"))
        {
          Object localObject2 = new JSONObject(paramConfig.getString("android"));
          if ((((JSONObject)localObject2).has("url")) && (((JSONObject)localObject2).has("scheme")))
          {
            paramConfig = ((JSONObject)localObject2).getString("scheme");
            localObject2 = ((JSONObject)localObject2).getString("url");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramConfig);
            localStringBuilder.append(Base64Util.encodeToString(((String)localObject2).getBytes(), 0));
            paramConfig = localStringBuilder.toString();
            SharedPreUtils.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
            if (QLog.isColorLevel()) {
              QLog.e("SPLASH_ConfigServlet", 2, new Object[] { "handleBuluoEnterConfig. buluoEntryUrl: ", paramConfig });
            }
          }
        }
      }
      else if (paramConfig.has("tribe_summary_url"))
      {
        paramConfig = paramConfig.optJSONObject("tribe_summary_url");
        if (paramConfig.has("android"))
        {
          paramConfig = paramConfig.optString("android");
          SharedPreUtils.d(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
        }
      }
    }
    catch (JSONException paramConfig)
    {
      label355:
      break label355;
    }
    if (QLog.isColorLevel())
    {
      paramConfig = (ConfigurationService.Config)localObject1;
      if (localObject1 == null) {
        paramConfig = "";
      }
      QLog.e("SPLASH_ConfigServlet", 2, new Object[] { "handleBuluoEnterConfig json fail. content: ", paramConfig });
    }
    SharedPreUtils.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", jdField_a_of_type_JavaLangString, i);
    return;
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("handleBuluoEnterConfig json fail. configContent is empty ,version: ");
      paramQQAppInterface.append(paramConfig.version.get());
      QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
      return;
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("handleBuluoEnterConfig:localVersion == version = ");
        paramQQAppInterface.append(i);
        QLog.i("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ConfigurationService.Config paramConfig, int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int j = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleRespQCameraPhoneConfig] ENTER success=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" result=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.camera.configServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramIntent.getStringExtra("uin");
    int i1 = 0;
    int i;
    int k;
    if ((paramBoolean) && (paramConfig != null) && (paramConfig.type.get() == 109) && (paramInt == 0))
    {
      int m = paramConfig.version.get();
      int n = paramIntent.getIntExtra("qcamera_conf_version", 0);
      paramIntent = new StringBuilder();
      paramIntent.append("[handleRespQCameraPhoneConfig] reqVersion=");
      paramIntent.append(n);
      paramIntent.append(" receiveVersion=");
      paramIntent.append(m);
      QLog.i("Q.camera.configServlet", 1, paramIntent.toString());
      i = m;
      paramInt = j;
      j = i1;
      k = n;
      if (m != n)
      {
        CameraUtils.a(BaseApplicationImpl.getContext(), m);
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("[handleRespQCameraPhoneConfig] save version: ");
          paramIntent.append(m);
          paramIntent.append(" and check config version: ");
          paramIntent.append(CameraUtils.a(BaseApplicationImpl.getContext()));
          QLog.d("Q.camera.configServlet", 2, paramIntent.toString());
        }
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
        {
          paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          j = paramIntent.task_id.get();
          i = paramIntent.compress.get();
          paramInt = 3;
          if (i == 1)
          {
            paramIntent = CameraUtils.a(paramIntent.content.get().toByteArray());
            if (paramIntent == null)
            {
              CameraUtils.a(BaseApplicationImpl.getContext(), true);
              QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] uncompress failed");
              paramInt = 4;
            }
            else
            {
              paramIntent = new String(paramIntent);
              if (QLog.isColorLevel()) {
                QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig] zip");
              }
              try
              {
                CameraUtils.a(BaseApplicationImpl.getContext(), paramIntent, m);
                paramInt = 0;
              }
              catch (Exception paramIntent)
              {
                paramIntent.printStackTrace();
              }
            }
          }
          else
          {
            paramIntent = paramIntent.content.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig]");
            }
            try
            {
              CameraUtils.a(BaseApplicationImpl.getContext(), paramIntent, m);
              paramInt = 0;
            }
            catch (Exception paramIntent)
            {
              paramIntent.printStackTrace();
              paramInt = 3;
            }
          }
          i = m;
          k = n;
        }
        else
        {
          paramInt = 5;
          paramIntent = new StringBuilder();
          paramIntent.append("[handleRespQCameraPhoneConfig] no data, current disableCameraSDK=");
          paramIntent.append(CameraUtils.a(BaseApplicationImpl.getContext()));
          QLog.w("Q.camera.configServlet", 1, paramIntent.toString());
          i = m;
          j = i1;
          k = n;
        }
      }
    }
    else
    {
      i = 0;
      paramInt = 1;
      k = 0;
      j = i1;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("[handleRespQCameraPhoneConfig] rptResult=");
    paramIntent.append(paramInt);
    QLog.i("Q.camera.configServlet", 1, paramIntent.toString());
    paramIntent = new HashMap();
    paramIntent.put("rpt_type", String.valueOf(109));
    paramIntent.put("rpt_task_id", String.valueOf(j));
    paramIntent.put("rpt_req_version", String.valueOf(k));
    paramIntent.put("rpt_version", String.valueOf(i));
    paramIntent.put("rpt_report_type", String.valueOf(1));
    paramIntent.put("rpt_result", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "qcamera_phone_config_pull_event", paramBoolean, 0L, 0L, paramIntent, String.valueOf(paramInt));
  }
  
  void a(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleResp_GetArScanFacePreDownConfig |  type= ");
      localStringBuilder.append(paramConfig.type.get());
      QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
    }
    if (paramConfig.type.get() != 205) {
      return;
    }
    int i = paramConfig.version.get();
    if (paramIntent.getIntExtra("key_download_cfg_version", 0) == i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, version same");
      }
      return;
    }
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, content is null");
        }
        return;
      }
      if (paramIntent.compress.get() == 1)
      {
        byte[] arrayOfByte = OlympicUtil.a(paramIntent.content.get().toByteArray());
        localStringBuilder = null;
        paramIntent = localStringBuilder;
        if (arrayOfByte != null)
        {
          try
          {
            paramIntent = new String(arrayOfByte, "UTF-8");
          }
          catch (OutOfMemoryError paramIntent)
          {
            if (QLog.isColorLevel()) {
              paramIntent.printStackTrace();
            }
            System.gc();
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            try
            {
              paramIntent = new String(arrayOfByte, "UTF-8");
            }
            catch (Throwable paramIntent)
            {
              for (;;)
              {
                paramIntent = localStringBuilder;
              }
            }
            localUnsupportedEncodingException = localUnsupportedEncodingException;
            paramIntent = localStringBuilder;
            if (!QLog.isColorLevel()) {
              break label268;
            }
          }
          localUnsupportedEncodingException.printStackTrace();
          paramIntent = localStringBuilder;
        }
      }
      else
      {
        paramIntent = paramIntent.content.get().toStringUtf8();
      }
      label268:
      if (paramIntent != null)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleResp_GetArScanFacePreDownConfig, config_content is ");
          localStringBuilder.append(paramIntent);
          QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
        }
        FaceScanDownloadManager.a(paramQQAppInterface, paramIntent, paramConfig.version.get());
      }
      else
      {
        FaceScanDownloadManager.b(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig we delete ARConfig info here");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, config type 205");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig we delete ARConfig info here");
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
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("receiveAllConfigs|type: 79,content: ");
              localStringBuilder.append(str);
              localStringBuilder.append(",version: ");
              localStringBuilder.append(paramConfig.version.get());
              QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
            }
            int j = paramConfig.version.get();
            if ((j == SharedPreUtils.J(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) && (paramConfig.content_list.size() <= 0))
            {
              if (!QLog.isColorLevel()) {
                break label307;
              }
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_MERGE_CONFIG_CMD IGNORE THIS ACTION  because of SAME VERSION");
              break label307;
            }
            str = str.split("=")[1];
            if (!TextUtils.isEmpty(str)) {
              ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateReadinjoyFolderMergerConfig(str);
            }
            SharedPreUtils.n(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin());
            break label307;
          }
        }
        else if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("receiveAllConfigs|type: 79,content_list is empty ,version: ");
          paramQQAppInterface.append(paramConfig.version.get());
          QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel())
        {
          paramConfig = new StringBuilder();
          paramConfig.append("received readinjoy merge config error,cmd : 79");
          paramConfig.append(paramQQAppInterface.toString());
          QLog.e("SPLASH_ConfigServlet", 2, paramConfig.toString());
        }
      }
      return;
      label307:
      i += 1;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString, ConfigServlet.IHandleConfigCallback paramIHandleConfigCallback)
  {
    int j = paramConfig.version.get();
    int i = paramIHandleConfigCallback.a();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append(", serverVersion=");
      paramQQAppInterface.append(j);
      paramQQAppInterface.append("|localVersion=");
      paramQQAppInterface.append(i);
      QLog.d("TroopRankConfig", 2, paramQQAppInterface.toString());
    }
    if ((j != i) && (paramConfig.msg_content_list.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramConfig.msg_content_list.size();
      i = 0;
      while (i < k)
      {
        paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.compress.get() == 1)
          {
            byte[] arrayOfByte = OlympicUtil.a(paramQQAppInterface.content.get().toByteArray());
            Object localObject = null;
            paramQQAppInterface = localObject;
            if (arrayOfByte != null)
            {
              try
              {
                paramQQAppInterface = new String(arrayOfByte, "UTF-8");
              }
              catch (OutOfMemoryError paramQQAppInterface)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.w("SPLASH_ConfigServlet", 2, paramString, paramQQAppInterface);
                  }
                  System.gc();
                  try
                  {
                    paramQQAppInterface = new String(arrayOfByte, "UTF-8");
                  }
                  catch (Throwable localThrowable)
                  {
                    paramQQAppInterface = localObject;
                    if (!QLog.isColorLevel()) {
                      break label290;
                    }
                  }
                }
                QLog.w("SPLASH_ConfigServlet", 2, paramString, localThrowable);
                paramQQAppInterface = localObject;
              }
              catch (Exception localException)
              {
                paramQQAppInterface = localObject;
                if (!QLog.isColorLevel()) {
                  break label290;
                }
              }
              QLog.w("SPLASH_ConfigServlet", 2, paramString, localException);
              paramQQAppInterface = localObject;
            }
          }
          else
          {
            paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
          }
          label290:
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            localArrayList.add(paramQQAppInterface);
          }
        }
        i += 1;
      }
      if (localArrayList.size() > 0)
      {
        paramIHandleConfigCallback.a(j);
        paramIHandleConfigCallback.a(localArrayList);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(paramString);
        paramQQAppInterface.append(", config_content is empty");
        QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
      }
    }
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
    //   1: checkcast 142	com/tencent/mobileqq/app/QQAppInterface
    //   4: astore 17
    //   6: aload_2
    //   7: getfield 4208	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   10: invokevirtual 390	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   13: istore 7
    //   15: iconst_0
    //   16: istore 10
    //   18: aconst_null
    //   19: astore_1
    //   20: iconst_0
    //   21: istore 13
    //   23: aload_3
    //   24: astore 5
    //   26: iload 10
    //   28: iload 7
    //   30: if_icmpge +12031 -> 12061
    //   33: aload_2
    //   34: getfield 4208	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   37: iload 10
    //   39: invokevirtual 393	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   42: checkcast 45	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   45: astore 18
    //   47: aload 18
    //   49: ifnonnull +6 -> 55
    //   52: goto +38 -> 90
    //   55: aload 18
    //   57: getfield 2250	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   60: invokevirtual 4209	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   63: ifne +6 -> 69
    //   66: goto +24 -> 90
    //   69: aload 18
    //   71: getfield 2250	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   74: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   77: istore 11
    //   79: invokestatic 4212	com/tencent/mobileqq/config/QConfigManager:a	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   82: iload 11
    //   84: invokevirtual 4214	com/tencent/mobileqq/config/QConfigManager:a	(I)Z
    //   87: ifeq +25 -> 112
    //   90: iload 13
    //   92: istore 14
    //   94: aload_1
    //   95: astore 16
    //   97: iload 7
    //   99: istore 8
    //   101: iload 8
    //   103: istore 7
    //   105: iload 7
    //   107: istore 8
    //   109: goto +11932 -> 12041
    //   112: aload 4
    //   114: iload 11
    //   116: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: invokeinterface 4216 2 0
    //   124: pop
    //   125: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +57 -> 185
    //   131: new 77	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   138: astore 15
    //   140: aload 15
    //   142: ldc_w 4218
    //   145: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 15
    //   151: iload 11
    //   153: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 15
    //   159: ldc_w 4220
    //   162: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 15
    //   168: iload 7
    //   170: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: ldc 91
    //   176: iconst_2
    //   177: aload 15
    //   179: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: iload 11
    //   187: iconst_1
    //   188: if_icmpeq +11309 -> 11497
    //   191: iload 11
    //   193: iconst_2
    //   194: if_icmpeq +10560 -> 10754
    //   197: iload 11
    //   199: iconst_3
    //   200: if_icmpeq +10146 -> 10346
    //   203: iload 11
    //   205: iconst_5
    //   206: if_icmpeq +9782 -> 9988
    //   209: iload 11
    //   211: bipush 6
    //   213: if_icmpeq +9743 -> 9956
    //   216: iload 11
    //   218: bipush 12
    //   220: if_icmpeq +9228 -> 9448
    //   223: iload 11
    //   225: bipush 13
    //   227: if_icmpeq +9191 -> 9418
    //   230: iload 11
    //   232: bipush 46
    //   234: if_icmpeq +9162 -> 9396
    //   237: iload 11
    //   239: bipush 47
    //   241: if_icmpeq +8827 -> 9068
    //   244: iload 11
    //   246: bipush 55
    //   248: if_icmpeq +8308 -> 8556
    //   251: iload 11
    //   253: bipush 56
    //   255: if_icmpeq +8279 -> 8534
    //   258: iload 11
    //   260: bipush 96
    //   262: if_icmpeq +8250 -> 8512
    //   265: iload 11
    //   267: bipush 97
    //   269: if_icmpeq +8221 -> 8490
    //   272: iload 7
    //   274: istore 8
    //   276: aload_1
    //   277: astore 16
    //   279: iload 13
    //   281: istore 14
    //   283: iload 11
    //   285: lookupswitch	default:+1059->1344, 10:+7748->8033, 23:+7724->8009, 31:+7430->7715, 34:+7408->7693, 38:+7087->7372, 49:+7065->7350, 53:+7041->7326, 61:+7019->7304, 63:+6997->7282, 64:+6975->7260, 65:+6891->7176, 66:+6869->7154, 69:+6847->7132, 82:+6825->7110, 84:+6801->7086, 90:+6419->6704, 93:+6010->6295, 101:+5983->6268, 102:+5958->6243, 109:+5920->6205, 111:+5895->6180, 115:+5868->6153, 116:+5053->5338, 118:+5028->5313, 119:+5003->5288, 121:+4978->5263, 129:+4953->5238, 130:+4928->5213, 139:+4903->5188, 140:+4878->5163, 142:+4853->5138, 143:+4828->5113, 145:+4801->5086, 146:+4776->5061, 147:+4751->5036, 148:+4726->5011, 149:+4697->4982, 153:+4672->4957, 155:+4647->4932, 156:+-184->101, 157:+4622->4907, 165:+4597->4882, 166:+4559->4844, 167:+4532->4817, 171:+4507->4792, 174:+4482->4767, 177:+4457->4742, 180:+4697->4982, 181:+4432->4717, 182:+4407->4692, 184:+4382->4667, 185:+4357->4642, 187:+4332->4617, 188:+4305->4590, 191:+4280->4565, 193:+3758->4043, 194:+3733->4018, 195:+3708->3993, 201:+3683->3968, 202:+3658->3943, 204:+3633->3918, 205:+3606->3891, 210:+3581->3866, 211:+3557->3842, 212:+3533->3818, 215:+3497->3782, 218:+4697->4982, 222:+3439->3724, 223:+3405->3690, 225:+3311->3596, 226:+3284->3569, 227:+3259->3544, 228:+3234->3519, 232:+3212->3497, 234:+3187->3472, 235:+3162->3447, 238:+3137->3422, 244:+3112->3397, 245:+3087->3372, 247:+3062->3347, 253:+3037->3322, 254:+3012->3297, 256:+2987->3272, 257:+2962->3247, 259:+2937->3222, 260:+2912->3197, 262:+2887->3172, 268:+2862->3147, 269:+2837->3122, 272:+2812->3097, 273:+2788->3073, 274:+2764->3049, 280:+2739->3024, 281:+2714->2999, 283:+2689->2974, 284:+2664->2949, 286:+2637->2922, 289:+2612->2897, 295:+2587->2872, 297:+2561->2846, 301:+2532->2817, 312:+2499->2784, 313:+2472->2757, 320:+2434->2719, 321:+2410->2695, 328:+2385->2670, 331:+2360->2645, 336:+2336->2621, 337:+2302->2587, 345:+2276->2561, 347:+2251->2536, 349:+2213->2498, 364:+3405->3690, 365:+3405->3690, 371:+2188->2473, 384:+2164->2449, 385:+2139->2424, 386:+2104->2389, 387:+2079->2364, 392:+2054->2339, 393:+2019->2304, 394:+1994->2279, 397:+1942->2227, 400:+1915->2200, 403:+1891->2176, 404:+1867->2152, 410:+1828->2113, 596:+1803->2088, 604:+1778->2063, 705:+1755->2040, 718:+1719->2004
    //   1345: fconst_0
    //   1346: tableswitch	default:+26 -> 1372, 42:+623->1969, 43:+598->1944, 44:+294->1640
    //   1373: fconst_0
    //   1374: tableswitch	default:+30 -> 1404, 72:+241->1615, 73:+216->1590, 74:+191->1565, 75:+166->1540
    //   1405: fconst_0
    //   1406: tableswitch	default:+26 -> 1432, 78:+107->1513, 79:+82->1488, 80:+57->1463
    //   1433: astore 15
    //   1435: aload 17
    //   1437: invokevirtual 1170	com/tencent/mobileqq/app/QQAppInterface:getConfigProcess	()Lcom/tencent/mobileqq/config/CfgProcess;
    //   1440: aload 17
    //   1442: aload 18
    //   1444: iload 11
    //   1446: invokevirtual 4222	com/tencent/mobileqq/config/CfgProcess:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   1449: iload 7
    //   1451: istore 8
    //   1453: aload_1
    //   1454: astore 16
    //   1456: iload 13
    //   1458: istore 14
    //   1460: goto -1359 -> 101
    //   1463: aload_1
    //   1464: astore 15
    //   1466: aload_0
    //   1467: aload 17
    //   1469: aload 18
    //   1471: invokespecial 4224	com/tencent/mobileqq/config/splashlogo/ConfigServlet:W	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1474: iload 7
    //   1476: istore 8
    //   1478: aload_1
    //   1479: astore 16
    //   1481: iload 13
    //   1483: istore 14
    //   1485: goto -1384 -> 101
    //   1488: aload_1
    //   1489: astore 15
    //   1491: aload_0
    //   1492: aload 17
    //   1494: aload 18
    //   1496: invokevirtual 4226	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1499: iload 7
    //   1501: istore 8
    //   1503: aload_1
    //   1504: astore 16
    //   1506: iload 13
    //   1508: istore 14
    //   1510: goto -1409 -> 101
    //   1513: aload_1
    //   1514: astore 15
    //   1516: aload_0
    //   1517: aload 17
    //   1519: aload 5
    //   1521: aload 18
    //   1523: invokespecial 4228	com/tencent/mobileqq/config/splashlogo/ConfigServlet:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1526: iload 7
    //   1528: istore 8
    //   1530: aload_1
    //   1531: astore 16
    //   1533: iload 13
    //   1535: istore 14
    //   1537: goto -1436 -> 101
    //   1540: aload_1
    //   1541: astore 15
    //   1543: aload_0
    //   1544: aload 17
    //   1546: aload 18
    //   1548: invokespecial 4230	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aw	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1551: iload 7
    //   1553: istore 8
    //   1555: aload_1
    //   1556: astore 16
    //   1558: iload 13
    //   1560: istore 14
    //   1562: goto -1461 -> 101
    //   1565: aload_1
    //   1566: astore 15
    //   1568: aload_0
    //   1569: aload 17
    //   1571: aload 18
    //   1573: invokespecial 4232	com/tencent/mobileqq/config/splashlogo/ConfigServlet:as	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1576: iload 7
    //   1578: istore 8
    //   1580: aload_1
    //   1581: astore 16
    //   1583: iload 13
    //   1585: istore 14
    //   1587: goto -1486 -> 101
    //   1590: aload_1
    //   1591: astore 15
    //   1593: aload_0
    //   1594: aload 17
    //   1596: aload 18
    //   1598: invokevirtual 4234	com/tencent/mobileqq/config/splashlogo/ConfigServlet:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1601: iload 7
    //   1603: istore 8
    //   1605: aload_1
    //   1606: astore 16
    //   1608: iload 13
    //   1610: istore 14
    //   1612: goto -1511 -> 101
    //   1615: aload_1
    //   1616: astore 15
    //   1618: aload_0
    //   1619: aload 17
    //   1621: aload 18
    //   1623: invokevirtual 4236	com/tencent/mobileqq/config/splashlogo/ConfigServlet:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1626: iload 7
    //   1628: istore 8
    //   1630: aload_1
    //   1631: astore 16
    //   1633: iload 13
    //   1635: istore 14
    //   1637: goto -1536 -> 101
    //   1640: aload_1
    //   1641: astore 15
    //   1643: aload 18
    //   1645: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1648: ifnull +207 -> 1855
    //   1651: aload_1
    //   1652: astore 15
    //   1654: aload 18
    //   1656: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1659: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   1662: ifle +193 -> 1855
    //   1665: aload_1
    //   1666: astore 15
    //   1668: aload 17
    //   1670: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1673: aload 18
    //   1675: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1678: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1681: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1684: invokestatic 4238	com/tencent/mobileqq/utils/SharedPreUtils:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   1687: iconst_0
    //   1688: istore 9
    //   1690: iload 7
    //   1692: istore 8
    //   1694: aload_1
    //   1695: astore 16
    //   1697: iload 13
    //   1699: istore 14
    //   1701: aload_1
    //   1702: astore 15
    //   1704: iload 9
    //   1706: aload 18
    //   1708: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1711: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   1714: if_icmpge -1613 -> 101
    //   1717: aload_1
    //   1718: astore 15
    //   1720: aload 18
    //   1722: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1725: iload 9
    //   1727: invokevirtual 465	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   1730: checkcast 125	java/lang/String
    //   1733: astore 5
    //   1735: aload_1
    //   1736: astore 15
    //   1738: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1741: ifeq +81 -> 1822
    //   1744: aload_1
    //   1745: astore 15
    //   1747: new 77	java/lang/StringBuilder
    //   1750: dup
    //   1751: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1754: astore 16
    //   1756: aload_1
    //   1757: astore 15
    //   1759: aload 16
    //   1761: ldc_w 4240
    //   1764: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1767: pop
    //   1768: aload_1
    //   1769: astore 15
    //   1771: aload 16
    //   1773: aload 5
    //   1775: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1778: pop
    //   1779: aload_1
    //   1780: astore 15
    //   1782: aload 16
    //   1784: ldc_w 472
    //   1787: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: pop
    //   1791: aload_1
    //   1792: astore 15
    //   1794: aload 16
    //   1796: aload 18
    //   1798: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1801: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1804: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1807: pop
    //   1808: aload_1
    //   1809: astore 15
    //   1811: ldc 91
    //   1813: iconst_2
    //   1814: aload 16
    //   1816: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1819: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1822: aload_1
    //   1823: astore 15
    //   1825: aload 5
    //   1827: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1830: ifne +10343 -> 12173
    //   1833: aload_1
    //   1834: astore 15
    //   1836: aload 17
    //   1838: getstatic 3422	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   1841: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1844: checkcast 3424	com/tencent/mobileqq/app/HotChatManager
    //   1847: aload 5
    //   1849: invokevirtual 4242	com/tencent/mobileqq/app/HotChatManager:d	(Ljava/lang/String;)V
    //   1852: goto +10321 -> 12173
    //   1855: iload 7
    //   1857: istore 8
    //   1859: aload_1
    //   1860: astore 16
    //   1862: iload 13
    //   1864: istore 14
    //   1866: aload_1
    //   1867: astore 15
    //   1869: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1872: ifeq -1771 -> 101
    //   1875: aload_1
    //   1876: astore 15
    //   1878: new 77	java/lang/StringBuilder
    //   1881: dup
    //   1882: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1885: astore 5
    //   1887: aload_1
    //   1888: astore 15
    //   1890: aload 5
    //   1892: ldc_w 4244
    //   1895: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1898: pop
    //   1899: aload_1
    //   1900: astore 15
    //   1902: aload 5
    //   1904: aload 18
    //   1906: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1909: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1912: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1915: pop
    //   1916: aload_1
    //   1917: astore 15
    //   1919: ldc 91
    //   1921: iconst_2
    //   1922: aload 5
    //   1924: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1927: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1930: iload 7
    //   1932: istore 8
    //   1934: aload_1
    //   1935: astore 16
    //   1937: iload 13
    //   1939: istore 14
    //   1941: goto -1840 -> 101
    //   1944: aload_1
    //   1945: astore 15
    //   1947: aload_0
    //   1948: aload 17
    //   1950: aload 18
    //   1952: invokespecial 4246	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ak	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1955: iload 7
    //   1957: istore 8
    //   1959: aload_1
    //   1960: astore 16
    //   1962: iload 13
    //   1964: istore 14
    //   1966: goto -1865 -> 101
    //   1969: aload_1
    //   1970: astore 15
    //   1972: aload 17
    //   1974: ldc_w 4248
    //   1977: invokevirtual 1296	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   1980: checkcast 4248	com/tencent/mobileqq/qwallet/config/IQWalletConfigService
    //   1983: aload 18
    //   1985: invokeinterface 4251 2 0
    //   1990: iload 7
    //   1992: istore 8
    //   1994: aload_1
    //   1995: astore 16
    //   1997: iload 13
    //   1999: istore 14
    //   2001: goto -1900 -> 101
    //   2004: aload_1
    //   2005: astore 15
    //   2007: aload_0
    //   2008: aload 17
    //   2010: aload 18
    //   2012: aload 5
    //   2014: ldc_w 4253
    //   2017: invokevirtual 1242	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2020: invokespecial 4255	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)I
    //   2023: invokestatic 4256	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	(I)V
    //   2026: iload 7
    //   2028: istore 8
    //   2030: aload_1
    //   2031: astore 16
    //   2033: iload 13
    //   2035: istore 14
    //   2037: goto -1936 -> 101
    //   2040: aload_1
    //   2041: astore 15
    //   2043: aload_0
    //   2044: aload 18
    //   2046: invokespecial 4258	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2049: iload 7
    //   2051: istore 8
    //   2053: aload_1
    //   2054: astore 16
    //   2056: iload 13
    //   2058: istore 14
    //   2060: goto -1959 -> 101
    //   2063: aload_1
    //   2064: astore 15
    //   2066: aload_0
    //   2067: aload 17
    //   2069: aload 18
    //   2071: invokespecial 4260	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aL	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2074: iload 7
    //   2076: istore 8
    //   2078: aload_1
    //   2079: astore 16
    //   2081: iload 13
    //   2083: istore 14
    //   2085: goto -1984 -> 101
    //   2088: aload_1
    //   2089: astore 15
    //   2091: aload_0
    //   2092: aload 17
    //   2094: aload 18
    //   2096: invokespecial 4262	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aM	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2099: iload 7
    //   2101: istore 8
    //   2103: aload_1
    //   2104: astore 16
    //   2106: iload 13
    //   2108: istore 14
    //   2110: goto -2009 -> 101
    //   2113: aload_1
    //   2114: astore 15
    //   2116: aload 17
    //   2118: ldc_w 1293
    //   2121: invokevirtual 1296	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   2124: checkcast 1293	com/tencent/mobileqq/activity/aio/stickerrecommended/IStickerRecManager
    //   2127: aload 17
    //   2129: aload 18
    //   2131: iload 11
    //   2133: invokeinterface 4266 4 0
    //   2138: iload 7
    //   2140: istore 8
    //   2142: aload_1
    //   2143: astore 16
    //   2145: iload 13
    //   2147: istore 14
    //   2149: goto -2048 -> 101
    //   2152: aload_1
    //   2153: astore 15
    //   2155: aload 17
    //   2157: aload 18
    //   2159: invokestatic 4268	com/tencent/mobileqq/config/splashlogo/ConfigServlet:P	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2162: iload 7
    //   2164: istore 8
    //   2166: aload_1
    //   2167: astore 16
    //   2169: iload 13
    //   2171: istore 14
    //   2173: goto -2072 -> 101
    //   2176: aload_1
    //   2177: astore 15
    //   2179: aload 17
    //   2181: aload 18
    //   2183: invokestatic 4270	com/tencent/mobileqq/config/splashlogo/ConfigServlet:O	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2186: iload 7
    //   2188: istore 8
    //   2190: aload_1
    //   2191: astore 16
    //   2193: iload 13
    //   2195: istore 14
    //   2197: goto -2096 -> 101
    //   2200: aload_1
    //   2201: astore 15
    //   2203: aload_0
    //   2204: aload 17
    //   2206: aload 18
    //   2208: iload 11
    //   2210: invokespecial 4271	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   2213: iload 7
    //   2215: istore 8
    //   2217: aload_1
    //   2218: astore 16
    //   2220: iload 13
    //   2222: istore 14
    //   2224: goto -2123 -> 101
    //   2227: aload_1
    //   2228: astore 15
    //   2230: invokestatic 1308	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:a	()Lcom/tencent/mobileqq/haoliyou/orion/ZhuoXusManager;
    //   2233: getfield 1311	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:a	Lcom/tencent/mobileqq/haoliyou/orion/ZhuoXusManager$ConfigLoader;
    //   2236: aload 18
    //   2238: invokevirtual 4272	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager$ConfigLoader:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2241: iload 7
    //   2243: istore 8
    //   2245: aload_1
    //   2246: astore 16
    //   2248: iload 13
    //   2250: istore 14
    //   2252: goto -2151 -> 101
    //   2255: astore 5
    //   2257: aload_1
    //   2258: astore 15
    //   2260: aload 5
    //   2262: invokevirtual 1476	java/lang/Throwable:printStackTrace	()V
    //   2265: iload 7
    //   2267: istore 8
    //   2269: aload_1
    //   2270: astore 16
    //   2272: iload 13
    //   2274: istore 14
    //   2276: goto -2175 -> 101
    //   2279: aload_1
    //   2280: astore 15
    //   2282: aload_0
    //   2283: aload 17
    //   2285: aload 18
    //   2287: invokespecial 4274	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aK	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2290: iload 7
    //   2292: istore 8
    //   2294: aload_1
    //   2295: astore 16
    //   2297: iload 13
    //   2299: istore 14
    //   2301: goto -2200 -> 101
    //   2304: aload_1
    //   2305: astore 15
    //   2307: aload 17
    //   2309: getstatic 4277	com/tencent/mobileqq/app/QQManagerFactory:GROUP_VIDEO_PLUGIN_MANAGER	I
    //   2312: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2315: checkcast 4279	com/tencent/mobileqq/intervideo/groupvideo/IGroupVideoManager
    //   2318: aload 18
    //   2320: invokeinterface 4280 2 0
    //   2325: iload 7
    //   2327: istore 8
    //   2329: aload_1
    //   2330: astore 16
    //   2332: iload 13
    //   2334: istore 14
    //   2336: goto -2235 -> 101
    //   2339: aload_1
    //   2340: astore 15
    //   2342: aload_0
    //   2343: aload 17
    //   2345: aload 18
    //   2347: invokespecial 4282	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aJ	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2350: iload 7
    //   2352: istore 8
    //   2354: aload_1
    //   2355: astore 16
    //   2357: iload 13
    //   2359: istore 14
    //   2361: goto -2260 -> 101
    //   2364: aload_1
    //   2365: astore 15
    //   2367: aload_0
    //   2368: aload 17
    //   2370: aload 18
    //   2372: invokespecial 4284	com/tencent/mobileqq/config/splashlogo/ConfigServlet:Q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2375: iload 7
    //   2377: istore 8
    //   2379: aload_1
    //   2380: astore 16
    //   2382: iload 13
    //   2384: istore 14
    //   2386: goto -2285 -> 101
    //   2389: aload_1
    //   2390: astore 15
    //   2392: aload 17
    //   2394: getstatic 4287	com/tencent/mobileqq/app/QQManagerFactory:NOW_DYNAMIC_MANAGER	I
    //   2397: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2400: checkcast 4289	com/tencent/mobileqq/intervideo/now/dynamic/IDynamicNowManager
    //   2403: aload 18
    //   2405: invokeinterface 4290 2 0
    //   2410: iload 7
    //   2412: istore 8
    //   2414: aload_1
    //   2415: astore 16
    //   2417: iload 13
    //   2419: istore 14
    //   2421: goto -2320 -> 101
    //   2424: aload_1
    //   2425: astore 15
    //   2427: aload_0
    //   2428: aload 17
    //   2430: aload 18
    //   2432: invokespecial 4292	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aI	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2435: iload 7
    //   2437: istore 8
    //   2439: aload_1
    //   2440: astore 16
    //   2442: iload 13
    //   2444: istore 14
    //   2446: goto -2345 -> 101
    //   2449: aload_1
    //   2450: astore 15
    //   2452: aload 17
    //   2454: aload 18
    //   2456: invokestatic 4294	com/tencent/mobileqq/config/splashlogo/ConfigServlet:N	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2459: iload 7
    //   2461: istore 8
    //   2463: aload_1
    //   2464: astore 16
    //   2466: iload 13
    //   2468: istore 14
    //   2470: goto -2369 -> 101
    //   2473: aload_1
    //   2474: astore 15
    //   2476: aload_0
    //   2477: aload 17
    //   2479: aload 18
    //   2481: invokevirtual 4296	com/tencent/mobileqq/config/splashlogo/ConfigServlet:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2484: iload 7
    //   2486: istore 8
    //   2488: aload_1
    //   2489: astore 16
    //   2491: iload 13
    //   2493: istore 14
    //   2495: goto -2394 -> 101
    //   2498: aload_1
    //   2499: astore 15
    //   2501: aload 17
    //   2503: getstatic 1352	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   2506: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2509: checkcast 1354	com/tencent/mobileqq/app/TroopManager
    //   2512: getfield 1357	com/tencent/mobileqq/app/TroopManager:a	Lcom/tencent/biz/troopconfig/TroopConfigForAllUser;
    //   2515: aload 17
    //   2517: aload 18
    //   2519: invokevirtual 4299	com/tencent/biz/troopconfig/TroopConfigForAllUser:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2522: iload 7
    //   2524: istore 8
    //   2526: aload_1
    //   2527: astore 16
    //   2529: iload 13
    //   2531: istore 14
    //   2533: goto -2432 -> 101
    //   2536: aload_1
    //   2537: astore 15
    //   2539: aload_0
    //   2540: aload 17
    //   2542: aload 18
    //   2544: invokevirtual 4301	com/tencent/mobileqq/config/splashlogo/ConfigServlet:L	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2547: iload 7
    //   2549: istore 8
    //   2551: aload_1
    //   2552: astore 16
    //   2554: iload 13
    //   2556: istore 14
    //   2558: goto -2457 -> 101
    //   2561: aload_1
    //   2562: astore 15
    //   2564: aload 17
    //   2566: iload 11
    //   2568: aload 18
    //   2570: invokestatic 4306	com/tencent/mobileqq/wifi/FreeWifiHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2573: iload 7
    //   2575: istore 8
    //   2577: aload_1
    //   2578: astore 16
    //   2580: iload 13
    //   2582: istore 14
    //   2584: goto -2483 -> 101
    //   2587: aload_1
    //   2588: astore 15
    //   2590: aload 17
    //   2592: invokestatic 4311	com/tencent/mobileqq/flashchat/RichTextChatManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/flashchat/RichTextChatManager;
    //   2595: aload 17
    //   2597: iload 11
    //   2599: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2602: aload 18
    //   2604: invokevirtual 4314	com/tencent/mobileqq/flashchat/RichTextChatManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/Integer;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2607: iload 7
    //   2609: istore 8
    //   2611: aload_1
    //   2612: astore 16
    //   2614: iload 13
    //   2616: istore 14
    //   2618: goto -2517 -> 101
    //   2621: aload_1
    //   2622: astore 15
    //   2624: aload 17
    //   2626: aload 18
    //   2628: invokestatic 4316	com/tencent/mobileqq/config/splashlogo/ConfigServlet:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2631: iload 7
    //   2633: istore 8
    //   2635: aload_1
    //   2636: astore 16
    //   2638: iload 13
    //   2640: istore 14
    //   2642: goto -2541 -> 101
    //   2645: aload_1
    //   2646: astore 15
    //   2648: aload_0
    //   2649: aload 17
    //   2651: aload 18
    //   2653: invokespecial 4318	com/tencent/mobileqq/config/splashlogo/ConfigServlet:R	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2656: iload 7
    //   2658: istore 8
    //   2660: aload_1
    //   2661: astore 16
    //   2663: iload 13
    //   2665: istore 14
    //   2667: goto -2566 -> 101
    //   2670: aload_1
    //   2671: astore 15
    //   2673: aload_0
    //   2674: aload 17
    //   2676: aload 18
    //   2678: invokespecial 4320	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aG	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2681: iload 7
    //   2683: istore 8
    //   2685: aload_1
    //   2686: astore 16
    //   2688: iload 13
    //   2690: istore 14
    //   2692: goto -2591 -> 101
    //   2695: aload_1
    //   2696: astore 15
    //   2698: aload 17
    //   2700: aload 18
    //   2702: invokestatic 4322	com/tencent/mobileqq/config/splashlogo/ConfigServlet:v	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2705: iload 7
    //   2707: istore 8
    //   2709: aload_1
    //   2710: astore 16
    //   2712: iload 13
    //   2714: istore 14
    //   2716: goto -2615 -> 101
    //   2719: aload_1
    //   2720: astore 15
    //   2722: aload 17
    //   2724: getstatic 1389	com/tencent/mobileqq/app/QQManagerFactory:QQSTORY_MANAGER	I
    //   2727: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2730: checkcast 1391	com/tencent/biz/qqstory/base/QQStoryManager
    //   2733: getfield 1394	com/tencent/biz/qqstory/base/QQStoryManager:a	Lcom/tencent/biz/qqstory/config/TextFilterConfig;
    //   2736: aload 17
    //   2738: aload 18
    //   2740: invokevirtual 4323	com/tencent/biz/qqstory/config/TextFilterConfig:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2743: iload 7
    //   2745: istore 8
    //   2747: aload_1
    //   2748: astore 16
    //   2750: iload 13
    //   2752: istore 14
    //   2754: goto -2653 -> 101
    //   2757: aload_1
    //   2758: astore 15
    //   2760: aload 17
    //   2762: invokestatic 4328	com/tencent/biz/qqstory/base/QQStoryFeedManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/biz/qqstory/base/QQStoryFeedManager;
    //   2765: aload 18
    //   2767: invokevirtual 4329	com/tencent/biz/qqstory/base/QQStoryFeedManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2770: iload 7
    //   2772: istore 8
    //   2774: aload_1
    //   2775: astore 16
    //   2777: iload 13
    //   2779: istore 14
    //   2781: goto -2680 -> 101
    //   2784: aload_1
    //   2785: astore 15
    //   2787: aload 17
    //   2789: getstatic 4332	com/tencent/mobileqq/app/QQManagerFactory:STORY_HALO_MANAGER	I
    //   2792: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2795: checkcast 4334	com/tencent/biz/qqstory/base/StoryHaloManager
    //   2798: aload 18
    //   2800: invokevirtual 4335	com/tencent/biz/qqstory/base/StoryHaloManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2803: iload 7
    //   2805: istore 8
    //   2807: aload_1
    //   2808: astore 16
    //   2810: iload 13
    //   2812: istore 14
    //   2814: goto -2713 -> 101
    //   2817: aload_1
    //   2818: astore 15
    //   2820: aload 17
    //   2822: aload 18
    //   2824: iload 11
    //   2826: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2829: invokestatic 4340	com/tencent/mobileqq/statistics/QZoneReport:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;ILjava/lang/String;)V
    //   2832: iload 7
    //   2834: istore 8
    //   2836: aload_1
    //   2837: astore 16
    //   2839: iload 13
    //   2841: istore 14
    //   2843: goto -2742 -> 101
    //   2846: aload_1
    //   2847: astore 15
    //   2849: aload 17
    //   2851: iload 11
    //   2853: aload 18
    //   2855: invokestatic 4343	com/tencent/mobileqq/data/nativemonitor/NativeMonitorConfigHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2858: iload 7
    //   2860: istore 8
    //   2862: aload_1
    //   2863: astore 16
    //   2865: iload 13
    //   2867: istore 14
    //   2869: goto -2768 -> 101
    //   2872: aload_1
    //   2873: astore 15
    //   2875: aload_0
    //   2876: aload 17
    //   2878: aload 18
    //   2880: invokevirtual 4345	com/tencent/mobileqq/config/splashlogo/ConfigServlet:D	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2883: iload 7
    //   2885: istore 8
    //   2887: aload_1
    //   2888: astore 16
    //   2890: iload 13
    //   2892: istore 14
    //   2894: goto -2793 -> 101
    //   2897: aload_1
    //   2898: astore 15
    //   2900: aload_0
    //   2901: aload 17
    //   2903: aload 18
    //   2905: invokevirtual 4347	com/tencent/mobileqq/config/splashlogo/ConfigServlet:M	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2908: iload 7
    //   2910: istore 8
    //   2912: aload_1
    //   2913: astore 16
    //   2915: iload 13
    //   2917: istore 14
    //   2919: goto -2818 -> 101
    //   2922: aload_1
    //   2923: astore 15
    //   2925: aload_0
    //   2926: aload 17
    //   2928: aload 5
    //   2930: aload 18
    //   2932: invokespecial 4349	com/tencent/mobileqq/config/splashlogo/ConfigServlet:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2935: iload 7
    //   2937: istore 8
    //   2939: aload_1
    //   2940: astore 16
    //   2942: iload 13
    //   2944: istore 14
    //   2946: goto -2845 -> 101
    //   2949: aload_1
    //   2950: astore 15
    //   2952: aload_0
    //   2953: aload 17
    //   2955: aload 18
    //   2957: invokevirtual 4351	com/tencent/mobileqq/config/splashlogo/ConfigServlet:K	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2960: iload 7
    //   2962: istore 8
    //   2964: aload_1
    //   2965: astore 16
    //   2967: iload 13
    //   2969: istore 14
    //   2971: goto -2870 -> 101
    //   2974: aload_1
    //   2975: astore 15
    //   2977: aload_0
    //   2978: aload 17
    //   2980: aload 18
    //   2982: invokevirtual 4353	com/tencent/mobileqq/config/splashlogo/ConfigServlet:J	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2985: iload 7
    //   2987: istore 8
    //   2989: aload_1
    //   2990: astore 16
    //   2992: iload 13
    //   2994: istore 14
    //   2996: goto -2895 -> 101
    //   2999: aload_1
    //   3000: astore 15
    //   3002: aload_0
    //   3003: aload 17
    //   3005: aload 18
    //   3007: invokevirtual 4355	com/tencent/mobileqq/config/splashlogo/ConfigServlet:I	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3010: iload 7
    //   3012: istore 8
    //   3014: aload_1
    //   3015: astore 16
    //   3017: iload 13
    //   3019: istore 14
    //   3021: goto -2920 -> 101
    //   3024: aload_1
    //   3025: astore 15
    //   3027: aload 17
    //   3029: aload 18
    //   3031: invokestatic 4358	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   3034: pop
    //   3035: iload 7
    //   3037: istore 8
    //   3039: aload_1
    //   3040: astore 16
    //   3042: iload 13
    //   3044: istore 14
    //   3046: goto -2945 -> 101
    //   3049: aload_1
    //   3050: astore 15
    //   3052: aload 17
    //   3054: aload 18
    //   3056: invokestatic 4361	com/tencent/mobileqq/troop/logic/HomeworkTroopController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3059: iload 7
    //   3061: istore 8
    //   3063: aload_1
    //   3064: astore 16
    //   3066: iload 13
    //   3068: istore 14
    //   3070: goto -2969 -> 101
    //   3073: aload_1
    //   3074: astore 15
    //   3076: aload 17
    //   3078: aload 18
    //   3080: invokestatic 4362	com/tencent/biz/troopgift/GiftConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3083: iload 7
    //   3085: istore 8
    //   3087: aload_1
    //   3088: astore 16
    //   3090: iload 13
    //   3092: istore 14
    //   3094: goto -2993 -> 101
    //   3097: aload_1
    //   3098: astore 15
    //   3100: aload_0
    //   3101: aload 17
    //   3103: aload 18
    //   3105: invokevirtual 4364	com/tencent/mobileqq/config/splashlogo/ConfigServlet:q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3108: iload 7
    //   3110: istore 8
    //   3112: aload_1
    //   3113: astore 16
    //   3115: iload 13
    //   3117: istore 14
    //   3119: goto -3018 -> 101
    //   3122: aload_1
    //   3123: astore 15
    //   3125: aload_0
    //   3126: aload 17
    //   3128: aload 18
    //   3130: invokespecial 4366	com/tencent/mobileqq/config/splashlogo/ConfigServlet:af	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3133: iload 7
    //   3135: istore 8
    //   3137: aload_1
    //   3138: astore 16
    //   3140: iload 13
    //   3142: istore 14
    //   3144: goto -3043 -> 101
    //   3147: aload_1
    //   3148: astore 15
    //   3150: aload_0
    //   3151: aload 17
    //   3153: aload 18
    //   3155: invokespecial 4368	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ae	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3158: iload 7
    //   3160: istore 8
    //   3162: aload_1
    //   3163: astore 16
    //   3165: iload 13
    //   3167: istore 14
    //   3169: goto -3068 -> 101
    //   3172: aload_1
    //   3173: astore 15
    //   3175: aload_0
    //   3176: aload 17
    //   3178: aload 18
    //   3180: invokevirtual 4370	com/tencent/mobileqq/config/splashlogo/ConfigServlet:G	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3183: iload 7
    //   3185: istore 8
    //   3187: aload_1
    //   3188: astore 16
    //   3190: iload 13
    //   3192: istore 14
    //   3194: goto -3093 -> 101
    //   3197: aload_1
    //   3198: astore 15
    //   3200: aload_0
    //   3201: aload 17
    //   3203: aload 18
    //   3205: invokespecial 4372	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aE	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3208: iload 7
    //   3210: istore 8
    //   3212: aload_1
    //   3213: astore 16
    //   3215: iload 13
    //   3217: istore 14
    //   3219: goto -3118 -> 101
    //   3222: aload_1
    //   3223: astore 15
    //   3225: aload_0
    //   3226: aload 17
    //   3228: aload 18
    //   3230: invokevirtual 4374	com/tencent/mobileqq/config/splashlogo/ConfigServlet:F	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3233: iload 7
    //   3235: istore 8
    //   3237: aload_1
    //   3238: astore 16
    //   3240: iload 13
    //   3242: istore 14
    //   3244: goto -3143 -> 101
    //   3247: aload_1
    //   3248: astore 15
    //   3250: aload_0
    //   3251: aload 17
    //   3253: aload 18
    //   3255: invokespecial 4376	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aD	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3258: iload 7
    //   3260: istore 8
    //   3262: aload_1
    //   3263: astore 16
    //   3265: iload 13
    //   3267: istore 14
    //   3269: goto -3168 -> 101
    //   3272: aload_1
    //   3273: astore 15
    //   3275: aload_0
    //   3276: aload 17
    //   3278: aload 18
    //   3280: invokespecial 4378	com/tencent/mobileqq/config/splashlogo/ConfigServlet:av	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3283: iload 7
    //   3285: istore 8
    //   3287: aload_1
    //   3288: astore 16
    //   3290: iload 13
    //   3292: istore 14
    //   3294: goto -3193 -> 101
    //   3297: aload_1
    //   3298: astore 15
    //   3300: aload_0
    //   3301: aload 17
    //   3303: aload 18
    //   3305: invokevirtual 4380	com/tencent/mobileqq/config/splashlogo/ConfigServlet:E	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3308: iload 7
    //   3310: istore 8
    //   3312: aload_1
    //   3313: astore 16
    //   3315: iload 13
    //   3317: istore 14
    //   3319: goto -3218 -> 101
    //   3322: aload_1
    //   3323: astore 15
    //   3325: aload_0
    //   3326: aload 17
    //   3328: aload 18
    //   3330: invokevirtual 4382	com/tencent/mobileqq/config/splashlogo/ConfigServlet:C	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3333: iload 7
    //   3335: istore 8
    //   3337: aload_1
    //   3338: astore 16
    //   3340: iload 13
    //   3342: istore 14
    //   3344: goto -3243 -> 101
    //   3347: aload_1
    //   3348: astore 15
    //   3350: aload_0
    //   3351: aload 17
    //   3353: aload 18
    //   3355: invokevirtual 4384	com/tencent/mobileqq/config/splashlogo/ConfigServlet:p	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3358: iload 7
    //   3360: istore 8
    //   3362: aload_1
    //   3363: astore 16
    //   3365: iload 13
    //   3367: istore 14
    //   3369: goto -3268 -> 101
    //   3372: aload_1
    //   3373: astore 15
    //   3375: aload_0
    //   3376: aload 17
    //   3378: aload 18
    //   3380: invokevirtual 4386	com/tencent/mobileqq/config/splashlogo/ConfigServlet:B	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3383: iload 7
    //   3385: istore 8
    //   3387: aload_1
    //   3388: astore 16
    //   3390: iload 13
    //   3392: istore 14
    //   3394: goto -3293 -> 101
    //   3397: aload_1
    //   3398: astore 15
    //   3400: aload_0
    //   3401: aload 17
    //   3403: aload 18
    //   3405: invokevirtual 4388	com/tencent/mobileqq/config/splashlogo/ConfigServlet:H	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3408: iload 7
    //   3410: istore 8
    //   3412: aload_1
    //   3413: astore 16
    //   3415: iload 13
    //   3417: istore 14
    //   3419: goto -3318 -> 101
    //   3422: aload_1
    //   3423: astore 15
    //   3425: aload_0
    //   3426: aload 17
    //   3428: aload 18
    //   3430: invokevirtual 4390	com/tencent/mobileqq/config/splashlogo/ConfigServlet:z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3433: iload 7
    //   3435: istore 8
    //   3437: aload_1
    //   3438: astore 16
    //   3440: iload 13
    //   3442: istore 14
    //   3444: goto -3343 -> 101
    //   3447: aload_1
    //   3448: astore 15
    //   3450: aload_0
    //   3451: aload 17
    //   3453: aload 18
    //   3455: invokespecial 4392	com/tencent/mobileqq/config/splashlogo/ConfigServlet:T	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3458: iload 7
    //   3460: istore 8
    //   3462: aload_1
    //   3463: astore 16
    //   3465: iload 13
    //   3467: istore 14
    //   3469: goto -3368 -> 101
    //   3472: aload_1
    //   3473: astore 15
    //   3475: aload_0
    //   3476: aload 17
    //   3478: aload 18
    //   3480: invokevirtual 4394	com/tencent/mobileqq/config/splashlogo/ConfigServlet:A	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3483: iload 7
    //   3485: istore 8
    //   3487: aload_1
    //   3488: astore 16
    //   3490: iload 13
    //   3492: istore 14
    //   3494: goto -3393 -> 101
    //   3497: aload_1
    //   3498: astore 15
    //   3500: aload 18
    //   3502: invokestatic 4397	com/tencent/mobileqq/search/util/SearchConfigUtils:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3505: iload 7
    //   3507: istore 8
    //   3509: aload_1
    //   3510: astore 16
    //   3512: iload 13
    //   3514: istore 14
    //   3516: goto -3415 -> 101
    //   3519: aload_1
    //   3520: astore 15
    //   3522: aload_0
    //   3523: aload 17
    //   3525: aload 18
    //   3527: invokespecial 4399	com/tencent/mobileqq/config/splashlogo/ConfigServlet:au	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3530: iload 7
    //   3532: istore 8
    //   3534: aload_1
    //   3535: astore 16
    //   3537: iload 13
    //   3539: istore 14
    //   3541: goto -3440 -> 101
    //   3544: aload_1
    //   3545: astore 15
    //   3547: aload_0
    //   3548: aload 17
    //   3550: aload 18
    //   3552: invokespecial 4401	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ad	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3555: iload 7
    //   3557: istore 8
    //   3559: aload_1
    //   3560: astore 16
    //   3562: iload 13
    //   3564: istore 14
    //   3566: goto -3465 -> 101
    //   3569: aload_1
    //   3570: astore 15
    //   3572: aload_0
    //   3573: aload 17
    //   3575: aload 5
    //   3577: aload 18
    //   3579: invokespecial 4403	com/tencent/mobileqq/config/splashlogo/ConfigServlet:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3582: iload 7
    //   3584: istore 8
    //   3586: aload_1
    //   3587: astore 16
    //   3589: iload 13
    //   3591: istore 14
    //   3593: goto -3492 -> 101
    //   3596: aload_1
    //   3597: astore 15
    //   3599: aload 18
    //   3601: ldc_w 1539
    //   3604: invokestatic 496	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3607: checkcast 1539	com/tencent/aelight/camera/qqstory/api/ICaptureVideoFilterManager
    //   3610: aload 17
    //   3612: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3615: invokeinterface 1542 2 0
    //   3620: sipush 225
    //   3623: invokestatic 2022	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   3626: astore 5
    //   3628: iload 7
    //   3630: istore 8
    //   3632: aload_1
    //   3633: astore 16
    //   3635: iload 13
    //   3637: istore 14
    //   3639: aload 5
    //   3641: ifnull -3540 -> 101
    //   3644: aload_1
    //   3645: astore 15
    //   3647: ldc_w 1539
    //   3650: invokestatic 496	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3653: checkcast 1539	com/tencent/aelight/camera/qqstory/api/ICaptureVideoFilterManager
    //   3656: aload 17
    //   3658: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3661: aload 5
    //   3663: aload 18
    //   3665: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3668: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3671: invokeinterface 4406 4 0
    //   3676: iload 7
    //   3678: istore 8
    //   3680: aload_1
    //   3681: astore 16
    //   3683: iload 13
    //   3685: istore 14
    //   3687: goto -3586 -> 101
    //   3690: aload_1
    //   3691: astore 15
    //   3693: aload 17
    //   3695: invokestatic 1548	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   3698: aload 17
    //   3700: iload 11
    //   3702: aload 5
    //   3704: aload 18
    //   3706: invokevirtual 4410	com/tencent/mobileqq/utils/BusinessCommonConfig:decodeConfig	(Lcom/tencent/mobileqq/app/QQAppInterface;ILandroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)Ljava/lang/Boolean;
    //   3709: pop
    //   3710: iload 7
    //   3712: istore 8
    //   3714: aload_1
    //   3715: astore 16
    //   3717: iload 13
    //   3719: istore 14
    //   3721: goto -3620 -> 101
    //   3724: aload_1
    //   3725: astore 15
    //   3727: aload 17
    //   3729: getstatic 4413	com/tencent/mobileqq/app/QQManagerFactory:PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER	I
    //   3732: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3735: checkcast 4415	com/tencent/biz/pubaccount/Advertisement/manager/AdvertisementVideoPreloadManager
    //   3738: astore 5
    //   3740: iload 7
    //   3742: istore 8
    //   3744: aload_1
    //   3745: astore 16
    //   3747: iload 13
    //   3749: istore 14
    //   3751: aload 5
    //   3753: ifnull -3652 -> 101
    //   3756: aload_1
    //   3757: astore 15
    //   3759: aload 5
    //   3761: aload 17
    //   3763: aload 18
    //   3765: invokevirtual 4416	com/tencent/biz/pubaccount/Advertisement/manager/AdvertisementVideoPreloadManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3768: iload 7
    //   3770: istore 8
    //   3772: aload_1
    //   3773: astore 16
    //   3775: iload 13
    //   3777: istore 14
    //   3779: goto -3678 -> 101
    //   3782: aload_1
    //   3783: astore 15
    //   3785: aload_0
    //   3786: aload 17
    //   3788: aload 18
    //   3790: aload 5
    //   3792: ldc_w 4253
    //   3795: invokevirtual 1242	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   3798: invokespecial 4418	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)I
    //   3801: invokestatic 4419	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager:b	(I)V
    //   3804: iload 7
    //   3806: istore 8
    //   3808: aload_1
    //   3809: astore 16
    //   3811: iload 13
    //   3813: istore 14
    //   3815: goto -3714 -> 101
    //   3818: aload_1
    //   3819: astore 15
    //   3821: aload 17
    //   3823: aload 18
    //   3825: invokestatic 4421	com/tencent/mobileqq/config/splashlogo/ConfigServlet:y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3828: iload 7
    //   3830: istore 8
    //   3832: aload_1
    //   3833: astore 16
    //   3835: iload 13
    //   3837: istore 14
    //   3839: goto -3738 -> 101
    //   3842: aload_1
    //   3843: astore 15
    //   3845: aload 17
    //   3847: aload 18
    //   3849: invokestatic 4422	com/tencent/mobileqq/search/util/SearchConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3852: iload 7
    //   3854: istore 8
    //   3856: aload_1
    //   3857: astore 16
    //   3859: iload 13
    //   3861: istore 14
    //   3863: goto -3762 -> 101
    //   3866: aload_1
    //   3867: astore 15
    //   3869: aload_0
    //   3870: aload 17
    //   3872: aload 18
    //   3874: invokespecial 4424	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aH	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3877: iload 7
    //   3879: istore 8
    //   3881: aload_1
    //   3882: astore 16
    //   3884: iload 13
    //   3886: istore 14
    //   3888: goto -3787 -> 101
    //   3891: aload_1
    //   3892: astore 15
    //   3894: aload_0
    //   3895: aload 17
    //   3897: aload 5
    //   3899: aload 18
    //   3901: invokevirtual 4426	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3904: iload 7
    //   3906: istore 8
    //   3908: aload_1
    //   3909: astore 16
    //   3911: iload 13
    //   3913: istore 14
    //   3915: goto -3814 -> 101
    //   3918: aload_1
    //   3919: astore 15
    //   3921: aload_0
    //   3922: aload 17
    //   3924: aload 18
    //   3926: invokespecial 4428	com/tencent/mobileqq/config/splashlogo/ConfigServlet:S	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3929: iload 7
    //   3931: istore 8
    //   3933: aload_1
    //   3934: astore 16
    //   3936: iload 13
    //   3938: istore 14
    //   3940: goto -3839 -> 101
    //   3943: aload_1
    //   3944: astore 15
    //   3946: aload_0
    //   3947: aload 17
    //   3949: aload 18
    //   3951: invokevirtual 4430	com/tencent/mobileqq/config/splashlogo/ConfigServlet:x	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3954: iload 7
    //   3956: istore 8
    //   3958: aload_1
    //   3959: astore 16
    //   3961: iload 13
    //   3963: istore 14
    //   3965: goto -3864 -> 101
    //   3968: aload_1
    //   3969: astore 15
    //   3971: aload_0
    //   3972: aload 17
    //   3974: aload 18
    //   3976: invokespecial 4432	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aa	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3979: iload 7
    //   3981: istore 8
    //   3983: aload_1
    //   3984: astore 16
    //   3986: iload 13
    //   3988: istore 14
    //   3990: goto -3889 -> 101
    //   3993: aload_1
    //   3994: astore 15
    //   3996: aload_0
    //   3997: aload 17
    //   3999: aload 18
    //   4001: invokespecial 4434	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ac	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4004: iload 7
    //   4006: istore 8
    //   4008: aload_1
    //   4009: astore 16
    //   4011: iload 13
    //   4013: istore 14
    //   4015: goto -3914 -> 101
    //   4018: aload_1
    //   4019: astore 15
    //   4021: aload_0
    //   4022: aload 17
    //   4024: aload 18
    //   4026: invokevirtual 4436	com/tencent/mobileqq/config/splashlogo/ConfigServlet:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4029: iload 7
    //   4031: istore 8
    //   4033: aload_1
    //   4034: astore 16
    //   4036: iload 13
    //   4038: istore 14
    //   4040: goto -3939 -> 101
    //   4043: iload 7
    //   4045: istore 8
    //   4047: aload_1
    //   4048: astore 16
    //   4050: iload 13
    //   4052: istore 14
    //   4054: aload_1
    //   4055: astore 15
    //   4057: aload 18
    //   4059: getfield 387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4062: ifnull -3961 -> 101
    //   4065: iload 7
    //   4067: istore 8
    //   4069: aload_1
    //   4070: astore 16
    //   4072: iload 13
    //   4074: istore 14
    //   4076: aload_1
    //   4077: astore 15
    //   4079: aload 18
    //   4081: getfield 387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4084: invokevirtual 390	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   4087: ifle -3986 -> 101
    //   4090: aload_1
    //   4091: astore 15
    //   4093: aload 18
    //   4095: getfield 387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4098: astore 5
    //   4100: aload 5
    //   4102: iconst_0
    //   4103: invokevirtual 393	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4106: astore 5
    //   4108: aload_1
    //   4109: astore 15
    //   4111: aload 5
    //   4113: checkcast 395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   4116: astore 5
    //   4118: aload 5
    //   4120: ifnull +398 -> 4518
    //   4123: aload_1
    //   4124: astore 15
    //   4126: aload 5
    //   4128: getfield 399	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4131: invokevirtual 402	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4134: iconst_1
    //   4135: if_icmpne +114 -> 4249
    //   4138: aload_1
    //   4139: astore 15
    //   4141: aload 5
    //   4143: getfield 406	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4146: invokevirtual 411	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4149: invokevirtual 417	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4152: invokestatic 422	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   4155: astore 16
    //   4157: aload 16
    //   4159: ifnull +8023 -> 12182
    //   4162: aload_1
    //   4163: astore 15
    //   4165: new 125	java/lang/String
    //   4168: dup
    //   4169: aload 16
    //   4171: ldc_w 424
    //   4174: invokespecial 427	java/lang/String:<init>	([BLjava/lang/String;)V
    //   4177: astore 5
    //   4179: goto +86 -> 4265
    //   4182: astore 5
    //   4184: aload_1
    //   4185: astore 15
    //   4187: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4190: ifeq +11 -> 4201
    //   4193: aload_1
    //   4194: astore 15
    //   4196: aload 5
    //   4198: invokevirtual 2392	java/lang/OutOfMemoryError:printStackTrace	()V
    //   4201: aload_1
    //   4202: astore 15
    //   4204: invokestatic 438	java/lang/System:gc	()V
    //   4207: aload_1
    //   4208: astore 15
    //   4210: new 125	java/lang/String
    //   4213: dup
    //   4214: aload 16
    //   4216: ldc_w 424
    //   4219: invokespecial 427	java/lang/String:<init>	([BLjava/lang/String;)V
    //   4222: astore 5
    //   4224: goto +41 -> 4265
    //   4227: astore 5
    //   4229: aload_1
    //   4230: astore 15
    //   4232: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4235: ifeq +7947 -> 12182
    //   4238: aload_1
    //   4239: astore 15
    //   4241: aload 5
    //   4243: invokevirtual 2393	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   4246: goto +7936 -> 12182
    //   4249: aload_1
    //   4250: astore 15
    //   4252: aload 5
    //   4254: getfield 406	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4257: invokevirtual 411	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4260: invokevirtual 441	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4263: astore 5
    //   4265: iload 7
    //   4267: istore 8
    //   4269: aload_1
    //   4270: astore 16
    //   4272: iload 13
    //   4274: istore 14
    //   4276: aload 5
    //   4278: ifnull -4177 -> 101
    //   4281: aload_1
    //   4282: astore 15
    //   4284: aload 18
    //   4286: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4289: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4292: istore 8
    //   4294: aload_1
    //   4295: astore 15
    //   4297: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4300: ifeq +76 -> 4376
    //   4303: aload_1
    //   4304: astore 15
    //   4306: new 77	java/lang/StringBuilder
    //   4309: dup
    //   4310: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   4313: astore 16
    //   4315: aload_1
    //   4316: astore 15
    //   4318: aload 16
    //   4320: ldc_w 4438
    //   4323: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4326: pop
    //   4327: aload_1
    //   4328: astore 15
    //   4330: aload 16
    //   4332: iload 8
    //   4334: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4337: pop
    //   4338: aload_1
    //   4339: astore 15
    //   4341: aload 16
    //   4343: ldc_w 4440
    //   4346: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4349: pop
    //   4350: aload_1
    //   4351: astore 15
    //   4353: aload 16
    //   4355: aload 5
    //   4357: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4360: pop
    //   4361: aload_1
    //   4362: astore 15
    //   4364: ldc_w 1601
    //   4367: iconst_2
    //   4368: aload 16
    //   4370: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4373: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4376: aload_1
    //   4377: astore 15
    //   4379: aload 5
    //   4381: invokestatic 4445	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;
    //   4384: astore_1
    //   4385: aload_1
    //   4386: astore 15
    //   4388: aload 17
    //   4390: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   4393: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4396: iload 8
    //   4398: invokestatic 4447	com/tencent/mobileqq/utils/SharedPreUtils:n	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4401: aload_1
    //   4402: astore 15
    //   4404: aload 17
    //   4406: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4409: ldc_w 4449
    //   4412: invokestatic 4454	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   4415: ifne +56 -> 4471
    //   4418: aload_1
    //   4419: astore 15
    //   4421: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4424: ifeq +16 -> 4440
    //   4427: aload_1
    //   4428: astore 15
    //   4430: ldc_w 1601
    //   4433: iconst_2
    //   4434: ldc_w 4456
    //   4437: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4440: aload_1
    //   4441: astore 15
    //   4443: aload 5
    //   4445: invokestatic 4457	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)V
    //   4448: aload_1
    //   4449: astore 15
    //   4451: aload 17
    //   4453: aload_1
    //   4454: invokestatic 4460	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   4457: iload 7
    //   4459: istore 8
    //   4461: aload_1
    //   4462: astore 16
    //   4464: iload 13
    //   4466: istore 14
    //   4468: goto -4367 -> 101
    //   4471: iload 7
    //   4473: istore 8
    //   4475: aload_1
    //   4476: astore 16
    //   4478: iload 13
    //   4480: istore 14
    //   4482: aload_1
    //   4483: astore 15
    //   4485: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4488: ifeq -4387 -> 101
    //   4491: aload_1
    //   4492: astore 15
    //   4494: ldc_w 1601
    //   4497: iconst_2
    //   4498: ldc_w 4462
    //   4501: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4504: iload 7
    //   4506: istore 8
    //   4508: aload_1
    //   4509: astore 16
    //   4511: iload 13
    //   4513: istore 14
    //   4515: goto -4414 -> 101
    //   4518: iload 7
    //   4520: istore 8
    //   4522: aload_1
    //   4523: astore 16
    //   4525: iload 13
    //   4527: istore 14
    //   4529: aload_1
    //   4530: astore 15
    //   4532: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4535: ifeq -4434 -> 101
    //   4538: aload_1
    //   4539: astore 15
    //   4541: ldc_w 1601
    //   4544: iconst_2
    //   4545: ldc_w 4464
    //   4548: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4551: iload 7
    //   4553: istore 8
    //   4555: aload_1
    //   4556: astore 16
    //   4558: iload 13
    //   4560: istore 14
    //   4562: goto -4461 -> 101
    //   4565: aload_1
    //   4566: astore 15
    //   4568: aload_0
    //   4569: aload 17
    //   4571: aload 18
    //   4573: invokevirtual 4466	com/tencent/mobileqq/config/splashlogo/ConfigServlet:m	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4576: iload 7
    //   4578: istore 8
    //   4580: aload_1
    //   4581: astore 16
    //   4583: iload 13
    //   4585: istore 14
    //   4587: goto -4486 -> 101
    //   4590: aload_1
    //   4591: astore 15
    //   4593: aload_0
    //   4594: aload 17
    //   4596: aload 5
    //   4598: aload 18
    //   4600: invokespecial 4468	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4603: iload 7
    //   4605: istore 8
    //   4607: aload_1
    //   4608: astore 16
    //   4610: iload 13
    //   4612: istore 14
    //   4614: goto -4513 -> 101
    //   4617: aload_1
    //   4618: astore 15
    //   4620: aload_0
    //   4621: aload 17
    //   4623: aload 18
    //   4625: invokevirtual 4470	com/tencent/mobileqq/config/splashlogo/ConfigServlet:u	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4628: iload 7
    //   4630: istore 8
    //   4632: aload_1
    //   4633: astore 16
    //   4635: iload 13
    //   4637: istore 14
    //   4639: goto -4538 -> 101
    //   4642: aload_1
    //   4643: astore 15
    //   4645: aload_0
    //   4646: aload 17
    //   4648: aload 18
    //   4650: invokevirtual 4472	com/tencent/mobileqq/config/splashlogo/ConfigServlet:w	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4653: iload 7
    //   4655: istore 8
    //   4657: aload_1
    //   4658: astore 16
    //   4660: iload 13
    //   4662: istore 14
    //   4664: goto -4563 -> 101
    //   4667: aload_1
    //   4668: astore 15
    //   4670: aload_0
    //   4671: aload 17
    //   4673: aload 18
    //   4675: invokevirtual 4474	com/tencent/mobileqq/config/splashlogo/ConfigServlet:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4678: iload 7
    //   4680: istore 8
    //   4682: aload_1
    //   4683: astore 16
    //   4685: iload 13
    //   4687: istore 14
    //   4689: goto -4588 -> 101
    //   4692: aload_1
    //   4693: astore 15
    //   4695: aload_0
    //   4696: aload 17
    //   4698: aload 18
    //   4700: invokevirtual 4476	com/tencent/mobileqq/config/splashlogo/ConfigServlet:r	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4703: iload 7
    //   4705: istore 8
    //   4707: aload_1
    //   4708: astore 16
    //   4710: iload 13
    //   4712: istore 14
    //   4714: goto -4613 -> 101
    //   4717: aload_1
    //   4718: astore 15
    //   4720: aload_0
    //   4721: aload 17
    //   4723: aload 18
    //   4725: invokevirtual 4478	com/tencent/mobileqq/config/splashlogo/ConfigServlet:o	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4728: iload 7
    //   4730: istore 8
    //   4732: aload_1
    //   4733: astore 16
    //   4735: iload 13
    //   4737: istore 14
    //   4739: goto -4638 -> 101
    //   4742: aload_1
    //   4743: astore 15
    //   4745: aload_0
    //   4746: aload 17
    //   4748: aload 18
    //   4750: invokevirtual 4480	com/tencent/mobileqq/config/splashlogo/ConfigServlet:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4753: iload 7
    //   4755: istore 8
    //   4757: aload_1
    //   4758: astore 16
    //   4760: iload 13
    //   4762: istore 14
    //   4764: goto -4663 -> 101
    //   4767: aload_1
    //   4768: astore 15
    //   4770: aload_0
    //   4771: aload 17
    //   4773: aload 18
    //   4775: invokevirtual 4482	com/tencent/mobileqq/config/splashlogo/ConfigServlet:s	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4778: iload 7
    //   4780: istore 8
    //   4782: aload_1
    //   4783: astore 16
    //   4785: iload 13
    //   4787: istore 14
    //   4789: goto -4688 -> 101
    //   4792: aload_1
    //   4793: astore 15
    //   4795: aload_0
    //   4796: aload 17
    //   4798: aload 18
    //   4800: invokevirtual 4484	com/tencent/mobileqq/config/splashlogo/ConfigServlet:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4803: iload 7
    //   4805: istore 8
    //   4807: aload_1
    //   4808: astore 16
    //   4810: iload 13
    //   4812: istore 14
    //   4814: goto -4713 -> 101
    //   4817: aload_1
    //   4818: astore 15
    //   4820: aload_0
    //   4821: aload 17
    //   4823: aload 5
    //   4825: aload 18
    //   4827: invokespecial 4486	com/tencent/mobileqq/config/splashlogo/ConfigServlet:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4830: iload 7
    //   4832: istore 8
    //   4834: aload_1
    //   4835: astore 16
    //   4837: iload 13
    //   4839: istore 14
    //   4841: goto -4740 -> 101
    //   4844: aload_1
    //   4845: astore 15
    //   4847: aload 17
    //   4849: getstatic 1688	com/tencent/mobileqq/app/QQManagerFactory:TROOP_STORY_MANAGER	I
    //   4852: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4855: checkcast 1690	com/tencent/biz/qqstory/troop/TroopStoryManager
    //   4858: getfield 1693	com/tencent/biz/qqstory/troop/TroopStoryManager:a	Lcom/tencent/biz/qqstory/troop/TroopDynamicConfig;
    //   4861: aload 17
    //   4863: aload 18
    //   4865: invokevirtual 4487	com/tencent/biz/qqstory/troop/TroopDynamicConfig:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4868: iload 7
    //   4870: istore 8
    //   4872: aload_1
    //   4873: astore 16
    //   4875: iload 13
    //   4877: istore 14
    //   4879: goto -4778 -> 101
    //   4882: aload_1
    //   4883: astore 15
    //   4885: aload_0
    //   4886: aload 17
    //   4888: aload 18
    //   4890: invokevirtual 4489	com/tencent/mobileqq/config/splashlogo/ConfigServlet:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4893: iload 7
    //   4895: istore 8
    //   4897: aload_1
    //   4898: astore 16
    //   4900: iload 13
    //   4902: istore 14
    //   4904: goto -4803 -> 101
    //   4907: aload_1
    //   4908: astore 15
    //   4910: aload_0
    //   4911: aload 17
    //   4913: aload 18
    //   4915: invokespecial 4491	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aA	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4918: iload 7
    //   4920: istore 8
    //   4922: aload_1
    //   4923: astore 16
    //   4925: iload 13
    //   4927: istore 14
    //   4929: goto -4828 -> 101
    //   4932: aload_1
    //   4933: astore 15
    //   4935: aload_0
    //   4936: aload 17
    //   4938: aload 18
    //   4940: invokespecial 4493	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aF	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4943: iload 7
    //   4945: istore 8
    //   4947: aload_1
    //   4948: astore 16
    //   4950: iload 13
    //   4952: istore 14
    //   4954: goto -4853 -> 101
    //   4957: aload_1
    //   4958: astore 15
    //   4960: aload_0
    //   4961: aload 17
    //   4963: aload 18
    //   4965: invokevirtual 4495	com/tencent/mobileqq/config/splashlogo/ConfigServlet:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4968: iload 7
    //   4970: istore 8
    //   4972: aload_1
    //   4973: astore 16
    //   4975: iload 13
    //   4977: istore 14
    //   4979: goto -4878 -> 101
    //   4982: aload_1
    //   4983: astore 15
    //   4985: iload 11
    //   4987: aload 17
    //   4989: invokevirtual 1211	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4992: aload 18
    //   4994: invokestatic 4498	com/tencent/av/QAVConfig:a	(ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4997: iload 7
    //   4999: istore 8
    //   5001: aload_1
    //   5002: astore 16
    //   5004: iload 13
    //   5006: istore 14
    //   5008: goto -4907 -> 101
    //   5011: aload_1
    //   5012: astore 15
    //   5014: aload_0
    //   5015: aload 17
    //   5017: aload 18
    //   5019: invokespecial 4500	com/tencent/mobileqq/config/splashlogo/ConfigServlet:U	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5022: iload 7
    //   5024: istore 8
    //   5026: aload_1
    //   5027: astore 16
    //   5029: iload 13
    //   5031: istore 14
    //   5033: goto -4932 -> 101
    //   5036: aload_1
    //   5037: astore 15
    //   5039: aload_0
    //   5040: aload 17
    //   5042: aload 18
    //   5044: invokevirtual 4502	com/tencent/mobileqq/config/splashlogo/ConfigServlet:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5047: iload 7
    //   5049: istore 8
    //   5051: aload_1
    //   5052: astore 16
    //   5054: iload 13
    //   5056: istore 14
    //   5058: goto -4957 -> 101
    //   5061: aload_1
    //   5062: astore 15
    //   5064: aload_0
    //   5065: aload 17
    //   5067: aload 18
    //   5069: invokevirtual 4504	com/tencent/mobileqq/config/splashlogo/ConfigServlet:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5072: iload 7
    //   5074: istore 8
    //   5076: aload_1
    //   5077: astore 16
    //   5079: iload 13
    //   5081: istore 14
    //   5083: goto -4982 -> 101
    //   5086: aload_1
    //   5087: astore 15
    //   5089: aload_0
    //   5090: aload 17
    //   5092: aload 5
    //   5094: aload 18
    //   5096: invokespecial 4506	com/tencent/mobileqq/config/splashlogo/ConfigServlet:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5099: iload 7
    //   5101: istore 8
    //   5103: aload_1
    //   5104: astore 16
    //   5106: iload 13
    //   5108: istore 14
    //   5110: goto -5009 -> 101
    //   5113: aload_1
    //   5114: astore 15
    //   5116: aload_0
    //   5117: aload 17
    //   5119: aload 18
    //   5121: invokevirtual 4508	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5124: iload 7
    //   5126: istore 8
    //   5128: aload_1
    //   5129: astore 16
    //   5131: iload 13
    //   5133: istore 14
    //   5135: goto -5034 -> 101
    //   5138: aload_1
    //   5139: astore 15
    //   5141: aload_0
    //   5142: aload 17
    //   5144: aload 18
    //   5146: invokespecial 4510	com/tencent/mobileqq/config/splashlogo/ConfigServlet:Z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5149: iload 7
    //   5151: istore 8
    //   5153: aload_1
    //   5154: astore 16
    //   5156: iload 13
    //   5158: istore 14
    //   5160: goto -5059 -> 101
    //   5163: aload_1
    //   5164: astore 15
    //   5166: aload_0
    //   5167: aload 17
    //   5169: aload 18
    //   5171: invokespecial 4512	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aC	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5174: iload 7
    //   5176: istore 8
    //   5178: aload_1
    //   5179: astore 16
    //   5181: iload 13
    //   5183: istore 14
    //   5185: goto -5084 -> 101
    //   5188: aload_1
    //   5189: astore 15
    //   5191: aload_0
    //   5192: aload 17
    //   5194: aload 18
    //   5196: invokespecial 4514	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ag	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5199: iload 7
    //   5201: istore 8
    //   5203: aload_1
    //   5204: astore 16
    //   5206: iload 13
    //   5208: istore 14
    //   5210: goto -5109 -> 101
    //   5213: aload_1
    //   5214: astore 15
    //   5216: aload_0
    //   5217: aload 17
    //   5219: aload 18
    //   5221: invokespecial 4516	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aB	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5224: iload 7
    //   5226: istore 8
    //   5228: aload_1
    //   5229: astore 16
    //   5231: iload 13
    //   5233: istore 14
    //   5235: goto -5134 -> 101
    //   5238: aload_1
    //   5239: astore 15
    //   5241: aload_0
    //   5242: aload 17
    //   5244: aload 18
    //   5246: invokespecial 4518	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ab	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5249: iload 7
    //   5251: istore 8
    //   5253: aload_1
    //   5254: astore 16
    //   5256: iload 13
    //   5258: istore 14
    //   5260: goto -5159 -> 101
    //   5263: aload_1
    //   5264: astore 15
    //   5266: aload_0
    //   5267: aload 17
    //   5269: aload 18
    //   5271: invokespecial 4520	com/tencent/mobileqq/config/splashlogo/ConfigServlet:az	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5274: iload 7
    //   5276: istore 8
    //   5278: aload_1
    //   5279: astore 16
    //   5281: iload 13
    //   5283: istore 14
    //   5285: goto -5184 -> 101
    //   5288: aload_1
    //   5289: astore 15
    //   5291: aload_0
    //   5292: aload 17
    //   5294: aload 18
    //   5296: invokespecial 4522	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ay	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5299: iload 7
    //   5301: istore 8
    //   5303: aload_1
    //   5304: astore 16
    //   5306: iload 13
    //   5308: istore 14
    //   5310: goto -5209 -> 101
    //   5313: aload_1
    //   5314: astore 15
    //   5316: aload_0
    //   5317: aload 17
    //   5319: aload 18
    //   5321: invokespecial 4524	com/tencent/mobileqq/config/splashlogo/ConfigServlet:Y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5324: iload 7
    //   5326: istore 8
    //   5328: aload_1
    //   5329: astore 16
    //   5331: iload 13
    //   5333: istore 14
    //   5335: goto -5234 -> 101
    //   5338: aload_1
    //   5339: astore 15
    //   5341: aload 17
    //   5343: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   5346: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5349: invokestatic 1755	com/tencent/mobileqq/utils/SharedPreUtils:F	(Landroid/content/Context;Ljava/lang/String;)I
    //   5352: istore 8
    //   5354: aload_1
    //   5355: astore 15
    //   5357: aload 18
    //   5359: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5362: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5365: istore 9
    //   5367: aload_1
    //   5368: astore 15
    //   5370: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5373: ifeq +38 -> 5411
    //   5376: aload_1
    //   5377: astore 15
    //   5379: ldc 91
    //   5381: iconst_2
    //   5382: ldc_w 4526
    //   5385: iconst_2
    //   5386: anewarray 4	java/lang/Object
    //   5389: dup
    //   5390: iconst_0
    //   5391: iload 8
    //   5393: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5396: aastore
    //   5397: dup
    //   5398: iconst_1
    //   5399: iload 9
    //   5401: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5404: aastore
    //   5405: invokestatic 549	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5408: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5411: iload 8
    //   5413: iload 9
    //   5415: if_icmpeq +206 -> 5621
    //   5418: aload_1
    //   5419: astore 15
    //   5421: aload 18
    //   5423: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5426: ifnull +139 -> 5565
    //   5429: aload_1
    //   5430: astore 15
    //   5432: aload 18
    //   5434: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5437: invokevirtual 4527	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   5440: ifeq +6 -> 5446
    //   5443: goto +122 -> 5565
    //   5446: aload_1
    //   5447: astore 15
    //   5449: aload 18
    //   5451: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5454: iconst_0
    //   5455: invokevirtual 465	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   5458: checkcast 125	java/lang/String
    //   5461: astore 5
    //   5463: aload_1
    //   5464: astore 15
    //   5466: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5469: ifeq +52 -> 5521
    //   5472: aload_1
    //   5473: astore 15
    //   5475: new 77	java/lang/StringBuilder
    //   5478: dup
    //   5479: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   5482: astore 16
    //   5484: aload_1
    //   5485: astore 15
    //   5487: aload 16
    //   5489: ldc_w 4529
    //   5492: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5495: pop
    //   5496: aload_1
    //   5497: astore 15
    //   5499: aload 16
    //   5501: aload 5
    //   5503: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5506: pop
    //   5507: aload_1
    //   5508: astore 15
    //   5510: ldc 91
    //   5512: iconst_2
    //   5513: aload 16
    //   5515: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5518: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5521: aload_1
    //   5522: astore 15
    //   5524: aload 5
    //   5526: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5529: ifeq +19 -> 5548
    //   5532: aload_1
    //   5533: astore 15
    //   5535: ldc_w 4531
    //   5538: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5541: invokestatic 4536	com/tencent/mobileqq/upgrade/UpgradeConfigManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   5544: pop
    //   5545: goto +57 -> 5602
    //   5548: aload_1
    //   5549: astore 15
    //   5551: ldc_w 4531
    //   5554: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5557: aload 5
    //   5559: invokestatic 4539	com/tencent/mobileqq/upgrade/UpgradeConfigManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5562: goto +40 -> 5602
    //   5565: aload_1
    //   5566: astore 15
    //   5568: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5571: ifeq +15 -> 5586
    //   5574: aload_1
    //   5575: astore 15
    //   5577: ldc 91
    //   5579: iconst_2
    //   5580: ldc_w 4541
    //   5583: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5586: aload_1
    //   5587: astore 15
    //   5589: ldc_w 4531
    //   5592: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5595: invokestatic 4536	com/tencent/mobileqq/upgrade/UpgradeConfigManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   5598: pop
    //   5599: aconst_null
    //   5600: astore 5
    //   5602: aload_1
    //   5603: astore 15
    //   5605: aload 17
    //   5607: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   5610: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5613: iload 9
    //   5615: invokestatic 4543	com/tencent/mobileqq/utils/SharedPreUtils:m	(Landroid/content/Context;Ljava/lang/String;I)V
    //   5618: goto +27 -> 5645
    //   5621: aload_1
    //   5622: astore 15
    //   5624: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5627: ifeq +6566 -> 12193
    //   5630: aload_1
    //   5631: astore 15
    //   5633: ldc 91
    //   5635: iconst_2
    //   5636: ldc_w 4545
    //   5639: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5642: goto +6551 -> 12193
    //   5645: aload_1
    //   5646: astore 15
    //   5648: aload 17
    //   5650: getstatic 1770	com/tencent/mobileqq/app/BusinessHandlerFactory:CONFIG_HANDLER	Ljava/lang/String;
    //   5653: invokevirtual 1336	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   5656: checkcast 1772	com/tencent/mobileqq/app/ConfigHandler
    //   5659: astore 18
    //   5661: aload_1
    //   5662: astore 15
    //   5664: aload 5
    //   5666: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5669: ifne +448 -> 6117
    //   5672: aload_1
    //   5673: astore 15
    //   5675: invokestatic 4550	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeController;
    //   5678: invokevirtual 4553	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   5681: astore 16
    //   5683: aload_1
    //   5684: astore 15
    //   5686: aload 16
    //   5688: aload 5
    //   5690: invokevirtual 4556	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   5693: aload_1
    //   5694: astore 15
    //   5696: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5699: ifeq +45 -> 5744
    //   5702: aload_1
    //   5703: astore 15
    //   5705: ldc 91
    //   5707: iconst_2
    //   5708: ldc_w 4558
    //   5711: iconst_2
    //   5712: anewarray 4	java/lang/Object
    //   5715: dup
    //   5716: iconst_0
    //   5717: invokestatic 1198	com/tencent/common/config/AppSetting:a	()I
    //   5720: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5723: aastore
    //   5724: dup
    //   5725: iconst_1
    //   5726: aload 16
    //   5728: getfield 4561	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   5731: getfield 4566	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   5734: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5737: aastore
    //   5738: invokestatic 549	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5741: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5744: aload_1
    //   5745: astore 15
    //   5747: aload 17
    //   5749: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5752: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5755: invokestatic 4568	com/tencent/mobileqq/utils/SharedPreUtils:aG	(Landroid/content/Context;Ljava/lang/String;)I
    //   5758: aload 16
    //   5760: getfield 4561	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   5763: getfield 4566	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   5766: if_icmpeq +93 -> 5859
    //   5769: aload_1
    //   5770: astore 15
    //   5772: aload 17
    //   5774: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5777: aload 17
    //   5779: invokevirtual 1211	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   5782: iconst_0
    //   5783: invokestatic 4570	com/tencent/mobileqq/utils/SharedPreUtils:V	(Landroid/content/Context;Ljava/lang/String;I)V
    //   5786: aload_1
    //   5787: astore 15
    //   5789: aload 17
    //   5791: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5794: aload 17
    //   5796: invokevirtual 1211	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   5799: lconst_0
    //   5800: invokestatic 4573	com/tencent/mobileqq/utils/SharedPreUtils:g	(Landroid/content/Context;Ljava/lang/String;J)V
    //   5803: aload_1
    //   5804: astore 15
    //   5806: aload 17
    //   5808: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5811: aload 17
    //   5813: invokevirtual 1211	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   5816: iconst_0
    //   5817: invokestatic 4575	com/tencent/mobileqq/utils/SharedPreUtils:W	(Landroid/content/Context;Ljava/lang/String;I)V
    //   5820: aload_1
    //   5821: astore 15
    //   5823: aload 17
    //   5825: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5828: aload 17
    //   5830: invokevirtual 1211	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   5833: lconst_0
    //   5834: invokestatic 4577	com/tencent/mobileqq/utils/SharedPreUtils:h	(Landroid/content/Context;Ljava/lang/String;J)V
    //   5837: aload_1
    //   5838: astore 15
    //   5840: aload 17
    //   5842: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5845: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5848: aload 16
    //   5850: getfield 4561	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   5853: getfield 4566	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   5856: invokestatic 4579	com/tencent/mobileqq/utils/SharedPreUtils:U	(Landroid/content/Context;Ljava/lang/String;I)V
    //   5859: aload_1
    //   5860: astore 15
    //   5862: invokestatic 1198	com/tencent/common/config/AppSetting:a	()I
    //   5865: aload 16
    //   5867: getfield 4561	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   5870: getfield 4566	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   5873: if_icmplt +96 -> 5969
    //   5876: aload_1
    //   5877: astore 15
    //   5879: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5882: ifeq +15 -> 5897
    //   5885: aload_1
    //   5886: astore 15
    //   5888: ldc 91
    //   5890: iconst_2
    //   5891: ldc_w 4581
    //   5894: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5897: aload_1
    //   5898: astore 15
    //   5900: aload 17
    //   5902: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5905: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5908: iconst_0
    //   5909: invokestatic 4543	com/tencent/mobileqq/utils/SharedPreUtils:m	(Landroid/content/Context;Ljava/lang/String;I)V
    //   5912: aload_1
    //   5913: astore 15
    //   5915: ldc_w 4531
    //   5918: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5921: invokestatic 4536	com/tencent/mobileqq/upgrade/UpgradeConfigManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   5924: pop
    //   5925: aload_1
    //   5926: astore 15
    //   5928: aload 16
    //   5930: getfield 4561	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   5933: iconst_0
    //   5934: putfield 4584	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   5937: aload_1
    //   5938: astore 15
    //   5940: aload 18
    //   5942: aload 16
    //   5944: invokevirtual 4587	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   5947: aload_1
    //   5948: astore 15
    //   5950: aload 18
    //   5952: invokevirtual 4588	com/tencent/mobileqq/app/ConfigHandler:d	()V
    //   5955: iload 7
    //   5957: istore 8
    //   5959: aload_1
    //   5960: astore 16
    //   5962: iload 13
    //   5964: istore 14
    //   5966: goto -5865 -> 101
    //   5969: aload 17
    //   5971: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   5974: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5977: invokestatic 2164	java/lang/System:currentTimeMillis	()J
    //   5980: invokestatic 4590	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;J)V
    //   5983: aload 16
    //   5985: monitorenter
    //   5986: aload 16
    //   5988: getfield 4591	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Boolean	Z
    //   5991: ifne +30 -> 6021
    //   5994: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5997: ifeq +12 -> 6009
    //   6000: ldc 91
    //   6002: iconst_2
    //   6003: ldc_w 4593
    //   6006: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6009: aload 16
    //   6011: monitorexit
    //   6012: iconst_1
    //   6013: istore 14
    //   6015: aload_1
    //   6016: astore 16
    //   6018: goto -5913 -> 105
    //   6021: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6024: ifeq +12 -> 6036
    //   6027: ldc 91
    //   6029: iconst_2
    //   6030: ldc_w 4595
    //   6033: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6036: aload 16
    //   6038: getfield 4596	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_Int	I
    //   6041: ifne +25 -> 6066
    //   6044: aload 16
    //   6046: getfield 4597	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_a_of_type_Int	I
    //   6049: iconst_1
    //   6050: if_icmpne +6149 -> 12199
    //   6053: iconst_1
    //   6054: istore 13
    //   6056: goto +3 -> 6059
    //   6059: aload 17
    //   6061: iload 13
    //   6063: invokestatic 4598	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   6066: aload 18
    //   6068: invokevirtual 4588	com/tencent/mobileqq/app/ConfigHandler:d	()V
    //   6071: invokestatic 4550	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeController;
    //   6074: aload 16
    //   6076: getfield 4561	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:jdField_b_of_type_ProtocolKQQConfigUpgradeInfo	Lprotocol/KQQConfig/UpgradeInfo;
    //   6079: aload 18
    //   6081: invokevirtual 4601	com/tencent/mobileqq/upgrade/UpgradeController:a	(Lprotocol/KQQConfig/UpgradeInfo;Lcom/tencent/mobileqq/upgrade/UpgradeController$OnHandleUpgradeFinishListener;)Z
    //   6084: pop
    //   6085: aload 16
    //   6087: monitorexit
    //   6088: iconst_1
    //   6089: istore 14
    //   6091: iload 7
    //   6093: istore 8
    //   6095: aload_1
    //   6096: astore 16
    //   6098: goto -5997 -> 101
    //   6101: astore 5
    //   6103: aload 16
    //   6105: monitorexit
    //   6106: aload 5
    //   6108: athrow
    //   6109: astore 5
    //   6111: iconst_1
    //   6112: istore 13
    //   6114: goto +6056 -> 12170
    //   6117: aload_1
    //   6118: astore 15
    //   6120: aload 18
    //   6122: invokevirtual 4588	com/tencent/mobileqq/app/ConfigHandler:d	()V
    //   6125: aload_1
    //   6126: astore 15
    //   6128: aload 18
    //   6130: invokestatic 4550	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeController;
    //   6133: invokevirtual 4553	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   6136: invokevirtual 4587	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   6139: iload 7
    //   6141: istore 8
    //   6143: aload_1
    //   6144: astore 16
    //   6146: iload 13
    //   6148: istore 14
    //   6150: goto -6049 -> 101
    //   6153: aload_1
    //   6154: astore 15
    //   6156: aload_0
    //   6157: aload 17
    //   6159: aload 5
    //   6161: aload 18
    //   6163: invokespecial 4603	com/tencent/mobileqq/config/splashlogo/ConfigServlet:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6166: iload 7
    //   6168: istore 8
    //   6170: aload_1
    //   6171: astore 16
    //   6173: iload 13
    //   6175: istore 14
    //   6177: goto -6076 -> 101
    //   6180: aload_1
    //   6181: astore 15
    //   6183: aload_0
    //   6184: aload 17
    //   6186: aload 18
    //   6188: invokespecial 4605	com/tencent/mobileqq/config/splashlogo/ConfigServlet:X	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6191: iload 7
    //   6193: istore 8
    //   6195: aload_1
    //   6196: astore 16
    //   6198: iload 13
    //   6200: istore 14
    //   6202: goto -6101 -> 101
    //   6205: aload_2
    //   6206: getfield 4608	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6209: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6212: istore 8
    //   6214: aload_1
    //   6215: astore 15
    //   6217: aload_0
    //   6218: aload 5
    //   6220: iload 6
    //   6222: aload 18
    //   6224: iload 8
    //   6226: invokevirtual 4610	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   6229: iload 7
    //   6231: istore 8
    //   6233: aload_1
    //   6234: astore 16
    //   6236: iload 13
    //   6238: istore 14
    //   6240: goto -6139 -> 101
    //   6243: aload_1
    //   6244: astore 15
    //   6246: aload_0
    //   6247: aload 17
    //   6249: aload 18
    //   6251: invokespecial 4612	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ah	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6254: iload 7
    //   6256: istore 8
    //   6258: aload_1
    //   6259: astore 16
    //   6261: iload 13
    //   6263: istore 14
    //   6265: goto -6164 -> 101
    //   6268: aload_1
    //   6269: astore 15
    //   6271: aload_0
    //   6272: aload 17
    //   6274: aload 5
    //   6276: aload 18
    //   6278: invokespecial 4614	com/tencent/mobileqq/config/splashlogo/ConfigServlet:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6281: iload 7
    //   6283: istore 8
    //   6285: aload_1
    //   6286: astore 16
    //   6288: iload 13
    //   6290: istore 14
    //   6292: goto -6191 -> 101
    //   6295: iload 7
    //   6297: istore 9
    //   6299: aload 18
    //   6301: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6304: ifnull +202 -> 6506
    //   6307: iload 7
    //   6309: istore 9
    //   6311: aload 18
    //   6313: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6316: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6319: ifle +187 -> 6506
    //   6322: iload 7
    //   6324: istore 9
    //   6326: aload 18
    //   6328: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6331: invokevirtual 1046	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   6334: invokeinterface 114 1 0
    //   6339: astore 5
    //   6341: iload 7
    //   6343: istore 8
    //   6345: aload_1
    //   6346: astore 16
    //   6348: iload 13
    //   6350: istore 14
    //   6352: iload 7
    //   6354: istore 9
    //   6356: aload 5
    //   6358: invokeinterface 119 1 0
    //   6363: ifeq -6262 -> 101
    //   6366: iload 7
    //   6368: istore 9
    //   6370: aload 5
    //   6372: invokeinterface 123 1 0
    //   6377: checkcast 125	java/lang/String
    //   6380: astore 15
    //   6382: iload 7
    //   6384: istore 9
    //   6386: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6389: ifeq +5821 -> 12210
    //   6392: iload 7
    //   6394: istore 9
    //   6396: new 77	java/lang/StringBuilder
    //   6399: dup
    //   6400: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   6403: astore 16
    //   6405: iload 7
    //   6407: istore 9
    //   6409: iload 9
    //   6411: istore 8
    //   6413: aload 16
    //   6415: ldc_w 4616
    //   6418: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6421: pop
    //   6422: iload 9
    //   6424: istore 8
    //   6426: aload 16
    //   6428: aload 15
    //   6430: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6433: pop
    //   6434: iload 9
    //   6436: istore 8
    //   6438: aload 16
    //   6440: ldc_w 472
    //   6443: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6446: pop
    //   6447: iload 9
    //   6449: istore 8
    //   6451: aload 16
    //   6453: aload 18
    //   6455: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6458: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6461: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6464: pop
    //   6465: iload 9
    //   6467: istore 8
    //   6469: ldc 91
    //   6471: iconst_2
    //   6472: aload 16
    //   6474: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6477: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6480: goto +3 -> 6483
    //   6483: iload 7
    //   6485: istore 8
    //   6487: aload_0
    //   6488: aload 17
    //   6490: aload 15
    //   6492: aload 18
    //   6494: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6497: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6500: invokespecial 4618	com/tencent/mobileqq/config/splashlogo/ConfigServlet:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   6503: goto -162 -> 6341
    //   6506: iload 7
    //   6508: istore 9
    //   6510: aload_1
    //   6511: astore 16
    //   6513: iload 13
    //   6515: istore 14
    //   6517: iload 9
    //   6519: istore 7
    //   6521: iload 9
    //   6523: istore 8
    //   6525: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6528: ifeq -6423 -> 105
    //   6531: iload 9
    //   6533: istore 8
    //   6535: new 77	java/lang/StringBuilder
    //   6538: dup
    //   6539: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   6542: astore 5
    //   6544: iload 9
    //   6546: istore 8
    //   6548: aload 5
    //   6550: ldc_w 4620
    //   6553: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6556: pop
    //   6557: iload 9
    //   6559: istore 8
    //   6561: aload 5
    //   6563: aload 18
    //   6565: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6568: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6571: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6574: pop
    //   6575: iload 9
    //   6577: istore 8
    //   6579: ldc 91
    //   6581: iconst_2
    //   6582: aload 5
    //   6584: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6587: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6590: aload_1
    //   6591: astore 16
    //   6593: iload 13
    //   6595: istore 14
    //   6597: iload 9
    //   6599: istore 7
    //   6601: goto -6496 -> 105
    //   6604: astore 5
    //   6606: iload 8
    //   6608: istore 7
    //   6610: goto +9 -> 6619
    //   6613: astore 5
    //   6615: iload 9
    //   6617: istore 7
    //   6619: iload 7
    //   6621: istore 8
    //   6623: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6626: ifeq +59 -> 6685
    //   6629: iload 7
    //   6631: istore 8
    //   6633: new 77	java/lang/StringBuilder
    //   6636: dup
    //   6637: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   6640: astore 15
    //   6642: iload 7
    //   6644: istore 8
    //   6646: aload 15
    //   6648: ldc_w 4622
    //   6651: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6654: pop
    //   6655: iload 7
    //   6657: istore 8
    //   6659: aload 15
    //   6661: aload 5
    //   6663: invokevirtual 529	java/lang/Exception:toString	()Ljava/lang/String;
    //   6666: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6669: pop
    //   6670: iload 7
    //   6672: istore 8
    //   6674: ldc 91
    //   6676: iconst_2
    //   6677: aload 15
    //   6679: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6682: invokestatic 531	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6685: iload 7
    //   6687: istore 8
    //   6689: aload 5
    //   6691: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   6694: aload_1
    //   6695: astore 16
    //   6697: iload 13
    //   6699: istore 14
    //   6701: goto -6596 -> 105
    //   6704: iload 7
    //   6706: istore 9
    //   6708: iload 9
    //   6710: istore 8
    //   6712: aload 18
    //   6714: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6717: ifnull +250 -> 6967
    //   6720: iload 9
    //   6722: istore 8
    //   6724: aload 18
    //   6726: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6729: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6732: ifle +235 -> 6967
    //   6735: iload 9
    //   6737: istore 8
    //   6739: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6742: ifeq +122 -> 6864
    //   6745: iload 9
    //   6747: istore 8
    //   6749: new 77	java/lang/StringBuilder
    //   6752: dup
    //   6753: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   6756: astore 5
    //   6758: iload 9
    //   6760: istore 8
    //   6762: aload 5
    //   6764: ldc_w 4624
    //   6767: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6770: pop
    //   6771: iload 9
    //   6773: istore 8
    //   6775: aload 5
    //   6777: iload 11
    //   6779: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6782: pop
    //   6783: iload 9
    //   6785: istore 8
    //   6787: aload 5
    //   6789: ldc_w 4626
    //   6792: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6795: pop
    //   6796: iload 9
    //   6798: istore 8
    //   6800: aload 5
    //   6802: aload 18
    //   6804: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6807: iconst_0
    //   6808: invokevirtual 465	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6811: checkcast 125	java/lang/String
    //   6814: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6817: pop
    //   6818: iload 9
    //   6820: istore 8
    //   6822: aload 5
    //   6824: ldc_w 472
    //   6827: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6830: pop
    //   6831: iload 9
    //   6833: istore 8
    //   6835: aload 5
    //   6837: aload 18
    //   6839: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6842: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6845: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6848: pop
    //   6849: iload 9
    //   6851: istore 8
    //   6853: ldc 91
    //   6855: iconst_2
    //   6856: aload 5
    //   6858: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6861: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6864: iload 9
    //   6866: istore 8
    //   6868: aload 17
    //   6870: getstatic 4629	com/tencent/mobileqq/app/QQManagerFactory:PHOTO_PLUS_MANAGER	I
    //   6873: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6876: checkcast 4631	cooperation/photoplus/PhotoPlusManager
    //   6879: astore 5
    //   6881: iload 9
    //   6883: istore 8
    //   6885: aload 18
    //   6887: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6890: astore 15
    //   6892: aload 15
    //   6894: iconst_0
    //   6895: invokevirtual 465	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6898: astore 15
    //   6900: aload_1
    //   6901: astore 16
    //   6903: iload 13
    //   6905: istore 14
    //   6907: iload 9
    //   6909: istore 7
    //   6911: iload 9
    //   6913: istore 8
    //   6915: aload 5
    //   6917: aload 15
    //   6919: checkcast 125	java/lang/String
    //   6922: invokevirtual 4632	cooperation/photoplus/PhotoPlusManager:a	(Ljava/lang/String;)Z
    //   6925: ifeq -6820 -> 105
    //   6928: iload 9
    //   6930: istore 8
    //   6932: aload 17
    //   6934: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   6937: aload 17
    //   6939: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   6942: aload 18
    //   6944: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6947: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6950: invokestatic 4634	com/tencent/mobileqq/utils/SharedPreUtils:o	(Landroid/content/Context;Ljava/lang/String;I)V
    //   6953: aload_1
    //   6954: astore 16
    //   6956: iload 13
    //   6958: istore 14
    //   6960: iload 9
    //   6962: istore 7
    //   6964: goto -6859 -> 105
    //   6967: aload_1
    //   6968: astore 16
    //   6970: iload 13
    //   6972: istore 14
    //   6974: iload 9
    //   6976: istore 7
    //   6978: iload 9
    //   6980: istore 8
    //   6982: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6985: ifeq -6880 -> 105
    //   6988: iload 9
    //   6990: istore 8
    //   6992: new 77	java/lang/StringBuilder
    //   6995: dup
    //   6996: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   6999: astore 5
    //   7001: iload 9
    //   7003: istore 8
    //   7005: aload 5
    //   7007: ldc_w 4624
    //   7010: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7013: pop
    //   7014: iload 9
    //   7016: istore 8
    //   7018: aload 5
    //   7020: iload 11
    //   7022: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7025: pop
    //   7026: iload 9
    //   7028: istore 8
    //   7030: aload 5
    //   7032: ldc_w 4636
    //   7035: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7038: pop
    //   7039: iload 9
    //   7041: istore 8
    //   7043: aload 5
    //   7045: aload 18
    //   7047: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7050: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7053: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7056: pop
    //   7057: iload 9
    //   7059: istore 8
    //   7061: ldc 91
    //   7063: iconst_2
    //   7064: aload 5
    //   7066: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7069: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7072: aload_1
    //   7073: astore 16
    //   7075: iload 13
    //   7077: istore 14
    //   7079: iload 9
    //   7081: istore 7
    //   7083: goto -6978 -> 105
    //   7086: iload 7
    //   7088: istore 8
    //   7090: aload_0
    //   7091: aload 17
    //   7093: aload 5
    //   7095: aload 18
    //   7097: invokespecial 4638	com/tencent/mobileqq/config/splashlogo/ConfigServlet:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7100: aload_1
    //   7101: astore 16
    //   7103: iload 13
    //   7105: istore 14
    //   7107: goto -7002 -> 105
    //   7110: iload 7
    //   7112: istore 8
    //   7114: aload_0
    //   7115: aload 17
    //   7117: aload 18
    //   7119: invokespecial 4640	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ax	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7122: aload_1
    //   7123: astore 16
    //   7125: iload 13
    //   7127: istore 14
    //   7129: goto -7024 -> 105
    //   7132: iload 7
    //   7134: istore 8
    //   7136: aload_0
    //   7137: aload 17
    //   7139: aload 18
    //   7141: invokespecial 4642	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ar	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7144: aload_1
    //   7145: astore 16
    //   7147: iload 13
    //   7149: istore 14
    //   7151: goto -7046 -> 105
    //   7154: iload 7
    //   7156: istore 8
    //   7158: aload_0
    //   7159: aload 17
    //   7161: aload 18
    //   7163: invokespecial 4644	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aj	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7166: aload_1
    //   7167: astore 16
    //   7169: iload 13
    //   7171: istore 14
    //   7173: goto -7068 -> 105
    //   7176: iload 7
    //   7178: istore 9
    //   7180: aload_1
    //   7181: astore 16
    //   7183: iload 13
    //   7185: istore 14
    //   7187: iload 9
    //   7189: istore 7
    //   7191: iload 9
    //   7193: istore 8
    //   7195: aload 18
    //   7197: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7200: ifnull -7095 -> 105
    //   7203: iload 9
    //   7205: istore 8
    //   7207: aload 17
    //   7209: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7212: aload 18
    //   7214: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7217: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7220: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7223: invokestatic 4646	com/tencent/mobileqq/utils/SharedPreUtils:d	(Landroid/content/Context;ILjava/lang/String;)V
    //   7226: iload 9
    //   7228: istore 8
    //   7230: aload 17
    //   7232: getstatic 4649	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	Ljava/lang/String;
    //   7235: invokevirtual 1336	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   7238: checkcast 4651	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   7241: aload 18
    //   7243: invokevirtual 4652	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7246: aload_1
    //   7247: astore 16
    //   7249: iload 13
    //   7251: istore 14
    //   7253: iload 9
    //   7255: istore 7
    //   7257: goto -7152 -> 105
    //   7260: iload 7
    //   7262: istore 8
    //   7264: aload_0
    //   7265: aload 17
    //   7267: aload 18
    //   7269: invokespecial 4654	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ap	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7272: aload_1
    //   7273: astore 16
    //   7275: iload 13
    //   7277: istore 14
    //   7279: goto -7174 -> 105
    //   7282: iload 7
    //   7284: istore 8
    //   7286: aload_0
    //   7287: aload 17
    //   7289: aload 18
    //   7291: invokespecial 4656	com/tencent/mobileqq/config/splashlogo/ConfigServlet:an	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7294: aload_1
    //   7295: astore 16
    //   7297: iload 13
    //   7299: istore 14
    //   7301: goto -7196 -> 105
    //   7304: iload 7
    //   7306: istore 8
    //   7308: aload_0
    //   7309: aload 17
    //   7311: aload 18
    //   7313: invokespecial 4658	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ao	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7316: aload_1
    //   7317: astore 16
    //   7319: iload 13
    //   7321: istore 14
    //   7323: goto -7218 -> 105
    //   7326: iload 7
    //   7328: istore 8
    //   7330: aload_0
    //   7331: aload 17
    //   7333: aload 5
    //   7335: aload 18
    //   7337: invokespecial 4660	com/tencent/mobileqq/config/splashlogo/ConfigServlet:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7340: aload_1
    //   7341: astore 16
    //   7343: iload 13
    //   7345: istore 14
    //   7347: goto -7242 -> 105
    //   7350: iload 7
    //   7352: istore 8
    //   7354: aload_0
    //   7355: aload 17
    //   7357: aload 18
    //   7359: invokespecial 4662	com/tencent/mobileqq/config/splashlogo/ConfigServlet:al	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7362: aload_1
    //   7363: astore 16
    //   7365: iload 13
    //   7367: istore 14
    //   7369: goto -7264 -> 105
    //   7372: iload 7
    //   7374: istore 9
    //   7376: aload 18
    //   7378: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7381: ifnull +147 -> 7528
    //   7384: aload 18
    //   7386: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7389: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7392: ifle +136 -> 7528
    //   7395: aload 18
    //   7397: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7400: invokevirtual 1046	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7403: invokeinterface 114 1 0
    //   7408: astore 5
    //   7410: aload_1
    //   7411: astore 16
    //   7413: iload 13
    //   7415: istore 14
    //   7417: iload 9
    //   7419: istore 7
    //   7421: aload 5
    //   7423: invokeinterface 119 1 0
    //   7428: ifeq -7323 -> 105
    //   7431: aload 5
    //   7433: invokeinterface 123 1 0
    //   7438: checkcast 125	java/lang/String
    //   7441: astore 15
    //   7443: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7446: ifeq +63 -> 7509
    //   7449: new 77	java/lang/StringBuilder
    //   7452: dup
    //   7453: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   7456: astore 16
    //   7458: aload 16
    //   7460: ldc_w 4664
    //   7463: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7466: pop
    //   7467: aload 16
    //   7469: aload 15
    //   7471: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7474: pop
    //   7475: aload 16
    //   7477: ldc_w 472
    //   7480: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7483: pop
    //   7484: aload 16
    //   7486: aload 18
    //   7488: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7491: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7494: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7497: pop
    //   7498: ldc 91
    //   7500: iconst_2
    //   7501: aload 16
    //   7503: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7506: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7509: aload_0
    //   7510: aload 17
    //   7512: aload 15
    //   7514: aload 18
    //   7516: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7519: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7522: invokespecial 4666	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   7525: goto -115 -> 7410
    //   7528: aload_1
    //   7529: astore 16
    //   7531: iload 13
    //   7533: istore 14
    //   7535: iload 9
    //   7537: istore 7
    //   7539: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7542: ifeq -7437 -> 105
    //   7545: new 77	java/lang/StringBuilder
    //   7548: dup
    //   7549: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   7552: astore 5
    //   7554: aload 5
    //   7556: ldc_w 4668
    //   7559: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7562: pop
    //   7563: aload 5
    //   7565: aload 18
    //   7567: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7570: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7573: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7576: pop
    //   7577: ldc 91
    //   7579: iconst_2
    //   7580: aload 5
    //   7582: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7585: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7588: aload_1
    //   7589: astore 16
    //   7591: iload 13
    //   7593: istore 14
    //   7595: iload 9
    //   7597: istore 7
    //   7599: goto -7494 -> 105
    //   7602: astore 5
    //   7604: iload 9
    //   7606: istore 8
    //   7608: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7611: ifeq +59 -> 7670
    //   7614: iload 9
    //   7616: istore 8
    //   7618: new 77	java/lang/StringBuilder
    //   7621: dup
    //   7622: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   7625: astore 15
    //   7627: iload 9
    //   7629: istore 8
    //   7631: aload 15
    //   7633: ldc_w 4670
    //   7636: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7639: pop
    //   7640: iload 9
    //   7642: istore 8
    //   7644: aload 15
    //   7646: aload 5
    //   7648: invokevirtual 529	java/lang/Exception:toString	()Ljava/lang/String;
    //   7651: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7654: pop
    //   7655: iload 9
    //   7657: istore 8
    //   7659: ldc 91
    //   7661: iconst_2
    //   7662: aload 15
    //   7664: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7667: invokestatic 531	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7670: iload 9
    //   7672: istore 8
    //   7674: aload 5
    //   7676: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   7679: aload_1
    //   7680: astore 16
    //   7682: iload 13
    //   7684: istore 14
    //   7686: iload 9
    //   7688: istore 7
    //   7690: goto -7585 -> 105
    //   7693: iload 7
    //   7695: istore 8
    //   7697: aload_0
    //   7698: aload 17
    //   7700: aload 18
    //   7702: invokespecial 4672	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ai	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7705: aload_1
    //   7706: astore 16
    //   7708: iload 13
    //   7710: istore 14
    //   7712: goto -7607 -> 105
    //   7715: iload 7
    //   7717: istore 9
    //   7719: iload 9
    //   7721: istore 8
    //   7723: aload 18
    //   7725: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7728: ifnull +187 -> 7915
    //   7731: iload 9
    //   7733: istore 8
    //   7735: aload 18
    //   7737: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7740: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7743: ifle +172 -> 7915
    //   7746: iload 9
    //   7748: istore 8
    //   7750: aload 18
    //   7752: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7755: iconst_0
    //   7756: invokevirtual 465	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7759: checkcast 125	java/lang/String
    //   7762: astore 5
    //   7764: iload 9
    //   7766: istore 8
    //   7768: aload 18
    //   7770: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7773: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7776: istore 7
    //   7778: iload 9
    //   7780: istore 8
    //   7782: aload 17
    //   7784: invokevirtual 4676	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   7787: aload 17
    //   7789: aload 5
    //   7791: iload 7
    //   7793: invokevirtual 4679	com/tencent/av/gaudio/AVNotifyCenter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   7796: aload_1
    //   7797: astore 16
    //   7799: iload 13
    //   7801: istore 14
    //   7803: iload 9
    //   7805: istore 7
    //   7807: iload 9
    //   7809: istore 8
    //   7811: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7814: ifeq -7709 -> 105
    //   7817: iload 9
    //   7819: istore 8
    //   7821: new 77	java/lang/StringBuilder
    //   7824: dup
    //   7825: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   7828: astore 15
    //   7830: iload 9
    //   7832: istore 8
    //   7834: aload 15
    //   7836: ldc_w 4681
    //   7839: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7842: pop
    //   7843: iload 9
    //   7845: istore 8
    //   7847: aload 15
    //   7849: aload 5
    //   7851: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7854: pop
    //   7855: iload 9
    //   7857: istore 8
    //   7859: aload 15
    //   7861: ldc_w 472
    //   7864: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7867: pop
    //   7868: iload 9
    //   7870: istore 8
    //   7872: aload 15
    //   7874: aload 18
    //   7876: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7879: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7882: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7885: pop
    //   7886: iload 9
    //   7888: istore 8
    //   7890: ldc 91
    //   7892: iconst_2
    //   7893: aload 15
    //   7895: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7898: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7901: aload_1
    //   7902: astore 16
    //   7904: iload 13
    //   7906: istore 14
    //   7908: iload 9
    //   7910: istore 7
    //   7912: goto -7807 -> 105
    //   7915: aload_1
    //   7916: astore 16
    //   7918: iload 13
    //   7920: istore 14
    //   7922: iload 9
    //   7924: istore 7
    //   7926: iload 9
    //   7928: istore 8
    //   7930: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7933: ifeq -7828 -> 105
    //   7936: iload 9
    //   7938: istore 8
    //   7940: new 77	java/lang/StringBuilder
    //   7943: dup
    //   7944: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   7947: astore 5
    //   7949: iload 9
    //   7951: istore 8
    //   7953: aload 5
    //   7955: ldc_w 4683
    //   7958: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7961: pop
    //   7962: iload 9
    //   7964: istore 8
    //   7966: aload 5
    //   7968: aload 18
    //   7970: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7973: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7976: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7979: pop
    //   7980: iload 9
    //   7982: istore 8
    //   7984: ldc 91
    //   7986: iconst_2
    //   7987: aload 5
    //   7989: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7992: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7995: aload_1
    //   7996: astore 16
    //   7998: iload 13
    //   8000: istore 14
    //   8002: iload 9
    //   8004: istore 7
    //   8006: goto -7901 -> 105
    //   8009: iload 7
    //   8011: istore 8
    //   8013: aload_0
    //   8014: aload 17
    //   8016: aload 5
    //   8018: aload 18
    //   8020: invokespecial 4685	com/tencent/mobileqq/config/splashlogo/ConfigServlet:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8023: aload_1
    //   8024: astore 16
    //   8026: iload 13
    //   8028: istore 14
    //   8030: goto -7925 -> 105
    //   8033: iload 7
    //   8035: istore 8
    //   8037: aload 18
    //   8039: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8042: ifnull +4171 -> 12213
    //   8045: iload 7
    //   8047: istore 8
    //   8049: aload 18
    //   8051: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8054: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8057: ifle +4156 -> 12213
    //   8060: iload 7
    //   8062: istore 8
    //   8064: aload 18
    //   8066: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8069: invokevirtual 1046	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   8072: astore 5
    //   8074: goto +3 -> 8077
    //   8077: aload 5
    //   8079: ifnull +289 -> 8368
    //   8082: iload 7
    //   8084: istore 8
    //   8086: aload 5
    //   8088: invokeinterface 110 1 0
    //   8093: ifle +275 -> 8368
    //   8096: iload 7
    //   8098: istore 8
    //   8100: aload 5
    //   8102: iconst_0
    //   8103: invokeinterface 191 2 0
    //   8108: checkcast 125	java/lang/String
    //   8111: astore 15
    //   8113: iload 7
    //   8115: istore 8
    //   8117: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8120: ifeq +87 -> 8207
    //   8123: iload 7
    //   8125: istore 8
    //   8127: new 77	java/lang/StringBuilder
    //   8130: dup
    //   8131: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   8134: astore 16
    //   8136: iload 7
    //   8138: istore 8
    //   8140: aload 16
    //   8142: ldc_w 4687
    //   8145: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8148: pop
    //   8149: iload 7
    //   8151: istore 8
    //   8153: aload 16
    //   8155: aload 15
    //   8157: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8160: pop
    //   8161: iload 7
    //   8163: istore 8
    //   8165: aload 16
    //   8167: ldc_w 472
    //   8170: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8173: pop
    //   8174: iload 7
    //   8176: istore 8
    //   8178: aload 16
    //   8180: aload 18
    //   8182: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8185: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8188: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8191: pop
    //   8192: iload 7
    //   8194: istore 8
    //   8196: ldc 91
    //   8198: iconst_2
    //   8199: aload 16
    //   8201: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8204: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8207: iload 7
    //   8209: istore 8
    //   8211: aload 15
    //   8213: invokestatic 4690	com/tencent/biz/bmqq/util/BmqqSegmentUtil:a	(Ljava/lang/String;)V
    //   8216: iload 7
    //   8218: istore 8
    //   8220: aload 5
    //   8222: invokeinterface 114 1 0
    //   8227: astore 5
    //   8229: iload 7
    //   8231: istore 8
    //   8233: aload 5
    //   8235: invokeinterface 119 1 0
    //   8240: ifeq +3979 -> 12219
    //   8243: iload 7
    //   8245: istore 8
    //   8247: aload 5
    //   8249: invokeinterface 123 1 0
    //   8254: checkcast 125	java/lang/String
    //   8257: astore 15
    //   8259: iload 7
    //   8261: istore 8
    //   8263: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8266: ifeq +87 -> 8353
    //   8269: iload 7
    //   8271: istore 8
    //   8273: new 77	java/lang/StringBuilder
    //   8276: dup
    //   8277: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   8280: astore 16
    //   8282: iload 7
    //   8284: istore 8
    //   8286: aload 16
    //   8288: ldc_w 4687
    //   8291: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8294: pop
    //   8295: iload 7
    //   8297: istore 8
    //   8299: aload 16
    //   8301: aload 15
    //   8303: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8306: pop
    //   8307: iload 7
    //   8309: istore 8
    //   8311: aload 16
    //   8313: ldc_w 472
    //   8316: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8319: pop
    //   8320: iload 7
    //   8322: istore 8
    //   8324: aload 16
    //   8326: aload 18
    //   8328: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8331: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8334: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8337: pop
    //   8338: iload 7
    //   8340: istore 8
    //   8342: ldc 91
    //   8344: iconst_2
    //   8345: aload 16
    //   8347: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8350: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8353: iload 7
    //   8355: istore 8
    //   8357: aload 15
    //   8359: invokestatic 4693	com/tencent/mobileqq/activity/aio/tips/C2BTipsBar:a	(Ljava/lang/String;)Z
    //   8362: ifeq -133 -> 8229
    //   8365: goto +3854 -> 12219
    //   8368: iload 7
    //   8370: istore 8
    //   8372: aconst_null
    //   8373: invokestatic 4690	com/tencent/biz/bmqq/util/BmqqSegmentUtil:a	(Ljava/lang/String;)V
    //   8376: iload 7
    //   8378: istore 8
    //   8380: invokestatic 4694	com/tencent/mobileqq/activity/aio/tips/C2BTipsBar:a	()V
    //   8383: iload 7
    //   8385: istore 8
    //   8387: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8390: ifeq +62 -> 8452
    //   8393: iload 7
    //   8395: istore 8
    //   8397: new 77	java/lang/StringBuilder
    //   8400: dup
    //   8401: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   8404: astore 5
    //   8406: iload 7
    //   8408: istore 8
    //   8410: aload 5
    //   8412: ldc_w 4696
    //   8415: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8418: pop
    //   8419: iload 7
    //   8421: istore 8
    //   8423: aload 5
    //   8425: aload 18
    //   8427: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8430: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8433: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8436: pop
    //   8437: iload 7
    //   8439: istore 8
    //   8441: ldc 91
    //   8443: iconst_2
    //   8444: aload 5
    //   8446: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8449: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8452: iload 7
    //   8454: istore 8
    //   8456: aload 18
    //   8458: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8461: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8464: istore 9
    //   8466: iload 7
    //   8468: istore 8
    //   8470: aload 17
    //   8472: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   8475: iload 9
    //   8477: invokestatic 4698	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;I)V
    //   8480: aload_1
    //   8481: astore 16
    //   8483: iload 13
    //   8485: istore 14
    //   8487: goto -8382 -> 105
    //   8490: iload 7
    //   8492: istore 8
    //   8494: aload_0
    //   8495: aload 17
    //   8497: aload 18
    //   8499: invokespecial 4700	com/tencent/mobileqq/config/splashlogo/ConfigServlet:at	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8502: aload_1
    //   8503: astore 16
    //   8505: iload 13
    //   8507: istore 14
    //   8509: goto -8404 -> 105
    //   8512: iload 7
    //   8514: istore 8
    //   8516: aload_0
    //   8517: aload 17
    //   8519: aload 18
    //   8521: invokespecial 4702	com/tencent/mobileqq/config/splashlogo/ConfigServlet:V	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8524: aload_1
    //   8525: astore 16
    //   8527: iload 13
    //   8529: istore 14
    //   8531: goto -8426 -> 105
    //   8534: iload 7
    //   8536: istore 8
    //   8538: aload_0
    //   8539: aload 17
    //   8541: aload 18
    //   8543: invokespecial 4704	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aq	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8546: aload_1
    //   8547: astore 16
    //   8549: iload 13
    //   8551: istore 14
    //   8553: goto -8448 -> 105
    //   8556: iload 7
    //   8558: istore 9
    //   8560: iload 9
    //   8562: istore 8
    //   8564: aload 17
    //   8566: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8569: aload 17
    //   8571: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8574: invokestatic 1221	com/tencent/mobileqq/utils/SharedPreUtils:j	(Landroid/content/Context;Ljava/lang/String;)I
    //   8577: istore 12
    //   8579: aload 18
    //   8581: ifnull +3641 -> 12222
    //   8584: iload 9
    //   8586: istore 8
    //   8588: aload 18
    //   8590: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8593: ifnull +3629 -> 12222
    //   8596: iload 9
    //   8598: istore 8
    //   8600: aload 18
    //   8602: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8605: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8608: istore 11
    //   8610: goto +3 -> 8613
    //   8613: iload 9
    //   8615: istore 8
    //   8617: aload 18
    //   8619: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8622: ifnull +289 -> 8911
    //   8625: iload 9
    //   8627: istore 8
    //   8629: aload 18
    //   8631: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8634: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8637: ifle +274 -> 8911
    //   8640: iload 9
    //   8642: istore 8
    //   8644: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8647: ifeq +147 -> 8794
    //   8650: iload 9
    //   8652: istore 8
    //   8654: new 77	java/lang/StringBuilder
    //   8657: dup
    //   8658: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   8661: astore 5
    //   8663: iload 9
    //   8665: istore 8
    //   8667: aload 5
    //   8669: ldc_w 4706
    //   8672: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8675: pop
    //   8676: iload 9
    //   8678: istore 8
    //   8680: aload 5
    //   8682: iload 11
    //   8684: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8687: pop
    //   8688: iload 9
    //   8690: istore 8
    //   8692: aload 5
    //   8694: ldc_w 4708
    //   8697: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8700: pop
    //   8701: iload 9
    //   8703: istore 8
    //   8705: aload 5
    //   8707: iload 12
    //   8709: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8712: pop
    //   8713: iload 9
    //   8715: istore 8
    //   8717: aload 5
    //   8719: ldc_w 4710
    //   8722: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8725: pop
    //   8726: iload 9
    //   8728: istore 8
    //   8730: aload 5
    //   8732: aload 18
    //   8734: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8737: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8740: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8743: pop
    //   8744: iload 9
    //   8746: istore 8
    //   8748: aload 5
    //   8750: ldc_w 4626
    //   8753: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8756: pop
    //   8757: iload 9
    //   8759: istore 8
    //   8761: aload 5
    //   8763: aload 18
    //   8765: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8768: iconst_0
    //   8769: invokevirtual 465	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8772: checkcast 125	java/lang/String
    //   8775: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8778: pop
    //   8779: iload 9
    //   8781: istore 8
    //   8783: ldc 91
    //   8785: iconst_2
    //   8786: aload 5
    //   8788: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8791: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8794: iload 9
    //   8796: istore 8
    //   8798: new 242	java/util/HashSet
    //   8801: dup
    //   8802: invokespecial 243	java/util/HashSet:<init>	()V
    //   8805: astore 5
    //   8807: iconst_0
    //   8808: istore 7
    //   8810: iload 9
    //   8812: istore 8
    //   8814: iload 7
    //   8816: aload 18
    //   8818: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8821: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8824: if_icmpge +34 -> 8858
    //   8827: iload 9
    //   8829: istore 8
    //   8831: aload 5
    //   8833: aload 18
    //   8835: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8838: iload 7
    //   8840: invokevirtual 465	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8843: invokeinterface 4711 2 0
    //   8848: pop
    //   8849: iload 7
    //   8851: iconst_1
    //   8852: iadd
    //   8853: istore 7
    //   8855: goto -45 -> 8810
    //   8858: iload 9
    //   8860: istore 8
    //   8862: aload 17
    //   8864: getstatic 4714	com/tencent/mobileqq/app/QQManagerFactory:SEND_BLESS_CONFIG_MANAGER	I
    //   8867: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8870: checkcast 4716	com/tencent/mobileqq/activity/bless/BlessManager
    //   8873: aload 5
    //   8875: invokevirtual 4719	com/tencent/mobileqq/activity/bless/BlessManager:a	(Ljava/util/Set;)V
    //   8878: iload 9
    //   8880: istore 8
    //   8882: aload 17
    //   8884: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   8887: aload 17
    //   8889: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   8892: iload 11
    //   8894: invokestatic 4720	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   8897: aload_1
    //   8898: astore 16
    //   8900: iload 13
    //   8902: istore 14
    //   8904: iload 9
    //   8906: istore 7
    //   8908: goto -8803 -> 105
    //   8911: iload 9
    //   8913: istore 8
    //   8915: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8918: ifeq +81 -> 8999
    //   8921: iload 9
    //   8923: istore 8
    //   8925: new 77	java/lang/StringBuilder
    //   8928: dup
    //   8929: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   8932: astore 5
    //   8934: iload 9
    //   8936: istore 8
    //   8938: aload 5
    //   8940: ldc_w 4722
    //   8943: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8946: pop
    //   8947: iload 9
    //   8949: istore 8
    //   8951: aload 5
    //   8953: iload 11
    //   8955: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8958: pop
    //   8959: iload 9
    //   8961: istore 8
    //   8963: aload 5
    //   8965: ldc_w 4708
    //   8968: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8971: pop
    //   8972: iload 9
    //   8974: istore 8
    //   8976: aload 5
    //   8978: iload 12
    //   8980: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8983: pop
    //   8984: iload 9
    //   8986: istore 8
    //   8988: ldc 91
    //   8990: iconst_2
    //   8991: aload 5
    //   8993: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8996: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8999: aload_1
    //   9000: astore 16
    //   9002: iload 13
    //   9004: istore 14
    //   9006: iload 9
    //   9008: istore 7
    //   9010: iload 12
    //   9012: iload 11
    //   9014: if_icmpeq -8909 -> 105
    //   9017: iload 9
    //   9019: istore 8
    //   9021: aload 17
    //   9023: getstatic 4714	com/tencent/mobileqq/app/QQManagerFactory:SEND_BLESS_CONFIG_MANAGER	I
    //   9026: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9029: checkcast 4716	com/tencent/mobileqq/activity/bless/BlessManager
    //   9032: invokevirtual 4723	com/tencent/mobileqq/activity/bless/BlessManager:a	()V
    //   9035: iload 9
    //   9037: istore 8
    //   9039: aload 17
    //   9041: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9044: aload 17
    //   9046: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   9049: iload 11
    //   9051: invokestatic 4720	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9054: aload_1
    //   9055: astore 16
    //   9057: iload 13
    //   9059: istore 14
    //   9061: iload 9
    //   9063: istore 7
    //   9065: goto -8960 -> 105
    //   9068: iload 7
    //   9070: istore 9
    //   9072: iload 9
    //   9074: istore 8
    //   9076: aload 18
    //   9078: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9081: ifnull +221 -> 9302
    //   9084: iload 9
    //   9086: istore 8
    //   9088: aload 18
    //   9090: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9093: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   9096: ifle +206 -> 9302
    //   9099: iload 9
    //   9101: istore 8
    //   9103: aload 17
    //   9105: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9108: aload 18
    //   9110: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9113: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9116: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9119: invokestatic 4725	com/tencent/mobileqq/utils/SharedPreUtils:c	(Landroid/content/Context;ILjava/lang/String;)V
    //   9122: iconst_0
    //   9123: istore 11
    //   9125: aload_1
    //   9126: astore 16
    //   9128: iload 13
    //   9130: istore 14
    //   9132: iload 9
    //   9134: istore 7
    //   9136: iload 9
    //   9138: istore 8
    //   9140: iload 11
    //   9142: aload 18
    //   9144: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9147: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   9150: if_icmpge -9045 -> 105
    //   9153: iload 9
    //   9155: istore 8
    //   9157: aload 18
    //   9159: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9162: iload 11
    //   9164: invokevirtual 465	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   9167: checkcast 125	java/lang/String
    //   9170: astore 5
    //   9172: iload 9
    //   9174: istore 8
    //   9176: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9179: ifeq +87 -> 9266
    //   9182: iload 9
    //   9184: istore 8
    //   9186: new 77	java/lang/StringBuilder
    //   9189: dup
    //   9190: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   9193: astore 15
    //   9195: iload 9
    //   9197: istore 8
    //   9199: aload 15
    //   9201: ldc_w 4727
    //   9204: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9207: pop
    //   9208: iload 9
    //   9210: istore 8
    //   9212: aload 15
    //   9214: aload 5
    //   9216: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9219: pop
    //   9220: iload 9
    //   9222: istore 8
    //   9224: aload 15
    //   9226: ldc_w 472
    //   9229: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9232: pop
    //   9233: iload 9
    //   9235: istore 8
    //   9237: aload 15
    //   9239: aload 18
    //   9241: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9244: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9247: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9250: pop
    //   9251: iload 9
    //   9253: istore 8
    //   9255: ldc 91
    //   9257: iconst_2
    //   9258: aload 15
    //   9260: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9263: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9266: iload 9
    //   9268: istore 8
    //   9270: aload 5
    //   9272: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9275: ifne +2954 -> 12229
    //   9278: iload 9
    //   9280: istore 8
    //   9282: aload 17
    //   9284: getstatic 4649	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	Ljava/lang/String;
    //   9287: invokevirtual 1336	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   9290: checkcast 4651	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   9293: aload 5
    //   9295: iconst_0
    //   9296: invokevirtual 4729	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(Ljava/lang/String;Z)V
    //   9299: goto +2930 -> 12229
    //   9302: aload_1
    //   9303: astore 16
    //   9305: iload 13
    //   9307: istore 14
    //   9309: iload 9
    //   9311: istore 7
    //   9313: iload 9
    //   9315: istore 8
    //   9317: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9320: ifeq -9215 -> 105
    //   9323: iload 9
    //   9325: istore 8
    //   9327: new 77	java/lang/StringBuilder
    //   9330: dup
    //   9331: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   9334: astore 5
    //   9336: iload 9
    //   9338: istore 8
    //   9340: aload 5
    //   9342: ldc_w 4731
    //   9345: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9348: pop
    //   9349: iload 9
    //   9351: istore 8
    //   9353: aload 5
    //   9355: aload 18
    //   9357: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9360: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9363: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9366: pop
    //   9367: iload 9
    //   9369: istore 8
    //   9371: ldc 91
    //   9373: iconst_2
    //   9374: aload 5
    //   9376: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9379: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9382: aload_1
    //   9383: astore 16
    //   9385: iload 13
    //   9387: istore 14
    //   9389: iload 9
    //   9391: istore 7
    //   9393: goto -9288 -> 105
    //   9396: iload 7
    //   9398: istore 8
    //   9400: aload_0
    //   9401: aload 17
    //   9403: aload 18
    //   9405: invokespecial 4733	com/tencent/mobileqq/config/splashlogo/ConfigServlet:am	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9408: aload_1
    //   9409: astore 16
    //   9411: iload 13
    //   9413: istore 14
    //   9415: goto -9310 -> 105
    //   9418: iload 7
    //   9420: istore 8
    //   9422: invokestatic 61	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9425: aload 17
    //   9427: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   9430: invokestatic 1870	cooperation/pluginbridge/BridgeHelper:a	(Landroid/content/Context;Ljava/lang/String;)Lcooperation/pluginbridge/BridgeHelper;
    //   9433: aload 18
    //   9435: invokevirtual 4734	cooperation/pluginbridge/BridgeHelper:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9438: aload_1
    //   9439: astore 16
    //   9441: iload 13
    //   9443: istore 14
    //   9445: goto -9340 -> 105
    //   9448: iload 7
    //   9450: istore 8
    //   9452: aload 17
    //   9454: getstatic 1875	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_BANNER_MANAGER	I
    //   9457: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9460: checkcast 1877	com/tencent/mobileqq/config/struct/NearbyBannerManager
    //   9463: astore 15
    //   9465: iload 7
    //   9467: istore 8
    //   9469: aload 15
    //   9471: invokevirtual 4737	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	()Ljava/util/Set;
    //   9474: astore 19
    //   9476: iload 7
    //   9478: istore 8
    //   9480: new 2209	com/tencent/mobileqq/config/struct/PicAndAdConf
    //   9483: dup
    //   9484: bipush 21
    //   9486: iconst_2
    //   9487: invokespecial 4740	com/tencent/mobileqq/config/struct/PicAndAdConf:<init>	(SB)V
    //   9490: astore 16
    //   9492: iload 7
    //   9494: istore 8
    //   9496: aload 18
    //   9498: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9501: ifnull +200 -> 9701
    //   9504: iload 7
    //   9506: istore 8
    //   9508: aload 18
    //   9510: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9513: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   9516: ifle +185 -> 9701
    //   9519: iload 7
    //   9521: istore 8
    //   9523: aload 18
    //   9525: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9528: invokevirtual 1046	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   9531: invokeinterface 114 1 0
    //   9536: astore 5
    //   9538: iload 7
    //   9540: istore 8
    //   9542: aload 5
    //   9544: invokeinterface 119 1 0
    //   9549: ifeq +221 -> 9770
    //   9552: iload 7
    //   9554: istore 8
    //   9556: aload 5
    //   9558: invokeinterface 123 1 0
    //   9563: checkcast 125	java/lang/String
    //   9566: astore 20
    //   9568: iload 7
    //   9570: istore 8
    //   9572: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9575: ifeq +2663 -> 12238
    //   9578: iload 7
    //   9580: istore 8
    //   9582: new 77	java/lang/StringBuilder
    //   9585: dup
    //   9586: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   9589: astore 21
    //   9591: iload 7
    //   9593: istore 8
    //   9595: aload 21
    //   9597: ldc_w 4742
    //   9600: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9603: pop
    //   9604: iload 7
    //   9606: istore 8
    //   9608: aload 21
    //   9610: aload 20
    //   9612: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9615: pop
    //   9616: iload 7
    //   9618: istore 8
    //   9620: aload 21
    //   9622: ldc_w 472
    //   9625: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9628: pop
    //   9629: iload 7
    //   9631: istore 8
    //   9633: aload 21
    //   9635: aload 18
    //   9637: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9640: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9643: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9646: pop
    //   9647: iload 7
    //   9649: istore 8
    //   9651: ldc 91
    //   9653: iconst_2
    //   9654: aload 21
    //   9656: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9659: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9662: goto +3 -> 9665
    //   9665: iload 7
    //   9667: istore 8
    //   9669: aload 16
    //   9671: aload 20
    //   9673: aload 19
    //   9675: invokestatic 4744	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/config/struct/PicAndAdConf;Ljava/lang/String;Ljava/util/Set;)Z
    //   9678: pop
    //   9679: iload 7
    //   9681: istore 8
    //   9683: aload 15
    //   9685: aload 16
    //   9687: aload 18
    //   9689: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9692: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9695: invokevirtual 4747	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(Lcom/tencent/mobileqq/config/struct/PicAndAdConf;I)V
    //   9698: goto -160 -> 9538
    //   9701: iload 7
    //   9703: istore 8
    //   9705: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9708: ifeq +62 -> 9770
    //   9711: iload 7
    //   9713: istore 8
    //   9715: new 77	java/lang/StringBuilder
    //   9718: dup
    //   9719: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   9722: astore 5
    //   9724: iload 7
    //   9726: istore 8
    //   9728: aload 5
    //   9730: ldc_w 4749
    //   9733: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9736: pop
    //   9737: iload 7
    //   9739: istore 8
    //   9741: aload 5
    //   9743: aload 18
    //   9745: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9748: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9751: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9754: pop
    //   9755: iload 7
    //   9757: istore 8
    //   9759: ldc 91
    //   9761: iconst_2
    //   9762: aload 5
    //   9764: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9767: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9770: iload 7
    //   9772: istore 8
    //   9774: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9777: ifeq +152 -> 9929
    //   9780: iload 7
    //   9782: istore 8
    //   9784: new 77	java/lang/StringBuilder
    //   9787: dup
    //   9788: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   9791: astore 5
    //   9793: iload 7
    //   9795: istore 8
    //   9797: aload 5
    //   9799: ldc_w 4751
    //   9802: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9805: pop
    //   9806: iload 7
    //   9808: istore 8
    //   9810: aload 18
    //   9812: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9815: ifnonnull +9 -> 9824
    //   9818: iconst_0
    //   9819: istore 9
    //   9821: goto +22 -> 9843
    //   9824: iload 7
    //   9826: istore 8
    //   9828: aload 18
    //   9830: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9833: invokevirtual 1046	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   9836: invokeinterface 110 1 0
    //   9841: istore 9
    //   9843: iload 7
    //   9845: istore 8
    //   9847: aload 5
    //   9849: iload 9
    //   9851: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9854: pop
    //   9855: iload 7
    //   9857: istore 8
    //   9859: aload 5
    //   9861: ldc_w 4753
    //   9864: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9867: pop
    //   9868: iload 7
    //   9870: istore 8
    //   9872: aload 5
    //   9874: aload 16
    //   9876: invokevirtual 4754	com/tencent/mobileqq/config/struct/PicAndAdConf:a	()I
    //   9879: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9882: pop
    //   9883: iload 7
    //   9885: istore 8
    //   9887: aload 5
    //   9889: ldc_w 4756
    //   9892: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9895: pop
    //   9896: iload 7
    //   9898: istore 8
    //   9900: aload 5
    //   9902: aload 18
    //   9904: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9907: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9910: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9913: pop
    //   9914: iload 7
    //   9916: istore 8
    //   9918: ldc 91
    //   9920: iconst_2
    //   9921: aload 5
    //   9923: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9926: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9929: iload 7
    //   9931: istore 8
    //   9933: aload 15
    //   9935: aload 18
    //   9937: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9940: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9943: invokevirtual 4757	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(I)V
    //   9946: aload_1
    //   9947: astore 16
    //   9949: iload 13
    //   9951: istore 14
    //   9953: goto -9848 -> 105
    //   9956: iload 7
    //   9958: istore 8
    //   9960: ldc_w 1880
    //   9963: invokestatic 496	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   9966: checkcast 1880	com/tencent/mobileqq/dpc/api/IDPCApi
    //   9969: aload_2
    //   9970: ldc 8
    //   9972: invokeinterface 4761 3 0
    //   9977: pop
    //   9978: aload_1
    //   9979: astore 16
    //   9981: iload 13
    //   9983: istore 14
    //   9985: goto -9880 -> 105
    //   9988: iload 7
    //   9990: istore 9
    //   9992: iload 9
    //   9994: istore 8
    //   9996: aload 18
    //   9998: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10001: ifnull +251 -> 10252
    //   10004: iload 9
    //   10006: istore 8
    //   10008: aload 18
    //   10010: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10013: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   10016: ifle +236 -> 10252
    //   10019: iload 9
    //   10021: istore 8
    //   10023: new 1022	java/util/ArrayList
    //   10026: dup
    //   10027: invokespecial 1023	java/util/ArrayList:<init>	()V
    //   10030: astore 5
    //   10032: iconst_0
    //   10033: istore 7
    //   10035: iload 9
    //   10037: istore 8
    //   10039: iload 7
    //   10041: aload 18
    //   10043: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10046: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   10049: if_icmpge +148 -> 10197
    //   10052: iload 9
    //   10054: istore 8
    //   10056: aload 18
    //   10058: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10061: iload 7
    //   10063: invokevirtual 465	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   10066: checkcast 125	java/lang/String
    //   10069: astore 15
    //   10071: iload 9
    //   10073: istore 8
    //   10075: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10078: ifeq +87 -> 10165
    //   10081: iload 9
    //   10083: istore 8
    //   10085: new 77	java/lang/StringBuilder
    //   10088: dup
    //   10089: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   10092: astore 16
    //   10094: iload 9
    //   10096: istore 8
    //   10098: aload 16
    //   10100: ldc_w 4763
    //   10103: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10106: pop
    //   10107: iload 9
    //   10109: istore 8
    //   10111: aload 16
    //   10113: aload 15
    //   10115: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10118: pop
    //   10119: iload 9
    //   10121: istore 8
    //   10123: aload 16
    //   10125: ldc_w 472
    //   10128: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10131: pop
    //   10132: iload 9
    //   10134: istore 8
    //   10136: aload 16
    //   10138: aload 18
    //   10140: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10143: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10146: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10149: pop
    //   10150: iload 9
    //   10152: istore 8
    //   10154: ldc 91
    //   10156: iconst_2
    //   10157: aload 16
    //   10159: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10162: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10165: iload 9
    //   10167: istore 8
    //   10169: aload_0
    //   10170: aload 15
    //   10172: invokespecial 4765	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/config/operation/QQOperationViopTipTask;
    //   10175: astore 15
    //   10177: aload 15
    //   10179: ifnull +2062 -> 12241
    //   10182: iload 9
    //   10184: istore 8
    //   10186: aload 5
    //   10188: aload 15
    //   10190: invokevirtual 1058	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   10193: pop
    //   10194: goto +2047 -> 12241
    //   10197: iload 9
    //   10199: istore 8
    //   10201: aload 17
    //   10203: invokestatic 4770	com/tencent/mobileqq/config/operation/QQOperateManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/config/operation/QQOperateManager;
    //   10206: aload 17
    //   10208: aload 5
    //   10210: invokevirtual 4773	com/tencent/mobileqq/config/operation/QQOperateManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/ArrayList;)V
    //   10213: iload 9
    //   10215: istore 8
    //   10217: aload 17
    //   10219: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   10222: aload 17
    //   10224: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   10227: aload 18
    //   10229: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10232: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10235: invokestatic 4774	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   10238: aload_1
    //   10239: astore 16
    //   10241: iload 13
    //   10243: istore 14
    //   10245: iload 9
    //   10247: istore 7
    //   10249: goto -10144 -> 105
    //   10252: aload_1
    //   10253: astore 16
    //   10255: iload 13
    //   10257: istore 14
    //   10259: iload 9
    //   10261: istore 7
    //   10263: iload 9
    //   10265: istore 8
    //   10267: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10270: ifeq -10165 -> 105
    //   10273: iload 9
    //   10275: istore 8
    //   10277: new 77	java/lang/StringBuilder
    //   10280: dup
    //   10281: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   10284: astore 5
    //   10286: iload 9
    //   10288: istore 8
    //   10290: aload 5
    //   10292: ldc_w 4776
    //   10295: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10298: pop
    //   10299: iload 9
    //   10301: istore 8
    //   10303: aload 5
    //   10305: aload 18
    //   10307: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10310: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10313: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10316: pop
    //   10317: iload 9
    //   10319: istore 8
    //   10321: ldc 91
    //   10323: iconst_2
    //   10324: aload 5
    //   10326: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10329: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10332: aload_1
    //   10333: astore 16
    //   10335: iload 13
    //   10337: istore 14
    //   10339: iload 9
    //   10341: istore 7
    //   10343: goto -10238 -> 105
    //   10346: iload 7
    //   10348: istore 8
    //   10350: aload 18
    //   10352: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10355: ifnull +160 -> 10515
    //   10358: iload 7
    //   10360: istore 8
    //   10362: aload 18
    //   10364: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10367: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   10370: ifle +145 -> 10515
    //   10373: iload 7
    //   10375: istore 8
    //   10377: aload 18
    //   10379: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10382: iconst_0
    //   10383: invokevirtual 465	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   10386: checkcast 125	java/lang/String
    //   10389: astore 5
    //   10391: iload 7
    //   10393: istore 8
    //   10395: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10398: ifeq +87 -> 10485
    //   10401: iload 7
    //   10403: istore 8
    //   10405: new 77	java/lang/StringBuilder
    //   10408: dup
    //   10409: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   10412: astore 15
    //   10414: iload 7
    //   10416: istore 8
    //   10418: aload 15
    //   10420: ldc_w 4778
    //   10423: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10426: pop
    //   10427: iload 7
    //   10429: istore 8
    //   10431: aload 15
    //   10433: aload 5
    //   10435: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10438: pop
    //   10439: iload 7
    //   10441: istore 8
    //   10443: aload 15
    //   10445: ldc_w 472
    //   10448: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10451: pop
    //   10452: iload 7
    //   10454: istore 8
    //   10456: aload 15
    //   10458: aload 18
    //   10460: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10463: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10466: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10469: pop
    //   10470: iload 7
    //   10472: istore 8
    //   10474: ldc 91
    //   10476: iconst_2
    //   10477: aload 15
    //   10479: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10482: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10485: iload 7
    //   10487: istore 8
    //   10489: aload_0
    //   10490: aload 17
    //   10492: aload 5
    //   10494: aload 18
    //   10496: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10499: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10502: invokespecial 4780	com/tencent/mobileqq/config/splashlogo/ConfigServlet:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   10505: aload_1
    //   10506: astore 16
    //   10508: iload 13
    //   10510: istore 14
    //   10512: goto -10407 -> 105
    //   10515: iload 7
    //   10517: istore 8
    //   10519: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10522: ifeq +62 -> 10584
    //   10525: iload 7
    //   10527: istore 8
    //   10529: new 77	java/lang/StringBuilder
    //   10532: dup
    //   10533: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   10536: astore 5
    //   10538: iload 7
    //   10540: istore 8
    //   10542: aload 5
    //   10544: ldc_w 4782
    //   10547: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10550: pop
    //   10551: iload 7
    //   10553: istore 8
    //   10555: aload 5
    //   10557: aload 18
    //   10559: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10562: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10565: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10568: pop
    //   10569: iload 7
    //   10571: istore 8
    //   10573: ldc 91
    //   10575: iconst_2
    //   10576: aload 5
    //   10578: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10581: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10584: iload 7
    //   10586: istore 8
    //   10588: new 77	java/lang/StringBuilder
    //   10591: dup
    //   10592: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   10595: astore 5
    //   10597: iload 7
    //   10599: istore 8
    //   10601: aload 5
    //   10603: aload 17
    //   10605: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   10608: invokevirtual 3591	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   10611: invokevirtual 2201	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10614: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10617: pop
    //   10618: iload 7
    //   10620: istore 8
    //   10622: aload 5
    //   10624: ldc_w 2203
    //   10627: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10630: pop
    //   10631: iload 7
    //   10633: istore 8
    //   10635: aload 5
    //   10637: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10640: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10643: pop
    //   10644: iload 7
    //   10646: istore 8
    //   10648: aload 5
    //   10650: ldc_w 2203
    //   10653: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10656: pop
    //   10657: iload 7
    //   10659: istore 8
    //   10661: aload 5
    //   10663: ldc_w 3593
    //   10666: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10669: pop
    //   10670: iload 7
    //   10672: istore 8
    //   10674: new 2198	java/io/File
    //   10677: dup
    //   10678: aload 5
    //   10680: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10683: invokespecial 3635	java/io/File:<init>	(Ljava/lang/String;)V
    //   10686: astore 5
    //   10688: iload 7
    //   10690: istore 8
    //   10692: aload 5
    //   10694: invokevirtual 3638	java/io/File:exists	()Z
    //   10697: ifeq +13 -> 10710
    //   10700: iload 7
    //   10702: istore 8
    //   10704: aload 5
    //   10706: invokevirtual 3641	java/io/File:delete	()Z
    //   10709: pop
    //   10710: iload 7
    //   10712: istore 8
    //   10714: aload 17
    //   10716: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   10719: aload 18
    //   10721: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10724: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10727: ldc 8
    //   10729: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10732: invokestatic 4784	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   10735: aload_1
    //   10736: astore 16
    //   10738: iload 13
    //   10740: istore 14
    //   10742: goto -10637 -> 105
    //   10745: astore 5
    //   10747: iload 8
    //   10749: istore 7
    //   10751: goto +1419 -> 12170
    //   10754: iload 7
    //   10756: istore 9
    //   10758: aload 18
    //   10760: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10763: astore 5
    //   10765: aload 5
    //   10767: ifnull +520 -> 11287
    //   10770: iload 9
    //   10772: istore 8
    //   10774: aload 18
    //   10776: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10779: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   10782: ifle +505 -> 11287
    //   10785: iload 9
    //   10787: istore 8
    //   10789: getstatic 3489	com/tencent/mobileqq/config/Config:a	Lcom/tencent/mobileqq/config/struct/PicAndAdConf;
    //   10792: invokevirtual 4785	com/tencent/mobileqq/config/struct/PicAndAdConf:b	()V
    //   10795: iload 9
    //   10797: istore 8
    //   10799: aload 18
    //   10801: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10804: invokevirtual 1046	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   10807: invokeinterface 114 1 0
    //   10812: astore 5
    //   10814: iload 9
    //   10816: istore 8
    //   10818: aload 5
    //   10820: invokeinterface 119 1 0
    //   10825: ifeq +136 -> 10961
    //   10828: iload 9
    //   10830: istore 8
    //   10832: aload 5
    //   10834: invokeinterface 123 1 0
    //   10839: checkcast 125	java/lang/String
    //   10842: astore 15
    //   10844: iload 9
    //   10846: istore 8
    //   10848: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10851: ifeq +87 -> 10938
    //   10854: iload 9
    //   10856: istore 8
    //   10858: new 77	java/lang/StringBuilder
    //   10861: dup
    //   10862: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   10865: astore 16
    //   10867: iload 9
    //   10869: istore 8
    //   10871: aload 16
    //   10873: ldc_w 4787
    //   10876: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10879: pop
    //   10880: iload 9
    //   10882: istore 8
    //   10884: aload 16
    //   10886: aload 15
    //   10888: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10891: pop
    //   10892: iload 9
    //   10894: istore 8
    //   10896: aload 16
    //   10898: ldc_w 472
    //   10901: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10904: pop
    //   10905: iload 9
    //   10907: istore 8
    //   10909: aload 16
    //   10911: aload 18
    //   10913: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10916: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10919: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10922: pop
    //   10923: iload 9
    //   10925: istore 8
    //   10927: ldc 91
    //   10929: iconst_2
    //   10930: aload 16
    //   10932: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10935: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10938: iload 9
    //   10940: istore 8
    //   10942: aload_0
    //   10943: aload 17
    //   10945: aload 15
    //   10947: aload 18
    //   10949: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10952: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10955: invokespecial 4789	com/tencent/mobileqq/config/splashlogo/ConfigServlet:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   10958: goto -144 -> 10814
    //   10961: iload 9
    //   10963: istore 8
    //   10965: new 4791	com/tencent/mobileqq/config/ConfigManager
    //   10968: dup
    //   10969: aload 17
    //   10971: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   10974: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10977: invokespecial 4793	com/tencent/mobileqq/config/ConfigManager:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   10980: astore 5
    //   10982: iload 9
    //   10984: istore 8
    //   10986: aload 5
    //   10988: invokevirtual 4794	com/tencent/mobileqq/config/ConfigManager:b	()V
    //   10991: iload 9
    //   10993: istore 8
    //   10995: aload 5
    //   10997: invokevirtual 4795	com/tencent/mobileqq/config/ConfigManager:c	()V
    //   11000: iload 9
    //   11002: istore 8
    //   11004: invokestatic 61	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11007: ldc_w 4797
    //   11010: iconst_0
    //   11011: invokevirtual 653	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   11014: astore 5
    //   11016: iload 9
    //   11018: istore 8
    //   11020: aload 5
    //   11022: invokeinterface 659 1 0
    //   11027: astore 15
    //   11029: iload 9
    //   11031: istore 8
    //   11033: new 77	java/lang/StringBuilder
    //   11036: dup
    //   11037: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   11040: astore 16
    //   11042: iload 9
    //   11044: istore 8
    //   11046: aload 16
    //   11048: ldc_w 4799
    //   11051: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11054: pop
    //   11055: iload 9
    //   11057: istore 8
    //   11059: aload 16
    //   11061: aload 17
    //   11063: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   11066: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11069: pop
    //   11070: iload 9
    //   11072: istore 8
    //   11074: aload 15
    //   11076: aload 16
    //   11078: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11081: iconst_1
    //   11082: invokeinterface 2549 3 0
    //   11087: invokeinterface 670 1 0
    //   11092: pop
    //   11093: iload 9
    //   11095: istore 8
    //   11097: aload 5
    //   11099: invokeinterface 659 1 0
    //   11104: astore 5
    //   11106: iload 9
    //   11108: istore 8
    //   11110: new 77	java/lang/StringBuilder
    //   11113: dup
    //   11114: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   11117: astore 15
    //   11119: iload 9
    //   11121: istore 8
    //   11123: aload 15
    //   11125: ldc_w 4801
    //   11128: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11131: pop
    //   11132: iload 9
    //   11134: istore 8
    //   11136: aload 15
    //   11138: aload 17
    //   11140: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   11143: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11146: pop
    //   11147: iload 9
    //   11149: istore 8
    //   11151: aload 5
    //   11153: aload 15
    //   11155: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11158: iconst_1
    //   11159: invokeinterface 2549 3 0
    //   11164: invokeinterface 670 1 0
    //   11169: pop
    //   11170: iload 9
    //   11172: istore 8
    //   11174: aload 17
    //   11176: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11179: aload 18
    //   11181: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11184: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11187: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11190: invokestatic 4238	com/tencent/mobileqq/utils/SharedPreUtils:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   11193: aload_1
    //   11194: astore 16
    //   11196: iload 13
    //   11198: istore 14
    //   11200: iload 9
    //   11202: istore 7
    //   11204: iload 9
    //   11206: istore 8
    //   11208: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11211: ifeq -11106 -> 105
    //   11214: iload 9
    //   11216: istore 8
    //   11218: new 77	java/lang/StringBuilder
    //   11221: dup
    //   11222: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   11225: astore 5
    //   11227: iload 9
    //   11229: istore 8
    //   11231: aload 5
    //   11233: ldc_w 4803
    //   11236: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11239: pop
    //   11240: iload 9
    //   11242: istore 8
    //   11244: aload 5
    //   11246: aload 18
    //   11248: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11251: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11254: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11257: pop
    //   11258: iload 9
    //   11260: istore 8
    //   11262: ldc 91
    //   11264: iconst_2
    //   11265: aload 5
    //   11267: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11270: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   11273: aload_1
    //   11274: astore 16
    //   11276: iload 13
    //   11278: istore 14
    //   11280: iload 9
    //   11282: istore 7
    //   11284: goto -11179 -> 105
    //   11287: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11290: istore 14
    //   11292: iload 14
    //   11294: ifeq +62 -> 11356
    //   11297: iload 9
    //   11299: istore 8
    //   11301: new 77	java/lang/StringBuilder
    //   11304: dup
    //   11305: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   11308: astore 5
    //   11310: iload 9
    //   11312: istore 8
    //   11314: aload 5
    //   11316: ldc_w 4805
    //   11319: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11322: pop
    //   11323: iload 9
    //   11325: istore 8
    //   11327: aload 5
    //   11329: aload 18
    //   11331: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11334: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11337: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11340: pop
    //   11341: iload 9
    //   11343: istore 8
    //   11345: ldc 91
    //   11347: iconst_2
    //   11348: aload 5
    //   11350: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11353: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11356: getstatic 3489	com/tencent/mobileqq/config/Config:a	Lcom/tencent/mobileqq/config/struct/PicAndAdConf;
    //   11359: invokevirtual 4785	com/tencent/mobileqq/config/struct/PicAndAdConf:b	()V
    //   11362: getstatic 3489	com/tencent/mobileqq/config/Config:a	Lcom/tencent/mobileqq/config/struct/PicAndAdConf;
    //   11365: invokevirtual 4806	com/tencent/mobileqq/config/struct/PicAndAdConf:c	()V
    //   11368: new 4791	com/tencent/mobileqq/config/ConfigManager
    //   11371: dup
    //   11372: aload 17
    //   11374: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11377: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11380: invokespecial 4793	com/tencent/mobileqq/config/ConfigManager:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   11383: astore 5
    //   11385: aload 5
    //   11387: invokevirtual 4794	com/tencent/mobileqq/config/ConfigManager:b	()V
    //   11390: aload 5
    //   11392: invokevirtual 4795	com/tencent/mobileqq/config/ConfigManager:c	()V
    //   11395: invokestatic 61	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11398: ldc_w 4797
    //   11401: iconst_0
    //   11402: invokevirtual 653	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   11405: invokeinterface 659 1 0
    //   11410: astore 5
    //   11412: new 77	java/lang/StringBuilder
    //   11415: dup
    //   11416: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   11419: astore 15
    //   11421: aload 15
    //   11423: ldc_w 4801
    //   11426: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11429: pop
    //   11430: aload 15
    //   11432: aload 17
    //   11434: invokevirtual 1193	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   11437: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11440: pop
    //   11441: aload 15
    //   11443: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11446: astore 15
    //   11448: aload 5
    //   11450: aload 15
    //   11452: iconst_0
    //   11453: invokeinterface 2549 3 0
    //   11458: invokeinterface 670 1 0
    //   11463: pop
    //   11464: aload 17
    //   11466: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11469: aload 18
    //   11471: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11474: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11477: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11480: invokestatic 4238	com/tencent/mobileqq/utils/SharedPreUtils:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   11483: aload_1
    //   11484: astore 16
    //   11486: iload 13
    //   11488: istore 14
    //   11490: iload 9
    //   11492: istore 8
    //   11494: goto +547 -> 12041
    //   11497: iload 7
    //   11499: istore 9
    //   11501: aload 18
    //   11503: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   11506: ifnull +321 -> 11827
    //   11509: aload 18
    //   11511: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   11514: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   11517: ifle +310 -> 11827
    //   11520: new 77	java/lang/StringBuilder
    //   11523: dup
    //   11524: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   11527: astore 5
    //   11529: aload 5
    //   11531: aload 17
    //   11533: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11536: invokevirtual 3591	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   11539: invokevirtual 2201	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11542: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11545: pop
    //   11546: aload 5
    //   11548: ldc_w 3634
    //   11551: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11554: pop
    //   11555: new 2198	java/io/File
    //   11558: dup
    //   11559: aload 5
    //   11561: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11564: invokespecial 3635	java/io/File:<init>	(Ljava/lang/String;)V
    //   11567: astore 5
    //   11569: aload 5
    //   11571: invokevirtual 3638	java/io/File:exists	()Z
    //   11574: ifne +12 -> 11586
    //   11577: aload 5
    //   11579: invokevirtual 4809	java/io/File:mkdirs	()Z
    //   11582: pop
    //   11583: goto +62 -> 11645
    //   11586: aload 5
    //   11588: invokevirtual 4812	java/io/File:isDirectory	()Z
    //   11591: ifeq +54 -> 11645
    //   11594: aload 5
    //   11596: invokevirtual 4816	java/io/File:listFiles	()[Ljava/io/File;
    //   11599: astore 5
    //   11601: aload 5
    //   11603: arraylength
    //   11604: istore 11
    //   11606: iconst_0
    //   11607: istore 8
    //   11609: iload 8
    //   11611: iload 11
    //   11613: if_icmpge +32 -> 11645
    //   11616: aload 5
    //   11618: iload 8
    //   11620: aaload
    //   11621: astore 15
    //   11623: aload 15
    //   11625: ifnull +630 -> 12255
    //   11628: aload 15
    //   11630: invokevirtual 3638	java/io/File:exists	()Z
    //   11633: ifeq +622 -> 12255
    //   11636: aload 15
    //   11638: invokevirtual 3641	java/io/File:delete	()Z
    //   11641: pop
    //   11642: goto +613 -> 12255
    //   11645: aload 18
    //   11647: getfield 461	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   11650: invokevirtual 1046	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   11653: invokeinterface 114 1 0
    //   11658: astore 5
    //   11660: aload_1
    //   11661: astore 16
    //   11663: iload 13
    //   11665: istore 14
    //   11667: iload 9
    //   11669: istore 8
    //   11671: aload 5
    //   11673: invokeinterface 119 1 0
    //   11678: ifeq +363 -> 12041
    //   11681: aload 5
    //   11683: invokeinterface 123 1 0
    //   11688: checkcast 125	java/lang/String
    //   11691: astore 15
    //   11693: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11696: ifeq +63 -> 11759
    //   11699: new 77	java/lang/StringBuilder
    //   11702: dup
    //   11703: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   11706: astore 16
    //   11708: aload 16
    //   11710: ldc_w 4818
    //   11713: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11716: pop
    //   11717: aload 16
    //   11719: aload 15
    //   11721: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11724: pop
    //   11725: aload 16
    //   11727: ldc_w 472
    //   11730: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11733: pop
    //   11734: aload 16
    //   11736: aload 18
    //   11738: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11741: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11744: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11747: pop
    //   11748: ldc 91
    //   11750: iconst_2
    //   11751: aload 16
    //   11753: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11756: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11759: aload_0
    //   11760: aload 17
    //   11762: aload 15
    //   11764: aload 18
    //   11766: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11769: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11772: invokespecial 4820	com/tencent/mobileqq/config/splashlogo/ConfigServlet:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   11775: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11778: ifeq -118 -> 11660
    //   11781: new 77	java/lang/StringBuilder
    //   11784: dup
    //   11785: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   11788: astore 15
    //   11790: aload 15
    //   11792: ldc_w 4822
    //   11795: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11798: pop
    //   11799: aload 15
    //   11801: aload 18
    //   11803: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11806: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11809: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11812: pop
    //   11813: ldc 91
    //   11815: iconst_2
    //   11816: aload 15
    //   11818: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11821: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   11824: goto -164 -> 11660
    //   11827: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11830: ifeq +46 -> 11876
    //   11833: new 77	java/lang/StringBuilder
    //   11836: dup
    //   11837: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   11840: astore 5
    //   11842: aload 5
    //   11844: ldc_w 4824
    //   11847: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11850: pop
    //   11851: aload 5
    //   11853: aload 18
    //   11855: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11858: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11861: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11864: pop
    //   11865: ldc 91
    //   11867: iconst_2
    //   11868: aload 5
    //   11870: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11873: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11876: new 77	java/lang/StringBuilder
    //   11879: dup
    //   11880: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   11883: astore 5
    //   11885: aload 5
    //   11887: aload 17
    //   11889: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11892: invokevirtual 3591	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   11895: invokevirtual 2201	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11898: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11901: pop
    //   11902: aload 5
    //   11904: ldc_w 2203
    //   11907: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11910: pop
    //   11911: aload 5
    //   11913: ldc_w 4826
    //   11916: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11919: pop
    //   11920: new 2198	java/io/File
    //   11923: dup
    //   11924: aload 5
    //   11926: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11929: invokespecial 3635	java/io/File:<init>	(Ljava/lang/String;)V
    //   11932: invokevirtual 3641	java/io/File:delete	()Z
    //   11935: pop
    //   11936: aload 17
    //   11938: invokevirtual 1430	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11941: aload 18
    //   11943: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11946: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11949: ldc_w 4828
    //   11952: ldc 8
    //   11954: invokestatic 3632	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   11957: aload_1
    //   11958: astore 16
    //   11960: iload 13
    //   11962: istore 14
    //   11964: iload 9
    //   11966: istore 8
    //   11968: goto +73 -> 12041
    //   11971: astore 5
    //   11973: aload_1
    //   11974: astore 16
    //   11976: iload 13
    //   11978: istore 14
    //   11980: iload 7
    //   11982: istore 8
    //   11984: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11987: ifeq +54 -> 12041
    //   11990: new 77	java/lang/StringBuilder
    //   11993: dup
    //   11994: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   11997: astore 15
    //   11999: aload 15
    //   12001: ldc_w 4830
    //   12004: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12007: pop
    //   12008: aload 15
    //   12010: aload 5
    //   12012: invokevirtual 2032	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   12015: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12018: pop
    //   12019: ldc 91
    //   12021: iconst_2
    //   12022: aload 15
    //   12024: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12027: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12030: iload 7
    //   12032: istore 8
    //   12034: iload 13
    //   12036: istore 14
    //   12038: aload_1
    //   12039: astore 16
    //   12041: iload 10
    //   12043: iconst_1
    //   12044: iadd
    //   12045: istore 10
    //   12047: iload 8
    //   12049: istore 7
    //   12051: aload 16
    //   12053: astore_1
    //   12054: iload 14
    //   12056: istore 13
    //   12058: goto -12035 -> 23
    //   12061: aload_1
    //   12062: ifnull +42 -> 12104
    //   12065: iload 13
    //   12067: ifne +53 -> 12120
    //   12070: aload 17
    //   12072: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12075: ldc_w 4449
    //   12078: invokestatic 4454	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   12081: ifne +39 -> 12120
    //   12084: aload 17
    //   12086: getstatic 4833	com/tencent/mobileqq/app/QQManagerFactory:TIM_UPGRADE_DOWNLOAD_MANAGER	I
    //   12089: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12092: checkcast 4835	com/tencent/mobileqq/upgrade/UpgradeTIMManager
    //   12095: aload 17
    //   12097: aload_1
    //   12098: invokevirtual 4836	com/tencent/mobileqq/upgrade/UpgradeTIMManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   12101: goto +19 -> 12120
    //   12104: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12107: ifeq +13 -> 12120
    //   12110: ldc_w 1601
    //   12113: iconst_2
    //   12114: ldc_w 4838
    //   12117: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   12120: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12123: ifeq +36 -> 12159
    //   12126: new 77	java/lang/StringBuilder
    //   12129: dup
    //   12130: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   12133: astore_1
    //   12134: aload_1
    //   12135: ldc_w 4840
    //   12138: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12141: pop
    //   12142: aload_1
    //   12143: iload 13
    //   12145: invokevirtual 454	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12148: pop
    //   12149: ldc 91
    //   12151: iconst_2
    //   12152: aload_1
    //   12153: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12156: invokestatic 2010	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   12159: return
    //   12160: astore 5
    //   12162: goto +20 -> 12182
    //   12165: astore 5
    //   12167: aload 15
    //   12169: astore_1
    //   12170: goto -197 -> 11973
    //   12173: iload 9
    //   12175: iconst_1
    //   12176: iadd
    //   12177: istore 9
    //   12179: goto -10489 -> 1690
    //   12182: aconst_null
    //   12183: astore 5
    //   12185: goto -7920 -> 4265
    //   12188: astore 5
    //   12190: goto -217 -> 11973
    //   12193: aconst_null
    //   12194: astore 5
    //   12196: goto -6551 -> 5645
    //   12199: iconst_0
    //   12200: istore 13
    //   12202: goto -6143 -> 6059
    //   12205: astore 5
    //   12207: goto -37 -> 12170
    //   12210: goto -5727 -> 6483
    //   12213: aconst_null
    //   12214: astore 5
    //   12216: goto -4139 -> 8077
    //   12219: goto -3767 -> 8452
    //   12222: iload 12
    //   12224: istore 11
    //   12226: goto -3613 -> 8613
    //   12229: iload 11
    //   12231: iconst_1
    //   12232: iadd
    //   12233: istore 11
    //   12235: goto -3110 -> 9125
    //   12238: goto -2573 -> 9665
    //   12241: iload 7
    //   12243: iconst_1
    //   12244: iadd
    //   12245: istore 7
    //   12247: goto -2212 -> 10035
    //   12250: astore 5
    //   12252: goto -279 -> 11973
    //   12255: iload 8
    //   12257: iconst_1
    //   12258: iadd
    //   12259: istore 8
    //   12261: goto -652 -> 11609
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12264	0	this	ConfigServlet
    //   0	12264	1	paramAppRuntime	AppRuntime
    //   0	12264	2	paramRespGetConfig	ConfigurationService.RespGetConfig
    //   0	12264	3	paramIntent	Intent
    //   0	12264	4	paramList	List<Integer>
    //   0	12264	5	paramArrayOfInt	int[]
    //   0	12264	6	paramBoolean	boolean
    //   13	12233	7	i	int
    //   99	12161	8	j	int
    //   1688	10490	9	k	int
    //   16	12030	10	m	int
    //   77	12157	11	n	int
    //   8577	3646	12	i1	int
    //   21	12180	13	bool1	boolean
    //   92	11963	14	bool2	boolean
    //   138	12030	15	localObject1	Object
    //   95	11957	16	localObject2	Object
    //   4	12092	17	localQQAppInterface	QQAppInterface
    //   45	11897	18	localObject3	Object
    //   9474	200	19	localSet	Set
    //   9566	106	20	str	String
    //   9589	66	21	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2230	2241	2255	java/lang/Throwable
    //   4165	4179	4182	java/lang/OutOfMemoryError
    //   4165	4179	4227	java/io/UnsupportedEncodingException
    //   5986	6009	6101	finally
    //   6009	6012	6101	finally
    //   6021	6036	6101	finally
    //   6036	6053	6101	finally
    //   6059	6066	6101	finally
    //   6066	6088	6101	finally
    //   6103	6106	6101	finally
    //   5969	5986	6109	java/lang/Exception
    //   6106	6109	6109	java/lang/Exception
    //   6413	6422	6604	java/lang/Exception
    //   6426	6434	6604	java/lang/Exception
    //   6438	6447	6604	java/lang/Exception
    //   6451	6465	6604	java/lang/Exception
    //   6469	6480	6604	java/lang/Exception
    //   6487	6503	6604	java/lang/Exception
    //   6525	6531	6604	java/lang/Exception
    //   6535	6544	6604	java/lang/Exception
    //   6548	6557	6604	java/lang/Exception
    //   6561	6575	6604	java/lang/Exception
    //   6579	6590	6604	java/lang/Exception
    //   6299	6307	6613	java/lang/Exception
    //   6311	6322	6613	java/lang/Exception
    //   6326	6341	6613	java/lang/Exception
    //   6356	6366	6613	java/lang/Exception
    //   6370	6382	6613	java/lang/Exception
    //   6386	6392	6613	java/lang/Exception
    //   6396	6405	6613	java/lang/Exception
    //   7376	7410	7602	java/lang/Exception
    //   7421	7509	7602	java/lang/Exception
    //   7509	7525	7602	java/lang/Exception
    //   7539	7588	7602	java/lang/Exception
    //   6623	6629	10745	java/lang/Exception
    //   6633	6642	10745	java/lang/Exception
    //   6646	6655	10745	java/lang/Exception
    //   6659	6670	10745	java/lang/Exception
    //   6674	6685	10745	java/lang/Exception
    //   6689	6694	10745	java/lang/Exception
    //   6712	6720	10745	java/lang/Exception
    //   6724	6735	10745	java/lang/Exception
    //   6739	6745	10745	java/lang/Exception
    //   6749	6758	10745	java/lang/Exception
    //   6762	6771	10745	java/lang/Exception
    //   6775	6783	10745	java/lang/Exception
    //   6787	6796	10745	java/lang/Exception
    //   6800	6818	10745	java/lang/Exception
    //   6822	6831	10745	java/lang/Exception
    //   6835	6849	10745	java/lang/Exception
    //   6853	6864	10745	java/lang/Exception
    //   6868	6881	10745	java/lang/Exception
    //   6885	6892	10745	java/lang/Exception
    //   6915	6928	10745	java/lang/Exception
    //   6932	6953	10745	java/lang/Exception
    //   6982	6988	10745	java/lang/Exception
    //   6992	7001	10745	java/lang/Exception
    //   7005	7014	10745	java/lang/Exception
    //   7018	7026	10745	java/lang/Exception
    //   7030	7039	10745	java/lang/Exception
    //   7043	7057	10745	java/lang/Exception
    //   7061	7072	10745	java/lang/Exception
    //   7090	7100	10745	java/lang/Exception
    //   7114	7122	10745	java/lang/Exception
    //   7136	7144	10745	java/lang/Exception
    //   7158	7166	10745	java/lang/Exception
    //   7195	7203	10745	java/lang/Exception
    //   7207	7226	10745	java/lang/Exception
    //   7230	7246	10745	java/lang/Exception
    //   7264	7272	10745	java/lang/Exception
    //   7286	7294	10745	java/lang/Exception
    //   7308	7316	10745	java/lang/Exception
    //   7330	7340	10745	java/lang/Exception
    //   7354	7362	10745	java/lang/Exception
    //   7608	7614	10745	java/lang/Exception
    //   7618	7627	10745	java/lang/Exception
    //   7631	7640	10745	java/lang/Exception
    //   7644	7655	10745	java/lang/Exception
    //   7659	7670	10745	java/lang/Exception
    //   7674	7679	10745	java/lang/Exception
    //   7697	7705	10745	java/lang/Exception
    //   7723	7731	10745	java/lang/Exception
    //   7735	7746	10745	java/lang/Exception
    //   7750	7764	10745	java/lang/Exception
    //   7768	7778	10745	java/lang/Exception
    //   7782	7796	10745	java/lang/Exception
    //   7811	7817	10745	java/lang/Exception
    //   7821	7830	10745	java/lang/Exception
    //   7834	7843	10745	java/lang/Exception
    //   7847	7855	10745	java/lang/Exception
    //   7859	7868	10745	java/lang/Exception
    //   7872	7886	10745	java/lang/Exception
    //   7890	7901	10745	java/lang/Exception
    //   7930	7936	10745	java/lang/Exception
    //   7940	7949	10745	java/lang/Exception
    //   7953	7962	10745	java/lang/Exception
    //   7966	7980	10745	java/lang/Exception
    //   7984	7995	10745	java/lang/Exception
    //   8013	8023	10745	java/lang/Exception
    //   8037	8045	10745	java/lang/Exception
    //   8049	8060	10745	java/lang/Exception
    //   8064	8074	10745	java/lang/Exception
    //   8086	8096	10745	java/lang/Exception
    //   8100	8113	10745	java/lang/Exception
    //   8117	8123	10745	java/lang/Exception
    //   8127	8136	10745	java/lang/Exception
    //   8140	8149	10745	java/lang/Exception
    //   8153	8161	10745	java/lang/Exception
    //   8165	8174	10745	java/lang/Exception
    //   8178	8192	10745	java/lang/Exception
    //   8196	8207	10745	java/lang/Exception
    //   8211	8216	10745	java/lang/Exception
    //   8220	8229	10745	java/lang/Exception
    //   8233	8243	10745	java/lang/Exception
    //   8247	8259	10745	java/lang/Exception
    //   8263	8269	10745	java/lang/Exception
    //   8273	8282	10745	java/lang/Exception
    //   8286	8295	10745	java/lang/Exception
    //   8299	8307	10745	java/lang/Exception
    //   8311	8320	10745	java/lang/Exception
    //   8324	8338	10745	java/lang/Exception
    //   8342	8353	10745	java/lang/Exception
    //   8357	8365	10745	java/lang/Exception
    //   8372	8376	10745	java/lang/Exception
    //   8380	8383	10745	java/lang/Exception
    //   8387	8393	10745	java/lang/Exception
    //   8397	8406	10745	java/lang/Exception
    //   8410	8419	10745	java/lang/Exception
    //   8423	8437	10745	java/lang/Exception
    //   8441	8452	10745	java/lang/Exception
    //   8456	8466	10745	java/lang/Exception
    //   8470	8480	10745	java/lang/Exception
    //   8494	8502	10745	java/lang/Exception
    //   8516	8524	10745	java/lang/Exception
    //   8538	8546	10745	java/lang/Exception
    //   8564	8579	10745	java/lang/Exception
    //   8588	8596	10745	java/lang/Exception
    //   8600	8610	10745	java/lang/Exception
    //   8617	8625	10745	java/lang/Exception
    //   8629	8640	10745	java/lang/Exception
    //   8644	8650	10745	java/lang/Exception
    //   8654	8663	10745	java/lang/Exception
    //   8667	8676	10745	java/lang/Exception
    //   8680	8688	10745	java/lang/Exception
    //   8692	8701	10745	java/lang/Exception
    //   8705	8713	10745	java/lang/Exception
    //   8717	8726	10745	java/lang/Exception
    //   8730	8744	10745	java/lang/Exception
    //   8748	8757	10745	java/lang/Exception
    //   8761	8779	10745	java/lang/Exception
    //   8783	8794	10745	java/lang/Exception
    //   8798	8807	10745	java/lang/Exception
    //   8814	8827	10745	java/lang/Exception
    //   8831	8849	10745	java/lang/Exception
    //   8862	8878	10745	java/lang/Exception
    //   8882	8897	10745	java/lang/Exception
    //   8915	8921	10745	java/lang/Exception
    //   8925	8934	10745	java/lang/Exception
    //   8938	8947	10745	java/lang/Exception
    //   8951	8959	10745	java/lang/Exception
    //   8963	8972	10745	java/lang/Exception
    //   8976	8984	10745	java/lang/Exception
    //   8988	8999	10745	java/lang/Exception
    //   9021	9035	10745	java/lang/Exception
    //   9039	9054	10745	java/lang/Exception
    //   9076	9084	10745	java/lang/Exception
    //   9088	9099	10745	java/lang/Exception
    //   9103	9122	10745	java/lang/Exception
    //   9140	9153	10745	java/lang/Exception
    //   9157	9172	10745	java/lang/Exception
    //   9176	9182	10745	java/lang/Exception
    //   9186	9195	10745	java/lang/Exception
    //   9199	9208	10745	java/lang/Exception
    //   9212	9220	10745	java/lang/Exception
    //   9224	9233	10745	java/lang/Exception
    //   9237	9251	10745	java/lang/Exception
    //   9255	9266	10745	java/lang/Exception
    //   9270	9278	10745	java/lang/Exception
    //   9282	9299	10745	java/lang/Exception
    //   9317	9323	10745	java/lang/Exception
    //   9327	9336	10745	java/lang/Exception
    //   9340	9349	10745	java/lang/Exception
    //   9353	9367	10745	java/lang/Exception
    //   9371	9382	10745	java/lang/Exception
    //   9400	9408	10745	java/lang/Exception
    //   9422	9438	10745	java/lang/Exception
    //   9452	9465	10745	java/lang/Exception
    //   9469	9476	10745	java/lang/Exception
    //   9480	9492	10745	java/lang/Exception
    //   9496	9504	10745	java/lang/Exception
    //   9508	9519	10745	java/lang/Exception
    //   9523	9538	10745	java/lang/Exception
    //   9542	9552	10745	java/lang/Exception
    //   9556	9568	10745	java/lang/Exception
    //   9572	9578	10745	java/lang/Exception
    //   9582	9591	10745	java/lang/Exception
    //   9595	9604	10745	java/lang/Exception
    //   9608	9616	10745	java/lang/Exception
    //   9620	9629	10745	java/lang/Exception
    //   9633	9647	10745	java/lang/Exception
    //   9651	9662	10745	java/lang/Exception
    //   9669	9679	10745	java/lang/Exception
    //   9683	9698	10745	java/lang/Exception
    //   9705	9711	10745	java/lang/Exception
    //   9715	9724	10745	java/lang/Exception
    //   9728	9737	10745	java/lang/Exception
    //   9741	9755	10745	java/lang/Exception
    //   9759	9770	10745	java/lang/Exception
    //   9774	9780	10745	java/lang/Exception
    //   9784	9793	10745	java/lang/Exception
    //   9797	9806	10745	java/lang/Exception
    //   9810	9818	10745	java/lang/Exception
    //   9828	9843	10745	java/lang/Exception
    //   9847	9855	10745	java/lang/Exception
    //   9859	9868	10745	java/lang/Exception
    //   9872	9883	10745	java/lang/Exception
    //   9887	9896	10745	java/lang/Exception
    //   9900	9914	10745	java/lang/Exception
    //   9918	9929	10745	java/lang/Exception
    //   9933	9946	10745	java/lang/Exception
    //   9960	9978	10745	java/lang/Exception
    //   9996	10004	10745	java/lang/Exception
    //   10008	10019	10745	java/lang/Exception
    //   10023	10032	10745	java/lang/Exception
    //   10039	10052	10745	java/lang/Exception
    //   10056	10071	10745	java/lang/Exception
    //   10075	10081	10745	java/lang/Exception
    //   10085	10094	10745	java/lang/Exception
    //   10098	10107	10745	java/lang/Exception
    //   10111	10119	10745	java/lang/Exception
    //   10123	10132	10745	java/lang/Exception
    //   10136	10150	10745	java/lang/Exception
    //   10154	10165	10745	java/lang/Exception
    //   10169	10177	10745	java/lang/Exception
    //   10186	10194	10745	java/lang/Exception
    //   10201	10213	10745	java/lang/Exception
    //   10217	10238	10745	java/lang/Exception
    //   10267	10273	10745	java/lang/Exception
    //   10277	10286	10745	java/lang/Exception
    //   10290	10299	10745	java/lang/Exception
    //   10303	10317	10745	java/lang/Exception
    //   10321	10332	10745	java/lang/Exception
    //   10350	10358	10745	java/lang/Exception
    //   10362	10373	10745	java/lang/Exception
    //   10377	10391	10745	java/lang/Exception
    //   10395	10401	10745	java/lang/Exception
    //   10405	10414	10745	java/lang/Exception
    //   10418	10427	10745	java/lang/Exception
    //   10431	10439	10745	java/lang/Exception
    //   10443	10452	10745	java/lang/Exception
    //   10456	10470	10745	java/lang/Exception
    //   10474	10485	10745	java/lang/Exception
    //   10489	10505	10745	java/lang/Exception
    //   10519	10525	10745	java/lang/Exception
    //   10529	10538	10745	java/lang/Exception
    //   10542	10551	10745	java/lang/Exception
    //   10555	10569	10745	java/lang/Exception
    //   10573	10584	10745	java/lang/Exception
    //   10588	10597	10745	java/lang/Exception
    //   10601	10618	10745	java/lang/Exception
    //   10622	10631	10745	java/lang/Exception
    //   10635	10644	10745	java/lang/Exception
    //   10648	10657	10745	java/lang/Exception
    //   10661	10670	10745	java/lang/Exception
    //   10674	10688	10745	java/lang/Exception
    //   10692	10700	10745	java/lang/Exception
    //   10704	10710	10745	java/lang/Exception
    //   10714	10735	10745	java/lang/Exception
    //   10774	10785	10745	java/lang/Exception
    //   10789	10795	10745	java/lang/Exception
    //   10799	10814	10745	java/lang/Exception
    //   10818	10828	10745	java/lang/Exception
    //   10832	10844	10745	java/lang/Exception
    //   10848	10854	10745	java/lang/Exception
    //   10858	10867	10745	java/lang/Exception
    //   10871	10880	10745	java/lang/Exception
    //   10884	10892	10745	java/lang/Exception
    //   10896	10905	10745	java/lang/Exception
    //   10909	10923	10745	java/lang/Exception
    //   10927	10938	10745	java/lang/Exception
    //   10942	10958	10745	java/lang/Exception
    //   10965	10982	10745	java/lang/Exception
    //   10986	10991	10745	java/lang/Exception
    //   10995	11000	10745	java/lang/Exception
    //   11004	11016	10745	java/lang/Exception
    //   11020	11029	10745	java/lang/Exception
    //   11033	11042	10745	java/lang/Exception
    //   11046	11055	10745	java/lang/Exception
    //   11059	11070	10745	java/lang/Exception
    //   11074	11093	10745	java/lang/Exception
    //   11097	11106	10745	java/lang/Exception
    //   11110	11119	10745	java/lang/Exception
    //   11123	11132	10745	java/lang/Exception
    //   11136	11147	10745	java/lang/Exception
    //   11151	11170	10745	java/lang/Exception
    //   11174	11193	10745	java/lang/Exception
    //   11208	11214	10745	java/lang/Exception
    //   11218	11227	10745	java/lang/Exception
    //   11231	11240	10745	java/lang/Exception
    //   11244	11258	10745	java/lang/Exception
    //   11262	11273	10745	java/lang/Exception
    //   11301	11310	10745	java/lang/Exception
    //   11314	11323	10745	java/lang/Exception
    //   11327	11341	10745	java/lang/Exception
    //   11345	11356	10745	java/lang/Exception
    //   6892	6900	11971	java/lang/Exception
    //   11448	11483	11971	java/lang/Exception
    //   11501	11583	11971	java/lang/Exception
    //   11586	11606	11971	java/lang/Exception
    //   11628	11642	11971	java/lang/Exception
    //   11645	11660	11971	java/lang/Exception
    //   11671	11759	11971	java/lang/Exception
    //   11759	11824	11971	java/lang/Exception
    //   11827	11876	11971	java/lang/Exception
    //   11876	11957	11971	java/lang/Exception
    //   4210	4224	12160	java/lang/Throwable
    //   1435	1449	12165	java/lang/Exception
    //   1466	1474	12165	java/lang/Exception
    //   1491	1499	12165	java/lang/Exception
    //   1516	1526	12165	java/lang/Exception
    //   1543	1551	12165	java/lang/Exception
    //   1568	1576	12165	java/lang/Exception
    //   1593	1601	12165	java/lang/Exception
    //   1618	1626	12165	java/lang/Exception
    //   1643	1651	12165	java/lang/Exception
    //   1654	1665	12165	java/lang/Exception
    //   1668	1687	12165	java/lang/Exception
    //   1704	1717	12165	java/lang/Exception
    //   1720	1735	12165	java/lang/Exception
    //   1738	1744	12165	java/lang/Exception
    //   1747	1756	12165	java/lang/Exception
    //   1759	1768	12165	java/lang/Exception
    //   1771	1779	12165	java/lang/Exception
    //   1782	1791	12165	java/lang/Exception
    //   1794	1808	12165	java/lang/Exception
    //   1811	1822	12165	java/lang/Exception
    //   1825	1833	12165	java/lang/Exception
    //   1836	1852	12165	java/lang/Exception
    //   1869	1875	12165	java/lang/Exception
    //   1878	1887	12165	java/lang/Exception
    //   1890	1899	12165	java/lang/Exception
    //   1902	1916	12165	java/lang/Exception
    //   1919	1930	12165	java/lang/Exception
    //   1947	1955	12165	java/lang/Exception
    //   1972	1990	12165	java/lang/Exception
    //   2007	2026	12165	java/lang/Exception
    //   2043	2049	12165	java/lang/Exception
    //   2066	2074	12165	java/lang/Exception
    //   2091	2099	12165	java/lang/Exception
    //   2116	2138	12165	java/lang/Exception
    //   2155	2162	12165	java/lang/Exception
    //   2179	2186	12165	java/lang/Exception
    //   2203	2213	12165	java/lang/Exception
    //   2230	2241	12165	java/lang/Exception
    //   2260	2265	12165	java/lang/Exception
    //   2282	2290	12165	java/lang/Exception
    //   2307	2325	12165	java/lang/Exception
    //   2342	2350	12165	java/lang/Exception
    //   2367	2375	12165	java/lang/Exception
    //   2392	2410	12165	java/lang/Exception
    //   2427	2435	12165	java/lang/Exception
    //   2452	2459	12165	java/lang/Exception
    //   2476	2484	12165	java/lang/Exception
    //   2501	2522	12165	java/lang/Exception
    //   2539	2547	12165	java/lang/Exception
    //   2564	2573	12165	java/lang/Exception
    //   2590	2607	12165	java/lang/Exception
    //   2624	2631	12165	java/lang/Exception
    //   2648	2656	12165	java/lang/Exception
    //   2673	2681	12165	java/lang/Exception
    //   2698	2705	12165	java/lang/Exception
    //   2722	2743	12165	java/lang/Exception
    //   2760	2770	12165	java/lang/Exception
    //   2787	2803	12165	java/lang/Exception
    //   2820	2832	12165	java/lang/Exception
    //   2849	2858	12165	java/lang/Exception
    //   2875	2883	12165	java/lang/Exception
    //   2900	2908	12165	java/lang/Exception
    //   2925	2935	12165	java/lang/Exception
    //   2952	2960	12165	java/lang/Exception
    //   2977	2985	12165	java/lang/Exception
    //   3002	3010	12165	java/lang/Exception
    //   3027	3035	12165	java/lang/Exception
    //   3052	3059	12165	java/lang/Exception
    //   3076	3083	12165	java/lang/Exception
    //   3100	3108	12165	java/lang/Exception
    //   3125	3133	12165	java/lang/Exception
    //   3150	3158	12165	java/lang/Exception
    //   3175	3183	12165	java/lang/Exception
    //   3200	3208	12165	java/lang/Exception
    //   3225	3233	12165	java/lang/Exception
    //   3250	3258	12165	java/lang/Exception
    //   3275	3283	12165	java/lang/Exception
    //   3300	3308	12165	java/lang/Exception
    //   3325	3333	12165	java/lang/Exception
    //   3350	3358	12165	java/lang/Exception
    //   3375	3383	12165	java/lang/Exception
    //   3400	3408	12165	java/lang/Exception
    //   3425	3433	12165	java/lang/Exception
    //   3450	3458	12165	java/lang/Exception
    //   3475	3483	12165	java/lang/Exception
    //   3500	3505	12165	java/lang/Exception
    //   3522	3530	12165	java/lang/Exception
    //   3547	3555	12165	java/lang/Exception
    //   3572	3582	12165	java/lang/Exception
    //   3599	3628	12165	java/lang/Exception
    //   3647	3676	12165	java/lang/Exception
    //   3693	3710	12165	java/lang/Exception
    //   3727	3740	12165	java/lang/Exception
    //   3759	3768	12165	java/lang/Exception
    //   3785	3804	12165	java/lang/Exception
    //   3821	3828	12165	java/lang/Exception
    //   3845	3852	12165	java/lang/Exception
    //   3869	3877	12165	java/lang/Exception
    //   3894	3904	12165	java/lang/Exception
    //   3921	3929	12165	java/lang/Exception
    //   3946	3954	12165	java/lang/Exception
    //   3971	3979	12165	java/lang/Exception
    //   3996	4004	12165	java/lang/Exception
    //   4021	4029	12165	java/lang/Exception
    //   4057	4065	12165	java/lang/Exception
    //   4079	4090	12165	java/lang/Exception
    //   4093	4100	12165	java/lang/Exception
    //   4111	4118	12165	java/lang/Exception
    //   4126	4138	12165	java/lang/Exception
    //   4141	4157	12165	java/lang/Exception
    //   4165	4179	12165	java/lang/Exception
    //   4187	4193	12165	java/lang/Exception
    //   4196	4201	12165	java/lang/Exception
    //   4204	4207	12165	java/lang/Exception
    //   4210	4224	12165	java/lang/Exception
    //   4232	4238	12165	java/lang/Exception
    //   4241	4246	12165	java/lang/Exception
    //   4252	4265	12165	java/lang/Exception
    //   4284	4294	12165	java/lang/Exception
    //   4297	4303	12165	java/lang/Exception
    //   4306	4315	12165	java/lang/Exception
    //   4318	4327	12165	java/lang/Exception
    //   4330	4338	12165	java/lang/Exception
    //   4341	4350	12165	java/lang/Exception
    //   4353	4361	12165	java/lang/Exception
    //   4364	4376	12165	java/lang/Exception
    //   4379	4385	12165	java/lang/Exception
    //   4388	4401	12165	java/lang/Exception
    //   4404	4418	12165	java/lang/Exception
    //   4421	4427	12165	java/lang/Exception
    //   4430	4440	12165	java/lang/Exception
    //   4443	4448	12165	java/lang/Exception
    //   4451	4457	12165	java/lang/Exception
    //   4485	4491	12165	java/lang/Exception
    //   4494	4504	12165	java/lang/Exception
    //   4532	4538	12165	java/lang/Exception
    //   4541	4551	12165	java/lang/Exception
    //   4568	4576	12165	java/lang/Exception
    //   4593	4603	12165	java/lang/Exception
    //   4620	4628	12165	java/lang/Exception
    //   4645	4653	12165	java/lang/Exception
    //   4670	4678	12165	java/lang/Exception
    //   4695	4703	12165	java/lang/Exception
    //   4720	4728	12165	java/lang/Exception
    //   4745	4753	12165	java/lang/Exception
    //   4770	4778	12165	java/lang/Exception
    //   4795	4803	12165	java/lang/Exception
    //   4820	4830	12165	java/lang/Exception
    //   4847	4868	12165	java/lang/Exception
    //   4885	4893	12165	java/lang/Exception
    //   4910	4918	12165	java/lang/Exception
    //   4935	4943	12165	java/lang/Exception
    //   4960	4968	12165	java/lang/Exception
    //   4985	4997	12165	java/lang/Exception
    //   5014	5022	12165	java/lang/Exception
    //   5039	5047	12165	java/lang/Exception
    //   5064	5072	12165	java/lang/Exception
    //   5089	5099	12165	java/lang/Exception
    //   5116	5124	12165	java/lang/Exception
    //   5141	5149	12165	java/lang/Exception
    //   5166	5174	12165	java/lang/Exception
    //   5191	5199	12165	java/lang/Exception
    //   5216	5224	12165	java/lang/Exception
    //   5241	5249	12165	java/lang/Exception
    //   5266	5274	12165	java/lang/Exception
    //   5291	5299	12165	java/lang/Exception
    //   5316	5324	12165	java/lang/Exception
    //   5341	5354	12165	java/lang/Exception
    //   5357	5367	12165	java/lang/Exception
    //   5370	5376	12165	java/lang/Exception
    //   5379	5411	12165	java/lang/Exception
    //   5421	5429	12165	java/lang/Exception
    //   5432	5443	12165	java/lang/Exception
    //   5449	5463	12165	java/lang/Exception
    //   5466	5472	12165	java/lang/Exception
    //   5475	5484	12165	java/lang/Exception
    //   5487	5496	12165	java/lang/Exception
    //   5499	5507	12165	java/lang/Exception
    //   5510	5521	12165	java/lang/Exception
    //   5524	5532	12165	java/lang/Exception
    //   5535	5545	12165	java/lang/Exception
    //   5551	5562	12165	java/lang/Exception
    //   5568	5574	12165	java/lang/Exception
    //   5577	5586	12165	java/lang/Exception
    //   5589	5599	12165	java/lang/Exception
    //   5605	5618	12165	java/lang/Exception
    //   5624	5630	12165	java/lang/Exception
    //   5633	5642	12165	java/lang/Exception
    //   5648	5661	12165	java/lang/Exception
    //   5664	5672	12165	java/lang/Exception
    //   5675	5683	12165	java/lang/Exception
    //   5686	5693	12165	java/lang/Exception
    //   5696	5702	12165	java/lang/Exception
    //   5705	5744	12165	java/lang/Exception
    //   5747	5769	12165	java/lang/Exception
    //   5772	5786	12165	java/lang/Exception
    //   5789	5803	12165	java/lang/Exception
    //   5806	5820	12165	java/lang/Exception
    //   5823	5837	12165	java/lang/Exception
    //   5840	5859	12165	java/lang/Exception
    //   5862	5876	12165	java/lang/Exception
    //   5879	5885	12165	java/lang/Exception
    //   5888	5897	12165	java/lang/Exception
    //   5900	5912	12165	java/lang/Exception
    //   5915	5925	12165	java/lang/Exception
    //   5928	5937	12165	java/lang/Exception
    //   5940	5947	12165	java/lang/Exception
    //   5950	5955	12165	java/lang/Exception
    //   6120	6125	12165	java/lang/Exception
    //   6128	6139	12165	java/lang/Exception
    //   6156	6166	12165	java/lang/Exception
    //   6183	6191	12165	java/lang/Exception
    //   6217	6229	12165	java/lang/Exception
    //   6246	6254	12165	java/lang/Exception
    //   6271	6281	12165	java/lang/Exception
    //   4100	4108	12188	java/lang/Exception
    //   6205	6214	12205	java/lang/Exception
    //   10758	10765	12250	java/lang/Exception
    //   11287	11292	12250	java/lang/Exception
    //   11356	11448	12250	java/lang/Exception
  }
  
  public void a(AppRuntime paramAppRuntime, ConfigurationService.RespGetConfig paramRespGetConfig, Intent paramIntent, int[] paramArrayOfInt, boolean paramBoolean)
  {
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    if ((paramBoolean) && (paramRespGetConfig.result.get() == 0) && (paramRespGetConfig.config_list != null) && (paramRespGetConfig.config_list.size() != 0)) {
      return;
    }
    int i = 0;
    for (;;)
    {
      paramIntent = paramArrayOfInt;
      if (i >= paramIntent.length) {
        break;
      }
      int j = paramIntent[i];
      if (!QConfigManager.a().a(j))
      {
        Object localObject;
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("receiveAllConfigs|failed type: ");
              paramIntent.append(j);
              QLog.i("SPLASH_ConfigServlet", 2, paramIntent.toString());
            }
            switch (j)
            {
            case 156: 
            default: 
              paramIntent = paramAppRuntime;
              paramIntent.getConfigProcess().a(paramIntent, j, paramBoolean, paramRespGetConfig.result.get());
              break;
            case 718: 
              ShortVideoResourceManager.a(paramRespGetConfig.result.get());
              break;
            case 705: 
              QLog.e("SPLASH_ConfigServlet", 1, new Object[] { "get local qr login switch failed : ", Integer.valueOf(paramRespGetConfig.result.get()) });
              break;
            case 604: 
              QLog.e("SPLASH_ConfigServlet", 1, new Object[] { "get dev manage switch failed : ", Integer.valueOf(paramRespGetConfig.result.get()) });
              break;
            case 321: 
              if (QLog.isColorLevel())
              {
                j = paramRespGetConfig.result.get();
                paramIntent = new StringBuilder();
                paramIntent.append("SCRIBBLE_RED_SWITCH_CONFIG.  failed, resultCode:");
                paramIntent.append(j);
                QLog.d("SPLASH_ConfigServlet", 2, paramIntent.toString());
              }
              break;
            case 283: 
              SafeModeUtil.c();
              break;
            case 273: 
              if (QLog.isColorLevel())
              {
                j = paramRespGetConfig.result.get();
                paramIntent = new StringBuilder();
                paramIntent.append("get config failed, resultCode:");
                paramIntent.append(j);
                QLog.d("GiftConfigManager", 2, paramIntent.toString());
              }
              break;
            case 260: 
              if (QLog.isColorLevel())
              {
                j = paramRespGetConfig.result.get();
                QLog.d("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "PUSH_RECOMMEND_SHIELD_CONFIG fail code: %s", new Object[] { Integer.valueOf(j) }));
              }
              break;
            case 257: 
              if (QLog.isColorLevel())
              {
                j = paramRespGetConfig.result.get();
                QLog.d("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "MEDAL_STRONG_REMINDER_CONFIG fail code: %s", new Object[] { Integer.valueOf(j) }));
              }
              break;
            case 223: 
            case 364: 
            case 365: 
              BusinessCommonConfig.getInstance(paramAppRuntime).handleResp_Config_Fail(paramAppRuntime, j, paramBoolean, paramRespGetConfig);
              break;
            case 215: 
              AEOldShortVideoResManager.a(paramRespGetConfig.result.get());
              break;
            case 210: 
              paramIntent = (IOCRService)paramAppRuntime.getRuntimeService(IOCRService.class, "");
              j = paramRespGetConfig.result.get();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("OCR_CONFIG failed, resultCode:");
              ((StringBuilder)localObject).append(j);
              QLog.d("SPLASH_ConfigServlet", 1, ((StringBuilder)localObject).toString());
              paramIntent.onGetOCRConfig(false, null);
              break;
            case 202: 
              if (QLog.isColorLevel())
              {
                j = paramRespGetConfig.result.get();
                paramIntent = new StringBuilder();
                paramIntent.append("failed, resultCode:");
                paramIntent.append(j);
                QLog.d("CU_OPEN_CARD_GUIDE", 2, paramIntent.toString());
              }
              break;
            case 188: 
              if (QLog.isColorLevel())
              {
                j = paramRespGetConfig.result.get();
                paramIntent = new StringBuilder();
                paramIntent.append("AR_GLOBAL_CONTROL_COFIG failed, resultCode:");
                paramIntent.append(j);
                QLog.d("SPLASH_ConfigServlet", 2, paramIntent.toString());
              }
              break;
            case 185: 
              ScribbleResMgr.a().b();
              break;
            case 174: 
              if (QLog.isColorLevel())
              {
                j = paramRespGetConfig.result.get();
                paramIntent = new StringBuilder();
                paramIntent.append("Nearby. NEARBY_TABS_CONFIG failed, resultCode:");
                paramIntent.append(j);
                QLog.d("SPLASH_ConfigServlet", 2, paramIntent.toString());
              }
              break;
            case 165: 
              if (QLog.isColorLevel())
              {
                j = paramRespGetConfig.result.get();
                paramIntent = new StringBuilder();
                paramIntent.append("BuluoRedDot. BULUO_REDDOT_CONFIG failed, resultCode:");
                paramIntent.append(j);
                QLog.d("SPLASH_ConfigServlet", 2, paramIntent.toString());
              }
              break;
            case 149: 
            case 180: 
            case 218: 
              QAVConfig.a(j, paramBoolean, paramRespGetConfig);
              break;
            case 140: 
              j = paramRespGetConfig.result.get();
              if (QLog.isColorLevel())
              {
                paramIntent = new StringBuilder();
                paramIntent.append("ScanFu. GET_SCAN_FU_CONFIG failed, resultCode:");
                paramIntent.append(j);
                QLog.d("SPLASH_ConfigServlet", 2, paramIntent.toString());
              }
              paramIntent = new HashMap();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(j);
              ((StringBuilder)localObject).append("");
              paramIntent.put("failedCode", ((StringBuilder)localObject).toString());
              StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pullMedalConfigFailed", false, 0L, 0L, paramIntent, null);
              break;
            case 119: 
              paramIntent = (BabyQHandler)paramAppRuntime.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
              if (paramIntent != null) {
                paramIntent.a(false, false);
              }
              break;
            }
          }
        } while ((paramBoolean) && (paramRespGetConfig.result.get() == 0));
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE get config fail.");
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          ReportController.b(paramAppRuntime, "CliOper", "", "", "0X800716D", "0X800716D", 0, 0, "", "", "", "");
          this.jdField_a_of_type_Boolean = true;
        }
        ((ConfigHandler)paramAppRuntime.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a(UpgradeController.a().a());
        break label1347;
        paramIntent = paramAppRuntime;
        if ((!paramBoolean) || (paramRespGetConfig.result.get() != 0))
        {
          localObject = (PasswdRedBagFoldManager)paramIntent.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
          ((PasswdRedBagFoldManager)localObject).jdField_a_of_type_Boolean = true;
          ((PasswdRedBagFoldManager)localObject).jdField_b_of_type_Boolean = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
          ((PasswdRedBagFoldManager)localObject).jdField_a_of_type_Int = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
          ((PasswdRedBagFoldManager)localObject).d = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
          SharedPreUtils.a(paramIntent.getApp(), paramIntent.getAccount(), 0, ((PasswdRedBagFoldManager)localObject).jdField_b_of_type_Boolean, ((PasswdRedBagFoldManager)localObject).jdField_a_of_type_Int, ((PasswdRedBagFoldManager)localObject).c, ((PasswdRedBagFoldManager)localObject).d);
          break label1347;
          paramIntent = paramAppRuntime;
          if (paramRespGetConfig.result.get() != 0) {
            PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, paramIntent.getCurrentUin(), "actPatchConfig", 101, "");
          } else if ((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) {
            PatchFileManager.a(paramIntent);
          }
          SafeModeUtil.c();
        }
      }
      label1347:
      i += 1;
    }
  }
  
  public void a(AppRuntime paramAppRuntime, List<Integer> paramList)
  {
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    Iterator localIterator = paramList.iterator();
    Object localObject1;
    Object localObject2;
    int j;
    boolean bool;
    int i;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject1 = (Integer)localIterator.next();
      if (!QConfigManager.a().a(((Integer)localObject1).intValue()))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("receiveAllConfigs|noReceiveType: ");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(",length: ");
          ((StringBuilder)localObject2).append(paramList.size());
          QLog.w("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
        }
        j = ((Integer)localObject1).intValue();
        bool = true;
        i = 0;
        switch (j)
        {
        case 156: 
        default: 
          break;
        case 718: 
          ShortVideoResourceManager.b();
          break;
        case 345: 
          FreeWifiHelper.a(paramAppRuntime, true);
          break;
        case 297: 
          NativeMonitorConfigHelper.a(true);
          break;
        case 223: 
        case 364: 
        case 365: 
          BusinessCommonConfig.getInstance(paramAppRuntime).handleResp_Config_NoResp(paramAppRuntime, ((Integer)localObject1).intValue());
          break;
        case 215: 
          AEOldShortVideoResManager.b();
          break;
        case 205: 
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "config is newest .handleResp_GetArScanFacePreDownConfig  no receive respConfig");
          }
          break;
        case 202: 
          if (QLog.isColorLevel()) {
            QLog.i("CU_OPEN_CARD_GUIDE", 2, "no need to update, use local config");
          }
          break;
        case 191: 
          ((AppGuideTipsManager)paramAppRuntime.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).a();
          break;
        case 188: 
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_AR_GLOBAL_CONTROL_COFIG", 2, "handleResp_AR_GLOBAL_CONTROL_COFIG:no receive respConfig");
          }
          break;
        case 185: 
          ScribbleResMgr.a().a();
          break;
        case 119: 
          localObject1 = (BabyQHandler)paramAppRuntime.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
          if (localObject1 != null) {
            ((BabyQHandler)localObject1).a(false, false);
          }
          break;
        case 116: 
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE no config, use local config.");
          }
          localObject1 = (ConfigHandler)paramAppRuntime.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
          localObject2 = UpgradeConfigManager.a("config_upgrade_", jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("receiveAllConfigs|GET_CONFIG_UPGRADE configContent=");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject3).toString());
          }
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE local config is empty, reset local version to 0.");
            }
            SharedPreUtils.m(paramAppRuntime.getApp(), jdField_a_of_type_JavaLangString, 0);
            UpgradeConfigManager.a("config_upgrade_", jdField_a_of_type_JavaLangString);
            ((ConfigHandler)localObject1).a(UpgradeController.a().a());
          }
          else
          {
            localObject3 = UpgradeController.a().a();
            ((UpgradeDetailWrapper)localObject3).a((String)localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, String.format("receiveAllConfigs|GET_CONFIG_UPGRADE localAppID=%s configAppID=%s", new Object[] { Integer.valueOf(AppSetting.a()), Integer.valueOf(((UpgradeDetailWrapper)localObject3).jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId) }));
            }
            if (AppSetting.a() >= ((UpgradeDetailWrapper)localObject3).jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE already upgraded, delete local config.");
              }
              SharedPreUtils.m(paramAppRuntime.getApp(), jdField_a_of_type_JavaLangString, 0);
              UpgradeConfigManager.a("config_upgrade_", jdField_a_of_type_JavaLangString);
              ((UpgradeDetailWrapper)localObject3).jdField_b_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType = 0;
              ((ConfigHandler)localObject1).a((UpgradeDetailWrapper)localObject3);
              ((ConfigHandler)localObject1).d();
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!((UpgradeDetailWrapper)localObject3).jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE waiting switch bit.");
          }
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE do upgrade.");
        }
        if (((UpgradeDetailWrapper)localObject3).jdField_b_of_type_Int == 0)
        {
          if (((UpgradeDetailWrapper)localObject3).jdField_a_of_type_Int != 1) {
            break label1030;
          }
          ConfigHandler.a(paramAppRuntime, bool);
        }
        UpgradeController.a().a(((UpgradeDetailWrapper)localObject3).jdField_b_of_type_ProtocolKQQConfigUpgradeInfo, (UpgradeController.OnHandleUpgradeFinishListener)localObject1);
        break;
      }
      finally {}
      PatchFileManager.a(paramAppRuntime);
      break;
      ((IQWalletConfigService)paramAppRuntime.getRuntimeService(IQWalletConfigService.class)).handleQWalletSettingCofig(null);
      break;
      localObject1 = SharedPreUtils.b(paramAppRuntime.getCurrentAccountUin());
      ((SharedPreferences)localObject1).edit().remove("qav_upgrade_invite_video").commit();
      ((SharedPreferences)localObject1).edit().remove("qav_upgrade_invite_multi").commit();
      break;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramAppRuntime.getApplication().getFilesDir().getAbsolutePath());
      ((StringBuilder)localObject1).append("/splashpic/");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new File((String)localObject1);
      if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory())) {
        break;
      }
      localObject2 = ((File)localObject2).listFiles();
      if (localObject2 == null) {
        break;
      }
      j = localObject2.length;
      while (i < j)
      {
        localObject3 = localObject2[i];
        if (localObject3 != null) {
          ThreadManager.post(new ConfigServlet.1(this, (File)localObject3, (String)localObject1, paramAppRuntime), 5, null, true);
        }
        i += 1;
      }
      break;
      return;
      label1030:
      bool = false;
    }
  }
  
  public void a(int[] paramArrayOfInt, FromServiceMsg paramFromServiceMsg)
  {
    KandianConfigServlet.a("0", paramArrayOfInt, paramFromServiceMsg.getResultCode());
    SoLoadConfProcessor.a(paramArrayOfInt, paramFromServiceMsg);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (k == 215)
      {
        AEOldShortVideoResManager.a(-5);
        AEQLog.d("SPLASH_ConfigServlet", "【SHORT_VIDEO_RESOURCE_CONFIG】RES_OVERTIME");
      }
      else if (k == 718)
      {
        ShortVideoResourceManager.a(-5);
        AEQLog.d("SPLASH_ConfigServlet", "【SHORT_VIDEO_RESOURCE_CONFIG】RES_OVERTIME");
      }
      i += 1;
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime, int[] paramArrayOfInt)
  {
    return (paramArrayOfInt != null) && (paramArrayOfInt.length == 1) && (paramArrayOfInt[0] == 215) && (!paramAppRuntime.isLogin());
  }
  
  protected void b(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig != null) {}
    try
    {
      if (paramConfig.type.get() == 143)
      {
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
        {
          Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          if (localObject1 != null)
          {
            if (((ConfigurationService.Content)localObject1).compress.get() == 1)
            {
              byte[] arrayOfByte = OlympicUtil.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
              localStringBuilder = null;
              localObject1 = localStringBuilder;
              if (arrayOfByte != null)
              {
                try
                {
                  localObject1 = new String(arrayOfByte, "UTF-8");
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  if (QLog.isColorLevel()) {
                    localOutOfMemoryError.printStackTrace();
                  }
                  System.gc();
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  try
                  {
                    localObject2 = new String(arrayOfByte, "UTF-8");
                  }
                  catch (Throwable localThrowable)
                  {
                    for (;;)
                    {
                      Object localObject2;
                      int i;
                      Object localObject3 = localStringBuilder;
                      continue;
                      paramQQAppInterface = "";
                    }
                  }
                  localUnsupportedEncodingException = localUnsupportedEncodingException;
                  localObject2 = localStringBuilder;
                  if (!QLog.isColorLevel()) {
                    break label179;
                  }
                }
                localUnsupportedEncodingException.printStackTrace();
                localObject2 = localStringBuilder;
              }
            }
            else
            {
              localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
            }
            label179:
            if (localObject2 != null)
            {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("receiveAllConfigs|type: 143,content: ");
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append(",version: ");
                localStringBuilder.append(paramConfig.version.get());
                QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, localStringBuilder.toString());
              }
              i = paramConfig.version.get();
              if ((i != SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
              {
                ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).setGlamourIcon((String)localObject2);
                ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).setGlamourLevelColors((String)localObject2);
                SharedPreUtils.i(paramQQAppInterface.getApp(), (String)localObject2);
                SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", jdField_a_of_type_JavaLangString, i);
                return;
              }
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
              }
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "handleNearbyGlamourLevelConfig, content is null");
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("receiveAllConfigs|type: 143,content_list is empty ,version: ");
        if (paramConfig == null) {
          break label488;
        }
        paramQQAppInterface = Integer.valueOf(paramConfig.version.get());
        ((StringBuilder)localObject2).append(paramQQAppInterface);
        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel())
      {
        paramConfig = new StringBuilder();
        paramConfig.append("received change machine config error,cmd : 143");
        paramConfig.append(paramQQAppInterface.toString());
        QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, paramConfig.toString());
      }
    }
  }
  
  public void d(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleRespGetHotDaysConfig|type= ");
      ((StringBuilder)localObject1).append(paramConfig.type.get());
      QLog.d("HotFriend_SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramConfig != null) {}
    try
    {
      if (paramConfig.type.get() == 146)
      {
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
        {
          localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          if (localObject1 != null)
          {
            if (((ConfigurationService.Content)localObject1).compress.get() == 1)
            {
              byte[] arrayOfByte = OlympicUtil.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
              localStringBuilder = null;
              localObject1 = localStringBuilder;
              if (arrayOfByte != null)
              {
                try
                {
                  localObject1 = new String(arrayOfByte, "UTF-8");
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  if (QLog.isColorLevel()) {
                    localOutOfMemoryError.printStackTrace();
                  }
                  System.gc();
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  try
                  {
                    localObject2 = new String(arrayOfByte, "UTF-8");
                  }
                  catch (Throwable localThrowable)
                  {
                    for (;;)
                    {
                      Object localObject2;
                      Object localObject3 = localStringBuilder;
                      continue;
                      paramQQAppInterface = "";
                    }
                  }
                  localUnsupportedEncodingException = localUnsupportedEncodingException;
                  localObject2 = localStringBuilder;
                  if (!QLog.isColorLevel()) {
                    break label211;
                  }
                }
                localUnsupportedEncodingException.printStackTrace();
                localObject2 = localStringBuilder;
              }
            }
            else
            {
              localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
            }
            label211:
            if (localObject2 != null)
            {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("handleRespGetHotDaysConfig, config_content is ");
                localStringBuilder.append((String)localObject2);
                QLog.d("HotFriend_SPLASH_ConfigServlet", 2, localStringBuilder.toString());
              }
              HotReactiveHelper.a(paramQQAppInterface, (String)localObject2, paramConfig.version.get());
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, content is null");
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("content_list is empty ,version: ");
        if (paramConfig == null) {
          break label372;
        }
        paramQQAppInterface = Integer.valueOf(paramConfig.version.get());
        ((StringBuilder)localObject2).append(paramQQAppInterface);
        QLog.d("HotFriend_SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HotFriend_SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void e(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label280;
      }
      i = 0;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        int i;
        Object localObject;
        StringBuilder localStringBuilder;
        int j;
        label280:
        continue;
        label345:
        i += 1;
      }
    }
    if (i < paramConfig.content_list.size())
    {
      localObject = (String)paramConfig.content_list.get(i);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("receiveAllConfigs|type: 72,content: ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",version: ");
        localStringBuilder.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
      }
      j = paramConfig.version.get();
      if ((j == SharedPreUtils.I(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin())) && (paramConfig.content_list.size() <= 0))
      {
        if (!QLog.isColorLevel()) {
          break label345;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_CONFIG_CMD IGNORE THIS ACTION  because of SAME VERSION");
        break label345;
      }
      if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateArkChannelConfig((String)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received 72 ark config");
        }
      }
      else if ((((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).updateReadinjoyFolderConfig(paramQQAppInterface, (String)localObject)) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("received READINJOY_FOLDER_CONFIG_CMD save version: ");
        ((StringBuilder)localObject).append(j);
        QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject).toString());
      }
      SharedPreUtils.p(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentUin(), j);
      break label345;
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("receiveAllConfigs|type: 72,content_list is empty ,version: ");
        paramQQAppInterface.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy folder config error,cmd : 72");
        }
      }
    }
  }
  
  public void f(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label304;
      }
      i = 0;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        int i;
        Object localObject1;
        Object localObject2;
        int j;
        label304:
        continue;
        label369:
        i += 1;
      }
    }
    if (i < paramConfig.content_list.size())
    {
      localObject1 = ((String)paramConfig.content_list.get(i)).trim();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("receiveAllConfigs|type: 73,content: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",version: ");
        ((StringBuilder)localObject2).append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
      }
      j = paramConfig.version.get();
      if ((j == SharedPreUtils.x(paramQQAppInterface.getApp())) && (paramConfig.content_list.size() <= 0))
      {
        if (!QLog.isColorLevel()) {
          break label369;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_SETTING_CMD IGNORE THIS ACTION  because of SAME VERSION");
        break label369;
      }
      localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8")));
      localObject1 = (Element)((Document)localObject2).getElementsByTagName("kandian_setting").item(0);
      localObject2 = (Element)((Document)localObject2).getElementsByTagName("url").item(0);
      localObject1 = ((Element)localObject1).getFirstChild().getNodeValue();
      localObject2 = ((Element)localObject2).getFirstChild().getNodeValue();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        SharedPreUtils.b(paramQQAppInterface.getApp(), (String)localObject2, "1".equals(localObject1));
      }
      SharedPreUtils.o(paramQQAppInterface.getApp(), j);
      break label369;
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("receiveAllConfigs|type: 73,content_list is empty ,version: ");
        paramQQAppInterface.append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy folder setting config error,cmd : 73");
        }
      }
    }
  }
  
  void g(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 147) {
      return;
    }
    int i = SharedPreUtils.a(paramQQAppInterface.getApp(), "shop_tab", jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {}
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
        paramConfig = new StringBuilder();
        paramConfig.append("current config set tab show:");
        paramConfig.append(bool);
        paramConfig.append(",preload:");
        paramConfig.append(paramQQAppInterface.c);
        paramConfig.append(",stayTime:");
        paramConfig.append(paramQQAppInterface.a);
        paramConfig.append(",dayLimit:");
        paramConfig.append(paramQQAppInterface.d);
        QLog.i("Ecshop", 2, paramConfig.toString());
      }
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  protected void h(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleQuickShotShareToStoryConfig type = ");
      ((StringBuilder)localObject).append(paramConfig.type.get());
      QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject).toString());
    }
    int i = SharedPreUtils.V(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
    int j = paramConfig.version.get();
    if (i == j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig version code not changed .");
      }
      return;
    }
    SharedPreUtils.u(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), j);
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() >= 1) && (paramConfig.msg_content_list.get(0) != null))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig.compress.get() == 1)
      {
        localObject = OlympicUtil.a(paramConfig.content.get().toByteArray());
        if (localObject != null) {
          try
          {
            paramConfig = new String((byte[])localObject, "UTF-8");
          }
          catch (OutOfMemoryError paramConfig)
          {
            if (QLog.isColorLevel()) {
              QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramConfig));
            }
            System.gc();
            try
            {
              paramConfig = new String((byte[])localObject, "UTF-8");
            }
            catch (Throwable paramConfig)
            {
              if (!QLog.isColorLevel()) {
                break label268;
              }
            }
            QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramConfig));
          }
          catch (Exception paramConfig)
          {
            if (QLog.isColorLevel()) {
              QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramConfig));
            }
          }
        }
        label268:
        paramConfig = null;
      }
      else
      {
        paramConfig = paramConfig.content.get().toStringUtf8();
      }
      if (!TextUtils.isEmpty(paramConfig)) {
        SharedPreUtils.f(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), paramConfig);
      } else {
        SharedPreUtils.f(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), null);
      }
      ((QQStoryManager)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER)).a(paramConfig);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("handleQuickShotShareToStoryConfig() configContent = ");
        paramQQAppInterface.append(paramConfig);
        QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig data is null!!!");
    }
    SharedPreUtils.f(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), null);
  }
  
  void i(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = SharedPreUtils.aa(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    byte[] arrayOfByte;
    StringBuilder localStringBuilder;
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {
        if (paramConfig.compress.get() == 1)
        {
          arrayOfByte = OlympicUtil.a(paramConfig.content.get().toByteArray());
          localStringBuilder = null;
          paramConfig = localStringBuilder;
          if (arrayOfByte == null) {
            break label138;
          }
        }
      }
    }
    label138:
    try
    {
      paramConfig = new String(arrayOfByte, "UTF-8");
    }
    catch (Exception paramConfig)
    {
      label112:
      break label112;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "handleQQPreDownYYBConfig|uncompress failed");
    paramConfig = localStringBuilder;
    break label138;
    paramConfig = paramConfig.content.get().toStringUtf8();
    if (paramConfig != null) {
      try
      {
        paramConfig = new JSONObject(paramConfig);
        boolean bool1 = paramConfig.getBoolean("wifiAutoPreDown");
        boolean bool2 = paramConfig.getBoolean("noSafeDown");
        paramConfig = paramQQAppInterface.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(bool1);
        SharedPreUtils.k(paramConfig, "wifiAutoPreDown", localStringBuilder.toString());
        paramConfig = paramQQAppInterface.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(bool2);
        SharedPreUtils.k(paramConfig, "noSafeDown", localStringBuilder.toString());
        SharedPreUtils.z(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  void j(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = SharedPreUtils.X(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    Object localObject;
    String str;
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {
        if (paramConfig.compress.get() == 1)
        {
          localObject = OlympicUtil.a(paramConfig.content.get().toByteArray());
          str = null;
          paramConfig = str;
          if (localObject == null) {
            break label138;
          }
        }
      }
    }
    label138:
    try
    {
      paramConfig = new String((byte[])localObject, "UTF-8");
    }
    catch (Exception paramConfig)
    {
      label112:
      break label112;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoConfig|uncompress failed");
    paramConfig = str;
    break label138;
    paramConfig = paramConfig.content.get().toStringUtf8();
    if (paramConfig != null) {
      try
      {
        localObject = new JSONObject(paramConfig);
        paramConfig = ((JSONObject)localObject).getString("url");
        str = ((JSONObject)localObject).getString("wantWord");
        localObject = ((JSONObject)localObject).getString("thxWord");
        SharedPreUtils.i(paramQQAppInterface.getApp(), "url", paramConfig);
        SharedPreUtils.i(paramQQAppInterface.getApp(), "thxWord", (String)localObject);
        SharedPreUtils.i(paramQQAppInterface.getApp(), "wantWord", str);
        SharedPreUtils.y(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  void k(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 165) {
      return;
    }
    int i = SharedPreUtils.ab(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    byte[] arrayOfByte;
    Object localObject;
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {
        if (paramConfig.compress.get() == 1)
        {
          arrayOfByte = OlympicUtil.a(paramConfig.content.get().toByteArray());
          localObject = null;
          paramConfig = localObject;
          if (arrayOfByte == null) {
            break label152;
          }
        }
      }
    }
    label152:
    try
    {
      paramConfig = new String(arrayOfByte, "UTF-8");
    }
    catch (Exception paramConfig)
    {
      label126:
      break label126;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoConfig|uncompress failed");
    paramConfig = localObject;
    break label152;
    paramConfig = paramConfig.content.get().toStringUtf8();
    if (paramConfig != null) {
      try
      {
        boolean bool = new JSONObject(paramConfig).getBoolean("isShowBuluoNumRedDot");
        SharedPreUtils.A(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        SharedPreUtils.e(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, bool);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  void l(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
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
              Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
              if (localObject1 != null)
              {
                StringBuilder localStringBuilder = null;
                if (((ConfigurationService.Content)localObject1).compress.get() == 1)
                {
                  byte[] arrayOfByte = OlympicUtil.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
                  localObject1 = localStringBuilder;
                  if (arrayOfByte != null) {
                    try
                    {
                      localObject1 = new String(arrayOfByte, "UTF-8");
                    }
                    catch (Exception localException)
                    {
                      localException.printStackTrace();
                      localObject2 = localStringBuilder;
                    }
                  }
                }
                else
                {
                  localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
                }
                if (QLog.isColorLevel())
                {
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("receiveAllConfigs|type: 184, version:");
                  localStringBuilder.append(paramConfig.version.get());
                  localStringBuilder.append(", content:");
                  localStringBuilder.append((String)localObject2);
                  QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
                }
                ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).updatePublicAccountQQMailConfigData(paramQQAppInterface, (String)localObject2, j);
                break label368;
              }
              if (!QLog.isColorLevel()) {
                break label368;
              }
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG remote version: ");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(" | localVersion: ");
              ((StringBuilder)localObject2).append(k);
              QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
              break label368;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG content_list is empty");
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
        return;
      }
      label368:
      i += 1;
    }
  }
  
  void m(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 191) {
      return;
    }
    int i = SharedPreUtils.al(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    Object localObject2;
    if (j != i)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleAppGuideTipsConfig, new version : ");
        ((StringBuilder)localObject1).append(j);
        QLog.i("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
      }
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramConfig != null) {
          if (paramConfig.compress.get() == 1)
          {
            localObject2 = OlympicUtil.a(paramConfig.content.get().toByteArray());
            localObject1 = null;
            paramConfig = (ConfigurationService.Config)localObject1;
            if (localObject2 == null) {
              break label180;
            }
          }
        }
      }
    }
    try
    {
      paramConfig = new String((byte[])localObject2, "UTF-8");
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        paramConfig = (ConfigurationService.Config)localObject1;
      }
    }
    paramConfig = paramConfig.content.get().toStringUtf8();
    label180:
    if (paramConfig != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleAppGuideTipsConfig content");
        ((StringBuilder)localObject1).append(paramConfig);
        QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
      }
      try
      {
        localObject1 = new JSONObject(paramConfig);
        if (((JSONObject)localObject1).length() > 0)
        {
          paramConfig = new ArrayList();
          localObject2 = ((JSONObject)localObject1).keys();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject(str);
            AppGuideTipsConfig localAppGuideTipsConfig = new AppGuideTipsConfig();
            localAppGuideTipsConfig.tipsType = str;
            localAppGuideTipsConfig.switchKey = localJSONObject.getString("switch");
            localAppGuideTipsConfig.maxCount = Integer.valueOf(localJSONObject.getString("total")).intValue();
            localAppGuideTipsConfig.duration = Long.valueOf(localJSONObject.getString("duration")).longValue();
            localAppGuideTipsConfig.tipsUrl = localJSONObject.getString("url");
            localAppGuideTipsConfig.opkey = localJSONObject.getString("opkey");
            localAppGuideTipsConfig.msgTypeStr = localJSONObject.getString("androidtypes");
            boolean bool = "1".equals(str);
            if (bool)
            {
              if (localJSONObject.has("message")) {
                localAppGuideTipsConfig.tipsMsg = localJSONObject.getString("message");
              } else {
                localAppGuideTipsConfig.tipsMsg = localJSONObject.getString("txt");
              }
              if (localJSONObject.has("title")) {
                localAppGuideTipsConfig.tipsHighLight = localJSONObject.getString("title");
              } else {
                localAppGuideTipsConfig.tipsHighLight = localJSONObject.getString("htxt");
              }
            }
            else
            {
              localAppGuideTipsConfig.tipsMsg = localJSONObject.getString("txt");
              localAppGuideTipsConfig.tipsHighLight = localJSONObject.getString("htxt");
            }
            paramConfig.add(localAppGuideTipsConfig);
          }
          localObject1 = (AppGuideTipsManager)paramQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER);
          ((AppGuideTipsManager)localObject1).a(paramConfig);
          ((AppGuideTipsManager)localObject1).a();
          SharedPreUtils.G(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramConfig = new StringBuilder();
        paramConfig.append("handleAppGuideTipsConfig failed");
        paramConfig.append(paramQQAppInterface);
        QLog.e("SPLASH_ConfigServlet", 1, paramConfig.toString());
      }
    }
  }
  
  void n(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 194) {
      return;
    }
    int i = SharedPreUtils.Z(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleTroopPobingConfig reqVersion=");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("version=");
      ((StringBuilder)localObject1).append(j);
      QLog.d("PobingSPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramConfig == null) {
          break label495;
        }
        if (paramConfig.compress.get() == 1)
        {
          localObject2 = OlympicUtil.a(paramConfig.content.get().toByteArray());
          localObject1 = null;
          paramConfig = (ConfigurationService.Config)localObject1;
          if (localObject2 == null) {
            break label222;
          }
        }
      }
    }
    try
    {
      paramConfig = new String((byte[])localObject2, "UTF-8");
    }
    catch (Exception paramConfig)
    {
      label186:
      break label186;
    }
    paramConfig = (ConfigurationService.Config)localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("PobingSPLASH_ConfigServlet", 2, "handleTroopPobingConfig|uncompress failed");
      paramConfig = (ConfigurationService.Config)localObject1;
      break label222;
      paramConfig = paramConfig.content.get().toStringUtf8();
    }
    label222:
    if (paramConfig != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleTroopPobingConfig content");
        ((StringBuilder)localObject1).append(paramConfig);
        QLog.d("Pobing", 1, ((StringBuilder)localObject1).toString());
      }
      if (paramConfig != null)
      {
        try
        {
          localObject2 = new JSONObject(paramConfig);
          localObject1 = ((JSONObject)localObject2).getJSONArray("left");
          localObject2 = ((JSONObject)localObject2).getJSONArray("right");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleTroopPobingConfig content");
            localStringBuilder.append(paramConfig);
            localStringBuilder.append(" left: ");
            localStringBuilder.append(localObject1);
            QLog.d("SPLASH_ConfigServlet", 1, localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleTroopPobingConfig content");
            localStringBuilder.append(paramConfig);
            localStringBuilder.append(" right: ");
            localStringBuilder.append(localObject2);
            QLog.d("SPLASH_ConfigServlet", 1, localStringBuilder.toString());
          }
          TroopManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString, (JSONArray)localObject1, (JSONArray)localObject2);
        }
        catch (Exception paramConfig)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleTroopPobingConfig failed");
          ((StringBuilder)localObject1).append(paramConfig);
          QLog.e("SPLASH_ConfigServlet", 1, ((StringBuilder)localObject1).toString());
        }
        paramConfig = new JSONArray();
        TroopManager.a(paramQQAppInterface, jdField_a_of_type_JavaLangString, paramConfig, paramConfig);
        QLog.i("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig, empty config clear local");
      }
    }
    label495:
    SharedPreUtils.x(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
  }
  
  void o(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 181) {
      return;
    }
    i = SharedPreUtils.ag(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    j = paramConfig.version.get();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleDoutuConfig reqVersion = ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", version=");
      ((StringBuilder)localObject1).append(j);
      QLog.d("DoutuSPLASH_ConfigServlet", 2, ((StringBuilder)localObject1).toString());
    }
    if (i != j)
    {
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuConfigVersion(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = paramConfig.msg_content_list;
        bool1 = false;
        paramConfig = (ConfigurationService.Content)paramConfig.get(0);
        if (paramConfig != null) {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
            if (paramConfig == null) {}
          }
        }
      }
    }
    try
    {
      paramConfig = new String(paramConfig, "UTF-8");
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        label237:
        boolean bool2;
        boolean bool3;
        label1646:
        continue;
        i = 0;
        continue;
        long l1 = 0L;
        continue;
        j = 0;
        continue;
        int k = 0;
        continue;
        paramConfig = null;
        continue;
        localObject1 = null;
        continue;
        long l2 = 0L;
        continue;
        int m = 0;
        continue;
        int n = 0;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        if (k == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if (m == 1) {
          bool3 = true;
        } else {
          bool3 = false;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoutuSPLASH_ConfigServlet", 2, "handleDoutuConfig|uncompress failed");
    }
    paramConfig = null;
    break label237;
    paramConfig = paramConfig.content.get().toStringUtf8();
    if (paramConfig != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleDoutuConfig content");
        ((StringBuilder)localObject1).append(paramConfig);
        QLog.d("Doutu", 1, ((StringBuilder)localObject1).toString());
      }
      try
      {
        Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramConfig.getBytes("utf-8")));
        paramConfig = ((Document)localObject2).getElementsByTagName("doutu_config");
        if ((paramConfig == null) || (paramConfig.getLength() <= 0)) {
          break label1646;
        }
        if ((((Document)localObject2).getElementsByTagName("entry") == null) || (((Document)localObject2).getElementsByTagName("entry").item(0) == null)) {
          break label1651;
        }
        i = Integer.parseInt(((Document)localObject2).getElementsByTagName("entry").item(0).getFirstChild().getNodeValue());
        paramConfig = ((Document)localObject2).getElementsByTagName("timeGap");
        long l4 = 0L;
        if ((paramConfig == null) || (((Document)localObject2).getElementsByTagName("timeGap").item(0) == null)) {
          break label1656;
        }
        l1 = Long.parseLong(((Document)localObject2).getElementsByTagName("timeGap").item(0).getFirstChild().getNodeValue());
        if ((((Document)localObject2).getElementsByTagName("duiTimes") == null) || (((Document)localObject2).getElementsByTagName("duiTimes").item(0) == null)) {
          break label1662;
        }
        j = Integer.parseInt(((Document)localObject2).getElementsByTagName("duiTimes").item(0).getFirstChild().getNodeValue());
        if ((((Document)localObject2).getElementsByTagName("entryCombo") == null) || (((Document)localObject2).getElementsByTagName("entryCombo").item(0) == null)) {
          break label1668;
        }
        k = Integer.parseInt(((Document)localObject2).getElementsByTagName("entryCombo").item(0).getFirstChild().getNodeValue());
        if ((((Document)localObject2).getElementsByTagName("resUrl") == null) || (((Document)localObject2).getElementsByTagName("resUrl").item(0) == null)) {
          break label1674;
        }
        paramConfig = ((Document)localObject2).getElementsByTagName("resUrl").item(0).getFirstChild().getNodeValue();
        if ((((Document)localObject2).getElementsByTagName("resMd5") == null) || (((Document)localObject2).getElementsByTagName("resMd5").item(0) == null)) {
          break label1679;
        }
        localObject1 = ((Document)localObject2).getElementsByTagName("resMd5").item(0).getFirstChild().getNodeValue();
        if ((((Document)localObject2).getElementsByTagName("comboDuration") == null) || (((Document)localObject2).getElementsByTagName("comboDuration").item(0) == null)) {
          break label1685;
        }
        l2 = Long.parseLong(((Document)localObject2).getElementsByTagName("comboDuration").item(0).getFirstChild().getNodeValue());
        l3 = l4;
        if (((Document)localObject2).getElementsByTagName("comboKeep") != null)
        {
          l3 = l4;
          if (((Document)localObject2).getElementsByTagName("comboKeep").item(0) != null) {
            l3 = Long.parseLong(((Document)localObject2).getElementsByTagName("comboKeep").item(0).getFirstChild().getNodeValue());
          }
        }
        if ((((Document)localObject2).getElementsByTagName("recommendSwitch") == null) || (((Document)localObject2).getElementsByTagName("recommendSwitch").item(0) == null)) {
          break label1691;
        }
        m = Integer.parseInt(((Document)localObject2).getElementsByTagName("recommendSwitch").item(0).getFirstChild().getNodeValue());
        if ((((Document)localObject2).getElementsByTagName("smartHeadPicCount") == null) || (((Document)localObject2).getElementsByTagName("smartHeadPicCount").item(0) == null)) {
          break label1697;
        }
        n = Integer.parseInt(((Document)localObject2).getElementsByTagName("smartHeadPicCount").item(0).getFirstChild().getNodeValue());
        localObject2 = (IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class);
        BaseApplication localBaseApplication = paramQQAppInterface.getApp();
        String str = jdField_a_of_type_JavaLangString;
        if (i == 1) {
          bool1 = true;
        }
        ((IDoutuSPUtil)localObject2).updateDoutuSwitch(localBaseApplication, str, bool1);
        ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuDuration(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l1);
        ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDuiTimes(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
        localObject2 = (IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class);
        localBaseApplication = paramQQAppInterface.getApp();
        str = jdField_a_of_type_JavaLangString;
        if (k != 1) {
          break label1703;
        }
        bool1 = true;
        ((IDoutuSPUtil)localObject2).updateDoutuComboSwitch(localBaseApplication, str, bool1);
        localObject2 = (IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class);
        localBaseApplication = paramQQAppInterface.getApp();
        str = jdField_a_of_type_JavaLangString;
        if (m != 1) {
          break label1709;
        }
        bool1 = true;
        ((IDoutuSPUtil)localObject2).updateDoutuSmartSwitchNew(localBaseApplication, str, bool1);
        if (paramConfig != null) {
          ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuResUrl(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
        }
        if (localObject1 != null) {
          ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuResMd5(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, (String)localObject1);
        }
        ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateComboDuration(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l2);
        ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateComboKeep(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, l3);
        ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateSmartPicCount(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, n);
        paramConfig = (IDoutuService)paramQQAppInterface.getRuntimeService(IDoutuService.class, "");
        if (paramConfig == null) {
          break label1646;
        }
        paramConfig.setApp(paramQQAppInterface);
        if (i != 1) {
          break label1715;
        }
        bool1 = true;
      }
      catch (Exception paramQQAppInterface)
      {
        long l3;
        paramConfig = new StringBuilder();
        paramConfig.append("handleDoutuConfig failed");
        paramConfig.append(paramQQAppInterface);
        QLog.e("HotPicManager", 1, paramConfig.toString());
        return;
      }
      paramConfig.updataDoutuConfig(bool1, bool2, l1, l2, l3, bool3, n);
      paramConfig.doOnLogin(true);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Doutu", 1, "handleDoutuConfig content is null");
      }
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuSwitch(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuDuration(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuComboSwitch(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuSmartSwitchNew(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuResUrl(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuResMd5(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeComboDuration(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeComboKeep(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeSmartPicCount(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuSmartSwitchNew(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDuiTimes(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    }
  }
  
  void p(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 247) {
      return;
    }
    int i = SharedPreUtils.t(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGreenVideoConfig reqVersion = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", version=");
      localStringBuilder.append(j);
      QLog.d("GreenVideoSPLASH_ConfigServlet", 2, localStringBuilder.toString());
    }
    byte[] arrayOfByte;
    if (i != j)
    {
      SharedPreUtils.f(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramConfig != null) {
          if (paramConfig.compress.get() == 1)
          {
            arrayOfByte = OlympicUtil.a(paramConfig.content.get().toByteArray());
            localStringBuilder = null;
            paramConfig = localStringBuilder;
            if (arrayOfByte == null) {
              break label234;
            }
          }
        }
      }
    }
    try
    {
      paramConfig = new String(arrayOfByte, "UTF-8");
    }
    catch (Exception paramConfig)
    {
      label198:
      break label198;
    }
    paramConfig = localStringBuilder;
    if (QLog.isColorLevel())
    {
      QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig|uncompress failed");
      paramConfig = localStringBuilder;
      break label234;
      paramConfig = paramConfig.content.get().toStringUtf8();
    }
    label234:
    if (paramConfig != null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleGreenVideoConfig content : ");
        localStringBuilder.append(paramConfig);
        QLog.d("GreenVideo", 1, localStringBuilder.toString());
      }
      SharedPreUtils.e(paramQQAppInterface.getApp(), paramConfig);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GreenVideo", 1, "handleGreenVideoConfig content is null");
    }
    SharedPreUtils.a(paramQQAppInterface.getApp());
  }
  
  /* Error */
  void q(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 2250	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 272
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 1463	com/tencent/mobileqq/utils/SharedPreUtils:v	(Landroid/content/Context;Ljava/lang/String;)I
    //   24: istore_3
    //   25: aload_2
    //   26: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   29: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   32: istore 4
    //   34: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +56 -> 93
    //   40: new 77	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   47: astore 5
    //   49: aload 5
    //   51: ldc_w 5299
    //   54: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 5
    //   60: iload_3
    //   61: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 5
    //   67: ldc_w 5180
    //   70: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 5
    //   76: iload 4
    //   78: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 91
    //   84: iconst_2
    //   85: aload 5
    //   87: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: iload_3
    //   94: iload 4
    //   96: if_icmpeq +826 -> 922
    //   99: aload_1
    //   100: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   103: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: iload 4
    //   108: invokestatic 1449	com/tencent/mobileqq/utils/SharedPreUtils:h	(Landroid/content/Context;Ljava/lang/String;I)V
    //   111: aload_2
    //   112: getfield 387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   115: ifnull +807 -> 922
    //   118: aload_2
    //   119: getfield 387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   122: invokevirtual 390	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   125: ifle +797 -> 922
    //   128: aload_2
    //   129: getfield 387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   132: iconst_0
    //   133: invokevirtual 393	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   136: checkcast 395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   139: astore_2
    //   140: aload_2
    //   141: ifnull +781 -> 922
    //   144: aload_2
    //   145: getfield 399	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   148: invokevirtual 402	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   151: iconst_1
    //   152: if_icmpne +56 -> 208
    //   155: aload_2
    //   156: getfield 406	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   159: invokevirtual 411	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   162: invokevirtual 417	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   165: invokestatic 422	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +33 -> 203
    //   173: new 125	java/lang/String
    //   176: dup
    //   177: aload_2
    //   178: ldc_w 424
    //   181: invokespecial 427	java/lang/String:<init>	([BLjava/lang/String;)V
    //   184: astore_2
    //   185: goto +34 -> 219
    //   188: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +12 -> 203
    //   194: ldc 91
    //   196: iconst_2
    //   197: ldc_w 5301
    //   200: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aconst_null
    //   204: astore_2
    //   205: goto +14 -> 219
    //   208: aload_2
    //   209: getfield 406	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   212: invokevirtual 411	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   215: invokevirtual 441	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   218: astore_2
    //   219: aload_2
    //   220: ifnull +677 -> 897
    //   223: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +39 -> 265
    //   229: new 77	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   236: astore 5
    //   238: aload 5
    //   240: ldc_w 5303
    //   243: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 5
    //   249: aload_2
    //   250: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: ldc 91
    //   256: iconst_2
    //   257: aload 5
    //   259: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: invokestatic 798	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   268: invokevirtual 802	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   271: new 804	java/io/ByteArrayInputStream
    //   274: dup
    //   275: aload_2
    //   276: ldc_w 806
    //   279: invokevirtual 810	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   282: invokespecial 813	java/io/ByteArrayInputStream:<init>	([B)V
    //   285: invokevirtual 818	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   288: astore_2
    //   289: aload_2
    //   290: ldc_w 5305
    //   293: invokeinterface 826 2 0
    //   298: astore 5
    //   300: aload 5
    //   302: ifnull +620 -> 922
    //   305: aload 5
    //   307: invokeinterface 831 1 0
    //   312: ifle +610 -> 922
    //   315: new 77	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   322: astore 5
    //   324: aload_2
    //   325: ldc_w 5307
    //   328: invokeinterface 826 2 0
    //   333: ifnull +42 -> 375
    //   336: aload 5
    //   338: aload_2
    //   339: ldc_w 5307
    //   342: invokeinterface 826 2 0
    //   347: iconst_0
    //   348: invokeinterface 837 2 0
    //   353: invokeinterface 843 1 0
    //   358: invokeinterface 846 1 0
    //   363: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 5
    //   369: bipush 124
    //   371: invokevirtual 952	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload_2
    //   376: ldc_w 5309
    //   379: invokeinterface 826 2 0
    //   384: ifnull +42 -> 426
    //   387: aload 5
    //   389: aload_2
    //   390: ldc_w 5309
    //   393: invokeinterface 826 2 0
    //   398: iconst_0
    //   399: invokeinterface 837 2 0
    //   404: invokeinterface 843 1 0
    //   409: invokeinterface 846 1 0
    //   414: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 5
    //   420: bipush 124
    //   422: invokevirtual 952	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_2
    //   427: ldc_w 5311
    //   430: invokeinterface 826 2 0
    //   435: ifnull +42 -> 477
    //   438: aload 5
    //   440: aload_2
    //   441: ldc_w 5311
    //   444: invokeinterface 826 2 0
    //   449: iconst_0
    //   450: invokeinterface 837 2 0
    //   455: invokeinterface 843 1 0
    //   460: invokeinterface 846 1 0
    //   465: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 5
    //   471: bipush 124
    //   473: invokevirtual 952	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload_2
    //   478: ldc_w 5313
    //   481: invokeinterface 826 2 0
    //   486: ifnull +42 -> 528
    //   489: aload 5
    //   491: aload_2
    //   492: ldc_w 5313
    //   495: invokeinterface 826 2 0
    //   500: iconst_0
    //   501: invokeinterface 837 2 0
    //   506: invokeinterface 843 1 0
    //   511: invokeinterface 846 1 0
    //   516: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload 5
    //   522: bipush 124
    //   524: invokevirtual 952	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload_2
    //   529: ldc_w 5315
    //   532: invokeinterface 826 2 0
    //   537: ifnull +42 -> 579
    //   540: aload 5
    //   542: aload_2
    //   543: ldc_w 5315
    //   546: invokeinterface 826 2 0
    //   551: iconst_0
    //   552: invokeinterface 837 2 0
    //   557: invokeinterface 843 1 0
    //   562: invokeinterface 846 1 0
    //   567: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload 5
    //   573: bipush 124
    //   575: invokevirtual 952	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload_2
    //   580: ldc_w 5317
    //   583: invokeinterface 826 2 0
    //   588: ifnull +60 -> 648
    //   591: aload_2
    //   592: ldc_w 5317
    //   595: invokeinterface 826 2 0
    //   600: iconst_0
    //   601: invokeinterface 837 2 0
    //   606: ifnull +42 -> 648
    //   609: aload 5
    //   611: aload_2
    //   612: ldc_w 5317
    //   615: invokeinterface 826 2 0
    //   620: iconst_0
    //   621: invokeinterface 837 2 0
    //   626: invokeinterface 843 1 0
    //   631: invokeinterface 846 1 0
    //   636: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 5
    //   642: bipush 124
    //   644: invokevirtual 952	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload_2
    //   649: ldc_w 5319
    //   652: invokeinterface 826 2 0
    //   657: ifnull +60 -> 717
    //   660: aload_2
    //   661: ldc_w 5319
    //   664: invokeinterface 826 2 0
    //   669: iconst_0
    //   670: invokeinterface 837 2 0
    //   675: ifnull +42 -> 717
    //   678: aload 5
    //   680: aload_2
    //   681: ldc_w 5319
    //   684: invokeinterface 826 2 0
    //   689: iconst_0
    //   690: invokeinterface 837 2 0
    //   695: invokeinterface 843 1 0
    //   700: invokeinterface 846 1 0
    //   705: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload 5
    //   711: bipush 124
    //   713: invokevirtual 952	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   716: pop
    //   717: aload_2
    //   718: ldc_w 5321
    //   721: invokeinterface 826 2 0
    //   726: ifnull +60 -> 786
    //   729: aload_2
    //   730: ldc_w 5321
    //   733: invokeinterface 826 2 0
    //   738: iconst_0
    //   739: invokeinterface 837 2 0
    //   744: ifnull +42 -> 786
    //   747: aload 5
    //   749: aload_2
    //   750: ldc_w 5321
    //   753: invokeinterface 826 2 0
    //   758: iconst_0
    //   759: invokeinterface 837 2 0
    //   764: invokeinterface 843 1 0
    //   769: invokeinterface 846 1 0
    //   774: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload 5
    //   780: bipush 124
    //   782: invokevirtual 952	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload_2
    //   787: ldc_w 5323
    //   790: invokeinterface 826 2 0
    //   795: ifnull +52 -> 847
    //   798: aload_2
    //   799: ldc_w 5323
    //   802: invokeinterface 826 2 0
    //   807: iconst_0
    //   808: invokeinterface 837 2 0
    //   813: ifnull +34 -> 847
    //   816: aload 5
    //   818: aload_2
    //   819: ldc_w 5323
    //   822: invokeinterface 826 2 0
    //   827: iconst_0
    //   828: invokeinterface 837 2 0
    //   833: invokeinterface 843 1 0
    //   838: invokeinterface 846 1 0
    //   843: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: aload_1
    //   848: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   851: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   854: aload 5
    //   856: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   859: invokestatic 5325	com/tencent/mobileqq/utils/SharedPreUtils:m	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   862: return
    //   863: astore_1
    //   864: new 77	java/lang/StringBuilder
    //   867: dup
    //   868: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   871: astore_2
    //   872: aload_2
    //   873: ldc_w 5327
    //   876: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: aload_2
    //   881: aload_1
    //   882: invokevirtual 889	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: ldc 91
    //   888: iconst_1
    //   889: aload_2
    //   890: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   893: invokestatic 531	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   896: return
    //   897: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq +12 -> 912
    //   903: ldc 91
    //   905: iconst_2
    //   906: ldc_w 5329
    //   909: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   912: aload_1
    //   913: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   916: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   919: invokestatic 5331	com/tencent/mobileqq/utils/SharedPreUtils:k	(Landroid/content/Context;Ljava/lang/String;)V
    //   922: return
    //   923: astore_2
    //   924: goto -736 -> 188
    //   927: astore 6
    //   929: goto -554 -> 375
    //   932: astore 6
    //   934: goto -508 -> 426
    //   937: astore 6
    //   939: goto -462 -> 477
    //   942: astore 6
    //   944: goto -416 -> 528
    //   947: astore 6
    //   949: goto -370 -> 579
    //   952: astore 6
    //   954: goto -306 -> 648
    //   957: astore 6
    //   959: goto -242 -> 717
    //   962: astore 6
    //   964: goto -178 -> 786
    //   967: astore_2
    //   968: goto -121 -> 847
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	971	0	this	ConfigServlet
    //   0	971	1	paramQQAppInterface	QQAppInterface
    //   0	971	2	paramConfig	ConfigurationService.Config
    //   24	73	3	i	int
    //   32	75	4	j	int
    //   47	808	5	localObject	Object
    //   927	1	6	localThrowable1	Throwable
    //   932	1	6	localThrowable2	Throwable
    //   937	1	6	localThrowable3	Throwable
    //   942	1	6	localThrowable4	Throwable
    //   947	1	6	localThrowable5	Throwable
    //   952	1	6	localThrowable6	Throwable
    //   957	1	6	localThrowable7	Throwable
    //   962	1	6	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   265	300	863	java/lang/Exception
    //   305	324	863	java/lang/Exception
    //   324	375	863	java/lang/Exception
    //   375	426	863	java/lang/Exception
    //   426	477	863	java/lang/Exception
    //   477	528	863	java/lang/Exception
    //   528	579	863	java/lang/Exception
    //   579	648	863	java/lang/Exception
    //   648	717	863	java/lang/Exception
    //   717	786	863	java/lang/Exception
    //   786	847	863	java/lang/Exception
    //   847	862	863	java/lang/Exception
    //   173	185	923	java/lang/Exception
    //   324	375	927	java/lang/Throwable
    //   375	426	932	java/lang/Throwable
    //   426	477	937	java/lang/Throwable
    //   477	528	942	java/lang/Throwable
    //   528	579	947	java/lang/Throwable
    //   579	648	952	java/lang/Throwable
    //   648	717	957	java/lang/Throwable
    //   717	786	962	java/lang/Throwable
    //   786	847	967	java/lang/Throwable
  }
  
  void r(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j = ((ISttManagerApi)QRoute.api(ISttManagerApi.class)).getConfigVersion(paramQQAppInterface);
    int i = paramConfig.version.get();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handlePttSttConfig l :");
      localStringBuilder.append(j);
      localStringBuilder.append(" s : ");
      localStringBuilder.append(i);
      QLog.i("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
    }
    if (j != i)
    {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramConfig != null)
        {
          if (paramConfig.compress.get() == 1)
          {
            Object localObject = OlympicUtil.a(paramConfig.content.get().toByteArray());
            localStringBuilder = null;
            paramConfig = localStringBuilder;
            if (localObject != null) {
              try
              {
                paramConfig = new String((byte[])localObject, "UTF-8");
              }
              catch (Exception paramConfig)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("handleHotPicConfig|uncompress failed");
                ((StringBuilder)localObject).append(paramConfig);
                QLog.e("SPLASH_ConfigServlet", 1, ((StringBuilder)localObject).toString());
                paramConfig = localStringBuilder;
              }
            }
          }
          else
          {
            paramConfig = paramConfig.content.get().toStringUtf8();
          }
          if (paramConfig != null) {
            try
            {
              j = new JSONObject(paramConfig).getInt("pttSttAbility");
              ((ISttManagerApi)QRoute.api(ISttManagerApi.class)).saveSttAbilityV2Config(j, paramQQAppInterface);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("handlePttSttConfig content");
              localStringBuilder.append(paramConfig);
              localStringBuilder.append(" flag ");
              localStringBuilder.append(j);
              QLog.i("SPLASH_ConfigServlet", 1, localStringBuilder.toString());
            }
            catch (Exception paramConfig)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("handlePttSttConfig failed");
              localStringBuilder.append(paramConfig);
              QLog.e("SPLASH_ConfigServlet", 1, localStringBuilder.toString());
            }
          }
        }
      }
      else
      {
        QLog.i("SPLASH_ConfigServlet", 1, "handlePttSttConfig no config");
        ((ISttManagerApi)QRoute.api(ISttManagerApi.class)).saveSttAbilityV2Config(0, paramQQAppInterface);
      }
      ((ISttManagerApi)QRoute.api(ISttManagerApi.class)).saveConfigVersion(paramQQAppInterface, i);
    }
  }
  
  protected void s(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        int j = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(0))).intValue();
        int k = paramConfig.version.get();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleNearbyTabsConfig, l :");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(" s : ");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append("content_list_size=");
        int i;
        if (paramConfig.msg_content_list == null) {
          i = 0;
        } else {
          i = paramConfig.msg_content_list.size();
        }
        ((StringBuilder)localObject1).append(i);
        QLog.d("Q.nearby.tab_nearby_tab_config", 1, ((StringBuilder)localObject1).toString());
        if ((j != k) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.msg_content_list.size())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("content task_id :");
            ((StringBuilder)localObject1).append(((ConfigurationService.Content)paramConfig.msg_content_list.get(i)).task_id.get());
            QLog.d("Q.nearby.tab_nearby_tab_config", 1, ((StringBuilder)localObject1).toString());
            i += 1;
            continue;
          }
          localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          if (localObject1 != null)
          {
            Object localObject3;
            if (((ConfigurationService.Content)localObject1).compress.get() == 1)
            {
              localObject1 = OlympicUtil.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
              if (localObject1 == null) {
                break label1064;
              }
              try
              {
                localObject1 = new String((byte[])localObject1, "UTF-8");
              }
              catch (Exception localException)
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("handleNearbyTabsConfig|uncompress failed");
                ((StringBuilder)localObject3).append(localException);
                QLog.e("Q.nearby.tab_nearby_tab_config", 1, ((StringBuilder)localObject3).toString());
                break label1064;
              }
            }
            else
            {
              localObject2 = localException.content.get().toStringUtf8();
            }
            if (localObject2 != null)
            {
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("handleNearbyTabsConfig content");
                ((StringBuilder)localObject3).append((String)localObject2);
                QLog.i("Q.nearby.tab_nearby_tab_config", 1, ((StringBuilder)localObject3).toString());
              }
              try
              {
                localObject2 = new JSONObject((String)localObject2);
                localObject3 = ((JSONObject)localObject2).optJSONArray("tabs");
                if (((JSONArray)localObject3).length() > 0) {
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "key_tabs_array", ((JSONArray)localObject3).toString());
                }
                localObject3 = ((JSONObject)localObject2).optJSONObject("werewolves");
                if (localObject3 != null) {
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "werewolves_config", ((JSONObject)localObject3).toString());
                }
                i = ((JSONObject)localObject2).optInt("AutoEnterWithoutReddot");
                if (localObject3 != null) {
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "key_auto_enter_without_redot", Integer.valueOf(i));
                }
                localObject3 = ((JSONObject)localObject2).optJSONObject("now_nearby");
                if (localObject3 != null)
                {
                  i = ((JSONObject)localObject3).optInt("match_secs");
                  j = ((JSONObject)localObject3).optInt("match_times");
                  k = ((JSONObject)localObject3).optInt("open_switch");
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "now_nearby_match_secs", Integer.valueOf(i));
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "now_nearby_match_times", Integer.valueOf(j));
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "now_nearby_1v1_open_switch", Integer.valueOf(k));
                }
                localObject3 = ((JSONObject)localObject2).optJSONArray("banner_items");
                if (localObject3 != null) {
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "key_banner_enter_items", ((JSONArray)localObject3).toString());
                } else {
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "key_banner_enter_items", "");
                }
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "key_tabs_config_version", Integer.valueOf(paramConfig.version.get()));
                i = ((JSONObject)localObject2).optInt("nearby_usercard_tab_host", 0);
                j = ((JSONObject)localObject2).optInt("nearby_usercard_tab_guest", -1);
                k = ((JSONObject)localObject2).optInt("nearby_usercard_publish", 0);
                int m = ((JSONObject)localObject2).optInt("face_score_switch", 0);
                paramConfig = ((JSONObject)localObject2).optString("mine_page_url");
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "nearby_usercard_tab_host", Integer.valueOf(i));
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "nearby_usercard_tab_guest", Integer.valueOf(j));
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "nearby_usercard_publish", Integer.valueOf(k));
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "face_score_switch", Integer.valueOf(m));
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "nearby_mine_page_url", paramConfig);
                i = ((JSONObject)localObject2).optInt("now_ip_conn_switch");
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "now_ip_conn_switch", Integer.valueOf(i));
                paramConfig = ((JSONObject)localObject2).optJSONObject("nearby_guide_config");
                if (paramConfig != null) {
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(jdField_a_of_type_JavaLangString, "cike_guide_content", paramConfig.toString());
                }
                paramQQAppInterface.notifyObservers(NearbyEnterUpdateObserver.class, 1, true, null);
                return;
              }
              catch (Exception paramQQAppInterface)
              {
                paramConfig = new StringBuilder();
                paramConfig.append("handleNearbyTabsConfig failed");
                paramConfig.append(paramQQAppInterface);
                QLog.e("Q.nearby.tab_nearby_tab_config", 1, paramConfig.toString());
                return;
              }
            }
          }
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("Q.nearby.tab_nearby_tab_config", 1, "handleNearbyTabsConfig exp:", paramQQAppInterface);
      }
      label1064:
      Object localObject2 = null;
    }
  }
  
  void t(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    QLog.i("Contact.RecommendTabConfig", 1, String.format("receive handleContactRecommendTabConfig", new Object[0]));
    if (paramConfig.type.get() != 371) {
      return;
    }
    int j = SharedPreUtils.ae(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int i = paramConfig.version.get();
    if (j == i)
    {
      QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, req-version equals to rsp-version, ver=%d", new Object[] { Integer.valueOf(j) }));
      return;
    }
    j = paramConfig.msg_content_list.size();
    StringBuilder localStringBuilder = null;
    byte[] arrayOfByte;
    if (j > 0)
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {
        if (paramConfig.compress.get() == 1)
        {
          arrayOfByte = OlympicUtil.a(paramConfig.content.get().toByteArray());
          paramConfig = localStringBuilder;
          if (arrayOfByte == null) {
            break label255;
          }
        }
      }
    }
    try
    {
      paramConfig = new String(arrayOfByte, "UTF-8");
    }
    catch (Exception paramConfig)
    {
      label166:
      break label166;
    }
    QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, uncompress failed, buf-len=%d", new Object[] { Integer.valueOf(arrayOfByte.length) }));
    paramConfig = localStringBuilder;
    break label255;
    paramConfig = paramConfig.content.get().toStringUtf8();
    break label255;
    QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, content is null", new Object[0]));
    paramConfig = localStringBuilder;
    break label255;
    QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, msg content list is empty", new Object[0]));
    paramConfig = localStringBuilder;
    label255:
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleContactRecommendTabConfig config_content:");
      localStringBuilder.append(paramConfig);
      QLog.i("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
    }
    SharedPreUtils.l(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, paramConfig);
    SharedPreUtils.D(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, i);
  }
  
  /* Error */
  void u(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: ldc_w 5449
    //   6: iconst_1
    //   7: ldc_w 5451
    //   10: iconst_0
    //   11: anewarray 4	java/lang/Object
    //   14: invokestatic 549	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   17: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: aload_1
    //   21: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   24: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokestatic 1620	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   30: istore_3
    //   31: aload_2
    //   32: getfield 49	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   35: invokevirtual 55	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   38: istore 8
    //   40: iload_3
    //   41: iload 8
    //   43: if_icmpeq +450 -> 493
    //   46: new 242	java/util/HashSet
    //   49: dup
    //   50: invokespecial 243	java/util/HashSet:<init>	()V
    //   53: astore 10
    //   55: aload_2
    //   56: getfield 387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   59: ifnull +399 -> 458
    //   62: aload_2
    //   63: getfield 387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   66: invokevirtual 390	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   69: ifle +389 -> 458
    //   72: aload_2
    //   73: getfield 387	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   76: iconst_0
    //   77: invokevirtual 393	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   80: checkcast 395	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull +360 -> 445
    //   88: aload_2
    //   89: getfield 406	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   92: invokevirtual 1030	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   95: ifeq +350 -> 445
    //   98: aload_2
    //   99: getfield 399	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   102: invokevirtual 402	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   105: iconst_1
    //   106: if_icmpne +89 -> 195
    //   109: aload_2
    //   110: getfield 406	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   113: invokevirtual 411	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   116: invokevirtual 417	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   119: invokestatic 422	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   122: astore 11
    //   124: aconst_null
    //   125: astore 9
    //   127: aload 9
    //   129: astore_2
    //   130: aload 11
    //   132: ifnull +74 -> 206
    //   135: new 125	java/lang/String
    //   138: dup
    //   139: aload 11
    //   141: ldc_w 424
    //   144: invokespecial 427	java/lang/String:<init>	([BLjava/lang/String;)V
    //   147: astore_2
    //   148: goto +58 -> 206
    //   151: astore_2
    //   152: new 77	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   159: astore 11
    //   161: aload 11
    //   163: ldc_w 5453
    //   166: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 11
    //   172: aload_2
    //   173: invokevirtual 889	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc_w 5449
    //   180: iconst_1
    //   181: aload 11
    //   183: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 531	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload 9
    //   191: astore_2
    //   192: goto +14 -> 206
    //   195: aload_2
    //   196: getfield 406	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   199: invokevirtual 411	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   202: invokevirtual 441	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   205: astore_2
    //   206: aload_2
    //   207: ifnull +273 -> 480
    //   210: new 127	org/json/JSONObject
    //   213: dup
    //   214: aload_2
    //   215: invokespecial 130	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   218: astore 9
    //   220: new 77	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   227: astore 11
    //   229: aload 11
    //   231: ldc_w 5455
    //   234: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 11
    //   240: aload_2
    //   241: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: ldc_w 5449
    //   248: iconst_1
    //   249: aload 11
    //   251: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload 9
    //   259: ldc_w 5457
    //   262: invokevirtual 140	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   265: istore_3
    //   266: aload 9
    //   268: ldc_w 5459
    //   271: invokevirtual 140	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   274: istore 4
    //   276: aload 9
    //   278: ldc_w 5461
    //   281: invokevirtual 261	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   284: astore_2
    //   285: iload_3
    //   286: istore 6
    //   288: iload 4
    //   290: istore 5
    //   292: aload_2
    //   293: ifnull +135 -> 428
    //   296: iload_3
    //   297: istore 6
    //   299: iload 4
    //   301: istore 5
    //   303: aload_2
    //   304: invokevirtual 266	org/json/JSONArray:length	()I
    //   307: ifle +121 -> 428
    //   310: iload_3
    //   311: istore 6
    //   313: iload 4
    //   315: istore 5
    //   317: iload 7
    //   319: aload_2
    //   320: invokevirtual 266	org/json/JSONArray:length	()I
    //   323: if_icmpge +105 -> 428
    //   326: aload_2
    //   327: iload 7
    //   329: invokevirtual 5462	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   332: checkcast 127	org/json/JSONObject
    //   335: ldc_w 5464
    //   338: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   341: astore 9
    //   343: aload 9
    //   345: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   348: ifne +13 -> 361
    //   351: aload 10
    //   353: aload 9
    //   355: invokeinterface 4711 2 0
    //   360: pop
    //   361: iload 7
    //   363: iconst_1
    //   364: iadd
    //   365: istore 7
    //   367: goto -57 -> 310
    //   370: astore_2
    //   371: goto +13 -> 384
    //   374: astore_2
    //   375: goto +6 -> 381
    //   378: astore_2
    //   379: iconst_0
    //   380: istore_3
    //   381: iconst_0
    //   382: istore 4
    //   384: new 77	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   391: astore 9
    //   393: aload 9
    //   395: ldc_w 5349
    //   398: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 9
    //   404: aload_2
    //   405: invokevirtual 889	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: ldc_w 5449
    //   412: iconst_1
    //   413: aload 9
    //   415: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 531	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: iload 4
    //   423: istore 5
    //   425: iload_3
    //   426: istore 6
    //   428: aload_1
    //   429: invokestatic 5467	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager;
    //   432: aload_1
    //   433: iload 6
    //   435: iload 5
    //   437: aload 10
    //   439: invokevirtual 5470	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   442: goto +38 -> 480
    //   445: ldc_w 5449
    //   448: iconst_1
    //   449: ldc_w 5472
    //   452: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: goto +25 -> 480
    //   458: ldc_w 5449
    //   461: iconst_1
    //   462: ldc_w 5474
    //   465: invokestatic 99	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aload_1
    //   469: invokestatic 5467	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager;
    //   472: aload_1
    //   473: iconst_0
    //   474: iconst_0
    //   475: aload 10
    //   477: invokevirtual 5470	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   480: aload_1
    //   481: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   484: getstatic 63	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   487: iload 8
    //   489: invokestatic 5475	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   492: return
    //   493: ldc_w 5449
    //   496: iconst_1
    //   497: ldc_w 5477
    //   500: iconst_1
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: iload_3
    //   507: invokestatic 545	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   510: aastore
    //   511: invokestatic 549	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   514: invokestatic 531	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	this	ConfigServlet
    //   0	518	1	paramQQAppInterface	QQAppInterface
    //   0	518	2	paramConfig	ConfigurationService.Config
    //   30	477	3	i	int
    //   274	148	4	j	int
    //   290	146	5	k	int
    //   286	148	6	m	int
    //   1	365	7	n	int
    //   38	450	8	i1	int
    //   125	289	9	localObject1	Object
    //   53	423	10	localHashSet	HashSet
    //   122	128	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   135	148	151	java/lang/Exception
    //   276	285	370	java/lang/Exception
    //   303	310	370	java/lang/Exception
    //   317	361	370	java/lang/Exception
    //   266	276	374	java/lang/Exception
    //   210	266	378	java/lang/Exception
  }
  
  void w(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new ConfigServlet.11(this, paramConfig, paramQQAppInterface));
  }
  
  void x(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = SharedPreUtils.ai(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString);
    int j = paramConfig.version.get();
    Object localObject2 = null;
    Object localObject1 = null;
    if (i != j)
    {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if ((paramConfig != null) && (paramConfig.content.has()))
        {
          if (paramConfig.compress.get() == 1)
          {
            localObject2 = OlympicUtil.a(paramConfig.content.get().toByteArray());
            paramConfig = localObject1;
            if (localObject2 != null) {
              try
              {
                paramConfig = new String((byte[])localObject2, "UTF-8");
              }
              catch (Exception paramConfig)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("handleCUOpenCardGuideConfig|uncompress failed");
                ((StringBuilder)localObject2).append(paramConfig);
                QLog.e("SPLASH_ConfigServlet", 1, ((StringBuilder)localObject2).toString());
                paramConfig = localObject1;
              }
            }
          }
          else
          {
            paramConfig = paramConfig.content.get().toStringUtf8();
          }
        }
        else
        {
          paramConfig = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig empty content", new Object[0]));
            paramConfig = localObject1;
          }
        }
      }
      else
      {
        paramConfig = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig empty config", new Object[0]));
          paramConfig = localObject1;
        }
      }
      SharedPreUtils.F(paramQQAppInterface.getApp(), jdField_a_of_type_JavaLangString, j);
      ((CUOpenCardGuideMng)paramQQAppInterface.getManager(QQManagerFactory.CU_OPEN_CARD_GUIDE_MANAGER)).a(paramConfig);
    }
    else
    {
      paramConfig = (ConfigurationService.Config)localObject2;
      if (QLog.isColorLevel())
      {
        QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig same version, no need to update", new Object[0]));
        paramConfig = (ConfigurationService.Config)localObject2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig reqVer: %d rspVer: %d config: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramConfig }));
    }
  }
  
  public void z(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    boolean bool;
    Object localObject;
    if (i != paramQQAppInterface.getPreferences().getInt("tim_upgrade_hongdian_version", 0))
    {
      long l1 = System.currentTimeMillis();
      bool = PackageUtil.a(paramQQAppInterface.getApp(), "com.tencent.tim");
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("is install TIM = ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" time cost = ");
        ((StringBuilder)localObject).append(l2 - l1);
        QLog.d("TimUpgradeHondianManager", 2, ((StringBuilder)localObject).toString());
      }
      if (!bool)
      {
        paramConfig = a(paramConfig);
        if ((paramConfig == null) || (paramConfig.size() <= 0)) {
          break label421;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new JSONObject((String)paramConfig.get(0));
        if (!paramConfig.has("AboutTIMRedDot")) {
          break label421;
        }
        localObject = paramQQAppInterface.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tim_upgrade_hongdian_pre_");
        localStringBuilder.append(paramQQAppInterface.getCurrentUin());
        localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        paramConfig = paramConfig.getJSONObject("AboutTIMRedDot");
        if (paramConfig.has("On"))
        {
          int j = paramConfig.getInt("On");
          bool = true;
          if (j != 1) {
            break label422;
          }
          ((SharedPreferences.Editor)localObject).putBoolean("tim_upgrade_hongdian_switch", bool);
        }
        if (paramConfig.has("AboutTitle")) {
          ((SharedPreferences.Editor)localObject).putString("tim_upgrade_hongdian_title", paramConfig.getString("AboutTitle"));
        }
        if (paramConfig.has("AboutSubtitle")) {
          ((SharedPreferences.Editor)localObject).putString("tim_upgrade_hongdian_sub_title", paramConfig.getString("AboutSubtitle"));
        }
        if (paramConfig.has("AndroidAboutURL"))
        {
          paramConfig = paramConfig.getString("AndroidAboutURL");
          ((SharedPreferences.Editor)localObject).putString("tim_upgrade_hongdian_url", paramConfig);
          ((UpgradeTIMManager)paramQQAppInterface.getManager(QQManagerFactory.TIM_UPGRADE_DOWNLOAD_MANAGER)).a(paramConfig);
        }
        ((SharedPreferences.Editor)localObject).commit();
        paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
        paramQQAppInterface.putInt("tim_upgrade_hongdian_version", i);
        paramQQAppInterface.apply();
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      ((TimUpgradeHongdianManager)paramQQAppInterface.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER)).a();
      label421:
      return;
      label422:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet
 * JD-Core Version:    0.7.0.1
 */