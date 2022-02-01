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
  private boolean jdField_a_of_type_Boolean = false;
  AudioPlayerHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter;
  private boolean h = false;
  private boolean i = true;
  
  public AudioPlayer(Context paramContext, AudioPlayerBase.AudioPlayerListener paramAudioPlayerListener)
  {
    super(paramContext, paramAudioPlayerListener);
  }
  
  private void a(AudioManager paramAudioManager)
  {
    paramAudioManager.setBluetoothScoOn(true);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer_Old", 2, "unregister sco receiver:  " + SystemClock.uptimeMillis());
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label51:
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Exception localException)
    {
      break label51;
    }
  }
  
  private void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer_Old", 2, "tryStartBlueToothSco " + paramString);
    }
    b();
    paramString = new AudioPlayer.MyScoReceiver(this, paramString, paramInt);
    this.jdField_a_of_type_AndroidAppApplication.registerReceiver(paramString, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = paramString;
    this.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
  }
  
  protected AudioPlayerHelper.AudioPlayerParameter a()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter = AudioPlayerHelper.a();
    }
    if ((this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) && (jdField_b_of_type_Boolean)) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[4];
    }
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[2];
    }
    if (this.h) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[3];
    }
    AudioPlayerHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter;
    if (this.i) {}
    for (int j = 0;; j = 1) {
      return arrayOfAudioPlayerParameter[j];
    }
  }
  
  public void a()
  {
    b();
    super.a();
  }
  
  public void a(IAudioFilePlayer paramIAudioFilePlayer, int paramInt1, int paramInt2, String paramString)
  {
    b();
    super.a(paramIAudioFilePlayer, paramInt1, paramInt2, paramString);
  }
  
  @TargetApi(14)
  public void a(String paramString, int paramInt)
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null)
    {
      jdField_b_of_type_Int = 0;
      a(paramString, paramInt);
      return;
    }
    if (!localBluetoothAdapter.isEnabled())
    {
      jdField_b_of_type_Int = 0;
      a(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(1) != 2)
    {
      jdField_b_of_type_Int = 0;
      a(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(2) == 2)
    {
      jdField_b_of_type_Int = 0;
      a(paramString, paramInt);
      return;
    }
    paramString = new AudioPlayer.1(this, paramString, paramInt, localBluetoothAdapter);
    localBluetoothAdapter.getProfileProxy(BaseApplication.getContext(), paramString, 1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (a()) {
      a(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a() - AudioPlayerHelper.a);
    }
  }
  
  /* Error */
  protected boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 7
    //   5: aload_0
    //   6: monitorenter
    //   7: iload_2
    //   8: istore 6
    //   10: iload_2
    //   11: ifge +6 -> 17
    //   14: iconst_0
    //   15: istore 6
    //   17: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   20: lstore 9
    //   22: aload_0
    //   23: aload_1
    //   24: putfield 189	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: aload_0
    //   28: invokestatic 195	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   31: pop
    //   32: aload_0
    //   33: invokevirtual 197	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:b	()Z
    //   36: istore 8
    //   38: iload 8
    //   40: ifne +8 -> 48
    //   43: aload_0
    //   44: monitorexit
    //   45: iload 7
    //   47: ireturn
    //   48: getstatic 140	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_b_of_type_Int	I
    //   51: iconst_m1
    //   52: if_icmpne +16 -> 68
    //   55: aload_0
    //   56: aload_1
    //   57: iload 6
    //   59: invokevirtual 199	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:a	(Ljava/lang/String;I)V
    //   62: iconst_1
    //   63: istore 7
    //   65: goto -22 -> 43
    //   68: aload_0
    //   69: getfield 107	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   72: invokestatic 202	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:a	(Landroid/media/AudioManager;)Z
    //   75: ifeq +16 -> 91
    //   78: aload_0
    //   79: aload_1
    //   80: iload 6
    //   82: invokespecial 204	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:b	(Ljava/lang/String;I)V
    //   85: iconst_1
    //   86: istore 7
    //   88: goto -45 -> 43
    //   91: aload_0
    //   92: invokevirtual 207	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:k	()V
    //   95: new 209	java/io/FileInputStream
    //   98: dup
    //   99: aload_1
    //   100: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   103: astore 12
    //   105: aload 12
    //   107: astore 11
    //   109: aload 12
    //   111: invokestatic 215	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Ljava/io/InputStream;)B
    //   114: istore 4
    //   116: aload 12
    //   118: astore 11
    //   120: iload 4
    //   122: istore_3
    //   123: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +45 -> 171
    //   129: aload 12
    //   131: astore 11
    //   133: iload 4
    //   135: istore_3
    //   136: ldc 47
    //   138: iconst_2
    //   139: new 49	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   146: ldc 217
    //   148: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_1
    //   152: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 219
    //   157: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload 4
    //   162: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: iload 4
    //   173: istore 5
    //   175: aload 12
    //   177: ifnull +12 -> 189
    //   180: aload 12
    //   182: invokevirtual 227	java/io/InputStream:close	()V
    //   185: iload 4
    //   187: istore 5
    //   189: iload 5
    //   191: iflt +258 -> 449
    //   194: aload_0
    //   195: new 229	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer
    //   198: dup
    //   199: invokespecial 230	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:<init>	()V
    //   202: putfield 171	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   205: iconst_1
    //   206: istore_2
    //   207: iload_2
    //   208: invokestatic 233	com/tencent/mobileqq/qqaudio/QQAudioReporter:a	(I)V
    //   211: aload_0
    //   212: getfield 171	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   215: aload_1
    //   216: invokeinterface 235 2 0
    //   221: aload_0
    //   222: getfield 171	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   225: iload 6
    //   227: invokeinterface 237 2 0
    //   232: aload_0
    //   233: getfield 171	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   236: iconst_m1
    //   237: iload 5
    //   239: invokeinterface 240 3 0
    //   244: aload_0
    //   245: getfield 171	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   248: aload_0
    //   249: invokeinterface 243 2 0
    //   254: aload_0
    //   255: getfield 171	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   258: aload_0
    //   259: getfield 246	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_Float	F
    //   262: invokeinterface 249 2 0
    //   267: aload_0
    //   268: getfield 171	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   271: invokeinterface 250 1 0
    //   276: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +33 -> 312
    //   282: ldc 252
    //   284: iconst_2
    //   285: new 49	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   292: ldc 254
    //   294: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   300: lload 9
    //   302: lsub
    //   303: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   306: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: iconst_1
    //   313: istore 7
    //   315: goto -272 -> 43
    //   318: astore 13
    //   320: aconst_null
    //   321: astore 12
    //   323: aload 12
    //   325: astore 11
    //   327: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +37 -> 367
    //   333: aload 12
    //   335: astore 11
    //   337: ldc 47
    //   339: iconst_2
    //   340: new 49	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 256
    //   350: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 13
    //   355: invokevirtual 259	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   358: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: iload_3
    //   368: istore 5
    //   370: aload 12
    //   372: ifnull -183 -> 189
    //   375: aload 12
    //   377: invokevirtual 227	java/io/InputStream:close	()V
    //   380: iload_3
    //   381: istore 5
    //   383: goto -194 -> 189
    //   386: astore 11
    //   388: iload_3
    //   389: istore 5
    //   391: goto -202 -> 189
    //   394: astore_1
    //   395: aconst_null
    //   396: astore 11
    //   398: aload 11
    //   400: ifnull +8 -> 408
    //   403: aload 11
    //   405: invokevirtual 227	java/io/InputStream:close	()V
    //   408: aload_1
    //   409: athrow
    //   410: astore_1
    //   411: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +13 -> 427
    //   417: ldc 47
    //   419: iconst_2
    //   420: ldc_w 261
    //   423: aload_1
    //   424: invokestatic 264	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   427: aload_0
    //   428: aload_0
    //   429: getfield 171	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   432: iconst_2
    //   433: iconst_0
    //   434: aload_1
    //   435: invokevirtual 265	java/lang/Exception:toString	()Ljava/lang/String;
    //   438: invokevirtual 266	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:a	(Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;IILjava/lang/String;)V
    //   441: goto -398 -> 43
    //   444: astore_1
    //   445: aload_0
    //   446: monitorexit
    //   447: aload_1
    //   448: athrow
    //   449: aload_0
    //   450: new 268	com/tencent/mobileqq/qqaudio/audioplayer/AmrPlayer
    //   453: dup
    //   454: invokespecial 269	com/tencent/mobileqq/qqaudio/audioplayer/AmrPlayer:<init>	()V
    //   457: putfield 171	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   460: ldc 47
    //   462: iconst_1
    //   463: new 49	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 271
    //   473: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: iload 5
    //   478: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   481: ldc_w 273
    //   484: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: iconst_2
    //   494: istore_2
    //   495: goto -288 -> 207
    //   498: astore 11
    //   500: iload 4
    //   502: istore 5
    //   504: goto -315 -> 189
    //   507: astore 11
    //   509: goto -101 -> 408
    //   512: astore_1
    //   513: goto -115 -> 398
    //   516: astore 13
    //   518: goto -195 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	AudioPlayer
    //   0	521	1	paramString	String
    //   0	521	2	paramInt	int
    //   1	388	3	b1	byte
    //   114	387	4	b2	byte
    //   173	330	5	b3	byte
    //   8	218	6	j	int
    //   3	311	7	bool1	boolean
    //   36	3	8	bool2	boolean
    //   20	281	9	l	long
    //   107	229	11	localFileInputStream1	java.io.FileInputStream
    //   386	1	11	localException1	Exception
    //   396	8	11	localObject	java.lang.Object
    //   498	1	11	localException2	Exception
    //   507	1	11	localException3	Exception
    //   103	273	12	localFileInputStream2	java.io.FileInputStream
    //   318	36	13	localException4	Exception
    //   516	1	13	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   95	105	318	java/lang/Exception
    //   375	380	386	java/lang/Exception
    //   95	105	394	finally
    //   91	95	410	java/lang/Exception
    //   194	205	410	java/lang/Exception
    //   207	276	410	java/lang/Exception
    //   408	410	410	java/lang/Exception
    //   449	493	410	java/lang/Exception
    //   17	38	444	finally
    //   48	62	444	finally
    //   68	85	444	finally
    //   91	95	444	finally
    //   180	185	444	finally
    //   194	205	444	finally
    //   207	276	444	finally
    //   276	312	444	finally
    //   375	380	444	finally
    //   403	408	444	finally
    //   408	410	444	finally
    //   411	427	444	finally
    //   427	441	444	finally
    //   449	493	444	finally
    //   180	185	498	java/lang/Exception
    //   403	408	507	java/lang/Exception
    //   109	116	512	finally
    //   123	129	512	finally
    //   136	171	512	finally
    //   327	333	512	finally
    //   337	367	512	finally
    //   109	116	516	java/lang/Exception
    //   123	129	516	java/lang/Exception
    //   136	171	516	java/lang/Exception
  }
  
  public boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false, 0);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.h) && ((paramBoolean1 != this.i) || (paramBoolean2)))
    {
      this.i = paramBoolean1;
      if (a()) {
        a(paramInt);
      }
      return true;
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (a()) {
      a(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a() - AudioPlayerHelper.a);
    }
  }
  
  public void e()
  {
    if ((this.h) && (!this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothA2dpOn())) {
      this.h = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer
 * JD-Core Version:    0.7.0.1
 */