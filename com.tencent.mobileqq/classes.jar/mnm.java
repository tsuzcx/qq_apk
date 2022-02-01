import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;

@TargetApi(18)
public class mnm
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private String jdField_a_of_type_JavaLangString;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private mnr jdField_a_of_type_Mnr;
  public volatile boolean a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private MediaCodec jdField_b_of_type_AndroidMediaMediaCodec;
  public volatile boolean b;
  private long c;
  public volatile boolean c;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  
  public mnm(mnr parammnr)
  {
    this.jdField_a_of_type_Mnr = parammnr;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavRecordEncoder", 2, "sending EOS to encoder");
      }
      this.jdField_a_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
    }
    ByteBuffer[] arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    int i = 0;
    for (;;)
    {
      int j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
      if (j == -1) {
        if (!paramBoolean) {
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "no output available yet");
          }
        }
      }
      label513:
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QavRecordEncoder", 2, "no output available, spinning to await EOS");
        }
        j = i + 1;
        i = j;
        if (j <= 100) {
          break;
        }
        throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
        if (j == -3)
        {
          arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          break;
        }
        if (j == -2)
        {
          if (this.jdField_a_of_type_Boolean) {
            throw new RuntimeException("format changed twice");
          }
          localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "encoder output format changed: " + localObject);
          }
          this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
          if ((!this.jdField_c_of_type_Boolean) && ((this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean)))
          {
            this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
            this.jdField_c_of_type_Boolean = true;
            if (this.jdField_a_of_type_Mnr.a != null) {
              this.jdField_a_of_type_Mnr.a.j();
            }
          }
          this.jdField_a_of_type_Boolean = true;
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          break;
        }
        if (j < 0)
        {
          QLog.w("QavRecordEncoder", 2, "unexpected result from encoder.dequeueOutputBuffer: " + j);
          break;
        }
        Object localObject = arrayOfByteBuffer[j];
        if (localObject == null) {
          throw new RuntimeException("encoderOutputBuffer " + j + " was null");
        }
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
          }
          this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
        }
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0) && (this.jdField_c_of_type_Boolean))
        {
          ((ByteBuffer)localObject).position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
          ((ByteBuffer)localObject).limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
          if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs < this.jdField_c_of_type_Long) {
            break label513;
          }
          this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
          this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Int, (ByteBuffer)localObject, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
          if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0) {
            break label539;
          }
          if (paramBoolean) {
            break;
          }
          QLog.w("QavRecordEncoder", 2, "reached end of stream unexpectedly");
          return;
          QLog.e("QavRecordEncoder", 1, "handleVideoFrame, find older frame");
        }
      } while (!QLog.isColorLevel());
      QLog.d("QavRecordEncoder", 2, "end of stream reached");
      return;
      label539:
      i = 0;
    }
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(batj parambatj)
  {
    this.jdField_a_of_type_JavaLangString = parambatj.jdField_a_of_type_JavaLangString;
    Object localObject = MediaFormat.createVideoFormat("video/avc", parambatj.jdField_a_of_type_Int, parambatj.jdField_b_of_type_Int);
    ((MediaFormat)localObject).setInteger("color-format", 2130708361);
    ((MediaFormat)localObject).setInteger("bitrate", parambatj.c);
    ((MediaFormat)localObject).setInteger("frame-rate", parambatj.d);
    ((MediaFormat)localObject).setInteger("i-frame-interval", parambatj.e);
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "VideoFormat: " + localObject);
    }
    if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
      this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(32768);
    }
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("video/avc");
    this.jdField_a_of_type_AndroidMediaMediaCodec.configure((MediaFormat)localObject, null, null, 1);
    this.jdField_a_of_type_AndroidViewSurface = this.jdField_a_of_type_AndroidMediaMediaCodec.createInputSurface();
    this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidMediaMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", 2);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("channel-mask", 12);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("bitrate", 128000);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("channel-count", 1);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("sample-rate", 48000);
    this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("max-input-size", 32768);
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "AudioFormat: " + this.jdField_a_of_type_AndroidMediaMediaFormat);
    }
    this.jdField_b_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
    if (this.jdField_b_of_type_AndroidMediaMediaCodec != null)
    {
      this.jdField_b_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, 1);
      this.jdField_b_of_type_AndroidMediaMediaCodec.start();
    }
    localObject = new File(parambatj.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordEncoder", 2, "start, before check file, exits[" + ((File)localObject).exists() + "]");
    }
    if (!((File)localObject).exists()) {
      bgmg.c(((File)localObject).getAbsolutePath());
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordEncoder", 2, "start, end of check file, exits[" + ((File)localObject).exists() + "]");
    }
    this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(parambatj.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(parambatj.g);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Long = (System.currentTimeMillis() + 99999999L);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    if (this.jdField_b_of_type_AndroidMediaMediaCodec == null) {
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  protected void a(mnd parammnd, boolean paramBoolean)
  {
    if (AudioHelper.f()) {
      QLog.w("QavRecordEncoder", 1, "handleAudioFrame, frame[" + parammnd + "], endOfStream[" + paramBoolean + "], mNoAudio[" + this.jdField_d_of_type_Boolean + "]");
    }
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaNioByteBuffer.clear();
    this.jdField_a_of_type_JavaNioByteBuffer.put(parammnd.a);
    this.jdField_a_of_type_JavaNioByteBuffer.position(parammnd.a.length);
    this.jdField_a_of_type_JavaNioByteBuffer.flip();
    Object localObject = this.jdField_b_of_type_AndroidMediaMediaCodec.getInputBuffers();
    int i = 0;
    label121:
    int j = this.jdField_b_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    if (j >= 0)
    {
      localObject = localObject[j];
      ((ByteBuffer)localObject).clear();
      ((ByteBuffer)localObject).put(this.jdField_a_of_type_JavaNioByteBuffer);
      this.jdField_b_of_type_AndroidMediaMediaCodec.queueInputBuffer(j, 0, parammnd.a.length, parammnd.jdField_b_of_type_Long, 0);
      if (QLog.isColorLevel()) {
        QLog.d("QavRecordEncoder", 2, "encode, write to codec, size=" + parammnd.a.length);
      }
      label217:
      parammnd = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      i = 0;
    }
    for (;;)
    {
      j = this.jdField_b_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
      if (j == -1)
      {
        if (!paramBoolean)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QavRecordEncoder", 2, "no output available yet");
          return;
          if (j != -1) {
            break label121;
          }
          if (!paramBoolean)
          {
            if (!QLog.isColorLevel()) {
              break label217;
            }
            QLog.d("QavRecordEncoder", 2, "encode, encode, no output available yet");
            break label217;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "encode, encode, no output available, spinning to await EOS");
          }
          j = i + 1;
          i = j;
          if (j <= 10) {
            break label121;
          }
          break label217;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavRecordEncoder", 2, "no output available, spinning to await EOS");
        }
        j = i + 1;
        i = j;
        if (j <= 10) {
          continue;
        }
        return;
      }
      if (j == -3)
      {
        parammnd = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      }
      else if (j == -2)
      {
        if (this.jdField_b_of_type_Boolean) {
          throw new RuntimeException("format changed twice");
        }
        localObject = this.jdField_b_of_type_AndroidMediaMediaCodec.getOutputFormat();
        this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
        if (QLog.isColorLevel()) {
          QLog.w("QavRecordEncoder", 1, "encoder output format changed, newFormat[" + localObject + "], mAudioTrackIndex[" + this.jdField_b_of_type_Int + "]");
        }
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
          if (this.jdField_a_of_type_Mnr.a != null) {
            this.jdField_a_of_type_Mnr.a.j();
          }
        }
        this.jdField_b_of_type_Boolean = true;
      }
      else if (j < 0)
      {
        QLog.w("QavRecordEncoder", 2, "unexpected result from encoder.dequeueOutputBuffer: " + j);
      }
      else
      {
        localObject = parammnd[j];
        if (localObject == null) {
          throw new RuntimeException("encoderOutputBuffer " + j + " was null");
        }
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
          }
          this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
        }
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0) && (this.jdField_c_of_type_Boolean))
        {
          ((ByteBuffer)localObject).position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
          ((ByteBuffer)localObject).limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
          if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs < this.jdField_b_of_type_Long) {
            break label772;
          }
          this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
          this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_b_of_type_Int, (ByteBuffer)localObject, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
          if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0) {
            break label799;
          }
          if (paramBoolean) {
            break;
          }
          QLog.w("QavRecordEncoder", 2, "reached end of stream unexpectedly");
          return;
          label772:
          QLog.e("QavRecordEncoder", 1, "handleAudioFrame, find older frame");
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QavRecordEncoder", 2, "end of stream reached");
        return;
        label799:
        i = 0;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = (1L + l);
    paramArrayOfByte = new mnd(paramArrayOfByte, l);
    paramArrayOfByte.jdField_b_of_type_Long = paramLong;
    a(paramArrayOfByte, false);
  }
  
  public boolean a()
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
      return false;
    }
    long l = System.currentTimeMillis();
    if (l - this.jdField_d_of_type_Long > 2000L)
    {
      QLog.d("QavRecordEncoder", 1, "onAudioTrackTimeout has timeout, ready=" + this.jdField_d_of_type_Long + ", now=" + l);
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_Mnr.a != null) {
          this.jdField_a_of_type_Mnr.a.j();
        }
      }
      mno.e();
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordEncoder", 2, "QavRecordEncoder stop.");
    }
    long l = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = (1L + l);
    mnd localmnd = new mnd(new byte[0], l);
    localmnd.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    a(localmnd, true);
    a(true);
    c();
    if (this.jdField_a_of_type_JavaNioByteBuffer != null)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_AndroidMediaMediaCodec != null) {}
    try
    {
      this.jdField_b_of_type_AndroidMediaMediaCodec.stop();
    }
    catch (Exception localException3)
    {
      try
      {
        this.jdField_b_of_type_AndroidMediaMediaCodec.release();
        this.jdField_b_of_type_AndroidMediaMediaCodec = null;
        if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {}
      }
      catch (Exception localException3)
      {
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              this.jdField_a_of_type_AndroidMediaMediaCodec.release();
              this.jdField_a_of_type_AndroidMediaMediaCodec = null;
              if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null) {}
              try
              {
                if (this.jdField_c_of_type_Boolean)
                {
                  this.jdField_c_of_type_Boolean = false;
                  this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
                }
                this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
              }
              catch (Exception localException5)
              {
                for (;;)
                {
                  QLog.e("QavRecordEncoder", 2, "Muxer stop exception:" + localException5, localException5);
                }
              }
              this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
              this.jdField_a_of_type_Int = -1;
              this.jdField_b_of_type_Int = -1;
              this.jdField_a_of_type_Boolean = false;
              this.jdField_b_of_type_Boolean = false;
              this.jdField_c_of_type_Boolean = false;
              return;
              localException1 = localException1;
              QLog.w("QavRecordEncoder", 2, "mAudioCodec stop exception:" + localException1);
              continue;
              localException2 = localException2;
              QLog.w("QavRecordEncoder", 2, "mAudioCodec release exception:" + localException2);
              continue;
              localException3 = localException3;
              QLog.w("QavRecordEncoder", 2, "mVideoCodec stop exception:" + localException3);
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              QLog.w("QavRecordEncoder", 2, "mVideoCodec release exception:" + localException4);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mnm
 * JD-Core Version:    0.7.0.1
 */