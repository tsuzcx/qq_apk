package com.tencent.mobileqq.statistics;

import agyv;
import aieq;
import aknx;
import aksm;
import aliw;
import alto;
import alvt;
import alxa;
import alys;
import amca;
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
import arrr;
import auad;
import aufn;
import awgf;
import awgg;
import awjk;
import axoc;
import azpr;
import azqs;
import azrh;
import azri;
import azrr;
import aztc;
import bddn;
import bdfp;
import bdgk;
import bdin;
import bdne;
import bead;
import beae;
import beag;
import beaj;
import becr;
import bhsb;
import bhsc;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageReportData;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
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
import lkp;
import lvz;

public class DailyReport
  extends AsyncStep
{
  private static int d = 50000;
  bead jdField_a_of_type_Bead = new azpr(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
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
      azqs.b(paramQQAppInterface, "CliOper", "", paramQQAppInterface.getCurrentAccountUin(), "Type_input", "Type_input", 0, 0, "", "", str, (String)localObject);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("MainActivityReportHelper", 1, "reportIMEInfo fail", paramQQAppInterface);
    }
  }
  
  private void a(String paramString)
  {
    int i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_op4dongtai");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Clk_data_wire_in", 8, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_op4buddylist");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Clk_data_wire_in", 21, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_op4recent");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Clk_data_wire_in", 22, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckpic");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_pic", 0, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckvideo");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_video", 0, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckfile");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_file", 0, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_cktxt");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_text", 0, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_cktkphoto");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_photo", 0, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_copy");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Long_press_copy", 0, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forward");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Long_press_retran", 0, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_delete");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Long_press_delete", 0, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_save2weiyun");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Long_press_weiyun", 0, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckadv");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "data_wire_setting", 0, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckviewrecvfile");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Chkfiles_data_wire", 0, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckclearmsg");
    if (i > 0) {
      azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Clean_data_wire", 0, i, 0);
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("auto_receive_files", false);
    azri localazri = azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    HashMap localHashMap = new HashMap();
    localHashMap.clear();
    if (bool) {}
    for (i = 1;; i = 0)
    {
      localHashMap.put("auto_receive_files", Integer.valueOf(i));
      localazri.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, localHashMap);
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forwardin_text");
      if (i > 0) {
        azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Retran_text", 0, i, 0);
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forwardin_image");
      if (i > 0) {
        azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Retran_pic", 0, i, 0);
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forwardin_file");
      if (i > 0) {
        azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Retran_file", 0, i, 0);
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forwardin_link");
      if (i > 0) {
        azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Retran_link", 0, i, 0);
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_open_via_qq");
      if (i > 0) {
        azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Open_via_qq", 0, i, 0);
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_share_my_pc");
      if (i > 0) {
        azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "share_my_PC", 0, i, 0);
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_share_frd");
      if (i > 0) {
        azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "share_frd", 0, i, 0);
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "Clk_disconnect_wp");
      if (i > 0) {
        azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "Wifiphoto", "Clk_disconnect_wp", 0, i, 0);
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "Clk_wp_back");
      if (i > 0) {
        azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "Wifiphoto", "Clk_wp_back", 0, i, 0);
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "Open_wp");
      if (i > 0) {
        azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "Wifiphoto", "Open_wp", 0, i, 0);
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
      azqs.b(paramQQAppInterface, "0X800AAA1", "0X800AAA1", "0X800AAA1", "", 0, "", str2, str1, "", "", "", "", "", "");
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
    int i = (int)Math.min(bdgk.j(), bdgk.i());
    int j = bdgk.b() * 100 + d;
    if (i <= 240) {
      i = j + 1;
    }
    for (;;)
    {
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      azri.a(BaseApplication.getContext()).a(paramString, "reportDeviceProfile", false, 0L, 0L, (HashMap)localObject, "");
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
  
  private void c(azri paramazri)
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
      paramazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "report_skin_engine_enable", bool, 0L, 0L, localHashMap, "");
      return;
      i = 89051;
      break;
    }
  }
  
  private void d(azri paramazri)
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.sApplication.getSystemService("activity");
    HashMap localHashMap = new HashMap();
    int i = localActivityManager.getMemoryClass();
    localHashMap.put("param_FailCode", Integer.toString(89000 + i));
    paramazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "report_mem_cache_size", false, i, 0L, localHashMap, "");
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() != 0)
    {
      i = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d() == 0) {
        break label673;
      }
      j = 1;
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != 0) {
        break label678;
      }
      k = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b() != 0) {
        break label683;
      }
      m = 0;
      boolean bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), null, "new_msg_notification_key", true);
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
      azqs.b((QQAppInterface)localObject, "dc00898", "", "", "0X800AD3B", "0X800AD3B", n, 0, "", "", "", "");
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (m == 0) {
        break label695;
      }
      n = 1;
      label205:
      azqs.b((QQAppInterface)localObject, "dc00898", "", "", "0X800AD3C", "0X800AD3C", n, 0, "", "", "", "");
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (i == 0) {
        break label701;
      }
      localObject = "1";
      label249:
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800A3CF", "0X800A3CF", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (j == 0) {
        break label709;
      }
      localObject = "1";
      label292:
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800A3D0", "0X800A3D0", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool1) {
        break label717;
      }
      localObject = "1";
      label336:
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800A3CE", "0X800A3CE", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (m == 0) {
        break label725;
      }
      localObject = "1";
      label380:
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800A3D1", "0X800A3D1", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (k == 0) {
        break label733;
      }
      localObject = "1";
      label423:
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800A3D2", "0X800A3D2", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool2) {
        break label741;
      }
      localObject = "1";
      label467:
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800A512", "0X800A512", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bhsb.a(true)) {
        break label749;
      }
      localObject = "1";
      label513:
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800A6E8", "0X800A6E8", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bhsb.a(false)) {
        break label757;
      }
      localObject = "1";
      label559:
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800A6E9", "0X800A6E9", 0, 0, (String)localObject, "", "", "");
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool3) {
        break label765;
      }
      i = 1;
      label600:
      azqs.b((QQAppInterface)localObject, "CliOper", "", "", "0X800AC8B", "0X800AC8B", i, 0, "", "", "", "");
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool4) {
        break label770;
      }
    }
    label770:
    for (int i = 1;; i = 2)
    {
      azqs.b((QQAppInterface)localObject, "CliOper", "", "", "0X800AC8C", "0X800AC8C", i, 0, "", "", "", "");
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
  
  private void e(azri paramazri)
  {
    if (paramazri == null) {
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
          paramazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arOpenGLSupport", bool, 0L, 0L, localHashMap, "");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DailyReport", 2, "reportOpenglSupport", localThrowable);
        }
        paramazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arOpenGLSupport", false, 0L, 0L, null, "");
        return;
      }
      String str2 = String.valueOf(0);
    }
  }
  
  private void f()
  {
    Object localObject = agyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QQAppInterface localQQAppInterface;
    if (localObject != null)
    {
      boolean bool = ((agyv)localObject).b();
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool) {
        break label57;
      }
    }
    label57:
    for (localObject = "1";; localObject = "2")
    {
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800A224", "0X800A224", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
  
  private void f(azri paramazri)
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
            paramazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arSensorSupport", true, 0L, 0L, localHashMap, "");
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
        paramazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arSensorSupport", false, 0L, 0L, null, "");
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
    int i = azrr.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("Click_grp_asst", Integer.valueOf(i));
    }
    i = azrr.b(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_setting_asst", Integer.valueOf(i));
    }
    i = azrr.c(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_setting_msg", Integer.valueOf(i));
    }
    i = azrr.d(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_msg_equ", Integer.valueOf(i));
    }
    i = azrr.e(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_msg_dec", Integer.valueOf(i));
    }
    i = azrr.f(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_msg_inc", Integer.valueOf(i));
    }
    azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localHashMap);
  }
  
  private void h()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    azri localazri = azri.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    int i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "ep_tab");
    if (i > 0) {
      localazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "ep_tab", 1, i, 0);
    }
    i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "ep_mall_in2");
    if (i > 0) {
      localazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "ep_mall_in", 2, i, 0);
    }
    Object localObject = (aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    if (localObject != null)
    {
      localObject = ((aufn)localObject).a();
      if (localObject == null) {}
    }
    for (i = ((List)localObject).size();; i = 0)
    {
      localObject = new HashMap();
      ((Map)localObject).put("Ep_amount", Integer.valueOf(i));
      localazri.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, (Map)localObject);
      i = 0;
      while (i < 3)
      {
        int j = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "ep_tab2" + i);
        localazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "ep_tab2", 0, j, 0, i);
        i += 1;
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "Ep_manage");
      if (i > 0) {
        localazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "Ep_manage", 0, i, 0);
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "Clk_ep_edit");
      if (i > 0) {
        localazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "Clk_ep_edit", 0, i, 0);
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "Delete_ep");
      if (i > 0) {
        localazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "Delete_ep", 0, i, 0);
      }
      i = azrh.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "Ep_order");
      if (i > 0) {
        localazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "Ep_order", 0, i, 0);
      }
      return;
    }
  }
  
  private void i()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject2 = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject2 != null)
    {
      localObject1 = ((alto)localObject2).a((String)localObject1);
      if ((localObject1 != null) && (((ExtensionInfo)localObject1).isPendantValid())) {}
    }
    else
    {
      return;
    }
    File localFile = new File(bdfp.b(((ExtensionInfo)localObject1).pendantId, 4));
    if (!localFile.exists())
    {
      localObject2 = (beag)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
      String str = bdfp.c(((ExtensionInfo)localObject1).pendantId, 4);
      Bundle localBundle = new Bundle();
      localBundle.putLong("id", ((ExtensionInfo)localObject1).pendantId);
      localObject1 = new beae(str, localFile);
      ((beag)localObject2).a(1).a((beae)localObject1, this.jdField_a_of_type_Bead, localBundle);
      return;
    }
    localObject2 = bdfp.a(localFile);
    VasWebviewUtil.reportVasStatus("AvatarPendant", "AvatarPendantOn", String.valueOf(((ExtensionInfo)localObject1).pendantId), 0, 0, 0, 0, (String)localObject2, "");
  }
  
  private void j()
  {
    List localList = ((aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a();
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
          break label142;
        }
        if (str.equals("")) {
          str = ((EmoticonPackage)localObject).epId;
        }
      }
    }
    label142:
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
    String str3 = ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).c(null);
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
    VasWebviewUtil.reportVasStatus("0X800498F", "0X800498F", ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g(), 0);
  }
  
  private void m()
  {
    amca localamca = (amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
    VasWebviewUtil.reportVasStatus("0X8004990", "0X8004990", String.valueOf(localamca.b()), localamca.g(), 0);
  }
  
  private void n()
  {
    boolean bool1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name());
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
    String str = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp().getSharedPreferences("sticker_pref", 0).getBoolean("sticker_switch_" + str, true)) && (EmojiStickerManager.a())) {}
    for (boolean bool = true;; bool = false)
    {
      EmojiStickerManager.e = bool;
      if (!EmojiStickerManager.e) {
        break;
      }
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "SwitchOn", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
    }
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "SwitchOff", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  private void p()
  {
    Object localObject1 = (aknx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (localObject1 != null)
    {
      localObject1 = ((aknx)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      int i;
      Object localObject2;
      int j;
      if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).apolloStatus == 1))
      {
        Object localObject3 = ((ApolloBaseInfo)localObject1).getApolloDress();
        i = 0;
        localObject2 = new StringBuilder();
        if (localObject3 != null)
        {
          int k = ((aksm)localObject3).a;
          localObject3 = ((aksm)localObject3).a();
          int m = localObject3.length;
          j = 0;
          for (;;)
          {
            i = k;
            if (j >= m) {
              break;
            }
            ((StringBuilder)localObject2).append(localObject3[j]).append("|");
            j += 1;
          }
        }
        j = aknx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "dress", 0, 0, i + "", ((ApolloBaseInfo)localObject1).apolloVipFlag + "", ((StringBuilder)localObject2).toString(), String.valueOf(j + 1));
      }
      for (;;)
      {
        if ((aknx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) && (localObject1 != null)) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "white", 0, 0, ((ApolloBaseInfo)localObject1).apolloStatus + "", "0", "", "");
        }
        localObject1 = (aliw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
        if (localObject1 == null) {
          break;
        }
        localObject2 = ((aliw)localObject1).e();
        if (localObject2 != null) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "action_added", ((List)localObject2).size(), 0, "0", "0", "", "");
        }
        if ((((aliw)localObject1).a == null) || (((aliw)localObject1).a.isEmpty())) {
          break;
        }
        localObject1 = ((aliw)localObject1).a.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          try
          {
            i = (int)Float.parseFloat((String)((Map.Entry)localObject2).getValue());
            j = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "game_downloaded", 0, 0, String.valueOf(j), String.valueOf(i), "", "");
          }
          catch (Exception localException) {}
        }
        if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).apolloStatus == 2)) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "close", 0, 0, "0", "0", "", "");
        }
      }
    }
  }
  
  private void q()
  {
    Object localObject = (alys)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(102);
    QQAppInterface localQQAppInterface;
    if (((alys)localObject).d)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((alys)localObject).a()) {
        break label63;
      }
    }
    label63:
    for (localObject = "1";; localObject = "0")
    {
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X8005B8B", "0X8005B8B", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
  
  private void r()
  {
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    QQAppInterface localQQAppInterface;
    if (localawgf != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localawgf.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      if (localNearbyPeopleCard != null)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!localNearbyPeopleCard.switchHobby) {
          break label140;
        }
        str = "1";
        azqs.b(localQQAppInterface, "CliStatus", "", "", "0X8004A12", "0X8004A12", 0, 0, str, "", "", "");
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
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X8004A13", "0X8004A13", 0, 0, str, "", "", "");
      localawgf.a();
      return;
      str = "0";
      break;
    }
  }
  
  /* Error */
  private void s()
  {
    // Byte code:
    //   0: new 634	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 635	java/lang/StringBuilder:<init>	()V
    //   7: invokestatic 972	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   10: invokevirtual 975	java/io/File:getPath	()Ljava/lang/String;
    //   13: invokevirtual 640	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 977
    //   19: invokevirtual 640	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 644	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore 15
    //   27: new 667	java/io/File
    //   30: dup
    //   31: aload 15
    //   33: invokespecial 678	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 14
    //   38: aconst_null
    //   39: astore 13
    //   41: iconst_0
    //   42: istore 5
    //   44: iconst_0
    //   45: istore 4
    //   47: aload 14
    //   49: invokevirtual 681	java/io/File:exists	()Z
    //   52: ifne +4 -> 56
    //   55: return
    //   56: invokestatic 781	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   59: getstatic 980	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:batteryCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   62: invokevirtual 790	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   65: invokevirtual 982	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 12
    //   70: aload 12
    //   72: invokestatic 987	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifne +165 -> 240
    //   78: aload 12
    //   80: ldc_w 989
    //   83: invokevirtual 991	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   86: ifeq +154 -> 240
    //   89: aload 12
    //   91: aload 12
    //   93: ldc_w 989
    //   96: invokevirtual 995	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   99: iconst_1
    //   100: iadd
    //   101: aload 12
    //   103: invokevirtual 996	java/lang/String:length	()I
    //   106: invokevirtual 1000	java/lang/String:substring	(II)Ljava/lang/String;
    //   109: astore 12
    //   111: aload 12
    //   113: ldc_w 1002
    //   116: invokevirtual 1006	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   119: iconst_1
    //   120: aaload
    //   121: invokestatic 915	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   124: fstore_1
    //   125: iload 5
    //   127: istore_3
    //   128: invokestatic 1010	java/lang/Math:random	()D
    //   131: fload_1
    //   132: f2d
    //   133: dcmpg
    //   134: ifgt +646 -> 780
    //   137: iload 5
    //   139: istore_3
    //   140: aload 14
    //   142: invokevirtual 1014	java/io/File:listFiles	()[Ljava/io/File;
    //   145: astore 12
    //   147: iload 5
    //   149: istore_3
    //   150: new 1016	java/util/ArrayList
    //   153: dup
    //   154: invokespecial 1017	java/util/ArrayList:<init>	()V
    //   157: astore 16
    //   159: aload 12
    //   161: ifnull +112 -> 273
    //   164: iload 5
    //   166: istore_3
    //   167: aload 12
    //   169: arraylength
    //   170: ifle +103 -> 273
    //   173: iload 5
    //   175: istore_3
    //   176: aload 12
    //   178: arraylength
    //   179: istore 6
    //   181: iconst_0
    //   182: istore_2
    //   183: iload_2
    //   184: iload 6
    //   186: if_icmpge +87 -> 273
    //   189: iload 5
    //   191: istore_3
    //   192: aload 12
    //   194: iload_2
    //   195: aaload
    //   196: invokevirtual 1020	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   199: astore 17
    //   201: aload 17
    //   203: ifnull +30 -> 233
    //   206: iload 5
    //   208: istore_3
    //   209: aload 17
    //   211: ldc_w 1022
    //   214: invokevirtual 1025	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   217: ifeq +16 -> 233
    //   220: iload 5
    //   222: istore_3
    //   223: aload 16
    //   225: aload 17
    //   227: invokeinterface 1026 2 0
    //   232: pop
    //   233: iload_2
    //   234: iconst_1
    //   235: iadd
    //   236: istore_2
    //   237: goto -54 -> 183
    //   240: ldc_w 1028
    //   243: astore 12
    //   245: goto -134 -> 111
    //   248: astore 12
    //   250: invokestatic 449	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +13 -> 266
    //   256: ldc_w 528
    //   259: iconst_2
    //   260: ldc_w 1030
    //   263: invokestatic 1033	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: ldc_w 1034
    //   269: fstore_1
    //   270: goto -145 -> 125
    //   273: aload 13
    //   275: astore 12
    //   277: iload 4
    //   279: istore_2
    //   280: iload 5
    //   282: istore_3
    //   283: aload 16
    //   285: invokeinterface 77 1 0
    //   290: ifle +106 -> 396
    //   293: iload 5
    //   295: istore_3
    //   296: aload 16
    //   298: invokeinterface 77 1 0
    //   303: iconst_5
    //   304: if_icmpge +409 -> 713
    //   307: iload 5
    //   309: istore_3
    //   310: new 634	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 635	java/lang/StringBuilder:<init>	()V
    //   317: aload 15
    //   319: invokevirtual 640	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc_w 1036
    //   325: invokevirtual 640	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokestatic 1041	java/lang/System:currentTimeMillis	()J
    //   331: invokevirtual 1044	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   334: ldc_w 1046
    //   337: invokevirtual 640	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 644	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: astore 12
    //   345: iload 5
    //   347: istore_3
    //   348: aload 16
    //   350: aload 12
    //   352: invokestatic 1051	bdhb:a	(Ljava/util/List;Ljava/lang/String;)Z
    //   355: ifeq +249 -> 604
    //   358: iload 5
    //   360: istore_3
    //   361: new 667	java/io/File
    //   364: dup
    //   365: aload 12
    //   367: invokespecial 678	java/io/File:<init>	(Ljava/lang/String;)V
    //   370: astore 12
    //   372: iload 5
    //   374: istore_3
    //   375: aload 12
    //   377: invokevirtual 681	java/io/File:exists	()Z
    //   380: istore 7
    //   382: iload 4
    //   384: istore_2
    //   385: iload 7
    //   387: ifne +9 -> 396
    //   390: aconst_null
    //   391: astore 12
    //   393: iload 4
    //   395: istore_2
    //   396: aload 12
    //   398: ifnull +379 -> 777
    //   401: new 1053	org/json/JSONObject
    //   404: dup
    //   405: invokespecial 1054	org/json/JSONObject:<init>	()V
    //   408: astore 13
    //   410: new 1053	org/json/JSONObject
    //   413: dup
    //   414: invokespecial 1054	org/json/JSONObject:<init>	()V
    //   417: astore 15
    //   419: aload 15
    //   421: ldc_w 1056
    //   424: aload 12
    //   426: invokevirtual 1020	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   429: invokevirtual 1059	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   432: pop
    //   433: new 1053	org/json/JSONObject
    //   436: dup
    //   437: invokespecial 1054	org/json/JSONObject:<init>	()V
    //   440: astore 12
    //   442: aload 12
    //   444: ldc_w 1061
    //   447: invokestatic 1065	com/tencent/mfsdk/MagnifierSDK:a	()Ljava/lang/String;
    //   450: invokevirtual 1059	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   453: pop
    //   454: aload 12
    //   456: ldc_w 1067
    //   459: bipush 17
    //   461: invokestatic 377	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   464: invokevirtual 1059	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   467: pop
    //   468: aload 13
    //   470: ldc_w 1069
    //   473: aload 15
    //   475: invokevirtual 1059	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   478: pop
    //   479: aload 13
    //   481: ldc_w 1071
    //   484: aload 12
    //   486: invokevirtual 1059	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   489: pop
    //   490: aload 13
    //   492: ldc_w 1073
    //   495: bipush 104
    //   497: invokevirtual 1076	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   500: pop
    //   501: lconst_0
    //   502: lstore 10
    //   504: aload_0
    //   505: getfield 197	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   508: invokevirtual 426	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   511: invokestatic 1082	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   514: lstore 8
    //   516: new 1084	com/tencent/mfsdk/collector/ResultObject
    //   519: dup
    //   520: iconst_0
    //   521: ldc_w 1086
    //   524: iconst_1
    //   525: lconst_1
    //   526: lconst_1
    //   527: aload 13
    //   529: iconst_1
    //   530: iconst_1
    //   531: lload 8
    //   533: invokespecial 1089	com/tencent/mfsdk/collector/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   536: invokestatic 1094	com/tencent/mfsdk/reporter/ReporterMachine:a	(Lcom/tencent/mfsdk/collector/ResultObject;)V
    //   539: iconst_1
    //   540: istore_2
    //   541: iload_2
    //   542: istore_3
    //   543: iload_2
    //   544: ifle +125 -> 669
    //   547: aload 14
    //   549: invokevirtual 1014	java/io/File:listFiles	()[Ljava/io/File;
    //   552: astore 12
    //   554: iload_2
    //   555: istore_3
    //   556: aload 12
    //   558: ifnull +111 -> 669
    //   561: iload_2
    //   562: istore_3
    //   563: aload 12
    //   565: arraylength
    //   566: ifle +103 -> 669
    //   569: aload 12
    //   571: arraylength
    //   572: istore 5
    //   574: iconst_0
    //   575: istore 4
    //   577: iload_2
    //   578: istore_3
    //   579: iload 4
    //   581: iload 5
    //   583: if_icmpge +86 -> 669
    //   586: aload 12
    //   588: iload 4
    //   590: aaload
    //   591: invokevirtual 1097	java/io/File:delete	()Z
    //   594: pop
    //   595: iload 4
    //   597: iconst_1
    //   598: iadd
    //   599: istore 4
    //   601: goto -24 -> 577
    //   604: aload 13
    //   606: astore 12
    //   608: iload 4
    //   610: istore_2
    //   611: iload 5
    //   613: istore_3
    //   614: invokestatic 449	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   617: ifeq -221 -> 396
    //   620: iload 5
    //   622: istore_3
    //   623: ldc_w 528
    //   626: iconst_2
    //   627: ldc_w 1099
    //   630: invokestatic 1033	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: aload 13
    //   635: astore 12
    //   637: iload 4
    //   639: istore_2
    //   640: goto -244 -> 396
    //   643: astore 12
    //   645: iload_3
    //   646: istore_2
    //   647: iload_2
    //   648: istore_3
    //   649: invokestatic 449	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   652: ifeq +17 -> 669
    //   655: ldc_w 528
    //   658: iconst_2
    //   659: ldc_w 1101
    //   662: aload 12
    //   664: invokestatic 532	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   667: iload_2
    //   668: istore_3
    //   669: invokestatic 449	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   672: ifeq -617 -> 55
    //   675: ldc_w 528
    //   678: iconst_2
    //   679: new 634	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 635	java/lang/StringBuilder:<init>	()V
    //   686: ldc_w 1103
    //   689: invokevirtual 640	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: iload_3
    //   693: invokevirtual 643	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   696: ldc_w 1105
    //   699: invokevirtual 640	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: fload_1
    //   703: invokevirtual 1108	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   706: invokevirtual 644	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 1033	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: return
    //   713: iconst_3
    //   714: istore_2
    //   715: aload 13
    //   717: astore 12
    //   719: goto -323 -> 396
    //   722: astore 12
    //   724: lload 10
    //   726: lstore 8
    //   728: invokestatic 449	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   731: ifeq -215 -> 516
    //   734: ldc_w 528
    //   737: iconst_2
    //   738: ldc_w 1110
    //   741: aload 12
    //   743: invokestatic 532	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   746: lload 10
    //   748: lstore 8
    //   750: goto -234 -> 516
    //   753: astore 12
    //   755: iload_2
    //   756: istore_3
    //   757: invokestatic 449	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   760: ifeq +17 -> 777
    //   763: iload_2
    //   764: istore_3
    //   765: ldc_w 528
    //   768: iconst_2
    //   769: ldc_w 1112
    //   772: aload 12
    //   774: invokestatic 532	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   777: goto -236 -> 541
    //   780: iconst_2
    //   781: istore_2
    //   782: goto -241 -> 541
    //   785: astore 12
    //   787: goto -140 -> 647
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	790	0	this	DailyReport
    //   124	579	1	f	float
    //   182	600	2	i	int
    //   127	638	3	j	int
    //   45	593	4	k	int
    //   42	579	5	m	int
    //   179	8	6	n	int
    //   380	6	7	bool	boolean
    //   514	235	8	l1	long
    //   502	245	10	l2	long
    //   68	176	12	localObject1	Object
    //   248	1	12	localException1	Exception
    //   275	361	12	localObject2	Object
    //   643	20	12	localException2	Exception
    //   717	1	12	localJSONObject1	org.json.JSONObject
    //   722	20	12	localException3	Exception
    //   753	20	12	localException4	Exception
    //   785	1	12	localException5	Exception
    //   39	677	13	localJSONObject2	org.json.JSONObject
    //   36	512	14	localFile	File
    //   25	449	15	localObject3	Object
    //   157	192	16	localArrayList	java.util.ArrayList
    //   199	27	17	str	String
    // Exception table:
    //   from	to	target	type
    //   56	111	248	java/lang/Exception
    //   111	125	248	java/lang/Exception
    //   128	137	643	java/lang/Exception
    //   140	147	643	java/lang/Exception
    //   150	159	643	java/lang/Exception
    //   167	173	643	java/lang/Exception
    //   176	181	643	java/lang/Exception
    //   192	201	643	java/lang/Exception
    //   209	220	643	java/lang/Exception
    //   223	233	643	java/lang/Exception
    //   283	293	643	java/lang/Exception
    //   296	307	643	java/lang/Exception
    //   310	345	643	java/lang/Exception
    //   348	358	643	java/lang/Exception
    //   361	372	643	java/lang/Exception
    //   375	382	643	java/lang/Exception
    //   614	620	643	java/lang/Exception
    //   623	633	643	java/lang/Exception
    //   757	763	643	java/lang/Exception
    //   765	777	643	java/lang/Exception
    //   504	516	722	java/lang/Exception
    //   401	501	753	java/lang/Exception
    //   516	539	753	java/lang/Exception
    //   728	746	753	java/lang/Exception
    //   547	554	785	java/lang/Exception
    //   563	574	785	java/lang/Exception
    //   586	595	785	java/lang/Exception
  }
  
  private void t()
  {
    Map localMap = ((auad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(303)).a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((Boolean)localMap.get("temp_msg_setting_troop_")).booleanValue())
    {
      str = "1";
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 1, 1, str, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((Boolean)localMap.get("temp_msg_setting_nearby_")).booleanValue()) {
        break label345;
      }
      str = "1";
      label97:
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 2, 2, str, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((Boolean)localMap.get("temp_msg_setting_interest_v2")).booleanValue()) {
        break label352;
      }
      str = "1";
      label150:
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 3, 3, str, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((Boolean)localMap.get("temp_msg_setting_contact_")).booleanValue()) {
        break label359;
      }
      str = "1";
      label203:
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 4, 4, str, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((Boolean)localMap.get("temp_msg_setting_consult_")).booleanValue()) {
        break label366;
      }
      str = "1";
      label256:
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 5, 5, str, "", "", "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((Boolean)localMap.get("temp_msg_setting_circle_v2")).booleanValue()) {
        break label373;
      }
    }
    label345:
    label352:
    label359:
    label366:
    label373:
    for (String str = "1";; str = "0")
    {
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 6, 6, str, "", "", "");
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
    }
  }
  
  public int a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app;
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
    azri localazri;
    if ((((Calendar)localObject1).getTimeInMillis() - l2 - 100L >= 0L) || ((l1 > 0L) && (localCalendar1.after(localCalendar2))))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bddn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      NotifyPushSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      r();
      g();
      arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      a((String)localObject3);
      localObject4 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      localazri = azri.a((Context)localObject4);
    }
    label1434:
    label1735:
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
        lvz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        lvz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        o();
        localObject1 = (alxa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
        if ((localObject1 != null) && (((alxa)localObject1).h()))
        {
          if (((alxa)localObject1).b() == 1)
          {
            localObject1 = "devlock";
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "auth_mode", 1, 0, new String[] { "0", "0", localObject1 });
          }
        }
        else
        {
          Object localObject5 = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          localObject1 = null;
          if (localObject5 != null) {
            localObject1 = ((alto)localObject5).a((String)localObject3);
          }
          if (localObject1 != null) {
            VasWebviewUtil.reportVasStatus("FontStatus", "FontOn", String.valueOf(((ExtensionInfo)localObject1).uVipFont), 0, 0);
          }
          if (localObject1 != null)
          {
            j = ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g();
            if (j != 2) {
              continue;
            }
            i = 0;
            VasWebviewUtil.reportVasStatus("0X8004A26", "0X8004A26", String.valueOf(((ExtensionInfo)localObject1).colorRingId), i, 0);
          }
          i = ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g();
          if (localObject1 != null) {
            VasWebviewUtil.reportVasStatus("0X8005005", "0X8005005", String.valueOf(((ExtensionInfo)localObject1).commingRingId), i, 0);
          }
          j = becr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 6, true, null);
          if (i != 2) {
            break label753;
          }
          i = 0;
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "funcallnew", "setfuncall", 0, 0, String.valueOf(j), String.valueOf(i), String.valueOf(bdin.a(null)), "1");
          localObject1 = azrh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localObject1 == null) {
            break label763;
          }
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label763;
          }
          localObject5 = (MessageReportData)((Iterator)localObject1).next();
          if (((MessageReportData)localObject5).msgCount <= 0) {
            continue;
          }
          localazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageReportData)localObject5).getMsgReport());
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
      label753:
      if (i == 3)
      {
        i = 2;
        continue;
        label763:
        i = bddn.a((Context)localObject4, (String)localObject3);
        if (i > 0) {
          azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Setting_Quit", i);
        }
        i = NotifyPushSettingActivity.a((Context)localObject4, (String)localObject3, "LED_light");
        localObject2 = new HashMap();
        ((HashMap)localObject2).clear();
        ((HashMap)localObject2).put("LED_light", Integer.valueOf(i));
        localazri.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, (Map)localObject2);
        boolean bool;
        if (bhsc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))
        {
          bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, null, null, "qqsetting_show_badgeunread_key", true);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (bool)
          {
            localObject2 = "1";
            azqs.b((QQAppInterface)localObject4, "CliStatus", "", "", "0X8004BE8", "0X8004BE8", 0, 0, (String)localObject2, "", "", "");
          }
        }
        else
        {
          awjk.a();
          i = ThemeUtil.getThemeSwitchTimes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (i > 0) {
            localazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, "", "theme_mall", "theme_replace", 0, i, 0);
          }
          i = ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if (i > 0) {
            localazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, "", "background", "bkground_replace", 0, i, 0);
          }
          bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getString(2131694138), "qqsetting_lock_screen_whenexit_key", true);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (!Boolean.valueOf(bool).booleanValue()) {
            break label1685;
          }
        }
        for (localObject2 = "1";; localObject2 = "0")
        {
          azqs.b((QQAppInterface)localObject3, "CliStatus", "", "", "0X80040D9", "0X80040D9", 0, 0, (String)localObject2, "", "", "");
          d(localazri);
          c(localazri);
          try
          {
            if (Build.VERSION.SDK_INT < 19) {
              break label1434;
            }
            localObject3 = new HashMap();
            i = QQToast.a();
            ((HashMap)localObject3).put("notifationStat", String.valueOf(i));
            ((HashMap)localObject3).put("uinParam", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localObject2 = bdgk.j();
            if (localObject2 != null) {
              break label1735;
            }
            localObject2 = "";
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              int k;
              int m;
              if (QLog.isColorLevel()) {
                QLog.d("StatisticCollector", 2, "msg Notification report fail err:" + localThrowable.getMessage());
              }
            }
          }
          ((HashMap)localObject3).put("romInfo", localObject2);
          localObject4 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
          bool = ((SharedPreferences)localObject4).contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "_" + "push_open_notify_xml");
          j = ((SharedPreferences)localObject4).getInt("push_msg_notify_count", 0);
          k = ((SharedPreferences)localObject4).getInt("push_msg_notify_open", 0);
          m = ((SharedPreferences)localObject4).getInt("push_msg_notify_cancle", 0);
          ((HashMap)localObject3).put("hasConfigs", String.valueOf(bool));
          ((HashMap)localObject3).put("pushCount", String.valueOf(j));
          ((HashMap)localObject3).put("openCount", String.valueOf(k));
          ((HashMap)localObject3).put("cancleCount", String.valueOf(m));
          azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msgNotificationStatsTag", true, 0L, 0L, (HashMap)localObject3, "");
          if (QLog.isColorLevel()) {
            QLog.d("StatisticCollector", 2, String.format("msg Notification report value, notifationStat: %d, romInfo: %s", new Object[] { Integer.valueOf(i), localObject2 }));
          }
          azqs.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "push_value", "", "", "", 1, "", String.valueOf(i), String.valueOf(bool), String.valueOf(j), String.valueOf(k), String.valueOf(m), "", "");
          t();
          aieq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          f(localazri);
          a(localazri);
          e(localazri);
          f();
          new aztc().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          c();
          b(localazri);
          lkp.e();
          b();
          e();
          s();
          if (QLog.isColorLevel()) {
            QLog.d("StatisticCollector", 2, "**************report data below:*****************");
          }
          localSharedPreferences.edit().putLong("LastTimeLogin_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), l2).commit();
          if (localCalendar1.after(localCalendar2))
          {
            ThemeUiPlugin.reportThemeNumAndCurrThemeName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
  
  void a(azri paramazri)
  {
    if (paramazri == null) {
      return;
    }
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        int i = bdin.a(BaseApplication.getContext());
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
        paramazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "arMapWifiSwitchStatus", true, 0L, 0L, localHashMap, "");
        return;
      }
      catch (Throwable paramazri) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DailyReport", 2, "reportWifiSwitchStatus", paramazri);
      return;
      label160:
      boolean bool = false;
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("mobileQQ", 0);
    azrr.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    azrh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    bddn.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    ThemeUtil.resetThemeSwitchTimes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).b(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  void b(azri paramazri)
  {
    if (paramazri == null) {
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
        boolean bool = bdne.a();
        arrayOfInt = bdne.a();
        long l2 = bdne.a();
        if ((!bool) && (arrayOfInt[1] <= 0))
        {
          axoc.a().b(false);
          bdne.b();
        }
        l1 = -1L;
        if (l2 <= 0L) {
          break label300;
        }
        l1 = (System.currentTimeMillis() - l2) / 1000L;
      }
      catch (Throwable paramazri) {}
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
      paramazri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "reportQQFilterDownloadInfo", true, 0L, 0L, localHashMap, "");
      azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "acQQFilterDownloadCount", true, 0L, 0L, localHashMap, null);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DailyReport", 2, "reportWifiSwitchStatus", paramazri);
      return;
      label300:
      if (arrayOfInt[0] <= 0) {
        if (arrayOfInt[1] <= 0) {
          break;
        }
      }
    }
  }
  
  public void c()
  {
    Object localObject = (alvt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(186);
    boolean bool1 = ((alvt)localObject).c();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool2;
    if (bool1)
    {
      str = "1";
      azqs.b(localQQAppInterface, "CliStatus", "", "", "0X8007918", "0X8007918", 0, 0, str, "", "", "");
      bool2 = ((alvt)localObject).b();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bool2) {
        break label160;
      }
    }
    label160:
    for (String str = "1";; str = "2")
    {
      azqs.b((QQAppInterface)localObject, "CliStatus", "", "", "0X8007919", "0X8007919", 0, 0, str, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("DailyReport", 2, "reportVisitorLikeRankingStatus isRankingSwitch=" + bool1 + "isRankingNotificationSwitch=" + bool2);
      }
      return;
      str = "2";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.DailyReport
 * JD-Core Version:    0.7.0.1
 */