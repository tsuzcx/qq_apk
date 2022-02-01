package com.tencent.mobileqq.msf.core.push;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat.Builder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.c.d;
import com.tencent.mobileqq.msf.core.c.e.a;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.aa;
import com.tencent.mobileqq.msf.sdk.z;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.pb.offlinepush.C2CMsgReadedNotify;
import com.tencent.msf.service.protocol.pb.offlinepush.C2CTmpOffMsgHead;
import com.tencent.msf.service.protocol.pb.offlinepush.DisMsgReadedNotify;
import com.tencent.msf.service.protocol.pb.offlinepush.DiscussOffInfo;
import com.tencent.msf.service.protocol.pb.offlinepush.GroupOffInfo;
import com.tencent.msf.service.protocol.pb.offlinepush.PbPushOffMsg;
import com.tencent.msf.service.protocol.pb.offlinepush.PbPushOffReadedNotify;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class g
  extends BroadcastReceiver
{
  static int H = 10101;
  static int I = 10102;
  public static int J = 10103;
  public static int K = 10104;
  public static final String P = "com.tencent.mobileqq.msf.receiveofflinepush";
  public static final String Q = "com.tencent.mobileqq.msf.offlinepushclearall";
  public static final String R = "com.tencent.mobileqq.msf.devlockquickloginpush";
  public static final String S = "com.tencent.mobileqq.msf.devlockquickloginpushclear";
  public static final String T = "com.tencent.mobileqq.action.QQWiFi";
  public static final String U = "com.tencent.mobileqq.msf.qqwifi.settings";
  public static final String V = "com.tencent.mobileqq.msf.qqwifi.redtouch";
  public static final String W = "com.tencent.mobileqq.msf.qqwifi.autoconnect";
  public static final String Y = "com.tencent.mobileqq.msf.receiveofflinepushav";
  public static final String Z = "com.tencent.mobileqq.msf.offlinepushclearallav";
  public static final String a = "app_push_info_";
  private static final long[] aD = { 100L, 200L, 200L, 100L };
  private static final String aE = "com.tencent.mobileqq.broadcast.pcactiveQQ";
  static final int ab = 20140416;
  public static final int ak = 0;
  public static final int al = 1;
  public static final int am = 2;
  public static final int an = 3;
  public static final int ao = -56;
  public static final int ap = -55;
  private static final int[] au = { 1, 1, 1, 5, 5, 10, 10, 30, 30, 60, 60, 900, 900 };
  private static int av = 0;
  public static final String b = "com.tencent.mobileqq";
  static final String f = "MSF.C.PushManager";
  static final String g = "PCActivePush";
  static SimpleDateFormat h = new SimpleDateFormat("dd HH:mm:ss");
  public static final String k = "alarmAddedTime";
  public static long l = 0L;
  public static boolean t = false;
  public static String u = "0";
  public static volatile boolean v = false;
  static final String w = "OnlinePush.ReqPush";
  static final String x = "CliNotifySvc.SvcReqPush";
  static final String y = "StatSvc.QueryHB";
  int A = 30000;
  long B = 0L;
  final long C = 300000L;
  long D = 0L;
  public long E = 0L;
  public long F = 0L;
  public long G = 0L;
  ArrayList L = new ArrayList();
  ArrayList M = new ArrayList();
  boolean N = false;
  boolean O = false;
  public QQNotificationManager X;
  private boolean aA = false;
  private long aB = 0L;
  private long aC = 0L;
  private AtomicBoolean aF = new AtomicBoolean(false);
  private String aG = "0";
  private int aH = -1;
  private PendingIntent aI = null;
  private BroadcastReceiver aJ = new l(this);
  private int aK;
  private boolean aL;
  private Object aM;
  public MediaPlayer aa;
  Handler ac = new m(this);
  String ad = Environment.getExternalStorageDirectory().getAbsolutePath();
  String ae;
  String af;
  String ag;
  String ah;
  String ai;
  String aj;
  String aq;
  String ar;
  String as;
  public ToServiceMsg at;
  private final int aw = 1;
  private PendingIntent ax;
  private c ay;
  private Handler az = new h(this);
  MsfCore c;
  String d = "";
  String e = "";
  public ConcurrentHashMap i = new ConcurrentHashMap();
  public e j;
  AlarmManager m;
  g.b n = new g.b(this);
  int o = -1;
  public long p = 0L;
  boolean q = false;
  public boolean r = true;
  boolean s = false;
  volatile Object z = new Object();
  
  public g(MsfCore paramMsfCore)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.ad);
    localStringBuilder.append("/Tencent/MobileQQ/");
    this.ae = localStringBuilder.toString();
    this.af = "head/";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.ae);
    localStringBuilder.append(this.af);
    localStringBuilder.append("_hd/");
    this.ag = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.ae);
    localStringBuilder.append(this.af);
    localStringBuilder.append("_thd/");
    this.ah = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.af);
    localStringBuilder.append("_hd/");
    this.ai = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.ae);
    localStringBuilder.append(".billd_urldrawable/");
    this.aj = localStringBuilder.toString();
    this.aq = "message.ring.switch";
    this.ar = "message.vibrate.switch";
    this.as = "message.ring.care";
    this.aL = false;
    this.aM = new Object();
    this.c = paramMsfCore;
    this.j = new e(this);
    this.n.setName("MsfCorePushManager");
    this.ay = new c(paramMsfCore);
    this.q = CommonBadgeUtilImpl.isMIUI6();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 9) && (paramInt1 != 10) && (paramInt1 != 16) && (paramInt1 != 17) && (paramInt1 != 31) && (paramInt1 != 79) && (paramInt1 != 97) && (paramInt1 != 120) && (paramInt1 != 208))
    {
      StringBuilder localStringBuilder;
      if ((paramInt1 != 215) && (paramInt1 != 519))
      {
        if ((paramInt1 != 529) && (paramInt1 != 562) && (paramInt1 != 734))
        {
          if (paramInt1 != 42) {
            if ((paramInt1 != 43) && (paramInt1 != 82))
            {
              if (paramInt1 != 83)
              {
                if ((paramInt1 == 132) || (paramInt1 == 133)) {
                  break label284;
                }
                if ((paramInt1 != 140) && (paramInt1 != 141))
                {
                  if ((paramInt1 == 166) || (paramInt1 == 167)) {
                    break label284;
                  }
                  if (QLog.isColorLevel())
                  {
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append("onRecvPbPushOffMsg unknow msgtype:");
                    localStringBuilder.append(paramInt1);
                    QLog.d("MSF.C.PushManager", 2, localStringBuilder.toString());
                  }
                  return -1;
                }
                return 2;
              }
            }
            else {
              return 3;
            }
          }
          return 1;
        }
      }
      else if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {}
        switch (paramInt2)
        {
        default: 
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onRecvPbPushOffMsg unknow dwVideoType:");
            localStringBuilder.append(paramInt2);
            QLog.d("MSF.C.PushManager", 2, localStringBuilder.toString());
          }
          return -1;
        case 13: 
          return 1;
        case 12: 
          return 2;
        }
      }
    }
    label284:
    return 0;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      if (paramBitmap == null) {
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      Object localObject = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect((RectF)localObject, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localObject = new Matrix();
      ((Matrix)localObject).setRectToRect(new RectF(localRect1), new RectF(localRect2), Matrix.ScaleToFit.FILL);
      localCanvas.drawBitmap(Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true), localRect2, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f1 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    int i2 = (paramInt1 + paramInt2) / 2;
    double d2 = f1;
    Double.isNaN(d2);
    int i1 = (int)(4.0D * d2);
    double d1;
    if (i2 <= 70)
    {
      d1 = 2.0D;
      Double.isNaN(d2);
    }
    for (;;)
    {
      i1 = (int)(d2 * d1);
      break label115;
      if (i2 <= 100) {
        break label115;
      }
      if (i2 > 128) {
        break;
      }
      d1 = 8.0D;
      Double.isNaN(d2);
    }
    i1 = (int)((paramInt1 / 100 * 4 + 8) * f1);
    label115:
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(paramInt2 * f1);
    return a(paramBitmap, i1, paramInt1, paramInt2);
  }
  
  private MediaPlayer a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = paramContext.getResources().openRawResourceFd(paramInt);
      if (paramContext == null) {
        return null;
      }
      ReportMediaPlayer localReportMediaPlayer = new ReportMediaPlayer();
      a(localReportMediaPlayer);
      localReportMediaPlayer.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
      paramContext.close();
      localReportMediaPlayer.prepare();
      return localReportMediaPlayer;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "createAndSetAudioStreamType  create failed:", paramContext);
      }
    }
    return null;
  }
  
  private MediaPlayer a(Context paramContext, Uri paramUri)
  {
    try
    {
      ReportMediaPlayer localReportMediaPlayer = new ReportMediaPlayer();
      a(localReportMediaPlayer);
      localReportMediaPlayer.setDataSource(paramContext, paramUri);
      localReportMediaPlayer.prepare();
      return localReportMediaPlayer;
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "createAndSetAudioStreamType create failed:", paramContext);
      }
    }
    return null;
  }
  
  static Object a(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    paramString = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
    paramString.setAccessible(true);
    return paramString.invoke(paramObject, paramArrayOfObject);
  }
  
  static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    return a(paramObject, paramString, a(paramArrayOfObject), paramArrayOfObject);
  }
  
  static Object a(String paramString1, String paramString2, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    paramString1 = Class.forName(paramString1);
    return paramString1.getDeclaredMethod(paramString2, paramArrayOfClass).invoke(paramString1, paramArrayOfObject);
  }
  
  private String a(PushRegisterInfo paramPushRegisterInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramPushRegisterInfo != null)
    {
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramPushRegisterInfo.uin);
      localStringBuilder.append(", pushIds=");
      localStringBuilder.append(paramPushRegisterInfo.pushIds);
      localStringBuilder.append(", iStatus=");
      localStringBuilder.append(paramPushRegisterInfo.iStatus);
      localStringBuilder.append(", extStatus=");
      localStringBuilder.append(paramPushRegisterInfo.extStatus);
      localStringBuilder.append(", bKikPC=");
      localStringBuilder.append(paramPushRegisterInfo.bKikPC);
      localStringBuilder.append(", bKikWeak=");
      localStringBuilder.append(paramPushRegisterInfo.bKikWeak);
      localStringBuilder.append(", timeStamp=");
      localStringBuilder.append(paramPushRegisterInfo.timeStamp);
      localStringBuilder.append(", iLargeSeq=");
      localStringBuilder.append(paramPushRegisterInfo.iLargeSeq);
    }
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", Long.toString(paramLong), "OnlinePush.RespPush");
    Object localObject = BaseApplication.getContext().getPackageName();
    localToServiceMsg.setAppId(((a)this.i.get(localObject)).a);
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.setRequestSsoSeq(paramInt1);
    localToServiceMsg.setNeedCallback(false);
    localObject = new com.tencent.msf.service.protocol.c.b();
    ((com.tencent.msf.service.protocol.c.b)localObject).a = paramLong;
    ((com.tencent.msf.service.protocol.c.b)localObject).c = paramInt2;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("OnlinePush.RespPush");
    localUniPacket.setFuncName("SvcRespPushMsg");
    localUniPacket.setRequestId(paramInt1);
    localUniPacket.put("resp", localObject);
    localToServiceMsg.putWupBuffer(localUniPacket.encode());
    this.c.sender.b(localToServiceMsg);
  }
  
  private void a(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.setAudioStreamType(r());
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject1;
    if (com.tencent.mobileqq.msf.service.e.a())
    {
      QLog.d("PCActivePush", 1, "stop tryActiveQQ by mainProcessReady");
      try
      {
        BaseApplication.getContext().unregisterReceiver(this.aJ);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("account", paramString);
      ((HashMap)localObject1).put("retryIndex", String.valueOf(paramInt));
      ((HashMap)localObject1).put("reason", "mainProcessReady");
      if (this.c.getStatReporter() != null) {
        this.c.getStatReporter().a("dim.Msf.PCActiveQQResult", true, 0L, 0L, (Map)localObject1, false, false);
      }
      this.aF.set(false);
      return;
    }
    if (paramInt >= com.tencent.mobileqq.msf.core.a.a.V())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("stop tryActiveQQ index: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("PCActivePush", 1, ((StringBuilder)localObject1).toString());
      try
      {
        BaseApplication.getContext().unregisterReceiver(this.aJ);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("account", paramString);
      ((HashMap)localObject2).put("retryIndex", String.valueOf(paramInt));
      ((HashMap)localObject2).put("reason", "tryTooMuch");
      if (this.c.getStatReporter() != null) {
        this.c.getStatReporter().a("dim.Msf.PCActiveQQResult", false, 0L, 0L, (Map)localObject2, false, false);
      }
      this.aF.set(false);
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("tryActiveQQ index: ");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.d("PCActivePush", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new Intent("com.tencent.mobileqq.broadcast.qq");
    ((Intent)localObject2).putExtra("k_start_mode", 1);
    ((Intent)localObject2).putExtra("k_pcactive_uin", paramString);
    ((Intent)localObject2).putExtra("k_pcactive_retryIndex", paramInt);
    ((Intent)localObject2).setPackage(BaseApplication.getContext().getPackageName());
    BaseApplication.getContext().sendBroadcast((Intent)localObject2);
    this.aG = paramString;
    this.aH = paramInt;
    localObject2 = new Intent("com.tencent.mobileqq.broadcast.pcactiveQQ");
    ((Intent)localObject2).putExtra("uin", paramString);
    ((Intent)localObject2).putExtra("retryIndex", paramInt + 1);
    this.aI = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject2, 134217728);
    this.m.set(0, System.currentTimeMillis() + 300000, this.aI);
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    if (SettingCloneUtil.readValue(paramContext, localStringBuilder.toString(), "通知时指示灯闪烁", "qqsetting_notify_blncontrol_key", true))
    {
      boolean bool = SettingCloneUtil.readValue(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false);
      if (bool)
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("onRecvPbPushOffMsg isNoDisturbMode:");
          paramContext.append(bool);
          QLog.d("MSF.C.PushManager", 2, paramContext.toString());
        }
        int i1 = Calendar.getInstance().get(11);
        if ((i1 >= 23) || (i1 < 8)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean a(SharedPreferences paramSharedPreferences)
  {
    try
    {
      if ((this.L != null) && (this.L.size() > 0))
      {
        localObject = ((g.a)this.L.get(this.L.size() - 1)).a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("special_sound_type");
        localStringBuilder.append(((offlinepush.PbPushOffMsg)localObject).to_uin.get());
        localStringBuilder.append(((offlinepush.PbPushOffMsg)localObject).from_uin.get());
        boolean bool = paramSharedPreferences.contains(localStringBuilder.toString());
        return bool;
      }
    }
    catch (Exception paramSharedPreferences)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("-->isSpecialCareSound...exception=");
        ((StringBuilder)localObject).append(paramSharedPreferences.getMessage());
        QLog.i("PushManager", 2, ((StringBuilder)localObject).toString());
      }
      paramSharedPreferences.printStackTrace();
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (!paramString1.equals(paramString2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(":video");
      if (!paramString1.equals(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append(":QQ");
        if (!paramString1.equals(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString2);
          localStringBuilder.append(":nearby_video");
          if (!paramString1.equals(localStringBuilder.toString())) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  static Class[] a(Object[] paramArrayOfObject)
  {
    Object localObject = (Class[])null;
    if (paramArrayOfObject != null)
    {
      Class[] arrayOfClass = new Class[paramArrayOfObject.length];
      int i1 = 0;
      int i2 = paramArrayOfObject.length;
      for (;;)
      {
        localObject = arrayOfClass;
        if (i1 >= i2) {
          break;
        }
        if (paramArrayOfObject[i1] != null) {
          arrayOfClass[i1] = paramArrayOfObject[i1].getClass();
        } else {
          arrayOfClass[i1] = String.class;
        }
        if (arrayOfClass[i1] == Integer.class) {
          arrayOfClass[i1] = Integer.TYPE;
        } else if (arrayOfClass[i1] == Boolean.class) {
          arrayOfClass[i1] = Boolean.TYPE;
        }
        i1 += 1;
      }
    }
    return localObject;
  }
  
  public static boolean b(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Integer localInteger1 = Integer.valueOf(0);
    boolean bool = true;
    Integer localInteger2 = Integer.valueOf(1);
    if (localTelephonyManager != null)
    {
      if (localTelephonyManager.getCallState() != 0) {
        break label314;
      }
      try
      {
        if (((Integer)a(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { localInteger1 })).intValue() != 0) {
          break label314;
        }
        int i1 = ((Integer)a(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { localInteger2 })).intValue();
        if (i1 != 0) {
          break label314;
        }
        try
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone2");
        }
        catch (Exception paramContext)
        {
          break label153;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "1 isCalling Exception", localException);
        }
      }
    }
    label153:
    paramContext = null;
    if (paramContext != null)
    {
      if (paramContext.getCallState() != 0) {
        break label314;
      }
      try
      {
        if (((Integer)a(paramContext, "getCallStateGemini", new Object[] { localInteger1 })).intValue() != 0) {
          break label314;
        }
        i1 = ((Integer)a(paramContext, "getCallStateGemini", new Object[] { localInteger2 })).intValue();
        if (i1 != 0) {
          break label314;
        }
        try
        {
          paramContext = a("android.telephony.MSimTelephonyManager", "getDefault", null, null);
          if (((Integer)a(paramContext, "getCallState", new Object[] { localInteger1 })).intValue() != 0) {
            break label314;
          }
          i1 = ((Integer)a(paramContext, "getCallState", new Object[] { localInteger2 })).intValue();
          if (i1 == 0) {}
        }
        catch (Exception paramContext)
        {
          break label312;
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "2 isCalling Exception", paramContext);
        }
      }
    }
    label312:
    bool = false;
    label314:
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isCalling: ");
      paramContext.append(bool);
      QLog.d("MSF.C.PushManager", 2, paramContext.toString());
    }
    return bool;
  }
  
  private Object[] b(int paramInt, String paramString)
  {
    if ((paramInt != 3) && (paramInt == 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troop_");
      localStringBuilder.append(paramString);
      localStringBuilder.toString();
    }
    return new Object[] { Integer.valueOf(paramInt), paramString };
  }
  
  private Object[] b(offlinepush.PbPushOffMsg paramPbPushOffMsg)
  {
    boolean bool = paramPbPushOffMsg.msg_str.has();
    Object localObject4 = null;
    if (bool)
    {
      String str2 = paramPbPushOffMsg.msg_str.get().toStringUtf8();
      int i1 = a(paramPbPushOffMsg.msg_type.get(), paramPbPushOffMsg.dwViedoType.get());
      this.o = i1;
      String str1 = "";
      Object localObject2;
      Object localObject3;
      if (i1 != 0)
      {
        long l1;
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3) {
              return null;
            }
            if (paramPbPushOffMsg.group_info.has())
            {
              if (paramPbPushOffMsg.group_info.group_card.has()) {
                localObject2 = paramPbPushOffMsg.group_info.group_card.get().toStringUtf8();
              } else {
                localObject2 = Long.toString(paramPbPushOffMsg.from_uin.get());
              }
              if (paramPbPushOffMsg.group_info.group_name.has()) {
                localObject1 = paramPbPushOffMsg.group_info.group_name.get().toStringUtf8();
              } else {
                localObject1 = null;
              }
              if (paramPbPushOffMsg.group_info.group_code.has())
              {
                l1 = paramPbPushOffMsg.group_info.group_code.get();
                if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                  paramPbPushOffMsg = (offlinepush.PbPushOffMsg)localObject1;
                } else {
                  paramPbPushOffMsg = Long.toString(l1);
                }
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("");
                ((StringBuilder)localObject1).append(l1);
                localObject3 = a(1, ((StringBuilder)localObject1).toString());
                localObject1 = localObject2;
                localObject2 = localObject3;
                break label1008;
              }
              paramPbPushOffMsg = (offlinepush.PbPushOffMsg)localObject1;
              localObject1 = localObject2;
              localObject2 = str1;
              break label1008;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get troop msg, but no msg.group_info exit");
            }
            return null;
          }
          if (paramPbPushOffMsg.c2c_tmp_msg_head.has())
          {
            if ((paramPbPushOffMsg.from_nick.has()) && (paramPbPushOffMsg.from_nick.get().toStringUtf8().length() != 0))
            {
              localObject1 = paramPbPushOffMsg.from_nick.get().toStringUtf8();
            }
            else if (paramPbPushOffMsg.c2c_tmp_msg_head.discuss_remark.has())
            {
              localObject1 = paramPbPushOffMsg.c2c_tmp_msg_head.discuss_remark.get().toStringUtf8();
            }
            else if (paramPbPushOffMsg.c2c_tmp_msg_head.group_card.has())
            {
              localObject1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_card.get().toStringUtf8();
            }
            else if (paramPbPushOffMsg.c2c_tmp_msg_head.group_name.has())
            {
              localObject1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_name.get().toStringUtf8();
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get c2c temp msg, no nick find use from_uin");
              }
              localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
            }
            if (paramPbPushOffMsg.c2c_tmp_msg_head.group_uin.has())
            {
              l1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_uin.get();
              paramPbPushOffMsg = new StringBuilder();
              paramPbPushOffMsg.append("");
              paramPbPushOffMsg.append(l1);
              localObject2 = a(3, paramPbPushOffMsg.toString());
              localObject3 = localObject1;
            }
            else
            {
              localObject3 = localObject1;
              localObject2 = str1;
              if (paramPbPushOffMsg.c2c_tmp_msg_head.group_code.has())
              {
                l1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_code.get();
                paramPbPushOffMsg = new StringBuilder();
                paramPbPushOffMsg.append("");
                paramPbPushOffMsg.append(l1);
                localObject2 = a(3, paramPbPushOffMsg.toString());
                localObject3 = localObject1;
              }
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get c2c temp msg, but no msg.c2c_tmp_msg_head exit");
            }
            return null;
          }
        }
        else
        {
          if (paramPbPushOffMsg.discuss_info.has())
          {
            if (paramPbPushOffMsg.discuss_info.discuss_remark.has()) {
              localObject1 = paramPbPushOffMsg.discuss_info.discuss_remark.get().toStringUtf8();
            } else if (paramPbPushOffMsg.from_nick.has()) {
              localObject1 = paramPbPushOffMsg.from_nick.get().toStringUtf8();
            } else {
              localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
            }
            if (paramPbPushOffMsg.discuss_info.dis_name.has()) {
              localObject2 = paramPbPushOffMsg.discuss_info.dis_name.get().toStringUtf8();
            } else {
              localObject2 = Long.toString(paramPbPushOffMsg.discuss_info.discuss_uin.get());
            }
            if (paramPbPushOffMsg.discuss_info.discuss_uin.has())
            {
              l1 = paramPbPushOffMsg.discuss_info.discuss_uin.get();
              if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
                paramPbPushOffMsg = (offlinepush.PbPushOffMsg)localObject2;
              } else {
                paramPbPushOffMsg = Long.toString(l1);
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("");
              ((StringBuilder)localObject2).append(l1);
              localObject2 = a(3, ((StringBuilder)localObject2).toString());
              localObject3 = null;
              localObject4 = paramPbPushOffMsg;
              paramPbPushOffMsg = (offlinepush.PbPushOffMsg)localObject3;
              break label1008;
            }
            paramPbPushOffMsg = null;
            localObject4 = localObject2;
            localObject2 = str1;
            break label1008;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get discuss msg, but no msg.discuss_info exit");
          }
          return null;
        }
      }
      else
      {
        if ((paramPbPushOffMsg.from_nick.has()) && (paramPbPushOffMsg.from_nick.get().toStringUtf8().length() != 0)) {
          localObject1 = paramPbPushOffMsg.from_nick.get().toStringUtf8();
        } else {
          localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
        }
        localObject3 = localObject1;
        localObject2 = str1;
        if (paramPbPushOffMsg.from_uin.has())
        {
          paramPbPushOffMsg.from_uin.get();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(paramPbPushOffMsg.from_uin.get());
          localObject2 = a(0, ((StringBuilder)localObject2).toString());
          localObject3 = localObject1;
        }
      }
      paramPbPushOffMsg = null;
      Object localObject1 = localObject3;
      label1008:
      return new Object[] { Integer.valueOf(i1), str2, localObject1, localObject2, localObject4, paramPbPushOffMsg };
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg no msg str exit");
    }
    return null;
  }
  
  private Object[] b(boolean paramBoolean)
  {
    long l1;
    label168:
    Object localObject4;
    StringBuilder localStringBuilder;
    if ((this.L.size() == 1) && (!paramBoolean))
    {
      arrayOfObject = new Object[4];
      localObject2 = b(((g.a)this.L.get(0)).a);
      if (localObject2 == null) {
        return null;
      }
      i1 = ((Integer)localObject2[0]).intValue();
      if (i1 != 0) {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3) {
              return null;
            }
            if (((g.a)this.L.get(0)).a.msg_flag.has())
            {
              l1 = ((g.a)this.L.get(0)).a.msg_flag.get();
              if ((l1 & 0x2) == 2L)
              {
                localObject1 = "[有人@我]";
                break label168;
              }
              if ((l1 & 1L) == 1L)
              {
                localObject1 = "[特别关注]";
                break label168;
              }
            }
            localObject1 = "";
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[离线消息]");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(localObject2[2]);
            ((StringBuilder)localObject3).append(":");
            ((StringBuilder)localObject3).append(localObject2[1]);
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(localObject2[5]);
            ((StringBuilder)localObject4).append("[离线消息]");
            localObject4 = ((StringBuilder)localObject4).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(localObject2[2]);
            localStringBuilder.append(":");
            localStringBuilder.append(localObject2[1]);
            localObject1 = localStringBuilder.toString();
            arrayOfObject[0] = localObject3;
            arrayOfObject[1] = localObject4;
            arrayOfObject[2] = localObject1;
            arrayOfObject[3] = localObject2[3];
            return arrayOfObject;
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[离线消息]");
          ((StringBuilder)localObject1).append(localObject2[2]);
          ((StringBuilder)localObject1).append("(");
          ((StringBuilder)localObject1).append(localObject2[4]);
          ((StringBuilder)localObject1).append("):");
          ((StringBuilder)localObject1).append(localObject2[1]);
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(localObject2[4]);
          ((StringBuilder)localObject3).append("[离线消息]");
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(localObject2[2]);
          ((StringBuilder)localObject4).append(":");
          ((StringBuilder)localObject4).append(localObject2[1]);
          localObject4 = ((StringBuilder)localObject4).toString();
          arrayOfObject[0] = localObject1;
          arrayOfObject[1] = localObject3;
          arrayOfObject[2] = localObject4;
          arrayOfObject[3] = localObject2[3];
          return arrayOfObject;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[离线消息]");
      ((StringBuilder)localObject1).append(localObject2[2]);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(localObject2[1]);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localObject2[2]);
      ((StringBuilder)localObject3).append("[离线消息]");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = (String)localObject2[1];
      arrayOfObject[0] = localObject1;
      arrayOfObject[1] = localObject3;
      arrayOfObject[2] = localObject4;
      arrayOfObject[3] = localObject2[3];
      return arrayOfObject;
    }
    int i1 = t();
    if ((i1 == 1) && (!paramBoolean))
    {
      localObject1 = this.L;
      arrayOfObject = b(((g.a)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).a);
      if (arrayOfObject == null) {
        return null;
      }
      localObject2 = new Object[4];
      i1 = ((Integer)arrayOfObject[0]).intValue();
      if (i1 != 0) {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3) {
              return null;
            }
            if (((g.a)this.L.get(0)).a.msg_flag.has())
            {
              localObject1 = this.L;
              l1 = ((g.a)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).a.msg_flag.get();
              if ((l1 & 0x2) == 2L)
              {
                localObject1 = "[有人@我]";
                break label843;
              }
              if ((l1 & 1L) == 1L)
              {
                localObject1 = "[特别关注]";
                break label843;
              }
            }
            localObject1 = "";
            label843:
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[离线消息]");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(arrayOfObject[2]);
            ((StringBuilder)localObject3).append(":");
            ((StringBuilder)localObject3).append(arrayOfObject[1]);
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(arrayOfObject[5]);
            ((StringBuilder)localObject4).append("[");
            ((StringBuilder)localObject4).append(this.L.size());
            ((StringBuilder)localObject4).append("条离线消息]");
            localObject4 = ((StringBuilder)localObject4).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(arrayOfObject[2]);
            localStringBuilder.append(":");
            localStringBuilder.append(arrayOfObject[1]);
            localObject1 = localStringBuilder.toString();
            localObject2[0] = localObject3;
            localObject2[1] = localObject4;
            localObject2[2] = localObject1;
            localObject2[3] = arrayOfObject[3];
            return localObject2;
          }
        }
        else
        {
          i2 = u();
          if (i2 == 1) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i1 != 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[离线消息]");
            ((StringBuilder)localObject1).append(arrayOfObject[2]);
            ((StringBuilder)localObject1).append("(");
            ((StringBuilder)localObject1).append(arrayOfObject[4]);
            ((StringBuilder)localObject1).append("):");
            ((StringBuilder)localObject1).append(arrayOfObject[1]);
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(arrayOfObject[4]);
            ((StringBuilder)localObject3).append("[");
            ((StringBuilder)localObject3).append(this.L.size());
            ((StringBuilder)localObject3).append("条离线消息]");
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(arrayOfObject[2]);
            ((StringBuilder)localObject4).append(":");
            ((StringBuilder)localObject4).append(arrayOfObject[1]);
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject2[0] = localObject1;
            localObject2[1] = localObject3;
            localObject2[2] = localObject4;
            localObject2[3] = arrayOfObject[3];
            return localObject2;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("有");
          ((StringBuilder)localObject1).append(i2);
          ((StringBuilder)localObject1).append("个联系人给你发来");
          ((StringBuilder)localObject1).append(this.L.size());
          ((StringBuilder)localObject1).append("条离线消息");
          localObject2[2] = ((StringBuilder)localObject1).toString();
          localObject2[3] = arrayOfObject[3];
          localObject2[1] = "QQ[离线消息]";
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[离线消息]");
          ((StringBuilder)localObject1).append(arrayOfObject[2]);
          ((StringBuilder)localObject1).append("(");
          ((StringBuilder)localObject1).append(arrayOfObject[4]);
          ((StringBuilder)localObject1).append("):");
          ((StringBuilder)localObject1).append(arrayOfObject[1]);
          localObject2[0] = ((StringBuilder)localObject1).toString();
          return localObject2;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[离线消息]");
      ((StringBuilder)localObject1).append(arrayOfObject[2]);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(arrayOfObject[1]);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(arrayOfObject[2]);
      ((StringBuilder)localObject3).append("[");
      ((StringBuilder)localObject3).append(this.L.size());
      ((StringBuilder)localObject3).append("条离线消息]");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = (String)arrayOfObject[1];
      localObject2[0] = localObject1;
      localObject2[1] = localObject3;
      localObject2[2] = localObject4;
      localObject2[3] = arrayOfObject[3];
      return localObject2;
    }
    Object localObject1 = this.L;
    Object[] arrayOfObject = b(((g.a)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).a);
    if (arrayOfObject == null) {
      return null;
    }
    int i2 = ((Integer)arrayOfObject[0]).intValue();
    if (i2 != 0)
    {
      if (i2 == 1) {
        break label1895;
      }
      if (i2 != 2)
      {
        if (i2 != 3) {
          return null;
        }
        if (((g.a)this.L.get(0)).a.msg_flag.has())
        {
          localObject1 = this.L;
          l1 = ((g.a)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).a.msg_flag.get();
          if ((l1 & 0x2) == 2L)
          {
            localObject1 = "[有人@我]";
            break label1743;
          }
          if ((l1 & 1L) == 1L)
          {
            localObject1 = "[特别关注]";
            break label1743;
          }
        }
        localObject1 = "";
        label1743:
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[离线消息]");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(arrayOfObject[2]);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(arrayOfObject[1]);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("有");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append("个联系人给你发来");
        ((StringBuilder)localObject2).append(this.L.size());
        ((StringBuilder)localObject2).append("条离线消息");
        return new Object[] { localObject1, "QQ[离线消息]", ((StringBuilder)localObject2).toString(), arrayOfObject[3] };
      }
    }
    break label2059;
    label1895:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("有");
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append("个联系人给你发来");
    ((StringBuilder)localObject1).append(this.L.size());
    ((StringBuilder)localObject1).append("条离线消息");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = arrayOfObject[3];
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[离线消息]");
    ((StringBuilder)localObject3).append(arrayOfObject[2]);
    ((StringBuilder)localObject3).append("(");
    ((StringBuilder)localObject3).append(arrayOfObject[4]);
    ((StringBuilder)localObject3).append("):");
    ((StringBuilder)localObject3).append(arrayOfObject[1]);
    return new Object[] { ((StringBuilder)localObject3).toString(), "QQ[离线消息]", localObject1, localObject2 };
    label2059:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("有");
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append("个联系人给你发来");
    ((StringBuilder)localObject1).append(this.L.size());
    ((StringBuilder)localObject1).append("条离线消息");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = arrayOfObject[3];
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[离线消息]");
    ((StringBuilder)localObject3).append(arrayOfObject[2]);
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append(arrayOfObject[1]);
    return new Object[] { ((StringBuilder)localObject3).toString(), "QQ[离线消息]", localObject1, localObject2 };
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.L.size() > 0)
    {
      offlinepush.PbPushOffMsg localPbPushOffMsg = ((g.a)this.L.get(0)).a;
      BaseApplication localBaseApplication = BaseApplication.getContext();
      Object localObject1 = b(paramBoolean);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "Decode Message error, exit now");
        }
        return;
      }
      Object localObject4 = (String)localObject1[0];
      Object localObject5 = (String)localObject1[1];
      String str = (String)localObject1[2];
      Object localObject2 = BitmapFactory.decodeFile((String)localObject1[3]);
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = a((Bitmap)localObject2, 50, 50);
      }
      localObject2 = new NotificationCompat.Builder(localBaseApplication).setContentTitle((CharSequence)localObject5).setContentText(str).setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker((CharSequence)localObject4).setWhen(System.currentTimeMillis());
      if (localObject1 != null) {
        ((NotificationCompat.Builder)localObject2).setLargeIcon((Bitmap)localObject1);
      } else {
        ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapFactory.decodeResource(localBaseApplication.getResources(), BaseApplication.qqlaunchicon));
      }
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject2).setSmallIcon(BaseApplication.qqlaunchicon);
      }
      if (a(localBaseApplication, localPbPushOffMsg.to_uin.get()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "isShowNofityLight=true");
        }
        if (Calendar.getInstance().get(11) < 23) {}
        ((NotificationCompat.Builder)localObject2).setLights(-16711936, 2000, 2000);
      }
      localObject1 = new Intent("com.tencent.mobileqq.msf.receiveofflinepush");
      ((Intent)localObject1).putExtra("param_fromuin", localPbPushOffMsg.from_uin.get());
      ((Intent)localObject1).putExtra("param_notifyid", 478);
      ((Intent)localObject1).setPackage("com.tencent.mobileqq");
      ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getBroadcast(localBaseApplication, 0, (Intent)localObject1, 0));
      ((NotificationCompat.Builder)localObject2).setDeleteIntent(PendingIntent.getBroadcast(localBaseApplication, 0, new Intent("com.tencent.mobileqq.msf.offlinepushclearall"), 0));
      localObject1 = ((NotificationCompat.Builder)localObject2).build();
      localObject2 = this.X;
      QQNotificationManager.addChannelIfNeed((Notification)localObject1, "CHANNEL_ID_SHOW_BADGE");
      localObject2 = this.X;
      if (localObject2 != null) {
        ((QQNotificationManager)localObject2).cancel("MSF.C.PushManager", 478);
      }
      int i1;
      if (this.q) {
        try
        {
          localObject2 = BaseApplication.getContext().getSharedPreferences("unreadcount", 4);
          i1 = ((SharedPreferences)localObject2).getInt("unread", -1);
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("NOTIFICATION_ID_PUSH_MSG mIsPushOffAVShow ");
            ((StringBuilder)localObject4).append(this.O);
            ((StringBuilder)localObject4).append("count=");
            ((StringBuilder)localObject4).append(i1);
            QLog.i("BadgeUtilImpl", 2, ((StringBuilder)localObject4).toString());
          }
          if (this.O) {
            i1 = this.L.size();
          } else {
            i1 = this.L.size() + i1;
          }
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("NOTIFICATION_ID_PUSH_MSG changeMI6Badge count=");
            ((StringBuilder)localObject4).append(i1);
            QLog.i("BadgeUtilImpl", 2, ((StringBuilder)localObject4).toString());
          }
          int i2 = i1;
          if (this.O)
          {
            i2 = i1;
            if (this.N) {
              i2 = i1 + ((SharedPreferences)localObject2).getInt("unread", -1);
            }
          }
          this.N = true;
          BadgeUtilImpl.changeMI6Badge(BaseApplication.getContext(), i2, (Notification)localObject1);
        }
        catch (Throwable localThrowable)
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("NOTIFICATION_ID_PUSH_MSG exception ex=");
            ((StringBuilder)localObject4).append(localThrowable);
            QLog.i("BadgeUtilImpl", 2, ((StringBuilder)localObject4).toString());
          }
        }
      }
      Object localObject3 = String.valueOf(localPbPushOffMsg.to_uin.get());
      paramBoolean = b.b(localBaseApplication, (String)localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, new Object[] { "fireNotifition: invoked. ", " msgNotificationEnabled: ", Boolean.valueOf(paramBoolean), " toUin: ", localObject3 });
      }
      if (paramBoolean)
      {
        if ((w()) && (SdkInfoUtil.isOreo()) && (this.r))
        {
          this.r = false;
          QLog.d("MSF.C.PushManager", 1, "HPush_msf-notification cancelAll before first notify:");
          this.X.cancelAll();
        }
        this.X.notify("MSF.C.PushManager", 478, (Notification)localObject1);
      }
      localObject1 = PreferenceManager.getDefaultSharedPreferences(localBaseApplication);
      localObject3 = localBaseApplication.getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      if (c(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) == 0) {
        if (a(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) != 1) {}
      }
      for (;;)
      {
        i1 = 1;
        break;
        do
        {
          i1 = 0;
          break;
        } while (c(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) != 1);
      }
      if ((b(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) == 1) && (z()))
      {
        localObject4 = (Vibrator)localBaseApplication.getSystemService("vibrator");
        if (a((SharedPreferences)localObject3)) {
          ((Vibrator)localObject4).vibrate(1000L);
        } else {
          ((Vibrator)localObject4).vibrate(aD, -1);
        }
      }
      if ((i1 != 0) && (y()))
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("-->isSpecialCareSound:");
          ((StringBuilder)localObject4).append(a((SharedPreferences)localObject3));
          QLog.i("PushManager", 2, ((StringBuilder)localObject4).toString());
        }
        if (a((SharedPreferences)localObject3))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("sound_type");
          ((StringBuilder)localObject4).append(localPbPushOffMsg.to_uin.get());
          i1 = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject4).toString(), BaseApplication.defaultNotifSoundResourceId);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("special_sound_type");
          localObject5 = this.L;
          ((StringBuilder)localObject4).append(((g.a)((ArrayList)localObject5).get(((ArrayList)localObject5).size() - 1)).a.to_uin.get());
          localObject5 = this.L;
          ((StringBuilder)localObject4).append(((g.a)((ArrayList)localObject5).get(((ArrayList)localObject5).size() - 1)).a.from_uin.get());
          i1 = ((SharedPreferences)localObject3).getInt(((StringBuilder)localObject4).toString(), i1);
          if (i1 == 1) {}
          try
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("defaulut_special_sound_source");
            ((StringBuilder)localObject4).append(i1);
            ((SharedPreferences)localObject3).getInt(((StringBuilder)localObject4).toString(), i1);
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label1363;
            }
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("special sound play exception|");
            ((StringBuilder)localObject4).append(localException.getMessage());
            QLog.i("PushManager", 2, ((StringBuilder)localObject4).toString());
            localException.printStackTrace();
          }
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("special_sound_url");
          ((StringBuilder)localObject4).append(i1);
          localObject3 = ((SharedPreferences)localObject3).getString(((StringBuilder)localObject4).toString(), "");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject3 = new File(BaseApplication.getContext().getFilesDir(), (String)localObject3);
            if (((File)localObject3).exists())
            {
              a(((File)localObject3).getAbsolutePath(), false);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("PushManager", 2, "-->special sound not exist.");
            }
          }
        }
      }
      label1363:
      if ((a(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) == 1) && (y()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sound_type");
        localStringBuilder.append(localPbPushOffMsg.to_uin.get());
        a(((SharedPreferences)localObject1).getInt(localStringBuilder.toString(), BaseApplication.defaultNotifSoundResourceId), false);
      }
      return;
    }
    if (this.X == null) {
      this.X = QQNotificationManager.getInstance();
    }
    this.X.cancel("MSF.C.PushManager", 478);
  }
  
  private boolean c(offlinepush.PbPushOffMsg paramPbPushOffMsg)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvPbPushOffMsg msg_type:0x");
      localStringBuilder.append(Integer.toHexString(paramPbPushOffMsg.msg_type.get()));
      localStringBuilder.append(" dwViedoType:");
      localStringBuilder.append(paramPbPushOffMsg.dwViedoType.get());
      QLog.d("MSF.C.PushManager", 4, localStringBuilder.toString());
    }
    return (paramPbPushOffMsg.msg_type.get() == 734) || (paramPbPushOffMsg.msg_type.get() == 215) || (paramPbPushOffMsg.msg_type.get() == 519) || (paramPbPushOffMsg.msg_type.get() == 562);
  }
  
  private void f(String paramString)
  {
    Object localObject = (a)this.i.get(paramString);
    ((a)localObject).n = String.valueOf(com.tencent.mobileqq.msf.core.c.e(BaseApplication.getContext()));
    JceOutputStream localJceOutputStream = new JceOutputStream();
    ((a)localObject).writeTo(localJceOutputStream);
    localObject = MsfStore.getNativeConfigStore();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("app_push_info_");
    localStringBuilder.append(paramString);
    ((NativeConfigStore)localObject).setConfig(localStringBuilder.toString(), HexUtil.bytes2HexStr(localJceOutputStream.toByteArray()));
  }
  
  private void s()
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.msf.wakeup");
    localIntent.setPackage(BaseApplication.getContext().getPackageName());
    BaseApplication.getContext().sendBroadcast(localIntent);
  }
  
  private int t()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.L.iterator();
    while (localIterator1.hasNext())
    {
      Long localLong = Long.valueOf(((g.a)localIterator1.next()).a.from_uin.get());
      int i2 = 0;
      Iterator localIterator2 = localArrayList.iterator();
      do
      {
        i1 = i2;
        if (!localIterator2.hasNext()) {
          break;
        }
      } while (!((Long)localIterator2.next()).equals(localLong));
      int i1 = 1;
      if (i1 == 0) {
        localArrayList.add(localLong);
      }
    }
    return localArrayList.size();
  }
  
  private int u()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.L.iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (g.a)localIterator1.next();
      int i1 = a(((g.a)localObject).a.msg_type.get(), ((g.a)localObject).a.dwViedoType.get());
      if ((i1 != 0) && (i1 == 1) && (((g.a)localObject).a.discuss_info.has()))
      {
        localObject = Long.valueOf(((g.a)localObject).a.discuss_info.discuss_uin.get());
        int i2 = 0;
        Iterator localIterator2 = localArrayList.iterator();
        do
        {
          i1 = i2;
          if (!localIterator2.hasNext()) {
            break;
          }
        } while (!((Long)localIterator2.next()).equals(localObject));
        i1 = 1;
        if (i1 == 0) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList.size();
  }
  
  private Object[] v()
  {
    if (this.M.size() == 1)
    {
      Object[] arrayOfObject1 = new Object[4];
      Object[] arrayOfObject2 = b(((g.a)this.M.get(0)).a);
      if (arrayOfObject2 == null) {
        return null;
      }
      int i1 = ((Integer)arrayOfObject2[0]).intValue();
      if (i1 != 0) {
        if (i1 != 1)
        {
          if (i1 != 2) {
            return null;
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[离线消息]");
          ((StringBuilder)localObject1).append(arrayOfObject2[2]);
          ((StringBuilder)localObject1).append("(");
          ((StringBuilder)localObject1).append(arrayOfObject2[4]);
          ((StringBuilder)localObject1).append("):");
          ((StringBuilder)localObject1).append(arrayOfObject2[1]);
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(arrayOfObject2[4]);
          ((StringBuilder)localObject2).append("[离线消息]");
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(arrayOfObject2[2]);
          ((StringBuilder)localObject3).append(":");
          ((StringBuilder)localObject3).append(arrayOfObject2[1]);
          localObject3 = ((StringBuilder)localObject3).toString();
          arrayOfObject1[0] = localObject1;
          arrayOfObject1[1] = localObject2;
          arrayOfObject1[2] = localObject3;
          arrayOfObject1[3] = arrayOfObject2[3];
          return arrayOfObject1;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[离线消息]");
      ((StringBuilder)localObject1).append(arrayOfObject2[2]);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(arrayOfObject2[1]);
      localObject3 = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(arrayOfObject2[2]);
      ((StringBuilder)localObject1).append("[离线消息]");
      String str2 = ((StringBuilder)localObject1).toString();
      String str1 = (String)arrayOfObject2[1];
      localObject1 = localObject3;
      localObject2 = str1;
      if (b(BaseApplication.getContext()))
      {
        localObject1 = localObject3;
        localObject2 = str1;
        if (((String)arrayOfObject2[1]).contains("视频"))
        {
          localObject2 = "给你发起过视频通话，请结束当前电话后回拨。";
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(arrayOfObject2[2]);
          ((StringBuilder)localObject1).append("给你发起过视频通话，请结束当前电话后回拨。");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        if (((String)arrayOfObject2[1]).contains("语音"))
        {
          localObject2 = "给你发起过语音通话，请结束当前电话后回拨。";
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(arrayOfObject2[2]);
          ((StringBuilder)localObject1).append("给你发起过语音通话，请结束当前电话后回拨。");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      arrayOfObject1[0] = localObject1;
      arrayOfObject1[1] = str2;
      arrayOfObject1[2] = localObject2;
      arrayOfObject1[3] = arrayOfObject2[3];
      return arrayOfObject1;
    }
    Object localObject1 = new Object[4];
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("收到");
    ((StringBuilder)localObject2).append(this.M.size());
    ((StringBuilder)localObject2).append("个未接来电");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1[2] = localObject2;
    localObject1[1] = "QQ[离线消息]";
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[离线消息]QQ ");
    ((StringBuilder)localObject3).append((String)localObject2);
    localObject1[0] = ((StringBuilder)localObject3).toString();
    return localObject1;
  }
  
  private static boolean w()
  {
    return ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 21);
  }
  
  private void x()
  {
    if (this.M.size() > 0)
    {
      offlinepush.PbPushOffMsg localPbPushOffMsg = ((g.a)this.M.get(0)).a;
      BaseApplication localBaseApplication = BaseApplication.getContext();
      Object localObject1 = v();
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "Decode Message error, exit now");
        }
        return;
      }
      Object localObject4 = (String)localObject1[0];
      String str1 = (String)localObject1[1];
      String str2 = (String)localObject1[2];
      Object localObject2 = BitmapFactory.decodeFile((String)localObject1[3]);
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = a((Bitmap)localObject2, 50, 50);
      }
      if (this.X == null) {
        this.X = QQNotificationManager.getInstance();
      }
      localObject2 = new NotificationCompat.Builder(localBaseApplication).setContentTitle(str1).setContentText(str2).setAutoCancel(true).setSmallIcon(BaseApplication.appnewavmsgicon).setTicker((CharSequence)localObject4).setWhen(System.currentTimeMillis());
      if (localObject1 != null) {
        ((NotificationCompat.Builder)localObject2).setLargeIcon((Bitmap)localObject1);
      } else {
        ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapFactory.decodeResource(localBaseApplication.getResources(), BaseApplication.qqlaunchicon));
      }
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject2).setSmallIcon(BaseApplication.qqlaunchicon);
      }
      if (a(localBaseApplication, localPbPushOffMsg.to_uin.get()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "isShowNofityLight=true");
        }
        if (Calendar.getInstance().get(11) < 23) {}
        ((NotificationCompat.Builder)localObject2).setLights(-16711936, 2000, 2000);
      }
      localObject1 = new Intent("com.tencent.mobileqq.msf.receiveofflinepushav");
      ((Intent)localObject1).putExtra("param_fromuin", localPbPushOffMsg.from_uin.get());
      ((Intent)localObject1).putExtra("param_notifyid", 479);
      ((Intent)localObject1).setPackage("com.tencent.mobileqq");
      ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getBroadcast(localBaseApplication, 0, (Intent)localObject1, 0));
      ((NotificationCompat.Builder)localObject2).setDeleteIntent(PendingIntent.getBroadcast(localBaseApplication, 0, new Intent("com.tencent.mobileqq.msf.offlinepushclearallav"), 0));
      localObject1 = ((NotificationCompat.Builder)localObject2).build();
      this.X.cancel("MSF.C.PushManager", 479);
      if (this.q) {
        try
        {
          int i1 = BaseApplication.getContext().getSharedPreferences("unreadcount", 4).getInt("unread", -1);
          if (this.N) {
            i1 = this.M.size();
          } else {
            i1 += this.M.size();
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("NOTIFICATION_ID_PUSH_AVMSG changeMI6Badge count=");
            ((StringBuilder)localObject2).append(i1);
            QLog.i("BadgeUtilImpl", 2, ((StringBuilder)localObject2).toString());
          }
          this.O = true;
          BadgeUtilImpl.changeMI6Badge(BaseApplication.getContext(), i1, (Notification)localObject1);
        }
        catch (Throwable localThrowable)
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("NOTIFICATION_ID_PUSH_AVMSG exception ex=");
            ((StringBuilder)localObject4).append(localThrowable);
            QLog.i("BadgeUtilImpl", 2, ((StringBuilder)localObject4).toString());
          }
        }
      }
      Object localObject3 = this.X;
      QQNotificationManager.addChannelIfNeed((Notification)localObject1, "CHANNEL_ID_SHOW_BADGE");
      this.X.notify("MSF.C.PushManager", 479, (Notification)localObject1);
      if ((a(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) == 1) && (y()))
      {
        localObject1 = PreferenceManager.getDefaultSharedPreferences(localBaseApplication);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("sound_type");
        ((StringBuilder)localObject3).append(localPbPushOffMsg.to_uin.get());
        a(((SharedPreferences)localObject1).getInt(((StringBuilder)localObject3).toString(), BaseApplication.defaultNotifSoundResourceId), false);
      }
      if ((b(String.valueOf(localPbPushOffMsg.to_uin.get()), localBaseApplication) == 1) && (z())) {
        ((Vibrator)localBaseApplication.getSystemService("vibrator")).vibrate(aD, -1);
      }
      return;
    }
    if (this.X == null) {
      this.X = QQNotificationManager.getInstance();
    }
    this.X.cancel("MSF.C.PushManager", 479);
  }
  
  private boolean y()
  {
    return com.tencent.qphone.base.util.a.b();
  }
  
  private boolean z()
  {
    return (com.tencent.qphone.base.util.a.d()) || ((com.tencent.qphone.base.util.a.b()) && (com.tencent.qphone.base.util.a.c()));
  }
  
  public int a(String paramString)
  {
    Iterator localIterator = this.i.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.i.get(localObject);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).k.uin.equals(paramString)))
      {
        if (((a)localObject).c == 0L) {
          return -2;
        }
        return ((a)localObject).k.iStatus;
      }
    }
    return -1;
  }
  
  public int a(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 1;
    }
    paramString = paramContext.getSharedPreferences(paramString, 4).getString(this.aq, String.valueOf(1));
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 1;
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject = BaseApplication.getContext().getFilesDir().getPath();
    StringBuilder localStringBuilder1 = new StringBuilder(256);
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      localStringBuilder1.append(this.ag);
    }
    else
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append((String)localObject);
      localStringBuilder2.append(this.ai);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localObject = b(paramInt, paramString);
    paramInt = ((Integer)localObject[0]).intValue();
    if (paramInt != -56)
    {
      if (paramInt != -55)
      {
        if (paramInt != 1)
        {
          if (paramInt == 3) {
            localStringBuilder1.append("discussion_");
          }
        }
        else {
          localStringBuilder1.append("troop_");
        }
      }
      else
      {
        localStringBuilder1.append("sys_");
        paramString = (String)localObject[1];
      }
    }
    else
    {
      localStringBuilder1.append("troop_sys_");
      paramString = (String)localObject[1];
    }
    localObject = MD5.toMD5(paramString);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append((String)localObject);
    localStringBuilder2.append(paramString);
    localObject = MD5.toMD5(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append((String)localObject);
    localStringBuilder2.append(paramString);
    localStringBuilder1.append(MD5.toMD5(localStringBuilder2.toString()));
    localStringBuilder1.append(".png");
    return localStringBuilder1.toString();
  }
  
  public void a()
  {
    try
    {
      if (!this.s)
      {
        this.n.start();
        this.s = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   13: invokevirtual 1535	android/media/MediaPlayer:isPlaying	()Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   28: invokevirtual 1538	android/media/MediaPlayer:release	()V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   36: goto +13 -> 49
    //   39: astore 4
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   46: aload 4
    //   48: athrow
    //   49: iload_1
    //   50: sipush 1000
    //   53: if_icmpeq +18 -> 71
    //   56: aload_0
    //   57: aload_0
    //   58: invokestatic 503	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   61: iload_1
    //   62: invokespecial 1540	com/tencent/mobileqq/msf/core/push/g:a	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   65: putfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   68: goto +17 -> 85
    //   71: aload_0
    //   72: aload_0
    //   73: invokestatic 503	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   76: getstatic 1546	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   79: invokespecial 1548	com/tencent/mobileqq/msf/core/push/g:a	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   82: putfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   85: aload_0
    //   86: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   89: astore 4
    //   91: aload 4
    //   93: ifnonnull +6 -> 99
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: aload_0
    //   100: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   103: new 1550	com/tencent/mobileqq/msf/core/push/k
    //   106: dup
    //   107: aload_0
    //   108: invokespecial 1551	com/tencent/mobileqq/msf/core/push/k:<init>	(Lcom/tencent/mobileqq/msf/core/push/g;)V
    //   111: invokevirtual 1555	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   114: aload_0
    //   115: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   118: invokevirtual 1556	android/media/MediaPlayer:start	()V
    //   121: aload_0
    //   122: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   125: iload_2
    //   126: invokevirtual 1559	android/media/MediaPlayer:setLooping	(Z)V
    //   129: goto +10 -> 139
    //   132: astore 4
    //   134: aload_0
    //   135: monitorexit
    //   136: aload 4
    //   138: athrow
    //   139: aload_0
    //   140: monitorexit
    //   141: return
    //   142: astore 4
    //   144: goto -5 -> 139
    //   147: astore 4
    //   149: goto -118 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	g
    //   0	152	1	paramInt	int
    //   0	152	2	paramBoolean	boolean
    //   16	2	3	bool	boolean
    //   39	8	4	localObject1	Object
    //   89	3	4	localMediaPlayer	MediaPlayer
    //   132	5	4	localObject2	Object
    //   142	1	4	localException1	Exception
    //   147	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	31	39	finally
    //   2	17	132	finally
    //   31	36	132	finally
    //   41	49	132	finally
    //   56	68	132	finally
    //   71	85	132	finally
    //   85	91	132	finally
    //   99	129	132	finally
    //   2	17	142	java/lang/Exception
    //   31	36	142	java/lang/Exception
    //   41	49	142	java/lang/Exception
    //   56	68	142	java/lang/Exception
    //   71	85	142	java/lang/Exception
    //   85	91	142	java/lang/Exception
    //   99	129	142	java/lang/Exception
    //   24	31	147	java/lang/Exception
  }
  
  public void a(long paramLong)
  {
    long l1;
    if (paramLong < 30000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "queryPushIntervTime less than 30000,change to 30000.");
      }
      l1 = 30000L;
    }
    else
    {
      l1 = paramLong;
      if (paramLong > 3600000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "queryPushIntervTime greater than 600000 ,change to 600000.");
        }
        l1 = 3600000L;
      }
    }
    if (this.ax != null) {
      a(BaseApplication.getContext());
    }
    Object localObject = new Intent(this.e);
    ((Intent)localObject).setAction(this.e);
    this.ax = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
    this.m = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    paramLong = System.currentTimeMillis() + l1;
    if ((Build.VERSION.SDK_INT >= 23) && (com.tencent.mobileqq.msf.core.a.a.bs())) {
      try
      {
        localObject = AlarmManager.class.getDeclaredMethod("setAndAllowWhileIdle", new Class[] { Integer.TYPE, Long.TYPE, PendingIntent.class });
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(this.m, new Object[] { Integer.valueOf(0), Long.valueOf(paramLong), this.ax });
      }
      catch (Exception localException1)
      {
        QLog.e("MSF.C.PushManager", 1, "MSF_Alive_Log doRegistertAlarm excep!", localException1);
        try
        {
          this.m.set(0, paramLong, this.ax);
        }
        catch (Exception localException2)
        {
          QLog.e("MSF.C.PushManager", 1, "MSF_Alive_Log doRegistertAlarm excep throw et!", localException2);
        }
      }
    } else {
      try
      {
        this.m.set(0, paramLong, this.ax);
      }
      catch (Exception localException3)
      {
        QLog.e("MSF.C.PushManager", 1, "MSF_Alive_Log doRegistertAlarm excep throw et!", localException3);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MSF_Alive_Log register ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" alarm alive send at ");
      localStringBuilder.append(h.format(Long.valueOf(paramLong)));
      QLog.d("MSF.C.PushManager", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.aB = paramLong1;
    c(paramLong2);
  }
  
  public void a(Context paramContext)
  {
    paramContext = this.ax;
    if (paramContext != null) {
      this.m.cancel(paramContext);
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    this.X = QQNotificationManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("|");
    localStringBuilder.append(Build.VERSION.RELEASE);
    this.d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsfSdkUtils.getProcessName(paramContext));
    localStringBuilder.append("_");
    localStringBuilder.append(getClass().hashCode());
    this.e = localStringBuilder.toString();
    paramContext = new IntentFilter();
    paramContext.addAction(this.e);
    BaseApplication.getContext().registerReceiver(this, paramContext);
    this.m = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    a(paramBoolean);
  }
  
  public void a(a parama, RegPushReason paramRegPushReason)
  {
    if (parama.c > 0L)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("send ");
        localStringBuilder.append(parama.b);
        localStringBuilder.append(" push register, pushId is ");
        localStringBuilder.append(parama.c);
        QLog.d("MSF.C.PushManager", 2, localStringBuilder.toString());
      }
      this.j.a(parama, null, false, paramRegPushReason);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramRegPushReason = new StringBuilder();
      paramRegPushReason.append(parama.b);
      paramRegPushReason.append(" queryPushId is ");
      paramRegPushReason.append(parama.c);
      paramRegPushReason.append(" ,skip register.");
      QLog.d("MSF.C.PushManager", 2, paramRegPushReason.toString());
    }
  }
  
  public void a(CommandCallbackerInfo paramCommandCallbackerInfo, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      String str = com.tencent.mobileqq.msf.service.u.b(paramToServiceMsg);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("recv processName:");
        localStringBuilder.append(str);
        localStringBuilder.append(" appCmdCallbacker ");
        localStringBuilder.append(paramCommandCallbackerInfo);
        QLog.d("MSF.C.PushManager", 2, localStringBuilder.toString());
      }
      if (!this.i.containsKey(str)) {
        this.i.putIfAbsent(str, new a(str));
      }
      ((a)this.i.get(str)).m = paramCommandCallbackerInfo;
      paramCommandCallbackerInfo = com.tencent.mobileqq.msf.service.u.a(paramToServiceMsg);
      paramCommandCallbackerInfo.setMsgSuccess();
      this.c.addRespToQuque(paramToServiceMsg, paramCommandCallbackerInfo);
      f(str);
      return;
    }
    finally {}
  }
  
  public void a(PushRegisterInfo paramPushRegisterInfo, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      String str = com.tencent.mobileqq.msf.service.u.b(paramToServiceMsg);
      if (a(str, BaseApplication.getContext().getPackageName()))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("recv processName:");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(" recv unRegisterPush ");
          QLog.d("MSF.C.PushManager", 2, ((StringBuilder)localObject).toString());
        }
        if (!this.i.containsKey(str)) {
          this.i.putIfAbsent(str, new a(str));
        }
        ((a)this.i.get(str)).k = paramPushRegisterInfo;
        ((a)this.i.get(str)).a = paramToServiceMsg.getAppId();
        ((a)this.i.get(str)).c = 0L;
        this.j.a((a)this.i.get(str), paramToServiceMsg, true, RegPushReason.appRegister);
        paramToServiceMsg = ((a)this.i.get(str)).k.pushIds;
        paramPushRegisterInfo = paramPushRegisterInfo.pushIds;
        Object localObject = new ArrayList();
        paramToServiceMsg = paramToServiceMsg.iterator();
        while (paramToServiceMsg.hasNext())
        {
          long l1 = ((Long)paramToServiceMsg.next()).longValue();
          if (!paramPushRegisterInfo.contains(Long.valueOf(l1))) {
            ((ArrayList)localObject).add(Long.valueOf(l1));
          }
        }
        ((a)this.i.get(str)).k.pushIds = ((ArrayList)localObject);
        if (((a)this.i.get(str)).c == 0L) {
          ((a)this.i.get(str)).k = null;
        }
        f(str);
      }
      else if (QLog.isColorLevel())
      {
        paramPushRegisterInfo = new StringBuilder();
        paramPushRegisterInfo.append("recv other processName:");
        paramPushRegisterInfo.append(str);
        paramPushRegisterInfo.append(" recv unRegisterPush ");
        QLog.e("MSF.C.PushManager", 2, paramPushRegisterInfo.toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramPushRegisterInfo;
    }
  }
  
  public void a(z paramz, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recv proxyRegister sendProcess=");
      ((StringBuilder)localObject).append(com.tencent.mobileqq.msf.service.u.b(paramToServiceMsg));
      ((StringBuilder)localObject).append(" registerProcess");
      ((StringBuilder)localObject).append(paramz.b);
      ((StringBuilder)localObject).append(" callbacker=");
      ((StringBuilder)localObject).append(paramz.e);
      ((StringBuilder)localObject).append(" appid=");
      ((StringBuilder)localObject).append(paramz.a);
      ((StringBuilder)localObject).append(" ProxyRegisterInfo=");
      ((StringBuilder)localObject).append(paramz);
      QLog.d("MSF.C.PushManager", 1, ((StringBuilder)localObject).toString());
      if (!this.i.containsKey(paramz.b)) {
        this.i.putIfAbsent(paramz.b, new a(paramz.b));
      }
      localObject = (a)this.i.get(paramz.b);
      ((a)localObject).a = paramz.a;
      ((a)localObject).m = paramz.e;
      ((a)localObject).l = paramz.d;
      localObject = o.a(paramToServiceMsg);
      ((FromServiceMsg)localObject).setMsgSuccess();
      this.c.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject);
      f(paramz.b);
      return;
    }
    finally {}
  }
  
  public void a(offlinepush.PbPushOffMsg paramPbPushOffMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onRecvDevlockQuickloginOfflinePush start...");
    }
    Object localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      if (paramPbPushOffMsg.msg_str.has()) {
        localObject1 = new String(paramPbPushOffMsg.msg_str.get().toByteArray(), "utf-8");
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = localObject3;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onRecvDevlockQuickloginOfflinePush  maintip=");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.d("MSF.C.PushManager", 2, ((StringBuilder)localObject3).toString());
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Object localObject4 = BitmapFactory.decodeResource(localBaseApplication.getResources(), BaseApplication.devlockQuickloginIcon);
    localObject3 = localObject4;
    if (localObject4 != null) {
      localObject3 = a((Bitmap)localObject4, 50, 50);
    }
    Object localObject2 = new NotificationCompat.Builder(localBaseApplication).setContentTitle("一键验证").setContentText((CharSequence)localObject2).setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker("一键验证").setWhen(System.currentTimeMillis());
    if (localObject3 != null) {
      ((NotificationCompat.Builder)localObject2).setLargeIcon((Bitmap)localObject3);
    } else {
      ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapFactory.decodeResource(localBaseApplication.getResources(), BaseApplication.qqlaunchicon));
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((NotificationCompat.Builder)localObject2).setSmallIcon(BaseApplication.qqlaunchicon);
    }
    localObject3 = new Intent("com.tencent.mobileqq.msf.receiveofflinepush");
    localObject4 = PendingIntent.getBroadcast(localBaseApplication, 0, (Intent)localObject3, 0);
    ((Intent)localObject3).putExtra("param_fromuin", paramPbPushOffMsg.from_uin.get());
    ((Intent)localObject3).putExtra("param_notifyid", 480);
    ((NotificationCompat.Builder)localObject2).setContentIntent((PendingIntent)localObject4);
    ((NotificationCompat.Builder)localObject2).setDeleteIntent(PendingIntent.getBroadcast(localBaseApplication, 0, new Intent("com.tencent.mobileqq.msf.devlockquickloginpushclear"), 0));
    paramPbPushOffMsg = ((NotificationCompat.Builder)localObject2).build();
    if (this.X == null) {
      this.X = QQNotificationManager.getInstance();
    }
    this.X.cancel("MSF.C.PushManager", 480);
    localObject2 = this.X;
    QQNotificationManager.addChannelIfNeed(paramPbPushOffMsg, "CHANNEL_ID_OTHER");
    this.X.notify("MSF.C.PushManager", 480, paramPbPushOffMsg);
    this.ac.removeMessages(20140416);
    this.ac.sendEmptyMessageDelayed(20140416, 120000L);
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConnClosed ");
      ((StringBuilder)localObject).append(parama);
      QLog.d("MSF.C.PushManager", 2, ((StringBuilder)localObject).toString());
    }
    label388:
    label396:
    label408:
    for (;;)
    {
      try
      {
        l2 = SystemClock.elapsedRealtime();
        if ((this.E > 0L) && (this.aC > 0L))
        {
          if (this.E <= this.aC) {
            break label388;
          }
          l1 = l2 - this.E;
          bool = true;
          parama = "2";
          i1 = 1;
        }
        else
        {
          parama = "0";
          l1 = 0L;
          i1 = 0;
          bool = true;
        }
        if ((this.F <= 0L) || (this.aC <= 0L)) {
          break label408;
        }
        if (this.F <= this.aC) {
          break label396;
        }
        l1 = l2 - this.F;
        bool = true;
      }
      catch (Exception parama)
      {
        long l2;
        QLog.d("MSF.C.PushManager", 1, "onCloseConn's report error! ", parama);
      }
      if (i1 != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("t1:");
        ((StringBuilder)localObject).append(this.E);
        ((StringBuilder)localObject).append(",t2:");
        ((StringBuilder)localObject).append(this.F);
        ((StringBuilder)localObject).append(",t3:");
        ((StringBuilder)localObject).append(this.aC);
        ((StringBuilder)localObject).append(",t4:");
        ((StringBuilder)localObject).append(l2);
        QLog.d("MSF.C.PushManager", 1, ((StringBuilder)localObject).toString());
        localObject = MsfService.getCore().getAccountCenter().i();
        if (this.c.getStatReporter() != null) {
          this.c.getStatReporter().a(parama, (String)localObject, bool, l1, this.E, this.F, this.G, this.aC, l2);
        }
      }
      v = false;
      this.j.g = false;
      this.D = 0L;
      this.aB = 0L;
      this.aC = 0L;
      this.E = 0L;
      this.F = 0L;
      this.G = 0L;
      l = 0L;
      parama = new i(this);
      parama.setName("onConnClosedPushThread");
      parama.start();
      return;
      long l1 = 0L;
      boolean bool = false;
      continue;
      bool = false;
      parama = "4";
      int i1 = 1;
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = this.i.keySet().iterator();
    int i1 = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (a)this.i.get(localObject2);
      if (localObject2 != null) {
        if (paramFromServiceMsg.getServiceCmd().equals("CliNotifySvc.SvcReqPush"))
        {
          localObject2 = new UniPacket(true);
          ((UniPacket)localObject2).setEncodeName("UTF-8");
          try
          {
            ((UniPacket)localObject2).decode(paramFromServiceMsg.getWupBuffer());
          }
          catch (Throwable paramFromServiceMsg)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("decode PushMsg error ");
              ((StringBuilder)localObject1).append(paramFromServiceMsg);
              QLog.d("MSF.C.PushManager", 2, ((StringBuilder)localObject1).toString(), paramFromServiceMsg);
            }
            return;
          }
        }
        else
        {
          if (paramFromServiceMsg.getServiceCmd().equals("StatSvc.QueryHB")) {
            if (com.tencent.mobileqq.msf.core.a.a.u)
            {
              ((a)localObject2).i = this.c.nowSocketConnAdd;
              ((a)localObject2).f = System.currentTimeMillis();
              a((a)localObject2, RegPushReason.serverPush);
            }
          }
          for (;;)
          {
            i1 = 1;
            break;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("MSF.C.PushManager", 2, "recv push StatSvc.QueryHB, but do not support useAnyPacketAsPushHB ");
            break;
            if (!paramFromServiceMsg.isSuccess()) {
              break label227;
            }
            if (!a((a)localObject2, paramFromServiceMsg)) {
              break;
            }
          }
          label227:
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
            com.tencent.mobileqq.msf.core.c.e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 3);
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("recv error onRecvPushMsg FromServiceMsg  ");
            ((StringBuilder)localObject2).append(paramFromServiceMsg);
            QLog.d("MSF.C.PushManager", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
    }
    if ((i1 == 0) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("found not handle push msg ");
      ((StringBuilder)localObject1).append(paramFromServiceMsg);
      QLog.w("MSF.C.PushManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    this.j.a(paramFromServiceMsg, paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    String str = com.tencent.mobileqq.msf.service.u.b(paramToServiceMsg);
    a locala = (a)this.i.get(str);
    if (locala != null)
    {
      int i1 = ((Integer)paramToServiceMsg.getAttribute("battery_capacity", Integer.valueOf(0))).intValue();
      if (i1 > 0) {
        locala.k.batteryCapacity = i1;
      }
      int i2 = ((Integer)paramToServiceMsg.getAttribute("power_connect", Integer.valueOf(-1))).intValue();
      if (i2 != -1) {
        locala.k.powerConnect = i2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, new Object[] { "updateBatteryStatus batteryCapacity:", Integer.valueOf(i1), " powerConnectStatus:", Integer.valueOf(i2) });
      }
      f(str);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, RegPushReason paramRegPushReason)
  {
    if (this.az.hasMessages(1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "remove message handler mLoadPushInfoHandler");
      }
      this.az.removeMessages(1);
    }
    String str = com.tencent.mobileqq.msf.service.u.b(paramToServiceMsg);
    if (a(str, BaseApplication.getContext().getPackageName()))
    {
      if (!this.i.containsKey(str)) {
        this.i.putIfAbsent(str, new a(str));
      }
      PushRegisterInfo localPushRegisterInfo = aa.b(paramToServiceMsg);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("recv processName:");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(" recv regPush  ,regPushReason:");
        ((StringBuilder)localObject1).append(paramRegPushReason);
        QLog.d("MSF.C.PushManager", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = (a)this.i.get(str);
      if ((localObject1 != null) && (((a)localObject1).k != null) && (((a)localObject1).c != 0L) && (((a)localObject1).k.uin.equals(localPushRegisterInfo.uin)) && (((a)localObject1).k.iStatus == localPushRegisterInfo.iStatus) && (((a)localObject1).k.extStatus == localPushRegisterInfo.extStatus) && (localPushRegisterInfo.extStatus != 1000L) && (((a)localObject1).k.bKikPC == localPushRegisterInfo.bKikPC) && (((a)localObject1).k.bKikWeak == localPushRegisterInfo.bKikWeak) && (((a)localObject1).k.timeStamp == localPushRegisterInfo.timeStamp) && (((a)localObject1).k.iLargeSeq == localPushRegisterInfo.iLargeSeq))
      {
        if (QLog.isColorLevel())
        {
          paramRegPushReason = new StringBuilder();
          paramRegPushReason.append("handlerPush also register Push ");
          paramRegPushReason.append(MD5.toMD5(localPushRegisterInfo.uin));
          paramRegPushReason.append("iStatus:");
          paramRegPushReason.append(localPushRegisterInfo.iStatus);
          paramRegPushReason.append(" extStatus:");
          paramRegPushReason.append(localPushRegisterInfo.extStatus);
          QLog.e("MSF.C.PushManager", 2, paramRegPushReason.toString());
        }
        paramRegPushReason = com.tencent.mobileqq.msf.service.u.a(paramToServiceMsg);
        paramRegPushReason.setMsgSuccess();
        this.c.addRespToQuque(paramToServiceMsg, paramRegPushReason);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handlerPush not found the same register Push ");
          ((StringBuilder)localObject2).append(MD5.toMD5(localPushRegisterInfo.uin));
          ((StringBuilder)localObject2).append(" iStatus:");
          ((StringBuilder)localObject2).append(localPushRegisterInfo.iStatus);
          ((StringBuilder)localObject2).append(" extStatus:");
          ((StringBuilder)localObject2).append(localPushRegisterInfo.extStatus);
          QLog.e("MSF.C.PushManager", 2, ((StringBuilder)localObject2).toString());
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, String.format("old{%s}, new{%s}", new Object[] { a(((a)localObject1).k), a(localPushRegisterInfo) }));
        }
        if (((a)localObject1).k != null) {
          paramToServiceMsg.extraData.putInt("oldStatus", ((a)localObject1).k.iStatus);
        } else {
          QLog.d("MSF.C.PushManager", 1, "oldPushInfo.appPushRegisterInfo is null");
        }
        ((a)localObject1).k = localPushRegisterInfo;
        ((a)localObject1).a = paramToServiceMsg.getAppId();
        Object localObject2 = localPushRegisterInfo.pushIds.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((a)localObject1).c = (((Long)((Iterator)localObject2).next()).longValue() | ((a)localObject1).c);
        }
        f(str);
        this.j.a((a)localObject1, paramToServiceMsg, false, paramRegPushReason);
      }
      if ((localPushRegisterInfo.iStatus != 95) && (localPushRegisterInfo.iStatus != 21))
      {
        this.c.stopPCActivePolling("regPush");
        MsfService.core.pushManager.m();
      }
    }
    else if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("recv other processName:");
      paramToServiceMsg.append(str);
      paramToServiceMsg.append(" recv regPush ");
      QLog.e("MSF.C.PushManager", 2, paramToServiceMsg.toString());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.j.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(String paramString, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recv processName:");
      ((StringBuilder)localObject).append(com.tencent.mobileqq.msf.service.u.b(paramToServiceMsg));
      ((StringBuilder)localObject).append(" recv proxyUnRegister ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("MSF.C.PushManager", 1, ((StringBuilder)localObject).toString());
      this.i.remove(paramString);
      localObject = o.a(paramToServiceMsg);
      ((FromServiceMsg)localObject).setMsgSuccess();
      this.c.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject);
      paramToServiceMsg = MsfStore.getNativeConfigStore();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app_push_info_");
      ((StringBuilder)localObject).append(paramString);
      paramToServiceMsg.removeConfig(((StringBuilder)localObject).toString());
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   6: ifnull +41 -> 47
    //   9: aload_0
    //   10: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   13: invokevirtual 1535	android/media/MediaPlayer:isPlaying	()Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   28: invokevirtual 1538	android/media/MediaPlayer:release	()V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   36: goto +11 -> 47
    //   39: astore_1
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   45: aload_1
    //   46: athrow
    //   47: aload_0
    //   48: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   51: ifnonnull +14 -> 65
    //   54: aload_0
    //   55: new 544	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   58: dup
    //   59: invokespecial 545	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   62: putfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   65: aload_0
    //   66: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   69: invokevirtual 1964	android/media/MediaPlayer:reset	()V
    //   72: aload_0
    //   73: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   76: new 1966	java/io/FileInputStream
    //   79: dup
    //   80: aload_1
    //   81: invokespecial 1967	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   84: invokevirtual 1970	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   87: invokevirtual 1973	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   90: aload_0
    //   91: aload_0
    //   92: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   95: invokespecial 548	com/tencent/mobileqq/msf/core/push/g:a	(Landroid/media/MediaPlayer;)V
    //   98: aload_0
    //   99: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   102: invokevirtual 573	android/media/MediaPlayer:prepare	()V
    //   105: aload_0
    //   106: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   109: new 1975	com/tencent/mobileqq/msf/core/push/j
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 1976	com/tencent/mobileqq/msf/core/push/j:<init>	(Lcom/tencent/mobileqq/msf/core/push/g;)V
    //   117: invokevirtual 1555	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   120: aload_0
    //   121: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   124: invokevirtual 1556	android/media/MediaPlayer:start	()V
    //   127: aload_0
    //   128: getfield 1532	com/tencent/mobileqq/msf/core/push/g:aa	Landroid/media/MediaPlayer;
    //   131: iload_2
    //   132: invokevirtual 1559	android/media/MediaPlayer:setLooping	(Z)V
    //   135: goto +12 -> 147
    //   138: astore_1
    //   139: goto +11 -> 150
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 775	java/lang/Exception:printStackTrace	()V
    //   147: aload_0
    //   148: monitorexit
    //   149: return
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    //   154: astore 4
    //   156: goto -125 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	g
    //   0	159	1	paramString	String
    //   0	159	2	paramBoolean	boolean
    //   16	2	3	bool	boolean
    //   154	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   24	31	39	finally
    //   2	17	138	finally
    //   31	36	138	finally
    //   40	47	138	finally
    //   47	65	138	finally
    //   65	135	138	finally
    //   143	147	138	finally
    //   2	17	142	java/lang/Exception
    //   31	36	142	java/lang/Exception
    //   40	47	142	java/lang/Exception
    //   47	65	142	java/lang/Exception
    //   65	135	142	java/lang/Exception
    //   24	31	154	java/lang/Exception
  }
  
  public void a(boolean paramBoolean)
  {
    String[] arrayOfString = MsfStore.getNativeConfigStore().getConfigList("app_push_info_");
    int i3 = 1;
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      QLog.d("MSF.C.PushManager", 1, "loadAppPushInfo null");
    }
    Object localObject1;
    if ((true == paramBoolean) && (arrayOfString == null) && (av < au.length))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loop to loadAppPushInfo with time ");
      ((StringBuilder)localObject1).append(au[av]);
      ((StringBuilder)localObject1).append(" seconds");
      QLog.d("MSF.C.PushManager", 1, ((StringBuilder)localObject1).toString());
      localObject1 = this.az.obtainMessage();
      ((Message)localObject1).what = 1;
      ((Message)localObject1).obj = Boolean.valueOf(paramBoolean);
      this.az.sendMessageDelayed((Message)localObject1, au[av] * 1000);
      av += 1;
    }
    else if (this.c.getStatReporter() != null)
    {
      localObject1 = this.c.getStatReporter();
      boolean bool;
      if (arrayOfString == null) {
        bool = false;
      } else {
        bool = true;
      }
      long l1 = av;
      if (true == paramBoolean) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      ((j)localObject1).a("dim.Msf.LoadPushTimes", bool, l1, i1, null, false, false);
    }
    int i4 = com.tencent.mobileqq.msf.core.c.e(BaseApplication.getContext());
    int i5 = arrayOfString.length;
    int i2 = 0;
    int i1 = i3;
    while (i2 < i5)
    {
      Object localObject2 = HexUtil.hexStr2Bytes(arrayOfString[i2]);
      localObject1 = new a();
      ((a)localObject1).readFrom(new JceInputStream((byte[])localObject2));
      localObject2 = BaseApplication.getContext().getPackageName();
      StringBuilder localStringBuilder;
      if (!a(((a)localObject1).b, (String)localObject2))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("filter other push process. processName:");
        ((StringBuilder)localObject2).append(((a)localObject1).b);
        QLog.e("MSF.C.PushManager", i1, ((StringBuilder)localObject2).toString());
        localObject2 = MsfStore.getNativeConfigStore();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("app_push_info_");
        localStringBuilder.append(((a)localObject1).b);
        ((NativeConfigStore)localObject2).removeConfig(localStringBuilder.toString());
      }
      else
      {
        this.i.put(((a)localObject1).b, localObject1);
        if ((((a)localObject1).k != null) && (((a)localObject1).c > 0L))
        {
          if (i4 == -1)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("nVersionCode:");
            ((StringBuilder)localObject2).append(i4);
            ((StringBuilder)localObject2).append(" sendMsgPushRegister now");
            QLog.d("MSF.C.PushManager", i1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = String.valueOf(i4);
            if (((a)localObject1).n != null)
            {
              if (((a)localObject1).n.equals(localObject2))
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("info.installVersion :");
                localStringBuilder.append(((a)localObject1).n);
                localStringBuilder.append(" strVersionCode:");
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append(" sendMsgPushRegister now");
                QLog.d("MSF.C.PushManager", 1, localStringBuilder.toString());
              }
              else if (paramBoolean)
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("info.installVersion :");
                localStringBuilder.append(((a)localObject1).n);
                localStringBuilder.append(" bBoot:");
                localStringBuilder.append(paramBoolean);
                localStringBuilder.append(" strVersionCode:");
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append(" sendMsgPushRegister now");
                QLog.d("MSF.C.PushManager", 1, localStringBuilder.toString());
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("info.installVersion :");
                localStringBuilder.append(((a)localObject1).n);
                localStringBuilder.append(" strVersionCode:");
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append(" no need sendMsgPushRegister");
                QLog.d("MSF.C.PushManager", 1, localStringBuilder.toString());
                break label876;
              }
            }
            else
            {
              if (!paramBoolean) {
                break label811;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("info.installVersion :");
              ((StringBuilder)localObject2).append(((a)localObject1).n);
              ((StringBuilder)localObject2).append(" bBoot:");
              ((StringBuilder)localObject2).append(paramBoolean);
              ((StringBuilder)localObject2).append(" sendMsgPushRegister now");
              QLog.d("MSF.C.PushManager", 1, ((StringBuilder)localObject2).toString());
            }
            i1 = 1;
            break label878;
            label811:
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("info.installVersion :");
            ((StringBuilder)localObject2).append(((a)localObject1).n);
            ((StringBuilder)localObject2).append(" bBoot:");
            ((StringBuilder)localObject2).append(paramBoolean);
            ((StringBuilder)localObject2).append(" no need sendMsgPushRegister");
            QLog.d("MSF.C.PushManager", 1, ((StringBuilder)localObject2).toString());
            label876:
            i1 = 0;
          }
          label878:
          if (i1 != 0)
          {
            if (((a)localObject1).k != null) {
              this.c.getAccountCenter().c(((a)localObject1).k.uin, "autoRegPush");
            }
            this.j.a((a)localObject1, null, false, RegPushReason.msfBoot);
          }
          else
          {
            ((a)localObject1).c = 0L;
          }
          if (!t)
          {
            i1 = 1;
            t = true;
            u = ((a)localObject1).k.uin;
          }
          else
          {
            i1 = 1;
          }
        }
      }
      i2 += 1;
    }
  }
  
  public boolean a(a parama, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = parama.m;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (localObject != null)
    {
      bool2 = bool3;
      if (parama.m.uin.equals(paramFromServiceMsg.getUin()))
      {
        localObject = parama.m.cmds.iterator();
        for (;;)
        {
          bool2 = bool1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          if (((String)((Iterator)localObject).next()).equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (!paramFromServiceMsg.getServiceCmd().startsWith("ConfigPushSvc")) {
              paramFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
            }
            MsfSdkUtils.addFromMsgProcessName(parama.b, paramFromServiceMsg);
            paramFromServiceMsg.setMsfCommand(MsfCommand.onRecvPushMsg);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("handleCmdPush ");
              localStringBuilder.append(parama.b);
              localStringBuilder.append(" ");
              localStringBuilder.append(paramFromServiceMsg.getShortStringForLog());
              QLog.d("MSF.C.PushManager", 2, localStringBuilder.toString());
            }
            this.c.addRespToQuque(parama.b, null, paramFromServiceMsg);
            bool1 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public int b(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 1;
    }
    paramString = paramContext.getSharedPreferences(paramString, 4).getString(this.ar, String.valueOf(1));
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 1;
  }
  
  public long b(String paramString)
  {
    Iterator localIterator = this.i.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.i.get(localObject);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).k.uin.equals(paramString)))
      {
        if (((a)localObject).c == 0L) {
          return -2L;
        }
        return ((a)localObject).k.extStatus;
      }
    }
    return -1L;
  }
  
  public void b(long paramLong)
  {
    if ((paramLong > 30000L) && (paramLong < 3600000L)) {
      this.D = paramLong;
    }
  }
  
  public void b(CommandCallbackerInfo paramCommandCallbackerInfo, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      String str = com.tencent.mobileqq.msf.service.u.b(paramToServiceMsg);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("recv processName:");
        localStringBuilder.append(str);
        localStringBuilder.append(" recv unRegisterCmdCall ");
        QLog.d("MSF.C.PushManager", 2, localStringBuilder.toString());
      }
      if (!this.i.containsKey(str)) {
        this.i.putIfAbsent(str, new a(str));
      }
      ((a)this.i.get(str)).m = paramCommandCallbackerInfo;
      paramCommandCallbackerInfo = com.tencent.mobileqq.msf.service.u.a(paramToServiceMsg);
      paramCommandCallbackerInfo.setMsgSuccess();
      this.c.addRespToQuque(paramToServiceMsg, paramCommandCallbackerInfo);
      f(str);
      return;
    }
    finally {}
  }
  
  public void b(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded getted");
    }
    long l2 = 0L;
    try
    {
      localObject1 = new offlinepush.PbPushOffReadedNotify();
      Object localObject2 = paramFromServiceMsg.getWupBuffer();
      Object localObject3 = new byte[localObject2.length - 4];
      System.arraycopy(localObject2, 4, localObject3, 0, localObject2.length - 4);
      ((offlinepush.PbPushOffReadedNotify)localObject1).mergeFrom((byte[])localObject3);
      int i1 = ((offlinepush.PbPushOffReadedNotify)localObject1).cNotifyType.get();
      long l1 = l2;
      Object localObject4;
      g.a locala;
      if ((i1 & 0x1) != 0)
      {
        localObject2 = new ArrayList();
        localObject3 = ((offlinepush.PbPushOffReadedNotify)localObject1).vC2CReadedNotify.get().iterator();
        l1 = l2;
        while (((Iterator)localObject3).hasNext())
        {
          l2 = ((offlinepush.C2CMsgReadedNotify)((Iterator)localObject3).next()).lPeerUin.get();
          if (QLog.isDevelopLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("onRecvPushReaded C2C uin:");
            ((StringBuilder)localObject4).append(l2);
            QLog.d("MSF.C.PushManager", 4, ((StringBuilder)localObject4).toString());
          }
          localObject4 = this.L.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            locala = (g.a)((Iterator)localObject4).next();
            l1 = locala.a.to_uin.get();
            if (locala.a.from_uin.get() == l2) {
              ((List)localObject2).add(locala);
            }
          }
        }
        if (QLog.isDevelopLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onRecvPushReaded remove");
          ((StringBuilder)localObject3).append(((List)localObject2).size());
          ((StringBuilder)localObject3).append(" message");
          QLog.d("MSF.C.PushManager", 4, ((StringBuilder)localObject3).toString());
        }
        this.L.removeAll((Collection)localObject2);
      }
      l2 = l1;
      if ((i1 & 0x4) != 0)
      {
        localObject2 = new ArrayList();
        localObject3 = ((offlinepush.PbPushOffReadedNotify)localObject1).vDisReadedNotify.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          l2 = ((offlinepush.DisMsgReadedNotify)((Iterator)localObject3).next()).lDisUin.get();
          if (QLog.isDevelopLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("onRecvPushReaded Discuss uin:");
            ((StringBuilder)localObject4).append(l2);
            QLog.d("MSF.C.PushManager", 4, ((StringBuilder)localObject4).toString());
          }
          localObject4 = this.L.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            locala = (g.a)((Iterator)localObject4).next();
            l1 = locala.a.to_uin.get();
            if (locala.a.discuss_info.discuss_uin.get() == l2) {
              ((List)localObject2).add(locala);
            }
          }
        }
        if (QLog.isDevelopLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onRecvPushReaded remove");
          ((StringBuilder)localObject3).append(((List)localObject2).size());
          ((StringBuilder)localObject3).append(" message");
          QLog.d("MSF.C.PushManager", 4, ((StringBuilder)localObject3).toString());
        }
        this.L.removeAll((Collection)localObject2);
        l2 = l1;
      }
      i1 = BaseApplication.getContext().getSharedPreferences("unreadcount", 4).getInt("unread", -1);
      int i2 = this.L.size();
      BadgeUtilImpl.setBadge(BaseApplication.getContext(), i1 + i2);
      c(true);
      a(l2, paramFromServiceMsg.getRequestSsoSeq(), ((offlinepush.PbPushOffReadedNotify)localObject1).svr_ip.get());
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onRecvPushReaded decode error:");
        ((StringBuilder)localObject1).append(paramFromServiceMsg);
        QLog.d("MSF.C.PushManager", 2, ((StringBuilder)localObject1).toString(), paramFromServiceMsg);
      }
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.j.b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean b()
  {
    Iterator localIterator = this.i.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.i.get(localObject);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).c != 0L)) {
        return true;
      }
    }
    return false;
  }
  
  public int c(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 1;
    }
    paramString = paramContext.getSharedPreferences(paramString, 4).getString(this.as, String.valueOf(1));
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 1;
  }
  
  public void c()
  {
    synchronized (this.z)
    {
      this.z.notify();
      return;
    }
  }
  
  public void c(long paramLong)
  {
    Object localObject = this.c;
    if ((localObject != null) && (((MsfCore)localObject).sender != null) && (this.c.sender.b.b()))
    {
      this.aC = paramLong;
      return;
    }
    localObject = this.c;
    if ((localObject != null) && (((MsfCore)localObject).sender != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("not need to update lastRecvTimeForSG, isConned:");
      ((StringBuilder)localObject).append(this.c.sender.b.b());
      QLog.i("MSF.C.PushManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg getted");
    }
    if (MsfService.getCore().getUinPushStatus(paramFromServiceMsg.getUin()) != 95)
    {
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRecvPbPushOffMsg client status:");
        ((StringBuilder)localObject).append(MsfService.getCore().getUinPushStatus(paramFromServiceMsg.getUin()));
        ((StringBuilder)localObject).append(" drop now");
        QLog.d("MSF.C.PushManager", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (com.tencent.mobileqq.msf.service.e.a())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg mobileqq is running drop now");
      }
      return;
    }
    Object localObject = this.L.iterator();
    int i1;
    while (((Iterator)localObject).hasNext())
    {
      i1 = ((g.a)((Iterator)localObject).next()).b;
      if (paramFromServiceMsg.getRequestSsoSeq() == i1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get duplicate msg drop now.");
        }
        return;
      }
    }
    localObject = this.M.iterator();
    while (((Iterator)localObject).hasNext())
    {
      i1 = ((g.a)((Iterator)localObject).next()).b;
      if (paramFromServiceMsg.getRequestSsoSeq() == i1)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("onRecvPbPushOffMsg get duplicate av msg drop now ssoseq:");
          paramFromServiceMsg.append(i1);
          QLog.d("MSF.C.PushManager", 2, paramFromServiceMsg.toString());
        }
        return;
      }
    }
    localObject = new g.a(this);
    try
    {
      offlinepush.PbPushOffMsg localPbPushOffMsg = new offlinepush.PbPushOffMsg();
      byte[] arrayOfByte1 = paramFromServiceMsg.getWupBuffer();
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 4];
      System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 0, arrayOfByte1.length - 4);
      localPbPushOffMsg.mergeFrom(arrayOfByte2);
      ((g.a)localObject).a = localPbPushOffMsg;
      ((g.a)localObject).b = paramFromServiceMsg.getRequestSsoSeq();
      if (c(localPbPushOffMsg))
      {
        this.M.add(localObject);
        x();
      }
      else if (localPbPushOffMsg.msg_type.get() == 528)
      {
        a(localPbPushOffMsg);
      }
      else
      {
        this.L.add(localObject);
        c(false);
      }
      a(localPbPushOffMsg.to_uin.get(), paramFromServiceMsg.getRequestSsoSeq(), localPbPushOffMsg.svr_ip.get());
      i1 = BaseApplication.getContext().getSharedPreferences("unreadcount", 4).getInt("unread", -5);
      int i2 = this.L.size();
      int i3 = this.M.size();
      BadgeUtilImpl.setBadge(BaseApplication.getContext(), i1 + (i2 + i3));
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRecvPbPushOffMsg decode error:");
        ((StringBuilder)localObject).append(paramFromServiceMsg);
        QLog.d("MSF.C.PushManager", 2, ((StringBuilder)localObject).toString(), paramFromServiceMsg);
      }
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      String str = BaseApplication.getContext().getPackageName();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recv processName:");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" recv KickedMsg ");
        QLog.d("MSF.C.PushManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (a)this.i.get(str);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).k.uin.equals(paramString)))
      {
        ((a)localObject).c = 0L;
        ((a)localObject).k = null;
        f(str);
      }
      if (this.c.getAccountCenter().i().equals(paramString))
      {
        this.c.getAccountCenter().c("0", "onKicked");
        this.c.stopPCActivePolling("onKicked");
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    v = false;
    f();
  }
  
  public void d(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRecvSsoHelloPush from:");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      QLog.d("MSF.C.PushManager", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new ToServiceMsg("", paramFromServiceMsg.getUin(), "SSO.HelloPush");
      ((ToServiceMsg)localObject).putWupBuffer(paramFromServiceMsg.getWupBuffer());
      ((ToServiceMsg)localObject).setAppId(this.c.getMsfAppid());
      ((ToServiceMsg)localObject).setNeedCallback(false);
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
      this.at = ((ToServiceMsg)localObject);
      try
      {
        this.c.sendSsoMsg((ToServiceMsg)localObject);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send sso hello push resp error ");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      QLog.i("MSF.C.PushManager", 2, ((StringBuilder)localObject).toString(), paramFromServiceMsg);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRecvSsoHelloPush error ");
        ((StringBuilder)localObject).append(paramFromServiceMsg);
        QLog.i("MSF.C.PushManager", 2, ((StringBuilder)localObject).toString(), paramFromServiceMsg);
      }
    }
  }
  
  public void d(String paramString)
  {
    QLog.d("PCActivePush", 1, "onPCActive");
    if (this.X == null) {
      this.X = QQNotificationManager.getInstance();
    }
    this.X.cancel("MSF.C.PushManager", 478);
    this.L.clear();
    this.aF.set(true);
    BaseApplication.getContext().registerReceiver(this.aJ, new IntentFilter("com.tencent.mobileqq.broadcast.pcactiveQQ"));
    this.aH = 0;
    this.aG = paramString;
    a(paramString, 0);
  }
  
  public long e()
  {
    long l2 = this.D;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 300000L;
    }
    return l1;
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MSF onNotificationQQWiFi=");
      localStringBuilder.append(paramString);
      QLog.i("MSF.C.PushManager", 2, localStringBuilder.toString());
    }
    BaseApplication.getContext().startActivity(new Intent(paramString));
  }
  
  void f()
  {
    Iterator localIterator = this.i.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.i.get(localObject);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).c != 0L))
      {
        try
        {
          long l1 = System.currentTimeMillis();
          if ((((a)localObject).f != 0L) && (l1 - ((a)localObject).f > 25200000L))
          {
            a((a)localObject, RegPushReason.msfHeartTimeTooLong);
            continue;
          }
          if ((v) && (((a)localObject).i != null) && (this.c.nowSocketConnAdd != null) && (((a)localObject).i.equals(this.c.nowSocketConnAdd)))
          {
            this.j.a((a)localObject, false);
            continue;
          }
          if (this.c.nowSocketConnAdd == null)
          {
            localObject = MsfMsgUtil.getConnOpenMsg("");
            MsfSdkUtils.addToMsgProcessName("", (ToServiceMsg)localObject);
            this.c.sendSsoMsg((ToServiceMsg)localObject);
            a(e());
            continue;
          }
          a((a)localObject, RegPushReason.msfByNetChange);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel()) {
          QLog.w("MSF.C.PushManager", 2, localException.toString(), localException);
        }
      }
    }
  }
  
  public long g()
  {
    return this.aB;
  }
  
  public long h()
  {
    return this.aC;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onNotificationClearAll");
    }
    this.L.clear();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onNotificationClearAllAV");
    }
    this.M.clear();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "clearOfflinePushNotification");
    }
    ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(478);
    this.L.clear();
    this.N = false;
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "clearOfflinePushNotificationAV");
    }
    if (this.X == null) {
      this.X = QQNotificationManager.getInstance();
    }
    this.X.cancel("MSF.C.PushManager", 479);
    this.M.clear();
    this.O = false;
  }
  
  public void m()
  {
    if (this.aF.get())
    {
      QLog.d("PCActivePush", 1, "stop tryActiveQQ by regPush");
      try
      {
        BaseApplication.getContext().unregisterReceiver(this.aJ);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      Object localObject = new HashMap();
      ((HashMap)localObject).put("account", this.aG);
      ((HashMap)localObject).put("retryIndex", String.valueOf(this.aH));
      ((HashMap)localObject).put("reason", "regpush");
      if (this.c.getStatReporter() != null) {
        this.c.getStatReporter().a("dim.Msf.PCActiveQQResult", true, 0L, 0L, (Map)localObject, false, false);
      }
      localObject = this.aI;
      if (localObject != null)
      {
        AlarmManager localAlarmManager = this.m;
        if (localAlarmManager != null) {
          try
          {
            localAlarmManager.cancel((PendingIntent)localObject);
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      this.aF.set(false);
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onNotificationBroadcast");
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (this.X == null) {
      this.X = QQNotificationManager.getInstance();
    }
    this.X.cancel("MSF.C.PushManager", 478);
    this.L.clear();
    try
    {
      boolean bool = b();
      if (bool)
      {
        localObject = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
        ((Intent)localObject).addFlags(268435456);
        localBaseApplication.startActivity((Intent)localObject);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "uin kicked out");
      }
      localObject = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
      ((Intent)localObject).addFlags(268435456);
      localBaseApplication.startActivity((Intent)localObject);
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Start QQ failed");
        ((StringBuilder)localObject).append(localException);
        QLog.d("MSF.C.PushManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onAVNotificationBroadcast");
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (this.X == null) {
      this.X = QQNotificationManager.getInstance();
    }
    this.X.cancel("MSF.C.PushManager", 479);
    this.M.clear();
    try
    {
      localObject = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
      ((Intent)localObject).addFlags(268435456);
      localBaseApplication.startActivity((Intent)localObject);
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Start QQ failed");
        ((StringBuilder)localObject).append(localException);
        QLog.d("MSF.C.PushManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("MSF_Alive_Log alarm receive ");
      ((StringBuilder)???).append(paramIntent);
      QLog.d("MSF.C.PushManager", 2, ((StringBuilder)???).toString());
    }
    if (this.p > 0L)
    {
      long l1 = System.currentTimeMillis() - this.p;
      if ((l1 > 0L) && (this.c.statReporter.Y != null)) {
        this.c.statReporter.Y.d = l1;
      }
      this.p = 0L;
    }
    synchronized (this.z)
    {
      this.z.notify();
      if (this.aA) {
        com.tencent.mobileqq.msf.core.u.a().e();
      }
      if (QLog.isColorLevel()) {
        this.c.netFlowStore.a(paramContext, paramIntent);
      } else if (this.aA) {
        this.c.netFlowStore.a(paramContext, paramIntent);
      }
      this.aA ^= true;
      if (this.c.getStandyModeManager() != null) {
        this.c.getStandyModeManager().a();
      }
      com.tencent.qphone.base.util.log.a.b.b();
      s();
      return;
    }
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "clearDevlockQuickloginNotification");
    }
    if (this.X == null) {
      this.X = QQNotificationManager.getInstance();
    }
    this.X.cancel("MSF.C.PushManager", 480);
  }
  
  public c q()
  {
    return this.ay;
  }
  
  public int r()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.g
 * JD-Core Version:    0.7.0.1
 */