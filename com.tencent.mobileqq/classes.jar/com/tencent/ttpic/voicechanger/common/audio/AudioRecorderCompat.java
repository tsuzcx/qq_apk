package com.tencent.ttpic.voicechanger.common.audio;

import android.content.Context;
import android.media.AudioRecord;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.logic.watermark.FFTData;

public class AudioRecorderCompat
{
  public static int AUDIO_BIT_RATE = 0;
  public static int AUDIO_CHANNEL_COUNT = 0;
  public static int AUDIO_INPUT_BUFFER_SIZE = 0;
  public static int AUDIO_OUTPUT_BUFFER_SIZE = 0;
  public static int AUDIO_SAMPLE_RATE_IN_HZ = 0;
  public static final int[] BIT_RATES;
  public static final int ERROR_AUDIO_FILE_NOT_EXIST = 1;
  public static final int ERROR_AUDIO_ILLEGAL_ARGUMENT = 3;
  public static final int ERROR_AUDIO_INIT_AUDIORECORD_FAILED = 4;
  public static final int ERROR_AUDIO_OUT_OF_MEMORY = 2;
  public static final int ERROR_AUDIO_REAL_PACKER_FAILED = 7;
  public static final int ERROR_AUDIO_RECORD_READ_FAILED = 6;
  public static final int ERROR_AUDIO_RECORD_START_FAILED = 5;
  public static final int[] SAMPLE_RATES = { 8000, 11025, 16000, 22050, 44100, 48000 };
  protected static final String TAG = "AudioRecorderCompat";
  public static final int WX_VOICE_HTTP_ERROR_NETWORK = -201;
  protected AudioRecord mARecorder;
  protected AudioRecorderCompat.AsyncPcmWriter mAsyncPcmWriter;
  protected String mAudioPath;
  protected int mBufSize;
  protected byte[] mBuffer;
  protected AudioRecorderCompat.State mCurrentState;
  private int mDecibel;
  protected int mDelay;
  private FFTData mFFTDataResult;
  protected boolean mHasDelaySet;
  protected int mHasRecordLength;
  private int mLastBufferSize;
  private int mLastSampleRate;
  protected AudioRecorderCompat.AudioListener mListener;
  protected OnErrorListener mOnErrorListener;
  protected RealTimePcmPacker mPcmPacker;
  protected boolean mRealPackerEnable;
  protected AudioRecorderCompat.SimpleRecordThread mRecThread;
  protected boolean mVoice2TextEnable;
  protected boolean mVoiceChangeEnable;
  protected VoiceChanger mVoiceChanger;
  protected boolean mWrite2FileEnable;
  private short[] mfftbuffer;
  private boolean needDB;
  
  static
  {
    BIT_RATES = new int[] { 64000, 96000, 128000 };
    AUDIO_SAMPLE_RATE_IN_HZ = SAMPLE_RATES[2];
    AUDIO_CHANNEL_COUNT = 1;
    AUDIO_BIT_RATE = BIT_RATES[1];
    double d1 = AUDIO_SAMPLE_RATE_IN_HZ;
    Double.isNaN(d1);
    int i = AUDIO_CHANNEL_COUNT;
    double d2 = i;
    Double.isNaN(d2);
    AUDIO_INPUT_BUFFER_SIZE = (int)(d1 * 0.02D * d2 * 4.0D);
    AUDIO_OUTPUT_BUFFER_SIZE = AUDIO_INPUT_BUFFER_SIZE * i;
  }
  
  public AudioRecorderCompat(String paramString)
  {
    boolean bool2 = false;
    this.needDB = false;
    this.mCurrentState = new AudioRecorderCompat.State(this);
    this.mBufSize = AUDIO_OUTPUT_BUFFER_SIZE;
    int i = AUDIO_INPUT_BUFFER_SIZE;
    this.mLastBufferSize = i;
    int j = AUDIO_SAMPLE_RATE_IN_HZ;
    this.mLastSampleRate = j;
    this.mFFTDataResult = new FFTData(i, j / 2);
    this.mfftbuffer = new short[AUDIO_INPUT_BUFFER_SIZE];
    this.mAudioPath = paramString;
    this.mWrite2FileEnable = (TextUtils.isEmpty(paramString) ^ true);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (this.mAudioPath.endsWith(".m4a")) {
        bool1 = true;
      }
    }
    this.mRealPackerEnable = bool1;
  }
  
  public void enableVoice2Text(Context paramContext, OnErrorListener paramOnErrorListener)
  {
    VoiceTextRecognizer.getInstance().init(paramContext, true);
    VoiceTextRecognizer.getInstance().setVRErrorListener(new AudioRecorderCompat.1(this, paramOnErrorListener));
    VoiceTextRecognizer.getInstance().start();
    this.mVoice2TextEnable = true;
  }
  
  public int getDecibel()
  {
    return this.mDecibel;
  }
  
  public int getDelay()
  {
    return this.mDelay;
  }
  
  public FFTData getFFTResult()
  {
    return this.mFFTDataResult;
  }
  
  public int init()
  {
    return initWithAudioSource(1);
  }
  
  public int init(int paramInt1, int paramInt2)
  {
    return initWithAudioSource(1, paramInt1, paramInt2);
  }
  
  /* Error */
  public int initWithAudioSource(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: getstatic 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   9: bipush 16
    //   11: iconst_2
    //   12: invokestatic 224	android/media/AudioRecord:getMinBufferSize	(III)I
    //   15: putfield 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   18: getstatic 226	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   21: astore 8
    //   23: new 228	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   30: astore 9
    //   32: aload 9
    //   34: ldc 231
    //   36: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 9
    //   42: aload_0
    //   43: getfield 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   46: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 8
    //   52: aload 9
    //   54: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 248	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   64: istore_2
    //   65: getstatic 101	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   68: istore_3
    //   69: iload_2
    //   70: iload_3
    //   71: if_icmpgt +8 -> 79
    //   74: aload_0
    //   75: iload_3
    //   76: putfield 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   84: newarray byte
    //   86: putfield 250	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBuffer	[B
    //   89: aload_0
    //   90: new 221	android/media/AudioRecord
    //   93: dup
    //   94: iload_1
    //   95: getstatic 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   98: getstatic 85	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_CHANNEL_COUNT	I
    //   101: bipush 16
    //   103: imul
    //   104: iconst_2
    //   105: aload_0
    //   106: getfield 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   109: invokespecial 253	android/media/AudioRecord:<init>	(IIIII)V
    //   112: putfield 255	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   115: aload_0
    //   116: getfield 255	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   119: invokevirtual 258	android/media/AudioRecord:getState	()I
    //   122: iconst_1
    //   123: if_icmpeq +22 -> 145
    //   126: getstatic 226	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   129: ldc_w 260
    //   132: invokestatic 263	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   139: iconst_1
    //   140: invokevirtual 267	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   143: iconst_4
    //   144: ireturn
    //   145: aload_0
    //   146: getfield 255	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   149: invokevirtual 270	android/media/AudioRecord:getRecordingState	()I
    //   152: iconst_1
    //   153: if_icmpne +40 -> 193
    //   156: aload_0
    //   157: getfield 255	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   160: invokevirtual 273	android/media/AudioRecord:startRecording	()V
    //   163: goto +30 -> 193
    //   166: astore 8
    //   168: getstatic 226	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   171: ldc_w 275
    //   174: aload 8
    //   176: iconst_0
    //   177: anewarray 4	java/lang/Object
    //   180: invokestatic 279	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   183: aload_0
    //   184: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   187: iconst_1
    //   188: invokevirtual 267	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   191: iconst_5
    //   192: ireturn
    //   193: aload_0
    //   194: getfield 255	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   197: invokevirtual 270	android/media/AudioRecord:getRecordingState	()I
    //   200: iconst_3
    //   201: if_icmpne +10 -> 211
    //   204: aload_0
    //   205: getfield 255	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   208: invokevirtual 282	android/media/AudioRecord:stop	()V
    //   211: aload_0
    //   212: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   215: iconst_4
    //   216: invokevirtual 267	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   219: aload_0
    //   220: new 284	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter
    //   223: dup
    //   224: aload_0
    //   225: aload_0
    //   226: getfield 132	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mAudioPath	Ljava/lang/String;
    //   229: getstatic 99	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_INPUT_BUFFER_SIZE	I
    //   232: invokespecial 287	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;Ljava/lang/String;I)V
    //   235: putfield 289	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mAsyncPcmWriter	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter;
    //   238: new 228	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   245: astore 8
    //   247: aload 8
    //   249: ldc_w 291
    //   252: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 8
    //   258: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   261: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload_0
    //   266: new 296	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread
    //   269: dup
    //   270: aload_0
    //   271: aload 8
    //   273: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokespecial 299	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;Ljava/lang/String;)V
    //   279: putfield 301	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread;
    //   282: aload_0
    //   283: getfield 301	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread;
    //   286: invokevirtual 302	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:start	()V
    //   289: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   292: lstore 4
    //   294: getstatic 226	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   297: astore 8
    //   299: new 228	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   306: astore 9
    //   308: aload 9
    //   310: ldc_w 304
    //   313: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 9
    //   319: lload 4
    //   321: lload 6
    //   323: lsub
    //   324: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 8
    //   330: aload 9
    //   332: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 248	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: aload_0
    //   339: getfield 150	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mRealPackerEnable	Z
    //   342: ifeq +90 -> 432
    //   345: aload_0
    //   346: new 306	com/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker
    //   349: dup
    //   350: getstatic 87	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_BIT_RATE	I
    //   353: getstatic 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   356: getstatic 85	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_CHANNEL_COUNT	I
    //   359: invokespecial 309	com/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker:<init>	(III)V
    //   362: putfield 311	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mPcmPacker	Lcom/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker;
    //   365: aload_0
    //   366: getfield 311	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mPcmPacker	Lcom/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker;
    //   369: aload_0
    //   370: getfield 132	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mAudioPath	Ljava/lang/String;
    //   373: invokevirtual 314	com/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker:setOutputPath	(Ljava/lang/String;)V
    //   376: aload_0
    //   377: getfield 289	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mAsyncPcmWriter	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter;
    //   380: invokevirtual 317	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter:onPrepare	()V
    //   383: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   386: lstore 6
    //   388: getstatic 226	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   391: astore 8
    //   393: new 228	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   400: astore 9
    //   402: aload 9
    //   404: ldc_w 319
    //   407: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 9
    //   413: lload 6
    //   415: lload 4
    //   417: lsub
    //   418: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 8
    //   424: aload 9
    //   426: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 248	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: iconst_0
    //   433: ireturn
    //   434: astore 8
    //   436: getstatic 226	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   439: aload 8
    //   441: invokevirtual 322	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   444: invokestatic 263	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload_0
    //   448: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   451: iconst_1
    //   452: invokevirtual 267	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   455: bipush 7
    //   457: ireturn
    //   458: astore 8
    //   460: getstatic 226	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   463: aload 8
    //   465: invokevirtual 323	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   468: invokestatic 263	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: aload_0
    //   472: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   475: iconst_1
    //   476: invokevirtual 267	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   479: iconst_1
    //   480: ireturn
    //   481: astore 8
    //   483: getstatic 226	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   486: ldc_w 325
    //   489: aload 8
    //   491: iconst_0
    //   492: anewarray 4	java/lang/Object
    //   495: invokestatic 327	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   498: aload_0
    //   499: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   502: iconst_1
    //   503: invokevirtual 267	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   506: iconst_3
    //   507: ireturn
    //   508: astore 8
    //   510: getstatic 226	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   513: aload 8
    //   515: invokevirtual 328	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   518: invokestatic 263	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload_0
    //   522: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   525: iconst_1
    //   526: invokevirtual 267	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   529: iconst_2
    //   530: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	AudioRecorderCompat
    //   0	531	1	paramInt	int
    //   64	8	2	i	int
    //   68	8	3	j	int
    //   292	124	4	l1	long
    //   3	411	6	l2	long
    //   21	30	8	str	String
    //   166	9	8	localSecurityException	java.lang.SecurityException
    //   245	178	8	localObject	Object
    //   434	6	8	localException	java.lang.Exception
    //   458	6	8	localFileNotFoundException	java.io.FileNotFoundException
    //   481	9	8	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   508	6	8	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   30	395	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   156	163	166	java/lang/SecurityException
    //   338	432	434	java/lang/Exception
    //   219	238	458	java/io/FileNotFoundException
    //   89	115	481	java/lang/IllegalArgumentException
    //   79	89	508	java/lang/OutOfMemoryError
  }
  
  public int initWithAudioSource(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = initWithAudioSource(paramInt1);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    long l = System.currentTimeMillis();
    this.mVoiceChanger = new VoiceChanger(this.mAudioPath, AUDIO_SAMPLE_RATE_IN_HZ, paramInt2, paramInt3);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Audio Processers: start voice changer = ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    LogUtils.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("init() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.d(str, localStringBuilder.toString());
    this.mVoiceChangeEnable = true;
    return paramInt1;
  }
  
  public void onDelaySet(int paramInt) {}
  
  public void onRecordError(int paramInt)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecordError() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.e((String)localObject, localStringBuilder.toString());
    localObject = this.mOnErrorListener;
    if (localObject != null) {
      ((OnErrorListener)localObject).onError(paramInt);
    }
  }
  
  public void onRecordStop()
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecordStop() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.d((String)localObject, localStringBuilder.toString());
    localObject = this.mAsyncPcmWriter;
    if (localObject != null) {
      ((AudioRecorderCompat.AsyncPcmWriter)localObject).onStop();
    }
  }
  
  public void onRecording(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.mWrite2FileEnable)
    {
      AudioRecorderCompat.AsyncPcmWriter localAsyncPcmWriter = this.mAsyncPcmWriter;
      if (localAsyncPcmWriter != null) {
        localAsyncPcmWriter.onRecord(paramArrayOfByte, paramInt);
      }
    }
    if (this.mVoice2TextEnable) {
      VoiceTextRecognizer.getInstance().recognizeFromPCMBuffer(paramArrayOfByte, paramInt);
    }
  }
  
  public void pause()
  {
    ??? = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pause() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.d((String)???, localStringBuilder.toString());
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 16 }))
      {
        LogUtils.d(TAG, "current state has been 16");
        return;
      }
      if (this.mCurrentState.equalState(new int[] { 8, 4 }))
      {
        this.mCurrentState.transfer(16);
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("current status is: ");
      localStringBuilder.append(this.mCurrentState);
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  public void release()
  {
    LogUtils.d(TAG, "release start");
    AudioRecord localAudioRecord;
    synchronized (this.mCurrentState)
    {
      if (!this.mCurrentState.equalState(new int[] { 32 }))
      {
        LogUtils.i(TAG, "stop() is forgotten by someone, so call it now!");
        stop(null);
      }
      this.mCurrentState.transfer(2);
      this.mHasRecordLength = 0;
      ??? = this.mRecThread;
      if ((??? != null) && (!???.equals(Thread.currentThread()))) {
        try
        {
          this.mRecThread.join();
        }
        catch (InterruptedException localInterruptedException)
        {
          LogUtils.e(TAG, localInterruptedException.getMessage());
          this.mRecThread = null;
        }
      }
      localAudioRecord = this.mARecorder;
      if (localAudioRecord != null) {
        localAudioRecord.release();
      }
      LogUtils.d(TAG, "AduioRecord release finish");
      this.mHasRecordLength = 0;
      LogUtils.d(TAG, "release finish");
      return;
    }
  }
  
  public void resume()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resume() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.d(str, localStringBuilder.toString());
    start();
  }
  
  public void setNeedDB(boolean paramBoolean)
  {
    this.needDB = paramBoolean;
  }
  
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void setSampleRate(int paramInt)
  {
    AUDIO_SAMPLE_RATE_IN_HZ = paramInt;
    paramInt = AUDIO_SAMPLE_RATE_IN_HZ;
    double d1 = paramInt;
    Double.isNaN(d1);
    int i = AUDIO_CHANNEL_COUNT;
    double d2 = i;
    Double.isNaN(d2);
    AUDIO_INPUT_BUFFER_SIZE = (int)(d1 * 0.02D * d2 * 4.0D);
    int j = AUDIO_INPUT_BUFFER_SIZE;
    AUDIO_OUTPUT_BUFFER_SIZE = i * j;
    if ((this.mLastBufferSize != j) || (this.mLastSampleRate != paramInt))
    {
      this.mFFTDataResult = new FFTData(AUDIO_INPUT_BUFFER_SIZE, AUDIO_SAMPLE_RATE_IN_HZ);
      this.mfftbuffer = new short[AUDIO_INPUT_BUFFER_SIZE];
    }
  }
  
  public void start()
  {
    ??? = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.d((String)???, localStringBuilder.toString());
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 8 }))
      {
        LogUtils.w(TAG, "current state has been 8");
        return;
      }
      if (this.mCurrentState.equalState(new int[] { 16, 4 }))
      {
        this.mCurrentState.transfer(8);
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("current status is: ");
      localStringBuilder.append(this.mCurrentState);
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  public void stop(AudioRecorderCompat.AudioListener paramAudioListener)
  {
    ??? = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.d((String)???, localStringBuilder.toString());
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 32 }))
      {
        LogUtils.d(TAG, "current state has been 32");
        return;
      }
      this.mCurrentState.transfer(32);
      ??? = this.mRecThread;
      if ((??? != null) && (!???.equals(Thread.currentThread())))
      {
        this.mListener = paramAudioListener;
        try
        {
          this.mRecThread.join();
          paramAudioListener = TAG;
          ??? = new StringBuilder();
          ((StringBuilder)???).append("stop() - join() - currentState = ");
          ((StringBuilder)???).append(this.mCurrentState);
          LogUtils.d(paramAudioListener, ((StringBuilder)???).toString());
        }
        catch (InterruptedException paramAudioListener)
        {
          LogUtils.e(TAG, paramAudioListener.getMessage());
        }
        this.mRecThread = null;
      }
      return;
    }
  }
  
  protected void tryReleaseChanger()
  {
    VoiceChanger localVoiceChanger = this.mVoiceChanger;
    if (localVoiceChanger != null) {
      localVoiceChanger.release();
    }
  }
  
  protected void tryReleasePacker()
  {
    RealTimePcmPacker localRealTimePcmPacker = this.mPcmPacker;
    if (localRealTimePcmPacker != null) {
      localRealTimePcmPacker.stop();
    }
  }
  
  protected void tryReleaseRecognizer()
  {
    if (this.mVoice2TextEnable)
    {
      VoiceTextRecognizer.getInstance().destroy();
      this.mVoice2TextEnable = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
 * JD-Core Version:    0.7.0.1
 */