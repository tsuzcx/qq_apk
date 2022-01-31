package com.tencent.mobileqq.filemanager.settings;

import aptm;
import java.io.File;

public class FMSettings$1
  implements Runnable
{
  public FMSettings$1(aptm paramaptm, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(this.a);
      if (!((File)localObject).exists()) {
        return;
      }
      if (((File)localObject).isDirectory())
      {
        localObject = ((File)localObject).listFiles();
        if ((localObject != null) && (localObject.length != 0))
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localObject[i].delete();
            i += 1;
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.1
 * JD-Core Version:    0.7.0.1
 */