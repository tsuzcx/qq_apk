package com.tencent.mobileqq.kandian.base.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class ReadInJoySkinUtils
{
  public static boolean a(File paramFile)
  {
    if (paramFile.exists())
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramFile.getAbsolutePath());
      localStringBuffer.append(File.separator);
      localStringBuffer.append("check.ini");
      Object localObject = new File(localStringBuffer.toString());
      if (!((File)localObject).exists()) {
        return false;
      }
      for (;;)
      {
        try
        {
          localObject = FileUtils.readFileToString((File)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return false;
          }
          arrayOfString = ((String)localObject).split("&");
          if (arrayOfString != null) {
            continue;
          }
          return false;
        }
        catch (IOException paramFile)
        {
          String[] arrayOfString;
          continue;
          int i = 0;
          continue;
        }
        if (i >= arrayOfString.length) {
          continue;
        }
        if (arrayOfString[i].startsWith("﻿")) {
          arrayOfString[i] = arrayOfString[i].replace("﻿", "");
        }
        localStringBuffer.setLength(0);
        localStringBuffer.append(paramFile.getAbsolutePath());
        localStringBuffer.append(File.separator);
        localStringBuffer.append(arrayOfString[i]);
        localObject = new File(localStringBuffer.toString());
        if (!((File)localObject).exists())
        {
          if (QLog.isColorLevel())
          {
            paramFile = new StringBuilder();
            paramFile.append("isAnimationPackageValid File not exist:");
            paramFile.append(((File)localObject).getName());
            QLog.e("ReadInJoySkinUtils", 2, paramFile.toString());
          }
          return false;
        }
        i += 1;
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoySkinUtils", 2, "isAnimationPackageValid IOException");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.ReadInJoySkinUtils
 * JD-Core Version:    0.7.0.1
 */