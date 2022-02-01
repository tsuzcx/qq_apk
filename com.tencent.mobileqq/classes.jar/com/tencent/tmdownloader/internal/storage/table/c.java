package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.downloadservice.a.b;
import com.tencent.tmdownloader.internal.storage.a.a;
import java.util.ArrayList;

public class c
  implements com.tencent.tmassistant.common.a.c
{
  private static final Object a = new Object();
  
  private static int a(com.tencent.tmdownloader.internal.downloadservice.c paramc, SQLiteDatabase paramSQLiteDatabase)
  {
    int i;
    if (paramc == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        ContentValues localContentValues = new ContentValues();
        com.tencent.tmdownloader.internal.downloadservice.c.a(localContentValues, paramc);
        int j = paramSQLiteDatabase.update("downloadInfo", localContentValues, "taskUrl = ?", new String[] { paramc.b });
        i = j;
        if (j <= 0) {
          return 0;
        }
      }
      catch (Exception paramc)
      {
        ab.c("DownloadInfoTable", "exception: ", paramc);
        paramc.printStackTrace();
      }
    }
    return -2;
  }
  
  public static ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> a()
  {
    Object localObject4 = null;
    Object localObject1 = null;
    ArrayList localArrayList;
    Object localObject5;
    synchronized (a)
    {
      localArrayList = new ArrayList();
      localObject5 = a.c().getReadableDatabase();
      if (localObject5 == null) {}
    }
    try
    {
      localObject5 = ((SQLiteDatabase)localObject5).rawQuery("select * from downloadInfo", null);
      if (localObject5 != null)
      {
        localObject1 = localObject5;
        localObject4 = localObject5;
        if (((Cursor)localObject5).moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localObject5;
            localObject4 = localObject5;
            localArrayList.add(com.tencent.tmdownloader.internal.downloadservice.c.a((Cursor)localObject5));
            localObject1 = localObject5;
            localObject4 = localObject5;
            bool = ((Cursor)localObject5).moveToNext();
          } while (bool);
        }
      }
      if (localObject5 != null) {
        ((Cursor)localObject5).close();
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localObject4 = localObject1;
      ab.c("DownloadInfoTable", "exception: ", localException);
      localObject4 = localObject1;
      localException.printStackTrace();
      if (localObject1 != null) {
        localObject1.close();
      }
      return localArrayList;
      localObject2 = finally;
      throw localObject2;
    }
    finally
    {
      if (localObject4 != null) {
        localObject4.close();
      }
    }
  }
  
  public static void a(com.tencent.tmdownloader.internal.downloadservice.c paramc)
  {
    localObject = a;
    if (paramc != null) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = a.c().getWritableDatabase();
      if ((localSQLiteDatabase != null) && (a(paramc, localSQLiteDatabase) <= 0))
      {
        ContentValues localContentValues = new ContentValues();
        com.tencent.tmdownloader.internal.downloadservice.c.a(localContentValues, paramc);
        localSQLiteDatabase.insert("downloadInfo", null, localContentValues);
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        ab.c("DownloadInfoTable", "exception: ", paramc);
        paramc.printStackTrace();
      }
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = a.c().getWritableDatabase();
      if (localSQLiteDatabase != null) {
        localSQLiteDatabase.delete("downloadInfo", "taskUrl = ?", new String[] { paramString });
      }
      return;
    }
    catch (Exception paramString)
    {
      ab.c("DownloadInfoTable", "exception: ", paramString);
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public static void a(ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> paramArrayList)
  {
    // Byte code:
    //   0: getstatic 15	com/tencent/tmdownloader/internal/storage/table/c:a	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnull +95 -> 102
    //   10: invokestatic 65	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   13: invokevirtual 102	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +84 -> 102
    //   21: aload_2
    //   22: invokevirtual 121	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   25: aload_0
    //   26: invokevirtual 125	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   29: astore_0
    //   30: aload_0
    //   31: invokeinterface 130 1 0
    //   36: ifeq +69 -> 105
    //   39: aload_0
    //   40: invokeinterface 134 1 0
    //   45: checkcast 24	com/tencent/tmdownloader/internal/downloadservice/c
    //   48: astore_3
    //   49: aload_3
    //   50: aload_2
    //   51: invokestatic 104	com/tencent/tmdownloader/internal/storage/table/c:a	(Lcom/tencent/tmdownloader/internal/downloadservice/c;Landroid/database/sqlite/SQLiteDatabase;)I
    //   54: ifgt -24 -> 30
    //   57: new 21	android/content/ContentValues
    //   60: dup
    //   61: invokespecial 22	android/content/ContentValues:<init>	()V
    //   64: astore 4
    //   66: aload 4
    //   68: aload_3
    //   69: invokestatic 27	com/tencent/tmdownloader/internal/downloadservice/c:a	(Landroid/content/ContentValues;Lcom/tencent/tmdownloader/internal/downloadservice/c;)V
    //   72: aload_2
    //   73: ldc 29
    //   75: aconst_null
    //   76: aload 4
    //   78: invokevirtual 108	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   81: pop2
    //   82: goto -52 -> 30
    //   85: astore_0
    //   86: ldc 45
    //   88: ldc 47
    //   90: aload_0
    //   91: invokestatic 53	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload_0
    //   95: invokevirtual 56	java/lang/Exception:printStackTrace	()V
    //   98: aload_2
    //   99: invokevirtual 137	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   102: aload_1
    //   103: monitorexit
    //   104: return
    //   105: aload_2
    //   106: invokevirtual 140	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   109: aload_2
    //   110: invokevirtual 137	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   113: goto -11 -> 102
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 56	java/lang/Exception:printStackTrace	()V
    //   121: goto -19 -> 102
    //   124: astore_0
    //   125: aload_1
    //   126: monitorexit
    //   127: aload_0
    //   128: athrow
    //   129: astore_0
    //   130: aload_2
    //   131: invokevirtual 137	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   134: aload_0
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramArrayList	ArrayList<com.tencent.tmdownloader.internal.downloadservice.c>
    //   3	123	1	localObject	Object
    //   16	115	2	localSQLiteDatabase	SQLiteDatabase
    //   48	21	3	localc	com.tencent.tmdownloader.internal.downloadservice.c
    //   64	13	4	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   21	30	85	java/lang/Exception
    //   30	82	85	java/lang/Exception
    //   105	109	85	java/lang/Exception
    //   10	17	116	java/lang/Exception
    //   98	102	116	java/lang/Exception
    //   109	113	116	java/lang/Exception
    //   130	136	116	java/lang/Exception
    //   10	17	124	finally
    //   98	102	124	finally
    //   102	104	124	finally
    //   109	113	124	finally
    //   117	121	124	finally
    //   125	127	124	finally
    //   130	136	124	finally
    //   21	30	129	finally
    //   30	82	129	finally
    //   86	98	129	finally
    //   105	109	129	finally
  }
  
  /* Error */
  public static com.tencent.tmdownloader.internal.downloadservice.c b(String paramString)
  {
    // Byte code:
    //   0: getstatic 15	com/tencent/tmdownloader/internal/storage/table/c:a	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnull +82 -> 89
    //   10: aload_0
    //   11: invokevirtual 113	java/lang/String:length	()I
    //   14: ifle +75 -> 89
    //   17: invokestatic 65	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   20: invokevirtual 71	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +64 -> 89
    //   28: aload_1
    //   29: ldc 144
    //   31: iconst_1
    //   32: anewarray 33	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: aastore
    //   39: invokevirtual 77	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +35 -> 79
    //   47: aload_1
    //   48: astore_0
    //   49: aload_1
    //   50: invokeinterface 83 1 0
    //   55: ifeq +24 -> 79
    //   58: aload_1
    //   59: astore_0
    //   60: aload_1
    //   61: invokestatic 86	com/tencent/tmdownloader/internal/downloadservice/c:a	(Landroid/database/Cursor;)Lcom/tencent/tmdownloader/internal/downloadservice/c;
    //   64: astore_2
    //   65: aload_1
    //   66: ifnull +9 -> 75
    //   69: aload_1
    //   70: invokeinterface 96 1 0
    //   75: aload_3
    //   76: monitorexit
    //   77: aload_2
    //   78: areturn
    //   79: aload_1
    //   80: ifnull +9 -> 89
    //   83: aload_1
    //   84: invokeinterface 96 1 0
    //   89: aload_3
    //   90: monitorexit
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aload_3
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_0
    //   103: ldc 45
    //   105: ldc 47
    //   107: aload_2
    //   108: invokestatic 53	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_1
    //   112: astore_0
    //   113: aload_2
    //   114: invokevirtual 56	java/lang/Exception:printStackTrace	()V
    //   117: aload_1
    //   118: ifnull -29 -> 89
    //   121: aload_1
    //   122: invokeinterface 96 1 0
    //   127: goto -38 -> 89
    //   130: aload_0
    //   131: ifnull +9 -> 140
    //   134: aload_0
    //   135: invokeinterface 96 1 0
    //   140: aload_1
    //   141: athrow
    //   142: astore_1
    //   143: goto -13 -> 130
    //   146: astore_2
    //   147: goto -46 -> 101
    //   150: astore_1
    //   151: aconst_null
    //   152: astore_0
    //   153: goto -23 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString	String
    //   23	118	1	localObject1	Object
    //   142	1	1	localObject2	Object
    //   150	1	1	localObject3	Object
    //   64	14	2	localc	com.tencent.tmdownloader.internal.downloadservice.c
    //   98	16	2	localException1	Exception
    //   146	1	2	localException2	Exception
    //   3	92	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   10	24	93	finally
    //   69	75	93	finally
    //   75	77	93	finally
    //   83	89	93	finally
    //   89	91	93	finally
    //   94	96	93	finally
    //   121	127	93	finally
    //   134	140	93	finally
    //   140	142	93	finally
    //   28	43	98	java/lang/Exception
    //   49	58	142	finally
    //   60	65	142	finally
    //   103	111	142	finally
    //   113	117	142	finally
    //   49	58	146	java/lang/Exception
    //   60	65	146	java/lang/Exception
    //   28	43	150	finally
  }
  
  public static ArrayList<b> b()
  {
    Object localObject4 = null;
    Object localObject1 = null;
    ArrayList localArrayList;
    Object localObject5;
    synchronized (a)
    {
      localArrayList = new ArrayList();
      localObject5 = a.c().getReadableDatabase();
      if (localObject5 == null) {}
    }
    try
    {
      localObject5 = ((SQLiteDatabase)localObject5).rawQuery("select a.taskUrl,a.status,b.clientId from downloadInfo as a left outer join clientinfo as b on a.taskUrl = b.taskUrl where b.clientId is not null and (a.status = 2 or a.status = 1)", null);
      if (localObject5 != null)
      {
        localObject1 = localObject5;
        localObject4 = localObject5;
        if (((Cursor)localObject5).moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localObject5;
            localObject4 = localObject5;
            Object localObject7 = ((Cursor)localObject5).getString(((Cursor)localObject5).getColumnIndex("clientId"));
            localObject1 = localObject5;
            localObject4 = localObject5;
            String str = ((Cursor)localObject5).getString(((Cursor)localObject5).getColumnIndex("taskUrl"));
            localObject1 = localObject5;
            localObject4 = localObject5;
            int i = ((Cursor)localObject5).getInt(((Cursor)localObject5).getColumnIndex("status"));
            localObject1 = localObject5;
            localObject4 = localObject5;
            localObject7 = new b((String)localObject7, str);
            localObject1 = localObject5;
            localObject4 = localObject5;
            ((b)localObject7).c = i;
            localObject1 = localObject5;
            localObject4 = localObject5;
            localArrayList.add(localObject7);
            localObject1 = localObject5;
            localObject4 = localObject5;
            bool = ((Cursor)localObject5).moveToNext();
          } while (bool);
        }
      }
      if (localObject5 != null) {
        ((Cursor)localObject5).close();
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localObject4 = localObject1;
      ab.c("DownloadInfoTable", "exception: ", localException);
      localObject4 = localObject1;
      localException.printStackTrace();
      if (localObject1 != null) {
        localObject1.close();
      }
      return localArrayList;
      localObject2 = finally;
      throw localObject2;
    }
    finally
    {
      if (localObject4 != null) {
        localObject4.close();
      }
    }
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists downloadInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId INTEGER , uId TEXT, taskUrl TEXT, bakUrl TEXT,finalUrl TEXT, fileName TEXT, contentType TEXT, totalBytes INTEGER,status INTEGER,receivedBytes INTEGER,priority INTEGER, netType TEXT,downloadFailedErrCode INTEGER,downloadFailedTime INTEGER,headerParams TEXT,appId INTEGER,taskPakcageName TEXT,taskVersioncode TEXT,startTime INTEGER,endTime INTEGER,downloadType INTEGER,uin INTEGER,uintype TEXT,via TEXT,channelId TEXT,traceId TEXT,extraData TEXT,iconUrl TEXT,appName TEXT,isAutoInstallBySDK INTEGER,fileSize INTEGER);";
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramInt2 == 2)) {
      return new String[] { "alter table downloadInfo add column headerParams TEXT;" };
    }
    if ((paramInt1 == 2) && (paramInt2 == 3)) {
      return new String[] { "alter table downloadInfo add column appId INTEGER;", "alter table downloadInfo add column taskPakcageName TEXT;", "alter table downloadInfo add column taskVersioncode TEXT;", "alter table downloadInfo add column startTime INTEGER;", "alter table downloadInfo add column endTime INTEGER;", "alter table downloadInfo add column downloadType INTEGER;", "alter table downloadInfo add column uin INTEGER;", "alter table downloadInfo add column uintype TEXT;", "alter table downloadInfo add column via TEXT;", "alter table downloadInfo add column channelId TEXT;", "alter table downloadInfo add column traceId TEXT;", "alter table downloadInfo add column extraData TEXT;" };
    }
    if ((paramInt1 == 3) && (paramInt2 == 4)) {
      return new String[] { "alter table downloadInfo add column iconUrl TEXT;", "alter table downloadInfo add column appName TEXT;" };
    }
    if ((paramInt1 == 4) && (paramInt2 == 5)) {
      return new String[] { "alter table downloadInfo add column isAutoInstallBySDK INTEGER;" };
    }
    if ((paramInt1 == 5) && (paramInt2 == 6)) {
      return new String[] { "alter table downloadInfo add column fileSize INTEGER;" };
    }
    return new String[] { "alter table downloadInfo add column netType TEXT;", "alter table downloadInfo add column downloadFailedErrCode INTEGER;", "alter table downloadInfo add column downloadFailedTime INTEGER;" };
  }
  
  public String tableName()
  {
    return "downloadInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.c
 * JD-Core Version:    0.7.0.1
 */