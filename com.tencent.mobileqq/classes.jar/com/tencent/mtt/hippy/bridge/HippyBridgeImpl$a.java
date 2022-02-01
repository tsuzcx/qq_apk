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
    paramFile = new File(paramFile, paramString);
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.list();
      if ((paramFile != null) && (paramFile.length > 0)) {
        return paramFile[0].equals(this.a);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.HippyBridgeImpl.a
 * JD-Core Version:    0.7.0.1
 */