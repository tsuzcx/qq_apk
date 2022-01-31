package com.tencent.open.appcommon;

import android.text.TextUtils;
import bcax;
import bcdp;
import bcds;
import java.io.File;

public final class Common$1
  implements Runnable
{
  public void run()
  {
    File localFile1 = new File(bcax.c());
    if (localFile1.exists())
    {
      File[] arrayOfFile = localFile1.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile2 = arrayOfFile[i];
        if ((localFile2.getName().startsWith("system_old_")) || ((localFile2.isDirectory()) && (!localFile2.getName().equals("tmp")) && (!TextUtils.isEmpty(bcax.p())) && (!localFile2.getName().equals(bcax.p()))))
        {
          if (!bcdp.a(new File(localFile1 + File.separator + localFile2.getName()))) {
            break label179;
          }
          bcds.b("Common", "<initSystemFolder> delete temp file<" + localFile2.getName() + "> successful");
        }
        for (;;)
        {
          i += 1;
          break;
          label179:
          bcds.c("Common", "<initSystemFolder> delete temp file<" + localFile2.getName() + "> failed");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.Common.1
 * JD-Core Version:    0.7.0.1
 */