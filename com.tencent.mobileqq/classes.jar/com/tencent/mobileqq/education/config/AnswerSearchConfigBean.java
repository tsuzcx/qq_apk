package com.tencent.mobileqq.education.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class AnswerSearchConfigBean
  implements IQStorageSafable<String>
{
  public boolean a = false;
  public String b = "{}";
  
  public void a(String paramString)
  {
    QLog.e("ProblemSearchConfigBean", 1, "onParse: start.");
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("ProblemSearchConfigBean", 1, "onParse: but configContent is null!");
    }
    this.b = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("scanSwitch")) {
        this.a = paramString.getBoolean("scanSwitch");
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("ProblemSearchConfigBean", 1, QLog.getStackTraceString(paramString));
    }
    QLog.e("ProblemSearchConfigBean", 1, "onParse: finish.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.config.AnswerSearchConfigBean
 * JD-Core Version:    0.7.0.1
 */