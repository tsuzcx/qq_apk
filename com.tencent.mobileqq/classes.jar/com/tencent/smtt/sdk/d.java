package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.a.a;
import com.tencent.smtt.sdk.a.e;
import com.tencent.smtt.sdk.a.g;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d
{
  private static String a = "EmergencyManager";
  private static int b = 0;
  private static int c = 1;
  private static int d = 2;
  private static int e = 3;
  private static int f = 4;
  private static int g = 5;
  private static d h;
  private long i = 60000L;
  private long j = 86400000L;
  private boolean k = false;
  
  public static d a()
  {
    try
    {
      if (h == null) {
        h = new d();
      }
      d locald = h;
      return locald;
    }
    finally {}
  }
  
  private void a(Context paramContext, int paramInt, List<com.tencent.smtt.sdk.a.b> paramList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    g localg = g.a();
    Object localObject1 = localg.a(paramContext, "emergence_ids");
    HashSet localHashSet = new HashSet();
    Object localObject2;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = g.a((String)((Iterator)localObject1).next());
        if ((localObject2 != null) && (localObject2.length == 4)) {
          localHashSet.add(Integer.valueOf(Integer.parseInt(localObject2[0])));
        }
      }
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (com.tencent.smtt.sdk.a.b)localIterator.next();
      int m = paramList.b();
      int n = paramList.a();
      if (localHashSet.contains(Integer.valueOf(n)))
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Command has been executed: ");
        ((StringBuilder)localObject2).append(paramList.toString());
      }
      for (paramList = ", ignored";; paramList = a.a(System.currentTimeMillis()))
      {
        ((StringBuilder)localObject2).append(paramList);
        TbsLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
        break;
        if (!paramList.e()) {
          break label283;
        }
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Command is out of date: ");
        ((StringBuilder)localObject2).append(paramList.toString());
        ((StringBuilder)localObject2).append(", now: ");
      }
      label283:
      localLinkedHashMap.put(Integer.valueOf(m), paramList.c());
      localg.a(paramContext, "emergence_ids", g.a(new String[] { String.valueOf(n), String.valueOf(paramList.b()), String.valueOf(paramList.c()), String.valueOf(paramList.d()) }));
    }
    a(paramContext, Integer.valueOf(paramInt), localLinkedHashMap);
  }
  
  private void b(Context paramContext)
  {
    com.tencent.smtt.sdk.a.c localc = new com.tencent.smtt.sdk.a.c();
    localc.a(com.tencent.smtt.utils.b.a(paramContext));
    localc.b(com.tencent.smtt.utils.b.d(paramContext));
    localc.a(Integer.valueOf(com.tencent.smtt.utils.b.b(paramContext)));
    localc.c(com.tencent.smtt.utils.b.c(paramContext));
    localc.d("x5webview");
    localc.b(Integer.valueOf(QbSdk.getTbsSdkVersion()));
    localc.c(Integer.valueOf(QbSdk.getTbsVersion(paramContext)));
    Iterator localIterator = g.a().a(paramContext, "emergence_ids").iterator();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext()) {
      try
      {
        Object localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = g.a((String)localObject);
          if ((localObject != null) && (localObject.length == 4))
          {
            int m = Integer.parseInt(localObject[0]);
            long l = Long.parseLong(localObject[3]);
            if (System.currentTimeMillis() < l) {
              localArrayList.add(Integer.valueOf(m));
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    localc.a(localArrayList);
    new e(paramContext, n.a(paramContext).j(), localc.a()).a(new d.1(this, paramContext));
  }
  
  /* Error */
  public void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/smtt/sdk/d:k	Z
    //   4: ifne +352 -> 356
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 44	com/tencent/smtt/sdk/d:k	Z
    //   12: invokestatic 57	com/tencent/smtt/sdk/a/g:a	()Lcom/tencent/smtt/sdk/a/g;
    //   15: astore 8
    //   17: aload 8
    //   19: invokevirtual 281	com/tencent/smtt/sdk/a/g:b	()Z
    //   22: ifne +319 -> 341
    //   25: aload 8
    //   27: aload_1
    //   28: invokevirtual 283	com/tencent/smtt/sdk/a/g:a	(Landroid/content/Context;)V
    //   31: invokestatic 57	com/tencent/smtt/sdk/a/g:a	()Lcom/tencent/smtt/sdk/a/g;
    //   34: aload_1
    //   35: ldc_w 285
    //   38: invokevirtual 288	com/tencent/smtt/sdk/a/g:b	(Landroid/content/Context;Ljava/lang/String;)J
    //   41: lstore 6
    //   43: invokestatic 57	com/tencent/smtt/sdk/a/g:a	()Lcom/tencent/smtt/sdk/a/g;
    //   46: aload_1
    //   47: ldc_w 290
    //   50: invokevirtual 288	com/tencent/smtt/sdk/a/g:b	(Landroid/content/Context;Ljava/lang/String;)J
    //   53: lstore 4
    //   55: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   58: lstore_2
    //   59: lload_2
    //   60: lload 6
    //   62: lsub
    //   63: lstore 6
    //   65: aload_0
    //   66: getfield 38	com/tencent/smtt/sdk/d:i	J
    //   69: lload 4
    //   71: invokestatic 296	java/lang/Math:max	(JJ)J
    //   74: aload_0
    //   75: getfield 42	com/tencent/smtt/sdk/d:j	J
    //   78: invokestatic 299	java/lang/Math:min	(JJ)J
    //   81: lstore 4
    //   83: lload 6
    //   85: lload 4
    //   87: lcmp
    //   88: ifle +76 -> 164
    //   91: getstatic 117	com/tencent/smtt/sdk/d:a	Ljava/lang/String;
    //   94: astore 8
    //   96: new 119	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   103: astore 9
    //   105: aload 9
    //   107: ldc_w 301
    //   110: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 9
    //   116: lload 6
    //   118: ldc2_w 302
    //   121: ldiv
    //   122: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 9
    //   128: ldc_w 308
    //   131: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 8
    //   137: aload 9
    //   139: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 138	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: invokestatic 57	com/tencent/smtt/sdk/a/g:a	()Lcom/tencent/smtt/sdk/a/g;
    //   148: aload_1
    //   149: ldc_w 285
    //   152: lload_2
    //   153: invokevirtual 311	com/tencent/smtt/sdk/a/g:a	(Landroid/content/Context;Ljava/lang/String;J)V
    //   156: aload_0
    //   157: aload_1
    //   158: invokespecial 313	com/tencent/smtt/sdk/d:b	(Landroid/content/Context;)V
    //   161: goto +165 -> 326
    //   164: aload_0
    //   165: aload_1
    //   166: getstatic 315	com/tencent/smtt/sdk/d:c	I
    //   169: new 235	java/util/ArrayList
    //   172: dup
    //   173: invokespecial 236	java/util/ArrayList:<init>	()V
    //   176: invokespecial 187	com/tencent/smtt/sdk/d:a	(Landroid/content/Context;ILjava/util/List;)V
    //   179: getstatic 117	com/tencent/smtt/sdk/d:a	Ljava/lang/String;
    //   182: astore 8
    //   184: new 119	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   191: astore 9
    //   193: aload 9
    //   195: ldc_w 317
    //   198: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 9
    //   204: lload 6
    //   206: ldc2_w 302
    //   209: ldiv
    //   210: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 9
    //   216: ldc_w 319
    //   219: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 9
    //   225: lload 6
    //   227: lload 4
    //   229: lsub
    //   230: invokestatic 323	java/lang/Math:abs	(J)J
    //   233: ldc2_w 302
    //   236: ldiv
    //   237: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 9
    //   243: ldc_w 325
    //   246: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 8
    //   252: aload 9
    //   254: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 138	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: goto +66 -> 326
    //   263: astore_1
    //   264: goto +69 -> 333
    //   267: astore 8
    //   269: aload_0
    //   270: aload_1
    //   271: getstatic 327	com/tencent/smtt/sdk/d:g	I
    //   274: new 235	java/util/ArrayList
    //   277: dup
    //   278: invokespecial 236	java/util/ArrayList:<init>	()V
    //   281: invokespecial 187	com/tencent/smtt/sdk/d:a	(Landroid/content/Context;ILjava/util/List;)V
    //   284: getstatic 117	com/tencent/smtt/sdk/d:a	Ljava/lang/String;
    //   287: astore_1
    //   288: new 119	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   295: astore 9
    //   297: aload 9
    //   299: ldc_w 329
    //   302: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 9
    //   308: aload 8
    //   310: invokevirtual 332	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   313: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_1
    //   318: aload 9
    //   320: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 138	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: invokestatic 57	com/tencent/smtt/sdk/a/g:a	()Lcom/tencent/smtt/sdk/a/g;
    //   329: invokevirtual 334	com/tencent/smtt/sdk/a/g:c	()V
    //   332: return
    //   333: invokestatic 57	com/tencent/smtt/sdk/a/g:a	()Lcom/tencent/smtt/sdk/a/g;
    //   336: invokevirtual 334	com/tencent/smtt/sdk/a/g:c	()V
    //   339: aload_1
    //   340: athrow
    //   341: aload_0
    //   342: aload_1
    //   343: getstatic 336	com/tencent/smtt/sdk/d:f	I
    //   346: new 235	java/util/ArrayList
    //   349: dup
    //   350: invokespecial 236	java/util/ArrayList:<init>	()V
    //   353: invokespecial 187	com/tencent/smtt/sdk/d:a	(Landroid/content/Context;ILjava/util/List;)V
    //   356: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	d
    //   0	357	1	paramContext	Context
    //   58	95	2	l1	long
    //   53	175	4	l2	long
    //   41	185	6	l3	long
    //   15	236	8	localObject	Object
    //   267	42	8	localException	Exception
    //   103	216	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   31	59	263	finally
    //   65	83	263	finally
    //   91	161	263	finally
    //   164	260	263	finally
    //   269	326	263	finally
    //   31	59	267	java/lang/Exception
    //   65	83	267	java/lang/Exception
    //   91	161	267	java/lang/Exception
    //   164	260	267	java/lang/Exception
  }
  
  public void a(Context paramContext, Integer paramInteger, Map<Integer, String> paramMap)
  {
    c.a().b(paramContext);
    TbsLog.e(a, "Dispatch emergency commands on tbs extension");
    QbSdk.a(paramContext, paramInteger, paramMap);
    paramContext = f.a(true);
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.a();
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.b();
    if (paramContext != null)
    {
      TbsLog.e(a, "Dispatch emergency commands on tbs shell");
      paramContext.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "dispatchEmergencyCommand", new Class[] { Integer.class, Map.class }, new Object[] { paramInteger, paramMap });
      return;
    }
    TbsLog.e(a, "Dex loader is null, cancel commands dispatching of tbs shell");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.d
 * JD-Core Version:    0.7.0.1
 */