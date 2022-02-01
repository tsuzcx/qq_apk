package com.tencent.qqperf.monitor.file;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExternalDirOperationConfig
{
  public static Boolean a;
  public static String a;
  public List<String> a;
  boolean a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public ExternalDirOperationConfig()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static ExternalDirOperationConfig a()
  {
    return new ExternalDirOperationConfig();
  }
  
  public static ExternalDirOperationConfig a(String paramString)
  {
    try
    {
      Object localObject = new ExternalDirOperationConfig();
      paramString = new JSONObject(paramString);
      ((ExternalDirOperationConfig)localObject).jdField_a_of_type_Boolean = paramString.optBoolean("switch", false);
      JSONArray localJSONArray = paramString.optJSONArray("exclude_path");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = (String)localObject;
        if (i >= j) {
          break;
        }
        paramString = (String)localJSONArray.get(i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(jdField_a_of_type_JavaLangString);
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        ((ExternalDirOperationConfig)localObject).jdField_a_of_type_JavaUtilList.add(paramString);
        i += 1;
      }
      return localObject;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ExternalDirOperationConfigProcessor", 2, paramString, new Object[0]);
      }
      paramString = null;
      localObject = paramString;
      if (paramString == null) {
        localObject = a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExternalDirOperationConfigProcessor", 2, new Object[] { localObject });
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("dt_sdk_start", 4).edit().putBoolean("sp_key_hook_switch", paramBoolean).apply();
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_JavaLangBoolean == null) {
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramContext.getSharedPreferences("dt_sdk_start", 4).getBoolean("sp_key_hook_switch", false));
      }
      boolean bool = jdField_a_of_type_JavaLangBoolean.booleanValue();
      return bool;
    }
    finally {}
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ExternalDirOperationConfig={");
    localStringBuilder.append(" hookSwitch:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" excludePaths:");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      localStringBuilder.append(" ");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.file.ExternalDirOperationConfig
 * JD-Core Version:    0.7.0.1
 */