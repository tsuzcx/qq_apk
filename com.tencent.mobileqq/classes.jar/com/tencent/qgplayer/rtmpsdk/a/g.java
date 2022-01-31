package com.tencent.qgplayer.rtmpsdk.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.qgplayer.rtmpsdk.QGLog;
import com.tencent.qgplayer.rtmpsdk.QGMediaStream;
import com.tencent.qgplayer.rtmpsdk.QGPlayerNativeManager;
import com.tencent.qgplayer.rtmpsdk.QGPlayerNativeManager.a;

public class g
  implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback, QGPlayerNativeManager.a
{
  private d a;
  private f b;
  private a c;
  private Handler d;
  private Handler e;
  private TextureView f;
  private SurfaceTexture g;
  private String h;
  private com.tencent.qgplayer.rtmpsdk.b.a i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  
  static
  {
    QGPlayerNativeManager.isSupportSpecifiedDecode("video/hevc");
  }
  
  public g(Context paramContext, com.tencent.qgplayer.rtmpsdk.b.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.i = parama;
    this.k = paramBoolean1;
    this.l = paramBoolean2;
    this.m = paramBoolean3;
    this.j = QGPlayerNativeManager.couldNativeVideoDecode();
    if ((paramBoolean1) && (!this.j))
    {
      this.b = new f(paramContext);
      this.b.a(this.i);
      parama = new HandlerThread("video_thread");
      parama.start();
      this.d = new Handler(parama.getLooper(), this);
    }
    if (paramBoolean2)
    {
      this.a = new d(paramContext);
      paramContext = new HandlerThread("audio_thread");
      paramContext.start();
      this.e = new Handler(paramContext.getLooper(), this);
    }
    for (;;)
    {
      QGLog.i("QGPlayer.MediaDataConsumer", "MediaDataConsumer construct , enableHwVideoDec : " + this.k + " , enableHwAudioDec : " + this.l + " , enableNativeVideoCodec : " + this.j);
      return;
      if (!paramBoolean3) {
        this.c = new a();
      }
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.c != null) {
      this.c.a(paramFloat);
    }
    if (this.a != null) {
      this.a.a(paramFloat);
    }
    if ((this.m) && (this.i != null)) {
      this.i.a(paramFloat);
    }
  }
  
  public void a(@NonNull TextureView paramTextureView)
  {
    this.f = paramTextureView;
  }
  
  public void a(String paramString)
  {
    if (this.i != null) {
      this.i.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt > 0)
    {
      QGLog.i("QGPlayer.MediaDataConsumer", "onEosTextureAvailable textureId = " + paramInt);
      if (this.g != null) {
        this.g.setOnFrameAvailableListener(null);
      }
      this.g = new SurfaceTexture(paramInt);
      this.g.setOnFrameAvailableListener(this);
      if (!this.j) {
        break label86;
      }
      QGPlayerNativeManager.nativeSetCodecDecodeSurface(paramString, new Surface(this.g));
    }
    label86:
    while (this.d == null) {
      return;
    }
    this.d.post(new Runnable()
    {
      public void run()
      {
        g.b(g.this).a(g.c(g.this));
      }
    });
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.i != null)
    {
      QGLog.i("QGPlayer.MediaDataConsumer", "onSetSurfaceInRenderThread setSurface");
      this.i.a(this.f.getSurfaceTexture(), paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.c != null) {
      this.c.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.b != null)
    {
      QGLog.i("QGPlayer.MediaDataConsumer", "seekToPts " + paramLong);
      this.b.a(paramLong);
    }
  }
  
  public void a(String paramString, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2, final long paramLong)
  {
    if (this.e != null) {
      this.e.post(new Runnable()
      {
        public void run()
        {
          if (g.a(g.this) != null)
          {
            g.a(g.this).a(paramInt1, paramInt2);
            g.a(g.this).a(paramArrayOfByte, true, paramLong);
          }
        }
      });
    }
  }
  
  public void a(String paramString, final byte[] paramArrayOfByte, final long paramLong, final boolean paramBoolean, final int paramInt)
  {
    if (this.d != null) {
      this.d.post(new Runnable()
      {
        public void run()
        {
          if (g.b(g.this) != null) {
            g.b(g.this).a(paramInt, paramArrayOfByte, paramBoolean, paramLong);
          }
        }
      });
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.i != null) {
      this.i.a(paramBoolean);
    }
  }
  
  public void a(QGMediaStream[] paramArrayOfQGMediaStream, int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.h = paramString1;
    if ((this.k) && (!this.j) && (this.d != null)) {
      Message.obtain(this.d, 1).sendToTarget();
    }
    if ((this.l) && (this.e != null)) {
      Message.obtain(this.e, 2).sendToTarget();
    }
    if (this.c != null) {
      this.c.a(this.h);
    }
    this.i.a(paramArrayOfQGMediaStream, paramInt1, paramString1, paramInt2, paramInt3, paramInt4, this.k, this.l, this.m, paramString2);
  }
  
  public void b(String paramString)
  {
    if (this.i != null) {
      this.i.b(paramString);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    if (this.i != null) {
      this.i.a(paramInt1, paramInt2);
    }
  }
  
  public void b(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if (this.c != null) {}
    try
    {
      this.c.a(paramArrayOfByte, paramLong);
      return;
    }
    catch (Exception paramString)
    {
      QGLog.e("QGPlayer.MediaDataConsumer", "onRecievePCMData handle buffer excpetion :" + paramString.toString());
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    if (this.i != null) {
      return this.i.a(paramString, paramInt);
    }
    return false;
  }
  
  public void c(String paramString)
  {
    if (this.g != null) {
      this.g.setOnFrameAvailableListener(null);
    }
    this.i.c(paramString);
    if ((this.b != null) && (this.d != null))
    {
      this.d.removeCallbacksAndMessages(null);
      Message.obtain(this.d, 3).sendToTarget();
    }
    if ((this.a != null) && (this.e != null))
    {
      this.e.removeCallbacksAndMessages(null);
      Message.obtain(this.e, 4).sendToTarget();
    }
    if (this.c != null) {
      this.c.a();
    }
    this.d = null;
    this.e = null;
    this.i = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.b != null)
      {
        this.b.a(this.h);
        continue;
        if (this.a != null)
        {
          this.a.a(this.h);
          continue;
          if (this.b != null)
          {
            this.b.f();
            continue;
            if (this.a != null) {
              this.a.f();
            }
          }
        }
      }
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.i != null) {
      this.i.a(paramSurfaceTexture);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.a.g
 * JD-Core Version:    0.7.0.1
 */