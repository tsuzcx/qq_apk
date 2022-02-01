package org.libpag;

import org.extra.tools.LibraryLoadUtils;

public class PAGMovie
  extends PAGImage
{
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
  }
  
  private PAGMovie(long paramLong)
  {
    super(paramLong);
  }
  
  public static PAGMovie FromComposition(PAGComposition paramPAGComposition)
  {
    long l = MakeFromComposition(paramPAGComposition);
    if (l == 0L) {
      return null;
    }
    return new PAGMovie(l);
  }
  
  public static PAGMovie FromVideoPath(String paramString)
  {
    long l = MakeFromVideoPath(paramString);
    if (l == 0L) {
      return null;
    }
    return new PAGMovie(l);
  }
  
  public static PAGMovie FromVideoPath(String paramString, long paramLong1, long paramLong2)
  {
    paramLong1 = MakeFromVideoPath(paramString, paramLong1, paramLong2);
    if (paramLong1 == 0L) {
      return null;
    }
    return new PAGMovie(paramLong1);
  }
  
  private static native long MakeFromComposition(PAGComposition paramPAGComposition);
  
  private static native long MakeFromVideoPath(String paramString);
  
  private static native long MakeFromVideoPath(String paramString, long paramLong1, long paramLong2);
  
  private static native void nativeInit();
  
  public native long duration();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.libpag.PAGMovie
 * JD-Core Version:    0.7.0.1
 */