package com.tencent.open.appcommon;

import android.text.TextUtils;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import java.io.File;

final class Common$1
  implements Runnable
{
  public void run()
  {
    File localFile1 = new File(Common.c());
    if (localFile1.exists())
    {
      File[] arrayOfFile = localFile1.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile2 = arrayOfFile[i];
        if ((localFile2.getName().startsWith("system_old_")) || ((localFile2.isDirectory()) && (!localFile2.getName().equals("tmp")) && (!TextUtils.isEmpty(Common.w())) && (!localFile2.getName().equals(Common.w()))))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localFile1);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(localFile2.getName());
          if (FileUtils.a(new File(localStringBuilder.toString())))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("<initSystemFolder> delete temp file<");
            localStringBuilder.append(localFile2.getName());
            localStringBuilder.append("> successful");
            LogUtility.b("Common", localStringBuilder.toString());
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("<initSystemFolder> delete temp file<");
            localStringBuilder.append(localFile2.getName());
            localStringBuilder.append("> failed");
            LogUtility.c("Common", localStringBuilder.toString());
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.Common.1
 * JD-Core Version:    0.7.0.1
 */