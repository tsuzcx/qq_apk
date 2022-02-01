package com.tencent.mobileqq.qcircle.api.db.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.api.ISecurityUtile;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class EncryptUtil
{
  public static final String HEAD_ENCRYPT = "@$#%&^";
  static final String SQL_GET_TABLE_ATTR = "select sql from sqlite_master where type=? and name=?";
  public static final String TAG = "QCircleDbCacheDatabase.EncryptUtil";
  public static final int WNS_DBENCRY_CLOSED = 0;
  public static final int WNS_DBENCRY_OPEN = 1;
  public static final int WNS_DEFAULT_DBENCRY = 0;
  public static final String WNS_SECONDARY_KEY_DBENCRY = "db_encryption";
  private static boolean hasReport = false;
  protected static final Object lock = new Object();
  public SQLiteDatabase db;
  private final Map<String, ArrayList<String>> queryCacheMap = new ConcurrentHashMap(32);
  private final Map<String, ArrayList<String>> tableMap = new ConcurrentHashMap(32);
  
  public EncryptUtil(SQLiteDatabase paramSQLiteDatabase)
  {
    this.db = paramSQLiteDatabase;
  }
  
  public static String[] analyseRawQueryArgs(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    paramString = Pattern.compile("'[^']+'").matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    while (paramString.find())
    {
      localObject1 = paramString.group().trim();
      localArrayList.add(((String)localObject1).substring(1, ((String)localObject1).length() - 1));
    }
    paramString = paramString.replaceAll(" ? ");
    paramString = Pattern.compile("\\s*(!<|!>|>|<|==|=|>=|<=|!=|=!|<>)\\s*[\\u4E00-\\u9FA5A-Za-z0-9_\\-\\?]+\\s*").matcher(paramString);
    Object localObject1 = new ArrayList();
    while (paramString.find())
    {
      Object localObject2 = paramString.group().trim();
      localObject2 = Pattern.compile("[\\u4E00-\\u9FA5A-Za-z0-9_\\-\\?]+$").matcher((CharSequence)localObject2);
      if (((Matcher)localObject2).find()) {
        ((ArrayList)localObject1).add(((Matcher)localObject2).group().trim());
      }
    }
    int j;
    if (((ArrayList)localObject1).size() > 0)
    {
      paramString = (String[])((ArrayList)localObject1).toArray(new String[0]);
      j = 0;
      label172:
      if (j < paramString.length)
      {
        if (!"?".equals(paramString[j])) {
          break label258;
        }
        if (i < localArrayList.size())
        {
          int k = i + 1;
          paramString[j] = ((String)localArrayList.get(i));
          i = k;
        }
      }
    }
    label258:
    for (;;)
    {
      j += 1;
      break label172;
      RFLog.e("QCircleDbCacheDatabase.EncryptUtil", RFLog.USR, "analyseRawQueryArgs error, params0.size < count(?)");
      return null;
      if (localArrayList.size() == i) {
        break;
      }
      RFLog.e("QCircleDbCacheDatabase.EncryptUtil", RFLog.USR, "analyseRawQueryArgs error, params0.size > count(?)");
      return null;
      return null;
    }
  }
  
  private ArrayList<String> analyseRawQueryWhere(String paramString)
  {
    if (this.queryCacheMap.containsKey(paramString)) {
      return (ArrayList)this.queryCacheMap.get(paramString);
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
    this.queryCacheMap.put(paramString, localArrayList);
    return localArrayList;
  }
  
  private ArrayList<String> analyseTableField(String paramString, String[] paramArrayOfString)
  {
    if (RFLog.isColorLevel()) {
      RFLog.d("QCircleDbCacheDatabase.EncryptUtil", RFLog.CLR, paramString);
    }
    try
    {
      String[] arrayOfString1 = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")")).split(",");
      ArrayList localArrayList = new ArrayList();
      int k = paramArrayOfString.length;
      int i = 0;
      for (;;)
      {
        paramString = localArrayList;
        if (i >= k) {
          break;
        }
        paramString = paramArrayOfString[i].toLowerCase().trim();
        int m = arrayOfString1.length;
        int j = 0;
        while (j < m)
        {
          String[] arrayOfString2 = arrayOfString1[j].trim().split(" ");
          if ((arrayOfString2.length > 1) && (paramString.equals(arrayOfString2[1].toLowerCase()))) {
            localArrayList.add(arrayOfString2[0]);
          }
          j += 1;
        }
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      if (RFLog.isColorLevel()) {
        RFLog.e("QCircleDbCacheDatabase.EncryptUtil", RFLog.CLR, new Object[] { "analyseTableField exception: ", paramString });
      }
      paramString = new ArrayList();
    }
  }
  
  private byte[] convertBlob(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    return ((ISecurityUtile)QRoute.api(ISecurityUtile.class)).encode(paramArrayOfByte);
  }
  
  public static String convertRawQuery(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = Pattern.compile("'[^']+'").matcher(paramString).replaceAll("?");
    localObject = Pattern.compile("\\s*(!<|!>|>|<|==|=|>=|<=|!=|=!|<>)\\s*[\\u4E00-\\u9FA5A-Za-z0-9_\\-\\?]+\\s*").matcher((CharSequence)localObject);
    StringBuffer localStringBuffer = new StringBuffer();
    while (((Matcher)localObject).find())
    {
      String str = ((Matcher)localObject).group();
      Matcher localMatcher = Pattern.compile("[\\u4E00-\\u9FA5A-Za-z0-9_\\-\\?]+\\s*$").matcher(str);
      if (localMatcher.find()) {
        ((Matcher)localObject).appendReplacement(localStringBuffer, str.substring(0, str.length() - localMatcher.group().length()) + "? ");
      }
    }
    if (RFLog.isColorLevel()) {
      RFLog.i("QCircleDbCacheDatabase.EncryptUtil", RFLog.CLR, "convertRawQuery, orign query:" + paramString + " new query:" + localStringBuffer.toString());
    }
    return localStringBuffer.toString();
  }
  
  public static String decryptStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("@$#%&^")) {
      return paramString;
    }
    for (;;)
    {
      String str1;
      synchronized (lock)
      {
        str1 = paramString.substring("@$#%&^".length());
        if (str1.length() <= 0) {
          break label194;
        }
        paramString = ((ISecurityUtile)QRoute.api(ISecurityUtile.class)).encode(str1);
        if (!TextUtils.isEmpty(paramString))
        {
          boolean bool = paramString.equals(str1);
          if (!bool) {
            break label189;
          }
        }
      }
      try
      {
        Thread.sleep(200L);
        String str2 = ((ISecurityUtile)QRoute.api(ISecurityUtile.class)).encode(str1);
        if (!TextUtils.isEmpty(str2))
        {
          paramString = str2;
          if (!str2.equals(str1)) {}
        }
        else
        {
          report(0);
          LocalMultiProcConfig.putInt4Uin("dbencrypt_" + QCircleServiceImpl.getQZoneService().getQUA3(), 0, MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin());
          return str2;
          paramString = finally;
          throw paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          RFLog.e("QCircleDbCacheDatabase.EncryptUtil", RFLog.USR, new Object[] { paramString });
        }
      }
      label189:
      return paramString;
      label194:
      paramString = str1;
    }
  }
  
  public static String encryptStr(String paramString)
  {
    if (!isNeedEncrypt()) {}
    while ((TextUtils.isEmpty(paramString)) || (paramString.startsWith("@$#%&^"))) {
      return paramString;
    }
    if (paramString.length() > 0) {}
    for (String str = ((ISecurityUtile)QRoute.api(ISecurityUtile.class)).encode(paramString);; str = paramString)
    {
      if ((TextUtils.isEmpty(str)) || (str.equals(paramString)))
      {
        report(1);
        return paramString;
      }
      return "@$#%&^" + str;
    }
  }
  
  public static boolean isNeedEncrypt()
  {
    int i = QCircleConfig.getInstance().getConfigValue("QZoneSetting", "db_encryption", Integer.valueOf(0)).intValue();
    int j = LocalMultiProcConfig.getInt4Uin("dbencrypt_" + QCircleServiceImpl.getQZoneService().getQUA3(), 1, MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin());
    return (i == 1) && (j == 1);
  }
  
  public static boolean isTargetTable(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2));
  }
  
  /* Error */
  private Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 342	java/lang/System:currentTimeMillis	()J
    //   5: pop2
    //   6: aload_0
    //   7: getfield 55	com/tencent/mobileqq/qcircle/api/db/util/EncryptUtil:db	Landroid/database/sqlite/SQLiteDatabase;
    //   10: aload_1
    //   11: aload_2
    //   12: invokevirtual 346	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   15: astore_2
    //   16: aload_3
    //   17: astore_1
    //   18: aload_2
    //   19: ifnull +19 -> 38
    //   22: new 348	com/tencent/mobileqq/qcircle/api/db/DbSafeCursorWrapper
    //   25: dup
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 55	com/tencent/mobileqq/qcircle/api/db/util/EncryptUtil:db	Landroid/database/sqlite/SQLiteDatabase;
    //   31: invokevirtual 351	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   34: invokespecial 354	com/tencent/mobileqq/qcircle/api/db/DbSafeCursorWrapper:<init>	(Landroid/database/Cursor;Ljava/lang/String;)V
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
    //   40: astore_1
    //   41: aload_1
    //   42: athrow
    //   43: astore_1
    //   44: aconst_null
    //   45: areturn
    //   46: astore_1
    //   47: aload_2
    //   48: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	EncryptUtil
    //   0	49	1	paramString	String
    //   0	49	2	paramArrayOfString	String[]
    //   1	16	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	16	40	finally
    //   22	38	40	finally
    //   6	16	43	java/lang/Throwable
    //   22	38	46	java/lang/Throwable
  }
  
  public static void report(int paramInt)
  {
    if (hasReport) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", "0");
    localHashMap.put("type", String.valueOf(paramInt));
    hasReport = true;
  }
  
  public ContentValues convertContentValues(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {}
    while (!isTargetTable(paramString1, paramString2)) {
      return paramContentValues;
    }
    paramString1 = new ContentValues(paramContentValues);
    paramString2 = getTableInfo(paramString2);
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
              paramString1.put(str, encryptStr((String)localObject));
            }
          }
          else if ((localObject instanceof byte[]))
          {
            paramString1.put(str, convertBlob((byte[])localObject));
          }
          else if ((localObject instanceof Long))
          {
            paramString1.put(str, encryptStr(String.valueOf(localObject)));
          }
          else if ((localObject instanceof Integer))
          {
            paramString1.put(str, encryptStr(String.valueOf(localObject)));
          }
          else if ((localObject instanceof Double))
          {
            paramString1.put(str, encryptStr(String.valueOf(localObject)));
          }
        }
      }
    }
    return paramString1;
  }
  
  public void convertWhereValues(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if ((paramString3 == null) || (paramArrayOfString == null)) {
      break label9;
    }
    for (;;)
    {
      label9:
      return;
      if (isTargetTable(paramString1, paramString2))
      {
        paramString1 = getTableInfo(paramString2);
        if (paramString1 == null) {
          break;
        }
        paramString2 = analyseRawQueryWhere(paramString3);
        int i = 0;
        while (i < paramString2.size())
        {
          if ((paramString1.contains(paramString2.get(i))) && ((paramArrayOfString[i] instanceof String))) {
            paramArrayOfString[i] = encryptStr(paramArrayOfString[i]);
          }
          i += 1;
        }
      }
    }
  }
  
  public ArrayList<String> getTableInfo(String paramString)
  {
    if (!isNeedEncrypt()) {
      return null;
    }
    if (!this.tableMap.containsKey(paramString))
    {
      Cursor localCursor = rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", paramString });
      if (localCursor != null)
      {
        if (localCursor.moveToFirst())
        {
          ArrayList localArrayList = analyseTableField(localCursor.getString(0), new String[] { "STRING" });
          this.tableMap.put(paramString, localArrayList);
        }
        localCursor.close();
      }
    }
    return (ArrayList)this.tableMap.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.util.EncryptUtil
 * JD-Core Version:    0.7.0.1
 */