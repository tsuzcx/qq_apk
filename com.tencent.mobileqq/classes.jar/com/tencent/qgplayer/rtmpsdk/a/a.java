package com.tencent.qgplayer.rtmpsdk.a;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.util.Log;
import com.tencent.qgplayer.rtmpsdk.QGLog;
import com.tencent.qgplayer.rtmpsdk.QGPlayerNativeManager;
import com.tencent.qgplayer.rtmpsdk.c.b;
import com.tencent.qgplayer.rtmpsdk.c.e;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;

public class a
{
  private int a = 0;
  private int b = 0;
  private AudioTrack c;
  private Thread d;
  private int e = 44100;
  private int f;
  private int g;
  private int h;
  private float i = 1.0F;
  private com.tencent.qgplayer.rtmpsdk.c.a j = new com.tencent.qgplayer.rtmpsdk.c.a(10485760);
  private boolean k = false;
  private volatile boolean l;
  private LinkedBlockingQueue<a> m = new LinkedBlockingQueue();
  private boolean n;
  private String o;
  private ByteBuffer p;
  
  private int a(int paramInt)
  {
    int i1;
    switch (paramInt)
    {
    default: 
      throw new RuntimeException("Unsupported channel count: " + paramInt);
    case 1: 
      i1 = 2;
    }
    for (;;)
    {
      if ((e.a <= 23) && ("foster".equals(e.b)) && ("NVIDIA".equals(e.c))) {}
      switch (paramInt)
      {
      case 4: 
      case 6: 
      default: 
        return i1;
        i1 = 12;
        continue;
        i1 = 28;
        continue;
        i1 = 204;
        continue;
        i1 = 220;
        continue;
        i1 = 252;
        continue;
        i1 = 1276;
        continue;
        i1 = b.a;
      }
    }
    return b.a;
    return 252;
  }
  
  private void a(long paramLong)
  {
    if (!f())
    {
      b();
      this.c.play();
    }
    int i1 = (int)paramLong;
    byte[] arrayOfByte = this.j.a(i1);
    this.p.get(arrayOfByte, 0, i1);
    this.c.write(arrayOfByte, 0, i1);
    this.j.a(arrayOfByte);
  }
  
  @TargetApi(21)
  private static void a(AudioTrack paramAudioTrack, float paramFloat)
  {
    paramAudioTrack.setVolume(paramFloat);
  }
  
