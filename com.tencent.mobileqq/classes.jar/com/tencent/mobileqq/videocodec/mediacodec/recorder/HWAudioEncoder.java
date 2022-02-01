package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;

@TargetApi(18)
public class HWAudioEncoder
{
  HWAudioEncoder.AudioEncodeListener a;
  private HandlerThread b = ThreadManagerV2.newFreeHandlerThread("HWAudioEncoder", 0);
  private Handler c;
  private MediaFormat d;
  private MediaCodec e;
  private MediaMuxer f;
  private MediaCodec.BufferInfo g = new MediaCodec.BufferInfo();
  private long h;
  private int i;
  private boolean j;
  private String k;
  private int l;
  private double m;
  private long n;
  
  public HWAudioEncoder()
  {
    this.b.start();
    this.c = new HWAudioEncoder.AudioEncodeHandler(this, this.b.getLooper(), this);
  }
  
  private void b(String paramString)
  {
    this.k = paramString;
    this.d = new MediaFormat();
    this.d.setString("mime", "audio/mp4a-latm");
    int i1 = CodecParam.mAudioChannel;
    int i2 = 16;
    if (i1 == 16) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    this.d.setInteger("channel-count", i1);
    this.d.setInteger("sample-rate", this.l);
    this.d.setInteger("aac-profile", 2);
    this.d.setInteger("bitrate", CodecParam.mDstAudioEncBitrate);
    this.d.setInteger("max-input-size", AudioCapture.a);
    this.e = MediaCodec.createEncoderByType("audio/mp4a-latm");
    this.e.configure(this.d, null, null, 1);
    this.e.start();
    paramString = new File(this.k);
    if (!paramString.exists()) {
      FileUtils.createFileIfNotExits(paramString.getAbsolutePath());
    }
    this.f = new MediaMuxer(this.k, 0);
    this.i = 0;
    this.j = false;
    this.h = 0L;
    this.g = new MediaCodec.BufferInfo();
    this.n = 0L;
    if (CodecParam.mAudioFormat != 2) {
      i2 = 8;
    }
    double d1 = this.l * i2 * i1 / 8;
    double d2 = Math.pow(10.0D, 6.0D);
    Double.isNaN(d1);
    this.m = (d1 / d2);
  }
  
  private void d() {}
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:c	Landroid/os/Handler;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +8 -> 14
    //   9: aload_3
    //   10: aconst_null
    //   11: invokevirtual 192	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield 127	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:e	Landroid/media/MediaCodec;
    //   18: ifnull +35 -> 53
    //   21: invokestatic 198	android/os/SystemClock:elapsedRealtimeNanos	()J
    //   24: lstore_1
    //   25: aload_0
    //   26: iconst_0
    //   27: newarray byte
    //   29: lload_1
    //   30: iconst_1
    //   31: invokevirtual 201	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:a	([BJZ)V
    //   34: aload_0
    //   35: getfield 127	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:e	Landroid/media/MediaCodec;
    //   38: invokevirtual 204	android/media/MediaCodec:stop	()V
    //   41: aload_0
    //   42: getfield 127	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:e	Landroid/media/MediaCodec;
    //   45: invokevirtual 207	android/media/MediaCodec:release	()V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 127	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:e	Landroid/media/MediaCodec;
    //   53: aload_0
    //   54: getfield 155	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:f	Landroid/media/MediaMuxer;
    //   57: astore_3
    //   58: aload_3
    //   59: ifnull +90 -> 149
    //   62: aload_0
    //   63: getfield 159	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:j	Z
    //   66: ifeq +83 -> 149
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield 159	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:j	Z
    //   74: aload_3
    //   75: invokevirtual 208	android/media/MediaMuxer:release	()V
    //   78: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +11 -> 92
    //   84: ldc 44
    //   86: iconst_2
    //   87: ldc 215
    //   89: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_0
    //   93: getfield 220	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:a	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder$AudioEncodeListener;
    //   96: ifnull +40 -> 136
    //   99: aload_0
    //   100: getfield 220	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:a	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder$AudioEncodeListener;
    //   103: invokeinterface 223 1 0
    //   108: goto +28 -> 136
    //   111: astore_3
    //   112: goto +30 -> 142
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   120: aload_0
    //   121: getfield 220	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:a	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder$AudioEncodeListener;
    //   124: ifnull +12 -> 136
    //   127: aload_0
    //   128: getfield 220	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:a	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder$AudioEncodeListener;
    //   131: invokeinterface 228 1 0
    //   136: aload_0
    //   137: aconst_null
    //   138: putfield 155	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:f	Landroid/media/MediaMuxer;
    //   141: return
    //   142: aload_0
    //   143: aconst_null
    //   144: putfield 155	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:f	Landroid/media/MediaMuxer;
    //   147: aload_3
    //   148: athrow
    //   149: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	HWAudioEncoder
    //   24	6	1	l1	long
    //   4	71	3	localObject1	Object
    //   111	1	3	localObject2	Object
    //   115	33	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   74	92	111	finally
    //   92	108	111	finally
    //   116	136	111	finally
    //   74	92	115	java/lang/Exception
    //   92	108	115	java/lang/Exception
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(HWAudioEncoder.AudioEncodeListener paramAudioEncodeListener)
  {
    this.a = paramAudioEncodeListener;
  }
  
