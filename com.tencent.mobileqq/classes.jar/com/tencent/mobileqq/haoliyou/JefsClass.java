package com.tencent.mobileqq.haoliyou;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bigbrother.TeleScreen;
import com.tencent.mobileqq.bigbrother.TeleScreenConfig.Config;
import com.tencent.mobileqq.bigbrother.WeakOuterRefRunnable;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class JefsClass
  extends IATHandler
{
  @Nullable
  private static IJefsClassInjectInterface jdField_a_of_type_ComTencentMobileqqHaoliyouIJefsClassInjectInterface;
  private static JefsClass jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass = new JefsClass();
  private static final Set<String> jdField_a_of_type_JavaUtilSet = new ArraySet();
  private static final Set<String> b;
  private static final Set<String> c;
  private int jdField_a_of_type_Int;
  private final SparseArrayCompat<Runnable> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private JefsClass.TeleScreenReceiver jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$TeleScreenReceiver;
  private ThreadLocal<Boolean> jdField_a_of_type_JavaLangThreadLocal = new JefsClass.1(this);
  
  static
  {
    try
    {
      QLog.d("TeleScreen|JefsClass", 1, "JefsClassInjectUtil newInstance");
      if (JefsClassInjectUtil.a.size() > 0) {
        jdField_a_of_type_ComTencentMobileqqHaoliyouIJefsClassInjectInterface = (IJefsClassInjectInterface)((Class)JefsClassInjectUtil.a.get(0)).newInstance();
      }
    }
    catch (Exception localException)
    {
      QLog.e("TeleScreen|JefsClass", 1, "JefsClassInjectUtil static statement: ", localException);
    }
    jdField_a_of_type_JavaUtilSet.add("android.settings.ACCESSIBILITY_SETTINGS");
    if (Build.VERSION.SDK_INT >= 26) {
      jdField_a_of_type_JavaUtilSet.add("android.settings.APP_NOTIFICATION_SETTINGS");
    }
    jdField_a_of_type_JavaUtilSet.add("android.settings.APPLICATION_DETAILS_SETTINGS");
    jdField_a_of_type_JavaUtilSet.add("android.settings.BLUETOOTH_SETTINGS");
    jdField_a_of_type_JavaUtilSet.add("android.settings.DATA_ROAMING_SETTINGS");
    jdField_a_of_type_JavaUtilSet.add("android.settings.DATE_SETTINGS");
    jdField_a_of_type_JavaUtilSet.add("android.settings.INTERNAL_STORAGE_SETTINGS");
    jdField_a_of_type_JavaUtilSet.add("android.settings.MEMORY_CARD_SETTINGS");
    jdField_a_of_type_JavaUtilSet.add("android.settings.LOCALE_SETTINGS");
    jdField_a_of_type_JavaUtilSet.add("android.settings.LOCATION_SOURCE_SETTINGS");
    if (Build.VERSION.SDK_INT >= 24) {
      jdField_a_of_type_JavaUtilSet.add("android.settings.MANAGE_DEFAULT_APPS_SETTINGS");
    }
    if (Build.VERSION.SDK_INT >= 23) {
      jdField_a_of_type_JavaUtilSet.add("android.settings.action.MANAGE_OVERLAY_PERMISSION");
    }
    if (Build.VERSION.SDK_INT >= 19) {
      jdField_a_of_type_JavaUtilSet.add("android.settings.NFC_PAYMENT_SETTINGS");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      jdField_a_of_type_JavaUtilSet.add("android.settings.NFC_SETTINGS");
    }
    jdField_a_of_type_JavaUtilSet.add("android.settings.NFCSHARING_SETTINGS");
    jdField_a_of_type_JavaUtilSet.add("android.settings.SETTINGS");
    jdField_a_of_type_JavaUtilSet.add("android.settings.WIFI_SETTINGS");
    jdField_a_of_type_JavaUtilSet.add("android.settings.WIRELESS_SETTINGS");
    if (Build.VERSION.SDK_INT >= 23) {
      jdField_a_of_type_JavaUtilSet.add("android.settings.action.MANAGE_WRITE_SETTINGS");
    }
    jdField_a_of_type_JavaUtilSet.add("android.media.action.IMAGE_CAPTURE");
    jdField_a_of_type_JavaUtilSet.add("android.intent.action.PICK");
    jdField_a_of_type_JavaUtilSet.add("android.intent.action.CALL");
    jdField_a_of_type_JavaUtilSet.add("android.intent.action.DIAL");
    jdField_a_of_type_JavaUtilSet.add("android.intent.action.CALL_BUTTON");
    jdField_a_of_type_JavaUtilSet.add("android.intent.action.SENDTO");
    jdField_a_of_type_JavaUtilSet.add("android.intent.action.GET_CONTENT");
    jdField_a_of_type_JavaUtilSet.add("android.intent.action.RINGTONE_PICKER");
    if (Build.VERSION.SDK_INT >= 19) {
      jdField_a_of_type_JavaUtilSet.add("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
    }
    jdField_a_of_type_JavaUtilSet.add("android.content.pm.CONFIRM_ACCESS_APPCATONS");
    jdField_a_of_type_JavaUtilSet.add("com.meizu.safe.security.SHOW_APPSEC");
    jdField_a_of_type_JavaUtilSet.add("miui.intent.action.APP_PERM_EDITOR");
    jdField_a_of_type_JavaUtilSet.add("android.intent.action.INSERT_OR_EDIT");
    jdField_a_of_type_JavaUtilSet.add("android.intent.action.INSERT");
    if (Build.VERSION.SDK_INT >= 16) {
      jdField_a_of_type_JavaUtilSet.add("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
    }
    b = new ArraySet();
    b.add(MobileQQ.getContext().getPackageName());
    b.add("com.android.settings");
    b.add("com.miui.securitycenter");
    b.add("com.miui.system");
    b.add("com.zui.safecenter");
    b.add("com.android.mms");
    b.add("com.sonymobile.cta");
    b.add("com.huawei.systemmanager");
    b.add("com.sec.android.app.capabilitymanager");
    b.add("com.coloros.safecenter");
    c = new ArraySet();
    c.add("com.tencent.mm");
    c.add("com.tencent.mtt");
    c.add("com.tencent.qzone.capaoptools");
  }
  
  private int a(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      do
      {
        this.jdField_a_of_type_Int += 1;
      } while (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_Int) != null);
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(i, paramRunnable);
      return i;
    }
    for (;;)
    {
      throw paramRunnable;
    }
  }
  
  private ArrayMap<String, String> a(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (paramString != null)
    {
      paramString = paramString.split(",");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length == 2) {
          localArrayMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
    return localArrayMap;
  }
  
  private static String a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSourceId() called with: context = [");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("], intent = [");
      ((StringBuilder)localObject).append(paramIntent);
      ((StringBuilder)localObject).append("]");
      QLog.d("TeleScreen|JefsClass", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    if (paramIntent.hasExtra("big_brother_source_key"))
    {
      paramIntent = paramIntent.getStringExtra("big_brother_source_key");
      localObject = paramIntent;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSourceId() src = [");
        ((StringBuilder)localObject).append(paramIntent);
        ((StringBuilder)localObject).append("], from intent");
        QLog.d("TeleScreen|JefsClass", 2, ((StringBuilder)localObject).toString());
        localObject = paramIntent;
      }
    }
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      paramIntent = (Intent)localObject;
      if ((paramContext instanceof Activity))
      {
        paramContext = ((Activity)paramContext).getIntent();
        paramIntent = (Intent)localObject;
        if (paramContext != null)
        {
          paramContext = paramContext.getStringExtra("big_brother_source_key");
          paramIntent = paramContext;
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("getSourceId() src = [");
            paramIntent.append(paramContext);
            paramIntent.append("], from Activity");
            QLog.d("TeleScreen|JefsClass", 2, paramIntent.toString());
            paramIntent = paramContext;
          }
        }
      }
    }
    return paramIntent;
  }
  
  private static String a(Context paramContext, Intent paramIntent, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRefId() called with: context = [");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("], intent = [");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("], source = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d("TeleScreen|JefsClass", 2, localStringBuilder.toString());
    }
    if ("biz_src_ads".equals(paramString))
    {
      if ((paramIntent != null) && (paramIntent.getStringExtra("big_brother_ref_source_key") != null))
      {
        paramContext = paramIntent.getStringExtra("big_brother_ref_source_key");
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("getRefId() refId = [");
          paramIntent.append(paramContext);
          paramIntent.append("], from intent");
          QLog.d("TeleScreen|JefsClass", 2, paramIntent.toString());
        }
        return paramContext;
      }
      if ((paramContext instanceof Activity))
      {
        paramContext = ((Activity)paramContext).getIntent();
        if (paramContext != null)
        {
          paramIntent = paramContext.getStringExtra("big_brother_source_key");
          paramString = paramContext.getStringExtra("big_brother_ref_source_key");
          if (paramString != null) {
            paramContext = paramString;
          } else {
            paramContext = paramIntent;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getRefId() Activity Source = [");
            localStringBuilder.append(paramIntent);
            localStringBuilder.append("], refId = [");
            localStringBuilder.append(paramString);
            localStringBuilder.append("]");
            QLog.d("TeleScreen|JefsClass", 2, localStringBuilder.toString());
          }
          return paramContext;
        }
      }
      else
      {
        paramIntent = new StringBuilder();
        paramIntent.append("getRefId: context is not Activity ");
        paramIntent.append(paramContext);
        QLog.i("TeleScreen|JefsClass", 1, paramIntent.toString());
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt1);
      if (localRunnable == null) {
        QLog.w("TeleScreen|JefsClass", 1, "no todo");
      }
      b(paramInt1, 0);
      a(localRunnable);
      TeleScreen.a().a(paramInt2, 2);
      return;
    }
  }
  
  private void a(Context paramContext, Intent paramIntent, JefsClass.CancelableRunnable paramCancelableRunnable, JefsClass.Interceptor paramInterceptor)
  {
    QLog.i("TeleScreen|JefsClass", 1, "intercept: ");
    if (((Boolean)this.jdField_a_of_type_JavaLangThreadLocal.get()).booleanValue())
    {
      a(paramCancelableRunnable);
      return;
    }
    String str2 = paramIntent.getPackage();
    String str3 = a(paramContext, paramIntent);
    String str1 = a(paramContext, paramIntent, str3);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("src ");
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append(", ref ");
      ((StringBuilder)localObject).append(str1);
      QLog.d("TeleScreen|JefsClass", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = jdField_a_of_type_ComTencentMobileqqHaoliyouIJefsClassInjectInterface;
    if ((localObject != null) && (((IJefsClassInjectInterface)localObject).a()))
    {
      if (b.contains(str2))
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("skip package: ");
          paramContext.append(str2);
          paramContext.append(", sourceId: ");
          paramContext.append(str3);
          paramContext.append(", refId = ");
          paramContext.append(str1);
          QLog.d("TeleScreen|JefsClass", 2, paramContext.toString());
        }
        a(paramCancelableRunnable);
        return;
      }
      str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = paramIntent.getComponent();
        str1 = str2;
        if (localObject != null)
        {
          str2 = ((ComponentName)localObject).getPackageName();
          str1 = str2;
          if (b.contains(str2))
          {
            if (QLog.isColorLevel())
            {
              paramContext = new StringBuilder();
              paramContext.append("skip package: ");
              paramContext.append(str2);
              paramContext.append(", sourceId: ");
              paramContext.append(str3);
              QLog.d("TeleScreen|JefsClass", 2, paramContext.toString());
            }
            a(paramCancelableRunnable);
            return;
          }
        }
      }
      str2 = paramIntent.getAction();
      if (jdField_a_of_type_JavaUtilSet.contains(str2))
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("skip action: ");
          paramContext.append(str2);
          QLog.d("TeleScreen|JefsClass", 2, paramContext.toString());
        }
        a(paramCancelableRunnable);
        return;
      }
      localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localObject != null) && (!((AppRuntime)localObject).isLogin()))
      {
        QLog.i("TeleScreen|JefsClass", 1, "haven't login ");
        a(paramCancelableRunnable);
        return;
      }
      if (localObject != null)
      {
        IJefsClassInjectInterface localIJefsClassInjectInterface = jdField_a_of_type_ComTencentMobileqqHaoliyouIJefsClassInjectInterface;
        if (localIJefsClassInjectInterface != null) {
          localIJefsClassInjectInterface.a(((AppRuntime)localObject).getAccount(), paramIntent);
        }
      }
      localObject = paramIntent.getData();
      if ((localObject != null) && (((Uri)localObject).getScheme() != null) && (((((Uri)localObject).getScheme().startsWith("tencent")) && ("tauth.qq.com".equals(((Uri)localObject).getAuthority()))) || ((((Uri)localObject).getScheme().startsWith("qwallet")) && ("open_pay".equals(((Uri)localObject).getAuthority()))) || ((((Uri)localObject).getScheme().equals("tmast")) && ("sdk_wake".equals(((Uri)localObject).getAuthority()))) || ((((Uri)localObject).getScheme().equals("tmast")) && ("spaceclean".equals(((Uri)localObject).getAuthority()))) || ((((Uri)localObject).getScheme().equals("https")) && ("ssl.ptlogin2.qq.com".equals(((Uri)localObject).getAuthority())) && ("/jump".equals(((Uri)localObject).getPath())))))
      {
        a(paramCancelableRunnable);
        return;
      }
      localObject = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        if (((List)localObject).size() == 1)
        {
          paramContext = ((ResolveInfo)((List)localObject).get(0)).activityInfo;
          if (paramContext != null)
          {
            if (b.contains(paramContext.packageName))
            {
              if (QLog.isColorLevel())
              {
                paramIntent = new StringBuilder();
                paramIntent.append("skip package: ");
                paramIntent.append(paramContext.packageName);
                paramIntent.append(", sourceId: ");
                paramIntent.append(str3);
                QLog.d("TeleScreen|JefsClass", 2, paramIntent.toString());
              }
              a(paramCancelableRunnable);
              return;
            }
            if (("com.tencent.android.qqdownloader".equals(paramContext.packageName)) && ("com.live.push.PushActivity".equals(paramContext.name)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("TeleScreen|JefsClass", 2, "wake up yyb");
              }
              a(paramCancelableRunnable);
              return;
            }
          }
        }
        paramInterceptor.a(str1, paramIntent.getDataString(), str2, (List)localObject, paramCancelableRunnable);
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("no matching app: ");
      paramContext.append(paramIntent.getDataString());
      QLog.i("TeleScreen|JefsClass", 1, paramContext.toString());
      a(paramCancelableRunnable);
      return;
    }
    a(paramCancelableRunnable);
  }
  
  private void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, List<ResolveInfo> paramList, JefsClass.CancelableRunnable paramCancelableRunnable, int paramInt)
  {
    QLog.i("TeleScreen|JefsClass", 1, "checkAndDoAsyn: ");
    String str1 = a(paramContext, paramIntent);
    String str2 = a(paramContext, paramIntent, str1);
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, String.format("src: %s, ref: %s, url: %s, packageName: %s, scheme: %s, action: %s", new Object[] { str1, str2, paramString1, paramString2, paramString3, paramString4 }));
    }
    paramCancelableRunnable.a(str1);
    try
    {
      Object localObject1 = (TeleScreenConfig.Config)QConfigManager.a().a(416);
      int i;
      if ((((TeleScreenConfig.Config)localObject1).a) && (!((TeleScreenConfig.Config)localObject1).a(str1, paramString3)) && (!a(paramList)) && (!a(str1, paramString2))) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject2 = null;
      if (i != 0) {
        localObject1 = paramCancelableRunnable;
      } else {
        localObject1 = null;
      }
      if (i == 0)
      {
        QLog.i("TeleScreen|JefsClass", 1, "report async");
        a(paramCancelableRunnable);
        paramInt = 0;
      }
      paramIntent.putExtra("keyIsDownLoad", true);
      try
      {
        paramCancelableRunnable = new WeakReference(paramContext);
        boolean bool = "android.intent.action.VIEW".equals(paramString4);
        if ((bool) && (("application/vnd.android.package-archive".equalsIgnoreCase(paramIntent.getType())) || (paramIntent.hasExtra("yyb_install_url"))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TeleScreen|JefsClass", 2, "install");
          }
          ThreadManagerV2.excute(new JefsClass.7(this, paramIntent, (JefsClass.CancelableRunnable)localObject1, paramCancelableRunnable, str1, str2), 64, null, true);
          return;
        }
        if ((paramString3 != null) && ((paramString3.startsWith("http://")) || (paramString3.startsWith("https://")))) {
          if ("application/vnd.android.package-archive".equals(paramIntent.getStringExtra("mimetype")))
          {
            a(paramContext, str1, str2, null, paramString3, (Runnable)localObject1);
            return;
          }
        }
        try
        {
          a(paramContext, str1, str2, paramString2, paramString1, paramString3, paramString4, paramList, (JefsClass.CancelableRunnable)localObject1, paramInt);
          return;
        }
        catch (Throwable paramContext) {}
        if ((paramString3 != null) && (paramString3.startsWith("mttbrowser://")))
        {
          paramIntent = a(paramString3.substring(13));
          if (URLEncoder.encode("application/vnd.android.package-archive").equals(paramIntent.get("downloadmimetype")))
          {
            a(paramContext, str1, str2, null, URLDecoder.decode((String)paramIntent.get("downloadurl")), (Runnable)localObject1);
            return;
          }
          a(paramContext, str1, str2, paramString2, paramString1, paramString3, paramString4, paramList, (JefsClass.CancelableRunnable)localObject1, paramInt);
          return;
        }
        if ((paramString3 != null) && (paramString3.startsWith("tencentfile://")))
        {
          i = paramString3.indexOf(",url=");
          if (i >= 0)
          {
            paramIntent = a(paramString3.substring(i));
            if (URLEncoder.encode("application/vnd.android.package-archive").equals(paramIntent.get("downloadmimetype")))
            {
              a(paramContext, str1, str2, null, URLDecoder.decode((String)paramIntent.get("downloadurl")), (Runnable)localObject1);
              return;
            }
            a(paramContext, str1, str2, paramString2, paramString1, paramString3, paramString4, paramList, (JefsClass.CancelableRunnable)localObject1, paramInt);
            return;
          }
          a(paramContext, str1, str2, paramString2, paramString1, paramString3, paramString4, paramList, (JefsClass.CancelableRunnable)localObject1, paramInt);
          return;
        }
        paramCancelableRunnable = (JefsClass.CancelableRunnable)localObject1;
        if ((paramString3 != null) && (paramString3.startsWith("tmast://")))
        {
          paramString1 = paramIntent.getStringExtra("packageName");
          paramIntent = localObject2;
          if (paramString1 == null) {
            paramIntent = URLDecoder.decode(Uri.parse(paramString3).getQueryParameter("downl_url"));
          }
          a(paramContext, str1, str2, paramString1, paramIntent, paramCancelableRunnable);
          return;
        }
        a(paramContext, str1, str2, paramString2, paramString1, paramString3, paramString4, paramList, paramCancelableRunnable, paramInt);
        return;
      }
      catch (Throwable paramContext) {}
      QLog.e("TeleScreen|JefsClass", 1, paramContext, new Object[0]);
      a((Runnable)localObject1);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("TeleScreen|JefsClass", 1, paramContext, new Object[0]);
      a(paramCancelableRunnable);
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Runnable paramRunnable)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      localObject2 = paramContext.getClass().getName();
      if (paramString3 != null) {
        localObject1 = paramString3;
      } else if (paramString4 == null) {
        localObject1 = "";
      } else {
        localObject1 = paramString4;
      }
      ReportController.b(null, "dc00898", "", "", "0X8009C58", "0X8009C58", 0, 0, "", "", (String)localObject2, (String)localObject1);
    }
    Object localObject1 = new WeakReference(paramContext);
    Object localObject2 = jdField_a_of_type_ComTencentMobileqqHaoliyouIJefsClassInjectInterface;
    if (localObject2 == null) {
      return;
    }
    ((IJefsClassInjectInterface)localObject2).a(paramContext, paramString1, paramString3, paramString4, paramString2, new JefsClass.4(this, paramRunnable, (WeakReference)localObject1, paramString1));
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<ResolveInfo> paramList, JefsClass.CancelableRunnable paramCancelableRunnable, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      localObject2 = paramContext.getClass().getName();
      if (paramString3 != null) {
        localObject1 = paramString3;
      } else if (paramString5 != null) {
        localObject1 = paramString5;
      } else if (paramString6 != null) {
        localObject1 = paramString6;
      } else if (paramString4 == null) {
        localObject1 = "";
      } else {
        localObject1 = paramString4;
      }
      ReportController.b(null, "dc00898", "", "", "0X8009C58", "0X8009C58", 0, 0, "", "", (String)localObject2, (String)localObject1);
    }
    Object localObject1 = new WeakReference(paramContext);
    Object localObject2 = jdField_a_of_type_ComTencentMobileqqHaoliyouIJefsClassInjectInterface;
    if (localObject2 == null) {
      return;
    }
    ((IJefsClassInjectInterface)localObject2).a(paramContext, paramString1, paramString4, paramString3, paramString5, paramString6, paramList, paramString2, new JefsClass.5(this, (WeakReference)localObject1, paramCancelableRunnable, paramInt, paramString1));
  }
  
  private void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(true));
    paramRunnable.run();
    this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(false));
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return ("biz_src_jc_qzone".equals(paramString1)) && ("com.qzone".equals(paramString2));
  }
  
  private static boolean a(List<ResolveInfo> paramList)
  {
    if (paramList != null)
    {
      String str = MobileQQ.getContext().getPackageName();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)paramList.next();
        if ((localResolveInfo.activityInfo != null) && (str.equals(localResolveInfo.activityInfo.packageName))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
      {
        if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.indexOfKey(paramInt1) >= 0)
        {
          i = 1;
          this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.delete(paramInt1);
          if (i != 0)
          {
            paramInt1 = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size();
            if (paramInt1 <= 0) {
              try
              {
                MobileQQ.context.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$TeleScreenReceiver);
              }
              catch (Throwable localThrowable)
              {
                QLog.e("TeleScreen|JefsClass", 1, localThrowable, new Object[0]);
              }
            }
          }
          TeleScreen.a().a(paramInt2, -1);
          return;
        }
      }
      int i = 0;
    }
  }
  
  public static JefsClass getInstance()
  {
    return jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass;
  }
  
  public JefsClass.Cancelable a(Context paramContext, Intent paramIntent, String paramString, WeakOuterRefRunnable paramWeakOuterRefRunnable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndDoAsyn() called with: context = [");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("], intent = [");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("], url = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], todo = [");
      localStringBuilder.append(paramWeakOuterRefRunnable);
      localStringBuilder.append("]");
      QLog.d("TeleScreen|JefsClass", 2, localStringBuilder.toString());
    }
    int i = paramIntent.getIntExtra("key_callback_id", 0);
    paramWeakOuterRefRunnable.b(i);
    paramWeakOuterRefRunnable = new JefsClass.CancelableRunnable(paramWeakOuterRefRunnable);
    a(paramContext, paramIntent, paramWeakOuterRefRunnable, new JefsClass.3(this, paramContext, paramIntent, paramString, i));
    return paramWeakOuterRefRunnable.a();
  }
  
  public JefsClass.Cancelable a(Context paramContext, Intent paramIntent, String paramString, Runnable paramRunnable)
  {
    return a(paramContext, paramIntent, paramString, new WeakOuterRefRunnable(paramRunnable, true));
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if ("com.tencent.mobileqq".equals(paramString))
    {
      a(paramInt1, paramInt2);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.telescreen.action_run");
    localIntent.putExtra("key_id", paramInt1);
    localIntent.putExtra("key_process_id", paramString);
    localIntent.putExtra("key_callback_id", paramInt2);
    MobileQQ.context.sendBroadcast(localIntent);
  }
  
  public void a(Activity paramActivity, Intent paramIntent, Runnable paramRunnable)
  {
    getInstance().b(paramActivity, paramIntent, paramRunnable);
  }
  
  public void b(int paramInt1, String paramString, int paramInt2)
  {
    if ("com.tencent.mobileqq".equals(paramString))
    {
      b(paramInt1, paramInt2);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.telescreen.action_remove");
    localIntent.putExtra("key_id", paramInt1);
    localIntent.putExtra("key_process_id", paramString);
    localIntent.putExtra("key_callback_id", paramInt2);
    MobileQQ.context.sendBroadcast(localIntent);
  }
  
  public void b(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    getInstance().a(paramActivity, paramIntent, new JefsClass.2(this, paramActivity, paramIntent, paramInt, paramBundle));
  }
  
  public void b(Context paramContext, Intent paramIntent, Runnable paramRunnable)
  {
    a(paramContext, paramIntent, null, new WeakOuterRefRunnable(paramRunnable, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass
 * JD-Core Version:    0.7.0.1
 */