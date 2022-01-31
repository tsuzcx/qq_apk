package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.a;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class au
{
  private static StatLogger h = ;
  private static Context i = null;
  private static au j = null;
  volatile int a = 0;
  a b = null;
  private bc c = null;
  private bc d = null;
  private com.tencent.wxop.stat.common.e e = null;
  private String f = "";
  private String g = "";
  private int k = 0;
  private ConcurrentHashMap<com.tencent.wxop.stat.event.e, String> l = null;
  private boolean m = false;
  private HashMap<String, String> n = new HashMap();
  
  private au(Context paramContext)
  {
    try
    {
      this.e = new com.tencent.wxop.stat.common.e();
      i = paramContext.getApplicationContext();
      this.l = new ConcurrentHashMap();
      this.f = l.p(paramContext);
      this.g = ("pri_" + l.p(paramContext));
      this.c = new bc(i, this.f);
      this.d = new bc(i, this.g);
      a(true);
      a(false);
      f();
      b(i);
      d();
      j();
      return;
    }
    catch (Throwable paramContext)
    {
      h.e(paramContext);
    }
  }
  
  public static au a(Context paramContext)
  {
    if (j == null) {}
    try
    {
      if (j == null) {
        j = new au(paramContext);
      }
      return j;
    }
    finally {}
  }
  
  private String a(List<bd> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramList.size() * 3);
    localStringBuilder.append("event_id in (");
    int i2 = paramList.size();
    paramList = paramList.iterator();
    int i1 = 0;
    while (paramList.hasNext())
    {
      localStringBuilder.append(((bd)paramList.next()).a);
      if (i1 != i2 - 1) {
        localStringBuilder.append(",");
      }
      i1 += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if ((this.a > 0) && (paramInt > 0))
        {
          boolean bool = StatServiceImpl.a();
          if (!bool) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        ArrayList localArrayList;
        h.e(localThrowable);
        continue;
      }
      finally {}
      return;
      if (StatConfig.isDebugEnable()) {
        h.i("Load " + this.a + " unsent events");
      }
      localArrayList = new ArrayList(paramInt);
      b(localArrayList, paramInt, paramBoolean);
      if (localArrayList.size() > 0)
      {
        if (StatConfig.isDebugEnable()) {
          h.i("Peek " + localArrayList.size() + " unsent events.");
        }
        a(localArrayList, 2, paramBoolean);
        i.b(i).b(localArrayList, new ba(this, localArrayList, paramBoolean));
      }
    }
  }
  
  private void a(com.tencent.wxop.stat.event.e parame, h paramh, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      long l2;
      try
      {
        localSQLiteDatabase = c(paramBoolean);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        if (!paramBoolean)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (this.a > StatConfig.getMaxStoreEventCount())
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            h.warn("Too many events stored in db.");
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            this.a -= this.c.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
          }
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        String str = parame.g();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (StatConfig.isDebugEnable())
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          h.i("insert 1 event, content:" + str);
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("content", r.b(str));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("send_count", "0");
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("status", Integer.toString(1));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("timestamp", Long.valueOf(parame.c()));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        l1 = localSQLiteDatabase.insert("events", null, localContentValues);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.setTransactionSuccessful();
        l2 = l1;
        if (localSQLiteDatabase == null) {
          break label485;
        }
      }
      catch (Throwable localThrowable3)
      {
        SQLiteDatabase localSQLiteDatabase;
        l2 = -1L;
        localObject2 = localThrowable1;
        h.e(localThrowable3);
        if (localThrowable1 == null) {
          break label485;
        }
        try
        {
          localThrowable1.endTransaction();
          l1 = -1L;
        }
        catch (Throwable localThrowable2)
        {
          h.e(localThrowable2);
          l1 = -1L;
        }
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        try
        {
          localObject2.endTransaction();
          throw parame;
        }
        catch (Throwable paramh)
        {
          h.e(paramh);
          continue;
        }
        h.error("Failed to store event:" + parame.g());
        return;
      }
      try
      {
        localSQLiteDatabase.endTransaction();
        if (l1 > 0L)
        {
          this.a += 1;
          if (StatConfig.isDebugEnable()) {
            h.d("directStoreEvent insert event to db, event:" + parame.g());
          }
          if (paramh != null) {
            paramh.a();
          }
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        h.e(localThrowable1);
        continue;
      }
      label485:
      long l1 = l2;
    }
  }
  
  /* Error */
  private void a(List<bd> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: invokeinterface 141 1 0
    //   14: istore 4
    //   16: iload 4
    //   18: ifne +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: iload_3
    //   26: invokespecial 339	com/tencent/wxop/stat/au:b	(Z)I
    //   29: istore 4
    //   31: aload_0
    //   32: iload_3
    //   33: invokespecial 241	com/tencent/wxop/stat/au:c	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore 6
    //   38: iload_2
    //   39: iconst_2
    //   40: if_icmpne +192 -> 232
    //   43: aload 6
    //   45: astore 5
    //   47: new 96	java/lang/StringBuilder
    //   50: dup
    //   51: ldc_w 341
    //   54: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: iload_2
    //   58: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: ldc_w 343
    //   64: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: aload_1
    //   69: invokespecial 345	com/tencent/wxop/stat/au:a	(Ljava/util/List;)Ljava/lang/String;
    //   72: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 8
    //   80: aload 7
    //   82: astore_1
    //   83: aload 8
    //   85: astore 7
    //   87: aload 6
    //   89: astore 5
    //   91: invokestatic 184	com/tencent/wxop/stat/StatConfig:isDebugEnable	()Z
    //   94: ifeq +31 -> 125
    //   97: aload 6
    //   99: astore 5
    //   101: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   104: new 96	java/lang/StringBuilder
    //   107: dup
    //   108: ldc_w 347
    //   111: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload 7
    //   116: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokevirtual 194	com/tencent/wxop/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   125: aload 6
    //   127: astore 5
    //   129: aload 6
    //   131: invokevirtual 246	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   134: aload 6
    //   136: astore 5
    //   138: aload 6
    //   140: aload 7
    //   142: invokevirtual 350	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   145: aload_1
    //   146: ifnull +48 -> 194
    //   149: aload 6
    //   151: astore 5
    //   153: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   156: new 96	java/lang/StringBuilder
    //   159: dup
    //   160: ldc_w 352
    //   163: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: aload_1
    //   167: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 194	com/tencent/wxop/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   176: aload 6
    //   178: astore 5
    //   180: aload 6
    //   182: aload_1
    //   183: invokevirtual 350	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   186: aload 6
    //   188: astore 5
    //   190: aload_0
    //   191: invokespecial 119	com/tencent/wxop/stat/au:f	()V
    //   194: aload 6
    //   196: astore 5
    //   198: aload 6
    //   200: invokevirtual 318	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   203: aload 6
    //   205: ifnull -184 -> 21
    //   208: aload 6
    //   210: invokevirtual 321	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   213: goto -192 -> 21
    //   216: astore_1
    //   217: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   220: aload_1
    //   221: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   224: goto -203 -> 21
    //   227: astore_1
    //   228: aload_0
    //   229: monitorexit
    //   230: aload_1
    //   231: athrow
    //   232: aload 6
    //   234: astore 5
    //   236: new 96	java/lang/StringBuilder
    //   239: dup
    //   240: ldc_w 341
    //   243: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: iload_2
    //   247: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: ldc_w 354
    //   253: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: aload_1
    //   258: invokespecial 345	com/tencent/wxop/stat/au:a	(Ljava/util/List;)Ljava/lang/String;
    //   261: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: astore 7
    //   269: aload 8
    //   271: astore_1
    //   272: aload 6
    //   274: astore 5
    //   276: aload_0
    //   277: getfield 69	com/tencent/wxop/stat/au:k	I
    //   280: iconst_3
    //   281: irem
    //   282: ifne +26 -> 308
    //   285: aload 6
    //   287: astore 5
    //   289: new 96	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 356
    //   296: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: iload 4
    //   301: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: astore_1
    //   308: aload 6
    //   310: astore 5
    //   312: aload_0
    //   313: aload_0
    //   314: getfield 69	com/tencent/wxop/stat/au:k	I
    //   317: iconst_1
    //   318: iadd
    //   319: putfield 69	com/tencent/wxop/stat/au:k	I
    //   322: goto -235 -> 87
    //   325: astore_1
    //   326: aload 6
    //   328: astore 5
    //   330: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   333: aload_1
    //   334: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   337: aload 6
    //   339: ifnull -318 -> 21
    //   342: aload 6
    //   344: invokevirtual 321	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   347: goto -326 -> 21
    //   350: astore_1
    //   351: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   354: aload_1
    //   355: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   358: goto -337 -> 21
    //   361: astore_1
    //   362: aconst_null
    //   363: astore 5
    //   365: aload 5
    //   367: ifnull +8 -> 375
    //   370: aload 5
    //   372: invokevirtual 321	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   375: aload_1
    //   376: athrow
    //   377: astore 5
    //   379: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   382: aload 5
    //   384: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   387: goto -12 -> 375
    //   390: astore_1
    //   391: goto -26 -> 365
    //   394: astore_1
    //   395: aconst_null
    //   396: astore 6
    //   398: goto -72 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	au
    //   0	401	1	paramList	List<bd>
    //   0	401	2	paramInt	int
    //   0	401	3	paramBoolean	boolean
    //   14	286	4	i1	int
    //   45	326	5	localSQLiteDatabase1	SQLiteDatabase
    //   377	6	5	localThrowable	Throwable
    //   36	361	6	localSQLiteDatabase2	SQLiteDatabase
    //   4	264	7	str1	String
    //   1	269	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   208	213	216	java/lang/Throwable
    //   8	16	227	finally
    //   24	31	227	finally
    //   208	213	227	finally
    //   217	224	227	finally
    //   342	347	227	finally
    //   351	358	227	finally
    //   370	375	227	finally
    //   375	377	227	finally
    //   379	387	227	finally
    //   47	80	325	java/lang/Throwable
    //   91	97	325	java/lang/Throwable
    //   101	125	325	java/lang/Throwable
    //   129	134	325	java/lang/Throwable
    //   138	145	325	java/lang/Throwable
    //   153	176	325	java/lang/Throwable
    //   180	186	325	java/lang/Throwable
    //   190	194	325	java/lang/Throwable
    //   198	203	325	java/lang/Throwable
    //   236	269	325	java/lang/Throwable
    //   276	285	325	java/lang/Throwable
    //   289	308	325	java/lang/Throwable
    //   312	322	325	java/lang/Throwable
    //   342	347	350	java/lang/Throwable
    //   31	38	361	finally
    //   370	375	377	java/lang/Throwable
    //   47	80	390	finally
    //   91	97	390	finally
    //   101	125	390	finally
    //   129	134	390	finally
    //   138	145	390	finally
    //   153	176	390	finally
    //   180	186	390	finally
    //   190	194	390	finally
    //   198	203	390	finally
    //   236	269	390	finally
    //   276	285	390	finally
    //   289	308	390	finally
    //   312	322	390	finally
    //   330	337	390	finally
    //   31	38	394	java/lang/Throwable
  }
  
  /* Error */
  private void a(List<bd> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: invokeinterface 141 1 0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 184	com/tencent/wxop/stat/StatConfig:isDebugEnable	()Z
    //   25: ifeq +41 -> 66
    //   28: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   31: new 96	java/lang/StringBuilder
    //   34: dup
    //   35: ldc_w 359
    //   38: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: invokeinterface 141 1 0
    //   47: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc_w 361
    //   53: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_2
    //   57: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 194	com/tencent/wxop/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   66: new 96	java/lang/StringBuilder
    //   69: dup
    //   70: aload_1
    //   71: invokeinterface 141 1 0
    //   76: iconst_3
    //   77: imul
    //   78: invokespecial 144	java/lang/StringBuilder:<init>	(I)V
    //   81: astore 7
    //   83: aload 7
    //   85: ldc 146
    //   87: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: invokeinterface 141 1 0
    //   97: istore 4
    //   99: aload_1
    //   100: invokeinterface 150 1 0
    //   105: astore_1
    //   106: iconst_0
    //   107: istore_3
    //   108: aload_1
    //   109: invokeinterface 156 1 0
    //   114: ifeq +40 -> 154
    //   117: aload 7
    //   119: aload_1
    //   120: invokeinterface 160 1 0
    //   125: checkcast 162	com/tencent/wxop/stat/bd
    //   128: getfield 165	com/tencent/wxop/stat/bd:a	J
    //   131: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: iload_3
    //   136: iload 4
    //   138: iconst_1
    //   139: isub
    //   140: if_icmpeq +264 -> 404
    //   143: aload 7
    //   145: ldc 170
    //   147: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: goto +253 -> 404
    //   154: aload 7
    //   156: ldc 172
    //   158: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 6
    //   164: astore_1
    //   165: aload_0
    //   166: iload_2
    //   167: invokespecial 241	com/tencent/wxop/stat/au:c	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   170: astore 6
    //   172: aload 6
    //   174: astore_1
    //   175: aload 6
    //   177: astore 5
    //   179: aload 6
    //   181: invokevirtual 246	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   184: aload 6
    //   186: astore_1
    //   187: aload 6
    //   189: astore 5
    //   191: aload 6
    //   193: ldc_w 260
    //   196: aload 7
    //   198: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: aconst_null
    //   202: invokevirtual 266	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   205: istore_3
    //   206: aload 6
    //   208: astore_1
    //   209: aload 6
    //   211: astore 5
    //   213: invokestatic 184	com/tencent/wxop/stat/StatConfig:isDebugEnable	()Z
    //   216: ifeq +58 -> 274
    //   219: aload 6
    //   221: astore_1
    //   222: aload 6
    //   224: astore 5
    //   226: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   229: new 96	java/lang/StringBuilder
    //   232: dup
    //   233: ldc_w 366
    //   236: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   239: iload 4
    //   241: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 368
    //   247: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 7
    //   252: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc_w 370
    //   261: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: iload_3
    //   265: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokevirtual 194	com/tencent/wxop/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   274: aload 6
    //   276: astore_1
    //   277: aload 6
    //   279: astore 5
    //   281: aload_0
    //   282: aload_0
    //   283: getfield 65	com/tencent/wxop/stat/au:a	I
    //   286: iload_3
    //   287: isub
    //   288: putfield 65	com/tencent/wxop/stat/au:a	I
    //   291: aload 6
    //   293: astore_1
    //   294: aload 6
    //   296: astore 5
    //   298: aload 6
    //   300: invokevirtual 318	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   303: aload 6
    //   305: astore_1
    //   306: aload 6
    //   308: astore 5
    //   310: aload_0
    //   311: invokespecial 119	com/tencent/wxop/stat/au:f	()V
    //   314: aload 6
    //   316: ifnull -297 -> 19
    //   319: aload 6
    //   321: invokevirtual 321	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   324: goto -305 -> 19
    //   327: astore_1
    //   328: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   331: aload_1
    //   332: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   335: goto -316 -> 19
    //   338: astore_1
    //   339: aload_0
    //   340: monitorexit
    //   341: aload_1
    //   342: athrow
    //   343: astore 6
    //   345: aload_1
    //   346: astore 5
    //   348: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   351: aload 6
    //   353: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   356: aload_1
    //   357: ifnull -338 -> 19
    //   360: aload_1
    //   361: invokevirtual 321	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   364: goto -345 -> 19
    //   367: astore_1
    //   368: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   371: aload_1
    //   372: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   375: goto -356 -> 19
    //   378: astore_1
    //   379: aload 5
    //   381: ifnull +8 -> 389
    //   384: aload 5
    //   386: invokevirtual 321	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   389: aload_1
    //   390: athrow
    //   391: astore 5
    //   393: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   396: aload 5
    //   398: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   401: goto -12 -> 389
    //   404: iload_3
    //   405: iconst_1
    //   406: iadd
    //   407: istore_3
    //   408: goto -300 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	au
    //   0	411	1	paramList	List<bd>
    //   0	411	2	paramBoolean	boolean
    //   14	394	3	i1	int
    //   97	143	4	i2	int
    //   1	384	5	localObject	Object
    //   391	6	5	localThrowable1	Throwable
    //   4	316	6	localSQLiteDatabase	SQLiteDatabase
    //   343	9	6	localThrowable2	Throwable
    //   81	170	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   319	324	327	java/lang/Throwable
    //   8	15	338	finally
    //   22	66	338	finally
    //   66	106	338	finally
    //   108	135	338	finally
    //   143	151	338	finally
    //   154	162	338	finally
    //   319	324	338	finally
    //   328	335	338	finally
    //   360	364	338	finally
    //   368	375	338	finally
    //   384	389	338	finally
    //   389	391	338	finally
    //   393	401	338	finally
    //   165	172	343	java/lang/Throwable
    //   179	184	343	java/lang/Throwable
    //   191	206	343	java/lang/Throwable
    //   213	219	343	java/lang/Throwable
    //   226	274	343	java/lang/Throwable
    //   281	291	343	java/lang/Throwable
    //   298	303	343	java/lang/Throwable
    //   310	314	343	java/lang/Throwable
    //   360	364	367	java/lang/Throwable
    //   165	172	378	finally
    //   179	184	378	finally
    //   191	206	378	finally
    //   213	219	378	finally
    //   226	274	378	finally
    //   281	291	378	finally
    //   298	303	378	finally
    //   310	314	378	finally
    //   348	356	378	finally
    //   384	389	391	java/lang/Throwable
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = c(paramBoolean);
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        localContentValues.put("status", Integer.valueOf(1));
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        int i1 = localSQLiteDatabase.update("events", localContentValues, "status=?", new String[] { Long.toString(2L) });
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        if (StatConfig.isDebugEnable())
        {
          localObject1 = localSQLiteDatabase;
          localObject3 = localSQLiteDatabase;
          h.i("update " + i1 + " unsent events.");
        }
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        localSQLiteDatabase.setTransactionSuccessful();
      }
      catch (Throwable localThrowable4)
      {
        SQLiteDatabase localSQLiteDatabase;
        localObject3 = localThrowable1;
        h.e(localThrowable4);
        if (localThrowable1 == null) {
          continue;
        }
        try
        {
          localThrowable1.endTransaction();
          return;
        }
        catch (Throwable localThrowable2)
        {
          h.e(localThrowable2);
          return;
        }
      }
      finally
      {
        if (localObject3 == null) {
          break label215;
        }
      }
      try
      {
        localSQLiteDatabase.endTransaction();
        return;
      }
      catch (Throwable localThrowable1)
      {
        h.e(localThrowable1);
        return;
      }
    }
    try
    {
      localObject3.endTransaction();
      label215:
      throw localObject2;
    }
    catch (Throwable localThrowable3)
    {
      for (;;)
      {
        h.e(localThrowable3);
      }
    }
  }
  
  private int b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return StatConfig.getMaxSendRetryCount();
    }
    return StatConfig.getMaxImportantDataSendRetryCount();
  }
  
  public static au b()
  {
    return j;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      if (!paramBoolean) {
        paramInt = g();
      }
    }
    for (;;)
    {
      if (paramInt > 0)
      {
        int i2 = StatConfig.getSendPeriodMinutes() * 60 * StatConfig.getNumEventsCommitPerSec();
        int i1 = paramInt;
        if (paramInt > i2)
        {
          i1 = paramInt;
          if (i2 > 0) {
            i1 = i2;
          }
        }
        int i3 = StatConfig.a();
        int i4 = i1 / i3;
        int i5 = i1 % i3;
        if (StatConfig.isDebugEnable()) {
          h.i("sentStoreEventsByDb sendNumbers=" + i1 + ",important=" + paramBoolean + ",maxSendNumPerFor1Period=" + i2 + ",maxCount=" + i4 + ",restNumbers=" + i5);
        }
        paramInt = 0;
        for (;;)
        {
          if (paramInt < i4)
          {
            a(i3, paramBoolean);
            paramInt += 1;
            continue;
            paramInt = h();
            break;
          }
        }
        if (i5 > 0) {
          a(i5, paramBoolean);
        }
      }
      return;
    }
  }
  
  /* Error */
  private void b(com.tencent.wxop.stat.event.e parame, h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 249	com/tencent/wxop/stat/StatConfig:getMaxStoreEventCount	()I
    //   5: ifle +25 -> 30
    //   8: getstatic 425	com/tencent/wxop/stat/StatConfig:m	I
    //   11: ifle +12 -> 23
    //   14: iload_3
    //   15: ifne +8 -> 23
    //   18: iload 4
    //   20: ifeq +13 -> 33
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: iload_3
    //   27: invokespecial 427	com/tencent/wxop/stat/au:a	(Lcom/tencent/wxop/stat/event/e;Lcom/tencent/wxop/stat/h;Z)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: getstatic 425	com/tencent/wxop/stat/StatConfig:m	I
    //   36: ifle -6 -> 30
    //   39: invokestatic 184	com/tencent/wxop/stat/StatConfig:isDebugEnable	()Z
    //   42: ifeq +83 -> 125
    //   45: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   48: new 96	java/lang/StringBuilder
    //   51: dup
    //   52: ldc_w 429
    //   55: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 71	com/tencent/wxop/stat/au:l	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: invokevirtual 430	java/util/concurrent/ConcurrentHashMap:size	()I
    //   65: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc_w 432
    //   71: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: getstatic 425	com/tencent/wxop/stat/StatConfig:m	I
    //   77: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: ldc_w 434
    //   83: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: getfield 65	com/tencent/wxop/stat/au:a	I
    //   90: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokevirtual 194	com/tencent/wxop/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   99: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   102: new 96	java/lang/StringBuilder
    //   105: dup
    //   106: ldc_w 436
    //   109: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_1
    //   113: invokevirtual 273	com/tencent/wxop/stat/event/e:g	()Ljava/lang/String;
    //   116: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokevirtual 194	com/tencent/wxop/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   125: aload_0
    //   126: getfield 71	com/tencent/wxop/stat/au:l	Ljava/util/concurrent/ConcurrentHashMap;
    //   129: aload_1
    //   130: ldc 59
    //   132: invokevirtual 439	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: aload_0
    //   137: getfield 71	com/tencent/wxop/stat/au:l	Ljava/util/concurrent/ConcurrentHashMap;
    //   140: invokevirtual 430	java/util/concurrent/ConcurrentHashMap:size	()I
    //   143: getstatic 425	com/tencent/wxop/stat/StatConfig:m	I
    //   146: if_icmplt +7 -> 153
    //   149: aload_0
    //   150: invokespecial 222	com/tencent/wxop/stat/au:i	()V
    //   153: aload_2
    //   154: ifnull -124 -> 30
    //   157: aload_0
    //   158: getfield 71	com/tencent/wxop/stat/au:l	Ljava/util/concurrent/ConcurrentHashMap;
    //   161: invokevirtual 430	java/util/concurrent/ConcurrentHashMap:size	()I
    //   164: ifle +7 -> 171
    //   167: aload_0
    //   168: invokespecial 222	com/tencent/wxop/stat/au:i	()V
    //   171: aload_2
    //   172: invokeinterface 329 1 0
    //   177: goto -147 -> 30
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	au
    //   0	185	1	parame	com.tencent.wxop.stat.event.e
    //   0	185	2	paramh	h
    //   0	185	3	paramBoolean1	boolean
    //   0	185	4	paramBoolean2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	180	finally
    //   23	30	180	finally
    //   33	125	180	finally
    //   125	153	180	finally
    //   157	171	180	finally
    //   171	177	180	finally
  }
  
  /* Error */
  private void b(f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 445	com/tencent/wxop/stat/f:a	()Ljava/lang/String;
    //   6: astore 7
    //   8: aload 7
    //   10: invokestatic 447	com/tencent/wxop/stat/common/l:a	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore 5
    //   15: new 268	android/content/ContentValues
    //   18: dup
    //   19: invokespecial 269	android/content/ContentValues:<init>	()V
    //   22: astore 8
    //   24: aload 8
    //   26: ldc_w 277
    //   29: aload_1
    //   30: getfield 450	com/tencent/wxop/stat/f:b	Lorg/json/JSONObject;
    //   33: invokevirtual 453	org/json/JSONObject:toString	()Ljava/lang/String;
    //   36: invokevirtual 286	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload 8
    //   41: ldc_w 455
    //   44: aload 5
    //   46: invokevirtual 286	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_1
    //   50: aload 5
    //   52: putfield 457	com/tencent/wxop/stat/f:c	Ljava/lang/String;
    //   55: aload 8
    //   57: ldc_w 459
    //   60: aload_1
    //   61: getfield 461	com/tencent/wxop/stat/f:d	I
    //   64: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: invokevirtual 377	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   70: aload_0
    //   71: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   74: invokevirtual 464	com/tencent/wxop/stat/bc:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   77: ldc_w 466
    //   80: aconst_null
    //   81: aconst_null
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: invokevirtual 470	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   89: astore 6
    //   91: aload 6
    //   93: astore 5
    //   95: aload 6
    //   97: invokeinterface 475 1 0
    //   102: ifeq +324 -> 426
    //   105: aload 6
    //   107: astore 5
    //   109: aload 6
    //   111: iconst_0
    //   112: invokeinterface 479 2 0
    //   117: aload_1
    //   118: getfield 480	com/tencent/wxop/stat/f:a	I
    //   121: if_icmpne -30 -> 91
    //   124: iconst_1
    //   125: istore_2
    //   126: aload 6
    //   128: astore 5
    //   130: aload_0
    //   131: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   134: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   137: invokevirtual 246	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   140: iconst_1
    //   141: iload_2
    //   142: if_icmpne +116 -> 258
    //   145: aload 6
    //   147: astore 5
    //   149: aload_0
    //   150: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   153: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   156: ldc_w 466
    //   159: aload 8
    //   161: ldc_w 482
    //   164: iconst_1
    //   165: anewarray 381	java/lang/String
    //   168: dup
    //   169: iconst_0
    //   170: aload_1
    //   171: getfield 480	com/tencent/wxop/stat/f:a	I
    //   174: invokestatic 297	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   177: aastore
    //   178: invokevirtual 390	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   181: i2l
    //   182: lstore_3
    //   183: lload_3
    //   184: ldc2_w 330
    //   187: lcmp
    //   188: ifne +113 -> 301
    //   191: aload 6
    //   193: astore 5
    //   195: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   198: new 96	java/lang/StringBuilder
    //   201: dup
    //   202: ldc_w 484
    //   205: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: aload 7
    //   210: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokevirtual 486	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   219: aload 6
    //   221: astore 5
    //   223: aload_0
    //   224: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   227: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   230: invokevirtual 318	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   233: aload 6
    //   235: ifnull +10 -> 245
    //   238: aload 6
    //   240: invokeinterface 489 1 0
    //   245: aload_0
    //   246: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   249: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   252: invokevirtual 321	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   255: aload_0
    //   256: monitorexit
    //   257: return
    //   258: aload 6
    //   260: astore 5
    //   262: aload 8
    //   264: ldc_w 491
    //   267: aload_1
    //   268: getfield 480	com/tencent/wxop/stat/f:a	I
    //   271: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   274: invokevirtual 377	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   277: aload 6
    //   279: astore 5
    //   281: aload_0
    //   282: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   285: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   288: ldc_w 466
    //   291: aconst_null
    //   292: aload 8
    //   294: invokevirtual 315	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   297: lstore_3
    //   298: goto -115 -> 183
    //   301: aload 6
    //   303: astore 5
    //   305: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   308: new 96	java/lang/StringBuilder
    //   311: dup
    //   312: ldc_w 493
    //   315: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   318: aload 7
    //   320: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokevirtual 325	com/tencent/wxop/stat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   329: goto -110 -> 219
    //   332: astore_1
    //   333: aload 6
    //   335: astore 5
    //   337: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   340: aload_1
    //   341: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   344: aload 6
    //   346: ifnull +10 -> 356
    //   349: aload 6
    //   351: invokeinterface 489 1 0
    //   356: aload_0
    //   357: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   360: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   363: invokevirtual 321	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   366: goto -111 -> 255
    //   369: astore_1
    //   370: goto -115 -> 255
    //   373: astore_1
    //   374: aconst_null
    //   375: astore 5
    //   377: aload 5
    //   379: ifnull +10 -> 389
    //   382: aload 5
    //   384: invokeinterface 489 1 0
    //   389: aload_0
    //   390: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   393: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   396: invokevirtual 321	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   399: aload_1
    //   400: athrow
    //   401: astore_1
    //   402: aload_0
    //   403: monitorexit
    //   404: aload_1
    //   405: athrow
    //   406: astore 5
    //   408: goto -9 -> 399
    //   411: astore_1
    //   412: goto -35 -> 377
    //   415: astore_1
    //   416: aconst_null
    //   417: astore 6
    //   419: goto -86 -> 333
    //   422: astore_1
    //   423: goto -168 -> 255
    //   426: iconst_0
    //   427: istore_2
    //   428: goto -302 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	au
    //   0	431	1	paramf	f
    //   125	303	2	i1	int
    //   182	116	3	l1	long
    //   13	370	5	localObject	Object
    //   406	1	5	localException	java.lang.Exception
    //   89	329	6	localCursor	android.database.Cursor
    //   6	313	7	str	String
    //   22	271	8	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   95	105	332	java/lang/Throwable
    //   109	124	332	java/lang/Throwable
    //   130	140	332	java/lang/Throwable
    //   149	183	332	java/lang/Throwable
    //   195	219	332	java/lang/Throwable
    //   223	233	332	java/lang/Throwable
    //   262	277	332	java/lang/Throwable
    //   281	298	332	java/lang/Throwable
    //   305	329	332	java/lang/Throwable
    //   356	366	369	java/lang/Exception
    //   2	91	373	finally
    //   238	245	401	finally
    //   245	255	401	finally
    //   349	356	401	finally
    //   356	366	401	finally
    //   382	389	401	finally
    //   389	399	401	finally
    //   399	401	401	finally
    //   389	399	406	java/lang/Exception
    //   95	105	411	finally
    //   109	124	411	finally
    //   130	140	411	finally
    //   149	183	411	finally
    //   195	219	411	finally
    //   223	233	411	finally
    //   262	277	411	finally
    //   281	298	411	finally
    //   305	329	411	finally
    //   337	344	411	finally
    //   2	91	415	java/lang/Throwable
    //   245	255	422	java/lang/Exception
  }
  
  /* Error */
  private void b(List<bd> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_3
    //   2: invokespecial 495	com/tencent/wxop/stat/au:d	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   5: astore 7
    //   7: iconst_1
    //   8: invokestatic 297	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   11: astore 8
    //   13: iload_2
    //   14: invokestatic 297	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   17: astore 9
    //   19: aload 7
    //   21: ldc_w 260
    //   24: aconst_null
    //   25: ldc_w 379
    //   28: iconst_1
    //   29: anewarray 381	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload 8
    //   36: aastore
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aload 9
    //   42: invokevirtual 498	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore 7
    //   47: aload 7
    //   49: invokeinterface 475 1 0
    //   54: ifeq +173 -> 227
    //   57: aload 7
    //   59: iconst_0
    //   60: invokeinterface 502 2 0
    //   65: lstore 5
    //   67: aload 7
    //   69: iconst_1
    //   70: invokeinterface 505 2 0
    //   75: astore 9
    //   77: aload 9
    //   79: astore 8
    //   81: getstatic 507	com/tencent/wxop/stat/StatConfig:g	Z
    //   84: ifne +10 -> 94
    //   87: aload 9
    //   89: invokestatic 508	com/tencent/wxop/stat/common/r:a	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 8
    //   94: aload 7
    //   96: iconst_2
    //   97: invokeinterface 479 2 0
    //   102: istore_2
    //   103: aload 7
    //   105: iconst_3
    //   106: invokeinterface 479 2 0
    //   111: istore 4
    //   113: new 162	com/tencent/wxop/stat/bd
    //   116: dup
    //   117: lload 5
    //   119: aload 8
    //   121: iload_2
    //   122: iload 4
    //   124: invokespecial 511	com/tencent/wxop/stat/bd:<init>	(JLjava/lang/String;II)V
    //   127: astore 8
    //   129: invokestatic 184	com/tencent/wxop/stat/StatConfig:isDebugEnable	()Z
    //   132: ifeq +55 -> 187
    //   135: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   138: new 96	java/lang/StringBuilder
    //   141: dup
    //   142: ldc_w 513
    //   145: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   148: lload 5
    //   150: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   153: ldc_w 515
    //   156: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload 4
    //   161: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: ldc_w 517
    //   167: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 7
    //   172: iconst_4
    //   173: invokeinterface 502 2 0
    //   178: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   181: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokevirtual 194	com/tencent/wxop/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   187: aload_1
    //   188: aload 8
    //   190: invokeinterface 521 2 0
    //   195: pop
    //   196: goto -149 -> 47
    //   199: astore 8
    //   201: aload 7
    //   203: astore_1
    //   204: aload 8
    //   206: astore 7
    //   208: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   211: aload 7
    //   213: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   216: aload_1
    //   217: ifnull +9 -> 226
    //   220: aload_1
    //   221: invokeinterface 489 1 0
    //   226: return
    //   227: aload 7
    //   229: ifnull -3 -> 226
    //   232: aload 7
    //   234: invokeinterface 489 1 0
    //   239: return
    //   240: astore_1
    //   241: aconst_null
    //   242: astore 7
    //   244: aload 7
    //   246: ifnull +10 -> 256
    //   249: aload 7
    //   251: invokeinterface 489 1 0
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: goto -15 -> 244
    //   262: astore 8
    //   264: aload_1
    //   265: astore 7
    //   267: aload 8
    //   269: astore_1
    //   270: goto -26 -> 244
    //   273: astore 7
    //   275: aconst_null
    //   276: astore_1
    //   277: goto -69 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	au
    //   0	280	1	paramList	List<bd>
    //   0	280	2	paramInt	int
    //   0	280	3	paramBoolean	boolean
    //   111	49	4	i1	int
    //   65	84	5	l1	long
    //   5	261	7	localObject1	Object
    //   273	1	7	localThrowable1	Throwable
    //   11	178	8	localObject2	Object
    //   199	6	8	localThrowable2	Throwable
    //   262	6	8	localObject3	Object
    //   17	71	9	str	String
    // Exception table:
    //   from	to	target	type
    //   47	77	199	java/lang/Throwable
    //   81	94	199	java/lang/Throwable
    //   94	187	199	java/lang/Throwable
    //   187	196	199	java/lang/Throwable
    //   0	47	240	finally
    //   47	77	258	finally
    //   81	94	258	finally
    //   94	187	258	finally
    //   187	196	258	finally
    //   208	216	262	finally
    //   0	47	273	java/lang/Throwable
  }
  
  private SQLiteDatabase c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.c.getWritableDatabase();
    }
    return this.d.getWritableDatabase();
  }
  
  private SQLiteDatabase d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.c.getReadableDatabase();
    }
    return this.d.getReadableDatabase();
  }
  
  private void f()
  {
    this.a = (g() + h());
  }
  
  private int g()
  {
    return (int)DatabaseUtils.queryNumEntries(this.c.getReadableDatabase(), "events");
  }
  
  private int h()
  {
    return (int)DatabaseUtils.queryNumEntries(this.d.getReadableDatabase(), "events");
  }
  
  private void i()
  {
    localObject5 = null;
    Object localObject1 = null;
    if (this.m) {
      return;
    }
    synchronized (this.l)
    {
      if (this.l.size() == 0) {
        return;
      }
    }
    this.m = true;
    if (StatConfig.isDebugEnable()) {
      h.i("insert " + this.l.size() + " events ,numEventsCachedInMemory:" + StatConfig.m + ",numStoredEvents:" + this.a);
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
      Object localObject3 = localSQLiteDatabase;
      localObject5 = localSQLiteDatabase;
      localSQLiteDatabase.beginTransaction();
      localObject3 = localSQLiteDatabase;
      localObject5 = localSQLiteDatabase;
      Iterator localIterator = this.l.entrySet().iterator();
      for (;;)
      {
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        com.tencent.wxop.stat.event.e locale = (com.tencent.wxop.stat.event.e)((Map.Entry)localIterator.next()).getKey();
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        String str = locale.g();
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        if (StatConfig.isDebugEnable())
        {
          localObject3 = localSQLiteDatabase;
          localObject5 = localSQLiteDatabase;
          h.i("insert content:" + str);
        }
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localContentValues.put("content", r.b(str));
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localContentValues.put("send_count", "0");
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localContentValues.put("status", Integer.toString(1));
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localContentValues.put("timestamp", Long.valueOf(locale.c()));
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localSQLiteDatabase.insert("events", null, localContentValues);
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localIterator.remove();
      }
      try
      {
        localObject5.endTransaction();
        f();
        throw localObject4;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          h.e(localThrowable3);
        }
      }
    }
    catch (Throwable localThrowable4)
    {
      localObject5 = localObject3;
      h.e(localThrowable4);
      if (localObject3 != null) {}
      try
      {
        localObject3.endTransaction();
        f();
        for (;;)
        {
          this.m = false;
          if (StatConfig.isDebugEnable()) {
            h.i("after insert, cacheEventsInMemory.size():" + this.l.size() + ",numEventsCachedInMemory:" + StatConfig.m + ",numStoredEvents:" + this.a);
          }
          return;
          localObject3 = localThrowable4;
          localObject5 = localThrowable4;
          localThrowable4.setTransactionSuccessful();
          if (localThrowable4 != null) {
            try
            {
              localThrowable4.endTransaction();
              f();
            }
            catch (Throwable localThrowable1)
            {
              h.e(localThrowable1);
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          h.e(localThrowable2);
        }
      }
    }
    finally
    {
      if (localObject5 == null) {}
    }
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   4: invokevirtual 464	com/tencent/wxop/stat/bc:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 552
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 470	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_1
    //   22: aload_2
    //   23: invokeinterface 475 1 0
    //   28: ifeq +51 -> 79
    //   31: aload_2
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 78	com/tencent/wxop/stat/au:n	Ljava/util/HashMap;
    //   37: aload_2
    //   38: iconst_0
    //   39: invokeinterface 505 2 0
    //   44: aload_2
    //   45: iconst_1
    //   46: invokeinterface 505 2 0
    //   51: invokevirtual 553	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: goto -35 -> 20
    //   58: astore_3
    //   59: aload_2
    //   60: astore_1
    //   61: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   64: aload_3
    //   65: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   68: aload_2
    //   69: ifnull +9 -> 78
    //   72: aload_2
    //   73: invokeinterface 489 1 0
    //   78: return
    //   79: aload_2
    //   80: ifnull -2 -> 78
    //   83: aload_2
    //   84: invokeinterface 489 1 0
    //   89: return
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +9 -> 103
    //   97: aload_1
    //   98: invokeinterface 489 1 0
    //   103: aload_2
    //   104: athrow
    //   105: astore_2
    //   106: goto -13 -> 93
    //   109: astore_3
    //   110: aconst_null
    //   111: astore_2
    //   112: goto -53 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	au
    //   21	77	1	localCursor1	android.database.Cursor
    //   19	65	2	localCursor2	android.database.Cursor
    //   90	14	2	localObject1	Object
    //   105	1	2	localObject2	Object
    //   111	1	2	localObject3	Object
    //   58	7	3	localThrowable1	Throwable
    //   109	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   22	31	58	java/lang/Throwable
    //   33	55	58	java/lang/Throwable
    //   0	20	90	finally
    //   22	31	105	finally
    //   33	55	105	finally
    //   61	68	105	finally
    //   0	20	109	java/lang/Throwable
  }
  
  public int a()
  {
    return this.a;
  }
  
  void a(int paramInt)
  {
    this.e.a(new bb(this, paramInt));
  }
  
  void a(com.tencent.wxop.stat.event.e parame, h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      this.e.a(new ay(this, parame, paramh, paramBoolean1, paramBoolean2));
    }
  }
  
  void a(f paramf)
  {
    if (paramf == null) {
      return;
    }
    this.e.a(new az(this, paramf));
  }
  
  void a(List<bd> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      this.e.a(new av(this, paramList, paramInt, paramBoolean1, paramBoolean2));
    }
  }
  
  void a(List<bd> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      this.e.a(new aw(this, paramList, paramBoolean1, paramBoolean2));
    }
  }
  
  /* Error */
  public a b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/tencent/wxop/stat/au:b	Lcom/tencent/wxop/stat/common/a;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 67	com/tencent/wxop/stat/au:b	Lcom/tencent/wxop/stat/common/a;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   22: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: invokevirtual 246	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   28: invokestatic 184	com/tencent/wxop/stat/StatConfig:isDebugEnable	()Z
    //   31: ifeq +12 -> 43
    //   34: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   37: ldc_w 585
    //   40: invokevirtual 194	com/tencent/wxop/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   47: invokevirtual 464	com/tencent/wxop/stat/bc:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: ldc_w 587
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 498	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 11
    //   65: iconst_0
    //   66: istore_2
    //   67: aload 11
    //   69: invokeinterface 475 1 0
    //   74: ifeq +365 -> 439
    //   77: aload 11
    //   79: iconst_0
    //   80: invokeinterface 505 2 0
    //   85: astore 16
    //   87: aload 16
    //   89: invokestatic 508	com/tencent/wxop/stat/common/r:a	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 12
    //   94: aload 11
    //   96: iconst_1
    //   97: invokeinterface 479 2 0
    //   102: istore 5
    //   104: aload 11
    //   106: iconst_2
    //   107: invokeinterface 505 2 0
    //   112: astore 10
    //   114: aload 11
    //   116: iconst_3
    //   117: invokeinterface 502 2 0
    //   122: lstore 6
    //   124: invokestatic 592	java/lang/System:currentTimeMillis	()J
    //   127: ldc2_w 593
    //   130: ldiv
    //   131: lstore 8
    //   133: iload 5
    //   135: iconst_1
    //   136: if_icmpeq +754 -> 890
    //   139: lload 6
    //   141: ldc2_w 593
    //   144: lmul
    //   145: invokestatic 596	com/tencent/wxop/stat/common/l:a	(J)Ljava/lang/String;
    //   148: ldc2_w 593
    //   151: lload 8
    //   153: lmul
    //   154: invokestatic 596	com/tencent/wxop/stat/common/l:a	(J)Ljava/lang/String;
    //   157: invokevirtual 599	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifne +730 -> 890
    //   163: iconst_1
    //   164: istore_2
    //   165: aload 10
    //   167: aload_1
    //   168: invokestatic 601	com/tencent/wxop/stat/common/l:l	(Landroid/content/Context;)Ljava/lang/String;
    //   171: invokevirtual 599	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifne +711 -> 885
    //   177: iload_2
    //   178: iconst_2
    //   179: ior
    //   180: istore_3
    //   181: aload 12
    //   183: ldc 170
    //   185: invokevirtual 605	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   188: astore 14
    //   190: iconst_0
    //   191: istore 4
    //   193: iconst_0
    //   194: istore_2
    //   195: aload 14
    //   197: ifnull +441 -> 638
    //   200: aload 14
    //   202: arraylength
    //   203: ifle +435 -> 638
    //   206: aload 14
    //   208: iconst_0
    //   209: aaload
    //   210: astore 10
    //   212: aload 10
    //   214: ifnull +13 -> 227
    //   217: aload 10
    //   219: invokevirtual 608	java/lang/String:length	()I
    //   222: bipush 11
    //   224: if_icmpge +646 -> 870
    //   227: aload_1
    //   228: invokestatic 610	com/tencent/wxop/stat/common/r:a	(Landroid/content/Context;)Ljava/lang/String;
    //   231: astore 13
    //   233: aload 13
    //   235: ifnull +629 -> 864
    //   238: aload 13
    //   240: invokevirtual 608	java/lang/String:length	()I
    //   243: bipush 10
    //   245: if_icmple +619 -> 864
    //   248: iconst_1
    //   249: istore_2
    //   250: aload 13
    //   252: astore 10
    //   254: goto +642 -> 896
    //   257: aload 14
    //   259: ifnull +394 -> 653
    //   262: aload 14
    //   264: arraylength
    //   265: iconst_2
    //   266: if_icmplt +387 -> 653
    //   269: aload 14
    //   271: iconst_1
    //   272: aaload
    //   273: astore 14
    //   275: new 96	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 611	java/lang/StringBuilder:<init>	()V
    //   282: aload 12
    //   284: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc 170
    //   289: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 14
    //   294: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore 13
    //   302: iload_2
    //   303: istore 4
    //   305: aload_0
    //   306: new 613	com/tencent/wxop/stat/common/a
    //   309: dup
    //   310: aload 12
    //   312: aload 14
    //   314: iload_3
    //   315: invokespecial 616	com/tencent/wxop/stat/common/a:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   318: putfield 67	com/tencent/wxop/stat/au:b	Lcom/tencent/wxop/stat/common/a;
    //   321: new 268	android/content/ContentValues
    //   324: dup
    //   325: invokespecial 269	android/content/ContentValues:<init>	()V
    //   328: astore 10
    //   330: aload 10
    //   332: ldc_w 618
    //   335: aload 13
    //   337: invokestatic 282	com/tencent/wxop/stat/common/r:b	(Ljava/lang/String;)Ljava/lang/String;
    //   340: invokevirtual 286	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload 10
    //   345: ldc_w 620
    //   348: iload_3
    //   349: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: invokevirtual 377	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   355: aload 10
    //   357: ldc_w 622
    //   360: aload_1
    //   361: invokestatic 601	com/tencent/wxop/stat/common/l:l	(Landroid/content/Context;)Ljava/lang/String;
    //   364: invokevirtual 286	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload 10
    //   369: ldc_w 624
    //   372: lload 8
    //   374: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   377: invokevirtual 311	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   380: iload 4
    //   382: ifeq +31 -> 413
    //   385: aload_0
    //   386: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   389: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   392: ldc_w 587
    //   395: aload 10
    //   397: ldc_w 626
    //   400: iconst_1
    //   401: anewarray 381	java/lang/String
    //   404: dup
    //   405: iconst_0
    //   406: aload 16
    //   408: aastore
    //   409: invokevirtual 390	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   412: pop
    //   413: iload_3
    //   414: iload 5
    //   416: if_icmpeq +495 -> 911
    //   419: aload_0
    //   420: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   423: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   426: ldc_w 587
    //   429: aconst_null
    //   430: aload 10
    //   432: invokevirtual 629	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   435: pop2
    //   436: goto +475 -> 911
    //   439: iload_2
    //   440: ifne +158 -> 598
    //   443: aload_1
    //   444: invokestatic 631	com/tencent/wxop/stat/common/l:b	(Landroid/content/Context;)Ljava/lang/String;
    //   447: astore 12
    //   449: aload_1
    //   450: invokestatic 633	com/tencent/wxop/stat/common/l:c	(Landroid/content/Context;)Ljava/lang/String;
    //   453: astore 13
    //   455: aload 13
    //   457: ifnull +400 -> 857
    //   460: aload 13
    //   462: invokevirtual 608	java/lang/String:length	()I
    //   465: ifle +392 -> 857
    //   468: new 96	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 611	java/lang/StringBuilder:<init>	()V
    //   475: aload 12
    //   477: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: ldc 170
    //   482: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload 13
    //   487: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: astore 10
    //   495: invokestatic 592	java/lang/System:currentTimeMillis	()J
    //   498: ldc2_w 593
    //   501: ldiv
    //   502: lstore 6
    //   504: aload_1
    //   505: invokestatic 601	com/tencent/wxop/stat/common/l:l	(Landroid/content/Context;)Ljava/lang/String;
    //   508: astore_1
    //   509: new 268	android/content/ContentValues
    //   512: dup
    //   513: invokespecial 269	android/content/ContentValues:<init>	()V
    //   516: astore 14
    //   518: aload 14
    //   520: ldc_w 618
    //   523: aload 10
    //   525: invokestatic 282	com/tencent/wxop/stat/common/r:b	(Ljava/lang/String;)Ljava/lang/String;
    //   528: invokevirtual 286	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   531: aload 14
    //   533: ldc_w 620
    //   536: iconst_0
    //   537: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   540: invokevirtual 377	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   543: aload 14
    //   545: ldc_w 622
    //   548: aload_1
    //   549: invokevirtual 286	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: aload 14
    //   554: ldc_w 624
    //   557: lload 6
    //   559: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   562: invokevirtual 311	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   565: aload_0
    //   566: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   569: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   572: ldc_w 587
    //   575: aconst_null
    //   576: aload 14
    //   578: invokevirtual 315	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   581: pop2
    //   582: aload_0
    //   583: new 613	com/tencent/wxop/stat/common/a
    //   586: dup
    //   587: aload 12
    //   589: aload 13
    //   591: iconst_0
    //   592: invokespecial 616	com/tencent/wxop/stat/common/a:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   595: putfield 67	com/tencent/wxop/stat/au:b	Lcom/tencent/wxop/stat/common/a;
    //   598: aload_0
    //   599: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   602: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   605: invokevirtual 318	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   608: aload 11
    //   610: ifnull +10 -> 620
    //   613: aload 11
    //   615: invokeinterface 489 1 0
    //   620: aload_0
    //   621: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   624: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   627: invokevirtual 321	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   630: aload_0
    //   631: getfield 67	com/tencent/wxop/stat/au:b	Lcom/tencent/wxop/stat/common/a;
    //   634: astore_1
    //   635: goto -621 -> 14
    //   638: aload_1
    //   639: invokestatic 631	com/tencent/wxop/stat/common/l:b	(Landroid/content/Context;)Ljava/lang/String;
    //   642: astore 10
    //   644: iconst_1
    //   645: istore_2
    //   646: aload 10
    //   648: astore 12
    //   650: goto -393 -> 257
    //   653: aload_1
    //   654: invokestatic 633	com/tencent/wxop/stat/common/l:c	(Landroid/content/Context;)Ljava/lang/String;
    //   657: astore 15
    //   659: iload_2
    //   660: istore 4
    //   662: aload 15
    //   664: astore 14
    //   666: aload 10
    //   668: astore 13
    //   670: aload 15
    //   672: ifnull -367 -> 305
    //   675: iload_2
    //   676: istore 4
    //   678: aload 15
    //   680: astore 14
    //   682: aload 10
    //   684: astore 13
    //   686: aload 15
    //   688: invokevirtual 608	java/lang/String:length	()I
    //   691: ifle -386 -> 305
    //   694: new 96	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 611	java/lang/StringBuilder:<init>	()V
    //   701: aload 12
    //   703: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: ldc 170
    //   708: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: aload 15
    //   713: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: astore 13
    //   721: iconst_1
    //   722: istore 4
    //   724: aload 15
    //   726: astore 14
    //   728: goto -423 -> 305
    //   731: astore_1
    //   732: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   735: aload_1
    //   736: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   739: goto -109 -> 630
    //   742: astore_1
    //   743: aload_0
    //   744: monitorexit
    //   745: aload_1
    //   746: athrow
    //   747: astore 10
    //   749: aconst_null
    //   750: astore_1
    //   751: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   754: aload 10
    //   756: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   759: aload_1
    //   760: ifnull +9 -> 769
    //   763: aload_1
    //   764: invokeinterface 489 1 0
    //   769: aload_0
    //   770: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   773: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   776: invokevirtual 321	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   779: goto -149 -> 630
    //   782: astore_1
    //   783: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   786: aload_1
    //   787: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   790: goto -160 -> 630
    //   793: astore_1
    //   794: aconst_null
    //   795: astore 11
    //   797: aload 11
    //   799: ifnull +10 -> 809
    //   802: aload 11
    //   804: invokeinterface 489 1 0
    //   809: aload_0
    //   810: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   813: invokevirtual 258	com/tencent/wxop/stat/bc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   816: invokevirtual 321	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   819: aload_1
    //   820: athrow
    //   821: astore 10
    //   823: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   826: aload 10
    //   828: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   831: goto -12 -> 819
    //   834: astore_1
    //   835: goto -38 -> 797
    //   838: astore 10
    //   840: aload_1
    //   841: astore 11
    //   843: aload 10
    //   845: astore_1
    //   846: goto -49 -> 797
    //   849: astore 10
    //   851: aload 11
    //   853: astore_1
    //   854: goto -103 -> 751
    //   857: aload 12
    //   859: astore 10
    //   861: goto -366 -> 495
    //   864: iload 4
    //   866: istore_2
    //   867: goto +29 -> 896
    //   870: aload 10
    //   872: astore 13
    //   874: aload 12
    //   876: astore 10
    //   878: aload 13
    //   880: astore 12
    //   882: goto -625 -> 257
    //   885: iload_2
    //   886: istore_3
    //   887: goto -706 -> 181
    //   890: iload 5
    //   892: istore_2
    //   893: goto -728 -> 165
    //   896: aload 10
    //   898: astore 13
    //   900: aload 12
    //   902: astore 10
    //   904: aload 13
    //   906: astore 12
    //   908: goto -651 -> 257
    //   911: iconst_1
    //   912: istore_2
    //   913: goto -474 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	916	0	this	au
    //   0	916	1	paramContext	Context
    //   66	847	2	i1	int
    //   180	707	3	i2	int
    //   191	674	4	i3	int
    //   102	789	5	i4	int
    //   122	436	6	l1	long
    //   131	242	8	l2	long
    //   112	571	10	localObject1	Object
    //   747	8	10	localThrowable1	Throwable
    //   821	6	10	localThrowable2	Throwable
    //   838	6	10	localObject2	Object
    //   849	1	10	localThrowable3	Throwable
    //   859	44	10	localObject3	Object
    //   63	789	11	localObject4	Object
    //   92	815	12	localObject5	Object
    //   231	674	13	localObject6	Object
    //   188	539	14	localObject7	Object
    //   657	68	15	str1	String
    //   85	322	16	str2	String
    // Exception table:
    //   from	to	target	type
    //   613	620	731	java/lang/Throwable
    //   620	630	731	java/lang/Throwable
    //   2	14	742	finally
    //   613	620	742	finally
    //   620	630	742	finally
    //   630	635	742	finally
    //   732	739	742	finally
    //   763	769	742	finally
    //   769	779	742	finally
    //   783	790	742	finally
    //   802	809	742	finally
    //   809	819	742	finally
    //   819	821	742	finally
    //   823	831	742	finally
    //   18	43	747	java/lang/Throwable
    //   43	65	747	java/lang/Throwable
    //   763	769	782	java/lang/Throwable
    //   769	779	782	java/lang/Throwable
    //   18	43	793	finally
    //   43	65	793	finally
    //   802	809	821	java/lang/Throwable
    //   809	819	821	java/lang/Throwable
    //   67	133	834	finally
    //   139	163	834	finally
    //   165	177	834	finally
    //   181	190	834	finally
    //   200	206	834	finally
    //   217	227	834	finally
    //   227	233	834	finally
    //   238	248	834	finally
    //   262	269	834	finally
    //   275	302	834	finally
    //   305	380	834	finally
    //   385	413	834	finally
    //   419	436	834	finally
    //   443	455	834	finally
    //   460	495	834	finally
    //   495	598	834	finally
    //   598	608	834	finally
    //   638	644	834	finally
    //   653	659	834	finally
    //   686	721	834	finally
    //   751	759	838	finally
    //   67	133	849	java/lang/Throwable
    //   139	163	849	java/lang/Throwable
    //   165	177	849	java/lang/Throwable
    //   181	190	849	java/lang/Throwable
    //   200	206	849	java/lang/Throwable
    //   217	227	849	java/lang/Throwable
    //   227	233	849	java/lang/Throwable
    //   238	248	849	java/lang/Throwable
    //   262	269	849	java/lang/Throwable
    //   275	302	849	java/lang/Throwable
    //   305	380	849	java/lang/Throwable
    //   385	413	849	java/lang/Throwable
    //   419	436	849	java/lang/Throwable
    //   443	455	849	java/lang/Throwable
    //   460	495	849	java/lang/Throwable
    //   495	598	849	java/lang/Throwable
    //   598	608	849	java/lang/Throwable
    //   638	644	849	java/lang/Throwable
    //   653	659	849	java/lang/Throwable
    //   686	721	849	java/lang/Throwable
  }
  
  void c()
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    try
    {
      this.e.a(new ax(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      h.e(localThrowable);
    }
  }
  
  /* Error */
  void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/wxop/stat/au:c	Lcom/tencent/wxop/stat/bc;
    //   4: invokevirtual 464	com/tencent/wxop/stat/bc:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 466
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 470	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 4
    //   21: aload 4
    //   23: astore_3
    //   24: aload 4
    //   26: invokeinterface 475 1 0
    //   31: ifeq +151 -> 182
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: iconst_0
    //   40: invokeinterface 479 2 0
    //   45: istore_1
    //   46: aload 4
    //   48: astore_3
    //   49: aload 4
    //   51: iconst_1
    //   52: invokeinterface 505 2 0
    //   57: astore 5
    //   59: aload 4
    //   61: astore_3
    //   62: aload 4
    //   64: iconst_2
    //   65: invokeinterface 505 2 0
    //   70: astore 6
    //   72: aload 4
    //   74: astore_3
    //   75: aload 4
    //   77: iconst_3
    //   78: invokeinterface 479 2 0
    //   83: istore_2
    //   84: aload 4
    //   86: astore_3
    //   87: new 443	com/tencent/wxop/stat/f
    //   90: dup
    //   91: iload_1
    //   92: invokespecial 641	com/tencent/wxop/stat/f:<init>	(I)V
    //   95: astore 7
    //   97: aload 4
    //   99: astore_3
    //   100: aload 7
    //   102: iload_1
    //   103: putfield 480	com/tencent/wxop/stat/f:a	I
    //   106: aload 4
    //   108: astore_3
    //   109: aload 7
    //   111: new 452	org/json/JSONObject
    //   114: dup
    //   115: aload 5
    //   117: invokespecial 642	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   120: putfield 450	com/tencent/wxop/stat/f:b	Lorg/json/JSONObject;
    //   123: aload 4
    //   125: astore_3
    //   126: aload 7
    //   128: aload 6
    //   130: putfield 457	com/tencent/wxop/stat/f:c	Ljava/lang/String;
    //   133: aload 4
    //   135: astore_3
    //   136: aload 7
    //   138: iload_2
    //   139: putfield 461	com/tencent/wxop/stat/f:d	I
    //   142: aload 4
    //   144: astore_3
    //   145: getstatic 42	com/tencent/wxop/stat/au:i	Landroid/content/Context;
    //   148: aload 7
    //   150: invokestatic 645	com/tencent/wxop/stat/StatConfig:a	(Landroid/content/Context;Lcom/tencent/wxop/stat/f;)V
    //   153: goto -132 -> 21
    //   156: astore 5
    //   158: aload 4
    //   160: astore_3
    //   161: getstatic 40	com/tencent/wxop/stat/au:h	Lcom/tencent/wxop/stat/common/StatLogger;
    //   164: aload 5
    //   166: invokevirtual 131	com/tencent/wxop/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   169: aload 4
    //   171: ifnull +10 -> 181
    //   174: aload 4
    //   176: invokeinterface 489 1 0
    //   181: return
    //   182: aload 4
    //   184: ifnull -3 -> 181
    //   187: aload 4
    //   189: invokeinterface 489 1 0
    //   194: return
    //   195: astore 4
    //   197: aconst_null
    //   198: astore_3
    //   199: aload_3
    //   200: ifnull +9 -> 209
    //   203: aload_3
    //   204: invokeinterface 489 1 0
    //   209: aload 4
    //   211: athrow
    //   212: astore 4
    //   214: goto -15 -> 199
    //   217: astore 5
    //   219: aconst_null
    //   220: astore 4
    //   222: goto -64 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	au
    //   45	58	1	i1	int
    //   83	56	2	i2	int
    //   23	181	3	localCursor1	android.database.Cursor
    //   19	169	4	localCursor2	android.database.Cursor
    //   195	15	4	localObject1	Object
    //   212	1	4	localObject2	Object
    //   220	1	4	localObject3	Object
    //   57	59	5	str1	String
    //   156	9	5	localThrowable1	Throwable
    //   217	1	5	localThrowable2	Throwable
    //   70	59	6	str2	String
    //   95	54	7	localf	f
    // Exception table:
    //   from	to	target	type
    //   24	34	156	java/lang/Throwable
    //   37	46	156	java/lang/Throwable
    //   49	59	156	java/lang/Throwable
    //   62	72	156	java/lang/Throwable
    //   75	84	156	java/lang/Throwable
    //   87	97	156	java/lang/Throwable
    //   100	106	156	java/lang/Throwable
    //   109	123	156	java/lang/Throwable
    //   126	133	156	java/lang/Throwable
    //   136	142	156	java/lang/Throwable
    //   145	153	156	java/lang/Throwable
    //   0	21	195	finally
    //   24	34	212	finally
    //   37	46	212	finally
    //   49	59	212	finally
    //   62	72	212	finally
    //   75	84	212	finally
    //   87	97	212	finally
    //   100	106	212	finally
    //   109	123	212	finally
    //   126	133	212	finally
    //   136	142	212	finally
    //   145	153	212	finally
    //   161	169	212	finally
    //   0	21	217	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.au
 * JD-Core Version:    0.7.0.1
 */