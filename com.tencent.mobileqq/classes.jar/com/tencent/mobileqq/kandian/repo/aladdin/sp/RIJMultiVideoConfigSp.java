package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;

public class RIJMultiVideoConfigSp
{
  public static boolean a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isVideoFromTypeHint: config=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", videoFromType=");
        localStringBuilder.append(paramInt);
        QLog.d("RIJMultiVideoConfigSp", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString2.split(paramString1);
        int j = paramString1.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = TextUtils.equals(String.valueOf(paramInt), paramString1[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramString1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append("isVideoFromTypeHint: ");
      QLog.e("RIJMultiVideoConfigSp", 2, localStringBuilder.toString(), paramString1);
    }
  }
  
  public static boolean b(int paramInt, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return a(paramInt, paramString1, (String)RIJSPUtils.b(paramString2, ""));
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("invalid spilt or configKey");
      QLog.d("RIJMultiVideoConfigSp", 2, paramString1.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJMultiVideoConfigSp
 * JD-Core Version:    0.7.0.1
 */