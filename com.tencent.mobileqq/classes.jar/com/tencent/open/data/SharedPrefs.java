package com.tencent.open.data;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.OpenConst;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class SharedPrefs
  implements OpenConst
{
  private static SharedPreferences a;
  private static boolean b;
  private static HashMap<String, JSONObject> c;
  
  @TargetApi(11)
  public static SharedPreferences a()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if (a == null)
        {
          localObject1 = BaseApplication.getContext();
          if (Build.VERSION.SDK_INT > 10)
          {
            i = 4;
            a = ((BaseApplication)localObject1).getSharedPreferences("shared_prefs_open", i);
          }
        }
        else
        {
          localObject1 = a;
          return localObject1;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    JSONObject localJSONObject = g("last_skey_update_time");
    if (localJSONObject != null) {
      try
      {
        localJSONObject.put(paramString, paramLong);
        a("last_skey_update_time", localJSONObject);
        QLog.e("open_log", 1, new Object[] { "saveUpdateSkeyTime uin=", AuthorityUtil.a(paramString) });
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("open_log", 1, "saveUpdateSkeyTime", paramString);
      }
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      try
      {
        String str = a().getString(paramString2, "");
        if (str.length() > 0)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("(^|,)");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("($|,)");
          localObject = Pattern.compile(((StringBuilder)localObject).toString()).matcher(str);
          if (((Matcher)localObject).find())
          {
            paramString1 = ",";
            if ((((Matcher)localObject).start() == 0) || (((Matcher)localObject).end() == str.length())) {
              break label135;
            }
            paramString1 = ((Matcher)localObject).replaceFirst(paramString1);
            a().edit().putString(paramString2, paramString1).commit();
          }
        }
        return;
      }
      finally {}
      return;
      label135:
      paramString1 = "";
    }
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      String str;
      try
      {
        str = a().getString(paramString2, "");
        int k = str.length();
        int j = 1;
        i = j;
        localObject = paramString1;
        if (k > 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("(^|,)");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("($|,)");
          if (Pattern.compile(((StringBuilder)localObject).toString()).matcher(str).find()) {
            break label223;
          }
          if (paramBoolean)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(str);
            localObject = ((StringBuilder)localObject).toString();
            i = j;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(paramString1);
            localObject = ((StringBuilder)localObject).toString();
            i = j;
          }
        }
        if (i != 0) {
          a().edit().putString(paramString2, (String)localObject).commit();
        }
        return;
      }
      finally {}
      return;
      label223:
      Object localObject = str;
      int i = 0;
    }
  }
  
  private static void a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      if (c != null) {
        c.put(paramString, paramJSONObject);
      }
      a().edit().putString(paramString, paramJSONObject.toString()).commit();
      return;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
  {
    JSONObject localJSONObject = g("last_skey_update_time");
    boolean bool;
    if (localJSONObject != null) {
      try
      {
        long l1 = localJSONObject.getLong(paramString);
        long l2 = System.currentTimeMillis();
        if (l2 - l1 <= 43200000L) {
          bool = false;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("open_log", 1, "shouldUpdateSkey", paramString);
      }
    } else {
      bool = true;
    }
    QLog.e("open_log", 1, new Object[] { "shouldUpdateSkey ret=", Boolean.valueOf(bool) });
    return bool;
  }
  
  public static ArrayList<String> b()
  {
    e();
    return f("login_history");
  }
  
  public static void b(String paramString)
  {
    QLog.d("open_log", 1, new Object[] { "addLoginHistory uin=", AuthorityUtil.a(paramString) });
    e();
    a(paramString, "login_history");
    a(paramString, "login_history", true);
    if (!d()) {
      a().edit().putBoolean("have_ever_login", true).commit();
    }
  }
  
  public static String c()
  {
    ArrayList localArrayList = f("im_block_uins");
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return (String)localArrayList.get(0);
    }
    return null;
  }
  
  public static void c(String paramString)
  {
    QLog.d("open_log", 1, new Object[] { "addImBlockUin uin=", AuthorityUtil.a(paramString) });
    a(paramString, "im_block_uins");
    a(paramString, "im_block_uins", true);
  }
  
  public static void d(String paramString)
  {
    a(paramString, "login_history");
  }
  
  public static boolean d()
  {
    if (!b) {
      b = a().getBoolean("have_ever_login", false);
    }
    return b;
  }
  
  private static void e()
  {
    if (!d())
    {
      Object localObject1 = BaseApplication.getContext();
      int k = 0;
      int j = 0;
      Object localObject2 = ((BaseApplication)localObject1).getSharedPreferences("accountList", 0);
      localObject1 = ((SharedPreferences)localObject2).getString("last_account", null);
      localObject2 = ((SharedPreferences)localObject2).getString("accList", null);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject4 = ((String)localObject2).split(",");
        if (localObject4 != null)
        {
          localObject3 = new ArrayList(localObject4.length);
          int m = localObject4.length;
          i = 0;
          for (;;)
          {
            localObject2 = localObject3;
            if (i >= m) {
              break;
            }
            localObject2 = localObject4[i];
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(localObject1))) {
              ((ArrayList)localObject3).add(localObject2);
            }
            i += 1;
          }
        }
      }
      localObject2 = null;
      Object localObject4 = MsfSdkUtils.getLoginedAccountList();
      int i = k;
      Object localObject3 = localObject1;
      if (localObject4 != null)
      {
        localObject4 = ((ArrayList)localObject4).iterator();
        for (;;)
        {
          i = j;
          localObject3 = localObject1;
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject4).next();
          if (localSimpleAccount.isLogined())
          {
            a(localSimpleAccount.getUin(), "login_history", true);
            j = 1;
          }
          else
          {
            localObject3 = localObject1;
            if (localSimpleAccount.getUin().equals(localObject1)) {
              localObject3 = null;
            }
            localObject1 = localObject3;
            if (localObject2 != null)
            {
              Iterator localIterator = ((ArrayList)localObject2).iterator();
              do
              {
                localObject1 = localObject3;
                if (!localIterator.hasNext()) {
                  break;
                }
                localObject1 = (String)localIterator.next();
              } while (!localSimpleAccount.getUin().equals(localObject1));
              ((ArrayList)localObject2).remove(localObject1);
              localObject1 = localObject3;
            }
          }
        }
      }
      j = i;
      if (localObject2 != null)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
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
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        a((String)localObject3, "login_history", true);
        j = 1;
      }
      if (j != 0) {
        a().edit().putBoolean("have_ever_login", true).commit();
      }
    }
  }
  
  public static void e(String paramString)
  {
    QLog.d("open_log", 1, new Object[] { "delImBlockUin uin=", AuthorityUtil.a(paramString) });
    a(paramString, "im_block_uins");
  }
  
  private static ArrayList<String> f(String paramString)
  {
    try
    {
      localObject1 = a().getString(paramString, "");
      if (((String)localObject1).length() <= 0) {
        break label84;
      }
      String[] arrayOfString = ((String)localObject1).split(",");
      ArrayList localArrayList = new ArrayList();
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        localObject1 = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(arrayOfString[i]);
        i += 1;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        for (;;)
        {
          throw localObject2;
        }
        label84:
        Object localObject3 = null;
      }
    }
    return localObject1;
  }
  
  private static JSONObject g(String paramString)
  {
    Object localObject1 = null;
    try
    {
      if (c == null) {
        c = new HashMap();
      } else {
        localObject1 = (JSONObject)c.get(paramString);
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = a().getString(paramString, "{}");
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          try
          {
            c.put(paramString, localObject2);
          }
          catch (JSONException paramString)
          {
            localObject1 = localObject2;
          }
          paramString.printStackTrace();
        }
        catch (JSONException paramString) {}
        localObject2 = localObject1;
      }
      return localObject2;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.data.SharedPrefs
 * JD-Core Version:    0.7.0.1
 */