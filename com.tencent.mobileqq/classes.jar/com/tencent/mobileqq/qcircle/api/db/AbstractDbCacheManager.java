package com.tencent.mobileqq.qcircle.api.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.db.util.EncryptUtil;
import com.tencent.mobileqq.qcircle.api.db.util.SecurityUtil;
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
  private static boolean c = false;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private DbCacheDatabase jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheDatabase;
  protected IDBCacheDataWrapper.DbCreator a;
  protected String a;
  private ArrayList<IDBCacheDataWrapper.Structure> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String b;
  private boolean d;
  private boolean e = false;
  private volatile boolean f = false;
  
  protected AbstractDbCacheManager(Context paramContext, Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.jdField_b_of_type_JavaLangString = null;
    paramContext = paramContext.getApplicationContext();
    this.jdField_b_of_type_JavaLangString = a(paramLong, paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheDatabase = DbCacheDatabase.a(paramContext, this.jdField_b_of_type_JavaLangString, paramInt2, paramInt3);
    this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheDatabase.attach(hashCode());
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramClass);
    e();
  }
  
  private SQLiteDatabase a(boolean paramBoolean)
  {
    if (isClosed()) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheDatabase.a(paramBoolean);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    if (paramInt == DbCacheService.jdField_a_of_type_Int)
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
    if (DbCacheDatabase.jdField_a_of_type_Boolean)
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
      RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, paramClass.getMessage());
      paramClass = null;
    }
    if (paramClass == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBCacheDataWrapper$DbCreator = paramClass;
    paramClass = paramClass.structure();
    if (paramClass != null)
    {
      int j = paramClass.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramClass[i];
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
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
    if ((jdField_a_of_type_Boolean) || (paramLong > 50L))
    {
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("db:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" table:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" selection:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" args:");
      localStringBuilder.append(Arrays.toString(paramArrayOfString));
      RFLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test", i, localStringBuilder.toString());
      i = RFLog.USR;
      paramString1 = new StringBuilder();
      paramString1.append("timecost: ");
      paramString1.append(paramLong);
      RFLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test", i, paramString1.toString());
    }
    if ((jdField_b_of_type_Boolean) || (paramLong > 50L)) {
      RFLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test_Stack", RFLog.USR, Log.getStackTraceString(new Throwable()));
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramThrowable.getMessage());
    RFLog.w("QCircleDbCacheDatabase.CacheManager", i, localStringBuilder.toString());
    try
    {
      DbCacheExceptionHandler.a().a(paramThrowable, this.jdField_b_of_type_JavaLangString);
      return;
    }
    catch (Throwable paramString)
    {
      RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, paramString.getMessage());
    }
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload 8
    //   8: astore 6
    //   10: aload 9
    //   12: astore 7
    //   14: new 98	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   21: astore 10
    //   23: aload 8
    //   25: astore 6
    //   27: aload 9
    //   29: astore 7
    //   31: aload 10
    //   33: ldc 252
    //   35: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 8
    //   41: astore 6
    //   43: aload 9
    //   45: astore 7
    //   47: aload 10
    //   49: aload_2
    //   50: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 8
    //   56: astore 6
    //   58: aload 9
    //   60: astore 7
    //   62: aload 10
    //   64: ldc 254
    //   66: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 8
    //   72: astore 6
    //   74: aload 9
    //   76: astore 7
    //   78: aload_1
    //   79: aload 10
    //   81: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: aconst_null
    //   85: invokevirtual 258	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +56 -> 146
    //   93: aload_1
    //   94: astore 6
    //   96: aload_1
    //   97: astore 7
    //   99: aload_1
    //   100: invokeinterface 263 1 0
    //   105: ifle +41 -> 146
    //   108: aload_1
    //   109: astore 6
    //   111: aload_1
    //   112: astore 7
    //   114: aload_1
    //   115: invokeinterface 266 1 0
    //   120: pop
    //   121: aload_1
    //   122: astore 6
    //   124: aload_1
    //   125: astore 7
    //   127: aload_1
    //   128: iconst_0
    //   129: invokeinterface 270 2 0
    //   134: istore_3
    //   135: iload_3
    //   136: iconst_1
    //   137: if_icmpne +9 -> 146
    //   140: iconst_1
    //   141: istore 4
    //   143: goto +6 -> 149
    //   146: iconst_0
    //   147: istore 4
    //   149: iload 4
    //   151: istore 5
    //   153: aload_1
    //   154: ifnull +110 -> 264
    //   157: aload_1
    //   158: invokeinterface 273 1 0
    //   163: iload 4
    //   165: ireturn
    //   166: astore_1
    //   167: ldc 170
    //   169: getstatic 175	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   172: iconst_2
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: ldc_w 275
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_1
    //   185: aastore
    //   186: invokestatic 278	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   189: iload 4
    //   191: ireturn
    //   192: astore_1
    //   193: goto +74 -> 267
    //   196: astore_1
    //   197: aload 7
    //   199: astore 6
    //   201: ldc 170
    //   203: getstatic 175	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   206: iconst_2
    //   207: anewarray 4	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: ldc_w 275
    //   215: aastore
    //   216: dup
    //   217: iconst_1
    //   218: aload_1
    //   219: aastore
    //   220: invokestatic 278	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   223: aload 7
    //   225: ifnull +36 -> 261
    //   228: aload 7
    //   230: invokeinterface 273 1 0
    //   235: goto +26 -> 261
    //   238: astore_1
    //   239: ldc 170
    //   241: getstatic 175	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   244: iconst_2
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: ldc_w 275
    //   253: aastore
    //   254: dup
    //   255: iconst_1
    //   256: aload_1
    //   257: aastore
    //   258: invokestatic 278	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   261: iconst_0
    //   262: istore 5
    //   264: iload 5
    //   266: ireturn
    //   267: aload 6
    //   269: ifnull +36 -> 305
    //   272: aload 6
    //   274: invokeinterface 273 1 0
    //   279: goto +26 -> 305
    //   282: astore_2
    //   283: ldc 170
    //   285: getstatic 175	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   288: iconst_2
    //   289: anewarray 4	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: ldc_w 275
    //   297: aastore
    //   298: dup
    //   299: iconst_1
    //   300: aload_2
    //   301: aastore
    //   302: invokestatic 278	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   305: aload_1
    //   306: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	AbstractDbCacheManager
    //   0	307	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	307	2	paramString	String
    //   134	4	3	i	int
    //   141	49	4	bool1	boolean
    //   151	114	5	bool2	boolean
    //   8	265	6	localObject1	Object
    //   12	217	7	localObject2	Object
    //   4	67	8	localObject3	Object
    //   1	74	9	localObject4	Object
    //   21	59	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   157	163	166	java/lang/Exception
    //   14	23	192	finally
    //   31	39	192	finally
    //   47	54	192	finally
    //   62	70	192	finally
    //   78	89	192	finally
    //   99	108	192	finally
    //   114	121	192	finally
    //   127	135	192	finally
    //   201	223	192	finally
    //   14	23	196	java/lang/Exception
    //   31	39	196	java/lang/Exception
    //   47	54	196	java/lang/Exception
    //   62	70	196	java/lang/Exception
    //   78	89	196	java/lang/Exception
    //   99	108	196	java/lang/Exception
    //   114	121	196	java/lang/Exception
    //   127	135	196	java/lang/Exception
    //   228	235	238	java/lang/Exception
    //   272	279	282	java/lang/Exception
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 281	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   4: aload_2
    //   5: arraylength
    //   6: istore 4
    //   8: iconst_0
    //   9: istore_3
    //   10: iload_3
    //   11: iload 4
    //   13: if_icmpge +84 -> 97
    //   16: aload_2
    //   17: iload_3
    //   18: aaload
    //   19: astore 6
    //   21: aload 6
    //   23: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +65 -> 91
    //   29: aload_1
    //   30: aload 6
    //   32: invokevirtual 284	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   35: invokestatic 287	com/tencent/biz/richframework/delegate/impl/RFLog:isColorLevel	()Z
    //   38: ifeq +46 -> 84
    //   41: getstatic 175	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   44: istore 5
    //   46: new 98	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   53: astore 7
    //   55: aload 7
    //   57: ldc_w 289
    //   60: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 7
    //   66: aload 6
    //   68: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 170
    //   74: iload 5
    //   76: aload 7
    //   78: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 182	com/tencent/biz/richframework/delegate/impl/RFLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: iload_3
    //   85: iconst_1
    //   86: iadd
    //   87: istore_3
    //   88: goto -78 -> 10
    //   91: aload_1
    //   92: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   95: iconst_0
    //   96: ireturn
    //   97: aload_1
    //   98: invokevirtual 295	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   101: aload_1
    //   102: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   105: iconst_1
    //   106: ireturn
    //   107: astore_2
    //   108: goto +32 -> 140
    //   111: astore_2
    //   112: ldc 170
    //   114: getstatic 175	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   117: iconst_2
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: ldc_w 297
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: aload_2
    //   130: aastore
    //   131: invokestatic 278	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   134: aload_1
    //   135: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   138: iconst_0
    //   139: ireturn
    //   140: aload_1
    //   141: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   144: goto +5 -> 149
    //   147: aload_2
    //   148: athrow
    //   149: goto -2 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	AbstractDbCacheManager
    //   0	152	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	152	2	paramArrayOfString	String[]
    //   9	79	3	i	int
    //   6	8	4	j	int
    //   44	31	5	k	int
    //   19	48	6	str	String
    //   53	24	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	8	107	finally
    //   21	84	107	finally
    //   97	101	107	finally
    //   112	134	107	finally
    //   0	8	111	java/lang/Exception
    //   21	84	111	java/lang/Exception
    //   97	101	111	java/lang/Exception
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null)
    {
      RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, "db is null,create table fail.");
      return;
    }
    if (!this.d) {
      try
      {
        Object localObject = c();
        boolean bool = RFLog.isColorLevel();
        int i;
        StringBuilder localStringBuilder1;
        if (bool)
        {
          i = RFLog.CLR;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("create table sql:");
          localStringBuilder1.append((String)localObject);
          RFLog.d("QCircleDbCacheDatabase.CacheManager", i, localStringBuilder1.toString());
        }
        if (jdField_a_of_type_Boolean)
        {
          i = RFLog.CLR;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("create table sql:");
          localStringBuilder1.append((String)localObject);
          RFLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test", i, localStringBuilder1.toString());
        }
        paramSQLiteDatabase.execSQL((String)localObject);
        localObject = d();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(";");
          int j = localObject.length;
          i = 0;
          while (i < j)
          {
            localStringBuilder1 = localObject[i];
            if (RFLog.isColorLevel())
            {
              int k = RFLog.CLR;
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("create index sql:");
              localStringBuilder2.append(localStringBuilder1);
              RFLog.d("QCircleDbCacheDatabase.CacheManager", k, localStringBuilder2.toString());
            }
            paramSQLiteDatabase.execSQL(localStringBuilder1);
            i += 1;
          }
        }
        this.d = true;
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "createTableIfNeeded error", paramSQLiteDatabase });
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "createTableIfNeeded error", paramSQLiteDatabase });
      }
    }
  }
  
  private String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CREATE TABLE IF NOT EXISTS ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" (");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append("_id INTEGER PRIMARY KEY");
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  private void c()
  {
    if (isClosed()) {
      return;
    }
    try
    {
      if (isClosed()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheDatabase.detach(hashCode());
      this.e = true;
      return;
    }
    finally {}
  }
  
  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    String str = e();
    paramSQLiteDatabase.execSQL(str);
    this.d = false;
    if (RFLog.isColorLevel())
    {
      int i = RFLog.CLR;
      paramSQLiteDatabase = new StringBuilder();
      paramSQLiteDatabase.append("deleteTable sql:");
      paramSQLiteDatabase.append(str);
      RFLog.i("QCircleDbCacheDatabase.CacheManager", i, paramSQLiteDatabase.toString());
    }
  }
  
  private String d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBCacheDataWrapper$DbCreator;
    if (localObject != null)
    {
      if (!(localObject instanceof IDBCacheDataWrapper.RawDbCreator)) {
        return null;
      }
      try
      {
        localObject = ((IDBCacheDataWrapper.RawDbCreator)localObject).indexRawSql(this.jdField_a_of_type_JavaLangString);
        return localObject;
      }
      catch (Exception localException)
      {
        RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, localException.getMessage());
      }
    }
    return null;
  }
  
  private void d()
  {
    b();
  }
  
  private void d(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("_temp");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ALTER TABLE ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" RENAME TO ");
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    paramSQLiteDatabase.execSQL((String)localObject);
    this.d = false;
    if (RFLog.isColorLevel())
    {
      int i = RFLog.USR;
      paramSQLiteDatabase = new StringBuilder();
      paramSQLiteDatabase.append("remaneTable sql:");
      paramSQLiteDatabase.append((String)localObject);
      RFLog.w("QCircleDbCacheDatabase.CacheManager", i, paramSQLiteDatabase.toString());
    }
  }
  
  private String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DROP TABLE IF EXISTS ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  private void e()
  {
    if (!a()) {
      return;
    }
    int k = this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBCacheDataWrapper$DbCreator.version();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("_cache_db_version");
    int j = LocalMultiProcConfig.getInt4Uin(((StringBuilder)localObject1).toString(), -1, this.jdField_a_of_type_Long);
    int i = j;
    if (j == -1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("_cache_db_version");
      i = LocalMultiProcConfig.getInt4Uin(((StringBuilder)localObject1).toString(), -1, this.jdField_a_of_type_Long);
    }
    if (RFLog.isColorLevel()) {
      RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "mDbName:", this.jdField_b_of_type_JavaLangString, " mTable:", this.jdField_a_of_type_JavaLangString, " preVersion:", Integer.valueOf(i), " version:", Integer.valueOf(k) });
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
        if (a((SQLiteDatabase)localObject1, this.jdField_a_of_type_JavaLangString))
        {
          if ((i == -1) || (i == k) || (!(this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBCacheDataWrapper$DbCreator instanceof IDBCacheDataWrapper.UpdateDbCreator))) {
            break label793;
          }
          localObject2 = ((IDBCacheDataWrapper.UpdateDbCreator)this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBCacheDataWrapper$DbCreator).onUpdate(i, k);
          if ((localObject2 == null) || (localObject2.length <= 0)) {
            break label787;
          }
          Object localObject3 = localObject2[0];
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label787;
          }
          if ((!((String)localObject3).startsWith("ALTER")) && (!((String)localObject3).startsWith("DELETE")))
          {
            if (((String)localObject3).startsWith("INSERT"))
            {
              d((SQLiteDatabase)localObject1);
              b((SQLiteDatabase)localObject1);
              bool = a((SQLiteDatabase)localObject1, (String[])localObject2);
              e((SQLiteDatabase)localObject1);
            }
            else
            {
              if (!((String)localObject3).startsWith("NOTHING")) {
                break label787;
              }
              bool = true;
            }
          }
          else {
            bool = a((SQLiteDatabase)localObject1, (String[])localObject2);
          }
          if (bool)
          {
            this.d = true;
          }
          else
          {
            c((SQLiteDatabase)localObject1);
            continue;
            c((SQLiteDatabase)localObject1);
          }
          b((SQLiteDatabase)localObject1);
          long l = System.currentTimeMillis();
          if ((this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBCacheDataWrapper$DbCreator instanceof IDBCacheDataWrapper.UpdateDbCreator))
          {
            bool = ((IDBCacheDataWrapper.UpdateDbCreator)this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBCacheDataWrapper$DbCreator).needEncrypt(i, k);
            if (bool)
            {
              localObject2 = a();
              a((ArrayList)localObject2);
              if (RFLog.isColorLevel())
              {
                j = RFLog.USR;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("encrypt success mTableName:");
                ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
                ((StringBuilder)localObject3).append(" datasize:");
                ((StringBuilder)localObject3).append(((ArrayList)localObject2).size());
                ((StringBuilder)localObject3).append(" timecost:");
                ((StringBuilder)localObject3).append(System.currentTimeMillis() - l);
                RFLog.i("QCircleDbCacheDatabase.CacheManager", j, ((StringBuilder)localObject3).toString());
              }
            }
            else
            {
              j = RFLog.USR;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("encrypt success mTableName:");
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
              RFLog.i("QCircleDbCacheDatabase.CacheManager", j, ((StringBuilder)localObject2).toString());
            }
          }
        }
        else
        {
          b((SQLiteDatabase)localObject1);
        }
        if (i != k)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append("_cache_db_version");
          LocalMultiProcConfig.putInt4Uin(((StringBuilder)localObject2).toString(), k, this.jdField_a_of_type_Long);
          return;
        }
      }
      catch (Exception localException2)
      {
        RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "updateOrCreateTable error", localException2 });
        try
        {
          c((SQLiteDatabase)localObject1);
          e((SQLiteDatabase)localObject1);
          b((SQLiteDatabase)localObject1);
          if (i != k)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject1).append("_cache_db_version");
            LocalMultiProcConfig.putInt4Uin(((StringBuilder)localObject1).toString(), k, this.jdField_a_of_type_Long);
            return;
          }
        }
        catch (Exception localException1)
        {
          RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "updateOrCreateTable error", localException1 });
        }
      }
      return;
      label787:
      boolean bool = false;
      continue;
      label793:
      if (i != -1) {
        if (i == k) {}
      }
    }
  }
  
  private void e(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("_temp");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DROP TABLE IF EXISTS ");
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    paramSQLiteDatabase.execSQL((String)localObject);
    if (RFLog.isColorLevel())
    {
      int i = RFLog.USR;
      paramSQLiteDatabase = new StringBuilder();
      paramSQLiteDatabase.append("dropTable sql:");
      paramSQLiteDatabase.append((String)localObject);
      RFLog.w("QCircleDbCacheDatabase.CacheManager", i, paramSQLiteDatabase.toString());
    }
  }
  
  /* Error */
  protected int a(ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 79	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:isClosed	()Z
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
    //   24: invokespecial 408	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore 8
    //   29: aload 8
    //   31: ifnonnull +5 -> 36
    //   34: iconst_0
    //   35: ireturn
    //   36: iload 5
    //   38: istore 4
    //   40: invokestatic 474	com/tencent/mobileqq/app/SQLiteDatabase:beginTransactionLog	()V
    //   43: iload 5
    //   45: istore 4
    //   47: aload 8
    //   49: invokestatic 281	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   52: iload 5
    //   54: istore 4
    //   56: aload_0
    //   57: aload 8
    //   59: aload_1
    //   60: aload_2
    //   61: aload_3
    //   62: invokevirtual 477	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   65: istore 5
    //   67: iload 5
    //   69: istore 4
    //   71: aload 8
    //   73: invokevirtual 295	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   76: iload 5
    //   78: istore 6
    //   80: aload 8
    //   82: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   85: iload 5
    //   87: istore 6
    //   89: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   92: iload 5
    //   94: istore 4
    //   96: goto +48 -> 144
    //   99: astore_1
    //   100: aload_0
    //   101: ldc_w 482
    //   104: aload_1
    //   105: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: iload 6
    //   110: istore 4
    //   112: goto +32 -> 144
    //   115: astore_1
    //   116: goto +116 -> 232
    //   119: astore_1
    //   120: aload_0
    //   121: ldc_w 486
    //   124: aload_1
    //   125: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: iload 4
    //   130: istore 6
    //   132: aload 8
    //   134: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   137: iload 4
    //   139: istore 6
    //   141: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   144: getstatic 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:c	Z
    //   147: ifeq +73 -> 220
    //   150: getstatic 491	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   153: istore 5
    //   155: new 98	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   162: astore_1
    //   163: aload_1
    //   164: ldc_w 493
    //   167: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_1
    //   172: aload_0
    //   173: getfield 67	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   176: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_1
    //   181: ldc_w 495
    //   184: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: iload 4
    //   191: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_1
    //   196: ldc_w 497
    //   199: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_1
    //   204: aload_2
    //   205: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: ldc 170
    //   211: iload 5
    //   213: aload_1
    //   214: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 314	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: iload 4
    //   222: ifle +7 -> 229
    //   225: aload_0
    //   226: invokespecial 499	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:d	()V
    //   229: iload 4
    //   231: ireturn
    //   232: aload 8
    //   234: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   237: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   240: goto +12 -> 252
    //   243: astore_2
    //   244: aload_0
    //   245: ldc_w 482
    //   248: aload_2
    //   249: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   252: aload_1
    //   253: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	AbstractDbCacheManager
    //   0	254	1	paramContentValues	ContentValues
    //   0	254	2	paramString	String
    //   0	254	3	paramArrayOfString	String[]
    //   38	192	4	i	int
    //   7	205	5	j	int
    //   78	62	6	k	int
    //   4	6	7	bool	boolean
    //   27	206	8	localSQLiteDatabase	SQLiteDatabase
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
    //   232	240	243	java/lang/Throwable
  }
  
  final int a(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (paramContentValues == null) {
      return 0;
    }
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheDatabase.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramString, paramArrayOfString);
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramString, paramArrayOfString, System.currentTimeMillis() - l);
    return paramSQLiteDatabase.update(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheDatabase.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramContentValues), paramString, paramArrayOfString);
  }
  
  public int a(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    IDBCacheDataWrapper.DbCreator localDbCreator = this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBCacheDataWrapper$DbCreator;
    if (((localDbCreator instanceof IDBCacheDataWrapper.RawDbCreator)) && (paramArrayOfString == null)) {
      return ((IDBCacheDataWrapper.RawDbCreator)localDbCreator).delRawSql(paramSQLiteDatabase, this.jdField_a_of_type_JavaLangString, paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheDatabase.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramString, paramArrayOfString);
    long l = System.currentTimeMillis();
    int i = paramSQLiteDatabase.delete(this.jdField_a_of_type_JavaLangString, paramString, paramArrayOfString);
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramString, paramArrayOfString, System.currentTimeMillis() - l);
    return i;
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
    int i = 0;
    if (bool) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = a(true);
    if (localSQLiteDatabase == null) {
      return 0;
    }
    int j;
    try
    {
      j = a(localSQLiteDatabase, paramString, paramArrayOfString);
      i = j;
    }
    catch (Throwable paramArrayOfString)
    {
      a("fail to delete data", paramArrayOfString);
    }
    if (c)
    {
      j = RFLog.DEV;
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("delete--table:");
      paramArrayOfString.append(this.jdField_a_of_type_JavaLangString);
      paramArrayOfString.append(",deleted:");
      paramArrayOfString.append(i);
      paramArrayOfString.append(",where:");
      paramArrayOfString.append(paramString);
      RFLog.d("QCircleDbCacheDatabase.CacheManager", j, paramArrayOfString.toString());
    }
    d();
    return i;
  }
  
  /* Error */
  public int a(ArrayList<ContentValues> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 79	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:isClosed	()Z
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 4
    //   9: iload 5
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_1
    //   17: ifnull +254 -> 271
    //   20: aload_1
    //   21: invokevirtual 195	java/util/ArrayList:size	()I
    //   24: ifne +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: iconst_1
    //   31: invokespecial 408	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   34: astore 6
    //   36: aload 6
    //   38: ifnonnull +5 -> 43
    //   41: iconst_0
    //   42: ireturn
    //   43: invokestatic 474	com/tencent/mobileqq/app/SQLiteDatabase:beginTransactionLog	()V
    //   46: aload 6
    //   48: invokestatic 281	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   51: iconst_0
    //   52: istore_3
    //   53: iconst_0
    //   54: istore_2
    //   55: iload_3
    //   56: aload_1
    //   57: invokevirtual 195	java/util/ArrayList:size	()I
    //   60: if_icmpge +51 -> 111
    //   63: iload_2
    //   64: aload_0
    //   65: aload 6
    //   67: aload_1
    //   68: iload_3
    //   69: invokevirtual 549	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   72: checkcast 528	android/content/ContentValues
    //   75: ldc_w 551
    //   78: iconst_1
    //   79: anewarray 124	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: aload_1
    //   85: iload_3
    //   86: invokevirtual 549	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   89: checkcast 528	android/content/ContentValues
    //   92: ldc_w 553
    //   95: invokevirtual 556	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: aastore
    //   99: invokevirtual 477	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   102: iadd
    //   103: istore_2
    //   104: iload_3
    //   105: iconst_1
    //   106: iadd
    //   107: istore_3
    //   108: goto -53 -> 55
    //   111: aload 6
    //   113: invokevirtual 295	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   116: aload 6
    //   118: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   121: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   124: goto +12 -> 136
    //   127: astore_1
    //   128: aload_0
    //   129: ldc_w 482
    //   132: aload_1
    //   133: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: goto +42 -> 178
    //   139: astore_1
    //   140: goto +107 -> 247
    //   143: astore_1
    //   144: aload_0
    //   145: ldc_w 486
    //   148: aload_1
    //   149: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   152: aload 6
    //   154: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   157: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   160: iload 4
    //   162: istore_2
    //   163: goto +15 -> 178
    //   166: astore_1
    //   167: aload_0
    //   168: ldc_w 482
    //   171: aload_1
    //   172: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   175: iload 4
    //   177: istore_2
    //   178: getstatic 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:c	Z
    //   181: ifeq +64 -> 245
    //   184: getstatic 491	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   187: istore_3
    //   188: new 98	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   195: astore_1
    //   196: aload_1
    //   197: ldc_w 493
    //   200: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: aload_0
    //   206: getfield 67	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   209: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_1
    //   214: ldc_w 495
    //   217: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_1
    //   222: iload_2
    //   223: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_1
    //   228: ldc_w 497
    //   231: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: ldc 170
    //   237: iload_3
    //   238: aload_1
    //   239: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 314	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: iload_2
    //   246: ireturn
    //   247: aload 6
    //   249: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   252: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   255: goto +14 -> 269
    //   258: astore 6
    //   260: aload_0
    //   261: ldc_w 482
    //   264: aload 6
    //   266: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   269: aload_1
    //   270: athrow
    //   271: iconst_0
    //   272: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	AbstractDbCacheManager
    //   0	273	1	paramArrayList	ArrayList<ContentValues>
    //   54	192	2	i	int
    //   52	186	3	j	int
    //   7	169	4	k	int
    //   4	6	5	bool	boolean
    //   34	214	6	localSQLiteDatabase	SQLiteDatabase
    //   258	7	6	localThrowable	Throwable
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
    //   247	255	258	java/lang/Throwable
  }
  
  final long a(SQLiteDatabase paramSQLiteDatabase, IDBCacheDataWrapper paramIDBCacheDataWrapper)
  {
    ContentValues localContentValues = new ContentValues();
    paramIDBCacheDataWrapper.writeTo(localContentValues);
    return paramSQLiteDatabase.replaceOrThrow(this.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheDatabase.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, localContentValues));
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
  
  public Cursor a(String paramString, String[] paramArrayOfString)
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
    if (c)
    {
      int i = RFLog.DEV;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rawQuery--sql:");
      localStringBuilder.append(paramString);
      RFLog.d("QCircleDbCacheDatabase.CacheManager", i, localStringBuilder.toString());
    }
    try
    {
      long l = System.currentTimeMillis();
      localObject1 = ((SQLiteDatabase)localObject1).rawQuery(paramString, paramArrayOfString);
      try
      {
        a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramString, paramArrayOfString, System.currentTimeMillis() - l);
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
      paramArrayOfString = new DbSafeCursorWrapper(paramString, this.jdField_b_of_type_JavaLangString);
    }
    return paramArrayOfString;
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
    //   1: invokevirtual 79	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: iconst_0
    //   11: invokespecial 408	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 12
    //   16: aload 12
    //   18: ifnonnull +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: invokestatic 287	com/tencent/biz/richframework/delegate/impl/RFLog:isColorLevel	()Z
    //   26: ifeq +120 -> 146
    //   29: getstatic 310	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   32: istore 6
    //   34: new 98	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   41: astore 11
    //   43: aload 11
    //   45: ldc_w 580
    //   48: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 11
    //   54: aload_0
    //   55: getfield 67	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 11
    //   64: ldc_w 582
    //   67: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 11
    //   73: aload_2
    //   74: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 11
    //   80: ldc_w 584
    //   83: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 11
    //   89: aload 4
    //   91: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 11
    //   97: ldc_w 586
    //   100: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 11
    //   106: aload 5
    //   108: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 11
    //   114: ldc_w 588
    //   117: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 11
    //   123: aload_3
    //   124: invokestatic 220	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   127: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: ldc 170
    //   133: iload 6
    //   135: aload 11
    //   137: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 314	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: goto +3 -> 146
    //   146: aload 4
    //   148: astore 11
    //   150: aload 4
    //   152: ifnonnull +25 -> 177
    //   155: aload 4
    //   157: astore 11
    //   159: aload_0
    //   160: invokevirtual 383	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	()Z
    //   163: ifeq +14 -> 177
    //   166: aload_0
    //   167: getfield 184	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBCacheDataWrapper$DbCreator	Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper$DbCreator;
    //   170: invokeinterface 591 1 0
    //   175: astore 11
    //   177: aload_0
    //   178: getfield 53	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheDatabase	Lcom/tencent/mobileqq/qcircle/api/db/DbCacheDatabase;
    //   181: invokevirtual 502	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:a	()Lcom/tencent/mobileqq/qcircle/api/db/util/EncryptUtil;
    //   184: aload_0
    //   185: getfield 32	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   188: aload_0
    //   189: getfield 67	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   192: aload_2
    //   193: aload_3
    //   194: invokevirtual 507	com/tencent/mobileqq/qcircle/api/db/util/EncryptUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   197: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   200: lstore 7
    //   202: aload 12
    //   204: aload_0
    //   205: getfield 67	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   208: aload_1
    //   209: aload_2
    //   210: aload_3
    //   211: aconst_null
    //   212: aconst_null
    //   213: aload 11
    //   215: aload 5
    //   217: invokevirtual 595	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   220: astore 4
    //   222: aload_0
    //   223: getfield 32	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   226: astore_1
    //   227: aload_0
    //   228: getfield 67	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   231: astore 5
    //   233: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   236: lstore 9
    //   238: aload_0
    //   239: aload_1
    //   240: aload 5
    //   242: aload_2
    //   243: aload_3
    //   244: lload 9
    //   246: lload 7
    //   248: lsub
    //   249: invokespecial 509	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;J)V
    //   252: aload 4
    //   254: astore_3
    //   255: goto +55 -> 310
    //   258: astore_1
    //   259: aload 4
    //   261: astore_3
    //   262: goto +13 -> 275
    //   265: astore_1
    //   266: aload 4
    //   268: astore_3
    //   269: goto +6 -> 275
    //   272: astore_1
    //   273: aconst_null
    //   274: astore_3
    //   275: new 98	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   282: astore 4
    //   284: aload 4
    //   286: ldc_w 597
    //   289: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 4
    //   295: aload_2
    //   296: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_0
    //   301: aload 4
    //   303: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aload_1
    //   307: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   310: aload_3
    //   311: ifnull +16 -> 327
    //   314: new 572	com/tencent/mobileqq/qcircle/api/db/DbSafeCursorWrapper
    //   317: dup
    //   318: aload_3
    //   319: aload_0
    //   320: getfield 32	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   323: invokespecial 575	com/tencent/mobileqq/qcircle/api/db/DbSafeCursorWrapper:<init>	(Landroid/database/Cursor;Ljava/lang/String;)V
    //   326: areturn
    //   327: aconst_null
    //   328: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	AbstractDbCacheManager
    //   0	329	1	paramArrayOfString1	String[]
    //   0	329	2	paramString1	String
    //   0	329	3	paramArrayOfString2	String[]
    //   0	329	4	paramString2	String
    //   0	329	5	paramString3	String
    //   32	102	6	i	int
    //   200	47	7	l1	long
    //   236	9	9	l2	long
    //   41	173	11	localObject	Object
    //   14	189	12	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   238	252	258	java/lang/Throwable
    //   222	238	265	java/lang/Throwable
    //   159	177	272	java/lang/Throwable
    //   177	222	272	java/lang/Throwable
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
        if (!a()) {
          return null;
        }
        Object localObject = paramCursor;
        if (!(paramCursor instanceof DbSafeCursorWrapper)) {
          localObject = new DbSafeCursorWrapper(paramCursor, this.jdField_b_of_type_JavaLangString);
        }
        try
        {
          paramCursor = this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBCacheDataWrapper$DbCreator.createFromCursor((Cursor)localObject);
          return paramCursor;
        }
        catch (Throwable paramCursor)
        {
          RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, paramCursor.getMessage());
          return null;
        }
        catch (OutOfMemoryError paramCursor)
        {
          if (!this.f)
          {
            this.f = true;
            localObject = a(true);
            if (localObject != null) {
              try
              {
                c((SQLiteDatabase)localObject);
                b((SQLiteDatabase)localObject);
              }
              catch (Exception localException)
              {
                RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, localException.getMessage());
              }
            }
            RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, paramCursor.getMessage());
          }
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  /* Error */
  public ArrayList<ContentValues> a()
  {
    // Byte code:
    //   0: new 34	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 35	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 53	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheDatabase	Lcom/tencent/mobileqq/qcircle/api/db/DbCacheDatabase;
    //   14: invokevirtual 502	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:a	()Lcom/tencent/mobileqq/qcircle/api/db/util/EncryptUtil;
    //   17: aload_0
    //   18: getfield 67	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokevirtual 613	com/tencent/mobileqq/qcircle/api/db/util/EncryptUtil:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +294 -> 320
    //   29: aload_3
    //   30: invokevirtual 195	java/util/ArrayList:size	()I
    //   33: ifne +6 -> 39
    //   36: goto +284 -> 320
    //   39: aload_3
    //   40: invokevirtual 616	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   43: checkcast 34	java/util/ArrayList
    //   46: astore_3
    //   47: aload_3
    //   48: iconst_0
    //   49: ldc_w 553
    //   52: invokevirtual 619	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   55: aload_3
    //   56: aload_3
    //   57: invokevirtual 195	java/util/ArrayList:size	()I
    //   60: anewarray 124	java/lang/String
    //   63: invokevirtual 623	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   66: checkcast 625	[Ljava/lang/String;
    //   69: checkcast 625	[Ljava/lang/String;
    //   72: astore 4
    //   74: aload_0
    //   75: aload 4
    //   77: aconst_null
    //   78: aconst_null
    //   79: aconst_null
    //   80: aconst_null
    //   81: invokevirtual 566	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore_3
    //   85: aload_3
    //   86: ifnull +200 -> 286
    //   89: aload_3
    //   90: invokeinterface 266 1 0
    //   95: pop
    //   96: aload_3
    //   97: invokeinterface 628 1 0
    //   102: ifne +184 -> 286
    //   105: new 528	android/content/ContentValues
    //   108: dup
    //   109: invokespecial 529	android/content/ContentValues:<init>	()V
    //   112: astore 5
    //   114: aload 5
    //   116: ldc_w 553
    //   119: aload_3
    //   120: aload_3
    //   121: ldc_w 553
    //   124: invokeinterface 632 2 0
    //   129: invokeinterface 270 2 0
    //   134: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: invokevirtual 636	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
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
    //   161: invokeinterface 632 2 0
    //   166: invokeinterface 640 2 0
    //   171: invokevirtual 643	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: iload_1
    //   175: iconst_1
    //   176: iadd
    //   177: istore_1
    //   178: goto -36 -> 142
    //   181: aload_2
    //   182: aload 5
    //   184: invokevirtual 192	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   187: pop
    //   188: aload_3
    //   189: invokeinterface 646 1 0
    //   194: pop
    //   195: goto -99 -> 96
    //   198: astore_2
    //   199: goto +55 -> 254
    //   202: astore 4
    //   204: ldc 170
    //   206: getstatic 175	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   209: iconst_1
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload 4
    //   217: aastore
    //   218: invokestatic 278	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   221: aload_3
    //   222: ifnull +94 -> 316
    //   225: aload_3
    //   226: invokeinterface 273 1 0
    //   231: goto +85 -> 316
    //   234: astore_3
    //   235: ldc 170
    //   237: getstatic 175	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   240: iconst_1
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: aload_3
    //   247: aastore
    //   248: invokestatic 278	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   251: goto +65 -> 316
    //   254: aload_3
    //   255: ifnull +29 -> 284
    //   258: aload_3
    //   259: invokeinterface 273 1 0
    //   264: goto +20 -> 284
    //   267: astore_3
    //   268: ldc 170
    //   270: getstatic 175	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   273: iconst_1
    //   274: anewarray 4	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: aload_3
    //   280: aastore
    //   281: invokestatic 278	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   284: aload_2
    //   285: athrow
    //   286: aload_3
    //   287: ifnull +29 -> 316
    //   290: aload_3
    //   291: invokeinterface 273 1 0
    //   296: goto +20 -> 316
    //   299: astore_3
    //   300: ldc 170
    //   302: getstatic 175	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   305: iconst_1
    //   306: anewarray 4	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: aload_3
    //   312: aastore
    //   313: invokestatic 278	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   316: aload_0
    //   317: monitorexit
    //   318: aload_2
    //   319: areturn
    //   320: aload_0
    //   321: monitorexit
    //   322: aconst_null
    //   323: areturn
    //   324: astore_2
    //   325: aload_0
    //   326: monitorexit
    //   327: goto +5 -> 332
    //   330: aload_2
    //   331: athrow
    //   332: goto -2 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	AbstractDbCacheManager
    //   141	37	1	i	int
    //   7	175	2	localArrayList	ArrayList
    //   198	121	2	localArrayList1	ArrayList<ContentValues>
    //   324	7	2	localObject1	Object
    //   24	202	3	localObject2	Object
    //   234	25	3	localException1	Exception
    //   267	24	3	localException2	Exception
    //   299	13	3	localException3	Exception
    //   72	86	4	arrayOfString	String[]
    //   202	14	4	localException4	Exception
    //   112	71	5	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   89	96	198	finally
    //   96	140	198	finally
    //   142	174	198	finally
    //   181	195	198	finally
    //   204	221	198	finally
    //   89	96	202	java/lang/Exception
    //   96	140	202	java/lang/Exception
    //   142	174	202	java/lang/Exception
    //   181	195	202	java/lang/Exception
    //   225	231	234	java/lang/Exception
    //   258	264	267	java/lang/Exception
    //   290	296	299	java/lang/Exception
    //   10	25	324	finally
    //   29	36	324	finally
    //   39	85	324	finally
    //   225	231	324	finally
    //   235	251	324	finally
    //   258	264	324	finally
    //   268	284	324	finally
    //   284	286	324	finally
    //   290	296	324	finally
    //   300	316	324	finally
    //   316	318	324	finally
    //   320	322	324	finally
    //   325	327	324	finally
  }
  
  protected abstract void a();
  
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
  
  protected boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBCacheDataWrapper$DbCreator != null;
  }
  
  /* Error */
  protected boolean a(int paramInt, String paramString, String[] paramArrayOfString, java.util.Collection<? extends IDBCacheDataWrapper> paramCollection)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 79	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload 4
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: iconst_1
    //   18: invokespecial 408	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore 8
    //   23: aload 8
    //   25: ifnonnull +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: getstatic 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:c	Z
    //   33: ifeq +80 -> 113
    //   36: getstatic 491	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   39: istore 5
    //   41: new 98	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   48: astore 9
    //   50: aload 9
    //   52: ldc_w 651
    //   55: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 9
    //   61: aload_0
    //   62: getfield 67	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 9
    //   71: ldc_w 653
    //   74: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 9
    //   80: iload_1
    //   81: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 9
    //   87: ldc_w 497
    //   90: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 9
    //   96: aload_2
    //   97: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc 170
    //   103: iload 5
    //   105: aload 9
    //   107: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 314	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: invokestatic 474	com/tencent/mobileqq/app/SQLiteDatabase:beginTransactionLog	()V
    //   116: aload 8
    //   118: invokestatic 281	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   121: aload_0
    //   122: aload 8
    //   124: iload_1
    //   125: aload_2
    //   126: aload_3
    //   127: invokevirtual 655	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;ILjava/lang/String;[Ljava/lang/String;)V
    //   130: aload 4
    //   132: invokeinterface 658 1 0
    //   137: astore_2
    //   138: aload_2
    //   139: invokeinterface 341 1 0
    //   144: ifeq +59 -> 203
    //   147: aload_2
    //   148: invokeinterface 345 1 0
    //   153: checkcast 531	com/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper
    //   156: astore_3
    //   157: aload_3
    //   158: ifnonnull +6 -> 164
    //   161: goto -23 -> 138
    //   164: aload_0
    //   165: aload 8
    //   167: aload_3
    //   168: invokevirtual 660	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper;)J
    //   171: lstore 6
    //   173: lload 6
    //   175: ldc2_w 121
    //   178: lcmp
    //   179: ifne -41 -> 138
    //   182: aload 8
    //   184: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   187: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   190: iconst_0
    //   191: ireturn
    //   192: astore_2
    //   193: aload_0
    //   194: ldc_w 482
    //   197: aload_2
    //   198: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: iconst_0
    //   202: ireturn
    //   203: aload 8
    //   205: invokevirtual 295	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   208: aload 8
    //   210: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   213: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   216: goto +12 -> 228
    //   219: astore_2
    //   220: aload_0
    //   221: ldc_w 482
    //   224: aload_2
    //   225: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload_0
    //   229: invokespecial 499	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:d	()V
    //   232: iconst_1
    //   233: ireturn
    //   234: astore_2
    //   235: goto +33 -> 268
    //   238: astore_2
    //   239: aload_0
    //   240: ldc_w 662
    //   243: aload_2
    //   244: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload 8
    //   249: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   252: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   255: iconst_0
    //   256: ireturn
    //   257: astore_2
    //   258: aload_0
    //   259: ldc_w 482
    //   262: aload_2
    //   263: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   266: iconst_0
    //   267: ireturn
    //   268: aload 8
    //   270: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   273: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   276: goto +12 -> 288
    //   279: astore_3
    //   280: aload_0
    //   281: ldc_w 482
    //   284: aload_3
    //   285: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   288: goto +5 -> 293
    //   291: aload_2
    //   292: athrow
    //   293: goto -2 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	AbstractDbCacheManager
    //   0	296	1	paramInt	int
    //   0	296	2	paramString	String
    //   0	296	3	paramArrayOfString	String[]
    //   0	296	4	paramCollection	java.util.Collection<? extends IDBCacheDataWrapper>
    //   39	65	5	i	int
    //   171	3	6	l	long
    //   21	248	8	localSQLiteDatabase	SQLiteDatabase
    //   48	58	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   182	190	192	java/lang/Throwable
    //   208	216	219	java/lang/Throwable
    //   113	138	234	finally
    //   138	157	234	finally
    //   164	173	234	finally
    //   203	208	234	finally
    //   239	247	234	finally
    //   113	138	238	java/lang/Throwable
    //   138	157	238	java/lang/Throwable
    //   164	173	238	java/lang/Throwable
    //   203	208	238	java/lang/Throwable
    //   247	255	257	java/lang/Throwable
    //   268	276	279	java/lang/Throwable
  }
  
  /* Error */
  public boolean a(int paramInt, String paramString, String[] paramArrayOfString, IDBCacheDataWrapper... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 79	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload 4
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: iconst_1
    //   18: invokespecial 408	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore 8
    //   23: aload 8
    //   25: ifnonnull +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: getstatic 488	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:c	Z
    //   33: ifeq +80 -> 113
    //   36: getstatic 491	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   39: istore 5
    //   41: new 98	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   48: astore 9
    //   50: aload 9
    //   52: ldc_w 651
    //   55: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 9
    //   61: aload_0
    //   62: getfield 67	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 9
    //   71: ldc_w 653
    //   74: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 9
    //   80: iload_1
    //   81: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 9
    //   87: ldc_w 497
    //   90: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 9
    //   96: aload_2
    //   97: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc 170
    //   103: iload 5
    //   105: aload 9
    //   107: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 314	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: invokestatic 474	com/tencent/mobileqq/app/SQLiteDatabase:beginTransactionLog	()V
    //   116: aload 8
    //   118: invokestatic 281	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   121: aload_0
    //   122: aload 8
    //   124: iload_1
    //   125: aload_2
    //   126: aload_3
    //   127: invokevirtual 655	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;ILjava/lang/String;[Ljava/lang/String;)V
    //   130: aload 4
    //   132: arraylength
    //   133: istore 5
    //   135: iconst_0
    //   136: istore_1
    //   137: goto +142 -> 279
    //   140: aload_0
    //   141: aload 8
    //   143: aload_2
    //   144: invokevirtual 660	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;Lcom/tencent/mobileqq/qcircle/api/db/IDBCacheDataWrapper;)J
    //   147: lstore 6
    //   149: lload 6
    //   151: ldc2_w 121
    //   154: lcmp
    //   155: ifne +24 -> 179
    //   158: aload 8
    //   160: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   163: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   166: iconst_0
    //   167: ireturn
    //   168: astore_2
    //   169: aload_0
    //   170: ldc_w 482
    //   173: aload_2
    //   174: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: iconst_0
    //   178: ireturn
    //   179: iload_1
    //   180: iconst_1
    //   181: iadd
    //   182: istore_1
    //   183: goto +96 -> 279
    //   186: aload 8
    //   188: invokevirtual 295	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   191: aload 8
    //   193: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   196: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   199: goto +12 -> 211
    //   202: astore_2
    //   203: aload_0
    //   204: ldc_w 482
    //   207: aload_2
    //   208: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   211: aload_0
    //   212: invokespecial 499	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:d	()V
    //   215: iconst_1
    //   216: ireturn
    //   217: astore_2
    //   218: goto +33 -> 251
    //   221: astore_2
    //   222: aload_0
    //   223: ldc_w 662
    //   226: aload_2
    //   227: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload 8
    //   232: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   235: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   238: iconst_0
    //   239: ireturn
    //   240: astore_2
    //   241: aload_0
    //   242: ldc_w 482
    //   245: aload_2
    //   246: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   249: iconst_0
    //   250: ireturn
    //   251: aload 8
    //   253: invokevirtual 292	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   256: invokestatic 480	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   259: goto +12 -> 271
    //   262: astore_3
    //   263: aload_0
    //   264: ldc_w 482
    //   267: aload_3
    //   268: invokespecial 484	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: goto +5 -> 276
    //   274: aload_2
    //   275: athrow
    //   276: goto -2 -> 274
    //   279: iload_1
    //   280: iload 5
    //   282: if_icmpge -96 -> 186
    //   285: aload 4
    //   287: iload_1
    //   288: aaload
    //   289: astore_2
    //   290: aload_2
    //   291: ifnonnull -151 -> 140
    //   294: goto -115 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	AbstractDbCacheManager
    //   0	297	1	paramInt	int
    //   0	297	2	paramString	String
    //   0	297	3	paramArrayOfString	String[]
    //   0	297	4	paramVarArgs	IDBCacheDataWrapper[]
    //   39	244	5	i	int
    //   147	3	6	l	long
    //   21	231	8	localSQLiteDatabase	SQLiteDatabase
    //   48	58	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   158	166	168	java/lang/Throwable
    //   191	199	202	java/lang/Throwable
    //   113	135	217	finally
    //   140	149	217	finally
    //   186	191	217	finally
    //   222	230	217	finally
    //   113	135	221	java/lang/Throwable
    //   140	149	221	java/lang/Throwable
    //   186	191	221	java/lang/Throwable
    //   230	238	240	java/lang/Throwable
    //   251	259	262	java/lang/Throwable
  }
  
  final String b()
  {
    return a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  protected abstract void b();
  
  public void close()
  {
    c();
    a();
  }
  
  /* Error */
  public void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 668	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:c	()V
    //   4: aload_0
    //   5: invokespecial 673	java/lang/Object:finalize	()V
    //   8: return
    //   9: astore_1
    //   10: goto +23 -> 33
    //   13: astore_1
    //   14: ldc 170
    //   16: getstatic 175	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: aastore
    //   27: invokestatic 278	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   30: goto -26 -> 4
    //   33: aload_0
    //   34: invokespecial 673	java/lang/Object:finalize	()V
    //   37: goto +5 -> 42
    //   40: aload_1
    //   41: athrow
    //   42: goto -2 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	AbstractDbCacheManager
    //   9	1	1	localObject	Object
    //   13	28	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   14	30	9	finally
    //   0	4	13	java/lang/Exception
  }
  
  public boolean isClosed()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.AbstractDbCacheManager
 * JD-Core Version:    0.7.0.1
 */