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
  private static boolean _dumpEnable = false;
  private static boolean _logEnable = true;
  private boolean _IsBluetoothStreamVolume = false;
  private int _RecordSamplerate = 8000;
  private TraeAudioSession _as = null;
  private AudioManager _audioManager = null;
  private AudioRecord _audioRecord = null;
  private boolean _audioRecordChanged = false;
  private boolean _audioRouteChanged = false;
  private int _audioSource = 0;
  private int _audioSourcePolicy = -1;
  private int _audioStreamTypePolicy = -1;
  private AudioTrack _audioTrack = null;
  private int _bufferedPlaySamples = 0;
  private int _bufferedRecSamples = 0;
  private int _channelPlayType = 4;
  private int _channelRecordType = 4;
  private String _connectedDev = "DEVICE_NONE";
  private Context _context = null;
  private boolean _doPlayInit = true;
  private boolean _doRecInit = true;
  private boolean _isPlaying = false;
  private boolean _isRecording = false;
  private int _modePolicy = -1;
  private ByteBuffer _playBuffer;
  private final ReentrantLock _playLock = new ReentrantLock();
  private int _playPosition = 0;
  private int _playSamplerate = 8000;
  private File _play_dump = null;
  private FileOutputStream _play_out = null;
  private boolean _preDone = false;
  private Condition _precon = this._prelock.newCondition();
  private ReentrantLock _prelock = new ReentrantLock();
  private ByteBuffer _recBuffer;
  private final ReentrantLock _recLock = new ReentrantLock();
  private File _rec_dump = null;
  private FileOutputStream _rec_out = null;
  private int _sessionId = 0;
  private int _streamType = 0;
  private byte[] _tempBufPlay;
  private byte[] _tempBufRec;
  private int switchState = 0;
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
    label552:
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
              break label434;
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
          tmp254_252 = arrayOfInt;
          tmp254_252[0] = 0;
          tmp258_254 = tmp254_252;
          tmp258_254[1] = 0;
          tmp262_258 = tmp258_254;
          tmp262_258[2] = 3;
          tmp266_262 = tmp262_258;
          tmp266_262[3] = 1;
          tmp266_262;
          this._streamType = TraeAudioManager.b(this._audioStreamTypePolicy);
          if (this._audioRouteChanged) {
            break label460;
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
            break label716;
          }
          paramInt1 = j * i;
          if ((paramInt1 >= k * 4) || (i >= 2)) {
            break label552;
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
      label434:
      if ((this._channelPlayType == 4) && (QLog.isColorLevel()))
      {
        QLog.w("TRAE", 2, "InitPlayback, _channelPlayType Mono");
        continue;
        label460:
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
            break label716;
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
        label716:
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
        break label910;
      }
    }
    label910:
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
    //   1: getfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   4: ifne +70 -> 74
    //   7: iconst_1
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   13: ifnonnull +66 -> 79
    //   16: iconst_1
    //   17: istore_3
    //   18: iload_2
    //   19: iload_3
    //   20: ior
    //   21: ifeq +63 -> 84
    //   24: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +45 -> 72
    //   30: ldc 186
    //   32: iconst_2
    //   33: new 188	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 416
    //   43: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   50: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc_w 418
    //   56: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   63: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: iconst_m1
    //   73: ireturn
    //   74: iconst_0
    //   75: istore_2
    //   76: goto -67 -> 9
    //   79: iconst_0
    //   80: istore_3
    //   81: goto -63 -> 18
    //   84: aload_0
    //   85: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   88: invokevirtual 421	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   91: aload_0
    //   92: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   95: astore 10
    //   97: aload 10
    //   99: ifnonnull +13 -> 112
    //   102: aload_0
    //   103: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   106: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   109: bipush 254
    //   111: ireturn
    //   112: aload_0
    //   113: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   116: istore 7
    //   118: iload 7
    //   120: iconst_1
    //   121: if_icmpne +13 -> 134
    //   124: bipush 237
    //   126: invokestatic 430	android/os/Process:setThreadPriority	(I)V
    //   129: aload_0
    //   130: iconst_0
    //   131: putfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   134: getstatic 68	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   137: ifeq +27 -> 164
    //   140: aload_0
    //   141: getfield 129	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   144: astore 10
    //   146: aload 10
    //   148: ifnull +16 -> 164
    //   151: aload_0
    //   152: getfield 129	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   155: aload_0
    //   156: getfield 171	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   159: iconst_0
    //   160: iconst_0
    //   161: invokevirtual 436	java/io/FileOutputStream:write	([BII)V
    //   164: aload_0
    //   165: getfield 143	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   168: ifne +515 -> 683
    //   171: iconst_0
    //   172: istore_2
    //   173: aload_0
    //   174: getfield 167	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   177: aload_0
    //   178: getfield 171	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   181: invokevirtual 440	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   184: pop
    //   185: iload_2
    //   186: ifeq +950 -> 1136
    //   189: aload_0
    //   190: getfield 167	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   193: invokevirtual 444	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   196: pop
    //   197: invokestatic 450	android/os/SystemClock:elapsedRealtime	()J
    //   200: lstore 8
    //   202: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +48 -> 253
    //   208: ldc 186
    //   210: iconst_2
    //   211: new 188	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 452
    //   221: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_0
    //   225: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   228: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: ldc_w 454
    //   234: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   241: invokevirtual 336	android/media/AudioTrack:getStreamType	()I
    //   244: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_0
    //   254: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   257: invokevirtual 457	android/media/AudioTrack:getPlayState	()I
    //   260: istore_2
    //   261: iload_2
    //   262: iconst_3
    //   263: if_icmpne +120 -> 383
    //   266: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +12 -> 281
    //   272: ldc 186
    //   274: iconst_2
    //   275: ldc_w 459
    //   278: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_0
    //   282: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   285: invokevirtual 462	android/media/AudioTrack:stop	()V
    //   288: aload_0
    //   289: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   292: invokevirtual 465	android/media/AudioTrack:flush	()V
    //   295: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +35 -> 333
    //   301: ldc 186
    //   303: iconst_2
    //   304: new 188	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 467
    //   314: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   321: invokevirtual 457	android/media/AudioTrack:getPlayState	()I
    //   324: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload_0
    //   334: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   337: invokevirtual 266	android/media/AudioTrack:release	()V
    //   340: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +35 -> 378
    //   346: ldc 186
    //   348: iconst_2
    //   349: new 188	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 469
    //   359: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_0
    //   363: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   366: invokevirtual 457	android/media/AudioTrack:getPlayState	()I
    //   369: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload_0
    //   379: aconst_null
    //   380: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   383: aload_0
    //   384: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   387: aload_0
    //   388: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_channelPlayType	I
    //   391: iconst_2
    //   392: invokestatic 257	android/media/AudioTrack:getMinBufferSize	(III)I
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
    //   425: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   428: iastore
    //   429: aload_0
    //   430: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
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
    //   446: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_channelPlayType	I
    //   449: bipush 12
    //   451: if_icmpne +904 -> 1355
    //   454: iload_2
    //   455: iconst_2
    //   456: imul
    //   457: istore_2
    //   458: goto +897 -> 1355
    //   461: iload_3
    //   462: aload 10
    //   464: arraylength
    //   465: if_icmpge +539 -> 1004
    //   468: aload_0
    //   469: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   472: ifnonnull +532 -> 1004
    //   475: aload_0
    //   476: aload 10
    //   478: iload_3
    //   479: iaload
    //   480: putfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   483: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq +46 -> 532
    //   489: ldc 186
    //   491: iconst_2
    //   492: new 188	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 273
    //   502: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: iload 5
    //   507: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: ldc_w 275
    //   513: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_0
    //   517: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   520: invokestatic 278	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   523: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   526: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: iconst_1
    //   533: istore 4
    //   535: iload 4
    //   537: iconst_2
    //   538: if_icmpgt +822 -> 1360
    //   541: iload 5
    //   543: iload 4
    //   545: imul
    //   546: istore 6
    //   548: iload 6
    //   550: iload_2
    //   551: iconst_4
    //   552: imul
    //   553: if_icmpge +250 -> 803
    //   556: iload 4
    //   558: iconst_2
    //   559: if_icmpge +244 -> 803
    //   562: iload 4
    //   564: iconst_1
    //   565: iadd
    //   566: istore 4
    //   568: goto -33 -> 535
    //   571: astore 10
    //   573: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   576: ifeq -447 -> 129
    //   579: ldc 186
    //   581: iconst_2
    //   582: new 188	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 471
    //   592: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload 10
    //   597: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   600: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: goto -480 -> 129
    //   612: astore 10
    //   614: iconst_0
    //   615: istore_1
    //   616: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   619: ifeq +33 -> 652
    //   622: ldc 186
    //   624: iconst_2
    //   625: new 188	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 409
    //   635: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload 10
    //   640: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   643: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   652: aload_0
    //   653: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   656: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   659: iload_1
    //   660: ireturn
    //   661: astore 10
    //   663: aload 10
    //   665: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   668: goto -504 -> 164
    //   671: astore 10
    //   673: aload_0
    //   674: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   677: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   680: aload 10
    //   682: athrow
    //   683: aload_0
    //   684: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   687: ifnonnull +26 -> 713
    //   690: aload_0
    //   691: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   694: ifnull +19 -> 713
    //   697: aload_0
    //   698: aload_0
    //   699: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   702: ldc 227
    //   704: invokevirtual 233	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   707: checkcast 235	android/media/AudioManager
    //   710: putfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   713: aload_0
    //   714: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   717: invokevirtual 287	android/media/AudioManager:getMode	()I
    //   720: ifne +45 -> 765
    //   723: aload_0
    //   724: getfield 141	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   727: ldc_w 289
    //   730: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   733: ifeq +32 -> 765
    //   736: aload_0
    //   737: iconst_3
    //   738: putfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   741: aload_0
    //   742: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   745: aload_0
    //   746: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   749: invokevirtual 336	android/media/AudioTrack:getStreamType	()I
    //   752: if_icmpne +21 -> 773
    //   755: iconst_0
    //   756: istore_2
    //   757: aload_0
    //   758: iconst_0
    //   759: putfield 143	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   762: goto -589 -> 173
    //   765: aload_0
    //   766: iconst_0
    //   767: putfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   770: goto -29 -> 741
    //   773: iconst_1
    //   774: istore_2
    //   775: goto -18 -> 757
    //   778: astore 10
    //   780: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   783: ifeq -400 -> 383
    //   786: ldc 186
    //   788: iconst_2
    //   789: ldc_w 476
    //   792: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   795: goto -412 -> 383
    //   798: astore 10
    //   800: goto -184 -> 616
    //   803: aload_0
    //   804: new 253	android/media/AudioTrack
    //   807: dup
    //   808: aload_0
    //   809: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   812: aload_0
    //   813: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   816: aload_0
    //   817: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_channelPlayType	I
    //   820: iconst_2
    //   821: iload 6
    //   823: iconst_1
    //   824: invokespecial 298	android/media/AudioTrack:<init>	(IIIIII)V
    //   827: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   830: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   833: ifeq +32 -> 865
    //   836: ldc 186
    //   838: iconst_2
    //   839: new 188	java/lang/StringBuilder
    //   842: dup
    //   843: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   846: ldc_w 307
    //   849: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: aload_0
    //   853: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   856: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   865: aload_0
    //   866: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   869: invokevirtual 301	android/media/AudioTrack:getState	()I
    //   872: iconst_1
    //   873: if_icmpeq +487 -> 1360
    //   876: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   879: ifeq +43 -> 922
    //   882: ldc 186
    //   884: iconst_2
    //   885: new 188	java/lang/StringBuilder
    //   888: dup
    //   889: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   892: ldc_w 303
    //   895: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: iload 6
    //   900: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   903: ldc_w 305
    //   906: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: aload_0
    //   910: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   913: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   916: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   919: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   922: aload_0
    //   923: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   926: invokevirtual 266	android/media/AudioTrack:release	()V
    //   929: aload_0
    //   930: aconst_null
    //   931: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   934: goto -372 -> 562
    //   937: astore 11
    //   939: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   942: ifeq +40 -> 982
    //   945: ldc 186
    //   947: iconst_2
    //   948: new 188	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   955: aload 11
    //   957: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   960: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: ldc_w 307
    //   966: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: aload_0
    //   970: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   973: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   976: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   979: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   982: aload_0
    //   983: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   986: ifnull +10 -> 996
    //   989: aload_0
    //   990: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   993: invokevirtual 266	android/media/AudioTrack:release	()V
    //   996: aload_0
    //   997: aconst_null
    //   998: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1001: goto -439 -> 562
    //   1004: aload_0
    //   1005: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1008: astore 10
    //   1010: aload 10
    //   1012: ifnull +57 -> 1069
    //   1015: aload_0
    //   1016: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1019: invokevirtual 479	android/media/AudioTrack:play	()V
    //   1022: aload_0
    //   1023: getfield 137	com/tencent/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/sharp/jni/TraeAudioSession;
    //   1026: aload_0
    //   1027: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1030: invokevirtual 287	android/media/AudioManager:getMode	()I
    //   1033: aload_0
    //   1034: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   1037: invokevirtual 316	com/tencent/sharp/jni/TraeAudioSession:b	(II)I
    //   1040: pop
    //   1041: aload_0
    //   1042: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1045: astore 10
    //   1047: aload_0
    //   1048: getfield 141	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   1051: ldc_w 329
    //   1054: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1057: ifeq +68 -> 1125
    //   1060: bipush 6
    //   1062: istore_2
    //   1063: aload 10
    //   1065: iload_2
    //   1066: invokestatic 333	com/tencent/sharp/jni/TraeAudioManager:a	(Landroid/media/AudioManager;I)V
    //   1069: iload_1
    //   1070: istore_2
    //   1071: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1074: ifeq +42 -> 1116
    //   1077: ldc 186
    //   1079: iconst_2
    //   1080: new 188	java/lang/StringBuilder
    //   1083: dup
    //   1084: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   1087: ldc_w 481
    //   1090: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: invokestatic 450	android/os/SystemClock:elapsedRealtime	()J
    //   1096: lload 8
    //   1098: lsub
    //   1099: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1102: ldc_w 486
    //   1105: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1111: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1114: iload_1
    //   1115: istore_2
    //   1116: aload_0
    //   1117: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1120: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1123: iload_2
    //   1124: ireturn
    //   1125: aload_0
    //   1126: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1129: invokevirtual 336	android/media/AudioTrack:getStreamType	()I
    //   1132: istore_2
    //   1133: goto -70 -> 1063
    //   1136: aload_0
    //   1137: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1140: aload_0
    //   1141: getfield 171	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   1144: iconst_0
    //   1145: iload_1
    //   1146: invokevirtual 489	android/media/AudioTrack:write	([BII)I
    //   1149: istore_2
    //   1150: aload_0
    //   1151: getfield 167	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1154: invokevirtual 444	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1157: pop
    //   1158: iload_2
    //   1159: ifge +60 -> 1219
    //   1162: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1165: ifeq +45 -> 1210
    //   1168: ldc 186
    //   1170: iconst_2
    //   1171: new 188	java/lang/StringBuilder
    //   1174: dup
    //   1175: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   1178: ldc_w 491
    //   1181: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: iload_2
    //   1185: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1188: ldc_w 493
    //   1191: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: iload_1
    //   1195: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1198: ldc_w 495
    //   1201: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1210: aload_0
    //   1211: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1214: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1217: iconst_m1
    //   1218: ireturn
    //   1219: iload_2
    //   1220: iload_1
    //   1221: if_icmpeq +51 -> 1272
    //   1224: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1227: ifeq +45 -> 1272
    //   1230: ldc 186
    //   1232: iconst_2
    //   1233: new 188	java/lang/StringBuilder
    //   1236: dup
    //   1237: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   1240: ldc_w 497
    //   1243: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: iload_2
    //   1247: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1250: ldc_w 493
    //   1253: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: iload_1
    //   1257: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1260: ldc_w 495
    //   1263: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1272: aload_0
    //   1273: aload_0
    //   1274: getfield 119	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1277: iload_2
    //   1278: iconst_1
    //   1279: ishr
    //   1280: iadd
    //   1281: putfield 119	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1284: aload_0
    //   1285: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1288: invokevirtual 319	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1291: istore_1
    //   1292: iload_1
    //   1293: aload_0
    //   1294: getfield 121	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1297: if_icmpge +8 -> 1305
    //   1300: aload_0
    //   1301: iconst_0
    //   1302: putfield 121	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1305: aload_0
    //   1306: aload_0
    //   1307: getfield 119	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1310: iload_1
    //   1311: aload_0
    //   1312: getfield 121	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1315: isub
    //   1316: isub
    //   1317: putfield 119	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1320: aload_0
    //   1321: iload_1
    //   1322: putfield 121	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1325: aload_0
    //   1326: getfield 113	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   1329: ifne +23 -> 1352
    //   1332: aload_0
    //   1333: getfield 119	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1336: istore_1
    //   1337: goto -221 -> 1116
    //   1340: astore 10
    //   1342: iload_2
    //   1343: istore_1
    //   1344: goto -728 -> 616
    //   1347: astore 10
    //   1349: goto -280 -> 1069
    //   1352: goto -236 -> 1116
    //   1355: iconst_0
    //   1356: istore_3
    //   1357: goto -896 -> 461
    //   1360: iload_3
    //   1361: iconst_1
    //   1362: iadd
    //   1363: istore_3
    //   1364: goto -903 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1367	0	this	AudioDeviceInterface
    //   0	1367	1	paramInt	int
    //   8	1335	2	i	int
    //   17	1347	3	j	int
    //   533	34	4	k	int
    //   395	151	5	m	int
    //   546	353	6	n	int
    //   116	6	7	bool	boolean
    //   200	897	8	l	long
    //   95	382	10	localObject1	Object
    //   571	25	10	localException1	Exception
    //   612	27	10	localException2	Exception
    //   661	3	10	localIOException	java.io.IOException
    //   671	10	10	localObject2	Object
    //   778	1	10	localIllegalStateException	java.lang.IllegalStateException
    //   798	1	10	localException3	Exception
    //   1008	56	10	localObject3	Object
    //   1340	1	10	localException4	Exception
    //   1347	1	10	localException5	Exception
    //   937	19	11	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   124	129	571	java/lang/Exception
    //   91	97	612	java/lang/Exception
    //   112	118	612	java/lang/Exception
    //   129	134	612	java/lang/Exception
    //   134	146	612	java/lang/Exception
    //   151	164	612	java/lang/Exception
    //   164	171	612	java/lang/Exception
    //   173	185	612	java/lang/Exception
    //   573	609	612	java/lang/Exception
    //   663	668	612	java/lang/Exception
    //   683	713	612	java/lang/Exception
    //   713	741	612	java/lang/Exception
    //   741	755	612	java/lang/Exception
    //   757	762	612	java/lang/Exception
    //   765	770	612	java/lang/Exception
    //   1136	1150	612	java/lang/Exception
    //   151	164	661	java/io/IOException
    //   91	97	671	finally
    //   112	118	671	finally
    //   124	129	671	finally
    //   129	134	671	finally
    //   134	146	671	finally
    //   151	164	671	finally
    //   164	171	671	finally
    //   173	185	671	finally
    //   189	253	671	finally
    //   253	261	671	finally
    //   266	281	671	finally
    //   281	333	671	finally
    //   333	378	671	finally
    //   378	383	671	finally
    //   383	454	671	finally
    //   461	532	671	finally
    //   573	609	671	finally
    //   616	652	671	finally
    //   663	668	671	finally
    //   683	713	671	finally
    //   713	741	671	finally
    //   741	755	671	finally
    //   757	762	671	finally
    //   765	770	671	finally
    //   780	795	671	finally
    //   803	830	671	finally
    //   830	865	671	finally
    //   865	922	671	finally
    //   922	934	671	finally
    //   939	982	671	finally
    //   982	996	671	finally
    //   996	1001	671	finally
    //   1004	1010	671	finally
    //   1015	1060	671	finally
    //   1063	1069	671	finally
    //   1071	1114	671	finally
    //   1125	1133	671	finally
    //   1136	1150	671	finally
    //   1150	1158	671	finally
    //   1162	1210	671	finally
    //   1224	1272	671	finally
    //   1272	1305	671	finally
    //   1305	1337	671	finally
    //   266	281	778	java/lang/IllegalStateException
    //   281	333	778	java/lang/IllegalStateException
    //   333	378	778	java/lang/IllegalStateException
    //   378	383	778	java/lang/IllegalStateException
    //   189	253	798	java/lang/Exception
    //   253	261	798	java/lang/Exception
    //   266	281	798	java/lang/Exception
    //   281	333	798	java/lang/Exception
    //   333	378	798	java/lang/Exception
    //   378	383	798	java/lang/Exception
    //   383	454	798	java/lang/Exception
    //   461	532	798	java/lang/Exception
    //   780	795	798	java/lang/Exception
    //   830	865	798	java/lang/Exception
    //   865	922	798	java/lang/Exception
    //   922	934	798	java/lang/Exception
    //   939	982	798	java/lang/Exception
    //   982	996	798	java/lang/Exception
    //   996	1001	798	java/lang/Exception
    //   1004	1010	798	java/lang/Exception
    //   1071	1114	798	java/lang/Exception
    //   803	830	937	java/lang/Exception
    //   1150	1158	1340	java/lang/Exception
    //   1162	1210	1340	java/lang/Exception
    //   1224	1272	1340	java/lang/Exception
    //   1272	1305	1340	java/lang/Exception
    //   1305	1337	1340	java/lang/Exception
    //   1015	1060	1347	java/lang/Exception
    //   1063	1069	1347	java/lang/Exception
    //   1125	1133	1347	java/lang/Exception
  }
  
  /* Error */
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 113	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   4: ifne +40 -> 44
    //   7: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +32 -> 42
    //   13: ldc 186
    //   15: iconst_2
    //   16: new 188	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 500
    //   26: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 113	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   33: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: iconst_m1
    //   43: ireturn
    //   44: aload_0
    //   45: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   48: invokevirtual 421	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   51: aload_0
    //   52: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   55: astore 7
    //   57: aload 7
    //   59: ifnonnull +13 -> 72
    //   62: aload_0
    //   63: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   66: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   69: bipush 254
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 111	com/tencent/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   76: istore 6
    //   78: iload 6
    //   80: iconst_1
    //   81: if_icmpne +13 -> 94
    //   84: bipush 237
    //   86: invokestatic 430	android/os/Process:setThreadPriority	(I)V
    //   89: aload_0
    //   90: iconst_0
    //   91: putfield 111	com/tencent/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   94: aload_0
    //   95: getfield 145	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecordChanged	Z
    //   98: ifne +358 -> 456
    //   101: iconst_0
    //   102: istore_2
    //   103: iload_2
    //   104: ifeq +750 -> 854
    //   107: aload_0
    //   108: getfield 169	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   111: invokevirtual 444	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   114: pop
    //   115: aload_0
    //   116: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   119: invokevirtual 503	android/media/AudioRecord:getRecordingState	()I
    //   122: istore_1
    //   123: iload_1
    //   124: iconst_3
    //   125: if_icmpne +48 -> 173
    //   128: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +35 -> 166
    //   134: ldc 186
    //   136: iconst_2
    //   137: new 188	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 505
    //   147: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_0
    //   151: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   154: invokevirtual 503	android/media/AudioRecord:getRecordingState	()I
    //   157: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_0
    //   167: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   170: invokevirtual 506	android/media/AudioRecord:stop	()V
    //   173: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +35 -> 211
    //   179: ldc 186
    //   181: iconst_2
    //   182: new 188	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 508
    //   192: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_0
    //   196: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   199: invokevirtual 503	android/media/AudioRecord:getRecordingState	()I
    //   202: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload_0
    //   212: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   215: invokevirtual 359	android/media/AudioRecord:release	()V
    //   218: aload_0
    //   219: aconst_null
    //   220: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   223: aload_0
    //   224: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   227: aload_0
    //   228: getfield 133	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   231: iconst_2
    //   232: invokestatic 344	android/media/AudioRecord:getMinBufferSize	(III)I
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
    //   265: getfield 88	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   268: invokestatic 361	com/tencent/sharp/jni/TraeAudioManager:a	(I)I
    //   271: iastore
    //   272: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +32 -> 307
    //   278: ldc 186
    //   280: iconst_2
    //   281: new 188	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 510
    //   291: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload 7
    //   296: iconst_0
    //   297: iaload
    //   298: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aload_0
    //   308: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
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
    //   324: getfield 133	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
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
    //   347: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   350: ifnonnull +444 -> 794
    //   353: aload_0
    //   354: aload 7
    //   356: iload_2
    //   357: iaload
    //   358: putfield 88	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   361: iconst_1
    //   362: istore_3
    //   363: goto +702 -> 1065
    //   366: astore 7
    //   368: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq -282 -> 89
    //   374: ldc 186
    //   376: iconst_2
    //   377: new 188	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 512
    //   387: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 7
    //   392: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   395: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: goto -315 -> 89
    //   407: astore 7
    //   409: iconst_0
    //   410: istore_2
    //   411: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +33 -> 447
    //   417: ldc 186
    //   419: iconst_2
    //   420: new 188	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   427: ldc_w 514
    //   430: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload 7
    //   435: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   438: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload_0
    //   448: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   451: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   454: iload_2
    //   455: ireturn
    //   456: aload_0
    //   457: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   460: ifnonnull +26 -> 486
    //   463: aload_0
    //   464: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   467: ifnull +19 -> 486
    //   470: aload_0
    //   471: aload_0
    //   472: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   475: ldc 227
    //   477: invokevirtual 233	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   480: checkcast 235	android/media/AudioManager
    //   483: putfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   486: aload_0
    //   487: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   490: astore 7
    //   492: aload 7
    //   494: ifnonnull +12 -> 506
    //   497: aload_0
    //   498: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   501: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   504: iconst_m1
    //   505: ireturn
    //   506: aload_0
    //   507: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   510: invokevirtual 287	android/media/AudioManager:getMode	()I
    //   513: ifne +60 -> 573
    //   516: aload_0
    //   517: getfield 141	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   520: ldc_w 289
    //   523: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   526: ifeq +47 -> 573
    //   529: aload_0
    //   530: iconst_0
    //   531: invokestatic 361	com/tencent/sharp/jni/TraeAudioManager:a	(I)I
    //   534: putfield 88	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   537: aload_0
    //   538: getfield 88	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   541: aload_0
    //   542: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   545: invokevirtual 517	android/media/AudioRecord:getAudioSource	()I
    //   548: if_icmpne +548 -> 1096
    //   551: iconst_0
    //   552: istore_2
    //   553: aload_0
    //   554: iconst_0
    //   555: putfield 145	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecordChanged	Z
    //   558: goto -455 -> 103
    //   561: astore 7
    //   563: aload_0
    //   564: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   567: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   570: aload 7
    //   572: athrow
    //   573: aload_0
    //   574: bipush 7
    //   576: invokestatic 361	com/tencent/sharp/jni/TraeAudioManager:a	(I)I
    //   579: putfield 88	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   582: goto -45 -> 537
    //   585: astore 7
    //   587: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   590: ifeq +12 -> 602
    //   593: ldc 186
    //   595: iconst_2
    //   596: ldc_w 519
    //   599: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: aload 7
    //   604: invokevirtual 520	java/lang/IllegalStateException:printStackTrace	()V
    //   607: aload_0
    //   608: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   611: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   614: iconst_m1
    //   615: ireturn
    //   616: aload_0
    //   617: new 343	android/media/AudioRecord
    //   620: dup
    //   621: aload_0
    //   622: getfield 88	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   625: aload_0
    //   626: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   629: aload_0
    //   630: getfield 133	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   633: iconst_2
    //   634: iload 5
    //   636: invokespecial 366	android/media/AudioRecord:<init>	(IIIII)V
    //   639: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   642: aload_0
    //   643: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   646: invokevirtual 367	android/media/AudioRecord:getState	()I
    //   649: iconst_1
    //   650: if_icmpeq +451 -> 1101
    //   653: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   656: ifeq +56 -> 712
    //   659: ldc 186
    //   661: iconst_2
    //   662: new 188	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   669: ldc_w 369
    //   672: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: iload 5
    //   677: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   680: ldc_w 305
    //   683: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_0
    //   687: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   690: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   693: ldc_w 371
    //   696: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload_0
    //   700: getfield 88	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   703: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   706: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: aload_0
    //   713: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   716: invokevirtual 359	android/media/AudioRecord:release	()V
    //   719: aload_0
    //   720: aconst_null
    //   721: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   724: goto +365 -> 1089
    //   727: astore 8
    //   729: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   732: ifeq +40 -> 772
    //   735: ldc 186
    //   737: iconst_2
    //   738: new 188	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   745: aload 8
    //   747: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   750: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: ldc_w 373
    //   756: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload_0
    //   760: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   763: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   766: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   772: aload_0
    //   773: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   776: ifnull +10 -> 786
    //   779: aload_0
    //   780: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   783: invokevirtual 359	android/media/AudioRecord:release	()V
    //   786: aload_0
    //   787: aconst_null
    //   788: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   791: goto +298 -> 1089
    //   794: aload_0
    //   795: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   798: astore 7
    //   800: aload 7
    //   802: ifnull +10 -> 812
    //   805: aload_0
    //   806: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   809: invokevirtual 523	android/media/AudioRecord:startRecording	()V
    //   812: iconst_0
    //   813: istore_3
    //   814: aload_0
    //   815: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   818: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   821: iload_3
    //   822: ireturn
    //   823: astore 7
    //   825: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   828: ifeq +12 -> 840
    //   831: ldc 186
    //   833: iconst_2
    //   834: ldc_w 525
    //   837: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   840: aload 7
    //   842: invokevirtual 520	java/lang/IllegalStateException:printStackTrace	()V
    //   845: aload_0
    //   846: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   849: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   852: iconst_m1
    //   853: ireturn
    //   854: aload_0
    //   855: getfield 169	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   858: invokevirtual 444	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   861: pop
    //   862: aload_0
    //   863: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   866: aload_0
    //   867: getfield 173	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   870: iconst_0
    //   871: iload_1
    //   872: invokevirtual 528	android/media/AudioRecord:read	([BII)I
    //   875: istore_2
    //   876: iload_2
    //   877: ifge +60 -> 937
    //   880: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   883: ifeq +45 -> 928
    //   886: ldc 186
    //   888: iconst_2
    //   889: new 188	java/lang/StringBuilder
    //   892: dup
    //   893: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   896: ldc_w 530
    //   899: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: iload_2
    //   903: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   906: ldc_w 493
    //   909: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: iload_1
    //   913: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   916: ldc_w 495
    //   919: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   925: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   928: aload_0
    //   929: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   932: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   935: iconst_m1
    //   936: ireturn
    //   937: aload_0
    //   938: getfield 169	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   941: aload_0
    //   942: getfield 173	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   945: iconst_0
    //   946: iload_2
    //   947: invokevirtual 534	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   950: pop
    //   951: getstatic 68	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   954: ifeq +27 -> 981
    //   957: aload_0
    //   958: getfield 127	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   961: astore 7
    //   963: aload 7
    //   965: ifnull +16 -> 981
    //   968: aload_0
    //   969: getfield 127	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   972: aload_0
    //   973: getfield 173	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   976: iconst_0
    //   977: iload_2
    //   978: invokevirtual 436	java/io/FileOutputStream:write	([BII)V
    //   981: iload_2
    //   982: istore_3
    //   983: iload_2
    //   984: iload_1
    //   985: if_icmpeq -171 -> 814
    //   988: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   991: ifeq +45 -> 1036
    //   994: ldc 186
    //   996: iconst_2
    //   997: new 188	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   1004: ldc_w 536
    //   1007: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: iload_2
    //   1011: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1014: ldc_w 493
    //   1017: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: iload_1
    //   1021: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1024: ldc_w 495
    //   1027: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1033: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1036: aload_0
    //   1037: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1040: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1043: iconst_m1
    //   1044: ireturn
    //   1045: astore 7
    //   1047: aload 7
    //   1049: invokevirtual 474	java/io/IOException:printStackTrace	()V
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
    //   3: getfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   6: ifeq +20 -> 26
    //   9: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 186
    //   17: iconst_2
    //   18: ldc_w 546
    //   21: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   30: ifnonnull +40 -> 70
    //   33: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -12 -> 24
    //   39: ldc 186
    //   41: iconst_2
    //   42: new 188	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 548
    //   52: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   59: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: iconst_m1
    //   69: ireturn
    //   70: aload_0
    //   71: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   74: invokevirtual 479	android/media/AudioTrack:play	()V
    //   77: getstatic 68	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   80: ifeq +52 -> 132
    //   83: aload_0
    //   84: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   87: ifnull +11 -> 98
    //   90: aload_0
    //   91: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   94: invokevirtual 287	android/media/AudioManager:getMode	()I
    //   97: istore_1
    //   98: aload_0
    //   99: new 550	java/io/File
    //   102: dup
    //   103: aload_0
    //   104: ldc_w 552
    //   107: iload_1
    //   108: invokespecial 556	com/tencent/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   111: invokespecial 558	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: putfield 125	com/tencent/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   117: aload_0
    //   118: new 432	java/io/FileOutputStream
    //   121: dup
    //   122: aload_0
    //   123: getfield 125	com/tencent/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   126: invokespecial 561	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   129: putfield 129	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   137: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +12 -> 152
    //   143: ldc 186
    //   145: iconst_2
    //   146: ldc_w 563
    //   149: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_2
    //   155: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +12 -> 170
    //   161: ldc 186
    //   163: iconst_2
    //   164: ldc_w 565
    //   167: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_2
    //   171: invokevirtual 520	java/lang/IllegalStateException:printStackTrace	()V
    //   174: iconst_m1
    //   175: ireturn
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 566	java/io/FileNotFoundException:printStackTrace	()V
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
    //   2: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 186
    //   10: iconst_2
    //   11: ldc_w 569
    //   14: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 113	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   21: ifeq +40 -> 61
    //   24: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +32 -> 59
    //   30: ldc 186
    //   32: iconst_2
    //   33: new 188	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 571
    //   43: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 113	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   50: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iconst_m1
    //   60: ireturn
    //   61: aload_0
    //   62: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   65: ifnonnull +40 -> 105
    //   68: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq -12 -> 59
    //   74: ldc 186
    //   76: iconst_2
    //   77: new 188	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 573
    //   87: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   94: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iconst_m1
    //   104: ireturn
    //   105: aload_0
    //   106: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   109: invokevirtual 523	android/media/AudioRecord:startRecording	()V
    //   112: getstatic 68	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   115: ifeq +52 -> 167
    //   118: aload_0
    //   119: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   122: ifnull +11 -> 133
    //   125: aload_0
    //   126: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   129: invokevirtual 287	android/media/AudioManager:getMode	()I
    //   132: istore_1
    //   133: aload_0
    //   134: new 550	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: ldc_w 575
    //   142: iload_1
    //   143: invokespecial 556	com/tencent/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   146: invokespecial 558	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: putfield 123	com/tencent/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   152: aload_0
    //   153: new 432	java/io/FileOutputStream
    //   156: dup
    //   157: aload_0
    //   158: getfield 123	com/tencent/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   161: invokespecial 561	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: putfield 127	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   167: aload_0
    //   168: iconst_1
    //   169: putfield 113	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   172: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +12 -> 187
    //   178: ldc 186
    //   180: iconst_2
    //   181: ldc_w 577
    //   184: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_2
    //   190: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +12 -> 205
    //   196: ldc 186
    //   198: iconst_2
    //   199: ldc_w 525
    //   202: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_2
    //   206: invokevirtual 520	java/lang/IllegalStateException:printStackTrace	()V
    //   209: iconst_m1
    //   210: ireturn
    //   211: astore_2
    //   212: aload_2
    //   213: invokevirtual 566	java/io/FileNotFoundException:printStackTrace	()V
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
    //   0: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +32 -> 35
    //   6: ldc 186
    //   8: iconst_2
    //   9: new 188	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 580
    //   19: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   26: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   39: ifnonnull +53 -> 92
    //   42: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +45 -> 90
    //   48: ldc 186
    //   50: iconst_2
    //   51: new 188	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 582
    //   61: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: getfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   68: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   71: ldc_w 418
    //   74: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   81: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_m1
    //   91: ireturn
    //   92: aload_0
    //   93: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   96: invokevirtual 421	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   99: aload_0
    //   100: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   103: invokevirtual 457	android/media/AudioTrack:getPlayState	()I
    //   106: istore_1
    //   107: iload_1
    //   108: iconst_3
    //   109: if_icmpne +70 -> 179
    //   112: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +12 -> 127
    //   118: ldc 186
    //   120: iconst_2
    //   121: ldc_w 459
    //   124: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_0
    //   128: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   131: invokevirtual 462	android/media/AudioTrack:stop	()V
    //   134: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +35 -> 172
    //   140: ldc 186
    //   142: iconst_2
    //   143: new 188	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 467
    //   153: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   160: invokevirtual 457	android/media/AudioTrack:getPlayState	()I
    //   163: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   176: invokevirtual 465	android/media/AudioTrack:flush	()V
    //   179: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +35 -> 217
    //   185: ldc 186
    //   187: iconst_2
    //   188: new 188	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 469
    //   198: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   205: invokevirtual 457	android/media/AudioTrack:getPlayState	()I
    //   208: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_0
    //   218: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   221: invokevirtual 266	android/media/AudioTrack:release	()V
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   229: aload_0
    //   230: iconst_0
    //   231: putfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   234: aload_0
    //   235: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   238: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   241: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +12 -> 256
    //   247: ldc 186
    //   249: iconst_2
    //   250: ldc_w 584
    //   253: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: iconst_0
    //   257: ireturn
    //   258: astore_2
    //   259: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +12 -> 274
    //   265: ldc 186
    //   267: iconst_2
    //   268: ldc_w 476
    //   271: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_2
    //   275: invokevirtual 520	java/lang/IllegalStateException:printStackTrace	()V
    //   278: aload_0
    //   279: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   282: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   285: iconst_m1
    //   286: ireturn
    //   287: astore_2
    //   288: aload_0
    //   289: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   292: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
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
    //   0: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 186
    //   8: iconst_2
    //   9: ldc_w 587
    //   12: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   19: ifnonnull +40 -> 59
    //   22: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +32 -> 57
    //   28: ldc 186
    //   30: iconst_2
    //   31: new 188	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 589
    //   41: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   48: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iconst_m1
    //   58: ireturn
    //   59: aload_0
    //   60: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   63: invokevirtual 421	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   66: aload_0
    //   67: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   70: invokevirtual 503	android/media/AudioRecord:getRecordingState	()I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_3
    //   76: if_icmpne +48 -> 124
    //   79: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +35 -> 117
    //   85: ldc 186
    //   87: iconst_2
    //   88: new 188	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 505
    //   98: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   105: invokevirtual 503	android/media/AudioRecord:getRecordingState	()I
    //   108: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_0
    //   118: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   121: invokevirtual 506	android/media/AudioRecord:stop	()V
    //   124: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +35 -> 162
    //   130: ldc 186
    //   132: iconst_2
    //   133: new 188	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 508
    //   143: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   150: invokevirtual 503	android/media/AudioRecord:getRecordingState	()I
    //   153: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   166: invokevirtual 359	android/media/AudioRecord:release	()V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 113	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   179: aload_0
    //   180: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   183: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   186: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +12 -> 201
    //   192: ldc 186
    //   194: iconst_2
    //   195: ldc_w 591
    //   198: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_2
    //   204: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +12 -> 219
    //   210: ldc 186
    //   212: iconst_2
    //   213: ldc_w 519
    //   216: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_2
    //   220: invokevirtual 520	java/lang/IllegalStateException:printStackTrace	()V
    //   223: aload_0
    //   224: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   227: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   230: iconst_m1
    //   231: ireturn
    //   232: astore_2
    //   233: aload_0
    //   234: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   237: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
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
      this._as = new TraeAudioSession(this._context, new AudioDeviceInterface.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sharp.jni.AudioDeviceInterface
 * JD-Core Version:    0.7.0.1
 */