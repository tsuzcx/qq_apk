package com.tencent.open.appcommon;

import android.text.TextUtils;
import bjrc;
import bjtu;
import bjtx;
import java.io.File;

public final class Common$1
  implements Runnable
{
  public void run()
  {
    File localFile1 = new File(bjrc.c());
    if (localFile1.exists())
    {
      File[] arrayOfFile = localFile1.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile2 = arrayOfFile[i];
        if ((localFile2.getName().startsWith("system_old_")) || ((localFile2.isDirectory()) && (!localFile2.getName().equals("tmp")) && (!TextUtils.isEmpty(bjrc.q())) && (!localFile2.getName().equals(bjrc.q()))))
        {
          if (!bjtu.a(new File(localFile1 + File.separator + localFile2.getName()))) {
            break label179;
          }
          bjtx.b("Common", "<initSystemFolder> delete temp file<" + localFile2.getName() + "> successful");
        }
        for (;;)
        {
          i += 1;
          break;
          label179:
          bjtx.c("Common", "<initSystemFolder> delete temp file<" + localFile2.getName() + "> failed");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.Common.1
 * JD-Core Version:    0.7.0.1
 */