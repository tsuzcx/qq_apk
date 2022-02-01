package com.tencent.mobileqq.portal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.olympic.OlympicDPC;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.Integer;>;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

public class PortalManager
  implements SoundPool.OnLoadCompleteListener, Handler.Callback, INetEngineListener, Manager, BusinessObserver
{
  static int jdField_a_of_type_Int;
  static long jdField_a_of_type_Long = 2500L;
  private static PortalManager.TimerConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig;
  public static final String a;
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private static Comparator<PortalManager.TimerConfig> jdField_a_of_type_JavaUtilComparator;
  public static boolean a;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "2016-12-13", "2016-12-14", "2017-1-20", "2017-1-27", "2017-1-28" };
  private static final boolean[] jdField_a_of_type_ArrayOfBoolean;
  static long jdField_b_of_type_Long = 180000L;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  static long jdField_c_of_type_Long = 180000L;
  public static long f;
  public static long g;
  private static long i;
  private Context jdField_a_of_type_AndroidContentContext;
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private Handler jdField_a_of_type_AndroidOsHandler;
  SparseArrayCompat<ArrayList<Long>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(1);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new PortalManager.4(this);
  private OlympicDPC jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC;
  private PortalManager.BannerConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
  private PortalManager.PortalConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
  PortalManager.PortalJSReceiver jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalJSReceiver;
  private PortalManager.PortalShower jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
  protected volatile PortalManager.RedPacketConfig a;
  private IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  final ConcurrentHashMap<String, PortalManager.IconReqDetails> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(1000);
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 0, 0, 0, 0 };
  int jdField_b_of_type_Int = 4;
  private Handler jdField_b_of_type_AndroidOsHandler;
  SparseArrayCompat<ArrayList<Long>> jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(100);
  private PortalManager.BannerConfig jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
  private PortalManager.PortalConfig jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  public long d;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  volatile long jdField_e_of_type_Long = 0L;
  private long h = 0L;
  private long j = 0L;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaLangString = File.separator + "redPacketRes/";
    jdField_a_of_type_JavaUtilComparator = new PortalManager.3();
    jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig = new PortalManager.TimerConfig(null);
    jdField_a_of_type_JavaTextSimpleDateFormat = null;
    f = 0L;
    g = 0L;
    i = 0L;
    jdField_a_of_type_ArrayOfBoolean = new boolean[] { 0, 0, 0, 0, 0 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2131230748, 2131230750, 2131230749, 2131230747, 2131230751 };
  }
  
  public PortalManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.sApplication;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalJSReceiver = new PortalManager.PortalJSReceiver(this, null);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalJSReceiver, new IntentFilter("com.tencent.portal.req.action"), "com.tencent.msg.permission.pushnotify", null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("PortalManager", 1, "", paramQQAppInterface);
      }
    }
  }
  
  private static int a(String paramString)
  {
    int m = -1;
    int k = m;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!"hb_icon_path".equals(paramString)) {
        break label27;
      }
      k = 2130845060;
    }
    label27:
    do
    {
      do
      {
        return k;
        if ("hb_name_path".equals(paramString)) {
          return 2130845414;
        }
        k = m;
      } while ("hb_banner_path".equals(paramString));
      if ("hb_yure_star_logo_path".equals(paramString)) {
        return 2130845582;
      }
      if ("hb_yure_star_name_path".equals(paramString)) {
        return 2130845583;
      }
      if ("hb_busi_logo_path".equals(paramString)) {
        return 2130845404;
      }
      if ("hb_yure_busi_name_path".equals(paramString)) {
        return 2130845405;
      }
      if ("hb_bg_name_path".equals(paramString)) {
        return 2130845416;
      }
      if ("hb_leftclound_name_path".equals(paramString)) {
        return 2130845410;
      }
      if ("hb_rightclound_name_path".equals(paramString)) {
        return 2130845411;
      }
      if ("hb_luckybag_name_path".equals(paramString)) {
        return 2130845532;
      }
      k = m;
    } while (!"hb_luckybag_ing_name_path".equals(paramString));
    return 2130845533;
  }
  
  public static long a(String paramString)
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l1 = -1L;
    try
    {
      long l2 = jdField_a_of_type_JavaTextSimpleDateFormat.parse(paramString).getTime();
      l1 = l2;
    }
    catch (ParseException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PortalManager", 2, "", paramString);
    }
    return l1;
    return -1L;
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      paramString = (Bitmap)GlobalImageCache.a.get("red_packet_" + paramString);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("getBitmapFromCache, hit=");
        if (paramString == null) {
          break label73;
        }
      }
      label73:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("PortalManager", 2, bool);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PortalManager", 2, "preloadDrawableById Exception", paramString);
      }
    }
  }
  
  /* Error */
  public static Bitmap a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +40 -> 45
    //   8: ldc_w 268
    //   11: iconst_2
    //   12: new 71	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 398
    //   22: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 400
    //   32: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_1
    //   36: invokevirtual 403	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 391	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: getstatic 373	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   48: new 71	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 375
    //   58: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokevirtual 381	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 383	android/graphics/Bitmap
    //   74: astore_3
    //   75: aload_3
    //   76: ifnull +36 -> 112
    //   79: aload_3
    //   80: astore 5
    //   82: aload_3
    //   83: astore 6
    //   85: aload_3
    //   86: astore 4
    //   88: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +207 -> 298
    //   94: aload_3
    //   95: astore 5
    //   97: aload_3
    //   98: astore 6
    //   100: ldc_w 268
    //   103: iconst_2
    //   104: ldc_w 405
    //   107: invokestatic 391	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_3
    //   111: areturn
    //   112: aload_3
    //   113: astore 5
    //   115: aload_3
    //   116: astore 6
    //   118: invokestatic 409	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   121: invokevirtual 413	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   124: getstatic 418	com/tencent/mobileqq/app/QQManagerFactory:MGR_PORTAL	I
    //   127: invokevirtual 424	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   130: checkcast 2	com/tencent/mobileqq/portal/PortalManager
    //   133: astore 4
    //   135: aload 4
    //   137: ifnull +15 -> 152
    //   140: aload_3
    //   141: astore 5
    //   143: aload_3
    //   144: astore 6
    //   146: aload 4
    //   148: getfield 426	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC	Lcom/tencent/mobileqq/olympic/OlympicDPC;
    //   151: astore_2
    //   152: aload_3
    //   153: astore 5
    //   155: aload_3
    //   156: astore 6
    //   158: ldc_w 270
    //   161: iload_1
    //   162: aload_2
    //   163: iconst_2
    //   164: invokestatic 429	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;ILcom/tencent/mobileqq/olympic/OlympicDPC;I)Landroid/util/Pair;
    //   167: astore 4
    //   169: aload_3
    //   170: astore_2
    //   171: aload 4
    //   173: ifnull +18 -> 191
    //   176: aload_3
    //   177: astore 5
    //   179: aload_3
    //   180: astore 6
    //   182: aload 4
    //   184: getfield 435	android/util/Pair:second	Ljava/lang/Object;
    //   187: checkcast 383	android/graphics/Bitmap
    //   190: astore_2
    //   191: aload_2
    //   192: astore 4
    //   194: aload_2
    //   195: ifnull +103 -> 298
    //   198: aload_2
    //   199: astore 5
    //   201: aload_2
    //   202: astore 6
    //   204: getstatic 373	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   207: new 71	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   214: ldc_w 375
    //   217: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: aload_2
    //   228: invokevirtual 439	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: aload_2
    //   233: areturn
    //   234: astore_0
    //   235: aload 5
    //   237: astore 4
    //   239: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +56 -> 298
    //   245: ldc_w 268
    //   248: iconst_2
    //   249: ldc_w 441
    //   252: aload_0
    //   253: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   256: aload 5
    //   258: areturn
    //   259: astore_0
    //   260: aconst_null
    //   261: astore 6
    //   263: aload 6
    //   265: astore 4
    //   267: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +28 -> 298
    //   273: ldc_w 268
    //   276: iconst_2
    //   277: ldc_w 393
    //   280: aload_0
    //   281: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   284: aload 6
    //   286: areturn
    //   287: astore_0
    //   288: goto -25 -> 263
    //   291: astore_0
    //   292: aconst_null
    //   293: astore 5
    //   295: goto -60 -> 235
    //   298: aload 4
    //   300: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramString	String
    //   0	301	1	paramInt	int
    //   1	232	2	localObject1	Object
    //   74	106	3	localBitmap	Bitmap
    //   86	213	4	localObject2	Object
    //   80	214	5	localObject3	Object
    //   83	202	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   88	94	234	java/lang/OutOfMemoryError
    //   100	110	234	java/lang/OutOfMemoryError
    //   118	135	234	java/lang/OutOfMemoryError
    //   146	152	234	java/lang/OutOfMemoryError
    //   158	169	234	java/lang/OutOfMemoryError
    //   182	191	234	java/lang/OutOfMemoryError
    //   204	232	234	java/lang/OutOfMemoryError
    //   45	75	259	java/lang/Exception
    //   88	94	287	java/lang/Exception
    //   100	110	287	java/lang/Exception
    //   118	135	287	java/lang/Exception
    //   146	152	287	java/lang/Exception
    //   158	169	287	java/lang/Exception
    //   182	191	287	java/lang/Exception
    //   204	232	287	java/lang/Exception
    //   45	75	291	java/lang/OutOfMemoryError
  }
  
  public static Bitmap a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "getBitmap, path=" + paramString1 + ", defaultPath=" + paramString2);
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getFilesDir() + jdField_a_of_type_JavaLangString;
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return a(paramString2, true);
      }
      str = "red_packet_" + paramString1;
      localBitmap = (Bitmap)GlobalImageCache.a.get(str);
      if (localBitmap == null) {
        break label167;
      }
      localObject1 = localBitmap;
      paramString1 = localBitmap;
      try
      {
        if (!QLog.isColorLevel()) {
          return paramString1;
        }
        localObject1 = localBitmap;
        QLog.d("PortalManager", 2, "getBitmap, hit cache");
        return localBitmap;
      }
      catch (Exception paramString2) {}
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        String str;
        Bitmap localBitmap;
        label167:
        Object localObject1 = null;
      }
    }
    paramString1 = (String)localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("PortalManager", 2, "", paramString2);
      return localObject1;
      localObject1 = localBitmap;
      try
      {
        PortalManager localPortalManager = (PortalManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MGR_PORTAL);
        localObject1 = localBitmap;
        localObject2 = a((String)localObject2 + paramString1, -1, localPortalManager.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC, 1);
        paramString1 = localBitmap;
        if (localObject2 != null)
        {
          localObject1 = localBitmap;
          paramString1 = (Bitmap)((Pair)localObject2).second;
        }
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PortalManager", 2, "getBitmap, exception=" + paramString1.getMessage(), paramString1);
          }
          paramString1 = null;
        }
        localObject1 = paramString1;
        paramString2 = a(paramString2, true);
        localObject1 = paramString2;
        paramString1 = paramString2;
        if (!QLog.isColorLevel()) {
          return paramString1;
        }
      }
      if (paramString1 != null)
      {
        localObject1 = paramString1;
        GlobalImageCache.a.put(str, paramString1);
        return paramString1;
      }
      localObject1 = paramString2;
      QLog.d("PortalManager", 2, "getBitmap, using default bitmap");
      return paramString2;
    }
    return paramString1;
  }
  
  public static Bitmap a(String paramString, boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, new Object[] { "getDefaultIconBitmap", paramString });
      }
      localObject2 = (Bitmap)GlobalImageCache.a.get("red_packet_" + paramString);
      if (localObject2 != null) {
        return localObject2;
      }
      k = a(paramString);
      if (k < 0) {
        return null;
      }
      localObject1 = (PortalManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MGR_PORTAL);
      if (localObject1 == null) {
        break label194;
      }
      localObject1 = ((PortalManager)localObject1).jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        int k;
        Pair localPair;
        if (QLog.isColorLevel()) {
          QLog.e("PortalManager", 2, "", paramString);
        }
        return null;
        Object localObject1 = null;
      }
    }
    catch (Exception paramString)
    {
      label194:
      if (!QLog.isColorLevel()) {
        break label217;
      }
      QLog.e("PortalManager", 2, "", paramString);
      label217:
      localObject2 = null;
    }
    localPair = a("", k, (OlympicDPC)localObject1, 2);
    localObject1 = localObject2;
    if (localPair != null) {
      localObject1 = (Bitmap)localPair.second;
    }
    Object localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (paramBoolean)
      {
        GlobalImageCache.a.put("red_packet_" + paramString, localObject1);
        return localObject1;
      }
    }
    return localObject2;
  }
  
  private static Pair<Integer, Bitmap> a(String paramString, int paramInt1, OlympicDPC paramOlympicDPC, int paramInt2)
  {
    localObject3 = null;
    Object localObject1 = null;
    m = 0;
    if ((TextUtils.isEmpty(paramString)) && (paramInt1 < 0)) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject4 = new BitmapFactory.Options();
        if (paramOlympicDPC == null) {
          continue;
        }
        ((BitmapFactory.Options)localObject4).inPurgeable = true;
        ((BitmapFactory.Options)localObject4).inInputShareable = true;
        if (!paramOlympicDPC.jdField_d_of_type_Boolean) {
          continue;
        }
        ((BitmapFactory.Options)localObject4).inPreferredConfig = Bitmap.Config.ARGB_8888;
        if (!paramOlympicDPC.jdField_b_of_type_Boolean) {
          continue;
        }
        ((BitmapFactory.Options)localObject4).inSampleSize = 2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if ((paramOlympicDPC == null) || (paramOlympicDPC.jdField_b_of_type_Boolean)) {
          continue;
        }
        paramOlympicDPC.jdField_b_of_type_Boolean = true;
        if (paramOlympicDPC.jdField_c_of_type_Boolean) {
          continue;
        }
        localObject2 = a(paramString, paramInt1, paramOlympicDPC, paramInt2);
        paramOlympicDPC = (Bitmap)((Pair)localObject2).second;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PortalManager", 2, "decodeBitmap OOM|path:" + paramString);
        paramInt2 = 0;
        k = 1;
        continue;
        ((BitmapFactory.Options)localObject4).inSampleSize = 1;
        continue;
      }
      catch (Exception paramOlympicDPC)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PortalManager", 2, "decodeBitmap Exception:" + paramOlympicDPC.toString() + ",filePath:" + paramString);
        localObject3 = null;
        paramInt2 = 1;
        int k = 0;
        paramOlympicDPC = (OlympicDPC)localObject2;
        localObject2 = localObject3;
        continue;
        ((BitmapFactory.Options)localObject4).inPurgeable = true;
        ((BitmapFactory.Options)localObject4).inInputShareable = true;
        ((BitmapFactory.Options)localObject4).inSampleSize = 1;
        ((BitmapFactory.Options)localObject4).inPreferredConfig = Bitmap.Config.RGB_565;
        ((BitmapFactory.Options)localObject4).inDither = true;
        continue;
        if (paramInt2 != 2) {
          continue;
        }
        Object localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), paramInt1, (BitmapFactory.Options)localObject4);
        paramOlympicDPC = (OlympicDPC)localObject4;
        continue;
        paramInt1 = ((Integer)((Pair)localObject2).first).intValue();
        continue;
        if (k == 0) {
          continue;
        }
        paramInt1 = 2;
        continue;
        paramInt1 = m;
        if (paramInt2 == 0) {
          continue;
        }
        paramInt1 = 3;
        continue;
        l = paramOlympicDPC.getRowBytes() * paramOlympicDPC.getHeight() / 1024;
        continue;
        continue;
      }
      if (paramInt2 != 1) {
        continue;
      }
      localObject4 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject4);
      paramOlympicDPC = (OlympicDPC)localObject4;
      localObject1 = null;
      paramInt2 = 0;
      k = 0;
      if (localObject1 == null) {
        continue;
      }
      if (((Integer)localObject1.first).intValue() != 0) {
        continue;
      }
      paramInt1 = 1;
      if ((paramOlympicDPC == null) && (k == 0) && (paramInt2 == 0)) {}
      try
      {
        paramString = new File(paramString);
        if (paramString.exists()) {
          paramString.delete();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager", 2, "decodeBitmap| file.delete()");
        }
      }
      catch (Exception paramString)
      {
        long l;
        continue;
        Object localObject2 = null;
        paramOlympicDPC = localObject3;
        continue;
        paramOlympicDPC = null;
      }
      paramString = new Pair(Integer.valueOf(paramInt1), paramOlympicDPC);
      if (QLog.isColorLevel())
      {
        if (paramOlympicDPC != null) {
          continue;
        }
        l = 0L;
        QLog.d("PortalManager", 2, "decodeBitmap|size:" + l + "KB,errCode:" + paramInt1);
      }
      return paramString;
      ((BitmapFactory.Options)localObject4).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject4).inDither = true;
    }
  }
  
  public static Pair<String, String> a(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (paramXmlPullParser == null) {
      return new Pair("", "");
    }
    int k = paramXmlPullParser.next();
    Object localObject2 = "";
    Object localObject1 = "";
    String str;
    if (k != 1)
    {
      str = paramXmlPullParser.getName();
      if ((k != 3) || (!str.equalsIgnoreCase(paramString))) {}
    }
    else
    {
      return new Pair(localObject1, localObject2);
    }
    Object localObject3 = localObject2;
    Object localObject4 = localObject1;
    if (k == 2)
    {
      if (!str.equalsIgnoreCase("url")) {
        break label124;
      }
      localObject4 = paramXmlPullParser.nextText();
      localObject3 = localObject2;
    }
    for (;;)
    {
      k = paramXmlPullParser.next();
      localObject2 = localObject3;
      localObject1 = localObject4;
      break;
      label124:
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (str.equalsIgnoreCase("md5"))
      {
        localObject3 = paramXmlPullParser.nextText();
        localObject4 = localObject1;
      }
    }
  }
  
  public static PortalManager.RedPacketConfig a(String paramString, int paramInt1, int paramInt2, ArrayList<Integer> paramArrayList)
  {
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    PortalManager.RedPacketConfig localRedPacketConfig = new PortalManager.RedPacketConfig();
    localRedPacketConfig.version = paramInt1;
    localRedPacketConfig.taskId = paramInt2;
    Object localObject1 = null;
    Object localObject4;
    label322:
    label338:
    label340:
    Object localObject3;
    label698:
    label860:
    PortalManager.PortalConfig localPortalConfig;
    String str;
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        paramInt1 = localXmlPullParser.getEventType();
        if (paramInt1 == 1) {
          break label3257;
        }
        Object localObject2 = localObject1;
        if (paramInt1 == 2)
        {
          localObject4 = localXmlPullParser.getName();
          if (!((String)localObject4).equalsIgnoreCase("Common")) {
            break label698;
          }
          paramInt1 = localXmlPullParser.next();
          localObject2 = localObject1;
          if (paramInt1 != 1)
          {
            localObject4 = localXmlPullParser.getName();
            if ((paramInt1 != 3) || (!((String)localObject4).equalsIgnoreCase("Common"))) {
              continue;
            }
            localObject2 = localObject1;
          }
        }
        paramInt1 = localXmlPullParser.next();
        localObject1 = localObject2;
        continue;
        localObject2 = localObject1;
        if (paramInt1 == 2)
        {
          if (((String)localObject4).equalsIgnoreCase("GrabReqInterval"))
          {
            localRedPacketConfig.grebInterval = Long.valueOf(localXmlPullParser.nextText()).longValue();
            localObject2 = localObject1;
          }
        }
        else
        {
          paramInt1 = localXmlPullParser.next();
          localObject1 = localObject2;
          continue;
        }
        if (!((String)localObject4).equalsIgnoreCase("ReportActiveInterval")) {
          break label340;
        }
        localRedPacketConfig.reportActiveInterval = Long.valueOf(localXmlPullParser.nextText()).longValue();
        localObject2 = localObject1;
        continue;
        if (!QLog.isColorLevel()) {
          break label338;
        }
      }
      catch (Exception localException)
      {
        localObject1 = null;
        paramArrayList = (ArrayList<Integer>)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e("PortalManager", 2, "parseConfig " + paramString, localException);
          paramArrayList = (ArrayList<Integer>)localObject1;
        }
      }
      localObject1 = new StringBuilder().append("parseConfig, ");
      if (paramArrayList == null) {
        break label3667;
      }
      paramString = paramArrayList.toString();
      QLog.d("PortalManager", 2, paramString);
      return paramArrayList;
      if (((String)localObject4).equalsIgnoreCase("ReportNormalInterval"))
      {
        localRedPacketConfig.reportNormalInterval = Long.valueOf(localXmlPullParser.nextText()).longValue();
        localObject3 = localObject1;
      }
      else if (((String)localObject4).equalsIgnoreCase("ShareTimes"))
      {
        localRedPacketConfig.shareBaseLine = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        localObject3 = localObject1;
      }
      else if (((String)localObject4).equalsIgnoreCase("ComboNumber"))
      {
        if (localRedPacketConfig.comboNumberConfigs == null) {
          localRedPacketConfig.comboNumberConfigs = new ArrayList();
        }
        localObject3 = new PortalManager.ComboNumber();
        localRedPacketConfig.comboNumberConfigs.add(localObject3);
      }
      else if (((String)localObject4).equalsIgnoreCase("Number"))
      {
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          ((PortalManager.ComboNumber)localObject1).number = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          localObject3 = localObject1;
        }
      }
      else if (((String)localObject4).equalsIgnoreCase("NumberImage"))
      {
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          localObject3 = a(localXmlPullParser, (String)localObject4);
          ((PortalManager.ComboNumber)localObject1).numberImageUrl = ((String)((Pair)localObject3).first);
          ((PortalManager.ComboNumber)localObject1).numberImageMD5 = ((String)((Pair)localObject3).second);
          localObject3 = localObject1;
        }
      }
      else
      {
        localObject3 = localObject1;
        if (((String)localObject4).equalsIgnoreCase("FlowerImage"))
        {
          localObject3 = localObject1;
          if (localObject1 != null)
          {
            localObject4 = a(localXmlPullParser, (String)localObject4);
            if (TextUtils.isEmpty(((PortalManager.ComboNumber)localObject1).flowerImageUrl))
            {
              ((PortalManager.ComboNumber)localObject1).flowerImageUrl = ((String)((Pair)localObject4).first);
              ((PortalManager.ComboNumber)localObject1).flowerImageMD5 = ((String)((Pair)localObject4).second);
              localObject3 = localObject1;
            }
            else
            {
              localObject3 = localObject1;
              if (TextUtils.isEmpty(((PortalManager.ComboNumber)localObject1).flowerImage2Url))
              {
                ((PortalManager.ComboNumber)localObject1).flowerImage2Url = ((String)((Pair)localObject4).first);
                ((PortalManager.ComboNumber)localObject1).flowerImage2MD5 = ((String)((Pair)localObject4).second);
                localObject3 = localObject1;
                continue;
                if (((String)localObject4).equalsIgnoreCase("ConfigId"))
                {
                  localRedPacketConfig.id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                  localObject3 = localObject1;
                }
                else if (((String)localObject4).equalsIgnoreCase("BBanner"))
                {
                  localObject4 = new PortalManager.BannerConfig(null);
                  paramInt1 = localXmlPullParser.next();
                  localObject3 = localObject1;
                  if (paramInt1 != 1)
                  {
                    localObject3 = localXmlPullParser.getName();
                    if ((paramInt1 == 3) && (((String)localObject3).equalsIgnoreCase("BBanner")))
                    {
                      localRedPacketConfig.bannerConfigs.add(localObject4);
                      localObject3 = localObject1;
                    }
                    else
                    {
                      if (paramInt1 == 2)
                      {
                        if (!((String)localObject3).equalsIgnoreCase("Id")) {
                          break label860;
                        }
                        ((PortalManager.BannerConfig)localObject4).id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                      }
                      for (;;)
                      {
                        paramInt1 = localXmlPullParser.next();
                        break;
                        if (((String)localObject3).equalsIgnoreCase("Begin"))
                        {
                          ((PortalManager.BannerConfig)localObject4).uiBegin = a(localXmlPullParser.nextText());
                        }
                        else if (((String)localObject3).equalsIgnoreCase("End"))
                        {
                          ((PortalManager.BannerConfig)localObject4).uiEnd = a(localXmlPullParser.nextText());
                        }
                        else if (((String)localObject3).equalsIgnoreCase("Image"))
                        {
                          localObject3 = a(localXmlPullParser, (String)localObject3);
                          ((PortalManager.BannerConfig)localObject4).bannerImg = ((String)((Pair)localObject3).first);
                          ((PortalManager.BannerConfig)localObject4).bannarMd5 = ((String)((Pair)localObject3).second);
                        }
                        else if (((String)localObject3).equalsIgnoreCase("JumpH5"))
                        {
                          ((PortalManager.BannerConfig)localObject4).jumpUrl = localXmlPullParser.nextText();
                        }
                      }
                    }
                  }
                }
                else
                {
                  localObject3 = localObject1;
                  if (((String)localObject4).equalsIgnoreCase("Activity"))
                  {
                    localPortalConfig = new PortalManager.PortalConfig();
                    paramInt1 = localXmlPullParser.next();
                    localObject3 = localObject1;
                    if (paramInt1 != 1)
                    {
                      str = localXmlPullParser.getName();
                      if ((paramInt1 != 3) || (!str.equalsIgnoreCase("Activity"))) {
                        break;
                      }
                      if (localPortalConfig.realEnd >= localPortalConfig.realBegin)
                      {
                        localRedPacketConfig.portalConfigs.add(localPortalConfig);
                        localObject3 = localObject1;
                      }
                      else
                      {
                        localObject3 = localObject1;
                        if (QLog.isColorLevel())
                        {
                          QLog.d("PortalManager", 2, "parseConfig" + localPortalConfig.realBegin + ", " + localPortalConfig.realEnd);
                          localObject3 = localObject1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (paramInt1 == 2)
    {
      if (!str.equalsIgnoreCase("Id")) {
        break label1198;
      }
      localPortalConfig.id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
    }
    label1198:
    label1767:
    label2156:
    label2678:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            paramInt1 = localXmlPullParser.next();
            break;
            if (str.equalsIgnoreCase("Type"))
            {
              localPortalConfig.type = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            }
            else if (str.equalsIgnoreCase("Mode"))
            {
              localPortalConfig.mode = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            }
            else
            {
              long l;
              if (str.equalsIgnoreCase("BeginTime"))
              {
                l = a(localXmlPullParser.nextText());
                localPortalConfig.realBegin = l;
                localPortalConfig.uiBegin = l;
              }
              else if (str.equalsIgnoreCase("EndTime"))
              {
                l = a(localXmlPullParser.nextText());
                localPortalConfig.realEnd = l;
                localPortalConfig.uiEnd = l;
              }
              else if (str.equalsIgnoreCase("BackGroundImage"))
              {
                localObject3 = a(localXmlPullParser, str);
                localPortalConfig.bgImg = ((String)((Pair)localObject3).first);
                localPortalConfig.bgMd5 = ((String)((Pair)localObject3).second);
              }
              else if (str.equalsIgnoreCase("activityTime"))
              {
                localPortalConfig.rightMsg = localXmlPullParser.nextText();
              }
              else if (str.equalsIgnoreCase("scrollTime"))
              {
                localPortalConfig.scrollTime = (Integer.parseInt(localXmlPullParser.nextText()) * 1000);
              }
              else if (str.equalsIgnoreCase("Timer"))
              {
                localPortalConfig.countTime = (Integer.parseInt(localXmlPullParser.nextText()) * 1000);
              }
              else if (str.equalsIgnoreCase("GrabWording"))
              {
                localPortalConfig.grabMsg = localXmlPullParser.nextText();
              }
              else if (str.equalsIgnoreCase("NoRPWording"))
              {
                localPortalConfig.emptyMsg = localXmlPullParser.nextText();
              }
              else if (str.equalsIgnoreCase("LeftCloudImage"))
              {
                localObject3 = a(localXmlPullParser, str);
                localPortalConfig.leftCloudImageUrl = ((String)((Pair)localObject3).first);
                localPortalConfig.leftCloudImageMD5 = ((String)((Pair)localObject3).second);
              }
              else if (str.equalsIgnoreCase("RightCloudImage"))
              {
                localObject3 = a(localXmlPullParser, str);
                localPortalConfig.rightCloudImageURL = ((String)((Pair)localObject3).first);
                localPortalConfig.rightCloudImageMD5 = ((String)((Pair)localObject3).second);
              }
              else if (str.equalsIgnoreCase("Logo"))
              {
                localObject3 = new PortalManager.LogoConfig();
                localPortalConfig.logoList.add(localObject3);
                paramInt1 = localXmlPullParser.next();
                if (paramInt1 != 1)
                {
                  localObject4 = localXmlPullParser.getName();
                  if ((paramInt1 == 3) && (((String)localObject4).equalsIgnoreCase(str))) {
                    continue;
                  }
                  if (paramInt1 == 2)
                  {
                    if (!((String)localObject4).equalsIgnoreCase("LogoImage")) {
                      break label1767;
                    }
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((PortalManager.LogoConfig)localObject3).logoImageUrl = ((String)((Pair)localObject4).first);
                    ((PortalManager.LogoConfig)localObject3).logoImageMD5 = ((String)((Pair)localObject4).second);
                  }
                }
                for (;;)
                {
                  paramInt1 = localXmlPullParser.next();
                  break label1676;
                  break;
                  if (((String)localObject4).equalsIgnoreCase("logoId"))
                  {
                    ((PortalManager.LogoConfig)localObject3).logoId = Integer.parseInt(localXmlPullParser.nextText());
                  }
                  else if (((String)localObject4).equalsIgnoreCase("NameImage"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((PortalManager.LogoConfig)localObject3).nameUrl = ((String)((Pair)localObject4).first);
                    ((PortalManager.LogoConfig)localObject3).nameMD5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("GreetImage"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((PortalManager.LogoConfig)localObject3).greetImageUrl = ((String)((Pair)localObject4).first);
                    ((PortalManager.LogoConfig)localObject3).greetImageMD5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("padantImage"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((PortalManager.LogoConfig)localObject3).padantImageUrl = ((String)((Pair)localObject4).first);
                    ((PortalManager.LogoConfig)localObject3).padantImageMD5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("relationCompanyLogo"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((PortalManager.LogoConfig)localObject3).relationCompanyLogoUrl = ((String)((Pair)localObject4).first);
                    ((PortalManager.LogoConfig)localObject3).relationCompanyLogoMD5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("relationCompanyNameImage"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((PortalManager.LogoConfig)localObject3).relationCompanyNameUrl = ((String)((Pair)localObject4).first);
                    ((PortalManager.LogoConfig)localObject3).relationCompanyNameMD5 = ((String)((Pair)localObject4).second);
                  }
                }
              }
              else if (str.equalsIgnoreCase("Award"))
              {
                localObject3 = new PortalManager.AwardConfig();
                localPortalConfig.awardConfigList.add(localObject3);
                paramInt1 = localXmlPullParser.next();
                if (paramInt1 != 1)
                {
                  localObject4 = localXmlPullParser.getName();
                  if ((paramInt1 == 3) && (((String)localObject4).equalsIgnoreCase(str))) {
                    continue;
                  }
                  if (paramInt1 == 2)
                  {
                    if (!((String)localObject4).equalsIgnoreCase("AwardId")) {
                      break label2156;
                    }
                    ((PortalManager.AwardConfig)localObject3).awardId = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                  }
                }
                for (;;)
                {
                  paramInt1 = localXmlPullParser.next();
                  break label2082;
                  break;
                  if (((String)localObject4).equalsIgnoreCase("logoId"))
                  {
                    ((PortalManager.AwardConfig)localObject3).logoId = Integer.parseInt(localXmlPullParser.nextText());
                  }
                  else if (((String)localObject4).equalsIgnoreCase("AwardLogoType"))
                  {
                    ((PortalManager.AwardConfig)localObject3).awardType = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                  }
                  else if (((String)localObject4).equalsIgnoreCase("AwardLogo1Image"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((PortalManager.AwardConfig)localObject3).awardImg = ((String)((Pair)localObject4).first);
                    ((PortalManager.AwardConfig)localObject3).awardMd5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("AwardLogo2Image"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((PortalManager.AwardConfig)localObject3).starImg = ((String)((Pair)localObject4).first);
                    ((PortalManager.AwardConfig)localObject3).starMd5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("AwardLogoBGImage"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((PortalManager.AwardConfig)localObject3).ctfBgImg = ((String)((Pair)localObject4).first);
                    ((PortalManager.AwardConfig)localObject3).ctfBgMd5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("Grettings"))
                  {
                    ((PortalManager.AwardConfig)localObject3).awardMsg = localXmlPullParser.nextText();
                  }
                  else if (((String)localObject4).equalsIgnoreCase("AwardName"))
                  {
                    ((PortalManager.AwardConfig)localObject3).awardTitle = localXmlPullParser.nextText();
                  }
                  else if (((String)localObject4).equalsIgnoreCase("AddWording"))
                  {
                    ((PortalManager.AwardConfig)localObject3).addMsg = localXmlPullParser.nextText();
                  }
                  else if (((String)localObject4).equalsIgnoreCase("PublicId"))
                  {
                    ((PortalManager.AwardConfig)localObject3).publicId = localXmlPullParser.nextText();
                  }
                  else if (((String)localObject4).equalsIgnoreCase("showPublic"))
                  {
                    ((PortalManager.AwardConfig)localObject3).showPublic = Integer.parseInt(localXmlPullParser.nextText());
                  }
                  else if (((String)localObject4).equalsIgnoreCase("PublicWording"))
                  {
                    ((PortalManager.AwardConfig)localObject3).publicWording = localXmlPullParser.nextText();
                  }
                }
              }
              else if (str.equalsIgnoreCase("NextActTime"))
              {
                localPortalConfig.nextActTime = localXmlPullParser.nextText();
              }
              else if (str.equalsIgnoreCase("ActEndWording"))
              {
                localPortalConfig.actEndWording = localXmlPullParser.nextText();
              }
              else if (str.equalsIgnoreCase("TipWording"))
              {
                localPortalConfig.countDownTips = localXmlPullParser.nextText();
              }
              else if (str.equalsIgnoreCase("StarLuckytype"))
              {
                localPortalConfig.starLucytype = Integer.parseInt(localXmlPullParser.nextText());
              }
              else
              {
                if (!str.equalsIgnoreCase("StarNoLuckytype")) {
                  break label2659;
                }
                localPortalConfig.starNoLucyType = Integer.parseInt(localXmlPullParser.nextText());
              }
            }
          }
          if (!str.equalsIgnoreCase("sharePhoto")) {
            break label3006;
          }
          paramInt1 = localXmlPullParser.next();
          if (paramInt1 == 1) {
            break label2765;
          }
          localObject3 = localXmlPullParser.getName();
        } while ((paramInt1 == 3) && (((String)localObject3).equalsIgnoreCase(str)));
        if (paramInt1 == 2)
        {
          if (!((String)localObject3).equalsIgnoreCase("summary")) {
            break label2767;
          }
          localObject4 = localXmlPullParser.nextText();
          localObject3 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject3 = "";
          }
          localPortalConfig.summaryForStar = ((String)localObject3);
        }
        for (;;)
        {
          paramInt1 = localXmlPullParser.next();
          break label2678;
          break;
          if (((String)localObject3).equalsIgnoreCase("structMsgTitle"))
          {
            localObject4 = localXmlPullParser.nextText();
            localObject3 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject3 = "";
            }
            localPortalConfig.structMsgTitleForStar = ((String)localObject3);
          }
          else if (((String)localObject3).equalsIgnoreCase("structMsgContent"))
          {
            localObject4 = localXmlPullParser.nextText();
            localObject3 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject3 = "";
            }
            localPortalConfig.structMsgContentForStar = ((String)localObject3);
          }
          else if (((String)localObject3).equalsIgnoreCase("starPhoto"))
          {
            localObject3 = a(localXmlPullParser, (String)localObject3);
            localPortalConfig.shareStarImageUrl = ((String)((Pair)localObject3).first);
            localPortalConfig.shareStarImageMD5 = ((String)((Pair)localObject3).second);
          }
          else if (((String)localObject3).equalsIgnoreCase("ShareWording"))
          {
            localObject4 = localXmlPullParser.nextText();
            localObject3 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject3 = "";
            }
            localPortalConfig.shareWording = ((String)localObject3);
          }
          else if (((String)localObject3).equalsIgnoreCase("starGuiderPhoto"))
          {
            localObject3 = a(localXmlPullParser, (String)localObject3);
            localPortalConfig.starGuiderPhotoURL = ((String)((Pair)localObject3).first);
            localPortalConfig.starGuiderPhotoMD5 = ((String)((Pair)localObject3).second);
          }
        }
      } while (!str.equalsIgnoreCase("shareScore"));
      paramInt1 = localXmlPullParser.next();
      if (paramInt1 == 1) {
        break label3112;
      }
      localObject3 = localXmlPullParser.getName();
    } while ((paramInt1 == 3) && (((String)localObject3).equalsIgnoreCase(str)));
    label1676:
    label2082:
    label2659:
    if (paramInt1 == 2)
    {
      if (!((String)localObject3).equalsIgnoreCase("summary")) {
        break label3114;
      }
      localObject4 = localXmlPullParser.nextText();
      localObject3 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject3 = "";
      }
      localPortalConfig.summaryForScore = ((String)localObject3);
    }
    for (;;)
    {
      label2765:
      label2767:
      label3025:
      paramInt1 = localXmlPullParser.next();
      label3006:
      break label3025;
      label3112:
      break;
      label3114:
      if (((String)localObject3).equalsIgnoreCase("structMsgTitle"))
      {
        localObject4 = localXmlPullParser.nextText();
        localObject3 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject3 = "";
        }
        localPortalConfig.structMsgTitleForScore = ((String)localObject3);
      }
      else if (((String)localObject3).equalsIgnoreCase("structMsgContent"))
      {
        localObject4 = localXmlPullParser.nextText();
        localObject3 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject3 = "";
        }
        localPortalConfig.structMsgContentForScore = ((String)localObject3);
      }
      else if (((String)localObject3).equalsIgnoreCase("shareIcon"))
      {
        localObject3 = a(localXmlPullParser, (String)localObject3);
        localPortalConfig.shareImageUrl = ((String)((Pair)localObject3).first);
        localPortalConfig.shareImageMD5 = ((String)((Pair)localObject3).second);
      }
    }
    label3257:
    paramInt1 = 0;
    int m = localRedPacketConfig.portalConfigs.size();
    label3278:
    int k;
    if (paramArrayList != null)
    {
      paramInt2 = paramArrayList.size();
      if ((paramInt2 != 0) && (m > 0))
      {
        Collections.sort(localRedPacketConfig.portalConfigs, jdField_a_of_type_JavaUtilComparator);
        localObject1 = (PortalManager.PortalConfig)localRedPacketConfig.portalConfigs.get(0);
        if (((PortalManager.PortalConfig)localObject1).type != 2) {
          break label3677;
        }
        ((PortalManager.PortalConfig)localObject1).uiBegin = (((PortalManager.PortalConfig)localObject1).realBegin + ((Integer)paramArrayList.get(0 % paramInt2)).intValue());
        paramInt1 = 1;
        break label3677;
        label3351:
        if (k < m)
        {
          localObject3 = (PortalManager.PortalConfig)localRedPacketConfig.portalConfigs.get(k);
          if (((PortalManager.PortalConfig)localObject3).type != 2) {
            break label3674;
          }
          ((PortalManager.PortalConfig)localObject3).uiBegin = (((PortalManager.PortalConfig)localObject3).realBegin + ((Integer)paramArrayList.get(paramInt1 % paramInt2)).intValue() * 1000);
          if ((localObject1 == null) || (((PortalManager.PortalConfig)localObject1).type != 1) || (((PortalManager.PortalConfig)localObject1).realEnd + 2000L < ((PortalManager.PortalConfig)localObject3).realBegin)) {
            break label3683;
          }
          ((PortalManager.PortalConfig)localObject1).uiEnd = (((PortalManager.PortalConfig)localObject1).realEnd + ((Integer)paramArrayList.get(paramInt1 % paramInt2)).intValue() * 1000);
          break label3683;
        }
      }
      Collections.sort(localRedPacketConfig.portalConfigs, jdField_a_of_type_JavaUtilComparator);
      paramInt1 = localRedPacketConfig.bannerConfigs.size() - 1;
    }
    for (;;)
    {
      if (paramInt1 >= 0)
      {
        localObject1 = (PortalManager.BannerConfig)localRedPacketConfig.bannerConfigs.get(paramInt1);
        localObject3 = localRedPacketConfig.portalConfigs.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (PortalManager.PortalConfig)((Iterator)localObject3).next();
          if ((((PortalManager.BannerConfig)localObject1).uiBegin >= ((PortalManager.PortalConfig)localObject4).realBegin) && (((PortalManager.BannerConfig)localObject1).uiBegin < ((PortalManager.PortalConfig)localObject4).realEnd))
          {
            if (((PortalManager.BannerConfig)localObject1).uiBegin != ((PortalManager.PortalConfig)localObject4).realBegin) {
              break;
            }
            ((PortalManager.BannerConfig)localObject1).uiBegin = ((PortalManager.PortalConfig)localObject4).uiBegin;
            break;
          }
        } while (((PortalManager.PortalConfig)localObject4).uiBegin <= ((PortalManager.BannerConfig)localObject1).uiBegin);
      }
      else
      {
        Collections.sort(localRedPacketConfig.bannerConfigs, jdField_a_of_type_JavaUtilComparator);
        if (QLog.isColorLevel()) {
          a(localRedPacketConfig, "parseConfig, " + paramArrayList);
        }
        paramArrayList = localRedPacketConfig;
        break;
        label3667:
        paramString = "null";
        break label322;
        label3674:
        break label3687;
        label3677:
        k = 1;
        break label3351;
        label3683:
        paramInt1 += 1;
        label3687:
        k += 1;
        localObject1 = localObject3;
        break label3351;
        paramInt2 = 0;
        break label3278;
      }
      paramInt1 -= 1;
    }
  }
  
  private String a()
  {
    return new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "red_packet_config2017_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).getAbsolutePath();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    localObject = paramString1;
    if (TextUtils.isEmpty(paramString1)) {}
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("errorCode", paramInt3);
      if (!TextUtils.isEmpty(paramString2)) {
        ((JSONObject)localObject).put("errorMsg", paramString2);
      }
      localObject = ((JSONObject)localObject).toString();
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
        localObject = paramString1;
      }
    }
    a(paramInt1, (String)localObject, paramInt2);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((!QLog.isColorLevel()) || (paramInt1 == 1009)) {}
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        localObject = "get head returned , key = " + ((JSONObject)localObject).getString("key");
        QLog.d("PortalManager", 2, "sendBroadcastRespData, " + paramInt1 + ", " + paramInt2 + ", " + (String)localObject);
        localObject = new Intent("com.tencent.portal.resp.action");
        ((Intent)localObject).putExtra("portal_type_key", paramInt1);
        Bundle localBundle = new Bundle();
        localBundle.putByteArray("bc_data", PortalUtils.a(paramString));
        ((Intent)localObject).putExtras(localBundle);
        if (paramInt2 > 0) {
          ((Intent)localObject).putExtra("bc_seq", paramInt2);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str = paramString;
        continue;
      }
      String str = paramString;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PortalManager", 2, "downLoad, " + paramInt + ", " + paramString1 + ", " + paramString2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + jdField_a_of_type_JavaLangString;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = paramString1;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = (str + paramString2);
    localHttpNetReq.mPrioty = 2;
    localHttpNetReq.setUserData(new String[] { String.valueOf(paramInt), paramString2 });
    localHttpNetReq.mSupportBreakResume = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.sendReq(localHttpNetReq);
  }
  
  private void a(long paramLong)
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
    if (localObject3 == null) {
      return;
    }
    long l2 = paramLong;
    if (f > 0L) {
      l2 = f + i * (paramLong - g);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(100);
    ArrayList localArrayList = ((PortalManager.RedPacketConfig)localObject3).bannerConfigs;
    jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig.uiBegin = l2;
    PortalManager.PortalConfig localPortalConfig = null;
    int k = Collections.binarySearch(localArrayList, jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig, jdField_a_of_type_JavaUtilComparator);
    Object localObject1;
    if (k >= 0)
    {
      k += 1;
      if ((k <= 0) || (k > localArrayList.size())) {
        break label869;
      }
      localObject1 = (PortalManager.BannerConfig)localArrayList.get(k - 1);
      if (((PortalManager.BannerConfig)localObject1).uiEnd >= l2) {
        break label866;
      }
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = localPortalConfig;
      if (k < localArrayList.size())
      {
        localObject2 = localPortalConfig;
        if (k >= 0) {
          localObject2 = (PortalManager.BannerConfig)localArrayList.get(k);
        }
      }
      localObject3 = ((PortalManager.RedPacketConfig)localObject3).portalConfigs;
      k = Collections.binarySearch((List)localObject3, jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig, jdField_a_of_type_JavaUtilComparator);
      if (k >= 0)
      {
        k += 1;
        label184:
        if ((k <= 0) || (k > ((ArrayList)localObject3).size())) {
          break label860;
        }
        localPortalConfig = (PortalManager.PortalConfig)((ArrayList)localObject3).get(k - 1);
        if (localPortalConfig.uiEnd >= l2) {
          break label857;
        }
        localPortalConfig = null;
      }
      for (;;)
      {
        if ((k < ((ArrayList)localObject3).size()) && (k >= 0)) {}
        label291:
        label558:
        label587:
        for (localObject3 = (PortalManager.PortalConfig)((ArrayList)localObject3).get(k);; localObject3 = null)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig = ((PortalManager.BannerConfig)localObject1);
          this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig = ((PortalManager.BannerConfig)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig = localPortalConfig;
          this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig = ((PortalManager.PortalConfig)localObject3);
          paramLong = 9223372036854775807L;
          long l1;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
          {
            paramLong = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.uiEnd;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
              break label778;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd <= l2) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd >= paramLong)) {
              break label735;
            }
            l1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd;
            label332:
            paramLong = l1;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 2)
            {
              long l3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime;
              paramLong = l1;
              if (l3 >= l2)
              {
                paramLong = l1;
                if (l3 < l1)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PortalManager", 2, "updateCurrentTimer last minutes in, countTime = " + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime + ", diffTime = " + l3 + ", timeout = " + l3);
                  }
                  paramLong = l3;
                }
              }
            }
            this.j = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd;
          }
          label460:
          label848:
          for (;;)
          {
            if (paramLong != 9223372036854775807L)
            {
              if (paramLong <= l2) {
                break label808;
              }
              l1 = paramLong - l2;
              label481:
              l2 = l1;
              if (l1 > 60000L) {
                l2 = 60000L;
              }
              if (f == 0L) {
                break label841;
              }
            }
            for (l1 = 1000L;; l1 = l2)
            {
              a(true, 100, l1, null);
              if (!QLog.isColorLevel()) {
                break;
              }
              localObject1 = new StringBuilder().append("updateCurrentTimer, ");
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
              {
                k = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(k).append(", ");
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
                  break label821;
                }
                k = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(k).append(", ");
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label826;
                }
                k = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
                label616:
                localObject1 = ((StringBuilder)localObject1).append(k).append(", ");
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label831;
                }
                k = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(k).append(", ").append(paramLong).append(", ");
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label836;
                }
              }
              for (k = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag;; k = -1)
              {
                QLog.d("PortalManager", 2, k);
                return;
                k = -k - 1;
                break;
                k = -k - 1;
                break label184;
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
                  break label291;
                }
                paramLong = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.uiBegin;
                break label291;
                label735:
                l1 = paramLong;
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd <= l2) {
                  break label332;
                }
                l1 = paramLong;
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd >= paramLong) {
                  break label332;
                }
                l1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd;
                break label332;
                if ((this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiBegin >= paramLong)) {
                  break label848;
                }
                paramLong = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiBegin;
                break label460;
                l1 = 60000L;
                break label481;
                k = -1;
                break label558;
                k = -1;
                break label587;
                k = -1;
                break label616;
                k = -1;
                break label645;
              }
            }
          }
        }
        label645:
        label778:
        label808:
        label821:
        label826:
        label831:
        label836:
        label841:
        label857:
        continue;
        label860:
        localPortalConfig = null;
      }
      label866:
      continue;
      label869:
      localObject1 = null;
    }
  }
  
  private void a(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    if (FileUtils.a() < 1048576.0F) {}
    do
    {
      return;
      long l = NetConnInfoCenter.getServerTimeMillis();
      Iterator localIterator1 = paramRedPacketConfig.bannerConfigs.iterator();
      Object localObject1;
      while (localIterator1.hasNext())
      {
        localObject1 = (PortalManager.BannerConfig)localIterator1.next();
        if ((((PortalManager.BannerConfig)localObject1).uiEnd > l) && (b(((PortalManager.BannerConfig)localObject1).bannarMd5))) {
          a(((PortalManager.BannerConfig)localObject1).id, ((PortalManager.BannerConfig)localObject1).bannerImg, ((PortalManager.BannerConfig)localObject1).bannarMd5);
        }
      }
      if (paramRedPacketConfig.comboNumberConfigs != null)
      {
        localIterator1 = paramRedPacketConfig.comboNumberConfigs.iterator();
        while (localIterator1.hasNext())
        {
          localObject1 = (PortalManager.ComboNumber)localIterator1.next();
          if (b(((PortalManager.ComboNumber)localObject1).flowerImageMD5)) {
            a(-101, ((PortalManager.ComboNumber)localObject1).flowerImageUrl, ((PortalManager.ComboNumber)localObject1).flowerImageMD5);
          }
          if (b(((PortalManager.ComboNumber)localObject1).numberImageMD5)) {
            a(-101, ((PortalManager.ComboNumber)localObject1).numberImageUrl, ((PortalManager.ComboNumber)localObject1).numberImageMD5);
          }
          if (b(((PortalManager.ComboNumber)localObject1).flowerImage2MD5)) {
            a(-101, ((PortalManager.ComboNumber)localObject1).flowerImage2Url, ((PortalManager.ComboNumber)localObject1).flowerImage2MD5);
          }
        }
      }
      localIterator1 = paramRedPacketConfig.portalConfigs.iterator();
      while (localIterator1.hasNext())
      {
        localObject1 = (PortalManager.PortalConfig)localIterator1.next();
        if ((localObject1 != null) && ((((PortalManager.PortalConfig)localObject1).uiEnd > l) || (((PortalManager.PortalConfig)localObject1).realEnd > l)))
        {
          if (b(((PortalManager.PortalConfig)localObject1).bgMd5)) {
            a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.PortalConfig)localObject1).bgImg, ((PortalManager.PortalConfig)localObject1).bgMd5);
          }
          if (b(((PortalManager.PortalConfig)localObject1).leftCloudImageMD5)) {
            a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.PortalConfig)localObject1).leftCloudImageUrl, ((PortalManager.PortalConfig)localObject1).leftCloudImageMD5);
          }
          if (b(((PortalManager.PortalConfig)localObject1).rightCloudImageMD5)) {
            a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.PortalConfig)localObject1).rightCloudImageURL, ((PortalManager.PortalConfig)localObject1).rightCloudImageMD5);
          }
          Iterator localIterator2;
          Object localObject2;
          if (((PortalManager.PortalConfig)localObject1).logoList != null)
          {
            localIterator2 = ((PortalManager.PortalConfig)localObject1).logoList.iterator();
            while (localIterator2.hasNext())
            {
              localObject2 = (PortalManager.LogoConfig)localIterator2.next();
              if (localObject2 != null)
              {
                if (b(((PortalManager.LogoConfig)localObject2).logoImageMD5)) {
                  a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.LogoConfig)localObject2).logoImageUrl, ((PortalManager.LogoConfig)localObject2).logoImageMD5);
                }
                if (b(((PortalManager.LogoConfig)localObject2).nameMD5)) {
                  a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.LogoConfig)localObject2).nameUrl, ((PortalManager.LogoConfig)localObject2).nameMD5);
                }
                if (b(((PortalManager.LogoConfig)localObject2).greetImageMD5)) {
                  a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.LogoConfig)localObject2).greetImageUrl, ((PortalManager.LogoConfig)localObject2).greetImageMD5);
                }
                if (b(((PortalManager.LogoConfig)localObject2).padantImageMD5)) {
                  a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.LogoConfig)localObject2).padantImageUrl, ((PortalManager.LogoConfig)localObject2).padantImageMD5);
                }
                if (b(((PortalManager.LogoConfig)localObject2).relationCompanyLogoMD5)) {
                  a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.LogoConfig)localObject2).relationCompanyLogoUrl, ((PortalManager.LogoConfig)localObject2).relationCompanyLogoMD5);
                }
                if (b(((PortalManager.LogoConfig)localObject2).relationCompanyNameMD5)) {
                  a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.LogoConfig)localObject2).relationCompanyNameUrl, ((PortalManager.LogoConfig)localObject2).relationCompanyNameMD5);
                }
              }
            }
          }
          if (((PortalManager.PortalConfig)localObject1).awardConfigList != null)
          {
            localIterator2 = ((PortalManager.PortalConfig)localObject1).awardConfigList.iterator();
            while (localIterator2.hasNext())
            {
              localObject2 = (PortalManager.AwardConfig)localIterator2.next();
              if (localObject2 != null)
              {
                if (b(((PortalManager.AwardConfig)localObject2).awardMd5)) {
                  a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.AwardConfig)localObject2).awardImg, ((PortalManager.AwardConfig)localObject2).awardMd5);
                }
                if (b(((PortalManager.AwardConfig)localObject2).starMd5)) {
                  a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.AwardConfig)localObject2).starImg, ((PortalManager.AwardConfig)localObject2).starMd5);
                }
                if (b(((PortalManager.AwardConfig)localObject2).ctfBgMd5)) {
                  a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.AwardConfig)localObject2).ctfBgImg, ((PortalManager.AwardConfig)localObject2).ctfBgMd5);
                }
              }
            }
          }
          if (b(((PortalManager.PortalConfig)localObject1).shareStarImageMD5)) {
            a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.PortalConfig)localObject1).shareStarImageUrl, ((PortalManager.PortalConfig)localObject1).shareStarImageMD5);
          }
          if (b(((PortalManager.PortalConfig)localObject1).starGuiderPhotoMD5)) {
            a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.PortalConfig)localObject1).starGuiderPhotoURL, ((PortalManager.PortalConfig)localObject1).starGuiderPhotoMD5);
          }
        }
      }
    } while (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 1800000L);
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "tryDownload needReport");
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PortalManager.2(this, paramRedPacketConfig), 60000L);
  }
  
  private static void a(PortalManager.RedPacketConfig paramRedPacketConfig, String paramString)
  {
    int m = 0;
    int i1 = paramRedPacketConfig.bannerConfigs.size();
    int n = paramRedPacketConfig.portalConfigs.size();
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(paramString).append(", ").append(paramRedPacketConfig.id).append(", ").append(paramRedPacketConfig.version);
    localStringBuilder.append('[');
    int k = 0;
    while (k < i1)
    {
      localStringBuilder.append(((PortalManager.BannerConfig)paramRedPacketConfig.bannerConfigs.get(k)).id).append(", ");
      k += 1;
    }
    localStringBuilder.append(']').append(", ").append('[');
    k = m;
    while (k < n)
    {
      localStringBuilder.append(((PortalManager.PortalConfig)paramRedPacketConfig.portalConfigs.get(k)).id).append(", ");
      k += 1;
    }
    localStringBuilder.append(']');
    QLog.d("PortalManager", 2, localStringBuilder.toString());
  }
  
  @SuppressLint({"UseSparseArrays"})
  private boolean a(PortalManager.RedPacketConfig paramRedPacketConfig1, PortalManager.RedPacketConfig paramRedPacketConfig2, boolean paramBoolean)
  {
    int m = 0;
    int n = paramRedPacketConfig1.portalConfigs.size();
    if (paramRedPacketConfig2 != null) {}
    HashMap localHashMap;
    PortalManager.PortalConfig localPortalConfig1;
    for (int k = paramRedPacketConfig2.portalConfigs.size();; k = 0)
    {
      if (paramRedPacketConfig2 != null) {
        paramRedPacketConfig1.showGesturesTime = paramRedPacketConfig2.showGesturesTime;
      }
      if ((n <= 0) || (k <= 0)) {
        break label284;
      }
      localHashMap = new HashMap(k);
      localObject = paramRedPacketConfig2.portalConfigs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localPortalConfig1 = (PortalManager.PortalConfig)((Iterator)localObject).next();
        localHashMap.put(Integer.valueOf(localPortalConfig1.id), localPortalConfig1);
      }
    }
    Object localObject = paramRedPacketConfig1.portalConfigs.iterator();
    boolean bool = false;
    PortalManager.PortalConfig localPortalConfig2;
    do
    {
      paramBoolean = bool;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localPortalConfig1 = (PortalManager.PortalConfig)((Iterator)localObject).next();
      localPortalConfig2 = (PortalManager.PortalConfig)localHashMap.get(Integer.valueOf(localPortalConfig1.id));
    } while (localPortalConfig2 == null);
    if (localPortalConfig2.useFlag != localPortalConfig1.useFlag)
    {
      localPortalConfig1.useFlag = localPortalConfig2.useFlag;
      bool = true;
    }
    if (localPortalConfig2.useTime != localPortalConfig1.useTime)
    {
      localPortalConfig1.useTime = localPortalConfig2.useTime;
      bool = true;
    }
    if (localPortalConfig2.countGrab != localPortalConfig1.countGrab)
    {
      localPortalConfig1.countGrab = localPortalConfig2.countGrab;
      bool = true;
    }
    if (localPortalConfig2.continuousRecord != localPortalConfig1.continuousRecord) {
      localPortalConfig1.continuousRecord = localPortalConfig2.continuousRecord;
    }
    for (paramBoolean = true;; paramBoolean = bool)
    {
      bool = paramBoolean;
      break;
      label284:
      paramBoolean = false;
      n = paramRedPacketConfig1.bannerConfigs.size();
      k = m;
      if (paramRedPacketConfig2 != null) {
        k = paramRedPacketConfig2.bannerConfigs.size();
      }
      bool = paramBoolean;
      if (n > 0)
      {
        bool = paramBoolean;
        if (k > 0)
        {
          localHashMap = new HashMap(k);
          paramRedPacketConfig2 = paramRedPacketConfig2.bannerConfigs.iterator();
          while (paramRedPacketConfig2.hasNext())
          {
            localObject = (PortalManager.BannerConfig)paramRedPacketConfig2.next();
            localHashMap.put(Integer.valueOf(((PortalManager.BannerConfig)localObject).id), localObject);
          }
          paramRedPacketConfig1 = paramRedPacketConfig1.bannerConfigs.iterator();
          for (;;)
          {
            bool = paramBoolean;
            if (!paramRedPacketConfig1.hasNext()) {
              break;
            }
            paramRedPacketConfig2 = (PortalManager.BannerConfig)paramRedPacketConfig1.next();
            localObject = (PortalManager.BannerConfig)localHashMap.get(Integer.valueOf(paramRedPacketConfig2.id));
            if ((localObject != null) && (((PortalManager.BannerConfig)localObject).useFlag != paramRedPacketConfig2.useFlag))
            {
              paramRedPacketConfig2.useFlag = ((PortalManager.BannerConfig)localObject).useFlag;
              paramBoolean = true;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "updateUsedFlag, " + bool);
      }
      return bool;
    }
  }
  
  private int b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 2)) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord;
  }
  
  private PortalManager.RedPacketConfig b()
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(30000));
    ((ArrayList)localObject).add(Integer.valueOf(20000));
    ((ArrayList)localObject).add(Integer.valueOf(10000));
    localObject = a("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<HappyFestival>\n    <ConfigId>113</ConfigId>\n    <Common>\n        <GrabReqInterval>2500</GrabReqInterval>\n        <ReportActiveInterval>0</ReportActiveInterval>\n        <ReportNormalInterval>180000</ReportNormalInterval>\n        <Combo>\n            <ShareTimes>1</ShareTimes>\n            <ComboNumberList>\n                <ComboNumber>\n                    <Number>8</Number>\n                    <NumberImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </NumberImage>\n                    <FlowerImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </FlowerImage>\n                    <FlowerImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </FlowerImage>\n                </ComboNumber>\n            </ComboNumberList>\n        </Combo>\n    </Common>\n    <Activity>\n        <Id>2034</Id>\n        <Type>2</Type>\n        <Mode>3</Mode>\n        <BeginTime>2020-11-10 14:00:00</BeginTime>\n        <EndTime>2020-12-11 23:30:00</EndTime>\n        <scrollTime>5</scrollTime>\n        <OnActivity>\n            <Timer>30</Timer>\n            <TipWording>抢红包倒计时</TipWording>\n            <GrabWording>连刷更容易得红包！</GrabWording>\n            <NoRPWording>没中！继续刷还有机会。</NoRPWording>\n            <LogoList>\n                <Logo>\n                    <logoId>1</logoId>\n                    <LogoImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </LogoImage>\n                    <Name>随手记</Name>\n                    <NameImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </NameImage>\n                    <padantImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </padantImage>\n                </Logo>\n\n            </LogoList>\n            <NextActTime>23:40-23:59</NextActTime>\n            <AwardList>\n                <Award>\n                    <AwardId>2033</AwardId>\n                    <logoId>1</logoId>\n                    <AwardLogoType>1</AwardLogoType>\n                    <AwardLogo1Image>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </AwardLogo1Image>\n                    <AwardLogo2Image>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </AwardLogo2Image>\n                    <AwardLogoBGImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </AwardLogoBGImage>\n                    <AwardName>随手记</AwardName>\n                    <Grettings>随手记给你发红包啦</Grettings>\n                    <AddWording>随手记给你发红包啦</AddWording>\n                    <showPublic>1</showPublic>\n                    <PublicId>2137362945</PublicId>\n                    <PublicWording>关注随手记公众号</PublicWording>\n                </Award>\n\n            </AwardList>\n            <EndRefresh>\n                <Starluckytype>1</Starluckytype>\n                <StarNoluckyType>1</StarNoluckyType>\n            </EndRefresh>\n            <Share>\n                <shareScore>\n                    <summary>QQ红包开抢了！我已成功刷了%d次，谁比我厉害！</summary>\n                    <structMsgTitle>亿万红包等你来刷！</structMsgTitle>\n                    <structMsgContent>QQ刷红包，我已刷%d次，谁比我厉害！</structMsgContent>\n                    <shareIcon>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </shareIcon>\n                </shareScore>\n            </Share>\n        </OnActivity>\n    </Activity>\n\n</HappyFestival>\n", 0, 0, (ArrayList)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "getDebugRedPacketConfig  newConfig = " + localObject);
    }
    return localObject;
  }
  
  private void b(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    Object localObject1 = paramRedPacketConfig.bannerConfigs.iterator();
    boolean bool1 = true;
    int k;
    if (((Iterator)localObject1).hasNext())
    {
      if (!b(((PortalManager.BannerConfig)((Iterator)localObject1).next()).bannarMd5)) {}
      for (k = 1;; k = 0)
      {
        bool1 = k & bool1;
        break;
      }
    }
    boolean bool2 = bool1;
    Object localObject2;
    label118:
    int m;
    label132:
    int n;
    if (paramRedPacketConfig.comboNumberConfigs != null)
    {
      localObject1 = paramRedPacketConfig.comboNumberConfigs.iterator();
      bool2 = bool1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PortalManager.ComboNumber)((Iterator)localObject1).next();
        if (!b(((PortalManager.ComboNumber)localObject2).flowerImageMD5))
        {
          k = 1;
          if (b(((PortalManager.ComboNumber)localObject2).numberImageMD5)) {
            break label166;
          }
          m = 1;
          if (b(((PortalManager.ComboNumber)localObject2).flowerImage2MD5)) {
            break label171;
          }
        }
        label166:
        label171:
        for (n = 1;; n = 0)
        {
          bool1 = m & k & bool1 & n;
          break;
          k = 0;
          break label118;
          m = 0;
          break label132;
        }
      }
    }
    localObject1 = paramRedPacketConfig.portalConfigs.iterator();
    label241:
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PortalManager.PortalConfig)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        label256:
        label288:
        Object localObject4;
        label331:
        label346:
        int i1;
        label361:
        int i2;
        if (!b(((PortalManager.PortalConfig)localObject2).bgMd5))
        {
          k = 1;
          if (b(((PortalManager.PortalConfig)localObject2).leftCloudImageMD5)) {
            break label415;
          }
          m = 1;
          if (b(((PortalManager.PortalConfig)localObject2).rightCloudImageMD5)) {
            break label420;
          }
          n = 1;
          k = n & bool2 & k & m;
          if (((PortalManager.PortalConfig)localObject2).logoList == null) {
            break label455;
          }
          localObject3 = ((PortalManager.PortalConfig)localObject2).logoList.iterator();
          m = k;
          do
          {
            k = m;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject4 = (PortalManager.LogoConfig)((Iterator)localObject3).next();
          } while (localObject4 == null);
          if (b(((PortalManager.LogoConfig)localObject4).logoImageMD5)) {
            break label426;
          }
          k = 1;
          if (b(((PortalManager.LogoConfig)localObject4).nameMD5)) {
            break label431;
          }
          n = 1;
          if (b(((PortalManager.LogoConfig)localObject4).greetImageMD5)) {
            break label437;
          }
          i1 = 1;
          if (b(((PortalManager.LogoConfig)localObject4).padantImageMD5)) {
            break label443;
          }
          i2 = 1;
          label376:
          if (b(((PortalManager.LogoConfig)localObject4).relationCompanyLogoMD5)) {
            break label449;
          }
        }
        label415:
        label420:
        label426:
        label431:
        label437:
        label443:
        label449:
        for (int i3 = 1;; i3 = 0)
        {
          m = i3 & i2 & k & m & n & i1;
          break label288;
          k = 0;
          break;
          m = 0;
          break label241;
          n = 0;
          break label256;
          k = 0;
          break label331;
          n = 0;
          break label346;
          i1 = 0;
          break label361;
          i2 = 0;
          break label376;
        }
        label455:
        m = k;
        if (((PortalManager.PortalConfig)localObject2).awardConfigList != null)
        {
          localObject3 = ((PortalManager.PortalConfig)localObject2).awardConfigList.iterator();
          do
          {
            m = k;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject4 = (PortalManager.AwardConfig)((Iterator)localObject3).next();
          } while (localObject4 == null);
          if (!b(((PortalManager.AwardConfig)localObject4).awardMd5))
          {
            m = 1;
            label520:
            if (b(((PortalManager.AwardConfig)localObject4).starMd5)) {
              break label568;
            }
            n = 1;
            label535:
            if (b(((PortalManager.AwardConfig)localObject4).ctfBgMd5)) {
              break label574;
            }
          }
          label568:
          label574:
          for (i1 = 1;; i1 = 0)
          {
            k = n & m & k & i1;
            break;
            m = 0;
            break label520;
            n = 0;
            break label535;
          }
        }
        if (!b(((PortalManager.PortalConfig)localObject2).shareStarImageMD5))
        {
          k = 1;
          label594:
          if (b(((PortalManager.PortalConfig)localObject2).starGuiderPhotoMD5)) {
            break label625;
          }
        }
        label625:
        for (n = 1;; n = 0)
        {
          bool2 = k & m & n;
          break;
          k = 0;
          break label594;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "reportResCover ,resCover=" + bool2);
    }
    if (bool2) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      localObject2 = String.valueOf(paramRedPacketConfig.taskId);
      paramRedPacketConfig = String.valueOf(paramRedPacketConfig.version);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80078FA", "0X80078FA", 0, 0, (String)localObject1, (String)localObject2, paramRedPacketConfig, "");
      if (PrecoverUtils.a(this.jdField_a_of_type_AndroidContentContext, "hongbao_17_res_cover"))
      {
        PrecoverUtils.a(this.jdField_a_of_type_AndroidContentContext, "hongbao_17_res_cover");
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("config_version", paramRedPacketConfig);
        ((HashMap)localObject3).put("cover", localObject1);
        ((HashMap)localObject3).put("taskid", localObject2);
        StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "hongbao_res_precover", bool2, 0L, 0L, (HashMap)localObject3, "", false);
      }
      return;
    }
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (jdField_a_of_type_Boolean) {
      l = System.currentTimeMillis();
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(l);
    int m = ((Calendar)localObject1).get(1);
    int n = ((Calendar)localObject1).get(2);
    int i1 = ((Calendar)localObject1).get(5);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar localCalendar = Calendar.getInstance();
    localObject1 = null;
    int k = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (k < jdField_a_of_type_ArrayOfJavaLangString.length) {
        try
        {
          localObject2 = localSimpleDateFormat.parse(jdField_a_of_type_ArrayOfJavaLangString[k]);
          if (localObject2 == null)
          {
            k += 1;
            localObject1 = localObject2;
          }
        }
        catch (ParseException localParseException)
        {
          int i2;
          int i3;
          int i4;
          do
          {
            Object localObject2;
            for (;;)
            {
              localObject2 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.e("PortalManager", 2, "isForbidAlert", localParseException);
                localObject2 = localObject1;
              }
            }
            localCalendar.clear();
            localCalendar.setTime((Date)localObject2);
            i2 = localCalendar.get(1);
            i3 = localCalendar.get(2);
            i4 = localCalendar.get(5);
          } while ((m != i2) || (n + 1 != i3 + 1) || (i1 != i4));
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "isForbidAlert, current=" + l + ", bingo=" + bool1 + ", DEBUG_GRAB=" + jdField_a_of_type_Boolean);
    }
    return bool1;
  }
  
  private boolean b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {}
    String str;
    do
    {
      return false;
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + jdField_a_of_type_JavaLangString;
    } while (new File(str + paramString).exists());
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
    return true;
  }
  
  private void d()
  {
    boolean bool2 = true;
    int k;
    int m;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC = new OlympicDPC();
      k = (int)(DeviceInfoUtil.a() / 1024L / 1024L);
      m = ViewUtils.a();
      str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.olympic_act_config.name());
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_JavaLangString = str;
    }
    try
    {
      if (str.length() > 0)
      {
        String[] arrayOfString = str.split("\\|");
        if (arrayOfString.length >= 9)
        {
          if (k <= Integer.valueOf(arrayOfString[0]).intValue()) {}
          for (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true;; this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true)
          {
            if (Integer.valueOf(arrayOfString[3]).intValue() == 1) {
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Boolean = true;
            }
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[4]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Int = Integer.valueOf(arrayOfString[5]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Int = Integer.valueOf(arrayOfString[6]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Int = Integer.valueOf(arrayOfString[7]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_e_of_type_Int = Integer.valueOf(arrayOfString[8]).intValue();
            bool1 = false;
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_Boolean = bool1;
            if (bool1)
            {
              if (k > 512) {
                break label497;
              }
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_Int = 0;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Int = 3;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Int = 1000;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Int = 1;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_e_of_type_Int = 1;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Int != 1) {
              break label533;
            }
            OlympicUtil.a(bool2);
            if (QLog.isColorLevel()) {
              QLog.d("PortalManager", 2, "loadDPCConfig|featureValue:" + str + ",systemTotalMem:" + k + ",screenWidth:" + m + ",isUseDefault:" + bool1 + ",dpc:" + this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.toString());
            }
            return;
            if (m > Integer.valueOf(arrayOfString[1]).intValue()) {
              break;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager", 2, "loadDPCConfig Exception:" + localException.toString());
        }
        boolean bool1 = true;
        continue;
        label533:
        if (m <= Integer.valueOf(localException[2]).intValue())
        {
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Boolean = true;
          continue;
          label497:
          if (m <= 480)
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true;
          }
          else if (m <= 720)
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Boolean = true;
            continue;
            bool2 = false;
          }
        }
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
    }
    return -1;
  }
  
  public PortalManager.PortalConfig a(long paramLong)
  {
    long l2 = paramLong;
    long l1;
    int k;
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null)
    {
      l1 = paramLong;
      if (paramLong == -1L)
      {
        paramLong = NetConnInfoCenter.getServerTimeMillis();
        l1 = paramLong;
        if (f > 0L) {
          l1 = f + i * (paramLong - g);
        }
      }
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs;
      int m = localArrayList.size();
      k = 0;
      l2 = l1;
      if (k < m)
      {
        localObject2 = (PortalManager.PortalConfig)localArrayList.get(k);
        localObject1 = localObject2;
        l2 = l1;
        if (((PortalManager.PortalConfig)localObject2).id != l1)
        {
          if ((((PortalManager.PortalConfig)localObject2).realBegin > l1) || (((PortalManager.PortalConfig)localObject2).realEnd <= l1)) {
            break label202;
          }
          l2 = l1;
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      label140:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("findRealPortal, ").append(l2).append(", ");
        if (localObject1 == null) {
          break label239;
        }
      }
      label202:
      label239:
      for (k = localObject1.id;; k = -1)
      {
        QLog.d("PortalManager", 2, k);
        return localObject1;
        if ((l1 > 536870911L) && (((PortalManager.PortalConfig)localObject2).realBegin > l1))
        {
          localObject1 = null;
          l2 = l1;
          break label140;
        }
        k += 1;
        break;
      }
      localObject1 = null;
    }
  }
  
  /* Error */
  protected PortalManager.RedPacketConfig a()
  {
    // Byte code:
    //   0: new 76	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 204	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8: invokevirtual 1085	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: new 71	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 1087
    //   21: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 196	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   28: invokevirtual 1090	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   31: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 1093	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 519	java/io/File:exists	()Z
    //   45: ifeq +403 -> 448
    //   48: new 1493	java/io/FileInputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 1496	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore_1
    //   57: new 1498	java/io/ObjectInputStream
    //   60: dup
    //   61: new 1500	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 1503	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: invokespecial 1504	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore 6
    //   74: aload_1
    //   75: astore_3
    //   76: aload 6
    //   78: astore_2
    //   79: aload 6
    //   81: invokevirtual 1507	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   84: checkcast 600	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   87: astore 4
    //   89: aload 6
    //   91: ifnull +8 -> 99
    //   94: aload 6
    //   96: invokevirtual 1510	java/io/ObjectInputStream:close	()V
    //   99: aload_1
    //   100: ifnull +353 -> 453
    //   103: aload_1
    //   104: invokevirtual 1511	java/io/FileInputStream:close	()V
    //   107: aload 4
    //   109: astore_1
    //   110: aload_1
    //   111: astore_2
    //   112: aload_1
    //   113: ifnonnull +16 -> 129
    //   116: new 600	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   119: dup
    //   120: invokespecial 601	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:<init>	()V
    //   123: pop
    //   124: aload_0
    //   125: invokespecial 1513	com/tencent/mobileqq/portal/PortalManager:b	()Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   128: astore_2
    //   129: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +41 -> 173
    //   135: new 71	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 1515
    //   145: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: astore_3
    //   149: aload_2
    //   150: ifnull +254 -> 404
    //   153: aload_2
    //   154: invokevirtual 650	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:toString	()Ljava/lang/String;
    //   157: astore_1
    //   158: ldc_w 268
    //   161: iconst_2
    //   162: aload_3
    //   163: aload_1
    //   164: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 391	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_0
    //   174: getfield 1222	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig	Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   177: ifnonnull +11 -> 188
    //   180: aload_0
    //   181: iconst_1
    //   182: iconst_2
    //   183: lconst_0
    //   184: aload_2
    //   185: invokevirtual 1253	com/tencent/mobileqq/portal/PortalManager:a	(ZIJLjava/lang/Object;)V
    //   188: aload_2
    //   189: areturn
    //   190: astore_2
    //   191: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq -95 -> 99
    //   197: ldc_w 268
    //   200: iconst_2
    //   201: ldc_w 270
    //   204: aload_2
    //   205: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   208: goto -109 -> 99
    //   211: astore_1
    //   212: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +14 -> 229
    //   218: ldc_w 268
    //   221: iconst_2
    //   222: ldc_w 270
    //   225: aload_1
    //   226: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   229: aload 4
    //   231: astore_1
    //   232: goto -122 -> 110
    //   235: astore 5
    //   237: aconst_null
    //   238: astore 4
    //   240: aconst_null
    //   241: astore_1
    //   242: aload 4
    //   244: astore_3
    //   245: aload_1
    //   246: astore_2
    //   247: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +20 -> 270
    //   253: aload 4
    //   255: astore_3
    //   256: aload_1
    //   257: astore_2
    //   258: ldc_w 268
    //   261: iconst_2
    //   262: ldc_w 270
    //   265: aload 5
    //   267: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   270: aload_1
    //   271: ifnull +7 -> 278
    //   274: aload_1
    //   275: invokevirtual 1510	java/io/ObjectInputStream:close	()V
    //   278: aload 4
    //   280: ifnull +168 -> 448
    //   283: aload 4
    //   285: invokevirtual 1511	java/io/FileInputStream:close	()V
    //   288: aconst_null
    //   289: astore_1
    //   290: goto -180 -> 110
    //   293: astore_1
    //   294: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq -19 -> 278
    //   300: ldc_w 268
    //   303: iconst_2
    //   304: ldc_w 270
    //   307: aload_1
    //   308: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: goto -33 -> 278
    //   314: astore_1
    //   315: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +14 -> 332
    //   321: ldc_w 268
    //   324: iconst_2
    //   325: ldc_w 270
    //   328: aload_1
    //   329: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -224 -> 110
    //   337: astore 4
    //   339: aconst_null
    //   340: astore_1
    //   341: aconst_null
    //   342: astore_2
    //   343: aload_2
    //   344: ifnull +7 -> 351
    //   347: aload_2
    //   348: invokevirtual 1510	java/io/ObjectInputStream:close	()V
    //   351: aload_1
    //   352: ifnull +7 -> 359
    //   355: aload_1
    //   356: invokevirtual 1511	java/io/FileInputStream:close	()V
    //   359: aload 4
    //   361: athrow
    //   362: astore_2
    //   363: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq -15 -> 351
    //   369: ldc_w 268
    //   372: iconst_2
    //   373: ldc_w 270
    //   376: aload_2
    //   377: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   380: goto -29 -> 351
    //   383: astore_1
    //   384: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq -28 -> 359
    //   390: ldc_w 268
    //   393: iconst_2
    //   394: ldc_w 270
    //   397: aload_1
    //   398: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   401: goto -42 -> 359
    //   404: ldc_w 1081
    //   407: astore_1
    //   408: goto -250 -> 158
    //   411: astore 4
    //   413: aconst_null
    //   414: astore_2
    //   415: goto -72 -> 343
    //   418: astore 4
    //   420: aload_3
    //   421: astore_1
    //   422: goto -79 -> 343
    //   425: astore 5
    //   427: aconst_null
    //   428: astore_2
    //   429: aload_1
    //   430: astore 4
    //   432: aload_2
    //   433: astore_1
    //   434: goto -192 -> 242
    //   437: astore 5
    //   439: aload_1
    //   440: astore 4
    //   442: aload 6
    //   444: astore_1
    //   445: goto -203 -> 242
    //   448: aconst_null
    //   449: astore_1
    //   450: goto -340 -> 110
    //   453: aload 4
    //   455: astore_1
    //   456: goto -346 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	this	PortalManager
    //   40	124	1	localObject1	Object
    //   211	15	1	localIOException1	java.io.IOException
    //   231	59	1	localObject2	Object
    //   293	15	1	localIOException2	java.io.IOException
    //   314	15	1	localIOException3	java.io.IOException
    //   333	23	1	localObject3	Object
    //   383	15	1	localIOException4	java.io.IOException
    //   407	49	1	localObject4	Object
    //   78	111	2	localObject5	Object
    //   190	15	2	localIOException5	java.io.IOException
    //   246	102	2	localObject6	Object
    //   362	15	2	localIOException6	java.io.IOException
    //   414	19	2	localObject7	Object
    //   75	346	3	localObject8	Object
    //   87	197	4	localRedPacketConfig	PortalManager.RedPacketConfig
    //   337	23	4	localObject9	Object
    //   411	1	4	localObject10	Object
    //   418	1	4	localObject11	Object
    //   430	24	4	localObject12	Object
    //   235	31	5	localThrowable1	Throwable
    //   425	1	5	localThrowable2	Throwable
    //   437	1	5	localThrowable3	Throwable
    //   72	371	6	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   94	99	190	java/io/IOException
    //   103	107	211	java/io/IOException
    //   48	57	235	java/lang/Throwable
    //   274	278	293	java/io/IOException
    //   283	288	314	java/io/IOException
    //   48	57	337	finally
    //   347	351	362	java/io/IOException
    //   355	359	383	java/io/IOException
    //   57	74	411	finally
    //   79	89	418	finally
    //   247	253	418	finally
    //   258	270	418	finally
    //   57	74	425	java/lang/Throwable
    //   79	89	437	java/lang/Throwable
  }
  
  protected PortalManager.RedPacketConfig a(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    PortalManager.RedPacketConfig localRedPacketConfig1;
    if (QLog.isColorLevel())
    {
      if (paramRedPacketConfig == null) {
        QLog.d("PortalManager", 2, "handleNewConfig");
      }
    }
    else
    {
      PortalManager.RedPacketConfig localRedPacketConfig2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
      localRedPacketConfig1 = localRedPacketConfig2;
      if (localRedPacketConfig2 == null) {
        localRedPacketConfig1 = a();
      }
      if (paramRedPacketConfig == null) {
        break label126;
      }
      a(paramRedPacketConfig, localRedPacketConfig1, false);
      a(paramRedPacketConfig);
    }
    for (;;)
    {
      a(paramRedPacketConfig);
      return paramRedPacketConfig;
      QLog.d("PortalManager", 2, "handleNewConfig, " + paramRedPacketConfig.version + ", " + paramRedPacketConfig.bannerConfigs.size() + ", " + paramRedPacketConfig.portalConfigs.size());
      break;
      label126:
      paramRedPacketConfig = localRedPacketConfig1;
    }
  }
  
  public PortalManager.ResultData a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (0 == 0) {}
    for (Object localObject2 = a(paramInt2);; localObject2 = null)
    {
      if (localObject2 == null) {
        return null;
      }
      Object localObject3 = ((PortalManager.PortalConfig)localObject2).findRealAwardConfigById(paramInt3);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = ((PortalManager.PortalConfig)localObject2).findRealAwardConfigById(paramInt4);
        localObject1 = localObject2;
        if (localObject2 == null) {
          return null;
        }
      }
      localObject3 = new PortalManager.ResultData();
      switch (paramInt1)
      {
      default: 
        return null;
      }
      ((PortalManager.ResultData)localObject3).jdField_a_of_type_AndroidGraphicsBitmap = a(localObject1.awardMd5, null);
      ((PortalManager.ResultData)localObject3).jdField_a_of_type_JavaLangString = localObject1.addMsg;
      ((PortalManager.ResultData)localObject3).h = localObject1.publicId;
      ((PortalManager.ResultData)localObject3).jdField_g_of_type_JavaLangString = localObject1.publicWording;
      StringBuilder localStringBuilder = new StringBuilder().append(BaseApplicationImpl.getApplication().getFilesDir()).append(jdField_a_of_type_JavaLangString);
      if (localObject1.awardType == 2) {}
      for (localObject2 = localObject1.starMd5;; localObject2 = localObject1.awardMd5)
      {
        ((PortalManager.ResultData)localObject3).jdField_c_of_type_JavaLangString = ((String)localObject2);
        ((PortalManager.ResultData)localObject3).jdField_d_of_type_JavaLangString = (BaseApplicationImpl.getApplication().getFilesDir() + jdField_a_of_type_JavaLangString + localObject1.ctfBgMd5);
        ((PortalManager.ResultData)localObject3).f = localObject1.awardMsg;
        ((PortalManager.ResultData)localObject3).e = localObject1.awardTitle;
        ((PortalManager.ResultData)localObject3).jdField_d_of_type_Int = localObject1.awardType;
        ((PortalManager.ResultData)localObject3).jdField_g_of_type_Int = localObject1.showPublic;
        return localObject3;
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    c();
    a(true, 100, 0L, null);
    if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(16)) {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
        break label128;
      }
    }
    label128:
    for (long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime).longValue();; l = 10000L)
    {
      a(true, 16, 1000L, Long.valueOf(l));
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)) {
        QLog.d("PortalManager", 2, "setGrabTimeFinish activity id:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id + ", total count:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setStarShareFlag, ").append(paramInt1);
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
        break label101;
      }
    }
    label101:
    for (int k = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;; k = 0)
    {
      QLog.d("PortalManager", 2, k + "," + paramInt2);
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id == paramInt1))
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.starShareTypeReqState = 2;
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.starShareType = paramInt2;
      }
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "testplaySound, playSound, " + paramInt + ", " + this.jdField_a_of_type_ArrayOfInt[paramInt] + ", " + jdField_a_of_type_ArrayOfBoolean[paramInt] + ", mPlayCountDownStreamId=" + this.jdField_e_of_type_Int + ", mPlayCountDownState=" + this.jdField_b_of_type_Int);
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaSoundPool == null)
      {
        this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(this);
      }
      if (paramInt == 2)
      {
        if ((this.jdField_b_of_type_Int != 4) || (!paramBoolean))
        {
          if ((this.jdField_b_of_type_Int == 1) && (!paramBoolean)) {
            return;
          }
          this.jdField_b_of_type_Int = 1;
        }
      }
      else
      {
        k = this.jdField_a_of_type_ArrayOfInt[paramInt];
        if (k == 0)
        {
          k = this.jdField_a_of_type_AndroidMediaSoundPool.load(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), jdField_b_of_type_ArrayOfInt[paramInt], 1);
          this.jdField_a_of_type_ArrayOfInt[paramInt] = k;
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      int k;
      if (QLog.isColorLevel())
      {
        QLog.d("PortalManager", 2, "playSound, throwable=" + localThrowable.getMessage());
        localThrowable.printStackTrace();
        return;
        if (jdField_a_of_type_ArrayOfBoolean[paramInt] != 0) {
          if (paramInt == 2) {}
        }
        for (k = this.jdField_a_of_type_AndroidMediaSoundPool.play(k, 1.0F, 1.0F, 1, 0, 1.0F); QLog.isColorLevel(); k = -1)
        {
          QLog.d("PortalManager", 2, "playSound, " + paramInt + ", " + this.jdField_a_of_type_ArrayOfInt[paramInt] + ", " + jdField_a_of_type_ArrayOfBoolean[paramInt] + ", " + k + ", mPlayCountDownStreamId=" + this.jdField_e_of_type_Int);
          return;
          if (this.jdField_e_of_type_Int == 0) {
            this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.play(k, 1.0F, 1.0F, 10, -1, 1.0F);
          }
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new PortalManager.1(this, paramLong1, paramLong2, paramLong3));
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("clickBanner, ");
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
      {
        localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id);
        QLog.i("PortalManager", 2, localObject + ", " + paramBoolean);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag < 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag = 2;
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        a(null, 1, false, 0L);
      }
      if (!paramBoolean) {
        break label336;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl)) {
        break label311;
      }
      if (paramActivity == null) {
        break label268;
      }
      localObject = paramActivity;
      label144:
      localObject = new Intent((Context)localObject, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl);
      ((Intent)localObject).putExtra("hide_left_button", true);
      ((Intent)localObject).putExtra("show_right_close_button", true);
      ((Intent)localObject).putExtra("finish_animation_up_down", true);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).addFlags(67108864);
      if (paramActivity == null) {
        break label275;
      }
      paramActivity.startActivity((Intent)localObject);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077E7", "0X80077E7", 0, 0, "", "", "", "");
      return;
      localObject = "";
      break;
      label268:
      localObject = BaseApplicationImpl.sApplication;
      break label144;
      label275:
      paramActivity = BaseActivity.sTopActivity;
      if (paramActivity != null)
      {
        paramActivity.startActivity((Intent)localObject);
      }
      else
      {
        paramActivity = BaseApplicationImpl.sApplication;
        ((Intent)localObject).addFlags(268435456);
        paramActivity.startActivity((Intent)localObject);
        continue;
        label311:
        if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)) {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a();
        }
      }
    }
    label336:
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077E6", "0X80077E6", 0, 0, "", "", "", "");
  }
  
  public void a(PortalManager.PortalShower paramPortalShower, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower == null) {
      return;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    Bitmap localBitmap1 = null;
    Object localObject4 = null;
    String str1 = null;
    String str2 = null;
    Object localObject5 = null;
    paramPortalShower = null;
    int m = 0;
    int k = m;
    long l4;
    long l1;
    long l2;
    Bitmap localBitmap2;
    Bitmap localBitmap3;
    Bitmap localBitmap4;
    Object localObject3;
    if (1 == (paramInt & 0x1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.b();
        k = m;
      }
    }
    else
    {
      m = k;
      if (2 == (paramInt & 0x2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
          break label1356;
        }
        l4 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.version << 30 | this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
        l1 = paramLong;
        if (paramLong == 0L) {
          l1 = NetConnInfoCenter.getServerTimeMillis();
        }
        l2 = l1;
        if (f > 0L) {
          l2 = f + i * (l1 - g);
        }
        localBitmap2 = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.bgMd5, "hb_bg_name_path");
        localBitmap3 = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.leftCloudImageMD5, "hb_leftclound_name_path");
        localBitmap4 = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.rightCloudImageMD5, "hb_rightclound_name_path");
        paramLong = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.scrollTime;
        l1 = paramLong;
        if (paramLong == 0L) {
          l1 = 3000L;
        }
        localObject3 = localObject5;
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.size() > 0)
        {
          localObject3 = localObject5;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode == 3)
          {
            localObject5 = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList);
            localObject3 = localObject5;
            if (localObject5 != null)
            {
              Collections.shuffle((List)localObject5);
              localObject3 = localObject5;
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 1) {
          break label763;
        }
        paramLong = -1L;
        if (l2 > this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd) {
          paramLong = Math.min(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd - l2, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode != 1) {
          break label696;
        }
        paramPortalShower = (PortalManager.LogoConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
        localObject1 = a(paramPortalShower.logoImageMD5, "hb_yure_star_logo_path");
        localObject2 = a(paramPortalShower.nameMD5, "hb_yure_star_name_path");
        localBitmap1 = a(paramPortalShower.padantImageMD5, "hb_icon_path");
      }
    }
    for (;;)
    {
      label408:
      if (paramPortalShower != null) {
        localObject4 = a(paramPortalShower.greetImageMD5, null);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "refreshUi showPrepare ,countDown = " + paramLong + ",serverTime = " + l2 + ",currentPortal.uiEnd = " + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd + ",currentPortal.realEnd = " + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd);
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(l4, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode, localBitmap2, (Bitmap)localObject1, localBitmap1, localBitmap3, localBitmap4, (Bitmap)localObject4, (Bitmap)localObject2, (List)localObject3, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.rightMsg, paramLong, paramBoolean, l1);
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag < 2) && (!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a()))
      {
        this.jdField_d_of_type_Boolean = true;
        paramInt = 1;
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag = 2;
      }
      for (;;)
      {
        m = paramInt;
        for (;;)
        {
          if (m == 0) {
            break label1368;
          }
          a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
          return;
          k = m;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
            break;
          }
          k = m;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag >= 2) {
            break;
          }
          localObject3 = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.bannarMd5, "hb_banner_path");
          k = m;
          if (localObject3 == null) {
            break;
          }
          k = m;
          if (!this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a((Bitmap)localObject3, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag = 2;
          k = 1;
          break;
          label696:
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode != 2) {
            break label1376;
          }
          paramPortalShower = (PortalManager.LogoConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
          localObject1 = a(paramPortalShower.logoImageMD5, "hb_busi_logo_path");
          localObject2 = a(paramPortalShower.nameMD5, "hb_yure_busi_name_path");
          localBitmap1 = a(paramPortalShower.padantImageMD5, "hb_busi_logo_path");
          break label408;
          label763:
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 2)
          {
            String str3;
            long l3;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode == 1)
            {
              localObject2 = (PortalManager.LogoConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
              paramPortalShower = a(((PortalManager.LogoConfig)localObject2).logoImageMD5, "hb_icon_path");
              localBitmap1 = a(((PortalManager.LogoConfig)localObject2).nameMD5, "hb_name_path");
              localObject1 = a(((PortalManager.LogoConfig)localObject2).padantImageMD5, "hb_icon_path");
              localObject4 = a(((PortalManager.LogoConfig)localObject2).relationCompanyLogoMD5, "hb_busi_logo_path");
              localObject2 = a(((PortalManager.LogoConfig)localObject2).relationCompanyNameMD5, "hb_name_path");
              str1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.grabMsg;
              str2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.actEndWording;
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.nextActTime;
              str3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countDownTips;
              l3 = -1L;
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime <= 0L) {
                break label1246;
              }
              l3 = l2 - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime;
              if (l3 <= this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime)
              {
                paramLong = l3;
                if (l3 > 0L) {}
              }
              else
              {
                paramLong = 0L;
              }
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PortalManager", 2, "refreshUI  ,serverTime = " + l2 + ",currentPortal.useTime = " + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime + ",currentPortal.countTime = " + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime + ",currentPortal.realEnd = " + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd + ",countDown = " + paramLong);
              }
              this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(l4, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode, localBitmap2, paramPortalShower, (Bitmap)localObject1, str1, str2, (String)localObject5, str3, paramLong, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab, localBitmap3, localBitmap4, (List)localObject3, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.comboNumberConfigs, localBitmap1, l1, (Bitmap)localObject4, (Bitmap)localObject2);
              m = k;
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.showGesturesTime > 0L) {
                break;
              }
              m = k;
              if (!this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.b()) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.showGesturesTime = l2;
              m = 1;
              break;
              paramPortalShower = (PortalManager.PortalShower)localObject2;
              localObject4 = str1;
              localObject2 = str2;
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode != 2) {
                break label867;
              }
              localObject1 = (PortalManager.LogoConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
              paramPortalShower = a(((PortalManager.LogoConfig)localObject1).logoImageMD5, "hb_busi_logo_path");
              localBitmap1 = a(((PortalManager.LogoConfig)localObject1).nameMD5, "hb_name_path");
              localObject1 = a(((PortalManager.LogoConfig)localObject1).padantImageMD5, "hb_busi_logo_path");
              localObject4 = str1;
              localObject2 = str2;
              break label867;
              paramLong = l3;
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime == 0L)
              {
                paramLong = l3;
                if (l2 >= this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime) {
                  paramLong = 0L;
                }
              }
            }
          }
          label867:
          m = k;
          label1246:
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 3)
          {
            paramPortalShower = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.bgMd5, null);
            m = k;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(paramPortalShower))
            {
              m = 1;
              this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag = 2;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a();
          continue;
          label1356:
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a();
          m = k;
        }
        label1368:
        break;
        paramInt = k;
      }
      label1376:
      localObject2 = null;
      localObject1 = null;
      localBitmap1 = null;
    }
  }
  
  void a(boolean paramBoolean, int paramInt, long paramLong, Object paramObject)
  {
    if (!this.jdField_c_of_type_Boolean) {
      try
      {
        if (!this.jdField_c_of_type_Boolean) {
          if (!paramBoolean) {
            break label46;
          }
        }
        label46:
        for (Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;; localHandler = this.jdField_a_of_type_AndroidOsHandler)
        {
          localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, 0, 0, paramObject), paramLong);
          return;
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 2);
  }
  
  protected boolean a(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "saveRedPacketConfig");
    }
    if (paramRedPacketConfig == null) {
      return false;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramRedPacketConfig);
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      return FileUtils.a(a(), localByteArrayOutputStream.toByteArray(), false);
    }
    catch (Throwable paramRedPacketConfig)
    {
      paramRedPacketConfig.printStackTrace();
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    PortalManager.PortalConfig localPortalConfig = null;
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "isShowYYBao, url=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    int k;
    Object localObject;
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs != null))
    {
      k = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs.size();
      if (k > 0)
      {
        localObject = (PortalManager.PortalConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs.get(0);
        localPortalConfig = (PortalManager.PortalConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs.get(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs.size() - 1);
        if ((localObject != null) && (localPortalConfig != null) && (((PortalManager.PortalConfig)localObject).realBegin <= l) && (l <= localPortalConfig.realEnd))
        {
          paramString = URLUtil.a(paramString);
          if ((paramString != null) && ("redpacket2017".equalsIgnoreCase((String)paramString.get("from"))))
          {
            bool = false;
            paramString = (String)localObject;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("isShowYYBao, ").append(bool).append(",").append(l).append(",").append(k).append(", startpor=");
        if (paramString == null) {
          break label348;
        }
        paramString = paramString.id + "," + paramString.realBegin;
        localObject = ((StringBuilder)localObject).append(paramString).append(", endpor=");
        if (localPortalConfig == null) {
          break label355;
        }
      }
      label348:
      label355:
      for (paramString = localPortalConfig.id + "," + localPortalConfig.realEnd;; paramString = "")
      {
        QLog.d("PortalManager", 2, paramString);
        return bool;
        paramString = "";
        break;
      }
      bool = true;
      paramString = (String)localObject;
      continue;
      paramString = null;
      bool = true;
      continue;
      k = -1;
      bool = true;
      paramString = null;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "clearData");
    }
    File localFile = new File(BaseApplicationImpl.sApplication.getFilesDir(), "red_packet_config2017_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if ((localFile.delete()) && (!localFile.delete()) && (localFile.delete())) {}
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "testplaySound, stopCountDown, mPlayCountDownStreamId=" + this.jdField_e_of_type_Int + ", mPlayCountDownState=" + this.jdField_b_of_type_Int);
    }
    if (this.jdField_b_of_type_Int == 4) {
      return;
    }
    if (this.jdField_e_of_type_Int != 0) {}
    try
    {
      if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
        this.jdField_a_of_type_AndroidMediaSoundPool.pause(this.jdField_e_of_type_Int);
      }
      label83:
      this.jdField_e_of_type_Int = 0;
      this.jdField_b_of_type_Int = 4;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label83;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "handleMessage " + paramMessage.what + ", " + paramMessage.obj);
    }
    long l = 0L;
    Object localObject1;
    Object localObject2;
    boolean bool2;
    boolean bool1;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      for (;;)
      {
        return false;
        if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig == null) && (NetConnInfoCenter.servetTimeSecondInterv != 0L)) {
          a();
        }
        d();
      }
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null) {
        return true;
      }
    case 3: 
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
      localObject2 = (PortalManager.RedPacketConfig)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig = ((PortalManager.RedPacketConfig)localObject2);
      if (localObject2 != null)
      {
        bool2 = a((PortalManager.RedPacketConfig)localObject2, (PortalManager.RedPacketConfig)localObject1, true);
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.grebInterval, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.reportActiveInterval, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.reportNormalInterval);
          bool1 = bool2;
        }
        label283:
        l = NetConnInfoCenter.getServerTimeMillis();
        a(l);
      }
      break;
    }
    for (;;)
    {
      if (paramMessage.what == 5) {}
      for (bool2 = true;; bool2 = false)
      {
        a(null, 3, bool2, l);
        if (!bool1) {
          break;
        }
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        break;
      }
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(6)) {
        break;
      }
      a((PortalManager.RedPacketConfig)paramMessage.obj);
      break;
      a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
      break;
      localObject1 = (PortalManager.PortalShower)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower = ((PortalManager.PortalShower)localObject1);
      a((PortalManager.PortalShower)localObject1, paramMessage.arg1, false, 0L);
      break;
      a();
      if ((!QLog.isColorLevel()) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null)) {
        break;
      }
      QLog.d("PortalManager", 2, "MSG_GRAB_TIMEOUT | activity id:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id + ", total count:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
      break;
      this.jdField_a_of_type_AndroidOsHandler.post(new PortalManager.reportRunnable(this, this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, b(), ((Long)paramMessage.obj).longValue(), false));
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
      if ((!QLog.isColorLevel()) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null)) {
        break;
      }
      QLog.d("PortalManager", 2, "MSG_GRAB_TIMEOUT_REPORT | activity id:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id + ", total count:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) {
        QLog.d("PortalManager", 2, "MSG_GRAB_FAKE_EVENT, mShower" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) {}
      for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.emptyMsg;; paramMessage = HardCodeUtil.a(2131708330))
      {
        ((PortalManager.PortalShower)localObject1).a(false, paramMessage, null);
        break;
      }
      if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof ArrayList))) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      int k = paramMessage.arg1;
      localObject2 = (ArrayList)paramMessage.obj;
      if (paramMessage.arg2 == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        RedPacketServlet.a((AppRuntime)localObject1, k, (ArrayList)localObject2, bool1, paramMessage.getData());
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new PortalManager.reportRunnable(this, this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 2, 0, 0, 0, 0L, false));
      this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(15);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(15, 600000L);
      break;
      bool1 = false;
      break label283;
      bool1 = false;
    }
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 365	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +13 -> 18
    //   8: ldc_w 268
    //   11: iconst_2
    //   12: ldc_w 1863
    //   15: invokestatic 391	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 1330	com/tencent/mobileqq/portal/PortalManager:jdField_c_of_type_Boolean	Z
    //   23: aload_0
    //   24: getfield 1236	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig	Lcom/tencent/mobileqq/portal/PortalManager$PortalConfig;
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 151	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   32: invokevirtual 1864	android/support/v4/util/SparseArrayCompat:size	()I
    //   35: ifle +60 -> 95
    //   38: aload_1
    //   39: getfield 1318	com/tencent/mobileqq/portal/PortalManager$PortalConfig:useTime	J
    //   42: lconst_0
    //   43: lcmp
    //   44: ifle +51 -> 95
    //   47: aload_0
    //   48: getfield 217	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   51: new 1825	com/tencent/mobileqq/portal/PortalManager$reportRunnable
    //   54: dup
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 151	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   60: invokevirtual 1829	android/support/v4/util/SparseArrayCompat:clone	()Landroid/support/v4/util/SparseArrayCompat;
    //   63: iconst_1
    //   64: aload_0
    //   65: getfield 168	com/tencent/mobileqq/portal/PortalManager:jdField_c_of_type_Int	I
    //   68: aload_0
    //   69: getfield 170	com/tencent/mobileqq/portal/PortalManager:jdField_d_of_type_Int	I
    //   72: aload_0
    //   73: invokespecial 1831	com/tencent/mobileqq/portal/PortalManager:b	()I
    //   76: aload_1
    //   77: getfield 1318	com/tencent/mobileqq/portal/PortalManager$PortalConfig:useTime	J
    //   80: iconst_1
    //   81: invokespecial 1834	com/tencent/mobileqq/portal/PortalManager$reportRunnable:<init>	(Lcom/tencent/mobileqq/portal/PortalManager;Landroid/support/v4/util/SparseArrayCompat;IIIIJZ)V
    //   84: invokevirtual 1633	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   87: pop
    //   88: aload_0
    //   89: getfield 151	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   92: invokevirtual 1835	android/support/v4/util/SparseArrayCompat:clear	()V
    //   95: aload_0
    //   96: getfield 180	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   99: invokevirtual 1864	android/support/v4/util/SparseArrayCompat:size	()I
    //   102: ifle +39 -> 141
    //   105: aload_0
    //   106: getfield 217	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   109: new 1825	com/tencent/mobileqq/portal/PortalManager$reportRunnable
    //   112: dup
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 180	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   118: invokevirtual 1829	android/support/v4/util/SparseArrayCompat:clone	()Landroid/support/v4/util/SparseArrayCompat;
    //   121: iconst_2
    //   122: iconst_0
    //   123: iconst_0
    //   124: iconst_0
    //   125: lconst_0
    //   126: iconst_1
    //   127: invokespecial 1834	com/tencent/mobileqq/portal/PortalManager$reportRunnable:<init>	(Lcom/tencent/mobileqq/portal/PortalManager;Landroid/support/v4/util/SparseArrayCompat;IIIIJZ)V
    //   130: invokevirtual 1633	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   133: pop
    //   134: aload_0
    //   135: getfield 180	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   138: invokevirtual 1835	android/support/v4/util/SparseArrayCompat:clear	()V
    //   141: aload_0
    //   142: getfield 217	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   145: iconst_1
    //   146: invokevirtual 1225	android/os/Handler:removeMessages	(I)V
    //   149: aload_0
    //   150: getfield 217	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   153: bipush 15
    //   155: invokevirtual 1225	android/os/Handler:removeMessages	(I)V
    //   158: aload_0
    //   159: getfield 224	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   162: aconst_null
    //   163: invokevirtual 1867	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   166: aload_0
    //   167: getfield 196	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   170: aload_0
    //   171: invokevirtual 1870	com/tencent/mobileqq/app/QQAppInterface:unRegistObserver	(Lmqq/observer/BusinessObserver;)V
    //   174: aload_0
    //   175: getfield 196	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   178: aload_0
    //   179: getfield 192	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver	Lcom/tencent/mobileqq/avatar/observer/AvatarObserver;
    //   182: invokevirtual 1873	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   185: aload_0
    //   186: invokevirtual 1562	com/tencent/mobileqq/portal/PortalManager:c	()V
    //   189: aload_0
    //   190: getfield 196	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   193: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   196: aload_0
    //   197: getfield 237	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalJSReceiver	Lcom/tencent/mobileqq/portal/PortalManager$PortalJSReceiver;
    //   200: invokevirtual 1877	com/tencent/qphone/base/util/BaseApplication:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   203: aload_0
    //   204: getfield 1597	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidMediaSoundPool	Landroid/media/SoundPool;
    //   207: ifnull +15 -> 222
    //   210: aload_0
    //   211: getfield 1597	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidMediaSoundPool	Landroid/media/SoundPool;
    //   214: invokevirtual 1880	android/media/SoundPool:release	()V
    //   217: aload_0
    //   218: aconst_null
    //   219: putfield 1597	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidMediaSoundPool	Landroid/media/SoundPool;
    //   222: aload_0
    //   223: monitorexit
    //   224: return
    //   225: astore_1
    //   226: ldc_w 268
    //   229: iconst_1
    //   230: ldc_w 1863
    //   233: aload_1
    //   234: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   237: goto -34 -> 203
    //   240: astore_1
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	PortalManager
    //   27	50	1	localPortalConfig	PortalManager.PortalConfig
    //   225	9	1	localException	Exception
    //   240	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   189	203	225	java/lang/Exception
    //   2	18	240	finally
    //   18	95	240	finally
    //   95	141	240	finally
    //   141	189	240	finally
    //   189	203	240	finally
    //   203	222	240	finally
    //   226	237	240	finally
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "testplaySound, onLoadComplete, " + paramInt1 + ", " + paramInt2 + ", mPlayCountDownStreamId=" + this.jdField_e_of_type_Int + ", mPlayCountDownState=" + this.jdField_b_of_type_Int);
    }
    int k = 0;
    if ((k >= 5) || (this.jdField_a_of_type_ArrayOfInt[k] == paramInt1)) {
      if (k != 5) {
        break label105;
      }
    }
    label105:
    while (paramInt2 != 0)
    {
      return;
      k += 1;
      break;
    }
    jdField_a_of_type_ArrayOfBoolean[k] = true;
    a(k, true);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onReceive, cmd = " + paramInt + ", isSuccess = " + paramBoolean + ", " + paramBundle);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, new Object[] { "onReceive", Integer.valueOf(paramInt) });
    }
    Object localObject3;
    int k;
    int m;
    boolean bool;
    int n;
    int i1;
    PortalManager.PortalConfig localPortalConfig;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      localObject3 = paramBundle.getString("key_url");
      k = paramBundle.getInt("k_id", -1);
      int i2 = paramBundle.getInt("k_code", -1);
      m = paramBundle.getInt("k_money", -1);
      int i3 = paramBundle.getInt("k_type", -1);
      bool = paramBundle.getBoolean("k_s_follow", true);
      n = paramBundle.getInt("key_award_id", -1);
      i1 = paramBundle.getInt("key_promotion_id", -1);
      long l = paramBundle.getLong("key_send_url", -1L);
      paramBundle = paramBundle.getString("key_wish", "");
      paramInt = -1;
      if (paramBoolean) {
        this.h = (-this.h);
      }
      if (i2 > 0) {
        this.jdField_c_of_type_Int += 1;
      }
      if ((paramBoolean) && (i2 == 0))
      {
        this.jdField_d_of_type_Int += 1;
        switch (i3)
        {
        default: 
          this.jdField_d_of_type_Int -= 1;
          this.jdField_c_of_type_Int += 1;
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, new Object[] { "onReceive cmd = CMD_RESULT, portId = " + k + ", url = " + (String)localObject3 + ", showType = " + paramInt + ", money = " + m + ", awardId = " + n + ", promotionId = " + i1, ", sendUrl = " + Long.valueOf(l) + ", wishing " + paramBundle });
          }
          localPortalConfig = a(k);
          if (localPortalConfig == null) {
            paramBoolean = false;
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      Object localObject1;
      if ((paramBoolean) && (localPortalConfig != null))
      {
        localObject1 = localPortalConfig.findRealAwardConfigById(n);
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          localObject1 = localPortalConfig.findRealAwardConfigById(i1);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null)
          {
            paramBundle = (Bundle)localObject1;
            paramBoolean = false;
          }
        }
      }
      for (;;)
      {
        Object localObject2 = null;
        localObject1 = localObject2;
        if (paramBoolean)
        {
          localObject1 = localObject2;
          if (paramBundle != null)
          {
            localObject2 = new PortalManager.ResultData(null, paramBundle.awardTitle, paramBundle.awardMsg, k, paramInt, (String)localObject3, m, bool, n, i1);
            localObject3 = localPortalConfig.logoList.iterator();
            label578:
            PortalManager.LogoConfig localLogoConfig;
            do
            {
              localObject1 = localObject2;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localLogoConfig = (PortalManager.LogoConfig)((Iterator)localObject3).next();
            } while (localLogoConfig.logoId != paramBundle.logoId);
            String str = localLogoConfig.logoImageMD5;
            if (localPortalConfig.mode == 1) {}
            for (localObject1 = "hb_icon_path";; localObject1 = "hb_busi_logo_path")
            {
              ((PortalManager.ResultData)localObject2).b = a(str, (String)localObject1);
              ((PortalManager.ResultData)localObject2).jdField_c_of_type_AndroidGraphicsBitmap = a(localLogoConfig.nameMD5, "hb_name_path");
              break label578;
              paramInt = 0;
              break;
              paramInt = 1;
              break;
              paramBoolean = false;
              break;
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "onReceive" + localObject1 + "isSuccess " + paramBoolean);
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
          if (localPortalConfig != null)
          {
            localObject2 = localPortalConfig.emptyMsg;
            label760:
            ((PortalManager.PortalShower)localObject3).a(paramBoolean, (String)localObject2, (PortalManager.ResultData)localObject1);
          }
        }
        else
        {
          if ((!paramBoolean) || (paramBundle == null)) {
            break;
          }
          localPortalConfig.isHit = paramBoolean;
          if (paramInt != 0) {
            break label838;
          }
          localPortalConfig.hbCnt += 1;
        }
        while (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(6))
        {
          a(false, 6, 2000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
          return;
          localObject2 = HardCodeUtil.a(2131708328);
          break label760;
          label838:
          if (paramInt == 1) {
            localPortalConfig.cardCnt += 1;
          }
        }
        paramInt = paramBundle.getInt("k_code", 2);
        if (paramInt == 3)
        {
          handleMessage(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3, new PortalManager.RedPacketConfig()));
          return;
        }
        if (paramInt == 4)
        {
          paramBundle = (PortalManager.RedPacketConfig)paramBundle.getSerializable("k_cache");
          handleMessage(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3, paramBundle));
          return;
        }
        if ((!paramBoolean) || (paramInt == 2)) {
          break;
        }
        return;
        paramInt = paramBundle.getInt("k_code", -1);
        k = paramBundle.getInt("k_r_type");
        m = paramBundle.getInt("key_seq");
        if ((!paramBoolean) || (paramInt != 0))
        {
          a(k, m, null, paramInt, null);
          return;
        }
        a(k, paramBundle.getString("k_result"), m);
        return;
        continue;
        paramBundle = null;
      }
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    int k = 1;
    boolean bool;
    HttpNetReq localHttpNetReq;
    Object localObject1;
    HashMap localHashMap;
    int m;
    PortalManager.PortalConfig localPortalConfig;
    if (paramNetResp.mResult == 0)
    {
      bool = true;
      localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
      localObject1 = new File(localHttpNetReq.mOutPath);
      Object localObject2 = localHttpNetReq.getUserData();
      localHashMap = new HashMap();
      if ((localObject2 == null) || (!(localObject2 instanceof String[]))) {
        break label444;
      }
      localObject2 = (String[])localObject2;
      m = Integer.valueOf(localObject2[0]).intValue();
      localObject2 = localObject2[1];
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject2)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject2);
      }
      if (bool)
      {
        if (!((String)localObject2).equals(PortalUtils.a(((File)localObject1).getAbsolutePath()))) {
          break label423;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
        localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
        if ((localObject1 == null) || (((PortalManager.BannerConfig)localObject1).id != m)) {
          break label398;
        }
        a((String)localObject2, "hb_banner_path");
        a(true, 5, 0L, null);
        label181:
        if (QLog.isColorLevel()) {
          QLog.i("PortalManager", 2, "onRespMSG_UPDATE_UI, md5 = " + (String)localObject2);
        }
      }
      label215:
      if (QLog.isColorLevel()) {
        QLog.i("PortalManager", 2, "onResp" + localHttpNetReq.mReqUrl + ", " + paramNetResp.mResult + ", " + paramNetResp.mErrCode + ", " + (String)localHashMap.get("param_checkMd5Fail"));
      }
      if (bool) {
        break label453;
      }
      localHashMap.put("param_Url", localHttpNetReq.mReqUrl);
      localHashMap.put("param_ResultCode", String.valueOf(paramNetResp.mResult));
      localHashMap.put("param_FailCode", String.valueOf(paramNetResp.mErrCode));
    }
    for (;;)
    {
      if (k != 0)
      {
        paramNetResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext()).collectPerformance(paramNetResp, "RedPacketPicDownload", bool, 0L, 0L, localHashMap, "", false);
      }
      return;
      bool = false;
      break;
      label398:
      if ((localPortalConfig == null) || (localPortalConfig.id != m)) {
        break label181;
      }
      a(true, 5, 0L, null);
      break label181;
      label423:
      ((File)localObject1).delete();
      localHashMap.put("param_checkMd5Fail", "checkMd5Fail");
      break label215;
      label444:
      ((File)localObject1).delete();
      break label215;
      label453:
      if (new Random().nextInt(10000) == 1000)
      {
        localHashMap.put("param_Url", localHttpNetReq.mReqUrl);
        localHashMap.put("param_ResultCode", String.valueOf(paramNetResp.mResult));
      }
      else
      {
        k = 0;
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager
 * JD-Core Version:    0.7.0.1
 */