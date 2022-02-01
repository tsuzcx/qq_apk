package com.tencent.rmonitor.fd.hook;

import com.tencent.rmonitor.common.util.FileUtil;

public class FdOpenStackManager
{
  protected static boolean a = FileUtil.e("rmonitor_fd_stack");
  private static final String[] b = { ".*/librmonitor_fd_stack.so$", ".*/libBugly-rqd.so$" };
  private static final String[] c = { ".*\\.so$" };
  
  public static boolean a()
  {
    boolean bool = a;
    int j = 0;
    if (bool)
    {
      String[] arrayOfString = c;
      int k = arrayOfString.length;
      int i = 0;
      while (i < k)
      {
        nSetRegisterHookSo(arrayOfString[i]);
        i += 1;
      }
      arrayOfString = b;
      k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        nSetIgnoreHookSo(arrayOfString[i]);
        i += 1;
      }
      nEnableFdOpenHook();
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return nDumpFdOpenStacks(paramString);
  }
  
  public static void b() {}
  
  private static native void nDisableFdOpenHook();
  
  private static native boolean nDumpFdOpenStacks(String paramString);
  
  private static native void nEnableFdOpenHook();
  
  private static native void nSetIgnoreHookSo(String paramString);
  
  private static native void nSetRegisterHookSo(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.hook.FdOpenStackManager
 * JD-Core Version:    0.7.0.1
 */