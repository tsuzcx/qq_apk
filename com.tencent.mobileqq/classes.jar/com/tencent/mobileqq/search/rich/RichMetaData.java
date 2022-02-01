package com.tencent.mobileqq.search.rich;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RichMetaData
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  
  public static String a(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("entry", paramInt);
        int i = 1;
        if (paramBoolean1)
        {
          paramInt = 1;
          ((JSONObject)localObject).put("match", paramInt);
          ((JSONObject)localObject).put("keyword", paramString);
          if (!paramBoolean2) {
            break label118;
          }
          paramInt = i;
          ((JSONObject)localObject).put("nightmode", paramInt);
          paramString = ((JSONObject)localObject).toString();
          return paramString;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setLayout101ExtraData exception:");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("RichMetaData", 2, ((StringBuilder)localObject).toString());
        return null;
      }
      paramInt = 0;
      continue;
      label118:
      paramInt = 0;
    }
  }
  
  public String a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("serverdata", new JSONObject(this.jdField_a_of_type_JavaLangString));
      localJSONObject2.put("state", this.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(this.b)) {
        localJSONObject2.put("extradata", new JSONObject(this.b));
      }
      localJSONObject1.put("data", localJSONObject2);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("convertMetaData exception : ");
      localStringBuilder.append(localJSONException);
      QLog.e("RichMetaData", 2, localStringBuilder.toString());
    }
    return localJSONObject1.toString();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Int = 1;
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.RichMetaData
 * JD-Core Version:    0.7.0.1
 */