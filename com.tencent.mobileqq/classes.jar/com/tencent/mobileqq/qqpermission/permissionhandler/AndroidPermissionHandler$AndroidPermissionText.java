package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.content.Context;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;

class AndroidPermissionHandler$AndroidPermissionText
{
  private static final ArrayMap<String, Integer> a;
  private static final ArrayMap<String, Integer> b = new ArrayMap();
  private static final int c = 2131897124;
  private static final int d = 2131897123;
  
  static
  {
    a = new ArrayMap();
    ArrayMap localArrayMap = a;
    Integer localInteger1 = Integer.valueOf(2131897129);
    localArrayMap.put("android.permission.ACCESS_FINE_LOCATION", localInteger1);
    localArrayMap = b;
    Integer localInteger2 = Integer.valueOf(2131897128);
    localArrayMap.put("android.permission.ACCESS_FINE_LOCATION", localInteger2);
    a.put("android.permission.ACCESS_COARSE_LOCATION", localInteger1);
    b.put("android.permission.ACCESS_COARSE_LOCATION", localInteger2);
    localArrayMap = a;
    localInteger1 = Integer.valueOf(2131897121);
    localArrayMap.put("android.permission.READ_CONTACTS", localInteger1);
    localArrayMap = b;
    localInteger2 = Integer.valueOf(2131897120);
    localArrayMap.put("android.permission.READ_CONTACTS", localInteger2);
    a.put("android.permission.WRITE_CONTACTS", localInteger1);
    b.put("android.permission.WRITE_CONTACTS", localInteger2);
    localArrayMap = a;
    localInteger1 = Integer.valueOf(2131897137);
    localArrayMap.put("android.permission.READ_EXTERNAL_STORAGE", localInteger1);
    localArrayMap = b;
    localInteger2 = Integer.valueOf(2131897136);
    localArrayMap.put("android.permission.READ_EXTERNAL_STORAGE", localInteger2);
    a.put("android.permission.WRITE_EXTERNAL_STORAGE", localInteger1);
    b.put("android.permission.WRITE_EXTERNAL_STORAGE", localInteger2);
    a.put("android.permission.CAMERA", Integer.valueOf(2131897119));
    b.put("android.permission.CAMERA", Integer.valueOf(2131897118));
    a.put("android.permission.RECORD_AUDIO", Integer.valueOf(2131897135));
    b.put("android.permission.RECORD_AUDIO", Integer.valueOf(2131897134));
    a.put("android.permission.READ_SMS", Integer.valueOf(2131897133));
    b.put("android.permission.READ_SMS", Integer.valueOf(2131897132));
    a.put("qq.permission.notification", Integer.valueOf(2131897131));
    b.put("qq.permission.notification", Integer.valueOf(2131897130));
  }
  
  private static String a(Context paramContext, String paramString)
  {
    paramString = (Integer)a.get(paramString);
    int i;
    if (paramString == null) {
      i = c;
    } else {
      i = paramString.intValue();
    }
    return paramContext.getString(i);
  }
  
  public static String a(Context paramContext, List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      String str1 = paramContext.getString(2131897140);
      String str2 = paramContext.getString(2131897139);
      String str3 = paramContext.getString(2131897138);
      StringBuilder localStringBuilder = new StringBuilder();
      paramList = a(paramList);
      int i = 0;
      while (i < paramList.size())
      {
        String str4 = a(paramContext, (String)paramList.get(i));
        if (i == 0)
        {
          localStringBuilder.append(str4);
        }
        else if (i < paramList.size() - 1)
        {
          localStringBuilder.append(str2);
          localStringBuilder.append(str4);
        }
        else
        {
          localStringBuilder.append(str3);
          localStringBuilder.append(str4);
        }
        i += 1;
      }
      return String.format(str1, new Object[] { localStringBuilder.toString() });
    }
    return "";
  }
  
  private static List<String> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    if ((paramList.contains("android.permission.ACCESS_COARSE_LOCATION")) && (paramList.contains("android.permission.ACCESS_FINE_LOCATION"))) {
      localArrayList.remove("android.permission.ACCESS_FINE_LOCATION");
    }
    if ((paramList.contains("android.permission.READ_EXTERNAL_STORAGE")) && (paramList.contains("android.permission.WRITE_EXTERNAL_STORAGE"))) {
      localArrayList.remove("android.permission.WRITE_EXTERNAL_STORAGE");
    }
    return localArrayList;
  }
  
  private static String b(Context paramContext, String paramString)
  {
    paramString = (Integer)b.get(paramString);
    int i;
    if (paramString == null) {
      i = d;
    } else {
      i = paramString.intValue();
    }
    return paramContext.getString(i);
  }
  
  public static String b(Context paramContext, List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      String str1 = paramContext.getString(2131897122);
      String str2 = paramContext.getString(2131897139);
      String str3 = paramContext.getString(2131897138);
      StringBuilder localStringBuilder = new StringBuilder();
      paramList = a(paramList);
      int i = 0;
      while (i < paramList.size())
      {
        String str4 = b(paramContext, (String)paramList.get(i));
        if (i == 0)
        {
          localStringBuilder.append(str4);
        }
        else if (i < paramList.size() - 1)
        {
          localStringBuilder.append(str2);
          localStringBuilder.append(str4);
        }
        else
        {
          localStringBuilder.append(str3);
          localStringBuilder.append(str4);
        }
        i += 1;
      }
      return String.format(str1, new Object[] { localStringBuilder.toString() });
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.AndroidPermissionText
 * JD-Core Version:    0.7.0.1
 */