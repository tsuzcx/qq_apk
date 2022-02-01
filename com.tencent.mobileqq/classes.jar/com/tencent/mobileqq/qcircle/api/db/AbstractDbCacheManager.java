package com.tencent.mobileqq.qcircle.api.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.db.util.EncryptUtil;
import com.tencent.mobileqq.qcircle.api.db.util.SecurityUtil;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import cooperation.qzone.LocalMultiProcConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import mqq.app.MobileQQ;

public abstract class AbstractDbCacheManager
{
  private static final String DB_CACHE_VERSION = "_cache_db_version";
  public static final int DB_TYPE_NONUPDATE = 0;
  public static final int DB_TYPE_UPDATE = 1;
  private static final String ID = "_id";
  public static final int LOCAL_PHOTO_DB_UIN = -1;
  public static final String TAG = "QCircleDbCacheDatabase.CacheManager";
  public static final String TAG_TEST = "QCircleDbCacheDatabase.CacheManager.Database_Test";
  public static final String TAG_TEST_STACK = "QCircleDbCacheDatabase.CacheManager.Database_Test_Stack";
  private static boolean logEnable = false;
  public static boolean printTestLog = false;
  public static boolean printTestLogStack = false;
  private volatile boolean hasOOMError = false;
  private boolean mClosed = false;
  private DbCacheDatabase mDataBase;
  protected IDBCacheDataWrapper.DbCreator mDataCreator;
  private String mDbName = null;
  private int mDbType;
  private ArrayList<IDBCacheDataWrapper.Structure> mStructureList = new ArrayList();
  protected String mTable;
  private boolean mTableCreated;
  private long mUin;
  
  protected AbstractDbCacheManager(Context paramContext, Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    paramContext = paramContext.getApplicationContext();
    this.mDbName = generateDbName(paramLong, paramInt1);
    this.mDataBase = DbCacheDatabase.getInstance(paramContext, this.mDbName, paramInt2, paramInt3);
    this.mDataBase.attach(hashCode());
    this.mUin = paramLong;
    this.mDbType = paramInt1;
    this.mTable = paramString;
    initiate(paramClass);
    updateOrCreateTable();
  }
  
