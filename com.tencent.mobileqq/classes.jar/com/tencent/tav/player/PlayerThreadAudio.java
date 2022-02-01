package com.tencent.tav.player;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.reverseaudio.ReverseAudioDecoderTrack;
import java.nio.ByteBuffer;

public class PlayerThreadAudio
  implements Handler.Callback
{
  private static final String TAG = "PlayerThreadAudio";
  private IDecoderTrack audioDecoderTrack;
  public volatile CMSampleState currentPlayingState = new CMSampleState();
  public volatile long lastSyncMessgeId = -1L;
  private AudioTrackWrapper mAudioTrack;
  private boolean mLooper;
  private Handler mPlayHandler;
  private int mStatus = 1;
  private HandlerThread mThread;
  private Handler mVideoHandler;
  private float rate = 1.0F;
  private float volume = 1.0F;
  
  public PlayerThreadAudio(IDecoderTrack paramIDecoderTrack, Handler paramHandler)
  {
    this.audioDecoderTrack = paramIDecoderTrack;
    this.mVideoHandler = paramHandler;
    initThread();
  }
  
  private void actionPrepare()
  {
    if (this.audioDecoderTrack != null)
    {
      int i = this.mStatus;
      updateStatus(2);
      releaseAudioTrack();
    }
  }
  
  private String catLog(int paramInt)
  {
    return PlayerThread.catLog(paramInt);
  }
  
  private void initThread()
  {
    this.mThread = new HandlerThread("PlayerAudioThread");
    this.mThread.start();
    this.mPlayHandler = new Handler(this.mThread.getLooper(), this);
  }
  
  private void pause()
  {
    if (this.mStatus == 2)
    {
      this.mLooper = false;
      this.currentPlayingState = new CMSampleState();
      removePendingMessage(new int[] { 12 });
    }
  }
  
  private void play(Object paramObject)
  {
    if (this.mStatus == 1) {
      return;
    }
    this.mLooper = true;
    if (((paramObject instanceof CMTime)) && (Math.abs(((CMTime)paramObject).getTimeUs() - this.currentPlayingState.getTime().getTimeUs()) > 100000L)) {
      seekTo(paramObject);
    }
    if (this.mStatus == 3) {
      updateStatus(2);
    }
    sendMessage(12, "play", System.currentTimeMillis());
  }
  
  private void playerFinish()
  {
    this.currentPlayingState = new CMSampleState();
    this.audioDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
    this.mLooper = false;
    updateStatus(3);
    removePendingMessage(new int[] { 12 });
  }
  
  private void readSample()
  {
    Object localObject1 = this.audioDecoderTrack;
    if (localObject1 != null)
    {
      if (!this.mLooper) {
        return;
      }
      if ((localObject1 instanceof AudioCompositionDecoderTrack)) {
        ((AudioCompositionDecoderTrack)localObject1).setRate(this.rate);
      } else if ((localObject1 instanceof ReverseAudioDecoderTrack)) {
        ((ReverseAudioDecoderTrack)localObject1).setRate(this.rate);
      }
      localObject1 = CMSampleState.fromError(-2L);
      v("PlayerThreadAudio", "readSample start");
      StringBuilder localStringBuilder2 = null;
      byte[] arrayOfByte = null;
      try
      {
        Object localObject3 = this.audioDecoderTrack.readSample();
        try
        {
          localObject2 = ((CMSampleBuffer)localObject3).getState();
          localObject1 = localObject2;
          StringBuilder localStringBuilder3 = new StringBuilder();
          localObject1 = localObject2;
          localStringBuilder3.append("readSample finish ");
          localObject1 = localObject2;
          localStringBuilder3.append(localObject2);
          localObject1 = localObject2;
          v("PlayerThreadAudio", localStringBuilder3.toString());
        }
        catch (Exception localException3)
        {
          localObject2 = localObject3;
          localObject3 = localException3;
        }
        Logger.e("PlayerThreadAudio", "java.lang.IllegalStateException: buffer was freed", localException1);
      }
      catch (Exception localException1)
      {
        localObject2 = null;
      }
      Object localObject4 = localObject2;
      Object localObject2 = localObject1;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processFrame() called sampleState--> ");
      ((StringBuilder)localObject1).append(localObject2);
      v("PlayerThreadAudio", ((StringBuilder)localObject1).toString());
      if (this.mAudioTrack == null)
      {
        v("PlayerThreadAudio", "processFrame() called new mediaFormat");
        this.mAudioTrack = new AudioTrackWrapper(44100, 1);
        this.mAudioTrack.setVolume(this.volume);
      }
      if ((!((CMSampleState)localObject2).stateMatchingTo(new long[] { -1L, -3L, -100L })) && (!((CMSampleState)localObject2).getTime().bigThan(this.audioDecoderTrack.getDuration())))
      {
        if ((((CMSampleState)localObject2).getStateCode() >= 0L) && (localObject4 != null))
        {
          localObject1 = arrayOfByte;
          try
          {
            ByteBuffer localByteBuffer = localObject4.getSampleByteBuffer();
            localObject1 = localStringBuilder2;
            if (localByteBuffer != null)
            {
              localObject1 = arrayOfByte;
              localByteBuffer.position(0);
              localObject1 = arrayOfByte;
              arrayOfByte = new byte[localByteBuffer.limit()];
              localObject1 = arrayOfByte;
              localStringBuilder2 = new StringBuilder();
              localObject1 = arrayOfByte;
              localStringBuilder2.append("read sample thread: ");
              localObject1 = arrayOfByte;
              localStringBuilder2.append(Thread.currentThread().getId());
              localObject1 = arrayOfByte;
              localStringBuilder2.append(" ");
              localObject1 = arrayOfByte;
              localStringBuilder2.append(localObject4.getTime());
              localObject1 = arrayOfByte;
              Logger.v("PlayerThreadAudio", localStringBuilder2.toString());
              localObject1 = arrayOfByte;
              localByteBuffer.get(arrayOfByte);
              localObject1 = arrayOfByte;
            }
          }
          catch (Exception localException2)
          {
            Logger.e("PlayerThreadAudio", "readSample: ", localException2);
          }
          if (localObject1 != null)
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("processFrame() called run audioData length audioData--");
            localStringBuilder1.append(localObject1.length);
            v("PlayerThreadAudio", localStringBuilder1.toString());
            this.audioDecoderTrack.asyncReadNextSample(CMTime.CMTimeInvalid);
            this.mAudioTrack.writeData((byte[])localObject1, 0, localObject1.length);
          }
          else
          {
            v("PlayerThreadAudio", "processFrame() called run audioData length exception");
          }
        }
        this.currentPlayingState = ((CMSampleState)localObject2);
        if ((this.mLooper) && (this.rate != 0.0F))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("processFrame() called run looper ");
          ((StringBuilder)localObject1).append(this.currentPlayingState);
          v("PlayerThreadAudio", ((StringBuilder)localObject1).toString());
          scheduleNextWork();
          return;
        }
        v("PlayerThreadAudio", "processFrame() not run looper");
        return;
      }
      v("PlayerThreadAudio", "processFrame() called end of stream");
      playerFinish();
      this.currentPlayingState = ((CMSampleState)localObject2);
    }
  }
  
  /* Error */
  private void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 66	com/tencent/tav/player/PlayerThreadAudio:releaseAudioTrack	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: newarray int
    //   8: invokespecial 102	com/tencent/tav/player/PlayerThreadAudio:removePendingMessage	([I)V
    //   11: aload_0
    //   12: iconst_1
    //   13: invokespecial 63	com/tencent/tav/player/PlayerThreadAudio:updateStatus	(I)V
    //   16: new 180	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_1
    //   25: ldc_w 305
    //   28: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: aload_0
    //   34: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: ldc 10
    //   40: aload_1
    //   41: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 310	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   47: pop
    //   48: aload_0
    //   49: getfield 81	com/tencent/tav/player/PlayerThreadAudio:mThread	Landroid/os/HandlerThread;
    //   52: invokevirtual 314	android/os/HandlerThread:quit	()Z
    //   55: pop
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 81	com/tencent/tav/player/PlayerThreadAudio:mThread	Landroid/os/HandlerThread;
    //   61: aload_0
    //   62: getfield 54	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   65: astore_1
    //   66: aload_1
    //   67: monitorenter
    //   68: aload_0
    //   69: getfield 54	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   72: sipush 850
    //   75: invokevirtual 318	android/os/Handler:sendEmptyMessage	(I)Z
    //   78: pop
    //   79: aload_1
    //   80: monitorexit
    //   81: goto +42 -> 123
    //   84: astore_2
    //   85: aload_1
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    //   89: astore_2
    //   90: goto +49 -> 139
    //   93: astore_1
    //   94: ldc 10
    //   96: ldc_w 320
    //   99: aload_1
    //   100: invokestatic 202	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_0
    //   104: getfield 54	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   107: astore_1
    //   108: aload_1
    //   109: monitorenter
    //   110: aload_0
    //   111: getfield 54	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   114: sipush 850
    //   117: invokevirtual 318	android/os/Handler:sendEmptyMessage	(I)Z
    //   120: pop
    //   121: aload_1
    //   122: monitorexit
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 95	com/tencent/tav/player/PlayerThreadAudio:mPlayHandler	Landroid/os/Handler;
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 54	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   133: return
    //   134: astore_2
    //   135: aload_1
    //   136: monitorexit
    //   137: aload_2
    //   138: athrow
    //   139: aload_0
    //   140: getfield 54	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   143: astore_1
    //   144: aload_1
    //   145: monitorenter
    //   146: aload_0
    //   147: getfield 54	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   150: sipush 850
    //   153: invokevirtual 318	android/os/Handler:sendEmptyMessage	(I)Z
    //   156: pop
    //   157: aload_1
    //   158: monitorexit
    //   159: aload_0
    //   160: aconst_null
    //   161: putfield 95	com/tencent/tav/player/PlayerThreadAudio:mPlayHandler	Landroid/os/Handler;
    //   164: aload_0
    //   165: aconst_null
    //   166: putfield 54	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   169: aload_2
    //   170: athrow
    //   171: astore_2
    //   172: aload_1
    //   173: monitorexit
    //   174: aload_2
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	PlayerThreadAudio
    //   93	7	1	localException	Exception
    //   84	4	2	localObject2	Object
    //   89	1	2	localObject3	Object
    //   134	36	2	localObject4	Object
    //   171	4	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   68	81	84	finally
    //   85	87	84	finally
    //   16	61	89	finally
    //   94	103	89	finally
    //   16	61	93	java/lang/Exception
    //   110	123	134	finally
    //   135	137	134	finally
    //   146	159	171	finally
    //   172	174	171	finally
  }
  
  private void releaseAudioTrack()
  {
    AudioTrackWrapper localAudioTrackWrapper = this.mAudioTrack;
    if (localAudioTrackWrapper != null)
    {
      localAudioTrackWrapper.stop();
      this.mAudioTrack.release();
      this.mAudioTrack = null;
    }
  }
  
  private void removePendingMessage(int... paramVarArgs)
  {
    int j;
    int i;
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      j = paramVarArgs.length;
      i = 0;
    }
    while (i < j)
    {
      int k = paramVarArgs[i];
      this.mPlayHandler.removeMessages(k);
      i += 1;
      continue;
      this.mPlayHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private void scheduleNextWork()
  {
    sendMessage(12, "schedule next", System.currentTimeMillis());
  }
  
  private void seekTo(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof PlayerMessage)) {
      localObject = ((PlayerMessage)paramObject).bizMsg1;
    }
    if ((localObject instanceof CMTime))
    {
      paramObject = (CMTime)localObject;
      this.currentPlayingState = new CMSampleState(paramObject);
      this.audioDecoderTrack.seekTo(paramObject, false, true);
    }
    paramObject = this.mAudioTrack;
    if (paramObject != null) {
      paramObject.flush();
    }
  }
  
  private void setVolume(Object paramObject)
  {
    float f;
    if ((paramObject instanceof PlayerMessage)) {
      f = ((Float)((PlayerMessage)paramObject).bizMsg1).floatValue();
    } else if ((paramObject instanceof Float)) {
      f = ((Float)paramObject).floatValue();
    } else {
      f = 1.0F;
    }
    if ((f >= 0.0F) && (f <= 1.0F)) {
      setVolumeToAudioTrack(f);
    }
  }
  
  private void setVolumeToAudioTrack(float paramFloat)
  {
    this.volume = paramFloat;
    AudioTrackWrapper localAudioTrackWrapper = this.mAudioTrack;
    if (localAudioTrackWrapper != null) {
      localAudioTrackWrapper.setVolume(paramFloat);
    }
  }
  
  private void stop(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      removePendingMessage(new int[] { 12 });
      this.mLooper = false;
      this.currentPlayingState = new CMSampleState();
    }
    updateStatus(1);
    releaseAudioTrack();
  }
  
  private void updateStatus(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  private void v(String paramString1, String paramString2)
  {
    Logger.v(paramString1, paramString2);
  }
  
  public CMTime getCurrentPlayingState()
  {
    return this.currentPlayingState.getTime();
  }
  
  /* Error */
  public boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 362	android/os/Message:obj	Ljava/lang/Object;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_3
    //   9: ifnonnull +8 -> 17
    //   12: aconst_null
    //   13: astore_3
    //   14: goto +11 -> 25
    //   17: aload_1
    //   18: getfield 362	android/os/Message:obj	Ljava/lang/Object;
    //   21: checkcast 335	com/tencent/tav/player/PlayerMessage
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +12 -> 38
    //   29: aload_3
    //   30: getfield 339	com/tencent/tav/player/PlayerMessage:bizMsg1	Ljava/lang/Object;
    //   33: astore 4
    //   35: goto +6 -> 41
    //   38: aconst_null
    //   39: astore 4
    //   41: new 180	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   48: astore 6
    //   50: aload 6
    //   52: ldc_w 364
    //   55: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 6
    //   61: aload_0
    //   62: aload_1
    //   63: getfield 367	android/os/Message:what	I
    //   66: invokespecial 368	com/tencent/tav/player/PlayerThreadAudio:catLog	(I)Ljava/lang/String;
    //   69: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 6
    //   75: aload_1
    //   76: getfield 367	android/os/Message:what	I
    //   79: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 6
    //   85: ldc_w 370
    //   88: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 6
    //   94: aload_0
    //   95: getfield 46	com/tencent/tav/player/PlayerThreadAudio:mStatus	I
    //   98: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 6
    //   104: ldc_w 372
    //   107: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_3
    //   112: ifnonnull +6 -> 118
    //   115: goto +6 -> 121
    //   118: aload_3
    //   119: astore 5
    //   121: aload 6
    //   123: aload 5
    //   125: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 6
    //   131: ldc_w 374
    //   134: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 6
    //   140: aload 4
    //   142: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_0
    //   147: ldc 10
    //   149: aload 6
    //   151: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokespecial 169	com/tencent/tav/player/PlayerThreadAudio:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_1
    //   158: getfield 367	android/os/Message:what	I
    //   161: istore_2
    //   162: iload_2
    //   163: iconst_m1
    //   164: if_icmpeq +115 -> 279
    //   167: iload_2
    //   168: bipush 12
    //   170: if_icmpeq +102 -> 272
    //   173: iload_2
    //   174: tableswitch	default:+412 -> 586, 1:+91->265, 2:+82->256, 3:+75->249, 4:+67->241, 5:+58->232, 6:+51->225, 7:+42->216
    //   217: aload 4
    //   219: invokespecial 376	com/tencent/tav/player/PlayerThreadAudio:setVolume	(Ljava/lang/Object;)V
    //   222: goto +61 -> 283
    //   225: aload_0
    //   226: invokespecial 377	com/tencent/tav/player/PlayerThreadAudio:release	()V
    //   229: goto +54 -> 283
    //   232: aload_0
    //   233: aload 4
    //   235: invokespecial 125	com/tencent/tav/player/PlayerThreadAudio:seekTo	(Ljava/lang/Object;)V
    //   238: goto +45 -> 283
    //   241: aload_0
    //   242: iconst_0
    //   243: invokespecial 379	com/tencent/tav/player/PlayerThreadAudio:stop	(Z)V
    //   246: goto +37 -> 283
    //   249: aload_0
    //   250: invokespecial 381	com/tencent/tav/player/PlayerThreadAudio:pause	()V
    //   253: goto +30 -> 283
    //   256: aload_0
    //   257: aload 4
    //   259: invokespecial 383	com/tencent/tav/player/PlayerThreadAudio:play	(Ljava/lang/Object;)V
    //   262: goto +21 -> 283
    //   265: aload_0
    //   266: invokespecial 385	com/tencent/tav/player/PlayerThreadAudio:actionPrepare	()V
    //   269: goto +14 -> 283
    //   272: aload_0
    //   273: invokespecial 387	com/tencent/tav/player/PlayerThreadAudio:readSample	()V
    //   276: goto +7 -> 283
    //   279: aload_0
    //   280: invokespecial 302	com/tencent/tav/player/PlayerThreadAudio:playerFinish	()V
    //   283: aload_3
    //   284: ifnull +92 -> 376
    //   287: aload_3
    //   288: getfield 390	com/tencent/tav/player/PlayerMessage:form	Ljava/lang/String;
    //   291: invokestatic 396	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   294: ifne +82 -> 376
    //   297: aload_3
    //   298: getfield 390	com/tencent/tav/player/PlayerMessage:form	Ljava/lang/String;
    //   301: ldc_w 398
    //   304: invokevirtual 404	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   307: ifeq +69 -> 376
    //   310: new 180	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   317: astore 4
    //   319: aload 4
    //   321: ldc_w 406
    //   324: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 4
    //   330: aload_3
    //   331: getfield 409	com/tencent/tav/player/PlayerMessage:msgId	J
    //   334: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 4
    //   340: ldc_w 411
    //   343: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 4
    //   349: aload_1
    //   350: getfield 367	android/os/Message:what	I
    //   353: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: ldc 10
    //   359: aload 4
    //   361: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 414	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   367: pop
    //   368: aload_0
    //   369: aload_3
    //   370: getfield 409	com/tencent/tav/player/PlayerMessage:msgId	J
    //   373: putfield 44	com/tencent/tav/player/PlayerThreadAudio:lastSyncMessgeId	J
    //   376: iconst_1
    //   377: ireturn
    //   378: astore 4
    //   380: goto +110 -> 490
    //   383: astore 4
    //   385: ldc 10
    //   387: ldc_w 416
    //   390: aload 4
    //   392: invokestatic 202	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   395: aload_3
    //   396: ifnull +92 -> 488
    //   399: aload_3
    //   400: getfield 390	com/tencent/tav/player/PlayerMessage:form	Ljava/lang/String;
    //   403: invokestatic 396	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   406: ifne +82 -> 488
    //   409: aload_3
    //   410: getfield 390	com/tencent/tav/player/PlayerMessage:form	Ljava/lang/String;
    //   413: ldc_w 398
    //   416: invokevirtual 404	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   419: ifeq +69 -> 488
    //   422: new 180	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   429: astore 4
    //   431: aload 4
    //   433: ldc_w 406
    //   436: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload 4
    //   442: aload_3
    //   443: getfield 409	com/tencent/tav/player/PlayerMessage:msgId	J
    //   446: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 4
    //   452: ldc_w 411
    //   455: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 4
    //   461: aload_1
    //   462: getfield 367	android/os/Message:what	I
    //   465: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: ldc 10
    //   471: aload 4
    //   473: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 414	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   479: pop
    //   480: aload_0
    //   481: aload_3
    //   482: getfield 409	com/tencent/tav/player/PlayerMessage:msgId	J
    //   485: putfield 44	com/tencent/tav/player/PlayerThreadAudio:lastSyncMessgeId	J
    //   488: iconst_0
    //   489: ireturn
    //   490: aload_3
    //   491: ifnull +92 -> 583
    //   494: aload_3
    //   495: getfield 390	com/tencent/tav/player/PlayerMessage:form	Ljava/lang/String;
    //   498: invokestatic 396	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   501: ifne +82 -> 583
    //   504: aload_3
    //   505: getfield 390	com/tencent/tav/player/PlayerMessage:form	Ljava/lang/String;
    //   508: ldc_w 398
    //   511: invokevirtual 404	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   514: ifeq +69 -> 583
    //   517: new 180	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   524: astore 5
    //   526: aload 5
    //   528: ldc_w 406
    //   531: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload 5
    //   537: aload_3
    //   538: getfield 409	com/tencent/tav/player/PlayerMessage:msgId	J
    //   541: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 5
    //   547: ldc_w 411
    //   550: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload 5
    //   556: aload_1
    //   557: getfield 367	android/os/Message:what	I
    //   560: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: ldc 10
    //   566: aload 5
    //   568: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 414	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   574: pop
    //   575: aload_0
    //   576: aload_3
    //   577: getfield 409	com/tencent/tav/player/PlayerMessage:msgId	J
    //   580: putfield 44	com/tencent/tav/player/PlayerThreadAudio:lastSyncMessgeId	J
    //   583: aload 4
    //   585: athrow
    //   586: goto -303 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	this	PlayerThreadAudio
    //   0	589	1	paramMessage	Message
    //   161	13	2	i	int
    //   4	573	3	localObject1	Object
    //   33	327	4	localObject2	Object
    //   378	1	4	localObject3	Object
    //   383	8	4	localException	Exception
    //   429	155	4	localStringBuilder1	StringBuilder
    //   6	561	5	localObject4	Object
    //   48	102	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   157	162	378	finally
    //   216	222	378	finally
    //   225	229	378	finally
    //   232	238	378	finally
    //   241	246	378	finally
    //   249	253	378	finally
    //   256	262	378	finally
    //   265	269	378	finally
    //   272	276	378	finally
    //   279	283	378	finally
    //   385	395	378	finally
    //   157	162	383	java/lang/Exception
    //   216	222	383	java/lang/Exception
    //   225	229	383	java/lang/Exception
    //   232	238	383	java/lang/Exception
    //   241	246	383	java/lang/Exception
    //   249	253	383	java/lang/Exception
    //   256	262	383	java/lang/Exception
    //   265	269	383	java/lang/Exception
    //   272	276	383	java/lang/Exception
    //   279	283	383	java/lang/Exception
  }
  
  public boolean isFinished()
  {
    return (3 == this.mStatus) && (this.currentPlayingState.isInvalid());
  }
  
  public void sendMessage(int paramInt, Object paramObject, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendMessage() called with: what = [");
    localStringBuilder.append(catLog(paramInt));
    localStringBuilder.append("], obj = [");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("], from = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    v("PlayerThreadAudio", localStringBuilder.toString());
    if ((this.mPlayHandler != null) && (this.mThread != null))
    {
      if (((paramInt == 3) || (paramInt == -1) || (paramInt == 5) || (paramInt == 6)) && (this.mPlayHandler.hasMessages(12)))
      {
        this.mPlayHandler.removeMessages(12);
        sendMessage(12, "schedule next", System.currentTimeMillis());
      }
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(paramObject, paramString, paramLong)).sendToTarget();
    }
  }
  
  public void sendMessage(int paramInt, String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessage() called with: what = [");
    ((StringBuilder)localObject).append(catLog(paramInt));
    ((StringBuilder)localObject).append("], from = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    v("PlayerThreadAudio", ((StringBuilder)localObject).toString());
    localObject = this.mPlayHandler;
    if ((localObject != null) && (this.mThread != null)) {
      ((Handler)localObject).obtainMessage(paramInt, new PlayerMessage(null, paramString, paramLong)).sendToTarget();
    }
  }
  
  public void sendMessageDelay(int paramInt, long paramLong1, String paramString, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessageDelay() called with: what = [");
    ((StringBuilder)localObject).append(catLog(paramInt));
    ((StringBuilder)localObject).append("], delay = [");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("], from = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    v("PlayerThreadAudio", ((StringBuilder)localObject).toString());
    if (this.mPlayHandler != null)
    {
      localObject = new Message();
      ((Message)localObject).what = paramInt;
      ((Message)localObject).obj = new PlayerMessage(null, paramString, paramLong2);
      this.mPlayHandler.sendMessageDelayed((Message)localObject, paramLong1);
    }
  }
  
  public void setRate(float paramFloat)
  {
    this.rate = Math.abs(paramFloat);
  }
  
  public void update(IDecoderTrack paramIDecoderTrack)
  {
    this.audioDecoderTrack = paramIDecoderTrack;
  }
  
  @Deprecated
  public void updateComposition(AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack)
  {
    sendMessage(4, "updateComposition", System.currentTimeMillis());
    sendMessage(1, paramAudioCompositionDecoderTrack, "updateComposition", System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.player.PlayerThreadAudio
 * JD-Core Version:    0.7.0.1
 */