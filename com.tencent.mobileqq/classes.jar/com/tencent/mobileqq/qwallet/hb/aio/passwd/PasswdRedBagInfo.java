package com.tencent.mobileqq.qwallet.hb.aio.passwd;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PasswdRedBagInfo
{
  public String a;
  public String b;
  public String c;
  public long d;
  public String e;
  public boolean f;
  public boolean g;
  public int h;
  public String i;
  public String j;
  
  public PasswdRedBagInfo() {}
  
  public PasswdRedBagInfo(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramLong;
    this.e = paramString4;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    this.h = paramInt;
  }
  
  public PasswdRedBagInfo(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramLong, paramString4, paramBoolean1, paramBoolean2, paramInt);
    this.j = paramString5;
  }
  
  public PasswdRedBagInfo(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString5, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramLong, paramString4, paramBoolean1, paramBoolean2, paramInt);
    this.i = paramString5;
    this.j = paramString6;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("-");
    if (paramString.length < 2) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    int k = 0;
    for (;;)
    {
      if (k < paramString.length) {}
      try
      {
        localJSONArray.put(Integer.parseInt(paramString[k]));
        label53:
        k += 1;
        continue;
        if (localJSONArray.length() > 0) {
          return localJSONArray.toString();
        }
        return "";
      }
      catch (Throwable localThrowable)
      {
        break label53;
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString)
  {
    paramString = a(paramString);
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      paramJSONObject.put("key_poem_rule", paramString);
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public boolean a()
  {
    return this.d < NetConnInfoCenter.getServerTime();
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = true;
    try
    {
      List localList = d();
      if (!localList.contains(Integer.valueOf(paramInt)))
      {
        bool = localList.contains(Integer.valueOf(0));
        if (bool) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("passwdredinfo", 1, localThrowable, new Object[0]);
    }
    return false;
  }
  
  public int b()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getWordChainSubChannel] ");
        localStringBuilder.append(this.j);
        QLog.i("passwdredinfo", 2, localStringBuilder.toString());
      }
      int k = new JSONObject(this.j).optInt("key_sub_channel");
      return k;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("passwdredinfo", 1, QLog.getStackTraceString(localThrowable));
    }
    return -1;
  }
  
  public String c()
  {
    if (!TextUtils.isEmpty(this.j)) {
      try
      {
        String str = new JSONObject(this.j).optString("hb_from");
        return str;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PasswdRedBagInfo extStr:");
        localStringBuilder.append(this.j);
        QLog.e(localStringBuilder.toString(), 1, QLog.getStackTraceString(localThrowable));
      }
    }
    return "";
  }
  
  public List<Integer> d()
  {
    for (;;)
    {
      try
      {
        localLinkedList = new LinkedList();
      }
      finally
      {
        LinkedList localLinkedList;
        Object localObject1;
        continue;
        throw localObject2;
        continue;
        Object localObject3 = null;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[getWordLenSet] ");
          ((StringBuilder)localObject1).append(this.j);
          QLog.i("passwdredinfo", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = new JSONObject(this.j).optString("key_poem_rule");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JSONArray((String)localObject1);
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            int k = 0;
            int m = ((JSONArray)localObject1).length();
            if (k < m)
            {
              try
              {
                m = ((JSONArray)localObject1).optInt(k);
                if (m > 1) {
                  localLinkedList.add(Integer.valueOf(m));
                }
              }
              catch (Throwable localThrowable2)
              {
                QLog.e("passwdredinfo", 1, localThrowable2, new Object[0]);
              }
              k += 1;
              continue;
            }
          }
          localObject2 = finally;
        }
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("passwdredinfo", 1, QLog.getStackTraceString(localThrowable1));
        if (localLinkedList.size() <= 0) {
          localLinkedList.add(Integer.valueOf(0));
        }
        return localLinkedList;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PasswdRedBagInfo))
    {
      paramObject = (PasswdRedBagInfo)paramObject;
      if (TextUtils.isEmpty(this.a)) {
        return false;
      }
      if (this.a.equals(paramObject.a)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo
 * JD-Core Version:    0.7.0.1
 */