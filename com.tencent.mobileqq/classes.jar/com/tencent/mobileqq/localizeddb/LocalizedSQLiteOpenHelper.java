package com.tencent.mobileqq.localizeddb;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.utils.kapalaiadapter.ReflecterHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public abstract class LocalizedSQLiteOpenHelper
  extends SQLiteOpenHelper
{
  private final int jdField_a_of_type_Int;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final DatabaseErrorHandler jdField_a_of_type_AndroidDatabaseDatabaseErrorHandler;
  private final SQLiteDatabase.CursorFactory jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase$CursorFactory;
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public LocalizedSQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase$CursorFactory = paramCursorFactory;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidDatabaseDatabaseErrorHandler = paramDatabaseErrorHandler;
  }
  
  private SQLiteDatabase a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
    if (localObject1 != null) {
      if (!((SQLiteDatabase)localObject1).isOpen()) {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = null;
      } else if ((!paramBoolean) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isReadOnly())) {
        return this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
      }
    }
    SQLiteDatabase localSQLiteDatabase2;
    Object localObject4;
    if (!this.jdField_a_of_type_Boolean)
    {
      localSQLiteDatabase2 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
      localObject4 = localSQLiteDatabase2;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = true;
        Object localObject2;
        if (localSQLiteDatabase2 != null)
        {
          localObject4 = localSQLiteDatabase2;
          if (QLog.isColorLevel())
          {
            localObject4 = localSQLiteDatabase2;
            QLog.d("LocalizedSQLiteOpenHelper", 2, new Object[] { "getDatabaseLocked db not null, writable: ", Boolean.valueOf(paramBoolean), ", isReadOnly: ", Boolean.valueOf(localSQLiteDatabase2.isReadOnly()) });
          }
          localObject1 = localSQLiteDatabase2;
          if (paramBoolean)
          {
            localObject4 = localSQLiteDatabase2;
            paramBoolean = localSQLiteDatabase2.isReadOnly();
            localObject1 = localSQLiteDatabase2;
            if (paramBoolean)
            {
              localObject4 = localSQLiteDatabase2;
              try
              {
                ReflecterHelper.a(localSQLiteDatabase2, "reopenReadWrite");
                localObject1 = localSQLiteDatabase2;
              }
              catch (Exception localException)
              {
                localObject4 = localSQLiteDatabase2;
                QLog.d("LocalizedSQLiteOpenHelper", 1, localException, new Object[0]);
                localObject2 = localSQLiteDatabase2;
              }
            }
          }
        }
        else
        {
          localObject4 = localSQLiteDatabase2;
          if (this.jdField_a_of_type_JavaLangString == null)
          {
            localObject4 = localSQLiteDatabase2;
            if (QLog.isColorLevel())
            {
              localObject4 = localSQLiteDatabase2;
              QLog.d("LocalizedSQLiteOpenHelper", 2, "getDatabaseLocked mName null");
            }
            localObject4 = localSQLiteDatabase2;
            localObject2 = SQLiteDatabase.openDatabase(":memory:", null, 268435472);
          }
          else
          {
            localObject4 = localSQLiteDatabase2;
            try
            {
              if (QLog.isColorLevel())
              {
                localObject4 = localSQLiteDatabase2;
                QLog.d("LocalizedSQLiteOpenHelper", 2, new Object[] { "getDatabaseLocked DEBUG_STRICT_READONLY: ", Boolean.valueOf(false), ", writable: ", Boolean.valueOf(paramBoolean) });
              }
              localObject4 = localSQLiteDatabase2;
              if (!this.b) {
                break label821;
              }
              i = 8;
              localObject4 = localSQLiteDatabase2;
              localObject2 = this.jdField_a_of_type_AndroidContentContext.openOrCreateDatabase(this.jdField_a_of_type_JavaLangString, i | 0x10, this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase$CursorFactory, this.jdField_a_of_type_AndroidDatabaseDatabaseErrorHandler);
            }
            catch (SQLiteException localSQLiteException)
            {
              if (paramBoolean) {
                continue;
              }
            }
            localObject4 = localSQLiteDatabase2;
            StringBuilder localStringBuilder2 = new StringBuilder();
            localObject4 = localSQLiteDatabase2;
            localStringBuilder2.append("Couldn't open ");
            localObject4 = localSQLiteDatabase2;
            localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
            localObject4 = localSQLiteDatabase2;
            localStringBuilder2.append(" for writing (will try read-only):");
            localObject4 = localSQLiteDatabase2;
            QLog.d("LocalizedSQLiteOpenHelper", 1, localStringBuilder2.toString(), localSQLiteException);
            localObject4 = localSQLiteDatabase2;
            localSQLiteDatabase1 = SQLiteDatabase.openDatabase(this.jdField_a_of_type_AndroidContentContext.getDatabasePath(this.jdField_a_of_type_JavaLangString).getPath(), this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase$CursorFactory, 17, this.jdField_a_of_type_AndroidDatabaseDatabaseErrorHandler);
          }
        }
        localObject4 = localSQLiteDatabase1;
        onConfigure(localSQLiteDatabase1);
        localObject4 = localSQLiteDatabase1;
        i = localSQLiteDatabase1.getVersion();
        localObject4 = localSQLiteDatabase1;
        if (i != this.jdField_a_of_type_Int)
        {
          localObject4 = localSQLiteDatabase1;
          if (!localSQLiteDatabase1.isReadOnly())
          {
            localObject4 = localSQLiteDatabase1;
            localSQLiteDatabase1.beginTransaction();
            if (i == 0) {}
            try
            {
              onCreate(localSQLiteDatabase1);
              continue;
              if (i > this.jdField_a_of_type_Int) {
                onDowngrade(localSQLiteDatabase1, i, this.jdField_a_of_type_Int);
              } else {
                onUpgrade(localSQLiteDatabase1, i, this.jdField_a_of_type_Int);
              }
              localSQLiteDatabase1.setVersion(this.jdField_a_of_type_Int);
              localSQLiteDatabase1.setTransactionSuccessful();
              localObject4 = localSQLiteDatabase1;
              localSQLiteDatabase1.endTransaction();
            }
            finally
            {
              localObject4 = localSQLiteDatabase1;
              localSQLiteDatabase1.endTransaction();
              localObject4 = localSQLiteDatabase1;
            }
          }
          else
          {
            localObject4 = localSQLiteDatabase1;
            localStringBuilder1 = new StringBuilder();
            localObject4 = localSQLiteDatabase1;
            localStringBuilder1.append("Can't upgrade read-only database from version ");
            localObject4 = localSQLiteDatabase1;
            localStringBuilder1.append(localSQLiteDatabase1.getVersion());
            localObject4 = localSQLiteDatabase1;
            localStringBuilder1.append(" to ");
            localObject4 = localSQLiteDatabase1;
            localStringBuilder1.append(this.jdField_a_of_type_Int);
            localObject4 = localSQLiteDatabase1;
            localStringBuilder1.append(": ");
            localObject4 = localSQLiteDatabase1;
            localStringBuilder1.append(this.jdField_a_of_type_JavaLangString);
            localObject4 = localSQLiteDatabase1;
            throw new SQLiteException(localStringBuilder1.toString());
          }
        }
        localObject4 = localSQLiteDatabase1;
        onOpen(localSQLiteDatabase1);
        localObject4 = localSQLiteDatabase1;
        if (localSQLiteDatabase1.isReadOnly())
        {
          localObject4 = localSQLiteDatabase1;
          if (QLog.isColorLevel())
          {
            localObject4 = localSQLiteDatabase1;
            localStringBuilder1 = new StringBuilder();
            localObject4 = localSQLiteDatabase1;
            localStringBuilder1.append("Opened ");
            localObject4 = localSQLiteDatabase1;
            localStringBuilder1.append(this.jdField_a_of_type_JavaLangString);
            localObject4 = localSQLiteDatabase1;
            localStringBuilder1.append(" in read-only mode");
            localObject4 = localSQLiteDatabase1;
            QLog.d("LocalizedSQLiteOpenHelper", 2, localStringBuilder1.toString());
          }
        }
        localObject4 = localSQLiteDatabase1;
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = localSQLiteDatabase1;
        this.jdField_a_of_type_Boolean = false;
        if ((localSQLiteDatabase1 != null) && (localSQLiteDatabase1 != this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase)) {
          localSQLiteDatabase1.close();
        }
        return localSQLiteDatabase1;
      }
      finally
      {
        SQLiteDatabase localSQLiteDatabase1;
        StringBuilder localStringBuilder1;
        this.jdField_a_of_type_Boolean = false;
        if ((localObject4 == null) || (localObject4 == this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase)) {
          continue;
        }
        ((SQLiteDatabase)localObject4).close();
      }
      localObject4 = localStringBuilder1;
      throw localSQLiteDatabase1;
      throw new IllegalStateException("getDatabase called recursively");
      label821:
      int i = 0;
    }
  }
  
  public void close()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null) && (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()))
        {
          this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
          this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = null;
        }
        return;
      }
      throw new IllegalStateException("Closed during initialization");
    }
    finally {}
  }
  
  public String getDatabaseName()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = a(false);
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = a(true);
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append("Can't downgrade database from version ");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append(" to ");
    paramSQLiteDatabase.append(paramInt2);
    throw new SQLiteException(paramSQLiteDatabase.toString());
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    try
    {
      if (this.b != paramBoolean)
      {
        if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null) && (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) && (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isReadOnly())) {
          if (paramBoolean) {
            this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.enableWriteAheadLogging();
          } else {
            try
            {
              ReflecterHelper.a(this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase, "disableWriteAheadLogging");
            }
            catch (Exception localException)
            {
              QLog.d("LocalizedSQLiteOpenHelper", 1, localException, new Object[0]);
            }
          }
        }
        this.b = paramBoolean;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.localizeddb.LocalizedSQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */