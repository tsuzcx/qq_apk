package com.tencent.mtt.hippy.bridge;

import java.io.File;
import java.io.FilenameFilter;

class HippyBridgeImpl$a
  implements FilenameFilter
{
  String a;
  
  public HippyBridgeImpl$a(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    boolean bool2 = false;
    paramFile = new File(paramFile, paramString);
    boolean bool1 = bool2;
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.list();
      bool1 = bool2;
      if (paramFile != null)
      {
        bool1 = bool2;
        if (paramFile.length > 0) {
          bool1 = paramFile[0].equals(this.a);
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.HippyBridgeImpl.a
 * JD-Core Version:    0.7.0.1
 */