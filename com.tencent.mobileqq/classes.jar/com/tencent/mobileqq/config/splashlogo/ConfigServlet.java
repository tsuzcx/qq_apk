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
import com.tencent.mobileqq.config.QConfigHelper;
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
  public static final int[] b = { 1, 2, 3, 5, 10, 13, 23, 31, 38, 42, 44, 46, 47, 49, 53, 55, 56, 57, 61, 62, 63, 64, 65, 66, 69, 205, 72, 73, 74, 75, 385, 94, 78, 79, 80, 84, 223, 82, 101, 102, 147, 93, 90, 96, 97, 108, 146, 111, 109, 115, 286, 118, 119, 116, 130, 142, 121, 157, 211, 201, 129, 143, 140, 257, 232, 233, 148, 139, 145, 153, 149, 155, 165, 185, 167, 166, 171, 180, 182, 177, 371, 181, 184, 187, 191, 193, 188, 195, 227, 202, 210, 212, 407, StoryApi.d(2131492911), StoryApi.d(2131492912), StoryApi.d(2131492913), StoryApi.d(2131492908), StoryApi.d(2131492909), 218, 226, 225, 222, 256, 228, 235, 234, 238, 247, 244, 245, 253, 295, 254, 259, 260, 262, 204, 271, 275, 358, 268, 269, 272, 274, 279, 308, 281, 283, 284, 280, 289, 314, 297, 301, 296, 330, 347, 313, 312, 397, 321, 326, 320, 328, 331, 336, 337, 345, 349, 355, 372, 384, 379, 357, 378, 381, 273, 364, 365, 369, 387, 386, 392, 393, 394, 401, 400, 403, 404, 405, 408, 410, 194, 596, 604, 705 };
  private static String c = HardCodeUtil.a(2131900608);
  private boolean d = false;
  
  public static void N(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = PreferenceUtils.d(BaseApplication.getContext(), a);
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
      PreferenceUtils.a(BaseApplication.getContext(), a, i);
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
              PreferenceUtils.c(BaseApplication.getContext(), (String)localObject2, paramQQAppInterface.getCurrentAccountUin());
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
    int j = SharedPreUtils.cd(BaseApplication.getContext(), a);
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
      SharedPreUtils.ad(BaseApplication.getContext(), a, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {
        return;
      }
      try
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        SharedPreUtils.d(BaseApplication.getContext(), a, "aio_config_key", paramConfig);
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
    int j = SharedPreUtils.ce(BaseApplication.getContext(), a);
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
      SharedPreUtils.ae(BaseApplication.getContext(), a, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {
        return;
      }
      try
      {
        i = new JSONObject((String)paramConfig.get(paramConfig.size() - 1)).optInt("max_multimsg_totalcount");
        SharedPreUtils.g(BaseApplication.getContext(), a, "multimsg_config", i);
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
    int j = SharedPreUtils.bp(BaseApplication.getContext(), a);
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
      SharedPreUtils.O(BaseApplication.getContext(), a, i);
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
    int j = SharedPreUtils.q();
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
        SharedPreUtils.q(paramConfig);
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
    int j = SharedPreUtils.bn(BaseApplication.getContext(), a);
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
      SharedPreUtils.N(BaseApplication.getContext(), a, i);
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
          ZhituManager.a(paramQQAppInterface).c(i);
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
        ZhituManager.a(paramQQAppInterface).b(i);
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
    int j = SharedPreUtils.j(paramQQAppInterface.getApp());
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
            if ((j != SharedPreUtils.c(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", a)) && (!TextUtils.isEmpty((CharSequence)localObject)))
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
              SharedPreUtils.a(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", a, j);
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
    int j = SharedPreUtils.u(paramQQAppInterface.getApp());
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
    int j = SharedPreUtils.w(paramQQAppInterface.getApp());
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
          if (k != SharedPreUtils.c(paramQQAppInterface.getApp(), "now_entrance_action_version", a))
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
      SharedPreUtils.a(paramQQAppInterface.getApp(), "now_entrance_action_version", a, k);
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
          if (j != SharedPreUtils.c(paramQQAppInterface.getApp(), (String)localObject1, a))
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
        SharedPreUtils.g((Context)localObject4, str2, ((JSONObject)localObject3).optString("hot_chat_link"));
        SharedPreUtils.t(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), ((JSONObject)localObject3).optInt("aio_post_tab_plugin"));
        ((ITroopRobotService)((QQAppInterface)localObject2).getRuntimeService(ITroopRobotService.class, "all")).configRobotFromServer((JSONObject)localObject3);
        ((LbsInfoReportManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.LBS_REPORT_MANAGER)).a((JSONObject)localObject3);
        SharedPreUtils.s(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), ((JSONObject)localObject3).optInt("create_troop_max_invite_num"));
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
        SharedPreUtils.cg(paramQQAppInterface.getApp(), ((JSONObject)localObject3).optString("group_houseKeeper_switch"));
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
      localObject3 = a;
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
    return paramFloat / 100.0F * (float)DeviceInfoUtil.B();
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
    int k = AEOldShortVideoResManager.e();
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
    //   0: new 1008	java/io/BufferedReader
    //   3: dup
    //   4: new 1010	java/io/InputStreamReader
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 1013	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 1016	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_3
    //   16: new 78	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   23: astore_2
    //   24: aload_3
    //   25: invokevirtual 1019	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +13 -> 45
    //   35: aload_2
    //   36: aload 4
    //   38: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: goto -18 -> 24
    //   45: aload_1
    //   46: invokevirtual 1024	java/io/InputStream:close	()V
    //   49: goto +24 -> 73
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 950	java/io/IOException:printStackTrace	()V
    //   57: goto +16 -> 73
    //   60: astore_2
    //   61: goto +17 -> 78
    //   64: astore_3
    //   65: aload_3
    //   66: invokevirtual 950	java/io/IOException:printStackTrace	()V
    //   69: aload_1
    //   70: invokevirtual 1024	java/io/InputStream:close	()V
    //   73: aload_2
    //   74: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: areturn
    //   78: aload_1
    //   79: invokevirtual 1024	java/io/InputStream:close	()V
    //   82: goto +8 -> 90
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 950	java/io/IOException:printStackTrace	()V
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
  
  /* Error */
  private void a(int paramInt, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: getstatic 1052	com/tencent/mobileqq/kandian/biz/common/constant/ReadInJoyDataProviderConstants:b	Landroid/net/Uri;
    //   3: invokevirtual 1058	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc_w 1060
    //   13: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   16: invokevirtual 1066	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   19: pop
    //   20: aload 5
    //   22: invokevirtual 1070	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   25: astore 8
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 7
    //   33: aload 7
    //   35: astore 5
    //   37: new 1072	android/content/ContentValues
    //   40: dup
    //   41: invokespecial 1073	android/content/ContentValues:<init>	()V
    //   44: astore 9
    //   46: aload 7
    //   48: astore 5
    //   50: aload 9
    //   52: ldc_w 1075
    //   55: iload_1
    //   56: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: invokevirtual 1079	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   62: aload 7
    //   64: astore 5
    //   66: aload 9
    //   68: ldc_w 1081
    //   71: aload_2
    //   72: invokevirtual 1084	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload 7
    //   77: astore 5
    //   79: aload 9
    //   81: ldc_w 1086
    //   84: aload_3
    //   85: invokevirtual 1084	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 7
    //   90: astore 5
    //   92: ldc_w 1088
    //   95: iconst_2
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: ldc_w 1081
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: aload_2
    //   108: aastore
    //   109: invokestatic 551	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   112: astore_2
    //   113: aload 7
    //   115: astore 5
    //   117: aload 4
    //   119: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   122: invokevirtual 1092	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   125: aload 8
    //   127: aconst_null
    //   128: aload_2
    //   129: aconst_null
    //   130: aconst_null
    //   131: invokevirtual 1098	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   134: astore_2
    //   135: aload_2
    //   136: ifnull +82 -> 218
    //   139: aload_2
    //   140: invokeinterface 1103 1 0
    //   145: ifle +39 -> 184
    //   148: aload 4
    //   150: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   153: invokevirtual 1092	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   156: aload 8
    //   158: aload 9
    //   160: aconst_null
    //   161: aconst_null
    //   162: invokevirtual 1107	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   165: pop
    //   166: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +64 -> 233
    //   172: ldc 92
    //   174: iconst_2
    //   175: ldc_w 1109
    //   178: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: goto +52 -> 233
    //   184: aload 4
    //   186: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   189: invokevirtual 1092	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   192: aload 8
    //   194: aload 9
    //   196: invokevirtual 1113	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   199: pop
    //   200: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +30 -> 233
    //   206: ldc 92
    //   208: iconst_2
    //   209: ldc_w 1115
    //   212: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: goto +18 -> 233
    //   218: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +12 -> 233
    //   224: ldc 92
    //   226: iconst_2
    //   227: ldc_w 1117
    //   230: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload 4
    //   235: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   238: invokevirtual 1092	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   241: aload 8
    //   243: aconst_null
    //   244: invokevirtual 1121	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   247: aload_2
    //   248: ifnull +102 -> 350
    //   251: aload_2
    //   252: invokeinterface 1122 1 0
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
    //   286: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +51 -> 340
    //   292: aload_2
    //   293: astore 5
    //   295: new 78	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   302: astore 4
    //   304: aload_2
    //   305: astore 5
    //   307: aload 4
    //   309: ldc_w 1124
    //   312: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_2
    //   317: astore 5
    //   319: aload 4
    //   321: aload_3
    //   322: invokevirtual 893	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_2
    //   327: astore 5
    //   329: ldc 92
    //   331: iconst_2
    //   332: aload 4
    //   334: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload_2
    //   341: ifnull +9 -> 350
    //   344: aload_2
    //   345: invokeinterface 1122 1 0
    //   350: return
    //   351: aload_3
    //   352: ifnull +9 -> 361
    //   355: aload_3
    //   356: invokeinterface 1122 1 0
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
                                      localConfigSeq.version.set(SharedPreUtils.u(paramQQAppInterface.getApp()));
                                      break;
                                    case 79: 
                                      localConfigSeq.version.set(SharedPreUtils.T(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                      break;
                                    case 78: 
                                      localConfigSeq.version.set(SharedPreUtils.w(paramQQAppInterface.getApp(), a));
                                    }
                                    break;
                                  case 75: 
                                    j = SharedPreUtils.H(paramQQAppInterface.getApp(), a);
                                    if (SharedPreUtils.D(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.d()) {
                                      j = 0;
                                    }
                                    localConfigSeq.version.set(j);
                                    break;
                                  case 74: 
                                    localConfigSeq.version.set(((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).k());
                                    break;
                                  case 73: 
                                    localConfigSeq.version.set(SharedPreUtils.I(paramQQAppInterface.getApp()));
                                    break;
                                  case 72: 
                                    localConfigSeq.version.set(SharedPreUtils.S(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin()));
                                  }
                                  break;
                                case 57: 
                                  localConfigSeq.version.set(SharedPreUtils.H(paramQQAppInterface.getApp()));
                                  break;
                                case 56: 
                                  localConfigSeq.version.set(SharedPreUtils.N(paramQQAppInterface.getApp(), a));
                                  break;
                                case 55: 
                                  localConfigSeq.version.set(SharedPreUtils.m(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                }
                                break;
                              case 44: 
                                localConfigSeq.version.set(SharedPreUtils.g(paramQQAppInterface.getApp(), a));
                                break;
                              case 43: 
                                localConfigSeq.version.set(SharedPreUtils.L(paramQQAppInterface.getApp(), a));
                                break;
                              case 42: 
                                localConfigSeq.version.set(SharedPreUtils.M(paramQQAppInterface.getApp(), a));
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
                              j = ShortVideoResourceManager.e();
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
                              localConfigSeq.version.set(SharedPreUtils.s("local_qr_login_version"));
                              break;
                            case 604: 
                              localConfigSeq.version.set(SharedPreUtils.av(paramQQAppInterface.getApp(), a));
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
                              j = SharedPreUtils.ce(BaseApplicationImpl.getContext(), a);
                              localConfigSeq.version.set(j);
                              break;
                            case 403: 
                              j = SharedPreUtils.cd(BaseApplicationImpl.getContext(), a);
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
                              j = JumpForwardPkgManager.b();
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
                              j = SharedPreUtils.bZ(paramQQAppInterface.getApp(), a);
                              if (SharedPreUtils.ca(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.d()) {
                                j = 0;
                              }
                              localConfigSeq.version.set(j);
                              break;
                            case 387: 
                              localConfigSeq.version.set(SharedPreUtils.bp(paramQQAppInterface.getApp(), a));
                              localConfigSeq.compress.set(1);
                              break;
                            case 385: 
                              paramReqGetConfig = (NotificationController)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER);
                              j = paramReqGetConfig.b(paramQQAppInterface.getApp(), a);
                              n = paramReqGetConfig.a(paramQQAppInterface.getApp(), a);
                              int i1 = AppSetting.d();
                              if (n != i1) {
                                j = 0;
                              }
                              QLog.i("NCtr", 1, String.format("request NOTIFICATION_LIMIT_CONFIG localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i1) }));
                              localConfigSeq.version.set(j);
                              break;
                            case 384: 
                              j = PreferenceUtils.d(paramQQAppInterface.getApp(), a);
                              localConfigSeq.version.set(j);
                              break;
                            case 371: 
                              localConfigSeq.version.set(SharedPreUtils.aH(paramQQAppInterface.getApp(), a));
                              localConfigSeq.compress.set(1);
                              break;
                            case 349: 
                              paramReqGetConfig = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                              localConfigSeq.version.set(paramReqGetConfig.c.a(paramQQAppInterface.getApp(), a));
                              localConfigSeq.compress.set(1);
                              break;
                            case 347: 
                              j = ((IQIMBeautyManager)QRoute.api(IQIMBeautyManager.class)).getBeautyConfigVersion(paramQQAppInterface.getApp());
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 345: 
                              j = SharedPreUtils.c(paramQQAppInterface.getApp(), "wifi_connect_config_version", a);
                              localConfigSeq.version.set(j);
                              break;
                            case 337: 
                              j = SharedPreUtils.bM(paramQQAppInterface.getApp(), a);
                              if (SharedPreUtils.bN(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.d()) {
                                j = 0;
                              }
                              localConfigSeq.version.set(j);
                              break;
                            case 336: 
                              localConfigSeq.version.set(SharedPreUtils.aa(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                              localConfigSeq.compress.set(1);
                              break;
                            case 331: 
                              localConfigSeq.version.set(SharedPreUtils.q());
                              localConfigSeq.compress.set(1);
                              break;
                            case 328: 
                              j = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 321: 
                              localConfigSeq.version.set(SharedPreUtils.aY(paramQQAppInterface.getApp(), a));
                              break;
                            case 320: 
                              paramReqGetConfig = (QQStoryManager)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
                              localConfigSeq.version.set(paramReqGetConfig.x.a(paramQQAppInterface.getApp(), a));
                              localConfigSeq.compress.set(1);
                              break;
                            case 313: 
                              localConfigSeq.version.set(SharedPreUtils.bG(paramQQAppInterface.getApp(), a));
                              break;
                            case 301: 
                              j = paramQQAppInterface.getPreferences().getInt("qzone_xp_config_version", 0);
                              localConfigSeq.version.set(j);
                              break;
                            case 297: 
                              j = SharedPreUtils.bJ(paramQQAppInterface.getApp(), a);
                              if (SharedPreUtils.bK(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.d()) {
                                j = 0;
                              }
                              localConfigSeq.version.set(j);
                              break;
                            case 296: 
                              paramQQAppInterface.getConfigProcess().a(localConfigSeq, paramQQAppInterface, m);
                              paramReqGetConfig = (IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
                              try
                              {
                                paramReqGetConfig.t();
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
                              localConfigSeq.version.set(SharedPreUtils.u(paramQQAppInterface.getApp(), a));
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
                              j = SharedPreUtils.c(paramQQAppInterface.getApplication(), "troop_gift_anim_limit", "0");
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
                              j = GiftConfigManager.b(a);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 272: 
                              j = SharedPreUtils.A(paramQQAppInterface.getApp(), a);
                              n = AppSetting.d();
                              if (j != n)
                              {
                                SharedPreUtils.h(paramQQAppInterface.getApp(), a, 0);
                                SharedPreUtils.g(paramQQAppInterface.getApp(), a, n);
                              }
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append("[VideoCompress]onsend : appIdRecord = ");
                                paramReqGetConfig.append(j);
                                paramReqGetConfig.append(", appId = ");
                                paramReqGetConfig.append(n);
                                paramReqGetConfig.append(", VIDEO_REDBAG_CONFI version = ");
                                paramReqGetConfig.append(SharedPreUtils.aO(paramQQAppInterface.getApp(), a));
                                QLog.d("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                              }
                              localConfigSeq.version.set(SharedPreUtils.B(paramQQAppInterface.getApp(), a));
                              localConfigSeq.compress.set(1);
                              break;
                            case 269: 
                              j = SharedPreUtils.c(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", a);
                              localConfigSeq.version.set(j);
                              break;
                            case 268: 
                              j = SharedPreUtils.c(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", a);
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
                                if (((Integer)SharedPreUtils.w(paramQQAppInterface.getApp(), a, 1)).intValue() != AppSetting.d())
                                {
                                  SharedPreUtils.a(paramQQAppInterface.getApp(), a, 1, Integer.valueOf(AppSetting.d()));
                                  SharedPreUtils.a(paramQQAppInterface.getApp(), a, 2, localInteger);
                                  localConfigSeq.version.set(0);
                                }
                                else
                                {
                                  j = ((Integer)SharedPreUtils.w(paramQQAppInterface.getApp(), a, 2)).intValue();
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
                              if (SharedPreUtils.v(paramQQAppInterface.getApp(), a, 1) != AppSetting.d())
                              {
                                SharedPreUtils.d(paramQQAppInterface.getApp(), a, 1, AppSetting.d());
                                SharedPreUtils.d(paramQQAppInterface.getApp(), a, 2, 0);
                                localConfigSeq.version.set(0);
                              }
                              else
                              {
                                localConfigSeq.version.set(SharedPreUtils.v(paramQQAppInterface.getApp(), a, 2));
                              }
                              break;
                            case 256: 
                              j = SharedPreUtils.bl(paramQQAppInterface.getApp(), a);
                              if (SharedPreUtils.bm(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.d()) {
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
                              j = SharedPreUtils.y(paramQQAppInterface.getApp(), a);
                              n = AppSetting.d();
                              if (j != n)
                              {
                                SharedPreUtils.f(paramQQAppInterface.getApp(), a, 0);
                                SharedPreUtils.e(paramQQAppInterface.getApp(), a, n);
                              }
                              if (QLog.isColorLevel())
                              {
                                paramReqGetConfig = new StringBuilder();
                                paramReqGetConfig.append("[GreenVideo]onsend : appIdRecord = ");
                                paramReqGetConfig.append(j);
                                paramReqGetConfig.append(", appId = ");
                                paramReqGetConfig.append(n);
                                paramReqGetConfig.append(", GREEN_VIDEO_CONFI version = ");
                                paramReqGetConfig.append(SharedPreUtils.z(paramQQAppInterface.getApp(), a));
                                QLog.d("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                              }
                              localConfigSeq.version.set(SharedPreUtils.z(paramQQAppInterface.getApp(), a));
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
                              j = SharedPreUtils.bj(paramQQAppInterface.getApp(), a);
                              if (SharedPreUtils.bk(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.d()) {
                                j = 0;
                              }
                              localConfigSeq.version.set(j);
                              break;
                            case 227: 
                              j = SharedPreUtils.c(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", a);
                              localConfigSeq.version.set(j);
                              break;
                            case 226: 
                              if (!CapturePtvTemplateManager.b()) {
                                localConfigSeq.version.set(0);
                              } else {
                                localConfigSeq.version.set(SharedPreUtils.n(paramQQAppInterface.getApp()));
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
                              j = AEOldShortVideoResManager.e();
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
                              j = SharedPreUtils.bh(BaseApplicationImpl.getContext(), a);
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
                              j = FaceScanDownloadManager.c(paramQQAppInterface);
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
                              j = SharedPreUtils.c(paramQQAppInterface.getApp(), "nearby_config_version", a);
                              localConfigSeq.version.set(j);
                              break;
                            case 195: 
                              j = SharedPreUtils.c(paramQQAppInterface.getApp(), "change_machine_version", a);
                              localConfigSeq.version.set(j);
                              break;
                            case 194: 
                              localConfigSeq.version.set(SharedPreUtils.ay(paramQQAppInterface.getApp(), a));
                              localConfigSeq.compress.set(1);
                              break;
                            case 193: 
                              j = SharedPreUtils.P(paramQQAppInterface.getApp(), a);
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
                              localConfigSeq.version.set(SharedPreUtils.aT(paramQQAppInterface.getApp(), a));
                              break;
                            case 188: 
                              paramReqGetConfig = (ARGlobalConfigManager)paramQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
                              if (paramReqGetConfig != null)
                              {
                                j = paramReqGetConfig.f();
                                if (QLog.isColorLevel())
                                {
                                  localObject = new StringBuilder();
                                  ((StringBuilder)localObject).append(" local version = ");
                                  ((StringBuilder)localObject).append(j);
                                  QLog.d("handleResp_GetArGlobalConfig", 2, ((StringBuilder)localObject).toString());
                                }
                                if (paramReqGetConfig.c())
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
                              localConfigSeq.version.set(PhotoListConfigManager.a(paramQQAppInterface.getApp(), a));
                              localConfigSeq.compress.set(1);
                              break;
                            case 185: 
                              localConfigSeq.version.set(SharedPreUtils.P(paramQQAppInterface.getApp()));
                              break;
                            case 184: 
                              localConfigSeq.version.set(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountQQMailConfigVersionCode(paramQQAppInterface));
                              break;
                            case 182: 
                              localConfigSeq.version.set(((ISttManagerApi)QRoute.api(ISttManagerApi.class)).getConfigVersion(paramQQAppInterface));
                              localConfigSeq.compress.set(1);
                              break;
                            case 181: 
                              j = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getDoutuConfigAppId(paramQQAppInterface.getApp(), a);
                              n = AppSetting.d();
                              if (j != n)
                              {
                                ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuConfigVersion(paramQQAppInterface.getApp(), a, 0);
                                ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuConfigAppId(paramQQAppInterface.getApp(), a, n);
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
                                paramReqGetConfig.append(SharedPreUtils.aJ(paramQQAppInterface.getApp(), a));
                                QLog.d("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                              }
                              localConfigSeq.version.set(SharedPreUtils.aJ(paramQQAppInterface.getApp(), a));
                              localConfigSeq.compress.set(1);
                              break;
                            case 177: 
                              localConfigSeq.version.set(SharedPreUtils.aA(paramQQAppInterface.getApp(), a));
                              localConfigSeq.compress.set(1);
                              break;
                            case 174: 
                              if (((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(a, "key_app_id", localInteger)).intValue() != AppSetting.d())
                              {
                                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "key_tabs_config_version", localInteger);
                                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "key_app_id", Integer.valueOf(AppSetting.d()));
                              }
                              j = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(a, "key_tabs_config_version", localInteger)).intValue();
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
                              localConfigSeq.version.set(SharedPreUtils.au(paramQQAppInterface.getApp(), a));
                              localConfigSeq.compress.set(1);
                              break;
                            case 167: 
                              if (!PtvTemplateManager.b()) {
                                localConfigSeq.version.set(0);
                              } else {
                                localConfigSeq.version.set(SharedPreUtils.o(paramQQAppInterface.getApp()));
                              }
                              localConfigSeq.compress.set(1);
                              break;
                            case 166: 
                              paramReqGetConfig = (TroopStoryManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_STORY_MANAGER);
                              localConfigSeq.version.set(paramReqGetConfig.d.a(paramQQAppInterface.getApp(), a));
                              break;
                            case 165: 
                              localConfigSeq.version.set(SharedPreUtils.aB(paramQQAppInterface.getApp(), a));
                              localConfigSeq.compress.set(1);
                              break;
                            case 155: 
                              localConfigSeq.version.set(SharedPreUtils.al(paramQQAppInterface.getApp(), a));
                              break;
                            case 153: 
                              localConfigSeq.version.set(SharedPreUtils.an(paramQQAppInterface.getApp(), a));
                              break;
                            case 149: 
                            case 180: 
                            case 218: 
                              QAVConfig.a(m, a, localConfigSeq);
                              break;
                            case 148: 
                              localConfigSeq.version.set(SharedPreUtils.j(paramQQAppInterface.getApp()));
                              localConfigSeq.compress.set(1);
                              break;
                            case 147: 
                              localConfigSeq.version.set(SharedPreUtils.c(paramQQAppInterface.getApp(), "shop_tab", a));
                              break;
                            case 146: 
                              localConfigSeq.version.set(SharedPreUtils.Z(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                              localConfigSeq.compress.set(1);
                              break;
                            case 145: 
                              if (!PtvTemplateManager.i()) {
                                localConfigSeq.version.set(0);
                              } else {
                                localConfigSeq.version.set(SharedPreUtils.r(paramQQAppInterface.getApp()));
                              }
                              localConfigSeq.compress.set(1);
                              break;
                            case 143: 
                              j = SharedPreUtils.c(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", a);
                              localConfigSeq.version.set(j);
                              localConfigSeq.compress.set(1);
                              break;
                            case 142: 
                              j = SharedPreUtils.c(paramQQAppInterface.getApp(), "troop_common_config_version", a);
                              localConfigSeq.version.set(j);
                              break;
                            case 140: 
                              localConfigSeq.version.set(SharedPreUtils.ak(paramQQAppInterface.getApp(), a));
                              break;
                            case 139: 
                              if (PtvTemplateManager.f()) {
                                j = SharedPreUtils.p(paramQQAppInterface.getApp());
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
                              localConfigSeq.version.set(SharedPreUtils.I(paramQQAppInterface.getApp(), a));
                              break;
                            case 129: 
                              j = SharedPreUtils.c(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", a);
                              localConfigSeq.version.set(j);
                              break;
                            case 121: 
                              localConfigSeq.version.set(SharedPreUtils.ab(paramQQAppInterface.getApp(), a));
                            case 157: 
                              localConfigSeq.version.set(SharedPreUtils.ad(paramQQAppInterface.getApp(), a));
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
                                  j = AppSetting.d();
                                  if (j != paramReqGetConfig.b(paramQQAppInterface.getApp(), a))
                                  {
                                    paramReqGetConfig.a(paramQQAppInterface.getApp(), a, 0);
                                    paramReqGetConfig.b(paramQQAppInterface.getApp(), a, j);
                                    paramReqGetConfig.a(paramQQAppInterface.getApp(), a, true);
                                    paramReqGetConfig.d();
                                  }
                                  localConfigSeq.version.set(paramReqGetConfig.a(paramQQAppInterface.getApp(), a));
                                  continue;
                                  j = SharedPreUtils.c(paramQQAppInterface.getApp(), "now_entrance_action_version", a);
                                  localConfigSeq.version.set(j);
                                  continue;
                                  j = SharedPreUtils.O(paramQQAppInterface.getApp(), a);
                                  if (QLog.isColorLevel())
                                  {
                                    paramReqGetConfig = new StringBuilder();
                                    paramReqGetConfig.append("addAllConfigs|GET_CONFIG_UPGRADE version=");
                                    paramReqGetConfig.append(j);
                                    QLog.d("SPLASH_ConfigServlet", 2, paramReqGetConfig.toString());
                                  }
                                  localConfigSeq.version.set(j);
                                  paramQQAppInterface.getPreloadSwitch();
                                  OpenConfig.a(paramQQAppInterface.getApp(), String.valueOf(AppSetting.d()));
                                  ((ConfigHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).d();
                                  continue;
                                  localConfigSeq.version.set(SharedPreUtils.t(paramQQAppInterface.getApp(), a));
                                  continue;
                                  localConfigSeq.version.set(SharedPreUtils.w(paramQQAppInterface.getApp()));
                                  continue;
                                  j = CameraUtils.d(BaseApplicationImpl.getContext());
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
                                    if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), a, null, "qqsetting_calltab_show_key_version", 0) < j)
                                    {
                                      localConfigSeq.version.set(0);
                                    }
                                    else
                                    {
                                      localConfigSeq.version.set(SharedPreUtils.q(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                                      continue;
                                      j = ApkUtils.a(BaseApplicationImpl.getContext());
                                      if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), a, null, "qqsetting_calltab_show_key_version", 0) < j)
                                      {
                                        localConfigSeq.version.set(0);
                                        paramIntent.putExtra("update101Version", j);
                                      }
                                      else
                                      {
                                        localConfigSeq.version.set(SharedPreUtils.p(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                                        continue;
                                        paramReqGetConfig = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
                                        localConfigSeq.version.set(paramReqGetConfig.getsAllEntranceConfigVersion());
                                        continue;
                                        j = SharedPreUtils.c(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", a);
                                        localConfigSeq.version.set(j);
                                        continue;
                                        localConfigSeq.version.set(SharedPreUtils.R(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                      }
                                    }
                                  }
                                }
                              }
                            case 84: 
                              if (!PtvTemplateManager.a()) {
                                localConfigSeq.version.set(0);
                              } else {
                                localConfigSeq.version.set(SharedPreUtils.m(paramQQAppInterface.getApp()));
                              }
                              break;
                            case 82: 
                              localConfigSeq.version.set(SharedPreUtils.W(paramQQAppInterface.getApp(), a));
                              break;
                            case 69: 
                              j = SharedPreUtils.G(paramQQAppInterface.getApp(), a);
                              localConfigSeq.version.set(j);
                              break;
                            case 66: 
                              localConfigSeq.version.set(SharedPreUtils.F(paramQQAppInterface.getApp(), a));
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
                              localConfigSeq.version.set(SharedPreUtils.i(paramQQAppInterface.getApp(), a));
                              break;
                            case 64: 
                              localConfigSeq.version.set(SharedPreUtils.G(paramQQAppInterface.getApp()));
                              break;
                            case 63: 
                              localConfigSeq.version.set(SharedPreUtils.F(paramQQAppInterface.getApp()));
                              break;
                            case 61: 
                              localConfigSeq.version.set(SharedPreUtils.E(paramQQAppInterface.getApp()));
                              break;
                            case 53: 
                              localConfigSeq.version.set(SharedPreUtils.v(paramQQAppInterface.getApp(), a));
                              break;
                            case 49: 
                              localConfigSeq.version.set(SharedPreUtils.D(paramQQAppInterface.getApp()));
                              break;
                            case 38: 
                              localConfigSeq.version.set(SharedPreUtils.r(paramQQAppInterface.getApp(), a));
                              break;
                            case 34: 
                              paramReqGetConfig = (PhoneUnityManager)paramQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
                              localConfigSeq.version.set(paramReqGetConfig.f());
                              break;
                            case 31: 
                              localConfigSeq.version.set(SharedPreUtils.d(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                              break;
                            case 23: 
                              label5951:
                              localConfigSeq.version.set(SharedPreUtils.i(paramQQAppInterface.getApp()));
                              break;
                            }
                            localConfigSeq.version.set(SharedPreUtils.d(paramQQAppInterface.getApp()));
                            break label7452;
                          }
                          localConfigSeq.version.set(SharedPreUtils.e(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                          break label7452;
                        }
                        localConfigSeq.version.set(SharedPreUtils.s(paramQQAppInterface.getApp(), a));
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
                        localConfigSeq.version.set(SharedPreUtils.h(paramQQAppInterface.getApp(), a));
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
                    BridgeHelper.a(BaseApplication.getContext(), a).a();
                    localConfigSeq.version.set(SharedPreUtils.c(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
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
              localConfigSeq.version.set(SharedPreUtils.l(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
              break label7452;
            }
          }
          else
          {
            SharedPreUtils.a(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
            if (paramQQAppInterface.getCurrentAccountUin() != null)
            {
              c = paramQQAppInterface.getCurrentNickname();
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
                  localConfigSeq.version.set(SharedPreUtils.k(paramQQAppInterface.getApp(), a));
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
          localConfigSeq.version.set(SharedPreUtils.j(paramQQAppInterface.getApp(), a));
        }
      }
      else {
        localConfigSeq.version.set(SharedPreUtils.g(paramQQAppInterface.getApp()));
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
      paramIntent.width.set((int)DeviceInfoUtil.D());
      paramIntent.height.set((int)DeviceInfoUtil.E());
      paramQQAppInterface.screen = paramIntent;
      paramQQAppInterface.setHasFlag(true);
      localReqGetConfig.device_info = paramQQAppInterface;
    }
    if ((paramReqGetConfig.contains(Integer.valueOf(47))) || (paramReqGetConfig.contains(Integer.valueOf(65))) || (paramReqGetConfig.contains(Integer.valueOf(156))) || (paramReqGetConfig.contains(Integer.valueOf(297))))
    {
      paramIntent = new ConfigurationService.OS();
      paramIntent.setHasFlag(true);
      paramIntent.type.set(2);
      paramIntent.kernel.set(DeviceInfoUtil.I());
      paramIntent.sdk.set(String.valueOf(DeviceInfoUtil.d()));
      paramIntent.version.set(DeviceInfoUtil.g());
      paramIntent.rom.set(DeviceInfoUtil.v());
      paramQQAppInterface.brand.set(DeviceInfoUtil.t());
      paramQQAppInterface.model.set(DeviceInfoUtil.f());
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
    QConfigManager.b(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramInt != -1) && (SharedPreUtils.D(paramQQAppInterface.getApp()) == paramInt))
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
  
  private void a(ConfigurationService.ReqGetConfig paramReqGetConfig, ConfigurationService.ConfigSeq paramConfigSeq, QQAppInterface paramQQAppInterface)
  {
    for (Object localObject1 = "";; localObject1 = paramConfigSeq)
    {
      try
      {
        int i;
        if (SharedPreUtils.aK(paramQQAppInterface.getApp(), a) != AppSetting.d())
        {
          SharedPreUtils.H(paramQQAppInterface.getApp(), a, AppSetting.d());
          SharedPreUtils.I(paramQQAppInterface.getApp(), a, 0);
          i = 0;
        }
        else
        {
          i = SharedPreUtils.aL(paramQQAppInterface.getApp(), a);
        }
        paramConfigSeq.version.set(i);
        ConfigurationService.ConfigSeq localConfigSeq = null;
        try
        {
          paramConfigSeq = DeviceInfoUtil.R();
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
          ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "has_new_banner", Boolean.valueOf(true));
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
    if (j == SharedPreUtils.ad(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()))
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
            paramQQAppInterface.b();
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
      int j = SharedPreUtils.I(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
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
        paramQQAppInterface.mqqService.e = false;
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
    //   4: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +46 -> 53
    //   10: new 78	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   17: astore 6
    //   19: aload 6
    //   21: ldc_w 2319
    //   24: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 6
    //   30: aload_2
    //   31: getfield 2229	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   34: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   37: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc_w 2321
    //   44: iconst_2
    //   45: aload 6
    //   47: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_2
    //   54: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   57: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   60: istore 4
    //   62: aload_2
    //   63: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   66: ifnull +245 -> 311
    //   69: aload_2
    //   70: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   73: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   76: ifle +235 -> 311
    //   79: aload_2
    //   80: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   83: iconst_0
    //   84: invokevirtual 467	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   87: checkcast 126	java/lang/String
    //   90: astore_2
    //   91: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +40 -> 134
    //   97: new 78	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   104: astore 6
    //   106: aload 6
    //   108: ldc_w 2322
    //   111: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 6
    //   117: aload_2
    //   118: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: ldc_w 2321
    //   125: iconst_2
    //   126: aload 6
    //   128: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_2
    //   135: ifnull +176 -> 311
    //   138: new 128	org/json/JSONObject
    //   141: dup
    //   142: aload_2
    //   143: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   146: astore 8
    //   148: aload 8
    //   150: ldc_w 2324
    //   153: ldc 8
    //   155: invokevirtual 2326	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 6
    //   160: aload 8
    //   162: ldc_w 2328
    //   165: ldc 8
    //   167: invokevirtual 2326	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   170: astore_2
    //   171: aload 8
    //   173: ldc_w 2330
    //   176: ldc 8
    //   178: invokevirtual 2326	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 7
    //   183: aload 7
    //   185: astore 5
    //   187: aload 8
    //   189: ldc_w 2332
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
    //   226: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +83 -> 312
    //   232: ldc 92
    //   234: iconst_2
    //   235: aload 7
    //   237: invokevirtual 2032	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   240: aload 7
    //   242: invokestatic 1466	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   245: goto +67 -> 312
    //   248: aload_1
    //   249: getstatic 2335	com/tencent/mobileqq/app/QQManagerFactory:MEDAL_WALL_MNG	I
    //   252: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   255: checkcast 2337	com/tencent/mobileqq/medalwall/MedalWallMng
    //   258: iload_3
    //   259: aload 6
    //   261: aload_2
    //   262: aload 5
    //   264: invokevirtual 2340	com/tencent/mobileqq/medalwall/MedalWallMng:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_1
    //   268: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   271: iload 4
    //   273: aload_1
    //   274: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   277: invokestatic 2342	com/tencent/mobileqq/utils/SharedPreUtils:t	(Landroid/content/Context;ILjava/lang/String;)V
    //   280: aload_1
    //   281: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   284: aload_1
    //   285: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   288: iload_3
    //   289: invokestatic 2344	com/tencent/mobileqq/utils/SharedPreUtils:u	(Landroid/content/Context;Ljava/lang/String;I)V
    //   292: return
    //   293: astore_1
    //   294: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +14 -> 311
    //   300: ldc 92
    //   302: iconst_2
    //   303: aload_1
    //   304: iconst_0
    //   305: anewarray 4	java/lang/Object
    //   308: invokestatic 2347	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    int n = SharedPreUtils.v(paramQQAppInterface.getApp(), a, 2);
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
        SharedPreUtils.d(paramQQAppInterface.getApp(), a, 3, j);
        if (paramQQAppInterface.isCreateManager(QQManagerFactory.MEDAL_WALL_MNG)) {
          ((MedalWallMng)paramQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(j);
        }
      }
      SharedPreUtils.d(paramQQAppInterface.getApp(), a, 2, m);
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
        int k = ((Integer)SharedPreUtils.w(paramQQAppInterface.getApp(), a, 2)).intValue();
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
          SharedPreUtils.a(paramQQAppInterface.getApp(), a, 3, paramConfig);
          if (paramQQAppInterface.isCreateManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)) {
            ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(paramConfig);
          }
        }
        SharedPreUtils.a(paramQQAppInterface.getApp(), a, 2, Integer.valueOf(j));
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
    SharedPreUtils.s(paramQQAppInterface.getApp(), paramConfig.version.get(), a);
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
        OcrConfig.deleteLocalConfig(a);
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
    int k = AppSetting.d();
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
      localNotificationController.a(a);
    }
  }
  
  private void aJ(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j = paramConfig.version.get();
    int i = SharedPreUtils.bZ(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int k = SharedPreUtils.ca(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int m = AppSetting.d();
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
          SharedPreUtils.v(paramQQAppInterface.getApp(), paramConfig.version.get(), a);
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
    int i = JumpForwardPkgManager.b();
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
    int j = SharedPreUtils.av(BaseApplication.getContext(), a);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("handleDevConfig: ,version: ");
    paramQQAppInterface.append(paramConfig.version.get());
    paramQQAppInterface.append("| localVersion: ");
    paramQQAppInterface.append(j);
    QLog.i("SPLASH_ConfigServlet", 1, paramQQAppInterface.toString());
    if (i != j)
    {
      SharedPreUtils.z(BaseApplication.getContext(), a, i);
      paramQQAppInterface = a(paramConfig);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0)) {
        return;
      }
      try
      {
        paramQQAppInterface = (String)paramQQAppInterface.get(paramQQAppInterface.size() - 1);
        QLog.d("SPLASH_ConfigServlet", 1, new Object[] { "devConfig is ", paramQQAppInterface });
        SharedPreUtils.m(BaseApplication.getContext(), a, paramQQAppInterface);
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
          if (j != SharedPreUtils.c(paramQQAppInterface.getApp(), "nearby_config_version", a))
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
      SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_config_version", a, j);
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
          if (j != SharedPreUtils.c(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", a))
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
      SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", a, j);
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
          k = SharedPreUtils.c(paramQQAppInterface.getApp(), "change_machine_version", a);
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
            SharedPreUtils.a(paramQQAppInterface.getApp(), "change_machine_version", a, j);
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
          k = SharedPreUtils.c(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", a);
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
            SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", a, j);
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
          k = SharedPreUtils.c(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", a);
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
            SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", a, j);
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
          k = SharedPreUtils.c(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", a);
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
            SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", a, j);
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
    int i = SharedPreUtils.p(paramQQAppInterface.getApp());
    if (!PtvTemplateManager.f()) {
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
      localPtvTemplateManager.h();
    }
  }
  
  /* Error */
  private void ah(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: istore_3
    //   8: aload_1
    //   9: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   12: iload_3
    //   13: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   16: invokestatic 2719	com/tencent/mobileqq/utils/SharedPreUtils:g	(Landroid/content/Context;ILjava/lang/String;)V
    //   19: aload_2
    //   20: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   23: ifnull +24 -> 47
    //   26: aload_2
    //   27: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   30: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   33: ifle +14 -> 47
    //   36: aload_2
    //   37: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   40: invokevirtual 2720	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   43: astore_1
    //   44: goto +5 -> 49
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +177 -> 227
    //   53: aload_1
    //   54: invokeinterface 111 1 0
    //   59: ifle +168 -> 227
    //   62: iconst_0
    //   63: istore_3
    //   64: aload_1
    //   65: iconst_0
    //   66: invokeinterface 191 2 0
    //   71: checkcast 126	java/lang/String
    //   74: astore_1
    //   75: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +61 -> 139
    //   81: new 78	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   88: astore 4
    //   90: aload 4
    //   92: ldc_w 2722
    //   95: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 4
    //   101: aload_1
    //   102: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 4
    //   108: ldc_w 474
    //   111: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: aload_2
    //   118: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   121: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   124: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc 92
    //   130: iconst_2
    //   131: aload 4
    //   133: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_1
    //   140: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifne +128 -> 271
    //   146: invokestatic 2247	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   149: astore_2
    //   150: aload_2
    //   151: new 808	java/io/ByteArrayInputStream
    //   154: dup
    //   155: aload_1
    //   156: invokevirtual 2249	java/lang/String:getBytes	()[B
    //   159: invokespecial 817	java/io/ByteArrayInputStream:<init>	([B)V
    //   162: ldc_w 426
    //   165: invokeinterface 2255 3 0
    //   170: iload_3
    //   171: iconst_1
    //   172: if_icmpeq +99 -> 271
    //   175: iload_3
    //   176: iconst_2
    //   177: if_icmpne +28 -> 205
    //   180: aload_2
    //   181: invokeinterface 2261 1 0
    //   186: ldc_w 2724
    //   189: invokevirtual 2266	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   192: ifeq +13 -> 205
    //   195: aload_2
    //   196: invokeinterface 2269 1 0
    //   201: iconst_1
    //   202: invokestatic 2730	com/tencent/mobileqq/activity/JumpActivity:initJASwitch	(Ljava/lang/String;Z)V
    //   205: aload_2
    //   206: invokeinterface 2273 1 0
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
    //   227: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq +41 -> 271
    //   233: new 78	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   240: astore_1
    //   241: aload_1
    //   242: ldc_w 2732
    //   245: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_1
    //   250: aload_2
    //   251: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   254: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   257: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: ldc 92
    //   263: iconst_2
    //   264: aload_1
    //   265: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    int i = localPhoneUnityManager.f();
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
                      localPhoneUnityBannerData.b = localXmlPullParser.getAttributeValue(m);
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
                      localPhoneUnityBannerData.a = localXmlPullParser.getAttributeValue(m);
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
                      localPhoneUnityBannerData.c = Integer.valueOf(localXmlPullParser.getAttributeValue(m)).intValue();
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
                      localPhoneUnityBannerData.d = Integer.valueOf(localXmlPullParser.getAttributeValue(m)).intValue();
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
                      localPhoneUnityBannerData.e = Integer.valueOf(localXmlPullParser.getAttributeValue(m)).intValue();
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
                      localPhoneUnityBannerData.g = Integer.valueOf(localXmlPullParser.getAttributeValue(m)).intValue();
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
                      localPhoneUnityBannerData.h = "1".equals(localXmlPullParser.getAttributeValue(m));
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
                    localPhoneUnityBannerData.i = "1".equals(localXmlPullParser.getAttributeValue(m));
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
      k = SharedPreUtils.F(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
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
      int j = SharedPreUtils.L(paramQQAppInterface.getApp(), a);
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
        SharedPreUtils.k(paramQQAppInterface.getApp(), a, i);
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
      int i = SharedPreUtils.D(paramQQAppInterface.getApp());
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
      int j = SharedPreUtils.E(paramQQAppInterface.getApp());
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
      if (i != SharedPreUtils.G(paramQQAppInterface.getApp()))
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
    int j = SharedPreUtils.G(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
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
        PasswdRedBagFoldManager.b(paramQQAppInterface, i, (String)localObject);
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
    paramConfig.a = true;
    paramConfig.b = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    paramConfig.c = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    paramConfig.d = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    paramConfig.e = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, paramConfig.b, paramConfig.c, paramConfig.d, paramConfig.e);
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
        int j = paramQQAppInterface.k();
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
    //   1: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: istore 8
    //   9: aload_1
    //   10: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: aload_1
    //   14: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   17: invokestatic 1516	com/tencent/mobileqq/utils/SharedPreUtils:bj	(Landroid/content/Context;Ljava/lang/String;)I
    //   20: istore_3
    //   21: aload_1
    //   22: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: aload_1
    //   26: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokestatic 1519	com/tencent/mobileqq/utils/SharedPreUtils:bk	(Landroid/content/Context;Ljava/lang/String;)I
    //   32: istore 4
    //   34: invokestatic 1182	com/tencent/common/config/AppSetting:d	()I
    //   37: istore 5
    //   39: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +50 -> 92
    //   45: ldc 92
    //   47: iconst_2
    //   48: ldc_w 3003
    //   51: iconst_4
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: iload 8
    //   59: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: iload_3
    //   66: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: iload 4
    //   74: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: dup
    //   79: iconst_3
    //   80: iload 5
    //   82: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: invokestatic 551	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: iload 4
    //   94: iload 5
    //   96: if_icmpeq +18 -> 114
    //   99: aload_1
    //   100: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   103: aload_1
    //   104: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   107: iload 5
    //   109: invokestatic 3005	com/tencent/mobileqq/utils/SharedPreUtils:L	(Landroid/content/Context;Ljava/lang/String;I)V
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
    //   130: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +12 -> 145
    //   136: ldc_w 3007
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
    //   192: invokestatic 802	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   195: invokevirtual 806	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   198: new 808	java/io/ByteArrayInputStream
    //   201: dup
    //   202: aload 10
    //   204: ldc_w 810
    //   207: invokevirtual 814	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   210: invokespecial 817	java/io/ByteArrayInputStream:<init>	([B)V
    //   213: invokevirtual 822	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   216: astore 29
    //   218: aload 29
    //   220: ldc_w 3009
    //   223: invokeinterface 830 2 0
    //   228: iconst_0
    //   229: invokeinterface 841 2 0
    //   234: invokeinterface 847 1 0
    //   239: invokeinterface 850 1 0
    //   244: astore 26
    //   246: aload 29
    //   248: ldc_w 3011
    //   251: invokeinterface 830 2 0
    //   256: iconst_0
    //   257: invokeinterface 841 2 0
    //   262: invokeinterface 847 1 0
    //   267: invokeinterface 850 1 0
    //   272: astore 27
    //   274: aload 29
    //   276: ldc_w 3013
    //   279: invokeinterface 830 2 0
    //   284: iconst_0
    //   285: invokeinterface 841 2 0
    //   290: invokeinterface 847 1 0
    //   295: invokeinterface 850 1 0
    //   300: astore 28
    //   302: aload 29
    //   304: ldc_w 3015
    //   307: invokeinterface 830 2 0
    //   312: iconst_0
    //   313: invokeinterface 841 2 0
    //   318: invokeinterface 847 1 0
    //   323: invokeinterface 850 1 0
    //   328: astore 10
    //   330: aload 29
    //   332: ldc_w 3017
    //   335: invokeinterface 830 2 0
    //   340: iconst_0
    //   341: invokeinterface 841 2 0
    //   346: invokeinterface 847 1 0
    //   351: invokeinterface 850 1 0
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
    //   387: ldc_w 3019
    //   390: invokeinterface 830 2 0
    //   395: iconst_0
    //   396: invokeinterface 841 2 0
    //   401: invokeinterface 847 1 0
    //   406: invokeinterface 850 1 0
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
    //   463: ldc_w 3021
    //   466: invokeinterface 830 2 0
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
    //   534: invokeinterface 835 1 0
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
    //   593: invokeinterface 841 2 0
    //   598: invokeinterface 847 1 0
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
    //   663: invokeinterface 850 1 0
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
    //   1013: invokestatic 2767	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1016: invokevirtual 1274	java/lang/Integer:intValue	()I
    //   1019: istore_3
    //   1020: aload 27
    //   1022: invokestatic 2767	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1025: invokevirtual 1274	java/lang/Integer:intValue	()I
    //   1028: istore 4
    //   1030: aload 28
    //   1032: invokestatic 2767	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1035: invokevirtual 1274	java/lang/Integer:intValue	()I
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
    //   1628: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1631: ifeq +38 -> 1669
    //   1634: ldc_w 3007
    //   1637: iconst_2
    //   1638: aload 17
    //   1640: iconst_0
    //   1641: anewarray 4	java/lang/Object
    //   1644: invokestatic 2541	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   1761: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1764: ifeq -95 -> 1669
    //   1767: ldc_w 3007
    //   1770: iconst_2
    //   1771: aload 17
    //   1773: iconst_0
    //   1774: anewarray 4	java/lang/Object
    //   1777: invokestatic 2541	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   1866: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1869: ifeq -200 -> 1669
    //   1872: ldc_w 3007
    //   1875: iconst_2
    //   1876: aload 17
    //   1878: iconst_0
    //   1879: anewarray 4	java/lang/Object
    //   1882: invokestatic 2541	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   1971: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1974: ifeq -305 -> 1669
    //   1977: ldc_w 3007
    //   1980: iconst_2
    //   1981: aload 17
    //   1983: iconst_0
    //   1984: anewarray 4	java/lang/Object
    //   1987: invokestatic 2541	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   2076: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2079: ifeq -410 -> 1669
    //   2082: ldc_w 3007
    //   2085: iconst_2
    //   2086: aload 17
    //   2088: iconst_0
    //   2089: anewarray 4	java/lang/Object
    //   2092: invokestatic 2541	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   2181: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2184: ifeq -515 -> 1669
    //   2187: ldc_w 3007
    //   2190: iconst_2
    //   2191: aload 17
    //   2193: iconst_0
    //   2194: anewarray 4	java/lang/Object
    //   2197: invokestatic 2541	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
    //   2230: invokestatic 3026	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:b	()Lcom/tencent/mobileqq/activity/aio/qim/QIMUserManager;
    //   2233: aload_1
    //   2234: invokevirtual 3029	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:d	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   2237: astore 13
    //   2239: invokestatic 3026	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:b	()Lcom/tencent/mobileqq/activity/aio/qim/QIMUserManager;
    //   2242: aload_1
    //   2243: invokevirtual 3031	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:f	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   2246: astore 14
    //   2248: aload 13
    //   2250: aload_2
    //   2251: invokevirtual 490	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2254: ifeq +22 -> 2276
    //   2257: aload 14
    //   2259: aload 10
    //   2261: invokevirtual 490	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2264: ifne +6 -> 2270
    //   2267: goto +9 -> 2276
    //   2270: iconst_0
    //   2271: istore 9
    //   2273: goto +6 -> 2279
    //   2276: iconst_1
    //   2277: istore 9
    //   2279: invokestatic 3026	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:b	()Lcom/tencent/mobileqq/activity/aio/qim/QIMUserManager;
    //   2282: iload 6
    //   2284: iload 4
    //   2286: aload_2
    //   2287: aload 12
    //   2289: aload 10
    //   2291: aload 11
    //   2293: iload 9
    //   2295: iload_3
    //   2296: invokevirtual 3034	com/tencent/mobileqq/activity/aio/qim/QIMUserManager:a	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   2299: aload_1
    //   2300: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2303: aload_1
    //   2304: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2307: iload 8
    //   2309: iload 6
    //   2311: iload 4
    //   2313: aload_2
    //   2314: aload 10
    //   2316: aload 12
    //   2318: aload 11
    //   2320: iload 9
    //   2322: iload_3
    //   2323: invokestatic 3037	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   2326: return
    //   2327: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2330: ifeq +41 -> 2371
    //   2333: new 78	java/lang/StringBuilder
    //   2336: dup
    //   2337: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   2340: astore_1
    //   2341: aload_1
    //   2342: ldc_w 3039
    //   2345: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2348: pop
    //   2349: aload_1
    //   2350: aload_2
    //   2351: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2354: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2357: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2360: pop
    //   2361: ldc 92
    //   2363: iconst_2
    //   2364: aload_1
    //   2365: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    int i = SharedPreUtils.bl(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int j = SharedPreUtils.bm(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int m = AppSetting.d();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, String.format("received TimUserSpecial remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m) }));
    }
    if (j != m)
    {
      SharedPreUtils.M(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), m);
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
        localObject2 = TIMUserManager.b().d(paramQQAppInterface);
        String str = TIMUserManager.b().e(paramQQAppInterface);
        if (!((String)localObject2).equals(localObject1)) {
          break label486;
        }
        if (str.equals(paramConfig)) {
          break label480;
        }
      }
      catch (JSONException paramQQAppInterface) {}
      TIMUserManager.b().a(0, j, (String)localObject1, "", paramConfig, "", bool, 0);
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
    //   1: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: istore 34
    //   9: aload_1
    //   10: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: aload_1
    //   14: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   17: invokestatic 1172	com/tencent/mobileqq/utils/SharedPreUtils:H	(Landroid/content/Context;Ljava/lang/String;)I
    //   20: istore_3
    //   21: aload_1
    //   22: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: aload_1
    //   26: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokestatic 1178	com/tencent/mobileqq/utils/SharedPreUtils:D	(Landroid/content/Context;Ljava/lang/String;)I
    //   32: istore 4
    //   34: invokestatic 1182	com/tencent/common/config/AppSetting:d	()I
    //   37: istore 5
    //   39: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
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
    //   69: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: iload_3
    //   76: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: iload 4
    //   84: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: aastore
    //   88: dup
    //   89: iconst_3
    //   90: iload 5
    //   92: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: invokestatic 551	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   99: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: iload 4
    //   104: iload 5
    //   106: if_icmpeq +18 -> 124
    //   109: aload_1
    //   110: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   113: aload_1
    //   114: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   117: iload 5
    //   119: invokestatic 3074	com/tencent/mobileqq/utils/SharedPreUtils:i	(Landroid/content/Context;Ljava/lang/String;I)V
    //   122: iconst_0
    //   123: istore_3
    //   124: iload 34
    //   126: iload_3
    //   127: if_icmpeq +3621 -> 3748
    //   130: aload_2
    //   131: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   134: astore 43
    //   136: ldc 92
    //   138: astore 42
    //   140: aload 43
    //   142: ifnull +3562 -> 3704
    //   145: aload_2
    //   146: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   149: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   152: ifle +3552 -> 3704
    //   155: aload_2
    //   156: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   159: invokevirtual 2720	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   162: astore 43
    //   164: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +38 -> 205
    //   170: ldc 92
    //   172: iconst_2
    //   173: ldc_w 3076
    //   176: iconst_2
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_2
    //   183: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   186: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   189: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: ldc_w 3078
    //   198: aastore
    //   199: invokestatic 551	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   202: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload 43
    //   207: invokeinterface 115 1 0
    //   212: astore 58
    //   214: iconst_0
    //   215: istore 33
    //   217: aload 58
    //   219: invokeinterface 120 1 0
    //   224: ifeq +3524 -> 3748
    //   227: aload 58
    //   229: invokeinterface 124 1 0
    //   234: checkcast 126	java/lang/String
    //   237: astore 43
    //   239: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +84 -> 326
    //   245: new 78	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   252: astore 44
    //   254: aload 44
    //   256: ldc_w 3080
    //   259: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 44
    //   265: aload 43
    //   267: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 44
    //   273: ldc_w 474
    //   276: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 44
    //   282: aload_2
    //   283: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   286: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   289: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 44
    //   295: ldc_w 3082
    //   298: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 44
    //   304: aload_2
    //   305: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   308: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   311: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 42
    //   317: iconst_2
    //   318: aload 44
    //   320: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: aconst_null
    //   327: astore 46
    //   329: aconst_null
    //   330: astore 48
    //   332: aconst_null
    //   333: astore 49
    //   335: aload 43
    //   337: ldc_w 3084
    //   340: invokevirtual 485	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   477: invokevirtual 2301	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   480: istore 35
    //   482: iload 35
    //   484: ifeq +94 -> 578
    //   487: iload 14
    //   489: istore 15
    //   491: lload 36
    //   493: lstore 40
    //   495: aload 57
    //   497: ldc_w 481
    //   500: invokevirtual 485	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   503: iconst_1
    //   504: aaload
    //   505: invokevirtual 470	java/lang/String:trim	()Ljava/lang/String;
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
    //   540: invokestatic 853	java/lang/Integer:parseInt	(Ljava/lang/String;)I
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
    //   591: invokevirtual 2301	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   594: ifeq +94 -> 688
    //   597: iload 14
    //   599: istore 15
    //   601: lload 36
    //   603: lstore 40
    //   605: aload 57
    //   607: ldc_w 481
    //   610: invokevirtual 485	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   613: iconst_1
    //   614: aaload
    //   615: invokevirtual 470	java/lang/String:trim	()Ljava/lang/String;
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
    //   650: invokestatic 853	java/lang/Integer:parseInt	(Ljava/lang/String;)I
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
    //   701: invokevirtual 2301	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
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
    //   735: new 128	org/json/JSONObject
    //   738: dup
    //   739: aload 57
    //   741: ldc_w 481
    //   744: invokevirtual 485	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   747: iconst_1
    //   748: aaload
    //   749: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
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
    //   783: invokevirtual 609	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
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
    //   817: invokevirtual 609	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
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
    //   851: invokevirtual 609	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   854: astore 57
    //   856: aload 59
    //   858: ldc_w 3100
    //   861: invokevirtual 609	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   864: astore 47
    //   866: aload 57
    //   868: iconst_1
    //   869: aload 57
    //   871: invokevirtual 2151	java/lang/String:length	()I
    //   874: iconst_1
    //   875: isub
    //   876: invokevirtual 3102	java/lang/String:substring	(II)Ljava/lang/String;
    //   879: astore 46
    //   881: aload 47
    //   883: iconst_1
    //   884: aload 47
    //   886: invokevirtual 2151	java/lang/String:length	()I
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
    //   925: invokevirtual 218	org/json/JSONObject:optInt	(Ljava/lang/String;)I
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
    //   959: invokevirtual 218	org/json/JSONObject:optInt	(Ljava/lang/String;)I
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
    //   993: invokevirtual 218	org/json/JSONObject:optInt	(Ljava/lang/String;)I
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
    //   1265: invokevirtual 2301	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1268: ifeq +35 -> 1303
    //   1271: iload 14
    //   1273: istore 15
    //   1275: lload 36
    //   1277: lstore 40
    //   1279: aload 57
    //   1281: ldc_w 481
    //   1284: invokevirtual 485	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1287: iconst_1
    //   1288: aaload
    //   1289: invokevirtual 470	java/lang/String:trim	()Ljava/lang/String;
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
    //   1316: invokevirtual 2301	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1319: ifeq +36 -> 1355
    //   1322: iload 12
    //   1324: istore 15
    //   1326: lload 38
    //   1328: lstore 40
    //   1330: aload 57
    //   1332: ldc_w 481
    //   1335: invokevirtual 485	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1338: iconst_1
    //   1339: aaload
    //   1340: invokevirtual 470	java/lang/String:trim	()Ljava/lang/String;
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
    //   1364: invokevirtual 2301	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1367: ifeq +21 -> 1388
    //   1370: aload 57
    //   1372: ldc_w 481
    //   1375: invokevirtual 485	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1378: iconst_1
    //   1379: aaload
    //   1380: invokevirtual 470	java/lang/String:trim	()Ljava/lang/String;
    //   1383: astore 49
    //   1385: goto +7 -> 1392
    //   1388: aload 43
    //   1390: astore 49
    //   1392: aload 57
    //   1394: ldc_w 3122
    //   1397: invokevirtual 2301	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1400: ifeq +85 -> 1485
    //   1403: aload 57
    //   1405: ldc_w 481
    //   1408: invokevirtual 485	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1411: iconst_1
    //   1412: aaload
    //   1413: invokevirtual 470	java/lang/String:trim	()Ljava/lang/String;
    //   1416: invokestatic 2767	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1419: invokevirtual 1274	java/lang/Integer:intValue	()I
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
    //   1494: invokevirtual 2301	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1497: ifeq +2296 -> 3793
    //   1500: aload 57
    //   1502: ldc_w 481
    //   1505: invokevirtual 485	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   1537: invokevirtual 470	java/lang/String:trim	()Ljava/lang/String;
    //   1540: invokestatic 2767	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1543: invokevirtual 1274	java/lang/Integer:intValue	()I
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
    //   1620: invokevirtual 2301	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
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
    //   1651: ldc_w 481
    //   1654: invokevirtual 485	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1657: iconst_1
    //   1658: aaload
    //   1659: invokevirtual 470	java/lang/String:trim	()Ljava/lang/String;
    //   1662: invokestatic 2767	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1665: invokevirtual 1274	java/lang/Integer:intValue	()I
    //   1668: istore 5
    //   1670: iload 5
    //   1672: ifle +6 -> 1678
    //   1675: goto +12 -> 1687
    //   1678: getstatic 3130	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:s	I
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
    //   1737: invokevirtual 2301	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
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
    //   1768: ldc_w 481
    //   1771: invokevirtual 485	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1774: iconst_1
    //   1775: aaload
    //   1776: invokevirtual 470	java/lang/String:trim	()Ljava/lang/String;
    //   1779: invokestatic 2767	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1782: invokevirtual 1274	java/lang/Integer:intValue	()I
    //   1785: istore_3
    //   1786: iload_3
    //   1787: ifle +6 -> 1793
    //   1790: goto +11 -> 1801
    //   1793: getstatic 3134	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:t	I
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
    //   1852: invokevirtual 2301	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
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
    //   1884: ldc_w 481
    //   1887: invokevirtual 485	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   1920: invokestatic 3138	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1923: astore 43
    //   1925: aload 51
    //   1927: iconst_1
    //   1928: aaload
    //   1929: invokestatic 3140	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:f	(Ljava/lang/String;)I
    //   1932: istore 4
    //   1934: aload 51
    //   1936: iconst_1
    //   1937: aaload
    //   1938: invokestatic 3142	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:e	(Ljava/lang/String;)I
    //   1941: istore 23
    //   1943: aload 51
    //   1945: iconst_1
    //   1946: aaload
    //   1947: invokestatic 3144	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:d	(Ljava/lang/String;)I
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
    //   1980: invokestatic 3146	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:g	(Ljava/lang/String;)I
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
    //   2092: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2095: ifeq +115 -> 2210
    //   2098: new 78	java/lang/StringBuilder
    //   2101: dup
    //   2102: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   2105: astore 45
    //   2107: aload 45
    //   2109: ldc_w 3148
    //   2112: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2115: pop
    //   2116: aload 45
    //   2118: aload 43
    //   2120: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2123: pop
    //   2124: aload 45
    //   2126: ldc_w 3150
    //   2129: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: pop
    //   2133: aload 45
    //   2135: iload_3
    //   2136: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2139: pop
    //   2140: aload 45
    //   2142: ldc_w 3152
    //   2145: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2148: pop
    //   2149: aload 45
    //   2151: iload 4
    //   2153: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2156: pop
    //   2157: aload 45
    //   2159: ldc_w 3154
    //   2162: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: pop
    //   2166: aload 45
    //   2168: iload 18
    //   2170: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2173: pop
    //   2174: aload 45
    //   2176: ldc_w 3156
    //   2179: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2182: pop
    //   2183: aload 45
    //   2185: iload 19
    //   2187: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2190: pop
    //   2191: aload 55
    //   2193: iconst_2
    //   2194: aload 45
    //   2196: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   3063: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3066: ifeq +47 -> 3113
    //   3069: new 78	java/lang/StringBuilder
    //   3072: dup
    //   3073: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   3076: astore 50
    //   3078: aload 50
    //   3080: ldc_w 3158
    //   3083: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3086: pop
    //   3087: aload 50
    //   3089: aload 43
    //   3091: invokevirtual 2032	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3094: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3097: pop
    //   3098: ldc_w 3160
    //   3101: iconst_2
    //   3102: aload 50
    //   3104: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3107: invokestatic 533	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   3206: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3209: ifeq +43 -> 3252
    //   3212: ldc_w 3162
    //   3215: iconst_2
    //   3216: ldc_w 3164
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
    //   3243: invokestatic 551	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3246: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3249: goto +3 -> 3252
    //   3252: aload_1
    //   3253: iconst_5
    //   3254: invokestatic 3167	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:c	(Lcom/tencent/mobileqq/app/QQAppInterface;I)Ljava/lang/String;
    //   3257: astore 50
    //   3259: aload_1
    //   3260: bipush 6
    //   3262: invokestatic 3167	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:c	(Lcom/tencent/mobileqq/app/QQAppInterface;I)Ljava/lang/String;
    //   3265: astore 51
    //   3267: aload 48
    //   3269: ifnull +34 -> 3303
    //   3272: aload 48
    //   3274: aload 50
    //   3276: invokevirtual 490	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3279: ifeq +24 -> 3303
    //   3282: aload 49
    //   3284: ifnull +19 -> 3303
    //   3287: aload 49
    //   3289: aload 51
    //   3291: invokevirtual 490	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3294: ifne +6 -> 3300
    //   3297: goto +6 -> 3303
    //   3300: goto +26 -> 3326
    //   3303: iconst_0
    //   3304: putstatic 3169	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:I	Z
    //   3307: iconst_0
    //   3308: putstatic 3171	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:J	Z
    //   3311: iconst_0
    //   3312: invokestatic 3173	com/tencent/mobileqq/utils/SharedPreUtils:d	(Z)V
    //   3315: aload_1
    //   3316: aload 48
    //   3318: aload 49
    //   3320: getstatic 3175	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:d	Ljava/lang/String;
    //   3323: invokestatic 3178	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3326: aload_1
    //   3327: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3330: aload_1
    //   3331: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3334: iload 17
    //   3336: aload 48
    //   3338: aload 49
    //   3340: aload 47
    //   3342: aload 44
    //   3344: iload 11
    //   3346: iload 10
    //   3348: iload 21
    //   3350: iload 16
    //   3352: invokestatic 3181	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIII)V
    //   3355: aload_1
    //   3356: iload 17
    //   3358: aload 48
    //   3360: aload 49
    //   3362: aload 47
    //   3364: aload 44
    //   3366: iload 11
    //   3368: iload 21
    //   3370: iload 16
    //   3372: invokestatic 3184	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V
    //   3375: iload 10
    //   3377: invokestatic 3185	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:b	(I)V
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
    //   3409: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3412: aload_1
    //   3413: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3416: iconst_0
    //   3417: invokevirtual 655	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   3420: invokeinterface 661 1 0
    //   3425: ldc_w 3187
    //   3428: iconst_0
    //   3429: invokeinterface 2532 3 0
    //   3434: invokeinterface 672 1 0
    //   3439: pop
    //   3440: aload_1
    //   3441: iconst_0
    //   3442: invokestatic 3189	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   3445: aload_1
    //   3446: iconst_0
    //   3447: invokestatic 3190	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   3450: iload 7
    //   3452: iload_3
    //   3453: iload 8
    //   3455: iload 5
    //   3457: invokestatic 3193	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(IIII)V
    //   3460: aload_1
    //   3461: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3464: aload_1
    //   3465: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3468: iload 34
    //   3470: iconst_1
    //   3471: iload 7
    //   3473: iload_3
    //   3474: iload 8
    //   3476: iload 5
    //   3478: invokestatic 3196	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;IZIIII)V
    //   3481: aload 46
    //   3483: invokestatic 3197	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(Ljava/lang/String;)V
    //   3486: aload_1
    //   3487: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3490: aload_1
    //   3491: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3494: iload 34
    //   3496: aload 46
    //   3498: invokestatic 3200	com/tencent/mobileqq/utils/SharedPreUtils:c	(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;)V
    //   3501: iload 6
    //   3503: invokestatic 3201	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(I)V
    //   3506: aload_1
    //   3507: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3510: aload_1
    //   3511: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3514: iload 34
    //   3516: iload 6
    //   3518: invokestatic 3203	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;II)V
    //   3521: iload 4
    //   3523: invokestatic 3204	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:c	(I)V
    //   3526: aload_1
    //   3527: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3530: aload_1
    //   3531: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3534: iload 34
    //   3536: iload 4
    //   3538: invokestatic 3206	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;Ljava/lang/String;II)V
    //   3541: iload 20
    //   3543: iload 22
    //   3545: invokestatic 3209	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:a	(II)V
    //   3548: aload_1
    //   3549: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3552: aload_1
    //   3553: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3556: iload 34
    //   3558: iload 20
    //   3560: iload 22
    //   3562: invokestatic 3212	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;III)V
    //   3565: goto +3 -> 3568
    //   3568: iload 14
    //   3570: ifeq +126 -> 3696
    //   3573: iload 13
    //   3575: ifeq +121 -> 3696
    //   3578: iload 13
    //   3580: ifeq +116 -> 3696
    //   3583: aload_1
    //   3584: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3587: invokestatic 3218	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   3590: astore 44
    //   3592: new 78	java/lang/StringBuilder
    //   3595: dup
    //   3596: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   3599: astore 46
    //   3601: aload 46
    //   3603: aload_1
    //   3604: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3607: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3610: pop
    //   3611: aload 46
    //   3613: ldc_w 3220
    //   3616: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3619: pop
    //   3620: aload 46
    //   3622: ldc_w 3118
    //   3625: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3628: pop
    //   3629: aload 44
    //   3631: aload 46
    //   3633: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3636: ldc 8
    //   3638: invokeinterface 962 3 0
    //   3643: astore 44
    //   3645: aload_1
    //   3646: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3649: aload_1
    //   3650: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3653: iload 34
    //   3655: lload 36
    //   3657: aload 45
    //   3659: aload 43
    //   3661: invokestatic 3223	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V
    //   3664: aload 45
    //   3666: ifnull +30 -> 3696
    //   3669: aload 45
    //   3671: aload 44
    //   3673: invokevirtual 490	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3676: ifne +20 -> 3696
    //   3679: aload_1
    //   3680: getstatic 3226	com/tencent/mobileqq/app/BusinessHandlerFactory:POKE_BIG_RES_HANDLER	Ljava/lang/String;
    //   3683: invokevirtual 1321	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   3686: checkcast 3228	com/tencent/mobileqq/app/utils/PokeBigResHandler
    //   3689: iconst_1
    //   3690: invokevirtual 3229	com/tencent/mobileqq/app/utils/PokeBigResHandler:a	(Z)V
    //   3693: goto +3 -> 3696
    //   3696: iload 4
    //   3698: invokestatic 3204	com/tencent/mobileqq/activity/aio/item/PokeItemHelper:c	(I)V
    //   3701: goto -3487 -> 214
    //   3704: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3707: ifeq +41 -> 3748
    //   3710: new 78	java/lang/StringBuilder
    //   3713: dup
    //   3714: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   3717: astore_1
    //   3718: aload_1
    //   3719: ldc_w 3231
    //   3722: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3725: pop
    //   3726: aload_1
    //   3727: aload_2
    //   3728: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3731: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3734: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3737: pop
    //   3738: ldc 92
    //   3740: iconst_2
    //   3741: aload_1
    //   3742: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
        int j = SharedPreUtils.W(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
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
            paramConfig.c = true;
            paramConfig.d = bool1;
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
    if (j == SharedPreUtils.ab(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()))
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
    int k = ShortVideoResourceManager.e();
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
    return QConfigHelper.a(paramConfig, paramInt1, paramInt2);
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
            ((ARGlobalConfigManager)localObject).e();
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
        SharedPreUtils.h(paramQQAppInterface.getApplication(), paramInt, a);
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
  
  private void b(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.s("local_qr_login_version");
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
  
  public static List<String> c(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
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
      int j = SharedPreUtils.v(paramQQAppInterface.getApp(), paramIntent);
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
    int j = SharedPreUtils.aa(BaseApplication.getContext(), a);
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
      SharedPreUtils.r(BaseApplication.getContext(), i, a);
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
        SharedPreUtils.i(paramQQAppInterface.getApplication(), paramInt, a);
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
      int j = SharedPreUtils.w(paramQQAppInterface.getApp(), paramIntent);
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
      localPicAndAdConf1 = Config.c;
      localPicAndAdConf2 = Config.c;
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
    int i = SharedPreUtils.n(paramQQAppInterface.getApp());
    if (!CapturePtvTemplateManager.b()) {
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
        paramString.append(a);
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
    int i = SharedPreUtils.m(paramQQAppInterface.getApp());
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
    int i = SharedPreUtils.o(paramQQAppInterface.getApp());
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
      int j = SharedPreUtils.i(paramQQAppInterface.getApp());
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
          localNearbyGrayTipsManager.c();
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
            if (!StringUtil.isEmpty(str))
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
      if (!StringUtil.isEmpty((String)localObject1))
      {
        localObject2 = NearbyGrayTipsManager.d();
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
      localNearbyGrayTipsManager.c();
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
    if (i == SharedPreUtils.t(paramQQAppInterface.getApp(), a)) {
      return;
    }
    SharedPreUtils.j(paramQQAppInterface.getApp(), i, a);
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
        localObject1 = paramQQAppInterface.getNowLiveManager().d();
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
        paramQQAppInterface.getNowLiveManager().i = paramConfig.charAt(0);
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
        paramQQAppInterface.getNowLiveManager().f = Integer.valueOf(paramConfig).intValue();
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
    int j = SharedPreUtils.u(paramQQAppInterface.getApp(), a);
    if (i == j) {
      return;
    }
    SharedPreUtils.k(paramQQAppInterface.getApp(), i, a);
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
    int i = SharedPreUtils.r(paramQQAppInterface.getApp());
    if (!PtvTemplateManager.i()) {
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
    int m = SharedPreUtils.aY(paramQQAppInterface.getApp().getBaseContext(), a);
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
            bool2 = ScribbleResMgr.a((String)localObject2, paramQQAppInterface.getApp().getBaseContext(), a);
          }
        }
        j += 1;
      }
      if (bool1) {
        SharedPreUtils.u(paramQQAppInterface.getApp().getBaseContext(), k, a);
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
    int j = SharedPreUtils.bh(BaseApplication.getContext(), a);
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
      SharedPreUtils.K(BaseApplication.getContext(), a, i);
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
              SharedPreUtils.e(BaseApplication.getContext(), a, "receipt_kReceiptMsgEnable", i);
            }
            if (((JSONObject)localObject).has("kReceiptMsgMaxSendTimes"))
            {
              i = ((JSONObject)localObject).getInt("kReceiptMsgMaxSendTimes");
              SharedPreUtils.e(BaseApplication.getContext(), a, "receipt_kReceiptMsgSendTimes", i);
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
      String str = a(paramConfig, SharedPreUtils.c(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0"), 281);
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
          com.tencent.mobileqq.utils.AIOAnimationControlManager.c = i;
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
      int i = SharedPreUtils.c(paramQQAppInterface.getApp(), "task_entry_config_version", a);
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
        ((StringBuilder)localObject2).append(a);
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
    SharedPreUtils.a(paramQQAppInterface.getApp(), "task_entry_config_version", a, j);
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
    int j = SharedPreUtils.c(paramQQAppInterface.getApp(), "buluo_enter_config_version", a);
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
            SharedPreUtils.e(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
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
          SharedPreUtils.f(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
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
    SharedPreUtils.a(paramQQAppInterface.getApp(), "buluo_enter_config_version", a, i);
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
          paramIntent.append(CameraUtils.d(BaseApplicationImpl.getContext()));
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
        FaceScanDownloadManager.e(paramQQAppInterface);
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
            if ((j == SharedPreUtils.T(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) && (paramConfig.content_list.size() <= 0))
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
    a = paramString;
    a((QQAppInterface)paramAppRuntime, paramIntent, paramReqGetConfig, paramArrayOfInt, paramList, paramList1);
  }
  
  /* Error */
  public void a(AppRuntime paramAppRuntime, ConfigurationService.RespGetConfig paramRespGetConfig, Intent paramIntent, List<Integer> paramList, int[] paramArrayOfInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 143	com/tencent/mobileqq/app/QQAppInterface
    //   4: astore 17
    //   6: aload_2
    //   7: getfield 4252	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   10: invokevirtual 392	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   13: istore 7
    //   15: new 1026	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 1027	java/util/ArrayList:<init>	()V
    //   22: astore 18
    //   24: iconst_0
    //   25: istore 11
    //   27: aconst_null
    //   28: astore_1
    //   29: iconst_0
    //   30: istore 13
    //   32: aload_3
    //   33: astore 5
    //   35: iload 11
    //   37: iload 7
    //   39: if_icmpge +13481 -> 13520
    //   42: aload_2
    //   43: getfield 4252	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   46: iload 11
    //   48: invokevirtual 395	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   51: checkcast 47	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   54: astore 19
    //   56: aload 19
    //   58: ifnonnull +10 -> 68
    //   61: iload 7
    //   63: istore 8
    //   65: goto +46 -> 111
    //   68: aload 19
    //   70: getfield 2229	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   73: invokevirtual 4253	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   76: ifne +10 -> 86
    //   79: iload 7
    //   81: istore 8
    //   83: goto +28 -> 111
    //   86: aload 19
    //   88: getfield 2229	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   91: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   94: istore 10
    //   96: invokestatic 4256	com/tencent/mobileqq/config/QConfigManager:b	()Lcom/tencent/mobileqq/config/QConfigManager;
    //   99: iload 10
    //   101: invokevirtual 4258	com/tencent/mobileqq/config/QConfigManager:c	(I)Z
    //   104: ifeq +21 -> 125
    //   107: iload 7
    //   109: istore 8
    //   111: iload 8
    //   113: istore 9
    //   115: iload 13
    //   117: istore 14
    //   119: aload_1
    //   120: astore 16
    //   122: goto +13378 -> 13500
    //   125: aload 4
    //   127: iload 10
    //   129: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: invokeinterface 4260 2 0
    //   137: pop
    //   138: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +14 -> 155
    //   144: aload 18
    //   146: iload 10
    //   148: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: invokevirtual 3408	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   154: pop
    //   155: iload 10
    //   157: iconst_1
    //   158: if_icmpeq +12798 -> 12956
    //   161: iload 10
    //   163: iconst_2
    //   164: if_icmpeq +11938 -> 12102
    //   167: iload 10
    //   169: iconst_3
    //   170: if_icmpeq +11435 -> 11605
    //   173: iload 10
    //   175: iconst_5
    //   176: if_icmpeq +11012 -> 11188
    //   179: iload 10
    //   181: bipush 6
    //   183: if_icmpeq +10966 -> 11149
    //   186: iload 10
    //   188: bipush 12
    //   190: if_icmpeq +10345 -> 10535
    //   193: iload 10
    //   195: bipush 13
    //   197: if_icmpeq +10301 -> 10498
    //   200: iload 10
    //   202: bipush 46
    //   204: if_icmpeq +10265 -> 10469
    //   207: iload 10
    //   209: bipush 47
    //   211: if_icmpeq +9877 -> 10088
    //   214: iload 10
    //   216: bipush 55
    //   218: if_icmpeq +9272 -> 9490
    //   221: iload 10
    //   223: bipush 56
    //   225: if_icmpeq +9236 -> 9461
    //   228: iload 10
    //   230: bipush 96
    //   232: if_icmpeq +9200 -> 9432
    //   235: iload 10
    //   237: bipush 97
    //   239: if_icmpeq +9164 -> 9403
    //   242: iload 7
    //   244: istore 8
    //   246: iload 10
    //   248: lookupswitch	default:+1060->1308, 10:+8595->8843, 23:+8564->8812, 31:+8223->8471, 34:+8194->8442, 38:+7856->8104, 49:+7827->8075, 53:+7796->8044, 61:+7767->8015, 63:+7738->7986, 64:+7709->7957, 65:+7620->7868, 66:+7591->7839, 69:+7562->7810, 82:+7533->7781, 84:+7502->7750, 90:+7084->7332, 93:+6746->6994, 101:+6715->6963, 102:+6686->6934, 109:+6644->6892, 111:+6615->6863, 115:+6584->6832, 116:+5593->5841, 118:+5564->5812, 119:+5535->5783, 121:+5506->5754, 129:+5477->5725, 130:+5448->5696, 139:+5419->5667, 140:+5390->5638, 142:+5361->5609, 143:+5332->5580, 145:+5301->5549, 146:+5272->5520, 147:+5243->5491, 148:+5214->5462, 149:+5181->5429, 153:+5152->5400, 155:+5123->5371, 156:+-137->111, 157:+5094->5342, 165:+5065->5313, 166:+5023->5271, 167:+4992->5240, 171:+4963->5211, 174:+4934->5182, 177:+4905->5153, 180:+5181->5429, 181:+4876->5124, 182:+4847->5095, 184:+4818->5066, 185:+4789->5037, 187:+4760->5008, 188:+4729->4977, 191:+4700->4948, 193:+4042->4290, 194:+4013->4261, 195:+3984->4232, 201:+3955->4203, 202:+3926->4174, 204:+3897->4145, 205:+3866->4114, 210:+3837->4085, 211:+3809->4057, 212:+3781->4029, 215:+3741->3989, 218:+5181->5429, 222:+3675->3923, 223:+3637->3885, 225:+3535->3783, 226:+3504->3752, 227:+3475->3723, 228:+3446->3694, 232:+3420->3668, 234:+3391->3639, 235:+3362->3610, 238:+3333->3581, 244:+3304->3552, 245:+3275->3523, 247:+3246->3494, 253:+3217->3465, 254:+3188->3436, 256:+3159->3407, 257:+3130->3378, 259:+3101->3349, 260:+3072->3320, 262:+3043->3291, 268:+3014->3262, 269:+2985->3233, 272:+2956->3204, 273:+2928->3176, 274:+2900->3148, 280:+2871->3119, 281:+2842->3090, 283:+2813->3061, 284:+2784->3032, 286:+2753->3001, 289:+2724->2972, 295:+2695->2943, 297:+2665->2913, 301:+2632->2880, 312:+2595->2843, 313:+2564->2812, 320:+2522->2770, 321:+2494->2742, 328:+2465->2713, 331:+2436->2684, 336:+2408->2656, 337:+2370->2618, 345:+2340->2588, 347:+2311->2559, 349:+2269->2517, 364:+3637->3885, 365:+3637->3885, 371:+2240->2488, 384:+2212->2460, 385:+2183->2431, 386:+2144->2392, 387:+2115->2363, 392:+2086->2334, 393:+2047->2295, 394:+2018->2266, 397:+1958->2206, 400:+1927->2175, 403:+1899->2147, 404:+1871->2119, 410:+1828->2076, 596:+1799->2047, 604:+1770->2018, 705:+1743->1991, 718:+1703->1951
    //   1309: lconst_1
    //   1310: tableswitch	default:+26 -> 1336, 42:+602->1912, 43:+573->1883, 44:+214->1524
    //   1337: lconst_1
    //   1338: tableswitch	default:+30 -> 1368, 72:+171->1509, 73:+156->1494, 74:+141->1479, 75:+126->1464
    //   1369: lconst_1
    //   1370: tableswitch	default:+26 -> 1396, 78:+77->1447, 79:+62->1432, 80:+47->1417
    //   1397: sipush -18940
    //   1400: lor
    //   1401: aload 17
    //   1403: aload 19
    //   1405: iload 10
    //   1407: invokevirtual 4262	com/tencent/mobileqq/config/CfgProcess:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   1410: iload 7
    //   1412: istore 8
    //   1414: goto -1303 -> 111
    //   1417: aload_0
    //   1418: aload 17
    //   1420: aload 19
    //   1422: invokespecial 4264	com/tencent/mobileqq/config/splashlogo/ConfigServlet:W	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1425: iload 7
    //   1427: istore 8
    //   1429: goto -1318 -> 111
    //   1432: aload_0
    //   1433: aload 17
    //   1435: aload 19
    //   1437: invokevirtual 4266	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1440: iload 7
    //   1442: istore 8
    //   1444: goto -1333 -> 111
    //   1447: aload_0
    //   1448: aload 17
    //   1450: aload 5
    //   1452: aload 19
    //   1454: invokespecial 4268	com/tencent/mobileqq/config/splashlogo/ConfigServlet:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1457: iload 7
    //   1459: istore 8
    //   1461: goto -1350 -> 111
    //   1464: aload_0
    //   1465: aload 17
    //   1467: aload 19
    //   1469: invokespecial 4270	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aw	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1472: iload 7
    //   1474: istore 8
    //   1476: goto -1365 -> 111
    //   1479: aload_0
    //   1480: aload 17
    //   1482: aload 19
    //   1484: invokespecial 4272	com/tencent/mobileqq/config/splashlogo/ConfigServlet:as	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1487: iload 7
    //   1489: istore 8
    //   1491: goto -1380 -> 111
    //   1494: aload_0
    //   1495: aload 17
    //   1497: aload 19
    //   1499: invokevirtual 4274	com/tencent/mobileqq/config/splashlogo/ConfigServlet:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1502: iload 7
    //   1504: istore 8
    //   1506: goto -1395 -> 111
    //   1509: aload_0
    //   1510: aload 17
    //   1512: aload 19
    //   1514: invokevirtual 4276	com/tencent/mobileqq/config/splashlogo/ConfigServlet:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1517: iload 7
    //   1519: istore 8
    //   1521: goto -1410 -> 111
    //   1524: iload 7
    //   1526: istore 9
    //   1528: aload 19
    //   1530: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1533: ifnull +241 -> 1774
    //   1536: iload 7
    //   1538: istore 9
    //   1540: aload 19
    //   1542: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1545: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   1548: ifle +226 -> 1774
    //   1551: iload 7
    //   1553: istore 9
    //   1555: aload 17
    //   1557: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1560: aload 19
    //   1562: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1565: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1568: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   1571: invokestatic 4278	com/tencent/mobileqq/utils/SharedPreUtils:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   1574: iconst_0
    //   1575: istore 10
    //   1577: iload 7
    //   1579: istore 8
    //   1581: iload 7
    //   1583: istore 9
    //   1585: iload 10
    //   1587: aload 19
    //   1589: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1592: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   1595: if_icmpge -1484 -> 111
    //   1598: iload 7
    //   1600: istore 9
    //   1602: aload 19
    //   1604: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1607: iload 10
    //   1609: invokevirtual 467	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   1612: checkcast 126	java/lang/String
    //   1615: astore 5
    //   1617: iload 7
    //   1619: istore 9
    //   1621: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1624: ifeq +12111 -> 13735
    //   1627: iload 7
    //   1629: istore 9
    //   1631: new 78	java/lang/StringBuilder
    //   1634: dup
    //   1635: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1638: astore 16
    //   1640: iload 7
    //   1642: istore 9
    //   1644: aload_1
    //   1645: astore 15
    //   1647: iload 9
    //   1649: istore 8
    //   1651: aload 16
    //   1653: ldc_w 4280
    //   1656: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: pop
    //   1660: aload_1
    //   1661: astore 15
    //   1663: iload 9
    //   1665: istore 8
    //   1667: aload 16
    //   1669: aload 5
    //   1671: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1674: pop
    //   1675: aload_1
    //   1676: astore 15
    //   1678: iload 9
    //   1680: istore 8
    //   1682: aload 16
    //   1684: ldc_w 474
    //   1687: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1690: pop
    //   1691: aload_1
    //   1692: astore 15
    //   1694: iload 9
    //   1696: istore 8
    //   1698: aload 16
    //   1700: aload 19
    //   1702: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1705: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1708: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1711: pop
    //   1712: aload_1
    //   1713: astore 15
    //   1715: iload 9
    //   1717: istore 8
    //   1719: ldc 92
    //   1721: iconst_2
    //   1722: aload 16
    //   1724: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1727: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1730: goto +3 -> 1733
    //   1733: aload_1
    //   1734: astore 15
    //   1736: iload 7
    //   1738: istore 8
    //   1740: aload 5
    //   1742: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1745: ifne +11993 -> 13738
    //   1748: aload_1
    //   1749: astore 15
    //   1751: iload 7
    //   1753: istore 8
    //   1755: aload 17
    //   1757: getstatic 3463	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   1760: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1763: checkcast 3465	com/tencent/mobileqq/app/HotChatManager
    //   1766: aload 5
    //   1768: invokevirtual 4282	com/tencent/mobileqq/app/HotChatManager:k	(Ljava/lang/String;)V
    //   1771: goto +11967 -> 13738
    //   1774: aload_1
    //   1775: astore 16
    //   1777: iload 13
    //   1779: istore 14
    //   1781: iload 7
    //   1783: istore 9
    //   1785: aload_1
    //   1786: astore 15
    //   1788: iload 7
    //   1790: istore 8
    //   1792: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1795: ifeq -1673 -> 122
    //   1798: aload_1
    //   1799: astore 15
    //   1801: iload 7
    //   1803: istore 8
    //   1805: new 78	java/lang/StringBuilder
    //   1808: dup
    //   1809: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1812: astore 5
    //   1814: aload_1
    //   1815: astore 15
    //   1817: iload 7
    //   1819: istore 8
    //   1821: aload 5
    //   1823: ldc_w 4284
    //   1826: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: pop
    //   1830: aload_1
    //   1831: astore 15
    //   1833: iload 7
    //   1835: istore 8
    //   1837: aload 5
    //   1839: aload 19
    //   1841: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1844: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1847: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1850: pop
    //   1851: aload_1
    //   1852: astore 15
    //   1854: iload 7
    //   1856: istore 8
    //   1858: ldc 92
    //   1860: iconst_2
    //   1861: aload 5
    //   1863: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1866: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1869: aload_1
    //   1870: astore 16
    //   1872: iload 13
    //   1874: istore 14
    //   1876: iload 7
    //   1878: istore 9
    //   1880: goto -1758 -> 122
    //   1883: aload_1
    //   1884: astore 15
    //   1886: iload 7
    //   1888: istore 8
    //   1890: aload_0
    //   1891: aload 17
    //   1893: aload 19
    //   1895: invokespecial 4286	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ak	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   1898: aload_1
    //   1899: astore 16
    //   1901: iload 13
    //   1903: istore 14
    //   1905: iload 7
    //   1907: istore 9
    //   1909: goto -1787 -> 122
    //   1912: aload_1
    //   1913: astore 15
    //   1915: iload 7
    //   1917: istore 8
    //   1919: aload 17
    //   1921: ldc_w 4288
    //   1924: invokevirtual 1279	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   1927: checkcast 4288	com/tencent/mobileqq/qwallet/config/IQWalletConfigService
    //   1930: aload 19
    //   1932: invokeinterface 4291 2 0
    //   1937: aload_1
    //   1938: astore 16
    //   1940: iload 13
    //   1942: istore 14
    //   1944: iload 7
    //   1946: istore 9
    //   1948: goto -1826 -> 122
    //   1951: aload_1
    //   1952: astore 15
    //   1954: iload 7
    //   1956: istore 8
    //   1958: aload_0
    //   1959: aload 17
    //   1961: aload 19
    //   1963: aload 5
    //   1965: ldc_w 4293
    //   1968: invokevirtual 1224	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1971: invokespecial 4295	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)I
    //   1974: invokestatic 4296	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	(I)V
    //   1977: aload_1
    //   1978: astore 16
    //   1980: iload 13
    //   1982: istore 14
    //   1984: iload 7
    //   1986: istore 9
    //   1988: goto -1866 -> 122
    //   1991: aload_1
    //   1992: astore 15
    //   1994: iload 7
    //   1996: istore 8
    //   1998: aload_0
    //   1999: aload 19
    //   2001: invokespecial 4298	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2004: aload_1
    //   2005: astore 16
    //   2007: iload 13
    //   2009: istore 14
    //   2011: iload 7
    //   2013: istore 9
    //   2015: goto -1893 -> 122
    //   2018: aload_1
    //   2019: astore 15
    //   2021: iload 7
    //   2023: istore 8
    //   2025: aload_0
    //   2026: aload 17
    //   2028: aload 19
    //   2030: invokespecial 4300	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aL	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2033: aload_1
    //   2034: astore 16
    //   2036: iload 13
    //   2038: istore 14
    //   2040: iload 7
    //   2042: istore 9
    //   2044: goto -1922 -> 122
    //   2047: aload_1
    //   2048: astore 15
    //   2050: iload 7
    //   2052: istore 8
    //   2054: aload_0
    //   2055: aload 17
    //   2057: aload 19
    //   2059: invokespecial 4302	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aM	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2062: aload_1
    //   2063: astore 16
    //   2065: iload 13
    //   2067: istore 14
    //   2069: iload 7
    //   2071: istore 9
    //   2073: goto -1951 -> 122
    //   2076: aload_1
    //   2077: astore 15
    //   2079: iload 7
    //   2081: istore 8
    //   2083: aload 17
    //   2085: ldc_w 1276
    //   2088: invokevirtual 1279	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   2091: checkcast 1276	com/tencent/mobileqq/activity/aio/stickerrecommended/IStickerRecManager
    //   2094: aload 17
    //   2096: aload 19
    //   2098: iload 10
    //   2100: invokeinterface 4306 4 0
    //   2105: aload_1
    //   2106: astore 16
    //   2108: iload 13
    //   2110: istore 14
    //   2112: iload 7
    //   2114: istore 9
    //   2116: goto -1994 -> 122
    //   2119: aload_1
    //   2120: astore 15
    //   2122: iload 7
    //   2124: istore 8
    //   2126: aload 17
    //   2128: aload 19
    //   2130: invokestatic 4308	com/tencent/mobileqq/config/splashlogo/ConfigServlet:P	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2133: aload_1
    //   2134: astore 16
    //   2136: iload 13
    //   2138: istore 14
    //   2140: iload 7
    //   2142: istore 9
    //   2144: goto -2022 -> 122
    //   2147: aload_1
    //   2148: astore 15
    //   2150: iload 7
    //   2152: istore 8
    //   2154: aload 17
    //   2156: aload 19
    //   2158: invokestatic 4310	com/tencent/mobileqq/config/splashlogo/ConfigServlet:O	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2161: aload_1
    //   2162: astore 16
    //   2164: iload 13
    //   2166: istore 14
    //   2168: iload 7
    //   2170: istore 9
    //   2172: goto -2050 -> 122
    //   2175: aload_1
    //   2176: astore 15
    //   2178: iload 7
    //   2180: istore 8
    //   2182: aload_0
    //   2183: aload 17
    //   2185: aload 19
    //   2187: iload 10
    //   2189: invokespecial 4311	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   2192: aload_1
    //   2193: astore 16
    //   2195: iload 13
    //   2197: istore 14
    //   2199: iload 7
    //   2201: istore 9
    //   2203: goto -2081 -> 122
    //   2206: aload_1
    //   2207: astore 15
    //   2209: iload 7
    //   2211: istore 8
    //   2213: invokestatic 1291	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:a	()Lcom/tencent/mobileqq/haoliyou/orion/ZhuoXusManager;
    //   2216: getfield 1294	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:a	Lcom/tencent/mobileqq/haoliyou/orion/ZhuoXusManager$ConfigLoader;
    //   2219: aload 19
    //   2221: invokevirtual 4313	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager$ConfigLoader:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2224: aload_1
    //   2225: astore 16
    //   2227: iload 13
    //   2229: istore 14
    //   2231: iload 7
    //   2233: istore 9
    //   2235: goto -2113 -> 122
    //   2238: astore 5
    //   2240: aload_1
    //   2241: astore 15
    //   2243: iload 7
    //   2245: istore 8
    //   2247: aload 5
    //   2249: invokevirtual 1462	java/lang/Throwable:printStackTrace	()V
    //   2252: aload_1
    //   2253: astore 16
    //   2255: iload 13
    //   2257: istore 14
    //   2259: iload 7
    //   2261: istore 9
    //   2263: goto -2141 -> 122
    //   2266: aload_1
    //   2267: astore 15
    //   2269: iload 7
    //   2271: istore 8
    //   2273: aload_0
    //   2274: aload 17
    //   2276: aload 19
    //   2278: invokespecial 4315	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aK	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2281: aload_1
    //   2282: astore 16
    //   2284: iload 13
    //   2286: istore 14
    //   2288: iload 7
    //   2290: istore 9
    //   2292: goto -2170 -> 122
    //   2295: aload_1
    //   2296: astore 15
    //   2298: iload 7
    //   2300: istore 8
    //   2302: aload 17
    //   2304: getstatic 4318	com/tencent/mobileqq/app/QQManagerFactory:GROUP_VIDEO_PLUGIN_MANAGER	I
    //   2307: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2310: checkcast 4320	com/tencent/mobileqq/intervideo/groupvideo/IGroupVideoManager
    //   2313: aload 19
    //   2315: invokeinterface 4321 2 0
    //   2320: aload_1
    //   2321: astore 16
    //   2323: iload 13
    //   2325: istore 14
    //   2327: iload 7
    //   2329: istore 9
    //   2331: goto -2209 -> 122
    //   2334: aload_1
    //   2335: astore 15
    //   2337: iload 7
    //   2339: istore 8
    //   2341: aload_0
    //   2342: aload 17
    //   2344: aload 19
    //   2346: invokespecial 4323	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aJ	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2349: aload_1
    //   2350: astore 16
    //   2352: iload 13
    //   2354: istore 14
    //   2356: iload 7
    //   2358: istore 9
    //   2360: goto -2238 -> 122
    //   2363: aload_1
    //   2364: astore 15
    //   2366: iload 7
    //   2368: istore 8
    //   2370: aload_0
    //   2371: aload 17
    //   2373: aload 19
    //   2375: invokespecial 4325	com/tencent/mobileqq/config/splashlogo/ConfigServlet:Q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2378: aload_1
    //   2379: astore 16
    //   2381: iload 13
    //   2383: istore 14
    //   2385: iload 7
    //   2387: istore 9
    //   2389: goto -2267 -> 122
    //   2392: aload_1
    //   2393: astore 15
    //   2395: iload 7
    //   2397: istore 8
    //   2399: aload 17
    //   2401: getstatic 4328	com/tencent/mobileqq/app/QQManagerFactory:NOW_DYNAMIC_MANAGER	I
    //   2404: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2407: checkcast 4330	com/tencent/mobileqq/intervideo/now/dynamic/IDynamicNowManager
    //   2410: aload 19
    //   2412: invokeinterface 4331 2 0
    //   2417: aload_1
    //   2418: astore 16
    //   2420: iload 13
    //   2422: istore 14
    //   2424: iload 7
    //   2426: istore 9
    //   2428: goto -2306 -> 122
    //   2431: aload_1
    //   2432: astore 15
    //   2434: iload 7
    //   2436: istore 8
    //   2438: aload_0
    //   2439: aload 17
    //   2441: aload 19
    //   2443: invokespecial 4333	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aI	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2446: aload_1
    //   2447: astore 16
    //   2449: iload 13
    //   2451: istore 14
    //   2453: iload 7
    //   2455: istore 9
    //   2457: goto -2335 -> 122
    //   2460: aload_1
    //   2461: astore 15
    //   2463: iload 7
    //   2465: istore 8
    //   2467: aload 17
    //   2469: aload 19
    //   2471: invokestatic 4335	com/tencent/mobileqq/config/splashlogo/ConfigServlet:N	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2474: aload_1
    //   2475: astore 16
    //   2477: iload 13
    //   2479: istore 14
    //   2481: iload 7
    //   2483: istore 9
    //   2485: goto -2363 -> 122
    //   2488: aload_1
    //   2489: astore 15
    //   2491: iload 7
    //   2493: istore 8
    //   2495: aload_0
    //   2496: aload 17
    //   2498: aload 19
    //   2500: invokevirtual 4337	com/tencent/mobileqq/config/splashlogo/ConfigServlet:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2503: aload_1
    //   2504: astore 16
    //   2506: iload 13
    //   2508: istore 14
    //   2510: iload 7
    //   2512: istore 9
    //   2514: goto -2392 -> 122
    //   2517: aload_1
    //   2518: astore 15
    //   2520: iload 7
    //   2522: istore 8
    //   2524: aload 17
    //   2526: getstatic 1337	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   2529: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2532: checkcast 1339	com/tencent/mobileqq/app/TroopManager
    //   2535: getfield 1342	com/tencent/mobileqq/app/TroopManager:c	Lcom/tencent/biz/troopconfig/TroopConfigForAllUser;
    //   2538: aload 17
    //   2540: aload 19
    //   2542: invokevirtual 4340	com/tencent/biz/troopconfig/TroopConfigForAllUser:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2545: aload_1
    //   2546: astore 16
    //   2548: iload 13
    //   2550: istore 14
    //   2552: iload 7
    //   2554: istore 9
    //   2556: goto -2434 -> 122
    //   2559: aload_1
    //   2560: astore 15
    //   2562: iload 7
    //   2564: istore 8
    //   2566: aload_0
    //   2567: aload 17
    //   2569: aload 19
    //   2571: invokevirtual 4342	com/tencent/mobileqq/config/splashlogo/ConfigServlet:L	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2574: aload_1
    //   2575: astore 16
    //   2577: iload 13
    //   2579: istore 14
    //   2581: iload 7
    //   2583: istore 9
    //   2585: goto -2463 -> 122
    //   2588: aload_1
    //   2589: astore 15
    //   2591: iload 7
    //   2593: istore 8
    //   2595: aload 17
    //   2597: iload 10
    //   2599: aload 19
    //   2601: invokestatic 4347	com/tencent/mobileqq/wifi/FreeWifiHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2604: aload_1
    //   2605: astore 16
    //   2607: iload 13
    //   2609: istore 14
    //   2611: iload 7
    //   2613: istore 9
    //   2615: goto -2493 -> 122
    //   2618: aload_1
    //   2619: astore 15
    //   2621: iload 7
    //   2623: istore 8
    //   2625: aload 17
    //   2627: invokestatic 4352	com/tencent/mobileqq/flashchat/RichTextChatManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/flashchat/RichTextChatManager;
    //   2630: aload 17
    //   2632: iload 10
    //   2634: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2637: aload 19
    //   2639: invokevirtual 4355	com/tencent/mobileqq/flashchat/RichTextChatManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/Integer;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2642: aload_1
    //   2643: astore 16
    //   2645: iload 13
    //   2647: istore 14
    //   2649: iload 7
    //   2651: istore 9
    //   2653: goto -2531 -> 122
    //   2656: aload_1
    //   2657: astore 15
    //   2659: iload 7
    //   2661: istore 8
    //   2663: aload 17
    //   2665: aload 19
    //   2667: invokestatic 4357	com/tencent/mobileqq/config/splashlogo/ConfigServlet:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2670: aload_1
    //   2671: astore 16
    //   2673: iload 13
    //   2675: istore 14
    //   2677: iload 7
    //   2679: istore 9
    //   2681: goto -2559 -> 122
    //   2684: aload_1
    //   2685: astore 15
    //   2687: iload 7
    //   2689: istore 8
    //   2691: aload_0
    //   2692: aload 17
    //   2694: aload 19
    //   2696: invokespecial 4359	com/tencent/mobileqq/config/splashlogo/ConfigServlet:R	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2699: aload_1
    //   2700: astore 16
    //   2702: iload 13
    //   2704: istore 14
    //   2706: iload 7
    //   2708: istore 9
    //   2710: goto -2588 -> 122
    //   2713: aload_1
    //   2714: astore 15
    //   2716: iload 7
    //   2718: istore 8
    //   2720: aload_0
    //   2721: aload 17
    //   2723: aload 19
    //   2725: invokespecial 4361	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aG	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2728: aload_1
    //   2729: astore 16
    //   2731: iload 13
    //   2733: istore 14
    //   2735: iload 7
    //   2737: istore 9
    //   2739: goto -2617 -> 122
    //   2742: aload_1
    //   2743: astore 15
    //   2745: iload 7
    //   2747: istore 8
    //   2749: aload 17
    //   2751: aload 19
    //   2753: invokestatic 4363	com/tencent/mobileqq/config/splashlogo/ConfigServlet:v	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2756: aload_1
    //   2757: astore 16
    //   2759: iload 13
    //   2761: istore 14
    //   2763: iload 7
    //   2765: istore 9
    //   2767: goto -2645 -> 122
    //   2770: aload_1
    //   2771: astore 15
    //   2773: iload 7
    //   2775: istore 8
    //   2777: aload 17
    //   2779: getstatic 1375	com/tencent/mobileqq/app/QQManagerFactory:QQSTORY_MANAGER	I
    //   2782: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2785: checkcast 1377	com/tencent/biz/qqstory/base/QQStoryManager
    //   2788: getfield 1381	com/tencent/biz/qqstory/base/QQStoryManager:x	Lcom/tencent/biz/qqstory/config/TextFilterConfig;
    //   2791: aload 17
    //   2793: aload 19
    //   2795: invokevirtual 4364	com/tencent/biz/qqstory/config/TextFilterConfig:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2798: aload_1
    //   2799: astore 16
    //   2801: iload 13
    //   2803: istore 14
    //   2805: iload 7
    //   2807: istore 9
    //   2809: goto -2687 -> 122
    //   2812: aload_1
    //   2813: astore 15
    //   2815: iload 7
    //   2817: istore 8
    //   2819: aload 17
    //   2821: invokestatic 4369	com/tencent/biz/qqstory/base/QQStoryFeedManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/biz/qqstory/base/QQStoryFeedManager;
    //   2824: aload 19
    //   2826: invokevirtual 4370	com/tencent/biz/qqstory/base/QQStoryFeedManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2829: aload_1
    //   2830: astore 16
    //   2832: iload 13
    //   2834: istore 14
    //   2836: iload 7
    //   2838: istore 9
    //   2840: goto -2718 -> 122
    //   2843: aload_1
    //   2844: astore 15
    //   2846: iload 7
    //   2848: istore 8
    //   2850: aload 17
    //   2852: getstatic 4373	com/tencent/mobileqq/app/QQManagerFactory:STORY_HALO_MANAGER	I
    //   2855: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2858: checkcast 4375	com/tencent/biz/qqstory/base/StoryHaloManager
    //   2861: aload 19
    //   2863: invokevirtual 4376	com/tencent/biz/qqstory/base/StoryHaloManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2866: aload_1
    //   2867: astore 16
    //   2869: iload 13
    //   2871: istore 14
    //   2873: iload 7
    //   2875: istore 9
    //   2877: goto -2755 -> 122
    //   2880: aload_1
    //   2881: astore 15
    //   2883: iload 7
    //   2885: istore 8
    //   2887: aload 17
    //   2889: aload 19
    //   2891: iload 10
    //   2893: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   2896: invokestatic 4381	com/tencent/mobileqq/statistics/QZoneReport:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;ILjava/lang/String;)V
    //   2899: aload_1
    //   2900: astore 16
    //   2902: iload 13
    //   2904: istore 14
    //   2906: iload 7
    //   2908: istore 9
    //   2910: goto -2788 -> 122
    //   2913: aload_1
    //   2914: astore 15
    //   2916: iload 7
    //   2918: istore 8
    //   2920: aload 17
    //   2922: iload 10
    //   2924: aload 19
    //   2926: invokestatic 4386	com/tencent/mobileqq/data/nativemonitor/NativeMonitorConfigHelper:handleNativeMonitorConfig	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2929: aload_1
    //   2930: astore 16
    //   2932: iload 13
    //   2934: istore 14
    //   2936: iload 7
    //   2938: istore 9
    //   2940: goto -2818 -> 122
    //   2943: aload_1
    //   2944: astore 15
    //   2946: iload 7
    //   2948: istore 8
    //   2950: aload_0
    //   2951: aload 17
    //   2953: aload 19
    //   2955: invokevirtual 4388	com/tencent/mobileqq/config/splashlogo/ConfigServlet:D	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2958: aload_1
    //   2959: astore 16
    //   2961: iload 13
    //   2963: istore 14
    //   2965: iload 7
    //   2967: istore 9
    //   2969: goto -2847 -> 122
    //   2972: aload_1
    //   2973: astore 15
    //   2975: iload 7
    //   2977: istore 8
    //   2979: aload_0
    //   2980: aload 17
    //   2982: aload 19
    //   2984: invokevirtual 4390	com/tencent/mobileqq/config/splashlogo/ConfigServlet:M	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   2987: aload_1
    //   2988: astore 16
    //   2990: iload 13
    //   2992: istore 14
    //   2994: iload 7
    //   2996: istore 9
    //   2998: goto -2876 -> 122
    //   3001: aload_1
    //   3002: astore 15
    //   3004: iload 7
    //   3006: istore 8
    //   3008: aload_0
    //   3009: aload 17
    //   3011: aload 5
    //   3013: aload 19
    //   3015: invokespecial 4392	com/tencent/mobileqq/config/splashlogo/ConfigServlet:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3018: aload_1
    //   3019: astore 16
    //   3021: iload 13
    //   3023: istore 14
    //   3025: iload 7
    //   3027: istore 9
    //   3029: goto -2907 -> 122
    //   3032: aload_1
    //   3033: astore 15
    //   3035: iload 7
    //   3037: istore 8
    //   3039: aload_0
    //   3040: aload 17
    //   3042: aload 19
    //   3044: invokevirtual 4394	com/tencent/mobileqq/config/splashlogo/ConfigServlet:K	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3047: aload_1
    //   3048: astore 16
    //   3050: iload 13
    //   3052: istore 14
    //   3054: iload 7
    //   3056: istore 9
    //   3058: goto -2936 -> 122
    //   3061: aload_1
    //   3062: astore 15
    //   3064: iload 7
    //   3066: istore 8
    //   3068: aload_0
    //   3069: aload 17
    //   3071: aload 19
    //   3073: invokevirtual 4396	com/tencent/mobileqq/config/splashlogo/ConfigServlet:J	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3076: aload_1
    //   3077: astore 16
    //   3079: iload 13
    //   3081: istore 14
    //   3083: iload 7
    //   3085: istore 9
    //   3087: goto -2965 -> 122
    //   3090: aload_1
    //   3091: astore 15
    //   3093: iload 7
    //   3095: istore 8
    //   3097: aload_0
    //   3098: aload 17
    //   3100: aload 19
    //   3102: invokevirtual 4398	com/tencent/mobileqq/config/splashlogo/ConfigServlet:I	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3105: aload_1
    //   3106: astore 16
    //   3108: iload 13
    //   3110: istore 14
    //   3112: iload 7
    //   3114: istore 9
    //   3116: goto -2994 -> 122
    //   3119: aload_1
    //   3120: astore 15
    //   3122: iload 7
    //   3124: istore 8
    //   3126: aload 17
    //   3128: aload 19
    //   3130: invokestatic 4401	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   3133: pop
    //   3134: aload_1
    //   3135: astore 16
    //   3137: iload 13
    //   3139: istore 14
    //   3141: iload 7
    //   3143: istore 9
    //   3145: goto -3023 -> 122
    //   3148: aload_1
    //   3149: astore 15
    //   3151: iload 7
    //   3153: istore 8
    //   3155: aload 17
    //   3157: aload 19
    //   3159: invokestatic 4404	com/tencent/mobileqq/troop/logic/HomeworkTroopController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3162: aload_1
    //   3163: astore 16
    //   3165: iload 13
    //   3167: istore 14
    //   3169: iload 7
    //   3171: istore 9
    //   3173: goto -3051 -> 122
    //   3176: aload_1
    //   3177: astore 15
    //   3179: iload 7
    //   3181: istore 8
    //   3183: aload 17
    //   3185: aload 19
    //   3187: invokestatic 4405	com/tencent/biz/troopgift/GiftConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3190: aload_1
    //   3191: astore 16
    //   3193: iload 13
    //   3195: istore 14
    //   3197: iload 7
    //   3199: istore 9
    //   3201: goto -3079 -> 122
    //   3204: aload_1
    //   3205: astore 15
    //   3207: iload 7
    //   3209: istore 8
    //   3211: aload_0
    //   3212: aload 17
    //   3214: aload 19
    //   3216: invokevirtual 4407	com/tencent/mobileqq/config/splashlogo/ConfigServlet:q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3219: aload_1
    //   3220: astore 16
    //   3222: iload 13
    //   3224: istore 14
    //   3226: iload 7
    //   3228: istore 9
    //   3230: goto -3108 -> 122
    //   3233: aload_1
    //   3234: astore 15
    //   3236: iload 7
    //   3238: istore 8
    //   3240: aload_0
    //   3241: aload 17
    //   3243: aload 19
    //   3245: invokespecial 4409	com/tencent/mobileqq/config/splashlogo/ConfigServlet:af	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3248: aload_1
    //   3249: astore 16
    //   3251: iload 13
    //   3253: istore 14
    //   3255: iload 7
    //   3257: istore 9
    //   3259: goto -3137 -> 122
    //   3262: aload_1
    //   3263: astore 15
    //   3265: iload 7
    //   3267: istore 8
    //   3269: aload_0
    //   3270: aload 17
    //   3272: aload 19
    //   3274: invokespecial 4411	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ae	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3277: aload_1
    //   3278: astore 16
    //   3280: iload 13
    //   3282: istore 14
    //   3284: iload 7
    //   3286: istore 9
    //   3288: goto -3166 -> 122
    //   3291: aload_1
    //   3292: astore 15
    //   3294: iload 7
    //   3296: istore 8
    //   3298: aload_0
    //   3299: aload 17
    //   3301: aload 19
    //   3303: invokevirtual 4413	com/tencent/mobileqq/config/splashlogo/ConfigServlet:G	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3306: aload_1
    //   3307: astore 16
    //   3309: iload 13
    //   3311: istore 14
    //   3313: iload 7
    //   3315: istore 9
    //   3317: goto -3195 -> 122
    //   3320: aload_1
    //   3321: astore 15
    //   3323: iload 7
    //   3325: istore 8
    //   3327: aload_0
    //   3328: aload 17
    //   3330: aload 19
    //   3332: invokespecial 4415	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aE	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3335: aload_1
    //   3336: astore 16
    //   3338: iload 13
    //   3340: istore 14
    //   3342: iload 7
    //   3344: istore 9
    //   3346: goto -3224 -> 122
    //   3349: aload_1
    //   3350: astore 15
    //   3352: iload 7
    //   3354: istore 8
    //   3356: aload_0
    //   3357: aload 17
    //   3359: aload 19
    //   3361: invokevirtual 4417	com/tencent/mobileqq/config/splashlogo/ConfigServlet:F	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3364: aload_1
    //   3365: astore 16
    //   3367: iload 13
    //   3369: istore 14
    //   3371: iload 7
    //   3373: istore 9
    //   3375: goto -3253 -> 122
    //   3378: aload_1
    //   3379: astore 15
    //   3381: iload 7
    //   3383: istore 8
    //   3385: aload_0
    //   3386: aload 17
    //   3388: aload 19
    //   3390: invokespecial 4419	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aD	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3393: aload_1
    //   3394: astore 16
    //   3396: iload 13
    //   3398: istore 14
    //   3400: iload 7
    //   3402: istore 9
    //   3404: goto -3282 -> 122
    //   3407: aload_1
    //   3408: astore 15
    //   3410: iload 7
    //   3412: istore 8
    //   3414: aload_0
    //   3415: aload 17
    //   3417: aload 19
    //   3419: invokespecial 4421	com/tencent/mobileqq/config/splashlogo/ConfigServlet:av	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3422: aload_1
    //   3423: astore 16
    //   3425: iload 13
    //   3427: istore 14
    //   3429: iload 7
    //   3431: istore 9
    //   3433: goto -3311 -> 122
    //   3436: aload_1
    //   3437: astore 15
    //   3439: iload 7
    //   3441: istore 8
    //   3443: aload_0
    //   3444: aload 17
    //   3446: aload 19
    //   3448: invokevirtual 4423	com/tencent/mobileqq/config/splashlogo/ConfigServlet:E	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3451: aload_1
    //   3452: astore 16
    //   3454: iload 13
    //   3456: istore 14
    //   3458: iload 7
    //   3460: istore 9
    //   3462: goto -3340 -> 122
    //   3465: aload_1
    //   3466: astore 15
    //   3468: iload 7
    //   3470: istore 8
    //   3472: aload_0
    //   3473: aload 17
    //   3475: aload 19
    //   3477: invokevirtual 4425	com/tencent/mobileqq/config/splashlogo/ConfigServlet:C	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3480: aload_1
    //   3481: astore 16
    //   3483: iload 13
    //   3485: istore 14
    //   3487: iload 7
    //   3489: istore 9
    //   3491: goto -3369 -> 122
    //   3494: aload_1
    //   3495: astore 15
    //   3497: iload 7
    //   3499: istore 8
    //   3501: aload_0
    //   3502: aload 17
    //   3504: aload 19
    //   3506: invokevirtual 4427	com/tencent/mobileqq/config/splashlogo/ConfigServlet:p	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3509: aload_1
    //   3510: astore 16
    //   3512: iload 13
    //   3514: istore 14
    //   3516: iload 7
    //   3518: istore 9
    //   3520: goto -3398 -> 122
    //   3523: aload_1
    //   3524: astore 15
    //   3526: iload 7
    //   3528: istore 8
    //   3530: aload_0
    //   3531: aload 17
    //   3533: aload 19
    //   3535: invokevirtual 4429	com/tencent/mobileqq/config/splashlogo/ConfigServlet:B	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3538: aload_1
    //   3539: astore 16
    //   3541: iload 13
    //   3543: istore 14
    //   3545: iload 7
    //   3547: istore 9
    //   3549: goto -3427 -> 122
    //   3552: aload_1
    //   3553: astore 15
    //   3555: iload 7
    //   3557: istore 8
    //   3559: aload_0
    //   3560: aload 17
    //   3562: aload 19
    //   3564: invokevirtual 4431	com/tencent/mobileqq/config/splashlogo/ConfigServlet:H	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3567: aload_1
    //   3568: astore 16
    //   3570: iload 13
    //   3572: istore 14
    //   3574: iload 7
    //   3576: istore 9
    //   3578: goto -3456 -> 122
    //   3581: aload_1
    //   3582: astore 15
    //   3584: iload 7
    //   3586: istore 8
    //   3588: aload_0
    //   3589: aload 17
    //   3591: aload 19
    //   3593: invokevirtual 4433	com/tencent/mobileqq/config/splashlogo/ConfigServlet:z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3596: aload_1
    //   3597: astore 16
    //   3599: iload 13
    //   3601: istore 14
    //   3603: iload 7
    //   3605: istore 9
    //   3607: goto -3485 -> 122
    //   3610: aload_1
    //   3611: astore 15
    //   3613: iload 7
    //   3615: istore 8
    //   3617: aload_0
    //   3618: aload 17
    //   3620: aload 19
    //   3622: invokespecial 4435	com/tencent/mobileqq/config/splashlogo/ConfigServlet:T	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3625: aload_1
    //   3626: astore 16
    //   3628: iload 13
    //   3630: istore 14
    //   3632: iload 7
    //   3634: istore 9
    //   3636: goto -3514 -> 122
    //   3639: aload_1
    //   3640: astore 15
    //   3642: iload 7
    //   3644: istore 8
    //   3646: aload_0
    //   3647: aload 17
    //   3649: aload 19
    //   3651: invokevirtual 4437	com/tencent/mobileqq/config/splashlogo/ConfigServlet:A	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3654: aload_1
    //   3655: astore 16
    //   3657: iload 13
    //   3659: istore 14
    //   3661: iload 7
    //   3663: istore 9
    //   3665: goto -3543 -> 122
    //   3668: aload_1
    //   3669: astore 15
    //   3671: iload 7
    //   3673: istore 8
    //   3675: aload 19
    //   3677: invokestatic 4440	com/tencent/mobileqq/search/util/SearchConfigUtils:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3680: aload_1
    //   3681: astore 16
    //   3683: iload 13
    //   3685: istore 14
    //   3687: iload 7
    //   3689: istore 9
    //   3691: goto -3569 -> 122
    //   3694: aload_1
    //   3695: astore 15
    //   3697: iload 7
    //   3699: istore 8
    //   3701: aload_0
    //   3702: aload 17
    //   3704: aload 19
    //   3706: invokespecial 4442	com/tencent/mobileqq/config/splashlogo/ConfigServlet:au	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3709: aload_1
    //   3710: astore 16
    //   3712: iload 13
    //   3714: istore 14
    //   3716: iload 7
    //   3718: istore 9
    //   3720: goto -3598 -> 122
    //   3723: aload_1
    //   3724: astore 15
    //   3726: iload 7
    //   3728: istore 8
    //   3730: aload_0
    //   3731: aload 17
    //   3733: aload 19
    //   3735: invokespecial 4444	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ad	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3738: aload_1
    //   3739: astore 16
    //   3741: iload 13
    //   3743: istore 14
    //   3745: iload 7
    //   3747: istore 9
    //   3749: goto -3627 -> 122
    //   3752: aload_1
    //   3753: astore 15
    //   3755: iload 7
    //   3757: istore 8
    //   3759: aload_0
    //   3760: aload 17
    //   3762: aload 5
    //   3764: aload 19
    //   3766: invokespecial 4446	com/tencent/mobileqq/config/splashlogo/ConfigServlet:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3769: aload_1
    //   3770: astore 16
    //   3772: iload 13
    //   3774: istore 14
    //   3776: iload 7
    //   3778: istore 9
    //   3780: goto -3658 -> 122
    //   3783: aload_1
    //   3784: astore 15
    //   3786: iload 7
    //   3788: istore 8
    //   3790: aload 19
    //   3792: ldc_w 1530
    //   3795: invokestatic 498	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3798: checkcast 1530	com/tencent/aelight/camera/qqstory/api/ICaptureVideoFilterManager
    //   3801: aload 17
    //   3803: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3806: invokeinterface 1533 2 0
    //   3811: sipush 225
    //   3814: invokestatic 2022	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   3817: astore 5
    //   3819: aload_1
    //   3820: astore 16
    //   3822: iload 13
    //   3824: istore 14
    //   3826: iload 7
    //   3828: istore 9
    //   3830: aload 5
    //   3832: ifnull -3710 -> 122
    //   3835: aload_1
    //   3836: astore 15
    //   3838: iload 7
    //   3840: istore 8
    //   3842: ldc_w 1530
    //   3845: invokestatic 498	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3848: checkcast 1530	com/tencent/aelight/camera/qqstory/api/ICaptureVideoFilterManager
    //   3851: aload 17
    //   3853: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3856: aload 5
    //   3858: aload 19
    //   3860: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3863: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3866: invokeinterface 4449 4 0
    //   3871: aload_1
    //   3872: astore 16
    //   3874: iload 13
    //   3876: istore 14
    //   3878: iload 7
    //   3880: istore 9
    //   3882: goto -3760 -> 122
    //   3885: aload_1
    //   3886: astore 15
    //   3888: iload 7
    //   3890: istore 8
    //   3892: aload 17
    //   3894: invokestatic 1539	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   3897: aload 17
    //   3899: iload 10
    //   3901: aload 5
    //   3903: aload 19
    //   3905: invokevirtual 4453	com/tencent/mobileqq/utils/BusinessCommonConfig:decodeConfig	(Lcom/tencent/mobileqq/app/QQAppInterface;ILandroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)Ljava/lang/Boolean;
    //   3908: pop
    //   3909: aload_1
    //   3910: astore 16
    //   3912: iload 13
    //   3914: istore 14
    //   3916: iload 7
    //   3918: istore 9
    //   3920: goto -3798 -> 122
    //   3923: aload_1
    //   3924: astore 15
    //   3926: iload 7
    //   3928: istore 8
    //   3930: aload 17
    //   3932: getstatic 4456	com/tencent/mobileqq/app/QQManagerFactory:PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER	I
    //   3935: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3938: checkcast 4458	com/tencent/biz/pubaccount/Advertisement/manager/AdvertisementVideoPreloadManager
    //   3941: astore 5
    //   3943: aload_1
    //   3944: astore 16
    //   3946: iload 13
    //   3948: istore 14
    //   3950: iload 7
    //   3952: istore 9
    //   3954: aload 5
    //   3956: ifnull -3834 -> 122
    //   3959: aload_1
    //   3960: astore 15
    //   3962: iload 7
    //   3964: istore 8
    //   3966: aload 5
    //   3968: aload 17
    //   3970: aload 19
    //   3972: invokevirtual 4459	com/tencent/biz/pubaccount/Advertisement/manager/AdvertisementVideoPreloadManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   3975: aload_1
    //   3976: astore 16
    //   3978: iload 13
    //   3980: istore 14
    //   3982: iload 7
    //   3984: istore 9
    //   3986: goto -3864 -> 122
    //   3989: aload_1
    //   3990: astore 15
    //   3992: iload 7
    //   3994: istore 8
    //   3996: aload_0
    //   3997: aload 17
    //   3999: aload 19
    //   4001: aload 5
    //   4003: ldc_w 4293
    //   4006: invokevirtual 1224	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   4009: invokespecial 4461	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)I
    //   4012: invokestatic 4462	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager:b	(I)V
    //   4015: aload_1
    //   4016: astore 16
    //   4018: iload 13
    //   4020: istore 14
    //   4022: iload 7
    //   4024: istore 9
    //   4026: goto -3904 -> 122
    //   4029: aload_1
    //   4030: astore 15
    //   4032: iload 7
    //   4034: istore 8
    //   4036: aload 17
    //   4038: aload 19
    //   4040: invokestatic 4464	com/tencent/mobileqq/config/splashlogo/ConfigServlet:y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4043: aload_1
    //   4044: astore 16
    //   4046: iload 13
    //   4048: istore 14
    //   4050: iload 7
    //   4052: istore 9
    //   4054: goto -3932 -> 122
    //   4057: aload_1
    //   4058: astore 15
    //   4060: iload 7
    //   4062: istore 8
    //   4064: aload 17
    //   4066: aload 19
    //   4068: invokestatic 4465	com/tencent/mobileqq/search/util/SearchConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4071: aload_1
    //   4072: astore 16
    //   4074: iload 13
    //   4076: istore 14
    //   4078: iload 7
    //   4080: istore 9
    //   4082: goto -3960 -> 122
    //   4085: aload_1
    //   4086: astore 15
    //   4088: iload 7
    //   4090: istore 8
    //   4092: aload_0
    //   4093: aload 17
    //   4095: aload 19
    //   4097: invokespecial 4467	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aH	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4100: aload_1
    //   4101: astore 16
    //   4103: iload 13
    //   4105: istore 14
    //   4107: iload 7
    //   4109: istore 9
    //   4111: goto -3989 -> 122
    //   4114: aload_1
    //   4115: astore 15
    //   4117: iload 7
    //   4119: istore 8
    //   4121: aload_0
    //   4122: aload 17
    //   4124: aload 5
    //   4126: aload 19
    //   4128: invokevirtual 4469	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4131: aload_1
    //   4132: astore 16
    //   4134: iload 13
    //   4136: istore 14
    //   4138: iload 7
    //   4140: istore 9
    //   4142: goto -4020 -> 122
    //   4145: aload_1
    //   4146: astore 15
    //   4148: iload 7
    //   4150: istore 8
    //   4152: aload_0
    //   4153: aload 17
    //   4155: aload 19
    //   4157: invokespecial 4471	com/tencent/mobileqq/config/splashlogo/ConfigServlet:S	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4160: aload_1
    //   4161: astore 16
    //   4163: iload 13
    //   4165: istore 14
    //   4167: iload 7
    //   4169: istore 9
    //   4171: goto -4049 -> 122
    //   4174: aload_1
    //   4175: astore 15
    //   4177: iload 7
    //   4179: istore 8
    //   4181: aload_0
    //   4182: aload 17
    //   4184: aload 19
    //   4186: invokevirtual 4473	com/tencent/mobileqq/config/splashlogo/ConfigServlet:x	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4189: aload_1
    //   4190: astore 16
    //   4192: iload 13
    //   4194: istore 14
    //   4196: iload 7
    //   4198: istore 9
    //   4200: goto -4078 -> 122
    //   4203: aload_1
    //   4204: astore 15
    //   4206: iload 7
    //   4208: istore 8
    //   4210: aload_0
    //   4211: aload 17
    //   4213: aload 19
    //   4215: invokespecial 4475	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aa	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4218: aload_1
    //   4219: astore 16
    //   4221: iload 13
    //   4223: istore 14
    //   4225: iload 7
    //   4227: istore 9
    //   4229: goto -4107 -> 122
    //   4232: aload_1
    //   4233: astore 15
    //   4235: iload 7
    //   4237: istore 8
    //   4239: aload_0
    //   4240: aload 17
    //   4242: aload 19
    //   4244: invokespecial 4477	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ac	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4247: aload_1
    //   4248: astore 16
    //   4250: iload 13
    //   4252: istore 14
    //   4254: iload 7
    //   4256: istore 9
    //   4258: goto -4136 -> 122
    //   4261: aload_1
    //   4262: astore 15
    //   4264: iload 7
    //   4266: istore 8
    //   4268: aload_0
    //   4269: aload 17
    //   4271: aload 19
    //   4273: invokevirtual 4479	com/tencent/mobileqq/config/splashlogo/ConfigServlet:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4276: aload_1
    //   4277: astore 16
    //   4279: iload 13
    //   4281: istore 14
    //   4283: iload 7
    //   4285: istore 9
    //   4287: goto -4165 -> 122
    //   4290: iload 7
    //   4292: istore 10
    //   4294: aload_1
    //   4295: astore 16
    //   4297: iload 13
    //   4299: istore 14
    //   4301: iload 10
    //   4303: istore 9
    //   4305: aload_1
    //   4306: astore 15
    //   4308: iload 10
    //   4310: istore 8
    //   4312: aload 19
    //   4314: getfield 389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4317: ifnull -4195 -> 122
    //   4320: aload_1
    //   4321: astore 16
    //   4323: iload 13
    //   4325: istore 14
    //   4327: iload 10
    //   4329: istore 9
    //   4331: aload_1
    //   4332: astore 15
    //   4334: iload 10
    //   4336: istore 8
    //   4338: aload 19
    //   4340: getfield 389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4343: invokevirtual 392	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   4346: ifle -4224 -> 122
    //   4349: aload_1
    //   4350: astore 15
    //   4352: iload 10
    //   4354: istore 8
    //   4356: aload 19
    //   4358: getfield 389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4361: astore 5
    //   4363: aload 5
    //   4365: iconst_0
    //   4366: invokevirtual 395	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4369: astore 5
    //   4371: aload_1
    //   4372: astore 15
    //   4374: iload 10
    //   4376: istore 8
    //   4378: aload 5
    //   4380: checkcast 397	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   4383: astore 5
    //   4385: aload 5
    //   4387: ifnull +506 -> 4893
    //   4390: aload_1
    //   4391: astore 15
    //   4393: iload 10
    //   4395: istore 8
    //   4397: aload 5
    //   4399: getfield 401	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4402: invokevirtual 404	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4405: iconst_1
    //   4406: if_icmpne +146 -> 4552
    //   4409: aload_1
    //   4410: astore 15
    //   4412: iload 10
    //   4414: istore 8
    //   4416: aload 5
    //   4418: getfield 408	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4421: invokevirtual 413	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4424: invokevirtual 419	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4427: invokestatic 424	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   4430: astore 16
    //   4432: aload 16
    //   4434: ifnull +9322 -> 13756
    //   4437: aload_1
    //   4438: astore 15
    //   4440: iload 10
    //   4442: istore 8
    //   4444: new 126	java/lang/String
    //   4447: dup
    //   4448: aload 16
    //   4450: ldc_w 426
    //   4453: invokespecial 429	java/lang/String:<init>	([BLjava/lang/String;)V
    //   4456: astore 5
    //   4458: goto +114 -> 4572
    //   4461: astore 5
    //   4463: aload_1
    //   4464: astore 15
    //   4466: iload 10
    //   4468: istore 8
    //   4470: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4473: ifeq +15 -> 4488
    //   4476: aload_1
    //   4477: astore 15
    //   4479: iload 10
    //   4481: istore 8
    //   4483: aload 5
    //   4485: invokevirtual 2375	java/lang/OutOfMemoryError:printStackTrace	()V
    //   4488: aload_1
    //   4489: astore 15
    //   4491: iload 10
    //   4493: istore 8
    //   4495: invokestatic 440	java/lang/System:gc	()V
    //   4498: aload_1
    //   4499: astore 15
    //   4501: iload 10
    //   4503: istore 8
    //   4505: new 126	java/lang/String
    //   4508: dup
    //   4509: aload 16
    //   4511: ldc_w 426
    //   4514: invokespecial 429	java/lang/String:<init>	([BLjava/lang/String;)V
    //   4517: astore 5
    //   4519: goto +53 -> 4572
    //   4522: astore 5
    //   4524: aload_1
    //   4525: astore 15
    //   4527: iload 10
    //   4529: istore 8
    //   4531: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4534: ifeq +9222 -> 13756
    //   4537: aload_1
    //   4538: astore 15
    //   4540: iload 10
    //   4542: istore 8
    //   4544: aload 5
    //   4546: invokevirtual 2376	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   4549: goto +9207 -> 13756
    //   4552: aload_1
    //   4553: astore 15
    //   4555: iload 10
    //   4557: istore 8
    //   4559: aload 5
    //   4561: getfield 408	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4564: invokevirtual 413	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4567: invokevirtual 443	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4570: astore 5
    //   4572: aload_1
    //   4573: astore 16
    //   4575: iload 13
    //   4577: istore 14
    //   4579: iload 10
    //   4581: istore 9
    //   4583: aload 5
    //   4585: ifnull -4463 -> 122
    //   4588: aload_1
    //   4589: astore 15
    //   4591: iload 10
    //   4593: istore 8
    //   4595: aload 19
    //   4597: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4600: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4603: istore 7
    //   4605: aload_1
    //   4606: astore 15
    //   4608: iload 10
    //   4610: istore 8
    //   4612: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4615: ifeq +100 -> 4715
    //   4618: aload_1
    //   4619: astore 15
    //   4621: iload 10
    //   4623: istore 8
    //   4625: new 78	java/lang/StringBuilder
    //   4628: dup
    //   4629: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   4632: astore 16
    //   4634: aload_1
    //   4635: astore 15
    //   4637: iload 10
    //   4639: istore 8
    //   4641: aload 16
    //   4643: ldc_w 4481
    //   4646: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4649: pop
    //   4650: aload_1
    //   4651: astore 15
    //   4653: iload 10
    //   4655: istore 8
    //   4657: aload 16
    //   4659: iload 7
    //   4661: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4664: pop
    //   4665: aload_1
    //   4666: astore 15
    //   4668: iload 10
    //   4670: istore 8
    //   4672: aload 16
    //   4674: ldc_w 4483
    //   4677: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4680: pop
    //   4681: aload_1
    //   4682: astore 15
    //   4684: iload 10
    //   4686: istore 8
    //   4688: aload 16
    //   4690: aload 5
    //   4692: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4695: pop
    //   4696: aload_1
    //   4697: astore 15
    //   4699: iload 10
    //   4701: istore 8
    //   4703: ldc_w 1592
    //   4706: iconst_2
    //   4707: aload 16
    //   4709: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4712: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4715: aload_1
    //   4716: astore 15
    //   4718: iload 10
    //   4720: istore 8
    //   4722: aload 5
    //   4724: invokestatic 4488	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;
    //   4727: astore_1
    //   4728: aload_1
    //   4729: astore 15
    //   4731: iload 10
    //   4733: istore 8
    //   4735: aload 17
    //   4737: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   4740: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   4743: iload 7
    //   4745: invokestatic 4490	com/tencent/mobileqq/utils/SharedPreUtils:n	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4748: aload_1
    //   4749: astore 15
    //   4751: iload 10
    //   4753: istore 8
    //   4755: aload 17
    //   4757: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4760: ldc_w 4492
    //   4763: invokestatic 4497	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   4766: ifne +72 -> 4838
    //   4769: aload_1
    //   4770: astore 15
    //   4772: iload 10
    //   4774: istore 8
    //   4776: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4779: ifeq +20 -> 4799
    //   4782: aload_1
    //   4783: astore 15
    //   4785: iload 10
    //   4787: istore 8
    //   4789: ldc_w 1592
    //   4792: iconst_2
    //   4793: ldc_w 4499
    //   4796: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4799: aload_1
    //   4800: astore 15
    //   4802: iload 10
    //   4804: istore 8
    //   4806: aload 5
    //   4808: invokestatic 4500	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:b	(Ljava/lang/String;)V
    //   4811: aload_1
    //   4812: astore 15
    //   4814: iload 10
    //   4816: istore 8
    //   4818: aload 17
    //   4820: aload_1
    //   4821: invokestatic 4503	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   4824: aload_1
    //   4825: astore 16
    //   4827: iload 13
    //   4829: istore 14
    //   4831: iload 10
    //   4833: istore 9
    //   4835: goto -4713 -> 122
    //   4838: aload_1
    //   4839: astore 16
    //   4841: iload 13
    //   4843: istore 14
    //   4845: iload 10
    //   4847: istore 9
    //   4849: aload_1
    //   4850: astore 15
    //   4852: iload 10
    //   4854: istore 8
    //   4856: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4859: ifeq -4737 -> 122
    //   4862: aload_1
    //   4863: astore 15
    //   4865: iload 10
    //   4867: istore 8
    //   4869: ldc_w 1592
    //   4872: iconst_2
    //   4873: ldc_w 4505
    //   4876: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4879: aload_1
    //   4880: astore 16
    //   4882: iload 13
    //   4884: istore 14
    //   4886: iload 10
    //   4888: istore 9
    //   4890: goto -4768 -> 122
    //   4893: aload_1
    //   4894: astore 16
    //   4896: iload 13
    //   4898: istore 14
    //   4900: iload 10
    //   4902: istore 9
    //   4904: aload_1
    //   4905: astore 15
    //   4907: iload 10
    //   4909: istore 8
    //   4911: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4914: ifeq -4792 -> 122
    //   4917: aload_1
    //   4918: astore 15
    //   4920: iload 10
    //   4922: istore 8
    //   4924: ldc_w 1592
    //   4927: iconst_2
    //   4928: ldc_w 4507
    //   4931: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4934: aload_1
    //   4935: astore 16
    //   4937: iload 13
    //   4939: istore 14
    //   4941: iload 10
    //   4943: istore 9
    //   4945: goto -4823 -> 122
    //   4948: aload_1
    //   4949: astore 15
    //   4951: iload 7
    //   4953: istore 8
    //   4955: aload_0
    //   4956: aload 17
    //   4958: aload 19
    //   4960: invokevirtual 4509	com/tencent/mobileqq/config/splashlogo/ConfigServlet:m	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4963: aload_1
    //   4964: astore 16
    //   4966: iload 13
    //   4968: istore 14
    //   4970: iload 7
    //   4972: istore 9
    //   4974: goto -4852 -> 122
    //   4977: aload_1
    //   4978: astore 15
    //   4980: iload 7
    //   4982: istore 8
    //   4984: aload_0
    //   4985: aload 17
    //   4987: aload 5
    //   4989: aload 19
    //   4991: invokespecial 4511	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   4994: aload_1
    //   4995: astore 16
    //   4997: iload 13
    //   4999: istore 14
    //   5001: iload 7
    //   5003: istore 9
    //   5005: goto -4883 -> 122
    //   5008: aload_1
    //   5009: astore 15
    //   5011: iload 7
    //   5013: istore 8
    //   5015: aload_0
    //   5016: aload 17
    //   5018: aload 19
    //   5020: invokevirtual 4513	com/tencent/mobileqq/config/splashlogo/ConfigServlet:u	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5023: aload_1
    //   5024: astore 16
    //   5026: iload 13
    //   5028: istore 14
    //   5030: iload 7
    //   5032: istore 9
    //   5034: goto -4912 -> 122
    //   5037: aload_1
    //   5038: astore 15
    //   5040: iload 7
    //   5042: istore 8
    //   5044: aload_0
    //   5045: aload 17
    //   5047: aload 19
    //   5049: invokevirtual 4515	com/tencent/mobileqq/config/splashlogo/ConfigServlet:w	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5052: aload_1
    //   5053: astore 16
    //   5055: iload 13
    //   5057: istore 14
    //   5059: iload 7
    //   5061: istore 9
    //   5063: goto -4941 -> 122
    //   5066: aload_1
    //   5067: astore 15
    //   5069: iload 7
    //   5071: istore 8
    //   5073: aload_0
    //   5074: aload 17
    //   5076: aload 19
    //   5078: invokevirtual 4517	com/tencent/mobileqq/config/splashlogo/ConfigServlet:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5081: aload_1
    //   5082: astore 16
    //   5084: iload 13
    //   5086: istore 14
    //   5088: iload 7
    //   5090: istore 9
    //   5092: goto -4970 -> 122
    //   5095: aload_1
    //   5096: astore 15
    //   5098: iload 7
    //   5100: istore 8
    //   5102: aload_0
    //   5103: aload 17
    //   5105: aload 19
    //   5107: invokevirtual 4519	com/tencent/mobileqq/config/splashlogo/ConfigServlet:r	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5110: aload_1
    //   5111: astore 16
    //   5113: iload 13
    //   5115: istore 14
    //   5117: iload 7
    //   5119: istore 9
    //   5121: goto -4999 -> 122
    //   5124: aload_1
    //   5125: astore 15
    //   5127: iload 7
    //   5129: istore 8
    //   5131: aload_0
    //   5132: aload 17
    //   5134: aload 19
    //   5136: invokevirtual 4521	com/tencent/mobileqq/config/splashlogo/ConfigServlet:o	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5139: aload_1
    //   5140: astore 16
    //   5142: iload 13
    //   5144: istore 14
    //   5146: iload 7
    //   5148: istore 9
    //   5150: goto -5028 -> 122
    //   5153: aload_1
    //   5154: astore 15
    //   5156: iload 7
    //   5158: istore 8
    //   5160: aload_0
    //   5161: aload 17
    //   5163: aload 19
    //   5165: invokevirtual 4523	com/tencent/mobileqq/config/splashlogo/ConfigServlet:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5168: aload_1
    //   5169: astore 16
    //   5171: iload 13
    //   5173: istore 14
    //   5175: iload 7
    //   5177: istore 9
    //   5179: goto -5057 -> 122
    //   5182: aload_1
    //   5183: astore 15
    //   5185: iload 7
    //   5187: istore 8
    //   5189: aload_0
    //   5190: aload 17
    //   5192: aload 19
    //   5194: invokevirtual 4525	com/tencent/mobileqq/config/splashlogo/ConfigServlet:s	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5197: aload_1
    //   5198: astore 16
    //   5200: iload 13
    //   5202: istore 14
    //   5204: iload 7
    //   5206: istore 9
    //   5208: goto -5086 -> 122
    //   5211: aload_1
    //   5212: astore 15
    //   5214: iload 7
    //   5216: istore 8
    //   5218: aload_0
    //   5219: aload 17
    //   5221: aload 19
    //   5223: invokevirtual 4527	com/tencent/mobileqq/config/splashlogo/ConfigServlet:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5226: aload_1
    //   5227: astore 16
    //   5229: iload 13
    //   5231: istore 14
    //   5233: iload 7
    //   5235: istore 9
    //   5237: goto -5115 -> 122
    //   5240: aload_1
    //   5241: astore 15
    //   5243: iload 7
    //   5245: istore 8
    //   5247: aload_0
    //   5248: aload 17
    //   5250: aload 5
    //   5252: aload 19
    //   5254: invokespecial 4529	com/tencent/mobileqq/config/splashlogo/ConfigServlet:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5257: aload_1
    //   5258: astore 16
    //   5260: iload 13
    //   5262: istore 14
    //   5264: iload 7
    //   5266: istore 9
    //   5268: goto -5146 -> 122
    //   5271: aload_1
    //   5272: astore 15
    //   5274: iload 7
    //   5276: istore 8
    //   5278: aload 17
    //   5280: getstatic 1681	com/tencent/mobileqq/app/QQManagerFactory:TROOP_STORY_MANAGER	I
    //   5283: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5286: checkcast 1683	com/tencent/biz/qqstory/troop/TroopStoryManager
    //   5289: getfield 1686	com/tencent/biz/qqstory/troop/TroopStoryManager:d	Lcom/tencent/biz/qqstory/troop/TroopDynamicConfig;
    //   5292: aload 17
    //   5294: aload 19
    //   5296: invokevirtual 4530	com/tencent/biz/qqstory/troop/TroopDynamicConfig:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5299: aload_1
    //   5300: astore 16
    //   5302: iload 13
    //   5304: istore 14
    //   5306: iload 7
    //   5308: istore 9
    //   5310: goto -5188 -> 122
    //   5313: aload_1
    //   5314: astore 15
    //   5316: iload 7
    //   5318: istore 8
    //   5320: aload_0
    //   5321: aload 17
    //   5323: aload 19
    //   5325: invokevirtual 4532	com/tencent/mobileqq/config/splashlogo/ConfigServlet:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5328: aload_1
    //   5329: astore 16
    //   5331: iload 13
    //   5333: istore 14
    //   5335: iload 7
    //   5337: istore 9
    //   5339: goto -5217 -> 122
    //   5342: aload_1
    //   5343: astore 15
    //   5345: iload 7
    //   5347: istore 8
    //   5349: aload_0
    //   5350: aload 17
    //   5352: aload 19
    //   5354: invokespecial 4534	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aA	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5357: aload_1
    //   5358: astore 16
    //   5360: iload 13
    //   5362: istore 14
    //   5364: iload 7
    //   5366: istore 9
    //   5368: goto -5246 -> 122
    //   5371: aload_1
    //   5372: astore 15
    //   5374: iload 7
    //   5376: istore 8
    //   5378: aload_0
    //   5379: aload 17
    //   5381: aload 19
    //   5383: invokespecial 4536	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aF	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5386: aload_1
    //   5387: astore 16
    //   5389: iload 13
    //   5391: istore 14
    //   5393: iload 7
    //   5395: istore 9
    //   5397: goto -5275 -> 122
    //   5400: aload_1
    //   5401: astore 15
    //   5403: iload 7
    //   5405: istore 8
    //   5407: aload_0
    //   5408: aload 17
    //   5410: aload 19
    //   5412: invokevirtual 4538	com/tencent/mobileqq/config/splashlogo/ConfigServlet:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5415: aload_1
    //   5416: astore 16
    //   5418: iload 13
    //   5420: istore 14
    //   5422: iload 7
    //   5424: istore 9
    //   5426: goto -5304 -> 122
    //   5429: aload_1
    //   5430: astore 15
    //   5432: iload 7
    //   5434: istore 8
    //   5436: iload 10
    //   5438: aload 17
    //   5440: invokevirtual 1195	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   5443: aload 19
    //   5445: invokestatic 4541	com/tencent/av/QAVConfig:a	(ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5448: aload_1
    //   5449: astore 16
    //   5451: iload 13
    //   5453: istore 14
    //   5455: iload 7
    //   5457: istore 9
    //   5459: goto -5337 -> 122
    //   5462: aload_1
    //   5463: astore 15
    //   5465: iload 7
    //   5467: istore 8
    //   5469: aload_0
    //   5470: aload 17
    //   5472: aload 19
    //   5474: invokespecial 4543	com/tencent/mobileqq/config/splashlogo/ConfigServlet:U	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5477: aload_1
    //   5478: astore 16
    //   5480: iload 13
    //   5482: istore 14
    //   5484: iload 7
    //   5486: istore 9
    //   5488: goto -5366 -> 122
    //   5491: aload_1
    //   5492: astore 15
    //   5494: iload 7
    //   5496: istore 8
    //   5498: aload_0
    //   5499: aload 17
    //   5501: aload 19
    //   5503: invokevirtual 4545	com/tencent/mobileqq/config/splashlogo/ConfigServlet:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5506: aload_1
    //   5507: astore 16
    //   5509: iload 13
    //   5511: istore 14
    //   5513: iload 7
    //   5515: istore 9
    //   5517: goto -5395 -> 122
    //   5520: aload_1
    //   5521: astore 15
    //   5523: iload 7
    //   5525: istore 8
    //   5527: aload_0
    //   5528: aload 17
    //   5530: aload 19
    //   5532: invokevirtual 4547	com/tencent/mobileqq/config/splashlogo/ConfigServlet:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5535: aload_1
    //   5536: astore 16
    //   5538: iload 13
    //   5540: istore 14
    //   5542: iload 7
    //   5544: istore 9
    //   5546: goto -5424 -> 122
    //   5549: aload_1
    //   5550: astore 15
    //   5552: iload 7
    //   5554: istore 8
    //   5556: aload_0
    //   5557: aload 17
    //   5559: aload 5
    //   5561: aload 19
    //   5563: invokespecial 4549	com/tencent/mobileqq/config/splashlogo/ConfigServlet:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5566: aload_1
    //   5567: astore 16
    //   5569: iload 13
    //   5571: istore 14
    //   5573: iload 7
    //   5575: istore 9
    //   5577: goto -5455 -> 122
    //   5580: aload_1
    //   5581: astore 15
    //   5583: iload 7
    //   5585: istore 8
    //   5587: aload_0
    //   5588: aload 17
    //   5590: aload 19
    //   5592: invokevirtual 4551	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5595: aload_1
    //   5596: astore 16
    //   5598: iload 13
    //   5600: istore 14
    //   5602: iload 7
    //   5604: istore 9
    //   5606: goto -5484 -> 122
    //   5609: aload_1
    //   5610: astore 15
    //   5612: iload 7
    //   5614: istore 8
    //   5616: aload_0
    //   5617: aload 17
    //   5619: aload 19
    //   5621: invokespecial 4553	com/tencent/mobileqq/config/splashlogo/ConfigServlet:Z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5624: aload_1
    //   5625: astore 16
    //   5627: iload 13
    //   5629: istore 14
    //   5631: iload 7
    //   5633: istore 9
    //   5635: goto -5513 -> 122
    //   5638: aload_1
    //   5639: astore 15
    //   5641: iload 7
    //   5643: istore 8
    //   5645: aload_0
    //   5646: aload 17
    //   5648: aload 19
    //   5650: invokespecial 4555	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aC	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5653: aload_1
    //   5654: astore 16
    //   5656: iload 13
    //   5658: istore 14
    //   5660: iload 7
    //   5662: istore 9
    //   5664: goto -5542 -> 122
    //   5667: aload_1
    //   5668: astore 15
    //   5670: iload 7
    //   5672: istore 8
    //   5674: aload_0
    //   5675: aload 17
    //   5677: aload 19
    //   5679: invokespecial 4557	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ag	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5682: aload_1
    //   5683: astore 16
    //   5685: iload 13
    //   5687: istore 14
    //   5689: iload 7
    //   5691: istore 9
    //   5693: goto -5571 -> 122
    //   5696: aload_1
    //   5697: astore 15
    //   5699: iload 7
    //   5701: istore 8
    //   5703: aload_0
    //   5704: aload 17
    //   5706: aload 19
    //   5708: invokespecial 4559	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aB	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5711: aload_1
    //   5712: astore 16
    //   5714: iload 13
    //   5716: istore 14
    //   5718: iload 7
    //   5720: istore 9
    //   5722: goto -5600 -> 122
    //   5725: aload_1
    //   5726: astore 15
    //   5728: iload 7
    //   5730: istore 8
    //   5732: aload_0
    //   5733: aload 17
    //   5735: aload 19
    //   5737: invokespecial 4561	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ab	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5740: aload_1
    //   5741: astore 16
    //   5743: iload 13
    //   5745: istore 14
    //   5747: iload 7
    //   5749: istore 9
    //   5751: goto -5629 -> 122
    //   5754: aload_1
    //   5755: astore 15
    //   5757: iload 7
    //   5759: istore 8
    //   5761: aload_0
    //   5762: aload 17
    //   5764: aload 19
    //   5766: invokespecial 4563	com/tencent/mobileqq/config/splashlogo/ConfigServlet:az	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5769: aload_1
    //   5770: astore 16
    //   5772: iload 13
    //   5774: istore 14
    //   5776: iload 7
    //   5778: istore 9
    //   5780: goto -5658 -> 122
    //   5783: aload_1
    //   5784: astore 15
    //   5786: iload 7
    //   5788: istore 8
    //   5790: aload_0
    //   5791: aload 17
    //   5793: aload 19
    //   5795: invokespecial 4565	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ay	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5798: aload_1
    //   5799: astore 16
    //   5801: iload 13
    //   5803: istore 14
    //   5805: iload 7
    //   5807: istore 9
    //   5809: goto -5687 -> 122
    //   5812: aload_1
    //   5813: astore 15
    //   5815: iload 7
    //   5817: istore 8
    //   5819: aload_0
    //   5820: aload 17
    //   5822: aload 19
    //   5824: invokespecial 4567	com/tencent/mobileqq/config/splashlogo/ConfigServlet:Y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5827: aload_1
    //   5828: astore 16
    //   5830: iload 13
    //   5832: istore 14
    //   5834: iload 7
    //   5836: istore 9
    //   5838: goto -5716 -> 122
    //   5841: aload_1
    //   5842: astore 15
    //   5844: iload 7
    //   5846: istore 8
    //   5848: aload 17
    //   5850: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   5853: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   5856: invokestatic 1752	com/tencent/mobileqq/utils/SharedPreUtils:O	(Landroid/content/Context;Ljava/lang/String;)I
    //   5859: istore 9
    //   5861: aload_1
    //   5862: astore 15
    //   5864: iload 7
    //   5866: istore 8
    //   5868: aload 19
    //   5870: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5873: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5876: istore 10
    //   5878: aload_1
    //   5879: astore 15
    //   5881: iload 7
    //   5883: istore 8
    //   5885: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5888: ifeq +42 -> 5930
    //   5891: aload_1
    //   5892: astore 15
    //   5894: iload 7
    //   5896: istore 8
    //   5898: ldc 92
    //   5900: iconst_2
    //   5901: ldc_w 4569
    //   5904: iconst_2
    //   5905: anewarray 4	java/lang/Object
    //   5908: dup
    //   5909: iconst_0
    //   5910: iload 9
    //   5912: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5915: aastore
    //   5916: dup
    //   5917: iconst_1
    //   5918: iload 10
    //   5920: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5923: aastore
    //   5924: invokestatic 551	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5927: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5930: iload 9
    //   5932: iload 10
    //   5934: if_icmpeq +266 -> 6200
    //   5937: aload_1
    //   5938: astore 15
    //   5940: iload 7
    //   5942: istore 8
    //   5944: aload 19
    //   5946: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5949: ifnull +179 -> 6128
    //   5952: aload_1
    //   5953: astore 15
    //   5955: iload 7
    //   5957: istore 8
    //   5959: aload 19
    //   5961: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5964: invokevirtual 4570	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   5967: ifeq +6 -> 5973
    //   5970: goto +158 -> 6128
    //   5973: aload_1
    //   5974: astore 15
    //   5976: iload 7
    //   5978: istore 8
    //   5980: aload 19
    //   5982: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5985: iconst_0
    //   5986: invokevirtual 467	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   5989: checkcast 126	java/lang/String
    //   5992: astore 5
    //   5994: aload_1
    //   5995: astore 15
    //   5997: iload 7
    //   5999: istore 8
    //   6001: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6004: ifeq +68 -> 6072
    //   6007: aload_1
    //   6008: astore 15
    //   6010: iload 7
    //   6012: istore 8
    //   6014: new 78	java/lang/StringBuilder
    //   6017: dup
    //   6018: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   6021: astore 16
    //   6023: aload_1
    //   6024: astore 15
    //   6026: iload 7
    //   6028: istore 8
    //   6030: aload 16
    //   6032: ldc_w 4572
    //   6035: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6038: pop
    //   6039: aload_1
    //   6040: astore 15
    //   6042: iload 7
    //   6044: istore 8
    //   6046: aload 16
    //   6048: aload 5
    //   6050: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6053: pop
    //   6054: aload_1
    //   6055: astore 15
    //   6057: iload 7
    //   6059: istore 8
    //   6061: ldc 92
    //   6063: iconst_2
    //   6064: aload 16
    //   6066: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6069: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6072: aload_1
    //   6073: astore 15
    //   6075: iload 7
    //   6077: istore 8
    //   6079: aload 5
    //   6081: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6084: ifeq +23 -> 6107
    //   6087: aload_1
    //   6088: astore 15
    //   6090: iload 7
    //   6092: istore 8
    //   6094: ldc_w 4574
    //   6097: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   6100: invokestatic 4579	com/tencent/mobileqq/upgrade/UpgradeConfigManager:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   6103: pop
    //   6104: goto +73 -> 6177
    //   6107: aload_1
    //   6108: astore 15
    //   6110: iload 7
    //   6112: istore 8
    //   6114: ldc_w 4574
    //   6117: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   6120: aload 5
    //   6122: invokestatic 4582	com/tencent/mobileqq/upgrade/UpgradeConfigManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6125: goto +52 -> 6177
    //   6128: aload_1
    //   6129: astore 15
    //   6131: iload 7
    //   6133: istore 8
    //   6135: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6138: ifeq +19 -> 6157
    //   6141: aload_1
    //   6142: astore 15
    //   6144: iload 7
    //   6146: istore 8
    //   6148: ldc 92
    //   6150: iconst_2
    //   6151: ldc_w 4584
    //   6154: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6157: aload_1
    //   6158: astore 15
    //   6160: iload 7
    //   6162: istore 8
    //   6164: ldc_w 4574
    //   6167: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   6170: invokestatic 4579	com/tencent/mobileqq/upgrade/UpgradeConfigManager:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   6173: pop
    //   6174: aconst_null
    //   6175: astore 5
    //   6177: aload_1
    //   6178: astore 15
    //   6180: iload 7
    //   6182: istore 8
    //   6184: aload 17
    //   6186: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   6189: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   6192: iload 10
    //   6194: invokestatic 4586	com/tencent/mobileqq/utils/SharedPreUtils:m	(Landroid/content/Context;Ljava/lang/String;I)V
    //   6197: goto +35 -> 6232
    //   6200: aload_1
    //   6201: astore 15
    //   6203: iload 7
    //   6205: istore 8
    //   6207: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6210: ifeq +7552 -> 13762
    //   6213: aload_1
    //   6214: astore 15
    //   6216: iload 7
    //   6218: istore 8
    //   6220: ldc 92
    //   6222: iconst_2
    //   6223: ldc_w 4588
    //   6226: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6229: goto +7533 -> 13762
    //   6232: aload_1
    //   6233: astore 15
    //   6235: iload 7
    //   6237: istore 8
    //   6239: aload 17
    //   6241: getstatic 1767	com/tencent/mobileqq/app/BusinessHandlerFactory:CONFIG_HANDLER	Ljava/lang/String;
    //   6244: invokevirtual 1321	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   6247: checkcast 1769	com/tencent/mobileqq/app/ConfigHandler
    //   6250: astore 19
    //   6252: aload_1
    //   6253: astore 15
    //   6255: iload 7
    //   6257: istore 8
    //   6259: aload 5
    //   6261: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6264: ifne +524 -> 6788
    //   6267: aload_1
    //   6268: astore 15
    //   6270: iload 7
    //   6272: istore 8
    //   6274: invokestatic 4593	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeController;
    //   6277: invokevirtual 4596	com/tencent/mobileqq/upgrade/UpgradeController:d	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   6280: astore 16
    //   6282: aload_1
    //   6283: astore 15
    //   6285: iload 7
    //   6287: istore 8
    //   6289: aload 16
    //   6291: aload 5
    //   6293: invokevirtual 4599	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:a	(Ljava/lang/String;)V
    //   6296: aload_1
    //   6297: astore 15
    //   6299: iload 7
    //   6301: istore 8
    //   6303: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6306: ifeq +49 -> 6355
    //   6309: aload_1
    //   6310: astore 15
    //   6312: iload 7
    //   6314: istore 8
    //   6316: ldc 92
    //   6318: iconst_2
    //   6319: ldc_w 4601
    //   6322: iconst_2
    //   6323: anewarray 4	java/lang/Object
    //   6326: dup
    //   6327: iconst_0
    //   6328: invokestatic 1182	com/tencent/common/config/AppSetting:d	()I
    //   6331: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6334: aastore
    //   6335: dup
    //   6336: iconst_1
    //   6337: aload 16
    //   6339: getfield 4604	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:c	Lprotocol/KQQConfig/UpgradeInfo;
    //   6342: getfield 4609	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   6345: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6348: aastore
    //   6349: invokestatic 551	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6352: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6355: aload_1
    //   6356: astore 15
    //   6358: iload 7
    //   6360: istore 8
    //   6362: aload 17
    //   6364: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6367: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   6370: invokestatic 4612	com/tencent/mobileqq/utils/SharedPreUtils:bS	(Landroid/content/Context;Ljava/lang/String;)I
    //   6373: aload 16
    //   6375: getfield 4604	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:c	Lprotocol/KQQConfig/UpgradeInfo;
    //   6378: getfield 4609	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   6381: if_icmpeq +113 -> 6494
    //   6384: aload_1
    //   6385: astore 15
    //   6387: iload 7
    //   6389: istore 8
    //   6391: aload 17
    //   6393: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6396: aload 17
    //   6398: invokevirtual 1195	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   6401: iconst_0
    //   6402: invokestatic 4614	com/tencent/mobileqq/utils/SharedPreUtils:Z	(Landroid/content/Context;Ljava/lang/String;I)V
    //   6405: aload_1
    //   6406: astore 15
    //   6408: iload 7
    //   6410: istore 8
    //   6412: aload 17
    //   6414: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6417: aload 17
    //   6419: invokevirtual 1195	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   6422: lconst_0
    //   6423: invokestatic 4617	com/tencent/mobileqq/utils/SharedPreUtils:g	(Landroid/content/Context;Ljava/lang/String;J)V
    //   6426: aload_1
    //   6427: astore 15
    //   6429: iload 7
    //   6431: istore 8
    //   6433: aload 17
    //   6435: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6438: aload 17
    //   6440: invokevirtual 1195	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   6443: iconst_0
    //   6444: invokestatic 4619	com/tencent/mobileqq/utils/SharedPreUtils:aa	(Landroid/content/Context;Ljava/lang/String;I)V
    //   6447: aload_1
    //   6448: astore 15
    //   6450: iload 7
    //   6452: istore 8
    //   6454: aload 17
    //   6456: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6459: aload 17
    //   6461: invokevirtual 1195	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   6464: lconst_0
    //   6465: invokestatic 4621	com/tencent/mobileqq/utils/SharedPreUtils:h	(Landroid/content/Context;Ljava/lang/String;J)V
    //   6468: aload_1
    //   6469: astore 15
    //   6471: iload 7
    //   6473: istore 8
    //   6475: aload 17
    //   6477: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6480: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   6483: aload 16
    //   6485: getfield 4604	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:c	Lprotocol/KQQConfig/UpgradeInfo;
    //   6488: getfield 4609	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   6491: invokestatic 4623	com/tencent/mobileqq/utils/SharedPreUtils:Y	(Landroid/content/Context;Ljava/lang/String;I)V
    //   6494: aload_1
    //   6495: astore 15
    //   6497: iload 7
    //   6499: istore 8
    //   6501: invokestatic 1182	com/tencent/common/config/AppSetting:d	()I
    //   6504: aload 16
    //   6506: getfield 4604	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:c	Lprotocol/KQQConfig/UpgradeInfo;
    //   6509: getfield 4609	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   6512: if_icmplt +124 -> 6636
    //   6515: aload_1
    //   6516: astore 15
    //   6518: iload 7
    //   6520: istore 8
    //   6522: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6525: ifeq +19 -> 6544
    //   6528: aload_1
    //   6529: astore 15
    //   6531: iload 7
    //   6533: istore 8
    //   6535: ldc 92
    //   6537: iconst_2
    //   6538: ldc_w 4625
    //   6541: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6544: aload_1
    //   6545: astore 15
    //   6547: iload 7
    //   6549: istore 8
    //   6551: aload 17
    //   6553: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6556: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   6559: iconst_0
    //   6560: invokestatic 4586	com/tencent/mobileqq/utils/SharedPreUtils:m	(Landroid/content/Context;Ljava/lang/String;I)V
    //   6563: aload_1
    //   6564: astore 15
    //   6566: iload 7
    //   6568: istore 8
    //   6570: ldc_w 4574
    //   6573: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   6576: invokestatic 4579	com/tencent/mobileqq/upgrade/UpgradeConfigManager:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   6579: pop
    //   6580: aload_1
    //   6581: astore 15
    //   6583: iload 7
    //   6585: istore 8
    //   6587: aload 16
    //   6589: getfield 4604	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:c	Lprotocol/KQQConfig/UpgradeInfo;
    //   6592: iconst_0
    //   6593: putfield 4628	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   6596: aload_1
    //   6597: astore 15
    //   6599: iload 7
    //   6601: istore 8
    //   6603: aload 19
    //   6605: aload 16
    //   6607: invokevirtual 4631	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   6610: aload_1
    //   6611: astore 15
    //   6613: iload 7
    //   6615: istore 8
    //   6617: aload 19
    //   6619: invokevirtual 4633	com/tencent/mobileqq/app/ConfigHandler:f	()V
    //   6622: aload_1
    //   6623: astore 16
    //   6625: iload 13
    //   6627: istore 14
    //   6629: iload 7
    //   6631: istore 9
    //   6633: goto -6511 -> 122
    //   6636: aload 17
    //   6638: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   6641: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   6644: invokestatic 2143	java/lang/System:currentTimeMillis	()J
    //   6647: invokestatic 4635	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;J)V
    //   6650: aload 16
    //   6652: monitorenter
    //   6653: aload 16
    //   6655: getfield 4637	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:g	Z
    //   6658: ifne +34 -> 6692
    //   6661: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6664: ifeq +12 -> 6676
    //   6667: ldc 92
    //   6669: iconst_2
    //   6670: ldc_w 4639
    //   6673: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6676: aload 16
    //   6678: monitorexit
    //   6679: iconst_1
    //   6680: istore 14
    //   6682: aload_1
    //   6683: astore 16
    //   6685: iload 7
    //   6687: istore 9
    //   6689: goto +6811 -> 13500
    //   6692: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6695: ifeq +12 -> 6707
    //   6698: ldc 92
    //   6700: iconst_2
    //   6701: ldc_w 4641
    //   6704: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6707: aload 16
    //   6709: getfield 4643	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:j	I
    //   6712: ifne +25 -> 6737
    //   6715: aload 16
    //   6717: getfield 4645	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:i	I
    //   6720: iconst_1
    //   6721: if_icmpne +7047 -> 13768
    //   6724: iconst_1
    //   6725: istore 13
    //   6727: goto +3 -> 6730
    //   6730: aload 17
    //   6732: iload 13
    //   6734: invokestatic 4646	com/tencent/mobileqq/app/ConfigHandler:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   6737: aload 19
    //   6739: invokevirtual 4633	com/tencent/mobileqq/app/ConfigHandler:f	()V
    //   6742: invokestatic 4593	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeController;
    //   6745: aload 16
    //   6747: getfield 4604	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:c	Lprotocol/KQQConfig/UpgradeInfo;
    //   6750: aload 19
    //   6752: invokevirtual 4649	com/tencent/mobileqq/upgrade/UpgradeController:a	(Lprotocol/KQQConfig/UpgradeInfo;Lcom/tencent/mobileqq/upgrade/UpgradeController$OnHandleUpgradeFinishListener;)Z
    //   6755: pop
    //   6756: aload 16
    //   6758: monitorexit
    //   6759: iconst_1
    //   6760: istore 14
    //   6762: aload_1
    //   6763: astore 16
    //   6765: iload 7
    //   6767: istore 9
    //   6769: goto -6647 -> 122
    //   6772: astore 5
    //   6774: aload 16
    //   6776: monitorexit
    //   6777: aload 5
    //   6779: athrow
    //   6780: astore 5
    //   6782: iconst_1
    //   6783: istore 13
    //   6785: goto +6647 -> 13432
    //   6788: aload_1
    //   6789: astore 15
    //   6791: iload 7
    //   6793: istore 8
    //   6795: aload 19
    //   6797: invokevirtual 4633	com/tencent/mobileqq/app/ConfigHandler:f	()V
    //   6800: aload_1
    //   6801: astore 15
    //   6803: iload 7
    //   6805: istore 8
    //   6807: aload 19
    //   6809: invokestatic 4593	com/tencent/mobileqq/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/upgrade/UpgradeController;
    //   6812: invokevirtual 4596	com/tencent/mobileqq/upgrade/UpgradeController:d	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   6815: invokevirtual 4631	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   6818: aload_1
    //   6819: astore 16
    //   6821: iload 13
    //   6823: istore 14
    //   6825: iload 7
    //   6827: istore 9
    //   6829: goto -6707 -> 122
    //   6832: aload_1
    //   6833: astore 15
    //   6835: iload 7
    //   6837: istore 8
    //   6839: aload_0
    //   6840: aload 17
    //   6842: aload 5
    //   6844: aload 19
    //   6846: invokespecial 4651	com/tencent/mobileqq/config/splashlogo/ConfigServlet:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6849: aload_1
    //   6850: astore 16
    //   6852: iload 13
    //   6854: istore 14
    //   6856: iload 7
    //   6858: istore 9
    //   6860: goto -6738 -> 122
    //   6863: aload_1
    //   6864: astore 15
    //   6866: iload 7
    //   6868: istore 8
    //   6870: aload_0
    //   6871: aload 17
    //   6873: aload 19
    //   6875: invokespecial 4653	com/tencent/mobileqq/config/splashlogo/ConfigServlet:X	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6878: aload_1
    //   6879: astore 16
    //   6881: iload 13
    //   6883: istore 14
    //   6885: iload 7
    //   6887: istore 9
    //   6889: goto -6767 -> 122
    //   6892: aload_2
    //   6893: getfield 4656	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6896: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6899: istore 9
    //   6901: aload_1
    //   6902: astore 15
    //   6904: iload 7
    //   6906: istore 8
    //   6908: aload_0
    //   6909: aload 5
    //   6911: iload 6
    //   6913: aload 19
    //   6915: iload 9
    //   6917: invokevirtual 4658	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   6920: aload_1
    //   6921: astore 16
    //   6923: iload 13
    //   6925: istore 14
    //   6927: iload 7
    //   6929: istore 9
    //   6931: goto -6809 -> 122
    //   6934: aload_1
    //   6935: astore 15
    //   6937: iload 7
    //   6939: istore 8
    //   6941: aload_0
    //   6942: aload 17
    //   6944: aload 19
    //   6946: invokespecial 4660	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ah	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6949: aload_1
    //   6950: astore 16
    //   6952: iload 13
    //   6954: istore 14
    //   6956: iload 7
    //   6958: istore 9
    //   6960: goto -6838 -> 122
    //   6963: aload_1
    //   6964: astore 15
    //   6966: iload 7
    //   6968: istore 8
    //   6970: aload_0
    //   6971: aload 17
    //   6973: aload 5
    //   6975: aload 19
    //   6977: invokespecial 4662	com/tencent/mobileqq/config/splashlogo/ConfigServlet:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   6980: aload_1
    //   6981: astore 16
    //   6983: iload 13
    //   6985: istore 14
    //   6987: iload 7
    //   6989: istore 9
    //   6991: goto -6869 -> 122
    //   6994: aload 19
    //   6996: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6999: ifnull +150 -> 7149
    //   7002: aload 19
    //   7004: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7007: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7010: ifle +139 -> 7149
    //   7013: aload 19
    //   7015: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7018: invokevirtual 2720	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7021: invokeinterface 115 1 0
    //   7026: astore 5
    //   7028: aload_1
    //   7029: astore 16
    //   7031: iload 13
    //   7033: istore 14
    //   7035: iload 7
    //   7037: istore 9
    //   7039: aload 5
    //   7041: invokeinterface 120 1 0
    //   7046: ifeq -6924 -> 122
    //   7049: aload 5
    //   7051: invokeinterface 124 1 0
    //   7056: checkcast 126	java/lang/String
    //   7059: astore 15
    //   7061: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7064: ifeq +6715 -> 13779
    //   7067: new 78	java/lang/StringBuilder
    //   7070: dup
    //   7071: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   7074: astore 16
    //   7076: aload 16
    //   7078: ldc_w 4664
    //   7081: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7084: pop
    //   7085: aload 16
    //   7087: aload 15
    //   7089: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7092: pop
    //   7093: aload 16
    //   7095: ldc_w 474
    //   7098: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7101: pop
    //   7102: aload 16
    //   7104: aload 19
    //   7106: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7109: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7112: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7115: pop
    //   7116: ldc 92
    //   7118: iconst_2
    //   7119: aload 16
    //   7121: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7124: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7127: goto +3 -> 7130
    //   7130: aload_0
    //   7131: aload 17
    //   7133: aload 15
    //   7135: aload 19
    //   7137: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7140: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7143: invokespecial 4666	com/tencent/mobileqq/config/splashlogo/ConfigServlet:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   7146: goto -118 -> 7028
    //   7149: aload_1
    //   7150: astore 16
    //   7152: iload 13
    //   7154: istore 14
    //   7156: iload 7
    //   7158: istore 9
    //   7160: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7163: ifeq -7041 -> 122
    //   7166: new 78	java/lang/StringBuilder
    //   7169: dup
    //   7170: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   7173: astore 5
    //   7175: aload 5
    //   7177: ldc_w 4668
    //   7180: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7183: pop
    //   7184: aload 5
    //   7186: aload 19
    //   7188: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7191: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7194: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7197: pop
    //   7198: ldc 92
    //   7200: iconst_2
    //   7201: aload 5
    //   7203: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7206: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7209: aload_1
    //   7210: astore 16
    //   7212: iload 13
    //   7214: istore 14
    //   7216: iload 7
    //   7218: istore 9
    //   7220: goto -7098 -> 122
    //   7223: astore 5
    //   7225: aload_1
    //   7226: astore 15
    //   7228: iload 7
    //   7230: istore 8
    //   7232: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7235: ifeq +71 -> 7306
    //   7238: aload_1
    //   7239: astore 15
    //   7241: iload 7
    //   7243: istore 8
    //   7245: new 78	java/lang/StringBuilder
    //   7248: dup
    //   7249: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   7252: astore 16
    //   7254: aload_1
    //   7255: astore 15
    //   7257: iload 7
    //   7259: istore 8
    //   7261: aload 16
    //   7263: ldc_w 4670
    //   7266: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7269: pop
    //   7270: aload_1
    //   7271: astore 15
    //   7273: iload 7
    //   7275: istore 8
    //   7277: aload 16
    //   7279: aload 5
    //   7281: invokevirtual 531	java/lang/Exception:toString	()Ljava/lang/String;
    //   7284: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7287: pop
    //   7288: aload_1
    //   7289: astore 15
    //   7291: iload 7
    //   7293: istore 8
    //   7295: ldc 92
    //   7297: iconst_2
    //   7298: aload 16
    //   7300: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7303: invokestatic 533	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7306: aload_1
    //   7307: astore 15
    //   7309: iload 7
    //   7311: istore 8
    //   7313: aload 5
    //   7315: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   7318: aload_1
    //   7319: astore 16
    //   7321: iload 13
    //   7323: istore 14
    //   7325: iload 7
    //   7327: istore 9
    //   7329: goto -7207 -> 122
    //   7332: aload_1
    //   7333: astore 15
    //   7335: iload 7
    //   7337: istore 8
    //   7339: aload 19
    //   7341: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7344: ifnull +266 -> 7610
    //   7347: aload_1
    //   7348: astore 15
    //   7350: iload 7
    //   7352: istore 8
    //   7354: aload 19
    //   7356: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7359: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7362: ifle +248 -> 7610
    //   7365: aload_1
    //   7366: astore 15
    //   7368: iload 7
    //   7370: istore 8
    //   7372: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7375: ifeq +146 -> 7521
    //   7378: aload_1
    //   7379: astore 15
    //   7381: iload 7
    //   7383: istore 8
    //   7385: new 78	java/lang/StringBuilder
    //   7388: dup
    //   7389: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   7392: astore 5
    //   7394: aload_1
    //   7395: astore 15
    //   7397: iload 7
    //   7399: istore 8
    //   7401: aload 5
    //   7403: ldc_w 4672
    //   7406: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7409: pop
    //   7410: aload_1
    //   7411: astore 15
    //   7413: iload 7
    //   7415: istore 8
    //   7417: aload 5
    //   7419: iload 10
    //   7421: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7424: pop
    //   7425: aload_1
    //   7426: astore 15
    //   7428: iload 7
    //   7430: istore 8
    //   7432: aload 5
    //   7434: ldc_w 4674
    //   7437: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7440: pop
    //   7441: aload_1
    //   7442: astore 15
    //   7444: iload 7
    //   7446: istore 8
    //   7448: aload 5
    //   7450: aload 19
    //   7452: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7455: iconst_0
    //   7456: invokevirtual 467	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7459: checkcast 126	java/lang/String
    //   7462: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7465: pop
    //   7466: aload_1
    //   7467: astore 15
    //   7469: iload 7
    //   7471: istore 8
    //   7473: aload 5
    //   7475: ldc_w 474
    //   7478: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7481: pop
    //   7482: aload_1
    //   7483: astore 15
    //   7485: iload 7
    //   7487: istore 8
    //   7489: aload 5
    //   7491: aload 19
    //   7493: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7496: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7499: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7502: pop
    //   7503: aload_1
    //   7504: astore 15
    //   7506: iload 7
    //   7508: istore 8
    //   7510: ldc 92
    //   7512: iconst_2
    //   7513: aload 5
    //   7515: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7518: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7521: aload_1
    //   7522: astore 16
    //   7524: iload 13
    //   7526: istore 14
    //   7528: iload 7
    //   7530: istore 9
    //   7532: aload_1
    //   7533: astore 15
    //   7535: iload 7
    //   7537: istore 8
    //   7539: aload 17
    //   7541: getstatic 4677	com/tencent/mobileqq/app/QQManagerFactory:PHOTO_PLUS_MANAGER	I
    //   7544: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7547: checkcast 4679	cooperation/photoplus/PhotoPlusManager
    //   7550: aload 19
    //   7552: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7555: iconst_0
    //   7556: invokevirtual 467	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7559: checkcast 126	java/lang/String
    //   7562: invokevirtual 4680	cooperation/photoplus/PhotoPlusManager:a	(Ljava/lang/String;)Z
    //   7565: ifeq -7443 -> 122
    //   7568: aload_1
    //   7569: astore 15
    //   7571: iload 7
    //   7573: istore 8
    //   7575: aload 17
    //   7577: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7580: aload 17
    //   7582: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   7585: aload 19
    //   7587: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7590: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7593: invokestatic 4682	com/tencent/mobileqq/utils/SharedPreUtils:o	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7596: aload_1
    //   7597: astore 16
    //   7599: iload 13
    //   7601: istore 14
    //   7603: iload 7
    //   7605: istore 9
    //   7607: goto -7485 -> 122
    //   7610: aload_1
    //   7611: astore 16
    //   7613: iload 13
    //   7615: istore 14
    //   7617: iload 7
    //   7619: istore 9
    //   7621: aload_1
    //   7622: astore 15
    //   7624: iload 7
    //   7626: istore 8
    //   7628: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7631: ifeq -7509 -> 122
    //   7634: aload_1
    //   7635: astore 15
    //   7637: iload 7
    //   7639: istore 8
    //   7641: new 78	java/lang/StringBuilder
    //   7644: dup
    //   7645: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   7648: astore 5
    //   7650: aload_1
    //   7651: astore 15
    //   7653: iload 7
    //   7655: istore 8
    //   7657: aload 5
    //   7659: ldc_w 4672
    //   7662: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7665: pop
    //   7666: aload_1
    //   7667: astore 15
    //   7669: iload 7
    //   7671: istore 8
    //   7673: aload 5
    //   7675: iload 10
    //   7677: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7680: pop
    //   7681: aload_1
    //   7682: astore 15
    //   7684: iload 7
    //   7686: istore 8
    //   7688: aload 5
    //   7690: ldc_w 4684
    //   7693: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7696: pop
    //   7697: aload_1
    //   7698: astore 15
    //   7700: iload 7
    //   7702: istore 8
    //   7704: aload 5
    //   7706: aload 19
    //   7708: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7711: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7714: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7717: pop
    //   7718: aload_1
    //   7719: astore 15
    //   7721: iload 7
    //   7723: istore 8
    //   7725: ldc 92
    //   7727: iconst_2
    //   7728: aload 5
    //   7730: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7733: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7736: aload_1
    //   7737: astore 16
    //   7739: iload 13
    //   7741: istore 14
    //   7743: iload 7
    //   7745: istore 9
    //   7747: goto -7625 -> 122
    //   7750: aload_1
    //   7751: astore 15
    //   7753: iload 7
    //   7755: istore 8
    //   7757: aload_0
    //   7758: aload 17
    //   7760: aload 5
    //   7762: aload 19
    //   7764: invokespecial 4686	com/tencent/mobileqq/config/splashlogo/ConfigServlet:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7767: aload_1
    //   7768: astore 16
    //   7770: iload 13
    //   7772: istore 14
    //   7774: iload 7
    //   7776: istore 9
    //   7778: goto -7656 -> 122
    //   7781: aload_1
    //   7782: astore 15
    //   7784: iload 7
    //   7786: istore 8
    //   7788: aload_0
    //   7789: aload 17
    //   7791: aload 19
    //   7793: invokespecial 4688	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ax	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7796: aload_1
    //   7797: astore 16
    //   7799: iload 13
    //   7801: istore 14
    //   7803: iload 7
    //   7805: istore 9
    //   7807: goto -7685 -> 122
    //   7810: aload_1
    //   7811: astore 15
    //   7813: iload 7
    //   7815: istore 8
    //   7817: aload_0
    //   7818: aload 17
    //   7820: aload 19
    //   7822: invokespecial 4690	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ar	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7825: aload_1
    //   7826: astore 16
    //   7828: iload 13
    //   7830: istore 14
    //   7832: iload 7
    //   7834: istore 9
    //   7836: goto -7714 -> 122
    //   7839: aload_1
    //   7840: astore 15
    //   7842: iload 7
    //   7844: istore 8
    //   7846: aload_0
    //   7847: aload 17
    //   7849: aload 19
    //   7851: invokespecial 4692	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aj	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7854: aload_1
    //   7855: astore 16
    //   7857: iload 13
    //   7859: istore 14
    //   7861: iload 7
    //   7863: istore 9
    //   7865: goto -7743 -> 122
    //   7868: aload_1
    //   7869: astore 16
    //   7871: iload 13
    //   7873: istore 14
    //   7875: iload 7
    //   7877: istore 9
    //   7879: aload_1
    //   7880: astore 15
    //   7882: iload 7
    //   7884: istore 8
    //   7886: aload 19
    //   7888: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7891: ifnull -7769 -> 122
    //   7894: aload_1
    //   7895: astore 15
    //   7897: iload 7
    //   7899: istore 8
    //   7901: aload 17
    //   7903: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7906: aload 19
    //   7908: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7911: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7914: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   7917: invokestatic 4694	com/tencent/mobileqq/utils/SharedPreUtils:d	(Landroid/content/Context;ILjava/lang/String;)V
    //   7920: aload_1
    //   7921: astore 15
    //   7923: iload 7
    //   7925: istore 8
    //   7927: aload 17
    //   7929: getstatic 4697	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	Ljava/lang/String;
    //   7932: invokevirtual 1321	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   7935: checkcast 4699	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   7938: aload 19
    //   7940: invokevirtual 4700	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7943: aload_1
    //   7944: astore 16
    //   7946: iload 13
    //   7948: istore 14
    //   7950: iload 7
    //   7952: istore 9
    //   7954: goto -7832 -> 122
    //   7957: aload_1
    //   7958: astore 15
    //   7960: iload 7
    //   7962: istore 8
    //   7964: aload_0
    //   7965: aload 17
    //   7967: aload 19
    //   7969: invokespecial 4702	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ap	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   7972: aload_1
    //   7973: astore 16
    //   7975: iload 13
    //   7977: istore 14
    //   7979: iload 7
    //   7981: istore 9
    //   7983: goto -7861 -> 122
    //   7986: aload_1
    //   7987: astore 15
    //   7989: iload 7
    //   7991: istore 8
    //   7993: aload_0
    //   7994: aload 17
    //   7996: aload 19
    //   7998: invokespecial 4704	com/tencent/mobileqq/config/splashlogo/ConfigServlet:an	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8001: aload_1
    //   8002: astore 16
    //   8004: iload 13
    //   8006: istore 14
    //   8008: iload 7
    //   8010: istore 9
    //   8012: goto -7890 -> 122
    //   8015: aload_1
    //   8016: astore 15
    //   8018: iload 7
    //   8020: istore 8
    //   8022: aload_0
    //   8023: aload 17
    //   8025: aload 19
    //   8027: invokespecial 4706	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ao	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8030: aload_1
    //   8031: astore 16
    //   8033: iload 13
    //   8035: istore 14
    //   8037: iload 7
    //   8039: istore 9
    //   8041: goto -7919 -> 122
    //   8044: aload_1
    //   8045: astore 15
    //   8047: iload 7
    //   8049: istore 8
    //   8051: aload_0
    //   8052: aload 17
    //   8054: aload 5
    //   8056: aload 19
    //   8058: invokespecial 4708	com/tencent/mobileqq/config/splashlogo/ConfigServlet:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8061: aload_1
    //   8062: astore 16
    //   8064: iload 13
    //   8066: istore 14
    //   8068: iload 7
    //   8070: istore 9
    //   8072: goto -7950 -> 122
    //   8075: aload_1
    //   8076: astore 15
    //   8078: iload 7
    //   8080: istore 8
    //   8082: aload_0
    //   8083: aload 17
    //   8085: aload 19
    //   8087: invokespecial 4710	com/tencent/mobileqq/config/splashlogo/ConfigServlet:al	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8090: aload_1
    //   8091: astore 16
    //   8093: iload 13
    //   8095: istore 14
    //   8097: iload 7
    //   8099: istore 9
    //   8101: goto -7979 -> 122
    //   8104: aload 19
    //   8106: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8109: ifnull +150 -> 8259
    //   8112: aload 19
    //   8114: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8117: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8120: ifle +139 -> 8259
    //   8123: aload 19
    //   8125: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8128: invokevirtual 2720	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   8131: invokeinterface 115 1 0
    //   8136: astore 5
    //   8138: aload_1
    //   8139: astore 16
    //   8141: iload 13
    //   8143: istore 14
    //   8145: iload 7
    //   8147: istore 9
    //   8149: aload 5
    //   8151: invokeinterface 120 1 0
    //   8156: ifeq -8034 -> 122
    //   8159: aload 5
    //   8161: invokeinterface 124 1 0
    //   8166: checkcast 126	java/lang/String
    //   8169: astore 15
    //   8171: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8174: ifeq +5608 -> 13782
    //   8177: new 78	java/lang/StringBuilder
    //   8180: dup
    //   8181: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   8184: astore 16
    //   8186: aload 16
    //   8188: ldc_w 4712
    //   8191: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8194: pop
    //   8195: aload 16
    //   8197: aload 15
    //   8199: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8202: pop
    //   8203: aload 16
    //   8205: ldc_w 474
    //   8208: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8211: pop
    //   8212: aload 16
    //   8214: aload 19
    //   8216: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8219: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8222: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8225: pop
    //   8226: ldc 92
    //   8228: iconst_2
    //   8229: aload 16
    //   8231: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8234: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8237: goto +3 -> 8240
    //   8240: aload_0
    //   8241: aload 17
    //   8243: aload 15
    //   8245: aload 19
    //   8247: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8250: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8253: invokespecial 4714	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   8256: goto -118 -> 8138
    //   8259: aload_1
    //   8260: astore 16
    //   8262: iload 13
    //   8264: istore 14
    //   8266: iload 7
    //   8268: istore 9
    //   8270: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8273: ifeq -8151 -> 122
    //   8276: new 78	java/lang/StringBuilder
    //   8279: dup
    //   8280: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   8283: astore 5
    //   8285: aload 5
    //   8287: ldc_w 4716
    //   8290: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8293: pop
    //   8294: aload 5
    //   8296: aload 19
    //   8298: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8301: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8304: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8307: pop
    //   8308: ldc 92
    //   8310: iconst_2
    //   8311: aload 5
    //   8313: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8316: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8319: aload_1
    //   8320: astore 16
    //   8322: iload 13
    //   8324: istore 14
    //   8326: iload 7
    //   8328: istore 9
    //   8330: goto -8208 -> 122
    //   8333: astore 5
    //   8335: aload_1
    //   8336: astore 15
    //   8338: iload 7
    //   8340: istore 8
    //   8342: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8345: ifeq +71 -> 8416
    //   8348: aload_1
    //   8349: astore 15
    //   8351: iload 7
    //   8353: istore 8
    //   8355: new 78	java/lang/StringBuilder
    //   8358: dup
    //   8359: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   8362: astore 16
    //   8364: aload_1
    //   8365: astore 15
    //   8367: iload 7
    //   8369: istore 8
    //   8371: aload 16
    //   8373: ldc_w 4718
    //   8376: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8379: pop
    //   8380: aload_1
    //   8381: astore 15
    //   8383: iload 7
    //   8385: istore 8
    //   8387: aload 16
    //   8389: aload 5
    //   8391: invokevirtual 531	java/lang/Exception:toString	()Ljava/lang/String;
    //   8394: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8397: pop
    //   8398: aload_1
    //   8399: astore 15
    //   8401: iload 7
    //   8403: istore 8
    //   8405: ldc 92
    //   8407: iconst_2
    //   8408: aload 16
    //   8410: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8413: invokestatic 533	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8416: aload_1
    //   8417: astore 15
    //   8419: iload 7
    //   8421: istore 8
    //   8423: aload 5
    //   8425: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   8428: aload_1
    //   8429: astore 16
    //   8431: iload 13
    //   8433: istore 14
    //   8435: iload 7
    //   8437: istore 9
    //   8439: goto -8317 -> 122
    //   8442: aload_1
    //   8443: astore 15
    //   8445: iload 7
    //   8447: istore 8
    //   8449: aload_0
    //   8450: aload 17
    //   8452: aload 19
    //   8454: invokespecial 4720	com/tencent/mobileqq/config/splashlogo/ConfigServlet:ai	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8457: aload_1
    //   8458: astore 16
    //   8460: iload 13
    //   8462: istore 14
    //   8464: iload 7
    //   8466: istore 9
    //   8468: goto -8346 -> 122
    //   8471: aload_1
    //   8472: astore 15
    //   8474: iload 7
    //   8476: istore 8
    //   8478: aload 19
    //   8480: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8483: ifnull +220 -> 8703
    //   8486: aload_1
    //   8487: astore 15
    //   8489: iload 7
    //   8491: istore 8
    //   8493: aload 19
    //   8495: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8498: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8501: ifle +202 -> 8703
    //   8504: aload_1
    //   8505: astore 15
    //   8507: iload 7
    //   8509: istore 8
    //   8511: aload 19
    //   8513: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8516: iconst_0
    //   8517: invokevirtual 467	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8520: checkcast 126	java/lang/String
    //   8523: astore 5
    //   8525: aload_1
    //   8526: astore 15
    //   8528: iload 7
    //   8530: istore 8
    //   8532: aload 19
    //   8534: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8537: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8540: istore 9
    //   8542: aload_1
    //   8543: astore 15
    //   8545: iload 7
    //   8547: istore 8
    //   8549: aload 17
    //   8551: invokevirtual 4724	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   8554: aload 17
    //   8556: aload 5
    //   8558: iload 9
    //   8560: invokevirtual 4727	com/tencent/av/gaudio/AVNotifyCenter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   8563: aload_1
    //   8564: astore 16
    //   8566: iload 13
    //   8568: istore 14
    //   8570: iload 7
    //   8572: istore 9
    //   8574: aload_1
    //   8575: astore 15
    //   8577: iload 7
    //   8579: istore 8
    //   8581: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8584: ifeq -8462 -> 122
    //   8587: aload_1
    //   8588: astore 15
    //   8590: iload 7
    //   8592: istore 8
    //   8594: new 78	java/lang/StringBuilder
    //   8597: dup
    //   8598: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   8601: astore 16
    //   8603: aload_1
    //   8604: astore 15
    //   8606: iload 7
    //   8608: istore 8
    //   8610: aload 16
    //   8612: ldc_w 4729
    //   8615: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8618: pop
    //   8619: aload_1
    //   8620: astore 15
    //   8622: iload 7
    //   8624: istore 8
    //   8626: aload 16
    //   8628: aload 5
    //   8630: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8633: pop
    //   8634: aload_1
    //   8635: astore 15
    //   8637: iload 7
    //   8639: istore 8
    //   8641: aload 16
    //   8643: ldc_w 474
    //   8646: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8649: pop
    //   8650: aload_1
    //   8651: astore 15
    //   8653: iload 7
    //   8655: istore 8
    //   8657: aload 16
    //   8659: aload 19
    //   8661: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8664: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8667: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8670: pop
    //   8671: aload_1
    //   8672: astore 15
    //   8674: iload 7
    //   8676: istore 8
    //   8678: ldc 92
    //   8680: iconst_2
    //   8681: aload 16
    //   8683: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8686: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8689: aload_1
    //   8690: astore 16
    //   8692: iload 13
    //   8694: istore 14
    //   8696: iload 7
    //   8698: istore 9
    //   8700: goto -8578 -> 122
    //   8703: aload_1
    //   8704: astore 16
    //   8706: iload 13
    //   8708: istore 14
    //   8710: iload 7
    //   8712: istore 9
    //   8714: aload_1
    //   8715: astore 15
    //   8717: iload 7
    //   8719: istore 8
    //   8721: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8724: ifeq -8602 -> 122
    //   8727: aload_1
    //   8728: astore 15
    //   8730: iload 7
    //   8732: istore 8
    //   8734: new 78	java/lang/StringBuilder
    //   8737: dup
    //   8738: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   8741: astore 5
    //   8743: aload_1
    //   8744: astore 15
    //   8746: iload 7
    //   8748: istore 8
    //   8750: aload 5
    //   8752: ldc_w 4731
    //   8755: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8758: pop
    //   8759: aload_1
    //   8760: astore 15
    //   8762: iload 7
    //   8764: istore 8
    //   8766: aload 5
    //   8768: aload 19
    //   8770: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8773: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8776: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8779: pop
    //   8780: aload_1
    //   8781: astore 15
    //   8783: iload 7
    //   8785: istore 8
    //   8787: ldc 92
    //   8789: iconst_2
    //   8790: aload 5
    //   8792: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8795: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8798: aload_1
    //   8799: astore 16
    //   8801: iload 13
    //   8803: istore 14
    //   8805: iload 7
    //   8807: istore 9
    //   8809: goto -8687 -> 122
    //   8812: aload_1
    //   8813: astore 15
    //   8815: iload 7
    //   8817: istore 8
    //   8819: aload_0
    //   8820: aload 17
    //   8822: aload 5
    //   8824: aload 19
    //   8826: invokespecial 4733	com/tencent/mobileqq/config/splashlogo/ConfigServlet:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8829: aload_1
    //   8830: astore 16
    //   8832: iload 13
    //   8834: istore 14
    //   8836: iload 7
    //   8838: istore 9
    //   8840: goto -8718 -> 122
    //   8843: aload_1
    //   8844: astore 15
    //   8846: iload 7
    //   8848: istore 8
    //   8850: aload 19
    //   8852: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8855: ifnull +4930 -> 13785
    //   8858: aload_1
    //   8859: astore 15
    //   8861: iload 7
    //   8863: istore 8
    //   8865: aload 19
    //   8867: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8870: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8873: ifle +4912 -> 13785
    //   8876: aload_1
    //   8877: astore 15
    //   8879: iload 7
    //   8881: istore 8
    //   8883: aload 19
    //   8885: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8888: invokevirtual 2720	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   8891: astore 5
    //   8893: goto +3 -> 8896
    //   8896: aload 5
    //   8898: ifnull +352 -> 9250
    //   8901: aload_1
    //   8902: astore 15
    //   8904: iload 7
    //   8906: istore 8
    //   8908: aload 5
    //   8910: invokeinterface 111 1 0
    //   8915: ifle +335 -> 9250
    //   8918: aload_1
    //   8919: astore 15
    //   8921: iload 7
    //   8923: istore 8
    //   8925: aload 5
    //   8927: iconst_0
    //   8928: invokeinterface 191 2 0
    //   8933: checkcast 126	java/lang/String
    //   8936: astore 16
    //   8938: aload_1
    //   8939: astore 15
    //   8941: iload 7
    //   8943: istore 8
    //   8945: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8948: ifeq +105 -> 9053
    //   8951: aload_1
    //   8952: astore 15
    //   8954: iload 7
    //   8956: istore 8
    //   8958: new 78	java/lang/StringBuilder
    //   8961: dup
    //   8962: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   8965: astore 20
    //   8967: aload_1
    //   8968: astore 15
    //   8970: iload 7
    //   8972: istore 8
    //   8974: aload 20
    //   8976: ldc_w 4735
    //   8979: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8982: pop
    //   8983: aload_1
    //   8984: astore 15
    //   8986: iload 7
    //   8988: istore 8
    //   8990: aload 20
    //   8992: aload 16
    //   8994: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8997: pop
    //   8998: aload_1
    //   8999: astore 15
    //   9001: iload 7
    //   9003: istore 8
    //   9005: aload 20
    //   9007: ldc_w 474
    //   9010: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9013: pop
    //   9014: aload_1
    //   9015: astore 15
    //   9017: iload 7
    //   9019: istore 8
    //   9021: aload 20
    //   9023: aload 19
    //   9025: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9028: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9031: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9034: pop
    //   9035: aload_1
    //   9036: astore 15
    //   9038: iload 7
    //   9040: istore 8
    //   9042: ldc 92
    //   9044: iconst_2
    //   9045: aload 20
    //   9047: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9050: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9053: aload_1
    //   9054: astore 15
    //   9056: iload 7
    //   9058: istore 8
    //   9060: aload 16
    //   9062: invokestatic 4739	com/tencent/biz/bmqq/util/BmqqSegmentUtil:d	(Ljava/lang/String;)V
    //   9065: aload_1
    //   9066: astore 15
    //   9068: iload 7
    //   9070: istore 8
    //   9072: aload 5
    //   9074: invokeinterface 115 1 0
    //   9079: astore 5
    //   9081: aload_1
    //   9082: astore 15
    //   9084: iload 7
    //   9086: istore 8
    //   9088: aload 5
    //   9090: invokeinterface 120 1 0
    //   9095: ifeq +4696 -> 13791
    //   9098: aload_1
    //   9099: astore 15
    //   9101: iload 7
    //   9103: istore 8
    //   9105: aload 5
    //   9107: invokeinterface 124 1 0
    //   9112: checkcast 126	java/lang/String
    //   9115: astore 16
    //   9117: aload_1
    //   9118: astore 15
    //   9120: iload 7
    //   9122: istore 8
    //   9124: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9127: ifeq +105 -> 9232
    //   9130: aload_1
    //   9131: astore 15
    //   9133: iload 7
    //   9135: istore 8
    //   9137: new 78	java/lang/StringBuilder
    //   9140: dup
    //   9141: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   9144: astore 20
    //   9146: aload_1
    //   9147: astore 15
    //   9149: iload 7
    //   9151: istore 8
    //   9153: aload 20
    //   9155: ldc_w 4735
    //   9158: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9161: pop
    //   9162: aload_1
    //   9163: astore 15
    //   9165: iload 7
    //   9167: istore 8
    //   9169: aload 20
    //   9171: aload 16
    //   9173: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9176: pop
    //   9177: aload_1
    //   9178: astore 15
    //   9180: iload 7
    //   9182: istore 8
    //   9184: aload 20
    //   9186: ldc_w 474
    //   9189: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9192: pop
    //   9193: aload_1
    //   9194: astore 15
    //   9196: iload 7
    //   9198: istore 8
    //   9200: aload 20
    //   9202: aload 19
    //   9204: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9207: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9210: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9213: pop
    //   9214: aload_1
    //   9215: astore 15
    //   9217: iload 7
    //   9219: istore 8
    //   9221: ldc 92
    //   9223: iconst_2
    //   9224: aload 20
    //   9226: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9229: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9232: aload_1
    //   9233: astore 15
    //   9235: iload 7
    //   9237: istore 8
    //   9239: aload 16
    //   9241: invokestatic 4743	com/tencent/mobileqq/activity/aio/tips/C2BTipsBar:b	(Ljava/lang/String;)Z
    //   9244: ifeq -163 -> 9081
    //   9247: goto +4544 -> 13791
    //   9250: aload_1
    //   9251: astore 15
    //   9253: iload 7
    //   9255: istore 8
    //   9257: aconst_null
    //   9258: invokestatic 4739	com/tencent/biz/bmqq/util/BmqqSegmentUtil:d	(Ljava/lang/String;)V
    //   9261: aload_1
    //   9262: astore 15
    //   9264: iload 7
    //   9266: istore 8
    //   9268: invokestatic 4744	com/tencent/mobileqq/activity/aio/tips/C2BTipsBar:d	()V
    //   9271: aload_1
    //   9272: astore 15
    //   9274: iload 7
    //   9276: istore 8
    //   9278: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9281: ifeq +74 -> 9355
    //   9284: aload_1
    //   9285: astore 15
    //   9287: iload 7
    //   9289: istore 8
    //   9291: new 78	java/lang/StringBuilder
    //   9294: dup
    //   9295: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   9298: astore 5
    //   9300: aload_1
    //   9301: astore 15
    //   9303: iload 7
    //   9305: istore 8
    //   9307: aload 5
    //   9309: ldc_w 4746
    //   9312: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9315: pop
    //   9316: aload_1
    //   9317: astore 15
    //   9319: iload 7
    //   9321: istore 8
    //   9323: aload 5
    //   9325: aload 19
    //   9327: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9330: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9333: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9336: pop
    //   9337: aload_1
    //   9338: astore 15
    //   9340: iload 7
    //   9342: istore 8
    //   9344: ldc 92
    //   9346: iconst_2
    //   9347: aload 5
    //   9349: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9352: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9355: aload_1
    //   9356: astore 15
    //   9358: iload 7
    //   9360: istore 8
    //   9362: aload 19
    //   9364: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9367: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9370: istore 9
    //   9372: aload_1
    //   9373: astore 15
    //   9375: iload 7
    //   9377: istore 8
    //   9379: aload 17
    //   9381: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9384: iload 9
    //   9386: invokestatic 4748	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;I)V
    //   9389: aload_1
    //   9390: astore 16
    //   9392: iload 13
    //   9394: istore 14
    //   9396: iload 7
    //   9398: istore 9
    //   9400: goto -9278 -> 122
    //   9403: aload_1
    //   9404: astore 15
    //   9406: iload 7
    //   9408: istore 8
    //   9410: aload_0
    //   9411: aload 17
    //   9413: aload 19
    //   9415: invokespecial 4750	com/tencent/mobileqq/config/splashlogo/ConfigServlet:at	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9418: aload_1
    //   9419: astore 16
    //   9421: iload 13
    //   9423: istore 14
    //   9425: iload 7
    //   9427: istore 9
    //   9429: goto -9307 -> 122
    //   9432: aload_1
    //   9433: astore 15
    //   9435: iload 7
    //   9437: istore 8
    //   9439: aload_0
    //   9440: aload 17
    //   9442: aload 19
    //   9444: invokespecial 4752	com/tencent/mobileqq/config/splashlogo/ConfigServlet:V	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9447: aload_1
    //   9448: astore 16
    //   9450: iload 13
    //   9452: istore 14
    //   9454: iload 7
    //   9456: istore 9
    //   9458: goto -9336 -> 122
    //   9461: aload_1
    //   9462: astore 15
    //   9464: iload 7
    //   9466: istore 8
    //   9468: aload_0
    //   9469: aload 17
    //   9471: aload 19
    //   9473: invokespecial 4754	com/tencent/mobileqq/config/splashlogo/ConfigServlet:aq	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9476: aload_1
    //   9477: astore 16
    //   9479: iload 13
    //   9481: istore 14
    //   9483: iload 7
    //   9485: istore 9
    //   9487: goto -9365 -> 122
    //   9490: aload_1
    //   9491: astore 15
    //   9493: iload 7
    //   9495: istore 8
    //   9497: aload 17
    //   9499: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9502: aload 17
    //   9504: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   9507: invokestatic 1203	com/tencent/mobileqq/utils/SharedPreUtils:m	(Landroid/content/Context;Ljava/lang/String;)I
    //   9510: istore 12
    //   9512: aload 19
    //   9514: ifnull +4280 -> 13794
    //   9517: aload_1
    //   9518: astore 15
    //   9520: iload 7
    //   9522: istore 8
    //   9524: aload 19
    //   9526: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9529: ifnull +4265 -> 13794
    //   9532: aload_1
    //   9533: astore 15
    //   9535: iload 7
    //   9537: istore 8
    //   9539: aload 19
    //   9541: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9544: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9547: istore 10
    //   9549: goto +3 -> 9552
    //   9552: aload_1
    //   9553: astore 15
    //   9555: iload 7
    //   9557: istore 8
    //   9559: aload 19
    //   9561: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9564: ifnull +340 -> 9904
    //   9567: aload_1
    //   9568: astore 15
    //   9570: iload 7
    //   9572: istore 8
    //   9574: aload 19
    //   9576: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9579: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   9582: ifle +322 -> 9904
    //   9585: aload_1
    //   9586: astore 15
    //   9588: iload 7
    //   9590: istore 8
    //   9592: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9595: ifeq +177 -> 9772
    //   9598: aload_1
    //   9599: astore 15
    //   9601: iload 7
    //   9603: istore 8
    //   9605: new 78	java/lang/StringBuilder
    //   9608: dup
    //   9609: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   9612: astore 5
    //   9614: aload_1
    //   9615: astore 15
    //   9617: iload 7
    //   9619: istore 8
    //   9621: aload 5
    //   9623: ldc_w 4756
    //   9626: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9629: pop
    //   9630: aload_1
    //   9631: astore 15
    //   9633: iload 7
    //   9635: istore 8
    //   9637: aload 5
    //   9639: iload 10
    //   9641: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9644: pop
    //   9645: aload_1
    //   9646: astore 15
    //   9648: iload 7
    //   9650: istore 8
    //   9652: aload 5
    //   9654: ldc_w 4758
    //   9657: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9660: pop
    //   9661: aload_1
    //   9662: astore 15
    //   9664: iload 7
    //   9666: istore 8
    //   9668: aload 5
    //   9670: iload 12
    //   9672: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9675: pop
    //   9676: aload_1
    //   9677: astore 15
    //   9679: iload 7
    //   9681: istore 8
    //   9683: aload 5
    //   9685: ldc_w 4760
    //   9688: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9691: pop
    //   9692: aload_1
    //   9693: astore 15
    //   9695: iload 7
    //   9697: istore 8
    //   9699: aload 5
    //   9701: aload 19
    //   9703: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9706: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   9709: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9712: pop
    //   9713: aload_1
    //   9714: astore 15
    //   9716: iload 7
    //   9718: istore 8
    //   9720: aload 5
    //   9722: ldc_w 4674
    //   9725: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9728: pop
    //   9729: aload_1
    //   9730: astore 15
    //   9732: iload 7
    //   9734: istore 8
    //   9736: aload 5
    //   9738: aload 19
    //   9740: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9743: iconst_0
    //   9744: invokevirtual 467	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   9747: checkcast 126	java/lang/String
    //   9750: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9753: pop
    //   9754: aload_1
    //   9755: astore 15
    //   9757: iload 7
    //   9759: istore 8
    //   9761: ldc 92
    //   9763: iconst_2
    //   9764: aload 5
    //   9766: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9769: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9772: aload_1
    //   9773: astore 15
    //   9775: iload 7
    //   9777: istore 8
    //   9779: new 242	java/util/HashSet
    //   9782: dup
    //   9783: invokespecial 243	java/util/HashSet:<init>	()V
    //   9786: astore 5
    //   9788: iconst_0
    //   9789: istore 9
    //   9791: aload_1
    //   9792: astore 15
    //   9794: iload 7
    //   9796: istore 8
    //   9798: iload 9
    //   9800: aload 19
    //   9802: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9805: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   9808: if_icmpge +37 -> 9845
    //   9811: aload_1
    //   9812: astore 15
    //   9814: iload 7
    //   9816: istore 8
    //   9818: aload 5
    //   9820: aload 19
    //   9822: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9825: iload 9
    //   9827: invokevirtual 467	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   9830: invokeinterface 4761 2 0
    //   9835: pop
    //   9836: iload 9
    //   9838: iconst_1
    //   9839: iadd
    //   9840: istore 9
    //   9842: goto -51 -> 9791
    //   9845: aload_1
    //   9846: astore 15
    //   9848: iload 7
    //   9850: istore 8
    //   9852: aload 17
    //   9854: getstatic 4764	com/tencent/mobileqq/app/QQManagerFactory:SEND_BLESS_CONFIG_MANAGER	I
    //   9857: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9860: checkcast 4766	com/tencent/mobileqq/activity/bless/BlessManager
    //   9863: aload 5
    //   9865: invokevirtual 4769	com/tencent/mobileqq/activity/bless/BlessManager:a	(Ljava/util/Set;)V
    //   9868: aload_1
    //   9869: astore 15
    //   9871: iload 7
    //   9873: istore 8
    //   9875: aload 17
    //   9877: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9880: aload 17
    //   9882: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   9885: iload 10
    //   9887: invokestatic 4770	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9890: aload_1
    //   9891: astore 16
    //   9893: iload 13
    //   9895: istore 14
    //   9897: iload 7
    //   9899: istore 9
    //   9901: goto -9779 -> 122
    //   9904: aload_1
    //   9905: astore 15
    //   9907: iload 7
    //   9909: istore 8
    //   9911: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9914: ifeq +99 -> 10013
    //   9917: aload_1
    //   9918: astore 15
    //   9920: iload 7
    //   9922: istore 8
    //   9924: new 78	java/lang/StringBuilder
    //   9927: dup
    //   9928: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   9931: astore 5
    //   9933: aload_1
    //   9934: astore 15
    //   9936: iload 7
    //   9938: istore 8
    //   9940: aload 5
    //   9942: ldc_w 4772
    //   9945: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9948: pop
    //   9949: aload_1
    //   9950: astore 15
    //   9952: iload 7
    //   9954: istore 8
    //   9956: aload 5
    //   9958: iload 10
    //   9960: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9963: pop
    //   9964: aload_1
    //   9965: astore 15
    //   9967: iload 7
    //   9969: istore 8
    //   9971: aload 5
    //   9973: ldc_w 4758
    //   9976: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9979: pop
    //   9980: aload_1
    //   9981: astore 15
    //   9983: iload 7
    //   9985: istore 8
    //   9987: aload 5
    //   9989: iload 12
    //   9991: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9994: pop
    //   9995: aload_1
    //   9996: astore 15
    //   9998: iload 7
    //   10000: istore 8
    //   10002: ldc 92
    //   10004: iconst_2
    //   10005: aload 5
    //   10007: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10010: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10013: aload_1
    //   10014: astore 16
    //   10016: iload 13
    //   10018: istore 14
    //   10020: iload 7
    //   10022: istore 9
    //   10024: iload 12
    //   10026: iload 10
    //   10028: if_icmpeq -9906 -> 122
    //   10031: aload_1
    //   10032: astore 15
    //   10034: iload 7
    //   10036: istore 8
    //   10038: aload 17
    //   10040: getstatic 4764	com/tencent/mobileqq/app/QQManagerFactory:SEND_BLESS_CONFIG_MANAGER	I
    //   10043: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10046: checkcast 4766	com/tencent/mobileqq/activity/bless/BlessManager
    //   10049: invokevirtual 4773	com/tencent/mobileqq/activity/bless/BlessManager:c	()V
    //   10052: aload_1
    //   10053: astore 15
    //   10055: iload 7
    //   10057: istore 8
    //   10059: aload 17
    //   10061: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   10064: aload 17
    //   10066: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   10069: iload 10
    //   10071: invokestatic 4770	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   10074: aload_1
    //   10075: astore 16
    //   10077: iload 13
    //   10079: istore 14
    //   10081: iload 7
    //   10083: istore 9
    //   10085: goto -9963 -> 122
    //   10088: aload_1
    //   10089: astore 15
    //   10091: iload 7
    //   10093: istore 8
    //   10095: aload 19
    //   10097: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10100: ifnull +260 -> 10360
    //   10103: aload_1
    //   10104: astore 15
    //   10106: iload 7
    //   10108: istore 8
    //   10110: aload 19
    //   10112: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10115: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   10118: ifle +242 -> 10360
    //   10121: aload_1
    //   10122: astore 15
    //   10124: iload 7
    //   10126: istore 8
    //   10128: aload 17
    //   10130: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   10133: aload 19
    //   10135: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10138: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10141: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   10144: invokestatic 4775	com/tencent/mobileqq/utils/SharedPreUtils:c	(Landroid/content/Context;ILjava/lang/String;)V
    //   10147: iconst_0
    //   10148: istore 10
    //   10150: aload_1
    //   10151: astore 16
    //   10153: iload 13
    //   10155: istore 14
    //   10157: iload 7
    //   10159: istore 9
    //   10161: aload_1
    //   10162: astore 15
    //   10164: iload 7
    //   10166: istore 8
    //   10168: iload 10
    //   10170: aload 19
    //   10172: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10175: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   10178: if_icmpge -10056 -> 122
    //   10181: aload_1
    //   10182: astore 15
    //   10184: iload 7
    //   10186: istore 8
    //   10188: aload 19
    //   10190: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10193: iload 10
    //   10195: invokevirtual 467	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   10198: checkcast 126	java/lang/String
    //   10201: astore 5
    //   10203: aload_1
    //   10204: astore 15
    //   10206: iload 7
    //   10208: istore 8
    //   10210: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10213: ifeq +105 -> 10318
    //   10216: aload_1
    //   10217: astore 15
    //   10219: iload 7
    //   10221: istore 8
    //   10223: new 78	java/lang/StringBuilder
    //   10226: dup
    //   10227: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   10230: astore 16
    //   10232: aload_1
    //   10233: astore 15
    //   10235: iload 7
    //   10237: istore 8
    //   10239: aload 16
    //   10241: ldc_w 4777
    //   10244: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10247: pop
    //   10248: aload_1
    //   10249: astore 15
    //   10251: iload 7
    //   10253: istore 8
    //   10255: aload 16
    //   10257: aload 5
    //   10259: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10262: pop
    //   10263: aload_1
    //   10264: astore 15
    //   10266: iload 7
    //   10268: istore 8
    //   10270: aload 16
    //   10272: ldc_w 474
    //   10275: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10278: pop
    //   10279: aload_1
    //   10280: astore 15
    //   10282: iload 7
    //   10284: istore 8
    //   10286: aload 16
    //   10288: aload 19
    //   10290: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10293: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10296: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10299: pop
    //   10300: aload_1
    //   10301: astore 15
    //   10303: iload 7
    //   10305: istore 8
    //   10307: ldc 92
    //   10309: iconst_2
    //   10310: aload 16
    //   10312: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10315: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10318: aload_1
    //   10319: astore 15
    //   10321: iload 7
    //   10323: istore 8
    //   10325: aload 5
    //   10327: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10330: ifne +3471 -> 13801
    //   10333: aload_1
    //   10334: astore 15
    //   10336: iload 7
    //   10338: istore 8
    //   10340: aload 17
    //   10342: getstatic 4697	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	Ljava/lang/String;
    //   10345: invokevirtual 1321	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   10348: checkcast 4699	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   10351: aload 5
    //   10353: iconst_0
    //   10354: invokevirtual 4779	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(Ljava/lang/String;Z)V
    //   10357: goto +3444 -> 13801
    //   10360: aload_1
    //   10361: astore 16
    //   10363: iload 13
    //   10365: istore 14
    //   10367: iload 7
    //   10369: istore 9
    //   10371: aload_1
    //   10372: astore 15
    //   10374: iload 7
    //   10376: istore 8
    //   10378: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10381: ifeq -10259 -> 122
    //   10384: aload_1
    //   10385: astore 15
    //   10387: iload 7
    //   10389: istore 8
    //   10391: new 78	java/lang/StringBuilder
    //   10394: dup
    //   10395: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   10398: astore 5
    //   10400: aload_1
    //   10401: astore 15
    //   10403: iload 7
    //   10405: istore 8
    //   10407: aload 5
    //   10409: ldc_w 4781
    //   10412: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10415: pop
    //   10416: aload_1
    //   10417: astore 15
    //   10419: iload 7
    //   10421: istore 8
    //   10423: aload 5
    //   10425: aload 19
    //   10427: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10430: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10433: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10436: pop
    //   10437: aload_1
    //   10438: astore 15
    //   10440: iload 7
    //   10442: istore 8
    //   10444: ldc 92
    //   10446: iconst_2
    //   10447: aload 5
    //   10449: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10452: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10455: aload_1
    //   10456: astore 16
    //   10458: iload 13
    //   10460: istore 14
    //   10462: iload 7
    //   10464: istore 9
    //   10466: goto -10344 -> 122
    //   10469: aload_1
    //   10470: astore 15
    //   10472: iload 7
    //   10474: istore 8
    //   10476: aload_0
    //   10477: aload 17
    //   10479: aload 19
    //   10481: invokespecial 4783	com/tencent/mobileqq/config/splashlogo/ConfigServlet:am	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10484: aload_1
    //   10485: astore 16
    //   10487: iload 13
    //   10489: istore 14
    //   10491: iload 7
    //   10493: istore 9
    //   10495: goto -10373 -> 122
    //   10498: aload_1
    //   10499: astore 15
    //   10501: iload 7
    //   10503: istore 8
    //   10505: invokestatic 63	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10508: aload 17
    //   10510: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   10513: invokestatic 1867	cooperation/pluginbridge/BridgeHelper:a	(Landroid/content/Context;Ljava/lang/String;)Lcooperation/pluginbridge/BridgeHelper;
    //   10516: aload 19
    //   10518: invokevirtual 4784	cooperation/pluginbridge/BridgeHelper:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10521: aload_1
    //   10522: astore 16
    //   10524: iload 13
    //   10526: istore 14
    //   10528: iload 7
    //   10530: istore 9
    //   10532: goto -10410 -> 122
    //   10535: aload_1
    //   10536: astore 15
    //   10538: iload 7
    //   10540: istore 8
    //   10542: aload 17
    //   10544: getstatic 1873	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_BANNER_MANAGER	I
    //   10547: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10550: checkcast 1875	com/tencent/mobileqq/config/struct/NearbyBannerManager
    //   10553: astore 16
    //   10555: aload_1
    //   10556: astore 15
    //   10558: iload 7
    //   10560: istore 8
    //   10562: aload 16
    //   10564: invokevirtual 4787	com/tencent/mobileqq/config/struct/NearbyBannerManager:b	()Ljava/util/Set;
    //   10567: astore 21
    //   10569: aload_1
    //   10570: astore 15
    //   10572: iload 7
    //   10574: istore 8
    //   10576: new 2188	com/tencent/mobileqq/config/struct/PicAndAdConf
    //   10579: dup
    //   10580: bipush 21
    //   10582: iconst_2
    //   10583: invokespecial 4790	com/tencent/mobileqq/config/struct/PicAndAdConf:<init>	(SB)V
    //   10586: astore 20
    //   10588: aload_1
    //   10589: astore 15
    //   10591: iload 7
    //   10593: istore 8
    //   10595: aload 19
    //   10597: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10600: ifnull +239 -> 10839
    //   10603: aload_1
    //   10604: astore 15
    //   10606: iload 7
    //   10608: istore 8
    //   10610: aload 19
    //   10612: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10615: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   10618: ifle +221 -> 10839
    //   10621: aload_1
    //   10622: astore 15
    //   10624: iload 7
    //   10626: istore 8
    //   10628: aload 19
    //   10630: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10633: invokevirtual 2720	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   10636: invokeinterface 115 1 0
    //   10641: astore 5
    //   10643: aload_1
    //   10644: astore 15
    //   10646: iload 7
    //   10648: istore 8
    //   10650: aload 5
    //   10652: invokeinterface 120 1 0
    //   10657: ifeq +266 -> 10923
    //   10660: aload_1
    //   10661: astore 15
    //   10663: iload 7
    //   10665: istore 8
    //   10667: aload 5
    //   10669: invokeinterface 124 1 0
    //   10674: checkcast 126	java/lang/String
    //   10677: astore 22
    //   10679: aload_1
    //   10680: astore 15
    //   10682: iload 7
    //   10684: istore 8
    //   10686: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10689: ifeq +3121 -> 13810
    //   10692: aload_1
    //   10693: astore 15
    //   10695: iload 7
    //   10697: istore 8
    //   10699: new 78	java/lang/StringBuilder
    //   10702: dup
    //   10703: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   10706: astore 23
    //   10708: aload_1
    //   10709: astore 15
    //   10711: iload 7
    //   10713: istore 8
    //   10715: aload 23
    //   10717: ldc_w 4792
    //   10720: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10723: pop
    //   10724: aload_1
    //   10725: astore 15
    //   10727: iload 7
    //   10729: istore 8
    //   10731: aload 23
    //   10733: aload 22
    //   10735: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10738: pop
    //   10739: aload_1
    //   10740: astore 15
    //   10742: iload 7
    //   10744: istore 8
    //   10746: aload 23
    //   10748: ldc_w 474
    //   10751: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10754: pop
    //   10755: aload_1
    //   10756: astore 15
    //   10758: iload 7
    //   10760: istore 8
    //   10762: aload 23
    //   10764: aload 19
    //   10766: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10769: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10772: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10775: pop
    //   10776: aload_1
    //   10777: astore 15
    //   10779: iload 7
    //   10781: istore 8
    //   10783: ldc 92
    //   10785: iconst_2
    //   10786: aload 23
    //   10788: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10791: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10794: goto +3 -> 10797
    //   10797: aload_1
    //   10798: astore 15
    //   10800: iload 7
    //   10802: istore 8
    //   10804: aload 20
    //   10806: aload 22
    //   10808: aload 21
    //   10810: invokestatic 4794	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/config/struct/PicAndAdConf;Ljava/lang/String;Ljava/util/Set;)Z
    //   10813: pop
    //   10814: aload_1
    //   10815: astore 15
    //   10817: iload 7
    //   10819: istore 8
    //   10821: aload 16
    //   10823: aload 20
    //   10825: aload 19
    //   10827: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10830: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10833: invokevirtual 4797	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(Lcom/tencent/mobileqq/config/struct/PicAndAdConf;I)V
    //   10836: goto -193 -> 10643
    //   10839: aload_1
    //   10840: astore 15
    //   10842: iload 7
    //   10844: istore 8
    //   10846: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10849: ifeq +74 -> 10923
    //   10852: aload_1
    //   10853: astore 15
    //   10855: iload 7
    //   10857: istore 8
    //   10859: new 78	java/lang/StringBuilder
    //   10862: dup
    //   10863: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   10866: astore 5
    //   10868: aload_1
    //   10869: astore 15
    //   10871: iload 7
    //   10873: istore 8
    //   10875: aload 5
    //   10877: ldc_w 4799
    //   10880: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10883: pop
    //   10884: aload_1
    //   10885: astore 15
    //   10887: iload 7
    //   10889: istore 8
    //   10891: aload 5
    //   10893: aload 19
    //   10895: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10898: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10901: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10904: pop
    //   10905: aload_1
    //   10906: astore 15
    //   10908: iload 7
    //   10910: istore 8
    //   10912: ldc 92
    //   10914: iconst_2
    //   10915: aload 5
    //   10917: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10920: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10923: aload_1
    //   10924: astore 15
    //   10926: iload 7
    //   10928: istore 8
    //   10930: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10933: ifeq +182 -> 11115
    //   10936: aload_1
    //   10937: astore 15
    //   10939: iload 7
    //   10941: istore 8
    //   10943: new 78	java/lang/StringBuilder
    //   10946: dup
    //   10947: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   10950: astore 5
    //   10952: aload_1
    //   10953: astore 15
    //   10955: iload 7
    //   10957: istore 8
    //   10959: aload 5
    //   10961: ldc_w 4801
    //   10964: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10967: pop
    //   10968: aload_1
    //   10969: astore 15
    //   10971: iload 7
    //   10973: istore 8
    //   10975: aload 19
    //   10977: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10980: ifnonnull +9 -> 10989
    //   10983: iconst_0
    //   10984: istore 9
    //   10986: goto +25 -> 11011
    //   10989: aload_1
    //   10990: astore 15
    //   10992: iload 7
    //   10994: istore 8
    //   10996: aload 19
    //   10998: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   11001: invokevirtual 2720	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   11004: invokeinterface 111 1 0
    //   11009: istore 9
    //   11011: aload_1
    //   11012: astore 15
    //   11014: iload 7
    //   11016: istore 8
    //   11018: aload 5
    //   11020: iload 9
    //   11022: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11025: pop
    //   11026: aload_1
    //   11027: astore 15
    //   11029: iload 7
    //   11031: istore 8
    //   11033: aload 5
    //   11035: ldc_w 4803
    //   11038: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11041: pop
    //   11042: aload_1
    //   11043: astore 15
    //   11045: iload 7
    //   11047: istore 8
    //   11049: aload 5
    //   11051: aload 20
    //   11053: invokevirtual 4804	com/tencent/mobileqq/config/struct/PicAndAdConf:b	()I
    //   11056: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11059: pop
    //   11060: aload_1
    //   11061: astore 15
    //   11063: iload 7
    //   11065: istore 8
    //   11067: aload 5
    //   11069: ldc_w 4806
    //   11072: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11075: pop
    //   11076: aload_1
    //   11077: astore 15
    //   11079: iload 7
    //   11081: istore 8
    //   11083: aload 5
    //   11085: aload 19
    //   11087: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11090: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11093: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11096: pop
    //   11097: aload_1
    //   11098: astore 15
    //   11100: iload 7
    //   11102: istore 8
    //   11104: ldc 92
    //   11106: iconst_2
    //   11107: aload 5
    //   11109: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11112: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   11115: aload_1
    //   11116: astore 15
    //   11118: iload 7
    //   11120: istore 8
    //   11122: aload 16
    //   11124: aload 19
    //   11126: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11129: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11132: invokevirtual 4807	com/tencent/mobileqq/config/struct/NearbyBannerManager:a	(I)V
    //   11135: aload_1
    //   11136: astore 16
    //   11138: iload 13
    //   11140: istore 14
    //   11142: iload 7
    //   11144: istore 9
    //   11146: goto -11024 -> 122
    //   11149: aload_1
    //   11150: astore 15
    //   11152: iload 7
    //   11154: istore 8
    //   11156: ldc_w 1878
    //   11159: invokestatic 498	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   11162: checkcast 1878	com/tencent/mobileqq/dpc/api/IDPCApi
    //   11165: aload_2
    //   11166: ldc 8
    //   11168: invokeinterface 4811 3 0
    //   11173: pop
    //   11174: aload_1
    //   11175: astore 16
    //   11177: iload 13
    //   11179: istore 14
    //   11181: iload 7
    //   11183: istore 9
    //   11185: goto -11063 -> 122
    //   11188: aload_1
    //   11189: astore 15
    //   11191: iload 7
    //   11193: istore 8
    //   11195: aload 19
    //   11197: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   11200: ifnull +296 -> 11496
    //   11203: aload_1
    //   11204: astore 15
    //   11206: iload 7
    //   11208: istore 8
    //   11210: aload 19
    //   11212: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   11215: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   11218: ifle +278 -> 11496
    //   11221: aload_1
    //   11222: astore 15
    //   11224: iload 7
    //   11226: istore 8
    //   11228: new 1026	java/util/ArrayList
    //   11231: dup
    //   11232: invokespecial 1027	java/util/ArrayList:<init>	()V
    //   11235: astore 5
    //   11237: iconst_0
    //   11238: istore 9
    //   11240: aload_1
    //   11241: astore 15
    //   11243: iload 7
    //   11245: istore 8
    //   11247: iload 9
    //   11249: aload 19
    //   11251: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   11254: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   11257: if_icmpge +178 -> 11435
    //   11260: aload_1
    //   11261: astore 15
    //   11263: iload 7
    //   11265: istore 8
    //   11267: aload 19
    //   11269: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   11272: iload 9
    //   11274: invokevirtual 467	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   11277: checkcast 126	java/lang/String
    //   11280: astore 16
    //   11282: aload_1
    //   11283: astore 15
    //   11285: iload 7
    //   11287: istore 8
    //   11289: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11292: ifeq +105 -> 11397
    //   11295: aload_1
    //   11296: astore 15
    //   11298: iload 7
    //   11300: istore 8
    //   11302: new 78	java/lang/StringBuilder
    //   11305: dup
    //   11306: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   11309: astore 20
    //   11311: aload_1
    //   11312: astore 15
    //   11314: iload 7
    //   11316: istore 8
    //   11318: aload 20
    //   11320: ldc_w 4813
    //   11323: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11326: pop
    //   11327: aload_1
    //   11328: astore 15
    //   11330: iload 7
    //   11332: istore 8
    //   11334: aload 20
    //   11336: aload 16
    //   11338: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11341: pop
    //   11342: aload_1
    //   11343: astore 15
    //   11345: iload 7
    //   11347: istore 8
    //   11349: aload 20
    //   11351: ldc_w 474
    //   11354: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11357: pop
    //   11358: aload_1
    //   11359: astore 15
    //   11361: iload 7
    //   11363: istore 8
    //   11365: aload 20
    //   11367: aload 19
    //   11369: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11372: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11375: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11378: pop
    //   11379: aload_1
    //   11380: astore 15
    //   11382: iload 7
    //   11384: istore 8
    //   11386: ldc 92
    //   11388: iconst_2
    //   11389: aload 20
    //   11391: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11394: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11397: aload_1
    //   11398: astore 15
    //   11400: iload 7
    //   11402: istore 8
    //   11404: aload_0
    //   11405: aload 16
    //   11407: invokespecial 4815	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/config/operation/QQOperationViopTipTask;
    //   11410: astore 16
    //   11412: aload 16
    //   11414: ifnull +2399 -> 13813
    //   11417: aload_1
    //   11418: astore 15
    //   11420: iload 7
    //   11422: istore 8
    //   11424: aload 5
    //   11426: aload 16
    //   11428: invokevirtual 3408	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   11431: pop
    //   11432: goto +2381 -> 13813
    //   11435: aload_1
    //   11436: astore 15
    //   11438: iload 7
    //   11440: istore 8
    //   11442: aload 17
    //   11444: invokestatic 4820	com/tencent/mobileqq/config/operation/QQOperateManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/config/operation/QQOperateManager;
    //   11447: aload 17
    //   11449: aload 5
    //   11451: invokevirtual 4823	com/tencent/mobileqq/config/operation/QQOperateManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/ArrayList;)V
    //   11454: aload_1
    //   11455: astore 15
    //   11457: iload 7
    //   11459: istore 8
    //   11461: aload 17
    //   11463: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11466: aload 17
    //   11468: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   11471: aload 19
    //   11473: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11476: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11479: invokestatic 4824	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   11482: aload_1
    //   11483: astore 16
    //   11485: iload 13
    //   11487: istore 14
    //   11489: iload 7
    //   11491: istore 9
    //   11493: goto -11371 -> 122
    //   11496: aload_1
    //   11497: astore 16
    //   11499: iload 13
    //   11501: istore 14
    //   11503: iload 7
    //   11505: istore 9
    //   11507: aload_1
    //   11508: astore 15
    //   11510: iload 7
    //   11512: istore 8
    //   11514: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11517: ifeq -11395 -> 122
    //   11520: aload_1
    //   11521: astore 15
    //   11523: iload 7
    //   11525: istore 8
    //   11527: new 78	java/lang/StringBuilder
    //   11530: dup
    //   11531: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   11534: astore 5
    //   11536: aload_1
    //   11537: astore 15
    //   11539: iload 7
    //   11541: istore 8
    //   11543: aload 5
    //   11545: ldc_w 4826
    //   11548: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11551: pop
    //   11552: aload_1
    //   11553: astore 15
    //   11555: iload 7
    //   11557: istore 8
    //   11559: aload 5
    //   11561: aload 19
    //   11563: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11566: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11569: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11572: pop
    //   11573: aload_1
    //   11574: astore 15
    //   11576: iload 7
    //   11578: istore 8
    //   11580: ldc 92
    //   11582: iconst_2
    //   11583: aload 5
    //   11585: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11588: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11591: aload_1
    //   11592: astore 16
    //   11594: iload 13
    //   11596: istore 14
    //   11598: iload 7
    //   11600: istore 9
    //   11602: goto -11480 -> 122
    //   11605: aload_1
    //   11606: astore 15
    //   11608: iload 7
    //   11610: istore 8
    //   11612: aload 19
    //   11614: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   11617: ifnull +194 -> 11811
    //   11620: aload_1
    //   11621: astore 15
    //   11623: iload 7
    //   11625: istore 8
    //   11627: aload 19
    //   11629: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   11632: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   11635: ifle +176 -> 11811
    //   11638: aload_1
    //   11639: astore 15
    //   11641: iload 7
    //   11643: istore 8
    //   11645: aload 19
    //   11647: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   11650: iconst_0
    //   11651: invokevirtual 467	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   11654: checkcast 126	java/lang/String
    //   11657: astore 5
    //   11659: aload_1
    //   11660: astore 15
    //   11662: iload 7
    //   11664: istore 8
    //   11666: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11669: ifeq +105 -> 11774
    //   11672: aload_1
    //   11673: astore 15
    //   11675: iload 7
    //   11677: istore 8
    //   11679: new 78	java/lang/StringBuilder
    //   11682: dup
    //   11683: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   11686: astore 16
    //   11688: aload_1
    //   11689: astore 15
    //   11691: iload 7
    //   11693: istore 8
    //   11695: aload 16
    //   11697: ldc_w 4828
    //   11700: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11703: pop
    //   11704: aload_1
    //   11705: astore 15
    //   11707: iload 7
    //   11709: istore 8
    //   11711: aload 16
    //   11713: aload 5
    //   11715: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11718: pop
    //   11719: aload_1
    //   11720: astore 15
    //   11722: iload 7
    //   11724: istore 8
    //   11726: aload 16
    //   11728: ldc_w 474
    //   11731: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11734: pop
    //   11735: aload_1
    //   11736: astore 15
    //   11738: iload 7
    //   11740: istore 8
    //   11742: aload 16
    //   11744: aload 19
    //   11746: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11749: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11752: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11755: pop
    //   11756: aload_1
    //   11757: astore 15
    //   11759: iload 7
    //   11761: istore 8
    //   11763: ldc 92
    //   11765: iconst_2
    //   11766: aload 16
    //   11768: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11771: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11774: aload_1
    //   11775: astore 15
    //   11777: iload 7
    //   11779: istore 8
    //   11781: aload_0
    //   11782: aload 17
    //   11784: aload 5
    //   11786: aload 19
    //   11788: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11791: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11794: invokespecial 4830	com/tencent/mobileqq/config/splashlogo/ConfigServlet:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   11797: aload_1
    //   11798: astore 16
    //   11800: iload 13
    //   11802: istore 14
    //   11804: iload 7
    //   11806: istore 9
    //   11808: goto -11686 -> 122
    //   11811: aload_1
    //   11812: astore 15
    //   11814: iload 7
    //   11816: istore 8
    //   11818: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11821: ifeq +74 -> 11895
    //   11824: aload_1
    //   11825: astore 15
    //   11827: iload 7
    //   11829: istore 8
    //   11831: new 78	java/lang/StringBuilder
    //   11834: dup
    //   11835: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   11838: astore 5
    //   11840: aload_1
    //   11841: astore 15
    //   11843: iload 7
    //   11845: istore 8
    //   11847: aload 5
    //   11849: ldc_w 4832
    //   11852: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11855: pop
    //   11856: aload_1
    //   11857: astore 15
    //   11859: iload 7
    //   11861: istore 8
    //   11863: aload 5
    //   11865: aload 19
    //   11867: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   11870: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   11873: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11876: pop
    //   11877: aload_1
    //   11878: astore 15
    //   11880: iload 7
    //   11882: istore 8
    //   11884: ldc 92
    //   11886: iconst_2
    //   11887: aload 5
    //   11889: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11892: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11895: aload_1
    //   11896: astore 15
    //   11898: iload 7
    //   11900: istore 8
    //   11902: new 78	java/lang/StringBuilder
    //   11905: dup
    //   11906: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   11909: astore 5
    //   11911: aload_1
    //   11912: astore 15
    //   11914: iload 7
    //   11916: istore 8
    //   11918: aload 5
    //   11920: aload 17
    //   11922: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11925: invokevirtual 3632	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   11928: invokevirtual 2180	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11931: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11934: pop
    //   11935: aload_1
    //   11936: astore 15
    //   11938: iload 7
    //   11940: istore 8
    //   11942: aload 5
    //   11944: ldc_w 2182
    //   11947: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11950: pop
    //   11951: aload_1
    //   11952: astore 15
    //   11954: iload 7
    //   11956: istore 8
    //   11958: aload 5
    //   11960: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   11963: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11966: pop
    //   11967: aload_1
    //   11968: astore 15
    //   11970: iload 7
    //   11972: istore 8
    //   11974: aload 5
    //   11976: ldc_w 2182
    //   11979: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11982: pop
    //   11983: aload_1
    //   11984: astore 15
    //   11986: iload 7
    //   11988: istore 8
    //   11990: aload 5
    //   11992: ldc_w 3634
    //   11995: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11998: pop
    //   11999: aload_1
    //   12000: astore 15
    //   12002: iload 7
    //   12004: istore 8
    //   12006: new 2177	java/io/File
    //   12009: dup
    //   12010: aload 5
    //   12012: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12015: invokespecial 3676	java/io/File:<init>	(Ljava/lang/String;)V
    //   12018: astore 5
    //   12020: aload_1
    //   12021: astore 15
    //   12023: iload 7
    //   12025: istore 8
    //   12027: aload 5
    //   12029: invokevirtual 3679	java/io/File:exists	()Z
    //   12032: ifeq +16 -> 12048
    //   12035: aload_1
    //   12036: astore 15
    //   12038: iload 7
    //   12040: istore 8
    //   12042: aload 5
    //   12044: invokevirtual 3682	java/io/File:delete	()Z
    //   12047: pop
    //   12048: aload_1
    //   12049: astore 15
    //   12051: iload 7
    //   12053: istore 8
    //   12055: aload 17
    //   12057: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   12060: aload 19
    //   12062: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   12065: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12068: ldc 8
    //   12070: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   12073: invokestatic 4834	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   12076: aload_1
    //   12077: astore 16
    //   12079: iload 13
    //   12081: istore 14
    //   12083: iload 7
    //   12085: istore 9
    //   12087: goto -11965 -> 122
    //   12090: astore 5
    //   12092: iload 8
    //   12094: istore 7
    //   12096: aload 15
    //   12098: astore_1
    //   12099: goto +1633 -> 13732
    //   12102: iload 7
    //   12104: istore 10
    //   12106: aload 19
    //   12108: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   12111: astore 5
    //   12113: aload 5
    //   12115: ifnull +619 -> 12734
    //   12118: aload_1
    //   12119: astore 15
    //   12121: iload 10
    //   12123: istore 8
    //   12125: aload 19
    //   12127: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   12130: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   12133: ifle +601 -> 12734
    //   12136: aload_1
    //   12137: astore 15
    //   12139: iload 10
    //   12141: istore 8
    //   12143: getstatic 3530	com/tencent/mobileqq/config/Config:c	Lcom/tencent/mobileqq/config/struct/PicAndAdConf;
    //   12146: invokevirtual 4835	com/tencent/mobileqq/config/struct/PicAndAdConf:e	()V
    //   12149: aload_1
    //   12150: astore 15
    //   12152: iload 10
    //   12154: istore 8
    //   12156: aload 19
    //   12158: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   12161: invokevirtual 2720	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   12164: invokeinterface 115 1 0
    //   12169: astore 5
    //   12171: aload_1
    //   12172: astore 15
    //   12174: iload 10
    //   12176: istore 8
    //   12178: aload 5
    //   12180: invokeinterface 120 1 0
    //   12185: ifeq +163 -> 12348
    //   12188: aload_1
    //   12189: astore 15
    //   12191: iload 10
    //   12193: istore 8
    //   12195: aload 5
    //   12197: invokeinterface 124 1 0
    //   12202: checkcast 126	java/lang/String
    //   12205: astore 16
    //   12207: aload_1
    //   12208: astore 15
    //   12210: iload 10
    //   12212: istore 8
    //   12214: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12217: ifeq +105 -> 12322
    //   12220: aload_1
    //   12221: astore 15
    //   12223: iload 10
    //   12225: istore 8
    //   12227: new 78	java/lang/StringBuilder
    //   12230: dup
    //   12231: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   12234: astore 20
    //   12236: aload_1
    //   12237: astore 15
    //   12239: iload 10
    //   12241: istore 8
    //   12243: aload 20
    //   12245: ldc_w 4837
    //   12248: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12251: pop
    //   12252: aload_1
    //   12253: astore 15
    //   12255: iload 10
    //   12257: istore 8
    //   12259: aload 20
    //   12261: aload 16
    //   12263: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12266: pop
    //   12267: aload_1
    //   12268: astore 15
    //   12270: iload 10
    //   12272: istore 8
    //   12274: aload 20
    //   12276: ldc_w 474
    //   12279: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12282: pop
    //   12283: aload_1
    //   12284: astore 15
    //   12286: iload 10
    //   12288: istore 8
    //   12290: aload 20
    //   12292: aload 19
    //   12294: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   12297: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12300: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12303: pop
    //   12304: aload_1
    //   12305: astore 15
    //   12307: iload 10
    //   12309: istore 8
    //   12311: ldc 92
    //   12313: iconst_2
    //   12314: aload 20
    //   12316: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12319: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12322: aload_1
    //   12323: astore 15
    //   12325: iload 10
    //   12327: istore 8
    //   12329: aload_0
    //   12330: aload 17
    //   12332: aload 16
    //   12334: aload 19
    //   12336: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   12339: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12342: invokespecial 4839	com/tencent/mobileqq/config/splashlogo/ConfigServlet:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   12345: goto -174 -> 12171
    //   12348: aload_1
    //   12349: astore 15
    //   12351: iload 10
    //   12353: istore 8
    //   12355: new 4841	com/tencent/mobileqq/config/ConfigManager
    //   12358: dup
    //   12359: aload 17
    //   12361: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   12364: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   12367: invokespecial 4843	com/tencent/mobileqq/config/ConfigManager:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   12370: astore 5
    //   12372: aload_1
    //   12373: astore 15
    //   12375: iload 10
    //   12377: istore 8
    //   12379: aload 5
    //   12381: invokevirtual 4844	com/tencent/mobileqq/config/ConfigManager:c	()V
    //   12384: aload_1
    //   12385: astore 15
    //   12387: iload 10
    //   12389: istore 8
    //   12391: aload 5
    //   12393: invokevirtual 4845	com/tencent/mobileqq/config/ConfigManager:d	()V
    //   12396: aload_1
    //   12397: astore 15
    //   12399: iload 10
    //   12401: istore 8
    //   12403: invokestatic 63	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12406: ldc_w 4847
    //   12409: iconst_0
    //   12410: invokevirtual 655	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   12413: astore 5
    //   12415: aload_1
    //   12416: astore 15
    //   12418: iload 10
    //   12420: istore 8
    //   12422: aload 5
    //   12424: invokeinterface 661 1 0
    //   12429: astore 16
    //   12431: aload_1
    //   12432: astore 15
    //   12434: iload 10
    //   12436: istore 8
    //   12438: new 78	java/lang/StringBuilder
    //   12441: dup
    //   12442: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   12445: astore 20
    //   12447: aload_1
    //   12448: astore 15
    //   12450: iload 10
    //   12452: istore 8
    //   12454: aload 20
    //   12456: ldc_w 4849
    //   12459: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12462: pop
    //   12463: aload_1
    //   12464: astore 15
    //   12466: iload 10
    //   12468: istore 8
    //   12470: aload 20
    //   12472: aload 17
    //   12474: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   12477: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12480: pop
    //   12481: aload_1
    //   12482: astore 15
    //   12484: iload 10
    //   12486: istore 8
    //   12488: aload 16
    //   12490: aload 20
    //   12492: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12495: iconst_1
    //   12496: invokeinterface 2532 3 0
    //   12501: invokeinterface 672 1 0
    //   12506: pop
    //   12507: aload_1
    //   12508: astore 15
    //   12510: iload 10
    //   12512: istore 8
    //   12514: aload 5
    //   12516: invokeinterface 661 1 0
    //   12521: astore 5
    //   12523: aload_1
    //   12524: astore 15
    //   12526: iload 10
    //   12528: istore 8
    //   12530: new 78	java/lang/StringBuilder
    //   12533: dup
    //   12534: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   12537: astore 16
    //   12539: aload_1
    //   12540: astore 15
    //   12542: iload 10
    //   12544: istore 8
    //   12546: aload 16
    //   12548: ldc_w 4851
    //   12551: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12554: pop
    //   12555: aload_1
    //   12556: astore 15
    //   12558: iload 10
    //   12560: istore 8
    //   12562: aload 16
    //   12564: aload 17
    //   12566: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   12569: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12572: pop
    //   12573: aload_1
    //   12574: astore 15
    //   12576: iload 10
    //   12578: istore 8
    //   12580: aload 5
    //   12582: aload 16
    //   12584: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12587: iconst_1
    //   12588: invokeinterface 2532 3 0
    //   12593: invokeinterface 672 1 0
    //   12598: pop
    //   12599: aload_1
    //   12600: astore 15
    //   12602: iload 10
    //   12604: istore 8
    //   12606: aload 17
    //   12608: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   12611: aload 19
    //   12613: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   12616: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12619: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   12622: invokestatic 4278	com/tencent/mobileqq/utils/SharedPreUtils:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   12625: aload_1
    //   12626: astore 16
    //   12628: iload 13
    //   12630: istore 14
    //   12632: iload 10
    //   12634: istore 9
    //   12636: aload_1
    //   12637: astore 15
    //   12639: iload 10
    //   12641: istore 8
    //   12643: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12646: ifeq -12524 -> 122
    //   12649: aload_1
    //   12650: astore 15
    //   12652: iload 10
    //   12654: istore 8
    //   12656: new 78	java/lang/StringBuilder
    //   12659: dup
    //   12660: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   12663: astore 5
    //   12665: aload_1
    //   12666: astore 15
    //   12668: iload 10
    //   12670: istore 8
    //   12672: aload 5
    //   12674: ldc_w 4853
    //   12677: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12680: pop
    //   12681: aload_1
    //   12682: astore 15
    //   12684: iload 10
    //   12686: istore 8
    //   12688: aload 5
    //   12690: aload 19
    //   12692: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   12695: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12698: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12701: pop
    //   12702: aload_1
    //   12703: astore 15
    //   12705: iload 10
    //   12707: istore 8
    //   12709: ldc 92
    //   12711: iconst_2
    //   12712: aload 5
    //   12714: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12717: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   12720: aload_1
    //   12721: astore 16
    //   12723: iload 13
    //   12725: istore 14
    //   12727: iload 10
    //   12729: istore 9
    //   12731: goto -12609 -> 122
    //   12734: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12737: istore 14
    //   12739: iload 14
    //   12741: ifeq +74 -> 12815
    //   12744: aload_1
    //   12745: astore 15
    //   12747: iload 10
    //   12749: istore 8
    //   12751: new 78	java/lang/StringBuilder
    //   12754: dup
    //   12755: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   12758: astore 5
    //   12760: aload_1
    //   12761: astore 15
    //   12763: iload 10
    //   12765: istore 8
    //   12767: aload 5
    //   12769: ldc_w 4855
    //   12772: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12775: pop
    //   12776: aload_1
    //   12777: astore 15
    //   12779: iload 10
    //   12781: istore 8
    //   12783: aload 5
    //   12785: aload 19
    //   12787: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   12790: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12793: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12796: pop
    //   12797: aload_1
    //   12798: astore 15
    //   12800: iload 10
    //   12802: istore 8
    //   12804: ldc 92
    //   12806: iconst_2
    //   12807: aload 5
    //   12809: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12812: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12815: getstatic 3530	com/tencent/mobileqq/config/Config:c	Lcom/tencent/mobileqq/config/struct/PicAndAdConf;
    //   12818: invokevirtual 4835	com/tencent/mobileqq/config/struct/PicAndAdConf:e	()V
    //   12821: getstatic 3530	com/tencent/mobileqq/config/Config:c	Lcom/tencent/mobileqq/config/struct/PicAndAdConf;
    //   12824: invokevirtual 4856	com/tencent/mobileqq/config/struct/PicAndAdConf:f	()V
    //   12827: new 4841	com/tencent/mobileqq/config/ConfigManager
    //   12830: dup
    //   12831: aload 17
    //   12833: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   12836: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   12839: invokespecial 4843	com/tencent/mobileqq/config/ConfigManager:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   12842: astore 5
    //   12844: aload 5
    //   12846: invokevirtual 4844	com/tencent/mobileqq/config/ConfigManager:c	()V
    //   12849: aload 5
    //   12851: invokevirtual 4845	com/tencent/mobileqq/config/ConfigManager:d	()V
    //   12854: invokestatic 63	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12857: ldc_w 4847
    //   12860: iconst_0
    //   12861: invokevirtual 655	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   12864: invokeinterface 661 1 0
    //   12869: astore 5
    //   12871: new 78	java/lang/StringBuilder
    //   12874: dup
    //   12875: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   12878: astore 15
    //   12880: aload 15
    //   12882: ldc_w 4851
    //   12885: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12888: pop
    //   12889: aload 15
    //   12891: aload 17
    //   12893: invokevirtual 1175	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   12896: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12899: pop
    //   12900: aload 15
    //   12902: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12905: astore 15
    //   12907: aload 5
    //   12909: aload 15
    //   12911: iconst_0
    //   12912: invokeinterface 2532 3 0
    //   12917: invokeinterface 672 1 0
    //   12922: pop
    //   12923: aload 17
    //   12925: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   12928: aload 19
    //   12930: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   12933: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12936: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   12939: invokestatic 4278	com/tencent/mobileqq/utils/SharedPreUtils:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   12942: aload_1
    //   12943: astore 16
    //   12945: iload 13
    //   12947: istore 14
    //   12949: iload 10
    //   12951: istore 9
    //   12953: goto +547 -> 13500
    //   12956: iload 7
    //   12958: istore 8
    //   12960: aload 19
    //   12962: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   12965: ifnull +321 -> 13286
    //   12968: aload 19
    //   12970: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   12973: invokevirtual 466	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   12976: ifle +310 -> 13286
    //   12979: new 78	java/lang/StringBuilder
    //   12982: dup
    //   12983: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   12986: astore 5
    //   12988: aload 5
    //   12990: aload 17
    //   12992: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   12995: invokevirtual 3632	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   12998: invokevirtual 2180	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   13001: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13004: pop
    //   13005: aload 5
    //   13007: ldc_w 3675
    //   13010: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13013: pop
    //   13014: new 2177	java/io/File
    //   13017: dup
    //   13018: aload 5
    //   13020: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13023: invokespecial 3676	java/io/File:<init>	(Ljava/lang/String;)V
    //   13026: astore 5
    //   13028: aload 5
    //   13030: invokevirtual 3679	java/io/File:exists	()Z
    //   13033: ifne +12 -> 13045
    //   13036: aload 5
    //   13038: invokevirtual 4859	java/io/File:mkdirs	()Z
    //   13041: pop
    //   13042: goto +62 -> 13104
    //   13045: aload 5
    //   13047: invokevirtual 4862	java/io/File:isDirectory	()Z
    //   13050: ifeq +54 -> 13104
    //   13053: aload 5
    //   13055: invokevirtual 4866	java/io/File:listFiles	()[Ljava/io/File;
    //   13058: astore 5
    //   13060: aload 5
    //   13062: arraylength
    //   13063: istore 10
    //   13065: iconst_0
    //   13066: istore 9
    //   13068: iload 9
    //   13070: iload 10
    //   13072: if_icmpge +32 -> 13104
    //   13075: aload 5
    //   13077: iload 9
    //   13079: aaload
    //   13080: astore 15
    //   13082: aload 15
    //   13084: ifnull +743 -> 13827
    //   13087: aload 15
    //   13089: invokevirtual 3679	java/io/File:exists	()Z
    //   13092: ifeq +735 -> 13827
    //   13095: aload 15
    //   13097: invokevirtual 3682	java/io/File:delete	()Z
    //   13100: pop
    //   13101: goto +726 -> 13827
    //   13104: aload 19
    //   13106: getfield 463	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   13109: invokevirtual 2720	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   13112: invokeinterface 115 1 0
    //   13117: astore 5
    //   13119: aload_1
    //   13120: astore 16
    //   13122: iload 13
    //   13124: istore 14
    //   13126: iload 8
    //   13128: istore 9
    //   13130: aload 5
    //   13132: invokeinterface 120 1 0
    //   13137: ifeq +363 -> 13500
    //   13140: aload 5
    //   13142: invokeinterface 124 1 0
    //   13147: checkcast 126	java/lang/String
    //   13150: astore 15
    //   13152: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13155: ifeq +63 -> 13218
    //   13158: new 78	java/lang/StringBuilder
    //   13161: dup
    //   13162: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   13165: astore 16
    //   13167: aload 16
    //   13169: ldc_w 4868
    //   13172: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13175: pop
    //   13176: aload 16
    //   13178: aload 15
    //   13180: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13183: pop
    //   13184: aload 16
    //   13186: ldc_w 474
    //   13189: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13192: pop
    //   13193: aload 16
    //   13195: aload 19
    //   13197: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   13200: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   13203: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13206: pop
    //   13207: ldc 92
    //   13209: iconst_2
    //   13210: aload 16
    //   13212: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13215: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13218: aload_0
    //   13219: aload 17
    //   13221: aload 15
    //   13223: aload 19
    //   13225: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   13228: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   13231: invokespecial 4870	com/tencent/mobileqq/config/splashlogo/ConfigServlet:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   13234: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13237: ifeq -118 -> 13119
    //   13240: new 78	java/lang/StringBuilder
    //   13243: dup
    //   13244: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   13247: astore 15
    //   13249: aload 15
    //   13251: ldc_w 4872
    //   13254: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13257: pop
    //   13258: aload 15
    //   13260: aload 19
    //   13262: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   13265: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   13268: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13271: pop
    //   13272: ldc 92
    //   13274: iconst_2
    //   13275: aload 15
    //   13277: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13280: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   13283: goto -164 -> 13119
    //   13286: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13289: ifeq +46 -> 13335
    //   13292: new 78	java/lang/StringBuilder
    //   13295: dup
    //   13296: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   13299: astore 5
    //   13301: aload 5
    //   13303: ldc_w 4874
    //   13306: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13309: pop
    //   13310: aload 5
    //   13312: aload 19
    //   13314: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   13317: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   13320: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13323: pop
    //   13324: ldc 92
    //   13326: iconst_2
    //   13327: aload 5
    //   13329: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13332: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13335: new 78	java/lang/StringBuilder
    //   13338: dup
    //   13339: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   13342: astore 5
    //   13344: aload 5
    //   13346: aload 17
    //   13348: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   13351: invokevirtual 3632	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   13354: invokevirtual 2180	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   13357: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13360: pop
    //   13361: aload 5
    //   13363: ldc_w 2182
    //   13366: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13369: pop
    //   13370: aload 5
    //   13372: ldc_w 4876
    //   13375: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13378: pop
    //   13379: new 2177	java/io/File
    //   13382: dup
    //   13383: aload 5
    //   13385: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13388: invokespecial 3676	java/io/File:<init>	(Ljava/lang/String;)V
    //   13391: invokevirtual 3682	java/io/File:delete	()Z
    //   13394: pop
    //   13395: aload 17
    //   13397: invokevirtual 1417	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   13400: aload 19
    //   13402: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   13405: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   13408: ldc_w 4878
    //   13411: ldc 8
    //   13413: invokestatic 3673	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   13416: aload_1
    //   13417: astore 16
    //   13419: iload 13
    //   13421: istore 14
    //   13423: iload 8
    //   13425: istore 9
    //   13427: goto +73 -> 13500
    //   13430: astore 5
    //   13432: aload_1
    //   13433: astore 16
    //   13435: iload 13
    //   13437: istore 14
    //   13439: iload 7
    //   13441: istore 9
    //   13443: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13446: ifeq +54 -> 13500
    //   13449: new 78	java/lang/StringBuilder
    //   13452: dup
    //   13453: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   13456: astore 15
    //   13458: aload 15
    //   13460: ldc_w 4880
    //   13463: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13466: pop
    //   13467: aload 15
    //   13469: aload 5
    //   13471: invokevirtual 2032	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13474: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13477: pop
    //   13478: ldc 92
    //   13480: iconst_2
    //   13481: aload 15
    //   13483: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13486: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13489: iload 7
    //   13491: istore 9
    //   13493: iload 13
    //   13495: istore 14
    //   13497: aload_1
    //   13498: astore 16
    //   13500: iload 11
    //   13502: iconst_1
    //   13503: iadd
    //   13504: istore 11
    //   13506: iload 9
    //   13508: istore 7
    //   13510: aload 16
    //   13512: astore_1
    //   13513: iload 14
    //   13515: istore 13
    //   13517: goto -13485 -> 32
    //   13520: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13523: ifeq +103 -> 13626
    //   13526: new 78	java/lang/StringBuilder
    //   13529: dup
    //   13530: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   13533: astore_2
    //   13534: aload_2
    //   13535: ldc_w 4882
    //   13538: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13541: pop
    //   13542: aload_2
    //   13543: aload 18
    //   13545: invokevirtual 2073	java/util/ArrayList:size	()I
    //   13548: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13551: pop
    //   13552: aload_2
    //   13553: ldc_w 4884
    //   13556: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13559: pop
    //   13560: new 78	java/lang/StringBuilder
    //   13563: dup
    //   13564: aload_2
    //   13565: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13568: invokespecial 4885	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13571: astore_2
    //   13572: aload 18
    //   13574: invokevirtual 2074	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   13577: astore_3
    //   13578: aload_3
    //   13579: invokeinterface 120 1 0
    //   13584: ifeq +31 -> 13615
    //   13587: aload_2
    //   13588: aload_3
    //   13589: invokeinterface 124 1 0
    //   13594: checkcast 543	java/lang/Integer
    //   13597: invokevirtual 1274	java/lang/Integer:intValue	()I
    //   13600: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13603: pop
    //   13604: aload_2
    //   13605: ldc_w 2115
    //   13608: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13611: pop
    //   13612: goto -34 -> 13578
    //   13615: ldc_w 4887
    //   13618: iconst_2
    //   13619: aload_2
    //   13620: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13623: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13626: aload_1
    //   13627: ifnull +42 -> 13669
    //   13630: iload 13
    //   13632: ifne +53 -> 13685
    //   13635: aload 17
    //   13637: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13640: ldc_w 4492
    //   13643: invokestatic 4497	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   13646: ifne +39 -> 13685
    //   13649: aload 17
    //   13651: getstatic 4890	com/tencent/mobileqq/app/QQManagerFactory:TIM_UPGRADE_DOWNLOAD_MANAGER	I
    //   13654: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   13657: checkcast 4892	com/tencent/mobileqq/upgrade/UpgradeTIMManager
    //   13660: aload 17
    //   13662: aload_1
    //   13663: invokevirtual 4893	com/tencent/mobileqq/upgrade/UpgradeTIMManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   13666: goto +19 -> 13685
    //   13669: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13672: ifeq +13 -> 13685
    //   13675: ldc_w 1592
    //   13678: iconst_2
    //   13679: ldc_w 4895
    //   13682: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   13685: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13688: ifeq +36 -> 13724
    //   13691: new 78	java/lang/StringBuilder
    //   13694: dup
    //   13695: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   13698: astore_1
    //   13699: aload_1
    //   13700: ldc_w 4897
    //   13703: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13706: pop
    //   13707: aload_1
    //   13708: iload 13
    //   13710: invokevirtual 456	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13713: pop
    //   13714: ldc 92
    //   13716: iconst_2
    //   13717: aload_1
    //   13718: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13721: invokestatic 2010	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   13724: return
    //   13725: astore 5
    //   13727: goto +29 -> 13756
    //   13730: astore 5
    //   13732: goto -300 -> 13432
    //   13735: goto -12002 -> 1733
    //   13738: iload 10
    //   13740: iconst_1
    //   13741: iadd
    //   13742: istore 10
    //   13744: goto -12167 -> 1577
    //   13747: astore 5
    //   13749: iload 9
    //   13751: istore 7
    //   13753: goto -1654 -> 12099
    //   13756: aconst_null
    //   13757: astore 5
    //   13759: goto -9187 -> 4572
    //   13762: aconst_null
    //   13763: astore 5
    //   13765: goto -7533 -> 6232
    //   13768: iconst_0
    //   13769: istore 13
    //   13771: goto -7041 -> 6730
    //   13774: astore 5
    //   13776: goto -1677 -> 12099
    //   13779: goto -6649 -> 7130
    //   13782: goto -5542 -> 8240
    //   13785: aconst_null
    //   13786: astore 5
    //   13788: goto -4892 -> 8896
    //   13791: goto -4436 -> 9355
    //   13794: iload 12
    //   13796: istore 10
    //   13798: goto -4246 -> 9552
    //   13801: iload 10
    //   13803: iconst_1
    //   13804: iadd
    //   13805: istore 10
    //   13807: goto -3657 -> 10150
    //   13810: goto -3013 -> 10797
    //   13813: iload 9
    //   13815: iconst_1
    //   13816: iadd
    //   13817: istore 9
    //   13819: goto -2579 -> 11240
    //   13822: astore 5
    //   13824: goto -392 -> 13432
    //   13827: iload 9
    //   13829: iconst_1
    //   13830: iadd
    //   13831: istore 9
    //   13833: goto -765 -> 13068
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	13836	0	this	ConfigServlet
    //   0	13836	1	paramAppRuntime	AppRuntime
    //   0	13836	2	paramRespGetConfig	ConfigurationService.RespGetConfig
    //   0	13836	3	paramIntent	Intent
    //   0	13836	4	paramList	List<Integer>
    //   0	13836	5	paramArrayOfInt	int[]
    //   0	13836	6	paramBoolean	boolean
    //   13	13739	7	i	int
    //   63	13361	8	j	int
    //   113	13719	9	k	int
    //   94	13712	10	m	int
    //   25	13480	11	n	int
    //   9510	4285	12	i1	int
    //   30	13740	13	bool1	boolean
    //   117	13397	14	bool2	boolean
    //   1645	11837	15	localObject1	Object
    //   120	13391	16	localObject2	Object
    //   4	13657	17	localQQAppInterface	QQAppInterface
    //   22	13551	18	localArrayList	ArrayList
    //   54	13347	19	localObject3	Object
    //   8965	3526	20	localObject4	Object
    //   10567	242	21	localSet	Set
    //   10677	130	22	str	String
    //   10706	81	23	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2213	2224	2238	java/lang/Throwable
    //   4444	4458	4461	java/lang/OutOfMemoryError
    //   4444	4458	4522	java/io/UnsupportedEncodingException
    //   6653	6676	6772	finally
    //   6676	6679	6772	finally
    //   6692	6707	6772	finally
    //   6707	6724	6772	finally
    //   6730	6737	6772	finally
    //   6737	6759	6772	finally
    //   6774	6777	6772	finally
    //   6636	6653	6780	java/lang/Exception
    //   6777	6780	6780	java/lang/Exception
    //   6994	7028	7223	java/lang/Exception
    //   7039	7127	7223	java/lang/Exception
    //   7130	7146	7223	java/lang/Exception
    //   7160	7209	7223	java/lang/Exception
    //   8104	8138	8333	java/lang/Exception
    //   8149	8237	8333	java/lang/Exception
    //   8240	8256	8333	java/lang/Exception
    //   8270	8319	8333	java/lang/Exception
    //   1651	1660	12090	java/lang/Exception
    //   1667	1675	12090	java/lang/Exception
    //   1682	1691	12090	java/lang/Exception
    //   1698	1712	12090	java/lang/Exception
    //   1719	1730	12090	java/lang/Exception
    //   1740	1748	12090	java/lang/Exception
    //   1755	1771	12090	java/lang/Exception
    //   1792	1798	12090	java/lang/Exception
    //   1805	1814	12090	java/lang/Exception
    //   1821	1830	12090	java/lang/Exception
    //   1837	1851	12090	java/lang/Exception
    //   1858	1869	12090	java/lang/Exception
    //   1890	1898	12090	java/lang/Exception
    //   1919	1937	12090	java/lang/Exception
    //   1958	1977	12090	java/lang/Exception
    //   1998	2004	12090	java/lang/Exception
    //   2025	2033	12090	java/lang/Exception
    //   2054	2062	12090	java/lang/Exception
    //   2083	2105	12090	java/lang/Exception
    //   2126	2133	12090	java/lang/Exception
    //   2154	2161	12090	java/lang/Exception
    //   2182	2192	12090	java/lang/Exception
    //   2213	2224	12090	java/lang/Exception
    //   2247	2252	12090	java/lang/Exception
    //   2273	2281	12090	java/lang/Exception
    //   2302	2320	12090	java/lang/Exception
    //   2341	2349	12090	java/lang/Exception
    //   2370	2378	12090	java/lang/Exception
    //   2399	2417	12090	java/lang/Exception
    //   2438	2446	12090	java/lang/Exception
    //   2467	2474	12090	java/lang/Exception
    //   2495	2503	12090	java/lang/Exception
    //   2524	2545	12090	java/lang/Exception
    //   2566	2574	12090	java/lang/Exception
    //   2595	2604	12090	java/lang/Exception
    //   2625	2642	12090	java/lang/Exception
    //   2663	2670	12090	java/lang/Exception
    //   2691	2699	12090	java/lang/Exception
    //   2720	2728	12090	java/lang/Exception
    //   2749	2756	12090	java/lang/Exception
    //   2777	2798	12090	java/lang/Exception
    //   2819	2829	12090	java/lang/Exception
    //   2850	2866	12090	java/lang/Exception
    //   2887	2899	12090	java/lang/Exception
    //   2920	2929	12090	java/lang/Exception
    //   2950	2958	12090	java/lang/Exception
    //   2979	2987	12090	java/lang/Exception
    //   3008	3018	12090	java/lang/Exception
    //   3039	3047	12090	java/lang/Exception
    //   3068	3076	12090	java/lang/Exception
    //   3097	3105	12090	java/lang/Exception
    //   3126	3134	12090	java/lang/Exception
    //   3155	3162	12090	java/lang/Exception
    //   3183	3190	12090	java/lang/Exception
    //   3211	3219	12090	java/lang/Exception
    //   3240	3248	12090	java/lang/Exception
    //   3269	3277	12090	java/lang/Exception
    //   3298	3306	12090	java/lang/Exception
    //   3327	3335	12090	java/lang/Exception
    //   3356	3364	12090	java/lang/Exception
    //   3385	3393	12090	java/lang/Exception
    //   3414	3422	12090	java/lang/Exception
    //   3443	3451	12090	java/lang/Exception
    //   3472	3480	12090	java/lang/Exception
    //   3501	3509	12090	java/lang/Exception
    //   3530	3538	12090	java/lang/Exception
    //   3559	3567	12090	java/lang/Exception
    //   3588	3596	12090	java/lang/Exception
    //   3617	3625	12090	java/lang/Exception
    //   3646	3654	12090	java/lang/Exception
    //   3675	3680	12090	java/lang/Exception
    //   3701	3709	12090	java/lang/Exception
    //   3730	3738	12090	java/lang/Exception
    //   3759	3769	12090	java/lang/Exception
    //   3790	3819	12090	java/lang/Exception
    //   3842	3871	12090	java/lang/Exception
    //   3892	3909	12090	java/lang/Exception
    //   3930	3943	12090	java/lang/Exception
    //   3966	3975	12090	java/lang/Exception
    //   3996	4015	12090	java/lang/Exception
    //   4036	4043	12090	java/lang/Exception
    //   4064	4071	12090	java/lang/Exception
    //   4092	4100	12090	java/lang/Exception
    //   4121	4131	12090	java/lang/Exception
    //   4152	4160	12090	java/lang/Exception
    //   4181	4189	12090	java/lang/Exception
    //   4210	4218	12090	java/lang/Exception
    //   4239	4247	12090	java/lang/Exception
    //   4268	4276	12090	java/lang/Exception
    //   4312	4320	12090	java/lang/Exception
    //   4338	4349	12090	java/lang/Exception
    //   4356	4363	12090	java/lang/Exception
    //   4378	4385	12090	java/lang/Exception
    //   4397	4409	12090	java/lang/Exception
    //   4416	4432	12090	java/lang/Exception
    //   4444	4458	12090	java/lang/Exception
    //   4470	4476	12090	java/lang/Exception
    //   4483	4488	12090	java/lang/Exception
    //   4495	4498	12090	java/lang/Exception
    //   4505	4519	12090	java/lang/Exception
    //   4531	4537	12090	java/lang/Exception
    //   4544	4549	12090	java/lang/Exception
    //   4559	4572	12090	java/lang/Exception
    //   4595	4605	12090	java/lang/Exception
    //   4612	4618	12090	java/lang/Exception
    //   4625	4634	12090	java/lang/Exception
    //   4641	4650	12090	java/lang/Exception
    //   4657	4665	12090	java/lang/Exception
    //   4672	4681	12090	java/lang/Exception
    //   4688	4696	12090	java/lang/Exception
    //   4703	4715	12090	java/lang/Exception
    //   4722	4728	12090	java/lang/Exception
    //   4735	4748	12090	java/lang/Exception
    //   4755	4769	12090	java/lang/Exception
    //   4776	4782	12090	java/lang/Exception
    //   4789	4799	12090	java/lang/Exception
    //   4806	4811	12090	java/lang/Exception
    //   4818	4824	12090	java/lang/Exception
    //   4856	4862	12090	java/lang/Exception
    //   4869	4879	12090	java/lang/Exception
    //   4911	4917	12090	java/lang/Exception
    //   4924	4934	12090	java/lang/Exception
    //   4955	4963	12090	java/lang/Exception
    //   4984	4994	12090	java/lang/Exception
    //   5015	5023	12090	java/lang/Exception
    //   5044	5052	12090	java/lang/Exception
    //   5073	5081	12090	java/lang/Exception
    //   5102	5110	12090	java/lang/Exception
    //   5131	5139	12090	java/lang/Exception
    //   5160	5168	12090	java/lang/Exception
    //   5189	5197	12090	java/lang/Exception
    //   5218	5226	12090	java/lang/Exception
    //   5247	5257	12090	java/lang/Exception
    //   5278	5299	12090	java/lang/Exception
    //   5320	5328	12090	java/lang/Exception
    //   5349	5357	12090	java/lang/Exception
    //   5378	5386	12090	java/lang/Exception
    //   5407	5415	12090	java/lang/Exception
    //   5436	5448	12090	java/lang/Exception
    //   5469	5477	12090	java/lang/Exception
    //   5498	5506	12090	java/lang/Exception
    //   5527	5535	12090	java/lang/Exception
    //   5556	5566	12090	java/lang/Exception
    //   5587	5595	12090	java/lang/Exception
    //   5616	5624	12090	java/lang/Exception
    //   5645	5653	12090	java/lang/Exception
    //   5674	5682	12090	java/lang/Exception
    //   5703	5711	12090	java/lang/Exception
    //   5732	5740	12090	java/lang/Exception
    //   5761	5769	12090	java/lang/Exception
    //   5790	5798	12090	java/lang/Exception
    //   5819	5827	12090	java/lang/Exception
    //   5848	5861	12090	java/lang/Exception
    //   5868	5878	12090	java/lang/Exception
    //   5885	5891	12090	java/lang/Exception
    //   5898	5930	12090	java/lang/Exception
    //   5944	5952	12090	java/lang/Exception
    //   5959	5970	12090	java/lang/Exception
    //   5980	5994	12090	java/lang/Exception
    //   6001	6007	12090	java/lang/Exception
    //   6014	6023	12090	java/lang/Exception
    //   6030	6039	12090	java/lang/Exception
    //   6046	6054	12090	java/lang/Exception
    //   6061	6072	12090	java/lang/Exception
    //   6079	6087	12090	java/lang/Exception
    //   6094	6104	12090	java/lang/Exception
    //   6114	6125	12090	java/lang/Exception
    //   6135	6141	12090	java/lang/Exception
    //   6148	6157	12090	java/lang/Exception
    //   6164	6174	12090	java/lang/Exception
    //   6184	6197	12090	java/lang/Exception
    //   6207	6213	12090	java/lang/Exception
    //   6220	6229	12090	java/lang/Exception
    //   6239	6252	12090	java/lang/Exception
    //   6259	6267	12090	java/lang/Exception
    //   6274	6282	12090	java/lang/Exception
    //   6289	6296	12090	java/lang/Exception
    //   6303	6309	12090	java/lang/Exception
    //   6316	6355	12090	java/lang/Exception
    //   6362	6384	12090	java/lang/Exception
    //   6391	6405	12090	java/lang/Exception
    //   6412	6426	12090	java/lang/Exception
    //   6433	6447	12090	java/lang/Exception
    //   6454	6468	12090	java/lang/Exception
    //   6475	6494	12090	java/lang/Exception
    //   6501	6515	12090	java/lang/Exception
    //   6522	6528	12090	java/lang/Exception
    //   6535	6544	12090	java/lang/Exception
    //   6551	6563	12090	java/lang/Exception
    //   6570	6580	12090	java/lang/Exception
    //   6587	6596	12090	java/lang/Exception
    //   6603	6610	12090	java/lang/Exception
    //   6617	6622	12090	java/lang/Exception
    //   6795	6800	12090	java/lang/Exception
    //   6807	6818	12090	java/lang/Exception
    //   6839	6849	12090	java/lang/Exception
    //   6870	6878	12090	java/lang/Exception
    //   6908	6920	12090	java/lang/Exception
    //   6941	6949	12090	java/lang/Exception
    //   6970	6980	12090	java/lang/Exception
    //   7232	7238	12090	java/lang/Exception
    //   7245	7254	12090	java/lang/Exception
    //   7261	7270	12090	java/lang/Exception
    //   7277	7288	12090	java/lang/Exception
    //   7295	7306	12090	java/lang/Exception
    //   7313	7318	12090	java/lang/Exception
    //   7339	7347	12090	java/lang/Exception
    //   7354	7365	12090	java/lang/Exception
    //   7372	7378	12090	java/lang/Exception
    //   7385	7394	12090	java/lang/Exception
    //   7401	7410	12090	java/lang/Exception
    //   7417	7425	12090	java/lang/Exception
    //   7432	7441	12090	java/lang/Exception
    //   7448	7466	12090	java/lang/Exception
    //   7473	7482	12090	java/lang/Exception
    //   7489	7503	12090	java/lang/Exception
    //   7510	7521	12090	java/lang/Exception
    //   7539	7568	12090	java/lang/Exception
    //   7575	7596	12090	java/lang/Exception
    //   7628	7634	12090	java/lang/Exception
    //   7641	7650	12090	java/lang/Exception
    //   7657	7666	12090	java/lang/Exception
    //   7673	7681	12090	java/lang/Exception
    //   7688	7697	12090	java/lang/Exception
    //   7704	7718	12090	java/lang/Exception
    //   7725	7736	12090	java/lang/Exception
    //   7757	7767	12090	java/lang/Exception
    //   7788	7796	12090	java/lang/Exception
    //   7817	7825	12090	java/lang/Exception
    //   7846	7854	12090	java/lang/Exception
    //   7886	7894	12090	java/lang/Exception
    //   7901	7920	12090	java/lang/Exception
    //   7927	7943	12090	java/lang/Exception
    //   7964	7972	12090	java/lang/Exception
    //   7993	8001	12090	java/lang/Exception
    //   8022	8030	12090	java/lang/Exception
    //   8051	8061	12090	java/lang/Exception
    //   8082	8090	12090	java/lang/Exception
    //   8342	8348	12090	java/lang/Exception
    //   8355	8364	12090	java/lang/Exception
    //   8371	8380	12090	java/lang/Exception
    //   8387	8398	12090	java/lang/Exception
    //   8405	8416	12090	java/lang/Exception
    //   8423	8428	12090	java/lang/Exception
    //   8449	8457	12090	java/lang/Exception
    //   8478	8486	12090	java/lang/Exception
    //   8493	8504	12090	java/lang/Exception
    //   8511	8525	12090	java/lang/Exception
    //   8532	8542	12090	java/lang/Exception
    //   8549	8563	12090	java/lang/Exception
    //   8581	8587	12090	java/lang/Exception
    //   8594	8603	12090	java/lang/Exception
    //   8610	8619	12090	java/lang/Exception
    //   8626	8634	12090	java/lang/Exception
    //   8641	8650	12090	java/lang/Exception
    //   8657	8671	12090	java/lang/Exception
    //   8678	8689	12090	java/lang/Exception
    //   8721	8727	12090	java/lang/Exception
    //   8734	8743	12090	java/lang/Exception
    //   8750	8759	12090	java/lang/Exception
    //   8766	8780	12090	java/lang/Exception
    //   8787	8798	12090	java/lang/Exception
    //   8819	8829	12090	java/lang/Exception
    //   8850	8858	12090	java/lang/Exception
    //   8865	8876	12090	java/lang/Exception
    //   8883	8893	12090	java/lang/Exception
    //   8908	8918	12090	java/lang/Exception
    //   8925	8938	12090	java/lang/Exception
    //   8945	8951	12090	java/lang/Exception
    //   8958	8967	12090	java/lang/Exception
    //   8974	8983	12090	java/lang/Exception
    //   8990	8998	12090	java/lang/Exception
    //   9005	9014	12090	java/lang/Exception
    //   9021	9035	12090	java/lang/Exception
    //   9042	9053	12090	java/lang/Exception
    //   9060	9065	12090	java/lang/Exception
    //   9072	9081	12090	java/lang/Exception
    //   9088	9098	12090	java/lang/Exception
    //   9105	9117	12090	java/lang/Exception
    //   9124	9130	12090	java/lang/Exception
    //   9137	9146	12090	java/lang/Exception
    //   9153	9162	12090	java/lang/Exception
    //   9169	9177	12090	java/lang/Exception
    //   9184	9193	12090	java/lang/Exception
    //   9200	9214	12090	java/lang/Exception
    //   9221	9232	12090	java/lang/Exception
    //   9239	9247	12090	java/lang/Exception
    //   9257	9261	12090	java/lang/Exception
    //   9268	9271	12090	java/lang/Exception
    //   9278	9284	12090	java/lang/Exception
    //   9291	9300	12090	java/lang/Exception
    //   9307	9316	12090	java/lang/Exception
    //   9323	9337	12090	java/lang/Exception
    //   9344	9355	12090	java/lang/Exception
    //   9362	9372	12090	java/lang/Exception
    //   9379	9389	12090	java/lang/Exception
    //   9410	9418	12090	java/lang/Exception
    //   9439	9447	12090	java/lang/Exception
    //   9468	9476	12090	java/lang/Exception
    //   9497	9512	12090	java/lang/Exception
    //   9524	9532	12090	java/lang/Exception
    //   9539	9549	12090	java/lang/Exception
    //   9559	9567	12090	java/lang/Exception
    //   9574	9585	12090	java/lang/Exception
    //   9592	9598	12090	java/lang/Exception
    //   9605	9614	12090	java/lang/Exception
    //   9621	9630	12090	java/lang/Exception
    //   9637	9645	12090	java/lang/Exception
    //   9652	9661	12090	java/lang/Exception
    //   9668	9676	12090	java/lang/Exception
    //   9683	9692	12090	java/lang/Exception
    //   9699	9713	12090	java/lang/Exception
    //   9720	9729	12090	java/lang/Exception
    //   9736	9754	12090	java/lang/Exception
    //   9761	9772	12090	java/lang/Exception
    //   9779	9788	12090	java/lang/Exception
    //   9798	9811	12090	java/lang/Exception
    //   9818	9836	12090	java/lang/Exception
    //   9852	9868	12090	java/lang/Exception
    //   9875	9890	12090	java/lang/Exception
    //   9911	9917	12090	java/lang/Exception
    //   9924	9933	12090	java/lang/Exception
    //   9940	9949	12090	java/lang/Exception
    //   9956	9964	12090	java/lang/Exception
    //   9971	9980	12090	java/lang/Exception
    //   9987	9995	12090	java/lang/Exception
    //   10002	10013	12090	java/lang/Exception
    //   10038	10052	12090	java/lang/Exception
    //   10059	10074	12090	java/lang/Exception
    //   10095	10103	12090	java/lang/Exception
    //   10110	10121	12090	java/lang/Exception
    //   10128	10147	12090	java/lang/Exception
    //   10168	10181	12090	java/lang/Exception
    //   10188	10203	12090	java/lang/Exception
    //   10210	10216	12090	java/lang/Exception
    //   10223	10232	12090	java/lang/Exception
    //   10239	10248	12090	java/lang/Exception
    //   10255	10263	12090	java/lang/Exception
    //   10270	10279	12090	java/lang/Exception
    //   10286	10300	12090	java/lang/Exception
    //   10307	10318	12090	java/lang/Exception
    //   10325	10333	12090	java/lang/Exception
    //   10340	10357	12090	java/lang/Exception
    //   10378	10384	12090	java/lang/Exception
    //   10391	10400	12090	java/lang/Exception
    //   10407	10416	12090	java/lang/Exception
    //   10423	10437	12090	java/lang/Exception
    //   10444	10455	12090	java/lang/Exception
    //   10476	10484	12090	java/lang/Exception
    //   10505	10521	12090	java/lang/Exception
    //   10542	10555	12090	java/lang/Exception
    //   10562	10569	12090	java/lang/Exception
    //   10576	10588	12090	java/lang/Exception
    //   10595	10603	12090	java/lang/Exception
    //   10610	10621	12090	java/lang/Exception
    //   10628	10643	12090	java/lang/Exception
    //   10650	10660	12090	java/lang/Exception
    //   10667	10679	12090	java/lang/Exception
    //   10686	10692	12090	java/lang/Exception
    //   10699	10708	12090	java/lang/Exception
    //   10715	10724	12090	java/lang/Exception
    //   10731	10739	12090	java/lang/Exception
    //   10746	10755	12090	java/lang/Exception
    //   10762	10776	12090	java/lang/Exception
    //   10783	10794	12090	java/lang/Exception
    //   10804	10814	12090	java/lang/Exception
    //   10821	10836	12090	java/lang/Exception
    //   10846	10852	12090	java/lang/Exception
    //   10859	10868	12090	java/lang/Exception
    //   10875	10884	12090	java/lang/Exception
    //   10891	10905	12090	java/lang/Exception
    //   10912	10923	12090	java/lang/Exception
    //   10930	10936	12090	java/lang/Exception
    //   10943	10952	12090	java/lang/Exception
    //   10959	10968	12090	java/lang/Exception
    //   10975	10983	12090	java/lang/Exception
    //   10996	11011	12090	java/lang/Exception
    //   11018	11026	12090	java/lang/Exception
    //   11033	11042	12090	java/lang/Exception
    //   11049	11060	12090	java/lang/Exception
    //   11067	11076	12090	java/lang/Exception
    //   11083	11097	12090	java/lang/Exception
    //   11104	11115	12090	java/lang/Exception
    //   11122	11135	12090	java/lang/Exception
    //   11156	11174	12090	java/lang/Exception
    //   11195	11203	12090	java/lang/Exception
    //   11210	11221	12090	java/lang/Exception
    //   11228	11237	12090	java/lang/Exception
    //   11247	11260	12090	java/lang/Exception
    //   11267	11282	12090	java/lang/Exception
    //   11289	11295	12090	java/lang/Exception
    //   11302	11311	12090	java/lang/Exception
    //   11318	11327	12090	java/lang/Exception
    //   11334	11342	12090	java/lang/Exception
    //   11349	11358	12090	java/lang/Exception
    //   11365	11379	12090	java/lang/Exception
    //   11386	11397	12090	java/lang/Exception
    //   11404	11412	12090	java/lang/Exception
    //   11424	11432	12090	java/lang/Exception
    //   11442	11454	12090	java/lang/Exception
    //   11461	11482	12090	java/lang/Exception
    //   11514	11520	12090	java/lang/Exception
    //   11527	11536	12090	java/lang/Exception
    //   11543	11552	12090	java/lang/Exception
    //   11559	11573	12090	java/lang/Exception
    //   11580	11591	12090	java/lang/Exception
    //   11612	11620	12090	java/lang/Exception
    //   11627	11638	12090	java/lang/Exception
    //   11645	11659	12090	java/lang/Exception
    //   11666	11672	12090	java/lang/Exception
    //   11679	11688	12090	java/lang/Exception
    //   11695	11704	12090	java/lang/Exception
    //   11711	11719	12090	java/lang/Exception
    //   11726	11735	12090	java/lang/Exception
    //   11742	11756	12090	java/lang/Exception
    //   11763	11774	12090	java/lang/Exception
    //   11781	11797	12090	java/lang/Exception
    //   11818	11824	12090	java/lang/Exception
    //   11831	11840	12090	java/lang/Exception
    //   11847	11856	12090	java/lang/Exception
    //   11863	11877	12090	java/lang/Exception
    //   11884	11895	12090	java/lang/Exception
    //   11902	11911	12090	java/lang/Exception
    //   11918	11935	12090	java/lang/Exception
    //   11942	11951	12090	java/lang/Exception
    //   11958	11967	12090	java/lang/Exception
    //   11974	11983	12090	java/lang/Exception
    //   11990	11999	12090	java/lang/Exception
    //   12006	12020	12090	java/lang/Exception
    //   12027	12035	12090	java/lang/Exception
    //   12042	12048	12090	java/lang/Exception
    //   12055	12076	12090	java/lang/Exception
    //   12125	12136	12090	java/lang/Exception
    //   12143	12149	12090	java/lang/Exception
    //   12156	12171	12090	java/lang/Exception
    //   12178	12188	12090	java/lang/Exception
    //   12195	12207	12090	java/lang/Exception
    //   12214	12220	12090	java/lang/Exception
    //   12227	12236	12090	java/lang/Exception
    //   12243	12252	12090	java/lang/Exception
    //   12259	12267	12090	java/lang/Exception
    //   12274	12283	12090	java/lang/Exception
    //   12290	12304	12090	java/lang/Exception
    //   12311	12322	12090	java/lang/Exception
    //   12329	12345	12090	java/lang/Exception
    //   12355	12372	12090	java/lang/Exception
    //   12379	12384	12090	java/lang/Exception
    //   12391	12396	12090	java/lang/Exception
    //   12403	12415	12090	java/lang/Exception
    //   12422	12431	12090	java/lang/Exception
    //   12438	12447	12090	java/lang/Exception
    //   12454	12463	12090	java/lang/Exception
    //   12470	12481	12090	java/lang/Exception
    //   12488	12507	12090	java/lang/Exception
    //   12514	12523	12090	java/lang/Exception
    //   12530	12539	12090	java/lang/Exception
    //   12546	12555	12090	java/lang/Exception
    //   12562	12573	12090	java/lang/Exception
    //   12580	12599	12090	java/lang/Exception
    //   12606	12625	12090	java/lang/Exception
    //   12643	12649	12090	java/lang/Exception
    //   12656	12665	12090	java/lang/Exception
    //   12672	12681	12090	java/lang/Exception
    //   12688	12702	12090	java/lang/Exception
    //   12709	12720	12090	java/lang/Exception
    //   12751	12760	12090	java/lang/Exception
    //   12767	12776	12090	java/lang/Exception
    //   12783	12797	12090	java/lang/Exception
    //   12804	12815	12090	java/lang/Exception
    //   4363	4371	13430	java/lang/Exception
    //   12907	12942	13430	java/lang/Exception
    //   12960	13042	13430	java/lang/Exception
    //   13045	13065	13430	java/lang/Exception
    //   13087	13101	13430	java/lang/Exception
    //   13104	13119	13430	java/lang/Exception
    //   13130	13218	13430	java/lang/Exception
    //   13218	13283	13430	java/lang/Exception
    //   13286	13335	13430	java/lang/Exception
    //   13335	13416	13430	java/lang/Exception
    //   4505	4519	13725	java/lang/Throwable
    //   1396	1410	13730	java/lang/Exception
    //   1417	1425	13730	java/lang/Exception
    //   1432	1440	13730	java/lang/Exception
    //   1447	1457	13730	java/lang/Exception
    //   1464	1472	13730	java/lang/Exception
    //   1479	1487	13730	java/lang/Exception
    //   1494	1502	13730	java/lang/Exception
    //   1509	1517	13730	java/lang/Exception
    //   1528	1536	13747	java/lang/Exception
    //   1540	1551	13747	java/lang/Exception
    //   1555	1574	13747	java/lang/Exception
    //   1585	1598	13747	java/lang/Exception
    //   1602	1617	13747	java/lang/Exception
    //   1621	1627	13747	java/lang/Exception
    //   1631	1640	13747	java/lang/Exception
    //   6892	6901	13774	java/lang/Exception
    //   12106	12113	13822	java/lang/Exception
    //   12734	12739	13822	java/lang/Exception
    //   12815	12907	13822	java/lang/Exception
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
      if (!QConfigManager.b().c(j))
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
              ScribbleResMgr.a().c();
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
        if (!this.d)
        {
          ReportController.b(paramAppRuntime, "CliOper", "", "", "0X800716D", "0X800716D", 0, 0, "", "", "", "");
          this.d = true;
        }
        ((ConfigHandler)paramAppRuntime.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a(UpgradeController.a().d());
        break label1347;
        paramIntent = paramAppRuntime;
        if ((!paramBoolean) || (paramRespGetConfig.result.get() != 0))
        {
          localObject = (PasswdRedBagFoldManager)paramIntent.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
          ((PasswdRedBagFoldManager)localObject).a = true;
          ((PasswdRedBagFoldManager)localObject).b = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
          ((PasswdRedBagFoldManager)localObject).c = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
          ((PasswdRedBagFoldManager)localObject).e = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
          SharedPreUtils.a(paramIntent.getApp(), paramIntent.getAccount(), 0, ((PasswdRedBagFoldManager)localObject).b, ((PasswdRedBagFoldManager)localObject).c, ((PasswdRedBagFoldManager)localObject).d, ((PasswdRedBagFoldManager)localObject).e);
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
      if (!QConfigManager.b().c(((Integer)localObject1).intValue()))
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
          NativeMonitorConfigHelper.startToHookAfterConfigGet(true);
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
          ScribbleResMgr.a().b();
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
          localObject2 = UpgradeConfigManager.a("config_upgrade_", a);
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
            SharedPreUtils.m(paramAppRuntime.getApp(), a, 0);
            UpgradeConfigManager.b("config_upgrade_", a);
            ((ConfigHandler)localObject1).a(UpgradeController.a().d());
          }
          else
          {
            localObject3 = UpgradeController.a().d();
            ((UpgradeDetailWrapper)localObject3).a((String)localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, String.format("receiveAllConfigs|GET_CONFIG_UPGRADE localAppID=%s configAppID=%s", new Object[] { Integer.valueOf(AppSetting.d()), Integer.valueOf(((UpgradeDetailWrapper)localObject3).c.iUpgradeSdkId) }));
            }
            if (AppSetting.d() >= ((UpgradeDetailWrapper)localObject3).c.iUpgradeSdkId)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE already upgraded, delete local config.");
              }
              SharedPreUtils.m(paramAppRuntime.getApp(), a, 0);
              UpgradeConfigManager.b("config_upgrade_", a);
              ((UpgradeDetailWrapper)localObject3).c.iUpgradeType = 0;
              ((ConfigHandler)localObject1).a((UpgradeDetailWrapper)localObject3);
              ((ConfigHandler)localObject1).f();
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
        if (!((UpgradeDetailWrapper)localObject3).g)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE waiting switch bit.");
          }
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|GET_CONFIG_UPGRADE do upgrade.");
        }
        if (((UpgradeDetailWrapper)localObject3).j == 0)
        {
          if (((UpgradeDetailWrapper)localObject3).i != 1) {
            break label1030;
          }
          ConfigHandler.b(paramAppRuntime, bool);
        }
        UpgradeController.a().a(((UpgradeDetailWrapper)localObject3).c, (UpgradeController.OnHandleUpgradeFinishListener)localObject1);
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
              if ((i != SharedPreUtils.c(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", a)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
              {
                ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).setGlamourIcon((String)localObject2);
                ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).setGlamourLevelColors((String)localObject2);
                SharedPreUtils.aj(paramQQAppInterface.getApp(), (String)localObject2);
                SharedPreUtils.a(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", a, i);
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
      if ((j == SharedPreUtils.S(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin())) && (paramConfig.content_list.size() <= 0))
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
      if ((j == SharedPreUtils.I(paramQQAppInterface.getApp())) && (paramConfig.content_list.size() <= 0))
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
    int i = SharedPreUtils.c(paramQQAppInterface.getApp(), "shop_tab", a);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {}
    try
    {
      paramConfig = new JSONObject((String)paramConfig.content_list.get(0));
      boolean bool = paramConfig.getBoolean("android");
      SharedPreUtils.a(paramQQAppInterface.getApp(), "shop_tab", a, j);
      paramQQAppInterface = (EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      paramQQAppInterface.b(bool);
      paramQQAppInterface.z = paramConfig.optBoolean("preload_web_process", false);
      paramQQAppInterface.x = paramConfig.optLong("stay_time", 5000L);
      paramQQAppInterface.y = paramConfig.optInt("day_limit", 3);
      EcShopAssistantManager.j().edit().putBoolean("preload_web", paramQQAppInterface.z).putLong("stayTime", paramQQAppInterface.x).putInt("dayLimit", paramQQAppInterface.y).commit();
      if (QLog.isColorLevel())
      {
        paramConfig = new StringBuilder();
        paramConfig.append("current config set tab show:");
        paramConfig.append(bool);
        paramConfig.append(",preload:");
        paramConfig.append(paramQQAppInterface.z);
        paramConfig.append(",stayTime:");
        paramConfig.append(paramQQAppInterface.x);
        paramConfig.append(",dayLimit:");
        paramConfig.append(paramQQAppInterface.y);
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
    int i = SharedPreUtils.an(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
    int j = paramConfig.version.get();
    if (i == j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig version code not changed .");
      }
      return;
    }
    SharedPreUtils.x(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), j);
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
        SharedPreUtils.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), paramConfig);
      } else {
        SharedPreUtils.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), null);
      }
      ((QQStoryManager)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER)).b(paramConfig);
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
    SharedPreUtils.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), null);
  }
  
  void i(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = SharedPreUtils.aA(paramQQAppInterface.getApp(), a);
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
        SharedPreUtils.n(paramConfig, "wifiAutoPreDown", localStringBuilder.toString());
        paramConfig = paramQQAppInterface.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(bool2);
        SharedPreUtils.n(paramConfig, "noSafeDown", localStringBuilder.toString());
        SharedPreUtils.C(paramQQAppInterface.getApp(), a, j);
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
    int i = SharedPreUtils.au(paramQQAppInterface.getApp(), a);
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
        SharedPreUtils.l(paramQQAppInterface.getApp(), "url", paramConfig);
        SharedPreUtils.l(paramQQAppInterface.getApp(), "thxWord", (String)localObject);
        SharedPreUtils.l(paramQQAppInterface.getApp(), "wantWord", str);
        SharedPreUtils.B(paramQQAppInterface.getApp(), a, j);
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
    int i = SharedPreUtils.aB(paramQQAppInterface.getApp(), a);
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
        SharedPreUtils.D(paramQQAppInterface.getApp(), a, j);
        SharedPreUtils.d(paramQQAppInterface.getApp(), a, bool);
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
    int i = SharedPreUtils.aT(paramQQAppInterface.getApp(), a);
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
          SharedPreUtils.J(paramQQAppInterface.getApp(), a, j);
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
    int i = SharedPreUtils.ay(paramQQAppInterface.getApp(), a);
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
          TroopManager.a(paramQQAppInterface, a, (JSONArray)localObject1, (JSONArray)localObject2);
        }
        catch (Exception paramConfig)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleTroopPobingConfig failed");
          ((StringBuilder)localObject1).append(paramConfig);
          QLog.e("SPLASH_ConfigServlet", 1, ((StringBuilder)localObject1).toString());
        }
        paramConfig = new JSONArray();
        TroopManager.a(paramQQAppInterface, a, paramConfig, paramConfig);
        QLog.i("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig, empty config clear local");
      }
    }
    label495:
    SharedPreUtils.A(paramQQAppInterface.getApp(), a, j);
  }
  
  void o(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 181) {
      return;
    }
    i = SharedPreUtils.aJ(paramQQAppInterface.getApp(), a);
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
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuConfigVersion(paramQQAppInterface.getApp(), a, j);
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
        String str = a;
        if (i == 1) {
          bool1 = true;
        }
        ((IDoutuSPUtil)localObject2).updateDoutuSwitch(localBaseApplication, str, bool1);
        ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuDuration(paramQQAppInterface.getApp(), a, l1);
        ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDuiTimes(paramQQAppInterface.getApp(), a, j);
        localObject2 = (IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class);
        localBaseApplication = paramQQAppInterface.getApp();
        str = a;
        if (k != 1) {
          break label1703;
        }
        bool1 = true;
        ((IDoutuSPUtil)localObject2).updateDoutuComboSwitch(localBaseApplication, str, bool1);
        localObject2 = (IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class);
        localBaseApplication = paramQQAppInterface.getApp();
        str = a;
        if (m != 1) {
          break label1709;
        }
        bool1 = true;
        ((IDoutuSPUtil)localObject2).updateDoutuSmartSwitchNew(localBaseApplication, str, bool1);
        if (paramConfig != null) {
          ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuResUrl(paramQQAppInterface.getApp(), a, paramConfig);
        }
        if (localObject1 != null) {
          ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuResMd5(paramQQAppInterface.getApp(), a, (String)localObject1);
        }
        ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateComboDuration(paramQQAppInterface.getApp(), a, l2);
        ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateComboKeep(paramQQAppInterface.getApp(), a, l3);
        ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateSmartPicCount(paramQQAppInterface.getApp(), a, n);
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
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuSwitch(paramQQAppInterface.getApp(), a);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuDuration(paramQQAppInterface.getApp(), a);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuComboSwitch(paramQQAppInterface.getApp(), a);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuSmartSwitchNew(paramQQAppInterface.getApp(), a);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuResUrl(paramQQAppInterface.getApp(), a);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuResMd5(paramQQAppInterface.getApp(), a);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeComboDuration(paramQQAppInterface.getApp(), a);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeComboKeep(paramQQAppInterface.getApp(), a);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeSmartPicCount(paramQQAppInterface.getApp(), a);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDoutuSmartSwitchNew(paramQQAppInterface.getApp(), a);
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).removeDuiTimes(paramQQAppInterface.getApp(), a);
    }
  }
  
  void p(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 247) {
      return;
    }
    int i = SharedPreUtils.z(paramQQAppInterface.getApp(), a);
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
      SharedPreUtils.f(paramQQAppInterface.getApp(), a, j);
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
      SharedPreUtils.x(paramQQAppInterface.getApp(), paramConfig);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GreenVideo", 1, "handleGreenVideoConfig content is null");
    }
    SharedPreUtils.l(paramQQAppInterface.getApp());
  }
  
  /* Error */
  void q(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 2229	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 272
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   21: invokestatic 1449	com/tencent/mobileqq/utils/SharedPreUtils:B	(Landroid/content/Context;Ljava/lang/String;)I
    //   24: istore_3
    //   25: aload_2
    //   26: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   29: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   32: istore 4
    //   34: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +56 -> 93
    //   40: new 78	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   47: astore 5
    //   49: aload 5
    //   51: ldc_w 5360
    //   54: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 5
    //   60: iload_3
    //   61: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 5
    //   67: ldc_w 5241
    //   70: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 5
    //   76: iload 4
    //   78: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 92
    //   84: iconst_2
    //   85: aload 5
    //   87: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: iload_3
    //   94: iload 4
    //   96: if_icmpeq +826 -> 922
    //   99: aload_1
    //   100: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   103: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   106: iload 4
    //   108: invokestatic 1436	com/tencent/mobileqq/utils/SharedPreUtils:h	(Landroid/content/Context;Ljava/lang/String;I)V
    //   111: aload_2
    //   112: getfield 389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   115: ifnull +807 -> 922
    //   118: aload_2
    //   119: getfield 389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   122: invokevirtual 392	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   125: ifle +797 -> 922
    //   128: aload_2
    //   129: getfield 389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   132: iconst_0
    //   133: invokevirtual 395	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   136: checkcast 397	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   139: astore_2
    //   140: aload_2
    //   141: ifnull +781 -> 922
    //   144: aload_2
    //   145: getfield 401	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   148: invokevirtual 404	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   151: iconst_1
    //   152: if_icmpne +56 -> 208
    //   155: aload_2
    //   156: getfield 408	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   159: invokevirtual 413	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   162: invokevirtual 419	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   165: invokestatic 424	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +33 -> 203
    //   173: new 126	java/lang/String
    //   176: dup
    //   177: aload_2
    //   178: ldc_w 426
    //   181: invokespecial 429	java/lang/String:<init>	([BLjava/lang/String;)V
    //   184: astore_2
    //   185: goto +34 -> 219
    //   188: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +12 -> 203
    //   194: ldc 92
    //   196: iconst_2
    //   197: ldc_w 5362
    //   200: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aconst_null
    //   204: astore_2
    //   205: goto +14 -> 219
    //   208: aload_2
    //   209: getfield 408	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   212: invokevirtual 413	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   215: invokevirtual 443	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   218: astore_2
    //   219: aload_2
    //   220: ifnull +677 -> 897
    //   223: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +39 -> 265
    //   229: new 78	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   236: astore 5
    //   238: aload 5
    //   240: ldc_w 5364
    //   243: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 5
    //   249: aload_2
    //   250: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: ldc 92
    //   256: iconst_2
    //   257: aload 5
    //   259: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: invokestatic 802	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   268: invokevirtual 806	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   271: new 808	java/io/ByteArrayInputStream
    //   274: dup
    //   275: aload_2
    //   276: ldc_w 810
    //   279: invokevirtual 814	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   282: invokespecial 817	java/io/ByteArrayInputStream:<init>	([B)V
    //   285: invokevirtual 822	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   288: astore_2
    //   289: aload_2
    //   290: ldc_w 5366
    //   293: invokeinterface 830 2 0
    //   298: astore 5
    //   300: aload 5
    //   302: ifnull +620 -> 922
    //   305: aload 5
    //   307: invokeinterface 835 1 0
    //   312: ifle +610 -> 922
    //   315: new 78	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   322: astore 5
    //   324: aload_2
    //   325: ldc_w 5368
    //   328: invokeinterface 830 2 0
    //   333: ifnull +42 -> 375
    //   336: aload 5
    //   338: aload_2
    //   339: ldc_w 5368
    //   342: invokeinterface 830 2 0
    //   347: iconst_0
    //   348: invokeinterface 841 2 0
    //   353: invokeinterface 847 1 0
    //   358: invokeinterface 850 1 0
    //   363: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 5
    //   369: bipush 124
    //   371: invokevirtual 956	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload_2
    //   376: ldc_w 5370
    //   379: invokeinterface 830 2 0
    //   384: ifnull +42 -> 426
    //   387: aload 5
    //   389: aload_2
    //   390: ldc_w 5370
    //   393: invokeinterface 830 2 0
    //   398: iconst_0
    //   399: invokeinterface 841 2 0
    //   404: invokeinterface 847 1 0
    //   409: invokeinterface 850 1 0
    //   414: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 5
    //   420: bipush 124
    //   422: invokevirtual 956	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_2
    //   427: ldc_w 5372
    //   430: invokeinterface 830 2 0
    //   435: ifnull +42 -> 477
    //   438: aload 5
    //   440: aload_2
    //   441: ldc_w 5372
    //   444: invokeinterface 830 2 0
    //   449: iconst_0
    //   450: invokeinterface 841 2 0
    //   455: invokeinterface 847 1 0
    //   460: invokeinterface 850 1 0
    //   465: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 5
    //   471: bipush 124
    //   473: invokevirtual 956	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload_2
    //   478: ldc_w 5374
    //   481: invokeinterface 830 2 0
    //   486: ifnull +42 -> 528
    //   489: aload 5
    //   491: aload_2
    //   492: ldc_w 5374
    //   495: invokeinterface 830 2 0
    //   500: iconst_0
    //   501: invokeinterface 841 2 0
    //   506: invokeinterface 847 1 0
    //   511: invokeinterface 850 1 0
    //   516: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload 5
    //   522: bipush 124
    //   524: invokevirtual 956	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload_2
    //   529: ldc_w 5376
    //   532: invokeinterface 830 2 0
    //   537: ifnull +42 -> 579
    //   540: aload 5
    //   542: aload_2
    //   543: ldc_w 5376
    //   546: invokeinterface 830 2 0
    //   551: iconst_0
    //   552: invokeinterface 841 2 0
    //   557: invokeinterface 847 1 0
    //   562: invokeinterface 850 1 0
    //   567: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload 5
    //   573: bipush 124
    //   575: invokevirtual 956	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload_2
    //   580: ldc_w 5378
    //   583: invokeinterface 830 2 0
    //   588: ifnull +60 -> 648
    //   591: aload_2
    //   592: ldc_w 5378
    //   595: invokeinterface 830 2 0
    //   600: iconst_0
    //   601: invokeinterface 841 2 0
    //   606: ifnull +42 -> 648
    //   609: aload 5
    //   611: aload_2
    //   612: ldc_w 5378
    //   615: invokeinterface 830 2 0
    //   620: iconst_0
    //   621: invokeinterface 841 2 0
    //   626: invokeinterface 847 1 0
    //   631: invokeinterface 850 1 0
    //   636: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 5
    //   642: bipush 124
    //   644: invokevirtual 956	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload_2
    //   649: ldc_w 5380
    //   652: invokeinterface 830 2 0
    //   657: ifnull +60 -> 717
    //   660: aload_2
    //   661: ldc_w 5380
    //   664: invokeinterface 830 2 0
    //   669: iconst_0
    //   670: invokeinterface 841 2 0
    //   675: ifnull +42 -> 717
    //   678: aload 5
    //   680: aload_2
    //   681: ldc_w 5380
    //   684: invokeinterface 830 2 0
    //   689: iconst_0
    //   690: invokeinterface 841 2 0
    //   695: invokeinterface 847 1 0
    //   700: invokeinterface 850 1 0
    //   705: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload 5
    //   711: bipush 124
    //   713: invokevirtual 956	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   716: pop
    //   717: aload_2
    //   718: ldc_w 5382
    //   721: invokeinterface 830 2 0
    //   726: ifnull +60 -> 786
    //   729: aload_2
    //   730: ldc_w 5382
    //   733: invokeinterface 830 2 0
    //   738: iconst_0
    //   739: invokeinterface 841 2 0
    //   744: ifnull +42 -> 786
    //   747: aload 5
    //   749: aload_2
    //   750: ldc_w 5382
    //   753: invokeinterface 830 2 0
    //   758: iconst_0
    //   759: invokeinterface 841 2 0
    //   764: invokeinterface 847 1 0
    //   769: invokeinterface 850 1 0
    //   774: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload 5
    //   780: bipush 124
    //   782: invokevirtual 956	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload_2
    //   787: ldc_w 5384
    //   790: invokeinterface 830 2 0
    //   795: ifnull +52 -> 847
    //   798: aload_2
    //   799: ldc_w 5384
    //   802: invokeinterface 830 2 0
    //   807: iconst_0
    //   808: invokeinterface 841 2 0
    //   813: ifnull +34 -> 847
    //   816: aload 5
    //   818: aload_2
    //   819: ldc_w 5384
    //   822: invokeinterface 830 2 0
    //   827: iconst_0
    //   828: invokeinterface 841 2 0
    //   833: invokeinterface 847 1 0
    //   838: invokeinterface 850 1 0
    //   843: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: aload_1
    //   848: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   851: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   854: aload 5
    //   856: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   859: invokestatic 5386	com/tencent/mobileqq/utils/SharedPreUtils:p	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   862: return
    //   863: astore_1
    //   864: new 78	java/lang/StringBuilder
    //   867: dup
    //   868: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   871: astore_2
    //   872: aload_2
    //   873: ldc_w 5388
    //   876: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: aload_2
    //   881: aload_1
    //   882: invokevirtual 893	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: ldc 92
    //   888: iconst_1
    //   889: aload_2
    //   890: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   893: invokestatic 533	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   896: return
    //   897: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq +12 -> 912
    //   903: ldc 92
    //   905: iconst_2
    //   906: ldc_w 5390
    //   909: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   912: aload_1
    //   913: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   916: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   919: invokestatic 5393	com/tencent/mobileqq/utils/SharedPreUtils:aQ	(Landroid/content/Context;Ljava/lang/String;)V
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
        int j = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(a, "key_tabs_config_version", Integer.valueOf(0))).intValue();
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
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "key_tabs_array", ((JSONArray)localObject3).toString());
                }
                localObject3 = ((JSONObject)localObject2).optJSONObject("werewolves");
                if (localObject3 != null) {
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "werewolves_config", ((JSONObject)localObject3).toString());
                }
                i = ((JSONObject)localObject2).optInt("AutoEnterWithoutReddot");
                if (localObject3 != null) {
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "key_auto_enter_without_redot", Integer.valueOf(i));
                }
                localObject3 = ((JSONObject)localObject2).optJSONObject("now_nearby");
                if (localObject3 != null)
                {
                  i = ((JSONObject)localObject3).optInt("match_secs");
                  j = ((JSONObject)localObject3).optInt("match_times");
                  k = ((JSONObject)localObject3).optInt("open_switch");
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "now_nearby_match_secs", Integer.valueOf(i));
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "now_nearby_match_times", Integer.valueOf(j));
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "now_nearby_1v1_open_switch", Integer.valueOf(k));
                }
                localObject3 = ((JSONObject)localObject2).optJSONArray("banner_items");
                if (localObject3 != null) {
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "key_banner_enter_items", ((JSONArray)localObject3).toString());
                } else {
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "key_banner_enter_items", "");
                }
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "key_tabs_config_version", Integer.valueOf(paramConfig.version.get()));
                i = ((JSONObject)localObject2).optInt("nearby_usercard_tab_host", 0);
                j = ((JSONObject)localObject2).optInt("nearby_usercard_tab_guest", -1);
                k = ((JSONObject)localObject2).optInt("nearby_usercard_publish", 0);
                int m = ((JSONObject)localObject2).optInt("face_score_switch", 0);
                paramConfig = ((JSONObject)localObject2).optString("mine_page_url");
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "nearby_usercard_tab_host", Integer.valueOf(i));
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "nearby_usercard_tab_guest", Integer.valueOf(j));
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "nearby_usercard_publish", Integer.valueOf(k));
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "face_score_switch", Integer.valueOf(m));
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "nearby_mine_page_url", paramConfig);
                i = ((JSONObject)localObject2).optInt("now_ip_conn_switch");
                ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "now_ip_conn_switch", Integer.valueOf(i));
                paramConfig = ((JSONObject)localObject2).optJSONObject("nearby_guide_config");
                if (paramConfig != null) {
                  ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(a, "cike_guide_content", paramConfig.toString());
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
    int j = SharedPreUtils.aH(paramQQAppInterface.getApp(), a);
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
    SharedPreUtils.o(paramQQAppInterface.getApp(), a, paramConfig);
    SharedPreUtils.G(paramQQAppInterface.getApp(), a, i);
  }
  
  /* Error */
  void u(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: ldc_w 5511
    //   6: iconst_1
    //   7: ldc_w 5513
    //   10: iconst_0
    //   11: anewarray 4	java/lang/Object
    //   14: invokestatic 551	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   17: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: aload_1
    //   21: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   24: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   27: invokestatic 1613	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   30: istore_3
    //   31: aload_2
    //   32: getfield 51	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   35: invokevirtual 57	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   38: istore 8
    //   40: iload_3
    //   41: iload 8
    //   43: if_icmpeq +450 -> 493
    //   46: new 242	java/util/HashSet
    //   49: dup
    //   50: invokespecial 243	java/util/HashSet:<init>	()V
    //   53: astore 10
    //   55: aload_2
    //   56: getfield 389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   59: ifnull +399 -> 458
    //   62: aload_2
    //   63: getfield 389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   66: invokevirtual 392	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   69: ifle +389 -> 458
    //   72: aload_2
    //   73: getfield 389	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   76: iconst_0
    //   77: invokevirtual 395	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   80: checkcast 397	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull +360 -> 445
    //   88: aload_2
    //   89: getfield 408	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   92: invokevirtual 1034	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   95: ifeq +350 -> 445
    //   98: aload_2
    //   99: getfield 401	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   102: invokevirtual 404	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   105: iconst_1
    //   106: if_icmpne +89 -> 195
    //   109: aload_2
    //   110: getfield 408	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   113: invokevirtual 413	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   116: invokevirtual 419	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   119: invokestatic 424	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	([B)[B
    //   122: astore 11
    //   124: aconst_null
    //   125: astore 9
    //   127: aload 9
    //   129: astore_2
    //   130: aload 11
    //   132: ifnull +74 -> 206
    //   135: new 126	java/lang/String
    //   138: dup
    //   139: aload 11
    //   141: ldc_w 426
    //   144: invokespecial 429	java/lang/String:<init>	([BLjava/lang/String;)V
    //   147: astore_2
    //   148: goto +58 -> 206
    //   151: astore_2
    //   152: new 78	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   159: astore 11
    //   161: aload 11
    //   163: ldc_w 5515
    //   166: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 11
    //   172: aload_2
    //   173: invokevirtual 893	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc_w 5511
    //   180: iconst_1
    //   181: aload 11
    //   183: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 533	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload 9
    //   191: astore_2
    //   192: goto +14 -> 206
    //   195: aload_2
    //   196: getfield 408	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   199: invokevirtual 413	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   202: invokevirtual 443	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   205: astore_2
    //   206: aload_2
    //   207: ifnull +273 -> 480
    //   210: new 128	org/json/JSONObject
    //   213: dup
    //   214: aload_2
    //   215: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   218: astore 9
    //   220: new 78	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   227: astore 11
    //   229: aload 11
    //   231: ldc_w 5517
    //   234: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 11
    //   240: aload_2
    //   241: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: ldc_w 5511
    //   248: iconst_1
    //   249: aload 11
    //   251: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload 9
    //   259: ldc_w 5519
    //   262: invokevirtual 141	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   265: istore_3
    //   266: aload 9
    //   268: ldc_w 5521
    //   271: invokevirtual 141	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   274: istore 4
    //   276: aload 9
    //   278: ldc_w 5523
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
    //   329: invokevirtual 5524	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   332: checkcast 128	org/json/JSONObject
    //   335: ldc_w 5526
    //   338: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   341: astore 9
    //   343: aload 9
    //   345: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   348: ifne +13 -> 361
    //   351: aload 10
    //   353: aload 9
    //   355: invokeinterface 4761 2 0
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
    //   384: new 78	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   391: astore 9
    //   393: aload 9
    //   395: ldc_w 5411
    //   398: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 9
    //   404: aload_2
    //   405: invokevirtual 893	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: ldc_w 5511
    //   412: iconst_1
    //   413: aload 9
    //   415: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 533	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: iload 4
    //   423: istore 5
    //   425: iload_3
    //   426: istore 6
    //   428: aload_1
    //   429: invokestatic 5529	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager;
    //   432: aload_1
    //   433: iload 6
    //   435: iload 5
    //   437: aload 10
    //   439: invokevirtual 5532	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   442: goto +38 -> 480
    //   445: ldc_w 5511
    //   448: iconst_1
    //   449: ldc_w 5534
    //   452: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: goto +25 -> 480
    //   458: ldc_w 5511
    //   461: iconst_1
    //   462: ldc_w 5536
    //   465: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aload_1
    //   469: invokestatic 5529	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager;
    //   472: aload_1
    //   473: iconst_0
    //   474: iconst_0
    //   475: aload 10
    //   477: invokevirtual 5532	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   480: aload_1
    //   481: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   484: getstatic 65	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	Ljava/lang/String;
    //   487: iload 8
    //   489: invokestatic 5537	com/tencent/mobileqq/activity/aio/photo/PhotoListConfigManager:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   492: return
    //   493: ldc_w 5511
    //   496: iconst_1
    //   497: ldc_w 5539
    //   500: iconst_1
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: iload_3
    //   507: invokestatic 547	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   510: aastore
    //   511: invokestatic 551	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   514: invokestatic 533	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    int i = SharedPreUtils.aL(paramQQAppInterface.getApp(), a);
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
      SharedPreUtils.I(paramQQAppInterface.getApp(), a, j);
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
      ((TimUpgradeHongdianManager)paramQQAppInterface.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER)).b();
      label421:
      return;
      label422:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet
 * JD-Core Version:    0.7.0.1
 */