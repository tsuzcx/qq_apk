package com.tencent.sonic.sdk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicBoolean;

public class SonicDBHelper
  extends SQLiteOpenHelper
{
  private static final int SONIC_DATABASE_FIRST_VERSION = 1;
  private static final String SONIC_DATABASE_NAME = "sonic.db";
  private static final int SONIC_DATABASE_VERSION = 3;
  private static final String TAG = "SonicSdk_SonicDBHelper";
  private static AtomicBoolean isDBUpgrading = new AtomicBoolean(false);
  private static SonicDBHelper sInstance;
  
  private SonicDBHelper(Context paramContext)
  {
    super(paramContext, "sonic.db", null, 3);
  }
  
  static SonicDBHelper createInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new SonicDBHelper(paramContext);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  private void doUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 == 2) {}
    }
    else {
      upgradeToVersion_2(paramSQLiteDatabase);
    }
    upgradeToVersion_3(paramSQLiteDatabase);
  }
  
  public static SonicDBHelper getInstance()
  {
    try
    {
      if (sInstance != null)
      {
        SonicDBHelper localSonicDBHelper = sInstance;
        return localSonicDBHelper;
      }
      throw new IllegalStateException("SonicDBHelper::createInstance() needs to be called before SonicDBHelper::getInstance()!");
    }
    finally {}
  }
  
  private void upgradeToVersion_2(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ResourceData ( id  integer PRIMARY KEY autoincrement , resourceID text not null , resourceSha1 text not null , resourceSize integer default 0 , resourceUpdateTime integer default 0 , cacheExpiredTime integer default 0 ); ");
  }
  
  private void upgradeToVersion_3(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS SessionChunkData ( id  integer PRIMARY KEY autoincrement , sessionId text not null , eTag text not null , chunkKey text not null , chunkSha1 text not null ); ");
  }
  
  public boolean isUpgrading()
  {
    return isDBUpgrading.get();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS SessionData ( id  integer PRIMARY KEY autoincrement , sessionID text not null , eTag text not null , templateTag text , htmlSha1 text not null , UnavailableTime integer default 0 , htmlSize integer default 0 , templateUpdateTime integer default 0 , cacheExpiredTime integer default 0 , cacheHitCount integer default 0 , isRedPointPreload integer default 0 ); ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS SessionChunkData ( id  integer PRIMARY KEY autoincrement , sessionId text not null , eTag text not null , chunkKey text not null , chunkSha1 text not null ); ");
    onUpgrade(paramSQLiteDatabase, -1, 3);
    doUpgrade(paramSQLiteDatabase, 1, 3);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (isDBUpgrading.compareAndSet(false, true))
    {
      long l = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpgrade start, from ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(".");
      SonicUtils.log("SonicSdk_SonicDBHelper", 4, localStringBuilder.toString());
      if (-1 == paramInt1)
      {
        SonicEngine.getInstance().getRuntime().postTaskToThread(new SonicDBHelper.1(this), 0L);
      }
      else
      {
        doUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
        isDBUpgrading.set(false);
      }
      paramSQLiteDatabase = new StringBuilder();
      paramSQLiteDatabase.append("onUpgrade finish, cost ");
      paramSQLiteDatabase.append(System.currentTimeMillis() - l);
      paramSQLiteDatabase.append("ms.");
      SonicUtils.log("SonicSdk_SonicDBHelper", 4, paramSQLiteDatabase.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicDBHelper
 * JD-Core Version:    0.7.0.1
 */