  public static void beginTransaction(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null) {
      return;
    }
    if (DbCacheDatabase.isOpenWal)
    {
      paramSQLiteDatabase.beginTransactionNonExclusive();
      return;
    }
    paramSQLiteDatabase.beginTransaction();
  }
  
  private void checkTableVersion()
  {
    if (!isDataCreatorValid()) {
      return;
    }
    int i = this.mDataCreator.version();
    int j = LocalMultiProcConfig.getInt4Uin(this.mTable + "_cache_db_version", -1, this.mUin);
    android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
    if ((j == -1) || (j != i))
    {
      localSQLiteDatabase = getSQLiteDataBase(true);
      if (localSQLiteDatabase == null) {}
    }
    try
    {
      deleteTable(localSQLiteDatabase);
      LocalMultiProcConfig.putInt4Uin(this.mTable + "_cache_db_version", i, this.mUin);
      saveTableVersion(this.mTable + "_cache_db_version", i);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        localSQLException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void closeInternal()
  {
    if (isClosed()) {
      return;
    }
    try
    {
      if (isClosed()) {
        return;
      }
    }
    finally {}
    this.mDataBase.detach(hashCode());
    this.mClosed = true;
  }
  
  private void createTableIfNeeded(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null) {
      RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, "db is null,create table fail.");
    }
    while (this.mTableCreated) {
      return;
    }
    try
    {
      Object localObject = generateSqlForCreate();
      if (RFLog.isColorLevel()) {
        RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.CLR, "create table sql:" + (String)localObject);
      }
      if (printTestLog) {
        RFLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test", RFLog.CLR, "create table sql:" + (String)localObject);
      }
      paramSQLiteDatabase.execSQL((String)localObject);
      localObject = generateSqlForIndex();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(";");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i];
          if (RFLog.isColorLevel()) {
            RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.CLR, "create index sql:" + str);
          }
          paramSQLiteDatabase.execSQL(str);
          i += 1;
        }
      }
      this.mTableCreated = true;
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "createTableIfNeeded error", paramSQLiteDatabase });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "createTableIfNeeded error", paramSQLiteDatabase });
    }
  }
  
  private void deleteTable(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    String str = generateSqlForDrop();
    paramSQLiteDatabase.execSQL(str);
    this.mTableCreated = false;
    if (RFLog.isColorLevel()) {
      RFLog.i("QCircleDbCacheDatabase.CacheManager", RFLog.CLR, "deleteTable sql:" + str);
    }
  }
  
  private void dropTempTable(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    String str = this.mTable + "_temp";
    str = "DROP TABLE IF EXISTS " + str;
    paramSQLiteDatabase.execSQL(str);
    if (RFLog.isColorLevel()) {
      RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, "dropTable sql:" + str);
    }
  }
  
  public static String generateDbName(long paramLong, int paramInt)
  {
    if (paramInt == DbCacheService.DB_TYPE_NORMAL)
    {
      if (MobileQQ.sMobileQQ != null) {
        return SecurityUtil.encrypt(paramLong + "_qcircle_" + MobileQQ.sMobileQQ.getQQProcessName());
      }
      return SecurityUtil.encrypt(paramLong + "_qcircle");
    }
    if ((paramInt == DbCacheService.DB_TYPE_PERSISTED) && (paramLong == -1L)) {
      return SecurityUtil.encrypt(String.valueOf(paramLong));
    }
    if (paramInt == DbCacheService.DB_TYPE_PICTURE) {
      return SecurityUtil.encrypt(String.valueOf(-paramLong));
    }
    return SecurityUtil.encrypt(String.valueOf(paramInt + paramLong));
  }
  
  private String generateSqlForCreate()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + this.mTable + " (");
    localStringBuilder.append("_id INTEGER PRIMARY KEY");
    Iterator localIterator = this.mStructureList.iterator();
    while (localIterator.hasNext())
    {
      IDBCacheDataWrapper.Structure localStructure = (IDBCacheDataWrapper.Structure)localIterator.next();
      localStringBuilder.append(',');
      localStringBuilder.append(localStructure.mName);
      localStringBuilder.append(' ');
      localStringBuilder.append(localStructure.mType);
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  private String generateSqlForDrop()
  {
    return "DROP TABLE IF EXISTS " + this.mTable;
  }
  
  private String generateSqlForIndex()
  {
    if ((this.mDataCreator == null) || (!(this.mDataCreator instanceof IDBCacheDataWrapper.RawDbCreator))) {
      return null;
    }
    try
    {
      String str = ((IDBCacheDataWrapper.RawDbCreator)this.mDataCreator).indexRawSql(this.mTable);
      return str;
    }
    catch (Exception localException)
    {
      RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, localException.getMessage());
    }
    return null;
  }
  
  private android.database.sqlite.SQLiteDatabase getSQLiteDataBase(boolean paramBoolean)
  {
    if (isClosed()) {
      return null;
    }
    return this.mDataBase.getSQLiteDataBase(paramBoolean);
  }
  
  private void handleException(String paramString, Throwable paramThrowable)
  {
    RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, paramString + paramThrowable.getMessage());
    try
    {
      DbCacheExceptionHandler.getInstance().handleException(paramThrowable, this.mDbName);
      return;
    }
    catch (Throwable paramString)
    {
      RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, paramString.getMessage());
    }
  }
  
  private void initiate(Class<? extends IDBCacheDataWrapper> paramClass)
  {
    String str = paramClass.getName();
    try
    {
      paramClass = (IDBCacheDataWrapper.DbCreator)paramClass.getField("DB_CREATOR").get(null);
      if (paramClass == null) {
        return;
      }
    }
    catch (Throwable paramClass)
    {
      do
      {
        for (;;)
        {
          RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, paramClass.getMessage());
          paramClass = null;
        }
        this.mDataCreator = paramClass;
        paramClass = paramClass.structure();
        if (paramClass != null)
        {
          int j = paramClass.length;
          int i = 0;
          while (i < j)
          {
            Object localObject = paramClass[i];
            if (localObject != null) {
              this.mStructureList.add(localObject);
            }
            i += 1;
          }
        }
      } while (this.mStructureList.size() != 0);
      throw new AbstractDbCacheManager.BadCacheDataException("CacheData protocol requires a valid CacheData.Structure from CacheData.Creator object called  CREATOR on class " + str);
    }
  }
  
  private boolean isTableExist(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    localObject = null;
    localSQLiteDatabase = null;
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='" + paramString + "'", null);
      if (paramSQLiteDatabase == null) {
        break label238;
      }
      localSQLiteDatabase = paramSQLiteDatabase;
      localObject = paramSQLiteDatabase;
      if (paramSQLiteDatabase.getCount() <= 0) {
        break label238;
      }
      localSQLiteDatabase = paramSQLiteDatabase;
      localObject = paramSQLiteDatabase;
      paramSQLiteDatabase.moveToFirst();
      localSQLiteDatabase = paramSQLiteDatabase;
      localObject = paramSQLiteDatabase;
      int i = paramSQLiteDatabase.getInt(0);
      if (i != 1) {
        break label238;
      }
      bool = true;
    }
    catch (Exception paramSQLiteDatabase)
    {
      localObject = localSQLiteDatabase;
      RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "", paramSQLiteDatabase });
      if (localSQLiteDatabase == null) {
        break label170;
      }
      try
      {
        localSQLiteDatabase.close();
        return false;
      }
      catch (Exception paramSQLiteDatabase)
      {
        RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "", paramSQLiteDatabase });
        return false;
      }
    }
    finally
    {
      for (;;)
      {
        if (localObject != null) {}
        try
        {
          ((Cursor)localObject).close();
          throw paramSQLiteDatabase;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "", paramString });
          }
        }
        boolean bool = false;
      }
    }
    if (paramSQLiteDatabase != null) {}
    try
    {
      paramSQLiteDatabase.close();
      return bool;
    }
    catch (Exception paramSQLiteDatabase)
    {
      RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "", paramSQLiteDatabase });
      return bool;
    }
  }
  
  private void notifyDataChanged()
  {
    onChanged();
  }
  
  private void printTestLog(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, long paramLong)
  {
    if ((printTestLog) || (paramLong > 50L))
    {
      RFLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test", RFLog.USR, "db:" + paramString1 + " table:" + paramString2 + " selection:" + paramString3 + " args:" + Arrays.toString(paramArrayOfString));
      RFLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test", RFLog.USR, "timecost: " + paramLong);
    }
    if ((printTestLogStack) || (paramLong > 50L)) {
      RFLog.i("QCircleDbCacheDatabase.CacheManager.Database_Test_Stack", RFLog.USR, Log.getStackTraceString(new Throwable()));
    }
  }
  
  private void renameTable(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    String str = this.mTable + "_temp";
    str = "ALTER TABLE " + this.mTable + " RENAME TO " + str;
    paramSQLiteDatabase.execSQL(str);
    this.mTableCreated = false;
    if (RFLog.isColorLevel()) {
      RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, "remaneTable sql:" + str);
    }
  }
  
  /* Error */
  private void saveTableVersion(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 447	java/io/File
    //   9: dup
    //   10: ldc_w 449
    //   13: invokestatic 454	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokespecial 455	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 7
    //   21: aload 7
    //   23: invokevirtual 458	java/io/File:exists	()Z
    //   26: ifne +9 -> 35
    //   29: aload 7
    //   31: invokevirtual 461	java/io/File:createNewFile	()Z
    //   34: pop
    //   35: new 463	java/io/BufferedInputStream
    //   38: dup
    //   39: new 465	java/io/FileInputStream
    //   42: dup
    //   43: aload 7
    //   45: invokespecial 468	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 471	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore_3
    //   52: sipush 8192
    //   55: newarray byte
    //   57: astore 4
    //   59: iconst_m1
    //   60: aload_3
    //   61: aload 4
    //   63: invokevirtual 475	java/io/BufferedInputStream:read	([B)I
    //   66: if_icmpne +96 -> 162
    //   69: new 477	org/json/JSONObject
    //   72: dup
    //   73: invokespecial 478	org/json/JSONObject:<init>	()V
    //   76: astore 4
    //   78: aload 4
    //   80: aload_1
    //   81: iload_2
    //   82: invokevirtual 482	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   85: pop
    //   86: new 484	java/io/BufferedOutputStream
    //   89: dup
    //   90: new 486	java/io/FileOutputStream
    //   93: dup
    //   94: aload 7
    //   96: invokespecial 487	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   99: invokespecial 490	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   102: astore_1
    //   103: aload_1
    //   104: aload 4
    //   106: invokevirtual 491	org/json/JSONObject:toString	()Ljava/lang/String;
    //   109: invokevirtual 495	java/lang/String:getBytes	()[B
    //   112: invokevirtual 499	java/io/BufferedOutputStream:write	([B)V
    //   115: aload_1
    //   116: invokevirtual 502	java/io/BufferedOutputStream:flush	()V
    //   119: aload_3
    //   120: invokestatic 507	com/tencent/mobileqq/qcircle/api/db/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   123: pop
    //   124: aload_1
    //   125: invokestatic 507	com/tencent/mobileqq/qcircle/api/db/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   128: pop
    //   129: return
    //   130: astore_3
    //   131: ldc 21
    //   133: getstatic 188	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   136: new 141	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 509
    //   146: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_3
    //   150: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 194	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: goto -124 -> 35
    //   162: new 477	org/json/JSONObject
    //   165: dup
    //   166: new 230	java/lang/String
    //   169: dup
    //   170: aload 4
    //   172: invokespecial 514	java/lang/String:<init>	([B)V
    //   175: invokespecial 515	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   178: astore 4
    //   180: goto -102 -> 78
    //   183: astore 4
    //   185: aload_3
    //   186: astore_1
    //   187: aload 5
    //   189: astore_3
    //   190: ldc 21
    //   192: getstatic 188	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   195: new 141	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 517
    //   205: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 4
    //   210: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 194	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_1
    //   220: invokestatic 507	com/tencent/mobileqq/qcircle/api/db/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   223: pop
    //   224: aload_3
    //   225: invokestatic 507	com/tencent/mobileqq/qcircle/api/db/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   228: pop
    //   229: return
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_3
    //   233: aload 6
    //   235: astore 4
    //   237: aload_3
    //   238: invokestatic 507	com/tencent/mobileqq/qcircle/api/db/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   241: pop
    //   242: aload 4
    //   244: invokestatic 507	com/tencent/mobileqq/qcircle/api/db/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   247: pop
    //   248: aload_1
    //   249: athrow
    //   250: astore_1
    //   251: aload 6
    //   253: astore 4
    //   255: goto -18 -> 237
    //   258: astore 5
    //   260: aload_1
    //   261: astore 4
    //   263: aload 5
    //   265: astore_1
    //   266: goto -29 -> 237
    //   269: astore 4
    //   271: aload_1
    //   272: astore 5
    //   274: aload 4
    //   276: astore_1
    //   277: aload_3
    //   278: astore 4
    //   280: aload 5
    //   282: astore_3
    //   283: goto -46 -> 237
    //   286: astore 4
    //   288: aconst_null
    //   289: astore_1
    //   290: aload 5
    //   292: astore_3
    //   293: goto -103 -> 190
    //   296: astore 4
    //   298: aload_3
    //   299: astore 5
    //   301: aload_1
    //   302: astore_3
    //   303: aload 5
    //   305: astore_1
    //   306: goto -116 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	AbstractDbCacheManager
    //   0	309	1	paramString	String
    //   0	309	2	paramInt	int
    //   51	69	3	localBufferedInputStream	java.io.BufferedInputStream
    //   130	56	3	localException1	Exception
    //   189	114	3	localObject1	Object
    //   57	122	4	localObject2	Object
    //   183	26	4	localException2	Exception
    //   235	27	4	localObject3	Object
    //   269	6	4	localObject4	Object
    //   278	1	4	localObject5	Object
    //   286	1	4	localException3	Exception
    //   296	1	4	localException4	Exception
    //   4	184	5	localObject6	Object
    //   258	6	5	localObject7	Object
    //   272	32	5	localObject8	Object
    //   1	251	6	localObject9	Object
    //   19	76	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   29	35	130	java/lang/Exception
    //   52	78	183	java/lang/Exception
    //   78	103	183	java/lang/Exception
    //   162	180	183	java/lang/Exception
    //   35	52	230	finally
    //   52	78	250	finally
    //   78	103	250	finally
    //   162	180	250	finally
    //   103	119	258	finally
    //   190	219	269	finally
    //   35	52	286	java/lang/Exception
    //   103	119	296	java/lang/Exception
  }
  
  static String uniqueKey(long paramLong, int paramInt, String paramString)
  {
    return String.valueOf(paramLong) + "_" + paramString + "_" + paramInt;
  }
  
  private void updateOrCreateTable()
  {
    if (!isDataCreatorValid()) {}
    int j;
    IQZoneService localIQZoneService;
    int i;
    android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      j = this.mDataCreator.version();
      localIQZoneService = QCircleServiceImpl.getQZoneService();
      if (localIQZoneService == null) {
        break label709;
      }
      i = LocalMultiProcConfig.getInt4Uin(this.mDbName + this.mTable + "_cache_db_version", -1, this.mUin);
      if (i != -1) {
        break;
      }
      i = LocalMultiProcConfig.getInt4Uin(this.mTable + "_cache_db_version", -1, this.mUin);
      if (RFLog.isColorLevel()) {
        RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "mDbName:", this.mDbName, " mTable:", this.mTable, " preVersion:", Integer.valueOf(i), " version:", Integer.valueOf(j) });
      }
      localSQLiteDatabase = getSQLiteDataBase(true);
    } while (localSQLiteDatabase == null);
    boolean bool;
    for (;;)
    {
      try
      {
        if (!isTableExist(localSQLiteDatabase, this.mTable)) {
          break label692;
        }
        if ((i == -1) || (i == j) || (!(this.mDataCreator instanceof IDBCacheDataWrapper.UpdateDbCreator))) {
          break label714;
        }
        Object localObject = ((IDBCacheDataWrapper.UpdateDbCreator)this.mDataCreator).onUpdate(i, j);
        if ((localObject == null) || (localObject.length <= 0)) {
          break label701;
        }
        localCharSequence = localObject[0];
        if (TextUtils.isEmpty(localCharSequence)) {
          break label701;
        }
        if ((localCharSequence.startsWith("ALTER")) || (localCharSequence.startsWith("DELETE")))
        {
          bool = updateTable(localSQLiteDatabase, (String[])localObject);
          label292:
          if (!bool) {
            break label640;
          }
          this.mTableCreated = true;
          label301:
          createTableIfNeeded(localSQLiteDatabase);
          long l = System.currentTimeMillis();
          if ((this.mDataCreator instanceof IDBCacheDataWrapper.UpdateDbCreator))
          {
            if (!((IDBCacheDataWrapper.UpdateDbCreator)this.mDataCreator).needEncrypt(i, j)) {
              break label658;
            }
            localObject = queryDatas();
            updateDatas((ArrayList)localObject);
            if (RFLog.isColorLevel()) {
              RFLog.i("QCircleDbCacheDatabase.CacheManager", RFLog.USR, "encrypt success mTableName:" + this.mTable + " datasize:" + ((ArrayList)localObject).size() + " timecost:" + (System.currentTimeMillis() - l));
            }
          }
          label418:
          if ((i == j) || (localIQZoneService == null)) {
            break;
          }
          LocalMultiProcConfig.putInt4Uin(this.mDbName + this.mTable + "_cache_db_version", j, this.mUin);
          return;
        }
      }
      catch (Exception localException2)
      {
        CharSequence localCharSequence;
        for (;;)
        {
          RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "updateOrCreateTable error", localException2 });
          try
          {
            deleteTable(localSQLiteDatabase);
            dropTempTable(localSQLiteDatabase);
            createTableIfNeeded(localSQLiteDatabase);
            if ((i == j) || (localIQZoneService == null)) {
              break;
            }
            LocalMultiProcConfig.putInt4Uin(this.mDbName + this.mTable + "_cache_db_version", j, this.mUin);
            return;
          }
          catch (Exception localException1)
          {
            RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "updateOrCreateTable error", localException1 });
            return;
          }
        }
        if (localCharSequence.startsWith("INSERT"))
        {
          renameTable(localSQLiteDatabase);
          createTableIfNeeded(localSQLiteDatabase);
          bool = updateTable(localSQLiteDatabase, localException2);
          dropTempTable(localSQLiteDatabase);
          continue;
        }
        if (!localCharSequence.startsWith("NOTHING")) {
          break label701;
        }
      }
      bool = true;
      continue;
      label640:
      deleteTable(localSQLiteDatabase);
    }
    for (;;)
    {
      deleteTable(localSQLiteDatabase);
      break label301;
      label658:
      RFLog.i("QCircleDbCacheDatabase.CacheManager", RFLog.USR, "encrypt success mTableName:" + this.mTable);
      break label418;
      label692:
      createTableIfNeeded(localSQLiteDatabase);
      break label418;
      label701:
      bool = false;
      break label292;
      break;
      label709:
      i = -1;
      break;
      label714:
      if (i != -1) {
        if (i == j) {
          break label301;
        }
      }
    }
  }
  
  private boolean updateTable(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString)
  {
    try
    {
      beginTransaction(paramSQLiteDatabase);
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (!TextUtils.isEmpty(str))
        {
          paramSQLiteDatabase.execSQL(str);
          if (RFLog.isColorLevel()) {
            RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, "updateTable sql:" + str);
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      return true;
    }
    catch (Exception paramArrayOfString)
    {
      RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { "updateTable1 error", paramArrayOfString });
      return false;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void close()
  {
    closeInternal();
    onClosed();
  }
  
  public int delete(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (((this.mDataCreator instanceof IDBCacheDataWrapper.RawDbCreator)) && (paramArrayOfString == null)) {
      return ((IDBCacheDataWrapper.RawDbCreator)this.mDataCreator).delRawSql(paramSQLiteDatabase, this.mTable, paramString);
    }
    this.mDataBase.getEncryptor().convertWhereValues(this.mDbName, this.mTable, paramString, paramArrayOfString);
    long l = System.currentTimeMillis();
    int i = paramSQLiteDatabase.delete(this.mTable, paramString, paramArrayOfString);
    printTestLog(this.mDbName, this.mTable, paramString, paramArrayOfString, System.currentTimeMillis() - l);
    return i;
  }
  
  public int delete(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (isClosed()) {}
    android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
    do
    {
      return 0;
      localSQLiteDatabase = getSQLiteDataBase(true);
    } while (localSQLiteDatabase == null);
    try
    {
      int j = delete(localSQLiteDatabase, paramString, paramArrayOfString);
      i = j;
    }
    catch (Throwable paramArrayOfString)
    {
      for (;;)
      {
        handleException("fail to delete data", paramArrayOfString);
      }
    }
    if (logEnable) {
      RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.DEV, "delete--table:" + this.mTable + ",deleted:" + i + ",where:" + paramString);
    }
    notifyDataChanged();
    return i;
  }
  
  /* Error */
  @Deprecated
  protected int delete(Collection<String> paramCollection)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: invokevirtual 179	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:isClosed	()Z
    //   6: ifeq +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_0
    //   12: iconst_1
    //   13: invokespecial 160	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:getSQLiteDataBase	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 5
    //   18: aload 5
    //   20: ifnull -11 -> 9
    //   23: invokestatic 662	com/tencent/mobileqq/app/SQLiteDatabase:beginTransactionLog	()V
    //   26: aload 5
    //   28: invokestatic 601	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:beginTransaction	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   31: aload_1
    //   32: invokeinterface 665 1 0
    //   37: astore 4
    //   39: iconst_0
    //   40: istore_2
    //   41: aload 4
    //   43: invokeinterface 310 1 0
    //   48: ifeq +28 -> 76
    //   51: iload_2
    //   52: aload_0
    //   53: aload 5
    //   55: aload 4
    //   57: invokeinterface 314 1 0
    //   62: checkcast 230	java/lang/String
    //   65: aconst_null
    //   66: invokevirtual 640	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:delete	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)I
    //   69: iadd
    //   70: istore_3
    //   71: iload_3
    //   72: istore_2
    //   73: goto -32 -> 41
    //   76: aload 5
    //   78: invokevirtual 609	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   81: aload 5
    //   83: invokevirtual 606	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   86: invokestatic 668	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   89: getstatic 50	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:logEnable	Z
    //   92: ifeq +54 -> 146
    //   95: ldc 21
    //   97: getstatic 643	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   100: new 141	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 645
    //   110: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 102	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:mTable	Ljava/lang/String;
    //   117: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 647
    //   123: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: iload_2
    //   127: invokevirtual 524	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc_w 649
    //   133: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 210	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_0
    //   147: invokespecial 651	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:notifyDataChanged	()V
    //   150: iload_2
    //   151: ireturn
    //   152: astore 4
    //   154: aload_0
    //   155: ldc_w 670
    //   158: aload 4
    //   160: invokespecial 655	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:handleException	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: goto -74 -> 89
    //   166: astore 4
    //   168: aload_0
    //   169: ldc_w 653
    //   172: aload 4
    //   174: invokespecial 655	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:handleException	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: aload 5
    //   179: invokevirtual 606	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   182: invokestatic 668	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   185: goto -96 -> 89
    //   188: astore 4
    //   190: aload_0
    //   191: ldc_w 670
    //   194: aload 4
    //   196: invokespecial 655	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:handleException	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   199: goto -110 -> 89
    //   202: astore_1
    //   203: aload 5
    //   205: invokevirtual 606	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   208: invokestatic 668	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   211: aload_1
    //   212: athrow
    //   213: astore 4
    //   215: aload_0
    //   216: ldc_w 670
    //   219: aload 4
    //   221: invokespecial 655	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:handleException	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: goto -13 -> 211
    //   227: astore 4
    //   229: goto -61 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	AbstractDbCacheManager
    //   0	232	1	paramCollection	Collection<String>
    //   1	150	2	i	int
    //   70	2	3	j	int
    //   37	19	4	localIterator	Iterator
    //   152	7	4	localThrowable1	Throwable
    //   166	7	4	localThrowable2	Throwable
    //   188	7	4	localThrowable3	Throwable
    //   213	7	4	localThrowable4	Throwable
    //   227	1	4	localThrowable5	Throwable
    //   16	188	5	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   81	89	152	java/lang/Throwable
    //   23	39	166	java/lang/Throwable
    //   177	185	188	java/lang/Throwable
    //   23	39	202	finally
    //   41	71	202	finally
    //   76	81	202	finally
    //   168	177	202	finally
    //   203	211	213	java/lang/Throwable
    //   41	71	227	java/lang/Throwable
    //   76	81	227	java/lang/Throwable
  }
  
  protected void delete(long paramLong)
  {
    if (paramLong == 0L)
    {
      delete(null, null);
      return;
    }
    delete("_id=?", new String[] { String.valueOf(paramLong) });
  }
  
  protected void drop()
  {
    if (isClosed()) {}
    android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = getSQLiteDataBase(true);
    } while (localSQLiteDatabase == null);
    if (logEnable) {
      RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.DEV, "drop--table:" + this.mTable);
    }
    try
    {
      deleteTable(localSQLiteDatabase);
      notifyDataChanged();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        handleException("fail to drop data", localThrowable);
      }
    }
  }
  
  protected void execSQL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        return;
      } while (isClosed());
      localSQLiteDatabase = getSQLiteDataBase(true);
    } while (localSQLiteDatabase == null);
    try
    {
      if (RFLog.isColorLevel()) {
        RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.CLR, "execSQL--sql:" + paramString);
      }
      long l = System.currentTimeMillis();
      localSQLiteDatabase.execSQL(paramString);
      printTestLog(this.mDbName, this.mTable, paramString, null, System.currentTimeMillis() - l);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        handleException("fail to execSQL for " + paramString, localThrowable);
      }
    }
    notifyDataChanged();
  }
  
  public void finalize()
  {
    try
    {
      closeInternal();
      return;
    }
    catch (Exception localException)
    {
      RFLog.e("QCircleDbCacheDatabase.CacheManager", RFLog.USR, new Object[] { localException });
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  protected IDBCacheDataWrapper get(Cursor paramCursor, int paramInt)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {}
    while ((paramInt < 0) || (paramInt >= paramCursor.getCount()) || (!paramCursor.moveToPosition(paramInt)) || (!isDataCreatorValid())) {
      return null;
    }
    Object localObject = paramCursor;
    if (!(paramCursor instanceof DbSafeCursorWrapper)) {
      localObject = new DbSafeCursorWrapper(paramCursor, this.mDbName);
    }
    try
    {
      paramCursor = this.mDataCreator.createFromCursor((Cursor)localObject);
      return paramCursor;
    }
    catch (OutOfMemoryError paramCursor)
    {
      for (;;)
      {
        if (!this.hasOOMError)
        {
          this.hasOOMError = true;
          localObject = getSQLiteDataBase(true);
          if (localObject == null) {}
        }
        try
        {
          deleteTable((android.database.sqlite.SQLiteDatabase)localObject);
          createTableIfNeeded((android.database.sqlite.SQLiteDatabase)localObject);
          RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, paramCursor.getMessage());
          paramCursor = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, localException.getMessage());
          }
        }
      }
    }
    catch (Throwable paramCursor)
    {
      for (;;)
      {
        RFLog.w("QCircleDbCacheDatabase.CacheManager", RFLog.USR, paramCursor.getMessage());
        paramCursor = null;
      }
    }
  }
  
  protected Cursor getCursor(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3)
  {
    return getCursorWithColumn(null, paramString1, paramArrayOfString, paramString2, paramString3);
  }
  
  protected Cursor getCursorWithColumn(String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, String paramString4)
  {
    String[] arrayOfString = null;
    if (paramString1 != null)
    {
      arrayOfString = new String[1];
      arrayOfString[0] = paramString1;
    }
    return getCursorWithColumns(arrayOfString, paramString2, paramArrayOfString, paramString3, paramString4);
  }
  
  protected Cursor getCursorWithColumns(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3)
  {
    if (isClosed()) {
      return null;
    }
    android.database.sqlite.SQLiteDatabase localSQLiteDatabase = getSQLiteDataBase(false);
    if (localSQLiteDatabase == null) {
      return null;
    }
    if (RFLog.isColorLevel()) {
      RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.CLR, "query begin, table=" + this.mTable + ", selection=" + paramString1 + ", sortOrder=" + paramString2 + ", limit=" + paramString3 + ", args: " + Arrays.toString(paramArrayOfString2));
    }
    if (paramString2 == null) {}
    label240:
    for (;;)
    {
      try
      {
        if (isDataCreatorValid())
        {
          paramString2 = this.mDataCreator.sortOrder();
          this.mDataBase.getEncryptor().convertWhereValues(this.mDbName, this.mTable, paramString1, paramArrayOfString2);
          long l = System.currentTimeMillis();
          paramArrayOfString1 = localSQLiteDatabase.query(this.mTable, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, paramString3);
          return null;
        }
      }
      catch (Throwable paramArrayOfString2)
      {
        try
        {
          printTestLog(this.mDbName, this.mTable, paramString1, paramArrayOfString2, System.currentTimeMillis() - l);
          if (paramArrayOfString1 == null) {
            break label240;
          }
          return new DbSafeCursorWrapper(paramArrayOfString1, this.mDbName);
        }
        catch (Throwable paramArrayOfString2)
        {
          continue;
        }
        paramArrayOfString2 = paramArrayOfString2;
        paramArrayOfString1 = null;
        handleException("fail to obtain cursor for " + paramString1, paramArrayOfString2);
      }
    }
  }
  
  public String getDbName()
  {
    return this.mDbName;
  }
  
  protected long getId(Cursor paramCursor, int paramInt)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {}
    while ((paramInt < 0) || (paramInt >= paramCursor.getCount()) || (!paramCursor.moveToPosition(paramInt))) {
      return 0L;
    }
    return paramCursor.getLong(paramCursor.getColumnIndex("_id"));
  }
  
  final long getUin()
  {
    return this.mUin;
  }
  
  final long insert(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, IDBCacheDataWrapper paramIDBCacheDataWrapper)
  {
    ContentValues localContentValues = new ContentValues();
    paramIDBCacheDataWrapper.writeTo(localContentValues);
    return paramSQLiteDatabase.replaceOrThrow(this.mTable, null, this.mDataBase.getEncryptor().convertContentValues(this.mDbName, this.mTable, localContentValues));
  }
  
  public boolean isClosed()
  {
    return this.mClosed;
  }
  
  protected boolean isDataCreatorValid()
  {
    return this.mDataCreator != null;
  }
  
  protected abstract void onChanged();
  
  protected abstract void onClosed();
  
  protected void prepareForSave(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString, String[] paramArrayOfString)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    }
    delete(paramSQLiteDatabase, paramString, paramArrayOfString);
  }
  
  /* Error */
  public ArrayList<ContentValues> queryDatas()
  {
    // Byte code:
    //   0: new 67	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 68	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 88	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:mDataBase	Lcom/tencent/mobileqq/qcircle/api/db/DbCacheDatabase;
    //   14: invokevirtual 626	com/tencent/mobileqq/qcircle/api/db/DbCacheDatabase:getEncryptor	()Lcom/tencent/mobileqq/qcircle/api/db/util/EncryptUtil;
    //   17: aload_0
    //   18: getfield 102	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:mTable	Ljava/lang/String;
    //   21: invokevirtual 773	com/tencent/mobileqq/qcircle/api/db/util/EncryptUtil:getTableInfo	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +10 -> 36
    //   29: aload_3
    //   30: invokevirtual 375	java/util/ArrayList:size	()I
    //   33: ifne +7 -> 40
    //   36: aload_0
    //   37: monitorexit
    //   38: aconst_null
    //   39: areturn
    //   40: aload_3
    //   41: invokevirtual 776	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   44: checkcast 67	java/util/ArrayList
    //   47: astore_3
    //   48: aload_3
    //   49: iconst_0
    //   50: ldc 16
    //   52: invokevirtual 779	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   55: aload_3
    //   56: aload_3
    //   57: invokevirtual 375	java/util/ArrayList:size	()I
    //   60: anewarray 230	java/lang/String
    //   63: invokevirtual 783	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   66: checkcast 785	[Ljava/lang/String;
    //   69: checkcast 785	[Ljava/lang/String;
    //   72: astore 4
    //   74: aload_0
    //   75: aload 4
    //   77: aconst_null
    //   78: aconst_null
    //   79: aconst_null
    //   80: aconst_null
    //   81: invokevirtual 717	com/tencent/mobileqq/qcircle/api/db/AbstractDbCacheManager:getCursorWithColumns	([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore_3
    //   85: aload_3
    //   86: ifnull +143 -> 229
    //   89: aload_3
    //   90: invokeinterface 400 1 0
    //   95: pop
    //   96: aload_3
    //   97: invokeinterface 788 1 0
    //   102: ifne +127 -> 229
    //   105: new 752	android/content/ContentValues
    //   108: dup
    //   109: invokespecial 753	android/content/ContentValues:<init>	()V
    //   112: astore 5
    //   114: aload 5
    //   116: ldc 16
    //   118: aload_3
    //   119: aload_3
    //   120: ldc 16
    //   122: invokeinterface 743 2 0
    //   127: invokeinterface 404 2 0
    //   132: invokestatic 541	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: invokevirtual 791	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   138: iconst_1
    //   139: istore_1
    //   140: iload_1
    //   141: aload 4
    //   143: arraylength
    //   144: if_icmpge +35 -> 179
    //   147: aload 5
    //   149: aload 4
    //   151: iload_1
    //   152: aaload
    //   153: aload_3
    //   154: aload_3
    //   155: aload 4
    //   157: iload_1
    //   158: aaload
    //   159: invokeinterface 743 2 0
    //   164: invokeinterface 795 2 0
    //   169: invokevirtual 798	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: iload_1
    //   173: iconst_1
    //   174: iadd
    //   175: istore_1
    //   176: goto -36 -> 140
    //   179: aload_2
    //   180: aload 5
    //   182: invokevirtual 372	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   185: pop
    //   186: aload_3
    //   187: invokeinterface 801 1 0
    //   192: pop
    //   193: goto -97 -> 96
    //   196: astore 4
    //   198: ldc 21
    //   200: getstatic 188	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   203: iconst_1
    //   204: anewarray 4	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: aload 4
    //   211: aastore
    //   212: invokestatic 241	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   215: aload_3
    //   216: ifnull +9 -> 225
    //   219: aload_3
    //   220: invokeinterface 407 1 0
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_2
    //   228: areturn
    //   229: aload_3
    //   230: ifnull -5 -> 225
    //   233: aload_3
    //   234: invokeinterface 407 1 0
    //   239: goto -14 -> 225
    //   242: astore_3
    //   243: ldc 21
    //   245: getstatic 188	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   248: iconst_1
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload_3
    //   255: aastore
    //   256: invokestatic 241	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   259: goto -34 -> 225
    //   262: astore_2
    //   263: aload_0
    //   264: monitorexit
    //   265: aload_2
    //   266: athrow
    //   267: astore_3
    //   268: ldc 21
    //   270: getstatic 188	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   273: iconst_1
    //   274: anewarray 4	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: aload_3
    //   280: aastore
    //   281: invokestatic 241	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   284: goto -59 -> 225
    //   287: astore_2
    //   288: aload_3
    //   289: ifnull +9 -> 298
    //   292: aload_3
    //   293: invokeinterface 407 1 0
    //   298: aload_2
    //   299: athrow
    //   300: astore_3
    //   301: ldc 21
    //   303: getstatic 188	com/tencent/biz/richframework/delegate/impl/RFLog:USR	I
    //   306: iconst_1
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: aload_3
    //   313: aastore
    //   314: invokestatic 241	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   317: goto -19 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	AbstractDbCacheManager
    //   139	37	1	i	int
    //   7	221	2	localArrayList	ArrayList
    //   262	4	2	localObject1	Object
    //   287	12	2	localObject2	Object
    //   24	210	3	localObject3	Object
    //   242	13	3	localException1	Exception
    //   267	26	3	localException2	Exception
    //   300	13	3	localException3	Exception
    //   72	84	4	arrayOfString	String[]
    //   196	14	4	localException4	Exception
    //   112	69	5	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   89	96	196	java/lang/Exception
    //   96	138	196	java/lang/Exception
    //   140	172	196	java/lang/Exception
    //   179	193	196	java/lang/Exception
    //   233	239	242	java/lang/Exception
    //   10	25	262	finally
    //   29	36	262	finally
    //   36	38	262	finally
    //   40	85	262	finally
    //   219	225	262	finally
    //   225	227	262	finally
    //   233	239	262	finally
    //   243	259	262	finally
    //   263	265	262	finally
    //   268	284	262	finally
    //   292	298	262	finally
    //   298	300	262	finally
    //   301	317	262	finally
    //   219	225	267	java/lang/Exception
    //   89	96	287	finally
    //   96	138	287	finally
    //   140	172	287	finally
    //   179	193	287	finally
    //   198	215	287	finally
    //   292	298	300	java/lang/Exception
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return null;
      } while (isClosed());
      localObject = getSQLiteDataBase(false);
    } while (localObject == null);
    if (logEnable) {
      RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.DEV, "rawQuery--sql:" + paramString);
    }
    for (;;)
    {
      try
      {
        l = System.currentTimeMillis();
        localObject = ((android.database.sqlite.SQLiteDatabase)localObject).rawQuery(paramString, paramArrayOfString);
      }
      catch (Throwable paramArrayOfString)
      {
        try
        {
          long l;
          printTestLog(this.mDbName, this.mTable, paramString, paramArrayOfString, System.currentTimeMillis() - l);
          if (localObject == null) {
            break;
          }
          return new DbSafeCursorWrapper((Cursor)localObject, this.mDbName);
        }
        catch (Throwable paramArrayOfString)
        {
          for (;;)
          {
            paramString = (String)localObject;
          }
        }
        paramArrayOfString = paramArrayOfString;
        paramString = null;
      }
      handleException("fail to rawQuery obtain cursor for ", paramArrayOfString);
      localObject = paramString;
    }
  }
  
  protected boolean save(int paramInt, String paramString, String[] paramArrayOfString, Collection<? extends IDBCacheDataWrapper> paramCollection)
  {
    if (isClosed()) {
      return false;
    }
    if (paramCollection == null) {
      return false;
    }
    localSQLiteDatabase = getSQLiteDataBase(true);
    if (localSQLiteDatabase == null) {
      return false;
    }
    if (logEnable) {
      RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.DEV, "save--table:" + this.mTable + ",strategy:" + paramInt + ",where:" + paramString);
    }
    try
    {
      com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
      beginTransaction(localSQLiteDatabase);
      prepareForSave(localSQLiteDatabase, paramInt, paramString, paramArrayOfString);
      paramString = paramCollection.iterator();
      for (;;)
      {
        if (paramString.hasNext())
        {
          paramArrayOfString = (IDBCacheDataWrapper)paramString.next();
          if (paramArrayOfString != null)
          {
            long l = insert(localSQLiteDatabase, paramArrayOfString);
            if (l == -1L) {
              try
              {
                localSQLiteDatabase.endTransaction();
                com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
                return false;
              }
              catch (Throwable paramString)
              {
                for (;;)
                {
                  handleException("fail to end transaction", paramString);
                }
              }
            }
          }
        }
      }
      localSQLiteDatabase.setTransactionSuccessful();
      try
      {
        localSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        notifyDataChanged();
        return true;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          handleException("fail to end transaction", paramString);
        }
      }
      try
      {
        localSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        throw paramString;
      }
      catch (Throwable paramArrayOfString)
      {
        for (;;)
        {
          handleException("fail to end transaction", paramArrayOfString);
        }
      }
    }
    catch (Throwable paramString)
    {
      paramString = paramString;
      handleException("fail to save data", paramString);
      try
      {
        localSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        return false;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          handleException("fail to end transaction", paramString);
        }
      }
    }
    finally {}
  }
  
  public boolean save(int paramInt, String paramString, String[] paramArrayOfString, IDBCacheDataWrapper... paramVarArgs)
  {
    if (isClosed()) {}
    android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        return false;
      } while (paramVarArgs == null);
      localSQLiteDatabase = getSQLiteDataBase(true);
    } while (localSQLiteDatabase == null);
    if (logEnable) {
      RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.DEV, "save--table:" + this.mTable + ",strategy:" + paramInt + ",where:" + paramString);
    }
    int i;
    try
    {
      com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
      beginTransaction(localSQLiteDatabase);
      prepareForSave(localSQLiteDatabase, paramInt, paramString, paramArrayOfString);
      i = paramVarArgs.length;
      paramInt = 0;
      break label233;
    }
    catch (Throwable paramString)
    {
      long l;
      paramString = paramString;
      handleException("fail to save data", paramString);
      try
      {
        localSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        return false;
      }
      catch (Throwable paramString)
      {
        handleException("fail to end transaction", paramString);
        return false;
      }
    }
    finally {}
    l = insert(localSQLiteDatabase, paramString);
    if (l == -1L) {
      try
      {
        localSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        return false;
      }
      catch (Throwable paramString)
      {
        handleException("fail to end transaction", paramString);
        return false;
      }
    }
    label233:
    label253:
    for (;;)
    {
      localSQLiteDatabase.setTransactionSuccessful();
      try
      {
        localSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        notifyDataChanged();
        return true;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          handleException("fail to end transaction", paramString);
        }
      }
      try
      {
        localSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        throw paramString;
      }
      catch (Throwable paramArrayOfString)
      {
        for (;;)
        {
          handleException("fail to end transaction", paramArrayOfString);
        }
      }
      for (;;)
      {
        if (paramInt >= i) {
          break label253;
        }
        paramString = paramVarArgs[paramInt];
        if (paramString != null) {
          break;
        }
        paramInt += 1;
      }
    }
  }
  
  final String uniqueKey()
  {
    return uniqueKey(this.mUin, this.mDbType, this.mTable);
  }
  
  protected int update(ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int k = 0;
    int i = 0;
    int j;
    if (isClosed()) {
      j = i;
    }
    android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        do
        {
          return j;
          j = i;
        } while (paramContentValues == null);
        localSQLiteDatabase = getSQLiteDataBase(true);
        j = i;
      } while (localSQLiteDatabase == null);
      i = k;
      for (;;)
      {
        try
        {
          com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
          i = k;
          beginTransaction(localSQLiteDatabase);
          i = k;
          j = update(localSQLiteDatabase, paramContentValues, paramString, paramArrayOfString);
          i = j;
          localSQLiteDatabase.setTransactionSuccessful();
        }
        catch (Throwable paramContentValues)
        {
          paramContentValues = paramContentValues;
          handleException("fail to update data", paramContentValues);
          try
          {
            localSQLiteDatabase.endTransaction();
            com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
          }
          catch (Throwable paramContentValues)
          {
            handleException("fail to end transaction", paramContentValues);
          }
          continue;
        }
        finally {}
        try
        {
          localSQLiteDatabase.endTransaction();
          com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
          i = j;
        }
        catch (Throwable paramContentValues)
        {
          handleException("fail to end transaction", paramContentValues);
          i = j;
        }
      }
      if (logEnable) {
        RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.DEV, "update--table:" + this.mTable + ",updated:" + i + ",where:" + paramString);
      }
      j = i;
    } while (i <= 0);
    notifyDataChanged();
    return i;
    try
    {
      localSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      throw paramContentValues;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        handleException("fail to end transaction", paramString);
      }
    }
  }
  
  final int update(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (paramContentValues == null) {
      return 0;
    }
    long l = System.currentTimeMillis();
    this.mDataBase.getEncryptor().convertWhereValues(this.mDbName, this.mTable, paramString, paramArrayOfString);
    printTestLog(this.mDbName, this.mTable, paramString, paramArrayOfString, System.currentTimeMillis() - l);
    return paramSQLiteDatabase.update(this.mTable, this.mDataBase.getEncryptor().convertContentValues(this.mDbName, this.mTable, paramContentValues), paramString, paramArrayOfString);
  }
  
  @Deprecated
  final int update(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, IDBCacheDataWrapper paramIDBCacheDataWrapper, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    paramIDBCacheDataWrapper.writeTo(localContentValues);
    long l = System.currentTimeMillis();
    printTestLog(this.mDbName, this.mTable, paramString, null, System.currentTimeMillis() - l);
    return paramSQLiteDatabase.update(this.mTable, this.mDataBase.getEncryptor().convertContentValues(this.mDbName, this.mTable, localContentValues), paramString, null);
  }
  
  final int update(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString, String[] paramArrayOfString3)
  {
    ContentValues localContentValues = new ContentValues();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      localContentValues.put(paramArrayOfString1[i], paramArrayOfString2[i]);
      i += 1;
    }
    long l = System.currentTimeMillis();
    this.mDataBase.getEncryptor().convertWhereValues(this.mDbName, this.mTable, paramString, paramArrayOfString3);
    printTestLog(this.mDbName, this.mTable, paramString, paramArrayOfString3, System.currentTimeMillis() - l);
    return paramSQLiteDatabase.update(this.mTable, this.mDataBase.getEncryptor().convertContentValues(this.mDbName, this.mTable, localContentValues), paramString, paramArrayOfString3);
  }
  
  protected int update(IDBCacheDataWrapper paramIDBCacheDataWrapper, String paramString, String[] paramArrayOfString)
  {
    if (paramIDBCacheDataWrapper == null) {
      return 0;
    }
    ContentValues localContentValues = new ContentValues();
    paramIDBCacheDataWrapper.writeTo(localContentValues);
    return update(localContentValues, paramString, paramArrayOfString);
  }
  
  public int update(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    if (isClosed()) {}
    android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        return 0;
      } while ((TextUtils.isEmpty(paramString1)) || (paramArrayOfString1 == null) || (paramArrayOfString1.length == 0) || (TextUtils.isEmpty(paramString2)) || (paramArrayOfString2 == null) || (paramArrayOfString2.length == 0) || (paramArrayOfString1.length != paramArrayOfString2.length));
      localSQLiteDatabase = getSQLiteDataBase(true);
    } while (localSQLiteDatabase == null);
    for (;;)
    {
      try
      {
        com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
        beginTransaction(localSQLiteDatabase);
        paramString2 = paramString2 + "=?";
        int j = 0;
        i = 0;
        if (j < paramArrayOfString1.length)
        {
          String str1 = paramArrayOfString1[j];
          String str2 = paramArrayOfString2[j];
          i += update(localSQLiteDatabase, new String[] { paramString1 }, new String[] { str1 }, paramString2, new String[] { str2 });
          j += 1;
          continue;
        }
        localSQLiteDatabase.setTransactionSuccessful();
      }
      catch (Throwable paramString1)
      {
        int i;
        paramString1 = paramString1;
        handleException("fail to update data", paramString1);
        try
        {
          localSQLiteDatabase.endTransaction();
          com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
          i = 0;
        }
        catch (Throwable paramString1)
        {
          handleException("fail to end transaction", paramString1);
          i = 0;
        }
        continue;
      }
      finally {}
      try
      {
        localSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        if (logEnable) {
          RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.DEV, "update--table:" + this.mTable + ",updated:" + i);
        }
        if (i > 0) {
          notifyDataChanged();
        }
        return i;
      }
      catch (Throwable paramString1)
      {
        handleException("fail to end transaction", paramString1);
      }
    }
    try
    {
      localSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      throw paramString1;
    }
    catch (Throwable paramArrayOfString1)
    {
      for (;;)
      {
        handleException("fail to end transaction", paramArrayOfString1);
      }
    }
  }
  
  protected int update(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString, String[] paramArrayOfString3)
  {
    int j;
    if (isClosed()) {
      j = 0;
    }
    for (;;)
    {
      return j;
      if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length != paramArrayOfString2.length)) {
        return 0;
      }
      if ((paramArrayOfString3 != null) && (paramArrayOfString3.length != paramArrayOfString1.length)) {
        return 0;
      }
      android.database.sqlite.SQLiteDatabase localSQLiteDatabase = getSQLiteDataBase(true);
      if (localSQLiteDatabase == null) {
        return 0;
      }
      try
      {
        com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
        beginTransaction(localSQLiteDatabase);
        i = update(localSQLiteDatabase, paramArrayOfString1, paramArrayOfString2, paramString, paramArrayOfString3);
      }
      catch (Throwable paramArrayOfString1)
      {
        for (;;)
        {
          int i;
          handleException("fail to update data", paramArrayOfString1);
          try
          {
            localSQLiteDatabase.endTransaction();
            com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
          }
          catch (Throwable paramArrayOfString1)
          {
            handleException("fail to end transaction", paramArrayOfString1);
          }
        }
      }
      finally
      {
        try
        {
          localSQLiteDatabase.endTransaction();
          com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
          throw paramArrayOfString1;
        }
        catch (Throwable paramArrayOfString2)
        {
          for (;;)
          {
            handleException("fail to end transaction", paramArrayOfString2);
          }
        }
      }
    }
  }
  
  final int update2(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (paramContentValues == null) {
      return 0;
    }
    long l = System.currentTimeMillis();
    int i = paramSQLiteDatabase.update(this.mTable, paramContentValues, paramString, paramArrayOfString);
    printTestLog(this.mDbName, this.mTable, paramString, paramArrayOfString, System.currentTimeMillis() - l);
    return i;
  }
  
  protected int update2(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString, String[] paramArrayOfString3)
  {
    if (isClosed()) {}
    do
    {
      do
      {
        return 0;
      } while ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length != paramArrayOfString2.length) || (!TextUtils.isEmpty(paramString)) || (paramArrayOfString3 != null) || ((TextUtils.isEmpty(paramString)) && (paramArrayOfString3 != null)));
      localSQLiteDatabase = getSQLiteDataBase(true);
    } while (localSQLiteDatabase == null);
    try
    {
      com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
      beginTransaction(localSQLiteDatabase);
      if ((!TextUtils.isEmpty(paramString)) || (paramArrayOfString3 != null)) {
        break label175;
      }
      i = update(localSQLiteDatabase, paramArrayOfString1, paramArrayOfString2, null, null);
    }
    catch (Throwable paramArrayOfString1)
    {
      for (;;)
      {
        int i;
        label175:
        handleException("fail to update data", paramArrayOfString1);
        try
        {
          localSQLiteDatabase.endTransaction();
          com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
          i = 0;
        }
        catch (Throwable paramArrayOfString1)
        {
          handleException("fail to end transaction", paramArrayOfString1);
          i = 0;
        }
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          localSQLiteDatabase.endTransaction();
          com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
          throw paramArrayOfString1;
        }
        catch (Throwable paramArrayOfString2)
        {
          handleException("fail to end transaction", paramArrayOfString2);
        }
      }
    }
    localSQLiteDatabase.setTransactionSuccessful();
    try
    {
      localSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      if (logEnable) {
        RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.DEV, "update--table:" + this.mTable + ",updated:" + i + ",where:" + paramString);
      }
      if (i > 0) {
        notifyDataChanged();
      }
      return i;
      String str = paramString + "=?";
      int j = 0;
      i = 0;
      while (j < paramArrayOfString3.length)
      {
        int k = update(localSQLiteDatabase, paramArrayOfString1, paramArrayOfString2, str, new String[] { paramArrayOfString3[j] });
        i += k;
        j += 1;
      }
    }
    catch (Throwable paramArrayOfString1)
    {
      for (;;)
      {
        handleException("fail to end transaction", paramArrayOfString1);
      }
    }
  }
  
  public int updateDatas(ArrayList<ContentValues> paramArrayList)
  {
    if (isClosed()) {}
    android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        return 0;
      } while ((paramArrayList == null) || (paramArrayList.size() == 0));
      localSQLiteDatabase = getSQLiteDataBase(true);
    } while (localSQLiteDatabase == null);
    for (;;)
    {
      try
      {
        com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
        beginTransaction(localSQLiteDatabase);
        int j = 0;
        i = 0;
        if (j < paramArrayList.size())
        {
          i += update(localSQLiteDatabase, (ContentValues)paramArrayList.get(j), "_id=?", new String[] { ((ContentValues)paramArrayList.get(j)).getAsString("_id") });
          j += 1;
          continue;
        }
        localSQLiteDatabase.setTransactionSuccessful();
      }
      catch (Throwable paramArrayList)
      {
        int i;
        paramArrayList = paramArrayList;
        handleException("fail to update data", paramArrayList);
        try
        {
          localSQLiteDatabase.endTransaction();
          com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
          i = 0;
        }
        catch (Throwable paramArrayList)
        {
          handleException("fail to end transaction", paramArrayList);
          i = 0;
        }
        continue;
      }
      finally {}
      try
      {
        localSQLiteDatabase.endTransaction();
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        if (logEnable) {
          RFLog.d("QCircleDbCacheDatabase.CacheManager", RFLog.DEV, "update--table:" + this.mTable + ",updated:" + i + ",where:");
        }
        return i;
      }
      catch (Throwable paramArrayList)
      {
        handleException("fail to end transaction", paramArrayList);
      }
    }
    try
    {
      localSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      throw paramArrayList;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        handleException("fail to end transaction", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.AbstractDbCacheManager
 * JD-Core Version:    0.7.0.1
 */