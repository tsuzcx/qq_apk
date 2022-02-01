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
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public PasswdRedBagInfo() {}
  
  public PasswdRedBagInfo(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.d = paramString4;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public PasswdRedBagInfo(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramLong, paramString4, paramBoolean1, paramBoolean2, paramInt);
    this.f = paramString5;
  }
  
  public PasswdRedBagInfo(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString5, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramLong, paramString4, paramBoolean1, paramBoolean2, paramInt);
    this.e = paramString5;
    this.f = paramString6;
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
    int i = 0;
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        localJSONArray.put(Integer.parseInt(paramString[i]));
        label53:
        i += 1;
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
  
  public int a()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getWordChainSubChannel] ");
        localStringBuilder.append(this.f);
        QLog.i("passwdredinfo", 2, localStringBuilder.toString());
      }
      int i = new JSONObject(this.f).optInt("key_sub_channel");
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("passwdredinfo", 1, QLog.getStackTraceString(localThrowable));
    }
    return -1;
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.f)) {
      try
      {
        String str = new JSONObject(this.f).optString("hb_from");
        return str;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PasswdRedBagInfo extStr:");
        localStringBuilder.append(this.f);
        QLog.e(localStringBuilder.toString(), 1, QLog.getStackTraceString(localThrowable));
      }
    }
    return "";
  }
  
  public List<Integer> a()
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
          ((StringBuilder)localObject1).append(this.f);
          QLog.i("passwdredinfo", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = new JSONObject(this.f).optString("key_poem_rule");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JSONArray((String)localObject1);
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            int i = 0;
            int j = ((JSONArray)localObject1).length();
            if (i < j)
            {
              try
              {
                j = ((JSONArray)localObject1).optInt(i);
                if (j > 1) {
                  localLinkedList.add(Integer.valueOf(j));
                }
              }
              catch (Throwable localThrowable2)
              {
                QLog.e("passwdredinfo", 1, localThrowable2, new Object[0]);
              }
              i += 1;
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
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long < NetConnInfoCenter.getServerTime();
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = true;
    try
    {
      List localList = a();
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
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PasswdRedBagInfo))
    {
      paramObject = (PasswdRedBagInfo)paramObject;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return false;
      }
      if (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo
 * JD-Core Version:    0.7.0.1
 */