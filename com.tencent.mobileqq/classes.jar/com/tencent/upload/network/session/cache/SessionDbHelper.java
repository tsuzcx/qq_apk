package com.tencent.upload.network.session.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.upload.utils.UploadLog;

public class SessionDbHelper
{
  private static final String CREATE_TABLE = "CREATE TABLE session (_id INTEGER PRIMARY KEY AUTOINCREMENT,uin INTEGER,path TEXT,session TEXT,modified INTEGER,  UNIQUE (uin,path) ON CONFLICT REPLACE );";
  public static final String DATABASE_NAME = "upload_session";
  private static final int DATABASE_VERSION = 2;
  public static final String FILE_PATH = "path";
  public static final String MODIFIED_DATE = "modified";
  public static final String SESSION_ID = "session";
  private static final String SESSION_TABLE_NAME = "session";
  private static final String TAG = "SessionDbHelper";
  public static final String UIN = "uin";
  static String[] columns = { "_id", "uin", "path", "session", "modified" };
  private Context mContext = null;
  private SessionDbHelper.DatabaseHelper mOpenHelper;
  
  public SessionDbHelper(Context paramContext)
  {
    this.mContext = paramContext;
    open();
  }
  
  private void open()
  {
    this.mOpenHelper = new SessionDbHelper.DatabaseHelper(this.mContext);
  }
  
