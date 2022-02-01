package com.tencent.mobileqq.mqsafeedit;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CodecWarpper
{
  public static final String NATIVE_LIB_NAME = "codecwrapperV2";
  private static AtomicBoolean isSoLoaded = new AtomicBoolean(false);
  
  static
  {
    loadSo();
  }
  
  public static void loadSo()
  {
    if (!isSoLoaded.get()) {}
    try
    {
      if (CoreUtil.loadLibrary("codecwrapperV2", BaseApplication.getContext()))
      {
        isSoLoaded.set(true);
        return;
      }
      Object localObject = BaseApplication.getContext().getPackageName().replace(".", "_");
      AtomicBoolean localAtomicBoolean = isSoLoaded;
      localObject = new StringBuilder(String.valueOf(localObject));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("codecwrapperV2");
      localAtomicBoolean.set(CoreUtil.loadLibrary(((StringBuilder)localObject).toString(), BaseApplication.getContext()));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mqsafeedit.CodecWarpper
 * JD-Core Version:    0.7.0.1
 */