package com.tencent.mobileqq.qwallet.utils.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class PayInterceptApiImpl$InterceptConfig
{
  public String a;
  public Pattern a;
  public boolean a;
  public String b;
  public Pattern b;
  public boolean b;
  public String c;
  public String d;
  
  public static List<InterceptConfig> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          if (localJSONObject != null)
          {
            InterceptConfig localInterceptConfig = new InterceptConfig();
            localInterceptConfig.jdField_a_of_type_JavaLangString = localJSONObject.optString("sourceURLRegular");
            localInterceptConfig.jdField_b_of_type_JavaLangString = localJSONObject.optString("interceptURLRegular");
            int j = localJSONObject.optInt("shouldReport");
            boolean bool2 = true;
            if (j == 1)
            {
              bool1 = true;
              localInterceptConfig.jdField_a_of_type_Boolean = bool1;
              if (localJSONObject.optInt("shouldIntercept") != 1) {
                break label165;
              }
              bool1 = bool2;
              localInterceptConfig.jdField_b_of_type_Boolean = bool1;
              localInterceptConfig.c = localJSONObject.optString("jumpURL");
              localArrayList.add(localInterceptConfig);
            }
          }
          else
          {
            i += 1;
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      boolean bool1 = false;
      continue;
      label165:
      bool1 = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InterceptConfig [mSrcUrlRegular=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mInterceptUrlRegular=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mIsReport=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mIsIntercept=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", mJumpUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.impl.PayInterceptApiImpl.InterceptConfig
 * JD-Core Version:    0.7.0.1
 */