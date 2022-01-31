package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import java.util.concurrent.BlockingQueue;

@RequiresApi(api=21)
class TPBaseMediaCodecDecoder$BufferCallback
  extends MediaCodec.Callback
{
  private TPBaseMediaCodecDecoder$BufferCallback(TPBaseMediaCodecDecoder paramTPBaseMediaCodecDecoder) {}
  
  public void onError(@NonNull MediaCodec paramMediaCodec, @NonNull MediaCodec.CodecException paramCodecException)
  {
    TPNativeLog.printLog(4, this.this$0.getLogTag(), "onError: " + this.this$0.getStackTrace(paramCodecException));
    TPBaseMediaCodecDecoder.access$300(this.this$0);
  }
  
  public void onInputBufferAvailable(@NonNull MediaCodec paramMediaCodec, int paramInt)
  {
    try
    {
      TPBaseMediaCodecDecoder.access$100(this.this$0).put(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception paramMediaCodec)
    {
      TPNativeLog.printLog(3, this.this$0.getLogTag(), this.this$0.getStackTrace(paramMediaCodec));
    }
  }
  
  public void onOutputBufferAvailable(@NonNull MediaCodec paramMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      TPFrameInfo localTPFrameInfo = new TPFrameInfo();
      localTPFrameInfo.errCode = 0;
      localTPFrameInfo.bufferIndex = paramInt;
      localTPFrameInfo.ptsUs = paramBufferInfo.presentationTimeUs;
      this.this$0.processOutputBuffer(paramMediaCodec, paramInt, paramBufferInfo, localTPFrameInfo);
      TPBaseMediaCodecDecoder.access$200(this.this$0).put(localTPFrameInfo);
      return;
    }
    catch (Exception paramMediaCodec)
    {
      TPNativeLog.printLog(3, this.this$0.getLogTag(), this.this$0.getStackTrace(paramMediaCodec));
    }
  }
  
  public void onOutputFormatChanged(@NonNull MediaCodec paramMediaCodec, @NonNull MediaFormat paramMediaFormat)
  {
    this.this$0.processOutputFormatChanged(paramMediaFormat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder.BufferCallback
 * JD-Core Version:    0.7.0.1
 */