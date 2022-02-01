package com.tencent.qphone.base.util.log.a;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.c.d;
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
    Object localObject2;
    int j;
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 == null) || (localObject1.length == 0)) {
        return;
      }
      Arrays.sort((Object[])localObject1, new f(this));
      localObject2 = Calendar.getInstance();
      j = 3;
      try
      {
        str = a.h();
        i = j;
        if (str != null)
        {
          i = j;
          if (str.length() > 0) {
            i = Integer.parseInt(str);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str;
          long l;
          localException.printStackTrace();
          int i = j;
          continue;
          if ((!TextUtils.isEmpty(localException.getName())) && (localException.getName().endsWith(".log")) && ((localException.lastModified() < System.currentTimeMillis() - 3600000L) || (localException.getName().contains((CharSequence)localObject2)))) {
            if (b.a(localException))
            {
              localException.delete();
              QLog.d(b.f, 1, "compress log " + localException.getName());
            }
            else
            {
              QLog.d(b.f, 1, "compress log fail " + localException.getName());
            }
          }
        }
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
      for (;;)
      {
        if (i >= j) {
          break label362;
        }
        str = localObject1[i];
        if ((l <= str.lastModified()) && (str.lastModified() <= System.currentTimeMillis() + 3600000L)) {
          break;
        }
        str.delete();
        if (QLog.isColorLevel()) {
          QLog.d(b.f, 2, "del expires log " + str.getName());
        }
        i += 1;
      }
    }
    label362:
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(6, ((Calendar)localObject1).get(6) - 7);
    ((Calendar)localObject1).set(11, 0);
    ((Calendar)localObject1).set(12, 0);
    ((Calendar)localObject1).set(13, 0);
    ((Calendar)localObject1).set(14, 0);
    d.b(((Calendar)localObject1).getTimeInMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.a.e
 * JD-Core Version:    0.7.0.1
 */