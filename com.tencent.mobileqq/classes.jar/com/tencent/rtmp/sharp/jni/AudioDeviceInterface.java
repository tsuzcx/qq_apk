package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class AudioDeviceInterface
{
  private static final FileFilter CPU_FILTER = new AudioDeviceInterface.4();
  public static final int OUTPUT_MODE_HEADSET = 0;
  public static final int OUTPUT_MODE_SPEAKER = 1;
  private static final String TAG = "AudioDeviceInterface";
  private static boolean _dumpEnable = false;
  private static boolean _logEnable = true;
  private static boolean isSupportVivoKTVHelper = false;
  private static String[] mDeviceList;
  private static VivoKTVHelper mVivoKTVHelper;
  private TraeAudioSession _as = null;
  private TraeAudioSession _asAudioManager = null;
  private AudioManager _audioManager = null;
  private AudioRecord _audioRecord = null;
  private boolean _audioRouteChanged = false;
  private int _audioSource = 0;
  private int _audioSourcePolicy = -1;
  private int _audioStreamTypePolicy = -1;
  private AudioTrack _audioTrack = null;
  private int _bufferedPlaySamples = 0;
  private int _bufferedRecSamples = 0;
  private int _channelOutType = 4;
  private String _connectedDev = "DEVICE_NONE";
  private Context _context = null;
  private ByteBuffer _decBuffer0;
  private ByteBuffer _decBuffer1;
  private ByteBuffer _decBuffer10;
  private ByteBuffer _decBuffer2;
  private ByteBuffer _decBuffer3;
  private ByteBuffer _decBuffer4;
  private ByteBuffer _decBuffer5;
  private ByteBuffer _decBuffer6;
  private ByteBuffer _decBuffer7;
  private ByteBuffer _decBuffer8;
  private ByteBuffer _decBuffer9;
  private int _deviceStat = 0;
  private boolean _doPlayInit = true;
  private boolean _doRecInit = true;
  private boolean _isPlaying = false;
  private boolean _isRecording = false;
  private int _modePolicy = -1;
  private ByteBuffer _playBuffer;
  private int _playPosition = 0;
  private int _playSamplerate = 8000;
  private File _play_dump = null;
  private FileOutputStream _play_out = null;
  private boolean _preDone = false;
  private Condition _precon = this._prelock.newCondition();
  private ReentrantLock _prelock = new ReentrantLock();
  private ByteBuffer _recBuffer;
  private File _rec_dump = null;
  private FileOutputStream _rec_out = null;
  private int _sceneMode = 0;
  private int _sessionId = 0;
  private int _streamType = 0;
  private byte[] _tempBufPlay;
  private byte[] _tempBufRec;
  private TraeAudioCodecList _traeAudioCodecList = null;
  private int nPlayLengthMs = 0;
  private int nRecordLengthMs = 0;
  private int switchState = 0;
  private boolean usingJava = true;
  
  public AudioDeviceInterface()
  {
    try
    {
      this._playBuffer = ByteBuffer.allocateDirect(1920);
      this._recBuffer = ByteBuffer.allocateDirect(1920);
      this._decBuffer0 = ByteBuffer.allocateDirect(3840);
      this._decBuffer1 = ByteBuffer.allocateDirect(3840);
      this._decBuffer2 = ByteBuffer.allocateDirect(3840);
      this._decBuffer3 = ByteBuffer.allocateDirect(3840);
      this._decBuffer4 = ByteBuffer.allocateDirect(3840);
      this._decBuffer5 = ByteBuffer.allocateDirect(3840);
      this._decBuffer6 = ByteBuffer.allocateDirect(3840);
      this._decBuffer7 = ByteBuffer.allocateDirect(3840);
      this._decBuffer8 = ByteBuffer.allocateDirect(3840);
      this._decBuffer9 = ByteBuffer.allocateDirect(3840);
      this._decBuffer10 = ByteBuffer.allocateDirect(3840);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, localException.getMessage());
      }
    }
    this._tempBufPlay = new byte[1920];
    this._tempBufRec = new byte[1920];
    this._traeAudioCodecList = new TraeAudioCodecList();
    int i = Build.VERSION.SDK_INT;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioDeviceInterface apiLevel:");
      localStringBuilder.append(i);
      QLog.w("AudioDeviceInterface", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" SDK_INT:");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.w("AudioDeviceInterface", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("manufacture:");
      localStringBuilder.append(Build.MANUFACTURER);
      QLog.w("AudioDeviceInterface", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MODEL:");
      localStringBuilder.append(Build.MODEL);
      QLog.w("AudioDeviceInterface", 2, localStringBuilder.toString());
    }
  }
  
  private int CloseMp3File(int paramInt)
  {
    Object localObject = this._traeAudioCodecList;
    long l = paramInt;
    localObject = ((TraeAudioCodecList)localObject).find(l);
    if (localObject != null)
    {
      ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder.release();
      ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder = null;
      this._traeAudioCodecList.remove(l);
      return 0;
    }
    return -1;
  }
  
  private int EnableVivoKTVLoopback(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EnableVivoKTVLoopback: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" isSupportVivoKTVHelper:");
      ((StringBuilder)localObject).append(isSupportVivoKTVHelper);
      ((StringBuilder)localObject).append(" mVivoKTVHelper:");
      ((StringBuilder)localObject).append(mVivoKTVHelper);
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = mVivoKTVHelper;
    if ((localObject != null) && (isSupportVivoKTVHelper))
    {
      ((VivoKTVHelper)localObject).setPlayFeedbackParam(paramInt);
      return 0;
    }
    return -1;
  }
  
  private int InitPlayback(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("InitPlayback entry: sampleRate ");
      localStringBuilder1.append(paramInt1);
      QLog.w("AudioDeviceInterface", 2, localStringBuilder1.toString());
    }
    Object localObject1;
    if ((!this._isPlaying) && (this._audioTrack == null) && (paramInt2 <= 2))
    {
      if (this._audioManager == null) {
        try
        {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.w("AudioDeviceInterface", 2, localException1.getMessage());
          }
          return -1;
        }
      }
      if (paramInt2 == 2) {
        this._channelOutType = 12;
      } else {
        this._channelOutType = 4;
      }
      this._playSamplerate = paramInt1;
      int n = AudioTrack.getMinBufferSize(paramInt1, this._channelOutType, 2);
      if (this._channelOutType == 12) {
        if (QLog.isColorLevel()) {
          QLog.w("AudioDeviceInterface", 2, "InitPlayback, _channelOutType stero");
        } else if ((this._channelOutType == 4) && (QLog.isColorLevel())) {
          QLog.w("AudioDeviceInterface", 2, "InitPlayback, _channelOutType Mono");
        }
      }
      int i = paramInt1 * 20 * 1 * 2 / 1000;
      int j = i;
      if (this._channelOutType == 12) {
        j = i * 2;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("InitPlayback: minPlayBufSize:");
        ((StringBuilder)localObject1).append(n);
        ((StringBuilder)localObject1).append(" 20msFz:");
        ((StringBuilder)localObject1).append(j);
        QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject1).toString());
      }
      this._bufferedPlaySamples = 0;
      localObject1 = this._audioTrack;
      int i1 = 0;
      if (localObject1 != null)
      {
        ((AudioTrack)localObject1).release();
        this._audioTrack = null;
      }
      localObject1 = new int[4];
      Object tmp323_321 = localObject1;
      tmp323_321[0] = 0;
      Object tmp327_323 = tmp323_321;
      tmp327_323[1] = 0;
      Object tmp331_327 = tmp327_323;
      tmp331_327[2] = 3;
      Object tmp335_331 = tmp331_327;
      tmp335_331[3] = 1;
      tmp335_331;
      this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
      StringBuilder localStringBuilder2;
      if (this._audioRouteChanged)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("_audioRouteChanged:");
          localStringBuilder2.append(this._audioRouteChanged);
          localStringBuilder2.append(" _streamType:");
          localStringBuilder2.append(this._streamType);
          QLog.w("AudioDeviceInterface", 2, localStringBuilder2.toString());
        }
        if ((this._audioManager.getMode() == 0) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
          this._streamType = 3;
        } else {
          this._streamType = 0;
        }
        this._audioRouteChanged = false;
      }
      localObject1[0] = this._streamType;
      i = n;
      int k = 0;
      Object localObject2;
      while ((k < localObject1.length) && (this._audioTrack == null))
      {
        this._streamType = localObject1[k];
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("InitPlayback: min play buf size is ");
          localStringBuilder2.append(n);
          localStringBuilder2.append(" hw_sr:");
          localStringBuilder2.append(AudioTrack.getNativeOutputSampleRate(this._streamType));
          QLog.w("AudioDeviceInterface", 2, localStringBuilder2.toString());
        }
        int m = 1;
        while (m <= 2)
        {
          i = n * m;
          if ((i >= j * 4) || (m >= 2)) {
            try
            {
              this.nPlayLengthMs = (i * 500 / (paramInt1 * paramInt2));
              this._audioTrack = new ReportAudioTrack(this._streamType, this._playSamplerate, this._channelOutType, 2, i, 1);
              if (this._audioTrack.getState() != 1)
              {
                if (QLog.isColorLevel())
                {
                  localStringBuilder2 = new StringBuilder();
                  localStringBuilder2.append("InitPlayback: play not initialized playBufSize:");
                  localStringBuilder2.append(i);
                  localStringBuilder2.append(" sr:");
                  localStringBuilder2.append(this._playSamplerate);
                  QLog.w("AudioDeviceInterface", 2, localStringBuilder2.toString());
                }
                this._audioTrack.release();
                i1 = 0;
                this._audioTrack = null;
              }
              else
              {
                i1 = 0;
              }
            }
            catch (Exception localException2)
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder3 = new StringBuilder();
                localStringBuilder3.append(localException2.getMessage());
                localStringBuilder3.append(" _audioTrack:");
                localStringBuilder3.append(this._audioTrack);
                QLog.w("AudioDeviceInterface", 2, localStringBuilder3.toString());
              }
              localObject2 = this._audioTrack;
              if (localObject2 != null) {
                ((AudioTrack)localObject2).release();
              }
              i1 = 0;
              this._audioTrack = null;
            }
          }
          m += 1;
        }
        k += 1;
      }
      if (this._audioTrack == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("AudioDeviceInterface", 2, "InitPlayback fail!!!");
        }
        return -1;
      }
      localObject1 = this._as;
      if (localObject1 != null)
      {
        localObject2 = this._audioManager;
        if (localObject2 != null) {
          ((TraeAudioSession)localObject1).voiceCallAudioParamChanged(((AudioManager)localObject2).getMode(), this._streamType);
        }
      }
      this._playPosition = this._audioTrack.getPlaybackHeadPosition();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("InitPlayback exit: streamType:");
        ((StringBuilder)localObject1).append(this._streamType);
        ((StringBuilder)localObject1).append(" samplerate:");
        ((StringBuilder)localObject1).append(this._playSamplerate);
        ((StringBuilder)localObject1).append(" _playPosition:");
        ((StringBuilder)localObject1).append(this._playPosition);
        ((StringBuilder)localObject1).append(" playBufSize:");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" nPlayLengthMs:");
        ((StringBuilder)localObject1).append(this.nPlayLengthMs);
        QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = this._audioManager;
      if (this._connectedDev.equals("DEVICE_BLUETOOTHHEADSET")) {
        paramInt1 = 6;
      } else {
        paramInt1 = this._audioTrack.getStreamType();
      }
      TraeAudioManager.forceVolumeControlStream((AudioManager)localObject1, paramInt1);
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("InitPlayback _isPlaying:");
      ((StringBuilder)localObject1).append(this._isPlaying);
      QLog.e("AudioDeviceInterface", 2, ((StringBuilder)localObject1).toString());
    }
    return -1;
  }
  
  private int InitRecording(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("InitRecording entry:");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this._isRecording) && (this._audioRecord == null) && (paramInt2 <= 2))
    {
      int k;
      if (paramInt2 == 2) {
        k = 12;
      } else {
        k = 16;
      }
      int n = AudioRecord.getMinBufferSize(paramInt1, k, 2);
      int i1 = paramInt1 * 20 * paramInt2 * 2 / 1000;
      boolean bool = QLog.isColorLevel();
      String str = " sr:";
      if (bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("InitRecording: min rec buf size is ");
        ((StringBuilder)localObject).append(n);
        ((StringBuilder)localObject).append(" sr:");
        ((StringBuilder)localObject).append(getLowlatencySamplerate());
        ((StringBuilder)localObject).append(" fp");
        ((StringBuilder)localObject).append(getLowlatencyFramesPerBuffer());
        ((StringBuilder)localObject).append(" 20msFZ:");
        ((StringBuilder)localObject).append(i1);
        QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
      }
      this._bufferedRecSamples = (paramInt1 * 5 / 200);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("  rough rec delay set to ");
        ((StringBuilder)localObject).append(this._bufferedRecSamples);
        QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this._audioRecord;
      bool = false;
      if (localObject != null)
      {
        ((AudioRecord)localObject).release();
        this._audioRecord = null;
      }
      localObject = new int[4];
      Object tmp297_295 = localObject;
      tmp297_295[0] = 0;
      Object tmp301_297 = tmp297_295;
      tmp301_297[1] = 1;
      Object tmp305_301 = tmp301_297;
      tmp305_301[2] = 5;
      Object tmp309_305 = tmp305_301;
      tmp309_305[3] = 0;
      tmp309_305;
      localObject[0] = TraeAudioManager.getAudioSource(this._audioSourcePolicy);
      int i = n;
      int j = 0;
      while ((j < localObject.length) && (this._audioRecord == null))
      {
        this._audioSource = localObject[j];
        int m = 1;
        while (m <= 2)
        {
          i = n * m;
          if ((i >= i1 * 4) || (m >= 2))
          {
            try
            {
              this.nRecordLengthMs = (i * 500 / (paramInt1 * paramInt2));
              int i2 = this._audioSource;
              try
              {
                this._audioRecord = new AudioRecord(i2, paramInt1, k, 2, i);
                if (this._audioRecord.getState() != 1)
                {
                  if (QLog.isColorLevel())
                  {
                    StringBuilder localStringBuilder1 = new StringBuilder();
                    localStringBuilder1.append("InitRecording:  rec not initialized,try agine,  minbufsize:");
                    localStringBuilder1.append(i);
                    localStringBuilder1.append(str);
                    localStringBuilder1.append(paramInt1);
                    localStringBuilder1.append(" as:");
                    localStringBuilder1.append(this._audioSource);
                    QLog.w("AudioDeviceInterface", 2, localStringBuilder1.toString());
                  }
                  this._audioRecord.release();
                  this._audioRecord = null;
                  break label619;
                }
                bool = false;
              }
              catch (Exception localException1) {}
              if (!QLog.isColorLevel()) {
                break label598;
              }
            }
            catch (Exception localException2) {}
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(localException2.getMessage());
            localStringBuilder2.append(" _audioRecord:");
            localStringBuilder2.append(this._audioRecord);
            QLog.w("AudioDeviceInterface", 2, localStringBuilder2.toString());
            label598:
            AudioRecord localAudioRecord = this._audioRecord;
            if (localAudioRecord != null) {
              localAudioRecord.release();
            }
            this._audioRecord = null;
          }
          label619:
          m += 1;
          bool = false;
        }
        j += 1;
      }
      if (this._audioRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("AudioDeviceInterface", 2, "InitRecording fail!!!");
        }
        return -1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" [Config] InitRecording: audioSession:");
        ((StringBuilder)localObject).append(this._sessionId);
        ((StringBuilder)localObject).append(" audioSource:");
        ((StringBuilder)localObject).append(this._audioSource);
        ((StringBuilder)localObject).append(" rec sample rate set to ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" recBufSize:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" nRecordLengthMs:");
        ((StringBuilder)localObject).append(this.nRecordLengthMs);
        QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
      }
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "InitRecording exit");
      }
      return this._bufferedRecSamples;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("InitRecording _isRecording:");
      ((StringBuilder)localObject).append(this._isRecording);
      QLog.e("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    return -1;
  }
  
  private int InitSetting(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this._audioSourcePolicy = paramInt1;
    this._audioStreamTypePolicy = paramInt2;
    this._modePolicy = paramInt3;
    this._deviceStat = paramInt4;
    this._sceneMode = paramInt5;
    paramInt1 = this._deviceStat;
    if ((paramInt1 != 1) && (paramInt1 != 5) && (paramInt1 != 2) && (paramInt1 != 3)) {
      TraeAudioManager.IsMusicScene = false;
    } else {
      TraeAudioManager.IsMusicScene = true;
    }
    paramInt1 = this._sceneMode;
    if ((paramInt1 != 0) && (paramInt1 != 4)) {
      TraeAudioManager.IsEarPhoneSupported = false;
    } else {
      TraeAudioManager.IsEarPhoneSupported = true;
    }
    TraeAudioManager.IsUpdateSceneFlag = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("InitSetting: _audioSourcePolicy:");
      localStringBuilder.append(this._audioSourcePolicy);
      localStringBuilder.append(" _audioStreamTypePolicy:");
      localStringBuilder.append(this._audioStreamTypePolicy);
      localStringBuilder.append(" _modePolicy:");
      localStringBuilder.append(this._modePolicy);
      localStringBuilder.append(" DeviceStat:");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(" isSupportVivoKTVHelper:");
      localStringBuilder.append(isSupportVivoKTVHelper);
      QLog.w("AudioDeviceInterface", 2, localStringBuilder.toString());
    }
    return 0;
  }
  
  public static final void LogTraceEntry(String paramString)
  {
    if (!_logEnable) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getTraceInfo());
    localStringBuilder.append(" entry:");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, paramString);
    }
  }
  
  public static final void LogTraceExit()
  {
    if (!_logEnable) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getTraceInfo());
    ((StringBuilder)localObject).append(" exit");
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, (String)localObject);
    }
  }
  
  private int OpenMp3File(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = this._traeAudioCodecList;
    long l = paramInt1;
    if (((TraeAudioCodecList)localObject).find(l) == null)
    {
      localObject = this._traeAudioCodecList.add(l);
      ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder.setIOPath(paramString);
      ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder.setIndex(paramInt1);
      paramInt1 = ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder.prepare(paramInt2);
      if (paramInt1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("AudioDeviceInterface", 2, "openFile mp3 Failed!!!");
        }
        ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder.release();
        ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder = null;
        this._traeAudioCodecList.remove(l);
        return paramInt1;
      }
      return 0;
    }
    return -1;
  }
  
  /* Error */
  private int OpenslesNeedResetAudioTrack(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 125	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_modePolicy	I
    //   4: invokestatic 525	com/tencent/rtmp/sharp/jni/TraeAudioManager:isCloseSystemAPM	(I)Z
    //   7: ifne +5 -> 12
    //   10: iconst_m1
    //   11: ireturn
    //   12: aload_0
    //   13: getfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   16: ifne +7 -> 23
    //   19: iload_1
    //   20: ifeq +133 -> 153
    //   23: aload_0
    //   24: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   27: ifnonnull +27 -> 54
    //   30: aload_0
    //   31: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   34: ifnull +20 -> 54
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   42: ldc_w 323
    //   45: invokevirtual 329	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   48: checkcast 331	android/media/AudioManager
    //   51: putfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   54: aload_0
    //   55: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   58: ifnonnull +5 -> 63
    //   61: iconst_0
    //   62: ireturn
    //   63: aload_0
    //   64: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   67: invokevirtual 359	android/media/AudioManager:getMode	()I
    //   70: ifne +24 -> 94
    //   73: aload_0
    //   74: getfield 165	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   77: ldc_w 361
    //   80: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifeq +11 -> 94
    //   86: aload_0
    //   87: iconst_3
    //   88: putfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioStreamTypePolicy	I
    //   91: goto +8 -> 99
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioStreamTypePolicy	I
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   104: goto +49 -> 153
    //   107: astore_2
    //   108: goto +50 -> 158
    //   111: astore_2
    //   112: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   115: ifeq +38 -> 153
    //   118: new 246	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   125: astore_3
    //   126: aload_3
    //   127: ldc_w 527
    //   130: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_3
    //   135: aload_2
    //   136: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   139: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: ldc 18
    //   145: iconst_2
    //   146: aload_3
    //   147: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_0
    //   154: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioStreamTypePolicy	I
    //   157: ireturn
    //   158: aload_2
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	AudioDeviceInterface
    //   0	160	1	paramBoolean	boolean
    //   107	1	2	localObject	Object
    //   111	48	2	localException	Exception
    //   125	22	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	10	107	finally
    //   12	19	107	finally
    //   23	54	107	finally
    //   54	61	107	finally
    //   63	91	107	finally
    //   94	99	107	finally
    //   99	104	107	finally
    //   112	153	107	finally
    //   0	10	111	java/lang/Exception
    //   12	19	111	java/lang/Exception
    //   23	54	111	java/lang/Exception
    //   54	61	111	java/lang/Exception
    //   63	91	111	java/lang/Exception
    //   94	99	111	java/lang/Exception
    //   99	104	111	java/lang/Exception
  }
  
  /* Error */
  private int PlayAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 139	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   4: istore 7
    //   6: aload_0
    //   7: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   10: astore 10
    //   12: iconst_0
    //   13: istore_3
    //   14: aload 10
    //   16: ifnonnull +8 -> 24
    //   19: iconst_1
    //   20: istore_2
    //   21: goto +5 -> 26
    //   24: iconst_0
    //   25: istore_2
    //   26: iload 7
    //   28: iconst_1
    //   29: ixor
    //   30: iload_2
    //   31: ior
    //   32: ifeq +69 -> 101
    //   35: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   38: ifeq +61 -> 99
    //   41: new 246	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   48: astore 10
    //   50: aload 10
    //   52: ldc_w 534
    //   55: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 10
    //   61: aload_0
    //   62: getfield 139	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   65: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 10
    //   71: ldc_w 536
    //   74: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 10
    //   80: aload_0
    //   81: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   84: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 18
    //   90: iconst_2
    //   91: aload 10
    //   93: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: iconst_m1
    //   100: ireturn
    //   101: aload_0
    //   102: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   105: ifnonnull +6 -> 111
    //   108: bipush 254
    //   110: ireturn
    //   111: aload_0
    //   112: getfield 133	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   115: istore 7
    //   117: iload 7
    //   119: iconst_1
    //   120: if_icmpne +73 -> 193
    //   123: bipush 237
    //   125: invokestatic 541	android/os/Process:setThreadPriority	(I)V
    //   128: invokestatic 547	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   131: ldc_w 549
    //   134: invokevirtual 552	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   137: goto +51 -> 188
    //   140: astore 10
    //   142: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   145: ifeq +43 -> 188
    //   148: new 246	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   155: astore 11
    //   157: aload 11
    //   159: ldc_w 554
    //   162: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 11
    //   168: aload 10
    //   170: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   173: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc 18
    //   179: iconst_2
    //   180: aload 11
    //   182: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 232	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload_0
    //   189: iconst_0
    //   190: putfield 133	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   193: getstatic 556	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   196: ifeq +45 -> 241
    //   199: aload_0
    //   200: getfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   203: astore 10
    //   205: aload 10
    //   207: ifnull +34 -> 241
    //   210: aload_0
    //   211: getfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   214: aload_0
    //   215: getfield 234	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   218: iconst_0
    //   219: iconst_0
    //   220: invokevirtual 562	java/io/FileOutputStream:write	([BII)V
    //   223: goto +18 -> 241
    //   226: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   229: ifeq +12 -> 241
    //   232: ldc 18
    //   234: iconst_2
    //   235: ldc_w 564
    //   238: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload_0
    //   242: getfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   245: ifne +8 -> 253
    //   248: iconst_0
    //   249: istore_2
    //   250: goto +101 -> 351
    //   253: aload_0
    //   254: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   257: ifnonnull +27 -> 284
    //   260: aload_0
    //   261: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   264: ifnull +20 -> 284
    //   267: aload_0
    //   268: aload_0
    //   269: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   272: ldc_w 323
    //   275: invokevirtual 329	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   278: checkcast 331	android/media/AudioManager
    //   281: putfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   284: aload_0
    //   285: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   288: ifnull +34 -> 322
    //   291: aload_0
    //   292: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   295: invokevirtual 359	android/media/AudioManager:getMode	()I
    //   298: ifne +24 -> 322
    //   301: aload_0
    //   302: getfield 165	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   305: ldc_w 361
    //   308: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: ifeq +11 -> 322
    //   314: aload_0
    //   315: iconst_3
    //   316: putfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   319: goto +8 -> 327
    //   322: aload_0
    //   323: iconst_0
    //   324: putfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   327: aload_0
    //   328: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   331: aload_0
    //   332: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   335: invokevirtual 413	android/media/AudioTrack:getStreamType	()I
    //   338: if_icmpne +1209 -> 1547
    //   341: iconst_0
    //   342: istore_2
    //   343: goto +3 -> 346
    //   346: aload_0
    //   347: iconst_0
    //   348: putfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   351: aload_0
    //   352: getfield 194	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   355: aload_0
    //   356: getfield 234	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   359: invokevirtual 568	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   362: pop
    //   363: iload_2
    //   364: ifeq +857 -> 1221
    //   367: aload_0
    //   368: getfield 194	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   371: invokevirtual 572	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   374: pop
    //   375: invokestatic 578	android/os/SystemClock:elapsedRealtime	()J
    //   378: lstore 8
    //   380: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   383: ifeq +64 -> 447
    //   386: new 246	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   393: astore 10
    //   395: aload 10
    //   397: ldc_w 580
    //   400: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload 10
    //   406: aload_0
    //   407: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   410: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 10
    //   416: ldc_w 582
    //   419: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 10
    //   425: aload_0
    //   426: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   429: invokevirtual 413	android/media/AudioTrack:getStreamType	()I
    //   432: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: ldc 18
    //   438: iconst_2
    //   439: aload 10
    //   441: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 232	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload_0
    //   448: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   451: invokevirtual 585	android/media/AudioTrack:getPlayState	()I
    //   454: istore_2
    //   455: iconst_0
    //   456: istore 7
    //   458: iload_2
    //   459: iconst_3
    //   460: if_icmpne +158 -> 618
    //   463: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   466: ifeq +12 -> 478
    //   469: ldc 18
    //   471: iconst_2
    //   472: ldc_w 587
    //   475: invokestatic 232	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: aload_0
    //   479: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   482: invokevirtual 590	android/media/AudioTrack:stop	()V
    //   485: aload_0
    //   486: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   489: invokevirtual 593	android/media/AudioTrack:flush	()V
    //   492: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   495: ifeq +45 -> 540
    //   498: new 246	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   505: astore 10
    //   507: aload 10
    //   509: ldc_w 595
    //   512: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 10
    //   518: aload_0
    //   519: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   522: invokevirtual 585	android/media/AudioTrack:getPlayState	()I
    //   525: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: ldc 18
    //   531: iconst_2
    //   532: aload 10
    //   534: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 232	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   540: aload_0
    //   541: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   544: invokevirtual 346	android/media/AudioTrack:release	()V
    //   547: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   550: ifeq +45 -> 595
    //   553: new 246	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   560: astore 10
    //   562: aload 10
    //   564: ldc_w 597
    //   567: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload 10
    //   573: aload_0
    //   574: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   577: invokevirtual 585	android/media/AudioTrack:getPlayState	()I
    //   580: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: ldc 18
    //   586: iconst_2
    //   587: aload 10
    //   589: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 232	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: aload_0
    //   596: aconst_null
    //   597: putfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   600: goto +18 -> 618
    //   603: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   606: ifeq +12 -> 618
    //   609: ldc 18
    //   611: iconst_2
    //   612: ldc_w 599
    //   615: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload_0
    //   619: getfield 111	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   622: aload_0
    //   623: getfield 113	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   626: iconst_2
    //   627: invokestatic 337	android/media/AudioTrack:getMinBufferSize	(III)I
    //   630: istore 5
    //   632: iconst_4
    //   633: newarray int
    //   635: astore 10
    //   637: aload 10
    //   639: iconst_0
    //   640: iconst_0
    //   641: iastore
    //   642: aload 10
    //   644: iconst_1
    //   645: iconst_0
    //   646: iastore
    //   647: aload 10
    //   649: iconst_2
    //   650: iconst_3
    //   651: iastore
    //   652: aload 10
    //   654: iconst_3
    //   655: iconst_1
    //   656: iastore
    //   657: aload 10
    //   659: iconst_0
    //   660: aload_0
    //   661: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   664: iastore
    //   665: aload_0
    //   666: getfield 111	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   669: bipush 20
    //   671: imul
    //   672: iconst_1
    //   673: imul
    //   674: iconst_2
    //   675: imul
    //   676: sipush 1000
    //   679: idiv
    //   680: istore 4
    //   682: iload 4
    //   684: istore_2
    //   685: aload_0
    //   686: getfield 113	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   689: bipush 12
    //   691: if_icmpne +861 -> 1552
    //   694: iload 4
    //   696: iconst_2
    //   697: imul
    //   698: istore_2
    //   699: goto +853 -> 1552
    //   702: iload_3
    //   703: aload 10
    //   705: arraylength
    //   706: if_icmpge +356 -> 1062
    //   709: aload_0
    //   710: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   713: ifnonnull +349 -> 1062
    //   716: aload_0
    //   717: aload 10
    //   719: iload_3
    //   720: iaload
    //   721: putfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   724: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   727: ifeq +62 -> 789
    //   730: new 246	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   737: astore 11
    //   739: aload 11
    //   741: ldc_w 369
    //   744: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload 11
    //   750: iload 5
    //   752: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload 11
    //   758: ldc_w 371
    //   761: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: aload 11
    //   767: aload_0
    //   768: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   771: invokestatic 374	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   774: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: ldc 18
    //   780: iconst_2
    //   781: aload 11
    //   783: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   786: invokestatic 232	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   789: iconst_1
    //   790: istore 4
    //   792: iload 4
    //   794: iconst_2
    //   795: if_icmpgt +778 -> 1573
    //   798: iload 5
    //   800: iload 4
    //   802: imul
    //   803: istore 6
    //   805: iload 6
    //   807: iload_2
    //   808: iconst_4
    //   809: imul
    //   810: if_icmpge +12 -> 822
    //   813: iload 4
    //   815: iconst_2
    //   816: if_icmpge +6 -> 822
    //   819: goto +742 -> 1561
    //   822: aload_0
    //   823: new 376	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportAudioTrack
    //   826: dup
    //   827: aload_0
    //   828: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   831: aload_0
    //   832: getfield 111	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   835: aload_0
    //   836: getfield 113	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   839: iconst_2
    //   840: iload 6
    //   842: iconst_1
    //   843: invokespecial 379	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportAudioTrack:<init>	(IIIIII)V
    //   846: putfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   849: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   852: ifeq +42 -> 894
    //   855: new 246	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   862: astore 11
    //   864: aload 11
    //   866: ldc_w 388
    //   869: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: pop
    //   873: aload 11
    //   875: aload_0
    //   876: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   879: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: ldc 18
    //   885: iconst_2
    //   886: aload 11
    //   888: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   891: invokestatic 232	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   894: aload_0
    //   895: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   898: invokevirtual 382	android/media/AudioTrack:getState	()I
    //   901: iconst_1
    //   902: if_icmpeq +653 -> 1555
    //   905: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   908: ifeq +59 -> 967
    //   911: new 246	java/lang/StringBuilder
    //   914: dup
    //   915: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   918: astore 11
    //   920: aload 11
    //   922: ldc_w 384
    //   925: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload 11
    //   931: iload 6
    //   933: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   936: pop
    //   937: aload 11
    //   939: ldc_w 386
    //   942: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: pop
    //   946: aload 11
    //   948: aload_0
    //   949: getfield 111	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   952: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   955: pop
    //   956: ldc 18
    //   958: iconst_2
    //   959: aload 11
    //   961: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokestatic 232	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   967: aload_0
    //   968: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   971: invokevirtual 346	android/media/AudioTrack:release	()V
    //   974: aload_0
    //   975: aconst_null
    //   976: putfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   979: goto +582 -> 1561
    //   982: astore 11
    //   984: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   987: ifeq +53 -> 1040
    //   990: new 246	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   997: astore 12
    //   999: aload 12
    //   1001: aload 11
    //   1003: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1006: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: pop
    //   1010: aload 12
    //   1012: ldc_w 388
    //   1015: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: pop
    //   1019: aload 12
    //   1021: aload_0
    //   1022: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1025: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: ldc 18
    //   1031: iconst_2
    //   1032: aload 12
    //   1034: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokestatic 232	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1040: aload_0
    //   1041: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1044: ifnull +10 -> 1054
    //   1047: aload_0
    //   1048: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1051: invokevirtual 346	android/media/AudioTrack:release	()V
    //   1054: aload_0
    //   1055: aconst_null
    //   1056: putfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1059: goto +502 -> 1561
    //   1062: aload_0
    //   1063: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1066: astore 10
    //   1068: aload 10
    //   1070: ifnull +86 -> 1156
    //   1073: aload_0
    //   1074: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1077: invokevirtual 602	android/media/AudioTrack:play	()V
    //   1080: aload_0
    //   1081: getfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   1084: aload_0
    //   1085: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1088: invokevirtual 359	android/media/AudioManager:getMode	()I
    //   1091: aload_0
    //   1092: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   1095: invokevirtual 395	com/tencent/rtmp/sharp/jni/TraeAudioSession:voiceCallAudioParamChanged	(II)I
    //   1098: pop
    //   1099: aload_0
    //   1100: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1103: astore 10
    //   1105: aload_0
    //   1106: getfield 165	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   1109: ldc_w 410
    //   1112: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1115: ifeq +9 -> 1124
    //   1118: bipush 6
    //   1120: istore_2
    //   1121: goto +11 -> 1132
    //   1124: aload_0
    //   1125: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1128: invokevirtual 413	android/media/AudioTrack:getStreamType	()I
    //   1131: istore_2
    //   1132: aload 10
    //   1134: iload_2
    //   1135: invokestatic 417	com/tencent/rtmp/sharp/jni/TraeAudioManager:forceVolumeControlStream	(Landroid/media/AudioManager;I)V
    //   1138: goto +18 -> 1156
    //   1141: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1144: ifeq +12 -> 1156
    //   1147: ldc 18
    //   1149: iconst_2
    //   1150: ldc_w 604
    //   1153: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1156: iload_1
    //   1157: istore_2
    //   1158: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1161: ifeq +360 -> 1521
    //   1164: new 246	java/lang/StringBuilder
    //   1167: dup
    //   1168: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1171: astore 10
    //   1173: aload 10
    //   1175: ldc_w 606
    //   1178: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: pop
    //   1182: aload 10
    //   1184: invokestatic 578	android/os/SystemClock:elapsedRealtime	()J
    //   1187: lload 8
    //   1189: lsub
    //   1190: invokevirtual 609	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1193: pop
    //   1194: aload 10
    //   1196: ldc_w 611
    //   1199: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: pop
    //   1203: ldc 18
    //   1205: iconst_2
    //   1206: aload 10
    //   1208: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1211: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1214: iload_1
    //   1215: ireturn
    //   1216: astore 10
    //   1218: goto +253 -> 1471
    //   1221: aload_0
    //   1222: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1225: aload_0
    //   1226: getfield 234	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   1229: iconst_0
    //   1230: iload_1
    //   1231: invokevirtual 614	android/media/AudioTrack:write	([BII)I
    //   1234: istore_2
    //   1235: aload_0
    //   1236: getfield 194	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1239: invokevirtual 572	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1242: pop
    //   1243: iload_2
    //   1244: ifge +72 -> 1316
    //   1247: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1250: ifeq +330 -> 1580
    //   1253: new 246	java/lang/StringBuilder
    //   1256: dup
    //   1257: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1260: astore 10
    //   1262: aload 10
    //   1264: ldc_w 616
    //   1267: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: pop
    //   1271: aload 10
    //   1273: iload_2
    //   1274: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: aload 10
    //   1280: ldc_w 618
    //   1283: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: pop
    //   1287: aload 10
    //   1289: iload_1
    //   1290: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1293: pop
    //   1294: aload 10
    //   1296: ldc_w 620
    //   1299: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: pop
    //   1303: ldc 18
    //   1305: iconst_2
    //   1306: aload 10
    //   1308: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1311: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1314: iconst_m1
    //   1315: ireturn
    //   1316: iload_2
    //   1317: iload_1
    //   1318: if_icmpeq +70 -> 1388
    //   1321: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1324: ifeq +64 -> 1388
    //   1327: new 246	java/lang/StringBuilder
    //   1330: dup
    //   1331: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1334: astore 10
    //   1336: aload 10
    //   1338: ldc_w 622
    //   1341: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: pop
    //   1345: aload 10
    //   1347: iload_2
    //   1348: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1351: pop
    //   1352: aload 10
    //   1354: ldc_w 618
    //   1357: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: pop
    //   1361: aload 10
    //   1363: iload_1
    //   1364: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1367: pop
    //   1368: aload 10
    //   1370: ldc_w 620
    //   1373: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: pop
    //   1377: ldc 18
    //   1379: iconst_2
    //   1380: aload 10
    //   1382: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1385: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1388: aload_0
    //   1389: aload_0
    //   1390: getfield 143	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1393: iload_2
    //   1394: iconst_1
    //   1395: ishr
    //   1396: iadd
    //   1397: putfield 143	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1400: aload_0
    //   1401: getfield 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1404: invokevirtual 398	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1407: istore_1
    //   1408: iload_1
    //   1409: aload_0
    //   1410: getfield 145	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1413: if_icmpge +8 -> 1421
    //   1416: aload_0
    //   1417: iconst_0
    //   1418: putfield 145	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1421: aload_0
    //   1422: aload_0
    //   1423: getfield 143	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1426: iload_1
    //   1427: aload_0
    //   1428: getfield 145	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1431: isub
    //   1432: isub
    //   1433: putfield 143	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1436: aload_0
    //   1437: iload_1
    //   1438: putfield 145	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1441: aload_0
    //   1442: getfield 137	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   1445: ifne +8 -> 1453
    //   1448: aload_0
    //   1449: getfield 143	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1452: istore_1
    //   1453: iload_2
    //   1454: ireturn
    //   1455: astore 10
    //   1457: iload_2
    //   1458: istore_1
    //   1459: goto +12 -> 1471
    //   1462: astore 10
    //   1464: goto +59 -> 1523
    //   1467: astore 10
    //   1469: iconst_0
    //   1470: istore_1
    //   1471: iload_1
    //   1472: istore_2
    //   1473: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1476: ifeq +45 -> 1521
    //   1479: new 246	java/lang/StringBuilder
    //   1482: dup
    //   1483: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1486: astore 11
    //   1488: aload 11
    //   1490: ldc_w 527
    //   1493: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: pop
    //   1497: aload 11
    //   1499: aload 10
    //   1501: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1504: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: pop
    //   1508: ldc 18
    //   1510: iconst_2
    //   1511: aload 11
    //   1513: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1516: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1519: iload_1
    //   1520: istore_2
    //   1521: iload_2
    //   1522: ireturn
    //   1523: goto +6 -> 1529
    //   1526: aload 10
    //   1528: athrow
    //   1529: goto -3 -> 1526
    //   1532: astore 10
    //   1534: goto -1308 -> 226
    //   1537: astore 10
    //   1539: goto -936 -> 603
    //   1542: astore 10
    //   1544: goto -403 -> 1141
    //   1547: iconst_1
    //   1548: istore_2
    //   1549: goto -1203 -> 346
    //   1552: goto -850 -> 702
    //   1555: iconst_0
    //   1556: istore 7
    //   1558: goto +15 -> 1573
    //   1561: iload 4
    //   1563: iconst_1
    //   1564: iadd
    //   1565: istore 4
    //   1567: iconst_0
    //   1568: istore 7
    //   1570: goto -778 -> 792
    //   1573: iload_3
    //   1574: iconst_1
    //   1575: iadd
    //   1576: istore_3
    //   1577: goto -875 -> 702
    //   1580: iconst_m1
    //   1581: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1582	0	this	AudioDeviceInterface
    //   0	1582	1	paramInt	int
    //   20	1529	2	i	int
    //   13	1564	3	j	int
    //   680	886	4	k	int
    //   630	173	5	m	int
    //   803	129	6	n	int
    //   4	1565	7	bool	boolean
    //   378	810	8	l	long
    //   10	82	10	localObject1	Object
    //   140	29	10	localException1	Exception
    //   203	1004	10	localObject2	Object
    //   1216	1	10	localException2	Exception
    //   1260	121	10	localStringBuilder1	StringBuilder
    //   1455	1	10	localException3	Exception
    //   1462	1	10	localObject3	Object
    //   1467	60	10	localException4	Exception
    //   1532	1	10	localIOException	java.io.IOException
    //   1537	1	10	localIllegalStateException	IllegalStateException
    //   1542	1	10	localException5	Exception
    //   155	805	11	localStringBuilder2	StringBuilder
    //   982	20	11	localException6	Exception
    //   1486	26	11	localStringBuilder3	StringBuilder
    //   997	36	12	localStringBuilder4	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   123	137	140	java/lang/Exception
    //   822	849	982	java/lang/Exception
    //   367	447	1216	java/lang/Exception
    //   447	455	1216	java/lang/Exception
    //   463	478	1216	java/lang/Exception
    //   478	540	1216	java/lang/Exception
    //   540	595	1216	java/lang/Exception
    //   595	600	1216	java/lang/Exception
    //   603	618	1216	java/lang/Exception
    //   618	637	1216	java/lang/Exception
    //   657	682	1216	java/lang/Exception
    //   685	694	1216	java/lang/Exception
    //   702	789	1216	java/lang/Exception
    //   849	894	1216	java/lang/Exception
    //   894	967	1216	java/lang/Exception
    //   967	979	1216	java/lang/Exception
    //   984	1040	1216	java/lang/Exception
    //   1040	1054	1216	java/lang/Exception
    //   1054	1059	1216	java/lang/Exception
    //   1062	1068	1216	java/lang/Exception
    //   1141	1156	1216	java/lang/Exception
    //   1158	1214	1216	java/lang/Exception
    //   1235	1243	1455	java/lang/Exception
    //   1247	1314	1455	java/lang/Exception
    //   1321	1388	1455	java/lang/Exception
    //   1388	1421	1455	java/lang/Exception
    //   1421	1453	1455	java/lang/Exception
    //   101	108	1462	finally
    //   111	117	1462	finally
    //   123	137	1462	finally
    //   142	188	1462	finally
    //   188	193	1462	finally
    //   193	205	1462	finally
    //   210	223	1462	finally
    //   226	241	1462	finally
    //   241	248	1462	finally
    //   253	284	1462	finally
    //   284	319	1462	finally
    //   322	327	1462	finally
    //   327	341	1462	finally
    //   346	351	1462	finally
    //   351	363	1462	finally
    //   367	447	1462	finally
    //   447	455	1462	finally
    //   463	478	1462	finally
    //   478	540	1462	finally
    //   540	595	1462	finally
    //   595	600	1462	finally
    //   603	618	1462	finally
    //   618	637	1462	finally
    //   657	682	1462	finally
    //   685	694	1462	finally
    //   702	789	1462	finally
    //   822	849	1462	finally
    //   849	894	1462	finally
    //   894	967	1462	finally
    //   967	979	1462	finally
    //   984	1040	1462	finally
    //   1040	1054	1462	finally
    //   1054	1059	1462	finally
    //   1062	1068	1462	finally
    //   1073	1118	1462	finally
    //   1124	1132	1462	finally
    //   1132	1138	1462	finally
    //   1141	1156	1462	finally
    //   1158	1214	1462	finally
    //   1221	1235	1462	finally
    //   1235	1243	1462	finally
    //   1247	1314	1462	finally
    //   1321	1388	1462	finally
    //   1388	1421	1462	finally
    //   1421	1453	1462	finally
    //   1473	1519	1462	finally
    //   101	108	1467	java/lang/Exception
    //   111	117	1467	java/lang/Exception
    //   142	188	1467	java/lang/Exception
    //   188	193	1467	java/lang/Exception
    //   193	205	1467	java/lang/Exception
    //   210	223	1467	java/lang/Exception
    //   226	241	1467	java/lang/Exception
    //   241	248	1467	java/lang/Exception
    //   253	284	1467	java/lang/Exception
    //   284	319	1467	java/lang/Exception
    //   322	327	1467	java/lang/Exception
    //   327	341	1467	java/lang/Exception
    //   346	351	1467	java/lang/Exception
    //   351	363	1467	java/lang/Exception
    //   1221	1235	1467	java/lang/Exception
    //   210	223	1532	java/io/IOException
    //   463	478	1537	java/lang/IllegalStateException
    //   478	540	1537	java/lang/IllegalStateException
    //   540	595	1537	java/lang/IllegalStateException
    //   595	600	1537	java/lang/IllegalStateException
    //   1073	1118	1542	java/lang/Exception
    //   1124	1132	1542	java/lang/Exception
    //   1132	1138	1542	java/lang/Exception
  }
  
  private int ReadMp3File(int paramInt)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null)
    {
      ByteBuffer localByteBuffer = getDecBuffer(paramInt);
      if (localByteBuffer == null) {
        return -1;
      }
      localByteBuffer.rewind();
      paramInt = localCodecInfo.audioDecoder.getFrameSize();
      int i = localCodecInfo.audioDecoder.ReadOneFrame(localCodecInfo._tempBufdec, paramInt);
      localByteBuffer.put(localCodecInfo._tempBufdec, 0, paramInt);
      return i;
    }
    return -1;
  }
  
  /* Error */
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 137	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   4: ifne +50 -> 54
    //   7: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   10: ifeq +42 -> 52
    //   13: new 246	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   20: astore 5
    //   22: aload 5
    //   24: ldc_w 643
    //   27: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 5
    //   33: aload_0
    //   34: getfield 137	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   37: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 18
    //   43: iconst_2
    //   44: aload 5
    //   46: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: iconst_m1
    //   53: ireturn
    //   54: aload_0
    //   55: getfield 107	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   58: ifnonnull +6 -> 64
    //   61: bipush 254
    //   63: ireturn
    //   64: aload_0
    //   65: getfield 135	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   68: istore 4
    //   70: iload 4
    //   72: iconst_1
    //   73: if_icmpne +73 -> 146
    //   76: bipush 237
    //   78: invokestatic 541	android/os/Process:setThreadPriority	(I)V
    //   81: invokestatic 547	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   84: ldc_w 645
    //   87: invokevirtual 552	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   90: goto +51 -> 141
    //   93: astore 5
    //   95: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   98: ifeq +43 -> 141
    //   101: new 246	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   108: astore 6
    //   110: aload 6
    //   112: ldc_w 647
    //   115: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 6
    //   121: aload 5
    //   123: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: ldc 18
    //   132: iconst_2
    //   133: aload 6
    //   135: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 232	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload_0
    //   142: iconst_0
    //   143: putfield 135	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   146: aload_0
    //   147: getfield 196	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   150: invokevirtual 572	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   153: pop
    //   154: aload_0
    //   155: getfield 107	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   158: aload_0
    //   159: getfield 236	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   162: iconst_0
    //   163: iload_1
    //   164: invokevirtual 650	android/media/AudioRecord:read	([BII)I
    //   167: istore_3
    //   168: iload_3
    //   169: ifge +72 -> 241
    //   172: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   175: ifeq +280 -> 455
    //   178: new 246	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   185: astore 5
    //   187: aload 5
    //   189: ldc_w 652
    //   192: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 5
    //   198: iload_3
    //   199: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 5
    //   205: ldc_w 618
    //   208: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 5
    //   214: iload_1
    //   215: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 5
    //   221: ldc_w 620
    //   224: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: ldc 18
    //   230: iconst_2
    //   231: aload 5
    //   233: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: iconst_m1
    //   240: ireturn
    //   241: aload_0
    //   242: getfield 196	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   245: aload_0
    //   246: getfield 236	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   249: iconst_0
    //   250: iload_3
    //   251: invokevirtual 640	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   254: pop
    //   255: getstatic 556	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   258: ifeq +45 -> 303
    //   261: aload_0
    //   262: getfield 151	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   265: astore 5
    //   267: aload 5
    //   269: ifnull +34 -> 303
    //   272: aload_0
    //   273: getfield 151	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   276: aload_0
    //   277: getfield 236	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   280: iconst_0
    //   281: iload_3
    //   282: invokevirtual 562	java/io/FileOutputStream:write	([BII)V
    //   285: goto +18 -> 303
    //   288: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   291: ifeq +12 -> 303
    //   294: ldc 18
    //   296: iconst_2
    //   297: ldc_w 654
    //   300: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: iload_3
    //   304: istore_2
    //   305: iload_3
    //   306: iload_1
    //   307: if_icmpeq +138 -> 445
    //   310: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   313: ifeq +64 -> 377
    //   316: new 246	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   323: astore 5
    //   325: aload 5
    //   327: ldc_w 656
    //   330: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 5
    //   336: iload_3
    //   337: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 5
    //   343: ldc_w 618
    //   346: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 5
    //   352: iload_1
    //   353: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 5
    //   359: ldc_w 620
    //   362: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: ldc 18
    //   368: iconst_2
    //   369: aload 5
    //   371: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: iconst_m1
    //   378: ireturn
    //   379: astore 5
    //   381: iload_3
    //   382: istore_1
    //   383: goto +12 -> 395
    //   386: astore 5
    //   388: goto +59 -> 447
    //   391: astore 5
    //   393: iconst_0
    //   394: istore_1
    //   395: iload_1
    //   396: istore_2
    //   397: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   400: ifeq +45 -> 445
    //   403: new 246	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   410: astore 6
    //   412: aload 6
    //   414: ldc_w 658
    //   417: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 6
    //   423: aload 5
    //   425: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   428: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: ldc 18
    //   434: iconst_2
    //   435: aload 6
    //   437: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: iload_1
    //   444: istore_2
    //   445: iload_2
    //   446: ireturn
    //   447: aload 5
    //   449: athrow
    //   450: astore 5
    //   452: goto -164 -> 288
    //   455: iconst_m1
    //   456: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	AudioDeviceInterface
    //   0	457	1	paramInt	int
    //   304	142	2	i	int
    //   167	215	3	j	int
    //   68	6	4	bool	boolean
    //   20	25	5	localStringBuilder1	StringBuilder
    //   93	29	5	localException1	Exception
    //   185	185	5	localObject1	Object
    //   379	1	5	localException2	Exception
    //   386	1	5	localObject2	Object
    //   391	57	5	localException3	Exception
    //   450	1	5	localIOException	java.io.IOException
    //   108	328	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   76	90	93	java/lang/Exception
    //   172	239	379	java/lang/Exception
    //   241	267	379	java/lang/Exception
    //   272	285	379	java/lang/Exception
    //   288	303	379	java/lang/Exception
    //   310	377	379	java/lang/Exception
    //   54	61	386	finally
    //   64	70	386	finally
    //   76	90	386	finally
    //   95	141	386	finally
    //   141	146	386	finally
    //   146	168	386	finally
    //   172	239	386	finally
    //   241	267	386	finally
    //   272	285	386	finally
    //   288	303	386	finally
    //   310	377	386	finally
    //   397	443	386	finally
    //   54	61	391	java/lang/Exception
    //   64	70	391	java/lang/Exception
    //   95	141	391	java/lang/Exception
    //   141	146	391	java/lang/Exception
    //   146	168	391	java/lang/Exception
    //   272	285	450	java/io/IOException
  }
  
  private int SeekMp3To(int paramInt1, int paramInt2)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt1);
    if (localCodecInfo != null) {
      return localCodecInfo.audioDecoder.SeekTo(paramInt2);
    }
    return 0;
  }
  
  private int SetAudioOutputMode(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TraeAudioSession SetAudioOutputMode: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0)
    {
      if (mDeviceList != null)
      {
        if (this._asAudioManager == null) {
          return -1;
        }
        int i = 0;
        do
        {
          int j = 0;
          for (;;)
          {
            localObject = mDeviceList;
            paramInt = i;
            if (j >= localObject.length) {
              break;
            }
            paramInt = i;
            if (i != 0) {
              break;
            }
            if ("DEVICE_WIREDHEADSET".equals(localObject[j]))
            {
              this._asAudioManager.connectDevice("DEVICE_WIREDHEADSET");
              paramInt = 1;
              break;
            }
            j += 1;
          }
          j = 0;
          for (;;)
          {
            localObject = mDeviceList;
            i = paramInt;
            if (j >= localObject.length) {
              break;
            }
            i = paramInt;
            if (paramInt != 0) {
              break;
            }
            if ("DEVICE_BLUETOOTHHEADSET".equals(localObject[j]))
            {
              this._asAudioManager.connectDevice("DEVICE_BLUETOOTHHEADSET");
              i = 1;
              break;
            }
            j += 1;
          }
          j = 0;
          for (;;)
          {
            localObject = mDeviceList;
            paramInt = i;
            if (j >= localObject.length) {
              break;
            }
            paramInt = i;
            if (i != 0) {
              break;
            }
            if ("DEVICE_EARPHONE".equals(localObject[j]))
            {
              this._asAudioManager.connectDevice("DEVICE_EARPHONE");
              paramInt = 1;
              break;
            }
            j += 1;
          }
          i = paramInt;
        } while (paramInt == 0);
        return 0;
      }
      return -1;
    }
    if (1 == paramInt)
    {
      localObject = this._asAudioManager;
      if (localObject == null) {
        return -1;
      }
      ((TraeAudioSession)localObject).connectDevice("DEVICE_SPEAKERPHONE");
      return 0;
    }
    return -1;
  }
  
  private int SetPlayoutVolume(int paramInt)
  {
    if (this._audioManager == null)
    {
      localObject = this._context;
      if (localObject != null) {
        this._audioManager = ((AudioManager)((Context)localObject).getSystemService("audio"));
      }
    }
    int i = -1;
    Object localObject = this._audioManager;
    if (localObject != null)
    {
      ((AudioManager)localObject).setStreamVolume(0, paramInt, 0);
      i = 0;
    }
    return i;
  }
  
  private int StartPlayback()
  {
    boolean bool = this._isPlaying;
    int i = -1;
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "StartPlayback _isPlaying");
      }
      return -1;
    }
    Object localObject = this._audioTrack;
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StartPlayback _audioTrack:");
        ((StringBuilder)localObject).append(this._audioTrack);
        QLog.e("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
      }
      return -1;
    }
    try
    {
      ((AudioTrack)localObject).play();
      if (_dumpEnable)
      {
        localObject = this._audioManager;
        if (localObject != null) {
          i = ((AudioManager)localObject).getMode();
        }
        this._play_dump = new File(getDumpFilePath("jniplay.pcm", i));
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label141:
      label178:
      break label178;
    }
    try
    {
      this._play_out = new FileOutputStream(this._play_dump);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label141;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AudioDeviceInterface", 2, "open play dump file failed.");
    }
    this._isPlaying = true;
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "StartPlayback ok");
    }
    return 0;
    if (QLog.isColorLevel()) {
      QLog.e("AudioDeviceInterface", 2, "StartPlayback fail");
    }
    return -1;
  }
  
  private int StartRecording()
  {
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "StartRecording entry");
    }
    boolean bool = this._isRecording;
    int i = -1;
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StartRecording _isRecording:");
        ((StringBuilder)localObject).append(this._isRecording);
        QLog.e("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
      }
      return -1;
    }
    Object localObject = this._audioRecord;
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StartRecording _audioRecord:");
        ((StringBuilder)localObject).append(this._audioRecord);
        QLog.e("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
      }
      return -1;
    }
    try
    {
      ((AudioRecord)localObject).startRecording();
      if (_dumpEnable)
      {
        localObject = this._audioManager;
        if (localObject != null) {
          i = ((AudioManager)localObject).getMode();
        }
        this._rec_dump = new File(getDumpFilePath("jnirecord.pcm", i));
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label182:
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "StartRecording fail");
      }
      localIllegalStateException.printStackTrace();
      return -1;
    }
    try
    {
      this._rec_out = new FileOutputStream(this._rec_dump);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label182;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AudioDeviceInterface", 2, "open rec dump file failed.");
    }
    this._isRecording = true;
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "StartRecording ok");
    }
    return 0;
  }
  
  private int StopPlayback()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("StopPlayback entry _isPlaying:");
      ((StringBuilder)localObject).append(this._isPlaying);
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this._audioTrack;
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StopPlayback _isPlaying:");
        ((StringBuilder)localObject).append(this._isPlaying);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this._audioTrack);
        QLog.e("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
      }
      return -1;
    }
    if (((AudioTrack)localObject).getPlayState() == 3) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "StopPlayback stoping...");
      }
      this._audioTrack.stop();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StopPlayback flushing... state:");
        ((StringBuilder)localObject).append(this._audioTrack.getPlayState());
        QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
      }
      this._audioTrack.flush();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label194:
      break label194;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AudioDeviceInterface", 2, "StopPlayback err");
    }
    return -1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("StopPlayback releaseing... state:");
      ((StringBuilder)localObject).append(this._audioTrack.getPlayState());
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    this._audioTrack.release();
    this._audioTrack = null;
    this._isPlaying = false;
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "StopPlayback exit ok");
    }
    return 0;
  }
  
  private int StopRecording()
  {
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "StopRecording entry");
    }
    Object localObject = this._audioRecord;
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("UnintRecord:");
        ((StringBuilder)localObject).append(this._audioRecord);
        QLog.e("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
      }
      return -1;
    }
    if (((AudioRecord)localObject).getRecordingState() == 3) {}
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StopRecording stop... state:");
        ((StringBuilder)localObject).append(this._audioRecord.getRecordingState());
        QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
      }
      this._audioRecord.stop();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label129:
      break label129;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AudioDeviceInterface", 2, "StopRecording  err");
    }
    return -1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("StopRecording releaseing... state:");
      ((StringBuilder)localObject).append(this._audioRecord.getRecordingState());
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    this._audioRecord.release();
    this._audioRecord = null;
    this._isRecording = false;
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "StopRecording exit ok");
    }
    return 0;
  }
  
  private int getAndroidSdkVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  @TargetApi(16)
  private int getAudioSessionId(AudioRecord paramAudioRecord)
  {
    return 0;
  }
  
  private ByteBuffer getDecBuffer(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDecBuffer failed!! index:");
      localStringBuilder.append(paramInt);
      QLog.w("AudioDeviceInterface", 2, localStringBuilder.toString());
      return null;
    case 10: 
      return this._decBuffer10;
    case 9: 
      return this._decBuffer9;
    case 8: 
      return this._decBuffer8;
    case 7: 
      return this._decBuffer7;
    case 6: 
      return this._decBuffer6;
    case 5: 
      return this._decBuffer5;
    case 4: 
      return this._decBuffer4;
    case 3: 
      return this._decBuffer3;
    case 2: 
      return this._decBuffer2;
    case 1: 
      return this._decBuffer1;
    }
    return this._decBuffer0;
  }
  
  private String getDumpFilePath(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("manufacture:");
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MODEL:");
      ((StringBuilder)localObject).append(Build.MODEL);
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this._context;
    if (localObject == null) {
      return null;
    }
    localObject = ((Context)localObject).getExternalFilesDir(null);
    if (localObject == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getPath());
    localStringBuilder.append("/MF-");
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("-M-");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("-as-");
    localStringBuilder.append(TraeAudioManager.getAudioSource(this._audioSourcePolicy));
    localStringBuilder.append("-st-");
    localStringBuilder.append(this._streamType);
    localStringBuilder.append("-m-");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localObject = new File(paramString);
    if (!((File)localObject).getParentFile().exists()) {
      ((File)localObject).getParentFile().mkdirs();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dump:");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dump replace:");
      ((StringBuilder)localObject).append(paramString.replace(" ", "_"));
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    return paramString.replace(" ", "_");
  }
  
  private int getLowlatencyFramesPerBuffer()
  {
    Object localObject;
    if ((this._context != null) && (Build.VERSION.SDK_INT >= 9))
    {
      boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LOW_LATENCY:");
        if (bool == true) {
          localObject = "Y";
        } else {
          localObject = "N";
        }
        localStringBuilder.append((String)localObject);
        QLog.w("AudioDeviceInterface", 2, localStringBuilder.toString());
      }
      if ((Build.VERSION.SDK_INT < 17) && (QLog.isColorLevel())) {
        QLog.e("AudioDeviceInterface", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      }
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getLowlatencySamplerate err, _context:");
      ((StringBuilder)localObject).append(this._context);
      ((StringBuilder)localObject).append(" api:");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      QLog.e("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    return 0;
  }
  
  private int getLowlatencySamplerate()
  {
    Object localObject;
    if ((this._context != null) && (Build.VERSION.SDK_INT >= 9))
    {
      boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LOW_LATENCY:");
        if (bool == true) {
          localObject = "Y";
        } else {
          localObject = "N";
        }
        localStringBuilder.append((String)localObject);
        QLog.w("AudioDeviceInterface", 2, localStringBuilder.toString());
      }
      if (Build.VERSION.SDK_INT < 17)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AudioDeviceInterface", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
        }
        return 0;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "getLowlatencySamplerate not support right now!");
      }
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getLowlatencySamplerate err, _context:");
      ((StringBuilder)localObject).append(this._context);
      ((StringBuilder)localObject).append(" api:");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      QLog.e("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    return 0;
  }
  
  private int getMp3Channels(int paramInt)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null) {
      return localCodecInfo.audioDecoder.getChannels();
    }
    return -1;
  }
  
  private long getMp3FileTotalMs(int paramInt)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null) {
      return localCodecInfo.audioDecoder.getFileTotalMs();
    }
    return -1L;
  }
  
  private int getMp3SampleRate(int paramInt)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null) {
      return localCodecInfo.audioDecoder.getSampleRate();
    }
    return -1;
  }
  
  private int getPlayRecordSysBufferMs()
  {
    return (this.nRecordLengthMs + this.nPlayLengthMs) * 2;
  }
  
  public static String getTraceInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int i = arrayOfStackTraceElement.length;
    localStringBuffer.append("");
    localStringBuffer.append(arrayOfStackTraceElement[2].getClassName());
    localStringBuffer.append(".");
    localStringBuffer.append(arrayOfStackTraceElement[2].getMethodName());
    localStringBuffer.append(": ");
    localStringBuffer.append(arrayOfStackTraceElement[2].getLineNumber());
    return localStringBuffer.toString();
  }
  
  private void initTRAEAudioManager()
  {
    Context localContext = this._context;
    if (localContext != null)
    {
      TraeAudioManager.init(localContext);
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "initTRAEAudioManager , TraeAudioSession create");
      }
      if (this._asAudioManager == null) {
        this._asAudioManager = new TraeAudioSession(this._context, new AudioDeviceInterface.3(this));
      }
      this._asAudioManager.startService("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
  }
  
  static boolean isHardcodeOpenSles()
  {
    if (Build.MANUFACTURER.equals("Xiaomi"))
    {
      if (Build.MODEL.equals("MI 5")) {
        return true;
      }
      if (Build.MODEL.equals("MI 5s")) {
        return true;
      }
      if (Build.MODEL.equals("MI 5s Plus")) {
        return true;
      }
    }
    else if ((Build.MANUFACTURER.equals("samsung")) && (Build.MODEL.equals("SM-G9350")))
    {
      return true;
    }
    return false;
  }
  
  private int isSupportLowLatency()
  {
    if (isHardcodeOpenSles())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hardcode FEATURE_AUDIO_LOW_LATENCY: ");
        localStringBuilder.append(Build.MANUFACTURER);
        localStringBuilder.append("_");
        localStringBuilder.append(Build.MODEL);
        QLog.w("AudioDeviceInterface", 2, localStringBuilder.toString());
      }
      return 1;
    }
    return 0;
  }
  
  private int isSupportVivoKTVHelper()
  {
    Object localObject = this._context;
    if (localObject != null)
    {
      mVivoKTVHelper = VivoKTVHelper.getInstance((Context)localObject);
      localObject = mVivoKTVHelper;
      if (localObject != null) {
        isSupportVivoKTVHelper = ((VivoKTVHelper)localObject).isDeviceSupportKaraoke();
      }
    }
    if (isSupportVivoKTVHelper == true) {
      return 1;
    }
    return 0;
  }
  
  private int isVivoKTVLoopback()
  {
    VivoKTVHelper localVivoKTVHelper = mVivoKTVHelper;
    if ((localVivoKTVHelper != null) && (isSupportVivoKTVHelper)) {
      return localVivoKTVHelper.getPlayFeedbackParam();
    }
    return 0;
  }
  
  private void onOutputChanage(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onOutputChanage:");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    setAudioRouteSwitchState(paramString);
    if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {
      return;
    }
    int i = this._deviceStat;
    if ((i != 1) && (i != 5) && (i != 2))
    {
      if (i == 3) {
        return;
      }
      this._connectedDev = paramString;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" onOutputChanage:");
        localStringBuilder.append(paramString);
        if (this._audioManager == null)
        {
          localObject = " am==null";
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" mode:");
          ((StringBuilder)localObject).append(this._audioManager.getMode());
          localObject = ((StringBuilder)localObject).toString();
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" st:");
        localStringBuilder.append(this._streamType);
        if (this._audioTrack == null)
        {
          localObject = "_audioTrack==null";
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" at.st:");
          ((StringBuilder)localObject).append(this._audioTrack.getStreamType());
          localObject = ((StringBuilder)localObject).toString();
        }
        localStringBuilder.append((String)localObject);
        QLog.w("AudioDeviceInterface", 2, localStringBuilder.toString());
      }
      try
      {
        if (this._audioManager == null) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" curr mode:");
          ((StringBuilder)localObject).append(paramString);
          if (this._audioManager == null)
          {
            paramString = "am==null";
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append(" mode:");
            paramString.append(this._audioManager.getMode());
            paramString = paramString.toString();
          }
          ((StringBuilder)localObject).append(paramString);
          QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
        }
        if ((this._audioManager != null) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
          this._audioManager.setMode(0);
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w("AudioDeviceInterface", 2, paramString.getMessage());
        }
      }
      this._audioRouteChanged = true;
    }
  }
  
  private void setAudioRouteSwitchState(String paramString)
  {
    if (paramString.equals("DEVICE_EARPHONE"))
    {
      this.switchState = 1;
      return;
    }
    if (paramString.equals("DEVICE_SPEAKERPHONE"))
    {
      this.switchState = 2;
      return;
    }
    if (paramString.equals("DEVICE_WIREDHEADSET"))
    {
      this.switchState = 3;
      return;
    }
    if (paramString.equals("DEVICE_BLUETOOTHHEADSET"))
    {
      this.switchState = 4;
      return;
    }
    this.switchState = 0;
  }
  
  private int startService(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initTRAEAudioManager , TraeAudioSession startService: ");
      ((StringBuilder)localObject).append(this._asAudioManager);
      ((StringBuilder)localObject).append(" deviceConfig:");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this._asAudioManager;
    if (localObject != null) {
      return ((TraeAudioSession)localObject).startService(paramString);
    }
    return -1;
  }
  
  private int stopService()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initTRAEAudioManager , TraeAudioSession stopService: ");
      ((StringBuilder)localObject).append(this._asAudioManager);
      QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this._asAudioManager;
    if (localObject != null) {
      return ((TraeAudioSession)localObject).stopService();
    }
    return -1;
  }
  
  private void uninitTRAEAudioManager()
  {
    if (this._context != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "uninitTRAEAudioManager , stopService");
      }
      TraeAudioSession localTraeAudioSession = this._asAudioManager;
      if (localTraeAudioSession != null)
      {
        localTraeAudioSession.stopService();
        this._asAudioManager.release();
        this._asAudioManager = null;
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.w("AudioDeviceInterface", 2, "uninitTRAEAudioManager , context null");
    }
  }
  
  public int GetPlayoutVolume()
  {
    try
    {
      if ((this._audioManager == null) && (this._context != null)) {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
      }
      if (this._audioManager != null)
      {
        int i = this._audioManager.getStreamVolume(this._streamType);
        return i;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE GetPlayoutVolume", 2, localException.getMessage());
      }
    }
    return -1;
  }
  
  public int call_postprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    TraeAudioSession localTraeAudioSession = this._as;
    if (localTraeAudioSession != null)
    {
      localTraeAudioSession.voiceCallPostprocess();
      this._as.release();
      this._as = null;
    }
    TraeAudioManager.IsUpdateSceneFlag = false;
    LogTraceExit();
    return 0;
  }
  
  public int call_postprocess_media()
  {
    LogTraceEntry("");
    this.switchState = 0;
    Object localObject = this._as;
    if (localObject != null)
    {
      ((TraeAudioSession)localObject).release();
      this._as = null;
    }
    TraeAudioManager.IsUpdateSceneFlag = false;
    localObject = mVivoKTVHelper;
    if ((localObject != null) && (isSupportVivoKTVHelper)) {
      ((VivoKTVHelper)localObject).closeKTVDevice();
    }
    LogTraceExit();
    return 0;
  }
  
  /* Error */
  public int call_preprocess()
  {
    // Byte code:
    //   0: ldc_w 865
    //   3: invokestatic 980	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:LogTraceEntry	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 184	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:switchState	I
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioStreamTypePolicy	I
    //   16: invokestatic 351	com/tencent/rtmp/sharp/jni/TraeAudioManager:getAudioStreamType	(I)I
    //   19: putfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   22: aload_0
    //   23: getfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   26: ifnonnull +26 -> 52
    //   29: aload_0
    //   30: new 392	com/tencent/rtmp/sharp/jni/TraeAudioSession
    //   33: dup
    //   34: aload_0
    //   35: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   38: new 994	com/tencent/rtmp/sharp/jni/AudioDeviceInterface$1
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 995	com/tencent/rtmp/sharp/jni/AudioDeviceInterface$1:<init>	(Lcom/tencent/rtmp/sharp/jni/AudioDeviceInterface;)V
    //   46: invokespecial 902	com/tencent/rtmp/sharp/jni/TraeAudioSession:<init>	(Landroid/content/Context;Lcom/tencent/rtmp/sharp/jni/TraeAudioSession$ITraeAudioCallback;)V
    //   49: putfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 180	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_preDone	Z
    //   57: aload_0
    //   58: getfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   61: ifnull +300 -> 361
    //   64: aload_0
    //   65: getfield 172	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_prelock	Ljava/util/concurrent/locks/ReentrantLock;
    //   68: invokevirtual 998	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   71: aload_0
    //   72: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   75: ifnonnull +20 -> 95
    //   78: aload_0
    //   79: aload_0
    //   80: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   83: ldc_w 323
    //   86: invokevirtual 329	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   89: checkcast 331	android/media/AudioManager
    //   92: putfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   95: aload_0
    //   96: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   99: astore_2
    //   100: aload_2
    //   101: ifnull +121 -> 222
    //   104: aload_0
    //   105: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   108: invokevirtual 359	android/media/AudioManager:getMode	()I
    //   111: iconst_2
    //   112: if_icmpne +77 -> 189
    //   115: iconst_5
    //   116: istore_1
    //   117: iload_1
    //   118: ifle +71 -> 189
    //   121: aload_0
    //   122: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   125: invokevirtual 359	android/media/AudioManager:getMode	()I
    //   128: iconst_2
    //   129: if_icmpne +60 -> 189
    //   132: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   135: ifeq +41 -> 176
    //   138: new 246	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   145: astore_2
    //   146: aload_2
    //   147: ldc_w 1000
    //   150: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_2
    //   155: aload_0
    //   156: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   159: invokevirtual 359	android/media/AudioManager:getMode	()I
    //   162: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: ldc 18
    //   168: iconst_2
    //   169: aload_2
    //   170: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: ldc2_w 1001
    //   179: invokestatic 1005	java/lang/Thread:sleep	(J)V
    //   182: iload_1
    //   183: iconst_1
    //   184: isub
    //   185: istore_1
    //   186: goto -69 -> 117
    //   189: aload_0
    //   190: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   193: invokevirtual 1008	android/media/AudioManager:isMicrophoneMute	()Z
    //   196: ifeq +26 -> 222
    //   199: aload_0
    //   200: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   203: iconst_0
    //   204: invokevirtual 1012	android/media/AudioManager:setMicrophoneMute	(Z)V
    //   207: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   210: ifeq +12 -> 222
    //   213: ldc 18
    //   215: iconst_2
    //   216: ldc_w 1014
    //   219: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_0
    //   223: getfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   226: aload_0
    //   227: getfield 125	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_modePolicy	I
    //   230: aload_0
    //   231: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   234: invokevirtual 1017	com/tencent/rtmp/sharp/jni/TraeAudioSession:voiceCallPreprocess	(II)I
    //   237: pop
    //   238: aload_0
    //   239: getfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   242: invokevirtual 1020	com/tencent/rtmp/sharp/jni/TraeAudioSession:connectHighestPriorityDevice	()I
    //   245: pop
    //   246: bipush 7
    //   248: istore_1
    //   249: iload_1
    //   250: ifle +68 -> 318
    //   253: aload_0
    //   254: getfield 180	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_preDone	Z
    //   257: ifne +61 -> 318
    //   260: aload_0
    //   261: getfield 178	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_precon	Ljava/util/concurrent/locks/Condition;
    //   264: lconst_1
    //   265: getstatic 1026	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   268: invokeinterface 1032 4 0
    //   273: pop
    //   274: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   277: ifeq +97 -> 374
    //   280: new 246	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   287: astore_2
    //   288: aload_2
    //   289: ldc_w 1034
    //   292: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_2
    //   297: aload_0
    //   298: getfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   301: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: ldc 18
    //   307: iconst_2
    //   308: aload_2
    //   309: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: goto +59 -> 374
    //   318: invokestatic 224	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   321: ifeq +12 -> 333
    //   324: ldc 18
    //   326: iconst_2
    //   327: ldc_w 1036
    //   330: invokestatic 422	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload_0
    //   334: getfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   337: invokevirtual 1039	com/tencent/rtmp/sharp/jni/TraeAudioSession:getConnectedDevice	()I
    //   340: pop
    //   341: goto +13 -> 354
    //   344: astore_2
    //   345: aload_0
    //   346: getfield 172	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_prelock	Ljava/util/concurrent/locks/ReentrantLock;
    //   349: invokevirtual 1042	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   352: aload_2
    //   353: athrow
    //   354: aload_0
    //   355: getfield 172	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_prelock	Ljava/util/concurrent/locks/ReentrantLock;
    //   358: invokevirtual 1042	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   361: invokestatic 985	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:LogTraceExit	()V
    //   364: iconst_0
    //   365: ireturn
    //   366: astore_2
    //   367: goto -13 -> 354
    //   370: astore_2
    //   371: goto -38 -> 333
    //   374: iload_1
    //   375: iconst_1
    //   376: isub
    //   377: istore_1
    //   378: goto -129 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	AudioDeviceInterface
    //   116	262	1	i	int
    //   99	210	2	localObject1	Object
    //   344	9	2	localObject2	Object
    //   366	1	2	localInterruptedException1	InterruptedException
    //   370	1	2	localInterruptedException2	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   71	95	344	finally
    //   95	100	344	finally
    //   104	115	344	finally
    //   121	176	344	finally
    //   176	182	344	finally
    //   189	222	344	finally
    //   222	246	344	finally
    //   253	315	344	finally
    //   318	333	344	finally
    //   333	341	344	finally
    //   71	95	366	java/lang/InterruptedException
    //   95	100	366	java/lang/InterruptedException
    //   104	115	366	java/lang/InterruptedException
    //   121	176	366	java/lang/InterruptedException
    //   176	182	366	java/lang/InterruptedException
    //   189	222	366	java/lang/InterruptedException
    //   222	246	366	java/lang/InterruptedException
    //   333	341	366	java/lang/InterruptedException
    //   253	315	370	java/lang/InterruptedException
    //   318	333	370	java/lang/InterruptedException
  }
  
  public int call_preprocess_media()
  {
    LogTraceEntry("");
    this.switchState = 0;
    Object localObject = mVivoKTVHelper;
    if ((localObject != null) && (isSupportVivoKTVHelper))
    {
      ((VivoKTVHelper)localObject).openKTVDevice();
      mVivoKTVHelper.setPreModeParam(1);
      mVivoKTVHelper.setPlayFeedbackParam(1);
      mVivoKTVHelper.setPlayFeedbackParam(0);
    }
    if (this._as == null) {
      this._as = new TraeAudioSession(this._context, new AudioDeviceInterface.2(this));
    }
    if (this._as != null) {}
    try
    {
      if (this._audioManager == null) {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
      }
      localObject = this._audioManager;
      if (localObject != null)
      {
        if (this._audioManager.getMode() == 2)
        {
          int i = 5;
          while ((i > 0) && (this._audioManager.getMode() == 2))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("media call_preprocess_media waiting...  mode:");
              ((StringBuilder)localObject).append(this._audioManager.getMode());
              QLog.e("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
            }
            Thread.sleep(500L);
            i -= 1;
          }
        }
        if (this._audioManager.getMode() != 0) {
          this._audioManager.setMode(0);
        }
        if (this._audioManager.isMicrophoneMute())
        {
          this._audioManager.setMicrophoneMute(false);
          if (QLog.isColorLevel()) {
            QLog.e("AudioDeviceInterface", 2, "media call_preprocess_media setMicrophoneMute false");
          }
        }
      }
      this._as.connectHighestPriorityDevice();
      this._as.getConnectedDevice();
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "call_preprocess_media done!");
      }
      label287:
      LogTraceExit();
    }
    catch (InterruptedException localInterruptedException)
    {
      break label287;
    }
    return 0;
  }
  
  @SuppressLint({"NewApi"})
  public int checkAACMediaCodecSupported(boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        i = Build.VERSION.SDK_INT;
        Object localObject;
        if (i >= 21)
        {
          localObject = new MediaCodecList(1).getCodecInfos();
          k = localObject.length;
          i = 0;
          if (i >= k) {
            continue;
          }
          localMediaCodecInfo = localObject[i];
          if (localMediaCodecInfo.isEncoder() == paramBoolean) {
            break label337;
          }
          if (localMediaCodecInfo.getName().toLowerCase().contains("nvidia")) {
            return 0;
          }
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          j = 0;
          if (j >= arrayOfString.length) {
            break label337;
          }
          if (!arrayOfString[j].equalsIgnoreCase("audio/mp4a-latm")) {
            break label330;
          }
          if (!QLog.isColorLevel()) {
            break label328;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkAACSupported support!, ");
          ((StringBuilder)localObject).append(localMediaCodecInfo.getName());
          QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
          return 1;
        }
        int k = MediaCodecList.getCodecCount();
        i = 0;
        if (i >= k) {
          continue;
        }
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        if (localMediaCodecInfo.isEncoder() != paramBoolean)
        {
          if (localMediaCodecInfo.getName().toLowerCase().contains("nvidia")) {
            return 0;
          }
          localObject = localMediaCodecInfo.getSupportedTypes();
          j = 0;
          if (j < localObject.length)
          {
            if (localObject[j].equalsIgnoreCase("audio/mp4a-latm"))
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("checkAACSupported support!, ");
                ((StringBuilder)localObject).append(localMediaCodecInfo.getName());
                QLog.w("AudioDeviceInterface", 2, ((StringBuilder)localObject).toString());
              }
              return 1;
            }
            j += 1;
            continue;
          }
        }
        i += 1;
        continue;
      }
      catch (Exception localException)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "check if support aac codec failed.");
      }
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "Error when checking aac codec availability");
      }
      return 0;
      label328:
      return 1;
      label330:
      j += 1;
      continue;
      label337:
      i += 1;
    }
  }
  
  public int checkAACSupported()
  {
    int i = checkAACMediaCodecSupported(false);
    int j = checkAACMediaCodecSupported(true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAACSupported isSupportEncoder: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", isSupportDecoder:");
      localStringBuilder.append(j);
      QLog.w("AudioDeviceInterface", 2, localStringBuilder.toString());
    }
    if ((i == 1) && (j == 1)) {
      return 1;
    }
    return 0;
  }
  
  public int getAudioRouteSwitchState()
  {
    return this.switchState;
  }
  
  public int getMode()
  {
    try
    {
      if ((this._audioManager == null) && (this._context != null)) {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
      }
      if (this._audioManager != null)
      {
        int i = this._audioManager.getMode();
        return i;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE getMode", 2, localException.getMessage());
      }
    }
    return -1;
  }
  
  public int getNumberOfCPUCores()
  {
    if (Build.VERSION.SDK_INT <= 10) {
      return 1;
    }
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
      return i;
    }
    catch (SecurityException|NullPointerException localSecurityException) {}
    return -1;
  }
  
  public int hasLightSensorManager()
  {
    Object localObject = this._context;
    if (localObject == null) {
      return 1;
    }
    try
    {
      localObject = ((SensorManager)((Context)localObject).getSystemService("sensor")).getDefaultSensor(5);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("AudioDeviceInterface", 2, "not hasLightSensorManager null == sensor8");
        }
        return 0;
      }
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "hasLightSensorManager");
      }
      return 1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, localException.getMessage());
      }
    }
    return 1;
  }
  
  public int isBackground()
  {
    Object localObject = this._context;
    if (localObject == null) {
      return 0;
    }
    try
    {
      localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
      List localList = ((ActivityManager)localObject).getRunningTasks(1);
      if (localList == null)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("AudioDeviceInterface", 2, "running task is null, ams is abnormal!!!");
          return 0;
        }
      }
      else
      {
        localObject = (ActivityManager.RunningTaskInfo)((ActivityManager)localObject).getRunningTasks(1).get(0);
        if ((localObject != null) && (((ActivityManager.RunningTaskInfo)localObject).topActivity != null))
        {
          if (!(((ActivityManager.RunningTaskInfo)localObject).topActivity.getPackageName().equals(this._context.getPackageName()) ^ true)) {
            break label141;
          }
          return 1;
        }
        if (QLog.isColorLevel()) {
          QLog.e("AudioDeviceInterface", 2, "failed to get RunningTaskInfo");
        }
        return 0;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE isBackground", 2, localException.getMessage());
      }
      return 0;
    }
    return 0;
    label141:
    return 0;
  }
  
  public void setContext(Context paramContext)
  {
    this._context = paramContext;
  }
  
  public void setJavaInterface(int paramInt)
  {
    if (paramInt == 0) {
      this.usingJava = false;
    } else {
      this.usingJava = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setJavaInterface flg:");
      localStringBuilder.append(paramInt);
      QLog.w("AudioDeviceInterface", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioDeviceInterface
 * JD-Core Version:    0.7.0.1
 */