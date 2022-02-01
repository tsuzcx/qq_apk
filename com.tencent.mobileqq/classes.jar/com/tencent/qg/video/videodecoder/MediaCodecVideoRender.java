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
            this.h = true;
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
      paramMediaCodec.append(this.c.getOutputFormat());
      SLog.b("Q.qqstory.mediadecoderMediaCodecVideoRender", paramMediaCodec.toString());
      return;
    }
    SLog.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "INFO_OUTPUT_BUFFERS_CHANGED");
    this.e = paramMediaCodec.getOutputBuffers();
  }
  
  protected void a(MediaCodecRender.MediaCodecInfo paramMediaCodecInfo, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec.configure(paramMediaFormat, this.a, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaCodecVideoRender
 * JD-Core Version:    0.7.0.1
 */