package com.tencent.mobileqq.winkpublish.util;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
  public static int a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getSecondsFromDate] expireDate=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("[upload2]DateUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.trim().equals(" ")) {
        return 0;
      }
      try
      {
        if (paramString.matches("^[0-9]*$"))
        {
          if (paramString.length() >= 10) {
            return Integer.valueOf(paramString.substring(0, 10)).intValue();
          }
        }
        else
        {
          localObject = Calendar.getInstance();
          ((Calendar)localObject).set(Integer.parseInt(paramString.substring(0, 4)), Integer.parseInt(paramString.substring(5, 7)) - 1, Integer.parseInt(paramString.substring(8, 10)), Integer.parseInt(paramString.substring(11, 13)), Integer.parseInt(paramString.substring(14, 16)), Integer.parseInt(paramString.substring(17, 19)));
          long l = ((Calendar)localObject).getTime().getTime() / 1000L;
          return (int)l;
        }
      }
      catch (Exception localException)
      {
        ErrorInfo localErrorInfo1 = ErrorInfo.a("[upload2]DateUtil");
        ErrorInfo localErrorInfo2 = localErrorInfo1.a("[getSecondsFromDate] Exception", new Object[0]);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DateTime of exif is invalid:");
        localStringBuilder.append(paramString);
        localErrorInfo2.b(localStringBuilder.toString()).c("check if exif of the picture is correct");
        paramString = new StringBuilder();
        paramString.append(localErrorInfo1.b);
        paramString.append(localException.getMessage());
        QLog.e("[upload2]DateUtil", 1, paramString.toString());
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.DateUtil
 * JD-Core Version:    0.7.0.1
 */