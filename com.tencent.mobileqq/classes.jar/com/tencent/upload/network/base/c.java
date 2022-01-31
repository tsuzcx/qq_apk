package com.tencent.upload.network.base;

import android.util.SparseArray;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.e.f;
import com.tencent.upload.network.route.b.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class c
  implements a, b
{
  private static final AtomicInteger i = new AtomicInteger(0);
  protected final WeakReference<a> a;
  protected SparseArray<Object> b = new SparseArray();
  protected final byte[] c = new byte[0];
  protected volatile boolean d = false;
  protected String e;
  private final String f;
  private final String g;
  private ConnectionImpl h = null;
  
  public c(a parama, String paramString)
  {
    this.g = paramString;
    this.f = ("NetworkEngine-" + this.g);
    int j = UploadConfiguration.getDoNotFragment();
    this.a = new WeakReference(parama);
    if (!ConnectionImpl.isLibraryPrepared())
    {
      com.tencent.upload.common.b.e(this.f, "!isLibraryPrepared");
      return;
    }
    this.h = new ConnectionImpl(j, this.g);
    this.h.setCallback(this);
    this.h.setMsgCallback(this);
  }
  
  private static final int d()
  {
    return i.incrementAndGet();
  }
  
  public void a(a parama)
  {
    a locala = (a)this.a.get();
    if (locala == null) {
      return;
    }
    locala.a(parama);
  }
  
  public void a(a parama, int paramInt)
  {
    a locala = (a)this.a.get();
    if (locala == null) {
      return;
    }
    locala.a(parama, paramInt);
  }
  
  public void a(a parama, int paramInt1, int paramInt2)
  {
    a locala = (a)this.a.get();
    if (locala == null) {
      return;
    }
    locala.a(parama, paramInt1, paramInt2);
  }
  
  public void a(a parama, boolean paramBoolean, int paramInt, String paramString)
  {
    this.d = paramBoolean;
    paramString = (a)this.a.get();
    if (paramString == null)
    {
      com.tencent.upload.common.b.b(this.f, "onConnect, callback == null");
      return;
    }
    paramString.a(parama, paramBoolean, paramInt, this.e);
  }
  
  public void a(a parama, byte[] paramArrayOfByte)
  {
    a locala = (a)this.a.get();
    if (locala == null) {
      return;
    }
    locala.a(parama, paramArrayOfByte);
  }
  
  public void a(b paramb, int paramInt1, Object arg3, int paramInt2)
  {
    boolean bool = true;
    synchronized (this.c)
    {
      paramb = this.b.get(paramInt2);
      this.b.remove(paramInt2);
      switch (paramInt1)
      {
      }
    }
    if ((this.h != null) && ((paramb instanceof a)))
    {
      a locala = (a)paramb;
      paramb = locala.a;
      paramInt1 = UploadConfiguration.getMaxSegmentSize(paramb);
      if (!f.b(locala.a))
      {
        paramb = new b.a();
        com.tencent.upload.network.route.b.a(locala.a, paramb);
        ??? = paramb.a;
        paramb.a = null;
        paramb = ???;
        if (??? == null)
        {
          this.d = false;
          paramb = (a)this.a.get();
          if (paramb == null) {
            return;
          }
          paramb.a(this, false, 558, ???);
          return;
        }
      }
      com.tencent.upload.common.b.d(this.f, " OperationMsg.CONNECT, parsedIp:" + paramb + ", port:" + locala.b + ", proxyIp:" + locala.c + ", proxyPort:" + locala.d + " timeout:" + locala.e);
      this.e = paramb;
      this.h.connect(paramb, locala.b, locala.c, locala.d, locala.e, paramInt1);
    }
    else
    {
      ??? = this.f;
      paramb = new StringBuilder().append(" OperationMsg.CONNECT, obj instanceof ConnectParam:").append(paramb instanceof a).append(" mNativeConnection != null:");
      if (this.h != null) {}
      for (bool = true;; bool = false)
      {
        com.tencent.upload.common.b.d(???, bool);
        return;
      }
      if (this.h != null)
      {
        com.tencent.upload.common.b.d(this.f, " OperationMsg.DISCONNECT");
        this.h.disconnect();
        return;
      }
      com.tencent.upload.common.b.d(this.f, " OperationMsg.DISCONNECT, mNativeConnection == null");
      return;
      if ((this.h != null) && ((paramb instanceof b)))
      {
        paramb = (b)paramb;
        this.h.SendData(paramb.a, paramb.b, paramb.c, paramb.d);
        return;
      }
      ??? = this.f;
      paramb = new StringBuilder().append(" OperationMsg.SEND, obj instanceof ConnectParam:").append(paramb instanceof b).append("mNativeConnection != null:");
      if (this.h != null) {}
      for (;;)
      {
        com.tencent.upload.common.b.d(???, bool);
        return;
        bool = false;
      }
    }
  }
  
  public boolean a()
  {
    if (this.h == null) {
      return false;
    }
    if (this.h.isRunning())
    {
      com.tencent.upload.common.b.d(this.f, "start, is running, return false");
      return false;
    }
    return this.h.start();
  }
  
  public boolean a(String arg1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    if (this.h == null) {
      return false;
    }
    paramString2 = new a(???, paramInt1, paramString2, paramInt2, paramInt3);
    paramInt1 = d();
    synchronized (this.c)
    {
      this.b.put(paramInt1, paramString2);
      return this.h.PostMessage(0, null, paramInt1);
    }
  }
  
  public boolean a(byte[] arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.h == null) {
      return false;
    }
    b localb = new b(???, paramInt1, paramInt2, paramInt3);
    paramInt1 = d();
    synchronized (this.c)
    {
      this.b.put(paramInt1, localb);
      return this.h.PostMessage(2, null, paramInt1);
    }
  }
  
  public void b(a parama)
  {
    this.d = false;
    a locala = (a)this.a.get();
    if (locala == null) {
      return;
    }
    locala.b(parama);
  }
  
  public void b(a parama, int paramInt)
  {
    a locala = (a)this.a.get();
    if (locala == null) {
      return;
    }
    locala.b(parama, paramInt);
  }
  
  public boolean b()
  {
    if (this.h == null) {
      return false;
    }
    this.h.removeAllSendData();
    boolean bool = this.h.stop();
    synchronized (this.c)
    {
      this.b.clear();
      return bool;
    }
  }
  
  public void c()
  {
    if (this.h != null) {}
    try
    {
      this.h.wakeUp();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.upload.common.b.c(this.f, "wake up err : ", localThrowable);
    }
  }
  
  public void c(a parama, int paramInt)
  {
    a locala = (a)this.a.get();
    if (locala == null) {
      return;
    }
    locala.c(parama, paramInt);
  }
  
  public int hashCode()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      return ((a)this.a.get()).hashCode();
    }
    return super.hashCode();
  }
  
  private static final class a
  {
    public final String a;
    public final int b;
    public final String c;
    public final int d;
    public final int e;
    
    public a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
    {
      this.a = paramString1;
      this.b = paramInt1;
      this.c = paramString2;
      this.d = paramInt2;
      this.e = paramInt3;
    }
  }
  
  private static final class b
  {
    public final byte[] a;
    public final int b;
    public final int c;
    public final int d;
    
    public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramArrayOfByte;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.base.c
 * JD-Core Version:    0.7.0.1
 */