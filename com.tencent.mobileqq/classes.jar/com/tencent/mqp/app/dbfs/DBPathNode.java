package com.tencent.mqp.app.dbfs;

import android.database.sqlite.SQLiteDatabase;

public class DBPathNode
{
  public long a;
  DBFSPath jdField_a_of_type_ComTencentMqpAppDbfsDBFSPath;
  DBHelper jdField_a_of_type_ComTencentMqpAppDbfsDBHelper;
  DBSecurity jdField_a_of_type_ComTencentMqpAppDbfsDBSecurity;
  public long b;
  
  private DBFSPath a()
  {
    for (DBFSPath localDBFSPath = this.jdField_a_of_type_ComTencentMqpAppDbfsDBFSPath; localDBFSPath.jdField_a_of_type_ComTencentMqpAppDbfsDBFSPath != null; localDBFSPath = localDBFSPath.jdField_a_of_type_ComTencentMqpAppDbfsDBFSPath) {}
    return localDBFSPath;
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    for (;;)
    {
      try
      {
        a();
        this.b = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_ComTencentMqpAppDbfsDBSecurity.a(paramArrayOfByte));
        if (this.b != -1L)
        {
          this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, this.b);
          i = paramArrayOfByte.length;
          localSQLiteDatabase.setTransactionSuccessful();
          return i;
        }
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
        localSQLiteDatabase.close();
      }
      int i = 0;
    }
  }
  
  public void a()
  {
    long l = this.b;
    if (-1L == l) {
      return;
    }
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(l);
    this.b = -1L;
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, this.b);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    Object localObject = a();
    while (localObject != null)
    {
      long l2 = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, ((DBFSPath)localObject).jdField_a_of_type_JavaLangString);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, -1L, ((DBFSPath)localObject).jdField_a_of_type_JavaLangString);
      }
      DBFSPath localDBFSPath = ((DBFSPath)localObject).b;
      this.jdField_a_of_type_Long = l1;
      this.b = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long);
      localObject = localDBFSPath;
      if (this.b != -1L)
      {
        localObject = localDBFSPath;
        if (localDBFSPath != null) {
          return false;
        }
      }
    }
    return this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long) == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBPathNode
 * JD-Core Version:    0.7.0.1
 */