package com.tencent.mobileqq.qrscan;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PCMRecorder;
import com.tencent.chirp.PCMRecorder.OnQQRecorderListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.chirp.IChirpSoDownload.Callback;
import com.tencent.mobileqq.qrscan.earlydown.ChirpSoHandler;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class VoiceScan
  implements Handler.Callback, PCMRecorder.OnQQRecorderListener, IChirpSoDownload.Callback
{
  private static final String g = HardCodeUtil.a(2131914193);
  private static final String h = HardCodeUtil.a(2131914192);
  private Context a;
  private AppInterface b;
  private boolean c = false;
  private Handler d;
  private PCMRecorder e;
  private ChirpWrapper f;
  private boolean i = false;
  private Dialog j;
  private ChirpSoHandler k;
  private Handler l;
  private boolean m = false;
  private boolean n = false;
  
  public VoiceScan(Context paramContext, AppInterface paramAppInterface)
  {
    this.a = paramContext;
    this.b = paramAppInterface;
    this.l = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.d = new Handler(this);
  }
  
  private static void a(byte[] paramArrayOfByte, short[] paramArrayOfShort)
  {
    int i1 = 0;
    while (i1 < paramArrayOfShort.length)
    {
      int i2 = i1 * 2;
      int i3 = paramArrayOfByte[i2];
      paramArrayOfShort[i1] = ((short)(paramArrayOfByte[(i2 + 1)] << 8 & 0xFF00 | i3 & 0xFF));
      i1 += 1;
    }
  }
  
  private boolean d()
  {
    if (this.b == null) {
      return false;
    }
    ((IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class)).setTalkbackSwitch();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkVoiceScanEnable enableTalkBack = ");
      localStringBuilder.append(AppSetting.e);
      QLog.d("IQRScanConst_VoiceScan", 2, localStringBuilder.toString());
    }
    return AppSetting.e;
  }
  
  private void e()
  {
    boolean bool = ChirpWrapper.a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSoLoaded ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("IQRScanConst_VoiceScan", 2, ((StringBuilder)localObject).toString());
    }
    if (!bool)
    {
      if (this.k == null) {
        this.k = ((ChirpSoHandler)((IEarlyDownloadService)this.b.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler("qq.android.system.chirp"));
      }
      localObject = this.k;
      if (localObject != null)
      {
        ((ChirpSoHandler)localObject).a(this);
        this.k.a(true);
      }
      return;
    }
    if (AudioUtil.b(1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkInitVoiceScan, permission is forbidden, ");
        ((StringBuilder)localObject).append(this.i);
        QLog.d("IQRScanConst_VoiceScan", 2, ((StringBuilder)localObject).toString());
      }
      if (!this.i) {
        ThreadManager.getUIHandler().post(new VoiceScan.1(this));
      }
      return;
    }
    if (((IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class)).isVideoChatting(this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IQRScanConst_VoiceScan", 2, "isVedioChatting");
      }
      return;
    }
    Object localObject = this.a.getSharedPreferences("qrcode", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_first_enter_voice_qrcode");
    localStringBuilder.append(this.b.getCurrentAccountUin());
    bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkInitVoiceScan, isFirst = ");
      localStringBuilder.append(bool);
      QLog.d("IQRScanConst_VoiceScan", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_first_enter_voice_qrcode");
      localStringBuilder.append(this.b.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false).commit();
      localObject = this.l;
      if (localObject != null) {
        ((Handler)localObject).sendEmptyMessageDelayed(295, 2000L);
      }
    }
    if (this.f == null)
    {
      this.f = new ChirpWrapper();
      int i1 = this.f.b();
      if (i1 != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("decode chirp init failed = ");
          ((StringBuilder)localObject).append(i1);
          QLog.d("IQRScanConst_VoiceScan", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      this.e = new PCMRecorder(this.a, 44100, this);
      this.e.a();
    }
  }
  
  private void f()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((PCMRecorder)localObject).b();
      this.e = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((ChirpWrapper)localObject).c();
      this.f = null;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_VoiceScan", 2, "onScannerResume");
    }
    this.c = true;
    if (this.m)
    {
      Process.setThreadPriority(-19);
      this.l.sendEmptyMessage(293);
      return;
    }
    if (!this.n) {
      this.l.sendEmptyMessage(292);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("record error = ");
      localStringBuilder.append(paramInt);
      QLog.d("IQRScanConst_VoiceScan", 2, localStringBuilder.toString());
    }
    f();
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 232	com/tencent/mobileqq/qrscan/VoiceScan:f	Lcom/tencent/chirp/ChirpWrapper;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: arraylength
    //   10: iconst_2
    //   11: idiv
    //   12: newarray short
    //   14: astore_3
    //   15: aload_1
    //   16: aload_3
    //   17: invokestatic 274	com/tencent/mobileqq/qrscan/VoiceScan:a	([B[S)V
    //   20: aload_0
    //   21: getfield 232	com/tencent/mobileqq/qrscan/VoiceScan:f	Lcom/tencent/chirp/ChirpWrapper;
    //   24: aload_3
    //   25: bipush 15
    //   27: invokevirtual 277	com/tencent/chirp/ChirpWrapper:a	([SI)Ljava/lang/String;
    //   30: astore_1
    //   31: aload_1
    //   32: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +353 -> 388
    //   38: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +35 -> 76
    //   44: new 107	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   51: astore_3
    //   52: aload_3
    //   53: ldc_w 285
    //   56: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_3
    //   61: aload_1
    //   62: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 123
    //   68: iconst_2
    //   69: aload_3
    //   70: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_1
    //   77: ldc_w 287
    //   80: invokevirtual 293	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   83: ifeq +289 -> 372
    //   86: iconst_0
    //   87: istore_2
    //   88: iload_2
    //   89: aload_1
    //   90: invokevirtual 296	java/lang/String:length	()I
    //   93: if_icmpge +20 -> 113
    //   96: aload_1
    //   97: iload_2
    //   98: invokevirtual 300	java/lang/String:charAt	(I)C
    //   101: bipush 48
    //   103: if_icmpne +10 -> 113
    //   106: iload_2
    //   107: iconst_1
    //   108: iadd
    //   109: istore_2
    //   110: goto -22 -> 88
    //   113: aload_1
    //   114: iload_2
    //   115: invokevirtual 303	java/lang/String:substring	(I)Ljava/lang/String;
    //   118: astore_1
    //   119: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +35 -> 157
    //   125: new 107	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   132: astore_3
    //   133: aload_3
    //   134: ldc_w 305
    //   137: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_3
    //   142: aload_1
    //   143: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 123
    //   149: iconst_2
    //   150: aload_3
    //   151: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_1
    //   158: invokestatic 311	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   161: pop2
    //   162: ldc 91
    //   164: invokestatic 97	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   167: checkcast 91	com/tencent/mobileqq/qrscan/api/IQRScanAbilityApi
    //   170: ldc_w 312
    //   173: invokestatic 41	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   176: invokeinterface 316 2 0
    //   181: ldc2_w 317
    //   184: invokestatic 324	java/lang/Thread:sleep	(J)V
    //   187: aload_1
    //   188: ifnull +112 -> 300
    //   191: ldc 142
    //   193: aload_1
    //   194: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   197: ifne +103 -> 300
    //   200: aload_0
    //   201: getfield 63	com/tencent/mobileqq/qrscan/VoiceScan:b	Lcom/tencent/common/app/AppInterface;
    //   204: invokevirtual 203	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   207: aload_1
    //   208: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifeq +6 -> 217
    //   214: goto +86 -> 300
    //   217: aload_0
    //   218: getfield 63	com/tencent/mobileqq/qrscan/VoiceScan:b	Lcom/tencent/common/app/AppInterface;
    //   221: ldc_w 330
    //   224: ldc 142
    //   226: invokevirtual 148	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   229: checkcast 330	com/tencent/mobileqq/friend/api/IFriendDataService
    //   232: aload_1
    //   233: iconst_1
    //   234: iconst_1
    //   235: invokeinterface 334 4 0
    //   240: astore_3
    //   241: aload_3
    //   242: ifnull +39 -> 281
    //   245: aload_3
    //   246: invokevirtual 339	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   249: ifeq +32 -> 281
    //   252: new 341	com/tencent/mobileqq/profilecard/data/AllInOne
    //   255: dup
    //   256: aload_1
    //   257: iconst_1
    //   258: invokespecial 344	com/tencent/mobileqq/profilecard/data/AllInOne:<init>	(Ljava/lang/String;I)V
    //   261: astore_1
    //   262: aload_1
    //   263: aload_3
    //   264: getfield 347	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   267: putfield 350	com/tencent/mobileqq/profilecard/data/AllInOne:nickname	Ljava/lang/String;
    //   270: aload_1
    //   271: aload_3
    //   272: getfield 353	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   275: putfield 354	com/tencent/mobileqq/profilecard/data/AllInOne:remark	Ljava/lang/String;
    //   278: goto +38 -> 316
    //   281: new 341	com/tencent/mobileqq/profilecard/data/AllInOne
    //   284: dup
    //   285: aload_1
    //   286: iconst_3
    //   287: invokespecial 344	com/tencent/mobileqq/profilecard/data/AllInOne:<init>	(Ljava/lang/String;I)V
    //   290: astore_1
    //   291: aload_1
    //   292: bipush 12
    //   294: putfield 358	com/tencent/mobileqq/profilecard/data/AllInOne:subSourceId	I
    //   297: goto +19 -> 316
    //   300: new 341	com/tencent/mobileqq/profilecard/data/AllInOne
    //   303: dup
    //   304: aload_0
    //   305: getfield 63	com/tencent/mobileqq/qrscan/VoiceScan:b	Lcom/tencent/common/app/AppInterface;
    //   308: invokevirtual 203	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   311: iconst_0
    //   312: invokespecial 344	com/tencent/mobileqq/profilecard/data/AllInOne:<init>	(Ljava/lang/String;I)V
    //   315: astore_1
    //   316: aload_0
    //   317: getfield 61	com/tencent/mobileqq/qrscan/VoiceScan:a	Landroid/content/Context;
    //   320: aload_1
    //   321: invokestatic 364	com/tencent/mobileqq/profilecard/utils/ProfileUtils:openProfileCard	(Landroid/content/Context;Lcom/tencent/mobileqq/profilecard/data/AllInOne;)V
    //   324: aload_0
    //   325: getfield 63	com/tencent/mobileqq/qrscan/VoiceScan:b	Lcom/tencent/common/app/AppInterface;
    //   328: ldc_w 366
    //   331: ldc 142
    //   333: ldc 142
    //   335: ldc_w 368
    //   338: ldc_w 368
    //   341: iconst_0
    //   342: iconst_0
    //   343: ldc 142
    //   345: ldc 142
    //   347: ldc 142
    //   349: ldc 142
    //   351: invokestatic 373	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   354: return
    //   355: astore_1
    //   356: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +29 -> 388
    //   362: ldc 123
    //   364: iconst_2
    //   365: ldc 142
    //   367: aload_1
    //   368: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   371: return
    //   372: ldc 91
    //   374: invokestatic 97	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   377: checkcast 91	com/tencent/mobileqq/qrscan/api/IQRScanAbilityApi
    //   380: getstatic 46	com/tencent/mobileqq/qrscan/VoiceScan:h	Ljava/lang/String;
    //   383: invokeinterface 316 2 0
    //   388: return
    //   389: astore_3
    //   390: goto -203 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	VoiceScan
    //   0	393	1	paramArrayOfByte	byte[]
    //   87	28	2	i1	int
    //   14	258	3	localObject	Object
    //   389	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   157	181	355	java/lang/Exception
    //   191	214	355	java/lang/Exception
    //   217	241	355	java/lang/Exception
    //   245	278	355	java/lang/Exception
    //   281	297	355	java/lang/Exception
    //   300	316	355	java/lang/Exception
    //   316	354	355	java/lang/Exception
    //   181	187	389	java/lang/Exception
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_VoiceScan", 2, "onScannerPause");
    }
    this.c = false;
    this.l.removeCallbacksAndMessages(null);
    this.d.removeCallbacksAndMessages(Integer.valueOf(291));
    if (this.m)
    {
      Process.setThreadPriority(0);
      f();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_VoiceScan", 2, "onDestroy");
    }
    this.c = false;
    Object localObject = this.d;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.d = null;
    }
    localObject = this.l;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.l = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((ChirpSoHandler)localObject).b(this);
      this.k = null;
    }
    localObject = this.j;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {}
    try
    {
      this.j.dismiss();
      this.j = null;
      label105:
      f();
      this.a = null;
      this.b = null;
      return;
    }
    catch (Exception localException)
    {
      break label105;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 294: 
    default: 
      return true;
    case 295: 
      ((IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class)).speak(g);
      return true;
    case 293: 
      e();
      return true;
    case 292: 
      this.m = d();
      this.n = true;
      if (this.m)
      {
        this.d.sendEmptyMessage(291);
        return true;
      }
      break;
    case 291: 
      if (this.l != null)
      {
        Process.setThreadPriority(-19);
        this.l.removeCallbacksAndMessages(null);
        this.l.sendEmptyMessage(293);
      }
      break;
    }
    return true;
  }
  
  public void o()
  {
    if (this.c)
    {
      Handler localHandler = this.l;
      if (localHandler != null) {
        localHandler.sendEmptyMessage(293);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.VoiceScan
 * JD-Core Version:    0.7.0.1
 */