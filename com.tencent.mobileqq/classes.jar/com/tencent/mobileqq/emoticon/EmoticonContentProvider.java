package com.tencent.mobileqq.emoticon;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import apsr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppContentProvider;
import mqq.app.AppRuntime;

public class EmoticonContentProvider
  extends AppContentProvider
{
  private final UriMatcher a = new UriMatcher(-1);
  
  private SQLiteDatabase a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAppRuntime != null)
    {
      localObject1 = localObject2;
      if ((paramAppRuntime instanceof QQAppInterface))
      {
        paramAppRuntime = (QQAppInterface)paramAppRuntime;
        if (!paramBoolean) {
          break label41;
        }
        localObject1 = paramAppRuntime.b(paramString);
      }
    }
    return localObject1;
    label41:
    return paramAppRuntime.a(paramString);
  }
  
  @Nullable
  public Bundle call(@NonNull String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonContentProvider", 2, "call, method = " + paramString1 + " arg = " + paramString2 + " extras = " + paramBundle);
    }
    if (paramString2 == null)
    {
      QLog.e("EmoticonContentProvider", 2, "call, uin = null");
      return null;
    }
    Object localObject = getRuntime(paramString2);
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if ("vip_type".equals(paramString1)) {
        return apsr.a((QQAppInterface)localObject, paramString1);
      }
    }
    return super.call(paramString1, paramString2, paramBundle);
  }
  
  public int delete(@NonNull Uri paramUri, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    return 0;
  }
  
  @Nullable
  public String getType(@NonNull Uri paramUri)
  {
    return null;
  }
  
  @Nullable
  public Uri insert(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    super.onCreate();
    this.a.addURI("qq.emoticon", "emoticon_package", 1000);
    this.a.addURI("qq.emoticon", "emoticon_tab", 1001);
    this.a.addURI("qq.emoticon", "emoticon_fav", 1002);
    this.a.addURI("qq.emoticon", "emoticon", 1003);
    return true;
  }
  
  @Nullable
  public Cursor query(@NonNull Uri paramUri, @Nullable String[] paramArrayOfString1, @Nullable String paramString1, @Nullable String[] paramArrayOfString2, @Nullable String paramString2)
  {
    Object localObject = null;
    SQLiteDatabase localSQLiteDatabase = null;
    int i = this.a.match(paramUri);
    String str = paramUri.getQueryParameter("uin");
    if (str == null)
    {
      QLog.e("EmoticonContentProvider", 2, "query, uin = null, uri=" + paramUri.getPath());
      paramString1 = localSQLiteDatabase;
      return paramString1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonContentProvider", 2, "query, projection = " + paramArrayOfString1 + " selection = " + paramString1 + " selectionArgs = " + paramArrayOfString2 + " sortOrder = " + paramString2);
    }
    localSQLiteDatabase = a(getRuntime(str), str, true);
    if (localSQLiteDatabase == null)
    {
      QLog.e("EmoticonContentProvider", 1, "query, db null, uri=" + paramUri);
      return null;
    }
    switch (i)
    {
    default: 
      paramArrayOfString1 = localObject;
      if (QLog.isColorLevel())
      {
        QLog.e("EmoticonContentProvider", 2, "Uri match missing! match: " + paramUri);
        paramArrayOfString1 = localObject;
      }
      break;
    }
    for (;;)
    {
      paramString1 = paramArrayOfString1;
      if (paramArrayOfString1 == null) {
        break;
      }
      paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
      return paramArrayOfString1;
      paramArrayOfString1 = localSQLiteDatabase.a("EmoticonPackage", paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
      continue;
      paramArrayOfString1 = localSQLiteDatabase.a("EmoticonTab", paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
      continue;
      paramArrayOfString1 = localSQLiteDatabase.a("CustomEmotionData", paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
      continue;
      paramArrayOfString1 = localSQLiteDatabase.a("Emoticon", paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
    }
  }
  
  public int update(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmoticonContentProvider
 * JD-Core Version:    0.7.0.1
 */