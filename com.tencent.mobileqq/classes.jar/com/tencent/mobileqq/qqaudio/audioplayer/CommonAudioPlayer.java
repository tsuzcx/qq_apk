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
  volatile boolean a = false;
  private AudioDeviceStatus t;
  private AudioBluetoothSCOHelper u;
  private CommonAudioPlayer.UIAudioDeivceChangedListern v;
  private String w;
  
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
    ((StringBuilder)localObject).append(paramAudioDeviceStatusResult.b());
    localObject = ((StringBuilder)localObject).toString();
    this.t.a((String)localObject);
    int i = paramAudioDeviceStatusResult.b();
    boolean bool1 = false;
    boolean bool2;
    if ((i != 0) && (i != 1))
    {
      if ((i != 2) && (i != 3) && (i != 4)) {
        return;
      }
      localObject = this.v;
      if (localObject != null)
      {
        bool2 = this.t.e();
        boolean bool3 = this.t.f();
        boolean bool4 = this.t.d();
        if (paramAudioDeviceStatusResult.b() == 2) {
          bool1 = true;
        }
        ((CommonAudioPlayer.UIAudioDeivceChangedListern)localObject).a(bool2, bool3, bool4, bool1);
      }
    }
    else if (this.v != null)
    {
      bool1 = this.t.d();
      bool2 = this.t.g();
      if (bool2) {
        bool1 = false;
      }
      this.v.a(bool2, bool1);
    }
  }
  
  private void u()
  {
    String str = this.w;
    if (StringUtil.isEmpty(str)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(this.i.getPackageName());
    localIntent.setAction("mqq.audiosenormanager.audio.start");
    localIntent.putExtra("audiosenormanager.playkey", str);
    this.i.getApplicationContext().sendBroadcast(localIntent);
  }
  
  private void v()
  {
    String str = this.w;
    if (StringUtil.isEmpty(str)) {
      return;
    }
    this.w = null;
    Intent localIntent = new Intent();
    localIntent.setPackage(this.i.getPackageName());
    localIntent.setAction("mqq.audiosenormanager.audio.end");
    localIntent.putExtra("audiosenormanager.playkey", str);
    this.i.getApplicationContext().sendBroadcast(localIntent);
  }
  
  public void a()
  {
    this.u.a();
    super.a();
    this.a = false;
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
    this.t.a(paramInt, paramBoolean);
    AudioDeviceStatus.AudioDeviceStatusResult localAudioDeviceStatusResult = this.t.i();
    if (localAudioDeviceStatusResult != null)
    {
      boolean bool = m();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("before notifyUIDeviceStatusChanged status = ");
        localStringBuilder.append(localAudioDeviceStatusResult.b());
        localStringBuilder.append(" | isPlaying = ");
        localStringBuilder.append(bool);
        QLog.d("AudioPlayer_Common", 2, localStringBuilder.toString());
      }
      if (bool)
      {
        if (localAudioDeviceStatusResult.c())
        {
          localAudioDeviceStatusResult.d();
          d(this.g.h() - AudioPlayerHelper.a);
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
        p();
      }
    }
    else if (!paramBoolean)
    {
      p();
    }
  }
  
  public void a(CommonAudioPlayer.UIAudioDeivceChangedListern paramUIAudioDeivceChangedListern)
  {
    this.v = paramUIAudioDeivceChangedListern;
  }
  
  public void a(IAudioFilePlayer paramIAudioFilePlayer, int paramInt1, int paramInt2, String paramString)
  {
    this.u.a();
    super.a(paramIAudioFilePlayer, paramInt1, paramInt2, paramString);
    this.a = false;
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
    //   10: invokestatic 199	java/lang/System:currentTimeMillis	()J
    //   13: lstore 6
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 202	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:j	Ljava/lang/String;
    //   20: aload_0
    //   21: invokestatic 208	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   24: pop
    //   25: aload_0
    //   26: invokevirtual 211	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:r	()Z
    //   29: ifne +5 -> 34
    //   32: iconst_0
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 50	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:t	Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceStatus;
    //   38: invokevirtual 213	com/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceStatus:c	()V
    //   41: aload_0
    //   42: getfield 127	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:u	Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioBluetoothSCOHelper;
    //   45: aload_1
    //   46: iload 5
    //   48: invokevirtual 216	com/tencent/mobileqq/qqaudio/audioplayer/AudioBluetoothSCOHelper:a	(Ljava/lang/String;I)I
    //   51: istore_2
    //   52: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +38 -> 93
    //   58: new 26	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   65: astore 8
    //   67: aload 8
    //   69: ldc 218
    //   71: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 8
    //   77: iload_2
    //   78: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 157
    //   84: iconst_2
    //   85: aload 8
    //   87: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: iload_2
    //   94: ifne +10 -> 104
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 22	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:a	Z
    //   102: iconst_0
    //   103: ireturn
    //   104: iload_2
    //   105: iconst_2
    //   106: if_icmpne +10 -> 116
    //   109: aload_0
    //   110: iconst_0
    //   111: putfield 22	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:a	Z
    //   114: iconst_1
    //   115: ireturn
    //   116: aload_0
    //   117: getfield 221	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:h	Landroid/media/AudioManager;
    //   120: invokestatic 226	com/tencent/mobileqq/qqaudio/audioplayer/AudioDeviceHelper:a	(Landroid/media/AudioManager;)Z
    //   123: ifeq +78 -> 201
    //   126: aload_0
    //   127: getfield 127	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:u	Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioBluetoothSCOHelper;
    //   130: aload_1
    //   131: iload 5
    //   133: invokevirtual 228	com/tencent/mobileqq/qqaudio/audioplayer/AudioBluetoothSCOHelper:b	(Ljava/lang/String;I)I
    //   136: istore_2
    //   137: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +38 -> 178
    //   143: new 26	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   150: astore 8
    //   152: aload 8
    //   154: ldc 230
    //   156: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 8
    //   162: iload_2
    //   163: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: ldc 157
    //   169: iconst_2
    //   170: aload 8
    //   172: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: iload_2
    //   179: ifne +10 -> 189
    //   182: aload_0
    //   183: iconst_0
    //   184: putfield 22	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:a	Z
    //   187: iconst_0
    //   188: ireturn
    //   189: iload_2
    //   190: iconst_2
    //   191: if_icmpne +10 -> 201
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield 22	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:a	Z
    //   199: iconst_1
    //   200: ireturn
    //   201: new 26	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   208: astore 8
    //   210: aload 8
    //   212: aload_1
    //   213: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 8
    //   219: lload 6
    //   221: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_0
    //   226: aload 8
    //   228: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: putfield 80	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:w	Ljava/lang/String;
    //   234: aload_0
    //   235: invokevirtual 236	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:l	()V
    //   238: new 238	java/io/FileInputStream
    //   241: dup
    //   242: aload_1
    //   243: invokespecial 240	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   246: astore 8
    //   248: aload 8
    //   250: astore 9
    //   252: aload 8
    //   254: invokestatic 245	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Ljava/io/InputStream;)B
    //   257: istore 4
    //   259: iload 4
    //   261: istore_3
    //   262: aload 8
    //   264: astore 10
    //   266: aload 8
    //   268: astore 9
    //   270: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +85 -> 358
    //   276: aload 8
    //   278: astore 9
    //   280: new 26	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   287: astore 10
    //   289: aload 8
    //   291: astore 9
    //   293: aload 10
    //   295: ldc 247
    //   297: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 8
    //   303: astore 9
    //   305: aload 10
    //   307: aload_1
    //   308: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 8
    //   314: astore 9
    //   316: aload 10
    //   318: ldc 249
    //   320: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 8
    //   326: astore 9
    //   328: aload 10
    //   330: iload 4
    //   332: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 8
    //   338: astore 9
    //   340: ldc 157
    //   342: iconst_2
    //   343: aload 10
    //   345: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload 8
    //   353: astore 10
    //   355: iload 4
    //   357: istore_3
    //   358: aload 10
    //   360: invokevirtual 254	java/io/InputStream:close	()V
    //   363: iload_3
    //   364: istore 4
    //   366: goto +115 -> 481
    //   369: astore 10
    //   371: iload 4
    //   373: istore_3
    //   374: goto +26 -> 400
    //   377: astore 9
    //   379: goto +15 -> 394
    //   382: astore_1
    //   383: aconst_null
    //   384: astore 9
    //   386: goto +294 -> 680
    //   389: astore 9
    //   391: aconst_null
    //   392: astore 8
    //   394: iconst_m1
    //   395: istore_3
    //   396: aload 9
    //   398: astore 10
    //   400: aload 8
    //   402: astore 9
    //   404: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq +59 -> 466
    //   410: aload 8
    //   412: astore 9
    //   414: new 26	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   421: astore 11
    //   423: aload 8
    //   425: astore 9
    //   427: aload 11
    //   429: ldc_w 256
    //   432: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload 8
    //   438: astore 9
    //   440: aload 11
    //   442: aload 10
    //   444: invokevirtual 259	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   447: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload 8
    //   453: astore 9
    //   455: ldc 157
    //   457: iconst_2
    //   458: aload 11
    //   460: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: iload_3
    //   467: istore 4
    //   469: aload 8
    //   471: ifnull +10 -> 481
    //   474: aload 8
    //   476: astore 10
    //   478: goto -120 -> 358
    //   481: iload 4
    //   483: iflt +19 -> 502
    //   486: aload_0
    //   487: new 261	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer
    //   490: dup
    //   491: invokespecial 262	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:<init>	()V
    //   494: putfield 168	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   497: iconst_1
    //   498: istore_2
    //   499: goto +62 -> 561
    //   502: aload_0
    //   503: new 264	com/tencent/mobileqq/qqaudio/audioplayer/AmrPlayer
    //   506: dup
    //   507: invokespecial 265	com/tencent/mobileqq/qqaudio/audioplayer/AmrPlayer:<init>	()V
    //   510: putfield 168	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   513: new 26	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   520: astore 8
    //   522: aload 8
    //   524: ldc_w 267
    //   527: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload 8
    //   533: iload 4
    //   535: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload 8
    //   541: ldc_w 269
    //   544: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: ldc 157
    //   550: iconst_1
    //   551: aload 8
    //   553: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: iconst_2
    //   560: istore_2
    //   561: iload_2
    //   562: invokestatic 275	com/tencent/mobileqq/qqaudio/QQAudioReporter:a	(I)V
    //   565: aload_0
    //   566: getfield 168	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   569: aload_1
    //   570: invokeinterface 276 2 0
    //   575: aload_0
    //   576: getfield 168	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   579: iload 5
    //   581: invokeinterface 278 2 0
    //   586: aload_0
    //   587: getfield 168	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   590: iconst_m1
    //   591: iload 4
    //   593: invokeinterface 281 3 0
    //   598: aload_0
    //   599: getfield 168	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   602: aload_0
    //   603: invokeinterface 284 2 0
    //   608: aload_0
    //   609: getfield 168	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   612: aload_0
    //   613: getfield 287	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:e	F
    //   616: invokeinterface 290 2 0
    //   621: aload_0
    //   622: getfield 168	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   625: invokeinterface 291 1 0
    //   630: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   633: ifeq +40 -> 673
    //   636: new 26	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   643: astore_1
    //   644: aload_1
    //   645: ldc_w 293
    //   648: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload_1
    //   653: invokestatic 199	java/lang/System:currentTimeMillis	()J
    //   656: lload 6
    //   658: lsub
    //   659: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: ldc 157
    //   665: iconst_2
    //   666: aload_1
    //   667: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   673: aload_0
    //   674: invokespecial 295	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:u	()V
    //   677: iconst_1
    //   678: ireturn
    //   679: astore_1
    //   680: aload 9
    //   682: ifnull +8 -> 690
    //   685: aload 9
    //   687: invokevirtual 254	java/io/InputStream:close	()V
    //   690: aload_1
    //   691: athrow
    //   692: astore_1
    //   693: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   696: ifeq +13 -> 709
    //   699: ldc 157
    //   701: iconst_2
    //   702: ldc_w 297
    //   705: aload_1
    //   706: invokestatic 300	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   709: aload_0
    //   710: aload_0
    //   711: getfield 168	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:g	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   714: iconst_2
    //   715: iconst_0
    //   716: aload_1
    //   717: invokevirtual 301	java/lang/Exception:toString	()Ljava/lang/String;
    //   720: invokevirtual 302	com/tencent/mobileqq/qqaudio/audioplayer/CommonAudioPlayer:a	(Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;IILjava/lang/String;)V
    //   723: iconst_0
    //   724: ireturn
    //   725: astore 8
    //   727: iload_3
    //   728: istore 4
    //   730: goto -249 -> 481
    //   733: astore 8
    //   735: goto -45 -> 690
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	738	0	this	CommonAudioPlayer
    //   0	738	1	paramString	String
    //   0	738	2	paramInt	int
    //   261	467	3	b1	byte
    //   257	472	4	b2	byte
    //   1	579	5	i	int
    //   13	644	6	l	long
    //   65	487	8	localObject1	Object
    //   725	1	8	localException1	java.lang.Exception
    //   733	1	8	localException2	java.lang.Exception
    //   250	89	9	localObject2	Object
    //   377	1	9	localException3	java.lang.Exception
    //   384	1	9	localObject3	Object
    //   389	8	9	localException4	java.lang.Exception
    //   402	284	9	localObject4	Object
    //   264	95	10	localObject5	Object
    //   369	1	10	localException5	java.lang.Exception
    //   398	79	10	localObject6	Object
    //   421	38	11	localStringBuilder	StringBuilder
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
    //   252	259	679	finally
    //   270	276	679	finally
    //   280	289	679	finally
    //   293	301	679	finally
    //   305	312	679	finally
    //   316	324	679	finally
    //   328	336	679	finally
    //   340	351	679	finally
    //   404	410	679	finally
    //   414	423	679	finally
    //   427	436	679	finally
    //   440	451	679	finally
    //   455	466	679	finally
    //   234	238	692	java/lang/Exception
    //   486	497	692	java/lang/Exception
    //   502	559	692	java/lang/Exception
    //   561	630	692	java/lang/Exception
    //   690	692	692	java/lang/Exception
    //   358	363	725	java/lang/Exception
    //   685	690	733	java/lang/Exception
  }
  
  public void b()
  {
    this.t.a(this.h);
  }
  
  protected AudioPlayerHelper.AudioPlayerParameter c()
  {
    return this.t.h();
  }
  
  public void d()
  {
    try
    {
      v();
      super.d();
      this.a = false;
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
    if (this.j != null) {
      this.a = true;
    }
    super.d(paramInt);
  }
  
  public void j()
  {
    super.j();
    this.a = false;
  }
  
  public boolean m()
  {
    return (super.m()) || (this.a);
  }
  
  public void n()
  {
    this.t.e(true);
  }
  
  public void o()
  {
    this.t.e(false);
  }
  
  public void q()
  {
    super.q();
    this.u.a();
  }
  
  public void s()
  {
    this.t = new AudioDeviceStatus();
    this.u = new AudioBluetoothSCOHelper(this.i);
    this.u.a(this);
    this.t.b();
  }
  
  public int t()
  {
    return this.t.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer
 * JD-Core Version:    0.7.0.1
 */