package com.tencent.mobileqq.vas;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class ClubContentJsonTask$TaskInfo
{
  public String a;
  public JSONObject a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public ClubContentJsonTask$TaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.b = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }
  
  public JSONObject a(Context paramContext)
  {
    try
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        paramContext = this.jdField_a_of_type_OrgJsonJSONObject;
        return paramContext;
      }
      if ((paramContext != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        paramContext = new File(paramContext.getFilesDir(), this.jdField_a_of_type_JavaLangString);
        if (paramContext.exists())
        {
          paramContext = FileUtils.readFileContent(paramContext);
          try
          {
            this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramContext);
          }
          catch (Exception paramContext)
          {
            this.jdField_a_of_type_OrgJsonJSONObject = null;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("readLocalJsonFile, exception=");
            localStringBuilder.append(MsfSdkUtils.getStackTraceString(paramContext));
            QLog.e("TaskInfo", 1, localStringBuilder.toString());
          }
        }
        paramContext = this.jdField_a_of_type_OrgJsonJSONObject;
        return paramContext;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readLocalJsonFile, context or json_name null, context=");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(", json_name=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.e("TaskInfo", 1, localStringBuilder.toString());
      return null;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo
 * JD-Core Version:    0.7.0.1
 */