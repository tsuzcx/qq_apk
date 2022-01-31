package cooperation.readinjoy.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import bkby;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppContentProvider;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ReadInJoyDataProvider
  extends AppContentProvider
{
  public static final Uri a;
  static String jdField_a_of_type_JavaLangString = "content://qq.readinjoy/";
  public static final Uri b = Uri.parse(jdField_a_of_type_JavaLangString + "notify_msg_records");
  public static final Uri c = Uri.parse(jdField_a_of_type_JavaLangString + "feeds_msg_records");
  public static final Uri d = Uri.parse(jdField_a_of_type_JavaLangString + "recent_data");
  public static final Uri e = Uri.parse(jdField_a_of_type_JavaLangString + "common_records");
  private UriMatcher jdField_a_of_type_AndroidContentUriMatcher;
  private bkby jdField_a_of_type_Bkby;
  
  static
  {
    jdField_a_of_type_AndroidNetUri = Uri.parse(jdField_a_of_type_JavaLangString + "subscribe_msg_records");
  }
  
  private SQLiteDatabase a(Uri paramUri, boolean paramBoolean)
  {
    String str1 = paramUri.getQueryParameter("uin");
    if (str1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDataProvider", 2, "getDBHelper, uin = null, uri=" + paramUri.getPath());
      }
    }
    AppRuntime localAppRuntime;
    String str2;
    do
    {
      do
      {
        return null;
        localAppRuntime = getRuntime(str1);
        if (localAppRuntime != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoyDataProvider", 2, "getDBHelper, ar is null, uri=" + paramUri.getPath());
      return null;
      str2 = localAppRuntime.getAccount();
      if (str2.equals(str1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyDataProvider", 2, "getDBHelper, uin not equal, uri=" + paramUri.getPath() + ", current account=" + localAppRuntime.getAccount());
    return null;
    if ((this.jdField_a_of_type_Bkby == null) || (!this.jdField_a_of_type_Bkby.jdField_a_of_type_JavaLangString.equals(str2)))
    {
      this.jdField_a_of_type_Bkby = new bkby(this, localAppRuntime.getApplication().getApplicationContext(), str1);
      this.jdField_a_of_type_Bkby.jdField_a_of_type_JavaLangString = str2;
    }
    if (paramBoolean) {
      return this.jdField_a_of_type_Bkby.getReadableDatabase();
    }
    return this.jdField_a_of_type_Bkby.getWritableDatabase();
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {}
    SQLiteDatabase localSQLiteDatabase = a(paramUri, false);
    if (localSQLiteDatabase == null) {
      return -1;
    }
    switch (this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    case 2002: 
    default: 
      return 0;
    case 2000: 
      return localSQLiteDatabase.delete("subscribe_msg_records", paramString, paramArrayOfString);
    case 2001: 
      localSQLiteDatabase.execSQL("DELETE from notify_msg_records;");
      return 0;
    case 2003: 
      return localSQLiteDatabase.delete("feeds_msg_records", paramString, paramArrayOfString);
    }
    return localSQLiteDatabase.delete("common_records", paramString, paramArrayOfString);
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (QLog.isColorLevel()) {}
    SQLiteDatabase localSQLiteDatabase = a(paramUri, false);
    if (localSQLiteDatabase == null)
    {
      paramUri = null;
      return paramUri;
    }
    long l;
    switch (this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    case 2002: 
    default: 
      l = -1L;
    }
    while (l == -1L)
    {
      return null;
      l = localSQLiteDatabase.insert("subscribe_msg_records", null, paramContentValues);
      continue;
      l = localSQLiteDatabase.insert("notify_msg_records", null, paramContentValues);
      continue;
      l = localSQLiteDatabase.insert("feeds_msg_records", null, paramContentValues);
      continue;
      l = localSQLiteDatabase.insert("common_records", null, paramContentValues);
    }
  }
  
  public boolean onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentUriMatcher = new UriMatcher(-1);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.readinjoy", "subscribe_msg_records", 2000);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.readinjoy", "notify_msg_records", 2001);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.readinjoy", "recent_data", 2002);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.readinjoy", "feeds_msg_records", 2003);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.readinjoy", "common_records", 2004);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (QLog.isColorLevel()) {}
    SQLiteDatabase localSQLiteDatabase = a(paramUri, true);
    if (localSQLiteDatabase == null) {
      return null;
    }
    switch (this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    case 2002: 
    default: 
      return null;
    case 2000: 
      return localSQLiteDatabase.query("subscribe_msg_records", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, paramUri.getQueryParameter("limit"));
    case 2001: 
      return localSQLiteDatabase.query("notify_msg_records", null, null, null, null, null, "msgID DESC", null);
    case 2003: 
      return localSQLiteDatabase.query("feeds_msg_records", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, null);
    }
    return localSQLiteDatabase.query("common_records", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, null);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {}
    SQLiteDatabase localSQLiteDatabase = a(paramUri, false);
    if (localSQLiteDatabase == null) {
      return -1;
    }
    switch (this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    default: 
      return 0;
    case 2003: 
      return localSQLiteDatabase.update("feeds_msg_records", paramContentValues, paramString, paramArrayOfString);
    }
    return localSQLiteDatabase.update("common_records", paramContentValues, paramString, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.readinjoy.content.ReadInJoyDataProvider
 * JD-Core Version:    0.7.0.1
 */