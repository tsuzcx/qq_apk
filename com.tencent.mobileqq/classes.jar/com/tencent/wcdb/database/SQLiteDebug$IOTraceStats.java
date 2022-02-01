package com.tencent.wcdb.database;

import android.annotation.SuppressLint;

public class SQLiteDebug$IOTraceStats
{
  public String dbName;
  public String journalMode;
  public long lastJournalReadOffset;
  public byte[] lastJournalReadPage;
  public long lastJournalWriteOffset;
  public byte[] lastJournalWritePage;
  public long lastReadOffset;
  public byte[] lastReadPage;
  public long lastWriteOffset;
  public byte[] lastWritePage;
  public long pageCount;
  public long pageSize;
  public String path;
  
  @SuppressLint({"DefaultLocale"})
  public String toString()
  {
    return String.format("[%s | %s] pageSize: %d, pageCount: %d, journal: %s, lastRead: %d, lastWrite: %d, lastJournalRead: %d, lastJournalWrite: %d", new Object[] { this.dbName, this.path, Long.valueOf(this.pageSize), Long.valueOf(this.pageCount), this.journalMode, Long.valueOf(this.lastReadOffset), Long.valueOf(this.lastWriteOffset), Long.valueOf(this.lastJournalReadOffset), Long.valueOf(this.lastJournalWriteOffset) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDebug.IOTraceStats
 * JD-Core Version:    0.7.0.1
 */