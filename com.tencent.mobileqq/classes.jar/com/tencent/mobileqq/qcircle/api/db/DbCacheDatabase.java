package com.tencent.mobileqq.qcircle.api.db;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.db.util.EncryptUtil;
import cooperation.qqcircle.QCircleConfig;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

public class DbCacheDatabase
  extends SQLiteOpenHelper
  implements Sessional
{
  public static final int DATABASE_VERSION = 117;
  private static boolean OPEN_WAL = true;
  public static final String TAG = "QCircleDbCacheDatabase";
  public static volatile boolean isOpenWal = false;
  private static HashMap<String, DbCacheDatabase> sInstanceMap = new HashMap();
  private int dbOptiSync = 1;
  private EncryptUtil encryptor;
  private int mAttachCount = 0;
  private boolean mAutoCloseNoAttach = true;
  private Context mContext = null;
  private volatile boolean mDatabaseUpdated = false;
  private String mDbName;
  private HashSet<Integer> mSeesionIds = new HashSet();
  
  @TargetApi(11)
  protected DbCacheDatabase(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt1, int paramInt2, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt1, paramDatabaseErrorHandler);
    this.mDbName = paramString;
    this.mContext = paramContext;
    this.dbOptiSync = paramInt2;
    this.encryptor = new EncryptUtil(getSQLiteDataBase(false));
    isOpenWal = QCircleConfig.getInstance().getConfigValue("QZoneSetting", "enablewal", Boolean.valueOf(OPEN_WAL)).booleanValue();
  }
  
  public static DbCacheDatabase getInstance(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      DbCacheDatabase localDbCacheDatabase2 = (DbCacheDatabase)sInstanceMap.get(paramString);
      DbCacheDatabase localDbCacheDatabase1 = localDbCacheDatabase2;
      if (localDbCacheDatabase2 == null)
      {
        localDbCacheDatabase1 = new DbCacheDatabase(paramContext, paramString, null, paramInt1, paramInt2, new DbCacheDatabase.1());
        sInstanceMap.put(paramString, localDbCacheDatabase1);
      }
      return localDbCacheDatabase1;
    }
    finally {}
  }
  
  private void handleException(Throwable paramThrowable)
  {
    try
    {
      DbCacheExceptionHandler.getInstance().handleException(paramThrowable, this.mDbName);
      return;
    }
    catch (Throwable paramThrowable)
    {
      RFLog.e("QCircleDbCacheDatabase", RFLog.USR, new Object[] { "handleException error", paramThrowable });
    }
  }
  
  public void attach(int paramInt)
  {
    try
    {
      if (this.mSeesionIds.add(Integer.valueOf(paramInt))) {
        this.mAttachCount += 1;
      }
      RFLog.i("QCircleDbCacheDatabase", RFLog.USR, "[DB]" + this.mDbName + "  attach sessionId:" + paramInt + "mAttachCount:" + this.mAttachCount);
      return;
    }
    finally {}
  }
  
  public void deleteDatabase()
  {
    this.mContext.deleteDatabase(this.mDbName);
    RFLog.e("QCircleDbCacheDatabase", RFLog.USR, new Object[] { Integer.valueOf(RFLog.USR), "detele db:", this.mDbName });
  }
  
  public void detach(int paramInt)
  {
    int j = 0;
    int i = j;
    try
    {
      if (this.mSeesionIds.remove(Integer.valueOf(paramInt)))
      {
        int k = this.mAttachCount - 1;
        this.mAttachCount = k;
        i = j;
        if (k == 0) {
          i = 1;
        }
      }
      RFLog.i("QCircleDbCacheDatabase", RFLog.USR, "[DB]" + this.mDbName + "  detach sessionId:" + paramInt + "mAttachCount:" + this.mAttachCount);
      if ((i != 0) && (this.mAutoCloseNoAttach))
      {
        RFLog.i("QCircleDbCacheDatabase", RFLog.USR, "[DB] close " + this.mDbName + ",mAttachCount:" + this.mAttachCount);
        close();
      }
      return;
    }
    finally {}
  }
  
  protected void finalize()
  {
    try
    {
      close();
      return;
    }
    catch (Exception localException)
    {
      RFLog.e("QCircleDbCacheDatabase", RFLog.USR, new Object[] { "close error", localException });
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public EncryptUtil getEncryptor()
  {
    return this.encryptor;
  }
  
  /* Error */
  public SQLiteDatabase getSQLiteDataBase(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: iload_1
    //   5: ifeq +70 -> 75
    //   8: aload_0
    //   9: invokevirtual 214	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore_3
    //   13: aload_3
    //   14: astore_2
    //   15: aload_2
    //   16: astore_3
    //   17: aload_0
    //   18: getfield 62	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:mDatabaseUpdated	Z
    //   21: ifeq +33 -> 54
    //   24: aload_2
    //   25: ifnull +7 -> 32
    //   28: aload_2
    //   29: invokevirtual 217	android/database/sqlite/SQLiteDatabase:close	()V
    //   32: aload_0
    //   33: invokevirtual 219	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:deleteDatabase	()V
    //   36: iload_1
    //   37: ifeq +48 -> 85
    //   40: aload_0
    //   41: invokevirtual 214	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 62	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:mDatabaseUpdated	Z
    //   52: aload_2
    //   53: astore_3
    //   54: aload_3
    //   55: ifnull +16 -> 71
    //   58: getstatic 38	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:isOpenWal	Z
    //   61: istore_1
    //   62: iload_1
    //   63: ifeq +8 -> 71
    //   66: aload_3
    //   67: invokevirtual 222	android/database/sqlite/SQLiteDatabase:enableWriteAheadLogging	()Z
    //   70: pop
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_3
    //   74: areturn
    //   75: aload_0
    //   76: invokevirtual 225	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   79: astore_3
    //   80: aload_3
    //   81: astore_2
    //   82: goto -67 -> 15
    //   85: aload_0
    //   86: invokevirtual 225	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   89: astore_3
    //   90: aload_3
    //   91: astore_2
    //   92: goto -45 -> 47
    //   95: astore_3
    //   96: aload_0
    //   97: aload_3
    //   98: invokespecial 227	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:handleException	(Ljava/lang/Throwable;)V
    //   101: goto -54 -> 47
    //   104: astore_2
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_2
    //   108: athrow
    //   109: astore_3
    //   110: aload_0
    //   111: invokevirtual 219	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:deleteDatabase	()V
    //   114: iload_1
    //   115: ifeq +29 -> 144
    //   118: aload_0
    //   119: invokevirtual 214	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   122: astore_3
    //   123: aload_3
    //   124: astore_2
    //   125: aload_2
    //   126: astore_3
    //   127: aload_0
    //   128: getfield 62	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:mDatabaseUpdated	Z
    //   131: ifeq -77 -> 54
    //   134: aload_0
    //   135: iconst_0
    //   136: putfield 62	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:mDatabaseUpdated	Z
    //   139: aload_2
    //   140: astore_3
    //   141: goto -87 -> 54
    //   144: aload_0
    //   145: invokevirtual 225	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   148: astore_3
    //   149: aload_3
    //   150: astore_2
    //   151: goto -26 -> 125
    //   154: astore_3
    //   155: aload_0
    //   156: aload_3
    //   157: invokespecial 227	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:handleException	(Ljava/lang/Throwable;)V
    //   160: goto -35 -> 125
    //   163: astore_3
    //   164: aload_0
    //   165: getfield 62	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:mDatabaseUpdated	Z
    //   168: ifeq +33 -> 201
    //   171: iconst_0
    //   172: ifeq +11 -> 183
    //   175: new 229	java/lang/NullPointerException
    //   178: dup
    //   179: invokespecial 230	java/lang/NullPointerException:<init>	()V
    //   182: athrow
    //   183: aload_0
    //   184: invokevirtual 219	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:deleteDatabase	()V
    //   187: iload_1
    //   188: ifeq +15 -> 203
    //   191: aload_0
    //   192: invokevirtual 214	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   195: pop
    //   196: aload_0
    //   197: iconst_0
    //   198: putfield 62	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:mDatabaseUpdated	Z
    //   201: aload_3
    //   202: athrow
    //   203: aload_0
    //   204: invokevirtual 225	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   207: pop
    //   208: goto -12 -> 196
    //   211: astore_2
    //   212: aload_0
    //   213: aload_2
    //   214: invokespecial 227	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:handleException	(Ljava/lang/Throwable;)V
    //   217: goto -21 -> 196
    //   220: astore_2
    //   221: iconst_0
    //   222: putstatic 38	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:isOpenWal	Z
    //   225: aload_0
    //   226: aload_2
    //   227: invokespecial 227	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:handleException	(Ljava/lang/Throwable;)V
    //   230: goto -159 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	DbCacheDatabase
    //   0	233	1	paramBoolean	boolean
    //   3	89	2	localObject1	Object
    //   104	4	2	localObject2	Object
    //   124	27	2	localObject3	Object
    //   211	3	2	localThrowable1	Throwable
    //   220	7	2	localThrowable2	Throwable
    //   12	79	3	localObject4	Object
    //   95	3	3	localThrowable3	Throwable
    //   109	1	3	localThrowable4	Throwable
    //   122	28	3	localObject5	Object
    //   154	3	3	localThrowable5	Throwable
    //   163	39	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   40	45	95	java/lang/Throwable
    //   85	90	95	java/lang/Throwable
    //   17	24	104	finally
    //   28	32	104	finally
    //   32	36	104	finally
    //   40	45	104	finally
    //   47	52	104	finally
    //   58	62	104	finally
    //   66	71	104	finally
    //   71	73	104	finally
    //   85	90	104	finally
    //   96	101	104	finally
    //   105	107	104	finally
    //   127	139	104	finally
    //   164	171	104	finally
    //   175	183	104	finally
    //   183	187	104	finally
    //   191	196	104	finally
    //   196	201	104	finally
    //   201	203	104	finally
    //   203	208	104	finally
    //   212	217	104	finally
    //   221	230	104	finally
    //   8	13	109	java/lang/Throwable
    //   75	80	109	java/lang/Throwable
    //   118	123	154	java/lang/Throwable
    //   144	149	154	java/lang/Throwable
    //   8	13	163	finally
    //   75	80	163	finally
    //   110	114	163	finally
    //   118	123	163	finally
    //   144	149	163	finally
    //   155	160	163	finally
    //   191	196	211	java/lang/Throwable
    //   203	208	211	java/lang/Throwable
    //   66	71	220	java/lang/Throwable
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    RFLog.i("QCircleDbCacheDatabase", RFLog.USR, "DbCacheDatabase onDowngrade oldVersion:" + paramInt1 + ",newVersion=" + paramInt2);
    this.mDatabaseUpdated = true;
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    if (RFLog.isColorLevel()) {
      RFLog.i("QCircleDbCacheDatabase", RFLog.CLR, "[DB]" + this.mDbName + " onOpen");
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = SQLiteDatabase.class.getDeclaredField("mConfigurationLocked");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(paramSQLiteDatabase);
        localObject2 = localObject1.getClass().getDeclaredField("maxSqlCacheSize");
        ((Field)localObject2).setAccessible(true);
        ((Field)localObject2).set(localObject1, Integer.valueOf(150));
        localObject2 = SQLiteDatabase.class.getDeclaredField("mConnectionPoolLocked");
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Field)localObject2).get(paramSQLiteDatabase);
        Method[] arrayOfMethod = localObject2.getClass().getDeclaredMethods();
        int j = arrayOfMethod.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        paramSQLiteDatabase = arrayOfMethod[i];
        if (!TextUtils.equals(paramSQLiteDatabase.getName(), "reconfigure")) {
          break label522;
        }
      }
      catch (NoSuchFieldException paramSQLiteDatabase)
      {
        Object localObject1;
        Object localObject2;
        paramSQLiteDatabase.printStackTrace();
        if (!RFLog.isColorLevel()) {
          break label521;
        }
        RFLog.w("QCircleDbCacheDatabase", RFLog.USR, "[DB]" + this.mDbName + "  onOpen" + paramSQLiteDatabase.getMessage());
        return;
      }
      catch (IllegalArgumentException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (!RFLog.isColorLevel()) {
          break label521;
        }
        RFLog.w("QCircleDbCacheDatabase", RFLog.USR, "[DB]" + this.mDbName + "  onOpen" + paramSQLiteDatabase.getMessage());
        return;
      }
      catch (IllegalAccessException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (!RFLog.isColorLevel()) {
          break label521;
        }
        RFLog.w("QCircleDbCacheDatabase", RFLog.USR, "[DB]" + this.mDbName + "  onOpen" + paramSQLiteDatabase.getMessage());
        return;
      }
      catch (InvocationTargetException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        if (!RFLog.isColorLevel()) {
          break label521;
        }
        RFLog.w("QCircleDbCacheDatabase", RFLog.USR, "[DB]" + this.mDbName + "  onOpen" + paramSQLiteDatabase.getMessage());
        return;
        paramSQLiteDatabase = null;
        continue;
      }
      if (paramSQLiteDatabase != null)
      {
        paramSQLiteDatabase.setAccessible(true);
        paramSQLiteDatabase.invoke(localObject2, new Object[] { localObject1 });
        if (RFLog.isColorLevel()) {
          RFLog.i("QCircleDbCacheDatabase", RFLog.CLR, "[DB]" + this.mDbName + " LRU MAX SIZE = " + localObject1.getClass().getDeclaredField("maxSqlCacheSize").getInt(localObject1));
        }
      }
      else if (RFLog.isColorLevel())
      {
        RFLog.i("QCircleDbCacheDatabase", RFLog.CLR, "[DB]" + this.mDbName + " not find reconfigure()");
        return;
      }
      label521:
      return;
      label522:
      i += 1;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    RFLog.i("QCircleDbCacheDatabase", RFLog.USR, "DbCacheDatabase onUpgrade oldVersion:" + paramInt1 + ",newVersion=" + paramInt2);
    this.mDatabaseUpdated = true;
  }
  
  public void setAutoCloseWhenNoAttach(boolean paramBoolean)
  {
    this.mAutoCloseNoAttach = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheDatabase
 * JD-Core Version:    0.7.0.1
 */