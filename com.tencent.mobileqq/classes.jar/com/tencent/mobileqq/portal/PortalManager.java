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
  static int jdField_a_of_type_Int = 1;
  static long jdField_a_of_type_Long = 2500L;
  private static PortalManager.TimerConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig;
  public static final String a;
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private static Comparator<PortalManager.TimerConfig> jdField_a_of_type_JavaUtilComparator;
  public static boolean a = false;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(File.separator);
    localStringBuilder.append("redPacketRes/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_JavaUtilComparator = new PortalManager.3();
    jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig = new PortalManager.TimerConfig(null);
    jdField_a_of_type_JavaTextSimpleDateFormat = null;
    f = 0L;
    g = 0L;
    i = 0L;
    jdField_a_of_type_ArrayOfBoolean = new boolean[] { 0, 0, 0, 0, 0 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2131230752, 2131230754, 2131230753, 2131230751, 2131230755 };
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
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("PortalManager", 1, "", paramQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
  }
  
  private static int a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int m = -1;
    int k = m;
    if (!bool)
    {
      if ("hb_icon_path".equals(paramString)) {
        return 2130844937;
      }
      if ("hb_name_path".equals(paramString)) {
        return 2130845287;
      }
      if ("hb_banner_path".equals(paramString)) {
        return -1;
      }
      if ("hb_yure_star_logo_path".equals(paramString)) {
        return 2130845455;
      }
      if ("hb_yure_star_name_path".equals(paramString)) {
        return 2130845456;
      }
      if ("hb_busi_logo_path".equals(paramString)) {
        return 2130845277;
      }
      if ("hb_yure_busi_name_path".equals(paramString)) {
        return 2130845278;
      }
      if ("hb_bg_name_path".equals(paramString)) {
        return 2130845289;
      }
      if ("hb_leftclound_name_path".equals(paramString)) {
        return 2130845283;
      }
      if ("hb_rightclound_name_path".equals(paramString)) {
        return 2130845284;
      }
      if ("hb_luckybag_name_path".equals(paramString)) {
        return 2130845405;
      }
      k = m;
      if ("hb_luckybag_ing_name_path".equals(paramString)) {
        k = 2130845406;
      }
    }
    return k;
  }
  
  public static long a(String paramString)
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    try
    {
      long l = jdField_a_of_type_JavaTextSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (ParseException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "", paramString);
      }
    }
    return -1L;
  }
  
  public static Bitmap a(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = GlobalImageCache.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("red_packet_");
        localStringBuilder.append(paramString);
        paramString = (Bitmap)((MQLruCache)localObject).get(localStringBuilder.toString());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getBitmapFromCache, hit=");
          if (paramString != null)
          {
            bool = true;
            ((StringBuilder)localObject).append(bool);
            QLog.d("PortalManager", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PortalManager", 2, "preloadDrawableById Exception", paramString);
        }
        return null;
      }
      boolean bool = false;
    }
  }
  
  public static Bitmap a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("preloadDrawableById, key=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", id=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    StringBuilder localStringBuilder1 = null;
    MQLruCache localMQLruCache1 = null;
    Object localObject2 = localObject1;
    Object localObject4 = localStringBuilder1;
    try
    {
      MQLruCache localMQLruCache2 = GlobalImageCache.a;
      localObject2 = localObject1;
      localObject4 = localStringBuilder1;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localObject2 = localObject1;
      localObject4 = localStringBuilder1;
      localStringBuilder2.append("red_packet_");
      localObject2 = localObject1;
      localObject4 = localStringBuilder1;
      localStringBuilder2.append(paramString);
      localObject2 = localObject1;
      localObject4 = localStringBuilder1;
      localObject1 = (Bitmap)localMQLruCache2.get(localStringBuilder2.toString());
      if (localObject1 != null) {}
      try
      {
        if (!QLog.isColorLevel()) {
          return localObject1;
        }
        QLog.d("PortalManager", 2, "preloadDrawableById, already exist");
        return localObject1;
      }
      catch (Exception localException2)
      {
        paramString = (String)localObject1;
        localObject1 = localException2;
      }
      catch (OutOfMemoryError paramString)
      {
        localObject4 = localObject1;
        break label326;
      }
      localObject4 = (PortalManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MGR_PORTAL);
      localObject2 = localMQLruCache1;
      if (localObject4 != null) {
        localObject2 = ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC;
      }
      localObject2 = a("", paramInt, (OlympicDPC)localObject2, 2);
      if (localObject2 != null)
      {
        localObject2 = (Bitmap)((Pair)localObject2).second;
        localObject1 = localObject2;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        break label348;
      }
      localObject2 = localObject1;
      localObject4 = localObject1;
      localMQLruCache1 = GlobalImageCache.a;
      localObject2 = localObject1;
      localObject4 = localObject1;
      localStringBuilder1 = new StringBuilder();
      localObject2 = localObject1;
      localObject4 = localObject1;
      localStringBuilder1.append("red_packet_");
      localObject2 = localObject1;
      localObject4 = localObject1;
      localStringBuilder1.append(paramString);
      localObject2 = localObject1;
      localObject4 = localObject1;
      localMQLruCache1.put(localStringBuilder1.toString(), localObject1);
      return localObject1;
    }
    catch (Exception localException1)
    {
      paramString = localException2;
      localObject3 = paramString;
      if (!QLog.isColorLevel()) {
        break label348;
      }
      QLog.e("PortalManager", 2, "preloadDrawableById Exception", localException1);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    label326:
    Object localObject3 = localObject4;
    if (QLog.isColorLevel())
    {
      QLog.e("PortalManager", 2, "preloadDrawableById OutOfMemoryError", paramString);
      localObject3 = localObject4;
    }
    label348:
    return localObject3;
    return localException1;
  }
  
  public static Bitmap a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getBitmap, path=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", defaultPath=");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(BaseApplicationImpl.getApplication().getFilesDir());
    ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
    String str2 = ((StringBuilder)localObject1).toString();
    Object localObject4 = null;
    Object localObject3 = null;
    localObject1 = localObject4;
    try
    {
      if (TextUtils.isEmpty(paramString1))
      {
        localObject1 = localObject4;
        return a(paramString2, true);
      }
      localObject1 = localObject4;
      Object localObject2 = new StringBuilder();
      localObject1 = localObject4;
      ((StringBuilder)localObject2).append("red_packet_");
      localObject1 = localObject4;
      ((StringBuilder)localObject2).append(paramString1);
      localObject1 = localObject4;
      String str1 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject4;
      localObject2 = (Bitmap)GlobalImageCache.a.get(str1);
      if (localObject2 != null) {}
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager", 2, "getBitmap, hit cache");
        }
        return localObject2;
      }
      catch (Exception paramString2)
      {
        try
        {
          localObject1 = (PortalManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MGR_PORTAL);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str2);
          localStringBuilder.append(paramString1);
          paramString1 = a(localStringBuilder.toString(), -1, ((PortalManager)localObject1).jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC, 1);
          if (paramString1 != null) {
            paramString1 = (Bitmap)paramString1.second;
          } else {
            paramString1 = (String)localObject2;
          }
        }
        catch (Throwable localThrowable)
        {
          paramString1 = localObject3;
          localObject1 = localObject4;
          if (!QLog.isColorLevel()) {
            break label331;
          }
          localObject1 = localObject4;
          paramString1 = new StringBuilder();
          localObject1 = localObject4;
          paramString1.append("getBitmap, exception=");
          localObject1 = localObject4;
          paramString1.append(localThrowable.getMessage());
          localObject1 = localObject4;
          QLog.e("PortalManager", 2, paramString1.toString(), localThrowable);
          paramString1 = localObject3;
          if (paramString1 == null) {
            break label349;
          }
          localObject1 = paramString1;
          GlobalImageCache.a.put(str1, paramString1);
          return paramString1;
          localObject1 = paramString1;
          paramString2 = a(paramString2, true);
          localObject1 = paramString2;
          paramString1 = paramString2;
          if (!QLog.isColorLevel()) {
            return paramString1;
          }
        }
        paramString2 = paramString2;
        localObject1 = localObject2;
      }
      label331:
      label349:
      localObject1 = paramString2;
      QLog.d("PortalManager", 2, "getBitmap, using default bitmap");
      return paramString2;
    }
    catch (Exception paramString2)
    {
      paramString1 = (String)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("PortalManager", 2, "", paramString2);
        paramString1 = (String)localObject1;
      }
    }
    return paramString1;
  }
  
  public static Bitmap a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager", 2, new Object[] { "getDefaultIconBitmap", paramString });
        }
        localObject1 = GlobalImageCache.a;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("red_packet_");
        ((StringBuilder)localObject2).append(paramString);
        localObject2 = (Bitmap)((MQLruCache)localObject1).get(((StringBuilder)localObject2).toString());
        if (localObject2 != null) {
          return localObject2;
        }
        int k = a(paramString);
        if (k < 0) {
          return null;
        }
        localObject1 = (PortalManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MGR_PORTAL);
        if (localObject1 != null)
        {
          localObject1 = ((PortalManager)localObject1).jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC;
          Object localObject3 = a("", k, (OlympicDPC)localObject1, 2);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = (Bitmap)((Pair)localObject3).second;
          }
          if ((localObject1 != null) && (paramBoolean))
          {
            localObject2 = GlobalImageCache.a;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("red_packet_");
            ((StringBuilder)localObject3).append(paramString);
            ((MQLruCache)localObject2).put(((StringBuilder)localObject3).toString(), localObject1);
          }
          return localObject1;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PortalManager", 2, "", paramString);
        }
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PortalManager", 2, "", paramString);
        }
        return null;
      }
      Object localObject1 = null;
    }
  }
  
  private static Pair<Integer, Bitmap> a(String paramString, int paramInt1, OlympicDPC paramOlympicDPC, int paramInt2)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    Object localObject1 = null;
    StringBuilder localStringBuilder = null;
    if ((bool) && (paramInt1 < 0)) {
      return null;
    }
    int m = 0;
    try
    {
      try
      {
        Object localObject3 = new BitmapFactory.Options();
        if (paramOlympicDPC != null)
        {
          ((BitmapFactory.Options)localObject3).inPurgeable = true;
          ((BitmapFactory.Options)localObject3).inInputShareable = true;
          if (paramOlympicDPC.jdField_d_of_type_Boolean)
          {
            ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.ARGB_8888;
          }
          else
          {
            ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.RGB_565;
            ((BitmapFactory.Options)localObject3).inDither = true;
          }
          if (paramOlympicDPC.jdField_b_of_type_Boolean) {
            ((BitmapFactory.Options)localObject3).inSampleSize = 2;
          } else {
            ((BitmapFactory.Options)localObject3).inSampleSize = 1;
          }
        }
        else
        {
          ((BitmapFactory.Options)localObject3).inPurgeable = true;
          ((BitmapFactory.Options)localObject3).inInputShareable = true;
          ((BitmapFactory.Options)localObject3).inSampleSize = 1;
          ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.RGB_565;
          ((BitmapFactory.Options)localObject3).inDither = true;
        }
        if (paramInt2 == 1)
        {
          localObject3 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject3);
          paramOlympicDPC = (OlympicDPC)localObject3;
        }
        else if (paramInt2 == 2)
        {
          localObject3 = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), paramInt1, (BitmapFactory.Options)localObject3);
          paramOlympicDPC = (OlympicDPC)localObject3;
        }
        else
        {
          paramOlympicDPC = null;
        }
        localObject1 = paramOlympicDPC;
        paramInt1 = 0;
        paramOlympicDPC = localObject2;
      }
      catch (Exception paramOlympicDPC)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeBitmap Exception:");
          localStringBuilder.append(paramOlympicDPC.toString());
          localStringBuilder.append(",filePath:");
          localStringBuilder.append(paramString);
          QLog.d("PortalManager", 2, localStringBuilder.toString());
        }
        localStringBuilder = null;
        paramInt2 = 0;
        k = 1;
        paramOlympicDPC = (OlympicDPC)localObject1;
        localObject1 = localStringBuilder;
        break label378;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      int k;
      label280:
      break label280;
    }
    if ((paramOlympicDPC != null) && (!paramOlympicDPC.jdField_b_of_type_Boolean))
    {
      paramOlympicDPC.jdField_b_of_type_Boolean = true;
      if (!paramOlympicDPC.jdField_c_of_type_Boolean)
      {
        paramOlympicDPC = a(paramString, paramInt1, paramOlympicDPC, paramInt2);
        localObject1 = (Bitmap)paramOlympicDPC.second;
        break label329;
      }
    }
    localObject1 = null;
    paramOlympicDPC = localStringBuilder;
    label329:
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeBitmap OOM|path:");
      localStringBuilder.append(paramString);
      QLog.d("PortalManager", 2, localStringBuilder.toString());
    }
    paramInt1 = 1;
    k = 0;
    paramInt2 = paramInt1;
    label378:
    if (paramOlympicDPC != null)
    {
      if (((Integer)paramOlympicDPC.first).intValue() == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = ((Integer)paramOlympicDPC.first).intValue();
      }
    }
    else if (paramInt2 != 0)
    {
      paramInt1 = 2;
    }
    else
    {
      paramInt1 = m;
      if (k != 0) {
        paramInt1 = 3;
      }
    }
    if ((localObject1 == null) && (paramInt2 == 0) && (k == 0)) {}
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
      label486:
      long l;
      break label486;
    }
    paramString = new Pair(Integer.valueOf(paramInt1), localObject1);
    if (QLog.isColorLevel())
    {
      if (localObject1 == null) {
        l = 0L;
      } else {
        l = ((Bitmap)localObject1).getRowBytes() * ((Bitmap)localObject1).getHeight() / 1024;
      }
      paramOlympicDPC = new StringBuilder();
      paramOlympicDPC.append("decodeBitmap|size:");
      paramOlympicDPC.append(l);
      paramOlympicDPC.append("KB,errCode:");
      paramOlympicDPC.append(paramInt1);
      QLog.d("PortalManager", 2, paramOlympicDPC.toString());
    }
    return paramString;
  }
  
  public static Pair<String, String> a(XmlPullParser paramXmlPullParser, String paramString)
  {
    Object localObject2 = "";
    if (paramXmlPullParser == null) {
      return new Pair("", "");
    }
    int k = paramXmlPullParser.next();
    Object localObject4;
    for (Object localObject1 = ""; k != 1; localObject1 = localObject4)
    {
      String str = paramXmlPullParser.getName();
      if ((k == 3) && (str.equalsIgnoreCase(paramString))) {
        break;
      }
      Object localObject3 = localObject2;
      localObject4 = localObject1;
      if (k == 2) {
        if (str.equalsIgnoreCase("url"))
        {
          localObject3 = paramXmlPullParser.nextText();
          localObject4 = localObject1;
        }
        else
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (str.equalsIgnoreCase("md5"))
          {
            localObject4 = paramXmlPullParser.nextText();
            localObject3 = localObject2;
          }
        }
      }
      k = paramXmlPullParser.next();
      localObject2 = localObject3;
    }
    return new Pair(localObject2, localObject1);
  }
  
  public static PortalManager.RedPacketConfig a(String paramString, int paramInt1, int paramInt2, ArrayList<Integer> paramArrayList)
  {
    Object localObject2 = "Activity";
    Object localObject1 = "BBanner";
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    PortalManager.RedPacketConfig localRedPacketConfig = new PortalManager.RedPacketConfig();
    localRedPacketConfig.version = paramInt1;
    localRedPacketConfig.taskId = paramInt2;
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        paramInt1 = localXmlPullParser.getEventType();
        Object localObject3 = null;
        if (paramInt1 != 1)
        {
          Object localObject5 = localObject2;
          localObject4 = localObject1;
          Object localObject6 = localObject3;
          if (paramInt1 != 2) {
            break label3909;
          }
          Object localObject7 = localXmlPullParser.getName();
          if (((String)localObject7).equalsIgnoreCase("Common"))
          {
            paramInt1 = localXmlPullParser.next();
            localObject5 = localObject2;
            localObject4 = localObject1;
            localObject6 = localObject3;
            if (paramInt1 == 1) {
              break label3909;
            }
            localObject5 = localXmlPullParser.getName();
            if ((paramInt1 == 3) && (((String)localObject5).equalsIgnoreCase("Common")))
            {
              localObject5 = localObject2;
              localObject4 = localObject1;
              localObject6 = localObject3;
              break label3909;
            }
            localObject4 = localObject3;
            if (paramInt1 == 2) {
              if (((String)localObject5).equalsIgnoreCase("GrabReqInterval"))
              {
                localRedPacketConfig.grebInterval = Long.valueOf(localXmlPullParser.nextText()).longValue();
                localObject4 = localObject3;
              }
              else if (((String)localObject5).equalsIgnoreCase("ReportActiveInterval"))
              {
                localRedPacketConfig.reportActiveInterval = Long.valueOf(localXmlPullParser.nextText()).longValue();
                localObject4 = localObject3;
              }
              else if (((String)localObject5).equalsIgnoreCase("ReportNormalInterval"))
              {
                localRedPacketConfig.reportNormalInterval = Long.valueOf(localXmlPullParser.nextText()).longValue();
                localObject4 = localObject3;
              }
              else if (((String)localObject5).equalsIgnoreCase("ShareTimes"))
              {
                localRedPacketConfig.shareBaseLine = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                localObject4 = localObject3;
              }
              else if (((String)localObject5).equalsIgnoreCase("ComboNumber"))
              {
                if (localRedPacketConfig.comboNumberConfigs == null) {
                  localRedPacketConfig.comboNumberConfigs = new ArrayList();
                }
                localObject4 = new PortalManager.ComboNumber();
                localRedPacketConfig.comboNumberConfigs.add(localObject4);
              }
              else if (((String)localObject5).equalsIgnoreCase("Number"))
              {
                localObject4 = localObject3;
                if (localObject3 != null)
                {
                  ((PortalManager.ComboNumber)localObject3).number = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                  localObject4 = localObject3;
                }
              }
              else if (((String)localObject5).equalsIgnoreCase("NumberImage"))
              {
                localObject4 = localObject3;
                if (localObject3 != null)
                {
                  localObject4 = a(localXmlPullParser, (String)localObject5);
                  ((PortalManager.ComboNumber)localObject3).numberImageUrl = ((String)((Pair)localObject4).first);
                  ((PortalManager.ComboNumber)localObject3).numberImageMD5 = ((String)((Pair)localObject4).second);
                  localObject4 = localObject3;
                }
              }
              else
              {
                localObject4 = localObject3;
                if (((String)localObject5).equalsIgnoreCase("FlowerImage"))
                {
                  localObject4 = localObject3;
                  if (localObject3 != null)
                  {
                    localObject5 = a(localXmlPullParser, (String)localObject5);
                    if (TextUtils.isEmpty(((PortalManager.ComboNumber)localObject3).flowerImageUrl))
                    {
                      ((PortalManager.ComboNumber)localObject3).flowerImageUrl = ((String)((Pair)localObject5).first);
                      ((PortalManager.ComboNumber)localObject3).flowerImageMD5 = ((String)((Pair)localObject5).second);
                      localObject4 = localObject3;
                    }
                    else
                    {
                      localObject4 = localObject3;
                      if (TextUtils.isEmpty(((PortalManager.ComboNumber)localObject3).flowerImage2Url))
                      {
                        ((PortalManager.ComboNumber)localObject3).flowerImage2Url = ((String)((Pair)localObject5).first);
                        ((PortalManager.ComboNumber)localObject3).flowerImage2MD5 = ((String)((Pair)localObject5).second);
                        localObject4 = localObject3;
                      }
                    }
                  }
                }
              }
            }
            paramInt1 = localXmlPullParser.next();
            localObject3 = localObject4;
            continue;
          }
          if (((String)localObject7).equalsIgnoreCase("ConfigId"))
          {
            localRedPacketConfig.id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            localObject5 = localObject2;
            localObject4 = localObject1;
            localObject6 = localObject3;
            break label3909;
          }
          boolean bool = ((String)localObject7).equalsIgnoreCase((String)localObject1);
          String str = "Id";
          if (bool)
          {
            localObject7 = new PortalManager.BannerConfig(null);
            paramInt1 = localXmlPullParser.next();
            localObject5 = localObject2;
            localObject4 = localObject1;
            localObject6 = localObject3;
            if (paramInt1 == 1) {
              break label3909;
            }
            localObject4 = localXmlPullParser.getName();
            if ((paramInt1 == 3) && (((String)localObject4).equalsIgnoreCase((String)localObject1)))
            {
              localRedPacketConfig.bannerConfigs.add(localObject7);
              localObject5 = localObject2;
              localObject4 = localObject1;
              localObject6 = localObject3;
              break label3909;
            }
            if (paramInt1 != 2) {
              break label3912;
            }
            if (((String)localObject4).equalsIgnoreCase(str))
            {
              ((PortalManager.BannerConfig)localObject7).id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              break label3912;
            }
            if (((String)localObject4).equalsIgnoreCase("Begin"))
            {
              ((PortalManager.BannerConfig)localObject7).uiBegin = a(localXmlPullParser.nextText());
            }
            else if (((String)localObject4).equalsIgnoreCase("End"))
            {
              ((PortalManager.BannerConfig)localObject7).uiEnd = a(localXmlPullParser.nextText());
            }
            else if (((String)localObject4).equalsIgnoreCase("Image"))
            {
              localObject4 = a(localXmlPullParser, (String)localObject4);
              ((PortalManager.BannerConfig)localObject7).bannerImg = ((String)((Pair)localObject4).first);
              ((PortalManager.BannerConfig)localObject7).bannarMd5 = ((String)((Pair)localObject4).second);
            }
            else if (((String)localObject4).equalsIgnoreCase("JumpH5"))
            {
              ((PortalManager.BannerConfig)localObject7).jumpUrl = localXmlPullParser.nextText();
            }
            paramInt1 = localXmlPullParser.next();
            continue;
          }
          str = "Id";
          localObject5 = localObject2;
          localObject4 = localObject1;
          localObject6 = localObject3;
          if (!((String)localObject7).equalsIgnoreCase((String)localObject2)) {
            break label3909;
          }
          localObject7 = new PortalManager.PortalConfig();
          paramInt1 = localXmlPullParser.next();
          localObject5 = localObject2;
          localObject4 = localObject1;
          localObject6 = localObject3;
          if (paramInt1 == 1) {
            break label3909;
          }
          localObject6 = localXmlPullParser.getName();
          if ((paramInt1 == 3) && (((String)localObject6).equalsIgnoreCase((String)localObject2)))
          {
            if (((PortalManager.PortalConfig)localObject7).realEnd >= ((PortalManager.PortalConfig)localObject7).realBegin)
            {
              localRedPacketConfig.portalConfigs.add(localObject7);
              localObject5 = localObject2;
              localObject4 = localObject1;
              localObject6 = localObject3;
              break label3909;
            }
            localObject5 = localObject2;
            localObject4 = localObject1;
            localObject6 = localObject3;
            if (!QLog.isColorLevel()) {
              break label3909;
            }
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("parseConfig");
            ((StringBuilder)localObject4).append(((PortalManager.PortalConfig)localObject7).realBegin);
            ((StringBuilder)localObject4).append(", ");
            ((StringBuilder)localObject4).append(((PortalManager.PortalConfig)localObject7).realEnd);
            QLog.d("PortalManager", 2, ((StringBuilder)localObject4).toString());
            localObject5 = localObject2;
            localObject4 = localObject1;
            localObject6 = localObject3;
            break label3909;
          }
          if (paramInt1 != 2) {
            break label3926;
          }
          if (((String)localObject6).equalsIgnoreCase(str))
          {
            ((PortalManager.PortalConfig)localObject7).id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            break label3915;
          }
          if (((String)localObject6).equalsIgnoreCase("Type"))
          {
            ((PortalManager.PortalConfig)localObject7).type = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            break label3915;
          }
          if (((String)localObject6).equalsIgnoreCase("Mode"))
          {
            ((PortalManager.PortalConfig)localObject7).mode = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            break label3915;
          }
          long l;
          if (((String)localObject6).equalsIgnoreCase("BeginTime"))
          {
            l = a(localXmlPullParser.nextText());
            ((PortalManager.PortalConfig)localObject7).realBegin = l;
            ((PortalManager.PortalConfig)localObject7).uiBegin = l;
            break label3915;
          }
          if (((String)localObject6).equalsIgnoreCase("EndTime"))
          {
            l = a(localXmlPullParser.nextText());
            ((PortalManager.PortalConfig)localObject7).realEnd = l;
            ((PortalManager.PortalConfig)localObject7).uiEnd = l;
            break label3915;
          }
          if (((String)localObject6).equalsIgnoreCase("BackGroundImage"))
          {
            localObject4 = a(localXmlPullParser, (String)localObject6);
            ((PortalManager.PortalConfig)localObject7).bgImg = ((String)((Pair)localObject4).first);
            ((PortalManager.PortalConfig)localObject7).bgMd5 = ((String)((Pair)localObject4).second);
            break label3915;
          }
          if (((String)localObject6).equalsIgnoreCase("activityTime"))
          {
            ((PortalManager.PortalConfig)localObject7).rightMsg = localXmlPullParser.nextText();
            break label3915;
          }
          if (((String)localObject6).equalsIgnoreCase("scrollTime"))
          {
            ((PortalManager.PortalConfig)localObject7).scrollTime = (Integer.parseInt(localXmlPullParser.nextText()) * 1000);
            break label3915;
          }
          if (((String)localObject6).equalsIgnoreCase("Timer"))
          {
            ((PortalManager.PortalConfig)localObject7).countTime = (Integer.parseInt(localXmlPullParser.nextText()) * 1000);
            break label3915;
          }
          if (((String)localObject6).equalsIgnoreCase("GrabWording"))
          {
            ((PortalManager.PortalConfig)localObject7).grabMsg = localXmlPullParser.nextText();
            break label3915;
          }
          if (((String)localObject6).equalsIgnoreCase("NoRPWording"))
          {
            ((PortalManager.PortalConfig)localObject7).emptyMsg = localXmlPullParser.nextText();
            break label3915;
          }
          if (((String)localObject6).equalsIgnoreCase("LeftCloudImage"))
          {
            localObject4 = a(localXmlPullParser, (String)localObject6);
            ((PortalManager.PortalConfig)localObject7).leftCloudImageUrl = ((String)((Pair)localObject4).first);
            ((PortalManager.PortalConfig)localObject7).leftCloudImageMD5 = ((String)((Pair)localObject4).second);
            break label3915;
          }
          if (((String)localObject6).equalsIgnoreCase("RightCloudImage"))
          {
            localObject4 = a(localXmlPullParser, (String)localObject6);
            ((PortalManager.PortalConfig)localObject7).rightCloudImageURL = ((String)((Pair)localObject4).first);
            ((PortalManager.PortalConfig)localObject7).rightCloudImageMD5 = ((String)((Pair)localObject4).second);
            break label3915;
          }
          bool = ((String)localObject6).equalsIgnoreCase("Logo");
          if (bool)
          {
            localObject5 = new PortalManager.LogoConfig();
            ((PortalManager.PortalConfig)localObject7).logoList.add(localObject5);
            paramInt1 = localXmlPullParser.next();
            localObject4 = localObject1;
            if (paramInt1 == 1) {
              break label3919;
            }
            localObject4 = localXmlPullParser.getName();
            if ((paramInt1 != 3) || (!((String)localObject4).equalsIgnoreCase((String)localObject6)))
            {
              if (paramInt1 == 2) {
                if (((String)localObject4).equalsIgnoreCase("LogoImage"))
                {
                  localObject4 = a(localXmlPullParser, (String)localObject4);
                  ((PortalManager.LogoConfig)localObject5).logoImageUrl = ((String)((Pair)localObject4).first);
                  ((PortalManager.LogoConfig)localObject5).logoImageMD5 = ((String)((Pair)localObject4).second);
                }
                else if (((String)localObject4).equalsIgnoreCase("logoId"))
                {
                  ((PortalManager.LogoConfig)localObject5).logoId = Integer.parseInt(localXmlPullParser.nextText());
                }
                else if (((String)localObject4).equalsIgnoreCase("NameImage"))
                {
                  localObject4 = a(localXmlPullParser, (String)localObject4);
                  ((PortalManager.LogoConfig)localObject5).nameUrl = ((String)((Pair)localObject4).first);
                  ((PortalManager.LogoConfig)localObject5).nameMD5 = ((String)((Pair)localObject4).second);
                }
                else if (((String)localObject4).equalsIgnoreCase("GreetImage"))
                {
                  localObject4 = a(localXmlPullParser, (String)localObject4);
                  ((PortalManager.LogoConfig)localObject5).greetImageUrl = ((String)((Pair)localObject4).first);
                  ((PortalManager.LogoConfig)localObject5).greetImageMD5 = ((String)((Pair)localObject4).second);
                }
                else if (((String)localObject4).equalsIgnoreCase("padantImage"))
                {
                  localObject4 = a(localXmlPullParser, (String)localObject4);
                  ((PortalManager.LogoConfig)localObject5).padantImageUrl = ((String)((Pair)localObject4).first);
                  ((PortalManager.LogoConfig)localObject5).padantImageMD5 = ((String)((Pair)localObject4).second);
                }
                else if (((String)localObject4).equalsIgnoreCase("relationCompanyLogo"))
                {
                  localObject4 = a(localXmlPullParser, (String)localObject4);
                  ((PortalManager.LogoConfig)localObject5).relationCompanyLogoUrl = ((String)((Pair)localObject4).first);
                  ((PortalManager.LogoConfig)localObject5).relationCompanyLogoMD5 = ((String)((Pair)localObject4).second);
                }
                else if (((String)localObject4).equalsIgnoreCase("relationCompanyNameImage"))
                {
                  localObject4 = a(localXmlPullParser, (String)localObject4);
                  ((PortalManager.LogoConfig)localObject5).relationCompanyNameUrl = ((String)((Pair)localObject4).first);
                  ((PortalManager.LogoConfig)localObject5).relationCompanyNameMD5 = ((String)((Pair)localObject4).second);
                }
              }
              paramInt1 = localXmlPullParser.next();
              continue;
            }
          }
          else
          {
            localObject4 = localObject1;
            if (((String)localObject6).equalsIgnoreCase("Award"))
            {
              localObject5 = new PortalManager.AwardConfig();
              ((PortalManager.PortalConfig)localObject7).awardConfigList.add(localObject5);
              paramInt1 = localXmlPullParser.next();
              localObject1 = localObject4;
              if (paramInt1 != 1)
              {
                localObject1 = localXmlPullParser.getName();
                if ((paramInt1 == 3) && (((String)localObject1).equalsIgnoreCase((String)localObject6)))
                {
                  localObject1 = localObject4;
                }
                else
                {
                  if (paramInt1 == 2) {
                    if (((String)localObject1).equalsIgnoreCase("AwardId"))
                    {
                      ((PortalManager.AwardConfig)localObject5).awardId = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                    }
                    else if (((String)localObject1).equalsIgnoreCase("logoId"))
                    {
                      ((PortalManager.AwardConfig)localObject5).logoId = Integer.parseInt(localXmlPullParser.nextText());
                    }
                    else if (((String)localObject1).equalsIgnoreCase("AwardLogoType"))
                    {
                      ((PortalManager.AwardConfig)localObject5).awardType = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                    }
                    else if (((String)localObject1).equalsIgnoreCase("AwardLogo1Image"))
                    {
                      localObject1 = a(localXmlPullParser, (String)localObject1);
                      ((PortalManager.AwardConfig)localObject5).awardImg = ((String)((Pair)localObject1).first);
                      ((PortalManager.AwardConfig)localObject5).awardMd5 = ((String)((Pair)localObject1).second);
                    }
                    else if (((String)localObject1).equalsIgnoreCase("AwardLogo2Image"))
                    {
                      localObject1 = a(localXmlPullParser, (String)localObject1);
                      ((PortalManager.AwardConfig)localObject5).starImg = ((String)((Pair)localObject1).first);
                      ((PortalManager.AwardConfig)localObject5).starMd5 = ((String)((Pair)localObject1).second);
                    }
                    else if (((String)localObject1).equalsIgnoreCase("AwardLogoBGImage"))
                    {
                      localObject1 = a(localXmlPullParser, (String)localObject1);
                      ((PortalManager.AwardConfig)localObject5).ctfBgImg = ((String)((Pair)localObject1).first);
                      ((PortalManager.AwardConfig)localObject5).ctfBgMd5 = ((String)((Pair)localObject1).second);
                    }
                    else if (((String)localObject1).equalsIgnoreCase("Grettings"))
                    {
                      ((PortalManager.AwardConfig)localObject5).awardMsg = localXmlPullParser.nextText();
                    }
                    else if (((String)localObject1).equalsIgnoreCase("AwardName"))
                    {
                      ((PortalManager.AwardConfig)localObject5).awardTitle = localXmlPullParser.nextText();
                    }
                    else if (((String)localObject1).equalsIgnoreCase("AddWording"))
                    {
                      ((PortalManager.AwardConfig)localObject5).addMsg = localXmlPullParser.nextText();
                    }
                    else if (((String)localObject1).equalsIgnoreCase("PublicId"))
                    {
                      ((PortalManager.AwardConfig)localObject5).publicId = localXmlPullParser.nextText();
                    }
                    else if (((String)localObject1).equalsIgnoreCase("showPublic"))
                    {
                      ((PortalManager.AwardConfig)localObject5).showPublic = Integer.parseInt(localXmlPullParser.nextText());
                    }
                    else if (((String)localObject1).equalsIgnoreCase("PublicWording"))
                    {
                      ((PortalManager.AwardConfig)localObject5).publicWording = localXmlPullParser.nextText();
                    }
                  }
                  paramInt1 = localXmlPullParser.next();
                  continue;
                }
              }
            }
            else if (((String)localObject6).equalsIgnoreCase("NextActTime"))
            {
              ((PortalManager.PortalConfig)localObject7).nextActTime = localXmlPullParser.nextText();
              localObject1 = localObject4;
            }
            else if (((String)localObject6).equalsIgnoreCase("ActEndWording"))
            {
              ((PortalManager.PortalConfig)localObject7).actEndWording = localXmlPullParser.nextText();
              localObject1 = localObject4;
            }
            else if (((String)localObject6).equalsIgnoreCase("TipWording"))
            {
              ((PortalManager.PortalConfig)localObject7).countDownTips = localXmlPullParser.nextText();
              localObject1 = localObject4;
            }
            else if (((String)localObject6).equalsIgnoreCase("StarLuckytype"))
            {
              ((PortalManager.PortalConfig)localObject7).starLucytype = Integer.parseInt(localXmlPullParser.nextText());
              localObject1 = localObject4;
            }
            else if (((String)localObject6).equalsIgnoreCase("StarNoLuckytype"))
            {
              ((PortalManager.PortalConfig)localObject7).starNoLucyType = Integer.parseInt(localXmlPullParser.nextText());
              localObject1 = localObject4;
            }
            else
            {
              bool = ((String)localObject6).equalsIgnoreCase("sharePhoto");
              if (bool)
              {
                paramInt1 = localXmlPullParser.next();
                localObject1 = localObject4;
                if (paramInt1 != 1)
                {
                  localObject1 = localXmlPullParser.getName();
                  if ((paramInt1 == 3) && (((String)localObject1).equalsIgnoreCase((String)localObject6)))
                  {
                    localObject1 = localObject4;
                  }
                  else
                  {
                    if (paramInt1 == 2) {
                      if (((String)localObject1).equalsIgnoreCase("summary"))
                      {
                        localObject5 = localXmlPullParser.nextText();
                        localObject1 = localObject5;
                        if (TextUtils.isEmpty((CharSequence)localObject5)) {
                          localObject1 = "";
                        }
                        ((PortalManager.PortalConfig)localObject7).summaryForStar = ((String)localObject1);
                      }
                      else if (((String)localObject1).equalsIgnoreCase("structMsgTitle"))
                      {
                        localObject5 = localXmlPullParser.nextText();
                        localObject1 = localObject5;
                        if (TextUtils.isEmpty((CharSequence)localObject5)) {
                          localObject1 = "";
                        }
                        ((PortalManager.PortalConfig)localObject7).structMsgTitleForStar = ((String)localObject1);
                      }
                      else if (((String)localObject1).equalsIgnoreCase("structMsgContent"))
                      {
                        localObject5 = localXmlPullParser.nextText();
                        localObject1 = localObject5;
                        if (TextUtils.isEmpty((CharSequence)localObject5)) {
                          localObject1 = "";
                        }
                        ((PortalManager.PortalConfig)localObject7).structMsgContentForStar = ((String)localObject1);
                      }
                      else if (((String)localObject1).equalsIgnoreCase("starPhoto"))
                      {
                        localObject1 = a(localXmlPullParser, (String)localObject1);
                        ((PortalManager.PortalConfig)localObject7).shareStarImageUrl = ((String)((Pair)localObject1).first);
                        ((PortalManager.PortalConfig)localObject7).shareStarImageMD5 = ((String)((Pair)localObject1).second);
                      }
                      else if (((String)localObject1).equalsIgnoreCase("ShareWording"))
                      {
                        localObject5 = localXmlPullParser.nextText();
                        localObject1 = localObject5;
                        if (TextUtils.isEmpty((CharSequence)localObject5)) {
                          localObject1 = "";
                        }
                        ((PortalManager.PortalConfig)localObject7).shareWording = ((String)localObject1);
                      }
                      else if (((String)localObject1).equalsIgnoreCase("starGuiderPhoto"))
                      {
                        localObject1 = a(localXmlPullParser, (String)localObject1);
                        ((PortalManager.PortalConfig)localObject7).starGuiderPhotoURL = ((String)((Pair)localObject1).first);
                        ((PortalManager.PortalConfig)localObject7).starGuiderPhotoMD5 = ((String)((Pair)localObject1).second);
                      }
                    }
                    paramInt1 = localXmlPullParser.next();
                    continue;
                  }
                }
              }
              else
              {
                localObject1 = localObject4;
                if (((String)localObject6).equalsIgnoreCase("shareScore"))
                {
                  paramInt1 = localXmlPullParser.next();
                  localObject1 = localObject4;
                  if (paramInt1 != 1)
                  {
                    localObject1 = localXmlPullParser.getName();
                    if ((paramInt1 == 3) && (((String)localObject1).equalsIgnoreCase((String)localObject6)))
                    {
                      localObject1 = localObject4;
                    }
                    else
                    {
                      if (paramInt1 == 2) {
                        if (((String)localObject1).equalsIgnoreCase("summary"))
                        {
                          localObject5 = localXmlPullParser.nextText();
                          localObject1 = localObject5;
                          if (TextUtils.isEmpty((CharSequence)localObject5)) {
                            localObject1 = "";
                          }
                          ((PortalManager.PortalConfig)localObject7).summaryForScore = ((String)localObject1);
                        }
                        else if (((String)localObject1).equalsIgnoreCase("structMsgTitle"))
                        {
                          localObject5 = localXmlPullParser.nextText();
                          localObject1 = localObject5;
                          if (TextUtils.isEmpty((CharSequence)localObject5)) {
                            localObject1 = "";
                          }
                          ((PortalManager.PortalConfig)localObject7).structMsgTitleForScore = ((String)localObject1);
                        }
                        else if (((String)localObject1).equalsIgnoreCase("structMsgContent"))
                        {
                          localObject5 = localXmlPullParser.nextText();
                          localObject1 = localObject5;
                          if (TextUtils.isEmpty((CharSequence)localObject5)) {
                            localObject1 = "";
                          }
                          ((PortalManager.PortalConfig)localObject7).structMsgContentForScore = ((String)localObject1);
                        }
                        else if (((String)localObject1).equalsIgnoreCase("shareIcon"))
                        {
                          localObject1 = a(localXmlPullParser, (String)localObject1);
                          ((PortalManager.PortalConfig)localObject7).shareImageUrl = ((String)((Pair)localObject1).first);
                          ((PortalManager.PortalConfig)localObject7).shareImageMD5 = ((String)((Pair)localObject1).second);
                        }
                      }
                      paramInt1 = localXmlPullParser.next();
                      continue;
                    }
                  }
                }
              }
            }
          }
          paramInt1 = localXmlPullParser.next();
          continue;
          paramInt1 = localXmlPullParser.next();
          localObject2 = localObject5;
          localObject1 = localObject4;
          localObject3 = localObject6;
          continue;
        }
        int n = localRedPacketConfig.portalConfigs.size();
        paramInt1 = 0;
        if (paramArrayList == null) {
          break label3929;
        }
        paramInt2 = paramArrayList.size();
        if ((paramInt2 != 0) && (n > 0))
        {
          Collections.sort(localRedPacketConfig.portalConfigs, jdField_a_of_type_JavaUtilComparator);
          localObject1 = (PortalManager.PortalConfig)localRedPacketConfig.portalConfigs.get(0);
          if (((PortalManager.PortalConfig)localObject1).type != 2) {
            break label3934;
          }
          ((PortalManager.PortalConfig)localObject1).uiBegin = (((PortalManager.PortalConfig)localObject1).realBegin + ((Integer)paramArrayList.get(0 % paramInt2)).intValue());
          paramInt1 = 1;
          break label3934;
          if (k < n)
          {
            localObject2 = (PortalManager.PortalConfig)localRedPacketConfig.portalConfigs.get(k);
            paramInt1 = m;
            if (((PortalManager.PortalConfig)localObject2).type != 2) {
              break label3948;
            }
            ((PortalManager.PortalConfig)localObject2).uiBegin = (((PortalManager.PortalConfig)localObject2).realBegin + ((Integer)paramArrayList.get(m % paramInt2)).intValue() * 1000);
            if ((localObject1 == null) || (((PortalManager.PortalConfig)localObject1).type != 1) || (((PortalManager.PortalConfig)localObject1).realEnd + 2000L < ((PortalManager.PortalConfig)localObject2).realBegin)) {
              break label3943;
            }
            ((PortalManager.PortalConfig)localObject1).uiEnd = (((PortalManager.PortalConfig)localObject1).realEnd + ((Integer)paramArrayList.get(m % paramInt2)).intValue() * 1000);
            break label3943;
          }
        }
        Collections.sort(localRedPacketConfig.portalConfigs, jdField_a_of_type_JavaUtilComparator);
        paramInt1 = localRedPacketConfig.bannerConfigs.size() - 1;
        if (paramInt1 >= 0)
        {
          localObject1 = (PortalManager.BannerConfig)localRedPacketConfig.bannerConfigs.get(paramInt1);
          localObject2 = localRedPacketConfig.portalConfigs.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label3964;
          }
          localObject3 = (PortalManager.PortalConfig)((Iterator)localObject2).next();
          if ((((PortalManager.BannerConfig)localObject1).uiBegin >= ((PortalManager.PortalConfig)localObject3).realBegin) && (((PortalManager.BannerConfig)localObject1).uiBegin < ((PortalManager.PortalConfig)localObject3).realEnd))
          {
            if (((PortalManager.BannerConfig)localObject1).uiBegin != ((PortalManager.PortalConfig)localObject3).realBegin) {
              break label3964;
            }
            ((PortalManager.BannerConfig)localObject1).uiBegin = ((PortalManager.PortalConfig)localObject3).uiBegin;
            break label3964;
          }
          if (((PortalManager.PortalConfig)localObject3).uiBegin <= ((PortalManager.BannerConfig)localObject1).uiBegin) {
            continue;
          }
          break label3964;
        }
        Collections.sort(localRedPacketConfig.bannerConfigs, jdField_a_of_type_JavaUtilComparator);
        localObject1 = localRedPacketConfig;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("parseConfig, ");
          ((StringBuilder)localObject1).append(paramArrayList);
          a(localRedPacketConfig, ((StringBuilder)localObject1).toString());
          localObject1 = localRedPacketConfig;
        }
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("parseConfig ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.e("PortalManager", 2, ((StringBuilder)localObject1).toString(), paramArrayList);
        }
        localObject1 = null;
      }
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("parseConfig, ");
        if (localObject1 != null) {
          paramString = ((PortalManager.RedPacketConfig)localObject1).toString();
        } else {
          paramString = "null";
        }
        paramArrayList.append(paramString);
        QLog.d("PortalManager", 2, paramArrayList.toString());
      }
      return localObject1;
      label3909:
      continue;
      label3912:
      continue;
      label3915:
      Object localObject4 = localObject1;
      label3919:
      localObject1 = localObject4;
      continue;
      label3926:
      continue;
      label3929:
      paramInt2 = 0;
      continue;
      label3934:
      int k = 1;
      int m = paramInt1;
      continue;
      label3943:
      paramInt1 = m + 1;
      label3948:
      k += 1;
      localObject1 = localObject2;
      m = paramInt1;
      continue;
      label3964:
      paramInt1 -= 1;
    }
  }
  
  private String a()
  {
    File localFile = this.jdField_a_of_type_AndroidContentContext.getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("red_packet_config2017_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    return new File(localFile, localStringBuilder.toString()).getAbsolutePath();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    Object localObject = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
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
        paramString2.printStackTrace();
        localObject = paramString1;
      }
    }
    a(paramInt1, (String)localObject, paramInt2);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      if (paramInt1 == 1009) {
        try
        {
          Object localObject1 = new JSONObject(paramString);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("get head returned , key = ");
          ((StringBuilder)localObject3).append(((JSONObject)localObject1).getString("key"));
          localObject1 = ((StringBuilder)localObject3).toString();
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      } else {
        localObject2 = paramString;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("sendBroadcastRespData, ");
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append(paramInt2);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject3).toString());
    }
    Object localObject2 = new Intent("com.tencent.portal.resp.action");
    ((Intent)localObject2).putExtra("portal_type_key", paramInt1);
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putByteArray("bc_data", PortalUtils.a(paramString));
    ((Intent)localObject2).putExtras((Bundle)localObject3);
    if (paramInt2 > 0) {
      ((Intent)localObject2).putExtra("bc_seq", paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject2, "com.tencent.msg.permission.pushnotify");
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downLoad, ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("PortalManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir());
    ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
    localObject = ((StringBuilder)localObject).toString();
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = paramString1;
    localHttpNetReq.mHttpMethod = 0;
    paramString1 = new StringBuilder();
    paramString1.append((String)localObject);
    paramString1.append(paramString2);
    localHttpNetReq.mOutPath = paramString1.toString();
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
    long l1 = f;
    long l2;
    if (l1 > 0L) {
      l2 = l1 + i * (paramLong - g);
    } else {
      l2 = paramLong;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(100);
    Object localObject4 = ((PortalManager.RedPacketConfig)localObject3).bannerConfigs;
    Object localObject1 = jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig;
    ((PortalManager.TimerConfig)localObject1).uiBegin = l2;
    int k = Collections.binarySearch((List)localObject4, localObject1, jdField_a_of_type_JavaUtilComparator);
    if (k >= 0) {
      k += 1;
    } else {
      k = -k - 1;
    }
    Object localObject5 = null;
    Object localObject2;
    if ((k > 0) && (k <= ((ArrayList)localObject4).size()))
    {
      localObject2 = (PortalManager.BannerConfig)((ArrayList)localObject4).get(k - 1);
      localObject1 = localObject2;
      if (((PortalManager.BannerConfig)localObject2).uiEnd >= l2) {}
    }
    else
    {
      localObject1 = null;
    }
    if ((k < ((ArrayList)localObject4).size()) && (k >= 0)) {
      localObject2 = (PortalManager.BannerConfig)((ArrayList)localObject4).get(k);
    } else {
      localObject2 = null;
    }
    ArrayList localArrayList = ((PortalManager.RedPacketConfig)localObject3).portalConfigs;
    k = Collections.binarySearch(localArrayList, jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig, jdField_a_of_type_JavaUtilComparator);
    if (k >= 0) {
      k += 1;
    } else {
      k = -k - 1;
    }
    if ((k > 0) && (k <= localArrayList.size()))
    {
      localObject4 = (PortalManager.PortalConfig)localArrayList.get(k - 1);
      localObject3 = localObject4;
      if (((PortalManager.PortalConfig)localObject4).uiEnd >= l2) {}
    }
    else
    {
      localObject3 = null;
    }
    localObject4 = localObject5;
    if (k < localArrayList.size())
    {
      localObject4 = localObject5;
      if (k >= 0) {
        localObject4 = (PortalManager.PortalConfig)localArrayList.get(k);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig = ((PortalManager.BannerConfig)localObject1);
    this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig = ((PortalManager.BannerConfig)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig = ((PortalManager.PortalConfig)localObject3);
    this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig = ((PortalManager.PortalConfig)localObject4);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
    if (localObject1 != null)
    {
      paramLong = ((PortalManager.BannerConfig)localObject1).uiEnd;
    }
    else
    {
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
      if (localObject1 != null) {
        paramLong = ((PortalManager.BannerConfig)localObject1).uiBegin;
      } else {
        paramLong = 9223372036854775807L;
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
    if (localObject1 != null)
    {
      if ((((PortalManager.PortalConfig)localObject1).realEnd > l2) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd < paramLong))
      {
        l1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd;
      }
      else
      {
        l1 = paramLong;
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd > l2)
        {
          l1 = paramLong;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd < paramLong) {
            l1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd;
          }
        }
      }
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
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCurrentTimer last minutes in, countTime = ");
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime);
              ((StringBuilder)localObject1).append(", diffTime = ");
              ((StringBuilder)localObject1).append(l3);
              ((StringBuilder)localObject1).append(", timeout = ");
              ((StringBuilder)localObject1).append(l3);
              QLog.d("PortalManager", 2, ((StringBuilder)localObject1).toString());
            }
            paramLong = l3;
          }
        }
      }
      this.j = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd;
      l1 = paramLong;
    }
    else
    {
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
      l1 = paramLong;
      if (localObject1 != null)
      {
        l1 = paramLong;
        if (((PortalManager.PortalConfig)localObject1).uiBegin < paramLong) {
          l1 = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiBegin;
        }
      }
    }
    if (l1 != 9223372036854775807L)
    {
      if (l1 > l2) {
        paramLong = l1 - l2;
      } else {
        paramLong = 60000L;
      }
      l2 = paramLong;
      if (paramLong > 60000L) {
        l2 = 60000L;
      }
      if (f != 0L) {
        l2 = 1000L;
      }
      a(true, 100, l2, null);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateCurrentTimer, ");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
      int m = -1;
      if (localObject2 != null) {
        k = ((PortalManager.BannerConfig)localObject2).id;
      } else {
        k = -1;
      }
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(", ");
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
      if (localObject2 != null) {
        k = ((PortalManager.BannerConfig)localObject2).id;
      } else {
        k = -1;
      }
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(", ");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
      if (localObject2 != null) {
        k = ((PortalManager.PortalConfig)localObject2).id;
      } else {
        k = -1;
      }
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(", ");
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
      if (localObject2 != null) {
        k = ((PortalManager.PortalConfig)localObject2).id;
      } else {
        k = -1;
      }
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append(", ");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
      k = m;
      if (localObject2 != null) {
        k = ((PortalManager.PortalConfig)localObject2).useFlag;
      }
      ((StringBuilder)localObject1).append(k);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void a(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    if (FileUtils.getAvailableInnernalMemorySize() < 1048576.0F) {
      return;
    }
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
    if (System.currentTimeMillis() - this.jdField_d_of_type_Long > 1800000L)
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "tryDownload needReport");
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PortalManager.2(this, paramRedPacketConfig), 60000L);
    }
  }
  
  private static void a(PortalManager.RedPacketConfig paramRedPacketConfig, String paramString)
  {
    int i1 = paramRedPacketConfig.bannerConfigs.size();
    int n = paramRedPacketConfig.portalConfigs.size();
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(paramString);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramRedPacketConfig.id);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramRedPacketConfig.version);
    localStringBuilder.append('[');
    int m = 0;
    int k = 0;
    while (k < i1)
    {
      localStringBuilder.append(((PortalManager.BannerConfig)paramRedPacketConfig.bannerConfigs.get(k)).id);
      localStringBuilder.append(", ");
      k += 1;
    }
    localStringBuilder.append(']');
    localStringBuilder.append(", ");
    localStringBuilder.append('[');
    k = m;
    while (k < n)
    {
      localStringBuilder.append(((PortalManager.PortalConfig)paramRedPacketConfig.portalConfigs.get(k)).id);
      localStringBuilder.append(", ");
      k += 1;
    }
    localStringBuilder.append(']');
    QLog.d("PortalManager", 2, localStringBuilder.toString());
  }
  
  @SuppressLint({"UseSparseArrays"})
  private boolean a(PortalManager.RedPacketConfig paramRedPacketConfig1, PortalManager.RedPacketConfig paramRedPacketConfig2, boolean paramBoolean)
  {
    int n = paramRedPacketConfig1.portalConfigs.size();
    int m = 0;
    if (paramRedPacketConfig2 != null) {
      k = paramRedPacketConfig2.portalConfigs.size();
    } else {
      k = 0;
    }
    if (paramRedPacketConfig2 != null) {
      paramRedPacketConfig1.showGesturesTime = paramRedPacketConfig2.showGesturesTime;
    }
    HashMap localHashMap;
    Object localObject;
    if ((n > 0) && (k > 0))
    {
      localHashMap = new HashMap(k);
      localObject = paramRedPacketConfig2.portalConfigs.iterator();
      PortalManager.PortalConfig localPortalConfig1;
      while (((Iterator)localObject).hasNext())
      {
        localPortalConfig1 = (PortalManager.PortalConfig)((Iterator)localObject).next();
        localHashMap.put(Integer.valueOf(localPortalConfig1.id), localPortalConfig1);
      }
      localObject = paramRedPacketConfig1.portalConfigs.iterator();
      paramBoolean = false;
      for (;;)
      {
        bool = paramBoolean;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localPortalConfig1 = (PortalManager.PortalConfig)((Iterator)localObject).next();
        PortalManager.PortalConfig localPortalConfig2 = (PortalManager.PortalConfig)localHashMap.get(Integer.valueOf(localPortalConfig1.id));
        if (localPortalConfig2 != null)
        {
          if (localPortalConfig2.useFlag != localPortalConfig1.useFlag)
          {
            localPortalConfig1.useFlag = localPortalConfig2.useFlag;
            paramBoolean = true;
          }
          if (localPortalConfig2.useTime != localPortalConfig1.useTime)
          {
            localPortalConfig1.useTime = localPortalConfig2.useTime;
            paramBoolean = true;
          }
          if (localPortalConfig2.countGrab != localPortalConfig1.countGrab)
          {
            localPortalConfig1.countGrab = localPortalConfig2.countGrab;
            paramBoolean = true;
          }
          if (localPortalConfig2.continuousRecord != localPortalConfig1.continuousRecord)
          {
            localPortalConfig1.continuousRecord = localPortalConfig2.continuousRecord;
            paramBoolean = true;
          }
        }
      }
    }
    boolean bool = false;
    n = paramRedPacketConfig1.bannerConfigs.size();
    int k = m;
    if (paramRedPacketConfig2 != null) {
      k = paramRedPacketConfig2.bannerConfigs.size();
    }
    paramBoolean = bool;
    if (n > 0)
    {
      paramBoolean = bool;
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
          paramBoolean = bool;
          if (!paramRedPacketConfig1.hasNext()) {
            break;
          }
          paramRedPacketConfig2 = (PortalManager.BannerConfig)paramRedPacketConfig1.next();
          localObject = (PortalManager.BannerConfig)localHashMap.get(Integer.valueOf(paramRedPacketConfig2.id));
          if ((localObject != null) && (((PortalManager.BannerConfig)localObject).useFlag != paramRedPacketConfig2.useFlag))
          {
            paramRedPacketConfig2.useFlag = ((PortalManager.BannerConfig)localObject).useFlag;
            bool = true;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramRedPacketConfig1 = new StringBuilder();
      paramRedPacketConfig1.append("updateUsedFlag, ");
      paramRedPacketConfig1.append(paramBoolean);
      QLog.d("PortalManager", 2, paramRedPacketConfig1.toString());
    }
    return paramBoolean;
  }
  
  private int b()
  {
    PortalManager.PortalConfig localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
    if ((localPortalConfig != null) && (localPortalConfig.type == 2)) {
      return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord;
    }
    return 0;
  }
  
  private PortalManager.RedPacketConfig b()
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(30000));
    ((ArrayList)localObject).add(Integer.valueOf(20000));
    ((ArrayList)localObject).add(Integer.valueOf(10000));
    localObject = a("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<HappyFestival>\n    <ConfigId>113</ConfigId>\n    <Common>\n        <GrabReqInterval>2500</GrabReqInterval>\n        <ReportActiveInterval>0</ReportActiveInterval>\n        <ReportNormalInterval>180000</ReportNormalInterval>\n        <Combo>\n            <ShareTimes>1</ShareTimes>\n            <ComboNumberList>\n                <ComboNumber>\n                    <Number>8</Number>\n                    <NumberImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </NumberImage>\n                    <FlowerImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </FlowerImage>\n                    <FlowerImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </FlowerImage>\n                </ComboNumber>\n            </ComboNumberList>\n        </Combo>\n    </Common>\n    <Activity>\n        <Id>2034</Id>\n        <Type>2</Type>\n        <Mode>3</Mode>\n        <BeginTime>2020-11-10 14:00:00</BeginTime>\n        <EndTime>2020-12-11 23:30:00</EndTime>\n        <scrollTime>5</scrollTime>\n        <OnActivity>\n            <Timer>30</Timer>\n            <TipWording>抢红包倒计时</TipWording>\n            <GrabWording>连刷更容易得红包！</GrabWording>\n            <NoRPWording>没中！继续刷还有机会。</NoRPWording>\n            <LogoList>\n                <Logo>\n                    <logoId>1</logoId>\n                    <LogoImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </LogoImage>\n                    <Name>随手记</Name>\n                    <NameImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </NameImage>\n                    <padantImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </padantImage>\n                </Logo>\n\n            </LogoList>\n            <NextActTime>23:40-23:59</NextActTime>\n            <AwardList>\n                <Award>\n                    <AwardId>2033</AwardId>\n                    <logoId>1</logoId>\n                    <AwardLogoType>1</AwardLogoType>\n                    <AwardLogo1Image>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </AwardLogo1Image>\n                    <AwardLogo2Image>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </AwardLogo2Image>\n                    <AwardLogoBGImage>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </AwardLogoBGImage>\n                    <AwardName>随手记</AwardName>\n                    <Grettings>随手记给你发红包啦</Grettings>\n                    <AddWording>随手记给你发红包啦</AddWording>\n                    <showPublic>1</showPublic>\n                    <PublicId>2137362945</PublicId>\n                    <PublicWording>关注随手记公众号</PublicWording>\n                </Award>\n\n            </AwardList>\n            <EndRefresh>\n                <Starluckytype>1</Starluckytype>\n                <StarNoluckyType>1</StarNoluckyType>\n            </EndRefresh>\n            <Share>\n                <shareScore>\n                    <summary>QQ红包开抢了！我已成功刷了%d次，谁比我厉害！</summary>\n                    <structMsgTitle>亿万红包等你来刷！</structMsgTitle>\n                    <structMsgContent>QQ刷红包，我已刷%d次，谁比我厉害！</structMsgContent>\n                    <shareIcon>\n                        <url>https://sola.gtimg.cn/aoi/sola/20200410152156_UqBMKwJGiv.png</url>\n                        <md5>deafadc7908ab67d63181bc368c7a490</md5>\n                    </shareIcon>\n                </shareScore>\n            </Share>\n        </OnActivity>\n    </Activity>\n\n</HappyFestival>\n", 0, 0, (ArrayList)localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDebugRedPacketConfig  newConfig = ");
      localStringBuilder.append(localObject);
      QLog.d("PortalManager", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  private void b(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    Object localObject1 = paramRedPacketConfig.bannerConfigs.iterator();
    boolean bool3 = true;
    while (((Iterator)localObject1).hasNext()) {
      bool3 &= (b(((PortalManager.BannerConfig)((Iterator)localObject1).next()).bannarMd5) ^ true);
    }
    boolean bool4 = bool3;
    if (paramRedPacketConfig.comboNumberConfigs != null)
    {
      localObject1 = paramRedPacketConfig.comboNumberConfigs.iterator();
      for (;;)
      {
        bool4 = bool3;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (PortalManager.ComboNumber)((Iterator)localObject1).next();
        bool3 = bool3 & (b(((PortalManager.ComboNumber)localObject2).flowerImageMD5) ^ true) & (b(((PortalManager.ComboNumber)localObject2).numberImageMD5) ^ true) & (b(((PortalManager.ComboNumber)localObject2).flowerImage2MD5) ^ true);
      }
    }
    localObject1 = paramRedPacketConfig.portalConfigs.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PortalManager.PortalConfig)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        boolean bool2 = (b(((PortalManager.PortalConfig)localObject2).bgMd5) ^ true) & bool4 & (b(((PortalManager.PortalConfig)localObject2).leftCloudImageMD5) ^ true) & (b(((PortalManager.PortalConfig)localObject2).rightCloudImageMD5) ^ true);
        boolean bool1 = bool2;
        Object localObject4;
        if (((PortalManager.PortalConfig)localObject2).logoList != null)
        {
          localObject3 = ((PortalManager.PortalConfig)localObject2).logoList.iterator();
          for (;;)
          {
            bool1 = bool2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject4 = (PortalManager.LogoConfig)((Iterator)localObject3).next();
            if (localObject4 != null) {
              bool2 = bool2 & (b(((PortalManager.LogoConfig)localObject4).logoImageMD5) ^ true) & (b(((PortalManager.LogoConfig)localObject4).nameMD5) ^ true) & (b(((PortalManager.LogoConfig)localObject4).greetImageMD5) ^ true) & (b(((PortalManager.LogoConfig)localObject4).padantImageMD5) ^ true) & (b(((PortalManager.LogoConfig)localObject4).relationCompanyLogoMD5) ^ true);
            }
          }
        }
        bool2 = bool1;
        if (((PortalManager.PortalConfig)localObject2).awardConfigList != null)
        {
          localObject3 = ((PortalManager.PortalConfig)localObject2).awardConfigList.iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject4 = (PortalManager.AwardConfig)((Iterator)localObject3).next();
            if (localObject4 != null) {
              bool1 = bool1 & (b(((PortalManager.AwardConfig)localObject4).awardMd5) ^ true) & (b(((PortalManager.AwardConfig)localObject4).starMd5) ^ true) & (b(((PortalManager.AwardConfig)localObject4).ctfBgMd5) ^ true);
            }
          }
        }
        bool4 = bool2 & (b(((PortalManager.PortalConfig)localObject2).shareStarImageMD5) ^ true) & (b(((PortalManager.PortalConfig)localObject2).starGuiderPhotoMD5) ^ true);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportResCover ,resCover=");
      ((StringBuilder)localObject1).append(bool4);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (bool4) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    Object localObject2 = String.valueOf(paramRedPacketConfig.taskId);
    paramRedPacketConfig = String.valueOf(paramRedPacketConfig.version);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80078FA", "0X80078FA", 0, 0, (String)localObject1, (String)localObject2, paramRedPacketConfig, "");
    if (PrecoverUtils.a(this.jdField_a_of_type_AndroidContentContext, "hongbao_17_res_cover"))
    {
      PrecoverUtils.a(this.jdField_a_of_type_AndroidContentContext, "hongbao_17_res_cover");
      localObject3 = new HashMap();
      ((HashMap)localObject3).put("config_version", paramRedPacketConfig);
      ((HashMap)localObject3).put("cover", localObject1);
      ((HashMap)localObject3).put("taskid", localObject2);
      StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "hongbao_res_precover", bool4, 0L, 0L, (HashMap)localObject3, "", false);
    }
  }
  
  public static boolean b()
  {
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
    boolean bool2 = false;
    localObject1 = null;
    int k = 0;
    boolean bool1;
    for (;;)
    {
      Object localObject2 = jdField_a_of_type_ArrayOfJavaLangString;
      bool1 = bool2;
      if (k >= localObject2.length) {
        break;
      }
      try
      {
        localObject2 = localSimpleDateFormat.parse(localObject2[k]);
      }
      catch (ParseException localParseException)
      {
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e("PortalManager", 2, "isForbidAlert", localParseException);
          localObject2 = localObject1;
        }
      }
      if (localObject2 != null)
      {
        localCalendar.clear();
        localCalendar.setTime((Date)localObject2);
        int i2 = localCalendar.get(1);
        int i3 = localCalendar.get(2);
        int i4 = localCalendar.get(5);
        if ((m == i2) && (n + 1 == i3 + 1) && (i1 == i4))
        {
          bool1 = true;
          break;
        }
      }
      k += 1;
      localObject1 = localObject2;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isForbidAlert, current=");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(", bingo=");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(", DEBUG_GRAB=");
      ((StringBuilder)localObject1).append(jdField_a_of_type_Boolean);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject1).toString());
    }
    return bool1;
  }
  
  private boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
        return false;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir());
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramString);
      if (!new File(localStringBuilder.toString()).exists())
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC = new OlympicDPC();
      int k = (int)(DeviceInfoUtil.a() / 1024L / 1024L);
      int m = ViewUtils.a();
      String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.olympic_act_config.name());
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_JavaLangString = str;
      boolean bool2 = false;
      boolean bool1;
      try
      {
        if (str.length() > 0)
        {
          String[] arrayOfString = str.split("\\|");
          if (arrayOfString.length >= 9)
          {
            if (k <= Integer.valueOf(arrayOfString[0]).intValue()) {
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true;
            } else if (m <= Integer.valueOf(arrayOfString[1]).intValue()) {
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true;
            } else if (m <= Integer.valueOf(arrayOfString[2]).intValue()) {
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Boolean = true;
            }
            if (Integer.valueOf(arrayOfString[3]).intValue() == 1) {
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Boolean = true;
            }
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[4]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Int = Integer.valueOf(arrayOfString[5]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Int = Integer.valueOf(arrayOfString[6]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Int = Integer.valueOf(arrayOfString[7]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_e_of_type_Int = Integer.valueOf(arrayOfString[8]).intValue();
            bool1 = false;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadDPCConfig Exception:");
          localStringBuilder.append(localException.toString());
          QLog.d("PortalManager", 2, localStringBuilder.toString());
        }
        bool1 = true;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC;
      ((OlympicDPC)localObject).jdField_a_of_type_Boolean = bool1;
      if (bool1)
      {
        if (k <= 512) {
          ((OlympicDPC)localObject).jdField_b_of_type_Boolean = true;
        } else if (m <= 480) {
          ((OlympicDPC)localObject).jdField_b_of_type_Boolean = true;
        } else if (m <= 720) {
          ((OlympicDPC)localObject).jdField_c_of_type_Boolean = true;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC;
        ((OlympicDPC)localObject).jdField_d_of_type_Boolean = false;
        ((OlympicDPC)localObject).jdField_a_of_type_Int = 0;
        ((OlympicDPC)localObject).jdField_b_of_type_Int = 3;
        ((OlympicDPC)localObject).jdField_c_of_type_Int = 1000;
        ((OlympicDPC)localObject).jdField_d_of_type_Int = 1;
        ((OlympicDPC)localObject).jdField_e_of_type_Int = 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Int == 1) {
        bool2 = true;
      }
      OlympicUtil.a(bool2);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadDPCConfig|featureValue:");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(",systemTotalMem:");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(",screenWidth:");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(",isUseDefault:");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(",dpc:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.toString());
        QLog.d("PortalManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public int a()
  {
    PortalManager.PortalConfig localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
    if (localPortalConfig != null) {
      return localPortalConfig.id;
    }
    return -1;
  }
  
  public PortalManager.PortalConfig a(long paramLong)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
    StringBuilder localStringBuilder = null;
    Object localObject1 = localStringBuilder;
    long l2 = paramLong;
    int k;
    if (localObject2 != null)
    {
      long l1 = paramLong;
      if (paramLong == -1L)
      {
        paramLong = NetConnInfoCenter.getServerTimeMillis();
        l2 = f;
        l1 = paramLong;
        if (l2 > 0L) {
          l1 = l2 + i * (paramLong - g);
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs;
      int m = ((ArrayList)localObject2).size();
      k = 0;
      for (;;)
      {
        localObject1 = localStringBuilder;
        l2 = l1;
        if (k >= m) {
          break label187;
        }
        localObject1 = (PortalManager.PortalConfig)((ArrayList)localObject2).get(k);
        if ((((PortalManager.PortalConfig)localObject1).id == l1) || ((((PortalManager.PortalConfig)localObject1).realBegin <= l1) && (((PortalManager.PortalConfig)localObject1).realEnd > l1))) {
          break;
        }
        if ((l1 > 536870911L) && (((PortalManager.PortalConfig)localObject1).realBegin > l1))
        {
          localObject1 = localStringBuilder;
          l2 = l1;
          break label187;
        }
        k += 1;
      }
      l2 = l1;
    }
    label187:
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("findRealPortal, ");
      localStringBuilder.append(l2);
      localStringBuilder.append(", ");
      if (localObject1 != null) {
        k = ((PortalManager.PortalConfig)localObject1).id;
      } else {
        k = -1;
      }
      localStringBuilder.append(k);
      QLog.d("PortalManager", 2, localStringBuilder.toString());
    }
    return localObject1;
  }
  
  /* Error */
  protected PortalManager.RedPacketConfig a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 195	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4: invokevirtual 1076	android/content/Context:getFilesDir	()Ljava/io/File;
    //   7: astore_2
    //   8: new 63	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: ldc_w 1078
    //   20: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_3
    //   25: aload_0
    //   26: getfield 187	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: invokevirtual 1081	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   32: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: new 68	java/io/File
    //   39: dup
    //   40: aload_2
    //   41: aload_3
    //   42: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 1084	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore_2
    //   49: aload_2
    //   50: invokevirtual 533	java/io/File:exists	()Z
    //   53: istore_1
    //   54: aconst_null
    //   55: astore 4
    //   57: iload_1
    //   58: ifeq +303 -> 361
    //   61: new 1488	java/io/FileInputStream
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 1491	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   69: astore_2
    //   70: new 1493	java/io/ObjectInputStream
    //   73: dup
    //   74: new 1495	java/io/BufferedInputStream
    //   77: dup
    //   78: aload_2
    //   79: invokespecial 1498	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   82: invokespecial 1499	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore 7
    //   87: aload_2
    //   88: astore_3
    //   89: aload 7
    //   91: astore 5
    //   93: aload 7
    //   95: invokevirtual 1502	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   98: checkcast 595	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   101: astore 4
    //   103: aload 7
    //   105: invokevirtual 1505	java/io/ObjectInputStream:close	()V
    //   108: goto +19 -> 127
    //   111: astore_3
    //   112: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +12 -> 127
    //   118: ldc 251
    //   120: iconst_2
    //   121: ldc 253
    //   123: aload_3
    //   124: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_2
    //   128: invokevirtual 1506	java/io/FileInputStream:close	()V
    //   131: aload 4
    //   133: astore_2
    //   134: goto +229 -> 363
    //   137: astore_3
    //   138: aload 4
    //   140: astore_2
    //   141: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +219 -> 363
    //   147: ldc 251
    //   149: iconst_2
    //   150: ldc 253
    //   152: aload_3
    //   153: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   156: aload 4
    //   158: astore_2
    //   159: goto +204 -> 363
    //   162: astore 6
    //   164: aload_2
    //   165: astore 4
    //   167: aload 7
    //   169: astore_2
    //   170: goto +33 -> 203
    //   173: astore_3
    //   174: goto +127 -> 301
    //   177: astore 6
    //   179: aconst_null
    //   180: astore_3
    //   181: aload_2
    //   182: astore 4
    //   184: aload_3
    //   185: astore_2
    //   186: goto +17 -> 203
    //   189: astore_3
    //   190: aconst_null
    //   191: astore_2
    //   192: goto +109 -> 301
    //   195: astore 6
    //   197: aconst_null
    //   198: astore 4
    //   200: aload 4
    //   202: astore_2
    //   203: aload 4
    //   205: astore_3
    //   206: aload_2
    //   207: astore 5
    //   209: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +19 -> 231
    //   215: aload 4
    //   217: astore_3
    //   218: aload_2
    //   219: astore 5
    //   221: ldc 251
    //   223: iconst_2
    //   224: ldc 253
    //   226: aload 6
    //   228: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_2
    //   232: ifnull +26 -> 258
    //   235: aload_2
    //   236: invokevirtual 1505	java/io/ObjectInputStream:close	()V
    //   239: goto +19 -> 258
    //   242: astore_2
    //   243: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +12 -> 258
    //   249: ldc 251
    //   251: iconst_2
    //   252: ldc 253
    //   254: aload_2
    //   255: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aload 4
    //   260: ifnull +101 -> 361
    //   263: aload 4
    //   265: invokevirtual 1506	java/io/FileInputStream:close	()V
    //   268: goto +93 -> 361
    //   271: astore_2
    //   272: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +86 -> 361
    //   278: ldc 251
    //   280: iconst_2
    //   281: ldc 253
    //   283: aload_2
    //   284: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   287: goto +74 -> 361
    //   290: astore 6
    //   292: aload 5
    //   294: astore 4
    //   296: aload_3
    //   297: astore_2
    //   298: aload 6
    //   300: astore_3
    //   301: aload 4
    //   303: ifnull +29 -> 332
    //   306: aload 4
    //   308: invokevirtual 1505	java/io/ObjectInputStream:close	()V
    //   311: goto +21 -> 332
    //   314: astore 4
    //   316: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +13 -> 332
    //   322: ldc 251
    //   324: iconst_2
    //   325: ldc 253
    //   327: aload 4
    //   329: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   332: aload_2
    //   333: ifnull +26 -> 359
    //   336: aload_2
    //   337: invokevirtual 1506	java/io/FileInputStream:close	()V
    //   340: goto +19 -> 359
    //   343: astore_2
    //   344: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +12 -> 359
    //   350: ldc 251
    //   352: iconst_2
    //   353: ldc 253
    //   355: aload_2
    //   356: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   359: aload_3
    //   360: athrow
    //   361: aconst_null
    //   362: astore_2
    //   363: aload_2
    //   364: astore_3
    //   365: aload_2
    //   366: ifnonnull +16 -> 382
    //   369: new 595	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   372: dup
    //   373: invokespecial 596	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:<init>	()V
    //   376: pop
    //   377: aload_0
    //   378: invokespecial 1508	com/tencent/mobileqq/portal/PortalManager:b	()Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   381: astore_3
    //   382: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +55 -> 440
    //   388: new 63	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   395: astore 4
    //   397: aload 4
    //   399: ldc_w 1510
    //   402: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_3
    //   407: ifnull +11 -> 418
    //   410: aload_3
    //   411: invokevirtual 1070	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:toString	()Ljava/lang/String;
    //   414: astore_2
    //   415: goto +7 -> 422
    //   418: ldc_w 1072
    //   421: astore_2
    //   422: aload 4
    //   424: aload_2
    //   425: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: ldc 251
    //   431: iconst_2
    //   432: aload 4
    //   434: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: aload_0
    //   441: getfield 1213	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig	Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   444: ifnonnull +11 -> 455
    //   447: aload_0
    //   448: iconst_1
    //   449: iconst_2
    //   450: lconst_0
    //   451: aload_3
    //   452: invokevirtual 1244	com/tencent/mobileqq/portal/PortalManager:a	(ZIJLjava/lang/Object;)V
    //   455: aload_3
    //   456: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	PortalManager
    //   53	5	1	bool	boolean
    //   7	229	2	localObject1	Object
    //   242	13	2	localIOException1	java.io.IOException
    //   271	13	2	localIOException2	java.io.IOException
    //   297	40	2	localObject2	Object
    //   343	13	2	localIOException3	java.io.IOException
    //   362	63	2	str	String
    //   15	74	3	localObject3	Object
    //   111	13	3	localIOException4	java.io.IOException
    //   137	16	3	localIOException5	java.io.IOException
    //   173	1	3	localObject4	Object
    //   180	5	3	localObject5	Object
    //   189	1	3	localObject6	Object
    //   205	251	3	localObject7	Object
    //   55	252	4	localObject8	Object
    //   314	14	4	localIOException6	java.io.IOException
    //   395	38	4	localStringBuilder	StringBuilder
    //   91	202	5	localObject9	Object
    //   162	1	6	localThrowable1	Throwable
    //   177	1	6	localThrowable2	Throwable
    //   195	32	6	localThrowable3	Throwable
    //   290	9	6	localObject10	Object
    //   85	83	7	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   103	108	111	java/io/IOException
    //   127	131	137	java/io/IOException
    //   93	103	162	java/lang/Throwable
    //   70	87	173	finally
    //   70	87	177	java/lang/Throwable
    //   61	70	189	finally
    //   61	70	195	java/lang/Throwable
    //   235	239	242	java/io/IOException
    //   263	268	271	java/io/IOException
    //   93	103	290	finally
    //   209	215	290	finally
    //   221	231	290	finally
    //   306	311	314	java/io/IOException
    //   336	340	343	java/io/IOException
  }
  
  protected PortalManager.RedPacketConfig a(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    if (QLog.isColorLevel()) {
      if (paramRedPacketConfig == null)
      {
        QLog.d("PortalManager", 2, "handleNewConfig");
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleNewConfig, ");
        ((StringBuilder)localObject).append(paramRedPacketConfig.version);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramRedPacketConfig.bannerConfigs.size());
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramRedPacketConfig.portalConfigs.size());
        QLog.d("PortalManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    PortalManager.RedPacketConfig localRedPacketConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
    Object localObject = localRedPacketConfig;
    if (localRedPacketConfig == null) {
      localObject = a();
    }
    if (paramRedPacketConfig != null)
    {
      a(paramRedPacketConfig, (PortalManager.RedPacketConfig)localObject, false);
      a(paramRedPacketConfig);
    }
    else
    {
      paramRedPacketConfig = (PortalManager.RedPacketConfig)localObject;
    }
    if (paramRedPacketConfig != null) {
      a(paramRedPacketConfig);
    }
    return paramRedPacketConfig;
  }
  
  public PortalManager.ResultData a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject3 = a(paramInt2);
    if (localObject3 == null) {
      return null;
    }
    Object localObject2 = ((PortalManager.PortalConfig)localObject3).findRealAwardConfigById(paramInt3);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = ((PortalManager.PortalConfig)localObject3).findRealAwardConfigById(paramInt4);
      localObject1 = localObject2;
      if (localObject2 == null) {
        return null;
      }
    }
    localObject3 = new PortalManager.ResultData();
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      return null;
    }
    ((PortalManager.ResultData)localObject3).jdField_a_of_type_AndroidGraphicsBitmap = a(localObject1.awardMd5, null);
    ((PortalManager.ResultData)localObject3).jdField_a_of_type_JavaLangString = localObject1.addMsg;
    ((PortalManager.ResultData)localObject3).h = localObject1.publicId;
    ((PortalManager.ResultData)localObject3).jdField_g_of_type_JavaLangString = localObject1.publicWording;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir());
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    if (localObject1.awardType == 2) {
      localObject2 = localObject1.starMd5;
    } else {
      localObject2 = localObject1.awardMd5;
    }
    localStringBuilder.append((String)localObject2);
    ((PortalManager.ResultData)localObject3).jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getFilesDir());
    ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(localObject1.ctfBgMd5);
    ((PortalManager.ResultData)localObject3).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    ((PortalManager.ResultData)localObject3).f = localObject1.awardMsg;
    ((PortalManager.ResultData)localObject3).e = localObject1.awardTitle;
    ((PortalManager.ResultData)localObject3).jdField_d_of_type_Int = localObject1.awardType;
    ((PortalManager.ResultData)localObject3).jdField_g_of_type_Int = localObject1.showPublic;
    return localObject3;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    c();
    a(true, 100, 0L, null);
    Object localObject;
    if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(16))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
      long l;
      if (localObject != null) {
        l = Long.valueOf(((PortalManager.PortalConfig)localObject).useTime).longValue();
      } else {
        l = 10000L;
      }
      a(true, 16, 1000L, Long.valueOf(l));
    }
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setGrabTimeFinish activity id:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id);
      ((StringBuilder)localObject).append(", total count:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setStarShareFlag, ");
      ((StringBuilder)localObject).append(paramInt1);
      PortalManager.PortalConfig localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
      int k;
      if (localPortalConfig != null) {
        k = localPortalConfig.id;
      } else {
        k = 0;
      }
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
    if ((localObject != null) && (((PortalManager.PortalConfig)localObject).id == paramInt1))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
      ((PortalManager.PortalConfig)localObject).starShareTypeReqState = 2;
      ((PortalManager.PortalConfig)localObject).starShareType = paramInt2;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder1;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("testplaySound, playSound, ");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append(", ");
      localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[paramInt]);
      localStringBuilder1.append(", ");
      localStringBuilder1.append(jdField_a_of_type_ArrayOfBoolean[paramInt]);
      localStringBuilder1.append(", mPlayCountDownStreamId=");
      localStringBuilder1.append(this.jdField_e_of_type_Int);
      localStringBuilder1.append(", mPlayCountDownState=");
      localStringBuilder1.append(this.jdField_b_of_type_Int);
      QLog.d("PortalManager", 2, localStringBuilder1.toString());
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
        if ((this.jdField_b_of_type_Int == 4) && (paramBoolean)) {
          return;
        }
        if ((this.jdField_b_of_type_Int == 1) && (!paramBoolean)) {
          return;
        }
        this.jdField_b_of_type_Int = 1;
      }
      int n = this.jdField_a_of_type_ArrayOfInt[paramInt];
      if (n == 0)
      {
        k = this.jdField_a_of_type_AndroidMediaSoundPool.load(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), jdField_b_of_type_ArrayOfInt[paramInt], 1);
        this.jdField_a_of_type_ArrayOfInt[paramInt] = k;
        return;
      }
      int m = -1;
      int k = m;
      if (jdField_a_of_type_ArrayOfBoolean[paramInt] != 0) {
        if (paramInt != 2)
        {
          k = this.jdField_a_of_type_AndroidMediaSoundPool.play(n, 1.0F, 1.0F, 1, 0, 1.0F);
        }
        else
        {
          k = m;
          if (this.jdField_e_of_type_Int == 0)
          {
            this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.play(n, 1.0F, 1.0F, 10, -1, 1.0F);
            k = m;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("playSound, ");
        localStringBuilder1.append(paramInt);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[paramInt]);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(jdField_a_of_type_ArrayOfBoolean[paramInt]);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(k);
        localStringBuilder1.append(", mPlayCountDownStreamId=");
        localStringBuilder1.append(this.jdField_e_of_type_Int);
        QLog.d("PortalManager", 2, localStringBuilder1.toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("playSound, throwable=");
        localStringBuilder2.append(localThrowable.getMessage());
        QLog.d("PortalManager", 2, localStringBuilder2.toString());
        localThrowable.printStackTrace();
      }
    }
    return;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new PortalManager.1(this, paramLong1, paramLong2, paramLong3));
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clickBanner, ");
      localObject = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
      if (localObject != null) {
        localObject = Integer.valueOf(((PortalManager.BannerConfig)localObject).useFlag + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id);
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramBoolean);
      QLog.i("PortalManager", 2, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
    if (localObject != null)
    {
      if (((PortalManager.BannerConfig)localObject).useFlag < 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag = 2;
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        a(null, 1, false, 0L);
      }
      if (paramBoolean)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl))
        {
          if (paramActivity != null) {
            localObject = paramActivity;
          } else {
            localObject = BaseApplicationImpl.sApplication;
          }
          localObject = new Intent((Context)localObject, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl);
          ((Intent)localObject).putExtra("hide_left_button", true);
          ((Intent)localObject).putExtra("show_right_close_button", true);
          ((Intent)localObject).putExtra("finish_animation_up_down", true);
          ((Intent)localObject).putExtra("hide_operation_bar", true);
          ((Intent)localObject).addFlags(67108864);
          if (paramActivity != null)
          {
            paramActivity.startActivity((Intent)localObject);
          }
          else
          {
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
            }
          }
        }
        else
        {
          paramActivity = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
          if ((paramActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)) {
            paramActivity.a();
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077E7", "0X80077E7", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077E6", "0X80077E6", 0, 0, "", "", "", "");
    }
  }
  
  public void a(PortalManager.PortalShower paramPortalShower, int paramInt, boolean paramBoolean, long paramLong)
  {
    Object localObject4 = this;
    paramPortalShower = ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
    if (paramPortalShower == null) {
      return;
    }
    Object localObject1;
    if (1 == (paramInt & 0x1))
    {
      localObject1 = ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
      if (localObject1 == null)
      {
        paramPortalShower.b();
      }
      else if ((localObject1 != null) && (((PortalManager.BannerConfig)localObject1).useFlag < 2))
      {
        paramPortalShower = a(((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.bannarMd5, "hb_banner_path");
        if ((paramPortalShower != null) && (((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(paramPortalShower, ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl)))
        {
          ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag = 2;
          k = 1;
          break label111;
        }
      }
    }
    int k = 0;
    label111:
    if (2 == (paramInt & 0x2))
    {
      if (((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)
      {
        long l4 = ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.version << 30 | ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
        if (paramLong == 0L) {
          paramLong = NetConnInfoCenter.getServerTimeMillis();
        }
        long l2 = f;
        long l1 = paramLong;
        if (l2 > 0L) {
          l1 = l2 + i * (paramLong - g);
        }
        Bitmap localBitmap2 = a(((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.bgMd5, "hb_bg_name_path");
        Bitmap localBitmap3 = a(((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.leftCloudImageMD5, "hb_leftclound_name_path");
        Bitmap localBitmap4 = a(((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.rightCloudImageMD5, "hb_rightclound_name_path");
        paramLong = ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.scrollTime;
        l2 = paramLong;
        if (paramLong == 0L) {
          l2 = 3000L;
        }
        ArrayList localArrayList;
        if ((((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.size() > 0) && (((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode == 3))
        {
          localArrayList = new ArrayList(((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList);
          Collections.shuffle(localArrayList);
        }
        else
        {
          localArrayList = null;
        }
        Object localObject3;
        Object localObject2;
        Bitmap localBitmap1;
        if (((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 1)
        {
          if (l1 > ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd) {
            paramLong = Math.min(((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd - l1, ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd - ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd);
          } else {
            paramLong = -1L;
          }
          localObject3 = this;
          if (((PortalManager)localObject3).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode == 1)
          {
            localObject2 = (PortalManager.LogoConfig)((PortalManager)localObject3).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
            paramPortalShower = a(((PortalManager.LogoConfig)localObject2).logoImageMD5, "hb_yure_star_logo_path");
            localBitmap1 = a(((PortalManager.LogoConfig)localObject2).nameMD5, "hb_yure_star_name_path");
            localObject1 = a(((PortalManager.LogoConfig)localObject2).padantImageMD5, "hb_icon_path");
          }
          else if (((PortalManager)localObject3).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode == 2)
          {
            localObject2 = (PortalManager.LogoConfig)((PortalManager)localObject3).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
            paramPortalShower = a(((PortalManager.LogoConfig)localObject2).logoImageMD5, "hb_busi_logo_path");
            localBitmap1 = a(((PortalManager.LogoConfig)localObject2).nameMD5, "hb_yure_busi_name_path");
            localObject1 = a(((PortalManager.LogoConfig)localObject2).padantImageMD5, "hb_busi_logo_path");
          }
          else
          {
            localObject2 = null;
            paramPortalShower = null;
            localObject1 = null;
            localBitmap1 = null;
          }
          if (localObject2 != null) {
            localObject2 = a(((PortalManager.LogoConfig)localObject2).greetImageMD5, null);
          } else {
            localObject2 = null;
          }
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("refreshUi showPrepare ,countDown = ");
            ((StringBuilder)localObject4).append(paramLong);
            ((StringBuilder)localObject4).append(",serverTime = ");
            ((StringBuilder)localObject4).append(l1);
            ((StringBuilder)localObject4).append(",currentPortal.uiEnd = ");
            ((StringBuilder)localObject4).append(((PortalManager)localObject3).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd);
            ((StringBuilder)localObject4).append(",currentPortal.realEnd = ");
            ((StringBuilder)localObject4).append(((PortalManager)localObject3).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd);
            QLog.d("PortalManager", 2, ((StringBuilder)localObject4).toString());
          }
          ((PortalManager)localObject3).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(l4, ((PortalManager)localObject3).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode, localBitmap2, paramPortalShower, (Bitmap)localObject1, localBitmap3, localBitmap4, (Bitmap)localObject2, localBitmap1, localArrayList, ((PortalManager)localObject3).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.rightMsg, paramLong, paramBoolean, l2);
          paramInt = k;
          if (((PortalManager)localObject3).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag >= 2) {
            break label1445;
          }
          paramInt = k;
          if (((PortalManager)localObject3).jdField_d_of_type_Boolean) {
            break label1445;
          }
          paramInt = k;
          if (!((PortalManager)localObject3).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a()) {
            break label1445;
          }
          ((PortalManager)localObject3).jdField_d_of_type_Boolean = true;
          ((PortalManager)localObject3).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag = 2;
          paramInt = 1;
          break label1445;
        }
        if (((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 2)
        {
          if (((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode == 1)
          {
            localObject3 = (PortalManager.LogoConfig)((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
            paramPortalShower = a(((PortalManager.LogoConfig)localObject3).logoImageMD5, "hb_icon_path");
            localBitmap1 = a(((PortalManager.LogoConfig)localObject3).nameMD5, "hb_name_path");
            localObject1 = a(((PortalManager.LogoConfig)localObject3).padantImageMD5, "hb_icon_path");
            localObject2 = a(((PortalManager.LogoConfig)localObject3).relationCompanyLogoMD5, "hb_busi_logo_path");
            localObject3 = a(((PortalManager.LogoConfig)localObject3).relationCompanyNameMD5, "hb_name_path");
          }
          else
          {
            if (((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode == 2)
            {
              localObject1 = (PortalManager.LogoConfig)((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
              paramPortalShower = a(((PortalManager.LogoConfig)localObject1).logoImageMD5, "hb_busi_logo_path");
              localBitmap1 = a(((PortalManager.LogoConfig)localObject1).nameMD5, "hb_name_path");
              localObject1 = a(((PortalManager.LogoConfig)localObject1).padantImageMD5, "hb_busi_logo_path");
            }
            else
            {
              paramPortalShower = null;
              localObject1 = null;
              localBitmap1 = null;
            }
            localObject2 = null;
            localObject3 = null;
          }
          String str1 = ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.grabMsg;
          String str2 = ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.actEndWording;
          String str3 = ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.nextActTime;
          String str4 = ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countDownTips;
          if (((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime > 0L)
          {
            long l3 = l1 - ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime;
            if (l3 <= ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime)
            {
              paramLong = l3;
              if (l3 > 0L) {}
            }
            else
            {
              paramLong = 0L;
            }
          }
          else if ((((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime == 0L) && (l1 >= ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd - ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime))
          {
            paramLong = 0L;
          }
          else
          {
            paramLong = -1L;
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("refreshUI  ,serverTime = ");
            localStringBuilder.append(l1);
            localStringBuilder.append(",currentPortal.useTime = ");
            localStringBuilder.append(((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime);
            localStringBuilder.append(",currentPortal.countTime = ");
            localStringBuilder.append(((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime);
            localStringBuilder.append(",currentPortal.realEnd = ");
            localStringBuilder.append(((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd);
            localStringBuilder.append(",countDown = ");
            localStringBuilder.append(paramLong);
            QLog.d("PortalManager", 2, localStringBuilder.toString());
          }
          ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(l4, ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode, localBitmap2, paramPortalShower, (Bitmap)localObject1, str1, str2, str3, str4, paramLong, paramBoolean, ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab, localBitmap3, localBitmap4, localArrayList, ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.comboNumberConfigs, localBitmap1, l2, (Bitmap)localObject2, (Bitmap)localObject3);
          if ((((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.showGesturesTime <= 0L) && (((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.b()))
          {
            ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.showGesturesTime = l1;
            paramInt = 1;
          }
          else
          {
            paramInt = k;
          }
        }
        else
        {
          if (((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 3)
          {
            paramPortalShower = a(((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.bgMd5, null);
            if (((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(paramPortalShower))
            {
              ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag = 2;
              paramInt = 1;
              break label1420;
            }
          }
          paramInt = k;
          ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a();
        }
        break label1445;
      }
      ((PortalManager)localObject4).jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a();
    }
    label1420:
    paramInt = k;
    label1445:
    if (paramInt != 0) {
      a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
    }
  }
  
  void a(boolean paramBoolean, int paramInt, long paramLong, Object paramObject)
  {
    if (!this.jdField_c_of_type_Boolean) {
      try
      {
        if (!this.jdField_c_of_type_Boolean)
        {
          Handler localHandler;
          if (paramBoolean) {
            localHandler = this.jdField_b_of_type_AndroidOsHandler;
          } else {
            localHandler = this.jdField_a_of_type_AndroidOsHandler;
          }
          localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, 0, 0, paramObject), paramLong);
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    PortalManager.PortalConfig localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
    return (localPortalConfig != null) && (localPortalConfig.type == 2);
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
      return FileUtils.pushData2File(a(), localByteArrayOutputStream.toByteArray(), false);
    }
    catch (Throwable paramRedPacketConfig)
    {
      paramRedPacketConfig.printStackTrace();
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isShowYYBao, url=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    int m = -1;
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
    Object localObject2 = null;
    int k = m;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      k = m;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs != null)
      {
        m = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs.size();
        k = m;
        if (m > 0)
        {
          localObject3 = (PortalManager.PortalConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs.get(0);
          localObject4 = (PortalManager.PortalConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs.get(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs.size() - 1);
          k = m;
          bool1 = bool2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (localObject3 == null) {
            break label322;
          }
          k = m;
          bool1 = bool2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (localObject4 == null) {
            break label322;
          }
          k = m;
          bool1 = bool2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (((PortalManager.PortalConfig)localObject3).realBegin > l) {
            break label322;
          }
          k = m;
          bool1 = bool2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (l > ((PortalManager.PortalConfig)localObject4).realEnd) {
            break label322;
          }
          paramString = URLUtil.a(paramString);
          k = m;
          bool1 = bool2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (paramString == null) {
            break label322;
          }
          k = m;
          bool1 = bool2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (!"redpacket2017".equalsIgnoreCase((String)paramString.get("from"))) {
            break label322;
          }
          bool1 = false;
          k = m;
          localObject1 = localObject4;
          localObject2 = localObject3;
          break label322;
        }
      }
    }
    localObject1 = null;
    bool1 = bool2;
    label322:
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("isShowYYBao, ");
      ((StringBuilder)localObject4).append(bool1);
      ((StringBuilder)localObject4).append(",");
      ((StringBuilder)localObject4).append(l);
      ((StringBuilder)localObject4).append(",");
      ((StringBuilder)localObject4).append(k);
      ((StringBuilder)localObject4).append(", startpor=");
      localObject3 = "";
      if (localObject2 != null)
      {
        paramString = new StringBuilder();
        paramString.append(localObject2.id);
        paramString.append(",");
        paramString.append(localObject2.realBegin);
        paramString = paramString.toString();
      }
      else
      {
        paramString = "";
      }
      ((StringBuilder)localObject4).append(paramString);
      ((StringBuilder)localObject4).append(", endpor=");
      paramString = (String)localObject3;
      if (localObject1 != null)
      {
        paramString = new StringBuilder();
        paramString.append(((PortalManager.PortalConfig)localObject1).id);
        paramString.append(",");
        paramString.append(((PortalManager.PortalConfig)localObject1).realEnd);
        paramString = paramString.toString();
      }
      ((StringBuilder)localObject4).append(paramString);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject4).toString());
    }
    return bool1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "clearData");
    }
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("red_packet_config2017_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localFile = new File(localFile, localStringBuilder.toString());
    if ((localFile.delete()) && (!localFile.delete())) {
      localFile.delete();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("testplaySound, stopCountDown, mPlayCountDownStreamId=");
      localStringBuilder.append(this.jdField_e_of_type_Int);
      localStringBuilder.append(", mPlayCountDownState=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d("PortalManager", 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_Int == 4) {
      return;
    }
    int k = this.jdField_e_of_type_Int;
    if (k != 0) {}
    try
    {
      if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
        this.jdField_a_of_type_AndroidMediaSoundPool.pause(k);
      }
      label91:
      this.jdField_e_of_type_Int = 0;
      this.jdField_b_of_type_Int = 4;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label91;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleMessage ");
      ((StringBuilder)localObject1).append(paramMessage.what);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramMessage.obj);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject1).toString());
    }
    int k = paramMessage.what;
    boolean bool1 = true;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 5)
          {
            if (k != 6)
            {
              if (k != 7)
              {
                if (k != 8)
                {
                  if (k == 100) {
                    break label742;
                  }
                  switch (k)
                  {
                  default: 
                    return false;
                  case 16: 
                    this.jdField_a_of_type_AndroidOsHandler.post(new PortalManager.reportRunnable(this, this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, b(), ((Long)paramMessage.obj).longValue(), false));
                    this.jdField_d_of_type_Int = 0;
                    this.jdField_c_of_type_Int = 0;
                    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
                    if ((!QLog.isColorLevel()) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null)) {
                      break;
                    }
                    paramMessage = new StringBuilder();
                    paramMessage.append("MSG_GRAB_TIMEOUT_REPORT | activity id:");
                    paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id);
                    paramMessage.append(", total count:");
                    paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
                    QLog.d("PortalManager", 2, paramMessage.toString());
                    return false;
                  case 15: 
                    this.jdField_a_of_type_AndroidOsHandler.post(new PortalManager.reportRunnable(this, this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 2, 0, 0, 0, 0L, false));
                    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
                    this.jdField_a_of_type_AndroidOsHandler.removeMessages(15);
                    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(15, 600000L);
                    return false;
                  case 14: 
                    if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof ArrayList))) {
                      break;
                    }
                    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                    k = paramMessage.arg1;
                    localObject2 = (ArrayList)paramMessage.obj;
                    if (paramMessage.arg2 != 1) {
                      bool1 = false;
                    }
                    RedPacketServlet.a((AppRuntime)localObject1, k, (ArrayList)localObject2, bool1, paramMessage.getData());
                    return false;
                  case 13: 
                    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower == null) {
                      break;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)
                    {
                      paramMessage = new StringBuilder();
                      paramMessage.append("MSG_GRAB_FAKE_EVENT, mShower");
                      paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower);
                      QLog.d("PortalManager", 2, paramMessage.toString());
                    }
                    localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
                    paramMessage = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
                    if (paramMessage != null) {
                      paramMessage = paramMessage.emptyMsg;
                    } else {
                      paramMessage = HardCodeUtil.a(2131708339);
                    }
                    ((PortalManager.PortalShower)localObject1).a(false, paramMessage, null);
                    return false;
                  case 12: 
                    a();
                    if ((!QLog.isColorLevel()) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null)) {
                      break;
                    }
                    paramMessage = new StringBuilder();
                    paramMessage.append("MSG_GRAB_TIMEOUT | activity id:");
                    paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id);
                    paramMessage.append(", total count:");
                    paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
                    QLog.d("PortalManager", 2, paramMessage.toString());
                    return false;
                  }
                }
                localObject1 = (PortalManager.PortalShower)paramMessage.obj;
                this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower = ((PortalManager.PortalShower)localObject1);
                a((PortalManager.PortalShower)localObject1, paramMessage.arg1, false, 0L);
                return false;
              }
              a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
              return false;
            }
            if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(6)) {
              break label826;
            }
            a((PortalManager.RedPacketConfig)paramMessage.obj);
            return false;
          }
          l = 0L;
          bool1 = false;
          break label755;
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null) {
        return true;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
      Object localObject2 = (PortalManager.RedPacketConfig)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig = ((PortalManager.RedPacketConfig)localObject2);
      boolean bool2;
      if (localObject2 != null)
      {
        bool2 = a((PortalManager.RedPacketConfig)localObject2, (PortalManager.RedPacketConfig)localObject1, true);
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.grebInterval, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.reportActiveInterval, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.reportNormalInterval);
          bool1 = bool2;
        }
      }
      else
      {
        label742:
        bool1 = false;
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      a(l);
      label755:
      if (paramMessage.what == 5) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      a(null, 3, bool2, l);
      if (bool1)
      {
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        return false;
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig == null) && (NetConnInfoCenter.servetTimeSecondInterv != 0L)) {
        a();
      }
      d();
    }
    label826:
    return false;
  }
  
  public void onDestroy()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "onDestroy");
      }
      this.jdField_c_of_type_Boolean = true;
      PortalManager.PortalConfig localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
      if ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() > 0) && (localPortalConfig.useTime > 0L))
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new PortalManager.reportRunnable(this, this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, b(), localPortalConfig.useTime, true));
        this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
      }
      if (this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.size() > 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new PortalManager.reportRunnable(this, this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 2, 0, 0, 0, 0L, true));
        this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(15);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      c();
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalJSReceiver);
      }
      catch (Exception localException)
      {
        QLog.e("PortalManager", 1, "onDestroy", localException);
      }
      if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
      {
        this.jdField_a_of_type_AndroidMediaSoundPool.release();
        this.jdField_a_of_type_AndroidMediaSoundPool = null;
      }
      return;
    }
    finally {}
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramSoundPool = new StringBuilder();
      paramSoundPool.append("testplaySound, onLoadComplete, ");
      paramSoundPool.append(paramInt1);
      paramSoundPool.append(", ");
      paramSoundPool.append(paramInt2);
      paramSoundPool.append(", mPlayCountDownStreamId=");
      paramSoundPool.append(this.jdField_e_of_type_Int);
      paramSoundPool.append(", mPlayCountDownState=");
      paramSoundPool.append(this.jdField_b_of_type_Int);
      QLog.d("PortalManager", 2, paramSoundPool.toString());
    }
    int k = 0;
    while ((k < 5) && (this.jdField_a_of_type_ArrayOfInt[k] != paramInt1)) {
      k += 1;
    }
    if (k == 5) {
      return;
    }
    if (paramInt2 == 0)
    {
      jdField_a_of_type_ArrayOfBoolean[k] = true;
      a(k, true);
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive, cmd = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", isSuccess = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramBundle);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, new Object[] { "onReceive", Integer.valueOf(paramInt) });
    }
    int k;
    int m;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 8) {
          return;
        }
        paramInt = paramBundle.getInt("k_code", -1);
        k = paramBundle.getInt("k_r_type");
        m = paramBundle.getInt("key_seq");
        if ((paramBoolean) && (paramInt == 0))
        {
          a(k, paramBundle.getString("k_result"), m);
          return;
        }
        a(k, m, null, paramInt, null);
        return;
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
      }
    }
    else
    {
      Object localObject3 = paramBundle.getString("key_url");
      k = paramBundle.getInt("k_id", -1);
      paramInt = paramBundle.getInt("k_code", -1);
      m = paramBundle.getInt("k_money", -1);
      int i2 = paramBundle.getInt("k_type", -1);
      boolean bool2 = paramBundle.getBoolean("k_s_follow", true);
      int n = paramBundle.getInt("key_award_id", -1);
      int i1 = paramBundle.getInt("key_promotion_id", -1);
      long l = paramBundle.getLong("key_send_url", -1L);
      paramBundle = paramBundle.getString("key_wish", "");
      if (paramBoolean) {
        this.h = (-this.h);
      }
      if (paramInt > 0) {
        this.jdField_c_of_type_Int += 1;
      }
      if ((paramBoolean) && (paramInt == 0))
      {
        this.jdField_d_of_type_Int += 1;
        if (i2 != 0)
        {
          if (i2 != 1)
          {
            this.jdField_d_of_type_Int -= 1;
            this.jdField_c_of_type_Int += 1;
          }
          else
          {
            paramInt = 0;
            break label445;
          }
        }
        else
        {
          paramInt = 1;
          break label445;
        }
      }
      paramInt = -1;
      paramBoolean = false;
      label445:
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onReceive cmd = CMD_RESULT, portId = ");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(", url = ");
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(", showType = ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(", money = ");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(", awardId = ");
        ((StringBuilder)localObject1).append(n);
        ((StringBuilder)localObject1).append(", promotionId = ");
        ((StringBuilder)localObject1).append(i1);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(", sendUrl = ");
        ((StringBuilder)localObject2).append(Long.valueOf(l));
        ((StringBuilder)localObject2).append(", wishing ");
        ((StringBuilder)localObject2).append(paramBundle);
        QLog.d("PortalManager", 2, new Object[] { localObject1, ((StringBuilder)localObject2).toString() });
      }
      PortalManager.PortalConfig localPortalConfig = a(k);
      if (localPortalConfig == null) {
        paramBoolean = false;
      }
      Object localObject2 = null;
      boolean bool1;
      if ((paramBoolean) && (localPortalConfig != null))
      {
        localObject1 = localPortalConfig.findRealAwardConfigById(n);
        paramBundle = (Bundle)localObject1;
        bool1 = paramBoolean;
        if (localObject1 == null)
        {
          localObject1 = localPortalConfig.findRealAwardConfigById(i1);
          paramBundle = (Bundle)localObject1;
          bool1 = paramBoolean;
          if (localObject1 == null)
          {
            bool1 = false;
            paramBundle = (Bundle)localObject1;
          }
        }
      }
      else
      {
        paramBundle = null;
        bool1 = paramBoolean;
      }
      localObject1 = localObject2;
      if (bool1)
      {
        localObject1 = localObject2;
        if (paramBundle != null)
        {
          localObject2 = new PortalManager.ResultData(null, paramBundle.awardTitle, paramBundle.awardMsg, k, paramInt, (String)localObject3, m, bool2, n, i1);
          localObject3 = localPortalConfig.logoList.iterator();
          for (;;)
          {
            localObject1 = localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            PortalManager.LogoConfig localLogoConfig = (PortalManager.LogoConfig)((Iterator)localObject3).next();
            if (localLogoConfig.logoId == paramBundle.logoId)
            {
              String str = localLogoConfig.logoImageMD5;
              if (localPortalConfig.mode == 1) {
                localObject1 = "hb_icon_path";
              } else {
                localObject1 = "hb_busi_logo_path";
              }
              ((PortalManager.ResultData)localObject2).b = a(str, (String)localObject1);
              ((PortalManager.ResultData)localObject2).jdField_c_of_type_AndroidGraphicsBitmap = a(localLogoConfig.nameMD5, "hb_name_path");
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower != null)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onReceive");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append("isSuccess ");
          ((StringBuilder)localObject2).append(bool1);
          QLog.d("PortalManager", 2, ((StringBuilder)localObject2).toString());
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
        if (localPortalConfig != null) {
          localObject2 = localPortalConfig.emptyMsg;
        } else {
          localObject2 = HardCodeUtil.a(2131708337);
        }
        ((PortalManager.PortalShower)localObject3).a(bool1, (String)localObject2, (PortalManager.ResultData)localObject1);
      }
      if ((bool1) && (paramBundle != null))
      {
        localPortalConfig.isHit = bool1;
        if (paramInt == 0) {
          localPortalConfig.hbCnt += 1;
        } else if (paramInt == 1) {
          localPortalConfig.cardCnt += 1;
        }
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(6)) {
          a(false, 6, 2000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        }
      }
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    int m = paramNetResp.mResult;
    int k = 1;
    boolean bool;
    if (m == 0) {
      bool = true;
    } else {
      bool = false;
    }
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    Object localObject2 = new File(localHttpNetReq.mOutPath);
    Object localObject1 = localHttpNetReq.getUserData();
    HashMap localHashMap = new HashMap();
    if ((localObject1 != null) && ((localObject1 instanceof String[])))
    {
      localObject1 = (String[])localObject1;
      m = Integer.valueOf(localObject1[0]).intValue();
      localObject1 = localObject1[1];
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject1)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject1);
      }
      if (bool) {
        if (((String)localObject1).equals(PortalUtils.a(((File)localObject2).getAbsolutePath())))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
          PortalManager.PortalConfig localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
          if ((localObject2 != null) && (((PortalManager.BannerConfig)localObject2).id == m))
          {
            a((String)localObject1, "hb_banner_path");
            a(true, 5, 0L, null);
          }
          else if ((localPortalConfig != null) && (localPortalConfig.id == m))
          {
            a(true, 5, 0L, null);
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onRespMSG_UPDATE_UI, md5 = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.i("PortalManager", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          ((File)localObject2).delete();
          localHashMap.put("param_checkMd5Fail", "checkMd5Fail");
        }
      }
    }
    else
    {
      ((File)localObject2).delete();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResp");
      ((StringBuilder)localObject1).append(localHttpNetReq.mReqUrl);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramNetResp.mResult);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramNetResp.mErrCode);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append((String)localHashMap.get("param_checkMd5Fail"));
      QLog.i("PortalManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (!bool)
    {
      localHashMap.put("param_Url", localHttpNetReq.mReqUrl);
      localHashMap.put("param_ResultCode", String.valueOf(paramNetResp.mResult));
      localHashMap.put("param_FailCode", String.valueOf(paramNetResp.mErrCode));
    }
    else if (new Random().nextInt(10000) == 1000)
    {
      localHashMap.put("param_Url", localHttpNetReq.mReqUrl);
      localHashMap.put("param_ResultCode", String.valueOf(paramNetResp.mResult));
    }
    else
    {
      k = 0;
    }
    if (k != 0)
    {
      paramNetResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext()).collectPerformance(paramNetResp, "RedPacketPicDownload", bool, 0L, 0L, localHashMap, "", false);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager
 * JD-Core Version:    0.7.0.1
 */