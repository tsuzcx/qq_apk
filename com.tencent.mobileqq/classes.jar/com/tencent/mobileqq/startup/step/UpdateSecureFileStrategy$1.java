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
    if ((paramFile.isDirectory()) && (paramFile.getName().startsWith("NoRename#")))
    {
      paramFile = paramFile.getName().replaceAll("NoRename#", "");
      return (paramFile.length() == 9) && (paramFile.charAt(0) == SecurityFileFrameworkManagerImpl.generateVerifyChar(paramFile.substring(1)));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateSecureFileStrategy.1
 * JD-Core Version:    0.7.0.1
 */