  public void a(String paramString)
  {
    Handler localHandler = this.c;
    if (localHandler != null) {
      localHandler.obtainMessage(3, paramString).sendToTarget();
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.c != null)
    {
      paramLong = SystemClock.elapsedRealtimeNanos();
      this.c.obtainMessage(1, new Object[] { paramArrayOfByte, Long.valueOf(paramLong) }).sendToTarget();
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    double d1 = paramArrayOfByte.length;
    double d2 = this.m;
    Double.isNaN(d1);
    int i1 = (int)(d1 / d2);
    this.n += i1;
    boolean bool = QLog.isColorLevel();
    Object localObject1 = "HWAudioEncoder";
    if (bool) {
      QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame audioData=%s mAudioDataSize=%s frameTime=%s mLastAudioFrameTime=%s timestampNanos=%s endOfStream=&s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Double.valueOf(this.m), Integer.valueOf(i1), Long.valueOf(this.n), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    }
    Object localObject2 = this.e.getInputBuffers();
    for (int i2 = 0;; i2 = i1)
    {
      int i3 = this.e.dequeueInputBuffer(10000L);
      if (QLog.isColorLevel()) {
        QLog.d((String)localObject1, 2, String.format("handleAudioFrame inputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(i3), Integer.valueOf(i2) }));
      }
      if (i3 >= 0)
      {
        localObject2 = localObject2[i3];
        ((ByteBuffer)localObject2).clear();
        ((ByteBuffer)localObject2).put(paramArrayOfByte);
        this.e.queueInputBuffer(i3, 0, paramArrayOfByte.length, this.n, 0);
      }
      else
      {
        i1 = i2;
        if (i3 != -1) {
          continue;
        }
        if (paramBoolean)
        {
          i2 += 1;
          i1 = i2;
          if (i2 <= 10) {
            continue;
          }
        }
      }
      paramArrayOfByte = this.e.getOutputBuffers();
      for (i2 = 0;; i2 = i1)
      {
        i3 = this.e.dequeueOutputBuffer(this.g, 10000L);
        if (QLog.isColorLevel()) {
          QLog.d((String)localObject1, 2, String.format("handleAudioFrame outputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(i3), Integer.valueOf(i2) }));
        }
        localObject2 = localObject1;
        if (i3 == -1)
        {
          if (paramBoolean)
          {
            i2 += 1;
            i1 = i2;
            localObject1 = paramArrayOfByte;
            if (i2 > 10) {}
          }
        }
        else
        {
          do
          {
            for (;;)
            {
              paramArrayOfByte = (byte[])localObject1;
              break label707;
              if (i3 == -2)
              {
                localObject1 = this.e.getOutputFormat();
                this.i = this.f.addTrack((MediaFormat)localObject1);
                i1 = i2;
                localObject1 = paramArrayOfByte;
                if (!this.j)
                {
                  this.f.start();
                  this.j = true;
                  i1 = i2;
                  localObject1 = paramArrayOfByte;
                }
              }
              else
              {
                if (i3 != -3) {
                  break;
                }
                localObject1 = this.e.getOutputBuffers();
                i1 = i2;
              }
            }
            i1 = i2;
            localObject1 = paramArrayOfByte;
          } while (i3 < 0);
          localObject1 = paramArrayOfByte[i3];
          if ((this.g.flags & 0x2) != 0) {
            this.g.size = 0;
          }
          if ((this.g.size != 0) && (this.j))
          {
            ((ByteBuffer)localObject1).position(this.g.offset);
            ((ByteBuffer)localObject1).limit(this.g.offset + this.g.size);
            if (QLog.isColorLevel()) {
              QLog.d((String)localObject2, 2, String.format("handleAudioFrame presentationTimeUs=%s", new Object[] { Long.valueOf(this.g.presentationTimeUs) }));
            }
            if (this.g.presentationTimeUs >= this.h)
            {
              this.f.writeSampleData(this.i, (ByteBuffer)localObject1, this.g);
              this.h = this.g.presentationTimeUs;
            }
            else
            {
              QLog.e((String)localObject2, 1, "handleAudioFrame audio timestamp revert? throw this frame.");
            }
          }
          this.e.releaseOutputBuffer(i3, false);
          if ((this.g.flags & 0x4) == 0) {
            break label704;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d((String)localObject2, 2, String.format("handleAudioFrame time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
        }
        return;
        label704:
        i1 = 0;
        label707:
        localObject1 = localObject2;
      }
    }
  }
  
  public void b()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.c = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.b = null;
      this.c = null;
    }
  }
  
  public void c()
  {
    Handler localHandler = this.c;
    if (localHandler != null) {
      localHandler.obtainMessage(2).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder
 * JD-Core Version:    0.7.0.1
 */