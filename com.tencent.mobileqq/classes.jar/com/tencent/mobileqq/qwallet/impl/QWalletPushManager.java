package com.tencent.mobileqq.qwallet.impl;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.qwallet.temp.IQQAppInterfaceTemp;
import com.qwallet.temp.IQWalletPBTemp;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QWalletGoldMsgTipsElem;
import com.tencent.mobileqq.data.QWalletSubmsgtype0x66.MsgBody;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.raw;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPayApi.PCPayData;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletLockScreenActivity;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletPushManager
{
  private static long jdField_a_of_type_Long;
  private static ArrayList<IQWalletPayApi.PCPayData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap(16);
  private static final long[] jdField_a_of_type_ArrayOfLong = { 100L, 200L, 200L, 100L };
  private static long b;
  
  public static int a()
  {
    Object localObject = jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      localObject = (IQWalletPayApi.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
      k = j;
      if (localObject != null)
      {
        k = j;
        if (((IQWalletPayApi.PCPayData)localObject).jdField_c_of_type_Int == 0) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 8: 
      return 14;
    case 7: 
      return 5;
    case 6: 
      return 6;
    case 5: 
      return 7;
    case 4: 
      return 8;
    case 3: 
      return 11;
    case 2: 
      return 4;
    }
    return 9;
  }
  
  private static IQWalletPayApi.PCPayData a()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilArrayList.size())
    {
      IQWalletPayApi.PCPayData localPCPayData = (IQWalletPayApi.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localPCPayData != null) && (localPCPayData.jdField_c_of_type_Int == 1)) {
        return localPCPayData;
      }
      i += 1;
    }
    return null;
  }
  
  public static IQWalletPayApi.PCPayData a(boolean paramBoolean)
  {
    Object localObject = jdField_a_of_type_JavaUtilArrayList;
    if (localObject == null) {
      return null;
    }
    if (paramBoolean)
    {
      i = ((ArrayList)localObject).size() - 1;
      while (i >= 0)
      {
        localObject = (IQWalletPayApi.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localObject != null) && (((IQWalletPayApi.PCPayData)localObject).jdField_c_of_type_Int == 0)) {
          return localObject;
        }
        i -= 1;
      }
    }
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (IQWalletPayApi.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localObject != null) && (((IQWalletPayApi.PCPayData)localObject).jdField_c_of_type_Int == 0)) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public static void a()
  {
    Object localObject = jdField_a_of_type_JavaUtilArrayList;
    if (localObject == null) {
      return;
    }
    int i = ((ArrayList)localObject).size() - 1;
    while (i >= 0)
    {
      localObject = (IQWalletPayApi.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localObject == null) || (((IQWalletPayApi.PCPayData)localObject).jdField_c_of_type_Int == 1)) {
        jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
      i -= 1;
    }
  }
  
  private static void a(BaseQQAppInterface paramBaseQQAppInterface, IQWalletPayApi.PCPayData paramPCPayData)
  {
    if ((paramBaseQQAppInterface != null) && (jdField_a_of_type_JavaUtilArrayList != null) && (paramPCPayData != null) && (paramPCPayData.jdField_b_of_type_Int >= 1) && (paramPCPayData.jdField_b_of_type_Int <= 7) && (!TextUtils.isEmpty(paramPCPayData.jdField_a_of_type_JavaLangString)))
    {
      if (paramPCPayData.jdField_b_of_type_Int == 1) {
        jdField_b_of_type_Long = VACDReportUtil.a(null, "qqwallet", "pay-pcpush", "payinvoke", null, 0, null);
      }
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        jdField_a_of_type_JavaUtilArrayList.add(paramPCPayData);
        if (b(paramBaseQQAppInterface))
        {
          if (jdField_b_of_type_Long != 0L) {
            VACDReportUtil.a(jdField_b_of_type_Long, null, "startForegroundPay", null, 0, null);
          }
          b(paramBaseQQAppInterface);
        }
        else
        {
          if (jdField_b_of_type_Long != 0L) {
            VACDReportUtil.a(jdField_b_of_type_Long, null, "startBackgroundPay", null, 0, null);
          }
          c(paramBaseQQAppInterface, paramPCPayData);
        }
        jdField_b_of_type_Long = 0L;
        b(paramBaseQQAppInterface, paramPCPayData);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("params error, pcPayDatas=");
      ((StringBuilder)???).append(jdField_a_of_type_JavaUtilArrayList);
      ((StringBuilder)???).append(",app=");
      ((StringBuilder)???).append(paramBaseQQAppInterface);
      ((StringBuilder)???).append(",pcPayData=");
      ((StringBuilder)???).append(paramPCPayData);
      QLog.d("Q.qwallet.push", 2, ((StringBuilder)???).toString());
    }
  }
  
  private static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "PCPayData is empty.");
      }
      return;
    }
    if (paramBaseQQAppInterface == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int k = 0;
        int j = 0;
        int i = 0;
        int m = paramString.optInt("module", 0);
        int n = paramString.optInt("action", 0);
        if ((m >= 1) && (m <= 8) && (n >= 1))
        {
          if (n > 2) {
            return;
          }
          if ((m == 1) && (n == 1))
          {
            paramString = paramBaseQQAppInterface.getApp();
            if (Build.VERSION.SDK_INT > 10) {
              i = 4;
            }
            paramString = paramString.getSharedPreferences("qwallet_multi", i);
            if (paramString != null) {
              paramString.edit().putBoolean("is_refresh_home", true).commit();
            }
            i = 1;
          }
          else
          {
            StringBuilder localStringBuilder;
            if ((m == 1) && (n == 2))
            {
              paramString = new StringBuilder();
              paramString.append("qwallet_home_recomment_");
              paramString.append(paramBaseQQAppInterface.getCurrentAccountUin());
              paramString = MD5.toMD5(paramString.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramBaseQQAppInterface.getApp().getFilesDir());
              localStringBuilder.append("/");
              localStringBuilder.append(paramString);
              FileUtils.deleteFile(localStringBuilder.toString());
              paramString = new StringBuilder();
              paramString.append("qwallet_home_recomment_");
              paramString.append(paramBaseQQAppInterface.getCurrentAccountUin());
              paramString = MD5.toMD5(paramString.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramBaseQQAppInterface.getApp().getFilesDir());
              localStringBuilder.append("/");
              localStringBuilder.append(paramString);
              localStringBuilder.append("_");
              FileUtils.deleteFile(localStringBuilder.toString());
              continue;
            }
            if ((m == 2) && (n == 1))
            {
              paramString = paramBaseQQAppInterface.getApp();
              i = k;
              if (Build.VERSION.SDK_INT > 10) {
                i = 4;
              }
              paramString = paramString.getSharedPreferences("qwallet_multi", i);
              if (paramString == null) {
                continue;
              }
              paramString.edit().putBoolean("is_refresh_center", true).commit();
              continue;
            }
            if ((m == 2) && (n == 2))
            {
              paramString = new StringBuilder();
              paramString.append("qwallet_home_personalInfo_");
              paramString.append(paramBaseQQAppInterface.getCurrentAccountUin());
              paramString = MD5.toMD5(paramString.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramBaseQQAppInterface.getApp().getFilesDir());
              localStringBuilder.append("/");
              localStringBuilder.append(paramString);
              FileUtils.deleteFile(localStringBuilder.toString());
              continue;
            }
            i = j;
            if (m == 8)
            {
              i = j;
              if (n == 1)
              {
                ((IQWalletConfigService)paramBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "")).getAllConfig(0);
                i = j;
              }
            }
          }
          if ((i != 0) && (QWalletHelperDelegate.isQWalletProcessExist(paramBaseQQAppInterface.getApp())))
          {
            if (m != 1) {
              break label577;
            }
            paramString = "com.qwallet.refresh.home";
            b(paramBaseQQAppInterface, paramString);
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramBaseQQAppInterface)
      {
        paramBaseQQAppInterface.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("Q.qwallet.push", 2, "Parsing PCPAYDATA throws JSONException.");
        }
      }
      return;
      label577:
      paramString = "com.qwallet.refresh.center";
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onQQForeground isFromGestureLock=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.qwallet.push", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBaseQQAppInterface == null) {
      return;
    }
    if (a(false) == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 5;
    } else {
      i = 1000;
    }
    Object localObject = ThreadManager.getSubThreadHandler();
    if (localObject != null) {
      ((MqqHandler)localObject).postDelayed(new QWalletPushManager.1(paramBaseQQAppInterface), i);
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, byte[] paramArrayOfByte, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if (a(paramLong1, paramInt1, paramLong2, paramInt2)) {
        return;
      }
      try
      {
        paramArrayOfByte = ((IQWalletPBTemp)QRoute.api(IQWalletPBTemp.class)).convertSubmsgtype0x66$MsgBody(paramArrayOfByte);
        paramInt1 = paramArrayOfByte.pushType;
        try
        {
          paramArrayOfByte = paramArrayOfByte.pushData;
        }
        catch (Exception paramArrayOfByte) {}
        paramArrayOfByte.printStackTrace();
      }
      catch (Exception paramArrayOfByte)
      {
        paramInt1 = -1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "Parsing Msg0x210Sub0x66 data throws Exception.");
      }
      paramArrayOfByte = null;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pushType = ");
        ((StringBuilder)localObject).append(paramInt1);
        QLog.d("Q.qwallet.push", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt1 != -1)
      {
        if (paramArrayOfByte == null) {
          return;
        }
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 4) {
              if (paramInt1 != 5)
              {
                if (paramInt1 != 8)
                {
                  if (QLog.isColorLevel()) {
                    QLog.w("Q.qwallet.push", 2, "Unknow pushType.");
                  }
                }
                else
                {
                  try
                  {
                    paramBaseQQAppInterface = ((IQWalletPBTemp)QRoute.api(IQWalletPBTemp.class)).convertTroopTips(paramArrayOfByte);
                    if (paramBaseQQAppInterface.type != 3) {
                      return;
                    }
                    NotifyMsgApiImpl.onReceiveAAPaySysNotifyStatic(0, paramBaseQQAppInterface, null);
                    return;
                  }
                  catch (Exception paramBaseQQAppInterface)
                  {
                    if (!QLog.isColorLevel()) {
                      return;
                    }
                  }
                  paramBaseQQAppInterface.printStackTrace();
                }
              }
              else
              {
                try
                {
                  localObject = new String(paramArrayOfByte, "UTF-8");
                  if (TextUtils.isEmpty((CharSequence)localObject)) {
                    return;
                  }
                  paramArrayOfByte = new IQWalletPayApi.PCPayData();
                  paramArrayOfByte.jdField_b_of_type_Long = System.currentTimeMillis();
                  localObject = new JSONObject((String)localObject);
                  paramArrayOfByte.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("tradeTime", 0L);
                  paramArrayOfByte.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("expTime", 0);
                  paramArrayOfByte.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("payType", 0);
                  paramArrayOfByte.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("notifyText");
                  JSONObject localJSONObject1 = new JSONObject();
                  localJSONObject1.put("viewTag", "hbPackConfirm");
                  localJSONObject1.put("comeForm", 2);
                  localJSONObject1.put("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#pc@0001");
                  JSONObject localJSONObject2 = new JSONObject();
                  localJSONObject2.putOpt("push_data", ((JSONObject)localObject).optString("key", ""));
                  localJSONObject1.put("extra_data", localJSONObject2.toString());
                  paramArrayOfByte.jdField_a_of_type_JavaLangString = localJSONObject1.toString();
                  a(paramBaseQQAppInterface, paramArrayOfByte);
                  return;
                }
                catch (Exception paramBaseQQAppInterface)
                {
                  if (!QLog.isColorLevel()) {
                    return;
                  }
                }
                QLog.e("Q.qwallet.push", 2, "Coverting pushData Exception.", paramBaseQQAppInterface);
              }
            }
          }
          else
          {
            try
            {
              a(paramBaseQQAppInterface, new String(paramArrayOfByte, "UTF-8"));
              return;
            }
            catch (Exception paramBaseQQAppInterface)
            {
              if (!QLog.isColorLevel()) {
                return;
              }
            }
            QLog.e("Q.qwallet.push", 2, "Coverting pushData Exception.", paramBaseQQAppInterface);
          }
        }
        else {
          try
          {
            localObject = new String(paramArrayOfByte, "UTF-8");
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              paramArrayOfByte = new IQWalletPayApi.PCPayData();
              paramArrayOfByte.jdField_b_of_type_Long = System.currentTimeMillis();
              localObject = new JSONObject((String)localObject);
              paramArrayOfByte.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("tradeTime", 0L);
              paramArrayOfByte.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("expTime", 0);
              paramArrayOfByte.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("payType", 0);
              paramArrayOfByte.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("notifyText");
              localObject = ((JSONObject)localObject).optJSONObject("payData");
              if (localObject != null) {
                paramArrayOfByte.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).toString();
              }
              a(paramBaseQQAppInterface, paramArrayOfByte);
              return;
            }
          }
          catch (Exception paramBaseQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.qwallet.push", 2, "Coverting pushData Exception.", paramBaseQQAppInterface);
            }
          }
        }
      }
    }
  }
  
  protected static boolean a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    ??? = new StringBuilder(32);
    ((StringBuilder)???).append(paramLong1);
    ((StringBuilder)???).append(paramInt1);
    ((StringBuilder)???).append(paramLong2);
    ((StringBuilder)???).append(paramInt2);
    String str = ((StringBuilder)???).toString();
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    paramLong1 = System.currentTimeMillis();
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      if (Math.abs(paramLong1 - jdField_a_of_type_Long) > 1800000L) {
        jdField_a_of_type_JavaUtilHashMap.clear();
      } else if (jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        return true;
      }
      jdField_a_of_type_JavaUtilHashMap.put(str, null);
      jdField_a_of_type_Long = paramLong1;
      return false;
    }
  }
  
  public static void b()
  {
    ArrayList localArrayList = jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return;
    }
    localArrayList.clear();
  }
  
  private static void b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (jdField_a_of_type_JavaUtilArrayList == null) {
        return;
      }
      boolean bool1 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQUtils$isScreenLocked(paramBaseQQAppInterface.getApp());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startForegroundPay isScreenLock=");
        ((StringBuilder)localObject).append(bool1);
        QLog.d("Q.qwallet.push", 2, ((StringBuilder)localObject).toString());
      }
      if (bool1) {
        return;
      }
      Object localObject = a();
      boolean bool2 = false;
      bool1 = false;
      if (localObject == null)
      {
        if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject = (IQWalletPayApi.PCPayData)jdField_a_of_type_JavaUtilArrayList.get(0);
          if (localObject == null)
          {
            jdField_a_of_type_JavaUtilArrayList.remove(0);
            b(paramBaseQQAppInterface);
            return;
          }
          int i = a(((IQWalletPayApi.PCPayData)localObject).jdField_b_of_type_Int);
          if (i == 0)
          {
            jdField_a_of_type_JavaUtilArrayList.remove(0);
            b(paramBaseQQAppInterface);
            return;
          }
          bool2 = PayBridgeActivity.isPaying();
          if ((!bool2) || (QWalletHelperDelegate.isQWalletProcessExist(paramBaseQQAppInterface.getApplication().getApplicationContext()))) {
            bool1 = bool2;
          }
          if (bool1) {
            return;
          }
          ((IQWalletPayApi.PCPayData)localObject).jdField_c_of_type_Int = 1;
          try
          {
            paramBaseQQAppInterface = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
            paramBaseQQAppInterface.addFlags(872415232);
            paramBaseQQAppInterface.putExtra("json", ((IQWalletPayApi.PCPayData)localObject).jdField_a_of_type_JavaLangString);
            paramBaseQQAppInterface.putExtra("callbackSn", "0");
            paramBaseQQAppInterface.putExtra("payparmas_from_pcpush", true);
            paramBaseQQAppInterface.putExtra("pay_requestcode", i);
            paramBaseQQAppInterface.putExtra("payparmas_paytype", 2);
            paramBaseQQAppInterface.putExtra("vacreport_key_seq", jdField_b_of_type_Long);
            BaseApplication.getContext().startActivity(paramBaseQQAppInterface);
            return;
          }
          catch (Exception paramBaseQQAppInterface)
          {
            ((IQWalletPayApi.PCPayData)localObject).jdField_c_of_type_Int = 2;
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.e("Q.qwallet.push", 2, "Starting pay throws Exception.", paramBaseQQAppInterface);
        }
      }
      else
      {
        boolean bool3 = PayBridgeActivity.isPaying();
        bool1 = bool3;
        if (bool3)
        {
          bool1 = bool3;
          if (!QWalletHelperDelegate.isQWalletProcessExist(paramBaseQQAppInterface.getApplication().getApplicationContext())) {
            bool1 = false;
          }
        }
        if (bool1)
        {
          long l = System.currentTimeMillis();
          if (((IQWalletPayApi.PCPayData)localObject).jdField_c_of_type_Long + 43200000L > l) {
            bool1 = bool2;
          }
        }
        if (!bool1)
        {
          ((IQWalletPayApi.PCPayData)localObject).jdField_c_of_type_Int = 2;
          b(paramBaseQQAppInterface);
        }
      }
    }
  }
  
  private static void b(BaseQQAppInterface paramBaseQQAppInterface, IQWalletPayApi.PCPayData paramPCPayData)
  {
    if (((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQUtils$isScreenLocked(paramBaseQQAppInterface.getApp()))
    {
      ((PowerManager)paramBaseQQAppInterface.getApp().getSystemService("power")).newWakeLock(268435462, "Q.qwallet.push").acquire(10000L);
      String str2 = String.format(BaseApplication.getContext().getString(R.string.dn), new Object[] { Integer.valueOf(a()) });
      String str1;
      if (!TextUtils.isEmpty(paramPCPayData.jdField_b_of_type_JavaLangString)) {
        str1 = paramPCPayData.jdField_b_of_type_JavaLangString;
      } else {
        str1 = BaseApplication.getContext().getString(R.string.dm);
      }
      Intent localIntent = new Intent(paramBaseQQAppInterface.getApp(), QWalletLockScreenActivity.class);
      localIntent.addFlags(67108864);
      localIntent.addFlags(268435456);
      localIntent.addFlags(262144);
      localIntent.addFlags(1073741824);
      localIntent.putExtra("title", str2);
      localIntent.putExtra("content", str1);
      localIntent.putExtra("time", TimeFormatterUtils.b(BaseApplication.getContext(), paramPCPayData.jdField_b_of_type_Long));
      paramBaseQQAppInterface.getApp().startActivity(localIntent);
    }
    boolean bool1 = ((IQQAppInterfaceTemp)QRoute.api(IQQAppInterfaceTemp.class)).QQAppInterface$isRingerSilent(paramBaseQQAppInterface);
    boolean bool2 = PhoneStatusTools.e(paramBaseQQAppInterface.getApp());
    boolean bool3 = ((IQQAppInterfaceTemp)QRoute.api(IQQAppInterfaceTemp.class)).QQAppInterface$isVideoChatting(paramBaseQQAppInterface);
    boolean bool4 = ((IQQAppInterfaceTemp)QRoute.api(IQQAppInterfaceTemp.class)).QQAppInterface$isPttRecordingOrPlaying(paramBaseQQAppInterface);
    boolean bool5 = NoDisturbUtil.a(paramBaseQQAppInterface.getApp().getApplicationContext(), paramBaseQQAppInterface);
    if (QLog.isColorLevel())
    {
      paramPCPayData = new StringBuilder();
      paramPCPayData.append("isRingerSilent=");
      paramPCPayData.append(bool1);
      paramPCPayData.append(",isCalling=");
      paramPCPayData.append(bool2);
      paramPCPayData.append(",isVideoChatting=");
      paramPCPayData.append(bool3);
      paramPCPayData.append(",isRecordingPtt=");
      paramPCPayData.append(bool4);
      paramPCPayData.append(",canDisturb=");
      paramPCPayData.append(bool5);
      QLog.d("Q.qwallet.push", 2, paramPCPayData.toString());
    }
    if ((bool5) && (!bool2) && (!bool1) && (!bool3) && (!bool4))
    {
      if (((IQQAppInterfaceTemp)QRoute.api(IQQAppInterfaceTemp.class)).getALLGeneralSettingRing(paramBaseQQAppInterface) == 0) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if (((IQQAppInterfaceTemp)QRoute.api(IQQAppInterfaceTemp.class)).getALLGeneralSettingVibrate(paramBaseQQAppInterface) == 0) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      if (QLog.isColorLevel())
      {
        paramPCPayData = new StringBuilder();
        paramPCPayData.append("canPlaySound=");
        paramPCPayData.append(bool1);
        paramPCPayData.append(",canVibrator=");
        paramPCPayData.append(bool2);
        QLog.d("Q.qwallet.push", 2, paramPCPayData.toString());
      }
      if (bool2)
      {
        paramBaseQQAppInterface = (Vibrator)paramBaseQQAppInterface.getApp().getSystemService("vibrator");
        if (paramBaseQQAppInterface != null) {
          paramBaseQQAppInterface.vibrate(jdField_a_of_type_ArrayOfLong, -1);
        }
      }
      if (bool1)
      {
        paramBaseQQAppInterface = ThemeUtil.getThemeVoiceRootPath();
        if (paramBaseQQAppInterface != null)
        {
          paramPCPayData = new StringBuilder();
          paramPCPayData.append(paramBaseQQAppInterface);
          paramPCPayData.append(File.separatorChar);
          paramPCPayData.append("message.mp3");
          paramBaseQQAppInterface = new File(paramPCPayData.toString());
          if (paramBaseQQAppInterface.exists())
          {
            AudioUtil.a(Uri.fromFile(paramBaseQQAppInterface), false, true);
            return;
          }
        }
        AudioUtil.a(R.raw.jdField_b_of_type_Int, false);
      }
    }
  }
  
  private static void b(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new Intent(paramString);
    paramBaseQQAppInterface.getApp().sendBroadcast(paramString);
  }
  
  /* Error */
  public static void b(BaseQQAppInterface paramBaseQQAppInterface, byte[] paramArrayOfByte, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +19 -> 20
    //   4: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 126
    //   12: iconst_2
    //   13: ldc_w 662
    //   16: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: return
    //   20: lload_2
    //   21: iload 4
    //   23: lload 5
    //   25: iload 7
    //   27: invokestatic 275	com/tencent/mobileqq/qwallet/impl/QWalletPushManager:a	(JIJI)Z
    //   30: ifeq +19 -> 49
    //   33: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +12 -> 48
    //   39: ldc 126
    //   41: iconst_2
    //   42: ldc_w 664
    //   45: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: return
    //   49: ldc_w 277
    //   52: invokestatic 283	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   55: checkcast 277	com/qwallet/temp/IQWalletPBTemp
    //   58: aload_1
    //   59: invokeinterface 668 2 0
    //   64: astore 13
    //   66: aload 13
    //   68: ifnull +752 -> 820
    //   71: aload 13
    //   73: getfield 672	com/tencent/mobileqq/data/QWalletSubmsgtype0x7e$MsgBody$OnlinePush:action	I
    //   76: istore 7
    //   78: aload 13
    //   80: getfield 675	com/tencent/mobileqq/data/QWalletSubmsgtype0x7e$MsgBody$OnlinePush:timestamp	I
    //   83: istore 8
    //   85: aload 13
    //   87: getfield 678	com/tencent/mobileqq/data/QWalletSubmsgtype0x7e$MsgBody$OnlinePush:extend	Ljava/lang/String;
    //   90: astore_1
    //   91: aload 13
    //   93: getfield 681	com/tencent/mobileqq/data/QWalletSubmsgtype0x7e$MsgBody$OnlinePush:serialno	Ljava/lang/String;
    //   96: astore 10
    //   98: aload 13
    //   100: getfield 684	com/tencent/mobileqq/data/QWalletSubmsgtype0x7e$MsgBody$OnlinePush:billno	Ljava/lang/String;
    //   103: astore 11
    //   105: aload 13
    //   107: getfield 687	com/tencent/mobileqq/data/QWalletSubmsgtype0x7e$MsgBody$OnlinePush:appinfo	Ljava/lang/String;
    //   110: astore 12
    //   112: aload 13
    //   114: getfield 690	com/tencent/mobileqq/data/QWalletSubmsgtype0x7e$MsgBody$OnlinePush:amount	I
    //   117: istore 9
    //   119: aload 13
    //   121: getfield 693	com/tencent/mobileqq/data/QWalletSubmsgtype0x7e$MsgBody$OnlinePush:jumpurl	Ljava/lang/String;
    //   124: astore 13
    //   126: new 141	org/json/JSONObject
    //   129: dup
    //   130: invokespecial 361	org/json/JSONObject:<init>	()V
    //   133: astore 14
    //   135: new 141	org/json/JSONObject
    //   138: dup
    //   139: invokespecial 361	org/json/JSONObject:<init>	()V
    //   142: astore 15
    //   144: new 141	org/json/JSONObject
    //   147: dup
    //   148: aload_1
    //   149: invokespecial 144	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   152: astore 16
    //   154: aload 15
    //   156: ldc 152
    //   158: iload 7
    //   160: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload 15
    //   166: ldc_w 694
    //   169: aload 16
    //   171: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   174: pop
    //   175: aload 14
    //   177: ldc_w 696
    //   180: aload_0
    //   181: invokevirtual 193	com/tencent/common/app/business/BaseQQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   184: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   187: pop
    //   188: aload 14
    //   190: ldc_w 363
    //   193: ldc_w 698
    //   196: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   199: pop
    //   200: aload 14
    //   202: ldc_w 376
    //   205: ldc_w 700
    //   208: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   211: pop
    //   212: aload 14
    //   214: ldc_w 390
    //   217: aload 15
    //   219: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   222: pop
    //   223: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +71 -> 297
    //   229: new 110	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   236: astore 16
    //   238: aload 16
    //   240: ldc_w 702
    //   243: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 16
    //   249: aload 14
    //   251: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: ldc 126
    //   257: iconst_2
    //   258: aload 16
    //   260: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: goto +31 -> 297
    //   269: astore 16
    //   271: invokestatic 705	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   274: ifeq +8 -> 282
    //   277: aload 16
    //   279: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   282: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +12 -> 297
    //   288: ldc 126
    //   290: iconst_2
    //   291: ldc_w 707
    //   294: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload_0
    //   298: invokevirtual 158	com/tencent/common/app/business/BaseQQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   301: astore 16
    //   303: getstatic 163	android/os/Build$VERSION:SDK_INT	I
    //   306: istore 4
    //   308: iload 4
    //   310: bipush 10
    //   312: if_icmple +9 -> 321
    //   315: iconst_4
    //   316: istore 4
    //   318: goto +6 -> 324
    //   321: iconst_0
    //   322: istore 4
    //   324: aload 16
    //   326: ldc 165
    //   328: iload 4
    //   330: invokevirtual 171	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   333: astore 16
    //   335: aload 16
    //   337: ifnull +484 -> 821
    //   340: aload_0
    //   341: invokevirtual 193	com/tencent/common/app/business/BaseQQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   344: astore_0
    //   345: new 110	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   352: astore 17
    //   354: aload 17
    //   356: ldc_w 709
    //   359: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 17
    //   365: aload_0
    //   366: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 16
    //   372: aload 17
    //   374: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: lconst_0
    //   378: invokeinterface 712 4 0
    //   383: lstore_2
    //   384: invokestatic 717	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   387: ldc2_w 718
    //   390: ldiv
    //   391: lstore 5
    //   393: lload 5
    //   395: lload_2
    //   396: lcmp
    //   397: ifge +54 -> 451
    //   400: aload 16
    //   402: invokeinterface 177 1 0
    //   407: astore 15
    //   409: new 110	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   416: astore 16
    //   418: aload 16
    //   420: ldc_w 709
    //   423: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 16
    //   429: aload_0
    //   430: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 15
    //   436: aload 16
    //   438: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: lconst_0
    //   442: invokeinterface 723 4 0
    //   447: pop
    //   448: goto +101 -> 549
    //   451: lload 5
    //   453: lload_2
    //   454: lsub
    //   455: ldc2_w 724
    //   458: lcmp
    //   459: ifge +90 -> 549
    //   462: new 141	org/json/JSONObject
    //   465: dup
    //   466: invokespecial 361	org/json/JSONObject:<init>	()V
    //   469: astore_0
    //   470: aload_0
    //   471: ldc_w 727
    //   474: iconst_0
    //   475: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   478: pop
    //   479: aload_0
    //   480: ldc_w 729
    //   483: ldc 221
    //   485: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   488: pop
    //   489: aload_0
    //   490: ldc_w 731
    //   493: iconst_4
    //   494: invokevirtual 374	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   497: pop
    //   498: aload_0
    //   499: ldc_w 733
    //   502: aload 15
    //   504: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   507: pop
    //   508: goto +16 -> 524
    //   511: astore 15
    //   513: invokestatic 705	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   516: ifeq +8 -> 524
    //   519: aload 15
    //   521: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   524: ldc_w 432
    //   527: invokestatic 283	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   530: checkcast 432	com/qwallet/temp/IQWalletTemp
    //   533: iconst_4
    //   534: ldc_w 735
    //   537: aload_0
    //   538: invokevirtual 391	org/json/JSONObject:toString	()Ljava/lang/String;
    //   541: invokeinterface 739 4 0
    //   546: goto +3 -> 549
    //   549: new 741	android/os/Bundle
    //   552: dup
    //   553: invokespecial 742	android/os/Bundle:<init>	()V
    //   556: astore_0
    //   557: aload_0
    //   558: ldc_w 471
    //   561: aload 14
    //   563: invokevirtual 391	org/json/JSONObject:toString	()Ljava/lang/String;
    //   566: invokevirtual 746	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   569: aload_0
    //   570: ldc_w 477
    //   573: ldc_w 479
    //   576: invokevirtual 746	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: new 458	android/content/Intent
    //   582: dup
    //   583: invokestatic 461	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   586: ldc_w 443
    //   589: invokespecial 464	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   592: astore 15
    //   594: aload 15
    //   596: ldc_w 555
    //   599: invokevirtual 469	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   602: pop
    //   603: aload 15
    //   605: aload_0
    //   606: invokevirtual 750	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   609: pop
    //   610: aload 15
    //   612: ldc_w 486
    //   615: iconst_5
    //   616: invokevirtual 489	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   619: pop
    //   620: invokestatic 461	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   623: aload 15
    //   625: invokevirtual 500	com/tencent/qphone/base/util/BaseApplication:startActivity	(Landroid/content/Intent;)V
    //   628: invokestatic 705	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   631: ifeq +189 -> 820
    //   634: new 110	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   641: astore_0
    //   642: aload_0
    //   643: ldc_w 752
    //   646: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload_0
    //   651: iload 7
    //   653: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload_0
    //   658: ldc_w 754
    //   661: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: pop
    //   665: aload_0
    //   666: iload 8
    //   668: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload_0
    //   673: ldc_w 756
    //   676: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload_0
    //   681: aload_1
    //   682: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload_0
    //   687: ldc_w 758
    //   690: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload_0
    //   695: aload 10
    //   697: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload_0
    //   702: ldc_w 760
    //   705: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload_0
    //   710: aload 11
    //   712: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload_0
    //   717: ldc_w 762
    //   720: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload_0
    //   725: aload 12
    //   727: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload_0
    //   732: ldc_w 764
    //   735: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload_0
    //   740: iload 9
    //   742: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload_0
    //   747: ldc_w 766
    //   750: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload_0
    //   755: aload 13
    //   757: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload_0
    //   762: ldc_w 768
    //   765: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: pop
    //   769: aload_0
    //   770: aload 14
    //   772: invokevirtual 391	org/json/JSONObject:toString	()Ljava/lang/String;
    //   775: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: aload_0
    //   780: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: astore_0
    //   784: ldc 126
    //   786: iconst_4
    //   787: aload_0
    //   788: invokestatic 771	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   791: return
    //   792: astore_0
    //   793: goto +8 -> 801
    //   796: astore_0
    //   797: goto +4 -> 801
    //   800: astore_0
    //   801: aload_0
    //   802: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   805: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   808: ifeq +12 -> 820
    //   811: ldc 126
    //   813: iconst_2
    //   814: ldc_w 707
    //   817: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   820: return
    //   821: goto -272 -> 549
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	824	0	paramBaseQQAppInterface	BaseQQAppInterface
    //   0	824	1	paramArrayOfByte	byte[]
    //   0	824	2	paramLong1	long
    //   0	824	4	paramInt1	int
    //   0	824	5	paramLong2	long
    //   0	824	7	paramInt2	int
    //   83	584	8	i	int
    //   117	624	9	j	int
    //   96	600	10	str1	String
    //   103	608	11	str2	String
    //   110	616	12	str3	String
    //   64	692	13	localObject1	Object
    //   133	638	14	localJSONObject	JSONObject
    //   142	361	15	localObject2	Object
    //   511	9	15	localException1	Exception
    //   592	32	15	localIntent	Intent
    //   152	107	16	localObject3	Object
    //   269	9	16	localException2	Exception
    //   301	136	16	localObject4	Object
    //   352	21	17	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   144	266	269	java/lang/Exception
    //   470	508	511	java/lang/Exception
    //   784	791	792	java/lang/Exception
    //   324	335	796	java/lang/Exception
    //   340	393	796	java/lang/Exception
    //   400	448	796	java/lang/Exception
    //   462	470	796	java/lang/Exception
    //   513	524	796	java/lang/Exception
    //   524	546	796	java/lang/Exception
    //   549	784	796	java/lang/Exception
    //   49	66	800	java/lang/Exception
    //   71	144	800	java/lang/Exception
    //   271	282	800	java/lang/Exception
    //   282	297	800	java/lang/Exception
    //   297	308	800	java/lang/Exception
  }
  
  private static boolean b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    Object localObject1 = MobileQQ.getContext();
    if (localObject1 == null) {
      return false;
    }
    boolean bool = BaseGesturePWDUtil.getGestureLocking((Context)localObject1);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isQQForeground isQQLock=");
      ((StringBuilder)localObject2).append(bool);
      QLog.d("Q.qwallet.push", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramBaseQQAppInterface != null)
    {
      if (bool) {
        return false;
      }
      if (!paramBaseQQAppInterface.isBackgroundPause) {
        return true;
      }
      try
      {
        localObject2 = (ActivityManager)((Context)localObject1).getApplicationContext().getSystemService("activity");
        if (localObject2 == null) {
          return false;
        }
        paramBaseQQAppInterface = ((Context)localObject1).getApplicationContext().getPackageName();
        if (TextUtils.isEmpty(paramBaseQQAppInterface)) {
          return false;
        }
        localObject1 = ((ActivityManager)localObject2).getRunningAppProcesses();
        if (localObject1 == null) {
          return false;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
          if ((((ActivityManager.RunningAppProcessInfo)localObject2).importance == 100) && (((ActivityManager.RunningAppProcessInfo)localObject2).processName != null))
          {
            Object localObject3 = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramBaseQQAppInterface);
            localStringBuilder.append(":video");
            if (((String)localObject3).equals(localStringBuilder.toString())) {
              return false;
            }
            if (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals(paramBaseQQAppInterface))
            {
              localObject2 = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(paramBaseQQAppInterface);
              ((StringBuilder)localObject3).append(":");
              bool = ((String)localObject2).startsWith(((StringBuilder)localObject3).toString());
              if (!bool) {
                break;
              }
            }
            else
            {
              return true;
            }
          }
        }
        return false;
      }
      catch (Exception paramBaseQQAppInterface)
      {
        paramBaseQQAppInterface.printStackTrace();
      }
    }
    return false;
  }
  
  private static void c(BaseQQAppInterface paramBaseQQAppInterface, IQWalletPayApi.PCPayData paramPCPayData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "startBackgroundPay");
    }
    if ((paramBaseQQAppInterface != null) && (paramBaseQQAppInterface.getApp() != null))
    {
      if (paramPCPayData == null) {
        return;
      }
      String str = String.format(BaseApplication.getContext().getString(R.string.dn), new Object[] { Integer.valueOf(a()) });
      Object localObject = paramPCPayData.jdField_b_of_type_JavaLangString;
      paramPCPayData = (IQWalletPayApi.PCPayData)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramPCPayData = BaseApplication.getContext().getString(R.string.dm);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("callbackSn", "0");
      ((Bundle)localObject).putBoolean("payparmas_from_pcpush", true);
      ((Bundle)localObject).putInt("pay_requestcode", 12);
      ((Bundle)localObject).putInt("payparmas_paytype", 2);
      ((Bundle)localObject).putLong("vacreport_key_seq", jdField_b_of_type_Long);
      Intent localIntent = new Intent(paramBaseQQAppInterface.getApp(), PayBridgeActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtras((Bundle)localObject);
      localIntent.putExtra("param_notifyid", 238);
      paramBaseQQAppInterface = PendingIntent.getActivity(paramBaseQQAppInterface.getApp(), 12, localIntent, 1073741824);
      try
      {
        paramBaseQQAppInterface = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_SHOW_BADGE").setSmallIcon(R.drawable.e).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle(str).setContentText(paramPCPayData).setContentIntent(paramBaseQQAppInterface).build();
        paramPCPayData = QQNotificationManager.getInstance();
        if (paramPCPayData != null)
        {
          paramPCPayData.cancel("Q.qwallet.push", 238);
          paramPCPayData.notify("Q.qwallet.push", 238, paramBaseQQAppInterface);
          return;
        }
      }
      catch (Throwable paramBaseQQAppInterface)
      {
        QLog.e("QWalletPushManager", 1, paramBaseQQAppInterface, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletPushManager
 * JD-Core Version:    0.7.0.1
 */