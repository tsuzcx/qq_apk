package com.tencent.mobileqq.qcircle.api.db.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.api.ISecurityUtile;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptUtil
{
  protected static final Object b = new Object();
  private static boolean e = false;
  public SQLiteDatabase a;
  private final Map<String, ArrayList<String>> c = new ConcurrentHashMap(32);
  private final Map<String, ArrayList<String>> d = new ConcurrentHashMap(32);
  
  public EncryptUtil(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a = paramSQLiteDatabase;
  }
  
  public static String a(String paramString)
  {
    if (!a()) {
      return paramString;
    }
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.startsWith("@$#%&^")) {
      return paramString;
    }
    String str1;
    if (paramString.length() > 0) {
      str1 = ((ISecurityUtile)QRoute.api(ISecurityUtile.class)).encode(paramString);
    } else {
      str1 = paramString;
    }
    String str2 = paramString;
    if (!TextUtils.isEmpty(str1))
    {
      if (str1.equals(paramString)) {
        return paramString;
      }
      paramString = new StringBuilder();
      paramString.append("@$#%&^");
      paramString.append(str1);
      str2 = paramString.toString();
    }
    return str2;
  }
  
  private ArrayList<String> a(String paramString, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleDbCacheDatabase.EncryptUtil", 2, paramString);
    }
    try
    {
      paramString = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")")).split(",");
      ArrayList localArrayList = new ArrayList();
      int k = paramArrayOfString.length;
      int i = 0;
      while (i < k)
      {
        String str = paramArrayOfString[i].toLowerCase().trim();
        int m = paramString.length;
        int j = 0;
        while (j < m)
        {
          String[] arrayOfString = paramString[j].trim().split(" ");
          if ((arrayOfString.length > 1) && (str.equals(arrayOfString[1].toLowerCase()))) {
            localArrayList.add(arrayOfString[0]);
          }
          j += 1;
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QCircleDbCacheDatabase.EncryptUtil", 2, "analyseTableField exception: ", paramString);
      }
    }
    return new ArrayList();
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    int i = QCircleConfigHelper.a("QZoneSetting", "db_encryption", Integer.valueOf(0)).intValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dbencrypt_");
    localStringBuilder.append(QUA.getQUA3());
    int j = LocalMultiProcConfig.getInt4Uin(localStringBuilder.toString(), 1, QCircleHostStubUtil.getCurrentAccountLongUin());
    boolean bool1 = bool2;
    if (i == 1)
    {
      bool1 = bool2;
      if (j == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2));
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return paramArrayOfByte;
      }
      arrayOfByte = ((ISecurityUtile)QRoute.api(ISecurityUtile.class)).encode(paramArrayOfByte);
    }
    return arrayOfByte;
  }
  
  /* Error */
  private Cursor b(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/tencent/mobileqq/qcircle/api/db/util/EncryptUtil:a	Landroid/database/sqlite/SQLiteDatabase;
    //   4: aload_1
    //   5: aload_2
    //   6: invokevirtual 185	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +26 -> 37
    //   14: new 187	com/tencent/mobileqq/qcircle/api/db/DbSafeCursorWrapper
    //   17: dup
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 36	com/tencent/mobileqq/qcircle/api/db/util/EncryptUtil:a	Landroid/database/sqlite/SQLiteDatabase;
    //   23: invokevirtual 190	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   26: invokespecial 193	com/tencent/mobileqq/qcircle/api/db/DbSafeCursorWrapper:<init>	(Landroid/database/Cursor;Ljava/lang/String;)V
    //   29: astore_2
    //   30: aload_2
    //   31: areturn
    //   32: aload_1
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: athrow
    //   37: aconst_null
    //   38: areturn
    //   39: astore_1
    //   40: aconst_null
    //   41: areturn
    //   42: astore_2
    //   43: goto -11 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	EncryptUtil
    //   0	46	1	paramString	String
    //   0	46	2	paramArrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   0	10	34	finally
    //   14	30	34	finally
    //   0	10	39	java/lang/Throwable
    //   14	30	42	java/lang/Throwable
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (!paramString.startsWith("@$#%&^")) {
      return paramString;
    }
    String str1;
    synchronized (b)
    {
      str1 = paramString.substring(6);
      if (str1.length() > 0)
      {
        paramString = ((ISecurityUtile)QRoute.api(ISecurityUtile.class)).encode(str1);
        String str2;
        if (!TextUtils.isEmpty(paramString))
        {
          boolean bool = paramString.equals(str1);
          if (!bool) {}
        }
        else
        {
          try
          {
            Thread.sleep(200L);
          }
          catch (Exception paramString)
          {
            QLog.e("QCircleDbCacheDatabase.EncryptUtil", 1, paramString, new Object[0]);
          }
          str2 = ((ISecurityUtile)QRoute.api(ISecurityUtile.class)).encode(str1);
          if (TextUtils.isEmpty(str2)) {
            break label138;
          }
          paramString = str2;
          if (str2.equals(str1)) {
            break label138;
          }
        }
        return paramString;
        label138:
        paramString = new StringBuilder();
        paramString.append("dbencrypt_");
        paramString.append(QUA.getQUA3());
        LocalMultiProcConfig.putInt4Uin(paramString.toString(), 0, QCircleHostStubUtil.getCurrentAccountLongUin());
        return str2;
        throw paramString;
      }
    }
  }
  
  private ArrayList<String> d(String paramString)
  {
    if (this.d.containsKey(paramString)) {
      return (ArrayList)this.d.get(paramString);
    }
    Matcher localMatcher = Pattern.compile("\\s*\\w+\\s*(!<|!>|>|<|==|=|>=|<=|!=|=!|<>)\\s*\\?\\s*").matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    while (localMatcher.find())
    {
      Object localObject = localMatcher.group().trim();
      localObject = Pattern.compile("\\w+").matcher((CharSequence)localObject);
      ((Matcher)localObject).find();
      localArrayList.add(((Matcher)localObject).group());
    }
    this.d.put(paramString, localArrayList);
    return localArrayList;
  }
  
  public ContentValues a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    if (paramContentValues != null)
    {
      if (paramContentValues.size() <= 0) {
        return paramContentValues;
      }
      if (!a(paramString1, paramString2)) {
        return paramContentValues;
      }
      paramString1 = new ContentValues(paramContentValues);
      paramString2 = c(paramString2);
      if (paramString2 != null)
      {
        paramString2 = paramString2.iterator();
        while (paramString2.hasNext())
        {
          String str = (String)paramString2.next();
          if (paramContentValues.containsKey(str))
          {
            Object localObject = paramContentValues.get(str);
            if ((localObject instanceof String))
            {
              localObject = (String)paramContentValues.get(str);
              if ((localObject != null) && (((String)localObject).length() > 0)) {
                paramString1.put(str, a((String)localObject));
              }
            }
            else if ((localObject instanceof byte[]))
            {
              paramString1.put(str, a((byte[])localObject));
            }
            else if ((localObject instanceof Long))
            {
              paramString1.put(str, a(String.valueOf(localObject)));
            }
            else if ((localObject instanceof Integer))
            {
              paramString1.put(str, a(String.valueOf(localObject)));
            }
            else if ((localObject instanceof Double))
            {
              paramString1.put(str, a(String.valueOf(localObject)));
            }
          }
        }
      }
      return paramString1;
    }
    return paramContentValues;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (paramString3 != null)
    {
      if (paramArrayOfString == null) {
        return;
      }
      if (!a(paramString1, paramString2)) {
        return;
      }
      paramString1 = c(paramString2);
      if (paramString1 != null)
      {
        paramString2 = d(paramString3);
        int i = 0;
        while (i < paramString2.size())
        {
          if (paramString1.contains(paramString2.get(i))) {
            paramArrayOfString[i] = a(paramArrayOfString[i]);
          }
          i += 1;
        }
      }
    }
  }
  
  public ArrayList<String> c(String paramString)
  {
    if (!a()) {
      return null;
    }
    if (!this.c.containsKey(paramString))
    {
      Cursor localCursor = b("select sql from sqlite_master where type=? and name=?", new String[] { "table", paramString });
      if (localCursor != null)
      {
        if (localCursor.moveToFirst())
        {
          ArrayList localArrayList = a(localCursor.getString(0), new String[] { "STRING" });
          this.c.put(paramString, localArrayList);
        }
        localCursor.close();
      }
    }
    return (ArrayList)this.c.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.util.EncryptUtil
 * JD-Core Version:    0.7.0.1
 */