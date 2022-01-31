package org.tensorflow.lite;

import java.io.PrintStream;

public final class TensorFlowLite
{
  private static final String LIBNAME = "tensorflowlite_jni";
  
  static
  {
    init();
  }
  
  static boolean init()
  {
    try
    {
      System.loadLibrary("tensorflowlite_jni");
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      System.err.println("TensorFlowLite: failed to load native library: " + localUnsatisfiedLinkError.getMessage());
    }
    return false;
  }
  
  public static native String version();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     org.tensorflow.lite.TensorFlowLite
 * JD-Core Version:    0.7.0.1
 */