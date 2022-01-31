package com.tencent.qgplayer.rtmpsdk.a;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import com.tencent.qgplayer.rtmpsdk.QGLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

abstract class e
{
  Context a;
  b b;
  protected String c;
  protected long d = 0L;
  private List<byte[]> e = new ArrayList();
  private MediaCodec f;
  private final MediaCodec.BufferInfo g;
  private int h;
  private int i;
  private boolean j = false;
  private final int k;
  private boolean l = false;
  
  e(Context paramContext, int paramInt)
  {
    this.a = paramContext.getApplicationContext();
    this.k = paramInt;
    this.g = new MediaCodec.BufferInfo();
    this.b = new b();
  }
  
  private void b(long paramLong)
  {
    if (k()) {
      c(paramLong);
    }
  }
  
  private void c(long paramLong)
  {
    this.i = -30000;
    try
    {
      this.i = this.f.dequeueOutputBuffer(this.g, h());
      if (this.i >= 0)
      {
        ByteBuffer localByteBuffer = this.f.getOutputBuffers()[this.i];
        a(this.f, this.g, localByteBuffer, this.i, paramLong);
        this.b.b();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QGLog.e(c(), "dequeueOutputBuffer fail, throwable = " + localException.toString());
      }
      if (this.i == -2)
      {
        l();
        return;
      }
      if (this.i == -3)
      {
        QGLog.i(c(), "out put buffers changed, mTrackType = " + this.k);
        m();
        return;
      }
      if (this.i == -1) {
        try
        {
          Thread.sleep(10L);
          QGLog.i(c(), "INFO_TRY_AGAIN_LATER");
          b(this.b.d());
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            QGLog.e(c(), "INFO_TRY_AGAIN_LATER sleep interrupt, mTrackType = " + this.k);
            localInterruptedException.printStackTrace();
          }
        }
      }
      b(this.b.d());
      QGLog.e(c(), "unexpected result from decoder.dequeueOutputBuffer: " + this.i);
    }
  }
  
  private boolean k()
  {
    if (this.f == null)
    {
      QGLog.e(c(), "doDecode : null decoder");
      return false;
    }
    byte[] arrayOfByte = (byte[])this.e.get(0);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      QGLog.e(c(), "empty buffer");
      this.e.remove(0);
      return false;
    }
    ByteBuffer[] arrayOfByteBuffer = this.f.getInputBuffers();
    if (arrayOfByteBuffer.length == 0)
    {
      QGLog.e(c(), "getInputBuffers failed");
      return false;
    }
    this.h = -20000;
    try
    {
      this.h = this.f.dequeueInputBuffer(10000L);
      if (this.h >= 0)
      {
        arrayOfByteBuffer[this.h].put(arrayOfByte);
        this.f.queueInputBuffer(this.h, 0, arrayOfByte.length, System.nanoTime() / 1000L, 0);
        this.e.remove(0);
        this.b.a();
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QGLog.e(c(), "dequeueInputBuffer excpetion, mInputIndex = " + this.h);
        continue;
        a(this.b.c());
        QGLog.e(c(), "input buffer not available, inputIndex = " + this.h);
      }
    }
  }
  
  private void l()
  {
    MediaFormat localMediaFormat = this.f.getOutputFormat();
    a(this.f, localMediaFormat);
  }
  
  private void m() {}
  
  abstract void a();
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  abstract void a(MediaCodec paramMediaCodec);
  
  abstract void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo, ByteBuffer paramByteBuffer, int paramInt, long paramLong);
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat) {}
  
  abstract void a(b paramb);
  
  abstract void a(Exception paramException);
  
  public final void a(String paramString)
  {
    this.c = paramString;
    g();
    a();
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    if ((this.f == null) && (!g()))
    {
      QGLog.e(c(), "initDecoder error");
      if ((!this.j) && (paramBoolean))
      {
        QGLog.i(c(), "Android, received key Frame");
        this.j = true;
      }
      this.e.add(paramArrayOfByte);
    }
    for (;;)
    {
      return;
      if (this.f != null)
      {
        if ((!this.j) && (paramBoolean))
        {
          QGLog.i(c(), "Android, received key Frame");
          this.j = true;
        }
        try
        {
          this.e.add(paramArrayOfByte);
          int m;
          int n;
          do
          {
            if (this.e.isEmpty()) {
              break;
            }
            m = this.e.size();
            b(paramLong);
            n = this.e.size();
          } while (m != n);
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          j();
          a(paramArrayOfByte);
          QGLog.e(c(), "render frame Exception : " + paramArrayOfByte.toString());
        }
      }
    }
  }
  
  abstract void b();
  
  abstract void b(b paramb);
  
  abstract void b(Exception paramException);
  
  abstract String c();
  
  abstract String d();
  
  abstract boolean e();
  
  public final void f()
  {
    j();
    Looper.myLooper().quit();
    b();
  }
  
  final boolean g()
  {
    boolean bool = false;
    if (e()) {}
    try
    {
      this.f = MediaCodec.createDecoderByType(d());
      a(this.f);
      this.f.start();
      this.h = -1;
      this.i = -1;
      b localb = this.b;
      localb.a += 1;
      bool = true;
      return bool;
    }
    catch (Exception localException)
    {
      QGLog.e(c(), "initDecoder excpetion, throwable = " + localException.toString());
      j();
      b(localException);
    }
    return false;
  }
  
  protected long h()
  {
    return 0L;
  }
  
  protected final MediaCodec i()
  {
    return this.f;
  }
  
  /* Error */
  void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_m1
    //   2: putfield 172	com/tencent/qgplayer/rtmpsdk/a/e:h	I
    //   5: aload_0
    //   6: iconst_m1
    //   7: putfield 75	com/tencent/qgplayer/rtmpsdk/a/e:i	I
    //   10: aload_0
    //   11: getfield 36	com/tencent/qgplayer/rtmpsdk/a/e:e	Ljava/util/List;
    //   14: invokeinterface 277 1 0
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 38	com/tencent/qgplayer/rtmpsdk/a/e:j	Z
    //   24: aload_0
    //   25: getfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   28: ifnull +57 -> 85
    //   31: aload_0
    //   32: getfield 62	com/tencent/qgplayer/rtmpsdk/a/e:b	Lcom/tencent/qgplayer/rtmpsdk/a/b;
    //   35: astore_1
    //   36: aload_1
    //   37: aload_1
    //   38: getfield 279	com/tencent/qgplayer/rtmpsdk/a/b:b	I
    //   41: iconst_1
    //   42: iadd
    //   43: putfield 279	com/tencent/qgplayer/rtmpsdk/a/b:b	I
    //   46: aload_0
    //   47: getfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   50: invokevirtual 282	android/media/MediaCodec:stop	()V
    //   53: aload_0
    //   54: invokevirtual 98	com/tencent/qgplayer/rtmpsdk/a/e:c	()Ljava/lang/String;
    //   57: ldc_w 284
    //   60: invokestatic 125	com/tencent/qgplayer/rtmpsdk/QGLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   67: invokevirtual 287	android/media/MediaCodec:release	()V
    //   70: aload_0
    //   71: invokevirtual 98	com/tencent/qgplayer/rtmpsdk/a/e:c	()Ljava/lang/String;
    //   74: ldc_w 289
    //   77: invokestatic 125	com/tencent/qgplayer/rtmpsdk/QGLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: invokevirtual 98	com/tencent/qgplayer/rtmpsdk/a/e:c	()Ljava/lang/String;
    //   91: new 100	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 291
    //   101: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: invokevirtual 110	java/lang/Exception:toString	()Ljava/lang/String;
    //   108: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 116	com/tencent/qgplayer/rtmpsdk/QGLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   122: return
    //   123: astore_1
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: aload_0
    //   133: invokevirtual 98	com/tencent/qgplayer/rtmpsdk/a/e:c	()Ljava/lang/String;
    //   136: new 100	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 293
    //   146: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: invokevirtual 110	java/lang/Exception:toString	()Ljava/lang/String;
    //   153: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 116	com/tencent/qgplayer/rtmpsdk/QGLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_0
    //   163: getfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   166: invokevirtual 287	android/media/MediaCodec:release	()V
    //   169: aload_0
    //   170: invokevirtual 98	com/tencent/qgplayer/rtmpsdk/a/e:c	()Ljava/lang/String;
    //   173: ldc_w 289
    //   176: invokestatic 125	com/tencent/qgplayer/rtmpsdk/QGLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   184: return
    //   185: astore_1
    //   186: aload_0
    //   187: invokevirtual 98	com/tencent/qgplayer/rtmpsdk/a/e:c	()Ljava/lang/String;
    //   190: new 100	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   197: ldc_w 291
    //   200: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_1
    //   204: invokevirtual 110	java/lang/Exception:toString	()Ljava/lang/String;
    //   207: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 116	com/tencent/qgplayer/rtmpsdk/QGLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_0
    //   217: aconst_null
    //   218: putfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   221: return
    //   222: astore_1
    //   223: aload_0
    //   224: aconst_null
    //   225: putfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   228: aload_1
    //   229: athrow
    //   230: astore_1
    //   231: aload_0
    //   232: getfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   235: invokevirtual 287	android/media/MediaCodec:release	()V
    //   238: aload_0
    //   239: invokevirtual 98	com/tencent/qgplayer/rtmpsdk/a/e:c	()Ljava/lang/String;
    //   242: ldc_w 289
    //   245: invokestatic 125	com/tencent/qgplayer/rtmpsdk/QGLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload_0
    //   249: aconst_null
    //   250: putfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   253: aload_1
    //   254: athrow
    //   255: astore_2
    //   256: aload_0
    //   257: invokevirtual 98	com/tencent/qgplayer/rtmpsdk/a/e:c	()Ljava/lang/String;
    //   260: new 100	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   267: ldc_w 291
    //   270: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_2
    //   274: invokevirtual 110	java/lang/Exception:toString	()Ljava/lang/String;
    //   277: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 116	com/tencent/qgplayer/rtmpsdk/QGLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload_0
    //   287: aconst_null
    //   288: putfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   291: goto -38 -> 253
    //   294: astore_1
    //   295: aload_0
    //   296: aconst_null
    //   297: putfield 77	com/tencent/qgplayer/rtmpsdk/a/e:f	Landroid/media/MediaCodec;
    //   300: aload_1
    //   301: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	e
    //   35	3	1	localb	b
    //   86	19	1	localException1	Exception
    //   123	7	1	localObject1	Object
    //   131	19	1	localException2	Exception
    //   185	19	1	localException3	Exception
    //   222	7	1	localObject2	Object
    //   230	24	1	localObject3	Object
    //   294	7	1	localObject4	Object
    //   255	19	2	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   63	80	86	java/lang/Exception
    //   63	80	123	finally
    //   87	117	123	finally
    //   46	63	131	java/lang/Exception
    //   162	179	185	java/lang/Exception
    //   162	179	222	finally
    //   186	216	222	finally
    //   46	63	230	finally
    //   132	162	230	finally
    //   231	248	255	java/lang/Exception
    //   231	248	294	finally
    //   256	286	294	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.a.e
 * JD-Core Version:    0.7.0.1
 */