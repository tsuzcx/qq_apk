package com.tencent.mobileqq.qcircle.api.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qcircle.api.db.util.EncryptUtil;
import com.tencent.mobileqq.qcircle.api.db.util.SecurityUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.LocalMultiProcConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public abstract class AbstractDbCacheManager
{
  public static boolean a = false;
  public static boolean b = false;
  private static boolean e = false;
  protected IDBCacheDataWrapper.DbCreator c;
  protected String d;
  private long f;
  private int g;
  private boolean h;
  private boolean i = false;
  private volatile boolean j = false;
  private String k = null;
  private ArrayList<IDBCacheDataWrapper.Structure> l = new ArrayList();
  private DbCacheDatabase m;
  
  protected AbstractDbCacheManager(Context paramContext, Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    paramContext = paramContext.getApplicationContext();
    this.k = a(paramLong, paramInt1);
    this.m = DbCacheDatabase.a(paramContext, this.k, paramInt2, paramInt3);
    this.m.attach(hashCode());
    this.f = paramLong;
    this.g = paramInt1;
    this.d = paramString;
    a(paramClass);
    l();
  }
  
  private SQLiteDatabase a(boolean paramBoolean)
  {
    if (isClosed()) {
      return null;
    }
    return this.m.a(paramBoolean);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    if (paramInt == DbCacheService.a)
    {
      if (!TextUtils.isEmpty(QCircleHostStubUtil.getQQProcessName()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLong);
        localStringBuilder.append("_qcircle_");
        localStringBuilder.append(QCircleHostStubUtil.getQQProcessName());
        return SecurityUtil.a(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("_qcircle");
      return SecurityUtil.a(localStringBuilder.toString());
    }
    if ((paramInt == DbCacheService.b) && (paramLong == -1L)) {
      return SecurityUtil.a(String.valueOf(paramLong));
    }
    if (paramInt == DbCacheService.d) {
      return SecurityUtil.a(String.valueOf(-paramLong));
    }
    return SecurityUtil.a(String.valueOf(paramLong + paramInt));
  }
  
  static String a(long paramLong, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramLong));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null) {
      return;
    }
    if (DbCacheDatabase.a)
    {
      paramSQLiteDatabase.beginTransactionNonExclusive();
      return;
    }
    paramSQLiteDatabase.beginTransaction();
  }
  
  private void a(Class<? extends IDBCacheDataWrapper> paramClass)
  {
    String str = paramClass.getName();
    try
    {
      paramClass = (IDBCacheDataWrapper.DbCreator)paramClass.getField("DB_CREATOR").get(null);
    }
    catch (Throwable paramClass)
    {
      QLog.w("QCircleDbCacheDatabase.CacheManager", 1, paramClass.getMessage());
      paramClass = null;
    }
    if (paramClass == null) {
      return;
    }
    this.c = paramClass;
    paramClass = paramClass.structure();
    if (paramClass != null)
    {
      int i1 = paramClass.length;
      int n = 0;
      while (n < i1)
      {
        Object localObject = paramClass[n];
        if (localObject != null) {
          this.l.add(localObject);
        }
        n += 1;
      }
    }
    if (this.l.size() != 0) {
      return;
    }
    paramClass = new StringBuilder();
    paramClass.append("CacheData protocol requires a valid CacheData.Structure from CacheData.Creator object called  CREATOR on class ");
    paramClass.append(str);
    paramClass = new AbstractDbCacheManager.BadCacheDataException(paramClass.toString());
    for (;;)
    {
      throw paramClass;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, long paramLong)
  {
    if ((a) || (paramLong > 50L))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("db:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" table:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" selection:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" args:");
      localStringBuilder.append(Arrays.toString(paramArrayOfString));
      QLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test", 1, localStringBuilder.toString());
      paramString1 = new StringBuilder();
      paramString1.append("timecost: ");
      paramString1.append(paramLong);
      QLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test", 1, paramString1.toString());
    }
    if ((b) || (paramLong > 50L)) {
      QLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test_Stack", 1, Log.getStackTraceString(new Throwable()));
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramThrowable.getMessage());
    QLog.w("QCircleDbCacheDatabase.CacheManager", 1, localStringBuilder.toString());
    try
    {
      DbCacheExceptionHandler.a().a(paramThrowable, this.k);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.w("QCircleDbCacheDatabase.CacheManager", 1, paramString.getMessage());
    }
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 10
    //   6: iconst_0
    //   7: istore 7
    //   9: iconst_0
    //   10: istore 6
    //   12: iconst_0
    //   13: istore 5
    //   15: aload 10
    //   17: astore 8
    //   19: aload 11
    //   21: astore 9
    //   23: new 106	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   30: astore 12
    //   32: aload 10
    //   34: astore 8
    //   36: aload 11
    //   38: astore 9
    //   40: aload 12
    //   42: ldc_w 256
    //   45: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 10
    //   51: astore 8
    //   53: aload 11
    //   55: astore 9
    //   57: aload 12
    //   59: aload_2
    //   60: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 10
    //   66: astore 8
    //   68: aload 11
    //   70: astore 9
    //   72: aload 12
    //   74: ldc_w 258
    //   77: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 10
    //   83: astore 8
    //   85: aload 11
    //   87: astore 9
    //   89: aload_1
    //   90: aload 12
    //   92: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: aconst_null
    //   96: invokevirtual 262	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   99: astore_1
    //   100: iload 5
    //   102: istore 4
    //   104: aload_1
    //   105: ifnull +61 -> 166
    //   108: iload 5
    //   110: istore 4
    //   112: aload_1
    //   113: astore 8
    //   115: aload_1
    //   116: astore 9
    //   118: aload_1
    //   119: invokeinterface 267 1 0
    //   124: ifle +42 -> 166
    //   127: aload_1
    //   128: astore 8
    //   130: aload_1
    //   131: astore 9
    //   133: aload_1
    //   134: invokeinterface 270 1 0
    //   139: pop
    //   140: aload_1
    //   141: astore 8
    //   143: aload_1
    //   144: astore 9
    //   146: aload_1
    //   147: iconst_0
    //   148: invokeinterface 274 2 0
    //   153: istore_3
    //   154: iload 5
    //   156: istore 4
    //   158: iload_3
    //   159: iconst_1
    //   160: if_icmpne +6 -> 166
    //   163: iconst_1
    //   164: istore 4
    //   166: iload 4
    //   168: istore 5
    //   170: aload_1
    //   171: ifnull +73 -> 244
    //   174: iload 4
    //   176: istore 5
    //   178: aload_1
    //   179: invokeinterface 277 1 0
    //   184: iload 4
    //   186: ireturn
    //   187: astore_1
    //   188: ldc 178
    //   190: iconst_1
    //   191: ldc_w 279
    //   194: aload_1
    //   195: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   198: iload 5
    //   200: ireturn
    //   201: astore_1
    //   202: goto +45 -> 247
    //   205: astore_1
    //   206: aload 9
    //   208: astore 8
    //   210: ldc 178
    //   212: iconst_1
    //   213: ldc_w 279
    //   216: aload_1
    //   217: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   220: iload 6
    //   222: istore 5
    //   224: aload 9
    //   226: ifnull +18 -> 244
    //   229: iload 7
    //   231: istore 5
    //   233: aload 9
    //   235: invokeinterface 277 1 0
    //   240: iload 6
    //   242: istore 5
    //   244: iload 5
    //   246: ireturn
    //   247: aload 8
    //   249: ifnull +24 -> 273
    //   252: aload 8
    //   254: invokeinterface 277 1 0
    //   259: goto +14 -> 273
    //   262: astore_2
    //   263: ldc 178
    //   265: iconst_1
    //   266: ldc_w 279
    //   269: aload_2
    //   270: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   273: aload_1
    //   274: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	AbstractDbCacheManager
    //   0	275	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	275	2	paramString	String
    //   153	8	3	n	int
    //   102	83	4	bool1	boolean
    //   13	232	5	bool2	boolean
    //   10	231	6	bool3	boolean
    //   7	223	7	bool4	boolean
    //   17	236	8	localObject1	Object
    //   21	213	9	localObject2	Object
    //   4	78	10	localObject3	Object
    //   1	85	11	localObject4	Object
    //   30	61	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   178	184	187	java/lang/Exception
    //   233	240	187	java/lang/Exception
    //   23	32	201	finally
    //   40	49	201	finally
    //   57	64	201	finally
    //   72	81	201	finally
    //   89	100	201	finally
    //   118	127	201	finally
    //   133	140	201	finally
    //   146	154	201	finally
    //   210	220	201	finally
    //   23	32	205	java/lang/Exception
    //   40	49	205	java/lang/Exception
    //   57	64	205	java/lang/Exception
    //   72	81	205	java/lang/Exception
    //   89	100	205	java/lang/Exception
    //   118	127	205	java/lang/Exception
    //   133	140	205	java/lang/Exception
    //   146	154	205	java/lang/Exception
    //   252	259	262	java/lang/Exception
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 285	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   4: aload_2
    //   5: arraylength
    //   6: istore 4
    //   8: iconst_0
    //   9: istore_3
    //   10: iload_3
    //   11: iload 4
    //   13: if_icmpge +78 -> 91
    //   16: aload_2
    //   17: iload_3
    //   18: aaload
    //   19: astore 5
    //   21: aload 5
    //   23: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +59 -> 85
    //   29: aload_1
    //   30: aload 5
    //   32: invokevirtual 288	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   35: invokestatic 291	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   38: ifeq +40 -> 78
    //   41: new 106	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   48: astore 6
    //   50: aload 6
    //   52: ldc_w 293
    //   55: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 6
    //   61: aload 5
    //   63: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: ldc 178
    //   69: iconst_1
    //   70: aload 6
    //   72: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 187	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iload_3
    //   79: iconst_1
    //   80: iadd
    //   81: istore_3
    //   82: goto -72 -> 10
    //   85: aload_1
    //   86: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   89: iconst_0
    //   90: ireturn
    //   91: aload_1
    //   92: invokevirtual 299	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   95: aload_1
    //   96: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   99: iconst_1
    //   100: ireturn
    //   101: astore_2
    //   102: goto +20 -> 122
    //   105: astore_2
    //   106: ldc 178
    //   108: iconst_1
    //   109: ldc_w 301
    //   112: aload_2
    //   113: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   116: aload_1
    //   117: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   120: iconst_0
    //   121: ireturn
    //   122: aload_1
    //   123: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   126: goto +5 -> 131
    //   129: aload_2
    //   130: athrow
    //   131: goto -2 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	AbstractDbCacheManager
    //   0	134	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	134	2	paramArrayOfString	String[]
    //   9	73	3	n	int
    //   6	8	4	i1	int
    //   19	43	5	str	String
    //   48	23	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	8	101	finally
    //   21	78	101	finally
    //   91	95	101	finally
    //   106	116	101	finally
    //   0	8	105	java/lang/Exception
    //   21	78	105	java/lang/Exception
    //   91	95	105	java/lang/Exception
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null)
    {
      QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "db is null,create table fail.");
      return;
    }
    if (!this.h) {
      try
      {
        Object localObject = i();
        boolean bool = QLog.isColorLevel();
        StringBuilder localStringBuilder1;
        if (bool)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("create table sql:");
          localStringBuilder1.append((String)localObject);
          QLog.d("QCircleDbCacheDatabase.CacheManager", 2, localStringBuilder1.toString());
        }
        if (a)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("create table sql:");
          localStringBuilder1.append((String)localObject);
          QLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test", 2, localStringBuilder1.toString());
        }
        paramSQLiteDatabase.execSQL((String)localObject);
        localObject = j();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(";");
          int i1 = localObject.length;
          int n = 0;
          while (n < i1)
          {
            localStringBuilder1 = localObject[n];
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("create index sql:");
              localStringBuilder2.append(localStringBuilder1);
              QLog.d("QCircleDbCacheDatabase.CacheManager", 2, localStringBuilder2.toString());
            }
            paramSQLiteDatabase.execSQL(localStringBuilder1);
            n += 1;
          }
        }
        this.h = true;
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "createTableIfNeeded error", paramSQLiteDatabase);
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "createTableIfNeeded error", paramSQLiteDatabase);
      }
    }
  }
  
  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    String str = k();
    paramSQLiteDatabase.execSQL(str);
    this.h = false;
    if (QLog.isColorLevel())
    {
      paramSQLiteDatabase = new StringBuilder();
      paramSQLiteDatabase.append("deleteTable sql:");
      paramSQLiteDatabase.append(str);
      QLog.i("QCircleDbCacheDatabase.CacheManager", 2, paramSQLiteDatabase.toString());
    }
  }
  
  private void d(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("_temp");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ALTER TABLE ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" RENAME TO ");
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    paramSQLiteDatabase.execSQL((String)localObject);
    this.h = false;
    if (QLog.isColorLevel())
    {
      paramSQLiteDatabase = new StringBuilder();
      paramSQLiteDatabase.append("remaneTable sql:");
      paramSQLiteDatabase.append((String)localObject);
      QLog.w("QCircleDbCacheDatabase.CacheManager", 1, paramSQLiteDatabase.toString());
    }
  }
  
  private void e(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("_temp");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DROP TABLE IF EXISTS ");
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    paramSQLiteDatabase.execSQL((String)localObject);
    if (QLog.isColorLevel())
    {
      paramSQLiteDatabase = new StringBuilder();
      paramSQLiteDatabase.append("dropTable sql:");
      paramSQLiteDatabase.append((String)localObject);
      QLog.w("QCircleDbCacheDatabase.CacheManager", 1, paramSQLiteDatabase.toString());
    }
  }
  
  private void g()
  {
    if (isClosed()) {
      return;
    }
    try
    {
      if (isClosed()) {
        return;
      }
      this.m.detach(hashCode());
      this.i = true;
      return;
    }
    finally {}
  }
  
  private void h()
  {
    e();
  }
  
  private String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CREATE TABLE IF NOT EXISTS ");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(" (");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append("_id INTEGER PRIMARY KEY");
    localObject = this.l.iterator();
    while (((Iterator)localObject).hasNext())
    {
      IDBCacheDataWrapper.Structure localStructure = (IDBCacheDataWrapper.Structure)((Iterator)localObject).next();
      localStringBuilder.append(',');
      localStringBuilder.append(localStructure.mName);
      localStringBuilder.append(' ');
      localStringBuilder.append(localStructure.mType);
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  private String j()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (!(localObject instanceof IDBCacheDataWrapper.RawDbCreator)) {
        return null;
      }
      try
      {
        localObject = ((IDBCacheDataWrapper.RawDbCreator)localObject).indexRawSql(this.d);
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.w("QCircleDbCacheDatabase.CacheManager", 1, localException.getMessage());
      }
    }
    return null;
  }
  
  private String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DROP TABLE IF EXISTS ");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
  
  private void l()
  {
    if (!f()) {
      return;
    }
    int i2 = this.c.version();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.k);
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append("_cache_db_version");
    int i1 = LocalMultiProcConfig.getInt4Uin(((StringBuilder)localObject1).toString(), -1, this.f);
    int n = i1;
    if (i1 == -1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append("_cache_db_version");
      n = LocalMultiProcConfig.getInt4Uin(((StringBuilder)localObject1).toString(), -1, this.f);
    }
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1) {
      QLog.e("QCircleDbCacheDatabase.CacheManager", 1, new Object[] { "mDbName:", this.k, " mTable:", this.d, " preVersion:", Integer.valueOf(n), " version:", Integer.valueOf(i2) });
    }
    localObject1 = a(true);
    if (localObject1 == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject2;
        if (a((SQLiteDatabase)localObject1, this.d))
        {
          if ((n == -1) || (n == i2) || (!(this.c instanceof IDBCacheDataWrapper.UpdateDbCreator))) {
            break label773;
          }
          localObject2 = ((IDBCacheDataWrapper.UpdateDbCreator)this.c).onUpdate(n, i2);
          bool1 = bool2;
          Object localObject3;
          if (localObject2 != null)
          {
            bool1 = bool2;
            if (localObject2.length > 0)
            {
              localObject3 = localObject2[0];
              bool1 = bool2;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                if ((!((String)localObject3).startsWith("ALTER")) && (!((String)localObject3).startsWith("DELETE")))
                {
                  if (((String)localObject3).startsWith("INSERT"))
                  {
                    d((SQLiteDatabase)localObject1);
                    b((SQLiteDatabase)localObject1);
                    bool1 = a((SQLiteDatabase)localObject1, (String[])localObject2);
                    e((SQLiteDatabase)localObject1);
                  }
                  else
                  {
                    bool1 = bool2;
                    if (((String)localObject3).startsWith("NOTHING")) {
                      bool1 = true;
                    }
                  }
                }
                else {
                  bool1 = a((SQLiteDatabase)localObject1, (String[])localObject2);
                }
              }
            }
          }
          if (bool1)
          {
            this.h = true;
          }
          else
          {
            c((SQLiteDatabase)localObject1);
            continue;
            c((SQLiteDatabase)localObject1);
          }
          b((SQLiteDatabase)localObject1);
          long l1 = System.currentTimeMillis();
          if ((this.c instanceof IDBCacheDataWrapper.UpdateDbCreator))
          {
            bool1 = ((IDBCacheDataWrapper.UpdateDbCreator)this.c).needEncrypt(n, i2);
            if (bool1)
            {
              localObject2 = b();
              a((ArrayList)localObject2);
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("encrypt success mTableName:");
                ((StringBuilder)localObject3).append(this.d);
                ((StringBuilder)localObject3).append(" datasize:");
                ((StringBuilder)localObject3).append(((ArrayList)localObject2).size());
                ((StringBuilder)localObject3).append(" timecost:");
                ((StringBuilder)localObject3).append(System.currentTimeMillis() - l1);
                QLog.i("QCircleDbCacheDatabase.CacheManager", 1, ((StringBuilder)localObject3).toString());
              }
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("encrypt success mTableName:");
              ((StringBuilder)localObject2).append(this.d);
              QLog.i("QCircleDbCacheDatabase.CacheManager", 1, ((StringBuilder)localObject2).toString());
            }
          }
        }
        else
        {
          b((SQLiteDatabase)localObject1);
        }
        if (n != i2)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.k);
          ((StringBuilder)localObject2).append(this.d);
          ((StringBuilder)localObject2).append("_cache_db_version");
          LocalMultiProcConfig.putInt4Uin(((StringBuilder)localObject2).toString(), i2, this.f);
          return;
        }
      }
      catch (Exception localException2)
      {
        QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "updateOrCreateTable error", localException2);
        try
        {
          c((SQLiteDatabase)localObject1);
          e((SQLiteDatabase)localObject1);
          b((SQLiteDatabase)localObject1);
          if (n != i2)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.k);
            ((StringBuilder)localObject1).append(this.d);
            ((StringBuilder)localObject1).append("_cache_db_version");
            LocalMultiProcConfig.putInt4Uin(((StringBuilder)localObject1).toString(), i2, this.f);
            return;
          }
        }
        catch (Exception localException1)
        {
          QLog.e("QCircleDbCacheDatabase.CacheManager", 1, "updateOrCreateTable error", localException1);
        }
      }
      return;
      label773:
      if (n != -1) {
        if (n == i2) {}
      }
    }
  }
  
  /* Error */
  protected int a(ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 86	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:isClosed	()Z
    //   4: istore 7
    //   6: iconst_0
    //   7: istore 5
    //   9: iload 7
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_1
    //   17: ifnonnull +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: iconst_1
    //   24: invokespecial 414	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore 8
    //   29: aload 8
    //   31: ifnonnull +5 -> 36
    //   34: iconst_0
    //   35: ireturn
    //   36: iload 5
    //   38: istore 4
    //   40: invokestatic 478	com/tencent/mobileqq/app/SQLiteDatabase:beginTransactionLog	()V
    //   43: iload 5
    //   45: istore 4
    //   47: aload 8
    //   49: invokestatic 285	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   52: iload 5
    //   54: istore 4
    //   56: aload_0
    //   57: aload 8
    //   59: aload_1
    //   60: aload_2
    //   61: aload_3
    //   62: invokevirtual 481	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   65: istore 5
    //   67: iload 5
    //   69: istore 4
    //   71: aload 8
    //   73: invokevirtual 299	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   76: iload 5
    //   78: istore 6
    //   80: aload 8
    //   82: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   85: iload 5
    //   87: istore 6
    //   89: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   92: iload 5
    //   94: istore 4
    //   96: goto +48 -> 144
    //   99: astore_1
    //   100: aload_0
    //   101: ldc_w 486
    //   104: aload_1
    //   105: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: iload 6
    //   110: istore 4
    //   112: goto +32 -> 144
    //   115: astore_1
    //   116: goto +110 -> 226
    //   119: astore_1
    //   120: aload_0
    //   121: ldc_w 490
    //   124: aload_1
    //   125: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: iload 4
    //   130: istore 6
    //   132: aload 8
    //   134: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   137: iload 4
    //   139: istore 6
    //   141: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   144: getstatic 492	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:e	Z
    //   147: ifeq +67 -> 214
    //   150: new 106	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   157: astore_1
    //   158: aload_1
    //   159: ldc_w 494
    //   162: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_1
    //   167: aload_0
    //   168: getfield 74	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:d	Ljava/lang/String;
    //   171: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_1
    //   176: ldc_w 496
    //   179: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_1
    //   184: iload 4
    //   186: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_1
    //   191: ldc_w 498
    //   194: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_1
    //   199: aload_2
    //   200: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: ldc 178
    //   206: iconst_4
    //   207: aload_1
    //   208: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 315	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: iload 4
    //   216: ifle +7 -> 223
    //   219: aload_0
    //   220: invokespecial 500	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:h	()V
    //   223: iload 4
    //   225: ireturn
    //   226: aload 8
    //   228: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   231: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   234: goto +12 -> 246
    //   237: astore_2
    //   238: aload_0
    //   239: ldc_w 486
    //   242: aload_2
    //   243: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: aload_1
    //   247: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	AbstractDbCacheManager
    //   0	248	1	paramContentValues	ContentValues
    //   0	248	2	paramString	String
    //   0	248	3	paramArrayOfString	String[]
    //   38	186	4	n	int
    //   7	86	5	i1	int
    //   78	62	6	i2	int
    //   4	6	7	bool	boolean
    //   27	200	8	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   80	85	99	java/lang/Throwable
    //   89	92	99	java/lang/Throwable
    //   132	137	99	java/lang/Throwable
    //   141	144	99	java/lang/Throwable
    //   40	43	115	finally
    //   47	52	115	finally
    //   56	67	115	finally
    //   71	76	115	finally
    //   120	128	115	finally
    //   40	43	119	java/lang/Throwable
    //   47	52	119	java/lang/Throwable
    //   56	67	119	java/lang/Throwable
    //   71	76	119	java/lang/Throwable
    //   226	234	237	java/lang/Throwable
  }
  
  final int a(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (paramContentValues == null) {
      return 0;
    }
    long l1 = System.currentTimeMillis();
    this.m.a().a(this.k, this.d, paramString, paramArrayOfString);
    a(this.k, this.d, paramString, paramArrayOfString, System.currentTimeMillis() - l1);
    return paramSQLiteDatabase.update(this.d, this.m.a().a(this.k, this.d, paramContentValues), paramString, paramArrayOfString);
  }
  
  public int a(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    IDBCacheDataWrapper.DbCreator localDbCreator = this.c;
    if (((localDbCreator instanceof IDBCacheDataWrapper.RawDbCreator)) && (paramArrayOfString == null)) {
      return ((IDBCacheDataWrapper.RawDbCreator)localDbCreator).delRawSql(paramSQLiteDatabase, this.d, paramString);
    }
    this.m.a().a(this.k, this.d, paramString, paramArrayOfString);
    long l1 = System.currentTimeMillis();
    int n = paramSQLiteDatabase.delete(this.d, paramString, paramArrayOfString);
    a(this.k, this.d, paramString, paramArrayOfString, System.currentTimeMillis() - l1);
    return n;
  }
  
  protected int a(IDBCacheDataWrapper paramIDBCacheDataWrapper, String paramString, String[] paramArrayOfString)
  {
    if (paramIDBCacheDataWrapper == null) {
      return 0;
    }
    ContentValues localContentValues = new ContentValues();
    paramIDBCacheDataWrapper.writeTo(localContentValues);
    return a(localContentValues, paramString, paramArrayOfString);
  }
  
  public int a(String paramString, String[] paramArrayOfString)
  {
    boolean bool = isClosed();
    int n = 0;
    if (bool) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = a(true);
    if (localSQLiteDatabase == null) {
      return 0;
    }
    try
    {
      int i1 = a(localSQLiteDatabase, paramString, paramArrayOfString);
      n = i1;
    }
    catch (Throwable paramArrayOfString)
    {
      a("fail to delete data", paramArrayOfString);
    }
    if (e)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("delete--table:");
      paramArrayOfString.append(this.d);
      paramArrayOfString.append(",deleted:");
      paramArrayOfString.append(n);
      paramArrayOfString.append(",where:");
      paramArrayOfString.append(paramString);
      QLog.d("QCircleDbCacheDatabase.CacheManager", 4, paramArrayOfString.toString());
    }
    h();
    return n;
  }
  
  /* Error */
  public int a(ArrayList<ContentValues> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 86	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:isClosed	()Z
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 4
    //   9: iload 5
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_1
    //   17: ifnull +250 -> 267
    //   20: aload_1
    //   21: invokevirtual 200	java/util/ArrayList:size	()I
    //   24: ifne +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: iconst_1
    //   31: invokespecial 414	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   34: astore 6
    //   36: aload 6
    //   38: ifnonnull +5 -> 43
    //   41: iconst_0
    //   42: ireturn
    //   43: invokestatic 478	com/tencent/mobileqq/app/SQLiteDatabase:beginTransactionLog	()V
    //   46: aload 6
    //   48: invokestatic 285	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   51: iconst_0
    //   52: istore_3
    //   53: iconst_0
    //   54: istore_2
    //   55: iload_3
    //   56: aload_1
    //   57: invokevirtual 200	java/util/ArrayList:size	()I
    //   60: if_icmpge +51 -> 111
    //   63: iload_2
    //   64: aload_0
    //   65: aload 6
    //   67: aload_1
    //   68: iload_3
    //   69: invokevirtual 550	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   72: checkcast 529	android/content/ContentValues
    //   75: ldc_w 552
    //   78: iconst_1
    //   79: anewarray 132	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: aload_1
    //   85: iload_3
    //   86: invokevirtual 550	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   89: checkcast 529	android/content/ContentValues
    //   92: ldc_w 554
    //   95: invokevirtual 557	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: aastore
    //   99: invokevirtual 481	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   102: iadd
    //   103: istore_2
    //   104: iload_3
    //   105: iconst_1
    //   106: iadd
    //   107: istore_3
    //   108: goto -53 -> 55
    //   111: aload 6
    //   113: invokevirtual 299	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   116: aload 6
    //   118: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   121: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   124: goto +12 -> 136
    //   127: astore_1
    //   128: aload_0
    //   129: ldc_w 486
    //   132: aload_1
    //   133: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: goto +42 -> 178
    //   139: astore_1
    //   140: goto +103 -> 243
    //   143: astore_1
    //   144: aload_0
    //   145: ldc_w 490
    //   148: aload_1
    //   149: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   152: aload 6
    //   154: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   157: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   160: iload 4
    //   162: istore_2
    //   163: goto +15 -> 178
    //   166: astore_1
    //   167: aload_0
    //   168: ldc_w 486
    //   171: aload_1
    //   172: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   175: iload 4
    //   177: istore_2
    //   178: getstatic 492	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:e	Z
    //   181: ifeq +60 -> 241
    //   184: new 106	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   191: astore_1
    //   192: aload_1
    //   193: ldc_w 494
    //   196: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_1
    //   201: aload_0
    //   202: getfield 74	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:d	Ljava/lang/String;
    //   205: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_1
    //   210: ldc_w 496
    //   213: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_1
    //   218: iload_2
    //   219: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_1
    //   224: ldc_w 498
    //   227: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: ldc 178
    //   233: iconst_4
    //   234: aload_1
    //   235: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 315	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: iload_2
    //   242: ireturn
    //   243: aload 6
    //   245: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   248: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   251: goto +14 -> 265
    //   254: astore 6
    //   256: aload_0
    //   257: ldc_w 486
    //   260: aload 6
    //   262: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   265: aload_1
    //   266: athrow
    //   267: iconst_0
    //   268: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	AbstractDbCacheManager
    //   0	269	1	paramArrayList	ArrayList<ContentValues>
    //   54	188	2	n	int
    //   52	56	3	i1	int
    //   7	169	4	i2	int
    //   4	6	5	bool	boolean
    //   34	210	6	localSQLiteDatabase	SQLiteDatabase
    //   254	7	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   116	124	127	java/lang/Throwable
    //   43	51	139	finally
    //   55	104	139	finally
    //   111	116	139	finally
    //   144	152	139	finally
    //   43	51	143	java/lang/Throwable
    //   55	104	143	java/lang/Throwable
    //   111	116	143	java/lang/Throwable
    //   152	160	166	java/lang/Throwable
    //   243	251	254	java/lang/Throwable
  }
  
  final long a(SQLiteDatabase paramSQLiteDatabase, IDBCacheDataWrapper paramIDBCacheDataWrapper)
  {
    ContentValues localContentValues = new ContentValues();
    paramIDBCacheDataWrapper.writeTo(localContentValues);
    return paramSQLiteDatabase.replaceOrThrow(this.d, null, this.m.a().a(this.k, this.d, localContentValues));
  }
  
  protected Cursor a(String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, String paramString4)
  {
    if (paramString1 != null)
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramString1;
      paramString1 = arrayOfString;
    }
    else
    {
      paramString1 = null;
    }
    return a(paramString1, paramString2, paramArrayOfString, paramString3, paramString4);
  }
  
  protected Cursor a(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3)
  {
    return a(null, paramString1, paramArrayOfString, paramString2, paramString3);
  }
  
  /* Error */
  protected Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 86	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: iconst_0
    //   11: invokespecial 414	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 11
    //   16: aload 11
    //   18: ifnonnull +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: invokestatic 291	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +114 -> 140
    //   29: new 106	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   36: astore 10
    //   38: aload 10
    //   40: ldc_w 572
    //   43: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 10
    //   49: aload_0
    //   50: getfield 74	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:d	Ljava/lang/String;
    //   53: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 10
    //   59: ldc_w 574
    //   62: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 10
    //   68: aload_2
    //   69: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 10
    //   75: ldc_w 576
    //   78: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 10
    //   84: aload 4
    //   86: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 10
    //   92: ldc_w 578
    //   95: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 10
    //   101: aload 5
    //   103: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 10
    //   109: ldc_w 580
    //   112: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 10
    //   118: aload_3
    //   119: invokestatic 225	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   122: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: ldc 178
    //   128: iconst_2
    //   129: aload 10
    //   131: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 315	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: goto +3 -> 140
    //   140: aload 4
    //   142: astore 10
    //   144: aload 4
    //   146: ifnonnull +25 -> 171
    //   149: aload 4
    //   151: astore 10
    //   153: aload_0
    //   154: invokevirtual 386	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:f	()Z
    //   157: ifeq +14 -> 171
    //   160: aload_0
    //   161: getfield 189	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:c	Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper$DbCreator;
    //   164: invokeinterface 583 1 0
    //   169: astore 10
    //   171: aload_0
    //   172: getfield 60	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:m	Lcom/tencent/mobileqq/qcircle/api/db/DbCacheDatabase;
    //   175: invokevirtual 503	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:a	()Lcom/tencent/mobileqq/qcircle/api/db/util/EncryptUtil;
    //   178: aload_0
    //   179: getfield 39	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:k	Ljava/lang/String;
    //   182: aload_0
    //   183: getfield 74	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:d	Ljava/lang/String;
    //   186: aload_2
    //   187: aload_3
    //   188: invokevirtual 508	com/tencent/mobileqq/qcircle/api/db/util/EncryptUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   191: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   194: lstore 6
    //   196: aload 11
    //   198: aload_0
    //   199: getfield 74	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:d	Ljava/lang/String;
    //   202: aload_1
    //   203: aload_2
    //   204: aload_3
    //   205: aconst_null
    //   206: aconst_null
    //   207: aload 10
    //   209: aload 5
    //   211: invokevirtual 587	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   214: astore 4
    //   216: aload_0
    //   217: getfield 39	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:k	Ljava/lang/String;
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 74	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:d	Ljava/lang/String;
    //   225: astore 5
    //   227: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   230: lstore 8
    //   232: aload_0
    //   233: aload_1
    //   234: aload 5
    //   236: aload_2
    //   237: aload_3
    //   238: lload 8
    //   240: lload 6
    //   242: lsub
    //   243: invokespecial 510	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;J)V
    //   246: aload 4
    //   248: astore_3
    //   249: goto +55 -> 304
    //   252: astore_1
    //   253: aload 4
    //   255: astore_3
    //   256: goto +13 -> 269
    //   259: astore_1
    //   260: aload 4
    //   262: astore_3
    //   263: goto +6 -> 269
    //   266: astore_1
    //   267: aconst_null
    //   268: astore_3
    //   269: new 106	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   276: astore 4
    //   278: aload 4
    //   280: ldc_w 589
    //   283: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 4
    //   289: aload_2
    //   290: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_0
    //   295: aload 4
    //   297: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: aload_1
    //   301: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   304: aload_3
    //   305: ifnull +16 -> 321
    //   308: new 591	com/tencent/mobileqq/qcircle/api/db/DbSafeCursorWrapper
    //   311: dup
    //   312: aload_3
    //   313: aload_0
    //   314: getfield 39	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:k	Ljava/lang/String;
    //   317: invokespecial 594	com/tencent/mobileqq/qcircle/api/db/DbSafeCursorWrapper:<init>	(Landroid/database/Cursor;Ljava/lang/String;)V
    //   320: areturn
    //   321: aconst_null
    //   322: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	AbstractDbCacheManager
    //   0	323	1	paramArrayOfString1	String[]
    //   0	323	2	paramString1	String
    //   0	323	3	paramArrayOfString2	String[]
    //   0	323	4	paramString2	String
    //   0	323	5	paramString3	String
    //   194	47	6	l1	long
    //   230	9	8	l2	long
    //   36	172	10	localObject	Object
    //   14	183	11	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   232	246	252	java/lang/Throwable
    //   216	232	259	java/lang/Throwable
    //   153	171	266	java/lang/Throwable
    //   171	216	266	java/lang/Throwable
  }
  
  protected IDBCacheDataWrapper a(Cursor paramCursor, int paramInt)
  {
    if (paramCursor != null)
    {
      if (paramCursor.isClosed()) {
        return null;
      }
      if (paramInt >= 0)
      {
        if (paramInt >= paramCursor.getCount()) {
          return null;
        }
        if (!paramCursor.moveToPosition(paramInt)) {
          return null;
        }
        if (!f()) {
          return null;
        }
        Object localObject = paramCursor;
        if (!(paramCursor instanceof DbSafeCursorWrapper)) {
          localObject = new DbSafeCursorWrapper(paramCursor, this.k);
        }
        try
        {
          paramCursor = this.c.createFromCursor((Cursor)localObject);
          return paramCursor;
        }
        catch (Throwable paramCursor)
        {
          QLog.w("QCircleDbCacheDatabase.CacheManager", 1, paramCursor.getMessage());
          return null;
        }
        catch (OutOfMemoryError paramCursor)
        {
          if (!this.j)
          {
            this.j = true;
            localObject = a(true);
            if (localObject != null) {
              try
              {
                c((SQLiteDatabase)localObject);
                b((SQLiteDatabase)localObject);
              }
              catch (Exception localException)
              {
                QLog.w("QCircleDbCacheDatabase.CacheManager", 1, localException.getMessage());
              }
            }
            QLog.w("QCircleDbCacheDatabase.CacheManager", 1, paramCursor.getMessage());
          }
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    return this.k;
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString, String[] paramArrayOfString)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      a(paramSQLiteDatabase, paramString, paramArrayOfString);
    }
  }
  
  /* Error */
  protected boolean a(int paramInt, String paramString, String[] paramArrayOfString, java.util.Collection<? extends IDBCacheDataWrapper> paramCollection)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 86	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload 4
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: iconst_1
    //   18: invokespecial 414	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore 7
    //   23: aload 7
    //   25: ifnonnull +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: getstatic 492	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:e	Z
    //   33: ifeq +74 -> 107
    //   36: new 106	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   43: astore 8
    //   45: aload 8
    //   47: ldc_w 611
    //   50: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 8
    //   56: aload_0
    //   57: getfield 74	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:d	Ljava/lang/String;
    //   60: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 8
    //   66: ldc_w 613
    //   69: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 8
    //   75: iload_1
    //   76: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 8
    //   82: ldc_w 498
    //   85: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 8
    //   91: aload_2
    //   92: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 178
    //   98: iconst_4
    //   99: aload 8
    //   101: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 315	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: invokestatic 478	com/tencent/mobileqq/app/SQLiteDatabase:beginTransactionLog	()V
    //   110: aload 7
    //   112: invokestatic 285	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   115: aload_0
    //   116: aload 7
    //   118: iload_1
    //   119: aload_2
    //   120: aload_3
    //   121: invokevirtual 615	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;ILjava/lang/String;[Ljava/lang/String;)V
    //   124: aload 4
    //   126: invokeinterface 618 1 0
    //   131: astore_2
    //   132: aload_2
    //   133: invokeinterface 363 1 0
    //   138: ifeq +59 -> 197
    //   141: aload_2
    //   142: invokeinterface 367 1 0
    //   147: checkcast 532	com/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper
    //   150: astore_3
    //   151: aload_3
    //   152: ifnonnull +6 -> 158
    //   155: goto -23 -> 132
    //   158: aload_0
    //   159: aload 7
    //   161: aload_3
    //   162: invokevirtual 620	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper;)J
    //   165: lstore 5
    //   167: lload 5
    //   169: ldc2_w 129
    //   172: lcmp
    //   173: ifne -41 -> 132
    //   176: aload 7
    //   178: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   181: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   184: iconst_0
    //   185: ireturn
    //   186: astore_2
    //   187: aload_0
    //   188: ldc_w 486
    //   191: aload_2
    //   192: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   195: iconst_0
    //   196: ireturn
    //   197: aload 7
    //   199: invokevirtual 299	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   202: aload 7
    //   204: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   207: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   210: goto +12 -> 222
    //   213: astore_2
    //   214: aload_0
    //   215: ldc_w 486
    //   218: aload_2
    //   219: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload_0
    //   223: invokespecial 500	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:h	()V
    //   226: iconst_1
    //   227: ireturn
    //   228: astore_2
    //   229: goto +33 -> 262
    //   232: astore_2
    //   233: aload_0
    //   234: ldc_w 622
    //   237: aload_2
    //   238: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload 7
    //   243: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   246: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   249: iconst_0
    //   250: ireturn
    //   251: astore_2
    //   252: aload_0
    //   253: ldc_w 486
    //   256: aload_2
    //   257: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: iconst_0
    //   261: ireturn
    //   262: aload 7
    //   264: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   267: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   270: goto +12 -> 282
    //   273: astore_3
    //   274: aload_0
    //   275: ldc_w 486
    //   278: aload_3
    //   279: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   282: goto +5 -> 287
    //   285: aload_2
    //   286: athrow
    //   287: goto -2 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	AbstractDbCacheManager
    //   0	290	1	paramInt	int
    //   0	290	2	paramString	String
    //   0	290	3	paramArrayOfString	String[]
    //   0	290	4	paramCollection	java.util.Collection<? extends IDBCacheDataWrapper>
    //   165	3	5	l1	long
    //   21	242	7	localSQLiteDatabase	SQLiteDatabase
    //   43	57	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   176	184	186	java/lang/Throwable
    //   202	210	213	java/lang/Throwable
    //   107	132	228	finally
    //   132	151	228	finally
    //   158	167	228	finally
    //   197	202	228	finally
    //   233	241	228	finally
    //   107	132	232	java/lang/Throwable
    //   132	151	232	java/lang/Throwable
    //   158	167	232	java/lang/Throwable
    //   197	202	232	java/lang/Throwable
    //   241	249	251	java/lang/Throwable
    //   262	270	273	java/lang/Throwable
  }
  
  /* Error */
  public boolean a(int paramInt, String paramString, String[] paramArrayOfString, IDBCacheDataWrapper... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 86	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload 4
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: iconst_1
    //   18: invokespecial 414	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore 8
    //   23: aload 8
    //   25: ifnonnull +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: getstatic 492	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:e	Z
    //   33: ifeq +74 -> 107
    //   36: new 106	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   43: astore 9
    //   45: aload 9
    //   47: ldc_w 611
    //   50: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 9
    //   56: aload_0
    //   57: getfield 74	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:d	Ljava/lang/String;
    //   60: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 9
    //   66: ldc_w 613
    //   69: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 9
    //   75: iload_1
    //   76: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 9
    //   82: ldc_w 498
    //   85: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 9
    //   91: aload_2
    //   92: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 178
    //   98: iconst_4
    //   99: aload 9
    //   101: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 315	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: invokestatic 478	com/tencent/mobileqq/app/SQLiteDatabase:beginTransactionLog	()V
    //   110: aload 8
    //   112: invokestatic 285	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   115: aload_0
    //   116: aload 8
    //   118: iload_1
    //   119: aload_2
    //   120: aload_3
    //   121: invokevirtual 615	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;ILjava/lang/String;[Ljava/lang/String;)V
    //   124: aload 4
    //   126: arraylength
    //   127: istore 5
    //   129: iconst_0
    //   130: istore_1
    //   131: goto +142 -> 273
    //   134: aload_0
    //   135: aload 8
    //   137: aload_2
    //   138: invokevirtual 620	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper;)J
    //   141: lstore 6
    //   143: lload 6
    //   145: ldc2_w 129
    //   148: lcmp
    //   149: ifne +24 -> 173
    //   152: aload 8
    //   154: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   157: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_2
    //   163: aload_0
    //   164: ldc_w 486
    //   167: aload_2
    //   168: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   171: iconst_0
    //   172: ireturn
    //   173: iload_1
    //   174: iconst_1
    //   175: iadd
    //   176: istore_1
    //   177: goto +96 -> 273
    //   180: aload 8
    //   182: invokevirtual 299	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   185: aload 8
    //   187: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   190: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   193: goto +12 -> 205
    //   196: astore_2
    //   197: aload_0
    //   198: ldc_w 486
    //   201: aload_2
    //   202: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_0
    //   206: invokespecial 500	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:h	()V
    //   209: iconst_1
    //   210: ireturn
    //   211: astore_2
    //   212: goto +33 -> 245
    //   215: astore_2
    //   216: aload_0
    //   217: ldc_w 622
    //   220: aload_2
    //   221: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: aload 8
    //   226: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   229: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   232: iconst_0
    //   233: ireturn
    //   234: astore_2
    //   235: aload_0
    //   236: ldc_w 486
    //   239: aload_2
    //   240: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   243: iconst_0
    //   244: ireturn
    //   245: aload 8
    //   247: invokevirtual 296	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   250: invokestatic 484	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   253: goto +12 -> 265
    //   256: astore_3
    //   257: aload_0
    //   258: ldc_w 486
    //   261: aload_3
    //   262: invokespecial 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   265: goto +5 -> 270
    //   268: aload_2
    //   269: athrow
    //   270: goto -2 -> 268
    //   273: iload_1
    //   274: iload 5
    //   276: if_icmpge -96 -> 180
    //   279: aload 4
    //   281: iload_1
    //   282: aaload
    //   283: astore_2
    //   284: aload_2
    //   285: ifnonnull -151 -> 134
    //   288: goto -115 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	AbstractDbCacheManager
    //   0	291	1	paramInt	int
    //   0	291	2	paramString	String
    //   0	291	3	paramArrayOfString	String[]
    //   0	291	4	paramVarArgs	IDBCacheDataWrapper[]
    //   127	150	5	n	int
    //   141	3	6	l1	long
    //   21	225	8	localSQLiteDatabase	SQLiteDatabase
    //   43	57	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   152	160	162	java/lang/Throwable
    //   185	193	196	java/lang/Throwable
    //   107	129	211	finally
    //   134	143	211	finally
    //   180	185	211	finally
    //   216	224	211	finally
    //   107	129	215	java/lang/Throwable
    //   134	143	215	java/lang/Throwable
    //   180	185	215	java/lang/Throwable
    //   224	232	234	java/lang/Throwable
    //   245	253	256	java/lang/Throwable
  }
  
  public Cursor b(String paramString, String[] paramArrayOfString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    if (isClosed()) {
      return null;
    }
    Object localObject1 = a(false);
    if (localObject1 == null) {
      return null;
    }
    if (e)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rawQuery--sql:");
      localStringBuilder.append(paramString);
      QLog.d("QCircleDbCacheDatabase.CacheManager", 4, localStringBuilder.toString());
    }
    try
    {
      long l1 = System.currentTimeMillis();
      localObject1 = ((SQLiteDatabase)localObject1).rawQuery(paramString, paramArrayOfString);
      try
      {
        a(this.k, this.d, paramString, paramArrayOfString, System.currentTimeMillis() - l1);
        paramString = (String)localObject1;
      }
      catch (Throwable paramArrayOfString)
      {
        paramString = (String)localObject1;
      }
      a("fail to rawQuery obtain cursor for ", paramArrayOfString);
    }
    catch (Throwable paramArrayOfString)
    {
      paramString = null;
    }
    paramArrayOfString = localObject2;
    if (paramString != null) {
      paramArrayOfString = new DbSafeCursorWrapper(paramString, this.k);
    }
    return paramArrayOfString;
  }
  
  /* Error */
  public ArrayList<ContentValues> b()
  {
    // Byte code:
    //   0: new 41	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 42	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 60	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:m	Lcom/tencent/mobileqq/qcircle/api/db/DbCacheDatabase;
    //   14: invokevirtual 503	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:a	()Lcom/tencent/mobileqq/qcircle/api/db/util/EncryptUtil;
    //   17: aload_0
    //   18: getfield 74	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:d	Ljava/lang/String;
    //   21: invokevirtual 631	com/tencent/mobileqq/qcircle/api/db/util/EncryptUtil:c	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +274 -> 300
    //   29: aload_3
    //   30: invokevirtual 200	java/util/ArrayList:size	()I
    //   33: ifne +6 -> 39
    //   36: goto +264 -> 300
    //   39: aload_3
    //   40: invokevirtual 634	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   43: checkcast 41	java/util/ArrayList
    //   46: astore_3
    //   47: aload_3
    //   48: iconst_0
    //   49: ldc_w 554
    //   52: invokevirtual 637	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   55: aload_3
    //   56: aload_3
    //   57: invokevirtual 200	java/util/ArrayList:size	()I
    //   60: anewarray 132	java/lang/String
    //   63: invokevirtual 641	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   66: checkcast 643	[Ljava/lang/String;
    //   69: checkcast 643	[Ljava/lang/String;
    //   72: astore 4
    //   74: aload_0
    //   75: aload 4
    //   77: aconst_null
    //   78: aconst_null
    //   79: aconst_null
    //   80: aconst_null
    //   81: invokevirtual 567	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore_3
    //   85: aload_3
    //   86: ifnull +185 -> 271
    //   89: aload_3
    //   90: invokeinterface 270 1 0
    //   95: pop
    //   96: aload_3
    //   97: invokeinterface 646 1 0
    //   102: ifne +169 -> 271
    //   105: new 529	android/content/ContentValues
    //   108: dup
    //   109: invokespecial 530	android/content/ContentValues:<init>	()V
    //   112: astore 5
    //   114: aload 5
    //   116: ldc_w 554
    //   119: aload_3
    //   120: aload_3
    //   121: ldc_w 554
    //   124: invokeinterface 650 2 0
    //   129: invokeinterface 274 2 0
    //   134: invokestatic 408	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: invokevirtual 654	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   140: iconst_1
    //   141: istore_1
    //   142: iload_1
    //   143: aload 4
    //   145: arraylength
    //   146: if_icmpge +35 -> 181
    //   149: aload 5
    //   151: aload 4
    //   153: iload_1
    //   154: aaload
    //   155: aload_3
    //   156: aload_3
    //   157: aload 4
    //   159: iload_1
    //   160: aaload
    //   161: invokeinterface 650 2 0
    //   166: invokeinterface 658 2 0
    //   171: invokevirtual 661	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: iload_1
    //   175: iconst_1
    //   176: iadd
    //   177: istore_1
    //   178: goto -36 -> 142
    //   181: aload_2
    //   182: aload 5
    //   184: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   187: pop
    //   188: aload_3
    //   189: invokeinterface 664 1 0
    //   194: pop
    //   195: goto -99 -> 96
    //   198: astore_2
    //   199: goto +45 -> 244
    //   202: astore 4
    //   204: ldc 178
    //   206: iconst_1
    //   207: aload 4
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokestatic 667	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   216: aload_3
    //   217: ifnull +79 -> 296
    //   220: aload_3
    //   221: invokeinterface 277 1 0
    //   226: goto +70 -> 296
    //   229: astore_3
    //   230: ldc 178
    //   232: iconst_1
    //   233: aload_3
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 667	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   241: goto +55 -> 296
    //   244: aload_3
    //   245: ifnull +24 -> 269
    //   248: aload_3
    //   249: invokeinterface 277 1 0
    //   254: goto +15 -> 269
    //   257: astore_3
    //   258: ldc 178
    //   260: iconst_1
    //   261: aload_3
    //   262: iconst_0
    //   263: anewarray 4	java/lang/Object
    //   266: invokestatic 667	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   269: aload_2
    //   270: athrow
    //   271: aload_3
    //   272: ifnull +24 -> 296
    //   275: aload_3
    //   276: invokeinterface 277 1 0
    //   281: goto +15 -> 296
    //   284: astore_3
    //   285: ldc 178
    //   287: iconst_1
    //   288: aload_3
    //   289: iconst_0
    //   290: anewarray 4	java/lang/Object
    //   293: invokestatic 667	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   296: aload_0
    //   297: monitorexit
    //   298: aload_2
    //   299: areturn
    //   300: aload_0
    //   301: monitorexit
    //   302: aconst_null
    //   303: areturn
    //   304: astore_2
    //   305: aload_0
    //   306: monitorexit
    //   307: goto +5 -> 312
    //   310: aload_2
    //   311: athrow
    //   312: goto -2 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	AbstractDbCacheManager
    //   141	37	1	n	int
    //   7	175	2	localArrayList	ArrayList
    //   198	101	2	localArrayList1	ArrayList<ContentValues>
    //   304	7	2	localObject1	Object
    //   24	197	3	localObject2	Object
    //   229	20	3	localException1	Exception
    //   257	19	3	localException2	Exception
    //   284	5	3	localException3	Exception
    //   72	86	4	arrayOfString	String[]
    //   202	6	4	localException4	Exception
    //   112	71	5	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   89	96	198	finally
    //   96	140	198	finally
    //   142	174	198	finally
    //   181	195	198	finally
    //   204	216	198	finally
    //   89	96	202	java/lang/Exception
    //   96	140	202	java/lang/Exception
    //   142	174	202	java/lang/Exception
    //   181	195	202	java/lang/Exception
    //   220	226	229	java/lang/Exception
    //   248	254	257	java/lang/Exception
    //   275	281	284	java/lang/Exception
    //   10	25	304	finally
    //   29	36	304	finally
    //   39	85	304	finally
    //   220	226	304	finally
    //   230	241	304	finally
    //   248	254	304	finally
    //   258	269	304	finally
    //   269	271	304	finally
    //   275	281	304	finally
    //   285	296	304	finally
    //   296	298	304	finally
    //   300	302	304	finally
    //   305	307	304	finally
  }
  
  final String c()
  {
    return a(this.f, this.g, this.d);
  }
  
  public void close()
  {
    g();
    d();
  }
  
  protected abstract void d();
  
  protected abstract void e();
  
  protected boolean f()
  {
    return this.c != null;
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 672	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:g	()V
    //   4: aload_0
    //   5: invokespecial 677	java/lang/Object:finalize	()V
    //   8: return
    //   9: astore_1
    //   10: goto +18 -> 28
    //   13: astore_1
    //   14: ldc 178
    //   16: iconst_1
    //   17: aload_1
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 667	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   25: goto -21 -> 4
    //   28: aload_0
    //   29: invokespecial 677	java/lang/Object:finalize	()V
    //   32: goto +5 -> 37
    //   35: aload_1
    //   36: athrow
    //   37: goto -2 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	AbstractDbCacheManager
    //   9	1	1	localObject	Object
    //   13	23	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   14	25	9	finally
    //   0	4	13	java/lang/Exception
  }
  
  public boolean isClosed()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.AbstractDbCacheManager
 * JD-Core Version:    0.7.0.1
 */