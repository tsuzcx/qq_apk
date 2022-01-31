package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SqliteDataManager
{
  private static final String COOKIE_DB_NAME = "Cookies";
  public static final String LOGTAG = CookieManager.LOGTAG;
  public static final String TABLE_COOKIES = "cookies";
  public static final String TABLE_META = "meta";
  static File webviewDir;
  
  public static boolean deleteCookieDBFiles(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    FileUtil.delete(getWebviewDir(paramContext), false);
    return true;
  }
  
  private static String getColumns(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from " + paramString, null);
    int i = paramSQLiteDatabase.getCount();
    int j = paramSQLiteDatabase.getColumnCount();
    paramString = new StringBuilder();
    paramString.append("raws:" + i + ",columns:" + j + "\n");
    if ((i > 0) && (paramSQLiteDatabase.moveToFirst())) {
      label133:
      do
      {
        paramString.append("\n");
        i = 0;
        while (i < j)
        {
          try
          {
            String str = paramSQLiteDatabase.getString(i);
            paramString.append(str).append(",");
          }
          catch (Exception localException)
          {
            break label133;
          }
          i += 1;
        }
        paramString.append("\n");
      } while (paramSQLiteDatabase.moveToNext());
    } else {
      return paramString.toString();
    }
  }
  
  public static String getCookieDBFileInfo(Context paramContext)
  {
    if (paramContext == null) {
      return "null";
    }
    paramContext = getWebviewDir(paramContext);
    if (paramContext.exists()) {
      return paramContext.getAbsolutePath() + ",size:" + paramContext.length() + ",latmodify:" + paramContext.lastModified();
    }
    return "not exit";
  }
  
  /* Error */
  public static int getCookieDBVersion(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aconst_null
    //   5: astore 6
    //   7: aconst_null
    //   8: astore 9
    //   10: aconst_null
    //   11: astore 8
    //   13: aconst_null
    //   14: astore 7
    //   16: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   19: pop2
    //   20: aload_0
    //   21: invokestatic 135	com/tencent/smtt/sdk/SqliteDataManager:getSqliteDb	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnonnull +40 -> 66
    //   29: iconst_m1
    //   30: istore_1
    //   31: iconst_0
    //   32: ifeq +11 -> 43
    //   35: new 137	java/lang/NullPointerException
    //   38: dup
    //   39: invokespecial 138	java/lang/NullPointerException:<init>	()V
    //   42: athrow
    //   43: iload_1
    //   44: istore_2
    //   45: aload_0
    //   46: ifnull +18 -> 64
    //   49: iload_1
    //   50: istore_2
    //   51: aload_0
    //   52: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   55: ifeq +9 -> 64
    //   58: aload_0
    //   59: invokevirtual 144	android/database/sqlite/SQLiteDatabase:close	()V
    //   62: iload_1
    //   63: istore_2
    //   64: iload_2
    //   65: ireturn
    //   66: aload 9
    //   68: astore 6
    //   70: aload 8
    //   72: astore 7
    //   74: aload_0
    //   75: ldc 146
    //   77: aconst_null
    //   78: invokevirtual 63	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore 8
    //   83: aload 8
    //   85: astore 6
    //   87: aload 8
    //   89: astore 7
    //   91: aload 8
    //   93: invokeinterface 69 1 0
    //   98: istore 4
    //   100: aload 8
    //   102: astore 6
    //   104: aload 8
    //   106: astore 7
    //   108: aload 8
    //   110: invokeinterface 72 1 0
    //   115: pop
    //   116: iload_2
    //   117: istore_1
    //   118: iload 4
    //   120: ifle +67 -> 187
    //   123: iload_2
    //   124: istore_1
    //   125: aload 8
    //   127: astore 6
    //   129: aload 8
    //   131: astore 7
    //   133: aload 8
    //   135: invokeinterface 85 1 0
    //   140: ifeq +47 -> 187
    //   143: aload 8
    //   145: astore 6
    //   147: aload 8
    //   149: astore 7
    //   151: aload 8
    //   153: iconst_0
    //   154: invokeinterface 89 2 0
    //   159: ldc 148
    //   161: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq +56 -> 220
    //   167: aload 8
    //   169: astore 6
    //   171: aload 8
    //   173: astore 7
    //   175: aload 8
    //   177: iconst_1
    //   178: invokeinterface 89 2 0
    //   183: invokestatic 160	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   186: istore_1
    //   187: aload 8
    //   189: ifnull +10 -> 199
    //   192: aload 8
    //   194: invokeinterface 161 1 0
    //   199: iload_1
    //   200: istore_2
    //   201: aload_0
    //   202: ifnull -138 -> 64
    //   205: iload_1
    //   206: istore_2
    //   207: aload_0
    //   208: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   211: ifeq -147 -> 64
    //   214: aload_0
    //   215: invokevirtual 144	android/database/sqlite/SQLiteDatabase:close	()V
    //   218: iload_1
    //   219: ireturn
    //   220: aload 8
    //   222: astore 6
    //   224: aload 8
    //   226: astore 7
    //   228: aload 8
    //   230: invokeinterface 94 1 0
    //   235: istore 5
    //   237: iload 5
    //   239: ifne -96 -> 143
    //   242: iload_2
    //   243: istore_1
    //   244: goto -57 -> 187
    //   247: astore_0
    //   248: aconst_null
    //   249: astore_0
    //   250: aload 7
    //   252: ifnull +10 -> 262
    //   255: aload 7
    //   257: invokeinterface 161 1 0
    //   262: iload_3
    //   263: istore_2
    //   264: aload_0
    //   265: ifnull -201 -> 64
    //   268: iload_3
    //   269: istore_2
    //   270: aload_0
    //   271: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   274: ifeq -210 -> 64
    //   277: aload_0
    //   278: invokevirtual 144	android/database/sqlite/SQLiteDatabase:close	()V
    //   281: iconst_0
    //   282: ireturn
    //   283: astore 7
    //   285: aconst_null
    //   286: astore_0
    //   287: aload 6
    //   289: ifnull +10 -> 299
    //   292: aload 6
    //   294: invokeinterface 161 1 0
    //   299: aload_0
    //   300: ifnull +14 -> 314
    //   303: aload_0
    //   304: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   307: ifeq +7 -> 314
    //   310: aload_0
    //   311: invokevirtual 144	android/database/sqlite/SQLiteDatabase:close	()V
    //   314: aload 7
    //   316: athrow
    //   317: astore 7
    //   319: goto -32 -> 287
    //   322: astore 6
    //   324: goto -74 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	paramContext	Context
    //   30	214	1	i	int
    //   1	269	2	j	int
    //   3	266	3	k	int
    //   98	21	4	m	int
    //   235	3	5	bool	boolean
    //   5	288	6	localObject1	Object
    //   322	1	6	localThrowable	Throwable
    //   14	242	7	localCursor1	Cursor
    //   283	32	7	localObject2	Object
    //   317	1	7	localObject3	Object
    //   11	218	8	localCursor2	Cursor
    //   8	59	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   20	25	247	java/lang/Throwable
    //   20	25	283	finally
    //   74	83	317	finally
    //   91	100	317	finally
    //   108	116	317	finally
    //   133	143	317	finally
    //   151	167	317	finally
    //   175	187	317	finally
    //   228	237	317	finally
    //   74	83	322	java/lang/Throwable
    //   91	100	322	java/lang/Throwable
    //   108	116	322	java/lang/Throwable
    //   133	143	322	java/lang/Throwable
    //   151	167	322	java/lang/Throwable
    //   175	187	322	java/lang/Throwable
    //   228	237	322	java/lang/Throwable
  }
  
  public static SQLiteDatabase getSqliteDb(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramContext == null) {}
    for (;;)
    {
      return localObject1;
      paramContext = getWebviewDir(paramContext);
      if (paramContext == null) {
        continue;
      }
      try
      {
        paramContext = SQLiteDatabase.openDatabase(paramContext.getAbsolutePath(), null, 0);
        localObject1 = paramContext;
        if (paramContext != null) {
          continue;
        }
        TbsLog.i(LOGTAG, "dbPath is not exist!");
        return paramContext;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext = localObject2;
        }
      }
    }
  }
  
  public static File getWebviewDir(Context paramContext)
  {
    if ((webviewDir == null) && (paramContext != null)) {
      webviewDir = new File(paramContext.getDir("webview", 0), "Cookies");
    }
    if (webviewDir == null) {
      webviewDir = new File("/data/data/" + paramContext.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
    }
    return webviewDir;
  }
  
  /* Error */
  public static java.util.ArrayList<String> showDB(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: new 203	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 204	java/util/ArrayList:<init>	()V
    //   15: astore 4
    //   17: aload_0
    //   18: ldc 206
    //   20: aconst_null
    //   21: invokevirtual 63	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: astore_3
    //   27: aload_2
    //   28: invokeinterface 85 1 0
    //   33: ifeq +56 -> 89
    //   36: aload_2
    //   37: astore_3
    //   38: aload_2
    //   39: iconst_1
    //   40: invokeinterface 89 2 0
    //   45: astore 5
    //   47: aload_2
    //   48: astore_3
    //   49: aload_2
    //   50: iconst_4
    //   51: invokeinterface 89 2 0
    //   56: pop
    //   57: aload_2
    //   58: astore_3
    //   59: aload 4
    //   61: aload 5
    //   63: invokevirtual 209	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload_2
    //   68: astore_3
    //   69: aload_0
    //   70: aload 5
    //   72: invokestatic 211	com/tencent/smtt/sdk/SqliteDataManager:getColumns	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
    //   75: pop
    //   76: aload_2
    //   77: astore_3
    //   78: aload_2
    //   79: invokeinterface 94 1 0
    //   84: istore_1
    //   85: iload_1
    //   86: ifne -50 -> 36
    //   89: aload_2
    //   90: ifnull +9 -> 99
    //   93: aload_2
    //   94: invokeinterface 161 1 0
    //   99: aload_0
    //   100: ifnull +14 -> 114
    //   103: aload_0
    //   104: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   107: ifeq +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 144	android/database/sqlite/SQLiteDatabase:close	()V
    //   114: aload 4
    //   116: areturn
    //   117: astore_2
    //   118: aload_3
    //   119: ifnull +9 -> 128
    //   122: aload_3
    //   123: invokeinterface 161 1 0
    //   128: aload_0
    //   129: ifnull -15 -> 114
    //   132: aload_0
    //   133: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   136: ifeq -22 -> 114
    //   139: aload_0
    //   140: invokevirtual 144	android/database/sqlite/SQLiteDatabase:close	()V
    //   143: goto -29 -> 114
    //   146: astore_2
    //   147: aconst_null
    //   148: astore 4
    //   150: aload_2
    //   151: astore_3
    //   152: aload 4
    //   154: ifnull +10 -> 164
    //   157: aload 4
    //   159: invokeinterface 161 1 0
    //   164: aload_0
    //   165: ifnull +14 -> 179
    //   168: aload_0
    //   169: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   172: ifeq +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 144	android/database/sqlite/SQLiteDatabase:close	()V
    //   179: aload_3
    //   180: athrow
    //   181: astore_3
    //   182: aload_2
    //   183: astore 4
    //   185: goto -33 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramSQLiteDatabase	SQLiteDatabase
    //   84	2	1	bool	boolean
    //   24	70	2	localCursor	Cursor
    //   117	1	2	localThrowable	Throwable
    //   146	37	2	localObject1	Object
    //   1	179	3	localObject2	Object
    //   181	1	3	localObject3	Object
    //   15	169	4	localObject4	Object
    //   45	26	5	str	String
    // Exception table:
    //   from	to	target	type
    //   17	25	117	java/lang/Throwable
    //   27	36	117	java/lang/Throwable
    //   38	47	117	java/lang/Throwable
    //   49	57	117	java/lang/Throwable
    //   59	67	117	java/lang/Throwable
    //   69	76	117	java/lang/Throwable
    //   78	85	117	java/lang/Throwable
    //   17	25	146	finally
    //   27	36	181	finally
    //   38	47	181	finally
    //   49	57	181	finally
    //   59	67	181	finally
    //   69	76	181	finally
    //   78	85	181	finally
  }
  
  public static void transformCookies(Context paramContext, CookieManager.COOKIE_MODE paramCOOKIE_MODE, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = null;
    Cursor localCursor = null;
    if (paramContext == null) {}
    label10:
    String[] arrayOfString;
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        break label10;
        break label10;
        do
        {
          return;
        } while ((paramCOOKIE_MODE == CookieManager.COOKIE_MODE.MODE_KEYS) && (TextUtils.isEmpty(paramString)));
        arrayOfString = paramString.split(",");
      } while ((arrayOfString == null) || (arrayOfString.length < 1));
      localSQLiteDatabase = getSqliteDb(paramContext);
    } while (localSQLiteDatabase == null);
    HashMap localHashMap = new HashMap();
    paramString = localCursor;
    for (;;)
    {
      int i;
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("select * from cookies", null);
        paramString = localCursor;
        localObject = localCursor;
        if (localCursor.getCount() > 0)
        {
          paramString = localCursor;
          localObject = localCursor;
          if (localCursor.moveToFirst())
          {
            paramString = localCursor;
            localObject = localCursor;
            str = localCursor.getString(localCursor.getColumnIndex("host_key"));
            paramString = localCursor;
            localObject = localCursor;
            if (paramCOOKIE_MODE != CookieManager.COOKIE_MODE.MODE_KEYS) {
              continue;
            }
            paramString = localCursor;
            localObject = localCursor;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              break label672;
            }
            paramString = localCursor;
            localObject = localCursor;
            if (!str.equals(arrayOfString[i])) {
              continue;
            }
            i = 1;
            break label675;
            paramString = localCursor;
            localObject = localCursor;
            paramBoolean2 = localCursor.moveToNext();
            if (paramBoolean2) {
              continue;
            }
          }
        }
        if (localCursor != null) {
          localCursor.close();
        }
        if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen())) {
          localSQLiteDatabase.close();
        }
      }
      catch (Throwable paramCOOKIE_MODE)
      {
        String str;
        StringBuilder localStringBuilder;
        localObject = paramString;
        Log.e(LOGTAG, "getCookieDBVersion exception:" + paramCOOKIE_MODE.toString());
        if (paramString == null) {
          continue;
        }
        paramString.close();
        if ((localSQLiteDatabase == null) || (!localSQLiteDatabase.isOpen())) {
          continue;
        }
        localSQLiteDatabase.close();
        continue;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        ((Cursor)localObject).close();
        if ((localSQLiteDatabase == null) || (!localSQLiteDatabase.isOpen())) {
          continue;
        }
        localSQLiteDatabase.close();
      }
      if (localHashMap.isEmpty()) {
        break;
      }
      deleteCookieDBFiles(paramContext);
      paramCOOKIE_MODE = localHashMap.entrySet().iterator();
      if (paramCOOKIE_MODE.hasNext())
      {
        localObject = (Map.Entry)paramCOOKIE_MODE.next();
        paramString = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        CookieManager.getInstance().setCookie(paramString, (String)localObject, true);
        continue;
        i += 1;
        continue;
        paramString = localCursor;
        localObject = localCursor;
        localStringBuilder = new StringBuilder();
        paramString = localCursor;
        localObject = localCursor;
        localStringBuilder.append(localCursor.getString(localCursor.getColumnIndex("value")));
        paramString = localCursor;
        localObject = localCursor;
        localStringBuilder.append(";").append(localCursor.getString(localCursor.getColumnIndex("name")));
        paramString = localCursor;
        localObject = localCursor;
        localStringBuilder.append(";").append(localCursor.getInt(localCursor.getColumnIndex("expires_utc")));
        paramString = localCursor;
        localObject = localCursor;
        localStringBuilder.append(";").append(localCursor.getInt(localCursor.getColumnIndex("priority")));
        paramString = localCursor;
        localObject = localCursor;
        localHashMap.put(str, localStringBuilder.toString());
      }
      else
      {
        if (Build.VERSION.SDK_INT >= 21) {
          CookieManager.getInstance().flush();
        }
        for (;;)
        {
          if (!paramBoolean1) {
            break label670;
          }
          showDB(getSqliteDb(paramContext));
          i = getCookieDBVersion(paramContext);
          if (i == -1) {
            break;
          }
          CookieManager.getInstance();
          CookieManager.setROMCookieDBVersion(paramContext, i);
          return;
          CookieSyncManager.getInstance().sync();
        }
        label670:
        break label10;
        label672:
        i = 0;
        label675:
        if (i != 0) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.SqliteDataManager
 * JD-Core Version:    0.7.0.1
 */