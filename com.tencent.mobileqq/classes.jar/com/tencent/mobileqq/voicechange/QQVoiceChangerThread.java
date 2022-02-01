package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioCompositeProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessorListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class QQVoiceChangerThread
  extends Thread
  implements IAudioProcessorListener
{
  public volatile boolean a = true;
  int b = 0;
  int c = 0;
  int d = 0;
  public String e;
  VoiceChangeBasicParams f;
  VoiceChangeModeParams g;
  IVoiceChangeListener h;
  private Context i;
  private String j;
  private FileInputStream k = null;
  private FileOutputStream l = null;
  private AudioCompositeProcessor m;
  private AudioTrack n = null;
  private boolean o = false;
  private byte[] p = new byte[960];
  
  public QQVoiceChangerThread(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, VoiceChangeModeParams paramVoiceChangeModeParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener)
  {
    this.i = paramContext;
    this.j = paramVoiceChangeBasicParams.a;
    this.f = paramVoiceChangeBasicParams;
    this.g = paramVoiceChangeModeParams;
    this.e = paramString;
    this.h = paramIVoiceChangeListener;
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("new QQVoiceChangerThread filePath=");
      paramContext.append(this.j);
      paramContext.append(" sampleRate=");
      paramContext.append(paramVoiceChangeBasicParams.c);
      paramContext.append(" bitRate=");
      paramContext.append(paramVoiceChangeBasicParams.e);
      paramContext.append(" voiceType=");
      paramContext.append(paramVoiceChangeBasicParams.f);
      paramContext.append(" changeType=");
      paramContext.append(paramVoiceChangeBasicParams.g);
      QLog.d("QQVoiceChanger", 2, paramContext.toString());
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = (int)AudioHelper.a(this.i, paramArrayOfByte, paramInt, 1.0F);
    IVoiceChangeListener localIVoiceChangeListener = this.h;
    if (localIVoiceChangeListener != null) {
      localIVoiceChangeListener.onSlicePlayed(i1, this.d * 100 / this.c, this.b);
    }
    this.n.write(paramArrayOfByte, 0, paramInt);
  }
  
  private void e()
  {
    Object localObject = this.g.f;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.j = ((String)localObject);
    } else {
      this.j = ((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).renameFileToPcm(this.j);
    }
    this.k = new FileInputStream(this.j);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("open:");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append(" a=");
      ((StringBuilder)localObject).append(this.k.available());
      QLog.d("QQVoiceChanger", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void f()
  {
    Object localObject = this.n;
    if (localObject != null) {
      ((AudioTrack)localObject).release();
    }
    localObject = this.m;
    if (localObject != null) {
      ((AudioCompositeProcessor)localObject).a();
    }
    localObject = this.k;
    if (localObject != null) {
      ((FileInputStream)localObject).close();
    }
    localObject = this.l;
    if (localObject != null) {
      ((FileOutputStream)localObject).close();
    }
    if (this.o) {
      ((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).deleteAllFiles(this.f.a, this.j);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clean up requestToCancel=");
      ((StringBuilder)localObject).append(this.o);
      QLog.d("QQVoiceChanger", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void a()
  {
    int i1 = AudioTrack.getMinBufferSize(this.f.c, this.f.b, this.f.d);
    this.n = new ReportAudioTrack(3, this.f.c, 4, 2, i1, 1);
    this.n.play();
  }
  
  protected void a(int paramInt)
  {
    File localFile = new File(((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).getChangedSoundFilePath(this.f.a, paramInt));
    localFile.createNewFile();
    this.l = new FileOutputStream(localFile);
  }
  
  public void a(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    if (((paramIAudioProcessor instanceof SilkCodecWrapper)) || ((paramIAudioProcessor instanceof AmrInputStreamWrapper)))
    {
      this.b += (int)((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getMillisecond(this.f.c, 4, 2, paramProcessData.a);
      if (this.g.a) {
        a(paramProcessData.c, paramProcessData.a);
      }
    }
  }
  
  protected void b()
  {
    this.c = this.k.available();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start progress totalSize=");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append(" filePath=");
      ((StringBuilder)localObject1).append(this.j);
      ((StringBuilder)localObject1).append("pcmFilePath=");
      ((StringBuilder)localObject1).append(this.f.a);
      QLog.d("QQVoiceChanger", 2, ((StringBuilder)localObject1).toString());
    }
    int i3 = 0;
    int i1 = 0;
    for (;;)
    {
      if (this.a)
      {
        int i2 = i3;
        if (this.g.e)
        {
          i2 = i3;
          if (i3 == 0)
          {
            if (this.f.f == 0)
            {
              this.k.skip(6);
            }
            else if (this.f.f == 1)
            {
              this.k.skip(10L);
            }
            else if (this.f.f == 2)
            {
              i2 = this.k.read(this.p, 0, 64);
              if (i2 == 64)
              {
                localObject1 = this.l;
                if (localObject1 != null)
                {
                  ((FileOutputStream)localObject1).write(this.p, 0, i2);
                  this.l.flush();
                  break label254;
                }
              }
              if (!QLog.isColorLevel()) {
                break label659;
              }
              QLog.d("QQVoiceChanger", 2, "copy AFPCM failed!");
              break label659;
            }
            label254:
            i2 = 1;
          }
        }
        try
        {
          i3 = this.k.read(this.p, 0, 960);
          if (i3 == -1)
          {
            this.a = false;
            localObject1 = this.h;
            if (localObject1 != null) {
              ((IVoiceChangeListener)localObject1).onPlayEnd();
            }
            ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(4, this.b);
            ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).voiceChangeEnd(this.b, this.f.a, this.j, this.f.g, this.f.f);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("finishedCompress playedTime=");
              ((StringBuilder)localObject1).append(this.b);
              QLog.d("QQVoiceChanger", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            this.d += i3;
            localObject1 = this.m.a(this.p, 0, i3);
            ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).noteOneFrameProcessed();
            if ((this.l != null) && (this.g.c))
            {
              int i4 = i1;
              if (i1 == 0)
              {
                localObject2 = RecordParams.a(this.f.f, this.f.c);
                this.l.write((byte[])localObject2, 0, localObject2.length);
                this.l.flush();
                i4 = 1;
              }
              i3 = i2;
              i1 = i4;
              if (localObject1 == null) {
                continue;
              }
              this.l.write(((IAudioProcessor.ProcessData)localObject1).c, 0, ((IAudioProcessor.ProcessData)localObject1).a);
              this.l.flush();
              i3 = i2;
              i1 = i4;
              continue;
            }
            localObject2 = this.l;
            i3 = i2;
            if (localObject2 == null) {
              continue;
            }
            i3 = i2;
            if (localObject1 == null) {
              continue;
            }
            ((FileOutputStream)localObject2).write(((IAudioProcessor.ProcessData)localObject1).c, 0, ((IAudioProcessor.ProcessData)localObject1).a);
            this.l.flush();
            i3 = i2;
          }
        }
        catch (IOException localIOException)
        {
          Object localObject2;
          localIOException.printStackTrace();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("read failed");
            ((StringBuilder)localObject2).append(localIOException.getStackTrace());
            QLog.d("QQVoiceChanger", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
    }
    label659:
    IVoiceChangeListener localIVoiceChangeListener = this.h;
    if (localIVoiceChangeListener != null) {
      localIVoiceChangeListener.onPlayStop();
    }
  }
  
  public void b(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    if (((paramIAudioProcessor instanceof VoiceChange)) && (!this.g.c) && (this.g.a)) {
      a(paramProcessData.c, paramProcessData.a);
    }
  }
  
  public void c()
  {
    this.g.a = false;
    this.h = null;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestToSend isRunning=");
      localStringBuilder.append(this.a);
      QLog.d("QQVoiceChanger", 2, localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    if (!this.a) {
      ((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).deleteAllFilesOnExit(this.f.a, this.j);
    }
    this.h = null;
    this.a = false;
    this.o = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestToCancel isRunning=");
      localStringBuilder.append(this.a);
      QLog.d("QQVoiceChanger", 2, localStringBuilder.toString());
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 237
    //   2: invokestatic 330	android/os/Process:setThreadPriority	(I)V
    //   5: aload_0
    //   6: new 176	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor
    //   9: dup
    //   10: invokespecial 331	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:<init>	()V
    //   13: putfield 174	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:m	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   16: aload_0
    //   17: getfield 67	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   20: getfield 106	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:g	I
    //   23: ifne +11 -> 34
    //   26: aload_0
    //   27: getfield 69	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:g	Lcom/tencent/mobileqq/voicechange/VoiceChangeModeParams;
    //   30: iconst_0
    //   31: putfield 333	com/tencent/mobileqq/voicechange/VoiceChangeModeParams:d	Z
    //   34: aload_0
    //   35: getfield 69	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:g	Lcom/tencent/mobileqq/voicechange/VoiceChangeModeParams;
    //   38: getfield 333	com/tencent/mobileqq/voicechange/VoiceChangeModeParams:d	Z
    //   41: ifeq +32 -> 73
    //   44: aload_0
    //   45: getfield 174	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:m	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   48: new 315	com/tencent/mobileqq/voicechange/VoiceChange
    //   51: dup
    //   52: aload_0
    //   53: getfield 59	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:i	Landroid/content/Context;
    //   56: aload_0
    //   57: getfield 67	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   60: getfield 106	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:g	I
    //   63: aload_0
    //   64: getfield 71	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:e	Ljava/lang/String;
    //   67: invokespecial 336	com/tencent/mobileqq/voicechange/VoiceChange:<init>	(Landroid/content/Context;ILjava/lang/String;)V
    //   70: invokevirtual 339	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor;)V
    //   73: aload_0
    //   74: getfield 69	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:g	Lcom/tencent/mobileqq/voicechange/VoiceChangeModeParams;
    //   77: getfield 341	com/tencent/mobileqq/voicechange/VoiceChangeModeParams:b	Z
    //   80: ifeq +29 -> 109
    //   83: new 343	com/tencent/mobileqq/utils/WechatNsWrapper
    //   86: dup
    //   87: aload_0
    //   88: getfield 59	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:i	Landroid/content/Context;
    //   91: invokespecial 346	com/tencent/mobileqq/utils/WechatNsWrapper:<init>	(Landroid/content/Context;)V
    //   94: astore_1
    //   95: getstatic 348	com/tencent/mobileqq/utils/WechatNsWrapper:j	Z
    //   98: ifeq +11 -> 109
    //   101: aload_0
    //   102: getfield 174	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:m	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   105: aload_1
    //   106: invokevirtual 339	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor;)V
    //   109: aload_0
    //   110: getfield 69	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:g	Lcom/tencent/mobileqq/voicechange/VoiceChangeModeParams;
    //   113: getfield 293	com/tencent/mobileqq/voicechange/VoiceChangeModeParams:c	Z
    //   116: ifeq +52 -> 168
    //   119: aload_0
    //   120: getfield 67	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   123: getfield 102	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:f	I
    //   126: ifne +24 -> 150
    //   129: aload_0
    //   130: getfield 174	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:m	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   133: new 226	com/tencent/mobileqq/utils/AmrInputStreamWrapper
    //   136: dup
    //   137: aload_0
    //   138: getfield 59	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:i	Landroid/content/Context;
    //   141: invokespecial 349	com/tencent/mobileqq/utils/AmrInputStreamWrapper:<init>	(Landroid/content/Context;)V
    //   144: invokevirtual 339	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor;)V
    //   147: goto +21 -> 168
    //   150: aload_0
    //   151: getfield 174	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:m	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   154: new 224	com/tencent/mobileqq/utils/SilkCodecWrapper
    //   157: dup
    //   158: aload_0
    //   159: getfield 59	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:i	Landroid/content/Context;
    //   162: invokespecial 350	com/tencent/mobileqq/utils/SilkCodecWrapper:<init>	(Landroid/content/Context;)V
    //   165: invokevirtual 339	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor;)V
    //   168: aload_0
    //   169: invokespecial 352	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:e	()V
    //   172: aload_0
    //   173: aload_0
    //   174: getfield 67	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   177: getfield 106	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:g	I
    //   180: invokevirtual 354	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:a	(I)V
    //   183: aload_0
    //   184: getfield 174	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:m	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   187: aload_0
    //   188: getfield 67	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   191: getfield 91	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:c	I
    //   194: aload_0
    //   195: getfield 67	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   198: getfield 98	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:e	I
    //   201: aload_0
    //   202: getfield 67	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   205: getfield 102	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:f	I
    //   208: invokevirtual 356	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(III)V
    //   211: aload_0
    //   212: getfield 174	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:m	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   215: aload_0
    //   216: invokevirtual 359	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessorListener;)V
    //   219: aload_0
    //   220: invokevirtual 360	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:a	()V
    //   223: aload_0
    //   224: invokevirtual 362	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:b	()V
    //   227: aload_0
    //   228: invokespecial 364	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	()V
    //   231: return
    //   232: astore_1
    //   233: goto +61 -> 294
    //   236: astore_1
    //   237: aload_0
    //   238: getfield 73	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:h	Lcom/tencent/mobileqq/voicechange/IVoiceChangeListener;
    //   241: ifnull +12 -> 253
    //   244: aload_0
    //   245: getfield 73	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:h	Lcom/tencent/mobileqq/voicechange/IVoiceChangeListener;
    //   248: invokeinterface 367 1 0
    //   253: aload_1
    //   254: invokevirtual 368	java/lang/Exception:printStackTrace	()V
    //   257: aload_0
    //   258: invokespecial 364	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	()V
    //   261: return
    //   262: astore_1
    //   263: aload_1
    //   264: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   267: aload_0
    //   268: getfield 73	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:h	Lcom/tencent/mobileqq/voicechange/IVoiceChangeListener;
    //   271: ifnull +12 -> 283
    //   274: aload_0
    //   275: getfield 73	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:h	Lcom/tencent/mobileqq/voicechange/IVoiceChangeListener;
    //   278: invokeinterface 367 1 0
    //   283: aload_0
    //   284: invokespecial 364	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	()V
    //   287: return
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   293: return
    //   294: aload_0
    //   295: invokespecial 364	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	()V
    //   298: goto +8 -> 306
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   306: aload_1
    //   307: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	QQVoiceChangerThread
    //   94	12	1	localWechatNsWrapper	com.tencent.mobileqq.utils.WechatNsWrapper
    //   232	1	1	localObject	Object
    //   236	18	1	localException	java.lang.Exception
    //   262	2	1	localIOException1	IOException
    //   288	19	1	localIOException2	IOException
    //   301	2	2	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   16	34	232	finally
    //   34	73	232	finally
    //   73	109	232	finally
    //   109	147	232	finally
    //   150	168	232	finally
    //   168	227	232	finally
    //   237	253	232	finally
    //   253	257	232	finally
    //   263	283	232	finally
    //   16	34	236	java/lang/Exception
    //   34	73	236	java/lang/Exception
    //   73	109	236	java/lang/Exception
    //   109	147	236	java/lang/Exception
    //   150	168	236	java/lang/Exception
    //   168	227	236	java/lang/Exception
    //   16	34	262	java/io/IOException
    //   34	73	262	java/io/IOException
    //   73	109	262	java/io/IOException
    //   109	147	262	java/io/IOException
    //   150	168	262	java/io/IOException
    //   168	227	262	java/io/IOException
    //   227	231	288	java/io/IOException
    //   257	261	288	java/io/IOException
    //   283	287	288	java/io/IOException
    //   294	298	301	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.QQVoiceChangerThread
 * JD-Core Version:    0.7.0.1
 */