package cooperation.wadl;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import bibw;
import biby;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class WadlProvider
  extends ContentProvider
{
  private static final UriMatcher jdField_a_of_type_AndroidContentUriMatcher = new UriMatcher(-1);
  ContentResolver jdField_a_of_type_AndroidContentContentResolver;
  bibw jdField_a_of_type_Bibw;
  
  static
  {
    try
    {
      jdField_a_of_type_AndroidContentUriMatcher.addURI("cooperation.wadl.provider", "query_task_qqgame", 0);
      jdField_a_of_type_AndroidContentUriMatcher.addURI("cooperation.wadl.provider", "insert_task_qqgame", 1);
      jdField_a_of_type_AndroidContentUriMatcher.addURI("cooperation.wadl.provider", "update_task_qqgame", 2);
      jdField_a_of_type_AndroidContentUriMatcher.addURI("cooperation.wadl.provider", "delete_task_qqgame", 3);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("WadlProvider", 2, "WadlProvider amazing at ", localThrowable);
    }
  }
  
  public static Uri.Builder a(String paramString)
  {
    return Uri.parse("content://cooperation.wadl.provider/" + paramString).buildUpon();
  }
  
  @Nullable
  public Bundle call(@NonNull String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {}
    while (!"isAvailable".equals(paramString1)) {
      return localObject2;
    }
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 != null) {}
    for (localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();; localObject1 = null)
    {
      boolean bool;
      if (localObject1 != null)
      {
        bool = ((AppRuntime)localObject1).isLogin();
        label58:
        if (!bool) {
          break label162;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putBoolean("isLogin", true);
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WadlProvider", 2, "call method=" + paramString1 + ",arg=" + paramString2 + ",extras=" + paramBundle + ",isLogin=" + bool + ",retBundle=" + localObject1);
        return localObject1;
        bool = false;
        break label58;
        label162:
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("WadlProvider", 2, "call provider fail, is not login");
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public int delete(@NonNull Uri paramUri, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {}
    do
    {
      return 0;
      if (QLog.isColorLevel()) {
        QLog.d("WadlProvider", 2, "delete uri=" + paramUri);
      }
      switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
      {
      default: 
        return 0;
      }
      if (!TextUtils.isEmpty(biby.b(paramUri.getQueryParameter("encryptStr"), "^*^%&$((2020ggy!")))
      {
        int i = this.jdField_a_of_type_Bibw.a(paramString, paramArrayOfString);
        this.jdField_a_of_type_AndroidContentContentResolver.notifyChange(paramUri, null);
        return i;
      }
    } while (!QLog.isColorLevel());
    QLog.w("WadlProvider", 2, "delete fail, permission error!");
    return 0;
  }
  
  @Nullable
  public String getType(@NonNull Uri paramUri)
  {
    return "";
  }
  
  @Nullable
  public Uri insert(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {
      paramContentValues = null;
    }
    do
    {
      return paramContentValues;
      if (QLog.isColorLevel()) {
        QLog.d("WadlProvider", 2, "insert uri=" + paramUri);
      }
      switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
      {
      default: 
        return paramUri;
      }
      if (!TextUtils.isEmpty(biby.b(paramUri.getQueryParameter("encryptStr"), "^*^%&$((2020ggy!")))
      {
        this.jdField_a_of_type_Bibw.a(paramContentValues);
        this.jdField_a_of_type_AndroidContentContentResolver.notifyChange(paramUri, null);
        return paramUri;
      }
      paramContentValues = paramUri;
    } while (!QLog.isColorLevel());
    QLog.w("WadlProvider", 2, "insert fail, permission error!");
    return paramUri;
  }
  
  public boolean onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProvider", 2, "onCreate");
    }
    this.jdField_a_of_type_Bibw = new bibw(getContext());
    this.jdField_a_of_type_Bibw.a(this.jdField_a_of_type_Bibw.getReadableDatabase(), this.jdField_a_of_type_Bibw.getWritableDatabase());
    this.jdField_a_of_type_AndroidContentContentResolver = getContext().getContentResolver();
    return true;
  }
  
  @Nullable
  public Cursor query(@NonNull Uri paramUri, @Nullable String[] paramArrayOfString1, @Nullable String paramString1, @Nullable String[] paramArrayOfString2, @Nullable String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProvider", 2, "query uri=" + paramUri);
    }
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      paramUri = new MatrixCursor(new String[] { "ret_code" });
      paramUri.addRow(new Object[] { Integer.valueOf(-1000) });
    }
    do
    {
      Object localObject;
      do
      {
        return paramUri;
        localObject = null;
        switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
        {
        default: 
          return null;
        }
        if (TextUtils.isEmpty(biby.b(paramUri.getQueryParameter("encryptStr"), "^*^%&$((2020ggy!"))) {
          break;
        }
        paramArrayOfString1 = this.jdField_a_of_type_Bibw.a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
        paramUri = paramArrayOfString1;
      } while (!QLog.isColorLevel());
      QLog.d("WadlProvider", 2, "query cursor=" + paramArrayOfString1);
      return paramArrayOfString1;
      paramUri = localObject;
    } while (!QLog.isColorLevel());
    QLog.w("WadlProvider", 2, "query fail, permission error!");
    return null;
  }
  
  public int update(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {}
    do
    {
      return 0;
      if (QLog.isColorLevel()) {
        QLog.d("WadlProvider", 2, "update uri=" + paramUri + ",selection=" + paramString);
      }
      switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
      {
      default: 
        return 0;
      }
      if (!TextUtils.isEmpty(biby.b(paramUri.getQueryParameter("encryptStr"), "^*^%&$((2020ggy!")))
      {
        int i = this.jdField_a_of_type_Bibw.a(paramContentValues, paramString, paramArrayOfString);
        this.jdField_a_of_type_AndroidContentContentResolver.notifyChange(paramUri, null);
        return i;
      }
    } while (!QLog.isColorLevel());
    QLog.w("WadlProvider", 2, "update fail, permission error!");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.wadl.WadlProvider
 * JD-Core Version:    0.7.0.1
 */