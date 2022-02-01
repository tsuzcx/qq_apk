package com.tencent.mobileqq.startup.step;

import java.io.File;
import java.io.FileFilter;
import mqq.app.SecurityFileFrameworkManagerImpl;

class UpdateSecureFileStrategy$1
  implements FileFilter
{
  UpdateSecureFileStrategy$1(UpdateSecureFileStrategy paramUpdateSecureFileStrategy) {}
  
  public boolean accept(File paramFile)
  {
    boolean bool3 = paramFile.isDirectory();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramFile.getName().startsWith("NoRename#"))
      {
        paramFile = paramFile.getName().replaceAll("NoRename#", "");
        bool1 = bool2;
        if (paramFile.length() == 9)
        {
          bool1 = bool2;
          if (paramFile.charAt(0) == SecurityFileFrameworkManagerImpl.generateVerifyChar(paramFile.substring(1))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateSecureFileStrategy.1
 * JD-Core Version:    0.7.0.1
 */