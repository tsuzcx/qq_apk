package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.tmassistant.common.a.c;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.storage.a.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
  implements c
{
  private final Map<String, String> a = new ConcurrentHashMap();
  private final Map<String, byte[]> b = new ConcurrentHashMap();
  
  private void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    Object localObject;
    for (;;)
    {
      long l1;
      try
      {
        if (TextUtils.isEmpty(paramString1))
        {
          r.e("SettingTable", "key should not be empty!!");
          return;
        }
        l1 = System.currentTimeMillis();
        this.a.put(paramString1, paramString2);
        localObject = a.c();
        if (localObject == null)
        {
          r.e("SettingTable", "<commonInsert> sqliteHelper is null");
          continue;
        }
        localObject = ((d)localObject).getWritableDatabase();
      }
      finally {}
      if (localObject == null) {
        r.e("SettingTable", "<commonInsert> db is null");
      } else {
        for (;;)
        {
          try
          {
            ((SQLiteDatabase)localObject).beginTransaction();
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("key", paramString1);
            localContentValues.put("value", paramString2);
            localContentValues.put("data", paramArrayOfByte);
            int i = ((SQLiteDatabase)localObject).delete("setting_table", "key=?", new String[] { paramString1 });
            long l2 = ((SQLiteDatabase)localObject).insert("setting_table", null, localContentValues);
            r.c("SettingTable", "<commonInsert> deleteResult =  " + i + ", insertResult = " + l2);
            localContentValues.clear();
            ((SQLiteDatabase)localObject).setTransactionSuccessful();
          }
          catch (Exception paramString1)
          {
            r.c("SettingTable", "<commonInsert> error " + paramString1.getMessage());
            if (!((SQLiteDatabase)localObject).isOpen()) {
              continue;
            }
            bool = ((SQLiteDatabase)localObject).inTransaction();
            if (!bool) {
              continue;
            }
            try
            {
              ((SQLiteDatabase)localObject).endTransaction();
            }
            catch (Exception paramString1)
            {
              r.e("SettingTable", "<commonInsert> end transaction error");
            }
            continue;
          }
          finally
          {
            if (!((SQLiteDatabase)localObject).isOpen()) {
              break label363;
            }
            boolean bool = ((SQLiteDatabase)localObject).inTransaction();
            if (!bool) {
              break label363;
            }
          }
          try
          {
            ((SQLiteDatabase)localObject).endTransaction();
            r.c("SettingTable", "<commonInsert> time cost : " + (System.currentTimeMillis() - l1) + "ms");
          }
          catch (Exception paramString1)
          {
            r.e("SettingTable", "<commonInsert> end transaction error");
          }
        }
      }
    }
    try
    {
      ((SQLiteDatabase)localObject).endTransaction();
      label363:
      throw paramString1;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        r.e("SettingTable", "<commonInsert> end transaction error");
      }
    }
  }
  
  private void b()
  {
    localObject5 = null;
    Object localObject1 = null;
    try
    {
      r.c("SettingTable", "<initCache> begin");
      Object localObject6 = a.c();
      if (localObject6 == null) {
        r.e("SettingTable", "<initCache> sqliteHelper is null");
      }
      for (;;)
      {
        return;
        localObject6 = ((d)localObject6).getWritableDatabase();
        if (localObject6 == null)
        {
          r.e("SettingTable", "<initCache> db is null");
          continue;
        }
        try
        {
          localObject6 = ((SQLiteDatabase)localObject6).rawQuery("select * from setting_table", null);
          String str1;
          String str2;
          byte[] arrayOfByte;
          if (localObject6 != null)
          {
            localObject3 = localObject6;
            localObject5 = localObject6;
            if (((Cursor)localObject6).moveToFirst())
            {
              localObject3 = localObject6;
              localObject5 = localObject6;
              str1 = ((Cursor)localObject6).getString(((Cursor)localObject6).getColumnIndexOrThrow("key"));
              localObject3 = localObject6;
              localObject5 = localObject6;
              str2 = ((Cursor)localObject6).getString(((Cursor)localObject6).getColumnIndexOrThrow("value"));
              localObject3 = localObject6;
              localObject5 = localObject6;
              arrayOfByte = ((Cursor)localObject6).getBlob(((Cursor)localObject6).getColumnIndexOrThrow("data"));
              localObject5 = localObject6;
            }
          }
          try
          {
            r.c("SettingTable", "loading cache key = " + str1 + ",value = " + str2 + ",data = " + arrayOfByte.length);
            localObject3 = localObject6;
            localObject5 = localObject6;
            if (!TextUtils.isEmpty(str2))
            {
              localObject3 = localObject6;
              localObject5 = localObject6;
              this.a.put(str1, str2);
            }
            if (arrayOfByte != null)
            {
              localObject3 = localObject6;
              localObject5 = localObject6;
              if (arrayOfByte.length > 0)
              {
                localObject3 = localObject6;
                localObject5 = localObject6;
                this.b.put(str1, arrayOfByte);
              }
            }
            localObject3 = localObject6;
            localObject5 = localObject6;
            boolean bool = ((Cursor)localObject6).moveToNext();
            if (bool) {
              break label91;
            }
            if (localObject6 == null) {
              continue;
            }
            ((Cursor)localObject6).close();
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localObject3 = localObject6;
              localObject5 = localObject6;
              localException2.printStackTrace();
            }
          }
        }
        catch (Exception localException1)
        {
          Object localObject3;
          localObject5 = localObject3;
          r.c("SettingTable", "initCache exception: ", localException1);
          localObject5 = localObject3;
          localException1.printStackTrace();
          if (localObject3 == null) {
            continue;
          }
          localObject3.close();
        }
        finally
        {
          if (localObject5 != null) {
            localObject5.close();
          }
        }
      }
    }
    finally {}
  }
  
  /* Error */
  private String f(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 212
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 20	com/tencent/tmdownloader/internal/storage/table/e:a	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 216 2 0
    //   16: ifeq +62 -> 78
    //   19: aload_0
    //   20: getfield 20	com/tencent/tmdownloader/internal/storage/table/e:a	Ljava/util/Map;
    //   23: aload_1
    //   24: invokeinterface 220 2 0
    //   29: checkcast 101	java/lang/String
    //   32: astore 4
    //   34: ldc 40
    //   36: new 111	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   43: ldc 222
    //   45: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 224
    //   54: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload 4
    //   59: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 226
    //   64: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 132	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 4
    //   77: areturn
    //   78: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   81: lstore_2
    //   82: aload 5
    //   84: astore 4
    //   86: aload_1
    //   87: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifne +189 -> 279
    //   93: invokestatic 66	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   96: astore 4
    //   98: aload 4
    //   100: ifnonnull +17 -> 117
    //   103: ldc 40
    //   105: ldc 228
    //   107: invokestatic 48	com/tencent/tmassistantbase/util/r:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc 212
    //   112: astore 4
    //   114: goto -41 -> 73
    //   117: aload 4
    //   119: invokevirtual 74	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   122: astore 4
    //   124: aload 4
    //   126: ifnonnull +22 -> 148
    //   129: ldc 40
    //   131: ldc 230
    //   133: invokestatic 48	com/tencent/tmassistantbase/util/r:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 5
    //   138: astore 4
    //   140: goto -67 -> 73
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    //   148: aconst_null
    //   149: astore 8
    //   151: aload 4
    //   153: ldc 232
    //   155: iconst_1
    //   156: anewarray 101	java/lang/String
    //   159: dup
    //   160: iconst_0
    //   161: aload_1
    //   162: aastore
    //   163: invokevirtual 171	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   166: astore 6
    //   168: aload 5
    //   170: astore 7
    //   172: aload 6
    //   174: ifnull +85 -> 259
    //   177: aload 5
    //   179: astore 7
    //   181: aload 6
    //   183: astore 8
    //   185: aload 5
    //   187: astore 4
    //   189: aload 6
    //   191: invokeinterface 176 1 0
    //   196: ifeq +63 -> 259
    //   199: aload 6
    //   201: astore 8
    //   203: aload 5
    //   205: astore 4
    //   207: aload 6
    //   209: aload 6
    //   211: ldc 90
    //   213: invokeinterface 180 2 0
    //   218: invokeinterface 184 2 0
    //   223: astore 5
    //   225: aload 5
    //   227: astore 7
    //   229: aload 5
    //   231: ifnull +28 -> 259
    //   234: aload 6
    //   236: astore 8
    //   238: aload 5
    //   240: astore 4
    //   242: aload_0
    //   243: getfield 20	com/tencent/tmdownloader/internal/storage/table/e:a	Ljava/util/Map;
    //   246: aload_1
    //   247: aload 5
    //   249: invokeinterface 60 3 0
    //   254: pop
    //   255: aload 5
    //   257: astore 7
    //   259: aload 7
    //   261: astore 4
    //   263: aload 6
    //   265: ifnull +14 -> 279
    //   268: aload 6
    //   270: invokeinterface 200 1 0
    //   275: aload 7
    //   277: astore 4
    //   279: ldc 40
    //   281: new 111	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   288: ldc 234
    //   290: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   296: lload_2
    //   297: lsub
    //   298: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   301: ldc 152
    //   303: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 132	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: goto -239 -> 73
    //   315: aload 4
    //   317: ifnull +42 -> 359
    //   320: aload 4
    //   322: invokeinterface 200 1 0
    //   327: aload_1
    //   328: astore 4
    //   330: goto -51 -> 279
    //   333: astore_1
    //   334: aload 8
    //   336: ifnull +10 -> 346
    //   339: aload 8
    //   341: invokeinterface 200 1 0
    //   346: aload_1
    //   347: athrow
    //   348: astore_1
    //   349: aload 4
    //   351: astore_1
    //   352: aload 6
    //   354: astore 4
    //   356: goto -41 -> 315
    //   359: aload_1
    //   360: astore 4
    //   362: goto -83 -> 279
    //   365: astore_1
    //   366: ldc 212
    //   368: astore_1
    //   369: aconst_null
    //   370: astore 4
    //   372: goto -57 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	e
    //   0	375	1	paramString	String
    //   81	216	2	l	long
    //   32	339	4	localObject1	Object
    //   4	252	5	str1	String
    //   166	187	6	localCursor	Cursor
    //   170	106	7	str2	String
    //   149	191	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	73	143	finally
    //   78	82	143	finally
    //   86	98	143	finally
    //   103	110	143	finally
    //   117	124	143	finally
    //   129	136	143	finally
    //   268	275	143	finally
    //   279	312	143	finally
    //   320	327	143	finally
    //   339	346	143	finally
    //   346	348	143	finally
    //   151	168	333	finally
    //   189	199	333	finally
    //   207	225	333	finally
    //   242	255	333	finally
    //   189	199	348	java/lang/Exception
    //   207	225	348	java/lang/Exception
    //   242	255	348	java/lang/Exception
    //   151	168	365	java/lang/Exception
  }
  
  public void a()
  {
    if (m.a())
    {
      r.c("SettingTable", "<SettingTable> init begin, process " + m.e());
      com.tencent.tmassistantbase.util.f.a().postDelayed(new f(this), 1000L);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    r.c("SettingTable", "<setInt>key=" + paramString + ", value=" + String.valueOf(paramInt) + ", process:" + m.e());
    com.tencent.tmassistantbase.util.f.a().post(new g(this, paramString, paramInt));
    r.c("SettingTable", "<setInt> exit");
  }
  
  public void a(String paramString, long paramLong)
  {
    r.c("SettingTable", "<setLong>key=" + paramString + ", value=" + String.valueOf(paramLong) + ", process:" + m.e());
    com.tencent.tmassistantbase.util.f.a().post(new h(this, paramString, paramLong));
    r.c("SettingTable", "<setLong> exit");
  }
  
  public void a(String paramString1, String paramString2)
  {
    r.c("SettingTable", "<setString>key=" + paramString1 + ", value=" + String.valueOf(paramString2) + ", process:" + m.e());
    com.tencent.tmassistantbase.util.f.a().post(new i(this, paramString1, paramString2));
    r.c("SettingTable", "<setString> exit");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    r.c("SettingTable", "<setBoolean>key=" + paramString + ", value=" + String.valueOf(paramBoolean) + ",process:" + m.e());
    com.tencent.tmassistantbase.util.f.a().post(new k(this, paramString, paramBoolean));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    r.c("SettingTable", "<setBlob>key=" + paramString + ", value.length=" + paramArrayOfByte.length + ",process:" + m.e());
    com.tencent.tmassistantbase.util.f.a().post(new j(this, paramString, paramArrayOfByte));
  }
  
  public boolean a(String paramString)
  {
    r.c("SettingTable", "<getBoolean> key=" + paramString + ",process:" + m.e());
    try
    {
      boolean bool = Boolean.valueOf(f(paramString)).booleanValue();
      return bool;
    }
    catch (Exception paramString)
    {
      r.e("SettingTable", "<getBoolean> error, e = " + paramString.getMessage() + ",process:" + m.e());
    }
    return false;
  }
  
  public int b(String paramString)
  {
    r.c("SettingTable", "<getInt> key=" + paramString + ",process:" + m.e());
    try
    {
      int i = Integer.valueOf(f(paramString)).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      r.e("SettingTable", "<getInt> error, e = " + paramString.getMessage() + ",process:" + m.e());
    }
    return 0;
  }
  
  public long c(String paramString)
  {
    r.c("SettingTable", "<getLong> key=" + paramString + ",process:" + m.e());
    try
    {
      long l = Long.valueOf(f(paramString)).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      r.e("SettingTable", "<getLong> error, e = " + paramString.getMessage() + ",process:" + m.e());
    }
    return 0L;
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists setting_table (_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT,value TEXT,data BLOB);";
  }
  
  public String d(String paramString)
  {
    r.c("SettingTable", "<getString> key=" + paramString + ",process:" + m.e());
    try
    {
      paramString = f(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      r.e("SettingTable", "<getString> error, e = " + paramString.getMessage() + ",process:" + m.e());
    }
    return "";
  }
  
  /* Error */
  public byte[] e(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: ldc 40
    //   10: new 111	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 379
    //   20: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 313
    //   30: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokestatic 242	com/tencent/tmassistantbase/util/m:e	()Ljava/lang/String;
    //   36: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 132	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: iconst_0
    //   46: newarray byte
    //   48: astore 4
    //   50: aload_0
    //   51: getfield 22	com/tencent/tmdownloader/internal/storage/table/e:b	Ljava/util/Map;
    //   54: aload_1
    //   55: invokeinterface 216 2 0
    //   60: ifeq +60 -> 120
    //   63: aload_0
    //   64: getfield 22	com/tencent/tmdownloader/internal/storage/table/e:b	Ljava/util/Map;
    //   67: aload_1
    //   68: invokeinterface 220 2 0
    //   73: checkcast 381	[B
    //   76: astore_2
    //   77: ldc 40
    //   79: new 111	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   86: ldc 222
    //   88: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 383
    //   98: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_2
    //   102: invokevirtual 386	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: ldc 226
    //   107: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 132	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_2
    //   119: areturn
    //   120: aload 4
    //   122: astore_2
    //   123: aload_1
    //   124: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne -11 -> 116
    //   130: invokestatic 66	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   133: astore_2
    //   134: aload_2
    //   135: ifnonnull +16 -> 151
    //   138: ldc 40
    //   140: ldc_w 388
    //   143: invokestatic 48	com/tencent/tmassistantbase/util/r:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aconst_null
    //   147: astore_2
    //   148: goto -32 -> 116
    //   151: aload_2
    //   152: invokevirtual 74	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   155: astore 7
    //   157: aload 7
    //   159: ifnonnull +16 -> 175
    //   162: ldc 40
    //   164: ldc_w 390
    //   167: invokestatic 48	com/tencent/tmassistantbase/util/r:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aconst_null
    //   171: astore_2
    //   172: goto -56 -> 116
    //   175: aload 4
    //   177: astore_3
    //   178: aload 5
    //   180: astore_2
    //   181: aload 7
    //   183: ldc 232
    //   185: iconst_1
    //   186: anewarray 101	java/lang/String
    //   189: dup
    //   190: iconst_0
    //   191: aload_1
    //   192: aastore
    //   193: invokevirtual 171	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   196: astore 7
    //   198: aload 4
    //   200: astore 5
    //   202: aload 7
    //   204: ifnull +111 -> 315
    //   207: aload 4
    //   209: astore 5
    //   211: aload 4
    //   213: astore_3
    //   214: aload 7
    //   216: astore 6
    //   218: aload 7
    //   220: astore_2
    //   221: aload 7
    //   223: invokeinterface 176 1 0
    //   228: ifeq +87 -> 315
    //   231: aload 4
    //   233: astore_3
    //   234: aload 7
    //   236: astore 6
    //   238: aload 7
    //   240: astore_2
    //   241: aload 7
    //   243: aload 7
    //   245: ldc 92
    //   247: invokeinterface 180 2 0
    //   252: invokeinterface 188 2 0
    //   257: astore 4
    //   259: aload 4
    //   261: astore 5
    //   263: aload 4
    //   265: ifnull +50 -> 315
    //   268: aload 4
    //   270: astore 5
    //   272: aload 4
    //   274: astore_3
    //   275: aload 7
    //   277: astore 6
    //   279: aload 7
    //   281: astore_2
    //   282: aload 4
    //   284: arraylength
    //   285: ifle +30 -> 315
    //   288: aload 4
    //   290: astore_3
    //   291: aload 7
    //   293: astore 6
    //   295: aload 7
    //   297: astore_2
    //   298: aload_0
    //   299: getfield 22	com/tencent/tmdownloader/internal/storage/table/e:b	Ljava/util/Map;
    //   302: aload_1
    //   303: aload 4
    //   305: invokeinterface 60 3 0
    //   310: pop
    //   311: aload 4
    //   313: astore 5
    //   315: aload 5
    //   317: astore_2
    //   318: aload 7
    //   320: ifnull -204 -> 116
    //   323: aload 7
    //   325: invokeinterface 200 1 0
    //   330: aload 5
    //   332: astore_2
    //   333: goto -217 -> 116
    //   336: astore_1
    //   337: aload_0
    //   338: monitorexit
    //   339: aload_1
    //   340: athrow
    //   341: astore_1
    //   342: aload_3
    //   343: astore_2
    //   344: aload 6
    //   346: ifnull -230 -> 116
    //   349: aload 6
    //   351: invokeinterface 200 1 0
    //   356: aload_3
    //   357: astore_2
    //   358: goto -242 -> 116
    //   361: astore_1
    //   362: aload_2
    //   363: ifnull +9 -> 372
    //   366: aload_2
    //   367: invokeinterface 200 1 0
    //   372: aload_1
    //   373: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	e
    //   0	374	1	paramString	String
    //   76	291	2	localObject1	Object
    //   177	180	3	arrayOfByte1	byte[]
    //   48	264	4	arrayOfByte2	byte[]
    //   1	330	5	localObject2	Object
    //   4	346	6	localObject3	Object
    //   155	169	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	116	336	finally
    //   123	134	336	finally
    //   138	146	336	finally
    //   151	157	336	finally
    //   162	170	336	finally
    //   323	330	336	finally
    //   349	356	336	finally
    //   366	372	336	finally
    //   372	374	336	finally
    //   181	198	341	java/lang/Exception
    //   221	231	341	java/lang/Exception
    //   241	259	341	java/lang/Exception
    //   282	288	341	java/lang/Exception
    //   298	311	341	java/lang/Exception
    //   181	198	361	finally
    //   221	231	361	finally
    //   241	259	361	finally
    //   282	288	361	finally
    //   298	311	361	finally
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    return new String[0];
  }
  
  public String tableName()
  {
    return "setting_table";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.e
 * JD-Core Version:    0.7.0.1
 */