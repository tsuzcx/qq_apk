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
  AudioPlayerHelper.AudioPlayerParameter[] a;
  private boolean t = false;
  private boolean u = false;
  private boolean v = true;
  private BroadcastReceiver w;
  
  public AudioPlayer(Context paramContext, AudioPlayerBase.AudioPlayerListener paramAudioPlayerListener)
  {
    super(paramContext, paramAudioPlayerListener);
  }
  
  private void a(AudioManager paramAudioManager)
  {
    paramAudioManager.setBluetoothScoOn(true);
  }
  
  private void d(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryStartBlueToothSco ");
      localStringBuilder.append(paramString);
      QLog.d("AudioPlayer_Old", 2, localStringBuilder.toString());
    }
    s();
    paramString = new AudioPlayer.MyScoReceiver(this, paramString, paramInt);
    this.i.registerReceiver(paramString, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
    this.w = paramString;
    this.h.startBluetoothSco();
  }
  
  private void s()
  {
    if (this.w != null) {
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
      this.i.unregisterReceiver(this.w);
      label57:
      this.w = null;
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
  
  public void a()
  {
    s();
    super.a();
  }
  
  public void a(IAudioFilePlayer paramIAudioFilePlayer, int paramInt1, int paramInt2, String paramString)
  {
    s();
    super.a(paramIAudioFilePlayer, paramInt1, paramInt2, paramString);
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
    //   12: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   15: lstore 6
    //   17: aload_0
    //   18: aload_1
    //   19: putfield 129	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:j	Ljava/lang/String;
    //   22: aload_0
    //   23: invokestatic 135	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   26: pop
    //   27: aload_0
    //   28: invokevirtual 138	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:r	()Z
    //   31: istore 8
    //   33: iload 8
    //   35: ifne +7 -> 42
    //   38: aload_0
    //   39: monitorexit
    //   40: iconst_0
    //   41: ireturn
    //   42: getstatic 144	com/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceHelper:c	I
    //   45: iconst_m1
    //   46: if_icmpne +14 -> 60
    //   49: aload_0
    //   50: aload_1
    //   51: iload 5
    //   53: invokevirtual 147	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:b	(Ljava/lang/String;I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: iconst_1
    //   59: ireturn
    //   60: aload_0
    //   61: getfield 94	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:h	Landroid/media/AudioManager;
    //   64: invokestatic 150	com/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceHelper:a	(Landroid/media/AudioManager;)Z
    //   67: ifeq +14 -> 81
    //   70: aload_0
    //   71: aload_1
    //   72: iload 5
    //   74: invokespecial 152	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:d	(Ljava/lang/String;I)V
    //   77: aload_0
    //   78: monitorexit
    //   79: iconst_1
    //   80: ireturn
    //   81: aload_0
    //   82: invokevirtual 155	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:l	()V
    //   85: new 157	java/io/FileInputStream
    //   88: dup
    //   89: aload_1
    //   90: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   93: astore 9
    //   95: aload 9
    //   97: astore 10
    //   99: aload 9
    //   101: invokestatic 163	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Ljava/io/InputStream;)B
    //   104: istore 4
    //   106: iload 4
    //   108: istore_3
    //   109: aload 9
    //   111: astore 11
    //   113: aload 9
    //   115: astore 10
    //   117: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +85 -> 205
    //   123: aload 9
    //   125: astore 10
    //   127: new 45	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   134: astore 11
    //   136: aload 9
    //   138: astore 10
    //   140: aload 11
    //   142: ldc 165
    //   144: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 9
    //   150: astore 10
    //   152: aload 11
    //   154: aload_1
    //   155: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 9
    //   161: astore 10
    //   163: aload 11
    //   165: ldc 167
    //   167: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 9
    //   173: astore 10
    //   175: aload 11
    //   177: iload 4
    //   179: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 9
    //   185: astore 10
    //   187: ldc 56
    //   189: iconst_2
    //   190: aload 11
    //   192: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload 9
    //   200: astore 11
    //   202: iload 4
    //   204: istore_3
    //   205: aload 11
    //   207: invokevirtual 175	java/io/InputStream:close	()V
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
    //   233: goto +288 -> 521
    //   236: astore 10
    //   238: aconst_null
    //   239: astore 9
    //   241: iconst_m1
    //   242: istore_3
    //   243: aload 10
    //   245: astore 11
    //   247: aload 9
    //   249: astore 10
    //   251: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +58 -> 312
    //   257: aload 9
    //   259: astore 10
    //   261: new 45	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   268: astore 12
    //   270: aload 9
    //   272: astore 10
    //   274: aload 12
    //   276: ldc 177
    //   278: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 9
    //   284: astore 10
    //   286: aload 12
    //   288: aload 11
    //   290: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   293: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 9
    //   299: astore 10
    //   301: ldc 56
    //   303: iconst_2
    //   304: aload 12
    //   306: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   333: new 182	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer
    //   336: dup
    //   337: invokespecial 183	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:<init>	()V
    //   340: putfield 187	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   343: iconst_1
    //   344: istore_2
    //   345: goto +60 -> 405
    //   348: aload_0
    //   349: new 189	com/tencent/mobileqq/qqaudio/audioplayer/AmrPlayer
    //   352: dup
    //   353: invokespecial 190	com/tencent/mobileqq/qqaudio/audioplayer/AmrPlayer:<init>	()V
    //   356: putfield 187	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   359: new 45	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   366: astore 9
    //   368: aload 9
    //   370: ldc 192
    //   372: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 9
    //   378: iload 4
    //   380: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 9
    //   386: ldc 194
    //   388: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: ldc 56
    //   394: iconst_1
    //   395: aload 9
    //   397: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iconst_2
    //   404: istore_2
    //   405: iload_2
    //   406: invokestatic 202	com/tencent/mobileqq/qqaudio/QQAudioReporter:a	(I)V
    //   409: aload_0
    //   410: getfield 187	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   413: aload_1
    //   414: invokeinterface 206 2 0
    //   419: aload_0
    //   420: getfield 187	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   423: iload 5
    //   425: invokeinterface 208 2 0
    //   430: aload_0
    //   431: getfield 187	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   434: iconst_m1
    //   435: iload 4
    //   437: invokeinterface 211 3 0
    //   442: aload_0
    //   443: getfield 187	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   446: aload_0
    //   447: invokeinterface 214 2 0
    //   452: aload_0
    //   453: getfield 187	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   456: aload_0
    //   457: getfield 217	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:e	F
    //   460: invokeinterface 220 2 0
    //   465: aload_0
    //   466: getfield 187	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   469: invokeinterface 221 1 0
    //   474: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +39 -> 516
    //   480: new 45	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   487: astore_1
    //   488: aload_1
    //   489: ldc 223
    //   491: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload_1
    //   496: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   499: lload 6
    //   501: lsub
    //   502: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: ldc 225
    //   508: iconst_2
    //   509: aload_1
    //   510: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: aload_0
    //   517: monitorexit
    //   518: iconst_1
    //   519: ireturn
    //   520: astore_1
    //   521: aload 10
    //   523: ifnull +8 -> 531
    //   526: aload 10
    //   528: invokevirtual 175	java/io/InputStream:close	()V
    //   531: aload_1
    //   532: athrow
    //   533: astore_1
    //   534: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   537: ifeq +12 -> 549
    //   540: ldc 56
    //   542: iconst_2
    //   543: ldc 227
    //   545: aload_1
    //   546: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   549: aload_0
    //   550: aload_0
    //   551: getfield 187	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   554: iconst_2
    //   555: iconst_0
    //   556: aload_1
    //   557: invokevirtual 231	java/lang/Exception:toString	()Ljava/lang/String;
    //   560: invokevirtual 232	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:a	(Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;IILjava/lang/String;)V
    //   563: aload_0
    //   564: monitorexit
    //   565: iconst_0
    //   566: ireturn
    //   567: astore_1
    //   568: aload_0
    //   569: monitorexit
    //   570: goto +5 -> 575
    //   573: aload_1
    //   574: athrow
    //   575: goto -2 -> 573
    //   578: astore 9
    //   580: iload_3
    //   581: istore 4
    //   583: goto -256 -> 327
    //   586: astore 9
    //   588: goto -57 -> 531
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	591	0	this	AudioPlayer
    //   0	591	1	paramString	String
    //   0	591	2	paramInt	int
    //   108	473	3	b1	byte
    //   104	478	4	b2	byte
    //   3	421	5	i	int
    //   15	485	6	l	long
    //   31	3	8	bool	boolean
    //   93	303	9	localObject1	java.lang.Object
    //   578	1	9	localException1	Exception
    //   586	1	9	localException2	Exception
    //   97	89	10	localObject2	java.lang.Object
    //   224	1	10	localException3	Exception
    //   231	1	10	localObject3	java.lang.Object
    //   236	8	10	localException4	Exception
    //   249	278	10	localObject4	java.lang.Object
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
    //   99	106	520	finally
    //   117	123	520	finally
    //   127	136	520	finally
    //   140	148	520	finally
    //   152	159	520	finally
    //   163	171	520	finally
    //   175	183	520	finally
    //   187	198	520	finally
    //   251	257	520	finally
    //   261	270	520	finally
    //   274	282	520	finally
    //   286	297	520	finally
    //   301	312	520	finally
    //   81	85	533	java/lang/Exception
    //   332	343	533	java/lang/Exception
    //   348	403	533	java/lang/Exception
    //   405	474	533	java/lang/Exception
    //   531	533	533	java/lang/Exception
    //   12	33	567	finally
    //   42	56	567	finally
    //   60	77	567	finally
    //   81	85	567	finally
    //   205	210	567	finally
    //   332	343	567	finally
    //   348	403	567	finally
    //   405	474	567	finally
    //   474	516	567	finally
    //   526	531	567	finally
    //   531	533	567	finally
    //   534	549	567	finally
    //   549	563	567	finally
    //   205	210	578	java/lang/Exception
    //   526	531	586	java/lang/Exception
  }
  
  public boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false, 0);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!this.t) && (!this.u) && ((paramBoolean1 != this.v) || (paramBoolean2)))
    {
      this.v = paramBoolean1;
      if (m()) {
        d(paramInt);
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.u) && (!this.h.isBluetoothA2dpOn())) {
      this.u = false;
    }
  }
  
  @TargetApi(14)
  public void b(String paramString, int paramInt)
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null)
    {
      AudioDeviceHelper.c = 0;
      a(paramString, paramInt);
      return;
    }
    if (!localBluetoothAdapter.isEnabled())
    {
      AudioDeviceHelper.c = 0;
      a(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(1) != 2)
    {
      AudioDeviceHelper.c = 0;
      a(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(2) == 2)
    {
      AudioDeviceHelper.c = 0;
      a(paramString, paramInt);
      return;
    }
    paramString = new AudioPlayer.1(this, paramString, paramInt, localBluetoothAdapter);
    localBluetoothAdapter.getProfileProxy(BaseApplication.getContext(), paramString, 1);
  }
  
  public void b(boolean paramBoolean)
  {
    this.t = paramBoolean;
    if (m()) {
      d(this.g.h() - AudioPlayerHelper.a);
    }
  }
  
  protected AudioPlayerHelper.AudioPlayerParameter c()
  {
    if (this.a == null) {
      this.a = AudioPlayerHelper.a();
    }
    if ((this.h.isBluetoothScoOn()) && (AudioDeviceHelper.b)) {
      return this.a[4];
    }
    if (this.t) {
      return this.a[2];
    }
    if (this.u) {
      return this.a[3];
    }
    return this.a[(this.v ^ true)];
  }
  
  public void c(boolean paramBoolean)
  {
    this.u = paramBoolean;
    if (m()) {
      d(this.g.h() - AudioPlayerHelper.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer
 * JD-Core Version:    0.7.0.1
 */