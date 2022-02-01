package com.tencent.mobileqq.qcircle.api.db.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.api.ISecurityUtile;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptUtil
{
  protected static final Object a;
  private static boolean jdField_a_of_type_Boolean = false;
  public SQLiteDatabase a;
  private final Map<String, ArrayList<String>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(32);
  private final Map<String, ArrayList<String>> b = new ConcurrentHashMap(32);
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public EncryptUtil(SQLiteDatabase paramSQLiteDatabase)
  {
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = paramSQLiteDatabase;
  }
  
  /* Error */
  private Cursor a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: getfield 33	com/tencent/mobileqq/qcircle/api/db/util/EncryptUtil:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   8: aload_1
    //   9: aload_2
    //   10: invokevirtual 47	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +26 -> 41
    //   18: new 49	com/tencent/mobileqq/qcircle/api/db/DbSafeCursorWrapper
    //   21: dup
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 33	com/tencent/mobileqq/qcircle/api/db/util/EncryptUtil:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   27: invokevirtual 53	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   30: invokespecial 56	com/tencent/mobileqq/qcircle/api/db/DbSafeCursorWrapper:<init>	(Landroid/database/Cursor;Ljava/lang/String;)V
    //   33: astore_2
    //   34: aload_2
    //   35: areturn
    //   36: aload_1
    //   37: areturn
    //   38: astore_1
    //   39: aload_1
    //   40: athrow
    //   41: aconst_null
    //   42: areturn
    //   43: astore_1
    //   44: aconst_null
    //   45: areturn
    //   46: astore_2
    //   47: goto -11 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	EncryptUtil
    //   0	50	1	paramString	String
    //   0	50	2	paramArrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   4	14	38	finally
    //   18	34	38	finally
    //   4	14	43	java/lang/Throwable
    //   18	34	46	java/lang/Throwable
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
    String str;
    if (paramString.length() > 0) {
      str = ((ISecurityUtile)QRoute.api(ISecurityUtile.class)).encode(paramString);
    } else {
      str = paramString;
    }
    if ((!TextUtils.isEmpty(str)) && (!str.equals(paramString)))
    {
      paramString = new StringBuilder();
      paramString.append("@$#%&^");
      paramString.append(str);
      return paramString.toString();
    }
    a(1);
    return paramString;
  }
  
  private ArrayList<String> a(String paramString, String[] paramArrayOfString)
  {
    if (RFLog.isColorLevel()) {
      RFLog.d("QCircleDbCacheDatabase.EncryptUtil", RFLog.CLR, paramString);
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
      if (RFLog.isColorLevel()) {
        RFLog.e("QCircleDbCacheDatabase.EncryptUtil", RFLog.CLR, new Object[] { "analyseTableField exception: ", paramString });
      }
    }
    return new ArrayList();
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", "0");
    localHashMap.put("type", String.valueOf(paramInt));
    jdField_a_of_type_Boolean = true;
  }
  
  public static boolean a()
  {
    int i = QCircleConfigHelper.a("QZoneSetting", "db_encryption", Integer.valueOf(0)).intValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dbencrypt_");
    localStringBuilder.append(QUA.getQUA3());
    int j = LocalMultiProcConfig.getInt4Uin(localStringBuilder.toString(), 1, QCircleHostStubUtil.getCurrentAccountLongUin());
    return (i == 1) && (j == 1);
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
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (!paramString.startsWith("@$#%&^")) {
      return paramString;
    }
    String str1;
    synchronized (jdField_a_of_type_JavaLangObject)
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
            RFLog.e("QCircleDbCacheDatabase.EncryptUtil", RFLog.USR, new Object[] { paramString });
          }
          str2 = ((ISecurityUtile)QRoute.api(ISecurityUtile.class)).encode(str1);
          if (TextUtils.isEmpty(str2)) {
            break label143;
          }
          paramString = str2;
          if (str2.equals(str1)) {
            break label143;
          }
        }
        return paramString;
        label143:
        a(0);
        paramString = new StringBuilder();
        paramString.append("dbencrypt_");
        paramString.append(QUA.getQUA3());
        LocalMultiProcConfig.putInt4Uin(paramString.toString(), 0, QCircleHostStubUtil.getCurrentAccountLongUin());
        return str2;
        throw paramString;
      }
    }
  }
  
  private ArrayList<String> b(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return (ArrayList)this.b.get(paramString);
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
    this.b.put(paramString, localArrayList);
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
      paramString2 = a(paramString2);
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
  
  public ArrayList<String> a(String paramString)
  {
    if (!a()) {
      return null;
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      Cursor localCursor = a("select sql from sqlite_master where type=? and name=?", new String[] { "table", paramString });
      if (localCursor != null)
      {
        if (localCursor.moveToFirst())
        {
          ArrayList localArrayList = a(localCursor.getString(0), new String[] { "STRING" });
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localArrayList);
        }
        localCursor.close();
      }
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
      paramString1 = a(paramString2);
      if (paramString1 != null)
      {
        paramString2 = b(paramString3);
        int i = 0;
        while (i < paramString2.size())
        {
          if ((paramString1.contains(paramString2.get(i))) && ((paramArrayOfString[i] instanceof String))) {
            paramArrayOfString[i] = a(paramArrayOfString[i]);
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.util.EncryptUtil
 * JD-Core Version:    0.7.0.1
 */