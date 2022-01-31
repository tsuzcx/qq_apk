package com.tencent.tvkbeacon.core.b;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.tvkbeacon.core.info.b;
import com.tencent.tvkbeacon.core.protocol.common.RequestPackage;
import com.tencent.tvkbeacon.core.protocol.common.ResponsePackage;
import com.tencent.tvkbeacon.core.protocol.common.SocketResponsePackage;
import com.tencent.tvkbeacon.upload.UploadHandleListener;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h
  implements g
{
  private static volatile h a = null;
  private SparseArray<f> b = new SparseArray(5);
  private List<UploadHandleListener> c = new ArrayList(5);
  private ArrayList<i> d = new ArrayList(5);
  private Context e = null;
  private boolean f = true;
  private final int g = 1;
  private final String h = "test";
  private final String i = "test";
  private int j = 0;
  private boolean k = true;
  
  private h(Context paramContext)
  {
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    if (localContext != null)
    {
      this.e = localContext;
      return;
    }
    this.e = paramContext;
  }
  
  public static h a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new h(paramContext);
        com.tencent.tvkbeacon.core.c.c.h("[net] create upload handler successfully.", new Object[0]);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private ResponsePackage a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        Object localObject = com.tencent.tvkbeacon.core.strategy.d.a(this.e);
        if (localObject == null) {
          break label68;
        }
        paramArrayOfByte = com.tencent.tvkbeacon.core.c.a.d(paramArrayOfByte, ((com.tencent.tvkbeacon.core.strategy.d)localObject).b());
        if (paramArrayOfByte != null)
        {
          localObject = new com.tencent.tvkbeacon.core.wup.c();
          ((com.tencent.tvkbeacon.core.wup.c)localObject).a(paramArrayOfByte);
          paramArrayOfByte = (ResponsePackage)((com.tencent.tvkbeacon.core.wup.c)localObject).b("detail", new ResponsePackage());
          return paramArrayOfByte;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        com.tencent.tvkbeacon.core.c.c.a(paramArrayOfByte);
      }
      return null;
      label68:
      paramArrayOfByte = null;
    }
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    UploadHandleListener[] arrayOfUploadHandleListener = d();
    if (arrayOfUploadHandleListener != null)
    {
      int n = arrayOfUploadHandleListener.length;
      int m = 0;
      while (m < n)
      {
        arrayOfUploadHandleListener[m].onUploadEnd(paramInt1, paramInt2, paramLong1, paramLong2, paramBoolean, paramString);
        m += 1;
      }
    }
  }
  
  private void a(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3)
  {
    if ((paramInt1 != 0) && (paramLong1 != 0L))
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).record(paramInt1, paramBoolean, paramLong2, paramLong1, paramInt2, paramInt3, paramString1, paramString2, paramInt4, paramString3);
      }
    }
  }
  
  private static boolean a(SparseArray<f> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramSparseArray == null) || (paramArrayOfByte == null)) {
      return true;
    }
    paramSparseArray = (f)paramSparseArray.get(paramInt);
    if (paramSparseArray == null)
    {
      com.tencent.tvkbeacon.core.c.c.c("[net] no handler key:%d", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    try
    {
      com.tencent.tvkbeacon.core.c.c.b("[net] key:%d  handler: %s", new Object[] { Integer.valueOf(paramInt), paramSparseArray.getClass().toString() });
      paramSparseArray.a(paramInt, paramArrayOfByte, true);
      return true;
    }
    catch (Throwable paramSparseArray)
    {
      com.tencent.tvkbeacon.core.c.c.a(paramSparseArray);
      com.tencent.tvkbeacon.core.c.c.d("[net] handle error key:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    return false;
  }
  
  private byte[] b(a parama)
  {
    if (parama != null) {
      try
      {
        Object localObject1 = parama.a();
        if (localObject1 != null)
        {
          com.tencent.tvkbeacon.core.c.c.b("[net] RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d", new Object[] { ((RequestPackage)localObject1).appkey, ((RequestPackage)localObject1).sdkId, ((RequestPackage)localObject1).appVersion, Integer.valueOf(((RequestPackage)localObject1).cmd) });
          Object localObject2 = new com.tencent.tvkbeacon.core.wup.c();
          ((com.tencent.tvkbeacon.core.wup.c)localObject2).a.iRequestId = 1;
          ((com.tencent.tvkbeacon.core.wup.c)localObject2).a.sServantName = "test";
          ((com.tencent.tvkbeacon.core.wup.c)localObject2).a.sFuncName = "test";
          ((com.tencent.tvkbeacon.core.wup.c)localObject2).a("detail", localObject1);
          localObject1 = ((com.tencent.tvkbeacon.core.wup.c)localObject2).a();
          com.tencent.tvkbeacon.core.c.c.b("[event] reqPackage to wup byte size: %d", new Object[] { Integer.valueOf(localObject1.length) });
          localObject2 = com.tencent.tvkbeacon.core.strategy.d.a(this.e);
          if (localObject2 != null)
          {
            localObject1 = com.tencent.tvkbeacon.core.c.a.c((byte[])localObject1, ((com.tencent.tvkbeacon.core.strategy.d)localObject2).b());
            com.tencent.tvkbeacon.core.c.c.b("[event] wup through zip->encry byte size: %d", new Object[] { Integer.valueOf(localObject1.length) });
            return localObject1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.tvkbeacon.core.c.c.d("[event] parseSendData error", new Object[0]);
        com.tencent.tvkbeacon.core.c.c.a(localThrowable);
        parama.b();
      }
    }
    return null;
  }
  
  /* Error */
  private UploadHandleListener[] d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/tencent/tvkbeacon/core/b/h:c	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 49	com/tencent/tvkbeacon/core/b/h:c	Ljava/util/List;
    //   13: invokeinterface 243 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 49	com/tencent/tvkbeacon/core/b/h:c	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 122	com/tencent/tvkbeacon/upload/UploadHandleListener
    //   29: invokeinterface 247 2 0
    //   34: checkcast 249	[Lcom/tencent/tvkbeacon/upload/UploadHandleListener;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	h
    //   37	7	1	arrayOfUploadHandleListener	UploadHandleListener[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  private e e()
  {
    try
    {
      e locale = e.a(this.e);
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private SparseArray<f> f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/tvkbeacon/core/b/h:b	Landroid/util/SparseArray;
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: getfield 44	com/tencent/tvkbeacon/core/b/h:b	Landroid/util/SparseArray;
    //   13: invokevirtual 257	android/util/SparseArray:size	()I
    //   16: ifle +23 -> 39
    //   19: new 259	com/tencent/tvkbeacon/core/c/g
    //   22: dup
    //   23: invokespecial 260	com/tencent/tvkbeacon/core/c/g:<init>	()V
    //   26: pop
    //   27: aload_0
    //   28: getfield 44	com/tencent/tvkbeacon/core/b/h:b	Landroid/util/SparseArray;
    //   31: invokestatic 263	com/tencent/tvkbeacon/core/c/g:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aconst_null
    //   40: astore_1
    //   41: goto -6 -> 35
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	h
    //   34	7	1	localSparseArray	SparseArray
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	44	finally
  }
  
  public final void a(a parama)
  {
    int i2 = parama.c();
    if ((!a()) || (!b())) {
      if (i2 == 2)
      {
        com.tencent.tvkbeacon.core.c.c.h("[event] Not UpProc real event sync 2 DB done false", new Object[0]);
        parama.b(false);
      }
    }
    do
    {
      return;
      com.tencent.tvkbeacon.core.c.c.h("[event] NotUpProcess, don't upload, return!", new Object[0]);
      return;
      if (com.tencent.tvkbeacon.core.c.d.b(this.e)) {
        break;
      }
      com.tencent.tvkbeacon.core.c.c.c("[net] doUpload network is disabled or qimei is empty", new Object[0]);
    } while (i2 != 2);
    parama.b(false);
    return;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    int i1 = -1;
    Object localObject6 = parama.e();
    if ((localObject6 == null) || ("".equals(((String)localObject6).trim())))
    {
      com.tencent.tvkbeacon.core.c.c.d("[net] url error", new Object[0]);
      if (i2 == 2) {
        parama.b(false);
      }
      a(i2, -1, 0L, 0L, false, "url error");
      return;
    }
    byte[] arrayOfByte = b(parama);
    if (arrayOfByte == null)
    {
      com.tencent.tvkbeacon.core.c.c.c("[event] sendData is null", new Object[0]);
      a(i2, -1, 0L, 0L, false, "sendData error");
      return;
    }
    e locale = e();
    if (locale == null)
    {
      com.tencent.tvkbeacon.core.c.c.d("[net] reqH is null.", new Object[0]);
      a(i2, -1, 0L, 0L, false, "reqHandler error");
      return;
    }
    Object localObject5;
    Object localObject1;
    Object localObject7;
    label357:
    label361:
    c localc;
    long l1;
    int m;
    boolean bool2;
    boolean bool3;
    if (!locale.a())
    {
      localObject5 = parama.d();
      localObject1 = null;
      if (localObject5 != null) {
        localObject1 = "?rid=".concat(String.valueOf(localObject5));
      }
      localObject7 = com.tencent.tvkbeacon.core.strategy.d.a(this.e);
      localObject5 = localObject1;
      if (localObject7 != null)
      {
        localObject7 = ((com.tencent.tvkbeacon.core.strategy.d)localObject7).a();
        localObject5 = localObject1;
        if (localObject7 != null)
        {
          localObject5 = localObject1;
          if (!"".equals(localObject7))
          {
            if (localObject1 != null) {
              break label1205;
            }
            localObject5 = "?sid=".concat(String.valueOf(localObject7));
          }
        }
      }
      if (localObject5 != null)
      {
        localObject1 = (String)localObject6 + (String)localObject5;
        localObject5 = localObject1;
        com.tencent.tvkbeacon.core.c.c.h("[net] start upload cmd: %d  url:%s  data type:%s", new Object[] { Integer.valueOf(i2), localObject5, parama.getClass().getSimpleName() });
        localObject7 = com.tencent.tvkbeacon.core.info.d.i(this.e);
        localc = new c();
        l1 = com.tencent.tvkbeacon.core.c.a.a(b.a(this.e).i()) / 1000L;
        m = i1;
        bool2 = bool4;
        bool3 = bool5;
      }
    }
    for (;;)
    {
      int n;
      try
      {
        if (!locale.a()) {
          continue;
        }
        m = i1;
        bool2 = bool4;
        bool3 = bool5;
        localObject5 = locale.a((String)localObject5, com.tencent.tvkbeacon.core.strategy.d.a(this.e).f(), arrayOfByte, parama, localc);
        localObject1 = localObject5;
        if (localObject5 != null)
        {
          m = i1;
          bool2 = bool4;
          bool3 = bool5;
          localObject1 = new SocketResponsePackage();
          m = i1;
          bool2 = bool4;
          bool3 = bool5;
          ((SocketResponsePackage)localObject1).readFrom(new com.tencent.tvkbeacon.core.wup.a((byte[])localObject5));
          m = i1;
          bool2 = bool4;
          bool3 = bool5;
          com.tencent.tvkbeacon.core.c.c.b("[net] received body size:%d |statusCode:%d |header:%s |msg:%s", new Object[] { Integer.valueOf(((SocketResponsePackage)localObject1).body.length), Integer.valueOf(((SocketResponsePackage)localObject1).statusCode), ((SocketResponsePackage)localObject1).header, ((SocketResponsePackage)localObject1).msg });
          m = i1;
          bool2 = bool4;
          bool3 = bool5;
          localObject6 = ((SocketResponsePackage)localObject1).header;
          m = i1;
          bool2 = bool4;
          bool3 = bool5;
          if (((Map)localObject6).containsKey("session_id"))
          {
            m = i1;
            bool2 = bool4;
            bool3 = bool5;
            if (((Map)localObject6).containsKey("max_time"))
            {
              m = i1;
              bool2 = bool4;
              bool3 = bool5;
              localObject5 = (String)((Map)localObject6).get("session_id");
              m = i1;
              bool2 = bool4;
              bool3 = bool5;
              localObject6 = (String)((Map)localObject6).get("max_time");
              m = i1;
              bool2 = bool4;
              bool3 = bool5;
              com.tencent.tvkbeacon.core.strategy.d.a(this.e).a(this.e, (String)localObject5, (String)localObject6);
            }
          }
          m = i1;
          bool2 = bool4;
          bool3 = bool5;
          localObject1 = ((SocketResponsePackage)localObject1).body;
        }
        m = i1;
        bool2 = bool4;
        bool3 = bool5;
        l2 = localc.b();
        m = i1;
        bool2 = bool4;
        bool3 = bool5;
        l3 = localc.c();
        m = i1;
        bool2 = bool4;
        bool3 = bool5;
        localObject1 = a((byte[])localObject1);
        n = i1;
        if (localObject1 != null)
        {
          m = i1;
          bool2 = bool4;
          bool3 = bool5;
          n = ((ResponsePackage)localObject1).cmd;
          m = n;
          bool2 = bool4;
          bool3 = bool5;
          if (((ResponsePackage)localObject1).result != 0) {
            break label1879;
          }
          bool1 = true;
          m = n;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.tvkbeacon.core.c.c.b("[net] response cmd:%d result:%d", new Object[] { Integer.valueOf(((ResponsePackage)localObject1).cmd), Byte.valueOf(((ResponsePackage)localObject1).result) });
        }
        if (localObject1 != null)
        {
          m = n;
          bool2 = bool1;
          bool3 = bool1;
          localObject5 = b.a(this.e);
          if (localObject5 != null)
          {
            m = n;
            bool2 = bool1;
            bool3 = bool1;
            if (((ResponsePackage)localObject1).srcGatewayIp != null)
            {
              m = n;
              bool2 = bool1;
              bool3 = bool1;
              ((b)localObject5).c(((ResponsePackage)localObject1).srcGatewayIp.trim());
            }
            m = n;
            bool2 = bool1;
            bool3 = bool1;
            localObject6 = new Date();
            m = n;
            bool2 = bool1;
            bool3 = bool1;
            ((b)localObject5).a(((ResponsePackage)localObject1).serverTime - ((Date)localObject6).getTime());
            m = n;
            bool2 = bool1;
            bool3 = bool1;
            com.tencent.tvkbeacon.core.c.c.h("[net] fix ip:%s  tmgap: %d", new Object[] { ((b)localObject5).h(), Long.valueOf(((b)localObject5).i()) });
          }
          m = n;
          bool2 = bool1;
          bool3 = bool1;
          localObject5 = ((ResponsePackage)localObject1).sBuffer;
          if (localObject5 != null) {
            continue;
          }
          m = n;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.tvkbeacon.core.c.c.h("[net] no response! ", new Object[0]);
        }
      }
      catch (Throwable localThrowable)
      {
        long l2;
        long l3;
        localThrowable = localThrowable;
        try
        {
          l2 = localc.b();
          l3 = localc.c();
          localObject5 = localThrowable.toString().replace("java.lang.Exception: ", "");
          a(i2, m, l2, l3, false, (String)localObject5);
          a(i2, l2, false, l1, (int)localc.e(), parama.f(), (String)localObject7, localc.f(), localc.d(), (String)localObject5);
          if ((com.tencent.tvkbeacon.core.strategy.d.a(this.e).d()) && ((localThrowable instanceof ConnectException))) {
            com.tencent.tvkbeacon.core.strategy.d.a(this.e).e();
          }
          com.tencent.tvkbeacon.core.c.c.d("[net] req error  %s", new Object[] { localThrowable.toString() });
          parama.b(bool2);
          return;
        }
        finally
        {
          for (;;)
          {
            int i3;
            String str;
            bool3 = bool2;
          }
        }
        m = n;
        bool2 = bool1;
        bool3 = bool1;
        i1 = parama.c();
        m = n;
        bool2 = bool1;
        bool3 = bool1;
        i3 = localThrowable.cmd;
        if (i3 != 0) {
          break label1620;
        }
        m = n;
        bool2 = bool1;
        bool3 = bool1;
        com.tencent.tvkbeacon.core.c.c.h("[net] response with no data", new Object[0]);
        continue;
      }
      finally {}
      m = n;
      bool2 = bool1;
      bool3 = bool1;
      a(i2, n, l2, l3, bool1, null);
      if (localObject1 != null)
      {
        m = n;
        bool2 = bool1;
        bool3 = bool1;
        localObject1 = String.valueOf(((ResponsePackage)localObject1).result);
        m = n;
        bool2 = bool1;
        bool3 = bool1;
        a(i2, l2, bool1, l1, (int)localc.e(), parama.f(), (String)localObject7, localc.f(), localc.d(), (String)localObject1);
        parama.b(bool1);
        return;
        label1205:
        localObject5 = (String)localObject1 + "&sid=" + (String)localObject7;
        break;
        m = i1;
        bool2 = bool4;
        bool3 = bool5;
        localObject6 = locale.a((String)localObject5, arrayOfByte, parama, localc);
        localObject1 = localObject6;
        if (localObject6 != null) {
          continue;
        }
        localObject1 = localObject6;
        m = i1;
        bool2 = bool4;
        bool3 = bool5;
        if (parama.c() != 100) {
          continue;
        }
        localObject1 = localObject6;
        m = i1;
        bool2 = bool4;
        bool3 = bool5;
        if ("http://strategy.beacon.qq.com/analytics/upload".equals(localObject5)) {
          continue;
        }
        m = i1;
        bool2 = bool4;
        bool3 = bool5;
        localObject1 = locale.a("http://strategy.beacon.qq.com/analytics/upload", arrayOfByte, parama, localc);
        continue;
        m = n;
        bool2 = bool1;
        bool3 = bool1;
        localObject6 = f();
        if (localObject6 != null)
        {
          m = n;
          bool2 = bool1;
          bool3 = bool1;
          if (((SparseArray)localObject6).size() > 0) {}
        }
        else
        {
          m = n;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.tvkbeacon.core.c.c.h("[net] no handler! ", new Object[0]);
          continue;
        }
        parama.b(bool3);
        throw localObject2;
        switch (i1)
        {
        default: 
          m = n;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.tvkbeacon.core.c.c.c("[net] unknown req: %d ", new Object[] { Integer.valueOf(i1) });
          break;
        case 100: 
          if (i3 != 101)
          {
            m = n;
            bool2 = bool1;
            bool3 = bool1;
            com.tencent.tvkbeacon.core.c.c.c("[net] UNMATCH req: %d , rep: %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i3) });
          }
          break;
        case 4: 
          if (i3 != 105)
          {
            m = n;
            bool2 = bool1;
            bool3 = bool1;
            com.tencent.tvkbeacon.core.c.c.c("[net] UNMATCH req: %d , rep: %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i3) });
          }
          break;
        case 102: 
          label1620:
          if (i3 != 103)
          {
            m = n;
            bool2 = bool1;
            bool3 = bool1;
            com.tencent.tvkbeacon.core.c.c.c("[net] UNMATCH req: %d  , rep: %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i3) });
            continue;
          }
          m = n;
          bool2 = bool1;
          bool3 = bool1;
          a((SparseArray)localObject6, i3, (byte[])localObject5);
          break;
        }
      }
      str = "response null";
      continue;
      Object localObject4 = localObject6;
      break label357;
      localObject5 = localObject6;
      break label361;
      label1879:
      bool1 = false;
    }
  }
  
  public final void a(i parami)
  {
    this.d.add(parami);
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean a(int paramInt, f paramf)
  {
    boolean bool;
    if (paramf == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.b.append(paramInt, paramf);
        bool = true;
      }
      finally {}
    }
  }
  
  public final boolean a(UploadHandleListener paramUploadHandleListener)
  {
    boolean bool;
    if (paramUploadHandleListener == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        if (!this.c.contains(paramUploadHandleListener)) {
          this.c.add(paramUploadHandleListener);
        }
        bool = true;
      }
      finally {}
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    try
    {
      this.k = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 53	com/tencent/tvkbeacon/core/b/h:e	Landroid/content/Context;
    //   6: invokestatic 529	com/tencent/tvkbeacon/core/c/d:a	(Landroid/content/Context;)Z
    //   9: ifne +12 -> 21
    //   12: aload_0
    //   13: getfield 67	com/tencent/tvkbeacon/core/b/h:k	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	h
    //   16	13	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  public final ArrayList<i> c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.b.h
 * JD-Core Version:    0.7.0.1
 */