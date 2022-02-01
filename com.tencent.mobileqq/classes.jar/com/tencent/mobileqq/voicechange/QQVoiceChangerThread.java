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
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack = null;
  private AudioCompositeProcessor jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor;
  IVoiceChangeListener jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener;
  VoiceChangeBasicParams jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams;
  VoiceChangeModeParams jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams;
  private FileInputStream jdField_a_of_type_JavaIoFileInputStream = null;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream = null;
  public String a;
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[960];
  int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  int c = 0;
  
  public QQVoiceChangerThread(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, VoiceChangeModeParams paramVoiceChangeModeParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams = paramVoiceChangeBasicParams;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams = paramVoiceChangeModeParams;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener = paramIVoiceChangeListener;
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("new QQVoiceChangerThread filePath=");
      paramContext.append(this.jdField_b_of_type_JavaLangString);
      paramContext.append(" sampleRate=");
      paramContext.append(paramVoiceChangeBasicParams.jdField_b_of_type_Int);
      paramContext.append(" bitRate=");
      paramContext.append(paramVoiceChangeBasicParams.d);
      paramContext.append(" voiceType=");
      paramContext.append(paramVoiceChangeBasicParams.e);
      paramContext.append(" changeType=");
      paramContext.append(paramVoiceChangeBasicParams.f);
      QLog.d("QQVoiceChanger", 2, paramContext.toString());
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (int)AudioHelper.a(this.jdField_a_of_type_AndroidContentContext, paramArrayOfByte, paramInt, 1.0F);
    IVoiceChangeListener localIVoiceChangeListener = this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener;
    if (localIVoiceChangeListener != null) {
      localIVoiceChangeListener.onSlicePlayed(i, this.c * 100 / this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_AndroidMediaAudioTrack.write(paramArrayOfByte, 0, paramInt);
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
    } else {
      this.jdField_b_of_type_JavaLangString = ((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).renameFileToPcm(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("open:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" a=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaIoFileInputStream.available());
      QLog.d("QQVoiceChanger", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioTrack;
    if (localObject != null) {
      ((AudioTrack)localObject).release();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor;
    if (localObject != null) {
      ((AudioCompositeProcessor)localObject).a();
    }
    localObject = this.jdField_a_of_type_JavaIoFileInputStream;
    if (localObject != null) {
      ((FileInputStream)localObject).close();
    }
    localObject = this.jdField_a_of_type_JavaIoFileOutputStream;
    if (localObject != null) {
      ((FileOutputStream)localObject).close();
    }
    if (this.jdField_b_of_type_Boolean) {
      ((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).deleteAllFiles(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clean up requestToCancel=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("QQVoiceChanger", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void a()
  {
    int i = AudioTrack.getMinBufferSize(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.c);
    this.jdField_a_of_type_AndroidMediaAudioTrack = new ReportAudioTrack(3, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int, 4, 2, i, 1);
    this.jdField_a_of_type_AndroidMediaAudioTrack.play();
  }
  
  protected void a(int paramInt)
  {
    File localFile = new File(((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).getChangedSoundFilePath(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, paramInt));
    localFile.createNewFile();
    this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
  }
  
  public void a(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    if (((paramIAudioProcessor instanceof SilkCodecWrapper)) || ((paramIAudioProcessor instanceof AmrInputStreamWrapper)))
    {
      this.jdField_a_of_type_Int += (int)((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getMillisecond(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int, 4, 2, paramProcessData.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_a_of_type_Boolean) {
        a(paramProcessData.jdField_a_of_type_ArrayOfByte, paramProcessData.jdField_a_of_type_Int);
      }
    }
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaIoFileInputStream.available();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start progress totalSize=");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject1).append(" filePath=");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("pcmFilePath=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
      QLog.d("QQVoiceChanger", 2, ((StringBuilder)localObject1).toString());
    }
    int k = 0;
    int i = 0;
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        int j = k;
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.e)
        {
          j = k;
          if (k == 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e == 0)
            {
              this.jdField_a_of_type_JavaIoFileInputStream.skip(6);
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e == 1)
            {
              this.jdField_a_of_type_JavaIoFileInputStream.skip(10L);
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e == 2)
            {
              j = this.jdField_a_of_type_JavaIoFileInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, 64);
              if (j == 64)
              {
                localObject1 = this.jdField_a_of_type_JavaIoFileOutputStream;
                if (localObject1 != null)
                {
                  ((FileOutputStream)localObject1).write(this.jdField_a_of_type_ArrayOfByte, 0, j);
                  this.jdField_a_of_type_JavaIoFileOutputStream.flush();
                  break label253;
                }
              }
              if (!QLog.isColorLevel()) {
                break label658;
              }
              QLog.d("QQVoiceChanger", 2, "copy AFPCM failed!");
              break label658;
            }
            label253:
            j = 1;
          }
        }
        try
        {
          k = this.jdField_a_of_type_JavaIoFileInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, 960);
          if (k == -1)
          {
            this.jdField_a_of_type_Boolean = false;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener;
            if (localObject1 != null) {
              ((IVoiceChangeListener)localObject1).onPlayEnd();
            }
            ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(4, this.jdField_a_of_type_Int);
            ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).voiceChangeEnd(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("finishedCompress playedTime=");
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
              QLog.d("QQVoiceChanger", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            this.c += k;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(this.jdField_a_of_type_ArrayOfByte, 0, k);
            ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).noteOneFrameProcessed();
            if ((this.jdField_a_of_type_JavaIoFileOutputStream != null) && (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.c))
            {
              int m = i;
              if (i == 0)
              {
                localObject2 = RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int);
                this.jdField_a_of_type_JavaIoFileOutputStream.write((byte[])localObject2, 0, localObject2.length);
                this.jdField_a_of_type_JavaIoFileOutputStream.flush();
                m = 1;
              }
              k = j;
              i = m;
              if (localObject1 == null) {
                continue;
              }
              this.jdField_a_of_type_JavaIoFileOutputStream.write(((IAudioProcessor.ProcessData)localObject1).jdField_a_of_type_ArrayOfByte, 0, ((IAudioProcessor.ProcessData)localObject1).jdField_a_of_type_Int);
              this.jdField_a_of_type_JavaIoFileOutputStream.flush();
              k = j;
              i = m;
              continue;
            }
            localObject2 = this.jdField_a_of_type_JavaIoFileOutputStream;
            k = j;
            if (localObject2 == null) {
              continue;
            }
            k = j;
            if (localObject1 == null) {
              continue;
            }
            ((FileOutputStream)localObject2).write(((IAudioProcessor.ProcessData)localObject1).jdField_a_of_type_ArrayOfByte, 0, ((IAudioProcessor.ProcessData)localObject1).jdField_a_of_type_Int);
            this.jdField_a_of_type_JavaIoFileOutputStream.flush();
            k = j;
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
    label658:
    IVoiceChangeListener localIVoiceChangeListener = this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener;
    if (localIVoiceChangeListener != null) {
      localIVoiceChangeListener.onPlayStop();
    }
  }
  
  public void b(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    if (((paramIAudioProcessor instanceof VoiceChange)) && (!this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.c) && (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_a_of_type_Boolean)) {
      a(paramProcessData.jdField_a_of_type_ArrayOfByte, paramProcessData.jdField_a_of_type_Int);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener = null;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestToSend isRunning=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("QQVoiceChanger", 2, localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      ((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).deleteAllFilesOnExit(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestToCancel isRunning=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("QQVoiceChanger", 2, localStringBuilder.toString());
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 237
    //   2: invokestatic 316	android/os/Process:setThreadPriority	(I)V
    //   5: aload_0
    //   6: new 164	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor
    //   9: dup
    //   10: invokespecial 317	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:<init>	()V
    //   13: putfield 162	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   16: aload_0
    //   17: getfield 54	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   20: getfield 95	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:f	I
    //   23: ifne +11 -> 34
    //   26: aload_0
    //   27: getfield 56	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams	Lcom/tencent/mobileqq/voicechange/VoiceChangeModeParams;
    //   30: iconst_0
    //   31: putfield 319	com/tencent/mobileqq/voicechange/VoiceChangeModeParams:d	Z
    //   34: aload_0
    //   35: getfield 56	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams	Lcom/tencent/mobileqq/voicechange/VoiceChangeModeParams;
    //   38: getfield 319	com/tencent/mobileqq/voicechange/VoiceChangeModeParams:d	Z
    //   41: ifeq +32 -> 73
    //   44: aload_0
    //   45: getfield 162	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   48: new 301	com/tencent/mobileqq/voicechange/VoiceChange
    //   51: dup
    //   52: aload_0
    //   53: getfield 46	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   56: aload_0
    //   57: getfield 54	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   60: getfield 95	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:f	I
    //   63: aload_0
    //   64: getfield 57	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   67: invokespecial 322	com/tencent/mobileqq/voicechange/VoiceChange:<init>	(Landroid/content/Context;ILjava/lang/String;)V
    //   70: invokevirtual 325	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor;)V
    //   73: aload_0
    //   74: getfield 56	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams	Lcom/tencent/mobileqq/voicechange/VoiceChangeModeParams;
    //   77: getfield 326	com/tencent/mobileqq/voicechange/VoiceChangeModeParams:jdField_b_of_type_Boolean	Z
    //   80: ifeq +29 -> 109
    //   83: new 328	com/tencent/mobileqq/utils/WechatNsWrapper
    //   86: dup
    //   87: aload_0
    //   88: getfield 46	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   91: invokespecial 331	com/tencent/mobileqq/utils/WechatNsWrapper:<init>	(Landroid/content/Context;)V
    //   94: astore_1
    //   95: getstatic 332	com/tencent/mobileqq/utils/WechatNsWrapper:jdField_a_of_type_Boolean	Z
    //   98: ifeq +11 -> 109
    //   101: aload_0
    //   102: getfield 162	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   105: aload_1
    //   106: invokevirtual 325	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor;)V
    //   109: aload_0
    //   110: getfield 56	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams	Lcom/tencent/mobileqq/voicechange/VoiceChangeModeParams;
    //   113: getfield 279	com/tencent/mobileqq/voicechange/VoiceChangeModeParams:c	Z
    //   116: ifeq +52 -> 168
    //   119: aload_0
    //   120: getfield 54	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   123: getfield 90	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:e	I
    //   126: ifne +24 -> 150
    //   129: aload_0
    //   130: getfield 162	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   133: new 214	com/tencent/mobileqq/utils/AmrInputStreamWrapper
    //   136: dup
    //   137: aload_0
    //   138: getfield 46	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   141: invokespecial 333	com/tencent/mobileqq/utils/AmrInputStreamWrapper:<init>	(Landroid/content/Context;)V
    //   144: invokevirtual 325	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor;)V
    //   147: goto +21 -> 168
    //   150: aload_0
    //   151: getfield 162	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   154: new 212	com/tencent/mobileqq/utils/SilkCodecWrapper
    //   157: dup
    //   158: aload_0
    //   159: getfield 46	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   162: invokespecial 334	com/tencent/mobileqq/utils/SilkCodecWrapper:<init>	(Landroid/content/Context;)V
    //   165: invokevirtual 325	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessor;)V
    //   168: aload_0
    //   169: invokespecial 336	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:e	()V
    //   172: aload_0
    //   173: aload_0
    //   174: getfield 54	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   177: getfield 95	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:f	I
    //   180: invokevirtual 338	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:a	(I)V
    //   183: aload_0
    //   184: getfield 162	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   187: aload_0
    //   188: getfield 54	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   191: getfield 77	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:jdField_b_of_type_Int	I
    //   194: aload_0
    //   195: getfield 54	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   198: getfield 85	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:d	I
    //   201: aload_0
    //   202: getfield 54	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams	Lcom/tencent/mobileqq/voicechange/VoiceChangeBasicParams;
    //   205: getfield 90	com/tencent/mobileqq/voicechange/VoiceChangeBasicParams:e	I
    //   208: invokevirtual 340	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(III)V
    //   211: aload_0
    //   212: getfield 162	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor	Lcom/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor;
    //   215: aload_0
    //   216: invokevirtual 343	com/tencent/mobileqq/qqaudio/audioprocessor/AudioCompositeProcessor:a	(Lcom/tencent/mobileqq/qqaudio/audioprocessor/IAudioProcessorListener;)V
    //   219: aload_0
    //   220: invokevirtual 344	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:a	()V
    //   223: aload_0
    //   224: invokevirtual 346	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:b	()V
    //   227: aload_0
    //   228: invokespecial 348	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	()V
    //   231: return
    //   232: astore_1
    //   233: goto +61 -> 294
    //   236: astore_1
    //   237: aload_0
    //   238: getfield 59	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener	Lcom/tencent/mobileqq/voicechange/IVoiceChangeListener;
    //   241: ifnull +12 -> 253
    //   244: aload_0
    //   245: getfield 59	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener	Lcom/tencent/mobileqq/voicechange/IVoiceChangeListener;
    //   248: invokeinterface 351 1 0
    //   253: aload_1
    //   254: invokevirtual 352	java/lang/Exception:printStackTrace	()V
    //   257: aload_0
    //   258: invokespecial 348	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	()V
    //   261: return
    //   262: astore_1
    //   263: aload_1
    //   264: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   267: aload_0
    //   268: getfield 59	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener	Lcom/tencent/mobileqq/voicechange/IVoiceChangeListener;
    //   271: ifnull +12 -> 283
    //   274: aload_0
    //   275: getfield 59	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener	Lcom/tencent/mobileqq/voicechange/IVoiceChangeListener;
    //   278: invokeinterface 351 1 0
    //   283: aload_0
    //   284: invokespecial 348	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	()V
    //   287: return
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   293: return
    //   294: aload_0
    //   295: invokespecial 348	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:f	()V
    //   298: goto +8 -> 306
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 287	java/io/IOException:printStackTrace	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.QQVoiceChangerThread
 * JD-Core Version:    0.7.0.1
 */