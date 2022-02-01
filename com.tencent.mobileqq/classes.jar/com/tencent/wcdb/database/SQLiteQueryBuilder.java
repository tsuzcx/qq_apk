package com.tencent.wcdb.database;

import android.text.TextUtils;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLiteQueryBuilder
{
  private static final Pattern a = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
  private Map<String, String> b = null;
  private String c = "";
  private StringBuilder d = null;
  private boolean e = false;
  private SQLiteDatabase.CursorFactory f = null;
  
  public static String a(boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if ((TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
      throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    }
    if ((!TextUtils.isEmpty(paramString6)) && (!a.matcher(paramString6).matches()))
    {
      paramString1 = new StringBuilder();
      paramString1.append("invalid LIMIT clauses:");
      paramString1.append(paramString6);
      throw new IllegalArgumentException(paramString1.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder(120);
    localStringBuilder.append("SELECT ");
    if (paramBoolean) {
      localStringBuilder.append("DISTINCT ");
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0)) {
      a(localStringBuilder, paramArrayOfString);
    } else {
      localStringBuilder.append("* ");
    }
    localStringBuilder.append("FROM ");
    localStringBuilder.append(paramString1);
    a(localStringBuilder, " WHERE ", paramString2);
    a(localStringBuilder, " GROUP BY ", paramString3);
    a(localStringBuilder, " HAVING ", paramString4);
    a(localStringBuilder, " ORDER BY ", paramString5);
    a(localStringBuilder, " LIMIT ", paramString6);
    return localStringBuilder.toString();
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append(paramString2);
    }
  }
  
  public static void a(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (str != null)
      {
        if (i > 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(str);
      }
      i += 1;
    }
    paramStringBuilder.append(' ');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteQueryBuilder
 * JD-Core Version:    0.7.0.1
 */