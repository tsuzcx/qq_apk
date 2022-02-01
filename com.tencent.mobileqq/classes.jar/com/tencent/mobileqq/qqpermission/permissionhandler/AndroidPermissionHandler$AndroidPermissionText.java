package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.content.Context;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;

class AndroidPermissionHandler$AndroidPermissionText
{
  private static final int jdField_a_of_type_Int = 2131699108;
  private static final ArrayMap<String, Integer> jdField_a_of_type_AndroidxCollectionArrayMap;
  private static final int jdField_b_of_type_Int = 2131699107;
  private static final ArrayMap<String, Integer> jdField_b_of_type_AndroidxCollectionArrayMap = new ArrayMap();
  
  static
  {
    jdField_a_of_type_AndroidxCollectionArrayMap = new ArrayMap();
    ArrayMap localArrayMap = jdField_a_of_type_AndroidxCollectionArrayMap;
    Integer localInteger1 = Integer.valueOf(2131699113);
    localArrayMap.put("android.permission.ACCESS_FINE_LOCATION", localInteger1);
    localArrayMap = jdField_b_of_type_AndroidxCollectionArrayMap;
    Integer localInteger2 = Integer.valueOf(2131699112);
    localArrayMap.put("android.permission.ACCESS_FINE_LOCATION", localInteger2);
    jdField_a_of_type_AndroidxCollectionArrayMap.put("android.permission.ACCESS_COARSE_LOCATION", localInteger1);
    jdField_b_of_type_AndroidxCollectionArrayMap.put("android.permission.ACCESS_COARSE_LOCATION", localInteger2);
    localArrayMap = jdField_a_of_type_AndroidxCollectionArrayMap;
    localInteger1 = Integer.valueOf(2131699105);
    localArrayMap.put("android.permission.READ_CONTACTS", localInteger1);
    localArrayMap = jdField_b_of_type_AndroidxCollectionArrayMap;
    localInteger2 = Integer.valueOf(2131699104);
    localArrayMap.put("android.permission.READ_CONTACTS", localInteger2);
    jdField_a_of_type_AndroidxCollectionArrayMap.put("android.permission.WRITE_CONTACTS", localInteger1);
    jdField_b_of_type_AndroidxCollectionArrayMap.put("android.permission.WRITE_CONTACTS", localInteger2);
    localArrayMap = jdField_a_of_type_AndroidxCollectionArrayMap;
    localInteger1 = Integer.valueOf(2131699121);
    localArrayMap.put("android.permission.READ_EXTERNAL_STORAGE", localInteger1);
    localArrayMap = jdField_b_of_type_AndroidxCollectionArrayMap;
    localInteger2 = Integer.valueOf(2131699120);
    localArrayMap.put("android.permission.READ_EXTERNAL_STORAGE", localInteger2);
    jdField_a_of_type_AndroidxCollectionArrayMap.put("android.permission.WRITE_EXTERNAL_STORAGE", localInteger1);
    jdField_b_of_type_AndroidxCollectionArrayMap.put("android.permission.WRITE_EXTERNAL_STORAGE", localInteger2);
    jdField_a_of_type_AndroidxCollectionArrayMap.put("android.permission.CAMERA", Integer.valueOf(2131699103));
    jdField_b_of_type_AndroidxCollectionArrayMap.put("android.permission.CAMERA", Integer.valueOf(2131699102));
    jdField_a_of_type_AndroidxCollectionArrayMap.put("android.permission.RECORD_AUDIO", Integer.valueOf(2131699119));
    jdField_b_of_type_AndroidxCollectionArrayMap.put("android.permission.RECORD_AUDIO", Integer.valueOf(2131699118));
    jdField_a_of_type_AndroidxCollectionArrayMap.put("android.permission.READ_SMS", Integer.valueOf(2131699117));
    jdField_b_of_type_AndroidxCollectionArrayMap.put("android.permission.READ_SMS", Integer.valueOf(2131699116));
    jdField_a_of_type_AndroidxCollectionArrayMap.put("qq.permission.notification", Integer.valueOf(2131699115));
    jdField_b_of_type_AndroidxCollectionArrayMap.put("qq.permission.notification", Integer.valueOf(2131699114));
  }
  
  private static String a(Context paramContext, String paramString)
  {
    paramString = (Integer)jdField_a_of_type_AndroidxCollectionArrayMap.get(paramString);
    int i;
    if (paramString == null) {
      i = jdField_a_of_type_Int;
    } else {
      i = paramString.intValue();
    }
    return paramContext.getString(i);
  }
  
  public static String a(Context paramContext, List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      String str1 = paramContext.getString(2131699124);
      String str2 = paramContext.getString(2131699123);
      String str3 = paramContext.getString(2131699122);
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
    paramString = (Integer)jdField_b_of_type_AndroidxCollectionArrayMap.get(paramString);
    int i;
    if (paramString == null) {
      i = jdField_b_of_type_Int;
    } else {
      i = paramString.intValue();
    }
    return paramContext.getString(i);
  }
  
  public static String b(Context paramContext, List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      String str1 = paramContext.getString(2131699106);
      String str2 = paramContext.getString(2131699123);
      String str3 = paramContext.getString(2131699122);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.AndroidPermissionText
 * JD-Core Version:    0.7.0.1
 */