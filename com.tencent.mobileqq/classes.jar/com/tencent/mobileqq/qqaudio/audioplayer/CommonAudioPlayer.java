package com.tencent.mobileqq.qqaudio.audioplayer;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class CommonAudioPlayer
  extends AudioPlayerBase
  implements IAudioDeviceService.IAudioDeviceListener
{
  private AudioBluetoothSCOHelper jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper;
  private AudioDeviceStatus jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus;
  private CommonAudioPlayer.UIAudioDeivceChangedListern jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer$UIAudioDeivceChangedListern;
  private String b;
  volatile boolean e = false;
  
  public CommonAudioPlayer(Context paramContext, AudioPlayerBase.AudioPlayerListener paramAudioPlayerListener)
  {
    super(paramContext, paramAudioPlayerListener);
  }
  
  private void a(AudioDeviceStatus.AudioDeviceStatusResult paramAudioDeviceStatusResult)
  {
    if (paramAudioDeviceStatusResult == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CommonAudioPlayer.notifyUIDeviceStatusChanged getDeviceStatusType = ");
    ((StringBuilder)localObject).append(paramAudioDeviceStatusResult.a());
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.a((String)localObject);
    int i = paramAudioDeviceStatusResult.a();
    boolean bool1 = false;
    boolean bool2;
    if ((i != 0) && (i != 1))
    {
      if ((i != 2) && (i != 3) && (i != 4)) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer$UIAudioDeivceChangedListern;
      if (localObject != null)
      {
        bool2 = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.b();
        boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.c();
        boolean bool4 = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.a();
        if (paramAudioDeviceStatusResult.a() == 2) {
          bool1 = true;
        }
        ((CommonAudioPlayer.UIAudioDeivceChangedListern)localObject).a(bool2, bool3, bool4, bool1);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer$UIAudioDeivceChangedListern != null)
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.a();
      bool2 = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.d();
      if (bool2) {
        bool1 = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer$UIAudioDeivceChangedListern.a(bool2, bool1);
    }
  }
  
  private void m()
  {
    String str = this.b;
    if (StringUtil.a(str)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(this.jdField_a_of_type_AndroidAppApplication.getPackageName());
    localIntent.setAction("mqq.audiosenormanager.audio.start");
    localIntent.putExtra("audiosenormanager.playkey", str);
    this.jdField_a_of_type_AndroidAppApplication.getApplicationContext().sendBroadcast(localIntent);
  }
  
  private void n()
  {
    String str = this.b;
    if (StringUtil.a(str)) {
      return;
    }
    this.b = null;
    Intent localIntent = new Intent();
    localIntent.setPackage(this.jdField_a_of_type_AndroidAppApplication.getPackageName());
    localIntent.setAction("mqq.audiosenormanager.audio.end");
    localIntent.putExtra("audiosenormanager.playkey", str);
    this.jdField_a_of_type_AndroidAppApplication.getApplicationContext().sendBroadcast(localIntent);
  }
  
  protected AudioPlayerHelper.AudioPlayerParameter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper.a();
    super.a();
    this.e = false;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 8)
    {
      if (paramInt == 16) {
        a(paramBoolean, true);
      }
    }
    else {
      a(paramBoolean, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.a(paramInt, paramBoolean);
    AudioDeviceStatus.AudioDeviceStatusResult localAudioDeviceStatusResult = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.a();
    if (localAudioDeviceStatusResult != null)
    {
      boolean bool = a();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("before notifyUIDeviceStatusChanged status = ");
        localStringBuilder.append(localAudioDeviceStatusResult.a());
        localStringBuilder.append(" | isPlaying = ");
        localStringBuilder.append(bool);
        QLog.d("AudioPlayer_Common", 2, localStringBuilder.toString());
      }
      if (bool)
      {
        if (localAudioDeviceStatusResult.a())
        {
          localAudioDeviceStatusResult.a();
          d(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a() - AudioPlayerHelper.a);
        }
        a(localAudioDeviceStatusResult);
      }
    }
    if (paramInt != 8)
    {
      if (paramInt != 16) {
        return;
      }
      if (paramBoolean) {
        j();
      }
    }
    else if (!paramBoolean)
    {
      j();
    }
  }
  
  public void a(CommonAudioPlayer.UIAudioDeivceChangedListern paramUIAudioDeivceChangedListern)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer$UIAudioDeivceChangedListern = paramUIAudioDeivceChangedListern;
  }
  
  public void a(IAudioFilePlayer paramIAudioFilePlayer, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper.a();
    super.a(paramIAudioFilePlayer, paramInt1, paramInt2, paramString);
    this.e = false;
  }
  
  public boolean a()
  {
    return (super.a()) || (this.e);
  }
  
  /* Error */
  protected boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: istore 5
    //   3: iload_2
    //   4: ifge +6 -> 10
    //   7: iconst_0
    //   8: istore 5
    //   10: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   13: lstore 6
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 193	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: aload_0
    //   21: invokestatic 199	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   24: pop
    //   25: aload_0
    //   26: invokevirtual 200	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:b	()Z
    //   29: ifne +5 -> 34
    //   32: iconst_0
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 47	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus	Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceStatus;
    //   38: invokevirtual 202	com/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceStatus:b	()V
    //   41: aload_0
    //   42: getfield 125	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper	Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioBluetoothSCOHelper;
    //   45: aload_1
    //   46: iload 5
    //   48: invokevirtual 205	com/tencent/mobileqq/qqaudio/audioplayer/AudioBluetoothSCOHelper:a	(Ljava/lang/String;I)I
    //   51: istore_2
    //   52: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +38 -> 93
    //   58: new 24	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   65: astore 8
    //   67: aload 8
    //   69: ldc 207
    //   71: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 8
    //   77: iload_2
    //   78: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 153
    //   84: iconst_2
    //   85: aload 8
    //   87: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: iload_2
    //   94: ifne +10 -> 104
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 20	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:e	Z
    //   102: iconst_0
    //   103: ireturn
    //   104: iload_2
    //   105: iconst_2
    //   106: if_icmpne +10 -> 116
    //   109: aload_0
    //   110: iconst_0
    //   111: putfield 20	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:e	Z
    //   114: iconst_1
    //   115: ireturn
    //   116: aload_0
    //   117: getfield 210	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   120: invokestatic 215	com/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceHelper:a	(Landroid/media/AudioManager;)Z
    //   123: ifeq +78 -> 201
    //   126: aload_0
    //   127: getfield 125	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper	Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioBluetoothSCOHelper;
    //   130: aload_1
    //   131: iload 5
    //   133: invokevirtual 217	com/tencent/mobileqq/qqaudio/audioplayer/AudioBluetoothSCOHelper:b	(Ljava/lang/String;I)I
    //   136: istore_2
    //   137: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +38 -> 178
    //   143: new 24	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   150: astore 8
    //   152: aload 8
    //   154: ldc 219
    //   156: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 8
    //   162: iload_2
    //   163: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: ldc 153
    //   169: iconst_2
    //   170: aload 8
    //   172: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: iload_2
    //   179: ifne +10 -> 189
    //   182: aload_0
    //   183: iconst_0
    //   184: putfield 20	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:e	Z
    //   187: iconst_0
    //   188: ireturn
    //   189: iload_2
    //   190: iconst_2
    //   191: if_icmpne +10 -> 201
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield 20	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:e	Z
    //   199: iconst_1
    //   200: ireturn
    //   201: new 24	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   208: astore 8
    //   210: aload 8
    //   212: aload_1
    //   213: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 8
    //   219: lload 6
    //   221: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_0
    //   226: aload 8
    //   228: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: putfield 76	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:b	Ljava/lang/String;
    //   234: aload_0
    //   235: invokevirtual 225	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:g	()V
    //   238: new 227	java/io/FileInputStream
    //   241: dup
    //   242: aload_1
    //   243: invokespecial 229	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   246: astore 8
    //   248: aload 8
    //   250: astore 9
    //   252: aload 8
    //   254: invokestatic 234	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Ljava/io/InputStream;)B
    //   257: istore 4
    //   259: iload 4
    //   261: istore_3
    //   262: aload 8
    //   264: astore 10
    //   266: aload 8
    //   268: astore 9
    //   270: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +85 -> 358
    //   276: aload 8
    //   278: astore 9
    //   280: new 24	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   287: astore 10
    //   289: aload 8
    //   291: astore 9
    //   293: aload 10
    //   295: ldc 236
    //   297: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 8
    //   303: astore 9
    //   305: aload 10
    //   307: aload_1
    //   308: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 8
    //   314: astore 9
    //   316: aload 10
    //   318: ldc 238
    //   320: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 8
    //   326: astore 9
    //   328: aload 10
    //   330: iload 4
    //   332: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 8
    //   338: astore 9
    //   340: ldc 153
    //   342: iconst_2
    //   343: aload 10
    //   345: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload 8
    //   353: astore 10
    //   355: iload 4
    //   357: istore_3
    //   358: aload 10
    //   360: invokevirtual 243	java/io/InputStream:close	()V
    //   363: iload_3
    //   364: istore 4
    //   366: goto +114 -> 480
    //   369: astore 10
    //   371: iload 4
    //   373: istore_3
    //   374: goto +26 -> 400
    //   377: astore 9
    //   379: goto +15 -> 394
    //   382: astore_1
    //   383: aconst_null
    //   384: astore 9
    //   386: goto +293 -> 679
    //   389: astore 9
    //   391: aconst_null
    //   392: astore 8
    //   394: iconst_m1
    //   395: istore_3
    //   396: aload 9
    //   398: astore 10
    //   400: aload 8
    //   402: astore 9
    //   404: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq +58 -> 465
    //   410: aload 8
    //   412: astore 9
    //   414: new 24	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   421: astore 11
    //   423: aload 8
    //   425: astore 9
    //   427: aload 11
    //   429: ldc 245
    //   431: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 8
    //   437: astore 9
    //   439: aload 11
    //   441: aload 10
    //   443: invokevirtual 248	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   446: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 8
    //   452: astore 9
    //   454: ldc 153
    //   456: iconst_2
    //   457: aload 11
    //   459: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   465: iload_3
    //   466: istore 4
    //   468: aload 8
    //   470: ifnull +10 -> 480
    //   473: aload 8
    //   475: astore 10
    //   477: goto -119 -> 358
    //   480: iload 4
    //   482: iflt +19 -> 501
    //   485: aload_0
    //   486: new 250	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer
    //   489: dup
    //   490: invokespecial 251	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:<init>	()V
    //   493: putfield 161	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   496: iconst_1
    //   497: istore_2
    //   498: goto +62 -> 560
    //   501: aload_0
    //   502: new 253	com/tencent/mobileqq/qqaudio/audioplayer/AmrPlayer
    //   505: dup
    //   506: invokespecial 254	com/tencent/mobileqq/qqaudio/audioplayer/AmrPlayer:<init>	()V
    //   509: putfield 161	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   512: new 24	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   519: astore 8
    //   521: aload 8
    //   523: ldc_w 256
    //   526: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 8
    //   532: iload 4
    //   534: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 8
    //   540: ldc_w 258
    //   543: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: ldc 153
    //   549: iconst_1
    //   550: aload 8
    //   552: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   558: iconst_2
    //   559: istore_2
    //   560: iload_2
    //   561: invokestatic 264	com/tencent/mobileqq/qqaudio/QQAudioReporter:a	(I)V
    //   564: aload_0
    //   565: getfield 161	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   568: aload_1
    //   569: invokeinterface 265 2 0
    //   574: aload_0
    //   575: getfield 161	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   578: iload 5
    //   580: invokeinterface 267 2 0
    //   585: aload_0
    //   586: getfield 161	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   589: iconst_m1
    //   590: iload 4
    //   592: invokeinterface 270 3 0
    //   597: aload_0
    //   598: getfield 161	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   601: aload_0
    //   602: invokeinterface 273 2 0
    //   607: aload_0
    //   608: getfield 161	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   611: aload_0
    //   612: getfield 276	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_Float	F
    //   615: invokeinterface 279 2 0
    //   620: aload_0
    //   621: getfield 161	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   624: invokeinterface 280 1 0
    //   629: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   632: ifeq +40 -> 672
    //   635: new 24	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   642: astore_1
    //   643: aload_1
    //   644: ldc_w 282
    //   647: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload_1
    //   652: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   655: lload 6
    //   657: lsub
    //   658: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: ldc 153
    //   664: iconst_2
    //   665: aload_1
    //   666: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: aload_0
    //   673: invokespecial 284	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:m	()V
    //   676: iconst_1
    //   677: ireturn
    //   678: astore_1
    //   679: aload 9
    //   681: ifnull +8 -> 689
    //   684: aload 9
    //   686: invokevirtual 243	java/io/InputStream:close	()V
    //   689: aload_1
    //   690: athrow
    //   691: astore_1
    //   692: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   695: ifeq +13 -> 708
    //   698: ldc 153
    //   700: iconst_2
    //   701: ldc_w 286
    //   704: aload_1
    //   705: invokestatic 289	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   708: aload_0
    //   709: aload_0
    //   710: getfield 161	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   713: iconst_2
    //   714: iconst_0
    //   715: aload_1
    //   716: invokevirtual 290	java/lang/Exception:toString	()Ljava/lang/String;
    //   719: invokevirtual 291	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:a	(Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;IILjava/lang/String;)V
    //   722: iconst_0
    //   723: ireturn
    //   724: astore 8
    //   726: iload_3
    //   727: istore 4
    //   729: goto -249 -> 480
    //   732: astore 8
    //   734: goto -45 -> 689
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	737	0	this	CommonAudioPlayer
    //   0	737	1	paramString	String
    //   0	737	2	paramInt	int
    //   261	466	3	b1	byte
    //   257	471	4	b2	byte
    //   1	578	5	i	int
    //   13	643	6	l	long
    //   65	486	8	localObject1	Object
    //   724	1	8	localException1	java.lang.Exception
    //   732	1	8	localException2	java.lang.Exception
    //   250	89	9	localObject2	Object
    //   377	1	9	localException3	java.lang.Exception
    //   384	1	9	localObject3	Object
    //   389	8	9	localException4	java.lang.Exception
    //   402	283	9	localObject4	Object
    //   264	95	10	localObject5	Object
    //   369	1	10	localException5	java.lang.Exception
    //   398	78	10	localObject6	Object
    //   421	37	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   270	276	369	java/lang/Exception
    //   280	289	369	java/lang/Exception
    //   293	301	369	java/lang/Exception
    //   305	312	369	java/lang/Exception
    //   316	324	369	java/lang/Exception
    //   328	336	369	java/lang/Exception
    //   340	351	369	java/lang/Exception
    //   252	259	377	java/lang/Exception
    //   238	248	382	finally
    //   238	248	389	java/lang/Exception
    //   252	259	678	finally
    //   270	276	678	finally
    //   280	289	678	finally
    //   293	301	678	finally
    //   305	312	678	finally
    //   316	324	678	finally
    //   328	336	678	finally
    //   340	351	678	finally
    //   404	410	678	finally
    //   414	423	678	finally
    //   427	435	678	finally
    //   439	450	678	finally
    //   454	465	678	finally
    //   234	238	691	java/lang/Exception
    //   485	496	691	java/lang/Exception
    //   501	558	691	java/lang/Exception
    //   560	629	691	java/lang/Exception
    //   689	691	691	java/lang/Exception
    //   358	363	724	java/lang/Exception
    //   684	689	732	java/lang/Exception
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.a(this.jdField_a_of_type_AndroidMediaAudioManager);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.a();
  }
  
  public void c()
  {
    try
    {
      n();
      super.c();
      this.e = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.e = true;
    }
    super.d(paramInt);
  }
  
  public void f()
  {
    super.f();
    this.e = false;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.e(true);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.e(false);
  }
  
  public void k()
  {
    super.k();
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper.a();
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus = new AudioDeviceStatus();
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper = new AudioBluetoothSCOHelper(this.jdField_a_of_type_AndroidAppApplication);
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioBluetoothSCOHelper.a(this);
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioDeviceStatus.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer
 * JD-Core Version:    0.7.0.1
 */