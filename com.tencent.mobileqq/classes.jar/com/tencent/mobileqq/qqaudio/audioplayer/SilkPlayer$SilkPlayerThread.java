package com.tencent.mobileqq.qqaudio.audioplayer;

import android.app.Application;
import android.media.AudioTrack;
import com.tencent.mobileqq.ptt.pttspeed.Sonic;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;

class SilkPlayer$SilkPlayerThread
  extends Thread
{
  int a;
  int b;
  private SilkCodecWrapper c;
  private byte[] d;
  private byte[] e;
  private volatile boolean f = false;
  private AudioTrack g;
  private int h;
  private int i;
  
  public SilkPlayer$SilkPlayerThread(SilkPlayer paramSilkPlayer, Application paramApplication)
  {
    this.i = QQAudioUtils.a(SilkPlayer.a(paramSilkPlayer));
    this.c = new SilkCodecWrapper(paramApplication, false);
    this.h = QQAudioUtils.a(this.i);
    int j = this.h;
    this.d = new byte[j];
    this.e = new byte[j];
    if (QLog.isColorLevel())
    {
      paramSilkPlayer = new StringBuilder();
      paramSilkPlayer.append("SilkPlayerThread sampleRate=");
      paramSilkPlayer.append(this.i);
      paramSilkPlayer.append(", oneFrameSize=");
      paramSilkPlayer.append(this.h);
      paramSilkPlayer.append(", currenttime:");
      paramSilkPlayer.append(System.currentTimeMillis());
      QLog.d("SilkPlayer", 2, paramSilkPlayer.toString());
    }
  }
  
  private FileInputStream a()
  {
    if (SilkPlayer.g(this.this$0) != -1) {
      if (SilkPlayer.g(this.this$0) == this.this$0.h())
      {
        this.b = SilkPlayer.f(this.this$0);
        this.a = SilkPlayer.f(this.this$0);
        SilkPlayer.a(this.this$0, -1);
      }
      else
      {
        SilkPlayer.b(this.this$0, 0);
        SilkPlayer.c(this.this$0, 0);
      }
    }
    FileInputStream localFileInputStream = new FileInputStream(SilkPlayer.h(this.this$0));
    int j = this.b;
    if (j == 0)
    {
      localFileInputStream.skip(10L);
      this.a += 10;
      return localFileInputStream;
    }
    localFileInputStream.skip(j);
    return localFileInputStream;
  }
  
  private void a(int paramInt)
  {
    try
    {
      SilkPlayer.c(this.this$0, paramInt);
      SilkPlayer.j(this.this$0);
      if (SilkPlayer.g(this.this$0) == -1) {
        this.this$0.c(SilkPlayer.e(this.this$0) * 20);
      }
      if ((SilkPlayer.g(this.this$0) != -1) && (this.this$0.h() >= SilkPlayer.g(this.this$0))) {
        SilkPlayer.a(this.this$0, -1);
      }
      return;
    }
    finally {}
  }
  
  private void a(Sonic paramSonic, int paramInt, byte[] paramArrayOfByte)
  {
    if ((SonicHelper.a(SilkPlayer.b(this.this$0))) && (paramArrayOfByte != null) && (SonicHelper.a()))
    {
      if (paramInt > 0) {
        paramSonic.a(this.e, paramInt);
      } else {
        paramSonic.b();
      }
      paramInt = paramSonic.c();
      if (paramInt > 0)
      {
        byte[] arrayOfByte = paramArrayOfByte;
        if (paramArrayOfByte.length < paramInt) {
          arrayOfByte = new byte[paramInt * 2];
        }
        paramSonic.b(arrayOfByte, paramInt);
        this.g.write(arrayOfByte, 0, paramInt);
      }
    }
    else
    {
      this.g.write(this.e, 0, this.h);
      if (SilkPlayer.i(this.this$0) != null) {
        SilkPlayer.i(this.this$0).a(this.e);
      }
    }
  }
  
  private void a(boolean paramBoolean, FileInputStream paramFileInputStream)
  {
    this.f = false;
    AudioTrack localAudioTrack = this.g;
    if ((localAudioTrack != null) && (localAudioTrack.getState() != 0))
    {
      try
      {
        this.g.pause();
        this.g.flush();
        this.g.release();
        if (QLog.isColorLevel()) {
          QLog.d("SilkPlayer", 2, "SilkPlayerThread onEnd, release mAudioTrack.");
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.g = null;
    }
    this.c.c();
    if (paramBoolean) {
      this.this$0.b();
    }
    if (paramFileInputStream != null) {
      try
      {
        paramFileInputStream.close();
        return;
      }
      catch (IOException paramFileInputStream)
      {
        paramFileInputStream.printStackTrace();
      }
    }
  }
  
  private boolean a(FileInputStream paramFileInputStream, int paramInt, Sonic paramSonic, byte[] paramArrayOfByte)
  {
    if (SilkPlayer.g(this.this$0) == -1)
    {
      int j = paramFileInputStream.read(this.d, 0, paramInt);
      this.a += paramInt;
      if (j == -1)
      {
        paramFileInputStream = this.this$0;
        paramSonic = new StringBuilder();
        paramSonic.append("silk decode error: failed to read frameSize=");
        paramSonic.append(paramInt);
        paramFileInputStream.a(2, 6, paramSonic.toString());
        if (QLog.isColorLevel())
        {
          paramFileInputStream = new StringBuilder();
          paramFileInputStream.append("silk decode error: failed to read frameSize=");
          paramFileInputStream.append(paramInt);
          QLog.d("SilkPlayer", 2, paramFileInputStream.toString());
        }
        return false;
      }
      if (!this.f) {
        return false;
      }
      paramFileInputStream = this.c;
      byte[] arrayOfByte1 = this.d;
      byte[] arrayOfByte2 = this.e;
      paramInt = paramFileInputStream.a(arrayOfByte1, arrayOfByte2, paramInt, arrayOfByte2.length);
      if (paramInt == 0)
      {
        this.this$0.a(3, 7, "silk decode jni error ret = 0");
        if (QLog.isColorLevel()) {
          QLog.d("SilkPlayer", 2, "silk decode jni error");
        }
        return false;
      }
      if (this.f) {
        a(paramSonic, paramInt, paramArrayOfByte);
      }
      return true;
    }
    this.a += paramInt;
    paramFileInputStream.skip(paramInt);
    return true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_2
    //   1: newarray byte
    //   3: astore 11
    //   5: iconst_0
    //   6: istore 5
    //   8: iconst_0
    //   9: istore 4
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 111	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:a	I
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 109	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:b	I
    //   21: bipush 237
    //   23: invokestatic 234	android/os/Process:setThreadPriority	(I)V
    //   26: aconst_null
    //   27: astore 6
    //   29: aconst_null
    //   30: astore 7
    //   32: aload_0
    //   33: getfield 48	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:c	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
    //   36: aload_0
    //   37: getfield 41	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:i	I
    //   40: iconst_0
    //   41: iconst_1
    //   42: invokevirtual 237	com/tencent/mobileqq/utils/SilkCodecWrapper:a	(III)V
    //   45: aload_0
    //   46: getfield 24	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;
    //   49: invokestatic 144	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:b	(Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;)F
    //   52: invokestatic 149	com/tencent/mobileqq/qqaudio/audioplayer/sonic/SonicHelper:a	(F)Z
    //   55: ifeq +766 -> 821
    //   58: invokestatic 151	com/tencent/mobileqq/qqaudio/audioplayer/sonic/SonicHelper:a	()Z
    //   61: ifeq +760 -> 821
    //   64: new 153	com/tencent/mobileqq/ptt/pttspeed/Sonic
    //   67: dup
    //   68: aload_0
    //   69: getfield 41	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:i	I
    //   72: iconst_1
    //   73: invokespecial 240	com/tencent/mobileqq/ptt/pttspeed/Sonic:<init>	(II)V
    //   76: astore 8
    //   78: aload 8
    //   80: aload_0
    //   81: getfield 24	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;
    //   84: invokestatic 144	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:b	(Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;)F
    //   87: invokevirtual 243	com/tencent/mobileqq/ptt/pttspeed/Sonic:a	(F)V
    //   90: sipush 2048
    //   93: newarray byte
    //   95: astore 9
    //   97: goto +3 -> 100
    //   100: aload_0
    //   101: getfield 24	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;
    //   104: invokestatic 246	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:c	(Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;)Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayerListener;
    //   107: ifnull +15 -> 122
    //   110: aload_0
    //   111: getfield 24	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;
    //   114: invokestatic 246	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:c	(Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;)Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayerListener;
    //   117: invokeinterface 250 1 0
    //   122: aload_0
    //   123: getfield 41	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:i	I
    //   126: iconst_4
    //   127: iconst_2
    //   128: invokestatic 254	android/media/AudioTrack:getMinBufferSize	(III)I
    //   131: istore_1
    //   132: aload 7
    //   134: astore 6
    //   136: aload_0
    //   137: new 256	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportAudioTrack
    //   140: dup
    //   141: aload_0
    //   142: getfield 24	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;
    //   145: invokestatic 258	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:d	(Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;)I
    //   148: aload_0
    //   149: getfield 41	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:i	I
    //   152: iconst_4
    //   153: iconst_2
    //   154: iload_1
    //   155: iconst_1
    //   156: invokespecial 261	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportAudioTrack:<init>	(IIIIII)V
    //   159: putfield 165	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:g	Landroid/media/AudioTrack;
    //   162: aload 7
    //   164: astore 6
    //   166: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +138 -> 307
    //   172: aload 7
    //   174: astore 6
    //   176: new 65	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   183: astore 10
    //   185: aload 7
    //   187: astore 6
    //   189: aload 10
    //   191: ldc_w 263
    //   194: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 7
    //   200: astore 6
    //   202: aload 10
    //   204: aload_0
    //   205: getfield 24	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;
    //   208: invokestatic 258	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:d	(Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;)I
    //   211: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 7
    //   217: astore 6
    //   219: aload 10
    //   221: ldc_w 265
    //   224: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 7
    //   230: astore 6
    //   232: aload 10
    //   234: aload_0
    //   235: getfield 41	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:i	I
    //   238: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 7
    //   244: astore 6
    //   246: aload 10
    //   248: ldc_w 267
    //   251: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 7
    //   257: astore 6
    //   259: aload 10
    //   261: iload_1
    //   262: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 7
    //   268: astore 6
    //   270: aload 10
    //   272: ldc_w 269
    //   275: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 7
    //   281: astore 6
    //   283: aload 10
    //   285: invokestatic 85	java/lang/System:currentTimeMillis	()J
    //   288: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 7
    //   294: astore 6
    //   296: ldc 90
    //   298: iconst_2
    //   299: aload 10
    //   301: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aload 7
    //   309: astore 6
    //   311: aload_0
    //   312: getfield 165	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:g	Landroid/media/AudioTrack;
    //   315: invokevirtual 272	android/media/AudioTrack:play	()V
    //   318: aload 7
    //   320: astore 6
    //   322: aload_0
    //   323: invokespecial 274	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:a	()Ljava/io/FileInputStream;
    //   326: astore 7
    //   328: aload 7
    //   330: astore 6
    //   332: iload 5
    //   334: istore_3
    //   335: aload 7
    //   337: astore 10
    //   339: aload_0
    //   340: getfield 29	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:f	Z
    //   343: ifeq +470 -> 813
    //   346: iload 5
    //   348: istore_3
    //   349: aload 7
    //   351: astore 10
    //   353: aload 7
    //   355: ifnull +458 -> 813
    //   358: aload 7
    //   360: astore 6
    //   362: aload 7
    //   364: aload 11
    //   366: iconst_0
    //   367: iconst_2
    //   368: invokevirtual 214	java/io/FileInputStream:read	([BII)I
    //   371: istore_2
    //   372: aload 7
    //   374: astore 6
    //   376: aload_0
    //   377: aload_0
    //   378: getfield 111	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:a	I
    //   381: iconst_2
    //   382: iadd
    //   383: putfield 111	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:a	I
    //   386: iload_2
    //   387: iconst_m1
    //   388: if_icmpne +93 -> 481
    //   391: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +67 -> 461
    //   397: new 65	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   404: astore 6
    //   406: aload 6
    //   408: ldc_w 276
    //   411: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 6
    //   417: aload_0
    //   418: getfield 24	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;
    //   421: invokestatic 138	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:e	(Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;)I
    //   424: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 6
    //   430: ldc_w 278
    //   433: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 6
    //   439: aload_0
    //   440: getfield 24	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;
    //   443: invokestatic 107	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:f	(Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;)I
    //   446: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: ldc 90
    //   452: iconst_2
    //   453: aload 6
    //   455: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: iconst_1
    //   462: istore_3
    //   463: aload 7
    //   465: astore 10
    //   467: goto +346 -> 813
    //   470: astore 8
    //   472: iconst_1
    //   473: istore_3
    //   474: aload 7
    //   476: astore 6
    //   478: goto +259 -> 737
    //   481: aload 7
    //   483: astore 6
    //   485: aload_0
    //   486: getfield 29	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:f	Z
    //   489: ifne +13 -> 502
    //   492: iload 5
    //   494: istore_3
    //   495: aload 7
    //   497: astore 10
    //   499: goto +314 -> 813
    //   502: aload 7
    //   504: astore 6
    //   506: aload 11
    //   508: invokestatic 281	com/tencent/mobileqq/qqaudio/QQAudioUtils:b	([B)I
    //   511: istore_2
    //   512: iload_2
    //   513: ifgt +145 -> 658
    //   516: aload 7
    //   518: astore 6
    //   520: aload_0
    //   521: getfield 24	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;
    //   524: astore 8
    //   526: aload 7
    //   528: astore 6
    //   530: new 65	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   537: astore 9
    //   539: aload 7
    //   541: astore 6
    //   543: aload 9
    //   545: ldc_w 283
    //   548: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload 7
    //   554: astore 6
    //   556: aload 9
    //   558: iload_2
    //   559: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload 7
    //   565: astore 6
    //   567: aload 8
    //   569: iconst_1
    //   570: iconst_4
    //   571: aload 9
    //   573: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokevirtual 219	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:a	(IILjava/lang/String;)V
    //   579: aload 7
    //   581: astore 6
    //   583: iload 5
    //   585: istore_3
    //   586: aload 7
    //   588: astore 10
    //   590: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   593: ifeq +220 -> 813
    //   596: aload 7
    //   598: astore 6
    //   600: new 65	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   607: astore 8
    //   609: aload 7
    //   611: astore 6
    //   613: aload 8
    //   615: ldc_w 283
    //   618: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload 7
    //   624: astore 6
    //   626: aload 8
    //   628: iload_2
    //   629: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 7
    //   635: astore 6
    //   637: ldc 90
    //   639: iconst_2
    //   640: aload 8
    //   642: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: iload 5
    //   650: istore_3
    //   651: aload 7
    //   653: astore 10
    //   655: goto +158 -> 813
    //   658: aload 7
    //   660: astore 6
    //   662: aload_0
    //   663: getfield 29	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:f	Z
    //   666: ifne +13 -> 679
    //   669: iload 5
    //   671: istore_3
    //   672: aload 7
    //   674: astore 10
    //   676: goto +137 -> 813
    //   679: aload 7
    //   681: astore 6
    //   683: aload_0
    //   684: aload 7
    //   686: iload_2
    //   687: aload 8
    //   689: aload 9
    //   691: invokespecial 285	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:a	(Ljava/io/FileInputStream;ILcom/tencent/mobileqq/ptt/pttspeed/Sonic;[B)Z
    //   694: ifne +13 -> 707
    //   697: iload 5
    //   699: istore_3
    //   700: aload 7
    //   702: astore 10
    //   704: goto +109 -> 813
    //   707: aload 7
    //   709: astore 6
    //   711: aload_0
    //   712: aload_0
    //   713: getfield 111	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:a	I
    //   716: invokespecial 287	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:a	(I)V
    //   719: goto -391 -> 328
    //   722: astore 8
    //   724: iload 4
    //   726: istore_3
    //   727: goto +10 -> 737
    //   730: astore 8
    //   732: iconst_0
    //   733: istore_1
    //   734: iload 4
    //   736: istore_3
    //   737: new 65	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   744: astore 7
    //   746: aload 7
    //   748: ldc_w 289
    //   751: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: aload 7
    //   757: aload 8
    //   759: invokevirtual 290	java/lang/Exception:toString	()Ljava/lang/String;
    //   762: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: ldc 90
    //   768: iconst_1
    //   769: aload 7
    //   771: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: aload_0
    //   778: getfield 24	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;
    //   781: aload 8
    //   783: aload_0
    //   784: getfield 165	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:g	Landroid/media/AudioTrack;
    //   787: aload_0
    //   788: getfield 41	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:i	I
    //   791: iload_1
    //   792: invokevirtual 295	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:a	(Ljava/lang/Exception;Landroid/media/AudioTrack;II)V
    //   795: aload_0
    //   796: getfield 24	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer;
    //   799: iconst_4
    //   800: iconst_5
    //   801: aload 8
    //   803: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   806: invokevirtual 219	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:a	(IILjava/lang/String;)V
    //   809: aload 6
    //   811: astore 10
    //   813: aload_0
    //   814: iload_3
    //   815: aload 10
    //   817: invokespecial 300	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer$SilkPlayerThread:a	(ZLjava/io/FileInputStream;)V
    //   820: return
    //   821: aconst_null
    //   822: astore 8
    //   824: aload 8
    //   826: astore 9
    //   828: goto -728 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	831	0	this	SilkPlayerThread
    //   131	661	1	j	int
    //   371	316	2	k	int
    //   334	481	3	bool1	boolean
    //   9	726	4	bool2	boolean
    //   6	692	5	bool3	boolean
    //   27	783	6	localObject1	Object
    //   30	740	7	localObject2	Object
    //   76	3	8	localSonic	Sonic
    //   470	1	8	localException1	Exception
    //   524	164	8	localObject3	Object
    //   722	1	8	localException2	Exception
    //   730	72	8	localException3	Exception
    //   822	3	8	localObject4	Object
    //   95	732	9	localObject5	Object
    //   183	633	10	localObject6	Object
    //   3	504	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   391	461	470	java/lang/Exception
    //   136	162	722	java/lang/Exception
    //   166	172	722	java/lang/Exception
    //   176	185	722	java/lang/Exception
    //   189	198	722	java/lang/Exception
    //   202	215	722	java/lang/Exception
    //   219	228	722	java/lang/Exception
    //   232	242	722	java/lang/Exception
    //   246	255	722	java/lang/Exception
    //   259	266	722	java/lang/Exception
    //   270	279	722	java/lang/Exception
    //   283	292	722	java/lang/Exception
    //   296	307	722	java/lang/Exception
    //   311	318	722	java/lang/Exception
    //   322	328	722	java/lang/Exception
    //   339	346	722	java/lang/Exception
    //   362	372	722	java/lang/Exception
    //   376	386	722	java/lang/Exception
    //   485	492	722	java/lang/Exception
    //   506	512	722	java/lang/Exception
    //   520	526	722	java/lang/Exception
    //   530	539	722	java/lang/Exception
    //   543	552	722	java/lang/Exception
    //   556	563	722	java/lang/Exception
    //   567	579	722	java/lang/Exception
    //   590	596	722	java/lang/Exception
    //   600	609	722	java/lang/Exception
    //   613	622	722	java/lang/Exception
    //   626	633	722	java/lang/Exception
    //   637	648	722	java/lang/Exception
    //   662	669	722	java/lang/Exception
    //   683	697	722	java/lang/Exception
    //   711	719	722	java/lang/Exception
    //   32	97	730	java/lang/Exception
    //   100	122	730	java/lang/Exception
    //   122	132	730	java/lang/Exception
  }
  
  public void start()
  {
    this.f = true;
    super.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.SilkPlayer.SilkPlayerThread
 * JD-Core Version:    0.7.0.1
 */