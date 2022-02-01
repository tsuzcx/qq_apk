package com.tencent.mobileqq.vas.hippy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class VasThemeHippyHelper
{
  Activity jdField_a_of_type_AndroidAppActivity;
  public Context a;
  private ThemeDiyModule jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public VasThemeHippyHelper(Context paramContext, AppInterface paramAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule = new ThemeDiyModule(paramContext, paramAppInterface);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(Promise paramPromise, ThemeUtil.ThemeInfo paramThemeInfo, String paramString, Bundle arg4)
  {
    try
    {
      if ("setSVTheme".equals(paramString))
      {
        String str = ???.getString("themeId");
        int i = ???.getInt("themeStatus", -1);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ???.append("IPC_THEME_SET_SERVER respone themeId:");
          ???.append(str);
          ???.append(", ret:");
          ???.append(i);
          QLog.d("VasThemeHippyHelper", 2, ???.toString());
        }
        if (i != 0)
        {
          paramThemeInfo = new JSONObject();
          paramThemeInfo.put("themeId", str);
          paramPromise.reject(VasHippyUtils.a(5, "setup theme setSV error.", paramThemeInfo));
          return;
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          VasThemeHippyHelper.ThemeSwitchListener localThemeSwitchListener = new VasThemeHippyHelper.ThemeSwitchListener(this, str, true, paramThemeInfo, paramPromise);
          if ((paramPromise != null) && (!TextUtils.isEmpty(str)) && (paramThemeInfo != null) && (str.equals(paramThemeInfo.themeId)) && (!DarkModeManager.a(this.jdField_a_of_type_AndroidAppActivity, str, new VasThemeHippyHelper.2(this, str, localThemeSwitchListener)))) {
            if (!SimpleUIUtil.a())
            {
              this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule.a();
              ThemeSwitcher.a(str, "200", localThemeSwitchListener);
            }
            else
            {
              if (!ThemeUtil.isFixTheme(str)) {
                ThemeSwitchUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, str, "20000000");
              }
              localThemeSwitchListener.postSwitch(0);
            }
          }
          return;
        }
      }
      return;
    }
    catch (Throwable paramThemeInfo)
    {
      ??? = new StringBuilder();
      ???.append("onResponse Throwable cmd:");
      ???.append(paramString);
      ???.append(", msg：");
      ???.append(QLog.getStackTraceString(paramThemeInfo));
      QLog.e("VasThemeHippyHelper", 1, ???.toString());
      paramPromise.reject(VasHippyUtils.a(-1, paramThemeInfo.toString(), null));
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Promise paramPromise)
  {
    ThemeUtil.ThemeInfo localThemeInfo = ThemeUtil.getThemeInfo(this.jdField_a_of_type_AndroidContentContext, paramString1);
    Object localObject = localThemeInfo;
    if (localThemeInfo == null)
    {
      localObject = new ThemeUtil.ThemeInfo();
      ((ThemeUtil.ThemeInfo)localObject).themeId = paramString1;
      ((ThemeUtil.ThemeInfo)localObject).version = paramString2;
      if ("1000".equals(paramString1)) {
        ((ThemeUtil.ThemeInfo)localObject).status = "5";
      }
      ThemeUtil.setThemeInfo(this.jdField_a_of_type_AndroidContentContext, (ThemeUtil.ThemeInfo)localObject);
    }
    if ("1103".equals(paramString1))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule.a();
      ThemeSwitcher.a(paramString1, "200", new VasThemeHippyHelper.ThemeSwitchListener(this, paramString1, true, (ThemeUtil.ThemeInfo)localObject, paramPromise));
      return;
    }
    paramPromise = new VasThemeHippyHelper.VasThemeStyleCallBack(this, paramString1, true, "", (ThemeUtil.ThemeInfo)localObject, paramPromise);
    localObject = new Bundle();
    ((Bundle)localObject).putString("themeId", paramString1);
    ((Bundle)localObject).putString("seriesID", paramString3);
    localObject = DataFactory.a("setSVTheme", "0", 0, (Bundle)localObject);
    ((ThemeHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER)).a(paramString1, paramString2, paramString3, (Bundle)localObject, paramPromise);
  }
  
  private static void b(Bundle paramBundle, String paramString, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int k = NetworkUtil.getSystemNetwork(localQQAppInterface.getApplication().getApplicationContext());
    String str1 = paramBundle.getString("actionName");
    int i;
    Object localObject1;
    if (!TextUtils.isEmpty(str1))
    {
      long l = paramBundle.getLong("downloadTime");
      int j = ((ISVIPHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(i);
      ReportController.b(localQQAppInterface, "CliOper", "", "", "theme_mall", str1, 0, paramInt, paramString, ((StringBuilder)localObject1).toString(), String.valueOf(k), String.valueOf(l));
    }
    str1 = paramBundle.getString("statisticKey");
    if (!TextUtils.isEmpty(str1)) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_themeId", paramString);
        ((HashMap)localObject1).put("param_netType", String.valueOf(k));
        ((HashMap)localObject1).put("param_FailCode", paramBundle.getString("param_FailCode"));
        localObject2 = StatisticCollector.getInstance(localQQAppInterface.getApplication().getApplicationContext());
        String str3 = localQQAppInterface.getAccount();
        if (paramInt != 0) {
          break label411;
        }
        bool = true;
        ((StatisticCollector)localObject2).collectPerformance(str3, str1, bool, 1L, 0L, (HashMap)localObject1, "", false);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("StatisticCollector Error:");
          ((StringBuilder)localObject1).append(localException.getMessage());
          QLog.e("StatisticCollector", 2, ((StringBuilder)localObject1).toString());
        }
      }
      String str2 = paramBundle.getString("from");
      if (!TextUtils.isEmpty(str2))
      {
        paramInt = paramBundle.getInt("step");
        i = paramBundle.getInt("code");
        localObject1 = paramBundle.getString("version");
        localObject2 = paramBundle.getString("path");
        paramBundle = paramBundle.getString("r5");
        if (TextUtils.isEmpty(paramBundle)) {
          paramBundle = "";
        }
        ThemeReporter.a(localQQAppInterface, "theme_detail", str2, paramInt, k, i, paramString, (String)localObject1, (String)localObject2, paramBundle);
      }
      return;
      label411:
      boolean bool = false;
    }
  }
  
  public String a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, JSONArray paramJSONArray, long paramLong, Promise arg10)
  {
    if ((!TextUtils.isEmpty(paramString2)) && ((TextUtils.isEmpty(paramString4)) || ((paramJSONArray != null) && (paramJSONArray.length() >= 1)))) {
      break label127;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ThemeJsHandler setup setWeekLoopThemeArray err,seriesID=");
    ((StringBuilder)localObject1).append(paramString4);
    ((StringBuilder)localObject1).append(",themeArray=");
    ((StringBuilder)localObject1).append(paramJSONArray);
    QLog.e("VasThemeHippyHelper", 1, ((StringBuilder)localObject1).toString());
    a(null, 0, paramString2, 0L, null, null, paramString1, 155, ThemeReporter.a, -8, paramString3, "");
    ???.reject(VasHippyUtils.a(1, "seriesID || themeArray data error", null));
    label127:
    paramString1 = paramString2;
    localObject1 = ThemeUtil.getCurrentThemeId();
    if (QLog.isColorLevel())
    {
      paramJSONArray = new StringBuilder();
      paramJSONArray.append("ThemeJsHandler setup,themeId=");
      paramJSONArray.append(paramString1);
      paramJSONArray.append(",version=");
      paramJSONArray.append(paramString3);
      paramJSONArray.append(",isSound=");
      paramJSONArray.append(paramInt);
      paramJSONArray.append(" isDiyTheme:");
      paramJSONArray.append(paramBoolean);
      paramJSONArray.append(" currentThemeId:");
      paramJSONArray.append((String)localObject1);
      QLog.i("VasThemeHippyHelper", 2, paramJSONArray.toString());
    }
    paramJSONArray = paramString3;
    if ((paramString1.equals(localObject1)) && (!paramBoolean))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ThemeJsHandler setup the same theme,themeId=");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(",version=");
        ((StringBuilder)localObject1).append(paramJSONArray);
        QLog.i("VasThemeHippyHelper", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = this;
      Object localObject2 = ((VasThemeHippyHelper)localObject1).jdField_a_of_type_JavaUtilHashMap;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramJSONArray);
      if (((HashMap)localObject2).containsKey(Integer.valueOf(localStringBuilder.toString().hashCode())))
      {
        localObject1 = ((VasThemeHippyHelper)localObject1).jdField_a_of_type_JavaUtilHashMap;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(paramJSONArray);
        paramString1 = (String)((HashMap)localObject1).get(Integer.valueOf(((StringBuilder)localObject2).toString().hashCode()));
      }
      else
      {
        paramString1 = ThemeReporter.b;
      }
      a(null, 1, paramString2, 0L, null, null, "200", 155, paramString1, 23, paramString3, "0");
      paramJSONArray = VasHippyUtils.a(0, "set the same theme", null);
      paramString1 = ???;
      paramString1.resolve(paramJSONArray);
    }
    else
    {
      paramString1 = ???;
    }
    paramJSONArray = this;
    synchronized (paramJSONArray.jdField_a_of_type_JavaLangObject)
    {
      paramJSONArray.a(paramString2, paramString3, paramString4, paramString1);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("setup server :id:");
        paramString1.append(paramString2);
        QLog.i("VasThemeHippyHelper", 2, paramString1.toString());
      }
      return "";
    }
  }
  
  public void a(Bundle paramBundle, Promise paramPromise, ThemeUtil.ThemeInfo paramThemeInfo)
  {
    if (paramBundle != null)
    {
      boolean bool = false;
      paramBundle.getInt("respkey", 0);
      String str = paramBundle.getString("cmd");
      paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if (paramBundle == null) {
        return;
      }
      int i = paramBundle.getInt("failcode", 1000);
      if ((TextUtils.isEmpty(str)) || (QLog.isColorLevel()) || (1001 == i))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("response:");
        localStringBuilder.append(str);
        localStringBuilder.append(", backCode=");
        localStringBuilder.append(i);
        localStringBuilder.append(", isTimeOut=");
        if (1001 == i) {
          bool = true;
        }
        localStringBuilder.append(bool);
        QLog.d("VasThemeHippyHelper", 2, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty(str)) {
        return;
      }
      a(paramPromise, paramThemeInfo, str, paramBundle);
    }
  }
  
  void a(String paramString1, int paramInt1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, String paramString8)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new VasThemeHippyHelper.1(this, paramString2, paramInt1, paramString1, paramLong, paramString3, paramString4, paramString5, paramInt2, paramInt3, paramString7, paramString8, paramString6), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasThemeHippyHelper
 * JD-Core Version:    0.7.0.1
 */