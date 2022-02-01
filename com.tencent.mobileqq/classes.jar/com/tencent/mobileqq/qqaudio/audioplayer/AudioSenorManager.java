package com.tencent.mobileqq.qqaudio.audioplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class AudioSenorManager
  extends BroadcastReceiver
{
  public static int b = 1000;
  boolean a = true;
  AppRuntime c;
  float d;
  float e;
  float f;
  Runnable g = new AudioSenorManager.1(this);
  Runnable h = new AudioSenorManager.2(this);
  private AudioSenorManager.IAudioSenorListener i = null;
  private SensorManager j;
  private Sensor k;
  private Sensor l;
  private AudioSenorManager.AccelerationEventListener m;
  private AudioSenorManager.ProximityEventListener n;
  private float o;
  private float p = 0.6F;
  private float q = 0.02F;
  private volatile int r = 0;
  private List<String> s = new CopyOnWriteArrayList();
  private boolean t = false;
  
  public AudioSenorManager(AppRuntime paramAppRuntime)
  {
    this.c = paramAppRuntime;
    paramAppRuntime = paramAppRuntime.getApp();
    this.j = ((SensorManager)paramAppRuntime.getSystemService("sensor"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.audiosenormanager.audio.start");
    localIntentFilter.addAction("mqq.audiosenormanager.audio.end");
    paramAppRuntime.registerReceiver(this, localIntentFilter);
  }
  
  private float a(Sensor paramSensor)
  {
    String str = Build.MODEL;
    if ((!str.equals("ZTE U880s")) && (!str.equals("ZTE U807")))
    {
      if ((!str.equals("Coolpad 5890")) && (!str.equals("Coolpad 5891")) && (!str.equals("Coolpad 8720L")) && (!str.equals("Coolpad 5879")) && (!str.equals("Coolpad 5891Q")))
      {
        if ((!str.equals("HUAWEI Y320-T00")) && (!str.equals("Lenovo A658t")) && (!str.equals("Lenovo A788t")))
        {
          if (str.equals("ME860")) {
            return 99.0F;
          }
          if ((!str.equals("ZTE U930HD")) && (!str.equals("ZTE-T U960s")))
          {
            float f1 = 0.0F;
            if (paramSensor != null) {
              f1 = paramSensor.getMaximumRange();
            }
            return f1;
          }
          return 100.0F;
        }
        return 10.0F;
      }
      return 5.0F;
    }
    return 97.0F;
  }
  
  private void a(String paramString)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      if (!this.s.contains(paramString)) {
        this.s.add(paramString);
      }
      d();
      ThreadManager.removeJobFromThreadPool(this.h, 16);
      ThreadManager.excute(this.g, 16, null, false);
    }
  }
  
  public static boolean a()
  {
    return Build.MODEL.equals("ZTE U930");
  }
  
  private void b(String paramString)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      if (this.s.contains(paramString))
      {
        List localList = this.s;
        localList.remove(localList.indexOf(paramString));
      }
      if (this.s.size() == 0)
      {
        ThreadManager.removeJobFromThreadPool(this.g, 16);
        ThreadManager.excute(this.h, 16, null, false);
        if (this.r != 0)
        {
          this.r = 0;
          paramString = this.i;
          if (paramString != null) {
            paramString.onNearToEarStatusChanged(this.r);
          }
        }
      }
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: ldc 220
    //   2: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5: checkcast 220	com/tencent/mobileqq/dpc/api/IDPCApi
    //   8: getstatic 232	com/tencent/mobileqq/dpc/enumname/DPCNames:qq_audio_play	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   11: invokevirtual 236	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   14: aconst_null
    //   15: invokeinterface 240 3 0
    //   20: astore 7
    //   22: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +40 -> 65
    //   28: new 247	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   35: astore 8
    //   37: aload 8
    //   39: ldc 250
    //   41: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 8
    //   47: aload 7
    //   49: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc_w 256
    //   56: iconst_2
    //   57: aload 8
    //   59: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload 7
    //   67: invokestatic 267	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   70: ifne +160 -> 230
    //   73: aload 7
    //   75: invokevirtual 270	java/lang/String:length	()I
    //   78: iconst_1
    //   79: if_icmple +151 -> 230
    //   82: aload 7
    //   84: ldc_w 272
    //   87: invokevirtual 276	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   90: astore 7
    //   92: ldc_w 278
    //   95: aload 7
    //   97: iconst_0
    //   98: aaload
    //   99: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: istore 6
    //   104: iload 6
    //   106: ifne +9 -> 115
    //   109: iconst_1
    //   110: istore 4
    //   112: goto +6 -> 118
    //   115: iconst_0
    //   116: istore 4
    //   118: aload 7
    //   120: iconst_1
    //   121: aaload
    //   122: invokestatic 284	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   125: fstore_2
    //   126: iload 4
    //   128: istore 5
    //   130: fload_2
    //   131: fstore_1
    //   132: aload 7
    //   134: arraylength
    //   135: iconst_5
    //   136: if_icmplt +99 -> 235
    //   139: aload_0
    //   140: aload 7
    //   142: iconst_2
    //   143: aaload
    //   144: invokestatic 284	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   147: putfield 51	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:p	F
    //   150: aload_0
    //   151: aload 7
    //   153: iconst_3
    //   154: aaload
    //   155: invokestatic 284	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   158: putfield 54	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:q	F
    //   161: aload 7
    //   163: iconst_4
    //   164: aaload
    //   165: invokestatic 290	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   168: putstatic 292	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:b	I
    //   171: iload 4
    //   173: istore 5
    //   175: fload_2
    //   176: fstore_1
    //   177: goto +58 -> 235
    //   180: astore 7
    //   182: goto +15 -> 197
    //   185: astore 7
    //   187: goto +8 -> 195
    //   190: astore 7
    //   192: iconst_1
    //   193: istore 4
    //   195: fconst_0
    //   196: fstore_2
    //   197: iload 4
    //   199: istore 5
    //   201: fload_2
    //   202: fstore_1
    //   203: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +29 -> 235
    //   209: ldc_w 256
    //   212: iconst_2
    //   213: ldc_w 294
    //   216: aload 7
    //   218: invokestatic 297	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: iload 4
    //   223: istore 5
    //   225: fload_2
    //   226: fstore_1
    //   227: goto +8 -> 235
    //   230: iconst_1
    //   231: istore 5
    //   233: fconst_0
    //   234: fstore_1
    //   235: getstatic 292	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:b	I
    //   238: ifge +9 -> 247
    //   241: sipush 1000
    //   244: putstatic 292	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:b	I
    //   247: aload_0
    //   248: getfield 51	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:p	F
    //   251: fconst_0
    //   252: fcmpg
    //   253: ifgt +6 -> 259
    //   256: iconst_0
    //   257: istore 5
    //   259: ldc 220
    //   261: invokestatic 226	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   264: checkcast 220	com/tencent/mobileqq/dpc/api/IDPCApi
    //   267: getstatic 303	com/tencent/mobileqq/dpc/enumname/DPCAccountNames:qq_audio_play_fix	Lcom/tencent/mobileqq/dpc/enumname/DPCAccountNames;
    //   270: invokevirtual 304	com/tencent/mobileqq/dpc/enumname/DPCAccountNames:name	()Ljava/lang/String;
    //   273: aconst_null
    //   274: invokeinterface 240 3 0
    //   279: astore 7
    //   281: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq +41 -> 325
    //   287: new 247	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   294: astore 8
    //   296: aload 8
    //   298: ldc_w 306
    //   301: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 8
    //   307: aload 7
    //   309: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc_w 256
    //   316: iconst_2
    //   317: aload 8
    //   319: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: iload 5
    //   327: istore 4
    //   329: fload_1
    //   330: fstore_2
    //   331: aload 7
    //   333: invokestatic 267	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   336: ifne +112 -> 448
    //   339: iload 5
    //   341: istore 4
    //   343: fload_1
    //   344: fstore_2
    //   345: aload 7
    //   347: invokevirtual 270	java/lang/String:length	()I
    //   350: iconst_1
    //   351: if_icmple +97 -> 448
    //   354: fload_1
    //   355: fstore_3
    //   356: aload 7
    //   358: ldc_w 272
    //   361: invokevirtual 276	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   364: astore 7
    //   366: fload_1
    //   367: fstore_2
    //   368: fload_1
    //   369: fstore_3
    //   370: ldc_w 308
    //   373: aload 7
    //   375: iconst_4
    //   376: aaload
    //   377: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   380: ifne +13 -> 393
    //   383: fload_1
    //   384: fstore_3
    //   385: aload 7
    //   387: iconst_4
    //   388: aaload
    //   389: invokestatic 284	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   392: fstore_2
    //   393: fload_2
    //   394: fstore_3
    //   395: ldc_w 278
    //   398: aload 7
    //   400: iconst_5
    //   401: aaload
    //   402: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   405: istore 6
    //   407: iload 6
    //   409: iconst_1
    //   410: ixor
    //   411: istore 4
    //   413: goto +35 -> 448
    //   416: astore 7
    //   418: iload 5
    //   420: istore 4
    //   422: fload_3
    //   423: fstore_2
    //   424: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   427: ifeq +21 -> 448
    //   430: ldc_w 256
    //   433: iconst_2
    //   434: ldc_w 310
    //   437: aload 7
    //   439: invokestatic 297	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: fload_3
    //   443: fstore_2
    //   444: iload 5
    //   446: istore 4
    //   448: iload 4
    //   450: ifeq +27 -> 477
    //   453: aload_0
    //   454: aload_0
    //   455: getfield 95	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:j	Landroid/hardware/SensorManager;
    //   458: iconst_1
    //   459: invokevirtual 314	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   462: putfield 195	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:l	Landroid/hardware/Sensor;
    //   465: aload_0
    //   466: new 316	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager$AccelerationEventListener
    //   469: dup
    //   470: aload_0
    //   471: invokespecial 317	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager$AccelerationEventListener:<init>	(Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager;)V
    //   474: putfield 216	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:m	Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager$AccelerationEventListener;
    //   477: aload_0
    //   478: aload_0
    //   479: getfield 95	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:j	Landroid/hardware/SensorManager;
    //   482: bipush 8
    //   484: invokevirtual 314	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   487: putfield 164	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:k	Landroid/hardware/Sensor;
    //   490: aload_0
    //   491: new 319	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager$ProximityEventListener
    //   494: dup
    //   495: aload_0
    //   496: invokespecial 320	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager$ProximityEventListener:<init>	(Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager;)V
    //   499: putfield 322	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:n	Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager$ProximityEventListener;
    //   502: fload_2
    //   503: ldc_w 323
    //   506: fcmpl
    //   507: ifle +11 -> 518
    //   510: aload_0
    //   511: fload_2
    //   512: putfield 325	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:o	F
    //   515: goto +24 -> 539
    //   518: aload_0
    //   519: getfield 164	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:k	Landroid/hardware/Sensor;
    //   522: astore 7
    //   524: aload 7
    //   526: ifnull +13 -> 539
    //   529: aload_0
    //   530: aload_0
    //   531: aload 7
    //   533: invokespecial 327	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:a	(Landroid/hardware/Sensor;)F
    //   536: putfield 325	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:o	F
    //   539: aload_0
    //   540: iconst_1
    //   541: putfield 63	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:t	Z
    //   544: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	AudioSenorManager
    //   131	253	1	f1	float
    //   125	387	2	f2	float
    //   355	88	3	f3	float
    //   110	339	4	i1	int
    //   128	317	5	i2	int
    //   102	309	6	bool	boolean
    //   20	142	7	localObject1	java.lang.Object
    //   180	1	7	localException1	java.lang.Exception
    //   185	1	7	localException2	java.lang.Exception
    //   190	27	7	localException3	java.lang.Exception
    //   279	120	7	localObject2	java.lang.Object
    //   416	22	7	localException4	java.lang.Exception
    //   522	10	7	localSensor	Sensor
    //   35	283	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   132	171	180	java/lang/Exception
    //   118	126	185	java/lang/Exception
    //   82	104	190	java/lang/Exception
    //   356	366	416	java/lang/Exception
    //   370	383	416	java/lang/Exception
    //   385	393	416	java/lang/Exception
    //   395	407	416	java/lang/Exception
  }
  
  private void d()
  {
    this.d = -999.0F;
    this.e = -999.0F;
    this.f = -999.0F;
    this.a = false;
  }
  
  public void a(AudioSenorManager.IAudioSenorListener paramIAudioSenorListener)
  {
    this.i = paramIAudioSenorListener;
  }
  
  public void b()
  {
    AppRuntime localAppRuntime = this.c;
    if (localAppRuntime != null)
    {
      localAppRuntime.getApp().unregisterReceiver(this);
      this.c = null;
    }
    this.i = null;
    this.s.clear();
    ThreadManager.removeJobFromThreadPool(this.h, 16);
    ThreadManager.removeJobFromThreadPool(this.g, 16);
    this.j.unregisterListener(this.m);
    this.j.unregisterListener(this.n);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramContext = paramIntent.getStringExtra("audiosenormanager.playkey");
    if ((str != null) && (str.equals("mqq.audiosenormanager.audio.start")))
    {
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive AUDIO_SENOR_START_NOTIFY key = ");
        paramIntent.append(paramContext);
        QLog.d("AudioPlayer_SenorManager", 2, paramIntent.toString());
      }
      if (!this.t) {
        c();
      }
      a(paramContext);
      return;
    }
    if ((str != null) && (str.equals("mqq.audiosenormanager.audio.end")))
    {
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive AUDIO_SENOR_END_NOTIFY key = ");
        paramIntent.append(paramContext);
        QLog.d("AudioPlayer_SenorManager", 2, paramIntent.toString());
      }
      b(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager
 * JD-Core Version:    0.7.0.1
 */