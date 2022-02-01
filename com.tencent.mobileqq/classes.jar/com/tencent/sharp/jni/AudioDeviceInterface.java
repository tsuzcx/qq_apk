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
import com.tencent.sharp.jni.api.impl.TraeAudioSessionApiImpl;
import java.io.File;
import java.io.FileNotFoundException;
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
  private TraeAudioSessionApiImpl _as = null;
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
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, localException.getMessage());
      }
    }
    this._tempBufPlay = new byte[1920];
    this._tempBufRec = new byte[1920];
    int i = Build.VERSION.SDK_INT;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioDeviceInterface apiLevel:");
      localStringBuilder.append(i);
      QLog.w("TRAE", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" SDK_INT:");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.w("TRAE", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("manufacture:");
      localStringBuilder.append(Build.MANUFACTURER);
      QLog.w("TRAE", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MODEL:");
      localStringBuilder.append(Build.MODEL);
      QLog.w("TRAE", 2, localStringBuilder.toString());
    }
  }
  
  private int GetPlayoutVolume()
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
    if (localObject != null) {
      i = ((AudioManager)localObject).getStreamVolume(0);
    }
    return i;
  }
  
  private int InitPlayback(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("InitPlayback entry: sampleRate ");
      localStringBuilder1.append(paramInt1);
      QLog.w("TRAE", 2, localStringBuilder1.toString());
    }
    label768:
    Object localObject2;
    if ((!this._isPlaying) && (this._audioTrack == null) && (paramInt2 <= 2) && (paramInt2 >= 1))
    {
      if (this._audioManager == null) {
        try
        {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, localException1.getMessage());
          }
          return -1;
        }
      }
      if (paramInt2 == 2) {
        this._channelPlayType = 12;
      } else {
        this._channelPlayType = 4;
      }
      this._playSamplerate = paramInt1;
      int j = AudioTrack.getMinBufferSize(paramInt1, this._channelPlayType, 2);
      if (this._channelPlayType == 12) {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitPlayback, _channelPlayType stero");
        } else if ((this._channelPlayType == 4) && (QLog.isColorLevel())) {
          QLog.w("TRAE", 2, "InitPlayback, _channelPlayType Mono");
        }
      }
      int k = paramInt1 * 20 * paramInt2 * 2 / 1000;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("InitPlayback: minPlayBufSize:");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(" 20msFz:");
        ((StringBuilder)localObject1).append(k);
        QLog.w("TRAE", 2, ((StringBuilder)localObject1).toString());
      }
      this._bufferedPlaySamples = 0;
      Object localObject1 = this._audioTrack;
      if (localObject1 != null)
      {
        ((AudioTrack)localObject1).release();
        this._audioTrack = null;
      }
      int[] arrayOfInt = new int[4];
      int[] tmp303_301 = arrayOfInt;
      tmp303_301[0] = 0;
      int[] tmp307_303 = tmp303_301;
      tmp307_303[1] = 0;
      int[] tmp311_307 = tmp307_303;
      tmp311_307[2] = 3;
      int[] tmp315_311 = tmp311_307;
      tmp315_311[3] = 1;
      tmp315_311;
      this._streamType = TraeUtils.b(this._audioStreamTypePolicy);
      if (this._audioRouteChanged)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("_audioRouteChanged:");
          ((StringBuilder)localObject1).append(this._audioRouteChanged);
          ((StringBuilder)localObject1).append(" _streamType:");
          ((StringBuilder)localObject1).append(this._streamType);
          QLog.w("TRAE", 2, ((StringBuilder)localObject1).toString());
        }
        if ((this._audioManager.getMode() == 0) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
          this._streamType = 3;
        } else {
          this._streamType = 0;
        }
        this._audioRouteChanged = false;
      }
      arrayOfInt[0] = this._streamType;
      paramInt1 = j;
      paramInt2 = 0;
      while ((paramInt2 < arrayOfInt.length) && (this._audioTrack == null))
      {
        this._streamType = arrayOfInt[paramInt2];
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("InitPlayback: min play buf size is ");
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append(" hw_sr:");
          ((StringBuilder)localObject1).append(AudioTrack.getNativeOutputSampleRate(this._streamType));
          QLog.w("TRAE", 2, ((StringBuilder)localObject1).toString());
        }
        int i = 1;
        while (i <= 2)
        {
          paramInt1 = j * i;
          if ((paramInt1 >= k * 4) || (i >= 2))
          {
            try
            {
              int m = this._streamType;
              int n = this._playSamplerate;
              int i1 = this._channelPlayType;
              try
              {
                this._audioTrack = new AudioTrack(m, n, i1, 2, paramInt1, 1);
                if (this._audioTrack.getState() != 1)
                {
                  if (QLog.isColorLevel())
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("InitPlayback: play not initialized playBufSize:");
                    ((StringBuilder)localObject1).append(paramInt1);
                    ((StringBuilder)localObject1).append(" sr:");
                    ((StringBuilder)localObject1).append(this._playSamplerate);
                    QLog.w("TRAE", 2, ((StringBuilder)localObject1).toString());
                  }
                  this._audioTrack.release();
                  this._audioTrack = null;
                  break label789;
                }
              }
              catch (Exception localException2) {}
              if (!QLog.isColorLevel()) {
                break label768;
              }
            }
            catch (Exception localException3) {}
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(localException3.getMessage());
            localStringBuilder2.append(" _audioTrack:");
            localStringBuilder2.append(this._audioTrack);
            QLog.w("TRAE", 2, localStringBuilder2.toString());
            localObject2 = this._audioTrack;
            if (localObject2 != null) {
              ((AudioTrack)localObject2).release();
            }
            this._audioTrack = null;
          }
          label789:
          i += 1;
        }
        paramInt2 += 1;
      }
      if (this._audioTrack == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitPlayback fail!!!");
        }
        return -1;
      }
      localObject2 = this._as;
      if ((localObject2 != null) && (this._audioManager != null)) {
        ((TraeAudioSessionApiImpl)localObject2).voiceCallAudioParamChanged(this._streamType);
      }
      this._playPosition = this._audioTrack.getPlaybackHeadPosition();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("InitPlayback exit: streamType:");
        ((StringBuilder)localObject2).append(this._streamType);
        ((StringBuilder)localObject2).append(" samplerate:");
        ((StringBuilder)localObject2).append(this._playSamplerate);
        ((StringBuilder)localObject2).append(" _playPosition:");
        ((StringBuilder)localObject2).append(this._playPosition);
        ((StringBuilder)localObject2).append(" playBufSize:");
        ((StringBuilder)localObject2).append(paramInt1);
        QLog.w("TRAE", 2, ((StringBuilder)localObject2).toString());
      }
      if (this._connectedDev.equals("DEVICE_BLUETOOTH_HEADSET")) {
        paramInt1 = 6;
      } else {
        paramInt1 = this._audioTrack.getStreamType();
      }
      if (paramInt1 == 6) {
        this._IsBluetoothStreamVolume = true;
      } else {
        this._IsBluetoothStreamVolume = false;
      }
      TraeUtils.a(this._audioManager, paramInt1);
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("InitPlayback _isPlaying:");
      ((StringBuilder)localObject2).append(this._isPlaying);
      QLog.e("TRAE", 2, ((StringBuilder)localObject2).toString());
    }
    return -1;
  }
  
  /* Error */
  private int InitRecording(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: new 194	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   13: astore 9
    //   15: aload 9
    //   17: ldc_w 338
    //   20: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 9
    //   26: iload_1
    //   27: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc 175
    //   33: iconst_2
    //   34: aload 9
    //   36: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: getfield 111	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   46: ifne +897 -> 943
    //   49: aload_0
    //   50: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   53: ifnonnull +890 -> 943
    //   56: iload_2
    //   57: iconst_2
    //   58: if_icmpgt +885 -> 943
    //   61: iload_2
    //   62: iconst_1
    //   63: if_icmpge +6 -> 69
    //   66: goto +877 -> 943
    //   69: aload_0
    //   70: getfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   73: ifnonnull +43 -> 116
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   81: ldc 225
    //   83: invokevirtual 231	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   86: checkcast 233	android/media/AudioManager
    //   89: putfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   92: goto +24 -> 116
    //   95: astore 9
    //   97: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +14 -> 114
    //   103: ldc 175
    //   105: iconst_2
    //   106: aload 9
    //   108: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   111: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: iconst_m1
    //   115: ireturn
    //   116: aload_0
    //   117: bipush 16
    //   119: putfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   122: iload_2
    //   123: iconst_2
    //   124: if_icmpne +9 -> 133
    //   127: aload_0
    //   128: bipush 12
    //   130: putfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   133: aload_0
    //   134: iload_1
    //   135: putfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   138: iload_1
    //   139: aload_0
    //   140: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   143: iconst_2
    //   144: invokestatic 341	android/media/AudioRecord:getMinBufferSize	(III)I
    //   147: istore 5
    //   149: iload_1
    //   150: bipush 20
    //   152: imul
    //   153: iload_2
    //   154: imul
    //   155: iconst_2
    //   156: imul
    //   157: sipush 1000
    //   160: idiv
    //   161: istore 6
    //   163: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +95 -> 261
    //   169: new 194	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   176: astore 9
    //   178: aload 9
    //   180: ldc_w 343
    //   183: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 9
    //   189: iload 5
    //   191: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 9
    //   197: ldc_w 298
    //   200: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 9
    //   206: aload_0
    //   207: invokespecial 346	com/tencent/sharp/jni/AudioDeviceInterface:getLowlatencySamplerate	()I
    //   210: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 9
    //   216: ldc_w 348
    //   219: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 9
    //   225: aload_0
    //   226: invokespecial 351	com/tencent/sharp/jni/AudioDeviceInterface:getLowlatencyFramesPerBuffer	()I
    //   229: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 9
    //   235: ldc_w 353
    //   238: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 9
    //   244: iload 6
    //   246: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 175
    //   252: iconst_2
    //   253: aload 9
    //   255: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_0
    //   262: iload_1
    //   263: iconst_5
    //   264: imul
    //   265: sipush 200
    //   268: idiv
    //   269: putfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedRecSamples	I
    //   272: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +42 -> 317
    //   278: new 194	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   285: astore 9
    //   287: aload 9
    //   289: ldc_w 355
    //   292: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 9
    //   298: aload_0
    //   299: getfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedRecSamples	I
    //   302: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: ldc 175
    //   308: iconst_2
    //   309: aload 9
    //   311: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload_0
    //   318: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   321: astore 10
    //   323: aconst_null
    //   324: astore 9
    //   326: aload 10
    //   328: ifnull +13 -> 341
    //   331: aload 10
    //   333: invokevirtual 356	android/media/AudioRecord:release	()V
    //   336: aload_0
    //   337: aconst_null
    //   338: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   341: iconst_4
    //   342: newarray int
    //   344: astore 10
    //   346: aload 10
    //   348: dup
    //   349: iconst_0
    //   350: iconst_0
    //   351: iastore
    //   352: dup
    //   353: iconst_1
    //   354: iconst_1
    //   355: iastore
    //   356: dup
    //   357: iconst_2
    //   358: iconst_5
    //   359: iastore
    //   360: dup
    //   361: iconst_3
    //   362: iconst_0
    //   363: iastore
    //   364: pop
    //   365: aload 10
    //   367: iconst_0
    //   368: aload_0
    //   369: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_audioSourcePolicy	I
    //   372: invokestatic 358	com/tencent/sharp/jni/TraeUtils:a	(I)I
    //   375: iastore
    //   376: aload_0
    //   377: getfield 143	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecordChanged	Z
    //   380: ifne +6 -> 386
    //   383: goto +96 -> 479
    //   386: aload_0
    //   387: getfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   390: invokevirtual 273	android/media/AudioManager:getMode	()I
    //   393: ifne +27 -> 420
    //   396: aload_0
    //   397: getfield 139	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   400: ldc_w 275
    //   403: invokevirtual 281	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   406: ifeq +14 -> 420
    //   409: aload 10
    //   411: iconst_0
    //   412: iconst_0
    //   413: invokestatic 358	com/tencent/sharp/jni/TraeUtils:a	(I)I
    //   416: iastore
    //   417: goto +12 -> 429
    //   420: aload 10
    //   422: iconst_0
    //   423: bipush 7
    //   425: invokestatic 358	com/tencent/sharp/jni/TraeUtils:a	(I)I
    //   428: iastore
    //   429: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   432: ifeq +42 -> 474
    //   435: new 194	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   442: astore 11
    //   444: aload 11
    //   446: ldc_w 360
    //   449: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 11
    //   455: aload 10
    //   457: iconst_0
    //   458: iaload
    //   459: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: ldc 175
    //   465: iconst_2
    //   466: aload 11
    //   468: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   474: aload_0
    //   475: iconst_0
    //   476: putfield 143	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecordChanged	Z
    //   479: iload 5
    //   481: istore_2
    //   482: iconst_0
    //   483: istore_3
    //   484: iload_3
    //   485: aload 10
    //   487: arraylength
    //   488: if_icmpge +315 -> 803
    //   491: aload_0
    //   492: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   495: ifnonnull +308 -> 803
    //   498: aload_0
    //   499: aload 10
    //   501: iload_3
    //   502: iaload
    //   503: putfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   506: iconst_1
    //   507: istore 4
    //   509: iload 4
    //   511: iconst_2
    //   512: if_icmpgt +284 -> 796
    //   515: iload 5
    //   517: iload 4
    //   519: imul
    //   520: istore_2
    //   521: iload_2
    //   522: iload 6
    //   524: iconst_4
    //   525: imul
    //   526: if_icmpge +12 -> 538
    //   529: iload 4
    //   531: iconst_2
    //   532: if_icmpge +6 -> 538
    //   535: goto +252 -> 787
    //   538: aload_0
    //   539: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   542: istore 7
    //   544: aload_0
    //   545: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   548: istore 8
    //   550: aconst_null
    //   551: astore 11
    //   553: aconst_null
    //   554: astore 12
    //   556: aconst_null
    //   557: astore 9
    //   559: aload_0
    //   560: new 340	android/media/AudioRecord
    //   563: dup
    //   564: iload 7
    //   566: iload_1
    //   567: iload 8
    //   569: iconst_2
    //   570: iload_2
    //   571: invokespecial 363	android/media/AudioRecord:<init>	(IIIII)V
    //   574: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   577: aload_0
    //   578: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   581: invokevirtual 364	android/media/AudioRecord:getState	()I
    //   584: iconst_1
    //   585: if_icmpeq +102 -> 687
    //   588: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq +77 -> 668
    //   594: new 194	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   601: astore 9
    //   603: aload 9
    //   605: ldc_w 366
    //   608: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload 9
    //   614: iload_2
    //   615: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload 9
    //   621: ldc_w 298
    //   624: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 9
    //   630: iload_1
    //   631: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 9
    //   637: ldc_w 368
    //   640: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 9
    //   646: aload_0
    //   647: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   650: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: ldc 175
    //   656: iconst_2
    //   657: aload 9
    //   659: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: goto +3 -> 668
    //   668: aload_0
    //   669: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   672: invokevirtual 356	android/media/AudioRecord:release	()V
    //   675: aload_0
    //   676: aconst_null
    //   677: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   680: aload 11
    //   682: astore 9
    //   684: goto +103 -> 787
    //   687: aload 12
    //   689: astore 9
    //   691: goto +105 -> 796
    //   694: astore 11
    //   696: goto +13 -> 709
    //   699: astore 11
    //   701: aconst_null
    //   702: astore 9
    //   704: goto +5 -> 709
    //   707: astore 11
    //   709: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq +53 -> 765
    //   715: new 194	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   722: astore 12
    //   724: aload 12
    //   726: aload 11
    //   728: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   731: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload 12
    //   737: ldc_w 370
    //   740: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload 12
    //   746: aload_0
    //   747: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   750: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: ldc 175
    //   756: iconst_2
    //   757: aload 12
    //   759: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: aload_0
    //   766: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   769: astore 11
    //   771: aload 11
    //   773: ifnull +8 -> 781
    //   776: aload 11
    //   778: invokevirtual 356	android/media/AudioRecord:release	()V
    //   781: aload_0
    //   782: aload 9
    //   784: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   787: iload 4
    //   789: iconst_1
    //   790: iadd
    //   791: istore 4
    //   793: goto -284 -> 509
    //   796: iload_3
    //   797: iconst_1
    //   798: iadd
    //   799: istore_3
    //   800: goto -316 -> 484
    //   803: aload_0
    //   804: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   807: ifnonnull +20 -> 827
    //   810: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   813: ifeq +12 -> 825
    //   816: ldc 175
    //   818: iconst_2
    //   819: ldc_w 372
    //   822: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   825: iconst_m1
    //   826: ireturn
    //   827: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   830: ifeq +93 -> 923
    //   833: new 194	java/lang/StringBuilder
    //   836: dup
    //   837: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   840: astore 9
    //   842: aload 9
    //   844: ldc_w 374
    //   847: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: pop
    //   851: aload 9
    //   853: aload_0
    //   854: getfield 88	com/tencent/sharp/jni/AudioDeviceInterface:_sessionId	I
    //   857: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: aload 9
    //   863: ldc_w 376
    //   866: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: pop
    //   870: aload 9
    //   872: aload_0
    //   873: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   876: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: aload 9
    //   882: ldc_w 378
    //   885: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: pop
    //   889: aload 9
    //   891: iload_1
    //   892: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload 9
    //   898: ldc_w 380
    //   901: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: aload 9
    //   907: iload_2
    //   908: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   911: pop
    //   912: ldc 175
    //   914: iconst_2
    //   915: aload 9
    //   917: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   923: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   926: ifeq +12 -> 938
    //   929: ldc 175
    //   931: iconst_2
    //   932: ldc_w 382
    //   935: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   938: aload_0
    //   939: getfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedRecSamples	I
    //   942: ireturn
    //   943: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   946: ifeq +42 -> 988
    //   949: new 194	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   956: astore 9
    //   958: aload 9
    //   960: ldc_w 384
    //   963: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: aload 9
    //   969: aload_0
    //   970: getfield 111	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   973: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: ldc 175
    //   979: iconst_2
    //   980: aload 9
    //   982: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   988: iconst_m1
    //   989: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	990	0	this	AudioDeviceInterface
    //   0	990	1	paramInt1	int
    //   0	990	2	paramInt2	int
    //   483	317	3	i	int
    //   507	285	4	j	int
    //   147	373	5	k	int
    //   161	365	6	m	int
    //   542	23	7	n	int
    //   548	20	8	i1	int
    //   13	22	9	localStringBuilder1	StringBuilder
    //   95	12	9	localException1	Exception
    //   176	805	9	localObject1	Object
    //   321	179	10	localObject2	Object
    //   442	239	11	localStringBuilder2	StringBuilder
    //   694	1	11	localException2	Exception
    //   699	1	11	localException3	Exception
    //   707	20	11	localException4	Exception
    //   769	8	11	localAudioRecord	AudioRecord
    //   554	204	12	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   76	92	95	java/lang/Exception
    //   559	577	694	java/lang/Exception
    //   544	550	699	java/lang/Exception
    //   538	544	707	java/lang/Exception
  }
  
  private int InitSetting(int paramInt1, int paramInt2, int paramInt3)
  {
    this._audioSourcePolicy = paramInt1;
    this._audioStreamTypePolicy = paramInt2;
    this._modePolicy = paramInt3;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("InitSetting: _audioSourcePolicy:");
      localStringBuilder.append(this._audioSourcePolicy);
      localStringBuilder.append(" _audioStreamTypePolicy:");
      localStringBuilder.append(this._audioStreamTypePolicy);
      localStringBuilder.append(" _modePolicy:");
      localStringBuilder.append(this._modePolicy);
      QLog.w("TRAE", 2, localStringBuilder.toString());
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
      QLog.w("TRAE", 2, paramString);
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
      QLog.w("TRAE", 2, (String)localObject);
    }
  }
  
  /* Error */
  private int OpenslesNeedResetAudioTrack(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_modePolicy	I
    //   4: iconst_m1
    //   5: if_icmpeq +110 -> 115
    //   8: invokestatic 407	com/tencent/sharp/jni/TraeUtils:b	()Z
    //   11: ifne +5 -> 16
    //   14: iconst_m1
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 141	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   20: ifne +7 -> 27
    //   23: iload_1
    //   24: ifeq +139 -> 163
    //   27: aload_0
    //   28: getfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   31: ifnonnull +26 -> 57
    //   34: aload_0
    //   35: getfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   38: ifnull +19 -> 57
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   46: ldc 225
    //   48: invokevirtual 231	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   51: checkcast 233	android/media/AudioManager
    //   54: putfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   57: aload_0
    //   58: getfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   61: ifnonnull +5 -> 66
    //   64: iconst_0
    //   65: ireturn
    //   66: aload_0
    //   67: getfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   70: invokevirtual 273	android/media/AudioManager:getMode	()I
    //   73: ifne +24 -> 97
    //   76: aload_0
    //   77: getfield 139	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   80: ldc_w 275
    //   83: invokevirtual 281	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +11 -> 97
    //   89: aload_0
    //   90: iconst_3
    //   91: putfield 96	com/tencent/sharp/jni/AudioDeviceInterface:_audioStreamTypePolicy	I
    //   94: goto +8 -> 102
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 96	com/tencent/sharp/jni/AudioDeviceInterface:_audioStreamTypePolicy	I
    //   102: aload_0
    //   103: iconst_0
    //   104: putfield 141	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   107: aload_0
    //   108: iconst_0
    //   109: putfield 143	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecordChanged	Z
    //   112: goto +51 -> 163
    //   115: iconst_m1
    //   116: ireturn
    //   117: astore_2
    //   118: goto +50 -> 168
    //   121: astore_2
    //   122: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +38 -> 163
    //   128: new 194	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   135: astore_3
    //   136: aload_3
    //   137: ldc_w 409
    //   140: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_3
    //   145: aload_2
    //   146: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   149: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: ldc 175
    //   155: iconst_2
    //   156: aload_3
    //   157: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload_0
    //   164: getfield 96	com/tencent/sharp/jni/AudioDeviceInterface:_audioStreamTypePolicy	I
    //   167: ireturn
    //   168: aload_2
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	AudioDeviceInterface
    //   0	170	1	paramBoolean	boolean
    //   117	1	2	localObject	Object
    //   121	48	2	localException	Exception
    //   135	22	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	14	117	finally
    //   16	23	117	finally
    //   27	57	117	finally
    //   57	64	117	finally
    //   66	94	117	finally
    //   97	102	117	finally
    //   102	112	117	finally
    //   122	163	117	finally
    //   0	14	121	java/lang/Exception
    //   16	23	121	java/lang/Exception
    //   27	57	121	java/lang/Exception
    //   57	64	121	java/lang/Exception
    //   66	94	121	java/lang/Exception
    //   97	102	121	java/lang/Exception
    //   102	112	121	java/lang/Exception
  }
  
  /* Error */
  private int PlayAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 113	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   4: istore 7
    //   6: aload_0
    //   7: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
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
    //   35: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   38: ifeq +61 -> 99
    //   41: new 194	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   48: astore 10
    //   50: aload 10
    //   52: ldc_w 416
    //   55: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 10
    //   61: aload_0
    //   62: getfield 113	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   65: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 10
    //   71: ldc_w 418
    //   74: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 10
    //   80: aload_0
    //   81: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   84: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 175
    //   90: iconst_2
    //   91: aload 10
    //   93: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: iconst_m1
    //   100: ireturn
    //   101: aload_0
    //   102: getfield 103	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   105: invokevirtual 421	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   108: aload_0
    //   109: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   112: astore 10
    //   114: aload 10
    //   116: ifnonnull +13 -> 129
    //   119: aload_0
    //   120: getfield 103	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   123: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   126: bipush 254
    //   128: ireturn
    //   129: aload_0
    //   130: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   133: istore 7
    //   135: iload 7
    //   137: iconst_1
    //   138: if_icmpne +64 -> 202
    //   141: bipush 237
    //   143: invokestatic 430	android/os/Process:setThreadPriority	(I)V
    //   146: goto +51 -> 197
    //   149: astore 10
    //   151: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +43 -> 197
    //   157: new 194	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   164: astore 11
    //   166: aload 11
    //   168: ldc_w 432
    //   171: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 11
    //   177: aload 10
    //   179: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   182: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: ldc 175
    //   188: iconst_2
    //   189: aload 11
    //   191: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_0
    //   198: iconst_0
    //   199: putfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   202: getstatic 434	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   205: ifeq +37 -> 242
    //   208: aload_0
    //   209: getfield 127	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   212: astore 10
    //   214: aload 10
    //   216: ifnull +26 -> 242
    //   219: aload_0
    //   220: getfield 127	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   223: aload_0
    //   224: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   227: iconst_0
    //   228: iconst_0
    //   229: invokevirtual 440	java/io/FileOutputStream:write	([BII)V
    //   232: goto +10 -> 242
    //   235: astore 10
    //   237: aload 10
    //   239: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   242: aload_0
    //   243: getfield 141	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   246: ifne +8 -> 254
    //   249: iconst_0
    //   250: istore_2
    //   251: goto +93 -> 344
    //   254: aload_0
    //   255: getfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   258: ifnonnull +26 -> 284
    //   261: aload_0
    //   262: getfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   265: ifnull +19 -> 284
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   273: ldc 225
    //   275: invokevirtual 231	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   278: checkcast 233	android/media/AudioManager
    //   281: putfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   284: aload_0
    //   285: getfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   288: invokevirtual 273	android/media/AudioManager:getMode	()I
    //   291: ifne +24 -> 315
    //   294: aload_0
    //   295: getfield 139	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   298: ldc_w 275
    //   301: invokevirtual 281	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   304: ifeq +11 -> 315
    //   307: aload_0
    //   308: iconst_3
    //   309: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   312: goto +8 -> 320
    //   315: aload_0
    //   316: iconst_0
    //   317: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   320: aload_0
    //   321: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   324: aload_0
    //   325: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   328: invokevirtual 326	android/media/AudioTrack:getStreamType	()I
    //   331: if_icmpne +1204 -> 1535
    //   334: iconst_0
    //   335: istore_2
    //   336: goto +3 -> 339
    //   339: aload_0
    //   340: iconst_0
    //   341: putfield 141	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   344: aload_0
    //   345: getfield 165	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   348: aload_0
    //   349: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   352: invokevirtual 447	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   355: pop
    //   356: iload_2
    //   357: ifeq +835 -> 1192
    //   360: aload_0
    //   361: getfield 165	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   364: invokevirtual 451	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   367: pop
    //   368: invokestatic 457	android/os/SystemClock:elapsedRealtime	()J
    //   371: lstore 8
    //   373: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   376: ifeq +64 -> 440
    //   379: new 194	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   386: astore 10
    //   388: aload 10
    //   390: ldc_w 459
    //   393: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 10
    //   399: aload_0
    //   400: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   403: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 10
    //   409: ldc_w 461
    //   412: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 10
    //   418: aload_0
    //   419: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   422: invokevirtual 326	android/media/AudioTrack:getStreamType	()I
    //   425: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: ldc 175
    //   431: iconst_2
    //   432: aload 10
    //   434: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: aload_0
    //   441: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   444: invokevirtual 464	android/media/AudioTrack:getPlayState	()I
    //   447: istore_2
    //   448: iconst_0
    //   449: istore 7
    //   451: iload_2
    //   452: iconst_3
    //   453: if_icmpne +158 -> 611
    //   456: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +12 -> 471
    //   462: ldc 175
    //   464: iconst_2
    //   465: ldc_w 466
    //   468: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: aload_0
    //   472: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   475: invokevirtual 469	android/media/AudioTrack:stop	()V
    //   478: aload_0
    //   479: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   482: invokevirtual 472	android/media/AudioTrack:flush	()V
    //   485: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq +45 -> 533
    //   491: new 194	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   498: astore 10
    //   500: aload 10
    //   502: ldc_w 474
    //   505: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 10
    //   511: aload_0
    //   512: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   515: invokevirtual 464	android/media/AudioTrack:getPlayState	()I
    //   518: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: ldc 175
    //   524: iconst_2
    //   525: aload 10
    //   527: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: aload_0
    //   534: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   537: invokevirtual 258	android/media/AudioTrack:release	()V
    //   540: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq +45 -> 588
    //   546: new 194	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   553: astore 10
    //   555: aload 10
    //   557: ldc_w 476
    //   560: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 10
    //   566: aload_0
    //   567: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   570: invokevirtual 464	android/media/AudioTrack:getPlayState	()I
    //   573: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: ldc 175
    //   579: iconst_2
    //   580: aload 10
    //   582: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: aload_0
    //   589: aconst_null
    //   590: putfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   593: goto +18 -> 611
    //   596: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   599: ifeq +12 -> 611
    //   602: ldc 175
    //   604: iconst_2
    //   605: ldc_w 478
    //   608: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: aload_0
    //   612: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   615: aload_0
    //   616: getfield 129	com/tencent/sharp/jni/AudioDeviceInterface:_channelPlayType	I
    //   619: iconst_2
    //   620: invokestatic 247	android/media/AudioTrack:getMinBufferSize	(III)I
    //   623: istore 5
    //   625: iconst_4
    //   626: newarray int
    //   628: astore 10
    //   630: aload 10
    //   632: iconst_0
    //   633: iconst_0
    //   634: iastore
    //   635: aload 10
    //   637: iconst_1
    //   638: iconst_0
    //   639: iastore
    //   640: aload 10
    //   642: iconst_2
    //   643: iconst_3
    //   644: iastore
    //   645: aload 10
    //   647: iconst_3
    //   648: iconst_1
    //   649: iastore
    //   650: aload 10
    //   652: iconst_0
    //   653: aload_0
    //   654: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   657: iastore
    //   658: aload_0
    //   659: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   662: bipush 20
    //   664: imul
    //   665: iconst_1
    //   666: imul
    //   667: iconst_2
    //   668: imul
    //   669: sipush 1000
    //   672: idiv
    //   673: istore 4
    //   675: iload 4
    //   677: istore_2
    //   678: aload_0
    //   679: getfield 129	com/tencent/sharp/jni/AudioDeviceInterface:_channelPlayType	I
    //   682: bipush 12
    //   684: if_icmpne +856 -> 1540
    //   687: iload 4
    //   689: iconst_2
    //   690: imul
    //   691: istore_2
    //   692: goto +848 -> 1540
    //   695: iload_3
    //   696: aload 10
    //   698: arraylength
    //   699: if_icmpge +356 -> 1055
    //   702: aload_0
    //   703: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   706: ifnonnull +349 -> 1055
    //   709: aload_0
    //   710: aload 10
    //   712: iload_3
    //   713: iaload
    //   714: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   717: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   720: ifeq +62 -> 782
    //   723: new 194	java/lang/StringBuilder
    //   726: dup
    //   727: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   730: astore 11
    //   732: aload 11
    //   734: ldc_w 283
    //   737: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload 11
    //   743: iload 5
    //   745: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 11
    //   751: ldc_w 285
    //   754: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: pop
    //   758: aload 11
    //   760: aload_0
    //   761: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   764: invokestatic 288	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   767: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: ldc 175
    //   773: iconst_2
    //   774: aload 11
    //   776: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: iconst_1
    //   783: istore 4
    //   785: iload 4
    //   787: iconst_2
    //   788: if_icmpgt +773 -> 1561
    //   791: iload 5
    //   793: iload 4
    //   795: imul
    //   796: istore 6
    //   798: iload 6
    //   800: iload_2
    //   801: iconst_4
    //   802: imul
    //   803: if_icmpge +12 -> 815
    //   806: iload 4
    //   808: iconst_2
    //   809: if_icmpge +6 -> 815
    //   812: goto +737 -> 1549
    //   815: aload_0
    //   816: new 243	android/media/AudioTrack
    //   819: dup
    //   820: aload_0
    //   821: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   824: aload_0
    //   825: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   828: aload_0
    //   829: getfield 129	com/tencent/sharp/jni/AudioDeviceInterface:_channelPlayType	I
    //   832: iconst_2
    //   833: iload 6
    //   835: iconst_1
    //   836: invokespecial 291	android/media/AudioTrack:<init>	(IIIIII)V
    //   839: putfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   842: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   845: ifeq +42 -> 887
    //   848: new 194	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   855: astore 11
    //   857: aload 11
    //   859: ldc_w 300
    //   862: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: pop
    //   866: aload 11
    //   868: aload_0
    //   869: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   872: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   875: pop
    //   876: ldc 175
    //   878: iconst_2
    //   879: aload 11
    //   881: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   884: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   887: aload_0
    //   888: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   891: invokevirtual 294	android/media/AudioTrack:getState	()I
    //   894: iconst_1
    //   895: if_icmpeq +648 -> 1543
    //   898: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   901: ifeq +59 -> 960
    //   904: new 194	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   911: astore 11
    //   913: aload 11
    //   915: ldc_w 296
    //   918: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 11
    //   924: iload 6
    //   926: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: aload 11
    //   932: ldc_w 298
    //   935: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload 11
    //   941: aload_0
    //   942: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   945: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   948: pop
    //   949: ldc 175
    //   951: iconst_2
    //   952: aload 11
    //   954: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   957: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   960: aload_0
    //   961: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   964: invokevirtual 258	android/media/AudioTrack:release	()V
    //   967: aload_0
    //   968: aconst_null
    //   969: putfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   972: goto +577 -> 1549
    //   975: astore 11
    //   977: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   980: ifeq +53 -> 1033
    //   983: new 194	java/lang/StringBuilder
    //   986: dup
    //   987: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   990: astore 12
    //   992: aload 12
    //   994: aload 11
    //   996: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   999: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload 12
    //   1005: ldc_w 300
    //   1008: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: pop
    //   1012: aload 12
    //   1014: aload_0
    //   1015: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1018: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1021: pop
    //   1022: ldc 175
    //   1024: iconst_2
    //   1025: aload 12
    //   1027: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1033: aload_0
    //   1034: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1037: ifnull +10 -> 1047
    //   1040: aload_0
    //   1041: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1044: invokevirtual 258	android/media/AudioTrack:release	()V
    //   1047: aload_0
    //   1048: aconst_null
    //   1049: putfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1052: goto +497 -> 1549
    //   1055: aload_0
    //   1056: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1059: astore 10
    //   1061: aload 10
    //   1063: ifnull +61 -> 1124
    //   1066: aload_0
    //   1067: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1070: invokevirtual 481	android/media/AudioTrack:play	()V
    //   1073: aload_0
    //   1074: getfield 135	com/tencent/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/sharp/jni/api/impl/TraeAudioSessionApiImpl;
    //   1077: aload_0
    //   1078: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   1081: invokevirtual 310	com/tencent/sharp/jni/api/impl/TraeAudioSessionApiImpl:voiceCallAudioParamChanged	(I)I
    //   1084: pop
    //   1085: aload_0
    //   1086: getfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1089: astore 10
    //   1091: aload_0
    //   1092: getfield 139	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   1095: ldc_w 323
    //   1098: invokevirtual 281	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1101: ifeq +9 -> 1110
    //   1104: bipush 6
    //   1106: istore_2
    //   1107: goto +11 -> 1118
    //   1110: aload_0
    //   1111: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1114: invokevirtual 326	android/media/AudioTrack:getStreamType	()I
    //   1117: istore_2
    //   1118: aload 10
    //   1120: iload_2
    //   1121: invokestatic 330	com/tencent/sharp/jni/TraeUtils:a	(Landroid/media/AudioManager;I)V
    //   1124: iload_1
    //   1125: istore_2
    //   1126: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1129: ifeq +371 -> 1500
    //   1132: new 194	java/lang/StringBuilder
    //   1135: dup
    //   1136: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1139: astore 10
    //   1141: aload 10
    //   1143: ldc_w 483
    //   1146: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: pop
    //   1150: aload 10
    //   1152: invokestatic 457	android/os/SystemClock:elapsedRealtime	()J
    //   1155: lload 8
    //   1157: lsub
    //   1158: invokevirtual 486	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: aload 10
    //   1164: ldc_w 488
    //   1167: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: pop
    //   1171: ldc 175
    //   1173: iconst_2
    //   1174: aload 10
    //   1176: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1179: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1182: iload_1
    //   1183: istore_2
    //   1184: goto +316 -> 1500
    //   1187: astore 10
    //   1189: goto +261 -> 1450
    //   1192: aload_0
    //   1193: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1196: aload_0
    //   1197: getfield 185	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   1200: iconst_0
    //   1201: iload_1
    //   1202: invokevirtual 491	android/media/AudioTrack:write	([BII)I
    //   1205: istore_2
    //   1206: aload_0
    //   1207: getfield 165	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1210: invokevirtual 451	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1213: pop
    //   1214: iload_2
    //   1215: ifge +79 -> 1294
    //   1218: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1221: ifeq +64 -> 1285
    //   1224: new 194	java/lang/StringBuilder
    //   1227: dup
    //   1228: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1231: astore 10
    //   1233: aload 10
    //   1235: ldc_w 493
    //   1238: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: pop
    //   1242: aload 10
    //   1244: iload_2
    //   1245: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1248: pop
    //   1249: aload 10
    //   1251: ldc_w 495
    //   1254: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: pop
    //   1258: aload 10
    //   1260: iload_1
    //   1261: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1264: pop
    //   1265: aload 10
    //   1267: ldc_w 497
    //   1270: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: pop
    //   1274: ldc 175
    //   1276: iconst_2
    //   1277: aload 10
    //   1279: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1282: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1285: aload_0
    //   1286: getfield 103	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1289: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1292: iconst_m1
    //   1293: ireturn
    //   1294: iload_2
    //   1295: iload_1
    //   1296: if_icmpeq +70 -> 1366
    //   1299: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1302: ifeq +64 -> 1366
    //   1305: new 194	java/lang/StringBuilder
    //   1308: dup
    //   1309: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1312: astore 10
    //   1314: aload 10
    //   1316: ldc_w 499
    //   1319: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: pop
    //   1323: aload 10
    //   1325: iload_2
    //   1326: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1329: pop
    //   1330: aload 10
    //   1332: ldc_w 495
    //   1335: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: aload 10
    //   1341: iload_1
    //   1342: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1345: pop
    //   1346: aload 10
    //   1348: ldc_w 497
    //   1351: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: pop
    //   1355: ldc 175
    //   1357: iconst_2
    //   1358: aload 10
    //   1360: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1363: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1366: aload_0
    //   1367: aload_0
    //   1368: getfield 117	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1371: iload_2
    //   1372: iconst_1
    //   1373: ishr
    //   1374: iadd
    //   1375: putfield 117	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1378: aload_0
    //   1379: getfield 76	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1382: invokevirtual 313	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1385: istore_1
    //   1386: iload_1
    //   1387: aload_0
    //   1388: getfield 119	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1391: if_icmpge +8 -> 1399
    //   1394: aload_0
    //   1395: iconst_0
    //   1396: putfield 119	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1399: aload_0
    //   1400: aload_0
    //   1401: getfield 117	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1404: iload_1
    //   1405: aload_0
    //   1406: getfield 119	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1409: isub
    //   1410: isub
    //   1411: putfield 117	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1414: aload_0
    //   1415: iload_1
    //   1416: putfield 119	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1419: aload_0
    //   1420: getfield 111	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   1423: ifne +8 -> 1431
    //   1426: aload_0
    //   1427: getfield 117	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1430: istore_1
    //   1431: goto +69 -> 1500
    //   1434: astore 10
    //   1436: iload_2
    //   1437: istore_1
    //   1438: goto +12 -> 1450
    //   1441: astore 10
    //   1443: goto +66 -> 1509
    //   1446: astore 10
    //   1448: iconst_0
    //   1449: istore_1
    //   1450: iload_1
    //   1451: istore_2
    //   1452: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1455: ifeq +45 -> 1500
    //   1458: new 194	java/lang/StringBuilder
    //   1461: dup
    //   1462: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1465: astore 11
    //   1467: aload 11
    //   1469: ldc_w 409
    //   1472: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: pop
    //   1476: aload 11
    //   1478: aload 10
    //   1480: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1483: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1486: pop
    //   1487: ldc 175
    //   1489: iconst_2
    //   1490: aload 11
    //   1492: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1495: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1498: iload_1
    //   1499: istore_2
    //   1500: aload_0
    //   1501: getfield 103	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1504: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1507: iload_2
    //   1508: ireturn
    //   1509: aload_0
    //   1510: getfield 103	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1513: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1516: goto +6 -> 1522
    //   1519: aload 10
    //   1521: athrow
    //   1522: goto -3 -> 1519
    //   1525: astore 10
    //   1527: goto -931 -> 596
    //   1530: astore 10
    //   1532: goto -408 -> 1124
    //   1535: iconst_1
    //   1536: istore_2
    //   1537: goto -1198 -> 339
    //   1540: goto -845 -> 695
    //   1543: iconst_0
    //   1544: istore 7
    //   1546: goto +15 -> 1561
    //   1549: iload 4
    //   1551: iconst_1
    //   1552: iadd
    //   1553: istore 4
    //   1555: iconst_0
    //   1556: istore 7
    //   1558: goto -773 -> 785
    //   1561: iload_3
    //   1562: iconst_1
    //   1563: iadd
    //   1564: istore_3
    //   1565: goto -870 -> 695
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1568	0	this	AudioDeviceInterface
    //   0	1568	1	paramInt	int
    //   20	1517	2	i	int
    //   13	1552	3	j	int
    //   673	881	4	k	int
    //   623	173	5	m	int
    //   796	129	6	n	int
    //   4	1553	7	bool	boolean
    //   371	785	8	l	long
    //   10	105	10	localObject1	Object
    //   149	29	10	localException1	Exception
    //   212	3	10	localFileOutputStream	FileOutputStream
    //   235	3	10	localIOException	java.io.IOException
    //   386	789	10	localObject2	Object
    //   1187	1	10	localException2	Exception
    //   1231	128	10	localStringBuilder1	StringBuilder
    //   1434	1	10	localException3	Exception
    //   1441	1	10	localObject3	Object
    //   1446	74	10	localException4	Exception
    //   1525	1	10	localIllegalStateException	IllegalStateException
    //   1530	1	10	localException5	Exception
    //   164	789	11	localStringBuilder2	StringBuilder
    //   975	20	11	localException6	Exception
    //   1465	26	11	localStringBuilder3	StringBuilder
    //   990	36	12	localStringBuilder4	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   141	146	149	java/lang/Exception
    //   219	232	235	java/io/IOException
    //   815	842	975	java/lang/Exception
    //   360	440	1187	java/lang/Exception
    //   440	448	1187	java/lang/Exception
    //   456	471	1187	java/lang/Exception
    //   471	533	1187	java/lang/Exception
    //   533	588	1187	java/lang/Exception
    //   588	593	1187	java/lang/Exception
    //   596	611	1187	java/lang/Exception
    //   611	630	1187	java/lang/Exception
    //   650	675	1187	java/lang/Exception
    //   678	687	1187	java/lang/Exception
    //   695	782	1187	java/lang/Exception
    //   842	887	1187	java/lang/Exception
    //   887	960	1187	java/lang/Exception
    //   960	972	1187	java/lang/Exception
    //   977	1033	1187	java/lang/Exception
    //   1033	1047	1187	java/lang/Exception
    //   1047	1052	1187	java/lang/Exception
    //   1055	1061	1187	java/lang/Exception
    //   1126	1182	1187	java/lang/Exception
    //   1206	1214	1434	java/lang/Exception
    //   1218	1285	1434	java/lang/Exception
    //   1299	1366	1434	java/lang/Exception
    //   1366	1399	1434	java/lang/Exception
    //   1399	1431	1434	java/lang/Exception
    //   108	114	1441	finally
    //   129	135	1441	finally
    //   141	146	1441	finally
    //   151	197	1441	finally
    //   197	202	1441	finally
    //   202	214	1441	finally
    //   219	232	1441	finally
    //   237	242	1441	finally
    //   242	249	1441	finally
    //   254	284	1441	finally
    //   284	312	1441	finally
    //   315	320	1441	finally
    //   320	334	1441	finally
    //   339	344	1441	finally
    //   344	356	1441	finally
    //   360	440	1441	finally
    //   440	448	1441	finally
    //   456	471	1441	finally
    //   471	533	1441	finally
    //   533	588	1441	finally
    //   588	593	1441	finally
    //   596	611	1441	finally
    //   611	630	1441	finally
    //   650	675	1441	finally
    //   678	687	1441	finally
    //   695	782	1441	finally
    //   815	842	1441	finally
    //   842	887	1441	finally
    //   887	960	1441	finally
    //   960	972	1441	finally
    //   977	1033	1441	finally
    //   1033	1047	1441	finally
    //   1047	1052	1441	finally
    //   1055	1061	1441	finally
    //   1066	1104	1441	finally
    //   1110	1118	1441	finally
    //   1118	1124	1441	finally
    //   1126	1182	1441	finally
    //   1192	1206	1441	finally
    //   1206	1214	1441	finally
    //   1218	1285	1441	finally
    //   1299	1366	1441	finally
    //   1366	1399	1441	finally
    //   1399	1431	1441	finally
    //   1452	1498	1441	finally
    //   108	114	1446	java/lang/Exception
    //   129	135	1446	java/lang/Exception
    //   151	197	1446	java/lang/Exception
    //   197	202	1446	java/lang/Exception
    //   202	214	1446	java/lang/Exception
    //   219	232	1446	java/lang/Exception
    //   237	242	1446	java/lang/Exception
    //   242	249	1446	java/lang/Exception
    //   254	284	1446	java/lang/Exception
    //   284	312	1446	java/lang/Exception
    //   315	320	1446	java/lang/Exception
    //   320	334	1446	java/lang/Exception
    //   339	344	1446	java/lang/Exception
    //   344	356	1446	java/lang/Exception
    //   1192	1206	1446	java/lang/Exception
    //   456	471	1525	java/lang/IllegalStateException
    //   471	533	1525	java/lang/IllegalStateException
    //   533	588	1525	java/lang/IllegalStateException
    //   588	593	1525	java/lang/IllegalStateException
    //   1066	1104	1530	java/lang/Exception
    //   1110	1118	1530	java/lang/Exception
    //   1118	1124	1530	java/lang/Exception
  }
  
  /* Error */
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 111	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   4: ifne +50 -> 54
    //   7: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +42 -> 52
    //   13: new 194	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   20: astore 7
    //   22: aload 7
    //   24: ldc_w 502
    //   27: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 7
    //   33: aload_0
    //   34: getfield 111	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   37: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 175
    //   43: iconst_2
    //   44: aload 7
    //   46: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: iconst_m1
    //   53: ireturn
    //   54: aload_0
    //   55: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   58: invokevirtual 421	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   61: aload_0
    //   62: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   65: astore 7
    //   67: aload 7
    //   69: ifnonnull +13 -> 82
    //   72: aload_0
    //   73: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   76: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   79: bipush 254
    //   81: ireturn
    //   82: aload_0
    //   83: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   86: istore 6
    //   88: iload 6
    //   90: iconst_1
    //   91: if_icmpne +72 -> 163
    //   94: bipush 237
    //   96: invokestatic 430	android/os/Process:setThreadPriority	(I)V
    //   99: goto +51 -> 150
    //   102: astore 7
    //   104: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +43 -> 150
    //   110: new 194	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   117: astore 8
    //   119: aload 8
    //   121: ldc_w 504
    //   124: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 8
    //   130: aload 7
    //   132: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: ldc 175
    //   141: iconst_2
    //   142: aload 8
    //   144: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: iconst_0
    //   152: putfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   155: goto +8 -> 163
    //   158: astore 7
    //   160: goto +997 -> 1157
    //   163: aload_0
    //   164: getfield 143	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecordChanged	Z
    //   167: ifne +8 -> 175
    //   170: iconst_0
    //   171: istore_2
    //   172: goto +126 -> 298
    //   175: aload_0
    //   176: getfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   179: astore 7
    //   181: aload 7
    //   183: ifnonnull +26 -> 209
    //   186: aload_0
    //   187: getfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   190: ifnull +19 -> 209
    //   193: aload_0
    //   194: aload_0
    //   195: getfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   198: ldc 225
    //   200: invokevirtual 231	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   203: checkcast 233	android/media/AudioManager
    //   206: putfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   209: aload_0
    //   210: getfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   213: astore 7
    //   215: aload 7
    //   217: ifnonnull +12 -> 229
    //   220: aload_0
    //   221: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   224: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   227: iconst_m1
    //   228: ireturn
    //   229: aload_0
    //   230: getfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   233: invokevirtual 273	android/media/AudioManager:getMode	()I
    //   236: istore_2
    //   237: iload_2
    //   238: ifne +27 -> 265
    //   241: aload_0
    //   242: getfield 139	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   245: ldc_w 275
    //   248: invokevirtual 281	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifeq +14 -> 265
    //   254: aload_0
    //   255: iconst_0
    //   256: invokestatic 358	com/tencent/sharp/jni/TraeUtils:a	(I)I
    //   259: putfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   262: goto +12 -> 274
    //   265: aload_0
    //   266: bipush 7
    //   268: invokestatic 358	com/tencent/sharp/jni/TraeUtils:a	(I)I
    //   271: putfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   274: aload_0
    //   275: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   278: aload_0
    //   279: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   282: invokevirtual 507	android/media/AudioRecord:getAudioSource	()I
    //   285: if_icmpne +949 -> 1234
    //   288: iconst_0
    //   289: istore_2
    //   290: goto +3 -> 293
    //   293: aload_0
    //   294: iconst_0
    //   295: putfield 143	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecordChanged	Z
    //   298: iload_2
    //   299: ifeq +617 -> 916
    //   302: aload_0
    //   303: getfield 167	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   306: invokevirtual 451	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   309: pop
    //   310: aload_0
    //   311: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   314: invokevirtual 510	android/media/AudioRecord:getRecordingState	()I
    //   317: istore_1
    //   318: iload_1
    //   319: iconst_3
    //   320: if_icmpne +86 -> 406
    //   323: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +45 -> 371
    //   329: new 194	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   336: astore 7
    //   338: aload 7
    //   340: ldc_w 512
    //   343: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 7
    //   349: aload_0
    //   350: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   353: invokevirtual 510	android/media/AudioRecord:getRecordingState	()I
    //   356: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: ldc 175
    //   362: iconst_2
    //   363: aload 7
    //   365: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: aload_0
    //   372: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   375: invokevirtual 513	android/media/AudioRecord:stop	()V
    //   378: goto +28 -> 406
    //   381: astore 7
    //   383: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +12 -> 398
    //   389: ldc 175
    //   391: iconst_2
    //   392: ldc_w 515
    //   395: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload 7
    //   400: invokevirtual 516	java/lang/IllegalStateException:printStackTrace	()V
    //   403: goto -183 -> 220
    //   406: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   409: ifeq +45 -> 454
    //   412: new 194	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   419: astore 7
    //   421: aload 7
    //   423: ldc_w 518
    //   426: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload 7
    //   432: aload_0
    //   433: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   436: invokevirtual 510	android/media/AudioRecord:getRecordingState	()I
    //   439: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: ldc 175
    //   445: iconst_2
    //   446: aload 7
    //   448: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: aload_0
    //   455: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   458: invokevirtual 356	android/media/AudioRecord:release	()V
    //   461: aload_0
    //   462: aconst_null
    //   463: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   466: aload_0
    //   467: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   470: aload_0
    //   471: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   474: iconst_2
    //   475: invokestatic 341	android/media/AudioRecord:getMinBufferSize	(III)I
    //   478: istore 4
    //   480: iconst_4
    //   481: newarray int
    //   483: astore 7
    //   485: aload 7
    //   487: iconst_0
    //   488: iconst_0
    //   489: iastore
    //   490: aload 7
    //   492: iconst_1
    //   493: iconst_1
    //   494: iastore
    //   495: aload 7
    //   497: iconst_2
    //   498: iconst_5
    //   499: iastore
    //   500: aload 7
    //   502: iconst_3
    //   503: iconst_0
    //   504: iastore
    //   505: aload 7
    //   507: iconst_0
    //   508: aload_0
    //   509: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   512: invokestatic 358	com/tencent/sharp/jni/TraeUtils:a	(I)I
    //   515: iastore
    //   516: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +42 -> 561
    //   522: new 194	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   529: astore 8
    //   531: aload 8
    //   533: ldc_w 520
    //   536: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload 8
    //   542: aload 7
    //   544: iconst_0
    //   545: iaload
    //   546: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: ldc 175
    //   552: iconst_2
    //   553: aload 8
    //   555: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: aload_0
    //   562: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   565: bipush 20
    //   567: imul
    //   568: iconst_1
    //   569: imul
    //   570: iconst_2
    //   571: imul
    //   572: sipush 1000
    //   575: idiv
    //   576: istore_2
    //   577: iload_2
    //   578: istore_1
    //   579: aload_0
    //   580: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   583: bipush 12
    //   585: if_icmpne +654 -> 1239
    //   588: iload_2
    //   589: iconst_2
    //   590: imul
    //   591: istore_1
    //   592: goto +647 -> 1239
    //   595: iload_2
    //   596: aload 7
    //   598: arraylength
    //   599: if_icmpge +260 -> 859
    //   602: aload_0
    //   603: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   606: ifnonnull +253 -> 859
    //   609: aload_0
    //   610: aload 7
    //   612: iload_2
    //   613: iaload
    //   614: putfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   617: iconst_1
    //   618: istore_3
    //   619: iload_3
    //   620: iconst_2
    //   621: if_icmpgt +630 -> 1251
    //   624: iload 4
    //   626: iload_3
    //   627: imul
    //   628: istore 5
    //   630: iload 5
    //   632: iload_1
    //   633: iconst_4
    //   634: imul
    //   635: if_icmpge +11 -> 646
    //   638: iload_3
    //   639: iconst_2
    //   640: if_icmpge +6 -> 646
    //   643: goto +601 -> 1244
    //   646: aload_0
    //   647: new 340	android/media/AudioRecord
    //   650: dup
    //   651: aload_0
    //   652: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   655: aload_0
    //   656: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   659: aload_0
    //   660: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   663: iconst_2
    //   664: iload 5
    //   666: invokespecial 363	android/media/AudioRecord:<init>	(IIIII)V
    //   669: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   672: aload_0
    //   673: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   676: invokevirtual 364	android/media/AudioRecord:getState	()I
    //   679: iconst_1
    //   680: if_icmpeq +571 -> 1251
    //   683: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   686: ifeq +78 -> 764
    //   689: new 194	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   696: astore 8
    //   698: aload 8
    //   700: ldc_w 366
    //   703: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload 8
    //   709: iload 5
    //   711: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload 8
    //   717: ldc_w 298
    //   720: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload 8
    //   726: aload_0
    //   727: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   730: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: aload 8
    //   736: ldc_w 368
    //   739: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: aload 8
    //   745: aload_0
    //   746: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   749: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   752: pop
    //   753: ldc 175
    //   755: iconst_2
    //   756: aload 8
    //   758: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   764: aload_0
    //   765: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   768: invokevirtual 356	android/media/AudioRecord:release	()V
    //   771: aload_0
    //   772: aconst_null
    //   773: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   776: goto +468 -> 1244
    //   779: astore 8
    //   781: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   784: ifeq +53 -> 837
    //   787: new 194	java/lang/StringBuilder
    //   790: dup
    //   791: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   794: astore 9
    //   796: aload 9
    //   798: aload 8
    //   800: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   803: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload 9
    //   809: ldc_w 370
    //   812: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload 9
    //   818: aload_0
    //   819: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   822: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: ldc 175
    //   828: iconst_2
    //   829: aload 9
    //   831: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 183	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: aload_0
    //   838: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   841: ifnull +10 -> 851
    //   844: aload_0
    //   845: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   848: invokevirtual 356	android/media/AudioRecord:release	()V
    //   851: aload_0
    //   852: aconst_null
    //   853: putfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   856: goto +388 -> 1244
    //   859: aload_0
    //   860: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   863: astore 7
    //   865: aload 7
    //   867: ifnull +44 -> 911
    //   870: aload_0
    //   871: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   874: invokevirtual 523	android/media/AudioRecord:startRecording	()V
    //   877: goto +34 -> 911
    //   880: astore 7
    //   882: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   885: ifeq +12 -> 897
    //   888: ldc 175
    //   890: iconst_2
    //   891: ldc_w 525
    //   894: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   897: aload 7
    //   899: invokevirtual 516	java/lang/IllegalStateException:printStackTrace	()V
    //   902: aload_0
    //   903: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   906: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   909: iconst_m1
    //   910: ireturn
    //   911: iconst_0
    //   912: istore_2
    //   913: goto +296 -> 1209
    //   916: aload_0
    //   917: getfield 167	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   920: invokevirtual 451	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   923: pop
    //   924: aload_0
    //   925: getfield 78	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   928: aload_0
    //   929: getfield 187	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   932: iconst_0
    //   933: iload_1
    //   934: invokevirtual 528	android/media/AudioRecord:read	([BII)I
    //   937: istore_3
    //   938: iload_3
    //   939: ifge +73 -> 1012
    //   942: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   945: ifeq -43 -> 902
    //   948: new 194	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   955: astore 7
    //   957: aload 7
    //   959: ldc_w 530
    //   962: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: pop
    //   966: aload 7
    //   968: iload_3
    //   969: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   972: pop
    //   973: aload 7
    //   975: ldc_w 495
    //   978: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: aload 7
    //   984: iload_1
    //   985: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   988: pop
    //   989: aload 7
    //   991: ldc_w 497
    //   994: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: pop
    //   998: ldc 175
    //   1000: iconst_2
    //   1001: aload 7
    //   1003: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1006: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1009: goto -107 -> 902
    //   1012: aload_0
    //   1013: getfield 167	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   1016: aload_0
    //   1017: getfield 187	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   1020: iconst_0
    //   1021: iload_3
    //   1022: invokevirtual 534	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1025: pop
    //   1026: getstatic 434	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   1029: ifeq +37 -> 1066
    //   1032: aload_0
    //   1033: getfield 125	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   1036: astore 7
    //   1038: aload 7
    //   1040: ifnull +26 -> 1066
    //   1043: aload_0
    //   1044: getfield 125	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   1047: aload_0
    //   1048: getfield 187	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   1051: iconst_0
    //   1052: iload_3
    //   1053: invokevirtual 440	java/io/FileOutputStream:write	([BII)V
    //   1056: goto +10 -> 1066
    //   1059: astore 7
    //   1061: aload 7
    //   1063: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   1066: iload_3
    //   1067: istore_2
    //   1068: iload_3
    //   1069: iload_1
    //   1070: if_icmpeq +139 -> 1209
    //   1073: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1076: ifeq -174 -> 902
    //   1079: new 194	java/lang/StringBuilder
    //   1082: dup
    //   1083: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1086: astore 7
    //   1088: aload 7
    //   1090: ldc_w 536
    //   1093: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: pop
    //   1097: aload 7
    //   1099: iload_3
    //   1100: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1103: pop
    //   1104: aload 7
    //   1106: ldc_w 495
    //   1109: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: pop
    //   1113: aload 7
    //   1115: iload_1
    //   1116: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1119: pop
    //   1120: aload 7
    //   1122: ldc_w 497
    //   1125: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: pop
    //   1129: ldc 175
    //   1131: iconst_2
    //   1132: aload 7
    //   1134: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1137: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1140: goto -238 -> 902
    //   1143: astore 7
    //   1145: iload_3
    //   1146: istore_1
    //   1147: goto +12 -> 1159
    //   1150: astore 7
    //   1152: goto +66 -> 1218
    //   1155: astore 7
    //   1157: iconst_0
    //   1158: istore_1
    //   1159: iload_1
    //   1160: istore_2
    //   1161: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1164: ifeq +45 -> 1209
    //   1167: new 194	java/lang/StringBuilder
    //   1170: dup
    //   1171: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1174: astore 8
    //   1176: aload 8
    //   1178: ldc_w 538
    //   1181: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: pop
    //   1185: aload 8
    //   1187: aload 7
    //   1189: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1192: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: pop
    //   1196: ldc 175
    //   1198: iconst_2
    //   1199: aload 8
    //   1201: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1204: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1207: iload_1
    //   1208: istore_2
    //   1209: aload_0
    //   1210: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1213: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1216: iload_2
    //   1217: ireturn
    //   1218: aload_0
    //   1219: getfield 105	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1222: invokevirtual 424	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1225: goto +6 -> 1231
    //   1228: aload 7
    //   1230: athrow
    //   1231: goto -3 -> 1228
    //   1234: iconst_1
    //   1235: istore_2
    //   1236: goto -943 -> 293
    //   1239: iconst_0
    //   1240: istore_2
    //   1241: goto -646 -> 595
    //   1244: iload_3
    //   1245: iconst_1
    //   1246: iadd
    //   1247: istore_3
    //   1248: goto -629 -> 619
    //   1251: iload_2
    //   1252: iconst_1
    //   1253: iadd
    //   1254: istore_2
    //   1255: goto -660 -> 595
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1258	0	this	AudioDeviceInterface
    //   0	1258	1	paramInt	int
    //   171	1084	2	i	int
    //   618	630	3	j	int
    //   478	150	4	k	int
    //   628	82	5	m	int
    //   86	6	6	bool	boolean
    //   20	48	7	localObject1	Object
    //   102	29	7	localException1	Exception
    //   158	1	7	localException2	Exception
    //   179	185	7	localObject2	Object
    //   381	18	7	localIllegalStateException1	IllegalStateException
    //   419	447	7	localObject3	Object
    //   880	18	7	localIllegalStateException2	IllegalStateException
    //   955	84	7	localObject4	Object
    //   1059	3	7	localIOException	java.io.IOException
    //   1086	47	7	localStringBuilder1	StringBuilder
    //   1143	1	7	localException3	Exception
    //   1150	1	7	localObject5	Object
    //   1155	74	7	localException4	Exception
    //   117	640	8	localStringBuilder2	StringBuilder
    //   779	20	8	localException5	Exception
    //   1174	26	8	localStringBuilder3	StringBuilder
    //   794	36	9	localStringBuilder4	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   94	99	102	java/lang/Exception
    //   104	150	158	java/lang/Exception
    //   150	155	158	java/lang/Exception
    //   186	209	158	java/lang/Exception
    //   241	262	158	java/lang/Exception
    //   302	318	158	java/lang/Exception
    //   323	371	158	java/lang/Exception
    //   371	378	158	java/lang/Exception
    //   383	398	158	java/lang/Exception
    //   398	403	158	java/lang/Exception
    //   406	454	158	java/lang/Exception
    //   454	485	158	java/lang/Exception
    //   505	561	158	java/lang/Exception
    //   561	577	158	java/lang/Exception
    //   579	588	158	java/lang/Exception
    //   595	617	158	java/lang/Exception
    //   672	764	158	java/lang/Exception
    //   764	776	158	java/lang/Exception
    //   781	837	158	java/lang/Exception
    //   837	851	158	java/lang/Exception
    //   851	856	158	java/lang/Exception
    //   859	865	158	java/lang/Exception
    //   870	877	158	java/lang/Exception
    //   882	897	158	java/lang/Exception
    //   897	902	158	java/lang/Exception
    //   323	371	381	java/lang/IllegalStateException
    //   371	378	381	java/lang/IllegalStateException
    //   646	672	779	java/lang/Exception
    //   870	877	880	java/lang/IllegalStateException
    //   1043	1056	1059	java/io/IOException
    //   942	1009	1143	java/lang/Exception
    //   1012	1038	1143	java/lang/Exception
    //   1043	1056	1143	java/lang/Exception
    //   1061	1066	1143	java/lang/Exception
    //   1073	1140	1143	java/lang/Exception
    //   61	67	1150	finally
    //   82	88	1150	finally
    //   94	99	1150	finally
    //   104	150	1150	finally
    //   150	155	1150	finally
    //   163	170	1150	finally
    //   175	181	1150	finally
    //   186	209	1150	finally
    //   209	215	1150	finally
    //   229	237	1150	finally
    //   241	262	1150	finally
    //   265	274	1150	finally
    //   274	288	1150	finally
    //   293	298	1150	finally
    //   302	318	1150	finally
    //   323	371	1150	finally
    //   371	378	1150	finally
    //   383	398	1150	finally
    //   398	403	1150	finally
    //   406	454	1150	finally
    //   454	485	1150	finally
    //   505	561	1150	finally
    //   561	577	1150	finally
    //   579	588	1150	finally
    //   595	617	1150	finally
    //   646	672	1150	finally
    //   672	764	1150	finally
    //   764	776	1150	finally
    //   781	837	1150	finally
    //   837	851	1150	finally
    //   851	856	1150	finally
    //   859	865	1150	finally
    //   870	877	1150	finally
    //   882	897	1150	finally
    //   897	902	1150	finally
    //   916	938	1150	finally
    //   942	1009	1150	finally
    //   1012	1038	1150	finally
    //   1043	1056	1150	finally
    //   1061	1066	1150	finally
    //   1073	1140	1150	finally
    //   1161	1207	1150	finally
    //   61	67	1155	java/lang/Exception
    //   82	88	1155	java/lang/Exception
    //   163	170	1155	java/lang/Exception
    //   175	181	1155	java/lang/Exception
    //   209	215	1155	java/lang/Exception
    //   229	237	1155	java/lang/Exception
    //   265	274	1155	java/lang/Exception
    //   274	288	1155	java/lang/Exception
    //   293	298	1155	java/lang/Exception
    //   916	938	1155	java/lang/Exception
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
        QLog.e("TRAE", 2, "StartPlayback _isPlaying");
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
        QLog.e("TRAE", 2, ((StringBuilder)localObject).toString());
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
        try
        {
          this._play_out = new FileOutputStream(this._play_dump);
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
        }
      }
      this._isPlaying = true;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "StartPlayback ok");
      }
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "StartPlayback fail");
      }
      localIllegalStateException.printStackTrace();
    }
    return -1;
  }
  
  private int StartRecording()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "StartRecording entry");
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
        QLog.e("TRAE", 2, ((StringBuilder)localObject).toString());
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
        QLog.e("TRAE", 2, ((StringBuilder)localObject).toString());
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
        try
        {
          this._rec_out = new FileOutputStream(this._rec_dump);
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
        }
      }
      this._isRecording = true;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "StartRecording ok");
      }
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "StartRecording fail");
      }
      localIllegalStateException.printStackTrace();
    }
    return -1;
  }
  
  private int StopPlayback()
  {
    StringBuilder localStringBuilder1;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("StopPlayback entry _isPlaying:");
      localStringBuilder1.append(this._isPlaying);
      QLog.w("TRAE", 2, localStringBuilder1.toString());
    }
    if (this._audioTrack == null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("StopPlayback _isPlaying:");
        localStringBuilder1.append(this._isPlaying);
        localStringBuilder1.append(" ");
        localStringBuilder1.append(this._audioTrack);
        QLog.e("TRAE", 2, localStringBuilder1.toString());
      }
      return -1;
    }
    this._playLock.lock();
    try
    {
      int i = this._audioTrack.getPlayState();
      if (i == 3) {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopPlayback stoping...");
          }
          this._audioTrack.stop();
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("StopPlayback flushing... state:");
            localStringBuilder1.append(this._audioTrack.getPlayState());
            QLog.w("TRAE", 2, localStringBuilder1.toString());
          }
          this._audioTrack.flush();
        }
        catch (IllegalStateException localIllegalStateException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "StopPlayback err");
          }
          localIllegalStateException.printStackTrace();
          return -1;
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("StopPlayback releaseing... state:");
        localStringBuilder2.append(this._audioTrack.getPlayState());
        QLog.w("TRAE", 2, localStringBuilder2.toString());
      }
      this._audioTrack.release();
      this._audioTrack = null;
      this._isPlaying = false;
      this._playLock.unlock();
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "StopPlayback exit ok");
      }
      return 0;
    }
    finally
    {
      this._playLock.unlock();
    }
  }
  
  private int StopRecording()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "StopRecording entry");
    }
    StringBuilder localStringBuilder1;
    if (this._audioRecord == null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("UnintRecord:");
        localStringBuilder1.append(this._audioRecord);
        QLog.e("TRAE", 2, localStringBuilder1.toString());
      }
      return -1;
    }
    this._recLock.lock();
    try
    {
      int i = this._audioRecord.getRecordingState();
      if (i == 3) {
        try
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("StopRecording stop... state:");
            localStringBuilder1.append(this._audioRecord.getRecordingState());
            QLog.w("TRAE", 2, localStringBuilder1.toString());
          }
          this._audioRecord.stop();
        }
        catch (IllegalStateException localIllegalStateException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "StopRecording  err");
          }
          localIllegalStateException.printStackTrace();
          return -1;
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("StopRecording releaseing... state:");
        localStringBuilder2.append(this._audioRecord.getRecordingState());
        QLog.w("TRAE", 2, localStringBuilder2.toString());
      }
      this._audioRecord.release();
      this._audioRecord = null;
      this._isRecording = false;
      this._recLock.unlock();
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "StopRecording exit ok");
      }
      return 0;
    }
    finally
    {
      this._recLock.unlock();
    }
  }
  
  @TargetApi(16)
  private int getAudioSessionId(AudioRecord paramAudioRecord)
  {
    return 0;
  }
  
  private String getDumpFilePath(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("manufacture:");
      localStringBuilder.append(Build.MANUFACTURER);
      QLog.w("TRAE", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MODEL:");
      localStringBuilder.append(Build.MODEL);
      QLog.w("TRAE", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/MF-");
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("-M-");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("-as-");
    localStringBuilder.append(TraeUtils.a(this._audioSourcePolicy));
    localStringBuilder.append("-st-");
    localStringBuilder.append(this._streamType);
    localStringBuilder.append("-m-");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dump:");
      localStringBuilder.append(paramString);
      QLog.w("TRAE", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dump replace:");
      localStringBuilder.append(paramString.replace(" ", "_"));
      QLog.w("TRAE", 2, localStringBuilder.toString());
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
        QLog.w("TRAE", 2, localStringBuilder.toString());
      }
      if ((Build.VERSION.SDK_INT < 17) && (QLog.isColorLevel())) {
        QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
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
      QLog.e("TRAE", 2, ((StringBuilder)localObject).toString());
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
        QLog.w("TRAE", 2, localStringBuilder.toString());
      }
      if (Build.VERSION.SDK_INT < 17)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
        }
        return 0;
      }
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate not support right now!");
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
      QLog.e("TRAE", 2, ((StringBuilder)localObject).toString());
    }
    return 0;
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
    if (this._context != null)
    {
      TraeAudioManager.a().a(this._context);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession startService");
      }
    }
  }
  
  private void onOutputChanage(String paramString)
  {
    setAudioRouteSwitchState(paramString);
    this._connectedDev = paramString;
    Object localObject;
    if (this._audioManager == null)
    {
      localObject = this._context;
      if (localObject != null) {
        try
        {
          this._audioManager = ((AudioManager)((Context)localObject).getSystemService("audio"));
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, paramString.getMessage());
          }
          return;
        }
      }
    }
    if ((this._audioManager != null) && (this._audioTrack != null))
    {
      int i;
      if (this._connectedDev.equals("DEVICE_BLUETOOTH_HEADSET")) {
        i = 6;
      } else {
        i = this._audioTrack.getStreamType();
      }
      if ((this._IsBluetoothStreamVolume) && (i != 6))
      {
        TraeUtils.a(this._audioManager, i);
        this._IsBluetoothStreamVolume = false;
      }
      else if ((!this._IsBluetoothStreamVolume) && (i == 6))
      {
        TraeUtils.a(this._audioManager, i);
        this._IsBluetoothStreamVolume = true;
      }
    }
    if (this._modePolicy != -1)
    {
      if (!TraeUtils.b()) {
        return;
      }
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
        QLog.w("TRAE", 2, localStringBuilder.toString());
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
          QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
        }
        if ((this._connectedDev.equals("DEVICE_SPEAKERPHONE")) && (this._audioManager != null)) {
          this._audioManager.setMode(0);
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, paramString.getMessage());
        }
      }
      this._audioRouteChanged = true;
      this._audioRecordChanged = true;
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
    if (paramString.equals("DEVICE_WIRED_HEADSET"))
    {
      this.switchState = 3;
      return;
    }
    if (paramString.equals("DEVICE_BLUETOOTH_HEADSET"))
    {
      this.switchState = 4;
      return;
    }
    this.switchState = 0;
  }
  
  private int sigHowling(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("java onHowling flg:");
      localStringBuilder.append(paramInt);
      QLog.w("TRAE", 2, localStringBuilder.toString());
    }
    if (this._as == null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onHowling too early");
        localStringBuilder.append(paramInt);
        QLog.w("TRAE", 2, localStringBuilder.toString());
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
      TraeAudioManager.a().b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "uninitTRAEAudioManager , context null");
    }
  }
  
  public int call_postprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    TraeAudioSessionApiImpl localTraeAudioSessionApiImpl = this._as;
    if (localTraeAudioSessionApiImpl != null)
    {
      localTraeAudioSessionApiImpl.voiceCallPostProcess();
      this._as.release();
      this._as = null;
    }
    LogTraceExit();
    return 0;
  }
  
  public int call_preprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    this._streamType = TraeUtils.b(this._audioStreamTypePolicy);
    if (this._as == null)
    {
      this._as = new TraeAudioSessionApiImpl();
      this._as.init(new AudioDeviceInterface.1(this));
    }
    this._preDone = false;
    if (this._as != null) {
      this._prelock.lock();
    }
    int i;
    label217:
    for (;;)
    {
      try
      {
        this._as.getConnectedDevice(-1030L);
        this._as.voiceCallPreProcess(this._modePolicy, this._streamType);
        i = 7;
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
            break label217;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("call_preprocess waiting...  as:");
          localStringBuilder.append(this._as);
          QLog.e("TRAE", 2, localStringBuilder.toString());
          break label217;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "call_preprocess done!");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
        i -= 1;
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
      QLog.w("TRAE", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.sharp.jni.AudioDeviceInterface
 * JD-Core Version:    0.7.0.1
 */