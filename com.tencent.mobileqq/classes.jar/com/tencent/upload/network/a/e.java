package com.tencent.upload.network.a;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.upload.c.c.a;
import com.tencent.upload.common.Const;
import com.tencent.upload.common.Const.UploadRetCode;
import com.tencent.upload.common.Const.b;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.route.UploadRoute;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class e
  implements a, com.tencent.upload.network.base.a
{
  private com.tencent.upload.network.base.c a;
  private UploadRoute b;
  private final String c = String.valueOf(hashCode());
  private final WeakReference<b> d;
  private ByteBuffer e = ByteBuffer.allocate(128);
  private volatile a.b f;
  private String g;
  private ConcurrentLinkedQueue<com.tencent.upload.c.a> h = new ConcurrentLinkedQueue();
  private SparseArray<com.tencent.upload.c.a> i = new SparseArray();
  private SparseArray<a> j = new SparseArray();
  private Const.b k;
  private volatile long l;
  private Handler m;
  private int n = 0;
  
  public e(Looper paramLooper, b paramb, Const.b paramb1)
  {
    this.d = new WeakReference(paramb);
    this.f = a.b.a;
    this.m = new Handler(paramLooper);
    this.k = paramb1;
    f();
  }
  
  private void a(int paramInt)
  {
    int i1 = 0;
    com.tencent.upload.common.b.b("UploadSession", "do Cleanup Session. sid=" + this.c);
    this.e.clear();
    Const.UploadRetCode localUploadRetCode = Const.a(paramInt);
    com.tencent.upload.common.b.b("UploadSession", "mActionRequests.size()=" + this.h.size() + "mSendingMap.size()=" + this.i.size() + "mTimeoutMap.size()=" + this.j.size());
    Object localObject = this.h.iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.upload.c.a locala = (com.tencent.upload.c.a)((Iterator)localObject).next();
      if ((locala != null) && (locala.f() != null)) {
        locala.f().onRequestError(locala, localUploadRetCode, this);
      }
    }
    this.h.clear();
    paramInt = 0;
    if (paramInt < this.i.size())
    {
      int i2 = this.i.keyAt(paramInt);
      localObject = (a)this.j.get(i2);
      if ((localObject != null) && (((a)localObject).a != null)) {}
      for (;;)
      {
        paramInt += 1;
        break;
        localObject = (com.tencent.upload.c.a)this.i.get(i2);
        if ((localObject != null) && (((com.tencent.upload.c.a)localObject).f() != null)) {
          ((com.tencent.upload.c.a)localObject).f().onRequestError((com.tencent.upload.c.a)localObject, localUploadRetCode, this);
        }
      }
    }
    this.i.clear();
    paramInt = i1;
    if (paramInt < this.j.size())
    {
      i1 = this.j.keyAt(paramInt);
      localObject = (a)this.j.get(i1);
      if (localObject != null) {}
      for (localObject = ((a)localObject).a;; localObject = null)
      {
        if ((localObject != null) && (((com.tencent.upload.c.a)localObject).f() != null)) {
          ((com.tencent.upload.c.a)localObject).f().onRequestError((com.tencent.upload.c.a)localObject, localUploadRetCode, this);
        }
        paramInt += 1;
        break;
      }
    }
    h();
  }
  
  private void a(com.tencent.upload.c.a parama)
  {
    com.tencent.upload.network.base.c localc = this.a;
    if (localc == null)
    {
      com.tencent.upload.common.b.e("UploadSession", "Session has no connection! actionId=" + parama.b() + " reqId=" + parama.c() + " sid=" + this.c);
      a(localc, Const.UploadRetCode.SESSION_WITHOUT_CONN.getCode(), Const.UploadRetCode.SESSION_WITHOUT_CONN.getDesc());
    }
    byte[] arrayOfByte;
    for (;;)
    {
      return;
      try
      {
        arrayOfByte = parama.a();
        if (arrayOfByte == null)
        {
          com.tencent.upload.common.b.e("UploadSession", "decode request failed. actionId=" + parama.b() + " reqId=" + parama.c() + " cmd=" + parama.d() + " sid=" + this.c);
          this.i.delete(parama.c());
          if (parama.f() == null) {
            continue;
          }
          parama.f().onRequestError(parama, Const.UploadRetCode.FILE_NOT_EXIST, this);
        }
      }
      catch (IOException localIOException)
      {
        if (parama.f() != null) {
          parama.f().onRequestError(parama, Const.UploadRetCode.IO_EXCEPTION, this);
        }
        com.tencent.upload.common.b.c("UploadSession", "", localIOException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (parama.f() != null) {
          parama.f().onRequestError(parama, Const.UploadRetCode.OOM, this);
        }
        com.tencent.upload.common.b.c("UploadSession", "", localOutOfMemoryError);
        return;
      }
    }
    int i1 = b(arrayOfByte.length);
    if (!localOutOfMemoryError.a(arrayOfByte, parama.c(), i1, i1))
    {
      com.tencent.upload.common.b.e("UploadSession", "NetworkEngine SendAsync failed. sid=" + this.c);
      this.i.delete(parama.c());
      a(localOutOfMemoryError, Const.UploadRetCode.SESSION_CONN_SEND_FAILED.getCode(), Const.UploadRetCode.SESSION_CONN_SEND_FAILED.getDesc());
      return;
    }
    localOutOfMemoryError.c();
  }
  
  private void a(com.tencent.upload.c.c paramc)
  {
    if (paramc == null) {}
    int i1;
    a locala;
    do
    {
      return;
      i1 = paramc.c();
      paramc = this.j;
      locala = (a)paramc.get(i1);
    } while (locala == null);
    this.m.removeCallbacks(locala.b);
    paramc.delete(i1);
  }
  
  /* Error */
  private void a(a.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 110	com/tencent/upload/network/a/e:f	Lcom/tencent/upload/network/a/a$b;
    //   6: astore_2
    //   7: aload_2
    //   8: aload_1
    //   9: if_acmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: ldc 129
    //   17: new 131	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 298
    //   27: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_0
    //   31: getfield 77	com/tencent/upload/network/a/e:c	Ljava/lang/String;
    //   34: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 300
    //   40: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: getfield 110	com/tencent/upload/network/a/e:f	Lcom/tencent/upload/network/a/a$b;
    //   47: invokevirtual 301	com/tencent/upload/network/a/a$b:toString	()Ljava/lang/String;
    //   50: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 303
    //   56: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: invokevirtual 301	com/tencent/upload/network/a/a$b:toString	()Ljava/lang/String;
    //   63: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 147	com/tencent/upload/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_0
    //   73: aload_1
    //   74: putfield 110	com/tencent/upload/network/a/e:f	Lcom/tencent/upload/network/a/a$b;
    //   77: goto -65 -> 12
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	e
    //   0	85	1	paramb	a.b
    //   6	2	2	localb	a.b
    // Exception table:
    //   from	to	target	type
    //   2	7	80	finally
    //   15	77	80	finally
  }
  
  private void a(a parama, com.tencent.upload.c.c paramc)
  {
    if (parama != null) {}
    for (parama = parama.a;; parama = null)
    {
      if ((this.f == a.b.c) && (parama != null) && (parama.f() != null))
      {
        if (paramc != null) {
          paramc.a(this.c);
        }
        parama.f().onResponse(parama, paramc);
      }
      return;
    }
  }
  
  private void a(com.tencent.upload.network.base.a parama, int paramInt, String paramString)
  {
    if (parama != this.a) {}
    do
    {
      return;
      com.tencent.upload.common.b.e("UploadSession", "Session Error. sid=" + this.c + " errorCode=" + paramInt + " msg=" + paramString + " currState=" + this.f.toString());
      parama = (b)this.d.get();
    } while ((parama == null) || (paramInt == 0));
    a(a.b.a);
    a(paramInt);
    parama.b(this, paramInt, paramString);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    int i1 = this.e.position() + paramArrayOfByte.length;
    if (this.e.capacity() < i1)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i1);
      this.e.flip();
      localByteBuffer.put(this.e);
      this.e = localByteBuffer;
    }
    this.e.put(paramArrayOfByte);
  }
  
  private static final int b(int paramInt)
  {
    int i1 = UploadConfiguration.getDataTimeout();
    paramInt = i1;
    if (j()) {
      paramInt = i1 * 2;
    }
    return paramInt;
  }
  
  private void b(final com.tencent.upload.c.a parama)
  {
    if (parama == null) {
      return;
    }
    final int i1 = parama.c();
    if ((a)this.j.get(i1) != null)
    {
      com.tencent.upload.common.b.d("UploadSession", "timeout runnable has been started. reqId=" + i1 + " sid=" + this.c);
      return;
    }
    a locala = new a(parama);
    Runnable local9 = new Runnable()
    {
      public void run()
      {
        SparseArray localSparseArray = e.h(e.this);
        e.a locala = (e.a)localSparseArray.get(i1);
        if ((locala == null) || (locala.b != this)) {
          com.tencent.upload.common.b.d("UploadSession", "execute timeout runnable has been removed. reqId=" + i1 + " sid=" + e.c(e.this));
        }
        do
        {
          return;
          com.tencent.upload.common.b.d("UploadSession", "ResponseTime! actionId=" + locala.a.b() + " reqId=" + i1 + " cmd=" + locala.a.d() + " sid=" + e.c(e.this) + " currState=" + e.d(e.this).toString());
          localSparseArray.remove(i1);
          e.i(e.this).removeCallbacks(locala.b);
          locala.b = null;
        } while ((e.d(e.this) != a.b.c) || (parama == null) || (parama.f() == null));
        parama.f().onRequestTimeout(parama, e.this);
      }
    };
    this.m.removeCallbacks(locala.b);
    locala.b = local9;
    this.j.put(i1, locala);
    i1 = c(parama);
    this.m.postDelayed(local9, i1);
  }
  
  private void b(com.tencent.upload.network.base.a parama, byte[] paramArrayOfByte)
  {
    f();
    a(paramArrayOfByte);
    parama = c.a.a;
    paramArrayOfByte = g();
    int i1;
    label24:
    boolean bool;
    if (paramArrayOfByte == null)
    {
      i1 = 0;
      if (i1 == 0) {
        break label329;
      }
      if (this.f == a.b.c)
      {
        paramArrayOfByte = (b)this.d.get();
        if (paramArrayOfByte != null)
        {
          if (parama.a() != 0) {
            break label323;
          }
          this.n += 1;
          if (this.n <= 3) {
            break label335;
          }
          parama = c.a.f;
          bool = true;
        }
      }
    }
    for (;;)
    {
      com.tencent.upload.common.b.e("UploadSession", this.c + " doRecv sRecvErrorCnt " + this.n + " ret:" + parama + " needCallBack:" + bool);
      if (bool)
      {
        this.n = 0;
        a(a.b.a);
        a(parama.a());
        paramArrayOfByte.b(this, parama.a(), parama.b());
      }
      return;
      if (paramArrayOfByte.length == 0)
      {
        i1 = 1;
        break label24;
      }
      com.tencent.upload.c.c localc = new com.tencent.upload.c.c();
      try
      {
        paramArrayOfByte = localc.a(paramArrayOfByte);
        parama = paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          com.tencent.upload.common.b.c("UploadSession", this.c + "decode error ", paramArrayOfByte);
        }
        paramArrayOfByte = (a)this.j.get(localc.c());
        if (paramArrayOfByte == null) {
          break label320;
        }
        a(localc);
        a(paramArrayOfByte, localc);
      }
      if (parama.a() != 0)
      {
        com.tencent.upload.common.b.e("UploadSession", this.c + " doRecv decode error " + parama);
        i1 = 1;
        break label24;
      }
      label320:
      break;
      label323:
      bool = true;
      continue;
      label329:
      this.n = 0;
      return;
      label335:
      bool = false;
    }
  }
  
  private static final int c(com.tencent.upload.c.a parama)
  {
    int i2 = UploadConfiguration.getDataTimeout();
    int i1 = i2;
    if (j()) {
      i1 = i2 * 2;
    }
    return i1;
  }
  
  private byte[] g()
  {
    if (this.e.position() == 0) {}
    int i1;
    do
    {
      return null;
      if (this.e.position() < 4)
      {
        com.tencent.upload.common.b.d("UploadSession", "doDivideReceivedBuffer: size < 4 sid=" + this.c);
        return new byte[0];
      }
      i1 = com.tencent.upload.e.c.c(this.e.array());
      if ((i1 > UploadConfiguration.getMaxSessionPacketSize()) || (i1 < 25))
      {
        com.tencent.upload.common.b.d("UploadSession", " doDivideReceivedBuffer size > max, size:" + i1 + " sid=" + this.c);
        return new byte[0];
      }
    } while (i1 > this.e.position());
    byte[] arrayOfByte = new byte[i1];
    this.e.flip();
    this.e.get(arrayOfByte);
    this.e.compact();
    return arrayOfByte;
  }
  
  private void h()
  {
    int i1 = 0;
    if (i1 < this.j.size())
    {
      int i2 = this.j.keyAt(i1);
      a locala = (a)this.j.get(i2);
      if (locala == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        this.m.removeCallbacks(locala.b);
        locala.b = null;
      }
    }
    this.j.clear();
  }
  
  private void i()
  {
    if (this.h.isEmpty()) {}
    for (;;)
    {
      return;
      try
      {
        com.tencent.upload.c.a locala = (com.tencent.upload.c.a)this.h.remove();
        if (locala == null) {
          continue;
        }
        com.tencent.upload.common.b.b("[transfer] UploadSession", "Send Request Begin. sid=" + this.c + " " + locala.toString() + " sending:" + this.i.size() + " waiting:" + this.h.size());
        this.i.put(locala.c(), locala);
        a(locala);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.upload.common.b.c("UploadSession", "get send request exception.", localException);
          Object localObject = null;
        }
      }
    }
  }
  
  private static boolean j()
  {
    return UploadConfiguration.getCurrentNetworkCategory() == 3;
  }
  
  public void a()
  {
    if (this.a == null) {
      return;
    }
    com.tencent.upload.common.b.d("[connect] UploadSession", "Close Session. sid=" + this.c);
    if (this.a != null)
    {
      this.a.b();
      this.a = null;
    }
    b localb = (b)this.d.get();
    if (localb != null) {
      localb.b(this);
    }
    a(a.b.a);
    this.e.clear();
    this.h.clear();
    this.i.clear();
    h();
  }
  
  public void a(com.tencent.upload.network.base.a parama)
  {
    if (parama != this.a) {
      return;
    }
    com.tencent.upload.common.b.b("UploadSession", "Session onStart. sid=" + this.c);
  }
  
  public void a(final com.tencent.upload.network.base.a parama, final int paramInt)
  {
    this.m.post(new Runnable()
    {
      public void run()
      {
        int i = paramInt;
        if (c.a(paramInt)) {
          i = Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode();
        }
        com.tencent.upload.common.b.d("UploadSession", "Session Error. sid=" + e.c(e.this) + " socket_status=" + paramInt);
        e.a(e.this, parama, i, "NDK Network Error: " + i);
      }
    });
  }
  
  public void a(final com.tencent.upload.network.base.a parama, final int paramInt1, final int paramInt2)
  {
    this.m.post(new Runnable()
    {
      public void run()
      {
        if (parama != e.b(e.this))
        {
          ((com.tencent.upload.network.base.c)parama).b();
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("doSendTimeout! sid=").append(e.c(e.this)).append(" seq:").append(paramInt1).append(" reason:").append(paramInt2).append(" currState=").append(e.d(e.this).toString()).append(" timeout route:");
        if (e.f(e.this) == null) {}
        for (Object localObject = "null";; localObject = e.f(e.this))
        {
          com.tencent.upload.common.b.d("UploadSession", localObject);
          if (e.d(e.this) != a.b.c) {
            break;
          }
          localObject = (com.tencent.upload.c.a)e.g(e.this).get(paramInt1);
          if ((localObject != null) && (((com.tencent.upload.c.a)localObject).f() != null)) {
            ((com.tencent.upload.c.a)localObject).f().onRequestTimeout((com.tencent.upload.c.a)localObject, e.this);
          }
          localObject = (b)e.e(e.this).get();
          if (localObject == null) {
            break;
          }
          ((b)localObject).b(e.this, Const.UploadRetCode.REQUEST_TIMEOUT.getCode(), Const.UploadRetCode.REQUEST_TIMEOUT.getDesc());
          e.a(e.this, a.b.a);
          return;
        }
      }
    });
  }
  
  public void a(final com.tencent.upload.network.base.a parama, final boolean paramBoolean, final int paramInt, final String paramString)
  {
    this.m.post(new Runnable()
    {
      public void run()
      {
        Object localObject;
        if (parama != e.b(e.this))
        {
          localObject = (com.tencent.upload.network.base.c)parama;
          com.tencent.upload.common.b.b("[connect] UploadSession", "doAfterConnect. sid=" + e.c(e.this) + " succeed=" + paramBoolean + " errorCode=" + paramInt + " ip=" + paramString + " The connection is invalid, close it!" + ((com.tencent.upload.network.base.c)localObject).hashCode());
          ((com.tencent.upload.network.base.c)localObject).b();
        }
        do
        {
          do
          {
            do
            {
              return;
              e.this.f();
              com.tencent.upload.common.b.b("[connect] UploadSession", "doAfterConnect. sid=" + e.c(e.this) + " succeed=" + paramBoolean + " errorCode=" + paramInt + " ip=" + paramString + " currState=" + e.d(e.this).toString());
            } while (e.d(e.this) != a.b.b);
            if (!paramBoolean) {
              break;
            }
            com.tencent.upload.common.b.b("[connect] UploadSession", "sid=" + e.c(e.this) + ", connect succeed:" + paramBoolean + ", ip=" + paramString + ", currState=" + e.d(e.this).toString());
            e.a(e.this, paramString);
            e.a(e.this, a.b.c);
            localObject = (b)e.e(e.this).get();
          } while (localObject == null);
          ((b)localObject).a(e.this);
          return;
          localObject = (b)e.e(e.this).get();
        } while (localObject == null);
        e.a(e.this, a.b.a);
        ((b)localObject).a(e.this, paramInt, "连接失败");
      }
    });
  }
  
  public void a(final com.tencent.upload.network.base.a parama, final byte[] paramArrayOfByte)
  {
    this.m.post(new Runnable()
    {
      public void run()
      {
        e.a(e.this, parama, paramArrayOfByte);
      }
    });
  }
  
  public boolean a(com.tencent.upload.c.a parama, a.a parama1)
  {
    if (this.f != a.b.c)
    {
      com.tencent.upload.common.b.e("UploadSession", "Can't send request, state is illegel. CurrState=" + this.f.toString() + " sid=" + this.c);
      return false;
    }
    if (parama == null)
    {
      com.tencent.upload.common.b.e("UploadSession", "Can't send request, request is illegel. sid=" + this.c);
      return false;
    }
    f();
    parama.a(parama1);
    this.h.add(parama);
    this.m.post(new Runnable()
    {
      public void run()
      {
        e.a(e.this);
      }
    });
    return true;
  }
  
  public boolean a(UploadRoute paramUploadRoute)
  {
    return a(paramUploadRoute, UploadConfiguration.getConnectionTimeout());
  }
  
  public boolean a(UploadRoute paramUploadRoute, int paramInt)
  {
    if (paramUploadRoute == null)
    {
      com.tencent.upload.common.b.d("[connect] UploadSession", "open route == null");
      return false;
    }
    if (paramInt <= 0) {
      paramInt = UploadConfiguration.getConnectionTimeout();
    }
    for (;;)
    {
      if (this.a != null)
      {
        this.a.b();
        this.a = null;
      }
      if (this.b != null) {
        this.b = null;
      }
      this.a = new com.tencent.upload.network.base.c(this, this.c);
      if (this.a == null)
      {
        com.tencent.upload.common.b.d("[connect] UploadSession", "Open NetworkEngine Failed! sid=" + this.c + " state:" + this.f.toString());
        return false;
      }
      if (!this.a.a())
      {
        com.tencent.upload.common.b.d("[connect] UploadSession", "NetworkEngine Start Failed! sid=" + this.c + " state:" + this.f.toString());
        return false;
      }
      boolean bool = this.a.a(paramUploadRoute.getIp(), paramUploadRoute.getPort(), paramUploadRoute.getProxyIp(), paramUploadRoute.getPorxyPort(), paramInt);
      if (bool)
      {
        this.b = paramUploadRoute;
        a(a.b.b);
      }
      com.tencent.upload.common.b.b("[connect] UploadSession", "connectAsync success, sid=" + this.c + " state:" + this.f.toString());
      return bool;
    }
  }
  
  public UploadRoute b()
  {
    return this.b;
  }
  
  public void b(final com.tencent.upload.network.base.a parama)
  {
    this.m.post(new Runnable()
    {
      public void run()
      {
        if (parama != e.b(e.this))
        {
          ((com.tencent.upload.network.base.c)parama).b();
          return;
        }
        com.tencent.upload.common.b.b("UploadSession", "Session DisConnected. sid=" + e.c(e.this) + " currState=" + e.d(e.this).toString());
        b localb = (b)e.e(e.this).get();
        if ((localb != null) && (e.this.d() == a.b.c)) {
          localb.b(e.this);
        }
        e.b(e.this, a.b.a);
      }
    });
  }
  
  public void b(com.tencent.upload.network.base.a parama, final int paramInt)
  {
    this.m.post(new Runnable()
    {
      public void run()
      {
        e.this.f();
        com.tencent.upload.c.a locala = (com.tencent.upload.c.a)e.g(e.this).get(paramInt);
        e.a(e.this, locala);
      }
    });
  }
  
  public String c()
  {
    return this.g;
  }
  
  public void c(com.tencent.upload.network.base.a parama, final int paramInt)
  {
    this.m.post(new Runnable()
    {
      public void run()
      {
        e.this.f();
        Object localObject = (com.tencent.upload.c.a)e.g(e.this).get(paramInt);
        if (localObject == null)
        {
          com.tencent.upload.common.b.d("[transfer] UploadSession", "doSendEnd request== null. reqId=" + paramInt + ", sid=" + e.c(e.this));
          return;
        }
        com.tencent.upload.common.b.b("[transfer] UploadSession", "Send Request End. sid=" + e.c(e.this) + ", taskId=" + ((com.tencent.upload.c.a)localObject).b() + ", reqId=" + ((com.tencent.upload.c.a)localObject).c());
        e.g(e.this).delete(paramInt);
        if (((com.tencent.upload.c.a)localObject).f() != null) {
          ((com.tencent.upload.c.a)localObject).f().onRequestSended((com.tencent.upload.c.a)localObject);
        }
        localObject = (e.a)e.h(e.this).get(paramInt);
        if ((localObject != null) && (((e.a)localObject).a != null) && (!((e.a)localObject).a.e()))
        {
          if (((e.a)localObject).b != null) {
            e.i(e.this).removeCallbacks(((e.a)localObject).b);
          }
          ((e.a)localObject).b = null;
        }
        e.a(e.this);
      }
    });
  }
  
  public a.b d()
  {
    return this.f;
  }
  
  public boolean e()
  {
    if (System.currentTimeMillis() - this.l > 60000L) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.upload.common.b.c("UploadSession", "session isExpired:" + bool);
      return bool;
    }
  }
  
  public void f()
  {
    this.l = System.currentTimeMillis();
  }
  
  private static final class a
  {
    public final com.tencent.upload.c.a a;
    public Runnable b;
    public long c;
    
    public a(com.tencent.upload.c.a parama)
    {
      this.a = parama;
      this.c = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.a.e
 * JD-Core Version:    0.7.0.1
 */