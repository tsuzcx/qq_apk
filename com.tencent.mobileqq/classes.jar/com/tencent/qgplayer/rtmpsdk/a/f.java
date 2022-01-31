package com.tencent.qgplayer.rtmpsdk.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.qgplayer.rtmpsdk.QGLog;
import com.tencent.qgplayer.rtmpsdk.QGPlayerNativeManager;
import java.nio.ByteBuffer;

class f
  extends e
{
  private static boolean l = false;
  private static boolean m = false;
  private int e = 950;
  private int f = 540;
  private boolean g = true;
  private c h;
  private SurfaceTexture i;
  private int j = 0;
  private String k = "video/avc";
  
  f(Context paramContext)
  {
    super(paramContext, 2);
  }
  
  private static void a(MediaCodec paramMediaCodec, int paramInt)
  {
    paramMediaCodec.setVideoScalingMode(paramInt);
  }
  
  @TargetApi(23)
  private static void a(MediaCodec paramMediaCodec, SurfaceTexture paramSurfaceTexture)
  {
    paramMediaCodec.setOutputSurface(new Surface(paramSurfaceTexture));
  }
  
  void a() {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      if (this.j != 1) {
        break label77;
      }
      if (!l)
      {
        m = QGPlayerNativeManager.isSupportSpecifiedDecode("video/hevc");
        l = true;
      }
      j();
      if (!m) {
        break label64;
      }
    }
    label64:
    label77:
    for (this.k = "video/hevc";; this.k = "video/avc")
    {
      super.a(paramArrayOfByte, paramBoolean, paramLong);
      return;
      QGPlayerNativeManager.onThrowMediaCodecException(this.c, this.j, 4);
      return;
    }
  }
  
  void a(@NonNull SurfaceTexture paramSurfaceTexture)
  {
    if (this.i != paramSurfaceTexture)
    {
      this.i = paramSurfaceTexture;
      MediaCodec localMediaCodec = i();
      if (localMediaCodec != null)
      {
        if (com.tencent.qgplayer.rtmpsdk.c.e.a < 23) {
          break label36;
        }
        a(localMediaCodec, paramSurfaceTexture);
      }
    }
    return;
    label36:
    j();
    g();
  }
  
  void a(MediaCodec paramMediaCodec)
  {
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.k, this.e, this.f);
    Surface localSurface = new Surface(this.i);
    QGLog.i("QGPlayer.MediaCodecVideoDecoder", "create MediaFormat success, surface.isValid = " + localSurface.isValid() + ",width =" + this.e + ", height = " + this.f);
    paramMediaCodec.configure(localMediaFormat, localSurface, null, 0);
    QGLog.i("QGPlayer.MediaCodecVideoDecoder", "config Decoder success");
    a(paramMediaCodec, 1);
    QGLog.i("QGPlayer.MediaCodecVideoDecoder", "setVideoScalingMode success");
  }
  
  void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    boolean bool = true;
    if ((this.d > 0L) && (paramLong < this.d)) {
      bool = false;
    }
    for (;;)
    {
      paramMediaCodec.releaseOutputBuffer(paramInt, bool);
      if ((paramBufferInfo.flags & 0x4) != 0) {
        QGLog.i("QGPlayer.MediaCodecVideoDecoder", "processOutputBuffer output EOS");
      }
      return;
      this.d = 0L;
    }
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    QGLog.i("QGPlayer.MediaCodecVideoDecoder", "onFormatChanged new format = " + paramMediaFormat);
    int i1;
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top")))
    {
      i1 = 1;
      if (i1 == 0) {
        break label241;
      }
      n = paramMediaFormat.getInteger("crop-right") - paramMediaFormat.getInteger("crop-left") + 1;
      label84:
      if (i1 == 0) {
        break label251;
      }
      i1 = paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top") + 1;
      label106:
      if ((this.e == n) && (this.f == i1)) {
        break label262;
      }
      QGLog.i("QGPlayer.MediaCodecVideoDecoder", "onFormatChanged, curWidth = " + this.e + ", newWidth = " + n + ", curHeight = " + this.f + ", newHeight=" + i1);
      this.e = n;
      this.f = i1;
    }
    label262:
    for (int n = 1;; n = 0)
    {
      if ((this.g) || (n != 0))
      {
        this.g = true;
        if (this.h != null) {
          this.h.a(this.e, this.f);
        }
      }
      return;
      i1 = 0;
      break;
      label241:
      n = paramMediaFormat.getInteger("width");
      break label84;
      label251:
      i1 = paramMediaFormat.getInteger("height");
      break label106;
    }
  }
  
  void a(b paramb)
  {
    if ((paramb != null) && (paramb.e()))
    {
      paramb.a();
      QGPlayerNativeManager.onThrowMediaCodecException(this.c, this.j, 1);
    }
  }
  
  void a(c paramc)
  {
    this.h = paramc;
  }
  
  void a(Exception paramException)
  {
    QGPlayerNativeManager.onThrowMediaCodecException(this.c, this.j, 5);
  }
  
  void b()
  {
    this.g = true;
  }
  
  void b(b paramb)
  {
    if ((paramb != null) && (paramb.f()))
    {
      paramb.b();
      QGPlayerNativeManager.onThrowMediaCodecException(this.c, this.j, 2);
    }
  }
  
  void b(Exception paramException)
  {
    QGPlayerNativeManager.onThrowMediaCodecException(this.c, this.j, 3);
  }
  
  String c()
  {
    return "QGPlayer.MediaCodecVideoDecoder";
  }
  
  String d()
  {
    return this.k;
  }
  
  boolean e()
  {
    if ((i() != null) || (this.i == null))
    {
      QGLog.e("QGPlayer.MediaCodecVideoDecoder", "init video decoder error, deocder = " + i() + ", surface = " + this.i);
      return false;
    }
    return true;
  }
  
  protected long h()
  {
    return 10000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.a.f
 * JD-Core Version:    0.7.0.1
 */