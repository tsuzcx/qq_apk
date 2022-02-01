package com.tencent.mobileqq.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.Ability;

public abstract class EntityManagerFactory
{
  protected static final String CLOSE_EXCEPTION_MSG = "The EntityManagerFactory has been already closed";
  protected static final int FLAG_CHECK_AUTHENTICATION = -1;
  public static long corruptedTime = -1L;
  protected boolean closed;
  protected SQLiteOpenHelper dbHelper;
  protected int mDBVersion = 0;
  protected ISQLiteOpenHelper mInnerDbHelper;
  protected String mName;
  public String name;
  protected String tag = "EntityManagerFactory";
  
  public EntityManagerFactory(String paramString)
  {
    this.dbHelper = build(paramString);
    this.mName = paramString;
    this.name = paramString;
  }
  
  protected EntityManagerFactory(String paramString, int paramInt)
  {
    this.mName = paramString;
    this.name = paramString;
    this.mDBVersion = paramInt;
  }
  
  /* Error */
  public static String getSqliteLibraryVersion()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aconst_null
    //   5: astore_0
    //   6: aconst_null
    //   7: astore_3
    //   8: ldc 55
    //   10: aconst_null
    //   11: invokestatic 61	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 4
    //   16: aload_3
    //   17: astore_2
    //   18: aload_1
    //   19: astore_0
    //   20: aload 4
    //   22: astore_1
    //   23: aload 4
    //   25: ldc 63
    //   27: aconst_null
    //   28: invokevirtual 67	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore 5
    //   33: ldc 69
    //   35: astore_3
    //   36: aload 5
    //   38: astore_2
    //   39: aload 5
    //   41: astore_0
    //   42: aload 4
    //   44: astore_1
    //   45: aload 5
    //   47: invokeinterface 75 1 0
    //   52: ifeq +78 -> 130
    //   55: aload 5
    //   57: astore_2
    //   58: aload 5
    //   60: astore_0
    //   61: aload 4
    //   63: astore_1
    //   64: new 77	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   71: astore 6
    //   73: aload 5
    //   75: astore_2
    //   76: aload 5
    //   78: astore_0
    //   79: aload 4
    //   81: astore_1
    //   82: aload 6
    //   84: aload_3
    //   85: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 5
    //   91: astore_2
    //   92: aload 5
    //   94: astore_0
    //   95: aload 4
    //   97: astore_1
    //   98: aload 6
    //   100: aload 5
    //   102: iconst_0
    //   103: invokeinterface 86 2 0
    //   108: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 5
    //   114: astore_2
    //   115: aload 5
    //   117: astore_0
    //   118: aload 4
    //   120: astore_1
    //   121: aload 6
    //   123: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_3
    //   127: goto -91 -> 36
    //   130: aload 5
    //   132: ifnull +10 -> 142
    //   135: aload 5
    //   137: invokeinterface 92 1 0
    //   142: aload_3
    //   143: astore_0
    //   144: aload 4
    //   146: ifnull +65 -> 211
    //   149: aload 4
    //   151: invokevirtual 93	android/database/sqlite/SQLiteDatabase:close	()V
    //   154: aload_3
    //   155: areturn
    //   156: astore_0
    //   157: aload 4
    //   159: astore_3
    //   160: aload_0
    //   161: astore 4
    //   163: goto +13 -> 176
    //   166: astore_2
    //   167: aconst_null
    //   168: astore_1
    //   169: goto +45 -> 214
    //   172: astore 4
    //   174: aconst_null
    //   175: astore_3
    //   176: aload_2
    //   177: astore_0
    //   178: aload_3
    //   179: astore_1
    //   180: ldc 95
    //   182: iconst_1
    //   183: ldc 97
    //   185: aload 4
    //   187: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: aload_2
    //   191: ifnull +9 -> 200
    //   194: aload_2
    //   195: invokeinterface 92 1 0
    //   200: aload_3
    //   201: ifnull +7 -> 208
    //   204: aload_3
    //   205: invokevirtual 93	android/database/sqlite/SQLiteDatabase:close	()V
    //   208: ldc 105
    //   210: astore_0
    //   211: aload_0
    //   212: areturn
    //   213: astore_2
    //   214: aload_0
    //   215: ifnull +9 -> 224
    //   218: aload_0
    //   219: invokeinterface 92 1 0
    //   224: aload_1
    //   225: ifnull +7 -> 232
    //   228: aload_1
    //   229: invokevirtual 93	android/database/sqlite/SQLiteDatabase:close	()V
    //   232: goto +5 -> 237
    //   235: aload_2
    //   236: athrow
    //   237: goto -2 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	139	0	localObject1	Object
    //   156	5	0	localThrowable1	java.lang.Throwable
    //   177	42	0	localObject2	Object
    //   3	226	1	localObject3	Object
    //   1	114	2	localObject4	Object
    //   166	29	2	localObject5	Object
    //   213	23	2	localObject6	Object
    //   7	198	3	localObject7	Object
    //   14	148	4	localObject8	Object
    //   172	14	4	localThrowable2	java.lang.Throwable
    //   31	105	5	localCursor	android.database.Cursor
    //   71	51	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   23	33	156	java/lang/Throwable
    //   45	55	156	java/lang/Throwable
    //   64	73	156	java/lang/Throwable
    //   82	89	156	java/lang/Throwable
    //   98	112	156	java/lang/Throwable
    //   121	127	156	java/lang/Throwable
    //   8	16	166	finally
    //   8	16	172	java/lang/Throwable
    //   23	33	213	finally
    //   45	55	213	finally
    //   64	73	213	finally
    //   82	89	213	finally
    //   98	112	213	finally
    //   121	127	213	finally
    //   180	190	213	finally
  }
  
  public abstract SQLiteOpenHelper build(String paramString);
  
  protected void checkTableColumnChange(String paramString, SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  protected void cleanOverDueCorruptDatabase() {}
  
  public void close()
  {
    if (!this.closed)
    {
      this.closed = true;
      this.dbHelper.close();
      return;
    }
    throw new IllegalStateException("The EntityManagerFactory has been already closed");
  }
  
  protected abstract void createDatabase(SQLiteDatabase paramSQLiteDatabase);
  
  public EntityManager createEntityManager()
  {
    if (!this.closed)
    {
      OGEntityManager localOGEntityManager = new OGEntityManager(this.dbHelper, this.mName);
      this.closed = false;
      return localOGEntityManager;
    }
    throw new IllegalStateException("The EntityManagerFactory has been already closed");
  }
  
  protected void doAfterUpgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  protected abstract String getPackageName();
  
  protected boolean isNeedEncrypt()
  {
    return true;
  }
  
  public boolean isOpen()
  {
    return this.closed ^ true;
  }
  
  protected abstract void upgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  
  public boolean verifyAuthentication()
  {
    if (this.name.matches("^[0-9]*$"))
    {
      EntityManager localEntityManager = createEntityManager();
      Ability localAbility = (Ability)localEntityManager.find(Ability.class, "flags=?", new String[] { String.valueOf(-1) });
      if (localAbility == null)
      {
        localAbility = new Ability();
        localAbility.flags = -1;
        localAbility.uin = this.name;
        localEntityManager.persistOrReplace(localAbility);
      }
      else if ((localAbility.uin == null) || (!localAbility.uin.equals(this.name)))
      {
        this.mInnerDbHelper.a();
        localAbility = new Ability();
        localAbility.flags = -1;
        localAbility.uin = this.name;
        localEntityManager.persistOrReplace(localAbility);
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */