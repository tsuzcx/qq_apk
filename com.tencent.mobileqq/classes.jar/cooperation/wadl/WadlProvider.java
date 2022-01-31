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
import bkhz;
import bkib;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class WadlProvider
  extends ContentProvider
{
  private static final UriMatcher jdField_a_of_type_AndroidContentUriMatcher = new UriMatcher(-1);
  public static String a;
  public static boolean a;
  ContentResolver jdField_a_of_type_AndroidContentContentResolver;
  bkhz jdField_a_of_type_Bkhz;
  private volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
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
  
  private void a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WadlProvider", 2, "init...");
      }
      this.jdField_a_of_type_Bkhz = new bkhz(getContext());
      this.jdField_a_of_type_Bkhz.a(this.jdField_a_of_type_Bkhz.getReadableDatabase(), this.jdField_a_of_type_Bkhz.getWritableDatabase());
      this.jdField_a_of_type_AndroidContentContentResolver = getContext().getContentResolver();
    }
  }
  
  @Nullable
  public Bundle call(@NonNull String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle)
  {
    boolean bool2 = false;
    Object localObject = null;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {}
    do
    {
      do
      {
        return null;
        a();
      } while (!"isAvailable".equals(paramString1));
      if (jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WadlProvider", 2, "call method=" + paramString1 + ",arg=" + paramString2 + ",extras=" + paramBundle + ",providerSwitch=" + jdField_a_of_type_Boolean + ",retBundle=" + null);
    return null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localObject = localBaseApplicationImpl.getRuntime();
    }
    boolean bool3 = bkib.a("com.tencent.mobileqq:TMAssistantDownloadSDKService");
    if (localObject != null) {
      bool2 = ((AppRuntime)localObject).isLogin();
    }
    for (boolean bool1 = ((AppRuntime)localObject).isRunning();; bool1 = false)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("isRunning", bool1);
      ((Bundle)localObject).putBoolean("isLogin", bool2);
      ((Bundle)localObject).putBoolean("isTMRunning", bool3);
      if (QLog.isColorLevel()) {
        QLog.d("WadlProvider", 2, "call method=" + paramString1 + ",arg=" + paramString2 + ",extras=" + paramBundle + ",isRunning=" + bool1 + ",isLogin=" + bool2 + ",isTMRunning=" + bool3);
      }
      return localObject;
    }
  }
  
  public int delete(@NonNull Uri paramUri, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProvider", 2, "delete uri=" + paramUri);
    }
    if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) || (!jdField_a_of_type_Boolean)) {}
    do
    {
      return 0;
      a();
      switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
      {
      default: 
        return 0;
      }
      if (!TextUtils.isEmpty(bkib.b(paramUri.getQueryParameter("encryptStr"), jdField_a_of_type_JavaLangString)))
      {
        int i = this.jdField_a_of_type_Bkhz.a(paramString, paramArrayOfString);
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
    if (QLog.isColorLevel()) {
      QLog.d("WadlProvider", 2, "insert uri=" + paramUri);
    }
    if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) || (!jdField_a_of_type_Boolean)) {
      paramContentValues = null;
    }
    do
    {
      return paramContentValues;
      a();
      switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
      {
      default: 
        return paramUri;
      }
      if (!TextUtils.isEmpty(bkib.b(paramUri.getQueryParameter("encryptStr"), jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Bkhz.a(paramContentValues);
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
    return true;
  }
  
  @Nullable
  public Cursor query(@NonNull Uri paramUri, @Nullable String[] paramArrayOfString1, @Nullable String paramString1, @Nullable String[] paramArrayOfString2, @Nullable String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProvider", 2, "query uri=" + paramUri);
    }
    if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) || (!jdField_a_of_type_Boolean))
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
        a();
        localObject = null;
        switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
        {
        default: 
          return null;
        }
        if (TextUtils.isEmpty(bkib.b(paramUri.getQueryParameter("encryptStr"), jdField_a_of_type_JavaLangString))) {
          break;
        }
        paramArrayOfString1 = this.jdField_a_of_type_Bkhz.a(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
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
    if (QLog.isColorLevel()) {
      QLog.d("WadlProvider", 2, "update uri=" + paramUri + ",selection=" + paramString);
    }
    if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) || (!jdField_a_of_type_Boolean)) {}
    do
    {
      return 0;
      a();
      switch (jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
      {
      default: 
        return 0;
      }
      if (!TextUtils.isEmpty(bkib.b(paramUri.getQueryParameter("encryptStr"), jdField_a_of_type_JavaLangString)))
      {
        int i = this.jdField_a_of_type_Bkhz.a(paramContentValues, paramString, paramArrayOfString);
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