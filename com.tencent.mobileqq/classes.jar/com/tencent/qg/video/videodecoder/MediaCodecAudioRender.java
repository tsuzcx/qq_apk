package com.tencent.qg.video.videodecoder;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AudioSampleRateExtract;
import com.tencent.mobileqq.editor.composite.step.AudioDataUtil;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.videocodec.audio.AudioDecodeConfig;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.util.Pair;
import java.nio.ByteBuffer;

@TargetApi(16)
public class MediaCodecAudioRender
  extends MediaCodecRender
{
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public AudioDecodeConfig a;
  private MediaCodecAudioRender.AudioDecodeHandler jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecAudioRender$AudioDecodeHandler;
  
  private AudioTrack a()
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.e != 1) {
          break label113;
        }
        i = 4;
        if (this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.b != 16) {
          break label119;
        }
        j = 2;
        int k = AudioTrack.getMinBufferSize(this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.d, i, j);
        ReportAudioTrack localReportAudioTrack = new ReportAudioTrack(3, this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.d, i, j, k, 1);
        try
        {
          localReportAudioTrack.play();
          return localReportAudioTrack;
        }
        catch (Throwable localThrowable1)
        {
          localObject = localReportAudioTrack;
        }
        SLog.c("Q.qqstory.mediadecoderMediaCodecAudioRender", "AudioTrack init fail :%s", localThrowable2);
      }
      catch (Throwable localThrowable2) {}
      return localObject;
      label113:
      int i = 12;
      continue;
      label119:
      int j = 3;
    }
  }
  
  private void a(AudioTrack paramAudioTrack, byte[] paramArrayOfByte, int paramInt)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_Int;
    int i = 1;
    byte[] arrayOfByte;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (!this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaContext.a) {
              paramAudioTrack.write(paramArrayOfByte, 0, paramInt);
            }
            paramArrayOfByte = null;
            j = 0;
            paramInt = i;
            i = j;
            break label179;
          }
          paramInt = paramArrayOfByte.length * 4;
          arrayOfByte = new byte[paramInt];
          AudioDataUtil.a(paramArrayOfByte, 0, arrayOfByte, paramInt, 4);
          paramArrayOfByte = arrayOfByte;
        }
        else
        {
          paramInt = paramArrayOfByte.length * 2 / 3;
          arrayOfByte = new byte[paramInt];
          AudioDataUtil.b(paramArrayOfByte, 0, arrayOfByte, paramInt);
          paramArrayOfByte = arrayOfByte;
        }
      }
      else
      {
        paramInt = paramArrayOfByte.length * 2;
        arrayOfByte = new byte[paramInt];
        AudioDataUtil.a(paramArrayOfByte, 0, arrayOfByte, paramInt, 2);
        paramArrayOfByte = arrayOfByte;
      }
    }
    else
    {
      paramInt = paramArrayOfByte.length / 2;
      arrayOfByte = new byte[paramInt];
      AudioDataUtil.a(paramArrayOfByte, 0, arrayOfByte, paramInt);
      paramArrayOfByte = arrayOfByte;
    }
    j = 0;
    i = paramInt;
    paramInt = j;
    label179:
    if ((!this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaContext.a) && (paramInt == 0) && (paramArrayOfByte != null)) {
      paramAudioTrack.write(paramArrayOfByte, 0, i);
    }
  }
  
  public long a(long paramLong)
  {
    this.jdField_a_of_type_AndroidMediaAudioTrack.flush();
    return super.a(paramLong);
  }
  
  protected String a()
  {
    return "Q.qqstory.mediadecoderMediaCodecAudioRender";
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidMediaAudioTrack.play();
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo)
  {
    int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 10000L);
    if (i != -3)
    {
      if (i != -2)
      {
        if (i != -1)
        {
          if ((paramBufferInfo.flags & 0x4) != 0)
          {
            SLog.b("Q.qqstory.mediadecoderMediaCodecAudioRender", "output EOS");
            this.jdField_b_of_type_Boolean = true;
          }
          try
          {
            Object localObject = this.jdField_b_of_type_ArrayOfJavaNioByteBuffer[i];
            if (localObject == null)
            {
              SLog.e("Q.qqstory.mediadecoderMediaCodecAudioRender", "find no data");
              return;
            }
            if (paramBufferInfo.size != 0)
            {
              ((ByteBuffer)localObject).position(paramBufferInfo.offset);
              ((ByteBuffer)localObject).limit(paramBufferInfo.offset + paramBufferInfo.size);
            }
            int j = ((ByteBuffer)localObject).remaining();
            paramBufferInfo = new byte[j];
            ((ByteBuffer)localObject).get(paramBufferInfo, 0, j);
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = new Pair(paramBufferInfo, Integer.valueOf(j));
            this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecAudioRender$AudioDecodeHandler.sendMessage((Message)localObject);
            paramMediaCodec.releaseOutputBuffer(i, false);
            return;
          }
          catch (Exception paramMediaCodec)
          {
            SLog.c("Q.qqstory.mediadecoderMediaCodecAudioRender", "handle data error :%s", paramMediaCodec);
            return;
          }
        }
        SLog.b("Q.qqstory.mediadecoderMediaCodecAudioRender", "dequeueOutputBuffer timed out!");
        return;
      }
      paramBufferInfo = new StringBuilder();
      paramBufferInfo.append("New format ");
      paramBufferInfo.append(paramMediaCodec.getOutputFormat());
      SLog.b("Q.qqstory.mediadecoderMediaCodecAudioRender", paramBufferInfo.toString());
      return;
    }
    SLog.b("Q.qqstory.mediadecoderMediaCodecAudioRender", "INFO_OUTPUT_BUFFERS_CHANGED");
    this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = paramMediaCodec.getOutputBuffers();
  }
  
  protected void a(MediaCodecRender.MediaCodecInfo paramMediaCodecInfo, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.e = paramMediaFormat.getInteger("channel-count");
      this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.d = AudioSampleRateExtract.a(paramMediaFormat);
    }
    catch (Throwable paramMediaCodecInfo)
    {
      paramMediaCodecInfo.printStackTrace();
    }
    paramMediaCodecInfo = new StringBuilder();
    paramMediaCodecInfo.append("config after b=");
    paramMediaCodecInfo.append(this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.c);
    paramMediaCodecInfo.append(" c=");
    paramMediaCodecInfo.append(this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.e);
    paramMediaCodecInfo.append(" sc=");
    paramMediaCodecInfo.append(this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.d);
    SLog.b("Q.qqstory.mediadecoderMediaCodecAudioRender", paramMediaCodecInfo.toString());
    paramMediaCodec.configure(paramMediaFormat, null, null, 0);
    this.jdField_a_of_type_AndroidMediaAudioTrack = a();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("mc_audio_thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecAudioRender$AudioDecodeHandler = new MediaCodecAudioRender.AudioDecodeHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public void b()
  {
    super.b();
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioTrack;
    if (localObject != null)
    {
      ((AudioTrack)localObject).stop();
      this.jdField_a_of_type_AndroidMediaAudioTrack.release();
      this.jdField_a_of_type_AndroidMediaAudioTrack = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (localObject != null)
    {
      ((HandlerThread)localObject).getLooper().quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecAudioRender$AudioDecodeHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaCodecAudioRender
 * JD-Core Version:    0.7.0.1
 */