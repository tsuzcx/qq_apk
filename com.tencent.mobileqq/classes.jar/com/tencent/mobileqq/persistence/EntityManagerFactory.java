package com.tencent.mobileqq.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.Ability;

public abstract class EntityManagerFactory
{
  protected static final String CLOSE_EXCEPTION_MSG = "The EntityManagerFactory has been already closed";
  protected static final int FLAG_CHECK_AUTHENTICATION = -1;
  public static long corruptedTime = -1L;
  public String TAG = "EntityManagerFactory";
  protected boolean closed;
  protected SQLiteOpenHelper dbHelper = build(paramString);
  protected EntityManagerFactory.SQLiteOpenHelperImpl mInnerDbHelper;
  protected String mName;
  public String name;
  
  public EntityManagerFactory(String paramString)
  {
    this.mName = paramString;
    this.name = paramString;
  }
  
  /* Error */
  public static String getSqliteLibraryVersion()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_0
    //   6: ldc 53
    //   8: astore_3
    //   9: ldc 55
    //   11: aconst_null
    //   12: invokestatic 61	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: aload 4
    //   19: astore_0
    //   20: aload_2
    //   21: astore_1
    //   22: aload_0
    //   23: ldc 63
    //   25: aconst_null
    //   26: invokevirtual 67	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: invokeinterface 73 1 0
    //   38: ifeq +33 -> 71
    //   41: aload_2
    //   42: astore_1
    //   43: new 75	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   50: aload_3
    //   51: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: iconst_0
    //   56: invokeinterface 84 2 0
    //   61: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore_3
    //   68: goto -38 -> 30
    //   71: aload_2
    //   72: ifnull +9 -> 81
    //   75: aload_2
    //   76: invokeinterface 90 1 0
    //   81: aload_3
    //   82: astore_1
    //   83: aload_0
    //   84: ifnull +9 -> 93
    //   87: aload_0
    //   88: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   91: aload_3
    //   92: astore_1
    //   93: aload_1
    //   94: areturn
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: ldc 93
    //   100: astore_3
    //   101: ldc 95
    //   103: iconst_1
    //   104: ldc 97
    //   106: aload_2
    //   107: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload_1
    //   111: ifnull +9 -> 120
    //   114: aload_1
    //   115: invokeinterface 90 1 0
    //   120: aload_3
    //   121: astore_1
    //   122: aload_0
    //   123: ifnull -30 -> 93
    //   126: aload_0
    //   127: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   130: ldc 93
    //   132: areturn
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_0
    //   136: aload_1
    //   137: ifnull +9 -> 146
    //   140: aload_1
    //   141: invokeinterface 90 1 0
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   154: aload_2
    //   155: athrow
    //   156: astore_2
    //   157: goto -21 -> 136
    //   160: astore_2
    //   161: goto -25 -> 136
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_1
    //   167: goto -69 -> 98
    //   170: astore_3
    //   171: aload_2
    //   172: astore_1
    //   173: aload_3
    //   174: astore_2
    //   175: goto -77 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	146	0	localObject1	Object
    //   1	172	1	localObject2	Object
    //   3	73	2	localCursor	android.database.Cursor
    //   95	12	2	localThrowable1	java.lang.Throwable
    //   133	22	2	localObject3	Object
    //   156	1	2	localObject4	Object
    //   160	1	2	localObject5	Object
    //   164	8	2	localThrowable2	java.lang.Throwable
    //   174	1	2	localObject6	Object
    //   8	113	3	str	String
    //   170	4	3	localThrowable3	java.lang.Throwable
    //   15	3	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   9	17	95	java/lang/Throwable
    //   9	17	133	finally
    //   22	30	156	finally
    //   32	41	156	finally
    //   43	68	156	finally
    //   101	110	160	finally
    //   22	30	164	java/lang/Throwable
    //   32	41	170	java/lang/Throwable
    //   43	68	170	java/lang/Throwable
  }
  
  public abstract SQLiteOpenHelper build(String paramString);
  
  protected void checkTableColumnChange(String paramString, SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  protected void cleanOverDueCorruptDatabase() {}
  
  public void close()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    this.closed = true;
    this.dbHelper.close();
  }
  
  protected abstract void createDatabase(SQLiteDatabase paramSQLiteDatabase);
  
  public EntityManager createEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    OGEntityManager localOGEntityManager = new OGEntityManager(this.dbHelper, this.mName);
    this.closed = false;
    return localOGEntityManager;
  }
  
  protected void doAfterUpgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  protected abstract String getPackageName();
  
  protected boolean isNeedEncrypt()
  {
    return true;
  }
  
  public boolean isOpen()
  {
    return !this.closed;
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
        return true;
      }
      if ((localAbility.uin == null) || (!localAbility.uin.equals(this.name)))
      {
        this.mInnerDbHelper.dropAllTable();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */