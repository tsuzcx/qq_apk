package com.tencent.wcdb.database;

import java.io.File;
import java.io.FileFilter;

final class SQLiteDatabase$2
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().startsWith(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabase.2
 * JD-Core Version:    0.7.0.1
 */