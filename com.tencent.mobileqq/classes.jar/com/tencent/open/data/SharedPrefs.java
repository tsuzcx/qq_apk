package com.tencent.open.data;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.OpenConst;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class SharedPrefs
  implements OpenConst
{
  private static SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  private static boolean jdField_a_of_type_Boolean;
  
  /* Error */
  @android.annotation.TargetApi(11)
  public static SharedPreferences a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/tencent/open/data/SharedPrefs:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   6: ifnonnull +27 -> 33
    //   9: invokestatic 27	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   12: astore_1
    //   13: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   16: bipush 10
    //   18: if_icmple +24 -> 42
    //   21: iconst_4
    //   22: istore_0
    //   23: aload_1
    //   24: ldc 35
    //   26: iload_0
    //   27: invokevirtual 39	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   30: putstatic 21	com/tencent/open/data/SharedPrefs:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   33: getstatic 21	com/tencent/open/data/SharedPrefs:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   36: astore_1
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: iconst_0
    //   43: istore_0
    //   44: goto -21 -> 23
    //   47: astore_1
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	22	0	i	int
    //   12	29	1	localObject1	Object
    //   47	5	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	21	47	finally
    //   23	33	47	finally
    //   33	37	47	finally
  }
  
  public static ArrayList a()
  {
    a();
    return a("login_history");
  }
  
  private static ArrayList a(String paramString)
  {
    Object localObject1 = null;
    try
    {
      Object localObject3 = a().getString(paramString, "");
      if (((String)localObject3).length() > 0)
      {
        String[] arrayOfString = ((String)localObject3).split(",");
        localObject3 = new ArrayList();
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          localObject1 = localObject3;
          if (i >= j) {
            break;
          }
          ((ArrayList)localObject3).add(arrayOfString[i]);
          i += 1;
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  private static JSONObject a(String paramString)
  {
    JSONObject localJSONObject = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        if (jdField_a_of_type_JavaUtilHashMap == null)
        {
          jdField_a_of_type_JavaUtilHashMap = new HashMap();
          if (localJSONObject != null) {
            break label95;
          }
          localObject2 = a().getString(paramString, "{}");
        }
      }
      finally {}
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject((String)localObject2);
        }
        catch (JSONException localJSONException2)
        {
          paramString = localJSONException1;
          Object localObject1 = localJSONException2;
          break;
        }
        try
        {
          jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject2);
          paramString = (String)localObject2;
          return paramString;
        }
        catch (JSONException localJSONException1)
        {
          paramString = (String)localObject2;
          break;
        }
      }
      localJSONObject = (JSONObject)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      continue;
      localJSONObject.printStackTrace();
      continue;
      label95:
      paramString = localJSONException1;
    }
  }
  
  private static void a()
  {
    Object localObject1;
    String str1;
    Object localObject2;
    int j;
    int i;
    Object localObject3;
    if (!a())
    {
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("accountList", 0);
      str1 = ((SharedPreferences)localObject1).getString("last_account", null);
      localObject1 = ((SharedPreferences)localObject1).getString("accList", null);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label345;
      }
      localObject2 = ((String)localObject1).split(",");
      if (localObject2 == null) {
        break label345;
      }
      localObject1 = new ArrayList(localObject2.length);
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals(str1))) {
          ((ArrayList)localObject1).add(localObject3);
        }
        i += 1;
      }
    }
    for (;;)
    {
      localObject2 = MsfSdkUtils.getLoginedAccountList();
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SimpleAccount)((Iterator)localObject2).next();
          if (((SimpleAccount)localObject3).isLogined())
          {
            a(((SimpleAccount)localObject3).getUin(), "login_history", true);
            i = 1;
          }
          for (;;)
          {
            break;
            if (!((SimpleAccount)localObject3).getUin().equals(str1)) {
              break label337;
            }
            str1 = null;
            label194:
            if (localObject1 == null) {
              break label334;
            }
            Iterator localIterator = ((ArrayList)localObject1).iterator();
            String str2;
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              str2 = (String)localIterator.next();
            } while (!((SimpleAccount)localObject3).getUin().equals(str2));
            ((ArrayList)localObject1).remove(str2);
          }
        }
      }
      for (;;)
      {
        j = i;
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            a((String)((Iterator)localObject1).next(), "login_history", true);
            i = 1;
          }
        }
        if (!TextUtils.isEmpty(str1))
        {
          a(str1, "login_history", true);
          j = 1;
        }
        if (j != 0) {
          a().edit().putBoolean("have_ever_login", true).commit();
        }
        return;
        label334:
        break;
        label337:
        break label194;
        i = 0;
      }
      label345:
      localObject1 = null;
    }
  }
  
  public static void a(String paramString)
  {
    a();
    a(paramString, "login_history");
    a(paramString, "login_history", true);
    if (!a()) {
      a().edit().putBoolean("have_ever_login", true).commit();
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    JSONObject localJSONObject = a("last_skey_update_time");
    if (localJSONObject != null) {}
    try
    {
      localJSONObject.put(paramString, paramLong);
      a("last_skey_update_time", localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      for (;;)
      {
        try
        {
          String str = a().getString(paramString2, "");
          if (str.length() > 0)
          {
            Matcher localMatcher = Pattern.compile("(^|,)" + paramString1 + "($|,)").matcher(str);
            if (localMatcher.find())
            {
              paramString1 = ",";
              if ((localMatcher.start() == 0) || (localMatcher.end() == str.length())) {
                break label126;
              }
              paramString1 = localMatcher.replaceFirst(paramString1);
              a().edit().putString(paramString2, paramString1).commit();
            }
          }
          return;
        }
        finally {}
        label126:
        paramString1 = "";
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    if (!TextUtils.isEmpty(paramString1)) {}
    label169:
    for (;;)
    {
      String str;
      try
      {
        str = a().getString(paramString2, "");
        if (str.length() <= 0) {
          break label169;
        }
        if (!Pattern.compile("(^|,)" + paramString1 + "($|,)").matcher(str).find())
        {
          if (paramBoolean)
          {
            paramString1 = paramString1 + "," + str;
            if (i != 0) {
              a().edit().putString(paramString2, paramString1).commit();
            }
            return;
          }
          paramString1 = str + "," + paramString1;
          continue;
        }
        i = 0;
      }
      finally {}
      paramString1 = str;
      continue;
      return;
    }
  }
  
  private static void a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilHashMap != null) {
        jdField_a_of_type_JavaUtilHashMap.put(paramString, paramJSONObject);
      }
      a().edit().putString(paramString, paramJSONObject.toString()).commit();
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = a().getBoolean("have_ever_login", false);
    }
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(String paramString)
  {
    JSONObject localJSONObject = a("last_skey_update_time");
    if (localJSONObject != null) {}
    try
    {
      long l1 = localJSONObject.getLong(paramString);
      long l2 = System.currentTimeMillis();
      return l2 - l1 > 43200000L;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return true;
  }
  
  public static void b(String paramString)
  {
    a(paramString, "login_history");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.data.SharedPrefs
 * JD-Core Version:    0.7.0.1
 */