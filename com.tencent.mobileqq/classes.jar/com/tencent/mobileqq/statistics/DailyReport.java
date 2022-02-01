package com.tencent.mobileqq.statistics;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.wifi.WifiManager;
import android.opengl.ETC1Util;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.tencent.av.business.manager.pendant.AVEffectPendantReport;
import com.tencent.av.redpacket.AVRedPacketDataCollector;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloDress;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageReportData;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.download.unite.core.UniteDownloadDbOperator;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.pic.PicReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.statistics.cpu.CPUReport;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.repoter.ReporterMachine;
import com.tencent.qqperf.repoter.ResultObject;
import com.tencent.theme.SkinEngine;
import com.tencent.util.AutoSaveUtils;
import com.tencent.util.BadgeUtils;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class DailyReport
  extends AsyncStep
{
  private static int d = 50000;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new DailyReport.1(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  
  private static String a(Context paramContext)
  {
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = (InputMethodManager)paramContext.getSystemService("input_method");
    try
    {
      localObject = ((InputMethodManager)localObject).getInputMethodList();
      int i;
      if (localObject == null) {
        i = 0;
      }
      while (j < i)
      {
        localStringBuffer.append(((InputMethodInfo)((List)localObject).get(j)).loadLabel(paramContext.getPackageManager()));
        localStringBuffer.append(';');
        j += 1;
        continue;
        i = ((List)localObject).size();
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      paramContext = localStringBuffer.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static Set<Integer> a()
  {
    List localList = ((SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor")).getSensorList(-1);
    HashSet localHashSet = new HashSet();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        Sensor localSensor = (Sensor)localList.get(i);
        if (localSensor != null) {
          localHashSet.add(Integer.valueOf(localSensor.getType()));
        }
        i += 1;
      }
    }
    return localHashSet;
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.getApp().getApplicationContext();
    try
    {
      String str = Settings.Secure.getString(((Context)localObject).getContentResolver(), "default_input_method");
      localObject = a((Context)localObject);
      ReportController.b(paramQQAppInterface, "CliOper", "", paramQQAppInterface.getCurrentAccountUin(), "Type_input", "Type_input", 0, 0, "", "", str, (String)localObject);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("MainActivityReportHelper", 1, "reportIMEInfo fail", paramQQAppInterface);
    }
  }
  
  private void a(String paramString)
  {
    int i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_op4dongtai");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Clk_data_wire_in", 8, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_op4buddylist");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Clk_data_wire_in", 21, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_op4recent");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Clk_data_wire_in", 22, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckpic");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_pic", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckvideo");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_video", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckfile");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_file", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_cktxt");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_text", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_cktkphoto");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_photo", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_copy");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Long_press_copy", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forward");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Long_press_retran", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_delete");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Long_press_delete", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_save2weiyun");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Long_press_weiyun", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckadv");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "data_wire_setting", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckviewrecvfile");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Chkfiles_data_wire", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckclearmsg");
    if (i > 0) {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Clean_data_wire", 0, i, 0);
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("auto_receive_files", false);
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    HashMap localHashMap = new HashMap();
    localHashMap.clear();
    if (bool) {}
    for (i = 1;; i = 0)
    {
      localHashMap.put("auto_receive_files", Integer.valueOf(i));
      localStatisticCollector.reportOnOff(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, localHashMap);
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forwardin_text");
      if (i > 0) {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Retran_text", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forwardin_image");
      if (i > 0) {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Retran_pic", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forwardin_file");
      if (i > 0) {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Retran_file", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forwardin_link");
      if (i > 0) {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Retran_link", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_open_via_qq");
      if (i > 0) {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Open_via_qq", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_share_my_pc");
      if (i > 0) {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "share_my_PC", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_share_frd");
      if (i > 0) {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "share_frd", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "Clk_disconnect_wp");
      if (i > 0) {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "Wifiphoto", "Clk_disconnect_wp", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "Clk_wp_back");
      if (i > 0) {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "Wifiphoto", "Clk_wp_back", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "Open_wp");
      if (i > 0) {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "Wifiphoto", "Open_wp", 0, i, 0);
      }
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str2 = UserAction.getQIMEI();
    if (paramQQAppInterface.isLogin()) {}
    for (String str1 = "0";; str1 = "1")
    {
      ReportController.b(paramQQAppInterface, "0X800AAA1", "0X800AAA1", "0X800AAA1", "", 0, "", str2, str1, "", "", "", "", "", "");
      return;
    }
  }
  
  private static void b(String paramString)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (((SharedPreferences)localObject).getBoolean("hasReportDeviceProfile", false)) {
      return;
    }
    ((SharedPreferences)localObject).edit().putBoolean("hasReportDeviceProfile", true);
    localObject = new HashMap();
    int i = (int)Math.min(DeviceInfoUtil.j(), DeviceInfoUtil.i());
    int j = DeviceInfoUtil.b() * 100 + d;
    if (i <= 240) {
      i = j + 1;
    }
    for (;;)
    {
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString, "reportDeviceProfile", false, 0L, 0L, (HashMap)localObject, "");
      return;
      if (i <= 320) {
        i = j + 2;
      } else if (i <= 480) {
        i = j + 3;
      } else if (i <= 640) {
        i = j + 4;
      } else if (i <= 720) {
        i = j + 5;
      } else if (i <= 1080) {
        i = j + 6;
      } else {
        i = j + 7;
      }
    }
  }
  
  private void c(StatisticCollector paramStatisticCollector)
  {
    HashMap localHashMap = new HashMap();
    int i = 89050;
    if (SkinEngine.IS_PROBLEM_MIUI)
    {
      localHashMap.put("param_FailCode", Integer.toString(i));
      if ((!BaseApplicationImpl.IS_SUPPORT_THEME) || (SkinEngine.IS_PROBLEM_MIUI)) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "report_skin_engine_enable", bool, 0L, 0L, localHashMap, "");
      return;
      i = 89051;
      break;
    }
  }
  
  private void d(StatisticCollector paramStatisticCollector)
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.sApplication.getSystemService("activity");
    HashMap localHashMap = new HashMap();
    int i = localActivityManager.getMemoryClass();
    localHashMap.put("param_FailCode", Integer.toString(89000 + i));
    paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "report_mem_cache_size", false, i, 0L, localHashMap, "");
  }
  
  private void e()
  {
    int j;
    label24:
    int k;
    label45:
    int m;
    label58:
    Object localObject;
    int n;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getALLGeneralSettingRing() != 0)
    {
      i = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getALLGeneralSettingVibrate() == 0) {
        break label673;
      }
      j = 1;
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopGeneralSettingRing() != 0) {
        break label678;
      }
      k = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopGeneralSettingVibrate() != 0) {
        break label683;
      }
      m = 0;
      boolean bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), null, "new_msg_notification_key", true);
      boolean bool3 = QQNotificationManager.getInstance().groupChannelVibrateOn();
      boolean bool4 = QQNotificationManager.getInstance().c2cChannelVibrateOn();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, new Object[] { "reportMessageNotificationSettings: invoked. ", " groupChannelVibrateOn: ", Boolean.valueOf(bool3), " c2cChannelVibrateOn: ", Boolean.valueOf(bool4) });
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (j == 0) {
        break label689;
      }
      n = 1;
      label162:
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800AD3B", "0X800AD3B", n, 0, "", "", "", "");
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (m == 0) {
        break label695;
      }
      n = 1;
      label205:
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800AD3C", "0X800AD3C", n, 0, "", "", "", "");
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (i == 0) {
        break label701;
      }
      localObject = "1";
      label249:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A3CF", "0X800A3CF", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (j == 0) {
        break label709;
      }
      localObject = "1";
      label292:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A3D0", "0X800A3D0", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool1) {
        break label717;
      }
      localObject = "1";
      label336:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A3CE", "0X800A3CE", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (m == 0) {
        break label725;
      }
      localObject = "1";
      label380:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A3D1", "0X800A3D1", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (k == 0) {
        break label733;
      }
      localObject = "1";
      label423:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A3D2", "0X800A3D2", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool2) {
        break label741;
      }
      localObject = "1";
      label467:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A512", "0X800A512", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!AutoSaveUtils.a(true)) {
        break label749;
      }
      localObject = "1";
      label513:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A6E8", "0X800A6E8", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!AutoSaveUtils.a(false)) {
        break label757;
      }
      localObject = "1";
      label559:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A6E9", "0X800A6E9", 0, 0, (String)localObject, "", "", "");
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool3) {
        break label765;
      }
      i = 1;
      label600:
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X800AC8B", "0X800AC8B", i, 0, "", "", "", "");
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool4) {
        break label770;
      }
    }
    label770:
    for (int i = 1;; i = 2)
    {
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X800AC8C", "0X800AC8C", i, 0, "", "", "", "");
      return;
      i = 0;
      break;
      label673:
      j = 0;
      break label24;
      label678:
      k = 1;
      break label45;
      label683:
      m = 1;
      break label58;
      label689:
      n = 2;
      break label162;
      label695:
      n = 2;
      break label205;
      label701:
      localObject = "2";
      break label249;
      label709:
      localObject = "2";
      break label292;
      label717:
      localObject = "2";
      break label336;
      label725:
      localObject = "2";
      break label380;
      label733:
      localObject = "2";
      break label423;
      label741:
      localObject = "2";
      break label467;
      label749:
      localObject = "2";
      break label513;
      label757:
      localObject = "2";
      break label559;
      label765:
      i = 2;
      break label600;
    }
  }
  
  private void e(StatisticCollector paramStatisticCollector)
  {
    if (paramStatisticCollector == null) {
      return;
    }
    for (;;)
    {
      try
      {
        boolean bool = ETC1Util.isETC1Supported();
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_manufacture", Build.MANUFACTURER);
        localHashMap.put("param_model", Build.MODEL);
        if (bool)
        {
          String str1 = String.valueOf(1);
          localHashMap.put("param_etc1supported", str1);
          paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arOpenGLSupport", bool, 0L, 0L, localHashMap, "");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DailyReport", 2, "reportOpenglSupport", localThrowable);
        }
        paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arOpenGLSupport", false, 0L, 0L, null, "");
        return;
      }
      String str2 = String.valueOf(0);
    }
  }
  
  private void f()
  {
    Object localObject = StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QQAppInterface localQQAppInterface;
    if (localObject != null)
    {
      boolean bool = ((StickerRecManager)localObject).b();
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool) {
        break label57;
      }
    }
    label57:
    for (localObject = "1";; localObject = "2")
    {
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A224", "0X800A224", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
  
  private void f(StatisticCollector paramStatisticCollector)
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        Set localSet = a();
        localHashMap.put("param_manufacture", Build.MANUFACTURER);
        localHashMap.put("param_model", Build.MODEL);
        if ((localSet.contains(Integer.valueOf(1))) && (localSet.contains(Integer.valueOf(2))) && (localSet.contains(Integer.valueOf(4))))
        {
          String str1 = "1";
          localHashMap.put("param_sensor_all3", str1);
          if (!localSet.contains(Integer.valueOf(1))) {
            break label591;
          }
          str1 = "1";
          localHashMap.put("param_sensor_accl", str1);
          if (!localSet.contains(Integer.valueOf(4))) {
            break label598;
          }
          str1 = "1";
          localHashMap.put("param_sensor_gyro", str1);
          if (!localSet.contains(Integer.valueOf(16))) {
            break label605;
          }
          str1 = "1";
          localHashMap.put("param_sensor_gyro_uncalibrated", str1);
          if (!localSet.contains(Integer.valueOf(2))) {
            break label612;
          }
          str1 = "1";
          localHashMap.put("param_sensor_magnet", str1);
          if (!localSet.contains(Integer.valueOf(14))) {
            break label619;
          }
          str1 = "1";
          localHashMap.put("param_sensor_magnet_uncalibrated", str1);
          if ((!localSet.contains(Integer.valueOf(1))) || (!localSet.contains(Integer.valueOf(4)))) {
            break label626;
          }
          str1 = "1";
          localHashMap.put("param_sensor_accl_gyro", str1);
          if ((!localSet.contains(Integer.valueOf(1))) || (!localSet.contains(Integer.valueOf(2)))) {
            break label633;
          }
          str1 = "1";
          localHashMap.put("param_sensor_accl_magnet", str1);
          if ((!localSet.contains(Integer.valueOf(4))) || (!localSet.contains(Integer.valueOf(2)))) {
            break label640;
          }
          str1 = "1";
          localHashMap.put("param_sensor_gyro_magnet", str1);
          if (!localSet.contains(Integer.valueOf(3))) {
            break label647;
          }
          str1 = "1";
          localHashMap.put("param_sensor_orientation", str1);
          if (!localSet.contains(Integer.valueOf(11))) {
            break label654;
          }
          str1 = "1";
          localHashMap.put("param_sensor_rotation", str1);
          if (!localSet.contains(Integer.valueOf(15))) {
            break label661;
          }
          str1 = "1";
          localHashMap.put("param_sensor_rotation_game", str1);
          if (!localSet.contains(Integer.valueOf(20))) {
            break label668;
          }
          str1 = "1";
          localHashMap.put("param_sensor_rotation_geomagnet", str1);
          if (!localSet.contains(Integer.valueOf(9))) {
            break label675;
          }
          str1 = "1";
          localHashMap.put("param_sensor_gravity", str1);
          if (localSet.contains(Integer.valueOf(10)))
          {
            str1 = "1";
            localHashMap.put("param_sensor_linear_accl", str1);
            paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arSensorSupport", true, 0L, 0L, localHashMap, "");
            return;
          }
          str1 = "0";
          continue;
        }
        str2 = "0";
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DailyReport", 2, "reportSensorSupport", localException);
        }
        paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arSensorSupport", false, 0L, 0L, null, "");
        return;
      }
      continue;
      label591:
      String str2 = "0";
      continue;
      label598:
      str2 = "0";
      continue;
      label605:
      str2 = "0";
      continue;
      label612:
      str2 = "0";
      continue;
      label619:
      str2 = "0";
      continue;
      label626:
      str2 = "0";
      continue;
      label633:
      str2 = "0";
      continue;
      label640:
      str2 = "0";
      continue;
      label647:
      str2 = "0";
      continue;
      label654:
      str2 = "0";
      continue;
      label661:
      str2 = "0";
      continue;
      label668:
      str2 = "0";
      continue;
      label675:
      str2 = "0";
    }
  }
  
  private void g()
  {
    HashMap localHashMap = new HashMap();
    int i = StatisticTroopAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("Click_grp_asst", Integer.valueOf(i));
    }
    i = StatisticTroopAssist.b(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_setting_asst", Integer.valueOf(i));
    }
    i = StatisticTroopAssist.c(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_setting_msg", Integer.valueOf(i));
    }
    i = StatisticTroopAssist.d(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_msg_equ", Integer.valueOf(i));
    }
    i = StatisticTroopAssist.e(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_msg_dec", Integer.valueOf(i));
    }
    i = StatisticTroopAssist.f(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_msg_inc", Integer.valueOf(i));
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).reportCustomSet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localHashMap);
  }
  
  private void h()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    int i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "ep_tab");
    if (i > 0) {
      localStatisticCollector.reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "ep_tab", 1, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "ep_mall_in2");
    if (i > 0) {
      localStatisticCollector.reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "ep_mall_in", 2, i, 0);
    }
    Object localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
    if (localObject != null)
    {
      localObject = ((EmoticonManager)localObject).a();
      if (localObject == null) {}
    }
    for (i = ((List)localObject).size();; i = 0)
    {
      localObject = new HashMap();
      ((Map)localObject).put("Ep_amount", Integer.valueOf(i));
      localStatisticCollector.reportOnOff(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, (Map)localObject);
      i = 0;
      while (i < 3)
      {
        int j = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "ep_tab2" + i);
        localStatisticCollector.reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "ep_tab2", 0, j, 0, i);
        i += 1;
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "Ep_manage");
      if (i > 0) {
        localStatisticCollector.reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "Ep_manage", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "Clk_ep_edit");
      if (i > 0) {
        localStatisticCollector.reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "Clk_ep_edit", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "Delete_ep");
      if (i > 0) {
        localStatisticCollector.reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "Delete_ep", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "Ep_order");
      if (i > 0) {
        localStatisticCollector.reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "Ep_order", 0, i, 0);
      }
      return;
    }
  }
  
  private void i()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject2 != null)
    {
      localObject1 = ((FriendsManager)localObject2).a((String)localObject1);
      if ((localObject1 != null) && (((ExtensionInfo)localObject1).isPendantValid())) {}
    }
    else
    {
      return;
    }
    File localFile = new File(AvatarPendantUtil.b(((ExtensionInfo)localObject1).pendantId, 4));
    if (!localFile.exists())
    {
      localObject2 = (DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
      String str = AvatarPendantUtil.c(((ExtensionInfo)localObject1).pendantId, 4);
      Bundle localBundle = new Bundle();
      localBundle.putLong("id", ((ExtensionInfo)localObject1).pendantId);
      localObject1 = new DownloadTask(str, localFile);
      ((DownloaderFactory)localObject2).a(1).a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
      return;
    }
    localObject2 = AvatarPendantUtil.a(localFile);
    VasWebviewUtil.reportVasStatus("AvatarPendant", "AvatarPendantOn", String.valueOf(((ExtensionInfo)localObject1).pendantId), 0, 0, 0, 0, (String)localObject2, "");
  }
  
  private void j()
  {
    List localList = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a();
    String str = "";
    Object localObject = str;
    int i;
    if (localList != null)
    {
      i = 0;
      localObject = str;
      if (i < localList.size())
      {
        localObject = (EmoticonPackage)localList.get(i);
        if ((3 != ((EmoticonPackage)localObject).jobType) && (5 != ((EmoticonPackage)localObject).jobType)) {
          break label143;
        }
        if (str.equals("")) {
          str = ((EmoticonPackage)localObject).epId;
        }
      }
    }
    label143:
    for (;;)
    {
      i += 1;
      break;
      str = str + "|" + ((EmoticonPackage)localObject).epId;
      continue;
      VasWebviewUtil.reportVasStatus("MbBaoyou", "MbBaoyouID", "0", 0, 0, 0, 0, (String)localObject, "");
      return;
    }
  }
  
  private void k()
  {
    String str3 = ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).c(null);
    String str2;
    String str1;
    if (str3.equals("custom"))
    {
      str2 = "0X8004E10";
      str1 = "0X8004E10";
    }
    for (;;)
    {
      VasWebviewUtil.reportVasStatus(str2, str1, str3, 0, 0);
      return;
      str1 = "0X8004E0F";
      str2 = "0X8004E0F";
    }
  }
  
  private void l()
  {
    VasWebviewUtil.reportVasStatus("0X800498F", "0X800498F", ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g(), 0);
  }
  
  private void m()
  {
    SVIPHandler localSVIPHandler = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
    VasWebviewUtil.reportVasStatus("0X8004990", "0X8004990", String.valueOf(localSVIPHandler.b()), localSVIPHandler.g(), 0);
  }
  
  private void n()
  {
    boolean bool1 = ((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.chat_font.name());
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("font_open_switch", 0).getBoolean("isUserOpenFontSwitch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
    int i;
    if (bool1) {
      i = 2;
    }
    for (;;)
    {
      VasWebviewUtil.reportVasStatus("font_switch", "switch_on", "0", 0, 0, i, 0, "", "");
      return;
      if (bool2) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  private void o()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sticker_pref", 0).getBoolean("sticker_switch_" + str, true)) && (EmojiStickerManager.a())) {}
    for (boolean bool = true;; bool = false)
    {
      EmojiStickerManager.f = bool;
      if (!EmojiStickerManager.f) {
        break;
      }
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "SwitchOn", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
    }
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "SwitchOff", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  private void p()
  {
    Object localObject1 = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (localObject1 != null)
    {
      Object localObject2 = ((IApolloManagerService)localObject1).getApolloBaseInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      int i;
      int j;
      if ((localObject2 != null) && (((ApolloBaseInfo)localObject2).apolloStatus == 1))
      {
        Object localObject3 = ((ApolloBaseInfo)localObject2).getApolloDress();
        i = 0;
        StringBuilder localStringBuilder = new StringBuilder();
        if (localObject3 != null)
        {
          int k = ((ApolloDress)localObject3).roleId;
          localObject3 = ((ApolloDress)localObject3).getDressIds();
          int m = localObject3.length;
          j = 0;
          for (;;)
          {
            i = k;
            if (j >= m) {
              break;
            }
            localStringBuilder.append(localObject3[j]).append("|");
            j += 1;
          }
        }
        j = ((IApolloManagerService)localObject1).getApolloUserStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "dress", 0, 0, i + "", ((ApolloBaseInfo)localObject2).apolloVipFlag + "", localStringBuilder.toString(), String.valueOf(j + 1));
      }
      for (;;)
      {
        if ((((IApolloManagerService)localObject1).getWhiteListStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) && (localObject2 != null)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "white", 0, 0, ((ApolloBaseInfo)localObject2).apolloStatus + "", "0", "", "");
        }
        localObject1 = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        if (localObject1 == null) {
          break;
        }
        localObject2 = ((IApolloDaoManagerService)localObject1).getFavActionList();
        if (localObject2 != null) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "action_added", ((List)localObject2).size(), 0, "0", "0", "", "");
        }
        localObject1 = ((IApolloDaoManagerService)localObject1).getApolloGameVer();
        if ((localObject1 == null) || (((ConcurrentHashMap)localObject1).isEmpty())) {
          break;
        }
        localObject1 = ((ConcurrentHashMap)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          try
          {
            i = (int)Float.parseFloat((String)((Map.Entry)localObject2).getValue());
            j = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "game_downloaded", 0, 0, String.valueOf(j), String.valueOf(i), "", "");
          }
          catch (Exception localException) {}
        }
        if ((localException != null) && (localException.apolloStatus == 2)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "close", 0, 0, "0", "0", "", "");
        }
      }
    }
  }
  
  private void q()
  {
    Object localObject = (PhoneUnityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
    QQAppInterface localQQAppInterface;
    if (((PhoneUnityManager)localObject).d)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((PhoneUnityManager)localObject).a()) {
        break label64;
      }
    }
    label64:
    for (localObject = "1";; localObject = "0")
    {
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8005B8B", "0X8005B8B", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
  
  private void r()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    QQAppInterface localQQAppInterface;
    if (localEntityManager != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      if (localNearbyPeopleCard != null)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!localNearbyPeopleCard.switchHobby) {
          break label140;
        }
        str = "1";
        ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8004A12", "0X8004A12", 0, 0, str, "", "", "");
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!localNearbyPeopleCard.switchQzone) {
          break label147;
        }
      }
    }
    label140:
    label147:
    for (String str = "1";; str = "0")
    {
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8004A13", "0X8004A13", 0, 0, str, "", "", "");
      localEntityManager.close();
      return;
      str = "0";
      break;
    }
  }
  
  private void s()
  {
    Object localObject3 = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/mobileqq/netflow/";
    File localFile = new File((String)localObject3);
    JSONObject localJSONObject = null;
    int m = 0;
    int k = 0;
    if (!localFile.exists()) {}
    float f;
    label133:
    int j;
    label637:
    do
    {
      return;
      int i;
      try
      {
        localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.batteryCfg.name());
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("#")))
        {
          localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf("#") + 1, ((String)localObject1).length());
          f = Float.parseFloat(localObject1.split(";")[1]);
          j = m;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject2;
          for (;;)
          {
            Object localObject1;
            if (Math.random() <= f)
            {
              j = m;
              localObject1 = localFile.listFiles();
              j = m;
              ArrayList localArrayList = new ArrayList();
              if (localObject1 != null)
              {
                j = m;
                if (localObject1.length > 0)
                {
                  j = m;
                  int n = localObject1.length;
                  i = 0;
                  for (;;)
                  {
                    if (i < n)
                    {
                      j = m;
                      String str = localObject1[i].getAbsolutePath();
                      if (str != null)
                      {
                        j = m;
                        if (str.endsWith(".log"))
                        {
                          j = m;
                          localArrayList.add(str);
                        }
                      }
                      i += 1;
                      continue;
                      localObject1 = "0.02;0.000025";
                      break;
                      localException1 = localException1;
                      if (QLog.isColorLevel()) {
                        QLog.d("DailyReport", 2, "reportNetflowData get default config!");
                      }
                      f = 2.5E-005F;
                      break label133;
                    }
                  }
                }
              }
              localObject2 = localJSONObject;
              i = k;
              j = m;
              if (localArrayList.size() > 0)
              {
                j = m;
                if (localArrayList.size() >= 5) {
                  break label637;
                }
                j = m;
                localObject2 = (String)localObject3 + "netflow_" + System.currentTimeMillis() + ".zip";
                j = m;
                if (FileUtils.a(localArrayList, (String)localObject2))
                {
                  j = m;
                  localObject2 = new File((String)localObject2);
                  j = m;
                  boolean bool = ((File)localObject2).exists();
                  if (!bool) {
                    localObject2 = null;
                  }
                  i = k;
                }
              }
              else
              {
                if (localObject2 == null) {
                  break label701;
                }
              }
            }
          }
          for (;;)
          {
            try
            {
              for (;;)
              {
                localJSONObject = new JSONObject();
                localObject3 = new JSONObject();
                ((JSONObject)localObject3).put("fileObj1", ((File)localObject2).getAbsolutePath());
                localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("p_id", MagnifierSDK.b());
                ((JSONObject)localObject2).put("plugin", String.valueOf(17));
                localJSONObject.put("fileObj", localObject3);
                localJSONObject.put("clientinfo", localObject2);
                localJSONObject.put("newplugin", 104);
                long l2 = 0L;
                try
                {
                  for (;;)
                  {
                    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
                    ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, localJSONObject, true, true, l1));
                    i = 1;
                    j = i;
                    if (i <= 0) {
                      break label735;
                    }
                    try
                    {
                      localObject2 = localFile.listFiles();
                      j = i;
                      if (localObject2 == null) {
                        break label735;
                      }
                      j = i;
                      if (localObject2.length <= 0) {
                        break label735;
                      }
                      m = localObject2.length;
                      k = 0;
                      for (;;)
                      {
                        j = i;
                        if (k >= m) {
                          break;
                        }
                        localObject2[k].delete();
                        k += 1;
                      }
                      j = m;
                      if (QLog.isColorLevel())
                      {
                        j = m;
                        QLog.d("DailyReport", 2, "reportNetflowData zip fail!");
                      }
                      localObject2 = null;
                    }
                    catch (Exception localException5)
                    {
                      break label713;
                    }
                  }
                  i = 3;
                  localObject2 = localJSONObject;
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    l1 = l2;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("DailyReport", 2, "reportNetflowData parse uin fail!", localException2);
                      l1 = l2;
                    }
                  }
                }
              }
              continue;
            }
            catch (Exception localException3)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                j = i;
                QLog.d("DailyReport", 2, "reportNetflowData report fail!", localException3);
              }
            }
            i = 2;
          }
          j = i;
        }
        catch (Exception localException4)
        {
          i = j;
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.d("DailyReport", 2, "reportNetflowData error occur!", localException4);
        j = i;
      }
    } while (!QLog.isColorLevel());
    label701:
    label713:
    label735:
    QLog.d("DailyReport", 2, "reportNetflowData finish! reportResult:" + j + " ,sample:" + f);
  }
  
  private void t()
  {
    Map localMap = ((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((Boolean)localMap.get("temp_msg_setting_troop_")).booleanValue())
    {
      str = "1";
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 1, 1, str, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((Boolean)localMap.get("temp_msg_setting_nearby_")).booleanValue()) {
        break label455;
      }
      str = "1";
      label97:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 2, 2, str, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((Boolean)localMap.get("temp_msg_setting_interest_v2")).booleanValue()) {
        break label462;
      }
      str = "1";
      label150:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 3, 3, str, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((Boolean)localMap.get("temp_msg_setting_contact_")).booleanValue()) {
        break label469;
      }
      str = "1";
      label203:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 4, 4, str, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((Boolean)localMap.get("temp_msg_setting_consult_")).booleanValue()) {
        break label476;
      }
      str = "1";
      label256:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 5, 5, str, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((Boolean)localMap.get("temp_msg_setting_circle_v2")).booleanValue()) {
        break label483;
      }
      str = "1";
      label309:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 6, 6, str, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((Boolean)localMap.get("temp_msg_setting_game_buddy_")).booleanValue()) {
        break label490;
      }
      str = "1";
      label364:
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 7, 7, str, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((Boolean)localMap.get("temp_msg_setting_audio_room")).booleanValue()) {
        break label497;
      }
    }
    label455:
    label462:
    label469:
    label476:
    label483:
    label490:
    label497:
    for (String str = "1";; str = "0")
    {
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 8, 8, str, "", "", "");
      return;
      str = "0";
      break;
      str = "0";
      break label97;
      str = "0";
      break label150;
      str = "0";
      break label203;
      str = "0";
      break label256;
      str = "0";
      break label309;
      str = "0";
      break label364;
    }
  }
  
  private void u()
  {
    if (!ScreenShotDetector.b()) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B4E6", "0X800B4E6", 0, 0, "", "", "", "");
    }
  }
  
  public int a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("mobileQQ", 0);
    long l1 = localSharedPreferences.getLong("LastTimeLogin_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0L);
    long l2 = System.currentTimeMillis() - 10L;
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(l1);
    localCalendar2.add(5, 1);
    localCalendar2.clear(10);
    localCalendar2.clear(12);
    localCalendar2.clear(13);
    localCalendar2.clear(14);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).add(5, 1);
    ((Calendar)localObject1).clear(10);
    ((Calendar)localObject1).clear(12);
    ((Calendar)localObject1).clear(13);
    ((Calendar)localObject1).clear(14);
    Object localObject3;
    Object localObject4;
    StatisticCollector localStatisticCollector;
    if ((((Calendar)localObject1).getTimeInMillis() - l2 - 100L >= 0L) || ((l1 > 0L) && (localCalendar1.after(localCalendar2))))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QQSettingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      NotifyPushSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      r();
      g();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      a((String)localObject3);
      localObject4 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      localStatisticCollector = StatisticCollector.getInstance((Context)localObject4);
    }
    label757:
    label1781:
    for (;;)
    {
      int j;
      int i;
      Object localObject2;
      try
      {
        h();
        i();
        j();
        k();
        l();
        m();
        n();
        p();
        q();
        AVRedPacketDataCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        AVRedPacketDataCollector.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        o();
        localObject1 = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
        if ((localObject1 != null) && (((MessageRoamManager)localObject1).h()))
        {
          if (((MessageRoamManager)localObject1).b() == 1)
          {
            localObject1 = "devlock";
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "auth_mode", 1, 0, new String[] { "0", "0", localObject1 });
          }
        }
        else
        {
          Object localObject5 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          localObject1 = null;
          if (localObject5 != null) {
            localObject1 = ((FriendsManager)localObject5).a((String)localObject3);
          }
          if (localObject1 != null) {
            VasWebviewUtil.reportVasStatus("FontStatus", "FontOn", String.valueOf(((ExtensionInfo)localObject1).uVipFont), 0, 0);
          }
          if (localObject1 != null)
          {
            j = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
            if (j != 2) {
              continue;
            }
            i = 0;
            VasWebviewUtil.reportVasStatus("0X8004A26", "0X8004A26", String.valueOf(((ExtensionInfo)localObject1).colorRingId), i, 0);
          }
          i = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
          if (localObject1 != null) {
            VasWebviewUtil.reportVasStatus("0X8005005", "0X8005005", String.valueOf(((ExtensionInfo)localObject1).commingRingId), i, 0);
          }
          j = VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 6, true, null);
          if (i != 2) {
            break label757;
          }
          i = 0;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "funcallnew", "setfuncall", 0, 0, String.valueOf(j), String.valueOf(i), String.valueOf(NetworkUtil.a(null)), "1");
          localObject1 = StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localObject1 == null) {
            break label767;
          }
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label767;
          }
          localObject5 = (MessageReportData)((Iterator)localObject1).next();
          if (((MessageReportData)localObject5).msgCount <= 0) {
            continue;
          }
          localStatisticCollector.reportActionCountMsgOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageReportData)localObject5).getMsgReport());
          continue;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DailyReport", 2, "reportAioEmotionData", localException);
        continue;
        localObject2 = "password";
        continue;
        i = j;
        if (j != 3) {
          continue;
        }
        i = 2;
        continue;
      }
      if (i == 3)
      {
        i = 2;
        continue;
        label767:
        i = QQSettingUtil.a((Context)localObject4, (String)localObject3);
        if (i > 0) {
          StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Setting_Quit", i);
        }
        i = NotifyPushSettingActivity.a((Context)localObject4, (String)localObject3, "LED_light");
        localObject2 = new HashMap();
        ((HashMap)localObject2).clear();
        ((HashMap)localObject2).put("LED_light", Integer.valueOf(i));
        localStatisticCollector.reportOnOff(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, (Map)localObject2);
        boolean bool;
        if (BadgeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))
        {
          bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, null, null, "qqsetting_show_badgeunread_key", true);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (bool)
          {
            localObject2 = "1";
            ReportController.b((AppRuntime)localObject4, "CliStatus", "", "", "0X8004BE8", "0X8004BE8", 0, 0, (String)localObject2, "", "", "");
          }
        }
        else
        {
          PicReporter.a();
          i = ThemeUtil.getThemeSwitchTimes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (i > 0) {
            localStatisticCollector.reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, "", "theme_mall", "theme_replace", 0, i, 0);
          }
          i = ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if (i > 0) {
            localStatisticCollector.reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, "", "background", "bkground_replace", 0, i, 0);
          }
          bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getString(2131693883), "qqsetting_lock_screen_whenexit_key", true);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (!Boolean.valueOf(bool).booleanValue()) {
            break label1731;
          }
        }
        for (localObject2 = "1";; localObject2 = "0")
        {
          ReportController.b((AppRuntime)localObject3, "CliStatus", "", "", "0X80040D9", "0X80040D9", 0, 0, (String)localObject2, "", "", "");
          d(localStatisticCollector);
          c(localStatisticCollector);
          try
          {
            if (Build.VERSION.SDK_INT < 19) {
              break label1439;
            }
            localObject3 = new HashMap();
            i = QQAppInterface.isNotificationEnabled();
            ((HashMap)localObject3).put("notifationStat", String.valueOf(i));
            ((HashMap)localObject3).put("uinParam", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localObject2 = DeviceInfoUtil.j();
            if (localObject2 != null) {
              break label1794;
            }
            localObject2 = "";
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              int k;
              int m;
              if (QLog.isColorLevel())
              {
                QLog.d("StatisticCollector", 2, "msg Notification report fail err:" + localThrowable.getMessage());
                continue;
                QLog.d("QQInitHandler", 1, "reportPluginStatus lebaHelperService == null");
              }
            }
          }
          ((HashMap)localObject3).put("romInfo", localObject2);
          localObject4 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
          bool = ((SharedPreferences)localObject4).contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "_" + "push_open_notify_xml");
          j = ((SharedPreferences)localObject4).getInt("push_msg_notify_count", 0);
          k = ((SharedPreferences)localObject4).getInt("push_msg_notify_open", 0);
          m = ((SharedPreferences)localObject4).getInt("push_msg_notify_cancle", 0);
          ((HashMap)localObject3).put("hasConfigs", String.valueOf(bool));
          ((HashMap)localObject3).put("pushCount", String.valueOf(j));
          ((HashMap)localObject3).put("openCount", String.valueOf(k));
          ((HashMap)localObject3).put("cancleCount", String.valueOf(m));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msgNotificationStatsTag", true, 0L, 0L, (HashMap)localObject3, "");
          if (QLog.isColorLevel()) {
            QLog.d("StatisticCollector", 2, String.format("msg Notification report value, notifationStat: %d, romInfo: %s", new Object[] { Integer.valueOf(i), localObject2 }));
          }
          ReportController.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "push_value", "", "", "", 1, "", String.valueOf(i), String.valueOf(bool), String.valueOf(j), String.valueOf(k), String.valueOf(m), "", "");
          t();
          localObject2 = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ILebaHelperService.class, "");
          if (localObject2 == null) {
            break label1781;
          }
          ((ILebaHelperService)localObject2).reportPluginStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          f(localStatisticCollector);
          a(localStatisticCollector);
          e(localStatisticCollector);
          f();
          new CPUReport().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          d();
          b(localStatisticCollector);
          AVEffectPendantReport.e();
          UniteDownloadDbOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          a();
          e();
          u();
          s();
          if (QLog.isColorLevel()) {
            QLog.d("StatisticCollector", 2, "**************report data below:*****************");
          }
          localSharedPreferences.edit().putLong("LastTimeLogin_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), l2).commit();
          if (localCalendar1.after(localCalendar2))
          {
            ThemeUiPlugin.reportThemeNumAndCurrThemeName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          }
          if (l1 == 0L) {
            localSharedPreferences.edit().putLong("LastTimeLogin_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), l2).commit();
          }
          return 7;
          localObject2 = "0";
          break;
        }
      }
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("mobileQQ", 0);
    StatisticTroopAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    QQSettingUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    ThemeUtil.resetThemeSwitchTimes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).b(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  void a(StatisticCollector paramStatisticCollector)
  {
    if (paramStatisticCollector == null) {
      return;
    }
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        int i = NetworkUtil.a(BaseApplication.getContext());
        WifiManager localWifiManager = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
        if ((localWifiManager == null) || (!localWifiManager.isWifiEnabled())) {
          break label160;
        }
        bool = true;
        localHashMap.put("param_nettype", String.valueOf(i));
        localHashMap.put("param_wifi_switch_on", String.valueOf(bool));
        if (QLog.isColorLevel()) {
          QLog.d("DailyReport", 2, "reportWifiSwitchStatus nettype = " + i + ",isWiFiSwitchOn = " + bool);
        }
        paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arMapWifiSwitchStatus", true, 0L, 0L, localHashMap, "");
        return;
      }
      catch (Throwable paramStatisticCollector) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DailyReport", 2, "reportWifiSwitchStatus", paramStatisticCollector);
      return;
      label160:
      boolean bool = false;
    }
  }
  
  void b(StatisticCollector paramStatisticCollector)
  {
    if (paramStatisticCollector == null) {
      return;
    }
    for (;;)
    {
      HashMap localHashMap;
      int[] arrayOfInt;
      long l1;
      try
      {
        localHashMap = new HashMap();
        boolean bool = SharedPreUtils.a();
        arrayOfInt = SharedPreUtils.a();
        long l2 = SharedPreUtils.a();
        if ((!bool) && (arrayOfInt[1] <= 0))
        {
          CapturePtvTemplateManager.a().b(false);
          SharedPreUtils.b();
        }
        l1 = -1L;
        if (l2 <= 0L) {
          break label300;
        }
        l1 = (System.currentTimeMillis() - l2) / 1000L;
      }
      catch (Throwable paramStatisticCollector) {}
      if (arrayOfInt[0] > arrayOfInt[1]) {
        break;
      }
      BigDecimal localBigDecimal = new BigDecimal(arrayOfInt[0] * 1.0F / arrayOfInt[1]);
      localHashMap.put("filter_download", String.valueOf(arrayOfInt[0]));
      localHashMap.put("filter_total", String.valueOf(arrayOfInt[1]));
      localHashMap.put("filter_ratio", String.valueOf(localBigDecimal.setScale(2, 4).floatValue()));
      localHashMap.put("filter_spacing", String.valueOf(l1));
      if (QLog.isColorLevel()) {
        QLog.d("DailyReport", 2, "reportQQFilterDownloadInfo filter_download = " + arrayOfInt[0] + ",filter_total = " + arrayOfInt[1] + ",filter_spacing" + l1);
      }
      paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "reportQQFilterDownloadInfo", true, 0L, 0L, localHashMap, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "acQQFilterDownloadCount", true, 0L, 0L, localHashMap, null);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DailyReport", 2, "reportWifiSwitchStatus", paramStatisticCollector);
      return;
      label300:
      if (arrayOfInt[0] <= 0) {
        if (arrayOfInt[1] <= 0) {
          break;
        }
      }
    }
  }
  
  public void d()
  {
    Object localObject = (LikeRankingListManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER);
    boolean bool1 = ((LikeRankingListManager)localObject).c();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool2;
    if (bool1)
    {
      str = "1";
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8007918", "0X8007918", 0, 0, str, "", "", "");
      bool2 = ((LikeRankingListManager)localObject).b();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool2) {
        break label160;
      }
    }
    label160:
    for (String str = "1";; str = "2")
    {
      ReportController.b((AppRuntime)localObject, "CliStatus", "", "", "0X8007919", "0X8007919", 0, 0, str, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("DailyReport", 2, "reportVisitorLikeRankingStatus isRankingSwitch=" + bool1 + "isRankingNotificationSwitch=" + bool2);
      }
      return;
      str = "2";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.DailyReport
 * JD-Core Version:    0.7.0.1
 */