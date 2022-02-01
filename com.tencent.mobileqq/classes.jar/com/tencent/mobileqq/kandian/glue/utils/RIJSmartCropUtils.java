package com.tencent.mobileqq.kandian.glue.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.qphone.base.util.QLog;

public class RIJSmartCropUtils
{
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (!ReadInJoyHelper.b(RIJQQAppInterfaceUtil.e()))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("smart crop switch is false ! url : ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("RIJSmartCropUtils", 2, ((StringBuilder)localObject1).toString());
      }
      return paramString;
    }
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (!paramString.startsWith("http://qqpublic.qpic.cn")) {
      return paramString;
    }
    Object localObject2 = paramString.split("/");
    if (localObject2.length < 2) {
      return paramString;
    }
    Object localObject1 = localObject2[(localObject2.length - 2)].split("_");
    if (localObject1.length < 1) {
      return paramString;
    }
    Object localObject3 = localObject1[(localObject1.length - 1)];
    if ("open".equals(localObject3))
    {
      localObject1 = ReadInJoyConstants.a(paramString, 0);
    }
    else
    {
      localObject1 = paramString;
      if (!"vsmcut".equals(localObject3)) {
        return localObject1;
      }
      localObject1 = ReadInJoyConstants.a(paramString, 1);
    }
    localObject1 = RIJPreParseData.a((Pair[])localObject1, paramInt1, paramInt2);
    if (localObject1 == null) {
      return paramString;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("the picture size : w : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" h : ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", select scale : ");
      localStringBuilder.append(((Pair)localObject1).first);
      localStringBuilder.append(":");
      localStringBuilder.append(((Pair)localObject1).second);
      QLog.d("RIJSmartCropUtils", 2, localStringBuilder.toString());
    }
    localObject2 = localObject2[(localObject2.length - 1)];
    localObject1 = paramString.replace(String.format("_%s/%s", new Object[] { localObject3, localObject2 }), String.format("_%s_%d_%d/%s", new Object[] { localObject3, ((Pair)localObject1).first, ((Pair)localObject1).second, localObject2 }));
    return localObject1;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (paramString.startsWith("http://qqpublic.qpic.cn"))
      {
        paramString = paramString.split("/");
        bool1 = bool2;
        if (paramString.length >= 2)
        {
          paramString = paramString[(paramString.length - 2)].split("_");
          bool1 = bool2;
          if (paramString.length >= 1)
          {
            paramString = paramString[(paramString.length - 1)];
            if (!TextUtils.equals("open", paramString))
            {
              bool1 = bool2;
              if (!TextUtils.equals("vsmcut", paramString)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils
 * JD-Core Version:    0.7.0.1
 */