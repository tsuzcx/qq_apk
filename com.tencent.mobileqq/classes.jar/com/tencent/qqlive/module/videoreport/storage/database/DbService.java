package com.tencent.qqlive.module.videoreport.storage.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import com.tencent.qqlive.module.videoreport.storage.annotation.AnnotationProcessor;
import com.tencent.qqlive.module.videoreport.storage.util.Coder;
import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import com.tencent.qqlive.module.videoreport.storage.util.GsonObjectCoder;
import java.util.LinkedList;
import java.util.List;

class DbService
  implements IDbOperation
{
  private static final String EQUAL = "` = '";
  private static volatile DbService sInstance;
  private AnnotationProcessor mAnnotationProcessor;
  private Coder mCoder;
  private DbOpenHelper mDatabaseHelper;
  private SQLiteDatabase mDb;
  
  private DbService(Context paramContext)
  {
    this.mDatabaseHelper = new DbOpenHelper(paramContext);
    this.mCoder = new GsonObjectCoder();
    this.mAnnotationProcessor = AnnotationProcessor.getInstance();
  }
  
  private SQLiteDatabase db()
  {
    if (this.mDb == null) {
      try
      {
        if (this.mDb == null) {
          this.mDb = this.mDatabaseHelper.getWritableDatabase();
        }
      }
      finally {}
    }
    return this.mDb;
  }
  
  private void executeInTransaction(Runnable paramRunnable)
  {
    db().beginTransaction();
    try
    {
      paramRunnable.run();
      db().setTransactionSuccessful();
      return;
    }
    finally
    {
      db().endTransaction();
    }
  }
  
  private static String generateEquation(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("`");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("` = '");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("'");
    return localStringBuilder.toString();
  }
  
  private <T> String generateReplaceValue(T paramT, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("('");
    localStringBuilder.append(this.mAnnotationProcessor.getClassId(paramT.getClass()));
    localStringBuilder.append("', '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("', '");
    localStringBuilder.append(this.mCoder.encode(paramT));
    localStringBuilder.append("')");
    return localStringBuilder.toString();
  }
  
  static DbService getInstance(Context paramContext)
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new DbService(paramContext);
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public void clearTable()
  {
    db().delete("datong_storage", null, null);
  }
  
  public void close()
  {
    db().close();
  }
  
  public <T> boolean containsObject(Class<T> paramClass, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = db();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(generateEquation("class_id", this.mAnnotationProcessor.getClassId(paramClass)));
    localStringBuilder.append(" and ");
    localStringBuilder.append(generateEquation("object_id", paramString));
    paramClass = localSQLiteDatabase.query("datong_storage", null, localStringBuilder.toString(), null, null, null, null, null);
    boolean bool;
    if (paramClass.getCount() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramClass.close();
    return bool;
  }
  
  public <T> void deleteAllObjects(Class<T> paramClass)
  {
    paramClass = generateEquation("class_id", this.mAnnotationProcessor.getClassId(paramClass));
    db().delete("datong_storage", paramClass, null);
  }
  
  public <T> void deleteObject(Class<T> paramClass, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(generateEquation("class_id", this.mAnnotationProcessor.getClassId(paramClass)));
    localStringBuilder.append(" and ");
    localStringBuilder.append(generateEquation("object_id", paramString));
    paramClass = localStringBuilder.toString();
    db().delete("datong_storage", paramClass, null);
  }
  
  public <T> void deleteObjects(Class<T> paramClass, List<String> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(generateEquation("class_id", this.mAnnotationProcessor.getClassId(paramClass)));
    localStringBuilder.append(" and `");
    localStringBuilder.append("object_id");
    localStringBuilder.append("` in ('");
    localStringBuilder.append((String)paramList.get(0));
    localStringBuilder.append("'");
    paramClass = new StringBuilder(localStringBuilder.toString());
    int j = paramList.size();
    int i = 1;
    while (i < j)
    {
      paramClass.append(" ,'");
      paramClass.append((String)paramList.get(i));
      paramClass.append("'");
      i += 1;
    }
    paramClass.append(")");
    db().delete("datong_storage", paramClass.toString(), null);
  }
  
  public <T> List<Pair<String, T>> getAllObjects(Class<T> paramClass)
  {
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = db().query("datong_storage", null, generateEquation("class_id", this.mAnnotationProcessor.getClassId(paramClass)), null, null, null, null);
    while (localCursor.moveToNext())
    {
      Object localObject = localCursor.getString(localCursor.getColumnIndex("object_dat"));
      String str = localCursor.getString(localCursor.getColumnIndex("object_id"));
      localObject = this.mCoder.decode((String)localObject, paramClass);
      if (localObject != null) {
        localLinkedList.add(new Pair(str, localObject));
      }
    }
    localCursor.close();
    return localLinkedList;
  }
  
  public <T> T getObject(Class<T> paramClass, String paramString)
  {
    Object localObject = db();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(generateEquation("class_id", this.mAnnotationProcessor.getClassId(paramClass)));
    localStringBuilder.append(" and ");
    localStringBuilder.append(generateEquation("object_id", paramString));
    paramString = ((SQLiteDatabase)localObject).query("datong_storage", null, localStringBuilder.toString(), null, null, null, null);
    if (paramString.moveToNext())
    {
      localObject = paramString.getString(paramString.getColumnIndex("object_dat"));
      paramClass = this.mCoder.decode((String)localObject, paramClass);
    }
    else
    {
      paramClass = null;
    }
    paramString.close();
    return paramClass;
  }
  
  public <T> List<Pair<String, T>> getObjects(Class<T> paramClass, Condition<T> paramCondition)
  {
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = db().query("datong_storage", null, generateEquation("class_id", this.mAnnotationProcessor.getClassId(paramClass)), null, null, null, null);
    while (localCursor.moveToNext())
    {
      Object localObject = localCursor.getString(localCursor.getColumnIndex("object_dat"));
      localObject = this.mCoder.decode((String)localObject, paramClass);
      if ((localObject != null) && ((paramCondition == null) || (paramCondition.satisfy(localObject)))) {
        localLinkedList.add(new Pair(localCursor.getString(localCursor.getColumnIndex("object_id")), localObject));
      }
    }
    localCursor.close();
    return localLinkedList;
  }
  
  public <T> void insertObject(T paramT, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("REPLACE INTO datong_storage (`class_id`, `object_id`, `object_dat`)\nVALUES ");
    localStringBuilder.append(generateReplaceValue(paramT, paramString));
    localStringBuilder.append(";");
    paramT = localStringBuilder.toString();
    this.mDb.execSQL(paramT);
  }
  
  public <T> void insertObjects(List<T> paramList, List<String> paramList1)
  {
    if (paramList.isEmpty()) {
      return;
    }
    executeInTransaction(new DbService.1(this, paramList, paramList1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.database.DbService
 * JD-Core Version:    0.7.0.1
 */