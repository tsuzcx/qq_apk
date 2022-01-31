package com.tencent.mobileqq.portal;

import agmp;
import agmq;
import agmr;
import agms;
import agmt;
import agmv;
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
import android.os.Vibrator;
import android.support.v4.util.MQLruCache;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.olympic.OlympicDPC;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import tencent.im.s2c.msgtype0x210.submsgtype0x78.submsgtype0x78.MsgBody;

public class PortalManager
  implements SoundPool.OnLoadCompleteListener, Handler.Callback, INetEngine.INetEngineListener, Manager, BusinessObserver
{
  static int jdField_a_of_type_Int;
  public static long a;
  private static PortalManager.TimerConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig;
  protected static INetEngine.IBreakDownFix a;
  public static final String a;
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private static Comparator jdField_a_of_type_JavaUtilComparator;
  public static boolean a;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "2016-12-13", "2016-12-14", "2017-1-20", "2017-1-27", "2017-1-28" };
  private static final boolean[] jdField_a_of_type_ArrayOfBoolean;
  public static long b;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  public static long c;
  public static long f;
  public static long g;
  private static long i;
  agmv jdField_a_of_type_Agmv;
  private Context jdField_a_of_type_AndroidContentContext;
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private Handler jdField_a_of_type_AndroidOsHandler;
  SparseArrayCompat jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(1);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new agmt(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OlympicDPC jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC;
  private PortalManager.BannerConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
  private PortalManager.PortalConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
  private PortalManager.PortalShower jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
  public volatile PortalManager.RedPacketConfig a;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  Set jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  public final ConcurrentHashMap a;
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 0, 0, 0, 0 };
  int jdField_b_of_type_Int = 4;
  private Handler jdField_b_of_type_AndroidOsHandler;
  SparseArrayCompat jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(100);
  private PortalManager.BannerConfig jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
  private PortalManager.PortalConfig jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  public long d;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  volatile long jdField_e_of_type_Long = 0L;
  private long h;
  private long j;
  
  static
  {
    jdField_a_of_type_Long = 2500L;
    jdField_b_of_type_Long = 180000L;
    jdField_c_of_type_Long = 180000L;
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = File.separator + "redPacketRes/";
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new agmr();
    jdField_a_of_type_JavaUtilComparator = new agms();
    jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig = new PortalManager.TimerConfig(null);
    jdField_a_of_type_ArrayOfBoolean = new boolean[] { 0, 0, 0, 0, 0 };
    jdField_b_of_type_ArrayOfInt = new int[0];
  }
  
  public PortalManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(1000);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.sApplication;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    this.jdField_a_of_type_Agmv = new agmv(this, null);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_Agmv, new IntentFilter("com.tencent.portal.req.action"), "com.tencent.msg.permission.pushnotify", null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
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
    return -1;
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
      paramString = (Bitmap)BaseApplicationImpl.sImageCache.get("red_packet_" + paramString);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("getBitmapFromCache, hit=");
        if (paramString == null) {
          break label72;
        }
      }
      label72:
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
    //   2: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +39 -> 44
    //   8: ldc 239
    //   10: iconst_2
    //   11: new 66	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 325
    //   21: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 327
    //   31: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_1
    //   35: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: getstatic 300	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   47: new 66	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 302
    //   57: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokevirtual 308	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 310	android/graphics/Bitmap
    //   73: astore_3
    //   74: aload_3
    //   75: ifnull +35 -> 110
    //   78: aload_3
    //   79: astore 5
    //   81: aload_3
    //   82: astore 6
    //   84: aload_3
    //   85: astore 4
    //   87: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +202 -> 292
    //   93: aload_3
    //   94: astore 5
    //   96: aload_3
    //   97: astore 6
    //   99: ldc 239
    //   101: iconst_2
    //   102: ldc_w 332
    //   105: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_3
    //   109: areturn
    //   110: aload_3
    //   111: astore 5
    //   113: aload_3
    //   114: astore 6
    //   116: invokestatic 336	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   119: invokevirtual 340	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   122: bipush 78
    //   124: invokevirtual 346	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   127: checkcast 2	com/tencent/mobileqq/portal/PortalManager
    //   130: astore 4
    //   132: aload 4
    //   134: ifnull +15 -> 149
    //   137: aload_3
    //   138: astore 5
    //   140: aload_3
    //   141: astore 6
    //   143: aload 4
    //   145: getfield 348	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC	Lcom/tencent/mobileqq/olympic/OlympicDPC;
    //   148: astore_2
    //   149: aload_3
    //   150: astore 5
    //   152: aload_3
    //   153: astore 6
    //   155: ldc 241
    //   157: iload_1
    //   158: aload_2
    //   159: iconst_2
    //   160: invokestatic 351	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;ILcom/tencent/mobileqq/olympic/OlympicDPC;I)Landroid/util/Pair;
    //   163: astore 4
    //   165: aload_3
    //   166: astore_2
    //   167: aload 4
    //   169: ifnull +18 -> 187
    //   172: aload_3
    //   173: astore 5
    //   175: aload_3
    //   176: astore 6
    //   178: aload 4
    //   180: getfield 357	android/util/Pair:second	Ljava/lang/Object;
    //   183: checkcast 310	android/graphics/Bitmap
    //   186: astore_2
    //   187: aload_2
    //   188: astore 4
    //   190: aload_2
    //   191: ifnull +101 -> 292
    //   194: aload_2
    //   195: astore 5
    //   197: aload_2
    //   198: astore 6
    //   200: getstatic 300	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   203: new 66	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 302
    //   213: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: aload_2
    //   224: invokevirtual 361	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   227: pop
    //   228: aload_2
    //   229: areturn
    //   230: astore_0
    //   231: aload 5
    //   233: astore 4
    //   235: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +54 -> 292
    //   241: ldc 239
    //   243: iconst_2
    //   244: ldc_w 363
    //   247: aload_0
    //   248: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   251: aload 5
    //   253: areturn
    //   254: astore_0
    //   255: aconst_null
    //   256: astore 6
    //   258: aload 6
    //   260: astore 4
    //   262: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +27 -> 292
    //   268: ldc 239
    //   270: iconst_2
    //   271: ldc_w 320
    //   274: aload_0
    //   275: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   278: aload 6
    //   280: areturn
    //   281: astore_0
    //   282: goto -24 -> 258
    //   285: astore_0
    //   286: aconst_null
    //   287: astore 5
    //   289: goto -58 -> 231
    //   292: aload 4
    //   294: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	paramString	String
    //   0	295	1	paramInt	int
    //   1	228	2	localObject1	Object
    //   73	103	3	localBitmap	Bitmap
    //   85	208	4	localObject2	Object
    //   79	209	5	localObject3	Object
    //   82	197	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   87	93	230	java/lang/OutOfMemoryError
    //   99	108	230	java/lang/OutOfMemoryError
    //   116	132	230	java/lang/OutOfMemoryError
    //   143	149	230	java/lang/OutOfMemoryError
    //   155	165	230	java/lang/OutOfMemoryError
    //   178	187	230	java/lang/OutOfMemoryError
    //   200	228	230	java/lang/OutOfMemoryError
    //   44	74	254	java/lang/Exception
    //   87	93	281	java/lang/Exception
    //   99	108	281	java/lang/Exception
    //   116	132	281	java/lang/Exception
    //   143	149	281	java/lang/Exception
    //   155	165	281	java/lang/Exception
    //   178	187	281	java/lang/Exception
    //   200	228	281	java/lang/Exception
    //   44	74	285	java/lang/OutOfMemoryError
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
      localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
      if (localBitmap == null) {
        break label163;
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
        label163:
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
        PortalManager localPortalManager = (PortalManager)BaseApplicationImpl.getApplication().getRuntime().getManager(78);
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
        BaseApplicationImpl.sImageCache.put(str, paramString1);
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
      localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get("red_packet_" + paramString);
      if (localObject2 != null) {
        return localObject2;
      }
      k = a(paramString);
      if (k < 0) {
        return null;
      }
      localObject1 = (PortalManager)BaseApplicationImpl.getApplication().getRuntime().getManager(78);
      if (localObject1 == null) {
        break label163;
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
      label163:
      if (!QLog.isColorLevel()) {
        break label184;
      }
      QLog.e("PortalManager", 2, "", paramString);
      label184:
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
        BaseApplicationImpl.sImageCache.put("red_packet_" + paramString, localObject1);
        return localObject1;
      }
    }
    return localObject2;
  }
  
  private static Pair a(String paramString, int paramInt1, OlympicDPC paramOlympicDPC, int paramInt2)
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
  
  public static Pair a(XmlPullParser paramXmlPullParser, String paramString)
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
        break label120;
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
      label120:
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (str.equalsIgnoreCase("md5"))
      {
        localObject3 = paramXmlPullParser.nextText();
        localObject4 = localObject1;
      }
    }
  }
  
  public static PortalManager.RedPacketConfig a(String paramString, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    PortalManager.RedPacketConfig localRedPacketConfig = new PortalManager.RedPacketConfig();
    localRedPacketConfig.version = paramInt1;
    localRedPacketConfig.taskId = paramInt2;
    Object localObject1 = null;
    Object localObject4;
    label302:
    label317:
    label319:
    Object localObject3;
    label659:
    label821:
    PortalManager.PortalConfig localPortalConfig;
    String str;
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        paramInt1 = localXmlPullParser.getEventType();
        if (paramInt1 == 1) {
          break label3210;
        }
        Object localObject2 = localObject1;
        if (paramInt1 == 2)
        {
          localObject4 = localXmlPullParser.getName();
          if (!((String)localObject4).equalsIgnoreCase("Common")) {
            break label659;
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
          break label319;
        }
        localRedPacketConfig.reportActiveInterval = Long.valueOf(localXmlPullParser.nextText()).longValue();
        localObject2 = localObject1;
        continue;
        if (!QLog.isColorLevel()) {
          break label317;
        }
      }
      catch (Exception localException)
      {
        localObject1 = null;
        paramArrayList = (ArrayList)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e("PortalManager", 2, paramString, localException);
          paramArrayList = (ArrayList)localObject1;
        }
      }
      localObject1 = new StringBuilder().append("parseConfig, ");
      if (paramArrayList == null) {
        break label3620;
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
        localObject3 = a(localXmlPullParser, (String)localObject4);
        ((PortalManager.ComboNumber)localObject1).numberImageUrl = ((String)((Pair)localObject3).first);
        ((PortalManager.ComboNumber)localObject1).numberImageMD5 = ((String)((Pair)localObject3).second);
        localObject3 = localObject1;
      }
      else
      {
        localObject3 = localObject1;
        if (((String)localObject4).equalsIgnoreCase("FlowerImage"))
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
                        break label821;
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
    if (paramInt1 == 2)
    {
      if (!str.equalsIgnoreCase("Id")) {
        break label1158;
      }
      localPortalConfig.id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
    }
    label1158:
    label1636:
    label2042:
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
                      break label1727;
                    }
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((PortalManager.LogoConfig)localObject3).logoImageUrl = ((String)((Pair)localObject4).first);
                    ((PortalManager.LogoConfig)localObject3).logoImageMD5 = ((String)((Pair)localObject4).second);
                  }
                }
                for (;;)
                {
                  paramInt1 = localXmlPullParser.next();
                  break label1636;
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
                      break label2116;
                    }
                    ((PortalManager.AwardConfig)localObject3).awardId = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                  }
                }
                for (;;)
                {
                  paramInt1 = localXmlPullParser.next();
                  break label2042;
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
                  break label2619;
                }
                localPortalConfig.starNoLucyType = Integer.parseInt(localXmlPullParser.nextText());
              }
            }
          }
          if (!str.equalsIgnoreCase("sharePhoto")) {
            break label2962;
          }
          paramInt1 = localXmlPullParser.next();
          if (paramInt1 == 1) {
            break label2724;
          }
          localObject3 = localXmlPullParser.getName();
        } while ((paramInt1 == 3) && (((String)localObject3).equalsIgnoreCase(str)));
        if (paramInt1 == 2)
        {
          if (!((String)localObject3).equalsIgnoreCase("summary")) {
            break label2726;
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
          break label2638;
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
        break label3067;
      }
      localObject3 = localXmlPullParser.getName();
    } while ((paramInt1 == 3) && (((String)localObject3).equalsIgnoreCase(str)));
    label1727:
    label2116:
    label2638:
    if (paramInt1 == 2)
    {
      if (!((String)localObject3).equalsIgnoreCase("summary")) {
        break label3069;
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
      label2619:
      paramInt1 = localXmlPullParser.next();
      label2724:
      label2726:
      break label2981;
      label2962:
      label2981:
      label3067:
      break;
      label3069:
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
    label3210:
    paramInt1 = 0;
    int m = localRedPacketConfig.portalConfigs.size();
    label3231:
    label3304:
    int k;
    if (paramArrayList != null)
    {
      paramInt2 = paramArrayList.size();
      if ((paramInt2 != 0) && (m > 0))
      {
        Collections.sort(localRedPacketConfig.portalConfigs, jdField_a_of_type_JavaUtilComparator);
        localObject1 = (PortalManager.PortalConfig)localRedPacketConfig.portalConfigs.get(0);
        if (((PortalManager.PortalConfig)localObject1).type != 2) {
          break label3630;
        }
        ((PortalManager.PortalConfig)localObject1).uiBegin = (((PortalManager.PortalConfig)localObject1).realBegin + ((Integer)paramArrayList.get(0 % paramInt2)).intValue());
        paramInt1 = 1;
        break label3630;
        if (k < m)
        {
          localObject3 = (PortalManager.PortalConfig)localRedPacketConfig.portalConfigs.get(k);
          if (((PortalManager.PortalConfig)localObject3).type != 2) {
            break label3627;
          }
          ((PortalManager.PortalConfig)localObject3).uiBegin = (((PortalManager.PortalConfig)localObject3).realBegin + ((Integer)paramArrayList.get(paramInt1 % paramInt2)).intValue() * 1000);
          if ((localObject1 == null) || (((PortalManager.PortalConfig)localObject1).type != 1) || (((PortalManager.PortalConfig)localObject1).realEnd + 2000L < ((PortalManager.PortalConfig)localObject3).realBegin)) {
            break label3636;
          }
          ((PortalManager.PortalConfig)localObject1).uiEnd = (((PortalManager.PortalConfig)localObject1).realEnd + ((Integer)paramArrayList.get(paramInt1 % paramInt2)).intValue() * 1000);
          break label3636;
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
        label3620:
        paramString = "null";
        break label302;
        label3627:
        break label3640;
        label3630:
        k = 1;
        break label3304;
        label3636:
        paramInt1 += 1;
        label3640:
        k += 1;
        localObject1 = localObject3;
        break label3304;
        paramInt2 = 0;
        break label3231;
      }
      paramInt1 -= 1;
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + jdField_a_of_type_JavaLangString;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramString1;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_c_of_type_JavaLangString = (str + paramString2);
    localHttpNetReq.jdField_e_of_type_Int = 2;
    localHttpNetReq.a(new String[] { String.valueOf(paramInt), paramString2 });
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
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
        break label867;
      }
      localObject1 = (PortalManager.BannerConfig)localArrayList.get(k - 1);
      if (((PortalManager.BannerConfig)localObject1).uiEnd >= l2) {
        break label864;
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
          break label858;
        }
        localPortalConfig = (PortalManager.PortalConfig)((ArrayList)localObject3).get(k - 1);
        if (localPortalConfig.uiEnd >= l2) {
          break label855;
        }
        localPortalConfig = null;
      }
      for (;;)
      {
        if ((k < ((ArrayList)localObject3).size()) && (k >= 0)) {}
        label291:
        label557:
        label586:
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
              break label776;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd <= l2) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd >= paramLong)) {
              break label733;
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
          label459:
          label846:
          for (;;)
          {
            if (paramLong != 9223372036854775807L)
            {
              if (paramLong <= l2) {
                break label806;
              }
              l1 = paramLong - l2;
              label480:
              l2 = l1;
              if (l1 > 60000L) {
                l2 = 60000L;
              }
              if (f == 0L) {
                break label839;
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
                  break label819;
                }
                k = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(k).append(", ");
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label824;
                }
                k = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
                label615:
                localObject1 = ((StringBuilder)localObject1).append(k).append(", ");
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label829;
                }
                k = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(k).append(", ").append(paramLong).append(", ");
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label834;
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
                label733:
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
                  break label846;
                }
                paramLong = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiBegin;
                break label459;
                l1 = 60000L;
                break label480;
                k = -1;
                break label557;
                k = -1;
                break label586;
                k = -1;
                break label615;
                k = -1;
                break label644;
              }
            }
          }
        }
        label644:
        label776:
        label806:
        label819:
        label824:
        label829:
        label834:
        label839:
        label855:
        continue;
        label858:
        localPortalConfig = null;
      }
      label864:
      continue;
      label867:
      localObject1 = null;
    }
  }
  
  public static void a(Activity paramActivity, PortalManager.ResultData paramResultData)
  {
    if ((paramResultData == null) || (paramActivity == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "showResultActivity" + paramResultData + ", " + paramActivity);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "showResultActivity, " + paramResultData.jdField_b_of_type_Int + ", " + paramResultData.jdField_b_of_type_JavaLangString + ", " + paramResultData.jdField_a_of_type_Int);
      }
      Intent localIntent = new Intent(paramActivity, HongbaoShowerActivity.class);
      localIntent.putExtra("a_hb_type", paramResultData.jdField_b_of_type_Int);
      localIntent.putExtra("a_hg_url", paramResultData.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("a_hb_task_id", paramResultData.jdField_a_of_type_Int);
      localIntent.putExtra("money", paramResultData.jdField_c_of_type_Int);
      localIntent.putExtra("show_follow", paramResultData.jdField_a_of_type_Boolean);
      localIntent.putExtra("award_id", paramResultData.jdField_e_of_type_Int);
      localIntent.putExtra("promotion_id", paramResultData.jdField_f_of_type_Int);
      localIntent.addFlags(67108864);
      paramActivity.startActivity(localIntent);
    } while ((paramResultData.jdField_c_of_type_Int <= 0) || (QWalletHelper.isQWalletProcessExist(paramActivity)));
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "preload qwallet process by shua yi shua");
    }
    if ((paramActivity instanceof BaseActivity))
    {
      QWalletHelper.preloadQWallet(((BaseActivity)paramActivity).app, 0, "qwallet_red");
      return;
    }
    QWalletHelper.preloadQWallet(null, 0, "qwallet_red");
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
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new agmq(this, paramRedPacketConfig), 60000L);
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
        StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "hongbao_res_precover", bool2, 0L, 0L, (HashMap)localObject3, "", false);
      }
      return;
    }
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
  
  private int d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 2)) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord;
  }
  
  public static boolean e()
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
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 2)) {}
    for (;;)
    {
      return;
      int k = 0;
      while (k < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
      {
        if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(k) != this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id)
        {
          this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.remove(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(k));
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "purifyBrashReporter delete key = " + this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(k));
          }
        }
        k += 1;
      }
    }
  }
  
  private void j()
  {
    boolean bool2 = true;
    int k;
    int m;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC = new OlympicDPC();
      k = (int)(DeviceInfoUtil.e() / 1024L / 1024L);
      m = ViewUtils.a();
      str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.olympic_act_config.name());
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
                break label487;
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
              break label523;
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
        label523:
        if (m <= Integer.valueOf(localException[2]).intValue())
        {
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Boolean = true;
          continue;
          label487:
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
            break label201;
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
          break label238;
        }
      }
      label201:
      label238:
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
    //   0: new 71	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 175	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8: invokevirtual 1470	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: new 66	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 1472
    //   21: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 167	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   28: invokevirtual 1475	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   31: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 1478	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 444	java/io/File:exists	()Z
    //   45: ifeq +383 -> 428
    //   48: new 1480	java/io/FileInputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 1483	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore_1
    //   57: new 1485	java/io/ObjectInputStream
    //   60: dup
    //   61: new 1487	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 1490	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: invokespecial 1491	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore 6
    //   74: aload_1
    //   75: astore_3
    //   76: aload 6
    //   78: astore_2
    //   79: aload 6
    //   81: invokevirtual 1494	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   84: checkcast 522	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   87: astore 4
    //   89: aload 6
    //   91: ifnull +8 -> 99
    //   94: aload 6
    //   96: invokevirtual 1497	java/io/ObjectInputStream:close	()V
    //   99: aload_1
    //   100: ifnull +333 -> 433
    //   103: aload_1
    //   104: invokevirtual 1498	java/io/FileInputStream:close	()V
    //   107: aload 4
    //   109: astore_1
    //   110: aload_1
    //   111: astore_2
    //   112: aload_1
    //   113: ifnonnull +11 -> 124
    //   116: new 522	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   119: dup
    //   120: invokespecial 523	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:<init>	()V
    //   123: astore_2
    //   124: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +40 -> 167
    //   130: new 66	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 1500
    //   140: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: astore_3
    //   144: aload_2
    //   145: ifnull +239 -> 384
    //   148: aload_2
    //   149: invokevirtual 570	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:toString	()Ljava/lang/String;
    //   152: astore_1
    //   153: ldc 239
    //   155: iconst_2
    //   156: aload_3
    //   157: aload_1
    //   158: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload_0
    //   168: getfield 1115	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig	Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   171: ifnonnull +11 -> 182
    //   174: aload_0
    //   175: iconst_1
    //   176: iconst_2
    //   177: lconst_0
    //   178: aload_2
    //   179: invokevirtual 1154	com/tencent/mobileqq/portal/PortalManager:a	(ZIJLjava/lang/Object;)V
    //   182: aload_2
    //   183: areturn
    //   184: astore_2
    //   185: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq -89 -> 99
    //   191: ldc 239
    //   193: iconst_2
    //   194: ldc 241
    //   196: aload_2
    //   197: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   200: goto -101 -> 99
    //   203: astore_1
    //   204: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +12 -> 219
    //   210: ldc 239
    //   212: iconst_2
    //   213: ldc 241
    //   215: aload_1
    //   216: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload 4
    //   221: astore_1
    //   222: goto -112 -> 110
    //   225: astore 5
    //   227: aconst_null
    //   228: astore 4
    //   230: aconst_null
    //   231: astore_1
    //   232: aload 4
    //   234: astore_3
    //   235: aload_1
    //   236: astore_2
    //   237: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +18 -> 258
    //   243: aload 4
    //   245: astore_3
    //   246: aload_1
    //   247: astore_2
    //   248: ldc 239
    //   250: iconst_2
    //   251: ldc 241
    //   253: aload 5
    //   255: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aload_1
    //   259: ifnull +7 -> 266
    //   262: aload_1
    //   263: invokevirtual 1497	java/io/ObjectInputStream:close	()V
    //   266: aload 4
    //   268: ifnull +160 -> 428
    //   271: aload 4
    //   273: invokevirtual 1498	java/io/FileInputStream:close	()V
    //   276: aconst_null
    //   277: astore_1
    //   278: goto -168 -> 110
    //   281: astore_1
    //   282: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq -19 -> 266
    //   288: ldc 239
    //   290: iconst_2
    //   291: ldc 241
    //   293: aload_1
    //   294: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   297: goto -31 -> 266
    //   300: astore_1
    //   301: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +12 -> 316
    //   307: ldc 239
    //   309: iconst_2
    //   310: ldc 241
    //   312: aload_1
    //   313: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: aconst_null
    //   317: astore_1
    //   318: goto -208 -> 110
    //   321: astore 4
    //   323: aconst_null
    //   324: astore_1
    //   325: aconst_null
    //   326: astore_2
    //   327: aload_2
    //   328: ifnull +7 -> 335
    //   331: aload_2
    //   332: invokevirtual 1497	java/io/ObjectInputStream:close	()V
    //   335: aload_1
    //   336: ifnull +7 -> 343
    //   339: aload_1
    //   340: invokevirtual 1498	java/io/FileInputStream:close	()V
    //   343: aload 4
    //   345: athrow
    //   346: astore_2
    //   347: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq -15 -> 335
    //   353: ldc 239
    //   355: iconst_2
    //   356: ldc 241
    //   358: aload_2
    //   359: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   362: goto -27 -> 335
    //   365: astore_1
    //   366: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   369: ifeq -26 -> 343
    //   372: ldc 239
    //   374: iconst_2
    //   375: ldc 241
    //   377: aload_1
    //   378: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   381: goto -38 -> 343
    //   384: ldc_w 1002
    //   387: astore_1
    //   388: goto -235 -> 153
    //   391: astore 4
    //   393: aconst_null
    //   394: astore_2
    //   395: goto -68 -> 327
    //   398: astore 4
    //   400: aload_3
    //   401: astore_1
    //   402: goto -75 -> 327
    //   405: astore 5
    //   407: aconst_null
    //   408: astore_2
    //   409: aload_1
    //   410: astore 4
    //   412: aload_2
    //   413: astore_1
    //   414: goto -182 -> 232
    //   417: astore 5
    //   419: aload_1
    //   420: astore 4
    //   422: aload 6
    //   424: astore_1
    //   425: goto -193 -> 232
    //   428: aconst_null
    //   429: astore_1
    //   430: goto -320 -> 110
    //   433: aload 4
    //   435: astore_1
    //   436: goto -326 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	this	PortalManager
    //   40	118	1	localObject1	Object
    //   203	13	1	localIOException1	java.io.IOException
    //   221	57	1	localObject2	Object
    //   281	13	1	localIOException2	java.io.IOException
    //   300	13	1	localIOException3	java.io.IOException
    //   317	23	1	localObject3	Object
    //   365	13	1	localIOException4	java.io.IOException
    //   387	49	1	localObject4	Object
    //   78	105	2	localObject5	Object
    //   184	13	2	localIOException5	java.io.IOException
    //   236	96	2	localObject6	Object
    //   346	13	2	localIOException6	java.io.IOException
    //   394	19	2	localObject7	Object
    //   75	326	3	localObject8	Object
    //   87	185	4	localRedPacketConfig	PortalManager.RedPacketConfig
    //   321	23	4	localObject9	Object
    //   391	1	4	localObject10	Object
    //   398	1	4	localObject11	Object
    //   410	24	4	localObject12	Object
    //   225	29	5	localThrowable1	Throwable
    //   405	1	5	localThrowable2	Throwable
    //   417	1	5	localThrowable3	Throwable
    //   72	351	6	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   94	99	184	java/io/IOException
    //   103	107	203	java/io/IOException
    //   48	57	225	java/lang/Throwable
    //   262	266	281	java/io/IOException
    //   271	276	300	java/io/IOException
    //   48	57	321	finally
    //   331	335	346	java/io/IOException
    //   339	343	365	java/io/IOException
    //   57	74	391	finally
    //   79	89	398	finally
    //   237	243	398	finally
    //   248	258	398	finally
    //   57	74	405	java/lang/Throwable
    //   79	89	417	java/lang/Throwable
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
        break label124;
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
      label124:
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
        ((PortalManager.ResultData)localObject3).jdField_f_of_type_JavaLangString = localObject1.awardMsg;
        ((PortalManager.ResultData)localObject3).jdField_e_of_type_JavaLangString = localObject1.awardTitle;
        ((PortalManager.ResultData)localObject3).jdField_d_of_type_Int = localObject1.awardType;
        ((PortalManager.ResultData)localObject3).jdField_g_of_type_Int = localObject1.showPublic;
        return localObject3;
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    d();
    a(true, 100, 0L, null);
    if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(16)) {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
        break label127;
      }
    }
    label127:
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
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 2)) {}
    do
    {
      do
      {
        return;
      } while (paramInt <= this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord);
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord = paramInt;
    } while (this.jdField_a_of_type_AndroidOsHandler.hasMessages(6));
    a(false, 6, 2000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setStarShareFlag, ").append(paramInt1);
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
        break label100;
      }
    }
    label100:
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
    this.jdField_b_of_type_AndroidOsHandler.post(new agmp(this, paramLong1, paramLong2, paramLong3));
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
        break label328;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl)) {
        break label303;
      }
      if (paramActivity == null) {
        break label260;
      }
      localObject = paramActivity;
      label143:
      localObject = new Intent((Context)localObject, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl);
      ((Intent)localObject).putExtra("hide_left_button", true);
      ((Intent)localObject).putExtra("show_right_close_button", true);
      ((Intent)localObject).putExtra("finish_animation_up_down", true);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).addFlags(67108864);
      if (paramActivity == null) {
        break label267;
      }
      paramActivity.startActivity((Intent)localObject);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077E7", "0X80077E7", 0, 0, "", "", "", "");
      return;
      localObject = "";
      break;
      label260:
      localObject = BaseApplicationImpl.sApplication;
      break label143;
      label267:
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
        label303:
        if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)) {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a();
        }
      }
    }
    label328:
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077E6", "0X80077E6", 0, 0, "", "", "", "");
  }
  
  public void a(Context paramContext) {}
  
  public void a(PortalManager.PortalShower paramPortalShower)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower = null;
  }
  
  public void a(PortalManager.PortalShower paramPortalShower, int paramInt)
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(8, paramInt, 0, paramPortalShower).sendToTarget();
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
          break label1186;
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
          break label686;
        }
        paramLong = -1L;
        if (l2 > this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd) {
          paramLong = Math.min(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd - l2, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode != 1) {
          break label619;
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
            break label1198;
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
          label619:
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode != 2) {
            break label1206;
          }
          paramPortalShower = (PortalManager.LogoConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
          localObject1 = a(paramPortalShower.logoImageMD5, "hb_busi_logo_path");
          localObject2 = a(paramPortalShower.nameMD5, "hb_yure_busi_name_path");
          localBitmap1 = a(paramPortalShower.padantImageMD5, "hb_busi_logo_path");
          break label408;
          label686:
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
                break label1076;
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
                break label790;
              }
              localObject1 = (PortalManager.LogoConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
              paramPortalShower = a(((PortalManager.LogoConfig)localObject1).logoImageMD5, "hb_busi_logo_path");
              localBitmap1 = a(((PortalManager.LogoConfig)localObject1).nameMD5, "hb_name_path");
              localObject1 = a(((PortalManager.LogoConfig)localObject1).padantImageMD5, "hb_busi_logo_path");
              localObject4 = str1;
              localObject2 = str2;
              break label790;
              label1076:
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
          label790:
          m = k;
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
          label1186:
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a();
          m = k;
        }
        label1198:
        break;
        paramInt = k;
      }
      label1206:
      localObject2 = null;
      localObject1 = null;
      localBitmap1 = null;
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    int k = 1;
    boolean bool;
    HttpNetReq localHttpNetReq;
    Object localObject1;
    HashMap localHashMap;
    int m;
    PortalManager.PortalConfig localPortalConfig;
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      bool = true;
      localHttpNetReq = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      localObject1 = new File(localHttpNetReq.jdField_c_of_type_JavaLangString);
      Object localObject2 = localHttpNetReq.a();
      localHashMap = new HashMap();
      if ((localObject2 == null) || (!(localObject2 instanceof String[]))) {
        break label441;
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
          break label420;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
        localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
        if ((localObject1 == null) || (((PortalManager.BannerConfig)localObject1).id != m)) {
          break label395;
        }
        a((String)localObject2, "hb_banner_path");
        a(true, 5, 0L, null);
        label181:
        if (QLog.isColorLevel()) {
          QLog.i("PortalManager", 2, "onRespMSG_UPDATE_UI, md5 = " + (String)localObject2);
        }
      }
      label214:
      if (QLog.isColorLevel()) {
        QLog.i("PortalManager", 2, "onResp" + localHttpNetReq.jdField_a_of_type_JavaLangString + ", " + paramNetResp.jdField_a_of_type_Int + ", " + paramNetResp.jdField_b_of_type_Int + ", " + (String)localHashMap.get("param_checkMd5Fail"));
      }
      if (bool) {
        break label450;
      }
      localHashMap.put("param_Url", localHttpNetReq.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_ResultCode", String.valueOf(paramNetResp.jdField_a_of_type_Int));
      localHashMap.put("param_FailCode", String.valueOf(paramNetResp.jdField_b_of_type_Int));
    }
    for (;;)
    {
      if (k != 0)
      {
        paramNetResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext()).a(paramNetResp, "RedPacketPicDownload", bool, 0L, 0L, localHashMap, "", false);
      }
      return;
      bool = false;
      break;
      label395:
      if ((localPortalConfig == null) || (localPortalConfig.id != m)) {
        break label181;
      }
      a(true, 5, 0L, null);
      break label181;
      label420:
      ((File)localObject1).delete();
      localHashMap.put("param_checkMd5Fail", "checkMd5Fail");
      break label214;
      label441:
      ((File)localObject1).delete();
      break label214;
      label450:
      if (new Random().nextInt(10000) == 1000)
      {
        localHashMap.put("param_Url", localHttpNetReq.jdField_a_of_type_JavaLangString);
        localHashMap.put("param_ResultCode", String.valueOf(paramNetResp.jdField_a_of_type_Int));
      }
      else
      {
        k = 0;
      }
    }
  }
  
  public void a(submsgtype0x78.MsgBody paramMsgBody)
  {
    boolean bool = paramMsgBody.uint32_version.has();
    int k = paramMsgBody.uint32_version.get();
    int m = c();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "handlePush, " + bool + ", " + m + ", " + k);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, Object paramObject)
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
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    long l1;
    if (f > 0L)
    {
      l1 = f;
      long l3 = i;
      l2 = (l2 - g) * l3 + l1;
    }
    for (;;)
    {
      boolean bool = NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder(128);
        ((StringBuilder)localObject2).append("grabHongbao").append(", ").append(bool);
        if (localObject1 != null) {
          ((StringBuilder)localObject2).append(", ").append(((PortalManager.PortalConfig)localObject1).id).append(", ").append(((PortalManager.PortalConfig)localObject1).type).append(", ").append(((PortalManager.PortalConfig)localObject1).useFlag).append(", ").append(((PortalManager.PortalConfig)localObject1).useTime).append(", ").append(l2).append(", ").append(((PortalManager.PortalConfig)localObject1).currentCountGrab);
        }
        QLog.e("PortalManager", 2, ((StringBuilder)localObject2).toString());
      }
      if ((localObject1 == null) || (((PortalManager.PortalConfig)localObject1).type == 1)) {}
      label266:
      do
      {
        return false;
        localObject2 = (ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id);
        if (localObject2 != null) {
          break;
        }
        localObject2 = new ArrayList(60);
        ((ArrayList)localObject2).add(Long.valueOf(l2));
        this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id, localObject2);
        if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() > 1) {
          i();
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
        PortalManager.PortalConfig localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
        k = localPortalConfig.countGrab + 1;
        localPortalConfig.countGrab = k;
        ((PortalManager.PortalConfig)localObject2).currentCountGrab = k;
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(6)) {
          a(false, 6, 2000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        }
        if (((PortalManager.PortalConfig)localObject1).type != 3) {
          break label438;
        }
      } while (((PortalManager.PortalConfig)localObject1).useFlag >= 4);
      int k = 1;
      for (;;)
      {
        if (k != 0)
        {
          localObject1 = new PortalManager.ResultData();
          ((PortalManager.ResultData)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.hotUrl;
          ((PortalManager.ResultData)localObject1).jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(1, (PortalManager.ResultData)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag = 4;
          a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
          return false;
          ((ArrayList)localObject2).add(Long.valueOf(l2));
          break label266;
          label438:
          if (!((PortalManager.PortalConfig)localObject1).isOver(l2)) {
            break label780;
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.hotUrl)) || (((PortalManager.PortalConfig)localObject1).useFlag >= 4)) {
            break;
          }
          k = 1;
          continue;
        }
        if (!bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(false, "网络不给力，请检查网络是否可用！", null);
          return false;
        }
        if (this.h >= 0L)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "GetNewPackReq_DelayTime");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label773;
          }
        }
        for (;;)
        {
          try
          {
            l1 = Long.valueOf((String)localObject1).longValue();
            l1 *= 1000L;
            if ((l1 <= 30000L) || (l1 >= 300000L)) {
              break label773;
            }
          }
          catch (Exception localException)
          {
            QLog.e("PortalManager", 1, (String)localObject1, localException);
            l1 = 30000L;
            continue;
          }
          if ((Math.abs(l2 - this.h) < l1) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.currentCountGrab <= jdField_a_of_type_Int))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PortalManager", 2, "grabHongbao, " + l2 + ", " + this.h + "," + l1);
            }
            return true;
            if ((this.h < 0L) && ((this.h + l2 < jdField_a_of_type_Long) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.currentCountGrab <= jdField_a_of_type_Int)))
            {
              if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(13)) {
                a(true, 13, (1200.0D + Math.random() * 2300.0D), null);
              }
              return true;
            }
          }
          this.h = l2;
          if (jdField_a_of_type_Boolean) {
            RedPacketServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1001);
          }
          for (;;)
          {
            return true;
            RedPacketServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id);
          }
          label773:
          l1 = 30000L;
        }
        label780:
        k = 0;
      }
    }
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
      return FileUtils.a(new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "red_packet_config2017_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
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
          break label346;
        }
        paramString = paramString.id + "," + paramString.realBegin;
        localObject = ((StringBuilder)localObject).append(paramString).append(", endpor=");
        if (localPortalConfig == null) {
          break label352;
        }
      }
      label346:
      label352:
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
  
  public long[] a()
  {
    this.jdField_b_of_type_Boolean = true;
    PortalManager.PortalConfig localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (f > 0L)
    {
      long l2 = f;
      long l3 = i;
      l1 = (l1 - g) * l3 + l2;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("setGrabStartTime");
        if (localPortalConfig != null) {
          localStringBuilder.append(", ").append(localPortalConfig.id).append(", ").append(localPortalConfig.type).append(", ").append(localPortalConfig.useTime).append(", ").append(localPortalConfig.countTime).append(", ").append(l1).append(", ").append(localPortalConfig.realEnd);
        }
        QLog.d("PortalManager", 2, localStringBuilder.toString());
      }
      if ((localPortalConfig == null) || (localPortalConfig.type != 2) || ((localPortalConfig.useTime == 0L) && (localPortalConfig.countTime + l1 >= localPortalConfig.realEnd)) || ((localPortalConfig.useTime > 0L) && (localPortalConfig.useTime + localPortalConfig.countTime >= localPortalConfig.realEnd)) || ((localPortalConfig.useTime > 0L) && (localPortalConfig.useTime + localPortalConfig.countTime <= l1)) || (l1 > localPortalConfig.realEnd)) {
        return null;
      }
      if (localPortalConfig.useTime == 0L)
      {
        localPortalConfig.useTime = l1;
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077E8", "0X80077E8", 0, 0, "", "", l1 + "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077EB", "0X80077EB", 0, 0, a() + "", "", "", "");
      }
      l1 = localPortalConfig.countTime - l1 + localPortalConfig.useTime;
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(12);
      a(true, 12, l1, Long.valueOf(localPortalConfig.useTime));
      return new long[] { localPortalConfig.countTime, l1 };
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;
    }
    return -1;
  }
  
  public void b()
  {
    a(true, 100, 0L, null);
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 2);
  }
  
  public int c()
  {
    PortalManager.RedPacketConfig localRedPacketConfig2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
    PortalManager.RedPacketConfig localRedPacketConfig1 = localRedPacketConfig2;
    if (localRedPacketConfig2 == null) {
      localRedPacketConfig1 = a();
    }
    return localRedPacketConfig1.version;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "clearData");
    }
    File localFile = new File(BaseApplicationImpl.sApplication.getFilesDir(), "red_packet_config2017_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if ((localFile.delete()) && (!localFile.delete()) && (localFile.delete())) {}
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "canRefreshMessage : activityEndTime = " + this.j);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)) {}
    do
    {
      do
      {
        long l1;
        long l2;
        do
        {
          return false;
          if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) || (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null)) {
            break;
          }
          l1 = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realBegin;
          l2 = NetConnInfoCenter.getServerTimeMillis();
        } while ((l1 - l2 <= 600000L) || (l2 - this.j < 300000L));
        return true;
      } while ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null));
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) || (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)) {
        break;
      }
    } while (NetConnInfoCenter.getServerTimeMillis() - this.j < 300000L);
    return true;
    return true;
  }
  
  public void d()
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
      label82:
      this.jdField_e_of_type_Int = 0;
      this.jdField_b_of_type_Int = 4;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label82;
    }
  }
  
  public boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "hasNextPortal, " + this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig);
    }
    return this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null;
  }
  
  public void e()
  {
    ((Vibrator)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("vibrator")).vibrate(300L);
  }
  
  public void f()
  {
    ArrayList localArrayList;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)
    {
      localArrayList = (ArrayList)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id);
      if (localArrayList != null) {
        break label132;
      }
      localArrayList = new ArrayList(60);
      localArrayList.add(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id, localArrayList);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(15)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(15, 600000L);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 1) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077E4", "0X80077E4", 0, 0, "", "", "", "");
      }
      return;
      label132:
      localArrayList.add(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    }
  }
  
  public void g()
  {
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (!this.jdField_b_of_type_Boolean))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 1) {
        break label61;
      }
    }
    label61:
    for (String str = "1";; str = "2")
    {
      ReportController.b(localQQAppInterface, "dc01440", "", "", "0X80077E2", "0X80077E2", 0, 0, str, "", "", "");
      return;
    }
  }
  
  public void h()
  {
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 1) {
        break label54;
      }
    }
    label54:
    for (String str = "1";; str = "2")
    {
      ReportController.b(localQQAppInterface, "dc01440", "", "", "0X80077E3", "0X80077E3", 0, 0, str, "", "", "");
      return;
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
        j();
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
      this.jdField_a_of_type_AndroidOsHandler.post(new PortalManager.reportRunnable(this, this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, d(), ((Long)paramMessage.obj).longValue(), false));
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
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) {}
      for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.emptyMsg;; paramMessage = "没中红包，继续刷")
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
    //   2: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 239
    //   10: iconst_2
    //   11: ldc_w 1994
    //   14: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 1306	com/tencent/mobileqq/portal/PortalManager:jdField_c_of_type_Boolean	Z
    //   22: aload_0
    //   23: getfield 1135	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig	Lcom/tencent/mobileqq/portal/PortalManager$PortalConfig;
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 134	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   31: invokevirtual 1389	android/support/v4/util/SparseArrayCompat:size	()I
    //   34: ifle +60 -> 94
    //   37: aload_1
    //   38: getfield 1294	com/tencent/mobileqq/portal/PortalManager$PortalConfig:useTime	J
    //   41: lconst_0
    //   42: lcmp
    //   43: ifle +51 -> 94
    //   46: aload_0
    //   47: getfield 188	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   50: new 1966	com/tencent/mobileqq/portal/PortalManager$reportRunnable
    //   53: dup
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 134	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   59: invokevirtual 1970	android/support/v4/util/SparseArrayCompat:clone	()Landroid/support/v4/util/SparseArrayCompat;
    //   62: iconst_1
    //   63: aload_0
    //   64: getfield 1971	com/tencent/mobileqq/portal/PortalManager:jdField_c_of_type_Int	I
    //   67: aload_0
    //   68: getfield 1972	com/tencent/mobileqq/portal/PortalManager:jdField_d_of_type_Int	I
    //   71: aload_0
    //   72: invokespecial 1974	com/tencent/mobileqq/portal/PortalManager:d	()I
    //   75: aload_1
    //   76: getfield 1294	com/tencent/mobileqq/portal/PortalManager$PortalConfig:useTime	J
    //   79: iconst_1
    //   80: invokespecial 1977	com/tencent/mobileqq/portal/PortalManager$reportRunnable:<init>	(Lcom/tencent/mobileqq/portal/PortalManager;Landroid/support/v4/util/SparseArrayCompat;IIIIJZ)V
    //   83: invokevirtual 1615	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   86: pop
    //   87: aload_0
    //   88: getfield 134	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   91: invokevirtual 1978	android/support/v4/util/SparseArrayCompat:clear	()V
    //   94: aload_0
    //   95: getfield 153	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   98: invokevirtual 1389	android/support/v4/util/SparseArrayCompat:size	()I
    //   101: ifle +39 -> 140
    //   104: aload_0
    //   105: getfield 188	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   108: new 1966	com/tencent/mobileqq/portal/PortalManager$reportRunnable
    //   111: dup
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 153	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   117: invokevirtual 1970	android/support/v4/util/SparseArrayCompat:clone	()Landroid/support/v4/util/SparseArrayCompat;
    //   120: iconst_2
    //   121: iconst_0
    //   122: iconst_0
    //   123: iconst_0
    //   124: lconst_0
    //   125: iconst_1
    //   126: invokespecial 1977	com/tencent/mobileqq/portal/PortalManager$reportRunnable:<init>	(Lcom/tencent/mobileqq/portal/PortalManager;Landroid/support/v4/util/SparseArrayCompat;IIIIJZ)V
    //   129: invokevirtual 1615	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   132: pop
    //   133: aload_0
    //   134: getfield 153	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   137: invokevirtual 1978	android/support/v4/util/SparseArrayCompat:clear	()V
    //   140: aload_0
    //   141: getfield 188	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   144: iconst_1
    //   145: invokevirtual 1124	android/os/Handler:removeMessages	(I)V
    //   148: aload_0
    //   149: getfield 188	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   152: bipush 15
    //   154: invokevirtual 1124	android/os/Handler:removeMessages	(I)V
    //   157: aload_0
    //   158: getfield 195	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   161: aconst_null
    //   162: invokevirtual 1997	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   165: aload_0
    //   166: getfield 167	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   169: aload_0
    //   170: invokevirtual 2000	com/tencent/mobileqq/app/QQAppInterface:unRegistObserver	(Lmqq/observer/BusinessObserver;)V
    //   173: aload_0
    //   174: getfield 167	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   177: aload_0
    //   178: getfield 165	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppFriendListObserver	Lcom/tencent/mobileqq/app/FriendListObserver;
    //   181: invokevirtual 2003	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   184: aload_0
    //   185: invokevirtual 1545	com/tencent/mobileqq/portal/PortalManager:d	()V
    //   188: aload_0
    //   189: getfield 167	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   192: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   195: aload_0
    //   196: getfield 208	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_Agmv	Lagmv;
    //   199: invokevirtual 2007	com/tencent/qphone/base/util/BaseApplication:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   202: aload_0
    //   203: getfield 1579	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidMediaSoundPool	Landroid/media/SoundPool;
    //   206: ifnull +15 -> 221
    //   209: aload_0
    //   210: getfield 1579	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidMediaSoundPool	Landroid/media/SoundPool;
    //   213: invokevirtual 2010	android/media/SoundPool:release	()V
    //   216: aload_0
    //   217: aconst_null
    //   218: putfield 1579	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidMediaSoundPool	Landroid/media/SoundPool;
    //   221: aload_0
    //   222: monitorexit
    //   223: return
    //   224: astore_1
    //   225: ldc 239
    //   227: iconst_1
    //   228: ldc_w 1994
    //   231: aload_1
    //   232: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   235: goto -33 -> 202
    //   238: astore_1
    //   239: aload_0
    //   240: monitorexit
    //   241: aload_1
    //   242: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	PortalManager
    //   26	50	1	localPortalConfig	PortalManager.PortalConfig
    //   224	8	1	localException	Exception
    //   238	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   188	202	224	java/lang/Exception
    //   2	17	238	finally
    //   17	94	238	finally
    //   94	140	238	finally
    //   140	188	238	finally
    //   188	202	238	finally
    //   202	221	238	finally
    //   225	235	238	finally
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "testplaySound, onLoadComplete, " + paramInt1 + ", " + paramInt2 + ", mPlayCountDownStreamId=" + this.jdField_e_of_type_Int + ", mPlayCountDownState=" + this.jdField_b_of_type_Int);
    }
    int k = 0;
    if ((k >= 5) || (this.jdField_a_of_type_ArrayOfInt[k] == paramInt1)) {
      if (k != 5) {
        break label104;
      }
    }
    label104:
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
      QLog.d("PortalManager", 2, "onReceive, " + paramInt + ", " + paramBoolean + ", " + paramBundle);
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
      localObject3 = paramBundle.getString("k_url");
      k = paramBundle.getInt("k_id", -1);
      int i2 = paramBundle.getInt("k_code", -1);
      m = paramBundle.getInt("k_money", -1);
      int i3 = paramBundle.getInt("k_type", -1);
      bool = paramBundle.getBoolean("k_s_follow", true);
      n = paramBundle.getInt("key_award_id", -1);
      i1 = paramBundle.getInt("key_promotion_id", -1);
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
            QLog.d("PortalManager", 2, "onReceive cmd = CMD_RESULT, portId = " + k + ", url = " + (String)localObject3 + ", showType = " + paramInt + ", money = " + m + ", awardId = " + n + ", promotionId = " + i1);
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
            label477:
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
              ((PortalManager.ResultData)localObject2).jdField_b_of_type_AndroidGraphicsBitmap = a(str, (String)localObject1);
              ((PortalManager.ResultData)localObject2).jdField_c_of_type_AndroidGraphicsBitmap = a(localLogoConfig.nameMD5, "hb_name_path");
              break label477;
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
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
          if (localPortalConfig != null)
          {
            localObject2 = localPortalConfig.emptyMsg;
            label615:
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
            break label690;
          }
          localPortalConfig.hbCnt += 1;
        }
        while (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(6))
        {
          a(false, 6, 2000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
          return;
          localObject2 = "没中红包，继续刷";
          break label615;
          label690:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager
 * JD-Core Version:    0.7.0.1
 */