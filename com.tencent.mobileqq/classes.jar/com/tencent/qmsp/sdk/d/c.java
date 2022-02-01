package com.tencent.qmsp.sdk.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.a.e;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.k;
import com.tencent.qmsp.sdk.f.m;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class c
  implements Handler.Callback
{
  private ConcurrentHashMap<String, com.tencent.qmsp.sdk.b.b> a = new ConcurrentHashMap();
  private Handler b = new Handler(com.tencent.qmsp.sdk.app.b.e().b(), this);
  final Object c = new Object();
  private int d = 0;
  private d.b e = null;
  private String f = "";
  private String g = "";
  private SharedPreferences h = null;
  private b i = null;
  private int j = 0;
  
  public c(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.qmsp.sdk.c.b.a);
    localStringBuilder.append(a(d.b));
    this.h = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
    this.i = new b();
  }
  
  private int a(int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    try
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "No matched update from server.");
      return -1;
    }
    catch (Exception paramString)
    {
      String str;
      boolean bool;
      paramString.printStackTrace();
    }
    if (this.h.getInt(a(d.d), 0) < paramInt) {
      return 0;
    }
    str = c();
    if (!new File(str).exists()) {
      return 0;
    }
    str = a.a(str);
    if (str != null)
    {
      if (!str.equalsIgnoreCase(paramString)) {
        return 0;
      }
      if (str != null)
      {
        bool = str.equalsIgnoreCase(paramString);
        if (bool) {
          return 1;
        }
      }
    }
    else
    {
      return 0;
    }
    return -1;
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    return k.a(paramArrayOfByte);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject2 = com.tencent.qmsp.sdk.a.d.a(2);
      if (localObject2 == null) {
        return;
      }
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put(e.a(20), paramInt1);
      localJSONObject2.put(e.a(21), paramInt2);
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put(e.a(15), localObject2);
      localJSONObject1.put(e.a(16), localJSONObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[SFU] request : ");
      ((StringBuilder)localObject2).append(localJSONObject1.toString());
      com.tencent.qmsp.sdk.f.g.d("Qp.QUM", 0, ((StringBuilder)localObject2).toString());
      com.tencent.qmsp.sdk.b.g.b().a(2, QmspSDK.getAppID(), 2, localJSONObject1, new c.b(this));
      int k = this.j;
      a("0X80078AA", paramInt1, k, "", "");
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] send update query: fileid=%d, localversion=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return;
    }
    finally
    {
      localObject1.printStackTrace();
    }
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    String str = String.format("%d", new Object[] { Integer.valueOf(paramInt1) });
    Object localObject = this.e;
    if (localObject != null) {
      paramInt1 = (int)((d.b)localObject).b;
    } else {
      paramInt1 = 0;
    }
    localObject = this.e;
    if (localObject != null) {
      localObject = String.format("%d", new Object[] { Long.valueOf(((d.b)localObject).a) });
    } else {
      localObject = "";
    }
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] report: actiontype=%s, actionname=%s, actionfrom=%d, actionresult=%d, sectionId=%s, reportId=%s, fileInfo: %s", new Object[] { paramString1, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(this.d), localObject, str, "", "" }));
    com.tencent.qmsp.sdk.a.g localg = new com.tencent.qmsp.sdk.a.g();
    try
    {
      localg.a(paramString1).a(str).a((String)localObject).a(this.d).a(paramInt2).a(paramString2).a(paramString3);
      com.tencent.qmsp.sdk.a.f.a(localg.toString(), 2);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      com.tencent.qmsp.sdk.f.g.b(com.tencent.qmsp.sdk.f.g.a, 0, "onReport error! <JsonObject userData>!");
    }
  }
  
  private void a(boolean paramBoolean, com.tencent.qmsp.sdk.b.b paramb)
  {
    if ((paramBoolean) && (paramb != null))
    {
      File localFile = new File(paramb.b);
      c.c localc = (c.c)paramb.a();
      if ((localFile.exists()) && (localc != null))
      {
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] http download complete: %s, %s", new Object[] { paramb.b, localc.e }));
        int k = localc.a;
        if (k != 1)
        {
          if (k != 2) {
            return;
          }
          a("0X80078AE", localc.g, this.j, "", "");
          k = 7;
        }
        for (;;)
        {
          b(k);
          return;
          localFile = new File(c());
          new File(paramb.b).renameTo(localFile);
          a("0X80078AC", localc.g, this.j, "", "");
          if (!this.i.a(localFile.toString())) {
            break;
          }
          this.h.edit().putInt(a(d.d), localc.g).commit();
          if (this.i.a().isEmpty())
          {
            com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] config ok but without any sections");
            k = 16;
          }
          else
          {
            k = 5;
          }
        }
        a("0X80078AD", localc.g, this.j, localc.d, localc.e);
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] invalid config (sig not accepted)");
        a(1);
        return;
      }
      a(3);
      return;
    }
    a(3);
  }
  
  private boolean a(c.c paramc)
  {
    if (paramc == null) {
      return false;
    }
    if ((paramc.a == 2) && (paramc.k != 1) && (!com.tencent.qmsp.sdk.f.f.b(QmspSDK.getContext())))
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] donot download file because not using wifi");
      com.tencent.qmsp.sdk.a.a.a(3, 3);
      return false;
    }
    if ((paramc.i < 3) && (this.a.contains(paramc.f.toLowerCase()))) {
      return false;
    }
    com.tencent.qmsp.sdk.b.b localb = new com.tencent.qmsp.sdk.b.b();
    localb.a = paramc.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramc.c);
    localStringBuilder.append(paramc.d);
    localb.b = localStringBuilder.toString();
    localb.d = paramc.d;
    localb.c = paramc.c;
    paramc.i += 1;
    localb.a(paramc);
    this.a.put(paramc.f.toLowerCase(), localb);
    try
    {
      com.tencent.qmsp.sdk.b.d.a(localb);
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] begin http download %s", new Object[] { paramc.e }));
    return true;
  }
  
  private boolean a(d.b paramb)
  {
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] backup: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      long l2 = paramb.r;
      long l1 = 0L;
      int k = l2 < 0L;
      if (k == 0) {
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] no files need to backup");
      }
      do
      {
        bool = true;
        break label244;
        if (k <= 0) {
          break;
        }
        String str = f(paramb);
        k = 0;
        while (k < paramb.q.size())
        {
          d.a locala = (d.a)paramb.q.get(k);
          l2 = l1;
          if (1 == locala.j)
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(locala.c);
            localObject = ((StringBuilder)localObject).toString();
            a(new File(locala.f), new File((String)localObject));
            l2 = l1 + 1L;
          }
          int m;
          k += 1;
          l1 = l2;
        }
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] backup %d files of %d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramb.q.size()) }));
      } while (paramb.r == l1);
    }
    boolean bool = false;
    label244:
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] backup result: %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  /* Error */
  private boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_2
    //   10: invokevirtual 132	java/io/File:exists	()Z
    //   13: ifeq +12 -> 25
    //   16: aload_2
    //   17: invokevirtual 406	java/io/File:delete	()Z
    //   20: ifne +36 -> 56
    //   23: iconst_0
    //   24: ireturn
    //   25: new 125	java/io/File
    //   28: dup
    //   29: aload_2
    //   30: invokevirtual 409	java/io/File:getParent	()Ljava/lang/String;
    //   33: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 6
    //   38: aload 6
    //   40: invokevirtual 132	java/io/File:exists	()Z
    //   43: ifne +13 -> 56
    //   46: aload 6
    //   48: invokevirtual 412	java/io/File:mkdirs	()Z
    //   51: ifne +5 -> 56
    //   54: iconst_0
    //   55: ireturn
    //   56: new 414	java/io/FileOutputStream
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 417	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: astore_2
    //   65: aload 4
    //   67: astore 5
    //   69: aload_2
    //   70: astore 4
    //   72: new 419	java/io/BufferedInputStream
    //   75: dup
    //   76: new 421	java/io/FileInputStream
    //   79: dup
    //   80: aload_1
    //   81: invokespecial 422	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   84: invokespecial 425	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   87: astore_1
    //   88: invokestatic 430	com/tencent/qmsp/sdk/f/a:a	()Lcom/tencent/qmsp/sdk/f/a;
    //   91: sipush 4096
    //   94: invokevirtual 433	com/tencent/qmsp/sdk/f/a:a	(I)[B
    //   97: astore 4
    //   99: aload_1
    //   100: aload 4
    //   102: invokevirtual 437	java/io/BufferedInputStream:read	([B)I
    //   105: istore_3
    //   106: iload_3
    //   107: iconst_m1
    //   108: if_icmpeq +18 -> 126
    //   111: aload_2
    //   112: aload 4
    //   114: iconst_0
    //   115: iload_3
    //   116: invokevirtual 441	java/io/FileOutputStream:write	([BII)V
    //   119: aload_2
    //   120: invokevirtual 444	java/io/FileOutputStream:flush	()V
    //   123: goto -24 -> 99
    //   126: invokestatic 430	com/tencent/qmsp/sdk/f/a:a	()Lcom/tencent/qmsp/sdk/f/a;
    //   129: aload 4
    //   131: invokevirtual 447	com/tencent/qmsp/sdk/f/a:a	([B)V
    //   134: aload_2
    //   135: invokevirtual 450	java/io/FileOutputStream:close	()V
    //   138: aload_1
    //   139: invokevirtual 451	java/io/BufferedInputStream:close	()V
    //   142: iconst_1
    //   143: ireturn
    //   144: astore 4
    //   146: aload_1
    //   147: astore 5
    //   149: aload 4
    //   151: astore_1
    //   152: goto +68 -> 220
    //   155: astore 6
    //   157: goto +31 -> 188
    //   160: astore_1
    //   161: aload 4
    //   163: astore_2
    //   164: goto +56 -> 220
    //   167: astore 6
    //   169: aload 7
    //   171: astore_1
    //   172: goto +16 -> 188
    //   175: astore_1
    //   176: aconst_null
    //   177: astore_2
    //   178: goto +42 -> 220
    //   181: astore 6
    //   183: aconst_null
    //   184: astore_2
    //   185: aload 7
    //   187: astore_1
    //   188: aload_1
    //   189: astore 5
    //   191: aload_2
    //   192: astore 4
    //   194: aload 6
    //   196: invokevirtual 361	java/io/IOException:printStackTrace	()V
    //   199: aload_2
    //   200: ifnull +10 -> 210
    //   203: aload_2
    //   204: invokevirtual 450	java/io/FileOutputStream:close	()V
    //   207: goto +3 -> 210
    //   210: aload_1
    //   211: ifnull +7 -> 218
    //   214: aload_1
    //   215: invokevirtual 451	java/io/BufferedInputStream:close	()V
    //   218: iconst_0
    //   219: ireturn
    //   220: aload_2
    //   221: ifnull +10 -> 231
    //   224: aload_2
    //   225: invokevirtual 450	java/io/FileOutputStream:close	()V
    //   228: goto +3 -> 231
    //   231: aload 5
    //   233: ifnull +8 -> 241
    //   236: aload 5
    //   238: invokevirtual 451	java/io/BufferedInputStream:close	()V
    //   241: goto +5 -> 246
    //   244: aload_1
    //   245: athrow
    //   246: goto -2 -> 244
    //   249: astore_2
    //   250: goto -112 -> 138
    //   253: astore_1
    //   254: iconst_1
    //   255: ireturn
    //   256: astore_2
    //   257: goto -47 -> 210
    //   260: astore_1
    //   261: iconst_0
    //   262: ireturn
    //   263: astore_2
    //   264: goto -33 -> 231
    //   267: astore_2
    //   268: goto -27 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	c
    //   0	271	1	paramFile1	File
    //   0	271	2	paramFile2	File
    //   105	11	3	k	int
    //   7	123	4	localObject1	Object
    //   144	18	4	localObject2	Object
    //   192	1	4	localFile1	File
    //   4	233	5	localObject3	Object
    //   36	11	6	localFile2	File
    //   155	1	6	localIOException1	IOException
    //   167	1	6	localIOException2	IOException
    //   181	14	6	localIOException3	IOException
    //   1	185	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   88	99	144	finally
    //   99	106	144	finally
    //   111	123	144	finally
    //   126	134	144	finally
    //   88	99	155	java/io/IOException
    //   99	106	155	java/io/IOException
    //   111	123	155	java/io/IOException
    //   126	134	155	java/io/IOException
    //   72	88	160	finally
    //   194	199	160	finally
    //   72	88	167	java/io/IOException
    //   9	23	175	finally
    //   25	54	175	finally
    //   56	65	175	finally
    //   9	23	181	java/io/IOException
    //   25	54	181	java/io/IOException
    //   56	65	181	java/io/IOException
    //   134	138	249	java/io/IOException
    //   138	142	253	java/io/IOException
    //   203	207	256	java/io/IOException
    //   214	218	260	java/io/IOException
    //   224	228	263	java/io/IOException
    //   236	241	267	java/io/IOException
  }
  
  private void b()
  {
    try
    {
      this.h.edit().putLong(a(d.c), System.currentTimeMillis()).commit();
      b(2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b(int paramInt)
  {
    int m = 0;
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 2, String.format("[SFU] update event: %d", new Object[] { Integer.valueOf(paramInt) }));
    int n = 6;
    int k = 8;
    if (paramInt != 1) {
      if (paramInt != 2) {
        switch (paramInt)
        {
        default: 
          return;
        }
      }
    }
    try
    {
      h();
      return;
    }
    finally
    {
      boolean bool;
      label472:
      localObject.printStackTrace();
      label525:
      return;
    }
    g();
    break label539;
    i(this.e);
    this.e = null;
    if (f())
    {
      break label573;
      if (this.e == null) {
        break label567;
      }
      b(this.e);
      break label567;
      if (this.e != null)
      {
        bool = j(this.e);
        if (bool)
        {
          paramInt = m;
          break label472;
        }
      }
      paramInt = this.j;
      a("0X80078B3", 0, paramInt, "", "");
      paramInt = 10;
      break label472;
      if ((this.e == null) || (!c(this.e))) {
        break label550;
      }
      paramInt = m;
      break label472;
      paramInt = k;
      if (this.e != null)
      {
        paramInt = k;
        if (m(this.e))
        {
          paramInt = 12;
          break label525;
          if ((this.e == null) || (!l(this.e))) {
            break label556;
          }
          paramInt = 11;
          break label525;
        }
      }
      c(paramInt);
      paramInt = 13;
      break label525;
      if (this.e != null)
      {
        bool = a(this.e);
        if (bool)
        {
          paramInt = 10;
          break label525;
        }
      }
      paramInt = this.j;
      a("0X80078B1", 0, paramInt, "", "");
      paramInt = 6;
      break label472;
      if (this.e != null)
      {
        bool = k(this.e);
        if (bool)
        {
          paramInt = 9;
          break label525;
        }
      }
      paramInt = this.j;
      a("0X80078B0", 0, paramInt, "", "");
      paramInt = 5;
      break label472;
      if (this.e != null)
      {
        bool = n(this.e);
        if (bool)
        {
          paramInt = 8;
          break label525;
        }
      }
      paramInt = this.j;
      a("0X80078AF", 0, paramInt, "", "");
      paramInt = 4;
      break label472;
      if ((this.e == null) || (!d(this.e))) {
        break label562;
      }
      return;
      a(paramInt);
      return;
      if ((!d()) || (this.e == null)) {
        break label573;
      }
      paramInt = n;
      if (!e(this.e))
      {
        break label567;
        i();
        return;
        if (this.d != 1) {
          break label579;
        }
      }
    }
    for (;;)
    {
      b(paramInt);
      return;
      label539:
      paramInt = 17;
      continue;
      paramInt = 5;
      continue;
      label550:
      paramInt = 9;
      break label472;
      label556:
      paramInt = 7;
      break;
      label562:
      paramInt = 3;
      break label472;
      label567:
      paramInt = 15;
      continue;
      label573:
      paramInt = 16;
      continue;
      label579:
      paramInt = 14;
    }
  }
  
  private void b(com.tencent.qmsp.sdk.b.c paramc)
  {
    if (paramc == null) {
      return;
    }
    int k = paramc.a;
    if (k == 2)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] http download error=%d", new Object[] { Integer.valueOf(k) }));
      return;
    }
    c.c localc = (c.c)paramc.b.a();
    if (localc == null) {
      return;
    }
    boolean bool;
    if (paramc.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool) {}
    try
    {
      k = localc.i;
      if (k < 3)
      {
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] retried to download, retry=%d, result=%b, url=%s", new Object[] { Integer.valueOf(localc.i), Boolean.valueOf(bool), localc.e }));
        a(localc);
        return;
      }
      File localFile = new File(paramc.b.b);
      if (localFile.exists()) {
        localFile.delete();
      }
      this.a.remove(localc.f.toLowerCase());
      a(bool, paramc.b);
      return;
    }
    finally
    {
      paramc.printStackTrace();
    }
  }
  
  private void b(d.b paramb)
  {
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] cleanup: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      com.tencent.qmsp.sdk.f.d.a(g(paramb), false);
    }
  }
  
  private String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e());
    localStringBuilder.append(a(d.a));
    return localStringBuilder.toString();
  }
  
  private void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  private boolean c(d.b paramb)
  {
    return true;
  }
  
  private boolean d()
  {
    this.e = null;
    List localList = this.i.a();
    int k = 0;
    while (k < localList.size())
    {
      d.b localb = (d.b)localList.get(k);
      if (!localb.a())
      {
        if ((localb.m) && (localb.l) && (localb.n))
        {
          this.e = localb;
          c(0);
          com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] next update: sid=%d", new Object[] { Long.valueOf(this.e.a) }));
          bool = true;
          break label194;
        }
        com.tencent.qmsp.sdk.f.g.d("Qp.QUM", 1, String.format("[SFU] not matched section: sid=%d, os: %b, qq:%b, cpu:%b", new Object[] { Long.valueOf(localb.a), Boolean.valueOf(localb.m), Boolean.valueOf(localb.l), Boolean.valueOf(localb.n) }));
        localb.b();
      }
      k += 1;
    }
    boolean bool = false;
    label194:
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] get next section result? %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  private boolean d(d.b paramb)
  {
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] download package: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      return a(new c.c(2, 0, g(paramb), paramb.c, paramb.e, paramb.d, 0, true, 0, System.currentTimeMillis(), paramb.u));
    }
    return false;
  }
  
  private String e()
  {
    String str = com.tencent.qmsp.sdk.a.b.c();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  private boolean e(d.b paramb)
  {
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] get different: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      List localList = paramb.o;
      int k = 0;
      while (k < localList.size())
      {
        d.a locala = (d.a)localList.get(k);
        if (!new File(locala.f).exists())
        {
          locala.j = 2;
          paramb.q.add(locala);
        }
        else
        {
          String str = a.a(locala.f);
          if ((str == null) || (!str.equalsIgnoreCase(locala.b)))
          {
            locala.j = 1;
            if (str == null) {
              str = "";
            }
            locala.c = str;
            paramb.q.add(locala);
            paramb.r += 1L;
          }
        }
        k += 1;
      }
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] need to update %d files of %d", new Object[] { Integer.valueOf(paramb.q.size()), Integer.valueOf(paramb.o.size()) }));
      return paramb.q.isEmpty() ^ true;
    }
    return false;
  }
  
  private String f(d.b paramb)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(g(paramb));
    ((StringBuilder)localObject).append("bak");
    ((StringBuilder)localObject).append(File.separator);
    paramb = ((StringBuilder)localObject).toString();
    localObject = new File(paramb);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramb;
  }
  
  private boolean f()
  {
    Object localObject = this.i.a();
    int k = 0;
    while (k < ((List)localObject).size())
    {
      if (!((d.b)((List)localObject).get(k)).a())
      {
        bool = false;
        break label50;
      }
      k += 1;
    }
    boolean bool = true;
    label50:
    if (bool) {
      localObject = "yes";
    } else {
      localObject = "no";
    }
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] all complete: %s", new Object[] { localObject }));
    return bool;
  }
  
  private String g(d.b paramb)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(e());
    ((StringBuilder)localObject).append(paramb.a);
    ((StringBuilder)localObject).append(File.separator);
    paramb = ((StringBuilder)localObject).toString();
    localObject = new File(paramb);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramb;
  }
  
  private void g()
  {
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] all sections update complete");
    try
    {
      if (!TextUtils.isEmpty(this.f))
      {
        com.tencent.qmsp.sdk.c.f.i().e();
        this.h.edit().putString(a(d.e), this.f).putString(a(d.f), this.g).commit();
        a("0X80078B6", 0, this.j, this.f, this.g);
      }
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] notify update complete: %s", new Object[] { this.f }));
      return;
    }
    finally
    {
      localObject.printStackTrace();
    }
  }
  
  private String h(d.b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(g(paramb));
    localStringBuilder.append(paramb.c);
    return localStringBuilder.toString();
  }
  
  private void h()
  {
    synchronized (this.c)
    {
      int k = this.j;
      a("0X80078B5", 0, k, "", "");
      this.e = null;
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] update ended");
      return;
    }
  }
  
  private void i()
  {
    a(1, this.h.getInt(a(d.d), 0));
    this.h.edit().remove(a(d.e)).commit();
  }
  
  private void i(d.b paramb)
  {
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] update complete: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      paramb.b();
      if (j())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.f);
        localStringBuilder.append(String.format("#%d#", new Object[] { Long.valueOf(paramb.b) }));
        this.f = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.g);
        localStringBuilder.append(String.format("#%d#", new Object[] { Long.valueOf(paramb.a) }));
        this.g = localStringBuilder.toString();
      }
      a("0X80078B4", 0, this.j, "", "");
    }
  }
  
  private boolean j()
  {
    return this.d == 0;
  }
  
  private boolean j(d.b paramb)
  {
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] rollback: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      if (paramb.p.isEmpty()) {
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] no files need to rollback");
      }
      long l2;
      do
      {
        bool = true;
        break;
        String str = f(paramb);
        l2 = 0L;
        int k = 0;
        while (k < paramb.p.size())
        {
          Object localObject = (d.a)paramb.p.get(k);
          File localFile1 = new File(((d.a)localObject).f);
          File localFile2 = new File(((d.a)localObject).g);
          long l1 = l2;
          if (localFile2.exists())
          {
            if (!localFile2.delete()) {
              localFile2.deleteOnExit();
            }
            l1 = l2 + 1L;
          }
          l2 = l1;
          if (((d.a)localObject).j == 2)
          {
            l2 = l1;
            if (localFile1.exists())
            {
              if (!localFile1.delete()) {
                localFile1.deleteOnExit();
              }
              l2 = l1 + 1L;
            }
          }
          localObject = new File(str, ((d.a)localObject).c);
          l1 = l2;
          if (((File)localObject).exists())
          {
            l1 = l2;
            if (((File)localObject).canRead())
            {
              l1 = l2;
              if (localFile1.exists())
              {
                l1 = l2;
                if (localFile1.canWrite())
                {
                  a((File)localObject, localFile1);
                  l1 = l2 + 1L;
                }
              }
            }
          }
          k += 1;
          l2 = l1;
        }
      } while (l2 == paramb.p.size());
    }
    boolean bool = false;
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] rollback result: %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  private boolean k(d.b paramb)
  {
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] unzip package: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      String str = g(paramb);
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (m.a(h(paramb), str) == 0)
      {
        bool = true;
        break label79;
      }
    }
    boolean bool = false;
    label79:
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] unzip result: %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  private boolean l(d.b paramb)
  {
    if ((paramb != null) && (!paramb.q.isEmpty()))
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] do update files: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      String str = g(paramb);
      int k = 0;
      while (k < paramb.q.size())
      {
        d.a locala = (d.a)paramb.q.get(k);
        File localFile1 = new File(str, locala.b);
        Object localObject = new File(locala.f);
        if ((localFile1.exists()) && (localFile1.canRead()))
        {
          boolean bool2 = a(localFile1, (File)localObject);
          bool1 = bool2;
          if (!bool2)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(locala.f);
            ((StringBuilder)localObject).append(".1");
            localObject = ((StringBuilder)localObject).toString();
            File localFile2 = new File((String)localObject);
            locala.j = 3;
            locala.g = ((String)localObject);
            bool2 = a(localFile1, localFile2);
            com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] copied failed, renamed to: %s", new Object[] { locala.g }));
            bool1 = bool2;
            if (bool2)
            {
              this.h.edit().putString(locala.f, locala.g).commit();
              bool1 = bool2;
            }
          }
          if (bool1)
          {
            com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] success copied: %s", new Object[] { locala.f }));
            paramb.p.add(locala);
            paramb.s += 1L;
          }
          else
          {
            a("0X80078B2", (int)locala.h, this.j, locala.a, locala.b);
            com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] failed copied: %s", new Object[] { locala.f }));
            break;
          }
        }
        else
        {
          com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] copied failed, src not existed or cannot read: %s", new Object[] { localFile1.toString() }));
        }
        k += 1;
      }
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] update %d files of %d", new Object[] { Long.valueOf(paramb.s), Integer.valueOf(paramb.q.size()) }));
      if (paramb.s == paramb.q.size())
      {
        bool1 = true;
        break label485;
      }
    }
    boolean bool1 = false;
    label485:
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] update result: %b", new Object[] { Boolean.valueOf(bool1) }));
    return bool1;
  }
  
  private boolean m(d.b paramb)
  {
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] verify: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      if (paramb.q.isEmpty()) {
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] no diff: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      }
      d.a locala;
      String str;
      for (;;)
      {
        bool = true;
        break label207;
        int k = 0;
        while (k < paramb.q.size())
        {
          locala = (d.a)paramb.q.get(k);
          if (TextUtils.isEmpty(locala.g)) {
            str = locala.f;
          } else {
            str = locala.g;
          }
          str = a.a(str);
          if ((str == null) || (!str.equalsIgnoreCase(locala.b))) {
            break label166;
          }
          k += 1;
        }
      }
      label166:
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] not matched: %s!=%s, sid=%d", new Object[] { str, locala.b, Long.valueOf(paramb.a) }));
    }
    boolean bool = false;
    label207:
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] verify result: %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  private boolean n(d.b paramb)
  {
    boolean bool;
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] verify package: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      String str = a.a(h(paramb));
      if (str == null) {
        return false;
      }
      bool = str.equalsIgnoreCase(paramb.d);
    }
    else
    {
      bool = false;
    }
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] verify result: %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  public void a()
  {
    if (!QmspSDK.getTaskStatus())
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] Plugin Update Task Finish！");
      return;
    }
    if (!com.tencent.qmsp.sdk.c.f.i().a(1001).booleanValue())
    {
      a(QmspSDK.getAtomUpdateInterval().get());
      return;
    }
    Object localObject = this.h;
    String str = a(d.c);
    long l1 = 0L;
    long l3 = ((SharedPreferences)localObject).getLong(str, 0L);
    long l2 = System.currentTimeMillis() - l3;
    if (l2 >= 0L) {
      l1 = l2;
    }
    l2 = QmspSDK.getAtomUpdateInterval().get();
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 2, String.format("[SFU] startSFU last time: %d, interval: %d", new Object[] { Long.valueOf(l3), Long.valueOf(l1) }));
    if (l1 >= QmspSDK.getAtomUpdateInterval().get())
    {
      b();
      l1 = l2;
    }
    else
    {
      l1 = QmspSDK.getAtomUpdateInterval().get() - l1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[SFU] next time: ");
      ((StringBuilder)localObject).append(l1);
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 0, ((StringBuilder)localObject).toString());
    }
    a(l1);
  }
  
  protected void a(int paramInt)
  {
    com.tencent.qmsp.sdk.f.g.b("Qp.QUM", 2, String.format("[SFU] update error: %d", new Object[] { Integer.valueOf(paramInt) }));
    switch (paramInt)
    {
    default: 
      break;
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
      c(paramInt);
      break;
    case 1: 
      File localFile = new File(c());
      if (localFile.exists()) {
        localFile.delete();
      }
      break;
    }
    b(1);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = (JSONObject)paramObject;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[SFU] rcv : ");
        ((StringBuilder)localObject).append(paramObject);
        paramObject = ((StringBuilder)localObject).toString();
        boolean bool2 = false;
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 0, paramObject);
        bool1 = bool2;
        if (localJSONObject != null)
        {
          int k = localJSONObject.optInt("st");
          this.j = Integer.valueOf(localJSONObject.optString("tsi")).intValue();
          paramInt = this.j;
          a("0X80078B8", k, paramInt, "", "");
          if (k == 0)
          {
            int i1 = localJSONObject.optInt("sc");
            int m = localJSONObject.optInt("fi");
            int n = localJSONObject.optInt("fv");
            paramObject = (String)localJSONObject.opt("fh");
            localObject = (String)localJSONObject.opt("fu");
            int i2 = localJSONObject.optInt("zf");
            if (i2 != 1) {
              break label474;
            }
            bool1 = true;
            int i3 = a(n, paramObject);
            paramInt = 5;
            com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] resp: cmd=%d, status=%d, fileid=%d, fileversion=%d, md5=%s, url=%s, zipped: %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), paramObject, localObject, Integer.valueOf(i2) }));
            if (i3 == 0)
            {
              paramInt = this.j;
              a("0X80078AB", m, paramInt, "", "");
              com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("Need to update config file, fileid=%d", new Object[] { Integer.valueOf(m) }));
              bool1 = a(new c.c(1, m, e(), a(d.a), (String)localObject, paramObject, n, bool1, 0, System.currentTimeMillis(), 1));
              continue;
            }
            if (i3 == 1)
            {
              paramObject = new File(c());
              bool1 = bool2;
              if (!this.i.a(paramObject.toString())) {
                continue;
              }
              if (this.i.a().isEmpty()) {
                paramInt = 16;
              }
              b(paramInt);
              bool1 = true;
              continue;
            }
            paramObject = "[SFU] NO Need UPDATE";
          }
          else
          {
            paramObject = String.format("[SFU] Server replied with error, status=%d", new Object[] { Integer.valueOf(k) });
          }
          com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, paramObject);
          bool1 = bool2;
        }
        if (!bool1)
        {
          b(17);
          return;
        }
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        b(17);
      }
      return;
      label474:
      boolean bool1 = false;
    }
  }
  
  public void a(long paramLong)
  {
    com.tencent.qmsp.sdk.c.f.i().c().postDelayed(new c.a(this), paramLong);
  }
  
  public void a(com.tencent.qmsp.sdk.b.c paramc)
  {
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.obtainMessage(1052688, paramc).sendToTarget();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1052688) {
      b((com.tencent.qmsp.sdk.b.c)paramMessage.obj);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.d.c
 * JD-Core Version:    0.7.0.1
 */