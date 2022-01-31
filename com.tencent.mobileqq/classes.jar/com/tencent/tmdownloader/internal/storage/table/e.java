package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.tmassistant.common.a.c;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.t;
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
          ac.e("SettingTable", "key should not be empty!!");
          return;
        }
        l1 = System.currentTimeMillis();
        this.a.put(paramString1, paramString2);
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
          this.b.put(paramString1, paramArrayOfByte);
        }
        localObject = a.c();
        if (localObject == null)
        {
          ac.e("SettingTable", "<commonInsert> sqliteHelper is null");
          continue;
        }
        localObject = ((d)localObject).getWritableDatabase();
      }
      finally {}
      if (localObject == null) {
        ac.e("SettingTable", "<commonInsert> db is null");
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
            ac.c("SettingTable", "<commonInsert> deleteResult =  " + i + ", insertResult = " + l2);
            localContentValues.clear();
            ((SQLiteDatabase)localObject).setTransactionSuccessful();
          }
          catch (Exception paramString1)
          {
            ac.c("SettingTable", "<commonInsert> error " + paramString1.getMessage());
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
              ac.e("SettingTable", "<commonInsert> end transaction error");
            }
            continue;
          }
          finally
          {
            if (!((SQLiteDatabase)localObject).isOpen()) {
              break label384;
            }
            boolean bool = ((SQLiteDatabase)localObject).inTransaction();
            if (!bool) {
              break label384;
            }
          }
          try
          {
            ((SQLiteDatabase)localObject).endTransaction();
            ac.c("SettingTable", "<commonInsert> time cost : " + (System.currentTimeMillis() - l1) + "ms");
          }
          catch (Exception paramString1)
          {
            ac.e("SettingTable", "<commonInsert> end transaction error");
          }
        }
      }
    }
    try
    {
      ((SQLiteDatabase)localObject).endTransaction();
      label384:
      throw paramString1;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        ac.e("SettingTable", "<commonInsert> end transaction error");
      }
    }
  }
  
  private void b()
  {
    localObject5 = null;
    Object localObject1 = null;
    try
    {
      ac.c("SettingTable", "<initCache> begin");
      Object localObject6 = a.c();
      if (localObject6 == null) {
        ac.e("SettingTable", "<initCache> sqliteHelper is null");
      }
      for (;;)
      {
        return;
        localObject6 = ((d)localObject6).getWritableDatabase();
        if (localObject6 == null)
        {
          ac.e("SettingTable", "<initCache> db is null");
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
            ac.c("SettingTable", "loading cache key = " + str1 + ",value = " + str2 + ",data = " + arrayOfByte.length);
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
          ac.c("SettingTable", "initCache exception: ", localException1);
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
  
  private String f(String paramString)
  {
    String str1 = "";
    if (this.a.containsKey(paramString))
    {
      localObject1 = (String)this.a.get(paramString);
      ac.c("SettingTable", "getting key=" + paramString + ",value=" + (String)localObject1 + ",using cache");
      return localObject1;
    }
    long l = System.currentTimeMillis();
    localObject1 = str1;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        break label273;
      }
      localObject1 = a.c();
      if (localObject1 == null)
      {
        ac.e("SettingTable", "<get> sqliteHelper is null");
        return "";
      }
    }
    finally {}
    localObject1 = ((d)localObject1).getWritableDatabase();
    if (localObject1 == null)
    {
      ac.e("SettingTable", "<get> db is null");
      return "";
    }
    localObject2 = null;
    try
    {
      localCursor = ((SQLiteDatabase)localObject1).rawQuery("select * from setting_table where key = ?", new String[] { paramString });
      str2 = str1;
      if (localCursor != null)
      {
        str2 = str1;
        localObject2 = localCursor;
        localObject1 = str1;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        String str2;
        label273:
        paramString = "";
        localObject1 = null;
        if (localObject1 == null) {
          break;
        }
        ((Cursor)localObject1).close();
        localObject1 = paramString;
      }
    }
    finally
    {
      if (localObject2 != null) {
        localObject2.close();
      }
    }
    try
    {
      if (localCursor.moveToFirst())
      {
        localObject2 = localCursor;
        localObject1 = str1;
        str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("value"));
        str2 = str1;
        if (str1 != null)
        {
          localObject2 = localCursor;
          localObject1 = str1;
          this.a.put(paramString, str1);
          str2 = str1;
        }
      }
      localObject1 = str2;
      if (localCursor != null)
      {
        localCursor.close();
        localObject1 = str2;
      }
    }
    catch (Exception paramString)
    {
      paramString = (String)localObject1;
      localObject1 = localCursor;
      break label318;
      localObject1 = paramString;
      break label273;
    }
    ac.c("SettingTable", "<get> time cost : " + (System.currentTimeMillis() - l) + "ms");
    return localObject1;
  }
  
  public void a()
  {
    if (t.a())
    {
      ac.c("SettingTable", "<SettingTable> init begin, process " + t.e());
      l.a().postDelayed(new f(this), 1000L);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    ac.c("SettingTable", "<setInt>key=" + paramString + ", value=" + String.valueOf(paramInt) + ", process:" + t.e());
    l.a().post(new g(this, paramString, paramInt));
    ac.c("SettingTable", "<setInt> exit");
  }
  
  public void a(String paramString, long paramLong)
  {
    ac.c("SettingTable", "<setLong>key=" + paramString + ", value=" + String.valueOf(paramLong) + ", process:" + t.e());
    l.a().post(new h(this, paramString, paramLong));
    ac.c("SettingTable", "<setLong> exit");
  }
  
  public void a(String paramString1, String paramString2)
  {
    ac.c("SettingTable", "<setString>key=" + paramString1 + ", value=" + String.valueOf(paramString2) + ", process:" + t.e());
    l.a().post(new i(this, paramString1, paramString2));
    ac.c("SettingTable", "<setString> exit");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ac.c("SettingTable", "<setBoolean>key=" + paramString + ", value=" + String.valueOf(paramBoolean) + ",process:" + t.e());
    l.a().post(new k(this, paramString, paramBoolean));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    ac.c("SettingTable", "<setBlob>key=" + paramString + ", value.length=" + paramArrayOfByte.length + ",process:" + t.e());
    l.a().post(new j(this, paramString, paramArrayOfByte));
  }
  
  public boolean a(String paramString)
  {
    ac.c("SettingTable", "<getBoolean> key=" + paramString + ",process:" + t.e());
    try
    {
      boolean bool = Boolean.valueOf(f(paramString)).booleanValue();
      return bool;
    }
    catch (Exception paramString)
    {
      ac.e("SettingTable", "<getBoolean> error, e = " + paramString.getMessage() + ",process:" + t.e());
    }
    return false;
  }
  
  public int b(String paramString)
  {
    ac.c("SettingTable", "<getInt> key=" + paramString + ",process:" + t.e());
    try
    {
      int i = Integer.valueOf(f(paramString)).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      ac.e("SettingTable", "<getInt> error, e = " + paramString.getMessage() + ",process:" + t.e());
    }
    return 0;
  }
  
  public long c(String paramString)
  {
    ac.c("SettingTable", "<getLong> key=" + paramString + ",process:" + t.e());
    try
    {
      long l = Long.valueOf(f(paramString)).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      ac.e("SettingTable", "<getLong> error, e = " + paramString.getMessage() + ",process:" + t.e());
    }
    return 0L;
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists setting_table (_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT,value TEXT,data BLOB);";
  }
  
  public String d(String paramString)
  {
    ac.c("SettingTable", "<getString> key=" + paramString + ",process:" + t.e());
    try
    {
      paramString = f(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.e("SettingTable", "<getString> error, e = " + paramString.getMessage() + ",process:" + t.e());
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
    //   33: invokestatic 242	com/tencent/tmassistantbase/util/t:e	()Ljava/lang/String;
    //   36: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 132	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   113: invokestatic 132	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   143: invokestatic 48	com/tencent/tmassistantbase/util/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   167: invokestatic 48	com/tencent/tmassistantbase/util/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.e
 * JD-Core Version:    0.7.0.1
 */