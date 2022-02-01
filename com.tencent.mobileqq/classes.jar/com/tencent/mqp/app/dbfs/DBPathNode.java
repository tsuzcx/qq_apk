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
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      a();
      this.b = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_ComTencentMqpAppDbfsDBSecurity.a(paramArrayOfByte));
      if (this.b != -1L)
      {
        this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, this.b);
        i = paramArrayOfByte.length;
      }
      localSQLiteDatabase.setTransactionSuccessful();
      return i;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
      localSQLiteDatabase.close();
    }
  }
  
  public void a()
  {
    if (-1L == this.b) {
      return;
    }
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.b);
    this.b = -1L;
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, this.b);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    DBFSPath localDBFSPath = a();
    while (localDBFSPath != null)
    {
      long l2 = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, localDBFSPath.jdField_a_of_type_JavaLangString);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long, -1L, localDBFSPath.jdField_a_of_type_JavaLangString);
      }
      localDBFSPath = localDBFSPath.b;
      this.jdField_a_of_type_Long = l1;
      this.b = this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long);
      if ((this.b != -1L) && (localDBFSPath != null)) {
        return false;
      }
    }
    return this.jdField_a_of_type_ComTencentMqpAppDbfsDBHelper.a(this.jdField_a_of_type_Long) == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBPathNode
 * JD-Core Version:    0.7.0.1
 */