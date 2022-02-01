package org.libpag;

import org.extra.tools.LibraryLoadUtils;

public class PAG
{
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
  }
  
  public static native String SDKVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.PAG
 * JD-Core Version:    0.7.0.1
 */