  public void clearUserData(long paramLong)
  {
    String str = Long.toString(paramLong);
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.mOpenHelper.getWritableDatabase();
      localObject1 = localSQLiteDatabase;
      localObject3 = localSQLiteDatabase;
      localSQLiteDatabase.delete("session", "uin = ? ", new String[] { str });
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      UploadLog.e("SessionDbHelper", "clearUserData failed. " + localException.toString());
      return;
    }
    finally
    {
      if ((localObject3 != null) && (localObject3.isOpen())) {
        localObject3.close();
      }
    }
  }
  
  public void close()
  {
    this.mOpenHelper.close();
  }
  
  public void delete(long paramLong, String paramString1, String paramString2)
  {
    String str = Long.toString(paramLong);
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.mOpenHelper.getWritableDatabase();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localSQLiteDatabase.delete("session", "uin = ? AND path = ?", new String[] { str, paramString1 });
      return;
    }
    catch (Exception localException)
    {
      localObject2 = localObject1;
      UploadLog.e("SessionDbHelper", "delete failed path=" + paramString1 + " session=" + paramString2 + localException.toString());
      return;
    }
    finally
    {
      if ((localObject2 != null) && (localObject2.isOpen())) {
        localObject2.close();
      }
    }
  }
  
  /* Error */
  public void insert(long paramLong, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 119	android/content/ContentValues
    //   6: dup
    //   7: invokespecial 120	android/content/ContentValues:<init>	()V
    //   10: astore 10
    //   12: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   15: lstore 5
    //   17: aload 10
    //   19: ldc 30
    //   21: lload_1
    //   22: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   25: invokevirtual 134	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   28: aload 10
    //   30: ldc 17
    //   32: aload_3
    //   33: invokevirtual 136	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload 10
    //   38: ldc 23
    //   40: aload 4
    //   42: invokevirtual 136	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload 10
    //   47: ldc 20
    //   49: lload 5
    //   51: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   54: invokevirtual 134	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   57: aload_0
    //   58: getfield 60	com/tencent/upload/network/session/cache/SessionDbHelper:mOpenHelper	Lcom/tencent/upload/network/session/cache/SessionDbHelper$DatabaseHelper;
    //   61: invokevirtual 74	com/tencent/upload/network/session/cache/SessionDbHelper$DatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   64: astore 9
    //   66: aload 9
    //   68: astore 7
    //   70: aload 9
    //   72: astore 8
    //   74: aload 9
    //   76: ldc 23
    //   78: aconst_null
    //   79: aload 10
    //   81: invokevirtual 139	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   84: pop2
    //   85: aload 9
    //   87: ifnull +16 -> 103
    //   90: aload 9
    //   92: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   95: ifeq +8 -> 103
    //   98: aload 9
    //   100: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   103: return
    //   104: astore 8
    //   106: aload 7
    //   108: astore 8
    //   110: ldc 27
    //   112: new 91	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   119: ldc 141
    //   121: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_3
    //   125: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 116
    //   130: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 4
    //   135: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 108	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload 7
    //   146: ifnull -43 -> 103
    //   149: aload 7
    //   151: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   154: ifeq -51 -> 103
    //   157: aload 7
    //   159: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   162: return
    //   163: astore_3
    //   164: aconst_null
    //   165: astore 8
    //   167: aload 8
    //   169: ifnull +16 -> 185
    //   172: aload 8
    //   174: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   177: ifeq +8 -> 185
    //   180: aload 8
    //   182: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   185: aload_3
    //   186: athrow
    //   187: astore_3
    //   188: goto -21 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	SessionDbHelper
    //   0	191	1	paramLong	long
    //   0	191	3	paramString1	String
    //   0	191	4	paramString2	String
    //   15	35	5	l	long
    //   1	157	7	localObject1	Object
    //   72	1	8	localSQLiteDatabase1	SQLiteDatabase
    //   104	1	8	localException	Exception
    //   108	73	8	localObject2	Object
    //   64	35	9	localSQLiteDatabase2	SQLiteDatabase
    //   10	70	10	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   57	66	104	java/lang/Exception
    //   74	85	104	java/lang/Exception
    //   57	66	163	finally
    //   74	85	187	finally
    //   110	144	187	finally
  }
  
  /* Error */
  public String query(long paramLong, String paramString)
  {
    // Byte code:
    //   0: lload_1
    //   1: invokestatic 70	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 60	com/tencent/upload/network/session/cache/SessionDbHelper:mOpenHelper	Lcom/tencent/upload/network/session/cache/SessionDbHelper$DatabaseHelper;
    //   10: invokevirtual 74	com/tencent/upload/network/session/cache/SessionDbHelper$DatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: astore 4
    //   15: aload 4
    //   17: ldc 23
    //   19: getstatic 44	com/tencent/upload/network/session/cache/SessionDbHelper:columns	[Ljava/lang/String;
    //   22: ldc 112
    //   24: iconst_2
    //   25: anewarray 40	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload 5
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: aload_3
    //   36: aastore
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 146	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore 5
    //   45: aload 5
    //   47: ifnull +227 -> 274
    //   50: aload 5
    //   52: invokeinterface 151 1 0
    //   57: ifeq +217 -> 274
    //   60: aload 5
    //   62: aload 5
    //   64: ldc 23
    //   66: invokeinterface 155 2 0
    //   71: invokeinterface 159 2 0
    //   76: astore_3
    //   77: aload 4
    //   79: ifnull +16 -> 95
    //   82: aload 4
    //   84: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   87: ifeq +8 -> 95
    //   90: aload 4
    //   92: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   95: aload 5
    //   97: ifnull +175 -> 272
    //   100: aload 5
    //   102: invokeinterface 162 1 0
    //   107: ifne +165 -> 272
    //   110: aload 5
    //   112: invokeinterface 163 1 0
    //   117: aload_3
    //   118: areturn
    //   119: astore_3
    //   120: aconst_null
    //   121: astore 4
    //   123: aconst_null
    //   124: astore 5
    //   126: ldc 27
    //   128: new 91	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   135: ldc 165
    //   137: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_3
    //   141: invokevirtual 101	java/lang/Exception:toString	()Ljava/lang/String;
    //   144: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 108	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload 4
    //   155: ifnull +16 -> 171
    //   158: aload 4
    //   160: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   163: ifeq +8 -> 171
    //   166: aload 4
    //   168: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   171: aload 5
    //   173: ifnull +97 -> 270
    //   176: aload 5
    //   178: invokeinterface 162 1 0
    //   183: ifne +87 -> 270
    //   186: aload 5
    //   188: invokeinterface 163 1 0
    //   193: aconst_null
    //   194: areturn
    //   195: astore_3
    //   196: aconst_null
    //   197: astore 4
    //   199: aconst_null
    //   200: astore 5
    //   202: aload 4
    //   204: ifnull +16 -> 220
    //   207: aload 4
    //   209: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   212: ifeq +8 -> 220
    //   215: aload 4
    //   217: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   220: aload 5
    //   222: ifnull +20 -> 242
    //   225: aload 5
    //   227: invokeinterface 162 1 0
    //   232: ifne +10 -> 242
    //   235: aload 5
    //   237: invokeinterface 163 1 0
    //   242: aload_3
    //   243: athrow
    //   244: astore_3
    //   245: aconst_null
    //   246: astore 5
    //   248: goto -46 -> 202
    //   251: astore_3
    //   252: goto -50 -> 202
    //   255: astore_3
    //   256: goto -54 -> 202
    //   259: astore_3
    //   260: aconst_null
    //   261: astore 5
    //   263: goto -137 -> 126
    //   266: astore_3
    //   267: goto -141 -> 126
    //   270: aconst_null
    //   271: areturn
    //   272: aload_3
    //   273: areturn
    //   274: aconst_null
    //   275: astore_3
    //   276: goto -199 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	SessionDbHelper
    //   0	279	1	paramLong	long
    //   0	279	3	paramString	String
    //   13	203	4	localSQLiteDatabase	SQLiteDatabase
    //   4	258	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	15	119	java/lang/Exception
    //   6	15	195	finally
    //   15	45	244	finally
    //   50	77	251	finally
    //   126	153	255	finally
    //   15	45	259	java/lang/Exception
    //   50	77	266	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.network.session.cache.SessionDbHelper
 * JD-Core Version:    0.7.0.1
 */