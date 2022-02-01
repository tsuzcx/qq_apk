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
  public String b;
  public String c;
  public String d;
  public String e;
  public JSONObject f;
  
  public ClubContentJsonTask$TaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.c = paramString2;
    this.b = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }
  
  public JSONObject a(Context paramContext)
  {
    try
    {
      if (this.f != null)
      {
        paramContext = this.f;
        return paramContext;
      }
      if ((paramContext != null) && (!TextUtils.isEmpty(this.a)))
      {
        paramContext = new File(paramContext.getFilesDir(), this.a);
        if (paramContext.exists())
        {
          paramContext = FileUtils.readFileContent(paramContext);
          try
          {
            this.f = new JSONObject(paramContext);
          }
          catch (Exception paramContext)
          {
            this.f = null;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("readLocalJsonFile, exception=");
            localStringBuilder.append(MsfSdkUtils.getStackTraceString(paramContext));
            QLog.e("TaskInfo", 1, localStringBuilder.toString());
          }
        }
        paramContext = this.f;
        return paramContext;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readLocalJsonFile, context or json_name null, context=");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(", json_name=");
      localStringBuilder.append(this.a);
      QLog.e("TaskInfo", 1, localStringBuilder.toString());
      return null;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo
 * JD-Core Version:    0.7.0.1
 */