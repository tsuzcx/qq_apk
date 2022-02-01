package com.tencent.mobileqq.filemanager.settings;

import java.io.File;

class QQFMSettings$1
  implements Runnable
{
  QQFMSettings$1(QQFMSettings paramQQFMSettings, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(this.a);
      if (!((File)localObject).exists()) {
        return;
      }
      if (!((File)localObject).isDirectory()) {
        return;
      }
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        if (localObject.length == 0) {
          return;
        }
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].delete();
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings.1
 * JD-Core Version:    0.7.0.1
 */