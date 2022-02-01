package com.tencent.wcdb.database;

import com.tencent.wcdb.extension.SQLiteExtension;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class SQLiteDatabaseConfiguration
{
  public final String a;
  public final String b;
  public String c;
  public int d;
  public int e;
  public Locale f;
  public boolean g;
  public boolean h;
  public int i;
  public boolean j;
  public boolean k;
  public final LinkedHashSet<SQLiteExtension> l = new LinkedHashSet();
  
  public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration != null)
    {
      this.a = paramSQLiteDatabaseConfiguration.a;
      this.b = paramSQLiteDatabaseConfiguration.b;
      a(paramSQLiteDatabaseConfiguration);
      return;
    }
    throw new IllegalArgumentException("other must not be null.");
  }
  
  public SQLiteDatabaseConfiguration(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      this.a = paramString;
      this.b = paramString;
      this.d = paramInt;
      this.i = 2;
      this.e = 25;
      this.f = Locale.getDefault();
      if ((paramInt & 0x100) != 0) {
        paramString = "vfslog";
      } else {
        paramString = null;
      }
      this.c = paramString;
      return;
    }
    throw new IllegalArgumentException("path must not be null.");
  }
  
  public void a(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration != null)
    {
      if (this.a.equals(paramSQLiteDatabaseConfiguration.a))
      {
        this.d = paramSQLiteDatabaseConfiguration.d;
        this.e = paramSQLiteDatabaseConfiguration.e;
        this.f = paramSQLiteDatabaseConfiguration.f;
        this.g = paramSQLiteDatabaseConfiguration.g;
        this.h = paramSQLiteDatabaseConfiguration.h;
        this.j = paramSQLiteDatabaseConfiguration.j;
        this.k = paramSQLiteDatabaseConfiguration.k;
        this.i = paramSQLiteDatabaseConfiguration.i;
        this.c = paramSQLiteDatabaseConfiguration.c;
        this.l.clear();
        this.l.addAll(paramSQLiteDatabaseConfiguration.l);
        return;
      }
      throw new IllegalArgumentException("other configuration must refer to the same database.");
    }
    throw new IllegalArgumentException("other must not be null.");
  }
  
  public boolean a()
  {
    return this.a.equalsIgnoreCase(":memory:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabaseConfiguration
 * JD-Core Version:    0.7.0.1
 */