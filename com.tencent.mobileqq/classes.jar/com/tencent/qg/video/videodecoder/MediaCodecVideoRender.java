package com.tencent.qg.video.videodecoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.biz.qqstory.support.logging.SLog;

@TargetApi(16)
public class MediaCodecVideoRender
  extends MediaCodecRender
{
  private Surface a;
  
  protected String a()
  {
    return "Q.qqstory.mediadecoderMediaCodecVideoRender";
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
          int j = paramBufferInfo.flags;
          boolean bool = true;
          if ((j & 0x4) != 0)
          {
            SLog.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "output EOS");
            this.jdField_b_of_type_Boolean = true;
          }
          if (paramBufferInfo.size == 0) {
            bool = false;
          }
          paramMediaCodec.releaseOutputBuffer(i, bool);
          SLog.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "dequeueOutputBuffer render");
          return;
        }
        SLog.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "dequeueOutputBuffer timed out!");
        return;
      }
      paramMediaCodec = new StringBuilder();
      paramMediaCodec.append("New format ");
      paramMediaCodec.append(this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat());
      SLog.b("Q.qqstory.mediadecoderMediaCodecVideoRender", paramMediaCodec.toString());
      return;
    }
    SLog.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "INFO_OUTPUT_BUFFERS_CHANGED");
    this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = paramMediaCodec.getOutputBuffers();
  }
  
  protected void a(MediaCodecRender.MediaCodecInfo paramMediaCodecInfo, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec.configure(paramMediaFormat, this.jdField_a_of_type_AndroidViewSurface, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaCodecVideoRender
 * JD-Core Version:    0.7.0.1
 */