  private void b()
  {
    this.c = new AudioTrack(3, this.e, this.g, this.f, this.h, 1);
    int i1 = this.c.getState();
    if (i1 != 1) {
      try
      {
        this.c.release();
        throw new b(i1, this.e, this.g, this.h);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QGLog.e("QGPlayer.AudioPlayer", "audioTrack release fail, throwable = " + localException.toString());
        }
      }
    }
    e();
  }
  
  private static void b(AudioTrack paramAudioTrack, float paramFloat)
  {
    paramAudioTrack.setStereoVolume(paramFloat, paramFloat);
  }
  
  private void c()
  {
    int i1 = 0;
    while (this.m.size() > this.b)
    {
      this.m.poll();
      i1 += 1;
    }
    QGLog.i("QGPlayer.AudioPlayer", "drop audio item:" + i1 + ", queue size:" + this.m.size());
  }
  
  private void d()
  {
    if (this.c != null) {
      QGLog.i("QGPlayer.AudioPlayer", "release");
    }
    try
    {
      this.c.pause();
      this.c.flush();
      this.c.stop();
      this.c.release();
      this.c = null;
      this.k = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QGLog.e("QGPlayer.AudioPlayer", "STOP audio player exception, throwable = " + localException.toString());
      }
    }
  }
  
  private void e()
  {
    if (!f())
    {
      QGLog.e("QGPlayer.AudioPlayer", "setVolumeInternal fail, not initialized");
      return;
    }
    if (e.a >= 21)
    {
      a(this.c, this.i);
      return;
    }
    b(this.c, this.i);
  }
  
  private boolean f()
  {
    return this.c != null;
  }
  
  public void a()
  {
    if (this.d != null)
    {
      QGLog.i("QGPlayer.AudioPlayer", "stop");
      this.l = false;
    }
    try
    {
      if (this.m.size() == 0)
      {
        a locala = new a(null);
        locala.a = new byte[0];
        locala.b = 0L;
        this.m.add(locala);
      }
      this.d = null;
      return;
    }
    finally {}
  }
  
  public void a(float paramFloat)
  {
    if (this.i != paramFloat)
    {
      this.i = paramFloat;
      e();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.k)
    {
      this.e = paramInt1;
      this.g = a(paramInt2);
      if (paramInt3 != 8) {
        break label80;
      }
    }
    label80:
    for (paramInt2 = 3;; paramInt2 = 2)
    {
      this.f = paramInt2;
      this.h = AudioTrack.getMinBufferSize(paramInt1, this.g, this.f);
      this.p = ByteBuffer.allocateDirect(this.e * this.g * this.f / 20);
      this.k = true;
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.o = paramString;
    if (this.d == null)
    {
      QGLog.i("QGPlayer.AudioPlayer", "start");
      this.l = true;
      this.d = new Thread("QGPLAYER_AUDIO_PLAY")
      {
        public void run()
        {
          if (a.a(a.this))
          {
            if (a.b(a.this) == null) {
              break label159;
            }
            a.b(a.this).clear();
          }
          label159:
          for (long l = QGPlayerNativeManager.nativeGetAudioData(a.c(a.this), a.b(a.this));; l = 0L)
          {
            for (;;)
            {
              for (;;)
              {
                if (l <= 0L) {
                  break label97;
                }
                try
                {
                  a.a(a.this, l);
                }
                catch (Exception localException)
                {
                  QGLog.e("QGPlayer.AudioPlayer", "handle buffer exception : " + localException.toString());
                }
              }
              break;
              try
              {
                label97:
                sleep(10L);
              }
              catch (InterruptedException localInterruptedException)
              {
                localInterruptedException.printStackTrace();
              }
            }
            break;
            try
            {
              a.d(a.this).clear();
              a.a(a.this, 0);
              a.b(a.this, 0);
              a.e(a.this);
              return;
            }
            finally {}
          }
        }
      };
      this.d.setPriority(10);
      this.d.start();
    }
  }
  
  public void a(ByteBuffer paramByteBuffer, long paramLong)
  {
    if (!paramByteBuffer.hasRemaining())
    {
      QGLog.i("QGPlayer.AudioPlayer", "play buffer no remaining");
      return;
    }
    this.n = true;
    int i1 = paramByteBuffer.remaining();
    byte[] arrayOfByte = this.j.a(i1);
    paramByteBuffer.get(arrayOfByte, 0, i1);
    a(arrayOfByte, paramLong);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      if ((this.k) && (this.a == 0) && (this.b == 0) && (paramArrayOfByte.length > 0))
      {
        int i1 = (int)(1000L / this.g / 2L) * paramArrayOfByte.length / this.e;
        this.a = (350 / i1);
        this.b = (200 / i1);
      }
      if (this.m.size() > this.a)
      {
        Log.i("QGPlayer.AudioPlayer", "mPCMQueue.size() = " + this.m.size() + ", m_nDropThreshold = " + this.a + ",stopThreshold = " + this.b);
        c();
      }
      a locala = new a(null);
      locala.a = paramArrayOfByte;
      locala.b = paramLong;
      this.m.add(locala);
      return;
    }
    finally {}
  }
  
  private static class a
  {
    public byte[] a;
    public long b;
  }
  
  private static final class b
    extends Exception
  {
    final int a;
    
    b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
      this.a = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.a.a
 * JD-Core Version:    0.7.0.1
 */