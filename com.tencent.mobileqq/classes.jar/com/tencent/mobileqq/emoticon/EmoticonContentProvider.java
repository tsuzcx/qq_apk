package com.tencent.mobileqq.emoticon;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
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
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof BaseQQAppInterface)))
    {
      paramAppRuntime = (BaseQQAppInterface)paramAppRuntime;
      if (paramBoolean) {
        return paramAppRuntime.getReadableDatabase(paramString);
      }
      return paramAppRuntime.getWritableDatabase(paramString);
    }
    return null;
  }
  
  @Nullable
  public Bundle call(@NonNull String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("call, method = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" arg = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" extras = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.i("EmoticonContentProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString2 == null)
    {
      QLog.e("EmoticonContentProvider", 2, "call, uin = null");
      return null;
    }
    Object localObject = getRuntime(paramString2);
    if ((localObject instanceof BaseQQAppInterface))
    {
      localObject = (BaseQQAppInterface)localObject;
      if ("vip_type".equals(paramString1)) {
        return SVIPHandlerWrapper.a((BaseQQAppInterface)localObject, paramString1);
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
    int i = this.a.match(paramUri);
    Object localObject2 = paramUri.getQueryParameter("uin");
    Object localObject1 = null;
    if (localObject2 == null)
    {
      paramArrayOfString1 = new StringBuilder();
      paramArrayOfString1.append("query, uin = null, uri=");
      paramArrayOfString1.append(paramUri.getPath());
      QLog.e("EmoticonContentProvider", 2, paramArrayOfString1.toString());
      return null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("query, projection = ");
      localStringBuilder.append(paramArrayOfString1);
      localStringBuilder.append(" selection = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" selectionArgs = ");
      localStringBuilder.append(paramArrayOfString2);
      localStringBuilder.append(" sortOrder = ");
      localStringBuilder.append(paramString2);
      QLog.i("EmoticonContentProvider", 2, localStringBuilder.toString());
    }
    localObject2 = a(getRuntime((String)localObject2), (String)localObject2, true);
    if (localObject2 == null)
    {
      paramArrayOfString1 = new StringBuilder();
      paramArrayOfString1.append("query, db null, uri=");
      paramArrayOfString1.append(paramUri);
      QLog.e("EmoticonContentProvider", 1, paramArrayOfString1.toString());
      return null;
    }
    switch (i)
    {
    default: 
      paramArrayOfString1 = localObject1;
      if (QLog.isColorLevel())
      {
        paramArrayOfString1 = new StringBuilder();
        paramArrayOfString1.append("Uri match missing! match: ");
        paramArrayOfString1.append(paramUri);
        QLog.e("EmoticonContentProvider", 2, paramArrayOfString1.toString());
        paramArrayOfString1 = localObject1;
      }
      break;
    case 1003: 
      paramArrayOfString1 = ((SQLiteDatabase)localObject2).query("Emoticon", paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
      break;
    case 1002: 
      paramArrayOfString1 = ((SQLiteDatabase)localObject2).query("CustomEmotionData", paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
      break;
    case 1001: 
      paramArrayOfString1 = ((SQLiteDatabase)localObject2).query("EmoticonTab", paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
      break;
    case 1000: 
      paramArrayOfString1 = ((SQLiteDatabase)localObject2).query("EmoticonPackage", paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
    }
    if (paramArrayOfString1 != null) {
      paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
    }
    return paramArrayOfString1;
  }
  
  public int update(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmoticonContentProvider
 * JD-Core Version:    0.7.0.1
 */