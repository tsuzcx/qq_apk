package com.tencent.qphone.base.util.log.a;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.d.d;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.Calendar;

final class e
  extends Thread
{
  public void run()
  {
    Object localObject1 = new File(QLog.getLogPath());
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      Object localObject2;
      int i;
      int j;
      long l;
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        Arrays.sort((Object[])localObject1, new f(this));
        localObject2 = Calendar.getInstance();
        try
        {
          String str1 = a.h();
          if ((str1 != null) && (str1.length() > 0)) {
            i = Integer.parseInt(str1);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i = 3;
        }
        if (i >= 1)
        {
          j = i;
          if (i <= 14) {}
        }
        else
        {
          j = 3;
        }
        ((Calendar)localObject2).add(6, j - j * 2);
        l = ((Calendar)localObject2).getTimeInMillis();
        localObject2 = b.h();
        j = localObject1.length;
        i = 0;
      }
      while (i < j)
      {
        File localFile = localObject1[i];
        String str2;
        StringBuilder localStringBuilder;
        if ((l <= localFile.lastModified()) && (localFile.lastModified() <= System.currentTimeMillis() + 3600000L))
        {
          if ((!TextUtils.isEmpty(localFile.getName())) && (localFile.getName().endsWith(".log")) && ((localFile.lastModified() < System.currentTimeMillis() - 3600000L) || (localFile.getName().contains((CharSequence)localObject2)))) {
            if (b.a(localFile))
            {
              localFile.delete();
              str2 = b.f;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("compress log ");
              localStringBuilder.append(localFile.getName());
              QLog.d(str2, 1, localStringBuilder.toString());
            }
            else
            {
              str2 = b.f;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("compress log fail ");
              localStringBuilder.append(localFile.getName());
              QLog.d(str2, 1, localStringBuilder.toString());
            }
          }
        }
        else
        {
          localFile.delete();
          if (QLog.isColorLevel())
          {
            str2 = b.f;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("del expires log ");
            localStringBuilder.append(localFile.getName());
            QLog.d(str2, 2, localStringBuilder.toString());
          }
        }
        i += 1;
        continue;
        return;
      }
    }
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(6, ((Calendar)localObject1).get(6) - 7);
    ((Calendar)localObject1).set(11, 0);
    ((Calendar)localObject1).set(12, 0);
    ((Calendar)localObject1).set(13, 0);
    ((Calendar)localObject1).set(14, 0);
    d.b(((Calendar)localObject1).getTimeInMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.a.e
 * JD-Core Version:    0.7.0.1
 */