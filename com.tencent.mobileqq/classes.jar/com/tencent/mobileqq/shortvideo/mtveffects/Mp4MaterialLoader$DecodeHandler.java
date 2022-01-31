package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import java.lang.ref.WeakReference;

class Mp4MaterialLoader$DecodeHandler
  extends Handler
{
  private WeakReference<HWVideoDecoder> mDecoderRef;
  
  public Mp4MaterialLoader$DecodeHandler(Looper paramLooper, HWVideoDecoder paramHWVideoDecoder)
  {
    super(paramLooper);
    this.mDecoderRef = new WeakReference(paramHWVideoDecoder);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    HWVideoDecoder localHWVideoDecoder = (HWVideoDecoder)this.mDecoderRef.get();
    if (localHWVideoDecoder == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (i)
          {
          default: 
            return;
          }
        } while (paramMessage.obj == null);
        long l = ((Long)paramMessage.obj).longValue();
        if (l >= 0L) {
          localHWVideoDecoder.nextTo(l);
        }
        localHWVideoDecoder.decodeFrame();
        return;
      } while (paramMessage.obj == null);
      paramMessage = (Object[])paramMessage.obj;
    } while (paramMessage.length != 3);
    localHWVideoDecoder.startDecode(new DecodeConfig((String)paramMessage[1], 0, true, false), ((Integer)paramMessage[0]).intValue(), (SurfaceTexture.OnFrameAvailableListener)paramMessage[2], (HWDecodeListener)paramMessage[2]);
    return;
    localHWVideoDecoder.pauseDecode();
    return;
    localHWVideoDecoder.resumeDecode();
    return;
    localHWVideoDecoder.stopDecode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.Mp4MaterialLoader.DecodeHandler
 * JD-Core Version:    0.7.0.1
 */