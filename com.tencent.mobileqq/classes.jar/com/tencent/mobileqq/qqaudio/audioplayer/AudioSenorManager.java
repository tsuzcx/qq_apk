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
  public static int a = 1000;
  float jdField_a_of_type_Float;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private AudioSenorManager.AccelerationEventListener jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioSenorManager$AccelerationEventListener;
  private AudioSenorManager.IAudioSenorListener jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioSenorManager$IAudioSenorListener = null;
  private AudioSenorManager.ProximityEventListener jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioSenorManager$ProximityEventListener;
  Runnable jdField_a_of_type_JavaLangRunnable = new AudioSenorManager.1(this);
  private List<String> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  boolean jdField_a_of_type_Boolean = true;
  float jdField_b_of_type_Float;
  private volatile int jdField_b_of_type_Int = 0;
  private Sensor jdField_b_of_type_AndroidHardwareSensor;
  Runnable jdField_b_of_type_JavaLangRunnable = new AudioSenorManager.2(this);
  private boolean jdField_b_of_type_Boolean = false;
  float c;
  private float d;
  private float e = 0.6F;
  private float f = 0.02F;
  
  public AudioSenorManager(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    paramAppRuntime = paramAppRuntime.getApp();
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramAppRuntime.getSystemService("sensor"));
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
    if (!StringUtil.a(paramString))
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilList.add(paramString);
      }
      c();
      ThreadManager.removeJobFromThreadPool(this.jdField_b_of_type_JavaLangRunnable, 16);
      ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 16, null, false);
    }
  }
  
  public static boolean a()
  {
    return Build.MODEL.equals("ZTE U930");
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: ldc 194
    //   2: invokestatic 200	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5: checkcast 194	com/tencent/mobileqq/dpc/api/IDPCApi
    //   8: getstatic 206	com/tencent/mobileqq/dpc/enumname/DPCNames:qq_audio_play	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   11: invokevirtual 210	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   14: aconst_null
    //   15: invokeinterface 214 3 0
    //   20: astore 7
    //   22: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +39 -> 64
    //   28: new 221	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   35: astore 8
    //   37: aload 8
    //   39: ldc 224
    //   41: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 8
    //   47: aload 7
    //   49: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 230
    //   55: iconst_2
    //   56: aload 8
    //   58: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload 7
    //   66: invokestatic 242	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifne +157 -> 226
    //   72: aload 7
    //   74: invokevirtual 246	java/lang/String:length	()I
    //   77: iconst_1
    //   78: if_icmple +148 -> 226
    //   81: aload 7
    //   83: ldc 248
    //   85: invokevirtual 252	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   88: astore 7
    //   90: ldc 254
    //   92: aload 7
    //   94: iconst_0
    //   95: aaload
    //   96: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: istore 6
    //   101: iload 6
    //   103: ifne +9 -> 112
    //   106: iconst_1
    //   107: istore 4
    //   109: goto +6 -> 115
    //   112: iconst_0
    //   113: istore 4
    //   115: aload 7
    //   117: iconst_1
    //   118: aaload
    //   119: invokestatic 260	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   122: fstore_2
    //   123: iload 4
    //   125: istore 5
    //   127: fload_2
    //   128: fstore_1
    //   129: aload 7
    //   131: arraylength
    //   132: iconst_5
    //   133: if_icmplt +98 -> 231
    //   136: aload_0
    //   137: aload 7
    //   139: iconst_2
    //   140: aaload
    //   141: invokestatic 260	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   144: putfield 37	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:e	F
    //   147: aload_0
    //   148: aload 7
    //   150: iconst_3
    //   151: aaload
    //   152: invokestatic 260	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   155: putfield 40	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:f	F
    //   158: aload 7
    //   160: iconst_4
    //   161: aaload
    //   162: invokestatic 266	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: putstatic 268	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:jdField_a_of_type_Int	I
    //   168: iload 4
    //   170: istore 5
    //   172: fload_2
    //   173: fstore_1
    //   174: goto +57 -> 231
    //   177: astore 7
    //   179: goto +15 -> 194
    //   182: astore 7
    //   184: goto +8 -> 192
    //   187: astore 7
    //   189: iconst_1
    //   190: istore 4
    //   192: fconst_0
    //   193: fstore_2
    //   194: iload 4
    //   196: istore 5
    //   198: fload_2
    //   199: fstore_1
    //   200: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +28 -> 231
    //   206: ldc 230
    //   208: iconst_2
    //   209: ldc_w 270
    //   212: aload 7
    //   214: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: iload 4
    //   219: istore 5
    //   221: fload_2
    //   222: fstore_1
    //   223: goto +8 -> 231
    //   226: iconst_1
    //   227: istore 5
    //   229: fconst_0
    //   230: fstore_1
    //   231: getstatic 268	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:jdField_a_of_type_Int	I
    //   234: ifge +9 -> 243
    //   237: sipush 1000
    //   240: putstatic 268	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:jdField_a_of_type_Int	I
    //   243: aload_0
    //   244: getfield 37	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:e	F
    //   247: fconst_0
    //   248: fcmpg
    //   249: ifgt +6 -> 255
    //   252: iconst_0
    //   253: istore 5
    //   255: ldc 194
    //   257: invokestatic 200	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   260: checkcast 194	com/tencent/mobileqq/dpc/api/IDPCApi
    //   263: getstatic 279	com/tencent/mobileqq/dpc/enumname/DPCAccountNames:qq_audio_play_fix	Lcom/tencent/mobileqq/dpc/enumname/DPCAccountNames;
    //   266: invokevirtual 280	com/tencent/mobileqq/dpc/enumname/DPCAccountNames:name	()Ljava/lang/String;
    //   269: aconst_null
    //   270: invokeinterface 214 3 0
    //   275: astore 7
    //   277: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +40 -> 320
    //   283: new 221	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   290: astore 8
    //   292: aload 8
    //   294: ldc_w 282
    //   297: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 8
    //   303: aload 7
    //   305: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: ldc 230
    //   311: iconst_2
    //   312: aload 8
    //   314: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: iload 5
    //   322: istore 4
    //   324: fload_1
    //   325: fstore_2
    //   326: aload 7
    //   328: invokestatic 242	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   331: ifne +109 -> 440
    //   334: iload 5
    //   336: istore 4
    //   338: fload_1
    //   339: fstore_2
    //   340: aload 7
    //   342: invokevirtual 246	java/lang/String:length	()I
    //   345: iconst_1
    //   346: if_icmple +94 -> 440
    //   349: fload_1
    //   350: fstore_3
    //   351: aload 7
    //   353: ldc 248
    //   355: invokevirtual 252	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   358: astore 7
    //   360: fload_1
    //   361: fstore_2
    //   362: fload_1
    //   363: fstore_3
    //   364: ldc_w 284
    //   367: aload 7
    //   369: iconst_4
    //   370: aaload
    //   371: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   374: ifne +13 -> 387
    //   377: fload_1
    //   378: fstore_3
    //   379: aload 7
    //   381: iconst_4
    //   382: aaload
    //   383: invokestatic 260	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   386: fstore_2
    //   387: fload_2
    //   388: fstore_3
    //   389: ldc 254
    //   391: aload 7
    //   393: iconst_5
    //   394: aaload
    //   395: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   398: istore 6
    //   400: iload 6
    //   402: iconst_1
    //   403: ixor
    //   404: istore 4
    //   406: goto +34 -> 440
    //   409: astore 7
    //   411: iload 5
    //   413: istore 4
    //   415: fload_3
    //   416: fstore_2
    //   417: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq +20 -> 440
    //   423: ldc 230
    //   425: iconst_2
    //   426: ldc_w 286
    //   429: aload 7
    //   431: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   434: fload_3
    //   435: fstore_2
    //   436: iload 5
    //   438: istore 4
    //   440: iload 4
    //   442: ifeq +27 -> 469
    //   445: aload_0
    //   446: aload_0
    //   447: getfield 81	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:jdField_a_of_type_AndroidHardwareSensorManager	Landroid/hardware/SensorManager;
    //   450: iconst_1
    //   451: invokevirtual 290	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   454: putfield 190	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:jdField_b_of_type_AndroidHardwareSensor	Landroid/hardware/Sensor;
    //   457: aload_0
    //   458: new 292	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager$AccelerationEventListener
    //   461: dup
    //   462: aload_0
    //   463: invokespecial 293	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager$AccelerationEventListener:<init>	(Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager;)V
    //   466: putfield 156	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioSenorManager$AccelerationEventListener	Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager$AccelerationEventListener;
    //   469: aload_0
    //   470: aload_0
    //   471: getfield 81	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:jdField_a_of_type_AndroidHardwareSensorManager	Landroid/hardware/SensorManager;
    //   474: bipush 8
    //   476: invokevirtual 290	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   479: putfield 152	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:jdField_a_of_type_AndroidHardwareSensor	Landroid/hardware/Sensor;
    //   482: aload_0
    //   483: new 295	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager$ProximityEventListener
    //   486: dup
    //   487: aload_0
    //   488: invokespecial 296	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager$ProximityEventListener:<init>	(Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager;)V
    //   491: putfield 160	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioSenorManager$ProximityEventListener	Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager$ProximityEventListener;
    //   494: fload_2
    //   495: ldc_w 297
    //   498: fcmpl
    //   499: ifle +11 -> 510
    //   502: aload_0
    //   503: fload_2
    //   504: putfield 299	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:d	F
    //   507: goto +24 -> 531
    //   510: aload_0
    //   511: getfield 152	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:jdField_a_of_type_AndroidHardwareSensor	Landroid/hardware/Sensor;
    //   514: astore 7
    //   516: aload 7
    //   518: ifnull +13 -> 531
    //   521: aload_0
    //   522: aload_0
    //   523: aload 7
    //   525: invokespecial 301	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:a	(Landroid/hardware/Sensor;)F
    //   528: putfield 299	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:d	F
    //   531: aload_0
    //   532: iconst_1
    //   533: putfield 49	com/tencent/mobileqq/qqaudio/audioplayer/AudioSenorManager:jdField_b_of_type_Boolean	Z
    //   536: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	AudioSenorManager
    //   128	250	1	f1	float
    //   122	382	2	f2	float
    //   350	85	3	f3	float
    //   107	334	4	i	int
    //   125	312	5	j	int
    //   99	305	6	bool	boolean
    //   20	139	7	localObject1	java.lang.Object
    //   177	1	7	localException1	java.lang.Exception
    //   182	1	7	localException2	java.lang.Exception
    //   187	26	7	localException3	java.lang.Exception
    //   275	117	7	localObject2	java.lang.Object
    //   409	21	7	localException4	java.lang.Exception
    //   514	10	7	localSensor	Sensor
    //   35	278	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   129	168	177	java/lang/Exception
    //   115	123	182	java/lang/Exception
    //   81	101	187	java/lang/Exception
    //   351	360	409	java/lang/Exception
    //   364	377	409	java/lang/Exception
    //   379	387	409	java/lang/Exception
    //   389	400	409	java/lang/Exception
  }
  
  private void b(String paramString)
  {
    if (!StringUtil.a(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramString))
      {
        List localList = this.jdField_a_of_type_JavaUtilList;
        localList.remove(localList.indexOf(paramString));
      }
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 16);
        ThreadManager.excute(this.jdField_b_of_type_JavaLangRunnable, 16, null, false);
        if (this.jdField_b_of_type_Int != 0)
        {
          this.jdField_b_of_type_Int = 0;
          paramString = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioSenorManager$IAudioSenorListener;
          if (paramString != null) {
            paramString.onNearToEarStatusChanged(this.jdField_b_of_type_Int);
          }
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Float = -999.0F;
    this.jdField_b_of_type_Float = -999.0F;
    this.c = -999.0F;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localAppRuntime != null)
    {
      localAppRuntime.getApp().unregisterReceiver(this);
      this.jdField_a_of_type_MqqAppAppRuntime = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioSenorManager$IAudioSenorListener = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    ThreadManager.removeJobFromThreadPool(this.jdField_b_of_type_JavaLangRunnable, 16);
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 16);
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioSenorManager$AccelerationEventListener);
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioSenorManager$ProximityEventListener);
  }
  
  public void a(AudioSenorManager.IAudioSenorListener paramIAudioSenorListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioSenorManager$IAudioSenorListener = paramIAudioSenorListener;
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
      if (!this.jdField_b_of_type_Boolean) {
        b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager
 * JD-Core Version:    0.7.0.1
 */