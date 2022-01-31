package com.tencent.sharp.jni;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import bfll;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class AudioDeviceInterface
{
  private static boolean _dumpEnable;
  private static boolean _logEnable = true;
  private boolean _IsBluetoothStreamVolume;
  private int _RecordSamplerate = 8000;
  private TraeAudioSession _as;
  private AudioManager _audioManager;
  private AudioRecord _audioRecord;
  private boolean _audioRecordChanged;
  private boolean _audioRouteChanged;
  private int _audioSource = 0;
  private int _audioSourcePolicy = -1;
  private int _audioStreamTypePolicy = -1;
  private AudioTrack _audioTrack;
  private int _bufferedPlaySamples;
  private int _bufferedRecSamples;
  private int _channelPlayType = 4;
  private int _channelRecordType = 4;
  private String _connectedDev = "DEVICE_NONE";
  private Context _context;
  private boolean _doPlayInit = true;
  private boolean _doRecInit = true;
  private boolean _isPlaying;
  private boolean _isRecording;
  private int _modePolicy = -1;
  private ByteBuffer _playBuffer;
  private final ReentrantLock _playLock = new ReentrantLock();
  private int _playPosition;
  private int _playSamplerate = 8000;
  private File _play_dump;
  private FileOutputStream _play_out;
  private boolean _preDone;
  private Condition _precon = this._prelock.newCondition();
  private ReentrantLock _prelock = new ReentrantLock();
  private ByteBuffer _recBuffer;
  private final ReentrantLock _recLock = new ReentrantLock();
  private File _rec_dump;
  private FileOutputStream _rec_out;
  private int _sessionId;
  private int _streamType = 0;
  private byte[] _tempBufPlay;
  private byte[] _tempBufRec;
  private int switchState;
  private boolean usingJava = true;
  
  public AudioDeviceInterface()
  {
    try
    {
      this._playBuffer = ByteBuffer.allocateDirect(1920);
      this._recBuffer = ByteBuffer.allocateDirect(1920);
      this._tempBufPlay = new byte[1920];
      this._tempBufRec = new byte[1920];
      int i = Build.VERSION.SDK_INT;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "AudioDeviceInterface apiLevel:" + i);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " SDK_INT:" + Build.VERSION.SDK_INT);
      }
      if ((i > 0) || (QLog.isColorLevel())) {
        QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException.getMessage());
        }
      }
    }
  }
  
  private int GetPlayoutVolume()
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null) {
      i = this._audioManager.getStreamVolume(0);
    }
    return i;
  }
  
  private int InitPlayback(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitPlayback entry: sampleRate " + paramInt1);
    }
    if ((this._isPlaying) || (this._audioTrack != null) || (paramInt2 > 2) || (paramInt2 < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitPlayback _isPlaying:" + this._isPlaying);
      }
      return -1;
    }
    if (this._audioManager == null) {}
    label544:
    for (;;)
    {
      try
      {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        if (paramInt2 == 2)
        {
          this._channelPlayType = 12;
          this._playSamplerate = paramInt1;
          int j = AudioTrack.getMinBufferSize(paramInt1, this._channelPlayType, 2);
          if (this._channelPlayType == 12)
          {
            if (!QLog.isColorLevel()) {
              break label429;
            }
            QLog.w("TRAE", 2, "InitPlayback, _channelPlayType stero");
          }
          int k = paramInt1 * 20 * paramInt2 * 2 / 1000;
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback: minPlayBufSize:" + j + " 20msFz:" + k);
          }
          this._bufferedPlaySamples = 0;
          if (this._audioTrack != null)
          {
            this._audioTrack.release();
            this._audioTrack = null;
          }
          int[] arrayOfInt = new int[4];
          tmp251_249 = arrayOfInt;
          tmp251_249[0] = 0;
          tmp255_251 = tmp251_249;
          tmp255_251[1] = 0;
          tmp259_255 = tmp255_251;
          tmp259_255[2] = 3;
          tmp263_259 = tmp259_255;
          tmp263_259[3] = 1;
          tmp263_259;
          this._streamType = TraeAudioManager.b(this._audioStreamTypePolicy);
          if (this._audioRouteChanged) {
            break label454;
          }
          arrayOfInt[0] = this._streamType;
          paramInt2 = 0;
          paramInt1 = j;
          if ((paramInt2 >= arrayOfInt.length) || (this._audioTrack != null)) {
            break;
          }
          this._streamType = arrayOfInt[paramInt2];
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback: min play buf size is " + j + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
          }
          int i = 1;
          if (i > 2) {
            break label708;
          }
          paramInt1 = j * i;
          if ((paramInt1 >= k * 4) || (i >= 2)) {
            break label544;
          }
          i += 1;
          continue;
        }
        this._channelPlayType = 4;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException1.getMessage());
        }
        return -1;
      }
      continue;
      label429:
      if ((this._channelPlayType == 4) && (QLog.isColorLevel()))
      {
        QLog.w("TRAE", 2, "InitPlayback, _channelPlayType Mono");
        continue;
        label454:
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "_audioRouteChanged:" + this._audioRouteChanged + " _streamType:" + this._streamType);
        }
        if ((this._audioManager.getMode() == 0) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {}
        for (this._streamType = 3;; this._streamType = 0)
        {
          this._audioRouteChanged = false;
          break;
        }
        try
        {
          this._audioTrack = new AudioTrack(this._streamType, this._playSamplerate, this._channelPlayType, 2, paramInt1, 1);
          if (this._audioTrack.getState() == 1) {
            break label708;
          }
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback: play not initialized playBufSize:" + paramInt1 + " sr:" + this._playSamplerate);
          }
          this._audioTrack.release();
          this._audioTrack = null;
        }
        catch (Exception localException2)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, localException2.getMessage() + " _audioTrack:" + this._audioTrack);
          }
          if (this._audioTrack != null) {
            this._audioTrack.release();
          }
          this._audioTrack = null;
        }
        continue;
        label708:
        paramInt2 += 1;
      }
    }
    if (this._audioTrack == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InitPlayback fail!!!");
      }
      return -1;
    }
    if ((this._as != null) && (this._audioManager != null)) {
      this._as.b(this._audioManager.getMode(), this._streamType);
    }
    this._playPosition = this._audioTrack.getPlaybackHeadPosition();
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitPlayback exit: streamType:" + this._streamType + " samplerate:" + this._playSamplerate + " _playPosition:" + this._playPosition + " playBufSize:" + paramInt1);
    }
    if (this._connectedDev.equals("DEVICE_BLUETOOTHHEADSET"))
    {
      paramInt1 = 6;
      if (paramInt1 != 6) {
        break label902;
      }
    }
    label902:
    for (this._IsBluetoothStreamVolume = true;; this._IsBluetoothStreamVolume = false)
    {
      TraeAudioManager.a(this._audioManager, paramInt1);
      return 0;
      paramInt1 = this._audioTrack.getStreamType();
      break;
    }
  }
  
  private int InitRecording(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording entry:" + paramInt1);
    }
    if ((this._isRecording) || (this._audioRecord != null) || (paramInt2 > 2) || (paramInt2 < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitRecording _isRecording:" + this._isRecording);
      }
      return -1;
    }
    if (this._audioManager == null) {}
    for (;;)
    {
      int i;
      try
      {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        this._channelRecordType = 16;
        if (paramInt2 == 2) {
          this._channelRecordType = 12;
        }
        this._RecordSamplerate = paramInt1;
        int k = AudioRecord.getMinBufferSize(paramInt1, this._channelRecordType, 2);
        int m = paramInt1 * 20 * paramInt2 * 2 / 1000;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitRecording: min rec buf size is " + k + " sr:" + getLowlatencySamplerate() + " fp" + getLowlatencyFramesPerBuffer() + " 20msFZ:" + m);
        }
        this._bufferedRecSamples = (paramInt1 * 5 / 200);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "  rough rec delay set to " + this._bufferedRecSamples);
        }
        if (this._audioRecord != null)
        {
          this._audioRecord.release();
          this._audioRecord = null;
        }
        int[] arrayOfInt = new int[4];
        int[] tmp305_303 = arrayOfInt;
        tmp305_303[0] = 0;
        int[] tmp309_305 = tmp305_303;
        tmp309_305[1] = 1;
        int[] tmp313_309 = tmp309_305;
        tmp313_309[2] = 5;
        int[] tmp317_313 = tmp313_309;
        tmp317_313[3] = 0;
        tmp317_313;
        arrayOfInt[0] = TraeAudioManager.a(this._audioSourcePolicy);
        if (!this._audioRecordChanged)
        {
          i = 0;
          paramInt2 = k;
          if ((i >= arrayOfInt.length) || (this._audioRecord != null)) {
            break;
          }
          this._audioSource = arrayOfInt[i];
          int j = 1;
          if (j > 2) {
            break label682;
          }
          paramInt2 = k * j;
          if ((paramInt2 >= m * 4) || (j >= 2)) {
            break label512;
          }
          j += 1;
          continue;
        }
        if (this._audioManager.getMode() != 0) {
          break label500;
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException1.getMessage());
        }
        return -1;
      }
      if (this._connectedDev.equals("DEVICE_SPEAKERPHONE")) {
        localException1[0] = TraeAudioManager.a(0);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitRecording _audioRecordChanged as[0]:" + localException1[0]);
        }
        this._audioRecordChanged = false;
        break;
        label500:
        localException1[0] = TraeAudioManager.a(7);
      }
      try
      {
        label512:
        this._audioRecord = new AudioRecord(this._audioSource, paramInt1, this._channelRecordType, 2, paramInt2);
        if (this._audioRecord.getState() == 1) {
          break label682;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitRecording:  rec not initialized,try agine,  minbufsize:" + paramInt2 + " sr:" + paramInt1 + " as:" + this._audioSource);
        }
        this._audioRecord.release();
        this._audioRecord = null;
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException2.getMessage() + " _audioRecord:" + this._audioRecord);
        }
        if (this._audioRecord != null) {
          this._audioRecord.release();
        }
        this._audioRecord = null;
      }
      continue;
      label682:
      i += 1;
    }
    if (this._audioRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InitRecording fail!!!");
      }
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " [Config] InitRecording: audioSession:" + this._sessionId + " audioSource:" + this._audioSource + " rec sample rate set to " + paramInt1 + " recBufSize:" + paramInt2);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording exit");
    }
    return this._bufferedRecSamples;
  }
  
  private int InitSetting(int paramInt1, int paramInt2, int paramInt3)
  {
    this._audioSourcePolicy = paramInt1;
    this._audioStreamTypePolicy = paramInt2;
    this._modePolicy = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy);
    }
    return 0;
  }
  
  public static final void LogTraceEntry(String paramString)
  {
    if (!_logEnable) {}
    do
    {
      return;
      paramString = getTraceInfo() + " entry:" + paramString;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, paramString);
  }
  
  public static final void LogTraceExit()
  {
    if (!_logEnable) {}
    String str;
    do
    {
      return;
      str = getTraceInfo() + " exit";
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, str);
  }
  
  private int OpenslesNeedResetAudioTrack(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!TraeAudioManager.a(this._modePolicy)) {
          return -1;
        }
        if ((this._audioRouteChanged) || (paramBoolean))
        {
          if ((this._audioManager == null) && (this._context != null)) {
            this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
          }
          if (this._audioManager == null) {
            return 0;
          }
          if ((this._audioManager.getMode() != 0) || (!this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
            continue;
          }
          this._audioStreamTypePolicy = 3;
          this._audioRouteChanged = false;
          this._audioRecordChanged = false;
        }
      }
      catch (Exception localException)
      {
        localException = localException;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TRAE", 2, "PlayAudio Exception: " + localException.getMessage());
        continue;
      }
      finally {}
      return this._audioStreamTypePolicy;
      this._audioStreamTypePolicy = 0;
    }
  }
  
  /* Error */
  private int PlayAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 207	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   4: ifne +70 -> 74
    //   7: iconst_1
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   13: ifnonnull +66 -> 79
    //   16: iconst_1
    //   17: istore_3
    //   18: iload_2
    //   19: iload_3
    //   20: ior
    //   21: ifeq +63 -> 84
    //   24: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +45 -> 72
    //   30: ldc 144
    //   32: iconst_2
    //   33: new 146	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 402
    //   43: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 207	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   50: invokevirtual 214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc_w 404
    //   56: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   63: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: iconst_m1
    //   73: ireturn
    //   74: iconst_0
    //   75: istore_2
    //   76: goto -67 -> 9
    //   79: iconst_0
    //   80: istore_3
    //   81: goto -63 -> 18
    //   84: aload_0
    //   85: getfield 93	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   88: invokevirtual 407	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   91: aload_0
    //   92: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   95: astore 10
    //   97: aload 10
    //   99: ifnonnull +13 -> 112
    //   102: aload_0
    //   103: getfield 93	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   106: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   109: bipush 254
    //   111: ireturn
    //   112: aload_0
    //   113: getfield 97	com/tencent/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   116: istore 7
    //   118: iload 7
    //   120: iconst_1
    //   121: if_icmpne +13 -> 134
    //   124: bipush 237
    //   126: invokestatic 416	android/os/Process:setThreadPriority	(I)V
    //   129: aload_0
    //   130: iconst_0
    //   131: putfield 97	com/tencent/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   134: getstatic 418	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   137: ifeq +27 -> 164
    //   140: aload_0
    //   141: getfield 420	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   144: astore 10
    //   146: aload 10
    //   148: ifnull +16 -> 164
    //   151: aload_0
    //   152: getfield 420	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   155: aload_0
    //   156: getfield 129	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   159: iconst_0
    //   160: iconst_0
    //   161: invokevirtual 426	java/io/FileOutputStream:write	([BII)V
    //   164: aload_0
    //   165: getfield 241	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   168: ifne +513 -> 681
    //   171: iconst_0
    //   172: istore_2
    //   173: aload_0
    //   174: getfield 125	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   177: aload_0
    //   178: getfield 129	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   181: invokevirtual 430	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   184: pop
    //   185: iload_2
    //   186: ifeq +948 -> 1134
    //   189: aload_0
    //   190: getfield 125	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   193: invokevirtual 434	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   196: pop
    //   197: invokestatic 440	android/os/SystemClock:elapsedRealtime	()J
    //   200: lstore 8
    //   202: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +48 -> 253
    //   208: ldc 144
    //   210: iconst_2
    //   211: new 146	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 442
    //   221: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_0
    //   225: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   228: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: ldc_w 444
    //   234: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   241: invokevirtual 312	android/media/AudioTrack:getStreamType	()I
    //   244: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_0
    //   254: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   257: invokevirtual 447	android/media/AudioTrack:getPlayState	()I
    //   260: istore_2
    //   261: iload_2
    //   262: iconst_3
    //   263: if_icmpne +120 -> 383
    //   266: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +12 -> 281
    //   272: ldc 144
    //   274: iconst_2
    //   275: ldc_w 449
    //   278: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_0
    //   282: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   285: invokevirtual 452	android/media/AudioTrack:stop	()V
    //   288: aload_0
    //   289: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   292: invokevirtual 455	android/media/AudioTrack:flush	()V
    //   295: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +35 -> 333
    //   301: ldc 144
    //   303: iconst_2
    //   304: new 146	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 457
    //   314: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   321: invokevirtual 447	android/media/AudioTrack:getPlayState	()I
    //   324: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload_0
    //   334: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   337: invokevirtual 234	android/media/AudioTrack:release	()V
    //   340: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +35 -> 378
    //   346: ldc 144
    //   348: iconst_2
    //   349: new 146	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 459
    //   359: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_0
    //   363: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   366: invokevirtual 447	android/media/AudioTrack:getPlayState	()I
    //   369: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload_0
    //   379: aconst_null
    //   380: putfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   383: aload_0
    //   384: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   387: aload_0
    //   388: getfield 101	com/tencent/sharp/jni/AudioDeviceInterface:_channelPlayType	I
    //   391: iconst_2
    //   392: invokestatic 223	android/media/AudioTrack:getMinBufferSize	(III)I
    //   395: istore 5
    //   397: iconst_4
    //   398: newarray int
    //   400: astore 10
    //   402: aload 10
    //   404: dup
    //   405: iconst_0
    //   406: iconst_0
    //   407: iastore
    //   408: dup
    //   409: iconst_1
    //   410: iconst_0
    //   411: iastore
    //   412: dup
    //   413: iconst_2
    //   414: iconst_3
    //   415: iastore
    //   416: dup
    //   417: iconst_3
    //   418: iconst_1
    //   419: iastore
    //   420: pop
    //   421: aload 10
    //   423: iconst_0
    //   424: aload_0
    //   425: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   428: iastore
    //   429: aload_0
    //   430: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   433: bipush 20
    //   435: imul
    //   436: iconst_1
    //   437: imul
    //   438: iconst_2
    //   439: imul
    //   440: sipush 1000
    //   443: idiv
    //   444: istore_2
    //   445: aload_0
    //   446: getfield 101	com/tencent/sharp/jni/AudioDeviceInterface:_channelPlayType	I
    //   449: bipush 12
    //   451: if_icmpne +902 -> 1353
    //   454: iload_2
    //   455: iconst_2
    //   456: imul
    //   457: istore_2
    //   458: goto +895 -> 1353
    //   461: iload_3
    //   462: aload 10
    //   464: arraylength
    //   465: if_icmpge +537 -> 1002
    //   468: aload_0
    //   469: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   472: ifnonnull +530 -> 1002
    //   475: aload_0
    //   476: aload 10
    //   478: iload_3
    //   479: iaload
    //   480: putfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   483: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq +44 -> 530
    //   489: ldc 144
    //   491: iconst_2
    //   492: new 146	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   499: ldc 243
    //   501: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: iload 5
    //   506: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: ldc 245
    //   511: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload_0
    //   515: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   518: invokestatic 248	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   521: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   524: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   530: iconst_1
    //   531: istore 4
    //   533: iload 4
    //   535: iconst_2
    //   536: if_icmpgt +822 -> 1358
    //   539: iload 5
    //   541: iload 4
    //   543: imul
    //   544: istore 6
    //   546: iload 6
    //   548: iload_2
    //   549: iconst_4
    //   550: imul
    //   551: if_icmpge +250 -> 801
    //   554: iload 4
    //   556: iconst_2
    //   557: if_icmpge +244 -> 801
    //   560: iload 4
    //   562: iconst_1
    //   563: iadd
    //   564: istore 4
    //   566: goto -33 -> 533
    //   569: astore 10
    //   571: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq -445 -> 129
    //   577: ldc 144
    //   579: iconst_2
    //   580: new 146	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 461
    //   590: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload 10
    //   595: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   598: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: goto -478 -> 129
    //   610: astore 10
    //   612: iconst_0
    //   613: istore_1
    //   614: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   617: ifeq +33 -> 650
    //   620: ldc 144
    //   622: iconst_2
    //   623: new 146	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   630: ldc_w 395
    //   633: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload 10
    //   638: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   641: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   650: aload_0
    //   651: getfield 93	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   654: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   657: iload_1
    //   658: ireturn
    //   659: astore 10
    //   661: aload 10
    //   663: invokevirtual 464	java/io/IOException:printStackTrace	()V
    //   666: goto -502 -> 164
    //   669: astore 10
    //   671: aload_0
    //   672: getfield 93	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   675: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   678: aload 10
    //   680: athrow
    //   681: aload_0
    //   682: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   685: ifnonnull +26 -> 711
    //   688: aload_0
    //   689: getfield 187	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   692: ifnull +19 -> 711
    //   695: aload_0
    //   696: aload_0
    //   697: getfield 187	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   700: ldc 189
    //   702: invokevirtual 195	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   705: checkcast 197	android/media/AudioManager
    //   708: putfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   711: aload_0
    //   712: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   715: invokevirtual 257	android/media/AudioManager:getMode	()I
    //   718: ifne +45 -> 763
    //   721: aload_0
    //   722: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   725: ldc_w 259
    //   728: invokevirtual 265	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   731: ifeq +32 -> 763
    //   734: aload_0
    //   735: iconst_3
    //   736: putfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   739: aload_0
    //   740: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   743: aload_0
    //   744: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   747: invokevirtual 312	android/media/AudioTrack:getStreamType	()I
    //   750: if_icmpne +21 -> 771
    //   753: iconst_0
    //   754: istore_2
    //   755: aload_0
    //   756: iconst_0
    //   757: putfield 241	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   760: goto -587 -> 173
    //   763: aload_0
    //   764: iconst_0
    //   765: putfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   768: goto -29 -> 739
    //   771: iconst_1
    //   772: istore_2
    //   773: goto -18 -> 755
    //   776: astore 10
    //   778: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   781: ifeq -398 -> 383
    //   784: ldc 144
    //   786: iconst_2
    //   787: ldc_w 466
    //   790: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   793: goto -410 -> 383
    //   796: astore 10
    //   798: goto -184 -> 614
    //   801: aload_0
    //   802: new 219	android/media/AudioTrack
    //   805: dup
    //   806: aload_0
    //   807: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   810: aload_0
    //   811: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   814: aload_0
    //   815: getfield 101	com/tencent/sharp/jni/AudioDeviceInterface:_channelPlayType	I
    //   818: iconst_2
    //   819: iload 6
    //   821: iconst_1
    //   822: invokespecial 268	android/media/AudioTrack:<init>	(IIIIII)V
    //   825: putfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   828: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   831: ifeq +32 -> 863
    //   834: ldc 144
    //   836: iconst_2
    //   837: new 146	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   844: ldc_w 277
    //   847: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: aload_0
    //   851: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   854: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   857: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   863: aload_0
    //   864: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   867: invokevirtual 271	android/media/AudioTrack:getState	()I
    //   870: iconst_1
    //   871: if_icmpeq +487 -> 1358
    //   874: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   877: ifeq +43 -> 920
    //   880: ldc 144
    //   882: iconst_2
    //   883: new 146	java/lang/StringBuilder
    //   886: dup
    //   887: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   890: ldc_w 273
    //   893: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: iload 6
    //   898: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   901: ldc_w 275
    //   904: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: aload_0
    //   908: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   911: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   914: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   917: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   920: aload_0
    //   921: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   924: invokevirtual 234	android/media/AudioTrack:release	()V
    //   927: aload_0
    //   928: aconst_null
    //   929: putfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   932: goto -372 -> 560
    //   935: astore 11
    //   937: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   940: ifeq +40 -> 980
    //   943: ldc 144
    //   945: iconst_2
    //   946: new 146	java/lang/StringBuilder
    //   949: dup
    //   950: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   953: aload 11
    //   955: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   958: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: ldc_w 277
    //   964: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: aload_0
    //   968: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   971: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   974: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   977: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   980: aload_0
    //   981: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   984: ifnull +10 -> 994
    //   987: aload_0
    //   988: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   991: invokevirtual 234	android/media/AudioTrack:release	()V
    //   994: aload_0
    //   995: aconst_null
    //   996: putfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   999: goto -439 -> 560
    //   1002: aload_0
    //   1003: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1006: astore 10
    //   1008: aload 10
    //   1010: ifnull +57 -> 1067
    //   1013: aload_0
    //   1014: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1017: invokevirtual 469	android/media/AudioTrack:play	()V
    //   1020: aload_0
    //   1021: getfield 284	com/tencent/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/sharp/jni/TraeAudioSession;
    //   1024: aload_0
    //   1025: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1028: invokevirtual 257	android/media/AudioManager:getMode	()I
    //   1031: aload_0
    //   1032: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   1035: invokevirtual 288	com/tencent/sharp/jni/TraeAudioSession:b	(II)I
    //   1038: pop
    //   1039: aload_0
    //   1040: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1043: astore 10
    //   1045: aload_0
    //   1046: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   1049: ldc_w 303
    //   1052: invokevirtual 265	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1055: ifeq +68 -> 1123
    //   1058: bipush 6
    //   1060: istore_2
    //   1061: aload 10
    //   1063: iload_2
    //   1064: invokestatic 309	com/tencent/sharp/jni/TraeAudioManager:a	(Landroid/media/AudioManager;I)V
    //   1067: iload_1
    //   1068: istore_2
    //   1069: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1072: ifeq +42 -> 1114
    //   1075: ldc 144
    //   1077: iconst_2
    //   1078: new 146	java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1085: ldc_w 471
    //   1088: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: invokestatic 440	android/os/SystemClock:elapsedRealtime	()J
    //   1094: lload 8
    //   1096: lsub
    //   1097: invokevirtual 474	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1100: ldc_w 476
    //   1103: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1109: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1112: iload_1
    //   1113: istore_2
    //   1114: aload_0
    //   1115: getfield 93	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1118: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1121: iload_2
    //   1122: ireturn
    //   1123: aload_0
    //   1124: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1127: invokevirtual 312	android/media/AudioTrack:getStreamType	()I
    //   1130: istore_2
    //   1131: goto -70 -> 1061
    //   1134: aload_0
    //   1135: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1138: aload_0
    //   1139: getfield 129	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   1142: iconst_0
    //   1143: iload_1
    //   1144: invokevirtual 479	android/media/AudioTrack:write	([BII)I
    //   1147: istore_2
    //   1148: aload_0
    //   1149: getfield 125	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1152: invokevirtual 434	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1155: pop
    //   1156: iload_2
    //   1157: ifge +60 -> 1217
    //   1160: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1163: ifeq +45 -> 1208
    //   1166: ldc 144
    //   1168: iconst_2
    //   1169: new 146	java/lang/StringBuilder
    //   1172: dup
    //   1173: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1176: ldc_w 481
    //   1179: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: iload_2
    //   1183: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1186: ldc_w 483
    //   1189: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: iload_1
    //   1193: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1196: ldc_w 485
    //   1199: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1205: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1208: aload_0
    //   1209: getfield 93	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1212: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1215: iconst_m1
    //   1216: ireturn
    //   1217: iload_2
    //   1218: iload_1
    //   1219: if_icmpeq +51 -> 1270
    //   1222: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1225: ifeq +45 -> 1270
    //   1228: ldc 144
    //   1230: iconst_2
    //   1231: new 146	java/lang/StringBuilder
    //   1234: dup
    //   1235: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1238: ldc_w 487
    //   1241: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: iload_2
    //   1245: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1248: ldc_w 483
    //   1251: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: iload_1
    //   1255: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1258: ldc_w 485
    //   1261: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1267: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1270: aload_0
    //   1271: aload_0
    //   1272: getfield 231	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1275: iload_2
    //   1276: iconst_1
    //   1277: ishr
    //   1278: iadd
    //   1279: putfield 231	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1282: aload_0
    //   1283: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1286: invokevirtual 291	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1289: istore_1
    //   1290: iload_1
    //   1291: aload_0
    //   1292: getfield 293	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1295: if_icmpge +8 -> 1303
    //   1298: aload_0
    //   1299: iconst_0
    //   1300: putfield 293	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1303: aload_0
    //   1304: aload_0
    //   1305: getfield 231	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1308: iload_1
    //   1309: aload_0
    //   1310: getfield 293	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1313: isub
    //   1314: isub
    //   1315: putfield 231	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1318: aload_0
    //   1319: iload_1
    //   1320: putfield 293	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1323: aload_0
    //   1324: getfield 317	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   1327: ifne +23 -> 1350
    //   1330: aload_0
    //   1331: getfield 231	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1334: istore_1
    //   1335: goto -221 -> 1114
    //   1338: astore 10
    //   1340: iload_2
    //   1341: istore_1
    //   1342: goto -728 -> 614
    //   1345: astore 10
    //   1347: goto -280 -> 1067
    //   1350: goto -236 -> 1114
    //   1353: iconst_0
    //   1354: istore_3
    //   1355: goto -894 -> 461
    //   1358: iload_3
    //   1359: iconst_1
    //   1360: iadd
    //   1361: istore_3
    //   1362: goto -901 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1365	0	this	AudioDeviceInterface
    //   0	1365	1	paramInt	int
    //   8	1333	2	i	int
    //   17	1345	3	j	int
    //   531	34	4	k	int
    //   395	149	5	m	int
    //   544	353	6	n	int
    //   116	6	7	bool	boolean
    //   200	895	8	l	long
    //   95	382	10	localObject1	Object
    //   569	25	10	localException1	Exception
    //   610	27	10	localException2	Exception
    //   659	3	10	localIOException	java.io.IOException
    //   669	10	10	localObject2	Object
    //   776	1	10	localIllegalStateException	java.lang.IllegalStateException
    //   796	1	10	localException3	Exception
    //   1006	56	10	localObject3	Object
    //   1338	1	10	localException4	Exception
    //   1345	1	10	localException5	Exception
    //   935	19	11	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   124	129	569	java/lang/Exception
    //   91	97	610	java/lang/Exception
    //   112	118	610	java/lang/Exception
    //   129	134	610	java/lang/Exception
    //   134	146	610	java/lang/Exception
    //   151	164	610	java/lang/Exception
    //   164	171	610	java/lang/Exception
    //   173	185	610	java/lang/Exception
    //   571	607	610	java/lang/Exception
    //   661	666	610	java/lang/Exception
    //   681	711	610	java/lang/Exception
    //   711	739	610	java/lang/Exception
    //   739	753	610	java/lang/Exception
    //   755	760	610	java/lang/Exception
    //   763	768	610	java/lang/Exception
    //   1134	1148	610	java/lang/Exception
    //   151	164	659	java/io/IOException
    //   91	97	669	finally
    //   112	118	669	finally
    //   124	129	669	finally
    //   129	134	669	finally
    //   134	146	669	finally
    //   151	164	669	finally
    //   164	171	669	finally
    //   173	185	669	finally
    //   189	253	669	finally
    //   253	261	669	finally
    //   266	281	669	finally
    //   281	333	669	finally
    //   333	378	669	finally
    //   378	383	669	finally
    //   383	454	669	finally
    //   461	530	669	finally
    //   571	607	669	finally
    //   614	650	669	finally
    //   661	666	669	finally
    //   681	711	669	finally
    //   711	739	669	finally
    //   739	753	669	finally
    //   755	760	669	finally
    //   763	768	669	finally
    //   778	793	669	finally
    //   801	828	669	finally
    //   828	863	669	finally
    //   863	920	669	finally
    //   920	932	669	finally
    //   937	980	669	finally
    //   980	994	669	finally
    //   994	999	669	finally
    //   1002	1008	669	finally
    //   1013	1058	669	finally
    //   1061	1067	669	finally
    //   1069	1112	669	finally
    //   1123	1131	669	finally
    //   1134	1148	669	finally
    //   1148	1156	669	finally
    //   1160	1208	669	finally
    //   1222	1270	669	finally
    //   1270	1303	669	finally
    //   1303	1335	669	finally
    //   266	281	776	java/lang/IllegalStateException
    //   281	333	776	java/lang/IllegalStateException
    //   333	378	776	java/lang/IllegalStateException
    //   378	383	776	java/lang/IllegalStateException
    //   189	253	796	java/lang/Exception
    //   253	261	796	java/lang/Exception
    //   266	281	796	java/lang/Exception
    //   281	333	796	java/lang/Exception
    //   333	378	796	java/lang/Exception
    //   378	383	796	java/lang/Exception
    //   383	454	796	java/lang/Exception
    //   461	530	796	java/lang/Exception
    //   778	793	796	java/lang/Exception
    //   828	863	796	java/lang/Exception
    //   863	920	796	java/lang/Exception
    //   920	932	796	java/lang/Exception
    //   937	980	796	java/lang/Exception
    //   980	994	796	java/lang/Exception
    //   994	999	796	java/lang/Exception
    //   1002	1008	796	java/lang/Exception
    //   1069	1112	796	java/lang/Exception
    //   801	828	935	java/lang/Exception
    //   1148	1156	1338	java/lang/Exception
    //   1160	1208	1338	java/lang/Exception
    //   1222	1270	1338	java/lang/Exception
    //   1270	1303	1338	java/lang/Exception
    //   1303	1335	1338	java/lang/Exception
    //   1013	1058	1345	java/lang/Exception
    //   1061	1067	1345	java/lang/Exception
    //   1123	1131	1345	java/lang/Exception
  }
  
  /* Error */
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 317	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   4: ifne +40 -> 44
    //   7: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +32 -> 42
    //   13: ldc 144
    //   15: iconst_2
    //   16: new 146	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 490
    //   26: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 317	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   33: invokevirtual 214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: iconst_m1
    //   43: ireturn
    //   44: aload_0
    //   45: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   48: invokevirtual 407	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   51: aload_0
    //   52: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   55: astore 7
    //   57: aload 7
    //   59: ifnonnull +13 -> 72
    //   62: aload_0
    //   63: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   66: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   69: bipush 254
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 99	com/tencent/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   76: istore 6
    //   78: iload 6
    //   80: iconst_1
    //   81: if_icmpne +13 -> 94
    //   84: bipush 237
    //   86: invokestatic 416	android/os/Process:setThreadPriority	(I)V
    //   89: aload_0
    //   90: iconst_0
    //   91: putfield 99	com/tencent/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   94: aload_0
    //   95: getfield 345	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecordChanged	Z
    //   98: ifne +358 -> 456
    //   101: iconst_0
    //   102: istore_2
    //   103: iload_2
    //   104: ifeq +750 -> 854
    //   107: aload_0
    //   108: getfield 127	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   111: invokevirtual 434	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   114: pop
    //   115: aload_0
    //   116: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   119: invokevirtual 493	android/media/AudioRecord:getRecordingState	()I
    //   122: istore_1
    //   123: iload_1
    //   124: iconst_3
    //   125: if_icmpne +48 -> 173
    //   128: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +35 -> 166
    //   134: ldc 144
    //   136: iconst_2
    //   137: new 146	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 495
    //   147: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_0
    //   151: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   154: invokevirtual 493	android/media/AudioRecord:getRecordingState	()I
    //   157: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_0
    //   167: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   170: invokevirtual 496	android/media/AudioRecord:stop	()V
    //   173: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +35 -> 211
    //   179: ldc 144
    //   181: iconst_2
    //   182: new 146	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 498
    //   192: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_0
    //   196: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   199: invokevirtual 493	android/media/AudioRecord:getRecordingState	()I
    //   202: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload_0
    //   212: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   215: invokevirtual 341	android/media/AudioRecord:release	()V
    //   218: aload_0
    //   219: aconst_null
    //   220: putfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   223: aload_0
    //   224: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   227: aload_0
    //   228: getfield 103	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   231: iconst_2
    //   232: invokestatic 324	android/media/AudioRecord:getMinBufferSize	(III)I
    //   235: istore 4
    //   237: iconst_4
    //   238: newarray int
    //   240: astore 7
    //   242: aload 7
    //   244: dup
    //   245: iconst_0
    //   246: iconst_0
    //   247: iastore
    //   248: dup
    //   249: iconst_1
    //   250: iconst_1
    //   251: iastore
    //   252: dup
    //   253: iconst_2
    //   254: iconst_5
    //   255: iastore
    //   256: dup
    //   257: iconst_3
    //   258: iconst_0
    //   259: iastore
    //   260: pop
    //   261: aload 7
    //   263: iconst_0
    //   264: aload_0
    //   265: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   268: invokestatic 343	com/tencent/sharp/jni/TraeAudioManager:a	(I)I
    //   271: iastore
    //   272: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +32 -> 307
    //   278: ldc 144
    //   280: iconst_2
    //   281: new 146	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 500
    //   291: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload 7
    //   296: iconst_0
    //   297: iaload
    //   298: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aload_0
    //   308: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   311: bipush 20
    //   313: imul
    //   314: iconst_1
    //   315: imul
    //   316: iconst_2
    //   317: imul
    //   318: sipush 1000
    //   321: idiv
    //   322: istore_1
    //   323: aload_0
    //   324: getfield 103	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   327: bipush 12
    //   329: if_icmpne +731 -> 1060
    //   332: iload_1
    //   333: iconst_2
    //   334: imul
    //   335: istore_1
    //   336: goto +724 -> 1060
    //   339: iload_2
    //   340: aload 7
    //   342: arraylength
    //   343: if_icmpge +451 -> 794
    //   346: aload_0
    //   347: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   350: ifnonnull +444 -> 794
    //   353: aload_0
    //   354: aload 7
    //   356: iload_2
    //   357: iaload
    //   358: putfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   361: iconst_1
    //   362: istore_3
    //   363: goto +702 -> 1065
    //   366: astore 7
    //   368: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq -282 -> 89
    //   374: ldc 144
    //   376: iconst_2
    //   377: new 146	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 502
    //   387: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 7
    //   392: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   395: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: goto -315 -> 89
    //   407: astore 7
    //   409: iconst_0
    //   410: istore_2
    //   411: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +33 -> 447
    //   417: ldc 144
    //   419: iconst_2
    //   420: new 146	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   427: ldc_w 504
    //   430: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload 7
    //   435: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   438: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload_0
    //   448: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   451: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   454: iload_2
    //   455: ireturn
    //   456: aload_0
    //   457: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   460: ifnonnull +26 -> 486
    //   463: aload_0
    //   464: getfield 187	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   467: ifnull +19 -> 486
    //   470: aload_0
    //   471: aload_0
    //   472: getfield 187	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   475: ldc 189
    //   477: invokevirtual 195	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   480: checkcast 197	android/media/AudioManager
    //   483: putfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   486: aload_0
    //   487: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   490: astore 7
    //   492: aload 7
    //   494: ifnonnull +12 -> 506
    //   497: aload_0
    //   498: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   501: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   504: iconst_m1
    //   505: ireturn
    //   506: aload_0
    //   507: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   510: invokevirtual 257	android/media/AudioManager:getMode	()I
    //   513: ifne +60 -> 573
    //   516: aload_0
    //   517: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   520: ldc_w 259
    //   523: invokevirtual 265	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   526: ifeq +47 -> 573
    //   529: aload_0
    //   530: iconst_0
    //   531: invokestatic 343	com/tencent/sharp/jni/TraeAudioManager:a	(I)I
    //   534: putfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   537: aload_0
    //   538: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   541: aload_0
    //   542: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   545: invokevirtual 507	android/media/AudioRecord:getAudioSource	()I
    //   548: if_icmpne +548 -> 1096
    //   551: iconst_0
    //   552: istore_2
    //   553: aload_0
    //   554: iconst_0
    //   555: putfield 345	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecordChanged	Z
    //   558: goto -455 -> 103
    //   561: astore 7
    //   563: aload_0
    //   564: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   567: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   570: aload 7
    //   572: athrow
    //   573: aload_0
    //   574: bipush 7
    //   576: invokestatic 343	com/tencent/sharp/jni/TraeAudioManager:a	(I)I
    //   579: putfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   582: goto -45 -> 537
    //   585: astore 7
    //   587: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   590: ifeq +12 -> 602
    //   593: ldc 144
    //   595: iconst_2
    //   596: ldc_w 509
    //   599: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: aload 7
    //   604: invokevirtual 510	java/lang/IllegalStateException:printStackTrace	()V
    //   607: aload_0
    //   608: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   611: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   614: iconst_m1
    //   615: ireturn
    //   616: aload_0
    //   617: new 323	android/media/AudioRecord
    //   620: dup
    //   621: aload_0
    //   622: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   625: aload_0
    //   626: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   629: aload_0
    //   630: getfield 103	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   633: iconst_2
    //   634: iload 5
    //   636: invokespecial 350	android/media/AudioRecord:<init>	(IIIII)V
    //   639: putfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   642: aload_0
    //   643: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   646: invokevirtual 351	android/media/AudioRecord:getState	()I
    //   649: iconst_1
    //   650: if_icmpeq +451 -> 1101
    //   653: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   656: ifeq +56 -> 712
    //   659: ldc 144
    //   661: iconst_2
    //   662: new 146	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   669: ldc_w 353
    //   672: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: iload 5
    //   677: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   680: ldc_w 275
    //   683: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_0
    //   687: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   690: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   693: ldc_w 355
    //   696: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload_0
    //   700: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   703: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   706: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: aload_0
    //   713: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   716: invokevirtual 341	android/media/AudioRecord:release	()V
    //   719: aload_0
    //   720: aconst_null
    //   721: putfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   724: goto +365 -> 1089
    //   727: astore 8
    //   729: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   732: ifeq +40 -> 772
    //   735: ldc 144
    //   737: iconst_2
    //   738: new 146	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   745: aload 8
    //   747: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   750: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: ldc_w 357
    //   756: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload_0
    //   760: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   763: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   766: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   772: aload_0
    //   773: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   776: ifnull +10 -> 786
    //   779: aload_0
    //   780: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   783: invokevirtual 341	android/media/AudioRecord:release	()V
    //   786: aload_0
    //   787: aconst_null
    //   788: putfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   791: goto +298 -> 1089
    //   794: aload_0
    //   795: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   798: astore 7
    //   800: aload 7
    //   802: ifnull +10 -> 812
    //   805: aload_0
    //   806: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   809: invokevirtual 513	android/media/AudioRecord:startRecording	()V
    //   812: iconst_0
    //   813: istore_3
    //   814: aload_0
    //   815: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   818: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   821: iload_3
    //   822: ireturn
    //   823: astore 7
    //   825: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   828: ifeq +12 -> 840
    //   831: ldc 144
    //   833: iconst_2
    //   834: ldc_w 515
    //   837: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   840: aload 7
    //   842: invokevirtual 510	java/lang/IllegalStateException:printStackTrace	()V
    //   845: aload_0
    //   846: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   849: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   852: iconst_m1
    //   853: ireturn
    //   854: aload_0
    //   855: getfield 127	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   858: invokevirtual 434	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   861: pop
    //   862: aload_0
    //   863: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   866: aload_0
    //   867: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   870: iconst_0
    //   871: iload_1
    //   872: invokevirtual 518	android/media/AudioRecord:read	([BII)I
    //   875: istore_2
    //   876: iload_2
    //   877: ifge +60 -> 937
    //   880: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   883: ifeq +45 -> 928
    //   886: ldc 144
    //   888: iconst_2
    //   889: new 146	java/lang/StringBuilder
    //   892: dup
    //   893: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   896: ldc_w 520
    //   899: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: iload_2
    //   903: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   906: ldc_w 483
    //   909: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: iload_1
    //   913: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   916: ldc_w 485
    //   919: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   925: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   928: aload_0
    //   929: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   932: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   935: iconst_m1
    //   936: ireturn
    //   937: aload_0
    //   938: getfield 127	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   941: aload_0
    //   942: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   945: iconst_0
    //   946: iload_2
    //   947: invokevirtual 524	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   950: pop
    //   951: getstatic 418	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   954: ifeq +27 -> 981
    //   957: aload_0
    //   958: getfield 526	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   961: astore 7
    //   963: aload 7
    //   965: ifnull +16 -> 981
    //   968: aload_0
    //   969: getfield 526	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   972: aload_0
    //   973: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   976: iconst_0
    //   977: iload_2
    //   978: invokevirtual 426	java/io/FileOutputStream:write	([BII)V
    //   981: iload_2
    //   982: istore_3
    //   983: iload_2
    //   984: iload_1
    //   985: if_icmpeq -171 -> 814
    //   988: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   991: ifeq +45 -> 1036
    //   994: ldc 144
    //   996: iconst_2
    //   997: new 146	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1004: ldc_w 528
    //   1007: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: iload_2
    //   1011: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1014: ldc_w 483
    //   1017: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: iload_1
    //   1021: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1024: ldc_w 485
    //   1027: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1033: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1036: aload_0
    //   1037: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1040: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1043: iconst_m1
    //   1044: ireturn
    //   1045: astore 7
    //   1047: aload 7
    //   1049: invokevirtual 464	java/io/IOException:printStackTrace	()V
    //   1052: goto -71 -> 981
    //   1055: astore 7
    //   1057: goto -646 -> 411
    //   1060: iconst_0
    //   1061: istore_2
    //   1062: goto -723 -> 339
    //   1065: iload_3
    //   1066: iconst_2
    //   1067: if_icmpgt +34 -> 1101
    //   1070: iload 4
    //   1072: iload_3
    //   1073: imul
    //   1074: istore 5
    //   1076: iload 5
    //   1078: iload_1
    //   1079: iconst_4
    //   1080: imul
    //   1081: if_icmpge -465 -> 616
    //   1084: iload_3
    //   1085: iconst_2
    //   1086: if_icmpge -470 -> 616
    //   1089: iload_3
    //   1090: iconst_1
    //   1091: iadd
    //   1092: istore_3
    //   1093: goto -28 -> 1065
    //   1096: iconst_1
    //   1097: istore_2
    //   1098: goto -545 -> 553
    //   1101: iload_2
    //   1102: iconst_1
    //   1103: iadd
    //   1104: istore_2
    //   1105: goto -766 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1108	0	this	AudioDeviceInterface
    //   0	1108	1	paramInt	int
    //   102	1003	2	i	int
    //   362	731	3	j	int
    //   235	839	4	k	int
    //   634	448	5	m	int
    //   76	6	6	bool	boolean
    //   55	300	7	localObject1	Object
    //   366	25	7	localException1	Exception
    //   407	27	7	localException2	Exception
    //   490	3	7	localAudioManager	AudioManager
    //   561	10	7	localObject2	Object
    //   585	18	7	localIllegalStateException1	java.lang.IllegalStateException
    //   798	3	7	localAudioRecord	AudioRecord
    //   823	18	7	localIllegalStateException2	java.lang.IllegalStateException
    //   961	3	7	localFileOutputStream	FileOutputStream
    //   1045	3	7	localIOException	java.io.IOException
    //   1055	1	7	localException3	Exception
    //   727	19	8	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   84	89	366	java/lang/Exception
    //   51	57	407	java/lang/Exception
    //   72	78	407	java/lang/Exception
    //   89	94	407	java/lang/Exception
    //   94	101	407	java/lang/Exception
    //   107	123	407	java/lang/Exception
    //   128	166	407	java/lang/Exception
    //   166	173	407	java/lang/Exception
    //   173	211	407	java/lang/Exception
    //   211	307	407	java/lang/Exception
    //   307	332	407	java/lang/Exception
    //   339	361	407	java/lang/Exception
    //   368	404	407	java/lang/Exception
    //   456	486	407	java/lang/Exception
    //   486	492	407	java/lang/Exception
    //   506	537	407	java/lang/Exception
    //   537	551	407	java/lang/Exception
    //   553	558	407	java/lang/Exception
    //   573	582	407	java/lang/Exception
    //   587	602	407	java/lang/Exception
    //   602	607	407	java/lang/Exception
    //   642	712	407	java/lang/Exception
    //   712	724	407	java/lang/Exception
    //   729	772	407	java/lang/Exception
    //   772	786	407	java/lang/Exception
    //   786	791	407	java/lang/Exception
    //   794	800	407	java/lang/Exception
    //   805	812	407	java/lang/Exception
    //   825	840	407	java/lang/Exception
    //   840	845	407	java/lang/Exception
    //   854	876	407	java/lang/Exception
    //   51	57	561	finally
    //   72	78	561	finally
    //   84	89	561	finally
    //   89	94	561	finally
    //   94	101	561	finally
    //   107	123	561	finally
    //   128	166	561	finally
    //   166	173	561	finally
    //   173	211	561	finally
    //   211	307	561	finally
    //   307	332	561	finally
    //   339	361	561	finally
    //   368	404	561	finally
    //   411	447	561	finally
    //   456	486	561	finally
    //   486	492	561	finally
    //   506	537	561	finally
    //   537	551	561	finally
    //   553	558	561	finally
    //   573	582	561	finally
    //   587	602	561	finally
    //   602	607	561	finally
    //   616	642	561	finally
    //   642	712	561	finally
    //   712	724	561	finally
    //   729	772	561	finally
    //   772	786	561	finally
    //   786	791	561	finally
    //   794	800	561	finally
    //   805	812	561	finally
    //   825	840	561	finally
    //   840	845	561	finally
    //   854	876	561	finally
    //   880	928	561	finally
    //   937	963	561	finally
    //   968	981	561	finally
    //   988	1036	561	finally
    //   1047	1052	561	finally
    //   128	166	585	java/lang/IllegalStateException
    //   166	173	585	java/lang/IllegalStateException
    //   616	642	727	java/lang/Exception
    //   805	812	823	java/lang/IllegalStateException
    //   968	981	1045	java/io/IOException
    //   880	928	1055	java/lang/Exception
    //   937	963	1055	java/lang/Exception
    //   968	981	1055	java/lang/Exception
    //   988	1036	1055	java/lang/Exception
    //   1047	1052	1055	java/lang/Exception
  }
  
  private int SetPlayoutVolume(int paramInt)
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null)
    {
      this._audioManager.setStreamVolume(0, paramInt, 0);
      i = 0;
    }
    return i;
  }
  
  /* Error */
  private int StartPlayback()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 207	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   6: ifeq +20 -> 26
    //   9: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 144
    //   17: iconst_2
    //   18: ldc_w 538
    //   21: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   30: ifnonnull +40 -> 70
    //   33: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -12 -> 24
    //   39: ldc 144
    //   41: iconst_2
    //   42: new 146	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 540
    //   52: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   59: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: iconst_m1
    //   69: ireturn
    //   70: aload_0
    //   71: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   74: invokevirtual 469	android/media/AudioTrack:play	()V
    //   77: getstatic 418	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   80: ifeq +52 -> 132
    //   83: aload_0
    //   84: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   87: ifnull +11 -> 98
    //   90: aload_0
    //   91: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   94: invokevirtual 257	android/media/AudioManager:getMode	()I
    //   97: istore_1
    //   98: aload_0
    //   99: new 542	java/io/File
    //   102: dup
    //   103: aload_0
    //   104: ldc_w 544
    //   107: iload_1
    //   108: invokespecial 548	com/tencent/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   111: invokespecial 550	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: putfield 552	com/tencent/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   117: aload_0
    //   118: new 422	java/io/FileOutputStream
    //   121: dup
    //   122: aload_0
    //   123: getfield 552	com/tencent/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   126: invokespecial 555	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   129: putfield 420	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield 207	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   137: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +12 -> 152
    //   143: ldc 144
    //   145: iconst_2
    //   146: ldc_w 557
    //   149: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_2
    //   155: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +12 -> 170
    //   161: ldc 144
    //   163: iconst_2
    //   164: ldc_w 559
    //   167: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_2
    //   171: invokevirtual 510	java/lang/IllegalStateException:printStackTrace	()V
    //   174: iconst_m1
    //   175: ireturn
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 560	java/io/FileNotFoundException:printStackTrace	()V
    //   181: goto -49 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	AudioDeviceInterface
    //   1	107	1	i	int
    //   154	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   176	2	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   70	77	154	java/lang/IllegalStateException
    //   117	132	176	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StartRecording()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 144
    //   10: iconst_2
    //   11: ldc_w 563
    //   14: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 317	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   21: ifeq +40 -> 61
    //   24: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +32 -> 59
    //   30: ldc 144
    //   32: iconst_2
    //   33: new 146	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 565
    //   43: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 317	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   50: invokevirtual 214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iconst_m1
    //   60: ireturn
    //   61: aload_0
    //   62: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   65: ifnonnull +40 -> 105
    //   68: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq -12 -> 59
    //   74: ldc 144
    //   76: iconst_2
    //   77: new 146	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 567
    //   87: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   94: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iconst_m1
    //   104: ireturn
    //   105: aload_0
    //   106: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   109: invokevirtual 513	android/media/AudioRecord:startRecording	()V
    //   112: getstatic 418	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   115: ifeq +52 -> 167
    //   118: aload_0
    //   119: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   122: ifnull +11 -> 133
    //   125: aload_0
    //   126: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   129: invokevirtual 257	android/media/AudioManager:getMode	()I
    //   132: istore_1
    //   133: aload_0
    //   134: new 542	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: ldc_w 569
    //   142: iload_1
    //   143: invokespecial 548	com/tencent/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   146: invokespecial 550	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: putfield 571	com/tencent/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   152: aload_0
    //   153: new 422	java/io/FileOutputStream
    //   156: dup
    //   157: aload_0
    //   158: getfield 571	com/tencent/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   161: invokespecial 555	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: putfield 526	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   167: aload_0
    //   168: iconst_1
    //   169: putfield 317	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   172: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +12 -> 187
    //   178: ldc 144
    //   180: iconst_2
    //   181: ldc_w 573
    //   184: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_2
    //   190: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +12 -> 205
    //   196: ldc 144
    //   198: iconst_2
    //   199: ldc_w 515
    //   202: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_2
    //   206: invokevirtual 510	java/lang/IllegalStateException:printStackTrace	()V
    //   209: iconst_m1
    //   210: ireturn
    //   211: astore_2
    //   212: aload_2
    //   213: invokevirtual 560	java/io/FileNotFoundException:printStackTrace	()V
    //   216: goto -49 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	AudioDeviceInterface
    //   1	142	1	i	int
    //   189	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   211	2	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   105	112	189	java/lang/IllegalStateException
    //   152	167	211	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StopPlayback()
  {
    // Byte code:
    //   0: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +32 -> 35
    //   6: ldc 144
    //   8: iconst_2
    //   9: new 146	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 576
    //   19: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 207	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   26: invokevirtual 214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   39: ifnonnull +53 -> 92
    //   42: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +45 -> 90
    //   48: ldc 144
    //   50: iconst_2
    //   51: new 146	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 578
    //   61: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: getfield 207	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   68: invokevirtual 214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   71: ldc_w 404
    //   74: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   81: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_m1
    //   91: ireturn
    //   92: aload_0
    //   93: getfield 93	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   96: invokevirtual 407	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   99: aload_0
    //   100: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   103: invokevirtual 447	android/media/AudioTrack:getPlayState	()I
    //   106: istore_1
    //   107: iload_1
    //   108: iconst_3
    //   109: if_icmpne +70 -> 179
    //   112: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +12 -> 127
    //   118: ldc 144
    //   120: iconst_2
    //   121: ldc_w 449
    //   124: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_0
    //   128: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   131: invokevirtual 452	android/media/AudioTrack:stop	()V
    //   134: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +35 -> 172
    //   140: ldc 144
    //   142: iconst_2
    //   143: new 146	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 457
    //   153: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   160: invokevirtual 447	android/media/AudioTrack:getPlayState	()I
    //   163: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   176: invokevirtual 455	android/media/AudioTrack:flush	()V
    //   179: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +35 -> 217
    //   185: ldc 144
    //   187: iconst_2
    //   188: new 146	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 459
    //   198: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   205: invokevirtual 447	android/media/AudioTrack:getPlayState	()I
    //   208: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_0
    //   218: getfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   221: invokevirtual 234	android/media/AudioTrack:release	()V
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 209	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   229: aload_0
    //   230: iconst_0
    //   231: putfield 207	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   234: aload_0
    //   235: getfield 93	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   238: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   241: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +12 -> 256
    //   247: ldc 144
    //   249: iconst_2
    //   250: ldc_w 580
    //   253: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: iconst_0
    //   257: ireturn
    //   258: astore_2
    //   259: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +12 -> 274
    //   265: ldc 144
    //   267: iconst_2
    //   268: ldc_w 466
    //   271: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_2
    //   275: invokevirtual 510	java/lang/IllegalStateException:printStackTrace	()V
    //   278: aload_0
    //   279: getfield 93	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   282: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   285: iconst_m1
    //   286: ireturn
    //   287: astore_2
    //   288: aload_0
    //   289: getfield 93	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   292: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   295: aload_2
    //   296: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	AudioDeviceInterface
    //   106	4	1	i	int
    //   258	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   287	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   112	127	258	java/lang/IllegalStateException
    //   127	134	258	java/lang/IllegalStateException
    //   99	107	287	finally
    //   112	127	287	finally
    //   127	134	287	finally
    //   134	172	287	finally
    //   172	179	287	finally
    //   179	217	287	finally
    //   217	234	287	finally
    //   259	274	287	finally
    //   274	278	287	finally
  }
  
  /* Error */
  private int StopRecording()
  {
    // Byte code:
    //   0: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 144
    //   8: iconst_2
    //   9: ldc_w 583
    //   12: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   19: ifnonnull +40 -> 59
    //   22: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +32 -> 57
    //   28: ldc 144
    //   30: iconst_2
    //   31: new 146	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 585
    //   41: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   48: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iconst_m1
    //   58: ireturn
    //   59: aload_0
    //   60: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   63: invokevirtual 407	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   66: aload_0
    //   67: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   70: invokevirtual 493	android/media/AudioRecord:getRecordingState	()I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_3
    //   76: if_icmpne +48 -> 124
    //   79: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +35 -> 117
    //   85: ldc 144
    //   87: iconst_2
    //   88: new 146	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 495
    //   98: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   105: invokevirtual 493	android/media/AudioRecord:getRecordingState	()I
    //   108: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_0
    //   118: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   121: invokevirtual 496	android/media/AudioRecord:stop	()V
    //   124: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +35 -> 162
    //   130: ldc 144
    //   132: iconst_2
    //   133: new 146	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 498
    //   143: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   150: invokevirtual 493	android/media/AudioRecord:getRecordingState	()I
    //   153: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: getfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   166: invokevirtual 341	android/media/AudioRecord:release	()V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 319	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 317	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   179: aload_0
    //   180: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   183: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   186: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +12 -> 201
    //   192: ldc 144
    //   194: iconst_2
    //   195: ldc_w 587
    //   198: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_2
    //   204: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +12 -> 219
    //   210: ldc 144
    //   212: iconst_2
    //   213: ldc_w 509
    //   216: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_2
    //   220: invokevirtual 510	java/lang/IllegalStateException:printStackTrace	()V
    //   223: aload_0
    //   224: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   227: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   230: iconst_m1
    //   231: ireturn
    //   232: astore_2
    //   233: aload_0
    //   234: getfield 95	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   237: invokevirtual 410	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   240: aload_2
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	AudioDeviceInterface
    //   73	4	1	i	int
    //   203	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   232	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   79	117	203	java/lang/IllegalStateException
    //   117	124	203	java/lang/IllegalStateException
    //   66	74	232	finally
    //   79	117	232	finally
    //   117	124	232	finally
    //   124	162	232	finally
    //   162	179	232	finally
    //   204	219	232	finally
    //   219	223	232	finally
  }
  
  @TargetApi(16)
  private int getAudioSessionId(AudioRecord paramAudioRecord)
  {
    return 0;
  }
  
  private String getDumpFilePath(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
    }
    paramString = Environment.getExternalStorageDirectory().getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-as-" + TraeAudioManager.a(this._audioSourcePolicy) + "-st-" + this._streamType + "-m-" + paramInt + "-" + paramString;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump:" + paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump replace:" + paramString.replace(" ", "_"));
    }
    return paramString.replace(" ", "_");
  }
  
  private int getLowlatencyFramesPerBuffer()
  {
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
      return 0;
    }
    boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("LOW_LATENCY:");
      if (bool != true) {
        break label146;
      }
    }
    label146:
    for (String str = "Y";; str = "N")
    {
      QLog.w("TRAE", 2, str);
      if ((Build.VERSION.SDK_INT >= 17) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      return 0;
    }
  }
  
  private int getLowlatencySamplerate()
  {
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9)) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
    }
    label146:
    label153:
    do
    {
      return 0;
      boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("LOW_LATENCY:");
        if (bool != true) {
          break label146;
        }
      }
      for (String str = "Y";; str = "N")
      {
        QLog.w("TRAE", 2, str);
        if (Build.VERSION.SDK_INT >= 17) {
          break label153;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
        return 0;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, "getLowlatencySamplerate not support right now!");
    return 0;
  }
  
  public static String getTraceInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int i = arrayOfStackTraceElement.length;
    localStringBuffer.append("").append(arrayOfStackTraceElement[2].getClassName()).append(".").append(arrayOfStackTraceElement[2].getMethodName()).append(": ").append(arrayOfStackTraceElement[2].getLineNumber());
    return localStringBuffer.toString();
  }
  
  private void initTRAEAudioManager()
  {
    if (this._context != null)
    {
      TraeAudioManager.a(this._context);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession startService");
      }
    }
  }
  
  private void onOutputChanage(String paramString)
  {
    setAudioRouteSwitchState(paramString);
    this._connectedDev = paramString;
    if ((this._audioManager == null) && (this._context != null)) {}
    for (;;)
    {
      try
      {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        if ((this._audioManager != null) && (this._audioTrack != null))
        {
          if (this._connectedDev.equals("DEVICE_BLUETOOTHHEADSET"))
          {
            i = 6;
            if ((!this._IsBluetoothStreamVolume) || (i == 6)) {
              break label136;
            }
            TraeAudioManager.a(this._audioManager, i);
            this._IsBluetoothStreamVolume = false;
          }
        }
        else
        {
          if (TraeAudioManager.a(this._modePolicy)) {
            break;
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TRAE", 2, paramString.getMessage());
        return;
      }
      int i = this._audioTrack.getStreamType();
      continue;
      label136:
      if ((!this._IsBluetoothStreamVolume) && (i == 6))
      {
        TraeAudioManager.a(this._audioManager, i);
        this._IsBluetoothStreamVolume = true;
      }
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(" onOutputChanage:").append(paramString);
      if (this._audioManager != null) {
        break label359;
      }
      localObject = " am==null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(" st:").append(this._streamType);
      if (this._audioTrack != null) {
        break label389;
      }
      localObject = "_audioTrack==null";
      label233:
      QLog.w("TRAE", 2, (String)localObject);
    }
    for (;;)
    {
      try
      {
        if (this._audioManager == null) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append(" curr mode:").append(paramString);
          if (this._audioManager != null) {
            continue;
          }
          paramString = "am==null";
          QLog.w("TRAE", 2, paramString);
        }
        if ((this._connectedDev.equals("DEVICE_SPEAKERPHONE")) && (this._audioManager != null)) {
          this._audioManager.setMode(0);
        }
      }
      catch (Exception paramString)
      {
        label359:
        if (!QLog.isColorLevel()) {
          continue;
        }
        label389:
        QLog.w("TRAE", 2, paramString.getMessage());
        continue;
      }
      this._audioRouteChanged = true;
      this._audioRecordChanged = true;
      return;
      localObject = " mode:" + this._audioManager.getMode();
      break;
      localObject = " at.st:" + this._audioTrack.getStreamType();
      break label233;
      paramString = " mode:" + this._audioManager.getMode();
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
  
  private int sigHowling(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "java onHowling flg:" + paramInt);
    }
    if (this._as == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "onHowling too early" + paramInt);
      }
      return -1;
    }
    return 0;
  }
  
  private void uninitTRAEAudioManager()
  {
    if (this._context != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "uninitTRAEAudioManager , stopService");
      }
      TraeAudioManager.c();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TRAE", 2, "uninitTRAEAudioManager , context null");
  }
  
  public int call_postprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    if (this._as != null)
    {
      this._as.e();
      this._as.a();
      this._as = null;
    }
    LogTraceExit();
    return 0;
  }
  
  public int call_preprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    this._streamType = TraeAudioManager.b(this._audioStreamTypePolicy);
    if (this._as == null) {
      this._as = new TraeAudioSession(this._context, new bfll(this));
    }
    this._preDone = false;
    if (this._as != null) {
      this._prelock.lock();
    }
    int i;
    int j;
    label211:
    for (;;)
    {
      try
      {
        this._as.b(-1030L);
        this._as.a(this._modePolicy, this._streamType);
        i = 7;
        j = i - 1;
        if (i <= 0) {}
      }
      finally
      {
        this._prelock.unlock();
      }
      try
      {
        if (!this._preDone)
        {
          this._precon.await(1L, TimeUnit.SECONDS);
          if (!QLog.isColorLevel()) {
            break label211;
          }
          QLog.e("TRAE", 2, "call_preprocess waiting...  as:" + this._as);
          i = j;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "call_preprocess done!");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
        i = j;
      }
      this._prelock.unlock();
      LogTraceExit();
      return 0;
    }
  }
  
  public int getAudioRouteSwitchState()
  {
    return this.switchState;
  }
  
  public void setContext(Context paramContext)
  {
    this._context = paramContext;
  }
  
  public void setJavaInterface(int paramInt)
  {
    if (paramInt == 0) {}
    for (this.usingJava = false;; this.usingJava = true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "setJavaInterface flg:" + paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.sharp.jni.AudioDeviceInterface
 * JD-Core Version:    0.7.0.1
 */