package com.tencent.open.component.cache.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.open.component.cache.util.LocalConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractDbCacheManager
{
  protected DbCacheData.DbCreator a;
  protected long b;
  protected String c;
  protected boolean d;
  protected boolean e = false;
  protected ArrayList<DbCacheData.Structure> f = new ArrayList();
  protected DbCacheDatabase g;
  
  protected AbstractDbCacheManager(Context paramContext, Class<? extends DbCacheData> paramClass, long paramLong, String paramString)
  {
    this.g = DbCacheDatabase.a(paramContext.getApplicationContext(), paramLong);
    this.g.a(hashCode());
    this.b = paramLong;
    this.c = paramString;
    a(paramClass);
    e();
    a(f());
  }
  
  static String a(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramLong));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  final int a(SQLiteDatabase paramSQLiteDatabase, DbCacheData paramDbCacheData, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    paramDbCacheData.a(localContentValues);
    return paramSQLiteDatabase.update(this.c, localContentValues, paramString, null);
  }
  
  final Cursor a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = this.a.b();
    }
    return paramSQLiteDatabase.query(this.c, null, paramString1, null, null, null, str);
  }
  
  protected Cursor a(String paramString1, String paramString2)
  {
    if (a()) {
      return null;
    }
    SQLiteDatabase localSQLiteDatabase = f();
    if (localSQLiteDatabase == null) {
      return null;
    }
    try
    {
      paramString1 = a(localSQLiteDatabase, paramString1, paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (SQLException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  protected DbCacheData a(Cursor paramCursor, int paramInt)
  {
    if (paramCursor != null)
    {
      if (paramCursor.isClosed()) {
        return null;
      }
      if (paramInt >= 0)
      {
        if (paramInt >= paramCursor.getCount()) {
          return null;
        }
        try
        {
          boolean bool = paramCursor.moveToPosition(paramInt);
          if (!bool) {
            return null;
          }
          return this.a.b(paramCursor);
        }
        catch (Exception paramCursor)
        {
          paramCursor.printStackTrace();
        }
      }
    }
    return null;
  }
  
  /* Error */
  protected void a(int paramInt, DbCacheData... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 122	com/tencent/open/component/cache/database/AbstractDbCacheManager:a	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_2
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 62	com/tencent/open/component/cache/database/AbstractDbCacheManager:f	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnonnull +4 -> 25
    //   24: return
    //   25: aload 4
    //   27: invokevirtual 148	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   30: aload_0
    //   31: aload 4
    //   33: iload_1
    //   34: invokevirtual 151	com/tencent/open/component/cache/database/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;I)V
    //   37: aload_2
    //   38: arraylength
    //   39: istore_3
    //   40: iconst_0
    //   41: istore_1
    //   42: iload_1
    //   43: iload_3
    //   44: if_icmpge +19 -> 63
    //   47: aload_0
    //   48: aload 4
    //   50: aload_2
    //   51: iload_1
    //   52: aaload
    //   53: invokevirtual 154	com/tencent/open/component/cache/database/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;Lcom/tencent/open/component/cache/database/DbCacheData;)V
    //   56: iload_1
    //   57: iconst_1
    //   58: iadd
    //   59: istore_1
    //   60: goto -18 -> 42
    //   63: aload 4
    //   65: invokevirtual 157	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   68: aload 4
    //   70: invokevirtual 160	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   73: goto +38 -> 111
    //   76: astore_2
    //   77: goto +39 -> 116
    //   80: astore_2
    //   81: aload_2
    //   82: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   85: aload 4
    //   87: invokevirtual 160	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   90: goto +21 -> 111
    //   93: astore_2
    //   94: aload_2
    //   95: invokevirtual 128	android/database/SQLException:printStackTrace	()V
    //   98: aload 4
    //   100: invokevirtual 160	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   103: goto +8 -> 111
    //   106: astore_2
    //   107: aload_2
    //   108: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   111: aload_0
    //   112: invokevirtual 162	com/tencent/open/component/cache/database/AbstractDbCacheManager:d	()V
    //   115: return
    //   116: aload 4
    //   118: invokevirtual 160	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   121: goto +10 -> 131
    //   124: astore 4
    //   126: aload 4
    //   128: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   131: goto +5 -> 136
    //   134: aload_2
    //   135: athrow
    //   136: goto -2 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	AbstractDbCacheManager
    //   0	139	1	paramInt	int
    //   0	139	2	paramVarArgs	DbCacheData[]
    //   39	6	3	i	int
    //   17	100	4	localSQLiteDatabase	SQLiteDatabase
    //   124	3	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   25	40	76	finally
    //   47	56	76	finally
    //   63	68	76	finally
    //   81	85	76	finally
    //   94	98	76	finally
    //   25	40	80	java/lang/Exception
    //   47	56	80	java/lang/Exception
    //   63	68	80	java/lang/Exception
    //   25	40	93	android/database/SQLException
    //   47	56	93	android/database/SQLException
    //   63	68	93	android/database/SQLException
    //   68	73	106	java/lang/Exception
    //   85	90	106	java/lang/Exception
    //   98	103	106	java/lang/Exception
    //   116	121	124	java/lang/Exception
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!this.d) {
      try
      {
        paramSQLiteDatabase.execSQL(g());
        this.d = true;
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
      }
    }
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      a(paramSQLiteDatabase, null);
    }
  }
  
  final void a(SQLiteDatabase paramSQLiteDatabase, DbCacheData paramDbCacheData)
  {
    ContentValues localContentValues = new ContentValues();
    paramDbCacheData.a(localContentValues);
    paramSQLiteDatabase.replaceOrThrow(this.c, null, localContentValues);
  }
  
  final void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase.delete(this.c, paramString, null);
  }
  
  /* Error */
  protected void a(DbCacheData paramDbCacheData, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 122	com/tencent/open/component/cache/database/AbstractDbCacheManager:a	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 62	com/tencent/open/component/cache/database/AbstractDbCacheManager:f	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 8
    //   19: aload 8
    //   21: ifnonnull +4 -> 25
    //   24: return
    //   25: iconst_0
    //   26: istore 6
    //   28: iconst_0
    //   29: istore 7
    //   31: iconst_0
    //   32: istore_3
    //   33: iload 6
    //   35: istore 4
    //   37: iload 7
    //   39: istore 5
    //   41: aload 8
    //   43: invokevirtual 148	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   46: iload 6
    //   48: istore 4
    //   50: iload 7
    //   52: istore 5
    //   54: aload_0
    //   55: aload 8
    //   57: aload_1
    //   58: aload_2
    //   59: invokevirtual 184	com/tencent/open/component/cache/database/AbstractDbCacheManager:a	(Landroid/database/sqlite/SQLiteDatabase;Lcom/tencent/open/component/cache/database/DbCacheData;Ljava/lang/String;)I
    //   62: ifle +5 -> 67
    //   65: iconst_1
    //   66: istore_3
    //   67: iload_3
    //   68: istore 4
    //   70: iload_3
    //   71: istore 5
    //   73: aload 8
    //   75: invokevirtual 157	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   78: iload_3
    //   79: istore 6
    //   81: aload 8
    //   83: invokevirtual 160	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   86: goto +55 -> 141
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   94: iload 6
    //   96: istore_3
    //   97: goto +44 -> 141
    //   100: astore_1
    //   101: goto +49 -> 150
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   109: iload 4
    //   111: istore 6
    //   113: aload 8
    //   115: invokevirtual 160	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   118: iload 4
    //   120: istore_3
    //   121: goto +20 -> 141
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 128	android/database/SQLException:printStackTrace	()V
    //   129: iload 5
    //   131: istore 6
    //   133: aload 8
    //   135: invokevirtual 160	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   138: iload 5
    //   140: istore_3
    //   141: iload_3
    //   142: ifeq +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 162	com/tencent/open/component/cache/database/AbstractDbCacheManager:d	()V
    //   149: return
    //   150: aload 8
    //   152: invokevirtual 160	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   155: goto +8 -> 163
    //   158: astore_2
    //   159: aload_2
    //   160: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	AbstractDbCacheManager
    //   0	165	1	paramDbCacheData	DbCacheData
    //   0	165	2	paramString	String
    //   32	110	3	i	int
    //   35	84	4	j	int
    //   39	100	5	k	int
    //   26	106	6	m	int
    //   29	22	7	n	int
    //   17	134	8	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   81	86	89	java/lang/Exception
    //   113	118	89	java/lang/Exception
    //   133	138	89	java/lang/Exception
    //   41	46	100	finally
    //   54	65	100	finally
    //   73	78	100	finally
    //   105	109	100	finally
    //   125	129	100	finally
    //   41	46	104	java/lang/Exception
    //   54	65	104	java/lang/Exception
    //   73	78	104	java/lang/Exception
    //   41	46	124	android/database/SQLException
    //   54	65	124	android/database/SQLException
    //   73	78	124	android/database/SQLException
    //   150	155	158	java/lang/Exception
  }
  
  protected void a(Class<? extends DbCacheData> paramClass)
  {
    String str = paramClass.getName();
    try
    {
      paramClass = (DbCacheData.DbCreator)paramClass.getField("DB_CREATOR").get(null);
      if (paramClass != null)
      {
        this.a = paramClass;
        paramClass = paramClass.a();
        if (paramClass != null)
        {
          int j = paramClass.length;
          int i = 0;
          while (i < j)
          {
            Object localObject = paramClass[i];
            if (localObject != null) {
              this.f.add(localObject);
            }
            i += 1;
          }
        }
        if (this.f.size() != 0) {
          return;
        }
        paramClass = new StringBuilder();
        paramClass.append("CacheData protocol requires a valid CacheData.Structure from CacheData.Creator object called  CREATOR on class ");
        paramClass.append(str);
        throw new AbstractDbCacheManager.BadCacheDataException(paramClass.toString());
      }
      paramClass = new StringBuilder();
      paramClass.append("CacheData protocol requires a CacheData.Creator object called  CREATOR on class ");
      paramClass.append(str);
      throw new AbstractDbCacheManager.BadCacheDataException(paramClass.toString());
    }
    catch (IllegalAccessException paramClass)
    {
      break label224;
    }
    catch (ClassCastException paramClass)
    {
      break label190;
    }
    catch (NoSuchFieldException paramClass)
    {
      label156:
      break label156;
    }
    paramClass = new StringBuilder();
    paramClass.append("CacheData protocol requires a CacheData.Creator object called  CacheData on class ");
    paramClass.append(str);
    throw new AbstractDbCacheManager.BadCacheDataException(paramClass.toString());
    label190:
    paramClass = new StringBuilder();
    paramClass.append("CacheData protocol requires a CacheData.Creator object called  CREATOR on class ");
    paramClass.append(str);
    throw new AbstractDbCacheManager.BadCacheDataException(paramClass.toString());
    label224:
    paramClass = new StringBuilder();
    paramClass.append("IllegalAccessException when access: ");
    paramClass.append(str);
    paramClass = new AbstractDbCacheManager.BadCacheDataException(paramClass.toString());
    for (;;)
    {
      throw paramClass;
    }
  }
  
  protected void a(String paramString)
  {
    if (a()) {
      return;
    }
    SQLiteDatabase localSQLiteDatabase = f();
    if (localSQLiteDatabase == null) {
      return;
    }
    try
    {
      a(localSQLiteDatabase, paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    catch (SQLException paramString)
    {
      paramString.printStackTrace();
    }
    d();
  }
  
  public final boolean a()
  {
    return this.e;
  }
  
  final String b()
  {
    return a(this.b, this.c);
  }
  
  protected void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(h());
    this.d = false;
  }
  
  protected abstract void c();
  
  protected void d()
  {
    c();
  }
  
  protected void e()
  {
    int i = this.a.c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("_cache_db_version");
    int j = LocalConfig.b(((StringBuilder)localObject).toString(), -1, this.b);
    if ((j == -1) || (j != i))
    {
      localObject = f();
      if (localObject != null) {
        try
        {
          b((SQLiteDatabase)localObject);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        catch (SQLException localSQLException)
        {
          localSQLException.printStackTrace();
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("_cache_db_version");
    LocalConfig.a(localStringBuilder.toString(), i, this.b);
  }
  
  protected SQLiteDatabase f()
  {
    if (a()) {
      return null;
    }
    return this.g.getWritableDatabase();
  }
  
  protected String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CREATE TABLE IF NOT EXISTS ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(" (");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append("_id INTEGER PRIMARY KEY");
    localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext())
    {
      DbCacheData.Structure localStructure = (DbCacheData.Structure)((Iterator)localObject).next();
      localStringBuilder.append(',');
      localStringBuilder.append(localStructure.a());
      localStringBuilder.append(' ');
      localStringBuilder.append(localStructure.b());
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  protected String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DROP TABLE IF EXISTS ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.component.cache.database.AbstractDbCacheManager
 * JD-Core Version:    0.7.0.1
 */