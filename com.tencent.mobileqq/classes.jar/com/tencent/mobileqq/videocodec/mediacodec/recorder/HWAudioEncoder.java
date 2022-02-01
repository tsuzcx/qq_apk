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
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManagerV2.newFreeHandlerThread("HWAudioEncoder", 0);
  HWAudioEncoder.AudioEncodeListener jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder$AudioEncodeListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public HWAudioEncoder()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new HWAudioEncoder.AudioEncodeHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidMediaMediaFormat = new MediaFormat();
    this.jdField_a_of_type_AndroidMediaMediaFormat.setString("mime", "audio/mp4a-latm");
    int i = CodecParam.mAudioChannel;
    int j = 16;
    if (i == 16) {
      i = 1;
    } else {
      i = 2;
    }
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("channel-count", i);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("sample-rate", this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", 2);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("bitrate", CodecParam.mDstAudioEncBitrate);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("max-input-size", AudioCapture.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
    this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, 1);
    this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    paramString = new File(this.jdField_a_of_type_JavaLangString);
    if (!paramString.exists()) {
      FileUtils.createFileIfNotExits(paramString.getAbsolutePath());
    }
    this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(this.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
    this.jdField_b_of_type_Long = 0L;
    if (CodecParam.mAudioFormat != 2) {
      j = 8;
    }
    double d1 = this.jdField_b_of_type_Int * j * i / 8;
    double d2 = Math.pow(10.0D, 6.0D);
    Double.isNaN(d1);
    this.jdField_a_of_type_Double = (d1 / d2);
  }
  
  private void d() {}
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +8 -> 14
    //   9: aload_3
    //   10: aconst_null
    //   11: invokevirtual 180	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield 116	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   18: ifnull +35 -> 53
    //   21: invokestatic 186	android/os/SystemClock:elapsedRealtimeNanos	()J
    //   24: lstore_1
    //   25: aload_0
    //   26: iconst_0
    //   27: newarray byte
    //   29: lload_1
    //   30: iconst_1
    //   31: invokevirtual 189	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:a	([BJZ)V
    //   34: aload_0
    //   35: getfield 116	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   38: invokevirtual 192	android/media/MediaCodec:stop	()V
    //   41: aload_0
    //   42: getfield 116	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   45: invokevirtual 195	android/media/MediaCodec:release	()V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 116	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   53: aload_0
    //   54: getfield 144	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   57: astore_3
    //   58: aload_3
    //   59: ifnull +90 -> 149
    //   62: aload_0
    //   63: getfield 147	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_Boolean	Z
    //   66: ifeq +83 -> 149
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield 147	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_Boolean	Z
    //   74: aload_3
    //   75: invokevirtual 196	android/media/MediaMuxer:release	()V
    //   78: invokestatic 201	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +11 -> 92
    //   84: ldc 32
    //   86: iconst_2
    //   87: ldc 203
    //   89: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_0
    //   93: getfield 208	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder$AudioEncodeListener	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder$AudioEncodeListener;
    //   96: ifnull +40 -> 136
    //   99: aload_0
    //   100: getfield 208	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder$AudioEncodeListener	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder$AudioEncodeListener;
    //   103: invokeinterface 213 1 0
    //   108: goto +28 -> 136
    //   111: astore_3
    //   112: goto +30 -> 142
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 216	java/lang/Exception:printStackTrace	()V
    //   120: aload_0
    //   121: getfield 208	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder$AudioEncodeListener	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder$AudioEncodeListener;
    //   124: ifnull +12 -> 136
    //   127: aload_0
    //   128: getfield 208	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder$AudioEncodeListener	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder$AudioEncodeListener;
    //   131: invokeinterface 217 1 0
    //   136: aload_0
    //   137: aconst_null
    //   138: putfield 144	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   141: return
    //   142: aload_0
    //   143: aconst_null
    //   144: putfield 144	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWAudioEncoder:jdField_a_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
    //   147: aload_3
    //   148: athrow
    //   149: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	HWAudioEncoder
    //   24	6	1	l	long
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
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(HWAudioEncoder.AudioEncodeListener paramAudioEncodeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder$AudioEncodeListener = paramAudioEncodeListener;
  }
  
  public void a(String paramString)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.obtainMessage(3, paramString).sendToTarget();
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      paramLong = SystemClock.elapsedRealtimeNanos();
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { paramArrayOfByte, Long.valueOf(paramLong) }).sendToTarget();
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    double d1 = paramArrayOfByte.length;
    double d2 = this.jdField_a_of_type_Double;
    Double.isNaN(d1);
    int i = (int)(d1 / d2);
    this.jdField_b_of_type_Long += i;
    boolean bool = QLog.isColorLevel();
    Object localObject1 = "HWAudioEncoder";
    if (bool) {
      QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame audioData=%s mAudioDataSize=%s frameTime=%s mLastAudioFrameTime=%s timestampNanos=%s endOfStream=&s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Double.valueOf(this.jdField_a_of_type_Double), Integer.valueOf(i), Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    }
    Object localObject2 = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
    for (int j = 0;; j = i)
    {
      int k = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
      if (QLog.isColorLevel()) {
        QLog.d((String)localObject1, 2, String.format("handleAudioFrame inputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j) }));
      }
      if (k >= 0)
      {
        localObject2 = localObject2[k];
        ((ByteBuffer)localObject2).clear();
        ((ByteBuffer)localObject2).put(paramArrayOfByte);
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(k, 0, paramArrayOfByte.length, this.jdField_b_of_type_Long, 0);
      }
      else
      {
        i = j;
        if (k != -1) {
          continue;
        }
        if (paramBoolean)
        {
          j += 1;
          i = j;
          if (j <= 10) {
            continue;
          }
        }
      }
      paramArrayOfByte = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      for (j = 0;; j = i)
      {
        k = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
        if (QLog.isColorLevel()) {
          QLog.d((String)localObject1, 2, String.format("handleAudioFrame outputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j) }));
        }
        localObject2 = localObject1;
        if (k == -1)
        {
          if (paramBoolean)
          {
            j += 1;
            i = j;
            localObject1 = paramArrayOfByte;
            if (j > 10) {}
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
              if (k == -2)
              {
                localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
                this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject1);
                i = j;
                localObject1 = paramArrayOfByte;
                if (!this.jdField_a_of_type_Boolean)
                {
                  this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
                  this.jdField_a_of_type_Boolean = true;
                  i = j;
                  localObject1 = paramArrayOfByte;
                }
              }
              else
              {
                if (k != -3) {
                  break;
                }
                localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
                i = j;
              }
            }
            i = j;
            localObject1 = paramArrayOfByte;
          } while (k < 0);
          localObject1 = paramArrayOfByte[k];
          if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0) {
            this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
          }
          if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0) && (this.jdField_a_of_type_Boolean))
          {
            ((ByteBuffer)localObject1).position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
            ((ByteBuffer)localObject1).limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
            if (QLog.isColorLevel()) {
              QLog.d((String)localObject2, 2, String.format("handleAudioFrame presentationTimeUs=%s", new Object[] { Long.valueOf(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs) }));
            }
            if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs >= this.jdField_a_of_type_Long)
            {
              this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Int, (ByteBuffer)localObject1, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
              this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
            }
            else
            {
              QLog.e((String)localObject2, 1, "handleAudioFrame audio timestamp revert? throw this frame.");
            }
          }
          this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(k, false);
          if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0) {
            break label704;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d((String)localObject2, 2, String.format("handleAudioFrame time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
        }
        return;
        label704:
        i = 0;
        label707:
        localObject1 = localObject2;
      }
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public void c()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.obtainMessage(2).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder
 * JD-Core Version:    0.7.0.1
 */