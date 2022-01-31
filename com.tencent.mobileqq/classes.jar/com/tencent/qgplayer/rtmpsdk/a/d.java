package com.tencent.qgplayer.rtmpsdk.a;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import com.tencent.qgplayer.rtmpsdk.QGLog;
import com.tencent.qgplayer.rtmpsdk.QGPlayerNativeManager;
import java.nio.ByteBuffer;

public class d
  extends e
{
  private a e = new a();
  private MediaFormat f;
  private boolean g;
  
  d(Context paramContext)
  {
    super(paramContext, 1);
  }
  
  void a()
  {
    this.e.a(this.c);
  }
  
  public void a(float paramFloat)
  {
    if (this.e != null) {
      this.e.a(paramFloat);
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.f == null)
    {
      QGLog.i("QGPlayer.MediaCodecAudioDecoder", "setAudioCodecFormat sampleRate = " + paramInt1 + ", channelCount = " + paramInt2);
      this.f = new MediaFormat();
      this.f.setString("mime", "audio/mp4a-latm");
      this.f.setInteger("sample-rate", paramInt1);
      this.f.setInteger("channel-count", paramInt2);
      this.f.setInteger("is-adts", 1);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[] { 17, -112 });
      this.f.setByteBuffer("csd-0", localByteBuffer);
    }
    try
    {
      this.e.a(paramInt1, paramInt2, 2);
      return;
    }
    catch (Exception localException)
    {
      this.g = true;
      QGLog.e("QGPlayer.MediaCodecAudioDecoder", "audio player config fail, throwable = " + localException.toString());
    }
  }
  
  void a(MediaCodec paramMediaCodec)
  {
    if (this.f != null)
    {
      paramMediaCodec.configure(this.f, null, null, 0);
      QGLog.i("QGPlayer.MediaCodecAudioDecoder", "configure audio codec success");
    }
  }
  
  void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    if ((this.e != null) && (!this.g)) {}
    try
    {
      this.e.a(paramByteBuffer, paramLong);
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      return;
    }
    catch (Exception paramMediaCodec)
    {
      this.g = true;
      QGLog.e("QGPlayer.MediaCodecAudioDecoder", "processOutputBuffer exception, throwable = " + paramMediaCodec.toString());
    }
  }
  
  void a(b paramb)
  {
    if ((paramb != null) && (paramb.g()))
    {
      paramb.a();
      QGLog.i("QGPlayer.MediaCodecAudioDecoder", "onUnvailableInput , reach the upper limit of unvailable input index audio");
      paramb = new Bundle();
      paramb.putString("event_description", "aac reach the upper limit of unvailable input index audio");
      QGPlayerNativeManager.dispatchPlayEvent(this.c, 2303, paramb);
    }
  }
  
  void a(Exception paramException)
  {
    paramException = new Bundle();
    paramException.putString("event_description", "aac audio render exception");
    QGPlayerNativeManager.dispatchPlayEvent(this.c, 2303, paramException);
  }
  
  void b()
  {
    this.e.a();
    this.g = false;
  }
  
  void b(b paramb)
  {
    if ((paramb != null) && (paramb.h()))
    {
      paramb.b();
      QGLog.i("QGPlayer.MediaCodecAudioDecoder", "onUnvailableOutput , reach the upper limit of unvailable output index audio");
      paramb = new Bundle();
      paramb.putString("event_description", "aac reach the upper limit of unvailable output index audio");
      QGPlayerNativeManager.dispatchPlayEvent(this.c, 2303, paramb);
    }
  }
  
  void b(Exception paramException)
  {
    paramException = new Bundle();
    paramException.putString("event_description", "init aac audio Decoder exception");
    QGPlayerNativeManager.dispatchPlayEvent(this.c, 2303, paramException);
  }
  
  String c()
  {
    return "QGPlayer.MediaCodecAudioDecoder";
  }
  
  String d()
  {
    return "audio/mp4a-latm";
  }
  
  boolean e()
  {
    if ((i() != null) || (this.f == null))
    {
      QGLog.e("QGPlayer.MediaCodecAudioDecoder", "init audio decoder error, deocder = " + i() + ",mFormat = " + this.f);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.a.d
 * JD-Core Version:    0.7.0.1
 */