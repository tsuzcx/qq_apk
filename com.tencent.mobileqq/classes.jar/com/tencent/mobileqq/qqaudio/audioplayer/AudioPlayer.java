package com.tencent.mobileqq.qqaudio.audioplayer;

import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.SystemClock;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class AudioPlayer
  extends AudioPlayerBase
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  AudioPlayerHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter;
  private boolean e = false;
  private boolean f = false;
  private boolean g = true;
  
  public AudioPlayer(Context paramContext, AudioPlayerBase.AudioPlayerListener paramAudioPlayerListener)
  {
    super(paramContext, paramAudioPlayerListener);
  }
  
  private void a(AudioManager paramAudioManager)
  {
    paramAudioManager.setBluetoothScoOn(true);
  }
  
  private void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryStartBlueToothSco ");
      localStringBuilder.append(paramString);
      QLog.d("AudioPlayer_Old", 2, localStringBuilder.toString());
    }
    l();
    paramString = new AudioPlayer.MyScoReceiver(this, paramString, paramInt);
    this.jdField_a_of_type_AndroidAppApplication.registerReceiver(paramString, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = paramString;
    this.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unregister sco receiver:  ");
        localStringBuilder.append(SystemClock.uptimeMillis());
        QLog.d("AudioPlayer_Old", 2, localStringBuilder.toString());
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label57:
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
  
  protected AudioPlayerHelper.AudioPlayerParameter a()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter = AudioPlayerHelper.a();
    }
    if ((this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) && (AudioDeviceHelper.jdField_a_of_type_Boolean)) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[4];
    }
    if (this.e) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[2];
    }
    if (this.f) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[3];
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[(this.g ^ true)];
  }
  
  public void a()
  {
    l();
    super.a();
  }
  
  public void a(IAudioFilePlayer paramIAudioFilePlayer, int paramInt1, int paramInt2, String paramString)
  {
    l();
    super.a(paramIAudioFilePlayer, paramInt1, paramInt2, paramString);
  }
  
  @TargetApi(14)
  public void a(String paramString, int paramInt)
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null)
    {
      AudioDeviceHelper.jdField_a_of_type_Int = 0;
      a(paramString, paramInt);
      return;
    }
    if (!localBluetoothAdapter.isEnabled())
    {
      AudioDeviceHelper.jdField_a_of_type_Int = 0;
      a(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(1) != 2)
    {
      AudioDeviceHelper.jdField_a_of_type_Int = 0;
      a(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(2) == 2)
    {
      AudioDeviceHelper.jdField_a_of_type_Int = 0;
      a(paramString, paramInt);
      return;
    }
    paramString = new AudioPlayer.1(this, paramString, paramInt, localBluetoothAdapter);
    localBluetoothAdapter.getProfileProxy(BaseApplication.getContext(), paramString, 1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (a()) {
      d(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a() - AudioPlayerHelper.jdField_a_of_type_Int);
    }
  }
  
  /* Error */
  protected boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: istore 5
    //   5: iload_2
    //   6: ifge +6 -> 12
    //   9: iconst_0
    //   10: istore 5
    //   12: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   15: lstore 6
    //   17: aload_0
    //   18: aload_1
    //   19: putfield 192	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   22: aload_0
    //   23: invokestatic 198	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   26: pop
    //   27: aload_0
    //   28: invokevirtual 200	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:b	()Z
    //   31: istore 8
    //   33: iload 8
    //   35: ifne +7 -> 42
    //   38: aload_0
    //   39: monitorexit
    //   40: iconst_0
    //   41: ireturn
    //   42: getstatic 144	com/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceHelper:jdField_a_of_type_Int	I
    //   45: iconst_m1
    //   46: if_icmpne +14 -> 60
    //   49: aload_0
    //   50: aload_1
    //   51: iload 5
    //   53: invokevirtual 202	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:a	(Ljava/lang/String;I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: iconst_1
    //   59: ireturn
    //   60: aload_0
    //   61: getfield 92	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   64: invokestatic 205	com/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceHelper:a	(Landroid/media/AudioManager;)Z
    //   67: ifeq +14 -> 81
    //   70: aload_0
    //   71: aload_1
    //   72: iload 5
    //   74: invokespecial 207	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:b	(Ljava/lang/String;I)V
    //   77: aload_0
    //   78: monitorexit
    //   79: iconst_1
    //   80: ireturn
    //   81: aload_0
    //   82: invokevirtual 209	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:g	()V
    //   85: new 211	java/io/FileInputStream
    //   88: dup
    //   89: aload_1
    //   90: invokespecial 212	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   93: astore 9
    //   95: aload 9
    //   97: astore 10
    //   99: aload 9
    //   101: invokestatic 217	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Ljava/io/InputStream;)B
    //   104: istore 4
    //   106: iload 4
    //   108: istore_3
    //   109: aload 9
    //   111: astore 11
    //   113: aload 9
    //   115: astore 10
    //   117: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +85 -> 205
    //   123: aload 9
    //   125: astore 10
    //   127: new 44	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   134: astore 11
    //   136: aload 9
    //   138: astore 10
    //   140: aload 11
    //   142: ldc 219
    //   144: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 9
    //   150: astore 10
    //   152: aload 11
    //   154: aload_1
    //   155: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 9
    //   161: astore 10
    //   163: aload 11
    //   165: ldc 221
    //   167: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 9
    //   173: astore 10
    //   175: aload 11
    //   177: iload 4
    //   179: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 9
    //   185: astore 10
    //   187: ldc 55
    //   189: iconst_2
    //   190: aload 11
    //   192: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload 9
    //   200: astore 11
    //   202: iload 4
    //   204: istore_3
    //   205: aload 11
    //   207: invokevirtual 229	java/io/InputStream:close	()V
    //   210: iload_3
    //   211: istore 4
    //   213: goto +114 -> 327
    //   216: astore 11
    //   218: iload 4
    //   220: istore_3
    //   221: goto +26 -> 247
    //   224: astore 10
    //   226: goto +15 -> 241
    //   229: astore_1
    //   230: aconst_null
    //   231: astore 10
    //   233: goto +290 -> 523
    //   236: astore 10
    //   238: aconst_null
    //   239: astore 9
    //   241: iconst_m1
    //   242: istore_3
    //   243: aload 10
    //   245: astore 11
    //   247: aload 9
    //   249: astore 10
    //   251: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +58 -> 312
    //   257: aload 9
    //   259: astore 10
    //   261: new 44	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   268: astore 12
    //   270: aload 9
    //   272: astore 10
    //   274: aload 12
    //   276: ldc 231
    //   278: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 9
    //   284: astore 10
    //   286: aload 12
    //   288: aload 11
    //   290: invokevirtual 234	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   293: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 9
    //   299: astore 10
    //   301: ldc 55
    //   303: iconst_2
    //   304: aload 12
    //   306: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: iload_3
    //   313: istore 4
    //   315: aload 9
    //   317: ifnull +10 -> 327
    //   320: aload 9
    //   322: astore 11
    //   324: goto -119 -> 205
    //   327: iload 4
    //   329: iflt +19 -> 348
    //   332: aload_0
    //   333: new 236	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer
    //   336: dup
    //   337: invokespecial 237	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:<init>	()V
    //   340: putfield 175	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   343: iconst_1
    //   344: istore_2
    //   345: goto +60 -> 405
    //   348: aload_0
    //   349: new 239	com/tencent/mobileqq/qqaudio/audioplayer/AmrPlayer
    //   352: dup
    //   353: invokespecial 240	com/tencent/mobileqq/qqaudio/audioplayer/AmrPlayer:<init>	()V
    //   356: putfield 175	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   359: new 44	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   366: astore 9
    //   368: aload 9
    //   370: ldc 242
    //   372: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 9
    //   378: iload 4
    //   380: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 9
    //   386: ldc 244
    //   388: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: ldc 55
    //   394: iconst_1
    //   395: aload 9
    //   397: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iconst_2
    //   404: istore_2
    //   405: iload_2
    //   406: invokestatic 250	com/tencent/mobileqq/qqaudio/QQAudioReporter:a	(I)V
    //   409: aload_0
    //   410: getfield 175	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   413: aload_1
    //   414: invokeinterface 252 2 0
    //   419: aload_0
    //   420: getfield 175	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   423: iload 5
    //   425: invokeinterface 254 2 0
    //   430: aload_0
    //   431: getfield 175	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   434: iconst_m1
    //   435: iload 4
    //   437: invokeinterface 257 3 0
    //   442: aload_0
    //   443: getfield 175	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   446: aload_0
    //   447: invokeinterface 260 2 0
    //   452: aload_0
    //   453: getfield 175	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   456: aload_0
    //   457: getfield 263	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_Float	F
    //   460: invokeinterface 266 2 0
    //   465: aload_0
    //   466: getfield 175	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   469: invokeinterface 267 1 0
    //   474: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +41 -> 518
    //   480: new 44	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   487: astore_1
    //   488: aload_1
    //   489: ldc_w 269
    //   492: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload_1
    //   497: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   500: lload 6
    //   502: lsub
    //   503: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: ldc_w 271
    //   510: iconst_2
    //   511: aload_1
    //   512: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: aload_0
    //   519: monitorexit
    //   520: iconst_1
    //   521: ireturn
    //   522: astore_1
    //   523: aload 10
    //   525: ifnull +8 -> 533
    //   528: aload 10
    //   530: invokevirtual 229	java/io/InputStream:close	()V
    //   533: aload_1
    //   534: athrow
    //   535: astore_1
    //   536: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq +13 -> 552
    //   542: ldc 55
    //   544: iconst_2
    //   545: ldc_w 273
    //   548: aload_1
    //   549: invokestatic 276	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   552: aload_0
    //   553: aload_0
    //   554: getfield 175	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   557: iconst_2
    //   558: iconst_0
    //   559: aload_1
    //   560: invokevirtual 277	java/lang/Exception:toString	()Ljava/lang/String;
    //   563: invokevirtual 278	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:a	(Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;IILjava/lang/String;)V
    //   566: aload_0
    //   567: monitorexit
    //   568: iconst_0
    //   569: ireturn
    //   570: astore_1
    //   571: aload_0
    //   572: monitorexit
    //   573: goto +5 -> 578
    //   576: aload_1
    //   577: athrow
    //   578: goto -2 -> 576
    //   581: astore 9
    //   583: iload_3
    //   584: istore 4
    //   586: goto -259 -> 327
    //   589: astore 9
    //   591: goto -58 -> 533
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	AudioPlayer
    //   0	594	1	paramString	String
    //   0	594	2	paramInt	int
    //   108	476	3	b1	byte
    //   104	481	4	b2	byte
    //   3	421	5	i	int
    //   15	486	6	l	long
    //   31	3	8	bool	boolean
    //   93	303	9	localObject1	java.lang.Object
    //   581	1	9	localException1	Exception
    //   589	1	9	localException2	Exception
    //   97	89	10	localObject2	java.lang.Object
    //   224	1	10	localException3	Exception
    //   231	1	10	localObject3	java.lang.Object
    //   236	8	10	localException4	Exception
    //   249	280	10	localObject4	java.lang.Object
    //   111	95	11	localObject5	java.lang.Object
    //   216	1	11	localException5	Exception
    //   245	78	11	localObject6	java.lang.Object
    //   268	37	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   117	123	216	java/lang/Exception
    //   127	136	216	java/lang/Exception
    //   140	148	216	java/lang/Exception
    //   152	159	216	java/lang/Exception
    //   163	171	216	java/lang/Exception
    //   175	183	216	java/lang/Exception
    //   187	198	216	java/lang/Exception
    //   99	106	224	java/lang/Exception
    //   85	95	229	finally
    //   85	95	236	java/lang/Exception
    //   99	106	522	finally
    //   117	123	522	finally
    //   127	136	522	finally
    //   140	148	522	finally
    //   152	159	522	finally
    //   163	171	522	finally
    //   175	183	522	finally
    //   187	198	522	finally
    //   251	257	522	finally
    //   261	270	522	finally
    //   274	282	522	finally
    //   286	297	522	finally
    //   301	312	522	finally
    //   81	85	535	java/lang/Exception
    //   332	343	535	java/lang/Exception
    //   348	403	535	java/lang/Exception
    //   405	474	535	java/lang/Exception
    //   533	535	535	java/lang/Exception
    //   12	33	570	finally
    //   42	56	570	finally
    //   60	77	570	finally
    //   81	85	570	finally
    //   205	210	570	finally
    //   332	343	570	finally
    //   348	403	570	finally
    //   405	474	570	finally
    //   474	518	570	finally
    //   528	533	570	finally
    //   533	535	570	finally
    //   536	552	570	finally
    //   552	566	570	finally
    //   205	210	581	java/lang/Exception
    //   528	533	589	java/lang/Exception
  }
  
  public boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false, 0);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!this.e) && (!this.f) && ((paramBoolean1 != this.g) || (paramBoolean2)))
    {
      this.g = paramBoolean1;
      if (a()) {
        d(paramInt);
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.f) && (!this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothA2dpOn())) {
      this.f = false;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (a()) {
      d(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a() - AudioPlayerHelper.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer
 * JD-Core Version:    0.7.0.1
 */