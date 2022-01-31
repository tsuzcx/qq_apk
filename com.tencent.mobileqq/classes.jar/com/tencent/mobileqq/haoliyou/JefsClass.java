package com.tencent.mobileqq.haoliyou;

import akcy;
import amau;
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
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import aqve;
import aqvf;
import aqvg;
import aqvh;
import aqvi;
import aqvn;
import aqvo;
import aqvp;
import aqvq;
import aqvr;
import aqwk;
import axqy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bigbrother.WeakOuterRefRunnable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class JefsClass
  extends aqve
{
  private static JefsClass jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass = new JefsClass();
  private static final Set<String> jdField_a_of_type_JavaUtilSet = new ArraySet();
  private static final Set<String> b;
  private static final Set<String> c;
  private int jdField_a_of_type_Int;
  private final SparseArrayCompat<Runnable> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private aqvq jdField_a_of_type_Aqvq;
  private aqvr jdField_a_of_type_Aqvr;
  private ThreadLocal<Boolean> jdField_a_of_type_JavaLangThreadLocal = new aqvf(this);
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
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
    b = new ArraySet();
    b.add(BaseApplicationImpl.sApplication.getPackageName());
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
  
  public static aqvq a(JSONObject paramJSONObject)
  {
    aqvq localaqvq = new aqvq();
    if (paramJSONObject == null) {
      return localaqvq;
    }
    label199:
    for (;;)
    {
      try
      {
        Object localObject1 = paramJSONObject.optJSONArray("packages");
        String str;
        if (localObject1 != null)
        {
          j = ((JSONArray)localObject1).length();
          i = 0;
          if (i < j)
          {
            str = ((JSONArray)localObject1).getString(i);
            if (str == null) {
              break label199;
            }
            localaqvq.jdField_a_of_type_JavaUtilSet.add(str);
            break label199;
          }
        }
        paramJSONObject = paramJSONObject.optJSONArray("policy");
        if (paramJSONObject == null) {
          break;
        }
        int j = paramJSONObject.length();
        int i = 0;
        if (i >= j) {
          break;
        }
        Object localObject2 = paramJSONObject.getJSONObject(i);
        if (localObject2 != null)
        {
          localObject1 = ((JSONObject)localObject2).optString("package");
          str = ((JSONObject)localObject2).optString("schema");
          localObject2 = ((JSONObject)localObject2).optString("action");
          aqvp localaqvp = new aqvp();
          localaqvp.a = ((String)localObject1);
          localaqvp.b = str.toLowerCase();
          localaqvp.c = ((String)localObject2).toLowerCase();
          localaqvq.jdField_a_of_type_JavaUtilList.add(localaqvp);
        }
        i += 1;
        continue;
        i += 1;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.d("TeleScreen|JefsClass", 1, paramJSONObject, new Object[0]);
        return localaqvq;
      }
    }
  }
  
  private static String a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, "getSourceId() called with: context = [" + paramContext + "], intent = [" + paramIntent + "]");
    }
    Intent localIntent = null;
    if (paramIntent.hasExtra("big_brother_source_key"))
    {
      paramIntent = paramIntent.getStringExtra("big_brother_source_key");
      localIntent = paramIntent;
      if (QLog.isColorLevel())
      {
        QLog.d("TeleScreen|JefsClass", 2, "getSourceId() src = [" + paramIntent + "], from intent");
        localIntent = paramIntent;
      }
    }
    paramIntent = localIntent;
    if (localIntent == null)
    {
      paramIntent = localIntent;
      if ((paramContext instanceof Activity))
      {
        paramContext = ((Activity)paramContext).getIntent();
        paramIntent = localIntent;
        if (paramContext != null)
        {
          paramContext = paramContext.getStringExtra("big_brother_source_key");
          paramIntent = paramContext;
          if (QLog.isColorLevel())
          {
            QLog.d("TeleScreen|JefsClass", 2, "getSourceId() src = [" + paramContext + "], from Activity");
            paramIntent = paramContext;
          }
        }
      }
    }
    return paramIntent;
  }
  
  private static String a(Context paramContext, Intent paramIntent, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, "getRefId() called with: context = [" + paramContext + "], intent = [" + paramIntent + "], source = [" + paramString + "]");
    }
    if ("biz_src_ads".equals(paramString))
    {
      if ((paramIntent != null) && (paramIntent.getStringExtra("big_brother_ref_source_key") != null))
      {
        paramContext = paramIntent.getStringExtra("big_brother_ref_source_key");
        paramIntent = paramContext;
        if (QLog.isColorLevel())
        {
          QLog.d("TeleScreen|JefsClass", 2, "getRefId() refId = [" + paramContext + "], from intent");
          paramIntent = paramContext;
        }
        return paramIntent;
      }
      if ((paramContext instanceof Activity))
      {
        paramContext = ((Activity)paramContext).getIntent();
        if (paramContext != null)
        {
          paramString = paramContext.getStringExtra("big_brother_source_key");
          String str = paramContext.getStringExtra("big_brother_ref_source_key");
          if (str != null) {}
          for (paramContext = str;; paramContext = paramString)
          {
            paramIntent = paramContext;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("TeleScreen|JefsClass", 2, "getRefId() Activity Source = [" + paramString + "], refId = [" + str + "]");
            return paramContext;
          }
        }
      }
      else
      {
        QLog.i("TeleScreen|JefsClass", 1, "getRefId: context is not Activity " + paramContext);
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
      amau.a().a(paramInt2, 2);
      return;
    }
  }
  
  private void a(Context paramContext, Intent paramIntent, JefsClass.CancelableRunnable paramCancelableRunnable, aqvo paramaqvo)
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
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, "src " + str3 + ", ref " + str1);
    }
    if (!akcy.a())
    {
      a(paramCancelableRunnable);
      return;
    }
    if (b.contains(str2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TeleScreen|JefsClass", 2, "skip package: " + str2 + ", sourceId: " + str3 + ", refId = " + str1);
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
          if (QLog.isColorLevel()) {
            QLog.d("TeleScreen|JefsClass", 2, "skip package: " + str2 + ", sourceId: " + str3);
          }
          a(paramCancelableRunnable);
          return;
        }
      }
    }
    str2 = paramIntent.getAction();
    if (jdField_a_of_type_JavaUtilSet.contains(str2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TeleScreen|JefsClass", 2, "skip action: " + str2);
      }
      a(paramCancelableRunnable);
      return;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject != null) && (!((AppRuntime)localObject).isLogin()))
    {
      QLog.i("TeleScreen|JefsClass", 1, "haven't login ");
      a(paramCancelableRunnable);
      return;
    }
    localObject = paramIntent.getData();
    if ((localObject != null) && (((Uri)localObject).getScheme() != null) && (((((Uri)localObject).getScheme().startsWith("tencent")) && ("tauth.qq.com".equals(((Uri)localObject).getAuthority()))) || ((((Uri)localObject).getScheme().startsWith("qwallet")) && ("open_pay".equals(((Uri)localObject).getAuthority()))) || ((((Uri)localObject).getScheme().equals("tmast")) && ("sdk_wake".equals(((Uri)localObject).getAuthority()))) || ((((Uri)localObject).getScheme().equals("https")) && ("ssl.ptlogin2.qq.com".equals(((Uri)localObject).getAuthority())) && ("/jump".equals(((Uri)localObject).getPath())))))
    {
      a(paramCancelableRunnable);
      return;
    }
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    if ((localObject != null) && ((paramContext == null) || (paramContext.size() == 0)))
    {
      QLog.i("TeleScreen|JefsClass", 1, "no matching app: " + paramIntent.getDataString());
      a(paramCancelableRunnable);
      return;
    }
    if ((paramContext != null) && (paramContext.size() == 1))
    {
      localObject = ((ResolveInfo)paramContext.get(0)).activityInfo;
      if (localObject != null)
      {
        if (b.contains(((ActivityInfo)localObject).packageName))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TeleScreen|JefsClass", 2, "skip package: " + ((ActivityInfo)localObject).packageName + ", sourceId: " + str3);
          }
          a(paramCancelableRunnable);
          return;
        }
        if (("com.tencent.android.qqdownloader".equals(((ActivityInfo)localObject).packageName)) && ("com.live.push.PushActivity".equals(((ActivityInfo)localObject).name)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TeleScreen|JefsClass", 2, "wake up yyb");
          }
          a(paramCancelableRunnable);
          return;
        }
      }
    }
    paramaqvo.a(str1, paramIntent.getDataString(), str2, paramContext, paramCancelableRunnable);
  }
  
  /* Error */
  private void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, List<ResolveInfo> paramList, JefsClass.CancelableRunnable paramCancelableRunnable, int paramInt)
  {
    // Byte code:
    //   0: ldc 254
    //   2: iconst_1
    //   3: ldc_w 517
    //   6: invokestatic 339	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_1
    //   10: aload_2
    //   11: invokestatic 377	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Landroid/content/Intent;)Ljava/lang/String;
    //   14: astore 12
    //   16: aload_1
    //   17: aload_2
    //   18: aload 12
    //   20: invokestatic 379	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 13
    //   25: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +49 -> 77
    //   31: ldc 254
    //   33: iconst_2
    //   34: ldc_w 519
    //   37: bipush 6
    //   39: anewarray 256	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload 12
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload 13
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: aload_3
    //   55: aastore
    //   56: dup
    //   57: iconst_3
    //   58: aload 4
    //   60: aastore
    //   61: dup
    //   62: iconst_4
    //   63: aload 5
    //   65: aastore
    //   66: dup
    //   67: iconst_5
    //   68: aload 6
    //   70: aastore
    //   71: invokestatic 523	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   74: invokestatic 293	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload 8
    //   79: aload 12
    //   81: invokevirtual 528	com/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable:a	(Ljava/lang/String;)V
    //   84: invokestatic 533	ampl:a	()Lampl;
    //   87: sipush 416
    //   90: invokevirtual 535	ampl:a	(I)Ljava/lang/Object;
    //   93: checkcast 537	amaw
    //   96: astore 11
    //   98: aload 11
    //   100: getfield 539	amaw:jdField_a_of_type_Boolean	Z
    //   103: ifeq +180 -> 283
    //   106: aload 11
    //   108: aload 12
    //   110: aload 5
    //   112: invokevirtual 542	amaw:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   115: ifne +168 -> 283
    //   118: aload 7
    //   120: invokestatic 545	com/tencent/mobileqq/haoliyou/JefsClass:a	(Ljava/util/List;)Z
    //   123: ifne +160 -> 283
    //   126: aload 12
    //   128: aload 4
    //   130: invokestatic 546	com/tencent/mobileqq/haoliyou/JefsClass:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   133: ifne +150 -> 283
    //   136: iconst_1
    //   137: istore 10
    //   139: iload 10
    //   141: ifeq +148 -> 289
    //   144: aload 8
    //   146: astore 11
    //   148: iload 10
    //   150: ifne +561 -> 711
    //   153: ldc 254
    //   155: iconst_1
    //   156: ldc_w 548
    //   159: invokestatic 339	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: aload 8
    //   165: invokespecial 352	com/tencent/mobileqq/haoliyou/JefsClass:a	(Ljava/lang/Runnable;)V
    //   168: iconst_0
    //   169: istore 9
    //   171: aload_2
    //   172: ldc_w 550
    //   175: iconst_1
    //   176: invokevirtual 554	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   179: pop
    //   180: new 556	java/lang/ref/WeakReference
    //   183: dup
    //   184: aload_1
    //   185: invokespecial 559	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   188: astore 8
    //   190: ldc_w 561
    //   193: aload 6
    //   195: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   198: ifeq +97 -> 295
    //   201: ldc_w 563
    //   204: aload_2
    //   205: invokevirtual 566	android/content/Intent:getType	()Ljava/lang/String;
    //   208: invokevirtual 569	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   211: ifne +13 -> 224
    //   214: aload_2
    //   215: ldc_w 571
    //   218: invokevirtual 301	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   221: ifeq +74 -> 295
    //   224: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +12 -> 239
    //   230: ldc 254
    //   232: iconst_2
    //   233: ldc_w 573
    //   236: invokestatic 293	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: new 575	com/tencent/mobileqq/haoliyou/JefsClass$7
    //   242: dup
    //   243: aload_0
    //   244: aload_2
    //   245: aload 11
    //   247: aload 8
    //   249: aload 12
    //   251: aload 13
    //   253: invokespecial 578	com/tencent/mobileqq/haoliyou/JefsClass$7:<init>	(Lcom/tencent/mobileqq/haoliyou/JefsClass;Landroid/content/Intent;Lcom/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable;Ljava/lang/ref/WeakReference;Ljava/lang/String;Ljava/lang/String;)V
    //   256: bipush 64
    //   258: aconst_null
    //   259: iconst_1
    //   260: invokestatic 584	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   263: return
    //   264: astore_1
    //   265: ldc 254
    //   267: iconst_1
    //   268: aload_1
    //   269: iconst_0
    //   270: anewarray 256	java/lang/Object
    //   273: invokestatic 587	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   276: aload_0
    //   277: aload 8
    //   279: invokespecial 352	com/tencent/mobileqq/haoliyou/JefsClass:a	(Ljava/lang/Runnable;)V
    //   282: return
    //   283: iconst_0
    //   284: istore 10
    //   286: goto -147 -> 139
    //   289: aconst_null
    //   290: astore 11
    //   292: goto -144 -> 148
    //   295: aload 5
    //   297: ifnull +98 -> 395
    //   300: aload 5
    //   302: ldc_w 589
    //   305: invokevirtual 445	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   308: ifne +14 -> 322
    //   311: aload 5
    //   313: ldc_w 591
    //   316: invokevirtual 445	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   319: ifeq +76 -> 395
    //   322: ldc_w 563
    //   325: aload_2
    //   326: ldc_w 593
    //   329: invokevirtual 304	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   332: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   335: ifeq +37 -> 372
    //   338: aload_0
    //   339: aload_1
    //   340: aload 12
    //   342: aload 13
    //   344: aconst_null
    //   345: aload 5
    //   347: aload 11
    //   349: invokespecial 596	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V
    //   352: return
    //   353: astore_1
    //   354: ldc 254
    //   356: iconst_1
    //   357: aload_1
    //   358: iconst_0
    //   359: anewarray 256	java/lang/Object
    //   362: invokestatic 587	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   365: aload_0
    //   366: aload 11
    //   368: invokespecial 352	com/tencent/mobileqq/haoliyou/JefsClass:a	(Ljava/lang/Runnable;)V
    //   371: return
    //   372: aload_0
    //   373: aload_1
    //   374: aload 12
    //   376: aload 13
    //   378: aload 4
    //   380: aload_3
    //   381: aload 5
    //   383: aload 6
    //   385: aload 7
    //   387: aload 11
    //   389: iload 9
    //   391: invokespecial 599	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable;I)V
    //   394: return
    //   395: aload 5
    //   397: ifnull +98 -> 495
    //   400: aload 5
    //   402: ldc_w 601
    //   405: invokevirtual 445	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   408: ifeq +87 -> 495
    //   411: aload_0
    //   412: aload 5
    //   414: ldc_w 601
    //   417: invokevirtual 602	java/lang/String:length	()I
    //   420: invokevirtual 605	java/lang/String:substring	(I)Ljava/lang/String;
    //   423: invokespecial 607	com/tencent/mobileqq/haoliyou/JefsClass:a	(Ljava/lang/String;)Landroid/support/v4/util/ArrayMap;
    //   426: astore_2
    //   427: ldc_w 563
    //   430: invokestatic 612	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   433: aload_2
    //   434: ldc_w 614
    //   437: invokevirtual 617	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   440: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   443: ifeq +29 -> 472
    //   446: aload_0
    //   447: aload_1
    //   448: aload 12
    //   450: aload 13
    //   452: aconst_null
    //   453: aload_2
    //   454: ldc_w 619
    //   457: invokevirtual 617	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   460: checkcast 181	java/lang/String
    //   463: invokestatic 624	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   466: aload 11
    //   468: invokespecial 596	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V
    //   471: return
    //   472: aload_0
    //   473: aload_1
    //   474: aload 12
    //   476: aload 13
    //   478: aload 4
    //   480: aload_3
    //   481: aload 5
    //   483: aload 6
    //   485: aload 7
    //   487: aload 11
    //   489: iload 9
    //   491: invokespecial 599	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable;I)V
    //   494: return
    //   495: aload 5
    //   497: ifnull +132 -> 629
    //   500: aload 5
    //   502: ldc_w 626
    //   505: invokevirtual 445	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   508: ifeq +121 -> 629
    //   511: aload 5
    //   513: ldc_w 628
    //   516: invokevirtual 632	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   519: istore 10
    //   521: iload 10
    //   523: iflt +83 -> 606
    //   526: aload_0
    //   527: aload 5
    //   529: iload 10
    //   531: invokevirtual 605	java/lang/String:substring	(I)Ljava/lang/String;
    //   534: invokespecial 607	com/tencent/mobileqq/haoliyou/JefsClass:a	(Ljava/lang/String;)Landroid/support/v4/util/ArrayMap;
    //   537: astore_2
    //   538: ldc_w 563
    //   541: invokestatic 612	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   544: aload_2
    //   545: ldc_w 614
    //   548: invokevirtual 617	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   551: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   554: ifeq +29 -> 583
    //   557: aload_0
    //   558: aload_1
    //   559: aload 12
    //   561: aload 13
    //   563: aconst_null
    //   564: aload_2
    //   565: ldc_w 619
    //   568: invokevirtual 617	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   571: checkcast 181	java/lang/String
    //   574: invokestatic 624	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   577: aload 11
    //   579: invokespecial 596	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V
    //   582: return
    //   583: aload_0
    //   584: aload_1
    //   585: aload 12
    //   587: aload 13
    //   589: aload 4
    //   591: aload_3
    //   592: aload 5
    //   594: aload 6
    //   596: aload 7
    //   598: aload 11
    //   600: iload 9
    //   602: invokespecial 599	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable;I)V
    //   605: return
    //   606: aload_0
    //   607: aload_1
    //   608: aload 12
    //   610: aload 13
    //   612: aload 4
    //   614: aload_3
    //   615: aload 5
    //   617: aload 6
    //   619: aload 7
    //   621: aload 11
    //   623: iload 9
    //   625: invokespecial 599	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable;I)V
    //   628: return
    //   629: aload 5
    //   631: ifnull +57 -> 688
    //   634: aload 5
    //   636: ldc_w 634
    //   639: invokevirtual 445	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   642: ifeq +46 -> 688
    //   645: aload_2
    //   646: ldc_w 635
    //   649: invokevirtual 304	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   652: astore_3
    //   653: aconst_null
    //   654: astore_2
    //   655: aload_3
    //   656: ifnonnull +18 -> 674
    //   659: aload 5
    //   661: invokestatic 639	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   664: ldc_w 641
    //   667: invokevirtual 644	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   670: invokestatic 624	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   673: astore_2
    //   674: aload_0
    //   675: aload_1
    //   676: aload 12
    //   678: aload 13
    //   680: aload_3
    //   681: aload_2
    //   682: aload 11
    //   684: invokespecial 596	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V
    //   687: return
    //   688: aload_0
    //   689: aload_1
    //   690: aload 12
    //   692: aload 13
    //   694: aload 4
    //   696: aload_3
    //   697: aload 5
    //   699: aload 6
    //   701: aload 7
    //   703: aload 11
    //   705: iload 9
    //   707: invokespecial 599	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/haoliyou/JefsClass$CancelableRunnable;I)V
    //   710: return
    //   711: goto -540 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	714	0	this	JefsClass
    //   0	714	1	paramContext	Context
    //   0	714	2	paramIntent	Intent
    //   0	714	3	paramString1	String
    //   0	714	4	paramString2	String
    //   0	714	5	paramString3	String
    //   0	714	6	paramString4	String
    //   0	714	7	paramList	List<ResolveInfo>
    //   0	714	8	paramCancelableRunnable	JefsClass.CancelableRunnable
    //   0	714	9	paramInt	int
    //   137	393	10	i	int
    //   96	608	11	localObject	Object
    //   14	677	12	str1	String
    //   23	670	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   84	98	264	java/lang/Throwable
    //   180	224	353	java/lang/Throwable
    //   224	239	353	java/lang/Throwable
    //   239	263	353	java/lang/Throwable
    //   300	322	353	java/lang/Throwable
    //   322	352	353	java/lang/Throwable
    //   372	394	353	java/lang/Throwable
    //   400	471	353	java/lang/Throwable
    //   472	494	353	java/lang/Throwable
    //   500	521	353	java/lang/Throwable
    //   526	582	353	java/lang/Throwable
    //   583	605	353	java/lang/Throwable
    //   606	628	353	java/lang/Throwable
    //   634	653	353	java/lang/Throwable
    //   659	674	353	java/lang/Throwable
    //   674	687	353	java/lang/Throwable
    //   688	710	353	java/lang/Throwable
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Runnable paramRunnable)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    String str1;
    if (TextUtils.isEmpty(paramString1))
    {
      if (!(paramContext instanceof BaseActivity)) {
        break label103;
      }
      localQQAppInterface = ((BaseActivity)paramContext).app;
      str2 = paramContext.getClass().getName();
      if (paramString3 == null) {
        break label109;
      }
      str1 = paramString3;
    }
    for (;;)
    {
      axqy.b(localQQAppInterface, "dc00898", "", "", "0X8009C58", "0X8009C58", 0, 0, "", "", str2, str1);
      aqwk.a(paramContext, paramString1, paramString3, paramString4, paramString2, new aqvh(this, paramRunnable, new WeakReference(paramContext), paramString1));
      return;
      label103:
      localQQAppInterface = null;
      break;
      label109:
      if (paramString4 == null) {
        str1 = "";
      } else {
        str1 = paramString4;
      }
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<ResolveInfo> paramList, JefsClass.CancelableRunnable paramCancelableRunnable, int paramInt)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    String str1;
    if (TextUtils.isEmpty(paramString1))
    {
      if (!(paramContext instanceof BaseActivity)) {
        break label111;
      }
      localQQAppInterface = ((BaseActivity)paramContext).app;
      str2 = paramContext.getClass().getName();
      if (paramString3 == null) {
        break label117;
      }
      str1 = paramString3;
    }
    for (;;)
    {
      axqy.b(localQQAppInterface, "dc00898", "", "", "0X8009C58", "0X8009C58", 0, 0, "", "", str2, str1);
      aqwk.a(paramContext, paramString1, paramString4, paramString3, paramString5, paramString6, paramList, paramString2, new aqvi(this, new WeakReference(paramContext), paramCancelableRunnable, paramInt, paramString1));
      return;
      label111:
      localQQAppInterface = null;
      break;
      label117:
      if (paramString5 != null) {
        str1 = paramString5;
      } else if (paramString6 != null) {
        str1 = paramString6;
      } else if (paramString4 == null) {
        str1 = "";
      } else {
        str1 = paramString4;
      }
    }
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
      String str = BaseApplicationImpl.sApplication.getPackageName();
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
    for (int i = 1;; i = 0) {
      synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
      {
        if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.indexOfKey(paramInt1) >= 0)
        {
          this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.delete(paramInt1);
          if (i != 0)
          {
            paramInt1 = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size();
            if (paramInt1 > 0) {}
          }
          try
          {
            BaseApplicationImpl.context.unregisterReceiver(this.jdField_a_of_type_Aqvr);
            amau.a().a(paramInt2, -1);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              QLog.e("TeleScreen|JefsClass", 1, localThrowable, new Object[0]);
            }
          }
        }
      }
    }
  }
  
  public static JefsClass getInstance()
  {
    return jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass;
  }
  
  public aqvn a(Context paramContext, Intent paramIntent, String paramString, WeakOuterRefRunnable paramWeakOuterRefRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, "checkAndDoAsyn() called with: context = [" + paramContext + "], intent = [" + paramIntent + "], url = [" + paramString + "], todo = [" + paramWeakOuterRefRunnable + "]");
    }
    int i = paramIntent.getIntExtra("key_callback_id", 0);
    paramWeakOuterRefRunnable.b(i);
    paramWeakOuterRefRunnable = new JefsClass.CancelableRunnable(paramWeakOuterRefRunnable);
    a(paramContext, paramIntent, paramWeakOuterRefRunnable, new aqvg(this, paramContext, paramIntent, paramString, i));
    return paramWeakOuterRefRunnable.a();
  }
  
  public aqvn a(Context paramContext, Intent paramIntent, String paramString, Runnable paramRunnable)
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
    BaseApplicationImpl.context.sendBroadcast(localIntent);
  }
  
  public void a(Activity paramActivity, Intent paramIntent, Runnable paramRunnable)
  {
    getInstance().b(paramActivity, paramIntent, paramRunnable);
  }
  
  public void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Aqvq = a(paramJSONObject);
      return;
    }
    finally
    {
      paramJSONObject = finally;
      throw paramJSONObject;
    }
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
    BaseApplicationImpl.context.sendBroadcast(localIntent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass
 * JD-Core Version:    0.7.0.1
 */