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
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.tencent.av.business.manager.pendant.AVEffectPendantReport;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageReportData;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.download.unite.core.UniteDownloadDbOperator;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.statistics.cpu.CPUReport;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.AutoSaveUtils;
import com.tencent.util.BadgeUtils;
import java.io.File;
import java.math.BigDecimal;
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

public class DailyReport
  extends AsyncStep
{
  private static int jdField_a_of_type_Int = 50000;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new DailyReport.1(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  
  private static String a(Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = (InputMethodManager)paramContext.getSystemService("input_method");
    try
    {
      localObject = ((InputMethodManager)localObject).getInputMethodList();
      int j = 0;
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((List)localObject).size();
      }
      while (j < i)
      {
        localStringBuffer.append(((InputMethodInfo)((List)localObject).get(j)).loadLabel(paramContext.getPackageManager()));
        localStringBuffer.append(';');
        j += 1;
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
  
  public static void a()
  {
    boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694986), "qqsetting_auto_receive_pic_key", true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_state", String.valueOf(bool));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "act2G3G4GSwitch", false, 0L, 0L, localHashMap, "");
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str2 = UserAction.getQIMEI();
    String str1;
    if (paramQQAppInterface.isLogin()) {
      str1 = "0";
    } else {
      str1 = "1";
    }
    ReportController.b(paramQQAppInterface, "0X800AAA1", "0X800AAA1", "0X800AAA1", "", 0, "", str2, str1, "", "", "", "", "", "");
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
    int j = DeviceInfoUtil.b();
    j = jdField_a_of_type_Int + j * 100;
    if (i <= 240) {
      i = j + 1;
    } else if (i <= 320) {
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
    ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString, "reportDeviceProfile", false, 0L, 0L, (HashMap)localObject, "");
  }
  
  private void c(StatisticCollector paramStatisticCollector)
  {
    HashMap localHashMap = new HashMap();
    int i;
    if (SkinEngine.IS_PROBLEM_MIUI) {
      i = 89050;
    } else {
      i = 89051;
    }
    localHashMap.put("param_FailCode", Integer.toString(i));
    boolean bool;
    if ((BaseApplicationImpl.IS_SUPPORT_THEME) && (!SkinEngine.IS_PROBLEM_MIUI)) {
      bool = true;
    } else {
      bool = false;
    }
    paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "report_skin_engine_enable", bool, 0L, 0L, localHashMap, "");
  }
  
  private void d()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getALLGeneralSettingRing() != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getALLGeneralSettingVibrate() != 0) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent();
    int k;
    if (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
      k = 0;
    } else {
      k = 1;
    }
    int m;
    if (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
      m = 0;
    } else {
      m = 1;
    }
    boolean bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), null, "new_msg_notification_key", true);
    boolean bool3 = QQNotificationManager.getInstance().groupChannelVibrateOn();
    boolean bool4 = QQNotificationManager.getInstance().c2cChannelVibrateOn();
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, new Object[] { "reportMessageNotificationSettings: invoked. ", " groupChannelVibrateOn: ", Boolean.valueOf(bool3), " c2cChannelVibrateOn: ", Boolean.valueOf(bool4) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int n;
    if (j != 0) {
      n = 1;
    } else {
      n = 2;
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800AD3B", "0X800AD3B", n, 0, "", "", "", "");
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (m != 0) {
      n = 1;
    } else {
      n = 2;
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800AD3C", "0X800AD3C", n, 0, "", "", "", "");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (i != 0) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A3CF", "0X800A3CF", 0, 0, (String)localObject, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (j != 0) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A3D0", "0X800A3D0", 0, 0, (String)localObject, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (bool1) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A3CE", "0X800A3CE", 0, 0, (String)localObject, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (m != 0) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A3D1", "0X800A3D1", 0, 0, (String)localObject, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (k != 0) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A3D2", "0X800A3D2", 0, 0, (String)localObject, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (bool2) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A512", "0X800A512", 0, 0, (String)localObject, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (AutoSaveUtils.a(true)) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A6E8", "0X800A6E8", 0, 0, (String)localObject, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (AutoSaveUtils.a(false)) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A6E9", "0X800A6E9", 0, 0, (String)localObject, "", "", "");
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (bool3) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X800AC8B", "0X800AC8B", i, 0, "", "", "", "");
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (bool4) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X800AC8C", "0X800AC8C", i, 0, "", "", "", "");
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
    boolean bool = ((IStickerRecManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str;
    if (bool) {
      str = "1";
    } else {
      str = "2";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800A224", "0X800A224", 0, 0, str, "", "", "");
  }
  
  private void e(StatisticCollector paramStatisticCollector)
  {
    if (paramStatisticCollector == null) {
      return;
    }
    try
    {
      boolean bool = ETC1Util.isETC1Supported();
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_manufacture", Build.MANUFACTURER);
      localHashMap.put("param_model", Build.MODEL);
      String str;
      if (bool) {
        str = String.valueOf(1);
      } else {
        str = String.valueOf(0);
      }
      localHashMap.put("param_etc1supported", str);
      paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arOpenGLSupport", bool, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DailyReport", 2, "reportOpenglSupport", localThrowable);
      }
      paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arOpenGLSupport", false, 0L, 0L, null, "");
    }
  }
  
  private void f()
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
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localStatisticCollector.reportCustomSet(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), localHashMap);
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
        boolean bool = localSet.contains(Integer.valueOf(1));
        String str3 = "1";
        if ((bool) && (localSet.contains(Integer.valueOf(2))) && (localSet.contains(Integer.valueOf(4))))
        {
          String str1 = "1";
          localHashMap.put("param_sensor_all3", str1);
          if (!localSet.contains(Integer.valueOf(1))) {
            break label638;
          }
          str1 = "1";
          localHashMap.put("param_sensor_accl", str1);
          if (!localSet.contains(Integer.valueOf(4))) {
            break label644;
          }
          str1 = "1";
          localHashMap.put("param_sensor_gyro", str1);
          if (!localSet.contains(Integer.valueOf(16))) {
            break label650;
          }
          str1 = "1";
          localHashMap.put("param_sensor_gyro_uncalibrated", str1);
          if (!localSet.contains(Integer.valueOf(2))) {
            break label656;
          }
          str1 = "1";
          localHashMap.put("param_sensor_magnet", str1);
          if (!localSet.contains(Integer.valueOf(14))) {
            break label662;
          }
          str1 = "1";
          localHashMap.put("param_sensor_magnet_uncalibrated", str1);
          if ((!localSet.contains(Integer.valueOf(1))) || (!localSet.contains(Integer.valueOf(4)))) {
            break label668;
          }
          str1 = "1";
          localHashMap.put("param_sensor_accl_gyro", str1);
          if ((!localSet.contains(Integer.valueOf(1))) || (!localSet.contains(Integer.valueOf(2)))) {
            break label674;
          }
          str1 = "1";
          localHashMap.put("param_sensor_accl_magnet", str1);
          if ((!localSet.contains(Integer.valueOf(4))) || (!localSet.contains(Integer.valueOf(2)))) {
            break label680;
          }
          str1 = "1";
          localHashMap.put("param_sensor_gyro_magnet", str1);
          if (!localSet.contains(Integer.valueOf(3))) {
            break label686;
          }
          str1 = "1";
          localHashMap.put("param_sensor_orientation", str1);
          if (!localSet.contains(Integer.valueOf(11))) {
            break label692;
          }
          str1 = "1";
          localHashMap.put("param_sensor_rotation", str1);
          if (!localSet.contains(Integer.valueOf(15))) {
            break label698;
          }
          str1 = "1";
          localHashMap.put("param_sensor_rotation_game", str1);
          if (!localSet.contains(Integer.valueOf(20))) {
            break label704;
          }
          str1 = "1";
          localHashMap.put("param_sensor_rotation_geomagnet", str1);
          if (!localSet.contains(Integer.valueOf(9))) {
            break label710;
          }
          str1 = "1";
          localHashMap.put("param_sensor_gravity", str1);
          if (!localSet.contains(Integer.valueOf(10))) {
            break label716;
          }
          str1 = str3;
          localHashMap.put("param_sensor_linear_accl", str1);
          paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arSensorSupport", true, 0L, 0L, localHashMap, "");
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DailyReport", 2, "reportSensorSupport", localException);
        }
        paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arSensorSupport", false, 0L, 0L, null, "");
        return;
      }
      String str2 = "0";
      continue;
      label638:
      str2 = "0";
      continue;
      label644:
      str2 = "0";
      continue;
      label650:
      str2 = "0";
      continue;
      label656:
      str2 = "0";
      continue;
      label662:
      str2 = "0";
      continue;
      label668:
      str2 = "0";
      continue;
      label674:
      str2 = "0";
      continue;
      label680:
      str2 = "0";
      continue;
      label686:
      str2 = "0";
      continue;
      label692:
      str2 = "0";
      continue;
      label698:
      str2 = "0";
      continue;
      label704:
      str2 = "0";
      continue;
      label710:
      str2 = "0";
      continue;
      label716:
      str2 = "0";
    }
  }
  
  private void g()
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
    Object localObject = (IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
    if (localObject != null)
    {
      localObject = ((IEmoticonManagerService)localObject).syncGetTabEmoticonPackages();
      if (localObject != null)
      {
        i = ((List)localObject).size();
        break label138;
      }
    }
    i = 0;
    label138:
    localObject = new HashMap();
    ((Map)localObject).put("Ep_amount", Integer.valueOf(i));
    localStatisticCollector.reportOnOff(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, (Map)localObject);
    i = 0;
    while (i < 3)
    {
      localObject = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ep_tab2");
      localStringBuilder.append(i);
      int j = StatisticAssist.a((Context)localObject, str, localStringBuilder.toString());
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
  }
  
  private void h()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject2 != null)
    {
      localObject1 = ((FriendsManager)localObject2).a((String)localObject1);
      if (localObject1 != null)
      {
        if (!((ExtensionInfo)localObject1).isPendantValid()) {
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
          ((DownloaderFactory)localObject2).a(1).startDownload((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
          return;
        }
        localObject2 = AvatarPendantUtil.a(localFile);
        VasWebviewUtil.a("AvatarPendant", "AvatarPendantOn", String.valueOf(((ExtensionInfo)localObject1).pendantId), 0, 0, 0, 0, (String)localObject2, "");
      }
    }
  }
  
  private void i()
  {
    List localList = ((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncGetTabEmoticonPackages();
    Object localObject1;
    if (localList != null)
    {
      int i = 0;
      Object localObject2;
      for (localObject1 = ""; i < localList.size(); localObject1 = localObject2)
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)localList.get(i);
        if (3 != localEmoticonPackage.jobType)
        {
          localObject2 = localObject1;
          if (5 != localEmoticonPackage.jobType) {}
        }
        else if (((String)localObject1).equals(""))
        {
          localObject2 = localEmoticonPackage.epId;
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("|");
          ((StringBuilder)localObject2).append(localEmoticonPackage.epId);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        i += 1;
      }
    }
    else
    {
      localObject1 = "";
    }
    VasWebviewUtil.a("MbBaoyou", "MbBaoyouID", "0", 0, 0, 0, 0, (String)localObject1, "");
  }
  
  private void j()
  {
    String str3 = ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).c(null);
    boolean bool = str3.equals("custom");
    String str1 = "0X8004E10";
    String str2 = "0X8004E0F";
    if (bool) {
      str2 = "0X8004E10";
    } else {
      str1 = "0X8004E0F";
    }
    VasWebviewUtil.a(str1, str2, str3, 0, 0);
  }
  
  private void k()
  {
    VasWebviewUtil.a("0X800498F", "0X800498F", ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g(), 0);
  }
  
  private void l()
  {
    ISVIPHandler localISVIPHandler = (ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
    VasWebviewUtil.a("0X8004990", "0X8004990", String.valueOf(localISVIPHandler.b()), localISVIPHandler.g(), 0);
  }
  
  private void m()
  {
    boolean bool1 = ((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.chat_font.name());
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("font_open_switch", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isUserOpenFontSwitch_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    boolean bool2 = localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
    int i;
    if (bool1) {
      i = 2;
    } else if (bool2) {
      i = 1;
    } else {
      i = 0;
    }
    VasWebviewUtil.a("font_switch", "switch_on", "0", 0, 0, i, 0, "", "");
  }
  
  private void n()
  {
    String str = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    Object localObject = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    boolean bool2 = false;
    localObject = ((BaseApplication)localObject).getSharedPreferences("sticker_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sticker_switch_");
    localStringBuilder.append(str);
    boolean bool1 = bool2;
    if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true))
    {
      bool1 = bool2;
      if (EmojiStickerManager.a()) {
        bool1 = true;
      }
    }
    EmojiStickerManager.f = bool1;
    if (EmojiStickerManager.f)
    {
      VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "SwitchOn", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
    }
    VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "SwitchOff", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  private void o()
  {
    Object localObject2 = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    Object localObject1;
    int i;
    int j;
    if (localObject2 != null)
    {
      localObject1 = ((IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      StringBuilder localStringBuilder1;
      if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).apolloStatus == 1))
      {
        Object localObject3 = ((ApolloBaseInfo)localObject1).getApolloDress();
        localStringBuilder1 = new StringBuilder();
        i = 0;
        j = 0;
        if (localObject3 != null)
        {
          int k = ((ApolloDress)localObject3).roleId;
          localObject3 = ((ApolloDress)localObject3).getDressIds();
          int m = localObject3.length;
          i = j;
          while (i < m)
          {
            localStringBuilder1.append(localObject3[i]);
            localStringBuilder1.append("|");
            i += 1;
          }
          i = k;
        }
        j = ((IApolloManagerService)localObject2).getApolloUserStatus();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(i);
        ((StringBuilder)localObject4).append("");
        localObject4 = ((StringBuilder)localObject4).toString();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(((ApolloBaseInfo)localObject1).apolloVipFlag);
        localStringBuilder2.append("");
        ReportController.b((AppRuntime)localObject3, "CliStatus", "", "", "ApolloStatus", "dress", 0, 0, (String)localObject4, localStringBuilder2.toString(), localStringBuilder1.toString(), String.valueOf(j + 1));
      }
      else if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).apolloStatus == 2))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "close", 0, 0, "0", "0", "", "");
      }
      if ((((IApolloManagerService)localObject2).getWhiteListStatus() == 1) && (localObject1 != null))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(((ApolloBaseInfo)localObject1).apolloStatus);
        localStringBuilder1.append("");
        ReportController.b((AppRuntime)localObject2, "CliStatus", "", "", "ApolloStatus", "white", 0, 0, localStringBuilder1.toString(), "0", "", "");
      }
      localObject1 = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      if (localObject1 != null)
      {
        localObject2 = ((IApolloDaoManagerService)localObject1).getFavActionList();
        if (localObject2 != null) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "action_added", ((List)localObject2).size(), 0, "0", "0", "", "");
        }
        localObject1 = ((IApolloDaoManagerService)localObject1).getApolloGameVer();
        if ((localObject1 != null) && (!((ConcurrentHashMap)localObject1).isEmpty())) {
          localObject1 = ((ConcurrentHashMap)localObject1).entrySet().iterator();
        }
      }
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext()) {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
      }
      try
      {
        i = (int)Float.parseFloat((String)((Map.Entry)localObject2).getValue());
        j = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "game_downloaded", 0, 0, String.valueOf(j), String.valueOf(i), "", "");
      }
      catch (Exception localException) {}
      return;
    }
  }
  
  private void p()
  {
    Object localObject = (PhoneUnityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
    if (((PhoneUnityManager)localObject).d)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (((PhoneUnityManager)localObject).a()) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8005B8B", "0X8005B8B", 0, 0, (String)localObject, "", "", "");
    }
  }
  
  private void q()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      if (localNearbyPeopleCard != null)
      {
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str;
        if (localNearbyPeopleCard.switchHobby) {
          str = "1";
        } else {
          str = "0";
        }
        ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8004A12", "0X8004A12", 0, 0, str, "", "", "");
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localNearbyPeopleCard.switchQzone) {
          str = "1";
        } else {
          str = "0";
        }
        ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8004A13", "0X8004A13", 0, 0, str, "", "", "");
      }
      localEntityManager.close();
    }
  }
  
  /* Error */
  private void r()
  {
    // Byte code:
    //   0: new 569	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 570	java/lang/StringBuilder:<init>	()V
    //   7: astore 11
    //   9: aload 11
    //   11: invokestatic 937	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   14: invokevirtual 940	java/io/File:getPath	()Ljava/lang/String;
    //   17: invokevirtual 575	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 11
    //   23: ldc_w 942
    //   26: invokevirtual 575	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 11
    //   32: invokevirtual 579	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 15
    //   37: new 612	java/io/File
    //   40: dup
    //   41: aload 15
    //   43: invokespecial 622	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore 14
    //   48: aload 14
    //   50: invokevirtual 625	java/io/File:exists	()Z
    //   53: ifne +4 -> 57
    //   56: return
    //   57: ldc_w 733
    //   60: invokestatic 329	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   63: checkcast 733	com/tencent/mobileqq/dpc/api/IDPCApi
    //   66: getstatic 945	com/tencent/mobileqq/dpc/enumname/DPCNames:batteryCfg	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   69: invokevirtual 742	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   72: invokeinterface 948 2 0
    //   77: astore 11
    //   79: aload 11
    //   81: invokestatic 953	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: ifne +707 -> 791
    //   87: aload 11
    //   89: ldc_w 955
    //   92: invokevirtual 957	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +696 -> 791
    //   98: aload 11
    //   100: aload 11
    //   102: ldc_w 955
    //   105: invokevirtual 961	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   108: iconst_1
    //   109: iadd
    //   110: aload 11
    //   112: invokevirtual 962	java/lang/String:length	()I
    //   115: invokevirtual 966	java/lang/String:substring	(II)Ljava/lang/String;
    //   118: astore 11
    //   120: goto +3 -> 123
    //   123: aload 11
    //   125: ldc_w 968
    //   128: invokevirtual 972	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   131: iconst_1
    //   132: aaload
    //   133: invokestatic 878	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   136: fstore_1
    //   137: goto +23 -> 160
    //   140: invokestatic 355	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +13 -> 156
    //   146: ldc_w 459
    //   149: iconst_2
    //   150: ldc_w 974
    //   153: invokestatic 977	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: ldc_w 978
    //   159: fstore_1
    //   160: iconst_0
    //   161: istore 5
    //   163: invokestatic 982	java/lang/Math:random	()D
    //   166: fload_1
    //   167: f2d
    //   168: dcmpg
    //   169: ifgt +640 -> 809
    //   172: aload 14
    //   174: invokevirtual 986	java/io/File:listFiles	()[Ljava/io/File;
    //   177: astore 11
    //   179: new 988	java/util/ArrayList
    //   182: dup
    //   183: invokespecial 989	java/util/ArrayList:<init>	()V
    //   186: astore 16
    //   188: aload 11
    //   190: ifnull +58 -> 248
    //   193: aload 11
    //   195: arraylength
    //   196: ifle +52 -> 248
    //   199: aload 11
    //   201: arraylength
    //   202: istore_3
    //   203: iconst_0
    //   204: istore_2
    //   205: iload_2
    //   206: iload_3
    //   207: if_icmpge +41 -> 248
    //   210: aload 11
    //   212: iload_2
    //   213: aaload
    //   214: invokevirtual 992	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   217: astore 12
    //   219: aload 12
    //   221: ifnull +578 -> 799
    //   224: aload 12
    //   226: ldc_w 994
    //   229: invokevirtual 997	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   232: ifeq +567 -> 799
    //   235: aload 16
    //   237: aload 12
    //   239: invokeinterface 998 2 0
    //   244: pop
    //   245: goto +554 -> 799
    //   248: aload 16
    //   250: invokeinterface 53 1 0
    //   255: istore_2
    //   256: aconst_null
    //   257: astore 13
    //   259: aconst_null
    //   260: astore 12
    //   262: aload 12
    //   264: astore 11
    //   266: iload_2
    //   267: ifle +137 -> 404
    //   270: aload 16
    //   272: invokeinterface 53 1 0
    //   277: iconst_5
    //   278: if_icmpge +117 -> 395
    //   281: new 569	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 570	java/lang/StringBuilder:<init>	()V
    //   288: astore 11
    //   290: aload 11
    //   292: aload 15
    //   294: invokevirtual 575	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 11
    //   300: ldc_w 1000
    //   303: invokevirtual 575	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 11
    //   309: invokestatic 1005	java/lang/System:currentTimeMillis	()J
    //   312: invokevirtual 1008	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 11
    //   318: ldc_w 1010
    //   321: invokevirtual 575	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 11
    //   327: invokevirtual 579	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: astore 11
    //   332: aload 16
    //   334: aload 11
    //   336: invokestatic 1016	com/tencent/mobileqq/utils/FileUtils:zipFiles	(Ljava/util/List;Ljava/lang/String;)Z
    //   339: ifeq +29 -> 368
    //   342: new 612	java/io/File
    //   345: dup
    //   346: aload 11
    //   348: invokespecial 622	java/io/File:<init>	(Ljava/lang/String;)V
    //   351: astore 11
    //   353: aload 11
    //   355: invokevirtual 625	java/io/File:exists	()Z
    //   358: ifne +448 -> 806
    //   361: aload 12
    //   363: astore 11
    //   365: goto +39 -> 404
    //   368: aload 12
    //   370: astore 11
    //   372: invokestatic 355	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +29 -> 404
    //   378: ldc_w 459
    //   381: iconst_2
    //   382: ldc_w 1018
    //   385: invokestatic 977	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: aload 12
    //   390: astore 11
    //   392: goto +12 -> 404
    //   395: iconst_3
    //   396: istore_3
    //   397: aload 13
    //   399: astore 11
    //   401: goto +5 -> 406
    //   404: iconst_0
    //   405: istore_3
    //   406: iload_3
    //   407: istore_2
    //   408: aload 11
    //   410: ifnull +210 -> 620
    //   413: new 1020	org/json/JSONObject
    //   416: dup
    //   417: invokespecial 1021	org/json/JSONObject:<init>	()V
    //   420: astore 12
    //   422: new 1020	org/json/JSONObject
    //   425: dup
    //   426: invokespecial 1021	org/json/JSONObject:<init>	()V
    //   429: astore 13
    //   431: aload 13
    //   433: ldc_w 1023
    //   436: aload 11
    //   438: invokevirtual 992	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   441: invokevirtual 1026	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   444: pop
    //   445: new 1020	org/json/JSONObject
    //   448: dup
    //   449: invokespecial 1021	org/json/JSONObject:<init>	()V
    //   452: astore 11
    //   454: aload 11
    //   456: ldc_w 1028
    //   459: invokestatic 1032	com/tencent/qqperf/MagnifierSDK:b	()Ljava/lang/String;
    //   462: invokevirtual 1026	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   465: pop
    //   466: aload 11
    //   468: ldc_w 1034
    //   471: bipush 17
    //   473: invokestatic 290	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   476: invokevirtual 1026	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   479: pop
    //   480: aload 12
    //   482: ldc_w 1036
    //   485: aload 13
    //   487: invokevirtual 1026	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   490: pop
    //   491: aload 12
    //   493: ldc_w 1038
    //   496: aload 11
    //   498: invokevirtual 1026	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   501: pop
    //   502: aload 12
    //   504: ldc_w 1040
    //   507: bipush 104
    //   509: invokevirtual 1043	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   512: pop
    //   513: lconst_0
    //   514: lstore 9
    //   516: aload_0
    //   517: getfield 309	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   520: invokevirtual 339	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   523: invokestatic 1049	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   526: lstore 7
    //   528: goto +31 -> 559
    //   531: astore 11
    //   533: lload 9
    //   535: lstore 7
    //   537: invokestatic 355	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq +19 -> 559
    //   543: ldc_w 459
    //   546: iconst_2
    //   547: ldc_w 1051
    //   550: aload 11
    //   552: invokestatic 463	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   555: lload 9
    //   557: lstore 7
    //   559: new 1053	com/tencent/qqperf/repoter/ResultObject
    //   562: dup
    //   563: iconst_0
    //   564: ldc_w 1055
    //   567: iconst_1
    //   568: lconst_1
    //   569: lconst_1
    //   570: aload 12
    //   572: iconst_1
    //   573: iconst_1
    //   574: lload 7
    //   576: invokespecial 1058	com/tencent/qqperf/repoter/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   579: invokestatic 1063	com/tencent/qqperf/repoter/ReporterMachine:a	(Lcom/tencent/qqperf/repoter/ResultObject;)V
    //   582: iconst_1
    //   583: istore_2
    //   584: goto +36 -> 620
    //   587: astore 11
    //   589: iload_3
    //   590: istore_2
    //   591: iload_3
    //   592: istore 4
    //   594: invokestatic 355	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +23 -> 620
    //   600: iload_3
    //   601: istore 4
    //   603: ldc_w 459
    //   606: iconst_2
    //   607: ldc_w 1065
    //   610: aload 11
    //   612: invokestatic 463	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   615: iload_3
    //   616: istore_2
    //   617: goto +3 -> 620
    //   620: iload_2
    //   621: istore_3
    //   622: iload_2
    //   623: ifle +103 -> 726
    //   626: iload_2
    //   627: istore 4
    //   629: aload 14
    //   631: invokevirtual 986	java/io/File:listFiles	()[Ljava/io/File;
    //   634: astore 11
    //   636: iload_2
    //   637: istore_3
    //   638: aload 11
    //   640: ifnull +86 -> 726
    //   643: iload_2
    //   644: istore 4
    //   646: iload_2
    //   647: istore_3
    //   648: aload 11
    //   650: arraylength
    //   651: ifle +75 -> 726
    //   654: iload_2
    //   655: istore 4
    //   657: aload 11
    //   659: arraylength
    //   660: istore 6
    //   662: iload_2
    //   663: istore_3
    //   664: iload 5
    //   666: iload 6
    //   668: if_icmpge +58 -> 726
    //   671: iload_2
    //   672: istore 4
    //   674: aload 11
    //   676: iload 5
    //   678: aaload
    //   679: invokevirtual 1068	java/io/File:delete	()Z
    //   682: pop
    //   683: iload 5
    //   685: iconst_1
    //   686: iadd
    //   687: istore 5
    //   689: goto -27 -> 662
    //   692: astore 11
    //   694: goto +8 -> 702
    //   697: astore 11
    //   699: iconst_0
    //   700: istore 4
    //   702: iload 4
    //   704: istore_3
    //   705: invokestatic 355	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   708: ifeq +18 -> 726
    //   711: ldc_w 459
    //   714: iconst_2
    //   715: ldc_w 1070
    //   718: aload 11
    //   720: invokestatic 463	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   723: iload 4
    //   725: istore_3
    //   726: invokestatic 355	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   729: ifeq +56 -> 785
    //   732: new 569	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 570	java/lang/StringBuilder:<init>	()V
    //   739: astore 11
    //   741: aload 11
    //   743: ldc_w 1072
    //   746: invokevirtual 575	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload 11
    //   752: iload_3
    //   753: invokevirtual 578	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload 11
    //   759: ldc_w 1074
    //   762: invokevirtual 575	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload 11
    //   768: fload_1
    //   769: invokevirtual 1077	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   772: pop
    //   773: ldc_w 459
    //   776: iconst_2
    //   777: aload 11
    //   779: invokevirtual 579	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   782: invokestatic 977	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   785: return
    //   786: astore 11
    //   788: goto -648 -> 140
    //   791: ldc_w 1079
    //   794: astore 11
    //   796: goto -673 -> 123
    //   799: iload_2
    //   800: iconst_1
    //   801: iadd
    //   802: istore_2
    //   803: goto -598 -> 205
    //   806: goto -402 -> 404
    //   809: iconst_2
    //   810: istore_2
    //   811: goto -191 -> 620
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	814	0	this	DailyReport
    //   136	633	1	f	float
    //   204	607	2	i	int
    //   202	551	3	j	int
    //   592	132	4	k	int
    //   161	527	5	m	int
    //   660	9	6	n	int
    //   526	49	7	l1	long
    //   514	42	9	l2	long
    //   7	490	11	localObject1	Object
    //   531	20	11	localException1	Exception
    //   587	24	11	localException2	Exception
    //   634	41	11	arrayOfFile	File[]
    //   692	1	11	localException3	Exception
    //   697	22	11	localException4	Exception
    //   739	39	11	localStringBuilder	StringBuilder
    //   786	1	11	localException5	Exception
    //   794	1	11	str1	String
    //   217	354	12	localObject2	Object
    //   257	229	13	localJSONObject	org.json.JSONObject
    //   46	584	14	localFile	File
    //   35	258	15	str2	String
    //   186	147	16	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   516	528	531	java/lang/Exception
    //   413	513	587	java/lang/Exception
    //   537	555	587	java/lang/Exception
    //   559	582	587	java/lang/Exception
    //   594	600	692	java/lang/Exception
    //   603	615	692	java/lang/Exception
    //   629	636	692	java/lang/Exception
    //   648	654	692	java/lang/Exception
    //   657	662	692	java/lang/Exception
    //   674	683	692	java/lang/Exception
    //   163	188	697	java/lang/Exception
    //   193	203	697	java/lang/Exception
    //   210	219	697	java/lang/Exception
    //   224	245	697	java/lang/Exception
    //   248	256	697	java/lang/Exception
    //   270	361	697	java/lang/Exception
    //   372	388	697	java/lang/Exception
    //   57	120	786	java/lang/Exception
    //   123	137	786	java/lang/Exception
  }
  
  private void s()
  {
    Map localMap = ((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str;
    if (((Boolean)localMap.get("temp_msg_setting_troop_")).booleanValue()) {
      str = "1";
    } else {
      str = "0";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 1, 1, str, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((Boolean)localMap.get("temp_msg_setting_nearby_")).booleanValue()) {
      str = "1";
    } else {
      str = "0";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 2, 2, str, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((Boolean)localMap.get("temp_msg_setting_interest_v2")).booleanValue()) {
      str = "1";
    } else {
      str = "0";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 3, 3, str, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((Boolean)localMap.get("temp_msg_setting_contact_")).booleanValue()) {
      str = "1";
    } else {
      str = "0";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 4, 4, str, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((Boolean)localMap.get("temp_msg_setting_consult_")).booleanValue()) {
      str = "1";
    } else {
      str = "0";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 5, 5, str, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((Boolean)localMap.get("temp_msg_setting_circle_v2")).booleanValue()) {
      str = "1";
    } else {
      str = "0";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 6, 6, str, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((Boolean)localMap.get("temp_msg_setting_game_buddy_")).booleanValue()) {
      str = "1";
    } else {
      str = "0";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 7, 7, str, "", "", "");
    localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((Boolean)localMap.get("temp_msg_setting_audio_room")).booleanValue()) {
      str = "1";
    } else {
      str = "0";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 8, 8, str, "", "", "");
  }
  
  private void t()
  {
    if (!ScreenShotDetector.b()) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B4E6", "0X800B4E6", 0, 0, "", "", "", "");
    }
  }
  
  void a(StatisticCollector paramStatisticCollector)
  {
    if (paramStatisticCollector == null) {
      return;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
      boolean bool2 = false;
      Object localObject = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((WifiManager)localObject).isWifiEnabled()) {
          bool1 = true;
        }
      }
      localHashMap.put("param_nettype", String.valueOf(i));
      localHashMap.put("param_wifi_switch_on", String.valueOf(bool1));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportWifiSwitchStatus nettype = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(",isWiFiSwitchOn = ");
        ((StringBuilder)localObject).append(bool1);
        QLog.d("DailyReport", 2, ((StringBuilder)localObject).toString());
      }
      paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arMapWifiSwitchStatus", true, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Throwable paramStatisticCollector)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DailyReport", 2, "reportWifiSwitchStatus", paramStatisticCollector);
      }
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("mobileQQ", 0);
    StatisticTroopAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    StatisticAssist.a(localQQAppInterface, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, localQQAppInterface.getCurrentAccountUin());
    QQSettingUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    ThemeUtil.resetThemeSwitchTimes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).b(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  void b(StatisticCollector paramStatisticCollector)
  {
    if (paramStatisticCollector == null) {
      return;
    }
    int[] arrayOfInt;
    do
    {
      try
      {
        localHashMap = new HashMap();
        boolean bool = SharedPreUtils.a();
        arrayOfInt = SharedPreUtils.a();
        long l2 = SharedPreUtils.a();
        if ((!bool) && (arrayOfInt[1] <= 0))
        {
          CapturePtvTemplateManager.a().b(false);
          SharedPreUtils.a();
        }
        l1 = -1L;
        if (l2 <= 0L) {
          continue;
        }
        l1 = (System.currentTimeMillis() - l2) / 1000L;
      }
      catch (Throwable paramStatisticCollector)
      {
        HashMap localHashMap;
        long l1;
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DailyReport", 2, "reportWifiSwitchStatus", paramStatisticCollector);
        return;
      }
      localObject = new BigDecimal(arrayOfInt[0] * 1.0F / arrayOfInt[1]);
      localHashMap.put("filter_download", String.valueOf(arrayOfInt[0]));
      localHashMap.put("filter_total", String.valueOf(arrayOfInt[1]));
      localHashMap.put("filter_ratio", String.valueOf(((BigDecimal)localObject).setScale(2, 4).floatValue()));
      localHashMap.put("filter_spacing", String.valueOf(l1));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportQQFilterDownloadInfo filter_download = ");
        ((StringBuilder)localObject).append(arrayOfInt[0]);
        ((StringBuilder)localObject).append(",filter_total = ");
        ((StringBuilder)localObject).append(arrayOfInt[1]);
        ((StringBuilder)localObject).append(",filter_spacing");
        ((StringBuilder)localObject).append(l1);
        QLog.d("DailyReport", 2, ((StringBuilder)localObject).toString());
      }
      paramStatisticCollector.collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "reportQQFilterDownloadInfo", true, 0L, 0L, localHashMap, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "acQQFilterDownloadCount", true, 0L, 0L, localHashMap, null);
      return;
    } while (((arrayOfInt[0] > 0) || (arrayOfInt[1] > 0)) && (arrayOfInt[0] <= arrayOfInt[1]));
  }
  
  public void c()
  {
    Object localObject2 = (LikeRankingListManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER);
    boolean bool1 = ((LikeRankingListManager)localObject2).c();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1;
    if (bool1) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8007918", "0X8007918", 0, 0, (String)localObject1, "", "", "");
    boolean bool2 = ((LikeRankingListManager)localObject2).b();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (bool2) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    ReportController.b((AppRuntime)localObject2, "CliStatus", "", "", "0X8007919", "0X8007919", 0, 0, (String)localObject1, "", "", "");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportVisitorLikeRankingStatus isRankingSwitch=");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append("isRankingNotificationSwitch=");
      ((StringBuilder)localObject1).append(bool2);
      QLog.d("DailyReport", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  protected int doStep()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("mobileQQ", 0);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("LastTimeLogin_");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    long l1 = localSharedPreferences.getLong(((StringBuilder)localObject1).toString(), 0L);
    long l2 = System.currentTimeMillis() - 10L;
    localObject1 = Calendar.getInstance();
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(l1);
    ((Calendar)localObject2).add(5, 1);
    ((Calendar)localObject2).clear(10);
    ((Calendar)localObject2).clear(12);
    ((Calendar)localObject2).clear(13);
    ((Calendar)localObject2).clear(14);
    Object localObject3 = Calendar.getInstance();
    ((Calendar)localObject3).add(5, 1);
    ((Calendar)localObject3).clear(10);
    ((Calendar)localObject3).clear(12);
    ((Calendar)localObject3).clear(13);
    ((Calendar)localObject3).clear(14);
    ((Calendar)localObject3).getTimeInMillis();
    if ((l1 > 0L) && (((Calendar)localObject1).after(localObject2)))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QQSettingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      NotifyPushSettingActivity.a((QQAppInterface)localObject3, ((QQAppInterface)localObject3).getCurrentAccountUin());
      q();
      f();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      Object localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      a((String)localObject6);
      Object localObject7 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      StatisticCollector localStatisticCollector = StatisticCollector.getInstance((Context)localObject7);
      try
      {
        g();
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("DailyReport", 2, "reportAioEmotionData", localException);
      }
      h();
      i();
      j();
      k();
      l();
      m();
      o();
      p();
      n();
      Object localObject4 = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if ((localObject4 != null) && (((MessageRoamManager)localObject4).h()))
      {
        if (((MessageRoamManager)localObject4).b() == 1) {
          localObject4 = "devlock";
        } else {
          localObject4 = "password";
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "auth_mode", 1, 0, new String[] { "0", "0", localObject4 });
      }
      localObject4 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject4 != null) {
        localObject4 = ((FriendsManager)localObject4).a((String)localObject6);
      } else {
        localObject4 = null;
      }
      if (localObject4 != null) {
        VasWebviewUtil.a("FontStatus", "FontOn", String.valueOf(((ExtensionInfo)localObject4).uVipFont), 0, 0);
      }
      if (localObject4 != null)
      {
        j = ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
        if (j == 2)
        {
          i = 0;
        }
        else
        {
          i = j;
          if (j == 3) {
            i = 2;
          }
        }
        VasWebviewUtil.a("0X8004A26", "0X8004A26", String.valueOf(((ExtensionInfo)localObject4).colorRingId), i, 0);
      }
      int j = ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
      if (localObject4 != null) {
        VasWebviewUtil.a("0X8005005", "0X8005005", String.valueOf(((ExtensionInfo)localObject4).commingRingId), j, 0);
      }
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      int k = VipFunCallUtil.a((AppRuntime)localObject4, ((QQAppInterface)localObject4).getAccount(), 6, true, null);
      if (j == 2)
      {
        i = 0;
      }
      else
      {
        i = j;
        if (j == 3) {
          i = 2;
        }
      }
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      ReportController.b((AppRuntime)localObject4, "CliOper", "", ((QQAppInterface)localObject4).getCurrentAccountUin(), "funcallnew", "setfuncall", 0, 0, String.valueOf(k), String.valueOf(i), String.valueOf(NetworkUtil.getSystemNetwork(null)), "1");
      localObject4 = StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      Object localObject8;
      if (localObject4 != null)
      {
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject8 = (MessageReportData)((Iterator)localObject4).next();
          if (((MessageReportData)localObject8).msgCount > 0) {
            localStatisticCollector.reportActionCountMsgOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageReportData)localObject8).getMsgReport());
          }
        }
      }
      int i = QQSettingUtil.a((Context)localObject7, (String)localObject6);
      if (i > 0)
      {
        localObject4 = StatisticCollector.getInstance(BaseApplication.getContext());
        localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ((StatisticCollector)localObject4).reportActionCount((AppRuntime)localObject8, ((QQAppInterface)localObject8).getCurrentAccountUin(), "Setting_Quit", i);
      }
      i = NotifyPushSettingActivity.a((Context)localObject7, (String)localObject6, "LED_light");
      localObject4 = new HashMap();
      ((HashMap)localObject4).clear();
      ((HashMap)localObject4).put("LED_light", Integer.valueOf(i));
      localStatisticCollector.reportOnOff(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject6, (Map)localObject4);
      if (BadgeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))
      {
        bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, null, null, "qqsetting_show_badgeunread_key", true);
        localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (bool) {
          localObject4 = "1";
        } else {
          localObject4 = "0";
        }
        ReportController.b((AppRuntime)localObject7, "CliStatus", "", "", "0X8004BE8", "0X8004BE8", 0, 0, (String)localObject4, "", "", "");
      }
      a();
      i = ThemeUtil.getThemeSwitchTimes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (i > 0) {
        localStatisticCollector.reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject6, "", "theme_mall", "theme_replace", 0, i, 0);
      }
      i = ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (i > 0) {
        localStatisticCollector.reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject6, "", "background", "bkground_replace", 0, i, 0);
      }
      boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getString(2131693837), "qqsetting_lock_screen_whenexit_key", true);
      localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (Boolean.valueOf(bool).booleanValue()) {
        localObject4 = "1";
      } else {
        localObject4 = "0";
      }
      ReportController.b((AppRuntime)localObject6, "CliStatus", "", "", "0X80040D9", "0X80040D9", 0, 0, (String)localObject4, "", "", "");
      d(localStatisticCollector);
      c(localStatisticCollector);
      try
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          localObject7 = new HashMap();
          i = QQAppInterface.isNotificationEnabled();
          ((HashMap)localObject7).put("notifationStat", String.valueOf(i));
          ((HashMap)localObject7).put("uinParam", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          localObject6 = DeviceInfoUtil.j();
          localObject4 = localObject6;
          if (localObject6 == null) {
            localObject4 = "";
          }
          ((HashMap)localObject7).put("romInfo", localObject4);
          localObject6 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
          localObject8 = new StringBuilder();
          ((StringBuilder)localObject8).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          ((StringBuilder)localObject8).append("_");
          ((StringBuilder)localObject8).append("push_open_notify_xml");
          bool = ((SharedPreferences)localObject6).contains(((StringBuilder)localObject8).toString());
          j = ((SharedPreferences)localObject6).getInt("push_msg_notify_count", 0);
          k = ((SharedPreferences)localObject6).getInt("push_msg_notify_open", 0);
          try
          {
            int m = ((SharedPreferences)localObject6).getInt("push_msg_notify_cancle", 0);
            ((HashMap)localObject7).put("hasConfigs", String.valueOf(bool));
            ((HashMap)localObject7).put("pushCount", String.valueOf(j));
            ((HashMap)localObject7).put("openCount", String.valueOf(k));
            ((HashMap)localObject7).put("cancleCount", String.valueOf(m));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msgNotificationStatsTag", true, 0L, 0L, (HashMap)localObject7, "");
            if (QLog.isColorLevel()) {
              QLog.d("StatisticCollector", 2, String.format("msg Notification report value, notifationStat: %d, romInfo: %s", new Object[] { Integer.valueOf(i), localObject4 }));
            }
            ReportController.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "push_value", "", "", "", 1, "", String.valueOf(i), String.valueOf(bool), String.valueOf(j), String.valueOf(k), String.valueOf(m), "", "");
          }
          catch (Throwable localThrowable1) {}
        }
      }
      catch (Throwable localThrowable2)
      {
        if (QLog.isColorLevel())
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("msg Notification report fail err:");
          ((StringBuilder)localObject6).append(localThrowable2.getMessage());
          QLog.d("StatisticCollector", 2, ((StringBuilder)localObject6).toString());
        }
      }
      s();
      Object localObject5 = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ILebaHelperService.class, "");
      if (localObject5 != null) {
        ((ILebaHelperService)localObject5).reportPluginStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      } else {
        QLog.d("QQInitHandler", 1, "reportPluginStatus lebaHelperService == null");
      }
      f(localStatisticCollector);
      a(localStatisticCollector);
      e(localStatisticCollector);
      e();
      new CPUReport().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      c();
      b(localStatisticCollector);
      AVEffectPendantReport.e();
      UniteDownloadDbOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      b();
      d();
      t();
      r();
      if (QLog.isColorLevel()) {
        QLog.d("StatisticCollector", 2, "**************report data below:*****************");
      }
      localObject5 = localSharedPreferences.edit();
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("LastTimeLogin_");
      ((StringBuilder)localObject6).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject5).putLong(((StringBuilder)localObject6).toString(), l2).commit();
    }
    if (((Calendar)localObject1).after(localObject2))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      ThemeUiPlugin.reportThemeNumAndCurrThemeName((QQAppInterface)localObject1, ((QQAppInterface)localObject1).getCurrentAccountUin());
      localObject1 = (ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      ((ChatBackgroundManager)localObject1).a((QQAppInterface)localObject2, ((QQAppInterface)localObject2).getCurrentAccountUin());
    }
    if (l1 == 0L)
    {
      localObject1 = localSharedPreferences.edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("LastTimeLogin_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), l2).commit();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.DailyReport
 * JD-Core Version:    0.7.0.1
 */