package com.tencent.wcdb.database;

public class SQLiteCipherSpec
{
  public static final int HMAC_DEFAULT = -1;
  public static final int HMAC_SHA1 = 0;
  public static final int HMAC_SHA256 = 1;
  public static final int HMAC_SHA512 = 2;
  public int hmacAlgorithm = -1;
  public boolean hmacEnabled = true;
  public int kdfAlgorithm = -1;
  public int kdfIteration;
  public int pageSize = SQLiteGlobal.a;
  
  public SQLiteCipherSpec() {}
  
  public SQLiteCipherSpec(SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    this.kdfIteration = paramSQLiteCipherSpec.kdfIteration;
    this.hmacEnabled = paramSQLiteCipherSpec.hmacEnabled;
    this.pageSize = paramSQLiteCipherSpec.pageSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteCipherSpec
 * JD-Core Version:    0.7.0.1
 */