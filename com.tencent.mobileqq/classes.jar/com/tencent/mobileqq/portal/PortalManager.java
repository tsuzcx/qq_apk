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
  private static Comparator<PortalManager.TimerConfig> J;
  private static PortalManager.TimerConfig K;
  private static long N = 0L;
  private static final boolean[] P = { 0, 0, 0, 0, 0 };
  private static final int[] Q = { 2131230820, 2131230822, 2131230821, 2131230819, 2131230823 };
  static long a = 2500L;
  static long b = 180000L;
  static long c = 180000L;
  static int d = 1;
  public static boolean e = false;
  public static final String h;
  static SimpleDateFormat k;
  public static long m;
  public static long n;
  static final String[] s = { "2016-12-13", "2016-12-14", "2017-1-20", "2017-1-27", "2017-1-28" };
  private PortalManager.PortalConfig A;
  private PortalManager.PortalConfig B;
  private Context C;
  private Handler D;
  private QQAppInterface E;
  private Handler F;
  private boolean G;
  private boolean H = false;
  private IHttpEngineService I;
  private int L = 0;
  private int M = 0;
  private final int[] O = { 0, 0, 0, 0, 0 };
  private int R = 0;
  private AvatarObserver S = new PortalManager.4(this);
  private long T = 0L;
  SparseArrayCompat<ArrayList<Long>> f = new SparseArrayCompat(1);
  protected volatile PortalManager.RedPacketConfig g;
  public long i = 0L;
  Set<String> j = Collections.synchronizedSet(new HashSet());
  volatile long l = 0L;
  int o = 4;
  SparseArrayCompat<ArrayList<Long>> p = new SparseArrayCompat(100);
  final ConcurrentHashMap<String, PortalManager.IconReqDetails> q = new ConcurrentHashMap(1000);
  PortalManager.PortalJSReceiver r;
  private SoundPool t;
  private OlympicDPC u;
  private long v = 0L;
  private boolean w = false;
  private PortalManager.PortalShower x;
  private PortalManager.BannerConfig y;
  private PortalManager.BannerConfig z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(File.separator);
    localStringBuilder.append("redPacketRes/");
    h = localStringBuilder.toString();
    J = new PortalManager.3();
    K = new PortalManager.TimerConfig(null);
    k = null;
    m = 0L;
    n = 0L;
  }
  
  public PortalManager(QQAppInterface paramQQAppInterface)
  {
    this.E = paramQQAppInterface;
    this.C = BaseApplicationImpl.sApplication;
    this.D = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.F = new Handler(Looper.getMainLooper(), this);
    this.D.sendEmptyMessageDelayed(1, 5000L);
    this.r = new PortalManager.PortalJSReceiver(this, null);
    try
    {
      this.E.getApp().registerReceiver(this.r, new IntentFilter("com.tencent.portal.req.action"), "com.tencent.msg.permission.pushnotify", null);
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("PortalManager", 1, "", paramQQAppInterface);
    }
    this.E.registObserver(this);
    this.E.addObserver(this.S);
  }
  
  public static long a(String paramString)
  {
    if (k == null)
    {
      k = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      k.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    try
    {
      long l1 = k.parse(paramString).getTime();
      return l1;
    }
    catch (ParseException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "", paramString);
      }
    }
    return -1L;
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
        break label330;
      }
      localObject4 = (PortalManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MGR_PORTAL);
      localObject2 = localMQLruCache1;
      if (localObject4 != null) {
        localObject2 = ((PortalManager)localObject4).u;
      }
      localObject2 = a("", paramInt, (OlympicDPC)localObject2, 2);
      if (localObject2 != null)
      {
        localObject2 = (Bitmap)((Pair)localObject2).second;
        localObject1 = localObject2;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        break label353;
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
        break label353;
      }
      QLog.e("PortalManager", 2, "preloadDrawableById Exception", localException1);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    label330:
    Object localObject3 = localObject4;
    if (QLog.isColorLevel())
    {
      QLog.e("PortalManager", 2, "preloadDrawableById OutOfMemoryError", paramString);
      localObject3 = localObject4;
    }
    label353:
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
    ((StringBuilder)localObject1).append(h);
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
          paramString1 = a(localStringBuilder.toString(), -1, ((PortalManager)localObject1).u, 1);
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
            break label334;
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
            break label352;
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
      label334:
      label352:
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
        int i1 = e(paramString);
        if (i1 < 0) {
          return null;
        }
        localObject1 = (PortalManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MGR_PORTAL);
        if (localObject1 != null)
        {
          localObject1 = ((PortalManager)localObject1).u;
          Object localObject3 = a("", i1, (OlympicDPC)localObject1, 2);
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
    int i2 = 0;
    try
    {
      try
      {
        Object localObject3 = new BitmapFactory.Options();
        if (paramOlympicDPC != null)
        {
          ((BitmapFactory.Options)localObject3).inPurgeable = true;
          ((BitmapFactory.Options)localObject3).inInputShareable = true;
          if (paramOlympicDPC.e)
          {
            ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.ARGB_8888;
          }
          else
          {
            ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.RGB_565;
            ((BitmapFactory.Options)localObject3).inDither = true;
          }
          if (paramOlympicDPC.c) {
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
        i1 = 1;
        paramOlympicDPC = (OlympicDPC)localObject1;
        localObject1 = localStringBuilder;
        break label380;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      int i1;
      label281:
      break label281;
    }
    if ((paramOlympicDPC != null) && (!paramOlympicDPC.c))
    {
      paramOlympicDPC.c = true;
      if (!paramOlympicDPC.d)
      {
        paramOlympicDPC = a(paramString, paramInt1, paramOlympicDPC, paramInt2);
        localObject1 = (Bitmap)paramOlympicDPC.second;
        break label330;
      }
    }
    localObject1 = null;
    paramOlympicDPC = localStringBuilder;
    label330:
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeBitmap OOM|path:");
      localStringBuilder.append(paramString);
      QLog.d("PortalManager", 2, localStringBuilder.toString());
    }
    paramInt1 = 1;
    i1 = 0;
    paramInt2 = paramInt1;
    label380:
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
      paramInt1 = i2;
      if (i1 != 0) {
        paramInt1 = 3;
      }
    }
    if ((localObject1 == null) && (paramInt2 == 0) && (i1 == 0)) {}
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
      label489:
      long l1;
      break label489;
    }
    paramString = new Pair(Integer.valueOf(paramInt1), localObject1);
    if (QLog.isColorLevel())
    {
      if (localObject1 == null) {
        l1 = 0L;
      } else {
        l1 = ((Bitmap)localObject1).getRowBytes() * ((Bitmap)localObject1).getHeight() / 1024;
      }
      paramOlympicDPC = new StringBuilder();
      paramOlympicDPC.append("decodeBitmap|size:");
      paramOlympicDPC.append(l1);
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
    int i1 = paramXmlPullParser.next();
    Object localObject4;
    for (Object localObject1 = ""; i1 != 1; localObject1 = localObject4)
    {
      String str = paramXmlPullParser.getName();
      if ((i1 == 3) && (str.equalsIgnoreCase(paramString))) {
        break;
      }
      Object localObject3 = localObject2;
      localObject4 = localObject1;
      if (i1 == 2) {
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
      i1 = paramXmlPullParser.next();
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
            break label3919;
          }
          Object localObject7 = localXmlPullParser.getName();
          if (((String)localObject7).equalsIgnoreCase("Common"))
          {
            paramInt1 = localXmlPullParser.next();
            localObject5 = localObject2;
            localObject4 = localObject1;
            localObject6 = localObject3;
            if (paramInt1 == 1) {
              break label3919;
            }
            localObject5 = localXmlPullParser.getName();
            if ((paramInt1 == 3) && (((String)localObject5).equalsIgnoreCase("Common")))
            {
              localObject5 = localObject2;
              localObject4 = localObject1;
              localObject6 = localObject3;
              break label3919;
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
            break label3919;
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
              break label3919;
            }
            localObject4 = localXmlPullParser.getName();
            if ((paramInt1 == 3) && (((String)localObject4).equalsIgnoreCase((String)localObject1)))
            {
              localRedPacketConfig.bannerConfigs.add(localObject7);
              localObject5 = localObject2;
              localObject4 = localObject1;
              localObject6 = localObject3;
              break label3919;
            }
            if (paramInt1 != 2) {
              break label3922;
            }
            if (((String)localObject4).equalsIgnoreCase(str))
            {
              ((PortalManager.BannerConfig)localObject7).id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
              break label3922;
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
            break label3919;
          }
          localObject7 = new PortalManager.PortalConfig();
          paramInt1 = localXmlPullParser.next();
          localObject5 = localObject2;
          localObject4 = localObject1;
          localObject6 = localObject3;
          if (paramInt1 == 1) {
            break label3919;
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
              break label3919;
            }
            localObject5 = localObject2;
            localObject4 = localObject1;
            localObject6 = localObject3;
            if (!QLog.isColorLevel()) {
              break label3919;
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
            break label3919;
          }
          if (paramInt1 != 2) {
            break label3936;
          }
          if (((String)localObject6).equalsIgnoreCase(str))
          {
            ((PortalManager.PortalConfig)localObject7).id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            break label3925;
          }
          if (((String)localObject6).equalsIgnoreCase("Type"))
          {
            ((PortalManager.PortalConfig)localObject7).type = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            break label3925;
          }
          if (((String)localObject6).equalsIgnoreCase("Mode"))
          {
            ((PortalManager.PortalConfig)localObject7).mode = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            break label3925;
          }
          long l1;
          if (((String)localObject6).equalsIgnoreCase("BeginTime"))
          {
            l1 = a(localXmlPullParser.nextText());
            ((PortalManager.PortalConfig)localObject7).realBegin = l1;
            ((PortalManager.PortalConfig)localObject7).uiBegin = l1;
            break label3925;
          }
          if (((String)localObject6).equalsIgnoreCase("EndTime"))
          {
            l1 = a(localXmlPullParser.nextText());
            ((PortalManager.PortalConfig)localObject7).realEnd = l1;
            ((PortalManager.PortalConfig)localObject7).uiEnd = l1;
            break label3925;
          }
          if (((String)localObject6).equalsIgnoreCase("BackGroundImage"))
          {
            localObject4 = a(localXmlPullParser, (String)localObject6);
            ((PortalManager.PortalConfig)localObject7).bgImg = ((String)((Pair)localObject4).first);
            ((PortalManager.PortalConfig)localObject7).bgMd5 = ((String)((Pair)localObject4).second);
            break label3925;
          }
          if (((String)localObject6).equalsIgnoreCase("activityTime"))
          {
            ((PortalManager.PortalConfig)localObject7).rightMsg = localXmlPullParser.nextText();
            break label3925;
          }
          if (((String)localObject6).equalsIgnoreCase("scrollTime"))
          {
            ((PortalManager.PortalConfig)localObject7).scrollTime = (Integer.parseInt(localXmlPullParser.nextText()) * 1000);
            break label3925;
          }
          if (((String)localObject6).equalsIgnoreCase("Timer"))
          {
            ((PortalManager.PortalConfig)localObject7).countTime = (Integer.parseInt(localXmlPullParser.nextText()) * 1000);
            break label3925;
          }
          if (((String)localObject6).equalsIgnoreCase("GrabWording"))
          {
            ((PortalManager.PortalConfig)localObject7).grabMsg = localXmlPullParser.nextText();
            break label3925;
          }
          if (((String)localObject6).equalsIgnoreCase("NoRPWording"))
          {
            ((PortalManager.PortalConfig)localObject7).emptyMsg = localXmlPullParser.nextText();
            break label3925;
          }
          if (((String)localObject6).equalsIgnoreCase("LeftCloudImage"))
          {
            localObject4 = a(localXmlPullParser, (String)localObject6);
            ((PortalManager.PortalConfig)localObject7).leftCloudImageUrl = ((String)((Pair)localObject4).first);
            ((PortalManager.PortalConfig)localObject7).leftCloudImageMD5 = ((String)((Pair)localObject4).second);
            break label3925;
          }
          if (((String)localObject6).equalsIgnoreCase("RightCloudImage"))
          {
            localObject4 = a(localXmlPullParser, (String)localObject6);
            ((PortalManager.PortalConfig)localObject7).rightCloudImageURL = ((String)((Pair)localObject4).first);
            ((PortalManager.PortalConfig)localObject7).rightCloudImageMD5 = ((String)((Pair)localObject4).second);
            break label3925;
          }
          bool = ((String)localObject6).equalsIgnoreCase("Logo");
          if (bool)
          {
            localObject5 = new PortalManager.LogoConfig();
            ((PortalManager.PortalConfig)localObject7).logoList.add(localObject5);
            paramInt1 = localXmlPullParser.next();
            localObject4 = localObject1;
            if (paramInt1 == 1) {
              break label3929;
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
        int i3 = localRedPacketConfig.portalConfigs.size();
        paramInt1 = 0;
        if (paramArrayList == null) {
          break label3939;
        }
        paramInt2 = paramArrayList.size();
        if ((paramInt2 != 0) && (i3 > 0))
        {
          Collections.sort(localRedPacketConfig.portalConfigs, J);
          localObject1 = (PortalManager.PortalConfig)localRedPacketConfig.portalConfigs.get(0);
          if (((PortalManager.PortalConfig)localObject1).type != 2) {
            break label3944;
          }
          ((PortalManager.PortalConfig)localObject1).uiBegin = (((PortalManager.PortalConfig)localObject1).realBegin + ((Integer)paramArrayList.get(0 % paramInt2)).intValue());
          paramInt1 = 1;
          break label3944;
          if (i1 < i3)
          {
            localObject2 = (PortalManager.PortalConfig)localRedPacketConfig.portalConfigs.get(i1);
            paramInt1 = i2;
            if (((PortalManager.PortalConfig)localObject2).type != 2) {
              break label3958;
            }
            ((PortalManager.PortalConfig)localObject2).uiBegin = (((PortalManager.PortalConfig)localObject2).realBegin + ((Integer)paramArrayList.get(i2 % paramInt2)).intValue() * 1000);
            if ((localObject1 == null) || (((PortalManager.PortalConfig)localObject1).type != 1) || (((PortalManager.PortalConfig)localObject1).realEnd + 2000L < ((PortalManager.PortalConfig)localObject2).realBegin)) {
              break label3953;
            }
            ((PortalManager.PortalConfig)localObject1).uiEnd = (((PortalManager.PortalConfig)localObject1).realEnd + ((Integer)paramArrayList.get(i2 % paramInt2)).intValue() * 1000);
            break label3953;
          }
        }
        Collections.sort(localRedPacketConfig.portalConfigs, J);
        paramInt1 = localRedPacketConfig.bannerConfigs.size() - 1;
        if (paramInt1 >= 0)
        {
          localObject1 = (PortalManager.BannerConfig)localRedPacketConfig.bannerConfigs.get(paramInt1);
          localObject2 = localRedPacketConfig.portalConfigs.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label3974;
          }
          localObject3 = (PortalManager.PortalConfig)((Iterator)localObject2).next();
          if ((((PortalManager.BannerConfig)localObject1).uiBegin >= ((PortalManager.PortalConfig)localObject3).realBegin) && (((PortalManager.BannerConfig)localObject1).uiBegin < ((PortalManager.PortalConfig)localObject3).realEnd))
          {
            if (((PortalManager.BannerConfig)localObject1).uiBegin != ((PortalManager.PortalConfig)localObject3).realBegin) {
              break label3974;
            }
            ((PortalManager.BannerConfig)localObject1).uiBegin = ((PortalManager.PortalConfig)localObject3).uiBegin;
            break label3974;
          }
          if (((PortalManager.PortalConfig)localObject3).uiBegin <= ((PortalManager.BannerConfig)localObject1).uiBegin) {
            continue;
          }
          break label3974;
        }
        Collections.sort(localRedPacketConfig.bannerConfigs, J);
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
      label3919:
      continue;
      label3922:
      continue;
      label3925:
      Object localObject4 = localObject1;
      label3929:
      localObject1 = localObject4;
      continue;
      label3936:
      continue;
      label3939:
      paramInt2 = 0;
      continue;
      label3944:
      int i1 = 1;
      int i2 = paramInt1;
      continue;
      label3953:
      paramInt1 = i2 + 1;
      label3958:
      i1 += 1;
      localObject1 = localObject2;
      i2 = paramInt1;
      continue;
      label3974:
      paramInt1 -= 1;
    }
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
    ((Bundle)localObject3).putByteArray("bc_data", PortalUtils.d(paramString));
    ((Intent)localObject2).putExtras((Bundle)localObject3);
    if (paramInt2 > 0) {
      ((Intent)localObject2).putExtra("bc_seq", paramInt2);
    }
    this.E.getApp().sendBroadcast((Intent)localObject2, "com.tencent.msg.permission.pushnotify");
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
    if (this.I == null) {
      this.I = ((IHttpEngineService)this.E.getRuntimeService(IHttpEngineService.class, "all"));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.E.getApplication().getFilesDir());
    ((StringBuilder)localObject).append(h);
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
    this.I.sendReq(localHttpNetReq);
  }
  
  private static void a(PortalManager.RedPacketConfig paramRedPacketConfig, String paramString)
  {
    int i4 = paramRedPacketConfig.bannerConfigs.size();
    int i3 = paramRedPacketConfig.portalConfigs.size();
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(paramString);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramRedPacketConfig.id);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramRedPacketConfig.version);
    localStringBuilder.append('[');
    int i2 = 0;
    int i1 = 0;
    while (i1 < i4)
    {
      localStringBuilder.append(((PortalManager.BannerConfig)paramRedPacketConfig.bannerConfigs.get(i1)).id);
      localStringBuilder.append(", ");
      i1 += 1;
    }
    localStringBuilder.append(']');
    localStringBuilder.append(", ");
    localStringBuilder.append('[');
    i1 = i2;
    while (i1 < i3)
    {
      localStringBuilder.append(((PortalManager.PortalConfig)paramRedPacketConfig.portalConfigs.get(i1)).id);
      localStringBuilder.append(", ");
      i1 += 1;
    }
    localStringBuilder.append(']');
    QLog.d("PortalManager", 2, localStringBuilder.toString());
  }
  
  @SuppressLint({"UseSparseArrays"})
  private boolean a(PortalManager.RedPacketConfig paramRedPacketConfig1, PortalManager.RedPacketConfig paramRedPacketConfig2, boolean paramBoolean)
  {
    int i3 = paramRedPacketConfig1.portalConfigs.size();
    int i2 = 0;
    if (paramRedPacketConfig2 != null) {
      i1 = paramRedPacketConfig2.portalConfigs.size();
    } else {
      i1 = 0;
    }
    if (paramRedPacketConfig2 != null) {
      paramRedPacketConfig1.showGesturesTime = paramRedPacketConfig2.showGesturesTime;
    }
    HashMap localHashMap;
    Object localObject;
    if ((i3 > 0) && (i1 > 0))
    {
      localHashMap = new HashMap(i1);
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
    i3 = paramRedPacketConfig1.bannerConfigs.size();
    int i1 = i2;
    if (paramRedPacketConfig2 != null) {
      i1 = paramRedPacketConfig2.bannerConfigs.size();
    }
    paramBoolean = bool;
    if (i3 > 0)
    {
      paramBoolean = bool;
      if (i1 > 0)
      {
        localHashMap = new HashMap(i1);
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
  
  public static Bitmap b(String paramString)
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
  
  private void b(long paramLong)
  {
    Object localObject3 = this.g;
    if (localObject3 == null) {
      return;
    }
    long l1 = m;
    long l2;
    if (l1 > 0L) {
      l2 = l1 + N * (paramLong - n);
    } else {
      l2 = paramLong;
    }
    this.F.removeMessages(100);
    Object localObject4 = ((PortalManager.RedPacketConfig)localObject3).bannerConfigs;
    Object localObject1 = K;
    ((PortalManager.TimerConfig)localObject1).uiBegin = l2;
    int i1 = Collections.binarySearch((List)localObject4, localObject1, J);
    if (i1 >= 0) {
      i1 += 1;
    } else {
      i1 = -i1 - 1;
    }
    Object localObject5 = null;
    Object localObject2;
    if ((i1 > 0) && (i1 <= ((ArrayList)localObject4).size()))
    {
      localObject2 = (PortalManager.BannerConfig)((ArrayList)localObject4).get(i1 - 1);
      localObject1 = localObject2;
      if (((PortalManager.BannerConfig)localObject2).uiEnd >= l2) {}
    }
    else
    {
      localObject1 = null;
    }
    if ((i1 < ((ArrayList)localObject4).size()) && (i1 >= 0)) {
      localObject2 = (PortalManager.BannerConfig)((ArrayList)localObject4).get(i1);
    } else {
      localObject2 = null;
    }
    ArrayList localArrayList = ((PortalManager.RedPacketConfig)localObject3).portalConfigs;
    i1 = Collections.binarySearch(localArrayList, K, J);
    if (i1 >= 0) {
      i1 += 1;
    } else {
      i1 = -i1 - 1;
    }
    if ((i1 > 0) && (i1 <= localArrayList.size()))
    {
      localObject4 = (PortalManager.PortalConfig)localArrayList.get(i1 - 1);
      localObject3 = localObject4;
      if (((PortalManager.PortalConfig)localObject4).uiEnd >= l2) {}
    }
    else
    {
      localObject3 = null;
    }
    localObject4 = localObject5;
    if (i1 < localArrayList.size())
    {
      localObject4 = localObject5;
      if (i1 >= 0) {
        localObject4 = (PortalManager.PortalConfig)localArrayList.get(i1);
      }
    }
    this.y = ((PortalManager.BannerConfig)localObject1);
    this.z = ((PortalManager.BannerConfig)localObject2);
    this.A = ((PortalManager.PortalConfig)localObject3);
    this.B = ((PortalManager.PortalConfig)localObject4);
    localObject1 = this.y;
    if (localObject1 != null)
    {
      paramLong = ((PortalManager.BannerConfig)localObject1).uiEnd;
    }
    else
    {
      localObject1 = this.z;
      if (localObject1 != null) {
        paramLong = ((PortalManager.BannerConfig)localObject1).uiBegin;
      } else {
        paramLong = 9223372036854775807L;
      }
    }
    localObject1 = this.A;
    if (localObject1 != null)
    {
      if ((((PortalManager.PortalConfig)localObject1).realEnd > l2) && (this.A.realEnd < paramLong))
      {
        l1 = this.A.realEnd;
      }
      else
      {
        l1 = paramLong;
        if (this.A.uiEnd > l2)
        {
          l1 = paramLong;
          if (this.A.uiEnd < paramLong) {
            l1 = this.A.uiEnd;
          }
        }
      }
      paramLong = l1;
      if (this.A.type == 2)
      {
        long l3 = this.A.realEnd - this.A.countTime;
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
              ((StringBuilder)localObject1).append(this.A.countTime);
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
      this.T = this.A.realEnd;
      l1 = paramLong;
    }
    else
    {
      localObject1 = this.B;
      l1 = paramLong;
      if (localObject1 != null)
      {
        l1 = paramLong;
        if (((PortalManager.PortalConfig)localObject1).uiBegin < paramLong) {
          l1 = this.B.uiBegin;
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
      if (m != 0L) {
        l2 = 1000L;
      }
      a(true, 100, l2, null);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateCurrentTimer, ");
      localObject2 = this.y;
      int i2 = -1;
      if (localObject2 != null) {
        i1 = ((PortalManager.BannerConfig)localObject2).id;
      } else {
        i1 = -1;
      }
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", ");
      localObject2 = this.z;
      if (localObject2 != null) {
        i1 = ((PortalManager.BannerConfig)localObject2).id;
      } else {
        i1 = -1;
      }
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", ");
      localObject2 = this.A;
      if (localObject2 != null) {
        i1 = ((PortalManager.PortalConfig)localObject2).id;
      } else {
        i1 = -1;
      }
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", ");
      localObject2 = this.B;
      if (localObject2 != null) {
        i1 = ((PortalManager.PortalConfig)localObject2).id;
      } else {
        i1 = -1;
      }
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append(", ");
      localObject2 = this.A;
      i1 = i2;
      if (localObject2 != null) {
        i1 = ((PortalManager.PortalConfig)localObject2).useFlag;
      }
      ((StringBuilder)localObject1).append(i1);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void c(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    if (FileUtils.getAvailableInnernalMemorySize() < 1048576.0F) {
      return;
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    Iterator localIterator1 = paramRedPacketConfig.bannerConfigs.iterator();
    Object localObject1;
    while (localIterator1.hasNext())
    {
      localObject1 = (PortalManager.BannerConfig)localIterator1.next();
      if ((((PortalManager.BannerConfig)localObject1).uiEnd > l1) && (d(((PortalManager.BannerConfig)localObject1).bannarMd5))) {
        a(((PortalManager.BannerConfig)localObject1).id, ((PortalManager.BannerConfig)localObject1).bannerImg, ((PortalManager.BannerConfig)localObject1).bannarMd5);
      }
    }
    if (paramRedPacketConfig.comboNumberConfigs != null)
    {
      localIterator1 = paramRedPacketConfig.comboNumberConfigs.iterator();
      while (localIterator1.hasNext())
      {
        localObject1 = (PortalManager.ComboNumber)localIterator1.next();
        if (d(((PortalManager.ComboNumber)localObject1).flowerImageMD5)) {
          a(-101, ((PortalManager.ComboNumber)localObject1).flowerImageUrl, ((PortalManager.ComboNumber)localObject1).flowerImageMD5);
        }
        if (d(((PortalManager.ComboNumber)localObject1).numberImageMD5)) {
          a(-101, ((PortalManager.ComboNumber)localObject1).numberImageUrl, ((PortalManager.ComboNumber)localObject1).numberImageMD5);
        }
        if (d(((PortalManager.ComboNumber)localObject1).flowerImage2MD5)) {
          a(-101, ((PortalManager.ComboNumber)localObject1).flowerImage2Url, ((PortalManager.ComboNumber)localObject1).flowerImage2MD5);
        }
      }
    }
    localIterator1 = paramRedPacketConfig.portalConfigs.iterator();
    while (localIterator1.hasNext())
    {
      localObject1 = (PortalManager.PortalConfig)localIterator1.next();
      if ((localObject1 != null) && ((((PortalManager.PortalConfig)localObject1).uiEnd > l1) || (((PortalManager.PortalConfig)localObject1).realEnd > l1)))
      {
        if (d(((PortalManager.PortalConfig)localObject1).bgMd5)) {
          a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.PortalConfig)localObject1).bgImg, ((PortalManager.PortalConfig)localObject1).bgMd5);
        }
        if (d(((PortalManager.PortalConfig)localObject1).leftCloudImageMD5)) {
          a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.PortalConfig)localObject1).leftCloudImageUrl, ((PortalManager.PortalConfig)localObject1).leftCloudImageMD5);
        }
        if (d(((PortalManager.PortalConfig)localObject1).rightCloudImageMD5)) {
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
              if (d(((PortalManager.LogoConfig)localObject2).logoImageMD5)) {
                a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.LogoConfig)localObject2).logoImageUrl, ((PortalManager.LogoConfig)localObject2).logoImageMD5);
              }
              if (d(((PortalManager.LogoConfig)localObject2).nameMD5)) {
                a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.LogoConfig)localObject2).nameUrl, ((PortalManager.LogoConfig)localObject2).nameMD5);
              }
              if (d(((PortalManager.LogoConfig)localObject2).greetImageMD5)) {
                a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.LogoConfig)localObject2).greetImageUrl, ((PortalManager.LogoConfig)localObject2).greetImageMD5);
              }
              if (d(((PortalManager.LogoConfig)localObject2).padantImageMD5)) {
                a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.LogoConfig)localObject2).padantImageUrl, ((PortalManager.LogoConfig)localObject2).padantImageMD5);
              }
              if (d(((PortalManager.LogoConfig)localObject2).relationCompanyLogoMD5)) {
                a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.LogoConfig)localObject2).relationCompanyLogoUrl, ((PortalManager.LogoConfig)localObject2).relationCompanyLogoMD5);
              }
              if (d(((PortalManager.LogoConfig)localObject2).relationCompanyNameMD5)) {
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
              if (d(((PortalManager.AwardConfig)localObject2).awardMd5)) {
                a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.AwardConfig)localObject2).awardImg, ((PortalManager.AwardConfig)localObject2).awardMd5);
              }
              if (d(((PortalManager.AwardConfig)localObject2).starMd5)) {
                a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.AwardConfig)localObject2).starImg, ((PortalManager.AwardConfig)localObject2).starMd5);
              }
              if (d(((PortalManager.AwardConfig)localObject2).ctfBgMd5)) {
                a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.AwardConfig)localObject2).ctfBgImg, ((PortalManager.AwardConfig)localObject2).ctfBgMd5);
              }
            }
          }
        }
        if (d(((PortalManager.PortalConfig)localObject1).shareStarImageMD5)) {
          a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.PortalConfig)localObject1).shareStarImageUrl, ((PortalManager.PortalConfig)localObject1).shareStarImageMD5);
        }
        if (d(((PortalManager.PortalConfig)localObject1).starGuiderPhotoMD5)) {
          a(((PortalManager.PortalConfig)localObject1).id, ((PortalManager.PortalConfig)localObject1).starGuiderPhotoURL, ((PortalManager.PortalConfig)localObject1).starGuiderPhotoMD5);
        }
      }
    }
    if (System.currentTimeMillis() - this.i > 1800000L)
    {
      this.i = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "tryDownload needReport");
      }
      this.D.postDelayed(new PortalManager.2(this, paramRedPacketConfig), 60000L);
    }
  }
  
  private void d(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    Object localObject1 = paramRedPacketConfig.bannerConfigs.iterator();
    boolean bool3 = true;
    while (((Iterator)localObject1).hasNext()) {
      bool3 &= (d(((PortalManager.BannerConfig)((Iterator)localObject1).next()).bannarMd5) ^ true);
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
        bool3 = bool3 & (d(((PortalManager.ComboNumber)localObject2).flowerImageMD5) ^ true) & (d(((PortalManager.ComboNumber)localObject2).numberImageMD5) ^ true) & (d(((PortalManager.ComboNumber)localObject2).flowerImage2MD5) ^ true);
      }
    }
    localObject1 = paramRedPacketConfig.portalConfigs.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PortalManager.PortalConfig)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        boolean bool2 = (d(((PortalManager.PortalConfig)localObject2).bgMd5) ^ true) & bool4 & (d(((PortalManager.PortalConfig)localObject2).leftCloudImageMD5) ^ true) & (d(((PortalManager.PortalConfig)localObject2).rightCloudImageMD5) ^ true);
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
              bool2 = bool2 & (d(((PortalManager.LogoConfig)localObject4).logoImageMD5) ^ true) & (d(((PortalManager.LogoConfig)localObject4).nameMD5) ^ true) & (d(((PortalManager.LogoConfig)localObject4).greetImageMD5) ^ true) & (d(((PortalManager.LogoConfig)localObject4).padantImageMD5) ^ true) & (d(((PortalManager.LogoConfig)localObject4).relationCompanyLogoMD5) ^ true);
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
              bool1 = bool1 & (d(((PortalManager.AwardConfig)localObject4).awardMd5) ^ true) & (d(((PortalManager.AwardConfig)localObject4).starMd5) ^ true) & (d(((PortalManager.AwardConfig)localObject4).ctfBgMd5) ^ true);
            }
          }
        }
        bool4 = bool2 & (d(((PortalManager.PortalConfig)localObject2).shareStarImageMD5) ^ true) & (d(((PortalManager.PortalConfig)localObject2).starGuiderPhotoMD5) ^ true);
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
    ReportController.b(this.E, "dc01440", "", "", "0X80078FA", "0X80078FA", 0, 0, (String)localObject1, (String)localObject2, paramRedPacketConfig, "");
    if (PrecoverUtils.a(this.C, "hongbao_17_res_cover"))
    {
      PrecoverUtils.b(this.C, "hongbao_17_res_cover");
      localObject3 = new HashMap();
      ((HashMap)localObject3).put("config_version", paramRedPacketConfig);
      ((HashMap)localObject3).put("cover", localObject1);
      ((HashMap)localObject3).put("taskid", localObject2);
      StatisticCollector.getInstance(this.C).collectPerformance(this.E.getCurrentAccountUin(), "hongbao_res_precover", bool4, 0L, 0L, (HashMap)localObject3, "", false);
    }
  }
  
  private boolean d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.j.contains(paramString)) {
        return false;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.E.getApplication().getFilesDir());
      ((StringBuilder)localObject).append(h);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramString);
      if (!new File(localStringBuilder.toString()).exists())
      {
        this.j.add(paramString);
        return true;
      }
    }
    return false;
  }
  
  private static int e(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i2 = -1;
    int i1 = i2;
    if (!bool)
    {
      if ("hb_icon_path".equals(paramString)) {
        return 2130846373;
      }
      if ("hb_name_path".equals(paramString)) {
        return 2130846743;
      }
      if ("hb_banner_path".equals(paramString)) {
        return -1;
      }
      if ("hb_yure_star_logo_path".equals(paramString)) {
        return 2130846911;
      }
      if ("hb_yure_star_name_path".equals(paramString)) {
        return 2130846912;
      }
      if ("hb_busi_logo_path".equals(paramString)) {
        return 2130846733;
      }
      if ("hb_yure_busi_name_path".equals(paramString)) {
        return 2130846734;
      }
      if ("hb_bg_name_path".equals(paramString)) {
        return 2130846745;
      }
      if ("hb_leftclound_name_path".equals(paramString)) {
        return 2130846739;
      }
      if ("hb_rightclound_name_path".equals(paramString)) {
        return 2130846740;
      }
      if ("hb_luckybag_name_path".equals(paramString)) {
        return 2130846861;
      }
      i1 = i2;
      if ("hb_luckybag_ing_name_path".equals(paramString)) {
        i1 = 2130846862;
      }
    }
    return i1;
  }
  
  public static boolean g()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (e) {
      l1 = System.currentTimeMillis();
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(l1);
    int i2 = ((Calendar)localObject1).get(1);
    int i3 = ((Calendar)localObject1).get(2);
    int i4 = ((Calendar)localObject1).get(5);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar localCalendar = Calendar.getInstance();
    boolean bool2 = false;
    localObject1 = null;
    int i1 = 0;
    boolean bool1;
    for (;;)
    {
      Object localObject2 = s;
      bool1 = bool2;
      if (i1 >= localObject2.length) {
        break;
      }
      try
      {
        localObject2 = localSimpleDateFormat.parse(localObject2[i1]);
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
        int i5 = localCalendar.get(1);
        int i6 = localCalendar.get(2);
        int i7 = localCalendar.get(5);
        if ((i2 == i5) && (i3 + 1 == i6 + 1) && (i4 == i7))
        {
          bool1 = true;
          break;
        }
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isForbidAlert, current=");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append(", bingo=");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(", DEBUG_GRAB=");
      ((StringBuilder)localObject1).append(e);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject1).toString());
    }
    return bool1;
  }
  
  private int h()
  {
    PortalManager.PortalConfig localPortalConfig = this.A;
    if ((localPortalConfig != null) && (localPortalConfig.type == 2)) {
      return this.A.continuousRecord;
    }
    return 0;
  }
  
  private String i()
  {
    File localFile = this.C.getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("red_packet_config2017_");
    localStringBuilder.append(this.E.getAccount());
    return new File(localFile, localStringBuilder.toString()).getAbsolutePath();
  }
  
  private PortalManager.RedPacketConfig j()
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
  
  private void k()
  {
    if (this.u == null)
    {
      this.u = new OlympicDPC();
      int i1 = (int)(DeviceInfoUtil.a() / 1024L / 1024L);
      int i2 = ViewUtils.getScreenWidth();
      String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.olympic_act_config.name());
      this.u.a = str;
      boolean bool2 = false;
      boolean bool1;
      try
      {
        if (str.length() > 0)
        {
          String[] arrayOfString = str.split("\\|");
          if (arrayOfString.length >= 9)
          {
            if (i1 <= Integer.valueOf(arrayOfString[0]).intValue()) {
              this.u.c = true;
            } else if (i2 <= Integer.valueOf(arrayOfString[1]).intValue()) {
              this.u.c = true;
            } else if (i2 <= Integer.valueOf(arrayOfString[2]).intValue()) {
              this.u.d = true;
            }
            if (Integer.valueOf(arrayOfString[3]).intValue() == 1) {
              this.u.e = true;
            }
            this.u.f = Integer.valueOf(arrayOfString[4]).intValue();
            this.u.g = Integer.valueOf(arrayOfString[5]).intValue();
            this.u.h = Integer.valueOf(arrayOfString[6]).intValue();
            this.u.i = Integer.valueOf(arrayOfString[7]).intValue();
            this.u.j = Integer.valueOf(arrayOfString[8]).intValue();
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
      Object localObject = this.u;
      ((OlympicDPC)localObject).b = bool1;
      if (bool1)
      {
        if (i1 <= 512) {
          ((OlympicDPC)localObject).c = true;
        } else if (i2 <= 480) {
          ((OlympicDPC)localObject).c = true;
        } else if (i2 <= 720) {
          ((OlympicDPC)localObject).d = true;
        }
        localObject = this.u;
        ((OlympicDPC)localObject).e = false;
        ((OlympicDPC)localObject).f = 0;
        ((OlympicDPC)localObject).g = 3;
        ((OlympicDPC)localObject).h = 1000;
        ((OlympicDPC)localObject).i = 1;
        ((OlympicDPC)localObject).j = 1;
      }
      if (this.u.i == 1) {
        bool2 = true;
      }
      OlympicUtil.a(bool2);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadDPCConfig|featureValue:");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(",systemTotalMem:");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(",screenWidth:");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(",isUseDefault:");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(",dpc:");
        ((StringBuilder)localObject).append(this.u.toString());
        QLog.d("PortalManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public PortalManager.PortalConfig a(long paramLong)
  {
    Object localObject2 = this.g;
    StringBuilder localStringBuilder = null;
    Object localObject1 = localStringBuilder;
    long l2 = paramLong;
    int i1;
    if (localObject2 != null)
    {
      long l1 = paramLong;
      if (paramLong == -1L)
      {
        paramLong = NetConnInfoCenter.getServerTimeMillis();
        l2 = m;
        l1 = paramLong;
        if (l2 > 0L) {
          l1 = l2 + N * (paramLong - n);
        }
      }
      localObject2 = this.g.portalConfigs;
      int i2 = ((ArrayList)localObject2).size();
      i1 = 0;
      for (;;)
      {
        localObject1 = localStringBuilder;
        l2 = l1;
        if (i1 >= i2) {
          break label187;
        }
        localObject1 = (PortalManager.PortalConfig)((ArrayList)localObject2).get(i1);
        if ((((PortalManager.PortalConfig)localObject1).id == l1) || ((((PortalManager.PortalConfig)localObject1).realBegin <= l1) && (((PortalManager.PortalConfig)localObject1).realEnd > l1))) {
          break;
        }
        if ((l1 > 536870911L) && (((PortalManager.PortalConfig)localObject1).realBegin > l1))
        {
          localObject1 = localStringBuilder;
          l2 = l1;
          break label187;
        }
        i1 += 1;
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
        i1 = ((PortalManager.PortalConfig)localObject1).id;
      } else {
        i1 = -1;
      }
      localStringBuilder.append(i1);
      QLog.d("PortalManager", 2, localStringBuilder.toString());
    }
    return localObject1;
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
    PortalManager.RedPacketConfig localRedPacketConfig = this.g;
    Object localObject = localRedPacketConfig;
    if (localRedPacketConfig == null) {
      localObject = c();
    }
    if (paramRedPacketConfig != null)
    {
      a(paramRedPacketConfig, (PortalManager.RedPacketConfig)localObject, false);
      b(paramRedPacketConfig);
    }
    else
    {
      paramRedPacketConfig = (PortalManager.RedPacketConfig)localObject;
    }
    if (paramRedPacketConfig != null) {
      c(paramRedPacketConfig);
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
    ((PortalManager.ResultData)localObject3).a = a(localObject1.awardMd5, null);
    ((PortalManager.ResultData)localObject3).b = localObject1.addMsg;
    ((PortalManager.ResultData)localObject3).m = localObject1.publicId;
    ((PortalManager.ResultData)localObject3).l = localObject1.publicWording;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir());
    localStringBuilder.append(h);
    if (localObject1.awardType == 2) {
      localObject2 = localObject1.starMd5;
    } else {
      localObject2 = localObject1.awardMd5;
    }
    localStringBuilder.append((String)localObject2);
    ((PortalManager.ResultData)localObject3).g = localStringBuilder.toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getFilesDir());
    ((StringBuilder)localObject2).append(h);
    ((StringBuilder)localObject2).append(localObject1.ctfBgMd5);
    ((PortalManager.ResultData)localObject3).h = ((StringBuilder)localObject2).toString();
    ((PortalManager.ResultData)localObject3).k = localObject1.awardMsg;
    ((PortalManager.ResultData)localObject3).i = localObject1.awardTitle;
    ((PortalManager.ResultData)localObject3).j = localObject1.awardType;
    ((PortalManager.ResultData)localObject3).q = localObject1.showPublic;
    return localObject3;
  }
  
  public void a()
  {
    this.w = false;
    e();
    a(true, 100, 0L, null);
    Object localObject;
    if (!this.F.hasMessages(16))
    {
      localObject = this.A;
      long l1;
      if (localObject != null) {
        l1 = Long.valueOf(((PortalManager.PortalConfig)localObject).useTime).longValue();
      } else {
        l1 = 10000L;
      }
      a(true, 16, 1000L, Long.valueOf(l1));
    }
    if ((QLog.isColorLevel()) && (this.A != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setGrabTimeFinish activity id:");
      ((StringBuilder)localObject).append(this.A.id);
      ((StringBuilder)localObject).append(", total count:");
      ((StringBuilder)localObject).append(this.A.countGrab);
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
      PortalManager.PortalConfig localPortalConfig = this.A;
      int i1;
      if (localPortalConfig != null) {
        i1 = localPortalConfig.id;
      } else {
        i1 = 0;
      }
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("PortalManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.A;
    if ((localObject != null) && (((PortalManager.PortalConfig)localObject).id == paramInt1))
    {
      localObject = this.A;
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
      localStringBuilder1.append(this.O[paramInt]);
      localStringBuilder1.append(", ");
      localStringBuilder1.append(P[paramInt]);
      localStringBuilder1.append(", mPlayCountDownStreamId=");
      localStringBuilder1.append(this.R);
      localStringBuilder1.append(", mPlayCountDownState=");
      localStringBuilder1.append(this.o);
      QLog.d("PortalManager", 2, localStringBuilder1.toString());
    }
    try
    {
      if (this.t == null)
      {
        this.t = new SoundPool(10, 3, 0);
        this.t.setOnLoadCompleteListener(this);
      }
      if (paramInt == 2)
      {
        if ((this.o == 4) && (paramBoolean)) {
          return;
        }
        if ((this.o == 1) && (!paramBoolean)) {
          return;
        }
        this.o = 1;
      }
      int i3 = this.O[paramInt];
      if (i3 == 0)
      {
        i1 = this.t.load(this.E.getApp().getApplicationContext(), Q[paramInt], 1);
        this.O[paramInt] = i1;
        return;
      }
      int i2 = -1;
      int i1 = i2;
      if (P[paramInt] != 0) {
        if (paramInt != 2)
        {
          i1 = this.t.play(i3, 1.0F, 1.0F, 1, 0, 1.0F);
        }
        else
        {
          i1 = i2;
          if (this.R == 0)
          {
            this.R = this.t.play(i3, 1.0F, 1.0F, 10, -1, 1.0F);
            i1 = i2;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("playSound, ");
        localStringBuilder1.append(paramInt);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(this.O[paramInt]);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(P[paramInt]);
        localStringBuilder1.append(", ");
        localStringBuilder1.append(i1);
        localStringBuilder1.append(", mPlayCountDownStreamId=");
        localStringBuilder1.append(this.R);
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
    this.F.post(new PortalManager.1(this, paramLong1, paramLong2, paramLong3));
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clickBanner, ");
      localObject = this.y;
      if (localObject != null) {
        localObject = Integer.valueOf(((PortalManager.BannerConfig)localObject).useFlag + this.y.id);
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramBoolean);
      QLog.i("PortalManager", 2, localStringBuilder.toString());
    }
    Object localObject = this.y;
    if (localObject != null)
    {
      if (((PortalManager.BannerConfig)localObject).useFlag < 2)
      {
        this.y.useFlag = 2;
        a(false, 6, 1000L, this.g);
        a(null, 1, false, 0L);
      }
      if (paramBoolean)
      {
        if (!TextUtils.isEmpty(this.y.jumpUrl))
        {
          if (paramActivity != null) {
            localObject = paramActivity;
          } else {
            localObject = BaseApplicationImpl.sApplication;
          }
          localObject = new Intent((Context)localObject, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", this.y.jumpUrl);
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
          paramActivity = this.x;
          if ((paramActivity != null) && (this.A != null)) {
            paramActivity.a();
          }
        }
        ReportController.b(this.E, "dc01440", "", "", "0X80077E7", "0X80077E7", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.E, "dc01440", "", "", "0X80077E6", "0X80077E6", 0, 0, "", "", "", "");
    }
  }
  
  public void a(PortalManager.PortalShower paramPortalShower, int paramInt, boolean paramBoolean, long paramLong)
  {
    Object localObject4 = this;
    paramPortalShower = ((PortalManager)localObject4).x;
    if (paramPortalShower == null) {
      return;
    }
    Object localObject1;
    if (1 == (paramInt & 0x1))
    {
      localObject1 = ((PortalManager)localObject4).y;
      if (localObject1 == null)
      {
        paramPortalShower.d();
      }
      else if ((localObject1 != null) && (((PortalManager.BannerConfig)localObject1).useFlag < 2))
      {
        paramPortalShower = a(((PortalManager)localObject4).y.bannarMd5, "hb_banner_path");
        if ((paramPortalShower != null) && (((PortalManager)localObject4).x.a(paramPortalShower, ((PortalManager)localObject4).y.jumpUrl)))
        {
          ((PortalManager)localObject4).y.useFlag = 2;
          i1 = 1;
          break label111;
        }
      }
    }
    int i1 = 0;
    label111:
    if (2 == (paramInt & 0x2))
    {
      if (((PortalManager)localObject4).A != null)
      {
        long l4 = ((PortalManager)localObject4).g.version << 30 | ((PortalManager)localObject4).A.id;
        if (paramLong == 0L) {
          paramLong = NetConnInfoCenter.getServerTimeMillis();
        }
        long l2 = m;
        long l1 = paramLong;
        if (l2 > 0L) {
          l1 = l2 + N * (paramLong - n);
        }
        Bitmap localBitmap2 = a(((PortalManager)localObject4).A.bgMd5, "hb_bg_name_path");
        Bitmap localBitmap3 = a(((PortalManager)localObject4).A.leftCloudImageMD5, "hb_leftclound_name_path");
        Bitmap localBitmap4 = a(((PortalManager)localObject4).A.rightCloudImageMD5, "hb_rightclound_name_path");
        paramLong = ((PortalManager)localObject4).A.scrollTime;
        l2 = paramLong;
        if (paramLong == 0L) {
          l2 = 3000L;
        }
        ArrayList localArrayList;
        if ((((PortalManager)localObject4).A.logoList.size() > 0) && (((PortalManager)localObject4).A.mode == 3))
        {
          localArrayList = new ArrayList(((PortalManager)localObject4).A.logoList);
          Collections.shuffle(localArrayList);
        }
        else
        {
          localArrayList = null;
        }
        Object localObject3;
        Object localObject2;
        Bitmap localBitmap1;
        if (((PortalManager)localObject4).A.type == 1)
        {
          if (l1 > ((PortalManager)localObject4).A.realEnd) {
            paramLong = Math.min(((PortalManager)localObject4).A.uiEnd - l1, ((PortalManager)localObject4).A.uiEnd - ((PortalManager)localObject4).A.realEnd);
          } else {
            paramLong = -1L;
          }
          localObject3 = this;
          if (((PortalManager)localObject3).A.mode == 1)
          {
            localObject2 = (PortalManager.LogoConfig)((PortalManager)localObject3).A.logoList.get(0);
            paramPortalShower = a(((PortalManager.LogoConfig)localObject2).logoImageMD5, "hb_yure_star_logo_path");
            localBitmap1 = a(((PortalManager.LogoConfig)localObject2).nameMD5, "hb_yure_star_name_path");
            localObject1 = a(((PortalManager.LogoConfig)localObject2).padantImageMD5, "hb_icon_path");
          }
          else if (((PortalManager)localObject3).A.mode == 2)
          {
            localObject2 = (PortalManager.LogoConfig)((PortalManager)localObject3).A.logoList.get(0);
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
            ((StringBuilder)localObject4).append(((PortalManager)localObject3).A.uiEnd);
            ((StringBuilder)localObject4).append(",currentPortal.realEnd = ");
            ((StringBuilder)localObject4).append(((PortalManager)localObject3).A.realEnd);
            QLog.d("PortalManager", 2, ((StringBuilder)localObject4).toString());
          }
          ((PortalManager)localObject3).x.a(l4, ((PortalManager)localObject3).A.mode, localBitmap2, paramPortalShower, (Bitmap)localObject1, localBitmap3, localBitmap4, (Bitmap)localObject2, localBitmap1, localArrayList, ((PortalManager)localObject3).A.rightMsg, paramLong, paramBoolean, l2);
          paramInt = i1;
          if (((PortalManager)localObject3).A.useFlag >= 2) {
            break label1447;
          }
          paramInt = i1;
          if (((PortalManager)localObject3).H) {
            break label1447;
          }
          paramInt = i1;
          if (!((PortalManager)localObject3).x.a()) {
            break label1447;
          }
          ((PortalManager)localObject3).H = true;
          ((PortalManager)localObject3).A.useFlag = 2;
          paramInt = 1;
          break label1447;
        }
        if (((PortalManager)localObject4).A.type == 2)
        {
          if (((PortalManager)localObject4).A.mode == 1)
          {
            localObject3 = (PortalManager.LogoConfig)((PortalManager)localObject4).A.logoList.get(0);
            paramPortalShower = a(((PortalManager.LogoConfig)localObject3).logoImageMD5, "hb_icon_path");
            localBitmap1 = a(((PortalManager.LogoConfig)localObject3).nameMD5, "hb_name_path");
            localObject1 = a(((PortalManager.LogoConfig)localObject3).padantImageMD5, "hb_icon_path");
            localObject2 = a(((PortalManager.LogoConfig)localObject3).relationCompanyLogoMD5, "hb_busi_logo_path");
            localObject3 = a(((PortalManager.LogoConfig)localObject3).relationCompanyNameMD5, "hb_name_path");
          }
          else
          {
            if (((PortalManager)localObject4).A.mode == 2)
            {
              localObject1 = (PortalManager.LogoConfig)((PortalManager)localObject4).A.logoList.get(0);
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
          String str1 = ((PortalManager)localObject4).A.grabMsg;
          String str2 = ((PortalManager)localObject4).A.actEndWording;
          String str3 = ((PortalManager)localObject4).A.nextActTime;
          String str4 = ((PortalManager)localObject4).A.countDownTips;
          if (((PortalManager)localObject4).A.useTime > 0L)
          {
            long l3 = l1 - ((PortalManager)localObject4).A.useTime;
            if (l3 <= ((PortalManager)localObject4).A.countTime)
            {
              paramLong = l3;
              if (l3 > 0L) {}
            }
            else
            {
              paramLong = 0L;
            }
          }
          else if ((((PortalManager)localObject4).A.useTime == 0L) && (l1 >= ((PortalManager)localObject4).A.realEnd - ((PortalManager)localObject4).A.countTime))
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
            localStringBuilder.append(((PortalManager)localObject4).A.useTime);
            localStringBuilder.append(",currentPortal.countTime = ");
            localStringBuilder.append(((PortalManager)localObject4).A.countTime);
            localStringBuilder.append(",currentPortal.realEnd = ");
            localStringBuilder.append(((PortalManager)localObject4).A.realEnd);
            localStringBuilder.append(",countDown = ");
            localStringBuilder.append(paramLong);
            QLog.d("PortalManager", 2, localStringBuilder.toString());
          }
          ((PortalManager)localObject4).x.a(l4, ((PortalManager)localObject4).A.mode, localBitmap2, paramPortalShower, (Bitmap)localObject1, str1, str2, str3, str4, paramLong, paramBoolean, ((PortalManager)localObject4).A.countGrab, localBitmap3, localBitmap4, localArrayList, ((PortalManager)localObject4).g.comboNumberConfigs, localBitmap1, l2, (Bitmap)localObject2, (Bitmap)localObject3);
          if ((((PortalManager)localObject4).g.showGesturesTime <= 0L) && (((PortalManager)localObject4).x.b()))
          {
            ((PortalManager)localObject4).g.showGesturesTime = l1;
            paramInt = 1;
          }
          else
          {
            paramInt = i1;
          }
        }
        else
        {
          if (((PortalManager)localObject4).A.type == 3)
          {
            paramPortalShower = a(((PortalManager)localObject4).A.bgMd5, null);
            if (((PortalManager)localObject4).x.a(paramPortalShower))
            {
              ((PortalManager)localObject4).A.useFlag = 2;
              paramInt = 1;
              break label1422;
            }
          }
          paramInt = i1;
          ((PortalManager)localObject4).x.c();
        }
        break label1447;
      }
      ((PortalManager)localObject4).x.c();
    }
    label1422:
    paramInt = i1;
    label1447:
    if (paramInt != 0) {
      a(false, 6, 1000L, this.g);
    }
  }
  
  void a(boolean paramBoolean, int paramInt, long paramLong, Object paramObject)
  {
    if (!this.G) {
      try
      {
        if (!this.G)
        {
          Handler localHandler;
          if (paramBoolean) {
            localHandler = this.F;
          } else {
            localHandler = this.D;
          }
          localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, 0, 0, paramObject), paramLong);
        }
        return;
      }
      finally {}
    }
  }
  
  public int b()
  {
    PortalManager.PortalConfig localPortalConfig = this.A;
    if (localPortalConfig != null) {
      return localPortalConfig.id;
    }
    return -1;
  }
  
  protected boolean b(PortalManager.RedPacketConfig paramRedPacketConfig)
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
      return FileUtils.pushData2File(i(), localByteArrayOutputStream.toByteArray(), false);
    }
    catch (Throwable paramRedPacketConfig)
    {
      paramRedPacketConfig.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  protected PortalManager.RedPacketConfig c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 231	com/tencent/mobileqq/portal/PortalManager:C	Landroid/content/Context;
    //   4: invokevirtual 1433	android/content/Context:getFilesDir	()Ljava/io/File;
    //   7: astore_2
    //   8: new 99	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: ldc_w 1435
    //   20: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_3
    //   25: aload_0
    //   26: getfield 223	com/tencent/mobileqq/portal/PortalManager:E	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: invokevirtual 1438	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   32: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: new 104	java/io/File
    //   39: dup
    //   40: aload_2
    //   41: aload_3
    //   42: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 1441	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore_2
    //   49: aload_2
    //   50: invokevirtual 526	java/io/File:exists	()Z
    //   53: istore_1
    //   54: aconst_null
    //   55: astore 4
    //   57: iload_1
    //   58: ifeq +317 -> 375
    //   61: new 1792	java/io/FileInputStream
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 1795	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   69: astore_2
    //   70: new 1797	java/io/ObjectInputStream
    //   73: dup
    //   74: new 1799	java/io/BufferedInputStream
    //   77: dup
    //   78: aload_2
    //   79: invokespecial 1802	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   82: invokespecial 1803	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore 7
    //   87: aload_2
    //   88: astore_3
    //   89: aload 7
    //   91: astore 5
    //   93: aload 7
    //   95: invokevirtual 1806	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   98: checkcast 587	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   101: astore 4
    //   103: aload 7
    //   105: invokevirtual 1807	java/io/ObjectInputStream:close	()V
    //   108: goto +21 -> 129
    //   111: astore_3
    //   112: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +14 -> 129
    //   118: ldc_w 287
    //   121: iconst_2
    //   122: ldc_w 289
    //   125: aload_3
    //   126: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: invokevirtual 1808	java/io/FileInputStream:close	()V
    //   133: aload 4
    //   135: astore_2
    //   136: goto +241 -> 377
    //   139: astore_3
    //   140: aload 4
    //   142: astore_2
    //   143: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +231 -> 377
    //   149: ldc_w 287
    //   152: iconst_2
    //   153: ldc_w 289
    //   156: aload_3
    //   157: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   160: aload 4
    //   162: astore_2
    //   163: goto +214 -> 377
    //   166: astore 6
    //   168: aload_2
    //   169: astore 4
    //   171: aload 7
    //   173: astore_2
    //   174: goto +33 -> 207
    //   177: astore_3
    //   178: goto +133 -> 311
    //   181: astore 6
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_2
    //   186: astore 4
    //   188: aload_3
    //   189: astore_2
    //   190: goto +17 -> 207
    //   193: astore_3
    //   194: aconst_null
    //   195: astore_2
    //   196: goto +115 -> 311
    //   199: astore 6
    //   201: aconst_null
    //   202: astore 4
    //   204: aload 4
    //   206: astore_2
    //   207: aload 4
    //   209: astore_3
    //   210: aload_2
    //   211: astore 5
    //   213: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +21 -> 237
    //   219: aload 4
    //   221: astore_3
    //   222: aload_2
    //   223: astore 5
    //   225: ldc_w 287
    //   228: iconst_2
    //   229: ldc_w 289
    //   232: aload 6
    //   234: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   237: aload_2
    //   238: ifnull +28 -> 266
    //   241: aload_2
    //   242: invokevirtual 1807	java/io/ObjectInputStream:close	()V
    //   245: goto +21 -> 266
    //   248: astore_2
    //   249: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifeq +14 -> 266
    //   255: ldc_w 287
    //   258: iconst_2
    //   259: ldc_w 289
    //   262: aload_2
    //   263: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: aload 4
    //   268: ifnull +107 -> 375
    //   271: aload 4
    //   273: invokevirtual 1808	java/io/FileInputStream:close	()V
    //   276: goto +99 -> 375
    //   279: astore_2
    //   280: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +92 -> 375
    //   286: ldc_w 287
    //   289: iconst_2
    //   290: ldc_w 289
    //   293: aload_2
    //   294: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   297: goto +78 -> 375
    //   300: astore 6
    //   302: aload 5
    //   304: astore 4
    //   306: aload_3
    //   307: astore_2
    //   308: aload 6
    //   310: astore_3
    //   311: aload 4
    //   313: ifnull +31 -> 344
    //   316: aload 4
    //   318: invokevirtual 1807	java/io/ObjectInputStream:close	()V
    //   321: goto +23 -> 344
    //   324: astore 4
    //   326: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +15 -> 344
    //   332: ldc_w 287
    //   335: iconst_2
    //   336: ldc_w 289
    //   339: aload 4
    //   341: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   344: aload_2
    //   345: ifnull +28 -> 373
    //   348: aload_2
    //   349: invokevirtual 1808	java/io/FileInputStream:close	()V
    //   352: goto +21 -> 373
    //   355: astore_2
    //   356: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +14 -> 373
    //   362: ldc_w 287
    //   365: iconst_2
    //   366: ldc_w 289
    //   369: aload_2
    //   370: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   373: aload_3
    //   374: athrow
    //   375: aconst_null
    //   376: astore_2
    //   377: aload_2
    //   378: astore_3
    //   379: aload_2
    //   380: ifnonnull +16 -> 396
    //   383: new 587	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   386: dup
    //   387: invokespecial 588	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:<init>	()V
    //   390: pop
    //   391: aload_0
    //   392: invokespecial 1810	com/tencent/mobileqq/portal/PortalManager:j	()Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   395: astore_3
    //   396: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq +56 -> 455
    //   402: new 99	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   409: astore 4
    //   411: aload 4
    //   413: ldc_w 1812
    //   416: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload_3
    //   421: ifnull +11 -> 432
    //   424: aload_3
    //   425: invokevirtual 1063	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:toString	()Ljava/lang/String;
    //   428: astore_2
    //   429: goto +7 -> 436
    //   432: ldc_w 1065
    //   435: astore_2
    //   436: aload 4
    //   438: aload_2
    //   439: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: ldc_w 287
    //   446: iconst_2
    //   447: aload 4
    //   449: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: aload_0
    //   456: getfield 1239	com/tencent/mobileqq/portal/PortalManager:g	Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   459: ifnonnull +11 -> 470
    //   462: aload_0
    //   463: iconst_1
    //   464: iconst_2
    //   465: lconst_0
    //   466: aload_3
    //   467: invokevirtual 1270	com/tencent/mobileqq/portal/PortalManager:a	(ZIJLjava/lang/Object;)V
    //   470: aload_3
    //   471: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	this	PortalManager
    //   53	5	1	bool	boolean
    //   7	235	2	localObject1	Object
    //   248	15	2	localIOException1	java.io.IOException
    //   279	15	2	localIOException2	java.io.IOException
    //   307	42	2	localObject2	Object
    //   355	15	2	localIOException3	java.io.IOException
    //   376	63	2	str	String
    //   15	74	3	localObject3	Object
    //   111	15	3	localIOException4	java.io.IOException
    //   139	18	3	localIOException5	java.io.IOException
    //   177	1	3	localObject4	Object
    //   184	5	3	localObject5	Object
    //   193	1	3	localObject6	Object
    //   209	262	3	localObject7	Object
    //   55	262	4	localObject8	Object
    //   324	16	4	localIOException6	java.io.IOException
    //   409	39	4	localStringBuilder	StringBuilder
    //   91	212	5	localObject9	Object
    //   166	1	6	localThrowable1	Throwable
    //   181	1	6	localThrowable2	Throwable
    //   199	34	6	localThrowable3	Throwable
    //   300	9	6	localObject10	Object
    //   85	87	7	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   103	108	111	java/io/IOException
    //   129	133	139	java/io/IOException
    //   93	103	166	java/lang/Throwable
    //   70	87	177	finally
    //   70	87	181	java/lang/Throwable
    //   61	70	193	finally
    //   61	70	199	java/lang/Throwable
    //   241	245	248	java/io/IOException
    //   271	276	279	java/io/IOException
    //   93	103	300	finally
    //   213	219	300	finally
    //   225	237	300	finally
    //   316	321	324	java/io/IOException
    //   348	352	355	java/io/IOException
  }
  
  public boolean c(String paramString)
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
    int i2 = -1;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    Object localObject1 = this.g;
    Object localObject2 = null;
    int i1 = i2;
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      i1 = i2;
      if (this.g.portalConfigs != null)
      {
        i2 = this.g.portalConfigs.size();
        i1 = i2;
        if (i2 > 0)
        {
          localObject3 = (PortalManager.PortalConfig)this.g.portalConfigs.get(0);
          localObject4 = (PortalManager.PortalConfig)this.g.portalConfigs.get(this.g.portalConfigs.size() - 1);
          i1 = i2;
          bool1 = bool2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (localObject3 == null) {
            break label323;
          }
          i1 = i2;
          bool1 = bool2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (localObject4 == null) {
            break label323;
          }
          i1 = i2;
          bool1 = bool2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (((PortalManager.PortalConfig)localObject3).realBegin > l1) {
            break label323;
          }
          i1 = i2;
          bool1 = bool2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (l1 > ((PortalManager.PortalConfig)localObject4).realEnd) {
            break label323;
          }
          paramString = URLUtil.a(paramString);
          i1 = i2;
          bool1 = bool2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (paramString == null) {
            break label323;
          }
          i1 = i2;
          bool1 = bool2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (!"redpacket2017".equalsIgnoreCase((String)paramString.get("from"))) {
            break label323;
          }
          bool1 = false;
          i1 = i2;
          localObject1 = localObject4;
          localObject2 = localObject3;
          break label323;
        }
      }
    }
    localObject1 = null;
    bool1 = bool2;
    label323:
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("isShowYYBao, ");
      ((StringBuilder)localObject4).append(bool1);
      ((StringBuilder)localObject4).append(",");
      ((StringBuilder)localObject4).append(l1);
      ((StringBuilder)localObject4).append(",");
      ((StringBuilder)localObject4).append(i1);
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
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "clearData");
    }
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("red_packet_config2017_");
    localStringBuilder.append(this.E.getAccount());
    localFile = new File(localFile, localStringBuilder.toString());
    if ((localFile.delete()) && (!localFile.delete())) {
      localFile.delete();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("testplaySound, stopCountDown, mPlayCountDownStreamId=");
      localStringBuilder.append(this.R);
      localStringBuilder.append(", mPlayCountDownState=");
      localStringBuilder.append(this.o);
      QLog.d("PortalManager", 2, localStringBuilder.toString());
    }
    if (this.o == 4) {
      return;
    }
    int i1 = this.R;
    if (i1 != 0) {}
    try
    {
      if (this.t != null) {
        this.t.pause(i1);
      }
      label92:
      this.R = 0;
      this.o = 4;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label92;
    }
  }
  
  public boolean f()
  {
    PortalManager.PortalConfig localPortalConfig = this.A;
    return (localPortalConfig != null) && (localPortalConfig.type == 2);
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
    int i1 = paramMessage.what;
    boolean bool1 = true;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 5)
          {
            if (i1 != 6)
            {
              if (i1 != 7)
              {
                if (i1 != 8)
                {
                  if (i1 == 100) {
                    break label745;
                  }
                  switch (i1)
                  {
                  default: 
                    return false;
                  case 16: 
                    this.D.post(new PortalManager.reportRunnable(this, this.f.clone(), 1, this.L, this.M, h(), ((Long)paramMessage.obj).longValue(), false));
                    this.M = 0;
                    this.L = 0;
                    this.f.clear();
                    if ((!QLog.isColorLevel()) || (this.A == null)) {
                      break;
                    }
                    paramMessage = new StringBuilder();
                    paramMessage.append("MSG_GRAB_TIMEOUT_REPORT | activity id:");
                    paramMessage.append(this.A.id);
                    paramMessage.append(", total count:");
                    paramMessage.append(this.A.countGrab);
                    QLog.d("PortalManager", 2, paramMessage.toString());
                    return false;
                  case 15: 
                    this.D.post(new PortalManager.reportRunnable(this, this.p.clone(), 2, 0, 0, 0, 0L, false));
                    this.p.clear();
                    this.D.removeMessages(15);
                    this.D.sendEmptyMessageDelayed(15, 600000L);
                    return false;
                  case 14: 
                    if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof ArrayList))) {
                      break;
                    }
                    localObject1 = this.E;
                    i1 = paramMessage.arg1;
                    localObject2 = (ArrayList)paramMessage.obj;
                    if (paramMessage.arg2 != 1) {
                      bool1 = false;
                    }
                    RedPacketServlet.a((AppRuntime)localObject1, i1, (ArrayList)localObject2, bool1, paramMessage.getData());
                    return false;
                  case 13: 
                    if (this.x == null) {
                      break;
                    }
                    if (this.A != null)
                    {
                      paramMessage = new StringBuilder();
                      paramMessage.append("MSG_GRAB_FAKE_EVENT, mShower");
                      paramMessage.append(this.x);
                      QLog.d("PortalManager", 2, paramMessage.toString());
                    }
                    localObject1 = this.x;
                    paramMessage = this.A;
                    if (paramMessage != null) {
                      paramMessage = paramMessage.emptyMsg;
                    } else {
                      paramMessage = HardCodeUtil.a(2131906127);
                    }
                    ((PortalManager.PortalShower)localObject1).a(false, paramMessage, null);
                    return false;
                  case 12: 
                    a();
                    if ((!QLog.isColorLevel()) || (this.A == null)) {
                      break;
                    }
                    paramMessage = new StringBuilder();
                    paramMessage.append("MSG_GRAB_TIMEOUT | activity id:");
                    paramMessage.append(this.A.id);
                    paramMessage.append(", total count:");
                    paramMessage.append(this.A.countGrab);
                    QLog.d("PortalManager", 2, paramMessage.toString());
                    return false;
                  }
                }
                localObject1 = (PortalManager.PortalShower)paramMessage.obj;
                this.x = ((PortalManager.PortalShower)localObject1);
                a((PortalManager.PortalShower)localObject1, paramMessage.arg1, false, 0L);
                return false;
              }
              c(this.g);
              return false;
            }
            if (this.D.hasMessages(6)) {
              break label829;
            }
            b((PortalManager.RedPacketConfig)paramMessage.obj);
            return false;
          }
          l1 = 0L;
          bool1 = false;
          break label758;
        }
      }
      else if (this.g != null) {
        return true;
      }
      localObject1 = this.g;
      Object localObject2 = (PortalManager.RedPacketConfig)paramMessage.obj;
      this.g = ((PortalManager.RedPacketConfig)localObject2);
      boolean bool2;
      if (localObject2 != null)
      {
        bool2 = a((PortalManager.RedPacketConfig)localObject2, (PortalManager.RedPacketConfig)localObject1, true);
        bool1 = bool2;
        if (this.g != null)
        {
          a(this.g.grebInterval, this.g.reportActiveInterval, this.g.reportNormalInterval);
          bool1 = bool2;
        }
      }
      else
      {
        label745:
        bool1 = false;
      }
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      b(l1);
      label758:
      if (paramMessage.what == 5) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      a(null, 3, bool2, l1);
      if (bool1)
      {
        a(false, 6, 1000L, this.g);
        return false;
      }
    }
    else
    {
      if ((this.g == null) && (NetConnInfoCenter.servetTimeSecondInterv != 0L)) {
        c();
      }
      k();
    }
    label829:
    return false;
  }
  
  public void onDestroy()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "onDestroy");
      }
      this.G = true;
      PortalManager.PortalConfig localPortalConfig = this.A;
      if ((this.f.size() > 0) && (localPortalConfig.useTime > 0L))
      {
        this.D.post(new PortalManager.reportRunnable(this, this.f.clone(), 1, this.L, this.M, h(), localPortalConfig.useTime, true));
        this.f.clear();
      }
      if (this.p.size() > 0)
      {
        this.D.post(new PortalManager.reportRunnable(this, this.p.clone(), 2, 0, 0, 0, 0L, true));
        this.p.clear();
      }
      this.D.removeMessages(1);
      this.D.removeMessages(15);
      this.F.removeCallbacksAndMessages(null);
      this.E.unRegistObserver(this);
      this.E.removeObserver(this.S);
      e();
      try
      {
        this.E.getApp().unregisterReceiver(this.r);
      }
      catch (Exception localException)
      {
        QLog.e("PortalManager", 1, "onDestroy", localException);
      }
      if (this.t != null)
      {
        this.t.release();
        this.t = null;
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
      paramSoundPool.append(this.R);
      paramSoundPool.append(", mPlayCountDownState=");
      paramSoundPool.append(this.o);
      QLog.d("PortalManager", 2, paramSoundPool.toString());
    }
    int i1 = 0;
    while ((i1 < 5) && (this.O[i1] != paramInt1)) {
      i1 += 1;
    }
    if (i1 == 5) {
      return;
    }
    if (paramInt2 == 0)
    {
      P[i1] = true;
      a(i1, true);
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
    int i1;
    int i2;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 8) {
          return;
        }
        paramInt = paramBundle.getInt("k_code", -1);
        i1 = paramBundle.getInt("k_r_type");
        i2 = paramBundle.getInt("key_seq");
        if ((paramBoolean) && (paramInt == 0))
        {
          a(i1, paramBundle.getString("k_result"), i2);
          return;
        }
        a(i1, i2, null, paramInt, null);
        return;
      }
      paramInt = paramBundle.getInt("k_code", 2);
      if (paramInt == 3)
      {
        handleMessage(this.F.obtainMessage(3, new PortalManager.RedPacketConfig()));
        return;
      }
      if (paramInt == 4)
      {
        paramBundle = (PortalManager.RedPacketConfig)paramBundle.getSerializable("k_cache");
        handleMessage(this.F.obtainMessage(3, paramBundle));
      }
    }
    else
    {
      Object localObject3 = paramBundle.getString("key_url");
      i1 = paramBundle.getInt("k_id", -1);
      paramInt = paramBundle.getInt("k_code", -1);
      i2 = paramBundle.getInt("k_money", -1);
      int i5 = paramBundle.getInt("k_type", -1);
      boolean bool2 = paramBundle.getBoolean("k_s_follow", true);
      int i3 = paramBundle.getInt("key_award_id", -1);
      int i4 = paramBundle.getInt("key_promotion_id", -1);
      long l1 = paramBundle.getLong("key_send_url", -1L);
      paramBundle = paramBundle.getString("key_wish", "");
      if (paramBoolean) {
        this.v = (-this.v);
      }
      if (paramInt > 0) {
        this.L += 1;
      }
      if ((paramBoolean) && (paramInt == 0))
      {
        this.M += 1;
        if (i5 != 0)
        {
          if (i5 != 1)
          {
            this.M -= 1;
            this.L += 1;
          }
          else
          {
            paramInt = 0;
            break label448;
          }
        }
        else
        {
          paramInt = 1;
          break label448;
        }
      }
      paramInt = -1;
      paramBoolean = false;
      label448:
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onReceive cmd = CMD_RESULT, portId = ");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(", url = ");
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(", showType = ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(", money = ");
        ((StringBuilder)localObject1).append(i2);
        ((StringBuilder)localObject1).append(", awardId = ");
        ((StringBuilder)localObject1).append(i3);
        ((StringBuilder)localObject1).append(", promotionId = ");
        ((StringBuilder)localObject1).append(i4);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(", sendUrl = ");
        ((StringBuilder)localObject2).append(Long.valueOf(l1));
        ((StringBuilder)localObject2).append(", wishing ");
        ((StringBuilder)localObject2).append(paramBundle);
        QLog.d("PortalManager", 2, new Object[] { localObject1, ((StringBuilder)localObject2).toString() });
      }
      PortalManager.PortalConfig localPortalConfig = a(i1);
      if (localPortalConfig == null) {
        paramBoolean = false;
      }
      Object localObject2 = null;
      boolean bool1;
      if ((paramBoolean) && (localPortalConfig != null))
      {
        localObject1 = localPortalConfig.findRealAwardConfigById(i3);
        paramBundle = (Bundle)localObject1;
        bool1 = paramBoolean;
        if (localObject1 == null)
        {
          localObject1 = localPortalConfig.findRealAwardConfigById(i4);
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
          localObject2 = new PortalManager.ResultData(null, paramBundle.awardTitle, paramBundle.awardMsg, i1, paramInt, (String)localObject3, i2, bool2, i3, i4);
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
              ((PortalManager.ResultData)localObject2).r = a(str, (String)localObject1);
              ((PortalManager.ResultData)localObject2).s = a(localLogoConfig.nameMD5, "hb_name_path");
            }
          }
        }
      }
      if (this.x != null)
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
        localObject3 = this.x;
        if (localPortalConfig != null) {
          localObject2 = localPortalConfig.emptyMsg;
        } else {
          localObject2 = HardCodeUtil.a(2131906125);
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
        if (!this.D.hasMessages(6)) {
          a(false, 6, 2000L, this.g);
        }
      }
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    int i2 = paramNetResp.mResult;
    int i1 = 1;
    boolean bool;
    if (i2 == 0) {
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
      i2 = Integer.valueOf(localObject1[0]).intValue();
      localObject1 = localObject1[1];
      if (this.j.contains(localObject1)) {
        this.j.remove(localObject1);
      }
      if (bool) {
        if (((String)localObject1).equals(PortalUtils.a(((File)localObject2).getAbsolutePath())))
        {
          localObject2 = this.y;
          PortalManager.PortalConfig localPortalConfig = this.A;
          if ((localObject2 != null) && (((PortalManager.BannerConfig)localObject2).id == i2))
          {
            a((String)localObject1, "hb_banner_path");
            a(true, 5, 0L, null);
          }
          else if ((localPortalConfig != null) && (localPortalConfig.id == i2))
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
      i1 = 0;
    }
    if (i1 != 0)
    {
      paramNetResp = this.E.getCurrentAccountUin();
      StatisticCollector.getInstance(this.E.getApp().getApplicationContext()).collectPerformance(paramNetResp, "RedPacketPicDownload", bool, 0L, 0L, localHashMap, "", false);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager
 * JD-Core Version:    0.7.0.1
 */