package com.tencent.mobileqq.qwallet.utils.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class PayInterceptApiImpl$InterceptConfig
{
  public String a;
  public String b;
  public boolean c;
  public boolean d;
  public String e;
  public Pattern f;
  public Pattern g;
  public String h;
  
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
            localInterceptConfig.a = localJSONObject.optString("sourceURLRegular");
            localInterceptConfig.b = localJSONObject.optString("interceptURLRegular");
            int j = localJSONObject.optInt("shouldReport");
            boolean bool2 = true;
            if (j == 1)
            {
              bool1 = true;
              localInterceptConfig.c = bool1;
              if (localJSONObject.optInt("shouldIntercept") != 1) {
                break label165;
              }
              bool1 = bool2;
              localInterceptConfig.d = bool1;
              localInterceptConfig.e = localJSONObject.optString("jumpURL");
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
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mInterceptUrlRegular=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mIsReport=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mIsIntercept=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mJumpUrl=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.impl.PayInterceptApiImpl.InterceptConfig
 * JD-Core Version:    0.7.0.1
 */