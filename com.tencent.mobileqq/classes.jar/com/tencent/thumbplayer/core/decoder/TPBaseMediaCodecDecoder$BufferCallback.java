package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.tmediacodec.TMediaCodec;
import com.tencent.tmediacodec.TMediaCodec.Callback;
import java.util.concurrent.BlockingQueue;

@RequiresApi(api=21)
class TPBaseMediaCodecDecoder$BufferCallback
  extends TMediaCodec.Callback
{
  private TPBaseMediaCodecDecoder$BufferCallback(TPBaseMediaCodecDecoder paramTPBaseMediaCodecDecoder) {}
  
  public void onError(@NonNull TMediaCodec paramTMediaCodec, @NonNull MediaCodec.CodecException paramCodecException)
  {
    paramTMediaCodec = this.this$0.getLogTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError: ");
    localStringBuilder.append(this.this$0.getStackTrace(paramCodecException));
    TPNativeLog.printLog(4, paramTMediaCodec, localStringBuilder.toString());
    TPBaseMediaCodecDecoder.access$300(this.this$0);
  }
  
  public void onInputBufferAvailable(@NonNull TMediaCodec paramTMediaCodec, int paramInt)
  {
    try
    {
      TPBaseMediaCodecDecoder.access$100(this.this$0).put(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception paramTMediaCodec)
    {
      TPNativeLog.printLog(3, this.this$0.getLogTag(), this.this$0.getStackTrace(paramTMediaCodec));
    }
  }
  
  public void onOutputBufferAvailable(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      TPFrameInfo localTPFrameInfo = new TPFrameInfo();
      localTPFrameInfo.errCode = 0;
      localTPFrameInfo.bufferIndex = paramInt;
      localTPFrameInfo.ptsUs = paramBufferInfo.presentationTimeUs;
      this.this$0.processOutputBuffer(paramTMediaCodec, paramInt, paramBufferInfo, localTPFrameInfo);
      TPBaseMediaCodecDecoder.access$200(this.this$0).put(localTPFrameInfo);
      return;
    }
    catch (Exception paramTMediaCodec)
    {
      TPNativeLog.printLog(3, this.this$0.getLogTag(), this.this$0.getStackTrace(paramTMediaCodec));
    }
  }
  
  public void onOutputFormatChanged(@NonNull TMediaCodec paramTMediaCodec, @NonNull MediaFormat paramMediaFormat)
  {
    this.this$0.processOutputFormatChanged(paramMediaFormat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder.BufferCallback
 * JD-Core Version:    0.7.0.1
 */