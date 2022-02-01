package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashSet;
import java.util.Set;

public class SharedPreferencesHandler
{
  public static SharedPreferences.Editor a(SharedPreferences.Editor paramEditor, String paramString, Set<String> paramSet)
  {
    return a(paramEditor, paramString, paramSet.toArray());
  }
  
  public static SharedPreferences.Editor a(SharedPreferences.Editor paramEditor, String paramString, Object[] paramArrayOfObject)
  {
    String str = "";
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfObject[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(localObject.toString());
        str = localStringBuilder.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" ");
        str = ((StringBuilder)localObject).toString();
        i += 1;
      }
      paramEditor.putString(paramString, str);
      return paramEditor;
    }
    paramEditor.putString(paramString, "");
    return paramEditor;
  }
  
  public static Set<String> a(SharedPreferences paramSharedPreferences, String paramString, Set<String> paramSet)
  {
    paramSharedPreferences = paramSharedPreferences.getString(paramString, "");
    if ((paramSharedPreferences != null) && (paramSharedPreferences.length() > 0))
    {
      paramSharedPreferences = paramSharedPreferences.split(" ");
      paramString = new HashSet();
      int j = paramSharedPreferences.length;
      int i = 0;
      while (i < j)
      {
        paramSet = paramSharedPreferences[i];
        if ((paramSet != null) && (paramSet.length() > 0)) {
          paramString.add(paramSet);
        }
        i += 1;
      }
      return paramString;
    }
    return paramSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SharedPreferencesHandler
 * JD-Core Version:    0.7.0.1
 */